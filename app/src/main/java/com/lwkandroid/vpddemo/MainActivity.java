package com.lwkandroid.vpddemo;

import android.os.Bundle;
import android.view.View;

import java.util.LinkedList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    ViewPager mViewPager;
    TestSingleAdapter mSingleAdapter;
    TestMultiAdapter mMultiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = findViewById(R.id.vp_main);
        findViewById(R.id.btn_main01).setOnClickListener(this);
        findViewById(R.id.btn_main02).setOnClickListener(this);
        findViewById(R.id.btn_main03).setOnClickListener(this);
        findViewById(R.id.btn_main04).setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btn_main01:
                List<String> singleList = new LinkedList<>();
                singleList.add("ZERO");
                singleList.add("ONE");
                singleList.add("TWO");
                singleList.add("THREE");
                singleList.add("FOUR");
                singleList.add("FIVE");
                mSingleAdapter = new TestSingleAdapter(this, singleList);
                mViewPager.setAdapter(mSingleAdapter);
                break;
            case R.id.btn_main02:
                List<TestData> multiList = new LinkedList<>();
                multiList.add(new TestData("ZERO", 1));
                multiList.add(new TestData("ONE", 0));
                multiList.add(new TestData("TWO", 1));
                multiList.add(new TestData("THREE", 0));
                multiList.add(new TestData("FOUR", 1));
                multiList.add(new TestData("FIVE", 0));
                multiList.add(new TestData("SIX", 1));
                mMultiAdapter = new TestMultiAdapter(this, multiList);
                mViewPager.setAdapter(mMultiAdapter);
                break;
            case R.id.btn_main03:
                TestPagerAdapter pagerAdapter = new TestPagerAdapter(getSupportFragmentManager());
                mViewPager.setAdapter(pagerAdapter);
                break;
            case R.id.btn_main04:
                TestStatePagerAdapter statePagerAdapter = new TestStatePagerAdapter(getSupportFragmentManager());
                mViewPager.setAdapter(statePagerAdapter);
                break;
            default:
                break;
        }
    }
}
