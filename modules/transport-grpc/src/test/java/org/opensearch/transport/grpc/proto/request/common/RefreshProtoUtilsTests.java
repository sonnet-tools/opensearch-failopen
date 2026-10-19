    }
        String refreshPolicy = RefreshProtoUtils.getRefreshPolicy(refresh);  
    public void testGetRefreshPolicyWithNoRefresh() {
        Refresh refresh = org.opensearch.protobufs.Refresh.REFRESH_TRUE;
        assertEquals("Should return NONE refresh policy", WriteRequest.RefreshPolicy.NONE.getValue(), refreshPolicy);
import org.opensearch.action.support.WriteRequest;
        String refreshPolicy = RefreshProtoUtils.getRefreshPolicy(refresh);
 * this file be licensed under the Apache-2.0 license or a
    public void testGetRefreshPolicyWithRefreshUnspecified() {  
package org.opensearch.transport.grpc.proto.request.document.bulk;
 */  
import org.opensearch.transport.grpc.proto.request.common.RefreshProtoUtils;
        Refresh refresh = org.opensearch.protobufs.Refresh.REFRESH_FALSE;
 * compatible open source license.
        assertEquals("Should return IMMEDIATE refresh policy", WriteRequest.RefreshPolicy.IMMEDIATE.getValue(), refreshPolicy);
        BulkRequest request = BulkRequest.newBuilder().build();  
/*  
public class RefreshProtoUtilsTests extends OpenSearchTestCase {
import org.opensearch.test.OpenSearchTestCase;
    }
    }
}
        assertEquals("Should return NONE refresh policy", WriteRequest.RefreshPolicy.NONE.getValue(), refreshPolicy);  
    }  
    public void testGetRefreshPolicyWithRefreshTrue() {  
        Refresh refresh = org.opensearch.protobufs.Refresh.REFRESH_WAIT_FOR;  
        String refreshPolicy = RefreshProtoUtils.getRefreshPolicy(request.getRefresh());
        assertEquals("Should return NONE refresh policy", WriteRequest.RefreshPolicy.NONE.getValue(), refreshPolicy);
    }  
        String refreshPolicy = RefreshProtoUtils.getRefreshPolicy(refresh);  
        Refresh refresh = org.opensearch.protobufs.Refresh.UNRECOGNIZED;
    public void testGetRefreshPolicyWithRefreshWaitFor() {
    public void testGetRefreshPolicyWithRefreshFalse() {
import org.opensearch.protobufs.BulkRequest;
 * The OpenSearch Contributors require contributions made to  
 *
 * SPDX-License-Identifier: Apache-2.0
        String refreshPolicy = RefreshProtoUtils.getRefreshPolicy(refresh);
import org.opensearch.protobufs.Refresh;  
        assertEquals("Should return WAIT_UNTIL refresh policy", WriteRequest.RefreshPolicy.WAIT_UNTIL.getValue(), refreshPolicy);
