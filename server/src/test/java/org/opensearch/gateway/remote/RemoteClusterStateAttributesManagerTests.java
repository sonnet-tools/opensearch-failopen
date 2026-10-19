        assertEquals(4, splitFileName.length);
        final TestCapturingListener<ClusterMetadataManifest.UploadedMetadata> listener = new TestCapturingListener<>();  
            custom.getWriteableName(),
        Custom custom = getClusterStateCustom();
import static org.opensearch.gateway.remote.model.RemoteClusterBlocks.CLUSTER_BLOCKS;
        );
        String[] pathTokens = uploadedFileName.split(PATH_DELIMITER);
            invocationOnMock.getArgument(4, ActionListener.class).onResponse(null);
            new TestClusterStateCustom3("data3-changed"),  
import static org.mockito.ArgumentMatchers.anyString;
        assertThat(customsDiff.getUpserts(), is(Collections.emptyMap()));  
    private BlobStoreTransferService blobStoreTransferService;
            new TestClusterStateCustom2("data2"),
        assertEquals(String.join(CUSTOM_DELIMITER, CLUSTER_STATE_CUSTOM, custom.getWriteableName()), splitFileName[0]);
    private Compressor compressor;
        latch.await();  
        );  
            new LatchedActionListener<>(listener, latch)
import java.util.concurrent.CountDownLatch;
            CLUSTER_NAME,
import org.opensearch.core.compress.Compressor;  
import org.opensearch.cluster.ClusterState;
        TestCapturingListener<RemoteReadResult> listener = new TestCapturingListener<>();
import org.opensearch.cluster.ClusterName;  
        assertEquals(CLUSTER_BLOCKS, listener.getResult().getComponentName());  
            .uploadBlob(any(InputStream.class), anyIterable(), anyString(), eq(URGENT), any(ActionListener.class));  
        latch.await();
    private final String CLUSTER_UUID = "test-cluster-uuid";
            return null;
import static org.mockito.ArgumentMatchers.any;  
            TestClusterStateCustom2.TYPE,
import java.util.Map;  
import static org.opensearch.gateway.remote.model.RemoteClusterBlocksTests.randomClusterBlocks;  
    public void testGetAsyncWriteRunnable_Exception() throws IOException, InterruptedException {  
        when(blobStoreTransferService.downloadBlob(anyIterable(), anyString())).thenThrow(ioException);
        assertEquals(5, pathTokens.length);  
            remoteObjForDownload.discoveryNodesFormat.serialize(
        latch.await();
            CLUSTER_STATE_CUSTOM,  
    public void testGetAsyncWriteRunnable_DiscoveryNodes() throws IOException, InterruptedException {  
        assertThat(customsDiff.getUpserts(), is(currentCustoms));
 */  
        remoteClusterStateAttributesManager.readAsync(CLUSTER_BLOCKS, remoteClusterBlocks, new LatchedActionListener<>(listener, latch));
        BlobStoreRepository blobStoreRepository = mock(BlobStoreRepository.class);
        assertNotNull(listener.getResult());
        String[] pathTokens = uploadedFileName.split(PATH_DELIMITER);  
            CLUSTER_UUID,  
        assertNotNull(listener.getResult());
        assertEquals(CLUSTER_STATE_EPHEMERAL_PATH_TOKEN, pathTokens[3]);
        assertEquals(DISCOVERY_NODES, listener.getResult().getComponent());
            return null;  
        assertEquals(CLUSTER_STATE_EPHEMERAL_PATH_TOKEN, pathTokens[3]);  
        assertEquals(invertLong(VERSION), splitFileName[1]);  
        assertNotNull(capturingListener.getResult());  
    public void setup() throws Exception {
            new TestClusterStateCustom4("data4")
        assertEquals(CLUSTER_STATE_PATH_TOKEN, pathTokens[1]);
            CLUSTER_STATE_CUSTOM,  
        String[] splitFileName = pathTokens[4].split(DELIMITER);
        customsDiff = remoteClusterStateAttributesManager.getUpdatedCustoms(currentState, previousState, true, false);
        );  
            TestClusterStateCustom4.TYPE,
        );  
        final CountDownLatch latch = new CountDownLatch(1);
            TestClusterStateCustom4.TYPE,
    }
        Map<String, Custom> currentCustoms = Map.of(
            new TestClusterStateCustom2("data2"),
        assertEquals(CLUSTER_BLOCKS, splitFileName[0]);
        }).when(blobStoreTransferService)
            remoteClusterStateAttributesManager.getUpdatedCustoms(currentState, previousState, false, randomBoolean());
import static org.opensearch.gateway.remote.model.RemoteClusterStateCustoms.CLUSTER_STATE_CUSTOM;
        CountDownLatch latch = new CountDownLatch(1);
        DiscoveryNodes discoveryNodes = getDiscoveryNodes();
            CLUSTER_UUID,
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        ClusterBlocks clusterBlocks = randomClusterBlocks();
            TestClusterStateCustom1.TYPE,
        RemoteClusterStateCustoms remoteClusterStateCustoms = new RemoteClusterStateCustoms(
        final CountDownLatch latch = new CountDownLatch(1);  
        Exception ioException = new IOException("mock test exception");  
        );
        String fileName = randomAlphaOfLength(10);
        assertNull(listener.getFailure());  
import static org.opensearch.gateway.remote.model.RemoteClusterStateCustomsTests.getClusterStateCustom;
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.PATH_DELIMITER;  
        assertEquals(ioException, capturingListener.getFailure().getCause());
        assertTrue(capturingListener.getFailure() instanceof RemoteStateTransferException);  
            return null;
        final TestCapturingListener<ClusterMetadataManifest.UploadedMetadata> listener = new TestCapturingListener<>();
import org.opensearch.gateway.remote.model.RemoteClusterBlocks;
    private RemoteClusterStateAttributesManager remoteClusterStateAttributesManager;  
    }
package org.opensearch.gateway.remote;
        when(blobStoreTransferService.downloadBlob(anyIterable(), anyString())).thenReturn(
        String fileName = randomAlphaOfLength(10);  
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.CUSTOM_DELIMITER;
        assertThat(customsDiff.getDeletes(), is(Collections.emptyList()));
import org.junit.Before;  
        assertNull(listener.getFailure());  
        TestCapturingListener<RemoteReadResult> capturingListener = new TestCapturingListener<>();  
        threadPool.shutdown();  
            namedWriteableRegistry
        ClusterState currentState = ClusterState.builder(new ClusterName("test-cluster")).customs(currentCustoms).build();
            Version.CURRENT
    }
            return null;  
        Custom custom = getClusterStateCustom();
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.CLUSTER_STATE_EPHEMERAL_PATH_TOKEN;
        assertThat(customsDiff.getDeletes(), is(Collections.emptyList()));
        assertEquals(CLUSTER_STATE_PATH_TOKEN, pathTokens[1]);
                discoveryNodes,  
        assertEquals(encodeString(CLUSTER_NAME), pathTokens[0]);
            remoteClusterStateCustoms,
        when(blobStoreRepository.basePath()).thenReturn(new BlobPath());
    private final String CLUSTER_NAME = "test-cluster";  
        );
import static org.mockito.Mockito.when;  
        );
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.CLUSTER_STATE_PATH_TOKEN;  
        }  
            custom,  
 * compatible open source license.
        assertNull(listener.getFailure());
        Map<String, ClusterState.Custom> expectedCustoms = Map.of(
    @After  
        namedWriteableRegistry = writableRegistry();  
        assertEquals(invertLong(VERSION), splitFileName[1]);
        assertEquals(CLUSTER_STATE_ATTRIBUTE, capturingListener.getResult().getComponent());
        assertEquals(ioException, capturingListener.getFailure().getCause());  
        String[] pathTokens = uploadedFileName.split(PATH_DELIMITER);
        ClusterBlocks clusterBlocks = randomClusterBlocks();
 * this file be licensed under the Apache-2.0 license or a
                (out, discoveryNode) -> discoveryNode.writeToWithAttribute(out),
                compressor
        ClusterState previousState = ClusterState.builder(new ClusterName("test-cluster")).customs(previousCustoms).build();  
            blobStoreTransferService,  
            .uploadBlob(any(InputStream.class), anyIterable(), anyString(), eq(URGENT), any(ActionListener.class));
import org.opensearch.action.LatchedActionListener;
        assertEquals(encodeString(CLUSTER_NAME), pathTokens[0]);
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.core.compress.NoneCompressor;
        when(blobStoreTransferService.downloadBlob(anyIterable(), anyString())).thenReturn(  
import java.util.Collections;
        assertEquals(CLUSTER_STATE_EPHEMERAL_PATH_TOKEN, pathTokens[3]);
        TestCapturingListener<RemoteReadResult> listener = new TestCapturingListener<>();  
        remoteClusterStateAttributesManager.readAsync(DISCOVERY_NODES, remoteObjForDownload, new LatchedActionListener<>(listener, latch));
        );  
import org.opensearch.cluster.DiffableUtils;  
import org.opensearch.common.util.TestCapturingListener;  
    }
        );  
    }
import org.opensearch.cluster.block.ClusterBlocks;
        doAnswer(invocationOnMock -> {
            ).streamInput()  
        assertEquals(discoveryNodes.getSize(), readDiscoveryNodes.getSize());
    }
import org.opensearch.common.settings.ClusterSettings;
        String fileName = randomAlphaOfLength(10);
import static org.opensearch.gateway.remote.RemoteClusterStateTestUtils.TestClusterStateCustom1;
        super.tearDown();
    }
        }).when(blobStoreTransferService)
import static org.mockito.ArgumentMatchers.eq;  
        DiscoveryNodes readDiscoveryNodes = (DiscoveryNodes) listener.getResult().getObj();
import static org.opensearch.gateway.remote.RemoteClusterStateTestUtils.TestClusterStateCustom4;
        assertEquals(CLUSTER_STATE_ATTRIBUTES_CURRENT_CODEC_VERSION, Integer.parseInt(splitFileName[3]));
        assertEquals(CLUSTER_STATE_ATTRIBUTE, listener.getResult().getComponent());
        TestCapturingListener<ClusterMetadataManifest.UploadedMetadata> capturingListener = new TestCapturingListener<>();
        assertNull(listener.getFailure());
            DISCOVERY_NODES,
import org.junit.After;
        );
        assertEquals(CLUSTER_UUID, pathTokens[2]);
            TestClusterStateCustom3.TYPE,
        remoteClusterStateAttributesManager.readAsync(
        String uploadedFileName = listener.getResult().getUploadedFilename();
            remoteDiscoveryNodes,  
public class RemoteClusterStateAttributesManagerTests extends OpenSearchTestCase {
        RemoteDiscoveryNodes remoteDiscoveryNodes = new RemoteDiscoveryNodes(discoveryNodes, VERSION, CLUSTER_UUID, compressor);
        latch.await();
        TestCapturingListener<RemoteReadResult> capturingListener = new TestCapturingListener<>();  
        IOException ioException = new IOException("mock test exception");
        assertEquals(RemoteClusterStateUtils.encodeString(CLUSTER_NAME), pathTokens[0]);  
        doAnswer(invocationOnMock -> {
        CountDownLatch latch = new CountDownLatch(1);
            TestClusterStateCustom3.TYPE,  
        assertEquals(invertLong(VERSION), splitFileName[1]);
            TestClusterStateCustom3.TYPE,
}  
            new LatchedActionListener<>(capturingListener, latch)
        assertEquals(CLUSTER_STATE_PATH_TOKEN, pathTokens[1]);  
            blobStoreRepository,
            assertEquals(clusterBlocks.indices().get(index), readClusterBlocks.indices().get(index));
            fileName,
        latch.await();
            new LatchedActionListener<>(capturingListener, latch)
import org.opensearch.cluster.ClusterState.Custom;
            new TestClusterStateCustom3("data3")
        remoteClusterStateAttributesManager.writeAsync(DISCOVERY_NODES, remoteDiscoveryNodes, new LatchedActionListener<>(listener, latch));
        String uploadedFileName = listener.getResult().getUploadedFilename();  
        remoteClusterStateAttributesManager.readAsync(
        final TestCapturingListener<ClusterMetadataManifest.UploadedMetadata> listener = new TestCapturingListener<>();  
 * SPDX-License-Identifier: Apache-2.0
        }).when(blobStoreTransferService)  
        assertEquals(4, splitFileName.length);  
        latch.await();  
        assertEquals(5, pathTokens.length);
        RemoteDiscoveryNodes remoteDiscoveryNodes = new RemoteDiscoveryNodes(fileName, CLUSTER_UUID, compressor, Version.CURRENT);
    public void tearDown() throws Exception {
        final CountDownLatch latch = new CountDownLatch(1);  
        assertEquals(clusterBlocks.global(), readClusterBlocks.global());
        Map<String, ClusterState.Custom> previousCustoms = Map.of(
            compressor,
    public void testGetAsyncReadRunnable_Exception() throws IOException, InterruptedException {  
    public void testGetUpdatedCustoms() {  
        String[] splitFileName = pathTokens[4].split(DELIMITER);  
            new LatchedActionListener<>(capturingListener, latch)
            new TestClusterStateCustom3("data3-changed"),  
        assertEquals(CLUSTER_UUID, pathTokens[2]);
    }
            namedWriteableRegistry,  
        assertEquals(DISCOVERY_NODES, listener.getResult().getComponentName());  
/*  
        RemoteDiscoveryNodes remoteObjForDownload = new RemoteDiscoveryNodes(fileName, "cluster-uuid", compressor, Version.CURRENT);
import org.opensearch.gateway.remote.model.RemoteReadResult;
        assertEquals(String.join(CUSTOM_DELIMITER, CLUSTER_STATE_CUSTOM, custom.getWriteableName()), listener.getResult().getComponent());
import static org.opensearch.gateway.remote.RemoteClusterStateTestUtils.TestClusterStateCustom2;
        assertEquals(CLUSTER_UUID, pathTokens[2]);  
        assertNull(capturingListener.getResult());
            .uploadBlob(any(InputStream.class), anyIterable(), anyString(), eq(URGENT), any(ActionListener.class));
        assertNotNull(listener.getResult());
    }
import static org.hamcrest.Matchers.is;
            TestClusterStateCustom2.TYPE,  
        String[] splitFileName = pathTokens[4].split(DELIMITER);
import static org.mockito.Mockito.doAnswer;
import org.opensearch.index.translog.transfer.BlobStoreTransferService;  
import org.opensearch.repositories.blobstore.BlobStoreRepository;
import org.opensearch.Version;
        RemoteDiscoveryNodes remoteDiscoveryNodes = new RemoteDiscoveryNodes(discoveryNodes, VERSION, CLUSTER_UUID, compressor);
    public void testGetAsyncReadRunnable_ClusterBlocks() throws IOException, InterruptedException {  
            custom.getWriteableName(),  
        final CountDownLatch latch = new CountDownLatch(1);
import org.opensearch.cluster.node.DiscoveryNodes;
        compressor = new NoneCompressor();
        assertNull(capturingListener.getFailure());
            invocationOnMock.getArgument(4, ActionListener.class).onFailure(ioException);  
        assertEquals(CLUSTER_BLOCKS, listener.getResult().getComponent());  
import org.opensearch.threadpool.ThreadPool;
import java.util.List;
        assertNotNull(listener.getResult());
        assertEquals(discoveryNodes.getClusterManagerNodeId(), readDiscoveryNodes.getClusterManagerNodeId());
    private NamedWriteableRegistry namedWriteableRegistry;
import org.opensearch.common.blobstore.BlobPath;  
import static org.opensearch.gateway.remote.RemoteClusterStateAttributesManager.CLUSTER_STATE_ATTRIBUTES_CURRENT_CODEC_VERSION;
                fileName,
import static org.opensearch.gateway.remote.model.RemoteDiscoveryNodesTests.getDiscoveryNodes;  
            writableRegistry(),
        customsDiff = remoteClusterStateAttributesManager.getUpdatedCustoms(currentState, previousState, true, true);  
        assertEquals(CLUSTER_STATE_ATTRIBUTES_CURRENT_CODEC_VERSION, Integer.parseInt(splitFileName[3]));  
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.DELIMITER;
            .uploadBlob(any(InputStream.class), anyIterable(), anyString(), eq(URGENT), any(ActionListener.class));
        assertTrue(capturingListener.getFailure() instanceof RemoteStateTransferException);
    private final long VERSION = 7331L;
    public void testGetAsyncReadRunnable_DiscoveryNodes() throws IOException, InterruptedException {
import static org.opensearch.gateway.remote.RemoteClusterStateTestUtils.TestClusterStateCustom3;  
        for (String index : clusterBlocks.indices().keySet()) {
import org.opensearch.common.settings.Settings;
        CountDownLatch latch = new CountDownLatch(1);
        assertEquals(CLUSTER_STATE_CUSTOM, capturingListener.getResult().getComponentName());  
import org.opensearch.gateway.remote.model.RemoteClusterStateCustoms;  
        assertEquals(5, pathTokens.length);
    @Before  
            remoteClusterBlocks.clusterBlocksFormat.serialize(clusterBlocks, fileName, compressor).streamInput()
        assertEquals(CLUSTER_STATE_ATTRIBUTES_CURRENT_CODEC_VERSION, Integer.parseInt(splitFileName[3]));
        assertThat(customsDiff.getUpserts(), is(expectedCustoms));  
import java.io.IOException;
        doAnswer(invocationOnMock -> {
 *
        RemoteClusterStateCustoms remoteClusterStateCustoms = new RemoteClusterStateCustoms(
        assertEquals(CLUSTER_STATE_ATTRIBUTE, listener.getResult().getComponent());
import java.io.InputStream;  
        latch.await();  
        DiffableUtils.MapDiff<String, ClusterState.Custom, Map<String, ClusterState.Custom>> customsDiff =
import org.opensearch.gateway.remote.model.RemoteDiscoveryNodes;
import static org.opensearch.index.remote.RemoteStoreUtils.invertLong;
        remoteClusterStateAttributesManager.writeAsync(CLUSTER_BLOCKS, remoteClusterBlocks, new LatchedActionListener<>(listener, latch));
        RemoteClusterBlocks remoteClusterBlocks = new RemoteClusterBlocks(fileName, "cluster-uuid", compressor, Version.CURRENT);  
            threadPool
        remoteClusterStateAttributesManager = new RemoteClusterStateAttributesManager(  
import org.opensearch.threadpool.TestThreadPool;  
            remoteClusterStateCustoms,
        latch.await();
        doAnswer(invocationOnMock -> {  
        when(blobStoreTransferService.downloadBlob(anyIterable(), anyString())).thenReturn(  
        );  
    public void testGetAsyncWriteRunnable_Custom() throws IOException, InterruptedException {  
    }  
    public void testGetAsyncReadRunnable_Custom() throws IOException, InterruptedException {
            DISCOVERY_NODES,
        assertNull(capturingListener.getResult());
            remoteDiscoveryNodes,  
        String fileName = randomAlphaOfLength(10);
    public void testGetAsyncWriteRunnable_ClusterBlocks() throws IOException, InterruptedException {
        DiscoveryNodes discoveryNodes = getDiscoveryNodes();  
            invocationOnMock.getArgument(4, ActionListener.class).onResponse(null);
            VERSION,
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.encodeString;
        );  
            invocationOnMock.getArgument(4, ActionListener.class).onResponse(null);
        remoteClusterStateAttributesManager.writeAsync(
import static org.opensearch.common.blobstore.stream.write.WritePriority.URGENT;  
        RemoteClusterBlocks remoteClusterBlocks = new RemoteClusterBlocks(clusterBlocks, VERSION, CLUSTER_UUID, compressor);  
        );
            new TestClusterStateCustom1("data1"),  
        discoveryNodes.getNodes().forEach((nodeId, node) -> assertEquals(readDiscoveryNodes.get(nodeId), node));  
        }).when(blobStoreTransferService)
        assertNotNull(listener.getResult());  
        assertThat(customsDiff.getDeletes(), is(List.of(TestClusterStateCustom1.TYPE)));
import static org.opensearch.gateway.remote.RemoteClusterStateAttributesManager.DISCOVERY_NODES;  
 * The OpenSearch Contributors require contributions made to  
        String uploadedFileName = listener.getResult().getUploadedFilename();
    private final ThreadPool threadPool = new TestThreadPool(RemoteClusterStateAttributesManagerTests.class.getName());  
import static org.mockito.Mockito.mock;
import static org.mockito.ArgumentMatchers.anyIterable;
            remoteClusterStateCustoms.clusterStateCustomsFormat.serialize(custom, fileName, compressor).streamInput()
            new TestClusterStateCustom4("data4")
        final CountDownLatch latch = new CountDownLatch(1);
        assertEquals(custom, capturingListener.getResult().getObj());
        remoteClusterStateAttributesManager.writeAsync(
        assertNull(listener.getFailure());  
        DiscoveryNodes discoveryNodes = getDiscoveryNodes();
            compressor,
        blobStoreTransferService = mock(BlobStoreTransferService.class);  
        assertEquals(DISCOVERY_NODES, splitFileName[0]);  
import org.opensearch.core.action.ActionListener;
        ClusterBlocks readClusterBlocks = (ClusterBlocks) listener.getResult().getObj();
    }
        assertEquals(4, splitFileName.length);
import static org.opensearch.gateway.remote.RemoteClusterStateAttributesManager.CLUSTER_STATE_ATTRIBUTE;
        assertEquals(clusterBlocks.indices().keySet(), readClusterBlocks.indices().keySet());  
