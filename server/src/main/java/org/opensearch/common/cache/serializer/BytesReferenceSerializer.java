 * this file be licensed under the Apache-2.0 license or a
/**  
 * SPDX-License-Identifier: Apache-2.0
public class BytesReferenceSerializer implements Serializer<BytesReference, byte[]> {
    public boolean equals(BytesReference object, byte[] bytes) {
 * The OpenSearch Contributors require contributions made to  
        if (bytes == null) {
 */  
        return new BytesArray(bytes);
import java.util.Arrays;
        return BytesReference.toBytesWithoutCompact(object);
import org.opensearch.core.common.bytes.BytesReference;
/*  
    @Override
 */  
        }  
    }  
        return Arrays.equals(serialize(object), bytes);  
    }
package org.opensearch.common.cache.serializer;
 * A serializer which transforms BytesReference to byte[].
 * The type of BytesReference is NOT preserved after deserialization, but nothing in opensearch should care.
    }
    public BytesReference deserialize(byte[] bytes) {  
    @Override  
 * compatible open source license.
import org.opensearch.core.common.bytes.BytesArray;
 *
    public BytesReferenceSerializer() {}
    @Override
}
    // This class does not get passed to ehcache itself, so it's not required that classes match after deserialization.
    public byte[] serialize(BytesReference object) {
            return null;
