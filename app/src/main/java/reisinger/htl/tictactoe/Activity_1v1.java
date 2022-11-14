package reisinger.htl.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import reisinger.htl.tictactoe.logic.TicTacToeLogic;

public class Activity_1v1 extends AppCompatActivity implements View.OnClickListener {

    private boolean isP1 = true;

    int counter = 9;

    TextView info;

    TicTacToeLogic tttl = new TicTacToeLogic();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1v1);
        inizialize();
        info = findViewById(R.id.info);
        info.setText(" X ist am Zug! \n Züge ürig: " + counter);
    }

    void inizialize() {
        int[] ids = {R.id.bu1, R.id.bu2, R.id.bu3, R.id.bu4, R.id.bu5, R.id.bu6, R.id.bu7, R.id.bu8, R.id.bu9};
        for (int id : ids) {
            findViewById(id).setOnClickListener(this);
        }
    }



    @Override
    public void onClick(View view) {
        Button b = (Button) view;
        if (!b.getText().equals(" ")) {
            Toast.makeText(getApplicationContext(), "Bereits belegt", Toast.LENGTH_SHORT).show();
            return;
        }
        counter--;
            if (isP1) {
                tttl.newBoard(view.getId(), 'x');
                info.setText(" O ist am Zug! \n Züge ürig: " + counter);
                b.setText("X");
                isP1 = false;
            } else {
                tttl.newBoard(view.getId(), 'o');
                info.setText(" X ist am Zug! \n Züge ürig: " + counter);
                b.setText("O");
                isP1 = true;
            }

            switch (tttl.checkForWin()) {
                case -1:
                    Log.i("MainActivity", "Player 1 wins");
                    Toast.makeText(getApplicationContext(),"X gewinnt!", Toast.LENGTH_SHORT).show();
                    finish();
                    break;
                case 1:
                    Log.i("MainActivity", "Player 2 wins");
                    Toast.makeText(getApplicationContext(),"O gewinnt!", Toast.LENGTH_SHORT).show();
                    finish();
                    break;
                case -2:
                    Log.i("MainActivity", "No win yet");
                    break;
                case -3:
                    Log.i("MainActivity", "Unentschieden");
                    Toast.makeText(getApplicationContext(),"Unentschieden!", Toast.LENGTH_SHORT).show();
                    finish();
                    break;
            }


    }

    void sleep() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}