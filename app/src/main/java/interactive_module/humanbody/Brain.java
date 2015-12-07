package interactive_module.humanbody;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by alvinheng on 11/15/15.
 */
public class Brain extends Screen implements View.OnTouchListener {

    private ImageButton slider;
    private ImageButton back;

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.brain);

        ImageView iv = (ImageView) findViewById (R.id.image);
        if (iv != null) {
            iv.setOnTouchListener (this);
        }

        back = (ImageButton) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        slider = (ImageButton) findViewById(R.id.slider_button);
        slider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sliderActivity = new Intent(Brain.this, Slider.class);
                startActivity(sliderActivity);
            }
        });
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}
