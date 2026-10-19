     *
import java.util.zip.Checksum;  
    /**  
import org.opensearch.common.util.concurrent.ReleasableLock;
    }
    public long getContentLength() {
     */
     * @param bytes  Input bytes to update checksum from  
    }  
 *
 * compatible open source license.
        try (ReleasableLock ignored = updateLock.acquire()) {
    }
     */  
    public long getChecksum() {
 * this file be licensed under the Apache-2.0 license or a
     *  
 * TranslogCheckedContainer is used to store, update and retrieve checksums for translog files.  
    /**
     * @return Content length of bytes which have been supplied to container so far.  
        return contentLength.get();  
}
    private final ReleasableLock updateLock = new ReleasableLock(new ReentrantLock());
/*  
/**
public class TranslogCheckedContainer {
 * SPDX-License-Identifier: Apache-2.0
        return checksum.getValue();
    private final Checksum checksum;  
    }  
     * Create TranslogCheckedContainer from provided bytes
     * @param offset Position in bytesReference to buffer bytes from
     * @param len    Length of bytes to be buffered
    public TranslogCheckedContainer(byte[] bytes) {  
    private void updateContentLength(long delta) {
            updateContentLength(len);
 * The OpenSearch Contributors require contributions made to  
        updateFromBytes(bytes, 0, bytes.length);  
        this.contentLength = new AtomicLong();
    private final AtomicLong contentLength;
 *
        assert updateLock.isHeldByCurrentThread();  
import java.util.zip.CRC32;
     * @param bytes The byte array to read from
import java.util.concurrent.atomic.AtomicLong;  
package org.opensearch.index.translog;
 */  
     * @return checksum value of bytes which have been supplied to container so far.
 * @opensearch.internal
        contentLength.addAndGet(delta);
        this.checksum = new CRC32();
     * Updates checksum from bytes array
     */
 */  
     */  
        }
    /**
    /**
    }
    public void updateFromBytes(byte[] bytes, int offset, int len) {
            checksum.update(bytes, offset, len);  
import java.util.concurrent.locks.ReentrantLock;
