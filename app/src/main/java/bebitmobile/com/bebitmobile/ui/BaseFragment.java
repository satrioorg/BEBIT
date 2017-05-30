package bebitmobile.com.bebitmobile.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import bebitmobile.com.bebitmobile.BEBITApplication;
import bebitmobile.com.bebitmobile.data.api.BEBITAPI;
import butterknife.ButterKnife;

/**
 * Created by tunggul.jati on 23/11/2016.
 */

public abstract class BaseFragment extends Fragment {

//    @BindString(R.string.loading)
//    public String LOADING;
//
//    @BindString(R.string.connection_error)
//    public String CONNECTION_ERROR;

    protected abstract int getLayout();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    public void showProgressDialog(String message) {
        ((BaseActivity) getActivity()).showProgressDialog(message);
    }

    public void dismissProgressDialog() {
        ((BaseActivity) getActivity()).dismissProgressDialog();
    }

    public void showToast(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    public BEBITAPI getBaseAPI(){
        return BEBITApplication.getInstance().getWorkAPI();
    }

}
