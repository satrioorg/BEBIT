package bebitmobile.com.bebitmobile.ui.splash;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import bebitmobile.com.bebitmobile.R;
import bebitmobile.com.bebitmobile.ui.BaseActivity;
import bebitmobile.com.bebitmobile.ui.signinup.LoginActivity;
import butterknife.Bind;

/**
 * Modules of bebitmobile.com.bebitmobile.ui.activity
 *
 * @author tunggul.jati
 * @update 24/05/2017
 * ${TAGS}
 * @since 24/05/2017
 */

public class SplashActivity extends BaseActivity {

    /*CONTOH BUTTERKNIFE*/
//    @Bind(R.id.img_bebit)
//    ImageView imgBebit;

    @Override
    protected int getLayout() {
        return R.layout.a_splash;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*CONTOH BUTTERKNIFE*/
//        imgBebit.setVisibility(View.INVISIBLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                mPresenter.getDeviceId(mPresenter.constructGetDeviceIdReq());
                LoginActivity.startActivity((BaseActivity) SplashActivity.this);
                finish();
            }
        },3000);
    }

}
