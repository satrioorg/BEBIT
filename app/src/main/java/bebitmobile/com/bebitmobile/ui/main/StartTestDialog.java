package bebitmobile.com.bebitmobile.ui.main;

import bebitmobile.com.bebitmobile.R;
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

public class StartTestDialog extends BaseDialogFragment {

    private static final String TAG = "StartTestDialog";
    MainActivity mActivity;

    public StartTestDialog(){}

    public StartTestDialog(MainActivity mActivity) {
        this.mActivity = mActivity;
        show(mActivity.getSupportFragmentManager(), TAG);
    }

    @Override
    protected int getLayout() {
        return R.layout.d_start_test_iq;
    }

    @OnClick(R.id.btn_start_test_no)
    void showDialogAttend()
    {
        dismiss();
    }

    @OnClick(R.id.btn_start_test_yes)
    void showDialogReason()
    {
    }
}
