            originalRequest.writeTo(out);  
        assertThat(cloneRequest.getReferencedSegmentsCheckpoint(), equalTo(originalRequest.getReferencedSegmentsCheckpoint()));  
                cloneRequest = new PublishReferencedSegmentsRequest(in);
            try (StreamInput in = out.bytes().streamInput()) {
import static org.hamcrest.core.IsEqual.equalTo;
            Sets.newHashSet("_1", "_2", "_3")
        assertNull(request.validate());
import org.opensearch.core.index.shard.ShardId;
        }
import org.opensearch.core.index.Index;
            1,  
        );
/*  
        PublishReferencedSegmentsRequest originalRequest = new PublishReferencedSegmentsRequest(checkpoint);  
}
            0,
        assertThat(cloneRequest, equalTo(originalRequest));
import org.opensearch.core.common.io.stream.StreamInput;  
    }  
        ReferencedSegmentsCheckpoint checkpoint = new ReferencedSegmentsCheckpoint(  
import org.opensearch.common.util.set.Sets;
public class PublishReferencedSegmentsRequestTests extends OpenSearchTestCase {  
    public void testSerialize() throws Exception {
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            0,
            Collections.emptyMap(),  
import java.util.Collections;
    public void testPublishReferencedSegmentsRequest() {
import org.opensearch.common.io.stream.BytesStreamOutput;
        PublishReferencedSegmentsRequest request = new PublishReferencedSegmentsRequest(checkpoint);  
            Collections.emptyMap(),  
package org.opensearch.indices.replication.checkpoint;
import org.opensearch.test.OpenSearchTestCase;  
        );
            new ShardId(new Index("1", "1"), 0),
 *
    }
            0,
            Sets.newHashSet("_1", "_2", "_3")
        PublishReferencedSegmentsRequest cloneRequest;
 * this file be licensed under the Apache-2.0 license or a
            1,  
        assertEquals(checkpoint, request.getReferencedSegmentsCheckpoint());
            new ShardId(new Index("1", "1"), 0),
            }  
 * compatible open source license.
            "",
            0,
 */  
        ReferencedSegmentsCheckpoint checkpoint = new ReferencedSegmentsCheckpoint(  
 * The OpenSearch Contributors require contributions made to  
            "",
 * SPDX-License-Identifier: Apache-2.0
