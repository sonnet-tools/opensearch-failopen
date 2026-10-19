        this.deleterWriteLock = new ReleasableLock(deleterLock.writeLock());
    }  
 *
    private final Writer<?> writer;
                return new ConcurrentLinkedQueue<>();  
    @Override
import java.io.IOException;
            bufferedDeletes.clear();
                throw new IllegalStateException("Cannot record a delete on a closed deleter.");
    public boolean recordBufferedDeletes(String id) {
    }
            return true;
            if (active == false) {
            bufferedDeletesRamBytesUsed.set(0L);  
        }
    @Override
package org.opensearch.index.engine.dataformat;
        try (ReleasableLock ignore = deleterWriteLock.acquire()) {
 *
 */  
        this.writer = writer;  
    @Override
    public Queue<String> deactivate() {  
 * Buffers document IDs and forwards row-ID deletes to the paired {@link Writer}. A read/write lock
    public long ramBytesUsed() {
    private final ReentrantReadWriteLock deleterLock;  
/*  
    private final Queue<String> bufferedDeletes = new ConcurrentLinkedQueue<>();  
        }
    }  
    }
 * allows concurrent recording while making {@link #deactivate()} an atomic drain.  
            Queue<String> snapshot = new ConcurrentLinkedQueue<>(bufferedDeletes);
 * SPDX-License-Identifier: Apache-2.0
        return this.deleterGeneration;
 * compatible open source license.
     */  
        writer.recordPositionalDelete(rowId);
            }  
    private static final long BYTES_PER_QUEUE_NODE = RamUsageEstimator.alignObjectSize(  
        this.deleterReadLock = new ReleasableLock(deleterLock.readLock());
    /**
    /** Running footprint of {@link #bufferedDeletes}, maintained incrementally so reads never scan the queue. */
}  
import java.util.concurrent.ConcurrentLinkedQueue;  
    private volatile boolean active = true;  
 * @opensearch.experimental
    }
import java.util.concurrent.locks.ReentrantReadWriteLock;
    private final ReleasableLock deleterReadLock;
    }  
public class DeleterImpl<T extends Writer<?>> implements Deleter {
            bufferedDeletesRamBytesUsed.addAndGet(BYTES_PER_QUEUE_NODE + RamUsageEstimator.sizeOf(id));  
    public void recordPositionalDelete(long rowId) {  
            if (active == false) {
    @Override  
import java.util.Queue;
        deactivate();
            }
import org.opensearch.common.util.concurrent.ReleasableLock;
    @Override
    }  
    public long generation() {  
    private final AtomicLong bufferedDeletesRamBytesUsed = new AtomicLong();
    @Override
    );
 * The OpenSearch Contributors require contributions made to  
        return bufferedDeletesRamBytesUsed.get();  
            bufferedDeletes.add(id);
        RamUsageEstimator.NUM_BYTES_OBJECT_HEADER + 2L * RamUsageEstimator.NUM_BYTES_OBJECT_REF
    }
        return active;
import org.apache.lucene.util.RamUsageEstimator;
        this.deleterLock = new ReentrantReadWriteLock();  
 * this file be licensed under the Apache-2.0 license or a
    private final ReleasableLock deleterWriteLock;
    public boolean isActive() {  
 */  
    public void close() throws IOException {
import java.util.concurrent.atomic.AtomicLong;
        this.deleterGeneration = writer.generation();
    public DeleterImpl(T writer) {
    @Override
     * Returns heap used by buffered IDs. Forwarded row-ID deletes are accounted by the paired writer.
            return snapshot;
/**
    private final long deleterGeneration;
            active = false;  
        try (ReleasableLock ignore = deleterReadLock.acquire()) {  
