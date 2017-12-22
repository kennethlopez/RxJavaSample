package com.rxjavasample.data.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.rxjavasample.data.model.fields.UserFields;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class User extends RealmObject implements UserFields {
    @PrimaryKey
    @SerializedName(ID)
    @Expose
    private int id;

    @SerializedName(LOGIN)
    @Expose
    private String login;

    @SerializedName(AVATAR_URL)
    @Expose
    private String avatarUrl;

    @SerializedName(HTML_URL)
    @Expose
    private String htmlUrl;

    @SerializedName(TYPE)
    @Expose
    private String type;

    @SerializedName(NAME)
    @Expose
    private String name;

    @SerializedName(COMPANY)
    @Expose
    private String company;

    @SerializedName(LOCATION)
    @Expose
    private String location;

    @SerializedName(PUBLIC_REPOS)
    @Expose
    private int publicRepos;

    @SerializedName(FOLLOWERS)
    @Expose
    private int followers;

    @SerializedName(FOLLOWING)
    @Expose
    private int following;

    private RealmList<Follower> followersList;

    public RealmList<Follower> getFollowersList() {
        return followersList;
    }

    public void setFollowersList(RealmList<Follower> followersList) {
        this.followersList = followersList;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPublicRepos() {
        return publicRepos;
    }

    public void setPublicRepos(int publicRepos) {
        this.publicRepos = publicRepos;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }
}
