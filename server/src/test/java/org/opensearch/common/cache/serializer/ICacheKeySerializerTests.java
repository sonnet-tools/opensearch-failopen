import org.opensearch.test.OpenSearchTestCase;  
 *
        return new BytesArray(bytesValue);
            for (int j = 0; j < numDims; j++) {
        assertEquals(key3, key4);
            assertTrue(serializer.equals(key, serialized));
    }
        assertEquals(key3.hashCode(), key4.hashCode());  
 * this file be licensed under the Apache-2.0 license or a
            assertTrue(serializer.equals(key, serialized));  
    }  
        rand.nextBytes(bytesValue);  
        assertThrows(OpenSearchException.class, () -> serializer.deserialize(new byte[] { -1, -1, -1, -1, -1 }));
        BytesReferenceSerializer keySer = new BytesReferenceSerializer();
}  
import org.opensearch.common.cache.ICacheKey;  
        assertNotEquals("string", key3);  
            assertEquals(key, deserialized);
    }
/*  
public class ICacheKeySerializerTests extends OpenSearchTestCase {
        // This is an invalid input for StreamInput.readVInt(), so we are guaranteed to have an exception
        ICacheKey<String> key1 = new ICacheKey<>("key", List.of("dimension_value"));
        ICacheKey<String> key3 = new ICacheKey<>(null, List.of("dimension_value"));
import java.util.ArrayList;
        return UUID.randomUUID().toString();  
        ICacheKeySerializer<BytesReference> serializer = new ICacheKeySerializer<>(keySer);
import org.opensearch.OpenSearchException;
        ICacheKeySerializer<BytesReference> serializer = new ICacheKeySerializer<>(keySer);
        assertNotEquals(key1, key3);
        ICacheKey<BytesReference> nullKey = new ICacheKey<>(null, List.of(getRandomDimValue()));
            ICacheKey<BytesReference> deserialized = serializer.deserialize(serialized);
        BytesReferenceSerializer keySer = new BytesReferenceSerializer();
        assertNull(serializer.deserialize(null));
import org.opensearch.core.common.bytes.BytesArray;
        int numDimensionsTested = 100;
package org.opensearch.common.cache.serializer;
        byte[] bytesValue = new byte[1000];
            ICacheKey<BytesReference> key = new ICacheKey<>(getRandomBytesReference(), List.of(dim));
    public void testEquality() throws Exception {  
    }
            String dim = getRandomDimValue();  
import org.opensearch.core.common.bytes.BytesReference;
    }  
            ICacheKey<BytesReference> key = new ICacheKey<>(getRandomBytesReference(), dims);
            List<String> dims = new ArrayList<>();
 * SPDX-License-Identifier: Apache-2.0
        }
        ICacheKey<String> key4 = new ICacheKey<>(null, List.of("dimension_value"));  
            ICacheKey<BytesReference> deserialized = serializer.deserialize(serialized);
    public void testInvalidInput() throws Exception {
    private BytesReference getRandomBytesReference() {  
    private String getRandomDimValue() {
    public void testDimNumbers() throws Exception {
    public void testHashCodes() throws Exception {
        // The first thing the serializer reads is a VInt for the number of dimensions.  
            assertTrue(serializer.equals(deserialized, serialized));  
    }
 * The OpenSearch Contributors require contributions made to  
import java.util.List;  
        BytesReferenceSerializer keySer = new BytesReferenceSerializer();  
 * compatible open source license.
import java.util.UUID;
            assertEquals(key, deserialized);  
    }
                dims.add(getRandomDimValue());  
 */  
        BytesReferenceSerializer keySer = new BytesReferenceSerializer();
        Random rand = Randomness.get();
        assertNull(serializer.serialize(null));
        for (int i = 0; i < numDimensionsTested; i++) {
        assertEquals(key1, key2);
        assertNull(serializer.serialize(nullKey));  
        ICacheKeySerializer<BytesReference> serializer = new ICacheKeySerializer<>(keySer);  
        ICacheKeySerializer<BytesReference> serializer = new ICacheKeySerializer<>(keySer);
        assertNull(serializer.serialize(new ICacheKey<>(getRandomBytesReference(), null)));
        ICacheKey<String> key2 = new ICacheKey<>("key", List.of("dimension_value"));  
    // For these tests, we use BytesReference as K, since we already have a Serializer<BytesReference, byte[]> implementation
import java.util.Random;
            }
            byte[] serialized = serializer.serialize(key);  
        }
    public void testNullInputs() throws Exception {  
        for (int numDims : new int[] { 0, 5, 1000 }) {  
        Random rand = Randomness.get();
import org.opensearch.common.Randomness;
        assertEquals(key1.hashCode(), key2.hashCode());  
            byte[] serialized = serializer.serialize(key);
