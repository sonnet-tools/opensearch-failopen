        assertEquals(remoteObjectForDownload.clusterUUID(), clusterUUID);
                IndicesModule.getNamedXContents().stream(),
import java.util.List;
    }
import org.opensearch.core.xcontent.NamedXContentRegistry;
        // Deserialize assuming serialization was performed using version 3.4.0, which should fail
        doThrow(new IOException("mock-exception")).when(nodes).writeToWithAttribute(any());
        );
    private static final String TEST_BLOB_NAME = "/test-path/test-blob-name";
                    "node_" + 1,
        RemoteDiscoveryNodes remoteObjectForUpload = new RemoteDiscoveryNodes(nodes, METADATA_VERSION, clusterUUID, compressor);
                    buildNewFakeTransportAddress(),
 * compatible open source license.
        RemoteDiscoveryNodes remoteObjectForUpload = new RemoteDiscoveryNodes(nodes, METADATA_VERSION, clusterUUID, compressor);
    public void testFullBlobName() {
        DiscoveryNodes nodes = getDiscoveryNodes();
import org.opensearch.cluster.node.DiscoveryNode;
        namedXContentRegistry = new NamedXContentRegistry(
        RemoteDiscoveryNodes remoteObjectForDownload = new RemoteDiscoveryNodes(uploadedFile, clusterUUID, compressor, Version.CURRENT);
        RemoteDiscoveryNodes remoteObjectForUpload = new RemoteDiscoveryNodes(nodes, METADATA_VERSION, clusterUUID, compressor);
        assertEquals(params.getFilePrefix(), DISCOVERY_NODES);
            .add(
    public void testGetUploadedMetadata() throws IOException {
        assertEquals(uploadedMetadata.getComponent(), DISCOVERY_NODES);
        IOException iea = assertThrows(IOException.class, remoteObjectForUpload::serialize);
        remoteObjectForUpload.setFullBlobName(new BlobPath().add(TEST_BLOB_PATH));
            assertEquals(nodes.getClusterManagerNodeId(), readDiscoveryNodes.getClusterManagerNodeId());
                new DiscoveryNode(
        this.clusterUUID = "test-cluster-uuid";
                deserialize34.deserialize(inputStream);
        // Deserialize assuming serialization was performed using version 3.1.0, which should pass
}
        assertNull(remoteObjectForUpload.getBlobFileName());
        assertEquals(uploadedMetadata.getUploadedFilename(), remoteObjectForUpload.getFullBlobName());
                    Version.CURRENT
        BlobPathParameters params = remoteObjectForUpload.getBlobPathParameters();
        DiscoveryNodes readNodes31;
        }
import java.util.function.Function;
import org.opensearch.common.blobstore.BlobPath;
        // Create format with V_3_1_0 for serialization using the same ChecksumWritableBlobStoreFormat
    public void testSerDe() throws IOException {
        assertEquals(RemoteStoreUtils.invertLong(nameTokens[1]), METADATA_VERSION);
                    new HashSet<>(randomSubsetOf(DiscoveryNodeRole.BUILT_IN_ROLES)),
        }, nodes, "test-blob", compressor).streamInput().readAllBytes();
import org.opensearch.test.OpenSearchTestCase;
        });
        String[] nameTokens = blobFileName.split(RemoteClusterStateUtils.DELIMITER);
        DiscoveryNodes nodes = getDiscoveryNodes();
        assertEquals(nameTokens[0], DISCOVERY_NODES);
    private Compressor compressor;
import static org.opensearch.gateway.remote.RemoteClusterStateAttributesManager.CLUSTER_STATE_ATTRIBUTES_CURRENT_CODEC_VERSION;
import org.opensearch.gateway.remote.ClusterMetadataManifest;
        }
            Stream.of(
    private NamedXContentRegistry namedXContentRegistry;
        InputStream in = mock(InputStream.class);
    public void testBlobPathTokens() {
import static java.util.stream.Collectors.toList;
        assertThrows(AssertionError.class, remoteObjectForUpload::getUploadedMetadata);
import java.io.ByteArrayInputStream;
        assertThrows(Exception.class, () -> {
    @Before
            discoveryNode.writeToWithAttribute(out);
    }
    public void testClusterUUID() {
                    buildNewFakeTransportAddress(),
            .clusterManagerNodeId("name_2")
                )
 */
    public void testExceptionDuringSerialization() throws IOException {
    }
                    "node_" + 3,
import org.opensearch.Version;
 *
    public void setup() {
        DiscoveryNodes nodes = getDiscoveryNodes();
        return DiscoveryNodes.builder()
                new DiscoveryNode(
import static org.mockito.Mockito.doThrow;
        // Serialize using 3.1.0 format
import org.opensearch.cluster.node.DiscoveryNodes;
            .build();
 * this file be licensed under the Apache-2.0 license or a
    }
            .add(
    private static final String TEST_BLOB_PATH = "test-path";
        String uploadedFile = "user/local/opensearch/discovery-nodes";
                    new HashSet<>(randomSubsetOf(DiscoveryNodeRole.BUILT_IN_ROLES)),
                    Collections.emptyMap(),
        assertEquals(remoteObjectForUpload.clusterUUID(), clusterUUID);
            assertTrue(inputStream.available() > 0);
            "nodes",
    }
        IOException ioe = assertThrows(IOException.class, () -> remoteObjectForDownload.deserialize(in));
    }
            .localNodeId("name_1")
        );
        String blobFileName = remoteObjectForUpload.generateBlobFileName();
                )
            )
        assertTrue(RemoteStoreUtils.invertLong(nameTokens[2]) <= System.currentTimeMillis());
    private static final long METADATA_VERSION = 3L;
        RemoteDiscoveryNodes remoteObjectForUpload = new RemoteDiscoveryNodes(nodes, METADATA_VERSION, clusterUUID, compressor);
        RemoteDiscoveryNodes remoteObjectForUpload = new RemoteDiscoveryNodes(nodes, METADATA_VERSION, clusterUUID, compressor);
import org.opensearch.index.remote.RemoteStoreUtils;
import org.junit.Before;
                new DiscoveryNode(
import org.opensearch.repositories.blobstore.ChecksumWritableBlobStoreFormat;
import org.opensearch.core.compress.Compressor;
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.CLUSTER_STATE_EPHEMERAL_PATH_TOKEN;
        try (InputStream inputStream = new ByteArrayInputStream(serializedData)) {
import org.opensearch.cluster.node.DiscoveryNodeRole;
                )
    }
            ).flatMap(Function.identity()).collect(toList())
 * The OpenSearch Contributors require contributions made to
            readNodes31 = deserialize31.deserialize(inputStream);
            assertEquals(nodes.getSize(), readDiscoveryNodes.getSize());
    public void testGenerateBlobFileName() {
    public void testBlobPathParameters() {
            .add(
        RemoteDiscoveryNodes remoteObjectForDownload = new RemoteDiscoveryNodes(TEST_BLOB_NAME, clusterUUID, compressor, Version.CURRENT);
        when(in.read(any(byte[].class))).thenThrow(new IOException("mock-exception"));
package org.opensearch.gateway.remote.model;
import java.io.IOException;
import java.util.Collections;
        RemoteDiscoveryNodes remoteObjectForDownload = new RemoteDiscoveryNodes(uploadedFile, clusterUUID, compressor, Version.CURRENT);
    }
import static org.mockito.Mockito.when;
            )
        byte[] serializedData = serializeFormat.serialize((out, discoveryNode) -> {
            nodes.getNodes().forEach((nodeId, node) -> assertEquals(readDiscoveryNodes.get(nodeId), node));
 * SPDX-License-Identifier: Apache-2.0
                    Version.CURRENT
        compressor = new NoneCompressor();
            }
        assertNull(remoteObjectForUpload.getFullBlobName());
        DiscoveryNodes nodes = getDiscoveryNodes();
    public void testSerializationOnOldVersionDeserializationOnNewVersions() throws IOException {
        DiscoveryNodes nodes = getDiscoveryNodes();
        DiscoveryNodes nodes = getDiscoveryNodes();
    }
                    Collections.emptyMap(),
        DiscoveryNodes nodes = getDiscoveryNodes();
import java.io.InputStream;
                    "name_" + 1,
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
                    new HashSet<>(randomSubsetOf(DiscoveryNodeRole.BUILT_IN_ROLES)),
    public void testExceptionDuringDeserialize() throws IOException {
                    "node_" + 2,
/*
    private static final String TEST_BLOB_FILE_NAME = "test-blob-name";
        ChecksumWritableBlobStoreFormat<DiscoveryNodes> serializeFormat = new ChecksumWritableBlobStoreFormat<>(
        RemoteDiscoveryNodes remoteObjectForUpload = new RemoteDiscoveryNodes(nodes, METADATA_VERSION, clusterUUID, compressor);
        assertArrayEquals(remoteObjectForDownload.getBlobPathTokens(), new String[] { "user", "local", "opensearch", "discovery-nodes" });
    public void testBlobFileName() {
import org.opensearch.core.compress.NoneCompressor;
                    Version.CURRENT
import static org.opensearch.gateway.remote.model.RemoteDiscoveryNodes.DISCOVERY_NODES;
                ClusterModule.getNamedXWriteables().stream()
            out.setVersion(Version.V_3_1_0);
import org.opensearch.common.network.NetworkModule;
        assertEquals(remoteObjectForDownload.getFullBlobName(), TEST_BLOB_NAME);
        assertEquals(nameTokens[3], String.valueOf(CLUSTER_STATE_ATTRIBUTES_CURRENT_CODEC_VERSION));
    }
public class RemoteDiscoveryNodesTests extends OpenSearchTestCase {
        assertEquals(nodes.getClusterManagerNodeId(), readNodes31.getClusterManagerNodeId());
            is -> DiscoveryNodes.readFrom(is, null)
import static org.mockito.ArgumentMatchers.any;
        RemoteDiscoveryNodes remoteObjectForDownload = new RemoteDiscoveryNodes(TEST_BLOB_NAME, clusterUUID, compressor, Version.CURRENT);
import java.util.stream.Stream;
            DiscoveryNodes readDiscoveryNodes = remoteObjectForUpload.deserialize(inputStream);
        RemoteDiscoveryNodes remoteObjectForUpload = new RemoteDiscoveryNodes(nodes, METADATA_VERSION, clusterUUID, compressor);
            remoteObjectForUpload.setFullBlobName(BlobPath.cleanPath());
    private String clusterUUID;
        ClusterMetadataManifest.UploadedMetadata uploadedMetadata = remoteObjectForUpload.getUploadedMetadata();
            )
import static org.mockito.Mockito.mock;
        RemoteDiscoveryNodes remoteObjectForUpload = new RemoteDiscoveryNodes(nodes, METADATA_VERSION, clusterUUID, compressor);
        assertEquals(params.getPathTokens(), List.of(CLUSTER_STATE_EPHEMERAL_PATH_TOKEN));
                    "name_" + 2,
        DiscoveryNodes nodes = getDiscoveryNodes();
        try (InputStream inputStream = remoteObjectForUpload.serialize()) {
        String uploadedFile = "user/local/opensearch/discovery-nodes";
import java.util.HashSet;
    }
                    Collections.emptyMap(),
        // which is being used in RemoteDiscoveryNodes class.
        RemoteDiscoveryNodes deserialize34 = new RemoteDiscoveryNodes("test-blob", clusterUUID, compressor, Version.V_3_4_0);
    }
        assertEquals(nodes.getSize(), readNodes31.getSize());
                    buildNewFakeTransportAddress(),
                NetworkModule.getNamedXContents().stream(),
import org.opensearch.cluster.ClusterModule;
    public static DiscoveryNodes getDiscoveryNodes() {
        RemoteDiscoveryNodes deserialize31 = new RemoteDiscoveryNodes("test-blob", clusterUUID, compressor, Version.V_3_1_0);
import org.opensearch.indices.IndicesModule;
import org.opensearch.common.remote.BlobPathParameters;
                    "name_" + 3,
    }
import org.opensearch.gateway.remote.RemoteClusterStateUtils;
        assertEquals(remoteObjectForDownload.getBlobFileName(), TEST_BLOB_FILE_NAME);
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
        RemoteDiscoveryNodes remoteObjectForDownload = new RemoteDiscoveryNodes(TEST_BLOB_NAME, clusterUUID, compressor, Version.CURRENT);
            try (InputStream inputStream = new ByteArrayInputStream(serializedData)) {
