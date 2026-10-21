        ensureStableCluster(4);
            .cluster()
        logger.info("--> making sure snapshot delete works out cleanly");
        createRandomIndex(idxName);
 *
            builders[i] = client().prepareIndex(idxName).setId(Integer.toString(i)).setSource("field1", "bar " + i);
/*
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        final SnapshotInfo successfulSnapshotInfo = successfulSnapshot.getSnapshotInfo();
 * license agreements. See the NOTICE file distributed with
        unblockAllDataNodes(repoName);
    private void assertSnapshotExists(String repository, String snapshot) {
        logger.info("--> indexing some data");
import static org.hamcrest.Matchers.endsWith;
import org.opensearch.test.transport.MockTransportService;
        final String repoName = "test-repo";
        internalCluster().startClusterManagerOnlyNodes(3);
        try {
        final ActionFuture<CreateSnapshotResponse> snapshotFuture = client(clusterManagerNode).admin()
                either(endsWith(" Failed to update cluster state during snapshot finalization")).or(endsWith(" no longer cluster-manager"))
        ClusterService clusterService = internalCluster().clusterService(clusterManagerNode1);
import org.opensearch.snapshots.SnapshotInfo;
            .setWaitForCompletion(true)
import static org.hamcrest.Matchers.is;
 * The OpenSearch Contributors require contributions made to
        index(idxName, "type", JsonXContent.contentBuilder().startObject().field("foo", "bar").endObject());
 * Licensed to Elasticsearch under one or more contributor
        ensureStableCluster(3, dataNode);
import org.opensearch.snapshots.mockstore.MockRepository;
            .setWaitForCompletion(true)
        assertEquals(0, snapshotInfo.failedShards());
        assertThat(snapshotInfo.state(), is(SnapshotState.PARTIAL));
            .execute();
            } catch (SnapshotMissingException exception) {
 */
                }
import org.opensearch.test.OpenSearchIntegTestCase;
import java.util.Arrays;
import org.opensearch.snapshots.SnapshotState;
        logger.info("--> starting snapshot");
package org.opensearch.discovery;
            }
            .cluster()
/*
    }
        internalCluster().startDataOnlyNode();
        ensureStableCluster(2);
import org.opensearch.snapshots.SnapshotMissingException;
            .cluster()
        ActionFuture<CreateSnapshotResponse> future = client(clusterManagerNode1).admin()
    }
                    }
        blockAllDataNodes(repoName);
        SnapshotInfo snapshotInfo = snapshotsStatusResponse.getSnapshots().get(0);
            .setIndices(idxName)
import java.util.Collection;
import org.opensearch.snapshots.SnapshotException;
            .setSnapshots(snapshot)
                logger.info("--> done verifying, snapshot doesn't exist");
 * the Apache License, Version 2.0 (the "License"); you may
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFutureThrows;
        final String repoName = "test-repo";
                    final SnapshotsInProgress.Entry snapshotEntry = snapshots.entries().get(0);
                            clusterService.removeListener(this);
        awaitNoMoreRunningOperations(dataNode);
        createIndex(indexName);
            @Override
        final ActionFuture<CreateSnapshotResponse> snapshotResponse = internalCluster().clusterManagerClient()
            .prepareGetSnapshots(repository)
        internalCluster().setDisruptionScheme(networkDisruption);
        }
        for (int i = 0; i < builders.length; i++) {
import org.opensearch.common.unit.TimeValue;
import java.util.concurrent.TimeUnit;
        return Arrays.asList(MockTransportService.TestPlugin.class, MockRepository.Plugin.class);
            assertNotNull(sne);
            .execute();
    public void testDisruptionAfterFinalization() throws Exception {
import org.opensearch.cluster.service.ClusterService;
        final String idxName = "test";
    @Override
        logger.info("--> waiting for disruption to start");
        final String snapshot = "test-snap";
        assertTrue(disruptionStarted.await(1, TimeUnit.MINUTES));
            .setWaitForCompletion(true)
 *    http://www.apache.org/licenses/LICENSE-2.0
                        final RepositoryMetadata metadata = repoMeta.repository("test-repo");
        internalCluster().startClusterManagerOnlyNodes(3);
 */
            assertThat(sne.getSnapshotName(), is(snapshot));
        createRepository(repoName, "mock");
            .cluster()
        unblockNode(repoName, dataNode);
        ensureStableCluster(4, clusterManagerNode1);
        GetSnapshotsResponse snapshotsStatusResponse = dataNodeClient().admin()
            () -> snapshotResponse.actionGet(TimeValue.timeValueSeconds(30L))
                            networkDisruption.startDisrupting();
        final CreateSnapshotResponse successfulSnapshot = client(clusterManagerNode).admin()
 * software distributed under the License is distributed on an
        waitForBlock(clusterManagerNode, repoName, TimeValue.timeValueSeconds(10L));
        final String snapshot = "test-snap";
            .prepareCreateSnapshot(repoName, "test-snap")
        waitForBlockOnAnyDataNode(repoName, TimeValue.timeValueSeconds(10L));
 * Tests snapshot operations during disruptions.
 * SPDX-License-Identifier: Apache-2.0
    private void createRandomIndex(String idxName) throws InterruptedException {
        networkDisruption.stopDisrupting();
import java.util.concurrent.CountDownLatch;
        ensureStableCluster(2, clusterManagerNode);
        final CreateSnapshotResponse createSnapshotResponse = future.get();
 * specific language governing permissions and limitations
                            logger.info("--> starting disruption");
 * GitHub history for details.
        networkDisruption.stopDisrupting();
import org.opensearch.ExceptionsHelper;
}
    public void testDisruptionAfterShardFinalization() throws Exception {
        logger.info("--> done verifying, snapshot exists");
        CountDownLatch disruptionStarted = new CountDownLatch(1);
        logger.info("--> stopping disrupting");
        clusterService.addListener(new ClusterStateListener() {
        );
            .prepareCreateSnapshot(repoName, "snapshot-2")
                        if (metadata.pendingGeneration() > snapshotEntry.repositoryStateId()) {
        logger.info("--> stopping disrupting");
                    if (snapshotEntry.state() == SnapshotsInProgress.State.SUCCESS) {
        final SnapshotException sne = expectThrows(
        client().prepareIndex(indexName).setSource("foo", "bar").get();
 */
        networkDisruption.stopDisrupting();
            .cluster()
    @Override
        logger.info("--> recreate the index with potentially different shard counts");
        createIndex(idxName);
        assertAcked(client().admin().cluster().prepareDeleteSnapshot(repoName, "snapshot-2").get());
        createRepository(repoName, "mock");
        final String dataNode = internalCluster().startDataOnlyNode();
 *
 * compatible open source license.
        internalCluster().setDisruptionScheme(networkDisruption);
            .admin()
        NetworkDisruption networkDisruption = isolateClusterManagerDisruption(NetworkDisruption.UNRESPONSIVE);
import org.opensearch.snapshots.AbstractSnapshotIntegTestCase;
            .setWaitForCompletion(true)
    }
        logger.info("--> verify that snapshot was successful or no longer exist");
        assertBusy(() -> {
import org.opensearch.cluster.metadata.RepositoryMetadata;
        }
        assertAcked(prepareCreate(idxName, 0, indexSettingsNoReplicas(between(1, 5))));
 * KIND, either express or implied.  See the License for the
        indexRandom(true, builders);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            assertThat(
            fail("Should have failed because the node disconnected from the cluster during snapshot finalization");
        createRepository("test-repo", "fs");
        assertEquals(snapshotInfo.totalShards(), snapshotInfo.successfulShards());
        final NetworkDisruption networkDisruption = isolateClusterManagerDisruption(NetworkDisruption.DISCONNECT);
        logger.info("--> create a snapshot expected to be successful");
        final SnapshotInfo snapshotInfo = createSnapshotResponse.getSnapshotInfo();
        logger.info("--> make sure isolated cluster-manager responds to snapshot request");
        logger.info("--> run a snapshot that fails to finalize but succeeds on the data node");
 */
        ActionFuture<CreateSnapshotResponse> future = client(clusterManagerNode).admin()
        final String indexName = "index-one";
    }
        internalCluster().setDisruptionScheme(networkDisruption);
            .get();
import static org.hamcrest.Matchers.either;
        networkDisruption.startDisrupting();
                        }
        assertEquals(SnapshotState.SUCCESS, snapshotInfo.state());
                        final RepositoriesMetadata repoMeta = event.state().metadata().custom(RepositoriesMetadata.TYPE);
        blockDataNode(repoName, dataNode);
                assertSnapshotExists("test-repo", snapshot);
 * Unless required by applicable law or agreed to in writing,
            try {
        blockClusterManagerFromFinalizingSnapshotOnIndexFile(repoName);
        logger.info("--> done");
    protected Settings nodeSettings(int nodeOrdinal) {
            public void clusterChanged(ClusterChangedEvent event) {
    }
import org.opensearch.common.action.ActionFuture;
        NetworkDisruption networkDisruption = isolateClusterManagerDisruption(NetworkDisruption.DISCONNECT);
 *
 * under the License.
        IndexRequestBuilder[] builders = new IndexRequestBuilder[numdocs];
import org.opensearch.cluster.ClusterStateListener;
        final String clusterManagerNode = internalCluster().getClusterManagerName();
        awaitNoMoreRunningOperations(dataNode);
 * this file be licensed under the Apache-2.0 license or a
        ensureStableCluster(4);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            future.get();
            final SnapshotException sne = (SnapshotException) ExceptionsHelper.unwrap(ex, SnapshotException.class);
        return Settings.builder().put(super.nodeSettings(nodeOrdinal)).put(AbstractDisruptionTestCase.DEFAULT_SETTINGS).build();
import org.opensearch.test.disruption.NetworkDisruption;
public class SnapshotDisruptionIT extends AbstractSnapshotIntegTestCase {
    }
        assertThat(sne.getMessage(), endsWith("no longer cluster-manager"));
        index(idxName, "type", JsonXContent.contentBuilder().startObject().field("foo", "bar").endObject());
            .get();
import org.opensearch.common.xcontent.json.JsonXContent;
        assertFutureThrows(snapshotFuture, SnapshotException.class);
        awaitNoMoreRunningOperations(dataNode);
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
                if (snapshots != null && snapshots.entries().size() > 0) {
        final String clusterManagerNode1 = internalCluster().getClusterManagerName();
    }
                sne.getMessage(),
        client().admin().indices().prepareDelete(idxName).get();
            .execute();
import org.opensearch.cluster.ClusterChangedEvent;
        final int numdocs = randomIntBetween(10, 100);
                            disruptionStarted.countDown();
        logger.info("--> create snapshot via cluster-manager node client");
import org.opensearch.action.index.IndexRequestBuilder;
            .setWaitForCompletion(true)
        final String dataNode = internalCluster().startDataOnlyNode();
/**
        logger.info("--> starting snapshot");
        }, 1, TimeUnit.MINUTES);
 * Modifications Copyright OpenSearch Contributors. See
            }
            );
            .cluster()
        unblockNode(repoName, clusterManagerNode);
        createIndex(idxName);
import org.opensearch.cluster.metadata.RepositoriesMetadata;
            .prepareCreateSnapshot(repoName, snapshot)
        assertThat(successfulSnapshotInfo.state(), is(SnapshotState.SUCCESS));
    protected Collection<Class<? extends Plugin>> nodePlugins() {
 * ownership. Elasticsearch licenses this file to you under
            .execute();
        internalCluster().startClusterManagerOnlyNodes(1);
            .prepareCreateSnapshot(repoName, "snapshot-2")
            SnapshotException.class,
        networkDisruption.startDisrupting();
        final String idxName = "test";
                SnapshotsInProgress snapshots = event.state().custom(SnapshotsInProgress.TYPE);
/*
        } catch (Exception ex) {
        });
    public void testClusterManagerFailOverDuringShardSnapshots() throws Exception {
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsResponse;
import org.opensearch.common.settings.Settings;
import org.opensearch.plugins.Plugin;
        waitForBlock(dataNode, repoName, TimeValue.timeValueSeconds(30L));
        logger.info("--> done");
            .prepareCreateSnapshot("test-repo", snapshot)
import org.opensearch.cluster.SnapshotsInProgress;
 * You may obtain a copy of the License at
