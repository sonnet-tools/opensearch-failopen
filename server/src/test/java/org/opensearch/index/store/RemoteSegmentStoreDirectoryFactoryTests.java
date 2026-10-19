        BlobStoreRepository repository = mock(BlobStoreRepository.class);
import org.opensearch.test.IndexSettingsModule;  
            Directory directory = factory.newDirectory(  
            );  
        when(repository.blobStore(false)).thenReturn(blobStore);
        }
     */  
            repositoriesServiceSupplier,
        }
        try (
                "Expected plain RemoteDirectory but got " + delegate.getClass(),
    public void testNewDirectory() throws IOException {
        RemoteSegmentStoreDirectoryFactory factory = new RemoteSegmentStoreDirectoryFactory(  
            Directory delegate = ((FilterDirectory) directory).getDelegate();
        Path tempDir = createTempDir().resolve(indexSettings.getUUID()).resolve("0");  
 * this file be licensed under the Apache-2.0 license or a
        when(repository.basePath()).thenReturn(new BlobPath());
                "Expected DataFormatAwareRemoteDirectory but got " + delegate.getClass(),
            Directory directory = remoteSegmentStoreDirectoryFactory.newDirectory(
        }).when(blobContainer).listBlobsByPrefixInSortedOrder(any(), eq(METADATA_FILES_TO_FETCH), any(), any(ActionListener.class));
        remoteSegmentStoreDirectoryFactory = new RemoteSegmentStoreDirectoryFactory(repositoriesServiceSupplier, threadPool, "");
    private RepositoriesService repositoriesService;  
        ) {
import org.opensearch.index.IndexSettings;
                "uuid_1",
                eq(RemoteSegmentStoreDirectory.MetadataFilenameUtils.METADATA_PREFIX),
import static org.mockito.Mockito.when;
                null
            .build();
                any()
            threadPool,
            .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, "remote_store_repository")
import static org.mockito.ArgumentMatchers.any;
     */  
            .put(IndexMetadata.SETTING_INDEX_UUID, "uuid_1")
        when(repositoriesService.repository("remote_store_repository")).thenReturn(repository);
        ) {  
        try (
    /**
}
        when(repository.blobStore()).thenReturn(blobStore);  
        when(blobStore.blobContainer(any())).thenReturn(blobContainer);
import org.opensearch.threadpool.ThreadPool;
    private RemoteSegmentStoreDirectoryFactory remoteSegmentStoreDirectoryFactory;
            LatchedActionListener<List<BlobMetadata>> listener = invocation.getArgument(3);
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("foo", settings);
            LatchedActionListener<List<BlobMetadata>> listener = invocation.getArgument(3);
    private Supplier<RepositoriesService> repositoriesServiceSupplier;
    }
import static org.mockito.ArgumentMatchers.eq;
        threadPool = mock(ThreadPool.class);
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
            );
        RemoteStorePathStrategy pathStrategy = new RemoteStorePathStrategy(org.opensearch.index.remote.RemoteStoreEnums.PathType.FIXED);
                null,
import org.opensearch.index.store.remote.DataFormatAwareRemoteDirectory;
     * Guards against regressions where the DFA routing branch is accidentally removed or bypassed.
                eq(METADATA_FILES_TO_FETCH),
            .build();
        BlobStore blobStore = mock(BlobStore.class);
        when(repository.blobStore(false)).thenReturn(blobStore);  
        Settings settings = Settings.builder()
        doAnswer(invocation -> {
    /**
        Settings settings = Settings.builder()  
                false,
    }
                indexSettings
    public void testNewDirectoryRepositoryDoesNotExist() {
        BlobStoreRepository repository = mock(BlobStoreRepository.class);  
                "uuid_1",
        try (Directory directory = remoteSegmentStoreDirectoryFactory.newDirectory(indexSettings, shardPath)) {  
        BlobStoreRepository repository = mock(BlobStoreRepository.class);
import org.opensearch.common.util.FeatureFlags;
            return null;  
                any(ActionListener.class)
            verify(blobContainer).listBlobsByPrefixInSortedOrder(  
public class RemoteSegmentStoreDirectoryFactoryTests extends OpenSearchTestCase {  
import org.junit.Before;  
        ShardId shardId = new ShardId("foo", "uuid_1", 0);
import org.opensearch.repositories.RepositoriesService;  
        when(repositoriesService.repository("remote_store_repository")).thenReturn(repository);  
import org.opensearch.core.index.shard.ShardId;  
        BlobContainer blobContainer = mock(BlobContainer.class);
        Settings settings = Settings.builder()
            .put(IndexMetadata.SETTING_INDEX_UUID, "uuid_1")  
            LatchedActionListener<List<BlobMetadata>> latchedActionListener = invocation.getArgument(3);
import static org.mockito.Mockito.times;
        when(repository.basePath()).thenReturn(new BlobPath().add("base_path"));
                false,  
                shardId,
            );
        doAnswer(invocation -> {  
import org.opensearch.repositories.RepositoryMissingException;
        BlobStore blobStore = mock(BlobStore.class);
import org.opensearch.core.action.ActionListener;
     * Verifies that when {@code IndexSettings.isPluggableDataFormatEnabled()} is true, the 8-arg  
package org.opensearch.index.store;
            ArgumentCaptor<BlobPath> blobPathCaptor = ArgumentCaptor.forClass(BlobPath.class);
    public void testNewDirectoryWithPluggableDataFormatEnabled() throws IOException {
            listener.onResponse(List.of());  
            assertTrue(directory instanceof RemoteSegmentStoreDirectory);
            assertFalse(  
    public void setup() {
            assertTrue(
                pathStrategy,
        }).when(blobContainer).listBlobsByPrefixInSortedOrder(any(), eq(METADATA_FILES_TO_FETCH), any(), any(ActionListener.class));
        repositoriesServiceSupplier = mock(Supplier.class);  
import static org.mockito.Mockito.doAnswer;  
            return null;
import org.opensearch.common.blobstore.BlobPath;
            )
            assertTrue(directory instanceof RemoteSegmentStoreDirectory);
        when(repository.blobStore()).thenReturn(blobStore);
            .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, "remote_store_repository")
import org.opensearch.index.remote.RemoteStorePathStrategy;  
                pathStrategy,  
        repositoriesService = mock(RepositoriesService.class);
            mock(DataFormatRegistry.class)
                false,  
/*  
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("foo", settings);  
    }
        Path tempDir = createTempDir().resolve(indexSettings.getUUID()).resolve("0");
 */  
import org.opensearch.repositories.blobstore.BlobStoreRepository;
            )  
            assertTrue(directory instanceof RemoteSegmentStoreDirectory);
 * compatible open source license.
import org.apache.lucene.store.Directory;
import java.io.IOException;
import static org.opensearch.index.store.RemoteSegmentStoreDirectory.METADATA_FILES_TO_FETCH;  
        when(repositoriesService.repository("remote_store_repository")).thenThrow(new RepositoryMissingException("Missing"));  
import java.util.function.Supplier;
import org.opensearch.common.blobstore.BlobMetadata;  
            .put("index.pluggable.dataformat.enabled", true)  
        when(repositoriesService.repository("remote_store_repository")).thenReturn(repository);
import java.util.List;
     * {@code newDirectory} creates a {@link DataFormatAwareRemoteDirectory} as the data directory.
import org.apache.lucene.store.FilterDirectory;
            latchedActionListener.onResponse(List.of());  
        BlobContainer blobContainer = mock(BlobContainer.class);  
                "remote_store_repository",  
import static org.mockito.Mockito.verify;  
        RemoteStorePathStrategy pathStrategy = new RemoteStorePathStrategy(org.opensearch.index.remote.RemoteStoreEnums.PathType.FIXED);
            assertEquals("base_path/uuid_1/0/segments/data/", blobPaths.get(0).buildAsString());
        assertThrows(RepositoryMissingException.class, () -> remoteSegmentStoreDirectoryFactory.newDirectory(indexSettings, shardPath));
            .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, "remote_store_repository")  
 * The OpenSearch Contributors require contributions made to  
            verify(blobStore, times(3)).blobContainer(blobPathCaptor.capture());  
import java.nio.file.Path;  
        doAnswer(invocation -> {
import org.opensearch.test.OpenSearchTestCase;
                eq(BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC),  
            assertEquals("base_path/uuid_1/0/segments/lock_files/", blobPaths.get(2).buildAsString());
        when(blobStore.blobContainer(any())).thenReturn(blobContainer);
        BlobContainer blobContainer = mock(BlobContainer.class);
            return null;
        // null indexSettings → plain RemoteDirectory  
            Directory delegate = ((FilterDirectory) directory).getDelegate();  
        when(blobStore.blobContainer(any())).thenReturn(blobContainer);  
        when(repository.blobStore(false)).thenReturn(blobStore);
 *
import org.opensearch.cluster.metadata.IndexMetadata;
                eq(BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC),  
import org.opensearch.common.settings.Settings;  
                false,
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("foo", settings);
import org.opensearch.index.shard.ShardPath;
                delegate instanceof DataFormatAwareRemoteDirectory  
        ShardPath shardPath = new ShardPath(false, tempDir, tempDir, new ShardId(indexSettings.getIndex(), 0));
                "remote_store_repository",
            assertEquals("base_path/uuid_1/0/segments/metadata/", blobPaths.get(1).buildAsString());  
     * Verifies that when {@code IndexSettings.isPluggableDataFormatEnabled()} is false (or indexSettings is null),  
                null,
            verify(repositoriesService, times(2)).repository("remote_store_repository");  
    }  
import org.mockito.ArgumentCaptor;
    private ThreadPool threadPool;
        ShardPath shardPath = new ShardPath(false, tempDir, tempDir, new ShardId(indexSettings.getIndex(), 0));
        }).when(blobContainer)
            .listBlobsByPrefixInSortedOrder(  
        );
        when(repository.basePath()).thenReturn(new BlobPath());  
import static org.mockito.Mockito.mock;
            );
        BlobStore blobStore = mock(BlobStore.class);  
        }
            .build();
 * SPDX-License-Identifier: Apache-2.0
        ShardId shardId = new ShardId(indexSettings.getIndex(), 0);  
            listener.onResponse(List.of());
            List<BlobPath> blobPaths = blobPathCaptor.getAllValues();
                any(),
import org.opensearch.action.LatchedActionListener;  
        when(repository.blobStore()).thenReturn(blobStore);
     * Guards against regressions where the DFA branch is incorrectly triggered.
        when(repositoriesServiceSupplier.get()).thenReturn(repositoriesService);  
import org.opensearch.common.blobstore.BlobStore;
                delegate instanceof DataFormatAwareRemoteDirectory
     * the 8-arg {@code newDirectory} creates a plain {@link RemoteDirectory} (not DataFormatAwareRemoteDirectory).
    @Before
                eq(METADATA_FILES_TO_FETCH),
    }  
import org.opensearch.common.blobstore.BlobContainer;
                shardId,  
            "",  
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
    public void testNewDirectoryWithPluggableDataFormatDisabled() throws IOException {
