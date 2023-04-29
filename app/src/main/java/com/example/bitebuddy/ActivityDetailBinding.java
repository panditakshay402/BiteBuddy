package com.example.bitebuddy;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageSwitcher;

import java.text.BreakIterator;

public class ActivityDetailBinding {
    public ImageSwitcher detailImage;
    public BreakIterator editPrice;
    public BreakIterator editPhoneDetails;
    public BreakIterator editNameDetails;
    public BreakIterator detailDescription;
    public BreakIterator foodNameQ;
    public View orderButton;
    public BreakIterator quantity;

    public static ActivityDetailBinding inflate(LayoutInflater layoutInflater) {
        return null;
    }

    public int getRoot() {
        return 0;
    }
}
