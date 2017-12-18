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

    @SerializedName(SITE_ADMIN)
    @Expose
    private boolean siteAdmin;

    @SerializedName(NAME)
    @Expose
    private String name;

    @SerializedName(COMPANY)
    @Expose
    private String company;

    @SerializedName(BLOG)
    @Expose
    private String blog;

    @SerializedName(LOCATION)
    @Expose
    private String location;

    @SerializedName(PUBLIC_REPOS)
    @Expose
    private int publicRepos;

    @SerializedName(PUBLIC_GIST)
    @Expose
    private int publicGists;

    @SerializedName(FOLLOWERS)
    @Expose
    private int followers;

    @SerializedName(FOLLOWING)
    @Expose
    private int following;

    @SerializedName(CREATED_AT)
    @Expose
    private String createdAt;

    @SerializedName(UPDATED_AT)
    @Expose
    private String updatedAt;

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

    public boolean isSiteAdmin() {
        return siteAdmin;
    }

    public void setSiteAdmin(boolean siteAdmin) {
        this.siteAdmin = siteAdmin;
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

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
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

    public int getPublicGists() {
        return publicGists;
    }

    public void setPublicGists(int publicGists) {
        this.publicGists = publicGists;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
