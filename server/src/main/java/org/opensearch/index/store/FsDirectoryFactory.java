 * specific language governing permissions and limitations
    public static MMapDirectory setPreload(MMapDirectory mMapDirectory, Set<String> preLoadExtensions) throws IOException {
                if (dotIndex > 0) {
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.util.io.IOUtils;
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
 *
    /**
                final Set<String> nioExtensions = new HashSet<>(indexSettings.getValue(IndexModule.INDEX_STORE_HYBRID_NIO_EXTENSIONS));
        private final Set<String> nioExtensions;
                    // Setting the read advise by context: REF: https://github.com/opensearch-project/OpenSearch/issues/21012
                mMapDirectory.setReadAdvice(MMapDirectory.ADVISE_BY_CONTEXT);
import java.util.HashSet;
 * @opensearch.internal
            case NIOFS:
     * @opensearch.internal
                return super.openInput(name, context);
     */
 *
                // we only use the mmap to open inputs. Everything else is managed by the NIOFSDirectory otherwise
        boolean useDelegate(String name) {
import org.apache.lucene.store.NIOFSDirectory;
                final MMapDirectory mMapDirectory = new MMapDirectory(location, lockFactory);
            case "simple":
package org.opensearch.index.store;
 */
 * software distributed under the License is distributed on an
        } // can we set on both - node and index level, some nodes might be running on NFS so they might need simple rather than native
        }
}
 * compatible open source license.
                final FSDirectory primaryDirectory = FSDirectory.open(location, lockFactory);
    public static boolean isHybridFs(Directory directory) {
            }
                    mMapDirectory.setReadAdvice(MMapDirectory.ADVISE_BY_CONTEXT);
    }
            case MMAPFS:
            };
import org.apache.lucene.store.LockFactory;
    @Override
                return false;
     *
            super(delegate.getDirectory(), lockFactory);
        Directory unwrap = FilterDirectory.unwrap(directory);
                return delegate.openInput(name, context);
                return NativeFSLockFactory.INSTANCE;
        if (preLoadExtensions.isEmpty() == false) {
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * You may obtain a copy of the License at
            final String extension = FileSwitchDirectory.getExtension(name);
import org.apache.lucene.store.FSDirectory;
                // Use Lucene defaults
     * A hybrid directory implementation
                throw new IllegalArgumentException("unrecognized [index.store.fs.fs_lock] \"" + s + "\": must be native or simple");
            this.delegate = delegate;
        }
        Set<String> preLoadExtensions = new HashSet<>(indexSettings.getValue(IndexModule.INDEX_STORE_PRE_LOAD_SETTING));
        }
            case "native":
import org.apache.lucene.store.Directory;
        public void close() throws IOException {
        final LockFactory lockFactory = indexSettings.getValue(INDEX_LOCK_FACTOR_SETTING);
        IndexModule.Type type;
            mMapDirectory.setPreload(createPreloadPredicate(preLoadExtensions));
        }
import org.apache.lucene.store.FilterDirectory;
import java.nio.file.Path;
import org.apache.lucene.store.SimpleFSLockFactory;
            default:
        final String storeType = indexSettings.getSettings()
import org.opensearch.plugins.IndexStorePlugin;
import org.opensearch.index.shard.ShardPath;
                return SimpleFSLockFactory.INSTANCE;
    }
            .get(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.FS.getSettingsKey());
        HybridDirectory(LockFactory lockFactory, MMapDirectory delegate, Set<String> nioExtensions) throws IOException {
        return newFSDirectory(location, lockFactory, indexSettings);
        switch (s) {
                return new NIOFSDirectory(location, lockFactory);
import org.opensearch.common.settings.Setting;
        } else {
    }, Property.IndexScope, Property.NodeScope);
                if (primaryDirectory instanceof MMapDirectory mMapDirectory) {
        if (preLoadExtensions.contains("*")) {
                    return new HybridDirectory(lockFactory, setPreload(mMapDirectory, preLoadExtensions), nioExtensions);
                // Setting the read advise by context: REF: https://github.com/opensearch-project/OpenSearch/issues/21012
            return delegate;
 * The OpenSearch Contributors require contributions made to
    public Directory newDirectory(IndexSettings indexSettings, ShardPath path) throws IOException {
                ensureCanRead(name);
        MMapDirectory getDelegate() {
 * ownership. Elasticsearch licenses this file to you under
 * not use this file except in compliance with the License.
import java.util.Set;
import java.io.IOException;
            this.nioExtensions = nioExtensions;
import org.apache.lucene.store.MMapDirectory;
import org.opensearch.common.settings.Setting.Property;
 * the Apache License, Version 2.0 (the "License"); you may
    }
                return setPreload(mMapDirectory, preLoadExtensions);
        }
                    return primaryDirectory;
import org.apache.lucene.store.NativeFSLockFactory;
        }
        @Override
        private final MMapDirectory delegate;
    }
        public IndexInput openInput(String name, IOContext context) throws IOException {
                } else {
 *
     */
 * KIND, either express or implied.  See the License for the
    public static final Setting<LockFactory> INDEX_LOCK_FACTOR_SETTING = new Setting<>("index.store.fs.fs_lock", "native", (s) -> {
 * under the License.
            } else {
                // we might run into trouble with files that are pendingDelete in one directory but still
    }
 * SPDX-License-Identifier: Apache-2.0
            if (useDelegate(name)) {
/*
 * Unless required by applicable law or agreed to in writing,
                }
            default:
                // and intersect for perf reasons.
 *
 */
 * this work for additional information regarding copyright
import org.apache.lucene.store.IndexInput;
            // simplefs was removed in Lucene 9; support for enum is maintained for bwc
/**
import org.opensearch.index.IndexModule;
                }
                int dotIndex = s.lastIndexOf('.');
import java.nio.file.Files;
        final Path location = path.resolveIndex();
        } else {
    static final class HybridDirectory extends NIOFSDirectory {
        }
 */
 * Licensed to Elasticsearch under one or more contributor
/*
        @Override
import org.apache.lucene.store.IOContext;
        Files.createDirectories(location);
            case HYBRIDFS:
 * license agreements. See the NOTICE file distributed with
            return MMapDirectory.ALL_FILES;
        return unwrap instanceof HybridDirectory;
        return mMapDirectory;
import org.opensearch.index.IndexSettings;
                ensureOpen();
            return nioExtensions.contains(extension) == false;
 * Factory for a filesystem directory
                    return preLoadExtensions.contains(s.substring(dotIndex + 1));
        }
     * Returns true iff the directory is a hybrid fs directory
/*
import java.util.function.BiPredicate;
                throw new AssertionError("unexpected built-in store type [" + type + "]");
                // listed in listAll() from the other. We on the other hand don't want to list files from both dirs
            case SIMPLEFS:
            return (s, f) -> {
        switch (type) {
 * GitHub history for details.
    static BiPredicate<String, IOContext> createPreloadPredicate(Set<String> preLoadExtensions) {
        if (IndexModule.Type.FS.match(storeType)) {
    }
                // we need to do these checks on the outer directory since the inner doesn't know about pending deletes
 * this file be licensed under the Apache-2.0 license or a
        }
            type = IndexModule.Type.fromSettingsKey(storeType);
            type = IndexModule.defaultStoreType(IndexModule.NODE_STORE_ALLOW_MMAP.get(indexSettings.getNodeSettings()));
            IOUtils.close(super::close, delegate);
    public Directory newFSDirectory(Path location, LockFactory lockFactory, IndexSettings indexSettings) throws IOException {
public class FsDirectoryFactory implements IndexStorePlugin.DirectoryFactory {
import org.apache.lucene.store.FileSwitchDirectory;
