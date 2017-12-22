package com.rxjavasample.test.common;

import com.rxjavasample.data.model.Follower;
import com.rxjavasample.data.model.User;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;

public class TestDataFactory {

    public static List<User> makeListUsers(int number) {
        List<User> users = new ArrayList<>();
        for (int c = 0; c < number; c++) {
            users.add(makeUser(c));
        }

        return users;
    }

    public static User makeUser(int id) {
        String uniqueSuffix = String.valueOf(id);

        User user = new User();
        user.setId(id);
        user.setLogin("Login: " + uniqueSuffix);
        user.setAvatarUrl("https://avatars2.githubusercontent.com/u/" + uniqueSuffix + "?v=4");
        user.setHtmlUrl("https://github.com/" + uniqueSuffix);
        user.setType(uniqueSuffix);
        user.setName("Name: " + uniqueSuffix + " Lastname: " + uniqueSuffix);
        user.setCompany("Company: " + uniqueSuffix);
        user.setLocation("Location: " + uniqueSuffix);
        user.setPublicRepos(id);
        user.setFollowers(id);
        user.setFollowing(id);
        user.setFollowersList(makeListFollowers(5));
        return user;
    }

    public static RealmList<Follower> makeListFollowers(int number) {
        List<Follower> followers = new ArrayList<>();
        for(int c = 0; c < number; c++) {
            followers.add(makeFollower(c));
        }

        Follower[] followersArray = followers.toArray(new Follower[followers.size()]);
        return new RealmList<>(followersArray);
    }

    public static Follower makeFollower(int id) {
        String uniqueSuffix = String.valueOf(id);

        Follower follower = new Follower();
        follower.setId(id);
        follower.setLogin("Login: " + uniqueSuffix);
        follower.setAvatarUrl("https://avatars2.githubusercontent.com/u/" + uniqueSuffix + "?v=4");
        return follower;
    }
}