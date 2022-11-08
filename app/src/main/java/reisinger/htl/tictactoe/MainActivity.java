package reisinger.htl.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private boolean isP1 = true;

    TicTacToeLogic tttl = new TicTacToeLogic();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inizialize();
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
        if (b.getText().equals(" ")) {
            if (isP1) {
                tttl.newBoard(view.getId(), 'x');
                b.setText("X");
                isP1 = false;
            } else {
                tttl.newBoard(view.getId(), 'o');
                b.setText("O");
                isP1 = true;
            }
            switch (tttl.checkForWin()) {
                case -1:
                    Log.i("MainActivity", "Player 1 wins");
                    break;
                case 1:
                    Log.i("MainActivity", "Player 2 wins");
                    break;
                case -2:
                    Log.i("MainActivity", "No win yet");
                    break;
                case -3:
                    Log.i("MainActivity", "Draw");
                    break;
            }
        }
    }
}