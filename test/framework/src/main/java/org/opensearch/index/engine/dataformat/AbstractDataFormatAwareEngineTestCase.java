                assertThat(snapshot.getSegments().size(), greaterThan(0));  
            false,
     * configuration (e.g., {@link org.opensearch.index.codec.CodecService} for Lucene).
                        }
import org.opensearch.index.mapper.ParsedDocument;  
 * this file be licensed under the Apache-2.0 license or a
            "test",
                for (Segment seg : snapshot.getSegments()) {
            SequenceNumbers.UNASSIGNED_SEQ_NO,
}
        org.opensearch.index.mapper.MappedFieldType versionFieldType = mock(org.opensearch.index.mapper.MappedFieldType.class);
            var stats = engine.docStats();  
                assertThat(ref.get().getSegments().size(), greaterThan(0));  
    }
            .threadPool(threadPool)
            SeqNoFieldMapper.SequenceIDFields.emptySeqID(),
     * Creates a fresh {@link Store} backed by a temporary directory for each test.
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(  
        }  
                engine.refresh("batch-" + batch);
                    .sum();
        try (DataFormatAwareEngine engine = createEngine()) {
    protected Store createStore() throws IOException {
    /** Snapshot generation must strictly increase across refreshes. */  
                assertThat(totalRows, equalTo((long) numDocs));  
            .committerFactory(committerFactory)  
            assertThat(stats.getCount(), greaterThanOrEqualTo(0L));
            0
            engine.refresh("test");
            }
    /** Returns the DataFormatPlugin that provides the IndexingExecutionEngine under test. */  
import static org.hamcrest.Matchers.greaterThan;
 * <p>Subclasses provide the engine-specific components via {@link #createDataFormatPlugin()}  
                }
     * (e.g., the {@code parquet_native_write} executor for the Parquet engine).
import static org.opensearch.index.engine.EngineTestCase.createParsedDoc;
import org.opensearch.index.mapper.SeqNoFieldMapper;
            engine.flush(false, true);
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;  
                    }  
            indexSettings,
        try (DataFormatAwareEngine engine = createEngine()) {
            terminate(threadPool);
     * Subclasses may override to provide additional field type mappings.
    @Override  
            .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
            }  
            for (Thread t : threads)
            )  
    public void testConcurrentIndexThenRefreshAndFlush() throws Exception {
 * compatible open source license.
import java.util.Map;
import org.opensearch.index.seqno.RetentionLeases;  
 */  
        shardId = new ShardId(new Index("test", "_na_"), 0);  
import java.util.ArrayList;
            indexSettings,
     * and bootstraps the store's commit metadata.
            assertThat(stats.getCount(), equalTo((long) numDocs));
                .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
                    } catch (Exception e) {
        Path translogPath = createTempDir();
                assertThat("total rows must match indexed docs", totalRows, equalTo((long) totalDocs));
    /**
                    long gen = ref.get().getGeneration();
    /** Returns the SearchBackEndPlugin for reader manager creation. */  
            }  
        return new Store(  
                            maxSeqNo.accumulateAndGet(result.getSeqNo(), Math::max);
            .tombstoneDocSupplier(tombstoneDocSupplier())  
import org.opensearch.common.util.BigArrays;
import java.io.IOException;  
            shardPath,  
        Path translogPath,
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo((long) totalDocs - 1));
        Path path = createTempDir().resolve(shardId.getIndex().getUUID()).resolve(String.valueOf(shardId.id()));
            .store(store)  
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
    /**
                    .flatMap(s -> s.dfGroupedSearchableFiles().values().stream())  
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
        CommitterFactory committerFactory = createCommitterFactory(store);
            List<Exception> exceptions = Collections.synchronizedList(new ArrayList<>());
    /** Flushes after indexing and verifies the catalog snapshot preserves total row count. */
    @Override  
        when(seqNoFieldType.name()).thenReturn("_seq_no");
 * {@link IndexingExecutionEngine} implementation.
                t.join();
    }  
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of(createSearchBackEndPlugin()));  
                        barrier.await();
        store = createStore();  
    protected ThreadPool buildThreadPool() {
            store.close();  
            engine.flush(false, true);
    public void setUp() throws Exception {
                    .stream()  
        when(versionFieldType.typeName()).thenReturn("_version");  
                long totalRows = snapshot.getSegments()
        when(documentMapper.getVersion()).thenReturn(1L);  
import org.opensearch.index.store.Store;
 * The OpenSearch Contributors require contributions made to  
 *
    public void testTranslogRecordsAllPrimaryOps() throws IOException {
    /** Returns the data format name (e.g., "composite", "parquet"). */  
        return config -> new InMemoryCommitter(store);
                try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
            .flushMergesAfter(TimeValue.timeValueMinutes(5))  
                    .mapToLong(WriterFileSet::numRows)
import org.opensearch.plugins.PluginsService;
                    .flatMap(s -> s.dfGroupedSearchableFiles().values().stream())
            }
        try (
            int numBatches = randomIntBetween(3, 6);
    public void tearDown() throws Exception {
/**
import org.opensearch.index.engine.DataFormatAwareEngine;
                fail("concurrent indexing failed with " + failures.get() + " exceptions" + exceptions);  
     * committer factory, and refresh listeners. Subclasses may override to add engine-specific  
     * Builds the {@link EngineConfig} wiring together the store, translog, data format registry,
            for (Thread t : threads)  
                .build()
        List<ReferenceManager.RefreshListener> internalListeners
            BigArrays.NON_RECYCLING_INSTANCE,
            IndexWriter writer = new IndexWriter(
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), dataFormatName())
            writer.setLiveCommitData(commitData.entrySet());
            shardId,
    }
                        Exception failure;
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)  
                    .sum();  
            primaryTerm.get(),
import static org.opensearch.index.engine.EngineTestCase.tombstoneDocSupplier;  
    /** Override to provide a custom CommitterFactory (e.g., LuceneCommitterFactory). Default uses InMemoryCommitter. */  
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
            AtomicLong maxSeqNo = new AtomicLong(-1);
                threads[t] = new Thread(() -> {  
            shardId,
                // Verify segment generation uniqueness
        bootstrapStoreWithMetadata(store, uuid);  
                        assertThat(wfs.files().isEmpty(), equalTo(false));
    }
import org.opensearch.index.IndexSettings;
    }
                    .mapToLong(WriterFileSet::numRows)
            int totalDocs = randomIntBetween(20, 50);
    }  
    /** Every primary-origin index operation must produce a non-null translog location. */
            for (int t = 0; t < numThreads; t++) {
            commitData.put(SequenceNumbers.LOCAL_CHECKPOINT_KEY, Long.toString(SequenceNumbers.NO_OPS_PERFORMED));
                CatalogSnapshot snapshot = ref.get();
            int numDocs = randomIntBetween(3, 10);  
            dir,  
                    .stream()  
            assertThat(maxSeqNo.get(), equalTo((long) totalDocs - 1));  
    }
            assertThat(engine.lastRefreshedCheckpoint(), equalTo((long) numDocs - 1));
            }
 * translog, store, and commit infrastructure.
        threadPool = buildThreadPool();
                        assertThat(wfs.numRows(), greaterThan(0L));
                    .mapToLong(WriterFileSet::numRows)
            new DummyShardLock(shardId),
            }  
            // Index concurrently  
import org.apache.lucene.index.Term;
            -1,
            for (int i = 0; i < numDocs; i++) {
import org.opensearch.core.index.Index;  
    protected EngineConfig buildEngineConfig(  
import org.opensearch.index.mapper.MapperService;
import java.util.HashMap;
import org.apache.lucene.search.ReferenceManager;
            for (int batch = 0; batch < numBatches; batch++) {  
            assertThat(engine.translogManager().getTranslogStats().estimatedNumberOfOperations(), equalTo(numDocs));  
                // Verify all generations are unique
        return new TestThreadPool(getClass().getName());  
     * Creates a mock {@link MapperService} that returns
            }
                        int idx;  
        when(seqNoFieldType.typeName()).thenReturn("_seq_no");  
            VersionType.INTERNAL,
            commitData.put(SequenceNumbers.MAX_SEQ_NO, Long.toString(SequenceNumbers.NO_OPS_PERFORMED));
                        failures.incrementAndGet();  
    // ── Infrastructure ──
import org.opensearch.plugins.SearchBackEndPlugin;
    // ── Extension points ──
    // ── Common tests ──
     * Override to provide a custom {@link ThreadPool} with plugin-specific executors
import org.opensearch.threadpool.ThreadPool;
                Engine.IndexResult result = engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
        when(ms.fieldType("_version")).thenReturn(versionFieldType);
            Thread[] threads = new Thread[numThreads];
    public void testIndexAndRefreshProducesSegments() throws IOException {
                                throw failure;
                        exceptions.add(e);
     */
            }  
                Engine.IndexResult result = engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
                    assertTrue("duplicate generation: " + seg.generation(), gens.add(seg.generation()));
public abstract class AbstractDataFormatAwareEngineTestCase extends OpenSearchTestCase {
        return Settings.EMPTY;
                                .getFailure()) != null) {
    }  
        try (DataFormatAwareEngine engine = createEngine()) {  
        return new Engine.Index(
            for (int i = 0; i < numDocs; i++) {
            .primaryTermSupplier(primaryTerm::get)
import static org.hamcrest.Matchers.notNullValue;
        ) {
        return new ParsedDocument(  
import org.opensearch.index.mapper.Uid;
                Set<Long> gens = new HashSet<>();
    private DataFormatRegistry createRegistry() {  
            createDocumentInput()  
                long totalRows = snapshot.getSegments()
                threads[t].start();
    ) {
    // ── Helpers ──
            System.nanoTime(),  
 * Abstract base class for testing {@link DataFormatAwareEngine} with any  
import java.util.Set;
import org.opensearch.index.engine.dataformat.stub.MockDocumentInput;
 * <p>Tests cover: indexing, refresh, flush, catalog snapshots, concurrency,
import java.util.Collections;  
    @SuppressWarnings("unchecked")
 * orchestration layer with the injected engine.  
                store.directory(),  
            AtomicInteger docCounter = new AtomicInteger(0);  
    protected void bootstrapStoreWithMetadata(Store store, String translogUUID) throws IOException {  
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(batch), null)));
                            Engine.IndexResult result = engine.index(indexOp(createParsedDocWithInput(threadId + "_" + d, null)));
     */
    /** Override to add plugin-specific index settings (e.g., sort config, parquet settings). */
    /**  
    protected ParsedDocument createParsedDocWithInput(String id, String routing) {
            base.docs(),
        org.opensearch.index.mapper.DocumentMapper documentMapper = mock(org.opensearch.index.mapper.DocumentMapper.class);
     * Creates a fully wired {@link DataFormatAwareEngine} with translog, store, and the
                    } catch (Exception e) {
                assertThat(snapshot.getSegments().size(), equalTo(numBatches));
    public void testFlushCommitsAndPreservesData() throws IOException {  
                t.join();
import java.util.concurrent.atomic.AtomicLong;  
        try {
import org.opensearch.index.translog.Translog;
import org.opensearch.test.OpenSearchTestCase;
        try (DataFormatAwareEngine engine = createEngine()) {
import org.apache.lucene.index.IndexWriter;
                    assertThat("generation must advance monotonically", gen, greaterThan(prevGen));  
            for (int t = 0; t < numThreads; t++) {
        return new DataFormatRegistry(pluginsService);
 * SPDX-License-Identifier: Apache-2.0
        List<ReferenceManager.RefreshListener> externalListeners,  
                    }
import static org.mockito.Mockito.mock;
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
    protected Engine.Index indexOp(ParsedDocument doc) {  
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
            assertThat(failures.get(), equalTo(0));
                    .stream()
import java.util.HashSet;
            .globalCheckpointSupplier(() -> SequenceNumbers.NO_OPS_PERFORMED)  
    /** Concurrent indexing followed by refresh and flush must preserve total row count. */
            "",  
import org.opensearch.common.lucene.Lucene;
import static org.hamcrest.Matchers.equalTo;
    protected Settings additionalIndexSettings() {  
        }
    protected abstract String dataFormatName();
            base.id(),  
            writer.commit();  
        } finally {
     * expects: translog UUID, sequence number markers, and history UUID.
    }
            int numDocs = randomIntBetween(3, 10);  
                });  
            new FsDirectoryFactory()
import org.apache.lucene.store.Directory;  
     */
                    try {
            Store.OnClose.EMPTY,
    /** Each refresh cycle produces a new segment; all generations must be unique. */
    }
            }
    }
        }
            .mapperService(createMockMapperService(indexSettings))
    /**  
        when(versionFieldType.name()).thenReturn("_version");
            base.routing(),
            .internalRefreshListener(internalListeners)
                threads[t] = new Thread(() -> {  
     * Subclasses may override to provide a store with custom directory implementations.
        }
        }  
                final int threadId = t;
    protected DataFormatAwareEngine createEngine() throws IOException {  
                }  
                });
                threads[t].start();
        }  
     * field types for metadata fields required by {@link DataFormatAwareEngine#indexIntoEngine}.  
import java.util.UUID;  
 *  
                CatalogSnapshot snapshot = ref.get();
            int numThreads = randomIntBetween(2, 4);  
            }
import org.opensearch.index.engine.EngineConfig;  
                CatalogSnapshot snapshot = ref.get();  
        PluginsService pluginsService = mock(PluginsService.class);
    }  
import org.apache.lucene.index.IndexWriterConfig;
                engine.refresh("cycle-" + i);  
                }
        try (DataFormatAwareEngine engine = createEngine()) {
    }
                        while ((idx = docCounter.getAndIncrement()) < totalDocs) {
import org.opensearch.core.index.shard.ShardId;
                        }  
            CyclicBarrier barrier = new CyclicBarrier(numThreads);
import org.opensearch.index.store.FsDirectoryFactory;  
    protected DocumentInput<?> createDocumentInput() {  
        DataFormatRegistry registry = createRegistry();  
                        for (int d = 0; d < docsPerThread; d++) {  
    }
    protected AtomicLong primaryTerm;
import org.opensearch.cluster.metadata.IndexMetadata;
            commitData.put(Translog.TRANSLOG_UUID_KEY, translogUUID);  
    }
    protected ThreadPool threadPool;
    }
            .build();
     */  
import org.opensearch.test.IndexSettingsModule;
                for (Segment seg : snapshot.getSegments()) {  
                            }  
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
        return new EngineConfig.Builder().shardId(shardId)  
    public void testMultipleRefreshesAccumulateSegmentsWithUniqueGenerations() throws IOException {  
            translogPath,  
                    .setOpenMode(IndexWriterConfig.OpenMode.CREATE)
                    }  
            int docsPerThread = randomIntBetween(10, 25);
            long prevGen = -1;  
     */
            int numThreads = randomIntBetween(2, 4);
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", settingsBuilder.build());  
                assertThat(result.getTranslogLocation(), notNullValue());
    public void testSnapshotGenerationAdvancesMonotonically() throws IOException {
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
        TranslogConfig translogConfig = new TranslogConfig(
            for (int i = 0; i < randomIntBetween(3, 6); i++) {
            .externalRefreshListener(externalListeners)
                assertThat(totalRows, equalTo((long) numBatches));
        MapperService ms = mock(MapperService.class);
            new Term(IdFieldMapper.NAME, Uid.encodeId(doc.id())),
import java.nio.file.Path;
            Settings.builder()
            SequenceNumbers.UNASSIGNED_SEQ_NO,  
import org.opensearch.index.engine.exec.commit.CommitterFactory;
            for (int i = 0; i < numDocs; i++) {
        org.opensearch.index.mapper.MappedFieldType seqNoFieldType = mock(org.opensearch.index.mapper.MappedFieldType.class);
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo((long) numDocs - 1));
     */
                            if ((failure = engine.index(indexOp(createParsedDocWithInput(Integer.toString(idx), null)))  
        );
                new IndexWriterConfig(Lucene.STANDARD_ANALYZER).setMergePolicy(NoMergePolicy.INSTANCE)
        super.tearDown();
            int numDocs = randomIntBetween(3, 10);  
                assertThat(result.getSeqNo(), equalTo((long) i));  
                    assertTrue("duplicate generation: " + seg.generation(), gens.add(seg.generation()));
import org.opensearch.index.engine.dataformat.stub.InMemoryCommitter;
                        barrier.await();
        primaryTerm = new AtomicLong(randomLongBetween(1, Long.MAX_VALUE));
import org.opensearch.common.settings.Settings;  
        when(ms.documentMapper()).thenReturn(documentMapper);
     * Bootstraps the store's Lucene commit with the metadata that {@link DataFormatAwareEngine}  
        Store store,
    public void testDocStatsReflectsIndexedDocuments() throws IOException {
    }
    /**
        Directory dir = newDirectory();
import java.util.concurrent.CyclicBarrier;
    }  
    }
        try (DataFormatAwareEngine engine = createEngine()) {  
            CyclicBarrier barrier = new CyclicBarrier(numThreads);
                        failures.incrementAndGet();
        return ms;
                    assertThat(seg.dfGroupedSearchableFiles().isEmpty(), equalTo(false));
    public void testConcurrentIndexingPreservesCheckpoint() throws Exception {
     * Default creates a standard {@link TestThreadPool}.  
            Versions.MATCH_ANY,  
        ShardPath shardPath = new ShardPath(false, path, path, shardId);
            engine.refresh("test");
            int numDocs = randomIntBetween(5, 15);
            if (failures.get() > 0) {
            }
            engine.refresh("after-indexing");
            commitData.put(Engine.MAX_UNSAFE_AUTO_ID_TIMESTAMP_COMMIT_ID, "-1");  
                // Verify total row count
    }
 */
            }
            AtomicInteger failures = new AtomicInteger(0);  
                    prevGen = gen;
                    .sum();  
                Engine.IndexResult result = engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));  
    /** Indexes documents, refreshes, and verifies segments have unique generations and positive row counts. */  
                assertNull("expected no failure but got: " + result.getFailure(), result.getFailure());  
import org.opensearch.index.shard.ShardPath;
            .mergePolicy(NoMergePolicy.INSTANCE)
        super.setUp();
            base.version(),
 *
            false
            int totalDocs = numThreads * docsPerThread;
            commitData.put(Engine.HISTORY_UUID_KEY, UUID.randomUUID().toString());
        );  
/*  
import org.opensearch.index.translog.TranslogConfig;  
                Set<Long> gens = new HashSet<>();  
        when(ms.fieldType("_seq_no")).thenReturn(seqNoFieldType);  
    /** Override to provide a custom DocumentInput for the engine under test. Default uses MockDocumentInput. */
    protected Store store;
    }  
import org.opensearch.index.VersionType;  
import org.apache.lucene.index.NoMergePolicy;  
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo((long) numDocs - 1));  
    protected abstract SearchBackEndPlugin<?> createSearchBackEndPlugin();
        );
                    for (WriterFileSet wfs : seg.dfGroupedSearchableFiles().values()) {  
            Map<String, String> commitData = new HashMap<>();
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    /** Multi-threaded indexing must produce a contiguous checkpoint with no gaps. */  
        return new DataFormatAwareEngine(buildEngineConfig(store, translogPath, List.of(), List.of()));
            doc,  
            Engine.Operation.Origin.PRIMARY,
import org.opensearch.common.lucene.uid.Versions;
import org.opensearch.index.engine.exec.Segment;  
        );
                long totalRows = ref.get()
 * and {@link #createSearchBackEndPlugin()}. The base class handles all DFAE lifecycle,
import java.util.concurrent.atomic.AtomicInteger;
import org.opensearch.Version;
            Thread[] threads = new Thread[numThreads];  
 * merge invariants, and failure handling — all driven through the real DFAE
    protected abstract DataFormatPlugin createDataFormatPlugin();
    protected MapperService createMockMapperService(IndexSettings indexSettings) {  
        try (DataFormatAwareEngine engine = createEngine()) {
                    try {
        }
import org.opensearch.index.engine.Engine;
            // Refresh and flush  
import org.opensearch.test.DummyShardLock;  
    /** DocStats count must reflect the number of indexed documents after refresh. */  
    protected ShardId shardId;  
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
import java.util.List;  
            .translogConfig(translogConfig)
            for (int i = 0; i < numDocs; i++) {
        return new MockDocumentInput();
     * plugin-provided {@link IndexingExecutionEngine}. Each call creates a fresh translog  
            base.getMediaType(),
            AtomicInteger failures = new AtomicInteger(0);  
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo((long) totalDocs - 1));
import org.opensearch.threadpool.TestThreadPool;  
import org.opensearch.common.concurrent.GatedCloseable;  
        }  
    /**
import org.opensearch.index.engine.exec.WriterFileSet;
        }
                    .getSegments()
            .indexSettings(indexSettings)
import org.opensearch.index.seqno.SequenceNumbers;
        ParsedDocument base = createParsedDoc(id, routing);
        try (DataFormatAwareEngine engine = createEngine()) {
            .dataFormatRegistry(registry)
        }  
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
    protected CommitterFactory createCommitterFactory(Store store) {
            .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)
package org.opensearch.index.engine.dataformat;
        Settings.Builder settingsBuilder = Settings.builder()  
            base.source(),  
import org.opensearch.common.unit.TimeValue;
    }
                assertThat(snapshot.getSegments().size(), greaterThan(0));  
            }
import static org.mockito.Mockito.when;  
        when(ms.getIndexSettings()).thenReturn(indexSettings);
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
import org.opensearch.index.mapper.IdFieldMapper;
            null,
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of(createDataFormatPlugin()));
                    .flatMap(s -> s.dfGroupedSearchableFiles().values().stream())
            .put(additionalIndexSettings());
        );
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
