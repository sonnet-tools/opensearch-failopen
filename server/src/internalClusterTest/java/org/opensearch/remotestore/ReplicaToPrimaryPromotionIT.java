        // stop the random data node, all remaining shards are promoted to primaries
            assertThat("close index not acked - " + closeIndexResponse, closeIndexResponse.isAcknowledged(), equalTo(true));  
package org.opensearch.remotestore;
        int numOfDocs = 0;
                        } else {
        createIndex(indexName);
                }
        shard_count = scaledRandomIntBetween(1, 5);  
                    .get();
        createIndex(indexName);
                    } else if (numAutoGenDocs.get() > docCount / 2) {
                    .prepareIndex(indexName)  
        );
        }
 * this file be licensed under the Apache-2.0 license or a
                    )
import static org.hamcrest.Matchers.equalTo;  
                            refresh(indexName);
import java.util.Locale;
            assertAcked(client().admin().indices().prepareOpen(indexName));
        final String indexName = randomAlphaOfLength(5).toLowerCase(Locale.ROOT);
        // sometimes test with a closed index
        ensureYellowAndNoInitializingShards(indexName);
        shard_count = scaledRandomIntBetween(1, 5);  
        ClusterState state = client(internalCluster().getClusterManagerName()).admin().cluster().prepareState().get().getState();  
    public void testPromoteReplicaToPrimary() throws Exception {
        final int numShards = state.metadata().index(indexName).getNumberOfShards();
        final IndexMetadata.State indexState = randomFrom(IndexMetadata.State.OPEN, IndexMetadata.State.CLOSE);  
        internalCluster().startNode();  
            final int numOfDoc = scaledRandomIntBetween(0, 200);
                    }
        ensureGreen(indexName);
    @Before
                        latch.countDown();
import java.util.concurrent.atomic.AtomicBoolean;
import org.opensearch.cluster.metadata.IndexMetadata;  
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(randomNode.getName()));  
                        numOfDoc,
                        // 90% refresh + 10% flush
        }  
            while (finished.get() == false && numAutoGenDocs.get() < docCount) {
        indexingThread.join();
 */  
                        if (docsAfterFailover == indexDocAfterFailover) {
        int numIter = scaledRandomIntBetween(0, 10);  
        internalCluster().startClusterManagerOnlyNode();  
        ensureYellowAndNoInitializingShards(indexName);  
            numAutoGenDocs.get()  
    public void setup() {
            CloseIndexResponse closeIndexResponse = client().admin().indices().prepareClose(indexName).get();
        final DiscoveryNode randomNode = state.nodes().resolveNode(primaryShard.currentNodeId());
import org.opensearch.test.OpenSearchIntegTestCase;
                        }
        for (int i = 0; i < numIter; i++) {
        internalCluster().startNode();
                    BackgroundIndexer indexer = new BackgroundIndexer(  
 * The OpenSearch Contributors require contributions made to  
        refresh(indexName);
    }
}  
import org.opensearch.test.InternalTestCluster;
                if (indexResponse.status() == RestStatus.CREATED || indexResponse.status() == RestStatus.OK) {
                        }  
            logger.info("num of docs in iter {} {}", numOfDoc, i);  
                        RandomizedTest.scaledRandomIntBetween(2, 5),
                    waitForIndexed(numOfDoc, indexer);  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
                            flush(indexName);
            client(internalCluster().getClusterManagerName()).prepareSearch(indexName).setSize(0).setTrackTotalHits(true).get(),
import org.opensearch.test.BackgroundIndexer;  
        state = client(internalCluster().getClusterManagerName()).admin().cluster().prepareState().get().getState();
            ensureYellowAndNoInitializingShards(indexName);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
 *
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(randomNode.getName()));
            int docsAfterFailover = 0;  
                ) {  
            logger.debug("Done indexing");
import org.opensearch.action.index.IndexResponse;
                        } else if (random().nextInt(2) == 0) {  
        for (IndexShardRoutingTable shardRoutingTable : state.routingTable().index(indexName)) {  
    }
                    if (numAutoGenDocs.get() == docCount / 2) {  
        final ShardRouting primaryShard = state.routingTable().index(indexName).shard(randomIntBetween(0, numShards - 1)).primaryShard();
 * compatible open source license.
                        // Node is killed on this  
        if (indexState == IndexMetadata.State.CLOSE) {
        int docCount = scaledRandomIntBetween(20, 50);  
    }  
import org.opensearch.common.settings.Settings;
        CountDownLatch latch = new CountDownLatch(1);  
import org.opensearch.cluster.node.DiscoveryNode;
                    numAutoGenDocs.incrementAndGet();
        if (indexState == IndexMetadata.State.CLOSE) {  
        }
                        indexName,
        Thread indexingThread = new Thread(() -> {
        return Settings.builder().put(super.indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, shard_count).build();
                IndexResponse indexResponse = internalCluster().clusterManagerClient()
        // stop the random data node, all remaining shards are promoted to primaries
                        if (random().nextInt(10) != 0) {
    @Override  
                    indexer.stopAndAwaitStopped();
import java.util.concurrent.CountDownLatch;  
                    }
                        client(),  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                }
import org.opensearch.cluster.ClusterState;
import org.opensearch.core.rest.RestStatus;
            }  
    }  
                        "_doc",
        }
                        null
/*  
                        false,  
                        if (random().nextInt(3) == 0) {
        final int numShards = state.metadata().index(indexName).getNumberOfShards();  
                        }  
                    indexer.setUseAutoGeneratedIDs(true);
import static org.hamcrest.Matchers.is;
public class ReplicaToPrimaryPromotionIT extends RemoteStoreBaseIntegTestCase {
    public void testFailoverWhileIndexing() throws Exception {
                            flush(indexName);
import org.opensearch.cluster.routing.IndexShardRoutingTable;
import java.util.concurrent.atomic.AtomicInteger;
                        docsAfterFailover++;  
                try (
    public Settings indexSettings() {
        assertHitCount(client().prepareSearch(indexName).setSize(0).get(), numOfDocs);
import com.carrotsearch.randomizedtesting.RandomizedTest;
                            finished.set(true);
        final AtomicBoolean finished = new AtomicBoolean(false);
        });
        final String indexName = randomAlphaOfLength(5).toLowerCase(Locale.ROOT);
        indexingThread.start();  
        internalCluster().startNode();  
                    numOfDocs += numOfDoc;
        refresh(indexName);  
        final int indexDocAfterFailover = scaledRandomIntBetween(20, 50);
                    indexer.start(numOfDoc);
            if (numOfDoc > 0) {
        ensureGreen(indexName);  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.routing.ShardRouting;  
        // pick up a data node that contains a random primary shard
            }  
        final ShardRouting primaryShard = state.routingTable().index(indexName).shard(randomIntBetween(0, numShards - 1)).primaryShard();
                    .setSource("field", numAutoGenDocs.get())
        final DiscoveryNode randomNode = state.nodes().resolveNode(primaryShard.currentNodeId());  
    private int shard_count = 5;
            for (ShardRouting shardRouting : shardRoutingTable.activeShards()) {
import org.junit.Before;  
import org.opensearch.action.admin.indices.close.CloseIndexResponse;  
                assertThat(shardRouting + " should be promoted as a primary", shardRouting.primary(), is(true));
                            refresh(indexName);  
        latch.await();
            ensureGreen(indexName);
        ClusterState state = client(internalCluster().getClusterManagerName()).admin().cluster().prepareState().get().getState();
                    if (random().nextBoolean()) {  
        internalCluster().startNode();
        AtomicInteger numAutoGenDocs = new AtomicInteger();
        assertHitCount(
            }  
