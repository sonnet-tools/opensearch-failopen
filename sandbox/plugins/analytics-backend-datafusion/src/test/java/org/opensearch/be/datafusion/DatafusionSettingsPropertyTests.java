            datafusionSettings.registerListeners(clusterSettings);
    private ClusterSettings createClusterSettings() {
 * this file be licensed under the Apache-2.0 license or a
                    assertEquals(newBatchSize, afterBatch.batchSize());
            DatafusionSettings datafusionSettings = new DatafusionSettings(Settings.EMPTY);
 */  
                    int newSliceCount = randomIntBetween(1, 32);
                default:
import org.opensearch.common.settings.ClusterSettings;
                    assertEquals(before.listingTablePushdownFilters(), afterSkipRun.listingTablePushdownFilters());
                    assertEquals(Math.min(newSliceCount, Runtime.getRuntime().availableProcessors()), afterSlice.targetPartitions());
import org.opensearch.common.settings.Settings;  
                Settings.builder()  
                    WireConfigSnapshot afterSlice = datafusionSettings.getSnapshot();
                    newSettings = Settings.builder().put("search.concurrent.max_slice_count", newSliceCount).build();
            switch (settingIndex) {
                case 5: // concurrent_search_mode  
                    WireConfigSnapshot afterMode = datafusionSettings.getSnapshot();  
                    .put("datafusion.batch_size", newBatchSize)
                    fail("Unexpected setting index: " + settingIndex);  
            double newThreshold = randomDoubleBetween(0.0, 1.0, true);  
                    newSettings = Settings.builder().put("datafusion.listing_table.pushdown_filters", newPushdown).build();
                    assertEquals(before.minSkipRunSelectivityThreshold(), afterSkipRun.minSkipRunSelectivityThreshold(), 0.0);  
                    WireConfigSnapshot afterThreshold = datafusionSettings.getSnapshot();
                    clusterSettings.applySettings(newSettings);  
                    assertEquals(before.listingTablePushdownFilters(), afterThreshold.listingTablePushdownFilters());
                    assertEquals(before.minSkipRunDefault(), afterThreshold.minSkipRunDefault());  
                    assertEquals(before.listingTablePushdownFilters(), afterSlice.listingTablePushdownFilters());
        Set<Setting<?>> settingsSet = new HashSet<>(DatafusionSettings.NODE_SCOPED_SETTINGS);  
        for (int i = 0; i < ITERATIONS; i++) {
                    assertEquals(before.targetPartitions(), afterSkipRun.targetPartitions());
                case 1: // listing_table.pushdown_filters  
                    assertEquals(before.listingTablePushdownFilters(), afterBatch.listingTablePushdownFilters());
    }
            ClusterSettings clusterSettings = createClusterSettings();
                case 0: // batch_size  
                    int newBatchSize = randomIntBetween(1, 1_000_000);
import org.opensearch.test.OpenSearchTestCase;
            );
            }
                    boolean newPushdown = before.listingTablePushdownFilters() == false;
public class DatafusionSettingsPropertyTests extends OpenSearchTestCase {
                    newSettings = Settings.builder().put("datafusion.indexed.min_skip_run_default", newMinSkipRun).build();
}
            assertEquals(newThreshold, finalSnapshot.minSkipRunSelectivityThreshold(), 1e-15);  
                    assertEquals(before.targetPartitions(), afterBatch.targetPartitions());  
    }
    }  
                    break;
        settingsSet.add(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE);
                    WireConfigSnapshot afterPushdown = datafusionSettings.getSnapshot();
import java.util.Set;
            assertEquals(false, finalSnapshot.listingTablePushdownFilters());
                    assertEquals(before.minSkipRunDefault(), afterMode.minSkipRunDefault());
                    assertEquals(newMinSkipRun, afterSkipRun.minSkipRunDefault());
                    assertEquals(before.batchSize(), afterMode.batchSize());
                    assertEquals(before.minSkipRunDefault(), afterPushdown.minSkipRunDefault());
                    assertEquals(before.batchSize(), afterSkipRun.batchSize());  
                    break;
 * compatible open source license.
                    assertEquals(before.batchSize(), afterPushdown.batchSize());  
            datafusionSettings.registerListeners(clusterSettings);  
                    assertEquals(before.minSkipRunDefault(), afterBatch.minSkipRunDefault());
                    clusterSettings.applySettings(newSettings);  
                case 2: // min_skip_run_default  
            Settings newSettings;  
 * SPDX-License-Identifier: Apache-2.0
                    assertEquals(1, afterMode.targetPartitions());
                    assertEquals(before.minSkipRunSelectivityThreshold(), afterPushdown.minSkipRunSelectivityThreshold(), 0.0);  
                    assertEquals(before.batchSize(), afterThreshold.batchSize());  
                    assertEquals(before.minSkipRunSelectivityThreshold(), afterBatch.minSkipRunSelectivityThreshold(), 0.0);  
                    newSettings = Settings.builder().put("search.concurrent_segment_search.mode", "none").build();
                    assertEquals(before.minSkipRunDefault(), afterSlice.minSkipRunDefault());
                    clusterSettings.applySettings(newSettings);
package org.opensearch.be.datafusion;
            DatafusionSettings datafusionSettings = new DatafusionSettings(Settings.EMPTY);
                    newSettings = Settings.builder().put("datafusion.indexed.min_skip_run_selectivity_threshold", newThreshold).build();
    private static final int ITERATIONS = 200;  
                    clusterSettings.applySettings(newSettings);  
                    assertEquals(before.batchSize(), afterSlice.batchSize());  
                    double newThreshold = randomDoubleBetween(0.0, 1.0, true);
        for (int i = 0; i < ITERATIONS; i++) {  
        }  
            int newBatchSize = randomIntBetween(1, 1_000_000);
            clusterSettings.applySettings(
                    break;
                case 3: // min_skip_run_selectivity_threshold  
            assertEquals(newBatchSize, finalSnapshot.batchSize());
            WireConfigSnapshot before = datafusionSettings.getSnapshot();  
                    .put("datafusion.indexed.min_skip_run_selectivity_threshold", newThreshold)
                    .build()  
                    clusterSettings.applySettings(newSettings);  
            assertEquals(1024, finalSnapshot.minSkipRunDefault());
 *
                    newSettings = Settings.builder().put("datafusion.batch_size", newBatchSize).build();
                    assertEquals(before.minSkipRunSelectivityThreshold(), afterSlice.minSkipRunSelectivityThreshold(), 0.0);  
        settingsSet.add(SearchService.CONCURRENT_SEGMENT_SEARCH_TARGET_MAX_SLICE_COUNT_SETTING);
            int settingIndex = randomIntBetween(0, 5);
                    int newMinSkipRun = randomIntBetween(1, 100_000);
                    assertEquals(newPushdown, afterPushdown.listingTablePushdownFilters());
import org.opensearch.search.SearchService;
import org.opensearch.common.settings.Setting;
                    assertEquals(before.minSkipRunSelectivityThreshold(), afterMode.minSkipRunSelectivityThreshold(), 0.0);
    public void testSequentialUpdatesAccumulateCorrectly() {
                    break;
                    clusterSettings.applySettings(newSettings);  
                    assertEquals(newThreshold, afterThreshold.minSkipRunSelectivityThreshold(), 1e-15);
        return new ClusterSettings(Settings.EMPTY, settingsSet);  
                    break;  
                    assertEquals(before.listingTablePushdownFilters(), afterMode.listingTablePushdownFilters());  
            ClusterSettings clusterSettings = createClusterSettings();  
                    break;
        }
/*  
                    WireConfigSnapshot afterSkipRun = datafusionSettings.getSnapshot();
                case 4: // max_slice_count  
            WireConfigSnapshot finalSnapshot = datafusionSettings.getSnapshot();  
    public void testSnapshotUpdateConsistencyProperty() {  
                    assertEquals(before.targetPartitions(), afterPushdown.targetPartitions());
 * The OpenSearch Contributors require contributions made to  
import java.util.HashSet;
                    WireConfigSnapshot afterBatch = datafusionSettings.getSnapshot();
                    assertEquals(before.targetPartitions(), afterThreshold.targetPartitions());
