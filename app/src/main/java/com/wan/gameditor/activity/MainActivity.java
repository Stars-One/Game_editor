package com.wan.gameditor.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.wan.gameditor.R;


/**
 * @author stars-one
 */
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private LinearLayout mLinearlayout;

    private long exitTime = 0;
    private ImageView mImageHead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            exit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void initView() {

        /*
      角色当前属性
     */
        Button mCurrentProperty = (Button) findViewById(R.id.current_property);
        mCurrentProperty.setOnClickListener(this);
        /*
      角色当前装备
     */
        Button mCurrentEquipment = (Button) findViewById(R.id.current_equipment);
        mCurrentEquipment.setOnClickListener(this);
        /*
      添加新装备
     */
        Button mNewEquipment = (Button) findViewById(R.id.new_equipment);
        mNewEquipment.setOnClickListener(this);
        /*
      查看装备
     */
        Button mShowEquipment = (Button) findViewById(R.id.show_equipment);
        mShowEquipment.setOnClickListener(this);
        /*
      添加新角色
     */
        Button mNewPart = (Button) findViewById(R.id.new_part);
        mNewPart.setOnClickListener(this);
        Button mAbout = (Button) findViewById(R.id.about);
        mAbout.setOnClickListener(this);

        mLinearlayout = (LinearLayout) findViewById(R.id.linearlayout);
        mImageHead = (ImageView) findViewById(R.id.image_head);
        mImageHead.setOnClickListener(this);
    }


    public void exit() {
        final int time = 2000;
        if ((System.currentTimeMillis() - exitTime) > time) {
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            onDestroy();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.exit(0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.current_property:
                break;
            case R.id.current_equipment:
                mLinearlayout.setVisibility(View.VISIBLE);
                onBackPressed();
                break;
            case R.id.new_equipment:
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, NewActivity.class);
                startActivity(intent);
                break;
            case R.id.show_equipment:
                Intent intent1 = new Intent();
                intent1.setClass(MainActivity.this, ShownameActivity.class);
                startActivity(intent1);
                break;
            case R.id.new_part:
                break;
            case R.id.about:
                onBackPressed();
                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                /*参数里面注意！！！*/
                builder1.setTitle("关于");
                builder1.setMessage("作者：柯兴新一\n说明：本软件纯属娱乐，勿作商业用途！！");
                builder1.setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        arg0.cancel();
                    }
                });
                builder1.create().show();
                break;
            default:
                break;
            case R.id.image_head:
                enterchoseActivity("头饰");
                break;
        }
    }
public void enterchoseActivity(String s){

}

}
