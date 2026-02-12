package net.druidlabs.cocapu;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import io.github.andruid929.cocapi.attributes.Troop;
import io.github.andruid929.cocapi.information.Player;
import io.github.andruid929.cocapi.resourcetype.Info;
import io.github.andruid929.cocapi.resourcetype.PlayerInfo;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String playerInfoJsonString = PlayerInfo.getPlayerInfo("");

        Player player = new Player(playerInfoJsonString);

        player.getTrophies();

        Troop numberOne = player.getTroops()[0];
    }
}