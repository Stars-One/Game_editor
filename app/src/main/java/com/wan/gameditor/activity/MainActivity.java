package com.wan.gameditor.activity;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.ContentUris;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.wan.gameditor.R;

import static com.wan.gameditor.activity.SettingActivity.CHOOSE_PHOTO;


/**
 * @author stars-one
 */
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private LinearLayout mLinearlayout;

    private long exitTime = 0;
    private ImageView mImageHead;
    private ImageButton mImageButton;
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
        mImageButton = (ImageButton) findViewById(R.id.changePicture);
        mImageButton.setOnClickListener(this);
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
            case R.id.changePicture:
                checkPermission();
                break;
            case R.id.image_head:
                enterchoseActivity("头饰");
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
                if (resultCode==RESULT_OK){
                    if (Build.VERSION.SDK_INT>=19){
                        handleImageOnkitKat(data);//高于4.4版本使用此方法处理图片
                    }else{
                        handleImageBeforeKitKat(data);//低于4.4版本使用此方法处理图片
                    }
                }
                break;
            default:break;
        }
    }

    @TargetApi(19)
    private void handleImageOnkitKat(Intent data){
        String imagePath = null;
        Uri uri = data.getData();
        if (DocumentsContract.isDocumentUri(this,uri)){
            //如果是document类型的uri，则通过document id处理
            String docId = DocumentsContract.getDocumentId(uri);
            if ("com.android.providers.media.documents".equals(uri.getAuthority())){
                String id = docId.split(":")[1];//解析出数字格式的id
                String selection = MediaStore.Images.Media._ID + "=" + id;
                imagePath = getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,selection);
            } else if ("com.android,providers.downloads.documents".equals(uri.getAuthority())) {
                Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"),Long.valueOf(docId));
                imagePath = getImagePath(contentUri,null);
            }

        }else if("content".equalsIgnoreCase(uri.getScheme())){
            imagePath = getImagePath(uri,null);
        }
        displayImage(imagePath);
    }

    private void handleImageBeforeKitKat(Intent data){
        Uri uri = data.getData();
        String imagePath = getImagePath(uri,null);
        displayImage(imagePath);
    }
    //获得图片路径
    public String getImagePath(Uri uri,String selection) {
        String path = null;
        Cursor cursor = getContentResolver().query(uri,null,selection,null,null);   //内容提供器
        if (cursor!=null){
            if (cursor.moveToFirst()){
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));   //获取路径
            }
        }
        cursor.close();
        return path;
    }
    //展示图片
    private void displayImage(String imagePath) {
        if (imagePath != null){
            Bitmap bitImage = BitmapFactory.decodeFile(imagePath);//格式化图片
            headImage.setImageBitmap(bitImage);//为imageView设置图片
        }
        else{
            Toast.makeText(MainActivity.this,"获取图片失败",Toast.LENGTH_SHORT).show();
        }
    }


}
