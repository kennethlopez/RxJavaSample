package com.rxjavasample.data.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.rxjavasample.data.model.fields.FollowerFields;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Follower extends RealmObject implements FollowerFields {
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

    @SerializedName(TYPE)
    @Expose
    private String type;

    @SerializedName(SITE_ADMIN)
    @Expose
    private boolean siteAdmin;

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
}
