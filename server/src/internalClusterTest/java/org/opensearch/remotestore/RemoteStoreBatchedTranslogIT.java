            assertTrue("doc " + i + " must exist", get.isExists());
        for (int i = 0; i < DOCS; i += 50) {
            Settings.builder()
import org.opensearch.action.bulk.BulkResponse;
        // exactly the batched and inline operations in order.
public class RemoteStoreBatchedTranslogIT extends RemoteStoreBaseIntegTestCase {
     * flushes the shard; the flush drains the open chunks before the Lucene commit, so the commit's local checkpoint
            }  
 * realtime GETs and the translog replayed by a node restart all agree.
     */
            } else {
        }
                .put(IndexSettings.INDEX_TRANSLOG_BATCH_APPEND_ENABLED_SETTING.getKey(), true)  
            live++;  
    }
import static org.hamcrest.Matchers.equalTo;
            .setWaitForCompletion(true)
import org.opensearch.snapshots.SnapshotState;
import java.util.Map;
            assertTrue("dynamic field dyn" + i + " must be mapped", properties.containsKey("dyn" + i));
    private static String id(int i) {  
 * Batched translog appends are opt-in ({@code index.translog.batch_append.enabled}, default false) on remote-store
        // No refresh has happened: the chunks have been appended and synced, Lucene is uncommitted.
                .put(remoteStoreIndexSettings(0))  
        BulkRequestBuilder bulk = client().prepareBulk();  
import org.opensearch.index.IndexSettings;
    }
        final String restored = INDEX + "-restored";
     * Restoring the snapshot (shallow or full copy, chosen at random) must reproduce the state exactly.
        }
            .setRenameReplacement(restored)
        assertThat(restore.getRestoreInfo().failedShards(), equalTo(0));
        verifyState(INDEX, DOCS);
        // One shard bulk, in request order: index every id, then update every third, then delete every fifth. Every  
import org.opensearch.test.OpenSearchIntegTestCase;  
import org.opensearch.action.get.GetResponse;
        internalCluster().startDataOnlyNodes(1);
            )  
        ensureGreen(restored);
        ensureGreen(INDEX);  
 */  
        );
import org.opensearch.action.bulk.BulkRequestBuilder;  
            .get();  
            .get();  
                continue;
        assertHitCount(client().prepareSearch(index).setSize(0).get(), live);  
    public void testMixedBulkWithUpdatesDeletesAndDynamicMappingsSurvivesRestart() throws Exception {
    }
        assertFalse(
 * segment-replication indexes. With the setting on, a single bulk mixing indexes, updates and deletes of the same ids,  
            .cluster()  
        internalCluster().restartNode(dataNode);  
/**
            bulk.add(client().prepareUpdate(INDEX, id(i)).setDoc("value", i * 10));  
        createIndex(  
        createIndex(
        String dataNode = internalCluster().startDataOnlyNodes(1).get(0);  
        for (int i = 0; i < DOCS; i++) {
            .cluster()
            .prepareRestoreSnapshot(repo, "snap")
        final String repo = "batched-tlog-snapshots";
            GetResponse get = client().prepareGet(index, id(i)).setRealtime(true).get();
     * One shard bulk, in request order: index every id, then update every third, then delete every fifth. Every
                bulk.add(client().prepareIndex(INDEX).setId(id(i)).setSource("value", i));
    private void verifyDynamicMappings() {
/*  
        MappingMetadata mapping = client().admin().indices().prepareGetMappings(INDEX).get().getMappings().get(INDEX);
            .setWaitForCompletion(true)
            "batching must be opt-in: an eligible index without the setting keeps the per-operation path",
        verifyState(restored, DOCS);  
                bulk.add(client().prepareIndex(INDEX).setId(id(i)).setSource("value", i, "dyn" + i, "x"));  
        return "doc-" + i;
            assertThat("doc " + i, ((Number) get.getSourceAsMap().get("value")).intValue(), equalTo(expected));  
        // fiftieth document introduces a new field, so dynamic mapping updates interrupt the batch several times.
        internalCluster().startClusterManagerOnlyNode();
        indexMixedBulk();  
        verifyDynamicMappings();
    private static final int DOCS = 300;
            INDEX,
        assertThat(snapshot.getSnapshotInfo().state(), equalTo(SnapshotState.SUCCESS));
    @SuppressWarnings("unchecked")  
 *
        if (shallowCopy) {
        }  
            }
     * fiftieth document introduces a new field, so dynamic mapping updates interrupt the batch several times.  
            .setIndices(INDEX)
        // Realtime GETs before any refresh: every acknowledged operation is already observable.
    /**  
        verifyState(INDEX, DOCS);
        );
        ensureGreen(INDEX);
                assertFalse("doc " + i + " was deleted", get.isExists());  
        }
            INDEX,
        verifyState(INDEX, DOCS);
        BulkResponse response = bulk.get();
        CreateSnapshotResponse snapshot = client().admin()
        final boolean shallowCopy = randomBoolean();
}
        Settings.Builder repoSettings = Settings.builder().put("location", randomRepoPath().toAbsolutePath());  
        refresh(index);
            repoSettings.put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true);
            .setRenamePattern(INDEX)
            .prepareCreateSnapshot(repo, "snap")  
        // Restart the only data node: the shard recovers from remote segments plus the remote translog, which replays
    }
            int expected = i % 3 == 0 ? i * 10 : i;
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
                client().admin().indices().prepareGetSettings(INDEX).get().getIndexToSettings().get(INDEX)
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
package org.opensearch.remotestore;
        int live = 0;
            Settings.builder()  
        for (int i = 0; i < DOCS; i += 3) {
        RestoreSnapshotResponse restore = client().admin()
        verifyState(INDEX, DOCS);
        internalCluster().startClusterManagerOnlyNode();
        verifyDynamicMappings();  
    private void indexMixedBulk() {
 * SPDX-License-Identifier: Apache-2.0
        }
        createRepository(repo, "fs", repoSettings);
import org.opensearch.index.translog.Translog;  
     * A snapshot taken right after an unrefreshed batched bulk must capture every acknowledged operation. Snapshotting
    public void testUnrefreshedBatchedBulkIsCapturedBySnapshotAndRestore() throws Exception {  
        assertFalse(response.buildFailureMessage(), response.hasFailures());  
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
        refresh(INDEX);  
    }
        );
    /**
                .build()  
            "the index under test opted in",  
                .put(remoteStoreIndexSettings(0))
        }  
 */  
 * compatible open source license.
            if (i % 5 == 0) {
            IndexSettings.INDEX_TRANSLOG_BATCH_APPEND_ENABLED_SETTING.getDefault(Settings.EMPTY)  
        assertThat(snapshot.getSnapshotInfo().successfulShards(), equalTo(snapshot.getSnapshotInfo().totalShards()));
        Map<String, Object> properties = (Map<String, Object>) mapping.getSourceAsMap().get("properties");  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
     */
        assertTrue(
        verifyState(INDEX, DOCS);
        indexMixedBulk();
     * never advertises an operation the translog lacks, and the remote translog carries whatever the commit does not.  
                .build()
            IndexSettings.INDEX_TRANSLOG_BATCH_APPEND_ENABLED_SETTING.get(
    }
import org.opensearch.common.settings.Settings;
        for (int i = 0; i < DOCS; i += 5) {
    private static final String INDEX = "batched-tlog";
                .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.REQUEST)
import org.opensearch.repositories.blobstore.BlobStoreRepository;
                .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "-1")
            if (i % 50 == 0) {
                .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.REQUEST)
            bulk.add(client().prepareDelete(INDEX, id(i)));  
            .setIndices(INDEX)  
import org.opensearch.cluster.metadata.MappingMetadata;  
        for (int i = 0; i < docs; i++) {  
        );
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
        ensureGreen(INDEX);
 * with dynamic mapping updates arriving part way through, must leave the shard in request order: visible state,
    private void verifyState(String index, int docs) {
