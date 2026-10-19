 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.OpenSearchTestCase;  
        );
        clusterService.getClusterSettings().applySettings(settings);
    public void tearDown() throws Exception {  
        Set<Setting<?>> clusterSettingsToAdd = new HashSet<>(BUILT_IN_CLUSTER_SETTINGS);
            new ClusterSettings(Settings.EMPTY, clusterSettingsToAdd),  
        );  
        super.setUp();
    }  
    @Before  
import org.opensearch.common.settings.Setting;  
import static org.opensearch.common.settings.ClusterSettings.BUILT_IN_CLUSTER_SETTINGS;
import org.opensearch.common.settings.Settings;
 * compatible open source license.
        clusterService = ClusterServiceUtils.createClusterService(
        assertEquals(tieringServicePrefetchSettings.getReadAheadBlockCount(), 10);
        assertEquals(TieredStoragePrefetchSettings.READ_AHEAD_ENABLE_FILE_FORMATS, settings.getReadAheadEnableFileFormats());
import org.opensearch.cluster.service.ClusterService;
import org.junit.Before;  
import java.util.HashSet;
    private ClusterService clusterService;  
    @Override
    private ThreadPool threadPool;
package org.opensearch.storage.prefetch;
import org.opensearch.threadpool.TestThreadPool;
            Settings.EMPTY,
public class TieredStoragePrefetchSettingsTests extends OpenSearchTestCase {
import org.opensearch.common.settings.ClusterSettings;
        TieredStoragePrefetchSettings settings = new TieredStoragePrefetchSettings(clusterService.getClusterSettings());  
        assertEquals(true, settings.isStoredFieldsPrefetchEnabled());  
            threadPool
    }  
import org.opensearch.threadpool.ThreadPool;
    public void testUpdateAfterGetDefaultSettings() {  
/*  
    }
        TieredStoragePrefetchSettings tieringServicePrefetchSettings = new TieredStoragePrefetchSettings(
 *
        Settings settings = Settings.builder().put(TieredStoragePrefetchSettings.READ_AHEAD_BLOCK_COUNT.getKey(), 10).build();  
        assertEquals(tieringServicePrefetchSettings.getReadAheadBlockCount(), TieredStoragePrefetchSettings.DEFAULT_READ_AHEAD_BLOCK_COUNT);
        clusterSettingsToAdd.add(TieredStoragePrefetchSettings.STORED_FIELDS_PREFETCH_ENABLED_SETTING);  
import java.util.Set;  
        super.tearDown();
        assertEquals(tieringServicePrefetchSettings.isStoredFieldsPrefetchEnabled(), true);
            clusterService.getClusterSettings()
 */  
        threadPool.shutdownNow();
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.test.ClusterServiceUtils;
    public void testDefaultSettings() {
    }  
}
        clusterSettingsToAdd.add(TieredStoragePrefetchSettings.READ_AHEAD_BLOCK_COUNT);
        threadPool = new TestThreadPool("TieredStoragePrefetchSettingsTests");  
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(TieredStoragePrefetchSettings.DEFAULT_READ_AHEAD_BLOCK_COUNT, settings.getReadAheadBlockCount());
    public void setUp() throws Exception {
