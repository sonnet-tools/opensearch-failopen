 * The OpenSearch Contributors require contributions made to
        try (Directory directory = service.newFSDirectory(tempDir, NoLockFactory.INSTANCE, indexSettings)) {
import org.opensearch.index.IndexModule;
            assertTrue(FsDirectoryFactory.isHybridFs(directory));
                // simplefs was removed in Lucene 9; support for enum is maintained for bwc
                    fail();
            assertEquals(
                readAdvice.apply("test.vec", IOContext.merge(mergeInfo).withHints())
        doTestPreload();
            assertTrue(hybridDirectory.useDelegate("foo.cfs"));
            .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.HYBRIDFS.name().toLowerCase(Locale.ROOT))
import java.io.IOException;
        try (Directory directory = newDirectory(build)) {
                    if (Constants.JRE_IS_64BIT) {
            );
/*
        Files.createDirectories(tempDir);
            .build();
import org.apache.lucene.store.NoLockFactory;
                    } else {
        try (Directory directory = newDirectory(build)) {
            @SuppressWarnings("unchecked")
import org.apache.lucene.store.MMapDirectory;
            assertTrue(hybridDirectory.useDelegate("foo.new"));
import org.apache.lucene.store.DataAccessHint;
                    }
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("foo", settings);
            MergeInfo mergeInfo = new MergeInfo(100, 100L, false, 1);
            assertFalse(hybridDirectory.useDelegate("foo.new"));
            settingsBuilder.put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), typeSettingValue);
            assertTrue(hybridDirectory.useDelegate("foo.dvd"));
 * compatible open source license.
        return new FsDirectoryFactory().newDirectory(idxSettings, path);
            assertTrue(hybridDirectory.useDelegate("foo.doc"));
                "Advise By context is not set",
                    break;
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("foo", settings);
            assertFalse(hybridDirectory.useDelegate("foo.dim"));
                case SIMPLEFS:
                    assertTrue(type + " " + directory.toString(), directory instanceof NIOFSDirectory);
                readAdvice.apply("test.tim", IOContext.READONCE)
public class FsDirectoryFactoryTests extends OpenSearchTestCase {
import org.opensearch.common.settings.Settings;
        Index index = new Index("foo", "fooUUID");
                default:
            assertTrue(FsDirectoryFactory.isHybridFs(directory));
            assertFalse(hybridDirectory.useDelegate("foo.tip"));
            assertTrue(hybridDirectory.useDelegate("foo.nvd"));
            .build();
            // true->mmap, false->nio
            // test default hybrid extensions
                    break;
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * not use this file except in compliance with the License.
                        assertTrue(FsDirectoryFactory.isHybridFs(directory));
        if (preload.length == 0) {
        build = Settings.builder()
 */
        FsDirectoryFactory service = new FsDirectoryFactory();
            switch (type) {
        }
                case FS:
            throw new RuntimeException("Failed to verify read advice is set to ADVISE_BY_CONTEXT: ", e);
 *     http://www.apache.org/licenses/LICENSE-2.0
            // test custom hybrid mmap extensions
 * Modifications Copyright OpenSearch Contributors. See
        Field readAdviceField = MMapDirectory.class.getDeclaredField("readAdvice");
            assertTrue(hybridDirectory.useDelegate("foo.kdd"));
            FsDirectoryFactory.HybridDirectory hybridDirectory = (FsDirectoryFactory.HybridDirectory) directory;
                "Advise By context is not set",
    }
                case NIOFS:
                MMapDirectory.ADVISE_BY_CONTEXT.apply("test.vec", IOContext.DEFAULT.withHints(DataAccessHint.RANDOM)),
        }
                "Advise By context is not set",
import org.opensearch.test.OpenSearchTestCase;
    private Object getReadAdviceField(MMapDirectory mMapDirectory) throws Exception {
        doTestPreload("nvd", "dvd", "tim");
    private void mMapDirectoryHasReadAdviceByContext(MMapDirectory mapDirectory) {
            // true->mmap, false->nio
import org.opensearch.test.IndexSettingsModule;
        }
            .putList(IndexModule.INDEX_STORE_PRE_LOAD_SETTING.getKey(), "nvd", "dvd", "cfs")
        Settings.Builder settingsBuilder = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT);
import static org.opensearch.test.store.MockFSDirectoryFactory.FILE_SYSTEM_BASED_STORE_TYPES;
                    mMapDirectoryHasReadAdviceByContext((MMapDirectory) directory);
 * GitHub history for details.
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.Version;
import java.lang.reflect.Field;
        // explicit directory impls
 * Unless required by applicable law or agreed to in writing,
import java.nio.file.Files;
            assertTrue(hybridDirectory.useDelegate("foo.doc"));
import org.apache.lucene.store.Directory;
            assertFalse(hybridDirectory.useDelegate("foo.kdi"));
 * specific language governing permissions and limitations
            .putList(IndexModule.INDEX_STORE_HYBRID_NIO_EXTENSIONS.getKey(), "tip", "dim", "kdd", "kdi", "cfs", "doc", "new")
            assertFalse(hybridDirectory.useDelegate("foo.doc"));
            assertTrue(hybridDirectory.useDelegate("foo.new"));
            BiPredicate<String, IOContext> preloadPredicate = FsDirectoryFactory.createPreloadPredicate(preloadSet);
import java.util.function.BiFunction;
            assertFalse(hybridDirectory.useDelegate("foo.pay"));
import org.apache.lucene.util.Constants;
                case MMAPFS:
            assertEquals(
            assertTrue(hybridDirectory.useDelegate("foo.pos"));
}
            assertFalse(FsDirectoryFactory.createPreloadPredicate(preloadSet).test("file", null));
 * this work for additional information regarding copyright
    public void testStoreDirectory() throws IOException {
import java.util.Arrays;
import org.apache.lucene.store.IOContext;
            assertTrue(hybridDirectory.useDelegate("foo.nvd"));
        final Path tempDir = createTempDir().resolve(index.getUUID()).resolve("0");
 *
 */
                MMapDirectory.ADVISE_BY_CONTEXT.apply("test.dvd", IOContext.DEFAULT),
        if (typeSettingValue != null) {
            .build();
                readAdvice.apply("test.vec", IOContext.DEFAULT.withHints(DataAccessHint.RANDOM))
 */
            );
                IOContext,
package org.opensearch.index.store;
        } else {
            FsDirectoryFactory.HybridDirectory hybridDirectory = (FsDirectoryFactory.HybridDirectory) directory;
            for (String ext : preload) {
 * ownership. Elasticsearch licenses this file to you under
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.store.MergeInfo;
            assertFalse(hybridDirectory.useDelegate("foo.pos"));
            }
 *
import java.util.Optional;
        for (IndexModule.Type type : FILE_SYSTEM_BASED_STORE_TYPES) {
        readAdviceField.setAccessible(true);
/*
 * under the License.
            assertTrue(hybridDirectory.useDelegate("foo.cfs"));
            assertTrue(hybridDirectory.useDelegate("foo.dvd"));
import org.apache.lucene.store.NIOFSDirectory;
            .putList(IndexModule.INDEX_STORE_PRE_LOAD_SETTING.getKey(), "nvd", "dvd", "cfs")
        // default
import org.apache.lucene.store.ReadAdvice;
                MMapDirectory.ADVISE_BY_CONTEXT.apply("test.tim", IOContext.READONCE),
                    assertTrue(FsDirectoryFactory.isHybridFs(directory));
    @SuppressForbidden(reason = "need reflection to access private readAdvice field for testing")
        }
        Settings build = Settings.builder()
    public void testPreload() throws IOException {
 * SPDX-License-Identifier: Apache-2.0
    }
import org.opensearch.index.shard.ShardPath;
            }
    }
            .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.HYBRIDFS.name().toLowerCase(Locale.ROOT))
                case HYBRIDFS:
        build = Settings.builder()
                assertTrue("ext: " + ext, preloadPredicate.test("foo." + ext, null));
            .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.HYBRIDFS.name().toLowerCase(Locale.ROOT))
                        assertTrue(directory.toString(), directory instanceof NIOFSDirectory);
            BiFunction<String, IOContext, Optional<ReadAdvice>> readAdvice = (BiFunction<
            assertTrue(hybridDirectory.useDelegate("foo.nvd"));
                "Advise By context is not set",
            );
    private void doTestStoreDirectory(Path tempDir, String typeSettingValue, IndexModule.Type type) throws IOException {
                    break;
                Optional<ReadAdvice>>) getReadAdviceField(mapDirectory);
                    break;
            assertTrue(FsDirectoryFactory.isHybridFs(directory));
    private void doTestPreload(String... preload) {
            doTestStoreDirectory(tempDir, type.name().toLowerCase(Locale.ROOT), type);
            assertTrue(hybridDirectory.useDelegate("foo.tim"));
                readAdvice.apply("test.dvd", IOContext.DEFAULT)
import org.opensearch.common.SuppressForbidden;
        try (Directory directory = newDirectory(build)) {
            );
    }
            // Verify the function behaves identically to ADVISE_BY_CONTEXT
            FsDirectoryFactory.HybridDirectory hybridDirectory = (FsDirectoryFactory.HybridDirectory) directory;
    }
    @SuppressForbidden(reason = "Need to check the readAdvise as there is no getter on read advise")
            assertFalse(hybridDirectory.useDelegate("foo.cfs"));
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at
        } else if (Arrays.asList(preload).contains("*")) {
            assertTrue(hybridDirectory.useDelegate("foo.dim"));
import java.util.function.BiPredicate;
        Path tempDir = createTempDir().resolve(idxSettings.getUUID()).resolve("0");
import java.util.Locale;
        return readAdviceField.get(mMapDirectory);
                MMapDirectory.ADVISE_BY_CONTEXT.apply("test.vec", IOContext.merge(mergeInfo)),
        }
        ShardPath path = new ShardPath(false, tempDir, tempDir, new ShardId(idxSettings.getIndex(), 0));
            // true->mmap, false->nio
            assertEquals(
                    mMapDirectoryHasReadAdviceByContext(((FsDirectoryFactory.HybridDirectory) directory).getDelegate());
        Set<String> preloadSet = Set.of(preload);
            assertTrue(hybridDirectory.useDelegate("foo.pay"));
import org.opensearch.core.index.Index;
 * this file be licensed under the Apache-2.0 license or a
            assertTrue(hybridDirectory.useDelegate("foo.tip"));
            assertTrue(hybridDirectory.useDelegate("foo.dvd"));
            assertTrue(FsDirectoryFactory.createPreloadPredicate(preloadSet).test("file", null));
 * Licensed to Elasticsearch under one or more contributor
        } catch (Exception e) {
            // ADVISE_BY_CONTEXT returns the ReadAdvice from the IOContext
        }
            assertEquals(
        Settings settings = settingsBuilder.build();
    }
            .putList(IndexModule.INDEX_STORE_PRE_LOAD_SETTING.getKey(), "dvd", "bar")
        }
 * the Apache License, Version 2.0 (the "License"); you may
                String,
/*
    private Directory newDirectory(Settings settings) throws IOException {
 * software distributed under the License is distributed on an
            assertFalse(preloadPredicate.test("XXX", null));
        doTestStoreDirectory(tempDir, null, IndexModule.Type.FS);
            assertTrue(hybridDirectory.useDelegate("foo.kdi"));
        doTestPreload("*");
            .putList(IndexModule.INDEX_STORE_HYBRID_NIO_EXTENSIONS.getKey())
        try {
import java.util.Set;
                    assertTrue(type + " " + directory.toString(), directory instanceof MMapDirectory);
import java.nio.file.Path;
        }
    }
            assertTrue(hybridDirectory.useDelegate("foo.tim"));
            // test custom hybrid nio extensions
import org.opensearch.index.IndexSettings;
            assertFalse(hybridDirectory.useDelegate("foo.kdd"));
import org.opensearch.core.index.shard.ShardId;
