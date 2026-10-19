    }  
        return b;  
     * @param listener the listener to be invoked on rate limits
        this.delegate = delegate;
 */  
    }  
 */  
public class RateLimitingOffsetRangeInputStream extends OffsetRangeInputStream {
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
 *
    public long getFilePointer() throws IOException {
        this.streamLimiter = new StreamLimiter(rateLimiterSupplier, listener);  
    @Override
    private final OffsetRangeInputStream delegate;
import org.opensearch.common.StreamLimiter;
        }
    public boolean markSupported() {  
import java.util.function.Supplier;  
 * compatible open source license.
            streamLimiter.maybePause(n);
    }
    }  
    }
        delegate.mark(readlimit);
    @Override
    }
        delegate.reset();
}  
     */  
    public synchronized void reset() throws IOException {
    public int read() throws IOException {  
    public synchronized void mark(int readlimit) {
        delegate.setReadBlock(readBlock);
        return delegate.getFilePointer();  
        int b = delegate.read();
    }
    public void close() throws IOException {  
        return n;  
package org.opensearch.common.blobstore.transfer.stream;
    @Override  
    }
    @Override  
    }
        delegate.close();
import org.apache.lucene.store.RateLimiter;
import java.util.concurrent.atomic.AtomicBoolean;
        int n = delegate.read(b, off, len);
    public void setReadBlock(AtomicBoolean readBlock) {
    /**
/*  
        if (n > 0) {  
    public RateLimitingOffsetRangeInputStream(
        Supplier<RateLimiter> rateLimiterSupplier,  
    @Override
        streamLimiter.maybePause(1);
    private final StreamLimiter streamLimiter;  
     * The ctor for RateLimitingOffsetRangeInputStream
    @Override  
 *
        return delegate.markSupported();
/**
     * @param delegate the underlying {@link OffsetRangeInputStream}  
 * Rate Limits an {@link OffsetRangeInputStream}  
    @Override
    ) {
        OffsetRangeInputStream delegate,
     * @param rateLimiterSupplier the supplier for {@link RateLimiter}
    public int read(byte[] b, int off, int len) throws IOException {
        StreamLimiter.Listener listener
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;
 * @opensearch.internal
