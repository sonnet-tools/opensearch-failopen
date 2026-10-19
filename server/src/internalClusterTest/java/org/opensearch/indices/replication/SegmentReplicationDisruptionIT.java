            internalCluster().getInstance(TransportService.class, replicaNode),
    }  
        primaryTransportService.addSendBehavior(
            primaryNode  
            }
        waitForSearchableDocs(INDEX_NAME, 10, List.of(replicaNode));
    }
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        MockTransportService primaryTransportService = ((MockTransportService) internalCluster().getInstance(
import org.opensearch.indices.recovery.RecoveryState;
                        0L  
        );
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        assertBusy(() -> {  
import org.opensearch.index.shard.IndexShard;  
                .get();
            Settings.builder()
import org.opensearch.common.settings.Settings;
package org.opensearch.indices.replication;
        refresh(INDEX_NAME);
                .get();  
                .put(indexSettings())
        ensureYellow(INDEX_NAME);  
            // assert we have a peer recovery after the original
                return recoveryState.getTimer().stopTime();
        ensureGreen(INDEX_NAME);
        waitForNewPeerRecovery(replicaNode, originalRecoveryTime);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
                .setId(String.valueOf(i))
                        ((FileChunkRequest) request).shardId(),  
                .setSource(jsonBuilder().startObject().field("field", i).endObject())  
        final long originalRecoveryTime = getRecoveryStopTime(replicaNode);
                .put(indexSettings())  
    }  
            final long time = getRecoveryStopTime(replicaNode);
        );
        }, 1, TimeUnit.MINUTES);  
            if (recoveryState.getTargetNode().getName().equals(nodeName)) {
/*  
    @Before
 * this file be licensed under the Apache-2.0 license or a
                } else {
        internalCluster().startClusterManagerOnlyNode();  
    private void setup() {  
        latch.await();  
        for (int i = 11; i < 21; i++) {
                    FileChunkRequest req = (FileChunkRequest) request;
        final String primaryNode = internalCluster().startDataOnlyNode();
                if (action.equals(SegmentReplicationTargetService.Actions.FILE_CHUNK) && failed.getAndSet(true) == false) {
                }  
 *
        CountDownLatch latch = new CountDownLatch(1);
        waitForSearchableDocs(20, primaryNode, replicaNode);
        waitForNewPeerRecovery(replicaNode, originalRecoveryTime);  
        for (RecoveryState recoveryState : recoveryStates) {  
        for (int i = 0; i < 100; i++) {  
        refresh(INDEX_NAME);
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
    }  
                        0,
                    );
        final long originalRecoveryTime = getRecoveryStopTime(replicaNode);  
                        new BytesArray("test"),  
            TransportService.class,
import java.util.concurrent.atomic.AtomicBoolean;  
import org.opensearch.core.common.bytes.BytesArray;
                    connection.sendRequest(requestId, action, corrupt, options);
        }
 */  
            client().prepareIndex(INDEX_NAME)
                        req.recoveryId(),
        createIndex(  
import org.opensearch.transport.TransportRequest;
        createIndex(
        // reset checkIndex to ensure our original shard doesn't throw  
                .put("index.refresh_interval", -1)  
        }
import java.util.List;  
import org.opensearch.test.OpenSearchIntegTestCase;  
        for (int i = 0; i < 10; i++) {  
            assertNotEquals(time, 0);  
                    latch.countDown();  
                .build()  
                .put("index.refresh_interval", -1)
        );
        final String primaryNode = internalCluster().startDataOnlyNode();
        final String replicaNode = internalCluster().startDataOnlyNode();  
        waitForSearchableDocs(100, primaryNode, replicaNode);
        assertNotEquals(originalRecoveryTime, 0);
}
                .setSource(jsonBuilder().startObject().field("field", i).endObject())  
            client().prepareIndex(INDEX_NAME)
import java.util.concurrent.TimeUnit;
 * The OpenSearch Contributors require contributions made to  
            (connection, requestId, action, request, options) -> {  
 * can fail with an access denied IOException because deletion is not permitted.  
                    TransportRequest corrupt = new FileChunkRequest(  
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
import java.util.concurrent.CountDownLatch;
import org.opensearch.action.admin.indices.recovery.RecoveryResponse;
            }  
import org.opensearch.transport.TransportService;  
                        ((FileChunkRequest) request).position(),
        assertTrue(failed.get());
    private void waitForNewPeerRecovery(String replicaNode, long originalRecoveryTime) throws Exception {
 */
        ensureYellow(INDEX_NAME);
            client().prepareIndex(INDEX_NAME)  
    }
import org.opensearch.test.transport.MockTransportService;
            INDEX_NAME,  
            Settings.builder()
        indexShard.store().directory().deleteFile("_0.si");  
        ));
        internalCluster().startClusterManagerOnlyNode();
import org.apache.lucene.tests.util.LuceneTestCase;
            assertNotEquals(originalRecoveryTime, time);
        resetCheckIndexStatus();
                .setId(String.valueOf(i))
        ensureGreen(INDEX_NAME);
        ensureGreen(INDEX_NAME);
        AtomicBoolean failed = new AtomicBoolean(false);  
        }
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        resetCheckIndexStatus();
public class SegmentReplicationDisruptionIT extends SegmentReplicationBaseIT {
import org.opensearch.cluster.metadata.IndexMetadata;  
        final List<RecoveryState> recoveryStates = recoveryResponse.shardRecoveryStates().get(INDEX_NAME);
/**
                    connection.sendRequest(requestId, action, request, options);
 * These tests simulate corruption cases during replication.  They are skipped on WindowsFS simulation where file renaming
    public void testWipeSegmentBetweenSyncs() throws Exception {
        final RecoveryResponse recoveryResponse = client().admin().indices().prepareRecoveries(INDEX_NAME).get();
        return 0L;
        final IndexShard indexShard = getIndexShard(replicaNode, INDEX_NAME);
                .build()
@LuceneTestCase.SuppressFileSystems("WindowsFS")  
                .setSource(jsonBuilder().startObject().field("field", i).endObject())
import org.opensearch.indices.recovery.FileChunkRequest;
    private long getRecoveryStopTime(String nodeName) {  
import org.junit.Before;
        }
                .setId(String.valueOf(i))
                        ((FileChunkRequest) request).metadata(),
            INDEX_NAME,
    public void testSendCorruptBytesToReplica() throws Exception {
                        ((FileChunkRequest) request).requestSeqNo(),
                .get();
                        false,
        final String replicaNode = internalCluster().startDataOnlyNode();
        refresh(INDEX_NAME);  
