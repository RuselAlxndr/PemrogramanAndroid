package com.example.helloworld;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment1 extends Fragment {
    private static final String TAG = "Fragment1";
    public static String MY_FLAG = "MY_FLAG";
    private Button btnStartJob;
    private Button btnCancelJob;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_1, container, false);

        btnStartJob = view.findViewById(R.id.startJob);
        btnCancelJob = view.findViewById(R.id.cancelJob);
        Log.i(TAG, "onCreateView: button: " + btnStartJob);
        Log.i(TAG, "onCreateView: memulai service");
        serviceInit();
        return view;

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void onStartJobService() {
        ComponentName componentName = new ComponentName(requireActivity().getApplicationContext(), MyJobService.class);
        JobInfo info = new JobInfo.Builder(121018, componentName)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                .setPersisted(true)
                .setPeriodic(15 * 60 * 1000)
                .build();
        Log.i(TAG, "onStartJobService: membuat scheduler");

        JobScheduler scheduler = (JobScheduler) requireContext().getSystemService(Context.JOB_SCHEDULER_SERVICE);
        int resultCode = scheduler.schedule(info);
        if (resultCode == JobScheduler.RESULT_SUCCESS) {
            Toast.makeText(requireContext().getApplicationContext()
                    , "Job berhasil dibuat", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(requireContext().getApplicationContext()
                    , "Scheduling failed", Toast.LENGTH_SHORT).show();

        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void onStopJobService() {
        JobScheduler scheduler = (JobScheduler) requireContext().getSystemService(Context.JOB_SCHEDULER_SERVICE);
        scheduler.cancel(121018);
        Log.i(TAG, "onStopJobService: job di hentikan");
        Toast.makeText(requireContext().getApplicationContext()
                , "Service dihentikan", Toast.LENGTH_SHORT).show();
    }

    private void serviceInit() {
        Log.i(TAG, "serviceInit: masuk service init");
        btnStartJob.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {

                onStartJobService();
            }
        });
        btnCancelJob.setOnClickListener((new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {

                onStopJobService();
            }
        }));

    }

}





