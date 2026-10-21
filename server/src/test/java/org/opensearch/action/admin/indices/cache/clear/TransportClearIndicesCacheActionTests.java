        final Settings settings = buildEnvSettings(Settings.EMPTY);
        true,
package org.opensearch.action.admin.indices.cache.clear;
    public void testBlockCacheNotEvictedWhenFileCacheFalse() throws IOException {
import org.opensearch.env.TestEnvironment;
            ClearIndicesCacheRequest request = new ClearIndicesCacheRequest();
            // Check if the entry exists and reduce the ref count to make it evictable
            final ShardRouting shardRouting = mock(ShardRouting.class);
        final Environment environment = TestEnvironment.newEnvironment(settings);
import org.opensearch.cluster.block.ClusterBlockLevel;
        mock(IndexNameExpressionResolver.class)
            TransportClearIndicesCacheAction actionWithRegistry = new TransportClearIndicesCacheAction(
        testNode,
        ClusterState metadataWriteBlockedState = ClusterState.builder(ClusterState.EMPTY_STATE).blocks(builder).build();
        final Environment environment = TestEnvironment.newEnvironment(settings);
                }
import org.opensearch.index.store.remote.filecache.FileCacheTests;
import org.opensearch.action.support.ActionFilters;
                public java.util.Optional<BlockCache> get(String name) {
            fileCache.decRef(cacheEntryPath);
        builder.addIndexBlock(indexName, readClusterBlock);
        try (final NodeEnvironment nodeEnvironment = new NodeEnvironment(settings, environment)) {
import java.util.concurrent.atomic.AtomicReference;
            );
        "uuid",
                public void close() {}
        assertNull(action.checkGlobalBlock(metadataWriteBlockedState, new ClearIndicesCacheRequest()));
                    return List.of(mockCache);
import org.opensearch.core.index.shard.ShardId;
            when(testNode.getNodeEnvironment()).thenReturn(nodeEnvironment);
                @Override
        true,
        "",
            clearIndicesCacheRequest.fileCache(true);
import org.opensearch.action.support.broadcast.node.TransportBroadcastByNodeAction;
        builder = ClusterBlocks.builder();
                mock(ClusterService.class),
import org.opensearch.env.NodeEnvironment;
        final String indexName = "test";
            when(shardRouting.shardId()).thenReturn(shardId);
                @Override
 */
        assertNotNull(action.checkRequestBlock(metadataReadBlockedState, new ClearIndicesCacheRequest(), new String[] { indexName }));
            assertEquals(shardPath.getDataPath().toString(), evictedPrefix.get());
        ClusterBlocks.Builder builder = ClusterBlocks.builder();
 *
            final FileCache fileCache = FileCacheFactory.createConcurrentLRUFileCache(1024 * 1024, 16);
                @Override
                }
            BlockCacheRegistry registry = new BlockCacheRegistry() {
                @Override
                @Override
            };
    public void testGlobalBlockCheck() {
/*
            final ShardRouting shardRouting = mock(ShardRouting.class);
                }
import org.opensearch.index.shard.ShardPath;
    private final TransportClearIndicesCacheAction action = new TransportClearIndicesCacheAction(
            assertEquals(
import java.io.IOException;
    }
        builder.addGlobalBlock(readClusterBlock);
                public BlockCacheStats stats() {
            final ShardRouting shardRouting = mock(ShardRouting.class);
            fileCache.decRef(cacheEntryPath);
            final ShardPath shardPath = ShardPath.loadFileCachePath(nodeEnvironment, shardId);
            when(shardRouting.shardId()).thenReturn(shardId);
                }
        EnumSet.of(ClusterBlockLevel.METADATA_WRITE)
            when(testNode.getNodeEnvironment()).thenReturn(nodeEnvironment);
                }
                public void evictPrefix(String prefix) {
            assertNull(fileCache.get(cacheEntryPath));
            );
                mock(ActionFilters.class),
        final Settings settings = buildEnvSettings(Settings.EMPTY);
                registry,
        true,
            // Add an entry into the filecache and reduce the ref count
        mock(TransportService.class),
                }
            assertNotNull(fileCache.get(cacheEntryPath));
                }
    private final ClusterBlock readClusterBlock = new ClusterBlock(
import org.opensearch.index.store.remote.filecache.FileCache;
            };
        builder = ClusterBlocks.builder();
            // Initialize necessary stubs for the filecache clear shard operation
                mock(TransportService.class),
        ClusterState metadataReadBlockedState = ClusterState.builder(ClusterState.EMPTY_STATE).blocks(builder).build();
                }
import org.opensearch.cluster.block.ClusterBlock;
import org.opensearch.node.Node;
            assertNull("evictPrefix should not be called when fileCache=false", evictedPrefix.get());
            actionWithRegistry.shardOperation(request, shardRouting);
        final String indexName = "test";
                @Override
            BlockCache mockCache = new BlockCache() {
        builder.addIndexBlock(indexName, writeClusterBlock);
 * The OpenSearch Contributors require contributions made to
        "uuid",
                public void evictPrefix(String prefix) {
                @Override
        }
                public BlockCacheStats stats() {
        }
                public String cacheName() {
}
                }
    );
import org.opensearch.cluster.service.ClusterService;
                public boolean clear() {
 * SPDX-License-Identifier: Apache-2.0
            request.fileCache(false);
            final ShardId shardId = new ShardId(indexName, indexName, 1);
                public void close() {}
                    return "disk";
        mock(ClusterService.class),
        "",
                mock(TransportService.class),
                    return "disk";
                @Override
                mock(ClusterService.class),
        String indexName = "test";
        ClusterState metadataWriteBlockedState = ClusterState.builder(ClusterState.EMPTY_STATE).blocks(builder).build();
                TransportBroadcastByNodeAction.EmptyResult.INSTANCE,
import org.opensearch.cluster.routing.ShardRouting;
    private final Node testNode = mock(Node.class);
    }
            ClearIndicesCacheRequest clearIndicesCacheRequest = new ClearIndicesCacheRequest();
import java.nio.file.Path;
        true,
                @Override
            fileCache.put(cacheEntryPath, new FileCacheTests.StubCachedIndexInput(1));
    );
        final Settings settings = buildEnvSettings(Settings.EMPTY);
                mock(IndicesService.class),
    private final ClusterBlock writeClusterBlock = new ClusterBlock(
import org.opensearch.plugins.BlockCacheStats;
    );
            BlockCacheRegistry registry = new BlockCacheRegistry() {
                @Override
            AtomicReference<String> evictedPrefix = new AtomicReference<>();
import java.util.List;
        mock(IndicesService.class),
                public java.util.Optional<BlockCache> get(String name) {
    }
            // Set up a mock BlockCache that records the evictPrefix call
                mock(ActionFilters.class),
import org.opensearch.test.OpenSearchTestCase;
                mock(IndexNameExpressionResolver.class)
import org.opensearch.plugins.BlockCache;
            when(testNode.fileCache()).thenReturn(fileCache);
import org.opensearch.cluster.block.ClusterBlocks;
                    evictedPrefix.set(prefix);
        }
import org.opensearch.env.Environment;
        RestStatus.OK,
import org.opensearch.core.rest.RestStatus;
            TransportClearIndicesCacheAction actionWithRegistry = new TransportClearIndicesCacheAction(
 * this file be licensed under the Apache-2.0 license or a
            when(shardRouting.shardId()).thenReturn(shardId);
    }
        EnumSet.of(ClusterBlockLevel.METADATA_READ)
        true,
        RestStatus.OK,
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            when(testNode.fileCache()).thenReturn(null);
import org.opensearch.indices.IndicesService;
                registry,
import org.opensearch.transport.TransportService;
        assertNull(action.checkRequestBlock(metadataWriteBlockedState, new ClearIndicesCacheRequest(), new String[] { indexName }));
            when(testNode.fileCache()).thenReturn(null);
        try (final NodeEnvironment nodeEnvironment = new NodeEnvironment(settings, environment)) {
                @Override
        ClusterState metadataReadBlockedState = ClusterState.builder(ClusterState.EMPTY_STATE).blocks(builder).build();
        final String indexName = "test";
    }
                @Override
            final Path cacheEntryPath = shardPath.getDataPath();
                public List<BlockCache> all() {
        mock(ActionFilters.class),
                }
import org.opensearch.plugins.BlockCacheRegistry;
        final Environment environment = TestEnvironment.newEnvironment(settings);
                    return new BlockCacheStats(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
                testNode,
            actionWithRegistry.shardOperation(request, shardRouting);
        try (final NodeEnvironment nodeEnvironment = new NodeEnvironment(settings, environment)) {
        1,
            };
                public String cacheName() {
                action.shardOperation(clearIndicesCacheRequest, shardRouting)
            final ShardId shardId = new ShardId(indexName, indexName, 1);
            request.fileCache(true);
                @Override
                    evictedPrefix.set(prefix);
        assertNotNull(action.checkGlobalBlock(metadataReadBlockedState, new ClearIndicesCacheRequest()));
import org.opensearch.common.settings.Settings;
                    return true;
        null,
            BlockCache mockCache = new BlockCache() {
import org.opensearch.cluster.ClusterState;
                public boolean clear() {
        builder.addGlobalBlock(writeClusterBlock);
                    return java.util.Optional.of(mockCache);
                    return true;
            );
            final ShardPath shardPath = ShardPath.loadFileCachePath(nodeEnvironment, shardId);
 * compatible open source license.
            AtomicReference<String> evictedPrefix = new AtomicReference<>();
                mock(IndicesService.class),
            ClearIndicesCacheRequest request = new ClearIndicesCacheRequest();
import java.util.EnumSet;
                    return List.of(mockCache);
            when(testNode.getNodeEnvironment()).thenReturn(nodeEnvironment);
                public List<BlockCache> all() {
                    return java.util.Optional.of(mockCache);
    public void testIndexBlockCheck() {
import org.opensearch.index.store.remote.filecache.FileCacheFactory;
                }
    public void testOnShardOperation() throws IOException {
                @Override
                    return new BlockCacheStats(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
                }
        ClusterBlocks.Builder builder = ClusterBlocks.builder();
                testNode,
    public void testBlockCacheEvictedOnFileCacheClear() throws IOException {
import static org.mockito.Mockito.mock;
                mock(IndexNameExpressionResolver.class)
public class TransportClearIndicesCacheActionTests extends OpenSearchTestCase {
import static org.mockito.Mockito.when;
        true,
            final ShardId shardId = new ShardId(indexName, indexName, 1);
            };
        1,
