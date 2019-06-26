package flag.com.tw.ch05_FoodImgMenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] chk_id = {R.id.chk1, R.id.chk2, R.id.chk3, R.id.chk4, R.id.chk5};
        for(int id : chk_id) ((CheckBox) findViewById(id)).setOnCheckedChangeListener(this);
    }

    /*public void takeOrder(View v){
        CheckBox chk;
        String msg = "";

        int[] id = {R.id.chk1, R.id.chk2, R.id.chk3, R.id.chk4,};

        for(int i : id){
            chk = (CheckBox) findViewById(i);
            if(chk.isChecked()){
                msg += "\n" + chk.getText();
            }
        }

        if(msg.length() > 0){
            msg = "你點的餐點是:" + msg;
        }else
            msg = "請點餐";

        ((TextView) findViewById(R.id.showOrder)).setText(msg);

    }*/

    int items = 0;

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        int visible;
        if(isChecked) {
            items++;
            visible = View.VISIBLE;
        }else{
            items--;
            visible = View.GONE;
        }

        switch (compoundButton.getId()) {
            case R.id.chk1:
                findViewById(R.id.output1).setVisibility(visible);
                break;
            case R.id.chk2:
                findViewById(R.id.output2).setVisibility(visible);
                break;
            case R.id.chk3:
                findViewById(R.id.output3).setVisibility(visible);
                break;
            case R.id.chk4:
                findViewById(R.id.output4).setVisibility(visible);
                break;
            case R.id.chk5:
                findViewById(R.id.output5).setVisibility(visible);
                break;
        }
        String msg;

        if(items > 0) msg = "你點的餐點：";
        else msg = "請點餐";

        ((TextView)findViewById(R.id.showOrder)).setText(msg);
    }
}
