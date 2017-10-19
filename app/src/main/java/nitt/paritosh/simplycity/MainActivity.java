package nitt.paritosh.simplycity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import nitt.paritosh.simplycity.Tab.MyAdapter;
import nitt.paritosh.simplycity.Tab.SlidingTabLayout;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.roughike.bottombar.BottomBar;

public class MainActivity extends AppCompatActivity {
    private BottomBar bottomBar;
    private SlidingTabLayout mSlidingTabLayout;
    private ViewPager mViewPager;
    private Drawer.Result result;
    private AccountHeader.Result headerNavigationLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mViewPager = (ViewPager) findViewById(R.id.vp_tabs);
        mViewPager.setAdapter(new MyAdapter(getSupportFragmentManager(), this));

        mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.stl_tabs);
        mSlidingTabLayout.setDistributeEvenly(true);
        mSlidingTabLayout.setBackgroundColor((Color.parseColor("#FD2F13")));
        mSlidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.colorAccent));
        mSlidingTabLayout.setCustomTabView(R.layout.tab_view, R.id.tv_tab);
        mSlidingTabLayout.setViewPager(mViewPager);

        //===================================================================================

        headerNavigationLeft = new AccountHeader()
                .withActivity(this)
                .withCompactStyle(false)
                .withSavedInstance(savedInstanceState)
                .withHeaderBackground(R.drawable.nav1)
                .addProfiles(
                        new ProfileDrawerItem().withName("Kumar Paritosh").withEmail("kpritosh98@gmail.com").withIcon(getResources().getDrawable(R.drawable.me))
                )
                .build();


        /* navigationDrawerLeft = new Drawer()
                .withActivity(this)
                .withToolbar(toolbar)
                .withDisplayBelowToolbar(false)
                .withActionBarDrawerToggleAnimated(true)
                .withDrawerGravity(Gravity.LEFT)
                .withSavedInstance(savedInstanceState)
                .withAccountHeader(headerNavigationLeft)
                .withSelectedItem(0)
                .build();

        navigationDrawerLeft.addItem(new PrimaryDrawerItem().withName("My Orders").withIcon(getResources().getDrawable(R.drawable.ic_border_color_black_24dp)));
        navigationDrawerLeft.addItem(new PrimaryDrawerItem().withName("Live Chat").withIcon(getResources().getDrawable(R.drawable.ic_chat_black_24dp)));
        navigationDrawerLeft.addItem(new PrimaryDrawerItem().withName("Offers").withIcon(getResources().getDrawable(R.drawable.ic_card_giftcard_black_24dp)));
        navigationDrawerLeft.addItem(new PrimaryDrawerItem().withName("Help/Support").withIcon(getResources().getDrawable(R.drawable.ic_help_black_24dp)));
        navigationDrawerLeft.addItem(new PrimaryDrawerItem().withName("FAQs").withIcon(getResources().getDrawable(R.drawable.ic_format_list_numbered_black_24dp)));
        navigationDrawerLeft.addItem(new PrimaryDrawerItem().withName("About Us").withIcon(getResources().getDrawable(R.drawable.ic_favorite_black_24dp)));//=======================================================================================================


//        bottomBar =(BottomBar)findViewById(R.id.bottombar);
//        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
//            Fragment fragment = null;
//            @Override
//            public void onTabSelected(@IdRes int tabId) {
//                if (tabId == R.id.tab_home){
//                    fragment = new HomeFragment();
//                }else if (tabId == R.id.tab_explore){
//                    fragment = new ExploreFragment();
//                }else if (tabId ==R.id.tab_chat){
//                    fragment = new ChatFragment();
//                }else if (tabId==R.id.tab_friends){
//                    fragment = new FriendFragment();
//                }
//                getSupportFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.content, fragment)
//                        .commit();
//            }
//        });
    }

    */




        PrimaryDrawerItem i1 =new PrimaryDrawerItem().withIdentifier(1).withName("My Profile").withIcon(getResources().getDrawable(R.drawable.profile));
        PrimaryDrawerItem i2 =new PrimaryDrawerItem().withIdentifier(2).withName("My Orders").withIcon(getResources().getDrawable(R.drawable.order));
        PrimaryDrawerItem i3 =new PrimaryDrawerItem().withIdentifier(3).withName("Live Chat").withIcon(getResources().getDrawable(R.drawable.chat));
        PrimaryDrawerItem i4 =new PrimaryDrawerItem().withIdentifier(4).withName("Offers").withIcon(getResources().getDrawable(R.drawable.gift));
        PrimaryDrawerItem i5 =new PrimaryDrawerItem().withIdentifier(5).withName("Invite").withIcon(getResources().getDrawable(R.drawable.invite));
        PrimaryDrawerItem i6 =new PrimaryDrawerItem().withIdentifier(6).withName("Help/Support").withIcon(getResources().getDrawable(R.drawable.help));
        PrimaryDrawerItem i7 =new PrimaryDrawerItem().withIdentifier(7).withName("FAQs").withIcon(getResources().getDrawable(R.drawable.faq));
        PrimaryDrawerItem i8 =new PrimaryDrawerItem().withIdentifier(8).withName("About Us").withIcon(getResources().getDrawable(R.drawable.about));


        result = new Drawer()
                .withActivity(this)
                .withToolbar(toolbar)
                .withDisplayBelowToolbar(false)
                .withActionBarDrawerToggleAnimated(true)
                .withDrawerGravity(Gravity.LEFT)
                .withSavedInstance(savedInstanceState)
                .withAccountHeader(headerNavigationLeft)
                .withSelectedItem(0)
                //.withOnDrawerItemClickListener()
                .addDrawerItems(i1,i2,i3,i4,i5,i6,i7,i8)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener(){

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id, IDrawerItem drawerItem)
                    {


                        //android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
                        //int x = drawerItem.getIdentifier();
                        switch (position)
                        {

                            case 0:
                                Toast.makeText(getApplicationContext(),"okay", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(getApplicationContext(), Profile.class);
                                startActivity(i);
                                // fragmentManager.beginTransaction()
                                //    .replace(R.id.content, new FriendFragment()).commit();

                                break;
                            case 1:
                                Intent j = new Intent(getApplicationContext(), Orders.class);
                                startActivity(j);
                                //Toast.makeText(getApplicationContext(),"dekh le",Toast.LENGTH_SHORT).show();

                                break;
                            case 2:
                                Intent k = new Intent(getApplicationContext(), LiveChat.class);
                                startActivity(k);
                                break;
                            case 3:
                                Intent l = new Intent(getApplicationContext(), Offers.class);
                                startActivity(l);
                                break;
                            case 4:
                                Intent m = new Intent(getApplicationContext(), Invites.class);
                                startActivity(m);
                                break;
                            case 5:
                                Intent n = new Intent(getApplicationContext(), Help.class);
                                startActivity(n);
                                break;
                            case 6:
                                Intent p = new Intent(getApplicationContext(),FAQ.class);
                                startActivity(p);
                                break;
                            case 7:
                                 Intent z = new Intent(getApplicationContext(),AboutUs.class);
                                 startActivity(z);
                                break;



                        }


                    }
                })
                .build();











    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        //Runtime.getRuntime().gc();
        System.gc();
    }
}



