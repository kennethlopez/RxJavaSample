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
public class FollowerRealmProxy extends com.rxjavasample.data.model.Follower
    implements RealmObjectProxy, FollowerRealmProxyInterface {

    static final class FollowerColumnInfo extends ColumnInfo {
        long idIndex;
        long loginIndex;
        long avatarUrlIndex;
        long typeIndex;
        long siteAdminIndex;

        FollowerColumnInfo(OsSchemaInfo schemaInfo) {
            super(5);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Follower");
            this.idIndex = addColumnDetails("id", objectSchemaInfo);
            this.loginIndex = addColumnDetails("login", objectSchemaInfo);
            this.avatarUrlIndex = addColumnDetails("avatarUrl", objectSchemaInfo);
            this.typeIndex = addColumnDetails("type", objectSchemaInfo);
            this.siteAdminIndex = addColumnDetails("siteAdmin", objectSchemaInfo);
        }

        FollowerColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new FollowerColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final FollowerColumnInfo src = (FollowerColumnInfo) rawSrc;
            final FollowerColumnInfo dst = (FollowerColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.loginIndex = src.loginIndex;
            dst.avatarUrlIndex = src.avatarUrlIndex;
            dst.typeIndex = src.typeIndex;
            dst.siteAdminIndex = src.siteAdminIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(5);
        fieldNames.add("id");
        fieldNames.add("login");
        fieldNames.add("avatarUrl");
        fieldNames.add("type");
        fieldNames.add("siteAdmin");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private FollowerColumnInfo columnInfo;
    private ProxyState<com.rxjavasample.data.model.Follower> proxyState;

    FollowerRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (FollowerColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.rxjavasample.data.model.Follower>(this);
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

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Follower", 5, 0);
        builder.addPersistedProperty("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("login", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("avatarUrl", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("type", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("siteAdmin", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static FollowerColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new FollowerColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Follower";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.rxjavasample.data.model.Follower createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.rxjavasample.data.model.Follower obj = null;
        if (update) {
            Table table = realm.getTable(com.rxjavasample.data.model.Follower.class);
            FollowerColumnInfo columnInfo = (FollowerColumnInfo) realm.getSchema().getColumnInfo(com.rxjavasample.data.model.Follower.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.rxjavasample.data.model.Follower.class), false, Collections.<String> emptyList());
                    obj = new io.realm.FollowerRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.FollowerRealmProxy) realm.createObjectInternal(com.rxjavasample.data.model.Follower.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.FollowerRealmProxy) realm.createObjectInternal(com.rxjavasample.data.model.Follower.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final FollowerRealmProxyInterface objProxy = (FollowerRealmProxyInterface) obj;
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
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.rxjavasample.data.model.Follower createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.rxjavasample.data.model.Follower obj = new com.rxjavasample.data.model.Follower();
        final FollowerRealmProxyInterface objProxy = (FollowerRealmProxyInterface) obj;
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

    public static com.rxjavasample.data.model.Follower copyOrUpdate(Realm realm, com.rxjavasample.data.model.Follower object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.rxjavasample.data.model.Follower) cachedRealmObject;
        }

        com.rxjavasample.data.model.Follower realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.rxjavasample.data.model.Follower.class);
            FollowerColumnInfo columnInfo = (FollowerColumnInfo) realm.getSchema().getColumnInfo(com.rxjavasample.data.model.Follower.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = table.findFirstLong(pkColumnIndex, ((FollowerRealmProxyInterface) object).realmGet$id());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.rxjavasample.data.model.Follower.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.FollowerRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.rxjavasample.data.model.Follower copy(Realm realm, com.rxjavasample.data.model.Follower newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.rxjavasample.data.model.Follower) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.rxjavasample.data.model.Follower realmObject = realm.createObjectInternal(com.rxjavasample.data.model.Follower.class, ((FollowerRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        FollowerRealmProxyInterface realmObjectSource = (FollowerRealmProxyInterface) newObject;
        FollowerRealmProxyInterface realmObjectCopy = (FollowerRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$login(realmObjectSource.realmGet$login());
        realmObjectCopy.realmSet$avatarUrl(realmObjectSource.realmGet$avatarUrl());
        realmObjectCopy.realmSet$type(realmObjectSource.realmGet$type());
        realmObjectCopy.realmSet$siteAdmin(realmObjectSource.realmGet$siteAdmin());
        return realmObject;
    }

    public static long insert(Realm realm, com.rxjavasample.data.model.Follower object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.rxjavasample.data.model.Follower.class);
        long tableNativePtr = table.getNativePtr();
        FollowerColumnInfo columnInfo = (FollowerColumnInfo) realm.getSchema().getColumnInfo(com.rxjavasample.data.model.Follower.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((FollowerRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((FollowerRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((FollowerRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$login = ((FollowerRealmProxyInterface) object).realmGet$login();
        if (realmGet$login != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.loginIndex, rowIndex, realmGet$login, false);
        }
        String realmGet$avatarUrl = ((FollowerRealmProxyInterface) object).realmGet$avatarUrl();
        if (realmGet$avatarUrl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.avatarUrlIndex, rowIndex, realmGet$avatarUrl, false);
        }
        String realmGet$type = ((FollowerRealmProxyInterface) object).realmGet$type();
        if (realmGet$type != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.siteAdminIndex, rowIndex, ((FollowerRealmProxyInterface) object).realmGet$siteAdmin(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.rxjavasample.data.model.Follower.class);
        long tableNativePtr = table.getNativePtr();
        FollowerColumnInfo columnInfo = (FollowerColumnInfo) realm.getSchema().getColumnInfo(com.rxjavasample.data.model.Follower.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.rxjavasample.data.model.Follower object = null;
        while (objects.hasNext()) {
            object = (com.rxjavasample.data.model.Follower) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((FollowerRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((FollowerRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((FollowerRealmProxyInterface) object).realmGet$id());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$login = ((FollowerRealmProxyInterface) object).realmGet$login();
            if (realmGet$login != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.loginIndex, rowIndex, realmGet$login, false);
            }
            String realmGet$avatarUrl = ((FollowerRealmProxyInterface) object).realmGet$avatarUrl();
            if (realmGet$avatarUrl != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.avatarUrlIndex, rowIndex, realmGet$avatarUrl, false);
            }
            String realmGet$type = ((FollowerRealmProxyInterface) object).realmGet$type();
            if (realmGet$type != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.siteAdminIndex, rowIndex, ((FollowerRealmProxyInterface) object).realmGet$siteAdmin(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.rxjavasample.data.model.Follower object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.rxjavasample.data.model.Follower.class);
        long tableNativePtr = table.getNativePtr();
        FollowerColumnInfo columnInfo = (FollowerColumnInfo) realm.getSchema().getColumnInfo(com.rxjavasample.data.model.Follower.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((FollowerRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((FollowerRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((FollowerRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, rowIndex);
        String realmGet$login = ((FollowerRealmProxyInterface) object).realmGet$login();
        if (realmGet$login != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.loginIndex, rowIndex, realmGet$login, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.loginIndex, rowIndex, false);
        }
        String realmGet$avatarUrl = ((FollowerRealmProxyInterface) object).realmGet$avatarUrl();
        if (realmGet$avatarUrl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.avatarUrlIndex, rowIndex, realmGet$avatarUrl, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.avatarUrlIndex, rowIndex, false);
        }
        String realmGet$type = ((FollowerRealmProxyInterface) object).realmGet$type();
        if (realmGet$type != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.typeIndex, rowIndex, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.siteAdminIndex, rowIndex, ((FollowerRealmProxyInterface) object).realmGet$siteAdmin(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.rxjavasample.data.model.Follower.class);
        long tableNativePtr = table.getNativePtr();
        FollowerColumnInfo columnInfo = (FollowerColumnInfo) realm.getSchema().getColumnInfo(com.rxjavasample.data.model.Follower.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.rxjavasample.data.model.Follower object = null;
        while (objects.hasNext()) {
            object = (com.rxjavasample.data.model.Follower) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((FollowerRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((FollowerRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((FollowerRealmProxyInterface) object).realmGet$id());
            }
            cache.put(object, rowIndex);
            String realmGet$login = ((FollowerRealmProxyInterface) object).realmGet$login();
            if (realmGet$login != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.loginIndex, rowIndex, realmGet$login, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.loginIndex, rowIndex, false);
            }
            String realmGet$avatarUrl = ((FollowerRealmProxyInterface) object).realmGet$avatarUrl();
            if (realmGet$avatarUrl != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.avatarUrlIndex, rowIndex, realmGet$avatarUrl, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.avatarUrlIndex, rowIndex, false);
            }
            String realmGet$type = ((FollowerRealmProxyInterface) object).realmGet$type();
            if (realmGet$type != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.typeIndex, rowIndex, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.siteAdminIndex, rowIndex, ((FollowerRealmProxyInterface) object).realmGet$siteAdmin(), false);
        }
    }

    public static com.rxjavasample.data.model.Follower createDetachedCopy(com.rxjavasample.data.model.Follower realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.rxjavasample.data.model.Follower unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.rxjavasample.data.model.Follower();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.rxjavasample.data.model.Follower) cachedObject.object;
            }
            unmanagedObject = (com.rxjavasample.data.model.Follower) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        FollowerRealmProxyInterface unmanagedCopy = (FollowerRealmProxyInterface) unmanagedObject;
        FollowerRealmProxyInterface realmSource = (FollowerRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$login(realmSource.realmGet$login());
        unmanagedCopy.realmSet$avatarUrl(realmSource.realmGet$avatarUrl());
        unmanagedCopy.realmSet$type(realmSource.realmGet$type());
        unmanagedCopy.realmSet$siteAdmin(realmSource.realmGet$siteAdmin());

        return unmanagedObject;
    }

    static com.rxjavasample.data.model.Follower update(Realm realm, com.rxjavasample.data.model.Follower realmObject, com.rxjavasample.data.model.Follower newObject, Map<RealmModel, RealmObjectProxy> cache) {
        FollowerRealmProxyInterface realmObjectTarget = (FollowerRealmProxyInterface) realmObject;
        FollowerRealmProxyInterface realmObjectSource = (FollowerRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$login(realmObjectSource.realmGet$login());
        realmObjectTarget.realmSet$avatarUrl(realmObjectSource.realmGet$avatarUrl());
        realmObjectTarget.realmSet$type(realmObjectSource.realmGet$type());
        realmObjectTarget.realmSet$siteAdmin(realmObjectSource.realmGet$siteAdmin());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Follower = proxy[");
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
        stringBuilder.append("{type:");
        stringBuilder.append(realmGet$type() != null ? realmGet$type() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{siteAdmin:");
        stringBuilder.append(realmGet$siteAdmin());
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
        FollowerRealmProxy aFollower = (FollowerRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aFollower.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aFollower.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aFollower.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
