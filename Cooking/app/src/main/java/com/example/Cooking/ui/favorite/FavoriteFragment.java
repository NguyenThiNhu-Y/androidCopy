package com.example.Cooking.ui.favorite;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.Cooking.R;
import com.example.Cooking.TimKiemActivity;
import com.example.Cooking.databinding.FragmentYeuThichBinding;

public class FavoriteFragment extends Fragment {

    private FavoriteViewModel favoriteViewModel;
    private FragmentYeuThichBinding binding;
    private ImageButton imgBtSearch;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        favoriteViewModel =
                new ViewModelProvider(this).get(FavoriteViewModel.class);

        binding = FragmentYeuThichBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

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



//        final TextView textView = binding.textDashboard;
//        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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
}