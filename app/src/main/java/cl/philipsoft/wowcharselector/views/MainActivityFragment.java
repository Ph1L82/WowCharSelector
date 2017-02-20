package cl.philipsoft.wowcharselector.views;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import cl.philipsoft.wowcharselector.R;
import cl.philipsoft.wowcharselector.data.Faction;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);

    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final RadioGroup factionRg = (RadioGroup) view.findViewById(R.id.factionsRg);

        final RadioGroup allianceRacesRg = (RadioGroup) view.findViewById(R.id.racesAllianceRg);

        allianceRacesRg.setEnabled(false);
        allianceRacesRg.setVisibility(View.GONE);

        final RadioGroup hordeRacesRg = (RadioGroup) view.findViewById(R.id.racesHordeRg);

        hordeRacesRg.setEnabled(false);
        hordeRacesRg.setVisibility(View.GONE);

        final Faction faction = new Faction();

        factionRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) view.findViewById(group.getCheckedRadioButtonId());
                RadioButton allianceRb = (RadioButton) view.findViewById(R.id.factionAllianceRb);
                RadioButton hordeRb = (RadioButton) view.findViewById(R.id.factionHordeRb);

                Log.d("CHECK", "onCheckedChanged: " + group.getCheckedRadioButtonId() + " :: " + radioButton.getId());
                if (allianceRb.isChecked()){
                    allianceRacesRg.setEnabled(true);
                    allianceRacesRg.setVisibility(View.VISIBLE);
                    hordeRacesRg.setEnabled(false);
                    hordeRacesRg.setVisibility(View.GONE);
                    faction.setName("Alianza");
                } else if (hordeRb.isChecked()){
                    hordeRacesRg.setEnabled(true);
                    hordeRacesRg.setVisibility(View.VISIBLE);
                    allianceRacesRg.setEnabled(false);
                    allianceRacesRg.setVisibility(View.GONE);
                    faction.setName("Horda");
                }
            }
        });

        hordeRacesRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CHECK", "onCheckedChanged: " + getResources().getResourceEntryName(checkedId));
                Intent intent = new Intent(getContext(), ClassActivity.class);
                String race = getResources().getResourceEntryName(checkedId).replace("race", "");
                race = race.replace("Rb", "");
                intent.putExtra("CHOSEN_FACTION", "Horda");
                intent.putExtra("CHOSEN_RACE", race);
                Log.d("CHECK", "onCheckedChanged: " + race);
                startActivity(intent);
            }
        });
        allianceRacesRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CHECK", "onCheckedChanged: " + getResources().getResourceEntryName(checkedId));
                Intent intent = new Intent(getContext(), ClassActivity.class);
                String race = getResources().getResourceEntryName(checkedId).replace("race", "");
                race = race.replace("Rb", "");
                intent.putExtra("CHOSEN_FACTION", "Alianza");
                intent.putExtra("CHOSEN_RACE", race);
                Log.d("CHECK", "onCheckedChanged: " + race);
                startActivity(intent);
            }
        });
    }
}
