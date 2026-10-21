    }
        assertEquals(Integer.valueOf(1024), DatafusionSettings.INDEXED_MIN_SKIP_RUN_DEFAULT.get(Settings.EMPTY));
        assertEquals(Boolean.FALSE, DatafusionSettings.LISTING_TABLE_PUSHDOWN_FILTERS.get(Settings.EMPTY));
        expectThrows(IllegalArgumentException.class, () -> DatafusionSettings.INDEXED_MIN_SKIP_RUN_SELECTIVITY_THRESHOLD.get(settings));
        Settings settings = Settings.builder()
        // Invalid values are rejected at parse time.
        for (Setting<?> setting : DatafusionSettings.NODE_SCOPED_SETTINGS) {
import org.opensearch.common.settings.Setting;
 *
}
import org.opensearch.search.SearchService;
     * {@code NODE_SCOPED_SETTINGS} is handed to a {@code ClusterSettings}, which rejects anything that is
        assertTrue(DatafusionSettings.LISTING_TABLE_PUSHDOWN_FILTERS.isDynamic());
            DatafusionSettings.INDEXED_MIN_SKIP_RUN_SELECTIVITY_THRESHOLD.getKey()
        assertEquals(processors, ds.getSnapshot().targetPartitions());
        assertTrue(DatafusionSettings.NODE_SCOPED_SETTINGS.contains(DatafusionSettings.INDEXED_MIN_SKIP_RUN_SELECTIVITY_THRESHOLD));
import org.opensearch.common.settings.Settings;
        assertEquals(8192, snapshot.batchSize());
    public void testIndexedPushdownFiltersSettingDefinition() {
            .put(SearchService.CONCURRENT_SEGMENT_SEARCH_TARGET_MAX_SLICE_COUNT_SETTING.getKey(), processors + 10)
        assertEquals("datafusion.indexed.pushdown_filters", DatafusionSettings.INDEXED_PUSHDOWN_FILTERS.getKey());
    public void testMinSkipRunSelectivityThresholdSettingDefinition() {
    public void testNodeScopedSettingsContainsAllExpectedSettings() {
            .put(DatafusionSettings.DOCVALUES_INITIAL_BATCH_SIZE.getKey(), 4096)
            "datafusion.indexed.min_skip_run_selectivity_threshold",
        assertTrue(DatafusionSettings.NODE_SCOPED_SETTINGS.contains(DatafusionSettings.INDEXED_PUSHDOWN_FILTERS));
        assertTrue(DatafusionSettings.INDEX_SCOPED_SETTINGS.contains(DatafusionSettings.DOCVALUES_INITIAL_BATCH_SIZE));
        assertEquals(31, DatafusionSettings.NODE_SCOPED_SETTINGS.size());
     * not {@code NodeScope}, so index-scoped settings must stay in {@code INDEX_SCOPED_SETTINGS}.
        assertEquals(Integer.valueOf(8192), DatafusionSettings.BATCH_SIZE.get(Settings.EMPTY));
    }
    }
        );
        assertEquals(-1, DatafusionSettings.forceStrategyToWire("none"));
    }
        assertTrue(DatafusionSettings.LISTING_TABLE_PUSHDOWN_FILTERS.hasNodeScope());
        assertEquals(64, DatafusionSettings.docValuesMaxBatchSize(settings));
        assertEquals(-1, new DatafusionSettings(Settings.EMPTY).getSnapshot().forceStrategy());
    public void testSelectivityThresholdAboveBoundIsRejected() {
            () -> DatafusionSettings.INDEXED_FORCE_STRATEGY.get(
            )
        assertEquals(0.03, DatafusionSettings.INDEXED_MIN_SKIP_RUN_SELECTIVITY_THRESHOLD.get(Settings.EMPTY), 1e-15);
        WireConfigSnapshot snapshot = ds.getSnapshot();
        assertEquals(Boolean.TRUE, DatafusionSettings.INDEXED_PUSHDOWN_FILTERS.get(Settings.EMPTY));
    }
    public void testDefaultSnapshotValuesMatchDefaults() {
        assertTrue(DatafusionSettings.BATCH_SIZE.hasNodeScope());
        assertEquals("datafusion.indexed.force_strategy", DatafusionSettings.INDEXED_FORCE_STRATEGY.getKey());
    public void testDocValuesInitialBatchSizeIsResolvedDownToTheCeiling() {
        );
        assertTrue(DatafusionSettings.INDEXED_MIN_SKIP_RUN_SELECTIVITY_THRESHOLD.isDynamic());
        // is resolved down rather than rejected.
        assertTrue(DatafusionSettings.INDEXED_PUSHDOWN_FILTERS.isDynamic());
        DatafusionSettings ds = new DatafusionSettings(settings);
        assertEquals(DatafusionSettings.DEFAULT_DOCVALUES_INITIAL_BATCH_SIZE, DatafusionSettings.docValuesInitialBatchSize(Settings.EMPTY));
        assertEquals("datafusion.listing_table.pushdown_filters", DatafusionSettings.LISTING_TABLE_PUSHDOWN_FILTERS.getKey());
        assertTrue(DatafusionSettings.NODE_SCOPED_SETTINGS.contains(DatafusionSettings.INDEXED_MIN_SKIP_RUN_DEFAULT));
public class DatafusionSettingsTests extends OpenSearchTestCase {
    }
        assertEquals(Math.min(8, Runtime.getRuntime().availableProcessors()), ds.getSnapshot().targetPartitions());
        // A configured value flows into the snapshot.
    }
        DatafusionSettings ds = new DatafusionSettings(Settings.builder().put("datafusion.indexed.force_strategy", "boolean_mask").build());
            .build();
        int processors = Runtime.getRuntime().availableProcessors();
                Settings.builder().put("datafusion.indexed.force_strategy", "bogus").build()
 * compatible open source license.
        assertEquals("datafusion.batch_size", DatafusionSettings.BATCH_SIZE.getKey());
    public void testTargetPartitionsCappedAtAvailableProcessors() {
        assertEquals(64, DatafusionSettings.docValuesInitialBatchSize(settings));
    }
    public void testForceStrategySettingDefaultsAndMapping() {
        assertTrue(DatafusionSettings.NODE_SCOPED_SETTINGS.contains(DatafusionSettings.LISTING_TABLE_PUSHDOWN_FILTERS));
            assertTrue("NODE_SCOPED_SETTINGS must be NodeScope only, found: " + setting.getKey(), setting.hasNodeScope());
        assertTrue(DatafusionSettings.INDEX_SCOPED_SETTINGS.contains(DatafusionSettings.DOCVALUES_MAX_BATCH_SIZE));
        assertTrue(DatafusionSettings.DOCVALUES_MAX_BATCH_SIZE.hasIndexScope());
    }
        assertTrue(DatafusionSettings.NODE_SCOPED_SETTINGS.contains(DataFusionPlugin.DATAFUSION_SPILL_DIRECTORY));
        assertEquals(0, DatafusionSettings.forceStrategyToWire("row_selection"));
    }
        assertTrue(DatafusionSettings.INDEXED_MIN_SKIP_RUN_DEFAULT.hasNodeScope());
        assertEquals(DEFAULT_PARALLELISM, ds.getSnapshot().targetPartitions());
    }
    }
        assertEquals(1024, snapshot.minSkipRunDefault());
    public void testListingTablePushdownFiltersSettingDefinition() {
            IllegalArgumentException.class,
        assertEquals("datafusion.indexed.min_skip_run_default", DatafusionSettings.INDEXED_MIN_SKIP_RUN_DEFAULT.getKey());
        assertTrue(DatafusionSettings.DOCVALUES_INITIAL_BATCH_SIZE.isDynamic());
    public void testTargetPartitionsForcedToOneWhenModeNone() {
    }
 * The OpenSearch Contributors require contributions made to
    public void testDocValuesBatchSizeDefaults() {
    public void testDocValuesBatchSizeSettingsAreIndexScopedAndDynamic() {
        assertEquals(DatafusionSettings.DEFAULT_DOCVALUES_MAX_BATCH_SIZE, DatafusionSettings.docValuesMaxBatchSize(Settings.EMPTY));
        assertTrue(DatafusionSettings.NODE_SCOPED_SETTINGS.contains(DatafusionSettings.BATCH_SIZE));
    }
        assertTrue(DatafusionSettings.BATCH_SIZE.isDynamic());
    public void testIndexScopedSettingsHoldsTheDocValuesBatchSizes() {
 */
        assertTrue(DatafusionSettings.NODE_SCOPED_SETTINGS.contains(DataFusionPlugin.DATAFUSION_REDUCE_TARGET_PARTITIONS));
        assertEquals(
        expectThrows(
            .build();
        assertEquals(1, ds.getSnapshot().forceStrategy());
        assertTrue(DatafusionSettings.DOCVALUES_MAX_BATCH_SIZE.isDynamic());
        // Default snapshot encodes None (-1).
            .build();
        Settings settings = Settings.builder()
    }
    }
        assertTrue(DatafusionSettings.INDEXED_MIN_SKIP_RUN_SELECTIVITY_THRESHOLD.hasNodeScope());
        assertTrue(DatafusionSettings.NODE_SCOPED_SETTINGS.contains(DatafusionSettings.INDEXED_FORCE_STRATEGY));
        assertTrue(DatafusionSettings.INDEXED_PUSHDOWN_FILTERS.hasNodeScope());
        DatafusionSettings ds = new DatafusionSettings(Settings.EMPTY);
        assertEquals(2, DatafusionSettings.INDEX_SCOPED_SETTINGS.size());
        assertEquals(0.03, snapshot.minSkipRunSelectivityThreshold(), 1e-15);
    public void testBatchSizeZeroIsRejected() {
            .put(DatafusionSettings.DOCVALUES_MAX_BATCH_SIZE.getKey(), 64)
/*
    }
        Settings settings = Settings.builder().put("datafusion.indexed.min_skip_run_selectivity_threshold", 1.1).build();
        Settings settings = Settings.builder()
        }
            .put(SearchService.CONCURRENT_SEGMENT_SEARCH_TARGET_MAX_SLICE_COUNT_SETTING.getKey(), 16)
            .put(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), "none")
        DatafusionSettings ds = new DatafusionSettings(Settings.EMPTY);
        assertEquals(DEFAULT_PARALLELISM, snapshot.targetPartitions());
        assertTrue(DatafusionSettings.NODE_SCOPED_SETTINGS.contains(DataFusionPlugin.DATAFUSION_MEMORY_GUARD_SPILL_EXEMPT_CAP));
    public void testTargetPartitionsPassthroughWhenNonZero() {
    public void testBatchSizeSettingDefinition() {
            .build();
        assertTrue(DatafusionSettings.INDEXED_MIN_SKIP_RUN_DEFAULT.isDynamic());
        // The two settings are independent, so a configuration that asks to start above the ceiling
    public void testTargetPartitionsFallbackWhenZero() {
    public void testMinSkipRunDefaultSettingDefinition() {
        assertEquals("none", DatafusionSettings.INDEXED_FORCE_STRATEGY.get(Settings.EMPTY));
        expectThrows(IllegalArgumentException.class, () -> DatafusionSettings.BATCH_SIZE.get(settings));
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(false, snapshot.listingTablePushdownFilters());
package org.opensearch.be.datafusion;
import org.opensearch.test.OpenSearchTestCase;
    private static final int DEFAULT_PARALLELISM = Math.max(1, Math.min(Runtime.getRuntime().availableProcessors() / 2, 4));
        DatafusionSettings ds = new DatafusionSettings(settings);
     */
    /**
        assertTrue(DatafusionSettings.DOCVALUES_INITIAL_BATCH_SIZE.hasIndexScope());
        Settings settings = Settings.builder().put("datafusion.batch_size", 0).build();
    }
 * this file be licensed under the Apache-2.0 license or a
        DatafusionSettings ds = new DatafusionSettings(settings);
        Settings settings = Settings.builder()
    }
        assertTrue(DatafusionSettings.INDEXED_FORCE_STRATEGY.hasNodeScope());
        assertEquals(1, DatafusionSettings.forceStrategyToWire("boolean_mask"));
        assertEquals(1, ds.getSnapshot().targetPartitions());
            .put(SearchService.CONCURRENT_SEGMENT_SEARCH_TARGET_MAX_SLICE_COUNT_SETTING.getKey(), 8)
    public void testNodeScopedSettingsHoldOnlyNodeScope() {
        assertTrue(DatafusionSettings.INDEXED_FORCE_STRATEGY.isDynamic());
