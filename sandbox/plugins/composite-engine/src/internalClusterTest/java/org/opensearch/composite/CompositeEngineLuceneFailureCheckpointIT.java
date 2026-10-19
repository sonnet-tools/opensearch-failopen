import org.opensearch.index.shard.IndexShard;
            .put("index.pluggable.dataformat", "composite")
        return Stream.concat(
                DataFusionPlugin.class,  
        FailableLuceneDataFormatPlugin.clearFailure();
import org.opensearch.be.datafusion.DataFusionPlugin;
        assertEquals(1, bulk.getItems().length);
    }  
            .put("index.pluggable.dataformat.enabled", true)  
    }  
import java.util.stream.Collectors;
            .orElseThrow()
 * and the replica's processed LCP catches up.
            .index(INDEX_NAME)
    private String primaryNodeName() {
                InternalSettingsPlugin.class
            .stream()
package org.opensearch.composite;
        BulkItemResponse doc2 = indexOne("2", "value-2");  
        assertFalse("doc 2 must ultimately succeed via failover retry: " + doc2.getFailureMessage(), doc2.isFailed());
        // to the replica, and the bulk client retries doc 2 on the new primary.
        FailableLuceneDataFormatPlugin.clearFailure();
            .put(remoteStoreIndexSettings(1, 1))
        // 30s) — the new primary's lastKnownGCP has advanced past what it propagated to the
        return Settings.builder()  
 * compatible open source license.
            // Tighten the periodic GCP sync so the post-failover assertion doesn't race a
        FailableLuceneDataFormatPlugin.clearFailure();
                CompositeDataFormatPlugin.class,
import org.opensearch.test.InternalSettingsPlugin;
/**
import java.util.stream.Stream;
    public void tearDown() throws Exception {  
        FailableLuceneDataFormatPlugin.failOnNthWrite(0);
    }  
        internalCluster().startClusterManagerOnlyNode();
        assertBusy(() -> {  
        client().admin().indices().prepareFlush(INDEX_NAME).get();
            .shard(0)  
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(dfaIndexSettings()).get();
        assertFalse("doc 3 must succeed: " + doc3.getFailureMessage(), doc3.isFailed());  
            // 30s default timer waiting for the replica to catch up.
        // Arm a Directory write fault on the next op. Lucene's flush triggered by doc 2's
        super.setUp();
import java.util.concurrent.TimeUnit;  
/*  
        // Force the GCP sync immediately instead of waiting for the periodic timer (default
    public void testCheckpointsConvergeAfterLuceneDirectoryFault() throws Exception {
 * primary, the replica is promoted, and the bulk client retries the failed doc on the new
 * Verifies seqNo / checkpoint correctness on the composite engine when a Lucene secondary
import org.opensearch.arrow.allocator.ArrowBasePlugin;  
            .build();
            )
            .currentNodeId();  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
 * primary.  
        assertFalse("doc 1 must succeed: " + doc1.getFailureMessage(), doc1.isFailed());  
public class CompositeEngineLuceneFailureCheckpointIT extends RemoteStoreBaseIntegTestCase {
    private Settings dfaIndexSettings() {
        ensureGreen(INDEX_NAME);  
 * The OpenSearch Contributors require contributions made to  
        String nodeId = getClusterState().routingTable()
            .putList("index.composite.secondary_data_formats", List.of("lucene"))  
        BulkResponse bulk = client().prepareBulk().add(client().prepareIndex(INDEX_NAME).setSource("field", value)).get();  
            .build();
 *
 */  
 * is a tragic event: IndexWriter self-closes, DFAE fails the engine, the cluster fails the
        // replica during failover and we want the replica to catch up before assertions.  
        getIndexShard(primaryNodeName(), INDEX_NAME).maybeSyncGlobalCheckpoint("post-failover-test-sync");
import org.opensearch.indices.replication.common.ReplicationType;  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        return bulk.getItems()[0];
    }
        // addDoc hits the fault, IndexWriter goes tragic, engine fails, primary fails over  
 * write hits a {@link org.apache.lucene.store.Directory}-level I/O fault. The IOException  
    @Override  
    }
            IndexShard p = getIndexShard(primaryNodeName(), INDEX_NAME);
        super.tearDown();
import org.opensearch.parquet.ParquetDataFormatPlugin;
        ).collect(Collectors.toList());  
    private String replicaNodeName() {  
            assertEquals("primary persistedLCP", 2L, p.getLocalCheckpoint());
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
}
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        internalCluster().startDataOnlyNodes(2);  
            super.nodePlugins().stream(),  
 * sync, primary {@code maxSeqNo}, processed/persisted LCP, and lastSyncedGCP converge to 2
        BulkItemResponse doc1 = indexOne("1", "value-1");
    protected Settings nodeSettings(int nodeOrdinal) {
 * this file be licensed under the Apache-2.0 license or a
    @Override  
        return Settings.builder()
    }  
        return getClusterState().nodes().get(nodeId).getName();  
 * <p>Cluster: 2 data nodes, 1 shard, 1 replica, segment replication, remote-store-backed,
            .put(super.nodeSettings(nodeOrdinal))  
 */  
 * SPDX-License-Identifier: Apache-2.0
        return getClusterState().nodes().get(nodeId).getName();
    }
import org.opensearch.common.settings.Settings;  
import java.util.Collection;
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;  
import org.opensearch.cluster.metadata.IndexMetadata;
        BulkItemResponse doc3 = indexOne("3", "value-3");
            .replicaShards()
 *
    private static final String INDEX_NAME = "composite-lucene-failure-idx";
import org.opensearch.action.bulk.BulkItemResponse;
import org.opensearch.plugins.Plugin;
            .findFirst()
 * with Lucene wrapped by {@link FailableLuceneDataFormatPlugin}. After flush + explicit GCP  
        ensureYellowAndNoInitializingShards(INDEX_NAME);
            assertEquals("replica lastProcessedLCP matches primary", p.getProcessedLocalCheckpoint(), r.getProcessedLocalCheckpoint());
    }
            Stream.of(
            .put("index.composite.primary_data_format", "parquet")
import org.opensearch.common.util.FeatureFlags;
    }  
                FailableLuceneDataFormatPlugin.class,
    @Override
                ArrowBasePlugin.class,
import org.opensearch.test.OpenSearchIntegTestCase;
            assertEquals("primary processedLCP", 2L, p.getProcessedLocalCheckpoint());
            assertEquals("primary lastSyncedGCP catches up to LCP", p.getLocalCheckpoint(), p.getLastSyncedGlobalCheckpoint());  
                ParquetDataFormatPlugin.class,  
    private BulkItemResponse indexOne(String id, String value) {
    @Override
        }, 30, TimeUnit.SECONDS);
            .put("index.global_checkpoint_sync.interval", "1s")  
            IndexShard r = getIndexShard(replicaNodeName(), INDEX_NAME);
import java.util.List;
        ensureGreen(INDEX_NAME);  
        client().admin().indices().prepareRefresh(INDEX_NAME).get();  
    public void setUp() throws Exception {  
            .filter(s -> s.started())  
        String nodeId = getClusterState().routingTable().index(INDEX_NAME).shard(0).primaryShard().currentNodeId();
import org.opensearch.action.bulk.BulkResponse;
            assertEquals("primary maxSeqNo", 2L, p.seqNoStats().getMaxSeqNo());  
