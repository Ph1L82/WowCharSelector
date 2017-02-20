package cl.philipsoft.wowcharselector.views;

import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import cl.philipsoft.wowcharselector.R;
import cl.philipsoft.wowcharselector.data.Character;
import cl.philipsoft.wowcharselector.data.CharacterMaker;
import cl.philipsoft.wowcharselector.data.Faction;

public class CharacterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);
        final String charFaction = getIntent().getStringExtra("CHOSEN_FACTION");
        final String charRace = getIntent().getStringExtra("CHOSEN_RACE");
        final String charClass = getIntent().getStringExtra("CHOSEN_CLASS");
        final String charName = getIntent().getStringExtra("CHOSEN_NAME");
        Faction faction = new Faction(charFaction);
        final CharacterMaker characterMaker = new CharacterMaker(charName);
        final Character character = new Character(faction, characterMaker.makeCharRace(charRace), characterMaker.makeCharClass(charClass), charName);

        final Character pj = characterMaker.setCharacterBaseStats(character);

        TextView nameTextView = (TextView) findViewById(R.id.charNameTv);
        String charNameTextView = "Nombre: " + charName;
        nameTextView.setText(charNameTextView);
        TextView classTv = (TextView) findViewById(R.id.charClassTv);
        classTv.setText("Clase: " + charClass);
        TextView raceTv = (TextView) findViewById(R.id.charRaceTv);
        raceTv.setText("Raza: " + charRace);

        TextView factionTextView = (TextView) findViewById(R.id.charFactionTv);
        factionTextView.setText("Facción: " + charFaction);
        final SeekBar levelSeekBar = (SeekBar) findViewById(R.id.levelSb);
        final TextView levelTextView = (TextView) findViewById(R.id.levelTv);
        final TextView staminaTextView = (TextView) findViewById(R.id.staminaTv);
        final TextView strengthTextView = (TextView) findViewById(R.id.strengthTv);
        final TextView agilityTextView = (TextView) findViewById(R.id.agilityTv);
        final TextView intellectTextView = (TextView) findViewById(R.id.intellectTv);
        final TextView spiritTextView = (TextView) findViewById(R.id.spiritTv);

        levelSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                levelTextView.setText("Nivel: " + String.valueOf(progress));

                staminaTextView.setText("Stamina: " + String.valueOf(characterMaker.setCharacterLevelStats(character, progress).getStamina()));
                strengthTextView.setText("Strength: " + String.valueOf(characterMaker.setCharacterLevelStats(character, progress).getStrength()));
                intellectTextView.setText("Intellect: " + String.valueOf(characterMaker.setCharacterLevelStats(character, progress).getIntellect()));
                agilityTextView.setText("Agility: " + String.valueOf(characterMaker.setCharacterLevelStats(character, progress).getAgility()));
                spiritTextView.setText("Spirit: " + String.valueOf(characterMaker.setCharacterLevelStats(character, progress).getSpirit()));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Button calcBtn = (Button) findViewById(R.id.calcBtn);
        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Character c = characterMaker.setCharacterBaseStats(pj);
                levelTextView.setText("Nivel: " + String.valueOf(1));

                staminaTextView.setText("Stamina: " + String.valueOf(c.getStamina()));
                strengthTextView.setText("Strength: " + String.valueOf(c.getStrength()));
                intellectTextView.setText("Intellect: " + String.valueOf(c.getIntellect()));
                agilityTextView.setText("Agility: " + String.valueOf(c.getAgility()));
                spiritTextView.setText("Spirit: " + String.valueOf(c.getSpirit()));
                levelSeekBar.setProgress(1);
            }
        });
    }
}
