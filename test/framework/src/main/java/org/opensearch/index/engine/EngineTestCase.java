        public long getAsLong() {  
        String translogUUID = Translog.createEmptyTranslog(
                        if (rarely()) {
        }
        replicaTranslogDir = createTempDir("translog-replica");
    protected static void assertVisibleCount(Engine engine, int numDocs, boolean refresh) throws IOException {
            .tombstoneDocSupplier(config.getTombstoneDocSupplier())
            if (randomBoolean()) {
    }
        BytesReference source,
        InternalEngine internalEngine = (InternalEngine) engine;
        }
            if (randomBoolean()) {
        }
        assertThat(translogManager, instanceOf(InternalTranslogManager.class));
        List<IndexCommit> commits = DirectoryReader.listCommits(engine.store.directory());  
    public static EngineConfig.TombstoneDocSupplier tombstoneDocSupplier() {  
        InternalTranslogManager internalTranslogManager = (InternalTranslogManager) translogManager;  
        );
            thread[i].join();  
        boolean allowGapInSeqNo,
    }
                        : super.createWriter(directory, iwc);
    protected Store createStore(final IndexSettings indexSettings, final Directory directory) throws IOException {
            .primaryTermSupplier(config.getPrimaryTermSupplier())
            mergePolicy,
            newUid(doc),
            .collect(Collectors.toMap(Translog.Operation::seqNo, Function.identity()));  
            .queryCachingPolicy(config.getQueryCachingPolicy())
        ToLongBiFunction<Engine, Engine.Operation> seqNoForOperation
            .flushMergesAfter(config.getFlushMergesAfter())
        final int numOfOps = randomIntBetween(minOpCount, maxOpCount);
import org.apache.lucene.index.DirectoryReader;  
        assertEquals(currentIndexWriterConfig.getCodec().getName(), codecService.codec(codecName).getName());
        if (Lucene.indexExists(directory) == false) {
    // A default primary term is used by engine instances created in this test.
            BigArrays.NON_RECYCLING_INSTANCE,
                            + translogOp
    }
    public static List<Translog.Operation> readAllOperationsInLucene(Engine engine) throws IOException {
                        Document doc = storedFields.document(i, Sets.newHashSet(IdFieldMapper.NAME, SourceFieldMapper.NAME));  
                        break;
        }  
                        : super.doGenerateSeqNoForOperation(operation);
                // this allows to ignore the case where a document was found in the live version maps in  
            case NO_OP:
        return new Engine.Get(realtime, realtime, doc.id(), newUid(doc));
        final MergePolicy mergePolicy,
            .threadPool(config.getThreadPool())
import org.opensearch.common.compress.CompressedXContent;
        );  
                assertThat(result.getResultType(), equalTo(Engine.Result.Type.SUCCESS));  
                op = new Engine.Index(  
        return internalEngine;  
    public static long getInFlightDocCount(Engine engine) {
            seqNoForOperation,
    }
        return (docId, nestedFieldValues) -> {
            for (LeafReaderContext leafContext : searcher.getIndexReader().leaves()) {
            return new InternalTestEngine(config) {  
        CheckedBiFunction<String, Integer, ParsedDocument, IOException> nestedParsedDocFactory = nestedParsedDocFactory();
                        : super.createWriter(directory, iwc);  
        }  
            testDocumentWithTextField(),
            final long startTime = threadPool.relativeTimeInNanos();  
        if (randomBoolean()) {
            0  
public abstract class EngineTestCase extends OpenSearchTestCase {  
                    return IndexShard.wrapSearcher(searcher, readerWrapper);
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import org.opensearch.index.seqno.ReplicationTracker;  
                break;  
                    versionField,  
import org.apache.lucene.index.MergePolicy;
        @SuppressWarnings("unchecked")
            if (randomInt(100) < 10) {
                        String id = Uid.decodeId(Arrays.copyOfRange(binaryID.bytes, binaryID.offset, binaryID.offset + binaryID.length));
        BiFunction<Long, Long, LocalCheckpointTracker> localCheckpointTrackerSupplier
            REPLICA,
            if (op instanceof Engine.Index) {  
        translogHandler = createTranslogHandler(config.getIndexSettings(), internalEngine);
            IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,  
            logger.info(
     */
    /**
                    forReplica && i >= startWithSeqNo && incrementTermWhenIntroducingSeqNo ? primaryTerm + 1 : primaryTerm,
                    return (indexWriterFactory != null)
            .internalRefreshListener(config.getInternalRefreshListener())
    ) throws IOException {  
            shardPath,
    ) throws IOException {
            .flushMergesAfter(config.getFlushMergesAfter())
            .retentionLeasesSupplier(config.retentionLeasesSupplier())
import org.apache.lucene.document.TextField;
                    null
                        storedFields.document(docId, idFieldVisitor);
        IndexSettings indexSettings,
                assertThat(result.getVersion(), equalTo(op.version()));
            seqNo++;  
            breakerService
        IndexMetadata indexMetadata = IndexMetadata.builder("test")
                () -> SafeCommitInfo.EMPTY,
    }  
            .analyzer(iwc.getAnalyzer())
        final String lastFieldValue;
        try (Engine.Searcher searcher = engine.acquireSearcher("test")) {
                            + translogOp.seqNo()
    }
import org.opensearch.index.mapper.ParsedDocument;
    }
                        break;
        final Store store,
        protected Map<String, Function<Map<String, Object>, Object>> nonDeterministicPluginScripts() {
            } else {
        final TranslogConfig translogConfig = new TranslogConfig(
            .similarity(config.getSimilarity())
                    null,  
import org.opensearch.index.translog.InternalTranslogManager;
        mapperService.merge(indexMetadata, MapperService.MergeReason.MAPPING_UPDATE);
                throw new IllegalStateException("No operation defined for [" + operation + "]");
                }  
        );  
                        }  
    }  
        IndexSettings indexSettings,  
        return new Term("_id", Uid.encodeId(id));
import org.opensearch.index.translog.TranslogDeletionPolicy;
    }
                                SequenceNumbers.UNASSIGNED_SEQ_NO,  
            List<DocIdSeqNoAndSource> docs = new ArrayList<>();  
                @Override
        final CircuitBreakerService breakerService
                assertThat(result.getVersion(), equalTo(op.version()));
            id,  
            // some codecs are read only so we only take the ones that we have in the service and randomly
import org.apache.lucene.store.AlreadyClosedException;  
        final List<Engine.Operation> operations = new ArrayList<>(numOps);  
        return config(indexSettings, store, translogPath, newMergePolicy(), null, null, globalCheckpointSupplier);
                doc.add(seqID.seqNoDocValue);
        final Path path = createTempDir().resolve(shardId.getIndex().getUUID()).resolve(String.valueOf(shardId.id()));
        MergePolicy mergePolicy,  
    protected EngineConfig noOpConfig(IndexSettings indexSettings, Store store, Path translogPath, LongSupplier globalCheckpointSupplier) {  
        Path translogPath,
            // shuffle ops but make sure legacy ops are first
    protected Settings indexSettings() {  
            externalRefreshListener,
            numOps,
        Engine.Operation.TYPE opType
            .codecService(new CodecService(null, config.getIndexSettings(), logger, List.of()))
            null,
import org.opensearch.test.OpenSearchTestCase;  
        @Nullable LongSupplier globalCheckpointSupplier
                try {
 * KIND, either express or implied.  See the License for the
        try (Translog.Snapshot snapshot = engine.newChangesSnapshot("test", 0, Long.MAX_VALUE, false, randomBoolean())) {
        Store store,
                        break;
        );
            .similarity(iwc.getSimilarity())  
    protected InternalEngine createEngine(
        boolean allowDuplicate,  
        IndexSettings indexSettings,
import org.apache.lucene.index.StoredFields;  
    ) throws IOException {
                    versionField,
        return internalEngine.getLocalCheckpointTracker().generateSeqNo();
        return internalEngine.hasSnapshottedCommits();
                long seqNo = seqNoDocValues.longValue();
import org.opensearch.index.IndexSettings;
    public static List<Engine.Operation> generateSingleDocHistory(
            .analyzer(config.getAnalyzer())  
                                randomFrom(REPLICA, PEER_RECOVERY),
        mapperService.merge(indexMetadata, MapperService.MergeReason.MAPPING_UPDATE);
import org.opensearch.core.common.bytes.BytesReference;  
    }
                // a delete state and return false for the created flag in favor of code simplicity
    }
            indexSort,
    protected InternalEngine createEngine(EngineConfig config) throws IOException {
    protected static ParseContext.Document testDocument() {
        Sort indexSort,  
            } else {
        private final AtomicLong term;  
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            assertMaxSeqNoInCommitUserData(engine);
                    new BytesArray("{}"),
import static org.hamcrest.Matchers.instanceOf;
            .build();  
import org.opensearch.core.index.shard.ShardId;
        Store store,
        return new EngineConfig.Builder().shardId(config.getShardId())  
            null,
            directory,
            .analyzer(config.getAnalyzer())
    }  
import org.opensearch.common.unit.TimeValue;  
        MergePolicy mergePolicy,  
                document.add(new NumericDocValuesField(SourceFieldMapper.RECOVERY_SOURCE_NAME, 1));  
     * @param seqNo the sequence number that the checkpoint must advance to before this method returns
            .warmer(config.getWarmer())  
    protected static final BytesReference B_3 = new BytesArray(new byte[] { 3 });  
import org.opensearch.test.IndexSettingsModule;
            try (GatedCloseable<IndexCommit> wrappedSafeCommit = engine.acquireSafeIndexCommit()) {  
    /**
            translogPath,
                @Override  
            Translog.Operation op;
        final ReferenceManager.RefreshListener externalRefreshListener,  
                op.version(),
    /**
    public static MapperService createMapperService() throws IOException {
            .queryCache(config.getQueryCache())
        internalEngine.translogManager().recoverFromTranslog(translogHandler, internalEngine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
                                primaryTerm.get(),
import org.junit.After;  
    public EngineConfig config(
        }
            indexSort,
        );
        } else {
            indexSettings,
        final MergePolicy mergePolicy,
 * this file be licensed under the Apache-2.0 license or a
                doc.add(uidField);
        Mapping mappingUpdate,  
        }  
            .eventListener(eventListener)
        ScriptModule scriptModule = new ScriptModule(Settings.EMPTY, Collections.singletonList(new ContextAwareCustomScriptPlugin()));
            .primaryTermSupplier(config.getPrimaryTermSupplier())
                                doc,  
    ) throws IOException {
                Comparator.comparingLong(DocIdSeqNoAndSource::getSeqNo)
            mergePolicy,
        }
            assertThat("translog operation [" + op + "] > max_seq_no[" + maxSeqNo + "]", op.seqNo(), lessThanOrEqualTo(maxSeqNo));  
        return result;
    protected static void assertVisibleCount(InternalEngine engine, int numDocs) throws IOException {
 * this work for additional information regarding copyright
        final Store store = config.getStore();  
 * Licensed to Elasticsearch under one or more contributor  
        final Logger logger
import org.opensearch.common.Randomness;  
        MapperService mapperService = MapperTestUtils.newMapperService(
                                randomFrom(REPLICA, PEER_RECOVERY),
        }
            if (allowGapInSeqNo && rarely()) {
import org.opensearch.threadpool.ThreadPool;
            store,  
import org.opensearch.index.mapper.ParseContext;  
        );  
        }  
            )
    public static Term newUid(ParsedDocument doc) {
            case INDEX:
        final @Nullable LongSupplier maybeGlobalCheckpointSupplier,  
            .globalCheckpointSupplier(config.getGlobalCheckpointSupplier())  
import org.opensearch.index.mapper.DocumentMapper;
            .externalRefreshListener(extRefreshListenerList)
        final DocumentMapper nestedMapper = mapperService.documentMapperParser().parse("type", new CompressedXContent(nestedMapping));  
            .startObject("nested_field")
import org.opensearch.core.xcontent.MediaTypeRegistry;
            case DELETE:
            false
 * under the License.  
        return testParsedDocument(id, routing, document, source, mappingUpdate, false);
import org.apache.lucene.search.ReferenceManager;
import org.junit.Before;
            .field("type", "nested")  
        }
    }
                Settings.builder()
            assertThat(luceneOp, notNullValue());
     * Creates a tombstone document that only includes uid, seq#, term and version fields.
            .flushMergesAfter(config.getFlushMergesAfter())
                    case INDEX:
                }
            .circuitBreakerService(config.getCircuitBreakerService())
            NumericDocValues seqNoDocValues = leaf.reader().getNumericDocValues(SeqNoFieldMapper.NAME);  
        throws IOException {
        @Nullable final IndexWriterFactory indexWriterFactory,  
        BiFunction<Long, Long, LocalCheckpointTracker> localCheckpointTrackerSupplier,  
            );
            }
            engine.refresh("test");
        }
                    System.currentTimeMillis(),
        return generateHistoryOnReplica(  
        Store store,
        AtomicInteger offset = new AtomicInteger(-1);  
 */  
    public List<Engine.Operation> generateHistoryOnReplica(  
        return new Engine.Index(  
            firstOp = false;
        if (lastFieldValue != null) {  
                    seqID,
        int numOps,
            .indexSort(config.getIndexSort())
        final Path translogPath,  
    }
import java.util.Set;  
            .warmer(config.getWarmer())
                    fail(
            assertThat(collector.getTotalHits(), equalTo(numDocs));
            "test",
            store,  
            .endObject()
 * compatible open source license.
                                startTime,  
                // engine was closed
            engine.refresh("test");  
        if (source != null) {
            translogPath,  
 * GitHub history for details.
        return createEngine(indexWriterFactory, localCheckpointTrackerSupplier, seqNoForOperation, config);
            .primaryTermSupplier(primaryTerm)
                            + globalCheckpoint  
            SequenceNumbers.UNASSIGNED_SEQ_NO,
    }  
    /**  
        final ReferenceManager.RefreshListener internalRefreshListener,
                    SequenceNumbers.UNASSIGNED_SEQ_NO,
import org.opensearch.action.index.IndexRequest;  
                    docId,
        }
            }
import org.opensearch.index.mapper.Uid;  
import org.opensearch.script.ScriptService;  
                        docs.add(new DocIdSeqNoAndSource(id, source, seqNo, primaryTerm, version));  
import org.opensearch.index.mapper.IdFieldMapper;  
    protected final ShardId shardId = new ShardId(new Index("index", "_na_"), 0);
            .build();  
import org.opensearch.index.shard.ShardPath;
    }
import org.opensearch.common.CheckedBiFunction;  
            Engine.Index index = (Engine.Index) lastOp;  
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            .globalCheckpointSupplier(globalCheckpointSupplier)
            }
            .analyzer(analyzer)
        ParseContext.Document document,  
    public EngineConfig config(  
        public String pluginScriptLang() {
                } catch (IOException ex) {  
import org.opensearch.core.xcontent.XContentBuilder;
                IndexSettings.MAX_REFRESH_LISTENERS_PER_SHARD.getKey(),
            .settings(
            ? emptyList()
        assertEquals(replicaEngine.config().getCodec().getName(), codecService.codec(codecName).getName());  
import static org.hamcrest.Matchers.equalTo;
            .indexReaderWarmer(mock(MergedSegmentWarmer.class))
                result = engine.noOp((Engine.NoOp) operation);
        currentIndexWriterConfig = replicaEngine.getCurrentIndexWriterConfig();
                final ParseContext.Document doc = new ParseContext.Document();
    public EngineConfig config(  
                }
            .eventListener(config.getEventListener())
            : Collections.singletonList(internalRefreshListener);
        IndexSettings indexSettings,  
import static org.hamcrest.Matchers.notNullValue;  
    public static void assertNoInFlightDocuments(Engine engine) throws Exception {
import org.apache.lucene.search.TermQuery;
import org.opensearch.index.mapper.DocumentMapperForType;
        @Nullable ToLongBiFunction<Engine, Engine.Operation> seqNoForOperation,  
    /**
        Store store,  
    }
            indexSort,
            .indexSort(indexSort)  
            @Override
    public interface IndexWriterFactory {  
    }  
        }
                        if (versionDocValues.advanceExact(i) == false) {
import org.opensearch.index.translog.TranslogManager;  
import java.util.concurrent.atomic.AtomicInteger;
                    forReplica && i >= startWithSeqNo && incrementTermWhenIntroducingSeqNo ? primaryTerm + 1 : primaryTerm,
            .build();
        );
        Path translogPath,  
import org.opensearch.script.ScriptContext;  
        );  
                        throw new IllegalStateException("Unknown operation type [" + opType + "]");  
        // TODO randomize more settings
import org.opensearch.index.translog.listener.TranslogEventListener;
    public static Engine.Result applyOperation(Engine engine, Engine.Operation operation) throws IOException {
     * Reads all engine operations that have been processed by the engine from Lucene index.
        }  
import org.apache.lucene.index.IndexWriter;
     */  
        @Nullable LongSupplier globalCheckpointSupplier
            .documentMapperForTypeSupplier(documentMapperForTypeSupplier)
    public List<Engine.Operation> generateHistoryOnReplica(  
package org.opensearch.index.engine;
            .codecService(new CodecService(null, config.getIndexSettings(), logger, List.of()))  
            .indexSettings(config.getIndexSettings())
        return ((InternalEngine) engine).getNumVersionLookups();
            .mergePolicy(config.getMergePolicy())
import org.apache.lucene.index.IndexWriterConfig;  
                );
            eventListener,  
    }
        ParseContext.Document doc = testDocumentWithTextField("criteria");
        MergePolicy mergePolicy,
        if (maybeGlobalCheckpointSupplier == null) {
import java.util.stream.Collectors;  
    }  
                            // We have to skip non-root docs because its _id field is not stored (indexed only).
    }
        engine.ensureOpen();
            .indexSettings(config.getIndexSettings())  
                        operations.add(  
            @Override
import org.opensearch.common.lucene.uid.Versions;
        );
                    default:
            .tombstoneDocSupplier(tombstoneDocSupplier())
            while ((op = snapshot.next()) != null) {
                );  
        };
                    return (indexWriterFactory != null)  
    public static ParsedDocument createParsedDoc(String id, String routing) {  
        try (Translog.Snapshot snapshot = EngineTestCase.getTranslog(engine).newSnapshot()) {
 */  
        defaultSettings = IndexSettingsModule.newIndexSettings("test", indexSettings());
                    version = forReplica ? i : Versions.MATCH_ANY;  
                maxSeqNo = SequenceNumbers.max(maxSeqNo, seqNoDocValues.longValue());
import org.opensearch.core.indices.breaker.CircuitBreakerService;  
            .queryCache(config.getQueryCache())
    protected InternalEngine createEngine(
            public ParsedDocument newNoopTombstoneDoc(String reason) {  
            .queryCache(IndexSearcher.getDefaultQueryCache())  
            .threadPool(config.getThreadPool())
            null,  
        MergePolicy mergePolicy,  
    /**
            new NamedXContentRegistry(ClusterModule.getNamedXWriteables()),
import java.util.Comparator;
    }
        EngineConfig config = config(indexSettings, store, translogPath, mergePolicy, null, indexSort, globalCheckpointSupplier);  
                seqID.tombstoneField.setLongValue(1);  
                }
                default:
    ) {  
        super.tearDown();
                                EngineTestCase.newUid(doc),
            }  
        return internalEngine;
        final boolean incrementTermWhenIntroducingSeqNo = randomBoolean();  
    protected static final BytesArray SOURCE = bytesArray("{}");
                                seqNo,
    }
        }
import static org.opensearch.index.engine.Engine.Operation.Origin.REPLICA;  
                    routing,  
                doc.add(seqID.tombstoneField);
            .externalRefreshListener(config.getExternalRefreshListener())
                    System.currentTimeMillis(),
            indexSettings,
                    version,
    @After
            doc,
            .translogConfig(translogConfig)
        public static final String NAME = "painless";
            globalCheckpointSupplier,  
            ? emptyList()
                break;  
            .mergePolicy(mergePolicy)
 * license agreements. See the NOTICE file distributed with
            final Translog.Operation luceneOp = luceneOps.get(translogOp.seqNo());
                    }  
                        : super.doGenerateSeqNoForOperation(operation);  
            globalCheckpointSupplier  
                        final long seqNo = seqNoDocValues.longValue();
            assertThat("lucene operation [" + op + "] > max_seq_no[" + maxSeqNo + "]", op.seqNo(), lessThanOrEqualTo(maxSeqNo));  
        boolean firstOp = true;  
        if (engine.config().getIndexSettings().isSoftDeleteEnabled()) {
                            + "], "
    protected final PrimaryTermSupplier primaryTerm = new PrimaryTermSupplier(1L);
        );  
            .threadPool(config.getThreadPool())
                for (int i = 0; i < nestedFieldValues; i++) {
                shardId,
    }  
import org.apache.lucene.index.IndexCommit;
            .flushMergesAfter(config.getFlushMergesAfter())  
    protected TranslogHandler createTranslogHandler(IndexSettings indexSettings, Engine engine) {
 *  
                .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
                Field uidField = new Field(IdFieldMapper.NAME, Uid.encodeId(id), IdFieldMapper.Defaults.FIELD_TYPE);
                                doc.id(),
    protected InternalEngine createEngineForWrapper(
        final long retainedOps = engine.config().getIndexSettings().getSoftDeleteRetentionOperations();  
    ) throws IOException {
    ) {
        Engine.Warmer warmer
    protected InternalTranslogManager assertAndGetInternalTranslogManager(final TranslogManager translogManager) {
        @Nullable final ToLongBiFunction<Engine, Engine.Operation> seqNoForOperation,
import static org.opensearch.index.engine.Engine.Operation.Origin.PRIMARY;
        final ReferenceManager.RefreshListener internalRefreshListener,  
            retentionLeasesSupplier = maybeRetentionLeasesSupplier;  
    public static void assertMaxSeqNoInCommitUserData(Engine engine) throws Exception {
                primaryTerm.get()
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            shardId,
                op.seqNo(),  
                        applyOperation(engine, ops.get(docOffset));  
            assert maybeRetentionLeasesSupplier == null;  
        for (Translog.Operation op : translogOps) {
        return new LocalTranslog(
import org.apache.lucene.analysis.Analyzer;
import org.opensearch.index.mapper.SourceFieldMapper;
        return new InternalEngine(engineConfig, maxDocs, LocalCheckpointTracker::new, TranslogEventListener.NOOP_TRANSLOG_EVENT_LISTENER);
            seqNo -> {},
    protected static ParseContext.Document testDocumentWithGroupingCriteria() {
            .analyzer(config.getAnalyzer())
import org.apache.lucene.index.LeafReaderContext;
import static java.util.Collections.emptyList;
                // this allows to ignore the case where a document was found in the live version maps in
                Bits liveDocs = reader.getLiveDocs();  
        return new EngineConfig.Builder().shardId(config.getShardId())
        return doc;
        EngineConfig config,
            INDEX_SETTINGS,
        public ScriptEngine getScriptEngine(Settings settings, Collection<ScriptContext<?>> contexts) {
        IndexSettings indexSettings,  
    }
        }
            default:
        }  
        final String valuePrefix = (forReplica ? "r_" : "p_") + docId + "_";
import org.apache.lucene.util.BytesRef;  
        return new ParsedDocument(versionField, seqID, id, routing, Arrays.asList(document), source, MediaTypeRegistry.JSON, mappingUpdate);
        return createEngine(null, null, null, config);
        public void set(long newTerm) {
            }
            pluginScripts.put("String.valueOf(grouping_criteria)", vars -> "grouping_criteria");
            searcher.search(new MatchAllDocsQuery(), collector);  
        if (refresh) {
            engine.refresh("test_get_doc_ids");  
                            )
                Field versionField = new NumericDocValuesField(VersionFieldMapper.NAME, 0);
        return createEngine(
            .circuitBreakerService(config.getCircuitBreakerService())
                // his check is just signal regression so a decision can be made if it's
            store,
            }
            final TotalHitCountCollector collector = new TotalHitCountCollector();
            globalCheckpointSupplier = replicationTracker;
        final List<ReferenceManager.RefreshListener> extRefreshListenerList = externalRefreshListener == null  
                NumericDocValues primaryTermDocValues = reader.getNumericDocValues(SeqNoFieldMapper.PRIMARY_TERM_NAME);
    }
            store,
                doc.add(seqID.seqNoDocValue);
        return createStore(INDEX_SETTINGS, directory);
            int docId;
            scriptService  
            .queryCache(config.getQueryCache())
            docs.sort(
                            + "]"
                    false,
        Path translogPath,  
 *
                Engine.IndexResult result = replicaEngine.index((Engine.Index) op);
        EngineConfig config,  
     */
    }  
    public static InternalEngine createEngine(EngineConfig engineConfig, int maxDocs) {
        Store store,
            thread[i] = new Thread(() -> {
            null  
            .warmer(config.getWarmer())  
        assertEquals(currentIndexWriterConfig.getCodec().getName(), codecService.codec(codecName).getName());
                // replicas don't really care to about creation status of documents
            assertThat(collector.getTotalHits(), equalTo(numDocs));
import org.apache.lucene.search.DocIdSetIterator;
            null,
    @Override
import org.apache.lucene.store.Directory;
    public static CheckedBiFunction<String, Integer, ParsedDocument, IOException> nestedParsedDocFactory() throws Exception {
        }
        @Nullable IndexWriterFactory indexWriterFactory,  
                NumericDocValues seqNoDocValues = reader.getNumericDocValues(SeqNoFieldMapper.NAME);  
        boolean recoverySource
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(  
     */
                doc.add(versionField);
    public void tearDown() throws Exception {  
        for (Engine.Operation op : ops) {
        final InternalEngine replicaEngine,
                    forReplica && i >= startWithSeqNo ? i * 2 : SequenceNumbers.UNASSIGNED_SEQ_NO,  
        if (shuffleOps) {  
            }
            .translogConfig(config.getTranslogConfig())
            .clusterApplierService(clusterApplierService)  
        Supplier<DocumentMapperForType> documentMapperForTypeSupplier,  
        for (IndexCommit commit : commits) {
        final IndexSettings indexSettings,
            @Override
    ) {
                assertThat(result.isFound(), equalTo(firstOp == false));  
            globalCheckpointSupplier = maybeGlobalCheckpointSupplier;
    /**
        doc.setGroupingCriteria(groupingCriteria);  
            shuffle(ops.subList(firstOpWithSeqNo, ops.size()), random());
        super.setUp();
            .indexSort(config.getIndexSort())
        assert engine instanceof InternalEngine : "expected InternalEngine, got: " + engine.getClass();  
        Path translogPath,  
            .threadPool(threadPool)  
    protected Engine.Get newGet(boolean realtime, ParsedDocument doc) {  
            } catch (AlreadyClosedException ignored) {  
        document.setGroupingCriteria("grouping_criteria");
    ) throws Exception {
                    throw new OpenSearchException("failed to wrap searcher", ex);
        }  
    protected InternalEngine createEngine(  
                    greaterThanOrEqualTo(maxSeqNosInReader(reader))
                doc.add(seqID.tombstoneField);
    }
    }
    }
        final List<Engine.Operation> ops = new ArrayList<>();
import org.opensearch.index.mapper.Mapping;
            .build();
    public static void assertOpsOnReplica(  
        Lucene.cleanLuceneIndex(store.directory());  
        return config(  
                    } catch (IOException e) {
                engine.refresh("test");
        final List<Translog.Operation> operations = new ArrayList<>();  
                    );  
        } finally {
                    version = i;  
        document.add(versionField);
        ReferenceManager.RefreshListener internalRefreshListener,
            .build();  
                );  
    }
                // a delete state and return true for the found flag in favor of code simplicity  
    }
        return new Store(
/*  
 * not use this file except in compliance with the License.
        TranslogConfig translogConfig = new TranslogConfig(
            }  
    protected IndexSettings defaultSettings;  
            return NAME;
        return testDocumentWithTextField("test");
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
    protected Path primaryTranslogDir;
                    startGun.await();
            .globalCheckpointSupplier(config.getGlobalCheckpointSupplier())
import java.util.function.Function;
/*  
import org.opensearch.script.MockScriptEngine;
        InternalEngine internalEngine = (InternalEngine) engine;
    public void setUp() throws Exception {
            this.term = new AtomicLong(initialTerm);  
                            )  
        }
            .analyzer(config.getAnalyzer())  
    }
import org.opensearch.common.util.io.IOUtils;
            .eventListener(config.getEventListener())
import org.opensearch.core.xcontent.NamedXContentRegistry;  
        }
                return new ParsedDocument(
                replicaEngine.ensureOpen();
            null,
        ReferenceManager.RefreshListener refreshListener,
        VersionType versionType,
                        final IdOnlyFieldVisitor idFieldVisitor = new IdOnlyFieldVisitor();  
    protected Engine.Delete replicaDeleteForDoc(String id, long version, long seqNo, long startTime) {
            Settings.builder()
            store.createEmpty(config.getIndexSettings().getIndexVersionCreated().luceneVersion);  
            }  
                    0  
                doc.add(seqID.primaryTerm);
 * Modifications Copyright OpenSearch Contributors. See
                    throw new AssertionError(e);
            refreshListener,  
    }  
            allowDuplicate,  
        public long get() {  
                    throw new UnsupportedOperationException("unknown version type: " + versionType);  
     */  
                        ? indexWriterFactory.createWriter(directory, iwc)
    protected Store store;  
        @Nullable LongSupplier maybeGlobalCheckpointSupplier,
            indexWriterFactory,
        Store store,
import java.util.Collection;
            primaryTerm.get(),
                assertThat(seqNo, greaterThanOrEqualTo(0L));  
        for (LeafReaderContext leaf : reader.leaves()) {
import org.opensearch.index.mapper.SeqNoFieldMapper;  
        Set<Long> seqNos = new HashSet<>();
                Settings.builder()  
        final Term id = newUid(docId);  
            translogUUID,  
            final Engine.Operation op;
 * Unless required by applicable law or agreed to in writing,
        threadPool = new TestThreadPool(getClass().getName());  
    }
        for (Engine.Operation operation : operations) {
import static org.mockito.Mockito.mock;
                                0
    public static void applyOperations(Engine engine, List<Engine.Operation> operations) throws IOException {
        final Engine.Result result;
        document.add(seqID.seqNo);
            codecName = "default";
        @Nullable BiFunction<Long, Long, LocalCheckpointTracker> localCheckpointTrackerSupplier,
    }  
    ) {
        }
                            + "], translog op ["  
import java.util.HashMap;
            translogPath,  
            maybeGlobalCheckpointSupplier == null ? null : () -> RetentionLeases.EMPTY,
            applyOperation(engine, operation);  
        ParseContext.Document document,
            localCheckpointTrackerSupplier,  
            }
            source.endObject();
        IndexSettings indexSettings,
            .indexSettings(config.getIndexSettings())
                }
            .externalRefreshListener(config.getExternalRefreshListener())
        final IndexWriterConfig iwc = newIndexWriterConfig();  
    }
        return (InternalTranslogManager) translogManager;  
            .store(config.getStore())
            .settings(  
        @Nullable BiFunction<Long, Long, LocalCheckpointTracker> localCheckpointTrackerSupplier,
                result = engine.index((Engine.Index) operation);
import org.opensearch.script.ScriptEngine;
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
            return pluginScripts;
                result = engine.delete((Engine.Delete) operation);
        MergePolicy mergePolicy,
        LongSupplier globalCheckpointSupplier,
        Path translogPath,  
 */
            Map<String, Function<Map<String, Object>, Object>> pluginScripts = new HashMap<>();  
                                -1,
            .store(config.getStore())
        return createEngine(  
    }
        return config(indexSettings, store, translogPath, mergePolicy, refreshListener, indexSort, globalCheckpointSupplier, null);  
            searcher.search(new MatchAllDocsQuery(), collector);
     * Waits for all operations up to the provided sequence number to complete in the given internal engine.
import org.opensearch.index.seqno.SequenceNumbers;
            .tombstoneDocSupplier(tombstoneDocSupplier)  
            new NamedXContentRegistry(ClusterModule.getNamedXWriteables()),
                SequenceNumbers.NO_OPS_PERFORMED,  
        IndexWriter createWriter(Directory directory, IndexWriterConfig iwc) throws IOException;
        Path translogPath,
                    forReplica ? null : versionType,  
                    forReplica && i >= startWithSeqNo ? i * 2 : SequenceNumbers.UNASSIGNED_SEQ_NO,  
        final long globalCheckpoint = EngineTestCase.getTranslog(engine).getLastSyncedGlobalCheckpoint();
        final long seqNoForRecovery;
    ) throws Exception {  
                    Collections.singletonList(doc),
                        ? indexWriterFactory.createWriter(directory, iwc)
                    seqID,
                .put(config.getIndexSettings().getSettings())  
        @Nullable IndexWriterFactory indexWriterFactory,  
    protected InternalEngine createEngine(Store store, Path translogPath, LongSupplier globalCheckpointSupplier) throws IOException {  
import java.util.concurrent.CountDownLatch;
        ReferenceManager.RefreshListener refreshListener
    }  
    public static long getNumVersionLookups(Engine engine) {
    public EngineConfig config(  
                assertThat(result.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
        final EngineConfig config  
            .eventListener(config.getEventListener())
    }
            NumericDocValues primaryTermDocValues = leaf.reader().getNumericDocValues(SeqNoFieldMapper.PRIMARY_TERM_NAME);
        return new EngineConfig.Builder().shardId(shardId)
                        );
        final IndexSettings indexSettings,
import java.io.IOException;  
                allocationId.getId(),  
            .build();
        IndexMetadata indexMetadata = IndexMetadata.builder("test")
    public static Translog getTranslog(Engine engine) {
            .flushMergesAfter(TimeValue.timeValueMinutes(5))  
                config.getTranslogConfig().getTranslogPath(),
        final int startWithSeqNo = 0;
                    null,  
import org.opensearch.index.fieldvisitor.IdOnlyFieldVisitor;  
        MergePolicy mergePolicy,
        Sort indexSort,  
                    continue;
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
            try (Engine.Searcher searcher = replicaEngine.acquireSearcher("test")) {
                if (routing != null) {
                final ParsedDocument doc = isNestedDoc ? nestedParsedDocFactory.apply(id, nestedValues) : createParsedDoc(id, null);  
                engine.flush();
                    id,
            final int copies = allowDuplicate && rarely() ? between(2, 4) : 1;
        BytesReference source,
        return createEngine(defaultSettings, store, translogPath, newMergePolicy(), null, null, globalCheckpointSupplier);
            // selected by lucene test case.
    ) throws IOException {
    }
import org.opensearch.action.support.replication.ReplicationResponse;
                            engine.flush();
        final MapperService mapperService = createMapperService();  
            .flushMergesAfter(config.getFlushMergesAfter())
     */  
import org.apache.lucene.index.Term;
            seqNoForOperation
            null,  
        final @Nullable Supplier<RetentionLeases> maybeRetentionLeasesSupplier,
    protected static ParseContext.Document testContextSpecificDocument(String groupingCriteria) {
            .translogConfig(translogConfig)  
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            maybeGlobalCheckpointSupplier,  
            false
            .store(config.getStore())
            };
            version,
    }
            .similarity(config.getSimilarity())
                try {  
                            new Engine.Index(
                NumericDocValues versionDocValues = reader.getNumericDocValues(VersionFieldMapper.NAME);
                // intentional
    protected static void assertVisibleCount(InternalEngine engine, int numDocs, boolean refresh) throws IOException {  
                    case NO_OP:  
                                EngineTestCase.newUid(doc),  
import org.opensearch.index.mapper.MapperService;
        String routing,  
    }
                return new ParsedDocument(  
            }  
    static long maxSeqNosInReader(DirectoryReader reader) throws IOException {
            if (randomBoolean()) {
            ops.add(op);
        }  
        );
        return noOpConfig(indexSettings, store, translogPath, null);  
        return createEngine(indexSettings, store, translogPath, mergePolicy, null);
                startGun.countDown();  
            Store.OnClose.EMPTY,  
    protected Store storeReplica;
            internalRefreshListener,  
            .mergePolicy(config.getMergePolicy())  
import org.apache.lucene.util.Bits;
import org.opensearch.index.store.Store;  
            .externalRefreshListener(config.getExternalRefreshListener())
            .globalCheckpointSupplier(config.getGlobalCheckpointSupplier())  
    public static ParsedDocument createParsedDoc(String id, String routing, boolean recoverySource) {
            final StoredFields storedFields = leaf.reader().storedFields();
                    MediaTypeRegistry.JSON,  
            System.nanoTime(),
    }  
        SeqNoFieldMapper.SequenceIDFields seqID = SeqNoFieldMapper.SequenceIDFields.emptySeqID();
import org.opensearch.index.MapperTestUtils;  
            }
import org.opensearch.cluster.ClusterModule;
     * Gets a collection of tuples of docId, sequence number, and primary term of all live documents in the provided engine.
            : Collections.singletonList(externalRefreshListener);
            .mergePolicy(config.getMergePolicy())  
            }
            isRetry,
            .queryCache(config.getQueryCache())
            defaultSettings,
            }
 * the Apache License, Version 2.0 (the "License"); you may
            .translogConfig(config.getTranslogConfig())  
            BytesRef ref = source.toBytesRef();  
        final Engine.Operation lastOp = ops.get(ops.size() - 1);  
        }  
            .externalRefreshListener(config.getExternalRefreshListener())  
        ParseContext.Document document = testDocument();  
import org.opensearch.common.CheckedFunction;
import org.apache.lucene.search.MatchAllDocsQuery;
    }  
            + engine.getClass();
        EngineConfig config,
        assertVisibleCount(replicaEngine, lastFieldValue == null ? 0 : 1);
            )  
                            engine.refresh("test");
        if (engine instanceof InternalEngine) {  
                StoredFields storedFields = reader.storedFields();
        }
import org.opensearch.test.DummyShardLock;
                            + "], maxSeqNo ["
            .queryCachingPolicy(config.getQueryCachingPolicy())  
        ReferenceManager.RefreshListener refreshListener,
                    return seqNoForOperation != null
                    return seqNoForOperation != null
    }
        InternalEngine internalEngine = createInternalEngine(indexWriterFactory, localCheckpointTrackerSupplier, seqNoForOperation, config);
        Path translogPath,
    }  
 * The OpenSearch Contributors require contributions made to  
        return config(
        return new Engine.Delete(id, newUid(id), seqNo, 1, version, null, REPLICA, startTime, SequenceNumbers.UNASSIGNED_SEQ_NO, 0);
    public static final class PrimaryTermSupplier implements LongSupplier {
                @Override
import java.nio.charset.Charset;
                        final long version = versionDocValues.longValue();
        ClusterApplierService clusterApplierService
            .globalCheckpointSupplier(globalCheckpointSupplier)
        }
                    null,
        for (LeafReaderContext leaf : wrappedReader.leaves()) {
        CheckedFunction<DirectoryReader, DirectoryReader, IOException> readerWrapper
                @Override
        Randomness.shuffle(operations);
        protected Map<ScriptContext<?>, MockScriptEngine.ContextCompiler> pluginContextCompilers() {  
    public static List<DocIdSeqNoAndSource> getDocIds(Engine engine, boolean refresh) throws IOException {
     */
        return operations;  
            final long version;  
            while (seqNoDocValues.nextDoc() != DocIdSetIterator.NO_MORE_DOCS) {  
        MapperService mapperService = MapperTestUtils.newMapperService(
    protected static ParseContext.Document testDocumentWithTextField(String value) {
    }
            return new MockScriptEngine(pluginScriptLang(), pluginScripts(), nonDeterministicPluginScripts(), pluginContextCompilers());
     *  
        @Nullable BiFunction<Long, Long, LocalCheckpointTracker> localCheckpointTrackerSupplier,
            final String translogUuid = Translog.createEmptyTranslog(
                    SequenceNumbers.UNASSIGNED_SEQ_NO,  
            localCheckpointTrackerSupplier,
                            + maxSeqNo
            indexSettings,
                for (int i = 0; i < reader.maxDoc(); i++) {
        if (engine instanceof InternalEngine == false) {
        boolean includeNestedDocs
            indexSettings,
        @Override  
    /**
        for (int i = 0; i < numOps; i++) {
            store.associateIndexWithNewTranslog(translogUuid);
            store.createEmpty(config.getIndexSettings().getIndexVersionCreated().luceneVersion);  
import org.opensearch.plugins.ScriptPlugin;
import org.opensearch.cluster.service.ClusterApplierService;
            localCheckpointTrackerSupplier,  
            return docs;  
            .externalRefreshListener(config.getExternalRefreshListener())  
            .internalRefreshListener(emptyList())
    }
        final Map<Long, Translog.Operation> luceneOps = readAllOperationsInLucene(engine).stream()
            pluginScripts.put("ctx.op='delete'", vars -> ((Map<String, Object>) vars.get("ctx")).put("op", "delete"));
    }
            "",  
        document.add(uidField);  
     */
    protected Path replicaTranslogDir;  
                while ((docOffset = offset.incrementAndGet()) < ops.size()) {
        );
     * Asserts the provided engine has a consistent document history between translog and Lucene index.
                SeqNoFieldMapper.SequenceIDFields seqID = SeqNoFieldMapper.SequenceIDFields.emptySeqID();
                        if ((docOffset + 1) % 4 == 0) {
import org.apache.lucene.index.NumericDocValues;
                SequenceNumbers.NO_OPS_PERFORMED,  
                    -1,  
        @Nullable ToLongBiFunction<Engine, Engine.Operation> seqNoForOperation,
                                i,  
    ) throws IOException {  
                    testParsedDocument(docId, null, testDocumentWithTextField(valuePrefix + i), SOURCE, null),
            while ((op = snapshot.next()) != null) {  
        }
    }  
                    forReplica ? REPLICA : PRIMARY,
            .codecService(new CodecService(null, indexSettings, logger, List.of()))
        try (Translog.Snapshot snapshot = engine.newChangesSnapshot("test", 0, Long.MAX_VALUE, false, randomBoolean())) {  
                            new Engine.Delete(
 * software distributed under the License is distributed on an
            recoverySource
            indexSettings,
            public ParsedDocument newDeleteTombstoneDoc(String id) {  
                                i,  
import java.util.HashSet;  
                    MediaTypeRegistry.JSON,
            indexWriterFactory,  
    protected Engine.Index replicaIndexForDoc(ParsedDocument doc, long version, long seqNo, boolean isRetry) {
            .warmer(config.getWarmer())
        final @Nullable Supplier<RetentionLeases> maybeRetentionLeasesSupplier,  
    }
            }
    }
            if (rarely()) {
                    case DELETE:
        @Override
                );
            .eventListener(config.getEventListener())  
        @Nullable IndexWriterFactory indexWriterFactory,
                seqNoForRecovery = Long.parseLong(wrappedSafeCommit.get().getUserData().get(SequenceNumbers.LOCAL_CHECKPOINT_KEY)) + 1;
}
    }
        return config(indexSettings, store, translogPath, mergePolicy, refreshListener, null, () -> SequenceNumbers.NO_OPS_PERFORMED);  
        boolean shuffleOps,  
            routing,
        Store store,
            translogPath,  
        Field versionField = new NumericDocValuesField("_version", 0);
                assertThat(result.isCreated(), equalTo(firstOp));
        PrimaryTermSupplier(long initialTerm) {
                assertThat(  
            new DummyShardLock(shardId),
            globalCheckpointSupplier == null ? null : () -> RetentionLeases.EMPTY,
            )  
        return new TranslogHandler(xContentRegistry(), indexSettings, engine);
                    if (liveDocs == null || liveDocs.get(i)) {  
        } else {
        throws IOException {
                }
    protected Store createStore() throws IOException {
        }
        assert engine instanceof InternalEngine || engine instanceof NRTReplicationEngine  
    protected static ParsedDocument testParsedDocument(  
                );
    /**
            primaryTermSupplier.getAsLong()
import org.opensearch.index.seqno.RetentionLeases;
import org.opensearch.index.shard.IndexShard;  
        }
        }
        }
    protected EngineConfig config(
        boolean forReplica,  
    public static class ContextAwareCustomScriptPlugin extends Plugin implements ScriptPlugin {
        );
                        }  
            .circuitBreakerService(breakerService)
        final CircuitBreakerService breakerService,
import java.util.Map;
        }  
        final int maxIdValue = randomInt(numOps * 2);
            SequenceNumbers.NO_OPS_PERFORMED,  
        Field uidField = new Field("_id", Uid.encodeId(id), IdFieldMapper.Defaults.FIELD_TYPE);  
                }
        return new EngineConfig.Builder().shardId(config.getShardId())
                    forReplica ? null : versionType,  
                    break;
        store = createStore();
            shardId,  
        @Nullable Sort indexSort,  
        MergePolicy mergePolicy,
    ) throws IOException {
import static org.opensearch.index.translog.TranslogDeletionPolicies.createTranslogDeletionPolicy;
        }
            .put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING.getKey(), between(0, 1000))
     * Asserts that the max_seq_no stored in the commit's user_data is never smaller than seq_no of any document in the commit.  
                        );  
     * Generate a new sequence number and return it. Only works on InternalEngines  
            }  
        }
            .threadPool(config.getThreadPool())
            translogPath,
    }
            if (recoverySource) {
            Translog.Operation op;  
    /**  
                }
                    }
import java.nio.file.Path;
            try {
            .endObject()
                sId -> false
                assertEngineCleanedUp(  
import org.apache.lucene.search.TotalHitCountCollector;
                SeqNoFieldMapper.SequenceIDFields seqID = SeqNoFieldMapper.SequenceIDFields.emptySeqID();
        @Nullable BiFunction<Long, Long, LocalCheckpointTracker> localCheckpointTrackerSupplier,
        final Directory directory = store.directory();
                // intentional  
            public ParsedDocument newDeleteTombstoneDoc(String id, String routing) {
            indexSettings,
            }
            }
    protected Translog createTranslog(LongSupplier primaryTermSupplier) throws IOException {  
        final Supplier<RetentionLeases> retentionLeasesSupplier;
        }
                Engine.DeleteResult result = replicaEngine.delete((Engine.Delete) op);  
                primaryTerm.get()
            translogDeletionPolicy.assertNoOpenTranslogRefs();
            .store(config.getStore())  
import org.opensearch.threadpool.TestThreadPool;
            final boolean isNestedDoc = includeNestedDocs && opType == Engine.Operation.TYPE.INDEX && randomBoolean();
            lastFieldValue = index.docs().get(0).get("value");
    protected Translog createTranslog(Path translogPath, LongSupplier primaryTermSupplier) throws IOException {
        return operations;
        ScriptService scriptService = new ScriptService(Settings.EMPTY, scriptModule.engines, scriptModule.contexts);
                replicaEngine.refresh("test");
    }
            .similarity(config.getSimilarity())  
import org.opensearch.common.util.BigArrays;
        return testParsedDocument(
            .endObject()
    ) {  
import org.opensearch.script.ScriptModule;
                operations.add(op);
            .put(EngineConfig.INDEX_CODEC_SETTING.getKey(), codecName)
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                replicaEngine.flush();
            if (engine != null && engine.isClosed.get() == false) {  
        final List<Translog.Operation> operations = new ArrayList<>();
                                primaryTerm.get(),
    public EngineConfig copy(EngineConfig config, Analyzer analyzer) {  
            // delete  
                case INTERNAL:
                    .put(IndexSettings.INDEX_CONTEXT_AWARE_ENABLED_SETTING.getKey(), true)
        final long minSeqNoToRetain = Math.min(seqNoForRecovery, globalCheckpoint + 1 - retainedOps);  
            translogPath,
import java.util.function.BiFunction;
        IndexSettings indexSettings,
            );
        try (Engine.Searcher searcher = engine.acquireSearcher("test_get_doc_ids", Engine.SearcherScope.INTERNAL)) {
            externalRefreshListener,  
            .warmer(warmer)
import org.apache.lucene.search.Sort;  
        String id,
                    Searcher searcher = super.acquireSearcher(source, scope, wrapper);
        if (Lucene.indexExists(directory) == false) {
                switch (opType) {
        engine = createEngine(store, primaryTranslogDir);  
        }
                translogOps.add(op);
    }
            .tombstoneDocSupplier(config.getTombstoneDocSupplier())
                final ParseContext.Document doc = new ParseContext.Document();  
        assert translogManager instanceof InternalTranslogManager : "only InternalTranslogManager have translogs, got: "
        final @Nullable LongSupplier maybeGlobalCheckpointSupplier,
import org.opensearch.plugins.Plugin;  
        return newUid(doc.id());  
        long primaryTerm,
            return new InternalTestEngine(config, IndexWriter.MAX_DOCS, localCheckpointTrackerSupplier) {
        String name = Codec.getDefault().getName();
            }  
        return document;
        boolean allowGapInSeqNo,
        CodecService codecService = new CodecService(null, INDEX_SETTINGS, logger, List.of());
                IndexWriter createWriter(Directory directory, IndexWriterConfig iwc) throws IOException {  
            );  
    }
                int docOffset;  
                doc.add(new StoredField(SourceFieldMapper.NAME, byteRef.bytes, byteRef.offset, byteRef.length));
    protected InternalEngine createEngine(
                        }  
            BigArrays.NON_RECYCLING_INSTANCE,
                }
import static org.opensearch.index.engine.Engine.Operation.Origin.PEER_RECOVERY;
                        ? seqNoForOperation.applyAsLong(this, operation)  
    }  
import java.util.function.ToLongBiFunction;
            return Collections.emptyMap();  
                case EXTERNAL_GTE:
                    Long.parseLong(commit.getUserData().get(SequenceNumbers.MAX_SEQ_NO)),
                }
                // Replicas don't really care to about found status of documents
                                0
    public EngineConfig copy(EngineConfig config, LongSupplier globalCheckpointSupplier) {
            breakerService,
                assertThat(collector.getTotalHits(), equalTo(1));
        );  
            createTempDir(),  
            IOUtils.close(replicaEngine, storeReplica, engine, store, () -> terminate(threadPool));  
import org.apache.lucene.document.StoredField;
                assertThat(luceneOp.getSource().source, equalTo(translogOp.getSource().source));  
        long maxSeqNo = SequenceNumbers.NO_OPS_PERFORMED;  
        final List<Translog.Operation> translogOps = new ArrayList<>();
            }
            assert maybeRetentionLeasesSupplier != null;
            .primaryTermSupplier(config.getPrimaryTermSupplier())  
        return document;
            translogPath,
    }
            new FsDirectoryFactory()
            final NumericDocValues seqNoDocValues = leaf.reader().getNumericDocValues(SeqNoFieldMapper.NAME);
            allowGapInSeqNo,
    ) {  
                (leases, listener) -> listener.onResponse(new ReplicationResponse()),  
                try (Engine.Searcher searcher = engine.acquireSearcher("test")) {  
        final Engine.Warmer warmer
 *
        }  
        TranslogManager translogManager = engine.translogManager();  
                            + retainedOps  
            maybeGlobalCheckpointSupplier == null ? null : () -> RetentionLeases.EMPTY,  
/*
                }
        );  
 * You may obtain a copy of the License at  
        if (randomBoolean()) {
            .indexSort(config.getIndexSort())
            createTempDir(),  
                protected long doGenerateSeqNoForOperation(final Operation operation) {  
            null  
                op.primaryTerm()
     */
import org.opensearch.core.common.bytes.BytesArray;
            return;
                document.add(new StoredField(SourceFieldMapper.RECOVERY_SOURCE_NAME, ref.bytes, ref.offset, ref.length));
                case EXTERNAL:
    public static Term newUid(String id) {
        String docId
     * Exposes a translog associated with the given engine for testing purpose.  
        int maxOpCount,
        final LongSupplier globalCheckpointSupplier;  
            return Collections.emptyMap();
            shardId,
        int minOpCount,  
    protected InternalEngine createEngine(Store store, Path translogPath) throws IOException {
            .similarity(config.getSimilarity())
        Path translogPath,  
            }  
            .startObject()
            .internalRefreshListener(intRefreshListenerList)
import org.opensearch.common.xcontent.XContentFactory;
                                SequenceNumbers.UNASSIGNED_SEQ_NO,
                    0
            .store(store)  
                    if (seqNos.add(seqNo) == false) {
        return maxSeqNo;
            .queryCache(config.getQueryCache())  
        final long maxSeqNo = ((InternalEngine) engine).getLocalCheckpointTracker().getMaxSeqNo();
                replicaEngine.refresh("test");  
        Thread[] thread = new Thread[randomIntBetween(3, 5)];
import java.util.ArrayList;  
    public EngineConfig config(
                    .thenComparingLong(DocIdSeqNoAndSource::getPrimaryTerm)  
            mergePolicy,
        } else {  
        return ops;  
                assertTrue(seqNoDocValues.advanceExact(docId));
        for (int i = 0; i < thread.length; i++) {
        engine.getLocalCheckpointTracker().waitForProcessedOpsToComplete(seqNo);
        return Settings.builder()
            shuffle(ops.subList(0, firstOpWithSeqNo), random());  
                } else {
        assert engine instanceof InternalEngine : "only InternalEngines have snapshotted commits, got: " + engine.getClass();  
        final Engine.EventListener eventListener,  
        return createMapperService("{\"properties\": {}}");
                indexSettings,
                            + "retention policy ["
        );  
        switch (operation.operationType()) {  
        }  
        InternalEngine internalEngine = new InternalEngine(config) {
        @Nullable LongSupplier globalCheckpointSupplier,  
    }  
                    try {
        CircuitBreakerService breakerService
                engine.ensureOpen();
            .retentionLeasesSupplier(retentionLeasesSupplier)  
                    break;
    public static void waitForOpsToComplete(InternalEngine engine, long seqNo) throws InterruptedException {
                    assertAtMostOneLuceneDocumentPerSequenceNumber(engine.config().getIndexSettings(), searcher.getDirectoryReader());
                randomNonNegativeLong(),
        if (engine instanceof InternalEngine) {  
            assertConsistentHistoryBetweenTranslogAndLuceneIndex(engine);  
import org.opensearch.common.Nullable;
            .retentionLeasesSupplier(config.retentionLeasesSupplier())
            TranslogOperationHelper.create(engine.config()),
                searcher.search(new TermQuery(new Term("value", lastFieldValue)), collector);  
                        ? seqNoForOperation.applyAsLong(this, operation)
                }  
import org.opensearch.index.mapper.VersionFieldMapper;
        for (Translog.Operation translogOp : translogOps) {
            Settings.builder().put(config.getIndexSettings().getSettings()).build()
        boolean allowDuplicate,  
            .queryCachingPolicy(IndexSearcher.getDefaultQueryCachingPolicy())
            .put(  
        Store store,
            .similarity(config.getSimilarity())
    ) {
import org.opensearch.index.VersionType;
            return ((InternalEngine) engine).getInFlightDocCount();
        Store store,  
            .startObject("type")  
        String id,
        if (engine.isClosed.get() == false) {
                                seqNo,
import org.apache.lucene.document.NumericDocValuesField;  
                operations.add(op);  
            engine.config().setEnableGcDeletes(false);  
        } else {  
            .translogConfig(config.getTranslogConfig())
        Path translogPath,
            .put(IndexSettings.INDEX_GC_DELETES_SETTING.getKey(), "1h") // make sure this doesn't kick in on us  
        long seqNo = 0;
                        throw new AssertionError(e);
    public static MapperService createMapperService(String mapping) throws IOException {  
        } else {  
    protected void assertEngineCleanedUp(Engine engine, TranslogDeletionPolicy translogDeletionPolicy) throws Exception {  
    protected static final BytesReference B_1 = new BytesArray(new byte[] { 1 });
                    doc.add(new StoredField(RoutingFieldMapper.NAME, routing));  
            eventListener,
    }
        final Path translogPath,
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
                            new Engine.NoOp(seqNo, primaryTerm.get(), randomFrom(REPLICA, PEER_RECOVERY), startTime, "test-" + i)
        assertBusy(() -> assertThat(getInFlightDocCount(engine), equalTo(0L)));
    protected InternalEngine createEngine(IndexSettings indexSettings, Store store, Path translogPath, MergePolicy mergePolicy)  
    ) {
                    version,
    }
            final String translogUuid = Translog.createEmptyTranslog(
            try (DirectoryReader reader = DirectoryReader.open(commit)) {
            .indexSettings(indexSettings)  
    }
        document.add(new TextField("value", value, Field.Store.YES));
                final TotalHitCountCollector collector = new TotalHitCountCollector();
            .tombstoneDocSupplier(config.getTombstoneDocSupplier())  
                    id,
                        if (primaryTermDocValues.advanceExact(i) == false) {
        return config(
        return createEngine(indexSettings, store, translogPath, mergePolicy, indexWriterFactory, null, null);
import org.apache.lucene.codecs.Codec;  
            }  
        }
        TranslogConfig translogConfig = new TranslogConfig(
            final TotalHitCountCollector collector = new TotalHitCountCollector();  
            mergePolicy,
    public EngineConfig config(
            indexSettings,
        final List<ReferenceManager.RefreshListener> intRefreshListenerList = internalRefreshListener == null  
            "",  
        primaryTerm.set(randomLongBetween(1, Long.MAX_VALUE));  
        if (lastOp instanceof Engine.Index) {
    }  
            .putMapping(mapping)
        return new EngineConfig.Builder().shardId(config.getShardId())  
            .build();
            translogConfig,
            mergePolicy,
            shardId,
        for (Translog.Operation op : luceneOps.values()) {
                    }  
            return 0;  
                config.getTranslogConfig().getTranslogPath(),
            return term.get();
            .codecService(new CodecService(null, indexSettings, logger, List.of()))
    protected final AllocationId allocationId = AllocationId.newInitializing();  
import static java.util.Collections.shuffle;  
            .toString();
    }
            shardId,
    @FunctionalInterface
    public static MapperService createMapperServiceForContextAwareIndex() throws IOException {  
                        if (seqNoDocValues.advanceExact(i) == false) {
        return new EngineConfig.Builder().shardId(config.getShardId())
                            throw new AssertionError("seqNoDocValues not found for doc[" + i + "] id[" + id + "]");
        final ReferenceManager.RefreshListener externalRefreshListener,
 * SPDX-License-Identifier: Apache-2.0
    }  
            .circuitBreakerService(config.getCircuitBreakerService())
    ) throws IOException {
        final Engine.EventListener eventListener = new Engine.EventListener() {  
        }  
    }  
        if (localCheckpointTrackerSupplier == null) {
    }  
    }  
        LiveIndexWriterConfig currentIndexWriterConfig = engine.getCurrentIndexWriterConfig();
                "performing [{}], v [{}], seq# [{}], term [{}]",  
        CountDownLatch startGun = new CountDownLatch(thread.length);
        LongSupplier globalCheckpointSupplier
    }  
                        "Operation not found seq# ["  
                    Collections.singletonList(doc),
        );
        return new Engine.Index(newUid(doc), primaryTerm.get(), doc);
        return createEngine(  
import org.opensearch.common.util.set.Sets;  
        document.add(seqID.seqNoDocValue);  
                BytesRef byteRef = new BytesRef(reason);
                        );  
            } else {
            : "only InternalEngines or NRTReplicationEngines have translogs, got: " + engine.getClass();
    }  
    protected InternalEngine createEngine(  
                return newDeleteTombstoneDoc(id, null);
    public static List<Translog.Operation> readAllOperationsBasedOnSource(Engine engine) throws IOException {
                seqNo++;
    protected InternalEngine createEngine(  
        return createEngine(defaultSettings, store, translogPath, newMergePolicy(), null);  
                op = new Engine.Delete(  
                    .thenComparing((DocIdSeqNoAndSource::getId))
    }
        } else {
    protected ThreadPool threadPool;  
        @Nullable final BiFunction<Long, Long, LocalCheckpointTracker> localCheckpointTrackerSupplier,
            }  
import java.util.Collections;  
            .indexSort(config.getIndexSort())
                if (minSeqNoToRetain <= translogOp.seqNo()) {
                update -> {},
            globalCheckpointSupplier
        }
import org.opensearch.core.index.Index;
        return operations;  
            final int nestedValues = between(0, 3);
        Mapping mappingUpdate
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
    protected InternalEngine createEngine(
                doc.add(seqID.primaryTerm);
     */  
import org.opensearch.index.mapper.RoutingFieldMapper;
                .build()
                doc.add(versionField);  
        );  
            }  
    ) {  
    protected InternalEngine replicaEngine;
        return internalTranslogManager.getTranslog();
                            throw new AssertionError("versionDocValues not found for doc[" + i + "] id[" + id + "]");  
    protected EngineConfig config(  
        final Sort indexSort,
        internalEngine.translogManager().recoverFromTranslog(translogHandler, internalEngine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);  
                }
                        }
        return createTranslog(primaryTranslogDir, primaryTermSupplier);
    }
        final String nestedMapping = XContentFactory.jsonBuilder()
import org.apache.lucene.index.LeafReader;
            .circuitBreakerService(config.getCircuitBreakerService())  
                    id,
     * Override config with ingestion engine configs
        @Nullable IndexWriterFactory indexWriterFactory,
                SequenceNumbers.NO_OPS_PERFORMED,  
                }
import org.apache.lucene.index.LiveIndexWriterConfig;  
import org.opensearch.common.settings.Settings;
        primaryTranslogDir = createTempDir("translog-primary");
            .indexSettings(indexSettings)
                if (primaryTermDocValues.advanceExact(docId)) {
        Sort indexSort,  
    protected InternalEngine engine;  
            .codecService(new CodecService(null, config.getIndexSettings(), logger, List.of()))
        };  
            .codecService(new CodecService(null, indexSettings, logger, List.of()))  
    ) {
            () -> SequenceNumbers.NO_OPS_PERFORMED,
        return mapperService;
        return createStore(newDirectory());  
            while (firstOpWithSeqNo < ops.size() && ops.get(firstOpWithSeqNo).seqNo() < 0) {
            };  
            newMergePolicy(),
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(  
            .warmer(config.getWarmer())
    public static void assertAtMostOneLuceneDocumentPerSequenceNumber(IndexSettings indexSettings, DirectoryReader reader)  
        }; // we don't need to notify anybody in this test
        boolean includeNestedDocs,
            while ((docId = seqNoDocValues.nextDoc()) != DocIdSetIterator.NO_MORE_DOCS) {  
        );  
                        throw new AssertionError("found multiple documents for seq=" + seqNo + " id=" + idFieldVisitor.getId());
            );  
            assertNoInFlightDocuments(engine);
                            + "], global checkpoint ["
import org.opensearch.index.translog.TranslogConfig;
    ) {
            .globalCheckpointSupplier(config.getGlobalCheckpointSupplier())
            .retentionLeasesSupplier(config.retentionLeasesSupplier())  
    protected TranslogHandler translogHandler;
            int firstOpWithSeqNo = 0;
 *     http://www.apache.org/licenses/LICENSE-2.0
                                true,
            codecName = name;  
                throws EngineException {
            }  
            assertThat(luceneOp.toString(), luceneOp.primaryTerm(), equalTo(translogOp.primaryTerm()));  
     * Reads all engine operations that have been processed by the engine from Lucene index/Translog based on source.
                    replicaEngine,
        MergePolicy mergePolicy,
        return createEngine(defaultSettings, store, translogPath, newMergePolicy(), null, localCheckpointTrackerSupplier, null);  
    }
    public EngineConfig copy(EngineConfig config, MergePolicy mergePolicy) {
                                null,
            }  
        final Store store = config.getStore();  
            primaryTermSupplier,  
        String mapping = "{\"properties\": {}}";
            .build();
                assertEngineCleanedUp(engine, assertAndGetInternalTranslogManager(engine.translogManager()).getDeletionPolicy());
            }
                doc.add(seqID.seqNo);  
    protected String codecName;
            }
        Path translogPath,
     */  
                        BytesRef binaryID = doc.getBinaryValue(IdFieldMapper.NAME);
            .mergePolicy(mergePolicy)
    public static void assertConsistentHistoryBetweenTranslogAndLuceneIndex(Engine engine) throws IOException {  
            final XContentBuilder source = XContentFactory.jsonBuilder().startObject().field("field", "value");
        final DirectoryReader wrappedReader = indexSettings.isSoftDeleteEnabled() ? Lucene.wrapAllDocsLive(reader) : reader;  
            .circuitBreakerService(config.getCircuitBreakerService())  
            "",
    public static long generateNewSeqNo(final Engine engine) {
        return testParsedDocument(id, routing, testDocumentWithTextField(), new BytesArray("{ \"value\" : \"test\" }"), null);
            BigArrays.NON_RECYCLING_INSTANCE,  
            .internalRefreshListener(config.getInternalRefreshListener())  
 * ownership. Elasticsearch licenses this file to you under  
        return new ParseContext.Document();  
     * Returns the number of times a version was looked up either from version map or from the index.
            Translog.Operation op;
                seqID.tombstoneField.setLongValue(1);  
            null,
    public static void concurrentlyApplyOps(List<Engine.Operation> ops, InternalEngine engine) throws InterruptedException {  
            .retentionLeasesSupplier(config.retentionLeasesSupplier())
                );  
            .build();
            });
                        }
                doc.add(seqID.seqNo);  
        }  
                XContentBuilder nestedField = source.startObject("nested_field");
                    forReplica ? REPLICA : PRIMARY,
            final ReplicationTracker replicationTracker = new ReplicationTracker(
        try (Engine.Searcher searcher = engine.acquireSearcher("test")) {
            .eventListener(config.getEventListener())  
            .internalRefreshListener(emptyList())  
        document.add(seqID.primaryTerm);
        }  
            @Override  
            .retentionLeasesSupplier(config.retentionLeasesSupplier())
            if (nestedFieldValues > 0) {  
    }
                        final long primaryTerm = primaryTermDocValues.longValue();
    protected static final BytesReference B_2 = new BytesArray(new byte[] { 2 });
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    }
            if (replicaEngine != null && replicaEngine.isClosed.get() == false) {
            .indexSettings(indexSettings)
import org.opensearch.index.store.FsDirectoryFactory;
import org.apache.lucene.search.IndexSearcher;  
    }  
import org.apache.lucene.document.Field;
import java.util.List;
                source.endObject();
import org.opensearch.index.seqno.LocalCheckpointTracker;
    @Override
                // as deleted or not. This check is just signal regression so a decision can be made if it's
        return mapperService;  
    }
            if (luceneOp == null) {  
            null,
    }
import org.opensearch.index.codec.CodecService;
        if (refresh) {
            for (int copy = 0; copy < copies; copy++) {
        try {
            "test",
            lastFieldValue = null;
import org.opensearch.OpenSearchException;
            store,
        return new EngineConfig.TombstoneDocSupplier() {
import org.opensearch.index.translog.LocalTranslog;
                firstOpWithSeqNo++;  
            .startObject("properties")
        ParseContext.Document document = new ParseContext.Document();  
    public static boolean hasSnapshottedCommits(Engine engine) {
            .store(store)
    }
import org.opensearch.cluster.metadata.IndexMetadata;  
            includeNestedDocs,
                engine.refresh("test");
     * The returned operations are sorted and de-duplicated, thus each sequence number will be have at most one operation.  
        }; // we don't need to notify anybody in this test
            .primaryTermSupplier(config.getPrimaryTermSupplier())  
            return nestedMapper.parse(new SourceToParse("test", docId, BytesReference.bytes(source), MediaTypeRegistry.JSON));
            store.associateIndexWithNewTranslog(translogUuid);
        }
import org.opensearch.index.mapper.SourceToParse;
                    version = randomBoolean() ? Math.max(i - 1, 0) : i;  
    /**
    }  
    protected Engine.Index indexForDoc(ParsedDocument doc) {
            store,  
        final Engine.EventListener eventListener = new Engine.EventListener() {
            .tombstoneDocSupplier(tombstoneDocSupplier())
 * specific language governing permissions and limitations
            "test"
        @Nullable IndexWriterFactory indexWriterFactory
            .queryCachingPolicy(config.getQueryCachingPolicy())
            thread[i].start();  
        int numOps,
            .mergePolicy(config.getMergePolicy())
import org.opensearch.cluster.routing.AllocationId;
            .queryCachingPolicy(config.getQueryCachingPolicy())
            translogPath,  
    }  
import java.util.function.LongSupplier;  
            this.term.set(newTerm);
import org.opensearch.common.lucene.Lucene;  
            .translogConfig(config.getTranslogConfig())
        translogHandler = createTranslogHandler(config.getIndexSettings(), internalEngine);
            public Searcher acquireSearcher(String source, SearcherScope scope, Function<Searcher, Searcher> wrapper)
                        final BytesRef source = doc.getBinaryValue(SourceFieldMapper.NAME);  
        String routing,
            .endObject()  
                IndexWriter createWriter(Directory directory, IndexWriterConfig iwc) throws IOException {
        storeReplica = createStore();
                } catch (InterruptedException e) {  
                shardId,
                LeafReader reader = leafContext.reader();
                        operations.add(
        assertVisibleCount(engine, numDocs, true);  
                    null
    }  
                    break;
        IndexSettings indexSettings,
            maybeGlobalCheckpointSupplier,
                Field versionField = new NumericDocValuesField(VersionFieldMapper.NAME, 0);  
                between(10, 10 * IndexSettings.MAX_REFRESH_LISTENERS_PER_SHARD.get(Settings.EMPTY))
    }
import org.apache.logging.log4j.Logger;
    protected Store createStore(final Directory directory) throws IOException {  
            return get();
            engine.config().setEnableGcDeletes(false);  
            retentionLeasesSupplier = replicationTracker::getRetentionLeases;
            .threadPool(config.getThreadPool())  
        }
        final ShardPath shardPath = new ShardPath(false, path, path, shardId);  
                () -> 0L,
        Store store,
                    nestedField.field("field-" + i, "value-" + i);  
            while ((op = snapshot.next()) != null) {
            );  
import org.opensearch.index.translog.TranslogOperationHelper;
            "test",
                            continue;  
            createTranslogDeletionPolicy(INDEX_SETTINGS),
            randomFrom(Engine.Operation.TYPE.values())
        assertEquals(engine.config().getCodec().getName(), codecService.codec(codecName).getName());  
        if (Arrays.asList(codecService.availableCodecs()).contains(name)) {  
        Path translogPath,
import java.util.concurrent.atomic.AtomicLong;  
        final Store store,  
                op.operationType().name().charAt(0),
import org.apache.lucene.document.Document;
            final String id = Integer.toString(randomInt(maxIdValue));  
            warmer
                protected long doGenerateSeqNoForOperation(final Operation operation) {
        return new BytesArray(string.getBytes(Charset.defaultCharset()));
    protected static final IndexSettings INDEX_SETTINGS = IndexSettingsModule.newIndexSettings("index", Settings.EMPTY);
            .internalRefreshListener(emptyList())
            .primaryTermSupplier(config.getPrimaryTermSupplier())
                                startTime,  
            seqNoForRecovery = engine.getMinRetainedSeqNo();
            .putMapping(mapping)
        Lucene.cleanLuceneIndex(storeReplica.directory());
                                null,
            new NoneCircuitBreakerService(),
        final List<Engine.Operation> ops,
        for (int i = 0; i < thread.length; i++) {
import org.opensearch.common.concurrent.GatedCloseable;
        if (refresh) {
            indexSettings,  
            }
import org.opensearch.index.translog.Translog;  
        final Sort indexSort,
            translogPath,  
    @Before  
import org.opensearch.Version;
    public static void assertAtMostOneLuceneDocumentPerSequenceNumber(Engine engine) throws IOException {
    protected static ParsedDocument testParsedDocument(
     * @throws InterruptedException if the thread was interrupted while blocking on the condition
            .indexSort(config.getIndexSort())  
            if (luceneOp.opType() == Translog.Operation.Type.INDEX) {
import java.util.Arrays;
        }
        EngineConfig.TombstoneDocSupplier tombstoneDocSupplier
            translogPath,
            new BytesArray("{ \"value\" : \"test\" }"),  
        for (int i = 0; i < numOfOps; i++) {
        final Directory directory = store.directory();
            Settings.EMPTY,
            Settings.EMPTY,
    }
            seqNo,  
        }  
            false
    protected static BytesArray bytesArray(String string) {  
        };
        EngineConfig config
            .queryCachingPolicy(config.getQueryCachingPolicy())  
        @Nullable ToLongBiFunction<Engine, Engine.Operation> seqNoForOperation
                        operations.add(  
        ReferenceManager.RefreshListener externalRefreshListener,
            assertThat(luceneOp.opType(), equalTo(translogOp.opType()));
            }
        replicaEngine = createEngine(storeReplica, replicaTranslogDir);  
            switch (versionType) {
    public static InternalEngine createInternalEngine(
                document.add(new StoredField(SourceFieldMapper.NAME, ref.bytes, ref.offset, ref.length));
        Store store,
    protected EngineConfig noOpConfig(IndexSettings indexSettings, Store store, Path translogPath) {
    protected static ParseContext.Document testDocumentWithTextField() {
            internalRefreshListener,
import java.util.function.Supplier;
                shardId,
                    assertAndGetInternalTranslogManager(replicaEngine.translogManager()).getDeletionPolicy()
            assertAtMostOneLuceneDocumentPerSequenceNumber(engine);  
                break;  
    ) {
