package nitt.paritosh.simplycity.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import nitt.paritosh.simplycity.R;

import java.util.ArrayList;
import java.util.List;



public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {

    List<EndangeredItem> mItems;
    private Context context;
    ProgressBar progressBar;//initialize it as you dud with the imageView
    public String z= "https://www.google.co.in/imgres?imgurl=http%3A%2F%2F4.bp.blogspot.com%2F-XkLr-z5NjJE%2FVN4YRtxidBI%2FAAAAAAAACUU%2F3WrV1t34714%2Fs1600%2F16251-Cheesburger%252BFast%252BFood%252BHD%252BWallpaperz.jpg&imgrefurl=http%3A%2F%2Fsuperwallpaperz.blogspot.com%2F2015%2F02%2F30-best-delicious-food-hd-wallpapers.html&docid=UCZK3Dc0OJgUVM&tbnid=7ggxjuqcgIO0mM%3A&vet=10ahUKEwiXzPWc1sLWAhUaS48KHTFVCRAQMwglKAAwAA..i&w=1600&h=900&bih=690&biw=1396&q=best%20foods%20images%20HD&ved=0ahUKEwiXzPWc1sLWAhUaS48KHTFVCRAQMwglKAAwAA&iact=mrc&uact=8";
    public GridAdapter(Context context)
    {
        super();
        mItems = new ArrayList<EndangeredItem>();
        this.context=  context;

        EndangeredItem nama = new EndangeredItem();

        nama.setName("Cakes");
       // nama.setThumbnail(R.drawable.icon);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Cakes");
       // nama.setThumbnail(R.drawable.icon);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Cakes");
       // nama.setThumbnail(R.drawable.icon);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Cakes");
       // nama.setThumbnail(R.drawable.icon);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Cakes");
       // nama.setThumbnail(R.drawable.icon);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Cakes");
       // nama.setThumbnail(R.drawable.icon);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Cakes");
        //nama.setThumbnail(R.drawable.icon);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Cakes");
        //nama.setThumbnail(R.drawable.icon);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Cakes");
       // nama.setThumbnail(R.drawable.icon);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Cakes");
        //nama.setThumbnail(R.drawable.icon);
        mItems.add(nama);




    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.grid_view, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        //progressBar=(ProgressBar)v.findViewById(R.id.progressBar);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        EndangeredItem nature = mItems.get(i);
        viewHolder.tvspecies.setText(nature.getName());
        //viewHolder.imgThumbnail.setImageResource(nature.getThumbnail());


        //ProgressBar progressBar = (ProgressBar)findViewById() ; //initialize it as you dud with the imageView
        //progressBar.setVisibility(View.VISIBLE);
        Picasso.with(context)
               .load("https://i.ytimg.com/vi/8vJ6yUVnBWA/maxresdefault.jpg")
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .fit()
               .into(viewHolder.imgThumbnail);

              /*  .placeholder(R.drawable.cakes)
                .error(R.drawable.cakes)
               .into(viewHolder.imgThumbnail, new Callback() {
            @Override
            public void onSuccess() {
                progressBar.setVisibility(View.GONE);
            }
            @Override
            public void onError() {
            }
        });
        */
    }

    @Override
    public int getItemCount() {

        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {


        public ImageView imgThumbnail;
        public TextView tvspecies;

        public ViewHolder(View itemView) {
            super(itemView);
            imgThumbnail = (ImageView)itemView.findViewById(R.id.img_thumbnail);
            tvspecies = (TextView)itemView.findViewById(R.id.nama);

        }
    }
}
