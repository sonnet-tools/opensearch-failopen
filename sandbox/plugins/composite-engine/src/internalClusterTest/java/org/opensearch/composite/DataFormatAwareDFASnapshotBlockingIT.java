    private void createNonDFAIndex(String indexName, int docs) {
        Settings nonDfa = Settings.builder()
            .cluster()
import org.opensearch.core.common.unit.ByteSizeUnit;
            () -> client.admin()
     */
    }
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        // tiering a hot non-DFA index to warm). Remote store is enabled cluster-wide by the base.
        createHotDFAIndex(indexName, docs);
import org.opensearch.cluster.metadata.IndexMetadata;
            .prepareCreateSnapshot(V2_REPO, "v2-only-warm")
        assertTrue("warm non-DFA shard must be snapshotted, successfulShards=" + info.successfulShards(), info.successfulShards() >= 1);
                .setIndices(warmDFA)
            .prepareUpdateSettings(indexName)
    @After
        assertTrue("warm non-DFA must be restored", indexExists(warmNonDFA));
     *       non-DFA come back while the filtered warm DFA index does not.</li>
            }
            .prepareRestoreSnapshot(V2_REPO, "v2-warm-mix")
        assertFalse("warm DFA index must be filtered out, got: " + snapshotIndices, snapshotIndices.contains(warmDFA));
        client().admin().indices().prepareRefresh(indexName).get();
 * <ul>
        }
        assertEquals(SnapshotState.SUCCESS, info.state());
            .put("index.composite.primary_data_format", "parquet")
import java.util.List;
        assertFalse(indexExists(warmDFA));
        // Phase 1: take V2 snapshot, verify warm DFA is filtered.
    private Settings.Builder v2RepoSettings(Path location) {
        RestoreSnapshotResponse restoreResp = client.admin()
    @Override
            .build();
    /**
                // Node may have already been stopped; skip it.
        assertTrue("hot DFA must be restored", indexExists(hotDFA));
            .put("index.pluggable.dataformat", "composite")
        Client client = client();
    /**
        // the snapshotted indices (hot DFA + non-DFA) come back; the filtered warm DFA does not.
    }
import java.nio.file.Files;
 * Together these guarantee: hot DFA + non-DFA flow normally through V2 snapshots; warm DFA never
import org.junit.After;
    private static final String V2_REPO = "v2-block-test-repo";
    }
        Exception ex = expectThrows(
/*
     * restore of the warm DFA index fails because it's not in the manifest.
            Exception.class,
        ensureGreen(warmNonDFA);
    protected Settings nodeSettings(int nodeOrdinal) {
        }
        // the warm non-DFA index comes back; the warm DFA index (filtered at create time) does not.
        // Explicit restore of warm DFA → fails (not in snapshot).
            .setIndices("*")
     *   <li>Take a V2 snapshot of a cluster with hot DFA + warm DFA + non-DFA indexes.</li>
        assertEquals(SnapshotState.SUCCESS, info.state());
            .get();
        client().admin().indices().prepareRefresh(indexName).get();
 *       silently filtered out of V2 snapshots; the rest of the cluster is captured normally.</li>
            .put(super.nodeSettings(nodeOrdinal))
 * The OpenSearch Contributors require contributions made to
        // Take V2 snapshot — warm non-DFA must be included, warm DFA must be filtered.
     *   <li>Delete all indexes, restore all (*), and verify from cluster state that hot DFA +
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), new ByteSizeValue(2, ByteSizeUnit.GB).toString())
     *   <li>Verify the snapshot manifest contains hot DFA + non-DFA, NOT warm DFA.</li>
        assertFalse("warm DFA must NOT be restored (filtered from snapshot)", indexExists(warmDFA));
        internalCluster().startClusterManagerOnlyNode();
        RestoreSnapshotResponse restoreResp = client.admin()
import org.junit.Before;
        assertNotNull("explicit restore of filtered warm DFA must fail", ex.getMessage());
        assertFalse("warm DFA must NOT be restored (filtered from snapshot)", indexExists(warmDFA));
        internalCluster().startClusterManagerOnlyNode();
        // Restore all (*): delete both indices, restore, and validate from cluster state that only
     * Block A coverage — only-warm-DFA cluster. Snapshot succeeds with empty index list; explicit
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
        List<String> snapshotIndices = info.indices();
        CreateSnapshotResponse snapResp = client().admin()
     * </ul>
                .cluster()
        createWarmDFAIndex(warmDFA, 10);
        assertFalse(indexExists(warmNonDFA));
        final String warmDFA = "only-warm-dfa";
        client().admin().indices().prepareCreate(indexName).setSettings(nonDfa).get();
public class DataFormatAwareDFASnapshotBlockingIT extends DataFormatAwareReadonlyEngineBaseIT {
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            .get();
            .setSettings(Settings.builder().put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true))
 * appears in any snapshot.
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
    private void createWarmDFAIndex(String indexName, int docs) {
     *   <li>Phase 3: explicitly request restore of the warm DFA index from the snapshot — fails
            .setIndices("*")
     *       because it's not in the snapshot manifest (Block A filtered it at create time).</li>
        assertTrue("snapshot must be empty when cluster has only warm DFA, got: " + info.indices(), info.indices().isEmpty());
    }
    private Path v2RepoPath;
 * compatible open source license.
    }
            Exception.class,
                .setWaitForCompletion(true)
        // Writable warm: the index is created warm from the start (OpenSearch does not support
            client().prepareIndex(indexName).setSource("n", (long) i).get();
     */
        );
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertEquals(RestStatus.OK, restoreResp.status());
import java.nio.file.Path;
        return Settings.builder()
            .get();
            .setWaitForCompletion(true)
        assertTrue("snapshot must contain non-DFA index, got: " + snapshotIndices, snapshotIndices.contains(nonDFA));
    public void setupSnapshotRepos() throws java.io.IOException {
 * Integration tests covering the snapshot guardrails for pluggable-data-format-aware (DFA) indexes:
    /** Create a plain non-DFA, remote-store-backed index. */
        }
    }
        assertTrue("snapshot must contain hot DFA index, got: " + snapshotIndices, snapshotIndices.contains(hotDFA));
import org.opensearch.core.rest.RestStatus;
    }
        assertEquals(SnapshotState.SUCCESS, info.state());
                .cluster()
        // The warm non-DFA shard must actually be captured, not just listed.
    /** Create a hot DFA index, ingest docs, then tier to warm. */
 *
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
import org.opensearch.indices.replication.common.ReplicationType;
        Exception ex = expectThrows(
    public void testV2SnapshotIncludesWarmNonDFAIndex() throws Exception {
        ensureGreen(indexName);
        assertFalse("warm DFA index must be filtered out, got: " + snapshotIndices, snapshotIndices.contains(warmDFA));
        assertAcked(client.admin().indices().delete(new DeleteIndexRequest(warmNonDFA, warmDFA)).get());
        final String warmDFA = "warm-dfa";
        Client client = client();
        SnapshotInfo info = snapResp.getSnapshotInfo();
package org.opensearch.composite;
import org.opensearch.indices.RemoteStoreSettings;
        List<String> snapshotIndices = info.indices();
    }
import org.opensearch.repositories.blobstore.BlobStoreRepository;
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
        client().admin().indices().prepareCreate(indexName).setSettings(hot).get();
    }
    /** Create a hot DFA index with the given name, index docs, and flush. */
        Settings warmNonDfa = Settings.builder()
        createNonDFAIndex(nonDFA, 15);
                .get()
    @Before
    /** Create a writable-warm (non-DFA) index directly and ingest docs. */
            () -> client().admin()
        // Validate the restored set from cluster state.
import org.opensearch.transport.client.Client;
        CreateSnapshotResponse snapResp = client().admin()
            client().prepareIndex(indexName).setId(String.valueOf(i)).setSource("text", "n" + i).get();
        for (int i = 0; i < docs; i++) {
        for (int i = 0; i < docs; i++) {
        assertTrue("warm non-DFA index must be included in snapshot, got: " + snapshotIndices, snapshotIndices.contains(warmNonDFA));
 * </ul>
import org.opensearch.node.Node;
            .cluster()
        );
        for (String nodeName : internalCluster().getNodeNames()) {
            } catch (Exception ignored) {
            .setWaitForCompletion(true)
        client().admin()
        client().admin().indices().prepareClose(indexName).get();
    public void tearDownFileCache() {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        assertNotNull("explicit restore of warm DFA must fail; snapshot has no such index", ex.getMessage());
        createWarmDFAIndex(warmDFA, 10);
            .cluster()
        createRepository(V2_REPO, "fs", v2RepoSettings(v2RepoPath));
                Node node = internalCluster().getInstance(Node.class, nodeName);
        client().admin().indices().prepareFlush(indexName).setForce(true).get();
            .setWaitForCompletion(true)
     * Block A guard — warm tiering alone must NOT trigger exclusion; only the combination of
        assertEquals(RestStatus.OK, restoreResp.status());
        internalCluster().startDataAndWarmNodes(1);
            client().prepareIndex(indexName).setId(String.valueOf(i)).setSource("text", "n" + i).get();
        final String hotDFA = "hot-dfa-mix";
        v2RepoPath = randomRepoPath().toAbsolutePath();
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
                }
                .get()
        client().admin().indices().prepareFlush(indexName).setForce(true).get();
 */
        internalCluster().startDataAndWarmNodes(1);
                var fc = node.fileCache();
        internalCluster().startClusterManagerOnlyNode();
            .setWaitForCompletion(true)
            .build();
            .put("location", location)
        createHotDFAIndex(hotDFA, 30);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        client().admin().indices().prepareCreate(indexName).setSettings(warmNonDfa).get();
        // Phase 3: explicitly try to restore warm DFA from the snapshot → must fail (not in manifest).
            .get();
        assertTrue("non-DFA must be restored", indexExists(nonDFA));
    private void createHotDFAIndex(String indexName, int docs) {
    }
}
            .prepareRestoreSnapshot(V2_REPO, "v2-mixed-snap")
            .indices()
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        assertFalse(indexExists(nonDFA));
        }
     * Block A coverage — the headline V2 partial-filter test for a mixed cluster:
        assertAcked(client.admin().indices().delete(new DeleteIndexRequest(hotDFA, nonDFA, warmDFA)).get());
        createRepository(V2_REPO, "fs", v2RepoSettings(v2RepoPath));
import org.opensearch.common.settings.Settings;
        // Standard "no indices in snapshot match" / "index does not exist in snapshot" type error.
        client().admin().indices().prepareFlush(indexName).setForce(true).get();
        final String warmNonDFA = "warm-non-dfa";
            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED.getKey(), true)
            .cluster()
 * this file be licensed under the Apache-2.0 license or a
        Files.createDirectories(v2RepoPath);
     * successful shard), while a warm DFA index in the same cluster is still filtered out.
     */
import org.opensearch.snapshots.SnapshotInfo;
     * <em>non-DFA</em> index is captured by a V2 snapshot (present in the manifest with a
        ensureGreen(hotDFA, nonDFA);
            .put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true)
        final String warmDFA = "warm-dfa-mix";
                .setWaitForCompletion(true)
 * SPDX-License-Identifier: Apache-2.0
        // Validate the restored set from cluster state.
        final String nonDFA = "non-dfa-mix";
    public void testV2SnapshotMixedClusterFiltersWarmDFAFullLifecycle() throws Exception {
                .setIndices(warmDFA)
            .get();
/**
        assertFalse(indexExists(warmDFA));
     * warm tier + pluggable data format is filtered. This verifies that a writable-warm
        ensureGreen(indexName);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
 */
            try {
    public void testV2SnapshotWhenClusterHasOnlyWarmDFA() throws Exception {
        for (int i = 0; i < docs; i++) {
    /**
        SnapshotInfo info = snapResp.getSnapshotInfo();
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);
            .get();
            .prepareCreateSnapshot(V2_REPO, "v2-mixed-snap")
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                .prepareRestoreSnapshot(V2_REPO, "v2-mixed-snap")
        CreateSnapshotResponse snapResp = client().admin()
    private void createWarmNonDFAIndex(String indexName, int docs) {
        SnapshotInfo info = snapResp.getSnapshotInfo();
                .prepareRestoreSnapshot(V2_REPO, "v2-only-warm")
            .putList("index.composite.secondary_data_formats", List.of("lucene"))
import org.opensearch.index.IndexModule;
        client().admin().indices().prepareOpen(indexName).get();
            .build();
            .setWaitForCompletion(true)
                if (fc != null) {
        assertFalse(indexExists(hotDFA));
            .put("index.pluggable.dataformat.enabled", true)
        createWarmNonDFAIndex(warmNonDFA, 15);
        // Phase 2: delete every index, then restore all (*). Validate from cluster state that only
        internalCluster().startDataAndWarmNodes(1);
        createRepository(V2_REPO, "fs", v2RepoSettings(v2RepoPath));
        ensureGreen(indexName);
        Settings hot = Settings.builder()
        createWarmDFAIndex(warmDFA, 20);
                    fc.clear();
import org.opensearch.snapshots.SnapshotState;
            .prepareCreateSnapshot(V2_REPO, "v2-warm-mix")
     * <ul>
            .build();
        ensureGreen(indexName);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .put(remoteStoreIndexSettings(0, 1))
 *   <li><b>Block A</b> ({@code SnapshotsService.createSnapshotV2}): warm-tiered DFA indexes are
import org.opensearch.core.common.unit.ByteSizeValue;
    }
        return Settings.builder()
            .cluster()
 *
