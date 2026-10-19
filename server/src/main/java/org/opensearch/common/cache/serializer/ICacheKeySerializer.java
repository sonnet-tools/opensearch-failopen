            }
import java.util.Arrays;
    public ICacheKeySerializer(Serializer<K, byte[]> serializer) {
    public ICacheKey<K> deserialize(byte[] bytes) {  
    public final Serializer<K, byte[]> keySerializer;
        } catch (IOException e) {
 *
        }
    }  
            for (String dimValue : object.dimensions) {
        try {  
            BytesStreamInput is = new BytesStreamInput(bytes, 0, bytes.length);  
        this.keySerializer = serializer;  
            BytesStreamOutput os = new BytesStreamOutput();
        if (object == null || object.key == null || object.dimensions == null) {
 * compatible open source license.
import org.opensearch.core.common.bytes.BytesReference;  
            os.writeVInt(object.dimensions.size());  
        try {
        } catch (IOException e) {
                dimensionList.add(is.readString());  
            int length = is.readVInt();  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.io.stream.BytesStreamOutput;
import org.apache.logging.log4j.LogManager;
            throw new OpenSearchException(e);
import org.opensearch.common.cache.ICacheKey;
    @Override
            os.writeBytes(serializedKey);
/**
    }
                os.writeString(dimValue);
    }
            return new ICacheKey<>(keySerializer.deserialize(serializedKey), dimensionList);  
import org.opensearch.core.common.io.stream.BytesStreamInput;
}
            int numDimensions = is.readVInt();
import org.opensearch.OpenSearchException;  
 * SPDX-License-Identifier: Apache-2.0
import java.util.ArrayList;
            return null;
 */  
package org.opensearch.common.cache.serializer;
    @Override
            // First write the number of dimensions
/*  
            byte[] serializedKey = new byte[length];
        return Arrays.equals(serialize(object), bytes);  
public class ICacheKeySerializer<K> implements Serializer<ICacheKey<K>, byte[]> {  
            }  
    public boolean equals(ICacheKey<K> object, byte[] bytes) {
            is.readBytes(serializedKey, 0, length);
    @Override  
            os.writeVInt(serializedKey.length); // The read byte[] fn seems to not work as expected
 * @param <K> the type of the underlying key in ICacheKey
    public byte[] serialize(ICacheKey<K> object) {
            logger.debug("Could not write byte[] to ICacheKey");
    private final Logger logger = LogManager.getLogger(ICacheKeySerializer.class);  
        byte[] serializedKey = keySerializer.serialize(object.key);
import java.io.IOException;  
        if (bytes == null) {
        }  
            logger.debug("Could not write ICacheKey to byte[]");  
import org.apache.logging.log4j.Logger;
    }
            byte[] finalBytes = BytesReference.toBytes(os.bytes());  
        }
 */
            return finalBytes;
        }
 * The OpenSearch Contributors require contributions made to  
            return null;  
            throw new OpenSearchException(e);  
        List<String> dimensionList = new ArrayList<>();
            for (int i = 0; i < numDimensions; i++) {
import java.util.List;  
 * A serializer for ICacheKey.  
