                public BlockCacheStats stats() {
            assertEquals(shardPath.getDataPath().toString(), evictedPrefix.get());  
            BlockCache mockCache = new BlockCache() {
        1,  
            final ShardId shardId = new ShardId(indexName, indexName, 1);  
                action.shardOperation(clearIndicesCacheRequest, shardRouting)
                mock(IndicesService.class),
                @Override
            when(shardRouting.shardId()).thenReturn(shardId);
        final Environment environment = TestEnvironment.newEnvironment(settings);
    public void testBlockCacheNotEvictedWhenFileCacheFalse() throws IOException {
        ClusterBlocks.Builder builder = ClusterBlocks.builder();  
                    return java.util.Optional.of(mockCache);
            final ShardPath shardPath = ShardPath.loadFileCachePath(nodeEnvironment, shardId);  
            request.fileCache(true);  
            };
                }
            };  
/*  
import org.opensearch.index.store.remote.filecache.FileCacheFactory;  
            );  
    private final Node testNode = mock(Node.class);  
import org.opensearch.transport.TransportService;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
}
                }
    public void testBlockCacheEvictedOnFileCacheClear() throws IOException {
            assertNull(fileCache.get(cacheEntryPath));  
        true,  
        ClusterState metadataReadBlockedState = ClusterState.builder(ClusterState.EMPTY_STATE).blocks(builder).build();
            assertNotNull(fileCache.get(cacheEntryPath));  
        true,
package org.opensearch.action.admin.indices.cache.clear;
import org.opensearch.action.support.broadcast.node.TransportBroadcastByNodeAction;
                public boolean clear() {
        builder.addIndexBlock(indexName, readClusterBlock);  
            AtomicReference<String> evictedPrefix = new AtomicReference<>();  
 * SPDX-License-Identifier: Apache-2.0
        final Settings settings = buildEnvSettings(Settings.EMPTY);  
        builder = ClusterBlocks.builder();
            actionWithRegistry.shardOperation(request, shardRouting);
                TransportBroadcastByNodeAction.EmptyResult.INSTANCE,  
import org.opensearch.index.shard.ShardPath;
            actionWithRegistry.shardOperation(request, shardRouting);
                public void evictPrefix(String prefix) {  
                mock(TransportService.class),  
import org.opensearch.env.NodeEnvironment;
            };
                @Override
                public String cacheName() {  
        1,
        testNode,
            final ShardRouting shardRouting = mock(ShardRouting.class);
 */  
        ClusterState metadataWriteBlockedState = ClusterState.builder(ClusterState.EMPTY_STATE).blocks(builder).build();
import java.io.IOException;
                mock(IndexNameExpressionResolver.class)
            BlockCacheRegistry registry = new BlockCacheRegistry() {
            fileCache.put(cacheEntryPath, new FileCacheTests.StubCachedIndexInput(1));
import org.opensearch.cluster.service.ClusterService;  
        mock(TransportService.class),  
            ClearIndicesCacheRequest request = new ClearIndicesCacheRequest();
    private final ClusterBlock readClusterBlock = new ClusterBlock(
            when(testNode.getNodeEnvironment()).thenReturn(nodeEnvironment);
                public java.util.Optional<BlockCache> get(String name) {  
        try (final NodeEnvironment nodeEnvironment = new NodeEnvironment(settings, environment)) {
                registry,  
                }
                }
            // Add an entry into the filecache and reduce the ref count
        final String indexName = "test";
                }
        builder = ClusterBlocks.builder();
                    evictedPrefix.set(prefix);
        "",
            when(shardRouting.shardId()).thenReturn(shardId);
            request.fileCache(false);  
            final ShardRouting shardRouting = mock(ShardRouting.class);
                }
            clearIndicesCacheRequest.fileCache(true);
                @Override
        assertNull(action.checkGlobalBlock(metadataWriteBlockedState, new ClearIndicesCacheRequest()));
    }
    }
                testNode,
        assertNull(action.checkRequestBlock(metadataWriteBlockedState, new ClearIndicesCacheRequest(), new String[] { indexName }));  
        true,
import org.opensearch.cluster.routing.ShardRouting;
            when(testNode.getNodeEnvironment()).thenReturn(nodeEnvironment);
                @Override
        final Settings settings = buildEnvSettings(Settings.EMPTY);  
    public void testIndexBlockCheck() {
import java.util.EnumSet;  
                @Override
                }
            );  
        ClusterBlocks.Builder builder = ClusterBlocks.builder();
        RestStatus.OK,
import org.opensearch.cluster.block.ClusterBlockLevel;
            // Set up a mock BlockCache that records the evictPrefix call
                public List<BlockCache> all() {
    public void testOnShardOperation() throws IOException {  
                @Override  
import static org.mockito.Mockito.mock;
            ClearIndicesCacheRequest clearIndicesCacheRequest = new ClearIndicesCacheRequest();  
        final String indexName = "test";
import org.opensearch.index.store.remote.filecache.FileCacheTests;
                mock(ActionFilters.class),
import org.opensearch.cluster.ClusterState;  
    }  
        mock(IndexNameExpressionResolver.class)
        mock(IndicesService.class),
                mock(IndexNameExpressionResolver.class)
 *
                @Override  
import java.util.List;
                testNode,
            TransportClearIndicesCacheAction actionWithRegistry = new TransportClearIndicesCacheAction(
                }
        null,  
        true,  
                    return true;
        final Settings settings = buildEnvSettings(Settings.EMPTY);
                    return new BlockCacheStats(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);  
        builder.addGlobalBlock(writeClusterBlock);  
            final FileCache fileCache = FileCacheFactory.createConcurrentLRUFileCache(1024 * 1024, 16);
            final ShardId shardId = new ShardId(indexName, indexName, 1);  
            );
            assertNull("evictPrefix should not be called when fileCache=false", evictedPrefix.get());  
        mock(ActionFilters.class),
import org.opensearch.common.settings.Settings;
import org.opensearch.plugins.BlockCacheRegistry;
                @Override
                @Override
        final String indexName = "test";
            fileCache.decRef(cacheEntryPath);
                @Override
            final ShardRouting shardRouting = mock(ShardRouting.class);
                public void close() {}
                mock(IndicesService.class),
    }
                registry,  
                }  
                public void close() {}
import org.opensearch.plugins.BlockCacheStats;  
                @Override
        "",
    public void testGlobalBlockCheck() {
                }
            ClearIndicesCacheRequest request = new ClearIndicesCacheRequest();
import org.opensearch.cluster.block.ClusterBlock;
                    return "disk";
import org.opensearch.indices.IndicesService;
                mock(TransportService.class),  
import org.opensearch.node.Node;  
            // Initialize necessary stubs for the filecache clear shard operation
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.env.Environment;
        try (final NodeEnvironment nodeEnvironment = new NodeEnvironment(settings, environment)) {
            AtomicReference<String> evictedPrefix = new AtomicReference<>();  
import org.opensearch.index.store.remote.filecache.FileCache;
            when(testNode.fileCache()).thenReturn(fileCache);
    );
    private final ClusterBlock writeClusterBlock = new ClusterBlock(
        true,
        assertNotNull(action.checkGlobalBlock(metadataReadBlockedState, new ClearIndicesCacheRequest()));
            };  
                @Override
                public List<BlockCache> all() {
                mock(ActionFilters.class),
                    evictedPrefix.set(prefix);
        }
            when(testNode.fileCache()).thenReturn(null);
        RestStatus.OK,  
                public String cacheName() {  
import org.opensearch.cluster.block.ClusterBlocks;  
        EnumSet.of(ClusterBlockLevel.METADATA_READ)  
            when(testNode.getNodeEnvironment()).thenReturn(nodeEnvironment);  
            assertEquals(
            when(shardRouting.shardId()).thenReturn(shardId);
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.env.TestEnvironment;  
        }
        }
    private final TransportClearIndicesCacheAction action = new TransportClearIndicesCacheAction(
import org.opensearch.core.rest.RestStatus;  
            TransportClearIndicesCacheAction actionWithRegistry = new TransportClearIndicesCacheAction(
                @Override
import java.util.concurrent.atomic.AtomicReference;
        ClusterState metadataReadBlockedState = ClusterState.builder(ClusterState.EMPTY_STATE).blocks(builder).build();  
 * this file be licensed under the Apache-2.0 license or a
                @Override
        final Environment environment = TestEnvironment.newEnvironment(settings);
        assertNotNull(action.checkRequestBlock(metadataReadBlockedState, new ClearIndicesCacheRequest(), new String[] { indexName }));
                public java.util.Optional<BlockCache> get(String name) {  
 * compatible open source license.
import org.opensearch.plugins.BlockCache;
import org.opensearch.action.support.ActionFilters;
        "uuid",  
        String indexName = "test";
            final Path cacheEntryPath = shardPath.getDataPath();
            final ShardId shardId = new ShardId(indexName, indexName, 1);  
            final ShardPath shardPath = ShardPath.loadFileCachePath(nodeEnvironment, shardId);  
        ClusterState metadataWriteBlockedState = ClusterState.builder(ClusterState.EMPTY_STATE).blocks(builder).build();
            BlockCacheRegistry registry = new BlockCacheRegistry() {
        mock(ClusterService.class),
                    return List.of(mockCache);  
import static org.mockito.Mockito.when;
                    return true;
public class TransportClearIndicesCacheActionTests extends OpenSearchTestCase {
    );
                public BlockCacheStats stats() {
                    return java.util.Optional.of(mockCache);
            when(testNode.fileCache()).thenReturn(null);  
            BlockCache mockCache = new BlockCache() {
            // Check if the entry exists and reduce the ref count to make it evictable
                public boolean clear() {
                }
                public void evictPrefix(String prefix) {  
                    return new BlockCacheStats(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);  
    );  
        builder.addIndexBlock(indexName, writeClusterBlock);
        try (final NodeEnvironment nodeEnvironment = new NodeEnvironment(settings, environment)) {
        "uuid",
import java.nio.file.Path;
                mock(ClusterService.class),
        true,
                mock(ClusterService.class),
        builder.addGlobalBlock(readClusterBlock);
                    return List.of(mockCache);  
                }  
                    return "disk";
        final Environment environment = TestEnvironment.newEnvironment(settings);  
 * The OpenSearch Contributors require contributions made to  
            fileCache.decRef(cacheEntryPath);  
    }
        EnumSet.of(ClusterBlockLevel.METADATA_WRITE)
