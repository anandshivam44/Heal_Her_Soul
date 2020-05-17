package com.example.healhersoul.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.healhersoul.Fragments.Fragment_profile;
import com.example.healhersoul.Fragments.fragment_articles;
import com.example.healhersoul.Fragments.fragment_chat_bot;
import com.example.healhersoul.Fragments.fragment_donate;
import com.example.healhersoul.Fragments.fragment_emergency;
import com.example.healhersoul.Fragments.fragment_faq;
import com.example.healhersoul.Fragments.fragment_forum;
import com.example.healhersoul.Fragments.fragment_home;
import com.example.healhersoul.Fragments.fragment_telephone_directory;
import com.example.healhersoul.Fragments.fragment_tools;
import com.example.healhersoul.Fragments.fragment_workshop;
import com.example.healhersoul.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //    private CarouselView carouselView;
//    private Button next;
    private int[] sampleImages = {R.drawable.master, R.drawable.consultant, R.drawable.counseling, R.drawable.childmum,
            R.drawable.parents123};

    private DrawerLayout drawer;
    BottomNavigationView bottomNav;
    boolean frag_art = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_main);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
//        bottomNav = (BottomNavigationView) findViewById(R.id.bottom_navigation);
//        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams)
//                bottomNav .getLayoutParams();
//        layoutParams.setBehavior(new BottomNavigationViewBehavior());

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new fragment_home()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }

//        carouselView = findViewById(R.id.carouselView2);
//        carouselView.setPageCount(sampleImages.length);
//        carouselView.setImageListener(imageListener);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                frag_art = false;
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new fragment_home()).commit();
                break;
            case R.id.nav_profile:
                frag_art = false;
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment_profile()).commit();
                break;
            case R.id.nav_articles:
                frag_art = true;
                bottomNav.setVisibility(View.GONE);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new fragment_articles()).commit();
                break;
            case R.id.nav_tools:
                frag_art = false;
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new fragment_tools()).commit();
                break;
            case R.id.nav_telephone_directory:
                frag_art = false;
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new fragment_telephone_directory()).commit();
                break;
            case R.id.nav_faq:
                frag_art = false;
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new fragment_faq()).commit();
                break;
            case R.id.nav_emergency:
                frag_art = false;
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new fragment_emergency()).commit();
                break;
            case R.id.nav_workshop:
                frag_art = false;
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new fragment_workshop()).commit();
                break;
            case R.id.nav_donate:
                frag_art = false;
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new fragment_donate()).commit();
                break;
            case R.id.nav_about_us:
                frag_art = false;
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new about_us()).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_forum:
                            frag_art = false;
                            selectedFragment = new fragment_forum();
                            break;
                        case R.id.nav_home:
                            frag_art = false;
                            selectedFragment = new fragment_home();
                            break;
                        case R.id.nav_chat_bot:
                            frag_art = false;
                            selectedFragment = new fragment_chat_bot();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };

    @Override
    public void onBackPressed() {

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (frag_art == true) {
            drawer.openDrawer(GravityCompat.START);

        } else {
            super.onBackPressed();
        }
    }
//    ImageListener imageListener = new ImageListener() {
//        @Override
//        public void setImageForPosition(int position, ImageView imageView) {
//            imageView.setImageResource(sampleImages[position]);
//        }
//    };
}
