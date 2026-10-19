    }
        long warnThreshold,
        if (tieredStorageSlowlogEnabled) {
        List<TieredStoragePerQueryMetric> metricCollectors,
            this.tookInNanos = tookInNanos;  
        TimeValue.timeValueMillis(-1),  
            .addSettingsUpdateConsumer(INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_WARN_SETTING, this::setQueryWarnThreshold);
    public static final Setting<SlowLogLevel> INDEX_SEARCH_SLOWLOG_LEVEL = new Setting<>(  
    }
import java.util.HashMap;
                queryLogger,
    /**
        if (tieredStorageSlowlogEnabled) {
    public void onFailedQueryPhase(SearchContext searchContext) {  
     * @return the threshold  
                fetchWarnThreshold,
                context,
                builder.nullField("source");  
        TimeValue.timeValueMillis(5000),
import java.util.List;  
        setFetchWarnThreshold(indexSettings.getValue(INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_WARN_SETTING));
        long tookInNanos,  
    private volatile long fetchWarnThreshold;
                context,
     * Formats slow log output as JSON with warm storage metrics.  
                    stats.addAll(metricCollectors);  
        }
     * Sets whether tiered storage slow log is enabled.  
        indexSettings.getScopedSettings()
    public void setTieredStorageSlowlogEnabled(boolean tieredStorageSlowlogEnabled) {  
 *
        this.queryInfoThreshold = infoThreshold.nanos();  
        this.queryWarnThreshold = warnThreshold.nanos();
    // TODO check this level
        // Only clean up if we were collecting metrics
    public static final Map<String, Setting<?>> TIERED_STORAGE_SEARCH_SLOWLOG_SETTINGS_MAP = Collections.unmodifiableMap(new HashMap<>() {  
                queryDebugThreshold,
                    searchTask == null ? null : searchTask.getParentTaskId().toString(),
    }
     * @return the threshold
        TimeValue.timeValueMillis(2000),
        SlowLogLevel::parse,  
    private volatile long fetchTraceThreshold;
                ),  
                searchContext.getTask().getParentTaskId().toString(),
        this.queryLogger = LogManager.getLogger(TIERED_STORAGE_SEARCH_SLOWLOG_PREFIX + ".query");  
            removeMetricCollector();
    );  
     */  
                fetchInfoThreshold,
package org.opensearch.storage.slowlogs;
            );  
         * @param tookInNanos the time taken in nanoseconds
        TimeValue.timeValueMillis(10000),
                isQueryPhase
    private volatile long fetchDebugThreshold;
        setQueryWarnThreshold(indexSettings.getValue(INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_WARN_SETTING));  
     */
        long debugThreshold,
            builder.startArray("warm_stats");
    /**
import java.util.concurrent.TimeUnit;
        return queryWarnThreshold;
                    builder.value(collector.toString());
        this.fetchTraceThreshold = traceThreshold.nanos();  
     * Returns the current slow log level.
        this.fetchWarnThreshold = warnThreshold.nanos();  
     * Returns the fetch trace threshold in nanoseconds.  
import java.util.Map;
    ) {
    }
        if (tieredStorageSlowlogEnabled) {  
        if (tieredStorageSlowlogEnabled) {
            .addSettingsUpdateConsumer(INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_WARN_SETTING, this::setFetchWarnThreshold);  
            }
        if (tieredStorageSlowlogEnabled) {
    long getQueryDebugThreshold() {
    private volatile long fetchInfoThreshold;  
        this.level = level;
            put(INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_INFO_SETTING.getKey(), INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_INFO_SETTING);
                metricCollectors,  
        Logger log,  
    }  
    );  
        }
    );  
     * @return the threshold
        indexSettings.getScopedSettings().addSettingsUpdateConsumer(INDEX_SEARCH_SLOWLOG_LEVEL, this::setLevel);  
     * @return the threshold
        this.fetchDebugThreshold = debugThreshold.nanos();
            final List<TieredStoragePerQueryMetric> metricCollectors = new ArrayList<>(
                }
            setMetricCollector(searchContext, true);
            this.metricCollectors = metricCollectors;
import org.opensearch.common.settings.Setting.Property;
        // Only clean up if we were collecting metrics
        if (tieredStorageSlowlogEnabled) {
            if (context.request().source() != null) {  
     * @opensearch.experimental
    }  
     * Returns the query info threshold in nanoseconds.  
            printSlowLog(
            builder.startArray("stats");
        TimeValue.timeValueMillis(-1),  
            printSlowLog(  
     * @return the threshold
        TIERED_STORAGE_SEARCH_SLOWLOG_PREFIX + ".level",
     */
                searchContext.getTask().getParentTaskId().toString(),  
        this.queryDebugThreshold = debugThreshold.nanos();
    }
            builder.field("total_shards", context.numberOfShards());
        private XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {  
            if (metricCollectors != null && !metricCollectors.isEmpty()) {
                true
    }
        this.fetchInfoThreshold = infoThreshold.nanos();
                new TieredStoragePerQueryMetricImpl(  
 * Logs slow queries and fetches with per-query cache and prefetch metrics.
        // so we initialize collectors only in onPreSliceExecution
        this.queryTraceThreshold = traceThreshold.nanos();
     */  
     * @return the threshold
        TimeValue.timeValueMillis(-1),  
import java.util.Objects;
    );  
        }  
    /**
    /**  
                }
    private void setMetricCollector(SearchContext searchContext, boolean isQueryPhase) {  
        return TieredStorageQueryMetricService.getInstance().removeMetricCollector(Thread.currentThread().threadId());
    private volatile long queryInfoThreshold;
    private volatile long queryDebugThreshold;
    }
            log.error("Warm Slow Log: Search Task not expected to be null");
        {
import java.util.Set;  
import java.io.IOException;
    long getFetchInfoThreshold() {
        Property.Dynamic,
        }
import org.opensearch.core.xcontent.ToXContent;
                for (TieredStoragePerQueryMetric collector : metricCollectors) {  
            .addSettingsUpdateConsumer(INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_DEBUG_SETTING, this::setFetchDebugThreshold);  
    static final class TieredStorageSlowLogPrinter {
        TIERED_STORAGE_SEARCH_SLOWLOG_PREFIX + ".threshold.fetch.debug",
    long getFetchDebugThreshold() {
            builder.field("search_type", context.searchType().toString());  
            }  
        // Fetch phase execution is starting. Add new metric collector only if enabled  
    private void setFetchTraceThreshold(TimeValue traceThreshold) {
import org.opensearch.action.search.SearchShardTask;  
     */
                searchContext.shardTarget().getShardId().toString(),  
            );
                tookInNanos,  
            .addSettingsUpdateConsumer(INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_INFO_SETTING, this::setQueryInfoThreshold);
            assert metricCollectors.size() == 1 : "Fetch phase is expected to be single threaded, so we should only have 1 collector";
    private void setQueryInfoThreshold(TimeValue infoThreshold) {
    /**  
import java.util.ArrayList;
    }
        TimeValue.timeValueMillis(-1),  
import org.opensearch.common.xcontent.XContentFactory;  
    /**
    public static final Setting<TimeValue> INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_DEBUG_SETTING = Setting.timeSetting(  
     */  
            // Although fetch phase is single threaded today, we will use the same map implementation for posterity.  
        private final SearchContext context;
            builder.endObject();  
            }
/*  
                queryTraceThreshold
                for (Object stat : stats) {
    private Set<TieredStoragePerQueryMetric> removeMetricCollectors(String parentTaskId, String shardId, boolean isQueryPhase) {
        if (tieredStorageSlowlogEnabled) {  
        }  
     * Returns the query trace threshold in nanoseconds.
     * Returns the query debug threshold in nanoseconds.
    long getQueryInfoThreshold() {  
            setMetricCollector(searchContext, false);
        TIERED_STORAGE_SEARCH_SLOWLOG_PREFIX + ".threshold.fetch.warn",
        setTieredStorageSlowlogEnabled(indexSettings.getValue(TIERED_STORAGE_SEARCH_SLOWLOG_ENABLED));
        Property.Dynamic,
        Property.IndexScope
        long traceThreshold  
        } else if (traceThreshold >= 0 && tookInNanos > traceThreshold) {
        return fetchInfoThreshold;  
    }
            if (context.groupStats() != null) {
            .addSettingsUpdateConsumer(INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_INFO_SETTING, this::setFetchInfoThreshold);  
                metricCollectors,
    /** Setting to enable or disable tiered storage search slow log. */  
        final SearchShardTask searchTask = searchContext.getTask();
     * @return the slow log level  
     * @return the threshold  
        TIERED_STORAGE_SEARCH_SLOWLOG_PREFIX + ".threshold.query.info",
    public TieredStorageSearchSlowLog(IndexSettings indexSettings) {
        TieredStorageSlowLogPrinter(SearchContext context, long tookInNanos, List<TieredStoragePerQueryMetric> metricCollectors) {
        final Logger log = isQueryPhase ? queryLogger : fetchLogger;
        TimeValue.timeValueMillis(500),
    /** Fetch trace threshold setting. */
    private void setQueryWarnThreshold(TimeValue warnThreshold) {
     */
            builder.field("took_millis", TimeUnit.NANOSECONDS.toMillis(tookInNanos));
        // Only clean up if we were collecting metrics
    @Override
        SearchContext context,
            removeMetricCollectors(
        // Get all collectors associated with the task/shard
            log.trace("{}", new TieredStorageSlowLogPrinter(context, tookInNanos, metricCollectors));  
import org.opensearch.common.settings.Setting;  
                XContentBuilder builder = XContentFactory.jsonBuilder();
        Property.IndexScope
        @Override
    public void onPreQueryPhase(SearchContext searchContext) {  
            removeMetricCollectors(context.getTask().getParentTaskId().toString(), context.shardTarget().getShardId().toString(), true)
        Property.IndexScope
        indexSettings.getScopedSettings()
        Property.IndexScope
    }  
            removeMetricCollector();
     *
    );  
        setFetchDebugThreshold(indexSettings.getValue(INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_DEBUG_SETTING));
        long infoThreshold,
    public void onFailedFetchPhase(SearchContext searchContext) {
            put(INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_WARN_SETTING.getKey(), INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_WARN_SETTING);  
    private void setLevel(SlowLogLevel level) {
        TimeValue.timeValueMillis(-1),  
    /** Query debug threshold setting. */
}  
    public static final Setting<TimeValue> INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_DEBUG_SETTING = Setting.timeSetting(  
        setQueryInfoThreshold(indexSettings.getValue(INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_INFO_SETTING));  
    private SlowLogLevel level;
                Thread.currentThread().threadId(),
     * Returns the fetch warn threshold in nanoseconds.  
        public String toString() {
                toXContent(builder, FORMAT_PARAMS);
    );  
            put(INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_INFO_SETTING.getKey(), INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_INFO_SETTING);
    private final Logger fetchLogger;
            List<Object> stats = new ArrayList<>();  
import org.opensearch.index.shard.SearchOperationListener;
                }
    }
    public static final Set<Setting<?>> TIERED_STORAGE_SEARCH_SLOWLOG_SETTINGS = Collections.unmodifiableSet(
    public void onFailedSliceExecution(SearchContext searchContext) {
        Property.Dynamic,
 * this file be licensed under the Apache-2.0 license or a
        Property.IndexScope
 * The OpenSearch Contributors require contributions made to  
         * @param context the search context  
    }
        Loggers.setLevel(fetchLogger, level.name());
        setQueryTraceThreshold(indexSettings.getValue(INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_TRACE_SETTING));  
    );  
        this.fetchLogger = LogManager.getLogger(TIERED_STORAGE_SEARCH_SLOWLOG_PREFIX + ".fetch");
        indexSettings.getScopedSettings()
    /** Query warn threshold setting. */
 * compatible open source license.
            // warm_stats array  
    private final Logger queryLogger;  
            .addSettingsUpdateConsumer(INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_TRACE_SETTING, this::setQueryTraceThreshold);
    });
        Property.IndexScope
        // Only log if tiered storage slow log is enabled
import org.opensearch.index.IndexSettings;  
            put(INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_WARN_SETTING.getKey(), INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_WARN_SETTING);
import org.opensearch.common.logging.Loggers;
    }  
    }
                fetchDebugThreshold,
import java.util.HashSet;
        return fetchWarnThreshold;
    }
    }  
                false
        TIERED_STORAGE_SEARCH_SLOWLOG_PREFIX + ".threshold.fetch.info",
        indexSettings.getScopedSettings()
 */
            // took and took_millis  
        /**
        setFetchTraceThreshold(indexSettings.getValue(INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_TRACE_SETTING));
        TieredStorageQueryMetricService.getInstance()  
        false,  
        TIERED_STORAGE_SEARCH_SLOWLOG_PREFIX + ".threshold.query.warn",
     */  
        Property.Dynamic,
            }  
        setQueryDebugThreshold(indexSettings.getValue(INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_DEBUG_SETTING));  
        }  
    /**
        TimeValue.timeValueMillis(10000),
        new HashSet<>(TIERED_STORAGE_SEARCH_SLOWLOG_SETTINGS_MAP.values())
        return fetchTraceThreshold;
            log.warn("{}", new TieredStorageSlowLogPrinter(context, tookInNanos, metricCollectors));  
        TimeValue.timeValueMillis(5000),
    SlowLogLevel getLevel() {  
/**  
    long getQueryTraceThreshold() {
        if (warnThreshold >= 0 && tookInNanos > warnThreshold) {
    /** Fetch info threshold setting. */
        TIERED_STORAGE_SEARCH_SLOWLOG_PREFIX + ".enabled",
        // concurrent search and non-concurrent search cases
     * Returns the fetch debug threshold in nanoseconds.
    private volatile boolean tieredStorageSlowlogEnabled;
    }  
            log.debug("{}", new TieredStorageSlowLogPrinter(context, tookInNanos, metricCollectors));
 * SPDX-License-Identifier: Apache-2.0
        return queryInfoThreshold;
    }
    }  
    private void setFetchDebugThreshold(TimeValue debugThreshold) {
    public static final Setting<TimeValue> INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_INFO_SETTING = Setting.timeSetting(  
            .addSettingsUpdateConsumer(INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_DEBUG_SETTING, this::setQueryDebugThreshold);
    public static final String TIERED_STORAGE_SEARCH_SLOWLOG_PREFIX = "index.tiered.storage.slowlog";
    /** Query trace threshold setting. */
    /**
            builder.endArray();  
public final class TieredStorageSearchSlowLog implements SearchOperationListener {  
            .addSettingsUpdateConsumer(TIERED_STORAGE_SEARCH_SLOWLOG_ENABLED, this::setTieredStorageSlowlogEnabled);
            // It's also much cleaner than propagating the fetch boolean to TieredStorageQueryMetricService
                queryWarnThreshold,
    long getQueryWarnThreshold() {
     * @return the threshold
    public void onSliceExecution(SearchContext searchContext) {  
    }  
    }
        if (tieredStorageSlowlogEnabled) {
    private void setFetchInfoThreshold(TimeValue infoThreshold) {  
            put(INDEX_SEARCH_SLOWLOG_LEVEL.getKey(), INDEX_SEARCH_SLOWLOG_LEVEL);
import org.opensearch.common.logging.SlowLogLevel;
         */  
        private final List<TieredStoragePerQueryMetric> metricCollectors;
            builder.field("took", TimeValue.timeValueNanos(tookInNanos).toString());
    );  
    /** Map of all tiered storage search slow log settings keyed by setting name. */
                builder.field("source", context.request().source().toString(params));
        final List<TieredStoragePerQueryMetric> metricCollectors = new ArrayList<>(  
        SlowLogLevel.TRACE.name(),
        indexSettings.getScopedSettings()  
 * @opensearch.experimental
        // Only clean up and log if we were collecting metrics  
     * @param indexSettings the index settings  
        );
    );  
    }
            removeMetricCollectors(
     */
            put(INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_TRACE_SETTING.getKey(), INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_TRACE_SETTING);
    public static final Setting<TimeValue> INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_TRACE_SETTING = Setting.timeSetting(  
        return TieredStorageQueryMetricService.getInstance().removeMetricCollectors(parentTaskId, shardId, isQueryPhase);  
    long getFetchWarnThreshold() {  
    public static final Setting<TimeValue> INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_WARN_SETTING = Setting.timeSetting(  
     * Creates a new TieredStorageSearchSlowLog instance.
        Property.Dynamic,
    }
    }
    public static final Setting<TimeValue> INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_WARN_SETTING = Setting.timeSetting(  
        TIERED_STORAGE_SEARCH_SLOWLOG_PREFIX + ".threshold.fetch.trace",
import java.util.Collections;  
         * Creates a new slow log printer.
import org.apache.logging.log4j.Logger;
                    searchContext.shardTarget().getShardId().toString()
                fetchTraceThreshold  
    }  
        }
        TIERED_STORAGE_SEARCH_SLOWLOG_PREFIX + ".threshold.query.trace",
     * @param tieredStorageSlowlogEnabled true to enable
            try {  
        TimeValue.timeValueMillis(-1),  
        indexSettings.getScopedSettings()
        Property.IndexScope
    @Override
    }
     */
    private void setQueryDebugThreshold(TimeValue debugThreshold) {  
            removeMetricCollector();  
    }
                return builder.toString();  
            // search_type, total_shards, and source
        Property.IndexScope
    /** Settings prefix for tiered storage search slow log. */  
            return builder;
    }
            builder.endArray();
    }
import org.opensearch.common.unit.TimeValue;
        Loggers.setLevel(queryLogger, level.name());  
import org.apache.logging.log4j.LogManager;
    }  
        if (searchTask == null) {  
            builder.startObject();
        // Only collect metrics if tiered storage slow log is enabled  
            );  
    private volatile long queryWarnThreshold;  
        return fetchDebugThreshold;
                queryInfoThreshold,  
        } else if (infoThreshold >= 0 && tookInNanos > infoThreshold) {
        }
    /**
 */  
        private final Logger logger = LogManager.getLogger(TieredStorageSlowLogPrinter.class);
                fetchLogger,  
            put(INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_TRACE_SETTING.getKey(), INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_TRACE_SETTING);  
            removeMetricCollector();  
        setFetchInfoThreshold(indexSettings.getValue(INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_INFO_SETTING));
        Property.Dynamic,
        Property.Dynamic,
                if (metricCollectors != null) {
        TimeValue.timeValueMillis(-1),  
            }  
    );  
        Property.IndexScope
    private void setFetchWarnThreshold(TimeValue warnThreshold) {
            put(TIERED_STORAGE_SEARCH_SLOWLOG_ENABLED.getKey(), TIERED_STORAGE_SEARCH_SLOWLOG_ENABLED);
    public void onQueryPhase(SearchContext context, long tookInNanos) {
    /** Fetch warn threshold setting. */
    public void onFetchPhase(SearchContext context, long tookInNanos) {
    }  
    /** Slow log level setting. */
        return level;
        TimeValue.timeValueMillis(500),
    private void printSlowLog(
import org.opensearch.core.xcontent.XContentBuilder;
    /** Fetch debug threshold setting. */
                    builder.value(stat.toString());  
            );
    public void onPreSliceExecution(SearchContext searchContext) {
    public static final Setting<Boolean> TIERED_STORAGE_SEARCH_SLOWLOG_ENABLED = Setting.boolSetting(
    private void setQueryTraceThreshold(TimeValue traceThreshold) {
     * Returns the query warn threshold in nanoseconds.
    }  
                tookInNanos,
        }
            // stats array
     */
    private volatile long queryTraceThreshold;  
        }
    );  
    public static final Setting<TimeValue> INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_TRACE_SETTING = Setting.timeSetting(  
    @Override  
            removeMetricCollector();
    @Override
        // No need to call removeMetricCollector() here as that will be handled in onSliceExecution in both
            );
        }  
        TIERED_STORAGE_SEARCH_SLOWLOG_PREFIX + ".threshold.query.debug",
        TimeValue.timeValueMillis(-1),  
            );
    @Override  
        Property.Dynamic,
    public void onPreFetchPhase(SearchContext searchContext) {
import org.opensearch.search.internal.SearchContext;
            log.info("{}", new TieredStorageSlowLogPrinter(context, tookInNanos, metricCollectors));
    /**
            if (!stats.isEmpty()) {
        indexSettings.getScopedSettings()
        // Only clean up if we were collecting metrics
        } else if (debugThreshold >= 0 && tookInNanos > debugThreshold) {  
        indexSettings.getScopedSettings()
        }
        return queryDebugThreshold;  
        Property.Dynamic,
            .addMetricCollector(
 * Search slow log implementation for tiered storage (warm data).
                searchContext.shardTarget().getShardId().toString(),
    /**
    /** Query info threshold setting. */
        this.tieredStorageSlowlogEnabled = tieredStorageSlowlogEnabled;
    @Override
    long getFetchTraceThreshold() {  
            this.context = context;
    private static final ToXContent.Params FORMAT_PARAMS = new ToXContent.MapParams(Collections.singletonMap("pretty", "false"));
                throw new RuntimeException(e);
        private final long tookInNanos;  
        setLevel(indexSettings.getValue(INDEX_SEARCH_SLOWLOG_LEVEL));
    @Override
    public static final Setting<TimeValue> INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_INFO_SETTING = Setting.timeSetting(  
        Property.IndexScope
         * @param metricCollectors the per-query metric collectors
            put(INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_DEBUG_SETTING.getKey(), INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_DEBUG_SETTING);  
            } catch (IOException e) {
    /**  
        Property.Dynamic,
            .addSettingsUpdateConsumer(INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_TRACE_SETTING, this::setFetchTraceThreshold);  
     */
        indexSettings.getScopedSettings()
    /** Set of all tiered storage search slow log settings. */  
            } else {
 *  
        // The same search thread can pick up multiple slice executions post https://github.com/apache/lucene/pull/13472
    @Override
    @Override  
                removeMetricCollectors(context.getTask().getParentTaskId().toString(), context.shardTarget().getShardId().toString(), false)  
    private TieredStoragePerQueryMetric removeMetricCollector() {
        }
        }
        return queryTraceThreshold;
                stats.addAll(Objects.requireNonNull(context.groupStats()));
            put(INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_DEBUG_SETTING.getKey(), INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_DEBUG_SETTING);
     * Returns the fetch info threshold in nanoseconds.
        TimeValue.timeValueMillis(2000),
