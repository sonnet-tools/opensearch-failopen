        deserialized = ser.deserialize(serialized);  
        serialized = ser.serialize(cbr);
        assertEquals(pbr, deserialized);
        assertEquals(rbr, deserialized);
        serialized = ser.serialize(ba);
import org.opensearch.core.common.util.ByteArray;
        assertTrue(ser.equals(pbr, serialized));
/*  
import org.opensearch.common.Randomness;
        arr.set(0L, pbrValue, 0, pbrValue.length);
        byte[] bytesValue = new byte[1000];
import org.opensearch.common.util.BigArrays;  
        serialized = ser.serialize(rbr);
 * The OpenSearch Contributors require contributions made to  
        ByteArray arr = BigArrays.NON_RECYCLING_INSTANCE.newByteArray(pbrValue.length);  
        byte[] pbrValue = new byte[PageCacheRecycler.PAGE_SIZE_IN_BYTES * 2];
package org.opensearch.common.cache.serializer;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.bytes.ReleasableBytesReference;
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(ba, deserialized);
        deserialized = ser.deserialize(serialized);  
    public void testEquality() throws Exception {
        BytesReference cbr = CompositeBytesReference.of(new BytesArray(bytesValue), new BytesArray(bytesValue));  
public class BytesReferenceSerializerTests extends OpenSearchTestCase {
import java.util.Random;
        deserialized = ser.deserialize(serialized);  
        rand.nextBytes(pbrValue);
        serialized = ser.serialize(pbr);
        assertTrue(ser.equals(ba, serialized));
 */  
        // We need the PagedBytesReference to be larger than the page size (16 KB) in order to actually create it  
import org.opensearch.core.common.bytes.BytesReference;  
import org.opensearch.core.common.bytes.CompositeBytesReference;
        BytesReference deserialized = ser.deserialize(serialized);  
        assert !arr.hasArray();
        assertTrue(ser.equals(ba, serialized));
import org.opensearch.core.common.bytes.BytesArray;
        rand.nextBytes(bytesValue);
        assertEquals(ba, deserialized);
import org.opensearch.common.util.PageCacheRecycler;
import org.opensearch.test.OpenSearchTestCase;  
}  
        assertTrue(ser.equals(cbr, serialized));
        deserialized = ser.deserialize(serialized);  
 * compatible open source license.
 *
        BytesReference rbr = new ReleasableBytesReference(new BytesArray(bytesValue), ReleasableBytesReference.NO_OP);  
        BytesReferenceSerializer ser = new BytesReferenceSerializer();  
        BytesReference ba = new BytesArray(bytesValue);  
        ba = new BytesArray(new byte[] {});  
        assertTrue(ser.equals(rbr, serialized));
        byte[] serialized = ser.serialize(ba);
        BytesReference pbr = BytesReference.fromByteArray(arr, pbrValue.length);  
        Random rand = Randomness.get();  
        // Test that values are equal before and after serialization, for each implementation of BytesReference.
        assertEquals(cbr, deserialized);
    }
