package com.example.malavikaramprasad.guessfour;


import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
//import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

//    private Player1Fragment p1 = new Player1Fragment();
//    private Player2Fragment p2 = new Player2Fragment();
//    private int secretNumber1, secretNumber2;
//    private int player1Moves = 0, player2Moves = 0;
//
//    //maintain if the game is running or not
//    private boolean gameInProgress = false;
//
//    //Handler for UI thread
//    public static Handler myHandler, player1handler, player2handler;
//
//    //Winner TextView
//    TextView winner, player1Number, player2Number;
//
//    //Players thread
//    Thread player1thread, player2thread;
//
//    //Message constants
//    private static final int START_GAME = 1;
//    private static final int GET_NEXT_GUESS = 2;
//    private static final int UPDATE_PLAYER1_GUESS = 3;
//    private static final int UPDATE_PLAYER2_GUESS = 4;
//
//    HashMap<Integer,Integer> correctPos1 = new HashMap<Integer,Integer>();
//    ArrayList<Integer> correctNum1 = new ArrayList<Integer>();
////    ArrayList<Integer> otherNum1 = new ArrayList<Integer>();
//
//    private static final String FGADDED = "fragAdded";
//    private boolean fragAdded = false;
//    Fragment f1;


    @SuppressLint("HandlerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stat_layout);

        //Winner text view
        //winner = findViewById(R.id.textView3);

//        if (savedInstanceState != null) {
//            fragAdded = savedInstanceState.getBoolean(FGADDED);
//            // get the data and store it in variables
//
//            //
//        }

        GraphView graph = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 5),
                new DataPoint(4, 17),
                new DataPoint(5, 5),
                new DataPoint(6, 5),
                new DataPoint(7, 23),
                new DataPoint(8, 18),
                new DataPoint(9, 5),
                new DataPoint(10, 5),
                new DataPoint(11, 7),
                new DataPoint(12, 13),
                new DataPoint(13, 5),
                new DataPoint(14, 3),
                new DataPoint(15, 23),
                new DataPoint(16, 5),
                new DataPoint(17, 2),
                new DataPoint(18, 5),
                new DataPoint(19, 34),
                new DataPoint(20, 2),
                new DataPoint(21, 5),
                new DataPoint(22, 4),
                new DataPoint(23, 6),
        });
        graph.addSeries(series);

        //Create fragments for two players
//        FragmentManager mFragmentManager = getFragmentManager();
//
//        Fragment player1Frag = mFragmentManager.findFragmentById(R.id.player1);
//        Fragment player2Frag = mFragmentManager.findFragmentById(R.id.player2);
//
//
//        if(player1Frag==null && player2Frag == null){
//            FragmentTransaction fragmentTransaction = mFragmentManager
//                    .beginTransaction();
//            fragmentTransaction.replace(R.id.player1, p1);
//            fragmentTransaction.replace(R.id.player2, p2);
//            fragmentTransaction.commit();
//        }
//
//
////        if(f1==null){
////            f1 = new Fragment();
////            getSupportFragmentManager().beginTransaction().replace(R.id.player1, p1).commit();
////            getSupportFragmentManager().beginTransaction().replace(R.id.player2, p2).commit();
////        }
//
//
//        //setLayout();
//
//        //On Start Button click.
////        Button btn = findViewById(R.id.button);
//
////        btn.setOnClickListener(new View.OnClickListener(){
////            @Override
////            public void onClick(View view) {
////                //Reset all values or
////                //Halt the game and reset values
////                if(player1thread!=null && player2thread!=null)
////                    haltGame();
////                resetValues();
////                gameInProgress = true;
////                winner.setText("");
////                //Generate secret sequence and show in UI
////                secretNumber1 = generateNumber();
////                secretNumber2 = generateNumber();
////                player1Number = findViewById(R.id.player1_seq);
////                player2Number = findViewById(R.id.player2_seq);
////                player1Number.setText(String.valueOf("Secret Sequence: "+secretNumber1));
////                player1Number.setTextColor(Color.parseColor("Red"));
////                player2Number.setText(String.valueOf("Secret Sequence: "+secretNumber2));
////                player2Number.setTextColor(Color.parseColor("Purple"));
////
////                //Thread for player1
////                player1thread = new Thread(new Runnable() {
////                    @Override
////                    public void run() {
////                        Looper.prepare();
////                        player1handler = new Handler(){
////                            Message message;
////                            public void handleMessage(Message msg){
////                                switch(msg.what){
////                                    //Send update to UI with the guess
////                                    case GET_NEXT_GUESS:
////                                        message = myHandler.obtainMessage(UPDATE_PLAYER1_GUESS);
////                                        message.arg1 = player1numberGuess();
////                                        myHandler.sendMessage(message);
////                                        break;
////                                    default:
////                                        break;
////                                }
////                            }
////                        };
////                        //Start game initially by player 1
////                        Message message = myHandler.obtainMessage(START_GAME);
////                        myHandler.sendMessage(message);
////                        Looper.loop();
////                    }
////                });
////                player1thread.start();
////                //END - PLayer 1 thread
////
////                //Thread for player2
////                player2thread = new Thread(new Runnable() {
////                   public void run(){
////                        Looper.prepare();
////                        player2handler = new Handler(){
////                            public void handleMessage(Message msg){
////                                Message message;
////                                switch(msg.what){
////                                    //Send update to UI with the guess
////                                    case GET_NEXT_GUESS:
////                                        message = myHandler.obtainMessage(UPDATE_PLAYER2_GUESS);
////                                        message.arg2 = player2numberGuess();
////                                        myHandler.sendMessage(message);
////                                        break;
////                                    default:
////                                        break;
////                                }
////                            }
////                        };
////                        Looper.loop();
////                   }
////                });
////                player2thread.start();
////                //END - PLayer 2 thread
////            }
////        });
//
//        // UI HANDLER
//        myHandler = new Handler(){
//            public void handleMessage(Message message){
//                switch (message.what){
//                    case START_GAME:
//                        //Player 1 starts the game
//                        Message msg1 = player1handler.obtainMessage(GET_NEXT_GUESS);
//                        player1handler.sendMessage(msg1);
//                        break;
//
//                    case UPDATE_PLAYER1_GUESS:
//                        //If 20 moves are done, stop the game and declare draw
//                        if(player2Moves == 20 && player1Moves == 20)
//                        {
//                            haltGame();
//                            //Reset UI fields
//                            resetValues();
//                            winner.setText(R.string.draw_msg);
//                            winner.setBackgroundColor(Color.parseColor("green"));
//                            Log.i("MainActivity", "DRAW!!!");
//                            Toast.makeText(getApplicationContext(), R.string.draw_msg, Toast.LENGTH_LONG).show();
//                            break;
//                        }
//                        //Check if the guess by player 1 is correct
//                        int guess = message.arg1;
//                        if(guess == secretNumber2){
//                            String res = guesses1(guess, secretNumber2);
//                            addDataToScrollView(R.id.scroll1_layout, res);
//                            haltGame();
//                            winner.setText(R.string.player1);
//                            winner.setBackgroundColor(Color.parseColor("Yellow"));
//                            Log.i("MainActivity", "Player 1 WON!!!");
//                            Toast.makeText(getApplicationContext(), R.string.player1wins, Toast.LENGTH_LONG).show();
//                            player1Moves = player2Moves =  0;
//                            break;
//                        }
//                        //Display the details - correct, incorrect and positions
//                        String res = guesses1(guess, secretNumber2);
//                        addDataToScrollView(R.id.scroll1_layout, res);
//
//                        //Sleep 2nd Player for 1.5 sec
//                        player2handler.post(new Runnable() {
//                            @Override
//                            public void run() {
//                                try{
//                                    Thread.sleep(1500);
//                                }
//                                catch (Exception e){
//                                    e.printStackTrace();
//                                }
//                            }
//                        });
//
//                        //Player 2 makes next move
//                        message = player2handler.obtainMessage(GET_NEXT_GUESS);
//                        player2handler.sendMessage(message);
//                        break;
//
//                    case UPDATE_PLAYER2_GUESS:
//                        //If 20 moves are done, stop the game and declare draw
//                        if(player2Moves == 20 && player1Moves == 20)
//                        {
//                            haltGame();
//                            //Reset UI fields
//                            resetValues();
//                            player1Moves = player2Moves =  0;
//                            winner.setText(R.string.draw_msg);
//                            winner.setBackgroundColor(Color.parseColor("green"));
//                            Log.i("MainActivity", "DRAW!!!");
//                            break;
//                        }
//                        int guess2 = message.arg2;
//                        // Check if the guess by player 2 is correct
//                        if(guess2 == secretNumber1){
//                            String res2 = guesses2(guess2, secretNumber1);
//                            addDataToScrollView(R.id.scroll2_layout, res2);
//                            winner.setText(R.string.player2);
//                            winner.setBackgroundColor(Color.parseColor("Yellow"));
//                            Log.i("MainActivity", "Player 2 WON!!!");
//                            haltGame();
//                            player1Moves = player2Moves =  0;
//                            Toast.makeText(getApplicationContext(), R.string.player2wins, Toast.LENGTH_LONG).show();
//                            break;
//                        }
//                        //Display the details - correct, incorrect and positions
//                        String res2 = guesses2(guess2, secretNumber1);
//                        addDataToScrollView(R.id.scroll2_layout, res2);
//
//                        //Sleep 1st Player for 1.5 sec
//                        player1handler.post(new Runnable(){
//                            public void run(){
//                                try{
//                                    Thread.sleep(1500);
//                                }
//                                catch(Exception e){
//                                    e.printStackTrace();
//                                }
//                            }
//                        });
//
//                        //Player 1 makes next move
//                        message = player1handler.obtainMessage(GET_NEXT_GUESS);
//                        player1handler.sendMessage(message);
//                    default:
//                        break;
//                }
//            }
//        };
//        //END - UI handler
//
//    }
//
//    //Reset values when the game ends
//    public void resetValues(){
//        //Reset the secret sequence
//        player1Number = findViewById(R.id.player1_seq);
//        player2Number = findViewById(R.id.player2_seq);
//        player1Number.setText("");
//        player2Number.setText("");
//        //Remove the scroll view layout
//        LinearLayout ll2 = findViewById(R.id.scroll2_layout);
//        ll2.removeAllViews();
//        LinearLayout ll1 = findViewById(R.id.scroll1_layout);
//        ll1.removeAllViews();
//        //Set moves to 0
//        player1Moves = player2Moves =  0;
//    }
//
//    //Add data to scroll view
//    public void addDataToScrollView(int view_id, String displayText){
//        LinearLayout scrollView = findViewById(view_id);
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//        TextView displayTextField = new TextView(this);
//        displayTextField.setLayoutParams(params);
//        //displayTextField.setText(displayText);
//
//        //Spannable code
//        SpannableStringBuilder sb = new SpannableStringBuilder(displayText);
//        ForegroundColorSpan fcs = new ForegroundColorSpan(Color.parseColor("blue"));
//        sb.setSpan(fcs, 0,14, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
//        displayTextField.setText(sb);
//        //spannable code end
//        scrollView.addView(displayTextField);
//    }
//
//    //Player 1 - strategical guessing
//    public int player1numberGuess(){
//        ArrayList<Integer> res= new ArrayList<>();
//        int temp=0;
//        //int semiRes=0;
//        if(correctPos1.size()==0)
//            return generateNumber();
//        else{
//            for(int i=0;i<4;i++){
//                if(correctPos1.containsKey(i))
//                    res.add(correctPos1.get(i));
//                else{
//                    for(int j=0;j<10;j++){
//                        temp = generateRandomDigit();
//                        if(!res.contains(temp) && !correctNum1.contains(temp)) {
//                            res.add(temp);
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//        String result = "";
//        for (Integer val:res) {
//            result += val.toString();
//        }
//        return Integer.parseInt(result);
//    }
//
//    //Player 2 - random guessing
//    public int player2numberGuess(){
//        return generateNumber();
//    }
//
//    //Check if the guess and the secret number are the same
//    //Check the number of correct digits, incorrect digits and the positions.
//    public String guesses1(int num, int secretNumber){
//        int count = 0, rightCount=0;
//        int i=3;
//        int k = num;
//        //Increment the guess count for player2
//        player1Moves++;
//        ArrayList<Integer> secretDigits = new ArrayList<Integer>();
//        int[] numDigit = new int[4];
//        while(num!=0){
//            int x = num % 10;
//            numDigit[i] = x;
//            int y = secretNumber % 10;
//            secretDigits.add(y);
//            if(x==y){
//                count++;
//                correctPos1.put(i,y);
//                correctNum1.add(y);
//            }
//            i--;
//            num = num/10;
//            secretNumber = secretNumber/10;
//        }
////        otherNum1.clear();
//        for(int j=0;j<4;j++){
//            if(secretDigits.contains(numDigit[j])){
//                rightCount++;
////                if(correctNum1.size()>0 && correctNum1.contains(numDigit[j]))
////                    otherNum1.add(numDigit[j]);
//            }
//        }
//
//        return "Guess "+ player1Moves + ": " + k + "\n"+ "Incorrect positions: " + (rightCount-count) + "\n"+ "Correct Positions : " + count
//                                +"\n"+ "Position of correct digit: " + correctPos1.toString()+"\n";
//    }
//
//    public String guesses2(int num, int secretNumber){
//        int count = 0, rightCount=0;
//        HashMap<Integer,Integer> correctPos2 = new HashMap<Integer,Integer>();
//        int i=3;
//        int k = num;
//        //Increment the guess count for player2
//        player2Moves++;
//        ArrayList<Integer> secretDigits = new ArrayList<>();
//        int[] numDigit = new int[4];
//        while(num!=0){
//            int x = num % 10;
//            numDigit[i] = x;
//            int y = secretNumber % 10;
//            secretDigits.add(y);
//            if(x==y){
//                count++;
//                correctPos2.put(i,y);
//            }
//            i--;
//            num = num/10;
//            secretNumber = secretNumber/10;
//        }
//        for(int j=0;j<4;j++){
//            if(secretDigits.contains(numDigit[j]))
//                rightCount++;
//        }
//
//        return "Guess " + player2Moves + ": " +  k + "\n"+ "Incorrect positions: " + (rightCount-count) + "\n"+ "Correct Positions : " + count
//                +"\n"+ "Position of correct digit: " + correctPos2.toString()+ "\n";
//    }
//
//    //Generate 4 digit secret sequence
//    public int generateNumber() {
//        ArrayList<Integer> number = new ArrayList<Integer>();
//        while(number.size()!=4){
//            int temp = generateRandomDigit();
//            if(!number.contains(temp))
//                number.add(temp);
//        }
//
//        String result = "";
//        for (Integer val:number) {
//            result += val.toString();
//        }
//        return Integer.parseInt(result);
//    }
//
//    // generate random digit between 1 - 9
//    public int generateRandomDigit(){
//        Random r = new Random();
//        return r.nextInt(9) + 1;
//    }
//
//    //Stop the game
//    public void haltGame(){
//        //Interrupt the thread
//        player1thread.interrupt();
//        player2thread.interrupt();
//
//        //Remove messages and callback of all handler
//        myHandler.removeCallbacksAndMessages(null);
//        player1handler.removeCallbacksAndMessages(null);
//        player2handler.removeCallbacksAndMessages(null);
//
//        //looper quit
//        player1handler.getLooper().quitSafely();
//        player2handler.getLooper().quitSafely();
//
//        //Void all data
//        correctPos1.clear();
//        correctNum1.clear();
//        gameInProgress = false;
//    }
//
//    public void onSaveInstanceState(Bundle savedInstanceState) {
//        // If present, retain the state
//        super.onSaveInstanceState(savedInstanceState);
//        savedInstanceState.putBoolean(FGADDED, true);
//        // save list of guesses and ans
//        // save secret number
//        // save player moves.
//        // gameInProgress
//    }
//
//    public void onDestroy(){
//        super.onDestroy();
//        haltGame();
//    }
    }
}
