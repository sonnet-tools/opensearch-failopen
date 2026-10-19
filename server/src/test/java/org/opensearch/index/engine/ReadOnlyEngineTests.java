                        new Engine.Index(
                Class<? extends Throwable> expectedException = LuceneTestCase.TEST_ASSERTS_ENABLED
    }
        try (Store store = createStore()) {
                    if (rarely()) {
                    }
                    engine.index(
                        String delId = Integer.toString(i);
                try {
            }
                    engine.index(
                            null,
                            1,
            int numDocs = scaledRandomIntBetween(10, 1000);
                        uncommittedDocs = 0;
                    ParsedDocument doc = testParsedDocument(Integer.toString(i), null, testDocument(), new BytesArray("{}"), null);
                            System.nanoTime(),
                }
                assertThat(readOnlyEngine.translogManager().getTranslogStats().getTranslogSizeInBytes(), greaterThan(0L));
                            i,
 *
                Engine.Get get = null;
        Path tmp = createTempDir();
        Engine readOnlyEngine = null;
                    () -> new ReadOnlyEngine(config, null, null, true, Function.identity(), true) {
                Engine.Searcher internal = readOnlyEngine.acquireSearcher("test", Engine.SearcherScope.INTERNAL);
                assertThat(readOnlyEngine.translogManager().getTranslogStats().getUncommittedOperations(), equalTo(0));
        IOUtils.close(engine, store);
                TranslogHandler translogHandler = createTranslogHandler(config.getIndexSettings(), recoveringEngine);
 * The OpenSearch Contributors require contributions made to
                lastDocIds = getDocIds(engine, true);
                    .recoverFromTranslog(translogHandler, readOnlyEngine.getProcessedLocalCheckpoint(), randomNonNegativeLong());
import org.opensearch.index.store.Store;
public class ReadOnlyEngineTests extends EngineTestCase {
 * not use this file except in compliance with the License.
            final int numDocs = frequently() ? scaledRandomIntBetween(10, 200) : 0;
 * the Apache License, Version 2.0 (the "License"); you may
                } catch (final IllegalStateException e) {
                for (int i = 0; i < numDocs; i++) {
                IndexReader.CacheHelper helper = esReader.getReaderCacheHelper();
                        new Engine.Index(
 * Licensed to Elasticsearch under one or more contributor
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
            }
                globalCheckpoint.set(randomLongBetween(globalCheckpoint.get(), engine.getPersistedLocalCheckpoint()));
            EngineConfig config = config(defaultSettings, store, createTempDir(), newMergePolicy(), null, null, globalCheckpoint::get);
                assertThat(readOnlyEngine.getProcessedLocalCheckpoint(), equalTo(readOnlyEngine.getPersistedLocalCheckpoint()));
    public void testReadOnlyEngine() throws Exception {
import static org.opensearch.common.lucene.index.OpenSearchDirectoryReader.getOpenSearchDirectoryReader;
                assertThat(
 * software distributed under the License is distributed on an
        }
                    true
import org.apache.lucene.index.IndexReader;
        } finally {
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
    }
import org.apache.lucene.tests.util.LuceneTestCase;
                assertThat(engine.translogManager().getTranslogStats().getEarliestLastModifiedAge(), greaterThan(0L));
                        engine.flush();
                engine.translogManager().syncTranslog();
                engine.flushAndClose();
            int uncommittedDocs = 0;
                expectThrows(expectedException, () -> readOnlyEngine.index(null));
        }
                engine.flushAndClose();
                    globalCheckpoint.set(randomLongBetween(globalCheckpoint.get(), engine.getPersistedLocalCheckpoint()));
                    if (rarely()) {
                recoveringEngine.translogManager()
            // Close and reopen the main engine
                expectThrows(expectedException, () -> readOnlyEngine.delete(null));
                    exception.getMessage(),
                    fail("Read-only engine pre-closing verifications failed");
                            System.nanoTime(),
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
            }
 */
    public void testVerifyShardBeforeIndexClosingIsNoOp() throws IOException {
                }
                    .recoverFromTranslog(translogHandler, recoveringEngine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
                assertThat(engine.translogManager().getTranslogStats().getTranslogSizeInBytes(), greaterThan(0L));
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
                            System.nanoTime(),
                            SequenceNumbers.UNASSIGNED_SEQ_NO,
                        engine.flush();
    public void testReadOnly() throws IOException {
import java.io.IOException;
                assertThat(getDocIds(readOnlyEngine, false), equalTo(lastDocIds));
            }
                assertThat(readOnlyEngine.translogManager().getTranslogStats().getEarliestLastModifiedAge(), greaterThan(0L));
import java.util.function.Function;
                        )
                            return true;
            try (InternalEngine recoveringEngine = new InternalEngine(config)) {
        }
package org.opensearch.index.engine;
                for (int i = 0; i < numDocs; i++) {
            final int numDocs = scaledRandomIntBetween(10, 100);
                    )
                        uncommittedDocs += 1;
            store.createEmpty(Version.CURRENT.luceneVersion);
                for (int i = 0; i < numDocs; i++) {
                            Engine.Operation.Origin.REPLICA,
                assertThat(readOnlyEngine.getPersistedLocalCheckpoint(), equalTo(lastSeqNoStats.getLocalCheckpoint()));
                            -1,
            final SeqNoStats lastSeqNoStats;
     * Test that {@link ReadOnlyEngine#verifyEngineBeforeIndexClosing()} never fails
                assertThat(
                            doc,
            EngineConfig config = config(defaultSettings, store, createTempDir(), newMergePolicy(), null, null, globalCheckpoint::get);
                            SequenceNumbers.UNASSIGNED_SEQ_NO,
    }
}
                    globalCheckpoint.set(i);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
                            null,
            final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
import java.nio.file.Path;
                globalCheckpoint.set(engine.getPersistedLocalCheckpoint() - 1);
/*
import org.apache.lucene.index.IndexFormatTooOldException;
                OpenSearchDirectoryReader esReader = getOpenSearchDirectoryReader(dirReader);
                            newUid(doc),
            final boolean softDeletesEnabled = config.getIndexSettings().isSoftDeleteEnabled();
                    }
                    IllegalStateException.class,
                assertThat(readOnlyEngine.getSeqNoStats(globalCheckpoint.get()).getMaxSeqNo(), equalTo(lastSeqNoStats.getMaxSeqNo()));
                    }
                            null,
    /**
import static org.hamcrest.Matchers.instanceOf;
                            // we don't want the assertion to trip in this test
            }
                    engine.index(
 */
                    ? AssertionError.class
                    Function.identity(),
                IOUtils.close(external, internal);
                            -1,
 */
        try (Store store = createStore()) {
                assertThat(readOnlyEngine.getSeqNoStats(globalCheckpoint.get()).getMaxSeqNo(), equalTo(lastSeqNoStats.getMaxSeqNo()));
                        @Override
                            0
                assertThat(engine.translogManager().getTranslogStats().getUncommittedOperations(), equalTo(uncommittedDocs));
import org.opensearch.index.mapper.ParsedDocument;
            }
                // the locked down engine should still point to the previous commit
                );
                assertThat(readOnlyEngine.translogManager().getTranslogStats().getUncommittedSizeInBytes(), greaterThan(0L));
                            primaryTerm.get(),
                assertSame(external.getIndexReader(), internal.getIndexReader());
 * this work for additional information regarding copyright
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
                Engine.Searcher external = readOnlyEngine.acquireSearcher("test", Engine.SearcherScope.EXTERNAL);
                            0
        IOUtils.close(engine, store);
                new ReadOnlyEngine(config, null, new TranslogStats(), true, Function.identity(), true);
            }
                    readOnlyEngine.translogManager().getTranslogStats().estimatedNumberOfOperations(),
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.Version;
                }
                }
import org.opensearch.index.seqno.SequenceNumbers;
 * SPDX-License-Identifier: Apache-2.0
            final List<DocIdSeqNoAndSource> lastDocIds;
        IOUtils.close(engine, store);
                    engine.translogManager().getTranslogStats().estimatedNumberOfOperations(),
                assertThat(readOnlyEngine.getPersistedLocalCheckpoint(), equalTo(lastSeqNoStats.getLocalCheckpoint()));
            try (InternalEngine engine = createEngine(config)) {
        IOUtils.close(engine, store);
 * ownership. Elasticsearch licenses this file to you under
        // The index has one document in it, so the checkpoint cannot be NO_OPS_PERFORMED
                            doc,
    }
import org.opensearch.index.seqno.SeqNoStats;
                            + maxSeqNo
                            + "]"
                    : UnsupportedOperationException.class;
        }
            int numDocs = scaledRandomIntBetween(10, 1000);
        try (Store store = createStore(newFSDirectory(tmp))) {
 * compatible open source license.
import org.opensearch.common.util.io.IOUtils;
                    ParsedDocument doc = testParsedDocument(Integer.toString(i), null, testDocument(), new BytesArray("{}"), null);
                        get = newGet(randomBoolean(), doc);
                            Engine.Operation.Origin.REPLICA,
                            1,
 * under the License.
                engine.translogManager().syncTranslog();
import static org.hamcrest.Matchers.equalTo;
     * whatever the value of the global checkpoint to check is.
                assertThat(readOnlyEngine.getPersistedLocalCheckpoint(), equalTo(lastSeqNoStats.getLocalCheckpoint()));
                final TranslogHandler translogHandler = new TranslogHandler(xContentRegistry(), config.getIndexSettings(), readOnlyEngine);
                    maxSeqNo = engine.getProcessedLocalCheckpoint();
                    engine.getSeqNoStats(globalCheckpoint.get()),
                        )
                            -1,
    }
            EngineConfig config = config(defaultSettings, store, createTempDir(), newMergePolicy(), null, null, globalCheckpoint::get);
                            0
                        }
                            false,
                    engine.engineConfig,
                    if (rarely()) {
            EngineConfig config = config(defaultSettings, store, createTempDir(), newMergePolicy(), null, null, globalCheckpoint::get);
                );
    public void testReadOldIndicesFailure() throws IOException {
                    ParsedDocument doc = testParsedDocument(Integer.toString(i), null, testDocument(), new BytesArray("{}"), null);
        }
    public void testTranslogStats() throws IOException {
                    equalTo(
        IOUtils.close(engine, store);
                            primaryTerm.get(),
                        )
                try (Engine.GetResult getResult = readOnlyEngine.get(get, readOnlyEngine::acquireSearcher)) {
                }
                assertThat(readOnlyEngine.getSeqNoStats(globalCheckpoint.get()).getMaxSeqNo(), equalTo(lastSeqNoStats.getMaxSeqNo()));
            try {
                assertEquals(helper.getKey(), dirReader.getReaderCacheHelper().getKey());
                // the locked down engine should still point to the previous commit
                expectThrows(expectedException, () -> readOnlyEngine.noOp(null));
                            i,
import org.apache.lucene.index.DirectoryReader;
            try (InternalEngine engine = createEngine(config)) {
                            newUid(doc),
                            0
                            System.nanoTime(),
                    equalTo(softDeletesEnabled ? 0 : numDocs)
import java.util.concurrent.atomic.AtomicLong;
                assertThat(
 * specific language governing permissions and limitations
        }
import static org.hamcrest.Matchers.greaterThan;
                    }
                    );
                assertThat(readOnlyEngine.getProcessedLocalCheckpoint(), equalTo(readOnlyEngine.getPersistedLocalCheckpoint()));
import java.util.List;
                engine.flush(true, true);
                            doc,
            }
                assertEquals(IndexFormatTooOldException.class, e.getCause().getClass());
                    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * GitHub history for details.
        try (Store store = createStore()) {
                }
            } catch (UncheckedIOException e) {
                    false,
                    ParsedDocument doc = testParsedDocument(Integer.toString(i), null, testDocument(), new BytesArray("{}"), null);
        IOUtils.close(engine, store);
                globalCheckpoint.set(randomNonNegativeLong());
            try (ReadOnlyEngine readOnlyEngine = new ReadOnlyEngine(config, null, null, true, Function.identity(), true)) {
                            null,
                        "Maximum sequence number ["
 *
                assertThat(translogHandler.appliedOperations(), equalTo(0L));
            }
                    }
            try (InternalEngine engine = createEngine(config)) {
                        )
                    engine.index(
                            false,
                    );
        try (Store store = createStore()) {
                            primaryTerm.get(),
                            false,
                readOnlyEngine = new ReadOnlyEngine(
        try (Store store = createStore()) {
                );
            }
                    if (rarely()) {
                            primaryTerm.get(),
     */
                assertThat(external.getIndexReader(), instanceOf(DirectoryReader.class));
            EngineConfig config = config(defaultSettings, store, createTempDir(), newMergePolicy(), null, null, globalCheckpoint::get);
        }
            try (ReadOnlyEngine readOnlyEngine = new ReadOnlyEngine(config, null, new TranslogStats(), true, Function.identity(), true)) {
                    );
                }
                for (int i = 0; i < numDocs; i++) {
    }
                    engine.translogManager().getTranslogStats(),
 * You may obtain a copy of the License at
 * Unless required by applicable law or agreed to in writing,
            try (ReadOnlyEngine readOnlyEngine = new ReadOnlyEngine(config, null, null, true, Function.identity(), true)) {
                        engine.flush();
                            1,
/*
                for (int i = 0; i < numDocs; i++) {
                DirectoryReader dirReader = external.getDirectoryReader();
                        engine.flush();
                engine.translogManager().syncTranslog();
                        engine.delete(new Engine.Delete(delId, newUid(delId), primaryTerm.get()));
                            + "] from last commit does not match global checkpoint ["
                            Engine.Operation.Origin.REPLICA,
import org.apache.lucene.tests.util.TestUtil;
                assertNotNull(helper);
import org.opensearch.common.lucene.LuceneTests;
import java.io.UncheckedIOException;
/*
    public void testEnsureMaxSeqNoIsEqualToGlobalCheckpoint() throws IOException {
                    globalCheckpoint.set(i);
                IllegalStateException exception = expectThrows(
                            Engine.Operation.Origin.REPLICA,
                        protected boolean assertMaxSeqNoEqualsToGlobalCheckpoint(final long maxSeqNo, final long globalCheckpoint) {
            EngineConfig config = config(defaultSettings, store, createTempDir(), newMergePolicy(), null, null, globalCheckpoint::get);
                            newUid(doc),
                long maxSeqNo = SequenceNumbers.NO_OPS_PERFORMED;
import org.opensearch.index.translog.TranslogStats;
                lastSeqNoStats = engine.getSeqNoStats(globalCheckpoint.get());
            EngineConfig config = config(defaultSettings, store, createTempDir(), newMergePolicy(), null, null, globalCheckpoint::get);
                assertThat(getDocIds(readOnlyEngine, false), equalTo(lastDocIds));
                    readOnlyEngine.verifyEngineBeforeIndexClosing();
                    } else {
                        new Engine.Index(
    }
                            SequenceNumbers.UNASSIGNED_SEQ_NO,
 * KIND, either express or implied.  See the License for the
            try (ReadOnlyEngine readOnlyEngine = new ReadOnlyEngine(config, null, new TranslogStats(), true, Function.identity(), true)) {
        try (Store store = createStore()) {
                            i,
                    );
        IOUtils.close(engine, store);
                            + globalCheckpoint.get()
                readOnlyEngine.translogManager()
        TestUtil.unzip(getClass().getResourceAsStream(LuceneTests.OLDER_VERSION_INDEX_ZIP_RELATIVE_PATH), tmp);
                    }
                    if (randomBoolean()) {
                    assertTrue(getResult.exists());
                engine.flush();
    public void testRecoverFromTranslogAppliesNoOperations() throws IOException {
 *
                            SequenceNumbers.UNASSIGNED_SEQ_NO,
        final AtomicLong globalCheckpoint = new AtomicLong(0);
                            doc,
                            1,
                            newUid(doc),
            try (InternalEngine engine = createEngine(config)) {
                assertThat(getDocIds(readOnlyEngine, false), equalTo(lastDocIds));
                );
                            false,
import org.opensearch.core.common.bytes.BytesArray;
                    equalTo(softDeletesEnabled ? uncommittedDocs : numDocs)
                assertThat(engine.translogManager().getTranslogStats().getUncommittedSizeInBytes(), greaterThan(0L));
                        new Engine.Index(
                    if (get == null || rarely()) {
                );
                            i,
            store.createEmpty(Version.CURRENT.luceneVersion);
                assertThat(readOnlyEngine.getProcessedLocalCheckpoint(), equalTo(readOnlyEngine.getPersistedLocalCheckpoint()));
                            -1,
            IOUtils.close(readOnlyEngine);
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
