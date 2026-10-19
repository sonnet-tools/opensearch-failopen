            .put(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_DEBUG_SETTING.getKey(), "100ms")
        Set<Setting<?>> settingSet = new HashSet<>(IndexScopedSettings.BUILT_IN_INDEX_SETTINGS);
    }  
    public void testOnFetchPhaseWhenDisabled() {
    public void testOnPreSliceExecutionWhenEnabled() {
            java.util.Collections.emptyList()
        when(searchContext.searchType()).thenReturn(org.opensearch.action.search.SearchType.QUERY_THEN_FETCH);
    private IndexSettings createMockIndexSettings() {  
        assertTrue(result.contains("parentTask"));
            .put(TieredStorageSearchSlowLog.TIERED_STORAGE_SEARCH_SLOWLOG_ENABLED.getKey(), true)
        // Test different time thresholds for different log levels
import org.opensearch.common.settings.Settings;
        settingSet.add(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_WARN_SETTING);
        assertNotNull(result);
        assertTrue(result.length() > 0);  
        // No direct way to verify, but should not throw exception
        slowLog.setTieredStorageSlowlogEnabled(true);
        // Verify no exception is thrown  
 * The OpenSearch Contributors require contributions made to  
        settingSet.add(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_INFO_SETTING);
/*  
    public void testOnPreQueryPhase() {
        assertTrue(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_WARN_SETTING.getKey().startsWith(expectedPrefix));  
        assertTrue(result.contains("warm_stats"));
    }  
        long tookInNanos = TimeUnit.MILLISECONDS.toNanos(50);
        // Verify hierarchy: warn > info > debug > trace
    public void testOnFailedSliceExecutionWhenEnabled() {
            searchContext,
        return new IndexSettings(metadata, settings, new IndexScopedSettings(settings, settingSet));
        // Verify the settings prefix is correct
                TieredStorageSearchSlowLog.TIERED_STORAGE_SEARCH_SLOWLOG_PREFIX + ".enabled"
        assertNotNull(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_DEBUG_SETTING);
        slowLog.onFailedQueryPhase(searchContext);
    public void testDifferentLogLevels() {
        // Verify no exception is thrown  
        assertTrue(slowLog.getQueryDebugThreshold() >= slowLog.getQueryTraceThreshold());
        // Should call removeMetricCollector when enabled  
    }
        // Test behavior when search task is null  
            metrics
        assertNotNull(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_DEBUG_SETTING);  
    }  
    }
        assertTrue(slowLog.getQueryInfoThreshold() > 0);
        );
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.action.search.SearchShardTask;
    public void testSlowLogPrinterWithGroupStats() {
        assertNotNull(result);
package org.opensearch.storage.slowlogs;
        String expectedPrefix = TieredStorageSearchSlowLog.TIERED_STORAGE_SEARCH_SLOWLOG_PREFIX;  
                TieredStorageSearchSlowLog.TIERED_STORAGE_SEARCH_SLOWLOG_PREFIX + ".level"
        when(searchTask.getParentTaskId()).thenReturn(TaskId.EMPTY_TASK_ID);  
    private SearchContext searchContext;
        settingSet.add(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_TRACE_SETTING);
        Settings settings = Settings.builder()
        // Verify that constructor properly initializes all settings
        // Verify no exception is thrown  
        // Verify no exception is thrown
        slowLog.onFailedQueryPhase(searchContext);
    public void testOnFailedQueryPhaseWhenDisabled() {  
    }
        long tookInNanos = TimeUnit.MILLISECONDS.toNanos(50);  
        slowLog.setTieredStorageSlowlogEnabled(true);  
    public void testOnQueryPhaseWhenDisabled() {
        // Test that settings map contains all expected settings  
            )
        // Test with time above trace threshold
        assertNotNull(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_TRACE_SETTING);
    }  
            .put(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_WARN_SETTING.getKey(), "1s")  
import org.opensearch.core.index.shard.ShardId;
            .put(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_INFO_SETTING.getKey(), "500ms")
        super.setUp();
        assertTrue(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_LEVEL.getKey().startsWith(expectedPrefix));
    public void setUp() throws Exception {  
        slowLog.onPreFetchPhase(searchContext);
        // Should not call setMetricCollector when disabled  
        slowLog.onPreFetchPhase(searchContext);
    }
        slowLog.onFailedSliceExecution(searchContext);
        assertNotNull(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_WARN_SETTING);
        slowLog.setTieredStorageSlowlogEnabled(true);
        slowLog.onQueryPhase(searchContext, warnTime);
        assertTrue(slowLog.getFetchInfoThreshold() > 0);  
        // Enable slow log
    public void testOnFailedFetchPhaseWhenDisabled() {  
    public void testSearchContextWithNullTask() {
        // All should complete without exceptions
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            java.util.Collections.emptyList()  
        assertNotNull(result);
        assertTrue(result.contains("stats"));  
        // Test WARN level (1s threshold)  
        // Mock search task - use string directly to avoid TaskId class issues
            java.util.Collections.emptyList()
    }
    public void testOnPreSliceExecutionWhenDisabled() {
        // Disable slow log
    private SearchShardTask searchTask;
    public void testOnPreFetchPhaseWhenEnabled() {  
            TimeUnit.MILLISECONDS.toNanos(100),  
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-1", "shard-0");  
import org.opensearch.common.settings.IndexScopedSettings;
 */  
        slowLog.onSliceExecution(searchContext);  
    public void testSlowLogSettingsSet() {
    private TieredStorageQueryMetricService metricService;  
    public void testSettingsPrefix() {
        when(searchContext.getTask()).thenReturn(null);
import org.junit.Before;  
        java.util.List<String> groupStats = java.util.Arrays.asList("stat1", "stat2");
        slowLog.onSliceExecution(searchContext);
    }
        long infoTime = TimeUnit.MILLISECONDS.toNanos(600);  
    }
    public void testOnFailedQueryPhaseWhenEnabled() {  
        assertTrue(slowLog.getQueryTraceThreshold() >= 0);
        assertNotNull(printer);
        // Should not call removeMetricCollector when disabled
            .put(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_DEBUG_SETTING.getKey(), "100ms")  
        assertTrue(slowLog.getQueryWarnThreshold() > 0);  
        // Verify no exceptions are thrown
        slowLog.setTieredStorageSlowlogEnabled(false);  
        slowLog.onFailedSliceExecution(searchContext);
        );
        assertTrue(slowLog.getFetchDebugThreshold() > 0);
import java.util.HashSet;
        // Should not call removeMetricCollector when disabled
}
    public void testSlowLogPrinterWithNullSource() {
        // Enable slow log
        long debugTime = TimeUnit.MILLISECONDS.toNanos(150);
        // Enable slow log
        // Verify no exception is thrown
        when(searchContext.request().source()).thenReturn(null);
    public void testThresholdGetters() {  
    public void testFetchPhaseLogging() {
        when(searchContext.numberOfShards()).thenReturn(1);  
        assertTrue(slowLog.getQueryTraceThreshold() > 0);  
        // Verify no exception is thrown
        // Should contain expected JSON structure
    }
        TieredStorageSearchSlowLog.TieredStorageSlowLogPrinter printer = new TieredStorageSearchSlowLog.TieredStorageSlowLogPrinter(  
        settingSet.add(TieredStorageSearchSlowLog.TIERED_STORAGE_SEARCH_SLOWLOG_ENABLED);
        assertNotNull(TieredStorageSearchSlowLog.TIERED_STORAGE_SEARCH_SLOWLOG_ENABLED);  
        // Disable slow log
        searchContext = mock(SearchContext.class);
    }
        assertTrue(slowLog.getQueryInfoThreshold() >= 0);  
            searchContext,  
import org.opensearch.search.internal.ShardSearchRequest;
        // Enable slow log
        assertTrue(slowLog.getQueryWarnThreshold() >= 0);
        assertTrue(slowLog.getFetchWarnThreshold() > 0);
    }
        slowLog.setTieredStorageSlowlogEnabled(true);  
            .put(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_WARN_SETTING.getKey(), "1s")
        assertTrue(slowLog.getQueryWarnThreshold() > 0);  
        // Create a metric collector
        assertTrue(
        // Enable slow log
/**  
        searchTask = mock(SearchShardTask.class);  
import java.util.Set;  
        );
    }
        slowLog.setTieredStorageSlowlogEnabled(true);
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
        IndexMetadata metadata = IndexMetadata.builder("Index").settings(settings).build();  
        // Verify no exception is thrown  
        slowLog.setTieredStorageSlowlogEnabled(true);
        when(searchContext.request()).thenReturn(mock(ShardSearchRequest.class));
        when(searchContext.groupStats()).thenReturn(groupStats);
            searchContext,
        slowLog.setTieredStorageSlowlogEnabled(false);
            searchContext,
        when(searchContext.request().source()).thenReturn(null);  
 * SPDX-License-Identifier: Apache-2.0
        // Should call removeMetricCollector when enabled
        when(searchContext.shardTarget()).thenReturn(shardTarget);
    public void testOnFailedSliceExecutionWhenDisabled() {  
            .put(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_TRACE_SETTING.getKey(), "10ms")  
        slowLog.setTieredStorageSlowlogEnabled(false);
        // Verify no exception is thrown  
    public void testOnFailedFetchPhaseWhenEnabled() {  
            searchContext,
        // Test enabling/disabling slow log
        slowLog.onPreSliceExecution(searchContext);  
            TieredStorageSearchSlowLog.TIERED_STORAGE_SEARCH_SLOWLOG_SETTINGS_MAP.containsKey(  
        assertTrue(result.contains("stats"));
    public void testOnSliceExecutionWhenEnabled() {  
        // Verify no exception is thrown
        slowLog.setTieredStorageSlowlogEnabled(false);  
import org.opensearch.common.settings.Setting;  
        String result = printer.toString();  
            TieredStorageSearchSlowLog.TIERED_STORAGE_SEARCH_SLOWLOG_SETTINGS_MAP.containsKey(
        // Mock metric service
    }
        assertEquals(SlowLogLevel.TRACE, slowLog.getLevel());
        TieredStorageSearchSlowLog.TieredStorageSlowLogPrinter printer = new TieredStorageSearchSlowLog.TieredStorageSlowLogPrinter(
        assertEquals(10, TieredStorageSearchSlowLog.TIERED_STORAGE_SEARCH_SLOWLOG_SETTINGS.size());
    public void testSlowLogSettings() {
        slowLog.onQueryPhase(searchContext, traceTime);
    }
    public void testOnQueryPhaseWhenEnabled() {
    }  
        slowLog.onFetchPhase(searchContext, fetchTime);
        );  
        assertTrue(slowLog.getQueryWarnThreshold() >= slowLog.getQueryInfoThreshold());  
        // Disable slow log
 */
public class TieredStorageSearchSlowLogTests extends OpenSearchTestCase {  
        // Test that all settings are properly defined
        assertTrue(slowLog.getQueryDebugThreshold() > 0);
        // Disable slow log
        metric.recordEndTime();  
        long fetchTime = TimeUnit.MILLISECONDS.toNanos(600); // Above info threshold  
        slowLog.setTieredStorageSlowlogEnabled(true);
        assertNotNull(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_TRACE_SETTING);  
        assertTrue(slowLog.getQueryTraceThreshold() > 0);  
        // Test DEBUG level (100ms threshold)
    @Before
        slowLog.setTieredStorageSlowlogEnabled(false);
        slowLog.onQueryPhase(searchContext, infoTime);
import org.opensearch.core.tasks.TaskId;  
        );
        slowLog.onQueryPhase(searchContext, tookInNanos);
        );  
        assertTrue(slowLog.getQueryDebugThreshold() >= 0);
        // Mock search context setup
 *
        // Test printer when search request source is null  
            .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
        assertTrue(slowLog.getQueryInfoThreshold() > 0);
    public void testTieredStorageSlowLogPrinterToString() {
        String result = printer.toString();  
    }
    }
        metric.recordFileAccess("file1.block_0_1", true);
        // Test that settings set contains all expected settings
        slowLog.setTieredStorageSlowlogEnabled(true);
        slowLog.setTieredStorageSlowlogEnabled(true);
        // Enable slow log  
        // Test all threshold getters return expected values
import org.opensearch.index.IndexSettings;
        slowLog.onFetchPhase(searchContext, tookInNanos);
import static org.mockito.Mockito.when;
        settingSet.add(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_TRACE_SETTING);
    }  
    }
            TimeUnit.MILLISECONDS.toNanos(100),
        assertFalse(TieredStorageSearchSlowLog.TIERED_STORAGE_SEARCH_SLOWLOG_SETTINGS.isEmpty());  
        metric.recordPrefetch("file2", 1);
        SearchShardTarget shardTarget = new SearchShardTarget("testNode", mock(ShardId.class), null, null);
        slowLog.setTieredStorageSlowlogEnabled(false);  
    }
 * this file be licensed under the Apache-2.0 license or a
        long traceTime = TimeUnit.MILLISECONDS.toNanos(15);
            )  
        assertTrue(result.contains("task-1"));
        // Should handle null task gracefully
        long tookInNanos = TimeUnit.MILLISECONDS.toNanos(50);
        slowLog.onPreSliceExecution(searchContext);
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        slowLog.onSliceExecution(searchContext);
    public void testConstructorInitializesSettings() {
    public void testSetTieredStorageSlowlogEnabled() {
            )
    }  
        );
        // Should contain metric data in warm_stats
        settingSet.add(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_WARN_SETTING);  
 * compatible open source license.
        slowLog.onFailedFetchPhase(searchContext);
        assertTrue(result.contains("warm_stats"));  
    }
        assertNotNull(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_INFO_SETTING);
        assertTrue(slowLog.getQueryDebugThreshold() > 0);
    public void testTieredStorageSlowLogPrinterWithMetrics() {
        // Should complete without exceptions
    public void testSlowLogSettingsMap() {
        settingSet.add(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_INFO_SETTING);  
        assertTrue(result.contains("search_type"));  
        // Should call setMetricCollector when enabled
        // Enable slow log
        assertTrue(slowLog.getFetchInfoThreshold() >= 0);
        // Disable slow log
    public void testOnSliceExecutionWhenDisabled() {
        assertNotNull(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_INFO_SETTING);
        assertTrue(TieredStorageSearchSlowLog.TIERED_STORAGE_SEARCH_SLOWLOG_ENABLED.getKey().startsWith(expectedPrefix));
    public void testOnFetchPhaseWhenEnabled() {  
        slowLog.onFetchPhase(searchContext, tookInNanos);
import org.opensearch.Version;
        // Create mock objects  
        assertTrue(result.contains("total_shards"));
        // Test fetch phase with different thresholds
        java.util.List<TieredStoragePerQueryMetric> metrics = java.util.Arrays.asList(metric);
    public void testTimeValueConversion() {
        // Disable slow log
        slowLog.setTieredStorageSlowlogEnabled(true);  
    }
    private IndexSettings indexSettings;  
        assertTrue(result.length() > 0);
    }
        slowLog.onQueryPhase(searchContext, debugTime);  
        TieredStorageSearchSlowLog.TieredStorageSlowLogPrinter printer = new TieredStorageSearchSlowLog.TieredStorageSlowLogPrinter(
        String result = printer.toString();
        // Just verify it doesn't throw exception  
        assertTrue(result.contains("took_millis"));
        assertNotNull(result);
import org.opensearch.cluster.metadata.IndexMetadata;  
 * Comprehensive unit tests for TieredStorageSearchSlowLog
        // onPreQueryPhase should not do anything as per the implementation
        slowLog.onPreSliceExecution(searchContext);  
        long tookInNanos = TimeUnit.MILLISECONDS.toNanos(50); // Above 10ms trace threshold  
    public void testTieredStorageSlowLogPrinterConstructor() {
            java.util.Collections.emptyList()  
    }
        assertTrue(slowLog.getFetchDebugThreshold() >= 0);  
        // Mock group stats - use List<String> to match expected type  
        assertTrue(slowLog.getFetchWarnThreshold() >= 0);
        assertTrue(slowLog.getQueryInfoThreshold() >= slowLog.getQueryDebugThreshold());
        assertNotNull(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_LEVEL);
        slowLog.onPreFetchPhase(searchContext);
        slowLog.setTieredStorageSlowlogEnabled(false);
import java.util.concurrent.TimeUnit;
        when(searchContext.getTask()).thenReturn(searchTask);  
        // Test TRACE level (10ms threshold)  
        assertNotNull(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_WARN_SETTING);  
        slowLog.onFailedFetchPhase(searchContext);
        metricService = mock(TieredStorageQueryMetricService.class);  
    }
        assertTrue(result.contains("\"source\":null"));
    }
import org.opensearch.search.SearchShardTarget;
        assertFalse(TieredStorageSearchSlowLog.TIERED_STORAGE_SEARCH_SLOWLOG_SETTINGS_MAP.isEmpty());
        TieredStorageSearchSlowLog.TieredStorageSlowLogPrinter printer = new TieredStorageSearchSlowLog.TieredStorageSlowLogPrinter(
                TieredStorageSearchSlowLog.TIERED_STORAGE_SEARCH_SLOWLOG_PREFIX + ".threshold.query.warn"  
            TieredStorageSearchSlowLog.TIERED_STORAGE_SEARCH_SLOWLOG_SETTINGS_MAP.containsKey(
            TimeUnit.MILLISECONDS.toNanos(100),  
        // Create slow log instance
        settingSet.add(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_LEVEL);  
        // Verify no exception is thrown  
    public void testOnPreFetchPhaseWhenDisabled() {  
        slowLog.onPreQueryPhase(searchContext);
            .build();
        // Test that time values are properly converted to nanoseconds
            TimeUnit.MILLISECONDS.toNanos(100),
        // Verify no exception is thrown  
import org.opensearch.common.logging.SlowLogLevel;
    }
        // Disable slow log
    private TieredStorageSearchSlowLog slowLog;
        settingSet.add(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_DEBUG_SETTING);
        slowLog.onPreFetchPhase(searchContext);
        // Verify no exception is thrown
        slowLog.setTieredStorageSlowlogEnabled(true);
    }
        // No direct way to verify, but should not throw exception
        assertTrue(result.contains("took"));  
        slowLog.setTieredStorageSlowlogEnabled(false);
import static org.mockito.Mockito.mock;  
        // Verify no exception is thrown
    }
        String result = printer.toString();
        assertTrue(slowLog.getFetchTraceThreshold() >= 0);
        );
        settingSet.add(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_DEBUG_SETTING);
        assertTrue(
        // Verify no exception is thrown  
        indexSettings = createMockIndexSettings();
        slowLog.setTieredStorageSlowlogEnabled(true);  
        // Enable slow log
        slowLog.onPreFetchPhase(searchContext);
        assertTrue(  
import org.opensearch.search.internal.SearchContext;  
        slowLog.onQueryPhase(searchContext, tookInNanos);
            .put(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_INFO_SETTING.getKey(), "500ms")
    }
        // Disable slow log  
            .put(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_LEVEL.getKey(), "TRACE")
        // Verify no exception is thrown  
        long warnTime = TimeUnit.MILLISECONDS.toNanos(1100);
    }
        // Verify no exception is thrown  
        slowLog.setTieredStorageSlowlogEnabled(false);  
        // Test INFO level (500ms threshold)
        assertTrue(slowLog.getFetchTraceThreshold() > 0);
        slowLog = new TieredStorageSearchSlowLog(indexSettings);  
            TimeUnit.MILLISECONDS.toNanos(100),
        TieredStorageSearchSlowLog.TieredStorageSlowLogPrinter printer = new TieredStorageSearchSlowLog.TieredStorageSlowLogPrinter(  
            .put(TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_TRACE_SETTING.getKey(), "10ms")
