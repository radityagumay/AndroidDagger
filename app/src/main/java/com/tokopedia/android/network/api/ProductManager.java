package com.tokopedia.android.network.api;

import com.google.common.collect.ImmutableList;
import com.tokopedia.android.network.RestService;
import com.tokopedia.android.service.Repository;
import com.tokopedia.android.service.User;
import com.tokopedia.android.service.response.ProductResponse;
import com.tokopedia.android.service.response.RepositoryResponse;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by raditya.gumay on 16/02/2016.
 */
public class ProductManager {

    private User user;
    private RestService restService;

    public ProductManager(User user,
                          RestService restService) {
        this.user = user;
        this.restService = restService;
    }

    public Observable<ProductResponse> getProductApis() {
        return restService.getProducts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<ImmutableList<Repository>> getUsersRepositories() {
        return restService.getUsersRepositories("jack")
                .map(new Func1<List<RepositoryResponse>, ImmutableList<Repository>>() {
                    @Override
                    public ImmutableList<Repository> call(List<RepositoryResponse> repositoriesListResponse) {
                        final ImmutableList.Builder<Repository> listBuilder = ImmutableList.builder();
                        for (RepositoryResponse repositoryResponse : repositoriesListResponse) {
                            Repository repository = new Repository();
                            repository.id = repositoryResponse.id;
                            repository.name = repositoryResponse.name;
                            repository.url = repositoryResponse.url;
                            listBuilder.add(repository);
                        }
                        return listBuilder.build();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
