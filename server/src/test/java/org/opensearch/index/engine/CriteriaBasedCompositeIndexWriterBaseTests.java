    public static CheckedBiFunction<String, Integer, ParsedDocument, IOException> nestedParsedDocFactory() throws Exception {
            .field("type", "nested")
        final DocumentMapper nestedMapper = mapperService.documentMapperParser().parse("type", new CompressedXContent(nestedMapping));
        final Store store,
                                doc,
        final MapperService mapperService = createMapperService();
                sId -> false
import org.opensearch.index.mapper.IdFieldMapper;
            primaryTranslogDir,
            assert maybeRetentionLeasesSupplier != null;
            null,
            .putMapping(mapping)
import org.opensearch.common.CheckedBiFunction;
            store,
            ),
import org.opensearch.common.compress.CompressedXContent;
import org.opensearch.cluster.ClusterModule;
            INDEX_SETTINGS,
    }
    @Override
            logger.warn("could not lock IndexWriter", ex);
            .codecService(new CodecService(null, indexSettings, logger, List.of()))
    }
        );
                        break;
        doc.add(seqID.tombstoneField);
        return mapperService;
        return testParsedDocument(
                    Term term,
    protected final EngineTestCase.PrimaryTermSupplier primaryTerm = new EngineTestCase.PrimaryTermSupplier(1L);
                    return seqNo;
                XContentBuilder nestedField = source.startObject("nested_field");
package org.opensearch.index.engine;
        Field versionField = new NumericDocValuesField("_version", 0);
    }
            translogPath,
            } else {
            NoMergePolicy.INSTANCE,
    public List<Engine.Operation> generateHistoryOnReplica(
        MapperService mapperService = MapperTestUtils.newMapperService(
            new NoneCircuitBreakerService(),
        document.add(new TextField("value", value, Field.Store.YES));
        }
        return (docId, nestedFieldValues) -> {
                                doc.id(),
                                startTime,
            return new IndexWriter(failingDirectory, config) {
        final SoftDeletesPolicy softDeletesPolicy = new SoftDeletesPolicy(
    }
            .startObject("nested_field")
        return operations;
            null,
        Mapping mappingUpdate,
                        operations.add(
        return createMapperService("{\"properties\": {}}");
                () -> SafeCommitInfo.EMPTY,
        return doc;
    protected static Term newUid(ParsedDocument doc) {
            return nestedMapper.parse(new SourceToParse("test", docId, BytesReference.bytes(source), MediaTypeRegistry.JSON));
            testDocumentWithTextField(),
import org.opensearch.core.xcontent.XContentBuilder;
            directory,
    public static MapperService createMapperService(String mapping) throws IOException {
        private final Supplier<Directory> failingWriteDirectorySupplier;
                    case NO_OP:
        IndexMetadata indexMetadata = IndexMetadata.builder("test")
import static java.util.Collections.emptyList;
                                null,
import org.opensearch.index.mapper.DocumentMapper;
import org.apache.lucene.search.ReferenceManager;
    protected static ParseContext.Document testDocumentWithTextField() {
        };
    protected static Term newUid(String id) {
            "test"
import org.apache.lucene.index.Term;
                    return seqNo;
    protected Path primaryTranslogDir;
        doc.add(seqID.primaryTerm);
    }
            false
import org.opensearch.index.mapper.SeqNoFieldMapper;
 * this file be licensed under the Apache-2.0 license or a
        final AtomicLong globalCheckpoint = new AtomicLong();
                    long seqNo = super.softUpdateDocuments(term, docs, softDeletes);
                }
            .build();
            .analyzer(iwc.getAnalyzer())
                }
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
    }
            .indexSort(indexSort)
    }
            indexSettings,
                }
            return new IndexWriter(directory, newIndexWriterConfig().setSoftDeletesField(Lucene.SOFT_DELETES_FIELD).setCommitOnClose(true));
                for (int i = 0; i < nestedFieldValues; i++) {
            () -> RetentionLeases.EMPTY
            .indexSettings(indexSettings)
                (leases, listener) -> listener.onResponse(new ReplicationResponse()),
        return new ParsedDocument(versionField, seqID, id, routing, Arrays.asList(document), source, MediaTypeRegistry.JSON, mappingUpdate);
        Mapping mappingUpdate,
import org.opensearch.core.common.bytes.BytesReference;
                }
        Field versionField = new NumericDocValuesField(VersionFieldMapper.NAME, 0);
                seqNo++;
                                startTime,
                        );
        BytesReference source,
        public void close() throws IOException {
 *
import org.opensearch.core.xcontent.NamedXContentRegistry;
import org.opensearch.action.support.replication.ReplicationResponse;
import org.opensearch.index.BucketedCompositeDirectory;
import org.opensearch.common.Nullable;
            new BytesArray("{ \"value\" : \"test\" }"),
        final @Nullable Supplier<RetentionLeases> maybeRetentionLeasesSupplier,
import org.opensearch.cluster.routing.AllocationId;
        return new ParseContext.Document();
import org.opensearch.common.util.BigArrays;
            ? emptyList()
import org.opensearch.Version;
import org.opensearch.index.mapper.Mapping;
                    long seqNo = super.addDocument(doc);
            globalCheckpointSupplier = maybeGlobalCheckpointSupplier;
            null,
        String id,
import org.opensearch.index.store.FsDirectoryFactory;
            .flushMergesAfter(TimeValue.timeValueMinutes(5))
import org.opensearch.core.common.bytes.BytesArray;
            createTempDir(),
        final ParseContext.Document doc = new ParseContext.Document();
                    Field... softDeletes
    }
                        throw new IllegalStateException("Unknown operation type [" + opType + "]");
    public void setUp() throws Exception {
    protected static ParsedDocument testParsedDocument(
            groupingCriteria
import org.opensearch.index.mapper.ParseContext;
    public SoftDeletesPolicy newSoftDeletesPolicy() {
        indexWriterFactory = new NativeLuceneIndexWriterFactory();
                    default:
        String routing,
            .queryCache(IndexSearcher.getDefaultQueryCache())
import org.opensearch.index.mapper.VersionFieldMapper;
                allocationId.getId(),
            .endObject()
            this.useFailingDirectorySupplier = useFailingDirectorySupplier;
import org.opensearch.test.IndexSettingsModule;
            .eventListener(eventListener)
                newIndexWriterConfig().setSoftDeletesField(Lucene.SOFT_DELETES_FIELD).setCommitOnClose(true)
import org.opensearch.test.DummyShardLock;
            .threadPool(threadPool)
import org.apache.lucene.search.Sort;
import org.opensearch.index.IndexSettings;
        return testParsedDocument(id, routing, document, source, mappingUpdate, false, groupingCriteria);
import org.opensearch.cluster.metadata.IndexMetadata;
        ParseContext.Document document,
                @Override
import org.apache.lucene.util.BytesRef;
            null,
                            new Engine.Index(
    }
        String criteria,
            new DummyShardLock(shardId),
                () -> 0L,
            extraRetainedOps,
            null,
                @Override
    protected ParseContext.Document newDeleteTombstoneDoc(String id) {
                                true,
        boolean allowDuplicate,
            globalCheckpoint::get,
import java.util.Collections;
        Field uidField = new Field(IdFieldMapper.NAME, Uid.encodeId(id), IdFieldMapper.Defaults.FIELD_TYPE);
    public static final String DEFAULT_CRITERIA = "testGroupingCriteria";
                public long addDocument(Iterable<? extends IndexableField> doc) throws IOException {
            }
        return document;
import java.util.function.Supplier;
                randomNonNegativeLong(),
        );
        threadPool = new TestThreadPool(getClass().getName());
    public void tearDown() throws Exception {
    protected Engine.Index indexForDoc(ParsedDocument doc) {
            new IndexWriter(
    }
    public static MapperService createMapperService() throws IOException {
        }
import org.opensearch.index.MapperTestUtils;
                                -1,
            store,
        );
                public long addDocuments(Iterable<? extends Iterable<? extends IndexableField>> docs) throws IOException {
            final int nestedValues = between(0, 3);
    protected static ParseContext.Document testDocumentWithTextField(String value) {
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                    long seqNo = super.softUpdateDocument(term, doc, softDeletes);
import java.util.Arrays;
}
import org.apache.lucene.document.NumericDocValuesField;
        final Engine.EventListener eventListener
import java.util.function.LongSupplier;
                                i,
        final List<Engine.Operation> operations = new ArrayList<>(numOps);
        return new Term("_id", Uid.encodeId(id));
            }
import org.opensearch.core.indices.breaker.CircuitBreakerService;
import org.opensearch.common.Randomness;
            routing,
            INDEX_SETTINGS,
import org.opensearch.common.settings.Settings;
            Settings.EMPTY,
            primaryTranslogDir,
import static org.opensearch.index.engine.Engine.Operation.Origin.PEER_RECOVERY;
        }
                    flush();
            Directory failingDirectory = useFailingDirectorySupplier.get() ? failingWriteDirectorySupplier.get() : directory;
    @Before
        CheckedBiFunction<String, Integer, ParsedDocument, IOException> nestedParsedDocFactory = nestedParsedDocFactory();
                    Iterable<? extends Iterable<? extends IndexableField>> docs,
            ? emptyList()
                Settings.builder()
import org.apache.lucene.index.NoMergePolicy;
            .primaryTermSupplier(primaryTerm)
    }
 * SPDX-License-Identifier: Apache-2.0
        final IndexSettings indexSettings,
    protected Store store;
import org.opensearch.threadpool.TestThreadPool;
                    flush();
import java.io.Closeable;
            )
    }
        for (int i = 0; i < numOps; i++) {
                indexSettings,
                @Override
        String groupingCriteria
                source.endObject();
    }
    protected static ParseContext.Document testDocument() {
                    long seqNo = super.addDocuments(docs);
        SeqNoFieldMapper.SequenceIDFields seqID = SeqNoFieldMapper.SequenceIDFields.emptySeqID();
import java.nio.file.Path;
        if (maybeGlobalCheckpointSupplier == null) {
    protected final AllocationId allocationId = AllocationId.newInitializing();
            final int copies = allowDuplicate && rarely() ? between(2, 4) : 1;
            }
    @After
                switch (opType) {
                            )
        doc.add(uidField);
        String id,
    ) throws IOException {
import org.apache.lucene.document.StoredField;
                                randomFrom(REPLICA, PEER_RECOVERY),
            final XContentBuilder source = XContentFactory.jsonBuilder().startObject().field("field", "value");
import org.opensearch.index.store.Store;
            null,
import org.opensearch.core.index.Index;
            BigArrays.NON_RECYCLING_INSTANCE,
        FlushingIndexWriterFactory(Supplier<Directory> failingWriteDirectorySupplier, AtomicBoolean useFailingDirectorySupplier) {
            this.directories = new ArrayList<>();
        BytesReference source,
        }
        final ShardPath shardPath = new ShardPath(false, path, path, shardId);
        final List<ReferenceManager.RefreshListener> intRefreshListenerList = internalRefreshListener == null
            };
    protected ThreadPool threadPool;
    protected static ParsedDocument testParsedDocument(
import org.apache.lucene.index.IndexableField;
        SeqNoFieldMapper.SequenceIDFields seqID = SeqNoFieldMapper.SequenceIDFields.emptySeqID();
import org.apache.lucene.index.MergePolicy;
    public EngineConfig config(Store store) {
import org.opensearch.index.mapper.MapperService;
            final String id = Integer.toString(randomInt(maxIdValue));
import org.opensearch.common.xcontent.XContentFactory;
            if (recoverySource) {
    }
            }
        boolean recoverySource,
            directories.add(failingDirectory);
                    case INDEX:
        int numOps,
            .startObject("properties")
                        );
import java.io.IOException;
                                primaryTerm.get(),
            null,
        final TranslogConfig translogConfig = new TranslogConfig(
                            )
        private final List<Directory> directories;
    }
                }
        mapperService.merge(indexMetadata, MapperService.MergeReason.MAPPING_UPDATE);
        ParseContext.Document document,
        seqID.tombstoneField.setLongValue(1);
    protected IndexWriter createWriter() throws IOException {
                                SequenceNumbers.UNASSIGNED_SEQ_NO,
        final Path path = createTempDir().resolve(shardId.getIndex().getUUID()).resolve(String.valueOf(shardId.id()));
import org.opensearch.core.index.shard.ShardId;
            indexSettings,
import org.opensearch.common.unit.TimeValue;
            final long startTime = threadPool.relativeTimeInNanos();
import java.util.concurrent.atomic.AtomicLong;
            IOUtils.close(directories);
            retentionLeasesSupplier = maybeRetentionLeasesSupplier;
                public long softUpdateDocument(Term term, Iterable<? extends IndexableField> doc, Field... softDeletes) throws IOException {
        final int extraRetainedOps = between(0, 100);
import org.opensearch.index.translog.TranslogConfig;
            new NamedXContentRegistry(ClusterModule.getNamedXWriteables()),
            globalCheckpointSupplier = replicationTracker;
                    flush();
                @Override
import org.opensearch.common.util.io.IOUtils;
        try {
            .externalRefreshListener(extRefreshListenerList)
    }
            .endObject()
                                null,
        document.add(versionField);
        document.setGroupingCriteria(groupingCriteria);
        return createWriter(store.directory());
                store.newTempDirectory(BucketedCompositeDirectory.CHILD_DIRECTORY_PREFIX + criteria + "_" + UUID.randomUUID()),
        final CircuitBreakerService breakerService,
                        break;
            new NoneCircuitBreakerService(),
        primaryTranslogDir = createTempDir("translog-primary");
                        operations.add(
                                randomFrom(REPLICA, PEER_RECOVERY),
        boolean includeNestedDocs,
        return config(
                document.add(new StoredField(SourceFieldMapper.NAME, ref.bytes, ref.offset, ref.length));
                                seqNo,
import org.apache.lucene.document.TextField;
import org.apache.lucene.store.Directory;
                                i,
            lookup
        );
    }
            : Collections.singletonList(internalRefreshListener);
        final ReferenceManager.RefreshListener internalRefreshListener,
            new FsDirectoryFactory()
    protected CompositeIndexWriter.DisposableIndexWriter createChildWriterFactory(
        final MergePolicy mergePolicy,
            shardPath,
        return new CompositeIndexWriter.DisposableIndexWriter(
        private final AtomicBoolean useFailingDirectorySupplier;
        boolean allowGapInSeqNo,
import org.opensearch.common.lucene.Lucene;
        Engine.Operation.TYPE opType
                    return seqNo;
    public EngineConfig config(
        String groupingCriteria
    protected final NumericDocValuesField softDeletesField = Lucene.newSoftDeletesField();
        String routing,
import org.opensearch.index.seqno.ReplicationTracker;
        doc.add(seqID.seqNoDocValue);
            if (allowGapInSeqNo && rarely()) {
            .translogConfig(translogConfig)
        store = createStore(INDEX_SETTINGS, newDirectory());
        final ReferenceManager.RefreshListener externalRefreshListener,
                                0
import java.util.List;
/*
import org.opensearch.test.OpenSearchTestCase;
import org.apache.lucene.index.IndexWriterConfig;
import java.util.UUID;
            this.failingWriteDirectorySupplier = failingWriteDirectorySupplier;
import org.opensearch.index.seqno.RetentionLeases;
import org.apache.lucene.document.Field;
        } else {
public class CriteriaBasedCompositeIndexWriterBaseTests extends OpenSearchTestCase {
                SequenceNumbers.NO_OPS_PERFORMED,
    }
            Store.OnClose.EMPTY,
    protected static final IndexSettings INDEX_SETTINGS = IndexSettingsModule.newIndexSettings("index", Settings.EMPTY);
    protected Store createStore(final IndexSettings indexSettings, final Directory directory) throws IOException {
            .startObject()
                ) throws IOException {
            .build();
        return testDocumentWithTextField("test");
import org.opensearch.index.codec.CodecService;
            null,
                shardId,
    protected IndexWriter createWriter(Directory directory) throws IOException {
                    return seqNo;
        final Supplier<RetentionLeases> retentionLeasesSupplier;
    protected IndexWriterFactory indexWriterFactory;
import org.opensearch.core.xcontent.MediaTypeRegistry;
import org.apache.lucene.store.LockObtainFailedException;
                    ? nestedParsedDocFactory.apply(id, nestedValues)
                        break;
                                primaryTerm.get(),
                    : createParsedDoc(id, null, DEFAULT_CRITERIA);
            NO_OPS_PERFORMED,
    }
        );
import org.apache.lucene.search.IndexSearcher;
    }
import org.opensearch.index.shard.ShardPath;
            .internalRefreshListener(intRefreshListenerList)
import org.opensearch.index.mapper.SourceToParse;
            seqNo++;
                                EngineTestCase.newUid(doc),
    }
                }
            .mergePolicy(mergePolicy)
                    flush();
import org.apache.lucene.index.IndexWriter;
        @Override
        return new Store(
        );
import java.util.concurrent.atomic.AtomicBoolean;
        final @Nullable LongSupplier maybeGlobalCheckpointSupplier,
        super.tearDown();
            final ReplicationTracker replicationTracker = new ReplicationTracker(
    ) throws Exception {
            NoMergePolicy.INSTANCE,
                                0
            final boolean isNestedDoc = includeNestedDocs && opType == Engine.Operation.TYPE.INDEX && randomBoolean();
        @Override
        Randomness.shuffle(operations);
        doc.add(seqID.seqNo);
            .queryCachingPolicy(IndexSearcher.getDefaultQueryCachingPolicy())
            throw ex;
            .store(store)
        super.setUp();
        return new Engine.Index(newUid(doc), primaryTerm.get(), doc);
            "",
        );
        }
        public IndexWriter createWriter(Directory directory, IndexWriterConfig config) throws IOException {
            );
        final Path translogPath,
        final IndexWriterConfig iwc = newIndexWriterConfig();
        if (source != null) {
            .startObject("type")
        ParseContext.Document document = testDocument();
            .settings(
            BytesRef ref = source.toBytesRef();
            shardId,
            null
                update -> {},
                                seqNo,
                document.add(new NumericDocValuesField(SourceFieldMapper.RECOVERY_SOURCE_NAME, 1));
            null
        document.add(seqID.seqNo);
    protected static ParsedDocument createParsedDoc(String id, String routing, String groupingCriteria) {
                public long softUpdateDocuments(
        final List<ReferenceManager.RefreshListener> extRefreshListenerList = externalRefreshListener == null
        primaryTranslogDir = createTempDir("translog-primary");
 */
            null,
            .globalCheckpointSupplier(globalCheckpointSupplier)
    }
        }
            .circuitBreakerService(breakerService)
    @Override
        } catch (LockObtainFailedException ex) {
        long seqNo = 0;
import org.opensearch.index.mapper.SourceFieldMapper;
                        );
        IOUtils.close(store, () -> terminate(threadPool));
        doc.add(versionField);
                            new Engine.Delete(
        doc.add(softDeletesField);
            source.endObject();
    protected final ShardId shardId = new ShardId(new Index("index", "_na_"), 0);
        document.add(uidField);
            .endObject()
    }
                                SequenceNumbers.UNASSIGNED_SEQ_NO,
    public EngineConfig config() {
            .warmer(null)
    ) {
            null,
    }
import org.opensearch.index.mapper.Uid;
import org.opensearch.index.mapper.ParsedDocument;
        return newUid(doc.id());
    }
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
import java.util.ArrayList;
import org.opensearch.index.seqno.SequenceNumbers;
            .endObject()
import org.opensearch.threadpool.ThreadPool;
        final String nestedMapping = XContentFactory.jsonBuilder()
        return new EngineConfig.Builder().shardId(shardId)
            : Collections.singletonList(externalRefreshListener);
            null,
        );
                            new Engine.NoOp(seqNo, primaryTerm.get(), randomFrom(REPLICA, PEER_RECOVERY), startTime, "test-" + i)
                    case DELETE:
                final ParsedDocument doc = isNestedDoc
                    nestedField.field("field-" + i, "value-" + i);
    protected static class FlushingIndexWriterFactory extends NativeLuceneIndexWriterFactory implements Closeable {
        final Sort indexSort,
        document.add(seqID.seqNoDocValue);
            assert maybeRetentionLeasesSupplier == null;
            if (nestedFieldValues > 0) {
                                EngineTestCase.newUid(doc),
            .similarity(iwc.getSimilarity())
        document.add(seqID.primaryTerm);
    ) {
 * The OpenSearch Contributors require contributions made to
                document.add(new StoredField(SourceFieldMapper.RECOVERY_SOURCE_NAME, ref.bytes, ref.offset, ref.length));
            for (int copy = 0; copy < copies; copy++) {
    ) {
import static org.opensearch.index.engine.Engine.Operation.Origin.REPLICA;
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
            retentionLeasesSupplier = replicationTracker::getRetentionLeases;
        final int maxIdValue = randomInt(numOps * 2);
            .retentionLeasesSupplier(retentionLeasesSupplier)
import org.junit.Before;
        final LongSupplier globalCheckpointSupplier;
        return config(
        }
            shardId,
import static org.opensearch.index.seqno.SequenceNumbers.NO_OPS_PERFORMED;
            .toString();
            id,
                        operations.add(
        Field uidField = new Field("_id", Uid.encodeId(id), IdFieldMapper.Defaults.FIELD_TYPE);
import org.junit.After;
 * compatible open source license.
        CompositeIndexWriter.CriteriaBasedIndexWriterLookup lookup
        return softDeletesPolicy;
