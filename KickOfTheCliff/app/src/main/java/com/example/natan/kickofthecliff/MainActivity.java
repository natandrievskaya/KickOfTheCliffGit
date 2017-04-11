package com.example.natan.kickofthecliff;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.natan.kickofthecliff.adapter.TabsFragmentAdapter;
import com.example.natan.kickofthecliff.dto.KickDTO;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int LAYOUT = R.layout.activity_main;

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ViewPager viewPager;
    private TabsFragmentAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(R.style.AppDefault);
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);

        initToolbar();
        initNavigationView();
        initTabs();
    }

    private void initToolbar() {//создание тулбара
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });
        toolbar.inflateMenu(R.menu.menu);
    }

    private void initTabs() {//создание табов
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        adapter = new TabsFragmentAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        new KickTask().execute();//выполнение метода

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initNavigationView() {//создание навигатион вью
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        //кнопочка для вызова бокового меню
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.view_navigation_open, R.string.view_navigation_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        /*по клику в боковом меню по "напоминания" открывается таб "напоминания"*/
        /*NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                drawerLayout.closeDrawers();
                switch (menuItem.getItemId()){
                    case R.id.actionLandscapeItem:
                        showNotificationTab();
                }
                return true;
            }
        });*/
    }

    /*private void showNotificationTab(){//вызывает таб "напоминание"
        viewPager.setCurrentItem(Constants.TAB_TWO);
    }*/

    private class KickTask extends AsyncTask<Void, Void, KickDTO[]> {//логика приложения

        @Override
        protected KickDTO[] doInBackground(Void... params) {
            RestTemplate template = new RestTemplate();//общение с сервером!!!!
            template.getMessageConverters().add(new MappingJackson2HttpMessageConverter());//преобразование запросов
            //KickDTO[] result = template.getForObject(Constants.URL.GET_KICK_ITEM, KickDTO[].class);
            return template.getForObject(Constants.URL.GET_KICK_ITEM, KickDTO[].class);
        }

        @Override
        protected void onPostExecute(KickDTO[] kickDTO) {//срабатывает после doInBackground
            List<KickDTO> list = new ArrayList<>();//получение списка объектов с сервера
            for(int i =0;i<kickDTO.length;i++) {
                list.add(kickDTO[i]);
            }
            adapter.setData(list);//проставление данных в адаптер
        }
    }
}



