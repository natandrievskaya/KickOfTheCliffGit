package com.example.natan.kickofthecliff.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.natan.kickofthecliff.R;

public class WinterFragment extends AbstractTabFragment {

    private static final int LAYOUT = R.layout.fragment_winter;

    public static WinterFragment getInstance(Context context){//передача объекта
        Bundle args = new Bundle();
        WinterFragment fragment = new WinterFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.tab_item_winter));

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);
        return view;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
