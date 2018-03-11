package com.example.buitu.listviewpractive;

import android.content.Intent;
import android.content.IntentSender;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ThemedSpinnerAdapter;
import android.widget.Toast;

import java.io.Serializable;

public class TemThongTinActivity extends AppCompatActivity {
    Button btnThem;
    EditText edtMaSv, edtTenSv, edtDiachi, edtSdt;
    Intent intent;
    Bundle bundle;
    int vt;
    int REQUEST_CODE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tem_thong_tin);
        AnhXa();
        try {
            intent = getIntent();
            bundle = intent.getBundleExtra("suadulieu");
            ThongTin tt = (ThongTin) bundle.getSerializable("ttSua");
            vt = (int) bundle.getInt("vitri");
            Log.d("Vi tri: ", "onClick: " + vt);
            Sua(tt);
            edtMaSv.setText(tt.getMaSV().toString());
            edtTenSv.setText(tt.getTenSV().toString());
            edtDiachi.setText(tt.getDiaChi().toString());
            edtSdt.setText(tt.getSdt().toString());
            REQUEST_CODE = 200;
        } catch (Exception e) {
            REQUEST_CODE = 100;
        }


        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intent = new Intent(TemThongTinActivity.this, MainActivity.class);
                bundle = new Bundle();
                ThongTin tt = new ThongTin(edtMaSv.getText().toString(),
                        edtTenSv.getText().toString(),
                        edtDiachi.getText().toString(),
                        edtSdt.getText().toString());
                if (REQUEST_CODE == 100) {
                    bundle.putSerializable("tt", tt);
                } else {
                    bundle.putSerializable("tt", tt);
                    bundle.putInt("vitri", vt);
                }
                intent.putExtra("dulieu", bundle);
                setResult(REQUEST_CODE, intent);
                finish();
            }
        });


    }

    private void Sua(ThongTin tt) {
        edtMaSv.setText(tt.getMaSV());
        edtTenSv.setText(tt.getTenSV());
        edtDiachi.setText(tt.getDiaChi());
        edtSdt.setText(tt.getSdt());
    }

    private void AnhXa() {
        edtMaSv = (EditText) findViewById(R.id.editTextMasv);
        edtTenSv = (EditText) findViewById(R.id.editTextTensv);
        edtDiachi = (EditText) findViewById(R.id.editTextDiachi);
        edtSdt = (EditText) findViewById(R.id.editTextsdt);
        btnThem = (Button) findViewById(R.id.buttonThem);
    }

}
