package io.realm;


public interface UserRealmProxyInterface {
    public int realmGet$id();
    public void realmSet$id(int value);
    public String realmGet$login();
    public void realmSet$login(String value);
    public String realmGet$avatarUrl();
    public void realmSet$avatarUrl(String value);
    public String realmGet$htmlUrl();
    public void realmSet$htmlUrl(String value);
    public String realmGet$type();
    public void realmSet$type(String value);
    public boolean realmGet$siteAdmin();
    public void realmSet$siteAdmin(boolean value);
    public String realmGet$name();
    public void realmSet$name(String value);
    public String realmGet$company();
    public void realmSet$company(String value);
    public String realmGet$blog();
    public void realmSet$blog(String value);
    public String realmGet$location();
    public void realmSet$location(String value);
    public int realmGet$publicRepos();
    public void realmSet$publicRepos(int value);
    public int realmGet$publicGists();
    public void realmSet$publicGists(int value);
    public int realmGet$followers();
    public void realmSet$followers(int value);
    public int realmGet$following();
    public void realmSet$following(int value);
    public String realmGet$createdAt();
    public void realmSet$createdAt(String value);
    public String realmGet$updatedAt();
    public void realmSet$updatedAt(String value);
    public RealmList<com.rxjavasample.data.model.Follower> realmGet$followersList();
    public void realmSet$followersList(RealmList<com.rxjavasample.data.model.Follower> value);
}
