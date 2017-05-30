package bebitmobile.com.bebitmobile.ui.main;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;

import bebitmobile.com.bebitmobile.R;
import bebitmobile.com.bebitmobile.ui.BaseActivity;
import bebitmobile.com.bebitmobile.ui.signinup.LoginActivity;
import butterknife.OnClick;

/**
 * Modules of bebitmobile.com.bebitmobile.ui.main
 *
 * @author tunggul.jati
 * @update 30/05/2017
 * ${TAGS}
 * @since 30/05/2017
 */

public class EditProfilActivity extends BaseActivity {

    @Override
    protected int getLayout() {
        return R.layout.a_edit_profil;
    }

    public static void startActivity(BaseActivity sourceActivity) {
        Intent i = new Intent(sourceActivity, EditProfilActivity.class);
        sourceActivity.startActivity(i);
    }

    @OnClick(R.id.epa_btn_submit)
    void epSubmit()
    {
        MainActivity.aMain.finish();
        EditProfilSuccessDialog std = new EditProfilSuccessDialog(this);
    }
}
