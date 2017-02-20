package cl.philipsoft.wowcharselector.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import cl.philipsoft.wowcharselector.R;

public class ClassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class);
        final String faction = getIntent().getStringExtra("CHOSEN_FACTION");
        final String race = getIntent().getStringExtra("CHOSEN_RACE");

        Button sendBtn = (Button) findViewById(R.id.sendBtn);
        final Intent intent = new Intent(this, CharacterActivity.class);
        final RadioGroup classesRg = (RadioGroup) findViewById(R.id.classesRg);
        final EditText nameEt = (EditText) findViewById(R.id.nameEt);
        classesRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CHECK", "onCheckedChanged: " + getResources().getResourceEntryName(classesRg.getCheckedRadioButtonId()));
            }
        });




        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("CHOSEN_FACTION", faction);
                intent.putExtra("CHOSEN_RACE", race);
                intent.putExtra("CHOSEN_CLASS", getResources().getResourceEntryName(classesRg.getCheckedRadioButtonId()).replace("class",""));
                intent.putExtra("CHOSEN_NAME", nameEt.getText().toString());
                startActivity(intent);
            }
        });
    }


}
