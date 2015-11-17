package interactive_module.humanbody;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by alvinheng on 11/16/15.
 */
public class Vessel extends Screen {

    private ImageButton back;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vessel);

        back = (ImageButton) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }
}