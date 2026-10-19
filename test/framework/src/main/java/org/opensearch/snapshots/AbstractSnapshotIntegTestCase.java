import org.opensearch.indices.RemoteStoreSettings;
        return oldVersionSnapshot;
 * The OpenSearch Contributors require contributions made to
                boolean found = false;
        }
        return clusterAdmin().prepareDeleteSnapshot(repoName, snapshotName).execute();
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.action.search.SearchRequest;
                state.metadata(),
        return snapshotInfo;
        final PlainActionFuture<Void> future = PlainActionFuture.newFuture();
        final String oldVersionSnapshot = OLD_VERSION_SNAPSHOT_PREFIX + version.id;
            Collections.emptyList(),
    public static void assertFileCount(Path dir, int expectedCount) throws IOException {
                    break;
                if (mockRepository.blocked()) {
        String indexName,
        Files.write(
                public void onClusterServiceClose() {
            .put("index.refresh_interval", "300s")
        final BlobStoreRepository remoteStoreRepository = (BlobStoreRepository) repositoriesService.repository(remoteStoreRepositoryName);
 *
        });
import org.opensearch.cluster.ClusterStateObserver;
        logger.info("--> waiting for cluster-manager to finish all repo operations on its SNAPSHOT pool");
import java.util.concurrent.TimeoutException;
            JsonXContent.jsonXContent.createParser(
        logger.info("--> deleting snapshot [{}] from repo [{}]", snapshotName, repoName);
                getRepositoryData(repoName).getGenId(),
        blockDataNode(repoName, dataNode);
                }
        logger.info("--> wait for [{}] snapshots to show up in the cluster state", count);
        final ActionFuture<CreateSnapshotResponse> fut = startFullSnapshot(repoName, snapshotName);
import org.opensearch.common.action.ActionFuture;
        if (statePredicate.test(observer.setAndGetObservedState()) == false) {
        return clusterAdmin().prepareCreateSnapshot(repoName, snapshotName).setWaitForCompletion(true).setPartial(partial).execute();
            .setIndices(indices.toArray(Strings.EMPTY_ARRAY))
                    return true;
            for (SnapshotsService snapshotsService : internalCluster().getInstances(SnapshotsService.class)) {
        }
        settingsBuilder.put("location", location);
    }
            true
                    .entries()) {
import static org.hamcrest.Matchers.greaterThan;
import org.opensearch.repositories.Repository;
            true
            observer.waitForNextChange(new ClusterStateObserver.Listener() {
            0L,
            .setRenameReplacement(restoredIndexName);
 */
        Settings.Builder settingsBuilder = randomRepositorySettings();
        );
        return clusterManagerName;
        assertThat(
        .build();
            future.get(30L, TimeUnit.SECONDS);
        future.get();
    protected SnapshotInfo createSnapshot(String repositoryName, String snapshot, List<String> indices) {
        assertDocCount(index, numdocs);
            0,
    }
            }
                    final String name = repositoryMetadata.name();
        settings.put("location", randomRepoPath()).put("compress", compress);
                assertTrue(snapshotsService.assertAllListenersResolved());
            f -> repo.finalizeSnapshot(
        throws InterruptedException {
        for (RepositoriesService repositoriesService : internalCluster().getDataNodeInstances(RepositoriesService.class)) {
        internalCluster().assertConsistentHistoryBetweenTranslogAndLuceneIndex();
import org.opensearch.core.common.bytes.BytesReference;
import org.opensearch.action.index.IndexRequestBuilder;
    /**
    }
    public AbstractSnapshotIntegTestCase(Settings nodeSettings) {
        logger.info("--> unblocking [{}] on node [{}]", repository, node);
 * Modifications Copyright OpenSearch Contributors. See
    public static void blockDataNode(String repository, String nodeName) {
        try (RemoteBufferedOutputDirectory lockDirectory = new RemoteBufferedOutputDirectory(blobContainer)) {
            settingsBuilder.put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true);
            false,
    */
        BlobContainer blobContainer = remoteStoreRepository.blobStore().blobContainer(shardLevelBlobPath);
        awaitClusterState(state -> state.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY).entries().size() == count);
     * generations (the existence of which would short-circuit checks for the repo containing old version snapshots)
    }
    }
                }
            .setWaitForCompletion(false)
        );
        final SnapshotId snapshotId = new SnapshotId(snapshotName, UUIDs.randomBase64UUID(random()));
        settingsBuilder.put("location", location);
     * Adds a snapshot in state {@link SnapshotState#FAILED} to the given repository.
        blockClusterManagerFromDeletingIndexNFile(repoName);
import org.opensearch.index.IndexModule;
        final ThreadPool clusterManagerThreadPool = internalCluster().getClusterManagerNodeInstance(ThreadPool.class);
import java.nio.file.Files;
        assertThat("This hack only works on an empty repository", getRepositoryData(repoName).getSnapshotIds(), empty());
import org.opensearch.indices.replication.common.ReplicationType;
        logger.info("--> restoring snapshot [{}] of {} in [{}] to [{}]", snapshotName, indexName, repositoryName, restoredIndexName);
 * KIND, either express or implied.  See the License for the
        final RepositoriesMetadata repositoriesMetadata = state.metadata().custom(RepositoriesMetadata.TYPE);
import org.opensearch.cluster.ClusterState;
            .get();
        );
 *
            logger.info("--> skipped repo consistency checks because [{}]", skipRepoConsistencyCheckReason);
import org.opensearch.cluster.service.ClusterService;
        final ClusterService clusterService = internalCluster().getCurrentClusterManagerNodeInstance(ClusterService.class);
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
    // threads so that blocking some threads on one repository doesn't block other repositories from doing work
import org.opensearch.repositories.ShardGenerations;
 *
        }
/*
import org.opensearch.core.xcontent.XContentBuilder;
        );
        super(Settings.EMPTY);
        String snapshotName,
/*
            MockRepository mockRepository = (MockRepository) repositoriesService.repository(repository);
 */
        logger.info("--> Deleting snapshot [{}] to repo [{}]", snapshotName, repoName);
        }
                @Override
        ((MockRepository) internalCluster().getClusterManagerNodeInstance(RepositoriesService.class).repository(repositoryName))
        final SnapshotInfo snapshotInfo = response.getSnapshotInfo();
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
 */
                        break;
            .setWaitForCompletion(true)
        settings.put("location", randomRepoPath());
    protected static Settings.Builder indexSettingsNoReplicas(int shards) {
    }
        if (WRITABLE_WARM_INDEX_SETTING.get(settings)) {
        final Repository repo = internalCluster().getCurrentClusterManagerNodeInstance(RepositoriesService.class).repository(repoName);
            remoteStoreRepository.basePath(),
                MockRepository mockRepository = (MockRepository) repositoriesService.repository(repository);
    }
import org.opensearch.common.Priority;
            builder.setIndexSettings(indexSettings);
        for (int i = 0; i < builders.length; i++) {
        final Settings.Builder settings = Settings.builder();
    }
        return deleteSnapshot(repoName, snapshotName);
    }
        return PlainActionFuture.get(repository::getRepositoryData);
import org.opensearch.index.store.RemoteBufferedOutputDirectory;
        fail("No nodes for the index " + indexName + " found");
    }
    }
    public static String blockNodeWithIndex(final String repositoryName, final String indexName) {
        logger.info("--> creating snapshot [{}] of {} in [{}]", snapshot, indices, repositoryName);
    private static final String OLD_VERSION_SNAPSHOT_PREFIX = "old-version-snapshot-";
            builders[i] = client().prepareIndex(index).setId(Integer.toString(i)).setSource("field1", "bar " + i);
    private String skipRepoConsistencyCheckReason;
        final SnapshotInfo snapshotInfo = new SnapshotInfo(
        }, 30L, TimeUnit.SECONDS);
        Settings.Builder settingsBuilder = randomRepositorySettings();
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
    protected void assertDocCount(String index, long count) {
            @Override
        );
            }
    public static long getFailureCount(String repository) {
        createIndex(indexName, indexSettings);
import static org.hamcrest.Matchers.equalTo;
        return settings;
     * @param snapshotName name for the new failed snapshot
            .put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), EnableAllocationDecider.Rebalance.NONE)
import static org.hamcrest.Matchers.is;
    }
        final RepositoryData downgradedRepoData = RepositoryData.snapshotsFromXContent(
import org.opensearch.repositories.RepositoriesService;
                return FileVisitResult.CONTINUE;
    protected ActionFuture<CreateSnapshotResponse> startFullSnapshot(String repoName, String snapshotName, boolean partial) {
import org.opensearch.search.builder.SearchSourceBuilder;
        if (skipRepoConsistencyCheckReason == null) {
        Settings.Builder settingsBuilder = Settings.builder()
        return Settings.builder()
            return node;
    }
                // Make sure that snapshot clean up operations are finished
            ((MockRepository) repositoriesService.repository(repository)).blockOnDataFiles(true);
    @Override
        return getRepositoryData(internalCluster().getCurrentClusterManagerNodeInstance(RepositoriesService.class).repository(repository));
            clusterAdmin().prepareGetRepositories()
        final List<Path> found = new ArrayList<>();
    }
import org.opensearch.repositories.RepositoryData;
                        clusterAdmin().prepareDeleteSnapshot(name, OLD_VERSION_SNAPSHOT_PREFIX + "*").get();
            Thread.sleep(100);
    }
    protected Settings.Builder getRepositorySettings(Path location, String basePath, boolean shallowCopyEnabled) {
            "We can only manually insert a snapshot into a repository that does not have a generation tracked in the CS",
        return null;
    /**
    protected Settings getRemoteStoreBackedIndexSettings() {
        }
    }
    /*
            settings.put("compression_type", randomFrom(CompressorRegistry.registeredCompressors().keySet()));
                .get()
                return;
        assertThat(createSnapshotResponse.getSnapshotInfo().totalShards(), is(0));
        assertBusy(() -> {
        if (basePath != null) {
    @Override
            ((MockRepository) repositoriesService.repository(repository)).unblock();
    protected ActionFuture<AcknowledgedResponse> startDeleteSnapshot(String repoName, String snapshotName) {
    protected boolean addMockIndexStorePlugin() {
    }
        .put("thread_pool.snapshot.max", 5)
    }
            @Override
        ((MockRepository) internalCluster().getInstance(RepositoriesService.class, nodeName).repository(repository)).setBlockOnAnyFiles(
    }
 * this file be licensed under the Apache-2.0 license or a
            .setBlockOnDeleteIndexFile();
            );
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT);
        PlainActionFuture.<RepositoryData, Exception>get(
import java.nio.file.FileVisitResult;
    }
        assertNotNull(reason);
                for (SnapshotsInProgress.Entry entry : stateResponse.getState()
            @Override
            }
                count.incrementAndGet();
        });
        .put("thread_pool.snapshot.core", 5)
    protected void createIndexWithContent(String indexName) {
        final CreateSnapshotResponse createSnapshotResponse = clusterAdmin().prepareCreateSnapshot(repoName, oldVersionSnapshot)
            if (snapshotInfo.state().completed()) {
    }
    protected Settings.Builder snapshotRepoSettingsForShallowCopy() {
            }
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
    protected Settings.Builder getRepositorySettings(Path location, boolean shallowCopyEnabled) {
        if (rarely()) {
                    assertEquals(stat.getActive(), 0);
import java.util.ArrayList;
        }
        final String clusterManagerName = internalCluster().getClusterManagerName();
                }
            .setRenamePattern(indexName)
        );
    public void waitForBlock(String node, String repository, TimeValue timeout) throws InterruptedException {
    }
import java.nio.file.StandardOpenOption;
        }
    @After
                f
 * Unless required by applicable law or agreed to in writing,
    protected void createIndexWithRandomDocs(String indexName, int docCount) throws InterruptedException {
        return fut;
    }
                .repositories()
    }
        final ClusterService clusterService = internalCluster().getInstance(ClusterService.class, viaNode);
        ((MockRepository) internalCluster().getInstance(RepositoriesService.class, nodeName).repository(repository)).blockOnSegmentFiles(
        logger.info("--> creating full snapshot [{}] to repo [{}]", snapshotName, repoName);
import org.junit.After;
import java.nio.file.Path;
        }
            .cluster()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertThat(snapshotInfo.state(), is(SnapshotState.SUCCESS));
        long failureCount = 0;
            .build();
        ((MockRepository) internalCluster().getInstance(RepositoriesService.class, nodeName).repository(repository)).blockOnDataFiles(true);
import static org.hamcrest.Matchers.hasSize;
 * under the License.
        assertThat(snapshotInfos, hasSize(1));
        IndexRequestBuilder[] builders = new IndexRequestBuilder[numdocs];
        final CreateSnapshotResponse response = client().admin()
                Function.identity(),
        String restoredIndexName,
        }
        }
        assertThat(snapshotInfo.successfulShards(), greaterThan(0));
        final Settings.Builder settings = Settings.builder();
        final RepositoriesService repositoriesService = internalCluster().getCurrentClusterManagerNodeInstance(RepositoriesService.class);
     * @param repoName     repository to add snapshot to
        fail("Timeout waiting for node [" + node + "] to be blocked");
    public SnapshotInfo waitForCompletion(String repository, String snapshotName, TimeValue timeout) throws InterruptedException {
                @Override
            .prepareCreateSnapshot(repositoryName, snapshot)
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
        return clusterAdmin().prepareDeleteSnapshot(repoName, snapshotName).execute();
                return updater.apply(currentState);
        logger.info("--> indexing [{}] documents into [{}]", numdocs, index);
            0
        return settingsBuilder;
            viaNode,
import java.util.concurrent.TimeUnit;
}
    }
            state -> state.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY).entries().isEmpty()
    }
    /**
        ensureGreen(indexName);
    protected void createIndexWithContent(String indexName, Settings indexSettings) {
import org.opensearch.repositories.blobstore.BlobStoreTestUtil;
        assertEquals("Unexpected file count, found: [" + found + "].", expectedCount, found.size());
            .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.FS.getSettingsKey())
        return failureCount;
    }
        skipRepoConsistencyCheckReason = reason;
        }, timeout.millis(), TimeUnit.MILLISECONDS);
        assertThat(snapshotInfo.state(), is(SnapshotState.SUCCESS));
import java.util.function.Function;
     */
    }
            @Override
 * this work for additional information regarding copyright
        return startFullSnapshot(repoName, snapshotName, false);
    }
    }
        MockRepository mockRepository = (MockRepository) repositoriesService.repository(repository);
    protected static final Settings LARGE_SNAPSHOT_POOL_SETTINGS = Settings.builder()
    protected SnapshotInfo getSnapshot(String repository, String snapshot) {
        indexRandomDocs(indexName, docCount);
                .filter(repositoryMetadata -> !repositoryMetadata.name().endsWith(TEST_REMOTE_STORE_REPO_SUFFIX))
        }
            settingsBuilder.put("base_path", basePath);
        index(indexName, "_doc", "some_id", "foo", "bar");
        }
                future.onResponse(null);
                future.onFailure(e);
import org.opensearch.cluster.SnapshotDeletionsInProgress;
 * the Apache License, Version 2.0 (the "License"); you may
    }
    }
            settingsBuilder.put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true);
import org.opensearch.plugins.Plugin;
        final CreateSnapshotResponse response = client().admin()
    }
        assertBusy(() -> {
            ),
                snapshotInfo,
        RestoreSnapshotRequestBuilder builder = client().admin()
            Collections.emptyList(),
        while (System.currentTimeMillis() - start < timeout.millis()) {
        internalCluster().stopRandomNode(settings -> settings.get("node.name").equals(node));
            client(),
public abstract class AbstractSnapshotIntegTestCase extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
    }
            .get();
                if (ThreadPool.Names.SNAPSHOT.equals(stat.getName())) {
    protected final static String TEST_REMOTE_STORE_REPO_SUFFIX = "__rs";
            .setBlockAndFailOnWriteIndexFile();
    protected void indexRandomDocs(String index, int numdocs) throws InterruptedException {
            .cluster()
        } else {
            public ClusterState execute(ClusterState currentState) {
            return false;
                });
    protected void awaitNumberOfSnapshotsInProgress(int count) throws Exception {
        Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
        final boolean blocked = waitUntil(() -> {
    protected void addBwCFailedSnapshot(String repoName, String snapshotName, Map<String, Object> metadata) throws Exception {
    @After
            final SnapshotInfo snapshotInfo = getSnapshot(repository, snapshotName);
        for (RepositoriesService repositoriesService : internalCluster().getDataNodeInstances(RepositoriesService.class)) {
            metadata,
    ) {
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
    protected void maybeInitWithOldSnapshotVersion(String repoName, Path repoPath) throws IOException {
import org.opensearch.core.rest.RestStatus;
    protected Collection<Class<? extends Plugin>> nodePlugins() {
import org.opensearch.node.NodeClosedException;
        long start = System.currentTimeMillis();
import java.io.IOException;
    public static void blockNodeOnAnySegmentFile(String repository, String nodeName) {
            settingsBuilder.put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true);
            segmentsPathFixedPrefix
    }
            settings.put("chunk_size", randomIntBetween(100, 1000), ByteSizeUnit.BYTES);
import java.util.Collections;
    }
import java.util.Map;
    public AbstractSnapshotIntegTestCase() {
        return settingsBuilder.build();
    }
        }
    protected ActionFuture<AcknowledgedResponse> deleteSnapshot(String repoName, String snapshotName) {
            if (mockRepository.blocked()) {
            final PlainActionFuture<Void> future = PlainActionFuture.newFuture();
                    future.onResponse(null);
                true
     *
import org.opensearch.threadpool.ThreadPoolStats;
            .prepareRestoreSnapshot(repositoryName, snapshotName)
    }
import org.opensearch.common.blobstore.BlobContainer;
     * Workaround to simulate BwC situation: taking a snapshot without indices here so that we don't create any new version shard
import org.opensearch.Version;
    protected SnapshotInfo createFullSnapshot(String repoName, String snapshotName) {
            mockRepository.setFailReadsAfterUnblock(true);
        createRepository(repoName, type, Settings.builder().put("location", location));
import org.opensearch.common.UUIDs;
                ShardGenerations.EMPTY,
import java.util.concurrent.atomic.AtomicInteger;
        String segmentsPathFixedPrefix = RemoteStoreSettings.CLUSTER_REMOTE_STORE_SEGMENTS_PATH_PREFIX.get(getNodeSettings());
    public static void blockAllDataNodes(String repository) {
        long start = System.currentTimeMillis();
            StandardOpenOption.TRUNCATE_EXISTING
/*
import java.util.List;
 * SPDX-License-Identifier: Apache-2.0
        return client().search(
            .setIndices("does-not-exist-for-sure-*")
import org.opensearch.repositories.blobstore.BlobStoreRepository;
                ClusterStateResponse stateResponse = clusterAdmin().prepareState().get();
    protected void awaitClusterState(String viaNode, Predicate<ClusterState> statePredicate) throws Exception {
import org.opensearch.cluster.SnapshotsInProgress;
                found.add(file);
        SnapshotInfo snapshotInfo = response.getSnapshotInfo();
            }
     * @param metadata     snapshot metadata to write (as returned by {@link SnapshotInfo#userMetadata()})
            for (RepositoriesService repositoriesService : internalCluster().getDataNodeInstances(RepositoriesService.class)) {
    }
        super(nodeSettings);
            // Rebalancing is causing some checks after restore to randomly fail
import org.opensearch.cluster.ClusterStateUpdateTask;
    protected RepositoryData getRepositoryData(Repository repository) {
        ensureGreen();
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
                public void onTimeout(TimeValue timeout) {
import java.util.Collection;
    }
        logger.info("--> creating index [{}]", indexName);
        if (shallowCopyEnabled) {
            0,
    }
            new SearchRequest(new SearchRequest(indexName).source(new SearchSourceBuilder().size(0).trackTotalHits(true)))
    protected Settings.Builder randomRepositorySettings() {
            repositoryData.getGenId()
        for (RepositoriesService repositoriesService : internalCluster().getDataOrClusterManagerNodeInstances(RepositoriesService.class)) {
    public static String blockClusterManagerFromFinalizingSnapshotOnSnapFile(final String repositoryName) {
import org.opensearch.common.settings.Settings;
                }
        return WRITABLE_WARM_INDEX_SETTING.get(settings) == false;
                public void onNewClusterState(ClusterState state) {
        assertEquals(getCountForIndex(index), count);
    }
        logger.info("--> waiting for [{}] to be blocked on node [{}]", repository, node);
        for (String node : internalCluster().nodesInclude(indexName)) {
    As a result of this wrapping the local directory of Composite Directory does not satisfy the assertion that local directory must be of type FSDirectory
                jsonBuilder.toString().replace(Version.CURRENT.toString(), version.toString())
    }
    public static int numberOfFiles(Path dir) throws IOException {
                    if (repositoryMetadata.settings().getAsBoolean("readonly", false) == false) {
import java.nio.file.attribute.BasicFileAttributes;
import org.opensearch.cluster.metadata.RepositoryMetadata;
            .cluster()
import org.opensearch.common.blobstore.BlobPath;
        indexRandom(true, builders);
            @Override
    }
                    }
        final ThreadPool threadPool = internalCluster().getInstance(ThreadPool.class, viaNode);
import org.opensearch.common.xcontent.json.JsonXContent;
    // Large snapshot pool settings to set up nodes for tests involving multiple repositories that need to have enough
    protected void createRepository(String repoName, String type) {
                    final Snapshot curr = entry.snapshot();
    protected ActionFuture<CreateSnapshotResponse> startFullSnapshot(String repoName, String snapshotName) {
        settings.put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), Boolean.TRUE);
        });
        for (RepositoriesService repositoriesService : internalCluster().getDataNodeInstances(RepositoriesService.class)) {
    protected void awaitClusterManagerFinishRepoOperations() throws Exception {
                    future.onFailure(new NodeClosedException(clusterService.localNode()));
            is(RepositoryData.UNKNOWN_REPO_GEN)
 * Licensed to Elasticsearch under one or more contributor
        return snapshotInfo;
    public static String blockClusterManagerFromFinalizingSnapshotOnIndexFile(final String repositoryName) {
            0L,
                        clusterAdmin().prepareCleanupRepository(name).get();
        RepositoriesService repositoriesService = internalCluster().getInstance(RepositoriesService.class, node);
    }
        return snapshotInfo;
        flushAndRefresh(index);
    protected ActionFuture<AcknowledgedResponse> deleteSnapshotBlockedOnClusterManager(String repoName, String snapshotName) {
            .setBlockOnWriteIndexFile();
        return clusterManagerName;
        fail("Timeout!!!");
    }
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
                .stream()
import org.opensearch.common.xcontent.XContentFactory;
            Thread.sleep(100);
import org.opensearch.core.common.unit.ByteSizeUnit;
 * software distributed under the License is distributed on an
    public static void failReadsAllDataNodes(String repository) {
    public void assertRepoConsistency() {
        assertEquals(builder.get().status(), RestStatus.ACCEPTED);
            snapshotId,
    public static String blockClusterManagerOnWriteIndexFile(final String repositoryName) {
    protected void restoreSnapshot(
            }, statePredicate);
    protected void createRepository(String repoName, String type, Path location) {
        return settingsBuilder;
            remoteStoreIndex,
 * specific language governing permissions and limitations
    protected Settings.Builder snapshotRepoSettingsForShallowCopy(Path path) {
    }
            randomBoolean(),
    protected void disableRepoConsistencyCheck(String reason) {
        clusterService.submitStateUpdateTask("test", new ClusterStateUpdateTask() {
        assertThat(snapshotInfo.state(), is(SnapshotState.SUCCESS));
        settings.put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), Boolean.TRUE);
    protected String[] getLockFilesInRemoteStore(String remoteStoreIndex, String remoteStoreRepositoryName) throws IOException {
 * compatible open source license.
import org.opensearch.core.common.Strings;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "1")
    protected void awaitClusterState(Predicate<ClusterState> statePredicate) throws Exception {
                return FileVisitResult.CONTINUE;
import static org.opensearch.index.remote.RemoteStoreEnums.DataType.LOCK_FILES;
            .put(IndexModule.INDEX_QUERY_CACHE_ENABLED_SETTING.getKey(), false)
 * GitHub history for details.
            ((MockRepository) internalCluster().getInstance(RepositoriesService.class, node).repository(repositoryName)).blockOnDataFiles(
        ((MockRepository) internalCluster().getInstance(RepositoriesService.class, node).repository(repository)).unblock();
                    if (curr.getRepository().equals(repository) && curr.getSnapshotId().getName().equals(snapshotName)) {
import static org.opensearch.common.util.FeatureFlags.WRITABLE_WARM_INDEX_SETTING;
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequestBuilder;
     * Randomly write an empty snapshot of an older version to an empty repository to simulate an older repository metadata format.
                }
        }
        Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
                    BlobStoreTestUtil.assertRepoConsistency(internalCluster(), name);
            }
            SnapshotState.FAILED,
            Version.V_2_0_0,
    public static void unblockAllDataNodes(String repository) {
            // due to https://github.com/elastic/elasticsearch/issues/9421
        }
import org.opensearch.cluster.metadata.IndexMetadata;
                    future.onFailure(new TimeoutException());
        final String clusterManagerName = internalCluster().getClusterManagerName();
package org.opensearch.snapshots;
        return Arrays.asList(MockRepository.Plugin.class);
        ((MockRepository) internalCluster().getInstance(RepositoriesService.class, clusterManagerName).repository(repositoryName))
            }
    protected String initWithSnapshotVersion(String repoName, Path repoPath, Version version) throws IOException {
    public void assertConsistentHistoryInLuceneIndex() throws Exception {
    public static void stopNode(final String node) throws IOException {
    }
        return settings;
        if (randomBoolean() && randomBoolean()) {
                    }
    }
import org.opensearch.snapshots.mockstore.MockRepository;
    private static final Settings SINGLE_SHARD_NO_REPLICA = indexSettingsNoReplicas(1).build();
        );
    }
    public static void blockNodeOnAnyFiles(String repository, String nodeName) {
import static org.hamcrest.Matchers.empty;
            .setWaitForCompletion(true)
        String repositoryName,
                NamedXContentRegistry.EMPTY,
    }
                    .custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY)
        });
    }
import static org.opensearch.index.remote.RemoteStoreEnums.DataCategory.SEGMENTS;
        final Settings.Builder settings = Settings.builder();
                Priority.NORMAL,
        while (System.currentTimeMillis() - start < timeout.millis()) {
import org.opensearch.cluster.metadata.RepositoriesMetadata;
            .setBlockAndFailOnWriteSnapFiles(true);
        return Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, shards).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0);
                if (found == false) {
 * license agreements. See the NOTICE file distributed with
            initialRepoMetadata.generation(),
            SEGMENTS,
            .prepareCreateSnapshot(repoName, snapshotName)
import java.util.function.Predicate;
    }
        return null;
        BlobPath shardLevelBlobPath = getShardLevelBlobPath(
        settings.put("location", path);
        logger.info("--> adding old version FAILED snapshot [{}] to repository [{}]", snapshotId, repoName);
        }
    }
    public static void waitForBlockOnAnyDataNode(String repository, TimeValue timeout) throws InterruptedException {
            LOCK_FILES,
 * not use this file except in compliance with the License.
            )
    protected long getCountForIndex(String indexName) {
    protected RepositoryData getRepositoryData(String repository) {
    public void unblockNode(final String repository, final String node) {
            .get();
        final ClusterState state = clusterAdmin().prepareState().get().getState();
        logger.info("--> creating full snapshot [{}] in [{}]", snapshotName, repoName);
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                && state.custom(SnapshotDeletionsInProgress.TYPE, SnapshotDeletionsInProgress.EMPTY).hasDeletionsInProgress() == false
                    return snapshotInfo;
        );
        assertNotNull(repositoriesMetadata);
    }
            "0",
    protected Settings nodeSettings(int nodeOrdinal) {
                @Override
            }
        }
        awaitNoMoreRunningOperations(internalCluster().getClusterManagerName());
import java.nio.file.SimpleFileVisitor;
        final ClusterStateObserver observer = new ClusterStateObserver(clusterService, logger, threadPool.getThreadContext());
        ((MockRepository) internalCluster().getInstance(RepositoriesService.class, clusterManagerName).repository(repositoryName))
import java.util.Arrays;
     */
    @Override
            "failed on purpose",
        awaitClusterState(internalCluster().getClusterManagerName(), statePredicate);
        createIndex(indexName);
        logger.info("--> verify no more operations in the cluster state");
        return count.get();
        final List<SnapshotInfo> snapshotInfos = clusterAdmin().prepareGetSnapshots(repository).setSnapshots(snapshot).get().getSnapshots();
        return settings;
    }
        createIndexWithContent(indexName, SINGLE_SHARD_NO_REPLICA);
import org.opensearch.core.xcontent.NamedXContentRegistry;
    public static void blockClusterManagerFromDeletingIndexNFile(String repositoryName) {
        logger.info("--> writing downgraded RepositoryData for repository metadata version [{}]", version);
        assertNotNull(initialRepoMetadata);
        }
    protected static SnapshotInfo assertSuccessful(ActionFuture<CreateSnapshotResponse> future) throws Exception {
import org.opensearch.test.VersionUtils;
import org.opensearch.common.unit.TimeValue;
        ((MockRepository) internalCluster().getInstance(RepositoriesService.class, clusterManagerName).repository(repositoryName))
    }
        assertThat(snapshotInfo.failedShards(), equalTo(0));
    @After
    }
            public void onFailure(String source, Exception e) {
        final RepositoryMetadata initialRepoMetadata = repositoriesMetadata.repository(repoName);
import org.opensearch.action.support.PlainActionFuture;
        final SnapshotInfo snapshotInfo = future.get().getSnapshotInfo();
    Disabling MockFSIndexStore plugin as the MockFSDirectoryFactory wraps the FSDirectory over a OpenSearchMockDirectoryWrapper which extends FilterDirectory (whereas FSDirectory extends BaseDirectory)
        waitForBlock(dataNode, repoName, TimeValue.timeValueSeconds(30L));
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, "1")
        awaitClusterState(
                }
            MockRepository mockRepository = (MockRepository) repositoriesService.repository(repository);
        assertThat(snapshotInfo.successfulShards(), is(snapshotInfo.totalShards()));
        return snapshotInfos.get(0);
            failureCount += mockRepository.getFailureCount();
        final String clusterManagerName = internalCluster().getClusterManagerName();
            for (ThreadPoolStats.Stats stat : clusterManagerThreadPool.stats()) {
 * You may obtain a copy of the License at
 * ownership. Elasticsearch licenses this file to you under
            .setWaitForCompletion(true)
            }
        final boolean compress = randomBoolean();
        Settings indexSettings
                        found = true;
    }
            .put(super.nodeSettings(nodeOrdinal))
        final AtomicInteger count = new AtomicInteger();
            }
    protected void awaitNoMoreRunningOperations(String viaNode) throws Exception {
        final String clusterManagerName = internalCluster().getClusterManagerName();
        );
        createRepository(repoName, type, randomRepositorySettings());
        if (shallowCopyEnabled) {
        final RepositoryData repositoryData = getRepositoryData(repoName);
    }
        final XContentBuilder jsonBuilder = JsonXContent.contentBuilder();
     */
            return lockDirectory.listAll();
        ).actionGet().getHits().getTotalHits().value();
import org.opensearch.core.compress.CompressorRegistry;
            BytesReference.toBytes(BytesReference.bytes(downgradedRepoData.snapshotsToXContent(XContentFactory.jsonBuilder(), version))),
import org.opensearch.core.xcontent.DeprecationHandler;
            initWithSnapshotVersion(repoName, repoPath, VersionUtils.randomIndexCompatibleVersion(random()));
    }
    public void verifyNoLeakedListeners() throws Exception {
    }
                .forEach(repositoryMetadata -> {
            repoPath.resolve(BlobStoreRepository.INDEX_FILE_PREFIX + repositoryData.getGenId()),
        if (compress) {
    }
        }
        repositoryData.snapshotsToXContent(jsonBuilder, version);
        if (indexSettings != null) {
        return clusterManagerName;
    }
    }
    }
                }
    protected ActionFuture<CreateSnapshotResponse> startFullSnapshotBlockedOnDataNode(String snapshotName, String repoName, String dataNode)
                Version.V_2_0_0,
    protected void awaitNoMoreRunningOperations() throws Exception {
            Collections.emptyList(),
    protected void updateClusterState(final Function<ClusterState, ClusterState> updater) throws Exception {
        assertTrue("No repository is blocked waiting on a data node", blocked);
