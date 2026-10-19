    private final FileCacheSettings fileCacheSettings;
     * Creates the appropriate FsService implementation based on node type.
    @Nullable
    ) {
        this.fileCacheSettings = new FileCacheSettings(settings, clusterSettings);
        NodeCacheService nodeCacheService,
        this.nodeCacheService = nodeCacheService;
            return new WarmFsService(settings, nodeEnvironment, fileCacheSettings, indicesService, nodeCacheService);
     * @return FsService instance  
/**
        NodeEnvironment nodeEnvironment,  
import org.opensearch.common.settings.Settings;
        ClusterSettings clusterSettings,
 *
    }
import org.opensearch.index.store.remote.filecache.FileCacheSettings;  
 * Factory for creating appropriate FsService implementations based on node type.
        this.indicesService = indicesService;  
}
 */  
 *  
 * @opensearch.internal
 * <p>On warm nodes, creates a {@link WarmFsService} that correctly reports virtual
    /**  
    private final NodeCacheService nodeCacheService;  
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.indices.IndicesService;
    }
import org.opensearch.common.Nullable;
     *
package org.opensearch.monitor.fs;
 * this file be licensed under the Apache-2.0 license or a
        }
public class FsServiceProvider {
     */
    private final Settings settings;  
    private final NodeEnvironment nodeEnvironment;
 *
 */  
    public FsServiceProvider(
 * The OpenSearch Contributors require contributions made to  
    private final IndicesService indicesService;
import org.opensearch.env.NodeEnvironment;
import org.opensearch.common.settings.ClusterSettings;  
        if (DiscoveryNode.isWarmNode(settings)) {  
 * SPDX-License-Identifier: Apache-2.0
        Settings settings,
 * disk capacity and cache reservation across all caches (FileCache + block cache).
import org.opensearch.index.store.remote.filecache.NodeCacheService;
 * On non-warm nodes, creates a standard {@link FsService}.  
        this.settings = settings;
 * compatible open source license.
        IndicesService indicesService  
        this.nodeEnvironment = nodeEnvironment;  
/*  
        return new FsService(settings, nodeEnvironment, nodeCacheService != null ? nodeCacheService.fileCache() : null);  
    public FsService createFsService() {
