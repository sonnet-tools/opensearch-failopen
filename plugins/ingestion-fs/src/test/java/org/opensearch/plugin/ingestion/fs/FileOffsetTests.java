    public void testFileOffset() {
package org.opensearch.plugin.ingestion.fs;
        long deserialized = ByteBuffer.wrap(serialized).getLong();
public class FileOffsetTests extends OpenSearchTestCase {
import java.nio.ByteBuffer;  
 * The OpenSearch Contributors require contributions made to  
/*  
        FileOffset offset = new FileOffset(42L);
 * compatible open source license.
 *
        byte[] serialized = offset.serialize();  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.OpenSearchTestCase;
    }  
}
        assertEquals(offset.getLine(), deserialized);
 * SPDX-License-Identifier: Apache-2.0
 */  
