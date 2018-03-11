package com.example.buitu.listviewpractive;

import android.content.ClipData;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lvThongTin;
    ArrayList<ThongTin> thongTinArrayList;
    ThongTinAdapter adapter;
    FloatingActionButton fab;
    Intent intent;
    int REQUEST_CODE_THEM = 100, REQUEST_CODE_SUA = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        adapter = new ThongTinAdapter(this, R.layout.dong_thongtin, thongTinArrayList);
        lvThongTin.setAdapter(adapter);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, TemThongTinActivity.class);
                Log.d("thong bao", "truoc khi them: " + thongTinArrayList.size());
                startActivityForResult(intent, REQUEST_CODE_THEM);

            }
        });
        registerForContextMenu(lvThongTin);

    }
    // Tao menu Option


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menuitem, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnuThem:
                Toast.makeText(MainActivity.this, "Them", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnuSua:
                AdapterView.AdapterContextMenuInfo adaptercontext = (AdapterView.AdapterContextMenuInfo) (item.getMenuInfo());
                int vitri = adaptercontext.position;
                intent = new Intent(MainActivity.this, TemThongTinActivity.class);
                Bundle bundle = new Bundle();
                ThongTin tt = thongTinArrayList.get(vitri);
                bundle.putSerializable("ttSua", tt);
                bundle.putInt("vitri", vitri);
                intent.putExtra("suadulieu", bundle);
                startActivityForResult(intent, REQUEST_CODE_SUA);
                break;
            case R.id.mnuXoa:
                Toast.makeText(MainActivity.this, "Xoa", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnuSX:
                Toast.makeText(MainActivity.this, "Sx", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }


    private void AnhXa() {
        lvThongTin = (ListView) findViewById(R.id.ListViewDS);
        fab = (FloatingActionButton) findViewById(R.id.floatingActionButtonThem);
        thongTinArrayList = new ArrayList<>();

        thongTinArrayList.add(new ThongTin("151212154", "Bui Tuan Viet", "Thai BInh", "01236725379"));
        thongTinArrayList.add(new ThongTin("151212154", " Viet", "Thai BInh", "01236725379"));
        thongTinArrayList.add(new ThongTin("123", "Bui Tuan Viet", "Thai BInh", "01236725379"));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("thong bao", "onActivityResult: hello my fr");
        Bundle bundle = data.getBundleExtra("dulieu");
        if (requestCode == 100) {
            if (bundle != null) {
                ThongTin tt = (ThongTin) bundle.getSerializable("tt");
                thongTinArrayList.add(tt);
                Log.d("thong bao", "sau khi them: " + thongTinArrayList.size());
            }
        } else {
            if (bundle != null) {
                int vt = (int) bundle.getInt("vitri");
                ThongTin ttSua = (ThongTin) bundle.getSerializable("tt");
                Log.d("AAA", "onActivityResult: vitriSua: " + ttSua.getTenSV() + " " + ttSua.getMaSV() + " " + ttSua.getSdt() + " " + ttSua.getDiaChi());
                thongTinArrayList.set(vt, ttSua);
                for (int i = 0; i < thongTinArrayList.size(); i++) {
                    Log.d("ABC", "onActivityResult:  " + thongTinArrayList.get(i).getTenSV() + " " +
                            thongTinArrayList.get(i).getMaSV() + " " +
                            thongTinArrayList.get(i).getDiaChi() + " " +
                            thongTinArrayList.get(i).getSdt());
                }

            }
        }
        adapter.notifyDataSetChanged();
    }
}
