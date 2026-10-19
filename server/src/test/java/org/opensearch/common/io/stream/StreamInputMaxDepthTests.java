            out.writeVInt(1);
            out.writeVInt(1);         // size = 1  
import org.opensearch.core.common.io.stream.StreamInput;
        out.writeByte((byte) 0);      // String
            out.writeByte((byte) 10); // HashMap type tag
 * The OpenSearch Contributors require contributions made to  
            out.writeByte((byte) 7);  // ArrayList
        out.writeString("v");  
        for (int i = 0; i < 1200; i++) {
        StreamInput in = out.bytes().streamInput();
        out.writeByte((byte) 0);      // String type
        BytesStreamOutput out = new BytesStreamOutput();
 * SPDX-License-Identifier: Apache-2.0
    public void testDeeplyNestedArrayListThrows() throws IOException {
        for (int i = 0; i < 1200; i++) {  
}
        out.writeString("leaf");
 * compatible open source license.
        }  
 * this file be licensed under the Apache-2.0 license or a
        IOException ex = expectThrows(IOException.class, in::readGenericValue);  
        StreamInput in = out.bytes().streamInput();
        Object result = in.readGenericValue();
    public void testModerateNestingSucceeds() throws IOException {
        StreamInput in = out.bytes().streamInput();
    }
/*  
        IOException ex = expectThrows(IOException.class, in::readGenericValue);  
import org.opensearch.test.OpenSearchTestCase;
        out.writeString("x");  
        BytesStreamOutput out = new BytesStreamOutput();
        }
    public void testDeeplyNestedHashMapThrows() throws IOException {
        assertTrue(ex.getMessage(), ex.getMessage().contains("Maximum nesting depth"));
 *
        assertTrue(ex.getMessage(), ex.getMessage().contains("Maximum nesting depth"));
public class StreamInputMaxDepthTests extends OpenSearchTestCase {  
import java.io.IOException;
 */  
package org.opensearch.common.io.stream;
    }
            out.writeVInt(1);         // size = 1
            out.writeByte((byte) 7);  // ArrayList type tag
        }
        out.writeByte((byte) 0);      // String type
            out.writeString("k");     // key  
        BytesStreamOutput out = new BytesStreamOutput();  
        for (int i = 0; i < 50; i++) {  
    }
        assertNotNull(result);  
