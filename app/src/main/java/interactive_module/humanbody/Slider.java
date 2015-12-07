package interactive_module.humanbody;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;

public class Slider extends Screen {
    private ImageButton back;
    private SeekBar mSeekBar;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slider);

        back = (ImageButton) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        mSeekBar = (SeekBar) findViewById(R.id.seekBar1);
        mImageView = (ImageView) findViewById(R.id.imageView1);

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                Context context = mImageView.getContext();
                int id = context.getResources().getIdentifier(getImageName(progresValue), "drawable", context.getPackageName());
                mImageView.setImageResource(id);
            }

            public void onStopTrackingTouch(SeekBar seekBar) {}
            public void onStartTrackingTouch(SeekBar seekBar) {}
        });
    }
    static String getImageName(int index)
    {
        index += 1;
        String imageName = "diabetes_animation" + padNumber(index, 4);
        return imageName;
    }
    static String padNumber(int i, int space)
    {
        String padded_output = "" + i;
        int zeros = space;
        while(zeros > 0)
        {
            zeros--;

            i = i / 10;
            if(i == 0)
            {
                break;
            }
        }
        for(int j = 0; j < zeros; j++)
        {
            padded_output = "0" + padded_output;
        }
        return padded_output;
    }
}
