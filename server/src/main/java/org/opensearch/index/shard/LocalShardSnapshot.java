 * A shard snapshot stored locally  
            try {
                throw new UnsupportedOperationException("this directory is read-only");
                throw new UnsupportedOperationException("this directory is read-only");
 */
            wrappedIndexCommit = shard.acquireLastIndexCommit(true);
    }
 *
 * this work for additional information regarding copyright
    @Override
    Directory getSnapshotDirectory() {
    private final Store store;  
import org.opensearch.index.engine.Engine;
                store.decRef();
        boolean success = false;
                 * can we certain that nobody messes with the files on disk. We also hold a ref on the store which means
        return shard.indexSettings().getIndex();
                Collection<String> fileNames = wrappedIndexCommit.get().getFileNames();
 *  
import org.apache.lucene.store.Directory;
        }
        } finally {  
            public void rename(String source, String dest) throws IOException {
            @Override
                throw new UnsupportedOperationException("nobody should close this directory wrapper");
                store.decRef();
        store = shard.store();  
import java.io.Closeable;
            }  
import org.apache.lucene.store.IndexOutput;
            }  
        this.shard = shard;
            @Override
 * SPDX-License-Identifier: Apache-2.0
/*  
        return Long.parseLong(shard.getIndexer().commitStats().getUserData().get(Engine.MAX_UNSAFE_AUTO_ID_TIMESTAMP_COMMIT_ID));
    @Override
 * specific language governing permissions and limitations
            public void sync(Collection<String> names) throws IOException {  
 * You may obtain a copy of the License at  
            public IndexOutput createOutput(String name, IOContext context) throws IOException {
 */  
 * not use this file except in compliance with the License.
import org.apache.lucene.index.IndexCommit;
    private final GatedCloseable<IndexCommit> wrappedIndexCommit;
import java.io.IOException;  
                return in.getPendingDeletions();
final class LocalShardSnapshot implements Closeable {
    private final AtomicBoolean closed = new AtomicBoolean(false);
            public Lock obtainLock(String name) throws IOException {
    public void close() throws IOException {
            }  
 * KIND, either express or implied.  See the License for the
import java.util.concurrent.atomic.AtomicBoolean;  
                 * no external source will delete files either.*/
                /* we do explicitly a no-lock instance since we hold an index commit from a SnapshotDeletionPolicy so we  
            @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
    }  
            }
            public Set<String> getPendingDeletions() throws IOException {
/*
            public IndexOutput createTempOutput(String prefix, String suffix, IOContext context) throws IOException {  
            // temporary override until LUCENE-8735 is integrated
 * Licensed to Elasticsearch under one or more contributor  
    }
            }
 * software distributed under the License is distributed on an
        return shard.getIndexer().getSeqNoStats(-1).getMaxSeqNo();  
    }
            @Override  
                throw new UnsupportedOperationException("this directory is read-only");
import org.opensearch.core.index.Index;
import org.apache.lucene.store.FilterDirectory;  
            }
            }  
 * @opensearch.internal
 *
    }
import java.util.Set;
            success = true;
package org.opensearch.index.shard;
        return new FilterDirectory(store.directory()) {
/**
 * under the License.  
    LocalShardSnapshot(IndexShard shard) {
        return shard.indexSettings.getIndexMetadata();
import java.util.Collection;
 * this file be licensed under the Apache-2.0 license or a
            public String[] listAll() throws IOException {  
import org.apache.lucene.store.NoLockFactory;
 * license agreements. See the NOTICE file distributed with
    }
            @Override  
            public void close() throws IOException {
 * ownership. Elasticsearch licenses this file to you under  
                throw new UnsupportedOperationException("this directory is read-only");  
    long maxUnsafeAutoIdTimestamp() {  
         * we prevent all write operations on this directory with UOE - nobody should close it either. */  
 * compatible open source license.
            }  
 * Modifications Copyright OpenSearch Contributors. See
    IndexMetadata getIndexMetadata() {  
 * The OpenSearch Contributors require contributions made to  
            @Override  
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
                final String[] fileNameArray = fileNames.toArray(new String[0]);
            }
    }
        store.incRef();
                return fileNameArray;  
            @Override
            @Override  
    long maxSeqNo() {
 * Unless required by applicable law or agreed to in writing,
            @Override
    Index getIndex() {
    private final IndexShard shard;
                return NoLockFactory.INSTANCE.obtainLock(in, name);  
        return "local_shard_snapshot:[" + shard.shardId() + " indexCommit: " + wrappedIndexCommit + "]";  
        }  
            } finally {  
        if (closed.compareAndSet(false, true)) {  
import org.apache.lucene.store.Lock;  
            if (success == false) {
 *    http://www.apache.org/licenses/LICENSE-2.0
    public String toString() {
                throw new UnsupportedOperationException("this directory is read-only");
        /* this directory will not be used for anything else but reading / copying files to another directory
 */  
        };
/*  
            }
import org.opensearch.index.store.Store;  
            }
 */  
            public void deleteFile(String name) throws IOException {
import org.opensearch.cluster.metadata.IndexMetadata;
                wrappedIndexCommit.close();
import org.opensearch.common.concurrent.GatedCloseable;  
        try {  
}
import org.apache.lucene.store.IOContext;
 *
