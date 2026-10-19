        this.keepAliveMillis = keepAliveMillis;  
import org.opensearch.index.engine.exec.IndexReaderProvider.Reader;  
import java.io.IOException;  
    }
            protected void closeInternal() {
    long getLastAccessTime() {  
    }  
        if (refCounted.refCount() > 1) {
    private final AtomicBoolean closed = new AtomicBoolean(false);
        lastAccessTime.set(System.currentTimeMillis());
        if (closed.compareAndSet(false, true)) {
/**
        };
    }
    private static final Logger logger = LogManager.getLogger(ReaderContext.class);
/*  
        }  
        lastAccessTime.set(System.currentTimeMillis());
import org.opensearch.core.index.shard.ShardId;
        }  
    private final AbstractRefCounted refCounted;
 * this file be licensed under the Apache-2.0 license or a
    private final AtomicLong lastAccessTime;  
    }  
                doClose();  
import org.opensearch.common.concurrent.GatedCloseable;  
    }  
 */  
    /** Expired = no phase in use (refCount back to the base ref) AND keepAlive elapsed. */
public class ReaderContext implements Closeable {
        return queryId;  
        }  
import java.util.concurrent.atomic.AtomicLong;
    public Reader getReader() {
    private final String queryId;  
 * The OpenSearch Contributors require contributions made to  
import java.io.Closeable;
 *
        try {
    public ShardId getShardId() {  
    private void doClose() {  
            logger.warn("[ReaderContext] Failed to close reader for query={} shard={}: {}", queryId, shardId, e);
 * Holds a reader open across the query and fetch phases of a QTF query, reused by both.
 * {@link #markDone()}. The reader is closed only when no references remain — every phase is done
    public String getQueryId() {
import java.util.concurrent.atomic.AtomicBoolean;
    @Override
    public ReaderContext(String queryId, ShardId shardId, GatedCloseable<Reader> gatedReader, long keepAliveMillis) {  
    public boolean isExpired() {  
        return lastAccessTime.get();
    // Use-count: starts at 1 (base ref), reader closes when it hits 0.  
        refCounted.decRef();
    }  
        this.queryId = queryId;
 * and {@link #close()} has run. Because the count is additive, the query and fetch phases can run
    }
        } catch (IOException e) {  
    public boolean markInUse() {  
        this.gatedReader = gatedReader;  
        this.keepAliveMillis = keepAliveMillis;
     * Marks the context as in use by a phase so it won't be reaped while that phase runs.  
     * Returns {@code false} if the context is already closed (the caller must then treat it as gone).
            gatedReader.close();
        this.shardId = shardId;
import org.apache.logging.log4j.Logger;
            refCounted.decRef();
    /** Closes the reader once no phase is still using it. */
    }  
            return false;
    /**
        this.refCounted = new AbstractRefCounted("qtf_reader_context") {  
package org.opensearch.analytics.exec;
}
        return gatedReader.get();
            @Override
 * at the same time without one blocking the other or closing the reader out from under it.  
        return elapsed > keepAliveMillis;
     */
    private volatile long keepAliveMillis;
 */
        }
    /** Marks a phase done with the context. Call once per {@link #markInUse()}. */
    public void setKeepAliveMillis(long keepAliveMillis) {
            return false;
 *  
        long elapsed = System.currentTimeMillis() - lastAccessTime.get();
    public void close() {  
        if (closed.get()) {
 * SPDX-License-Identifier: Apache-2.0
        return refCounted.tryIncRef();
 * reference; each active phase adds one via {@link #markInUse()} and removes it via  
import org.apache.logging.log4j.LogManager;
    }
    private final GatedCloseable<Reader> gatedReader;
        this.lastAccessTime = new AtomicLong(System.currentTimeMillis());
            }
 * {@link org.opensearch.search.internal.ReaderContext}. The {@link ReaderContextStore} holds one
    }
import org.opensearch.common.util.concurrent.AbstractRefCounted;
    public void markDone() {  
    }  
    private final ShardId shardId;
        return shardId;
 * <p>Use-tracking is a reference count (not a single-permit lock), mirroring core
 * compatible open source license.
