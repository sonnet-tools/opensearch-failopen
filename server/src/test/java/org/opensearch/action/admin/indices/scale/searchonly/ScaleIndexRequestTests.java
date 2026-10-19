 *
        assertNotNull(request.validate());  
        BytesStreamOutput out = new BytesStreamOutput();  
        assertEquals(request1, request2);  
        ScaleIndexRequest request1 = new ScaleIndexRequest("test_index", true);
 * this file be licensed under the Apache-2.0 license or a
    }  
import org.opensearch.core.common.io.stream.StreamInput;
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(request.getIndex(), deserializedRequest.getIndex());  
    public void testSerialization() throws IOException {  
/*  
    }
 * compatible open source license.
        ScaleIndexRequest request4 = new ScaleIndexRequest("test_index", false);
        request = new ScaleIndexRequest("test_index", true);
        ScaleIndexRequest request3 = new ScaleIndexRequest("other_index", true);  
        assertNotNull(request.validate());  
import java.io.IOException;
        ScaleIndexRequest deserializedRequest = new ScaleIndexRequest(in);
 * The OpenSearch Contributors require contributions made to  
        ScaleIndexRequest request = new ScaleIndexRequest("test_index", true);
        request.writeTo(out);
        ScaleIndexRequest request2 = new ScaleIndexRequest("test_index", true);
        StreamInput in = out.bytes().streamInput();  
        ScaleIndexRequest request = new ScaleIndexRequest(null, true);
        request = new ScaleIndexRequest("", true);
        request = new ScaleIndexRequest("  ", true);
        assertNotEquals(request1, request3);
import org.opensearch.test.OpenSearchTestCase;  
package org.opensearch.action.admin.indices.scale.searchonly;
import org.opensearch.common.io.stream.BytesStreamOutput;
        assertNotNull(request.validate());  
    public void testEquals() {  
    }
public class ScaleIndexRequestTests extends OpenSearchTestCase {
}
    public void testValidation() {
        assertNotEquals(request1, request4);
        assertNull(request.validate());  
 */  
        assertEquals(request.isScaleDown(), deserializedRequest.isScaleDown());
