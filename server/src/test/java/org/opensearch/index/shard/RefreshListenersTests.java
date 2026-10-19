        Engine.IndexResult index = index("1");
            shardId,  
import java.util.concurrent.CountDownLatch;  
        engine.refresh("I said so");
        assertFalse(listeners.refreshNeeded());
        assertEquals(0, listeners.pendingCount());  
            if (error != null) {  
                assertTrue(listeners.addOrNotify(index("1").getTranslogLocation(), listener));
            }
import org.opensearch.threadpool.ThreadPool.Names;
        {  
        store.associateIndexWithNewTranslog(translogUUID);  
        engine = new InternalEngine(config);
            .codecService(new CodecService(null, indexSettings, logger, List.of()))
                        listeners.addOrNotify(index.getTranslogLocation(), listener);  
        engine.refresh("I said so");
 * GitHub history for details.
            try (Releasable releaseable2 = listeners.forceRefreshes()) {
            assertTrue(listeners.addOrNotify(refreshedOperation.getTranslogLocation(), listener));  
        };  
        try (Releasable releaseable1 = listeners.forceRefreshes()) {
    public void testTooMany() throws Exception {
    private Store store;
        assertFalse(listeners.refreshNeeded());  
                        listener.assertNoError();
        Engine.IndexResult index = index("1");
                    } catch (Exception t) {  
        {  
        }
            assertFalse(listeners.addOrNotify(unrefreshedOperation.getTranslogLocation(), listener));
import org.opensearch.index.engine.Engine;
        document.add(seqID.primaryTerm);
            public void onFailedEngine(String reason, @Nullable Exception e) {  
    public void setupListeners() throws Exception {  
     */
            .threadPool(threadPool)
import static org.opensearch.common.unit.TimeValue.timeValueMillis;  
                    assertBusy(() -> assertNotNull(listener.forcedRefresh.get()), 1, TimeUnit.MINUTES);
                Engine.IndexResult index = index("1");
        DummyRefreshListener listener = new DummyRefreshListener();
        listener.assertNoError();
import org.opensearch.core.index.Index;
package org.opensearch.index.shard;
                }  
            .tombstoneDocSupplier(EngineTestCase.tombstoneDocSupplier())
            listeners.close();  
    @Before
}
            });
import org.opensearch.index.mapper.ParseContext.Document;  
import java.util.concurrent.atomic.AtomicBoolean;
                error = e;
        DummyRefreshListener listener = new DummyRefreshListener();  
import org.opensearch.index.mapper.IdFieldMapper;
            Exception e = expectThrows(  
        Document document = new Document();
        Engine.EventListener eventListener = new Engine.EventListener() {
        Thread[] indexers = new Thread[threadCount];
        Field idField = new Field("_id", id, IdFieldMapper.Defaults.FIELD_TYPE);
        // We shouldn't have called any of them
        ShardId shardId = new ShardId(new Index("index", "_na_"), 1);  
                engine.refresh("test");
import org.opensearch.common.util.concurrent.ThreadContext;  
            indexer.join();  
                            org.apache.lucene.document.Document document = storedFields.document(getResult.docIdAndVersion().docId);  
                latch.countDown();
            @Override
            }
        // These threads add and block until the refresh makes the change visible and then do a non-realtime get.  
 *     http://www.apache.org/licenses/LICENSE-2.0
                } else {
            source,
            DummyRefreshListener listener = new DummyRefreshListener();  
            BigArrays.NON_RECYCLING_INSTANCE,  
        List<DummyRefreshListener> nonForcedListeners = new ArrayList<>(maxListeners);
 * specific language governing permissions and limitations
                throw new RuntimeException(error);
        // Now setup the InternalEngine which is much more complicated because we aren't mocking anything  
            primaryTerm
        forcingListener.assertNoError();
 * not use this file except in compliance with the License.
        assertEquals(0, listeners.pendingCount());  
                    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        // Add one more listener which should cause a refresh.
        assertEquals(0, listeners.pendingCount());
                engine.refresh("I said so");
     */  
        }
 * SPDX-License-Identifier: Apache-2.0
        CountDownLatch latch = new CountDownLatch(1);  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.index.translog.Translog;  
            }
        BytesReference source = new BytesArray(new byte[] { 1 });  
 * software distributed under the License is distributed on an
        assertEquals(1, listeners.pendingCount());  
        listener.assertNoError();
            listener.assertNoError();
import org.opensearch.index.engine.InternalEngine;
        assertFalse(listeners.addOrNotify(index("1").getTranslogLocation(), new DummyRefreshListener()));
                    try {  
 *
            shardId,  
        assertEquals(maxListeners, listeners.pendingCount());
    private RefreshListeners listeners;
                        assertEquals(iteration, index.getVersion());  
            listener = new DummyRefreshListener();
        assertFalse(listener.forcedRefresh.get());
        assertEquals(0, listeners.pendingCount());
    private volatile int maxListeners;  
import org.apache.lucene.index.IndexWriterConfig;
        refreshMetric = new MeanMetric();
    private ThreadPool threadPool;
            assertTrue(listener.forcedRefresh.get());  
            .similarity(iwc.getSimilarity())
            "",
                            assertFalse(listener.forcedRefresh.get());  
        // This thread just refreshes every once in a while to cause trouble.  
        document.add(versionField);
            Arrays.asList(document),  
            .indexSettings(indexSettings)  
import org.opensearch.Version;  
            assertEquals("can't wait for refresh on a closed index", e.getMessage());
        engine.translogManager().recoverFromTranslog((s) -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
            .queryCachingPolicy(IndexSearcher.getDefaultQueryCachingPolicy())
             * longer useful there doesn't seem much point in sending the listener some kind of "I'm closed now, go away" enum value. */
                boolean immediate = listeners.addOrNotify(index.getTranslogLocation(), listener);
import java.util.ArrayList;
            assertTrue(listeners.addOrNotify(index("1").getTranslogLocation(), listener));  
            }  
import org.opensearch.index.engine.EngineTestCase;  
        for (int thread = 0; thread < threadCount; thread++) {
        public void accept(Boolean forcedRefresh) {
 * Modifications Copyright OpenSearch Contributors. See
            .primaryTermSupplier(() -> primaryTerm)
        assertTrue(listeners.addOrNotify(index.getTranslogLocation(), listener));  
        String allocationId = UUIDs.randomBase64UUID(random());
                listener.assertNoError();  
    /**
                        throw new RuntimeException("failure on the [" + iteration + "] iteration of thread [" + threadId + "]", t);
    }
            indexSettings,
            indexers[thread] = new Thread(() -> {
        Engine.IndexResult refreshedOperation = index("1");  
        assertEquals(1, latch.getCount());  
    public void testDisallowAddListeners() throws Exception {
        listeners.addOrNotify(index.getTranslogLocation(), forcingListener);  
import org.apache.lucene.store.Directory;
import java.util.concurrent.atomic.AtomicReference;  
    private static class DummyRefreshListener implements Consumer<Boolean> {  
import org.opensearch.index.IndexSettings;
        );  
        assertEquals(1, listeners.pendingCount());  
 * this file be licensed under the Apache-2.0 license or a
        SeqNoFieldMapper.SequenceIDFields seqID = SeqNoFieldMapper.SequenceIDFields.emptySeqID();  
import org.opensearch.common.lucene.uid.Versions;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.threadpool.ThreadPool;
         */  
import org.opensearch.common.UUIDs;
            assertFalse(listener.forcedRefresh.get());
                            StoredFields storedFields = getResult.docIdAndVersion().reader.storedFields();
        latch.await();
        // Fill the listener slots
        assertEquals(0, listeners.pendingCount());
                listener.assertNoError();
        document.add(new TextField("test", testFieldValue, Field.Store.YES));  
            .internalRefreshListener(Collections.emptyList())  
        terminate(threadPool);  
                        }
 * this work for additional information regarding copyright
            null,
     * misses the refresh and has to catch the next one. If the listener wasn't able to properly catch the next one then this would fail.
            refresher.join();  
import org.apache.lucene.document.TextField;  
        assertFalse(listener.forcedRefresh.get());
import org.opensearch.index.seqno.SequenceNumbers;
        Engine.IndexResult index = index("1");  
import org.opensearch.threadpool.Scheduler.Cancellable;
        // Setup dependencies of the listeners
        Directory directory = newDirectory();
 * Tests how {@linkplain RefreshListeners} interacts with {@linkplain InternalEngine}.
    /**
                    assertNotNull(listener.forcedRefresh.get());  
        );
        assertNull(threadPool.getThreadContext().getHeader("test"));
        }
import org.opensearch.threadpool.TestThreadPool;  
 */  
        DummyRefreshListener listener = new DummyRefreshListener();
import org.opensearch.common.lease.Releasable;  
            seqID,  
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;  
     * Attempts to add a listener at the same time as a refresh occurs by having a background thread force a refresh as fast as it can while  
                        try (Engine.GetResult getResult = engine.get(get, engine::acquireSearcher)) {
            threadPool.getThreadContext().putHeader("test", "foobar");
            // If you add a listener for an already refreshed location then it'll just fire even if closed
        IndexWriterConfig iwc = newIndexWriterConfig();
            .queryCache(IndexSearcher.getDefaultQueryCache())
 *
        maxListeners = randomIntBetween(1, 1000);
        int threadCount = between(3, 10);  
            /* Closing flushed pending listeners as though they were refreshed. Since this can only happen when the index is closed and no
            } catch (Exception e) {  
                        String testFieldValue = String.format(Locale.ROOT, "%s%04d", threadId, iteration);
import org.opensearch.test.DummyShardLock;
        private volatile Exception error;
            .analyzer(iwc.getAnalyzer())  
    public void testConcurrentRefresh() throws Exception {
            versionField,
            refreshMetric
                listener = new DummyRefreshListener();  
            assertNull(listener.forcedRefresh.get());
            final String threadId = String.format(Locale.ROOT, "%04d", thread);  
    }
        EngineConfig config = new EngineConfig.Builder().shardId(shardId)
                () -> listeners.addOrNotify(unrefreshedOperation.getTranslogLocation(), listener)
import static org.hamcrest.Matchers.arrayContaining;
            index(randomFrom("1" /* same document */, "2" /* different document */));  
import org.opensearch.core.common.bytes.BytesArray;
        }
 * under the License.  
        engine.refresh("I said so");
    }  
        assertEquals(0, listeners.pendingCount());
                IllegalStateException.class,
                assertTrue(listener.forcedRefresh.get());
        try (ThreadContext.StoredContext ignore = threadPool.getThreadContext().stashContext()) {
    private MeanMetric refreshMetric;  
    }
        assertEquals(0, listeners.pendingCount());  
import org.opensearch.index.codec.CodecService;  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.common.bytes.BytesReference;  
import java.util.concurrent.TimeUnit;
            threadPool.getThreadContext(),
        store = new Store(shardId, indexSettings, directory, new DummyShardLock(shardId));  
            false
    }
        Engine.IndexResult index = index("1");
        );  
 *  
                assertNull("Listener called twice", oldValue);
        listener.assertNoError();  
import org.opensearch.test.IndexSettingsModule;  
                assertFalse(listener.forcedRefresh.get());
    public void testAfterRefresh() throws Exception {
    @After  
            nonForcedListeners.add(listener);
                for (int iteration = 1; iteration <= 50; iteration++) {
        assertFalse(listener.forcedRefresh.get());
            listener.assertNoError();
import org.opensearch.common.util.io.IOUtils;
            DummyRefreshListener listener = new DummyRefreshListener();
        AtomicBoolean run = new AtomicBoolean(true);
            assertNull(listener.forcedRefresh.get());
            run.set(false);
import org.apache.lucene.document.NumericDocValuesField;
        document.add(idField);
/*  
            () -> engine.refresh("too-many-listeners"),
        }
 * Unless required by applicable law or agreed to in writing,
                        if (threadCount < maxListeners) {
            assertFalse(listeners.refreshNeeded());  
            .globalCheckpointSupplier(() -> SequenceNumbers.NO_OPS_PERFORMED)
    public void testBeforeRefresh() throws Exception {  
        final long primaryTerm = randomNonNegativeLong();
            SequenceNumbers.NO_OPS_PERFORMED,
            id,
            .flushMergesAfter(TimeValue.timeValueMinutes(5))
    private Engine.IndexResult index(String id, String testFieldValue) throws IOException {
                        assertBusy(() -> assertNotNull("listener never called", listener.forcedRefresh.get()), 1, TimeUnit.MINUTES);
 * The OpenSearch Contributors require contributions made to  
        });
        document.add(seqID.seqNo);  
        return engine.index(index);  
    public void testContextIsPreserved() throws IOException, InterruptedException {  
        }
        final AtomicReference<Boolean> forcedRefresh = new AtomicReference<>();
        refresher.start();
            () -> maxListeners,
            // But adding a listener to a non-refreshed location will fail
            DummyRefreshListener listener = new DummyRefreshListener();
                Boolean oldValue = this.forcedRefresh.getAndSet(forcedRefresh);
    }  
                            assertEquals(iteration, getResult.version());
import org.opensearch.index.engine.EngineConfig;
            assertTrue(listener.forcedRefresh.get());
import org.apache.lucene.document.Field;
        } finally {
        }  
            while (run.get()) {
                }  
            listener.assertNoError();
            MediaTypeRegistry.JSON,
        // That forces all the listeners through. It would be on the listener ThreadPool but we've made all of those execute immediately.
            .circuitBreakerService(new NoneCircuitBreakerService())
                            assertThat(document.getValues("test"), arrayContaining(testFieldValue));
            assertEquals(0, listeners.pendingCount());
            .build();  
import org.opensearch.index.mapper.SeqNoFieldMapper;
    public void testClose() throws Exception {
            assertEquals(0, listeners.pendingCount());  
            translogConfig.getTranslogPath(),
 */
                if (immediate) {
            assertTrue(listeners.addOrNotify(index("1").getTranslogLocation(), listener));
        assertTrue("Forced listener wasn't forced?", forcingListener.forcedRefresh.get());
        try {  
        }
import org.opensearch.common.unit.TimeValue;
                        }
        assertEquals(0, listeners.pendingCount());
 * compatible open source license.
            .mergePolicy(newMergePolicy())
import org.opensearch.common.settings.Settings;  
        DummyRefreshListener forcingListener = new DummyRefreshListener();
        listeners = new RefreshListeners(  
            .store(store)
    }
        {  
            assertFalse(listeners.refreshNeeded());  
            listener.assertNoError();
        assertEquals(0, listeners.pendingCount());
/*
import org.apache.lucene.search.IndexSearcher;
import org.junit.Before;
import java.io.IOException;  
        }
                assertEquals(0, listeners.pendingCount());
            try {  
    }
import org.opensearch.common.metrics.MeanMetric;
                        Engine.IndexResult index = index(threadId, testFieldValue);
        Engine.IndexResult unrefreshedOperation = index("1");
            assertEquals(0, listeners.pendingCount());
        listeners.setCurrentRefreshLocationSupplier(engine.translogManager()::getTranslogLastWriteLocation);  
            DummyRefreshListener listener = new DummyRefreshListener();
            .translogConfig(translogConfig)  
            }  
import org.opensearch.index.translog.TranslogConfig;
            }  
import org.opensearch.core.index.shard.ShardId;
        threadPool = new TestThreadPool(getTestName());
        @Override
import java.util.Collections;  
        Thread refresher = new Thread(() -> {  
        assertNull(listener.forcedRefresh.get());
            }
    }
    private Engine.IndexResult index(String id) throws IOException {  
import org.junit.After;  
    }
            listeners.addOrNotify(index.getTranslogLocation(), listener);  
            createTempDir("translog"),
        if (randomBoolean()) {
            assertFalse(listener.forcedRefresh.get());
        }
         * When the listener is called this captures it's only argument.
            }));  
     * regardless of what crazy sequence of events causes the refresh listener to fire.  
 */  
                DummyRefreshListener listener = new DummyRefreshListener();  
        TranslogConfig translogConfig = new TranslogConfig(
import java.util.Locale;
import java.util.Arrays;
            .externalRefreshListener(Collections.singletonList(listeners))
 */
        );
        Cancellable refresher = threadPool.scheduleWithFixedDelay(() -> engine.refresh("because test"), timeValueMillis(100), Names.SAME);
import org.opensearch.core.xcontent.MediaTypeRegistry;
import org.opensearch.index.store.Store;
        }
        IOUtils.close(engine, store);
/*  
            listener.assertNoError();
                        Engine.Get get = new Engine.Get(false, false, threadId, new Term(IdFieldMapper.NAME, threadId));
                // we don't need to notify anybody in this test
        Engine.Index index = new Engine.Index(new Term("_id", doc.id()), engine.config().getPrimaryTermSupplier().getAsLong(), doc);
                            assertTrue("document not found", getResult.exists());  
        for (Thread indexer : indexers) {
        for (DummyRefreshListener listener : nonForcedListeners) {
        for (DummyRefreshListener listener : nonForcedListeners) {
            assertTrue(listeners.refreshNeeded());
            .eventListener(eventListener)  
import java.util.List;
            assertEquals("Expected listener called with unforced refresh!", Boolean.FALSE, listener.forcedRefresh.get());  
        }  
     * Uses a bunch of threads to index, wait for refresh, and non-realtime get documents to validate that they are visible after waiting
        refresher.cancel();
                assertEquals("foobar", threadPool.getThreadContext().getHeader("test"));
            assertFalse(listeners.refreshNeeded());  
            );  
        return index(id, "test");
import org.opensearch.index.mapper.ParsedDocument;
            listener = new DummyRefreshListener();
import org.apache.lucene.index.Term;  
        ParsedDocument doc = new ParsedDocument(
    }
        store.createEmpty(Version.CURRENT.luceneVersion);
            null  
import org.opensearch.index.seqno.RetentionLeases;  
 * Licensed to Elasticsearch under one or more contributor  
        assertFalse(listeners.addOrNotify(index("1").getTranslogLocation(), listener));
        engine.refresh("I said so");
 * KIND, either express or implied.  See the License for the
        assertFalse(listeners.addOrNotify(index.getTranslogLocation(), listener));
        Field versionField = new NumericDocValuesField("_version", Versions.MATCH_ANY);
     * adding listeners. This can catch the situation where a refresh happens right as the listener is being added such that the listener
            indexers[thread].start();
        engine.refresh("I said so");  
import org.opensearch.common.util.BigArrays;
    }
        }  
    public void tearDownListeners() throws Exception {
        final String translogUUID = Translog.createEmptyTranslog(  
        /**
            .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)  
 * You may obtain a copy of the License at  
            assertFalse(listeners.addOrNotify(index.getTranslogLocation(), forced -> {  
            assertNull("Called listener too early!", listener.forcedRefresh.get());  
    private Engine engine;
        document.add(seqID.seqNoDocValue);
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("index", Settings.EMPTY);
        public void assertNoError() {
            assertEquals(0, listeners.pendingCount());
                        DummyRefreshListener listener = new DummyRefreshListener();
            if (randomBoolean()) {
import org.apache.lucene.index.StoredFields;
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.common.Nullable;
/**  
    }  
        }  
import java.util.function.Consumer;
        for (int i = 0; i < maxListeners; i++) {  
    public void testLotsOfThreads() throws Exception {
            for (int i = 0; i < 100; i++) {
public class RefreshListenersTests extends OpenSearchTestCase {  
            assertEquals(0, listeners.pendingCount());
            logger,  
        maxListeners = between(1, threadCount * 2);
