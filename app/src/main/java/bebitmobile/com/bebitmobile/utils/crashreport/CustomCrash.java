package bebitmobile.com.bebitmobile.utils.crashreport;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/**
 * Created by tunggul.jati on 23/11/2016.
 */


public class CustomCrash extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//BUKA INI
        /*setContentView(R.layout.a_custom_error);
        Button restartButton = (Button) findViewById(R.id.error_btnhomepage);
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CustomCrash.this, SplashActivity.class);
                startActivity(i);

            }
        });*/
//BUKA INI

        /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_custom_error);
Button restartButton = (Button) findViewById(R.id.customactivityoncrash_error_activity_restart_button);

        final Class<? extends Activity> restartActivityClass = LibraryCrash.getRestartActivityClassFromIntent(getIntent());

        if (restartActivityClass != null) {
            final Timer t = new Timer();
            t.schedule(new TimerTask() {
                @Override
                public void run() {
                    Intent intent = new Intent(CustomCrash.this, restartActivityClass);
                    LibraryCrash.restartApplicationWithIntent(CustomCrash.this, intent);
                    t.cancel();
                }

            },5000);
        } else {
            restartButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    LibraryCrash.closeApplication(CustomCrash.this);
                }
            });
        }

        Button moreInfoButton = (Button) findViewById(R.id.customactivityoncrash_error_activity_more_info_button);
        moreInfoButton.setVisibility(View.GONE);


//        if (LibraryCrash.isShowErrorDetailsFromIntent(getIntent())) {
//
//            moreInfoButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    //We retrieve all the error data and show it
//
//                    AlertDialog dialog = new AlertDialog.Builder(CustomCrash.this)
//                            .setTitle(R.string.customactivityoncrash_error_activity_error_details_title)
//                            .setMessage(LibraryCrash.getAllErrorDetailsFromIntent(CustomCrash.this, getIntent()))
//                            .setPositiveButton(R.string.customactivityoncrash_error_activity_error_details_close, null)
//                            .setNeutralButton(R.string.customactivityoncrash_error_activity_error_details_copy,
//                                    new DialogInterface.OnClickListener() {
//                                        @Override
//                                        public void onClick(DialogInterface dialog, int which) {
//                                            copyErrorToClipboard();
//                                            Toast.makeText(CustomCrash.this, R.string.customactivityoncrash_error_activity_error_details_copied, Toast.LENGTH_SHORT).show();
//                                        }
//                                    })
//                            .show();
//                    TextView textView = (TextView) dialog.findViewById(android.R.id.message);
//                    textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.customactivityoncrash_error_activity_error_details_text_size));
//                }
//            });
//        } else {
//            moreInfoButton.setVisibility(View.GONE);
//        }

  int CustomCrashDrawableId = LibraryCrash.getDefaultErrorActivityDrawableIdFromIntent(getIntent());
        ImageView errorImageView = ((ImageView) findViewById(R.id.customactivityoncrash_error_activity_image));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            errorImageView.setImageDrawable(getResources().getDrawable(CustomCrashDrawableId, getTheme()));
        } else {
            //noinspection deprecation
            errorImageView.setImageDrawable(getResources().getDrawable(CustomCrashDrawableId));
        }

    }

    private void copyErrorToClipboard() {
String errorInformation =
                LibraryCrash.getAllErrorDetailsFromIntent(CustomCrash.this, getIntent());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText(getString(R.string.customactivityoncrash_error_activity_error_details_clipboard_label), errorInformation);
            clipboard.setPrimaryClip(clip);
        } else {
            //noinspection deprecation
            android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
            clipboard.setText(errorInformation);
        }
*/

    }
}


