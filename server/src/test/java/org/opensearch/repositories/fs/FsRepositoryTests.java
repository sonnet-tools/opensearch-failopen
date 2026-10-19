     * the constructor should close it immediately.
                new RecoverySource.SnapshotRecoverySource("test", new Snapshot("foo", snapshotId), Version.CURRENT, indexId),
                    new TextField(
                .collect(Collectors.toList());
            repo.toAbsolutePath().toString(),        // absolute path: Path.resolve discards the validated location
        Settings settings = Settings.builder()
        NativeStoreHandle liveHandle = new NativeStoreHandle(99L, ptr -> destroyed.set(true));
            iwc.setParentField(Lucene.PARENT_FIELD);
            assertTrue(state.getIndex().recoveredBytes() > 0);
import org.opensearch.index.snapshots.IndexShardSnapshotStatus;
import org.apache.lucene.index.IndexCommit;
                future1.actionGet();
                IndexShardSnapshotStatus.Copy copy = snapshotStatus.asCopy();
            }
import org.apache.lucene.tests.analysis.MockAnalyzer;
import org.apache.lucene.document.SortedDocValuesField;
            .put("location", repo)
import org.apache.lucene.document.Document;
/*
                doc.add(
        if (isParentFieldEnabled) {
 * GitHub history for details.
    }
                    null
            for (int i = 0; i < docs; i++) {
            .put(IndexMetadata.SETTING_INDEX_UUID, "myindexUUID")
            return docs;
import org.opensearch.index.IndexSettings;
        RepositoryMetadata metadata = new RepositoryMetadata("test", "fs", settings);
    public void testRestrictedSettingsDefault() {
        assertSame(NativeStoreRepository.EMPTY, repository.getNativeStore());
            Collections.sort(recoveredFiles, Comparator.comparing(ReplicationLuceneIndex.FileMetadata::name));
            final PlainActionFuture<String> future1 = PlainActionFuture.newFuture();
            );
                @Override
        threadPool.generic().submit(() -> {
            deleteRandomDoc(store.directory(), isParentFieldEnabled);
            new RecoverySettings(settings, new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)),
import org.opensearch.threadpool.ThreadPool;
        repository.close();
    private int indexDocs(Directory directory, boolean isParentFieldEnabled) throws IOException {
import org.apache.lucene.util.IOSupplier;
                    new RecoverySettings(settings, new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS))
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toAbsolutePath())
        try (Directory directory = newDirectory()) {
                return new NativeStoreRepository(handle);
                return "fs";
                    indexId,
        );
import org.opensearch.indices.recovery.RecoveryState;
            final PlainActionFuture<Void> futureA = PlainActionFuture.newFuture();
        };
import org.apache.lucene.index.NoMergePolicy;
        final Settings indexSettings = Settings.builder()
                runnable.run();
     * When the native store provider returns a store that is not live and not EMPTY,
import org.apache.lucene.index.FilterMergePolicy;
            assertEquals(writer.getDocStats().numDocs, numDocs - 1);
import org.opensearch.indices.replication.common.ReplicationLuceneIndex;
                    null,
                doc.add(new SortedDocValuesField("dv", new BytesRef(TestUtil.randomRealisticUnicodeString(random()))));
import org.opensearch.plugins.NativeRemoteObjectStoreProvider;
    /**
        testSnapshotAndRestore(true, indexSettings);
            new Environment(settings, null),
            IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("myindex", indexSettings);
            NamedXContentRegistry.EMPTY,
            terminate(threadPool);
                .put("location", repo)
import org.opensearch.cluster.metadata.RepositoryMetadata;
        NativeRemoteObjectStoreProvider provider = new NativeRemoteObjectStoreProvider() {
/*
 * not use this file except in compliance with the License.
        NativeRemoteObjectStoreProvider provider = new NativeRemoteObjectStoreProvider() {
        Path repo = createTempDir();
            assertEquals(0, state.getIndex().reusedFileCount());
                Document doc = new Document();
                return NativeStoreRepository.EMPTY;
            Collection<String> commitFileNames = incIndexCommit.getFileNames();
 * SPDX-License-Identifier: Apache-2.0
            final PlainActionFuture<Void> futureB = PlainActionFuture.newFuture();
        FsRepository repository = new FsRepository(
                new RecoverySettings(settings, new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS))
                // Create a handle that's already closed — isLive() will be false
                true,
                .put(Environment.PATH_REPO_SETTING.getKey(), repo.toAbsolutePath())
            SnapshotId snapshotId = new SnapshotId("test", "test");
            }
                );
            assertThat("base_path [" + basePath + "] must be rejected", e.getMessage(), containsString("base_path"));
            "/usr/share/opensearch/data/nodes/0",    // absolute path (the reported POC payload)
                .putList(Environment.PATH_DATA_SETTING.getKey(), tmpPaths())
            futureB.actionGet();
                IndexShardSnapshotStatus snapshotStatus = IndexShardSnapshotStatus.newInitializing(null);
        }
            IndexCommit incIndexCommit = Lucene.getIndexCommit(Lucene.readSegmentInfos(store.directory()), store.directory());
            metadata,
            BlobStoreTestUtil.mockClusterService(),
                "should reuse everything except of .liv and .si",
        final RepositoryMetadata metadata = new RepositoryMetadata("test", "fs", settings);
                    Collections.emptyMap(),
            }
import org.opensearch.common.settings.ClusterSettings;
                    null,
            );
            .build();
            runGeneric(threadPool, () -> repository.restoreShard(store, incSnapshotId, indexId, shardId, secondState, futureC));
        assertTrue(restrictedSettings.contains(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY));
import java.util.Collection;
            } finally {
            public String repositoryType() {
                return "fs";
                .fileDetails()
                .build();
        );
        assertTrue(restrictedSettings.contains(BlobStoreRepository.READONLY_SETTING));
        assertTrue("Native handle should be destroyed after repository close", destroyed.get());
        new FsRepository(
            "a/b/../c"
            try {
import org.opensearch.snapshots.Snapshot;
            final RuntimeException e = expectThrows(
import org.apache.lucene.tests.util.TestUtil;
        // but the code path is exercised. Verify the repository's native store remains EMPTY.
                    new Environment(settings, null),
                doc.add(new StringField("id", "" + i, random().nextBoolean() ? Field.Store.YES : Field.Store.NO));
        final Settings settings = Settings.builder()
            final Settings settings = Settings.builder()
import org.opensearch.core.index.shard.ShardId;
            final PlainActionFuture<String> future2 = PlainActionFuture.newFuture();
                handle.close(); // first close — destroyer fires, isLive() becomes false
        AtomicBoolean secondCloseCalled = new AtomicBoolean(false);
                    return true;
            }
            final PlainActionFuture<Void> futureC = PlainActionFuture.newFuture();
 * Licensed to Elasticsearch under one or more contributor
                .put("location", repo)
        assertSame(liveStore, repository.getNativeStore());
                    NamedXContentRegistry.EMPTY,
        assertTrue(restrictedSettings.contains(FsRepository.LOCATION_SETTING));
    }
    private void deleteRandomDoc(Directory directory, boolean isParentFieldEnabled) throws IOException {
                public boolean keepFullyDeletedSegment(IOSupplier<CodecReader> readerIOSupplier) {
            IndexCommit indexCommit = Lucene.getIndexCommit(Lucene.readSegmentInfos(store.directory()), store.directory());
            .setMergePolicy(new FilterMergePolicy(NoMergePolicy.INSTANCE) {
import org.opensearch.common.settings.Settings;
    }
            .put("location", repo)
                BlobStoreTestUtil.mockClusterService(),
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toAbsolutePath())
import org.opensearch.plugins.NativeStoreHandle;
            .put("location", repo)
            assertEquals(secondState.getIndex().recoveredFileCount(), 2);
        Settings settings = Settings.builder()
                    store,
 * software distributed under the License is distributed on an
            .build();
import org.apache.lucene.index.IndexWriter;
        FsRepository repository = new FsRepository(
import org.apache.lucene.document.Field;
        }
            "../escape",
        RepositoryMetadata metadata = new RepositoryMetadata("test", "fs", settings);
            DiscoveryNode localNode = new DiscoveryNode("foo", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
        for (String basePath : maliciousBasePaths) {
                new UnassignedInfo(UnassignedInfo.Reason.EXISTING_INDEX_RESTORED, "")
            public String repositoryType() {
     * When the native store provider returns EMPTY, the repository should keep its default EMPTY store.
        );
import org.opensearch.indices.recovery.RecoverySettings;
import org.opensearch.Version;
                .stream()
            IndexId indexId = new IndexId(idxSettings.getIndex().getName(), idxSettings.getUUID());
            .build();
                    future2,
import static java.util.Collections.emptySet;
            .put("index.sort.field", "foo1")
                    snapshotId,
            runGeneric(threadPool, () -> repository.restoreShard(store, snapshotId, indexId, shardId, state, futureA));
            metadata,
            new Environment(settings, null),
 *    http://www.apache.org/licenses/LICENSE-2.0
                .put(FsRepository.BASE_PATH_SETTING.getKey(), "my_base_path")
        // Create a handle, close it so isLive() returns false, then wrap in NativeStoreRepository.
        );
                    null,
        assertSame(NativeStoreRepository.EMPTY, repository.getNativeStore());
        final Path repo = createTempDir();
            assertTrue(recoveredFiles.get(0).name(), recoveredFiles.get(0).name().endsWith(".liv"));
            );
            .put("location", repo)
                future2.actionGet();
                // Reset the flag so we can detect the second close from FsRepository
                () -> new FsRepository(
    public void testNonLiveStoreIsClosedDuringConstruction() {
            .put(Environment.PATH_REPO_SETTING.getKey(), repo.toAbsolutePath())
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toAbsolutePath())
            FsRepository repository = new FsRepository(
        assertThat(restrictedSettings.size(), is(4));
import org.opensearch.common.lucene.Lucene;
import org.opensearch.repositories.blobstore.BlobStoreTestUtil;
            RepositoryMetadata metadata = new RepositoryMetadata("test", "fs", settings);
import org.apache.lucene.index.Term;
        }
package org.opensearch.repositories.fs;
            "..",                                    // parent-directory traversal
        };
import org.opensearch.core.xcontent.NamedXContentRegistry;
import java.util.stream.Collectors;
        // A well-formed relative base_path that stays within path.repo must construct without throwing.
 * KIND, either express or implied.  See the License for the
import org.opensearch.action.support.PlainActionFuture;
            .build();
     */
            });
            @Override
import org.opensearch.repositories.blobstore.BlobStoreRepository;
            NamedXContentRegistry.EMPTY,
            provider
            }
        }
            });
        RepositoryMetadata metadata = new RepositoryMetadata("test", "fs", settings);
            futureC.actionGet();
     * When the native store provider returns a live store, it should be assigned to the repository.
import org.opensearch.index.store.Store;
 * under the License.
            provider
            new RecoverySettings(settings, new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS))
            ShardRouting routing = ShardRouting.newUnassigned(
    }
            final RepositoryMetadata metadata = new RepositoryMetadata("test", "fs", settings);
import org.apache.lucene.index.IndexWriterConfig;
            @Override
            RecoveryState firstState = new RecoveryState(routing, localNode, null);
 *
            // roll back to the first snap and then incrementally restore
import org.apache.lucene.store.Directory;
 * Modifications Copyright OpenSearch Contributors. See
                return "fs";
            .build();
    /**
                assertEquals(commitFileNames.size(), copy.getTotalFileCount());
            }
                repository.snapshotShard(
        final Settings indexSettings = Settings.builder().put(IndexMetadata.SETTING_INDEX_UUID, "myindexUUID").build();
        FsRepository repository = new FsRepository(
import org.opensearch.test.IndexSettingsModule;
            metadata,
            routing = ShardRoutingHelper.initialize(routing, localNode.getId(), 0);
import org.opensearch.cluster.metadata.IndexMetadata;
                latch.countDown();
     */
            assertTrue(recoveredFiles.get(1).name(), recoveredFiles.get(1).name().endsWith("segments_" + incIndexCommit.getGeneration()));
import java.util.concurrent.CountDownLatch;
    public void testSnapshotAndRestoreWithoutIndexSort() throws IOException, InterruptedException {
     */
                .put("compress", randomBoolean())
        // We need a store where isLive() == false but store != EMPTY.
        Path repo = createTempDir();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                .put(FsRepository.BASE_PATH_SETTING.getKey(), basePath)
            new RecoverySettings(settings, new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)),
            Settings settings = Settings.builder()
            .put(Environment.PATH_REPO_SETTING.getKey(), repo.toAbsolutePath())
import org.apache.lucene.document.TextField;
 * compatible open source license.
        // NativeStoreHandle.close() is idempotent so the destroyer won't fire again,
import java.nio.file.Path;
        final Path repo = createTempDir();
 * license agreements. See the NOTICE file distributed with
import org.opensearch.snapshots.SnapshotId;
 * Unless required by applicable law or agreed to in writing,
        IndexWriterConfig iwc = newIndexWriterConfig(random(), new MockAnalyzer(random())).setCodec(TestUtil.getDefaultCodec())
    }
        // Clean up: close the repository to release the native handle
            int docs = 1 + random().nextInt(100);
 * ownership. Elasticsearch licenses this file to you under
 */
    }
            @Override
import org.opensearch.cluster.routing.UnassignedInfo;
        NativeStoreRepository liveStore = new NativeStoreRepository(liveHandle);
import org.opensearch.cluster.node.DiscoveryNode;
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toAbsolutePath())
            writer.commit();
                .filter(f -> f.reused() == false)
                }
import java.util.Collections;
    }
        latch.await();
import java.util.Comparator;
                assertEquals(copy.getTotalFileCount(), copy.getIncrementalFileCount());
            SnapshotId incSnapshotId = new SnapshotId("test1", "test1");
                commitFileNames.size() - 2,
import org.opensearch.test.DummyShardLock;
        RepositoryMetadata metadata = new RepositoryMetadata("test", "fs", settings);
                NativeStoreHandle handle = new NativeStoreHandle(42L, ptr -> secondCloseCalled.set(true));
        CountDownLatch latch = new CountDownLatch(1);
            .put(FsRepository.BASE_PATH_SETTING.getKey(), "nested/base/path")
        }
                    future1,
        testSnapshotAndRestore(false, indexSettings);
            .build();
                    )
            repository.start();
                IndexShardSnapshotStatus snapshotStatus = IndexShardSnapshotStatus.newInitializing(shardGeneration);
            BlobStoreTestUtil.mockClusterService(),
            RecoveryState state = new RecoveryState(routing, localNode, null);
import org.opensearch.cluster.routing.ShardRouting;
            @Override
            futureA.actionGet();
 */
            runGeneric(threadPool, () -> {
                firstState.getIndex().reusedFileCount()
            final String shardGeneration = future1.actionGet();
            });
import org.opensearch.test.OpenSearchTestCase;
        try (IndexWriter writer = new IndexWriter(directory, iwc);) {
        };
            BlobStoreTestUtil.mockClusterService(),
        assertFalse("Live store should not have been destroyed", destroyed.get());
                    Version.CURRENT,
                    indexId,
        final List<String> maliciousBasePaths = List.of(
        assertTrue(repository.getNativeStore().isLive());
            new Environment(settings, null),
                new Environment(settings, null),
import org.opensearch.cluster.routing.RecoverySource;
                IndexShardSnapshotStatus.Copy copy = snapshotStatus.asCopy();
            new RecoverySettings(settings, new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS))
                    snapshotStatus,
            final int numDocs = writer.getDocStats().numDocs;
        assertTrue(restrictedSettings.contains(BlobStoreRepository.SYSTEM_REPOSITORY_SETTING));
        } finally {
 * The OpenSearch Contributors require contributions made to
        // The constructor should have called store.close() on the non-live, non-EMPTY store.
                NamedXContentRegistry.EMPTY,
        );
import org.apache.lucene.index.CodecReader;
}
            RecoveryState secondState = new RecoveryState(routing, localNode, null);
import org.apache.lucene.document.StringField;
 * this file be licensed under the Apache-2.0 license or a
            assertEquals(secondState.getIndex().reusedFileCount(), commitFileNames.size() - 2);
    public void testEmptyStoreFromProviderKeepsDefault() {
            List<ReplicationLuceneIndex.FileMetadata> recoveredFiles = secondState.getIndex()
                    store,
    public void testRelativeBasePathWithinPathRepoIsAccepted() {
                    null
        // Since NativeStoreHandle.close() is idempotent, we track via a counter in the destroyer.
            new Environment(settings, null),
            .put("location", repo)
            assertEquals(numDocs, Lucene.readSegmentInfos(directory).totalMaxDoc());
            int numDocs = indexDocs(directory, isParentFieldEnabled);
                    indexCommit,
import static org.hamcrest.Matchers.is;
                .put("chunk_size", randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
            new Environment(settings, null),
            runGeneric(threadPool, () -> repository.restoreShard(store, snapshotId, indexId, shardId, firstState, futureB));
 * this work for additional information regarding copyright
import org.opensearch.repositories.IndexId;
        AtomicBoolean destroyed = new AtomicBoolean(false);
                repository.snapshotShard(
                        TestUtil.randomRealisticUnicodeString(random()),
                .put(Environment.PATH_REPO_SETTING.getKey(), repo.toAbsolutePath())
 * the Apache License, Version 2.0 (the "License"); you may
    }
                    Collections.emptyMap(),
            iwc.setParentField(Lucene.PARENT_FIELD);
import static org.hamcrest.Matchers.containsString;
        ThreadPool threadPool = new TestThreadPool(getClass().getSimpleName());
import static java.util.Collections.emptyMap;
                shardId,
 * You may obtain a copy of the License at
            NamedXContentRegistry.EMPTY,
            BlobStoreTestUtil.mockClusterService(),
            );
            @Override
            @Override
import org.opensearch.repositories.NativeStoreRepository;
 */
        IndexWriterConfig iwc = newIndexWriterConfig(random(), new MockAnalyzer(random())).setCodec(TestUtil.getDefaultCodec());
    }
                metadata,
public class FsRepositoryTests extends OpenSearchTestCase {
                    Version.CURRENT,
                );
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toAbsolutePath())
        List<Setting<?>> restrictedSettings = repository.getRestrictedSystemRepositorySettings();
 * specific language governing permissions and limitations
    private void runGeneric(ThreadPool threadPool, Runnable runnable) throws InterruptedException {
    /**
import org.opensearch.env.Environment;
                    metadata,
        }
        try (IndexWriter writer = new IndexWriter(directory, iwc)) {
                return liveStore;
            .put(Environment.PATH_REPO_SETTING.getKey(), repo.toAbsolutePath())
            metadata,
            Lucene.cleanLuceneIndex(directory);
            .put(FsRepository.BASE_PATH_SETTING.getKey(), "my_base_path")
            }
import java.util.concurrent.atomic.AtomicBoolean;
            public NativeStoreRepository createNativeStore(RepositoryMetadata md, Settings nodeSettings) {
            public String repositoryType() {
        Path repo = createTempDir();
            runGeneric(threadPool, () -> {
import org.apache.lucene.util.BytesRef;
            }
    public void testSnapshotAndRestoreWithIndexSort() throws IOException, InterruptedException {
        Settings settings = Settings.builder()
    }
                    snapshotStatus,
    public void testLiveStoreIsAssignedDuringConstruction() {
        // The FsRepository constructor should call store.close() on this non-live, non-EMPTY store.
        );
            BlobStoreTestUtil.mockClusterService(),
            NamedXContentRegistry.EMPTY,
            writer.commit();
                    incIndexCommit,
                        "body",
        FsRepository repository = new FsRepository(
import org.opensearch.core.common.unit.ByteSizeUnit;
                    null,
import java.io.IOException;
            .put(Environment.PATH_REPO_SETTING.getKey(), repo.toAbsolutePath())
                        random().nextBoolean() ? Field.Store.YES : Field.Store.NO
                RuntimeException.class,
                )
            Store store = new Store(shardId, idxSettings, directory, new DummyShardLock(shardId));
            assertEquals(
                .build();
import org.opensearch.cluster.routing.ShardRoutingHelper;
            assertEquals(indexCommit.getFileNames().size(), state.getIndex().recoveredFileCount());
import org.opensearch.threadpool.TestThreadPool;
                    incSnapshotId,
        Path repo = createTempDir();
            Path repo = createTempDir();
            "nested/../../escape",
            ShardId shardId = new ShardId(idxSettings.getIndex(), 1);
    public void testBasePathEscapingPathRepoIsRejected() {
            .put(Environment.PATH_REPO_SETTING.getKey(), repo.toAbsolutePath())
 *
import org.opensearch.common.settings.Setting;
        });
            new RecoverySettings(settings, new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)),
            public NativeStoreRepository createNativeStore(RepositoryMetadata md, Settings nodeSettings) {
import java.util.List;
            "foo/../bar",                            // interior '..' is rejected by the strict string validator
        if (isParentFieldEnabled) {
/*
    }
            writer.deleteDocuments(new Term("id", "" + randomIntBetween(0, writer.getDocStats().numDocs - 1)));
            public NativeStoreRepository createNativeStore(RepositoryMetadata md, Settings nodeSettings) {
                    BlobStoreTestUtil.mockClusterService(),
                secondCloseCalled.set(false);
                );
                writer.addDocument(doc);
                assertEquals(2, copy.getIncrementalFileCount());
    public void testSnapshotAndRestore(boolean isParentFieldEnabled, Settings indexSettings) throws IOException, InterruptedException {
            metadata,
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toAbsolutePath())
        NativeRemoteObjectStoreProvider provider = new NativeRemoteObjectStoreProvider() {
 *
        Settings settings = Settings.builder()
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toAbsolutePath())
            provider
    }
            expectThrows(org.apache.lucene.index.IndexNotFoundException.class, () -> Lucene.readSegmentInfos(directory));
            NamedXContentRegistry.EMPTY,
