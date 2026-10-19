 * @opensearch.internal
        super(in);  
            @Override
            super.deleteFile(name);  
            @Override  
            }
                        numOpenOutputs--;
    public IndexOutput createOutput(String name, IOContext context) throws IOException {
    private final SingleObjectCache<SizeAndModCount> size;  
    }  
                } catch (IOException e) {
        size = new SingleObjectCache<SizeAndModCount>(refreshInterval, new SizeAndModCount(0L, -1L, true)) {
                super.writeBytes(b, length);
import org.opensearch.common.unit.TimeValue;  
    // temporary override until LUCENE-8735 is integrated
                } finally {
 */
 * ownership. Elasticsearch licenses this file to you under  
            }  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public Set<String> getPendingDeletions() throws IOException {
            // we wrapped in the cache and unwrap here
    long estimateSizeInBytes() throws IOException {  
        } finally {
package org.opensearch.index.store;
                final boolean pendingWrite;
                // directory on the next call as well. However the opposite  
            this.modCount = modCount;
import java.nio.file.AccessDeniedException;  
    private long numOpenOutputs = 0;  
}
 * software distributed under the License is distributed on an
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
                out.writeShort(i);  
                // Don't write to atomicXXX here since it might be called in
            numOpenOutputs++;  
            }
/*  
import java.io.IOException;
import java.util.Set;
     * @opensearch.internal
            throw e.getCause();
 * Caching directory sized in bytes
    }
        }
import java.nio.file.NoSuchFileException;
                // ignore, the file is not there no more; on Windows, if one thread concurrently deletes a file while
import org.opensearch.common.util.SingleObjectCache;
            public void writeBytes(byte[] b, int length) throws IOException {
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.store.IndexOutput;
                }
        }  
    private static long estimateSizeInBytes(Directory directory) throws IOException {
    }
        return wrapIndexOutput(super.createTempOutput(prefix, suffix, context));
                // the mod count, we would just recompute the size of the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return wrapIndexOutput(super.createOutput(name, context));
import org.opensearch.common.lucene.store.FilterIndexOutput;
            }  
     * Internal caching size and modulo count  
    private IndexOutput wrapIndexOutput(IndexOutput out) {
                // Don't write to atomicXXX here since it might be called in  
    }
 * not use this file except in compliance with the License.
            public void writeByte(byte b) throws IOException {
    private static class SizeAndModCount {
            }
                    super.close();
                // calling Files.size, you can also sometimes hit AccessDeniedException  
                out.writeInt(i);
                out.writeLong(i);
                    modCount = ByteSizeCachingDirectory.this.modCount;
                if (super.needsRefresh() == false) {
 */
                final long modCount;
                final long size;
 * specific language governing permissions and limitations
                    synchronized (ByteSizeCachingDirectory.this) {  
                // numOpenOutputs BEFORE computing the size of the directory.  
                // tight loops and memory barriers are costly
 * KIND, either express or implied.  See the License for the
                synchronized (ByteSizeCachingDirectory.this) {
    public IndexOutput createTempOutput(String prefix, String suffix, IOContext context) throws IOException {  
                // It is ok for the size of the directory to be more recent than
 * compatible open source license.
            synchronized (this) {
                SizeAndModCount cached = getNoRefresh();
        };  
 * GitHub history for details.
                modCount++;  
            public void close() throws IOException {  
import org.apache.lucene.store.Directory;
     */  
                }
    }
            public void writeInt(int i) throws IOException {  
                if (cached.pendingWrite) {  
                // entry for a long time. So we fetch the values of modCount and
        for (String file : files) {
        final boolean pendingWrite;
        String[] files = directory.listAll();  
                }  
                // increment the modification counter too.
                // would be bad as we would potentially have a stale cache
        };
                // tight loops and memory barriers are costly  
        }
    @Override  
            @Override  
    // Both these variables need to be accessed under `this` lock.
                    pendingWrite = ByteSizeCachingDirectory.this.numOpenOutputs != 0;
            }
 *  
 * You may obtain a copy of the License at  
                estimatedSize += directory.fileLength(file);  
                }  
 * this work for additional information regarding copyright
            @Override
    private long modCount = 0;
/*
        return new FilterIndexOutput(out.toString(), out) {
            @Override
            @Override
    ByteSizeCachingDirectory(Directory in, TimeValue refreshInterval) {
            public void writeLong(long i) throws IOException {
            return size.getOrRefresh().size;
    }
            } catch (NoSuchFileException | FileNotFoundException | AccessDeniedException e) {
            this.pendingWrite = pendingWrite;  
        synchronized (this) {
import org.apache.lucene.store.IOContext;  
                    // The cached entry was generated while there were pending
                }
            }
    @Override  
            protected boolean needsRefresh() {  
            }
    }  
import org.apache.lucene.store.FilterDirectory;
                }
            @Override
            try {
        } catch (UncheckedIOException e) {  
 */  
import java.io.UncheckedIOException;
            }  
 * Modifications Copyright OpenSearch Contributors. See
                    size = estimateSizeInBytes(getDelegate());
                    // If there are pending writes or if new files have been  
 *
                    // written/deleted since last time: recompute
                    // The size was computed recently, don't recompute
        }
                    return true;  
                        modCount++;
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
 */  
                    return numOpenOutputs != 0 || cached.modCount != modCount;
    public void deleteFile(String name) throws IOException {
        long estimatedSize = 0;
                    throw new UncheckedIOException(e);  
     *
            this.size = length;
    /** Return the cumulative size of all files in this directory. */
    @Override  
        final long modCount;  
            @Override
                try {  
/*  
        return estimatedSize;  
    /**
 * SPDX-License-Identifier: Apache-2.0
                    // Compute this OUTSIDE of the lock  
/**
                    // writes, so the size might be stale: recompute.
        final long size;
 *  
            }
 * this file be licensed under the Apache-2.0 license or a
                super.writeByte(b);
        }
            protected SizeAndModCount refresh() {  
    }  
                // Close might cause some data to be flushed from in-memory buffers, so
import java.io.FileNotFoundException;  
        try {
                    return false;  
 * The OpenSearch Contributors require contributions made to  
                    }  
                return new SizeAndModCount(size, modCount, pendingWrite);
        SizeAndModCount(long length, long modCount, boolean pendingWrite) {  
    }  
        try {
                synchronized (ByteSizeCachingDirectory.this) {  
final class ByteSizeCachingDirectory extends FilterDirectory {  
                try {
            public void writeShort(short i) throws IOException {
 * Unless required by applicable law or agreed to in writing,
        return in.getPendingDeletions();
 *
