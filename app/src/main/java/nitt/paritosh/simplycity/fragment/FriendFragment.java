package nitt.paritosh.simplycity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import nitt.paritosh.simplycity.R;
import nitt.paritosh.simplycity.models.RecyclerViewDataAdapter;
import nitt.paritosh.simplycity.models.SectionDataModel;
import nitt.paritosh.simplycity.models.SingleItemModel;


public class FriendFragment extends Fragment {

    ArrayList<SectionDataModel> allSampleData= new ArrayList<SectionDataModel>();
    RecyclerView my_recycler_view;
    String Types[]={"Stationery","Drafters","Mountboards","Dialy Items","Sports"};

    public FriendFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createDummyData();

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_friend, container, false);
        //FloatingActionButton fab = (FloatingActionButton)view.findViewById(R.id.fab);
        //fab.setOnClickListener(new View.OnClickListener() {
        //   @Override
        //   public void onClick(View view) {
        //     Intent intent = new Intent(getActivity(), TambahTemanActivity.class);
        //    startActivity(intent);
        //}

        // });


       // createDummyData();


        my_recycler_view = (RecyclerView) view.findViewById(R.id.my_recycler_view);

        my_recycler_view.setHasFixedSize(true);

        RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter(getActivity(), allSampleData);

        my_recycler_view.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        my_recycler_view.setAdapter(adapter);


        return view;
    }


    public void createDummyData() {
        for (int i = 0; i <= 4; i++) {

            SectionDataModel dm = new SectionDataModel();

            dm.setHeaderTitle(Types[i]);

            ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();
            for (int j = 0; j <= 5; j++) {
                singleItem.add(new SingleItemModel("Item " + j, "URL " + j));
            }

            dm.setAllItemsInSection(singleItem);

            allSampleData.add(dm);

        }
    }

}
