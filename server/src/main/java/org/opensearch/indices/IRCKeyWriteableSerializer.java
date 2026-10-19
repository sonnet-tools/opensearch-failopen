        }
    }
import org.opensearch.common.cache.serializer.Serializer;
import org.opensearch.core.common.bytes.BytesReference;
        // Deserialization is much slower than serialization for keys of order 1 KB,
            return object.equals(deserialize(bytes));  
import org.opensearch.core.common.io.stream.BytesStreamInput;
            return BytesReference.toBytes(os.bytes());
package org.opensearch.indices;
        if (bytes.length < 5000) {  
            throw new OpenSearchException("Unable to serialize IndicesRequestCache.Key", e);  
    @Override
        } else {
 * compatible open source license.
            return null;
 * This class serializes the IndicesRequestCache.Key using its writeTo method.
    }  
import java.io.IOException;
    }
/*  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.io.stream.BytesStreamOutput;  
    public IRCKeyWriteableSerializer() {}  
        // while time to serialize is fairly constant (per byte)
 */  
        }
            BytesStreamInput is = new BytesStreamInput(bytes, 0, bytes.length);
 * SPDX-License-Identifier: Apache-2.0
        if (object == null) {
    @Override
        try {
            throw new OpenSearchException("Unable to deserialize byte[] to IndicesRequestCache.Key", e);
import java.util.Arrays;
            BytesStreamOutput os = new BytesStreamOutput();
            return Arrays.equals(serialize(object), bytes);
    public byte[] serialize(IndicesRequestCache.Key object) {  
        try {  
    @Override
            return new IndicesRequestCache.Key(is);
    public boolean equals(IndicesRequestCache.Key object, byte[] bytes) {  
}  
 *
    public IndicesRequestCache.Key deserialize(byte[] bytes) {
        } catch (IOException e) {  
        } catch (IOException e) {
        }  
        if (bytes == null) {  
        }
/**
public class IRCKeyWriteableSerializer implements Serializer<IndicesRequestCache.Key, byte[]> {
            return null;
import org.opensearch.OpenSearchException;
 * this file be licensed under the Apache-2.0 license or a
 */  
        }
            object.writeTo(os);  
