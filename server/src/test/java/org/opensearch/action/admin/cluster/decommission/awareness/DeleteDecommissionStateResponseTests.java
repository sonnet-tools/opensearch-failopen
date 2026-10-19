        final DeleteDecommissionStateResponse originalResponse = new DeleteDecommissionStateResponse(true);  
 * SPDX-License-Identifier: Apache-2.0
        );  
import org.opensearch.action.admin.cluster.decommission.awareness.delete.DeleteDecommissionStateResponse;
import java.io.IOException;
 *
            writableRegistry(),
        final DeleteDecommissionStateResponse deserialized = copyWriteable(
/*  
 */  
}
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(deserialized, originalResponse);
    public void testSerialization() throws IOException {
 * compatible open source license.
public class DeleteDecommissionStateResponseTests extends OpenSearchTestCase {  
    }  
package org.opensearch.action.admin.cluster.decommission.awareness;
            DeleteDecommissionStateResponse::new
import org.opensearch.test.OpenSearchTestCase;
 * The OpenSearch Contributors require contributions made to  
            originalResponse,  
