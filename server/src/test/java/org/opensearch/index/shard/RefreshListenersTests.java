            assertEquals(0, listeners.pendingCount());
            DummyRefreshListener listener = new DummyRefreshListener();
                        Engine.Get get = new Engine.Get(false, false, threadId, new Term(IdFieldMapper.NAME, threadId));
    }
        }
/*
            translogConfig.getTranslogPath(),
                }
        for (int thread = 0; thread < threadCount; thread++) {
        engine.refresh("I said so");
                            assertTrue("document not found", getResult.exists());
        engine.refresh("I said so");
import org.opensearch.core.index.shard.ShardId;
    }
        );
                for (int iteration = 1; iteration <= 50; iteration++) {
     */
        assertTrue(listeners.addOrNotify(index.getTranslogLocation(), listener));
        assertEquals(0, listeners.pendingCount());
/*
                        }
 * compatible open source license.
     * Uses a bunch of threads to index, wait for refresh, and non-realtime get documents to validate that they are visible after waiting
        ShardId shardId = new ShardId(new Index("index", "_na_"), 1);
    }
        DummyRefreshListener forcingListener = new DummyRefreshListener();
            .mergePolicy(newMergePolicy())
    private Engine engine;
 * KIND, either express or implied.  See the License for the
            if (error != null) {
import org.opensearch.common.lucene.uid.Versions;
                listener = new DummyRefreshListener();
        document.add(seqID.primaryTerm);
 *
            assertTrue(listener.forcedRefresh.get());
    private static class DummyRefreshListener implements Consumer<Boolean> {
 * this file be licensed under the Apache-2.0 license or a
    }
            null,
import java.util.concurrent.atomic.AtomicReference;
            index(randomFrom("1" /* same document */, "2" /* different document */));
import org.opensearch.common.util.io.IOUtils;
        listeners = new RefreshListeners(
import org.opensearch.common.util.BigArrays;
            MediaTypeRegistry.JSON,
        assertEquals(0, listeners.pendingCount());
            .queryCachingPolicy(IndexSearcher.getDefaultQueryCachingPolicy())
            } catch (Exception e) {
        public void assertNoError() {
        BytesReference source = new BytesArray(new byte[] { 1 });
import java.util.Arrays;
package org.opensearch.index.shard;
            // If you add a listener for an already refreshed location then it'll just fire even if closed
                    assertBusy(() -> assertNotNull(listener.forcedRefresh.get()), 1, TimeUnit.MINUTES);
 * not use this file except in compliance with the License.
                        listener.assertNoError();
        final String translogUUID = Translog.createEmptyTranslog(
    public void testDisallowAddListeners() throws Exception {
import org.apache.lucene.index.IndexWriterConfig;
        Engine.IndexResult refreshedOperation = index("1");
        final long primaryTerm = randomNonNegativeLong();
        int threadCount = between(3, 10);
    public void tearDownListeners() throws Exception {
            Arrays.asList(document),
import org.opensearch.index.IndexSettings;
        assertEquals(0, listeners.pendingCount());
import org.opensearch.index.engine.Engine;
 * The OpenSearch Contributors require contributions made to
                    try {
        Document document = new Document();
import org.opensearch.threadpool.TestThreadPool;
                error = e;
        for (DummyRefreshListener listener : nonForcedListeners) {
        assertEquals(1, listeners.pendingCount());
        engine.refresh("I said so");
        // Add one more listener which should cause a refresh.
            assertEquals(0, listeners.pendingCount());
import org.opensearch.test.DummyShardLock;
        for (Thread indexer : indexers) {
import org.junit.Before;
            createTempDir("translog"),
            .tombstoneDocSupplier(EngineTestCase.tombstoneDocSupplier())
                engine.refresh("test");
        }
            .internalRefreshListener(Collections.emptyList())
        Field idField = new Field("_id", id, IdFieldMapper.Defaults.FIELD_TYPE);
            .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)
import org.opensearch.index.store.Store;
import org.apache.lucene.document.TextField;
            }
    public void testLotsOfThreads() throws Exception {
 * software distributed under the License is distributed on an
        DummyRefreshListener listener = new DummyRefreshListener();
        String allocationId = UUIDs.randomBase64UUID(random());
            logger,
                }
    }
            assertFalse(listeners.refreshNeeded());
            .analyzer(iwc.getAnalyzer())
        assertFalse(listener.forcedRefresh.get());
import java.util.ArrayList;
        );
    private Store store;
import org.opensearch.threadpool.ThreadPool;
    public void testContextIsPreserved() throws IOException, InterruptedException {
        listener.assertNoError();
        }
import java.util.concurrent.CountDownLatch;
        SeqNoFieldMapper.SequenceIDFields seqID = SeqNoFieldMapper.SequenceIDFields.emptySeqID();
import org.opensearch.index.mapper.ParsedDocument;
        );
            source,
import static org.hamcrest.Matchers.arrayContaining;
import org.opensearch.common.unit.TimeValue;
        // This thread just refreshes every once in a while to cause trouble.
        return index(id, "test");
    }
        CountDownLatch latch = new CountDownLatch(1);
            assertEquals(0, listeners.pendingCount());
            .store(store)
            // But adding a listener to a non-refreshed location will fail
        assertEquals(0, listeners.pendingCount());
import org.apache.lucene.index.Term;
            for (int i = 0; i < 100; i++) {
            .externalRefreshListener(Collections.singletonList(listeners))
            assertNull(listener.forcedRefresh.get());
            .globalCheckpointSupplier(() -> SequenceNumbers.NO_OPS_PERFORMED)
        document.add(versionField);
                Boolean oldValue = this.forcedRefresh.getAndSet(forcedRefresh);
        Engine.EventListener eventListener = new Engine.EventListener() {
        assertEquals(0, listeners.pendingCount());
        terminate(threadPool);
 *
        }
        document.add(new TextField("test", testFieldValue, Field.Store.YES));
            .build();
import org.opensearch.threadpool.ThreadPool.Names;
            BigArrays.NON_RECYCLING_INSTANCE,
            null
                            assertThat(document.getValues("test"), arrayContaining(testFieldValue));
import org.opensearch.index.mapper.ParseContext.Document;
            assertFalse(listener.forcedRefresh.get());
        maxListeners = between(1, threadCount * 2);
    public void testClose() throws Exception {
        store.associateIndexWithNewTranslog(translogUUID);
        assertEquals(maxListeners, listeners.pendingCount());
        }
    private ThreadPool threadPool;
                        try (Engine.GetResult getResult = engine.get(get, engine::acquireSearcher)) {
            .primaryTermSupplier(() -> primaryTerm)
        /**
import org.opensearch.index.engine.EngineTestCase;
                    }
            nonForcedListeners.add(listener);
                engine.refresh("I said so");
            assertNull(listener.forcedRefresh.get());
        refreshMetric = new MeanMetric();
                () -> listeners.addOrNotify(unrefreshedOperation.getTranslogLocation(), listener)
            assertFalse(listener.forcedRefresh.get());
        latch.await();
                        assertBusy(() -> assertNotNull("listener never called", listener.forcedRefresh.get()), 1, TimeUnit.MINUTES);
        ParsedDocument doc = new ParsedDocument(
import org.opensearch.core.common.bytes.BytesArray;
            assertTrue(listeners.addOrNotify(index("1").getTranslogLocation(), listener));
        // That forces all the listeners through. It would be on the listener ThreadPool but we've made all of those execute immediately.
 */
        assertEquals(1, listeners.pendingCount());
        try (ThreadContext.StoredContext ignore = threadPool.getThreadContext().stashContext()) {
                        assertEquals(iteration, index.getVersion());
        );
        try {
    public void testBeforeRefresh() throws Exception {
                        listeners.addOrNotify(index.getTranslogLocation(), listener);
            run.set(false);
                listener.assertNoError();
            primaryTerm
            threadPool.getThreadContext().putHeader("test", "foobar");
    @Before
        assertEquals(0, listeners.pendingCount());
            try {
        maxListeners = randomIntBetween(1, 1000);
        // Fill the listener slots
        Thread refresher = new Thread(() -> {
            assertEquals(0, listeners.pendingCount());
                IllegalStateException.class,
                    } catch (Exception t) {
import org.apache.lucene.store.Directory;
            shardId,
        try (Releasable releaseable1 = listeners.forceRefreshes()) {
import org.opensearch.test.IndexSettingsModule;
        if (randomBoolean()) {
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
        }
        }
    public void testConcurrentRefresh() throws Exception {
import org.apache.lucene.document.NumericDocValuesField;
            .codecService(new CodecService(null, indexSettings, logger, List.of()))
        document.add(seqID.seqNoDocValue);
        assertEquals(0, listeners.pendingCount());
            listener.assertNoError();
            assertTrue(listeners.addOrNotify(refreshedOperation.getTranslogLocation(), listener));
            assertTrue(listeners.refreshNeeded());
        {
                latch.countDown();
            DummyRefreshListener listener = new DummyRefreshListener();
        for (DummyRefreshListener listener : nonForcedListeners) {
            );
            }
        Engine.IndexResult index = index("1");
 */
    }
            assertEquals(0, listeners.pendingCount());
        refresher.cancel();
            listeners.addOrNotify(index.getTranslogLocation(), listener);
            assertFalse(listeners.refreshNeeded());
}
    public void testAfterRefresh() throws Exception {
        public void accept(Boolean forcedRefresh) {
            .translogConfig(translogConfig)
            id,
                assertTrue(listener.forcedRefresh.get());
            .indexSettings(indexSettings)
        AtomicBoolean run = new AtomicBoolean(true);
                assertNull("Listener called twice", oldValue);
            .flushMergesAfter(TimeValue.timeValueMinutes(5))
import org.apache.lucene.search.IndexSearcher;
import java.util.concurrent.atomic.AtomicBoolean;
        assertEquals(1, latch.getCount());
                assertFalse(listener.forcedRefresh.get());
        Engine.IndexResult unrefreshedOperation = index("1");
     */
import org.opensearch.common.util.concurrent.ThreadContext;
        };
    public void testTooMany() throws Exception {
            threadPool.getThreadContext(),
        // Now setup the InternalEngine which is much more complicated because we aren't mocking anything
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("index", Settings.EMPTY);
        } finally {
                assertEquals("foobar", threadPool.getThreadContext().getHeader("test"));
            assertFalse(listeners.addOrNotify(unrefreshedOperation.getTranslogLocation(), listener));
                } else {
        engine = new InternalEngine(config);
        // Setup dependencies of the listeners
    /**
        listener.assertNoError();
 * You may obtain a copy of the License at
                            assertFalse(listener.forcedRefresh.get());
            Exception e = expectThrows(
import org.opensearch.index.mapper.IdFieldMapper;
import org.opensearch.common.lease.Releasable;
        assertNull(threadPool.getThreadContext().getHeader("test"));
    }
                        if (threadCount < maxListeners) {
            indexSettings,
                assertTrue(listeners.addOrNotify(index("1").getTranslogLocation(), listener));
/**
     * adding listeners. This can catch the situation where a refresh happens right as the listener is being added such that the listener
import org.opensearch.common.UUIDs;
public class RefreshListenersTests extends OpenSearchTestCase {
 * ownership. Elasticsearch licenses this file to you under
            shardId,
import org.opensearch.Version;
        IOUtils.close(engine, store);
            public void onFailedEngine(String reason, @Nullable Exception e) {
import org.opensearch.common.Nullable;
import java.io.IOException;
            seqID,
            indexers[thread].start();
            refresher.join();
    }
 * the Apache License, Version 2.0 (the "License"); you may
            "",
            DummyRefreshListener listener = new DummyRefreshListener();
                // we don't need to notify anybody in this test
            assertEquals("can't wait for refresh on a closed index", e.getMessage());
        Cancellable refresher = threadPool.scheduleWithFixedDelay(() -> engine.refresh("because test"), timeValueMillis(100), Names.SAME);
            .threadPool(threadPool)
                        String testFieldValue = String.format(Locale.ROOT, "%s%04d", threadId, iteration);
 * GitHub history for details.
        });
        assertFalse(listener.forcedRefresh.get());
        assertNull(listener.forcedRefresh.get());
        assertFalse(listeners.addOrNotify(index.getTranslogLocation(), listener));
 *     http://www.apache.org/licenses/LICENSE-2.0
    private Engine.IndexResult index(String id, String testFieldValue) throws IOException {
            indexer.join();
import org.opensearch.index.translog.TranslogConfig;
        assertEquals(0, listeners.pendingCount());
            listeners.close();
            versionField,
            @Override
            });
        }
         */
            .circuitBreakerService(new NoneCircuitBreakerService())
        EngineConfig config = new EngineConfig.Builder().shardId(shardId)
import java.util.Locale;
import org.opensearch.index.codec.CodecService;
        for (int i = 0; i < maxListeners; i++) {
     * regardless of what crazy sequence of events causes the refresh listener to fire.
import org.opensearch.test.OpenSearchTestCase;
            listener.assertNoError();
        Engine.IndexResult index = index("1");
                        DummyRefreshListener listener = new DummyRefreshListener();
                        throw new RuntimeException("failure on the [" + iteration + "] iteration of thread [" + threadId + "]", t);
            () -> engine.refresh("too-many-listeners"),
        document.add(idField);
        }
     * misses the refresh and has to catch the next one. If the listener wasn't able to properly catch the next one then this would fail.
        store = new Store(shardId, indexSettings, directory, new DummyShardLock(shardId));
 * this work for additional information regarding copyright
            }
        engine.translogManager().recoverFromTranslog((s) -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
                throw new RuntimeException(error);
            while (run.get()) {
        @Override
        DummyRefreshListener listener = new DummyRefreshListener();
        DummyRefreshListener listener = new DummyRefreshListener();
        threadPool = new TestThreadPool(getTestName());
        Engine.IndexResult index = index("1");
            listener.assertNoError();
        Engine.IndexResult index = index("1");
                DummyRefreshListener listener = new DummyRefreshListener();
        listeners.addOrNotify(index.getTranslogLocation(), forcingListener);
            indexers[thread] = new Thread(() -> {
 * Unless required by applicable law or agreed to in writing,
        assertFalse(listeners.addOrNotify(index("1").getTranslogLocation(), new DummyRefreshListener()));
/*
            final String threadId = String.format(Locale.ROOT, "%04d", thread);
                            assertEquals(iteration, getResult.version());
            listener = new DummyRefreshListener();
            .similarity(iwc.getSimilarity())
                            org.apache.lucene.document.Document document = storedFields.document(getResult.docIdAndVersion().docId);
        assertFalse(listeners.addOrNotify(index("1").getTranslogLocation(), listener));
         * When the listener is called this captures it's only argument.
        }
        {
 *
import org.opensearch.threadpool.Scheduler.Cancellable;
        // We shouldn't have called any of them
        assertTrue("Forced listener wasn't forced?", forcingListener.forcedRefresh.get());
 * Licensed to Elasticsearch under one or more contributor
        assertFalse(listeners.refreshNeeded());
import org.opensearch.index.engine.EngineConfig;
        }
 * Tests how {@linkplain RefreshListeners} interacts with {@linkplain InternalEngine}.
            assertEquals("Expected listener called with unforced refresh!", Boolean.FALSE, listener.forcedRefresh.get());
        private volatile Exception error;
        refresher.start();
    /**
import java.util.concurrent.TimeUnit;
            }
             * longer useful there doesn't seem much point in sending the listener some kind of "I'm closed now, go away" enum value. */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                        }
    }
import org.opensearch.index.seqno.SequenceNumbers;
        Directory directory = newDirectory();
        store.createEmpty(Version.CURRENT.luceneVersion);
    }
        Field versionField = new NumericDocValuesField("_version", Versions.MATCH_ANY);
            try (Releasable releaseable2 = listeners.forceRefreshes()) {
        forcingListener.assertNoError();
            assertNull("Called listener too early!", listener.forcedRefresh.get());
import org.opensearch.index.seqno.RetentionLeases;
    private RefreshListeners listeners;
                listener.assertNoError();
            assertTrue(listeners.addOrNotify(index("1").getTranslogLocation(), listener));
            }
        }
            if (randomBoolean()) {
            DummyRefreshListener listener = new DummyRefreshListener();
 * license agreements. See the NOTICE file distributed with
        IndexWriterConfig iwc = newIndexWriterConfig();
 * under the License.
            assertFalse(listeners.refreshNeeded());
import java.util.Collections;
import org.opensearch.index.mapper.SeqNoFieldMapper;
 * Modifications Copyright OpenSearch Contributors. See
    public void setupListeners() throws Exception {
        }
            }));
import static org.opensearch.common.unit.TimeValue.timeValueMillis;
        listener.assertNoError();
            listener.assertNoError();
        assertFalse(listeners.refreshNeeded());
import org.opensearch.index.engine.InternalEngine;
            listener = new DummyRefreshListener();
import org.apache.lucene.document.Field;
    }
            }
        // These threads add and block until the refresh makes the change visible and then do a non-realtime get.
                        Engine.IndexResult index = index(threadId, testFieldValue);
            assertFalse(listeners.addOrNotify(index.getTranslogLocation(), forced -> {
    private volatile int maxListeners;
        Thread[] indexers = new Thread[threadCount];
            refreshMetric
    private Engine.IndexResult index(String id) throws IOException {
                            StoredFields storedFields = getResult.docIdAndVersion().reader.storedFields();
        engine.refresh("I said so");
        assertEquals(0, listeners.pendingCount());
                if (immediate) {
        List<DummyRefreshListener> nonForcedListeners = new ArrayList<>(maxListeners);
                    assertNotNull(listener.forcedRefresh.get());
        TranslogConfig translogConfig = new TranslogConfig(
import org.opensearch.common.settings.Settings;
            false
 * specific language governing permissions and limitations
                boolean immediate = listeners.addOrNotify(index.getTranslogLocation(), listener);
        return engine.index(index);
        listeners.setCurrentRefreshLocationSupplier(engine.translogManager()::getTranslogLastWriteLocation);
     * Attempts to add a listener at the same time as a refresh occurs by having a background thread force a refresh as fast as it can while
            }
        document.add(seqID.seqNo);
import org.opensearch.common.metrics.MeanMetric;
 */
        engine.refresh("I said so");
import org.apache.lucene.index.StoredFields;
 */
 * SPDX-License-Identifier: Apache-2.0
            () -> maxListeners,
        }
    }
            .queryCache(IndexSearcher.getDefaultQueryCache())
import org.opensearch.core.index.Index;
        Engine.Index index = new Engine.Index(new Term("_id", doc.id()), engine.config().getPrimaryTermSupplier().getAsLong(), doc);
                Engine.IndexResult index = index("1");
import org.opensearch.index.translog.Translog;
            .eventListener(eventListener)
        {
            /* Closing flushed pending listeners as though they were refreshed. Since this can only happen when the index is closed and no
import org.opensearch.core.xcontent.MediaTypeRegistry;
        final AtomicReference<Boolean> forcedRefresh = new AtomicReference<>();
            SequenceNumbers.NO_OPS_PERFORMED,
                assertEquals(0, listeners.pendingCount());
            assertTrue(listener.forcedRefresh.get());
            listener.assertNoError();
    private MeanMetric refreshMetric;
    @After
import java.util.List;
        assertFalse(listener.forcedRefresh.get());
import org.opensearch.core.common.bytes.BytesReference;
import org.junit.After;
import java.util.function.Consumer;
