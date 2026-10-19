        doThrow(new IOException("mock-exception")).when(nodes).writeToWithAttribute(any());  
        assertEquals(RemoteStoreUtils.invertLong(nameTokens[1]), METADATA_VERSION);
    @Before
    }
        assertArrayEquals(remoteObjectForDownload.getBlobPathTokens(), new String[] { "user", "local", "opensearch", "discovery-nodes" });  
import org.opensearch.gateway.remote.RemoteClusterStateUtils;
                    new HashSet<>(randomSubsetOf(DiscoveryNodeRole.BUILT_IN_ROLES)),
        RemoteDiscoveryNodes remoteObjectForDownload = new RemoteDiscoveryNodes(TEST_BLOB_NAME, clusterUUID, compressor, Version.CURRENT);
import java.io.InputStream;
        RemoteDiscoveryNodes remoteObjectForDownload = new RemoteDiscoveryNodes(TEST_BLOB_NAME, clusterUUID, compressor, Version.CURRENT);
import java.util.Collections;
                    Collections.emptyMap(),  
        remoteObjectForUpload.setFullBlobName(new BlobPath().add(TEST_BLOB_PATH));
                    buildNewFakeTransportAddress(),
    public void testGenerateBlobFileName() {
                NetworkModule.getNamedXContents().stream(),
        // which is being used in RemoteDiscoveryNodes class.
import static org.mockito.Mockito.doThrow;
    public static DiscoveryNodes getDiscoveryNodes() {
            assertEquals(nodes.getSize(), readDiscoveryNodes.getSize());  
        assertEquals(nodes.getSize(), readNodes31.getSize());
import org.opensearch.indices.IndicesModule;  
        assertEquals(remoteObjectForDownload.getBlobFileName(), TEST_BLOB_FILE_NAME);  
    }  
import org.opensearch.cluster.ClusterModule;
import org.opensearch.cluster.node.DiscoveryNodeRole;
    private static final String TEST_BLOB_PATH = "test-path";
        InputStream in = mock(InputStream.class);  
                    new HashSet<>(randomSubsetOf(DiscoveryNodeRole.BUILT_IN_ROLES)),  
 * compatible open source license.
package org.opensearch.gateway.remote.model;
    }
        try (InputStream inputStream = remoteObjectForUpload.serialize()) {
    private NamedXContentRegistry namedXContentRegistry;  
        byte[] serializedData = serializeFormat.serialize((out, discoveryNode) -> {  
        // Serialize using 3.1.0 format
                    "name_" + 2,
                    "node_" + 3,  
                    buildNewFakeTransportAddress(),
    public void testExceptionDuringSerialization() throws IOException {  
        RemoteDiscoveryNodes remoteObjectForUpload = new RemoteDiscoveryNodes(nodes, METADATA_VERSION, clusterUUID, compressor);
 *
    }
        assertEquals(nameTokens[3], String.valueOf(CLUSTER_STATE_ATTRIBUTES_CURRENT_CODEC_VERSION));
                    buildNewFakeTransportAddress(),  
        assertEquals(nodes.getClusterManagerNodeId(), readNodes31.getClusterManagerNodeId());
 * The OpenSearch Contributors require contributions made to  
        );  
        IOException iea = assertThrows(IOException.class, remoteObjectForUpload::serialize);
        String[] nameTokens = blobFileName.split(RemoteClusterStateUtils.DELIMITER);  
        // Create format with V_3_1_0 for serialization using the same ChecksumWritableBlobStoreFormat
import java.util.HashSet;  
        RemoteDiscoveryNodes remoteObjectForUpload = new RemoteDiscoveryNodes(nodes, METADATA_VERSION, clusterUUID, compressor);
    }
                    Collections.emptyMap(),
import org.opensearch.cluster.node.DiscoveryNodes;
                    Version.CURRENT
    }  
import static org.mockito.ArgumentMatchers.any;  
import org.opensearch.test.OpenSearchTestCase;
            )
import static org.mockito.Mockito.mock;
        );  
import org.opensearch.common.blobstore.BlobPath;  
            .build();  
        String uploadedFile = "user/local/opensearch/discovery-nodes";
    private Compressor compressor;
import java.util.function.Function;
import org.opensearch.common.network.NetworkModule;
        DiscoveryNodes nodes = getDiscoveryNodes();
import org.opensearch.index.remote.RemoteStoreUtils;
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.CLUSTER_STATE_EPHEMERAL_PATH_TOKEN;
            )
import static org.opensearch.gateway.remote.model.RemoteDiscoveryNodes.DISCOVERY_NODES;
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
        RemoteDiscoveryNodes remoteObjectForUpload = new RemoteDiscoveryNodes(nodes, METADATA_VERSION, clusterUUID, compressor);
                )  
        DiscoveryNodes nodes = getDiscoveryNodes();
    public void testSerializationOnOldVersionDeserializationOnNewVersions() throws IOException {
    }
                )
        RemoteDiscoveryNodes remoteObjectForUpload = new RemoteDiscoveryNodes(nodes, METADATA_VERSION, clusterUUID, compressor);
            out.setVersion(Version.V_3_1_0);
/*  
        DiscoveryNodes nodes = getDiscoveryNodes();
                IndicesModule.getNamedXContents().stream(),  
        RemoteDiscoveryNodes deserialize34 = new RemoteDiscoveryNodes("test-blob", clusterUUID, compressor, Version.V_3_4_0);  
        namedXContentRegistry = new NamedXContentRegistry(  
            .add(  
        assertThrows(AssertionError.class, remoteObjectForUpload::getUploadedMetadata);
            is -> DiscoveryNodes.readFrom(is, null)
    }
            ).flatMap(Function.identity()).collect(toList())
    }
                    "node_" + 2,
        RemoteDiscoveryNodes remoteObjectForUpload = new RemoteDiscoveryNodes(nodes, METADATA_VERSION, clusterUUID, compressor);
    }
        this.clusterUUID = "test-cluster-uuid";
            .localNodeId("name_1")
        // Deserialize assuming serialization was performed using version 3.1.0, which should pass
        RemoteDiscoveryNodes deserialize31 = new RemoteDiscoveryNodes("test-blob", clusterUUID, compressor, Version.V_3_1_0);
    private static final String TEST_BLOB_FILE_NAME = "test-blob-name";
        assertEquals(remoteObjectForDownload.clusterUUID(), clusterUUID);  
    }
    }  
        DiscoveryNodes nodes = getDiscoveryNodes();  
        RemoteDiscoveryNodes remoteObjectForUpload = new RemoteDiscoveryNodes(nodes, METADATA_VERSION, clusterUUID, compressor);
        assertEquals(remoteObjectForDownload.getFullBlobName(), TEST_BLOB_NAME);  
    public void setup() {  
            DiscoveryNodes readDiscoveryNodes = remoteObjectForUpload.deserialize(inputStream);
    private static final long METADATA_VERSION = 3L;  
            discoveryNode.writeToWithAttribute(out);
                    Collections.emptyMap(),
    public void testGetUploadedMetadata() throws IOException {
    public void testBlobPathTokens() {  
import java.io.IOException;  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.compress.Compressor;  
import java.util.List;
import org.opensearch.common.remote.BlobPathParameters;
        DiscoveryNodes nodes = getDiscoveryNodes();  
        assertThrows(Exception.class, () -> {
 * this file be licensed under the Apache-2.0 license or a
        compressor = new NoneCompressor();
                    Version.CURRENT  
            .clusterManagerNodeId("name_2")
            assertTrue(inputStream.available() > 0);
            )  
        ChecksumWritableBlobStoreFormat<DiscoveryNodes> serializeFormat = new ChecksumWritableBlobStoreFormat<>(  
        assertEquals(nameTokens[0], DISCOVERY_NODES);
        RemoteDiscoveryNodes remoteObjectForUpload = new RemoteDiscoveryNodes(nodes, METADATA_VERSION, clusterUUID, compressor);
        RemoteDiscoveryNodes remoteObjectForDownload = new RemoteDiscoveryNodes(TEST_BLOB_NAME, clusterUUID, compressor, Version.CURRENT);
        RemoteDiscoveryNodes remoteObjectForDownload = new RemoteDiscoveryNodes(uploadedFile, clusterUUID, compressor, Version.CURRENT);  
        DiscoveryNodes nodes = getDiscoveryNodes();
        assertEquals(uploadedMetadata.getComponent(), DISCOVERY_NODES);
        assertEquals(params.getPathTokens(), List.of(CLUSTER_STATE_EPHEMERAL_PATH_TOKEN));
        IOException ioe = assertThrows(IOException.class, () -> remoteObjectForDownload.deserialize(in));
        assertNull(remoteObjectForUpload.getFullBlobName());  
import static org.mockito.Mockito.when;  
    public void testFullBlobName() {  
        assertTrue(RemoteStoreUtils.invertLong(nameTokens[2]) <= System.currentTimeMillis());  
        RemoteDiscoveryNodes remoteObjectForDownload = new RemoteDiscoveryNodes(uploadedFile, clusterUUID, compressor, Version.CURRENT);
        when(in.read(any(byte[].class))).thenThrow(new IOException("mock-exception"));
public class RemoteDiscoveryNodesTests extends OpenSearchTestCase {
            nodes.getNodes().forEach((nodeId, node) -> assertEquals(readDiscoveryNodes.get(nodeId), node));
                    "node_" + 1,
        DiscoveryNodes nodes = getDiscoveryNodes();
        RemoteDiscoveryNodes remoteObjectForUpload = new RemoteDiscoveryNodes(nodes, METADATA_VERSION, clusterUUID, compressor);  
        assertNull(remoteObjectForUpload.getBlobFileName());  
                new DiscoveryNode(
import static java.util.stream.Collectors.toList;
                )
                new DiscoveryNode(  
        BlobPathParameters params = remoteObjectForUpload.getBlobPathParameters();  
        DiscoveryNodes readNodes31;  
    public void testClusterUUID() {  
        assertEquals(remoteObjectForUpload.clusterUUID(), clusterUUID);  
                    "name_" + 1,  
            "nodes",
        return DiscoveryNodes.builder()  
                    "name_" + 3,
            readNodes31 = deserialize31.deserialize(inputStream);
        String uploadedFile = "user/local/opensearch/discovery-nodes";
import java.util.stream.Stream;  
    private String clusterUUID;
            Stream.of(
        });
                ClusterModule.getNamedXWriteables().stream()
        assertEquals(params.getFilePrefix(), DISCOVERY_NODES);
                new DiscoveryNode(
import java.io.ByteArrayInputStream;
import org.opensearch.cluster.node.DiscoveryNode;  
                    new HashSet<>(randomSubsetOf(DiscoveryNodeRole.BUILT_IN_ROLES)),
    public void testExceptionDuringDeserialize() throws IOException {
        assertEquals(uploadedMetadata.getUploadedFilename(), remoteObjectForUpload.getFullBlobName());
            remoteObjectForUpload.setFullBlobName(BlobPath.cleanPath());  
        }  
    }
        String blobFileName = remoteObjectForUpload.generateBlobFileName();
        DiscoveryNodes nodes = getDiscoveryNodes();
        try (InputStream inputStream = new ByteArrayInputStream(serializedData)) {
                deserialize34.deserialize(inputStream);  
import org.junit.Before;  
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
 */  
            .add(
            .add(
                    Version.CURRENT
    public void testSerDe() throws IOException {
        ClusterMetadataManifest.UploadedMetadata uploadedMetadata = remoteObjectForUpload.getUploadedMetadata();  
    public void testBlobFileName() {  
    private static final String TEST_BLOB_NAME = "/test-path/test-blob-name";  
import org.opensearch.gateway.remote.ClusterMetadataManifest;  
import org.opensearch.core.xcontent.NamedXContentRegistry;
        }, nodes, "test-blob", compressor).streamInput().readAllBytes();  
import org.opensearch.core.compress.NoneCompressor;
}
    public void testBlobPathParameters() {  
import org.opensearch.repositories.blobstore.ChecksumWritableBlobStoreFormat;
import org.opensearch.Version;
        // Deserialize assuming serialization was performed using version 3.4.0, which should fail
            try (InputStream inputStream = new ByteArrayInputStream(serializedData)) {
            assertEquals(nodes.getClusterManagerNodeId(), readDiscoveryNodes.getClusterManagerNodeId());
import static org.opensearch.gateway.remote.RemoteClusterStateAttributesManager.CLUSTER_STATE_ATTRIBUTES_CURRENT_CODEC_VERSION;  
        }  
            }
