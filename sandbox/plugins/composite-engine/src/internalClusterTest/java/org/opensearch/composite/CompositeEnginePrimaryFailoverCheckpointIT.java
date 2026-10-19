            .filter(s -> s.started())
        assertBusy(() -> {  
            assertEquals("primary maxSeqNo", 2L, p.seqNoStats().getMaxSeqNo());
            assertEquals("primary persistedLCP", 2L, p.getLocalCheckpoint());
    protected Settings nodeSettings(int nodeOrdinal) {
/*  
    /** Waits until the primary's operationPrimaryTerm reaches {@code expectedTerm}. */
                LucenePlugin.class,  
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
 * nodes stay alive and the node-scoped DataFusion runtime survives.
import org.opensearch.index.shard.IndexShard;
import org.opensearch.arrow.allocator.ArrowBasePlugin;  
        }, 30, TimeUnit.SECONDS);
        internalCluster().startDataOnlyNodes(2);
            assertEquals("replica lastProcessedLCP matches primary", p.getProcessedLocalCheckpoint(), r.getProcessedLocalCheckpoint());  
            )  
/**
        assertFalse("doc 3 must succeed: " + doc3.getFailureMessage(), doc3.isFailed());  
    @Override
        String oldPrimary = primaryNodeName();  
    }
    private String primaryNodeName() {
            .putList("index.composite.secondary_data_formats", List.of("lucene"))
        BulkItemResponse doc3 = indexOne("3", "value-3");
import org.opensearch.action.bulk.BulkResponse;
 * compatible open source license.
        ensureYellowAndNoInitializingShards(INDEX_NAME);  
            .put("index.pluggable.dataformat", "composite")
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(dfaIndexSettings()).get();
        internalCluster().startClusterManagerOnlyNode();  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
import org.opensearch.be.datafusion.DataFusionPlugin;
        return bulk.getItems()[0];  
            IndexShard shard = getIndexShard(primaryNodeName(), INDEX_NAME);
 * converge to 2 and the replica's processed LCP catches up.  
            IndexShard r = getIndexShard(replicaNodeName(), INDEX_NAME);
                InternalSettingsPlugin.class
        assertFalse("doc 2 must succeed on new primary: " + doc2.getFailureMessage(), doc2.isFailed());  
            .put(super.nodeSettings(nodeOrdinal))
package org.opensearch.composite;
 * SPDX-License-Identifier: Apache-2.0
        assertBusy(() -> {  
 * this file be licensed under the Apache-2.0 license or a
        waitForPrimaryTerm(2L, TimeValue.timeValueSeconds(30));
            assertEquals("primary lastSyncedGCP catches up to LCP", p.getLocalCheckpoint(), p.getLastSyncedGlobalCheckpoint());
        assertFalse("doc 1 must succeed: " + doc1.getFailureMessage(), doc1.isFailed());
import org.opensearch.action.bulk.BulkItemResponse;
import java.util.List;
            // 30s default timer waiting for the replica to catch up.  
        assertEquals(1, bulk.getItems().length);
    private void waitForPrimaryTerm(long expectedTerm, TimeValue timeout) throws Exception {
 */  
        ensureGreen(INDEX_NAME);
    protected Collection<Class<? extends Plugin>> nodePlugins() {
 * Control variant of {@link CompositeEngineLuceneFailureCheckpointIT}: unmodified
        // Trigger a graceful primary handover: cancel the primary's allocation via cluster  
 */
            Stream.of(
import org.opensearch.common.unit.TimeValue;  
 *
                DataFusionPlugin.class,
                ParquetDataFormatPlugin.class,
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;  
        logger.info("Current Allocation: {}", getClusterState().routingTable().index(INDEX_NAME));
import org.opensearch.common.util.FeatureFlags;
            .put("index.composite.primary_data_format", "parquet")  
import java.util.concurrent.TimeUnit;  
            .stream()  
        String nodeId = getClusterState().routingTable().index(INDEX_NAME).shard(0).primaryShard().currentNodeId();  
    }
import org.opensearch.parquet.ParquetDataFormatPlugin;
        // the node-scoped DataFusion Tokio runtime manager (which dies on hard node stop).
import org.opensearch.be.lucene.LucenePlugin;
            .currentNodeId();
        return getClusterState().nodes().get(nodeId).getName();
            assertEquals("primary term did not reach expected value", expectedTerm, shard.getOperationPrimaryTerm());
import org.opensearch.cluster.routing.allocation.command.CancelAllocationCommand;
import org.opensearch.test.OpenSearchIntegTestCase;
        return getClusterState().nodes().get(nodeId).getName();
 * the fault-injection variant: primary maxSeqNo, processed/persisted LCP, and lastSyncedGCP
 * After cancel-reroute → 3 docs → flush + explicit GCP sync, asserts the same invariants as
        ensureGreen(INDEX_NAME);  
            IndexShard p = getIndexShard(primaryNodeName(), INDEX_NAME);
import org.opensearch.plugins.Plugin;
 * {@link LucenePlugin}, with failover triggered by {@link CancelAllocationCommand} so both  
import org.opensearch.indices.replication.common.ReplicationType;  
    private static final String INDEX_NAME = "composite-failover-idx";
import java.util.Collection;
        BulkResponse bulk = client().prepareBulk().add(client().prepareIndex(INDEX_NAME).setSource("field", value)).get();
 * <p>Cluster: 2 data nodes, 1 shard, 1 replica, segment replication, remote-store-backed.  
    private String replicaNodeName() {
            assert p.isActive() : "Primary is not active";  
import org.opensearch.test.InternalSettingsPlugin;
 *
    }
        BulkItemResponse doc1 = indexOne("1", "value-1");  
            .index(INDEX_NAME)  
        return Settings.builder()  
 * The OpenSearch Contributors require contributions made to  
            .build();
        client().admin().indices().prepareRefresh(INDEX_NAME).get();  
    private BulkItemResponse indexOne(String id, String value) {  
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)  
    private Settings dfaIndexSettings() {  
        return Stream.concat(  
            .put("index.pluggable.dataformat.enabled", true)
        client().admin().indices().prepareFlush(INDEX_NAME).get();
    }  
    }  
        // reroute. Both nodes stay alive, the replica is promoted, and we avoid tearing down
        }, timeout.seconds(), TimeUnit.SECONDS);  
            .put(remoteStoreIndexSettings(1, 1))
        return Settings.builder()
        BulkItemResponse doc2 = indexOne("2", "value-2");
            .orElseThrow()  
        String nodeId = getClusterState().routingTable()
import java.util.stream.Stream;
import org.opensearch.common.settings.Settings;
}
        getIndexShard(primaryNodeName(), INDEX_NAME).maybeSyncGlobalCheckpoint("post-failover-test-sync");
    public void testCheckpointsConvergeAfterPrimaryFailover() throws Exception {
            .replicaShards()
            // Tighten the periodic GCP sync so the post-failover assertion doesn't race a
import java.util.stream.Collectors;
    }
            assertEquals("primary processedLCP", 2L, p.getProcessedLocalCheckpoint());  
                CompositeDataFormatPlugin.class,
                ArrowBasePlugin.class,  
            assert r.isActive() : "Replica is not active";
    }
            .put("index.global_checkpoint_sync.interval", "1s")
            .shard(0)
        client().admin().cluster().prepareReroute().add(new CancelAllocationCommand(INDEX_NAME, 0, oldPrimary, true)).execute().actionGet();
            .build();  
            super.nodePlugins().stream(),
            .findFirst()
public class CompositeEnginePrimaryFailoverCheckpointIT extends RemoteStoreBaseIntegTestCase {  
    }
        ).collect(Collectors.toList());
    @Override
import org.opensearch.cluster.metadata.IndexMetadata;  
