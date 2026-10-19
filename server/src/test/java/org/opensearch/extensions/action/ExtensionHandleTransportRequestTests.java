    public void testExtensionHandleTransportRequest() throws Exception {
import org.opensearch.common.io.stream.BytesStreamOutput;
}
 */  
 *
        String expectedAction = "test-action";  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
        assertEquals(expectedRequestBytes, request.getRequestBytes());
        BytesStreamOutput out = new BytesStreamOutput();  
        assertEquals(expectedAction, request.getAction());
 * The OpenSearch Contributors require contributions made to  
import com.google.protobuf.ByteString;
public class ExtensionHandleTransportRequestTests extends OpenSearchTestCase {
        assertEquals(expectedRequestBytes, request.getRequestBytes());
        BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()));
import org.opensearch.core.common.io.stream.BytesStreamInput;
        assertEquals(expectedAction, request.getAction());
/*  
        ExtensionHandleTransportRequest request = new ExtensionHandleTransportRequest(expectedAction, expectedRequestBytes);
    }  
        logger.info(request.getRequestBytes());  
package org.opensearch.extensions.action;
import org.opensearch.core.common.bytes.BytesReference;  
 * this file be licensed under the Apache-2.0 license or a
        request = new ExtensionHandleTransportRequest(in);  
        logger.info(expectedRequestBytes);
        ByteString expectedRequestBytes = ByteString.copyFromUtf8("request-bytes");
        request.writeTo(out);
import org.opensearch.test.OpenSearchTestCase;
