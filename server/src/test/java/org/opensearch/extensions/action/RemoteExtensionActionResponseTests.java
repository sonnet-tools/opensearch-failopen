        BytesStreamOutput out = new BytesStreamOutput();
        assertArrayEquals(expectedResponseBytes, response.getResponseBytes());
        assertTrue(response.isSuccess());
 *
        assertArrayEquals(expectedResponseBytes, response.getResponseBytes());
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.io.stream.BytesStreamInput;  
import java.nio.charset.StandardCharsets;  
        assertFalse(response.isSuccess());
        RemoteExtensionActionResponse response = new RemoteExtensionActionResponse(true, expectedResponseBytes);  
import org.opensearch.common.io.stream.BytesStreamOutput;
        BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()));
    }  
    public void testExtensionActionResponse() throws Exception {
        response.writeTo(out);  
    }
        RemoteExtensionActionResponse response = new RemoteExtensionActionResponse(false, expectedEmptyBytes);  
        assertEquals(expectedResponse, response.getResponseBytesAsString());  
        assertTrue(response.isSuccess());
 */  
        response.setResponseBytes(expectedResponseBytes);
        byte[] expectedResponseBytes = expectedResponse.getBytes(StandardCharsets.UTF_8);
        String expectedResponse = "response-bytes";  
        assertTrue(response.isSuccess());  
public class RemoteExtensionActionResponseTests extends OpenSearchTestCase {
import org.opensearch.test.OpenSearchTestCase;
}
        assertArrayEquals(expectedResponseBytes, response.getResponseBytes());
        response = new RemoteExtensionActionResponse(in);
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
import org.opensearch.core.common.bytes.BytesReference;
        byte[] expectedEmptyBytes = new byte[0];
 * this file be licensed under the Apache-2.0 license or a
/*  
        assertEquals(expectedResponseBytes, response.getResponseBytes());  
    public void testSetters() {
        assertArrayEquals(expectedEmptyBytes, response.getResponseBytes());
        response.setResponseBytesAsString(expectedResponse);
        byte[] expectedResponseBytes = "response-bytes".getBytes(StandardCharsets.UTF_8);
package org.opensearch.extensions.action;
        response.setSuccess(true);
