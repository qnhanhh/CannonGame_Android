package vn.fptu.cannongame;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.media.AudioManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainActivityFragment extends Fragment {

    private CannonView cannonView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view=inflater.inflate(R.layout.fragment_main, container, false);

        cannonView=(CannonView) view.findViewById(R.id.cannonView);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        getActivity().setVolumeControlStream(AudioManager.STREAM_MUSIC);
    }

    @Override
    public void onPause(){
        super.onPause();
        cannonView.stopGame();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        cannonView.releaseResources();
    }
}