package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class UserRealmProxy extends com.rxjavasample.data.model.User
    implements RealmObjectProxy, UserRealmProxyInterface {

    static final class UserColumnInfo extends ColumnInfo {
        long idIndex;
        long loginIndex;
        long avatarUrlIndex;
        long htmlUrlIndex;
        long typeIndex;
        long siteAdminIndex;
        long nameIndex;
        long companyIndex;
        long blogIndex;
        long locationIndex;
        long publicReposIndex;
        long publicGistsIndex;
        long followersIndex;
        long followingIndex;
        long createdAtIndex;
        long updatedAtIndex;
        long followersListIndex;

        UserColumnInfo(OsSchemaInfo schemaInfo) {
            super(17);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("User");
            this.idIndex = addColumnDetails("id", objectSchemaInfo);
            this.loginIndex = addColumnDetails("login", objectSchemaInfo);
            this.avatarUrlIndex = addColumnDetails("avatarUrl", objectSchemaInfo);
            this.htmlUrlIndex = addColumnDetails("htmlUrl", objectSchemaInfo);
            this.typeIndex = addColumnDetails("type", objectSchemaInfo);
            this.siteAdminIndex = addColumnDetails("siteAdmin", objectSchemaInfo);
            this.nameIndex = addColumnDetails("name", objectSchemaInfo);
            this.companyIndex = addColumnDetails("company", objectSchemaInfo);
            this.blogIndex = addColumnDetails("blog", objectSchemaInfo);
            this.locationIndex = addColumnDetails("location", objectSchemaInfo);
            this.publicReposIndex = addColumnDetails("publicRepos", objectSchemaInfo);
            this.publicGistsIndex = addColumnDetails("publicGists", objectSchemaInfo);
            this.followersIndex = addColumnDetails("followers", objectSchemaInfo);
            this.followingIndex = addColumnDetails("following", objectSchemaInfo);
            this.createdAtIndex = addColumnDetails("createdAt", objectSchemaInfo);
            this.updatedAtIndex = addColumnDetails("updatedAt", objectSchemaInfo);
            this.followersListIndex = addColumnDetails("followersList", objectSchemaInfo);
        }

        UserColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new UserColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final UserColumnInfo src = (UserColumnInfo) rawSrc;
            final UserColumnInfo dst = (UserColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.loginIndex = src.loginIndex;
            dst.avatarUrlIndex = src.avatarUrlIndex;
            dst.htmlUrlIndex = src.htmlUrlIndex;
            dst.typeIndex = src.typeIndex;
            dst.siteAdminIndex = src.siteAdminIndex;
            dst.nameIndex = src.nameIndex;
            dst.companyIndex = src.companyIndex;
            dst.blogIndex = src.blogIndex;
            dst.locationIndex = src.locationIndex;
            dst.publicReposIndex = src.publicReposIndex;
            dst.publicGistsIndex = src.publicGistsIndex;
            dst.followersIndex = src.followersIndex;
            dst.followingIndex = src.followingIndex;
            dst.createdAtIndex = src.createdAtIndex;
            dst.updatedAtIndex = src.updatedAtIndex;
            dst.followersListIndex = src.followersListIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(17);
        fieldNames.add("id");
        fieldNames.add("login");
        fieldNames.add("avatarUrl");
        fieldNames.add("htmlUrl");
        fieldNames.add("type");
        fieldNames.add("siteAdmin");
        fieldNames.add("name");
        fieldNames.add("company");
        fieldNames.add("blog");
        fieldNames.add("location");
        fieldNames.add("publicRepos");
        fieldNames.add("publicGists");
        fieldNames.add("followers");
        fieldNames.add("following");
        fieldNames.add("createdAt");
        fieldNames.add("updatedAt");
        fieldNames.add("followersList");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private UserColumnInfo columnInfo;
    private ProxyState<com.rxjavasample.data.model.User> proxyState;
    private RealmList<com.rxjavasample.data.model.Follower> followersListRealmList;

    UserRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (UserColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.rxjavasample.data.model.User>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(int value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$login() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.loginIndex);
    }

    @Override
    public void realmSet$login(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.loginIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.loginIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.loginIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.loginIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$avatarUrl() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.avatarUrlIndex);
    }

    @Override
    public void realmSet$avatarUrl(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.avatarUrlIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.avatarUrlIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.avatarUrlIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.avatarUrlIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$htmlUrl() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.htmlUrlIndex);
    }

    @Override
    public void realmSet$htmlUrl(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.htmlUrlIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.htmlUrlIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.htmlUrlIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.htmlUrlIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$type() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.typeIndex);
    }

    @Override
    public void realmSet$type(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.typeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.typeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.typeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.typeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$siteAdmin() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.siteAdminIndex);
    }

    @Override
    public void realmSet$siteAdmin(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.siteAdminIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.siteAdminIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameIndex);
    }

    @Override
    public void realmSet$name(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$company() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.companyIndex);
    }

    @Override
    public void realmSet$company(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.companyIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.companyIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.companyIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.companyIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$blog() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.blogIndex);
    }

    @Override
    public void realmSet$blog(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.blogIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.blogIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.blogIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.blogIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$location() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.locationIndex);
    }

    @Override
    public void realmSet$location(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.locationIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.locationIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.locationIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.locationIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$publicRepos() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.publicReposIndex);
    }

    @Override
    public void realmSet$publicRepos(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.publicReposIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.publicReposIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$publicGists() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.publicGistsIndex);
    }

    @Override
    public void realmSet$publicGists(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.publicGistsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.publicGistsIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$followers() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.followersIndex);
    }

    @Override
    public void realmSet$followers(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.followersIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.followersIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$following() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.followingIndex);
    }

    @Override
    public void realmSet$following(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.followingIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.followingIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$createdAt() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.createdAtIndex);
    }

    @Override
    public void realmSet$createdAt(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.createdAtIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.createdAtIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.createdAtIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.createdAtIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$updatedAt() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.updatedAtIndex);
    }

    @Override
    public void realmSet$updatedAt(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.updatedAtIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.updatedAtIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.updatedAtIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.updatedAtIndex, value);
    }

    @Override
    public RealmList<com.rxjavasample.data.model.Follower> realmGet$followersList() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (followersListRealmList != null) {
            return followersListRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.followersListIndex);
            followersListRealmList = new RealmList<com.rxjavasample.data.model.Follower>(com.rxjavasample.data.model.Follower.class, osList, proxyState.getRealm$realm());
            return followersListRealmList;
        }
    }

    @Override
    public void realmSet$followersList(RealmList<com.rxjavasample.data.model.Follower> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("followersList")) {
                return;
            }
            // if the list contains unmanaged RealmObjects, convert them to managed.
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.rxjavasample.data.model.Follower> original = value;
                value = new RealmList<com.rxjavasample.data.model.Follower>();
                for (com.rxjavasample.data.model.Follower item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getModelList(columnInfo.followersListIndex);
        // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
        if (value != null && value.size() == osList.size()) {
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.rxjavasample.data.model.Follower linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.setRow(i, ((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        } else {
            osList.removeAll();
            if (value == null) {
                return;
            }
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.rxjavasample.data.model.Follower linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        }
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("User", 17, 0);
        builder.addPersistedProperty("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("login", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("avatarUrl", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("htmlUrl", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("type", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("siteAdmin", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("company", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("blog", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("location", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("publicRepos", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("publicGists", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("followers", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("following", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("createdAt", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("updatedAt", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty("followersList", RealmFieldType.LIST, "Follower");
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static UserColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new UserColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "User";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.rxjavasample.data.model.User createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        com.rxjavasample.data.model.User obj = null;
        if (update) {
            Table table = realm.getTable(com.rxjavasample.data.model.User.class);
            UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.rxjavasample.data.model.User.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.rxjavasample.data.model.User.class), false, Collections.<String> emptyList());
                    obj = new io.realm.UserRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("followersList")) {
                excludeFields.add("followersList");
            }
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.UserRealmProxy) realm.createObjectInternal(com.rxjavasample.data.model.User.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.UserRealmProxy) realm.createObjectInternal(com.rxjavasample.data.model.User.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final UserRealmProxyInterface objProxy = (UserRealmProxyInterface) obj;
        if (json.has("login")) {
            if (json.isNull("login")) {
                objProxy.realmSet$login(null);
            } else {
                objProxy.realmSet$login((String) json.getString("login"));
            }
        }
        if (json.has("avatarUrl")) {
            if (json.isNull("avatarUrl")) {
                objProxy.realmSet$avatarUrl(null);
            } else {
                objProxy.realmSet$avatarUrl((String) json.getString("avatarUrl"));
            }
        }
        if (json.has("htmlUrl")) {
            if (json.isNull("htmlUrl")) {
                objProxy.realmSet$htmlUrl(null);
            } else {
                objProxy.realmSet$htmlUrl((String) json.getString("htmlUrl"));
            }
        }
        if (json.has("type")) {
            if (json.isNull("type")) {
                objProxy.realmSet$type(null);
            } else {
                objProxy.realmSet$type((String) json.getString("type"));
            }
        }
        if (json.has("siteAdmin")) {
            if (json.isNull("siteAdmin")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'siteAdmin' to null.");
            } else {
                objProxy.realmSet$siteAdmin((boolean) json.getBoolean("siteAdmin"));
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                objProxy.realmSet$name(null);
            } else {
                objProxy.realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("company")) {
            if (json.isNull("company")) {
                objProxy.realmSet$company(null);
            } else {
                objProxy.realmSet$company((String) json.getString("company"));
            }
        }
        if (json.has("blog")) {
            if (json.isNull("blog")) {
                objProxy.realmSet$blog(null);
            } else {
                objProxy.realmSet$blog((String) json.getString("blog"));
            }
        }
        if (json.has("location")) {
            if (json.isNull("location")) {
                objProxy.realmSet$location(null);
            } else {
                objProxy.realmSet$location((String) json.getString("location"));
            }
        }
        if (json.has("publicRepos")) {
            if (json.isNull("publicRepos")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'publicRepos' to null.");
            } else {
                objProxy.realmSet$publicRepos((int) json.getInt("publicRepos"));
            }
        }
        if (json.has("publicGists")) {
            if (json.isNull("publicGists")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'publicGists' to null.");
            } else {
                objProxy.realmSet$publicGists((int) json.getInt("publicGists"));
            }
        }
        if (json.has("followers")) {
            if (json.isNull("followers")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'followers' to null.");
            } else {
                objProxy.realmSet$followers((int) json.getInt("followers"));
            }
        }
        if (json.has("following")) {
            if (json.isNull("following")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'following' to null.");
            } else {
                objProxy.realmSet$following((int) json.getInt("following"));
            }
        }
        if (json.has("createdAt")) {
            if (json.isNull("createdAt")) {
                objProxy.realmSet$createdAt(null);
            } else {
                objProxy.realmSet$createdAt((String) json.getString("createdAt"));
            }
        }
        if (json.has("updatedAt")) {
            if (json.isNull("updatedAt")) {
                objProxy.realmSet$updatedAt(null);
            } else {
                objProxy.realmSet$updatedAt((String) json.getString("updatedAt"));
            }
        }
        if (json.has("followersList")) {
            if (json.isNull("followersList")) {
                objProxy.realmSet$followersList(null);
            } else {
                objProxy.realmGet$followersList().clear();
                JSONArray array = json.getJSONArray("followersList");
                for (int i = 0; i < array.length(); i++) {
                    com.rxjavasample.data.model.Follower item = FollowerRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$followersList().add(item);
                }
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.rxjavasample.data.model.User createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.rxjavasample.data.model.User obj = new com.rxjavasample.data.model.User();
        final UserRealmProxyInterface objProxy = (UserRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("login")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$login((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$login(null);
                }
            } else if (name.equals("avatarUrl")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$avatarUrl((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$avatarUrl(null);
                }
            } else if (name.equals("htmlUrl")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$htmlUrl((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$htmlUrl(null);
                }
            } else if (name.equals("type")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$type((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$type(null);
                }
            } else if (name.equals("siteAdmin")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$siteAdmin((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'siteAdmin' to null.");
                }
            } else if (name.equals("name")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$name((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$name(null);
                }
            } else if (name.equals("company")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$company((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$company(null);
                }
            } else if (name.equals("blog")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$blog((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$blog(null);
                }
            } else if (name.equals("location")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$location((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$location(null);
                }
            } else if (name.equals("publicRepos")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$publicRepos((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'publicRepos' to null.");
                }
            } else if (name.equals("publicGists")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$publicGists((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'publicGists' to null.");
                }
            } else if (name.equals("followers")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$followers((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'followers' to null.");
                }
            } else if (name.equals("following")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$following((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'following' to null.");
                }
            } else if (name.equals("createdAt")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$createdAt((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$createdAt(null);
                }
            } else if (name.equals("updatedAt")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$updatedAt((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$updatedAt(null);
                }
            } else if (name.equals("followersList")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$followersList(null);
                } else {
                    objProxy.realmSet$followersList(new RealmList<com.rxjavasample.data.model.Follower>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.rxjavasample.data.model.Follower item = FollowerRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$followersList().add(item);
                    }
                    reader.endArray();
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        return realm.copyToRealm(obj);
    }

    public static com.rxjavasample.data.model.User copyOrUpdate(Realm realm, com.rxjavasample.data.model.User object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.rxjavasample.data.model.User) cachedRealmObject;
        }

        com.rxjavasample.data.model.User realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.rxjavasample.data.model.User.class);
            UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.rxjavasample.data.model.User.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = table.findFirstLong(pkColumnIndex, ((UserRealmProxyInterface) object).realmGet$id());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.rxjavasample.data.model.User.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.UserRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.rxjavasample.data.model.User copy(Realm realm, com.rxjavasample.data.model.User newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.rxjavasample.data.model.User) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.rxjavasample.data.model.User realmObject = realm.createObjectInternal(com.rxjavasample.data.model.User.class, ((UserRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        UserRealmProxyInterface realmObjectSource = (UserRealmProxyInterface) newObject;
        UserRealmProxyInterface realmObjectCopy = (UserRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$login(realmObjectSource.realmGet$login());
        realmObjectCopy.realmSet$avatarUrl(realmObjectSource.realmGet$avatarUrl());
        realmObjectCopy.realmSet$htmlUrl(realmObjectSource.realmGet$htmlUrl());
        realmObjectCopy.realmSet$type(realmObjectSource.realmGet$type());
        realmObjectCopy.realmSet$siteAdmin(realmObjectSource.realmGet$siteAdmin());
        realmObjectCopy.realmSet$name(realmObjectSource.realmGet$name());
        realmObjectCopy.realmSet$company(realmObjectSource.realmGet$company());
        realmObjectCopy.realmSet$blog(realmObjectSource.realmGet$blog());
        realmObjectCopy.realmSet$location(realmObjectSource.realmGet$location());
        realmObjectCopy.realmSet$publicRepos(realmObjectSource.realmGet$publicRepos());
        realmObjectCopy.realmSet$publicGists(realmObjectSource.realmGet$publicGists());
        realmObjectCopy.realmSet$followers(realmObjectSource.realmGet$followers());
        realmObjectCopy.realmSet$following(realmObjectSource.realmGet$following());
        realmObjectCopy.realmSet$createdAt(realmObjectSource.realmGet$createdAt());
        realmObjectCopy.realmSet$updatedAt(realmObjectSource.realmGet$updatedAt());

        RealmList<com.rxjavasample.data.model.Follower> followersListList = realmObjectSource.realmGet$followersList();
        if (followersListList != null) {
            RealmList<com.rxjavasample.data.model.Follower> followersListRealmList = realmObjectCopy.realmGet$followersList();
            followersListRealmList.clear();
            for (int i = 0; i < followersListList.size(); i++) {
                com.rxjavasample.data.model.Follower followersListItem = followersListList.get(i);
                com.rxjavasample.data.model.Follower cachefollowersList = (com.rxjavasample.data.model.Follower) cache.get(followersListItem);
                if (cachefollowersList != null) {
                    followersListRealmList.add(cachefollowersList);
                } else {
                    followersListRealmList.add(FollowerRealmProxy.copyOrUpdate(realm, followersListItem, update, cache));
                }
            }
        }

        return realmObject;
    }

    public static long insert(Realm realm, com.rxjavasample.data.model.User object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.rxjavasample.data.model.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.rxjavasample.data.model.User.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((UserRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((UserRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((UserRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$login = ((UserRealmProxyInterface) object).realmGet$login();
        if (realmGet$login != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.loginIndex, rowIndex, realmGet$login, false);
        }
        String realmGet$avatarUrl = ((UserRealmProxyInterface) object).realmGet$avatarUrl();
        if (realmGet$avatarUrl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.avatarUrlIndex, rowIndex, realmGet$avatarUrl, false);
        }
        String realmGet$htmlUrl = ((UserRealmProxyInterface) object).realmGet$htmlUrl();
        if (realmGet$htmlUrl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.htmlUrlIndex, rowIndex, realmGet$htmlUrl, false);
        }
        String realmGet$type = ((UserRealmProxyInterface) object).realmGet$type();
        if (realmGet$type != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.siteAdminIndex, rowIndex, ((UserRealmProxyInterface) object).realmGet$siteAdmin(), false);
        String realmGet$name = ((UserRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        String realmGet$company = ((UserRealmProxyInterface) object).realmGet$company();
        if (realmGet$company != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.companyIndex, rowIndex, realmGet$company, false);
        }
        String realmGet$blog = ((UserRealmProxyInterface) object).realmGet$blog();
        if (realmGet$blog != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.blogIndex, rowIndex, realmGet$blog, false);
        }
        String realmGet$location = ((UserRealmProxyInterface) object).realmGet$location();
        if (realmGet$location != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.locationIndex, rowIndex, realmGet$location, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.publicReposIndex, rowIndex, ((UserRealmProxyInterface) object).realmGet$publicRepos(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.publicGistsIndex, rowIndex, ((UserRealmProxyInterface) object).realmGet$publicGists(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.followersIndex, rowIndex, ((UserRealmProxyInterface) object).realmGet$followers(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.followingIndex, rowIndex, ((UserRealmProxyInterface) object).realmGet$following(), false);
        String realmGet$createdAt = ((UserRealmProxyInterface) object).realmGet$createdAt();
        if (realmGet$createdAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.createdAtIndex, rowIndex, realmGet$createdAt, false);
        }
        String realmGet$updatedAt = ((UserRealmProxyInterface) object).realmGet$updatedAt();
        if (realmGet$updatedAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, realmGet$updatedAt, false);
        }

        RealmList<com.rxjavasample.data.model.Follower> followersListList = ((UserRealmProxyInterface) object).realmGet$followersList();
        if (followersListList != null) {
            OsList followersListOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.followersListIndex);
            for (com.rxjavasample.data.model.Follower followersListItem : followersListList) {
                Long cacheItemIndexfollowersList = cache.get(followersListItem);
                if (cacheItemIndexfollowersList == null) {
                    cacheItemIndexfollowersList = FollowerRealmProxy.insert(realm, followersListItem, cache);
                }
                followersListOsList.addRow(cacheItemIndexfollowersList);
            }
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.rxjavasample.data.model.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.rxjavasample.data.model.User.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.rxjavasample.data.model.User object = null;
        while (objects.hasNext()) {
            object = (com.rxjavasample.data.model.User) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((UserRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((UserRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((UserRealmProxyInterface) object).realmGet$id());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$login = ((UserRealmProxyInterface) object).realmGet$login();
            if (realmGet$login != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.loginIndex, rowIndex, realmGet$login, false);
            }
            String realmGet$avatarUrl = ((UserRealmProxyInterface) object).realmGet$avatarUrl();
            if (realmGet$avatarUrl != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.avatarUrlIndex, rowIndex, realmGet$avatarUrl, false);
            }
            String realmGet$htmlUrl = ((UserRealmProxyInterface) object).realmGet$htmlUrl();
            if (realmGet$htmlUrl != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.htmlUrlIndex, rowIndex, realmGet$htmlUrl, false);
            }
            String realmGet$type = ((UserRealmProxyInterface) object).realmGet$type();
            if (realmGet$type != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.siteAdminIndex, rowIndex, ((UserRealmProxyInterface) object).realmGet$siteAdmin(), false);
            String realmGet$name = ((UserRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            }
            String realmGet$company = ((UserRealmProxyInterface) object).realmGet$company();
            if (realmGet$company != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.companyIndex, rowIndex, realmGet$company, false);
            }
            String realmGet$blog = ((UserRealmProxyInterface) object).realmGet$blog();
            if (realmGet$blog != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.blogIndex, rowIndex, realmGet$blog, false);
            }
            String realmGet$location = ((UserRealmProxyInterface) object).realmGet$location();
            if (realmGet$location != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.locationIndex, rowIndex, realmGet$location, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.publicReposIndex, rowIndex, ((UserRealmProxyInterface) object).realmGet$publicRepos(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.publicGistsIndex, rowIndex, ((UserRealmProxyInterface) object).realmGet$publicGists(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.followersIndex, rowIndex, ((UserRealmProxyInterface) object).realmGet$followers(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.followingIndex, rowIndex, ((UserRealmProxyInterface) object).realmGet$following(), false);
            String realmGet$createdAt = ((UserRealmProxyInterface) object).realmGet$createdAt();
            if (realmGet$createdAt != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.createdAtIndex, rowIndex, realmGet$createdAt, false);
            }
            String realmGet$updatedAt = ((UserRealmProxyInterface) object).realmGet$updatedAt();
            if (realmGet$updatedAt != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, realmGet$updatedAt, false);
            }

            RealmList<com.rxjavasample.data.model.Follower> followersListList = ((UserRealmProxyInterface) object).realmGet$followersList();
            if (followersListList != null) {
                OsList followersListOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.followersListIndex);
                for (com.rxjavasample.data.model.Follower followersListItem : followersListList) {
                    Long cacheItemIndexfollowersList = cache.get(followersListItem);
                    if (cacheItemIndexfollowersList == null) {
                        cacheItemIndexfollowersList = FollowerRealmProxy.insert(realm, followersListItem, cache);
                    }
                    followersListOsList.addRow(cacheItemIndexfollowersList);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.rxjavasample.data.model.User object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.rxjavasample.data.model.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.rxjavasample.data.model.User.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((UserRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((UserRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((UserRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, rowIndex);
        String realmGet$login = ((UserRealmProxyInterface) object).realmGet$login();
        if (realmGet$login != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.loginIndex, rowIndex, realmGet$login, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.loginIndex, rowIndex, false);
        }
        String realmGet$avatarUrl = ((UserRealmProxyInterface) object).realmGet$avatarUrl();
        if (realmGet$avatarUrl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.avatarUrlIndex, rowIndex, realmGet$avatarUrl, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.avatarUrlIndex, rowIndex, false);
        }
        String realmGet$htmlUrl = ((UserRealmProxyInterface) object).realmGet$htmlUrl();
        if (realmGet$htmlUrl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.htmlUrlIndex, rowIndex, realmGet$htmlUrl, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.htmlUrlIndex, rowIndex, false);
        }
        String realmGet$type = ((UserRealmProxyInterface) object).realmGet$type();
        if (realmGet$type != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.typeIndex, rowIndex, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.siteAdminIndex, rowIndex, ((UserRealmProxyInterface) object).realmGet$siteAdmin(), false);
        String realmGet$name = ((UserRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        String realmGet$company = ((UserRealmProxyInterface) object).realmGet$company();
        if (realmGet$company != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.companyIndex, rowIndex, realmGet$company, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.companyIndex, rowIndex, false);
        }
        String realmGet$blog = ((UserRealmProxyInterface) object).realmGet$blog();
        if (realmGet$blog != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.blogIndex, rowIndex, realmGet$blog, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.blogIndex, rowIndex, false);
        }
        String realmGet$location = ((UserRealmProxyInterface) object).realmGet$location();
        if (realmGet$location != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.locationIndex, rowIndex, realmGet$location, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.locationIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.publicReposIndex, rowIndex, ((UserRealmProxyInterface) object).realmGet$publicRepos(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.publicGistsIndex, rowIndex, ((UserRealmProxyInterface) object).realmGet$publicGists(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.followersIndex, rowIndex, ((UserRealmProxyInterface) object).realmGet$followers(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.followingIndex, rowIndex, ((UserRealmProxyInterface) object).realmGet$following(), false);
        String realmGet$createdAt = ((UserRealmProxyInterface) object).realmGet$createdAt();
        if (realmGet$createdAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.createdAtIndex, rowIndex, realmGet$createdAt, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.createdAtIndex, rowIndex, false);
        }
        String realmGet$updatedAt = ((UserRealmProxyInterface) object).realmGet$updatedAt();
        if (realmGet$updatedAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, realmGet$updatedAt, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, false);
        }

        OsList followersListOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.followersListIndex);
        RealmList<com.rxjavasample.data.model.Follower> followersListList = ((UserRealmProxyInterface) object).realmGet$followersList();
        if (followersListList != null && followersListList.size() == followersListOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = followersListList.size();
            for (int i = 0; i < objects; i++) {
                com.rxjavasample.data.model.Follower followersListItem = followersListList.get(i);
                Long cacheItemIndexfollowersList = cache.get(followersListItem);
                if (cacheItemIndexfollowersList == null) {
                    cacheItemIndexfollowersList = FollowerRealmProxy.insertOrUpdate(realm, followersListItem, cache);
                }
                followersListOsList.setRow(i, cacheItemIndexfollowersList);
            }
        } else {
            followersListOsList.removeAll();
            if (followersListList != null) {
                for (com.rxjavasample.data.model.Follower followersListItem : followersListList) {
                    Long cacheItemIndexfollowersList = cache.get(followersListItem);
                    if (cacheItemIndexfollowersList == null) {
                        cacheItemIndexfollowersList = FollowerRealmProxy.insertOrUpdate(realm, followersListItem, cache);
                    }
                    followersListOsList.addRow(cacheItemIndexfollowersList);
                }
            }
        }

        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.rxjavasample.data.model.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.rxjavasample.data.model.User.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.rxjavasample.data.model.User object = null;
        while (objects.hasNext()) {
            object = (com.rxjavasample.data.model.User) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((UserRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((UserRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((UserRealmProxyInterface) object).realmGet$id());
            }
            cache.put(object, rowIndex);
            String realmGet$login = ((UserRealmProxyInterface) object).realmGet$login();
            if (realmGet$login != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.loginIndex, rowIndex, realmGet$login, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.loginIndex, rowIndex, false);
            }
            String realmGet$avatarUrl = ((UserRealmProxyInterface) object).realmGet$avatarUrl();
            if (realmGet$avatarUrl != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.avatarUrlIndex, rowIndex, realmGet$avatarUrl, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.avatarUrlIndex, rowIndex, false);
            }
            String realmGet$htmlUrl = ((UserRealmProxyInterface) object).realmGet$htmlUrl();
            if (realmGet$htmlUrl != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.htmlUrlIndex, rowIndex, realmGet$htmlUrl, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.htmlUrlIndex, rowIndex, false);
            }
            String realmGet$type = ((UserRealmProxyInterface) object).realmGet$type();
            if (realmGet$type != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.typeIndex, rowIndex, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.siteAdminIndex, rowIndex, ((UserRealmProxyInterface) object).realmGet$siteAdmin(), false);
            String realmGet$name = ((UserRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
            }
            String realmGet$company = ((UserRealmProxyInterface) object).realmGet$company();
            if (realmGet$company != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.companyIndex, rowIndex, realmGet$company, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.companyIndex, rowIndex, false);
            }
            String realmGet$blog = ((UserRealmProxyInterface) object).realmGet$blog();
            if (realmGet$blog != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.blogIndex, rowIndex, realmGet$blog, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.blogIndex, rowIndex, false);
            }
            String realmGet$location = ((UserRealmProxyInterface) object).realmGet$location();
            if (realmGet$location != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.locationIndex, rowIndex, realmGet$location, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.locationIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.publicReposIndex, rowIndex, ((UserRealmProxyInterface) object).realmGet$publicRepos(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.publicGistsIndex, rowIndex, ((UserRealmProxyInterface) object).realmGet$publicGists(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.followersIndex, rowIndex, ((UserRealmProxyInterface) object).realmGet$followers(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.followingIndex, rowIndex, ((UserRealmProxyInterface) object).realmGet$following(), false);
            String realmGet$createdAt = ((UserRealmProxyInterface) object).realmGet$createdAt();
            if (realmGet$createdAt != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.createdAtIndex, rowIndex, realmGet$createdAt, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.createdAtIndex, rowIndex, false);
            }
            String realmGet$updatedAt = ((UserRealmProxyInterface) object).realmGet$updatedAt();
            if (realmGet$updatedAt != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, realmGet$updatedAt, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, false);
            }

            OsList followersListOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.followersListIndex);
            RealmList<com.rxjavasample.data.model.Follower> followersListList = ((UserRealmProxyInterface) object).realmGet$followersList();
            if (followersListList != null && followersListList.size() == followersListOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = followersListList.size();
                for (int i = 0; i < objectCount; i++) {
                    com.rxjavasample.data.model.Follower followersListItem = followersListList.get(i);
                    Long cacheItemIndexfollowersList = cache.get(followersListItem);
                    if (cacheItemIndexfollowersList == null) {
                        cacheItemIndexfollowersList = FollowerRealmProxy.insertOrUpdate(realm, followersListItem, cache);
                    }
                    followersListOsList.setRow(i, cacheItemIndexfollowersList);
                }
            } else {
                followersListOsList.removeAll();
                if (followersListList != null) {
                    for (com.rxjavasample.data.model.Follower followersListItem : followersListList) {
                        Long cacheItemIndexfollowersList = cache.get(followersListItem);
                        if (cacheItemIndexfollowersList == null) {
                            cacheItemIndexfollowersList = FollowerRealmProxy.insertOrUpdate(realm, followersListItem, cache);
                        }
                        followersListOsList.addRow(cacheItemIndexfollowersList);
                    }
                }
            }

        }
    }

    public static com.rxjavasample.data.model.User createDetachedCopy(com.rxjavasample.data.model.User realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.rxjavasample.data.model.User unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.rxjavasample.data.model.User();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.rxjavasample.data.model.User) cachedObject.object;
            }
            unmanagedObject = (com.rxjavasample.data.model.User) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        UserRealmProxyInterface unmanagedCopy = (UserRealmProxyInterface) unmanagedObject;
        UserRealmProxyInterface realmSource = (UserRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$login(realmSource.realmGet$login());
        unmanagedCopy.realmSet$avatarUrl(realmSource.realmGet$avatarUrl());
        unmanagedCopy.realmSet$htmlUrl(realmSource.realmGet$htmlUrl());
        unmanagedCopy.realmSet$type(realmSource.realmGet$type());
        unmanagedCopy.realmSet$siteAdmin(realmSource.realmGet$siteAdmin());
        unmanagedCopy.realmSet$name(realmSource.realmGet$name());
        unmanagedCopy.realmSet$company(realmSource.realmGet$company());
        unmanagedCopy.realmSet$blog(realmSource.realmGet$blog());
        unmanagedCopy.realmSet$location(realmSource.realmGet$location());
        unmanagedCopy.realmSet$publicRepos(realmSource.realmGet$publicRepos());
        unmanagedCopy.realmSet$publicGists(realmSource.realmGet$publicGists());
        unmanagedCopy.realmSet$followers(realmSource.realmGet$followers());
        unmanagedCopy.realmSet$following(realmSource.realmGet$following());
        unmanagedCopy.realmSet$createdAt(realmSource.realmGet$createdAt());
        unmanagedCopy.realmSet$updatedAt(realmSource.realmGet$updatedAt());

        // Deep copy of followersList
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$followersList(null);
        } else {
            RealmList<com.rxjavasample.data.model.Follower> managedfollowersListList = realmSource.realmGet$followersList();
            RealmList<com.rxjavasample.data.model.Follower> unmanagedfollowersListList = new RealmList<com.rxjavasample.data.model.Follower>();
            unmanagedCopy.realmSet$followersList(unmanagedfollowersListList);
            int nextDepth = currentDepth + 1;
            int size = managedfollowersListList.size();
            for (int i = 0; i < size; i++) {
                com.rxjavasample.data.model.Follower item = FollowerRealmProxy.createDetachedCopy(managedfollowersListList.get(i), nextDepth, maxDepth, cache);
                unmanagedfollowersListList.add(item);
            }
        }

        return unmanagedObject;
    }

    static com.rxjavasample.data.model.User update(Realm realm, com.rxjavasample.data.model.User realmObject, com.rxjavasample.data.model.User newObject, Map<RealmModel, RealmObjectProxy> cache) {
        UserRealmProxyInterface realmObjectTarget = (UserRealmProxyInterface) realmObject;
        UserRealmProxyInterface realmObjectSource = (UserRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$login(realmObjectSource.realmGet$login());
        realmObjectTarget.realmSet$avatarUrl(realmObjectSource.realmGet$avatarUrl());
        realmObjectTarget.realmSet$htmlUrl(realmObjectSource.realmGet$htmlUrl());
        realmObjectTarget.realmSet$type(realmObjectSource.realmGet$type());
        realmObjectTarget.realmSet$siteAdmin(realmObjectSource.realmGet$siteAdmin());
        realmObjectTarget.realmSet$name(realmObjectSource.realmGet$name());
        realmObjectTarget.realmSet$company(realmObjectSource.realmGet$company());
        realmObjectTarget.realmSet$blog(realmObjectSource.realmGet$blog());
        realmObjectTarget.realmSet$location(realmObjectSource.realmGet$location());
        realmObjectTarget.realmSet$publicRepos(realmObjectSource.realmGet$publicRepos());
        realmObjectTarget.realmSet$publicGists(realmObjectSource.realmGet$publicGists());
        realmObjectTarget.realmSet$followers(realmObjectSource.realmGet$followers());
        realmObjectTarget.realmSet$following(realmObjectSource.realmGet$following());
        realmObjectTarget.realmSet$createdAt(realmObjectSource.realmGet$createdAt());
        realmObjectTarget.realmSet$updatedAt(realmObjectSource.realmGet$updatedAt());
        RealmList<com.rxjavasample.data.model.Follower> followersListList = realmObjectSource.realmGet$followersList();
        RealmList<com.rxjavasample.data.model.Follower> followersListRealmList = realmObjectTarget.realmGet$followersList();
        if (followersListList != null && followersListList.size() == followersListRealmList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = followersListList.size();
            for (int i = 0; i < objects; i++) {
                com.rxjavasample.data.model.Follower followersListItem = followersListList.get(i);
                com.rxjavasample.data.model.Follower cachefollowersList = (com.rxjavasample.data.model.Follower) cache.get(followersListItem);
                if (cachefollowersList != null) {
                    followersListRealmList.set(i, cachefollowersList);
                } else {
                    followersListRealmList.set(i, FollowerRealmProxy.copyOrUpdate(realm, followersListItem, true, cache));
                }
            }
        } else {
            followersListRealmList.clear();
            if (followersListList != null) {
                for (int i = 0; i < followersListList.size(); i++) {
                    com.rxjavasample.data.model.Follower followersListItem = followersListList.get(i);
                    com.rxjavasample.data.model.Follower cachefollowersList = (com.rxjavasample.data.model.Follower) cache.get(followersListItem);
                    if (cachefollowersList != null) {
                        followersListRealmList.add(cachefollowersList);
                    } else {
                        followersListRealmList.add(FollowerRealmProxy.copyOrUpdate(realm, followersListItem, true, cache));
                    }
                }
            }
        }
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("User = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{login:");
        stringBuilder.append(realmGet$login() != null ? realmGet$login() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{avatarUrl:");
        stringBuilder.append(realmGet$avatarUrl() != null ? realmGet$avatarUrl() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{htmlUrl:");
        stringBuilder.append(realmGet$htmlUrl() != null ? realmGet$htmlUrl() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{type:");
        stringBuilder.append(realmGet$type() != null ? realmGet$type() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{siteAdmin:");
        stringBuilder.append(realmGet$siteAdmin());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{company:");
        stringBuilder.append(realmGet$company() != null ? realmGet$company() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{blog:");
        stringBuilder.append(realmGet$blog() != null ? realmGet$blog() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{location:");
        stringBuilder.append(realmGet$location() != null ? realmGet$location() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{publicRepos:");
        stringBuilder.append(realmGet$publicRepos());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{publicGists:");
        stringBuilder.append(realmGet$publicGists());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{followers:");
        stringBuilder.append(realmGet$followers());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{following:");
        stringBuilder.append(realmGet$following());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{createdAt:");
        stringBuilder.append(realmGet$createdAt() != null ? realmGet$createdAt() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{updatedAt:");
        stringBuilder.append(realmGet$updatedAt() != null ? realmGet$updatedAt() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{followersList:");
        stringBuilder.append("RealmList<Follower>[").append(realmGet$followersList().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRealmProxy aUser = (UserRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aUser.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aUser.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aUser.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
