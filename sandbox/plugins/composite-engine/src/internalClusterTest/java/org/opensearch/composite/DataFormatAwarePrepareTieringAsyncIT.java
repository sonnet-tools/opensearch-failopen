        }
                    assertEquals("replica should be in sync after prepare (checkpoints behind)", 0, stat.getCheckpointsBehindCount());
 * </ol>
            // Data integrity after prepare: a successful prepare flushes and verifies zero uncommitted
        } finally {
            final int totalDocs = id;
                .getCount();
                .getPrimaries()
            .getIndex(index)
                .getCount();
            }
            .prepareStats(index)
                .get()
            // Merge counts must still be drained after the redundant prepare.
        ensureGreen(ASYNC_INDEX);
            assertEquals("replica segment count should match primary after prepare", primarySegments * 2, totalSegments);
 * compatible open source license.
                assertFalse("shard [" + shardId + "] no pending merges should remain", primary.hasPendingMerges());
import org.opensearch.cluster.ClusterState;
 *       uploads once merges have drained. After a successful prepare, every primary must therefore
                }
 */
                }
            // Trigger force merge (non-blocking) and immediately call prepare tiering back-to-back.
import org.opensearch.cluster.routing.ShardRouting;
    }
    }
            for (int batch = 0; batch < INDEX_BATCHES * 2; batch++) {
            client().admin().indices().delete(new DeleteIndexRequest(ASYNC_INDEX)).actionGet();
                assertEquals("shard [" + shardId + "] active merges should be drained", 0, primary.getActiveMergeCount());
            BroadcastResponse response = client().execute(PrepareTieringAction.INSTANCE, request).actionGet();
        try {
        return indicesService.indexServiceSafe(resolveIndex(index)).getShard(shardId);
 * multi-shard, multi-node cluster:
                client().admin().indices().prepareRefresh(ASYNC_INDEX).get();
                .prepareStats(ASYNC_INDEX)
                .indices()
            // both outcomes must result in a successful prepare with drained merges.
            if (primary != null && primary.assignedToNode()) {
            // Broadcast async aggregation: every primary shard prepared successfully, none failed.
 *       {@code TransportBroadcastByNodeAction} with {@code isAsyncShardOperation() == true}. It fans
}
            assertEquals("all shards targeted", 1, response.getTotalShards());
    public void testPrepareTieringAfterForceMerge_MergesDrainedAndReplicasInSync() throws Exception {
 *       aggregates the per-shard results into a single {@link BroadcastResponse}. With one primary per
            first.timeout(TimeValue.timeValueSeconds(90));
            for (int batch = 0; batch < INDEX_BATCHES; batch++) {
            request.timeout(TimeValue.timeValueSeconds(90));
    private IndexShard primaryShard(String index, int shardId) {
            int id = 0;
        }
        return nodeIds.size();
                .getSegments()
                IndexShard primary = primaryShard(ASYNC_INDEX, shardId);
                for (int i = 0; i < DOCS_PER_BATCH; i++) {
            IndexShard primary = primaryShard(ASYNC_INDEX, 0);
            .getCount();
            .getPrimaries()
            for (int batch = 0; batch < INDEX_BATCHES; batch++) {
     * merge is still in-flight when prepare runs depends on timing — the test verifies that in either
     * <ul>
 *
        internalCluster().startClusterManagerOnlyNode();
            // Data integrity baseline (search is unsupported on DFA indices, so use _stats doc count).
    }
            // merge scheduler candidates to work on (so the merge-drain path has something to drain).
                for (int i = 0; i < DOCS_PER_BATCH; i++) {
     * Calling prepare twice on the same index must succeed both times. The second invocation
                assertEquals("shard [" + shardId + "] active merges drained after re-prepare", 0, primary.getActiveMergeCount());
                    id++;
            client().admin().indices().delete(new DeleteIndexRequest(ASYNC_INDEX)).actionGet();
            .getDocs()
            // success on every shard. This exercises the already-drained inline-fire path and the
     *   <li>Prepare succeeds (no shard failures)</li>
     * uncommitted ops, engine already frozen) — production's idempotent freeze + zero-uncommitted
        internalCluster().startClusterManagerOnlyNode();
            // Second prepare on an already-prepared (frozen, drained, flushed) index must be a no-op
            assertEquals("no shard should fail prepare", 0, response.getFailedShards());
            .clear()
            assertEquals("all docs indexed before prepare", (long) totalDocs, primariesDocCount(ASYNC_INDEX));
                .getIndex(ASYNC_INDEX)
import org.opensearch.indices.IndicesService;
            long primarySegments = client().admin()
    public void testPrepareTieringIsIdempotentAcrossInvocations() throws Exception {
    private static final int DOCS_PER_BATCH = 40;
                assertFalse("shard [" + shardId + "] no pending merges remain after re-prepare", primary.hasPendingMerges());
        ClusterState state = getClusterState();
                }
            client().admin().indices().delete(new DeleteIndexRequest(ASYNC_INDEX)).actionGet();
        ShardRouting primary = state.routingTable().index(index).shard(shardId).primaryShard();
            // idempotent freeze.
                for (int i = 0; i < DOCS_PER_BATCH; i++) {
            assertEquals("all primary shards targeted", NUM_SHARDS, response.getTotalShards());
/*
        Set<String> nodeIds = new HashSet<>();
            assertEquals("shard should prepare successfully", 1, response.getSuccessfulShards());
package org.opensearch.composite;
        for (int shardId = 0; shardId < NUM_SHARDS; shardId++) {
     * This guards against the race condition where forceMerge was invisible to onMergesDrained,
 *       node, a green response with all shards successful proves the parallel dispatch + aggregation
                    id++;
     * Triggers a force merge and immediately calls prepare tiering back-to-back. Whether the force
        return client().admin()
        String nodeName = state.nodes().get(primary.currentNodeId()).getName();
 *   <li><b>Broadcast async dispatch.</b> {@code TransportPrepareTieringAction} is a
            .indices()
                .clear()
 *       worked across nodes.</li>
     * exercises the already-drained inline-fire branch on every primary (no merges to drain, no
     */
            client().admin().indices().prepareForceMerge(ASYNC_INDEX).setMaxNumSegments(1).setFlush(false).execute();
            assertEquals("second prepare: all shards targeted", NUM_SHARDS, secondResponse.getTotalShards());
import org.opensearch.index.shard.IndexShard;
            // After prepare completes, all merges must be drained
import org.opensearch.storage.action.tiering.PrepareTieringRequest;
                client().admin().indices().prepareRefresh(ASYNC_INDEX).get();
            }
 *   <li><b>Non-blocking merge drain.</b> Each shard freezes its engine and registers an
            ShardRouting primary = state.routingTable().index(index).shard(shardId).primaryShard();
            // Prepare must succeed — regardless of whether force merge was still running or already done
     * causing tiering to proceed while a force merge was still running.
            final int totalDocs = id;
     *   <li>All merges (background and force) are drained after prepare completes</li>
            }
import org.opensearch.common.unit.TimeValue;
            // Whether the merge is still in-flight or already done when prepare runs is timing-dependent —
 * SPDX-License-Identifier: Apache-2.0
 * <p>This exercises both async mechanisms introduced for DFA tiering preparation, on a real
            assertEquals("first prepare: all shards succeed", NUM_SHARDS, firstResponse.getSuccessfulShards());
                .setSegments(true)
 *       {@code onMergesDrained} listener instead of blocking a thread. The action only flushes and
            assertEquals("all docs should be present", (long) totalDocs, primariesDocCount(ASYNC_INDEX));
            // Sanity: the primaries really are spread across more than one node, so the broadcast fans out.
        } finally {
            assertFalse("no pending merges should remain after prepare", primary.hasPendingMerges());
                    id++;
            }, 30, TimeUnit.SECONDS);
                .indices()
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
    /** Primary doc count via the _stats API (standard DFA-safe approach — search is unsupported on DFA indices). */
                .getSegments()
                .prepareStats(ASYNC_INDEX)
            int id = 0;
            // Merge-drain: after a successful prepare each primary must have fully drained its merges.
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.common.settings.Settings;
     * case:
 * The OpenSearch Contributors require contributions made to
            assertEquals("first prepare: no shard should fail", 0, firstResponse.getFailedShards());
/**
    private long primariesDocCount(String index) {
                .getTotal()
            for (int shardId = 0; shardId < NUM_SHARDS; shardId++) {
 * this file be licensed under the Apache-2.0 license or a
    private int distinctPrimaryNodeCount(String index) {
            // uncommitted would have surfaced as a failed shard above, which we asserted is zero.
        Settings settings = Settings.builder().put(dfaIndexSettings(0)).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, NUM_SHARDS).build();
            request.timeout(TimeValue.timeValueSeconds(90));
        try {
        internalCluster().startDataAndWarmNodes(2);
            assertEquals("active merges should be drained after prepare", 0, primary.getActiveMergeCount());
        ClusterState state = getClusterState();
    /** Resolves the live primary {@link IndexShard} for a given shard id. */
        }
            client().admin().indices().prepareFlush(ASYNC_INDEX).setForce(true).get();
            assertEquals("second prepare: no shard should fail", 0, secondResponse.getFailedShards());
            assertEquals("first prepare: all shards targeted", NUM_SHARDS, firstResponse.getTotalShards());
import java.util.HashSet;
                    assertEquals("replica should be in sync after prepare (bytes behind)", 0, stat.getBytesBehindCount());
            // Index in many batches to create multiple segments worth merging
    /**
 *
 * <p>Note: an IT cannot directly assert "no thread blocked"; the proof is functional — the prepare
            .get()
import org.opensearch.storage.action.tiering.PrepareTieringAction;
            second.timeout(TimeValue.timeValueSeconds(90));
    DataFormatAwareReadonlyEngineBaseIT.CleanerThreadFilter.class,
                .getIndex(ASYNC_INDEX)
        internalCluster().startDataAndWarmNodes(NUM_SHARDS);
            }
        } finally {
        internalCluster().startClusterManagerOnlyNode();
    /** Number of distinct nodes hosting a primary shard of the given index. */
            int id = 0;
            // Index in several refreshed batches so each shard accumulates multiple segments, giving the
 *       report zero active and zero pending merges.</li>
            assertBusy(() -> {
    AbstractCompositeEngineIT.ParquetNativeThreadFilter.class })
            PrepareTieringRequest request = new PrepareTieringRequest(ASYNC_INDEX);
            .setDocs(true)
        Settings settings = Settings.builder().put(dfaIndexSettings(1)).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).build();
            // Execute the real async prepare broadcast.
            assertEquals("second prepare: all shards succeed", NUM_SHARDS, secondResponse.getSuccessfulShards());
        try {
            // Data integrity: doc count should be preserved
        }
     * Regression test for the freeze CAS, the {@code force=true}/{@code "prepare_tiering"} flush+refresh
                    client().prepareIndex(ASYNC_INDEX).setSource("field_text", "value_" + id, "field_number", (long) id).get();
    private static final int INDEX_BATCHES = 5;
     * </ul>
        client().admin().indices().prepareCreate(ASYNC_INDEX).setSettings(settings).get();
     */
import java.util.Set;
            // Replicas must be in sync — checkpoints behind should be 0
                client().admin().indices().prepareRefresh(ASYNC_INDEX).get();
 * End-to-end integration test for the asynchronous pre-tiering sync ({@link PrepareTieringAction}).
     *   <li>Replicas are in sync with the primary (checkpoints behind == 0)</li>
    /**
            PrepareTieringRequest second = new PrepareTieringRequest(ASYNC_INDEX);
@ThreadLeakFilters(filters = {
                    client().prepareIndex(ASYNC_INDEX).setSource("field_text", "value_" + id, "field_number", (long) id).get();
 * <ol>
            assertEquals("all shards should prepare successfully", NUM_SHARDS, response.getSuccessfulShards());
 */
        client().admin().indices().prepareCreate(ASYNC_INDEX).setSettings(settings).get();
        // the prepare broadcast genuinely fans out to multiple nodes.
        Settings settings = Settings.builder().put(dfaIndexSettings(0)).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, NUM_SHARDS).build();
            PrepareTieringRequest first = new PrepareTieringRequest(ASYNC_INDEX);
                nodeIds.add(primary.currentNodeId());
 * is lost across the freeze + flush + remote sync.
     * bypasses, and {@code verifyNoUncommittedOps}.
            client().admin().indices().prepareFlush(ASYNC_INDEX).setForce(true).get();
        client().admin().indices().prepareCreate(ASYNC_INDEX).setSettings(settings).get();
                    client().prepareIndex(ASYNC_INDEX).setSource("field_text", "value_" + id, "field_number", (long) id).get();
        // One cluster-manager plus NUM_SHARDS data nodes so the (0-replica) primaries spread out and
     * verification + force-flush guard must all be no-ops on the second call rather than throw.
            }
        ensureGreen(ASYNC_INDEX);
                    assertEquals("replica should have no in-flight replication", 0, stat.getCurrentReplicationTimeMillis());
import org.opensearch.action.support.broadcast.BroadcastResponse;
                .clear()
import java.util.concurrent.TimeUnit;
                .get()
            PrepareTieringRequest request = new PrepareTieringRequest(ASYNC_INDEX);
 * completes successfully across all shards/nodes, the merge counts are drained to zero, and no data
            for (int shardId = 0; shardId < NUM_SHARDS; shardId++) {
    }
                .setSegments(true)
                }
        ensureGreen(ASYNC_INDEX);
 *
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, nodeName);
public class DataFormatAwarePrepareTieringAsyncIT extends DataFormatAwareReadonlyEngineBaseIT {
            // translog ops on every shard (verifyNoUncommittedOps) — a shard that lost or left data
    private static final int NUM_SHARDS = 3;
                IndexShard primary = primaryShard(ASYNC_INDEX, shardId);
            assertTrue("primaries should be spread across multiple nodes", distinctPrimaryNodeCount(ASYNC_INDEX) > 1);
            // After prepare, replica should have the same segment layout as primary (in sync)
            BroadcastResponse secondResponse = client().execute(PrepareTieringAction.INSTANCE, second).actionGet();
        internalCluster().startDataAndWarmNodes(NUM_SHARDS);
    }
 *       out to every node holding a primary shard, runs each shard's prepare on the GENERIC pool, and
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
            client().admin().indices().prepareFlush(ASYNC_INDEX).setForce(true).get();
                for (var stat : replicationStats) {
            BroadcastResponse firstResponse = client().execute(PrepareTieringAction.INSTANCE, first).actionGet();
            }
            BroadcastResponse response = client().execute(PrepareTieringAction.INSTANCE, request).actionGet();
    private static final String ASYNC_INDEX = "dfa-prepare-async-idx";
    public void testPrepareTieringRunsAsyncAcrossShardsAndDrainsMerges() throws Exception {
                var replicationStats = primary.getReplicationStatsForTrackedReplicas();
            assertEquals("no shard should fail prepare", 0, response.getFailedShards());
            // 1P+1R: total should be exactly 2x primary (replica mirrors primary)
    }
            long totalSegments = client().admin()
