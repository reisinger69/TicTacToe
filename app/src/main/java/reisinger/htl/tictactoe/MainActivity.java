package reisinger.htl.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import reisinger.htl.tictactoe.logic.MiniMaxLogic;
import reisinger.htl.tictactoe.logic.TicTacToeLogic;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private boolean isP1 = true;

    TicTacToeLogic tttl = new TicTacToeLogic();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = findViewById(R.id.change1v1);
        Button b2 = findViewById(R.id.changeminimax);
        b.setOnClickListener(this);
        b2.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.change1v1) {
            System.out.println("not pressed");
            Intent switchActivityIntent = new Intent(this, Activity_1v1.class);
            startActivity(switchActivityIntent);
        }else {
            System.out.println("pressed");
            Intent switchActivityIntent = new Intent(this, Activity_MiniMax.class);
            startActivity(switchActivityIntent);
        }
    }
}