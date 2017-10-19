package nitt.paritosh.simplycity.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


import nitt.paritosh.simplycity.R;

import nitt.paritosh.simplycity.ExploreFragment;
import nitt.paritosh.simplycity.restuarants.WonderModel;



/*
public class HomeFragment extends Fragment {
    public HomeFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);




        return view;
    }
}

*/

public class HomeFragment extends Fragment {

    ArrayList<WonderModel> listitems = new ArrayList<>();
    RecyclerView MyRecyclerView;
    String Wonders[] = {"Dominos","Maghai","KFC","Noodle King","AlHabibi","Arabian Foods","Meridian","Anjappar Chettinad"};
    //int  Images[] = {R.drawable.me,R.drawable.me,R.drawable.me,R.drawable.me,R.drawable.me,R.drawable.me,R.drawable.me};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeList();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        MyRecyclerView = (RecyclerView) view.findViewById(R.id.cardView);
        MyRecyclerView.setHasFixedSize(true);
        LinearLayoutManager MyLayoutManager = new LinearLayoutManager(getActivity());
        MyLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        if (listitems.size() > 0 & MyRecyclerView != null) {
            MyRecyclerView.setAdapter(new MyAdapter(listitems));
        }
        MyRecyclerView.setLayoutManager(MyLayoutManager);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }



    public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
        private ArrayList<WonderModel> list;

        public MyAdapter(ArrayList<WonderModel> Data) {
            list = Data;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
            // create a new view
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recycle_items, parent, false);
            MyViewHolder holder = new MyViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, int position) {

            holder.titleTextView.setText(list.get(position).getCardName());
            //holder.coverImageView.setImageResource(list.get(position).getImageResourceId());


            if (position==1)
            {

                Picasso.with(getActivity())
                        .load("https://scontent-bom1-1.xx.fbcdn.net/v/t1.0-9/19029735_674003869455260_6205278222850720957_n.png?oh=bbf7b8cd17af58642e0972e9796970c2&oe=5A3BA468")
                        .memoryPolicy(MemoryPolicy.NO_CACHE)
                        .networkPolicy(NetworkPolicy.NO_CACHE)
                        .fit()
                        //.resize(200,200)
                        .into(holder.coverImageView);
                holder.coverImageView.setTag(list.get(position).getImageResourceId());
            }
            else {
                Picasso.with(getActivity())
                        .load("http://wallpapermonkey.com/wp-content/uploads/2016/03/kfc-chicken.jpg")
                        .memoryPolicy(MemoryPolicy.NO_CACHE)
                        .networkPolicy(NetworkPolicy.NO_CACHE)
                        .fit()
                        //.resize(200,200)
                        .into(holder.coverImageView);
                holder.coverImageView.setTag(list.get(position).getImageResourceId());
            }
          //  holder.likeImageView.setTag(R.drawable.ondemand);

        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView titleTextView;
        public ImageView coverImageView;
        public ImageView likeImageView;
        public ImageView shareImageView;

        public MyViewHolder(View v) {
            super(v);
            titleTextView = (TextView) v.findViewById(R.id.titleTextView);
            coverImageView = (ImageView) v.findViewById(R.id.coverImageView);
           // likeImageView = (ImageView) v.findViewById(R.id.likeImageView);
            //shareImageView = (ImageView) v.findViewById(R.id.shareImageView);

         /*

            likeImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    int id = (int)likeImageView.getTag();
                    if( id == R.drawable.ondemand){

                        likeImageView.setTag(R.drawable.dinner);
                        likeImageView.setImageResource(R.drawable.dinner);

                        Toast.makeText(getActivity(),titleTextView.getText()+" added to favourites",Toast.LENGTH_SHORT).show();

                    }else{

                        likeImageView.setTag(R.drawable.dinner);
                        likeImageView.setImageResource(R.drawable.dinner);
                        Toast.makeText(getActivity(),titleTextView.getText()+" removed from favourites",Toast.LENGTH_SHORT).show();


                    }

                }
            });



            shareImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {






                    Uri imageUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                            "://" + getResources().getResourcePackageName(coverImageView.getId())
                            + '/' + "drawable" + '/' + getResources().getResourceEntryName((int)coverImageView.getTag()));


                    Intent shareIntent = new Intent();
                    shareIntent.setAction(Intent.ACTION_SEND);
                    shareIntent.putExtra(Intent.EXTRA_STREAM,imageUri);
                    shareIntent.setType("image/jpeg");
                    startActivity(Intent.createChooser(shareIntent, getResources().getText(R.string.send_to)));



                }
            });



            */

        }
    }

    public void initializeList() {
        listitems.clear();

        for(int i =0;i<8;i++){


            WonderModel item = new WonderModel();
            item.setCardName(Wonders[i]);
            //item.setImageResourceId(Images[i]);
            item.setIsfav(0);
            item.setIsturned(0);
            listitems.add(item);

        }




    }
}



