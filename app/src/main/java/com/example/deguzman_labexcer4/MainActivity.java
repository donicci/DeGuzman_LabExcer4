package com.example.deguzman_labexcer4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String[] android, version, level, rdate, dbmsg;
    ListView list;
    int[] cLogo = {R.drawable.cupcake, R.drawable.donut,R.drawable.eclair,R.drawable.froyo, R.drawable.gingerbread,R.drawable.honeycomb, R.drawable.icecreamsandwich,
            R.drawable.jellybean, R.drawable.kitkat, R.drawable.lollipop, R.drawable.marshmallow, R.drawable.nougat, R.drawable.oreo, R.drawable.androidpie, R.drawable.androidten};

    ArrayList<Android> androidList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android = getResources().getStringArray(R.array.android);
        version = getResources().getStringArray(R.array.version);
        level = getResources().getStringArray(R.array.level);
        dbmsg = getResources().getStringArray(R.array.dbmsg);
        rdate = getResources().getStringArray(R.array.rdate);
        list = findViewById(R.id.lvColleges);
        for(int i = 0; i < android.length; i++){
            androidList.add(new Android(cLogo[i], android[i], level[i], rdate[i], version[i], dbmsg[i]));
        }
        list = findViewById(R.id.lvColleges);
        AndroidAdapter adapter = new AndroidAdapter(this, R.layout.item ,androidList);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
        // Toast.makeText(this, names[i], Toast.LENGTH_LONG).show();

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle(androidList.get(i).getAndroid());
        dialog.setIcon(androidList.get(i).getLogo());
        dialog.setMessage(androidList.get(i).getDbmsg());
        dialog.setNeutralButton("CLOSE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick (DialogInterface dialog,int which){
                dialog.dismiss();
            }
        });
        dialog.create().show();

    }
}
