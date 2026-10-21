import org.opensearch.action.bulk.BulkResponse;
        assertBusy(() -> {
        assertBusy(() -> {
                InternalSettingsPlugin.class
import java.util.stream.Stream;
import org.opensearch.indices.replication.common.ReplicationType;
import org.opensearch.common.util.FeatureFlags;
            .put("index.composite.primary_data_format", "parquet")
            .put(super.nodeSettings(nodeOrdinal))
        BulkResponse bulk = client().prepareBulk().add(client().prepareIndex(INDEX_NAME).setSource("field", value)).get();
            .put("index.pluggable.dataformat.enabled", true)
    protected Settings nodeSettings(int nodeOrdinal) {
public class CompositeEnginePrimaryFailoverCheckpointIT extends RemoteStoreBaseIntegTestCase {
        assertFalse("doc 3 must succeed: " + doc3.getFailureMessage(), doc3.isFailed());
        String nodeId = getClusterState().routingTable()
                DataFusionPlugin.class,
        client().admin().cluster().prepareReroute().add(new CancelAllocationCommand(INDEX_NAME, 0, oldPrimary, true)).execute().actionGet();
                ArrowBasePlugin.class,
    protected Collection<Class<? extends Plugin>> nodePlugins() {
import java.util.Collection;
import org.opensearch.arrow.allocator.ArrowBasePlugin;
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
 * SPDX-License-Identifier: Apache-2.0
 * {@link LucenePlugin}, with failover triggered by {@link CancelAllocationCommand} so both
import org.opensearch.be.lucene.LucenePlugin;
    /** Waits until the primary's operationPrimaryTerm reaches {@code expectedTerm}. */
import org.opensearch.common.settings.Settings;
        return Settings.builder()
    }
            super.nodePlugins().stream(),
        ensureYellowAndNoInitializingShards(INDEX_NAME);
    private String primaryNodeName() {
    }
        return getClusterState().nodes().get(nodeId).getName();
    private static final String INDEX_NAME = "composite-failover-idx";
            assertEquals("primary processedLCP", 2L, p.getProcessedLocalCheckpoint());
        BulkItemResponse doc1 = indexOne("1", "value-1");
        BulkItemResponse doc2 = indexOne("2", "value-2");
        }, timeout.seconds(), TimeUnit.SECONDS);
        assertEquals(1, bulk.getItems().length);
    private BulkItemResponse indexOne(String id, String value) {
    }
import org.opensearch.index.shard.IndexShard;
import org.opensearch.parquet.ParquetDataFormatPlugin;
                ParquetDataFormatPlugin.class,
    }
    public void testCheckpointsConvergeAfterPrimaryFailover() throws Exception {
            assert p.isActive() : "Primary is not active";
            IndexShard r = getIndexShard(replicaNodeName(), INDEX_NAME);
 */
    @Override
        // Trigger a graceful primary handover: cancel the primary's allocation via cluster
            .currentNodeId();
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(dfaIndexSettings()).get();
 * After cancel-reroute → 3 docs → flush + explicit GCP sync, asserts the same invariants as
import org.opensearch.test.OpenSearchIntegTestCase;
    }
        return Settings.builder()
        String oldPrimary = primaryNodeName();
        client().admin().indices().prepareFlush(INDEX_NAME).get();
    private void waitForPrimaryTerm(long expectedTerm, TimeValue timeout) throws Exception {
}
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        ensureGreen(INDEX_NAME);
 * nodes stay alive and the node-scoped DataFusion runtime survives.
        BulkItemResponse doc3 = indexOne("3", "value-3");
import org.opensearch.test.InternalSettingsPlugin;
 * compatible open source license.
            .replicaShards()
import org.opensearch.cluster.routing.allocation.command.CancelAllocationCommand;
    }
 * the fault-injection variant: primary maxSeqNo, processed/persisted LCP, and lastSyncedGCP
                CompositeDataFormatPlugin.class,
            .findFirst()
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
import org.opensearch.action.bulk.BulkItemResponse;
            .put("index.pluggable.dataformat", "composite")
            .shard(0)
    private Settings dfaIndexSettings() {
            .put(remoteStoreIndexSettings(1, 1))
        }, 30, TimeUnit.SECONDS);
            // Tighten the periodic GCP sync so the post-failover assertion doesn't race a
            .build();
    private String replicaNodeName() {
import java.util.List;
            assert r.isActive() : "Replica is not active";
        // reroute. Both nodes stay alive, the replica is promoted, and we avoid tearing down
    }
        ).collect(Collectors.toList());
import org.opensearch.cluster.metadata.IndexMetadata;
        // the node-scoped DataFusion Tokio runtime manager (which dies on hard node stop).
/**
import java.util.stream.Collectors;
        ensureGreen(INDEX_NAME);
            // 30s default timer waiting for the replica to catch up.
            .putList("index.composite.secondary_data_formats", List.of("lucene"))
            assertEquals("primary term did not reach expected value", expectedTerm, shard.getOperationPrimaryTerm());
    @Override
import org.opensearch.common.unit.TimeValue;
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
            assertEquals("primary maxSeqNo", 2L, p.seqNoStats().getMaxSeqNo());
 */
    }
package org.opensearch.composite;
        internalCluster().startClusterManagerOnlyNode();
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
import org.opensearch.plugins.Plugin;
 * this file be licensed under the Apache-2.0 license or a
        return getClusterState().nodes().get(nodeId).getName();
            )
        waitForPrimaryTerm(2L, TimeValue.timeValueSeconds(30));
 * Control variant of {@link CompositeEngineLuceneFailureCheckpointIT}: unmodified
 * converge to 2 and the replica's processed LCP catches up.
 *
            .index(INDEX_NAME)
            Stream.of(
            .orElseThrow()
 * The OpenSearch Contributors require contributions made to
        assertFalse("doc 1 must succeed: " + doc1.getFailureMessage(), doc1.isFailed());
            .filter(s -> s.started())
        return Stream.concat(
 *
            IndexShard shard = getIndexShard(primaryNodeName(), INDEX_NAME);
            .stream()
                LucenePlugin.class,
            .put("index.global_checkpoint_sync.interval", "1s")
        return bulk.getItems()[0];
import org.opensearch.be.datafusion.DataFusionPlugin;
        String nodeId = getClusterState().routingTable().index(INDEX_NAME).shard(0).primaryShard().currentNodeId();
            assertEquals("replica lastProcessedLCP matches primary", p.getProcessedLocalCheckpoint(), r.getProcessedLocalCheckpoint());
        internalCluster().startDataOnlyNodes(2);
            assertEquals("primary lastSyncedGCP catches up to LCP", p.getLocalCheckpoint(), p.getLastSyncedGlobalCheckpoint());
            assertEquals("primary persistedLCP", 2L, p.getLocalCheckpoint());
/*
        getIndexShard(primaryNodeName(), INDEX_NAME).maybeSyncGlobalCheckpoint("post-failover-test-sync");
        assertFalse("doc 2 must succeed on new primary: " + doc2.getFailureMessage(), doc2.isFailed());
        logger.info("Current Allocation: {}", getClusterState().routingTable().index(INDEX_NAME));
            IndexShard p = getIndexShard(primaryNodeName(), INDEX_NAME);
import java.util.concurrent.TimeUnit;
 * <p>Cluster: 2 data nodes, 1 shard, 1 replica, segment replication, remote-store-backed.
            .build();
