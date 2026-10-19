import org.opensearch.cluster.routing.ShardRouting;  
        replicaTransportService.addRequestHandlingBehavior(
        public IndexResult index(Index index) throws IOException {
 */  
            return Optional.of(new MockEngineFactory());
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
import org.opensearch.index.engine.InternalEngine;
import java.util.List;
        @Override
        // until the primary is stopped and the replica is promoted.  
            replica  
    }
        refresh(INDEX_NAME);
        flush(INDEX_NAME);  
        ));
        indexLuceneLatch.countDown();
            .filter(plugin -> !plugin.getName().contains("MockEngineFactoryPlugin"))
        indexLuceneLatch = new CountDownLatch(1);
                }  
    }  
        flushLatch = new CountDownLatch(1);
        assertEquals(2L, response.getHits().getTotalHits().value());
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.IndexSettings;  
import org.opensearch.common.settings.Settings;
        }
            super(config);
        MockTransportService replicaTransportService = ((MockTransportService) internalCluster().getInstance(
    }  
    @Before
    public static class MockNRTReplicationEngine extends NRTReplicationEngine {
        @Override
        }  
import org.opensearch.plugins.Plugin;  
        public Optional<EngineFactory> getEngineFactory(final IndexSettings indexSettings) {  
            return config.isReadOnlyReplica() ? new MockNRTReplicationEngine(config) : new MockInternalEngine(config);
            IndexResult indexResult = super.index(index);  
        // stop the primary node - we only have one shard on here.
        );
        lockEnable = true;
                refreshLatch.countDown();
        assertTrue("flushLatch timed out", flushLatch.await(30, TimeUnit.SECONDS));
    private static boolean lockEnable;
        internalCluster().startClusterManagerOnlyNode();
import java.util.Collection;  
                    flushLatch.countDown();
        writeThread.start();
                throw new RuntimeException(e);
            (handler, request, channel, task) -> {
    // Used to test that primary promotion does not result in data loss.
import java.util.concurrent.TimeUnit;
            if (lockEnable) {
package org.opensearch.indices.replication;
        MockNRTReplicationEngine(EngineConfig config) throws EngineException {  
            return indexResult;
import org.opensearch.index.engine.NRTReplicationEngine;  
        waitForSearchableDocs(1, replica);
        waitForSearchableDocs(1, replica);  
        createIndex(INDEX_NAME, Settings.builder().put(indexSettings()).put("index.refresh_interval", -1).build());
 * this file be licensed under the Apache-2.0 license or a
        logger.info("refresh index");
    @Override
        refresh(INDEX_NAME);  
            TransportService.class,
import org.opensearch.index.engine.Engine;
import org.opensearch.action.support.replication.TransportReplicationAction;
import org.opensearch.transport.TransportService;
            }  
public class SegmentReplicationPrimaryPromotionIT extends SegmentReplicationBaseIT {
import org.opensearch.index.engine.EngineConfig;
    }
        assertTrue("refreshLatch timed out", refreshLatch.await(30, TimeUnit.SECONDS));  
    private static CountDownLatch flushLatch;
    private static CountDownLatch indexLuceneLatch;  
import org.opensearch.test.transport.MockTransportService;  
        assertFalse("writeThread did not complete in time", writeThread.isAlive());
            return seqNo;
            super(config);
            long seqNo = super.generateSeqNoForOperationOnPrimary(operation);
import org.opensearch.plugins.EnginePlugin;
    public void setup() {
            }  
import org.opensearch.test.OpenSearchIntegTestCase;
        }
import org.opensearch.transport.RemoteTransportException;
    }
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primary));
import java.util.Optional;
        MockInternalEngine(EngineConfig config) throws EngineException {
                if (lockEnable) {  
            } catch (Exception e) {
    private static CountDownLatch refreshLatch;
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
    protected Collection<Class<? extends Plugin>> getMockPlugins() {
        }  
import org.opensearch.test.InternalTestCluster;
                throw new RemoteTransportException("mock remote transport exception", new OpenSearchRejectedExecutionException());
        lockEnable = false;  
        public Engine newReadWriteEngine(EngineConfig config) {
}
        protected long generateSeqNoForOperationOnPrimary(final Operation operation) {  
    public static class MockEnginePlugin extends Plugin implements EnginePlugin {
        ensureYellowAndNoInitializingShards(INDEX_NAME);  
import org.opensearch.index.engine.EngineFactory;
        assertTrue(replicaShardRouting + " should be promoted as a primary", replicaShardRouting.primary());
        final ShardRouting replicaShardRouting = getShardRoutingForNodeName(replica);
 *
            .collect(java.util.stream.Collectors.toList());
    }
        @Override
 * The OpenSearch Contributors require contributions made to  
        client().prepareIndex(INDEX_NAME).setId("1").setSource("foo", "bar").get();
        waitForSearchableDocs(2, primary);
    public void testPrimaryStopped_ReplicaPromoted_no_data_loss() throws Exception {  
        flush(INDEX_NAME);
        assertNotNull(replicaShardRouting);  
        refresh(INDEX_NAME);  
        return plugins;
import org.opensearch.index.engine.EngineException;  
        writeThread.join(TimeUnit.SECONDS.toMillis(30));
        ensureGreen(INDEX_NAME);
        plugins.add(MockEnginePlugin.class);  
    }  
        // The exception is thrown unconditionally to simulate persistent publish-checkpoint failures
        replicaTransportService.clearAllRules();  
            }  
    public static class MockEngineFactory implements EngineFactory {
        Thread writeThread = new Thread(() -> { client().prepareIndex(INDEX_NAME).setId("2").setSource("foo2", "bar2").get(); });  
 * compatible open source license.
import org.junit.Before;  
import org.opensearch.indices.replication.checkpoint.PublishCheckpointAction;
/*  
        }
            try {
        waitForSearchableDocs(1, primary);
        ensureYellowAndNoInitializingShards(INDEX_NAME);  
        final String primary = internalCluster().startDataOnlyNode();
        List<Class<? extends Plugin>> plugins = super.getMockPlugins().stream()  
import java.io.IOException;
    public static class MockInternalEngine extends InternalEngine {  
import java.util.concurrent.CountDownLatch;  
        @Override  
        SearchResponse response = client(replica).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get();
        final String replica = internalCluster().startDataOnlyNode();
import org.opensearch.action.search.SearchResponse;
        }
            PublishCheckpointAction.ACTION_NAME + TransportReplicationAction.REPLICA_ACTION_SUFFIX,  
        refreshLatch = new CountDownLatch(1);  
                    assertTrue("indexLuceneLatch timed out", indexLuceneLatch.await(30, TimeUnit.SECONDS));
