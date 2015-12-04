package interactive_module.humanbody;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by alvinheng on 11/15/15.
 */
public class Heart extends Screen {

    private ImageButton back;
    private ImageButton vessel;
    private ImageButton slider;

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.heart);

        slider = (ImageButton) findViewById(R.id.slider_button);
        slider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sliderActivity = new Intent(Heart.this, Slider.class);
                startActivity(sliderActivity);
            }
        });

        back = (ImageButton) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        vessel = (ImageButton) findViewById(R.id.vessel);
        vessel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vesselActivity = new Intent(Heart.this, Vessel.class);
                startActivity(vesselActivity);
            }
        });
    }
}
