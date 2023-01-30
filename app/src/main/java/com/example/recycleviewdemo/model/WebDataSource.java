package com.example.recycleviewdemo.model;

import com.example.recycleviewdemo.R;

public class WebDataSource {

    static int [] image = {
            R.drawable.p02, R.drawable.p03,
            R.drawable.p01, R.drawable.p04
    };
    static String [] menu = {
            "麥香雞", "麥香魚", "大麥克", "雙層吉士牛肉堡"
    };
    static int [] price = {
            55, 50, 80, 75
    };

    public static int[] getImage() {
        return image;
    }

    public static String[] getMenu() {
        return menu;
    }

    public static int[] getPrice() {
        return price;
    }

    public static String getProductName(int idx) {
        return menu[idx];
    }

}