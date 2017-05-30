package bebitmobile.com.bebitmobile.ui.signinup;

import android.content.Intent;

import bebitmobile.com.bebitmobile.R;
import bebitmobile.com.bebitmobile.ui.BaseActivity;
import bebitmobile.com.bebitmobile.ui.main.MainActivity;
import butterknife.OnClick;

/**
 * Modules of bebitmobile.com.bebitmobile.ui.signinup
 *
 * @author tunggul.jati
 * @update 24/05/2017
 * ${TAGS}
 * @since 24/05/2017
 */

public class LoginActivity extends BaseActivity {

    @Override
    protected int getLayout() {
        return R.layout.a_login;
    }

    public static void startActivity(BaseActivity sourceActivity) {
        Intent i = new Intent(sourceActivity, LoginActivity.class);
        sourceActivity.startActivity(i);
    }

    @OnClick(R.id.btn_login)
    void gotoMain()
    {
        MainActivity.startActivity((BaseActivity) LoginActivity.this);
        finish();
    }
}
