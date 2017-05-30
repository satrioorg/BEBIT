package bebitmobile.com.bebitmobile;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
//import android.support.multidex.MultiDex;
//import android.support.multidex.MultiDex;
import android.util.Base64;
import android.util.Log;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import bebitmobile.com.bebitmobile.data.api.BEBITAPI;
import bebitmobile.com.bebitmobile.data.api.BEBITService;
import bebitmobile.com.bebitmobile.data.pref.AppPrefHelper;
import bebitmobile.com.bebitmobile.data.pref.PrefKey;
import dagger.ObjectGraph;

/**
 * Created by tunggul.jati on 18/10/2016.
 */

public class BEBITApplication extends Application{

    private BEBITService service;

    private static BEBITApplication currentApplication;

    //private final String DEFAULT_BASEURL = "http://";
    private final String DEFAULT_BASEURL = "http://kantorku.esy.es/rest_api/";
                                            /*"http://10.14.1.13/myshop/rest_api/";*/
//                                            "http://10.16.0.18/myshop/rest_api/";
//                                            "http://10.16.0.27/myshop/rest_api/";
    //private final String DEFAULT_BASEURL = "http://";
    private SharedPreferences appSharedPreferences;
    private SharedPreferences ncSharedPreferences;

    private ObjectGraph objectGraph;

    public BEBITApplication(){
        currentApplication = this;
    }

    public static BEBITApplication from(Activity activity)
    {
        return (BEBITApplication) activity.getApplication();
    }


    @Override
    public void onCreate() {
        super.onCreate();

        /*COBA*/
//        LibraryCrash.install(this);
//        ACRA.init(this);
//        ACRAReportSender reportSender = new ACRAReportSender(getBaseContext(), "tunggul.jati@pji-solutions.com", "Pactera25");
//        ACRA.getErrorReporter().setReportSender(reportSender);

        /*Coba*/
        /*RealmConfiguration realmConfiguration = new RealmConfiguration
                .Builder(this)
                .name("RDB_"+getPackageName()+".realm")
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);*/
        /*Coba*/

//        getKeyHash();
//        FacebookSdk.sdkInitialize(getApplicationContext());
//        AppEventsLogger.activateApp(this);
        setupAppSharedPreferences();
        //Const.bus = new MainThreadBus();
        currentApplication=this;
        Object prodModule = new ApplicationModule(this);
        objectGraph = ObjectGraph.create(prodModule);
        String Baseurl = AppPrefHelper.getString(PrefKey.BASE_URL);
        Baseurl = Baseurl == "" ? DEFAULT_BASEURL : Baseurl;
        AppPrefHelper.setString(PrefKey.BASE_URL, Baseurl);

        updateService();

    }

    public static synchronized BEBITApplication getInstance(){return currentApplication;}

    public void updateService(){
        service = null;
        service = new BEBITService(AppPrefHelper.getString(PrefKey.BASE_URL));

    }

    public ObjectGraph objectGraph() {
        return objectGraph;
    }

    public void inject(Object o) {
        objectGraph.inject(o);
    }

    public static BEBITApplication get(Context context)
    {
        return (BEBITApplication) context.getApplicationContext();
    }

    private void setupAppSharedPreferences(){
        this.appSharedPreferences = getSharedPreferences(BEBITApplication.class.getSimpleName(), Context.MODE_PRIVATE);
        this.ncSharedPreferences = getSharedPreferences(BEBITApplication.class.getSimpleName()+"_NC",
                Context.MODE_PRIVATE);
    }

    public SharedPreferences getAppSharedPreferences(){
        return appSharedPreferences;
    }
    public SharedPreferences getNcSharedPreferences() {
        return ncSharedPreferences;
    }
    public BEBITAPI getWorkAPI()
    {
        return service.getApi();
    }

    /*@Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }*/

    private void getKeyHash() {

        PackageInfo info;
        try {
            info = getPackageManager().getPackageInfo("com.", PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md;
                md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String something = new String(Base64.encode(md.digest(), 0));
                //String something = new String(Base64.encodeBytes(md.digest()));
                Log.e("hash key", something);
            }
        } catch (PackageManager.NameNotFoundException e1) {
            Log.e("name not found", e1.toString());
        } catch (NoSuchAlgorithmException e) {
            Log.e("no such an algorithm", e.toString());
        } catch (Exception e) {
            Log.e("exception", e.toString());
        }
    }
}
