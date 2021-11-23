package com.example.Cooking.ui.home;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.example.Cooking.API.ApiService;
import com.example.Cooking.ChiTietActivity;
import com.example.Cooking.Class.MonAn;
import com.example.Cooking.FragmentAdapter;
import com.example.Cooking.Photo;
import com.example.Cooking.PhotoAdapter;
import com.example.Cooking.R;
import com.example.Cooking.TimKiemActivity;
import com.example.Cooking.databinding.FragmentTrangChuBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentTrangChuBinding binding;
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private PhotoAdapter photoAdapter;
    private ViewPager2 viewPager2;
    private FragmentAdapter fragmentAdapter;
    private View view1, view2;
    private ImageView imgViewLauThai;
    private ImageButton imgBtSearch;
    private GridLayout gridLayout;
    private String localhost = "http://192.168.1.6:8081/image/";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentTrangChuBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //start slide
        viewPager = root.findViewById(R.id.viewpager);
        circleIndicator = root.findViewById(R.id.circle_indicator);

        photoAdapter = new PhotoAdapter(root.getContext(), getListPhoto());
        viewPager.setAdapter(photoAdapter);

        circleIndicator.setViewPager(viewPager);
        photoAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());
        //end slide

        //start viewpager2
        viewPager2 = root.findViewById(R.id.viewpagerlist);

        FragmentManager fm = getActivity().getSupportFragmentManager();
        fragmentAdapter = new FragmentAdapter(fm, getLifecycle());
        viewPager2.setAdapter(fragmentAdapter);

        view1 = root.findViewById(R.id.scrollIn1);
        view2 = root.findViewById(R.id.scrollIn2);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                if(position==1){
                    view1.setVisibility(View.INVISIBLE);
                    view2.setVisibility(View.VISIBLE);
                }
                else{
                    view1.setVisibility(View.VISIBLE);
                    view2.setVisibility(View.INVISIBLE);
                }

            }
        });
        //end viewpager2

        //Công thức cộng đồng
        ApiService.apiService.getAllMon().enqueue(new Callback<List<MonAn>>() {
            @Override
            public void onResponse(Call<List<MonAn>> call, Response<List<MonAn>> response) {
                List<MonAn> list = new ArrayList<>();
                list = response.body();
                if(list!=null){
                    gridLayout = root.findViewById(R.id.gridLayoutCongDong);
                    int soCot = 3;
                    int soDong = 3;
                    Collections.shuffle(list);
                    for(int i = 1;i<=soDong;i++){
                        for (int j=1; j<= soCot; j++){
                            int vitri = soCot*(i-1)+j-1;
                            MonAn monAn = list.get(vitri);
                            //LinearLayout bao ngoài
                            LinearLayout linearLayoutTong = new LinearLayout(getActivity());
                            LinearLayout.LayoutParams layoutParamsTong = new LinearLayout.LayoutParams(180,LinearLayout.LayoutParams.WRAP_CONTENT);
                            layoutParamsTong.setMargins(45,0,0,0);
                            linearLayoutTong.setLayoutParams(layoutParamsTong);
                            linearLayoutTong.setOrientation(LinearLayout.VERTICAL);

                            //set ảnh
                            LinearLayout linearLayout = new LinearLayout(getActivity());
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,180);
                            linearLayout.setLayoutParams(layoutParams);
                            ImageView imageView = new ImageView(getActivity());
                            Glide.with(getContext()).load(localhost+monAn.getAnh()).into(imageView);
                            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                            linearLayout.addView(imageView);

                            //set tên món và checkbox yêu thích
                            RelativeLayout relativeLayout = new RelativeLayout(getActivity());
                            RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,50);
                            relativeLayout.setLayoutParams(layoutParams1);

                            TextView textView = new TextView(getActivity());
                            textView.setText(monAn.getTenMon());
                            textView.setTextSize(14);
                            textView.setTextColor(Color.BLACK);
                            textView.setLines(2);

                            CheckBox checkBox = new CheckBox(getActivity());
                            checkBox.setButtonDrawable(R.drawable.checkbox_15px);
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                            layoutParams2.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,relativeLayout.getId());
                            checkBox.setLayoutParams(layoutParams2);

                            relativeLayout.addView(textView);
                            relativeLayout.addView(checkBox);

                            //người đăng
                            TextView textView1 = new TextView(getActivity());
                            textView1.setText(monAn.getNguoiDang());
                            textView1.setTextSize(10);
                            textView1.setTextColor(Color.rgb(90,90,90));

                            //giờ
                            TextView textView2 = new TextView(getActivity());
                            textView2.setText("1 gio");
                            textView2.setTextSize(14);
                            textView2.setTextColor(Color.BLACK);

                            linearLayoutTong.addView(linearLayout);
                            linearLayoutTong.addView(relativeLayout);
                            linearLayoutTong.addView(textView1);
                            linearLayoutTong.addView(textView2);

                            gridLayout.addView(linearLayoutTong);
                        }
                    }

                }
            }

            @Override
            public void onFailure(Call<List<MonAn>> call, Throwable t) {
                Toast.makeText(getActivity(), "lỗi", Toast.LENGTH_SHORT).show();
            }
        });

//        imgViewLauThai = root.findViewById(R.id.lauthai);
//        imgViewLauThai.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //getActivity();
//                Context view = root.getContext();
//                Intent intent = new Intent(root.getContext(), ChiTietActivity.class);
//                intent.putExtra("lauthai","Lẩu thái");
//                startActivity(intent);
//            }
//        });

        //start button search
        imgBtSearch = root.findViewById(R.id.imgBtSearch);
        imgBtSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(root.getContext(), TimKiemActivity.class);
                startActivity(intent);
            }
        });
        //end button search



//        final TextView textView = binding.textHome;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    private List<Photo> getListPhoto(){
        List<Photo> list = new ArrayList<>();
        list.add(new Photo(R.drawable.slide1));
        list.add(new Photo(R.drawable.slide2));
        list.add(new Photo(R.drawable.silde3));
        return list;
    }
}