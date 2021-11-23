package com.example.Cooking;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.Cooking.API.ApiService;
import com.example.Cooking.Class.DanhMuc;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//import com.example.danhmuc.Activity.danhMucConActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link list1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class list1 extends Fragment {
    GridLayout gridLayout;
    View view;
    String localhost = "http://192.168.1.6:8081/image/";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public list1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment list1.
     */
    // TODO: Rename and change types and number of parameters
    public static list1 newInstance(String param1, String param2) {
        list1 fragment = new list1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_list1,container,false);
//        ImageButton imgBtThucUong = (ImageButton) view.findViewById(R.id.imgBtThucUong);
//        imgBtThucUong.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), danhMucConActivity.class);
//                intent.putExtra("thucuong","Thức uống");
//                startActivity(intent);
//            }
//        });
        CallAPIDanhMuc();
       return view;
    }

    private void CallAPIDanhMuc(){
        ApiService.apiService.getDanhMuc().enqueue(new Callback<List<DanhMuc>>() {
            @Override
            public void onResponse(Call<List<DanhMuc>> call, Response<List<DanhMuc>> response) {
                List<DanhMuc> listDM = new ArrayList<>();
                listDM = response.body();
                if(listDM!=null){
                    gridLayout = view.findViewById(R.id.gridLayput1);
                    int soCot = 4;
                    int soDong = 3;
                    for(int i = 1; i<=soDong; i++){

                        for(int j= 1; j<=soCot; j++){
                            int vitri = soCot*(i-1)+j-1;

                            DanhMuc danhMuc = listDM.get(vitri);
                            //LinearLayout bao hình và chữ
                            LinearLayout linearLayoutTong = new LinearLayout(getActivity());
                            LinearLayout.LayoutParams layoutParamsTong = new LinearLayout.LayoutParams(120,140);
                            layoutParamsTong.setMargins(45,0,0,0);
                            linearLayoutTong.setLayoutParams(layoutParamsTong);
                            linearLayoutTong.setOrientation(LinearLayout.VERTICAL);

                            LinearLayout linearLayout = new LinearLayout(getActivity());
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(120,120);
                            linearLayout.setLayoutParams(layoutParams);
                            ImageButton imageButton = new ImageButton(getActivity());
                            Glide.with(getContext()).load(localhost+danhMuc.getAnh()).into(imageButton);
                            imageButton.setScaleType(ImageView.ScaleType.CENTER_CROP);
                            imageButton.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(186,236,248)));
                            linearLayout.addView(imageButton);

                            TextView textView = new TextView(getActivity());
                            textView.setText(danhMuc.getTenDM());
                            textView.setTextSize(8);
                            textView.setTextColor(Color.BLACK);
                            textView.setGravity(Gravity.CENTER);


                            linearLayoutTong.addView(linearLayout);
                            linearLayoutTong.addView(textView);

                            gridLayout.addView(linearLayoutTong);

                            //bắt sự kiện
                            imageButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(getActivity(), danhMucConActivity.class);
                                    String[] listGui = new String[2];
                                    listGui[0] = danhMuc.getTenDM();
                                    listGui[1] = danhMuc.getMaDM();
                                    intent.putExtra("tenDM",listGui);
                                    startActivity(intent);
                                }
                            });
                        }

                    }
                }
            }

            @Override
            public void onFailure(Call<List<DanhMuc>> call, Throwable t) {
                Toast.makeText(getActivity(), "lỗi", Toast.LENGTH_SHORT).show();
            }
        });
    }
}