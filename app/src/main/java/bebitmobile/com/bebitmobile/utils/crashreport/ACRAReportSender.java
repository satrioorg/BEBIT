package bebitmobile.com.bebitmobile.utils.crashreport;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.util.Log;
import android.util.Patterns;


import org.acra.ReportField;
import org.acra.collector.CrashReportData;
import org.acra.sender.ReportSender;
import org.acra.sender.ReportSenderException;

import java.util.Date;
import java.util.regex.Pattern;

/**
 * Created by tunggul.jati on 23/11/2016.
 */


public class ACRAReportSender implements ReportSender {
    private String emailUsername ;
    private String emailPassword ;

    Context context;

    public ACRAReportSender(Context context, String emailUsername, String emailPassword) {
        super();
        this.context = context;
        this.emailUsername = emailUsername;
        this.emailPassword = emailPassword;
    }

    @Override
    public void send(CrashReportData crashReportData) throws ReportSenderException {
        // Extract the required data out of the crash report.
        String reportBody = createCrashReport(crashReportData);

        // instantiate the email sender
        GMailSender gMailSender = new GMailSender(emailUsername, emailPassword);

        try {
            // specify your recipients and send the email
            String title;
            title = "CRASH REPORT WorkAttendance";
            gMailSender.sendMail(title, reportBody, emailUsername, "pactera.report@gmail.com,satrio.djati@live.com");

        } catch (Exception e) {
            Log.d("Error Sending email", e.toString());
        }
    }

    private String createCrashReport(CrashReportData report) {
        // I've extracted only basic information.
        // U can add loads more data using the enum ReportField. See below.

        String email_login = System.getProperty("EMAIL_LOGIN", "");
        String email_realm = System.getProperty("EMAIL_REALM", "");
        String gmail = "-";
        if (email_realm.equalsIgnoreCase("")) {
            if (email_login.equalsIgnoreCase("")) {
                Pattern gmailPattern = Patterns.EMAIL_ADDRESS; // API level 8+
                Account[] accounts = AccountManager.get(context).getAccounts();

                for (Account account : accounts) {
                    if (gmailPattern.matcher(account.name).matches()) {
                        gmail = account.name;
                        break;
                    }
                }
            } else {
                gmail = email_login;
            }
        } else {
            gmail = email_realm;
        }

        String user_login = System.getProperty("USERID_LOGIN", "0");
        String user_realm = System.getProperty("USERID_REALM", "0");
        String user;
        if (user_realm.equalsIgnoreCase("0")) {
            if (user_login.equalsIgnoreCase("0")) {
                user = "0";
            } else {
                user = user_login;
            }
        } else {
            user = user_realm;
        }

        String user_type;
        if (user.equals("0")) {
            user_type = "GUEST/DEVICE";
        } else if (user.equals("1")) {
            user_type = "AGENT";
        } else if (user.equals("2")) {
            user_type = "SUB-AGENT";
        } else if (user.equals("3")){
            user_type = "CUSTOMER";
        } else {
            user_type = "UNKNOWN";
        }

        StringBuilder body = new StringBuilder();
        body
                .append("Date : " + new Date().toString())
                .append("\n")
                .append("Email (" +  user_type + ") : " + gmail)
                .append("\n")
                .append("Device : " + report.getProperty(ReportField.BRAND) + "-" + report.getProperty(ReportField.PHONE_MODEL))
                .append("\n")
                .append("Android Version :" + report.getProperty(ReportField.ANDROID_VERSION))
                .append("\n")
                .append("App Version : " + report.getProperty(ReportField.APP_VERSION_CODE))
                .append("\n")
                .append("STACK TRACE : \n" + report.getProperty(ReportField.STACK_TRACE));

        return body.toString();
    }
}

