            invocationOnMock.getArgument(4, ActionListener.class).onResponse(null);
        assertEquals(GLOBAL_METADATA_CURRENT_CODEC_VERSION, Integer.parseInt(splitFileName[3]));
    }
        CoordinationMetadata coordinationMetadata = getCoordinationMetadata();
        assertEquals(CLUSTER_STATE_PATH_TOKEN, pathTokens[1]);
            RemoteTransientSettingsMetadata.SETTINGS_METADATA_FORMAT.serialize(settingsMetadata, fileName, compressor, FORMAT_PARAMS)
        assertEquals(TRANSIENT_SETTING_METADATA, listener.getResult().getComponentName());
        ClusterState currentState = ClusterState.builder(new ClusterName("test-cluster"))
    }
        assertEquals(CLUSTER_UUID, pathTokens[2]);
    }
            IndexGraveyard.TYPE,
import org.opensearch.common.util.TestCapturingListener;
            .uploadBlob(any(InputStream.class), anyIterable(), anyString(), eq(URGENT), any(ActionListener.class));
            blobStoreTransferService,
import static org.hamcrest.Matchers.is;
            return null;
        assertNotNull(listener.getResult());
import static org.opensearch.gateway.remote.model.RemoteGlobalMetadata.GLOBAL_METADATA;
        assertEquals(CLUSTER_STATE_PATH_TOKEN, pathTokens[1]);
import static org.mockito.ArgumentMatchers.anyIterable;
        );
            xContentRegistry
        assertEquals(CLUSTER_STATE_PATH_TOKEN, pathTokens[1]);
        String[] splitFileName = pathTokens[4].split(DELIMITER);
import static org.opensearch.gateway.remote.RemoteClusterStateTestUtils.CustomMetadata3;
        );
            IndexGraveyard.builder().build()
        TemplatesMetadata templatesMetadata = getTemplatesMetadata();
 * compatible open source license.
        );
        for (Version version : List.of(Version.CURRENT, Version.V_2_15_0, Version.V_2_13_0)) {
            CustomMetadata4.TYPE,
        assertNotNull(listener.getResult());
        remoteGlobalMetadataManager.readAsync(
import org.opensearch.gateway.remote.model.RemoteCoordinationMetadata;
    public void testGetUpdatedCustoms() {
        Settings settingsMetadata = getSettings();
        remoteGlobalMetadataManager.readAsync(
        latch.await();
            CLUSTER_UUID,
package org.opensearch.gateway.remote;
    private ClusterSettings clusterSettings;
        assertNotNull(listener.getResult());
import org.opensearch.action.LatchedActionListener;
            xContentRegistry
        );
        assertThat(customsDiff.getDeletes(), is(List.of()));
    public void testGetAsyncReadRunnable_GlobalMetadata() throws Exception {
import static org.opensearch.cluster.metadata.Metadata.isGlobalStateEquals;
        assertEquals(RemoteStoreUtils.invertLong(METADATA_VERSION), splitFileName[1]);
        RemoteCoordinationMetadata coordinationMetadataForDownload = new RemoteCoordinationMetadata(
        blobStoreTransferService = mock(BlobStoreTransferService.class);
    }
import static org.mockito.Mockito.when;
import org.opensearch.core.xcontent.NamedXContentRegistry;
        expectedUpserts = Map.of(
import org.opensearch.test.OpenSearchTestCase;
            templatesMetadata,
import org.opensearch.cluster.metadata.Metadata;
            coordinationMetadataForDownload,
    }
        latch.await();
        xContentRegistry = new NamedXContentRegistry(
import static org.mockito.ArgumentMatchers.anyString;
            hashesOfConsistentSettingsForDownload,
            IndexGraveyard.builder().build()
        );
            new LatchedActionListener<>(listener, latch)
import static org.opensearch.gateway.remote.model.RemoteTemplatesMetadata.TEMPLATES_METADATA_FORMAT;
            CustomMetadata4.TYPE,
        remoteGlobalMetadataManager.writeAsync(
            return null;
        when(blobStoreTransferService.downloadBlob(anyIterable(), anyString())).thenReturn(
            CustomMetadata4.TYPE,
                NetworkModule.getNamedXContents().stream(),
            CLUSTER_UUID,
import org.opensearch.gateway.remote.model.RemoteCustomMetadata;
            clusterSettings,
        TestCapturingListener<ClusterMetadataManifest.UploadedMetadata> listener = new TestCapturingListener<>();
import static org.opensearch.gateway.remote.model.RemoteCustomMetadata.CUSTOM_METADATA;
        RemoteCustomMetadata customMetadataForUpload = new RemoteCustomMetadata(
        assertNotNull(listener.getResult());
        );
                hashesOfConsistentSettings,
        assertNotNull(listener.getResult());
    }
            compressor,
            CLUSTER_UUID,
        assertNull(listener.getResult());
            new CustomMetadata4("data4"),
        );
        Metadata.Custom customMetadata = getCustomMetadata();
            RemotePersistentSettingsMetadata.SETTINGS_METADATA_FORMAT.serialize(settingsMetadata, fileName, compressor, FORMAT_PARAMS)
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.CLUSTER_STATE_PATH_TOKEN;
import static org.mockito.Mockito.mock;
    public void testGetAsyncWriteRunnable_CoordinationMetadata() throws Exception {
            .uploadBlob(any(InputStream.class), anyIterable(), anyString(), eq(URGENT), any(ActionListener.class));
        assertEquals(4, splitFileName.length);
 */
    public void testGetAsyncWriteRunnable_PersistentSettings() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
            compressor,
        assertEquals(SETTING_METADATA, listener.getResult().getComponentName());
        RemotePersistentSettingsMetadata persistentSettings = new RemotePersistentSettingsMetadata(
        expectedUpserts = Map.of(
    private void verifyCustomMetadataReadForVersion(Version version) throws Exception {
            COORDINATION_METADATA,
    public void testGetAsyncReadRunnable_PersistentSettings() throws Exception {
            .build();
            CLUSTER_UUID,
import static org.opensearch.gateway.remote.model.RemoteCoordinationMetadata.COORDINATION_METADATA_FORMAT;
        assertNull(listener.getFailure());
        assertEquals(RemoteStoreUtils.invertLong(METADATA_VERSION), splitFileName[1]);
        );
                IndicesModule.getNamedXContents().stream(),
        assertEquals(coordinationMetadata, listener.getResult().getObj());
        );
        assertEquals(4, splitFileName.length);
            compressor
        assertEquals(4, splitFileName.length);
public class RemoteGlobalMetadataManagerTests extends OpenSearchTestCase {
        when(blobStoreTransferService.downloadBlob(anyIterable(), anyString())).thenReturn(
        assertEquals(RemoteStoreUtils.invertLong(METADATA_VERSION), splitFileName[1]);
        ClusterMetadataManifest.UploadedMetadata uploadedMetadata = listener.getResult();
        remoteGlobalMetadataManager.writeAsync(TEMPLATES_METADATA, templateMetadataForUpload, new LatchedActionListener<>(listener, latch));
            new CustomMetadata4("data4"),
        assertEquals(CLUSTER_UUID, pathTokens[2]);
    public void tearDown() throws Exception {
            .uploadBlob(any(InputStream.class), anyIterable(), anyString(), eq(URGENT), any(ActionListener.class));
        String[] pathTokens = uploadedFileName.split(PATH_DELIMITER);
        assertEquals(TEMPLATES_METADATA, listener.getResult().getComponent());
        );
        );
            CustomMetadata1.TYPE,
        assertNull(listener.getFailure());
        latch.await();
    }
            new LatchedActionListener<>(listener, latch)
            templatesMetadataForDownload,
        assertNull(listener.getFailure());
import org.opensearch.core.compress.NoneCompressor;
        assertEquals(customMetadata, listener.getResult().getObj());
        RemoteCustomMetadata customMetadataForDownload = new RemoteCustomMetadata(
        TestCapturingListener<ClusterMetadataManifest.UploadedMetadata> listener = new TestCapturingListener<>();
        CoordinationMetadata coordinationMetadata = getCoordinationMetadata();
        assertEquals(ioException, listener.getFailure().getCause());
            CustomMetadata2.TYPE,
        String[] pathTokens = uploadedFileName.split(PATH_DELIMITER);
            return null;
    }
        assertEquals(5, pathTokens.length);
        when(blobStoreRepository.getCompressor()).thenReturn(compressor);
        latch.await();
        String[] pathTokens = uploadedFileName.split(PATH_DELIMITER);
            compressor,
import org.opensearch.cluster.metadata.DiffableStringMap;
    public void testGetAsyncWriteRunnable_CustomMetadata() throws Exception {
            COORDINATION_METADATA,
            CLUSTER_UUID,
    private final String CLUSTER_UUID = "test-cluster-uuid";
        doAnswer(invocationOnMock -> {
import org.opensearch.cluster.ClusterName;
            IndexGraveyard.TYPE,
        TestCapturingListener<RemoteReadResult> listener = new TestCapturingListener<>();
        remoteGlobalMetadataManager.writeAsync(
        String fileName = randomAlphaOfLength(10);
        assertNotNull(listener.getResult());
import static org.opensearch.gateway.remote.model.RemoteCoordinationMetadataTests.getCoordinationMetadata;
            new LatchedActionListener<>(listener, latch)
        ClusterMetadataManifest.UploadedMetadata uploadedMetadata = listener.getResult();
            invocationOnMock.getArgument(4, ActionListener.class).onResponse(null);
        RemoteGlobalMetadata globalMetadataForDownload = new RemoteGlobalMetadata(fileName, CLUSTER_UUID, compressor, xContentRegistry);
        TestCapturingListener<RemoteReadResult> listener = new TestCapturingListener<>();
            new CustomMetadata4("data4")
        CountDownLatch latch = new CountDownLatch(1);
        assertEquals(TRANSIENT_SETTING_METADATA, listener.getResult().getComponent());
        remoteGlobalMetadataManager.readAsync(
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            CustomMetadata2.TYPE,
        );
        assertThat(customsDiff.getDeletes(), is(List.of(CustomMetadata1.TYPE)));
        );
        assertNull(listener.getFailure());
        super.tearDown();
        assertEquals(RemoteClusterStateUtils.encodeString(CLUSTER_NAME), pathTokens[0]);
            new CustomMetadata3("data3-changed"),
            new CustomMetadata2("data2"),
        TestCapturingListener<ClusterMetadataManifest.UploadedMetadata> listener = new TestCapturingListener<>();
        when(blobStoreRepository.getNamedXContentRegistry()).thenReturn(xContentRegistry);
            compressor,
            verifyCustomMetadataReadForVersion(version);
    private final String CLUSTER_NAME = "test-cluster";
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        assertThat(customsDiff.getDeletes(), is(List.of(CustomMetadata1.TYPE)));
        RemoteTemplatesMetadata templateMetadataForUpload = new RemoteTemplatesMetadata(
            new CustomMetadata3("data3-changed"),
            xContentRegistry
            .getCustomsDiff(currentState, previousState, true, false);
import org.opensearch.cluster.coordination.CoordinationMetadata;
            METADATA_VERSION,
            xContentRegistry
            ).flatMap(Function.identity()).collect(toList())
        );
        assertEquals(HASHES_OF_CONSISTENT_SETTINGS, uploadedMetadata.getComponent());
    }
            coordinationMetadata,
            coordinationMetadataForDownload,
        TestCapturingListener<RemoteReadResult> listener = new TestCapturingListener<>();
        customsDiff = remoteGlobalMetadataManager.getCustomsDiff(currentState, previousState, true, true);
            hashesOfConsistentSettingsForUpload,
        assertEquals(COORDINATION_METADATA, uploadedMetadata.getComponent());
        CountDownLatch latch = new CountDownLatch(1);
        );
            new LatchedActionListener<>(listener, latch)
        ClusterState previousState = ClusterState.builder(new ClusterName("test-cluster"))
        }).when(blobStoreTransferService)
            remoteCoordinationMetadata,
        assertEquals(4, splitFileName.length);
        Map<String, Metadata.Custom> currentCustoms = Map.of(
            CustomMetadata2.TYPE,
        String fileName = randomAlphaOfLength(10);
                fileName,
        remoteGlobalMetadataManager.readAsync(SETTING_METADATA, persistentSettings, new LatchedActionListener<>(listener, latch));
        assertTrue(isGlobalStateEquals(metadata, (Metadata) listener.getResult().getObj()));
        remoteGlobalMetadataManager = new RemoteGlobalMetadataManager(
            version
        // verify update global metadata upload timeout
    @Before
            CustomMetadata3.TYPE,
        TestCapturingListener<ClusterMetadataManifest.UploadedMetadata> listener = new TestCapturingListener<>();
    private NamedWriteableRegistry namedWriteableRegistry;
        assertEquals(CLUSTER_UUID, pathTokens[2]);
        );
        assertEquals(CLUSTER_UUID, pathTokens[2]);
            METADATA_VERSION,
        when(blobStoreTransferService.downloadBlob(anyIterable(), anyString())).thenReturn(
        assertEquals(settingsMetadata, listener.getResult().getObj());
        String uploadedFileName = uploadedMetadata.getUploadedFilename();
            new CustomMetadata3("data3-changed"),
        remoteGlobalMetadataManager.readAsync(IndexGraveyard.TYPE, customMetadataForDownload, new LatchedActionListener<>(listener, latch));
        String[] pathTokens = uploadedFileName.split(PATH_DELIMITER);
import static org.opensearch.gateway.remote.RemoteClusterStateTestUtils.CustomMetadata2;
        assertEquals(5, pathTokens.length);
        assertNotNull(listener.getResult());
        assertEquals(GLOBAL_METADATA_PATH_TOKEN, pathTokens[3]);
        assertNotNull(listener.getResult());
    public void testGetAsyncWriteRunnable_TransientSettings() throws Exception {
        int globalMetadataUploadTimeout = randomIntBetween(1, 10);
            CustomMetadata3.TYPE,
import static org.opensearch.common.blobstore.stream.write.WritePriority.URGENT;
            CustomMetadata3.TYPE,
import static org.opensearch.gateway.remote.RemoteClusterStateTestUtils.CustomMetadata5;
import org.opensearch.common.settings.ClusterSettings;
            METADATA_VERSION,
        assertEquals(GLOBAL_METADATA_CURRENT_CODEC_VERSION, Integer.parseInt(splitFileName[3]));
            blobStoreRepository,
        assertEquals(CLUSTER_STATE_PATH_TOKEN, pathTokens[1]);
            compressor,
        remoteGlobalMetadataManager.writeAsync(TRANSIENT_SETTING_METADATA, transientSettings, new LatchedActionListener<>(listener, latch));
            HASHES_OF_CONSISTENT_SETTINGS,
            METADATA_VERSION,
            new CustomMetadata4("data4"),
        latch.await();
        assertThat(customsDiff.getUpserts(), is(expectedUpserts));
        assertEquals(CLUSTER_UUID, pathTokens[2]);
        RemoteCoordinationMetadata remoteCoordinationMetadata = new RemoteCoordinationMetadata(
            CustomMetadata3.TYPE,
        Settings newSettings = Settings.builder()
        CountDownLatch latch = new CountDownLatch(1);
        assertThat(customsDiff.getDeletes(), is(List.of()));
        CountDownLatch latch = new CountDownLatch(1);
        latch.await();
 *
            xContentRegistry
                .streamInput()
            compressor,
import static org.opensearch.gateway.remote.model.RemoteGlobalMetadata.GLOBAL_METADATA_FORMAT;
            CLUSTER_UUID,
        Map<String, Metadata.Custom> previousCustoms = Map.of(
import org.opensearch.gateway.remote.model.RemoteTemplatesMetadata;
        assertNull(listener.getFailure());
        assertEquals(COORDINATION_METADATA, listener.getResult().getComponent());
        remoteGlobalMetadataManager.readAsync(TRANSIENT_SETTING_METADATA, transientSettings, new LatchedActionListener<>(listener, latch));
}
import java.util.function.Function;
import org.opensearch.Version;
import static org.opensearch.gateway.remote.RemoteClusterStateTestUtils.CustomMetadata4;
import org.junit.Before;
        customsDiff = remoteGlobalMetadataManager.getCustomsDiff(currentState, previousState, false, false);
            CLUSTER_UUID,
import static org.opensearch.gateway.remote.model.RemoteTransientSettingsMetadata.TRANSIENT_SETTING_METADATA;
        RemoteTransientSettingsMetadata transientSettings = new RemoteTransientSettingsMetadata(
import java.util.stream.Stream;
        String fileName = randomAlphaOfLength(10);
    public void testGetAsyncWriteRunnable_TemplatesMetadata() throws Exception {
import org.opensearch.gateway.remote.model.RemotePersistentSettingsMetadata;
            CLUSTER_UUID,
import java.util.Map;
        String uploadedFileName = uploadedMetadata.getUploadedFilename();
        assertEquals(GLOBAL_METADATA_PATH_TOKEN, pathTokens[3]);
        String uploadedFileName = uploadedMetadata.getUploadedFilename();
        );
        String[] splitFileName = pathTokens[4].split(DELIMITER);
        TestCapturingListener<ClusterMetadataManifest.UploadedMetadata> listener = new TestCapturingListener<>();
import static java.util.stream.Collectors.toList;
        when(blobStoreTransferService.downloadBlob(anyIterable(), anyString())).thenReturn(
            new CustomMetadata3("data3-changed"),
        }).when(blobStoreTransferService)
        assertEquals(RemoteClusterStateUtils.encodeString(CLUSTER_NAME), pathTokens[0]);
        assertEquals(RemoteClusterStateUtils.encodeString(CLUSTER_NAME), pathTokens[0]);
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.PATH_DELIMITER;
        assertEquals(hashesOfConsistentSettings, listener.getResult().getObj());
        assertEquals(COORDINATION_METADATA, listener.getResult().getComponentName());
            invocationOnMock.getArgument(4, ActionListener.class).onFailure(ioException);
        );
        assertTrue(listener.getFailure() instanceof RemoteStateTransferException);
        Metadata.Custom customMetadata = getCustomMetadata();
            .metadata(Metadata.builder().customs(currentCustoms))
        assertEquals(GLOBAL_METADATA_CURRENT_CODEC_VERSION, Integer.parseInt(splitFileName[3]));
        assertEquals(ioException, listener.getFailure().getCause());
            invocationOnMock.getArgument(4, ActionListener.class).onResponse(null);
        );
        TestCapturingListener<RemoteReadResult> listener = new TestCapturingListener<>();
import org.opensearch.cluster.DiffableUtils;
    public void testGetAsyncReadRunnable_IOException() throws Exception {
import org.opensearch.common.network.NetworkModule;
        assertNotNull(listener.getResult());
        assertEquals(TEMPLATES_METADATA, listener.getResult().getComponentName());
        );
            compressor,
    public void testGetAsyncReadRunnable_HashesOfConsistentSettings() throws Exception {
    }
            new CustomMetadata5("data5")
        assertEquals(GLOBAL_METADATA_PATH_TOKEN, pathTokens[3]);
        );
            CLUSTER_UUID,
        assertEquals(TEMPLATES_METADATA, uploadedMetadata.getComponent());
        assertEquals(4, splitFileName.length);
        doAnswer(invocationOnMock -> {
        assertNotNull(listener.getFailure());
            Stream.of(
        RemotePersistentSettingsMetadata persistentSettings = new RemotePersistentSettingsMetadata(
        );
        String uploadedFileName = uploadedMetadata.getUploadedFilename();
import static org.opensearch.gateway.remote.model.RemoteCoordinationMetadata.COORDINATION_METADATA;
import org.opensearch.threadpool.TestThreadPool;
            METADATA_VERSION,
        assertEquals(globalMetadataUploadTimeout, remoteGlobalMetadataManager.getGlobalMetadataUploadTimeout().seconds());
        assertEquals(HASHES_OF_CONSISTENT_SETTINGS, listener.getResult().getComponent());
        latch.await();
        String[] splitFileName = pathTokens[4].split(DELIMITER);
            .uploadBlob(any(InputStream.class), anyIterable(), anyString(), eq(URGENT), any(ActionListener.class));
        String fileName = randomAlphaOfLength(10);
        );
import java.util.concurrent.CountDownLatch;
            CustomMetadata5.TYPE,
        );
        );
        remoteGlobalMetadataManager.readAsync(GLOBAL_METADATA, globalMetadataForDownload, new LatchedActionListener<>(listener, latch));
import static org.opensearch.gateway.remote.model.RemoteTemplatesMetadata.TEMPLATES_METADATA;
    private RemoteGlobalMetadataManager remoteGlobalMetadataManager;
            fileName,
            invocationOnMock.getArgument(4, ActionListener.class).onResponse(null);
            compressor,
            new CustomMetadata5("data5"),
        CountDownLatch latch = new CountDownLatch(1);
            writableRegistry(),
            invocationOnMock.getArgument(4, ActionListener.class).onResponse(null);
            coordinationMetadata,
        latch.await();
        remoteGlobalMetadataManager.writeAsync(
            compressor,
            new CustomMetadata3("data3")
        assertNull(listener.getFailure());
import static org.mockito.ArgumentMatchers.eq;
        assertNull(listener.getResult());
        Map<String, Metadata.Custom> expectedUpserts = Map.of(
        ClusterMetadataManifest.UploadedMetadata uploadedMetadata = listener.getResult();
        IOException ioException = new IOException("mock test exception");
            CLUSTER_UUID,
import static org.opensearch.gateway.remote.model.RemoteCustomMetadataTests.getCustomMetadata;
            compressor,
        TestCapturingListener<RemoteReadResult> listener = new TestCapturingListener<>();
        assertEquals(CLUSTER_UUID, pathTokens[2]);
        assertNull(listener.getFailure());
            HASHES_OF_CONSISTENT_SETTINGS,
        assertEquals(GLOBAL_METADATA_CURRENT_CODEC_VERSION, Integer.parseInt(splitFileName[3]));
    }
import static org.opensearch.gateway.remote.model.RemoteGlobalMetadataTests.getGlobalMetadata;
        RemoteHashesOfConsistentSettings hashesOfConsistentSettingsForUpload = new RemoteHashesOfConsistentSettings(
        DiffableUtils.MapDiff<String, Metadata.Custom, Map<String, Metadata.Custom>> customsDiff = remoteGlobalMetadataManager
        assertEquals(GLOBAL_METADATA_CURRENT_CODEC_VERSION, Integer.parseInt(splitFileName[3]));
        );
import org.opensearch.cluster.ClusterState;
import java.io.IOException;
        BlobPath blobPath = new BlobPath();
        ClusterMetadataManifest.UploadedMetadata uploadedMetadata = listener.getResult();
        clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    private Compressor compressor;
        assertEquals(GLOBAL_METADATA_PATH_TOKEN, pathTokens[3]);
 * The OpenSearch Contributors require contributions made to
            compressor,
        RemoteCoordinationMetadata coordinationMetadataForDownload = new RemoteCoordinationMetadata(
            customMetadata,
    }
        String fileName = randomAlphaOfLength(10);
        ClusterMetadataManifest.UploadedMetadata uploadedMetadata = listener.getResult();
        assertEquals(HASHES_OF_CONSISTENT_SETTINGS, splitFileName[0]);
        DiffableStringMap hashesOfConsistentSettings = getHashesOfConsistentSettings();
            COORDINATION_METADATA_FORMAT.serialize(coordinationMetadata, fileName, compressor, FORMAT_PARAMS).streamInput()
        );
        latch.await();
import java.util.List;
        assertEquals(GLOBAL_METADATA_PATH_TOKEN, pathTokens[3]);
        );
        doAnswer(invocationOnMock -> {
            RemoteGlobalMetadataManager.GLOBAL_METADATA_UPLOAD_TIMEOUT_DEFAULT,
                compressor
    public void testGetAsyncWriteRunnable_HashesOfConsistentSettings() throws Exception {
        latch.await();
        assertEquals(String.join(CUSTOM_DELIMITER, CUSTOM_METADATA, IndexGraveyard.TYPE), uploadedMetadata.getComponent());
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.GLOBAL_METADATA_PATH_TOKEN;
        customsDiff = remoteGlobalMetadataManager.getCustomsDiff(currentState, previousState, false, true);
            return null;
    }
        assertEquals(GLOBAL_METADATA_PATH_TOKEN, pathTokens[3]);
        TestCapturingListener<ClusterMetadataManifest.UploadedMetadata> listener = new TestCapturingListener<>();
            xContentRegistry
        assertEquals(templatesMetadata, listener.getResult().getObj());
import org.opensearch.threadpool.ThreadPool;
        }).when(blobStoreTransferService)
            compressor,
        // verify default value
        CountDownLatch latch = new CountDownLatch(1);
        assertEquals(RemoteClusterStateUtils.encodeString(CLUSTER_NAME), pathTokens[0]);
            fileName,
import static org.opensearch.gateway.remote.RemoteClusterStateTestUtils.CustomMetadata1;
        assertEquals(COORDINATION_METADATA, splitFileName[0]);
        assertNull(listener.getFailure());
        }).when(blobStoreTransferService)
            new LatchedActionListener<>(listener, latch)
            IndexGraveyard.TYPE,
            new CustomMetadata2("data2"),
        );
            xContentRegistry
            CLUSTER_UUID,
        RemoteHashesOfConsistentSettings hashesOfConsistentSettingsForDownload = new RemoteHashesOfConsistentSettings(
            customMetadataForUpload,
        CountDownLatch latch = new CountDownLatch(1);
    private NamedXContentRegistry xContentRegistry;
            new CustomMetadata2("data2"),
import org.opensearch.gateway.remote.model.RemoteGlobalMetadata;
        String[] splitFileName = pathTokens[4].split(DELIMITER);
            .build();
        String[] splitFileName = pathTokens[4].split(DELIMITER);
        assertNull(listener.getFailure());
    }
        assertEquals(settingsMetadata, listener.getResult().getObj());
        when(blobStoreTransferService.downloadBlob(anyIterable(), anyString())).thenReturn(
            CustomMetadata5.TYPE,
        Settings settingsMetadata = getSettings();
            CustomMetadata3.TYPE,
        assertNotNull(listener.getResult());
            remoteGlobalMetadataManager.getGlobalMetadataUploadTimeout()
        latch.await();
            COORDINATION_METADATA,
import static org.opensearch.gateway.remote.model.RemoteTemplatesMetadataTests.getTemplatesMetadata;
        when(blobStoreTransferService.downloadBlob(anyIterable(), anyString())).thenReturn(
        assertEquals(5, pathTokens.length);
        );
        DiffableStringMap hashesOfConsistentSettings = getHashesOfConsistentSettings();
        assertEquals(5, pathTokens.length);
            namedWriteableRegistry
            new CustomMetadata2("data2"),
            IndexGraveyard.TYPE,
import org.opensearch.gateway.remote.model.RemoteTransientSettingsMetadata;
        String[] pathTokens = uploadedFileName.split(PATH_DELIMITER);
            CLUSTER_UUID,
        remoteGlobalMetadataManager.readAsync(
        assertEquals(SETTING_METADATA, uploadedMetadata.getComponent());
        RemoteTransientSettingsMetadata transientSettings = new RemoteTransientSettingsMetadata(
            settingsMetadata,
        doAnswer(invocationOnMock -> {
        );
        String[] splitFileName = pathTokens[4].split(DELIMITER);
        }
    public void testGetAsyncReadRunnable_CustomMetadata() throws Exception {
        }).when(blobStoreTransferService)
            CustomMetadata4.TYPE,
        }).when(blobStoreTransferService)
        RemoteCoordinationMetadata remoteCoordinationMetadata = new RemoteCoordinationMetadata(
            new CustomMetadata4("data4"),
        assertEquals(GLOBAL_METADATA, listener.getResult().getComponent());
        assertEquals(IndexGraveyard.TYPE, listener.getResult().getComponentName());
        );
            new CustomMetadata5("data5")
    public void testGetAsyncReadRunnable_TransientSettings() throws Exception {
            .uploadBlob(any(InputStream.class), anyIterable(), anyString(), eq(URGENT), any(ActionListener.class));
    public void testGetAsyncWriteRunnable_IOException() throws Exception {
            CLUSTER_UUID,
        assertEquals(SETTING_METADATA, listener.getResult().getComponent());
        Settings settingsMetadata = getSettings();
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.CUSTOM_DELIMITER;
        assertNotNull(listener.getResult());
        CountDownLatch latch = new CountDownLatch(1);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.translog.transfer.BlobStoreTransferService;
        assertEquals(HASHES_OF_CONSISTENT_SETTINGS, listener.getResult().getComponentName());
            new CustomMetadata1("data1"),
    private BlobStoreRepository blobStoreRepository;
            new LatchedActionListener<>(listener, latch)
    private BlobStoreTransferService blobStoreTransferService;
            xContentRegistry
import org.opensearch.cluster.metadata.TemplatesMetadata;
            GLOBAL_METADATA_FORMAT.serialize(metadata, fileName, compressor, FORMAT_PARAMS).streamInput()
        CountDownLatch latch = new CountDownLatch(1);
            .build();
        when(blobStoreTransferService.downloadBlob(anyIterable(), anyString())).thenThrow(ioException);
    }
                ClusterModule.getNamedXWriteables().stream()
        assertEquals(RemoteClusterStateUtils.encodeString(CLUSTER_NAME), pathTokens[0]);
    }
        assertEquals(RemoteStoreUtils.invertLong(METADATA_VERSION), splitFileName[1]);
    public void testGetAsyncReadRunnable_TemplatesMetadata() throws Exception {
            TEMPLATES_METADATA,
        }).when(blobStoreTransferService)
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.FORMAT_PARAMS;
    private final ThreadPool threadPool = new TestThreadPool(getClass().getName());
        assertNull(listener.getFailure());
            compressor,
    public void setup() {
        when(blobStoreRepository.basePath()).thenReturn(blobPath);
 * this file be licensed under the Apache-2.0 license or a
        );
            fileName,
        ClusterMetadataManifest.UploadedMetadata uploadedMetadata = listener.getResult();
                .streamInput()
        assertEquals(4, splitFileName.length);
        remoteGlobalMetadataManager.writeAsync(SETTING_METADATA, persistentSettings, new LatchedActionListener<>(listener, latch));
import org.opensearch.index.remote.RemoteStoreUtils;
        assertEquals(RemoteClusterStateUtils.encodeString(CLUSTER_NAME), pathTokens[0]);
            threadPool
        assertThat(customsDiff.getUpserts(), is(expectedUpserts));
        assertEquals(5, pathTokens.length);
    public void testGlobalMetadataUploadWaitTimeSetting() {
            TEMPLATES_METADATA_FORMAT.serialize(templatesMetadata, fileName, compressor, FORMAT_PARAMS).streamInput()
            ).streamInput()
            customMetadataForDownload.customBlobStoreFormat.serialize(customMetadata, fileName, compressor).streamInput()
import org.opensearch.core.action.ActionListener;
            return null;
        TestCapturingListener<RemoteReadResult> listener = new TestCapturingListener<>();
        );
        assertTrue(listener.getFailure() instanceof RemoteStateTransferException);
        assertEquals(CLUSTER_STATE_PATH_TOKEN, pathTokens[1]);
            xContentRegistry
        Metadata metadata = getGlobalMetadata();
    }
        String fileName = randomAlphaOfLength(10);
        threadPool.shutdown();
        TestCapturingListener<RemoteReadResult> listener = new TestCapturingListener<>();
            METADATA_VERSION,
            CLUSTER_UUID,
        latch.await();
            new LatchedActionListener<>(listener, latch)
        remoteGlobalMetadataManager.writeAsync(
        assertEquals(5, pathTokens.length);
import org.opensearch.common.blobstore.BlobPath;
        assertEquals(SETTING_METADATA, splitFileName[0]);
        assertEquals(CUSTOM_METADATA, listener.getResult().getComponent());
        when(blobStoreTransferService.downloadBlob(anyIterable(), anyString())).thenReturn(
    }
import static org.opensearch.gateway.remote.model.RemotePersistentSettingsMetadataTests.getSettings;
    @After
        CoordinationMetadata coordinationMetadata = getCoordinationMetadata();
        doAnswer(invocationOnMock -> {
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.DELIMITER;
        expectedUpserts = Map.of(
import org.opensearch.cluster.ClusterModule;
            xContentRegistry
        assertEquals(RemoteStoreUtils.invertLong(METADATA_VERSION), splitFileName[1]);
        assertEquals(
        assertEquals(TRANSIENT_SETTING_METADATA, splitFileName[0]);
        assertEquals(String.join(CUSTOM_DELIMITER, CUSTOM_METADATA, IndexGraveyard.TYPE), splitFileName[0]);
        clusterSettings.applySettings(newSettings);
            Version.CURRENT
            CustomMetadata3.TYPE,
            return null;
        CountDownLatch latch = new CountDownLatch(1);
import static org.mockito.Mockito.doAnswer;
        assertNotNull(listener.getResult());
        compressor = new NoneCompressor();
            settingsMetadata,
        assertEquals(TRANSIENT_SETTING_METADATA, uploadedMetadata.getComponent());
    }
        assertThat(customsDiff.getUpserts(), is(expectedUpserts));
        );
        blobStoreRepository = mock(BlobStoreRepository.class);
            hashesOfConsistentSettings,
        CountDownLatch latch = new CountDownLatch(1);
        String[] pathTokens = uploadedFileName.split(PATH_DELIMITER);
        String fileName = randomAlphaOfLength(10);
        );
            hashesOfConsistentSettingsForDownload.hashesOfConsistentSettingsFormat.serialize(
        TestCapturingListener<RemoteReadResult> listener = new TestCapturingListener<>();
            CLUSTER_NAME,
            return null;
        Settings settingsMetadata = getSettings();
        assertEquals(TEMPLATES_METADATA, splitFileName[0]);
            CustomMetadata4.TYPE,
        assertEquals(GLOBAL_METADATA_CURRENT_CODEC_VERSION, Integer.parseInt(splitFileName[3]));
        assertNull(listener.getFailure());
    }
import org.opensearch.gateway.remote.model.RemoteReadResult;
import static org.opensearch.gateway.remote.model.RemoteHashesOfConsistentSettings.HASHES_OF_CONSISTENT_SETTINGS;
    private final long METADATA_VERSION = 7331L;
import org.opensearch.gateway.remote.model.RemoteHashesOfConsistentSettings;
        assertEquals(GLOBAL_METADATA, listener.getResult().getComponentName());
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.GLOBAL_METADATA_CURRENT_CODEC_VERSION;
            fileName,
            METADATA_VERSION,
        assertEquals(RemoteStoreUtils.invertLong(METADATA_VERSION), splitFileName[1]);
            invocationOnMock.getArgument(4, ActionListener.class).onResponse(null);
            fileName,
            .put("cluster.remote_store.state.global_metadata.upload_timeout", globalMetadataUploadTimeout + "s")
            .uploadBlob(any(InputStream.class), anyIterable(), anyString(), eq(URGENT), any(ActionListener.class));
import org.opensearch.core.compress.Compressor;
            fileName,
/*
            remoteCoordinationMetadata,
import java.io.InputStream;
import org.opensearch.cluster.metadata.IndexGraveyard;
            customMetadataForUpload.getType(),
        assertNull(listener.getFailure());
        doAnswer(invocationOnMock -> {
            new LatchedActionListener<>(listener, latch)
            COORDINATION_METADATA,
            new CustomMetadata3("data3-changed"),
            .uploadBlob(any(InputStream.class), anyIterable(), anyString(), eq(URGENT), any(ActionListener.class));
        TestCapturingListener<ClusterMetadataManifest.UploadedMetadata> listener = new TestCapturingListener<>();
import org.opensearch.indices.IndicesModule;
        IOException ioException = new IOException("mock test exception");
            CustomMetadata2.TYPE,
            CustomMetadata5.TYPE,
        CountDownLatch latch = new CountDownLatch(1);
        latch.await();
        assertNotNull(listener.getFailure());
        assertThat(customsDiff.getUpserts(), is(expectedUpserts));
            fileName,
        assertEquals(CLUSTER_STATE_PATH_TOKEN, pathTokens[1]);
        assertNull(listener.getFailure());
        String uploadedFileName = uploadedMetadata.getUploadedFilename();
        );
        String uploadedFileName = uploadedMetadata.getUploadedFilename();
        namedWriteableRegistry = writableRegistry();
            .metadata(Metadata.builder().customs(previousCustoms))
        CountDownLatch latch = new CountDownLatch(1);
        RemoteTemplatesMetadata templatesMetadataForDownload = new RemoteTemplatesMetadata(
        TemplatesMetadata templatesMetadata = getTemplatesMetadata();
        doAnswer(invocationOnMock -> {
        );
        String fileName = randomAlphaOfLength(10);
import static org.opensearch.gateway.remote.model.RemotePersistentSettingsMetadata.SETTING_METADATA;
import static org.opensearch.gateway.remote.model.RemoteHashesOfConsistentSettingsTests.getHashesOfConsistentSettings;
import org.opensearch.common.settings.Settings;
        CountDownLatch latch = new CountDownLatch(1);
import org.junit.After;
import static org.mockito.ArgumentMatchers.any;
            namedWriteableRegistry,
        latch.await();
        assertNotNull(listener.getResult());
    public void testGetAsyncReadRunnable_CoordinationMetadata() throws Exception {
