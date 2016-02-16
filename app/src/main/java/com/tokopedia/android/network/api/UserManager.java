package com.tokopedia.android.network.api;

import com.tokopedia.android.network.RestService;
import com.tokopedia.android.service.User;
import com.tokopedia.android.service.response.UserResponse;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by raditya.gumay on 16/02/2016.
 */
public class UserManager {

    private RestService restService;

    public UserManager(RestService restService) {
        this.restService = restService;
    }

    public Observable<User> getUser(String username) {
        return restService.getUser(username)
                .map(new Func1<UserResponse, User>() {
                    @Override
                    public User call(UserResponse userResponse) {
                        User user = new User();
                        user.login = userResponse.login;
                        user.id = userResponse.id;
                        user.url = userResponse.url;
                        user.email = userResponse.email;
                        return user;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
