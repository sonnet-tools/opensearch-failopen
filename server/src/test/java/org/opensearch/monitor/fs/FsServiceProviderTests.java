        IndicesService indicesService = mock(IndicesService.class);
     */  
     */
        Settings settings = Settings.EMPTY;  // no warm role
            assertTrue(  
        try (var nodeEnv = newNodeEnvironment(settings)) {
        ClusterSettings clusterSettings = new ClusterSettings(settings, BUILT_IN_CLUSTER_SETTINGS);
 * compatible open source license.
     * On a warm node, the provider must return a {@link WarmFsService}.
import static org.opensearch.common.settings.ClusterSettings.BUILT_IN_CLUSTER_SETTINGS;  
            );
        when(orchestrator.fileCache()).thenReturn(fileCache);
import static org.mockito.Mockito.mock;
        NodeCacheService orchestrator = mock(NodeCacheService.class);
            assertNotNull(fsService);
import org.opensearch.indices.IndicesService;  
            assertNotNull(fsService);
    /**  
        Settings settings = Settings.builder()
public class FsServiceProviderTests extends OpenSearchTestCase {
     * the provider still returns a standard FsService since the node is not warm.  
        try (var nodeEnv = newNodeEnvironment(settings)) {
        }
     * On a non-warm node with a non-null orchestrator (mixed-node scenario),
     * {@link FsService} — NOT a {@link WarmFsService}.
            assertFalse(
        try (var nodeEnv = newNodeEnvironment(settings)) {
        when(fileCache.capacity()).thenReturn(1024L * 1024 * 1024);
 */  
     * On a non-warm node (no WARM_ROLE in settings), the provider must return a plain
        FileCache fileCache = mock(FileCache.class);
        IndicesService indicesService = mock(IndicesService.class);
    public void testCreateFsServiceReturnsStandardFsServiceOnNonWarmNode() throws Exception {
/*  
 *
        when(fileCache.capacity()).thenReturn(100L * 1024 * 1024);
        Settings settings = Settings.EMPTY;  // data node, not warm  
        when(fileCache.usage()).thenReturn(0L);  
            );  
 * The OpenSearch Contributors require contributions made to  
            assertFalse("Non-warm node must NOT produce a WarmFsService", fsService instanceof WarmFsService);  
}
        NodeCacheService orchestrator = null;  // absent on non-warm nodes
        when(orchestrator.virtualBlockCacheBytes()).thenReturn(0L);
        when(orchestrator.fileCache()).thenReturn(fileCache);  
                "Warm node must produce a WarmFsService but got: " + fsService.getClass().getSimpleName(),
        NodeCacheService orchestrator = mock(NodeCacheService.class);
                fsService instanceof WarmFsService
        }
     */  
            FsService fsService = provider.createFsService();
            FsService fsService = provider.createFsService();  
import org.opensearch.common.settings.Settings;  
/**
            .put("node.search.cache.size", "1gb")
 * Functional tests for {@link FsServiceProvider}.
            assertNotNull(fsService);  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.OpenSearchTestCase;
            FsServiceProvider provider = new FsServiceProvider(settings, nodeEnv, orchestrator, clusterSettings, indicesService);  
            FsServiceProvider provider = new FsServiceProvider(settings, nodeEnv, orchestrator, clusterSettings, indicesService);
    /**
import org.opensearch.index.store.remote.filecache.FileCache;
package org.opensearch.monitor.fs;
    }
    /**
        FileCache fileCache = mock(FileCache.class);  
 */  
                fsService instanceof WarmFsService  
    public void testCreateFsServiceReturnsStandardFsServiceWhenOrchestratorPresentButNotWarmNode() throws Exception {
            .build();
import org.opensearch.index.store.remote.filecache.NodeCacheService;
        }
            FsService fsService = provider.createFsService();  
        when(orchestrator.cacheUtilizedBytes()).thenReturn(0L);
import org.opensearch.cluster.node.DiscoveryNodeRole;
    }
        IndicesService indicesService = mock(IndicesService.class);
 * SPDX-License-Identifier: Apache-2.0
    public void testCreateFsServiceReturnsWarmFsServiceOnWarmNode() throws Exception {
            .put("node.roles", DiscoveryNodeRole.WARM_ROLE.roleName())  
        when(fileCache.usage()).thenReturn(0L);
        when(orchestrator.blockCacheCapacityBytes()).thenReturn(0L);  
                "Non-warm node must NOT produce WarmFsService even when orchestrator is present",
import static org.mockito.Mockito.when;
import org.opensearch.common.settings.ClusterSettings;
        ClusterSettings clusterSettings = new ClusterSettings(settings, BUILT_IN_CLUSTER_SETTINGS);  
    }  
            FsServiceProvider provider = new FsServiceProvider(settings, nodeEnv, orchestrator, clusterSettings, indicesService);
        ClusterSettings clusterSettings = new ClusterSettings(settings, BUILT_IN_CLUSTER_SETTINGS);  
