package bebitmobile.com.bebitmobile.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import bebitmobile.com.bebitmobile.R;
import bebitmobile.com.bebitmobile.ui.BaseActivity;
import bebitmobile.com.bebitmobile.ui.BaseDialogFragment;
import butterknife.Bind;
import butterknife.OnClick;

/**
 * Modules of bebitmobile.com.bebitmobile.ui.main
 *
 * @author tunggul.jati
 * @update 29/05/2017
 * ${TAGS}
 * @since 29/05/2017
 */

public class EditProfilSuccessDialog extends BaseDialogFragment {

    /*@Bind(R.id.tv_editprofil)
    TextView tvEditProfil;*/

    private static final String TAG = "EditProfilSuccessDialog";
    EditProfilActivity mActivity;
//    private String tvReset = "Reset Password";

    public EditProfilSuccessDialog(){}

    public EditProfilSuccessDialog(EditProfilActivity mActivity) {
        this.mActivity = mActivity;
        show(mActivity.getSupportFragmentManager(), TAG);
    }

    @Override
    protected int getLayout() {
        return R.layout.d_editprofil_success;
    }

    /*@Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tvEditProfil.setText(tvReset);
    }*/

    @OnClick(R.id.btn_editprofil_success)
    void klikOk()
    {
        MainActivity.startActivity((BaseActivity) getActivity());
        getActivity().finish();
    }
}
