    protected IndexWriterFactory indexWriterFactory;  
        final TranslogConfig translogConfig = new TranslogConfig(
                                primaryTerm.get(),
            .queryCache(IndexSearcher.getDefaultQueryCache())
        boolean allowDuplicate,
    ) {
import org.opensearch.common.unit.TimeValue;
            Directory failingDirectory = useFailingDirectorySupplier.get() ? failingWriteDirectorySupplier.get() : directory;  
            null,  
            NO_OPS_PERFORMED,
            .endObject()
            () -> RetentionLeases.EMPTY
        public IndexWriter createWriter(Directory directory, IndexWriterConfig config) throws IOException {
        super.setUp();  
            assert maybeRetentionLeasesSupplier == null;
            final boolean isNestedDoc = includeNestedDocs && opType == Engine.Operation.TYPE.INDEX && randomBoolean();
        return new ParseContext.Document();
            null,
import org.junit.Before;  
                                null,
            lookup
                public long addDocument(Iterable<? extends IndexableField> doc) throws IOException {
import java.util.concurrent.atomic.AtomicBoolean;
        final IndexSettings indexSettings,
        final ReferenceManager.RefreshListener externalRefreshListener,
import org.opensearch.core.index.shard.ShardId;
        Engine.Operation.TYPE opType  
    public static CheckedBiFunction<String, Integer, ParsedDocument, IOException> nestedParsedDocFactory() throws Exception {  
import org.apache.lucene.search.Sort;
        };
                                i,  
                    flush();
                        operations.add(  
            null,
    public static MapperService createMapperService(String mapping) throws IOException {
    protected IndexWriter createWriter() throws IOException {
                                primaryTerm.get(),
            for (int copy = 0; copy < copies; copy++) {  
        return testDocumentWithTextField("test");
        primaryTranslogDir = createTempDir("translog-primary");
        doc.add(seqID.seqNoDocValue);
        doc.add(seqID.seqNo);
import java.util.Arrays;  
            return new IndexWriter(directory, newIndexWriterConfig().setSoftDeletesField(Lucene.SOFT_DELETES_FIELD).setCommitOnClose(true));
    public static MapperService createMapperService() throws IOException {
                update -> {},
                shardId,  
import org.apache.lucene.index.Term;
                public long softUpdateDocuments(
        MapperService mapperService = MapperTestUtils.newMapperService(  
            .toString();  
                                seqNo,
    protected static ParseContext.Document testDocumentWithTextField(String value) {
            new NamedXContentRegistry(ClusterModule.getNamedXWriteables()),
                public long addDocuments(Iterable<? extends Iterable<? extends IndexableField>> docs) throws IOException {
import org.apache.lucene.index.IndexableField;
                    case DELETE:
            new BytesArray("{ \"value\" : \"test\" }"),
                    flush();
            primaryTranslogDir,
                ) throws IOException {
            globalCheckpointSupplier = replicationTracker;
            .primaryTermSupplier(primaryTerm)
            translogPath,
            )  
            BytesRef ref = source.toBytesRef();
    protected CompositeIndexWriter.DisposableIndexWriter createChildWriterFactory(
import org.opensearch.Version;
import org.opensearch.threadpool.ThreadPool;
        document.add(versionField);
import org.junit.After;
                Settings.builder()
                                EngineTestCase.newUid(doc),  
                    ? nestedParsedDocFactory.apply(id, nestedValues)
public class CriteriaBasedCompositeIndexWriterBaseTests extends OpenSearchTestCase {
        mapperService.merge(indexMetadata, MapperService.MergeReason.MAPPING_UPDATE);  
    @Override  
    protected ThreadPool threadPool;
            new IndexWriter(  
        String groupingCriteria
import org.opensearch.core.xcontent.MediaTypeRegistry;
        );
        document.add(seqID.primaryTerm);
        if (source != null) {  
            .startObject("properties")
            NoMergePolicy.INSTANCE,  
            this.failingWriteDirectorySupplier = failingWriteDirectorySupplier;
    }
        @Override
    @After  
        } else {
import java.util.concurrent.atomic.AtomicLong;
            }
            .build();
        );
                    case NO_OP:  
            .threadPool(threadPool)
        try {
            source.endObject();
            if (allowGapInSeqNo && rarely()) {
        String id,
        primaryTranslogDir = createTempDir("translog-primary");
            this.directories = new ArrayList<>();  
import org.opensearch.test.IndexSettingsModule;
            directories.add(failingDirectory);
            indexSettings,
            store,
import org.opensearch.index.seqno.SequenceNumbers;
import org.apache.lucene.index.IndexWriterConfig;  
                }  
import org.opensearch.core.xcontent.XContentBuilder;
            .queryCachingPolicy(IndexSearcher.getDefaultQueryCachingPolicy())
        );
        final SoftDeletesPolicy softDeletesPolicy = new SoftDeletesPolicy(  
                source.endObject();  
        seqID.tombstoneField.setLongValue(1);
        } catch (LockObtainFailedException ex) {  
import java.nio.file.Path;
        ParseContext.Document document,  
                    nestedField.field("field-" + i, "value-" + i);
                () -> 0L,  
            return nestedMapper.parse(new SourceToParse("test", docId, BytesReference.bytes(source), MediaTypeRegistry.JSON));  
        }
            .settings(
        doc.add(uidField);  
        final ReferenceManager.RefreshListener internalRefreshListener,  
import org.opensearch.index.mapper.Uid;  
            final int copies = allowDuplicate && rarely() ? between(2, 4) : 1;
                public long softUpdateDocument(Term term, Iterable<? extends IndexableField> doc, Field... softDeletes) throws IOException {  
 * this file be licensed under the Apache-2.0 license or a
            final ReplicationTracker replicationTracker = new ReplicationTracker(
                            )
            null,
            null
                    return seqNo;
                                -1,
            .codecService(new CodecService(null, indexSettings, logger, List.of()))
                    case INDEX:
        ParseContext.Document document,
            Store.OnClose.EMPTY,
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
        return testParsedDocument(id, routing, document, source, mappingUpdate, false, groupingCriteria);  
            .translogConfig(translogConfig)  
                                randomFrom(REPLICA, PEER_RECOVERY),
import org.opensearch.index.MapperTestUtils;
                    : createParsedDoc(id, null, DEFAULT_CRITERIA);  
                        operations.add(
import org.opensearch.threadpool.TestThreadPool;  
        indexWriterFactory = new NativeLuceneIndexWriterFactory();
    protected static ParseContext.Document testDocumentWithTextField() {  
    protected static ParsedDocument testParsedDocument(  
        return (docId, nestedFieldValues) -> {
        String routing,
                XContentBuilder nestedField = source.startObject("nested_field");
    protected Store createStore(final IndexSettings indexSettings, final Directory directory) throws IOException {
            .indexSettings(indexSettings)
    protected static ParsedDocument testParsedDocument(
        int numOps,
import org.opensearch.index.codec.CodecService;
                    return seqNo;  
        return new ParsedDocument(versionField, seqID, id, routing, Arrays.asList(document), source, MediaTypeRegistry.JSON, mappingUpdate);  
                                seqNo,
        return softDeletesPolicy;
        final String nestedMapping = XContentFactory.jsonBuilder()
            .analyzer(iwc.getAnalyzer())  
            .globalCheckpointSupplier(globalCheckpointSupplier)  
    protected static final IndexSettings INDEX_SETTINGS = IndexSettingsModule.newIndexSettings("index", Settings.EMPTY);  
                randomNonNegativeLong(),  
                                startTime,  
                                true,
                indexSettings,
                            )  
import java.util.function.Supplier;
    }
        String id,
import java.util.Collections;
import org.opensearch.test.OpenSearchTestCase;
        return newUid(doc.id());
    protected static class FlushingIndexWriterFactory extends NativeLuceneIndexWriterFactory implements Closeable {
import org.opensearch.index.mapper.Mapping;  
            }  
                    long seqNo = super.addDocuments(docs);  
        FlushingIndexWriterFactory(Supplier<Directory> failingWriteDirectorySupplier, AtomicBoolean useFailingDirectorySupplier) {
    public EngineConfig config() {
    public SoftDeletesPolicy newSoftDeletesPolicy() {  
import static org.opensearch.index.seqno.SequenceNumbers.NO_OPS_PERFORMED;  
                switch (opType) {
    public static final String DEFAULT_CRITERIA = "testGroupingCriteria";
    }
            .startObject("type")
        store = createStore(INDEX_SETTINGS, newDirectory());
import org.opensearch.common.lucene.Lucene;
        Mapping mappingUpdate,
import org.apache.lucene.search.ReferenceManager;  
            .retentionLeasesSupplier(retentionLeasesSupplier)
            : Collections.singletonList(externalRefreshListener);  
import org.opensearch.index.shard.ShardPath;
            .eventListener(eventListener)  
            : Collections.singletonList(internalRefreshListener);  
        document.add(uidField);  
        final CircuitBreakerService breakerService,
                                SequenceNumbers.UNASSIGNED_SEQ_NO,  
                newIndexWriterConfig().setSoftDeletesField(Lucene.SOFT_DELETES_FIELD).setCommitOnClose(true)
import org.apache.lucene.store.Directory;
import org.opensearch.cluster.metadata.IndexMetadata;
            primaryTranslogDir,  
    }
        final MergePolicy mergePolicy,
            indexSettings,
            ),  
import org.opensearch.common.util.BigArrays;
    @Before
                final ParsedDocument doc = isNestedDoc
        final @Nullable Supplier<RetentionLeases> maybeRetentionLeasesSupplier,  
            .flushMergesAfter(TimeValue.timeValueMinutes(5))
            logger.warn("could not lock IndexWriter", ex);
import org.opensearch.index.mapper.DocumentMapper;  
        boolean includeNestedDocs,
        CheckedBiFunction<String, Integer, ParsedDocument, IOException> nestedParsedDocFactory = nestedParsedDocFactory();
    public EngineConfig config(Store store) {
import org.opensearch.index.translog.TranslogConfig;
            shardId,  
    }
 * SPDX-License-Identifier: Apache-2.0
import java.util.function.LongSupplier;  
import java.util.ArrayList;
                                doc.id(),
import org.opensearch.core.index.Index;
                            new Engine.NoOp(seqNo, primaryTerm.get(), randomFrom(REPLICA, PEER_RECOVERY), startTime, "test-" + i)
import java.util.UUID;  
            "test"
import org.opensearch.index.mapper.SourceToParse;
        private final List<Directory> directories;
            null,
    }  
            "",
import org.apache.lucene.store.LockObtainFailedException;  
    }
            null,  
            null,
import static org.opensearch.index.engine.Engine.Operation.Origin.PEER_RECOVERY;
        threadPool = new TestThreadPool(getClass().getName());  
        SeqNoFieldMapper.SequenceIDFields seqID = SeqNoFieldMapper.SequenceIDFields.emptySeqID();
    }
 * The OpenSearch Contributors require contributions made to  
    protected static ParsedDocument createParsedDoc(String id, String routing, String groupingCriteria) {
    protected static Term newUid(String id) {  
    public List<Engine.Operation> generateHistoryOnReplica(
                @Override
import org.opensearch.common.compress.CompressedXContent;
    protected static ParseContext.Document testDocument() {
            .endObject()  
            new FsDirectoryFactory()  
        final List<ReferenceManager.RefreshListener> extRefreshListenerList = externalRefreshListener == null
        final IndexWriterConfig iwc = newIndexWriterConfig();
                    return seqNo;
    ) {
            globalCheckpointSupplier = maybeGlobalCheckpointSupplier;  
        final Path path = createTempDir().resolve(shardId.getIndex().getUUID()).resolve(String.valueOf(shardId.id()));  
                }
 * compatible open source license.
        return new Engine.Index(newUid(doc), primaryTerm.get(), doc);  
    protected IndexWriter createWriter(Directory directory) throws IOException {  
import org.apache.lucene.index.NoMergePolicy;  
            .putMapping(mapping)
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                }
                        operations.add(  
import org.opensearch.common.settings.Settings;  
        return doc;
                seqNo++;
            .startObject("nested_field")  
        document.setGroupingCriteria(groupingCriteria);
import org.opensearch.cluster.ClusterModule;
    protected final AllocationId allocationId = AllocationId.newInitializing();  
    }  
        return new CompositeIndexWriter.DisposableIndexWriter(
 *
import org.opensearch.index.mapper.SeqNoFieldMapper;  
        Mapping mappingUpdate,  
 */  
                (leases, listener) -> listener.onResponse(new ReplicationResponse()),
        final Engine.EventListener eventListener
import org.opensearch.index.seqno.ReplicationTracker;
        ParseContext.Document document = testDocument();
        doc.add(seqID.primaryTerm);  
            shardPath,
            .store(store)
import org.opensearch.index.mapper.VersionFieldMapper;
        final MapperService mapperService = createMapperService();
package org.opensearch.index.engine;
        final LongSupplier globalCheckpointSupplier;
                                null,
        boolean recoverySource,  
                }
        Field uidField = new Field(IdFieldMapper.NAME, Uid.encodeId(id), IdFieldMapper.Defaults.FIELD_TYPE);
import org.opensearch.common.CheckedBiFunction;
            seqNo++;  
        final AtomicLong globalCheckpoint = new AtomicLong();
        return operations;  
        doc.add(seqID.tombstoneField);
        final @Nullable LongSupplier maybeGlobalCheckpointSupplier,
        }
import org.opensearch.index.mapper.MapperService;
        final int maxIdValue = randomInt(numOps * 2);  
                SequenceNumbers.NO_OPS_PERFORMED,
            .endObject()
        doc.add(versionField);
                        break;
                            new Engine.Index(
        public void close() throws IOException {
    protected Engine.Index indexForDoc(ParsedDocument doc) {
import org.opensearch.test.DummyShardLock;  
import org.opensearch.common.Randomness;  
            retentionLeasesSupplier = replicationTracker::getRetentionLeases;  
                    Iterable<? extends Iterable<? extends IndexableField>> docs,  
import org.opensearch.core.indices.breaker.CircuitBreakerService;  
    }
        return new EngineConfig.Builder().shardId(shardId)  
    public EngineConfig config(  
    }  
    }
            directory,
        final int extraRetainedOps = between(0, 100);
                        );
            .internalRefreshListener(intRefreshListenerList)  
            .build();  
    protected final ShardId shardId = new ShardId(new Index("index", "_na_"), 0);
}  
    public void tearDown() throws Exception {
            return new IndexWriter(failingDirectory, config) {
    }
            createTempDir(),
            NoMergePolicy.INSTANCE,
            if (nestedFieldValues > 0) {
        final List<Engine.Operation> operations = new ArrayList<>(numOps);
import org.opensearch.common.Nullable;
                                randomFrom(REPLICA, PEER_RECOVERY),
                document.add(new StoredField(SourceFieldMapper.NAME, ref.bytes, ref.offset, ref.length));  
    }
        Field versionField = new NumericDocValuesField("_version", 0);
            new NoneCircuitBreakerService(),  
        super.tearDown();
            ? emptyList()
import org.opensearch.core.common.bytes.BytesArray;
            store,
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
            throw ex;
                        throw new IllegalStateException("Unknown operation type [" + opType + "]");  
import org.opensearch.index.IndexSettings;  
            false
            .circuitBreakerService(breakerService)
            } else {
                document.add(new StoredField(SourceFieldMapper.RECOVERY_SOURCE_NAME, ref.bytes, ref.offset, ref.length));  
        final ParseContext.Document doc = new ParseContext.Document();
            assert maybeRetentionLeasesSupplier != null;
        String criteria,
            new NoneCircuitBreakerService(),
            .endObject()
import org.opensearch.index.store.FsDirectoryFactory;  
            ? emptyList()
            .indexSort(indexSort)
import org.opensearch.index.mapper.IdFieldMapper;
import org.opensearch.common.util.io.IOUtils;  
        if (maybeGlobalCheckpointSupplier == null) {  
            shardId,  
        return createWriter(store.directory());  
        final Sort indexSort,
    }
                    Term term,
                    default:
        String groupingCriteria
                allocationId.getId(),
                    long seqNo = super.softUpdateDocument(term, doc, softDeletes);
    protected final EngineTestCase.PrimaryTermSupplier primaryTerm = new EngineTestCase.PrimaryTermSupplier(1L);
        return document;
            testDocumentWithTextField(),  
            extraRetainedOps,  
        );  
        document.add(new TextField("value", value, Field.Store.YES));  
    ) throws IOException {
    }
                    Field... softDeletes
import java.io.Closeable;
        }
        Randomness.shuffle(operations);
                        );  
    }
    protected Store store;
                () -> SafeCommitInfo.EMPTY,
            final int nestedValues = between(0, 3);  
        return new Store(
                                startTime,  
        return createMapperService("{\"properties\": {}}");
            null,
        return new Term("_id", Uid.encodeId(id));
        return testParsedDocument(  
        final Path translogPath,  
import static java.util.Collections.emptyList;  
        final List<ReferenceManager.RefreshListener> intRefreshListenerList = internalRefreshListener == null
        }
            if (recoverySource) {
import org.apache.lucene.util.BytesRef;
    }
                    return seqNo;
            retentionLeasesSupplier = maybeRetentionLeasesSupplier;
        );
                                0
import java.util.List;
import org.apache.lucene.document.Field;
        final ShardPath shardPath = new ShardPath(false, path, path, shardId);
                for (int i = 0; i < nestedFieldValues; i++) {  
        }
import org.opensearch.index.store.Store;
        private final Supplier<Directory> failingWriteDirectorySupplier;  
                    long seqNo = super.softUpdateDocuments(term, docs, softDeletes);  
                    flush();  
        document.add(seqID.seqNo);
import org.apache.lucene.index.IndexWriter;
        IndexMetadata indexMetadata = IndexMetadata.builder("test")  
                                0
        private final AtomicBoolean useFailingDirectorySupplier;
                                i,  
    }
        return config(  
        SeqNoFieldMapper.SequenceIDFields seqID = SeqNoFieldMapper.SequenceIDFields.emptySeqID();  
        String routing,  
        }
import org.opensearch.index.mapper.ParsedDocument;
import org.opensearch.index.mapper.ParseContext;
import org.opensearch.core.common.bytes.BytesReference;  
        );
import static org.opensearch.index.engine.Engine.Operation.Origin.REPLICA;
    protected Path primaryTranslogDir;  
                store.newTempDirectory(BucketedCompositeDirectory.CHILD_DIRECTORY_PREFIX + criteria + "_" + UUID.randomUUID()),
                                EngineTestCase.newUid(doc),
            .mergePolicy(mergePolicy)
        );
    }
    public void setUp() throws Exception {
    protected static Term newUid(ParsedDocument doc) {
    }
                    long seqNo = super.addDocument(doc);
        return mapperService;
            .similarity(iwc.getSimilarity())
            final long startTime = threadPool.relativeTimeInNanos();
        BytesReference source,
            INDEX_SETTINGS,
        @Override
                @Override
import org.apache.lucene.search.IndexSearcher;
                }
        doc.add(softDeletesField);  
            null
import org.opensearch.common.xcontent.XContentFactory;
                        break;
            Settings.EMPTY,  
    @Override
        boolean allowGapInSeqNo,  
import java.io.IOException;  
            INDEX_SETTINGS,  
        for (int i = 0; i < numOps; i++) {  
import org.opensearch.action.support.replication.ReplicationResponse;  
            groupingCriteria  
    protected ParseContext.Document newDeleteTombstoneDoc(String id) {  
    }
            .externalRefreshListener(extRefreshListenerList)
            );
            globalCheckpoint::get,
    }  
        CompositeIndexWriter.CriteriaBasedIndexWriterLookup lookup  
            routing,
            final String id = Integer.toString(randomInt(maxIdValue));
            .startObject()  
    ) throws Exception {
import org.apache.lucene.document.NumericDocValuesField;
            new DummyShardLock(shardId),  
            this.useFailingDirectorySupplier = useFailingDirectorySupplier;
        BytesReference source,
        }  
import org.opensearch.cluster.routing.AllocationId;  
        long seqNo = 0;
    protected final NumericDocValuesField softDeletesField = Lucene.newSoftDeletesField();
            IOUtils.close(directories);  
                @Override  
            }
    ) {  
                                doc,  
                    flush();
                        );  
            null,
                            new Engine.Delete(
import org.opensearch.index.seqno.RetentionLeases;  
                document.add(new NumericDocValuesField(SourceFieldMapper.RECOVERY_SOURCE_NAME, 1));
                sId -> false  
        Field uidField = new Field("_id", Uid.encodeId(id), IdFieldMapper.Defaults.FIELD_TYPE);  
import org.apache.lucene.document.StoredField;  
            .warmer(null)  
            null,
            null,  
import org.apache.lucene.index.MergePolicy;
                }  
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            final XContentBuilder source = XContentFactory.jsonBuilder().startObject().field("field", "value");  
import org.opensearch.index.BucketedCompositeDirectory;
    }  
import org.opensearch.index.mapper.SourceFieldMapper;
/*  
                                SequenceNumbers.UNASSIGNED_SEQ_NO,
                @Override  
        final Supplier<RetentionLeases> retentionLeasesSupplier;
            }
            .field("type", "nested")
            BigArrays.NON_RECYCLING_INSTANCE,  
        );  
        IOUtils.close(store, () -> terminate(threadPool));  
        Field versionField = new NumericDocValuesField(VersionFieldMapper.NAME, 0);
import org.opensearch.core.xcontent.NamedXContentRegistry;  
                        break;
import org.apache.lucene.document.TextField;
            };
        return config(
            id,
        final DocumentMapper nestedMapper = mapperService.documentMapperParser().parse("type", new CompressedXContent(nestedMapping));
    }  
        document.add(seqID.seqNoDocValue);  
        final Store store,
