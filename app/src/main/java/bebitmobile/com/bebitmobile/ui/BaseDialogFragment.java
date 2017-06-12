package bebitmobile.com.bebitmobile.ui;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import bebitmobile.com.bebitmobile.BEBITApplication;
import bebitmobile.com.bebitmobile.data.api.BEBITAPI;
import butterknife.ButterKnife;

/**
 * Created by tunggul.jati on 23/11/2016.
 */

public abstract class BaseDialogFragment extends DialogFragment {

//    @BindString(R.string.loading)
//    public String LOADING;
//
//    @BindString(R.string.connection_error)
//    public String CONNECTION_ERROR;

    protected abstract int getLayout();

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
        ButterKnife.bind(this, view);
        setCancelable(false);
        return view;
    }

    @Override
    public void onAttach(Context newBase) {
         super.onAttach(newBase);
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