            .build();
    @Before
            .clusterApplierService(clusterApplierService)
            // shuffle ops but make sure legacy ops are first
        LiveIndexWriterConfig currentIndexWriterConfig = engine.getCurrentIndexWriterConfig();
            .build();
            assertThat(luceneOp.opType(), equalTo(translogOp.opType()));
            .threadPool(config.getThreadPool())
                    SequenceNumbers.UNASSIGNED_SEQ_NO,
            while ((docId = seqNoDocValues.nextDoc()) != DocIdSetIterator.NO_MORE_DOCS) {
        MergePolicy mergePolicy,
    }
        return new LocalTranslog(
            if (randomInt(100) < 10) {
                    try {
        MergePolicy mergePolicy,
        assertEquals(replicaEngine.config().getCodec().getName(), codecService.codec(codecName).getName());
        }
        );
            ? emptyList()
        String translogUUID = Translog.createEmptyTranslog(
    protected static ParsedDocument testParsedDocument(
            translogPath,
        for (int i = 0; i < numOfOps; i++) {
            .externalRefreshListener(config.getExternalRefreshListener())
        String docId
        @Override
                                seqNo,
            }
        Store store,
                op.version(),
        return new EngineConfig.Builder().shardId(config.getShardId())
import org.opensearch.index.translog.InternalTranslogManager;
            .eventListener(config.getEventListener())
import org.apache.lucene.index.LiveIndexWriterConfig;
import org.opensearch.test.OpenSearchTestCase;
                        BytesRef binaryID = doc.getBinaryValue(IdFieldMapper.NAME);
 * You may obtain a copy of the License at
            .externalRefreshListener(config.getExternalRefreshListener())
        @Nullable ToLongBiFunction<Engine, Engine.Operation> seqNoForOperation,
            indexWriterFactory,
                Settings.builder()
        Store store,
            null,
                    greaterThanOrEqualTo(maxSeqNosInReader(reader))
    }
                source.endObject();
    }
            indexSettings,
        return internalEngine.getLocalCheckpointTracker().generateSeqNo();
        PrimaryTermSupplier(long initialTerm) {
        }
    protected Path replicaTranslogDir;
    }
        EngineConfig config,
        @Nullable BiFunction<Long, Long, LocalCheckpointTracker> localCheckpointTrackerSupplier,
            } else {
     * Gets a collection of tuples of docId, sequence number, and primary term of all live documents in the provided engine.
            store.createEmpty(config.getIndexSettings().getIndexVersionCreated().luceneVersion);
        final Supplier<RetentionLeases> retentionLeasesSupplier;
}
            }
                // replicas don't really care to about creation status of documents
                replicaEngine.refresh("test");
            pluginScripts.put("String.valueOf(grouping_criteria)", vars -> "grouping_criteria");
        return testParsedDocument(id, routing, document, source, mappingUpdate, false);
            .flushMergesAfter(TimeValue.timeValueMinutes(5))
    public EngineConfig config(
            .queryCache(config.getQueryCache())
import org.opensearch.script.ScriptEngine;
            searcher.search(new MatchAllDocsQuery(), collector);
        if (source != null) {
        if (engine instanceof InternalEngine) {
            indexSettings,
    protected Engine.Delete replicaDeleteForDoc(String id, long version, long seqNo, long startTime) {
            : Collections.singletonList(externalRefreshListener);
            indexSettings,
        Lucene.cleanLuceneIndex(store.directory());
        long primaryTerm,
        return internalEngine.hasSnapshottedCommits();
                    MediaTypeRegistry.JSON,
import org.opensearch.index.translog.TranslogDeletionPolicy;
    ) {
                op = new Engine.Delete(
            .indexReaderWarmer(mock(MergedSegmentWarmer.class))
    protected static ParseContext.Document testContextSpecificDocument(String groupingCriteria) {
        if (engine.config().getIndexSettings().isSoftDeleteEnabled()) {
                doc.add(seqID.primaryTerm);
        protected Map<ScriptContext<?>, MockScriptEngine.ContextCompiler> pluginContextCompilers() {
            });
    ) {
            seqNo -> {},
        public long getAsLong() {
import org.opensearch.common.xcontent.XContentFactory;
            () -> SequenceNumbers.NO_OPS_PERFORMED,
            .codecService(new CodecService(null, indexSettings, logger, List.of()))
        final String valuePrefix = (forReplica ? "r_" : "p_") + docId + "_";
 * SPDX-License-Identifier: Apache-2.0
            SequenceNumbers.NO_OPS_PERFORMED,
        if (maybeGlobalCheckpointSupplier == null) {
        for (Engine.Operation op : ops) {
        final ShardPath shardPath = new ShardPath(false, path, path, shardId);
import org.opensearch.index.translog.TranslogConfig;
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                        if ((docOffset + 1) % 4 == 0) {
        }
            final boolean isNestedDoc = includeNestedDocs && opType == Engine.Operation.TYPE.INDEX && randomBoolean();
    protected InternalEngine createEngine(
        assert engine instanceof InternalEngine : "expected InternalEngine, got: " + engine.getClass();
                IndexWriter createWriter(Directory directory, IndexWriterConfig iwc) throws IOException {
            maybeGlobalCheckpointSupplier == null ? null : () -> RetentionLeases.EMPTY,
            indexSettings,
    }
    }
            .eventListener(eventListener)
            }
            .warmer(config.getWarmer())
            new FsDirectoryFactory()
                Bits liveDocs = reader.getLiveDocs();
                    throw new UnsupportedOperationException("unknown version type: " + versionType);
        IndexSettings indexSettings,
    protected static final BytesReference B_1 = new BytesArray(new byte[] { 1 });
            .analyzer(iwc.getAnalyzer())
                }
                            + retainedOps
        } else {
        EngineConfig config,
        ScriptService scriptService = new ScriptService(Settings.EMPTY, scriptModule.engines, scriptModule.contexts);
    /**
import java.util.function.BiFunction;
     */
                op.primaryTerm()
                seqNoForRecovery = Long.parseLong(wrappedSafeCommit.get().getUserData().get(SequenceNumbers.LOCAL_CHECKPOINT_KEY)) + 1;
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            Settings.builder().put(config.getIndexSettings().getSettings()).build()
                    case NO_OP:
            .internalRefreshListener(config.getInternalRefreshListener())
     */
import org.opensearch.threadpool.ThreadPool;
            primaryTermSupplier,
                protected long doGenerateSeqNoForOperation(final Operation operation) {
                @Override
        } else {
    }
        try {
        final long globalCheckpoint = EngineTestCase.getTranslog(engine).getLastSyncedGlobalCheckpoint();
                final ParseContext.Document doc = new ParseContext.Document();
            public Searcher acquireSearcher(String source, SearcherScope scope, Function<Searcher, Searcher> wrapper)
        );
        final Sort indexSort,
            return new MockScriptEngine(pluginScriptLang(), pluginScripts(), nonDeterministicPluginScripts(), pluginContextCompilers());
            .endObject()
            .primaryTermSupplier(primaryTerm)
                    fail(
            translogPath,
        boolean shuffleOps,
import org.opensearch.common.concurrent.GatedCloseable;
                    version,
                    0
        for (Translog.Operation op : luceneOps.values()) {
                try {
                assertThat(luceneOp.getSource().source, equalTo(translogOp.getSource().source));
            .endObject()
            .circuitBreakerService(config.getCircuitBreakerService())
import org.opensearch.index.mapper.SourceFieldMapper;
        try (Translog.Snapshot snapshot = EngineTestCase.getTranslog(engine).newSnapshot()) {
    }
    public static void concurrentlyApplyOps(List<Engine.Operation> ops, InternalEngine engine) throws InterruptedException {
                break;
            .indexSort(config.getIndexSort())
            .indexSettings(indexSettings)
                break;
                    startGun.await();
        final LongSupplier globalCheckpointSupplier;
            .indexSort(config.getIndexSort())
                    return (indexWriterFactory != null)
                "performing [{}], v [{}], seq# [{}], term [{}]",
        storeReplica = createStore();
                allocationId.getId(),
            );
            .warmer(config.getWarmer())
            .field("type", "nested")
        if (shuffleOps) {
    }
        throws IOException {
                        applyOperation(engine, ops.get(docOffset));
                                SequenceNumbers.UNASSIGNED_SEQ_NO,
                    if (seqNos.add(seqNo) == false) {
                    default:
        return createEngine(
    }
        );
import org.opensearch.cluster.service.ClusterApplierService;
                    seqID,
        final Engine.Operation lastOp = ops.get(ops.size() - 1);
            final String translogUuid = Translog.createEmptyTranslog(
                // this allows to ignore the case where a document was found in the live version maps in
        assert translogManager instanceof InternalTranslogManager : "only InternalTranslogManager have translogs, got: "
            localCheckpointTrackerSupplier,
        }
            .globalCheckpointSupplier(config.getGlobalCheckpointSupplier())
            }
            createTranslogDeletionPolicy(INDEX_SETTINGS),
            }
     */
     */
import org.opensearch.common.settings.Settings;
            Store.OnClose.EMPTY,
            @Override
            .eventListener(config.getEventListener())
            globalCheckpointSupplier == null ? null : () -> RetentionLeases.EMPTY,
    protected InternalEngine createEngine(
            shardId,
                                primaryTerm.get(),
                searcher.search(new TermQuery(new Term("value", lastFieldValue)), collector);
            translogPath,
    }
        }
            .internalRefreshListener(intRefreshListenerList)
        ReferenceManager.RefreshListener internalRefreshListener,
    public static List<DocIdSeqNoAndSource> getDocIds(Engine engine, boolean refresh) throws IOException {
        final Directory directory = store.directory();
                while ((docOffset = offset.incrementAndGet()) < ops.size()) {
import org.opensearch.action.support.replication.ReplicationResponse;
import org.opensearch.plugins.ScriptPlugin;
            .endObject()
    protected static final BytesReference B_3 = new BytesArray(new byte[] { 3 });
        ParseContext.Document document = testDocument();
        int numOps,
import org.apache.lucene.search.Sort;
                assertThat(result.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
        boolean allowGapInSeqNo,
                                startTime,
                doc.add(new StoredField(SourceFieldMapper.NAME, byteRef.bytes, byteRef.offset, byteRef.length));
            logger.info(
    ) throws IOException {
        document.add(versionField);
    protected EngineConfig config(
            .queryCachingPolicy(config.getQueryCachingPolicy())
        }
                        }
            docs.sort(
            return pluginScripts;
                    version,
        translogHandler = createTranslogHandler(config.getIndexSettings(), internalEngine);
            allowDuplicate,
            .translogConfig(config.getTranslogConfig())
        Supplier<DocumentMapperForType> documentMapperForTypeSupplier,
import org.opensearch.script.MockScriptEngine;
            .queryCachingPolicy(config.getQueryCachingPolicy())
    }
        engine.ensureOpen();
            BigArrays.NON_RECYCLING_INSTANCE,
            seqNoForRecovery = engine.getMinRetainedSeqNo();
            NumericDocValues primaryTermDocValues = leaf.reader().getNumericDocValues(SeqNoFieldMapper.PRIMARY_TERM_NAME);
            "",
                primaryTerm.get()
                    Collections.singletonList(doc),
                int docOffset;
        return createTranslog(primaryTranslogDir, primaryTermSupplier);
            return get();
                }
        TranslogConfig translogConfig = new TranslogConfig(
    }
            includeNestedDocs,
                protected long doGenerateSeqNoForOperation(final Operation operation) {
                    .thenComparingLong(DocIdSeqNoAndSource::getPrimaryTerm)
    public List<Engine.Operation> generateHistoryOnReplica(
import org.apache.lucene.index.NumericDocValues;
            final ReplicationTracker replicationTracker = new ReplicationTracker(
 * specific language governing permissions and limitations
            routing,
            return term.get();
            .build();
        assert engine instanceof InternalEngine || engine instanceof NRTReplicationEngine
import org.opensearch.index.mapper.SourceToParse;
import org.opensearch.cluster.ClusterModule;
        final Directory directory = store.directory();
        }
            globalCheckpointSupplier = maybeGlobalCheckpointSupplier;
        }; // we don't need to notify anybody in this test
            switch (versionType) {
import org.apache.lucene.search.ReferenceManager;
            translogPath,
    public static void assertOpsOnReplica(
            return;
import org.opensearch.Version;
        BytesReference source,
    public static Engine.Result applyOperation(Engine engine, Engine.Operation operation) throws IOException {
            engine.refresh("test");
                    return (indexWriterFactory != null)
            store.associateIndexWithNewTranslog(translogUuid);
        final InternalEngine replicaEngine,
        switch (operation.operationType()) {
                                randomFrom(REPLICA, PEER_RECOVERY),
            null,
                            new Engine.Delete(
            engine.config().setEnableGcDeletes(false);
                                seqNo,
                        : super.createWriter(directory, iwc);
        return new Engine.Index(
        ReferenceManager.RefreshListener refreshListener,
    }
        assertBusy(() -> assertThat(getInFlightDocCount(engine), equalTo(0L)));
        }
            id,
    ) throws IOException {
                        operations.add(
            )
     * Reads all engine operations that have been processed by the engine from Lucene index.
    ) throws IOException {
            .build();
import org.opensearch.common.compress.CompressedXContent;
                    } catch (IOException e) {
    }
            eventListener,
                indexSettings,
     */
                            + maxSeqNo
                            throw new AssertionError("versionDocValues not found for doc[" + i + "] id[" + id + "]");
        return testParsedDocument(id, routing, testDocumentWithTextField(), new BytesArray("{ \"value\" : \"test\" }"), null);
        assert engine instanceof InternalEngine : "only InternalEngines have snapshotted commits, got: " + engine.getClass();
            seqNoForOperation
            @Override
        final int maxIdValue = randomInt(numOps * 2);
                    id,
            .indexSettings(config.getIndexSettings())
    protected final ShardId shardId = new ShardId(new Index("index", "_na_"), 0);
            .indexSort(config.getIndexSort())
        SeqNoFieldMapper.SequenceIDFields seqID = SeqNoFieldMapper.SequenceIDFields.emptySeqID();
                .put(config.getIndexSettings().getSettings())
        );
    protected static void assertVisibleCount(Engine engine, int numDocs, boolean refresh) throws IOException {
    }
                primaryTerm.get()
     * @throws InterruptedException if the thread was interrupted while blocking on the condition
            thread[i].start();
        final List<ReferenceManager.RefreshListener> extRefreshListenerList = externalRefreshListener == null
import org.opensearch.index.translog.LocalTranslog;
import org.apache.lucene.document.Document;
        for (Engine.Operation operation : operations) {
        }
            .store(store)
                // this allows to ignore the case where a document was found in the live version maps in
                        final long version = versionDocValues.longValue();
                        ? seqNoForOperation.applyAsLong(this, operation)
        @Nullable LongSupplier globalCheckpointSupplier
                }
        return mapperService;
        @Nullable IndexWriterFactory indexWriterFactory,
    }
        final Store store = config.getStore();
 * ownership. Elasticsearch licenses this file to you under
     */
                        String id = Uid.decodeId(Arrays.copyOfRange(binaryID.bytes, binaryID.offset, binaryID.offset + binaryID.length));
        );
        TranslogConfig translogConfig = new TranslogConfig(
            final XContentBuilder source = XContentFactory.jsonBuilder().startObject().field("field", "value");
            .toString();
        final Map<Long, Translog.Operation> luceneOps = readAllOperationsInLucene(engine).stream()
            .mergePolicy(mergePolicy)
            };
            indexSort,
            case NO_OP:
 * Licensed to Elasticsearch under one or more contributor
            .tombstoneDocSupplier(config.getTombstoneDocSupplier())
            final Translog.Operation luceneOp = luceneOps.get(translogOp.seqNo());
import static org.mockito.Mockito.mock;
            return docs;
        return result;
            maybeGlobalCheckpointSupplier,
            Settings.EMPTY,
    ) throws IOException {
        }
            .queryCache(config.getQueryCache())
            .endObject()
        final Sort indexSort,
                            throw new AssertionError("seqNoDocValues not found for doc[" + i + "] id[" + id + "]");
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
                        break;
import org.opensearch.threadpool.TestThreadPool;
            null,
            .analyzer(analyzer)
        Path translogPath,
    protected InternalEngine createEngine(
    public EngineConfig config(
        final List<Translog.Operation> operations = new ArrayList<>();
    ) throws IOException {
        final boolean incrementTermWhenIntroducingSeqNo = randomBoolean();
            new NamedXContentRegistry(ClusterModule.getNamedXWriteables()),
    protected Engine.Index indexForDoc(ParsedDocument doc) {
        }
            .warmer(config.getWarmer())
    ) {
        boolean firstOp = true;
            }
    }
 * GitHub history for details.
            : Collections.singletonList(internalRefreshListener);
            .similarity(config.getSimilarity())
        ToLongBiFunction<Engine, Engine.Operation> seqNoForOperation
                assertThat(result.getVersion(), equalTo(op.version()));
            refreshListener,
                    Long.parseLong(commit.getUserData().get(SequenceNumbers.MAX_SEQ_NO)),
    public static class ContextAwareCustomScriptPlugin extends Plugin implements ScriptPlugin {
            lastFieldValue = index.docs().get(0).get("value");
                        : super.doGenerateSeqNoForOperation(operation);
    protected void assertEngineCleanedUp(Engine engine, TranslogDeletionPolicy translogDeletionPolicy) throws Exception {
    ) throws Exception {
        int numOps,
                                0
    ) throws Exception {
            Translog.Operation op;
            if (randomBoolean()) {
            retentionLeasesSupplier = maybeRetentionLeasesSupplier;
                                doc.id(),
                if (minSeqNoToRetain <= translogOp.seqNo()) {
        @Nullable LongSupplier globalCheckpointSupplier
    /**
        final EngineConfig config
                @Override
import java.util.function.ToLongBiFunction;
    public EngineConfig config(
                break;
            );
    protected InternalEngine engine;
    protected static void assertVisibleCount(InternalEngine engine, int numDocs, boolean refresh) throws IOException {
                            engine.flush();
        final int startWithSeqNo = 0;
            .queryCache(config.getQueryCache())
        }
import org.opensearch.common.CheckedBiFunction;
    /**
        final String lastFieldValue;
                } catch (IOException ex) {
import java.util.function.LongSupplier;
            applyOperation(engine, operation);
            externalRefreshListener,
import org.apache.lucene.index.IndexWriterConfig;
                assertThat(result.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
                case INTERNAL:
        final long minSeqNoToRetain = Math.min(seqNoForRecovery, globalCheckpoint + 1 - retainedOps);
                    new BytesArray("{}"),
            return 0;
                        storedFields.document(docId, idFieldVisitor);
        ScriptModule scriptModule = new ScriptModule(Settings.EMPTY, Collections.singletonList(new ContextAwareCustomScriptPlugin()));
            .retentionLeasesSupplier(config.retentionLeasesSupplier())
        } else {
            source.endObject();
                    continue;
        final DocumentMapper nestedMapper = mapperService.documentMapperParser().parse("type", new CompressedXContent(nestedMapping));
        final List<Engine.Operation> ops = new ArrayList<>();
        @Nullable IndexWriterFactory indexWriterFactory
import org.opensearch.plugins.Plugin;
                            + translogOp
                assertThat(result.getVersion(), equalTo(op.version()));
    }
            .retentionLeasesSupplier(config.retentionLeasesSupplier())
        final Path path = createTempDir().resolve(shardId.getIndex().getUUID()).resolve(String.valueOf(shardId.id()));
                        "Operation not found seq# ["
    protected InternalEngine createEngine(Store store, Path translogPath) throws IOException {
            maybeGlobalCheckpointSupplier == null ? null : () -> RetentionLeases.EMPTY,
        return createEngine(defaultSettings, store, translogPath, newMergePolicy(), null);
            .globalCheckpointSupplier(config.getGlobalCheckpointSupplier())
        return createStore(newDirectory());
            localCheckpointTrackerSupplier,
        final Store store,
        return new EngineConfig.TombstoneDocSupplier() {
                        }
                config.getTranslogConfig().getTranslogPath(),
            .similarity(config.getSimilarity())
        @Nullable final BiFunction<Long, Long, LocalCheckpointTracker> localCheckpointTrackerSupplier,
                    break;
import java.util.Arrays;
            ? emptyList()
        return newUid(doc.id());
        boolean forReplica,
            while ((op = snapshot.next()) != null) {
import static org.hamcrest.Matchers.instanceOf;
                        throw new AssertionError("found multiple documents for seq=" + seqNo + " id=" + idFieldVisitor.getId());
            seqNo,
            };
            }
        try (Engine.Searcher searcher = engine.acquireSearcher("test")) {
            .threadPool(threadPool)
        final CircuitBreakerService breakerService,
            .globalCheckpointSupplier(config.getGlobalCheckpointSupplier())
        } else {
        final List<Translog.Operation> translogOps = new ArrayList<>();
    }
            final StoredFields storedFields = leaf.reader().storedFields();
        LongSupplier globalCheckpointSupplier,
        mapperService.merge(indexMetadata, MapperService.MergeReason.MAPPING_UPDATE);
        return operations;
                            new Engine.NoOp(seqNo, primaryTerm.get(), randomFrom(REPLICA, PEER_RECOVERY), startTime, "test-" + i)
     * Override config with ingestion engine configs
import org.apache.lucene.analysis.Analyzer;
/*
            .codecService(new CodecService(null, indexSettings, logger, List.of()))
     *
    public static long getInFlightDocCount(Engine engine) {
            .translogConfig(config.getTranslogConfig())
        Thread[] thread = new Thread[randomIntBetween(3, 5)];
        return new ParseContext.Document();
        Store store,
            .translogConfig(translogConfig)
            store,
    }
            translogPath,
    protected Store createStore(final IndexSettings indexSettings, final Directory directory) throws IOException {
                result = engine.noOp((Engine.NoOp) operation);
        for (IndexCommit commit : commits) {
    protected EngineConfig noOpConfig(IndexSettings indexSettings, Store store, Path translogPath, LongSupplier globalCheckpointSupplier) {
    protected Settings indexSettings() {
        if (refresh) {
                NumericDocValues primaryTermDocValues = reader.getNumericDocValues(SeqNoFieldMapper.PRIMARY_TERM_NAME);
                            + globalCheckpoint
import org.opensearch.common.CheckedFunction;
            primaryTermSupplier.getAsLong()
import org.opensearch.index.seqno.RetentionLeases;
        return doc;
                    versionField,
        replicaTranslogDir = createTempDir("translog-replica");
    }
        IndexSettings indexSettings,
        store = createStore();
            false
                    Searcher searcher = super.acquireSearcher(source, scope, wrapper);
        }
                default:
        return createEngine(defaultSettings, store, translogPath, newMergePolicy(), null, null, globalCheckpointSupplier);
        for (int i = 0; i < numOps; i++) {
            0
                        ? indexWriterFactory.createWriter(directory, iwc)
        final ReferenceManager.RefreshListener internalRefreshListener,
            firstOp = false;
                assertEngineCleanedUp(
        return createEngine(indexWriterFactory, localCheckpointTrackerSupplier, seqNoForOperation, config);
                NumericDocValues versionDocValues = reader.getNumericDocValues(VersionFieldMapper.NAME);
        InternalEngine internalEngine = new InternalEngine(config) {
            assertThat(luceneOp, notNullValue());
                    SequenceNumbers.UNASSIGNED_SEQ_NO,
    protected Store createStore(final Directory directory) throws IOException {
        return generateHistoryOnReplica(
                            + "], translog op ["
    public static InternalEngine createInternalEngine(
            IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
            .externalRefreshListener(extRefreshListenerList)
        CodecService codecService = new CodecService(null, INDEX_SETTINGS, logger, List.of());
        threadPool = new TestThreadPool(getClass().getName());
        IndexSettings indexSettings,
                doc.add(seqID.primaryTerm);
    ) throws IOException {
        }
        Engine.Operation.TYPE opType
    }
        return (InternalTranslogManager) translogManager;
            .put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING.getKey(), between(0, 1000))
import org.opensearch.script.ScriptService;
 *
            .build();
        IndexSettings indexSettings,
    ) {
            maybeGlobalCheckpointSupplier,
    public static void applyOperations(Engine engine, List<Engine.Operation> operations) throws IOException {
                replicaEngine.flush();
    }
    }
            .tombstoneDocSupplier(config.getTombstoneDocSupplier())
            Settings.EMPTY,
        );
     * Waits for all operations up to the provided sequence number to complete in the given internal engine.
            .primaryTermSupplier(config.getPrimaryTermSupplier())
        return new BytesArray(string.getBytes(Charset.defaultCharset()));
                }
    public static boolean hasSnapshottedCommits(Engine engine) {
        final MapperService mapperService = createMapperService();
            .build();
                                true,
     * @param seqNo the sequence number that the checkpoint must advance to before this method returns
        return createEngine(indexSettings, store, translogPath, mergePolicy, indexWriterFactory, null, null);
                @Override
import java.util.concurrent.atomic.AtomicInteger;
            .eventListener(config.getEventListener())
    ) {
            .store(config.getStore())
            shardPath,
        }
                }
        AtomicInteger offset = new AtomicInteger(-1);
        }
    protected static ParseContext.Document testDocument() {
import org.apache.lucene.document.NumericDocValuesField;
        mapperService.merge(indexMetadata, MapperService.MergeReason.MAPPING_UPDATE);
                engine.refresh("test");
        super.setUp();
            }
            .indexSort(config.getIndexSort())
        return ops;
                );
                    break;
            lastFieldValue = null;
        }
                case EXTERNAL:
import static org.hamcrest.Matchers.equalTo;
        if (refresh) {
            public ParsedDocument newNoopTombstoneDoc(String reason) {
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        return config(indexSettings, store, translogPath, mergePolicy, refreshListener, indexSort, globalCheckpointSupplier, null);
        Store store,
import org.opensearch.core.common.bytes.BytesArray;
        String id,
            .codecService(new CodecService(null, indexSettings, logger, List.of()))
            }
            while ((op = snapshot.next()) != null) {
        } else {
import org.opensearch.test.DummyShardLock;
            public ParsedDocument newDeleteTombstoneDoc(String id, String routing) {
        final MergePolicy mergePolicy,
        Path translogPath,
        Sort indexSort,
                                i,
                replicaEngine.refresh("test");
                                doc,
                    .put(IndexSettings.INDEX_CONTEXT_AWARE_ENABLED_SETTING.getKey(), true)
import org.apache.lucene.util.Bits;
    public static Term newUid(String id) {
                () -> SafeCommitInfo.EMPTY,
        }
import static java.util.Collections.shuffle;
    protected InternalEngine createEngine(IndexSettings indexSettings, Store store, Path translogPath, MergePolicy mergePolicy)
            .settings(
            .flushMergesAfter(config.getFlushMergesAfter())
        return new EngineConfig.Builder().shardId(config.getShardId())
        );
            shuffle(ops.subList(0, firstOpWithSeqNo), random());
        Field versionField = new NumericDocValuesField("_version", 0);
            new DummyShardLock(shardId),
        }
import org.opensearch.index.codec.CodecService;
import java.util.HashMap;
import static org.opensearch.index.engine.Engine.Operation.Origin.PEER_RECOVERY;
        }
        engine.getLocalCheckpointTracker().waitForProcessedOpsToComplete(seqNo);
    }
        return new ParsedDocument(versionField, seqID, id, routing, Arrays.asList(document), source, MediaTypeRegistry.JSON, mappingUpdate);
    }
    }
    public static CheckedBiFunction<String, Integer, ParsedDocument, IOException> nestedParsedDocFactory() throws Exception {
                    );
            @Override
import java.util.HashSet;
        );
     * Generate a new sequence number and return it. Only works on InternalEngines
                .build()
import org.opensearch.core.index.Index;
                replicaEngine.ensureOpen();
        document.add(seqID.primaryTerm);
            primaryTerm.get(),
                    assertAtMostOneLuceneDocumentPerSequenceNumber(engine.config().getIndexSettings(), searcher.getDirectoryReader());
                            )
     * The returned operations are sorted and de-duplicated, thus each sequence number will be have at most one operation.
    protected String codecName;
    }
        primaryTranslogDir = createTempDir("translog-primary");
            .build();
        final long retainedOps = engine.config().getIndexSettings().getSoftDeleteRetentionOperations();
                engine.ensureOpen();
import java.util.concurrent.CountDownLatch;
                assertTrue(seqNoDocValues.advanceExact(docId));
        @Override
        return operations;
import org.opensearch.index.VersionType;
    }
import org.opensearch.index.mapper.VersionFieldMapper;
                        final BytesRef source = doc.getBinaryValue(SourceFieldMapper.NAME);
        return new EngineConfig.Builder().shardId(config.getShardId())
import org.opensearch.index.mapper.MapperService;
        @Nullable ToLongBiFunction<Engine, Engine.Operation> seqNoForOperation,
    }
            );
        final Path translogPath,
public abstract class EngineTestCase extends OpenSearchTestCase {
            final String translogUuid = Translog.createEmptyTranslog(
                StoredFields storedFields = reader.storedFields();
            .globalCheckpointSupplier(globalCheckpointSupplier)
import java.util.function.Supplier;
        final int numOfOps = randomIntBetween(minOpCount, maxOpCount);
        IndexWriter createWriter(Directory directory, IndexWriterConfig iwc) throws IOException;
                Comparator.comparingLong(DocIdSeqNoAndSource::getSeqNo)
            store,
            .put(EngineConfig.INDEX_CODEC_SETTING.getKey(), codecName)
        }
            translogPath,
    }
        } finally {
            translogPath,
            .startObject("nested_field")
        if (Lucene.indexExists(directory) == false) {
        TranslogManager translogManager = engine.translogManager();
                    seqID,
                    -1,
import org.opensearch.test.IndexSettingsModule;
        final ReferenceManager.RefreshListener externalRefreshListener,
                    version = i;
        return internalEngine;
        Path translogPath,
                SequenceNumbers.NO_OPS_PERFORMED,
                    return IndexShard.wrapSearcher(searcher, readerWrapper);
                result = engine.delete((Engine.Delete) operation);
            mergePolicy,
        }
    }
            .startObject()
            shardId,
    public static MapperService createMapperService(String mapping) throws IOException {
     * Reads all engine operations that have been processed by the engine from Lucene index/Translog based on source.
            .retentionLeasesSupplier(config.retentionLeasesSupplier())
                update -> {},
            .threadPool(config.getThreadPool())
                doc.add(seqID.seqNoDocValue);
                assertThat(
                    routing,
                    id,
            .externalRefreshListener(config.getExternalRefreshListener())
        for (int i = 0; i < thread.length; i++) {
        IndexMetadata indexMetadata = IndexMetadata.builder("test")
                        operations.add(
        return new Term("_id", Uid.encodeId(id));
    ) {
     * Creates a tombstone document that only includes uid, seq#, term and version fields.
        @Nullable Sort indexSort,
            .primaryTermSupplier(config.getPrimaryTermSupplier())
            while (firstOpWithSeqNo < ops.size() && ops.get(firstOpWithSeqNo).seqNo() < 0) {
        final Engine.EventListener eventListener,
        );
        MapperService mapperService = MapperTestUtils.newMapperService(
        return new EngineConfig.Builder().shardId(config.getShardId())
    protected static final BytesReference B_2 = new BytesArray(new byte[] { 2 });
                SequenceNumbers.NO_OPS_PERFORMED,
            .tombstoneDocSupplier(tombstoneDocSupplier)
                    nestedField.field("field-" + i, "value-" + i);
        Path translogPath,
                    forReplica ? REPLICA : PRIMARY,
                        ? indexWriterFactory.createWriter(directory, iwc)
        final IndexSettings indexSettings,
            }
    protected IndexSettings defaultSettings;
            .circuitBreakerService(breakerService)
    protected Path primaryTranslogDir;
                                EngineTestCase.newUid(doc),
    }
            return nestedMapper.parse(new SourceToParse("test", docId, BytesReference.bytes(source), MediaTypeRegistry.JSON));
            REPLICA,
        return createEngine(
        ReferenceManager.RefreshListener externalRefreshListener,
        EngineConfig config,
            .queryCachingPolicy(config.getQueryCachingPolicy())
            case INDEX:
     * Returns the number of times a version was looked up either from version map or from the index.
            }
                maxSeqNo = SequenceNumbers.max(maxSeqNo, seqNoDocValues.longValue());
    protected TranslogHandler createTranslogHandler(IndexSettings indexSettings, Engine engine) {
                assertThat(seqNo, greaterThanOrEqualTo(0L));
                            + "retention policy ["
        }
        final Engine.EventListener eventListener = new Engine.EventListener() {
    ) {
 * compatible open source license.
            .warmer(warmer)
            .codecService(new CodecService(null, config.getIndexSettings(), logger, List.of()))
    }
                assertThat(collector.getTotalHits(), equalTo(1));
    protected InternalEngine createEngine(Store store, Path translogPath, LongSupplier globalCheckpointSupplier) throws IOException {
        }
import org.opensearch.core.indices.breaker.CircuitBreakerService;
    }
            newMergePolicy(),
        );
                sId -> false
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
            assertThat("translog operation [" + op + "] > max_seq_no[" + maxSeqNo + "]", op.seqNo(), lessThanOrEqualTo(maxSeqNo));
import java.util.Collections;
            }
import org.opensearch.index.mapper.Uid;
    protected InternalEngine createEngine(
        ReferenceManager.RefreshListener refreshListener,
    public static EngineConfig.TombstoneDocSupplier tombstoneDocSupplier() {
    protected TranslogHandler translogHandler;
                config.getTranslogConfig().getTranslogPath(),
            breakerService
    public static void assertConsistentHistoryBetweenTranslogAndLuceneIndex(Engine engine) throws IOException {
    protected Store store;
            translogPath,
                    version = forReplica ? i : Versions.MATCH_ANY;
        );
            .queryCache(config.getQueryCache())
import org.apache.lucene.search.TermQuery;
        try (Engine.Searcher searcher = engine.acquireSearcher("test")) {
        final MergePolicy mergePolicy,
            shardId,
    }
            final Engine.Operation op;
    }
    public static void assertAtMostOneLuceneDocumentPerSequenceNumber(Engine engine) throws IOException {
import org.apache.lucene.index.StoredFields;
    }
            shardId,
import org.opensearch.index.shard.ShardPath;
            .warmer(config.getWarmer())
            return new InternalTestEngine(config) {
                                SequenceNumbers.UNASSIGNED_SEQ_NO,
            warmer
                    null,
    /**
     * Asserts the provided engine has a consistent document history between translog and Lucene index.
            final TotalHitCountCollector collector = new TotalHitCountCollector();
        final Engine.Warmer warmer
                }
        int minOpCount,
                // a delete state and return true for the found flag in favor of code simplicity
        }
import java.util.Map;
import org.opensearch.common.Randomness;
                seqNo++;
        final List<ReferenceManager.RefreshListener> intRefreshListenerList = internalRefreshListener == null
        Path translogPath,
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.document.Field;
            assert maybeRetentionLeasesSupplier == null;
        MergePolicy mergePolicy,
import static java.util.Collections.emptyList;
        }
                shardId,
            mergePolicy,
        );
            .queryCache(config.getQueryCache())
                );
                final TotalHitCountCollector collector = new TotalHitCountCollector();
            .queryCachingPolicy(config.getQueryCachingPolicy())
            if (luceneOp.opType() == Translog.Operation.Type.INDEX) {
 *     http://www.apache.org/licenses/LICENSE-2.0
            breakerService,
        translogHandler = createTranslogHandler(config.getIndexSettings(), internalEngine);
            List<DocIdSeqNoAndSource> docs = new ArrayList<>();
            // delete
                // intentional
import org.apache.lucene.document.TextField;
            try (DirectoryReader reader = DirectoryReader.open(commit)) {
            .store(config.getStore())
                final ParsedDocument doc = isNestedDoc ? nestedParsedDocFactory.apply(id, nestedValues) : createParsedDoc(id, null);
                long seqNo = seqNoDocValues.longValue();
        if (lastFieldValue != null) {
            .codecService(new CodecService(null, config.getIndexSettings(), logger, List.of()))
        long seqNo = 0;
import java.util.List;
        return createEngine(indexSettings, store, translogPath, mergePolicy, null);
import org.opensearch.index.mapper.ParsedDocument;
            mergePolicy,
    public static ParsedDocument createParsedDoc(String id, String routing) {
            if (replicaEngine != null && replicaEngine.isClosed.get() == false) {
        Store store,
        assertEquals(currentIndexWriterConfig.getCodec().getName(), codecService.codec(codecName).getName());
    ) {
        }
            indexSort,
import org.apache.lucene.store.Directory;
                            )
        return config(
                    System.currentTimeMillis(),
            .queryCachingPolicy(config.getQueryCachingPolicy())
        }
        return new EngineConfig.Builder().shardId(shardId)
    protected Engine.Get newGet(boolean realtime, ParsedDocument doc) {
            while ((op = snapshot.next()) != null) {
                return new ParsedDocument(
            + engine.getClass();
            for (int copy = 0; copy < copies; copy++) {
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            if (op instanceof Engine.Index) {
                if (routing != null) {
        }
            "test",
            null,
    }
                                randomFrom(REPLICA, PEER_RECOVERY),
                () -> 0L,
                    id,
    }
            assertConsistentHistoryBetweenTranslogAndLuceneIndex(engine);
        final Engine.EventListener eventListener = new Engine.EventListener() {
            }
        @Nullable BiFunction<Long, Long, LocalCheckpointTracker> localCheckpointTrackerSupplier,
        InternalEngine internalEngine = (InternalEngine) engine;
    protected InternalEngine createEngineForWrapper(
    }
        String routing,
        // TODO randomize more settings
import org.apache.lucene.util.BytesRef;
 *
import org.opensearch.OpenSearchException;
                    null,
                    return seqNoForOperation != null
        return createEngine(defaultSettings, store, translogPath, newMergePolicy(), null, localCheckpointTrackerSupplier, null);
            if (nestedFieldValues > 0) {
        public long get() {
            .globalCheckpointSupplier(globalCheckpointSupplier)
import java.util.Comparator;
            indexSettings,
            globalCheckpointSupplier = replicationTracker;
import org.opensearch.index.translog.TranslogManager;
            .translogConfig(config.getTranslogConfig())
            while (seqNoDocValues.nextDoc() != DocIdSetIterator.NO_MORE_DOCS) {
                    forReplica && i >= startWithSeqNo && incrementTermWhenIntroducingSeqNo ? primaryTerm + 1 : primaryTerm,
                            continue;
            .threadPool(config.getThreadPool())
import org.opensearch.index.mapper.SeqNoFieldMapper;
        final Engine.Result result;
                // intentional
        for (Translog.Operation op : translogOps) {
            shuffle(ops.subList(firstOpWithSeqNo, ops.size()), random());
            .tombstoneDocSupplier(tombstoneDocSupplier())
    }
        assertVisibleCount(replicaEngine, lastFieldValue == null ? 0 : 1);
            internalRefreshListener,
        Engine.Warmer warmer
                    Collections.singletonList(doc),
            .globalCheckpointSupplier(config.getGlobalCheckpointSupplier())
    protected static final IndexSettings INDEX_SETTINGS = IndexSettingsModule.newIndexSettings("index", Settings.EMPTY);
            .similarity(config.getSimilarity())
            .retentionLeasesSupplier(config.retentionLeasesSupplier())
                engine.flush();
                                startTime,
            assert maybeRetentionLeasesSupplier != null;
            translogUUID,
        EngineConfig config
        if (randomBoolean()) {
        InternalTranslogManager internalTranslogManager = (InternalTranslogManager) translogManager;
        MergePolicy mergePolicy,
            public ParsedDocument newDeleteTombstoneDoc(String id) {
                startGun.countDown();
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                SequenceNumbers.NO_OPS_PERFORMED,
                Settings.builder()
            store.createEmpty(config.getIndexSettings().getIndexVersionCreated().luceneVersion);
        }
            if (rarely()) {
            scriptService
 * Modifications Copyright OpenSearch Contributors. See
        protected Map<String, Function<Map<String, Object>, Object>> nonDeterministicPluginScripts() {
            .startObject("type")
        final Store store,
    public static List<Translog.Operation> readAllOperationsInLucene(Engine engine) throws IOException {
                engine.refresh("test");
                }
            )
        CheckedBiFunction<String, Integer, ParsedDocument, IOException> nestedParsedDocFactory = nestedParsedDocFactory();
        return operations;
import java.util.concurrent.atomic.AtomicLong;
                NumericDocValues seqNoDocValues = reader.getNumericDocValues(SeqNoFieldMapper.NAME);
import org.junit.After;
            .internalRefreshListener(emptyList())
            }
        ParseContext.Document document = new ParseContext.Document();
    protected InternalEngine createEngine(
    protected static BytesArray bytesArray(String string) {
    }
    protected EngineConfig config(
        Store store,
            }
import org.opensearch.index.store.Store;
    protected static ParseContext.Document testDocumentWithGroupingCriteria() {
            .flushMergesAfter(config.getFlushMergesAfter())
                // a delete state and return false for the created flag in favor of code simplicity
                switch (opType) {
import org.apache.lucene.search.TotalHitCountCollector;
                    0
import org.opensearch.index.store.FsDirectoryFactory;
        public String pluginScriptLang() {
        final String nestedMapping = XContentFactory.jsonBuilder()
                                null,
    public EngineConfig config(
        return new Store(
     * Exposes a translog associated with the given engine for testing purpose.
        }
            .indexSettings(config.getIndexSettings())
        IndexSettings indexSettings,
            store,
        ReferenceManager.RefreshListener refreshListener
        public static final String NAME = "painless";
    }
                    }
        if (engine.isClosed.get() == false) {
            codecName = "default";
            indexSettings,
    }
                final ParseContext.Document doc = new ParseContext.Document();
        final CircuitBreakerService breakerService
 * Unless required by applicable law or agreed to in writing,
                assertThat(result.isFound(), equalTo(firstOp == false));
                        throw new AssertionError(e);
    @After
                        );
                throw new IllegalStateException("No operation defined for [" + operation + "]");
            if (luceneOp == null) {
                        }
        Store store,
        @Nullable IndexWriterFactory indexWriterFactory,
    public interface IndexWriterFactory {
                    System.currentTimeMillis(),
                    throw new AssertionError(e);
                doc.add(seqID.seqNoDocValue);
import org.opensearch.common.lucene.uid.Versions;
            directory,
import org.opensearch.core.common.bytes.BytesReference;
        return createEngine(null, null, null, config);
        BiFunction<Long, Long, LocalCheckpointTracker> localCheckpointTrackerSupplier,
        };
        Mapping mappingUpdate
            BytesRef ref = source.toBytesRef();
                        operations.add(
    }
        }
        for (Translog.Operation translogOp : translogOps) {
        return createMapperService("{\"properties\": {}}");
        if (randomBoolean()) {
            Translog.Operation op;
    ) throws IOException {
        InternalEngine internalEngine = createInternalEngine(indexWriterFactory, localCheckpointTrackerSupplier, seqNoForOperation, config);
            Map<String, Function<Map<String, Object>, Object>> pluginScripts = new HashMap<>();
            store,
    public EngineConfig copy(EngineConfig config, MergePolicy mergePolicy) {
import java.nio.charset.Charset;
                                i,
        super.tearDown();
                LeafReader reader = leafContext.reader();
import static org.hamcrest.Matchers.notNullValue;
            BigArrays.NON_RECYCLING_INSTANCE,
            null
            }
    }
            .similarity(config.getSimilarity())
import java.util.Set;
    }
                    case DELETE:
                operations.add(op);
            .put(IndexSettings.INDEX_GC_DELETES_SETTING.getKey(), "1h") // make sure this doesn't kick in on us
                Field versionField = new NumericDocValuesField(VersionFieldMapper.NAME, 0);
            .analyzer(config.getAnalyzer())
        return new Engine.Get(realtime, realtime, doc.id(), newUid(doc));
        Path translogPath,
            .flushMergesAfter(config.getFlushMergesAfter())
                doc.add(seqID.tombstoneField);
        return config(indexSettings, store, translogPath, newMergePolicy(), null, null, globalCheckpointSupplier);
        MergePolicy mergePolicy,
            thread[i].join();
            TranslogOperationHelper.create(engine.config()),
        MergePolicy mergePolicy,
import org.apache.lucene.index.Term;
import org.apache.lucene.search.DocIdSetIterator;
                Engine.IndexResult result = replicaEngine.index((Engine.Index) op);
                        : super.doGenerateSeqNoForOperation(operation);
        @Nullable IndexWriterFactory indexWriterFactory,
        assertThat(translogManager, instanceOf(InternalTranslogManager.class));
        };
            assertNoInFlightDocuments(engine);
        );
    }
        Lucene.cleanLuceneIndex(storeReplica.directory());
            } else {
                            + "], global checkpoint ["
            "",
package org.opensearch.index.engine;
            }
                }
import org.opensearch.index.translog.TranslogOperationHelper;
    protected final PrimaryTermSupplier primaryTerm = new PrimaryTermSupplier(1L);
        long maxSeqNo = SequenceNumbers.NO_OPS_PERFORMED;
    ) throws IOException {
                shardId,
                    .thenComparing((DocIdSeqNoAndSource::getId))
    @Override
            return Collections.emptyMap();
            Engine.Index index = (Engine.Index) lastOp;
    }
        return new InternalEngine(engineConfig, maxDocs, LocalCheckpointTracker::new, TranslogEventListener.NOOP_TRANSLOG_EVENT_LISTENER);
import org.opensearch.cluster.routing.AllocationId;
                    forReplica ? null : versionType,
import org.opensearch.index.seqno.LocalCheckpointTracker;
                // as deleted or not. This check is just signal regression so a decision can be made if it's
    protected final AllocationId allocationId = AllocationId.newInitializing();
        primaryTerm.set(randomLongBetween(1, Long.MAX_VALUE));
            shardId,
            testDocumentWithTextField(),
                doc.add(seqID.tombstoneField);
            null
            .circuitBreakerService(config.getCircuitBreakerService())
        };
                    false,
        }
        document.add(uidField);
            .build();
        internalEngine.translogManager().recoverFromTranslog(translogHandler, internalEngine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
                );
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(
import java.util.stream.Collectors;
    }
    protected static void assertVisibleCount(InternalEngine engine, int numDocs) throws IOException {
import org.opensearch.core.xcontent.MediaTypeRegistry;
            .flushMergesAfter(config.getFlushMergesAfter())
        IndexSettings indexSettings,
            defaultSettings,
        boolean allowDuplicate,
import static org.opensearch.index.engine.Engine.Operation.Origin.PRIMARY;
        document.add(new TextField("value", value, Field.Store.YES));
        final ReferenceManager.RefreshListener externalRefreshListener,
            // some codecs are read only so we only take the ones that we have in the service and randomly
        Store store,
            }
                        if (versionDocValues.advanceExact(i) == false) {
    }
                        final long primaryTerm = primaryTermDocValues.longValue();
            .queryCache(IndexSearcher.getDefaultQueryCache())
            int firstOpWithSeqNo = 0;
 *
                for (int i = 0; i < reader.maxDoc(); i++) {
        throws IOException {
        return new Engine.Index(newUid(doc), primaryTerm.get(), doc);
    @Override
        final TranslogConfig translogConfig = new TranslogConfig(
                            + "], "
                doc.add(seqID.seqNo);
        ParseContext.Document document,
            "test",
            .retentionLeasesSupplier(retentionLeasesSupplier)
    }
        }; // we don't need to notify anybody in this test
import org.apache.lucene.index.IndexWriter;
                    forReplica ? REPLICA : PRIMARY,
                        docs.add(new DocIdSeqNoAndSource(id, source, seqNo, primaryTerm, version));
import org.opensearch.index.fieldvisitor.IdOnlyFieldVisitor;
import org.opensearch.common.lucene.Lucene;
import org.opensearch.index.MapperTestUtils;
            null,
import org.opensearch.cluster.metadata.IndexMetadata;
        Set<Long> seqNos = new HashSet<>();
            if (recoverySource) {
    protected static ParsedDocument testParsedDocument(
            null,
/*
                }
            }
        final ReferenceManager.RefreshListener internalRefreshListener,
                firstOpWithSeqNo++;
                } catch (InterruptedException e) {
                );
        IndexSettings indexSettings,
                    return seqNoForOperation != null
        MergePolicy mergePolicy,
import org.opensearch.index.IndexSettings;
    public static long generateNewSeqNo(final Engine engine) {
    }
        }
                    null
            final long startTime = threadPool.relativeTimeInNanos();
            }
            // selected by lucene test case.
import org.opensearch.index.translog.Translog;
    /**
    protected InternalEngine createEngine(
            .retentionLeasesSupplier(config.retentionLeasesSupplier())
        @Nullable LongSupplier maybeGlobalCheckpointSupplier,
        VersionType versionType,
            assertThat(collector.getTotalHits(), equalTo(numDocs));
                                0
                }
                op = new Engine.Index(
    }
    }
            try {
        boolean includeNestedDocs
        String mapping = "{\"properties\": {}}";
    public EngineConfig copy(EngineConfig config, LongSupplier globalCheckpointSupplier) {
            }
                doc.add(versionField);
            .similarity(iwc.getSimilarity())
    public EngineConfig config(
            version,
            Translog.Operation op;
            for (LeafReaderContext leafContext : searcher.getIndexReader().leaves()) {
    public EngineConfig config(
                Engine.DeleteResult result = replicaEngine.delete((Engine.Delete) op);
        if (Lucene.indexExists(directory) == false) {
            );
        Store store,
            Settings.builder()
            .translogConfig(translogConfig)
            final long version;
            .warmer(config.getWarmer())
                        );
                    assertAndGetInternalTranslogManager(replicaEngine.translogManager()).getDeletionPolicy()
                try {
 * KIND, either express or implied.  See the License for the
/*
        }
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(
        try (Translog.Snapshot snapshot = engine.newChangesSnapshot("test", 0, Long.MAX_VALUE, false, randomBoolean())) {
    protected ThreadPool threadPool;
        final @Nullable LongSupplier maybeGlobalCheckpointSupplier,
                    }
            .analyzer(config.getAnalyzer())
    static long maxSeqNosInReader(DirectoryReader reader) throws IOException {
                    forReplica && i >= startWithSeqNo ? i * 2 : SequenceNumbers.UNASSIGNED_SEQ_NO,
        return maxSeqNo;
import org.apache.lucene.index.LeafReader;
        CircuitBreakerService breakerService
                        if (primaryTermDocValues.advanceExact(i) == false) {
                XContentBuilder nestedField = source.startObject("nested_field");
import org.opensearch.common.util.set.Sets;
                            + "], maxSeqNo ["
    }
        }
 * this file be licensed under the Apache-2.0 license or a
                for (int i = 0; i < nestedFieldValues; i++) {
        }
                    versionField,
        doc.setGroupingCriteria(groupingCriteria);
import org.apache.lucene.search.MatchAllDocsQuery;
            .circuitBreakerService(config.getCircuitBreakerService())
    public static final class PrimaryTermSupplier implements LongSupplier {
                    docId,
            mergePolicy,
            new NoneCircuitBreakerService(),
            assertThat(luceneOp.toString(), luceneOp.primaryTerm(), equalTo(translogOp.primaryTerm()));
        Store store,
    ) {
                    replicaEngine,
     */
        assertEquals(currentIndexWriterConfig.getCodec().getName(), codecService.codec(codecName).getName());
        @Nullable LongSupplier globalCheckpointSupplier,
                randomNonNegativeLong(),
            .settings(
                    MediaTypeRegistry.JSON,
        @SuppressWarnings("unchecked")
        return Settings.builder()
    }
    }
                document.add(new StoredField(SourceFieldMapper.RECOVERY_SOURCE_NAME, ref.bytes, ref.offset, ref.length));
    public static void assertMaxSeqNoInCommitUserData(Engine engine) throws Exception {
                return new ParsedDocument(
            try (Engine.Searcher searcher = replicaEngine.acquireSearcher("test")) {
     * Asserts that the max_seq_no stored in the commit's user_data is never smaller than seq_no of any document in the commit.
                // engine was closed
                seqID.tombstoneField.setLongValue(1);
        return testParsedDocument(
            .store(config.getStore())
        boolean allowGapInSeqNo,
    public List<Engine.Operation> generateHistoryOnReplica(
            globalCheckpointSupplier
            default:
    /**
            .translogConfig(config.getTranslogConfig())
            if (allowGapInSeqNo && rarely()) {
            }
                            + "]"
    protected InternalEngine createEngine(EngineConfig config) throws IOException {
        final @Nullable Supplier<RetentionLeases> maybeRetentionLeasesSupplier,
            internalRefreshListener,
import org.opensearch.common.Nullable;
        return new TranslogHandler(xContentRegistry(), indexSettings, engine);
            .indexSort(config.getIndexSort())
                        final long seqNo = seqNoDocValues.longValue();
        BiFunction<Long, Long, LocalCheckpointTracker> localCheckpointTrackerSupplier
            engine.refresh("test_get_doc_ids");
    }
        return noOpConfig(indexSettings, store, translogPath, null);
            store,
            }
        Path translogPath,
            final NumericDocValues seqNoDocValues = leaf.reader().getNumericDocValues(SeqNoFieldMapper.NAME);
        return config(
    protected Store createStore() throws IOException {
        ParseContext.Document document,
    }
            .flushMergesAfter(config.getFlushMergesAfter())
            final int copies = allowDuplicate && rarely() ? between(2, 4) : 1;
                    }
            searcher.search(new MatchAllDocsQuery(), collector);
            allowGapInSeqNo,
                result = engine.index((Engine.Index) operation);
                    forReplica && i >= startWithSeqNo && incrementTermWhenIntroducingSeqNo ? primaryTerm + 1 : primaryTerm,
        return internalEngine;
    /**
                return newDeleteTombstoneDoc(id, null);
    protected Translog createTranslog(Path translogPath, LongSupplier primaryTermSupplier) throws IOException {
 * software distributed under the License is distributed on an
            if (engine != null && engine.isClosed.get() == false) {
            .mergePolicy(config.getMergePolicy())
            .indexSettings(indexSettings)
        assertEquals(engine.config().getCodec().getName(), codecService.codec(codecName).getName());
    public static long getNumVersionLookups(Engine engine) {
    protected static final BytesArray SOURCE = bytesArray("{}");
import org.opensearch.index.seqno.ReplicationTracker;
            .collect(Collectors.toMap(Translog.Operation::seqNo, Function.identity()));
        );
import org.opensearch.common.unit.TimeValue;
    protected Engine.Index replicaIndexForDoc(ParsedDocument doc, long version, long seqNo, boolean isRetry) {
        }
        }
    @FunctionalInterface
        final List<Translog.Operation> operations = new ArrayList<>();
            System.nanoTime(),
    }
            false
            isRetry,
            .codecService(new CodecService(null, config.getIndexSettings(), logger, List.of()))
    }
            translogConfig,
    }
                    null
                }
            indexSort,
            .putMapping(mapping)
        return document;
            .put(
    /**
            translogPath,
                                EngineTestCase.newUid(doc),
                SeqNoFieldMapper.SequenceIDFields seqID = SeqNoFieldMapper.SequenceIDFields.emptySeqID();
            NumericDocValues seqNoDocValues = leaf.reader().getNumericDocValues(SeqNoFieldMapper.NAME);
    }
            .indexSettings(config.getIndexSettings())
        for (LeafReaderContext leaf : reader.leaves()) {
     */
        }
        Path translogPath,
import static org.opensearch.index.translog.TranslogDeletionPolicies.createTranslogDeletionPolicy;
            final int nestedValues = between(0, 3);
import org.opensearch.script.ScriptModule;
        final Store store = config.getStore();
     */
import org.apache.logging.log4j.Logger;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
    public static Translog getTranslog(Engine engine) {
     */
                }
        final List<Engine.Operation> operations = new ArrayList<>(numOps);
                            new Engine.Index(
        final long seqNoForRecovery;
        Mapping mappingUpdate,
    public static void assertAtMostOneLuceneDocumentPerSequenceNumber(IndexSettings indexSettings, DirectoryReader reader)
    ) {
    protected static ParseContext.Document testDocumentWithTextField(String value) {
            indexWriterFactory,
        }
        if (refresh) {
    public static MapperService createMapperServiceForContextAwareIndex() throws IOException {
            translogDeletionPolicy.assertNoOpenTranslogRefs();
    protected Store storeReplica;
            );
import org.opensearch.index.mapper.DocumentMapperForType;
    }
        }
        return createEngine(
import org.opensearch.index.translog.listener.TranslogEventListener;
        return createStore(INDEX_SETTINGS, directory);
        return new EngineConfig.Builder().shardId(config.getShardId())
                                null,
            seqNo++;
        document.setGroupingCriteria("grouping_criteria");
    }
            numOps,
            .indexSettings(indexSettings)
                document.add(new NumericDocValuesField(SourceFieldMapper.RECOVERY_SOURCE_NAME, 1));
            null,
    public static MapperService createMapperService() throws IOException {
        defaultSettings = IndexSettingsModule.newIndexSettings("test", indexSettings());
            .eventListener(config.getEventListener())
                IndexSettings.MAX_REFRESH_LISTENERS_PER_SHARD.getKey(),
        final IndexSettings indexSettings,
        BytesReference source,
        public void set(long newTerm) {
            pluginScripts.put("ctx.op='delete'", vars -> ((Map<String, Object>) vars.get("ctx")).put("op", "delete"));
    }
import org.apache.lucene.document.StoredField;
            .internalRefreshListener(config.getInternalRefreshListener())
                @Override
        }
                doc.add(uidField);
        return mapperService;
        return config(indexSettings, store, translogPath, mergePolicy, refreshListener, null, () -> SequenceNumbers.NO_OPS_PERFORMED);
                                -1,
            .documentMapperForTypeSupplier(documentMapperForTypeSupplier)
        engine = createEngine(store, primaryTranslogDir);
            .threadPool(config.getThreadPool())
    ) throws IOException {
                    case INDEX:
            .build();
 */
                                primaryTerm.get(),
        @Nullable BiFunction<Long, Long, LocalCheckpointTracker> localCheckpointTrackerSupplier,
    }
    }
                if (primaryTermDocValues.advanceExact(docId)) {
        @Nullable ToLongBiFunction<Engine, Engine.Operation> seqNoForOperation
            store.associateIndexWithNewTranslog(translogUuid);
            .circuitBreakerService(config.getCircuitBreakerService())
                } else {
        if (localCheckpointTrackerSupplier == null) {
        MergePolicy mergePolicy,
import java.nio.file.Path;
    public EngineConfig copy(EngineConfig config, Analyzer analyzer) {
import org.apache.lucene.index.DirectoryReader;
                    forReplica ? null : versionType,
        if (Arrays.asList(codecService.availableCodecs()).contains(name)) {
        List<IndexCommit> commits = DirectoryReader.listCommits(engine.store.directory());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .threadPool(config.getThreadPool())
            "test",
    }
        boolean recoverySource
            thread[i] = new Thread(() -> {
                // his check is just signal regression so a decision can be made if it's
    ) {
        @Nullable IndexWriterFactory indexWriterFactory,
            if (randomBoolean()) {
            } else {
            .analyzer(config.getAnalyzer())
                shardId,
                }
        return (docId, nestedFieldValues) -> {
                    version = randomBoolean() ? Math.max(i - 1, 0) : i;
    ) {
import org.opensearch.script.ScriptContext;
        return testDocumentWithTextField("test");
    public static void waitForOpsToComplete(InternalEngine engine, long seqNo) throws InterruptedException {
        Path translogPath,
        internalEngine.translogManager().recoverFromTranslog(translogHandler, internalEngine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
            assertMaxSeqNoInCommitUserData(engine);
 * under the License.
        int maxOpCount,
    public static void assertNoInFlightDocuments(Engine engine) throws Exception {
    /**
            )
        public ScriptEngine getScriptEngine(Settings settings, Collection<ScriptContext<?>> contexts) {
        final Path translogPath,
            store,
            }
        Path translogPath,
        Sort indexSort,
            if (randomBoolean()) {
                        );
            .store(config.getStore())
        boolean includeNestedDocs,
 */
            INDEX_SETTINGS,
    public static InternalEngine createEngine(EngineConfig engineConfig, int maxDocs) {
            : "only InternalEngines or NRTReplicationEngines have translogs, got: " + engine.getClass();
        final @Nullable Supplier<RetentionLeases> maybeRetentionLeasesSupplier,
            new NamedXContentRegistry(ClusterModule.getNamedXWriteables()),
                        ? seqNoForOperation.applyAsLong(this, operation)
        private final AtomicLong term;
                Field versionField = new NumericDocValuesField(VersionFieldMapper.NAME, 0);
        }
                        final IdOnlyFieldVisitor idFieldVisitor = new IdOnlyFieldVisitor();
    }
            createTempDir(),
    }
            engine.refresh("test");
            }
import org.opensearch.core.xcontent.NamedXContentRegistry;
            doc,
            final TotalHitCountCollector collector = new TotalHitCountCollector();
        IndexMetadata indexMetadata = IndexMetadata.builder("test")
        Path translogPath,
            IOUtils.close(replicaEngine, storeReplica, engine, store, () -> terminate(threadPool));
    protected InternalEngine replicaEngine;
import org.apache.lucene.codecs.Codec;
            this.term = new AtomicLong(initialTerm);
                            // We have to skip non-root docs because its _id field is not stored (indexed only).
            return ((InternalEngine) engine).getInFlightDocCount();
        Store store,
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                document.add(new StoredField(SourceFieldMapper.NAME, ref.bytes, ref.offset, ref.length));
    }
            .externalRefreshListener(config.getExternalRefreshListener())
        );
            new BytesArray("{ \"value\" : \"test\" }"),
        document.add(seqID.seqNoDocValue);
    protected InternalTranslogManager assertAndGetInternalTranslogManager(final TranslogManager translogManager) {
            .startObject("properties")
        );
import org.opensearch.index.seqno.SequenceNumbers;
                assertThat(result.isCreated(), equalTo(firstOp));
        final IndexWriterConfig iwc = newIndexWriterConfig();
            "",
            assertThat(collector.getTotalHits(), equalTo(numDocs));
            localCheckpointTrackerSupplier,
            .primaryTermSupplier(config.getPrimaryTermSupplier())
        try (Translog.Snapshot snapshot = engine.newChangesSnapshot("test", 0, Long.MAX_VALUE, false, randomBoolean())) {
        }
import org.apache.lucene.store.AlreadyClosedException;
 * not use this file except in compliance with the License.
        final long maxSeqNo = ((InternalEngine) engine).getLocalCheckpointTracker().getMaxSeqNo();
            } catch (AlreadyClosedException ignored) {
        if (engine instanceof InternalEngine) {
                    throw new OpenSearchException("failed to wrap searcher", ex);
        replicaEngine = createEngine(storeReplica, replicaTranslogDir);
import org.opensearch.index.mapper.RoutingFieldMapper;
        assertVisibleCount(engine, numDocs, true);
        String id,
        );
    }
            null,
        IndexSettings indexSettings,
        @Nullable final IndexWriterFactory indexWriterFactory,
                BytesRef byteRef = new BytesRef(reason);
    public void setUp() throws Exception {
            .similarity(config.getSimilarity())
            .primaryTermSupplier(config.getPrimaryTermSupplier())
    public static List<Engine.Operation> generateSingleDocHistory(
            recoverySource
                Field uidField = new Field(IdFieldMapper.NAME, Uid.encodeId(id), IdFieldMapper.Defaults.FIELD_TYPE);
            }
            }
        for (LeafReaderContext leaf : wrappedReader.leaves()) {
                        }
import static org.opensearch.index.engine.Engine.Operation.Origin.REPLICA;
            assertThat("lucene operation [" + op + "] > max_seq_no[" + maxSeqNo + "]", op.seqNo(), lessThanOrEqualTo(maxSeqNo));
        ClusterApplierService clusterApplierService
                            engine.refresh("test");
            .store(store)
            codecName = name;
    }
            this.term.set(newTerm);
        Field uidField = new Field("_id", Uid.encodeId(id), IdFieldMapper.Defaults.FIELD_TYPE);
            .tombstoneDocSupplier(tombstoneDocSupplier())
            .indexSort(indexSort)
                doc.add(versionField);
        @Nullable BiFunction<Long, Long, LocalCheckpointTracker> localCheckpointTrackerSupplier,
                (leases, listener) -> listener.onResponse(new ReplicationResponse()),
        currentIndexWriterConfig = replicaEngine.getCurrentIndexWriterConfig();
                throws EngineException {
        InternalEngine internalEngine = (InternalEngine) engine;
     */
    public static Term newUid(ParsedDocument doc) {
 */
            false
    protected InternalEngine createEngine(
        } else {
            globalCheckpointSupplier,
            .queryCachingPolicy(IndexSearcher.getDefaultQueryCachingPolicy())
            .putMapping(mapping)
    }
        String name = Codec.getDefault().getName();
import java.util.ArrayList;
import org.apache.lucene.index.MergePolicy;
            try (GatedCloseable<IndexCommit> wrappedSafeCommit = engine.acquireSafeIndexCommit()) {
    }
                    testParsedDocument(docId, null, testDocumentWithTextField(valuePrefix + i), SOURCE, null),
            }
        final Term id = newUid(docId);
        String routing,
                    break;
    protected EngineConfig noOpConfig(IndexSettings indexSettings, Store store, Path translogPath) {
 * the Apache License, Version 2.0 (the "License"); you may
            .internalRefreshListener(emptyList())
            .primaryTermSupplier(config.getPrimaryTermSupplier())
            indexSettings,
import org.opensearch.index.shard.IndexShard;
    public static List<Translog.Operation> readAllOperationsBasedOnSource(Engine engine) throws IOException {
import java.util.function.Function;
            .tombstoneDocSupplier(config.getTombstoneDocSupplier())
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
                case EXTERNAL_GTE:
        for (int i = 0; i < thread.length; i++) {
        return config(
            .externalRefreshListener(config.getExternalRefreshListener())
    public void tearDown() throws Exception {
        Randomness.shuffle(operations);
 * The OpenSearch Contributors require contributions made to
            }
import org.opensearch.index.mapper.ParseContext;
                        throw new IllegalStateException("Unknown operation type [" + opType + "]");
        CheckedFunction<DirectoryReader, DirectoryReader, IOException> readerWrapper
            return NAME;
                    doc.add(new StoredField(RoutingFieldMapper.NAME, routing));
        LongSupplier globalCheckpointSupplier
            externalRefreshListener,
                );
    }
            BigArrays.NON_RECYCLING_INSTANCE,
        if (lastOp instanceof Engine.Index) {
                );
import org.opensearch.common.util.BigArrays;
                op.seqNo(),
import org.opensearch.core.xcontent.XContentBuilder;
        final Logger logger
            .eventListener(config.getEventListener())
        CountDownLatch startGun = new CountDownLatch(thread.length);
                        if (rarely()) {
                between(10, 10 * IndexSettings.MAX_REFRESH_LISTENERS_PER_SHARD.get(Settings.EMPTY))
        ParseContext.Document doc = testDocumentWithTextField("criteria");
                        break;
            .circuitBreakerService(config.getCircuitBreakerService())
            case DELETE:
                    forReplica && i >= startWithSeqNo ? i * 2 : SequenceNumbers.UNASSIGNED_SEQ_NO,
                SeqNoFieldMapper.SequenceIDFields seqID = SeqNoFieldMapper.SequenceIDFields.emptySeqID();
    }
            assertAtMostOneLuceneDocumentPerSequenceNumber(engine);
        final DirectoryReader wrappedReader = indexSettings.isSoftDeleteEnabled() ? Lucene.wrapAllDocsLive(reader) : reader;
            .analyzer(config.getAnalyzer())
        }
            "test"
        );
            return new InternalTestEngine(config, IndexWriter.MAX_DOCS, localCheckpointTrackerSupplier) {
        return new Engine.Delete(id, newUid(id), seqNo, 1, version, null, REPLICA, startTime, SequenceNumbers.UNASSIGNED_SEQ_NO, 0);
            SequenceNumbers.UNASSIGNED_SEQ_NO,
 * this work for additional information regarding copyright
import java.util.Collection;
    /**
        final List<Engine.Operation> ops,
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
import org.junit.Before;
                        : super.createWriter(directory, iwc);
        MapperService mapperService = MapperTestUtils.newMapperService(
import org.opensearch.index.mapper.IdFieldMapper;
                translogOps.add(op);
import org.apache.lucene.index.LeafReaderContext;
            .mergePolicy(config.getMergePolicy())
            return Collections.emptyMap();
            retentionLeasesSupplier = replicationTracker::getRetentionLeases;
    }
        return document;
    protected static ParseContext.Document testDocumentWithTextField() {
                // Replicas don't really care to about found status of documents
            indexSettings,
                }
                        break;
    }
            mergePolicy,
            translogPath,
                seqID.tombstoneField.setLongValue(1);
            .internalRefreshListener(emptyList())
        EngineConfig config = config(indexSettings, store, translogPath, mergePolicy, null, indexSort, globalCheckpointSupplier);
                        }
    }
        boolean allowDuplicate,
        final @Nullable LongSupplier maybeGlobalCheckpointSupplier,
                try (Engine.Searcher searcher = engine.acquireSearcher("test")) {
                    null,
        @Nullable final ToLongBiFunction<Engine, Engine.Operation> seqNoForOperation,
                    if (liveDocs == null || liveDocs.get(i)) {
            .mergePolicy(config.getMergePolicy())
            int docId;
        );
 * license agreements. See the NOTICE file distributed with
            ops.add(op);
            eventListener,
    // A default primary term is used by engine instances created in this test.
            seqNoForOperation,
                op.operationType().name().charAt(0),
                doc.add(seqID.seqNo);
            newUid(doc),
        Sort indexSort,
            }
        return ((InternalEngine) engine).getNumVersionLookups();
import org.apache.lucene.index.IndexCommit;
            .mergePolicy(mergePolicy)
            createTempDir(),
                        if (seqNoDocValues.advanceExact(i) == false) {
            final String id = Integer.toString(randomInt(maxIdValue));
                .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
    public static ParsedDocument createParsedDoc(String id, String routing, boolean recoverySource) {
import org.opensearch.index.mapper.Mapping;
                operations.add(op);
            randomFrom(Engine.Operation.TYPE.values())
            engine.config().setEnableGcDeletes(false);
                            + translogOp.seqNo()
import org.opensearch.index.mapper.DocumentMapper;
                assertEngineCleanedUp(engine, assertAndGetInternalTranslogManager(engine.translogManager()).getDeletionPolicy());
            @Override
        EngineConfig.TombstoneDocSupplier tombstoneDocSupplier
    protected Translog createTranslog(LongSupplier primaryTermSupplier) throws IOException {
                        Document doc = storedFields.document(i, Sets.newHashSet(IdFieldMapper.NAME, SourceFieldMapper.NAME));
        return internalTranslogManager.getTranslog();
            .mergePolicy(config.getMergePolicy())
    /**
import org.opensearch.common.util.io.IOUtils;
import org.opensearch.core.index.shard.ShardId;
    }
    }
        }
        if (engine instanceof InternalEngine == false) {
        }
            globalCheckpointSupplier
                IndexWriter createWriter(Directory directory, IndexWriterConfig iwc) throws IOException {
import org.opensearch.action.index.IndexRequest;
        document.add(seqID.seqNo);
        try (Engine.Searcher searcher = engine.acquireSearcher("test_get_doc_ids", Engine.SearcherScope.INTERNAL)) {
    }
import java.io.IOException;
