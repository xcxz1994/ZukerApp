package com.example.chuny.zuker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity implements
        android.view.View.OnClickListener {

    private ViewPager mViewPager;// 用来放置界面切换
    private PagerAdapter mPagerAdapter;// 初始化View适配器
    private List<View> mViews = new ArrayList<View>();// 用来存放Tab01-04
    // 四个Tab，每个Tab包含一个按钮
    private LinearLayout mTabSchool;
    private LinearLayout mTabFacetoFace;
    private LinearLayout mTabOnline;
    private LinearLayout mTabMy;
    // 四个按钮
    private ImageButton mSchoolImg;
    private ImageButton mFacetoFaceImg;
    private ImageButton mOnlineImg;
    private ImageButton mMyImg;

    private Button mReturnButton;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
        initViewPage();
        initEvent();


        SimpleAdapter adapter = new SimpleAdapter(
                this,getData(),R.layout.school_vlist,
                new String[]{"title","price","newPrice","info","img"},
                new int[]{R.id.title,R.id.price,R.id.newPrice,R.id.info,R.id.img}
        );
        System.out.println("sdsd"+adapter);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //通过view获取其内部的组件，进而进行操作
                String title = (String) ((TextView)view.findViewById(R.id.title)).getText();
                String price= (String) ((TextView)view.findViewById(R.id.price)).getText();
                String info = (String) ((TextView)view.findViewById(R.id.info)).getText();
                ImageView img=(ImageView)view.findViewById(R.id.img);
                //大多数情况下，position和id相同，并且都从0开始
                String showText = "点击第" + position + "项，标题内容为：" + title+"，价格是："+price+"信息是"+info + "，ID为：" + id;
               // Toast.makeText(MainActivity.this, showText, Toast.LENGTH_LONG).show();
                Intent intent3 = new Intent(MainActivity.this,School.class) ;
                startActivity(intent3);
                finish();

            }
        });
    }

    private void initEvent() {
        mTabSchool.setOnClickListener(this);
        mTabFacetoFace.setOnClickListener(this);
        mTabOnline.setOnClickListener(this);
        mTabMy.setOnClickListener(this);
        mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
            /**
             *ViewPage左右滑动时
             */
            @Override
            public void onPageSelected(int arg0) {
                int currentItem = mViewPager.getCurrentItem();
                switch (currentItem) {
                    case 0:
                        resetImg();
                        mSchoolImg.setImageResource(R.drawable.school_pressed);
                        break;
                    case 1:
                        resetImg();
                        mFacetoFaceImg.setImageResource(R.drawable.facetoface_pressed);
                        break;
                    case 2:
                        resetImg();
                        mOnlineImg.setImageResource(R.drawable.online_pressed);
                        break;
                    case 3:
                        resetImg();
                        mMyImg.setImageResource(R.drawable.my_pressed);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });
    }

    /**
     * 初始化设置
     */
    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.id_viewpage);
        // 初始化四个LinearLayout
        mTabSchool = (LinearLayout) findViewById(R.id.id_tab_school);
        mTabFacetoFace = (LinearLayout) findViewById(R.id.id_tab_facetoface);
        mTabOnline= (LinearLayout) findViewById(R.id.id_tab_online);
        mTabMy = (LinearLayout) findViewById(R.id.id_tab_my);
        // 初始化四个按钮
        mSchoolImg = (ImageButton) findViewById(R.id.id_tab_school_img);
        mFacetoFaceImg = (ImageButton) findViewById(R.id.id_tab_facetoface_img);
        mOnlineImg= (ImageButton) findViewById(R.id.id_tab_online_img);
        mMyImg = (ImageButton) findViewById(R.id.id_tab_my_img);

        mReturnButton = (Button)findViewById(R.id.returnback);

    }
    public void back_to_login(View view) {
        Intent intent3 = new Intent(MainActivity.this,Login.class) ;
        startActivity(intent3);
        finish();
    }
    /**
     * 初始化ViewPage
     */

    private List<Map<String,Object>> getData(){
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("title", "自行车");
        map.put("info", "这是自行车的介绍");
        map.put("price", "原价：12.00");
        map.put("newPrice", "会员价：11.00");
        map.put("img",R.drawable.zxc);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "台灯");
        map.put("info", "这是台灯的介绍");
        map.put("price", "原价：15.00");
        map.put("newPrice", "会员价：11.00");
        map.put("img",R.drawable.td);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "羽毛球拍");
        map.put("info", "这是羽毛球拍的介绍");
        map.put("price", "原价：15.00");
        map.put("newPrice", "会员价：11.00");
        map.put("img",R.drawable.ymqp);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "网球拍");
        map.put("info", "这是网球拍的介绍");
        map.put("price", "原价：8.00");
        map.put("newPrice", "会员价：6.00");
        map.put("img",R.drawable.wqp);
        list.add(map);

        return list;
    }
    private void initViewPage() {

        // 初妈化四个布局
        LayoutInflater mLayoutInflater = LayoutInflater.from(this);


        View tabfacetoface = mLayoutInflater.inflate(R.layout.tabfacetoface, null);

        View tabonline = mLayoutInflater.inflate(R.layout.tabonline, null);

        View tabschool = mLayoutInflater.inflate(R.layout.tabschool, null);
        listView = tabschool.findViewById(R.id.listView);


        View tabuser = mLayoutInflater.inflate(R.layout.user, null);

        mViews.add(tabschool);
        mViews.add(tabfacetoface);
        mViews.add(tabonline);
        mViews.add(tabuser);

        // 适配器初始化并设置
        mPagerAdapter = new PagerAdapter() {

            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                container.removeView(mViews.get(position));

            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = mViews.get(position);
                container.addView(view);
                return view;
            }

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {

                return arg0 == arg1;
            }

            @Override
            public int getCount() {

                return mViews.size();
            }
        };
        mViewPager.setAdapter(mPagerAdapter);
    }

    /**
     * 判断哪个要显示，及设置按钮图片
     */
    @Override
    public void onClick(View arg0) {

        switch (arg0.getId()) {
            case R.id.id_tab_school:
                mViewPager.setCurrentItem(0);

                resetImg();
                mSchoolImg.setImageResource(R.drawable.school_pressed);
                break;
            case R.id.id_tab_facetoface:
                mViewPager.setCurrentItem(1);
                resetImg();
                mFacetoFaceImg .setImageResource(R.drawable.facetoface_pressed);
                break;
            case R.id.id_tab_online:
                mViewPager.setCurrentItem(2);
                resetImg();
                mOnlineImg.setImageResource(R.drawable.online_pressed);
                break;
            case R.id.id_tab_my:
                mViewPager.setCurrentItem(3);
                resetImg();
                mMyImg.setImageResource(R.drawable.my_pressed);
                break;
            default:
                break;
        }
    }

    /**
     * 把所有图片变暗
     */
    private void resetImg() {
        mSchoolImg.setImageResource(R.drawable.school);
        mFacetoFaceImg.setImageResource(R.drawable.facetoface);
        mOnlineImg.setImageResource(R.drawable.online);
        mMyImg.setImageResource(R.drawable.my);
    }

}
