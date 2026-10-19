        );
    public static void assertRepoConsistency(InternalTestCluster testCluster, String repoName) {  
import java.util.concurrent.ExecutionException;  
        Map<String, BlobMetadata> foundBlobs = future.actionGet();  
        final BlobStoreRepository repo = (BlobStoreRepository) testCluster.getCurrentClusterManagerNodeInstance(RepositoriesService.class)
        return mockClusterService(  
        final BlobContainer repoRoot = repository.blobContainer();  
                            assertThat(
import org.opensearch.core.xcontent.NamedXContentRegistry;
                    final int shardId = Integer.parseInt(entry.getKey());  
                lessThanOrEqualTo(maxShardCountsExpected.get(indexId))  
                    .filter(p -> p.startsWith(prefix))  
                    if (shardContainer.listBlobs().keySet().stream().anyMatch(blob -> blob.startsWith("extra") == false)) {  
import org.opensearch.Version;
            foundIndexUUIDs = Collections.emptyList();  
                    InputStream blob = blobContainer.readBlob(BlobStoreRepository.INDEX_FILE_PREFIX + latestGen);
                        InputStream ignored = blobStore.blobContainer(repository.basePath().add("indices").add(index)).readBlob(file)
                    if (entry.getKey().startsWith("extra")) {  
                        indexId,  
 * compatible open source license.
                }  
            }
import org.opensearch.cluster.ClusterState;
            final BlobContainer shardContainer = repository.shardContainer(indexId, i);  
     * @return Mock ClusterService  
 * not use this file except in compliance with the License.
            appliers.forEach(
                    try (
        assertEquals(latestGen, indexGenerations[indexGenerations.length - 1]);
            final Set<String> indexMetaGenerationsFound = indicesContainer.children()
            final BlobStore blobStore = repository.blobStore();
            }
            .generic()
    /**  
            currentState.set(next);  
            .repository(repoName);
                                )
            .toArray();
                .collect(Collectors.toList());
                    final String generation = gens.get(i);
        final List<String> expectedIndexUUIDs = repositoryData.getIndices()
import java.util.Set;
            // TODO: assertEquals(indexMetaGenerationsExpected, indexMetaGenerationsFound); requires cleanup functionality for
                        );  
                .stream()  
import org.opensearch.repositories.RepositoryData;  
            ClusterState.builder(ClusterState.EMPTY_STATE)
            shardContainers.put(String.valueOf(i), shardContainer);
                    throw new AssertionError("Could not find index.latest blob for repo [" + repository + "]");
            for (String file : files) {  
                ) {
        if (blobs.isEmpty()) {
import java.io.DataInputStream;
                final RepositoryData repositoryData;
     * that contains the given {@code metadata}.  
        return clusterService;  
            // index meta generations blobs  
            .map(s -> s.replace(BlobStoreRepository.INDEX_FILE_PREFIX, ""))
            BlobContainer container = blobStore.blobContainer(repository.basePath().add("indices").add(name));
                count,
                                    .stream()  
    /**  
                            BlobStoreRepository.METADATA_NAME_FORMAT,
 *    http://www.apache.org/licenses/LICENSE-2.0
                    if (shardId < shardCount
            appliers.add((ClusterStateApplier) invocation.getArguments()[0]);
    }  
            for (SnapshotId snapshotId : repositoryData.getSnapshots(idx)) {
        // Setting local node as cluster-manager so it may update the repository metadata in the cluster state  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                            hasKey(BlobStoreRepository.INDEX_FILE_PREFIX + generation)
import static org.mockito.Mockito.when;
                for (String file : indexToFiles.get(index)) {  
 * You may obtain a copy of the License at  
                    indexContainer.listBlobs(),  
    }  
        }
        final PlainActionFuture<AssertionError> listener = PlainActionFuture.newFuture();  
                .build()
        repository.threadPool().generic().execute(ActionRunnable.run(future, () -> {  
                    Metadata.builder()  
     * functionality to make {@link BlobStoreRepository} work. Initializes the cluster state as {@link ClusterState#EMPTY_STATE}.
import static org.mockito.Mockito.any;
import org.opensearch.common.blobstore.BlobStore;
        int shardCount = repositoryData.shardGenerations().getGens(indexId).size();
    }
        final BlobContainer indicesContainer = repository.getBlobContainer().children().get("indices");
        doAnswer(invocation -> {
            .stream()  
                            .noneMatch(shardFailure -> shardFailure.index().equals(index) && shardFailure.shardId() == shardId)) {
        }
                assertIndexGenerations(blobContainer, latestGen);
 * license agreements. See the NOTICE file distributed with
                .nodes(
                        );
import java.util.Locale;
            if (gens.isEmpty() == false) {
            foundIndexUUIDs = indicesContainer.children()  
                            assertTrue(
            task.clusterStateProcessed((String) invocation.getArguments()[0], current, next);
                        if (snapshotInfo.getPinnedTimestamp() == 0) {  
                assertThat(indices, hasKey(indexId.getId()));  
 *
            }
            final SnapshotInfo snapshotInfo = repository.getSnapshotInfo(snapshotId);  
            foundSnapshotUUIDs.addAll(
 * this file be licensed under the Apache-2.0 license or a
                assertSnapshotUUIDs(repository, repositoryData);
                )  
            ((indexId, count) -> assertThat(  
        future.get();  
                    }
                    final int shardCount = indexMetadata.getNumberOfShards();
import org.opensearch.cluster.metadata.RepositoriesMetadata;
import org.opensearch.threadpool.ThreadPool;
                                    || shardPathContents.containsKey(
/*
                } catch (NoSuchFileException e) {
        final long[] indexGenerations = repoRoot.listBlobsByPrefix(BlobStoreRepository.INDEX_FILE_PREFIX)
        return totalSize.get();
import org.opensearch.repositories.RepositoriesService;
                        (i, existing) -> existing == null || existing < shardCount ? shardCount : existing
import org.opensearch.cluster.ClusterStateApplier;  
            throw new AssertionError(err);
                        final int impliedCount = shardId - 1;
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
import java.util.Collections;
                final BlobContainer blobContainer = repository.blobContainer();  
        }));
                    // Skip Lucene MockFS extraN directory
        when(clusterService.getClusterApplierService()).thenReturn(clusterApplierService);
                                    .filter(name -> name.startsWith(BlobStoreRepository.INDEX_FILE_PREFIX))
        if (indicesContainer == null) {  
            }  
                                lessThanOrEqualTo(2L)  
    }
                            );
        BlobStoreRepository repository,  
                .map(p -> p.replace(BlobStoreRepository.METADATA_PREFIX, "").replace(".dat", ""))
                final Map<String, BlobContainer> shardContainers = getShardContainers(index, repository, repositoryData);
 * The OpenSearch Contributors require contributions made to  
        final ClusterService clusterService = mock(ClusterService.class);  
            return true;
                indexMetaGenerationsExpected.add(repositoryData.indexMetaDataGenerations().indexMetaBlobId(snapshotId, idx));  
import org.opensearch.action.ActionRunnable;
        return mockClusterService(ClusterState.EMPTY_STATE);  
                        maxShardCountsSeen.compute(
 * Unless required by applicable law or agreed to in writing,
    }
                    // becomes unreferenced. We should fix that and remove this conditional once its fixed.
                    }  
            .values()
        final PlainActionFuture<Void> future = PlainActionFuture.newFuture();
        }
            .collect(Collectors.toList());
import java.util.Collection;  
                        .putCustom(RepositoriesMetadata.TYPE, new RepositoriesMetadata(Collections.singletonList(metadata)))
                            (i, existing) -> existing == null || existing < impliedCount ? impliedCount : existing
package org.opensearch.repositories.blobstore;
 */
        }
            .sorted()  
import org.opensearch.cluster.node.DiscoveryNodes;
 *  
    }
                                    .count(),
        BlobStoreTestUtil.assertConsistency(repo, repo.threadPool().executor(ThreadPool.Names.GENERIC));  
import java.util.Map;  
        final List<ClusterStateApplier> appliers = new CopyOnWriteArrayList<>();
                    hasKey(
import org.opensearch.cluster.metadata.RepositoryMetadata;
import org.opensearch.cluster.node.DiscoveryNode;  
                        .build()
        executor.execute(ActionRunnable.supply(listener, () -> {
            assertTrue(indexMetaGenerationsFound.containsAll(indexMetaGenerationsExpected));
        when(threadPool.executor(ThreadPool.Names.SNAPSHOT)).thenReturn(new SameThreadExecutorService());
            for (String index : snapshotInfo.indices()) {
     * functionality to make {@link BlobStoreRepository} work. Initializes the cluster state with a {@link RepositoriesMetadata} instance
    public static ClusterService mockClusterService(RepositoryMetadata metadata) {
                .listBlobsByPrefix(BlobStoreRepository.METADATA_PREFIX)
        Collection<String> foundSnapshotUUIDs = new HashSet<>();  
import java.util.List;
 *
                for (int i = 0; i < gens.size(); i++) {  
        } else {
import java.util.concurrent.atomic.AtomicReference;  
                        final String shardId = Integer.toString(i);
                        continue;
        final AtomicLong totalSize = new AtomicLong();
    }
    }
        }).when(clusterService).submitStateUpdateTask(anyString(), any(ClusterStateUpdateTask.class));  
 * this work for additional information regarding copyright
                                shardPathContents.containsKey(
import static org.junit.Assert.assertTrue;  
import java.util.stream.Collectors;
    public static void assertCorruptionVisible(BlobStoreRepository repository, Map<String, Set<String>> indexToFiles) {
                for (Map.Entry<String, BlobContainer> entry : indexContainer.children().entrySet()) {
                assertShardIndexGenerations(repository, repositoryData);  
            final ClusterState current = currentState.get();
                        assertThat(shardContainers, hasKey(shardId));
            indices = Collections.emptyMap();
            }  
import java.io.ByteArrayInputStream;
import org.opensearch.cluster.metadata.Metadata;  
                }  
                                        String.format(Locale.ROOT, BlobStoreRepository.SNAPSHOT_NAME_FORMAT, snapshotId.getUUID())  
import java.util.concurrent.atomic.AtomicLong;
        }
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
    /**
     * Creates a mocked {@link ClusterService} for use in {@link BlobStoreRepository} related tests that mocks out all the necessary  
        when(clusterApplierService.threadPool()).thenReturn(threadPool);
        }).when(clusterService).addStateApplier(any(ClusterStateApplier.class));
                    ) {} catch (NoSuchFileException e) {  
                applier -> applier.applyClusterState(new ClusterChangedEvent((String) invocation.getArguments()[0], next, current))
                )  
                }
import java.util.HashMap;
                        assertThat(  
                return null;
        final AtomicReference<ClusterState> currentState = new AtomicReference<>(
 * the Apache License, Version 2.0 (the "License"); you may
        for (IndexId index : shardGenerations.indices()) {
        final Map<IndexId, Integer> maxShardCountsSeen = new HashMap<>();  
        IndexId indexId,
        final AssertionError err = listener.actionGet(TimeValue.timeValueMinutes(1L));  
                        String.format(
    public static void assertBlobsByPrefix(BlobStoreRepository repository, BlobPath path, String prefix, Map<String, BlobMetadata> blobs) {
        maxShardCountsSeen.forEach(
        assertTrue(future.actionGet());
    public static void assertConsistency(BlobStoreRepository repository, Executor executor) {
        final PlainActionFuture<Boolean> future = PlainActionFuture.newFuture();
 * GitHub history for details.
import java.util.concurrent.CopyOnWriteArrayList;
        when(clusterService.state()).then(invocationOnMock -> currentState.get());  
        final PlainActionFuture<Map<String, BlobMetadata>> future = PlainActionFuture.newFuture();
                    DiscoveryNodes.builder().add(localNode).clusterManagerNodeId(localNode.getId()).localNodeId(localNode.getId()).build()
            for (Map.Entry<String, BlobMetadata> entry : foundBlobs.entrySet()) {
                .filter(s -> s.startsWith("extra") == false)  
                try (  
                repoRoot.listBlobs()  
        );
import org.opensearch.common.settings.Settings;  
                final long latestGen;
        when(clusterService.getSettings()).thenReturn(Settings.EMPTY);  
            assertThat(foundBlobs.keySet(), empty());
import java.util.HashSet;  
        final ShardGenerations shardGenerations = repositoryData.shardGenerations();
public final class BlobStoreTestUtil {
        );
        ExecutionException {  
                assertEquals(entry.getValue().length(), blobs.get(entry.getKey()).length());  
    private static void assertIndexUUIDs(BlobStoreRepository repository, RepositoryData repositoryData) throws IOException {  
                final BlobContainer indexContainer = indices.get(indexId.getId());
     * @return Mock ClusterService  
                    return false;
import static org.hamcrest.Matchers.empty;  
        assertThat(foundIndexUUIDs, containsInAnyOrder(expectedIndexUUIDs.toArray(Strings.EMPTY_ARRAY)));  
        }  
                final IndexId indexId = repositoryData.resolveIndexId(index);
import static org.mockito.Mockito.mock;
     */
                    }
                                    )
import org.opensearch.cluster.ClusterChangedEvent;
                }
            ))
        final ThreadPool threadPool = mock(ThreadPool.class);  
     * TODO: Expand the logic here to also check for unreferenced segment blobs and shard level metadata
    public static long createDanglingIndex(BlobStoreRepository repository, String name, Set<String> files) throws InterruptedException,
import static org.opensearch.test.OpenSearchTestCase.randomIntBetween;
import org.opensearch.common.blobstore.BlobPath;  
        if (indicesContainer == null) {
                        )  
        }
import org.opensearch.test.InternalTestCluster;
        // Assert that for each snapshot, the relevant metadata was written to index and shard folders
                            repositoryData.indexMetaDataGenerations().indexMetaBlobId(snapshotId, indexId)
        for (int i = 0; i < shardCount; i++) {
                container.writeBlob(file, new ByteArrayInputStream(new byte[size]), size, false);  
        }));
import org.opensearch.common.blobstore.BlobMetadata;
     */
    private static void assertShardIndexGenerations(BlobStoreRepository repository, RepositoryData repositoryData) throws IOException {  
                    assertThat(generation, not(ShardGenerations.DELETED_SHARD_GEN));
        return shardContainers;  
        if (err != null) {
import java.util.concurrent.Executor;
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
                        final Map<String, BlobMetadata> shardPathContents = shardContainer.listBlobs();
                    XContentParser parser = MediaTypeRegistry.JSON.xContent()
            final BlobStore blobStore = repository.blobStore();
     * @param metadata RepositoryMetadata to initialize the cluster state with
                    final BlobContainer shardContainer = entry.getValue();  
                        .createParser(NamedXContentRegistry.EMPTY, LoggingDeprecationHandler.INSTANCE, blob)  
        final Map<String, BlobContainer> shardContainers = new HashMap<>();  
    private static void assertSnapshotUUIDs(BlobStoreRepository repository, RepositoryData repositoryData) throws IOException {
 * Modifications Copyright OpenSearch Contributors. See  
     *                 implementations assert that all IO inducing calls happen on the generic or snapshot thread-pools and hence callers
    ) {
            indices = indicesContainer.children();  
        }
import org.apache.lucene.util.SameThreadExecutorService;  
                            Locale.ROOT,  
                return e;  
     */
import org.opensearch.cluster.service.ClusterService;  
 * specific language governing permissions and limitations
        repository.threadPool()  
            final ClusterState next = task.execute(current);
 * Licensed to Elasticsearch under one or more contributor  
                    }
        }));  
        repository.threadPool().generic().execute(ActionRunnable.supply(future, () -> {  
                    latestGen = inputStream.readLong();  
        } else {  
            final Set<String> indexMetaGenerationsExpected = new HashSet<>();  
                .metadata(
import org.opensearch.common.blobstore.BlobContainer;
 * software distributed under the License is distributed on an
                            shardContainers.get(shardId).listBlobsByPrefix(BlobStoreRepository.INDEX_FILE_PREFIX),
                    )
import java.nio.file.NoSuchFileException;
        doAnswer(invocation -> {
import org.opensearch.repositories.ShardGenerations;
            assertThat(foundBlobs.keySet(), containsInAnyOrder(blobs.keySet().toArray(Strings.EMPTY_ARRAY)));
                }  
                .keySet()
            new ThreadPool.Info(ThreadPool.Names.SNAPSHOT, ThreadPool.ThreadPoolType.FIXED, randomIntBetween(1, 10))
                            );
                assertThat(
                "Found unreferenced shard paths for index [" + indexId + "]",
import static org.opensearch.test.OpenSearchTestCase.buildNewFakeTransportAddress;  
     * Assert that there are no unreferenced indices or unreferenced root-level metadata blobs in any repository.
    private static void assertIndexGenerations(BlobContainer repoRoot, long latestGen) throws IOException {  
            // Skip Lucene MockFS extraN directory
                int size = randomIntBetween(0, 10);
    }
            .map(IndexId::getId)
                    .keySet()
                        return false;
                    .collect(Collectors.toSet())
import static org.mockito.Mockito.anyString;
        } else {
     * Creates a mocked {@link ClusterService} for use in {@link BlobStoreRepository} related tests that mocks out all the necessary
            .keySet()
import org.opensearch.action.support.PlainActionFuture;  
        );
            return null;  
            }
        when(threadPool.generic()).thenReturn(new SameThreadExecutorService());
                    .map(p -> p.replace(prefix, "").replace(".dat", ""))
        final Collection<SnapshotId> snapshotIds = repositoryData.getSnapshotIds();
            return null;
        }
     *                 of this assertion must pass an executor on those when using such an implementation.  
import static org.hamcrest.Matchers.containsInAnyOrder;
                );
import static org.junit.Assert.assertEquals;
/*
 */
        for (SnapshotId snapshotId : snapshotIds) {
    }  
/*  
            final List<String> gens = shardGenerations.getGens(index);  
                    // TODO: we shouldn't be leaking empty shard directories when a shard (but not all of the index it belongs to)
    private static ClusterService mockClusterService(ClusterState initialState) {
import java.io.InputStream;
                try (DataInputStream inputStream = new DataInputStream(blobContainer.readBlob("index.latest"))) {
import org.opensearch.snapshots.SnapshotId;
 * KIND, either express or implied.  See the License for the
     *
            }
    private static Map<String, BlobContainer> getShardContainers(
    }
    public static ClusterService mockClusterService() {
import org.opensearch.snapshots.SnapshotInfo;  
     * @param repository BlobStoreRepository to check  
        for (String prefix : new String[] { BlobStoreRepository.SNAPSHOT_PREFIX, BlobStoreRepository.SHALLOW_SNAPSHOT_PREFIX }) {
                final IndexMetadata indexMetadata = repository.getSnapshotIndexMetaData(repositoryData, snapshotId, indexId);  
            .stream()  
                assertIndexUUIDs(repository, repositoryData);
import static org.hamcrest.Matchers.not;  
        final List<String> expectedSnapshotUUIDs = snapshotIds.stream().map(SnapshotId::getUUID).collect(Collectors.toList());
        final DiscoveryNode localNode = new DiscoveryNode("", buildNewFakeTransportAddress(), Version.CURRENT);
                    .stream()
        when(threadPool.info(ThreadPool.Names.SNAPSHOT)).thenReturn(  
                .stream()
 * SPDX-License-Identifier: Apache-2.0
                if (blobStore.blobContainer(repository.basePath().add("indices")).children().containsKey(index) == false) {  
 * ownership. Elasticsearch licenses this file to you under  
        final List<String> foundIndexUUIDs;
}
                                    String.format(Locale.ROOT, BlobStoreRepository.SHALLOW_SNAPSHOT_NAME_FORMAT, snapshotId.getUUID())  
import org.opensearch.core.xcontent.XContentParser;  
import org.opensearch.core.xcontent.MediaTypeRegistry;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
 */  
                                shardPathContents.keySet()
                .keySet()
            .mapToLong(Long::parseLong)
import org.opensearch.cluster.metadata.IndexMetadata;
            );  
import org.opensearch.common.unit.TimeValue;
import static org.hamcrest.Matchers.hasKey;
            );  
 * under the License.  
                    );
     * @param executor Executor to run all repository calls on. This is needed since the production {@link BlobStoreRepository}
        final BlobContainer indicesContainer = repository.blobContainer().children().get("indices");  
        final ClusterApplierService clusterApplierService = mock(ClusterApplierService.class);
import java.io.IOException;  
                            .stream()  
        assertThat(foundSnapshotUUIDs, containsInAnyOrder(expectedSnapshotUUIDs.toArray(Strings.EMPTY_ARRAY)));
import org.opensearch.cluster.service.ClusterApplierService;
        RepositoryData repositoryData
                .collect(Collectors.toSet());
import static org.mockito.Mockito.doAnswer;  
        for (String indexId : foundIndexUUIDs) {
    }
import org.opensearch.repositories.IndexId;
                totalSize.addAndGet(size);
            final ClusterStateUpdateTask task = ((ClusterStateUpdateTask) invocation.getArguments()[1]);  
import org.opensearch.common.settings.ClusterSettings;
                .build()
                }
            for (String index : indexToFiles.keySet()) {
        assertTrue(indexGenerations.length <= 2);  
                    repositoryData = RepositoryData.snapshotsFromXContent(parser, latestGen);
                .get(indexId)  
                    }
        final Map<IndexId, Integer> maxShardCountsExpected = new HashMap<>();
import org.opensearch.core.common.Strings;  
     *
                            indexId,  
            } catch (AssertionError e) {
                        && snapshotInfo.shardFailures()
    }  
                        }
            ClusterState.builder(initialState)  
                    if (generation != null && generation.equals(ShardGenerations.NEW_SHARD_GEN) == false) {  
import static org.junit.Assert.assertThat;
            .execute(ActionRunnable.supply(future, () -> repository.blobStore().blobContainer(path).listBlobsByPrefix(prefix)));
import org.opensearch.cluster.ClusterStateUpdateTask;
        final Map<String, BlobContainer> indices;
            try {
                    maxShardCountsExpected.compute(
            final IndexId idx = repositoryData.getIndices().values().stream().filter(i -> i.getId().equals(indexId)).findFirst().get();
