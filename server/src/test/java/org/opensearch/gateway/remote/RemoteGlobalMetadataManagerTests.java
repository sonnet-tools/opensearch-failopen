        );
        );
            blobStoreTransferService,  
        );  
import org.opensearch.cluster.metadata.IndexGraveyard;  
        );
            compressor,
        assertEquals(RemoteStoreUtils.invertLong(METADATA_VERSION), splitFileName[1]);  
        assertEquals(GLOBAL_METADATA_PATH_TOKEN, pathTokens[3]);
        String[] pathTokens = uploadedFileName.split(PATH_DELIMITER);
import static org.mockito.Mockito.doAnswer;  
        remoteGlobalMetadataManager.readAsync(  
        TestCapturingListener<RemoteReadResult> listener = new TestCapturingListener<>();
import static org.opensearch.gateway.remote.RemoteClusterStateTestUtils.CustomMetadata1;  
        assertEquals(RemoteClusterStateUtils.encodeString(CLUSTER_NAME), pathTokens[0]);
import org.opensearch.cluster.ClusterModule;  
        doAnswer(invocationOnMock -> {
        customsDiff = remoteGlobalMetadataManager.getCustomsDiff(currentState, previousState, true, true);  
        assertEquals(CLUSTER_STATE_PATH_TOKEN, pathTokens[1]);  
        assertEquals(RemoteClusterStateUtils.encodeString(CLUSTER_NAME), pathTokens[0]);
        assertEquals(TEMPLATES_METADATA, listener.getResult().getComponentName());  
import org.opensearch.threadpool.ThreadPool;  
        doAnswer(invocationOnMock -> {
        String[] pathTokens = uploadedFileName.split(PATH_DELIMITER);  
        assertNotNull(listener.getResult());
        assertEquals(4, splitFileName.length);  
        remoteGlobalMetadataManager.readAsync(
            IndexGraveyard.TYPE,
        IOException ioException = new IOException("mock test exception");
        );  
        RemoteCustomMetadata customMetadataForUpload = new RemoteCustomMetadata(  
        doAnswer(invocationOnMock -> {
            templatesMetadataForDownload,
        assertEquals(GLOBAL_METADATA_CURRENT_CODEC_VERSION, Integer.parseInt(splitFileName[3]));  
            compressor,
import org.opensearch.cluster.coordination.CoordinationMetadata;
        latch.await();
    private BlobStoreRepository blobStoreRepository;
            namedWriteableRegistry  
            IndexGraveyard.TYPE,
        assertNotNull(listener.getResult());
            hashesOfConsistentSettingsForDownload.hashesOfConsistentSettingsFormat.serialize(
        assertNotNull(listener.getFailure());
            COORDINATION_METADATA,
            compressor,  
        );
        );
        assertEquals(TEMPLATES_METADATA, uploadedMetadata.getComponent());  
        CountDownLatch latch = new CountDownLatch(1);
        String fileName = randomAlphaOfLength(10);  
        latch.await();
            TEMPLATES_METADATA_FORMAT.serialize(templatesMetadata, fileName, compressor, FORMAT_PARAMS).streamInput()
        blobStoreRepository = mock(BlobStoreRepository.class);
import java.util.List;  
            hashesOfConsistentSettingsForDownload,
import static org.opensearch.gateway.remote.model.RemoteHashesOfConsistentSettingsTests.getHashesOfConsistentSettings;  
        DiffableStringMap hashesOfConsistentSettings = getHashesOfConsistentSettings();
            new CustomMetadata2("data2"),  
        IOException ioException = new IOException("mock test exception");  
        assertEquals(CLUSTER_UUID, pathTokens[2]);  
            GLOBAL_METADATA_FORMAT.serialize(metadata, fileName, compressor, FORMAT_PARAMS).streamInput()
        assertEquals(RemoteClusterStateUtils.encodeString(CLUSTER_NAME), pathTokens[0]);
            HASHES_OF_CONSISTENT_SETTINGS,  
        );
        String fileName = randomAlphaOfLength(10);  
        assertEquals(GLOBAL_METADATA_CURRENT_CODEC_VERSION, Integer.parseInt(splitFileName[3]));  
        when(blobStoreTransferService.downloadBlob(anyIterable(), anyString())).thenThrow(ioException);  
    public void testGlobalMetadataUploadWaitTimeSetting() {  
            compressor,
        remoteGlobalMetadataManager.writeAsync(  
            new CustomMetadata3("data3-changed"),
                NetworkModule.getNamedXContents().stream(),
            new CustomMetadata5("data5")
        ClusterMetadataManifest.UploadedMetadata uploadedMetadata = listener.getResult();  
import static org.opensearch.gateway.remote.model.RemoteGlobalMetadata.GLOBAL_METADATA_FORMAT;  
        }).when(blobStoreTransferService)  
import org.opensearch.common.settings.Settings;  
import static org.opensearch.gateway.remote.model.RemoteCoordinationMetadata.COORDINATION_METADATA;  
    public void testGetAsyncReadRunnable_HashesOfConsistentSettings() throws Exception {
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.CUSTOM_DELIMITER;  
        ClusterState currentState = ClusterState.builder(new ClusterName("test-cluster"))
        assertEquals(GLOBAL_METADATA, listener.getResult().getComponent());
        assertThat(customsDiff.getDeletes(), is(List.of()));
            new CustomMetadata3("data3-changed"),
    }  
        RemoteGlobalMetadata globalMetadataForDownload = new RemoteGlobalMetadata(fileName, CLUSTER_UUID, compressor, xContentRegistry);  
            CustomMetadata3.TYPE,
import org.opensearch.cluster.metadata.Metadata;
import static org.opensearch.gateway.remote.model.RemoteGlobalMetadataTests.getGlobalMetadata;
        CountDownLatch latch = new CountDownLatch(1);
            compressor,
        assertNull(listener.getFailure());
        );
    public void testGetAsyncReadRunnable_PersistentSettings() throws Exception {
        latch.await();
            CustomMetadata2.TYPE,  
import java.util.concurrent.CountDownLatch;
        assertThat(customsDiff.getDeletes(), is(List.of(CustomMetadata1.TYPE)));
            new CustomMetadata4("data4"),  
            writableRegistry(),
            CLUSTER_UUID,  
        );
                .streamInput()
    private NamedXContentRegistry xContentRegistry;
        CountDownLatch latch = new CountDownLatch(1);
import static org.opensearch.gateway.remote.model.RemotePersistentSettingsMetadata.SETTING_METADATA;
import org.opensearch.gateway.remote.model.RemoteReadResult;  
        assertNotNull(listener.getResult());
import org.opensearch.cluster.ClusterState;
        assertNull(listener.getFailure());
        when(blobStoreTransferService.downloadBlob(anyIterable(), anyString())).thenReturn(
    public void testGetAsyncReadRunnable_IOException() throws Exception {  
        assertEquals(RemoteClusterStateUtils.encodeString(CLUSTER_NAME), pathTokens[0]);
        assertEquals(GLOBAL_METADATA_PATH_TOKEN, pathTokens[3]);
import org.opensearch.test.OpenSearchTestCase;
    public void testGetAsyncReadRunnable_CustomMetadata() throws Exception {  
import org.opensearch.core.xcontent.NamedXContentRegistry;  
        RemotePersistentSettingsMetadata persistentSettings = new RemotePersistentSettingsMetadata(
import static org.opensearch.gateway.remote.model.RemoteTransientSettingsMetadata.TRANSIENT_SETTING_METADATA;  
        TemplatesMetadata templatesMetadata = getTemplatesMetadata();
            return null;
        latch.await();  
import org.opensearch.indices.IndicesModule;
            CustomMetadata5.TYPE,
        assertEquals(GLOBAL_METADATA_CURRENT_CODEC_VERSION, Integer.parseInt(splitFileName[3]));
import org.opensearch.cluster.metadata.DiffableStringMap;
            CLUSTER_UUID,
            CLUSTER_UUID,
        Map<String, Metadata.Custom> previousCustoms = Map.of(  
            xContentRegistry
        CountDownLatch latch = new CountDownLatch(1);
        assertTrue(isGlobalStateEquals(metadata, (Metadata) listener.getResult().getObj()));
        assertEquals(CLUSTER_STATE_PATH_TOKEN, pathTokens[1]);
            CustomMetadata3.TYPE,
        assertEquals(SETTING_METADATA, splitFileName[0]);
import org.opensearch.index.remote.RemoteStoreUtils;  
        CoordinationMetadata coordinationMetadata = getCoordinationMetadata();
            verifyCustomMetadataReadForVersion(version);
        assertEquals(ioException, listener.getFailure().getCause());
        assertEquals(CLUSTER_STATE_PATH_TOKEN, pathTokens[1]);
        assertEquals(HASHES_OF_CONSISTENT_SETTINGS, listener.getResult().getComponent());
            CLUSTER_UUID,
    public void testGetAsyncReadRunnable_GlobalMetadata() throws Exception {  
            .put("cluster.remote_store.state.global_metadata.upload_timeout", globalMetadataUploadTimeout + "s")
            xContentRegistry
import org.opensearch.cluster.DiffableUtils;  
            COORDINATION_METADATA_FORMAT.serialize(coordinationMetadata, fileName, compressor, FORMAT_PARAMS).streamInput()
        );
            new CustomMetadata4("data4")
    public void testGetAsyncWriteRunnable_PersistentSettings() throws Exception {
            customMetadataForDownload.customBlobStoreFormat.serialize(customMetadata, fileName, compressor).streamInput()  
            hashesOfConsistentSettings,  
        assertNotNull(listener.getResult());  
        assertNull(listener.getFailure());
            CustomMetadata4.TYPE,  
            .uploadBlob(any(InputStream.class), anyIterable(), anyString(), eq(URGENT), any(ActionListener.class));  
        doAnswer(invocationOnMock -> {  
    }
        namedWriteableRegistry = writableRegistry();  
        );  
    private final ThreadPool threadPool = new TestThreadPool(getClass().getName());  
        latch.await();
            return null;  
            compressor,  
import static org.opensearch.gateway.remote.model.RemoteTemplatesMetadataTests.getTemplatesMetadata;
        TestCapturingListener<RemoteReadResult> listener = new TestCapturingListener<>();
        CountDownLatch latch = new CountDownLatch(1);
            customMetadataForUpload,
        assertEquals(COORDINATION_METADATA, listener.getResult().getComponentName());
        assertEquals(GLOBAL_METADATA_PATH_TOKEN, pathTokens[3]);
        assertNull(listener.getFailure());
        doAnswer(invocationOnMock -> {
    private void verifyCustomMetadataReadForVersion(Version version) throws Exception {  
        );
        latch.await();
import static org.opensearch.gateway.remote.model.RemoteHashesOfConsistentSettings.HASHES_OF_CONSISTENT_SETTINGS;
        CoordinationMetadata coordinationMetadata = getCoordinationMetadata();  
        doAnswer(invocationOnMock -> {
            CustomMetadata4.TYPE,
        assertEquals(customMetadata, listener.getResult().getObj());
            xContentRegistry  
    public void testGetAsyncReadRunnable_TemplatesMetadata() throws Exception {  
        CountDownLatch latch = new CountDownLatch(1);
            METADATA_VERSION,
        threadPool.shutdown();  
    public void testGetAsyncReadRunnable_TransientSettings() throws Exception {  
        DiffableStringMap hashesOfConsistentSettings = getHashesOfConsistentSettings();
        );
    }
            CLUSTER_NAME,
        assertEquals(4, splitFileName.length);  
            new LatchedActionListener<>(listener, latch)
            CLUSTER_UUID,
        assertEquals(RemoteClusterStateUtils.encodeString(CLUSTER_NAME), pathTokens[0]);
        when(blobStoreTransferService.downloadBlob(anyIterable(), anyString())).thenReturn(  
        );  
        }).when(blobStoreTransferService)
            COORDINATION_METADATA,
            return null;
            new CustomMetadata3("data3")  
            CustomMetadata2.TYPE,
        assertThat(customsDiff.getUpserts(), is(expectedUpserts));
        assertEquals(COORDINATION_METADATA, listener.getResult().getComponent());
        assertNull(listener.getResult());  
        }).when(blobStoreTransferService)
        Metadata.Custom customMetadata = getCustomMetadata();
        );  
            compressor,
        TestCapturingListener<ClusterMetadataManifest.UploadedMetadata> listener = new TestCapturingListener<>();
            invocationOnMock.getArgument(4, ActionListener.class).onFailure(ioException);
import static java.util.stream.Collectors.toList;  
import org.opensearch.common.util.TestCapturingListener;
        String fileName = randomAlphaOfLength(10);
import org.opensearch.gateway.remote.model.RemoteHashesOfConsistentSettings;
        when(blobStoreTransferService.downloadBlob(anyIterable(), anyString())).thenReturn(
            RemotePersistentSettingsMetadata.SETTINGS_METADATA_FORMAT.serialize(settingsMetadata, fileName, compressor, FORMAT_PARAMS)
            new CustomMetadata3("data3-changed"),
        Map<String, Metadata.Custom> expectedUpserts = Map.of(
            CustomMetadata3.TYPE,
            .uploadBlob(any(InputStream.class), anyIterable(), anyString(), eq(URGENT), any(ActionListener.class));  
            hashesOfConsistentSettingsForUpload,
        TestCapturingListener<RemoteReadResult> listener = new TestCapturingListener<>();
        String[] pathTokens = uploadedFileName.split(PATH_DELIMITER);  
        ClusterMetadataManifest.UploadedMetadata uploadedMetadata = listener.getResult();
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.GLOBAL_METADATA_PATH_TOKEN;
            compressor,
            CLUSTER_UUID,  
            ).flatMap(Function.identity()).collect(toList())
    }
        assertEquals(CLUSTER_STATE_PATH_TOKEN, pathTokens[1]);
import static org.opensearch.gateway.remote.model.RemoteCoordinationMetadata.COORDINATION_METADATA_FORMAT;
    }
        Settings newSettings = Settings.builder()  
        when(blobStoreRepository.getCompressor()).thenReturn(compressor);
            CLUSTER_UUID,  
        assertEquals(CLUSTER_UUID, pathTokens[2]);  
            CustomMetadata4.TYPE,
import java.io.IOException;
        assertTrue(listener.getFailure() instanceof RemoteStateTransferException);  
        CountDownLatch latch = new CountDownLatch(1);
        String[] pathTokens = uploadedFileName.split(PATH_DELIMITER);
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.FORMAT_PARAMS;
        remoteGlobalMetadataManager.writeAsync(
            Stream.of(  
            new LatchedActionListener<>(listener, latch)  
        TestCapturingListener<RemoteReadResult> listener = new TestCapturingListener<>();
            xContentRegistry
            remoteCoordinationMetadata,
            remoteGlobalMetadataManager.getGlobalMetadataUploadTimeout()
        assertEquals(hashesOfConsistentSettings, listener.getResult().getObj());
        assertEquals(GLOBAL_METADATA_PATH_TOKEN, pathTokens[3]);
        RemoteTemplatesMetadata templateMetadataForUpload = new RemoteTemplatesMetadata(
        String fileName = randomAlphaOfLength(10);
        );
        String fileName = randomAlphaOfLength(10);
        assertEquals(5, pathTokens.length);  
            remoteCoordinationMetadata,  
    }  
import org.opensearch.common.network.NetworkModule;
    private final long METADATA_VERSION = 7331L;
        assertNull(listener.getResult());
        assertNotNull(listener.getResult());
        assertThat(customsDiff.getUpserts(), is(expectedUpserts));
        assertEquals(TRANSIENT_SETTING_METADATA, splitFileName[0]);
            compressor,
import static org.opensearch.cluster.metadata.Metadata.isGlobalStateEquals;
            coordinationMetadata,  
import static org.opensearch.gateway.remote.RemoteClusterStateTestUtils.CustomMetadata4;  
        remoteGlobalMetadataManager.writeAsync(  
import org.opensearch.cluster.metadata.TemplatesMetadata;
        }).when(blobStoreTransferService)
            new CustomMetadata4("data4"),
        CoordinationMetadata coordinationMetadata = getCoordinationMetadata();
        when(blobStoreRepository.getNamedXContentRegistry()).thenReturn(xContentRegistry);  
        remoteGlobalMetadataManager.readAsync(
            IndexGraveyard.TYPE,
        assertNotNull(listener.getResult());  
        assertEquals(4, splitFileName.length);  
        );  
        CountDownLatch latch = new CountDownLatch(1);
                fileName,
            Version.CURRENT
        );  
            customMetadataForUpload.getType(),
    }
    private Compressor compressor;  
        RemoteTransientSettingsMetadata transientSettings = new RemoteTransientSettingsMetadata(  
        assertEquals(CLUSTER_UUID, pathTokens[2]);  
    }
        expectedUpserts = Map.of(
        expectedUpserts = Map.of(  
        remoteGlobalMetadataManager.writeAsync(TEMPLATES_METADATA, templateMetadataForUpload, new LatchedActionListener<>(listener, latch));
        expectedUpserts = Map.of(
        assertEquals(SETTING_METADATA, listener.getResult().getComponent());
            new CustomMetadata5("data5"),  
        assertNull(listener.getFailure());  
        String uploadedFileName = uploadedMetadata.getUploadedFilename();
            threadPool
        clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        assertEquals(String.join(CUSTOM_DELIMITER, CUSTOM_METADATA, IndexGraveyard.TYPE), uploadedMetadata.getComponent());  
            xContentRegistry  
        String fileName = randomAlphaOfLength(10);  
        );  
import org.opensearch.gateway.remote.model.RemoteTemplatesMetadata;
            blobStoreRepository,
        assertEquals(5, pathTokens.length);  
            CustomMetadata3.TYPE,
            METADATA_VERSION,  
            .build();
            METADATA_VERSION,
        );  
        latch.await();
        latch.await();
        assertEquals(settingsMetadata, listener.getResult().getObj());  
import static org.opensearch.gateway.remote.model.RemoteCoordinationMetadataTests.getCoordinationMetadata;
    private NamedWriteableRegistry namedWriteableRegistry;
            clusterSettings,  
        remoteGlobalMetadataManager.writeAsync(  
        assertNull(listener.getFailure());  
        assertEquals(4, splitFileName.length);
        remoteGlobalMetadataManager.readAsync(IndexGraveyard.TYPE, customMetadataForDownload, new LatchedActionListener<>(listener, latch));
import static org.opensearch.gateway.remote.model.RemoteCustomMetadataTests.getCustomMetadata;
        Metadata.Custom customMetadata = getCustomMetadata();
    @Before
        assertThat(customsDiff.getUpserts(), is(expectedUpserts));
            .uploadBlob(any(InputStream.class), anyIterable(), anyString(), eq(URGENT), any(ActionListener.class));
        assertEquals(RemoteStoreUtils.invertLong(METADATA_VERSION), splitFileName[1]);  
        assertNull(listener.getFailure());  
        );  
            invocationOnMock.getArgument(4, ActionListener.class).onResponse(null);  
        assertEquals(RemoteStoreUtils.invertLong(METADATA_VERSION), splitFileName[1]);
                hashesOfConsistentSettings,  
import static org.opensearch.gateway.remote.model.RemoteTemplatesMetadata.TEMPLATES_METADATA;  
    }
        // verify update global metadata upload timeout
        ClusterState previousState = ClusterState.builder(new ClusterName("test-cluster"))
    public void testGetAsyncWriteRunnable_CustomMetadata() throws Exception {
        TestCapturingListener<ClusterMetadataManifest.UploadedMetadata> listener = new TestCapturingListener<>();
            CLUSTER_UUID,
            COORDINATION_METADATA,
        assertEquals(COORDINATION_METADATA, uploadedMetadata.getComponent());
        remoteGlobalMetadataManager.readAsync(GLOBAL_METADATA, globalMetadataForDownload, new LatchedActionListener<>(listener, latch));  
            invocationOnMock.getArgument(4, ActionListener.class).onResponse(null);  
import static org.mockito.Mockito.when;
        CountDownLatch latch = new CountDownLatch(1);
    private final String CLUSTER_NAME = "test-cluster";
        CountDownLatch latch = new CountDownLatch(1);  
        assertEquals(GLOBAL_METADATA_PATH_TOKEN, pathTokens[3]);
        TestCapturingListener<ClusterMetadataManifest.UploadedMetadata> listener = new TestCapturingListener<>();
        assertEquals(5, pathTokens.length);
 */  
        CountDownLatch latch = new CountDownLatch(1);  
        assertEquals(CLUSTER_UUID, pathTokens[2]);  
            return null;
        );
            CustomMetadata4.TYPE,  
            IndexGraveyard.builder().build()
        assertEquals(CLUSTER_UUID, pathTokens[2]);
import org.opensearch.repositories.blobstore.BlobStoreRepository;  
            compressor,  
        TestCapturingListener<ClusterMetadataManifest.UploadedMetadata> listener = new TestCapturingListener<>();
            return null;
    }
 * compatible open source license.
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.PATH_DELIMITER;
    private final String CLUSTER_UUID = "test-cluster-uuid";  
import static org.hamcrest.Matchers.is;
        assertEquals(String.join(CUSTOM_DELIMITER, CUSTOM_METADATA, IndexGraveyard.TYPE), splitFileName[0]);
    }  
        RemoteHashesOfConsistentSettings hashesOfConsistentSettingsForUpload = new RemoteHashesOfConsistentSettings(
        );  
        assertEquals(GLOBAL_METADATA_PATH_TOKEN, pathTokens[3]);
            compressor,
import org.junit.Before;
            CustomMetadata1.TYPE,
        CountDownLatch latch = new CountDownLatch(1);  
        RemoteCoordinationMetadata remoteCoordinationMetadata = new RemoteCoordinationMetadata(
        TemplatesMetadata templatesMetadata = getTemplatesMetadata();
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.gateway.remote.model.RemoteCoordinationMetadata;
            new LatchedActionListener<>(listener, latch)
            ).streamInput()  
            invocationOnMock.getArgument(4, ActionListener.class).onResponse(null);
        ClusterMetadataManifest.UploadedMetadata uploadedMetadata = listener.getResult();  
import static org.opensearch.gateway.remote.RemoteClusterStateTestUtils.CustomMetadata5;
        assertNull(listener.getFailure());  
import org.opensearch.Version;
        assertNull(listener.getFailure());  
        ClusterMetadataManifest.UploadedMetadata uploadedMetadata = listener.getResult();
        customsDiff = remoteGlobalMetadataManager.getCustomsDiff(currentState, previousState, false, false);
        String fileName = randomAlphaOfLength(10);
            new LatchedActionListener<>(listener, latch)  
        assertEquals(GLOBAL_METADATA, listener.getResult().getComponentName());  
            fileName,
            CLUSTER_UUID,
            CLUSTER_UUID,  
        assertEquals(SETTING_METADATA, listener.getResult().getComponentName());
    }
        assertEquals(CLUSTER_STATE_PATH_TOKEN, pathTokens[1]);
            new LatchedActionListener<>(listener, latch)  
import org.opensearch.core.compress.Compressor;
            CustomMetadata4.TYPE,  
            .getCustomsDiff(currentState, previousState, true, false);  
        assertNotNull(listener.getResult());
        BlobPath blobPath = new BlobPath();
            templatesMetadata,  
        );
            version  
            return null;  
        assertNull(listener.getFailure());
        );
        }).when(blobStoreTransferService)
            .metadata(Metadata.builder().customs(currentCustoms))
            invocationOnMock.getArgument(4, ActionListener.class).onResponse(null);  
        assertEquals(coordinationMetadata, listener.getResult().getObj());  
        RemoteTransientSettingsMetadata transientSettings = new RemoteTransientSettingsMetadata(  
        assertNotNull(listener.getResult());
            new LatchedActionListener<>(listener, latch)
        assertNotNull(listener.getResult());
import org.opensearch.gateway.remote.model.RemoteTransientSettingsMetadata;
import org.opensearch.gateway.remote.model.RemotePersistentSettingsMetadata;
            .uploadBlob(any(InputStream.class), anyIterable(), anyString(), eq(URGENT), any(ActionListener.class));  
        );
    }
        String uploadedFileName = uploadedMetadata.getUploadedFilename();
        // verify default value
            .metadata(Metadata.builder().customs(previousCustoms))  
            CLUSTER_UUID,
            CustomMetadata5.TYPE,
        remoteGlobalMetadataManager.writeAsync(TRANSIENT_SETTING_METADATA, transientSettings, new LatchedActionListener<>(listener, latch));
            fileName,
            CustomMetadata5.TYPE,
        String[] pathTokens = uploadedFileName.split(PATH_DELIMITER);
            new LatchedActionListener<>(listener, latch)
import static org.mockito.ArgumentMatchers.any;
        RemoteCoordinationMetadata remoteCoordinationMetadata = new RemoteCoordinationMetadata(
        String[] splitFileName = pathTokens[4].split(DELIMITER);
    private ClusterSettings clusterSettings;  
    public void testGetUpdatedCustoms() {
            .uploadBlob(any(InputStream.class), anyIterable(), anyString(), eq(URGENT), any(ActionListener.class));
import org.opensearch.common.settings.ClusterSettings;
        Metadata metadata = getGlobalMetadata();
        assertEquals(HASHES_OF_CONSISTENT_SETTINGS, listener.getResult().getComponentName());  
            CLUSTER_UUID,
        assertThat(customsDiff.getDeletes(), is(List.of()));  
        when(blobStoreRepository.basePath()).thenReturn(blobPath);
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(TRANSIENT_SETTING_METADATA, listener.getResult().getComponentName());
        RemotePersistentSettingsMetadata persistentSettings = new RemotePersistentSettingsMetadata(
        for (Version version : List.of(Version.CURRENT, Version.V_2_15_0, Version.V_2_13_0)) {
import static org.opensearch.common.blobstore.stream.write.WritePriority.URGENT;
            coordinationMetadata,
                .streamInput()  
        blobStoreTransferService = mock(BlobStoreTransferService.class);  
        RemoteCustomMetadata customMetadataForDownload = new RemoteCustomMetadata(  
            .build();  
        assertEquals(ioException, listener.getFailure().getCause());
        assertThat(customsDiff.getUpserts(), is(expectedUpserts));  
        TestCapturingListener<RemoteReadResult> listener = new TestCapturingListener<>();
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.DELIMITER;
            xContentRegistry
            namedWriteableRegistry,
        TestCapturingListener<RemoteReadResult> listener = new TestCapturingListener<>();
        String fileName = randomAlphaOfLength(10);
        assertEquals(CLUSTER_UUID, pathTokens[2]);
import static org.opensearch.gateway.remote.RemoteClusterStateTestUtils.CustomMetadata3;
        );
        when(blobStoreTransferService.downloadBlob(anyIterable(), anyString())).thenReturn(
        assertEquals(RemoteStoreUtils.invertLong(METADATA_VERSION), splitFileName[1]);
import org.opensearch.core.compress.NoneCompressor;
        latch.await();  
            CustomMetadata3.TYPE,  
        );
        );
        String uploadedFileName = uploadedMetadata.getUploadedFilename();
        int globalMetadataUploadTimeout = randomIntBetween(1, 10);
            new CustomMetadata3("data3-changed"),
            invocationOnMock.getArgument(4, ActionListener.class).onResponse(null);
        String[] splitFileName = pathTokens[4].split(DELIMITER);  
            CustomMetadata2.TYPE,
        );
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
        assertNotNull(listener.getResult());
        assertNotNull(listener.getResult());  
        RemoteCoordinationMetadata coordinationMetadataForDownload = new RemoteCoordinationMetadata(
            coordinationMetadataForDownload,  
 *
        compressor = new NoneCompressor();
        ClusterMetadataManifest.UploadedMetadata uploadedMetadata = listener.getResult();
        assertEquals(GLOBAL_METADATA_CURRENT_CODEC_VERSION, Integer.parseInt(splitFileName[3]));
            IndexGraveyard.builder().build()  
        assertEquals(4, splitFileName.length);
            .build();
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.GLOBAL_METADATA_CURRENT_CODEC_VERSION;  
        assertEquals(TEMPLATES_METADATA, listener.getResult().getComponent());
        assertEquals(IndexGraveyard.TYPE, listener.getResult().getComponentName());
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.CLUSTER_STATE_PATH_TOKEN;
    public void testGetAsyncReadRunnable_CoordinationMetadata() throws Exception {
import org.opensearch.core.action.ActionListener;
        Settings settingsMetadata = getSettings();  
        assertEquals(5, pathTokens.length);  
        String[] splitFileName = pathTokens[4].split(DELIMITER);
        assertEquals(settingsMetadata, listener.getResult().getObj());
        Settings settingsMetadata = getSettings();
        TestCapturingListener<ClusterMetadataManifest.UploadedMetadata> listener = new TestCapturingListener<>();
        );
            RemoteTransientSettingsMetadata.SETTINGS_METADATA_FORMAT.serialize(settingsMetadata, fileName, compressor, FORMAT_PARAMS)
        assertNull(listener.getFailure());
            new CustomMetadata1("data1"),
        customsDiff = remoteGlobalMetadataManager.getCustomsDiff(currentState, previousState, false, true);
        assertEquals(templatesMetadata, listener.getResult().getObj());
    @After  
        remoteGlobalMetadataManager.writeAsync(SETTING_METADATA, persistentSettings, new LatchedActionListener<>(listener, latch));  
            CLUSTER_UUID,  
    private BlobStoreTransferService blobStoreTransferService;
public class RemoteGlobalMetadataManagerTests extends OpenSearchTestCase {
    public void testGetAsyncWriteRunnable_CoordinationMetadata() throws Exception {
import static org.mockito.Mockito.mock;
        assertEquals(5, pathTokens.length);  
            invocationOnMock.getArgument(4, ActionListener.class).onResponse(null);  
        }  
        );
package org.opensearch.gateway.remote;
        assertEquals(TRANSIENT_SETTING_METADATA, listener.getResult().getComponent());  
                IndicesModule.getNamedXContents().stream(),
        Settings settingsMetadata = getSettings();
            settingsMetadata,
            xContentRegistry
            xContentRegistry
    public void setup() {  
    }
        assertEquals(RemoteStoreUtils.invertLong(METADATA_VERSION), splitFileName[1]);
        assertNotNull(listener.getResult());
import org.opensearch.gateway.remote.model.RemoteGlobalMetadata;  
        latch.await();  
        assertNull(listener.getFailure());
        TestCapturingListener<ClusterMetadataManifest.UploadedMetadata> listener = new TestCapturingListener<>();
import static org.opensearch.gateway.remote.model.RemoteGlobalMetadata.GLOBAL_METADATA;
        doAnswer(invocationOnMock -> {
import org.opensearch.common.blobstore.BlobPath;  
        String uploadedFileName = uploadedMetadata.getUploadedFilename();
            new CustomMetadata5("data5")
            CustomMetadata2.TYPE,
        super.tearDown();
        assertEquals(
    }
        assertEquals(globalMetadataUploadTimeout, remoteGlobalMetadataManager.getGlobalMetadataUploadTimeout().seconds());
        Settings settingsMetadata = getSettings();
import static org.opensearch.gateway.remote.RemoteClusterStateTestUtils.CustomMetadata2;
        }).when(blobStoreTransferService)
        latch.await();  
    public void testGetAsyncWriteRunnable_TransientSettings() throws Exception {
            fileName,
            METADATA_VERSION,  
        TestCapturingListener<RemoteReadResult> listener = new TestCapturingListener<>();
    public void testGetAsyncWriteRunnable_HashesOfConsistentSettings() throws Exception {  
import org.opensearch.gateway.remote.model.RemoteCustomMetadata;
        String uploadedFileName = uploadedMetadata.getUploadedFilename();
import org.opensearch.index.translog.transfer.BlobStoreTransferService;
        CountDownLatch latch = new CountDownLatch(1);  
import static org.opensearch.gateway.remote.model.RemotePersistentSettingsMetadataTests.getSettings;
        String[] splitFileName = pathTokens[4].split(DELIMITER);
        when(blobStoreTransferService.downloadBlob(anyIterable(), anyString())).thenReturn(  
import java.io.InputStream;
        remoteGlobalMetadataManager.readAsync(TRANSIENT_SETTING_METADATA, transientSettings, new LatchedActionListener<>(listener, latch));
            IndexGraveyard.TYPE,
            HASHES_OF_CONSISTENT_SETTINGS,
            METADATA_VERSION,
            xContentRegistry  
import java.util.Map;
        latch.await();
            new CustomMetadata4("data4"),
        assertTrue(listener.getFailure() instanceof RemoteStateTransferException);
import static org.mockito.ArgumentMatchers.anyIterable;  
        assertNotNull(listener.getFailure());  
        assertEquals(COORDINATION_METADATA, splitFileName[0]);
        Map<String, Metadata.Custom> currentCustoms = Map.of(  
        String[] splitFileName = pathTokens[4].split(DELIMITER);  
        assertEquals(4, splitFileName.length);  
import org.opensearch.cluster.ClusterName;
        assertEquals(TRANSIENT_SETTING_METADATA, uploadedMetadata.getComponent());
        );
        xContentRegistry = new NamedXContentRegistry(
import static org.mockito.ArgumentMatchers.eq;
import java.util.stream.Stream;
        CountDownLatch latch = new CountDownLatch(1);
        latch.await();
            new CustomMetadata4("data4"),  
    }
            customMetadata,
        TestCapturingListener<RemoteReadResult> listener = new TestCapturingListener<>();  
                ClusterModule.getNamedXWriteables().stream()  
        assertThat(customsDiff.getDeletes(), is(List.of(CustomMetadata1.TYPE)));
        String[] splitFileName = pathTokens[4].split(DELIMITER);
            COORDINATION_METADATA,
            RemoteGlobalMetadataManager.GLOBAL_METADATA_UPLOAD_TIMEOUT_DEFAULT,  
            return null;
        }).when(blobStoreTransferService)
import org.opensearch.action.LatchedActionListener;
            new CustomMetadata3("data3-changed"),
        remoteGlobalMetadataManager = new RemoteGlobalMetadataManager(
            METADATA_VERSION,  
import static org.opensearch.gateway.remote.model.RemoteCustomMetadata.CUSTOM_METADATA;  
            CustomMetadata3.TYPE,  
        clusterSettings.applySettings(newSettings);  
            fileName,
/*  
            TEMPLATES_METADATA,  
        );
                compressor
import org.opensearch.threadpool.TestThreadPool;
 * The OpenSearch Contributors require contributions made to  
}
        );
            new CustomMetadata2("data2"),  
        assertEquals(HASHES_OF_CONSISTENT_SETTINGS, splitFileName[0]);
        remoteGlobalMetadataManager.readAsync(
            xContentRegistry
import static org.mockito.ArgumentMatchers.anyString;
        assertEquals(GLOBAL_METADATA_CURRENT_CODEC_VERSION, Integer.parseInt(splitFileName[3]));  
            compressor,
            compressor  
            compressor,  
        assertNotNull(listener.getResult());
        assertNull(listener.getFailure());  
            .uploadBlob(any(InputStream.class), anyIterable(), anyString(), eq(URGENT), any(ActionListener.class));
        assertEquals(5, pathTokens.length);
        DiffableUtils.MapDiff<String, Metadata.Custom, Map<String, Metadata.Custom>> customsDiff = remoteGlobalMetadataManager
        assertEquals(CLUSTER_STATE_PATH_TOKEN, pathTokens[1]);  
        when(blobStoreTransferService.downloadBlob(anyIterable(), anyString())).thenReturn(
    }  
    public void testGetAsyncWriteRunnable_IOException() throws Exception {  
        assertEquals(SETTING_METADATA, uploadedMetadata.getComponent());  
        assertEquals(RemoteClusterStateUtils.encodeString(CLUSTER_NAME), pathTokens[0]);
        assertEquals(TEMPLATES_METADATA, splitFileName[0]);
        latch.await();
        ClusterMetadataManifest.UploadedMetadata uploadedMetadata = listener.getResult();
            fileName,
import org.junit.After;
        RemoteCoordinationMetadata coordinationMetadataForDownload = new RemoteCoordinationMetadata(
        );  
    public void testGetAsyncWriteRunnable_TemplatesMetadata() throws Exception {  
        assertEquals(RemoteStoreUtils.invertLong(METADATA_VERSION), splitFileName[1]);
        RemoteHashesOfConsistentSettings hashesOfConsistentSettingsForDownload = new RemoteHashesOfConsistentSettings(
    public void tearDown() throws Exception {
        String[] pathTokens = uploadedFileName.split(PATH_DELIMITER);
        RemoteTemplatesMetadata templatesMetadataForDownload = new RemoteTemplatesMetadata(  
            .uploadBlob(any(InputStream.class), anyIterable(), anyString(), eq(URGENT), any(ActionListener.class));  
        CountDownLatch latch = new CountDownLatch(1);
import java.util.function.Function;  
        TestCapturingListener<ClusterMetadataManifest.UploadedMetadata> listener = new TestCapturingListener<>();  
import static org.opensearch.gateway.remote.model.RemoteTemplatesMetadata.TEMPLATES_METADATA_FORMAT;
    private RemoteGlobalMetadataManager remoteGlobalMetadataManager;
    }
            coordinationMetadataForDownload,
        assertEquals(HASHES_OF_CONSISTENT_SETTINGS, uploadedMetadata.getComponent());  
    }
            CLUSTER_UUID,
            new CustomMetadata2("data2"),
    }
        when(blobStoreTransferService.downloadBlob(anyIterable(), anyString())).thenReturn(
        remoteGlobalMetadataManager.readAsync(SETTING_METADATA, persistentSettings, new LatchedActionListener<>(listener, latch));
            new CustomMetadata2("data2"),
        );  
            fileName,  
            new LatchedActionListener<>(listener, latch)  
        assertEquals(CUSTOM_METADATA, listener.getResult().getComponent());  
            settingsMetadata,
        assertEquals(GLOBAL_METADATA_CURRENT_CODEC_VERSION, Integer.parseInt(splitFileName[3]));  
            METADATA_VERSION,
            fileName,
        String uploadedFileName = uploadedMetadata.getUploadedFilename();
