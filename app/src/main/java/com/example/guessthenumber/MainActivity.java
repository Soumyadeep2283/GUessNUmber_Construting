package com.example.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
     public TextView True_Number, hint_1,hint_2,hint_3;
     public TextView result_hot, result_cold,result_correct;
     public static String TAG = MainActivity.class.getName();

     public EditText takeNumber;
     public static int number_to_find,number_tries,nuber_taken, result ;
     public String Value;
     public static final int MAX_NUMBER =100;
     //public static final Random rm = new Random();
     public Button b1;
     public String  number = null;
     public Integer cnv_number = null;
     public Integer number_cold = null;
     public String  cold_number = null;

     
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         takeNumber= findViewById(R.id.et1);
         True_Number=findViewById(R.id.tv1);
         hint_1=findViewById(R.id.hintview1);
         hint_2=findViewById(R.id.hintview2);
         hint_3=findViewById(R.id.hintview3);
         result_hot =findViewById(R.id.Hot);
         result_cold=findViewById(R.id.Cold);
         result_correct=findViewById(R.id.Exact);
         b1= findViewById(R.id.btn1);
         b1.setOnClickListener(this);


         True_Number.setVisibility(View.INVISIBLE);
         result_correct.setVisibility(View.INVISIBLE);
         result_hot.setVisibility(View.INVISIBLE);
         result_cold.setVisibility(View.INVISIBLE);


         //rendomNUmber();
         //compearGuess();


    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btn1 :

                b1.setBackgroundColor(000667);
               // String number = null;
                number = takeNumber.getText().toString();


                try{
                cnv_number= Integer.valueOf(number);
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }



                if(number.equals(""))
                {
                    takeNumber.setError("This Field Can not be Blank");
                    True_Number.setText("UMM Somethin's Wrong");

                }
                else if(cnv_number< 5) {
                    takeNumber.setError("Not Less then 5");
                    True_Number.setText("Put a Number betwwn 5-10");
                }

                else if(cnv_number> 10) {
                    takeNumber.setError("Not More then 10");
                    True_Number.setText("Put a Number betwwn 5-10");
                }
                else {
                        //Toast.makeText(this,"Correct No and Cold No is :-->" ,Toast.LENGTH_LONG).show();
                        rendomNUmber();
                        compearGuess();

                       //Toast.makeText(this,"Number Taken is :-->" +number ,Toast.LENGTH_LONG).show();
                       Log.d(TAG,"The numeber Taken is :"+number);
                       takeNumber.setText("");
                       True_Number.setText("Correct No is :"+Value);
                    }
                break;
        }





    }

    public void rendomNUmber(){
         final Random rm = new Random();
        int low = 5;
        int high = 10;
        int diff = high-low;
        result = rm.nextInt(diff) + low;

        Value = String.valueOf(result);
        True_Number.setText(Value);
        True_Number.setVisibility(View.INVISIBLE);
        Log.d(TAG,"The result value"+ "\n" +Value  );
     }



     public void compearGuess(){

         try{
             number_cold = cnv_number -1 ;
             cold_number = String.valueOf(number_cold);

         }catch (Exception ex){
             ex.printStackTrace();
         }

         if(number.equals(Value)){
             //Toast.makeText(this,"Number Taken is and Value Guessing is :-->" +number +Value ,Toast.LENGTH_LONG).show();

                 nuber_taken = Integer.parseInt(number);
                 number_tries++ ;
                 Toast.makeText(this,"nmer taken and main and cold nmer" +number+ "\n" +Value +"\n" +number_cold ,Toast.LENGTH_LONG).show();

                //True_Number.setText("YES"+Cold_number);
                 True_Number.setVisibility(View.VISIBLE);
                 result_correct.setVisibility(View.VISIBLE);
                 result_hot.setVisibility(View.INVISIBLE);
                 result_cold.setVisibility(View.INVISIBLE);
         }
        else if (number_cold.equals(number))
        {
             //Checking the Cold Number.......
             Toast.makeText(this,"Number Guess is CLOSE :-->" +number+ "\n" +number_cold ,Toast.LENGTH_LONG).show();
             result_hot.setVisibility(View.INVISIBLE);
             result_correct.setVisibility(View.INVISIBLE);
             result_cold.setVisibility(View.VISIBLE);
             True_Number.setVisibility(View.VISIBLE);
        }

         else{
             Toast.makeText(this,"Number Guess is Incorrect :-->" +number + "\n" +Value ,Toast.LENGTH_LONG).show();
             result_hot.setVisibility(View.VISIBLE);
             result_correct.setVisibility(View.INVISIBLE);
             True_Number.setVisibility(View.VISIBLE);
             result_cold.setVisibility(View.INVISIBLE);
            }


     }

}