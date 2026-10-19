            IndexCommit indexCommit = Lucene.getIndexCommit(Lucene.readSegmentInfos(store.directory()), store.directory());  
        assertSame(NativeStoreRepository.EMPTY, repository.getNativeStore());  
        try (Directory directory = newDirectory()) {
                Document doc = new Document();  
            public String repositoryType() {
                return NativeStoreRepository.EMPTY;
                metadata,
                return "fs";  
        final Settings indexSettings = Settings.builder().put(IndexMetadata.SETTING_INDEX_UUID, "myindexUUID").build();
    }
            metadata,
                runnable.run();  
                .build();  
        assertSame(NativeStoreRepository.EMPTY, repository.getNativeStore());
import org.opensearch.cluster.routing.UnassignedInfo;
        // Clean up: close the repository to release the native handle
    /**
            provider  
                    Collections.emptyMap(),
import org.opensearch.action.support.PlainActionFuture;  
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toAbsolutePath())  
import org.apache.lucene.index.FilterMergePolicy;  
                    Version.CURRENT,  
 * ownership. Elasticsearch licenses this file to you under  
                .put("location", repo)
 *
                    indexId,  
            Settings settings = Settings.builder()
import org.opensearch.common.settings.Settings;
                () -> new FsRepository(
                );
            } finally {
 * compatible open source license.
     */
            Collection<String> commitFileNames = incIndexCommit.getFileNames();
    }  
                    metadata,
                    incSnapshotId,
import org.apache.lucene.document.TextField;
        Settings settings = Settings.builder()
import org.opensearch.common.settings.ClusterSettings;  
            new RecoverySettings(settings, new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)),
            provider  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.repositories.blobstore.BlobStoreTestUtil;  
        assertThat(restrictedSettings.size(), is(4));  
            ShardId shardId = new ShardId(idxSettings.getIndex(), 1);
        }  
import org.opensearch.indices.recovery.RecoverySettings;
import org.opensearch.repositories.NativeStoreRepository;
                commitFileNames.size() - 2,
            repo.toAbsolutePath().toString(),        // absolute path: Path.resolve discards the validated location
            .put(Environment.PATH_REPO_SETTING.getKey(), repo.toAbsolutePath())  
        } finally {
                .putList(Environment.PATH_DATA_SETTING.getKey(), tmpPaths())
import org.opensearch.plugins.NativeStoreHandle;
        final RepositoryMetadata metadata = new RepositoryMetadata("test", "fs", settings);  
import static org.hamcrest.Matchers.containsString;  
import org.apache.lucene.document.Document;  
            assertTrue(recoveredFiles.get(0).name(), recoveredFiles.get(0).name().endsWith(".liv"));
import org.opensearch.core.common.unit.ByteSizeUnit;  
            IndexCommit incIndexCommit = Lucene.getIndexCommit(Lucene.readSegmentInfos(store.directory()), store.directory());  
 * SPDX-License-Identifier: Apache-2.0
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.xcontent.NamedXContentRegistry;
package org.opensearch.repositories.fs;
        RepositoryMetadata metadata = new RepositoryMetadata("test", "fs", settings);
                    new RecoverySettings(settings, new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS))  
        // NativeStoreHandle.close() is idempotent so the destroyer won't fire again,  
import org.apache.lucene.index.CodecReader;
    public void testRestrictedSettingsDefault() {  
            Lucene.cleanLuceneIndex(directory);
                future2.actionGet();  
        );
                    )
                RuntimeException.class,  
            writer.commit();
                    new Environment(settings, null),  
            final PlainActionFuture<Void> futureC = PlainActionFuture.newFuture();  
        assertTrue(repository.getNativeStore().isLive());
import java.util.Collections;  
    }  
                future1.actionGet();
                BlobStoreTestUtil.mockClusterService(),
import org.opensearch.index.store.Store;  
                .build();  
     * When the native store provider returns a live store, it should be assigned to the repository.  
            RecoveryState secondState = new RecoveryState(routing, localNode, null);
            DiscoveryNode localNode = new DiscoveryNode("foo", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);  
     */
                    future2,  
        assertTrue(restrictedSettings.contains(FsRepository.LOCATION_SETTING));
import static java.util.Collections.emptySet;
    }
            }
        assertTrue(restrictedSettings.contains(BlobStoreRepository.READONLY_SETTING));
import org.apache.lucene.index.IndexWriter;
            .put("location", repo)
                "should reuse everything except of .liv and .si",  
            );  
            for (int i = 0; i < docs; i++) {
            writer.deleteDocuments(new Term("id", "" + randomIntBetween(0, writer.getDocStats().numDocs - 1)));
                NativeStoreHandle handle = new NativeStoreHandle(42L, ptr -> secondCloseCalled.set(true));  
            public NativeStoreRepository createNativeStore(RepositoryMetadata md, Settings nodeSettings) {
        };
            .put(IndexMetadata.SETTING_INDEX_UUID, "myindexUUID")
import java.util.List;
                IndexShardSnapshotStatus.Copy copy = snapshotStatus.asCopy();
            assertTrue(state.getIndex().recoveredBytes() > 0);  
                public boolean keepFullyDeletedSegment(IOSupplier<CodecReader> readerIOSupplier) {  
    public void testSnapshotAndRestoreWithIndexSort() throws IOException, InterruptedException {
        NativeStoreRepository liveStore = new NativeStoreRepository(liveHandle);
            ShardRouting routing = ShardRouting.newUnassigned(
            .put("location", repo)
                // Reset the flag so we can detect the second close from FsRepository
            NamedXContentRegistry.EMPTY,  
            });
        final Settings settings = Settings.builder()  
        Path repo = createTempDir();
                    snapshotId,
            BlobStoreTestUtil.mockClusterService(),
            RecoveryState firstState = new RecoveryState(routing, localNode, null);
    private void deleteRandomDoc(Directory directory, boolean isParentFieldEnabled) throws IOException {
    }
            .build();  
        threadPool.generic().submit(() -> {
            final String shardGeneration = future1.actionGet();  
                new RecoverySource.SnapshotRecoverySource("test", new Snapshot("foo", snapshotId), Version.CURRENT, indexId),
        }  
    }
        assertTrue(restrictedSettings.contains(BlobStoreRepository.SYSTEM_REPOSITORY_SETTING));
        };
                    Version.CURRENT,
            new Environment(settings, null),
    private int indexDocs(Directory directory, boolean isParentFieldEnabled) throws IOException {
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toAbsolutePath())
    public void testLiveStoreIsAssignedDuringConstruction() {
 * license agreements. See the NOTICE file distributed with
import java.nio.file.Path;
                    null  
            "foo/../bar",                            // interior '..' is rejected by the strict string validator  
                handle.close(); // first close — destroyer fires, isLive() becomes false
            int docs = 1 + random().nextInt(100);
    }
 * The OpenSearch Contributors require contributions made to  
                    new TextField(  
import java.io.IOException;  
            }  
            final int numDocs = writer.getDocStats().numDocs;  
            provider
            @Override  
            .build();  
            iwc.setParentField(Lucene.PARENT_FIELD);
 * Modifications Copyright OpenSearch Contributors. See  
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toAbsolutePath())
import java.util.stream.Collectors;
        };  
            BlobStoreTestUtil.mockClusterService(),  
import org.opensearch.test.DummyShardLock;  
            List<ReplicationLuceneIndex.FileMetadata> recoveredFiles = secondState.getIndex()
        );  
                new Environment(settings, null),  
        RepositoryMetadata metadata = new RepositoryMetadata("test", "fs", settings);
import org.opensearch.core.index.shard.ShardId;
            .build();
                .put("compress", randomBoolean())  
        if (isParentFieldEnabled) {
            NamedXContentRegistry.EMPTY,  
        NativeRemoteObjectStoreProvider provider = new NativeRemoteObjectStoreProvider() {  
            return docs;
            runGeneric(threadPool, () -> {
        // but the code path is exercised. Verify the repository's native store remains EMPTY.
                firstState.getIndex().reusedFileCount()
 *
            writer.commit();  
import org.apache.lucene.index.IndexCommit;
            SnapshotId snapshotId = new SnapshotId("test", "test");  
public class FsRepositoryTests extends OpenSearchTestCase {  
            expectThrows(org.apache.lucene.index.IndexNotFoundException.class, () -> Lucene.readSegmentInfos(directory));
            "nested/../../escape",
            new Environment(settings, null),
            .build();  
        // We need a store where isLive() == false but store != EMPTY.  
     */
        AtomicBoolean destroyed = new AtomicBoolean(false);
        FsRepository repository = new FsRepository(  
     * the constructor should close it immediately.
            IndexId indexId = new IndexId(idxSettings.getIndex().getName(), idxSettings.getUUID());
            FsRepository repository = new FsRepository(
            futureB.actionGet();
import static org.hamcrest.Matchers.is;
            NamedXContentRegistry.EMPTY,  
        try (IndexWriter writer = new IndexWriter(directory, iwc);) {
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toAbsolutePath())
        });
            .put("location", repo)
                    return true;
            }
        FsRepository repository = new FsRepository(  
                .stream()
    /**
            final PlainActionFuture<Void> futureB = PlainActionFuture.newFuture();
import org.opensearch.cluster.node.DiscoveryNode;  
        }
import org.apache.lucene.util.BytesRef;  
            @Override
 */  
            runGeneric(threadPool, () -> repository.restoreShard(store, incSnapshotId, indexId, shardId, secondState, futureC));
        assertFalse("Live store should not have been destroyed", destroyed.get());  
            assertEquals(
            @Override  
import org.apache.lucene.tests.util.TestUtil;
                assertEquals(copy.getTotalFileCount(), copy.getIncrementalFileCount());
                    null
            try {
            assertEquals(0, state.getIndex().reusedFileCount());
import org.opensearch.repositories.IndexId;  
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toAbsolutePath())
            @Override
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toAbsolutePath())  
import org.opensearch.cluster.routing.ShardRoutingHelper;  
                );
 * GitHub history for details.
                    store,  
    private void runGeneric(ThreadPool threadPool, Runnable runnable) throws InterruptedException {
        assertTrue("Native handle should be destroyed after repository close", destroyed.get());  
        RepositoryMetadata metadata = new RepositoryMetadata("test", "fs", settings);
    public void testBasePathEscapingPathRepoIsRejected() {
                }
                assertEquals(commitFileNames.size(), copy.getTotalFileCount());  
                IndexShardSnapshotStatus.Copy copy = snapshotStatus.asCopy();  
    }
            new RecoverySettings(settings, new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS))
            SnapshotId incSnapshotId = new SnapshotId("test1", "test1");
                repository.snapshotShard(
        testSnapshotAndRestore(true, indexSettings);
        CountDownLatch latch = new CountDownLatch(1);  
                    null,  
            metadata,
import org.opensearch.Version;
 * this work for additional information regarding copyright
import org.opensearch.test.OpenSearchTestCase;
            BlobStoreTestUtil.mockClusterService(),
     * When the native store provider returns a store that is not live and not EMPTY,  
            public String repositoryType() {
                    null,
     * When the native store provider returns EMPTY, the repository should keep its default EMPTY store.
        final List<String> maliciousBasePaths = List.of(  
            RepositoryMetadata metadata = new RepositoryMetadata("test", "fs", settings);  
                    BlobStoreTestUtil.mockClusterService(),
                latch.countDown();
                .collect(Collectors.toList());  
            Path repo = createTempDir();  
            new RecoverySettings(settings, new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS))
 * Unless required by applicable law or agreed to in writing,
        final Settings indexSettings = Settings.builder()  
            metadata,  
import org.apache.lucene.document.SortedDocValuesField;
            new Environment(settings, null),
    }
        }
            .put(Environment.PATH_REPO_SETTING.getKey(), repo.toAbsolutePath())
            .put(Environment.PATH_REPO_SETTING.getKey(), repo.toAbsolutePath())
        IndexWriterConfig iwc = newIndexWriterConfig(random(), new MockAnalyzer(random())).setCodec(TestUtil.getDefaultCodec())  
        Settings settings = Settings.builder()
            runGeneric(threadPool, () -> {  
                // Create a handle that's already closed — isLive() will be false
import org.opensearch.cluster.routing.RecoverySource;
                .put("chunk_size", randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
            metadata,
            routing = ShardRoutingHelper.initialize(routing, localNode.getId(), 0);
            Store store = new Store(shardId, idxSettings, directory, new DummyShardLock(shardId));
            final RepositoryMetadata metadata = new RepositoryMetadata("test", "fs", settings);
        // The constructor should have called store.close() on the non-live, non-EMPTY store.
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toAbsolutePath())  
            new Environment(settings, null),
            .put(Environment.PATH_REPO_SETTING.getKey(), repo.toAbsolutePath())
import org.opensearch.threadpool.TestThreadPool;  
        );  
                    store,
            .build();
 *  
 * not use this file except in compliance with the License.
            assertEquals(secondState.getIndex().recoveredFileCount(), 2);
            }  
        new FsRepository(
                shardId,
                    null,
import org.opensearch.env.Environment;  
import org.apache.lucene.document.StringField;  
            final Settings settings = Settings.builder()
import java.util.Comparator;
 * specific language governing permissions and limitations
            .put(Environment.PATH_REPO_SETTING.getKey(), repo.toAbsolutePath())
        for (String basePath : maliciousBasePaths) {  
        }
            });  
import org.opensearch.common.lucene.Lucene;
            terminate(threadPool);
                    future1,
            .put(FsRepository.BASE_PATH_SETTING.getKey(), "my_base_path")  
            final RuntimeException e = expectThrows(
                repository.snapshotShard(
            @Override  
import org.apache.lucene.index.Term;
        Path repo = createTempDir();  
import org.opensearch.cluster.metadata.RepositoryMetadata;
import org.apache.lucene.util.IOSupplier;
        }
            }
    public void testEmptyStoreFromProviderKeepsDefault() {  
                        "body",
}  
                .put("location", repo)
 * under the License.  
        NativeRemoteObjectStoreProvider provider = new NativeRemoteObjectStoreProvider() {  
import org.opensearch.cluster.metadata.IndexMetadata;
    }  
        // The FsRepository constructor should call store.close() on this non-live, non-EMPTY store.
            );
            .setMergePolicy(new FilterMergePolicy(NoMergePolicy.INSTANCE) {
import org.apache.lucene.tests.analysis.MockAnalyzer;
                .put(Environment.PATH_REPO_SETTING.getKey(), repo.toAbsolutePath())  
                    snapshotStatus,  
 */
            new RecoverySettings(settings, new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)),
            new RecoverySettings(settings, new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)),
import org.opensearch.indices.replication.common.ReplicationLuceneIndex;  
import org.opensearch.repositories.blobstore.BlobStoreRepository;
                    indexCommit,  
            runGeneric(threadPool, () -> repository.restoreShard(store, snapshotId, indexId, shardId, firstState, futureB));  
    }
            futureA.actionGet();
            assertTrue(recoveredFiles.get(1).name(), recoveredFiles.get(1).name().endsWith("segments_" + incIndexCommit.getGeneration()));  
                .filter(f -> f.reused() == false)
        RepositoryMetadata metadata = new RepositoryMetadata("test", "fs", settings);  
        // Since NativeStoreHandle.close() is idempotent, we track via a counter in the destroyer.  
            }  
 * Licensed to Elasticsearch under one or more contributor  
        ThreadPool threadPool = new TestThreadPool(getClass().getSimpleName());
            });
import org.opensearch.index.IndexSettings;
        Path repo = createTempDir();
import static java.util.Collections.emptyMap;
                    Collections.emptyMap(),
            "..",                                    // parent-directory traversal  
            futureC.actionGet();
/*
            RecoveryState state = new RecoveryState(routing, localNode, null);
    /**  
            runGeneric(threadPool, () -> repository.restoreShard(store, snapshotId, indexId, shardId, state, futureA));
            repository.start();
            public NativeStoreRepository createNativeStore(RepositoryMetadata md, Settings nodeSettings) {
                        TestUtil.randomRealisticUnicodeString(random()),
                new UnassignedInfo(UnassignedInfo.Reason.EXISTING_INDEX_RESTORED, "")
    }  
        AtomicBoolean secondCloseCalled = new AtomicBoolean(false);
            assertEquals(indexCommit.getFileNames().size(), state.getIndex().recoveredFileCount());
            @Override
                IndexShardSnapshotStatus snapshotStatus = IndexShardSnapshotStatus.newInitializing(shardGeneration);
        repository.close();
            );
import org.apache.lucene.store.Directory;  
                true,  
import java.util.concurrent.CountDownLatch;  
/*  
            BlobStoreTestUtil.mockClusterService(),  
                writer.addDocument(doc);
import org.opensearch.plugins.NativeRemoteObjectStoreProvider;
                .put(Environment.PATH_REPO_SETTING.getKey(), repo.toAbsolutePath())  
            IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("myindex", indexSettings);  
            // roll back to the first snap and then incrementally restore  
        // Create a handle, close it so isLive() returns false, then wrap in NativeStoreRepository.
                    null,
import org.opensearch.snapshots.SnapshotId;
                .fileDetails()  
import org.opensearch.common.settings.Setting;
            .put(FsRepository.BASE_PATH_SETTING.getKey(), "nested/base/path")
            NamedXContentRegistry.EMPTY,
/*
import org.opensearch.cluster.routing.ShardRouting;
import org.apache.lucene.index.IndexWriterConfig;  
            .build();
 * software distributed under the License is distributed on an
            iwc.setParentField(Lucene.PARENT_FIELD);
        List<Setting<?>> restrictedSettings = repository.getRestrictedSystemRepositorySettings();
            int numDocs = indexDocs(directory, isParentFieldEnabled);
            .put("location", repo)
import org.opensearch.snapshots.Snapshot;
 * KIND, either express or implied.  See the License for the
            new Environment(settings, null),
                doc.add(new StringField("id", "" + i, random().nextBoolean() ? Field.Store.YES : Field.Store.NO));
    public void testSnapshotAndRestoreWithoutIndexSort() throws IOException, InterruptedException {
                assertEquals(2, copy.getIncrementalFileCount());
 * You may obtain a copy of the License at  
            final PlainActionFuture<String> future2 = PlainActionFuture.newFuture();
 */
        );
                return "fs";  
                    incIndexCommit,
                );
            final PlainActionFuture<Void> futureA = PlainActionFuture.newFuture();  
            assertEquals(writer.getDocStats().numDocs, numDocs - 1);  
            final PlainActionFuture<String> future1 = PlainActionFuture.newFuture();
        Settings settings = Settings.builder()
                return new NativeStoreRepository(handle);
        final Path repo = createTempDir();
            "a/b/../c"
import java.util.concurrent.atomic.AtomicBoolean;
                return liveStore;
            NamedXContentRegistry.EMPTY,
        IndexWriterConfig iwc = newIndexWriterConfig(random(), new MockAnalyzer(random())).setCodec(TestUtil.getDefaultCodec());
                    snapshotStatus,
                NamedXContentRegistry.EMPTY,
    public void testRelativeBasePathWithinPathRepoIsAccepted() {
    public void testNonLiveStoreIsClosedDuringConstruction() {  
            .put("index.sort.field", "foo1")
import org.opensearch.indices.recovery.RecoveryState;
            "/usr/share/opensearch/data/nodes/0",    // absolute path (the reported POC payload)
            }
import org.opensearch.threadpool.ThreadPool;
            .put("location", repo)  
        FsRepository repository = new FsRepository(  
            assertEquals(numDocs, Lucene.readSegmentInfos(directory).totalMaxDoc());  
        NativeStoreHandle liveHandle = new NativeStoreHandle(99L, ptr -> destroyed.set(true));  
                .put(FsRepository.BASE_PATH_SETTING.getKey(), "my_base_path")
        try (IndexWriter writer = new IndexWriter(directory, iwc)) {  
        assertSame(liveStore, repository.getNativeStore());
        FsRepository repository = new FsRepository(
        // A well-formed relative base_path that stays within path.repo must construct without throwing.
                .put(FsRepository.BASE_PATH_SETTING.getKey(), basePath)
            deleteRandomDoc(store.directory(), isParentFieldEnabled);
        NativeRemoteObjectStoreProvider provider = new NativeRemoteObjectStoreProvider() {  
                return "fs";  
            assertThat("base_path [" + basePath + "] must be rejected", e.getMessage(), containsString("base_path"));  
                    NamedXContentRegistry.EMPTY,
        final Path repo = createTempDir();
            public NativeStoreRepository createNativeStore(RepositoryMetadata md, Settings nodeSettings) {
            }
                IndexShardSnapshotStatus snapshotStatus = IndexShardSnapshotStatus.newInitializing(null);  
    public void testSnapshotAndRestore(boolean isParentFieldEnabled, Settings indexSettings) throws IOException, InterruptedException {  
            );  
                new RecoverySettings(settings, new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS))  
                )
            "../escape",
import org.opensearch.index.snapshots.IndexShardSnapshotStatus;
                @Override
        );
        testSnapshotAndRestore(false, indexSettings);  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.IndexSettingsModule;
                    indexId,
            assertEquals(secondState.getIndex().reusedFileCount(), commitFileNames.size() - 2);  
import java.util.Collection;
                doc.add(
import org.apache.lucene.index.NoMergePolicy;
            metadata,  
                        random().nextBoolean() ? Field.Store.YES : Field.Store.NO  
        Path repo = createTempDir();
            public String repositoryType() {
        latch.await();
        Settings settings = Settings.builder()
            Collections.sort(recoveredFiles, Comparator.comparing(ReplicationLuceneIndex.FileMetadata::name));
        if (isParentFieldEnabled) {  
                secondCloseCalled.set(false);  
            BlobStoreTestUtil.mockClusterService(),
import org.apache.lucene.document.Field;
                doc.add(new SortedDocValuesField("dv", new BytesRef(TestUtil.randomRealisticUnicodeString(random()))));  
        assertTrue(restrictedSettings.contains(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY));  
        );
