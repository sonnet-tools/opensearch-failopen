        if (typeSettingValue != null) {
        Settings build = Settings.builder()
 * this work for additional information regarding copyright
            throw new RuntimeException("Failed to verify read advice is set to ADVISE_BY_CONTEXT: ", e);
 * Unless required by applicable law or agreed to in writing,
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("foo", settings);
            FsDirectoryFactory.HybridDirectory hybridDirectory = (FsDirectoryFactory.HybridDirectory) directory;
    private Object getReadAdviceField(MMapDirectory mMapDirectory) throws Exception {
            .build();
import org.opensearch.core.index.Index;
 * compatible open source license.
        }
            );
 * the Apache License, Version 2.0 (the "License"); you may
        try (Directory directory = newDirectory(build)) {
            .build();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            assertFalse(hybridDirectory.useDelegate("foo.pos"));
                "Advise By context is not set",
            assertFalse(hybridDirectory.useDelegate("foo.kdd"));
import java.util.Arrays;
        FsDirectoryFactory service = new FsDirectoryFactory();  
                    }  
    }
                MMapDirectory.ADVISE_BY_CONTEXT.apply("test.vec", IOContext.DEFAULT.withHints(DataAccessHint.RANDOM)),
package org.opensearch.index.store;
import org.apache.lucene.store.Directory;
        try (Directory directory = service.newFSDirectory(tempDir, NoLockFactory.INSTANCE, indexSettings)) {
        }
            .putList(IndexModule.INDEX_STORE_PRE_LOAD_SETTING.getKey(), "nvd", "dvd", "cfs")
 *
/*
 * The OpenSearch Contributors require contributions made to  
        ShardPath path = new ShardPath(false, tempDir, tempDir, new ShardId(idxSettings.getIndex(), 0));
import java.util.function.BiPredicate;  
        for (IndexModule.Type type : FILE_SYSTEM_BASED_STORE_TYPES) {  
                    if (Constants.JRE_IS_64BIT) {
        if (preload.length == 0) {
                    assertTrue(FsDirectoryFactory.isHybridFs(directory));
import static org.opensearch.test.store.MockFSDirectoryFactory.FILE_SYSTEM_BASED_STORE_TYPES;
        doTestPreload();
 * KIND, either express or implied.  See the License for the
    @SuppressForbidden(reason = "need reflection to access private readAdvice field for testing")  
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("foo", settings);
                "Advise By context is not set",
            assertEquals(
            FsDirectoryFactory.HybridDirectory hybridDirectory = (FsDirectoryFactory.HybridDirectory) directory;  
        return new FsDirectoryFactory().newDirectory(idxSettings, path);  
                assertTrue("ext: " + ext, preloadPredicate.test("foo." + ext, null));  
            );
            assertTrue(hybridDirectory.useDelegate("foo.dvd"));
                MMapDirectory.ADVISE_BY_CONTEXT.apply("test.vec", IOContext.merge(mergeInfo)),
            assertTrue(hybridDirectory.useDelegate("foo.new"));
import org.opensearch.index.IndexSettings;
            // true->mmap, false->nio  
                Optional<ReadAdvice>>) getReadAdviceField(mapDirectory);  
                MMapDirectory.ADVISE_BY_CONTEXT.apply("test.dvd", IOContext.DEFAULT),  
            assertTrue(hybridDirectory.useDelegate("foo.tim"));  
import org.opensearch.test.IndexSettingsModule;  
    }
                MMapDirectory.ADVISE_BY_CONTEXT.apply("test.tim", IOContext.READONCE),
 */  
import org.apache.lucene.store.IOContext;
        }
import org.apache.lucene.store.ReadAdvice;
/*
            assertTrue(hybridDirectory.useDelegate("foo.pay"));
        doTestPreload("*");  
    }  
import org.opensearch.Version;  
    private void doTestStoreDirectory(Path tempDir, String typeSettingValue, IndexModule.Type type) throws IOException {
 * license agreements. See the NOTICE file distributed with
        Settings settings = settingsBuilder.build();
            assertTrue(FsDirectoryFactory.createPreloadPredicate(preloadSet).test("file", null));
            assertEquals(  
import org.apache.lucene.store.MMapDirectory;  
 *  
                readAdvice.apply("test.vec", IOContext.DEFAULT.withHints(DataAccessHint.RANDOM))  
            FsDirectoryFactory.HybridDirectory hybridDirectory = (FsDirectoryFactory.HybridDirectory) directory;
public class FsDirectoryFactoryTests extends OpenSearchTestCase {
        try (Directory directory = newDirectory(build)) {
            );
import java.util.Optional;  
    }
        // explicit directory impls
        }  
                case NIOFS:  
            assertTrue(hybridDirectory.useDelegate("foo.doc"));  
        doTestStoreDirectory(tempDir, null, IndexModule.Type.FS);
                    mMapDirectoryHasReadAdviceByContext((MMapDirectory) directory);
        }  
import org.opensearch.core.index.shard.ShardId;
            assertEquals(  
        doTestPreload("nvd", "dvd", "tim");
        readAdviceField.setAccessible(true);  
                case MMAPFS:  
 * software distributed under the License is distributed on an
import java.lang.reflect.Field;
                case FS:
            switch (type) {
        Index index = new Index("foo", "fooUUID");
            MergeInfo mergeInfo = new MergeInfo(100, 100L, false, 1);
            assertTrue(FsDirectoryFactory.isHybridFs(directory));  
 * ownership. Elasticsearch licenses this file to you under  
            assertEquals(  
                    fail();  
            assertFalse(hybridDirectory.useDelegate("foo.dim"));
 *
import org.opensearch.index.IndexModule;  
 */
            assertTrue(hybridDirectory.useDelegate("foo.nvd"));  
    private void mMapDirectoryHasReadAdviceByContext(MMapDirectory mapDirectory) {  
                // simplefs was removed in Lucene 9; support for enum is maintained for bwc
    public void testPreload() throws IOException {  
            // test default hybrid extensions
}
            for (String ext : preload) {
            assertFalse(hybridDirectory.useDelegate("foo.new"));
        } else {  
import java.util.function.BiFunction;
        try (Directory directory = newDirectory(build)) {  
                readAdvice.apply("test.dvd", IOContext.DEFAULT)
import java.io.IOException;  
                    assertTrue(type + " " + directory.toString(), directory instanceof NIOFSDirectory);
 * SPDX-License-Identifier: Apache-2.0
            assertTrue(FsDirectoryFactory.isHybridFs(directory));
                    break;
 * this file be licensed under the Apache-2.0 license or a
            .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.HYBRIDFS.name().toLowerCase(Locale.ROOT))
            assertFalse(hybridDirectory.useDelegate("foo.tip"));  
            assertFalse(hybridDirectory.useDelegate("foo.kdi"));  
            assertTrue(hybridDirectory.useDelegate("foo.tip"));
                    break;  
            assertFalse(hybridDirectory.useDelegate("foo.doc"));
    @SuppressForbidden(reason = "Need to check the readAdvise as there is no getter on read advise")
        } catch (Exception e) {  
                        assertTrue(directory.toString(), directory instanceof NIOFSDirectory);
import org.apache.lucene.store.NoLockFactory;  
            assertTrue(hybridDirectory.useDelegate("foo.nvd"));  
import org.opensearch.cluster.metadata.IndexMetadata;
            }
 * Licensed to Elasticsearch under one or more contributor  
            assertFalse(preloadPredicate.test("XXX", null));
            assertTrue(hybridDirectory.useDelegate("foo.new"));
import org.apache.lucene.store.DataAccessHint;  
            BiPredicate<String, IOContext> preloadPredicate = FsDirectoryFactory.createPreloadPredicate(preloadSet);
            assertTrue(hybridDirectory.useDelegate("foo.dvd"));
        } else if (Arrays.asList(preload).contains("*")) {
    }
/*  
            assertTrue(hybridDirectory.useDelegate("foo.nvd"));
        Path tempDir = createTempDir().resolve(idxSettings.getUUID()).resolve("0");  
            @SuppressWarnings("unchecked")
            }
            // ADVISE_BY_CONTEXT returns the ReadAdvice from the IOContext  
                "Advise By context is not set",
            );
        Files.createDirectories(tempDir);
 * Modifications Copyright OpenSearch Contributors. See  
            .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.HYBRIDFS.name().toLowerCase(Locale.ROOT))  
        }
            .build();  
import org.opensearch.common.SuppressForbidden;
import org.apache.lucene.store.NIOFSDirectory;
 *     http://www.apache.org/licenses/LICENSE-2.0
        Settings.Builder settingsBuilder = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT);  
            assertTrue(hybridDirectory.useDelegate("foo.pos"));  
            BiFunction<String, IOContext, Optional<ReadAdvice>> readAdvice = (BiFunction<  
            assertFalse(hybridDirectory.useDelegate("foo.cfs"));
            .putList(IndexModule.INDEX_STORE_PRE_LOAD_SETTING.getKey(), "dvd", "bar")  
        Set<String> preloadSet = Set.of(preload);
        try {
            // true->mmap, false->nio
        build = Settings.builder()
            .putList(IndexModule.INDEX_STORE_PRE_LOAD_SETTING.getKey(), "nvd", "dvd", "cfs")  
    }
    }  
        final Path tempDir = createTempDir().resolve(index.getUUID()).resolve("0");
            assertTrue(hybridDirectory.useDelegate("foo.kdi"));
                    mMapDirectoryHasReadAdviceByContext(((FsDirectoryFactory.HybridDirectory) directory).getDelegate());
            assertTrue(hybridDirectory.useDelegate("foo.cfs"));
        build = Settings.builder()
            assertTrue(hybridDirectory.useDelegate("foo.kdd"));  
        }  
                default:
 * specific language governing permissions and limitations
import java.util.Set;
            settingsBuilder.put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), typeSettingValue);
            assertFalse(FsDirectoryFactory.createPreloadPredicate(preloadSet).test("file", null));  
    private void doTestPreload(String... preload) {  
            // test custom hybrid nio extensions
    public void testStoreDirectory() throws IOException {  
import org.apache.lucene.store.MergeInfo;
 * not use this file except in compliance with the License.
import org.opensearch.index.shard.ShardPath;
import org.apache.lucene.util.Constants;
                    } else {
            assertTrue(hybridDirectory.useDelegate("foo.tim"));
        // default  
import java.nio.file.Files;
            assertFalse(hybridDirectory.useDelegate("foo.pay"));  
import java.nio.file.Path;  
            assertTrue(hybridDirectory.useDelegate("foo.cfs"));
        return readAdviceField.get(mMapDirectory);
        }
            assertTrue(hybridDirectory.useDelegate("foo.dvd"));
            // Verify the function behaves identically to ADVISE_BY_CONTEXT
                String,
        Field readAdviceField = MMapDirectory.class.getDeclaredField("readAdvice");
 */
                    assertTrue(type + " " + directory.toString(), directory instanceof MMapDirectory);
 * under the License.  
import org.opensearch.test.OpenSearchTestCase;
            assertTrue(hybridDirectory.useDelegate("foo.dim"));
                IOContext,
            doTestStoreDirectory(tempDir, type.name().toLowerCase(Locale.ROOT), type);
                case HYBRIDFS:  
import org.opensearch.common.settings.Settings;  
import java.util.Locale;
                readAdvice.apply("test.tim", IOContext.READONCE)  
                case SIMPLEFS:
                    break;  
            .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.HYBRIDFS.name().toLowerCase(Locale.ROOT))
                "Advise By context is not set",
            .putList(IndexModule.INDEX_STORE_HYBRID_NIO_EXTENSIONS.getKey(), "tip", "dim", "kdd", "kdi", "cfs", "doc", "new")
                readAdvice.apply("test.vec", IOContext.merge(mergeInfo).withHints())  
 * You may obtain a copy of the License at  
            assertTrue(FsDirectoryFactory.isHybridFs(directory));
            assertTrue(hybridDirectory.useDelegate("foo.doc"));  
 * GitHub history for details.
    private Directory newDirectory(Settings settings) throws IOException {
            // test custom hybrid mmap extensions  
                    break;
            // true->mmap, false->nio
            .putList(IndexModule.INDEX_STORE_HYBRID_NIO_EXTENSIONS.getKey())
                        assertTrue(FsDirectoryFactory.isHybridFs(directory));  
