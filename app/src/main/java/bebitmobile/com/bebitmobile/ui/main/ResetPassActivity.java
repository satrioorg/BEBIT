package bebitmobile.com.bebitmobile.ui.main;

import android.content.Intent;

import bebitmobile.com.bebitmobile.R;
import bebitmobile.com.bebitmobile.ui.BaseActivity;
import butterknife.OnClick;

/**
 * Modules of bebitmobile.com.bebitmobile.ui.main
 *
 * @author tunggul.jati
 * @update 30/05/2017
 * ${TAGS}
 * @since 30/05/2017
 */

public class ResetPassActivity extends BaseActivity {

    @Override
    protected int getLayout() {
        return R.layout.a_resetpass;
    }

    public static void startActivity(BaseActivity sourceActivity) {
        Intent i = new Intent(sourceActivity, ResetPassActivity.class);
        sourceActivity.startActivity(i);
    }

    @OnClick(R.id.rp_btn_submit)
    void rpSubmit()
    {
        MainActivity.aMain.finish();
        ResetPassSuccessDialog std = new ResetPassSuccessDialog(this);
    }
}
