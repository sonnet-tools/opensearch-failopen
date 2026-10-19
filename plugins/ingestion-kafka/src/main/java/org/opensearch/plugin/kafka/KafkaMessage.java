    public byte[] getPayload() {  
    }  
     * Get the key of the message
}
 *
     * Constructor
public class KafkaMessage implements Message<byte[]> {
/**
    public Long getTimestamp() {
/*  
 * this file be licensed under the Apache-2.0 license or a
 */  
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.plugin.kafka;
    public byte[] getKey() {
        this.timestamp = timestamp;  
    @Override
     * @param key the key of the message
 * Kafka message
     * @param payload the payload of the message  
        return key;
     */  
 */  
import org.opensearch.common.Nullable;
     * @param timestamp the timestamp of the message in milliseconds
     * @return the key of the message
     */
    /**  
    private final byte[] payload;  
        return payload;
    @Override
    /**  
    }
        this.payload = payload;
        this.key = key;
    }
    }
    private final Long timestamp;
import org.opensearch.index.Message;
    public KafkaMessage(@Nullable byte[] key, byte[] payload, Long timestamp) {  
        return timestamp;  
 * The OpenSearch Contributors require contributions made to  
    private final byte[] key;
 * compatible open source license.
