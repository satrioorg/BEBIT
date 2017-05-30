package bebitmobile.com.bebitmobile.ui.main;

import bebitmobile.com.bebitmobile.R;
import bebitmobile.com.bebitmobile.ui.BaseActivity;
import bebitmobile.com.bebitmobile.ui.BaseDialogFragment;
import butterknife.OnClick;

/**
 * Modules of bebitmobile.com.bebitmobile.ui.main
 *
 * @author tunggul.jati
 * @update 29/05/2017
 * ${TAGS}
 * @since 29/05/2017
 */

public class ResetPassSuccessDialog extends BaseDialogFragment {

    private static final String TAG = "ResetPassSuccessDialog";
    ResetPassActivity mActivity;

    public ResetPassSuccessDialog(){}

    public ResetPassSuccessDialog(ResetPassActivity mActivity) {
        this.mActivity = mActivity;
        show(mActivity.getSupportFragmentManager(), TAG);
    }

    @Override
    protected int getLayout() {
        return R.layout.d_resetpass_success;
    }

    @OnClick(R.id.btn_resetpass_success)
    void klikOk()
    {
        MainActivity.startActivity((BaseActivity) getActivity());
        getActivity().finish();
    }
}
