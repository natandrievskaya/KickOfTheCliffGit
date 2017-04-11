package com.example.natan.kickofthecliff.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.natan.kickofthecliff.R;

public class SpringFallFragment extends AbstractTabFragment {

    private static final int LAYOUT = R.layout.fragment_springfall;

    public static SpringFallFragment getInstance(Context context){//передача объекта
        Bundle args = new Bundle();
        SpringFallFragment fragment = new SpringFallFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.tab_item_springfall));

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
