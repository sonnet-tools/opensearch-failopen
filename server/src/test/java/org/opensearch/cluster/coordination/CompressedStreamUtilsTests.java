import static org.mockito.Mockito.when;
import org.opensearch.core.common.io.stream.StreamInput;
        // Decompression fails with AssertionError on non-compressed request
        BytesReference bytes = CompressedStreamUtils.createCompressedStream(localNode.getVersion(), localClusterState::writeTo);  
        final ClusterState localClusterState = ClusterState.builder(ClusterName.DEFAULT)
public class CompressedStreamUtilsTests extends OpenSearchTestCase {
 *
            .metadata(Metadata.builder().generateClusterUuidIfNeeded().clusterUUIDCommitted(true))  
import org.opensearch.transport.BytesTransportRequest;  
            .build();
        assertThrows(IOException.class, () -> CompressedStreamUtils.createCompressedStream(localNode.getVersion(), mockedState::writeTo));  
import static org.mockito.Mockito.doThrow;  
import static org.mockito.ArgumentMatchers.any;
import java.io.IOException;
    public void testCreateCompressedStream() throws IOException {  
        // Decompression works fine
import org.opensearch.cluster.ClusterState;  
}
import static org.mockito.Mockito.mock;
        when(mockedRequest.bytes().streamInput()).thenThrow(IOException.class);
            .build();
        final ClusterState localClusterState = ClusterState.builder(ClusterName.DEFAULT)
import org.opensearch.Version;
import org.opensearch.core.common.bytes.BytesReference;  
        ClusterState mockedState = mock(ClusterState.class);
        assertThrows(AssertionError.class, () -> CompressedStreamUtils.decompressBytes(mockedRequest, DEFAULT_NAMED_WRITABLE_REGISTRY));
        StreamInput input = CompressedStreamUtils.decompressBytes(request, DEFAULT_NAMED_WRITABLE_REGISTRY);
import org.opensearch.cluster.metadata.Metadata;
    }  
        assertEquals(request.version(), input.getVersion());  
import org.opensearch.cluster.node.DiscoveryNode;
        BytesTransportRequest request = new BytesTransportRequest(bytes, localNode.getVersion());
        BytesReference bytes = CompressedStreamUtils.createCompressedStream(localNode.getVersion(), localClusterState::writeTo);  
 */  
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
        BytesTransportRequest mockedRequest = mock(BytesTransportRequest.class, RETURNS_DEEP_STUBS);  
        DiscoveryNode localNode = new DiscoveryNode("node0", buildNewFakeTransportAddress(), Version.CURRENT);
        DiscoveryNode localNode = new DiscoveryNode("node0", buildNewFakeTransportAddress(), Version.CURRENT);
        // serialization success with normal state
        assertNotNull(bytes);
            .metadata(Metadata.builder().generateClusterUuidIfNeeded().clusterUUIDCommitted(true))  
 */  
    }
 * this file be licensed under the Apache-2.0 license or a
        // Fail on write failure on mocked cluster state's writeTo exception  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.OpenSearchTestCase;
/*  
package org.opensearch.cluster.coordination;
import org.opensearch.cluster.ClusterName;
    public void testDecompressBytes() throws IOException {  
 * Contains tests for {@link CompressedStreamUtils}
 * SPDX-License-Identifier: Apache-2.0
/**
 * compatible open source license.
        doThrow(IOException.class).when(mockedState).writeTo(any());
