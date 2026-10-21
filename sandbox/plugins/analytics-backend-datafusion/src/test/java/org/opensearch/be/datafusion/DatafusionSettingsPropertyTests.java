                    .build()
                case 4: // max_slice_count
 */
            );
            assertEquals(newBatchSize, finalSnapshot.batchSize());
 * this file be licensed under the Apache-2.0 license or a
                    WireConfigSnapshot afterSlice = datafusionSettings.getSnapshot();
 * SPDX-License-Identifier: Apache-2.0
                    assertEquals(before.minSkipRunSelectivityThreshold(), afterPushdown.minSkipRunSelectivityThreshold(), 0.0);
                    break;
import java.util.HashSet;
 * The OpenSearch Contributors require contributions made to
                    assertEquals(newPushdown, afterPushdown.listingTablePushdownFilters());
                    clusterSettings.applySettings(newSettings);
import org.opensearch.test.OpenSearchTestCase;
                    assertEquals(newMinSkipRun, afterSkipRun.minSkipRunDefault());
                    int newSliceCount = randomIntBetween(1, 32);
                    assertEquals(before.minSkipRunDefault(), afterThreshold.minSkipRunDefault());
                Settings.builder()
                    assertEquals(before.listingTablePushdownFilters(), afterThreshold.listingTablePushdownFilters());
                    assertEquals(before.minSkipRunSelectivityThreshold(), afterMode.minSkipRunSelectivityThreshold(), 0.0);
    }
public class DatafusionSettingsPropertyTests extends OpenSearchTestCase {
                    int newMinSkipRun = randomIntBetween(1, 100_000);
import org.opensearch.search.SearchService;
                    assertEquals(before.targetPartitions(), afterSkipRun.targetPartitions());
            switch (settingIndex) {
                    WireConfigSnapshot afterSkipRun = datafusionSettings.getSnapshot();
                case 2: // min_skip_run_default
    }
                    .put("datafusion.indexed.min_skip_run_selectivity_threshold", newThreshold)
                case 0: // batch_size
                case 5: // concurrent_search_mode
                    assertEquals(before.minSkipRunDefault(), afterMode.minSkipRunDefault());
                    assertEquals(before.minSkipRunSelectivityThreshold(), afterSkipRun.minSkipRunSelectivityThreshold(), 0.0);
                    assertEquals(before.minSkipRunSelectivityThreshold(), afterBatch.minSkipRunSelectivityThreshold(), 0.0);
                    assertEquals(before.listingTablePushdownFilters(), afterBatch.listingTablePushdownFilters());
                    assertEquals(before.batchSize(), afterPushdown.batchSize());
        }
                    assertEquals(before.minSkipRunDefault(), afterPushdown.minSkipRunDefault());
    private static final int ITERATIONS = 200;
    }
        Set<Setting<?>> settingsSet = new HashSet<>(DatafusionSettings.NODE_SCOPED_SETTINGS);
                    assertEquals(before.batchSize(), afterThreshold.batchSize());
                    assertEquals(Math.min(newSliceCount, Runtime.getRuntime().availableProcessors()), afterSlice.targetPartitions());
                    newSettings = Settings.builder().put("search.concurrent.max_slice_count", newSliceCount).build();
                    assertEquals(before.minSkipRunDefault(), afterBatch.minSkipRunDefault());
                    assertEquals(newBatchSize, afterBatch.batchSize());
                    assertEquals(before.listingTablePushdownFilters(), afterSkipRun.listingTablePushdownFilters());
            }
        return new ClusterSettings(Settings.EMPTY, settingsSet);
                case 1: // listing_table.pushdown_filters
    public void testSequentialUpdatesAccumulateCorrectly() {
                    clusterSettings.applySettings(newSettings);
            double newThreshold = randomDoubleBetween(0.0, 1.0, true);
                    assertEquals(newThreshold, afterThreshold.minSkipRunSelectivityThreshold(), 1e-15);
            WireConfigSnapshot finalSnapshot = datafusionSettings.getSnapshot();
                    assertEquals(before.targetPartitions(), afterPushdown.targetPartitions());
                case 3: // min_skip_run_selectivity_threshold
import org.opensearch.common.settings.Setting;
            clusterSettings.applySettings(
            Settings newSettings;
        }
                    newSettings = Settings.builder().put("datafusion.indexed.min_skip_run_default", newMinSkipRun).build();
            DatafusionSettings datafusionSettings = new DatafusionSettings(Settings.EMPTY);
                    break;
                    assertEquals(before.minSkipRunDefault(), afterSlice.minSkipRunDefault());
            datafusionSettings.registerListeners(clusterSettings);
            WireConfigSnapshot before = datafusionSettings.getSnapshot();
            int settingIndex = randomIntBetween(0, 5);
                    fail("Unexpected setting index: " + settingIndex);
                    assertEquals(before.listingTablePushdownFilters(), afterMode.listingTablePushdownFilters());
                    assertEquals(before.listingTablePushdownFilters(), afterSlice.listingTablePushdownFilters());
            assertEquals(1024, finalSnapshot.minSkipRunDefault());
                    break;
                    clusterSettings.applySettings(newSettings);
                    WireConfigSnapshot afterMode = datafusionSettings.getSnapshot();
import java.util.Set;
            DatafusionSettings datafusionSettings = new DatafusionSettings(Settings.EMPTY);
 * compatible open source license.
        for (int i = 0; i < ITERATIONS; i++) {
            ClusterSettings clusterSettings = createClusterSettings();
                    assertEquals(before.batchSize(), afterSlice.batchSize());
import org.opensearch.common.settings.ClusterSettings;
                    .put("datafusion.batch_size", newBatchSize)
                    WireConfigSnapshot afterThreshold = datafusionSettings.getSnapshot();
}
                    newSettings = Settings.builder().put("datafusion.indexed.min_skip_run_selectivity_threshold", newThreshold).build();
                    newSettings = Settings.builder().put("datafusion.batch_size", newBatchSize).build();
/*
                    assertEquals(before.batchSize(), afterSkipRun.batchSize());
                    int newBatchSize = randomIntBetween(1, 1_000_000);
                    break;
                    clusterSettings.applySettings(newSettings);
                    break;
                    WireConfigSnapshot afterBatch = datafusionSettings.getSnapshot();
                    double newThreshold = randomDoubleBetween(0.0, 1.0, true);
import org.opensearch.common.settings.Settings;
    public void testSnapshotUpdateConsistencyProperty() {
 *
            assertEquals(false, finalSnapshot.listingTablePushdownFilters());
                    clusterSettings.applySettings(newSettings);
                    newSettings = Settings.builder().put("search.concurrent_segment_search.mode", "none").build();
                    assertEquals(1, afterMode.targetPartitions());
            datafusionSettings.registerListeners(clusterSettings);
                    clusterSettings.applySettings(newSettings);
                    boolean newPushdown = before.listingTablePushdownFilters() == false;
                    assertEquals(before.targetPartitions(), afterThreshold.targetPartitions());
        settingsSet.add(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE);
                    assertEquals(before.batchSize(), afterMode.batchSize());
            ClusterSettings clusterSettings = createClusterSettings();
                    WireConfigSnapshot afterPushdown = datafusionSettings.getSnapshot();
                    break;
package org.opensearch.be.datafusion;
                default:
                    assertEquals(before.minSkipRunSelectivityThreshold(), afterSlice.minSkipRunSelectivityThreshold(), 0.0);
        for (int i = 0; i < ITERATIONS; i++) {
            assertEquals(newThreshold, finalSnapshot.minSkipRunSelectivityThreshold(), 1e-15);
            int newBatchSize = randomIntBetween(1, 1_000_000);
                    newSettings = Settings.builder().put("datafusion.listing_table.pushdown_filters", newPushdown).build();
                    assertEquals(before.targetPartitions(), afterBatch.targetPartitions());
    private ClusterSettings createClusterSettings() {
        settingsSet.add(SearchService.CONCURRENT_SEGMENT_SEARCH_TARGET_MAX_SLICE_COUNT_SETTING);
