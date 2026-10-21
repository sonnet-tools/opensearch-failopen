        ensureGreen(INDEX);
 * with dynamic mapping updates arriving part way through, must leave the shard in request order: visible state,
        BulkResponse response = bulk.get();
            } else {
        final boolean shallowCopy = randomBoolean();
        }
    private void indexMixedBulk() {
        createIndex(
        assertHitCount(client().prepareSearch(index).setSize(0).get(), live);
            }
                continue;
        assertThat(snapshot.getSnapshotInfo().state(), equalTo(SnapshotState.SUCCESS));
            INDEX,
        indexMixedBulk();
                bulk.add(client().prepareIndex(INDEX).setId(id(i)).setSource("value", i, "dyn" + i, "x"));
 * The OpenSearch Contributors require contributions made to
        verifyDynamicMappings();
        );
        );
        createRepository(repo, "fs", repoSettings);
            IndexSettings.INDEX_TRANSLOG_BATCH_APPEND_ENABLED_SETTING.get(
        RestoreSnapshotResponse restore = client().admin()
        verifyState(INDEX, DOCS);
        assertThat(snapshot.getSnapshotInfo().successfulShards(), equalTo(snapshot.getSnapshotInfo().totalShards()));
        verifyState(INDEX, DOCS);
            .setRenamePattern(INDEX)
            "the index under test opted in",
     * A snapshot taken right after an unrefreshed batched bulk must capture every acknowledged operation. Snapshotting
        );
        return "doc-" + i;
        internalCluster().startClusterManagerOnlyNode();
            assertTrue("dynamic field dyn" + i + " must be mapped", properties.containsKey("dyn" + i));
    public void testUnrefreshedBatchedBulkIsCapturedBySnapshotAndRestore() throws Exception {
    }
    }
                .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.REQUEST)
            repoSettings.put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true);
            if (i % 5 == 0) {
     * Restoring the snapshot (shallow or full copy, chosen at random) must reproduce the state exactly.
        ensureGreen(restored);
            .setWaitForCompletion(true)
 * this file be licensed under the Apache-2.0 license or a
                .put(remoteStoreIndexSettings(0))
 */
    private void verifyDynamicMappings() {
     */
            Settings.builder()
import org.opensearch.action.bulk.BulkResponse;
            assertTrue("doc " + i + " must exist", get.isExists());
        Settings.Builder repoSettings = Settings.builder().put("location", randomRepoPath().toAbsolutePath());
        // exactly the batched and inline operations in order.
        // Realtime GETs before any refresh: every acknowledged operation is already observable.
            .prepareCreateSnapshot(repo, "snap")
import org.opensearch.index.translog.Translog;
     * fiftieth document introduces a new field, so dynamic mapping updates interrupt the batch several times.
/*
        ensureGreen(INDEX);
    @SuppressWarnings("unchecked")
    }
    /**
import org.opensearch.action.bulk.BulkRequestBuilder;
     * never advertises an operation the translog lacks, and the remote translog carries whatever the commit does not.
    private static final int DOCS = 300;
            .cluster()
        }
        verifyState(restored, DOCS);
            assertThat("doc " + i, ((Number) get.getSourceAsMap().get("value")).intValue(), equalTo(expected));
                .put(remoteStoreIndexSettings(0))
import java.util.Map;
     * flushes the shard; the flush drains the open chunks before the Lucene commit, so the commit's local checkpoint
        assertFalse(
 * compatible open source license.
import org.opensearch.repositories.blobstore.BlobStoreRepository;
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
import org.opensearch.test.OpenSearchIntegTestCase;
 * SPDX-License-Identifier: Apache-2.0
}
     * One shard bulk, in request order: index every id, then update every third, then delete every fifth. Every
import org.opensearch.snapshots.SnapshotState;
 * Batched translog appends are opt-in ({@code index.translog.batch_append.enabled}, default false) on remote-store
        // fiftieth document introduces a new field, so dynamic mapping updates interrupt the batch several times.
            int expected = i % 3 == 0 ? i * 10 : i;
        MappingMetadata mapping = client().admin().indices().prepareGetMappings(INDEX).get().getMappings().get(INDEX);
            GetResponse get = client().prepareGet(index, id(i)).setRealtime(true).get();
    public void testMixedBulkWithUpdatesDeletesAndDynamicMappingsSurvivesRestart() throws Exception {
                bulk.add(client().prepareIndex(INDEX).setId(id(i)).setSource("value", i));
    }
        for (int i = 0; i < DOCS; i += 3) {
            live++;
            INDEX,
            }
            bulk.add(client().prepareUpdate(INDEX, id(i)).setDoc("value", i * 10));
            )
     */
 * realtime GETs and the translog replayed by a node restart all agree.
        createIndex(
            Settings.builder()
            .setIndices(INDEX)
        verifyState(INDEX, DOCS);
                assertFalse("doc " + i + " was deleted", get.isExists());
/**
        verifyState(INDEX, DOCS);
        assertThat(restore.getRestoreInfo().failedShards(), equalTo(0));
        refresh(INDEX);
        Map<String, Object> properties = (Map<String, Object>) mapping.getSourceAsMap().get("properties");
                client().admin().indices().prepareGetSettings(INDEX).get().getIndexToSettings().get(INDEX)
        BulkRequestBuilder bulk = client().prepareBulk();
        internalCluster().startClusterManagerOnlyNode();
                .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.REQUEST)
 * segment-replication indexes. With the setting on, a single bulk mixing indexes, updates and deletes of the same ids,
                .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "-1")
        // No refresh has happened: the chunks have been appended and synced, Lucene is uncommitted.
        }
        ensureGreen(INDEX);
        if (shallowCopy) {
            .setIndices(INDEX)
        CreateSnapshotResponse snapshot = client().admin()
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
import org.opensearch.index.IndexSettings;
        assertFalse(response.buildFailureMessage(), response.hasFailures());
        }
    }
package org.opensearch.remotestore;
        verifyState(INDEX, DOCS);
            .setWaitForCompletion(true)
    /**
        final String restored = INDEX + "-restored";
 *
            .get();
        internalCluster().startDataOnlyNodes(1);
        internalCluster().restartNode(dataNode);
public class RemoteStoreBatchedTranslogIT extends RemoteStoreBaseIntegTestCase {
            .get();
 */
            bulk.add(client().prepareDelete(INDEX, id(i)));
                .build()
            if (i % 50 == 0) {
            IndexSettings.INDEX_TRANSLOG_BATCH_APPEND_ENABLED_SETTING.getDefault(Settings.EMPTY)
        for (int i = 0; i < docs; i++) {
        int live = 0;
        // Restart the only data node: the shard recovers from remote segments plus the remote translog, which replays
        for (int i = 0; i < DOCS; i += 50) {
        assertTrue(
            .prepareRestoreSnapshot(repo, "snap")
import org.opensearch.common.settings.Settings;
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
    private void verifyState(String index, int docs) {
    private static String id(int i) {
        );
import org.opensearch.cluster.metadata.MappingMetadata;
    private static final String INDEX = "batched-tlog";
        for (int i = 0; i < DOCS; i += 5) {
        // One shard bulk, in request order: index every id, then update every third, then delete every fifth. Every
            "batching must be opt-in: an eligible index without the setting keeps the per-operation path",
            .setRenameReplacement(restored)
        refresh(index);
        indexMixedBulk();
import org.opensearch.action.get.GetResponse;
    }
        }
        String dataNode = internalCluster().startDataOnlyNodes(1).get(0);
        final String repo = "batched-tlog-snapshots";
                .build()
                .put(IndexSettings.INDEX_TRANSLOG_BATCH_APPEND_ENABLED_SETTING.getKey(), true)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        for (int i = 0; i < DOCS; i++) {
        }
            .cluster()
        verifyDynamicMappings();
