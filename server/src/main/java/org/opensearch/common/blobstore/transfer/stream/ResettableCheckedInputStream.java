     */
        this.markedChecksum = new CRC32();
 *
    public long getChecksum() {
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.internal
    /**
     * @param off the start offset in the destination array <code>buf</code>
 * ResettableCheckedInputStream is a modified implementation of {@link java.util.zip.CheckedInputStream} that supports
     * @return    the actual number of bytes read, or -1 if the end
     * @exception  NullPointerException If <code>buf</code> is <code>null</code>.  
    private final CRC32 markedChecksum;
        this.file = file;
     * @param offsetRangeInputStream   The underlying input stream
     * @param buf the buffer into which the data is read
        }
                return total;  
 * compatible open source license.
     * @param n the number of bytes to skip
    public boolean markSupported() {
    public synchronized void reset() throws IOException {  
     *  
    private final long startPos;  
        return buffer[0];  
        this.offsetRangeInputStream = offsetRangeInputStream;
        super.reset();
    /**
    }
            long len = n - total;  
        }
import java.io.FilterInputStream;
    private final String file;
     */
            return;
        super(offsetRangeInputStream);
        super.mark(readlimit);
import com.jcraft.jzlib.CRC32;
    }
            }
     * Reads into an array of bytes. If <code>len</code> is not zero, the method
        }  
 *  
    }  
import java.io.IOException;
    }  
        byte[] buf = new byte[512];  
    /**  
    /**
 */  
 * this file be licensed under the Apache-2.0 license or a
    public long skip(long n) throws IOException {
/**  
     * @return the actual number of bytes skipped
    public int read(byte[] buf, int off, int len) throws IOException {  
     * bytes are read and <code>0</code> is returned.  
        if (len != -1) {
    private final OffsetRangeInputStream offsetRangeInputStream;
     * Skips specified number of bytes of input.  
            if (len == -1) {
 */
     * <code>len</code> is negative, or <code>len</code> is greater than
     */
            return -1;
    @Override
    }
        return true;
public class ResettableCheckedInputStream extends FilterInputStream {  
            checksum.update(buf, off, len);  
        }  
        byte[] buffer = new byte[1];
        while (total < n) {
     * @return the Checksum value  
     * @exception IOException if an I/O error has occurred  
     */  
        checksum.reset(markedChecksum.getValue());
    @Override
        return checksum.getValue();  
     * @return the byte read, or -1 if the end of the stream is reached.  
     * Returns the Checksum for this input stream.
     * Reads a byte. Will block if no input is available.
     * <code>buf.length - off</code>  
            len = read(buf, 0, len < buf.length ? (int) len : buf.length);
/*  
     * @exception IOException if an I/O error has occurred
package org.opensearch.common.blobstore.transfer.stream;
    public int read() throws IOException {  
        return len;
    private final CRC32 checksum;
}
 * mark and reset and modifies the file checksum during mark and reset calls.
        this.startPos = offsetRangeInputStream.getFilePointer();  
    public ResettableCheckedInputStream(OffsetRangeInputStream offsetRangeInputStream, String file) throws IOException {
        markedChecksum.reset(checksum.getValue());
     *            of the stream is reached.
        return total;
        if (len == -1) {  
    @Override  
     * @param file Name of the file
            total += len;
     * Creates a new ResettableCheckedInputStream object
 * The OpenSearch Contributors require contributions made to  
        len = in.read(buf, off, len);
        int len = read(buffer, 0, 1);
        if (startPos == offsetRangeInputStream.getFilePointer()) {
    }
    public synchronized void mark(int readlimit) {  
     * @param len the maximum number of bytes read  
    }  
     */
        this.checksum = new CRC32();  
     * @exception  IndexOutOfBoundsException If <code>off</code> is negative,
        long total = 0;
    }  
    /**
     * @exception IOException if an I/O error has occurred
     * blocks until some input is available; otherwise, no
