package com.iridium.iridiumskyblock.managers;

import com.j256.ormlite.dao.*;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.*;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.ObjectFactory;
import com.j256.ormlite.table.TableInfo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class TestingDao<T, ID> implements Dao<T, ID> {
    @Override
    public T queryForId(ID id) {
        return null;
    }

    @Override
    public T queryForFirst(PreparedQuery<T> preparedQuery) {
        return null;
    }

    @Override
    public List<T> queryForAll() {
        return null;
    }

    @Override
    public T queryForFirst() {
        return null;
    }

    @Override
    public List<T> queryForEq(String fieldName, Object value) {
        return null;
    }

    @Override
    public List<T> queryForMatching(T matchObj) {
        return null;
    }

    @Override
    public List<T> queryForMatchingArgs(T matchObj) {
        return null;
    }

    @Override
    public List<T> queryForFieldValues(Map<String, Object> fieldValues) {
        return null;
    }

    @Override
    public List<T> queryForFieldValuesArgs(Map<String, Object> fieldValues) {
        return null;
    }

    @Override
    public T queryForSameId(T data) {
        return null;
    }

    @Override
    public QueryBuilder<T, ID> queryBuilder() {
        return null;
    }

    @Override
    public UpdateBuilder<T, ID> updateBuilder() {
        return null;
    }

    @Override
    public DeleteBuilder<T, ID> deleteBuilder() {
        return null;
    }

    @Override
    public List<T> query(PreparedQuery<T> preparedQuery) {
        return null;
    }

    @Override
    public int create(T data) {
        return 0;
    }

    @Override
    public int create(Collection<T> datas) {
        return 0;
    }

    @Override
    public T createIfNotExists(T data) {
        return null;
    }

    @Override
    public CreateOrUpdateStatus createOrUpdate(T data) {
        return null;
    }

    @Override
    public int update(T data) {
        return 0;
    }

    @Override
    public int updateId(T data, ID newId) {
        return 0;
    }

    @Override
    public int update(PreparedUpdate<T> preparedUpdate) {
        return 0;
    }

    @Override
    public int refresh(T data) {
        return 0;
    }

    @Override
    public int delete(T data) {
        return 0;
    }

    @Override
    public int deleteById(ID id) {
        return 0;
    }

    @Override
    public int delete(Collection<T> datas) {
        return 0;
    }

    @Override
    public int deleteIds(Collection<ID> ids) {
        return 0;
    }

    @Override
    public int delete(PreparedDelete<T> preparedDelete) {
        return 0;
    }

    @Override
    public CloseableIterator<T> iterator() {
        return null;
    }

    @Override
    public CloseableIterator<T> iterator(int resultFlags) {
        return null;
    }

    @Override
    public CloseableIterator<T> iterator(PreparedQuery<T> preparedQuery) {
        return null;
    }

    @Override
    public CloseableIterator<T> iterator(PreparedQuery<T> preparedQuery, int resultFlags) {
        return null;
    }

    @Override
    public CloseableWrappedIterable<T> getWrappedIterable() {
        return null;
    }

    @Override
    public CloseableWrappedIterable<T> getWrappedIterable(PreparedQuery<T> preparedQuery) {
        return null;
    }

    @Override
    public void closeLastIterator() {

    }

    @Override
    public GenericRawResults<String[]> queryRaw(String query, String... arguments) {
        return null;
    }

    @Override
    public <UO> GenericRawResults<UO> queryRaw(String query, RawRowMapper<UO> mapper, String... arguments) {
        return null;
    }

    @Override
    public <UO> GenericRawResults<UO> queryRaw(String query, DataType[] columnTypes, RawRowObjectMapper<UO> mapper, String... arguments) {
        return null;
    }

    @Override
    public GenericRawResults<Object[]> queryRaw(String query, DataType[] columnTypes, String... arguments) {
        return null;
    }

    @Override
    public <UO> GenericRawResults<UO> queryRaw(String query, DatabaseResultsMapper<UO> mapper, String... arguments) {
        return null;
    }

    @Override
    public long queryRawValue(String query, String... arguments) {
        return 0;
    }

    @Override
    public int executeRaw(String statement, String... arguments) {
        return 0;
    }

    @Override
    public int executeRawNoArgs(String statement) {
        return 0;
    }

    @Override
    public int updateRaw(String statement, String... arguments) {
        return 0;
    }

    @Override
    public <CT> CT callBatchTasks(Callable<CT> callable) {
        return null;
    }

    @Override
    public String objectToString(T data) {
        return null;
    }

    @Override
    public boolean objectsEqual(T data1, T data2) {
        return false;
    }

    @Override
    public ID extractId(T data) {
        return null;
    }

    @Override
    public Class<T> getDataClass() {
        return null;
    }

    @Override
    public FieldType findForeignFieldType(Class<?> clazz) {
        return null;
    }

    @Override
    public boolean isUpdatable() {
        return false;
    }

    @Override
    public boolean isTableExists() {
        return false;
    }

    @Override
    public long countOf() {
        return 0;
    }

    @Override
    public long countOf(PreparedQuery<T> preparedQuery) {
        return 0;
    }

    @Override
    public void assignEmptyForeignCollection(T parent, String fieldName) {

    }

    @Override
    public <FT> ForeignCollection<FT> getEmptyForeignCollection(String fieldName) {
        return null;
    }

    @Override
    public void setObjectCache(boolean enabled) {

    }

    @Override
    public void setObjectCache(ObjectCache objectCache) {

    }

    @Override
    public ObjectCache getObjectCache() {
        return null;
    }

    @Override
    public void clearObjectCache() {

    }

    @Override
    public T mapSelectStarRow(DatabaseResults results) {
        return null;
    }

    @Override
    public GenericRowMapper<T> getSelectStarRowMapper() {
        return null;
    }

    @Override
    public RawRowMapper<T> getRawRowMapper() {
        return null;
    }

    @Override
    public boolean idExists(ID id) {
        return false;
    }

    @Override
    public DatabaseConnection startThreadConnection() {
        return null;
    }

    @Override
    public void endThreadConnection(DatabaseConnection connection) {

    }

    @Override
    public void setAutoCommit(DatabaseConnection connection, boolean autoCommit) {

    }

    @Override
    public boolean isAutoCommit(DatabaseConnection connection) {
        return false;
    }

    @Override
    public void commit(DatabaseConnection connection) {

    }

    @Override
    public void rollBack(DatabaseConnection connection) {

    }

    @Override
    public ConnectionSource getConnectionSource() {
        return null;
    }

    @Override
    public void setObjectFactory(ObjectFactory<T> objectFactory) {

    }

    @Override
    public void registerObserver(DaoObserver observer) {

    }

    @Override
    public void unregisterObserver(DaoObserver observer) {

    }

    @Override
    public String getTableName() {
        return null;
    }

    @Override
    public void notifyChanges() {

    }

    @Override
    public T createObjectInstance() {
        return null;
    }

    @Override
    public TableInfo<T, ID> getTableInfo() {
        return null;
    }

    @Override
    public CloseableIterator<T> closeableIterator() {
        return null;
    }
}
