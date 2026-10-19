        assertEquals("datafusion.indexed.force_strategy", DatafusionSettings.INDEXED_FORCE_STRATEGY.getKey());
        assertEquals(0.03, DatafusionSettings.INDEXED_MIN_SKIP_RUN_SELECTIVITY_THRESHOLD.get(Settings.EMPTY), 1e-15);
            DatafusionSettings.INDEXED_MIN_SKIP_RUN_SELECTIVITY_THRESHOLD.getKey()
        assertEquals(DEFAULT_PARALLELISM, ds.getSnapshot().targetPartitions());
        Settings settings = Settings.builder()  
        );  
        assertEquals(  
        DatafusionSettings ds = new DatafusionSettings(settings);  
    }
        assertEquals("datafusion.batch_size", DatafusionSettings.BATCH_SIZE.getKey());
            .put(SearchService.CONCURRENT_SEGMENT_SEARCH_TARGET_MAX_SLICE_COUNT_SETTING.getKey(), processors + 10)  
 * compatible open source license.
        expectThrows(IllegalArgumentException.class, () -> DatafusionSettings.INDEXED_MIN_SKIP_RUN_SELECTIVITY_THRESHOLD.get(settings));
    }  
        assertTrue(DatafusionSettings.DOCVALUES_INITIAL_BATCH_SIZE.hasIndexScope());  
    public void testTargetPartitionsFallbackWhenZero() {
            .build();
    public void testNodeScopedSettingsHoldOnlyNodeScope() {
        assertTrue(DatafusionSettings.NODE_SCOPED_SETTINGS.contains(DataFusionPlugin.DATAFUSION_MEMORY_GUARD_SPILL_EXEMPT_CAP));  
                Settings.builder().put("datafusion.indexed.force_strategy", "bogus").build()
    private static final int DEFAULT_PARALLELISM = Math.max(1, Math.min(Runtime.getRuntime().availableProcessors() / 2, 4));
        assertEquals(2, DatafusionSettings.INDEX_SCOPED_SETTINGS.size());  
    }  
}
        assertTrue(DatafusionSettings.LISTING_TABLE_PUSHDOWN_FILTERS.hasNodeScope());  
        );  
            IllegalArgumentException.class,
        assertEquals(64, DatafusionSettings.docValuesInitialBatchSize(settings));
 */  
    public void testBatchSizeSettingDefinition() {
import org.opensearch.common.settings.Setting;
        assertEquals(DEFAULT_PARALLELISM, snapshot.targetPartitions());
        // Invalid values are rejected at parse time.  
        DatafusionSettings ds = new DatafusionSettings(settings);
        assertTrue(DatafusionSettings.INDEX_SCOPED_SETTINGS.contains(DatafusionSettings.DOCVALUES_INITIAL_BATCH_SIZE));
     */
        assertEquals(1, DatafusionSettings.forceStrategyToWire("boolean_mask"));  
    public void testMinSkipRunDefaultSettingDefinition() {
        assertTrue(DatafusionSettings.DOCVALUES_INITIAL_BATCH_SIZE.isDynamic());
    }  
        assertEquals(DatafusionSettings.DEFAULT_DOCVALUES_INITIAL_BATCH_SIZE, DatafusionSettings.docValuesInitialBatchSize(Settings.EMPTY));  
        assertEquals(0, DatafusionSettings.forceStrategyToWire("row_selection"));
        Settings settings = Settings.builder()  
    }
        Settings settings = Settings.builder()
        assertEquals("datafusion.indexed.min_skip_run_default", DatafusionSettings.INDEXED_MIN_SKIP_RUN_DEFAULT.getKey());
        assertTrue(DatafusionSettings.INDEXED_FORCE_STRATEGY.isDynamic());
    }
        assertTrue(DatafusionSettings.BATCH_SIZE.hasNodeScope());
    }  
        assertTrue(DatafusionSettings.NODE_SCOPED_SETTINGS.contains(DatafusionSettings.INDEXED_MIN_SKIP_RUN_SELECTIVITY_THRESHOLD));  
    }
    public void testIndexScopedSettingsHoldsTheDocValuesBatchSizes() {
        DatafusionSettings ds = new DatafusionSettings(Settings.EMPTY);
    }  
    public void testTargetPartitionsCappedAtAvailableProcessors() {  
        DatafusionSettings ds = new DatafusionSettings(Settings.EMPTY);  
        assertTrue(DatafusionSettings.NODE_SCOPED_SETTINGS.contains(DataFusionPlugin.DATAFUSION_SPILL_DIRECTORY));
        assertEquals(Boolean.TRUE, DatafusionSettings.INDEXED_PUSHDOWN_FILTERS.get(Settings.EMPTY));
        expectThrows(
        assertTrue(DatafusionSettings.NODE_SCOPED_SETTINGS.contains(DataFusionPlugin.DATAFUSION_REDUCE_TARGET_PARTITIONS));
        assertEquals(1, ds.getSnapshot().forceStrategy());
            .put(DatafusionSettings.DOCVALUES_INITIAL_BATCH_SIZE.getKey(), 4096)
    }
        assertEquals(31, DatafusionSettings.NODE_SCOPED_SETTINGS.size());
        assertEquals(Math.min(8, Runtime.getRuntime().availableProcessors()), ds.getSnapshot().targetPartitions());
        assertEquals(Integer.valueOf(8192), DatafusionSettings.BATCH_SIZE.get(Settings.EMPTY));  
        assertTrue(DatafusionSettings.NODE_SCOPED_SETTINGS.contains(DatafusionSettings.LISTING_TABLE_PUSHDOWN_FILTERS));  
        assertTrue(DatafusionSettings.NODE_SCOPED_SETTINGS.contains(DatafusionSettings.INDEXED_PUSHDOWN_FILTERS));
            assertTrue("NODE_SCOPED_SETTINGS must be NodeScope only, found: " + setting.getKey(), setting.hasNodeScope());
        assertEquals(-1, DatafusionSettings.forceStrategyToWire("none"));
    public void testListingTablePushdownFiltersSettingDefinition() {
            .build();  
    public void testDocValuesBatchSizeSettingsAreIndexScopedAndDynamic() {
import org.opensearch.test.OpenSearchTestCase;
    public void testMinSkipRunSelectivityThresholdSettingDefinition() {
        assertEquals(1024, snapshot.minSkipRunDefault());  
        assertTrue(DatafusionSettings.NODE_SCOPED_SETTINGS.contains(DatafusionSettings.BATCH_SIZE));
        // is resolved down rather than rejected.
        assertEquals(false, snapshot.listingTablePushdownFilters());
        assertEquals(DatafusionSettings.DEFAULT_DOCVALUES_MAX_BATCH_SIZE, DatafusionSettings.docValuesMaxBatchSize(Settings.EMPTY));
     * {@code NODE_SCOPED_SETTINGS} is handed to a {@code ClusterSettings}, which rejects anything that is
        assertTrue(DatafusionSettings.INDEXED_FORCE_STRATEGY.hasNodeScope());
    public void testDefaultSnapshotValuesMatchDefaults() {  
    }  
    public void testForceStrategySettingDefaultsAndMapping() {
        assertEquals(Boolean.FALSE, DatafusionSettings.LISTING_TABLE_PUSHDOWN_FILTERS.get(Settings.EMPTY));
    /**
        for (Setting<?> setting : DatafusionSettings.NODE_SCOPED_SETTINGS) {  
        assertEquals("datafusion.listing_table.pushdown_filters", DatafusionSettings.LISTING_TABLE_PUSHDOWN_FILTERS.getKey());  
        assertTrue(DatafusionSettings.INDEX_SCOPED_SETTINGS.contains(DatafusionSettings.DOCVALUES_MAX_BATCH_SIZE));
        assertTrue(DatafusionSettings.DOCVALUES_MAX_BATCH_SIZE.isDynamic());  
    }
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(DatafusionSettings.DOCVALUES_MAX_BATCH_SIZE.hasIndexScope());
            () -> DatafusionSettings.INDEXED_FORCE_STRATEGY.get(  
        assertEquals("datafusion.indexed.pushdown_filters", DatafusionSettings.INDEXED_PUSHDOWN_FILTERS.getKey());
    public void testIndexedPushdownFiltersSettingDefinition() {  
            .build();  
        assertTrue(DatafusionSettings.INDEXED_MIN_SKIP_RUN_DEFAULT.isDynamic());
            )
     * not {@code NodeScope}, so index-scoped settings must stay in {@code INDEX_SCOPED_SETTINGS}.  
 *
            .put(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), "none")
        assertEquals(processors, ds.getSnapshot().targetPartitions());
    public void testSelectivityThresholdAboveBoundIsRejected() {  
    }  
        DatafusionSettings ds = new DatafusionSettings(Settings.builder().put("datafusion.indexed.force_strategy", "boolean_mask").build());  
        WireConfigSnapshot snapshot = ds.getSnapshot();
        Settings settings = Settings.builder().put("datafusion.batch_size", 0).build();
            .put(DatafusionSettings.DOCVALUES_MAX_BATCH_SIZE.getKey(), 64)
        assertTrue(DatafusionSettings.INDEXED_MIN_SKIP_RUN_DEFAULT.hasNodeScope());
        Settings settings = Settings.builder()  
        assertTrue(DatafusionSettings.INDEXED_MIN_SKIP_RUN_SELECTIVITY_THRESHOLD.isDynamic());
    }  
        assertEquals(8192, snapshot.batchSize());
        assertEquals(64, DatafusionSettings.docValuesMaxBatchSize(settings));
        assertEquals(Integer.valueOf(1024), DatafusionSettings.INDEXED_MIN_SKIP_RUN_DEFAULT.get(Settings.EMPTY));  
        assertTrue(DatafusionSettings.LISTING_TABLE_PUSHDOWN_FILTERS.isDynamic());
    }  
    public void testTargetPartitionsPassthroughWhenNonZero() {
        assertTrue(DatafusionSettings.NODE_SCOPED_SETTINGS.contains(DatafusionSettings.INDEXED_MIN_SKIP_RUN_DEFAULT));
    public void testNodeScopedSettingsContainsAllExpectedSettings() {  
        assertEquals(-1, new DatafusionSettings(Settings.EMPTY).getSnapshot().forceStrategy());  
public class DatafusionSettingsTests extends OpenSearchTestCase {  
        // A configured value flows into the snapshot.
        assertTrue(DatafusionSettings.INDEXED_PUSHDOWN_FILTERS.isDynamic());  
    public void testDocValuesBatchSizeDefaults() {
    public void testDocValuesInitialBatchSizeIsResolvedDownToTheCeiling() {  
    }
        DatafusionSettings ds = new DatafusionSettings(settings);
 * SPDX-License-Identifier: Apache-2.0
            .build();
        assertTrue(DatafusionSettings.NODE_SCOPED_SETTINGS.contains(DatafusionSettings.INDEXED_FORCE_STRATEGY));
import org.opensearch.common.settings.Settings;
import org.opensearch.search.SearchService;  
/*  
        Settings settings = Settings.builder().put("datafusion.indexed.min_skip_run_selectivity_threshold", 1.1).build();
        expectThrows(IllegalArgumentException.class, () -> DatafusionSettings.BATCH_SIZE.get(settings));  
        int processors = Runtime.getRuntime().availableProcessors();
            "datafusion.indexed.min_skip_run_selectivity_threshold",
        assertEquals("none", DatafusionSettings.INDEXED_FORCE_STRATEGY.get(Settings.EMPTY));  
        // Default snapshot encodes None (-1).
    }
            .put(SearchService.CONCURRENT_SEGMENT_SEARCH_TARGET_MAX_SLICE_COUNT_SETTING.getKey(), 8)
    public void testBatchSizeZeroIsRejected() {
 * The OpenSearch Contributors require contributions made to  
        assertEquals(1, ds.getSnapshot().targetPartitions());  
package org.opensearch.be.datafusion;
    public void testTargetPartitionsForcedToOneWhenModeNone() {
    }
    }
        assertEquals(0.03, snapshot.minSkipRunSelectivityThreshold(), 1e-15);
        // The two settings are independent, so a configuration that asks to start above the ceiling
            .put(SearchService.CONCURRENT_SEGMENT_SEARCH_TARGET_MAX_SLICE_COUNT_SETTING.getKey(), 16)
        assertTrue(DatafusionSettings.BATCH_SIZE.isDynamic());
        assertTrue(DatafusionSettings.INDEXED_MIN_SKIP_RUN_SELECTIVITY_THRESHOLD.hasNodeScope());  
        }
        assertTrue(DatafusionSettings.INDEXED_PUSHDOWN_FILTERS.hasNodeScope());
