        );
            Map.of("_0", "_0__uuid")
 * compatible open source license.
        RemoteStorePublishMergedSegmentRequest originalRequest = new RemoteStorePublishMergedSegmentRequest(checkpoint);
            }
import org.opensearch.core.index.Index;  
import org.opensearch.core.common.io.stream.StreamInput;
package org.opensearch.indices.replication.checkpoint;
            try (StreamInput in = out.bytes().streamInput()) {
        assertEquals(cloneRequest.getMergedSegment(), originalRequest.getMergedSegment());  
import java.util.Collections;
    }
        RemoteStoreMergedSegmentCheckpoint checkpoint = new RemoteStoreMergedSegmentCheckpoint(  
                cloneRequest = new RemoteStorePublishMergedSegmentRequest(in);  
            new MergedSegmentCheckpoint(new ShardId(new Index("1", "1"), 0), 0, 0, 0, "", Collections.emptyMap(), "_0"),
        assertEquals(checkpoint, request.getMergedSegment());  
            Map.of("_0", "_0__uuid")
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
import org.opensearch.core.index.shard.ShardId;
 */  
    public void testSerialize() throws Exception {
import java.util.Map;
/*  
}
        );  
import java.util.Objects;  
import org.opensearch.common.io.stream.BytesStreamOutput;
        RemoteStoreMergedSegmentCheckpoint checkpoint = new RemoteStoreMergedSegmentCheckpoint(
            originalRequest.writeTo(out);
 *
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(checkpoint.getLocalToRemoteSegmentFilenameMap(), Map.of("_0", "_0__uuid"));
 * The OpenSearch Contributors require contributions made to  
    public void testPublishMergedSegmentRequest() {
        }
        RemoteStorePublishMergedSegmentRequest request = new RemoteStorePublishMergedSegmentRequest(checkpoint);
        RemoteStorePublishMergedSegmentRequest cloneRequest;
public class RemoteStorePublishMergedSegmentRequestTests extends OpenSearchTestCase {
        assertNull(request.validate());
    }  
            new MergedSegmentCheckpoint(new ShardId(new Index("1", "1"), 0), 0, 0, 0, "", Collections.emptyMap(), "_0"),  
        assertEquals(Objects.hash(checkpoint), request.hashCode());
 * this file be licensed under the Apache-2.0 license or a
