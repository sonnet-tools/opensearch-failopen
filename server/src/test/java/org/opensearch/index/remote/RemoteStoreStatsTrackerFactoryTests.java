import org.opensearch.index.shard.IndexShard;
        indexShard = createIndexShard(shardId, false);
    }
        shardId = new ShardId("index", "uuid", 0);  
        assertNull(remoteStoreStatsTrackerFactory.getRemoteSegmentTransferTracker(shardId));
    }  
                RemoteStoreStatsTrackerFactory.MOVING_AVERAGE_WINDOW_SIZE.getKey(),  
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),  
        indexShard = createIndexShard(shardId, true);
import org.opensearch.core.index.shard.ShardId;
            IllegalArgumentException.class,  
            )
            .put(
        );
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()
    private ClusterService clusterService;  
        );  
    public void testAfterIndexShardCreatedForRemoteBackedIndex() {
        remoteStoreStatsTrackerFactory = new RemoteStoreStatsTrackerFactory(clusterService, settings);
import org.opensearch.cluster.service.ClusterService;
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()
                settings
            settings,
                ClusterServiceUtils.createClusterService(
    }
            new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
    private RemoteStoreStatsTrackerFactory remoteStoreStatsTrackerFactory;
    public void testGetDefaultSettings() {
 * The OpenSearch Contributors require contributions made to  
        assertNotNull(remoteStoreStatsTrackerFactory.getRemoteSegmentTransferTracker(shardId));  
    public void testUpdateAfterGetConfiguredSettings() {  
    }
            ),
    private ThreadPool threadPool;
        assertNotNull(remoteStoreStatsTrackerFactory.getRemoteSegmentTransferTracker(indexShard.shardId()));
        super.setUp();
        );  
            .put(
    public void testAfterIndexShardCreatedForNonRemoteBackedIndex() {
                RemoteStoreStatsTrackerFactory.Defaults.MOVING_AVERAGE_WINDOW_SIZE_MIN_VALUE  
            RemoteStoreStatsTrackerFactory.Defaults.MOVING_AVERAGE_WINDOW_SIZE_MIN_VALUE,
        clusterService.getClusterSettings().applySettings(newSettings);
        );
        assertThrows(
            () -> new RemoteStoreStatsTrackerFactory(
        remoteStoreStatsTrackerFactory.afterIndexShardCreated(indexShard);  
        assertNull(remoteStoreStatsTrackerFactory.getRemoteSegmentTransferTracker(indexShard.shardId()));
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.test.ClusterServiceUtils;  
            "Failed to parse value",
                RemoteStoreStatsTrackerFactory.Defaults.MOVING_AVERAGE_WINDOW_SIZE_MIN_VALUE - 1
        remoteStoreStatsTrackerFactory.afterIndexShardCreated(indexShard);
            threadPool  
import org.opensearch.common.settings.Settings;  
                    settings,  
/*  
        );  
                RemoteStoreStatsTrackerFactory.MOVING_AVERAGE_WINDOW_SIZE.getKey(),
        clusterService = ClusterServiceUtils.createClusterService(  
    private ShardId shardId;
public class RemoteStoreStatsTrackerFactoryTests extends OpenSearchTestCase {
    }  
import static org.opensearch.index.remote.RemoteStoreTestsHelper.createIndexShard;
    private IndexShard indexShard;  
        remoteStoreStatsTrackerFactory.afterIndexShardClosed(shardId, indexShard, indexShard.indexSettings().getSettings());
}
        assertEquals(102, remoteStoreStatsTrackerFactory.getMovingAverageWindowSize());
import org.opensearch.threadpool.ThreadPool;  
    public void testGetConfiguredSettings() {
    public void testInvalidMovingAverageWindowSize() {  
        // Check moving average window size updated
        // Check moving average window size updated
                    new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
 */  
        threadPool = new TestThreadPool(getTestName());
        super.tearDown();
    public void setUp() throws Exception {
            RemoteStoreStatsTrackerFactory.Defaults.MOVING_AVERAGE_WINDOW_SIZE_MIN_VALUE,
            .build();
        remoteStoreStatsTrackerFactory = new RemoteStoreStatsTrackerFactory(  
            )
                    threadPool
    }  
        assertEquals(  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.OpenSearchTestCase;
 *
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()  
import org.opensearch.common.settings.ClusterSettings;
    public void testAfterIndexShardClosed() {
        Settings newSettings = Settings.builder().put(RemoteStoreStatsTrackerFactory.MOVING_AVERAGE_WINDOW_SIZE.getKey(), 102).build();  
    public void tearDown() throws Exception {  
            )
        threadPool.shutdownNow();
 * compatible open source license.
                Settings.EMPTY,
        remoteStoreStatsTrackerFactory.afterIndexShardCreated(indexShard);  
        Settings settings = Settings.builder()
    @Override  
    }  
import org.opensearch.threadpool.TestThreadPool;
    }
        );
            .build();  
        assertEquals(
            ClusterServiceUtils.createClusterService(
    @Override
    }
                threadPool
package org.opensearch.index.remote;
        settings = Settings.builder()  
    private Settings settings;
                ),  
        assertEquals(  
            RemoteStoreStatsTrackerFactory.Defaults.MOVING_AVERAGE_WINDOW_SIZE,
            Settings.EMPTY  
