package com.example.recycleviewdemo.model;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleviewdemo.R;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    //資料儲存區
    public String [] menus;
    public int [] price;
    public int[] images;

    public MenuAdapter() {
        // 從網路擷取 做法應該是透過 service
        this.menus = WebDataSource.getMenu();
        this.price = WebDataSource.getPrice();
        this.images = WebDataSource.getImage();
    }

    // onCreateViewHolder 是當 使用者捲動畫面時
    // RecyclerView 發現需要新的 ViewHolder 顯示資料給使用者看的時候 會呼叫
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 使用 row_list 建立 一個 view holder
        // UI view 一定要跟一個 UI Layout 綁定 不可獨立無連結
        // 在同一個context 之下(activity)繪製一個 row_list(ViewHolder) 放在 RecyclerView(parent)內
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_style, parent, false);
        // 版型更改 (R.layout.row_list, parent, false) 將參數 row_list 替換成 card_style

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvName.setText(this.menus[position]);
        holder.tvPrice.setText(String.valueOf(this.price[position]));
        holder.foodImage.setImageResource(this.images[position]);
    }

    @Override
    public int getItemCount() {
        return menus.length;
    }

    // MenuAdapter 負責製作 ViewHolder 並填入資料 交給 RecyclerView 顯示

    // 宣告 ViewHolder 的實作類別 去對應 ROW_LIST.XML 的 LAYOUT元件
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView foodImage;
        TextView tvName;
        TextView tvPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            foodImage = itemView.findViewById(R.id.foodImage2);
            tvName = itemView.findViewById(R.id.tvName2);
            tvPrice = itemView.findViewById(R.id.tvPrice2);
            // card_style 會重複 須改為 R.id.foodImage2 依此類推

            // 在此處支援 本品項的 click 動作
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    // String food = getFoodName(pos);
                    String food = WebDataSource.getProductName(pos);
                    Toast.makeText(itemView.getContext(), "使用者點選了第" + pos +" 個品項: " + food
                            , Toast.LENGTH_SHORT).show();
                }
            });
            // 長按品項
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    Toast.makeText(itemView.getContext(), "長按"
                            , Toast.LENGTH_LONG).show();
                    return false;
                }
            });

        }

        public ImageView getFoodImage() {
            return foodImage;
        }

        public TextView getTvName() {
            return tvName;
        }

        public TextView getTvPrice() {
            return tvPrice;
        }
    }

    public String getFoodName(int idx) {
        return this.menus[idx];
    }

}
