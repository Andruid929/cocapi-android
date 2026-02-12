package net.druidlabs.cocapu;

import android.os.Bundle;
import android.telephony.TelephonyCallback;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.transition.MaterialArcMotion;

import io.github.andruid929.cocapi.information.Player;

public class PlayerInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_player_info);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        MaterialToolbar toolbar = findViewById(R.id.pla_inf_toolbar);

        TextView tagText = findViewById(R.id.pla_inf_tag);
        TextView nameText = findViewById(R.id.pla_inf_name);
        TextView townHallLevelText = findViewById(R.id.pla_inf_town_hall_lvl);
        TextView expLevelText = findViewById(R.id.pla_inf_exp_lvl);
        TextView trophiesText = findViewById(R.id.pla_inf_trophies);

        Player player = new Player("");

        Troop troop = player.getTroops()[0];

        String tag = tagText.getText() + " " + player.getTag(false);
    }
 }