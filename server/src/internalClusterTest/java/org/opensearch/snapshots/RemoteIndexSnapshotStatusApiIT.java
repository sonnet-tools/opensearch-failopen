            return client().admin().cluster().prepareSnapshotStatus(repoName).setSnapshots(snapshotName).get().getSnapshots().get(0);
    public void setup() {
        final Settings remoteStoreEnabledIndexSettings = getRemoteStoreBackedIndexSettings();
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
public class RemoteIndexSnapshotStatusApiIT extends AbstractSnapshotIntegTestCase {
    private static SnapshotStatus getSnapshotStatus(String repoName, String snapshotName) {
        assertThat(shallowSnapshotShardState.getStage(), is(SnapshotIndexShardStage.DONE));
        logger.info("Set MAX_SHARDS_ALLOWED_IN_STATUS_API to a low value");
 */
 * GitHub history for details.
import java.nio.file.Path;
        for (int i = 0; i < 100; i++) {
        createIndex(index3, remoteStoreEnabledIndexSettings);
                .setIndices(index1, index2)
            assertShallowV2SnapshotStatus(snapshotStatusWithIndexFilter, true);
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotIndexShardStatus;
        logger.info("--> indexing some data");
    @Override
            assertEquals(0, snapshotIndexStatus.getStats().getIncrementalFileCount());
            index(remoteStoreEnabledIndexName, "_doc", Integer.toString(i), "foo", "bar" + i);
                .setSnapshots(snapshot)
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotIndexShardStage;
        }
        final long totalSize = shallowSnapshotShardState.getStats().getTotalSize();
        logger.info("--> wait for snapshot to finish");
        }
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotStatus;
        createRepository(snapshotRepoName, "fs", snapshotV2RepoSettings);
        SnapshotInfo snapshotInfo = createFullSnapshot(snapshotRepoName, snapshot);
        final String snapshotRepoName = "snapshot-repo-name";
        createIndex(remoteStoreEnabledIndexName, remoteStoreEnabledIndexSettings);
        ensureGreen();
 * under the License.
            index(index1, "_doc", Integer.toString(i), "foo", "bar" + i);
        } else {
 * Licensed to Elasticsearch under one or more contributor
 * KIND, either express or implied.  See the License for the
                .actionGet()
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotIndexStatus;
        logger.info("--> snapshot");
        }
        internalCluster().startDataOnlyNodes(2, pinnedTimestampSettings);
        unblockAllDataNodes(snapshotRepoName);
        assertBusy(() -> {
        final int incrementalFileCount = shallowSnapshotShardState.getStats().getIncrementalFileCount();
            SnapshotStatus snapshotStatusWithoutIndexFilter = client().admin()
        assertTrue(snapshotInfo.getPinnedTimestamp() > 0); // to assert creation of a shallow v2 snapshot
    }
        disableRepoConsistencyCheck("Remote store repository is being used for the test");
        }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        assertEquals(0, snapshotStatus.getStats().getTotalFileCount());
package org.opensearch.snapshots;
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
import static org.hamcrest.Matchers.is;
    final String remoteStoreRepoName = "remote-store-repo-name";
                assertEquals(SnapshotIndexShardStage.DONE, snapshotIndexShardStatus.getStage());
            throw new AssertionError(e);
        if (hasIndexFilter) {
        shallowSnapshotShardState = stateFirstShard(snapshotStatus, remoteStoreEnabledIndexName);
        final int totalFileCount = shallowSnapshotShardState.getStats().getTotalFileCount();
        }, 1, TimeUnit.MINUTES);
 * software distributed under the License is distributed on an
        final long incrementalSize = shallowSnapshotShardState.getStats().getIncrementalSize();
    public void testStatusAPICallForShallowCopySnapshot() throws Exception {
        createIndex(index2, remoteStoreEnabledIndexSettings);
 *
        final SnapshotStatus snapshotStatus = getSnapshotStatus(snapshotRepoName, snapshot);
        }
 * You may obtain a copy of the License at
        assertEquals(
 * this work for additional information regarding copyright
 */
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to
        final String remoteStoreEnabledIndexName = "remote-index-1";
import org.opensearch.cluster.SnapshotsInProgress;
        createRepository(snapshotRepoName, "fs", snapshotRepoSettingsForShallowCopy());
            assertEquals(0, snapshotStatus.getStats().getTotalSize());
        createFullSnapshot(snapshotRepoName, "test-snap-1");
            // with index filter
        Settings.Builder snapshotV2RepoSettings = snapshotRepoSettingsForShallowCopy().put(
                assertEquals(0, snapshotIndexShardStatus.getStats().getIncrementalFileCount());
import org.opensearch.repositories.blobstore.BlobStoreRepository;
                assertEquals(0, snapshotIndexShardStatus.getStats().getTotalFileCount());
 *    http://www.apache.org/licenses/LICENSE-2.0
        snapshotStatus = getSnapshotStatus(snapshotRepoName, "test-snap-2");
/*
 * Modifications Copyright OpenSearch Contributors. See
                .execute()
import org.opensearch.common.action.ActionFuture;
 */
import org.opensearch.indices.RemoteStoreSettings;
        SnapshotStatus snapshotStatus = getSnapshotStatus(snapshotRepoName, "test-snap-1");
import static org.hamcrest.Matchers.equalTo;
                .getSnapshots()
            assertShallowV2SnapshotStatus(snapshotStatusWithoutIndexFilter, false);
            assertEquals(0, snapshotIndexStatus.getStats().getTotalSize());
        Settings pinnedTimestampSettings = Settings.builder()
 *
import org.junit.Before;
            .build();
        internalCluster().startClusterManagerOnlyNode();
        for (int i = 0; i < 100; i++) {
 * SPDX-License-Identifier: Apache-2.0
        final String snapshot = "snapshot";
    }
    public void testStatusAPIStatsForBackToBackShallowSnapshot() throws Exception {
import org.opensearch.common.settings.Settings;
import static org.opensearch.snapshots.SnapshotsService.MAX_SHARDS_ALLOWED_IN_STATUS_API;
        createIndex(remoteStoreEnabledIndexName, remoteStoreEnabledIndexSettings);
        assert (getLockFilesInRemoteStore(remoteStoreEnabledIndexName, remoteStoreRepoName).length == 1);
        createFullSnapshot(snapshotRepoName, "test-snap-2");
            index(index3, "_doc", Integer.toString(i), "foo", "bar" + i);
        logger.info("Indexing some data");
                .prepareSnapshotStatus(snapshotRepoName)
        assertThat(snapshotStatus.getState(), is(SnapshotsInProgress.State.SUCCESS));
        ensureGreen();
                .actionGet()
 * compatible open source license.
            SnapshotIndexStatus snapshotIndexStatus = entry.getValue();
        logger.info("Create repository for shallow V2 snapshots");
            assertEquals(0, snapshotIndexStatus.getStats().getIncrementalSize());
        for (int i = 0; i < 50; i++) {
        for (Map.Entry<String, SnapshotIndexStatus> entry : snapshotStatus.getIndices().entrySet()) {
                assertEquals(0, snapshotIndexShardStatus.getStats().getIncrementalSize());
            }
        final Settings remoteStoreEnabledIndexSettings = getRemoteStoreBackedIndexSettings();
        disableRepoConsistencyCheck("Remote store repository is being used for the test");
            index(index2, "_doc", Integer.toString(i), "foo", "bar" + i);
import static org.opensearch.remotestore.RemoteStoreBaseIntegTestCase.remoteStoreClusterSettings;
        awaitNumberOfSnapshotsInProgress(1);
    }
        createRepository(snapshotRepoName, "mock", snapshotRepoSettingsForShallowCopy().put("block_on_data", true));
    }
        updateSettingsRequest.persistentSettings(Settings.builder().put(MAX_SHARDS_ALLOWED_IN_STATUS_API.getKey(), 2));
        internalCluster().startDataOnlyNodes(2);
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        refresh();
                // shard level
        internalCluster().startClusterManagerOnlyNode();
        assertThat(shallowSnapshotShardState.getStats().getIncrementalFileCount(), equalTo(incrementalFileCount));
        assertEquals(0, snapshotStatus.getStats().getIncrementalSize());
        createIndex(index1, remoteStoreEnabledIndexSettings);
 * ownership. Elasticsearch licenses this file to you under
        ensureGreen();
            // without index filter
        );
            index(remoteStoreEnabledIndexName, "_doc", Integer.toString(i), "foo", "bar" + i);
            // although no. of shards in snapshot (3) is greater than the max value allowed in a status api call, the request does not fail
        createFullSnapshot(snapshotRepoName, snapshot);
        disableRepoConsistencyCheck("Remote store repository is being used for the test");
            SnapshotStatus snapshotStatusWithIndexFilter = client().admin()
import org.opensearch.threadpool.ThreadPool;
        // Validating that the incremental file count and incremental file size is zero for shallow copy
    }
                assertEquals(0, snapshotIndexShardStatus.getStats().getTotalSize());
import org.opensearch.test.OpenSearchIntegTestCase;
        final String remoteStoreEnabledIndexName = "remote-index-1";
        internalCluster().startDataOnlyNodes(2);
        assertThat(snapshotStatus.getState(), is(SnapshotsInProgress.State.SUCCESS));
/*
        logger.info("--> wait for data nodes to get blocked");
        assertEquals(0, snapshotStatus.getStats().getIncrementalFileCount());
        final String index2 = "remote-index-2";
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
        SnapshotIndexShardStatus shallowSnapshotShardState = stateFirstShard(snapshotStatus, remoteStoreEnabledIndexName);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertThat(shallowSnapshotShardState.getStats().getTotalFileCount(), equalTo(totalFileCount));
            // TODO: after adding primary store size at the snapshot level, total size here should be > 0
    private static SnapshotIndexShardStatus stateFirstShard(SnapshotStatus snapshotStatus, String indexName) {
                .setSnapshots(snapshot)
import java.util.Map;
        final String snapshotRepoName = "snapshot-repo-name";
        logger.info("--> unblock all data nodes");
        assertThat(shallowSnapshotShardState.getStats().getTotalFileCount(), greaterThan(0));
                .getSnapshots()
            .put(super.nodeSettings(nodeOrdinal))
        final String snapshotRepoName = "snapshot-repo-name";
        internalCluster().startDataOnlyNodes(2);
                .prepareSnapshotStatus(snapshotRepoName)
        final SnapshotIndexShardStatus shallowSnapshotShardState = stateFirstShard(snapshotStatus, remoteStoreEnabledIndexName);
            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED.getKey(), true)
    protected Path absolutePath;
            index(remoteStoreEnabledIndexName, "_doc", Integer.toString(i), "foo", "bar" + i);
}
        createIndex(remoteStoreEnabledIndexName, remoteStoreEnabledIndexSettings);
        createRepository(snapshotRepoName, "fs", snapshotRepoSettingsForShallowCopy());
    protected Settings nodeSettings(int nodeOrdinal) {
                .getSnapshots()
        final String index1 = "remote-index-1";
                .getState()
                .get(0);
        }
                .cluster()
        } catch (SnapshotMissingException e) {
        final String snapshotRepoName = "snapshot-repo-name";
 * Unless required by applicable law or agreed to in writing,
import java.util.concurrent.TimeUnit;
 * specific language governing permissions and limitations
        }
        assertThat(snapshotStatus.getState(), is(SnapshotsInProgress.State.SUCCESS));
 *
    public void testStatusAPICallForShallowV2Snapshot() throws Exception {
            .build();
        createSnapshotResponseActionFuture.actionGet();
        assert (getLockFilesInRemoteStore(remoteStoreEnabledIndexName, remoteStoreRepoName).length == 1);
        ActionFuture<CreateSnapshotResponse> createSnapshotResponseActionFuture = startFullSnapshot(snapshotRepoName, "test-snap");
            for (SnapshotIndexShardStatus snapshotIndexShardStatus : snapshotStatus.getShards()) {
        final Settings remoteStoreEnabledIndexSettings = getRemoteStoreBackedIndexSettings();
        refresh();
                .setSnapshots("test-snap")
            .put(ThreadPool.ESTIMATED_TIME_INTERVAL_SETTING.getKey(), 0) // We have tests that check by-timestamp order
        logger.info("--> indexing some data");
            BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(),
    }
        for (int i = 0; i < 100; i++) {
        return snapshotStatus.getIndices().get(indexName).getShards().get(0);
                .get(0);
 * the Apache License, Version 2.0 (the "License"); you may
        final String remoteStoreEnabledIndexName = "remote-index-1";
                .cluster()
        try {
        return Settings.builder()
 * this file be licensed under the Apache-2.0 license or a
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        assertThat(shallowSnapshotShardState.getStage(), is(SnapshotIndexShardStage.DONE));
    public void testStatusAPICallInProgressShallowSnapshot() throws Exception {
        assert (getLockFilesInRemoteStore(remoteStoreEnabledIndexName, remoteStoreRepoName).length == 2);
        assertThat(shallowSnapshotShardState.getStats().getTotalSize(), equalTo(totalSize));
        assertThat(shallowSnapshotShardState.getStats().getIncrementalFileCount(), is(0));
            assertEquals(0, snapshotIndexStatus.getStats().getTotalFileCount());
        refresh();
    }
                .cluster()
        final String index3 = "remote-index-3";
            .put(remoteStoreClusterSettings(remoteStoreRepoName, absolutePath))
                .get()
        );
            // index level
                .execute()
 * not use this file except in compliance with the License.
        refresh();
    }
        logger.info("--> indexing some data");
import static org.hamcrest.Matchers.greaterThan;
            Boolean.TRUE
                .get(0)
    private void assertShallowV2SnapshotStatus(SnapshotStatus snapshotStatus, boolean hasIndexFilter) {
        absolutePath = randomRepoPath().toAbsolutePath();
    }
        // assert that total and incremental values of file count and size_in_bytes are 0 at index and shard levels
            SnapshotsInProgress.State.STARTED,
        final Settings remoteStoreEnabledIndexSettings = getRemoteStoreBackedIndexSettings();
            client().admin()
/*
                .prepareSnapshotStatus(snapshotRepoName)
        assertThat(shallowSnapshotShardState.getStats().getTotalSize(), greaterThan(0L));
        final String snapshot = "snapshot";
        disableRepoConsistencyCheck("Remote store repository is being used for the test");
        ensureGreen();
    @Before
        assertThat(shallowSnapshotShardState.getStats().getIncrementalSize(), is(0L));
        assertThat(shallowSnapshotShardState.getStats().getIncrementalSize(), equalTo(incrementalSize));
        internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings);
        internalCluster().startClusterManagerOnlyNode();
