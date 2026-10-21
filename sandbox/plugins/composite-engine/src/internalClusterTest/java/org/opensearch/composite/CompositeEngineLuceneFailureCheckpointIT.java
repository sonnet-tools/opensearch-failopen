import java.util.stream.Collectors;
                DataFusionPlugin.class,
        // to the replica, and the bulk client retries doc 2 on the new primary.
/*
 */
        assertFalse("doc 1 must succeed: " + doc1.getFailureMessage(), doc1.isFailed());
                InternalSettingsPlugin.class
import org.opensearch.common.util.FeatureFlags;
        internalCluster().startDataOnlyNodes(2);
import org.opensearch.common.settings.Settings;
            .put("index.global_checkpoint_sync.interval", "1s")
            IndexShard p = getIndexShard(primaryNodeName(), INDEX_NAME);
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(dfaIndexSettings()).get();
        assertBusy(() -> {
import org.opensearch.parquet.ParquetDataFormatPlugin;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.bulk.BulkItemResponse;
    private String replicaNodeName() {
        ensureGreen(INDEX_NAME);
import java.util.stream.Stream;
        client().admin().indices().prepareFlush(INDEX_NAME).get();
    }
            assertEquals("primary persistedLCP", 2L, p.getLocalCheckpoint());
            .build();
            .stream()
    public void testCheckpointsConvergeAfterLuceneDirectoryFault() throws Exception {
        BulkItemResponse doc2 = indexOne("2", "value-2");
        return Settings.builder()
            .shard(0)
    private BulkItemResponse indexOne(String id, String value) {
 * is a tragic event: IndexWriter self-closes, DFAE fails the engine, the cluster fails the
import org.opensearch.arrow.allocator.ArrowBasePlugin;
 * The OpenSearch Contributors require contributions made to
                ArrowBasePlugin.class,
            .replicaShards()
    }
    private Settings dfaIndexSettings() {
    }
        super.tearDown();
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
        FailableLuceneDataFormatPlugin.clearFailure();
 * sync, primary {@code maxSeqNo}, processed/persisted LCP, and lastSyncedGCP converge to 2
            .putList("index.composite.secondary_data_formats", List.of("lucene"))
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
            .build();
import org.opensearch.indices.replication.common.ReplicationType;
 * Verifies seqNo / checkpoint correctness on the composite engine when a Lucene secondary
    }
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    private String primaryNodeName() {
 * <p>Cluster: 2 data nodes, 1 shard, 1 replica, segment replication, remote-store-backed,
 * and the replica's processed LCP catches up.
 *
        return bulk.getItems()[0];
            // Tighten the periodic GCP sync so the post-failover assertion doesn't race a
        String nodeId = getClusterState().routingTable().index(INDEX_NAME).shard(0).primaryShard().currentNodeId();
    public void tearDown() throws Exception {
 * primary.
 */
    protected Settings nodeSettings(int nodeOrdinal) {
    public void setUp() throws Exception {
        FailableLuceneDataFormatPlugin.clearFailure();
        getIndexShard(primaryNodeName(), INDEX_NAME).maybeSyncGlobalCheckpoint("post-failover-test-sync");
        }, 30, TimeUnit.SECONDS);
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
import org.opensearch.action.bulk.BulkResponse;
            .put("index.pluggable.dataformat.enabled", true)
                ParquetDataFormatPlugin.class,
        ).collect(Collectors.toList());
        return Settings.builder()
    @Override
            .put(remoteStoreIndexSettings(1, 1))
/**
import java.util.List;
        return Stream.concat(
            assertEquals("primary maxSeqNo", 2L, p.seqNoStats().getMaxSeqNo());
 * SPDX-License-Identifier: Apache-2.0
        ensureGreen(INDEX_NAME);
    }
        BulkItemResponse doc3 = indexOne("3", "value-3");
            .orElseThrow()
        BulkResponse bulk = client().prepareBulk().add(client().prepareIndex(INDEX_NAME).setSource("field", value)).get();
        return getClusterState().nodes().get(nodeId).getName();
 * primary, the replica is promoted, and the bulk client retries the failed doc on the new
        FailableLuceneDataFormatPlugin.clearFailure();
        // replica during failover and we want the replica to catch up before assertions.
            assertEquals("replica lastProcessedLCP matches primary", p.getProcessedLocalCheckpoint(), r.getProcessedLocalCheckpoint());
 * write hits a {@link org.apache.lucene.store.Directory}-level I/O fault. The IOException
                FailableLuceneDataFormatPlugin.class,
        BulkItemResponse doc1 = indexOne("1", "value-1");
            .index(INDEX_NAME)
        ensureYellowAndNoInitializingShards(INDEX_NAME);
    private static final String INDEX_NAME = "composite-lucene-failure-idx";
import org.opensearch.test.OpenSearchIntegTestCase;
public class CompositeEngineLuceneFailureCheckpointIT extends RemoteStoreBaseIntegTestCase {
    @Override
            assertEquals("primary processedLCP", 2L, p.getProcessedLocalCheckpoint());
}
 * with Lucene wrapped by {@link FailableLuceneDataFormatPlugin}. After flush + explicit GCP
        internalCluster().startClusterManagerOnlyNode();
        // 30s) — the new primary's lastKnownGCP has advanced past what it propagated to the
            .findFirst()
    @Override
import java.util.concurrent.TimeUnit;
import org.opensearch.index.shard.IndexShard;
        assertFalse("doc 3 must succeed: " + doc3.getFailureMessage(), doc3.isFailed());
        FailableLuceneDataFormatPlugin.failOnNthWrite(0);
            .put("index.pluggable.dataformat", "composite")
import org.opensearch.cluster.metadata.IndexMetadata;
        return getClusterState().nodes().get(nodeId).getName();
            )
            super.nodePlugins().stream(),
            .put("index.composite.primary_data_format", "parquet")
            assertEquals("primary lastSyncedGCP catches up to LCP", p.getLocalCheckpoint(), p.getLastSyncedGlobalCheckpoint());
            .filter(s -> s.started())
 *
    }
        // Force the GCP sync immediately instead of waiting for the periodic timer (default
    @Override
    }
    }
        super.setUp();
        assertFalse("doc 2 must ultimately succeed via failover retry: " + doc2.getFailureMessage(), doc2.isFailed());
            .currentNodeId();
    }
import org.opensearch.plugins.Plugin;
        assertEquals(1, bulk.getItems().length);
import org.opensearch.be.datafusion.DataFusionPlugin;
            IndexShard r = getIndexShard(replicaNodeName(), INDEX_NAME);
            .put(super.nodeSettings(nodeOrdinal))
        // addDoc hits the fault, IndexWriter goes tragic, engine fails, primary fails over
import org.opensearch.test.InternalSettingsPlugin;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
import java.util.Collection;
        String nodeId = getClusterState().routingTable()
            // 30s default timer waiting for the replica to catch up.
package org.opensearch.composite;
            Stream.of(
        // Arm a Directory write fault on the next op. Lucene's flush triggered by doc 2's
                CompositeDataFormatPlugin.class,
 * compatible open source license.
