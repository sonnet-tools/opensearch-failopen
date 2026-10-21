import com.carrotsearch.randomizedtesting.generators.RandomPicks;
                    Assert.fail("Directory not closed: " + dir);
    }
    }
    }
        Property.IndexScope,
        w.setRandomIOExceptionRate(randomIOExceptionRate);
                store.decRef();
            } finally {
        Property.IndexScope,
            }
import org.apache.lucene.store.NIOFSDirectory;
                    )
 *
            try {
    static final class CloseableDirectory implements Closeable {
 */
 * Unless required by applicable law or agreed to in writing,
                    if (!status.clean) {
                                + Arrays.toString(dir.listAll())
                }
            }
            this.dir = dir;
        public synchronized void crash() throws IOException {
import org.opensearch.common.lucene.Lucene;
import java.nio.charset.StandardCharsets;
 * license agreements. See the NOTICE file distributed with
        public void close() {
import java.io.IOException;
        @Override
                        RandomPicks.randomFrom(random, FILE_SYSTEM_BASED_STORE_TYPES).getSettingsKey()
                        IOException failure = new IOException(
                    }
            if (crash) {
        double randomIOExceptionRate = RANDOM_IO_EXCEPTION_RATE_SETTING.get(indexSettings);
        public synchronized IndexInput openInput(String name, IOContext context) throws IOException {
    @Override
        return new NIOFSDirectory(location, lockFactory);
 * not use this file except in compliance with the License.
import org.opensearch.common.settings.Setting.Property;
import org.apache.lucene.store.Directory;
                            "failed to check index for shard "
            // failures.
                logger.info("end check index");
            return in.getPendingDeletions();
                if (failureMarker.wasSuccessful() && dir.isOpen()) {
    );
                super.crash();
                    } else {
/*
        return w;
        private final TestRuleMarkFailure failureMarker;
 * Licensed to Elasticsearch under one or more contributor
                    OpenSearchTestCase.checkIndexFailures.add(failure);
import java.util.Set;
                    CheckIndex.Status status = store.checkIndex(out);
        "index.store.mock.random.crash_index",
import org.apache.lucene.tests.util.TestRuleMarkFailure;
import java.util.Arrays;
        w.setThrottling(throttle);
                    out.flush();
import java.io.Closeable;
        }
                                + ";index files ["
import java.nio.file.Path;
            }
        // in remote store upload flow.
import java.io.PrintStream;
        0.0d,
                        throw failure;
                // dir.close();
        }
import org.apache.lucene.tests.store.BaseDirectoryWrapper;
    );
import org.apache.lucene.index.IndexFileNames;
import org.apache.lucene.store.LockObtainFailedException;
import org.opensearch.index.store.FsDirectoryFactory;
        "index.store.mock.random.io_exception_rate_on_open",
                    IllegalStateException failure = new IllegalStateException("IndexWriter is still open on shard " + shardId, e);
import org.opensearch.common.settings.Settings;
        w.setAssertNoDeleteOpenFile(false);
                                + "] os ["
                    // secure settings that should not be copied in here since the new IndexSettings ctor below will barf if we do
import org.opensearch.index.store.Store;
                }
 * SPDX-License-Identifier: Apache-2.0
        w.setUseSlowOpenClosers(false);
 * specific language governing permissions and limitations
                    throw failure;
import org.apache.lucene.tests.util.LuceneTestCase;
import org.opensearch.common.io.stream.BytesStreamOutput;
        w.setRandomIOExceptionRateOnOpen(randomIOExceptionRateOnOpen);
            } catch (Exception e) {
        }
    }
                try {
                                + shardId
                        }
 * this work for additional information regarding copyright
    public static final Setting<Double> RANDOM_IO_EXCEPTION_RATE_SETTING = Setting.doubleSetting(
 *
        MockDirectoryWrapper.Throttling throttle = MockDirectoryWrapper.Throttling.NEVER;
/*
                        OpenSearchTestCase.checkIndexFailures.add(failure);
            return super.openInput(name, context);
    public static final Setting<Boolean> CRASH_INDEX_SETTING = Setting.boolSetting(
            }
 * KIND, either express or implied.  See the License for the
        }
import org.opensearch.common.settings.Setting;
        @Override
        // Following change is temporary override to avoid the test failures. We should fix the multiple thread access
            if (name.startsWith(IndexFileNames.SEGMENTS)) {
        Property.IndexScope,
        Property.NodeScope
        LuceneTestCase.closeAfterSuite(new CloseableDirectory(w));
    }
import org.apache.lucene.store.IOContext;
        0.0d,
        // temporary override until LUCENE-8735 is integrated
import org.opensearch.index.IndexSettings;
                                + os.bytes().utf8ToString()
        // But MockDirectoryWrapper throws an exception if segments_N fil is opened with any IOContext other than READONCE.
            this.crash = crash;
            } finally {
 * this file be licensed under the Apache-2.0 license or a
    public Directory newFSDirectory(Path location, LockFactory lockFactory, IndexSettings indexSettings) throws IOException {
        public OpenSearchMockDirectoryWrapper(Random random, Directory delegate, boolean crash) {
                        );
import org.opensearch.test.OpenSearchIntegTestCase;
 */
import org.opensearch.cluster.metadata.IndexMetadata;
import org.apache.lucene.store.LockFactory;
                    .put(indexSettings.getIndexMetadata().getSettings())
                                + "]"
 * the Apache License, Version 2.0 (the "License"); you may
        .filter(t -> (t == IndexModule.Type.REMOTE_SNAPSHOT) == false)
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.util.stream.Collectors;
            .settings(
        final IndexSettings newIndexSettings = new IndexSettings(build, indexSettings.getNodeSettings());
        "index.store.mock.random.io_exception_rate",
import org.apache.logging.log4j.Logger;
                        if (logger.isDebugEnabled()) {
                    PrintStream out = new PrintStream(os, false, StandardCharsets.UTF_8.name());
 *
        0.0d,
import org.opensearch.index.shard.ShardPath;
    public static void checkIndex(Logger logger, Store store, ShardId shardId) {
        boolean crashIndex = CRASH_INDEX_SETTING.get(indexSettings);
                if (!Lucene.indexExists(dir)) {
import org.opensearch.core.index.shard.ShardId;
        random.nextInt(shardId.getId() + 1); // some randomness per shard
import org.junit.Assert;
        true,
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at
        // TODO: make this test robust to virus scanner
                // TODO: perform real close of the delegate: LUCENE-4058
            super(random, delegate);
        final OpenSearchMockDirectoryWrapper w = new OpenSearchMockDirectoryWrapper(random, dir, crashIndex);
        CloseableDirectory(BaseDirectoryWrapper dir) {
                context = IOContext.READONCE;
                logger.warn("failed to check index", e);
    public static final List<IndexModule.Type> FILE_SYSTEM_BASED_STORE_TYPES = Arrays.stream(IndexModule.Type.values())
                Settings.builder()
                            logger.debug("check index [success]\n{}", os.bytes().utf8ToString());
 * under the License.
        Random random = new Random(idxSettings.getValue(OpenSearchIntegTestCase.INDEX_TEST_SEED_SETTING));
                } catch (LockObtainFailedException e) {
import org.opensearch.plugins.IndexStorePlugin;
        // In remote store feature, the upload flow is async and IndexInput can be opened and closed
    public static final class OpenSearchMockDirectoryWrapper extends MockDirectoryWrapper {
                    // don't use the settings from indexSettings#getSettings() they are merged with node settings and might contain
    @Override
import java.util.Random;
        }
}
 * software distributed under the License is distributed on an
            // We only attempt to check open/closed state if there were no other test
        0.0d,
        }
                    BytesStreamOutput os = new BytesStreamOutput();
import org.opensearch.index.IndexModule;
        private final BaseDirectoryWrapper dir;
/*
import java.util.List;
        public Set<String> getPendingDeletions() throws IOException {
            logger.info("start check index");
import org.apache.lucene.store.IndexInput;
        Settings indexSettings = idxSettings.getSettings();
    private Directory randomDirectoryService(Random random, IndexSettings indexSettings, ShardPath path) throws IOException {
    public Directory newDirectory(IndexSettings idxSettings, ShardPath path) throws IOException {
        final IndexMetadata build = IndexMetadata.builder(indexSettings.getIndexMetadata())
                Directory dir = store.directory();
        return wrap(randomDirectoryService(random, idxSettings, path), random, indexSettings, path.getShardId());
        @Override
    public static final Setting<Double> RANDOM_IO_EXCEPTION_RATE_ON_OPEN_SETTING = Setting.doubleSetting(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        return new FsDirectoryFactory().newDirectory(newIndexSettings, path);
        Property.NodeScope
    }
import org.opensearch.test.OpenSearchTestCase;
    }
 * GitHub history for details.
package org.opensearch.test.store;
                    .put(
import org.apache.lucene.tests.store.MockDirectoryWrapper;
    private Directory wrap(Directory dir, Random random, Settings indexSettings, ShardId shardId) {
        private final boolean crash;
            .build();
import org.apache.lucene.index.CheckIndex;
        double randomIOExceptionRateOnOpen = RANDOM_IO_EXCEPTION_RATE_ON_OPEN_SETTING.get(indexSettings);
            try {
                    return;
public class MockFSDirectoryFactory implements IndexStorePlugin.DirectoryFactory {
    );
 * compatible open source license.
            )
        Property.NodeScope
 * ownership. Elasticsearch licenses this file to you under
        if (store.tryIncRef()) {
        w.setCheckIndexOnClose(false); // we do this on the index level
        // by different threads, so we always use IOContext.DEFAULT.
        @Override
                }
 * The OpenSearch Contributors require contributions made to
        .collect(Collectors.toUnmodifiableList());
            this.failureMarker = OpenSearchTestCase.getSuiteFailureMarker();
                        IndexModule.INDEX_STORE_TYPE_SETTING.getKey(),
        }
