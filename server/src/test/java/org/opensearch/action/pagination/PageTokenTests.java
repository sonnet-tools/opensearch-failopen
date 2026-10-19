            pageToken.writeTo(out);
            try (StreamInput in = out.bytes().streamInput()) {
 * The OpenSearch Contributors require contributions made to  
                PageToken deserialized = new PageToken(in);  
            pageToken.writeTo(out);  
import org.opensearch.common.io.stream.BytesStreamOutput;
                PageToken deserialized = new PageToken(in);
        }  
}
            }
                assertEquals(pageToken, deserialized);  
        PageToken pageToken = new PageToken("foo", "test");
            }
/*  
import org.opensearch.test.OpenSearchTestCase;  
            try (StreamInput in = out.bytes().streamInput()) {
        try (BytesStreamOutput out = new BytesStreamOutput()) {
package org.opensearch.action.pagination;
 * compatible open source license.
    public void testSerializationWithNextTokenAbsent() throws Exception {  
public class PageTokenTests extends OpenSearchTestCase {
    }
 * SPDX-License-Identifier: Apache-2.0
        PageToken pageToken = new PageToken(null, "test");
 *
 * this file be licensed under the Apache-2.0 license or a
        }
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
    public void testSerialization() throws Exception {
                assertEquals(pageToken, deserialized);
 */  
    }  
import org.opensearch.core.common.io.stream.StreamInput;
