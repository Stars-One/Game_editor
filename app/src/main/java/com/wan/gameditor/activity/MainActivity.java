package com.wan.gameditor.activity;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.wan.gameditor.R;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.UCropActivity;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import static com.wan.gameditor.activity.SettingActivity.CHOOSE_PHOTO;
import static com.yalantis.ucrop.UCrop.REQUEST_CROP;


/**
 * @author stars-one
 */
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private LinearLayout mLinearlayout;

    private long exitTime = 0;

    private ImageButton changeButton;
    private ImageView headImage;
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

        load();
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
        switch (item.getItemId()){
            case R.id.action_settings:
                Intent intent2 = new Intent(this,SettingActivity.class);
                startActivity(intent2);
                break;
            default:break;
        }

        return true;
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

        changeButton = (ImageButton)findViewById(R.id.changePicture);
        changeButton.setOnClickListener(this);
        headImage = (ImageView) findViewById(R.id.headPicture);
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
                startActivity(new Intent(v.getContext(),CurrentActivity.class));
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
            case R.id.changePicture:

                checkPermission();
                break;
            case R.id.image_head:

                break;
        }
    }
    //检查权限
    public void checkPermission(){
        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
            //发现没有权限，调用requestPermissions方法向用户申请权限，requestPermissions接收三个参数，第一个是context，第二个是一个String数组，我们把要申请的权限
            //名放在数组中即可，第三个是请求码，只要是唯一值就行
        }else{
            openAlbum();//有权限就打开相册
        }
    }

    public void openAlbum(){
        //通过intent打开相册，使用startactivityForResult方法启动actvity，会返回到onActivityResult方法，所以我们还得复写onActivityResult方法
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        startActivityForResult(intent,CHOOSE_PHOTO);
    }
    //弹出窗口向用户申请权限


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);//弹出授权的窗口，这条语句也可以删除，没有影响
        //获得了用户的授权结果，保存在grantResults中，判断grantResult中的结果来决定接下来的操作
        switch (requestCode){
            case 1:

                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    openAlbum();
                }else {
                    Toast.makeText(this, "授权失败，无法操作", Toast.LENGTH_SHORT).show();
                }
                break;
            default:break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case CHOOSE_PHOTO:
                if (resultCode == RESULT_OK) {
                    Uri originUri = data.getData();
                    startUcrop(originUri);
                }
                break;
            case REQUEST_CROP:
                if(resultCode==RESULT_OK){
                    final Uri resultUri = UCrop.getOutput(data);
                    Log.d("requestCROP",resultUri.toString());
                    if (Build.VERSION.SDK_INT >= 19) {
                        handleImageOnkitKat(resultUri);//高于4.4版本使用此方法处理图片
                    } else {
                        handleImageBeforeKitKat(resultUri);//低于4.4版本使用此方法处理图片
                    }
                }
                break;
            default:
                break;
        }
    }

    @TargetApi(19)
    private void handleImageOnkitKat(Uri resultUri) {
        Uri uri = resultUri;//返回的Uri
        String imagePath = uri.toString();
        displayImage(imagePath);
    }

    private void handleImageBeforeKitKat(Uri resultUri) {
        Uri uri = resultUri;
        String imagePath = uri.toString();
        displayImage(imagePath);
    }

    //展示图片
    private void displayImage(String imagePath) {
        if (imagePath != null) {
            save(imagePath);
            InputStream is = null ;
            try {
                is = new URL(imagePath).openStream();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Bitmap bitImage = BitmapFactory.decodeStream(is);//格式化图片
            headImage.setImageBitmap(bitImage);//为imageView设置图片

        } else {
            Toast.makeText(MainActivity.this, "获取图片失败", Toast.LENGTH_SHORT).show();
        }
    }
    private void save(String imagePath){
        SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();//获得SHaredPreferences.Editor对象
        editor.putBoolean("imageChange",true);//添加一个名为imageChange的boolean值，数值为true
        editor.putString("imagePath",imagePath);//保存imagePath图片路径
        editor.apply();//提交
    }
    private void load(){
        SharedPreferences preferences = getSharedPreferences("data",MODE_PRIVATE);//获得SharedPreferences的对象
        //括号里的判断是去找imageChange这个对应的数值，若是找不到，则是返回false，找到了的话就是我们上面定义的true，就会执行其中的语句
        if(preferences.getBoolean("imageChange",false)){
            String imagePath = preferences.getString("imagePath","");//取出保存的imagePath，若是找不到，则是返回一个空
            displayImage(imagePath);//调用显示图片方法，为ImageView设置图片
        }
    }

    private void startUcrop(Uri uri){
        Uri mDestinationUri = Uri.fromFile(new File(getCacheDir(), "SampleCropImage.jpeg"));
        UCrop uCrop = UCrop.of(uri, mDestinationUri);

        // uCrop = uCrop.withAspectRatio(16, 9);//设置裁剪框宽高比例为16:9

        UCrop.Options options = new UCrop.Options();//new一个设置
        options.setCompressionFormat(Bitmap.CompressFormat.JPEG);//设置裁剪出来的是JPEG的图片格式
        options.setAllowedGestures(UCropActivity.ALL, UCropActivity.ALL, UCropActivity.ALL);//缩放，旋转，裁剪
        // options.setMaxBitmapSize(100);//设置载入的最大尺寸
        options.setMaxScaleMultiplier(20);//设置最大缩放比例
        options.setShowCropFrame(true);//设置是否展示矩形裁剪框

        /*options.setCropGridStrokeWidth(20);//设置裁剪框横竖线的宽度
        options.setCropGridColor(Color.GREEN);//设置裁剪框横竖线的颜色
        options.setCropGridColumnCount(2);//设置竖线的数量
        options.setCropGridRowCount(1);//设置横线的数量*/
        uCrop.withOptions(options);
        uCrop.start(MainActivity.this);

    }
}
