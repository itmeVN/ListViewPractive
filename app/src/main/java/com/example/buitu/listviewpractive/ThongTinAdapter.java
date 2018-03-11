package com.example.buitu.listviewpractive;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by buitu on 3/5/2018.
 */

public class ThongTinAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<ThongTin> thongTins;

    public ThongTinAdapter(Context context, int layout, List<ThongTin> thongTins) {
        this.context = context;
        this.layout = layout;
        this.thongTins = thongTins;
    }

    @Override
    public int getCount() {
        return thongTins.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            holder = new ViewHolder();
            holder.txtMaSv = (TextView)view.findViewById(R.id.textMaSV);
            holder.txtTenSv = (TextView) view.findViewById(R.id.textTenSV);
            holder.txtDiachi = (TextView) view.findViewById(R.id.textDiaChi);
            holder.txtsdt = (TextView) view.findViewById(R.id.textsdt);
            ThongTin thongTin = thongTins.get(i);
            try{
                holder.txtMaSv.setText(thongTin.getMaSV().toString());
                holder.txtTenSv.setText(thongTin.getTenSV().toString());
                holder.txtDiachi.setText(thongTin.getDiaChi());
                holder.txtsdt.setText( thongTin.getSdt().toString());
            }
            catch (Exception e)
            {
                Log.d("Thong bao","Error!");
            }
            view.setTag(holder);
        }
        else holder = (ViewHolder) view.getTag();
        return view;
    }
    private class ViewHolder{
        TextView txtMaSv;
        TextView txtTenSv;
        TextView txtDiachi;
        TextView txtsdt;
    }
}
