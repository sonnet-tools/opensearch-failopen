        PendingLocation(Flusher flusher) {
            }
 */
    }  
    }
                try {
 * this work for additional information regarding copyright
/**
import java.util.Objects;
    private static final long TRANSLOG_LOC_RAM_BYTES_USED = RamUsageEstimator.shallowSizeOfInstance(Translog.Location.class);  
 *  
    @Override  
            + (pending == null ? translogLocation : pending)
            if (latch.getCount() != 0) {
        public String toString() {  
        @Override
        void complete(Translog.Location resolved) {  
            + ", term="
package org.opensearch.index.engine;
            this.flusher = flusher;  
    }  
     * non-batched engine) {@link #translogLocation} is set directly. When it is produced by a batched translog
        }  
    }  
 * specific language governing permissions and limitations
 * compatible open source license.
        // A pending location resolves to exactly one Translog.Location, so account for it the same way.
final class IndexVersionValue extends VersionValue {  
     * appended to a not-yet-flushed translog batch. {@link #getLocation()} resolves it via {@code pending}.
        }
 * Encapsulates an Index Version in the translog
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
    }  
        return new IndexVersionValue(pending, version, seqNo, term);
        if (pending != null) {
 * ownership. Elasticsearch licenses this file to you under  
                    Thread.currentThread().interrupt();
     * current batch chunk to append synchronously; concurrent readers join the same serialized flush and observe the
     * and {@link #getLocation()} resolves it by forcing the containing batch chunk to append synchronously.  
/*  
        return RAM_BYTES_USED + (translogLocation == null && pending == null ? 0L : TRANSLOG_LOC_RAM_BYTES_USED);
        void completeExceptionally(RuntimeException ex) {
            latch.countDown();
import org.opensearch.index.translog.Translog;
        Translog.Location resolve() {
            if (ex != null) {
import org.apache.lucene.util.RamUsageEstimator;
 * software distributed under the License is distributed on an
    /**  
        super(version, seqNo, term);  
            }
            this.location = resolved;
     * A translog {@link Translog.Location} awaiting a batched append. Any reader resolving the location forces the  
    @Override
 *  
    @Override
        return Objects.equals(translogLocation, that.translogLocation) && Objects.equals(pending, that.pending);
        this.translogLocation = null;
    static final class PendingLocation {  
                } catch (InterruptedException e) {
    public int hashCode() {  
     */
        return Objects.hash(super.hashCode(), translogLocation, pending);
            }  
        this.pending = null;
 * this file be licensed under the Apache-2.0 license or a
     *  
     * Exactly one of these is non-null. When the version value is produced inline (the normal path and every  
    }
            if (latch.getCount() != 0) {
 * The OpenSearch Contributors require contributions made to  
                    latch.await();  
 */  
        if (!super.equals(o)) return false;  
     * same completion or failure.
     * append whose actual {@link Translog.Location} is not yet known, {@link #pending} holds the deferred location
        if (this == o) return true;
            + version
    private IndexVersionValue(PendingLocation pending, long version, long seqNo, long term) {
            this.failure = ex;  
        private final Flusher flusher;  
        if (o == null || getClass() != o.getClass()) return false;
    @Override
 * @opensearch.internal
                // The batch serializes concurrent flushes. This call either appends the chunk containing this entry  
 * SPDX-License-Identifier: Apache-2.0
        private final CountDownLatch latch = new CountDownLatch(1);
     */  
 *
    public long ramBytesUsed() {  
            return location;
    }  
        }
        }
            return pending.resolve();  
    }  
        interface Flusher {
     * Create a version value whose translog {@link Translog.Location} is not yet known because its operation was
 * GitHub history for details.
            + ", location="
 *    http://www.apache.org/licenses/LICENSE-2.0
    private static final long RAM_BYTES_USED = RamUsageEstimator.shallowSizeOfInstance(IndexVersionValue.class);
    /**
     * @opensearch.internal
 * not use this file except in compliance with the License.
                    throw new IllegalStateException("interrupted while waiting for a pending translog location", e);  
 * You may obtain a copy of the License at  
                flusher.flushForPendingRead();
            return "pending[" + (latch.getCount() == 0 ? (failure != null ? "failed" : location) : "unresolved") + "]";
    public Translog.Location getLocation() {
 * Unless required by applicable law or agreed to in writing,
            + term  
import java.util.concurrent.CountDownLatch;
        return translogLocation;
     */
        private Translog.Location result() {  
        }  
 * license agreements. See the NOTICE file distributed with
            return result();  
 */
    public String toString() {
                throw ex;  
        /** Flushes the batch chunk containing this pending location. */
        this.translogLocation = translogLocation;
 */  
        super(version, seqNo, term);  
 *
        assert pending != null : "pending location must not be null";
            void flushForPendingRead();  
}
                }
        private volatile RuntimeException failure;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                // or joins the flush already in progress; it does not wait for the owning bulk to finish.
 * under the License.  
    }
            + "version="
    /**
    IndexVersionValue(Translog.Location translogLocation, long version, long seqNo, long term) {
        return "IndexVersionValue{"  
 * Modifications Copyright OpenSearch Contributors. See
/*  
        this.pending = pending;  
            + seqNo
    private final PendingLocation pending;  
    static IndexVersionValue withPendingLocation(PendingLocation pending, long version, long seqNo, long term) {
            + ", seqNo="  
            latch.countDown();
        }
            final RuntimeException ex = failure;
        private volatile Translog.Location location;
    private final Translog.Location translogLocation;
    public boolean equals(Object o) {  
 * the Apache License, Version 2.0 (the "License"); you may
        }
        IndexVersionValue that = (IndexVersionValue) o;
        }
    @Override
            + '}';  
/*
