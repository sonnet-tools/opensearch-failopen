        final String repoName = "test-repo";  
            ((MockTransportService) internalCluster().getInstance(TransportService.class, nodeName)).addSendBehavior(  
            .setWaitForCompletion(true)
        }
            Metadata.Builder metadataBuilder = Metadata.builder(currentState.metadata());  
                    .setSnapshots("test-snap")
        final String clusterManagerNode = blockClusterManagerFromFinalizingSnapshotOnSnapFile("test-repo");
                .isTimedOut(),
import org.opensearch.cluster.node.DiscoveryNode;
    public void testClusterManagerShutdownDuringSnapshot() throws Exception {  
        return files.stream().mapToLong(f -> {
import org.opensearch.core.common.io.stream.Writeable;
            return EnumSet.of(Metadata.XContentContext.API, Metadata.XContentContext.SNAPSHOT, Metadata.XContentContext.GATEWAY);
        final String repo = "test-repo";
                    .getState()
        final String indexName = "index-retention-leases";  
        public String getWriteableName() {  
    }
        assertRequestBuilderThrows(clusterAdmin().prepareGetRepositories("test-repo"), RepositoryMissingException.class);
        logger.info("--> create an index that will have some unallocated shards");
        assertAcked(prepareCreate("test-idx", 0, indexSettingsNoReplicas(between(1, 20))));
        public static final String TYPE = "test_snapshottable_gateway";
            .retentionLeases();
        );
import org.opensearch.plugins.Plugin;
        unblockAllDataNodes(repoName);
        internalCluster().stopCurrentClusterManagerNode();
        nodes.remove(blockedNode);
                .setWaitForCompletion(false)
        assertBusy(() -> assertTrue(getSnapshot("test-repo", "test-snap").state().completed()), 1, TimeUnit.MINUTES);  
            assertNotNull(failure.reason());
    }
        ClusterState clusterState = clusterAdmin().prepareState().get().getState();
            assertEquals(1, snapshotsStatusResponse.getSnapshots().size());  
        }
        assertAcked(clusterAdmin().prepareDeleteSnapshot(repositoryName, snapshot0, snapshot1).get());
        clusterStateAction.handleRequest(clusterStateRequest, new AbstractRestChannel(clusterStateRequest, true) {  
            assertThat(snapshotStatus.getShardsStats().getDoneShards(), greaterThan(10));
import static org.hamcrest.Matchers.notNullValue;  
        createIndex("some-index");  
        }
        final IndexNameExpressionResolver nameExpressionResolver = new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY));  
                    assertThat(response.content().utf8ToString(), not(containsString("verysecretpassword")));
        final int snapshot0FileCount = snapshot0Files.size();  
        indexRandomDocs("test-idx", randomIntBetween(10, 100));
        );  
            BrokenSettingPlugin.breakSetting = breakSetting;
    }  
            "mock",
            indexRequestBuilders = new IndexRequestBuilder[extraDocCount];
                .anyMatch(entry -> entry.state() == SnapshotsInProgress.State.ABORTED)  
        stopNode(blockedNode);
                .setWaitForCompletion(true)
            return fromXContent(NonSnapshottableGatewayMetadata::new, parser);
        } catch (SnapshotMissingException ex) {
        // index to some other field to trigger a change in index metadata
import java.nio.file.Path;
            Settings.builder()  
            super(data);
        logger.info("-->  restarting first data node, which should cause the primary shard on it to be failed");
        logger.info("--> waiting for block to kick in");  
                .execute()
        assertThat(metadata.custom(SnapshotableGatewayNoApiMetadata.TYPE), nullValue());
        }  
            public void sendResponse(RestResponse response) {
            SnapshotException.class,  
        assertThat(snapshot0IndexMetaFiles, hasSize(1)); // snapshotting a single index
            metadataBuilder.putCustom(NonSnapshottableGatewayMetadata.TYPE, new NonSnapshottableGatewayMetadata("before_snapshot_ns_gw"));
            .setRestoreGlobalState(false)
        final String repoName = "test-repo";
            .setRestoreGlobalState(false)  
        }  
        createSnapshot(repoName, snapshotName, Collections.singletonList(indexName));  
        internalCluster().startDataOnlyNode();
        assertDocCount(indexName, snapshotDocCount);
        createSnapshot(repo, snapshot, Collections.singletonList(shrunkIdx));
        assertThat(snapshots.get(0).getState().completed(), equalTo(true));  
                logger.trace("current snapshot status [{}]", snapshotStatuses.get(0));
        createFullSnapshot("test-repo", "test-snap");
import org.opensearch.indices.recovery.PeerRecoveryTargetService;
        assertThat(anotherStats.getIncrementalSize(), equalTo(anotherStats.getProcessedSize()));  
        maybeInitWithOldSnapshotVersion("test-repo", repoPath);
            return TYPE;  
        logger.info("-->  wait for shard snapshot of first primary to show as failed");
        logger.info("--> create an index that will have all allocated shards");
        assertAcked(prepareCreate("test-idx-some", 2, indexSettingsNoReplicas(6)));
            return fromXContent(SnapshotableGatewayNoApiMetadata::new, parser);
        public Version getMinimalSupportedVersion() {  
            assertAcked(deleteSnapshotResponseFuture.actionGet());
import java.util.EnumSet;
        logger.info("--> create snapshot before index deletion during above snapshot deletion");  
        }
        RestoreSnapshotResponse restoreResponse = clusterAdmin().prepareRestoreSnapshot(repoName, snapshotName)  
        logger.info("--> start relocations");
                .prepareRestoreSnapshot("test-repo", "test-snap")
        internalCluster().startNodes(2);
            namedWritables.add(new NamedWriteableRegistry.Entry(Metadata.Custom.class, name, reader));  
        logger.info("--> wait for snapshot to complete");  
                .setRestoreGlobalState(false)
import static org.hamcrest.Matchers.containsString;
        for (int i = 0; i < 5; i++) {  
import org.opensearch.core.common.Strings;
import org.opensearch.Version;
        assertThat(anotherStats.getIncrementalFileCount(), equalTo(anotherStats.getProcessedFileCount()));
        final List<String> dataNodes = internalCluster().startDataOnlyNodes(2);  
        assertAcked(client().admin().indices().prepareClose("test-idx"));
                List<SnapshotStatus> snapshotStatuses = snapshotsStatusResponse.getSnapshots();  
                .setTimeout("1m")  
 * the Apache License, Version 2.0 (the "License"); you may
            }
        final int snapshot1FileCount = snapshot1Files.size();
        }
        }
            metadataBuilder.removeCustom(SnapshotableGatewayNoApiMetadata.TYPE);  
        }  
        @Override
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
        assertThat(restoreSnapshotResponse.getRestoreInfo().successfulShards(), equalTo(0));
            .setPartial(true)  
            .setIndices("-*")
        for (int i = 0; i < docs; i++) {  
                .setIgnoreUnavailable(true)
            .setWaitForCompletion(false)
                    getRepoError.set(ex);
        internalCluster().startClusterManagerOnlyNode();
            .setWaitForCompletion(true)
        public EnumSet<Metadata.XContentContext> context() {
        }  
import org.opensearch.common.util.set.Sets;  
                .actionGet();  
        ensureGreen(indexName);
                .put("wait_after_unblock", 200)  
        ensureGreen(indexName);
            assertEquals(1, snapshotsStatusResponse.getSnapshots().size());  
            0
                    .getFailedShards(),
            }
        internalCluster().startClusterManagerOnlyNode();
        if (getRepoError.get() != null) {
        final String dataNode = internalCluster().startDataOnlyNode();  
        ServiceDisruptionScheme disruption = new BusyClusterManagerServiceDisruption(random(), Priority.HIGH);  
        // drop 1st one to avoid miscalculation as snapshot reuses some files of prev snapshot
        public Version getMinimalSupportedVersion() {
        @Override
import java.util.Set;  
                } catch (AssertionError ex) {  
 *
        disableRepoConsistencyCheck("This test does not create any data in the repository");
                DiscoveryNode node,
                metadataBuilder.putCustom(SnapshottableGatewayMetadata.TYPE, new SnapshottableGatewayMetadata("after_snapshot_s_gw"));
        assertAcked(
        assertThat(
            .setWaitForCompletion(false)
        assertThat(snapshot0IndexMetaFiles, hasSize(1)); // snapshotting a single index  
                    .getFailedShards(),  
            equalTo("before_snapshot_s_gw")  
import java.nio.file.attribute.BasicFileAttributes;  
import static org.hamcrest.Matchers.not;
        createFullSnapshot(repo, snapshotName);
                clusterAdmin(),
import java.nio.file.Files;  
        indexRandomDocs("test-idx", 100);  
        logger.info("-->  restarting data node, which should cause primary shards to be failed");  
        for (int i = 0; i < docs; i++) {
            builder.metadata(metadataBuilder);
                SnapshottableMetadata.TYPE,
        Files.walkFileTree(repoPath.resolve("indices"), new SimpleFileVisitor<Path>() {  
            .shardRecoveryStates()
        createRepository("test-repo", "mock", repoPath);
        public Version getMinimalSupportedVersion() {
            .setIndices("test-idx-closed")  
            // completely stopping. In this case the retried delete snapshot operation on the new cluster-manager can fail
        createRepository("test-repo", "fs", tempDir);
        // The IndexMetadata did not change between snapshots, verify that no new redundant IndexMetaData was written to the repository
                .cluster()  
     * Tests that a shrunken index (created via the shrink APIs) and subsequently snapshotted
        assertBusy(() -> {
    public void testRestoreIndexWithMissingShards() throws Exception {  
    public void testExceptionWhenRestoringPersistentSettings() {
                    throw new AssertionError("Node had no assigned shard snapshots so it shouldn't send out shard state updates");
            client().prepareIndex(indexName).setSource("test", "init").execute().actionGet();
            return readDiffFrom(TYPE, in);
            equalTo("after_snapshot_ns_gw")
            Settings.builder()  
                NonSnapshottableGatewayMetadata::readFrom,
import java.nio.file.SimpleFileVisitor;
            .put(Node.NODE_NAME_SETTING.getKey(), randomAlphaOfLength(5))  
            assertTrue(snapshotInfo.state().toString(), snapshotInfo.state().completed());
        assertThat(restoreSnapshotResponse.getRestoreInfo().successfulShards(), allOf(greaterThan(0), lessThan(6)));  
                    .setSnapshots("test-snap-2")
        logger.debug("--> indexing {} docs into {}", snapshotDocCount, indexName);  
                    .getSnapshots()  
        internalCluster().stopRandomDataNode();
        );
        dataNodeClient().admin()
        assertAcked(prepareCreate("test-idx", 2, indexSettingsNoReplicas(2)));  
                .put(MockRepository.Plugin.USERNAME_SETTING.getKey(), "notsecretusername")
        @Override
            registerMetadataCustom(  
        assertThat(restoreSnapshotResponse.getRestoreInfo().failedShards(), greaterThan(0));
                assertThat(getSnapshot("test-repo", "test-snap-2").state(), equalTo(SnapshotState.PARTIAL));  
 *
        logger.info("--> wait until the snapshot is done");
        public static SnapshotableGatewayNoApiMetadata fromXContent(XContentParser parser) throws IOException {  
        allowNodes(indexName, 1);
                    .getShardsStats()
            registerMetadataCustom(  
                return Files.size(f);  
                NonSnapshottableGatewayMetadata::readDiffFrom,  
        logger.info("--> snapshot");  
    }  
                if (file.getFileName().toString().startsWith("__")) {  
                assertEquals(snapshotStatuses.size(), 1);
        logger.debug("-->  close index {}", indexName);
                .isTimedOut(),
            clusterAdmin().prepareHealth()
                createSnapshotResponse.getSnapshotInfo().reason()  
            assertEquals(SnapshotState.PARTIAL, snapshotInfo.state());
    }
import org.opensearch.rest.AbstractRestChannel;
        final ActionFuture<CreateSnapshotResponse> snapshotResponse = startFullSnapshot(repoName, snapshotName);
        logger.info("--> start node");  
            SnapshotStatus snapshotStatus = snapshotStatuses.get(0);
        createFullSnapshot(repositoryName, snapshot2);  
        final Path repoPath = randomRepoPath();
        final String repositoryName = "repo-" + indexName;
            true,
    }
import org.opensearch.common.unit.TimeValue;
        assertEquals(SnapshotState.PARTIAL, snapshotInfo.state());
            return readFrom(SnapshottableGatewayMetadata::new, in);
            );
        internalCluster().restartNode(dataNodes.get(1), InternalTestCluster.EMPTY_CALLBACK);
            .filter(s -> s.getShardRouting().shardId().equals(shardId))
        assertThat(restoreSnapshotResponse.getRestoreInfo(), notNullValue());
import org.opensearch.action.support.ActiveShardCount;
        SnapshotStats anotherStats = snapshots.get(0).getStats();  
                .setPartial(true)  
        return files;  
        assertThat(getSnapshot("test-repo", "test-snap").state(), equalTo(SnapshotState.SUCCESS));  
            metadataBuilder.putCustom(SnapshottableGatewayMetadata.TYPE, new SnapshottableGatewayMetadata("before_snapshot_s_gw"));  
 *  
        ActionFuture<AcknowledgedResponse> deleteSnapshotResponseFuture = internalCluster().client(nodes.get(0))
    private long calculateTotalFilesSize(List<Path> files) {  
        logger.info("number of shards: {}", numberOfShards);  
    public void testRetentionLeasesClearedOnRestore() throws Exception {
            throw getRepoError.get();
        SnapshotsStatusResponse response = clusterAdmin().prepareSnapshotStatus(repositoryName).setSnapshots(snapshot0).get();
        assertDocCount("test-idx-closed", 100L);
        public EnumSet<Metadata.XContentContext> context() {
            }  
    /**  
        }
        logger.info("-->  starting a cluster-manager node and two data nodes");
    }
            client().admin().indices().prepareForceMerge("test-idx").setMaxNumSegments(1).setFlush(true).get().getFailedShards(),
        }
import static org.hamcrest.Matchers.greaterThan;  
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusResponse;
        @Override
            .setIgnoreUnavailable(true)
    public void testClusterManagerAndDataShutdownDuringSnapshot() throws Exception {
        assertThat(snapshot3IndexMetaFiles, hasSize(1)); // should have deleted the metadata blob referenced by the first two snapshots
        assertFalse("delete should not be able to finish until data node is unblocked", deleteResponse.isDone());  
        };
            SnapshotInfo snapshotInfo = snapshotsStatusResponse.getSnapshots().get(0);
        public static final String TYPE = "test_snapshottable_gateway_no_api";
        cluster().wipeIndices("_all");  
                .setSnapshots("test-snap")  
                .setWaitForCompletion(true)
            .prepareCreateSnapshot("test-repo", "test-snap")  
    public void testRestoreCustomMetadata() throws Exception {  
            .build();
                client.admin()  
            BrokenSettingPlugin.class,  
        assertAcked(client().admin().indices().prepareClose("test-idx-closed"));
        @Override
        });
        }  
    public void testRestoreIndexWithShardsMissingInLocalGateway() throws Exception {
                SnapshottableGatewayMetadata::readDiffFrom,  
        assertThat(restoreSnapshotResponse.getRestoreInfo().successfulShards(), equalTo(6));
        }  
import org.opensearch.transport.TransportRequest;  
        assertAcked(prepareCreate("test-idx-closed", 1, indexSettingsNoReplicas(4)));
            .get();
        }
                    .getSnapshots()
        createSnapshot("test-repo", "test-snap", Collections.singletonList("test-idx"));  
        // Wait for snapshot process to complete to prevent conflict with repository clean up
        public List<NamedWriteableRegistry.Entry> getNamedWriteables() {  
            "mock",
            prepareCreate("test-idx-none", 1, indexSettingsNoReplicas(6).put("index.routing.allocation.include.tag", "nowhere"))
        final String expression2 = nameExpressionResolver.resolveDateMathExpression(snapshotName);
            client().prepareIndex(indexName).setSource("test", "test" + i).execute().actionGet();
        ensureYellow();  
            logger.info("checking snapshot completion using wait_for_completion flag");
        assertAcked(client().admin().indices().prepareClose(indexName));  
            .actionGet();
                .setRestoreGlobalState(false)
                SnapshotableGatewayNoApiMetadata.TYPE,
        );
            client().prepareIndex(indexName).setSource("test", "test" + i).execute().actionGet();
        assertThat(snapshotInfo.shardFailures().size(), greaterThan(0));  
        createRepository("test-repo", "mock", repoPath);
            .setWaitForCompletion(true)
        List<SnapshotStatus> snapshots = response.getSnapshots();
            .execute()
            @Override
            "test-repo-0",
    public void testRestoreShrinkIndex() throws Exception {
    public void testDeduplicateIndexMetadata() throws Exception {  
        try {  
        final Set<Integer> reusedShards = new HashSet<>();  
        int docs = between(10, 100);
        public static SnapshottableMetadata readFrom(StreamInput in) throws IOException {
            .setIndices("test-idx-all")
                assertEquals(SnapshotState.PARTIAL, snapshotInfo.state());
            return builder.build();
        );
        assertFileCount(repo, 2);
            registerMetadataCustom(  
            if (randomBoolean()) {  
            return Metadata.API_AND_GATEWAY;
        clusterAdmin().prepareCleanupRepository("test-repo").get();  
            .findFirst()  
        public NonSnapshottableMetadata(String data) {
import java.util.HashSet;  
        createSnapshot("test-repo", "test-snap-delete", Collections.singletonList("test-idx"));  
        assertNotEquals(snapshotInfo.totalShards(), snapshotInfo.successfulShards());
                    assertThat(response.content().utf8ToString(), not(containsString("verysecretpassword")));
    public static class NonSnapshottableMetadata extends TestCustomMetadata {
 * GitHub history for details.
        assertThat(  
        assertThat(stats.getTotalFileCount(), greaterThanOrEqualTo(snapshot0FileCount));
        assertThat(  
            }
        awaitClusterState(
                try {  
        }
        updateClusterState(currentState -> {
        }
        });  
            return TYPE;  
            SnapshotRestoreException.class
        stopNode(dataNode);  
        logger.info("-->  starting a cluster-manager node and two data nodes");
        assertThat(anotherStats.getTotalFileCount(), greaterThanOrEqualTo(snapshot1FileCount));
                .setWaitForNodes("<2")
import org.opensearch.common.settings.SettingsFilter;  
        maybeInitWithOldSnapshotVersion("test-repo", repoPath);  
            return TYPE;
        final RetentionLeases restoredRetentionLeases = Arrays.stream(client().admin().indices().prepareStats(indexName).get().getShards())  
        } else {
        clusterAdmin().prepareCreateSnapshot(repoName, "test-snap")
                .setPartial(true)
        assertAcked(prepareCreate("test-idx", 0, indexSettingsNoReplicas(5)));  
        index(indexName, "_doc", "some_id", "foo", "bar");
        assertThat(metadata.custom(SnapshottableMetadata.TYPE), nullValue());  
                NonSnapshottableGatewayMetadata::readDiffFrom,  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
                    clusterStateError.set(ex);
        createRepository("test-repo", "fs");
            super(data);
            equalTo("before_snapshot_s_gw")
        public SnapshottableMetadata(String data) {  
        assertBusy(() -> assertTrue(getSnapshot("test-repo", "test-snap").state().completed()), 1, TimeUnit.MINUTES);
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), equalTo(6));  
        }, nodeClient);
        createRepository(repo, "fs");  
import org.opensearch.common.settings.Setting;
    }  
        createRepository(repoName, "fs");
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotStatus;  
 */  
        logger.info("-->  starting three cluster-manager nodes and two data nodes");  
public class DedicatedClusterSnapshotRestoreIT extends AbstractSnapshotIntegTestCase {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
                .prepareUpdateSettings(sourceIdx)
    }
                clusterAdmin().prepareSnapshotStatus("test-repo")  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        ensureGreen();  
        final String repoName = "test-repo";
        assertBusy(
import static org.hamcrest.Matchers.allOf;  
        }
        assertFileCount(repo, 0);
        }  
        blocked.set(false);
        logger.info("--> wait for relocations to start");
    public static class BrokenSettingPlugin extends Plugin {
        logger.info("-->  snapshot");
        public static NamedDiff<Metadata.Custom> readDiffFrom(StreamInput in) throws IOException {  
 * specific language governing permissions and limitations
            metadataBuilder.putCustom(NonSnapshottableGatewayMetadata.TYPE, new NonSnapshottableGatewayMetadata("after_snapshot_ns_gw"));
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), equalTo(6));
            return Metadata.API_AND_SNAPSHOT;
            assertThat(snapshotInfo.shardFailures(), hasSize(2));
            registerMetadataCustom(  
                NonSnapshottableMetadata.TYPE,
        final String otherDataNode = internalCluster().startDataOnlyNode();
        logger.info("--> add custom persistent metadata");  
        ensureGreen();  
        );
                .setSnapshots("test-snap-2")  
        assertAcked(prepareCreate("test-idx", 0, indexSettingsNoReplicas(between(1, 20))));  
        logger.info("--> done");
        // Register mock repositories
import java.util.concurrent.TimeUnit;
        // create another snapshot
            "test-repo",  
        logger.info("--> check that gateway-persistent custom metadata survived full cluster restart");
        logger.info("--> force merging down to a single segment to get a deterministic set of files");
            return EnumSet.of(Metadata.XContentContext.GATEWAY, Metadata.XContentContext.SNAPSHOT);  
                .execute()  
        final String snapshotName = "test-snap";  
            assertEquals(BrokenSettingPlugin.EXCEPTION.getMessage(), ex.getMessage());  
        SnapshotsStatusResponse response = clusterAdmin().prepareSnapshotStatus(repo)  
        logger.info("--> start two nodes");
        createSnapshot("test-repo", "test-snap-1", Collections.singletonList("test-idx"));
            ((NonSnapshottableGatewayMetadata) metadata.custom(NonSnapshottableGatewayMetadata.TYPE)).getData(),
            OpenSearchIntegTestCase.putRepositoryRequestBuilder(
        logger.info("--> waiting for completion");
        assertAcked(deleteResponse.get());  
                (connection, requestId, action, request, options) -> {
            ((SnapshotableGatewayNoApiMetadata) metadata.custom(SnapshotableGatewayNoApiMetadata.TYPE)).getData(),  
        final Path repoPath = randomRepoPath();
        @Override  
        final String dataNodeName = internalCluster().startDataOnlyNode();
            final CreateSnapshotResponse createSnapshotResponse = clusterAdmin().prepareCreateSnapshot("test-repo", "test-snap-2")  
            clusterAdmin().prepareCreateSnapshot("test-repo", "test-snap-2")
        // total size has to grow and has to be equal to files on fs
        // check that snapshot completes with both failed shards being accounted for in the snapshot result  
            client.admin()  
        }, 60L, TimeUnit.SECONDS);
        assertAcked(client().admin().indices().prepareDelete(indexName));
        List<SnapshotStatus> snapshots = response.getSnapshots();
        assertBusy(() -> {
        Consumer<String> setSettingValue = value -> {
        public static SnapshottableGatewayMetadata readFrom(StreamInput in) throws IOException {  
                    assertThat(response.content().utf8ToString(), containsString("notsecretusername"));
        final List<Path> snapshot1IndexMetaFiles = findRepoMetaBlobs(repoPath);
            .setIndices(shrunkIdx)  
                TransportRequest request,
                    .execute()
    }
                "State: [{}], Reason: [{}]",
            if (recoveryState.getIndex().reusedBytes() > 0) {
        @Override  
        assertThat(snapshot2IndexMetaFiles, hasSize(2)); // should have created one new metadata blob  
import java.util.ArrayList;
     * the cluster.  
                .actionGet()  
                .get();
        assertAcked(prepareCreate("test-idx", 0, indexSettingsNoReplicas(2)));
            equalTo(6)
                    .getShardsStats()
        logger.info("--> start a new data node");
                createSnapshotResponse.getSnapshotInfo().state(),
        );
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                .execute()
            );
        final String snapshot1 = "snapshot-1";
        createRepository("test-repo", "fs");
        );
        private final List<NamedWriteableRegistry.Entry> namedWritables = new ArrayList<>();
        RestoreSnapshotResponse restoreResponse = clusterAdmin().prepareRestoreSnapshot(repo, snapshot)
                .setIndices("test-idx-all", "test-idx-none", "test-idx-some", "test-idx-closed")
        createRepository(  
            GetSnapshotsResponse snapshotsStatusResponse = clusterAdmin().prepareGetSnapshots("test-repo")
        logger.info("--> start 2 nodes");  
            .setIndices(indexName)
    public void testSnapshotWithDateMath() {  
        assertThat(((NonSnapshottableMetadata) metadata.custom(NonSnapshottableMetadata.TYPE)).getData(), equalTo("after_snapshot_ns"));  
        public List<NamedXContentRegistry.Entry> getNamedXContent() {
        SnapshotInfo snapshotInfo = getSnapshot("test-repo", "test-snap");  
        assertThat(snapshotResponse.get().getSnapshotInfo().state(), is(SnapshotState.FAILED));
        final String indexName = "test-blocks-1";
        }
        ensureGreen();  
                    assertThat(response.content().utf8ToString(), containsString("notsecretusername"));
        snapshotFilesDiff.removeAll(snapshot0Files);  
        assertThat(stats.getTotalSize(), lessThan(anotherStats.getTotalSize()));
                .put("location", randomRepoPath())
    }  
                "mock",
        assertThat(((SnapshottableMetadata) metadata.custom(SnapshottableMetadata.TYPE)).getData(), equalTo("before_snapshot_s"));
        static final Setting<String> BROKEN_SETTING = new Setting<>("setting.broken", "default", s -> s, s -> {
        public static final String TYPE = "test_non_snapshottable_gateway";
        public EnumSet<Metadata.XContentContext> context() {  
            );
            ).get();  
        logger.info("--> restore index snapshot");
        logger.info("--> restore snapshot for the partial index");
import org.opensearch.repositories.blobstore.BlobStoreRepository;
            60L,
import org.opensearch.core.rest.RestStatus;
        logger.info("-->  starting a cluster-manager node and a data node");  
            MockTransportService.TestPlugin.class
                metadataBuilder.removeCustom(SnapshottableGatewayMetadata.TYPE);  
        internalCluster().startNode();
        }
        logger.info("--> delete index and stop the data node");
        String blockedNode = blockNodeWithIndex("test-repo", "test-idx");
        final ActionFuture<AcknowledgedResponse> deleteResponse = startDeleteSnapshot(repoName, snapshotName);
            return Version.CURRENT;
import static org.hamcrest.Matchers.hasSize;
import org.opensearch.transport.TransportService;
        restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap-2")
                    .actionGet()  
        for (int i = 0; i < snapshotDocCount; i++) {
import org.opensearch.common.util.concurrent.ThreadContext;
                .actionGet()
        public String getWriteableName() {
        waitForBlock(blockedNode, "test-repo", TimeValue.timeValueSeconds(60));
            return fromXContent(SnapshottableMetadata::new, parser);
            Metadata.Builder metadataBuilder = Metadata.builder(currentState.metadata());
            super(data);
        logger.info("--> start snapshot with default settings without a closed index - should fail");
        logger.info("--> restore snapshot for the closed index that was snapshotted completely");  
        assertSettingValue.accept("new value 2");
            ((NonSnapshottableGatewayMetadata) metadata.custom(NonSnapshottableGatewayMetadata.TYPE)).getData(),  
 */  
                if (fileName.startsWith(BlobStoreRepository.METADATA_PREFIX) && fileName.endsWith(".dat")) {
            .cluster()  
        // But should still be in state  
        );  
            .prepareCreateSnapshot("test-repo", "test-snap")
        }  
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), equalTo(4));
import org.opensearch.cluster.SnapshotsInProgress;
            Settings.builder().put("location", randomRepoPath()),
        }  
    }
        }  
        getRepoRequest.params().put("repository", "test-repo");  
        if (randomBoolean()) {  
    public void testSnapshotDeleteRelocatingPrimaryIndex() throws Exception {
            clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap-1")
                NonSnapshottableMetadata::readDiffFrom,  
            ((SnapshottableGatewayMetadata) metadata.custom(SnapshottableGatewayMetadata.TYPE)).getData(),
            indexRequestBuilders[i] = client().prepareIndex(indexName).setSource("field", "value");  
            final int extraDocCount = iterations(10, 1000);  
                metadataBuilder.putCustom(SnapshottableMetadata.TYPE, new SnapshottableMetadata("after_snapshot_s"));
        );
import org.opensearch.test.OpenSearchIntegTestCase;  
import org.opensearch.cluster.service.ClusterService;  
                    files.add(file);
        final List<Path> snapshot2IndexMetaFiles = findRepoMetaBlobs(repoPath);
        response = clusterAdmin().prepareSnapshotStatus(repositoryName).setSnapshots(snapshot1).get();
        assertThat(createSnapshotResponse.getSnapshotInfo().state(), is(SnapshotState.PARTIAL));
        public static NamedDiff<Metadata.Custom> readDiffFrom(StreamInput in) throws IOException {
                TransportRequestOptions finalOptions
        public TestCustomMetadataPlugin() {
            .cluster()  
            public void sendResponse(RestResponse response) {
        List<Path> files = new ArrayList<>();
            @Override
        public Version getMinimalSupportedVersion() {
    private static List<Path> findRepoMetaBlobs(Path repoPath) throws IOException {
        BrokenSettingPlugin.breakSetting(true);
        final String indexName = "test-index";  
            @Override
        }  
        logger.info("--> create an index that will have no allocated shards");  
            super(data);  
        Client client = client();  
    public static class SnapshottableGatewayMetadata extends TestCustomMetadata {
            .setIndices("test-idx")
        assertThat(reusedShards.size(), greaterThanOrEqualTo(numberOfShards / 2));
            .setSnapshots(Sets.newHashSet(expression1, expression2).toArray(Strings.EMPTY_ARRAY))
            .get();
    }
            .indices()
        stopNode(dataNode);
        assertAcked(client().admin().indices().prepareResizeIndex(sourceIdx, shrunkIdx).get());
            equalTo(false)
        logger.info("--> create an index that will have some unallocated shards");
            @Override  
            return Collections.singletonList(BROKEN_SETTING);  
                SnapshottableGatewayMetadata::fromXContent
import org.opensearch.core.ParseField;
        public static final String TYPE = "test_snapshottable";
        assertThat(stats.getTotalFileCount(), lessThan(anotherStats.getTotalFileCount()));  
package org.opensearch.snapshots;
        final Path repoPath = randomRepoPath();
            .findFirst()
        metadata = internalCluster().getInstance(ClusterService.class).state().metadata();
        transportService.addMessageListener(new TransportMessageListener() {
        indexRandomDocs(indexName, 100);
        ).get();
            .setRestoreGlobalState(false)
        assertDocCount("test-idx-all", 100L);  
        final String expression1 = nameExpressionResolver.resolveDateMathExpression(snapshotName);  
        internalCluster().restartNode(dataNode, InternalTestCluster.EMPTY_CALLBACK);
                .indices()  
        // (1) index-(N+1)  
        internalCluster().startNode();  
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(  
        Path tempDir = randomRepoPath();
        public SnapshottableGatewayMetadata(String data) {
        ensureGreen();
            logger.info(  
            .setPartial(true)
        createFullSnapshot(repositoryName, snapshot0);  
        final Path repoPath = randomRepoPath();
import java.util.concurrent.CountDownLatch;
import org.opensearch.common.Priority;
        assertThat(stats.getIncrementalSize(), equalTo(stats.getTotalSize()));
            } else {
            return readFrom(NonSnapshottableGatewayMetadata::new, in);  
        RestGetRepositoriesAction getRepoAction = new RestGetRepositoriesAction(internalCluster().getInstance(SettingsFilter.class));
        createIndex(indexName);  
        Consumer<String> assertSettingValue = value -> {
        final String repo = "repo";
        docs = between(1, 5);
                .get();
            .setWaitForCompletion(true)
        );
            ClusterState.Builder builder = ClusterState.builder(currentState);
                .setWaitForActiveShards(ActiveShardCount.NONE)  
        assertAcked(prepareCreate(indexName, 2, indexSettingsNoReplicas(between(2, 10))));  
import org.opensearch.transport.TransportRequestOptions;
            ClusterState.Builder builder = ClusterState.builder(currentState);
            .setPartial(true)  
            .execute()  
        indexRandomDocs("test-idx", 100);  
                } catch (AssertionError ex) {  
        }
                .execute()
        logger.info("-->  starting two cluster-manager nodes and two data nodes");
                new SnapshotableGatewayNoApiMetadata("before_snapshot_s_gw_noapi")
    public void testSnapshotWithStuckNode() throws Exception {
        dataNodeClient().admin()
        );
        assertSettingValue.accept("new value");
import java.util.Collection;  
        logger.info("--> waiting for block to kick in");
            .prepareDeleteSnapshot("test-repo", "test-snap")
            metadataBuilder.putCustom(
                SnapshotableGatewayNoApiMetadata::fromXContent
        }, 60L, TimeUnit.SECONDS);  
        indexRandomDocs(sourceIdx, randomIntBetween(10, 100));
        ensureYellow();  
        // The IndexMetadata did not change between snapshots, verify that no new redundant IndexMetaData was written to the repository
        }  
        assertThat(restoreResponse.getRestoreInfo().failedShards(), equalTo(0));
        metadata = clusterState.getMetadata();
        assertAcked(prepareCreate("test-idx", 2, indexSettingsNoReplicas(numberOfShards)));  
        client(internalCluster().getClusterManagerName()).admin()
    }
        final String snapshot = "test-snap";
        logger.info("--> stopping node [{}]", blockedNode);
        internalCluster().startClusterManagerOnlyNode();
            .setIndices("test-idx")
        assertAcked(prepareCreate("test-idx", 2, indexSettingsNoReplicas(2)));  
        clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap").get();
                getRepoLatch.countDown();  
        unblockNode("test-repo", blockedNode);  
        public static final String TYPE = "test_non_snapshottable";  
                SnapshottableGatewayMetadata.TYPE,
                }
            clusterAdmin().prepareHealth()
import static org.hamcrest.Matchers.is;  
            "fs",  
                .setWaitForCompletion(true)
        final String snapshotName = "<snapshot-{now/d}>";
 * software distributed under the License is distributed on an
                .execute()
            return TYPE;  
        assertThat(snapshots, hasSize(1));
import static org.hamcrest.Matchers.lessThan;
        final Path repoPath = randomRepoPath();
import java.io.UncheckedIOException;
        final RetentionLeases retentionLeases = shardStats.getRetentionLeaseStats().retentionLeases();
                .put("location", repo)
        List<Path> files = new ArrayList<>();
        assertThat(
    @AwaitsFix(bugUrl = "https://github.com/elastic/elasticsearch/issues/37485")
import java.util.concurrent.atomic.AtomicReference;
import org.opensearch.common.settings.Settings;
        }
        assertThat(anotherStats.getIncrementalFileCount(), greaterThanOrEqualTo(snapshotFilesDiff.size()));
                "test-repo" + i,  
        // Remove it from the list of available nodes
        assertThat(restoreSnapshotResponse.getRestoreInfo(), notNullValue());
        assertTrue(clusterStateLatch.await(1, TimeUnit.SECONDS));  
import org.opensearch.env.Environment;
                .get()  
                .setWaitForCompletion(true)  
        );  
            GetSnapshotsResponse snapshotsStatusResponse = clusterAdmin().prepareGetSnapshots("test-repo")
        // (2) index-latest
    }
            false
            .prepareRecoveries("test-idx")  
        createFullSnapshot(repositoryName, snapshot1);  
        assertThat(restoreSnapshotResponse.getRestoreInfo().failedShards(), equalTo(0));
        assertAcked(client().admin().indices().prepareDelete(sourceIdx).get());
        public NonSnapshottableGatewayMetadata(String data) {  
            } else {
        String blockedNode = blockNodeWithIndex("test-repo", "test-idx");  
        assertThat(snapshots, hasSize(1));
    public void testIndexDeletionDuringSnapshotCreationInQueue() throws Exception {
import org.opensearch.test.disruption.ServiceDisruptionScheme;
        RestClusterStateAction clusterStateAction = new RestClusterStateAction(internalCluster().getInstance(SettingsFilter.class));
        createFullSnapshot("test-repo", "test-snap");
        public static NonSnapshottableMetadata readFrom(StreamInput in) throws IOException {
                throw new UncheckedIOException(e);
            return builder.build();
            assertThat(snapshotStatuses.size(), equalTo(1));  
            assertBusy(() -> {  
import java.util.function.Consumer;
        @Override
        indexRandom(true, indexRequestBuilders);
        final String indexName = "test-idx";
            for (int i = 0; i < extraDocCount; i++) {  
        internalCluster().restartNode(dataNodes.get(0), InternalTestCluster.EMPTY_CALLBACK);  
        maybeInitWithOldSnapshotVersion("test-repo", repoPath);  
        }
        final String repoName = "test-repo-retention-leases";  
    }
        final SnapshotException sne = expectThrows(
        NodeClient nodeClient = internalCluster().getInstance(NodeClient.class);  
        }
                metadataBuilder.removeCustom(SnapshottableMetadata.TYPE);  
            assertThat(createSnapshotResponse.getSnapshotInfo().totalShards(), equalTo(22));
import org.opensearch.test.rest.FakeRestRequest;  
        indexRandomDocs("test-idx-some", 100);
        logger.info("--> change custom persistent metadata");
            .setIndices("test-idx-some")  
            // There is slight delay between snapshot being marked as completed in the cluster state and on the file system
        final int numberOfShards = getNumShards("test-idx").numPrimaries;
        if (clusterStateError.get() != null) {
        waitForBlock(dataNodeName, repoName, TimeValue.timeValueSeconds(30L));
                }
        logger.info("Number of failed shards [{}]", snapshotInfo.shardFailures().size());
            SnapshotsStatusResponse snapshotsStatusResponse = clusterAdmin().prepareSnapshotStatus("test-repo")
            .setWaitForCompletion(false)
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFutureThrows;
            return Version.CURRENT;
                    .cluster()
        clusterAdmin().prepareCreateSnapshot("test-repo", "test-snap-2")
        logger.info("--> making sure that snapshot no longer exists");
        assertBusy(  
        SnapshotInfo snapshotInfo = getSnapshot("test-repo", "test-snap");
            .setWaitForCompletion(false)
    public void testPartialSnapshotAllShardsMissing() throws Exception {
                    connection.sendRequest(requestId, action, request, options);
                .setIndices("test-idx-all", "test-idx-none", "test-idx-some", "test-idx-closed")
                .setWaitForEvents(Priority.LANGUID)
import org.opensearch.repositories.RepositoryMissingException;  
                    .getMetadata()
                    .setSnapshots("test-snap")  
            assertThat(
import org.opensearch.snapshots.mockstore.MockRepository;
        logger.info("--> set test persistent setting");  
            return Version.CURRENT;
                false
        final String snapshot1 = "snapshot-1";
        disableRepoConsistencyCheck("This test does not create any data in the repository");  
            1L,
            assertThat(getSnapshot("test-repo", "test-snap-2").state(), equalTo(SnapshotState.PARTIAL));
    }
                SnapshotableGatewayNoApiMetadata.TYPE,  
        for (RecoveryState recoveryState : recoveryStates) {
                throw EXCEPTION;  
import org.opensearch.index.seqno.RetentionLeaseActions;  
    }
                reusedShards.add(recoveryState.getShardId().getId());  
            return fromXContent(NonSnapshottableMetadata::new, parser);
        logger.info("--> stopping data node {}", dataNode);
        clusterState = clusterAdmin().prepareState().get().getState();  
        logger.info("-->  wait for shard snapshots to show as failed");  
            .setIndices("test-idx")  
        };
import org.opensearch.index.remote.RemoteStoreEnums;
            CheckedFunction<XContentParser, T, IOException> parser
        public List<Setting<?>> getSettings() {
        public EnumSet<Metadata.XContentContext> context() {  
            state -> state.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY)  
    }  
                Settings.builder().put("location", randomRepoPath()),  
        final String snapshot2 = "snapshot-2";
        assertFalse(restoredRetentionLeases.toString() + " has no " + leaseId, restoredRetentionLeases.contains(leaseId));  
        List<RecoveryState> recoveryStates = client().admin()
import static org.opensearch.test.NodeRoles.nonClusterManagerNode;
            logger.info("checking snapshot completion using status");
        final CountDownLatch getRepoLatch = new CountDownLatch(1);
        logger.info("--> snapshot");
        assertThat(getCountForIndex("test-idx-some"), allOf(greaterThan(0L), lessThan(100L)));
        unblockNode("test-repo", blockedNode);
        final CountDownLatch clusterStateLatch = new CountDownLatch(1);
    public void testSnapshotTotalAndIncrementalSizes() throws Exception {  
        assertTrue(indexExists("test-idx-none"));  
            Writeable.Reader<T> reader,
        createIndex(indexName);
        }
        RestRequest getRepoRequest = new FakeRestRequest();
            .getRetentionLeaseStats()
    }
            .setRestoreGlobalState(true)  
                NonSnapshottableGatewayMetadata::fromXContent
                clusterStateLatch.countDown();  
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsResponse;  
            // After it was marked as completed in the cluster state - we need to check if it's completed on the file system as well
    }
            } catch (IOException e) {
        internalCluster().startClusterManagerOnlyNode();
                return super.visitFile(file, attrs);  
            .execute()  
        cluster().wipeIndices("test-idx-some");  
        }
            return Version.CURRENT;  
import org.opensearch.test.InternalTestCluster;
        updateClusterState(currentState -> {  
            return fromXContent(SnapshottableGatewayMetadata::new, parser);  
                equalTo(value)
                .actionGet();
                NonSnapshottableGatewayMetadata.TYPE,
        logger.info("--> start first node");  
        internalCluster().startNodes(2);
    }
            client().prepareIndex(indexName).setSource("new_field", "test" + i).execute().actionGet();
    public void testDataNodeRestartWithBusyClusterManagerDuringSnapshot() throws Exception {
                return true;
        createIndex(indexName);
import org.opensearch.rest.RestResponse;
                .setIgnoreUnavailable(true)
        final Path repoPath = randomRepoPath();
                greaterThanOrEqualTo(1)
        );
        int numberOfShards = 6;
        Files.walkFileTree(repoPath, new SimpleFileVisitor<Path>() {  
        @Override  
        logger.info("delete index during snapshot creation");
    public static class TestCustomMetadataPlugin extends Plugin {  
 * You may obtain a copy of the License at  
            clusterAdmin(),
        assertEquals(SnapshotState.SUCCESS, snapshotInfo.state());  
        public static SnapshottableMetadata fromXContent(XContentParser parser) throws IOException {
                .put(MockRepository.Plugin.PASSWORD_SETTING.getKey(), "verysecretpassword")  
                    .get(0)
        final String leaseId = randomAlphaOfLength(randomIntBetween(1, 10)).toLowerCase(Locale.ROOT);
        logger.info("--> change the test persistent setting and break it");
            client().admin()
        internalCluster().startClusterManagerOnlyNode();  
    }
            ),
        public static NonSnapshottableMetadata fromXContent(XContentParser parser) throws IOException {  
        @Override
        public static NamedDiff<Metadata.Custom> readDiffFrom(StreamInput in) throws IOException {
        }).sum();
        createRepository("test-repo", "fs", repoPath);  
            .setPartial(true)  
        createFullSnapshot(repositoryName, snapshot0);
            .setIndices("test-idx")  
                }
        internalCluster().stopRandomDataNode();
        assertThat(snapshot1IndexMetaFiles, is(snapshot0IndexMetaFiles));  
            }
/*
        public Version getMinimalSupportedVersion() {
        clusterAdmin().prepareHealth().setTimeout("30s").setWaitForNodes("1");
        createRepository("test-repo", "fs");
 * Unless required by applicable law or agreed to in writing,
        }  
        cluster().wipeIndices("_all");
        // check that snapshot completes  
        logger.info("--> done");
            @Override
        logger.info("--> delete repository");
        createRepository(repoName, "fs");
        ensureGreen();
        });
            .get()
        internalCluster().startDataOnlyNodes(2);
                .get()
        indexRandomDocs("test-idx-all", 100);
            return namedWritables;
        assertThat(stats.getIncrementalFileCount(), equalTo(stats.getProcessedFileCount()));
        }
        indexRandomDocs("test-idx", randomIntBetween(10, 100));  
        createRepository("test-repo-2", "fs", tempDir);
        ensureGreen("test-idx-all");
        logger.info("Cluster state: {}", clusterState);
        internalCluster().startClusterManagerOnlyNode();
                SnapshottableMetadata::readFrom,
                    .get(BrokenSettingPlugin.BROKEN_SETTING.getKey()),
        } catch (IllegalArgumentException ex) {
                .setSnapshots("test-snap")  
        assertThat(stats.getTotalSize(), greaterThanOrEqualTo(snapshot0FileSize));
        internalCluster().stopCurrentClusterManagerNode();
import static org.opensearch.index.seqno.RetentionLeaseActions.RETAIN_ALL;
 * SPDX-License-Identifier: Apache-2.0
            return namedXContents;  
    public static class SnapshotableGatewayNoApiMetadata extends TestCustomMetadata {  
            public void onRequestSent(  
    public static class SnapshottableMetadata extends TestCustomMetadata {  
            return readDiffFrom(TYPE, in);
    public void testAbortWaitsOnDataNode() throws Exception {  
import org.opensearch.rest.RestRequest;  
        logger.info("--> restore snapshot for the index that was snapshotted completely");
        final String sourceIdx = "test-idx";  
        logger.info("--> verify that snapshot was partial");
            .get();
            .cluster()  
            namedXContents.add(new NamedXContentRegistry.Entry(Metadata.Custom.class, new ParseField(name), parser));
                long requestId,
        waitForBlock(blockedNode, "test-repo", TimeValue.timeValueSeconds(60));  
                SnapshotsStatusResponse snapshotsStatusResponse = clusterAdmin().prepareSnapshotStatus("test-repo")  
        logger.info("--> restore incomplete snapshot - should fail");
import org.opensearch.core.xcontent.NamedXContentRegistry;
            super(data);
        // Pick one node and block it
        @Override
        clusterAdmin().prepareRestoreSnapshot("test-repo-2", "test-snap")
        internalCluster().startNode(nonClusterManagerNode());
        final String snapshotName = "snapshot-retention-leases";
                    .get(0)  
        }
                }  
        createRepository(repoName, "fs");
        logger.info("--> shrink the index");  
        logger.info("--> execution was blocked on node [{}], aborting snapshot", blockedNode);
            60L,  
        assertAcked(client().admin().indices().prepareClose("test-idx-all"));
            equalTo("before_snapshot_s_gw_noapi")
            .setIndices("test-idx")  
                }  
            TimeUnit.SECONDS
        assertAcked(prepareCreate("test-idx", 1, indexSettingsNoReplicas(1)));
        unblockNode("test-repo", dataNode);
import java.nio.file.FileVisitResult;
            indexRandom(true, indexRequestBuilders);  
        ensureGreen("test-idx");
import org.opensearch.indices.recovery.RecoveryState;  
        }  
        final List<String> dataNodes = internalCluster().startDataOnlyNodes(2);  
                    .get();
        final TransportService transportService = internalCluster().getInstance(TransportService.class, otherDataNode);  
        final List<Path> snapshot3IndexMetaFiles = findRepoMetaBlobs(repoPath);  
                .getRestoreInfo()
        final String dataNode = blockNodeWithIndex("test-repo", "test-idx");
                try {  
            Writeable.Reader<NamedDiff> diffReader,  
        ensureGreen();  
            return Metadata.API_ONLY;  
        client(internalCluster().getClusterManagerName()).admin()
    public void testSnapshotDuringNodeShutdown() throws Exception {
                SnapshotInfo snapshotInfo = getSnapshot("test-repo", "test-snap-2");
        maybeInitWithOldSnapshotVersion("test-repo", repoPath);
            assertThat(snapshotStatus.getShardsStats().getDoneShards(), lessThan(16));
import static org.hamcrest.Matchers.equalTo;
            }
            ) {  
            public boolean clearData(String nodeName) {
        final ShardStats shardStats = Arrays.stream(client().admin().indices().prepareStats(indexName).get().getShards())
        assertAcked(admin().indices().prepareDelete("test-idx"));
        logger.info("--> snapshot the shrunk index");
        }  
            assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), lessThan(16));  
        }
                .stream()
        public String getWriteableName() {
        internalCluster().restartRandomDataNode();  
        logger.info("--> abort snapshot");
            .get();  
            .get();
        clusterAdmin().prepareCreateSnapshot("test-repo", "test-snap").setWaitForCompletion(false).setIndices("test-idx").get();
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.PARTIAL));
        assertAcked(startDeleteSnapshot(repositoryName, snapshot0).get());  
            TestCustomMetadataPlugin.class,
     */
        logger.info("--> stopping cluster-manager node {} ", clusterManagerNode);
            client().prepareIndex(indexName).setSource("test", "init").execute().actionGet();
        internalCluster().startNodes(2);
        logger.info("--> restore snapshot");
            .setWaitForCompletion(true)
                .cluster()
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(restoreResponse.getRestoreInfo().successfulShards(), equalTo(shardCount));  
        client().execute(RetentionLeaseActions.Add.INSTANCE, new RetentionLeaseActions.AddRequest(shardId, leaseId, RETAIN_ALL, "test"))
        }
        private static final IllegalArgumentException EXCEPTION = new IllegalArgumentException("this setting goes boom");
                // TODO: There's likely a bug with other path types where cleanup seems to leave unexpected files
        }
        getRepoAction.handleRequest(getRepoRequest, new AbstractRestChannel(getRepoRequest, true) {  
        SnapshotStats stats = snapshots.get(0).getStats();  
                indexRequestBuilders[i] = client().prepareIndex(indexName).setSource("field", "value");
                .setIndices("test-idx-all", "test-idx-none", "test-idx-some", "test-idx-closed")  
        assertEquals(snapshotInfo.totalShards(), snapshotInfo.successfulShards());
        public static NamedDiff<Metadata.Custom> readDiffFrom(StreamInput in) throws IOException {  
        );
        }
        final int shardCount = randomIntBetween(1, 5);
        logger.info("--> stopping cluster-manager node");  
                    .persistentSettings()  
        createRepository(repoName, "mock");
        assertBusy(() -> {
            () -> assertThat(
            }
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), equalTo(6));
        }
            throw clusterStateError.get();
                NonSnapshottableMetadata::readFrom,
        @Override  
        SnapshotInfo snapshotInfo = waitForCompletion("test-repo", "test-snap", TimeValue.timeValueSeconds(60));  
        disableRepoConsistencyCheck("This test leaves behind a purposely broken repository");
                .execute(),  
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotStats;
        final String indexName = "test-blocks-1";
import org.opensearch.transport.client.node.NodeClient;
            }
        internalCluster().startDataOnlyNodes(2);  
                is(1)  
            SnapshotMissingException.class,
            SnapshotInfo snapshotInfo = getSnapshot("test-repo", "test-snap-2");  
        ) {
        internalCluster().startDataOnlyNode();
 * KIND, either express or implied.  See the License for the
        // Wait for green so the close does not fail in the edge case of coinciding with a shard recovery that hasn't fully synced yet  
                .get()
        assertThat(
        internalCluster().startNode();
        final long snapshot0FileSize = calculateTotalFilesSize(snapshot0Files);
        indexRandomDocs("test-idx", randomIntBetween(50, 100));
            }, 1, TimeUnit.MINUTES);  
        });  
        internalCluster().startClusterManagerOnlyNodes(2);
        }, nodeClient);
                .setWaitForEvents(Priority.LANGUID)
        private void registerBuiltinWritables() {
                if (blocked.get() && action.equals(SnapshotsService.UPDATE_SNAPSHOT_STATUS_ACTION_NAME)) {
    }
                final String fileName = file.getFileName().toString();  
        logger.info("--> restart random data node and add new data node to change index allocation");
            client.admin()
 * The OpenSearch Contributors require contributions made to  
        }
        setSettingValue.accept("new value");
import org.opensearch.action.admin.indices.stats.ShardStats;
        ensureGreen("test-idx");
        indexRandomDocs("test-idx", 100);  
        }  
                .setWaitForNodes("2")
            .actionGet();
            List<SnapshotStatus> snapshotStatuses = snapshotsStatusResponse.getSnapshots();
        clusterAdmin().prepareDeleteSnapshot("test-repo", "test-snap-delete").execute();
            return TYPE;
        ensureGreen();  
            .get();
import org.opensearch.common.action.ActionFuture;  
        logger.info("--> create snapshot to be deleted and then delete");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertRequestBuilderThrows;
        setSettingValue.accept("new value 2");  
        final Path repoPath = randomRepoPath();
        });
        assertFutureThrows(
            () -> client().admin().cluster().prepareGetSnapshots("test-repo").setSnapshots("test-snap").execute().actionGet()
        // Create index on two nodes and make sure each node has a primary by setting no replicas
                .setTimeout("1m")  
        logger.info("--> start 2 nodes");
            .admin()
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
        List<String> nodes = internalCluster().startNodes(2);
        public String getWriteableName() {
        indexRandomDocs("test-idx", 100);
            .setWaitForCompletion(true)
        @Override
import java.io.IOException;  
        if (randomBoolean()) {
        @Override
            .setRestoreGlobalState(false)
                .actionGet()  
import org.opensearch.node.Node;
                false,
        logger.info("number of shards: {}", numberOfShards);
            );
        public SnapshotableGatewayNoApiMetadata(String data) {  
        createRepository(repositoryName, "fs", repoPath);
                SnapshotableGatewayNoApiMetadata::readFrom,
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir()) // to get a new node id
        ensureStableCluster(1);
        snapshots = response.getSnapshots();
            namedWritables.add(new NamedWriteableRegistry.Entry(NamedDiff.class, name, diffReader));
            .setWaitForCompletion(false)
        RestoreSnapshotResponse restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap-2")
                    .get()
        RestRequest clusterStateRequest = new FakeRestRequest();  
        ensureGreen();
            ),
            .filter(s -> s.getShardRouting().shardId().equals(shardId))
        assertThat(restoreSnapshotResponse.getRestoreInfo().failedShards(), equalTo(0));
        }  
        @Override
 * license agreements. See the NOTICE file distributed with
        assertEquals(0, snapshotInfo.failedShards());
        maybeInitWithOldSnapshotVersion("test-repo", repoPath);
        logger.info("--> start 2 nodes");  
import org.opensearch.cluster.metadata.Metadata;
        static void breakSetting(boolean breakSetting) {  
            "test-repo",
        logger.info("--> make sure that properly setup repository can be registered on all nodes");
import org.opensearch.core.xcontent.XContentParser;  
        logger.info("--> restore snapshot for the index that didn't have any shards snapshotted successfully");
        docs = between(1, 5);  
        assertThat(anotherStats.getIncrementalSize(), greaterThanOrEqualTo(calculateTotalFilesSize(snapshotFilesDiff)));  
        }
            .prepareCreateSnapshot("test-repo", "test-snap")
     * can be restored when the node the shrunken index was created on is no longer part of
            assertThat(snapshotStatus.getShardsStats().getTotalShards(), equalTo(22));  
 */
            ((SnapshottableGatewayMetadata) metadata.custom(SnapshottableGatewayMetadata.TYPE)).getData(),  
                    .setNodes(false)
        assertSettingValue.accept("new value 2");  
            .setWaitForCompletion(false)
            .cluster()  
        restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap-2")  
        try {
        internalCluster().startNode();
import org.opensearch.action.index.IndexRequestBuilder;  
 * Modifications Copyright OpenSearch Contributors. See
            () -> clusterAdmin().prepareCreateSnapshot("test-repo", "test-snap-1")
        for (SnapshotShardFailure failure : snapshotInfo.shardFailures()) {
        disruption.stopDisrupting();
        }, 1, TimeUnit.MINUTES);  
            client().admin().cluster().prepareCreateSnapshot(repositoryName, snapshot1).setWaitForCompletion(true).get().status(),
            @Override
        assertThat(
        }
        assertThat(snapshot1IndexMetaFiles, is(snapshot0IndexMetaFiles));
            .get("test-idx");  
                .prepareUpdateSettings()
        blockAllDataNodes(repoName);
        logger.info("--> done");  
            );
                .successfulShards(),  
        for (String nodeName : dataNodes) {
import org.opensearch.transport.TransportMessageListener;
            .get();  
        logger.info("--> create an index that will be closed");  
        final AtomicBoolean blocked = new AtomicBoolean(true);
                    if (PeerRecoveryTargetService.Actions.FILE_CHUNK.equals(action)) {
        public static SnapshotableGatewayNoApiMetadata readFrom(StreamInput in) throws IOException {
        stopNode(blockedNode);
            return readDiffFrom(TYPE, in);  
        assertThat(restoreSnapshotResponse.getRestoreInfo(), notNullValue());  
            .actionGet();  
        }
        internalCluster().startClusterManagerOnlyNodes(3);
        logger.info("--> close the index");
        logger.info("--> restore the shrunk index and ensure all shards are allocated");  
            String name,
        final AtomicReference<AssertionError> getRepoError = new AtomicReference<>();
        public static SnapshottableGatewayMetadata fromXContent(XContentParser parser) throws IOException {
        assertAcked(client().admin().indices().prepareCreate(indexName).setSettings(indexSettingsNoReplicas(shardCount)));
            if ((s.equals("default") == false && breakSetting)) {
import org.opensearch.core.common.io.stream.StreamInput;
        internalCluster().startDataOnlyNode(dataSettings);  
        SnapshotInfo snapshotInfo = waitForCompletion(repoName, "test-snap", TimeValue.timeValueSeconds(600));
        blockAllDataNodes("test-repo");  
    @Override
        for (int i = 0; i < docs; i++) {  
            clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap-2")  
        );
            () -> assertThat(
        }
import org.opensearch.common.CheckedFunction;
        final List<Path> snapshot0IndexMetaFiles = findRepoMetaBlobs(repoPath);  
        internalCluster().restartRandomDataNode(new InternalTestCluster.RestartCallback() {
        expectThrows(  
        logger.info("--> execution was blocked on node [{}], shutting it down", blockedNode);  
        // Make sure the first node is elected as cluster-manager  
import java.util.Arrays;
    }
        final String dataNode = blockNodeWithIndex("test-repo", "test-idx");
            .prepareCreateSnapshot("test-repo", "test-snap")
import java.util.Locale;
        createRepository(  
            }
        logger.info("--> restart all nodes");
        @Override
                    }
        public static NonSnapshottableGatewayMetadata fromXContent(XContentParser parser) throws IOException {
        );  
import java.util.concurrent.atomic.AtomicBoolean;  
        logger.info("--> start second node");
        clusterAdmin().prepareCreateSnapshot("test-repo", "test-snap").setWaitForCompletion(false).setIndices("test-idx").get();  
        return Arrays.asList(  
        assertDocCount(indexName, snapshotDocCount);  
        );  
        assertTrue(shardStats + ": " + retentionLeases, retentionLeases.contains(leaseId));  
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
        final Settings dataSettings = Settings.builder()
        setDisruptionScheme(disruption);
            .cluster()
        assertTrue(getRepoLatch.await(1, TimeUnit.SECONDS));  
        }
        );
        ensureGreen();
    public void testThatSensitiveRepositorySettingsAreNotExposed() throws Exception {
            }, 1, TimeUnit.MINUTES);
        assertAcked(prepareCreate(sourceIdx, 0, indexSettingsNoReplicas(between(2, 10))));
            .setIndices("test-idx-none")
        private static boolean breakSetting = false;  
        assertThat(restoreSnapshotResponse.getRestoreInfo().successfulShards(), equalTo(4));  
            builder.metadata(metadataBuilder);  
        final List<Path> snapshot1IndexMetaFiles = findRepoMetaBlobs(repoPath);  
        assertEquals(restoreResponse.getRestoreInfo().totalShards(), restoreResponse.getRestoreInfo().successfulShards());
        assertThat(  
                .get();
        restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap-2")
        final AtomicReference<AssertionError> clusterStateError = new AtomicReference<>();
    public void testDataNodeRestartAfterShardSnapshotFailure() throws Exception {  
        assertThat(stats.getIncrementalSize(), equalTo(stats.getProcessedSize()));
 * not use this file except in compliance with the License.
import static org.hamcrest.Matchers.nullValue;
            try {
        // Pick one node and block it  
                }  
    }  
        logger.info("-->  creating repository");  
            // When cluster-manager node is closed during this test, it sometime manages to delete the snapshot files before  
        createRepository(
            .execute();
        assertThat(snapshotInfo.failedShards(), greaterThan(0));  
            .get();
        final CreateSnapshotResponse createSnapshotResponse = startFullSnapshot(repoName, "test-snap", true).get();  
        ensureGreen();  
    }
        assertThat(anotherStats.getTotalSize(), greaterThanOrEqualTo(snapshot1FileSize));  
        logger.info("--> start 2 nodes");  
            );
import org.opensearch.cluster.NamedDiff;
        );  
        logger.info("--> stopping node [{}]", blockedNode);  
        private final List<NamedXContentRegistry.Entry> namedXContents = new ArrayList<>();  
            null,  
                .entries()
        assertThat(stats.getIncrementalFileCount(), equalTo(stats.getTotalFileCount()));
        createRepository("test-repo", "fs");
        assertThat(restoreSnapshotResponse.getRestoreInfo().failedShards(), equalTo(6));  
            metadataBuilder.putCustom(NonSnapshottableMetadata.TYPE, new NonSnapshottableMetadata("before_snapshot_ns"));
        final List<Path> snapshot0IndexMetaFiles = findRepoMetaBlobs(repoPath);
        createRepository(repo, "fs", Settings.builder().put("location", randomRepoPath()).put("compress", randomBoolean()));
        assertThat(restoreSnapshotResponse.getRestoreInfo(), notNullValue());
            .get();
        @Override  
        logger.info("-->  restarting second data node, which should cause the primary shard on it to be failed");  
                .actionGet();
        }, Setting.Property.NodeScope, Setting.Property.Dynamic);
        // Expect two files to remain in the repository:
    private List<Path> scanSnapshotFolder(Path repoPath) throws IOException {
import org.opensearch.test.disruption.BusyClusterManagerServiceDisruption;
        private <T extends Metadata.Custom> void registerMetadataCustom(  
    }
        );
                clusterAdmin().prepareSnapshotStatus("test-repo")
            "mock",
        cluster().wipeIndices("test-idx-none");
import org.opensearch.core.index.shard.ShardId;  
            .setWaitForCompletion(true)
                .put(BlobStoreRepository.SHARD_PATH_TYPE.getKey(), RemoteStoreEnums.PathType.FIXED)
            "test-repo",
            );
        final int snapshotDocCount = iterations(10, 1000);
        }
    }
            .get();
                .setPersistentSettings(Settings.builder().put(BrokenSettingPlugin.BROKEN_SETTING.getKey(), value))
import org.opensearch.index.seqno.RetentionLeases;
            equalTo(RestStatus.OK)  
                    files.add(file);
/*  
        indexRandomDocs("test-idx", randomIntBetween(50, 100));
        ArrayList<Path> snapshotFilesDiff = new ArrayList<>(snapshot1Files);
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
@ClusterScope(scope = Scope.TEST, numDataNodes = 0)  
                return super.visitFile(file, attrs);
        logger.info("-->  creating date math snapshot");
    }
            TimeUnit.MINUTES  
                    .setRoutingTable(false)  
            if (randomBoolean()) {  
        final String repositoryName = "repo-" + indexName;
            equalTo("after_snapshot_ns_gw")
        );  
            return Version.CURRENT;
import org.opensearch.rest.action.admin.cluster.RestGetRepositoriesAction;  
        logger.info("--> restore snapshot");
 * this file be licensed under the Apache-2.0 license or a
        createRepository("test-repo", "mock", repoPath);  
            return readDiffFrom(TYPE, in);
                .setRestoreGlobalState(true)  
        internalCluster().fullRestart();
        assertAcked(client().admin().indices().prepareDelete(shrunkIdx).get());  
        logger.info("Cluster state: {}", clusterState);  
        logger.info("--> snapshot");  
        // Shouldn't be returned as part of API response
            );
            () -> assertThat(clusterAdmin().prepareHealth(indexName).execute().actionGet().getRelocatingShards(), greaterThan(0)),
        @Override
            );  
        logger.info("--> verify that snapshot was successful");
                String action,  
        logger.info("--> check that at least half of the shards had some reuse: [{}]", reusedShards);  
            .get()  
        for (int i = 0; i < docs; i++) {  
        final String snapshot0 = "snapshot-0";  
        assertThat(
        // Drop all file chunk requests so that below relocation takes forever and we're guaranteed to run the snapshot in parallel to it
import org.opensearch.test.TestCustomMetadata;  
        ensureGreen();
import java.util.Collections;
    }  
        OpenSearchIntegTestCase.putRepositoryRequestBuilder(  
        logger.debug("--> restore index {} from snapshot", indexName);
        assertThat(  
        Metadata metadata = clusterState.getMetadata();
        logger.info("--> make sure old repository wasn't restored");  
        ensureGreen();
        Path repo = randomRepoPath();
        assertAcked(clusterAdmin().prepareDeleteRepository("test-repo"));  
            assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(10));
                    .get()
                        return;  
            Settings.builder().put("location", repoPath).put("random", randomAlphaOfLength(10)).put("wait_after_unblock", 200)
        final String snapshot0 = "snapshot-0";  
        final int numberOfShards = getNumShards("test-idx").numPrimaries;
import org.opensearch.test.transport.MockTransportService;
                null,
                .execute()  
            assertTrue(snapshotInfo.state().completed());
            return readFrom(NonSnapshottableMetadata::new, in);
                .setWaitForCompletion(true)  
        }
            otherDataNode,
        final ShardId shardId = new ShardId(resolveIndex(indexName), randomIntBetween(0, shardCount - 1));  
        for (int i = 0; i < docs; i++) {
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            logger.debug("--> indexing {} extra docs into {}", extraDocCount, indexName);
        }
        logger.info("-->  snapshot");
            }
 * this work for additional information regarding copyright
        public static NonSnapshottableGatewayMetadata readFrom(StreamInput in) throws IOException {
        }  
            // with SnapshotMissingException
        logger.info("--> shutdown one of the nodes");
 * under the License.  
                SnapshottableMetadata::fromXContent
        logger.info("--> wait until the snapshot is done");  
        return files;
        public EnumSet<Metadata.XContentContext> context() {
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
import org.opensearch.transport.client.Client;  
        assertThat(sne.getMessage(), containsString("Indices don't have primary shards"));
        });
            .actionGet();
}  
                NonSnapshottableMetadata::fromXContent
            registerBuiltinWritables();  
        createRepository(repositoryName, "fs", repoPath);  
import org.opensearch.cluster.ClusterState;  
        assertThat(clusterAdmin().prepareGetRepositories("test-repo-2").get().repositories().size(), equalTo(1));
        assertBusy(  
        final List<Path> snapshot1Files = scanSnapshotFolder(repoPath);
            .get();
            SnapshotInfo snapshotInfo = snapshotsStatusResponse.getSnapshots().get(0);
            assertBusy(() -> {
            return readFrom(SnapshottableMetadata::new, in);  
            metadataBuilder.putCustom(NonSnapshottableMetadata.TYPE, new NonSnapshottableMetadata("after_snapshot_ns"));
        assertThat(getSnapshot("test-repo", "test-snap").state(), equalTo(SnapshotState.SUCCESS));  
                .actionGet();
        internalCluster().startDataOnlyNodes(2);
        logger.debug("--> adding retention lease with id {} to {}", leaseId, shardId);  
        );  
        }
            assertThat(snapshotInfo.totalShards(), is(2));  
        logger.info("--> shutdown one of the nodes that should make half of the shards unavailable");
        }  
        indexRandomDocs("test-idx-closed", 100);  
            }  
        // snapshot could be taken before or after a day rollover  
                    .prepareState()
        List<Path> snapshot0Files = scanSnapshotFolder(repoPath);  
 * compatible open source license.
        clusterAdmin().prepareHealth().setTimeout("30s").setWaitForNodes("2");
        final String shrunkIdx = "test-idx-shrunk";
                SnapshottableMetadata::readDiffFrom,  
            TimeUnit.SECONDS  
            .get();  
        disruption.startDisrupting();
    public void testRegistrationFailure() {
        // add few docs - less than initially
            MockRepository.Plugin.class,
        IndexRequestBuilder[] indexRequestBuilders = new IndexRequestBuilder[snapshotDocCount];
        assertThat(getCountForIndex("test-idx-some"), allOf(greaterThan(0L), lessThan(100L)));
    }  
        logger.info("--> check that custom persistent metadata was restored");
        logger.info("--> Go through a loop of creating and deleting a snapshot to trigger repository cleanup");
    public static class NonSnapshottableGatewayMetadata extends TestCustomMetadata {  
            assertTrue(snapshotInfo.state().toString(), snapshotInfo.state().completed());
        assertAcked(
                SnapshottableGatewayMetadata::readFrom,
        createIndex("test-idx");
            equalTo(false)
import org.opensearch.rest.action.admin.cluster.RestClusterStateAction;
        final long snapshot1FileSize = calculateTotalFilesSize(snapshot1Files);
            registerMetadataCustom(  
                .put("random", randomAlphaOfLength(10))
        public String getWriteableName() {
 * Licensed to Elasticsearch under one or more contributor  
                .setSettings(Settings.builder().put("index.blocks.write", true))
        int docs = between(10, 100);  
/*  
            }
            return readFrom(SnapshotableGatewayNoApiMetadata::new, in);  
            metadataBuilder.putCustom(SnapshottableMetadata.TYPE, new SnapshottableMetadata("before_snapshot_s"));
        assertThat(metadata.custom(NonSnapshottableMetadata.TYPE), nullValue());
                .execute()
        }
import java.util.List;
        assertAcked(prepareCreate("test-idx-all", 1, indexSettingsNoReplicas(6)));  
