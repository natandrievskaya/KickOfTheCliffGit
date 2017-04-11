package com.example.natan.kickofthecliff.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.natan.kickofthecliff.dto.KickDTO;
import com.example.natan.kickofthecliff.fragment.AbstractTabFragment;
import com.example.natan.kickofthecliff.fragment.SpringFallFragment;
import com.example.natan.kickofthecliff.fragment.SummerFragment;
import com.example.natan.kickofthecliff.fragment.WinterFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TabsFragmentAdapter extends FragmentPagerAdapter {

    private Map<Integer, AbstractTabFragment> tabs;
    private Context context;

    private SummerFragment summerFragment;

    private List<KickDTO> data;//данный для SummerFragment

    public TabsFragmentAdapter(Context context, FragmentManager fm) {//конструктор
        super(fm);
        this.context = context;//создание табов
        this.data = new ArrayList<>();//делаем данные изначально пустыми
        initTabsMap(context);
    }

    @Override
    public CharSequence getPageTitle(int position) {//возвращает заголовок

        return tabs.get(position).getTitle();
    }

    @Override
    public Fragment getItem(int position) {//возвращает таб по позиции
        return tabs.get(position);
    }

    @Override
    public int getCount() {//возврещает количество
        return tabs.size();
    }

    private void initTabsMap(Context context) {//создание табов и передача информации в них
        tabs = new HashMap<>();
        summerFragment = SummerFragment.getInstance(context, data);
        tabs.put(0, summerFragment);
        tabs.put(1, WinterFragment.getInstance(context));
        tabs.put(2, SpringFallFragment.getInstance(context));
    }

    public void setData(List<KickDTO> data) {
        this.data = data;
        summerFragment.refreshData(data);//обновление данных в фрагменте лето
    }
}
