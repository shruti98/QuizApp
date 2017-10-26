package com.example.android.project1quiz;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.name;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static android.widget.Toast.makeText;
import static com.example.android.project1quiz.R.id.rg_r9;
import static com.example.android.project1quiz.R.string.email;
import static com.example.android.project1quiz.R.string.score;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int total = 0;
    RadioButton q1, q2, q3, q4, q5, q6, q7, q8, q9;
    CheckBox q10a, q10b, q10c;
    EditText q11;

    void correct() {
        total++;
    }

    public void check(View view) {
        q1 = (RadioButton) findViewById(R.id.rb_q1_angler_fish);
        if (q1.isChecked()) {
            correct();
            q1.setBackgroundColor(Color.parseColor("#9CCC65"));
        }
        q2 = (RadioButton) findViewById(R.id.rb_q2_box_jellyfish);
        if (q2.isChecked()) {
            correct();
            q2.setBackgroundColor(Color.parseColor("#9CCC65"));
        }
        q3 = (RadioButton) findViewById(R.id.rb_q3_intestine);
        if (q3.isChecked()) {
            q3.setBackgroundColor(Color.parseColor("#9CCC65"));
            correct();
        }
        q4 = (RadioButton) findViewById(R.id.rb_q4_3hearts);
        if (q4.isChecked()) {
            correct();
            q4.setBackgroundColor(Color.parseColor("#9CCC65"));
        }
        q5 = (RadioButton) findViewById(R.id.rb_q5_fever_of_rays);
        if (q5.isChecked()) {
            correct();
            q5.setBackgroundColor(Color.parseColor("#9CCC65"));
        }
        q6 = (RadioButton) findViewById(R.id.rb_q6_cartilage);
        if (q6.isChecked()) {
            q6.setBackgroundColor(Color.parseColor("#9CCC65"));
            correct();
        }
        q7 = (RadioButton) findViewById(R.id.rb_q7_colossal_squid);
        if (q7.isChecked()) {
            correct();
            q7.setBackgroundColor(Color.parseColor("#9CCC65"));
        }
        q8 = (RadioButton) findViewById(R.id.rb_q8_jellyfish);
        if (q8.isChecked()) {
            correct();
            q8.setBackgroundColor(Color.parseColor("#9CCC65"));
        }
        q9 = (RadioButton) findViewById(R.id.rb_q9_orca);
        if (q9.isChecked()) {
            correct();
            q9.setBackgroundColor(Color.parseColor("#9CCC65"));
        }

        q10a = (CheckBox) findViewById(R.id.cb_q10_hammer_head);
        q10b = (CheckBox) findViewById(R.id.cb_q10_sand_shark);
        q10c = (CheckBox) findViewById(R.id.cb_q10_angel_shark);

        if (q10a.isChecked() && q10b.isChecked() && q10c.isChecked()) {
            correct();
            q10a.setBackgroundColor(Color.parseColor("#9CCC65"));
            q10b.setBackgroundColor(Color.parseColor("#9CCC65"));
            q10c.setBackgroundColor(Color.parseColor("#9CCC65"));
        }

        q11 = (EditText) findViewById(R.id.et_bonus_ans);
        String ans = q11.getText().toString();
        String checkans = getResources().getString(R.string.blue_whale);
        String wrong = getResources().getString(R.string.wrong_ans);

        if (ans.contentEquals(checkans)) {
            correct();
            q11.setTextColor(Color.parseColor("#9CCC65"));
        } else {
            if (!ans.isEmpty()) {
                ans += wrong;
                q11.setText(ans);
            }
        }

        display(total);

    }


    public void reset(View view) {
        total = 0;
        RadioGroup r = (RadioGroup) findViewById(R.id.rg_r9);
        r.clearCheck();
        q1.setBackgroundColor(0);
        r = (RadioGroup) findViewById(R.id.rg_r8);
        r.clearCheck();
        q2.setBackgroundColor(0);
        r = (RadioGroup) findViewById(R.id.rg_r7);
        r.clearCheck();
        q3.setBackgroundColor(0);
        r = (RadioGroup) findViewById(R.id.rg_r6);
        r.clearCheck();
        q4.setBackgroundColor(0);
        r = (RadioGroup) findViewById(R.id.rg_r5);
        r.clearCheck();
        q5.setBackgroundColor(0);
        r = (RadioGroup) findViewById(R.id.rg_r4);
        r.clearCheck();
        q6.setBackgroundColor(0);
        r = (RadioGroup) findViewById(R.id.rg_r3);
        r.clearCheck();
        q7.setBackgroundColor(0);
        r = (RadioGroup) findViewById(R.id.rg_r2);
        r.clearCheck();
        q8.setBackgroundColor(0);
        r = (RadioGroup) findViewById(R.id.rg_r1);
        r.clearCheck();
        q9.setBackgroundColor(0);
        CheckBox c = (CheckBox) findViewById(R.id.cb_q10_hammer_head);
        c.setChecked(false);
        c.setBackgroundColor(0);
        c = (CheckBox) findViewById(R.id.cb_q10_sand_shark);
        c.setChecked(false);
        c.setBackgroundColor(0);
        c = (CheckBox) findViewById(R.id.cb_q10_angel_shark);
        c.setChecked(false);
        c.setBackgroundColor(0);
        q11.setText("");
        q11.setTextColor(Color.BLACK);

    }

    private void display(int x) {

        EditText name=(EditText) findViewById(R.id.et_name);
        String user=name.getText().toString();

        String score = getResources().getString(R.string.score,user,x);
        Toast toast = Toast.makeText(this, score, Toast.LENGTH_LONG);
        toast.show();
        total = 0;

        //getResources().getString(score, x);
        EditText et_email=(EditText) findViewById(R.id.et_email);
        String email=et_email.getText().toString();
        String arr[]={email};

        Intent intent=new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL,arr);
        intent.putExtra(Intent.EXTRA_TEXT,score);
        intent.putExtra(Intent.EXTRA_SUBJECT,getString(R.string.quiz_score));
        if(intent.resolveActivity(getPackageManager())!=null)
            startActivity(intent);

    }


}











