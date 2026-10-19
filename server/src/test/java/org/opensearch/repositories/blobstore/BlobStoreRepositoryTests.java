    public void testRemoteDirectoryCleanupAsyncPropagatesIndexMetadata() throws Exception {  
            ThreadPool.Names.REMOTE_PURGE,
        assertNotNull(registry);
        }).when(repository).cleanupStaleIndices(any(), any(), any(), any(), any(), any(), any(), any(), anyMap());
import java.nio.file.Path;
            eq("repo"),
        RepositoryData repositoryData = generateRandomRepoData();
        assertEquals(30, mergedStats.get("PUT").longValue());
            return Collections.singletonMap(  
import org.opensearch.common.Priority;
        repository.close();
        BlobStoreRepository repository = setupRepo();  
        repositoryData = addRandomSnapshotsToRepoData(OpenSearchBlobStoreRepositoryIntegTestCase.getRepositoryData(repository), true);  
        assertNoDeprecationWarnings();
        when(tp.executor(ThreadPool.Names.REMOTE_PURGE)).thenReturn(directExecutor);  
 * the Apache License, Version 2.0 (the "License"); you may
        when(staleIndexContainer.delete()).thenReturn(new DeleteResult(1, 100L));
 * KIND, either express or implied.  See the License for the
        Map<String, BlobMetadata> mockSnapshotShardPaths = new HashMap<>();
                RemoteStoreEnums.PathHashAlgorithm.FNV_1A_COMPOSITE_1,
        assertThat(repository.latestIndexBlobId(), equalTo(expectedGeneration + 2L));
    public void testGetLowPriorityRemoteUploadThrottleTimeInNanos() {
            int numIndices = inclIndices ? randomIntBetween(0, 20) : 0;
import static org.mockito.ArgumentMatchers.eq;  
            "repo",
            () -> writeIndexGen(repository, repositoryData.withGenId(startingGeneration + 1), repositoryData.getGenId())
        return String.join("/", indexUUID, shardId);  
 * software distributed under the License is distributed on an
            eq(indexUUID),
    }
        repository.close();
            Collections.emptyMap()  
        public Map<String, Repository.Factory> getRepositories(  
        Environment useCompressEnvironment = new Environment(useCompressSettings, node().getEnvironment().configDir());
        assertEquals(repoData.getSnapshotIds().size(), 0);
        RepositoryStats stats = repoSpy.stats();
        assertEquals(repository.repositoryDataCacheThreshold, expectedThreshold);
        assertEquals(pendingGeneration + 1L, repoData.getGenId());
            logger.warn("Unexpected additional paths found: " + unexpectedPaths);
        assertEquals(metadata.type(), REPO_TYPE);  
        repoData = addRandomSnapshotsToRepoData(OpenSearchBlobStoreRepositoryIntegTestCase.getRepositoryData(repository), true);
            String.valueOf(shardCount),
            () -> OpenSearchIntegTestCase.putRepository(client.admin().cluster(), repositoryName, REPO_TYPE, settings)  
    }  
            }  
                    result = result.add(entry.getValue().delete());  
        BlobStore blobStore = getMockedBlobStoreWithStats(10L, 20L, false);
        final RepositoryData emptyData = RepositoryData.EMPTY;
                }
            .put(node().settings())
            .sorted((s1, s2) -> s1.getName().compareTo(s2.getName()))
 */  
    }  
        actualPaths.remove("extra0");
    public void testSnapshotRepositoryDataCacheDefaultSetting() {
        when(mockSnapshotShardPathBlobContainer.delete()).thenReturn(new DeleteResult(1, 50L));
        Mockito.reset(factory);  
        if (!unexpectedPaths.isEmpty()) {
            false,  
        logger.info("--> make sure the node's repository can resolve the snapshots");
        );
    protected Collection<Class<? extends Plugin>> getPlugins() {
        Map<String, BlobMetadata> shardPathBlobs = repository.snapshotShardPathBlobContainer().listBlobs();
        // then
            tp,
        List<Setting<?>> settings = repository.getRestrictedSystemRepositorySettings();  
            eq(null),
            )
        Settings.Builder settings = Settings.builder().put(node().settings()).put("location", location);  
import static org.mockito.Mockito.times;
        RemoteStoreLockManager mockLockManager = mock(RemoteStoreLockManager.class);
        writeIndexGen(repository, repositoryData, repositoryData.getGenId());  
        repository.close();  
        long throttleTime = repository.getLowPriorityRemoteUploadThrottleTimeInNanos();
            result = result.add(mockSnapshotShardPathBlobContainer.delete());  
            RecoverySettings recoverySettings
    }
        );  
    }  
            eq(false),  
    public void testGetSnapshotThrottleTimeInNanos() {
        IndexId indexId = repoData.getIndices().values().iterator().next();
        final BlobStoreRepository repository = (BlobStoreRepository) repositoriesService.repository(repositoryName);
        );
            SnapshotShardPaths.ShardInfo shardInfo = SnapshotShardPaths.parseShardPath(shardPathBlobName);
import org.opensearch.snapshots.SnapshotShardPaths.ShardInfo;
    public void testGetStats_When_Sse_Disabled() {
import org.opensearch.core.index.shard.ShardId;  
        long throttleTime = repository.getRemoteUploadThrottleTimeInNanos();  
        RepositoryStats stats = repository.stats();
 * license agreements. See the NOTICE file distributed with
        repository.close();
        // write repo data again to index generational file, errors because we already wrote to the  
import static org.mockito.Mockito.never;
        shardInfo = SnapshotShardPaths.parseShardPath(shardPath);  
        assertEquals(shardInfo.getShardCount(), shardCount);
import org.opensearch.plugins.Plugin;
    }  
import org.opensearch.snapshots.SnapshotState;
        ShardInfo shardInfo = SnapshotShardPaths.parseShardPath(shardPath);
        AtomicBoolean executed1 = new AtomicBoolean(false);
        );  
            .cluster()
import org.opensearch.repositories.fs.FsRepository;
        BlobStoreRepository repository = setupRepo();
        assertTrue(stats.detailed);
        repository.close();
import org.mockito.ArgumentCaptor;
        RepositoryData repoData = OpenSearchBlobStoreRepositoryIntegTestCase.getRepositoryData(repository);
 * under the License.  
            String[] parts = shardPathBlobName.split("\\" + SnapshotShardPaths.DELIMITER);
            for (Map.Entry<String, BlobContainer> entry : indices.entrySet()) {
        BlobStoreRepository repository = mock(BlobStoreRepository.class);  
            .stream()  
        BlobStoreRepository repoSpy = Mockito.spy(repository);  
        final SnapshotId snapshotId1 = createSnapshotResponse.getSnapshotInfo().snapshotId();  
            "1"
            .removeSnapshots(Collections.singleton(repositoryData.getSnapshotIds().iterator().next()), ShardGenerations.EMPTY);
        String shardPath = String.join(  
        PlainActionFuture.<RepositoryData, Exception>get(  
        final Path location = OpenSearchIntegTestCase.randomRepoPath(node().settings());
                .collect(Collectors.toMap(Function.identity(), ind -> randomAlphaOfLength(256)));
        assertTrue(throttleTime >= 0);  
        RepositoryStats stats = repoSpy.stats();
    }
    }  
        assertEquals(repoData, emptyData);
            eq(null),
        assertEquals(maxSafeArraySize, expectedThreshold);  
        // write to and read from a index file with random repository data  
import org.opensearch.snapshots.SnapshotShardPaths;  
    public void testRepositoryDataConcurrentModificationNotAllowed() {  
        assertEquals(shardInfo.getShardCount(), shardCount);
        }
        repository.close();  
import java.util.HashMap;
import org.opensearch.index.store.lockmanager.RemoteStoreLockManager;
        RemoteSegmentStoreDirectoryFactory factory = mock(RemoteSegmentStoreDirectoryFactory.class);
        assertTrue(stats.detailed);
        assertTrue(settings.contains(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY));
        List<SnapshotId> snapshotIds = new ArrayList<>();
        assertNotNull("IndexSettings should not be null when IndexMetadata is provided", captor.getValue());  
        unexpectedPaths.removeAll(expectedPaths);  
            pathStrategy,
        BlobStoreRepository repository = setupRepo();
            foundIndices,
/*  
        if (extendedStats) {
        final RepositoriesService repositoriesService = getInstanceFromNode(RepositoriesService.class);
        assertEquals("Expected and actual paths should match after removing known extra files", expectedPaths, actualPaths);
import org.opensearch.repositories.ShardGenerations;  
            Map<BlobStore.Metric, Map<String, Long>> blobStoreMetricMap = Map.of(BlobStore.Metric.REQUEST_SUCCESS, blobStoreStatsMap);
        expectThrows(
        }
    public void testPrefixModeVerification() throws Exception {
        // Mock the cleanupStaleIndices method to call our test implementation
import org.opensearch.test.OpenSearchIntegTestCase;  
            Set<String> surviving = invocation.getArgument(2);
import java.util.concurrent.CountDownLatch;  
        SnapshotId snapshotId = repoData.getSnapshotIds().iterator().next();
            .put("location", location)
        assertNotNull(stats);  
        CountDownLatch latch = new CountDownLatch(1);
        repository.close();
        assertFalse(stats.detailed);
import org.opensearch.indices.recovery.RecoverySettings;  
 * not use this file except in compliance with the License.
 *
        RemoteStoreShardCleanupTask.ongoingRemoteDirectoryCleanups.add(getShardIdentifier(testIndexUUID, "2"));  
import static org.mockito.Mockito.doAnswer;
        BlobStoreRepository.remoteDirectoryCleanupAsync(
        assertFalse(executed1.get());  
        repository.close();
        assertNotNull(stats);  
        // Create mock snapshot shard paths
        final Path location = OpenSearchIntegTestCase.randomRepoPath(node().settings());
import org.opensearch.common.blobstore.BlobMetadata;
import java.util.HashSet;
            IndexId indexId = repoData.getIndices().get(shardInfo.getIndexId().getName());  
            Environment env,
    // the reason for this plug-in is to drop any assertSnapshotOrGenericThread as mostly all access in this test goes from test threads
    }  
            listener,
        repository.close();
import org.opensearch.core.common.unit.ByteSizeUnit;  
import static org.mockito.Mockito.mock;  
        assertThat(repository.readSnapshotIndexLatestBlob(), equalTo(expectedGeneration + 1L));
        }
import java.util.Set;
    }
    }
        RemoteStoreShardCleanupTask remoteStoreShardCleanupTask = new RemoteStoreShardCleanupTask(task1, testIndexUUID, shardId);  
            String.valueOf(indexId.getShardPathType()),  
        assertThat(OpenSearchBlobStoreRepositoryIntegTestCase.getRepositoryData(repository).getSnapshotIds().size(), equalTo(0));
            for (int j = 0; j < numIndices; j++) {
        ShardId shardId = new ShardId(new Index("idx", indexUUID), 0);  
        Settings.Builder settings = Settings.builder()
        NamedXContentRegistry registry = repository.getNamedXContentRegistry();  
        final Client client = client();  
            .build();  
        // Read shard paths and verify  
        Set<String> expectedPaths = new HashSet<>(writtenShardPaths);
        int numSnapshots = randomIntBetween(1, 20);
            indexUUID,
import java.util.List;  
        // removing a snapshot and writing to a new index generational file  
        BlobStoreRepository repository = setupRepo();
        long defaultThresholdOfHeap = ByteSizeUnit.GB.toBytes(1);
                    }  
            SnapshotId snapshotId = new SnapshotId(randomAlphaOfLength(8), UUIDs.randomBase64UUID());
        }  
    }
                "Path hash algorithm should be FNV_1A_COMPOSITE_1",  
            eq(shardId),
        RepositoryData repositoryData = generateRandomRepoData();
    public void testRetrieveSnapshots() throws Exception {  
        Settings useCompressSettings = Settings.builder()  
            shardId,
        // Case (a): non-null IndexMetadata propagated
        repository.writeIndexGen(repositoryData, startingGeneration, Version.CURRENT, Function.identity(), Priority.NORMAL, future1);
        long expectedThreshold = Math.max(ByteSizeUnit.KB.toBytes(500), maxThreshold / 2);
        Mockito.doReturn(sseBlobStore).when(repoSpy).getBlobStore(true);  
        // write to and read from a index file with no entries  
        Mockito.doReturn(blobStore).when(repoSpy).getBlobStore(false);
        assertEquals(45, stats.requestCounts.get("requests_count").longValue());  
        // Call the method we're testing
            repoData = repoData.addSnapshot(
    }
        assertTrue("Bytes deleted should be greater than 0", combinedResult.bytesDeleted() > 0);
        final List<SnapshotId> originalSnapshots = Arrays.asList(snapshotId1, snapshotId2);
            client().prepareIndex(indexName).setId(id).setSource("text", "sometext").get();
        // given  
                Version.CURRENT,
        // Scenario 2: ongoing = true => currentTask skipped.
    }
            eq(false),
    public void testGetRemoteDownloadThrottleTimeInNanos() {  
        @Override
        assertEquals(defaultAbsoluteThreshold, result);
        final Path location = OpenSearchIntegTestCase.randomRepoPath(node().settings());
    }
        assertTrue(stats.detailed);
        BlobContainer mockSnapshotShardPathBlobContainer = mock(BlobContainer.class);
    private BlobStoreRepository setupRepo() {
        final long pendingGeneration = repository.metadata.pendingGeneration();
    }
                String shardPathBlobName = repository.writeIndexShardPaths(indexId, snapshotId, indexId.getShardPathType());
        foundIndices.put("stale-index", staleIndexContainer);
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        // Verify that the current index was not processed for deletion
            f -> repository.writeIndexGen(repositoryData, generation, Version.CURRENT, Function.identity(), Priority.NORMAL, f)
import org.opensearch.action.support.GroupedActionListener;  
            .put(FsRepository.REPOSITORIES_COMPRESS_SETTING.getKey(), true)
import java.util.concurrent.TimeUnit;
            indexId.getName(),  
    }
import java.util.Collection;
        Map<String, Long> mergedStats = stats.extendedStats.get(BlobStore.Metric.REQUEST_SUCCESS);
import org.opensearch.threadpool.ThreadPool;
                writtenShardPaths.add(shardPathBlobName);
        BlobStoreRepository repository = setupRepo();  
        long defaultAbsoluteThreshold = ByteSizeUnit.KB.toBytes(500);  
        assertTrue(settings.contains(BlobStoreRepository.READONLY_SETTING));  
        for (int i = 0; i < numSnapshots; i++) {  
        Compressor compressor = repository.getCompressor();
        assertNotNull(stats);
 *
 * specific language governing permissions and limitations
                Settings.builder()
        Set<String> survivingIndexIds = new HashSet<>();
        assertTrue(executed1.get());
            latch.countDown();
        long maxThreshold = BlobStoreRepository.calculateMaxSnapshotRepositoryDataCacheThreshold();
import org.opensearch.core.index.Index;
        assertTrue(throttleTime >= 0);  
        final BlobStoreRepository repository = (BlobStoreRepository) repositoriesService.repository(repositoryName);
        logger.info("--> create second snapshot");
    }
        repository.close();
            pathStrategy,  
        assertEquals(5, mergedStats.get("GET").longValue());
import org.opensearch.common.settings.Setting;
        RepositoryStats stats = repoSpy.stats();
            String.valueOf(indexId.getShardPathType()),
        BlobStoreRepository repository = setupRepo();
        }, e -> {  
import org.opensearch.common.blobstore.BlobContainer;
            // Simulate the cleanup process
        String testIndexUUID = "test-idx-uuid";
            .setWaitForCompletion(true)  
    public void testGetRemoteUploadThrottleTimeInNanos() {
    }
            String id = Integer.toString(i);  
        new FsRepository(metadata, useCompressEnvironment, null, BlobStoreTestUtil.mockClusterService(), null);  
        assertEquals(shardInfo.getIndexId(), indexId);  
import java.util.ArrayList;  
        CreateSnapshotResponse createSnapshotResponse = client.admin()  
            indexUUID,  
        final RepositoriesService repositoriesService = getInstanceFromNode(RepositoriesService.class);
            null,
import org.opensearch.index.remote.RemoteStoreEnums;
        BlobStoreRepository repository = setupRepo();  
        Set<String> actualPaths = new HashSet<>(shardPathBlobs.keySet());
        Map<String, Long> mergedStats = stats.extendedStats.get(BlobStore.Metric.REQUEST_SUCCESS);
        executed1.set(false);
            "1"  
        repoData = addRandomSnapshotsToRepoData(repoData, false);
            resultReference.set(deleteResults);
            .getSnapshotIds()
        expectThrows(
        // Mock the BlobStoreRepository
    public void testCleanupStaleIndices() throws Exception {
    }
            new IOException("expected-short-circuit")
        Mockito.doReturn(blobStore).when(repoSpy).getBlobStore(false);  
        final long expectedGeneration = pendingGeneration + 1L;
        Mockito.doReturn(sseBlobStore).when(repoSpy).getBlobStore(true);  
import org.mockito.Mockito;  
        // write to and read from an index file with snapshots but no indices
        final String repositoryName = "test-repo";
import java.util.Map;
                REPO_TYPE,
import org.opensearch.snapshots.SnapshotId;
        OpenSearchIntegTestCase.putRepository(client.admin().cluster(), repositoryName, REPO_TYPE, settings);  
            ClusterService clusterService,  
            tp,  
        // Mock BlobContainer for current index  
        }
import org.opensearch.common.blobstore.DeleteResult;
        BlobStoreRepository repository = setupRepo();
        }  
        BlobStore sseBlobStore = getMockedBlobStoreWithStats(5L, 10L, false);  
        int maxSafeArraySize = Integer.MAX_VALUE - 8;
        assertNotNull(stats);  
    public void testGetStats_When_Sse_Only_Enabled_WithExtended_Stats() {
        repository.close();
            logger.error("Error in cleanupStaleIndices", e);
            captor.capture()
import org.opensearch.transport.client.Client;
        final BlobStoreRepository repository = setupRepo();
        );
/*  
        // when
import static org.mockito.ArgumentMatchers.any;  
        long throttleTime = repository.getRemoteDownloadThrottleTimeInNanos();
        final Settings settings = Settings.builder().put(node().settings()).put("location", location).build();  
import org.opensearch.repositories.RepositoryStats;
        Map<String, BlobContainer> foundIndices = new HashMap<>();  
    private BlobStore getMockedBlobStoreWithStats(long getCount, long putCount, boolean extendedStats) {
        BlobStore blobStore = Mockito.mock(BlobStore.class);  
        final String repositoryName = "test-repo";
            new IOException("expected-short-circuit")
    public void testGetCompressor() {
import static org.hamcrest.Matchers.equalTo;
        int shardCount = repoData.shardGenerations().getGens(indexId).size();  
            String.valueOf(shardCount),
        assertNotNull(stats);  
        long throttleTime = repository.getRestoreThrottleTimeInNanos();
import org.opensearch.repositories.Repository;
    }  
        assertFalse(repository.isSystemRepository());  
        final RepositoriesService repositoriesService = getInstanceFromNode(RepositoriesService.class);  
        mockSnapshotShardPaths.put(validShardPath, mock(BlobMetadata.class));
        BlobStoreRepository repository = setupRepo();
    public void testHeapThresholdUsed() {
 * compatible open source license.
        RepositoryMetadata metadata = repository.getMetadata();  
            eq(indexUUID),
import static org.mockito.ArgumentMatchers.nullable;
}
            blobStoreStatsMap.put("GET", getCount);  
        BlobStore sseBlobStore = getMockedBlobStoreWithStats(5L, 10L, true);
        for (int i = 0; i < numDocs; i++) {
            assertEquals("Index ID should match", shardInfo.getIndexId().getId(), indexId.getId());
        final Client client = client();
        final long pendingGeneration = repository.metadata.pendingGeneration();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertTrue("Cleanup did not complete within the expected time", latch.await(30, TimeUnit.SECONDS));  
        assertEquals(10, mergedStats.get("GET").longValue());
        assertTrue("All expected paths should be present", actualPaths.containsAll(expectedPaths));
        createSnapshotResponse = client.admin()  
        logger.info("-->  creating repository");
        String indexUUID = "test-uuid";
        BlobContainer staleIndexContainer = mock(BlobContainer.class);  
        // adding more and writing to a new index generational file
            snapshotIds,
            .put(node().getEnvironment().settings())
    public void testGetStats_When_Sse_not_Enabled_WithExtended_Stats() {
        assertEquals(20, mergedStats.get("PUT").longValue());
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
        assertEquals(shardInfo.getIndexId(), indexId);
     */
        repository.close();
                    protected void assertSnapshotOrGenericThread() {
import org.opensearch.common.settings.Settings;  
                indexLookup,
import static org.hamcrest.Matchers.nullValue;
            .prepareCreateSnapshot(repositoryName, "test-snap-2")
            );
 * GitHub history for details.
        assertEquals(repoData.getIndices().size(), 0);  
import java.util.concurrent.ExecutorService;
        assertThat(repository.readSnapshotIndexLatestBlob(), equalTo(expectedGeneration + 2L));  
        final BlobStoreRepository repository = setupRepo();
            eq(pathStrategy),  
 *  
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
    }
            eq(false),
        assertThat(OpenSearchBlobStoreRepositoryIntegTestCase.getRepositoryData(repository), equalTo(repositoryData));  
                snapshotId,  
    }
        final PlainActionFuture<RepositoryData> future1 = PlainActionFuture.newFuture();  
        BlobStoreRepository repoSpy = Mockito.spy(repository);  
        Mockito.doReturn(sseBlobStore).when(repoSpy).getBlobStore(true);
        verify(mockSnapshotShardPathBlobContainer, times(1)).delete();  
        BlobStoreRepository repository = setupRepo();
        Mockito.doReturn(sseBlobStore).when(repoSpy).getBlobStore(true);  
        RemoteStoreShardCleanupTask.ongoingRemoteDirectoryCleanups.add(getShardIdentifier(testIndexUUID, "0"));  
            assertEquals(
        remoteStoreShardCleanupTask.run();
        RemoteStoreShardCleanupTask.ongoingRemoteDirectoryCleanups.add(getShardIdentifier(testIndexUUID, "1"));
        long expectedThreshold = calculateMaxWithinIntLimit(defaultThresholdOfHeap, defaultAbsoluteThreshold);  
    public static class FsLikeRepoPlugin extends Plugin implements RepositoryPlugin {  
        when(factory.newDirectory(anyString(), anyString(), any(), any(), nullable(String.class), eq(false), eq(false), any())).thenThrow(
        }
package org.opensearch.repositories.blobstore;
            false,
        BlobStoreRepository repository = setupRepo();
    }
        ) {
import org.opensearch.repositories.RepositoriesService;
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
            .put("chunk_size", randomLongBetween(-10, 0), ByteSizeUnit.BYTES);  
        assertEquals(OpenSearchBlobStoreRepositoryIntegTestCase.getRepositoryData(repository), RepositoryData.EMPTY);
        RemoteStorePathStrategy pathStrategy = new RemoteStorePathStrategy(RemoteStoreEnums.PathType.FIXED);
    }  
        // N+1 generation from which this repository data instance was created
            factory,  
        return repository;
    }
        repository.close();
        repository.close();
        writeIndexGen(repository, repoData, repoData.getGenId());
        // Check if there are any unexpected additional paths
                }
        assertThat(snapshotIds, equalTo(originalSnapshots));  
import org.opensearch.index.store.lockmanager.RemoteStoreLockManagerFactory;
        BlobStoreRepository repository = setupRepo();  
        final Path location = OpenSearchIntegTestCase.randomRepoPath(node().settings());
/**  
    public void testBadChunksize() throws Exception {
            assertEquals("Shard path type should match", shardInfo.getIndexId().getShardPathType(), indexId.getShardPathType());  
            Map<String, BlobContainer> indices = invocation.getArgument(1);
import org.opensearch.action.support.PlainActionFuture;
    public void testGetStats_When_Sse_Only_Enabled() {
    }
        BlobStoreRepository repoSpy = Mockito.spy(repository);
        verify(currentIndexContainer, never()).delete();  
    }
            .setWaitForCompletion(true)  
        // given  
        // when
        assertNotNull("DeleteResult collection should not be null", results);  
import java.util.concurrent.atomic.AtomicBoolean;  
            mockRemoteStoreLockManagerFactory,
        assertEquals(metadata.name(), "test-repo");
            .put(BlobStoreRepository.PREFIX_MODE_VERIFICATION_SETTING.getKey(), true);
        BlobStore blobStore = getMockedBlobStoreWithStats(10L, 20L, false);
        assertEquals(defaultThresholdOfHeap, expectedThreshold);
 * Modifications Copyright OpenSearch Contributors. See
            .cluster()
import org.opensearch.cluster.metadata.RepositoryMetadata;  
 * You may obtain a copy of the License at  
        // Create a mock RemoteStoreLockManagerFactory
        // then
        shardPath = String.join(
                shardGenerations,  
 */  
            blobStoreStatsMap.put("PUT", putCount);
import org.opensearch.common.blobstore.BlobStore;  
import org.opensearch.repositories.RepositoryData;  
            SnapshotShardPaths.DELIMITER,
    public void testThresholdCappedAtIntMax() {
    }  
        // Scenario 1: ongoing = false => executed
        // Create sets for comparison  
        );
            "repo",
        foundIndices.put("current-index", currentIndexContainer);
        survivingIndexIds.add("current-index");  
    }  
import org.opensearch.core.compress.Compressor;
        writeIndexGen(repository, repositoryData, RepositoryData.EMPTY_REPO_GEN);
import org.opensearch.common.UUIDs;  
        assertEquals(OpenSearchBlobStoreRepositoryIntegTestCase.getRepositoryData(repository), repositoryData);
import org.opensearch.cluster.service.ClusterService;
        final BlobStoreRepository repository = setupRepo();
        assertNotNull(stats);  
        repository.cleanupStaleIndices(  
        // Mock BlobContainer for stale index
    }
        repository.close();
        assertFalse("DeleteResult collection should not be empty", results.isEmpty());
            eq(pathStrategy),
        return blobStore;
    public void testGetRestoreThrottleTimeInNanos() {  
                randomFrom(SnapshotState.SUCCESS, SnapshotState.PARTIAL, SnapshotState.FAILED),
            RepositoryException.class,
        RepositoryData repositoryData = generateRandomRepoData();
            return null;  
 * Licensed to Elasticsearch under one or more contributor  
        snapshotIds.add(new SnapshotId("snap2", UUIDs.randomBase64UUID()));  
        );
            listener.onResponse(result);
        // Verify that the stale index was processed for deletion
        Mockito.doReturn(blobStore).when(repoSpy).getBlobStore(false);
        List<SnapshotId> snapshotIds = OpenSearchBlobStoreRepositoryIntegTestCase.getRepositoryData(repository)
        long result = calculateMaxWithinIntLimit(defaultThresholdOfHeap, defaultAbsoluteThreshold);
        RepositoryData repoData = generateRandomRepoData();
    }  
import static org.mockito.ArgumentMatchers.anyString;
        // factory.newDirectory throws IOException to short-circuit; we only care about the args passed
        // Verify the total number of bytes and blobs deleted
        ArgumentCaptor<IndexSettings> captor = ArgumentCaptor.forClass(IndexSettings.class);
        assertEquals(repoData, OpenSearchBlobStoreRepositoryIntegTestCase.getRepositoryData(repository));
import org.opensearch.index.store.RemoteSegmentStoreDirectoryFactory;  
    }
        // when
        } else {
        OpenSearchIntegTestCase.putRepository(client.admin().cluster(), repositoryName, REPO_TYPE, settings);
 * ownership. Elasticsearch licenses this file to you under  
        assertTrue(settings.contains(BlobStoreRepository.SYSTEM_REPOSITORY_SETTING));
            final ShardGenerations.Builder builder = ShardGenerations.builder();  
        BlobStoreRepository repository = setupRepo();
        assertEquals(15, mergedStats.get("GET").longValue());
                    .put(IndexMetadata.SETTING_INDEX_UUID, indexUUID)
        }), 1);  
        BlobStoreRepository repository = setupRepo();
        long defaultThresholdOfHeap = (long) maxSafeArraySize + 1;
import org.opensearch.plugins.RepositoryPlugin;
        BlobStore sseBlobStore = getMockedBlobStoreWithStats(5L, 10L, true);  
        ShardId shardId = new ShardId(new Index(indexName, testIndexUUID), 0);
            repositoryData,  
            .collect(Collectors.toList());
    /**  
        AtomicReference<Collection<DeleteResult>> resultReference = new AtomicReference<>();  
        // Mock snapshotShardPathBlobContainer  
        assertFalse(repository.isReadOnly());  
                    @Override  
        BlobStoreRepository repository = setupRepo();  
        // Case (b): null IndexMetadata propagated as null
    }
import static org.mockito.Mockito.verify;  
            .put("location", location)
            RepositoryException.class,  
    public void testGetStats() {  
        assertEquals(OpenSearchBlobStoreRepositoryIntegTestCase.getRepositoryData(repository), repositoryData);
    public void testReadAndWriteSnapshotsThroughIndexFile() throws Exception {  
            eq("repo"),  
    public void testGetNamedXContentRegistry() {
    }  
        return Arrays.asList(FsLikeRepoPlugin.class);
        assertTrue(throttleTime >= 0);
            latch.countDown();
        writeIndexGen(repository, repositoryData, repositoryData.getGenId());
        // write to index generational file  
        BlobStoreRepository repository = setupRepo();
            indexId.getName(),
        Set<String> unexpectedPaths = new HashSet<>(actualPaths);
        assertFalse(stats.detailed);
        final BlobStoreRepository repository = (BlobStoreRepository) repositoriesService.repository(repositoryName);  
            eq(shardId),  
            null
import static org.mockito.Mockito.when;
        RepositoryStats stats = repoSpy.stats();  
        verify(staleIndexContainer, times(1)).delete();  
            .get();
            .get();
        client().admin().indices().prepareFlush(indexName).get();  
        final SnapshotId snapshotId2 = createSnapshotResponse.getSnapshotInfo().snapshotId();  
        logger.info("--> create first snapshot");
 * Tests for the {@link BlobStoreRepository} and its subclasses.
        BlobContainer currentIndexContainer = mock(BlobContainer.class);
    }  
        for (IndexId indexId : repoData.getIndices().values()) {
    }  
import org.opensearch.core.xcontent.NamedXContentRegistry;
import java.util.concurrent.atomic.AtomicReference;
    public void testAbsoluteThresholdUsed() {
    static final String REPO_TYPE = "fsLike";
        when(factory.newDirectory(anyString(), anyString(), any(), any(), nullable(String.class), eq(false), eq(false), any())).thenThrow(  
        ThreadPool tp = mock(ThreadPool.class);
    }  
            );  
        ExecutorService directExecutor = OpenSearchExecutors.newDirectExecutorService();
        assertTrue(throttleTime >= 0);
        assertEquals(repoData, OpenSearchBlobStoreRepositoryIntegTestCase.getRepositoryData(repository));  
        repository.close();  
        final String repositoryName = "test-repo";  
        RemoteSegmentStoreDirectoryFactory mockRemoteSegmentStoreDirectoryFactory = mock(RemoteSegmentStoreDirectoryFactory.class);  
        when(repository.snapshotShardPathBlobContainer()).thenReturn(mockSnapshotShardPathBlobContainer);  
import static org.mockito.ArgumentMatchers.anyMap;
        RepositoryStats stats = repoSpy.stats();  
 */
import java.util.Collections;  
 * Unless required by applicable law or agreed to in writing,
        assertNotNull(compressor);
            NamedXContentRegistry namedXContentRegistry,
    public void testParseShardPath() {  
        assertTrue(repository.getPrefixModeVerification());
                .stream()  
            }
        final Path location = OpenSearchIntegTestCase.randomRepoPath(node().settings());  
        // write to index generational file  
            if (indexId.getShardPathType() != IndexId.DEFAULT_SHARD_PATH_TYPE) {  
            assertNotNull("IndexId should not be null", indexId);
        ensureGreen();  
            Mockito.when(blobStore.stats()).thenReturn(blobStoreStatsMap);  
        assertThat(repository.latestIndexBlobId(), equalTo(expectedGeneration + 1L));  
            .put(node().settings())  
        BlobStoreRepository repository = setupRepo();
        // given  
        BlobStoreRepository repoSpy = Mockito.spy(repository);  
 */
            }  
        final long startingGeneration = repositoryData.getGenId();
        Mockito.doReturn(blobStore).when(repoSpy).getBlobStore(false);
    public void testIndexGenerationalFiles() throws Exception {  
        assertNotNull(metadata);
            blobStoreStatsMap.put("requests_count", getCount + putCount);
        GroupedActionListener<DeleteResult> listener = new GroupedActionListener<>(ActionListener.wrap(deleteResults -> {  
            eq(false),  
                RemoteStoreEnums.PathHashAlgorithm.fromCode(Integer.parseInt(parts[4]))
        BlobStore sseBlobStore = getMockedBlobStoreWithStats(5L, 10L, false);  
            GroupedActionListener<DeleteResult> listener = invocation.getArgument(6);  
        // then
            .setIndices(indexName)
        final Client client = client();
            .build();
                builder.put(new IndexId(randomAlphaOfLength(8), UUIDs.randomBase64UUID()), 0, "1");
                        // eliminate thread name check as we access blobStore on test/main threads
        assertEquals(15, stats.requestCounts.get("requests_count").longValue());
import static org.opensearch.repositories.blobstore.BlobStoreRepository.calculateMaxWithinIntLimit;  
        assertThat(repository.latestIndexBlobId(), equalTo(expectedGeneration));
import org.opensearch.cluster.metadata.IndexMetadata;
            final Map<IndexId, String> indexLookup = shardGenerations.indices()
import java.util.stream.Collectors;  
import java.io.IOException;
    public void testFsRepositoryCompressDeprecatedIgnored() {
        snapshotIds.add(new SnapshotId("snap1", UUIDs.randomBase64UUID()));
     * Guards against regressions where IndexMetadata is dropped or replaced with null during cleanup.
            mockSnapshotShardPaths,
        long defaultAbsoluteThreshold = ByteSizeUnit.KB.toBytes(500);
            .settings(
        assertNotNull(settings);
        verify(factory).newDirectory(
        final Client client = client();  
        );
        BlobStore blobStore = getMockedBlobStoreWithStats(10L, 20L, true);
        long defaultThresholdOfHeap = ByteSizeUnit.KB.toBytes(499);
            survivingIndexIds,  
        writeIndexGen(repository, repoData, repoData.getGenId());  
        );
        // given  
        assertThat(repository.readSnapshotIndexLatestBlob(), equalTo(expectedGeneration));  
        // then
import static org.opensearch.repositories.RepositoryDataTests.generateRandomRepoData;
        Collection<DeleteResult> results = resultReference.get();
    }
    public void testRemoteStoreShardCleanupTask() {  
        // Version 2.17 has file name starting with snapshot_path_  
        BlobStoreRepository.remoteDirectoryCleanupAsync(
 * this work for additional information regarding copyright
        OpenSearchIntegTestCase.putRepository(client.admin().cluster(), repositoryName, REPO_TYPE, settings);
        assertEquals(30, stats.requestCounts.get("requests_count").longValue());
import org.opensearch.env.Environment;
/*
        assertTrue(throttleTime >= 0);
import org.opensearch.repositories.IndexId;  
        Runnable task1 = () -> executed1.set(true);
        remoteStoreShardCleanupTask.run();
        logger.info("--> creating an index and indexing documents");  
import org.opensearch.index.remote.RemoteStorePathStrategy;
        RepositoryData repoData = generateRandomRepoData();
 * The OpenSearch Contributors require contributions made to  
        repository.close();
            final ShardGenerations shardGenerations = builder.build();
            SnapshotShardPaths.DELIMITER,
        when(mockRemoteStoreLockManagerFactory.newLockManager(anyString(), anyString(), anyString(), any())).thenReturn(mockLockManager);
     * {@link IndexMetadata} argument through to {@code RemoteSegmentStoreDirectory.remoteDirectoryCleanup},
        BlobStore blobStore = getMockedBlobStoreWithStats(10L, 20L, true);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.Version;
        final String indexName = "test-idx";
        RepositoryStats stats = repoSpy.stats();
        verify(factory).newDirectory(  
        assertEquals("Total blobs deleted should be 2", 2, combinedResult.blobsDeleted());
        assertEquals(10, mergedStats.get("PUT").longValue());
        BlobStoreRepository repoSpy = Mockito.spy(repository);  
        BlobStoreRepository repository = setupRepo();
            SnapshotShardPaths.FILE_PREFIX + indexId.getId(),  
        for (String shardPathBlobName : expectedPaths) {
        final String repositoryName = "test-repo";
        repository.close();
    public void testWriteAndReadShardPaths() throws Exception {
            ThreadPool.Names.REMOTE_PURGE,
                (metadata) -> new FsRepository(metadata, env, namedXContentRegistry, clusterService, recoverySettings) {
        Map<String, Long> mergedStats = stats.extendedStats.get(BlobStore.Metric.REQUEST_SUCCESS);
            );  
        // Verify that snapshot shard paths were considered in the cleanup process
            indexMetadata
            (IndexSettings) eq(null)
        // when
        assertFalse(stats.detailed);
        BlobStoreRepository repoSpy = Mockito.spy(repository);  
            .setIndices(indexName)
        String validShardPath = "stale-index-id#stale-index#1#0#1";  
            Mockito.when(blobStore.extendedStats()).thenReturn(blobStoreMetricMap);  
        Settings.Builder settings = Settings.builder()  
import java.util.function.Function;
        assertNotNull(stats);
    }
        // Remove known extra files - "extra0" file is added by the ExtrasFS, which is part of Lucene's test framework
        remoteStoreShardCleanupTask = new RemoteStoreShardCleanupTask(task1, testIndexUUID, shardId);
        long throttleTime = repository.getSnapshotThrottleTimeInNanos();
        HashMap<String, Long> blobStoreStatsMap = new HashMap<>();
        Settings.Builder settings = Settings.builder().put(node().settings()).put("location", location);
import java.util.Arrays;
        return repoData;
        );  
        );
        doAnswer(invocation -> {  
            factory,
     * Verifies that {@code BlobStoreRepository.remoteDirectoryCleanupAsync} propagates the
import org.opensearch.core.action.ActionListener;
                if (!surviving.contains(entry.getKey())) {
        // Version 2.17 has file name starting with indexId
        assertThat("getBlobContainer has to be lazy initialized", repository.getBlobContainer(), nullValue());  
        long expectedThreshold = calculateMaxWithinIntLimit(defaultThresholdOfHeap, defaultAbsoluteThreshold);
        RemoteStoreLockManagerFactory mockRemoteStoreLockManagerFactory = mock(RemoteStoreLockManagerFactory.class);
        String indexName = "test-idx";  
        createIndex(indexName);
    public void testGetStats_When_Sse_Enabled_WithExtended_Stats() {
    public void testIsSystemRepository() {
            indexId.getId(),
 *    http://www.apache.org/licenses/LICENSE-2.0
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
    public void testIsReadOnly() {
        assertEquals("Total bytes deleted should be 150", 150L, combinedResult.bytesDeleted());  
            .prepareCreateSnapshot(repositoryName, "test-snap-1")
import org.opensearch.index.IndexSettings;  
            DeleteResult result = DeleteResult.ZERO;  
            shardId,  
        repositoryData = OpenSearchBlobStoreRepositoryIntegTestCase.getRepositoryData(repository)
        BlobStoreRepository repository = setupRepo();
        writeIndexGen(repository, emptyData, emptyData.getGenId());  
import org.opensearch.repositories.RepositoryException;
 * SPDX-License-Identifier: Apache-2.0
    public void testGetMetadata() {
    }
        // just adding random shards in ongoing cleanups.
        Set<String> writtenShardPaths = new HashSet<>();
        int numDocs = randomIntBetween(10, 20);
     * which in turn passes it as an {@link IndexSettings} to the factory's 8-arg {@code newDirectory}.  
        BlobStoreRepository repository = setupRepo();
public class BlobStoreRepositoryTests extends BlobStoreRepositoryHelperTests {  
        DeleteResult combinedResult = results.stream().reduce(DeleteResult.ZERO, DeleteResult::add);  
        assertTrue("Blobs deleted should be greater than 0", combinedResult.blobsDeleted() > 0);  
    public void testGetStats_When_Sse_Enabled() {
    public void testGetRestrictedSystemRepositorySettings() {
    private String getShardIdentifier(String indexUUID, String shardId) {
        long defaultAbsoluteThreshold = ByteSizeUnit.KB.toBytes(500);
        IndexMetadata indexMetadata = IndexMetadata.builder("idx")  
        // Check if all expected paths are present in the actual paths
    private static void writeIndexGen(BlobStoreRepository repository, RepositoryData repositoryData, long generation) throws Exception {
                indexLookup.values().stream().collect(Collectors.toMap(Function.identity(), ignored -> UUIDs.randomBase64UUID(random())))
        final RepositoryMetadata metadata = new RepositoryMetadata("test-repo", REPO_TYPE, settings);
        );
    private RepositoryData addRandomSnapshotsToRepoData(RepositoryData repoData, boolean inclIndices) {
