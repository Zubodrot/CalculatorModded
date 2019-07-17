package example.testprj.calculatormodded;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.Edits;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private TextView uneditableTV;
    private TextView buttonEditableTV;
    private TextView operatorsTV;

    private RadioGroup modeRG;

    private RadioButton mode1_RB;
    private RadioButton mode2_RB;
    private RadioButton mode3_RB;

    private LinearLayout biggestLL;

    private static  boolean pluspressed = false;
    private static  boolean minuspressed = false;
    private static  boolean multiplypressed = false;
    private static  boolean dividepressed = false;

    private static Button[][] buttons = new Button[5][4];
    private static int[][] buttonIds = new int[5][4];
    private static String[][] btn_text = new String[5][4];


    int wrapcontent = LinearLayout.LayoutParams.WRAP_CONTENT;



    private static LinearLayout[] layouts= new LinearLayout[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uneditableTV = findViewById(R.id.tv_closed_text);
        buttonEditableTV = findViewById(R.id.tv_button_editable_text);
        operatorsTV = findViewById(R.id.tv_operator_placement);

        modeRG = findViewById(R.id.rg_mode);

        mode1_RB = findViewById(R.id.rb_1);
        mode2_RB = findViewById(R.id.rb_2);
        mode3_RB = findViewById(R.id.rb_3);

        biggestLL = findViewById(R.id.ll_main);

        btn_text [0][0] = getString(R.string.b00_text);
        btn_text [0][1] = getString(R.string.b01_text);
        btn_text [0][2] = getString(R.string.b02_text);
        btn_text [0][3] = getString(R.string.b03_text);

        btn_text [1][0] = getString(R.string.b10_text);
        btn_text [1][1] = getString(R.string.b11_text);
        btn_text [1][2] = getString(R.string.b12_text);
        btn_text [1][3] = getString(R.string.b13_text);

        btn_text [2][0] = getString(R.string.b20_text);
        btn_text [2][1] = getString(R.string.b21_text);
        btn_text [2][2] = getString(R.string.b22_text);
        btn_text [2][3] = getString(R.string.b23_text);

        btn_text [3][0] = getString(R.string.b30_text);
        btn_text [3][1] = getString(R.string.b31_text);
        btn_text [3][2] = getString(R.string.b32_text);
        btn_text [3][3] = getString(R.string.b33_text);

        btn_text [4][0] = getString(R.string.b40_text);
        btn_text [4][1] = getString(R.string.b41_text);
        btn_text [4][2] = getString(R.string.b42_text);
        btn_text [4][3] = getString(R.string.b43_text);


        lineOfButtonsBuilder(0);
        lineOfButtonsBuilder(1);
        lineOfButtonsBuilder(2);
        lineOfButtonsBuilder(3);
        lineOfButtonsBuilder(4);

        layouts[4].setVisibility(View.INVISIBLE);

        View.OnClickListener RBonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (modeRG.getCheckedRadioButtonId()){
                    case R.id.rb_1:
                        layouts[4].setVisibility(View.INVISIBLE);
                        break;
                    case R.id.rb_2:
                        layouts[4].setVisibility(View.VISIBLE);
                        break;

                }
            }
        };

        mode1_RB.setOnClickListener(RBonClickListener);
        mode2_RB.setOnClickListener(RBonClickListener);
        mode3_RB.setOnClickListener(RBonClickListener);



        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == buttonIds[0][0]) {

                    uneditableTV.setText("");
                    buttonEditableTV.setText("0");
                    operatorsTV.setText("");
                    pluspressed = false;
                    minuspressed = false;
                    multiplypressed = false;
                    dividepressed = false;
                }
                else if (view.getId() == buttonIds[0][1]) {

                    doublePressCheck();
                    operatorsTV.setText("+");
                    pluspressed = true;
                    buttonEditableTV.setText("0");
                }
                else if (view.getId() == buttonIds[0][2]) {

                    doublePressCheck();
                    operatorsTV.setText("-");
                    minuspressed = true;
                    buttonEditableTV.setText("0");
                }
                else if (view.getId() == buttonIds[0][3]) {

                    doublePressCheck();
                    operatorsTV.setText("*");
                    multiplypressed = true;
                    buttonEditableTV.setText("0");
                }
                else if (view.getId() == buttonIds[1][0]) {
                    if (buttonEditableTV.getText().equals("0")) {
                        buttonEditableTV.setText("7");
                    } else {
                        buttonEditableTV.setText(buttonEditableTV.getText() + "7");
                    }
                }
                else if (view.getId() == buttonIds[1][1]) {
                    if (buttonEditableTV.getText().equals("0")) {
                        buttonEditableTV.setText("8");
                    } else {
                        buttonEditableTV.setText(buttonEditableTV.getText() + "8");
                    }
                }
                else if (view.getId() == buttonIds[1][2]) {
                    if (buttonEditableTV.getText().equals("0")) {
                        buttonEditableTV.setText("9");
                    } else {
                        buttonEditableTV.setText(buttonEditableTV.getText() + "9");
                    }
                }
                else if (view.getId() == buttonIds[1][3]) {
                    doublePressCheck();
                    operatorsTV.setText("/");
                    dividepressed = true;
                    buttonEditableTV.setText("0");
                }
                else if (view.getId() == buttonIds[2][0]){

                    if (buttonEditableTV.getText().equals("0")) {
                        buttonEditableTV.setText("4");
                    } else {
                        buttonEditableTV.setText(buttonEditableTV.getText() + "4");
                    }
                }
                else if (view.getId() == buttonIds[2][1]) {
                    if (buttonEditableTV.getText().equals("0")) {
                        buttonEditableTV.setText("5");
                    } else {
                        buttonEditableTV.setText(buttonEditableTV.getText() + "5");
                    }
                }
                else if (view.getId() == buttonIds[2][2]) {
                    if (buttonEditableTV.getText().equals("0")) {
                        buttonEditableTV.setText("6");
                    } else {
                        buttonEditableTV.setText(buttonEditableTV.getText() + "6");
                    }
                }
                else if (view.getId() == buttonIds[2][3]) {
                    if (pluspressed) calculation(1);
                    if (minuspressed) calculation(2);
                    if (multiplypressed) calculation(3);
                    if (dividepressed) calculation(4);
                    buttonEditableTV.setText(uneditableTV.getText());
                    uneditableTV.setText("");
                    operatorsTV.setText("");
                    pluspressed = false;
                    minuspressed = false;
                    multiplypressed = false;
                    dividepressed = false;
                }
                else if (view.getId() == buttonIds[3][0]) {
                    if (buttonEditableTV.getText().equals("0")) {
                        buttonEditableTV.setText("1");
                    } else {
                        buttonEditableTV.setText(buttonEditableTV.getText() + "1");
                    }
                }
                else if (view.getId() == buttonIds[3][1]) {
                    if (buttonEditableTV.getText().equals("0")) {
                        buttonEditableTV.setText("2");
                    } else {
                        buttonEditableTV.setText(buttonEditableTV.getText() + "2");
                    }
                }
                else if (view.getId() == buttonIds[3][2]) {
                    if (buttonEditableTV.getText().equals("0")) {
                        buttonEditableTV.setText("3");
                    } else {
                        buttonEditableTV.setText(buttonEditableTV.getText() + "3");
                    }
                }
                else if (view.getId() == buttonIds[3][3]) {
                    if (buttonEditableTV.getText().equals("0")) {

                    } else {
                        buttonEditableTV.setText(buttonEditableTV.getText() + "0");
                    }
                }
                else if (view.getId() == buttonIds[4][0]){
                    if (buttonEditableTV.getText() != "0"){
                        buttonEditableTV.setText("-" + buttonEditableTV.getText());
                    }
                }
                else if (view.getId() == buttonIds[4][1]){
                    if (Double.parseDouble((String)buttonEditableTV.getText()) < 0){
                        Toast.makeText(getApplicationContext(),"We don't do complex numbers here",Toast.LENGTH_LONG).show();
                    }
                    else if (buttonEditableTV.getText() != "0"){
                        buttonEditableTV.setText(Double.toString(Math
                                .sqrt(Double.parseDouble((String)buttonEditableTV.getText()))));
                    }
                }
                else if (view.getId() == buttonIds[4][2]){
                    if (buttonEditableTV.getText() != "0"){
                        buttonEditableTV.setText(Double
                                .toString(Double.parseDouble((String)buttonEditableTV.getText())
                                        *Double.parseDouble((String)buttonEditableTV.getText())));
                    }
                }
                else if (view.getId() == buttonIds[4][3]){
                    String bEditTV = (String)buttonEditableTV.getText();
                    if (bEditTV.length() == 1){
                        buttonEditableTV.setText("0");
                    }
                    else{
                        bEditTV = bEditTV.substring(0,bEditTV.length()-1);
                        buttonEditableTV.setText(bEditTV);
                    }
                }
            }
        };

        for (int i = 0; i<5;i++)
            for (int j = 0; j<4; j++){
                buttons[i][j].setOnClickListener(onClickListener);
            }

    }



    private  void lineOfButtonsBuilder(int lineNumber){
        int llID = View.generateViewId();
        int bID = 0;
        LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(wrapcontent,wrapcontent);
        layouts[lineNumber] = new LinearLayout(this);
        layouts[lineNumber].setId(llID);
        layouts[lineNumber].setLayoutParams(lParams);
        biggestLL.addView(layouts[lineNumber],lParams);
        layouts[lineNumber].setOrientation(LinearLayout.HORIZONTAL);


        for (int i = 0; i<=3; i++){
            bID = View.generateViewId();
            buttonIds[lineNumber][i]= bID;
            buttons[lineNumber][i] = new Button(this);
            buttons[lineNumber][i].setId(bID);
            buttons[lineNumber][i].setText(btn_text[lineNumber][i]);
            buttons[lineNumber][i].setWidth(wrapcontent);
            buttons[lineNumber][i].setHeight(wrapcontent);
            layouts[lineNumber].addView(buttons[lineNumber][i]);

        }
    }

    private void calculation (int operationNumber){



        double uneditedTextInDouble = Double.parseDouble((String)(uneditableTV.getText()));
        double buttonEditedTextInDouble = Double.parseDouble((String)(buttonEditableTV.getText()));
        double operationResult = uneditedTextInDouble;

        switch (operationNumber){
            case 1:

                operationResult = uneditedTextInDouble + buttonEditedTextInDouble;
                break;
            case 2:
                operationResult = uneditedTextInDouble - buttonEditedTextInDouble;
                break;
            case 3:
                operationResult = uneditedTextInDouble * buttonEditedTextInDouble;
                break;
            case 4:

                if (buttonEditedTextInDouble == 0){

                    Toast.makeText(this,"Can't divide by zero",Toast.LENGTH_LONG)
                            .show();


                }
                else {
                    operationResult = uneditedTextInDouble / buttonEditedTextInDouble;
                }
                break;

        }

        if (operationResult % 1 == 0) {
            uneditableTV.setText(Integer.toString((int)operationResult));
        }
        else {
            uneditableTV.setText(Double.toString(operationResult));
        }
        buttonEditableTV.setText("0");


    }

    private void doublePressCheck(){
        if (pluspressed){
            calculation(1);
        }
        else if (minuspressed){
            calculation(2);
        }
        else if (multiplypressed){
            calculation(3);
        }
        else if (dividepressed){
            calculation(4);
        }
        else {
            uneditableTV.setText(buttonEditableTV.getText());
        }
    }
}
