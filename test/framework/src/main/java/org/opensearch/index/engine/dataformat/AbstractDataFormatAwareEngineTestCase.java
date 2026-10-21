        when(seqNoFieldType.name()).thenReturn("_seq_no");
            commitData.put(Engine.MAX_UNSAFE_AUTO_ID_TIMESTAMP_COMMIT_ID, "-1");
import org.opensearch.plugins.PluginsService;
                CatalogSnapshot snapshot = ref.get();
            int numDocs = randomIntBetween(3, 10);
            shardPath,
                Engine.IndexResult result = engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
        } finally {
import org.opensearch.index.translog.Translog;
import org.apache.lucene.search.ReferenceManager;
import org.opensearch.common.lucene.Lucene;
    }
        try (DataFormatAwareEngine engine = createEngine()) {
            }
    public void testMultipleRefreshesAccumulateSegmentsWithUniqueGenerations() throws IOException {
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo((long) totalDocs - 1));
 * Abstract base class for testing {@link DataFormatAwareEngine} with any
     */
            indexSettings,
    protected void bootstrapStoreWithMetadata(Store store, String translogUUID) throws IOException {
            writer.commit();
            BigArrays.NON_RECYCLING_INSTANCE,
                    prevGen = gen;
    }
            terminate(threadPool);
            int docsPerThread = randomIntBetween(10, 25);
            commitData.put(SequenceNumbers.MAX_SEQ_NO, Long.toString(SequenceNumbers.NO_OPS_PERFORMED));
                    } catch (Exception e) {
        bootstrapStoreWithMetadata(store, uuid);
                });
                        for (int d = 0; d < docsPerThread; d++) {
        List<ReferenceManager.RefreshListener> internalListeners
        return ms;
    protected MapperService createMockMapperService(IndexSettings indexSettings) {
 * The OpenSearch Contributors require contributions made to
    }
    // ── Common tests ──
        try {
import org.opensearch.index.mapper.IdFieldMapper;
                assertThat(ref.get().getSegments().size(), greaterThan(0));
            primaryTerm.get(),
        Store store,
        }
                        }
import org.opensearch.index.engine.Engine;
import static org.hamcrest.Matchers.notNullValue;
import org.opensearch.index.shard.ShardPath;
            IndexWriter writer = new IndexWriter(
        try (DataFormatAwareEngine engine = createEngine()) {
                                .getFailure()) != null) {
                        failures.incrementAndGet();
                            Engine.IndexResult result = engine.index(indexOp(createParsedDocWithInput(threadId + "_" + d, null)));
                        assertThat(wfs.files().isEmpty(), equalTo(false));
import org.opensearch.index.engine.dataformat.stub.MockDocumentInput;
            translogPath,
                engine.refresh("cycle-" + i);
/**
                        exceptions.add(e);
import org.opensearch.test.DummyShardLock;
        );
            engine.flush(false, true);
                    try {
    }
            store.close();
        org.opensearch.index.mapper.DocumentMapper documentMapper = mock(org.opensearch.index.mapper.DocumentMapper.class);
        ) {
        when(ms.documentMapper()).thenReturn(documentMapper);
        return new Store(
    }
    public void setUp() throws Exception {
            // Refresh and flush
            .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
        try (
        when(ms.fieldType("_seq_no")).thenReturn(seqNoFieldType);
            assertThat(engine.lastRefreshedCheckpoint(), equalTo((long) numDocs - 1));
public abstract class AbstractDataFormatAwareEngineTestCase extends OpenSearchTestCase {
    }
import org.opensearch.index.engine.DataFormatAwareEngine;
import org.opensearch.index.IndexSettings;
                        assertThat(wfs.numRows(), greaterThan(0L));
            CyclicBarrier barrier = new CyclicBarrier(numThreads);
     * Creates a mock {@link MapperService} that returns
                    .mapToLong(WriterFileSet::numRows)
    protected ParsedDocument createParsedDocWithInput(String id, String routing) {
     * Creates a fully wired {@link DataFormatAwareEngine} with translog, store, and the
     * plugin-provided {@link IndexingExecutionEngine}. Each call creates a fresh translog
     * Subclasses may override to provide additional field type mappings.
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
            .indexSettings(indexSettings)
    }
                }
            var stats = engine.docStats();
                Set<Long> gens = new HashSet<>();
import org.opensearch.common.settings.Settings;
    @Override
            int numDocs = randomIntBetween(5, 15);
            for (int i = 0; i < numDocs; i++) {
        try (DataFormatAwareEngine engine = createEngine()) {
                    assertThat(seg.dfGroupedSearchableFiles().isEmpty(), equalTo(false));
                for (Segment seg : snapshot.getSegments()) {
                    long gen = ref.get().getGeneration();
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo((long) numDocs - 1));
import org.apache.lucene.index.NoMergePolicy;
            int numBatches = randomIntBetween(3, 6);
        Path path = createTempDir().resolve(shardId.getIndex().getUUID()).resolve(String.valueOf(shardId.id()));
import org.opensearch.Version;
     */
            .mergePolicy(NoMergePolicy.INSTANCE)
    /** Snapshot generation must strictly increase across refreshes. */
            }
    protected Settings additionalIndexSettings() {
import org.opensearch.common.concurrent.GatedCloseable;
        return Settings.EMPTY;
            for (int i = 0; i < randomIntBetween(3, 6); i++) {
        when(versionFieldType.typeName()).thenReturn("_version");
            base.version(),
                final int threadId = t;
    }
                    .sum();
 * <p>Subclasses provide the engine-specific components via {@link #createDataFormatPlugin()}
            createDocumentInput()
            .globalCheckpointSupplier(() -> SequenceNumbers.NO_OPS_PERFORMED)
    /** Override to provide a custom CommitterFactory (e.g., LuceneCommitterFactory). Default uses InMemoryCommitter. */
            VersionType.INTERNAL,
            Settings.builder()
        );
    }
                Engine.IndexResult result = engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
            AtomicInteger failures = new AtomicInteger(0);
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), dataFormatName())
import org.opensearch.index.engine.exec.Segment;
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo((long) totalDocs - 1));
                            }
            AtomicLong maxSeqNo = new AtomicLong(-1);
            Map<String, String> commitData = new HashMap<>();
import static org.opensearch.index.engine.EngineTestCase.tombstoneDocSupplier;
                        failures.incrementAndGet();
            }
                    .flatMap(s -> s.dfGroupedSearchableFiles().values().stream())
                    .stream()
        super.tearDown();
        }
            for (Thread t : threads)
    /**
            new FsDirectoryFactory()
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
import org.opensearch.index.engine.dataformat.stub.InMemoryCommitter;
            SequenceNumbers.UNASSIGNED_SEQ_NO,
            assertThat(failures.get(), equalTo(0));
                        while ((idx = docCounter.getAndIncrement()) < totalDocs) {
            )
                    .sum();
        when(documentMapper.getVersion()).thenReturn(1L);
            long prevGen = -1;
     */
                threads[t] = new Thread(() -> {
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of(createDataFormatPlugin()));
        return new MockDocumentInput();
        Path translogPath,
            commitData.put(Engine.HISTORY_UUID_KEY, UUID.randomUUID().toString());
                new IndexWriterConfig(Lucene.STANDARD_ANALYZER).setMergePolicy(NoMergePolicy.INSTANCE)
 * translog, store, and commit infrastructure.
            for (int batch = 0; batch < numBatches; batch++) {
        return new DataFormatRegistry(pluginsService);
import java.util.Collections;
import static org.mockito.Mockito.when;
     * Default creates a standard {@link TestThreadPool}.
}
    /** Flushes after indexing and verifies the catalog snapshot preserves total row count. */
                });
    }
    public void testDocStatsReflectsIndexedDocuments() throws IOException {
                Engine.IndexResult result = engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
import org.opensearch.index.seqno.SequenceNumbers;
    protected Engine.Index indexOp(ParsedDocument doc) {
import org.opensearch.plugins.SearchBackEndPlugin;
            "",
            for (int t = 0; t < numThreads; t++) {
                        barrier.await();
        );
    protected EngineConfig buildEngineConfig(
import java.util.Map;
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of(createSearchBackEndPlugin()));
        }
                assertNull("expected no failure but got: " + result.getFailure(), result.getFailure());
            if (failures.get() > 0) {
                // Verify segment generation uniqueness
    protected abstract SearchBackEndPlugin<?> createSearchBackEndPlugin();
        super.setUp();
        return new DataFormatAwareEngine(buildEngineConfig(store, translogPath, List.of(), List.of()));
import org.opensearch.index.engine.EngineConfig;
 *
    }
    /**
                    .stream()
import org.opensearch.threadpool.ThreadPool;
 */
    /** Each refresh cycle produces a new segment; all generations must be unique. */
                // Verify all generations are unique
    protected abstract DataFormatPlugin createDataFormatPlugin();
        PluginsService pluginsService = mock(PluginsService.class);
        );
    /**
import org.opensearch.index.engine.exec.commit.CommitterFactory;
import org.opensearch.core.index.shard.ShardId;
 * {@link IndexingExecutionEngine} implementation.
            false,
                engine.refresh("batch-" + batch);
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            shardId,
        return new EngineConfig.Builder().shardId(shardId)
                t.join();
     * configuration (e.g., {@link org.opensearch.index.codec.CodecService} for Lucene).
import static org.hamcrest.Matchers.equalTo;
        return new Engine.Index(
    }
 *
                    .sum();
import java.nio.file.Path;
            assertThat(stats.getCount(), greaterThanOrEqualTo(0L));
        try (DataFormatAwareEngine engine = createEngine()) {
                assertThat(snapshot.getSegments().size(), equalTo(numBatches));
                }
    ) {
import org.opensearch.index.mapper.SeqNoFieldMapper;
            engine.flush(false, true);
import org.apache.lucene.index.Term;
    protected ThreadPool threadPool;
                fail("concurrent indexing failed with " + failures.get() + " exceptions" + exceptions);
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(
            dir,
    @SuppressWarnings("unchecked")
            List<Exception> exceptions = Collections.synchronizedList(new ArrayList<>());
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
            doc,
                store.directory(),
                        int idx;
import org.opensearch.index.seqno.RetentionLeases;
            }
     * and bootstraps the store's commit metadata.
            .flushMergesAfter(TimeValue.timeValueMinutes(5))
import org.opensearch.common.lucene.uid.Versions;
            }
                    } catch (Exception e) {
    private DataFormatRegistry createRegistry() {
                threads[t] = new Thread(() -> {
    // ── Infrastructure ──
            engine.refresh("test");
        org.opensearch.index.mapper.MappedFieldType seqNoFieldType = mock(org.opensearch.index.mapper.MappedFieldType.class);
     * Subclasses may override to provide a store with custom directory implementations.
            }
            shardId,
    public void testFlushCommitsAndPreservesData() throws IOException {
                .build()
import static org.hamcrest.Matchers.greaterThan;
     * expects: translog UUID, sequence number markers, and history UUID.
            new Term(IdFieldMapper.NAME, Uid.encodeId(doc.id())),
import java.io.IOException;
        }
    }
     * field types for metadata fields required by {@link DataFormatAwareEngine#indexIntoEngine}.
        ShardPath shardPath = new ShardPath(false, path, path, shardId);
            Store.OnClose.EMPTY,
 * and {@link #createSearchBackEndPlugin()}. The base class handles all DFAE lifecycle,
                assertThat(result.getSeqNo(), equalTo((long) i));
            int totalDocs = numThreads * docsPerThread;
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
        when(seqNoFieldType.typeName()).thenReturn("_seq_no");
import org.opensearch.index.engine.exec.WriterFileSet;
                            if ((failure = engine.index(indexOp(createParsedDocWithInput(Integer.toString(idx), null)))
            .threadPool(threadPool)
import org.opensearch.index.mapper.Uid;
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
     * (e.g., the {@code parquet_native_write} executor for the Parquet engine).
                assertThat(snapshot.getSegments().size(), greaterThan(0));
                    .setOpenMode(IndexWriterConfig.OpenMode.CREATE)
        Path translogPath = createTempDir();
    public void testConcurrentIndexThenRefreshAndFlush() throws Exception {
                    assertTrue("duplicate generation: " + seg.generation(), gens.add(seg.generation()));
import org.opensearch.index.store.Store;
            }
/*
    protected ThreadPool buildThreadPool() {
            Engine.Operation.Origin.PRIMARY,
            .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)
    /** Returns the DataFormatPlugin that provides the IndexingExecutionEngine under test. */
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
                threads[t].start();
                assertThat(totalRows, equalTo((long) numDocs));
                    .getSegments()
     * Creates a fresh {@link Store} backed by a temporary directory for each test.
    protected Store store;
            base.getMediaType(),
                Set<Long> gens = new HashSet<>();
            engine.refresh("after-indexing");
        return new ParsedDocument(
            base.docs(),
                long totalRows = ref.get()
            // Index concurrently
            writer.setLiveCommitData(commitData.entrySet());
    public void tearDown() throws Exception {
import java.util.concurrent.atomic.AtomicLong;
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
import static org.opensearch.index.engine.EngineTestCase.createParsedDoc;
import org.opensearch.threadpool.TestThreadPool;
    /**
                    }
            for (int t = 0; t < numThreads; t++) {
        Settings.Builder settingsBuilder = Settings.builder()
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo((long) numDocs - 1));
    @Override
import org.opensearch.index.translog.TranslogConfig;
            .translogConfig(translogConfig)
                                throw failure;
            indexSettings,
    /**
 *
            SeqNoFieldMapper.SequenceIDFields.emptySeqID(),
import org.opensearch.index.mapper.MapperService;
                    assertTrue("duplicate generation: " + seg.generation(), gens.add(seg.generation()));
            }
        );
    }
     * Builds the {@link EngineConfig} wiring together the store, translog, data format registry,
        MapperService ms = mock(MapperService.class);
    /** Every primary-origin index operation must produce a non-null translog location. */
    /**
    /** Concurrent indexing followed by refresh and flush must preserve total row count. */
import java.util.UUID;
import java.util.ArrayList;
            Thread[] threads = new Thread[numThreads];
            int numThreads = randomIntBetween(2, 4);
     */
    protected CommitterFactory createCommitterFactory(Store store) {
    /** Multi-threaded indexing must produce a contiguous checkpoint with no gaps. */
        }
        threadPool = buildThreadPool();
    /** Returns the SearchBackEndPlugin for reader manager creation. */
        return config -> new InMemoryCommitter(store);
            int numDocs = randomIntBetween(3, 10);
            new DummyShardLock(shardId),
            .primaryTermSupplier(primaryTerm::get)
            .put(additionalIndexSettings());
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
                    }
                assertThat(totalRows, equalTo((long) numBatches));
                        Exception failure;
                long totalRows = snapshot.getSegments()
            0
import org.apache.lucene.store.Directory;
                // Verify total row count
     * Bootstraps the store's Lucene commit with the metadata that {@link DataFormatAwareEngine}
    }
import org.opensearch.cluster.metadata.IndexMetadata;
            for (int i = 0; i < numDocs; i++) {
                        barrier.await();
 * merge invariants, and failure handling — all driven through the real DFAE
            .externalRefreshListener(externalListeners)
            assertThat(stats.getCount(), equalTo((long) numDocs));
        }
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", settingsBuilder.build());
 * <p>Tests cover: indexing, refresh, flush, catalog snapshots, concurrency,
                    try {
                    }
    protected Store createStore() throws IOException {
            int totalDocs = randomIntBetween(20, 50);
                for (Segment seg : snapshot.getSegments()) {
                CatalogSnapshot snapshot = ref.get();
        when(ms.fieldType("_version")).thenReturn(versionFieldType);
    /** Override to provide a custom DocumentInput for the engine under test. Default uses MockDocumentInput. */
        try (DataFormatAwareEngine engine = createEngine()) {
    }
        List<ReferenceManager.RefreshListener> externalListeners,
import org.apache.lucene.index.IndexWriter;
                            maxSeqNo.accumulateAndGet(result.getSeqNo(), Math::max);
        store = createStore();
            for (int i = 0; i < numDocs; i++) {
    }
        TranslogConfig translogConfig = new TranslogConfig(
    protected ShardId shardId;
    // ── Helpers ──
            Versions.MATCH_ANY,
            .committerFactory(committerFactory)
        primaryTerm = new AtomicLong(randomLongBetween(1, Long.MAX_VALUE));
    /** Override to add plugin-specific index settings (e.g., sort config, parquet settings). */
            .mapperService(createMockMapperService(indexSettings))
     * committer factory, and refresh listeners. Subclasses may override to add engine-specific
import org.opensearch.test.OpenSearchTestCase;
                }
            System.nanoTime(),
        shardId = new ShardId(new Index("test", "_na_"), 0);
    }
                threads[t].start();
    protected DocumentInput<?> createDocumentInput() {
        org.opensearch.index.mapper.MappedFieldType versionFieldType = mock(org.opensearch.index.mapper.MappedFieldType.class);
    protected AtomicLong primaryTerm;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
 * this file be licensed under the Apache-2.0 license or a
            commitData.put(Translog.TRANSLOG_UUID_KEY, translogUUID);
            CyclicBarrier barrier = new CyclicBarrier(numThreads);
                assertThat(result.getTranslogLocation(), notNullValue());
        return new TestThreadPool(getClass().getName());
import org.opensearch.index.mapper.ParsedDocument;
 * compatible open source license.
            .dataFormatRegistry(registry)
    public void testConcurrentIndexingPreservesCheckpoint() throws Exception {
                    .flatMap(s -> s.dfGroupedSearchableFiles().values().stream())
    public void testIndexAndRefreshProducesSegments() throws IOException {
    /** Returns the data format name (e.g., "composite", "parquet"). */
                    assertThat("generation must advance monotonically", gen, greaterThan(prevGen));
 * SPDX-License-Identifier: Apache-2.0
            int numDocs = randomIntBetween(3, 10);
import java.util.concurrent.atomic.AtomicInteger;
            AtomicInteger failures = new AtomicInteger(0);
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    }
                long totalRows = snapshot.getSegments()
    }
        }
                assertThat(snapshot.getSegments().size(), greaterThan(0));
        }
 * orchestration layer with the injected engine.
            .store(store)
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(batch), null)));
package org.opensearch.index.engine.dataformat;
            }
    /** DocStats count must reflect the number of indexed documents after refresh. */
            .tombstoneDocSupplier(tombstoneDocSupplier())
import org.opensearch.core.index.Index;
    /** Indexes documents, refreshes, and verifies segments have unique generations and positive row counts. */
     */
import org.opensearch.index.VersionType;
            assertThat(maxSeqNo.get(), equalTo((long) totalDocs - 1));
        try (DataFormatAwareEngine engine = createEngine()) {
            .build();
            int numThreads = randomIntBetween(2, 4);
            for (int i = 0; i < numDocs; i++) {
import org.opensearch.index.store.FsDirectoryFactory;
                    .mapToLong(WriterFileSet::numRows)
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
import static org.mockito.Mockito.mock;
import org.opensearch.common.util.BigArrays;
import java.util.HashSet;
    public void testTranslogRecordsAllPrimaryOps() throws IOException {
        Directory dir = newDirectory();
            SequenceNumbers.UNASSIGNED_SEQ_NO,
                .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
        when(versionFieldType.name()).thenReturn("_version");
            -1,
                t.join();
            base.source(),
                    for (WriterFileSet wfs : seg.dfGroupedSearchableFiles().values()) {
            }
                try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
                assertThat("total rows must match indexed docs", totalRows, equalTo((long) totalDocs));
    }
            AtomicInteger docCounter = new AtomicInteger(0);
import org.opensearch.common.unit.TimeValue;
            Thread[] threads = new Thread[numThreads];
        CommitterFactory committerFactory = createCommitterFactory(store);
                    .mapToLong(WriterFileSet::numRows)
    protected abstract String dataFormatName();
            base.id(),
                        }
            commitData.put(SequenceNumbers.LOCAL_CHECKPOINT_KEY, Long.toString(SequenceNumbers.NO_OPS_PERFORMED));
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
            }
    protected DataFormatAwareEngine createEngine() throws IOException {
     */
import java.util.List;
                CatalogSnapshot snapshot = ref.get();
import java.util.Set;
            for (Thread t : threads)
        }
            assertThat(engine.translogManager().getTranslogStats().estimatedNumberOfOperations(), equalTo(numDocs));
    }
import org.opensearch.test.IndexSettingsModule;
    public void testSnapshotGenerationAdvancesMonotonically() throws IOException {
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
            false
        try (DataFormatAwareEngine engine = createEngine()) {
        }
     * Override to provide a custom {@link ThreadPool} with plugin-specific executors
            }
import org.apache.lucene.index.IndexWriterConfig;
            engine.refresh("test");
            }
            base.routing(),
        DataFormatRegistry registry = createRegistry();
 */
    // ── Extension points ──
            "test",
            null,
        try (DataFormatAwareEngine engine = createEngine()) {
                    .stream()
            .internalRefreshListener(internalListeners)
                    .flatMap(s -> s.dfGroupedSearchableFiles().values().stream())
        when(ms.getIndexSettings()).thenReturn(indexSettings);
import java.util.concurrent.CyclicBarrier;
        ParsedDocument base = createParsedDoc(id, routing);
import java.util.HashMap;
