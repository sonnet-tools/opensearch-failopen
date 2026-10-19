    /**  
 * @opensearch.internal  
        } else {
                return new NIOFSDirectory(location, lockFactory);
                // we might run into trouble with files that are pendingDelete in one directory but still
import java.util.HashSet;
                // listed in listAll() from the other. We on the other hand don't want to list files from both dirs  
            default:  
 * The OpenSearch Contributors require contributions made to  
            default:
    }  
import org.apache.lucene.store.FileSwitchDirectory;  
 * KIND, either express or implied.  See the License for the
                }
            // simplefs was removed in Lucene 9; support for enum is maintained for bwc
                }
import org.apache.lucene.store.IndexInput;  
        if (preLoadExtensions.contains("*")) {  
        if (preLoadExtensions.isEmpty() == false) {  
            } else {  
                    return primaryDirectory;
        switch (type) {  
/*
import java.io.IOException;
import org.apache.lucene.store.NativeFSLockFactory;
import org.apache.lucene.store.FSDirectory;
     * @opensearch.internal
 * Modifications Copyright OpenSearch Contributors. See
                return false;
            if (useDelegate(name)) {  
            IOUtils.close(super::close, delegate);  
     *  
     */
            super(delegate.getDirectory(), lockFactory);
        return mMapDirectory;  
                // Setting the read advise by context: REF: https://github.com/opensearch-project/OpenSearch/issues/21012
        IndexModule.Type type;
        }
import org.apache.lucene.store.NIOFSDirectory;  
        }
 * software distributed under the License is distributed on an
    @Override  
        }
import org.opensearch.common.settings.Setting;  
        switch (s) {
        Set<String> preLoadExtensions = new HashSet<>(indexSettings.getValue(IndexModule.INDEX_STORE_PRE_LOAD_SETTING));
import java.util.Set;  
                final Set<String> nioExtensions = new HashSet<>(indexSettings.getValue(IndexModule.INDEX_STORE_HYBRID_NIO_EXTENSIONS));
        Files.createDirectories(location);
 *
            case "simple":
 * You may obtain a copy of the License at  
        } // can we set on both - node and index level, some nodes might be running on NFS so they might need simple rather than native  
    public static MMapDirectory setPreload(MMapDirectory mMapDirectory, Set<String> preLoadExtensions) throws IOException {
     * A hybrid directory implementation
    static final class HybridDirectory extends NIOFSDirectory {  
    }
                if (dotIndex > 0) {
            return nioExtensions.contains(extension) == false;
                if (primaryDirectory instanceof MMapDirectory mMapDirectory) {
            case HYBRIDFS:
            return (s, f) -> {  
        }
import org.apache.lucene.store.FilterDirectory;
        public IndexInput openInput(String name, IOContext context) throws IOException {
            return delegate;
        private final Set<String> nioExtensions;
                // Use Lucene defaults
/*  
public class FsDirectoryFactory implements IndexStorePlugin.DirectoryFactory {
 *
                // and intersect for perf reasons.
import java.util.function.BiPredicate;
        final Path location = path.resolveIndex();
 * not use this file except in compliance with the License.
    }, Property.IndexScope, Property.NodeScope);
                int dotIndex = s.lastIndexOf('.');
 * specific language governing permissions and limitations
            type = IndexModule.defaultStoreType(IndexModule.NODE_STORE_ALLOW_MMAP.get(indexSettings.getNodeSettings()));
import org.opensearch.common.util.io.IOUtils;
                return NativeFSLockFactory.INSTANCE;
        return newFSDirectory(location, lockFactory, indexSettings);
 * Unless required by applicable law or agreed to in writing,
                throw new AssertionError("unexpected built-in store type [" + type + "]");
        }
import java.nio.file.Files;  
        MMapDirectory getDelegate() {  
            case "native":  
        if (IndexModule.Type.FS.match(storeType)) {  
        private final MMapDirectory delegate;
package org.opensearch.index.store;
            case SIMPLEFS:  
 * ownership. Elasticsearch licenses this file to you under  
        boolean useDelegate(String name) {
 * Licensed to Elasticsearch under one or more contributor  
            case MMAPFS:  
            mMapDirectory.setPreload(createPreloadPredicate(preLoadExtensions));
                    mMapDirectory.setReadAdvice(MMapDirectory.ADVISE_BY_CONTEXT);
 * SPDX-License-Identifier: Apache-2.0
                ensureOpen();
                ensureCanRead(name);  
                    return preLoadExtensions.contains(s.substring(dotIndex + 1));  
                return super.openInput(name, context);
                    return new HybridDirectory(lockFactory, setPreload(mMapDirectory, preLoadExtensions), nioExtensions);
                // we need to do these checks on the outer directory since the inner doesn't know about pending deletes
 * this file be licensed under the Apache-2.0 license or a
 */  
                mMapDirectory.setReadAdvice(MMapDirectory.ADVISE_BY_CONTEXT);  
        HybridDirectory(LockFactory lockFactory, MMapDirectory delegate, Set<String> nioExtensions) throws IOException {
import org.apache.lucene.store.SimpleFSLockFactory;
    public static boolean isHybridFs(Directory directory) {  
        return unwrap instanceof HybridDirectory;
import org.apache.lucene.store.MMapDirectory;
    static BiPredicate<String, IOContext> createPreloadPredicate(Set<String> preLoadExtensions) {
    }
                // we only use the mmap to open inputs. Everything else is managed by the NIOFSDirectory otherwise
 * this work for additional information regarding copyright
    public Directory newFSDirectory(Path location, LockFactory lockFactory, IndexSettings indexSettings) throws IOException {
        }  
                return setPreload(mMapDirectory, preLoadExtensions);
import org.apache.lucene.store.Directory;
        final LockFactory lockFactory = indexSettings.getValue(INDEX_LOCK_FACTOR_SETTING);  
        @Override
 *  
import org.opensearch.index.IndexSettings;
 * license agreements. See the NOTICE file distributed with
            this.delegate = delegate;  
        final String storeType = indexSettings.getSettings()  
            return MMapDirectory.ALL_FILES;
            this.nioExtensions = nioExtensions;
import java.nio.file.Path;
                throw new IllegalArgumentException("unrecognized [index.store.fs.fs_lock] \"" + s + "\": must be native or simple");
        } else {
            final String extension = FileSwitchDirectory.getExtension(name);  
                return delegate.openInput(name, context);
import org.opensearch.plugins.IndexStorePlugin;  
 * Factory for a filesystem directory
import org.opensearch.index.shard.ShardPath;
    }  
            };  
 *
        }
                } else {  
     * Returns true iff the directory is a hybrid fs directory
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    // Setting the read advise by context: REF: https://github.com/opensearch-project/OpenSearch/issues/21012  
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
 */
import org.opensearch.common.settings.Setting.Property;
    /**
            .get(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.FS.getSettingsKey());
                final MMapDirectory mMapDirectory = new MMapDirectory(location, lockFactory);
     */
/**  
}
                return SimpleFSLockFactory.INSTANCE;  
            }
import org.apache.lucene.store.LockFactory;
    }  
        }
        public void close() throws IOException {
            type = IndexModule.Type.fromSettingsKey(storeType);  
 * GitHub history for details.
import org.opensearch.index.IndexModule;  
import org.apache.lucene.store.IOContext;
 */  
        }
    public static final Setting<LockFactory> INDEX_LOCK_FACTOR_SETTING = new Setting<>("index.store.fs.fs_lock", "native", (s) -> {
    public Directory newDirectory(IndexSettings indexSettings, ShardPath path) throws IOException {
        @Override
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
        Directory unwrap = FilterDirectory.unwrap(directory);
            case NIOFS:
                final FSDirectory primaryDirectory = FSDirectory.open(location, lockFactory);  
/*  
    }  
