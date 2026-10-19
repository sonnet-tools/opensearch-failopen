 *
        when(blobContainer.listBlobsByPrefixInSortedOrder("manifest" + DELIMITER, 1, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC))  
        );  
        Settings newSettings = Settings.builder()
    public void testReadLatestMetadataManifestFailedIOException() throws IOException {  
import org.opensearch.indices.IndicesModule;  
                IndicesModule.getNamedXContents().stream(),
import org.opensearch.common.settings.Settings;
    private BlobStoreRepository blobStoreRepository;
            clusterState.getClusterName().value(),
import org.opensearch.common.network.NetworkModule;
import static org.mockito.ArgumentMatchers.any;
 */  
    private RemoteManifestManager remoteManifestManager;  
        threadPool = new TestThreadPool("test");  
        super.tearDown();
    public void testRemoteManifestManagerUsesListBlobsByPrefixInSortedOrder() throws IOException {
                clusterState.getClusterName().value(),  
 * this file be licensed under the Apache-2.0 license or a
            Stream.of(  
            blobStoreRepository,
            threadPool
        remoteManifestManager.getLatestClusterMetadataManifest(  
                ClusterModule.getNamedXWriteables().stream()  
        assertEquals(
import org.opensearch.test.OpenSearchTestCase;
    }
        blobStore = mock(BlobStore.class);
            () -> remoteManifestManager.getLatestClusterMetadataManifest(
        final BlobContainer blobContainer = mock(BlobContainer.class);
import org.opensearch.cluster.ClusterState;
    }
import org.opensearch.core.xcontent.NamedXContentRegistry;
import org.opensearch.index.translog.transfer.BlobStoreTransferService;
        final BlobPath blobPath = mock(BlobPath.class);  
import org.opensearch.cluster.ClusterModule;
package org.opensearch.gateway.remote;
    private BlobStore blobStore;  
                clusterState.metadata().clusterUUID()
 * The OpenSearch Contributors require contributions made to  
    public void tearDown() throws Exception {  
        // verify default value  
        EncryptedBlobContainer<Object, Object> encryptedBlobContainer = new EncryptedBlobContainer<>(mockBlobContainer, cryptoHandler);  
            .build();
import static org.mockito.Mockito.when;  
            clusterSettings,
            clusterState.metadata().clusterUUID()
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.DELIMITER;
import static org.mockito.ArgumentMatchers.anyString;  
        when(blobStore.blobContainer(any())).thenReturn(encryptedBlobContainer);
            IllegalStateException.class,
    @Before
            .build();
        when(blobStore.blobContainer(any())).thenReturn(blobContainer);  
import static org.mockito.Mockito.verify;
    }  
import org.opensearch.common.blobstore.BlobContainer;  
        );
        // verify update metadata manifest upload timeout  
        when(blobStoreRepository.blobStore()).thenReturn(blobStore);
        );  
        when(blobStoreRepository.getCompressor()).thenReturn(compressor);
        );
            "test-cluster-name",  
import java.util.function.Function;  
    private ThreadPool threadPool;
        verify(mockBlobContainer).listBlobsByPrefixInSortedOrder("manifest" + DELIMITER, 1, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC);
            "test-node-id",
}  
import org.opensearch.core.compress.NoneCompressor;  
import java.util.stream.Stream;
        when((blobStoreRepository.basePath())).thenReturn(blobPath);  
        blobStoreTransferService = mock(BlobStoreTransferService.class);  
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        when(blobPath.add(anyString())).thenReturn(blobPath);
        return blobContainer;
        when(mockBlobContainer.listBlobsByPrefixInSortedOrder("manifest" + DELIMITER, 1, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC))  
import static org.mockito.Mockito.mock;
            remoteManifestManager.getMetadataManifestUploadTimeout()  
            .build();  
        when(blobPath.buildAsString()).thenReturn("/blob/path/");  
 * SPDX-License-Identifier: Apache-2.0
    }  
        when((blobStoreRepository.basePath())).thenReturn(blobPath);
            .thenReturn(java.util.Collections.emptyList());
        assertEquals(metadataManifestUploadTimeout, remoteManifestManager.getMetadataManifestUploadTimeout().seconds());  
        assertEquals(e.getMessage(), "Error while fetching latest manifest file for remote cluster state");
    private BlobStoreTransferService blobStoreTransferService;
    private ClusterSettings clusterSettings;
    @After
        blobStoreRepository = mock(BlobStoreRepository.class);
import static java.util.stream.Collectors.toList;  
        threadPool.shutdown();
            .nodes(RemoteClusterStateServiceTests.nodesWithLocalNodeClusterManager())
                NetworkModule.getNamedXContents().stream(),
        clusterSettings.applySettings(newSettings);
    private BlobContainer mockBlobStoreObjects() {
import org.opensearch.common.settings.ClusterSettings;  
        Exception e = assertThrows(  
 * compatible open source license.
        final BlobPath blobPath = mock(BlobPath.class);
        when(blobPath.buildAsString()).thenReturn("/blob/path/");
            blobStoreTransferService,  
import java.io.IOException;
        NamedXContentRegistry xContentRegistry = new NamedXContentRegistry(
    @SuppressWarnings("unchecked")
import org.opensearch.common.blobstore.EncryptedBlobContainer;  
            RemoteManifestManager.METADATA_MANIFEST_UPLOAD_TIMEOUT_DEFAULT,
    public void testMetadataManifestUploadWaitTimeSetting() {
import org.opensearch.common.blobstore.BlobStore;
            ).flatMap(Function.identity()).collect(toList())
public class RemoteManifestManagerTests extends OpenSearchTestCase {
            .thenThrow(IOException.class);
import org.opensearch.threadpool.ThreadPool;
        final ClusterState clusterState = RemoteClusterStateServiceTests.generateClusterStateWithOneIndex()  
import org.opensearch.core.compress.Compressor;
        when(blobContainer.path()).thenReturn(blobPath);
    }
    }  
/*  
        BlobContainer mockBlobContainer = mock(BlobContainer.class);
import org.opensearch.common.blobstore.BlobPath;
import org.junit.After;
        when(blobStoreRepository.getNamedXContentRegistry()).thenReturn(xContentRegistry);  
        CryptoHandler<Object, Object> cryptoHandler = mock(CryptoHandler.class);
    public void setup() {
        Compressor compressor = new NoneCompressor();
        clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
import org.opensearch.threadpool.TestThreadPool;  
import org.opensearch.common.crypto.CryptoHandler;
            .put("cluster.remote_store.state.metadata_manifest.upload_timeout", metadataManifestUploadTimeout + "s")  
            )
        remoteManifestManager = new RemoteManifestManager(
        BlobContainer blobContainer = mockBlobStoreObjects();
        when(blobPath.add(anyString())).thenReturn(blobPath);
        int metadataManifestUploadTimeout = randomIntBetween(1, 10);
            .nodes(RemoteClusterStateServiceTests.nodesWithLocalNodeClusterManager())
        );
        when(mockBlobContainer.path()).thenReturn(blobPath);  
        final ClusterState clusterState = RemoteClusterStateServiceTests.generateClusterStateWithOneIndex()
import org.junit.Before;  
