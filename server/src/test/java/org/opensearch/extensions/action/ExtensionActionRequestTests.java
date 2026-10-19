        assertEquals(expectedRequestBytes, request.getRequestBytes());
        BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()));
        ExtensionActionRequest request = new ExtensionActionRequest(expectedAction, expectedRequestBytes);  
 * this file be licensed under the Apache-2.0 license or a
        assertNull(request.validate());  
        assertEquals(expectedAction, request.getAction());
}
        assertEquals(expectedAction, request.getAction());
 * SPDX-License-Identifier: Apache-2.0
        ByteString expectedRequestBytes = ByteString.copyFromUtf8("request-bytes");
package org.opensearch.extensions.action;
/*  
        String expectedAction = "test-action";
        BytesStreamOutput out = new BytesStreamOutput();
public class ExtensionActionRequestTests extends OpenSearchTestCase {
import com.google.protobuf.ByteString;
        request.writeTo(out);  
 */  
 *
 * The OpenSearch Contributors require contributions made to  
    }
        request = new ExtensionActionRequest(in);
import org.opensearch.test.OpenSearchTestCase;
    public void testExtensionActionRequest() throws Exception {  
        assertEquals(expectedRequestBytes, request.getRequestBytes());  
import org.opensearch.common.io.stream.BytesStreamOutput;
import org.opensearch.core.common.io.stream.BytesStreamInput;
import org.opensearch.core.common.bytes.BytesReference;  
 * compatible open source license.
