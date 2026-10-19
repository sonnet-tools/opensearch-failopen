/*
        Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
        while (System.currentTimeMillis() - start < timeout.millis()) {
 * Modifications Copyright OpenSearch Contributors. See  
            for (RepositoriesService repositoriesService : internalCluster().getDataNodeInstances(RepositoriesService.class)) {  
    protected void maybeInitWithOldSnapshotVersion(String repoName, Path repoPath) throws IOException {
 *
    protected void createIndexWithContent(String indexName) {
                ShardGenerations.EMPTY,  
    }  
                return;
        super(Settings.EMPTY);
    }  
import static org.opensearch.index.remote.RemoteStoreEnums.DataType.LOCK_FILES;
     * Randomly write an empty snapshot of an older version to an empty repository to simulate an older repository metadata format.
        waitForBlock(dataNode, repoName, TimeValue.timeValueSeconds(30L));  
 * specific language governing permissions and limitations
        return snapshotInfo;  
        final AtomicInteger count = new AtomicInteger();
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
    }  
import java.util.concurrent.atomic.AtomicInteger;
            .prepareRestoreSnapshot(repositoryName, snapshotName)
        }
            for (SnapshotsService snapshotsService : internalCluster().getInstances(SnapshotsService.class)) {  
        repositoryData.snapshotsToXContent(jsonBuilder, version);
}
        clusterService.submitStateUpdateTask("test", new ClusterStateUpdateTask() {  
    }  
    }
                }  
            if (snapshotInfo.state().completed()) {
        for (RepositoriesService repositoriesService : internalCluster().getDataNodeInstances(RepositoriesService.class)) {
import java.nio.file.FileVisitResult;
            final SnapshotInfo snapshotInfo = getSnapshot(repository, snapshotName);  
            .get();  
    public static void blockNodeOnAnyFiles(String repository, String nodeName) {
        final String clusterManagerName = internalCluster().getClusterManagerName();
import static org.hamcrest.Matchers.equalTo;  
            .setWaitForCompletion(true)
        String repositoryName,
                    future.onResponse(null);
     */
    }
import org.opensearch.action.support.PlainActionFuture;  
            "failed on purpose",
        assertThat(snapshotInfos, hasSize(1));  
        );
    /*
                @Override  
    public AbstractSnapshotIntegTestCase(Settings nodeSettings) {
                if (ThreadPool.Names.SNAPSHOT.equals(stat.getName())) {  
        }, 30L, TimeUnit.SECONDS);  
        final BlobStoreRepository remoteStoreRepository = (BlobStoreRepository) repositoriesService.repository(remoteStoreRepositoryName);  
import org.opensearch.core.rest.RestStatus;
    protected void addBwCFailedSnapshot(String repoName, String snapshotName, Map<String, Object> metadata) throws Exception {  
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {  
                MockRepository mockRepository = (MockRepository) repositoriesService.repository(repository);
        return count.get();  
            .get();
        MockRepository mockRepository = (MockRepository) repositoriesService.repository(repository);
    }
                found.add(file);
    protected void updateClusterState(final Function<ClusterState, ClusterState> updater) throws Exception {  
 * Licensed to Elasticsearch under one or more contributor  
    public void waitForBlock(String node, String repository, TimeValue timeout) throws InterruptedException {
            ((MockRepository) repositoriesService.repository(repository)).blockOnDataFiles(true);
            }
        logger.info("--> Deleting snapshot [{}] to repo [{}]", snapshotName, repoName);
    }  
     * @param snapshotName name for the new failed snapshot  
 * this file be licensed under the Apache-2.0 license or a
            .setBlockAndFailOnWriteIndexFile();  
import org.opensearch.cluster.ClusterState;
    private static final Settings SINGLE_SHARD_NO_REPLICA = indexSettingsNoReplicas(1).build();  
        final Settings.Builder settings = Settings.builder();  
        long start = System.currentTimeMillis();
        return snapshotInfo;
            0L,  
import java.nio.file.Files;  
        assertThat(  
            .build();
        });
    protected void awaitNoMoreRunningOperations() throws Exception {  
        }  
        ((MockRepository) internalCluster().getInstance(RepositoriesService.class, nodeName).repository(repository)).setBlockOnAnyFiles(  
    }
        if (indexSettings != null) {
import java.util.List;  
    public SnapshotInfo waitForCompletion(String repository, String snapshotName, TimeValue timeout) throws InterruptedException {  
        return null;  
        for (RepositoriesService repositoriesService : internalCluster().getDataOrClusterManagerNodeInstances(RepositoriesService.class)) {
    public static void failReadsAllDataNodes(String repository) {  
        }
 * compatible open source license.
                ClusterStateResponse stateResponse = clusterAdmin().prepareState().get();  
        for (String node : internalCluster().nodesInclude(indexName)) {
    public static long getFailureCount(String repository) {  
        assertThat(snapshotInfo.state(), is(SnapshotState.SUCCESS));
        if (statePredicate.test(observer.setAndGetObservedState()) == false) {  
    }
import org.opensearch.common.unit.TimeValue;  
            true
        final ThreadPool clusterManagerThreadPool = internalCluster().getClusterManagerNodeInstance(ThreadPool.class);  
import java.util.Collection;
            .setBlockAndFailOnWriteSnapFiles(true);
            builders[i] = client().prepareIndex(index).setId(Integer.toString(i)).setSource("field1", "bar " + i);  
        logger.info("--> creating full snapshot [{}] in [{}]", snapshotName, repoName);
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * Adds a snapshot in state {@link SnapshotState#FAILED} to the given repository.  
        ((MockRepository) internalCluster().getInstance(RepositoriesService.class, clusterManagerName).repository(repositoryName))
            .cluster()  
    public AbstractSnapshotIntegTestCase() {  
        assertDocCount(index, numdocs);
    protected String[] getLockFilesInRemoteStore(String remoteStoreIndex, String remoteStoreRepositoryName) throws IOException {
    }  
    protected ActionFuture<CreateSnapshotResponse> startFullSnapshotBlockedOnDataNode(String snapshotName, String repoName, String dataNode)
        final ClusterService clusterService = internalCluster().getInstance(ClusterService.class, viaNode);  
                // Make sure that snapshot clean up operations are finished
            Collections.emptyList(),
    }
            }
        assertEquals("Unexpected file count, found: [" + found + "].", expectedCount, found.size());  
            remoteStoreIndex,
    protected void awaitNumberOfSnapshotsInProgress(int count) throws Exception {
    protected Settings getRemoteStoreBackedIndexSettings() {
            builder.setIndexSettings(indexSettings);  
    }
        final RepositoryData repositoryData = getRepositoryData(repoName);  
    }  
        Settings.Builder settingsBuilder = randomRepositorySettings();
    }
            .put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), EnableAllocationDecider.Rebalance.NONE)
            .put(IndexModule.INDEX_QUERY_CACHE_ENABLED_SETTING.getKey(), false)
                    }  
        ).actionGet().getHits().getTotalHits().value();  
        return clusterManagerName;
import org.opensearch.plugins.Plugin;
        return PlainActionFuture.get(repository::getRepositoryData);  
import org.opensearch.common.action.ActionFuture;
import org.opensearch.common.settings.Settings;
    public static int numberOfFiles(Path dir) throws IOException {  
 * not use this file except in compliance with the License.
            randomBoolean(),
        );
                future.onResponse(null);
    }
 */  
import org.opensearch.cluster.metadata.RepositoryMetadata;  
                future.onFailure(e);
import java.util.function.Function;
                        clusterAdmin().prepareDeleteSnapshot(name, OLD_VERSION_SNAPSHOT_PREFIX + "*").get();
        settings.put("location", randomRepoPath());
        createRepository(repoName, type, randomRepositorySettings());
            LOCK_FILES,
    }
        fail("No nodes for the index " + indexName + " found");
        final CreateSnapshotResponse response = client().admin()
    /**
    }  
        fail("Timeout waiting for node [" + node + "] to be blocked");  
    }
                for (SnapshotsInProgress.Entry entry : stateResponse.getState()
        Settings indexSettings
    public static void unblockAllDataNodes(String repository) {  
        logger.info("--> wait for [{}] snapshots to show up in the cluster state", count);
    }
     *
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
    }
            repoPath.resolve(BlobStoreRepository.INDEX_FILE_PREFIX + repositoryData.getGenId()),  
     */
    private static final String OLD_VERSION_SNAPSHOT_PREFIX = "old-version-snapshot-";
    public static void blockNodeOnAnySegmentFile(String repository, String nodeName) {
    }  
        }  
            .prepareCreateSnapshot(repoName, snapshotName)
    public static String blockClusterManagerFromFinalizingSnapshotOnIndexFile(final String repositoryName) {  
            .setWaitForCompletion(false)
        RestoreSnapshotRequestBuilder builder = client().admin()
        assertThat(snapshotInfo.successfulShards(), is(snapshotInfo.totalShards()));  
 * under the License.  
import java.util.Map;
    @After
        Files.write(
        logger.info("--> creating full snapshot [{}] to repo [{}]", snapshotName, repoName);  
                        break;
    protected Settings.Builder randomRepositorySettings() {
 */
        fail("Timeout!!!");
     */  
            .cluster()
    }  
        .put("thread_pool.snapshot.core", 5)
        return clusterManagerName;  
    protected void createIndexWithRandomDocs(String indexName, int docCount) throws InterruptedException {
        createIndex(indexName);  
    }  
    }
        createIndex(indexName, indexSettings);
            .put("index.refresh_interval", "300s")
import org.opensearch.repositories.blobstore.BlobStoreRepository;  
    }
    }
        .build();  
    public static void assertFileCount(Path dir, int expectedCount) throws IOException {  
        });
 * ownership. Elasticsearch licenses this file to you under  
                f
                snapshotInfo,  
    }  
            JsonXContent.jsonXContent.createParser(
        return snapshotInfo;  
        }
                    return snapshotInfo;  
    /**
            }
    @After
                    return true;  
            @Override
 */
    @After  
            "We can only manually insert a snapshot into a repository that does not have a generation tracked in the CS",
            settingsBuilder.put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true);
                .repositories()
            viaNode,
import org.opensearch.search.builder.SearchSourceBuilder;
        final RepositoriesMetadata repositoriesMetadata = state.metadata().custom(RepositoriesMetadata.TYPE);
        assertNotNull(repositoriesMetadata);  
                }  
    }
    }
        super(nodeSettings);  
        return null;
import org.opensearch.action.index.IndexRequestBuilder;
        if (basePath != null) {  
            ((MockRepository) repositoriesService.repository(repository)).unblock();
    protected ActionFuture<AcknowledgedResponse> startDeleteSnapshot(String repoName, String snapshotName) {
 *    http://www.apache.org/licenses/LICENSE-2.0
    protected void assertDocCount(String index, long count) {  
        }
    public static void blockAllDataNodes(String repository) {  
            snapshotId,  
        return Settings.builder()  
            settingsBuilder.put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true);
import org.opensearch.common.Priority;  
import org.opensearch.test.VersionUtils;
        if (skipRepoConsistencyCheckReason == null) {
import org.opensearch.index.store.RemoteBufferedOutputDirectory;  
import org.opensearch.repositories.blobstore.BlobStoreTestUtil;
        final Settings.Builder settings = Settings.builder();  
import java.nio.file.StandardOpenOption;  
        final RepositoryMetadata initialRepoMetadata = repositoriesMetadata.repository(repoName);
        logger.info("--> waiting for [{}] to be blocked on node [{}]", repository, node);
            .prepareCreateSnapshot(repositoryName, snapshot)  
        final ClusterStateObserver observer = new ClusterStateObserver(clusterService, logger, threadPool.getThreadContext());
    ) {  
import java.util.function.Predicate;  
/*  
 * KIND, either express or implied.  See the License for the
        ((MockRepository) internalCluster().getInstance(RepositoriesService.class, nodeName).repository(repository)).blockOnDataFiles(true);  
            metadata,  
import org.opensearch.cluster.metadata.IndexMetadata;
                    }  
        return settingsBuilder;  
        final Repository repo = internalCluster().getCurrentClusterManagerNodeInstance(RepositoriesService.class).repository(repoName);
            .setIndices("does-not-exist-for-sure-*")  
            public ClusterState execute(ClusterState currentState) {
    @Override
                && state.custom(SnapshotDeletionsInProgress.TYPE, SnapshotDeletionsInProgress.EMPTY).hasDeletionsInProgress() == false  
                    future.onFailure(new NodeClosedException(clusterService.localNode()));
        return settingsBuilder.build();
        final XContentBuilder jsonBuilder = JsonXContent.contentBuilder();
        Settings.Builder settingsBuilder = randomRepositorySettings();
                assertTrue(snapshotsService.assertAllListenersResolved());
        logger.info("--> waiting for cluster-manager to finish all repo operations on its SNAPSHOT pool");
            return node;
        skipRepoConsistencyCheckReason = reason;
        awaitClusterState(internalCluster().getClusterManagerName(), statePredicate);
                return updater.apply(currentState);  
                jsonBuilder.toString().replace(Version.CURRENT.toString(), version.toString())
    protected RepositoryData getRepositoryData(Repository repository) {
        final CreateSnapshotResponse response = client().admin()  
    protected void awaitClusterManagerFinishRepoOperations() throws Exception {
    }  
        final PlainActionFuture<Void> future = PlainActionFuture.newFuture();
        final String oldVersionSnapshot = OLD_VERSION_SNAPSHOT_PREFIX + version.id;
    public static void blockDataNode(String repository, String nodeName) {
                public void onClusterServiceClose() {  
 * this work for additional information regarding copyright
            public void onFailure(String source, Exception e) {
    }  
import static org.hamcrest.Matchers.greaterThan;
        return clusterAdmin().prepareDeleteSnapshot(repoName, snapshotName).execute();
        awaitNoMoreRunningOperations(internalCluster().getClusterManagerName());
            // due to https://github.com/elastic/elasticsearch/issues/9421  
    public void assertRepoConsistency() {  
            true
import org.opensearch.cluster.ClusterStateUpdateTask;
    protected static Settings.Builder indexSettingsNoReplicas(int shards) {  
                    final String name = repositoryMetadata.name();
                @Override
import org.opensearch.snapshots.mockstore.MockRepository;  
            initWithSnapshotVersion(repoName, repoPath, VersionUtils.randomIndexCompatibleVersion(random()));  
            ),
        Settings.Builder settingsBuilder = Settings.builder()
            segmentsPathFixedPrefix  
    }
                }
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, "1")
        );
    protected Settings nodeSettings(int nodeOrdinal) {
import java.util.Collections;
        }
                public void onNewClusterState(ClusterState state) {
        return startFullSnapshot(repoName, snapshotName, false);
import org.opensearch.repositories.RepositoryData;
    protected Settings.Builder snapshotRepoSettingsForShallowCopy() {
            }  
                        clusterAdmin().prepareCleanupRepository(name).get();
            .setRenamePattern(indexName)  
                .filter(repositoryMetadata -> !repositoryMetadata.name().endsWith(TEST_REMOTE_STORE_REPO_SUFFIX))  
                Version.V_2_0_0,
                public void onTimeout(TimeValue timeout) {
            return lockDirectory.listAll();
        return deleteSnapshot(repoName, snapshotName);  
            MockRepository mockRepository = (MockRepository) repositoriesService.repository(repository);
        final ClusterState state = clusterAdmin().prepareState().get().getState();
        settings.put("location", randomRepoPath()).put("compress", compress);
        );
        settingsBuilder.put("location", location);
        createIndexWithContent(indexName, SINGLE_SHARD_NO_REPLICA);  
            client(),  
        ((MockRepository) internalCluster().getInstance(RepositoriesService.class, node).repository(repository)).unblock();
                Function.identity(),
                }
        assertEquals(getCountForIndex(index), count);
    }
    }
                true  
        }
        for (RepositoriesService repositoriesService : internalCluster().getDataNodeInstances(RepositoriesService.class)) {
                NamedXContentRegistry.EMPTY,
            logger.info("--> skipped repo consistency checks because [{}]", skipRepoConsistencyCheckReason);
    public void verifyNoLeakedListeners() throws Exception {
        logger.info("--> unblocking [{}] on node [{}]", repository, node);
            );
    }  
    protected SnapshotInfo createFullSnapshot(String repoName, String snapshotName) {
    }
import static org.hamcrest.Matchers.is;  
    }
    }
        BlobPath shardLevelBlobPath = getShardLevelBlobPath(
        logger.info("--> restoring snapshot [{}] of {} in [{}] to [{}]", snapshotName, indexName, repositoryName, restoredIndexName);
                getRepositoryData(repoName).getGenId(),
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
    }
    protected Settings.Builder getRepositorySettings(Path location, String basePath, boolean shallowCopyEnabled) {  
 * The OpenSearch Contributors require contributions made to  
    }  
            @Override  
        indexRandom(true, builders);
        settings.put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), Boolean.TRUE);
        final String clusterManagerName = internalCluster().getClusterManagerName();  
    }
            final PlainActionFuture<Void> future = PlainActionFuture.newFuture();
        createRepository(repoName, type, Settings.builder().put("location", location));  
    }
package org.opensearch.snapshots;
                .forEach(repositoryMetadata -> {
        if (WRITABLE_WARM_INDEX_SETTING.get(settings)) {
 *
    }
                if (mockRepository.blocked()) {
    }
        return clusterAdmin().prepareDeleteSnapshot(repoName, snapshotName).execute();  
        logger.info("--> verify no more operations in the cluster state");
                boolean found = false;
        return WRITABLE_WARM_INDEX_SETTING.get(settings) == false;
    protected void createRepository(String repoName, String type) {  
        String segmentsPathFixedPrefix = RemoteStoreSettings.CLUSTER_REMOTE_STORE_SEGMENTS_PATH_PREFIX.get(getNodeSettings());
     * @param metadata     snapshot metadata to write (as returned by {@link SnapshotInfo#userMetadata()})
import org.opensearch.threadpool.ThreadPool;  
                Priority.NORMAL,  
        assertEquals(builder.get().status(), RestStatus.ACCEPTED);
            }, statePredicate);
        });
import org.opensearch.cluster.metadata.RepositoriesMetadata;
    protected Settings.Builder getRepositorySettings(Path location, boolean shallowCopyEnabled) {  
 * You may obtain a copy of the License at  
        RepositoriesService repositoriesService = internalCluster().getInstance(RepositoriesService.class, node);
        logger.info("--> creating snapshot [{}] of {} in [{}]", snapshot, indices, repositoryName);  
    }
import org.opensearch.node.NodeClosedException;  
        try (RemoteBufferedOutputDirectory lockDirectory = new RemoteBufferedOutputDirectory(blobContainer)) {  
import org.opensearch.threadpool.ThreadPoolStats;
        );  
            .setIndices(indices.toArray(Strings.EMPTY_ARRAY))
        ((MockRepository) internalCluster().getInstance(RepositoriesService.class, nodeName).repository(repository)).blockOnSegmentFiles(  
        final Settings.Builder settings = Settings.builder();
    }
        );
    protected void restoreSnapshot(  
 * the Apache License, Version 2.0 (the "License"); you may
            }
    }  
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,  
    protected void createRepository(String repoName, String type, Path location) {
    }
    protected ActionFuture<CreateSnapshotResponse> startFullSnapshot(String repoName, String snapshotName, boolean partial) {
        if (compress) {
    protected long getCountForIndex(String indexName) {  
        if (randomBoolean() && randomBoolean()) {
        if (shallowCopyEnabled) {  
import java.util.ArrayList;
        final List<Path> found = new ArrayList<>();
    protected ActionFuture<AcknowledgedResponse> deleteSnapshotBlockedOnClusterManager(String repoName, String snapshotName) {
            clusterAdmin().prepareGetRepositories()
            SEGMENTS,
        return oldVersionSnapshot;
    }
     * @param repoName     repository to add snapshot to
                    assertEquals(stat.getActive(), 0);
import org.opensearch.action.search.SearchRequest;
    protected void awaitClusterState(String viaNode, Predicate<ClusterState> statePredicate) throws Exception {
public abstract class AbstractSnapshotIntegTestCase extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
                    final Snapshot curr = entry.snapshot();
                }
        long start = System.currentTimeMillis();  
        return failureCount;  
import org.opensearch.cluster.SnapshotDeletionsInProgress;
        IndexRequestBuilder[] builders = new IndexRequestBuilder[numdocs];
        return settings;
        settings.put("location", path);
import org.opensearch.indices.RemoteStoreSettings;
        assertBusy(() -> {
        return getRepositoryData(internalCluster().getCurrentClusterManagerNodeInstance(RepositoriesService.class).repository(repository));
    }
        final String clusterManagerName = internalCluster().getClusterManagerName();  
    public void assertConsistentHistoryInLuceneIndex() throws Exception {
    }
        assertThat(snapshotInfo.successfulShards(), greaterThan(0));
        final boolean compress = randomBoolean();  
        logger.info("--> adding old version FAILED snapshot [{}] to repository [{}]", snapshotId, repoName);
                }
            0L,
            }
        }
    public static void waitForBlockOnAnyDataNode(String repository, TimeValue timeout) throws InterruptedException {
            settingsBuilder.put("base_path", basePath);
    private String skipRepoConsistencyCheckReason;  
        return fut;
        final List<SnapshotInfo> snapshotInfos = clusterAdmin().prepareGetSnapshots(repository).setSnapshots(snapshot).get().getSnapshots();
    // threads so that blocking some threads on one repository doesn't block other repositories from doing work
    protected void indexRandomDocs(String index, int numdocs) throws InterruptedException {
        blockClusterManagerFromDeletingIndexNFile(repoName);
            future.get(30L, TimeUnit.SECONDS);  
        );  
            ((MockRepository) internalCluster().getInstance(RepositoriesService.class, node).repository(repositoryName)).blockOnDataFiles(
    public static void blockClusterManagerFromDeletingIndexNFile(String repositoryName) {
        logger.info("--> writing downgraded RepositoryData for repository metadata version [{}]", version);
import org.opensearch.cluster.ClusterStateObserver;  
            0
        return clusterAdmin().prepareCreateSnapshot(repoName, snapshotName).setWaitForCompletion(true).setPartial(partial).execute();
        }, timeout.millis(), TimeUnit.MILLISECONDS);
    }
                return FileVisitResult.CONTINUE;  
        Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
        }
    protected Settings.Builder snapshotRepoSettingsForShallowCopy(Path path) {
        return settingsBuilder;  
                    if (curr.getRepository().equals(repository) && curr.getSnapshotId().getName().equals(snapshotName)) {  
            settings.put("compression_type", randomFrom(CompressorRegistry.registeredCompressors().keySet()));  
import static org.hamcrest.Matchers.hasSize;
import org.opensearch.index.IndexModule;
    }
    // Large snapshot pool settings to set up nodes for tests involving multiple repositories that need to have enough
                    break;
import org.opensearch.common.xcontent.json.JsonXContent;
import java.util.Arrays;  
                    BlobStoreTestUtil.assertRepoConsistency(internalCluster(), name);
                state.metadata(),
import org.opensearch.core.compress.CompressorRegistry;  
            MockRepository mockRepository = (MockRepository) repositoriesService.repository(repository);  
        assertThat(snapshotInfo.state(), is(SnapshotState.SUCCESS));  
                }
            false,
        final ThreadPool threadPool = internalCluster().getInstance(ThreadPool.class, viaNode);
        final SnapshotInfo snapshotInfo = response.getSnapshotInfo();
            Thread.sleep(100);  
            }  
            @Override
    }
        final SnapshotInfo snapshotInfo = new SnapshotInfo(
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        flushAndRefresh(index);  
            Collections.emptyList(),
    protected SnapshotInfo createSnapshot(String repositoryName, String snapshot, List<String> indices) {
import org.opensearch.repositories.RepositoriesService;
/*
            }
    }
        assertThat("This hack only works on an empty repository", getRepositoryData(repoName).getSnapshotIds(), empty());  
        }  
    public static void stopNode(final String node) throws IOException {  
        final SnapshotId snapshotId = new SnapshotId(snapshotName, UUIDs.randomBase64UUID(random()));  
            Thread.sleep(100);
        assertThat(snapshotInfo.state(), is(SnapshotState.SUCCESS));
        final RepositoryData downgradedRepoData = RepositoryData.snapshotsFromXContent(  
            repositoryData.getGenId()  
            is(RepositoryData.UNKNOWN_REPO_GEN)  
        ((MockRepository) internalCluster().getInstance(RepositoriesService.class, clusterManagerName).repository(repositoryName))
            new SearchRequest(new SearchRequest(indexName).source(new SearchSourceBuilder().size(0).trackTotalHits(true)))
        assertTrue("No repository is blocked waiting on a data node", blocked);  
import org.opensearch.core.common.Strings;  
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
            0,  
        ensureGreen(indexName);  
            @Override  
        }
        future.get();
        return client().search(
    public static String blockNodeWithIndex(final String repositoryName, final String indexName) {  
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.indices.replication.common.ReplicationType;
    }
        }
            SnapshotState.FAILED,  
        return clusterManagerName;
        final RepositoriesService repositoriesService = internalCluster().getCurrentClusterManagerNodeInstance(RepositoriesService.class);
        while (System.currentTimeMillis() - start < timeout.millis()) {  
    @Override
        }
 * Unless required by applicable law or agreed to in writing,
        ensureGreen();
    }
        return settings;  
        index(indexName, "_doc", "some_id", "foo", "bar");
                    future.onFailure(new TimeoutException());  
            // Rebalancing is causing some checks after restore to randomly fail
            settings.put("chunk_size", randomIntBetween(100, 1000), ByteSizeUnit.BYTES);  
    /**
        );
    protected String initWithSnapshotVersion(String repoName, Path repoPath, Version version) throws IOException {
            .get();
            return false;  
            Version.V_2_0_0,
            failureCount += mockRepository.getFailureCount();
            f -> repo.finalizeSnapshot(
    public void unblockNode(final String repository, final String node) {  
            if (mockRepository.blocked()) {
                return FileVisitResult.CONTINUE;  
            .setWaitForCompletion(true)
        return Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, shards).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0);
        }
import java.nio.file.Path;
            @Override  
    protected SnapshotInfo getSnapshot(String repository, String snapshot) {
                .stream()
            state -> state.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY).entries().isEmpty()
        final ClusterService clusterService = internalCluster().getCurrentClusterManagerNodeInstance(ClusterService.class);
        logger.info("--> deleting snapshot [{}] from repo [{}]", snapshotName, repoName);
            )
            .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.FS.getSettingsKey())  
import org.opensearch.common.blobstore.BlobContainer;  
        for (RepositoriesService repositoriesService : internalCluster().getDataNodeInstances(RepositoriesService.class)) {
        internalCluster().assertConsistentHistoryBetweenTranslogAndLuceneIndex();  
        internalCluster().stopRandomNode(settings -> settings.get("node.name").equals(node));
        if (shallowCopyEnabled) {  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "1")  
 *  
import java.nio.file.attribute.BasicFileAttributes;
        blockDataNode(repoName, dataNode);
            Collections.emptyList(),
    protected void disableRepoConsistencyCheck(String reason) {
        if (rarely()) {
import static org.opensearch.common.util.FeatureFlags.WRITABLE_WARM_INDEX_SETTING;
            .cluster()
        assertNotNull(initialRepoMetadata);
                @Override
            .setRenameReplacement(restoredIndexName);
        return Arrays.asList(MockRepository.Plugin.class);
        });  
import static org.opensearch.index.remote.RemoteStoreEnums.DataCategory.SEGMENTS;  
        final CreateSnapshotResponse createSnapshotResponse = clusterAdmin().prepareCreateSnapshot(repoName, oldVersionSnapshot)
    }
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;  
        settingsBuilder.put("location", location);
    As a result of this wrapping the local directory of Composite Directory does not satisfy the assertion that local directory must be of type FSDirectory  
    protected ActionFuture<CreateSnapshotResponse> startFullSnapshot(String repoName, String snapshotName) {
        throws InterruptedException {  
import org.opensearch.core.common.unit.ByteSizeUnit;
 * software distributed under the License is distributed on an
import org.opensearch.core.common.bytes.BytesReference;
import java.nio.file.SimpleFileVisitor;
            StandardOpenOption.TRUNCATE_EXISTING
import org.opensearch.common.UUIDs;
    Disabling MockFSIndexStore plugin as the MockFSDirectoryFactory wraps the FSDirectory over a OpenSearchMockDirectoryWrapper which extends FilterDirectory (whereas FSDirectory extends BaseDirectory)
                    .entries()) {
    */
        );  
            initialRepoMetadata.generation(),
            .setBlockOnWriteIndexFile();
            BytesReference.toBytes(BytesReference.bytes(downgradedRepoData.snapshotsToXContent(XContentFactory.jsonBuilder(), version))),
        assertThat(createSnapshotResponse.getSnapshotInfo().totalShards(), is(0));  
        indexRandomDocs(indexName, docCount);
    }
    }  
        awaitClusterState(  
import org.opensearch.cluster.service.ClusterService;
            observer.waitForNextChange(new ClusterStateObserver.Listener() {
import org.opensearch.Version;  
        logger.info("--> indexing [{}] documents into [{}]", numdocs, index);  
import org.opensearch.common.xcontent.XContentFactory;
 * SPDX-License-Identifier: Apache-2.0
        return snapshotInfos.get(0);
            .setWaitForCompletion(true)  
            }
        }
        long failureCount = 0;
            0,
    protected static SnapshotInfo assertSuccessful(ActionFuture<CreateSnapshotResponse> future) throws Exception {  
    protected RepositoryData getRepositoryData(String repository) {
                if (found == false) {
        logger.info("--> creating index [{}]", indexName);
        String restoredIndexName,
                });
     * Workaround to simulate BwC situation: taking a snapshot without indices here so that we don't create any new version shard
        BlobContainer blobContainer = remoteStoreRepository.blobStore().blobContainer(shardLevelBlobPath);
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequestBuilder;
        }
    protected void awaitNoMoreRunningOperations(String viaNode) throws Exception {
            settingsBuilder.put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true);
        PlainActionFuture.<RepositoryData, Exception>get(
    public static String blockClusterManagerOnWriteIndexFile(final String repositoryName) {
    @Override
import java.util.concurrent.TimeUnit;
    public static String blockClusterManagerFromFinalizingSnapshotOnSnapFile(final String repositoryName) {
            .setBlockOnDeleteIndexFile();
            for (ThreadPoolStats.Stats stat : clusterManagerThreadPool.stats()) {
            }
     * generations (the existence of which would short-circuit checks for the repo containing old version snapshots)  
            .put(super.nodeSettings(nodeOrdinal))
 * license agreements. See the NOTICE file distributed with
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT);
    protected void createIndexWithContent(String indexName, Settings indexSettings) {  
        for (int i = 0; i < builders.length; i++) {
        final SnapshotInfo snapshotInfo = future.get().getSnapshotInfo();
        .put("thread_pool.snapshot.max", 5)
            "0",  
import org.opensearch.core.xcontent.DeprecationHandler;
    }
import org.opensearch.common.blobstore.BlobPath;
                count.incrementAndGet();
        }
    }
                        found = true;
        assertThat(snapshotInfo.failedShards(), equalTo(0));
        assertNotNull(reason);  
            mockRepository.setFailReadsAfterUnblock(true);  
    protected final static String TEST_REMOTE_STORE_REPO_SUFFIX = "__rs";
        ((MockRepository) internalCluster().getClusterManagerNodeInstance(RepositoriesService.class).repository(repositoryName))  
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
    protected boolean addMockIndexStorePlugin() {  
                    if (repositoryMetadata.settings().getAsBoolean("readonly", false) == false) {  
    protected void awaitClusterState(Predicate<ClusterState> statePredicate) throws Exception {
    protected ActionFuture<AcknowledgedResponse> deleteSnapshot(String repoName, String snapshotName) {  
import org.opensearch.core.xcontent.NamedXContentRegistry;  
    }  
import static org.hamcrest.Matchers.empty;
                .get()  
        SnapshotInfo snapshotInfo = response.getSnapshotInfo();
    protected static final Settings LARGE_SNAPSHOT_POOL_SETTINGS = Settings.builder()  
        final String clusterManagerName = internalCluster().getClusterManagerName();
                    .custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY)  
import java.io.IOException;
            remoteStoreRepository.basePath(),
    }
import java.util.concurrent.TimeoutException;  
import org.opensearch.repositories.Repository;  
        ((MockRepository) internalCluster().getInstance(RepositoriesService.class, clusterManagerName).repository(repositoryName))
import org.opensearch.cluster.SnapshotsInProgress;  
        String snapshotName,
        String indexName,  
        final ActionFuture<CreateSnapshotResponse> fut = startFullSnapshot(repoName, snapshotName);
    }
        final boolean blocked = waitUntil(() -> {
        assertBusy(() -> {
        settings.put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), Boolean.TRUE);
import org.junit.After;
        } else {  
import org.opensearch.repositories.ShardGenerations;
        }  
        awaitClusterState(state -> state.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY).entries().size() == count);  
 * GitHub history for details.
        return settings;  
