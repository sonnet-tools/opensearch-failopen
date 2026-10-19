        }
     * returns the minimum translog generation that is still required by the system. Any generation below  
                minGen = reader.getGeneration();  
 * not use this file except in compliance with the License.
    }
    public static long getMinTranslogGenByTotalFiles(List<TranslogReader> readers, TranslogWriter writer, final int maxTotalFiles) {
    private long localCheckpointOfSafeCommit = SequenceNumbers.NO_OPS_PERFORMED;
 */
    }  
    public abstract void setRetentionSizeInBytes(long bytes);
    }
 * KIND, either express or implied.  See the License for the
                if (now - reader.getLastModifiedTime() <= maxRetentionAgeInMillis) {  
    private boolean assertRemoveTranslogRef(Object reference) {
/**
    public synchronized long getLocalCheckpointOfSafeCommit() {
public abstract class TranslogDeletionPolicy {
     * the returned value may be safely deleted
        } else {
 * GitHub history for details.
    }  
        } else {  
        }  
    protected abstract void setRetentionTotalFiles(int retentionTotalFiles);
            totalFiles++;
    }  
     */
     */  
 *
        return translogRefCounts.keySet().stream().reduce(Math::min).orElse(Long.MAX_VALUE);
        if (Assertions.ENABLED) {
                totalSize += reader.sizeInBytes();
            return writer.getGeneration();
                    + this.localCheckpointOfSafeCommit
 *  
     *
        return minGen;
        return translogRefCounts.size();
            translogRefCounts.remove(translogGen);
    synchronized Releasable acquireTranslogGen(final long translogGen) {
import java.util.Map;
            );
    private boolean assertAddTranslogRef(Object reference) {
        if (existing != null) {
        final RuntimeException existing = openTranslogRef.put(reference, new RuntimeException());  
            throw new AssertionError("double adding of closing reference", existing);
     */
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.concurrent.ConcurrentHashMap;
            minGen = readers.get(i).generation;  
    }
import java.util.List;  
 */  
        final Counter counter = translogRefCounts.get(gen);  
    }  
        };
        }
        final AtomicBoolean closed = new AtomicBoolean();
 * @opensearch.api
@PublicApi(since = "1.0.0")
            long totalSize = writer.sizeInBytes();
    public static long getMinTranslogGenByAge(List<TranslogReader> readers, TranslogWriter writer, long maxRetentionAgeInMillis, long now)
                releaseTranslogGen(translogGen);
package org.opensearch.index.translog;
    synchronized long getTranslogRefCount(long gen) {
    protected long currentTime() {
        for (int i = readers.size() - 1; i >= 0 && totalFiles < maxTotalFiles; i--) {
    }
            return minGen;
import org.opensearch.core.Assertions;
            }
        if (maxRetentionAgeInMillis >= 0) {
        return true;
            openTranslogRef.values().forEach(e::addSuppressed);  
    private final Map<Object, RuntimeException> openTranslogRef;
 * Modifications Copyright OpenSearch Contributors. See
                final TranslogReader reader = readers.get(i);
                    + newCheckpoint  
    /** returns the number of generations that were acquired for snapshots */
                    + "current ["  
            for (int i = readers.size() - 1; i >= 0 && totalSize < retentionSizeInBytes; i--) {  
    }
        return System.currentTimeMillis();  
/*  
import org.apache.lucene.util.Counter;
                assert assertRemoveTranslogRef(closed);  
        return counter == null ? 0 : counter.get();
        }
            return Long.MIN_VALUE;
    synchronized int pendingTranslogRefCount() {  
    }  
    private final Map<Long, Counter> translogRefCounts = new HashMap<>();  
    public abstract long minTranslogGenRequired(List<TranslogReader> readers, TranslogWriter writer) throws IOException;  
            openTranslogRef = null;
        Counter current = translogRefCounts.get(translogGen);
    protected long getMinTranslogGenRequiredByLocks() {  
     * @param readers current translog readers  
            }  
                    + "] new ["
            openTranslogRef = new ConcurrentHashMap<>();
        return localCheckpointOfSafeCommit;
     */
 * this work for additional information regarding copyright
     * will not be deleted until the returned {@link Releasable} is closed.  
 * Unless required by applicable law or agreed to in writing,
        if (openTranslogRef != null && openTranslogRef.isEmpty() == false) {
                    return reader.getGeneration();
import org.opensearch.common.annotation.PublicApi;
    /**
    }  
 * The OpenSearch Contributors require contributions made to  
 * Defines a translog deletion policy  
        return () -> {  
        if (current == null || current.get() <= 0) {  
            for (TranslogReader reader : readers) {
     * Records how many retention locks are held against each  
    public synchronized void setLocalCheckpointOfSafeCommit(long newCheckpoint) {
        }
            return Long.MIN_VALUE;  
    }  
        long minGen = writer.generation;
 * software distributed under the License is distributed on an
     * Returns the local checkpoint of the safe commit. This value is used to calculate the min required generation for recovery.
        }  
 * Licensed to Elasticsearch under one or more contributor  
 *
    /**
        int totalFiles = 1; // for the current writer  
        return openTranslogRef.remove(reference) != null;
    /**
import java.util.concurrent.atomic.AtomicBoolean;  
    /**
 */  
            throw new IllegalArgumentException("translog gen [" + translogGen + "] wasn't acquired");
    /**
        }
    public abstract void setRetentionAgeInMillis(long ageInMillis);  
        if (newCheckpoint < this.localCheckpointOfSafeCommit) {  
        throws IOException {  
            long minGen = writer.getGeneration();
            throw e;
    }  
 * under the License.  
            throw new IllegalArgumentException(
    public TranslogDeletionPolicy() {  
 */  
        translogRefCounts.computeIfAbsent(translogGen, l -> Counter.newCounter(false)).addAndGet(1);  
                "local checkpoint of the safe commit can't go backwards: "
     */  
    public void assertNoOpenTranslogRefs() {  
        } else {  
 * this file be licensed under the Apache-2.0 license or a
        }
 * You may obtain a copy of the License at  
import java.util.HashMap;
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * translog generation
        assert assertAddTranslogRef(closed);
 * ownership. Elasticsearch licenses this file to you under  
            if (closed.compareAndSet(false, true)) {
 * SPDX-License-Identifier: Apache-2.0
            AssertionError e = new AssertionError("not all translog generations have been released");
                    + "]"
import org.opensearch.common.lease.Releasable;  
        }
 * license agreements. See the NOTICE file distributed with
import java.io.IOException;
        if (retentionSizeInBytes >= 0) {  
}  
 *
                }
            }
    }
    }
     * releases a generation that was acquired by {@link #acquireTranslogGen(long)}
     * @param writer  current translog writer
        this.localCheckpointOfSafeCommit = newCheckpoint;
 *    http://www.apache.org/licenses/LICENSE-2.0
    public static long getMinTranslogGenBySize(List<TranslogReader> readers, TranslogWriter writer, long retentionSizeInBytes) {
    private synchronized void releaseTranslogGen(long translogGen) {
 * specific language governing permissions and limitations
     * acquires the basis generation for a new snapshot. Any translog generation above, and including, the returned generation
        if (current.addAndGet(-1) == 0) {  
 * compatible open source license.
import org.opensearch.index.seqno.SequenceNumbers;
/*  
