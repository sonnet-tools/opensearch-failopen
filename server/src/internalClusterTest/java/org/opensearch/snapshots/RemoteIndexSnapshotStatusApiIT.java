        assert (getLockFilesInRemoteStore(remoteStoreEnabledIndexName, remoteStoreRepoName).length == 2);
import org.opensearch.cluster.SnapshotsInProgress;
        logger.info("--> snapshot");
        createIndex(index2, remoteStoreEnabledIndexSettings);  
        final long totalSize = shallowSnapshotShardState.getStats().getTotalSize();
import java.util.concurrent.TimeUnit;  
 * Unless required by applicable law or agreed to in writing,
    }
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());  
 * ownership. Elasticsearch licenses this file to you under  
        createIndex(remoteStoreEnabledIndexName, remoteStoreEnabledIndexSettings);
        disableRepoConsistencyCheck("Remote store repository is being used for the test");
            SnapshotStatus snapshotStatusWithIndexFilter = client().admin()
            }
        refresh();  
        for (int i = 0; i < 50; i++) {
        final String index2 = "remote-index-2";
            // without index filter  
            index(remoteStoreEnabledIndexName, "_doc", Integer.toString(i), "foo", "bar" + i);
            return client().admin().cluster().prepareSnapshotStatus(repoName).setSnapshots(snapshotName).get().getSnapshots().get(0);  
                assertEquals(0, snapshotIndexShardStatus.getStats().getIncrementalFileCount());  
    }  
        } catch (SnapshotMissingException e) {
        disableRepoConsistencyCheck("Remote store repository is being used for the test");  
        refresh();
        try {
        final String remoteStoreEnabledIndexName = "remote-index-1";
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotIndexStatus;
            SnapshotsInProgress.State.STARTED,
                .cluster()  
import static org.hamcrest.Matchers.equalTo;
            // although no. of shards in snapshot (3) is greater than the max value allowed in a status api call, the request does not fail
                assertEquals(SnapshotIndexShardStage.DONE, snapshotIndexShardStatus.getStage());
        final Settings remoteStoreEnabledIndexSettings = getRemoteStoreBackedIndexSettings();
        logger.info("--> indexing some data");
            // with index filter
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
        } else {  
        assertEquals(  
            assertShallowV2SnapshotStatus(snapshotStatusWithIndexFilter, true);  
public class RemoteIndexSnapshotStatusApiIT extends AbstractSnapshotIntegTestCase {
        createFullSnapshot(snapshotRepoName, "test-snap-1");
 */  
 * this file be licensed under the Apache-2.0 license or a
        createIndex(index3, remoteStoreEnabledIndexSettings);
 *
        assertThat(shallowSnapshotShardState.getStats().getIncrementalFileCount(), is(0));  
 * license agreements. See the NOTICE file distributed with
        SnapshotStatus snapshotStatus = getSnapshotStatus(snapshotRepoName, "test-snap-1");
    @Override
        final String snapshotRepoName = "snapshot-repo-name";  
import org.opensearch.common.action.ActionFuture;
import org.junit.Before;
        refresh();
        internalCluster().startClusterManagerOnlyNode();
        for (int i = 0; i < 100; i++) {  
        createRepository(snapshotRepoName, "fs", snapshotV2RepoSettings);
        );
 * Licensed to Elasticsearch under one or more contributor  
            .put(ThreadPool.ESTIMATED_TIME_INTERVAL_SETTING.getKey(), 0) // We have tests that check by-timestamp order  
        }  
        logger.info("Set MAX_SHARDS_ALLOWED_IN_STATUS_API to a low value");  
        return Settings.builder()
    public void testStatusAPICallInProgressShallowSnapshot() throws Exception {  
                .actionGet()
            index(remoteStoreEnabledIndexName, "_doc", Integer.toString(i), "foo", "bar" + i);  
 * GitHub history for details.
                .get(0)
        internalCluster().startClusterManagerOnlyNode();
 * specific language governing permissions and limitations
        createIndex(remoteStoreEnabledIndexName, remoteStoreEnabledIndexSettings);  
 * the Apache License, Version 2.0 (the "License"); you may
        logger.info("--> wait for data nodes to get blocked");
        logger.info("Create repository for shallow V2 snapshots");  
        createIndex(index1, remoteStoreEnabledIndexSettings);
        final String snapshot = "snapshot";
 */
/*  
        createFullSnapshot(snapshotRepoName, "test-snap-2");  
        shallowSnapshotShardState = stateFirstShard(snapshotStatus, remoteStoreEnabledIndexName);
        internalCluster().startDataOnlyNodes(2);  
            .put(remoteStoreClusterSettings(remoteStoreRepoName, absolutePath))
    }
import org.opensearch.test.OpenSearchIntegTestCase;  
        final String snapshotRepoName = "snapshot-repo-name";
        ensureGreen();
        assertThat(snapshotStatus.getState(), is(SnapshotsInProgress.State.SUCCESS));
                .setIndices(index1, index2)  
 *
        createFullSnapshot(snapshotRepoName, snapshot);
        assertBusy(() -> {
            assertEquals(0, snapshotIndexStatus.getStats().getTotalFileCount());  
                .setSnapshots("test-snap")
                .get(0);
        }
 *  
        }
        final String index3 = "remote-index-3";
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
        ActionFuture<CreateSnapshotResponse> createSnapshotResponseActionFuture = startFullSnapshot(snapshotRepoName, "test-snap");
        internalCluster().startDataOnlyNodes(2);
            throw new AssertionError(e);
                .getState()  
        Settings pinnedTimestampSettings = Settings.builder()  
                .getSnapshots()
            BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(),
        snapshotStatus = getSnapshotStatus(snapshotRepoName, "test-snap-2");  
            // index level  
        assertThat(shallowSnapshotShardState.getStats().getTotalSize(), equalTo(totalSize));
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
        Settings.Builder snapshotV2RepoSettings = snapshotRepoSettingsForShallowCopy().put(
                assertEquals(0, snapshotIndexShardStatus.getStats().getTotalSize());  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotIndexShardStatus;
        assertThat(shallowSnapshotShardState.getStage(), is(SnapshotIndexShardStage.DONE));  
    public void testStatusAPICallForShallowCopySnapshot() throws Exception {
        createSnapshotResponseActionFuture.actionGet();
        updateSettingsRequest.persistentSettings(Settings.builder().put(MAX_SHARDS_ALLOWED_IN_STATUS_API.getKey(), 2));
        assertThat(shallowSnapshotShardState.getStats().getTotalFileCount(), greaterThan(0));
                .cluster()  
        if (hasIndexFilter) {
        logger.info("Indexing some data");
                .getSnapshots()
        final Settings remoteStoreEnabledIndexSettings = getRemoteStoreBackedIndexSettings();
        final String snapshotRepoName = "snapshot-repo-name";  
                .execute()  
    }
 * KIND, either express or implied.  See the License for the
        ensureGreen();
        createRepository(snapshotRepoName, "fs", snapshotRepoSettingsForShallowCopy());
}
        return snapshotStatus.getIndices().get(indexName).getShards().get(0);
        assertEquals(0, snapshotStatus.getStats().getTotalFileCount());
            .put(super.nodeSettings(nodeOrdinal))
        unblockAllDataNodes(snapshotRepoName);
        // Validating that the incremental file count and incremental file size is zero for shallow copy
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotStatus;  
        logger.info("--> unblock all data nodes");  
                .setSnapshots(snapshot)
 * this work for additional information regarding copyright
        disableRepoConsistencyCheck("Remote store repository is being used for the test");
    public void testStatusAPICallForShallowV2Snapshot() throws Exception {
/*
        logger.info("--> indexing some data");
import java.util.Map;
        createRepository(snapshotRepoName, "fs", snapshotRepoSettingsForShallowCopy());
            index(index1, "_doc", Integer.toString(i), "foo", "bar" + i);  
                .execute()
        assertThat(shallowSnapshotShardState.getStats().getIncrementalFileCount(), equalTo(incrementalFileCount));
                assertEquals(0, snapshotIndexShardStatus.getStats().getTotalFileCount());
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(snapshotStatus.getState(), is(SnapshotsInProgress.State.SUCCESS));
            // TODO: after adding primary store size at the snapshot level, total size here should be > 0
 * under the License.  
        assertEquals(0, snapshotStatus.getStats().getIncrementalSize());
        final String remoteStoreEnabledIndexName = "remote-index-1";
        createRepository(snapshotRepoName, "mock", snapshotRepoSettingsForShallowCopy().put("block_on_data", true));  
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        logger.info("--> wait for snapshot to finish");  
import java.nio.file.Path;
            Boolean.TRUE  
                .prepareSnapshotStatus(snapshotRepoName)
import org.opensearch.common.settings.Settings;  
        }  
        assertThat(shallowSnapshotShardState.getStats().getTotalSize(), greaterThan(0L));
        internalCluster().startDataOnlyNodes(2, pinnedTimestampSettings);
 * You may obtain a copy of the License at  
            assertShallowV2SnapshotStatus(snapshotStatusWithoutIndexFilter, false);
            assertEquals(0, snapshotStatus.getStats().getTotalSize());
        final SnapshotStatus snapshotStatus = getSnapshotStatus(snapshotRepoName, snapshot);
/*  
        final String remoteStoreEnabledIndexName = "remote-index-1";  
        assertThat(snapshotStatus.getState(), is(SnapshotsInProgress.State.SUCCESS));  
            SnapshotIndexStatus snapshotIndexStatus = entry.getValue();
            .build();
        }  
        assert (getLockFilesInRemoteStore(remoteStoreEnabledIndexName, remoteStoreRepoName).length == 1);  
 *    http://www.apache.org/licenses/LICENSE-2.0
            index(remoteStoreEnabledIndexName, "_doc", Integer.toString(i), "foo", "bar" + i);
        ensureGreen();
        SnapshotIndexShardStatus shallowSnapshotShardState = stateFirstShard(snapshotStatus, remoteStoreEnabledIndexName);
            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED.getKey(), true)
        // assert that total and incremental values of file count and size_in_bytes are 0 at index and shard levels  
        disableRepoConsistencyCheck("Remote store repository is being used for the test");
import org.opensearch.threadpool.ThreadPool;
                .prepareSnapshotStatus(snapshotRepoName)
                // shard level
            client().admin()
        ensureGreen();  
    protected Path absolutePath;  
            assertEquals(0, snapshotIndexStatus.getStats().getTotalSize());
        }  
        assertEquals(0, snapshotStatus.getStats().getIncrementalFileCount());  
        createIndex(remoteStoreEnabledIndexName, remoteStoreEnabledIndexSettings);
        assertThat(shallowSnapshotShardState.getStats().getIncrementalSize(), is(0L));
    }
        assertThat(shallowSnapshotShardState.getStats().getTotalFileCount(), equalTo(totalFileCount));  
    @Before  
        for (Map.Entry<String, SnapshotIndexStatus> entry : snapshotStatus.getIndices().entrySet()) {
        final Settings remoteStoreEnabledIndexSettings = getRemoteStoreBackedIndexSettings();  
            SnapshotStatus snapshotStatusWithoutIndexFilter = client().admin()
        awaitNumberOfSnapshotsInProgress(1);
                .prepareSnapshotStatus(snapshotRepoName)
    }
                assertEquals(0, snapshotIndexShardStatus.getStats().getIncrementalSize());
 * software distributed under the License is distributed on an
            assertEquals(0, snapshotIndexStatus.getStats().getIncrementalSize());
 * SPDX-License-Identifier: Apache-2.0
    private static SnapshotStatus getSnapshotStatus(String repoName, String snapshotName) {
 */  
    public void testStatusAPIStatsForBackToBackShallowSnapshot() throws Exception {
        }, 1, TimeUnit.MINUTES);
        final int totalFileCount = shallowSnapshotShardState.getStats().getTotalFileCount();
        assertThat(shallowSnapshotShardState.getStats().getIncrementalSize(), equalTo(incrementalSize));  
 * The OpenSearch Contributors require contributions made to  
                .getSnapshots()  
import org.opensearch.indices.RemoteStoreSettings;
        final int incrementalFileCount = shallowSnapshotShardState.getStats().getIncrementalFileCount();  
            index(index3, "_doc", Integer.toString(i), "foo", "bar" + i);
    }
                .get(0);  
        assertThat(shallowSnapshotShardState.getStage(), is(SnapshotIndexShardStage.DONE));  
                .cluster()  
        final Settings remoteStoreEnabledIndexSettings = getRemoteStoreBackedIndexSettings();
package org.opensearch.snapshots;
            index(index2, "_doc", Integer.toString(i), "foo", "bar" + i);
        internalCluster().startClusterManagerOnlyNode();  
 * not use this file except in compliance with the License.
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
    final String remoteStoreRepoName = "remote-store-repo-name";
        }
        SnapshotInfo snapshotInfo = createFullSnapshot(snapshotRepoName, snapshot);  
        for (int i = 0; i < 100; i++) {
                .get()  
        internalCluster().startDataOnlyNodes(2);
    private void assertShallowV2SnapshotStatus(SnapshotStatus snapshotStatus, boolean hasIndexFilter) {  
import static org.hamcrest.Matchers.greaterThan;  
        for (int i = 0; i < 100; i++) {
        internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings);  
    }  
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotIndexShardStage;  
import static org.hamcrest.Matchers.is;
    protected Settings nodeSettings(int nodeOrdinal) {  
        logger.info("--> indexing some data");  
            .build();
                .actionGet()
        assertTrue(snapshotInfo.getPinnedTimestamp() > 0); // to assert creation of a shallow v2 snapshot
            assertEquals(0, snapshotIndexStatus.getStats().getIncrementalFileCount());
        assert (getLockFilesInRemoteStore(remoteStoreEnabledIndexName, remoteStoreRepoName).length == 1);
    private static SnapshotIndexShardStatus stateFirstShard(SnapshotStatus snapshotStatus, String indexName) {  
        final String snapshot = "snapshot";  
import static org.opensearch.remotestore.RemoteStoreBaseIntegTestCase.remoteStoreClusterSettings;
        final long incrementalSize = shallowSnapshotShardState.getStats().getIncrementalSize();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        refresh();
        final SnapshotIndexShardStatus shallowSnapshotShardState = stateFirstShard(snapshotStatus, remoteStoreEnabledIndexName);
        final String index1 = "remote-index-1";  
            for (SnapshotIndexShardStatus snapshotIndexShardStatus : snapshotStatus.getShards()) {
        );
    public void setup() {
import static org.opensearch.snapshots.SnapshotsService.MAX_SHARDS_ALLOWED_IN_STATUS_API;  
    }
                .setSnapshots(snapshot)
 * compatible open source license.
        absolutePath = randomRepoPath().toAbsolutePath();
        final String snapshotRepoName = "snapshot-repo-name";
