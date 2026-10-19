import org.opensearch.index.translog.RemoteFsTranslog;  
 *
 * and reuse every one that carries a footer instead of fetching it again.
        int numDocs = randomIntBetween(10, 30);
package org.opensearch.remotestore;
            // table already names it primary, so give that reset time to run.
     */
        try (MockLogAppender appender = downloadLogAppender()) {  
        }
        ensureGreen(INDEX_NAME);  
    }
    /**
            LogManager.getLogger(RemoteFsTimestampAwareTranslog.class)
    public void testPrimaryRelocationReusesLocallyPresentGenerations() throws Exception {
                .add(new MoveAllocationCommand(INDEX_NAME, 0, sourceNode, targetNode))
        assertHitCount(client().prepareSearch(INDEX_NAME).setSize(0).get(), numDocs + 5);  
        return new MockLogAppender.PatternSeenWithLoggerPrefixExpectation(  
 * SPDX-License-Identifier: Apache-2.0
                .actionGet();
     */  
        indexDocsAsSeparateGenerations(numDocs);
        String targetNode = internalCluster().startDataOnlyNode();
        for (int i = 0; i < numDocs; i++) {
        );
    }  
 */  
        try (MockLogAppender appender = downloadLogAppender()) {
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
            assertEquals(targetNode, primaryNodeName(INDEX_NAME));  
        refresh(INDEX_NAME);
            client().admin()
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;  
 */  
        assertHitCount(client().prepareSearch(INDEX_NAME).setSize(0).get(), numDocs);  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        String sourceNode = internalCluster().startDataOnlyNode();
            "translog generations reused on second download pass",
            // The promoted replica resets its engine (and downloads the translog) asynchronously after the routing  
            appender.addExpectation(generationsReusedExpectation());
        assertEquals(sourceNode, primaryNodeName(INDEX_NAME));  
        createIndex(INDEX_NAME, remoteStoreIndexSettings(0));
    }  
        ensureGreen(INDEX_NAME);
        indexDocsAsSeparateGenerations(5);
        // The first pass logs through the shard's logger, the second through the translog's; listen on both.  
 * compatible open source license.
import org.apache.logging.log4j.LogManager;
/*  
            appender.assertAllExpectationsMatched();
            LogManager.getLogger(RemoteFsTranslog.class),  
import org.opensearch.index.shard.IndexShard;
        internalCluster().startDataOnlyNodes(2);
            assertBusy(appender::assertAllExpectationsMatched, 30, TimeUnit.SECONDS);
        indexDocsAsSeparateGenerations(5);
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNode));  
            ".*generations already present locally=[1-9][0-9]*"
import org.opensearch.index.translog.RemoteFsTimestampAwareTranslog;
        }  
    private static MockLogAppender downloadLogAppender() throws IllegalAccessException {
        return MockLogAppender.createForLoggers(
            appender.addExpectation(generationsReusedExpectation());
        refresh(INDEX_NAME);
        int numDocs = randomIntBetween(10, 30);
}
    }
        // The relocated primary keeps working against the reused generations.  
 * Exercises the incremental remote translog download end to end. A remote-store primary opens its engine by
        String replicaNode = replicaNodeName(INDEX_NAME);
import org.opensearch.test.MockLogAppender;
 * downloading the translog twice into the same directory (once in {@code IndexShard#innerOpenEngineAndTranslog},
        createIndex(INDEX_NAME, remoteStoreIndexSettings(1));  
                .cluster()  
        assertHitCount(client().prepareSearch(INDEX_NAME).setSize(0).get(), numDocs + 5);  
 * The OpenSearch Contributors require contributions made to  
     * always lands in a directory holding no reusable generation and logs {@code locally=0}, which this does not match.  
        );
        refresh(INDEX_NAME);
 * {@code IndexShard#resetEngineToGlobalCheckpoint}. The second pass must find the generations the first pass wrote
    private void indexDocsAsSeparateGenerations(int numDocs) {
        indexDocsAsSeparateGenerations(numDocs);  
 * once more from the {@code RemoteFsTranslog} constructor), and a promoted replica does the same in  
            Level.INFO,  
/**  
        String primaryNode = primaryNodeName(INDEX_NAME);
            assertEquals(replicaNode, primaryNodeName(INDEX_NAME));
public class RemoteStoreTranslogIncrementalDownloadIT extends RemoteStoreBaseIntegTestCase {
        refresh(INDEX_NAME);
import org.apache.logging.log4j.Level;
                .execute()  
import org.opensearch.test.OpenSearchIntegTestCase;  
            ensureGreen(INDEX_NAME);
    }
import org.opensearch.test.InternalTestCluster;
        }
    private static final String INDEX_NAME = "remote-store-test-idx-1";
        assertHitCount(client().prepareSearch(INDEX_NAME).setSize(0).get(), numDocs);
            "org.opensearch.index",
     * {@code numDocs} closed generations that carry a footer (plus the footer-less empty initial one).
    private static MockLogAppender.PatternSeenWithLoggerPrefixExpectation generationsReusedExpectation() {
        internalCluster().startClusterManagerOnlyNode();
            indexSingleDoc(INDEX_NAME);  
     * Logged by the second download pass when at least one generation was found locally and reused. The first pass
            ensureYellowAndNoInitializingShards(INDEX_NAME);
 * this file be licensed under the Apache-2.0 license or a
            LogManager.getLogger(IndexShard.class),
    /**  
                .prepareReroute()
     * Each request-durability write rolls and uploads a generation, so this leaves the remote store with
    public void testReplicaPromotionReusesLocallyPresentGenerations() throws Exception {  
import java.util.concurrent.TimeUnit;
        internalCluster().startClusterManagerOnlyNode();  
