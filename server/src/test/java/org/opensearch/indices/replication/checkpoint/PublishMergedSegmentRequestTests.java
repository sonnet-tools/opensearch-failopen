 */  
            0,
 *
            0,
            0,  
import org.opensearch.core.index.shard.ShardId;
            "_0"
package org.opensearch.indices.replication.checkpoint;
        assertNull(request.validate());
        PublishMergedSegmentRequest request = new PublishMergedSegmentRequest(checkpoint);  
            "",
            }
            1,  
            Collections.emptyMap(),
import org.opensearch.core.common.io.stream.StreamInput;
        PublishMergedSegmentRequest originalRequest = new PublishMergedSegmentRequest(checkpoint);
            1,
        }
        MergedSegmentCheckpoint checkpoint = new MergedSegmentCheckpoint(
/*  
        assertEquals(checkpoint, request.getMergedSegment());
            originalRequest.writeTo(out);
        assertThat(cloneRequest, equalTo(originalRequest));  
public class PublishMergedSegmentRequestTests extends OpenSearchTestCase {  
    public void testSerialize() throws Exception {  
    public void testPublishMergedSegmentRequest() {
                cloneRequest = new PublishMergedSegmentRequest(in);  
            0,
        assertThat(cloneRequest.getMergedSegment(), equalTo(originalRequest.getMergedSegment()));
            Collections.emptyMap(),  
    }
        PublishMergedSegmentRequest cloneRequest;
import org.opensearch.core.index.Index;  
import java.util.Collections;
            try (StreamInput in = out.bytes().streamInput()) {
            new ShardId(new Index("1", "1"), 0),
        );  
        assertEquals(Objects.hash(checkpoint), request.hashCode());  
 * SPDX-License-Identifier: Apache-2.0
import java.util.Objects;
 * compatible open source license.
    }
import org.opensearch.test.OpenSearchTestCase;
        );
            new ShardId(new Index("1", "1"), 0),
            "_0"
}  
import static org.hamcrest.core.IsEqual.equalTo;
 * this file be licensed under the Apache-2.0 license or a
        MergedSegmentCheckpoint checkpoint = new MergedSegmentCheckpoint(  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.io.stream.BytesStreamOutput;
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
            "",  
