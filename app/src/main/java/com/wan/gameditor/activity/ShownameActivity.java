package com.wan.gameditor.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;

import com.wan.gameditor.R;
import com.wan.utils.EquipmentResult;
import com.wan.utils.mRecyclerViewAdatper;
import com.yanzhenjie.recyclerview.swipe.SwipeItemClickListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenu;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuBridge;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItem;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItemClickListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * @author stars-one
 */
public class ShownameActivity extends Activity {


    private SwipeMenuRecyclerView mMrecyclerview;
    private SwipeItemClickListener swipeItemClickListener;
    private SwipeMenuItemClickListener swipeMenuItemClickListener;
    private SwipeMenuCreator swipeMenuCreator;
    private List<EquipmentResult> equipmentResults;
    private EquipmentResult temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showname);
        initView();
        equipmentResults = DataSupport.findAll(EquipmentResult.class);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mMrecyclerview.setLayoutManager(linearLayoutManager);
        mMrecyclerview.setSwipeMenuCreator(swipeMenuCreator);//设置菜单
        mMrecyclerview.setSwipeMenuItemClickListener(swipeMenuItemClickListener);//设置菜单item监听器
        mMrecyclerview.setSwipeItemClickListener(swipeItemClickListener);//设置item监听器
        mMrecyclerview.setAdapter(new mRecyclerViewAdatper(equipmentResults));//设置adapter

    }

    private void initView() {

        mMrecyclerview = (SwipeMenuRecyclerView) findViewById(R.id.mrecyclerview);
        //创建侧滑菜单
        swipeMenuCreator = new SwipeMenuCreator() {
            @Override
            public void onCreateMenu(SwipeMenu swipeLeftMenu, SwipeMenu swipeRightMenu, int viewType) {
                SwipeMenuItem deleteitem = new SwipeMenuItem(ShownameActivity.this)
                        .setBackground(R.drawable.check_menu_bg)
                        .setImage(R.drawable.vector_drawable_delete)
                        .setHeight(ViewGroup.LayoutParams.MATCH_PARENT)
                        .setWidth(120);

                SwipeMenuItem edititem = new SwipeMenuItem(ShownameActivity.this)
                        .setBackground(R.drawable.check_button_bg)
                        .setImage(R.drawable.vector_drawable_edit)//设置图标
                        .setHeight(ViewGroup.LayoutParams.MATCH_PARENT)
                        .setWidth(120);
                swipeRightMenu.addMenuItem(edititem);
                swipeRightMenu.addMenuItem(deleteitem);

            }
        };
        //菜单item监听器
        swipeMenuItemClickListener = new SwipeMenuItemClickListener() {
            @Override
            public void onItemClick(SwipeMenuBridge menuBridge) {
                menuBridge.closeMenu();//防止侧滑状态错乱
                int adapterPosition = menuBridge.getAdapterPosition();  //RecyclerView的Item的position。
                int menuPosition = menuBridge.getPosition(); // 菜单在RecyclerView的Item中的Position。
                if(menuPosition==1) {

                    deleteconfirm(adapterPosition);
                }else {
                    edit(adapterPosition);
                }

            }
        };
        //item监听器
        swipeItemClickListener = new SwipeItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                show(position);
            }
        };

    }
    private void deleteconfirm(final int position){
        AlertDialog.Builder dialog = new AlertDialog.Builder(ShownameActivity.this)
                .setMessage("你确定要删除？")
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        })
             .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialog, int which) {
                     delete(position);
                     dialog.dismiss();

                 }
             });
        dialog.show();

    }
    private void delete(int position){
        temp = equipmentResults.get(position);

        DataSupport.deleteAll(EquipmentResult.class,"name = ? and type = ?",temp.getName(),temp.getType());
        equipmentResults.remove(temp);
        mMrecyclerview.setAdapter(new mRecyclerViewAdatper(equipmentResults));
    }
    private void edit(int position){
        temp = equipmentResults.get(position);
        Intent intent = new Intent(ShownameActivity.this,EditActivity.class);
        intent.putExtra("flag",1);
        intent.putExtra("r",temp);
        finish();
        startActivity(intent);

    }
    private void show(int position){
        temp = equipmentResults.get(position);

        Intent intent = new Intent(ShownameActivity.this,ShowActivity.class);
        intent.putExtra("r",temp);
        startActivity(intent);
    }
}
