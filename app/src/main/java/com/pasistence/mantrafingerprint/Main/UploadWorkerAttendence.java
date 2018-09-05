package com.pasistence.mantrafingerprint.Main;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mancj.materialsearchbar.MaterialSearchBar;
import com.pasistence.mantrafingerprint.Adapter.SearchAdapter;
import com.pasistence.mantrafingerprint.Adapter.WorkerAteendenceAdapter;
import com.pasistence.mantrafingerprint.Adapter.WorkerUploadAdapter;
import com.pasistence.mantrafingerprint.Models.APIResponseModels.Attendance;
import com.pasistence.mantrafingerprint.Models.WorkerModel;
import com.pasistence.mantrafingerprint.R;
import com.pasistence.mantrafingerprint.database.Database;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class UploadWorkerAttendence extends AppCompatActivity {
    private static final String TAG = "workerdetails -->";
    RecyclerView WorkerAttendenceListRecyclerView;
    RecyclerView.LayoutManager layoutupload;
    SearchAdapter adapter;
    Button btnUpload;

    Context mContext;
    WorkerAteendenceAdapter workerAteendenceAdapter;
    Database database;

    List<Attendance> attendanceList;


    MaterialSearchBar materialAttendenceSearchBar;
    List<String> suggestList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_worker_attendence);

        mInit();

        attendanceList = new Database(mContext).getallTempAttendace();

        workerAteendenceAdapter = new WorkerAteendenceAdapter(UploadWorkerAttendence.this, attendanceList);
        WorkerAttendenceListRecyclerView.setAdapter(workerAteendenceAdapter);
        workerAteendenceAdapter.notifyDataSetChanged();


        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadAllAttendanceData(attendanceList);
            }
        });
    }

    private void uploadAllAttendanceData(List<Attendance> attendanceList) {
        //JSONArray jsArray = new JSONArray(workerList);
       // Gson gson = new GsonBuilder().setPrettyPrinting().create();
        //String json = gson.toJson(attendanceList);
        String stringToPost = new Gson().toJson(attendanceList);
        //String joint = "worker :";
        Log.e(TAG, stringToPost.toString() );
       // System.out.println(json);
    }

    private void mInit() {

        mContext = UploadWorkerAttendence.this;

        WorkerAttendenceListRecyclerView = (RecyclerView) findViewById(R.id.workerattendence_recycler);
        WorkerAttendenceListRecyclerView.setHasFixedSize(true);
        layoutupload = new LinearLayoutManager(mContext);
        WorkerAttendenceListRecyclerView.setLayoutManager(layoutupload);
        materialAttendenceSearchBar = (MaterialSearchBar) findViewById(R.id.workerAttendence_searchBar);
        btnUpload = (Button)findViewById(R.id.btn_submit_upload) ;

        //Init DB
        database = new Database(this);


        //Setup search bar
        materialAttendenceSearchBar.setHint("Search");
        materialAttendenceSearchBar.setCardViewElevation(10);

        loadSuggestList();
        materialAttendenceSearchBar.addTextChangeListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                List<String> suggest = new ArrayList<>();
                for (String search : suggestList) {
                    if (search.toLowerCase().contains(materialAttendenceSearchBar.getText().toLowerCase()))
                        suggest.add(search);
                }
                materialAttendenceSearchBar.setLastSuggestions(suggest);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        materialAttendenceSearchBar.setOnSearchActionListener(new MaterialSearchBar.OnSearchActionListener() {
            @Override
            public void onSearchStateChanged(boolean enabled) {
                if (!enabled) {
                    WorkerAttendenceListRecyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onSearchConfirmed(CharSequence text) {
                startSearch(text.toString());
            }

            @Override
            public void onButtonClicked(int buttonCode) {

            }
        });

        //Init Adapter default set all result
        adapter = new SearchAdapter(UploadWorkerAttendence.this, this, database.getAllWorkers());
        WorkerAttendenceListRecyclerView.setAdapter(adapter);

    }

    private void startSearch(String text) {
        adapter = new SearchAdapter(UploadWorkerAttendence.this, this, database.getWorkerName(text));
        WorkerAttendenceListRecyclerView.setAdapter(adapter);
    }

    private void loadSuggestList() {
        suggestList = database.getNames();
        materialAttendenceSearchBar.setLastSuggestions(suggestList);
    }

}

