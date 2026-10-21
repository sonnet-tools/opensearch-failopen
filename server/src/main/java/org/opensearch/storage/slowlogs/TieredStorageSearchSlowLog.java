import org.opensearch.core.xcontent.XContentBuilder;
        return fetchWarnThreshold;
    }
    /** Query debug threshold setting. */
        }
    }
        private final Logger logger = LogManager.getLogger(TieredStorageSlowLogPrinter.class);
    );
        indexSettings.getScopedSettings()
            } catch (IOException e) {
        Property.IndexScope
        }
    private void setQueryTraceThreshold(TimeValue traceThreshold) {
        this.queryDebugThreshold = debugThreshold.nanos();
            setMetricCollector(searchContext, false);
    );
                stats.addAll(Objects.requireNonNull(context.groupStats()));
    SlowLogLevel getLevel() {
            removeMetricCollector();
        TIERED_STORAGE_SEARCH_SLOWLOG_PREFIX + ".threshold.fetch.warn",
        indexSettings.getScopedSettings()
            log.trace("{}", new TieredStorageSlowLogPrinter(context, tookInNanos, metricCollectors));
     * @return the threshold
    }
    }
 * this file be licensed under the Apache-2.0 license or a
    public static final Setting<TimeValue> INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_WARN_SETTING = Setting.timeSetting(
            }
    public static final String TIERED_STORAGE_SEARCH_SLOWLOG_PREFIX = "index.tiered.storage.slowlog";
        }
            );
     * @return the threshold
        if (tieredStorageSlowlogEnabled) {
    public static final Setting<TimeValue> INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_TRACE_SETTING = Setting.timeSetting(
            .addSettingsUpdateConsumer(INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_INFO_SETTING, this::setFetchInfoThreshold);
    private void setQueryDebugThreshold(TimeValue debugThreshold) {
        // No need to call removeMetricCollector() here as that will be handled in onSliceExecution in both
        SearchContext context,
            this.context = context;
        long traceThreshold
        Property.IndexScope
         * Creates a new slow log printer.
            );
    }
        false,
                    searchContext.shardTarget().getShardId().toString()
                queryWarnThreshold,
        Property.Dynamic,
            // It's also much cleaner than propagating the fetch boolean to TieredStorageQueryMetricService
                tookInNanos,
        TimeValue.timeValueMillis(10000),
import org.opensearch.common.logging.Loggers;
 * The OpenSearch Contributors require contributions made to
                false
                searchContext.shardTarget().getShardId().toString(),
            try {
    private void setFetchDebugThreshold(TimeValue debugThreshold) {
        @Override
                builder.field("source", context.request().source().toString(params));
        TIERED_STORAGE_SEARCH_SLOWLOG_PREFIX + ".threshold.fetch.info",
            log.debug("{}", new TieredStorageSlowLogPrinter(context, tookInNanos, metricCollectors));
        Logger log,
            put(INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_INFO_SETTING.getKey(), INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_INFO_SETTING);
            builder.field("search_type", context.searchType().toString());
     * Returns the query warn threshold in nanoseconds.
            if (context.request().source() != null) {
    /** Fetch trace threshold setting. */
import java.util.Objects;
     */
            .addSettingsUpdateConsumer(INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_WARN_SETTING, this::setQueryWarnThreshold);
        this.queryWarnThreshold = warnThreshold.nanos();
            .addSettingsUpdateConsumer(INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_DEBUG_SETTING, this::setQueryDebugThreshold);
        return TieredStorageQueryMetricService.getInstance().removeMetricCollector(Thread.currentThread().threadId());
        TIERED_STORAGE_SEARCH_SLOWLOG_PREFIX + ".level",
            if (metricCollectors != null && !metricCollectors.isEmpty()) {
    }
        this.queryLogger = LogManager.getLogger(TIERED_STORAGE_SEARCH_SLOWLOG_PREFIX + ".query");
    @Override
        Loggers.setLevel(queryLogger, level.name());
import java.util.Set;
    }
            }
    }
            builder.field("took_millis", TimeUnit.NANOSECONDS.toMillis(tookInNanos));
import java.util.concurrent.TimeUnit;
     * Returns the current slow log level.
    }
        SlowLogLevel.TRACE.name(),
        setLevel(indexSettings.getValue(INDEX_SEARCH_SLOWLOG_LEVEL));
    /**
        indexSettings.getScopedSettings()
        TimeValue.timeValueMillis(-1),
        Property.IndexScope
        long debugThreshold,
import org.apache.logging.log4j.LogManager;
        /**
    public static final Setting<TimeValue> INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_DEBUG_SETTING = Setting.timeSetting(
            }
            put(INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_DEBUG_SETTING.getKey(), INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_DEBUG_SETTING);
    }
        // Only clean up if we were collecting metrics
        TimeValue.timeValueMillis(2000),
     * @return the threshold
        // so we initialize collectors only in onPreSliceExecution
        {
    }
    private void setFetchWarnThreshold(TimeValue warnThreshold) {
    @Override
    }
    public void setTieredStorageSlowlogEnabled(boolean tieredStorageSlowlogEnabled) {
            builder.field("total_shards", context.numberOfShards());
            .addSettingsUpdateConsumer(INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_INFO_SETTING, this::setQueryInfoThreshold);
    }
            setMetricCollector(searchContext, true);
    private void setQueryInfoThreshold(TimeValue infoThreshold) {
        TieredStorageQueryMetricService.getInstance()
         */
    static final class TieredStorageSlowLogPrinter {
    long getFetchWarnThreshold() {
                    builder.value(stat.toString());
        Property.Dynamic,
        TimeValue.timeValueMillis(-1),
                return builder.toString();
            this.tookInNanos = tookInNanos;
        if (tieredStorageSlowlogEnabled) {
        // Only log if tiered storage slow log is enabled
     * Formats slow log output as JSON with warm storage metrics.
        // Only clean up and log if we were collecting metrics
        TimeValue.timeValueMillis(-1),
        // Only collect metrics if tiered storage slow log is enabled
        this.tieredStorageSlowlogEnabled = tieredStorageSlowlogEnabled;
    /** Setting to enable or disable tiered storage search slow log. */
        TIERED_STORAGE_SEARCH_SLOWLOG_PREFIX + ".threshold.query.debug",
     */
    }
        }
        Property.IndexScope
        Property.Dynamic,
    }
                fetchInfoThreshold,
            );
        }
                new TieredStoragePerQueryMetricImpl(
 */
        this.fetchDebugThreshold = debugThreshold.nanos();
     * Sets whether tiered storage slow log is enabled.
     * Returns the query trace threshold in nanoseconds.
        Property.Dynamic,
        indexSettings.getScopedSettings()
 *
     */
        Loggers.setLevel(fetchLogger, level.name());
    );
 *
    long getQueryWarnThreshold() {
        Property.IndexScope
     * Returns the fetch warn threshold in nanoseconds.
        Property.IndexScope
    );
        TimeValue.timeValueMillis(-1),
 */
                context,
            builder.endObject();
    }
        }
        return TieredStorageQueryMetricService.getInstance().removeMetricCollectors(parentTaskId, shardId, isQueryPhase);
     * Returns the query info threshold in nanoseconds.
    private volatile long queryWarnThreshold;
         * @param context the search context
        TIERED_STORAGE_SEARCH_SLOWLOG_PREFIX + ".threshold.query.trace",
    );
    /** Settings prefix for tiered storage search slow log. */
            assert metricCollectors.size() == 1 : "Fetch phase is expected to be single threaded, so we should only have 1 collector";
    }
        Property.Dynamic,
            removeMetricCollectors(context.getTask().getParentTaskId().toString(), context.shardTarget().getShardId().toString(), true)
    }
        indexSettings.getScopedSettings()
            // warm_stats array
     * @return the threshold
        this.fetchInfoThreshold = infoThreshold.nanos();
/*
import java.util.Map;
        return queryDebugThreshold;
 * Search slow log implementation for tiered storage (warm data).
    }
import org.opensearch.common.settings.Setting;
     */
                searchContext.shardTarget().getShardId().toString(),
                ),
            builder.startArray("stats");
        private final SearchContext context;
        return fetchTraceThreshold;
import org.opensearch.common.unit.TimeValue;
    public static final Map<String, Setting<?>> TIERED_STORAGE_SEARCH_SLOWLOG_SETTINGS_MAP = Collections.unmodifiableMap(new HashMap<>() {
        return fetchInfoThreshold;
        return queryInfoThreshold;
    long getFetchDebugThreshold() {
        final List<TieredStoragePerQueryMetric> metricCollectors = new ArrayList<>(
            } else {
    /**
                isQueryPhase
                Thread.currentThread().threadId(),
            builder.startArray("warm_stats");
            builder.field("took", TimeValue.timeValueNanos(tookInNanos).toString());
        List<TieredStoragePerQueryMetric> metricCollectors,
        TimeValue.timeValueMillis(500),
                queryInfoThreshold,
    private SlowLogLevel level;
                    stats.addAll(metricCollectors);
    );
            removeMetricCollector();
     */
    );
        Property.IndexScope
        } else if (debugThreshold >= 0 && tookInNanos > debugThreshold) {
        setQueryTraceThreshold(indexSettings.getValue(INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_TRACE_SETTING));
            // Although fetch phase is single threaded today, we will use the same map implementation for posterity.
        setFetchDebugThreshold(indexSettings.getValue(INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_DEBUG_SETTING));
        // Only clean up if we were collecting metrics
    }
            if (!stats.isEmpty()) {
    /** Fetch debug threshold setting. */
            printSlowLog(
    public void onPreFetchPhase(SearchContext searchContext) {
import java.io.IOException;
            // took and took_millis
        if (tieredStorageSlowlogEnabled) {
    /** Query info threshold setting. */
    /** Slow log level setting. */
import org.opensearch.common.xcontent.XContentFactory;
    /**
    long getQueryTraceThreshold() {
            .addSettingsUpdateConsumer(INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_TRACE_SETTING, this::setQueryTraceThreshold);
    private final Logger fetchLogger;
    private volatile long queryTraceThreshold;
            }
    private final Logger queryLogger;
    }
        if (tieredStorageSlowlogEnabled) {
            .addSettingsUpdateConsumer(INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_DEBUG_SETTING, this::setFetchDebugThreshold);
        if (tieredStorageSlowlogEnabled) {
import java.util.ArrayList;
                fetchWarnThreshold,
     * @param indexSettings the index settings
     */
    private volatile long fetchTraceThreshold;
        Property.Dynamic,
    @Override
        // Fetch phase execution is starting. Add new metric collector only if enabled
            .addSettingsUpdateConsumer(TIERED_STORAGE_SEARCH_SLOWLOG_ENABLED, this::setTieredStorageSlowlogEnabled);
                }
    /** Set of all tiered storage search slow log settings. */
                metricCollectors,
            final List<TieredStoragePerQueryMetric> metricCollectors = new ArrayList<>(
        private XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {
package org.opensearch.storage.slowlogs;
                fetchTraceThreshold
        if (tieredStorageSlowlogEnabled) {
            put(TIERED_STORAGE_SEARCH_SLOWLOG_ENABLED.getKey(), TIERED_STORAGE_SEARCH_SLOWLOG_ENABLED);
        indexSettings.getScopedSettings()
    private void setFetchInfoThreshold(TimeValue infoThreshold) {
    public void onFetchPhase(SearchContext context, long tookInNanos) {
    private void setMetricCollector(SearchContext searchContext, boolean isQueryPhase) {
        TieredStorageSlowLogPrinter(SearchContext context, long tookInNanos, List<TieredStoragePerQueryMetric> metricCollectors) {
    private void setQueryWarnThreshold(TimeValue warnThreshold) {
     */
    /**
    @Override
        }
     * Returns the query debug threshold in nanoseconds.
    }
                throw new RuntimeException(e);
        setTieredStorageSlowlogEnabled(indexSettings.getValue(TIERED_STORAGE_SEARCH_SLOWLOG_ENABLED));
                if (metricCollectors != null) {
        // Get all collectors associated with the task/shard
            this.metricCollectors = metricCollectors;
}
        } else if (infoThreshold >= 0 && tookInNanos > infoThreshold) {
    /**
                builder.nullField("source");
                toXContent(builder, FORMAT_PARAMS);
            log.warn("{}", new TieredStorageSlowLogPrinter(context, tookInNanos, metricCollectors));
import java.util.HashMap;
            put(INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_TRACE_SETTING.getKey(), INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_TRACE_SETTING);
     * Creates a new TieredStorageSearchSlowLog instance.
        return queryWarnThreshold;
         * @param metricCollectors the per-query metric collectors
        Property.Dynamic,
    private TieredStoragePerQueryMetric removeMetricCollector() {
 * @opensearch.experimental
    public static final Setting<TimeValue> INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_TRACE_SETTING = Setting.timeSetting(
        setQueryInfoThreshold(indexSettings.getValue(INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_INFO_SETTING));
    private volatile long fetchInfoThreshold;
            removeMetricCollector();
public final class TieredStorageSearchSlowLog implements SearchOperationListener {
        new HashSet<>(TIERED_STORAGE_SEARCH_SLOWLOG_SETTINGS_MAP.values())
    public static final Setting<TimeValue> INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_DEBUG_SETTING = Setting.timeSetting(
            builder.endArray();
    /** Fetch warn threshold setting. */
                queryTraceThreshold
        );
    public void onPreQueryPhase(SearchContext searchContext) {
    public static final Setting<TimeValue> INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_INFO_SETTING = Setting.timeSetting(
    @Override
 * Logs slow queries and fetches with per-query cache and prefetch metrics.
    public static final Setting<TimeValue> INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_INFO_SETTING = Setting.timeSetting(
        TimeValue.timeValueMillis(-1),
     */
    public static final Setting<Boolean> TIERED_STORAGE_SEARCH_SLOWLOG_ENABLED = Setting.boolSetting(
                metricCollectors,
            );
     */
        }
    private volatile long queryDebugThreshold;
        }
        }
        final SearchShardTask searchTask = searchContext.getTask();
        TIERED_STORAGE_SEARCH_SLOWLOG_PREFIX + ".threshold.query.info",
     * Returns the fetch info threshold in nanoseconds.
    /** Map of all tiered storage search slow log settings keyed by setting name. */
        TimeValue.timeValueMillis(10000),
        private final List<TieredStoragePerQueryMetric> metricCollectors;
    );
            printSlowLog(
    }
    }
        if (searchTask == null) {
        SlowLogLevel::parse,
    @Override
                queryLogger,
import org.opensearch.common.settings.Setting.Property;
                tookInNanos,
    );
        // Only clean up if we were collecting metrics
            put(INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_DEBUG_SETTING.getKey(), INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_DEBUG_SETTING);
    }
        Property.Dynamic,
     * @return the threshold
        }
    private void setFetchTraceThreshold(TimeValue traceThreshold) {
    }
    long getQueryInfoThreshold() {
            removeMetricCollector();
        } else if (traceThreshold >= 0 && tookInNanos > traceThreshold) {
 * SPDX-License-Identifier: Apache-2.0
            removeMetricCollectors(
    public TieredStorageSearchSlowLog(IndexSettings indexSettings) {
        TIERED_STORAGE_SEARCH_SLOWLOG_PREFIX + ".threshold.fetch.trace",
        this.fetchTraceThreshold = traceThreshold.nanos();
    }
        TimeValue.timeValueMillis(5000),
            put(INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_INFO_SETTING.getKey(), INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_INFO_SETTING);
    ) {
        if (tieredStorageSlowlogEnabled) {
        this.fetchWarnThreshold = warnThreshold.nanos();
     * @return the slow log level
        // Only clean up if we were collecting metrics
        final Logger log = isQueryPhase ? queryLogger : fetchLogger;
    @Override
    }
                fetchLogger,
    private volatile boolean tieredStorageSlowlogEnabled;
    private volatile long fetchWarnThreshold;
     * @opensearch.experimental
        return level;
                    builder.value(collector.toString());
    /** Fetch info threshold setting. */
        return queryTraceThreshold;
            .addSettingsUpdateConsumer(INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_WARN_SETTING, this::setFetchWarnThreshold);
            }
    private static final ToXContent.Params FORMAT_PARAMS = new ToXContent.MapParams(Collections.singletonMap("pretty", "false"));
                true
        // The same search thread can pick up multiple slice executions post https://github.com/apache/lucene/pull/13472
     * Returns the fetch trace threshold in nanoseconds.
    private void printSlowLog(
        // concurrent search and non-concurrent search cases
    public void onFailedSliceExecution(SearchContext searchContext) {
        TimeValue.timeValueMillis(2000),
        this.fetchLogger = LogManager.getLogger(TIERED_STORAGE_SEARCH_SLOWLOG_PREFIX + ".fetch");
import java.util.List;
        return fetchDebugThreshold;
    private Set<TieredStoragePerQueryMetric> removeMetricCollectors(String parentTaskId, String shardId, boolean isQueryPhase) {
        setFetchInfoThreshold(indexSettings.getValue(INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_INFO_SETTING));
        setFetchWarnThreshold(indexSettings.getValue(INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_WARN_SETTING));
    public void onFailedFetchPhase(SearchContext searchContext) {
                }
                XContentBuilder builder = XContentFactory.jsonBuilder();
         * @param tookInNanos the time taken in nanoseconds
            removeMetricCollectors(
import java.util.Collections;
        }
        this.level = level;
    public static final Setting<SlowLogLevel> INDEX_SEARCH_SLOWLOG_LEVEL = new Setting<>(
        Property.IndexScope
            put(INDEX_SEARCH_SLOWLOG_LEVEL.getKey(), INDEX_SEARCH_SLOWLOG_LEVEL);
        TimeValue.timeValueMillis(5000),
    public void onQueryPhase(SearchContext context, long tookInNanos) {
            );
import org.opensearch.action.search.SearchShardTask;
import org.opensearch.core.xcontent.ToXContent;
            builder.endArray();
    private volatile long queryInfoThreshold;
        }
        Property.IndexScope
        private final long tookInNanos;
import org.apache.logging.log4j.Logger;
    public void onPreSliceExecution(SearchContext searchContext) {
    });
    }
            log.error("Warm Slow Log: Search Task not expected to be null");
    }
                for (Object stat : stats) {
            put(INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_TRACE_SETTING.getKey(), INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_TRACE_SETTING);
        Property.Dynamic,
            if (context.groupStats() != null) {
/**
        indexSettings.getScopedSettings()
     * @return the threshold
                fetchDebugThreshold,
        TIERED_STORAGE_SEARCH_SLOWLOG_PREFIX + ".threshold.query.warn",
    long getFetchTraceThreshold() {
     * @return the threshold
            removeMetricCollector();
import org.opensearch.search.internal.SearchContext;
    @Override
        }
            // stats array
     */
            .addMetricCollector(
            );
                removeMetricCollectors(context.getTask().getParentTaskId().toString(), context.shardTarget().getShardId().toString(), false)
            // search_type, total_shards, and source
            .addSettingsUpdateConsumer(INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_TRACE_SETTING, this::setFetchTraceThreshold);
import org.opensearch.index.IndexSettings;
    @Override
        TIERED_STORAGE_SEARCH_SLOWLOG_PREFIX + ".enabled",
     * Returns the fetch debug threshold in nanoseconds.
                searchContext.getTask().getParentTaskId().toString(),
import org.opensearch.index.shard.SearchOperationListener;
        Property.Dynamic,
    /**
    private void setLevel(SlowLogLevel level) {
    public void onSliceExecution(SearchContext searchContext) {
     */
    /**
    );
     * @return the threshold
                queryDebugThreshold,
     *
            List<Object> stats = new ArrayList<>();
    }
    public void onFailedQueryPhase(SearchContext searchContext) {
        indexSettings.getScopedSettings()
        if (tieredStorageSlowlogEnabled) {
        TIERED_STORAGE_SEARCH_SLOWLOG_PREFIX + ".threshold.fetch.debug",
 * compatible open source license.
            put(INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_WARN_SETTING.getKey(), INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_WARN_SETTING);
            builder.startObject();
import java.util.HashSet;
            return builder;
        public String toString() {
                context,
        TimeValue.timeValueMillis(500),
        setQueryWarnThreshold(indexSettings.getValue(INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_WARN_SETTING));
        indexSettings.getScopedSettings()
    }
     */
import org.opensearch.common.logging.SlowLogLevel;
        long infoThreshold,
    private volatile long fetchDebugThreshold;
    public static final Setting<TimeValue> INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_WARN_SETTING = Setting.timeSetting(
        TimeValue.timeValueMillis(-1),
        if (warnThreshold >= 0 && tookInNanos > warnThreshold) {
        TimeValue.timeValueMillis(-1),
        TimeValue.timeValueMillis(-1),
                for (TieredStoragePerQueryMetric collector : metricCollectors) {
    /** Query warn threshold setting. */
    long getFetchInfoThreshold() {
     * @param tieredStorageSlowlogEnabled true to enable
                searchContext.getTask().getParentTaskId().toString(),
        this.queryInfoThreshold = infoThreshold.nanos();
        long tookInNanos,
    /**
        Property.IndexScope
            put(INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_WARN_SETTING.getKey(), INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_WARN_SETTING);
    /**
        long warnThreshold,
    /** Query trace threshold setting. */
                    searchTask == null ? null : searchTask.getParentTaskId().toString(),
        setFetchTraceThreshold(indexSettings.getValue(INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_TRACE_SETTING));
    }
        setQueryDebugThreshold(indexSettings.getValue(INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_DEBUG_SETTING));
        indexSettings.getScopedSettings().addSettingsUpdateConsumer(INDEX_SEARCH_SLOWLOG_LEVEL, this::setLevel);
    long getQueryDebugThreshold() {
    );
    /**
            log.info("{}", new TieredStorageSlowLogPrinter(context, tookInNanos, metricCollectors));
                }
    public static final Set<Setting<?>> TIERED_STORAGE_SEARCH_SLOWLOG_SETTINGS = Collections.unmodifiableSet(
    // TODO check this level
    /**
    /**
        this.queryTraceThreshold = traceThreshold.nanos();
    }
