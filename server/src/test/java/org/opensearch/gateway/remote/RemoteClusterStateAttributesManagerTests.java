        assertEquals(4, splitFileName.length);
        doAnswer(invocationOnMock -> {
import org.opensearch.threadpool.ThreadPool;
    public void testGetAsyncWriteRunnable_Exception() throws IOException, InterruptedException {
        assertEquals(custom, capturingListener.getResult().getObj());
        assertThat(customsDiff.getDeletes(), is(List.of(TestClusterStateCustom1.TYPE)));
import static org.opensearch.gateway.remote.model.RemoteClusterBlocks.CLUSTER_BLOCKS;
import org.opensearch.cluster.DiffableUtils;
        assertNull(capturingListener.getFailure());
import static org.opensearch.gateway.remote.RemoteClusterStateAttributesManager.CLUSTER_STATE_ATTRIBUTES_CURRENT_CODEC_VERSION;
            CLUSTER_STATE_CUSTOM,
import static org.hamcrest.Matchers.is;
        final TestCapturingListener<ClusterMetadataManifest.UploadedMetadata> listener = new TestCapturingListener<>();
import org.opensearch.cluster.block.ClusterBlocks;
import org.opensearch.cluster.ClusterState;
            remoteClusterStateCustoms.clusterStateCustomsFormat.serialize(custom, fileName, compressor).streamInput()
        assertNull(listener.getFailure());
            invocationOnMock.getArgument(4, ActionListener.class).onResponse(null);
import org.opensearch.cluster.ClusterState.Custom;
        assertEquals(String.join(CUSTOM_DELIMITER, CLUSTER_STATE_CUSTOM, custom.getWriteableName()), listener.getResult().getComponent());
        TestCapturingListener<ClusterMetadataManifest.UploadedMetadata> capturingListener = new TestCapturingListener<>();
        assertEquals(CLUSTER_STATE_EPHEMERAL_PATH_TOKEN, pathTokens[3]);
        RemoteDiscoveryNodes remoteDiscoveryNodes = new RemoteDiscoveryNodes(discoveryNodes, VERSION, CLUSTER_UUID, compressor);
/*
        );
        assertThat(customsDiff.getUpserts(), is(currentCustoms));
            blobStoreRepository,
        TestCapturingListener<RemoteReadResult> capturingListener = new TestCapturingListener<>();
    }
        assertEquals(CLUSTER_STATE_EPHEMERAL_PATH_TOKEN, pathTokens[3]);
        latch.await();
public class RemoteClusterStateAttributesManagerTests extends OpenSearchTestCase {
import static org.opensearch.gateway.remote.RemoteClusterStateTestUtils.TestClusterStateCustom3;
        remoteClusterStateAttributesManager.readAsync(CLUSTER_BLOCKS, remoteClusterBlocks, new LatchedActionListener<>(listener, latch));
        super.tearDown();
    }
        String[] splitFileName = pathTokens[4].split(DELIMITER);
        );
import java.util.List;
        assertEquals(5, pathTokens.length);
        remoteClusterStateAttributesManager.readAsync(DISCOVERY_NODES, remoteObjForDownload, new LatchedActionListener<>(listener, latch));
        );
            remoteClusterStateCustoms,
        );
        remoteClusterStateAttributesManager.writeAsync(DISCOVERY_NODES, remoteDiscoveryNodes, new LatchedActionListener<>(listener, latch));
    public void testGetUpdatedCustoms() {
import org.opensearch.cluster.ClusterName;
        latch.await();
            TestClusterStateCustom2.TYPE,
import org.opensearch.common.util.TestCapturingListener;
            namedWriteableRegistry
            remoteObjForDownload.discoveryNodesFormat.serialize(
        doAnswer(invocationOnMock -> {
        );
 * The OpenSearch Contributors require contributions made to
            return null;
            new LatchedActionListener<>(listener, latch)
    private Compressor compressor;
import org.opensearch.core.action.ActionListener;
            remoteClusterBlocks.clusterBlocksFormat.serialize(clusterBlocks, fileName, compressor).streamInput()
        TestCapturingListener<RemoteReadResult> listener = new TestCapturingListener<>();
        }).when(blobStoreTransferService)
            fileName,
            .uploadBlob(any(InputStream.class), anyIterable(), anyString(), eq(URGENT), any(ActionListener.class));
import java.util.Collections;
        String fileName = randomAlphaOfLength(10);
        blobStoreTransferService = mock(BlobStoreTransferService.class);
        assertEquals(CLUSTER_BLOCKS, listener.getResult().getComponentName());
import static org.opensearch.gateway.remote.RemoteClusterStateTestUtils.TestClusterStateCustom4;
        remoteClusterStateAttributesManager.writeAsync(
 * compatible open source license.
        final CountDownLatch latch = new CountDownLatch(1);
        assertThat(customsDiff.getUpserts(), is(expectedCustoms));
import static org.opensearch.common.blobstore.stream.write.WritePriority.URGENT;
        String uploadedFileName = listener.getResult().getUploadedFilename();
    }
        DiscoveryNodes discoveryNodes = getDiscoveryNodes();
        assertNull(listener.getFailure());
 */
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.CLUSTER_STATE_PATH_TOKEN;
        namedWriteableRegistry = writableRegistry();
import org.opensearch.cluster.node.DiscoveryNodes;
            VERSION,
            custom.getWriteableName(),
            custom.getWriteableName(),
            return null;
            custom,
    }
import org.opensearch.core.compress.Compressor;
        when(blobStoreTransferService.downloadBlob(anyIterable(), anyString())).thenReturn(
        BlobStoreRepository blobStoreRepository = mock(BlobStoreRepository.class);
        assertThat(customsDiff.getDeletes(), is(Collections.emptyList()));
            invocationOnMock.getArgument(4, ActionListener.class).onFailure(ioException);
package org.opensearch.gateway.remote;
        latch.await();
            new TestClusterStateCustom3("data3-changed"),
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.DELIMITER;
        assertEquals(CLUSTER_UUID, pathTokens[2]);
        discoveryNodes.getNodes().forEach((nodeId, node) -> assertEquals(readDiscoveryNodes.get(nodeId), node));
            TestClusterStateCustom1.TYPE,
            CLUSTER_UUID,
        Map<String, ClusterState.Custom> previousCustoms = Map.of(
import org.opensearch.Version;
        latch.await();
        String fileName = randomAlphaOfLength(10);
    public void testGetAsyncReadRunnable_ClusterBlocks() throws IOException, InterruptedException {
    public void testGetAsyncWriteRunnable_Custom() throws IOException, InterruptedException {
 *
        assertEquals(DISCOVERY_NODES, splitFileName[0]);
        assertNotNull(listener.getResult());
        final TestCapturingListener<ClusterMetadataManifest.UploadedMetadata> listener = new TestCapturingListener<>();
        String[] pathTokens = uploadedFileName.split(PATH_DELIMITER);
        String fileName = randomAlphaOfLength(10);
import static org.mockito.ArgumentMatchers.anyIterable;
        RemoteDiscoveryNodes remoteObjForDownload = new RemoteDiscoveryNodes(fileName, "cluster-uuid", compressor, Version.CURRENT);
                discoveryNodes,
    public void testGetAsyncWriteRunnable_ClusterBlocks() throws IOException, InterruptedException {
        Custom custom = getClusterStateCustom();
import static org.opensearch.gateway.remote.model.RemoteClusterStateCustomsTests.getClusterStateCustom;
        IOException ioException = new IOException("mock test exception");
        assertEquals(RemoteClusterStateUtils.encodeString(CLUSTER_NAME), pathTokens[0]);
        ClusterState previousState = ClusterState.builder(new ClusterName("test-cluster")).customs(previousCustoms).build();
        assertEquals(clusterBlocks.global(), readClusterBlocks.global());
            CLUSTER_UUID,
import static org.mockito.ArgumentMatchers.any;
            remoteDiscoveryNodes,
        String uploadedFileName = listener.getResult().getUploadedFilename();
            new LatchedActionListener<>(capturingListener, latch)
        assertEquals(CLUSTER_BLOCKS, splitFileName[0]);
        );
            new TestClusterStateCustom3("data3")
        remoteClusterStateAttributesManager.readAsync(
            compressor,
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.CUSTOM_DELIMITER;
        RemoteClusterBlocks remoteClusterBlocks = new RemoteClusterBlocks(clusterBlocks, VERSION, CLUSTER_UUID, compressor);
}
        assertNotNull(listener.getResult());
        assertEquals(CLUSTER_BLOCKS, listener.getResult().getComponent());
            new TestClusterStateCustom1("data1"),
import static org.opensearch.gateway.remote.model.RemoteDiscoveryNodesTests.getDiscoveryNodes;
        assertTrue(capturingListener.getFailure() instanceof RemoteStateTransferException);
        customsDiff = remoteClusterStateAttributesManager.getUpdatedCustoms(currentState, previousState, true, false);
    }
import org.opensearch.gateway.remote.model.RemoteDiscoveryNodes;
            namedWriteableRegistry,
        DiscoveryNodes readDiscoveryNodes = (DiscoveryNodes) listener.getResult().getObj();
        }).when(blobStoreTransferService)
            new TestClusterStateCustom3("data3-changed"),
        CountDownLatch latch = new CountDownLatch(1);
    public void testGetAsyncReadRunnable_Exception() throws IOException, InterruptedException {
        assertEquals(CLUSTER_STATE_PATH_TOKEN, pathTokens[1]);
        final CountDownLatch latch = new CountDownLatch(1);
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.CLUSTER_STATE_EPHEMERAL_PATH_TOKEN;
    private final long VERSION = 7331L;
        assertEquals(String.join(CUSTOM_DELIMITER, CLUSTER_STATE_CUSTOM, custom.getWriteableName()), splitFileName[0]);
            DISCOVERY_NODES,
        doAnswer(invocationOnMock -> {
        assertThat(customsDiff.getDeletes(), is(Collections.emptyList()));
        assertNull(listener.getFailure());
        }).when(blobStoreTransferService)
            ).streamInput()
import static org.opensearch.gateway.remote.model.RemoteClusterBlocksTests.randomClusterBlocks;
        final CountDownLatch latch = new CountDownLatch(1);
import static org.opensearch.gateway.remote.model.RemoteClusterStateCustoms.CLUSTER_STATE_CUSTOM;
        Exception ioException = new IOException("mock test exception");
        String fileName = randomAlphaOfLength(10);
import org.opensearch.gateway.remote.model.RemoteClusterBlocks;
    public void testGetAsyncReadRunnable_DiscoveryNodes() throws IOException, InterruptedException {
        assertEquals(CLUSTER_UUID, pathTokens[2]);
        String[] pathTokens = uploadedFileName.split(PATH_DELIMITER);
import org.opensearch.threadpool.TestThreadPool;
            return null;
        assertEquals(CLUSTER_UUID, pathTokens[2]);
        assertEquals(4, splitFileName.length);
import static org.mockito.Mockito.doAnswer;
        assertNotNull(capturingListener.getResult());
        assertEquals(discoveryNodes.getSize(), readDiscoveryNodes.getSize());
        CountDownLatch latch = new CountDownLatch(1);
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            .uploadBlob(any(InputStream.class), anyIterable(), anyString(), eq(URGENT), any(ActionListener.class));
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.PATH_DELIMITER;
        assertEquals(invertLong(VERSION), splitFileName[1]);
import static org.opensearch.gateway.remote.RemoteClusterStateAttributesManager.CLUSTER_STATE_ATTRIBUTE;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        DiffableUtils.MapDiff<String, ClusterState.Custom, Map<String, ClusterState.Custom>> customsDiff =
        }
        when(blobStoreTransferService.downloadBlob(anyIterable(), anyString())).thenReturn(
        customsDiff = remoteClusterStateAttributesManager.getUpdatedCustoms(currentState, previousState, true, true);
        TestCapturingListener<RemoteReadResult> listener = new TestCapturingListener<>();
        assertEquals(CLUSTER_STATE_ATTRIBUTE, listener.getResult().getComponent());
import static org.mockito.ArgumentMatchers.eq;
        final TestCapturingListener<ClusterMetadataManifest.UploadedMetadata> listener = new TestCapturingListener<>();
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.encodeString;
        when(blobStoreRepository.basePath()).thenReturn(new BlobPath());
import org.opensearch.gateway.remote.model.RemoteReadResult;
            threadPool
        Map<String, ClusterState.Custom> expectedCustoms = Map.of(
        RemoteClusterStateCustoms remoteClusterStateCustoms = new RemoteClusterStateCustoms(
    }
    }
            new TestClusterStateCustom2("data2"),
import static org.opensearch.gateway.remote.RemoteClusterStateTestUtils.TestClusterStateCustom2;
        remoteClusterStateAttributesManager.writeAsync(
        );
            new TestClusterStateCustom2("data2"),
    @Before
import static org.opensearch.index.remote.RemoteStoreUtils.invertLong;
        assertTrue(capturingListener.getFailure() instanceof RemoteStateTransferException);
        latch.await();
        assertNull(listener.getFailure());
        RemoteClusterStateCustoms remoteClusterStateCustoms = new RemoteClusterStateCustoms(
        when(blobStoreTransferService.downloadBlob(anyIterable(), anyString())).thenReturn(
import org.opensearch.common.blobstore.BlobPath;
        when(blobStoreTransferService.downloadBlob(anyIterable(), anyString())).thenThrow(ioException);
            DISCOVERY_NODES,
        String[] pathTokens = uploadedFileName.split(PATH_DELIMITER);
        assertEquals(CLUSTER_STATE_ATTRIBUTE, listener.getResult().getComponent());
            blobStoreTransferService,
        ClusterState currentState = ClusterState.builder(new ClusterName("test-cluster")).customs(currentCustoms).build();
import org.opensearch.action.LatchedActionListener;
    public void setup() throws Exception {
    private RemoteClusterStateAttributesManager remoteClusterStateAttributesManager;
        remoteClusterStateAttributesManager = new RemoteClusterStateAttributesManager(
        assertEquals(CLUSTER_STATE_ATTRIBUTES_CURRENT_CODEC_VERSION, Integer.parseInt(splitFileName[3]));
        assertEquals(encodeString(CLUSTER_NAME), pathTokens[0]);
            invocationOnMock.getArgument(4, ActionListener.class).onResponse(null);
        RemoteDiscoveryNodes remoteDiscoveryNodes = new RemoteDiscoveryNodes(fileName, CLUSTER_UUID, compressor, Version.CURRENT);
        assertNull(listener.getFailure());
        assertEquals(DISCOVERY_NODES, listener.getResult().getComponentName());
import java.io.InputStream;
        assertEquals(5, pathTokens.length);
import org.opensearch.test.OpenSearchTestCase;
            TestClusterStateCustom3.TYPE,
        );
        assertNull(capturingListener.getResult());
        );
        latch.await();
        assertEquals(ioException, capturingListener.getFailure().getCause());
    }
        latch.await();
        assertEquals(CLUSTER_STATE_ATTRIBUTES_CURRENT_CODEC_VERSION, Integer.parseInt(splitFileName[3]));
        assertEquals(DISCOVERY_NODES, listener.getResult().getComponent());
    }
            .uploadBlob(any(InputStream.class), anyIterable(), anyString(), eq(URGENT), any(ActionListener.class));
        doAnswer(invocationOnMock -> {
            Version.CURRENT
import org.junit.Before;
        remoteClusterStateAttributesManager.writeAsync(CLUSTER_BLOCKS, remoteClusterBlocks, new LatchedActionListener<>(listener, latch));
        String uploadedFileName = listener.getResult().getUploadedFilename();
        Map<String, Custom> currentCustoms = Map.of(
import java.io.IOException;
 * SPDX-License-Identifier: Apache-2.0
        String[] splitFileName = pathTokens[4].split(DELIMITER);
        );
        remoteClusterStateAttributesManager.readAsync(
        assertNotNull(listener.getResult());
        ClusterBlocks readClusterBlocks = (ClusterBlocks) listener.getResult().getObj();
            new LatchedActionListener<>(capturingListener, latch)
                compressor
            CLUSTER_STATE_CUSTOM,
import org.opensearch.gateway.remote.model.RemoteClusterStateCustoms;
            TestClusterStateCustom3.TYPE,
import org.opensearch.common.settings.ClusterSettings;
        DiscoveryNodes discoveryNodes = getDiscoveryNodes();
import java.util.Map;
            remoteDiscoveryNodes,
        assertNull(capturingListener.getResult());
            return null;
            remoteClusterStateCustoms,
        assertEquals(4, splitFileName.length);
        latch.await();
        assertEquals(CLUSTER_STATE_EPHEMERAL_PATH_TOKEN, pathTokens[3]);
        RemoteClusterBlocks remoteClusterBlocks = new RemoteClusterBlocks(fileName, "cluster-uuid", compressor, Version.CURRENT);
        String[] splitFileName = pathTokens[4].split(DELIMITER);
        TestCapturingListener<RemoteReadResult> capturingListener = new TestCapturingListener<>();
        assertEquals(encodeString(CLUSTER_NAME), pathTokens[0]);
        assertEquals(CLUSTER_STATE_ATTRIBUTES_CURRENT_CODEC_VERSION, Integer.parseInt(splitFileName[3]));
        for (String index : clusterBlocks.indices().keySet()) {
            invocationOnMock.getArgument(4, ActionListener.class).onResponse(null);
        CountDownLatch latch = new CountDownLatch(1);
import org.opensearch.index.translog.transfer.BlobStoreTransferService;
        DiscoveryNodes discoveryNodes = getDiscoveryNodes();
        assertEquals(invertLong(VERSION), splitFileName[1]);
        final CountDownLatch latch = new CountDownLatch(1);
            TestClusterStateCustom4.TYPE,
        compressor = new NoneCompressor();
        assertThat(customsDiff.getUpserts(), is(Collections.emptyMap()));
import org.junit.After;
        );
    private NamedWriteableRegistry namedWriteableRegistry;
import static org.mockito.Mockito.when;
            new TestClusterStateCustom4("data4")
            new LatchedActionListener<>(capturingListener, latch)
import static org.opensearch.gateway.remote.RemoteClusterStateAttributesManager.DISCOVERY_NODES;
            compressor,
                (out, discoveryNode) -> discoveryNode.writeToWithAttribute(out),
import static org.mockito.ArgumentMatchers.anyString;
            writableRegistry(),
import org.opensearch.common.settings.Settings;
        );
                fileName,
        assertEquals(clusterBlocks.indices().keySet(), readClusterBlocks.indices().keySet());
    }
            new TestClusterStateCustom4("data4")
        assertEquals(CLUSTER_STATE_ATTRIBUTE, capturingListener.getResult().getComponent());
    @After
    private final String CLUSTER_UUID = "test-cluster-uuid";
        final CountDownLatch latch = new CountDownLatch(1);
    private final ThreadPool threadPool = new TestThreadPool(RemoteClusterStateAttributesManagerTests.class.getName());
    private final String CLUSTER_NAME = "test-cluster";
        assertEquals(invertLong(VERSION), splitFileName[1]);
            assertEquals(clusterBlocks.indices().get(index), readClusterBlocks.indices().get(index));
    private BlobStoreTransferService blobStoreTransferService;
        assertEquals(CLUSTER_STATE_PATH_TOKEN, pathTokens[1]);
        assertEquals(5, pathTokens.length);
    }
import static org.mockito.Mockito.mock;
        assertEquals(CLUSTER_STATE_PATH_TOKEN, pathTokens[1]);
        assertEquals(CLUSTER_STATE_CUSTOM, capturingListener.getResult().getComponentName());
            .uploadBlob(any(InputStream.class), anyIterable(), anyString(), eq(URGENT), any(ActionListener.class));
            remoteClusterStateAttributesManager.getUpdatedCustoms(currentState, previousState, false, randomBoolean());
        assertEquals(ioException, capturingListener.getFailure().getCause());
            CLUSTER_NAME,
    public void testGetAsyncReadRunnable_Custom() throws IOException, InterruptedException {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        ClusterBlocks clusterBlocks = randomClusterBlocks();
        }).when(blobStoreTransferService)
    public void testGetAsyncWriteRunnable_DiscoveryNodes() throws IOException, InterruptedException {
        ClusterBlocks clusterBlocks = randomClusterBlocks();
        threadPool.shutdown();
        assertEquals(discoveryNodes.getClusterManagerNodeId(), readDiscoveryNodes.getClusterManagerNodeId());
    public void tearDown() throws Exception {
import java.util.concurrent.CountDownLatch;
        );
        assertNotNull(listener.getResult());
        RemoteDiscoveryNodes remoteDiscoveryNodes = new RemoteDiscoveryNodes(discoveryNodes, VERSION, CLUSTER_UUID, compressor);
import static org.opensearch.gateway.remote.RemoteClusterStateTestUtils.TestClusterStateCustom1;
        assertNotNull(listener.getResult());
            TestClusterStateCustom4.TYPE,
            TestClusterStateCustom2.TYPE,
import org.opensearch.core.compress.NoneCompressor;
        Custom custom = getClusterStateCustom();
            TestClusterStateCustom3.TYPE,
