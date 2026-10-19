        // when
        BlobStoreRepository repository = setupRepo();
    }
/*
        // Verify that the stale index was processed for deletion
        for (IndexId indexId : repoData.getIndices().values()) {
        BlobStoreRepository.remoteDirectoryCleanupAsync(
        OpenSearchIntegTestCase.putRepository(client.admin().cluster(), repositoryName, REPO_TYPE, settings);
        remoteStoreShardCleanupTask.run();
        // Remove known extra files - "extra0" file is added by the ExtrasFS, which is part of Lucene's test framework
        assertEquals(repository.repositoryDataCacheThreshold, expectedThreshold);
        assertThat(repository.readSnapshotIndexLatestBlob(), equalTo(expectedGeneration + 1L));
    }
            Map<BlobStore.Metric, Map<String, Long>> blobStoreMetricMap = Map.of(BlobStore.Metric.REQUEST_SUCCESS, blobStoreStatsMap);
package org.opensearch.repositories.blobstore;
        Settings useCompressSettings = Settings.builder()
    private static void writeIndexGen(BlobStoreRepository repository, RepositoryData repositoryData, long generation) throws Exception {
        final Client client = client();
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to
    }
        assertNoDeprecationWarnings();
                RemoteStoreEnums.PathHashAlgorithm.FNV_1A_COMPOSITE_1,
 * Tests for the {@link BlobStoreRepository} and its subclasses.
            eq(indexUUID),
            .prepareCreateSnapshot(repositoryName, "test-snap-2")
        // Mock BlobContainer for current index
            );
 * the Apache License, Version 2.0 (the "License"); you may
            Environment env,
        BlobStoreRepository repository = setupRepo();
            .setWaitForCompletion(true)
        // given
            resultReference.set(deleteResults);
    }
        RemoteStoreShardCleanupTask remoteStoreShardCleanupTask = new RemoteStoreShardCleanupTask(task1, testIndexUUID, shardId);
    protected Collection<Class<? extends Plugin>> getPlugins() {
        BlobStoreRepository repository = setupRepo();
            indexUUID,
import org.opensearch.repositories.RepositoryData;
        shardInfo = SnapshotShardPaths.parseShardPath(shardPath);
        assertTrue(stats.detailed);
        assertFalse(stats.detailed);
            indexId.getId(),
    public void testGetRemoteUploadThrottleTimeInNanos() {
/*
        );
     * {@link IndexMetadata} argument through to {@code RemoteSegmentStoreDirectory.remoteDirectoryCleanup},
            eq(shardId),
import org.opensearch.common.blobstore.BlobStore;
    public void testHeapThresholdUsed() {
                (metadata) -> new FsRepository(metadata, env, namedXContentRegistry, clusterService, recoverySettings) {
import org.opensearch.core.common.unit.ByteSizeUnit;
        long expectedThreshold = Math.max(ByteSizeUnit.KB.toBytes(500), maxThreshold / 2);
        // Verify that snapshot shard paths were considered in the cleanup process
        // then
    }
        assertEquals(defaultAbsoluteThreshold, result);
        } else {
    public void testPrefixModeVerification() throws Exception {
    public static class FsLikeRepoPlugin extends Plugin implements RepositoryPlugin {
            IndexId indexId = repoData.getIndices().get(shardInfo.getIndexId().getName());
        assertEquals(repoData, OpenSearchBlobStoreRepositoryIntegTestCase.getRepositoryData(repository));
                .stream()
        );
            shardId,
    }
        }
    }
    }
        assertTrue(stats.detailed);
        RepositoryStats stats = repoSpy.stats();
            .put(node().getEnvironment().settings())
    }
        // Mock BlobContainer for stale index
import org.opensearch.index.remote.RemoteStoreEnums;
                RemoteStoreEnums.PathHashAlgorithm.fromCode(Integer.parseInt(parts[4]))
        repository.cleanupStaleIndices(
            .put("chunk_size", randomLongBetween(-10, 0), ByteSizeUnit.BYTES);
        BlobStoreRepository repository = setupRepo();
        assertEquals(OpenSearchBlobStoreRepositoryIntegTestCase.getRepositoryData(repository), repositoryData);
            .cluster()
        OpenSearchIntegTestCase.putRepository(client.admin().cluster(), repositoryName, REPO_TYPE, settings);
        foundIndices.put("stale-index", staleIndexContainer);
        createIndex(indexName);
     * which in turn passes it as an {@link IndexSettings} to the factory's 8-arg {@code newDirectory}.
            listener,
        assertEquals(15, stats.requestCounts.get("requests_count").longValue());
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.Version;
        OpenSearchIntegTestCase.putRepository(client.admin().cluster(), repositoryName, REPO_TYPE, settings);
        assertEquals(45, stats.requestCounts.get("requests_count").longValue());
        long defaultAbsoluteThreshold = ByteSizeUnit.KB.toBytes(500);
        // adding more and writing to a new index generational file
        repository.close();
            return null;
 * this work for additional information regarding copyright
        for (int i = 0; i < numSnapshots; i++) {
import org.opensearch.threadpool.ThreadPool;
import static org.opensearch.repositories.blobstore.BlobStoreRepository.calculateMaxWithinIntLimit;
import org.opensearch.repositories.RepositoryStats;
import static org.mockito.Mockito.when;
 * specific language governing permissions and limitations
        remoteStoreShardCleanupTask = new RemoteStoreShardCleanupTask(task1, testIndexUUID, shardId);
}
            repoData = repoData.addSnapshot(
        List<SnapshotId> snapshotIds = new ArrayList<>();
import java.util.concurrent.ExecutorService;
 */
        repository.close();
        BlobStoreRepository repoSpy = Mockito.spy(repository);
import java.nio.file.Path;
            () -> OpenSearchIntegTestCase.putRepository(client.admin().cluster(), repositoryName, REPO_TYPE, settings)
        final Path location = OpenSearchIntegTestCase.randomRepoPath(node().settings());
        BlobContainer mockSnapshotShardPathBlobContainer = mock(BlobContainer.class);
    public void testGetRestrictedSystemRepositorySettings() {
        // Mock snapshotShardPathBlobContainer
    public void testIsSystemRepository() {
            Map<String, BlobContainer> indices = invocation.getArgument(1);
            .put("location", location)
 *
        writeIndexGen(repository, emptyData, emptyData.getGenId());
    public void testRetrieveSnapshots() throws Exception {
            eq(null),
        Settings.Builder settings = Settings.builder().put(node().settings()).put("location", location);
        final BlobStoreRepository repository = setupRepo();
            eq(pathStrategy),
import static org.opensearch.repositories.RepositoryDataTests.generateRandomRepoData;
        );
        when(mockRemoteStoreLockManagerFactory.newLockManager(anyString(), anyString(), anyString(), any())).thenReturn(mockLockManager);
        long expectedThreshold = calculateMaxWithinIntLimit(defaultThresholdOfHeap, defaultAbsoluteThreshold);
        assertNotNull(stats);
        BlobStoreRepository repository = setupRepo();
            .sorted((s1, s2) -> s1.getName().compareTo(s2.getName()))
 * Modifications Copyright OpenSearch Contributors. See
            .build();
        BlobStore blobStore = Mockito.mock(BlobStore.class);
        final RepositoryMetadata metadata = new RepositoryMetadata("test-repo", REPO_TYPE, settings);
    private BlobStore getMockedBlobStoreWithStats(long getCount, long putCount, boolean extendedStats) {
            .get();
        BlobStoreRepository repository = setupRepo();
            assertEquals("Shard path type should match", shardInfo.getIndexId().getShardPathType(), indexId.getShardPathType());
        RepositoryData repositoryData = generateRandomRepoData();
        assertEquals(defaultThresholdOfHeap, expectedThreshold);
            String.valueOf(indexId.getShardPathType()),
        }), 1);
        // removing a snapshot and writing to a new index generational file
    }
        repository.close();
        assertFalse(executed1.get());
        );
        repository.close();
        Set<String> unexpectedPaths = new HashSet<>(actualPaths);
    public void testGetStats_When_Sse_Enabled() {
        RepositoryMetadata metadata = repository.getMetadata();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * Verifies that {@code BlobStoreRepository.remoteDirectoryCleanupAsync} propagates the
                "Path hash algorithm should be FNV_1A_COMPOSITE_1",
        snapshotIds.add(new SnapshotId("snap1", UUIDs.randomBase64UUID()));
    }
        final String repositoryName = "test-repo";
        assertFalse(stats.detailed);
                Settings.builder()
            if (indexId.getShardPathType() != IndexId.DEFAULT_SHARD_PATH_TYPE) {
                    protected void assertSnapshotOrGenericThread() {
        RepositoryData repoData = generateRandomRepoData();
            .put(node().settings())
        repository.close();
        BlobStoreRepository repository = setupRepo();
        int numSnapshots = randomIntBetween(1, 20);
        assertNotNull(stats);
        assertTrue(repository.getPrefixModeVerification());
        CountDownLatch latch = new CountDownLatch(1);
 *    http://www.apache.org/licenses/LICENSE-2.0
        // when
        Set<String> writtenShardPaths = new HashSet<>();
import org.opensearch.common.blobstore.BlobContainer;
            eq(shardId),
            captor.capture()
        assertEquals(shardInfo.getShardCount(), shardCount);
    }
        final Client client = client();
        assertTrue(throttleTime >= 0);
            eq("repo"),
            String id = Integer.toString(i);
        // Case (b): null IndexMetadata propagated as null
        Map<String, BlobMetadata> mockSnapshotShardPaths = new HashMap<>();
            assertEquals(
        int shardCount = repoData.shardGenerations().getGens(indexId).size();
        Mockito.doReturn(blobStore).when(repoSpy).getBlobStore(false);
        final PlainActionFuture<RepositoryData> future1 = PlainActionFuture.newFuture();
    }
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.index.store.lockmanager.RemoteStoreLockManager;
            .prepareCreateSnapshot(repositoryName, "test-snap-1")
        repository.close();
            latch.countDown();
    }
        assertTrue("Cleanup did not complete within the expected time", latch.await(30, TimeUnit.SECONDS));
 */
        final Client client = client();
        RepositoryData repoData = generateRandomRepoData();
        public Map<String, Repository.Factory> getRepositories(
    public void testRemoteDirectoryCleanupAsyncPropagatesIndexMetadata() throws Exception {
        final String repositoryName = "test-repo";
            .settings(
        return repository;
                randomFrom(SnapshotState.SUCCESS, SnapshotState.PARTIAL, SnapshotState.FAILED),
        shardPath = String.join(
            RepositoryException.class,
            "repo",
 * ownership. Elasticsearch licenses this file to you under
        GroupedActionListener<DeleteResult> listener = new GroupedActionListener<>(ActionListener.wrap(deleteResults -> {
            String[] parts = shardPathBlobName.split("\\" + SnapshotShardPaths.DELIMITER);
        logger.info("--> make sure the node's repository can resolve the snapshots");
        final String repositoryName = "test-repo";
        assertEquals(metadata.type(), REPO_TYPE);
        final RepositoryData emptyData = RepositoryData.EMPTY;
            eq(indexUUID),
        BlobStore sseBlobStore = getMockedBlobStoreWithStats(5L, 10L, false);
        assertEquals(repoData.getSnapshotIds().size(), 0);
        // given
        Settings.Builder settings = Settings.builder()
        final RepositoriesService repositoriesService = getInstanceFromNode(RepositoriesService.class);
import java.util.HashSet;
    }
        final long expectedGeneration = pendingGeneration + 1L;
        final String indexName = "test-idx";
        final String repositoryName = "test-repo";
        Mockito.doReturn(sseBlobStore).when(repoSpy).getBlobStore(true);
        // Check if there are any unexpected additional paths
        repository.close();
                shardGenerations,
        RemoteStoreLockManager mockLockManager = mock(RemoteStoreLockManager.class);
            return Collections.singletonMap(
            "1"
        Compressor compressor = repository.getCompressor();
                snapshotId,
import java.util.Arrays;
    public void testGetStats_When_Sse_Disabled() {
            )
import org.opensearch.snapshots.SnapshotShardPaths.ShardInfo;
        assertThat(repository.readSnapshotIndexLatestBlob(), equalTo(expectedGeneration));
        Collection<DeleteResult> results = resultReference.get();
            shardId,
import static org.mockito.ArgumentMatchers.any;
    private RepositoryData addRandomSnapshotsToRepoData(RepositoryData repoData, boolean inclIndices) {
        NamedXContentRegistry registry = repository.getNamedXContentRegistry();
        Mockito.doReturn(sseBlobStore).when(repoSpy).getBlobStore(true);
        executed1.set(false);
        survivingIndexIds.add("current-index");
        BlobStore blobStore = getMockedBlobStoreWithStats(10L, 20L, true);
    }
        return blobStore;
    }
        }
        // write to and read from an index file with snapshots but no indices
        assertEquals("Total bytes deleted should be 150", 150L, combinedResult.bytesDeleted());
            .setIndices(indexName)
        logger.info("-->  creating repository");
                }
        repoData = addRandomSnapshotsToRepoData(OpenSearchBlobStoreRepositoryIntegTestCase.getRepositoryData(repository), true);
        String indexName = "test-idx";
        Map<String, Long> mergedStats = stats.extendedStats.get(BlobStore.Metric.REQUEST_SUCCESS);
        final Client client = client();
        assertTrue(executed1.get());
            logger.warn("Unexpected additional paths found: " + unexpectedPaths);
        }, e -> {
            repositoryData,
import static org.mockito.Mockito.mock;
        repository.writeIndexGen(repositoryData, startingGeneration, Version.CURRENT, Function.identity(), Priority.NORMAL, future1);
            NamedXContentRegistry namedXContentRegistry,
        verify(factory).newDirectory(
     */
            client().prepareIndex(indexName).setId(id).setSource("text", "sometext").get();
            final ShardGenerations.Builder builder = ShardGenerations.builder();
        String testIndexUUID = "test-idx-uuid";
        assertThat(repository.readSnapshotIndexLatestBlob(), equalTo(expectedGeneration + 2L));
    public void testReadAndWriteSnapshotsThroughIndexFile() throws Exception {
        final List<SnapshotId> originalSnapshots = Arrays.asList(snapshotId1, snapshotId2);
        RepositoryData repoData = OpenSearchBlobStoreRepositoryIntegTestCase.getRepositoryData(repository);
        RemoteStoreShardCleanupTask.ongoingRemoteDirectoryCleanups.add(getShardIdentifier(testIndexUUID, "0"));
import java.util.Collection;
        doAnswer(invocation -> {
            new IOException("expected-short-circuit")
            () -> writeIndexGen(repository, repositoryData.withGenId(startingGeneration + 1), repositoryData.getGenId())
        );
        assertNotNull(metadata);
            indexId.getName(),
        Map<String, BlobContainer> foundIndices = new HashMap<>();
            eq(false),
 * license agreements. See the NOTICE file distributed with
        final BlobStoreRepository repository = setupRepo();
            SnapshotShardPaths.DELIMITER,
        assertTrue(settings.contains(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY));
        // then
import org.opensearch.env.Environment;
        // write to and read from a index file with random repository data
        ensureGreen();
import org.opensearch.plugins.Plugin;
        actualPaths.remove("extra0");
            .setIndices(indexName)
        BlobStoreRepository repository = setupRepo();
    }
            ThreadPool.Names.REMOTE_PURGE,
import org.opensearch.index.remote.RemoteStorePathStrategy;
        repositoryData = OpenSearchBlobStoreRepositoryIntegTestCase.getRepositoryData(repository)
/**
        if (!unexpectedPaths.isEmpty()) {
        // write to index generational file
        long throttleTime = repository.getRemoteDownloadThrottleTimeInNanos();
    private String getShardIdentifier(String indexUUID, String shardId) {
            eq(pathStrategy),
        BlobContainer staleIndexContainer = mock(BlobContainer.class);
        writeIndexGen(repository, repositoryData, repositoryData.getGenId());
            final ShardGenerations shardGenerations = builder.build();
        CreateSnapshotResponse createSnapshotResponse = client.admin()
        AtomicBoolean executed1 = new AtomicBoolean(false);
        IndexId indexId = repoData.getIndices().values().iterator().next();
import org.opensearch.core.action.ActionListener;
    public void testSnapshotRepositoryDataCacheDefaultSetting() {
        assertEquals(shardInfo.getIndexId(), indexId);
        repository.close();
        PlainActionFuture.<RepositoryData, Exception>get(
    }
import org.mockito.ArgumentCaptor;
        DeleteResult combinedResult = results.stream().reduce(DeleteResult.ZERO, DeleteResult::add);
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
        assertNotNull(stats);
            indexId.getName(),
        BlobStoreRepository repoSpy = Mockito.spy(repository);
            "repo",
        assertTrue("Bytes deleted should be greater than 0", combinedResult.bytesDeleted() > 0);
import org.opensearch.common.settings.Setting;
        BlobContainer currentIndexContainer = mock(BlobContainer.class);
            factory,
        logger.info("--> create second snapshot");
    public void testAbsoluteThresholdUsed() {
            ThreadPool.Names.REMOTE_PURGE,
        // Version 2.17 has file name starting with snapshot_path_
        // write to and read from a index file with no entries
    // the reason for this plug-in is to drop any assertSnapshotOrGenericThread as mostly all access in this test goes from test threads
        long defaultAbsoluteThreshold = ByteSizeUnit.KB.toBytes(500);
        createSnapshotResponse = client.admin()
        BlobStoreRepository repository = mock(BlobStoreRepository.class);
        if (extendedStats) {
            .setWaitForCompletion(true)
import java.util.HashMap;
        Settings.Builder settings = Settings.builder()
                indexLookup,
        assertTrue(throttleTime >= 0);
import org.opensearch.snapshots.SnapshotShardPaths;
        List<Setting<?>> settings = repository.getRestrictedSystemRepositorySettings();
            tp,
        BlobStoreRepository.remoteDirectoryCleanupAsync(
            logger.error("Error in cleanupStaleIndices", e);
            eq(null),
            }
            pathStrategy,
    }
        Map<String, BlobMetadata> shardPathBlobs = repository.snapshotShardPathBlobContainer().listBlobs();
    }
    public void testIsReadOnly() {
        return Arrays.asList(FsLikeRepoPlugin.class);
    public void testGetStats_When_Sse_Enabled_WithExtended_Stats() {
        ExecutorService directExecutor = OpenSearchExecutors.newDirectExecutorService();
                    @Override
        final RepositoriesService repositoriesService = getInstanceFromNode(RepositoriesService.class);
        // given
import org.opensearch.common.settings.Settings;
                    }
            blobStoreStatsMap.put("GET", getCount);
        final SnapshotId snapshotId1 = createSnapshotResponse.getSnapshotInfo().snapshotId();
            blobStoreStatsMap.put("requests_count", getCount + putCount);
        repository.close();
    public void testGetRemoteDownloadThrottleTimeInNanos() {
        assertTrue(throttleTime >= 0);
        List<SnapshotId> snapshotIds = OpenSearchBlobStoreRepositoryIntegTestCase.getRepositoryData(repository)
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        long defaultAbsoluteThreshold = ByteSizeUnit.KB.toBytes(500);
        }).when(repository).cleanupStaleIndices(any(), any(), any(), any(), any(), any(), any(), any(), anyMap());
        // then
            ClusterService clusterService,
import java.util.function.Function;
        writeIndexGen(repository, repositoryData, repositoryData.getGenId());
        final long pendingGeneration = repository.metadata.pendingGeneration();
    public void testGetMetadata() {
        BlobStore blobStore = getMockedBlobStoreWithStats(10L, 20L, false);
import org.opensearch.cluster.service.ClusterService;
    }
        assertNotNull("IndexSettings should not be null when IndexMetadata is provided", captor.getValue());
import static org.mockito.ArgumentMatchers.anyMap;
        repository.close();
        }
        String shardPath = String.join(
        long throttleTime = repository.getRestoreThrottleTimeInNanos();
        verify(mockSnapshotShardPathBlobContainer, times(1)).delete();
    public void testParseShardPath() {
 */
        assertThat(snapshotIds, equalTo(originalSnapshots));
        repository.close();
        repository.close();
import java.util.Collections;
        RepositoryStats stats = repoSpy.stats();
    public void testCleanupStaleIndices() throws Exception {
import org.opensearch.repositories.fs.FsRepository;
        }
        assertEquals(repoData, OpenSearchBlobStoreRepositoryIntegTestCase.getRepositoryData(repository));
            .get();
 * GitHub history for details.
        foundIndices.put("current-index", currentIndexContainer);
        writeIndexGen(repository, repoData, repoData.getGenId());
    }
        RemoteStoreShardCleanupTask.ongoingRemoteDirectoryCleanups.add(getShardIdentifier(testIndexUUID, "1"));
        expectThrows(
        when(mockSnapshotShardPathBlobContainer.delete()).thenReturn(new DeleteResult(1, 50L));
                builder.put(new IndexId(randomAlphaOfLength(8), UUIDs.randomBase64UUID()), 0, "1");
        BlobStoreRepository repoSpy = Mockito.spy(repository);
        repositoryData = addRandomSnapshotsToRepoData(OpenSearchBlobStoreRepositoryIntegTestCase.getRepositoryData(repository), true);
 * Licensed to Elasticsearch under one or more contributor
                if (!surviving.contains(entry.getKey())) {
import org.opensearch.repositories.RepositoriesService;
    static final String REPO_TYPE = "fsLike";
        assertEquals(maxSafeArraySize, expectedThreshold);
        final BlobStoreRepository repository = (BlobStoreRepository) repositoriesService.repository(repositoryName);
import org.opensearch.action.support.PlainActionFuture;
        assertFalse("DeleteResult collection should not be empty", results.isEmpty());
    public void testGetRestoreThrottleTimeInNanos() {
    }
                .collect(Collectors.toMap(Function.identity(), ind -> randomAlphaOfLength(256)));
        assertThat("getBlobContainer has to be lazy initialized", repository.getBlobContainer(), nullValue());
        RepositoryStats stats = repoSpy.stats();
        Mockito.doReturn(sseBlobStore).when(repoSpy).getBlobStore(true);
        BlobStore blobStore = getMockedBlobStoreWithStats(10L, 20L, false);
    }
        long throttleTime = repository.getSnapshotThrottleTimeInNanos();
    /**
        assertEquals("Expected and actual paths should match after removing known extra files", expectedPaths, actualPaths);
    }
import java.util.concurrent.TimeUnit;
        );
        BlobStore sseBlobStore = getMockedBlobStoreWithStats(5L, 10L, true);
        final Settings settings = Settings.builder().put(node().settings()).put("location", location).build();
            "1"
                String shardPathBlobName = repository.writeIndexShardPaths(indexId, snapshotId, indexId.getShardPathType());
        when(repository.snapshotShardPathBlobContainer()).thenReturn(mockSnapshotShardPathBlobContainer);
        assertEquals(repoData, emptyData);
    }
        assertTrue(stats.detailed);
        Mockito.doReturn(blobStore).when(repoSpy).getBlobStore(false);
import org.opensearch.core.compress.Compressor;
        client().admin().indices().prepareFlush(indexName).get();
    }
        Runnable task1 = () -> executed1.set(true);
        final RepositoriesService repositoriesService = getInstanceFromNode(RepositoriesService.class);
        verify(factory).newDirectory(
        BlobStoreRepository repository = setupRepo();
        ThreadPool tp = mock(ThreadPool.class);
        String validShardPath = "stale-index-id#stale-index#1#0#1";
        // when
        RepositoryData repositoryData = generateRandomRepoData();
        final long startingGeneration = repositoryData.getGenId();
        when(factory.newDirectory(anyString(), anyString(), any(), any(), nullable(String.class), eq(false), eq(false), any())).thenThrow(
        long defaultThresholdOfHeap = ByteSizeUnit.KB.toBytes(499);
 * You may obtain a copy of the License at
        final Path location = OpenSearchIntegTestCase.randomRepoPath(node().settings());
        assertTrue(settings.contains(BlobStoreRepository.READONLY_SETTING));
        ShardId shardId = new ShardId(new Index("idx", indexUUID), 0);
        assertFalse(repository.isSystemRepository());
        BlobStoreRepository repository = setupRepo();
        // then
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
        assertNotNull(registry);
        RemoteStoreShardCleanupTask.ongoingRemoteDirectoryCleanups.add(getShardIdentifier(testIndexUUID, "2"));
        // Scenario 2: ongoing = true => currentTask skipped.
        assertEquals(15, mergedStats.get("GET").longValue());
        // Verify that the current index was not processed for deletion
                Version.CURRENT,
            indexMetadata
            survivingIndexIds,
     * Guards against regressions where IndexMetadata is dropped or replaced with null during cleanup.
    }
        @Override
        // Case (a): non-null IndexMetadata propagated
 *
 * Unless required by applicable law or agreed to in writing,
import java.util.ArrayList;
            factory,
        Map<String, Long> mergedStats = stats.extendedStats.get(BlobStore.Metric.REQUEST_SUCCESS);
        // N+1 generation from which this repository data instance was created
        long maxThreshold = BlobStoreRepository.calculateMaxSnapshotRepositoryDataCacheThreshold();
        long throttleTime = repository.getLowPriorityRemoteUploadThrottleTimeInNanos();
import java.util.stream.Collectors;
            null,
        RepositoryStats stats = repoSpy.stats();
            GroupedActionListener<DeleteResult> listener = invocation.getArgument(6);
            String.valueOf(indexId.getShardPathType()),
    }
                    .put(IndexMetadata.SETTING_INDEX_UUID, indexUUID)
            .put(FsRepository.REPOSITORIES_COMPRESS_SETTING.getKey(), true)
        int numDocs = randomIntBetween(10, 20);
        assertThat(OpenSearchBlobStoreRepositoryIntegTestCase.getRepositoryData(repository).getSnapshotIds().size(), equalTo(0));
    public void testGetCompressor() {
        Mockito.doReturn(blobStore).when(repoSpy).getBlobStore(false);
        // Create sets for comparison
import org.opensearch.cluster.metadata.RepositoryMetadata;
        Map<String, Long> mergedStats = stats.extendedStats.get(BlobStore.Metric.REQUEST_SUCCESS);
        repository.close();
        assertEquals("Total blobs deleted should be 2", 2, combinedResult.blobsDeleted());
            for (Map.Entry<String, BlobContainer> entry : indices.entrySet()) {
        long result = calculateMaxWithinIntLimit(defaultThresholdOfHeap, defaultAbsoluteThreshold);
    public void testWriteAndReadShardPaths() throws Exception {
                indexLookup.values().stream().collect(Collectors.toMap(Function.identity(), ignored -> UUIDs.randomBase64UUID(random())))
import static org.mockito.Mockito.doAnswer;
import org.opensearch.repositories.IndexId;
            .put(node().settings())
        Set<String> actualPaths = new HashSet<>(shardPathBlobs.keySet());
            SnapshotShardPaths.FILE_PREFIX + indexId.getId(),
import static org.hamcrest.Matchers.nullValue;
        for (String shardPathBlobName : expectedPaths) {
            RepositoryException.class,
            DeleteResult result = DeleteResult.ZERO;
        RepositoryStats stats = repoSpy.stats();
            int numIndices = inclIndices ? randomIntBetween(0, 20) : 0;
        logger.info("--> create first snapshot");
        logger.info("--> creating an index and indexing documents");
import org.opensearch.common.blobstore.BlobMetadata;
        ArgumentCaptor<IndexSettings> captor = ArgumentCaptor.forClass(IndexSettings.class);
                writtenShardPaths.add(shardPathBlobName);
import static org.mockito.Mockito.never;
        // factory.newDirectory throws IOException to short-circuit; we only care about the args passed
import org.opensearch.core.xcontent.NamedXContentRegistry;
        when(factory.newDirectory(anyString(), anyString(), any(), any(), nullable(String.class), eq(false), eq(false), any())).thenThrow(
 */
        RemoteSegmentStoreDirectoryFactory factory = mock(RemoteSegmentStoreDirectoryFactory.class);
import java.io.IOException;
        int maxSafeArraySize = Integer.MAX_VALUE - 8;
            result = result.add(mockSnapshotShardPathBlobContainer.delete());
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertNotNull("DeleteResult collection should not be null", results);
            SnapshotId snapshotId = new SnapshotId(randomAlphaOfLength(8), UUIDs.randomBase64UUID());
import org.opensearch.transport.client.Client;
    public void testThresholdCappedAtIntMax() {
import org.opensearch.common.Priority;
        assertEquals(shardInfo.getIndexId(), indexId);
        Set<String> survivingIndexIds = new HashSet<>();
        Mockito.doReturn(sseBlobStore).when(repoSpy).getBlobStore(true);
        RepositoryStats stats = repository.stats();
        assertTrue("Blobs deleted should be greater than 0", combinedResult.blobsDeleted() > 0);
import org.opensearch.core.index.Index;
        Settings.Builder settings = Settings.builder().put(node().settings()).put("location", location);
        assertTrue(throttleTime >= 0);
            String.valueOf(shardCount),
import org.opensearch.test.OpenSearchIntegTestCase;
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        final Path location = OpenSearchIntegTestCase.randomRepoPath(node().settings());
        repository.close();
        long defaultThresholdOfHeap = ByteSizeUnit.GB.toBytes(1);
import org.opensearch.common.blobstore.DeleteResult;
            .getSnapshotIds()
            SnapshotShardPaths.DELIMITER,
            eq(false),
    public void testGetLowPriorityRemoteUploadThrottleTimeInNanos() {
import org.opensearch.indices.recovery.RecoverySettings;
        BlobStoreRepository repository = setupRepo();
        BlobStoreRepository repoSpy = Mockito.spy(repository);
    }
        }
        final BlobStoreRepository repository = (BlobStoreRepository) repositoriesService.repository(repositoryName);
    public void testGetStats() {
import java.util.Map;
        assertEquals(shardInfo.getShardCount(), shardCount);
        }
        repository.close();
import org.opensearch.core.index.shard.ShardId;
        assertThat(repository.latestIndexBlobId(), equalTo(expectedGeneration));
            final Map<IndexId, String> indexLookup = shardGenerations.indices()
            latch.countDown();
            eq("repo"),
/*
            .collect(Collectors.toList());
        repository.close();
        final long pendingGeneration = repository.metadata.pendingGeneration();
        long throttleTime = repository.getRemoteUploadThrottleTimeInNanos();
            SnapshotShardPaths.ShardInfo shardInfo = SnapshotShardPaths.parseShardPath(shardPathBlobName);
        assertNotNull(stats);
        // when
        Mockito.doReturn(blobStore).when(repoSpy).getBlobStore(false);
        BlobStoreRepository repository = setupRepo();
        BlobStoreRepository repository = setupRepo();
import org.opensearch.plugins.RepositoryPlugin;
            eq(false),
import static org.mockito.ArgumentMatchers.anyString;
        // Create a mock RemoteStoreLockManagerFactory
        ) {
import org.opensearch.snapshots.SnapshotState;
            assertNotNull("IndexId should not be null", indexId);
    public void testGetStats_When_Sse_Only_Enabled() {
        // Create mock snapshot shard paths
        new FsRepository(metadata, useCompressEnvironment, null, BlobStoreTestUtil.mockClusterService(), null);
        // Read shard paths and verify
        assertEquals(repoData.getIndices().size(), 0);
    }
 * KIND, either express or implied.  See the License for the
        assertEquals(20, mergedStats.get("PUT").longValue());
        assertNotNull(stats);
                    result = result.add(entry.getValue().delete());
        writeIndexGen(repository, repositoryData, RepositoryData.EMPTY_REPO_GEN);
        assertTrue(settings.contains(BlobStoreRepository.SYSTEM_REPOSITORY_SETTING));
        BlobStore sseBlobStore = getMockedBlobStoreWithStats(5L, 10L, true);
            snapshotIds,
        assertTrue("All expected paths should be present", actualPaths.containsAll(expectedPaths));
        );
            f -> repository.writeIndexGen(repositoryData, generation, Version.CURRENT, Function.identity(), Priority.NORMAL, f)
        // write repo data again to index generational file, errors because we already wrote to the
        assertTrue(throttleTime >= 0);
        HashMap<String, Long> blobStoreStatsMap = new HashMap<>();
            false,
public class BlobStoreRepositoryTests extends BlobStoreRepositoryHelperTests {
        assertFalse(stats.detailed);
            );
        Environment useCompressEnvironment = new Environment(useCompressSettings, node().getEnvironment().configDir());
        assertEquals(10, mergedStats.get("PUT").longValue());
                        // eliminate thread name check as we access blobStore on test/main threads
        long expectedThreshold = calculateMaxWithinIntLimit(defaultThresholdOfHeap, defaultAbsoluteThreshold);
        repoData = addRandomSnapshotsToRepoData(repoData, false);
            .stream()
    }
    public void testGetNamedXContentRegistry() {
        verify(staleIndexContainer, times(1)).delete();
        RemoteStoreLockManagerFactory mockRemoteStoreLockManagerFactory = mock(RemoteStoreLockManagerFactory.class);
            Mockito.when(blobStore.extendedStats()).thenReturn(blobStoreMetricMap);
            eq(false),
        // given
import org.opensearch.index.store.RemoteSegmentStoreDirectoryFactory;
        Set<String> expectedPaths = new HashSet<>(writtenShardPaths);
        // write to index generational file
        );
        assertEquals(30, stats.requestCounts.get("requests_count").longValue());
        IndexMetadata indexMetadata = IndexMetadata.builder("idx")
        final Path location = OpenSearchIntegTestCase.randomRepoPath(node().settings());
        RemoteStorePathStrategy pathStrategy = new RemoteStorePathStrategy(RemoteStoreEnums.PathType.FIXED);
        RepositoryData repositoryData = generateRandomRepoData();
            Set<String> surviving = invocation.getArgument(2);
import java.util.Set;
        assertThat(repository.latestIndexBlobId(), equalTo(expectedGeneration + 1L));
    public void testGetSnapshotThrottleTimeInNanos() {
    }
        assertNotNull(stats);
        // Call the method we're testing
        long defaultThresholdOfHeap = (long) maxSafeArraySize + 1;
            RecoverySettings recoverySettings
        BlobStoreRepository repoSpy = Mockito.spy(repository);
        final SnapshotId snapshotId2 = createSnapshotResponse.getSnapshotInfo().snapshotId();
import java.util.List;
        assertNotNull(settings);
        // Scenario 1: ongoing = false => executed
import org.opensearch.snapshots.SnapshotId;
        assertEquals(10, mergedStats.get("GET").longValue());
        verify(currentIndexContainer, never()).delete();
        final BlobStoreRepository repository = setupRepo();
        BlobStoreRepository repository = setupRepo();
import static org.mockito.ArgumentMatchers.nullable;
        assertEquals(pendingGeneration + 1L, repoData.getGenId());
import org.opensearch.index.IndexSettings;
 * software distributed under the License is distributed on an
            for (int j = 0; j < numIndices; j++) {
        String indexUUID = "test-uuid";
        return String.join("/", indexUUID, shardId);
import static org.mockito.ArgumentMatchers.eq;
import java.util.concurrent.CountDownLatch;
        assertEquals(5, mergedStats.get("GET").longValue());
import org.mockito.Mockito;
            .put("location", location)
 * not use this file except in compliance with the License.
        assertEquals(metadata.name(), "test-repo");
            mockRemoteStoreLockManagerFactory,
    }
        BlobStoreRepository repoSpy = Mockito.spy(repository);
    private BlobStoreRepository setupRepo() {
            }
        // Mock the BlobStoreRepository
    public void testFsRepositoryCompressDeprecatedIgnored() {
import org.opensearch.repositories.Repository;
        RepositoryStats stats = repoSpy.stats();
    public void testRemoteStoreShardCleanupTask() {
        expectThrows(
            .cluster()
 * SPDX-License-Identifier: Apache-2.0
        return repoData;
            mockSnapshotShardPaths,
            .removeSnapshots(Collections.singleton(repositoryData.getSnapshotIds().iterator().next()), ShardGenerations.EMPTY);
    }
    }
        unexpectedPaths.removeAll(expectedPaths);
            }
        final Path location = OpenSearchIntegTestCase.randomRepoPath(node().settings());
import org.opensearch.index.store.lockmanager.RemoteStoreLockManagerFactory;
import org.opensearch.common.UUIDs;
            pathStrategy,
import org.opensearch.cluster.metadata.IndexMetadata;
        Mockito.reset(factory);
        // just adding random shards in ongoing cleanups.
            Mockito.when(blobStore.stats()).thenReturn(blobStoreStatsMap);
    public void testIndexGenerationalFiles() throws Exception {
        writeIndexGen(repository, repoData, repoData.getGenId());
            (IndexSettings) eq(null)
    }
        RemoteSegmentStoreDirectoryFactory mockRemoteSegmentStoreDirectoryFactory = mock(RemoteSegmentStoreDirectoryFactory.class);
        BlobStoreRepository repository = setupRepo();
            Collections.emptyMap()
            .put(BlobStoreRepository.PREFIX_MODE_VERIFICATION_SETTING.getKey(), true);
        assertThat(repository.latestIndexBlobId(), equalTo(expectedGeneration + 2L));
            listener.onResponse(result);
        assertThat(OpenSearchBlobStoreRepositoryIntegTestCase.getRepositoryData(repository), equalTo(repositoryData));
    }
        BlobStoreRepository repository = setupRepo();
    public void testGetStats_When_Sse_Only_Enabled_WithExtended_Stats() {
import org.opensearch.action.support.GroupedActionListener;
        final BlobStoreRepository repository = (BlobStoreRepository) repositoriesService.repository(repositoryName);
 * under the License.
        );
import static org.mockito.Mockito.verify;
import org.opensearch.repositories.ShardGenerations;
        assertNotNull(compressor);
import java.util.concurrent.atomic.AtomicBoolean;
        assertNotNull(stats);
        repository.close();
        ShardInfo shardInfo = SnapshotShardPaths.parseShardPath(shardPath);
        for (int i = 0; i < numDocs; i++) {
        BlobStoreRepository repository = setupRepo();
            tp,
            blobStoreStatsMap.put("PUT", putCount);
        repository.close();
        // Verify the total number of bytes and blobs deleted
        // Mock the cleanupStaleIndices method to call our test implementation
        assertFalse(repository.isReadOnly());
    public void testGetStats_When_Sse_not_Enabled_WithExtended_Stats() {
        // Version 2.17 has file name starting with indexId
        ShardId shardId = new ShardId(new Index(indexName, testIndexUUID), 0);
        BlobStoreRepository repository = setupRepo();
        assertEquals(30, mergedStats.get("PUT").longValue());
        BlobStore blobStore = getMockedBlobStoreWithStats(10L, 20L, true);
            new IOException("expected-short-circuit")
        );
            .build();
        }
import static org.mockito.Mockito.times;
 *
            String.valueOf(shardCount),
        AtomicReference<Collection<DeleteResult>> resultReference = new AtomicReference<>();
import org.opensearch.repositories.RepositoryException;
        when(tp.executor(ThreadPool.Names.REMOTE_PURGE)).thenReturn(directExecutor);
            indexUUID,
        BlobStoreRepository repository = setupRepo();
        );
        snapshotIds.add(new SnapshotId("snap2", UUIDs.randomBase64UUID()));
        // Check if all expected paths are present in the actual paths
    }
    public void testBadChunksize() throws Exception {
        SnapshotId snapshotId = repoData.getSnapshotIds().iterator().next();
            // Simulate the cleanup process
    }
        remoteStoreShardCleanupTask.run();
            assertEquals("Index ID should match", shardInfo.getIndexId().getId(), indexId.getId());
            false,
        assertEquals(OpenSearchBlobStoreRepositoryIntegTestCase.getRepositoryData(repository), RepositoryData.EMPTY);
            foundIndices,
        BlobStoreRepository repository = setupRepo();
import java.util.concurrent.atomic.AtomicReference;
        assertEquals(OpenSearchBlobStoreRepositoryIntegTestCase.getRepositoryData(repository), repositoryData);
        when(staleIndexContainer.delete()).thenReturn(new DeleteResult(1, 100L));
        BlobStore sseBlobStore = getMockedBlobStoreWithStats(5L, 10L, false);
                REPO_TYPE,
    public void testRepositoryDataConcurrentModificationNotAllowed() {
            );
        mockSnapshotShardPaths.put(validShardPath, mock(BlobMetadata.class));
                }
            null
        );
