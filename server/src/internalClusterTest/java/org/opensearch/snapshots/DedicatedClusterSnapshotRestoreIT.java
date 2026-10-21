                SnapshottableGatewayMetadata::readDiffFrom,
import java.util.Set;
        assertThat(
        );
        @Override
                .execute()
import org.opensearch.core.common.io.stream.Writeable;
import java.nio.file.Files;
        assertTrue(indexExists("test-idx-none"));
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotStatus;
        awaitClusterState(
    public static class NonSnapshottableGatewayMetadata extends TestCustomMetadata {
        logger.info("--> change custom persistent metadata");
        assertAcked(
        ensureStableCluster(1);
    public void testDataNodeRestartWithBusyClusterManagerDuringSnapshot() throws Exception {
        indexRandomDocs("test-idx-some", 100);
            SnapshotInfo snapshotInfo = getSnapshot("test-repo", "test-snap-2");
        assertFutureThrows(
                createSnapshotResponse.getSnapshotInfo().state(),
        @Override
            .prepareDeleteSnapshot("test-repo", "test-snap")
        response = clusterAdmin().prepareSnapshotStatus(repositoryName).setSnapshots(snapshot1).get();
        assertAcked(client().admin().indices().prepareClose(indexName));
            registerMetadataCustom(
        createRepository(repoName, "fs");
        public static NonSnapshottableGatewayMetadata fromXContent(XContentParser parser) throws IOException {
        createRepository("test-repo", "fs");
        assertThat(restoreSnapshotResponse.getRestoreInfo().successfulShards(), equalTo(6));
            assertBusy(() -> {
        assertThat(
        public NonSnapshottableGatewayMetadata(String data) {
        }, Setting.Property.NodeScope, Setting.Property.Dynamic);
        assertThat(metadata.custom(SnapshottableMetadata.TYPE), nullValue());
        SnapshotInfo snapshotInfo = waitForCompletion("test-repo", "test-snap", TimeValue.timeValueSeconds(60));
                .setIgnoreUnavailable(true)
        clusterAdmin().prepareRestoreSnapshot("test-repo-2", "test-snap")
            if (randomBoolean()) {
            client().admin().indices().prepareForceMerge("test-idx").setMaxNumSegments(1).setFlush(true).get().getFailedShards(),
                metadataBuilder.putCustom(SnapshottableMetadata.TYPE, new SnapshottableMetadata("after_snapshot_s"));
    }
        internalCluster().startClusterManagerOnlyNode();
        final String repo = "test-repo";
            namedXContents.add(new NamedXContentRegistry.Entry(Metadata.Custom.class, new ParseField(name), parser));
                throw new UncheckedIOException(e);
            assertThat(snapshotInfo.shardFailures(), hasSize(2));
            OpenSearchIntegTestCase.putRepositoryRequestBuilder(
        @Override
                metadataBuilder.putCustom(SnapshottableGatewayMetadata.TYPE, new SnapshottableGatewayMetadata("after_snapshot_s_gw"));
                .setSettings(Settings.builder().put("index.blocks.write", true))
        client(internalCluster().getClusterManagerName()).admin()
        } else {
                .prepareUpdateSettings()
        createRepository(repositoryName, "fs", repoPath);
        };
            return fromXContent(NonSnapshottableGatewayMetadata::new, parser);
            metadataBuilder.putCustom(NonSnapshottableGatewayMetadata.TYPE, new NonSnapshottableGatewayMetadata("before_snapshot_ns_gw"));
        }, nodeClient);
        public List<NamedXContentRegistry.Entry> getNamedXContent() {
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotStats;
        @Override
            SnapshotInfo snapshotInfo = snapshotsStatusResponse.getSnapshots().get(0);
        logger.info("--> wait for snapshot to complete");
                false
        }
        createRepository(repoName, "fs");
                    }
 * this work for additional information regarding copyright
                .actionGet()
    }
        @Override
        final CountDownLatch clusterStateLatch = new CountDownLatch(1);
        Consumer<String> assertSettingValue = value -> {
            if ((s.equals("default") == false && breakSetting)) {
        }
            .setWaitForCompletion(true)
        public Version getMinimalSupportedVersion() {
        public static final String TYPE = "test_non_snapshottable";
                .setIndices("test-idx-all", "test-idx-none", "test-idx-some", "test-idx-closed")
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsResponse;
                NonSnapshottableMetadata::readDiffFrom,
                greaterThanOrEqualTo(1)
        createSnapshot(repo, snapshot, Collections.singletonList(shrunkIdx));
        assertThat(anotherStats.getTotalSize(), greaterThanOrEqualTo(snapshot1FileSize));
        createRepository(repositoryName, "fs", repoPath);
            60L,
        createRepository("test-repo", "fs", tempDir);
        assertThat(restoreSnapshotResponse.getRestoreInfo().failedShards(), equalTo(0));
 * Modifications Copyright OpenSearch Contributors. See
        }
 *
        Files.walkFileTree(repoPath.resolve("indices"), new SimpleFileVisitor<Path>() {
            ) {
        logger.info("--> restore the shrunk index and ensure all shards are allocated");
                DiscoveryNode node,
                    clusterStateError.set(ex);
            } else {
        }
                return super.visitFile(file, attrs);
            List<SnapshotStatus> snapshotStatuses = snapshotsStatusResponse.getSnapshots();
            registerMetadataCustom(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertThat(snapshot1IndexMetaFiles, is(snapshot0IndexMetaFiles));
            return TYPE;
        }
        final List<Path> snapshot3IndexMetaFiles = findRepoMetaBlobs(repoPath);
        snapshotFilesDiff.removeAll(snapshot0Files);
            TestCustomMetadataPlugin.class,
        String blockedNode = blockNodeWithIndex("test-repo", "test-idx");
                .getRestoreInfo()
            return fromXContent(SnapshotableGatewayNoApiMetadata::new, parser);
            final int extraDocCount = iterations(10, 1000);
        assertBusy(() -> {
            assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(10));
        logger.info("--> restart random data node and add new data node to change index allocation");
            return namedXContents;
        docs = between(1, 5);
    }
        public EnumSet<Metadata.XContentContext> context() {
        return Arrays.asList(
        for (int i = 0; i < snapshotDocCount; i++) {
        });
        assertNotEquals(snapshotInfo.totalShards(), snapshotInfo.successfulShards());
import java.util.concurrent.CountDownLatch;
                reusedShards.add(recoveryState.getShardId().getId());
                clusterStateLatch.countDown();
        List<Path> snapshot0Files = scanSnapshotFolder(repoPath);
        public TestCustomMetadataPlugin() {
                .actionGet();
                }
        logger.info("--> done");
        if (randomBoolean()) {
        logger.info("--> stopping data node {}", dataNode);
        List<Path> files = new ArrayList<>();
        ensureGreen();
        final String snapshot1 = "snapshot-1";
                    .get();
    public static class SnapshottableGatewayMetadata extends TestCustomMetadata {
        createSnapshot(repoName, snapshotName, Collections.singletonList(indexName));
            .cluster()
            .findFirst()
        final List<Path> snapshot0IndexMetaFiles = findRepoMetaBlobs(repoPath);
        logger.info("--> create an index that will have all allocated shards");
            logger.info(
import org.opensearch.repositories.RepositoryMissingException;
                    .getShardsStats()
        ServiceDisruptionScheme disruption = new BusyClusterManagerServiceDisruption(random(), Priority.HIGH);
        internalCluster().startClusterManagerOnlyNode();
            assertEquals(1, snapshotsStatusResponse.getSnapshots().size());
                .setWaitForEvents(Priority.LANGUID)
            1L,
        stopNode(blockedNode);
        stopNode(blockedNode);
    }
        createIndex("some-index");
import java.util.HashSet;
        @Override
                Settings.builder().put("location", randomRepoPath()),
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        }
            .filter(s -> s.getShardRouting().shardId().equals(shardId))
            .execute();
 * not use this file except in compliance with the License.
                .execute()
            .get()
            return builder.build();
            .findFirst()
import org.opensearch.core.common.Strings;
        assertAcked(client().admin().indices().prepareResizeIndex(sourceIdx, shrunkIdx).get());
            ClusterState.Builder builder = ClusterState.builder(currentState);
        assertThat(stats.getIncrementalFileCount(), equalTo(stats.getProcessedFileCount()));
    }
                SnapshotsStatusResponse snapshotsStatusResponse = clusterAdmin().prepareSnapshotStatus("test-repo")
    /**
        internalCluster().startNode(nonClusterManagerNode());
            return TYPE;
            return fromXContent(SnapshottableMetadata::new, parser);
        // Shouldn't be returned as part of API response
    public void testRetentionLeasesClearedOnRestore() throws Exception {
        metadata = clusterState.getMetadata();
        assertThat(snapshotInfo.failedShards(), greaterThan(0));
        SnapshotsStatusResponse response = clusterAdmin().prepareSnapshotStatus(repo)
        unblockNode("test-repo", dataNode);
            .get("test-idx");
        assertThat(((NonSnapshottableMetadata) metadata.custom(NonSnapshottableMetadata.TYPE)).getData(), equalTo("after_snapshot_ns"));
        logger.info("--> wait until the snapshot is done");
        for (int i = 0; i < docs; i++) {
            assertThat(getSnapshot("test-repo", "test-snap-2").state(), equalTo(SnapshotState.PARTIAL));
                .setSnapshots("test-snap-2")
        disableRepoConsistencyCheck("This test leaves behind a purposely broken repository");
        );
        public static NamedDiff<Metadata.Custom> readDiffFrom(StreamInput in) throws IOException {
        logger.info("--> done");
        Path repo = randomRepoPath();
    }
        );
        internalCluster().startNode();
                .setPersistentSettings(Settings.builder().put(BrokenSettingPlugin.BROKEN_SETTING.getKey(), value))
        for (SnapshotShardFailure failure : snapshotInfo.shardFailures()) {
            assertThat(createSnapshotResponse.getSnapshotInfo().totalShards(), equalTo(22));
            }
            assertBusy(() -> {
        public Version getMinimalSupportedVersion() {
import static org.hamcrest.Matchers.nullValue;
        // Pick one node and block it
        logger.info("--> create an index that will have some unallocated shards");
            .get();
                .put("location", randomRepoPath())
        assertSettingValue.accept("new value 2");
        createIndex(indexName);
        logger.info("--> check that gateway-persistent custom metadata survived full cluster restart");
                    .setSnapshots("test-snap-2")
        final ShardStats shardStats = Arrays.stream(client().admin().indices().prepareStats(indexName).get().getShards())
            logger.info("checking snapshot completion using wait_for_completion flag");
import static org.hamcrest.Matchers.hasSize;
        if (clusterStateError.get() != null) {
        // Wait for snapshot process to complete to prevent conflict with repository clean up
        logger.info("--> create an index that will have some unallocated shards");
        indexRandomDocs("test-idx", randomIntBetween(10, 100));
            .getRetentionLeaseStats()
        SnapshotStats anotherStats = snapshots.get(0).getStats();
            public void sendResponse(RestResponse response) {
import org.opensearch.Version;
        assertBusy(
                .setPartial(true)
            equalTo(false)
        }
        @Override
        clusterAdmin().prepareCreateSnapshot("test-repo", "test-snap-2")
        final Path repoPath = randomRepoPath();
            }
        assertAcked(prepareCreate(indexName, 2, indexSettingsNoReplicas(between(2, 10))));
        internalCluster().startNode();
        createRepository("test-repo", "fs");
                .setIgnoreUnavailable(true)
            () -> assertThat(
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.action.ActionFuture;
            .actionGet();
        ensureGreen();
            .get()
import org.opensearch.test.InternalTestCluster;
        assertThat(restoreResponse.getRestoreInfo().failedShards(), equalTo(0));
            assertAcked(deleteSnapshotResponseFuture.actionGet());
            .get();
    public void testPartialSnapshotAllShardsMissing() throws Exception {
            assertThat(snapshotStatus.getShardsStats().getDoneShards(), lessThan(16));
        logger.info("--> waiting for block to kick in");
import org.opensearch.action.index.IndexRequestBuilder;
            clusterAdmin().prepareHealth()
                .setWaitForActiveShards(ActiveShardCount.NONE)
        // The IndexMetadata did not change between snapshots, verify that no new redundant IndexMetaData was written to the repository
    }
                .get()
        logger.info("--> change the test persistent setting and break it");
            .setIndices("test-idx")
        internalCluster().startNodes(2);
    }
        }
            assertNotNull(failure.reason());
import java.util.EnumSet;
        return files.stream().mapToLong(f -> {
        logger.info("-->  restarting second data node, which should cause the primary shard on it to be failed");
        for (int i = 0; i < docs; i++) {
        waitForBlock(blockedNode, "test-repo", TimeValue.timeValueSeconds(60));
    public void testSnapshotWithStuckNode() throws Exception {
            }
        internalCluster().startDataOnlyNodes(2);
        logger.info("--> execution was blocked on node [{}], shutting it down", blockedNode);
                    .setRoutingTable(false)
            registerMetadataCustom(
        clusterAdmin().prepareCreateSnapshot(repoName, "test-snap")
            }
        ).get();
        } catch (SnapshotMissingException ex) {
                SnapshotableGatewayNoApiMetadata.TYPE,
                final String fileName = file.getFileName().toString();
                clusterAdmin().prepareSnapshotStatus("test-repo")
        }
        public static NamedDiff<Metadata.Custom> readDiffFrom(StreamInput in) throws IOException {
import org.opensearch.cluster.ClusterState;
            equalTo("after_snapshot_ns_gw")
            return TYPE;
            }, 1, TimeUnit.MINUTES);
        assertAcked(
        internalCluster().startNodes(2);
        clusterAdmin().prepareHealth().setTimeout("30s").setWaitForNodes("1");
     */
import org.opensearch.common.settings.SettingsFilter;
        logger.info("delete index during snapshot creation");
import org.opensearch.transport.client.node.NodeClient;
        final ActionFuture<AcknowledgedResponse> deleteResponse = startDeleteSnapshot(repoName, snapshotName);
            .get();
            ((NonSnapshottableGatewayMetadata) metadata.custom(NonSnapshottableGatewayMetadata.TYPE)).getData(),
            .cluster()
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), equalTo(6));
                    .actionGet()
        final int snapshotDocCount = iterations(10, 1000);
import static org.hamcrest.Matchers.equalTo;
                    if (PeerRecoveryTargetService.Actions.FILE_CHUNK.equals(action)) {
import org.opensearch.common.util.concurrent.ThreadContext;
        final Path repoPath = randomRepoPath();
    public void testDeduplicateIndexMetadata() throws Exception {
        logger.info("-->  snapshot");
import java.nio.file.SimpleFileVisitor;
import static org.hamcrest.Matchers.not;
        logger.info("--> delete repository");
        logger.info("-->  starting two cluster-manager nodes and two data nodes");
        ensureYellow();
        logger.info("--> make sure that properly setup repository can be registered on all nodes");
        );
            client.admin()
            BrokenSettingPlugin.breakSetting = breakSetting;
            "mock",
        public SnapshotableGatewayNoApiMetadata(String data) {
        logger.debug("--> indexing {} docs into {}", snapshotDocCount, indexName);
        logger.info("--> start relocations");
            final CreateSnapshotResponse createSnapshotResponse = clusterAdmin().prepareCreateSnapshot("test-repo", "test-snap-2")
import org.opensearch.index.seqno.RetentionLeases;
        );
            return builder.build();
        // Wait for green so the close does not fail in the edge case of coinciding with a shard recovery that hasn't fully synced yet
                equalTo(value)
            .setIndices("test-idx-some")
        assertSettingValue.accept("new value 2");
 * license agreements. See the NOTICE file distributed with
        assertThat(anotherStats.getIncrementalFileCount(), greaterThanOrEqualTo(snapshotFilesDiff.size()));
    public static class TestCustomMetadataPlugin extends Plugin {
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
        logger.info("--> start first node");
        }
            SnapshotInfo snapshotInfo = snapshotsStatusResponse.getSnapshots().get(0);
        assertThat(getSnapshot("test-repo", "test-snap").state(), equalTo(SnapshotState.SUCCESS));
    @Override
        public static SnapshottableGatewayMetadata readFrom(StreamInput in) throws IOException {
        }
        internalCluster().stopCurrentClusterManagerNode();
                    .get(0)
    public void testClusterManagerAndDataShutdownDuringSnapshot() throws Exception {
            .setWaitForCompletion(true)
        });
    }
            ClusterState.Builder builder = ClusterState.builder(currentState);
        // add few docs - less than initially
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
                .execute()
        for (int i = 0; i < docs; i++) {
        public static SnapshotableGatewayNoApiMetadata readFrom(StreamInput in) throws IOException {
        SnapshotInfo snapshotInfo = getSnapshot("test-repo", "test-snap");
        final String repo = "repo";
            super(data);
                return true;
            assertThat(
            return Version.CURRENT;
            "mock",
        RestoreSnapshotResponse restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap-2")
import java.util.ArrayList;
        // But should still be in state
        logger.info("-->  restarting first data node, which should cause the primary shard on it to be failed");
            super(data);
            equalTo(RestStatus.OK)
import org.opensearch.index.remote.RemoteStoreEnums;
        final Path repoPath = randomRepoPath();
import org.opensearch.common.CheckedFunction;
        assertThat(snapshot1IndexMetaFiles, is(snapshot0IndexMetaFiles));
        ensureGreen();
            .execute()
        // create another snapshot
        logger.info("--> start two nodes");
        assertThat(
    public void testRestoreCustomMetadata() throws Exception {
                .actionGet();
        final String repoName = "test-repo";
                .put(BlobStoreRepository.SHARD_PATH_TYPE.getKey(), RemoteStoreEnums.PathType.FIXED)
        restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap-2")
        }
        public static NonSnapshottableMetadata fromXContent(XContentParser parser) throws IOException {
        logger.info("--> start node");
        assertThat(stats.getIncrementalSize(), equalTo(stats.getProcessedSize()));
        disruption.startDisrupting();
                long requestId,
        // Expect two files to remain in the repository:
        createIndex("test-idx");
            .setWaitForCompletion(true)
    }
        internalCluster().restartRandomDataNode();
        }
            .setIndices("test-idx")
            }
        public Version getMinimalSupportedVersion() {
        final String expression2 = nameExpressionResolver.resolveDateMathExpression(snapshotName);
        try {
            // completely stopping. In this case the retried delete snapshot operation on the new cluster-manager can fail
        final String indexName = "index-retention-leases";
        createRepository("test-repo", "mock", repoPath);
        }
        logger.info("--> stopping cluster-manager node {} ", clusterManagerNode);
import org.opensearch.test.transport.MockTransportService;
        logger.info("--> start a new data node");
        logger.info("--> start 2 nodes");
            metadataBuilder.putCustom(NonSnapshottableMetadata.TYPE, new NonSnapshottableMetadata("before_snapshot_ns"));
        assertAcked(startDeleteSnapshot(repositoryName, snapshot0).get());
        }
        docs = between(1, 5);
        for (int i = 0; i < docs; i++) {
                    .prepareState()
        }
            .cluster()
        cluster().wipeIndices("test-idx-some");
        indexRandom(true, indexRequestBuilders);
        logger.info("-->  restarting data node, which should cause primary shards to be failed");
        final ShardId shardId = new ShardId(resolveIndex(indexName), randomIntBetween(0, shardCount - 1));
        final List<Path> snapshot2IndexMetaFiles = findRepoMetaBlobs(repoPath);
        // The IndexMetadata did not change between snapshots, verify that no new redundant IndexMetaData was written to the repository
        }
    }
        assertThat(anotherStats.getTotalFileCount(), greaterThanOrEqualTo(snapshot1FileCount));
        assertThat(createSnapshotResponse.getSnapshotInfo().state(), is(SnapshotState.PARTIAL));
                .setWaitForCompletion(false)
        );
            .setIndices("test-idx")
 * KIND, either express or implied.  See the License for the
        indexRandomDocs("test-idx", 100);
import static org.hamcrest.Matchers.allOf;
            return EnumSet.of(Metadata.XContentContext.GATEWAY, Metadata.XContentContext.SNAPSHOT);
        assertThat(restoreSnapshotResponse.getRestoreInfo(), notNullValue());
        assertThat(stats.getIncrementalSize(), equalTo(stats.getTotalSize()));
    @AwaitsFix(bugUrl = "https://github.com/elastic/elasticsearch/issues/37485")
            .get();
                    .get()
            .setPartial(true)
    public void testDataNodeRestartAfterShardSnapshotFailure() throws Exception {
        @Override
            .setIndices("test-idx")
    }
        snapshots = response.getSnapshots();
            .retentionLeases();
        final String repositoryName = "repo-" + indexName;
            .get();
                .isTimedOut(),
            client.admin()
                client.admin()
import org.opensearch.indices.recovery.RecoveryState;
 * You may obtain a copy of the License at
        private <T extends Metadata.Custom> void registerMetadataCustom(
            }
        indexRandomDocs("test-idx", randomIntBetween(50, 100));
            registerMetadataCustom(
        restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap-2")
            .setWaitForCompletion(true)
                    .setSnapshots("test-snap")
        logger.info("--> check that custom persistent metadata was restored");
        int numberOfShards = 6;
                .put(MockRepository.Plugin.PASSWORD_SETTING.getKey(), "verysecretpassword")
            assertTrue(snapshotInfo.state().completed());
        public String getWriteableName() {
        RestoreSnapshotResponse restoreResponse = clusterAdmin().prepareRestoreSnapshot(repoName, snapshotName)
        assertAcked(clusterAdmin().prepareDeleteRepository("test-repo"));
        SnapshotInfo snapshotInfo = getSnapshot("test-repo", "test-snap");
        String blockedNode = blockNodeWithIndex("test-repo", "test-idx");
        final String dataNode = internalCluster().startDataOnlyNode();
                "mock",
    public void testThatSensitiveRepositorySettingsAreNotExposed() throws Exception {
        logger.info("--> create an index that will have no allocated shards");
        blockAllDataNodes(repoName);
            return Collections.singletonList(BROKEN_SETTING);
                }
        assertAcked(client().admin().indices().prepareDelete(sourceIdx).get());
        public static NonSnapshottableGatewayMetadata readFrom(StreamInput in) throws IOException {
            metadataBuilder.putCustom(SnapshottableMetadata.TYPE, new SnapshottableMetadata("before_snapshot_s"));
        cluster().wipeIndices("test-idx-none");
            equalTo("before_snapshot_s_gw")
            .setWaitForCompletion(false)
        logger.info("--> check that at least half of the shards had some reuse: [{}]", reusedShards);
            .setIgnoreUnavailable(true)
        logger.info("number of shards: {}", numberOfShards);
            () -> client().admin().cluster().prepareGetSnapshots("test-repo").setSnapshots("test-snap").execute().actionGet()
        final String repositoryName = "repo-" + indexName;
}
        }
        logger.info("number of shards: {}", numberOfShards);
        createFullSnapshot(repositoryName, snapshot0);
                TransportRequest request,
import org.opensearch.common.unit.TimeValue;
                    assertThat(response.content().utf8ToString(), not(containsString("verysecretpassword")));
                    throw new AssertionError("Node had no assigned shard snapshots so it shouldn't send out shard state updates");
        int docs = between(10, 100);
        assertAcked(prepareCreate("test-idx", 0, indexSettingsNoReplicas(between(1, 20))));
        private static boolean breakSetting = false;
        metadata = internalCluster().getInstance(ClusterService.class).state().metadata();
        internalCluster().startDataOnlyNodes(2);
        final String otherDataNode = internalCluster().startDataOnlyNode();
        final ActionFuture<CreateSnapshotResponse> snapshotResponse = startFullSnapshot(repoName, snapshotName);
        for (int i = 0; i < docs; i++) {
        );
        clusterAdmin().prepareCreateSnapshot("test-repo", "test-snap").setWaitForCompletion(false).setIndices("test-idx").get();
        );
        final String dataNode = blockNodeWithIndex("test-repo", "test-idx");
        ensureGreen("test-idx");
        ensureGreen();
        clusterAdmin().prepareHealth().setTimeout("30s").setWaitForNodes("2");
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
        public EnumSet<Metadata.XContentContext> context() {
        assertAcked(client().admin().indices().prepareClose("test-idx-all"));
import org.opensearch.cluster.node.DiscoveryNode;
        logger.info("--> restore snapshot for the partial index");
        assertThat(anotherStats.getIncrementalSize(), greaterThanOrEqualTo(calculateTotalFilesSize(snapshotFilesDiff)));
    }
        }
            );
            clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap-1")
            GetSnapshotsResponse snapshotsStatusResponse = clusterAdmin().prepareGetSnapshots("test-repo")
        final SnapshotException sne = expectThrows(
        static final Setting<String> BROKEN_SETTING = new Setting<>("setting.broken", "default", s -> s, s -> {
 *
        }
        assertThat(stats.getTotalSize(), greaterThanOrEqualTo(snapshot0FileSize));
        }
        assertAcked(client().admin().indices().prepareDelete(indexName));
            true,
        });
                (connection, requestId, action, request, options) -> {
                .execute()
    public void testAbortWaitsOnDataNode() throws Exception {
        createRepository(repo, "fs", Settings.builder().put("location", randomRepoPath()).put("compress", randomBoolean()));
        assertThat(clusterAdmin().prepareGetRepositories("test-repo-2").get().repositories().size(), equalTo(1));
        logger.info("--> execution was blocked on node [{}], aborting snapshot", blockedNode);
                throw EXCEPTION;
            @Override
        createRepository("test-repo", "fs");
        logger.info("--> restart all nodes");
            logger.debug("--> indexing {} extra docs into {}", extraDocCount, indexName);
            }
import org.opensearch.test.disruption.ServiceDisruptionScheme;
                    connection.sendRequest(requestId, action, request, options);
        assertThat(
            .prepareCreateSnapshot("test-repo", "test-snap")
        // Drop all file chunk requests so that below relocation takes forever and we're guaranteed to run the snapshot in parallel to it
        logger.info("--> start 2 nodes");
import org.opensearch.core.common.io.stream.StreamInput;
        );
 * software distributed under the License is distributed on an
            return readDiffFrom(TYPE, in);
        assertTrue(shardStats + ": " + retentionLeases, retentionLeases.contains(leaseId));
        );
        assertAcked(prepareCreate("test-idx", 1, indexSettingsNoReplicas(1)));
        assertAcked(client().admin().indices().prepareDelete(shrunkIdx).get());
                SnapshotableGatewayNoApiMetadata::readFrom,
        assertAcked(prepareCreate("test-idx-closed", 1, indexSettingsNoReplicas(4)));
                NonSnapshottableMetadata::readFrom,
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        indexRandomDocs("test-idx-closed", 100);
 * Licensed to Elasticsearch under one or more contributor
        internalCluster().startDataOnlyNodes(2);
import org.opensearch.core.index.shard.ShardId;
            builder.metadata(metadataBuilder);
        ArrayList<Path> snapshotFilesDiff = new ArrayList<>(snapshot1Files);
            .cluster()
                assertEquals(SnapshotState.PARTIAL, snapshotInfo.state());
        final String snapshotName = "snapshot-retention-leases";
        logger.info("--> making sure that snapshot no longer exists");
        // total size has to grow and has to be equal to files on fs
        final Settings dataSettings = Settings.builder()
            state -> state.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY)
    public void testRestoreIndexWithShardsMissingInLocalGateway() throws Exception {
                .get();
        logger.info("--> verify that snapshot was partial");
    }
        Client client = client();
        for (RecoveryState recoveryState : recoveryStates) {
        internalCluster().stopRandomDataNode();
import org.opensearch.core.ParseField;
                .setWaitForCompletion(true)
                TransportRequestOptions finalOptions
            registerMetadataCustom(
        assertThat(restoreSnapshotResponse.getRestoreInfo().failedShards(), equalTo(0));
        logger.info("--> shrink the index");
        restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap-2")
import java.util.Arrays;
            // There is slight delay between snapshot being marked as completed in the cluster state and on the file system
import org.opensearch.transport.TransportRequestOptions;
        );
        }
        assertThat(snapshot0IndexMetaFiles, hasSize(1)); // snapshotting a single index
        maybeInitWithOldSnapshotVersion("test-repo", repoPath);
        final RetentionLeases retentionLeases = shardStats.getRetentionLeaseStats().retentionLeases();
        public String getWriteableName() {
        disruption.stopDisrupting();
            return Version.CURRENT;
        setSettingValue.accept("new value 2");
        index(indexName, "_doc", "some_id", "foo", "bar");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFutureThrows;
            BrokenSettingPlugin.class,
                SnapshotInfo snapshotInfo = getSnapshot("test-repo", "test-snap-2");
            public void sendResponse(RestResponse response) {
            throw getRepoError.get();
        final AtomicReference<AssertionError> getRepoError = new AtomicReference<>();
        final List<String> dataNodes = internalCluster().startDataOnlyNodes(2);
        // Remove it from the list of available nodes
                    .setNodes(false)
        }
        // check that snapshot completes
    }
        logger.info("--> wait until the snapshot is done");
            60L,
            equalTo("before_snapshot_s_gw")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertRequestBuilderThrows;
                .actionGet()
                .actionGet();
                    files.add(file);
        assertThat(snapshots, hasSize(1));
            } catch (IOException e) {
        }
            indexRequestBuilders = new IndexRequestBuilder[extraDocCount];
        );
            SnapshotStatus snapshotStatus = snapshotStatuses.get(0);
            TimeUnit.MINUTES
import static org.hamcrest.Matchers.notNullValue;
        List<RecoveryState> recoveryStates = client().admin()
        assertThat(sne.getMessage(), containsString("Indices don't have primary shards"));
            .indices()
            assertThat(snapshotStatus.getShardsStats().getDoneShards(), greaterThan(10));
        }
        public static final String TYPE = "test_snapshottable_gateway_no_api";
import org.opensearch.cluster.NamedDiff;
        ensureGreen("test-idx");
                    .get(BrokenSettingPlugin.BROKEN_SETTING.getKey()),
        logger.info("--> close the index");
 */
    }
        assertAcked(client().admin().indices().prepareCreate(indexName).setSettings(indexSettingsNoReplicas(shardCount)));
                .actionGet();
import org.opensearch.common.Priority;
        final List<Path> snapshot1Files = scanSnapshotFolder(repoPath);
        assertThat(restoreSnapshotResponse.getRestoreInfo(), notNullValue());
        );
            throw clusterStateError.get();
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), equalTo(4));
        }).sum();
        }
        @Override
        createFullSnapshot("test-repo", "test-snap");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            .setIndices("test-idx")
        NodeClient nodeClient = internalCluster().getInstance(NodeClient.class);
            assertTrue(snapshotInfo.state().toString(), snapshotInfo.state().completed());
                .get();
import java.io.IOException;
                null,
        assertDocCount("test-idx-closed", 100L);
        assertEquals(0, snapshotInfo.failedShards());
        assertThat(
        final String sourceIdx = "test-idx";
        IndexRequestBuilder[] indexRequestBuilders = new IndexRequestBuilder[snapshotDocCount];
                .setRestoreGlobalState(true)
            MockRepository.Plugin.class,
    public void testClusterManagerShutdownDuringSnapshot() throws Exception {
        assertThat(stats.getTotalFileCount(), greaterThanOrEqualTo(snapshot0FileCount));
            .setWaitForCompletion(false)
        logger.info("-->  wait for shard snapshot of first primary to show as failed");
            ((NonSnapshottableGatewayMetadata) metadata.custom(NonSnapshottableGatewayMetadata.TYPE)).getData(),
 * this file be licensed under the Apache-2.0 license or a
        public static SnapshottableGatewayMetadata fromXContent(XContentParser parser) throws IOException {
            return EnumSet.of(Metadata.XContentContext.API, Metadata.XContentContext.SNAPSHOT, Metadata.XContentContext.GATEWAY);
        List<Path> files = new ArrayList<>();
        // Pick one node and block it
            super(data);
        assertAcked(prepareCreate("test-idx", 2, indexSettingsNoReplicas(2)));
            .setWaitForCompletion(true)
import java.util.Collections;
    }
            ).get();
            );
            @Override
        createRepository("test-repo", "fs", repoPath);
        nodes.remove(blockedNode);
                indexRequestBuilders[i] = client().prepareIndex(indexName).setSource("field", "value");
        logger.info("--> restore snapshot for the closed index that was snapshotted completely");
                SnapshottableMetadata::readDiffFrom,
        updateClusterState(currentState -> {
        // Create index on two nodes and make sure each node has a primary by setting no replicas
            namedWritables.add(new NamedWriteableRegistry.Entry(Metadata.Custom.class, name, reader));
        final int snapshot1FileCount = snapshot1Files.size();
            .get();
                    .getFailedShards(),
    public void testSnapshotWithDateMath() {
        waitForBlock(blockedNode, "test-repo", TimeValue.timeValueSeconds(60));
        assertThat(restoreSnapshotResponse.getRestoreInfo().successfulShards(), equalTo(0));
        @Override
                metadataBuilder.removeCustom(SnapshottableGatewayMetadata.TYPE);
        private final List<NamedWriteableRegistry.Entry> namedWritables = new ArrayList<>();
        logger.info("--> shutdown one of the nodes that should make half of the shards unavailable");
            return readFrom(NonSnapshottableGatewayMetadata::new, in);
        public String getWriteableName() {
 *
        RestRequest getRepoRequest = new FakeRestRequest();
import java.nio.file.Path;
        public String getWriteableName() {
            TimeUnit.SECONDS
            MockTransportService.TestPlugin.class
            return Metadata.API_AND_GATEWAY;
            otherDataNode,
public class DedicatedClusterSnapshotRestoreIT extends AbstractSnapshotIntegTestCase {
        internalCluster().startNode();
            assertThat(snapshotInfo.totalShards(), is(2));
        logger.debug("--> restore index {} from snapshot", indexName);
        ) {
        List<String> nodes = internalCluster().startNodes(2);
        ensureGreen();
            }
        public static NamedDiff<Metadata.Custom> readDiffFrom(StreamInput in) throws IOException {
        logger.info("--> snapshot");
            );
    }
        ensureGreen();
import org.opensearch.transport.TransportMessageListener;
            @Override
            return readFrom(NonSnapshottableMetadata::new, in);
    private static List<Path> findRepoMetaBlobs(Path repoPath) throws IOException {
                if (fileName.startsWith(BlobStoreRepository.METADATA_PREFIX) && fileName.endsWith(".dat")) {
        logger.info("-->  starting three cluster-manager nodes and two data nodes");
        assertAcked(prepareCreate("test-idx", 2, indexSettingsNoReplicas(2)));
        final String indexName = "test-idx";
        });
            CheckedFunction<XContentParser, T, IOException> parser
        internalCluster().stopCurrentClusterManagerNode();
            .setPartial(true)
                // TODO: There's likely a bug with other path types where cleanup seems to leave unexpected files
        assertAcked(client().admin().indices().prepareClose("test-idx"));
        logger.info("--> snapshot");
            equalTo("after_snapshot_ns_gw")
                } catch (AssertionError ex) {
            client().prepareIndex(indexName).setSource("test", "init").execute().actionGet();
        int docs = between(10, 100);
            @Override
        final long snapshot1FileSize = calculateTotalFilesSize(snapshot1Files);
    }
            equalTo(6)
        logger.info("-->  starting a cluster-manager node and two data nodes");
        assertThat(restoreSnapshotResponse.getRestoreInfo().successfulShards(), allOf(greaterThan(0), lessThan(6)));
        public static SnapshottableMetadata fromXContent(XContentParser parser) throws IOException {
            if (recoveryState.getIndex().reusedBytes() > 0) {
        );
            Writeable.Reader<NamedDiff> diffReader,
        assertThat(snapshotResponse.get().getSnapshotInfo().state(), is(SnapshotState.FAILED));
    public void testSnapshotDuringNodeShutdown() throws Exception {
            @Override
        client().execute(RetentionLeaseActions.Add.INSTANCE, new RetentionLeaseActions.AddRequest(shardId, leaseId, RETAIN_ALL, "test"))
import org.opensearch.node.Node;
                .setIndices("test-idx-all", "test-idx-none", "test-idx-some", "test-idx-closed")
        assertEquals(restoreResponse.getRestoreInfo().totalShards(), restoreResponse.getRestoreInfo().successfulShards());
            .setIndices("test-idx-none")
            .setIndices("test-idx-all")
                    .get()
        assertEquals(
            assertThat(snapshotStatus.getShardsStats().getTotalShards(), equalTo(22));
                    .getShardsStats()
        createRepository(repoName, "fs");
                .cluster()
        }
            return readDiffFrom(TYPE, in);
            return readFrom(SnapshotableGatewayNoApiMetadata::new, in);
import org.opensearch.common.settings.Setting;
                NonSnapshottableGatewayMetadata.TYPE,
        };
import org.opensearch.test.rest.FakeRestRequest;
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), equalTo(6));
        }
        final String snapshotName = "<snapshot-{now/d}>";
        ActionFuture<AcknowledgedResponse> deleteSnapshotResponseFuture = internalCluster().client(nodes.get(0))
        logger.info("--> delete index and stop the data node");
        assertThat(snapshots, hasSize(1));
        internalCluster().restartNode(dataNodes.get(1), InternalTestCluster.EMPTY_CALLBACK);
                clusterAdmin(),
        clusterAdmin().prepareDeleteSnapshot("test-repo", "test-snap-delete").execute();
        public SnapshottableMetadata(String data) {
                if (blocked.get() && action.equals(SnapshotsService.UPDATE_SNAPSHOT_STATUS_ACTION_NAME)) {
        client(internalCluster().getClusterManagerName()).admin()
        clusterAdmin().prepareCleanupRepository("test-repo").get();
        assertAcked(prepareCreate("test-idx", 0, indexSettingsNoReplicas(5)));
        Consumer<String> setSettingValue = value -> {
            return Metadata.API_ONLY;
        // check that snapshot completes with both failed shards being accounted for in the snapshot result
        logger.info("--> done");
            // with SnapshotMissingException
 * ownership. Elasticsearch licenses this file to you under
                    assertThat(response.content().utf8ToString(), containsString("notsecretusername"));
import static org.hamcrest.Matchers.greaterThan;
        createRepository(
import org.opensearch.plugins.Plugin;
        dataNodeClient().admin()
import java.util.concurrent.TimeUnit;
            assertEquals(1, snapshotsStatusResponse.getSnapshots().size());
            indexRandom(true, indexRequestBuilders);
        }
        final Path repoPath = randomRepoPath();
            assertEquals(SnapshotState.PARTIAL, snapshotInfo.state());
        indexRandomDocs(indexName, 100);
        indexRandomDocs("test-idx", randomIntBetween(50, 100));
        internalCluster().restartNode(dataNode, InternalTestCluster.EMPTY_CALLBACK);
        disableRepoConsistencyCheck("This test does not create any data in the repository");
        );
                .setPartial(true)
        logger.info("--> force merging down to a single segment to get a deterministic set of files");
        allowNodes(indexName, 1);
                false,
        clusterState = clusterAdmin().prepareState().get().getState();
            return fromXContent(SnapshottableGatewayMetadata::new, parser);
        ensureGreen();
            ((SnapshottableGatewayMetadata) metadata.custom(SnapshottableGatewayMetadata.TYPE)).getData(),
        assertFalse(restoredRetentionLeases.toString() + " has no " + leaseId, restoredRetentionLeases.contains(leaseId));
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), equalTo(6));
        assertDocCount(indexName, snapshotDocCount);
        logger.info("--> stopping node [{}]", blockedNode);
 * under the License.
        // (1) index-(N+1)
            metadataBuilder.putCustom(NonSnapshottableGatewayMetadata.TYPE, new NonSnapshottableGatewayMetadata("after_snapshot_ns_gw"));
        });
        public static NamedDiff<Metadata.Custom> readDiffFrom(StreamInput in) throws IOException {
                }
        return files;
import org.opensearch.common.util.set.Sets;
                .setWaitForCompletion(true)
        assertBusy(() -> assertTrue(getSnapshot("test-repo", "test-snap").state().completed()), 1, TimeUnit.MINUTES);
            try {
    public void testSnapshotTotalAndIncrementalSizes() throws Exception {
        final int snapshot0FileCount = snapshot0Files.size();
            ),
                is(1)
    }
        }
        }
        }
            .setIndices(shrunkIdx)
                return super.visitFile(file, attrs);
        SnapshotInfo snapshotInfo = waitForCompletion(repoName, "test-snap", TimeValue.timeValueSeconds(600));
        }
        assertBusy(
    public void testRestoreIndexWithMissingShards() throws Exception {
            super(data);
        final RetentionLeases restoredRetentionLeases = Arrays.stream(client().admin().indices().prepareStats(indexName).get().getShards())
        }
            ((SnapshotableGatewayNoApiMetadata) metadata.custom(SnapshotableGatewayNoApiMetadata.TYPE)).getData(),
                    .execute()
        createRepository(
        assertBusy(() -> {
        ensureGreen("test-idx-all");
                .get()
/*
        Files.walkFileTree(repoPath, new SimpleFileVisitor<Path>() {
        final CountDownLatch getRepoLatch = new CountDownLatch(1);
                .setRestoreGlobalState(false)
    }
                    .cluster()
        final AtomicReference<AssertionError> clusterStateError = new AtomicReference<>();
        final int numberOfShards = getNumShards("test-idx").numPrimaries;
                createSnapshotResponse.getSnapshotInfo().reason()
import java.util.function.Consumer;
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.PARTIAL));
            return Metadata.API_AND_SNAPSHOT;
package org.opensearch.snapshots;
            }
        SnapshotStats stats = snapshots.get(0).getStats();
        assertBusy(
        OpenSearchIntegTestCase.putRepositoryRequestBuilder(
        logger.info("--> waiting for block to kick in");
        ensureGreen();
            );
            assertThat(snapshotStatuses.size(), equalTo(1));
        logger.info("--> create an index that will be closed");
import org.opensearch.core.xcontent.XContentParser;
 */
            SnapshotRestoreException.class
        logger.info("--> set test persistent setting");
                    assertThat(response.content().utf8ToString(), not(containsString("verysecretpassword")));
        List<SnapshotStatus> snapshots = response.getSnapshots();
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
    private long calculateTotalFilesSize(List<Path> files) {
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir()) // to get a new node id
            client().prepareIndex(indexName).setSource("test", "init").execute().actionGet();
        logger.info("--> snapshot");
import org.opensearch.env.Environment;
        assertAcked(clusterAdmin().prepareDeleteSnapshot(repositoryName, snapshot0, snapshot1).get());
import org.opensearch.action.support.ActiveShardCount;
            .setRestoreGlobalState(true)
        assertThat(reusedShards.size(), greaterThanOrEqualTo(numberOfShards / 2));
        unblockAllDataNodes(repoName);
    }
            .setWaitForCompletion(false)
            }
        logger.info("-->  snapshot");
            .get();
            "fs",
        internalCluster().stopRandomDataNode();
        cluster().wipeIndices("_all");
@ClusterScope(scope = Scope.TEST, numDataNodes = 0)
        public Version getMinimalSupportedVersion() {
        getRepoRequest.params().put("repository", "test-repo");
        logger.info("Cluster state: {}", clusterState);
     * can be restored when the node the shrunken index was created on is no longer part of
            metadataBuilder.removeCustom(SnapshotableGatewayNoApiMetadata.TYPE);
        assertAcked(prepareCreate("test-idx", 2, indexSettingsNoReplicas(numberOfShards)));
                .setWaitForCompletion(true)
        final int shardCount = randomIntBetween(1, 5);
        internalCluster().startNodes(2);
                }
                .setWaitForNodes("2")
import org.opensearch.transport.client.Client;
            .setRestoreGlobalState(false)
        ensureYellow();
        public SnapshottableGatewayMetadata(String data) {
     * the cluster.
import java.io.UncheckedIOException;
        }
        createFullSnapshot(repo, snapshotName);
                SnapshottableGatewayMetadata::fromXContent
            }
                .setWaitForNodes("<2")
        }
import java.util.Collection;
            Settings.builder().put("location", repoPath).put("random", randomAlphaOfLength(10)).put("wait_after_unblock", 200)
                    .persistentSettings()
        );
            .setIndices("test-idx-closed")
/*
        assertThat(restoreSnapshotResponse.getRestoreInfo().failedShards(), greaterThan(0));
 * The OpenSearch Contributors require contributions made to
import org.opensearch.index.seqno.RetentionLeaseActions;
                .setSnapshots("test-snap")
import org.opensearch.common.settings.Settings;
        logger.info("--> wait for relocations to start");
import org.opensearch.cluster.SnapshotsInProgress;
        internalCluster().restartRandomDataNode(new InternalTestCluster.RestartCallback() {
        assertThat(stats.getTotalFileCount(), lessThan(anotherStats.getTotalFileCount()));
        @Override
        logger.info("--> create snapshot to be deleted and then delete");
        final String leaseId = randomAlphaOfLength(randomIntBetween(1, 10)).toLowerCase(Locale.ROOT);
        createFullSnapshot(repositoryName, snapshot0);
            return readDiffFrom(TYPE, in);
            ),
        logger.info("-->  creating repository");
        public String getWriteableName() {
                }
        assertThat(getSnapshot("test-repo", "test-snap").state(), equalTo(SnapshotState.SUCCESS));
        createRepository(repo, "fs");
            equalTo(false)
        }
            registerBuiltinWritables();
        private void registerBuiltinWritables() {
        logger.info("--> verify that snapshot was successful");
        final String shrunkIdx = "test-idx-shrunk";
                SnapshotableGatewayNoApiMetadata::fromXContent
        SnapshotsStatusResponse response = clusterAdmin().prepareSnapshotStatus(repositoryName).setSnapshots(snapshot0).get();
        public static NonSnapshottableMetadata readFrom(StreamInput in) throws IOException {
        @Override
        static void breakSetting(boolean breakSetting) {
        indexRandomDocs(sourceIdx, randomIntBetween(10, 100));
        final String repoName = "test-repo-retention-leases";
 */
        // index to some other field to trigger a change in index metadata
        final IndexNameExpressionResolver nameExpressionResolver = new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY));
        ensureGreen();
                NonSnapshottableGatewayMetadata::readDiffFrom,
            // When cluster-manager node is closed during this test, it sometime manages to delete the snapshot files before
        logger.info("-->  starting a cluster-manager node and two data nodes");
        for (int i = 0; i < 5; i++) {
        }
        final String dataNode = blockNodeWithIndex("test-repo", "test-idx");
        assertAcked(prepareCreate(sourceIdx, 0, indexSettingsNoReplicas(between(2, 10))));
        assertBusy(() -> assertTrue(getSnapshot("test-repo", "test-snap").state().completed()), 1, TimeUnit.MINUTES);
    public void testExceptionWhenRestoringPersistentSettings() {
        logger.info("--> start snapshot with default settings without a closed index - should fail");
        logger.info("--> abort snapshot");
        assertThat(restoreSnapshotResponse.getRestoreInfo().successfulShards(), equalTo(4));
        dataNodeClient().admin()
        final String snapshot1 = "snapshot-1";
        RestClusterStateAction clusterStateAction = new RestClusterStateAction(internalCluster().getInstance(SettingsFilter.class));
                .get();
        internalCluster().startDataOnlyNode(dataSettings);
            .setRestoreGlobalState(false)
import org.opensearch.test.OpenSearchIntegTestCase;
            SnapshotsStatusResponse snapshotsStatusResponse = clusterAdmin().prepareSnapshotStatus("test-repo")
import static org.opensearch.index.seqno.RetentionLeaseActions.RETAIN_ALL;
        clusterAdmin().prepareCreateSnapshot("test-repo", "test-snap").setWaitForCompletion(false).setIndices("test-idx").get();
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            Metadata.Builder metadataBuilder = Metadata.builder(currentState.metadata());
                SnapshottableMetadata.TYPE,
 * GitHub history for details.
    public void testSnapshotDeleteRelocatingPrimaryIndex() throws Exception {
        internalCluster().startClusterManagerOnlyNode();
            TimeUnit.SECONDS
            client().admin()
        logger.info("--> restore index snapshot");
        createRepository(repoName, "mock");
                SnapshottableGatewayMetadata.TYPE,
            client().admin().cluster().prepareCreateSnapshot(repositoryName, snapshot1).setWaitForCompletion(true).get().status(),
                assertEquals(snapshotStatuses.size(), 1);
        }
            .setWaitForCompletion(false)
                .setTimeout("1m")
        @Override
            0
            .actionGet();
            .filter(s -> s.getShardRouting().shardId().equals(shardId))
        assertEquals(snapshotInfo.totalShards(), snapshotInfo.successfulShards());
            GetSnapshotsResponse snapshotsStatusResponse = clusterAdmin().prepareGetSnapshots("test-repo")
        blockAllDataNodes("test-repo");
        public static final String TYPE = "test_non_snapshottable_gateway";
        assertThat(stats.getTotalSize(), lessThan(anotherStats.getTotalSize()));
        internalCluster().restartNode(dataNodes.get(0), InternalTestCluster.EMPTY_CALLBACK);
        final TransportService transportService = internalCluster().getInstance(TransportService.class, otherDataNode);
                new SnapshotableGatewayNoApiMetadata("before_snapshot_s_gw_noapi")
                    .get(0)
        createRepository("test-repo-2", "fs", tempDir);
        disableRepoConsistencyCheck("This test does not create any data in the repository");
        internalCluster().startClusterManagerOnlyNode();
        internalCluster().startNode();
        assertAcked(prepareCreate("test-idx", 0, indexSettingsNoReplicas(2)));
        assertThat(metadata.custom(NonSnapshottableMetadata.TYPE), nullValue());
        final List<Path> snapshot1IndexMetaFiles = findRepoMetaBlobs(repoPath);
                .setWaitForCompletion(true)
                SnapshottableGatewayMetadata::readFrom,
import static org.hamcrest.Matchers.containsString;
        createSnapshot("test-repo", "test-snap-1", Collections.singletonList("test-idx"));
        createIndex(indexName);
        }
        logger.info("--> restore snapshot");
    public static class SnapshotableGatewayNoApiMetadata extends TestCustomMetadata {
        );
        createIndex(indexName);
import org.opensearch.snapshots.mockstore.MockRepository;
        internalCluster().startClusterManagerOnlyNode();
        public NonSnapshottableMetadata(String data) {
                String action,
            .cluster()
            .execute()
            "test-repo",
                .put(MockRepository.Plugin.USERNAME_SETTING.getKey(), "notsecretusername")
            client().prepareIndex(indexName).setSource("test", "test" + i).execute().actionGet();
            builder.metadata(metadataBuilder);
                SnapshottableMetadata::readFrom,
        assertThat(
        public EnumSet<Metadata.XContentContext> context() {
        }
        );
        updateClusterState(currentState -> {
            equalTo("before_snapshot_s_gw_noapi")
            .setWaitForCompletion(true)
    }
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusResponse;
            );
            return Version.CURRENT;
            SnapshotMissingException.class,
                .put("random", randomAlphaOfLength(10))
        logger.info("--> stopping node [{}]", blockedNode);
        }
            .actionGet();
        cluster().wipeIndices("_all");
import org.opensearch.rest.AbstractRestChannel;
        indexRandomDocs("test-idx", 100);
        Metadata metadata = clusterState.getMetadata();
        logger.info("-->  starting a cluster-manager node and a data node");
import java.nio.file.FileVisitResult;
        logger.debug("--> adding retention lease with id {} to {}", leaseId, shardId);
        assertThat(snapshot2IndexMetaFiles, hasSize(2)); // should have created one new metadata blob
        }
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        assertThat(stats.getIncrementalFileCount(), equalTo(stats.getTotalFileCount()));
        stopNode(dataNode);
                } catch (AssertionError ex) {
        assertThat(
        final List<Path> snapshot1IndexMetaFiles = findRepoMetaBlobs(repoPath);
            Settings.builder()
        }
        indexRandomDocs("test-idx", randomIntBetween(10, 100));
        createRepository("test-repo", "mock", repoPath);
            );
            logger.info("checking snapshot completion using status");
        assertThat(restoreSnapshotResponse.getRestoreInfo(), notNullValue());
        assertThat(anotherStats.getIncrementalFileCount(), equalTo(anotherStats.getProcessedFileCount()));
/*
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(restoreResponse.getRestoreInfo().successfulShards(), equalTo(shardCount));
                NonSnapshottableGatewayMetadata::readDiffFrom,
import org.opensearch.transport.TransportRequest;
            ((MockTransportService) internalCluster().getInstance(TransportService.class, nodeName)).addSendBehavior(
    }
        final String snapshotName = "test-snap";
        final long snapshot0FileSize = calculateTotalFilesSize(snapshot0Files);
            return TYPE;
                .execute()
            Settings.builder().put("location", randomRepoPath()),
            () -> assertThat(
            // After it was marked as completed in the cluster state - we need to check if it's completed on the file system as well
                .cluster()
import static org.hamcrest.Matchers.lessThan;
        maybeInitWithOldSnapshotVersion("test-repo", repoPath);
            .setWaitForCompletion(true)
        assertThat(
        maybeInitWithOldSnapshotVersion("test-repo", repoPath);
            .build();
        assertDocCount(indexName, snapshotDocCount);
        internalCluster().startDataOnlyNode();
            return namedWritables;
        assertThat(snapshots.get(0).getState().completed(), equalTo(true));
        createFullSnapshot("test-repo", "test-snap");
        );
            Settings.builder()
        assertEquals(SnapshotState.PARTIAL, snapshotInfo.state());
        @Override
        assertThat(
        public static final String TYPE = "test_snapshottable_gateway";
        for (String nodeName : dataNodes) {
import org.opensearch.rest.RestResponse;
                .setRestoreGlobalState(false)
        internalCluster().startClusterManagerOnlyNodes(3);
 * compatible open source license.
            indexRequestBuilders[i] = client().prepareIndex(indexName).setSource("field", "value");
            if (randomBoolean()) {
                    .getFailedShards(),
        public static SnapshottableMetadata readFrom(StreamInput in) throws IOException {
        logger.info("--> shutdown one of the nodes");
        final String snapshot0 = "snapshot-0";
        assertAcked(client().admin().indices().prepareClose("test-idx-closed"));
        getRepoAction.handleRequest(getRepoRequest, new AbstractRestChannel(getRepoRequest, true) {
    }
        if (getRepoError.get() != null) {
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
        public List<NamedWriteableRegistry.Entry> getNamedWriteables() {
        assertFileCount(repo, 2);
        List<SnapshotStatus> snapshots = response.getSnapshots();
        }
        final String indexName = "test-index";
            return fromXContent(NonSnapshottableMetadata::new, parser);
        ClusterState clusterState = clusterAdmin().prepareState().get().getState();
        indexRandomDocs("test-idx", 100);
        }
        final String snapshot2 = "snapshot-2";
        clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap").get();
                return Files.size(f);
        final Path repoPath = randomRepoPath();
                .prepareRestoreSnapshot("test-repo", "test-snap")
            .get();
        final List<String> dataNodes = internalCluster().startDataOnlyNodes(2);
        assertThat(snapshot0IndexMetaFiles, hasSize(1)); // snapshotting a single index
    public void testIndexDeletionDuringSnapshotCreationInQueue() throws Exception {
import org.opensearch.test.disruption.BusyClusterManagerServiceDisruption;
        ensureGreen();
        assertAcked(admin().indices().prepareDelete("test-idx"));
        if (randomBoolean()) {
        public EnumSet<Metadata.XContentContext> context() {
        }
            );
        assertTrue(clusterStateLatch.await(1, TimeUnit.SECONDS));
        logger.debug("-->  close index {}", indexName);
        assertSettingValue.accept("new value");
                "State: [{}], Reason: [{}]",
            .setRestoreGlobalState(false)
                getRepoLatch.countDown();
        }, 1, TimeUnit.MINUTES);
        logger.info("--> make sure old repository wasn't restored");
                    .getSnapshots()
        logger.info("--> restore snapshot for the index that didn't have any shards snapshotted successfully");
import org.opensearch.rest.RestRequest;
                    .getMetadata()
        final String snapshot0 = "snapshot-0";
        }
        createRepository("test-repo", "mock", repoPath);
            .setPartial(true)
                try {
        final String snapshot = "test-snap";
        logger.info("--> restore snapshot for the index that was snapshotted completely");
            .prepareCreateSnapshot("test-repo", "test-snap")
                .execute(),
                try {
        assertEquals(SnapshotState.SUCCESS, snapshotInfo.state());
                .actionGet()
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        final String repoName = "test-repo";
        // drop 1st one to avoid miscalculation as snapshot reuses some files of prev snapshot
                    .getSnapshots()
                .get()
     * Tests that a shrunken index (created via the shrink APIs) and subsequently snapshotted
 * Unless required by applicable law or agreed to in writing,
        transportService.addMessageListener(new TransportMessageListener() {
        createFullSnapshot(repositoryName, snapshot1);
        logger.info("--> snapshot the shrunk index");
        logger.info("--> stopping cluster-manager node");
        expectThrows(
                List<SnapshotStatus> snapshotStatuses = snapshotsStatusResponse.getSnapshots();
        public Version getMinimalSupportedVersion() {
            .get();
    }
import java.util.Locale;
            .setWaitForCompletion(false)
    }
        ensureGreen();
        public static final String TYPE = "test_snapshottable";
        logger.info("Number of failed shards [{}]", snapshotInfo.shardFailures().size());
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            );
        private static final IllegalArgumentException EXCEPTION = new IllegalArgumentException("this setting goes boom");
        assertThat(anotherStats.getIncrementalSize(), equalTo(anotherStats.getProcessedSize()));
                "test-repo" + i,
            "mock",
import org.opensearch.action.admin.indices.stats.ShardStats;
        assertFileCount(repo, 0);
        createSnapshot("test-repo", "test-snap", Collections.singletonList("test-idx"));
            .get();
            () -> assertThat(clusterAdmin().prepareHealth(indexName).execute().actionGet().getRelocatingShards(), greaterThan(0)),
        }
        try {
            super(data);
            metadataBuilder.putCustom(
import org.opensearch.core.xcontent.NamedXContentRegistry;
        assertDocCount("test-idx-all", 100L);
            for (int i = 0; i < extraDocCount; i++) {
                SnapshotableGatewayNoApiMetadata.TYPE,
            assertEquals(BrokenSettingPlugin.EXCEPTION.getMessage(), ex.getMessage());
import org.opensearch.transport.TransportService;
            .setIndices(indexName)
        assertFalse("delete should not be able to finish until data node is unblocked", deleteResponse.isDone());
        // (2) index-latest
            prepareCreate("test-idx-none", 1, indexSettingsNoReplicas(6).put("index.routing.allocation.include.tag", "nowhere"))
        setDisruptionScheme(disruption);
            public void onRequestSent(
                    .setSnapshots("test-snap")
        );
        BrokenSettingPlugin.breakSetting(true);
                .setTimeout("1m")
import java.nio.file.attribute.BasicFileAttributes;
import org.opensearch.cluster.metadata.Metadata;
import java.util.List;
            "test-repo",
                        return;
            .get();
            .admin()
        ensureGreen(indexName);
import org.opensearch.rest.action.admin.cluster.RestClusterStateAction;
        ensureGreen(indexName);
                .setWaitForCompletion(true)
            .setRestoreGlobalState(false)
        }
        final String expression1 = nameExpressionResolver.resolveDateMathExpression(snapshotName);
            .setWaitForCompletion(false)
            return readFrom(SnapshottableGatewayMetadata::new, in);
        }
            Writeable.Reader<T> reader,
        );
        // Make sure the first node is elected as cluster-manager
            SnapshotException.class,
        // snapshot could be taken before or after a day rollover
        assertRequestBuilderThrows(clusterAdmin().prepareGetRepositories("test-repo"), RepositoryMissingException.class);
        internalCluster().startClusterManagerOnlyNodes(2);
        assertThat(restoreSnapshotResponse.getRestoreInfo().failedShards(), equalTo(6));
                .put("location", repo)
        return files;
        assertBusy(() -> {
import java.util.concurrent.atomic.AtomicBoolean;
        logger.info("--> start 2 nodes");
            .prepareCreateSnapshot("test-repo", "test-snap")
            return Version.CURRENT;
            .actionGet();
        }
        assertAcked(prepareCreate("test-idx-some", 2, indexSettingsNoReplicas(6)));
            return Version.CURRENT;
            String name,
        internalCluster().startDataOnlyNode();
        }, nodeClient);
                .prepareUpdateSettings(sourceIdx)
        internalCluster().fullRestart();
        assertThat(getCountForIndex("test-idx-some"), allOf(greaterThan(0L), lessThan(100L)));
                .put("wait_after_unblock", 200)
            .prepareRecoveries("test-idx")
        logger.info("--> create snapshot before index deletion during above snapshot deletion");
        assertThat(snapshot3IndexMetaFiles, hasSize(1)); // should have deleted the metadata blob referenced by the first two snapshots
        }
        }
            clusterAdmin().prepareCreateSnapshot("test-repo", "test-snap-2")
                clusterAdmin().prepareSnapshotStatus("test-repo")
        RestoreSnapshotResponse restoreResponse = clusterAdmin().prepareRestoreSnapshot(repo, snapshot)
        public EnumSet<Metadata.XContentContext> context() {
        final Path repoPath = randomRepoPath();
        internalCluster().startClusterManagerOnlyNode();
import org.opensearch.cluster.service.ClusterService;
                if (file.getFileName().toString().startsWith("__")) {
        waitForBlock(dataNodeName, repoName, TimeValue.timeValueSeconds(30L));
                logger.trace("current snapshot status [{}]", snapshotStatuses.get(0));
        RestGetRepositoriesAction getRepoAction = new RestGetRepositoriesAction(internalCluster().getInstance(SettingsFilter.class));
            );
                .successfulShards(),
        });
        final Set<Integer> reusedShards = new HashSet<>();
    public static class SnapshottableMetadata extends TestCustomMetadata {
                .indices()
        unblockNode("test-repo", blockedNode);
import java.util.concurrent.atomic.AtomicReference;
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            metadataBuilder.putCustom(SnapshottableGatewayMetadata.TYPE, new SnapshottableGatewayMetadata("before_snapshot_s_gw"));
        logger.info("--> restore snapshot");
                .setWaitForEvents(Priority.LANGUID)
            assertTrue(snapshotInfo.state().toString(), snapshotInfo.state().completed());
        stopNode(dataNode);
                    .getState()
            false
    private List<Path> scanSnapshotFolder(Path repoPath) throws IOException {
            .setPartial(true)
        indexRandomDocs("test-idx", 100);
        unblockNode("test-repo", blockedNode);
        Path tempDir = randomRepoPath();
        }, 60L, TimeUnit.SECONDS);
                NonSnapshottableGatewayMetadata::readFrom,
            }
            client().prepareIndex(indexName).setSource("new_field", "test" + i).execute().actionGet();
        maybeInitWithOldSnapshotVersion("test-repo", repoPath);
        logger.info("--> start second node");
    public void testRegistrationFailure() {
        );
        logger.info("--> start 2 nodes");
            .setSnapshots(Sets.newHashSet(expression1, expression2).toArray(Strings.EMPTY_ARRAY))
import org.opensearch.rest.action.admin.cluster.RestGetRepositoriesAction;
        final String dataNodeName = internalCluster().startDataOnlyNode();
        logger.info("Cluster state: {}", clusterState);
        }
        final Path repoPath = randomRepoPath();
            return TYPE;
        assertAcked(deleteResponse.get());
        @Override
        assertThat(getCountForIndex("test-idx-some"), allOf(greaterThan(0L), lessThan(100L)));
                .setIndices("test-idx-all", "test-idx-none", "test-idx-some", "test-idx-closed")
                NonSnapshottableGatewayMetadata::fromXContent
        createRepository(
        final String indexName = "test-blocks-1";
        createRepository("test-repo", "fs");
            clusterAdmin(),
                .anyMatch(entry -> entry.state() == SnapshotsInProgress.State.ABORTED)
            .get();
            "test-repo-0",
    public void testRestoreShrinkIndex() throws Exception {
        }
        final String repoName = "test-repo";
        logger.info("--> add custom persistent metadata");
            .prepareCreateSnapshot("test-repo", "test-snap")
        assertAcked(prepareCreate("test-idx-all", 1, indexSettingsNoReplicas(6)));
                .execute()
        indexRandomDocs("test-idx-all", 100);
        @Override
                metadataBuilder.removeCustom(SnapshottableMetadata.TYPE);
                .setSnapshots("test-snap")
        logger.info("--> waiting for completion");
                    getRepoError.set(ex);
            return readFrom(SnapshottableMetadata::new, in);
        final int numberOfShards = getNumShards("test-idx").numPrimaries;
            } else {
import org.opensearch.test.TestCustomMetadata;
            .put(Node.NODE_NAME_SETTING.getKey(), randomAlphaOfLength(5))
        }
import static org.opensearch.test.NodeRoles.nonClusterManagerNode;
            client().prepareIndex(indexName).setSource("test", "test" + i).execute().actionGet();
        createFullSnapshot(repositoryName, snapshot2);
        public List<Setting<?>> getSettings() {
        logger.info("-->  wait for shard snapshots to show as failed");
                SnapshottableMetadata::fromXContent
import static org.hamcrest.Matchers.is;
        @Override
import org.opensearch.indices.recovery.PeerRecoveryTargetService;
        maybeInitWithOldSnapshotVersion("test-repo", repoPath);
        final CreateSnapshotResponse createSnapshotResponse = startFullSnapshot(repoName, "test-snap", true).get();
            @Override
                .isTimedOut(),
                .entries()
            .execute()
        assertTrue(getRepoLatch.await(1, TimeUnit.SECONDS));
                NonSnapshottableMetadata.TYPE,
        public static SnapshotableGatewayNoApiMetadata fromXContent(XContentParser parser) throws IOException {
            "test-repo",
 * specific language governing permissions and limitations
    public static class BrokenSettingPlugin extends Plugin {
    }
                }
        RestRequest clusterStateRequest = new FakeRestRequest();
        final String indexName = "test-blocks-1";
            null,
            clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap-2")
        private final List<NamedXContentRegistry.Entry> namedXContents = new ArrayList<>();
        clusterStateAction.handleRequest(clusterStateRequest, new AbstractRestChannel(clusterStateRequest, true) {
import org.opensearch.core.rest.RestStatus;
        blocked.set(false);
        logger.info("-->  creating date math snapshot");
        // Register mock repositories
        final List<Path> snapshot0IndexMetaFiles = findRepoMetaBlobs(repoPath);
        logger.info("--> restore incomplete snapshot - should fail");
                NonSnapshottableMetadata::fromXContent
        }, 60L, TimeUnit.SECONDS);
        );
            metadataBuilder.putCustom(NonSnapshottableMetadata.TYPE, new NonSnapshottableMetadata("after_snapshot_ns"));
            .shardRecoveryStates()
        assertThat(snapshotInfo.shardFailures().size(), greaterThan(0));
        ensureGreen();
                assertThat(getSnapshot("test-repo", "test-snap-2").state(), equalTo(SnapshotState.PARTIAL));
            }, 1, TimeUnit.MINUTES);
        logger.info("--> Go through a loop of creating and deleting a snapshot to trigger repository cleanup");
    }
        setSettingValue.accept("new value");
    }
            .setIndices("-*")
            Metadata.Builder metadataBuilder = Metadata.builder(currentState.metadata());
            ((SnapshottableGatewayMetadata) metadata.custom(SnapshottableGatewayMetadata.TYPE)).getData(),
        final AtomicBoolean blocked = new AtomicBoolean(true);
        @Override
        assertAcked(prepareCreate("test-idx", 0, indexSettingsNoReplicas(between(1, 20))));
            return readDiffFrom(TYPE, in);
        assertThat(((SnapshottableMetadata) metadata.custom(SnapshottableMetadata.TYPE)).getData(), equalTo("before_snapshot_s"));
                .stream()
        final String clusterManagerNode = blockClusterManagerFromFinalizingSnapshotOnSnapFile("test-repo");
    }
    public static class NonSnapshottableMetadata extends TestCustomMetadata {
    }
            () -> clusterAdmin().prepareCreateSnapshot("test-repo", "test-snap-1")
                .execute()
        assertThat(restoreSnapshotResponse.getRestoreInfo(), notNullValue());
                    assertThat(response.content().utf8ToString(), containsString("notsecretusername"));
            assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), lessThan(16));
                    files.add(file);
        } catch (IllegalArgumentException ex) {
        assertThat(metadata.custom(SnapshotableGatewayNoApiMetadata.TYPE), nullValue());
        createSnapshot("test-repo", "test-snap-delete", Collections.singletonList("test-idx"));
            namedWritables.add(new NamedWriteableRegistry.Entry(NamedDiff.class, name, diffReader));
            clusterAdmin().prepareHealth()
            public boolean clearData(String nodeName) {
