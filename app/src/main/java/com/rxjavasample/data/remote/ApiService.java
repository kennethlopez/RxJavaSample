package com.rxjavasample.data.remote;


import com.rxjavasample.data.model.Follower;
import com.rxjavasample.data.model.User;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("/users/{username}")
    Flowable<User> getUser(
            @Path("username") String username
    );

    @GET("/users/{username}/followers")
    Flowable<List<Follower>> getFollowers(
            @Path("username") String username
    );
}