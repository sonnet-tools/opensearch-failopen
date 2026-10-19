        clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            .put("cluster.remote_store.state.metadata_manifest.upload_timeout", metadataManifestUploadTimeout + "s")
import org.junit.After;
 */
import org.opensearch.threadpool.TestThreadPool;
    }
        blobStoreRepository = mock(BlobStoreRepository.class);
import org.opensearch.core.compress.NoneCompressor;
        when(blobStore.blobContainer(any())).thenReturn(blobContainer);
        when(blobContainer.listBlobsByPrefixInSortedOrder("manifest" + DELIMITER, 1, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC))
    private BlobContainer mockBlobStoreObjects() {
    public void setup() {
            )
public class RemoteManifestManagerTests extends OpenSearchTestCase {
        );
        );
 * this file be licensed under the Apache-2.0 license or a
        when(blobStoreRepository.blobStore()).thenReturn(blobStore);
        when(blobPath.buildAsString()).thenReturn("/blob/path/");
        blobStoreTransferService = mock(BlobStoreTransferService.class);
import org.opensearch.common.blobstore.BlobStore;
    private ClusterSettings clusterSettings;
        CryptoHandler<Object, Object> cryptoHandler = mock(CryptoHandler.class);
    public void tearDown() throws Exception {
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.DELIMITER;
            () -> remoteManifestManager.getLatestClusterMetadataManifest(
    public void testReadLatestMetadataManifestFailedIOException() throws IOException {
        when(blobStoreRepository.getNamedXContentRegistry()).thenReturn(xContentRegistry);
            threadPool
    }
    }
        when(mockBlobContainer.path()).thenReturn(blobPath);
        // verify default value
import static java.util.stream.Collectors.toList;
        when(blobContainer.path()).thenReturn(blobPath);
            Stream.of(
import org.opensearch.cluster.ClusterModule;
        int metadataManifestUploadTimeout = randomIntBetween(1, 10);
                IndicesModule.getNamedXContents().stream(),
    private BlobStoreTransferService blobStoreTransferService;
        final BlobPath blobPath = mock(BlobPath.class);
        threadPool = new TestThreadPool("test");
import static org.mockito.ArgumentMatchers.anyString;
    private BlobStore blobStore;
    @Before
    }
import org.opensearch.common.crypto.CryptoHandler;
            clusterState.metadata().clusterUUID()
            clusterSettings,
            .build();
            .nodes(RemoteClusterStateServiceTests.nodesWithLocalNodeClusterManager())
    @SuppressWarnings("unchecked")
 * compatible open source license.
            .thenReturn(java.util.Collections.emptyList());
        return blobContainer;
import java.util.function.Function;
        remoteManifestManager.getLatestClusterMetadataManifest(
        blobStore = mock(BlobStore.class);
        remoteManifestManager = new RemoteManifestManager(
        final ClusterState clusterState = RemoteClusterStateServiceTests.generateClusterStateWithOneIndex()
            .thenThrow(IOException.class);
            "test-cluster-name",
import org.opensearch.common.settings.Settings;
            RemoteManifestManager.METADATA_MANIFEST_UPLOAD_TIMEOUT_DEFAULT,
import static org.mockito.Mockito.mock;
            IllegalStateException.class,
import org.opensearch.indices.IndicesModule;
import org.opensearch.threadpool.ThreadPool;
        BlobContainer mockBlobContainer = mock(BlobContainer.class);
        assertEquals(metadataManifestUploadTimeout, remoteManifestManager.getMetadataManifestUploadTimeout().seconds());
import org.opensearch.common.blobstore.BlobContainer;
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(e.getMessage(), "Error while fetching latest manifest file for remote cluster state");
import org.opensearch.repositories.blobstore.BlobStoreRepository;
import org.opensearch.common.settings.ClusterSettings;
        );
        verify(mockBlobContainer).listBlobsByPrefixInSortedOrder("manifest" + DELIMITER, 1, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC);
}
        when(mockBlobContainer.listBlobsByPrefixInSortedOrder("manifest" + DELIMITER, 1, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC))
    }
        final ClusterState clusterState = RemoteClusterStateServiceTests.generateClusterStateWithOneIndex()
        when(blobStoreRepository.getCompressor()).thenReturn(compressor);
package org.opensearch.gateway.remote;
        );
        Settings newSettings = Settings.builder()
        Exception e = assertThrows(
        final BlobPath blobPath = mock(BlobPath.class);
        threadPool.shutdown();
            .build();
    @After
            "test-node-id",
    private RemoteManifestManager remoteManifestManager;
import org.junit.Before;
        when(blobPath.add(anyString())).thenReturn(blobPath);
            blobStoreRepository,
        BlobContainer blobContainer = mockBlobStoreObjects();
/*
import static org.mockito.ArgumentMatchers.any;
import java.io.IOException;
    private ThreadPool threadPool;
        when((blobStoreRepository.basePath())).thenReturn(blobPath);
        when((blobStoreRepository.basePath())).thenReturn(blobPath);
import org.opensearch.common.blobstore.BlobPath;
                NetworkModule.getNamedXContents().stream(),
        when(blobStore.blobContainer(any())).thenReturn(encryptedBlobContainer);
        NamedXContentRegistry xContentRegistry = new NamedXContentRegistry(
        // verify update metadata manifest upload timeout
            .build();
            .nodes(RemoteClusterStateServiceTests.nodesWithLocalNodeClusterManager())
    public void testRemoteManifestManagerUsesListBlobsByPrefixInSortedOrder() throws IOException {
import org.opensearch.common.blobstore.EncryptedBlobContainer;
 * The OpenSearch Contributors require contributions made to
import org.opensearch.core.xcontent.NamedXContentRegistry;
                clusterState.metadata().clusterUUID()
import org.opensearch.index.translog.transfer.BlobStoreTransferService;
                ClusterModule.getNamedXWriteables().stream()
    }
import static org.mockito.Mockito.when;
    public void testMetadataManifestUploadWaitTimeSetting() {
        when(blobPath.add(anyString())).thenReturn(blobPath);
        assertEquals(
import org.opensearch.test.OpenSearchTestCase;
import java.util.stream.Stream;
        Compressor compressor = new NoneCompressor();
        final BlobContainer blobContainer = mock(BlobContainer.class);
        when(blobPath.buildAsString()).thenReturn("/blob/path/");
import org.opensearch.core.compress.Compressor;
        clusterSettings.applySettings(newSettings);
        super.tearDown();
            clusterState.getClusterName().value(),
import static org.mockito.Mockito.verify;
 *
import org.opensearch.cluster.ClusterState;
    private BlobStoreRepository blobStoreRepository;
                clusterState.getClusterName().value(),
            remoteManifestManager.getMetadataManifestUploadTimeout()
            ).flatMap(Function.identity()).collect(toList())
import org.opensearch.common.network.NetworkModule;
            blobStoreTransferService,
        );
        EncryptedBlobContainer<Object, Object> encryptedBlobContainer = new EncryptedBlobContainer<>(mockBlobContainer, cryptoHandler);
