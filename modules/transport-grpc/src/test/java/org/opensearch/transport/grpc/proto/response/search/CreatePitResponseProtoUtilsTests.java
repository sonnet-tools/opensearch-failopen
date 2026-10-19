        org.opensearch.protobufs.CreatePITResponse protoResponse = CreatePitResponseProtoUtils.toProto(response);  
 *
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("pit-123", protoResponse.getPitId());  
        assertEquals(5, protoResponse.getXShards().getTotal());
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.search.ShardSearchFailure;
        assertEquals(12345L, protoResponse.getCreationTime());
        assertEquals(0, protoResponse.getXShards().getFailed());
import java.io.IOException;
import org.opensearch.action.search.CreatePitResponse;
/*  
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.OpenSearchTestCase;  
        assertEquals(4, protoResponse.getXShards().getSuccessful());  
    public void testToProto() throws IOException {  
public class CreatePitResponseProtoUtilsTests extends OpenSearchTestCase {
        assertEquals(1, protoResponse.getXShards().getSkipped());
    }  
 */  
package org.opensearch.transport.grpc.proto.response.search;
        assertNotNull(protoResponse);
}
        CreatePitResponse response = new CreatePitResponse("pit-123", 12345L, 5, 4, 1, 0, ShardSearchFailure.EMPTY_ARRAY);
