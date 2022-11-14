package reisinger.htl.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import reisinger.htl.tictactoe.logic.MiniMaxLogic;
import reisinger.htl.tictactoe.logic.Move;
import reisinger.htl.tictactoe.logic.TicTacToeLogic;

public class Activity_MiniMax extends AppCompatActivity implements View.OnClickListener {

    private boolean isP1 = true;

    ArrayList<Button> buttonList;

    int counter = 9;

    TextView info;

    MiniMaxLogic mml = new MiniMaxLogic();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1v1);
        buttonList = new ArrayList<>();
        inizialize();
        info = findViewById(R.id.info);
        info.setText("Züge ürig: " + counter);

    }

    void inizialize() {
        int[] ids = {R.id.bu1, R.id.bu2, R.id.bu3, R.id.bu4, R.id.bu5, R.id.bu6, R.id.bu7, R.id.bu8, R.id.bu9};
        for (int id : ids) {
            buttonList.add(findViewById(id));
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
        info.setText("Züge ürig: " + counter);
        b.setText("X");
        mml.play(view.getId());
        if (checkwin()) {
            counter--;
            Move bestMove = mml.findBestMove();
            Button b2 = findViewById(getButtonId(bestMove));
            b2.setText("O");

            checkwin();
        }
    }

    boolean checkwin() {
        switch (mml.checkForWin(counter)) {
            case -1:
                Log.i("MainActivity", "You win");
                Toast.makeText(getApplicationContext(),"Du hast gewonnen!", Toast.LENGTH_LONG).show();
                finish();
                return false;
            case 1:
                Log.i("MainActivity", "You lose");
                Toast.makeText(getApplicationContext(),"Ou hast verloren!", Toast.LENGTH_LONG).show();
                finish();
                return false;
            case -2:
                Log.i("MainActivity", "No win yet");
                return true;
            case -3:
                Log.i("MainActivity", "Unentschieden");
                Toast.makeText(getApplicationContext(),"Unentschieden!", Toast.LENGTH_SHORT).show();
                finish();
                return false;
        }
        return true;
    }



    int getButtonId(Move bestMove) {
        System.out.println(bestMove.toString());
        if (bestMove.getX() == 0 && bestMove.getY() == 0) {
            System.out.println("placing in 0/0");
            return R.id.bu1;
        } else if(bestMove.getX() == 0 && bestMove.getY() == 1) {
            System.out.println("placing in 1/0");
            return R.id.bu2;
        } else if(bestMove.getX() == 0 && bestMove.getY() == 2) {
            System.out.println("placing in 2/0");
            return R.id.bu3;
        } else if(bestMove.getX() == 1 && bestMove.getY() == 0) {
            System.out.println("placing in 0/1");
            return R.id.bu4;
        } else if(bestMove.getX() == 1 && bestMove.getY() == 1) {
            System.out.println("placing in 1/1");
            return R.id.bu5;
        } else if(bestMove.getX() == 1 && bestMove.getY() == 2) {
            System.out.println("placing in 2/0");
            return R.id.bu6;
        } else if(bestMove.getX() == 2 && bestMove.getY() == 0) {
            System.out.println("placing in 2/1");
            return R.id.bu7;
        } else if(bestMove.getX() == 2 && bestMove.getY() == 1) {
            System.out.println("placing in 2/2");
            return R.id.bu8;
        }else{
            return R.id.bu9;
        }
    }

}