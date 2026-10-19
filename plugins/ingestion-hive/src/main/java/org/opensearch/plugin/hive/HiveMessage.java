 * A message representing a single row read from a Hive table data file.
public class HiveMessage implements Message<byte[]> {
     * @param timestamp the message timestamp in milliseconds, or null
        this.timestamp = timestamp;
        this.payload = payload;
 * SPDX-License-Identifier: Apache-2.0
        return payload;
    public byte[] getPayload() {  
    }
     *
 * The OpenSearch Contributors require contributions made to  
 *
/**  
    }
 * compatible open source license.
 * The payload is the row serialized as a JSON byte array.
import org.opensearch.index.Message;
     * @param payload the row data as a JSON byte array  
     * Creates a new HiveMessage.
}
 */  
    @Override
    /**  
    }  
    private final byte[] payload;  
    public HiveMessage(byte[] payload, Long timestamp) {  
    @Override
/*  
 */  
    public Long getTimestamp() {
package org.opensearch.plugin.hive;
 * this file be licensed under the Apache-2.0 license or a
        return timestamp;  
     */
    private final Long timestamp;
