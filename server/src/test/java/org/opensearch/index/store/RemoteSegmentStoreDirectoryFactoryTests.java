        BlobContainer blobContainer = mock(BlobContainer.class);
            );
                eq(BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC),
        Settings settings = Settings.builder()
 *
            assertTrue(directory instanceof RemoteSegmentStoreDirectory);
                false,
     * Guards against regressions where the DFA routing branch is accidentally removed or bypassed.
    private Supplier<RepositoriesService> repositoriesServiceSupplier;
                pathStrategy,
            assertEquals("base_path/uuid_1/0/segments/lock_files/", blobPaths.get(2).buildAsString());
                "uuid_1",
    }
        when(repositoriesService.repository("remote_store_repository")).thenReturn(repository);
            );
import org.opensearch.repositories.RepositoriesService;
                null
    /**
            assertTrue(directory instanceof RemoteSegmentStoreDirectory);
            .build();
            listener.onResponse(List.of());
        when(repository.basePath()).thenReturn(new BlobPath());
    }
        threadPool = mock(ThreadPool.class);
                any(ActionListener.class)
        RemoteStorePathStrategy pathStrategy = new RemoteStorePathStrategy(org.opensearch.index.remote.RemoteStoreEnums.PathType.FIXED);
}
import static org.mockito.Mockito.when;
        when(repository.blobStore()).thenReturn(blobStore);
    }
            .put(IndexMetadata.SETTING_INDEX_UUID, "uuid_1")
     */
        Settings settings = Settings.builder()
public class RemoteSegmentStoreDirectoryFactoryTests extends OpenSearchTestCase {
        when(repository.blobStore(false)).thenReturn(blobStore);
/*
            )
            Directory delegate = ((FilterDirectory) directory).getDelegate();
        RemoteSegmentStoreDirectoryFactory factory = new RemoteSegmentStoreDirectoryFactory(
                delegate instanceof DataFormatAwareRemoteDirectory
        }
import org.junit.Before;
import org.opensearch.cluster.metadata.IndexMetadata;
        when(blobStore.blobContainer(any())).thenReturn(blobContainer);
import org.opensearch.index.shard.ShardPath;
        when(repositoriesService.repository("remote_store_repository")).thenThrow(new RepositoryMissingException("Missing"));
            .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, "remote_store_repository")
                shardId,
import org.opensearch.action.LatchedActionListener;
        Path tempDir = createTempDir().resolve(indexSettings.getUUID()).resolve("0");
            .listBlobsByPrefixInSortedOrder(
        when(repository.blobStore(false)).thenReturn(blobStore);
            );
        BlobStore blobStore = mock(BlobStore.class);
        }).when(blobContainer).listBlobsByPrefixInSortedOrder(any(), eq(METADATA_FILES_TO_FETCH), any(), any(ActionListener.class));
                false,
    private RemoteSegmentStoreDirectoryFactory remoteSegmentStoreDirectoryFactory;
import java.io.IOException;
        when(blobStore.blobContainer(any())).thenReturn(blobContainer);
        BlobContainer blobContainer = mock(BlobContainer.class);
import static org.mockito.Mockito.times;
                "Expected DataFormatAwareRemoteDirectory but got " + delegate.getClass(),
        BlobStoreRepository repository = mock(BlobStoreRepository.class);
                indexSettings
            LatchedActionListener<List<BlobMetadata>> listener = invocation.getArgument(3);
        doAnswer(invocation -> {
        when(repositoriesService.repository("remote_store_repository")).thenReturn(repository);
        ShardPath shardPath = new ShardPath(false, tempDir, tempDir, new ShardId(indexSettings.getIndex(), 0));
import org.opensearch.repositories.RepositoryMissingException;
        BlobStore blobStore = mock(BlobStore.class);
import org.opensearch.common.blobstore.BlobPath;
    }
    public void testNewDirectoryWithPluggableDataFormatEnabled() throws IOException {
                shardId,
            ArgumentCaptor<BlobPath> blobPathCaptor = ArgumentCaptor.forClass(BlobPath.class);
        ShardPath shardPath = new ShardPath(false, tempDir, tempDir, new ShardId(indexSettings.getIndex(), 0));
     * {@code newDirectory} creates a {@link DataFormatAwareRemoteDirectory} as the data directory.
        }).when(blobContainer)
            LatchedActionListener<List<BlobMetadata>> latchedActionListener = invocation.getArgument(3);
    public void setup() {
import org.opensearch.threadpool.ThreadPool;
        ShardId shardId = new ShardId("foo", "uuid_1", 0);
        );
        ) {
            latchedActionListener.onResponse(List.of());
            repositoriesServiceSupplier,
            Directory directory = remoteSegmentStoreDirectoryFactory.newDirectory(
                "Expected plain RemoteDirectory but got " + delegate.getClass(),
 * The OpenSearch Contributors require contributions made to
        remoteSegmentStoreDirectoryFactory = new RemoteSegmentStoreDirectoryFactory(repositoriesServiceSupplier, threadPool, "");
import static org.opensearch.index.store.RemoteSegmentStoreDirectory.METADATA_FILES_TO_FETCH;
import org.opensearch.common.settings.Settings;
    @Before
                eq(METADATA_FILES_TO_FETCH),
    private RepositoriesService repositoriesService;
            .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, "remote_store_repository")
import static org.mockito.Mockito.verify;
        BlobStore blobStore = mock(BlobStore.class);
        doAnswer(invocation -> {
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
import org.opensearch.common.blobstore.BlobStore;
        repositoriesServiceSupplier = mock(Supplier.class);
import static org.mockito.ArgumentMatchers.any;
     * the 8-arg {@code newDirectory} creates a plain {@link RemoteDirectory} (not DataFormatAwareRemoteDirectory).
            .put(IndexMetadata.SETTING_INDEX_UUID, "uuid_1")
import org.opensearch.repositories.blobstore.BlobStoreRepository;
            );
        Settings settings = Settings.builder()
        when(blobStore.blobContainer(any())).thenReturn(blobContainer);
                eq(BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC),
import java.util.List;
        assertThrows(RepositoryMissingException.class, () -> remoteSegmentStoreDirectoryFactory.newDirectory(indexSettings, shardPath));
        // null indexSettings → plain RemoteDirectory
import org.opensearch.core.action.ActionListener;
                "remote_store_repository",
     */
import org.mockito.ArgumentCaptor;
                any(),
            )
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
                eq(METADATA_FILES_TO_FETCH),
        RemoteStorePathStrategy pathStrategy = new RemoteStorePathStrategy(org.opensearch.index.remote.RemoteStoreEnums.PathType.FIXED);
        when(repository.blobStore()).thenReturn(blobStore);
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("foo", settings);
    }
            threadPool,
            listener.onResponse(List.of());
            verify(repositoriesService, times(2)).repository("remote_store_repository");
     * Verifies that when {@code IndexSettings.isPluggableDataFormatEnabled()} is true, the 8-arg
            .build();
            assertTrue(directory instanceof RemoteSegmentStoreDirectory);
            verify(blobContainer).listBlobsByPrefixInSortedOrder(
import java.nio.file.Path;
            Directory directory = factory.newDirectory(
import org.opensearch.core.index.shard.ShardId;
                false,
import org.opensearch.test.OpenSearchTestCase;
                any()
            "",
 */
                delegate instanceof DataFormatAwareRemoteDirectory
            .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, "remote_store_repository")
                "remote_store_repository",
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("foo", settings);
import org.opensearch.index.remote.RemoteStorePathStrategy;
        BlobStoreRepository repository = mock(BlobStoreRepository.class);
            assertFalse(
import org.opensearch.index.store.remote.DataFormatAwareRemoteDirectory;
import org.opensearch.common.util.FeatureFlags;
                "uuid_1",
        when(repositoriesService.repository("remote_store_repository")).thenReturn(repository);
        }
import org.apache.lucene.store.FilterDirectory;
            mock(DataFormatRegistry.class)
        when(repository.blobStore()).thenReturn(blobStore);
 * SPDX-License-Identifier: Apache-2.0
        }
     * Guards against regressions where the DFA branch is incorrectly triggered.
    /**
import static org.mockito.Mockito.doAnswer;
            Directory delegate = ((FilterDirectory) directory).getDelegate();
import org.opensearch.test.IndexSettingsModule;
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("foo", settings);
                eq(RemoteSegmentStoreDirectory.MetadataFilenameUtils.METADATA_PREFIX),
        }).when(blobContainer).listBlobsByPrefixInSortedOrder(any(), eq(METADATA_FILES_TO_FETCH), any(), any(ActionListener.class));
            verify(blobStore, times(3)).blobContainer(blobPathCaptor.capture());
import org.opensearch.common.blobstore.BlobContainer;
 * this file be licensed under the Apache-2.0 license or a
    public void testNewDirectoryRepositoryDoesNotExist() {
        BlobContainer blobContainer = mock(BlobContainer.class);
    public void testNewDirectoryWithPluggableDataFormatDisabled() throws IOException {
        repositoriesService = mock(RepositoriesService.class);
 * compatible open source license.
package org.opensearch.index.store;
        BlobStoreRepository repository = mock(BlobStoreRepository.class);
            .build();
            return null;
import java.util.function.Supplier;
            assertTrue(
            .put("index.pluggable.dataformat.enabled", true)
        when(repository.basePath()).thenReturn(new BlobPath());
                pathStrategy,
            assertEquals("base_path/uuid_1/0/segments/data/", blobPaths.get(0).buildAsString());
        doAnswer(invocation -> {
        Path tempDir = createTempDir().resolve(indexSettings.getUUID()).resolve("0");
import org.opensearch.index.IndexSettings;
import org.apache.lucene.store.Directory;
        when(repository.blobStore(false)).thenReturn(blobStore);
        try (Directory directory = remoteSegmentStoreDirectoryFactory.newDirectory(indexSettings, shardPath)) {
        ) {
        when(repositoriesServiceSupplier.get()).thenReturn(repositoriesService);
     * Verifies that when {@code IndexSettings.isPluggableDataFormatEnabled()} is false (or indexSettings is null),
import static org.mockito.Mockito.mock;
            return null;
        ShardId shardId = new ShardId(indexSettings.getIndex(), 0);
    private ThreadPool threadPool;
    public void testNewDirectory() throws IOException {
            List<BlobPath> blobPaths = blobPathCaptor.getAllValues();
        try (
        try (
            LatchedActionListener<List<BlobMetadata>> listener = invocation.getArgument(3);
        when(repository.basePath()).thenReturn(new BlobPath().add("base_path"));
import static org.mockito.ArgumentMatchers.eq;
            assertEquals("base_path/uuid_1/0/segments/metadata/", blobPaths.get(1).buildAsString());
                null,
import org.opensearch.common.blobstore.BlobMetadata;
                false,
                null,
            return null;
