                        final int impliedCount = shardId - 1;
                container.writeBlob(file, new ByteArrayInputStream(new byte[size]), size, false);
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        assertTrue(future.actionGet());
package org.opensearch.repositories.blobstore;
            indices = Collections.emptyMap();
     *                 of this assertion must pass an executor on those when using such an implementation.
 */
    private static Map<String, BlobContainer> getShardContainers(
        );
            .sorted()
import java.nio.file.NoSuchFileException;
import java.util.concurrent.ExecutionException;
import java.util.List;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.common.blobstore.BlobStore;
import org.opensearch.repositories.RepositoryData;
        } else {
            appliers.forEach(
        final List<String> expectedIndexUUIDs = repositoryData.getIndices()
                        .putCustom(RepositoriesMetadata.TYPE, new RepositoriesMetadata(Collections.singletonList(metadata)))
    private static void assertIndexGenerations(BlobContainer repoRoot, long latestGen) throws IOException {
                assertIndexUUIDs(repository, repositoryData);
            final List<String> gens = shardGenerations.getGens(index);
                }
    }
                    }
            final ClusterState current = currentState.get();
    }
            // TODO: assertEquals(indexMetaGenerationsExpected, indexMetaGenerationsFound); requires cleanup functionality for
                applier -> applier.applyClusterState(new ClusterChangedEvent((String) invocation.getArguments()[0], next, current))
                return null;
import static org.hamcrest.Matchers.containsInAnyOrder;
                            .stream()
                    final int shardCount = indexMetadata.getNumberOfShards();
import java.io.ByteArrayInputStream;
            BlobContainer container = blobStore.blobContainer(repository.basePath().add("indices").add(name));
        Map<String, BlobMetadata> foundBlobs = future.actionGet();
                    .filter(p -> p.startsWith(prefix))
        }
                            repositoryData.indexMetaDataGenerations().indexMetaBlobId(snapshotId, indexId)
        for (IndexId index : shardGenerations.indices()) {
                indexMetaGenerationsExpected.add(repositoryData.indexMetaDataGenerations().indexMetaBlobId(snapshotId, idx));
                    }
                                    .stream()
        final BlobContainer indicesContainer = repository.getBlobContainer().children().get("indices");
        final ClusterService clusterService = mock(ClusterService.class);
     */
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        when(clusterService.getSettings()).thenReturn(Settings.EMPTY);
                ) {
 */
            }
                for (Map.Entry<String, BlobContainer> entry : indexContainer.children().entrySet()) {
import org.opensearch.common.settings.Settings;
import java.io.IOException;
        // Setting local node as cluster-manager so it may update the repository metadata in the cluster state
    private static void assertShardIndexGenerations(BlobStoreRepository repository, RepositoryData repositoryData) throws IOException {
     */
        final PlainActionFuture<Map<String, BlobMetadata>> future = PlainActionFuture.newFuture();
                    final int shardId = Integer.parseInt(entry.getKey());
                    InputStream blob = blobContainer.readBlob(BlobStoreRepository.INDEX_FILE_PREFIX + latestGen);
                        .build()
            .stream()
                    try (
            ClusterState.builder(initialState)
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.common.settings.ClusterSettings;
        }
            }
            throw new AssertionError(err);
                                    )
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
                try (
        final List<String> expectedSnapshotUUIDs = snapshotIds.stream().map(SnapshotId::getUUID).collect(Collectors.toList());
                    final String generation = gens.get(i);
import static org.mockito.Mockito.when;
                                    || shardPathContents.containsKey(
import org.opensearch.repositories.ShardGenerations;
import java.util.Map;
                .build()
 * not use this file except in compliance with the License.
        final BlobContainer indicesContainer = repository.blobContainer().children().get("indices");
        maxShardCountsSeen.forEach(
            final ClusterStateUpdateTask task = ((ClusterStateUpdateTask) invocation.getArguments()[1]);
        );
                final IndexId indexId = repositoryData.resolveIndexId(index);
        for (String prefix : new String[] { BlobStoreRepository.SNAPSHOT_PREFIX, BlobStoreRepository.SHALLOW_SNAPSHOT_PREFIX }) {
            assertTrue(indexMetaGenerationsFound.containsAll(indexMetaGenerationsExpected));
    public static long createDanglingIndex(BlobStoreRepository repository, String name, Set<String> files) throws InterruptedException,
            for (SnapshotId snapshotId : repositoryData.getSnapshots(idx)) {
    }
import org.opensearch.cluster.metadata.RepositoryMetadata;
        if (indicesContainer == null) {
                assertThat(indices, hasKey(indexId.getId()));
                    }
 * Licensed to Elasticsearch under one or more contributor
                    throw new AssertionError("Could not find index.latest blob for repo [" + repository + "]");
import java.util.HashMap;
                lessThanOrEqualTo(maxShardCountsExpected.get(indexId))
                    }
import org.opensearch.core.xcontent.XContentParser;
                final IndexMetadata indexMetadata = repository.getSnapshotIndexMetaData(repositoryData, snapshotId, indexId);
                        assertThat(shardContainers, hasKey(shardId));
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
import static org.junit.Assert.assertTrue;
import org.opensearch.common.blobstore.BlobMetadata;
                            );
        when(clusterService.state()).then(invocationOnMock -> currentState.get());
                .metadata(
     * functionality to make {@link BlobStoreRepository} work. Initializes the cluster state with a {@link RepositoriesMetadata} instance
import static org.mockito.Mockito.anyString;
                assertEquals(entry.getValue().length(), blobs.get(entry.getKey()).length());
                final BlobContainer indexContainer = indices.get(indexId.getId());
                            );
                        continue;
import java.util.Collection;
        BlobStoreRepository repository,
                                shardPathContents.containsKey(
import org.opensearch.test.InternalTestCluster;
import java.util.Locale;
                                    .filter(name -> name.startsWith(BlobStoreRepository.INDEX_FILE_PREFIX))
    public static void assertCorruptionVisible(BlobStoreRepository repository, Map<String, Set<String>> indexToFiles) {
            .map(IndexId::getId)
                        if (snapshotInfo.getPinnedTimestamp() == 0) {
    /**
                            assertThat(
        assertTrue(indexGenerations.length <= 2);
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.hasKey;
            .collect(Collectors.toList());
            task.clusterStateProcessed((String) invocation.getArguments()[0], current, next);
                    );
 *
 * specific language governing permissions and limitations
import org.opensearch.common.blobstore.BlobContainer;
 * The OpenSearch Contributors require contributions made to
        }
                        InputStream ignored = blobStore.blobContainer(repository.basePath().add("indices").add(index)).readBlob(file)
    /**
                        );
                .map(p -> p.replace(BlobStoreRepository.METADATA_PREFIX, "").replace(".dat", ""))
                final long latestGen;
            shardContainers.put(String.valueOf(i), shardContainer);
        final AtomicLong totalSize = new AtomicLong();
        return shardContainers;
import org.opensearch.cluster.node.DiscoveryNodes;
                    if (entry.getKey().startsWith("extra")) {
        if (err != null) {
import org.opensearch.cluster.metadata.RepositoriesMetadata;
                )
import java.util.concurrent.atomic.AtomicLong;
 * software distributed under the License is distributed on an
            );
                        )
                assertSnapshotUUIDs(repository, repositoryData);
    public static void assertBlobsByPrefix(BlobStoreRepository repository, BlobPath path, String prefix, Map<String, BlobMetadata> blobs) {
                .stream()
        } else {
            .keySet()
import java.io.DataInputStream;
                .collect(Collectors.toSet());
        when(clusterApplierService.threadPool()).thenReturn(threadPool);
                count,
                    DiscoveryNodes.builder().add(localNode).clusterManagerNodeId(localNode.getId()).localNodeId(localNode.getId()).build()
                    ) {} catch (NoSuchFileException e) {
    }
import org.opensearch.cluster.ClusterChangedEvent;
            for (Map.Entry<String, BlobMetadata> entry : foundBlobs.entrySet()) {
        for (SnapshotId snapshotId : snapshotIds) {
import static org.opensearch.test.OpenSearchTestCase.buildNewFakeTransportAddress;
            for (String index : indexToFiles.keySet()) {
 * under the License.
        if (indicesContainer == null) {
        final ShardGenerations shardGenerations = repositoryData.shardGenerations();
                        }
        Collection<String> foundSnapshotUUIDs = new HashSet<>();
/*
    }
import org.opensearch.threadpool.ThreadPool;
}
                    final BlobContainer shardContainer = entry.getValue();
     * @param metadata RepositoryMetadata to initialize the cluster state with
        }).when(clusterService).submitStateUpdateTask(anyString(), any(ClusterStateUpdateTask.class));
     * Assert that there are no unreferenced indices or unreferenced root-level metadata blobs in any repository.
            assertThat(foundBlobs.keySet(), containsInAnyOrder(blobs.keySet().toArray(Strings.EMPTY_ARRAY)));
        BlobStoreTestUtil.assertConsistency(repo, repo.threadPool().executor(ThreadPool.Names.GENERIC));
     * functionality to make {@link BlobStoreRepository} work. Initializes the cluster state as {@link ClusterState#EMPTY_STATE}.
            ((indexId, count) -> assertThat(
        final Collection<SnapshotId> snapshotIds = repositoryData.getSnapshotIds();
            new ThreadPool.Info(ThreadPool.Names.SNAPSHOT, ThreadPool.ThreadPoolType.FIXED, randomIntBetween(1, 10))
                }
                .collect(Collectors.toList());
import org.opensearch.snapshots.SnapshotInfo;
import org.opensearch.cluster.service.ClusterService;
     */
        for (String indexId : foundIndexUUIDs) {
     * @param executor Executor to run all repository calls on. This is needed since the production {@link BlobStoreRepository}
                .listBlobsByPrefix(BlobStoreRepository.METADATA_PREFIX)
import org.opensearch.cluster.service.ClusterApplierService;
        final BlobContainer repoRoot = repository.blobContainer();
                }
        RepositoryData repositoryData
        final DiscoveryNode localNode = new DiscoveryNode("", buildNewFakeTransportAddress(), Version.CURRENT);
        repository.threadPool().generic().execute(ActionRunnable.supply(future, () -> {
        final PlainActionFuture<Boolean> future = PlainActionFuture.newFuture();
                "Found unreferenced shard paths for index [" + indexId + "]",
            .execute(ActionRunnable.supply(future, () -> repository.blobStore().blobContainer(path).listBlobsByPrefix(prefix)));
                    maxShardCountsExpected.compute(
        final Map<String, BlobContainer> indices;
    public static void assertRepoConsistency(InternalTestCluster testCluster, String repoName) {
        IndexId indexId,
        }
            .repository(repoName);
            for (String index : snapshotInfo.indices()) {
        );
public final class BlobStoreTestUtil {
import org.opensearch.cluster.ClusterStateUpdateTask;
    private static ClusterService mockClusterService(ClusterState initialState) {
     * @param repository BlobStoreRepository to check
                try (DataInputStream inputStream = new DataInputStream(blobContainer.readBlob("index.latest"))) {
                            .noneMatch(shardFailure -> shardFailure.index().equals(index) && shardFailure.shardId() == shardId)) {
        return mockClusterService(
                    assertThat(generation, not(ShardGenerations.DELETED_SHARD_GEN));
            }
    public static ClusterService mockClusterService() {
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
        when(threadPool.generic()).thenReturn(new SameThreadExecutorService());
                final BlobContainer blobContainer = repository.blobContainer();
import org.opensearch.core.common.Strings;
        } else {
            foundSnapshotUUIDs.addAll(
        final List<String> foundIndexUUIDs;
import org.opensearch.action.support.PlainActionFuture;
                    }
 * license agreements. See the NOTICE file distributed with
                )
import org.opensearch.cluster.metadata.Metadata;
                    )
        final long[] indexGenerations = repoRoot.listBlobsByPrefix(BlobStoreRepository.INDEX_FILE_PREFIX)
                    XContentParser parser = MediaTypeRegistry.JSON.xContent()
                .get(indexId)
            final ClusterState next = task.execute(current);
import org.opensearch.cluster.ClusterState;
            .values()
                    // becomes unreferenced. We should fix that and remove this conditional once its fixed.
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.node.DiscoveryNode;
import static org.opensearch.test.OpenSearchTestCase.randomIntBetween;
            foundIndexUUIDs = Collections.emptyList();
        executor.execute(ActionRunnable.supply(listener, () -> {
 */
    private static void assertIndexUUIDs(BlobStoreRepository repository, RepositoryData repositoryData) throws IOException {
            final BlobContainer shardContainer = repository.shardContainer(indexId, i);
        final PlainActionFuture<AssertionError> listener = PlainActionFuture.newFuture();
     * Creates a mocked {@link ClusterService} for use in {@link BlobStoreRepository} related tests that mocks out all the necessary
            final IndexId idx = repositoryData.getIndices().values().stream().filter(i -> i.getId().equals(indexId)).findFirst().get();
        repository.threadPool().generic().execute(ActionRunnable.run(future, () -> {
                                    String.format(Locale.ROOT, BlobStoreRepository.SHALLOW_SNAPSHOT_NAME_FORMAT, snapshotId.getUUID())
            indices = indicesContainer.children();
import org.opensearch.Version;
        assertThat(foundSnapshotUUIDs, containsInAnyOrder(expectedSnapshotUUIDs.toArray(Strings.EMPTY_ARRAY)));
                                        String.format(Locale.ROOT, BlobStoreRepository.SNAPSHOT_NAME_FORMAT, snapshotId.getUUID())
                        );
                            indexId,
            ClusterState.builder(ClusterState.EMPTY_STATE)
                                lessThanOrEqualTo(2L)
                for (int i = 0; i < gens.size(); i++) {
import org.opensearch.cluster.metadata.IndexMetadata;
    }
        when(clusterService.getClusterApplierService()).thenReturn(clusterApplierService);
        }
            assertThat(foundBlobs.keySet(), empty());
        if (blobs.isEmpty()) {
        final ThreadPool threadPool = mock(ThreadPool.class);
            } catch (AssertionError e) {
import org.opensearch.action.ActionRunnable;
import static org.hamcrest.Matchers.empty;
            foundIndexUUIDs = indicesContainer.children()
                .keySet()
import java.util.stream.Collectors;
            currentState.set(next);
    }
                    latestGen = inputStream.readLong();
     * @return Mock ClusterService
     *
            if (gens.isEmpty() == false) {
                totalSize.addAndGet(size);
                .filter(s -> s.startsWith("extra") == false)
        }
import org.opensearch.snapshots.SnapshotId;
            }
                            shardContainers.get(shardId).listBlobsByPrefix(BlobStoreRepository.INDEX_FILE_PREFIX),
 * GitHub history for details.
        final AssertionError err = listener.actionGet(TimeValue.timeValueMinutes(1L));
import org.opensearch.common.unit.TimeValue;
        }));
        doAnswer(invocation -> {
    public static void assertConsistency(BlobStoreRepository repository, Executor executor) {
                    if (shardId < shardCount
import org.opensearch.core.xcontent.NamedXContentRegistry;
        repository.threadPool()
                        (i, existing) -> existing == null || existing < shardCount ? shardCount : existing
                    return false;
                .stream()
    ) {
            .mapToLong(Long::parseLong)
     * TODO: Expand the logic here to also check for unreferenced segment blobs and shard level metadata
     *                 implementations assert that all IO inducing calls happen on the generic or snapshot thread-pools and hence callers
            return true;
 *
            .toArray();
        final Map<String, BlobContainer> shardContainers = new HashMap<>();
            }
import static org.mockito.Mockito.any;
                for (String file : indexToFiles.get(index)) {
/*
import org.opensearch.cluster.ClusterStateApplier;
                    .map(p -> p.replace(prefix, "").replace(".dat", ""))
        doAnswer(invocation -> {
        }));
     * @return Mock ClusterService
            .generic()
                return e;
        final BlobStoreRepository repo = (BlobStoreRepository) testCluster.getCurrentClusterManagerNodeInstance(RepositoriesService.class)
import static org.mockito.Mockito.doAnswer;
                if (blobStore.blobContainer(repository.basePath().add("indices")).children().containsKey(index) == false) {
     * Creates a mocked {@link ClusterService} for use in {@link BlobStoreRepository} related tests that mocks out all the necessary
        // Assert that for each snapshot, the relevant metadata was written to index and shard folders
            }
                    if (generation != null && generation.equals(ShardGenerations.NEW_SHARD_GEN) == false) {
        ExecutionException {
import java.util.Set;
     * that contains the given {@code metadata}.
            for (String file : files) {
 *
            try {
 * this work for additional information regarding copyright
                    .stream()
                } catch (NoSuchFileException e) {
        future.get();
                    .keySet()
import java.util.concurrent.Executor;
        }
                );
                        maxShardCountsSeen.compute(
 * Modifications Copyright OpenSearch Contributors. See
        }));
                    // TODO: we shouldn't be leaking empty shard directories when a shard (but not all of the index it belongs to)
    /**
                    // Skip Lucene MockFS extraN directory
        final Map<IndexId, Integer> maxShardCountsSeen = new HashMap<>();
 * KIND, either express or implied.  See the License for the
                }
            final Set<String> indexMetaGenerationsExpected = new HashSet<>();
                        && snapshotInfo.shardFailures()
                .nodes(
        final AtomicReference<ClusterState> currentState = new AtomicReference<>(
            return null;
     *
            final Set<String> indexMetaGenerationsFound = indicesContainer.children()
                    indexContainer.listBlobs(),
                                )
                            hasKey(BlobStoreRepository.INDEX_FILE_PREFIX + generation)
            // index meta generations blobs
            appliers.add((ClusterStateApplier) invocation.getArguments()[0]);
                        String.format(
        final ClusterApplierService clusterApplierService = mock(ClusterApplierService.class);
        assertThat(foundIndexUUIDs, containsInAnyOrder(expectedIndexUUIDs.toArray(Strings.EMPTY_ARRAY)));
import java.util.concurrent.atomic.AtomicReference;
        when(threadPool.executor(ThreadPool.Names.SNAPSHOT)).thenReturn(new SameThreadExecutorService());
                final Map<String, BlobContainer> shardContainers = getShardContainers(index, repository, repositoryData);
                            Locale.ROOT,
 *    http://www.apache.org/licenses/LICENSE-2.0
                        final Map<String, BlobMetadata> shardPathContents = shardContainer.listBlobs();
                assertThat(
                }
        );
                        return false;
        return clusterService;
        final PlainActionFuture<Void> future = PlainActionFuture.newFuture();
    }
                    hasKey(
    public static ClusterService mockClusterService(RepositoryMetadata metadata) {
            .stream()
            .map(s -> s.replace(BlobStoreRepository.INDEX_FILE_PREFIX, ""))
        int shardCount = repositoryData.shardGenerations().getGens(indexId).size();
                repoRoot.listBlobs()
            final BlobStore blobStore = repository.blobStore();
        return mockClusterService(ClusterState.EMPTY_STATE);
            );
import static org.junit.Assert.assertThat;
                .build()
                    if (shardContainer.listBlobs().keySet().stream().anyMatch(blob -> blob.startsWith("extra") == false)) {
    }
    }
        }).when(clusterService).addStateApplier(any(ClusterStateApplier.class));
                        indexId,
                                shardPathContents.keySet()
                        final String shardId = Integer.toString(i);
    }
 * You may obtain a copy of the License at
                    Metadata.builder()
        final Map<IndexId, Integer> maxShardCountsExpected = new HashMap<>();
                assertIndexGenerations(blobContainer, latestGen);
        assertEquals(latestGen, indexGenerations[indexGenerations.length - 1]);
                        .createParser(NamedXContentRegistry.EMPTY, LoggingDeprecationHandler.INSTANCE, blob)
import java.util.concurrent.CopyOnWriteArrayList;
                    repositoryData = RepositoryData.snapshotsFromXContent(parser, latestGen);
                        assertThat(
import org.opensearch.core.xcontent.MediaTypeRegistry;
                            BlobStoreRepository.METADATA_NAME_FORMAT,
import java.util.HashSet;
import org.opensearch.common.blobstore.BlobPath;
            // Skip Lucene MockFS extraN directory
        for (int i = 0; i < shardCount; i++) {
    }
            }
                assertShardIndexGenerations(repository, repositoryData);
import java.io.InputStream;
import org.apache.lucene.util.SameThreadExecutorService;
        }
            ))
        when(threadPool.info(ThreadPool.Names.SNAPSHOT)).thenReturn(
                            (i, existing) -> existing == null || existing < impliedCount ? impliedCount : existing
        return totalSize.get();
/*
        final List<ClusterStateApplier> appliers = new CopyOnWriteArrayList<>();
            final SnapshotInfo snapshotInfo = repository.getSnapshotInfo(snapshotId);
import org.opensearch.repositories.IndexId;
                    .collect(Collectors.toSet())
        }
import org.opensearch.repositories.RepositoriesService;
            final BlobStore blobStore = repository.blobStore();
 * compatible open source license.
                int size = randomIntBetween(0, 10);
import static org.junit.Assert.assertEquals;
                final RepositoryData repositoryData;
            return null;
                }
import static org.mockito.Mockito.mock;
                .keySet()
    private static void assertSnapshotUUIDs(BlobStoreRepository repository, RepositoryData repositoryData) throws IOException {
import java.util.Collections;
                                    .count(),
 * the Apache License, Version 2.0 (the "License"); you may
    }
                            assertTrue(
