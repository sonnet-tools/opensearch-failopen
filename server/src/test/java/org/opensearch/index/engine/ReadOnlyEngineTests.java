                            Engine.Operation.Origin.REPLICA,
                Class<? extends Throwable> expectedException = LuceneTestCase.TEST_ASSERTS_ENABLED  
                try {
            EngineConfig config = config(defaultSettings, store, createTempDir(), newMergePolicy(), null, null, globalCheckpoint::get);
        try (Store store = createStore()) {
                for (int i = 0; i < numDocs; i++) {
                Engine.Get get = null;
            try (InternalEngine engine = createEngine(config)) {
        }
 * GitHub history for details.
                assertThat(readOnlyEngine.getSeqNoStats(globalCheckpoint.get()).getMaxSeqNo(), equalTo(lastSeqNoStats.getMaxSeqNo()));
                    readOnlyEngine.verifyEngineBeforeIndexClosing();  
            } catch (UncheckedIOException e) {
/*
        try (Store store = createStore()) {  
import java.nio.file.Path;  
        }
                        engine.flush();  
                // the locked down engine should still point to the previous commit
                            1,
 * the Apache License, Version 2.0 (the "License"); you may
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
            // Close and reopen the main engine
                    : UnsupportedOperationException.class;
     * Test that {@link ReadOnlyEngine#verifyEngineBeforeIndexClosing()} never fails  
                    } else {
            }
                            System.nanoTime(),  
                assertThat(readOnlyEngine.getPersistedLocalCheckpoint(), equalTo(lastSeqNoStats.getLocalCheckpoint()));  
                assertThat(readOnlyEngine.getPersistedLocalCheckpoint(), equalTo(lastSeqNoStats.getLocalCheckpoint()));
                    if (rarely()) {  
                assertThat(engine.translogManager().getTranslogStats().getUncommittedSizeInBytes(), greaterThan(0L));
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);  
                            System.nanoTime(),
                    readOnlyEngine.translogManager().getTranslogStats().estimatedNumberOfOperations(),  
                );  
                    engine.getSeqNoStats(globalCheckpoint.get()),  
                            return true;
                IndexReader.CacheHelper helper = esReader.getReaderCacheHelper();  
                assertThat(
                            primaryTerm.get(),  
 * SPDX-License-Identifier: Apache-2.0
                    engine.engineConfig,
                            primaryTerm.get(),
                readOnlyEngine = new ReadOnlyEngine(
                    ParsedDocument doc = testParsedDocument(Integer.toString(i), null, testDocument(), new BytesArray("{}"), null);  
                            0  
                            0
import org.apache.lucene.tests.util.LuceneTestCase;  
                        )
 * Unless required by applicable law or agreed to in writing,
            EngineConfig config = config(defaultSettings, store, createTempDir(), newMergePolicy(), null, null, globalCheckpoint::get);
                            SequenceNumbers.UNASSIGNED_SEQ_NO,
                    false,
                            newUid(doc),
                        get = newGet(randomBoolean(), doc);  
                            i,
                assertThat(readOnlyEngine.getPersistedLocalCheckpoint(), equalTo(lastSeqNoStats.getLocalCheckpoint()));
 *
            EngineConfig config = config(defaultSettings, store, createTempDir(), newMergePolicy(), null, null, globalCheckpoint::get);
import java.util.List;
                    ParsedDocument doc = testParsedDocument(Integer.toString(i), null, testDocument(), new BytesArray("{}"), null);
                recoveringEngine.translogManager()
                OpenSearchDirectoryReader esReader = getOpenSearchDirectoryReader(dirReader);
                    equalTo(softDeletesEnabled ? 0 : numDocs)
                        new Engine.Index(
    }  
                    globalCheckpoint.set(randomLongBetween(globalCheckpoint.get(), engine.getPersistedLocalCheckpoint()));
                assertThat(readOnlyEngine.getSeqNoStats(globalCheckpoint.get()).getMaxSeqNo(), equalTo(lastSeqNoStats.getMaxSeqNo()));
    public void testRecoverFromTranslogAppliesNoOperations() throws IOException {
                assertThat(readOnlyEngine.getProcessedLocalCheckpoint(), equalTo(readOnlyEngine.getPersistedLocalCheckpoint()));  
                    true
import org.apache.lucene.tests.util.TestUtil;
                            false,  
/*  
                    if (rarely()) {
            store.createEmpty(Version.CURRENT.luceneVersion);
 */
                            System.nanoTime(),
                globalCheckpoint.set(randomNonNegativeLong());
                    if (get == null || rarely()) {
                        String delId = Integer.toString(i);
                            false,
                assertThat(readOnlyEngine.translogManager().getTranslogStats().getTranslogSizeInBytes(), greaterThan(0L));
            try (ReadOnlyEngine readOnlyEngine = new ReadOnlyEngine(config, null, new TranslogStats(), true, Function.identity(), true)) {  
                    () -> new ReadOnlyEngine(config, null, null, true, Function.identity(), true) {
                }
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
            final SeqNoStats lastSeqNoStats;
                            newUid(doc),  
import org.opensearch.index.seqno.SequenceNumbers;  
                    ParsedDocument doc = testParsedDocument(Integer.toString(i), null, testDocument(), new BytesArray("{}"), null);  
                            System.nanoTime(),
                        "Maximum sequence number ["  
                long maxSeqNo = SequenceNumbers.NO_OPS_PERFORMED;
 *     http://www.apache.org/licenses/LICENSE-2.0
                assertThat(readOnlyEngine.getProcessedLocalCheckpoint(), equalTo(readOnlyEngine.getPersistedLocalCheckpoint()));  
        IOUtils.close(engine, store);  
                    assertTrue(getResult.exists());
                assertThat(readOnlyEngine.translogManager().getTranslogStats().getUncommittedOperations(), equalTo(0));  
                for (int i = 0; i < numDocs; i++) {
    }  
                Engine.Searcher internal = readOnlyEngine.acquireSearcher("test", Engine.SearcherScope.INTERNAL);
                        uncommittedDocs = 0;
                            -1,  
import org.apache.lucene.index.IndexReader;
                    engine.index(
                }  
                assertThat(
                            newUid(doc),  
import java.io.UncheckedIOException;
                    }
                TranslogHandler translogHandler = createTranslogHandler(config.getIndexSettings(), recoveringEngine);
                    }
import org.opensearch.index.seqno.SeqNoStats;
        IOUtils.close(engine, store);
            int uncommittedDocs = 0;
                            i,
            }
                            1,  
 * this file be licensed under the Apache-2.0 license or a
                    if (rarely()) {
                    IllegalStateException.class,  
import static org.hamcrest.Matchers.instanceOf;
                engine.flush(true, true);
                assertThat(  
 * KIND, either express or implied.  See the License for the
                final TranslogHandler translogHandler = new TranslogHandler(xContentRegistry(), config.getIndexSettings(), readOnlyEngine);  
                        engine.flush();  
                    engine.translogManager().getTranslogStats().estimatedNumberOfOperations(),
 * license agreements. See the NOTICE file distributed with
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                            false,
            }
                );
                            Engine.Operation.Origin.REPLICA,  
                        engine.flush();  
            }
                expectThrows(expectedException, () -> readOnlyEngine.noOp(null));
                lastDocIds = getDocIds(engine, true);
    }
                            primaryTerm.get(),  
                    globalCheckpoint.set(i);
                            doc,
                            false,  
                );
    public void testReadOnly() throws IOException {
                expectThrows(expectedException, () -> readOnlyEngine.delete(null));
                assertThat(readOnlyEngine.getSeqNoStats(globalCheckpoint.get()).getMaxSeqNo(), equalTo(lastSeqNoStats.getMaxSeqNo()));
                            SequenceNumbers.UNASSIGNED_SEQ_NO,  
                    equalTo(
                    )
        Path tmp = createTempDir();
public class ReadOnlyEngineTests extends EngineTestCase {
                engine.flushAndClose();  
                    }
        IOUtils.close(engine, store);
            try (ReadOnlyEngine readOnlyEngine = new ReadOnlyEngine(config, null, new TranslogStats(), true, Function.identity(), true)) {
            IOUtils.close(readOnlyEngine);
                assertThat(readOnlyEngine.translogManager().getTranslogStats().getEarliestLastModifiedAge(), greaterThan(0L));  
                    engine.index(
 * Modifications Copyright OpenSearch Contributors. See  
                }  
        // The index has one document in it, so the checkpoint cannot be NO_OPS_PERFORMED  
        }
    }  
            final boolean softDeletesEnabled = config.getIndexSettings().isSoftDeleteEnabled();
 * ownership. Elasticsearch licenses this file to you under  
                    engine.index(  
                for (int i = 0; i < numDocs; i++) {  
                    exception.getMessage(),
import org.opensearch.Version;
                            newUid(doc),
 *  
        IOUtils.close(engine, store);
                            null,
 */  
                            1,
                            0
        try (Store store = createStore()) {
     * whatever the value of the global checkpoint to check is.
    public void testVerifyShardBeforeIndexClosingIsNoOp() throws IOException {  
                }  
        IOUtils.close(engine, store);
                        engine.delete(new Engine.Delete(delId, newUid(delId), primaryTerm.get()));  
                            1,
import java.io.IOException;
        IOUtils.close(engine, store);  
import java.util.function.Function;  
import org.opensearch.common.lucene.LuceneTests;  
                for (int i = 0; i < numDocs; i++) {  
                    Function.identity(),  
                assertThat(external.getIndexReader(), instanceOf(DirectoryReader.class));  
    /**
                    if (randomBoolean()) {
                            null,  
                assertThat(readOnlyEngine.translogManager().getTranslogStats().getUncommittedSizeInBytes(), greaterThan(0L));
 * You may obtain a copy of the License at  
                            i,
            store.createEmpty(Version.CURRENT.luceneVersion);
                        )  
                assertThat(engine.translogManager().getTranslogStats().getEarliestLastModifiedAge(), greaterThan(0L));
            int numDocs = scaledRandomIntBetween(10, 1000);
import org.apache.lucene.index.DirectoryReader;  
 * software distributed under the License is distributed on an
                IllegalStateException exception = expectThrows(
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
            }
                            -1,
                    ? AssertionError.class
                        new Engine.Index(
                        @Override
                            Engine.Operation.Origin.REPLICA,
                            + "]"
        }
}
                    globalCheckpoint.set(i);  
            try (InternalEngine engine = createEngine(config)) {  
                assertThat(translogHandler.appliedOperations(), equalTo(0L));
                try (Engine.GetResult getResult = readOnlyEngine.get(get, readOnlyEngine::acquireSearcher)) {
import static org.hamcrest.Matchers.equalTo;  
                            + maxSeqNo
                    );  
                assertEquals(helper.getKey(), dirReader.getReaderCacheHelper().getKey());
                    }
            }  
                    .recoverFromTranslog(translogHandler, recoveringEngine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);  
                        protected boolean assertMaxSeqNoEqualsToGlobalCheckpoint(final long maxSeqNo, final long globalCheckpoint) {  
                engine.flush();  
                assertSame(external.getIndexReader(), internal.getIndexReader());
            }
            EngineConfig config = config(defaultSettings, store, createTempDir(), newMergePolicy(), null, null, globalCheckpoint::get);
                for (int i = 0; i < numDocs; i++) {
                            doc,
                }
                        new Engine.Index(
    public void testTranslogStats() throws IOException {  
import java.util.concurrent.atomic.AtomicLong;
 */
            try (InternalEngine engine = createEngine(config)) {  
                            null,
                        uncommittedDocs += 1;  
                IOUtils.close(external, internal);
                assertNotNull(helper);
                assertThat(getDocIds(readOnlyEngine, false), equalTo(lastDocIds));  
                expectThrows(expectedException, () -> readOnlyEngine.index(null));  
                globalCheckpoint.set(engine.getPersistedLocalCheckpoint() - 1);
 * this work for additional information regarding copyright
        Engine readOnlyEngine = null;
import org.opensearch.index.translog.TranslogStats;
                    engine.index(
 * The OpenSearch Contributors require contributions made to  
                            -1,
                // the locked down engine should still point to the previous commit
                            doc,
            final int numDocs = scaledRandomIntBetween(10, 100);
                    );
            try (ReadOnlyEngine readOnlyEngine = new ReadOnlyEngine(config, null, null, true, Function.identity(), true)) {
                    .recoverFromTranslog(translogHandler, readOnlyEngine.getProcessedLocalCheckpoint(), randomNonNegativeLong());
import static org.hamcrest.Matchers.greaterThan;
import org.apache.lucene.index.IndexFormatTooOldException;
                assertThat(engine.translogManager().getTranslogStats().getTranslogSizeInBytes(), greaterThan(0L));  
                globalCheckpoint.set(randomLongBetween(globalCheckpoint.get(), engine.getPersistedLocalCheckpoint()));
            EngineConfig config = config(defaultSettings, store, createTempDir(), newMergePolicy(), null, null, globalCheckpoint::get);  
                    );
                    }
                            primaryTerm.get(),
 * compatible open source license.
import org.opensearch.core.common.bytes.BytesArray;  
                            + "] from last commit does not match global checkpoint ["
                            SequenceNumbers.UNASSIGNED_SEQ_NO,
                }
                lastSeqNoStats = engine.getSeqNoStats(globalCheckpoint.get());  
                engine.flushAndClose();  
        }
                    engine.translogManager().getTranslogStats(),
        try (Store store = createStore()) {
                            + globalCheckpoint.get()  
    public void testEnsureMaxSeqNoIsEqualToGlobalCheckpoint() throws IOException {  
                            doc,  
import org.opensearch.index.store.Store;
            final List<DocIdSeqNoAndSource> lastDocIds;
            }
                assertEquals(IndexFormatTooOldException.class, e.getCause().getClass());  
                new ReadOnlyEngine(config, null, new TranslogStats(), true, Function.identity(), true);
            final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);  
                    ParsedDocument doc = testParsedDocument(Integer.toString(i), null, testDocument(), new BytesArray("{}"), null);
                assertThat(engine.translogManager().getTranslogStats().getUncommittedOperations(), equalTo(uncommittedDocs));
                            // we don't want the assertion to trip in this test
                    fail("Read-only engine pre-closing verifications failed");
                assertThat(readOnlyEngine.getProcessedLocalCheckpoint(), equalTo(readOnlyEngine.getPersistedLocalCheckpoint()));
            try {  
                            -1,
            try (InternalEngine recoveringEngine = new InternalEngine(config)) {  
                    );
    }  
                assertThat(getDocIds(readOnlyEngine, false), equalTo(lastDocIds));
        try (Store store = createStore()) {
package org.opensearch.index.engine;
            try (InternalEngine engine = createEngine(config)) {  
 * under the License.  
                engine.translogManager().syncTranslog();
            int numDocs = scaledRandomIntBetween(10, 1000);  
                );
        try (Store store = createStore()) {  
                engine.translogManager().syncTranslog();
                readOnlyEngine.translogManager()
    public void testReadOldIndicesFailure() throws IOException {
 * specific language governing permissions and limitations
                    }
                        engine.flush();
            final int numDocs = frequently() ? scaledRandomIntBetween(10, 200) : 0;  
/*
 *
        IOUtils.close(engine, store);
                            i,  
 * not use this file except in compliance with the License.
import static org.opensearch.common.lucene.index.OpenSearchDirectoryReader.getOpenSearchDirectoryReader;
        } finally {
        }  
import org.opensearch.index.mapper.ParsedDocument;
                    }
                } catch (final IllegalStateException e) {
 * Licensed to Elasticsearch under one or more contributor  
        TestUtil.unzip(getClass().getResourceAsStream(LuceneTests.OLDER_VERSION_INDEX_ZIP_RELATIVE_PATH), tmp);  
            try (ReadOnlyEngine readOnlyEngine = new ReadOnlyEngine(config, null, null, true, Function.identity(), true)) {
                        )  
                    maxSeqNo = engine.getProcessedLocalCheckpoint();
    public void testReadOnlyEngine() throws Exception {  
            EngineConfig config = config(defaultSettings, store, createTempDir(), newMergePolicy(), null, null, globalCheckpoint::get);  
import org.opensearch.common.util.io.IOUtils;
                        }  
        try (Store store = createStore(newFSDirectory(tmp))) {
                DirectoryReader dirReader = external.getDirectoryReader();
            EngineConfig config = config(defaultSettings, store, createTempDir(), newMergePolicy(), null, null, globalCheckpoint::get);
        final AtomicLong globalCheckpoint = new AtomicLong(0);
                        )
                            null,
                );
                        new Engine.Index(  
                assertThat(getDocIds(readOnlyEngine, false), equalTo(lastDocIds));
                engine.translogManager().syncTranslog();
                }  
    }
    }
                            SequenceNumbers.UNASSIGNED_SEQ_NO,
        }  
            }
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
                    if (rarely()) {
                            Engine.Operation.Origin.REPLICA,  
            }  
                    equalTo(softDeletesEnabled ? uncommittedDocs : numDocs)  
                Engine.Searcher external = readOnlyEngine.acquireSearcher("test", Engine.SearcherScope.EXTERNAL);  
                            0
