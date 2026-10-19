        org.opensearch.protobufs.DeletePitRequest protoRequest = org.opensearch.protobufs.DeletePitRequest.newBuilder()
            .addPitId("pit-1")
            .addPitId("pit-2")  
        assertEquals("pit-2", request.getPitIds().get(1));
import org.opensearch.test.OpenSearchTestCase;
 *
}
        assertEquals(1, request.getPitIds().size());
        assertEquals(2, request.getPitIds().size());
    }
        DeletePitRequest request = DeletePitRequestProtoUtils.prepareRequest(protoRequest);  
 * SPDX-License-Identifier: Apache-2.0
 */  
/*  
    }
        assertEquals("_all", request.getPitIds().get(0));  
 * this file be licensed under the Apache-2.0 license or a
            .build();
        DeletePitRequest request = DeletePitRequestProtoUtils.prepareRequest(protoRequest);  
import org.opensearch.action.search.DeletePitRequest;
    public void testPrepareRequestWithAllPitSelector() {
        org.opensearch.protobufs.DeletePitRequest protoRequest = org.opensearch.protobufs.DeletePitRequest.newBuilder()
    public void testPrepareRequestWithMultiplePitIds() {  
package org.opensearch.transport.grpc.proto.request.search;
public class DeletePitRequestProtoUtilsTests extends OpenSearchTestCase {
        assertEquals("pit-1", request.getPitIds().get(0));  
            .addPitId("_all")  
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
            .build();
