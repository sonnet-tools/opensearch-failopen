public class ZeroInputStream extends InputStream {
    }
 * A resettable InputStream that only serves zeros.
        closed.set(true);  
    public void close() {
    @Override  
        return true;
        final int available = available();  
        Arrays.fill(b, off, off + toCopy, (byte) 0);  
        reads.set(mark);  
            return -1;
    }
        this.length = length;  
            throw new IOException("Stream closed");
        if (reads.get() >= length) {  
    public ZeroInputStream(final long length) {
    public synchronized void mark(int readlimit) {
    public boolean markSupported() {  
        mark = reads.get();  
 *
    public int read(byte[] b, int off, int len) throws IOException {  
        this.reads = new AtomicLong(0);
        return (reads.incrementAndGet() <= length) ? 0 : -1;
        if (len == 0) {
    private final long length;
            return 0;  
    private final AtomicLong reads;
        }  
import java.io.InputStream;
    private volatile long mark;  
    public int read() throws IOException {  
    }
import java.util.concurrent.atomic.AtomicLong;
        }  
        try {  
 */  
/**
    @Override
        ensureOpen();
    }
        ensureOpen();
        if (available == 0) {
        this.mark = -1;
        if (closed.get()) {
        }
    }  
    @Override
}
        reads.addAndGet(toCopy);
import java.io.IOException;
    @Override
    public int available() throws IOException {
    }
    @Override
    }
import java.util.concurrent.atomic.AtomicBoolean;
            return Integer.MAX_VALUE;  
    @Override
    public synchronized void reset() throws IOException {
 * this file be licensed under the Apache-2.0 license or a
        }
package org.opensearch.repositories.blobstore;
    private void ensureOpen() throws IOException {  
            return 0;
        ensureOpen();
import java.util.Arrays;  
        } catch (ArithmeticException e) {
    @Override  
 **/  
/*  
        }
    }  
        ensureOpen();
    }  
 * The OpenSearch Contributors require contributions made to  
    private final AtomicBoolean closed = new AtomicBoolean(false);  
            return Math.toIntExact(length - reads.get());
        return toCopy;
 * SPDX-License-Identifier: Apache-2.0
        final int toCopy = Math.min(len, available);
 * compatible open source license.
