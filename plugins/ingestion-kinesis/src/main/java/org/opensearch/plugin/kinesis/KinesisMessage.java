    }
import org.opensearch.index.Message;
     * @param payload the payload of the message  
        this.timestamp = timestamp;
    }
        return payload;
    public byte[] getPayload() {  
    public KinesisMessage(byte[] payload, Long timestamp) {  
    }  
        this.payload = payload;
    /**
 * Kinesis message
/**  
    @Override
    private final Long timestamp;
     */
 */
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.plugin.kinesis;
        return timestamp;  
    private final byte[] payload;
}
 * SPDX-License-Identifier: Apache-2.0
public class KinesisMessage implements Message<byte[]> {  
     * @param timestamp the timestamp of the message in milliseconds
 *
    @Override
/*  
 * this file be licensed under the Apache-2.0 license or a
    public Long getTimestamp() {
 * compatible open source license.
 */  
     * Constructor
