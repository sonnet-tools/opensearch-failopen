/*  
        super.tearDown();
 * The OpenSearch Contributors require contributions made to  
import java.util.Set;
import org.opensearch.test.ClusterServiceUtils;  
import static org.mockito.Mockito.verify;
    private StoredFieldsPrefetch storedFieldsPrefetch;
        threadPool.shutdownNow();  
import org.opensearch.cluster.service.ClusterService;
        storedFieldsPrefetch.onPreFetchPhase(searchContext);
import org.opensearch.threadpool.ThreadPool;  
    public void testOnPreFetchPhase_WhenPrefetchDisabled() {
    public void testOnPreFetchPhase_WhenPrefetchEnabled_ZeroDocs() {
package org.opensearch.storage.prefetch;
public class StoredFieldsPrefetchTests extends OpenSearchTestCase {
import java.util.function.Supplier;
    private TieredStoragePrefetchSettings tieredStoragePrefetchSettings;
    private ClusterService clusterService;
}
import org.junit.Before;
    public void setUp() throws Exception {
        clusterSettingsToAdd.add(TieredStoragePrefetchSettings.STORED_FIELDS_PREFETCH_ENABLED_SETTING);  
import org.opensearch.common.settings.Setting;  
        // Prefetch is enabled by default, but no docs to load
import static org.mockito.Mockito.never;  
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, clusterSettingsToAdd);
    }
import static org.mockito.Mockito.when;  
    }
import java.util.HashSet;  
 * compatible open source license.
import org.opensearch.common.settings.ClusterSettings;
import org.opensearch.common.settings.Settings;
import org.opensearch.threadpool.TestThreadPool;
        // docIdsToLoadSize is called in the log statement and in the loop condition
 * this file be licensed under the Apache-2.0 license or a
import static org.mockito.Mockito.mock;
        when(searchContext.docIdsToLoadSize()).thenReturn(0);  
    private SearchContext searchContext;  
    }
 */  
        threadPool = new TestThreadPool("StoredFieldsPrefetchTests");
        return () -> this.tieredStoragePrefetchSettings;
    public Supplier<TieredStoragePrefetchSettings> getPrefetchSettingsSupplier() {  
    }
import org.opensearch.test.OpenSearchTestCase;
        this.tieredStoragePrefetchSettings = new TieredStoragePrefetchSettings(clusterService.getClusterSettings());
        verify(searchContext, never()).docIdsToLoadSize();
    @Before
        searchContext = mock(SearchContext.class);
        verify(searchContext, times(2)).docIdsToLoadSize();  
import static org.mockito.Mockito.times;
import org.opensearch.search.internal.SearchContext;
            .put(TieredStoragePrefetchSettings.STORED_FIELDS_PREFETCH_ENABLED_SETTING.getKey(), false)  
        clusterService.getClusterSettings().applySettings(settings);
    @Override  
        storedFieldsPrefetch.onPreFetchPhase(searchContext);  
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.common.settings.ClusterSettings.BUILT_IN_CLUSTER_SETTINGS;
        super.setUp();  
 *
        Set<Setting<?>> clusterSettingsToAdd = new HashSet<>(BUILT_IN_CLUSTER_SETTINGS);
            .build();
        clusterService = ClusterServiceUtils.createClusterService(Settings.EMPTY, clusterSettings, threadPool);  
    public void tearDown() throws Exception {
    }
    private ThreadPool threadPool;
        Settings settings = Settings.builder()
        storedFieldsPrefetch = new StoredFieldsPrefetch(getPrefetchSettingsSupplier());  
        clusterSettingsToAdd.add(TieredStoragePrefetchSettings.READ_AHEAD_BLOCK_COUNT);
