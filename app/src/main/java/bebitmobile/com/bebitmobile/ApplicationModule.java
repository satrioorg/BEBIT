package bebitmobile.com.bebitmobile;


import javax.inject.Singleton;

import bebitmobile.com.bebitmobile.ui.main.MainActivity;
import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by tunggul.jati on 23/11/2016.
 */

@Module(injects =
        {       MainActivity.class/*,
                ForgotPasswordFragment.class,
                ForgotPasswordPresenter.class,
                InputTaskFragment.class,
                InputTaskPresenter.class*/}, library = true)
public class ApplicationModule {
    BEBITApplication application;

    public ApplicationModule(BEBITApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Realm provideRealm() {
        Realm realm;
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(application).deleteRealmIfMigrationNeeded().build();
        try {
            realm = Realm.getInstance(realmConfiguration);
        } catch (Exception e) {
            Realm.deleteRealm(realmConfiguration);
            realm = Realm.getInstance(realmConfiguration);
        }
        return realm;
    }
}
