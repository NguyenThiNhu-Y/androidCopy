package com.example.Cooking.ui.notify;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.Cooking.databinding.FragmentTaiKhoanBinding;
import com.example.Cooking.databinding.FragmentThongBaoBinding;

public class NotifyFragment extends Fragment {

    private NotifyViewModel notifyViewModel;
    private FragmentThongBaoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notifyViewModel =
                new ViewModelProvider(this).get(NotifyViewModel.class);

        binding = FragmentThongBaoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textNotifications;
//        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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