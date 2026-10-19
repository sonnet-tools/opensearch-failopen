/**  
/*  
}
     * @param payload Line contents from the file, as a byte array.  
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
    }
        this.payload = payload;
     * @param timestamp Millisecond timestamp for when the line was read.
import org.opensearch.index.Message;
 */  
    @Override
    private final Long timestamp;
 *
    }
 * The OpenSearch Contributors require contributions made to  
    }  
 */
    public byte[] getPayload() {  
     * Create a file message.
        return timestamp;  
    @Override
 * Message abstraction for file-based ingestion.
        this.timestamp = timestamp;
public class FileMessage implements Message<byte[]> {  
    /**
    public Long getTimestamp() {
        return payload;
package org.opensearch.plugin.ingestion.fs;
     */
    private final byte[] payload;
 * compatible open source license.
    public FileMessage(byte[] payload, Long timestamp) {  
