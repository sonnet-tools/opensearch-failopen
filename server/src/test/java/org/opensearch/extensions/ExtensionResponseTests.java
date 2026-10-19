        try (BytesStreamOutput out = new BytesStreamOutput()) {
            out.flush();
                assertEquals(response, booleanResponse.getStatus());
public class ExtensionResponseTests extends OpenSearchTestCase {  
                booleanResponse = new AcknowledgedResponse(in);  
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
    }
package org.opensearch.extensions;
            }  
 */  
 *
 * compatible open source license.
import org.opensearch.test.OpenSearchTestCase;
/*  
        assertEquals(response, booleanResponse.getStatus());  
            booleanResponse.writeTo(out);  
        }
import org.opensearch.core.common.io.stream.BytesStreamInput;  
}  
        AcknowledgedResponse booleanResponse = new AcknowledgedResponse(response);
        boolean response = true;  
import org.opensearch.common.io.stream.BytesStreamOutput;
import org.opensearch.core.common.bytes.BytesReference;
 * SPDX-License-Identifier: Apache-2.0
    public void testAcknowledgedResponse() throws Exception {
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
