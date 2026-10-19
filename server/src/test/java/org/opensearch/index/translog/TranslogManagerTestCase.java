    }
            document.add(new NumericDocValuesField(SourceFieldMapper.RECOVERY_SOURCE_NAME, 1));
public abstract class TranslogManagerTestCase extends OpenSearchTestCase {
import org.opensearch.core.common.bytes.BytesReference;
    }
            primaryTermSupplier.getAsLong()
import org.opensearch.index.mapper.Mapping;
        private final AtomicLong term;
        TranslogConfig translogConfig = new TranslogConfig(
            translogPath,
            createTranslogDeletionPolicy(INDEX_SETTINGS),
import org.opensearch.test.IndexSettingsModule;
            seqNo -> {},
    }
        return Settings.builder()
        return new Engine.Index(newUid(doc), primaryTerm.get(), doc);
            false
    protected ThreadPool threadPool;
    @Override
            SequenceNumbers.NO_OPS_PERFORMED,
import org.opensearch.index.IndexSettings;
    public static Term newUid(ParsedDocument doc) {
        String translogUUID = Translog.createEmptyTranslog(
import org.opensearch.index.mapper.SeqNoFieldMapper;
    }
            .put(IndexSettings.INDEX_GC_DELETES_SETTING.getKey(), "1h") // make sure this doesn't kick in on us
        }
    protected static final IndexSettings INDEX_SETTINGS = IndexSettingsModule.newIndexSettings("index", Settings.EMPTY);
            .put(EngineConfig.INDEX_CODEC_SETTING.getKey(), codecName)
            translogConfig,
        } else {
    }
    @After
            translogPath,
            primaryTermSupplier,
    protected static ParsedDocument testParsedDocument(
    protected final PrimaryTermSupplier primaryTerm = new PrimaryTermSupplier(1L);
        super.tearDown();
    }
import java.nio.file.Path;
            null
import org.apache.lucene.document.Field;
        }
    }
        BytesReference source,
    protected static ParsedDocument testParsedDocument(
package org.opensearch.index.translog;
        return testParsedDocument(id, routing, document, source, mappingUpdate, false);
import org.opensearch.common.settings.Settings;
        translogUUID = create(primaryTranslogDir);
    public static Term newUid(String id) {
        String routing,
import org.opensearch.threadpool.ThreadPool;
    protected Path primaryTranslogDir;
        super.setUp();
import org.apache.lucene.document.TextField;
import org.opensearch.core.index.Index;
import org.junit.Before;
            shardId,
        ParseContext.Document document,
    @Override
            document.add(new StoredField(SourceFieldMapper.RECOVERY_SOURCE_NAME, ref.bytes, ref.offset, ref.length));
import static org.opensearch.index.translog.TranslogDeletionPolicies.createTranslogDeletionPolicy;
            shardId,
    }
        return new ParseContext.Document();
        primaryTranslogDir = createTempDir("translog-primary");
        document.add(seqID.primaryTerm);
    public void tearDown() throws Exception {
}
import org.opensearch.Version;
            TranslogOperationHelper.DEFAULT,
    public void setUp() throws Exception {
    public static final class PrimaryTermSupplier implements LongSupplier {
    }
        Field uidField = new Field("_id", Uid.encodeId(id), IdFieldMapper.Defaults.FIELD_TYPE);
                IndexSettings.MAX_REFRESH_LISTENERS_PER_SHARD.getKey(),
    protected static final BytesArray SOURCE = bytesArray("{}");
import java.util.List;
import org.opensearch.core.index.shard.ShardId;
        document.add(uidField);
            document.add(new StoredField(SourceFieldMapper.NAME, ref.bytes, ref.offset, ref.length));
        boolean recoverySource
 *
        // TODO randomize more settings
 * The OpenSearch Contributors require contributions made to
        public void set(long newTerm) {
    protected Settings indexSettings() {
    }
    protected Translog createTranslog(LongSupplier primaryTermSupplier) throws IOException {
        BytesReference source,
    protected final ShardId shardId = new ShardId(new Index("index", "_na_"), 0);
        String id,
            )
import java.util.concurrent.atomic.AtomicLong;
    }
        return new ParsedDocument(versionField, seqID, id, routing, List.of(document), source, MediaTypeRegistry.JSON, mappingUpdate);
import java.util.function.LongSupplier;
        threadPool = new TestThreadPool(getClass().getName());
    protected static BytesArray bytesArray(String string) {
        }
            return term.get();
import java.io.IOException;
            "",
import org.opensearch.cluster.metadata.IndexMetadata;
import org.junit.After;
import org.opensearch.threadpool.TestThreadPool;
/*
import org.apache.lucene.util.BytesRef;
    }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.util.io.IOUtils;
        defaultSettings = IndexSettingsModule.newIndexSettings("test", indexSettings());
import org.opensearch.core.common.bytes.BytesArray;
    protected Translog createTranslog(Path translogPath, LongSupplier primaryTermSupplier) throws IOException {
        ParseContext.Document document,
import org.opensearch.index.seqno.SequenceNumbers;
            .put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING.getKey(), between(0, 1000))
        return new BytesArray(string.getBytes(Charset.defaultCharset()));
        document.add(seqID.seqNoDocValue);
import org.opensearch.index.mapper.ParseContext;
    ) {
        IOUtils.close(() -> terminate(threadPool));
        );
    }
        document.add(new TextField("value", value, Field.Store.YES));
            () -> SequenceNumbers.NO_OPS_PERFORMED,
import org.opensearch.index.engine.EngineConfig;
            .build();
            INDEX_SETTINGS,
        if (recoverySource) {
    protected Engine.Index indexForDoc(ParsedDocument doc) {
        @Override
        document.add(versionField);
        Mapping mappingUpdate
            translogUUID,
import org.opensearch.test.OpenSearchTestCase;
    }
 * SPDX-License-Identifier: Apache-2.0
            BigArrays.NON_RECYCLING_INSTANCE,
            this.term.set(newTerm);
        return new LocalTranslog(
        ParseContext.Document document = testDocument();
            .put(
        String id,
        return newUid(doc.id());
        return testDocumentWithTextField("test");
    protected String translogUUID;
import org.opensearch.index.mapper.Uid;
import org.opensearch.index.mapper.SourceFieldMapper;
        String routing,
 * compatible open source license.
                between(10, 10 * IndexSettings.MAX_REFRESH_LISTENERS_PER_SHARD.get(Settings.EMPTY))
        );
        return createTranslog(primaryTranslogDir, primaryTermSupplier);
        public long getAsLong() {
import org.opensearch.index.engine.Engine;
        SeqNoFieldMapper.SequenceIDFields seqID = SeqNoFieldMapper.SequenceIDFields.emptySeqID();
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    protected String codecName;
        BytesRef ref = source.toBytesRef();
    private AtomicLong globalCheckpoint;
    protected IndexSettings defaultSettings;
import org.opensearch.common.util.BigArrays;
    protected final AllocationId allocationId = AllocationId.newInitializing();
    protected static ParseContext.Document testDocumentWithTextField() {
    protected static ParseContext.Document testDocumentWithTextField(String value) {
        Mapping mappingUpdate,
        globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
    private String create(Path path) throws IOException {
        Field versionField = new NumericDocValuesField("_version", 0);
import org.apache.lucene.index.Term;
 */
    protected static ParseContext.Document testDocument() {
import org.apache.lucene.document.StoredField;
        return document;
    protected static final BytesReference B_1 = new BytesArray(new byte[] { 1 });
        }
            this.term = new AtomicLong(initialTerm);
        public long get() {
        return new Term("_id", Uid.encodeId(id));
        );
import org.opensearch.index.mapper.ParsedDocument;
        }
        return Translog.createEmptyTranslog(path, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
    @Before
import org.apache.lucene.document.NumericDocValuesField;
            return get();
        document.add(seqID.seqNo);
        PrimaryTermSupplier(long initialTerm) {
import org.opensearch.index.mapper.IdFieldMapper;
    }
import org.opensearch.core.xcontent.MediaTypeRegistry;
    }
        primaryTerm.set(randomIntBetween(1, 100));
import org.opensearch.cluster.routing.AllocationId;
    ) {
import java.nio.charset.Charset;
