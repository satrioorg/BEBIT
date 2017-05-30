package bebitmobile.com.bebitmobile.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import bebitmobile.com.bebitmobile.BEBITApplication;
import bebitmobile.com.bebitmobile.R;
import bebitmobile.com.bebitmobile.data.api.BEBITAPI;
import butterknife.ButterKnife;


public abstract class BaseActivity extends AppCompatActivity {

//    @BindString(R.string.loading)
//    public String LOADING;
//
//    @BindString(R.string.connection_error)
//    public String CONNECTION_ERROR;

    private ProgressDialog progressDialog;

    protected abstract int getLayout();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        progressDialog = new ProgressDialog(this, R.style.AppTheme);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        progressDialog.dismiss();
    }

    public void showProgressDialog(String message) {
        progressDialog.setMessage(message);
        progressDialog.show();
    }

    public void dismissProgressDialog() {
        progressDialog.hide();
    }

    public void showToast(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    public BEBITAPI getBaseAPI()
    {
        return BEBITApplication.getInstance().getWorkAPI();
    }

}
