package interactive_module.humanbody;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class HumanBody extends Screen {

    private ImageButton brain;
    private ImageButton heart;
    private ImageButton pancreas;

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_human_body);

        addButtonListeners();

        toast("Touch the screen to discover where the regions are.");

        ImageView imageview = (ImageView)findViewById(R.id.highlighed);
        final Animation animation = new AlphaAnimation(1, 0); // Change alpha from fully visible to invisible
        animation.setDuration(500); // duration - half a second
        animation.setInterpolator(new LinearInterpolator()); // do not alter animation rate
        animation.setRepeatCount(Animation.INFINITE); // Repeat animation infinitely
        animation.setRepeatMode(Animation.REVERSE); // Reverse animation at the end so the button will fade back in
        imageview.startAnimation(animation);
    }

    public void addButtonListeners() {
        heart = (ImageButton) findViewById(R.id.heart);

        heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent heartActivity = new Intent(HumanBody.this, Heart.class);
                startActivity(heartActivity);
            }
        });
    }

    /**
     * Resume the activity.
     */

    @Override protected void onResume() {
        super.onResume();
/*
        View v  = findViewById (R.id.wglxy_bar);
        if (v != null) {
            Animation anim1 = AnimationUtils.loadAnimation(this, R.anim.fade_in);
            //anim1.setAnimationListener (new StartActivityAfterAnimation (i));
            v.startAnimation (anim1);
        }
*/
    }

    /**
     * Handle a click on the Wglxy views at the bottom.
     *
     */

    public void onClickWglxy (View v) {
        Intent viewIntent = new Intent ("android.intent.action.VIEW",
                Uri.parse("http://double-star.appspot.com/blahti/ds-download.html"));
        startActivity(viewIntent);

    }


/**
 */
// More methods

    /**
     * Get the color from the hotspot image at point x-y.
     *
     */

    public int getHotspotColor (int hotspotId, int x, int y) {
        ImageView img = (ImageView) findViewById (hotspotId);
        if (img == null) {
            Log.d("ImageAreasActivity", "Hot spot image not found");
            return 0;
        } else {
            img.setDrawingCacheEnabled(true);
            Bitmap hotspots = Bitmap.createBitmap(img.getDrawingCache());
            if (hotspots == null) {
                Log.d ("ImageAreasActivity", "Hot spot bitmap was not created");
                return 0;
            } else {
                img.setDrawingCacheEnabled(false);
                return hotspots.getPixel(x, y);
            }
        }
    }
}