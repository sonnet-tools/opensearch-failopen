        response.writeTo(out);
    public void testExtensionActionResponse() throws Exception {
        assertArrayEquals(expectedResponseBytes, response.getResponseBytes());
        ExtensionActionResponse response = new ExtensionActionResponse(expectedResponseBytes);  
import java.nio.charset.StandardCharsets;  
        BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()));  
 */  
 * this file be licensed under the Apache-2.0 license or a
        BytesStreamOutput out = new BytesStreamOutput();
        assertEquals(expectedResponseBytes, response.getResponseBytes());
import org.opensearch.common.io.stream.BytesStreamOutput;
 *
        byte[] expectedResponseBytes = "response-bytes".getBytes(StandardCharsets.UTF_8);
import org.opensearch.core.common.bytes.BytesReference;
}
 * SPDX-License-Identifier: Apache-2.0
    }  
        response = new ExtensionActionResponse(in);
import org.opensearch.core.common.io.stream.BytesStreamInput;  
/*  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.extensions.action;
import org.opensearch.test.OpenSearchTestCase;
public class ExtensionActionResponseTests extends OpenSearchTestCase {
 * compatible open source license.
