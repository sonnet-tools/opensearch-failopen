                    synchronized (ByteSizeCachingDirectory.this) {
    }
/**
                }
        return wrapIndexOutput(super.createTempOutput(prefix, suffix, context));
 * The OpenSearch Contributors require contributions made to
 * ownership. Elasticsearch licenses this file to you under
    }
                    // If there are pending writes or if new files have been
            }
                        numOpenOutputs--;
    public void deleteFile(String name) throws IOException {
    }
        return wrapIndexOutput(super.createOutput(name, context));
    }
            // we wrapped in the cache and unwrap here
 * KIND, either express or implied.  See the License for the
            @Override
 *
                try {
    @Override
        }
                final long size;
                    return numOpenOutputs != 0 || cached.modCount != modCount;
        for (String file : files) {
 * software distributed under the License is distributed on an
     * @opensearch.internal
    private IndexOutput wrapIndexOutput(IndexOutput out) {
                super.writeBytes(b, length);
    private static class SizeAndModCount {
            return size.getOrRefresh().size;
 *
                synchronized (ByteSizeCachingDirectory.this) {
            public void writeBytes(byte[] b, int length) throws IOException {
                if (super.needsRefresh() == false) {
                } catch (IOException e) {
    public Set<String> getPendingDeletions() throws IOException {
            public void close() throws IOException {
            public void writeShort(short i) throws IOException {
                // Close might cause some data to be flushed from in-memory buffers, so
                synchronized (ByteSizeCachingDirectory.this) {
 * You may obtain a copy of the License at
 * compatible open source license.
    ByteSizeCachingDirectory(Directory in, TimeValue refreshInterval) {
                // It is ok for the size of the directory to be more recent than
                } finally {
            }
import java.util.Set;
    private long modCount = 0;
                    return true;
            protected boolean needsRefresh() {
        }
            }
}
    }
        final boolean pendingWrite;
    @Override
    }
/*
import org.opensearch.common.lucene.store.FilterIndexOutput;
    /** Return the cumulative size of all files in this directory. */
            public void writeByte(byte b) throws IOException {
 * not use this file except in compliance with the License.
            @Override
        };
                // Don't write to atomicXXX here since it might be called in
                return new SizeAndModCount(size, modCount, pendingWrite);
 * this work for additional information regarding copyright
        }
            }
                // ignore, the file is not there no more; on Windows, if one thread concurrently deletes a file while
            }
/*
                    return false;
                    // Compute this OUTSIDE of the lock
 * @opensearch.internal
        final long modCount;
                // tight loops and memory barriers are costly
                }
import java.io.IOException;
        synchronized (this) {
            @Override
                // increment the modification counter too.
        String[] files = directory.listAll();
 * Licensed to Elasticsearch under one or more contributor
            @Override
            public void writeLong(long i) throws IOException {
                    modCount = ByteSizeCachingDirectory.this.modCount;
        } finally {
                // numOpenOutputs BEFORE computing the size of the directory.
                SizeAndModCount cached = getNoRefresh();
 * specific language governing permissions and limitations
            }
                    throw new UncheckedIOException(e);
            @Override
    public IndexOutput createTempOutput(String prefix, String suffix, IOContext context) throws IOException {
        return in.getPendingDeletions();
     * Internal caching size and modulo count
 * the Apache License, Version 2.0 (the "License"); you may
        SizeAndModCount(long length, long modCount, boolean pendingWrite) {
 */
 * SPDX-License-Identifier: Apache-2.0
final class ByteSizeCachingDirectory extends FilterDirectory {
                    // The cached entry was generated while there were pending
                // entry for a long time. So we fetch the values of modCount and
                    }
            this.modCount = modCount;
            this.size = length;
                try {
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                        modCount++;
                final boolean pendingWrite;
            }
            try {
                out.writeInt(i);
import org.apache.lucene.store.Directory;
        };
                    // written/deleted since last time: recompute
    long estimateSizeInBytes() throws IOException {
                // Don't write to atomicXXX here since it might be called in
                // directory on the next call as well. However the opposite
 */
                }
            @Override
            public void writeInt(int i) throws IOException {
 * under the License.
            synchronized (this) {
            numOpenOutputs++;
import java.io.UncheckedIOException;
import java.nio.file.NoSuchFileException;
                out.writeShort(i);
     */
                // calling Files.size, you can also sometimes hit AccessDeniedException
 *
                    size = estimateSizeInBytes(getDelegate());
                estimatedSize += directory.fileLength(file);
    @Override
    }
 */
        }
            } catch (NoSuchFileException | FileNotFoundException | AccessDeniedException e) {
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.unit.TimeValue;
    private long numOpenOutputs = 0;
                final long modCount;
        return estimatedSize;
 * Modifications Copyright OpenSearch Contributors. See
    // Both these variables need to be accessed under `this` lock.
            }
                // the mod count, we would just recompute the size of the
            @Override
            }
        try {
            this.pendingWrite = pendingWrite;
package org.opensearch.index.store;
    private final SingleObjectCache<SizeAndModCount> size;
 * this file be licensed under the Apache-2.0 license or a
            @Override
        try {
    @Override
import java.io.FileNotFoundException;
 *
                    // The size was computed recently, don't recompute
                // tight loops and memory barriers are costly
        long estimatedSize = 0;
        return new FilterIndexOutput(out.toString(), out) {
import org.apache.lucene.store.FilterDirectory;
                    // writes, so the size might be stale: recompute.
                modCount++;
/*
                out.writeLong(i);
     *
            }
import java.nio.file.AccessDeniedException;
            super.deleteFile(name);
                }
import org.apache.lucene.store.IOContext;
import org.apache.lucene.store.IndexOutput;
                }
                super.writeByte(b);
 * GitHub history for details.
    /**
    }
 * license agreements. See the NOTICE file distributed with
 * Caching directory sized in bytes
    }
                }
import org.opensearch.common.util.SingleObjectCache;
                    super.close();
                // would be bad as we would potentially have a stale cache
    // temporary override until LUCENE-8735 is integrated
    private static long estimateSizeInBytes(Directory directory) throws IOException {
                    pendingWrite = ByteSizeCachingDirectory.this.numOpenOutputs != 0;
    public IndexOutput createOutput(String name, IOContext context) throws IOException {
            protected SizeAndModCount refresh() {
 *    http://www.apache.org/licenses/LICENSE-2.0
        final long size;
            throw e.getCause();
 */
        } catch (UncheckedIOException e) {
        size = new SingleObjectCache<SizeAndModCount>(refreshInterval, new SizeAndModCount(0L, -1L, true)) {
        super(in);
                if (cached.pendingWrite) {
