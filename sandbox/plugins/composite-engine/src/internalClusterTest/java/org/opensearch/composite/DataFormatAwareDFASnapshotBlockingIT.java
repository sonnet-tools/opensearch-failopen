     */  
            .cluster()  
        createRepository(V2_REPO, "fs", v2RepoSettings(v2RepoPath));
        client().admin().indices().prepareClose(indexName).get();  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import org.opensearch.node.Node;  
            .prepareCreateSnapshot(V2_REPO, "v2-warm-mix")
                .setWaitForCompletion(true)
        ensureGreen(hotDFA, nonDFA);  
     * restore of the warm DFA index fails because it's not in the manifest.
        // Phase 2: delete every index, then restore all (*). Validate from cluster state that only  
        for (int i = 0; i < docs; i++) {
        Exception ex = expectThrows(
        // Standard "no indices in snapshot match" / "index does not exist in snapshot" type error.
        assertAcked(client.admin().indices().delete(new DeleteIndexRequest(hotDFA, nonDFA, warmDFA)).get());  
            try {  
            .build();  
import org.opensearch.core.common.unit.ByteSizeValue;
        }
        client().admin().indices().prepareOpen(indexName).get();  
                .prepareRestoreSnapshot(V2_REPO, "v2-mixed-snap")  
    public void testV2SnapshotIncludesWarmNonDFAIndex() throws Exception {
import java.nio.file.Path;  
    }
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
        for (int i = 0; i < docs; i++) {  
        final String warmDFA = "warm-dfa";
        final String warmDFA = "only-warm-dfa";
 */
        createNonDFAIndex(nonDFA, 15);
                Node node = internalCluster().getInstance(Node.class, nodeName);
        assertFalse(indexExists(warmNonDFA));
                .setWaitForCompletion(true)
        internalCluster().startDataAndWarmNodes(1);
        assertTrue("warm non-DFA index must be included in snapshot, got: " + snapshotIndices, snapshotIndices.contains(warmNonDFA));
            } catch (Exception ignored) {  
        createWarmNonDFAIndex(warmNonDFA, 15);
        List<String> snapshotIndices = info.indices();
    @Before  
     * <ul>
    /** Create a hot DFA index with the given name, index docs, and flush. */
    /**
            .put("index.pluggable.dataformat.enabled", true)
        client().admin().indices().prepareFlush(indexName).setForce(true).get();
        client().admin().indices().prepareCreate(indexName).setSettings(nonDfa).get();
            }
 *       silently filtered out of V2 snapshots; the rest of the cluster is captured normally.</li>  
 */  
            .put("index.composite.primary_data_format", "parquet")
        // Phase 3: explicitly try to restore warm DFA from the snapshot → must fail (not in manifest).
    private void createNonDFAIndex(String indexName, int docs) {
        assertTrue("snapshot must be empty when cluster has only warm DFA, got: " + info.indices(), info.indices().isEmpty());
 *
     * </ul>  
        assertEquals(RestStatus.OK, restoreResp.status());
        createRepository(V2_REPO, "fs", v2RepoSettings(v2RepoPath));
        client().admin().indices().prepareCreate(indexName).setSettings(warmNonDfa).get();  
}  
        assertEquals(RestStatus.OK, restoreResp.status());
        ensureGreen(indexName);
    }
import org.opensearch.snapshots.SnapshotInfo;
        client().admin().indices().prepareRefresh(indexName).get();  
        assertFalse("warm DFA index must be filtered out, got: " + snapshotIndices, snapshotIndices.contains(warmDFA));
        internalCluster().startDataAndWarmNodes(1);
        assertFalse(indexExists(warmDFA));  
                .cluster()
    }
        internalCluster().startDataAndWarmNodes(1);  
            .get();
     * <em>non-DFA</em> index is captured by a V2 snapshot (present in the manifest with a
 * <ul>
        createHotDFAIndex(hotDFA, 30);  
    /** Create a plain non-DFA, remote-store-backed index. */
import org.opensearch.common.settings.Settings;
 * appears in any snapshot.
                .setIndices(warmDFA)
        final String nonDFA = "non-dfa-mix";
        // The warm non-DFA shard must actually be captured, not just listed.
    private void createWarmDFAIndex(String indexName, int docs) {
        // Phase 1: take V2 snapshot, verify warm DFA is filtered.
        for (int i = 0; i < docs; i++) {
public class DataFormatAwareDFASnapshotBlockingIT extends DataFormatAwareReadonlyEngineBaseIT {  
 *   <li><b>Block A</b> ({@code SnapshotsService.createSnapshotV2}): warm-tiered DFA indexes are
            .prepareRestoreSnapshot(V2_REPO, "v2-mixed-snap")
     *   <li>Take a V2 snapshot of a cluster with hot DFA + warm DFA + non-DFA indexes.</li>  
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
            () -> client().admin()
import org.opensearch.cluster.metadata.IndexMetadata;
            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED.getKey(), true)
 * Integration tests covering the snapshot guardrails for pluggable-data-format-aware (DFA) indexes:  
            .setIndices("*")
        ensureGreen(indexName);
            Exception.class,  
     * successful shard), while a warm DFA index in the same cluster is still filtered out.  
            .get();  
        return Settings.builder()
            client().prepareIndex(indexName).setId(String.valueOf(i)).setSource("text", "n" + i).get();
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
     *       non-DFA come back while the filtered warm DFA index does not.</li>  
        CreateSnapshotResponse snapResp = client().admin()
        );
        // the snapshotted indices (hot DFA + non-DFA) come back; the filtered warm DFA does not.
        }
            .get();  
                .setIndices(warmDFA)
            .get();
        Settings hot = Settings.builder()  
    private static final String V2_REPO = "v2-block-test-repo";
            .setWaitForCompletion(true)  
        // the warm non-DFA index comes back; the warm DFA index (filtered at create time) does not.
import org.opensearch.indices.replication.common.ReplicationType;
    /** Create a hot DFA index, ingest docs, then tier to warm. */  
        Exception ex = expectThrows(
        internalCluster().startClusterManagerOnlyNode();  
            .cluster()  
        createRepository(V2_REPO, "fs", v2RepoSettings(v2RepoPath));  
import org.junit.Before;  
        SnapshotInfo info = snapResp.getSnapshotInfo();  
        createWarmDFAIndex(warmDFA, 10);
     *   <li>Delete all indexes, restore all (*), and verify from cluster state that hot DFA +
        assertTrue("snapshot must contain non-DFA index, got: " + snapshotIndices, snapshotIndices.contains(nonDFA));  
        createWarmDFAIndex(warmDFA, 20);
            client().prepareIndex(indexName).setId(String.valueOf(i)).setSource("text", "n" + i).get();  
            .setSettings(Settings.builder().put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true))
            .put(remoteStoreIndexSettings(0, 1))
        client().admin().indices().prepareFlush(indexName).setForce(true).get();  
        client().admin().indices().prepareFlush(indexName).setForce(true).get();
                .get()  
    private void createWarmNonDFAIndex(String indexName, int docs) {  
        // Validate the restored set from cluster state.
            .setWaitForCompletion(true)
        assertAcked(client.admin().indices().delete(new DeleteIndexRequest(warmNonDFA, warmDFA)).get());
    }  
            .cluster()
import org.opensearch.core.common.unit.ByteSizeUnit;  
     *       because it's not in the snapshot manifest (Block A filtered it at create time).</li>
                    fc.clear();
     * warm tier + pluggable data format is filtered. This verifies that a writable-warm
    }
 * </ul>
            .putList("index.composite.secondary_data_formats", List.of("lucene"))
    private void createHotDFAIndex(String indexName, int docs) {
            .setIndices("*")
            .put(super.nodeSettings(nodeOrdinal))  
            .cluster()  
            .get();
    @Override  
        assertNotNull("explicit restore of filtered warm DFA must fail", ex.getMessage());  
        Files.createDirectories(v2RepoPath);  
        assertTrue("warm non-DFA must be restored", indexExists(warmNonDFA));  
            .setWaitForCompletion(true)  
     * Block A coverage — only-warm-DFA cluster. Snapshot succeeds with empty index list; explicit
            .build();  
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        assertFalse(indexExists(warmDFA));  
        SnapshotInfo info = snapResp.getSnapshotInfo();
                .get()  
        final String warmNonDFA = "warm-non-dfa";  
import org.opensearch.snapshots.SnapshotState;  
    /**  
    private Path v2RepoPath;
 * SPDX-License-Identifier: Apache-2.0
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    public void setupSnapshotRepos() throws java.io.IOException {
     * Block A coverage — the headline V2 partial-filter test for a mixed cluster:
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;  
    private Settings.Builder v2RepoSettings(Path location) {  
        final String hotDFA = "hot-dfa-mix";  
        assertFalse("warm DFA index must be filtered out, got: " + snapshotIndices, snapshotIndices.contains(warmDFA));  
 *
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)  
    @After  
            () -> client.admin()
        );
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    }
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), new ByteSizeValue(2, ByteSizeUnit.GB).toString())
        RestoreSnapshotResponse restoreResp = client.admin()
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)  
            .build();
        ensureGreen(warmNonDFA);  
                .cluster()
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertTrue("non-DFA must be restored", indexExists(nonDFA));
        // Restore all (*): delete both indices, restore, and validate from cluster state that only
        assertEquals(SnapshotState.SUCCESS, info.state());
    }  
        Settings nonDfa = Settings.builder()  
        client().admin()
import org.opensearch.transport.client.Client;
     */
        // tiering a hot non-DFA index to warm). Remote store is enabled cluster-wide by the base.
        List<String> snapshotIndices = info.indices();
    }
    public void testV2SnapshotWhenClusterHasOnlyWarmDFA() throws Exception {
        assertFalse("warm DFA must NOT be restored (filtered from snapshot)", indexExists(warmDFA));
        final String warmDFA = "warm-dfa-mix";
     * Block A guard — warm tiering alone must NOT trigger exclusion; only the combination of  
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);
            .put("index.pluggable.dataformat", "composite")  
        // Explicit restore of warm DFA → fails (not in snapshot).
     */
        internalCluster().startClusterManagerOnlyNode();
            .put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true)
        v2RepoPath = randomRepoPath().toAbsolutePath();
 * Together these guarantee: hot DFA + non-DFA flow normally through V2 snapshots; warm DFA never  
 * compatible open source license.
        for (String nodeName : internalCluster().getNodeNames()) {
/*  
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
                var fc = node.fileCache();
    }
        Settings warmNonDfa = Settings.builder()  
                .prepareRestoreSnapshot(V2_REPO, "v2-only-warm")  
        // Writable warm: the index is created warm from the start (OpenSearch does not support
        SnapshotInfo info = snapResp.getSnapshotInfo();
        }  
        Client client = client();
        internalCluster().startClusterManagerOnlyNode();  
        ensureGreen(indexName);
        assertTrue("warm non-DFA shard must be snapshotted, successfulShards=" + info.successfulShards(), info.successfulShards() >= 1);
            .prepareCreateSnapshot(V2_REPO, "v2-only-warm")  
            .prepareUpdateSettings(indexName)  
        assertTrue("hot DFA must be restored", indexExists(hotDFA));  
            client().prepareIndex(indexName).setSource("n", (long) i).get();
        assertFalse("warm DFA must NOT be restored (filtered from snapshot)", indexExists(warmDFA));
            .setWaitForCompletion(true)
            .prepareCreateSnapshot(V2_REPO, "v2-mixed-snap")
            .prepareRestoreSnapshot(V2_REPO, "v2-warm-mix")
            .cluster()  
        ensureGreen(indexName);  
                }
            .get();
            .put("location", location)
            Exception.class,  
    public void tearDownFileCache() {
        CreateSnapshotResponse snapResp = client().admin()
        assertNotNull("explicit restore of warm DFA must fail; snapshot has no such index", ex.getMessage());
    /**  
        RestoreSnapshotResponse restoreResp = client.admin()
        CreateSnapshotResponse snapResp = client().admin()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
import org.opensearch.core.rest.RestStatus;
                // Node may have already been stopped; skip it.
        // Take V2 snapshot — warm non-DFA must be included, warm DFA must be filtered.
/**
        createWarmDFAIndex(warmDFA, 10);
 * this file be licensed under the Apache-2.0 license or a
import org.junit.After;
     *   <li>Verify the snapshot manifest contains hot DFA + non-DFA, NOT warm DFA.</li>
            .setWaitForCompletion(true)
    }
import java.util.List;
        client().admin().indices().prepareRefresh(indexName).get();
        assertEquals(SnapshotState.SUCCESS, info.state());
            .indices()
        assertTrue("snapshot must contain hot DFA index, got: " + snapshotIndices, snapshotIndices.contains(hotDFA));
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertFalse(indexExists(hotDFA));
        client().admin().indices().prepareCreate(indexName).setSettings(hot).get();
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)  
    }
import org.opensearch.index.IndexModule;  
            .build();
        createHotDFAIndex(indexName, docs);
        }  
        return Settings.builder()
import java.nio.file.Files;
        Client client = client();  
     *   <li>Phase 3: explicitly request restore of the warm DFA index from the snapshot — fails
    /** Create a writable-warm (non-DFA) index directly and ingest docs. */
    public void testV2SnapshotMixedClusterFiltersWarmDFAFullLifecycle() throws Exception {
        assertFalse(indexExists(nonDFA));
        assertEquals(SnapshotState.SUCCESS, info.state());
 * The OpenSearch Contributors require contributions made to  
        // Validate the restored set from cluster state.
    protected Settings nodeSettings(int nodeOrdinal) {
                if (fc != null) {  
import org.opensearch.indices.RemoteStoreSettings;
package org.opensearch.composite;
