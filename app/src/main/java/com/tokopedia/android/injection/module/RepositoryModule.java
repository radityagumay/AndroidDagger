package com.tokopedia.android.injection.module;

import com.tokopedia.android.database.DatabaseRealm;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by raditya.gumay on 23/02/2016.
 */
@Module
public class RepositoryModule {

    @Provides
    @Singleton
    public DatabaseRealm provideDatabaseRealm() {
        return new DatabaseRealm();
    }
}
