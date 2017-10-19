package nitt.paritosh.simplycity.Tab;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;

import nitt.paritosh.simplycity.R;
import nitt.paritosh.simplycity.fragment.ChatFragment;
import nitt.paritosh.simplycity.ExploreFragment;
import nitt.paritosh.simplycity.fragment.FriendFragment;
import nitt.paritosh.simplycity.fragment.HomeFragment;


public class MyAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private String[] titles ={"A","B","C","D"};
    int[] icon = new int[]{R.drawable.cakes,R.drawable.ondemand,R.drawable.everyday,R.drawable.stationery};
    private int heightIcon;

    public MyAdapter(FragmentManager fm, Context c)
    {
        super(fm);
        mContext = c;
        double scale = c.getResources().getDisplayMetrics().density;
        heightIcon=(int)(24*scale+0.5f);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag= null;

        if(position ==0){
            frag = new ExploreFragment();
        }else if(position == 1){
            frag = new HomeFragment();
        }else if(position == 2){
            frag = new ChatFragment();
        }else if(position == 3){
            frag = new FriendFragment();
        }

        Bundle b = new Bundle();
        b.putInt("position", position);
        frag.setArguments(b);
        return frag;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    public CharSequence getPageTitle(int position){
        Drawable d = mContext.getResources().getDrawable(icon[position]);
        d.setBounds(0,0,heightIcon,heightIcon);
        ImageSpan is = new ImageSpan(d);

        SpannableString sp = new SpannableString(" ");
        sp.setSpan(is,0,sp.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return sp;
    }

}