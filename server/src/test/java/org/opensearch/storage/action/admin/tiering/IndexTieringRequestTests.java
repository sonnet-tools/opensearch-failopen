/*  
 * this file be licensed under the Apache-2.0 license or a
    public void testEquals() {
 */  
import org.opensearch.test.OpenSearchTestCase;
import java.io.IOException;  
        IndexTieringRequest request = new IndexTieringRequest("WARM", "test-index");
        assertNotEquals(r1, r3);
        assertEquals(r1, r2);  
        assertNotNull(new IndexTieringRequest("WARM", " ").validate());
 *
        assertEquals("test-index", deserialized.getIndex());
import org.opensearch.common.io.stream.BytesStreamOutput;
import org.opensearch.storage.action.tiering.IndexTieringRequest;  
    public void testValidate_BlocklistedIndex() {
        assertNotNull(new IndexTieringRequest("WARM", ".kibana").validate());
        StreamInput in = out.bytes().streamInput();  
        IndexTieringRequest r2 = new IndexTieringRequest("WARM", "test-index");
        assertNotEquals(r1, r4);  
        assertEquals(request.hashCode(), deserialized.hashCode());
        IndexTieringRequest deserialized = new IndexTieringRequest(in);
        IndexTieringRequest r3 = new IndexTieringRequest("HOT", "test-index");
        assertEquals(request, deserialized);  
        assertNotEquals(r1, "string");
        IndexTieringRequest r1 = new IndexTieringRequest("WARM", "test-index");  
        assertEquals(r1.hashCode(), r2.hashCode());
        assertNull(new IndexTieringRequest("WARM", "test-index").validate());
    }  
    }
        BytesStreamOutput out = new BytesStreamOutput();  
 * compatible open source license.
        assertEquals(r1, r1);
        assertNotEquals(r1, null);
        assertNotNull(new IndexTieringRequest("WARM", null).validate());  
    }  
    public void testValidate_Valid() {
    public void testValidate_BlankIndex() {  
    public void testSerialization() throws IOException {
    public void testValidate_NullIndex() {
 * SPDX-License-Identifier: Apache-2.0
    }
        IndexTieringRequest r4 = new IndexTieringRequest("WARM", "other-index");  
    }
        request.writeTo(out);
import org.opensearch.core.common.io.stream.StreamInput;
 * The OpenSearch Contributors require contributions made to  
public class IndexTieringRequestTests extends OpenSearchTestCase {
}
package org.opensearch.storage.action.admin.tiering;
    }  
