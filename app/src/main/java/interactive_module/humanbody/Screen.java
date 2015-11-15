package interactive_module.humanbody;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by alvinheng on 11/15/15.
 */
public class Screen extends AppCompatActivity {

    /**
     * Show a string on the screen via Toast.
     *
     * @param msg String
     * @return void
     */

    public void toast (String msg)
    {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show ();
    }

}
