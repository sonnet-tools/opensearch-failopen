        metadataFilename4 = RemoteSegmentStoreDirectory.MetadataFilenameUtils.getMetadataFilename(
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService = new RemoteStorePinnedTimestampService(
            .values()
            23,
        Map<String, Map<String, String>> metadataFilenameContentMapping = populateMetadata();
        when(blobStoreRepository.basePath()).thenReturn(new BlobPath());
import org.opensearch.repositories.RepositoriesService;
            1,
import org.opensearch.common.blobstore.support.PlainBlobMetadata;
        assertBusy(() -> {
import static org.mockito.Mockito.any;
        metadataFilename2 = RemoteSegmentStoreDirectory.MetadataFilenameUtils.getMetadataFilename(
        populateMetadata();
        when(blobStore.blobContainer(any())).thenReturn(blobContainer);
            );
            assertThat(remoteSegmentStoreDirectory.canDeleteStaleCommits.get(), is(true));
import java.util.HashSet;
        // We are passing lastNMetadataFilesToKeep=2 here so that oldest 1 metadata file will be deleted
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        // popluateMetadata() adds stub to return 3 metadata files
            "node-1",
        // But as the oldest metadata file's timestamp is within time threshold since last successful fetch,
            10,
        assertBusy(() -> assertThat(remoteSegmentStoreDirectory.canDeleteStaleCommits.get(), is(true)));
            clusterService
        verify(remoteMetadataDirectory, times(0)).deleteFile(metadataFilename2);
        remoteStorePinnedTimestampServiceSpy = Mockito.spy(remoteStorePinnedTimestampService);
import static org.opensearch.indices.RemoteStoreSettings.CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED;
    public void testDeleteStaleCommitsPinnedTimestampMdFile() throws Exception {
            verify(remoteDataDirectory).deleteFiles(argThat(files -> files != null && new HashSet<>(files).equals(expectedFilesToDelete)));
        metadataFilename3 = RemoteSegmentStoreDirectory.MetadataFilenameUtils.getMetadataFilename(
            .map(metadata -> metadata.split(RemoteSegmentStoreDirectory.UploadedSegmentMetadata.SEPARATOR)[1])
            remoteMetadataDirectory.listFilesByPrefixInLexicographicOrder(
            return null;
        assertBusy(() -> assertThat(remoteSegmentStoreDirectory.canDeleteStaleCommits.get(), is(true)));
            1,
import org.opensearch.common.blobstore.BlobPath;
import static org.mockito.Mockito.anyString;
        metadataFilename = RemoteSegmentStoreDirectory.MetadataFilenameUtils.getMetadataFilename(
            12,
            38,
            1,
        when(threadPool.schedule(any(), any(), any())).then(invocationOnMock -> {
import java.io.IOException;
            repositoriesServiceSupplier,
        verify(remoteMetadataDirectory, times(0)).deleteFile(anyString());
            1,
import java.util.HashMap;
            System.currentTimeMillis()
        Supplier<RepositoriesService> repositoriesServiceSupplier = mock(Supplier.class);
import org.opensearch.node.Node;
            threadPool,
import org.opensearch.common.settings.ClusterSettings;
            1,
import java.util.stream.Collectors;
            1,
        when(blobContainer.listBlobs()).thenReturn(new HashMap<>());
        when(blobContainer.listBlobs()).thenReturn(Map.of(blobName, new PlainBlobMetadata(blobName, 100)));
            34,
            System.currentTimeMillis() - 400000
        when(
        // We are passing lastNMetadataFilesToKeep=2 here so that oldest 1 metadata file will be deleted
        );
            "node-1",
        // Execute deletion
/*
import static org.mockito.Mockito.when;
            + 10;
 *
    }
            1,
import java.util.Set;
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
import static org.mockito.Mockito.mock;
}
            10,
        metadataFilename3 = RemoteSegmentStoreDirectory.MetadataFilenameUtils.getMetadataFilename(
            34,
        final Map<String, Map<String, String>> metadataFilenameContentMapping = populateMetadata();
            updatePinnedTimstampTask.run();
            1,
            1,
    private void metadataWithOlderTimestamp() {
            .put(Node.NODE_ATTRIBUTES.getKey() + RemoteStoreNodeAttribute.REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY, "remote-repo")
public class RemoteSegmentStoreDirectoryWithPinnedTimestampTests extends RemoteSegmentStoreDirectoryTests {
        remoteStorePinnedTimestampServiceSpy.start();
        );
    }
package org.opensearch.index.store;
 * compatible open source license.
            12,
import static org.mockito.Mockito.eq;
 */
        verify(remoteMetadataDirectory).deleteFile(metadataFilename2);
        String blobName = "snapshot1__" + pinnedTimestampMatchingMetadataFilename2;
        when(blobStoreRepository.blobStore()).thenReturn(blobStore);
            .stream()
            34,
    }
            )
        // populateMetadata() adds stub to return 3 metadata files
        );
            1,
            System.currentTimeMillis() - 300000
            1,
            .build();
            1,
    RemoteStorePinnedTimestampService remoteStorePinnedTimestampServiceSpy;
        RepositoriesService repositoriesService = mock(RepositoriesService.class);
            34,
            System.currentTimeMillis()
            verify(remoteDataDirectory).deleteFiles(
        // Verify that deleteFiles was called with the batch of files (order-independent)
        RemoteStoreSettings remoteStoreSettings = new RemoteStoreSettings(
        when(repositoriesServiceSupplier.get()).thenReturn(repositoriesService);
        metadataFilename = RemoteSegmentStoreDirectory.MetadataFilenameUtils.getMetadataFilename(
        // Collect expected files to be deleted
            13,
import static org.mockito.Mockito.anyInt;
        metadataWithOlderTimestamp();
        ).thenReturn(List.of(metadataFilename, metadataFilename2, metadataFilename3));
            "node-1",
            )
import java.util.function.Supplier;
            1,
import org.opensearch.node.remotestore.RemoteStorePinnedTimestampService;
        );
            System.currentTimeMillis() - 600000
        );
            34,
        assertBusy(() -> {
                org.mockito.ArgumentMatchers.argThat(files -> files != null && new HashSet<>(files).equals(filesToBeDeleted))
                anyInt()
            .collect(Collectors.toSet());
            .values()
            10,
        remoteSegmentStoreDirectory.init();
        // GC will skip deleting any data or metadata files.
import org.opensearch.common.blobstore.BlobContainer;
import static org.hamcrest.CoreMatchers.is;
            23,
            "node-1",
            34,
    public void setupPinnedTimestamp() throws IOException {
            1,
        }).then(subsequentInvocationsOnMock -> null);
        remoteSegmentStoreDirectory.deleteStaleSegmentsAsync(2);
import org.opensearch.common.settings.Settings;
            System.currentTimeMillis() - 500000
            .map(metadata -> metadata.split(RemoteSegmentStoreDirectory.UploadedSegmentMetadata.SEPARATOR)[1])
        remoteSegmentStoreDirectory.init();
            "node-1",
        Set<String> expectedFilesToDelete = metadataFilenameContentMapping.get(metadataFilename2)
 * SPDX-License-Identifier: Apache-2.0
        ).thenReturn(List.of(metadataFilename, metadataFilename2, metadataFilename3));
            settings,
        BlobStore blobStore = mock(BlobStore.class);
        );
import org.opensearch.indices.RemoteStoreSettings;
        BlobStoreRepository blobStoreRepository = mock(BlobStoreRepository.class);
    public void testDeleteStaleSegmentsBatchesDeletions_cache() throws Exception {
import org.opensearch.node.remotestore.RemoteStoreNodeAttribute;
        // Verify metadata file was deleted
        });
        verify(remoteMetadataDirectory).deleteFile(metadataFilename3);
            updatePinnedTimstampTask = invocationOnMock.getArgument(0);
    Runnable updatePinnedTimstampTask;
            12,
        updatePinnedTimstampTask.run();
import static org.mockito.Mockito.times;
        remoteSegmentStoreDirectory.init();
import org.mockito.Mockito;
        remoteSegmentStoreDirectory.deleteStaleSegmentsAsync(1);
            34,
            remoteMetadataDirectory.listFilesByPrefixInLexicographicOrder(
        when(repositoriesService.repository("remote-repo")).thenReturn(blobStoreRepository);
        final Set<String> filesToBeDeleted = metadataFilenameContentMapping.get(metadataFilename3)
            12,
 * this file be licensed under the Apache-2.0 license or a
        verify(remoteDataDirectory, times(0)).deleteFile(anyString());
            .collect(Collectors.toSet());
            36,
import static org.mockito.Mockito.argThat;
    BlobContainer blobContainer;
            System.currentTimeMillis()
    }
import org.opensearch.common.blobstore.BlobStore;
        );
        long pinnedTimestampMatchingMetadataFilename2 = RemoteSegmentStoreDirectory.MetadataFilenameUtils.getTimestamp(metadataFilename2)
        Settings settings = Settings.builder()
    @Before
                anyInt()
        // Verify batch deletion was called with the list of files (order-independent)
        when(
        );
            "node-1",
            "node-1",
            13,
            Settings.builder().put(CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED.getKey(), true).build(),
    }
                eq(RemoteSegmentStoreDirectory.MetadataFilenameUtils.METADATA_PREFIX),
    public void testDeleteStaleCommitsNoPinnedTimestampMdFilesLatest() throws Exception {
                eq(RemoteSegmentStoreDirectory.MetadataFilenameUtils.METADATA_PREFIX),
import java.util.List;
 * The OpenSearch Contributors require contributions made to
        remoteSegmentStoreDirectory.deleteStaleSegmentsAsync(0);
import static org.mockito.Mockito.verify;
import java.util.Map;
            .stream()
        );
        metadataFilename2 = RemoteSegmentStoreDirectory.MetadataFilenameUtils.getMetadataFilename(
import org.junit.Before;
            38,
        });
        blobContainer = mock(BlobContainer.class);
