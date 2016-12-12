package ru.yandex.clickhouse.settings;

import ru.yandex.clickhouse.util.apache.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class ClickHouseProperties {

    // connection settings
    private boolean async;
    private int bufferSize;
    private int apacheBufferSize;
    private int socketTimeout;
    private int connectionTimeout;
    private int dataTransferTimeout;
    private int keepAliveTimeout;
    private int timeToLiveMillis;
    private int defaultMaxPerRoute;
    private int maxTotal;
    private String host;
    private int port;

    //additional
    private int maxCompressBufferSize;


    // queries settings
    private Integer maxParallelReplicas;
    private String totalsMode;
    private String quotaKey;
    private Integer priority;
    private String database;
    private boolean compress;
    private boolean decompress;
    private boolean extremes;
    private Integer maxThreads;
    private Integer maxExecutionTime;
    private Integer maxBlockSize;
    private Integer maxRowsToGroupBy;
    private String profile;
    private String user;
    private String password;
    private boolean distributedAggregationMemoryEfficient;
    private Long maxBytesBeforeExternalGroupBy;
    private Long maxBytesBeforeExternalSort;

    public ClickHouseProperties() {
        this(new Properties());
    }

    public ClickHouseProperties(Properties info) {
        // need casts for java 6
        this.async = (Boolean)getSetting(info, ClickHouseConnectionSettings.ASYNC);
        this.bufferSize = (Integer)getSetting(info, ClickHouseConnectionSettings.BUFFER_SIZE);
        this.apacheBufferSize = (Integer)getSetting(info, ClickHouseConnectionSettings.APACHE_BUFFER_SIZE);
        this.socketTimeout = (Integer)getSetting(info, ClickHouseConnectionSettings.SOCKET_TIMEOUT);
        this.connectionTimeout = (Integer)getSetting(info, ClickHouseConnectionSettings.CONNECTION_TIMEOUT);
        this.dataTransferTimeout = (Integer)getSetting(info, ClickHouseConnectionSettings.DATA_TRANSFER_TIMEOUT);
        this.keepAliveTimeout = (Integer)getSetting(info, ClickHouseConnectionSettings.KEEP_ALIVE_TIMEOUT);
        this.timeToLiveMillis = (Integer)getSetting(info, ClickHouseConnectionSettings.TIME_TO_LIVE_MILLIS);
        this.defaultMaxPerRoute = (Integer)getSetting(info, ClickHouseConnectionSettings.DEFAULT_MAX_PER_ROUTE);
        this.maxTotal = (Integer)getSetting(info, ClickHouseConnectionSettings.MAX_TOTAL);
        this.maxCompressBufferSize = (Integer) getSetting(info, ClickHouseConnectionSettings.MAX_COMPRESS_BUFFER_SIZE);

        this.maxParallelReplicas = getSetting(info, ClickHouseQueryParam.MAX_PARALLEL_REPLICAS);
        this.totalsMode = getSetting(info, ClickHouseQueryParam.TOTALS_MODE);
        this.quotaKey = getSetting(info, ClickHouseQueryParam.QUOTA_KEY);
        this.priority = getSetting(info, ClickHouseQueryParam.PRIORITY);
        this.database = getSetting(info, ClickHouseQueryParam.DATABASE);
        this.compress = (Boolean)getSetting(info, ClickHouseQueryParam.COMPRESS);
        this.decompress = (Boolean)getSetting(info, ClickHouseQueryParam.DECOMPRESS);
        this.extremes = (Boolean)getSetting(info, ClickHouseQueryParam.EXTREMES);
        this.maxThreads = getSetting(info, ClickHouseQueryParam.MAX_THREADS);
        this.maxExecutionTime = getSetting(info, ClickHouseQueryParam.MAX_EXECUTION_TIME);
        this.maxBlockSize = getSetting(info, ClickHouseQueryParam.MAX_BLOCK_SIZE);
        this.maxRowsToGroupBy = getSetting(info, ClickHouseQueryParam.MAX_ROWS_TO_GROUP_BY);
        this.profile = getSetting(info, ClickHouseQueryParam.PROFILE);
        this.user = getSetting(info, ClickHouseQueryParam.USER);
        this.password = getSetting(info, ClickHouseQueryParam.PASSWORD);
        this.distributedAggregationMemoryEfficient = (Boolean)getSetting(info, ClickHouseQueryParam.DISTRIBUTED_AGGREGATION_MEMORY_EFFICIENT);
        this.maxBytesBeforeExternalGroupBy = (Long)getSetting(info, ClickHouseQueryParam.MAX_BYTES_BEFORE_EXTERNAL_GROUP_BY);
        this.maxBytesBeforeExternalSort = (Long)getSetting(info, ClickHouseQueryParam.MAX_BYTES_BEFORE_EXTERNAL_SORT);
    }
    public Properties asProperties() {
        PropertiesBuilder ret = new PropertiesBuilder();
        ret.put(ClickHouseConnectionSettings.ASYNC.getKey(), async);
        ret.put(ClickHouseConnectionSettings.BUFFER_SIZE.getKey(), bufferSize);
        ret.put(ClickHouseConnectionSettings.APACHE_BUFFER_SIZE.getKey(), apacheBufferSize);
        ret.put(ClickHouseConnectionSettings.SOCKET_TIMEOUT.getKey(), socketTimeout);
        ret.put(ClickHouseConnectionSettings.CONNECTION_TIMEOUT.getKey(), connectionTimeout);
        ret.put(ClickHouseConnectionSettings.DATA_TRANSFER_TIMEOUT.getKey(), dataTransferTimeout);
        ret.put(ClickHouseConnectionSettings.KEEP_ALIVE_TIMEOUT.getKey(), keepAliveTimeout);
        ret.put(ClickHouseConnectionSettings.TIME_TO_LIVE_MILLIS.getKey(), timeToLiveMillis);
        ret.put(ClickHouseConnectionSettings.DEFAULT_MAX_PER_ROUTE.getKey(), defaultMaxPerRoute);
        ret.put(ClickHouseConnectionSettings.MAX_TOTAL.getKey(), maxTotal);
        ret.put(ClickHouseConnectionSettings.MAX_COMPRESS_BUFFER_SIZE.getKey(), maxCompressBufferSize);

        ret.put(ClickHouseQueryParam.MAX_PARALLEL_REPLICAS.getKey(), maxParallelReplicas);
        ret.put(ClickHouseQueryParam.TOTALS_MODE.getKey(), totalsMode);
        ret.put(ClickHouseQueryParam.QUOTA_KEY.getKey(), quotaKey);
        ret.put(ClickHouseQueryParam.PRIORITY.getKey(), priority);
        ret.put(ClickHouseQueryParam.DATABASE.getKey(), database);
        ret.put(ClickHouseQueryParam.COMPRESS.getKey(), compress);
        ret.put(ClickHouseQueryParam.DECOMPRESS.getKey(), decompress);
        ret.put(ClickHouseQueryParam.EXTREMES.getKey(), extremes);
        ret.put(ClickHouseQueryParam.MAX_THREADS.getKey(), maxThreads);
        ret.put(ClickHouseQueryParam.MAX_EXECUTION_TIME.getKey(), maxExecutionTime);
        ret.put(ClickHouseQueryParam.MAX_BLOCK_SIZE.getKey(), maxBlockSize);
        ret.put(ClickHouseQueryParam.MAX_ROWS_TO_GROUP_BY.getKey(), maxRowsToGroupBy);
        ret.put(ClickHouseQueryParam.PROFILE.getKey(), profile);
        ret.put(ClickHouseQueryParam.USER.getKey(), user);
        ret.put(ClickHouseQueryParam.PASSWORD.getKey(), password);
        return ret.getProperties();
    }

    public ClickHouseProperties(ClickHouseProperties properties) {
        setHost(properties.host);
        setPort(properties.port);
        setAsync(properties.async);
        setBufferSize(properties.bufferSize);
        setApacheBufferSize(properties.apacheBufferSize);
        setSocketTimeout(properties.socketTimeout);
        setConnectionTimeout(properties.connectionTimeout);
        setDataTransferTimeout(properties.dataTransferTimeout);
        setKeepAliveTimeout(properties.keepAliveTimeout);
        setTimeToLiveMillis(properties.timeToLiveMillis);
        setDefaultMaxPerRoute(properties.defaultMaxPerRoute);
        setMaxTotal(properties.maxTotal);
        setMaxCompressBufferSize(properties.maxCompressBufferSize);

        setMaxParallelReplicas(properties.maxParallelReplicas);
        setTotalsMode(properties.totalsMode);
        setQuotaKey(properties.quotaKey);
        setPriority(properties.priority);
        setDatabase(properties.database);
        setCompress(properties.compress);
        setDecompress(properties.decompress);
        setExtremes(properties.extremes);
        setMaxThreads(properties.maxThreads);
        setMaxExecutionTime(properties.maxExecutionTime);
        setMaxBlockSize(properties.maxBlockSize);
        setMaxRowsToGroupBy(properties.maxRowsToGroupBy);
        setProfile(properties.profile);
        setUser(properties.user);
        setPassword(properties.password);
        setDistributedAggregationMemoryEfficient(properties.distributedAggregationMemoryEfficient);
        setMaxBytesBeforeExternalGroupBy(properties.maxBytesBeforeExternalGroupBy);
        setMaxBytesBeforeExternalSort(properties.maxBytesBeforeExternalSort);
    }

    public Map<ClickHouseQueryParam, String> buildQueryParams(boolean ignoreDatabase){
        Map<ClickHouseQueryParam, String> params = new HashMap<ClickHouseQueryParam, String>();

        if (maxParallelReplicas != null) params.put(ClickHouseQueryParam.MAX_PARALLEL_REPLICAS, String.valueOf(maxParallelReplicas));
        if (maxRowsToGroupBy != null) params.put(ClickHouseQueryParam.MAX_ROWS_TO_GROUP_BY, String.valueOf(maxRowsToGroupBy));
        if (totalsMode != null) params.put(ClickHouseQueryParam.TOTALS_MODE, totalsMode);
        if (quotaKey != null) params.put(ClickHouseQueryParam.QUOTA_KEY, quotaKey);
        if (priority != null) params.put(ClickHouseQueryParam.PRIORITY, String.valueOf(priority));

        if (!StringUtils.isBlank(database) && !ignoreDatabase) params.put(ClickHouseQueryParam.DATABASE, getDatabase());

        if (compress) params.put(ClickHouseQueryParam.COMPRESS, "1");
        if (decompress){
            params.put(ClickHouseQueryParam.DECOMPRESS, "1");
            params.put(ClickHouseQueryParam.HTTP_NATIVE_COMPRESSION_DISABLE_CHECKSUMMING_ON_DECOMPRESS, "1"); // because we do not calculate checksum now
        }

        if (extremes) params.put(ClickHouseQueryParam.EXTREMES, "1");

        if (StringUtils.isBlank(profile)) {
            if (getMaxThreads() != null) {
                params.put(ClickHouseQueryParam.MAX_THREADS, String.valueOf(maxThreads));
            }

            // in seconds there
            if (getMaxExecutionTime() != null) {
                params.put(ClickHouseQueryParam.MAX_EXECUTION_TIME, String.valueOf((maxExecutionTime)));
            }

            if (getMaxBlockSize() != null) {
                params.put(ClickHouseQueryParam.MAX_BLOCK_SIZE, String.valueOf(getMaxBlockSize()));
            }
        } else {
            params.put(ClickHouseQueryParam.PROFILE, profile);
        }

        if (user != null) params.put(ClickHouseQueryParam.USER, user);
        if (password != null) params.put(ClickHouseQueryParam.PASSWORD, password);

        if (distributedAggregationMemoryEfficient) params.put(ClickHouseQueryParam.DISTRIBUTED_AGGREGATION_MEMORY_EFFICIENT, "1");

        if (maxBytesBeforeExternalGroupBy != null) params.put(ClickHouseQueryParam.MAX_BYTES_BEFORE_EXTERNAL_GROUP_BY, String.valueOf(maxBytesBeforeExternalGroupBy));
        if (maxBytesBeforeExternalSort != null) params.put(ClickHouseQueryParam.MAX_BYTES_BEFORE_EXTERNAL_SORT, String.valueOf(maxBytesBeforeExternalSort));

        return params;
    }

    public ClickHouseProperties withCredentials(String user, String password){
        ClickHouseProperties copy = new ClickHouseProperties(this);
        copy.setUser(user);
        copy.setPassword(password);
        return copy;
    }


    private <T> T getSetting(Properties info, ClickHouseQueryParam param){
        return getSetting(info, param.getKey(), param.getDefaultValue(), param.getClazz());
    }

    private <T> T getSetting(Properties info, ClickHouseConnectionSettings settings){
        return getSetting(info, settings.getKey(), settings.getDefaultValue(), settings.getClazz());
    }

    @SuppressWarnings("unchecked")
    private <T> T getSetting(Properties info, String key, Object defaultValue, Class clazz){
        Object val = info.get(key);
        if (val == null)
            return (T)defaultValue;
        if ((clazz == int.class || clazz == Integer.class) && val instanceof String) {
            return (T) clazz.cast(Integer.valueOf((String) val));
        }
        if ((clazz == long.class || clazz == Long.class) && val instanceof String) {
            return (T) clazz.cast(Long.valueOf((String) val));
        }
        if ((clazz == boolean.class || clazz == Boolean.class) && val instanceof String) {
            return (T) clazz.cast(Boolean.valueOf((String) val));
        }
        return (T) clazz.cast(val);
    }


    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public boolean isCompress() {
        return compress;
    }

    public void setCompress(boolean compress) {
        this.compress = compress;
    }

    public boolean isDecompress() {
        return decompress;
    }

    public void setDecompress(boolean decompress) {
        this.decompress = decompress;
    }

    public boolean isAsync() {
        return async;
    }

    public void setAsync(boolean async) {
        this.async = async;
    }

    public Integer getMaxThreads() {
        return maxThreads;
    }

    public void setMaxThreads(Integer maxThreads) {
        this.maxThreads = maxThreads;
    }

    public Integer getMaxBlockSize() {
        return maxBlockSize;
    }

    public void setMaxBlockSize(Integer maxBlockSize) {
        this.maxBlockSize = maxBlockSize;
    }

    public int getBufferSize() {
        return bufferSize;
    }

    public void setBufferSize(int bufferSize) {
        this.bufferSize = bufferSize;
    }

    public int getApacheBufferSize() {
        return apacheBufferSize;
    }

    public void setApacheBufferSize(int apacheBufferSize) {
        this.apacheBufferSize = apacheBufferSize;
    }

    public int getSocketTimeout() {
        return socketTimeout;
    }

    public void setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public int getDataTransferTimeout() {
        return dataTransferTimeout;
    }

    public void setDataTransferTimeout(int dataTransferTimeout) {
        this.dataTransferTimeout = dataTransferTimeout;
    }

    public int getKeepAliveTimeout() {
        return keepAliveTimeout;
    }

    public void setKeepAliveTimeout(int keepAliveTimeout) {
        this.keepAliveTimeout = keepAliveTimeout;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getTimeToLiveMillis() {
        return timeToLiveMillis;
    }

    public void setTimeToLiveMillis(int timeToLiveMillis) {
        this.timeToLiveMillis = timeToLiveMillis;
    }

    public int getDefaultMaxPerRoute() {
        return defaultMaxPerRoute;
    }

    public void setDefaultMaxPerRoute(int defaultMaxPerRoute) {
        this.defaultMaxPerRoute = defaultMaxPerRoute;
    }

    public int getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }

    public int getMaxCompressBufferSize() {
        return maxCompressBufferSize;
    }

    public void setMaxCompressBufferSize(int maxCompressBufferSize) {
        this.maxCompressBufferSize = maxCompressBufferSize;
    }

    public Integer getMaxParallelReplicas() {
        return maxParallelReplicas;
    }

    public void setMaxParallelReplicas(Integer maxParallelReplicas) {
        this.maxParallelReplicas = maxParallelReplicas;
    }

    public String getTotalsMode() {
        return totalsMode;
    }

    public void setTotalsMode(String totalsMode) {
        this.totalsMode = totalsMode;
    }

    public String getQuotaKey() {
        return quotaKey;
    }

    public void setQuotaKey(String quotaKey) {
        this.quotaKey = quotaKey;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public boolean isExtremes() {
        return extremes;
    }

    public void setExtremes(boolean extremes) {
        this.extremes = extremes;
    }

    public Integer getMaxExecutionTime() {
        return maxExecutionTime;
    }

    public void setMaxExecutionTime(Integer maxExecutionTime) {
        this.maxExecutionTime = maxExecutionTime;
    }

    public Integer getMaxRowsToGroupBy() {
        return maxRowsToGroupBy;
    }

    public void setMaxRowsToGroupBy(Integer maxRowsToGroupBy) {
        this.maxRowsToGroupBy = maxRowsToGroupBy;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean isDistributedAggregationMemoryEfficient() {
        return distributedAggregationMemoryEfficient;
    }

    public void setDistributedAggregationMemoryEfficient(boolean distributedAggregationMemoryEfficient) {
        this.distributedAggregationMemoryEfficient = distributedAggregationMemoryEfficient;
    }

    public Long getMaxBytesBeforeExternalGroupBy() {
        return maxBytesBeforeExternalGroupBy;
    }

    public void setMaxBytesBeforeExternalGroupBy(Long maxBytesBeforeExternalGroupBy) {
        this.maxBytesBeforeExternalGroupBy = maxBytesBeforeExternalGroupBy;
    }

    public Long getMaxBytesBeforeExternalSort() {
        return maxBytesBeforeExternalSort;
    }

    public void setMaxBytesBeforeExternalSort(Long maxBytesBeforeExternalSort) {
        this.maxBytesBeforeExternalSort = maxBytesBeforeExternalSort;
    }

    private static class PropertiesBuilder {
        private final Properties properties;
        public PropertiesBuilder() {
            properties = new Properties();
        }

        public void put(String key, int value) {
            properties.put(key, value);
        }

        public void put(String key, Integer value) {
            if (value != null) {
                properties.put(key, value.toString());
            }
        }

        public void put(String key, boolean value) {
            properties.put(key, String.valueOf(value));
        }

        public void put(String key, String value) {
            if (value != null) {
                properties.put(key, value);
            }
        }

        public Properties getProperties() {
            return properties;
        }
    }

}
