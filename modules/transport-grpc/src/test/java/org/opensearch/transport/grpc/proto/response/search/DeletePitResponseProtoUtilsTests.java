    }
import org.opensearch.action.search.DeletePitResponse;
import org.opensearch.test.OpenSearchTestCase;  
        assertEquals("pit-2", protoResponse.getPits(1).getPitId());
        assertFalse(protoResponse.getPits(1).getSuccessful());  
import java.util.List;
        assertEquals(2, protoResponse.getPitsCount());  
}  
package org.opensearch.transport.grpc.proto.response.search;
public class DeletePitResponseProtoUtilsTests extends OpenSearchTestCase {
 *
        assertNotNull(protoResponse);
 * this file be licensed under the Apache-2.0 license or a
        DeletePitResponse response = new DeletePitResponse(List.of(new DeletePitInfo(true, "pit-1"), new DeletePitInfo(false, "pit-2")));
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("pit-1", protoResponse.getPits(0).getPitId());
    public void testToProto() {  
 * compatible open source license.
        org.opensearch.protobufs.DeletePITResponse protoResponse = DeletePitResponseProtoUtils.toProto(response);  
        assertTrue(protoResponse.getPits(0).getSuccessful());
import org.opensearch.action.search.DeletePitInfo;
 * The OpenSearch Contributors require contributions made to  
 */  
/*  
