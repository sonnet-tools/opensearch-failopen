        assertTrue(slowLog.getFetchWarnThreshold() >= 0);
import org.opensearch.action.search.SearchShardTask;
            .put(TieredStorageSearchSlowLog.TIERED_STORAGE_SEARCH_SLOWLOG_ENABLED.getKey(), true)
        // Create a metric collector
        slowLog.onFailedSliceExecution(searchContext);
        TieredStorageSearchSlowLog.TieredStorageSlowLogPrinter printer = new TieredStorageSearchSlowLog.TieredStorageSlowLogPrinter(
    }
        String expectedPrefix = TieredStorageSearchSlowLog.TIERED_STORAGE_SEARCH_SLOWLOG_PREFIX;
    }
        slowLog.setTieredStorageSlowlogEnabled(false);
        // Verify no exception is thrown
    }
        // Should call removeMetricCollector when enabled
        // Verify that constructor properly initializes all settings
    }
        slowLog = new TieredStorageSearchSlowLog(indexSettings);
        slowLog.setTieredStorageSlowlogEnabled(true);
        // Test that time values are properly converted to nanoseconds
        slowLog.onPreSliceExecution(searchContext);
        assertTrue(result.length() > 0);
        // Test all threshold getters return expected values
        // Should call setMetricCollector when enabled
        assertTrue(slowLog.getQueryWarnThreshold() > 0);
        assertNotNull(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_TRACE_SETTING);
    public void testSetTieredStorageSlowlogEnabled() {
        settingSet.add(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_LEVEL);
        assertTrue(result.contains("took_millis"));
        // Just verify it doesn't throw exception
        // Enable slow log
        when(searchContext.numberOfShards()).thenReturn(1);
    }
    }
            .put(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_INFO_SETTING.getKey(), "500ms")
    public void testDifferentLogLevels() {
        assertNotNull(result);
    public void testOnPreFetchPhaseWhenDisabled() {
import org.junit.Before;
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-1", "shard-0");
        // Mock metric service
        java.util.List<TieredStoragePerQueryMetric> metrics = java.util.Arrays.asList(metric);
        assertEquals(SlowLogLevel.TRACE, slowLog.getLevel());
        slowLog.onQueryPhase(searchContext, traceTime);
        // Test that settings map contains all expected settings
        assertTrue(slowLog.getQueryDebugThreshold() > 0);
        searchTask = mock(SearchShardTask.class);
            TimeUnit.MILLISECONDS.toNanos(100),
        // Test printer when search request source is null
        // Disable slow log
        assertTrue(
            .put(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_INFO_SETTING.getKey(), "500ms")
        // Mock search context setup
        slowLog.onQueryPhase(searchContext, tookInNanos);
import org.opensearch.common.settings.IndexScopedSettings;
package org.opensearch.storage.slowlogs;
            .put(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_LEVEL.getKey(), "TRACE")
        // Test with time above trace threshold
        slowLog.setTieredStorageSlowlogEnabled(true);
        slowLog.onSliceExecution(searchContext);
    }
            TimeUnit.MILLISECONDS.toNanos(100),
        slowLog.setTieredStorageSlowlogEnabled(true);
        slowLog.setTieredStorageSlowlogEnabled(false);
import org.opensearch.core.index.shard.ShardId;
/**
        settingSet.add(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_WARN_SETTING);
    public void testOnPreSliceExecutionWhenDisabled() {
            searchContext,
        slowLog.onFailedSliceExecution(searchContext);
        slowLog.onSliceExecution(searchContext);
        assertFalse(TieredStorageSearchSlowLog.TIERED_STORAGE_SEARCH_SLOWLOG_SETTINGS_MAP.isEmpty());
        long fetchTime = TimeUnit.MILLISECONDS.toNanos(600); // Above info threshold
        slowLog.onFailedFetchPhase(searchContext);
        assertTrue(result.contains("search_type"));
        // Verify no exceptions are thrown
        slowLog.setTieredStorageSlowlogEnabled(false);
        slowLog.onPreFetchPhase(searchContext);
        slowLog.onQueryPhase(searchContext, infoTime);
    public void testOnFetchPhaseWhenDisabled() {
        slowLog.setTieredStorageSlowlogEnabled(false);
    public void testOnFailedQueryPhaseWhenEnabled() {
    }
 */
 * The OpenSearch Contributors require contributions made to
import org.opensearch.common.settings.Settings;
        slowLog.onPreFetchPhase(searchContext);
        when(searchContext.searchType()).thenReturn(org.opensearch.action.search.SearchType.QUERY_THEN_FETCH);
        super.setUp();
        settingSet.add(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_TRACE_SETTING);
import org.opensearch.search.internal.ShardSearchRequest;
        slowLog.onPreSliceExecution(searchContext);
        // Verify no exception is thrown
        settingSet.add(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_WARN_SETTING);
        long tookInNanos = TimeUnit.MILLISECONDS.toNanos(50); // Above 10ms trace threshold
        assertTrue(result.contains("took"));
        slowLog.setTieredStorageSlowlogEnabled(true);
            .put(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_DEBUG_SETTING.getKey(), "100ms")
        assertTrue(slowLog.getQueryDebugThreshold() > 0);
        settingSet.add(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_INFO_SETTING);
        // Disable slow log
    private SearchShardTask searchTask;
        assertTrue(result.contains("warm_stats"));
        slowLog.setTieredStorageSlowlogEnabled(true);
        slowLog.onPreQueryPhase(searchContext);
        );
    public void testOnFetchPhaseWhenEnabled() {
        // Test WARN level (1s threshold)
        SearchShardTarget shardTarget = new SearchShardTarget("testNode", mock(ShardId.class), null, null);
        // onPreQueryPhase should not do anything as per the implementation
        String result = printer.toString();
        assertNotNull(result);
        slowLog.onPreSliceExecution(searchContext);
    private TieredStorageQueryMetricService metricService;
        slowLog.setTieredStorageSlowlogEnabled(true);
        // Verify no exception is thrown
        slowLog.setTieredStorageSlowlogEnabled(true);
        assertTrue(slowLog.getQueryInfoThreshold() >= slowLog.getQueryDebugThreshold());
        // Enable slow log
        assertTrue(slowLog.getQueryDebugThreshold() >= slowLog.getQueryTraceThreshold());
        // Enable slow log
        );
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        assertNotNull(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_TRACE_SETTING);
                TieredStorageSearchSlowLog.TIERED_STORAGE_SEARCH_SLOWLOG_PREFIX + ".threshold.query.warn"
    public void testFetchPhaseLogging() {
    }
    }
        assertTrue(TieredStorageSearchSlowLog.TIERED_STORAGE_SEARCH_SLOWLOG_ENABLED.getKey().startsWith(expectedPrefix));
        assertNotNull(result);
        long traceTime = TimeUnit.MILLISECONDS.toNanos(15);
        // No direct way to verify, but should not throw exception
        // Verify no exception is thrown
            searchContext,
    }
 * SPDX-License-Identifier: Apache-2.0
    }
        assertTrue(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_LEVEL.getKey().startsWith(expectedPrefix));
    public void testOnSliceExecutionWhenEnabled() {
        // Test fetch phase with different thresholds
        slowLog.onPreFetchPhase(searchContext);
        long tookInNanos = TimeUnit.MILLISECONDS.toNanos(50);
        assertTrue(result.contains("\"source\":null"));
        slowLog.setTieredStorageSlowlogEnabled(false);
            java.util.Collections.emptyList()
        // Test INFO level (500ms threshold)
        // Test DEBUG level (100ms threshold)
    }
    public void testOnPreSliceExecutionWhenEnabled() {
}
        // Verify hierarchy: warn > info > debug > trace
            .put(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_DEBUG_SETTING.getKey(), "100ms")
    public void testThresholdGetters() {
        slowLog.onFailedFetchPhase(searchContext);
        // Should handle null task gracefully
            TimeUnit.MILLISECONDS.toNanos(100),
        Set<Setting<?>> settingSet = new HashSet<>(IndexScopedSettings.BUILT_IN_INDEX_SETTINGS);
        String result = printer.toString();
    public void testOnFailedFetchPhaseWhenDisabled() {
        settingSet.add(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_DEBUG_SETTING);
        // Should contain metric data in warm_stats
        slowLog.setTieredStorageSlowlogEnabled(true);
        assertTrue(slowLog.getFetchTraceThreshold() >= 0);
    }
        long debugTime = TimeUnit.MILLISECONDS.toNanos(150);
import org.opensearch.Version;
        assertTrue(slowLog.getFetchTraceThreshold() > 0);
        assertTrue(slowLog.getFetchDebugThreshold() > 0);
        // All should complete without exceptions
        when(searchContext.getTask()).thenReturn(searchTask);
        // Verify no exception is thrown
    private SearchContext searchContext;
        // Verify no exception is thrown
        slowLog.onQueryPhase(searchContext, warnTime);
        assertTrue(slowLog.getQueryWarnThreshold() > 0);
            TieredStorageSearchSlowLog.TIERED_STORAGE_SEARCH_SLOWLOG_SETTINGS_MAP.containsKey(
            java.util.Collections.emptyList()
    }
        slowLog.setTieredStorageSlowlogEnabled(true);
        TieredStorageSearchSlowLog.TieredStorageSlowLogPrinter printer = new TieredStorageSearchSlowLog.TieredStorageSlowLogPrinter(
            )
public class TieredStorageSearchSlowLogTests extends OpenSearchTestCase {
        assertTrue(slowLog.getQueryInfoThreshold() > 0);
        assertTrue(slowLog.getFetchWarnThreshold() > 0);
        assertTrue(slowLog.getQueryInfoThreshold() > 0);
        assertTrue(slowLog.getQueryDebugThreshold() >= 0);
        long tookInNanos = TimeUnit.MILLISECONDS.toNanos(50);
 */
        // Disable slow log
    public void testOnSliceExecutionWhenDisabled() {
import org.opensearch.core.tasks.TaskId;
        assertFalse(TieredStorageSearchSlowLog.TIERED_STORAGE_SEARCH_SLOWLOG_SETTINGS.isEmpty());
        assertNotNull(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_INFO_SETTING);
        slowLog.onPreFetchPhase(searchContext);
        );
            .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
        slowLog.setTieredStorageSlowlogEnabled(false);
    }
            java.util.Collections.emptyList()
        );
        assertNotNull(TieredStorageSearchSlowLog.TIERED_STORAGE_SEARCH_SLOWLOG_ENABLED);
        // Verify no exception is thrown
    public void testSettingsPrefix() {
        when(searchContext.shardTarget()).thenReturn(shardTarget);
    public void testSlowLogSettings() {
        );
    public void testOnQueryPhaseWhenDisabled() {
            searchContext,
        TieredStorageSearchSlowLog.TieredStorageSlowLogPrinter printer = new TieredStorageSearchSlowLog.TieredStorageSlowLogPrinter(
import java.util.Set;
        );
 * Comprehensive unit tests for TieredStorageSearchSlowLog
        // Verify the settings prefix is correct
    }
        assertTrue(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_WARN_SETTING.getKey().startsWith(expectedPrefix));
        when(searchContext.request()).thenReturn(mock(ShardSearchRequest.class));
        // Verify no exception is thrown
        assertTrue(slowLog.getFetchInfoThreshold() > 0);
        assertTrue(slowLog.getFetchDebugThreshold() >= 0);
            .put(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_TRACE_SETTING.getKey(), "10ms")
        // Should not call removeMetricCollector when disabled
        when(searchContext.getTask()).thenReturn(null);
    public void testOnPreFetchPhaseWhenEnabled() {
    @Before
        // Verify no exception is thrown
        // Verify no exception is thrown
    public void testOnFailedFetchPhaseWhenEnabled() {
            java.util.Collections.emptyList()
        slowLog.setTieredStorageSlowlogEnabled(true);
        assertTrue(result.contains("total_shards"));
        assertNotNull(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_DEBUG_SETTING);
        long tookInNanos = TimeUnit.MILLISECONDS.toNanos(50);
    }
        // Enable slow log
    public void testOnQueryPhaseWhenEnabled() {
        assertNotNull(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_DEBUG_SETTING);
        slowLog.onQueryPhase(searchContext, tookInNanos);
        // Should not call setMetricCollector when disabled
        // Create slow log instance
            .put(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_TRACE_SETTING.getKey(), "10ms")
        String result = printer.toString();
        assertTrue(
            TimeUnit.MILLISECONDS.toNanos(100),
    public void testOnFailedSliceExecutionWhenEnabled() {
    public void testSlowLogPrinterWithNullSource() {
import org.opensearch.common.settings.Setting;
        when(searchContext.request().source()).thenReturn(null);
        settingSet.add(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_DEBUG_SETTING);
        // Create mock objects
                TieredStorageSearchSlowLog.TIERED_STORAGE_SEARCH_SLOWLOG_PREFIX + ".level"
        assertTrue(slowLog.getQueryInfoThreshold() >= 0);
            .put(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_WARN_SETTING.getKey(), "1s")
        slowLog.onPreFetchPhase(searchContext);
        slowLog.onQueryPhase(searchContext, debugTime);
        // Enable slow log
        assertTrue(slowLog.getQueryWarnThreshold() >= slowLog.getQueryInfoThreshold());
        settingSet.add(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_TRACE_SETTING);
        assertEquals(10, TieredStorageSearchSlowLog.TIERED_STORAGE_SEARCH_SLOWLOG_SETTINGS.size());
        metricService = mock(TieredStorageQueryMetricService.class);
        slowLog.setTieredStorageSlowlogEnabled(true);
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        assertTrue(slowLog.getQueryTraceThreshold() > 0);
        indexSettings = createMockIndexSettings();
        assertNotNull(printer);
        when(searchContext.request().source()).thenReturn(null);
    }
        assertTrue(slowLog.getQueryTraceThreshold() >= 0);
        slowLog.setTieredStorageSlowlogEnabled(true);
    }
        when(searchContext.groupStats()).thenReturn(groupStats);
 * compatible open source license.
    public void testConstructorInitializesSettings() {
        metric.recordFileAccess("file1.block_0_1", true);
        // Verify no exception is thrown
    public void testSlowLogSettingsSet() {
        TieredStorageSearchSlowLog.TieredStorageSlowLogPrinter printer = new TieredStorageSearchSlowLog.TieredStorageSlowLogPrinter(
    public void testOnFailedQueryPhaseWhenDisabled() {
        // Test behavior when search task is null
        // Mock group stats - use List<String> to match expected type
        // Mock search task - use string directly to avoid TaskId class issues
    }
    }
        // Test enabling/disabling slow log
        searchContext = mock(SearchContext.class);
        // Test that all settings are properly defined
        // Should call removeMetricCollector when enabled
            .put(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_WARN_SETTING.getKey(), "1s")
    }
        slowLog.onFailedQueryPhase(searchContext);
        Settings settings = Settings.builder()
        IndexMetadata metadata = IndexMetadata.builder("Index").settings(settings).build();
        // Disable slow log
        assertNotNull(result);
import org.opensearch.cluster.metadata.IndexMetadata;
    public void testSlowLogPrinterWithGroupStats() {
        TieredStorageSearchSlowLog.TieredStorageSlowLogPrinter printer = new TieredStorageSearchSlowLog.TieredStorageSlowLogPrinter(
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import static org.mockito.Mockito.mock;
    public void testTieredStorageSlowLogPrinterToString() {
        // Should not call removeMetricCollector when disabled
        assertTrue(result.contains("task-1"));
            searchContext,
import org.opensearch.index.IndexSettings;
        slowLog.setTieredStorageSlowlogEnabled(false);
        slowLog.setTieredStorageSlowlogEnabled(false);
 *
import java.util.HashSet;
        return new IndexSettings(metadata, settings, new IndexScopedSettings(settings, settingSet));
        long infoTime = TimeUnit.MILLISECONDS.toNanos(600);
    }
    }
import static org.mockito.Mockito.when;
        assertTrue(slowLog.getQueryTraceThreshold() > 0);
    }
        assertTrue(result.contains("warm_stats"));
    }
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(result.contains("parentTask"));
        when(searchTask.getParentTaskId()).thenReturn(TaskId.EMPTY_TASK_ID);
                TieredStorageSearchSlowLog.TIERED_STORAGE_SEARCH_SLOWLOG_PREFIX + ".enabled"
/*
        // Test different time thresholds for different log levels
    public void testOnPreQueryPhase() {
        settingSet.add(TieredStorageSearchSlowLog.TIERED_STORAGE_SEARCH_SLOWLOG_ENABLED);
        assertNotNull(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_LEVEL);
        assertNotNull(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_WARN_SETTING);
            TimeUnit.MILLISECONDS.toNanos(100),
    public void testTimeValueConversion() {
        java.util.List<String> groupStats = java.util.Arrays.asList("stat1", "stat2");
        String result = printer.toString();
        // Verify no exception is thrown
        assertTrue(result.contains("stats"));
        // Verify no exception is thrown
        // Verify no exception is thrown
        assertTrue(
        metric.recordPrefetch("file2", 1);
            TieredStorageSearchSlowLog.TIERED_STORAGE_SEARCH_SLOWLOG_SETTINGS_MAP.containsKey(
            metrics
        assertNotNull(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_WARN_SETTING);
        // Disable slow log
    }
    private IndexSettings createMockIndexSettings() {
    }
        slowLog.setTieredStorageSlowlogEnabled(false);
        assertTrue(slowLog.getFetchInfoThreshold() >= 0);
    public void testSlowLogSettingsMap() {
        slowLog.onFetchPhase(searchContext, tookInNanos);
        );
import org.opensearch.common.logging.SlowLogLevel;
        // Disable slow log
    public void testOnFailedSliceExecutionWhenDisabled() {
import org.opensearch.search.internal.SearchContext;
        slowLog.onFetchPhase(searchContext, tookInNanos);
    }
        assertNotNull(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_INFO_SETTING);
        assertTrue(result.length() > 0);
import org.opensearch.test.OpenSearchTestCase;
    }
    public void setUp() throws Exception {
    }
        // Enable slow log
        assertTrue(slowLog.getQueryWarnThreshold() >= 0);
            )
import java.util.concurrent.TimeUnit;
        // Test TRACE level (10ms threshold)
        settingSet.add(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_INFO_SETTING);
        // Enable slow log
        // Test that settings set contains all expected settings
            .build();
        );
    public void testSearchContextWithNullTask() {
        // Disable slow log
            searchContext,
            )
        assertTrue(result.contains("stats"));
        // Should contain expected JSON structure
        slowLog.onSliceExecution(searchContext);
        long warnTime = TimeUnit.MILLISECONDS.toNanos(1100);
        // No direct way to verify, but should not throw exception
        // Verify no exception is thrown
            TieredStorageSearchSlowLog.TIERED_STORAGE_SEARCH_SLOWLOG_SETTINGS_MAP.containsKey(
import org.opensearch.search.SearchShardTarget;
    }
        // Enable slow log
        // Verify no exception is thrown
    public void testTieredStorageSlowLogPrinterConstructor() {
    private IndexSettings indexSettings;
    }
        // Should complete without exceptions
        slowLog.onFetchPhase(searchContext, fetchTime);
    private TieredStorageSearchSlowLog slowLog;
        slowLog.onFailedQueryPhase(searchContext);
    }
        // Disable slow log
        metric.recordEndTime();
    public void testTieredStorageSlowLogPrinterWithMetrics() {
