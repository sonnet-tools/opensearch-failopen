        BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()));  
        TransportActionRequestFromExtension request = new TransportActionRequestFromExtension(  
        BytesStreamOutput out = new BytesStreamOutput();
import org.opensearch.common.io.stream.BytesStreamOutput;
        );
 *
/*  
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(expectedAction, request.getAction());  
}
import org.opensearch.core.common.bytes.BytesReference;  
            uniqueId  
        assertEquals(expectedRequestBytes, request.getRequestBytes());
    }  
        assertEquals(uniqueId, request.getUniqueId());
            expectedAction,
import org.opensearch.test.OpenSearchTestCase;
import com.google.protobuf.ByteString;
        assertEquals(expectedRequestBytes, request.getRequestBytes());
package org.opensearch.extensions.action;
 */  
        String expectedAction = "test-action";  
public class TransportActionRequestFromExtensionTests extends OpenSearchTestCase {
        assertEquals(expectedAction, request.getAction());  
            expectedRequestBytes,
 * compatible open source license.
    public void testTransportActionRequestFromExtension() throws Exception {
import org.opensearch.core.common.io.stream.BytesStreamInput;
        request = new TransportActionRequestFromExtension(in);
        String uniqueId = "test-uniqueId";
 * The OpenSearch Contributors require contributions made to  
        ByteString expectedRequestBytes = ByteString.copyFromUtf8("request-bytes");
        assertEquals(uniqueId, request.getUniqueId());
 * SPDX-License-Identifier: Apache-2.0
        request.writeTo(out);
