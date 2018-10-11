package com.hunt.cn.helloandroidworld.fromstudytoproduct.handle_other_controller_or_event.VPWithFragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hunt.cn.helloandroidworld.R;

public class ThirdFrag extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.vpwf_3f,container,false);
    }
}
