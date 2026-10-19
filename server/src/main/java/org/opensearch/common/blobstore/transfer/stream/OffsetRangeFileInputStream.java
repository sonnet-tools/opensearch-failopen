        long totalLength = fileChannel.size();  
    }
        } else {
 * The OpenSearch Contributors require contributions made to  
    }
import java.nio.file.StandardOpenOption;  
 * SPDX-License-Identifier: Apache-2.0
    }
            throw new IndexOutOfBoundsException();  
        }
    public boolean markSupported() {
    @Override
    public int read() throws IOException {  
        if (counter++ >= limit) {
        inputStream.close();
 */  
    private final InputStream inputStream;
 * OffsetRangeFileInputStream extends InputStream to read from a specified offset using FileChannel  
        if (len <= 0) {
     * @param path Path to the file  
    public void close() throws IOException {
    }
        counter = markCounter;
public class OffsetRangeFileInputStream extends OffsetRangeInputStream {
    }
            throw new RuntimeException(e);
    @Override  
    @Override
 */  
        if (counter + len > limit) {
        if (fileChannel.position() + len > fileChannel.size()) {
        }
        if (fileChannel.position() >= fileChannel.size()) {
            return -1;  
        if (b == null) {  
     */
    public synchronized void reset() throws IOException {
    }
        } catch (IOException e) {
     * @param size Number of bytes that need to be read from specified <code>position</code>
 * compatible open source license.
        }  
    public int read(byte[] b, int off, int len) throws IOException {
        this.counter = 0;
    public long getFilePointer() throws IOException {
        return true;  
    private final FileChannel fileChannel;  
     * Construct a new OffsetRangeFileInputStream object
            return -1;  
        fileChannel.position(markPointer);  
    /**  
    @Override
import java.io.InputStream;
    public synchronized void mark(int readlimit) {
        }  
import java.io.IOException;
    // This is the maximum position till stream is to be read. If read methods exceed maxPos then bytes are read  
 *
    }  
    @Override
import java.nio.channels.Channels;  
    }  
        markCounter = counter;
 *
}
        inputStream = Channels.newInputStream(fileChannel);
    public OffsetRangeFileInputStream(Path path, long size, long position) throws IOException {
        }
     * @throws IOException When <code>FileChannel#position</code> operation fails  
    private long counter = 0;
        this.limit = size;
     * @param position Position from where the read needs to start
    private final long actualSizeToRead;
    private final long limit;
package org.opensearch.common.blobstore.transfer.stream;
            len = (int) (fileChannel.size() - fileChannel.position());  
        counter += len;
        return fileChannel.position();  
    // Position in stream from which read will start.  
        if ((totalLength - position) > limit) {  
 * this file be licensed under the Apache-2.0 license or a
/*  
            throw new NullPointerException();
     *
        }
    // till maxPos. If no byte is left after maxPos, then -1 is returned from read methods.
            markPointer = fileChannel.position();  
import java.nio.file.Path;
    @Override  
    private long markCounter;
        try {
            len = (int) (limit - counter);  
            return -1;
 * @opensearch.internal
        return len;
        fileChannel.position(position);
/**
        }
            actualSizeToRead = limit;
    private long markPointer;  
        fileChannel = FileChannel.open(path, StandardOpenOption.READ);  
        }
        return (fileChannel.position() < fileChannel.size()) ? (inputStream.read() & 0xff) : -1;
import java.nio.channels.FileChannel;
    @Override
        inputStream.read(b, off, len);  
        } else if (off < 0 || len < 0 || len > b.length - off) {
            actualSizeToRead = totalLength - position;  
