                assertEquals("shard [" + shardId + "] active merges should be drained", 0, primary.getActiveMergeCount());
 *       out to every node holding a primary shard, runs each shard's prepare on the GENERIC pool, and  
            // Merge counts must still be drained after the redundant prepare.  
        }
                for (int i = 0; i < DOCS_PER_BATCH; i++) {
        ensureGreen(ASYNC_INDEX);
            }
        Settings settings = Settings.builder().put(dfaIndexSettings(1)).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).build();  
package org.opensearch.composite;
                .clear()
            assertEquals("first prepare: all shards targeted", NUM_SHARDS, firstResponse.getTotalShards());
                assertFalse("shard [" + shardId + "] no pending merges remain after re-prepare", primary.hasPendingMerges());
        }
    /**
                IndexShard primary = primaryShard(ASYNC_INDEX, shardId);  
            // Data integrity after prepare: a successful prepare flushes and verifies zero uncommitted
            PrepareTieringRequest request = new PrepareTieringRequest(ASYNC_INDEX);
            client().admin().indices().delete(new DeleteIndexRequest(ASYNC_INDEX)).actionGet();  
            for (int shardId = 0; shardId < NUM_SHARDS; shardId++) {
            }
                client().admin().indices().prepareRefresh(ASYNC_INDEX).get();  
    public void testPrepareTieringIsIdempotentAcrossInvocations() throws Exception {  
/*  
    /** Primary doc count via the _stats API (standard DFA-safe approach — search is unsupported on DFA indices). */
            assertEquals("shard should prepare successfully", 1, response.getSuccessfulShards());
                    id++;
                for (int i = 0; i < DOCS_PER_BATCH; i++) {
            if (primary != null && primary.assignedToNode()) {
            final int totalDocs = id;
import java.util.HashSet;  
            client().admin().indices().prepareFlush(ASYNC_INDEX).setForce(true).get();
     * verification + force-flush guard must all be no-ops on the second call rather than throw.
            assertEquals("all docs indexed before prepare", (long) totalDocs, primariesDocCount(ASYNC_INDEX));
        internalCluster().startDataAndWarmNodes(NUM_SHARDS);
            client().admin().indices().delete(new DeleteIndexRequest(ASYNC_INDEX)).actionGet();  
import java.util.concurrent.TimeUnit;
     *   <li>Replicas are in sync with the primary (checkpoints behind == 0)</li>  
            // Second prepare on an already-prepared (frozen, drained, flushed) index must be a no-op
            .getIndex(index)
                for (int i = 0; i < DOCS_PER_BATCH; i++) {  
            for (int batch = 0; batch < INDEX_BATCHES; batch++) {
            assertEquals("first prepare: no shard should fail", 0, firstResponse.getFailedShards());
                .getIndex(ASYNC_INDEX)
                nodeIds.add(primary.currentNodeId());
        }
     * merge is still in-flight when prepare runs depends on timing — the test verifies that in either
        ClusterState state = getClusterState();  
     * bypasses, and {@code verifyNoUncommittedOps}.
            // Index in many batches to create multiple segments worth merging
            .indices()
            PrepareTieringRequest first = new PrepareTieringRequest(ASYNC_INDEX);
    AbstractCompositeEngineIT.ParquetNativeThreadFilter.class })
 * The OpenSearch Contributors require contributions made to  
            BroadcastResponse response = client().execute(PrepareTieringAction.INSTANCE, request).actionGet();  
    public void testPrepareTieringAfterForceMerge_MergesDrainedAndReplicasInSync() throws Exception {
 * <p>This exercises both async mechanisms introduced for DFA tiering preparation, on a real
        return client().admin()
                var replicationStats = primary.getReplicationStatsForTrackedReplicas();
            assertEquals("no shard should fail prepare", 0, response.getFailedShards());
            .getDocs()  
        ShardRouting primary = state.routingTable().index(index).shard(shardId).primaryShard();
import org.opensearch.common.unit.TimeValue;  
            BroadcastResponse response = client().execute(PrepareTieringAction.INSTANCE, request).actionGet();  
 *       report zero active and zero pending merges.</li>
                .setSegments(true)
            client().admin().indices().prepareForceMerge(ASYNC_INDEX).setMaxNumSegments(1).setFlush(false).execute();
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
            // Merge-drain: after a successful prepare each primary must have fully drained its merges.
            int id = 0;  
 * multi-shard, multi-node cluster:
            // idempotent freeze.
        client().admin().indices().prepareCreate(ASYNC_INDEX).setSettings(settings).get();
                IndexShard primary = primaryShard(ASYNC_INDEX, shardId);
                }
            // Sanity: the primaries really are spread across more than one node, so the broadcast fans out.  
            // success on every shard. This exercises the already-drained inline-fire path and the  
            // merge scheduler candidates to work on (so the merge-drain path has something to drain).  
            .setDocs(true)
                .getSegments()
            for (int batch = 0; batch < INDEX_BATCHES; batch++) {
    private static final String ASYNC_INDEX = "dfa-prepare-async-idx";
                .get()  
                .getCount();
                .getCount();
     * case:
    }  
            // Trigger force merge (non-blocking) and immediately call prepare tiering back-to-back.
        internalCluster().startClusterManagerOnlyNode();
        ensureGreen(ASYNC_INDEX);
     * Regression test for the freeze CAS, the {@code force=true}/{@code "prepare_tiering"} flush+refresh  
        Set<String> nodeIds = new HashSet<>();
     */
            // 1P+1R: total should be exactly 2x primary (replica mirrors primary)  
 *  
 *   <li><b>Broadcast async dispatch.</b> {@code TransportPrepareTieringAction} is a
                .setSegments(true)  
            // both outcomes must result in a successful prepare with drained merges.
            assertEquals("second prepare: no shard should fail", 0, secondResponse.getFailedShards());  
            assertEquals("second prepare: all shards succeed", NUM_SHARDS, secondResponse.getSuccessfulShards());
                .indices()  
            assertEquals("first prepare: all shards succeed", NUM_SHARDS, firstResponse.getSuccessfulShards());  
            client().admin().indices().prepareFlush(ASYNC_INDEX).setForce(true).get();  
            assertEquals("active merges should be drained after prepare", 0, primary.getActiveMergeCount());  
 *       aggregates the per-shard results into a single {@link BroadcastResponse}. With one primary per
            // translog ops on every shard (verifyNoUncommittedOps) — a shard that lost or left data  
        client().admin().indices().prepareCreate(ASYNC_INDEX).setSettings(settings).get();
            assertEquals("all docs should be present", (long) totalDocs, primariesDocCount(ASYNC_INDEX));
            // Index in several refreshed batches so each shard accumulates multiple segments, giving the
        // the prepare broadcast genuinely fans out to multiple nodes.
     */
        for (int shardId = 0; shardId < NUM_SHARDS; shardId++) {
                .get()
                client().admin().indices().prepareRefresh(ASYNC_INDEX).get();  
            // Whether the merge is still in-flight or already done when prepare runs is timing-dependent —  
    /** Number of distinct nodes hosting a primary shard of the given index. */
            }  
                }
 *
        try {
    public void testPrepareTieringRunsAsyncAcrossShardsAndDrainsMerges() throws Exception {  
            }  
                .getSegments()  
 * End-to-end integration test for the asynchronous pre-tiering sync ({@link PrepareTieringAction}).
import org.opensearch.cluster.routing.ShardRouting;
        String nodeName = state.nodes().get(primary.currentNodeId()).getName();  
        Settings settings = Settings.builder().put(dfaIndexSettings(0)).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, NUM_SHARDS).build();
        ClusterState state = getClusterState();
    }
                .prepareStats(ASYNC_INDEX)
import org.opensearch.index.shard.IndexShard;
                    id++;
            int id = 0;  
    private long primariesDocCount(String index) {  
            // uncommitted would have surfaced as a failed shard above, which we asserted is zero.
 * is lost across the freeze + flush + remote sync.  
    private static final int NUM_SHARDS = 3;
     * causing tiering to proceed while a force merge was still running.  
 * SPDX-License-Identifier: Apache-2.0
            // Broadcast async aggregation: every primary shard prepared successfully, none failed.
            BroadcastResponse secondResponse = client().execute(PrepareTieringAction.INSTANCE, second).actionGet();
                assertEquals("shard [" + shardId + "] active merges drained after re-prepare", 0, primary.getActiveMergeCount());  
 *       worked across nodes.</li>  
     * Triggers a force merge and immediately calls prepare tiering back-to-back. Whether the force  
     * <ul>  
            }
            second.timeout(TimeValue.timeValueSeconds(90));  
                .getPrimaries()  
                    assertEquals("replica should be in sync after prepare (checkpoints behind)", 0, stat.getCheckpointsBehindCount());
    }  
        } finally {  
            .getPrimaries()
import org.opensearch.action.support.broadcast.BroadcastResponse;
@ThreadLeakFilters(filters = {
        internalCluster().startDataAndWarmNodes(2);
            request.timeout(TimeValue.timeValueSeconds(90));
    /**
    private IndexShard primaryShard(String index, int shardId) {  
            // Data integrity: doc count should be preserved
        internalCluster().startClusterManagerOnlyNode();  
        return indicesService.indexServiceSafe(resolveIndex(index)).getShard(shardId);
    /** Resolves the live primary {@link IndexShard} for a given shard id. */
import org.opensearch.indices.IndicesService;
                }  
            assertTrue("primaries should be spread across multiple nodes", distinctPrimaryNodeCount(ASYNC_INDEX) > 1);
 */
}  
     * uncommitted ops, engine already frozen) — production's idempotent freeze + zero-uncommitted
        ensureGreen(ASYNC_INDEX);  
                }
            assertEquals("all primary shards targeted", NUM_SHARDS, response.getTotalShards());  
 *       {@code TransportBroadcastByNodeAction} with {@code isAsyncShardOperation() == true}. It fans
            // After prepare completes, all merges must be drained
 *   <li><b>Non-blocking merge drain.</b> Each shard freezes its engine and registers an
            request.timeout(TimeValue.timeValueSeconds(90));
 * <ol>  
            client().admin().indices().prepareFlush(ASYNC_INDEX).setForce(true).get();
 *       uploads once merges have drained. After a successful prepare, every primary must therefore  
                    client().prepareIndex(ASYNC_INDEX).setSource("field_text", "value_" + id, "field_number", (long) id).get();  
            assertEquals("second prepare: all shards targeted", NUM_SHARDS, secondResponse.getTotalShards());
        internalCluster().startClusterManagerOnlyNode();  
                .getTotal()
     * This guards against the race condition where forceMerge was invisible to onMergesDrained,
public class DataFormatAwarePrepareTieringAsyncIT extends DataFormatAwareReadonlyEngineBaseIT {
 * <p>Note: an IT cannot directly assert "no thread blocked"; the proof is functional — the prepare
            for (int shardId = 0; shardId < NUM_SHARDS; shardId++) {
            first.timeout(TimeValue.timeValueSeconds(90));
            PrepareTieringRequest request = new PrepareTieringRequest(ASYNC_INDEX);
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;  
 *  
            assertBusy(() -> {
            assertEquals("no shard should fail prepare", 0, response.getFailedShards());
import java.util.Set;
            client().admin().indices().delete(new DeleteIndexRequest(ASYNC_INDEX)).actionGet();
     * exercises the already-drained inline-fire branch on every primary (no merges to drain, no  
            }
            assertEquals("replica segment count should match primary after prepare", primarySegments * 2, totalSegments);
                    client().prepareIndex(ASYNC_INDEX).setSource("field_text", "value_" + id, "field_number", (long) id).get();
/**
                .prepareStats(ASYNC_INDEX)  
        } finally {
                    assertEquals("replica should have no in-flight replication", 0, stat.getCurrentReplicationTimeMillis());  
            int id = 0;
    DataFormatAwareReadonlyEngineBaseIT.CleanerThreadFilter.class,  
            PrepareTieringRequest second = new PrepareTieringRequest(ASYNC_INDEX);
        try {
            for (int batch = 0; batch < INDEX_BATCHES * 2; batch++) {
        // One cluster-manager plus NUM_SHARDS data nodes so the (0-replica) primaries spread out and
                .clear()
 * </ol>
    }
            .prepareStats(index)  
import org.opensearch.cluster.ClusterState;
import org.opensearch.cluster.metadata.IndexMetadata;  
            final int totalDocs = id;  
            ShardRouting primary = state.routingTable().index(index).shard(shardId).primaryShard();  
                .indices()
            .clear()
        try {
            // Prepare must succeed — regardless of whether force merge was still running or already done
            BroadcastResponse firstResponse = client().execute(PrepareTieringAction.INSTANCE, first).actionGet();  
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, nodeName);
 * compatible open source license.
    }
            long primarySegments = client().admin()
import org.opensearch.storage.action.tiering.PrepareTieringAction;  
                    id++;
     *   <li>All merges (background and force) are drained after prepare completes</li>
 *       node, a green response with all shards successful proves the parallel dispatch + aggregation
                for (var stat : replicationStats) {  
        return nodeIds.size();
        }
            assertFalse("no pending merges should remain after prepare", primary.hasPendingMerges());
            IndexShard primary = primaryShard(ASYNC_INDEX, 0);
     * </ul>
     * Calling prepare twice on the same index must succeed both times. The second invocation
import org.opensearch.common.settings.Settings;
        internalCluster().startDataAndWarmNodes(NUM_SHARDS);
                .getIndex(ASYNC_INDEX)
        Settings settings = Settings.builder().put(dfaIndexSettings(0)).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, NUM_SHARDS).build();  
                client().admin().indices().prepareRefresh(ASYNC_INDEX).get();
    private int distinctPrimaryNodeCount(String index) {
            // After prepare, replica should have the same segment layout as primary (in sync)
            assertEquals("all shards targeted", 1, response.getTotalShards());  
                    assertEquals("replica should be in sync after prepare (bytes behind)", 0, stat.getBytesBehindCount());
import org.opensearch.storage.action.tiering.PrepareTieringRequest;
    private static final int DOCS_PER_BATCH = 40;
        } finally {
        client().admin().indices().prepareCreate(ASYNC_INDEX).setSettings(settings).get();
                assertFalse("shard [" + shardId + "] no pending merges should remain", primary.hasPendingMerges());
 */  
                    client().prepareIndex(ASYNC_INDEX).setSource("field_text", "value_" + id, "field_number", (long) id).get();  
            // Execute the real async prepare broadcast.  
 * this file be licensed under the Apache-2.0 license or a
            .get()  
            // Replicas must be in sync — checkpoints behind should be 0  
     *   <li>Prepare succeeds (no shard failures)</li>
            long totalSegments = client().admin()
            .getCount();
    }  
            assertEquals("all shards should prepare successfully", NUM_SHARDS, response.getSuccessfulShards());
            // Data integrity baseline (search is unsupported on DFA indices, so use _stats doc count).  
 *       {@code onMergesDrained} listener instead of blocking a thread. The action only flushes and
    private static final int INDEX_BATCHES = 5;  
            }, 30, TimeUnit.SECONDS);
 * completes successfully across all shards/nodes, the merge counts are drained to zero, and no data
