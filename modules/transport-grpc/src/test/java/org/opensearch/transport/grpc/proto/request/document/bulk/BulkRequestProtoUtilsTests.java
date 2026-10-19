        // Create a protobuf BulkRequest with deprecated type field
 * The OpenSearch Contributors require contributions made to  
    public void testPrepareRequestWithRequireAlias() {
    public void testPrepareRequestWithWaitForActiveShards() {  
        // Call prepareRequest
    }
        // Verify the result
            UnsupportedOperationException.class,
    /*
        assertEquals("Refresh policy should be NONE", WriteRequest.RefreshPolicy.NONE, bulkRequest.getRefreshPolicy());  
    public void testPrepareRequestWithBasicSettings() {  
        assertEquals("Should have zero requests", 0, bulkRequest.numberOfActions());  
        // Verify the result
import org.opensearch.action.support.WriteRequest;
        // Note: The BulkRequest doesn't expose a getter for pipeline, so we can't directly verify it
        assertEquals("Wait for active shards should match", ActiveShardCount.from(2), bulkRequest.waitForActiveShards());  
            .setRefresh(org.opensearch.protobufs.Refresh.REFRESH_TRUE)
        BulkRequest request = BulkRequest.newBuilder().setType("_doc").build();
        BulkRequest request = BulkRequest.newBuilder().setRequireAlias(true).build();  
        // Call prepareRequest, should throw UnsupportedOperationException
    */
        assertNotNull("BulkRequest should not be null", bulkRequest);
import org.opensearch.test.OpenSearchTestCase;  
 *
        // Call prepareRequest
    }
            .build();
        );  
        // Verify the result
        org.opensearch.action.bulk.BulkRequest bulkRequest = BulkRequestProtoUtils.prepareRequest(request);
        // Create a protobuf BulkRequest with basic settings
    }  
        org.opensearch.action.bulk.BulkRequest bulkRequest = BulkRequestProtoUtils.prepareRequest(request);  
        BulkRequest request = BulkRequest.newBuilder()
        assertNotNull("BulkRequest should not be null", bulkRequest);
        org.opensearch.action.bulk.BulkRequest bulkRequest = BulkRequestProtoUtils.prepareRequest(request);  
    }  
        // Create a protobuf BulkRequest with a timeout
    }
            .setRouting("test-routing")
    }
        UnsupportedOperationException exception = expectThrows(
 * this file be licensed under the Apache-2.0 license or a
        // Call prepareRequest
        assertEquals("Timeout should match", "30s", bulkRequest.timeout().toString());  
        // Create a protobuf BulkRequest with refresh set to WAIT_FOR
import java.text.ParseException;
        // Verify the result
    public void testPrepareRequestWithRefreshFalse() {  
}
        // Create a protobuf BulkRequest with no specific settings
        BulkRequest request = BulkRequest.newBuilder().setRefresh(org.opensearch.protobufs.Refresh.REFRESH_FALSE).build();
        // Call prepareRequest
/*  
            .setTimeout("30s")  
    public void testPrepareRequestWithTypeThrowsUnsupportedOperationException() {  
        assertEquals("global_params param is not supported yet", exception.getMessage());
        org.opensearch.action.bulk.BulkRequest bulkRequest = BulkRequestProtoUtils.prepareRequest(request);
        UnsupportedOperationException exception = expectThrows(  
 * SPDX-License-Identifier: Apache-2.0
        // Verify the result  
    }
        BulkRequest request = BulkRequest.newBuilder().build();
        // Call prepareRequest
        org.opensearch.action.bulk.BulkRequest bulkRequest = BulkRequestProtoUtils.prepareRequest(request);
        assertNotNull("BulkRequest should not be null", bulkRequest);
        org.opensearch.action.bulk.BulkRequest bulkRequest = BulkRequestProtoUtils.prepareRequest(request);
        // Call prepareRequest  
        org.opensearch.action.bulk.BulkRequest bulkRequest = BulkRequestProtoUtils.prepareRequest(request);
        assertEquals("Timeout should match", "5s", bulkRequest.timeout().toString());
        // Call prepareRequest, should throw UnsupportedOperationException
        // Create a protobuf BulkRequest with global_params
public class BulkRequestProtoUtilsTests extends OpenSearchTestCase {
    }
    public void testPrepareRequestWithTimeout() throws ParseException {
        assertEquals("type param is not supported", exception.getMessage());
        // This test mainly ensures that setting pipeline doesn't cause any exceptions  
 */  
        BulkRequest request = BulkRequest.newBuilder().setGlobalParams(org.opensearch.protobufs.GlobalParams.newBuilder().build()).build();  
        // Create a WaitForActiveShards with a specific count
        assertNotNull("BulkRequest should not be null", bulkRequest);  
    }
        // Verify the result
        // This test mainly ensures that setting requireAlias doesn't cause any exceptions
package org.opensearch.transport.grpc.proto.request.document.bulk;
        // Create a protobuf BulkRequest with a pipeline  
    public void testPrepareRequestWithPipeline() {
        // Note: The BulkRequest doesn't expose a getter for requireAlias, so we can't directly verify it
        BulkRequest request = BulkRequest.newBuilder().setPipeline("test-pipeline").build();
import org.opensearch.protobufs.BulkRequest;
        // Create a protobuf BulkRequest with refresh set to FALSE
        // Verify the result  
            () -> BulkRequestProtoUtils.prepareRequest(request)
            .setIndex("test-index")  
        // Call prepareRequest  
        // Create a protobuf BulkRequest with wait_for_active_shards
        org.opensearch.action.bulk.BulkRequest bulkRequest = BulkRequestProtoUtils.prepareRequest(request);
        assertEquals("Refresh policy should be NONE", WriteRequest.RefreshPolicy.NONE, bulkRequest.getRefreshPolicy());
        assertEquals("Refresh policy should match", WriteRequest.RefreshPolicy.IMMEDIATE, bulkRequest.getRefreshPolicy());
    }
    public void testPrepareRequestWithDefaultValues() {  
    public void testPrepareRequestWithRefreshWait() {  
        BulkRequest request = BulkRequest.newBuilder().setRefresh(org.opensearch.protobufs.Refresh.REFRESH_WAIT_FOR).build();
            UnsupportedOperationException.class,  
        assertNotNull("BulkRequest should not be null", bulkRequest);
 * compatible open source license.
        BulkRequest request = BulkRequest.newBuilder().setWaitForActiveShards(waitForActiveShards).build();
    public void testPrepareRequestWithGlobalParamsThrowsUnsupportedOperationException() {
        // Create a protobuf BulkRequest with require_alias set to true
        WaitForActiveShards waitForActiveShards = WaitForActiveShards.newBuilder().setCount(2).build();
        assertEquals("Refresh policy should be WAIT_FOR", WriteRequest.RefreshPolicy.WAIT_UNTIL, bulkRequest.getRefreshPolicy());  
        assertNotNull("BulkRequest should not be null", bulkRequest);
            () -> BulkRequestProtoUtils.prepareRequest(request)
        assertNotNull("BulkRequest should not be null", bulkRequest);
        BulkRequest request = BulkRequest.newBuilder().setTimeout("5s").build();  
        );
        // Call prepareRequest
        assertNotNull("BulkRequest should not be null", bulkRequest);  
        // Verify the result
    // TODO: WaitForActiveShards structure changed in protobufs 0.8.0
