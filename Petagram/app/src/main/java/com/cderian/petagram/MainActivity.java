package com.cderian.petagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.cderian.petagram.adapter.PageAdapter;
import com.cderian.petagram.fragment.HomeFragment;
import com.cderian.petagram.fragment.PetFragment;
import com.cderian.petagram.menu.AboutActivity;
import com.cderian.petagram.menu.ContactoActivity;
import com.cderian.petagram.menu.RatedPatesActivity;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.actionBar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        setUpViewPager();

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.contact:
                openContactActivity();
                return true;
            case R.id.about:
                openBio();
                return true;
            case R.id.action_favs:
                openFavPets();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void openContactActivity () {
        Intent intent = new Intent(MainActivity.this, ContactoActivity.class);
        startActivity(intent);
    }

    private void openBio() {
        Intent intent = new Intent(MainActivity.this, AboutActivity.class);
        startActivity(intent);
    }

    private void openFavPets () {
        Intent intent = new Intent(MainActivity.this, RatedPatesActivity.class);
        startActivity(intent);
    }

    private ArrayList<Fragment> agregarFragments () {
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new HomeFragment());
        fragments.add(new PetFragment());

        return fragments;
    }

    private void setUpViewPager() {
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_pet_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_pet);
    }
}