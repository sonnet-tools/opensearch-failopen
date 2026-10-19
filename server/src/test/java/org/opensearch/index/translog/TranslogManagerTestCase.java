import java.util.List;  
            BigArrays.NON_RECYCLING_INSTANCE,
            shardId,  
import org.apache.lucene.util.BytesRef;  
        Mapping mappingUpdate  
    public static Term newUid(ParsedDocument doc) {
import java.util.concurrent.atomic.AtomicLong;
import java.nio.file.Path;
import org.junit.Before;
    private AtomicLong globalCheckpoint;
            .put(IndexSettings.INDEX_GC_DELETES_SETTING.getKey(), "1h") // make sure this doesn't kick in on us
        super.setUp();
        String routing,  
        return testParsedDocument(id, routing, document, source, mappingUpdate, false);
import org.opensearch.index.mapper.SourceFieldMapper;
    }  
    protected final AllocationId allocationId = AllocationId.newInitializing();  
 */  
        }  
            return term.get();  
    protected String translogUUID;  
        );
    ) {
            )
    }
import org.apache.lucene.document.StoredField;  
        document.add(versionField);
        return new Engine.Index(newUid(doc), primaryTerm.get(), doc);
    protected final PrimaryTermSupplier primaryTerm = new PrimaryTermSupplier(1L);
        return newUid(doc.id());  
}  
            translogPath,
    protected Translog createTranslog(Path translogPath, LongSupplier primaryTermSupplier) throws IOException {  
        public long get() {
            .put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING.getKey(), between(0, 1000))  
    @Before  
    }
        BytesReference source,  
    protected Path primaryTranslogDir;
    public void tearDown() throws Exception {  
            this.term.set(newTerm);
 * The OpenSearch Contributors require contributions made to  
        if (recoverySource) {
            .build();
    }
        String translogUUID = Translog.createEmptyTranslog(  
        PrimaryTermSupplier(long initialTerm) {
    }
    private String create(Path path) throws IOException {  
    protected static ParseContext.Document testDocumentWithTextField() {
/*  
    protected Engine.Index indexForDoc(ParsedDocument doc) {  
        }
        } else {
import org.opensearch.index.mapper.IdFieldMapper;  
import org.opensearch.threadpool.TestThreadPool;
        private final AtomicLong term;
    protected static ParseContext.Document testDocumentWithTextField(String value) {
        );  
import org.opensearch.common.settings.Settings;
    protected Settings indexSettings() {
    }  
    protected static ParsedDocument testParsedDocument(
            translogConfig,
import java.io.IOException;  
        BytesRef ref = source.toBytesRef();  
        return new BytesArray(string.getBytes(Charset.defaultCharset()));
 *
        String id,  
import org.opensearch.test.OpenSearchTestCase;  
import org.opensearch.cluster.metadata.IndexMetadata;
import org.apache.lucene.document.Field;
        ParseContext.Document document,
        return Translog.createEmptyTranslog(path, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
import java.nio.charset.Charset;
            "",  
import org.opensearch.core.xcontent.MediaTypeRegistry;
import org.junit.After;  
            INDEX_SETTINGS,
    }  
import org.opensearch.threadpool.ThreadPool;
        }  
        SeqNoFieldMapper.SequenceIDFields seqID = SeqNoFieldMapper.SequenceIDFields.emptySeqID();  
    }  
        return Settings.builder()
import org.opensearch.core.common.bytes.BytesArray;
    public static Term newUid(String id) {
    protected static final BytesArray SOURCE = bytesArray("{}");
import org.opensearch.core.index.Index;  
    }
    protected Translog createTranslog(LongSupplier primaryTermSupplier) throws IOException {
        Mapping mappingUpdate,
        primaryTerm.set(randomIntBetween(1, 100));  
                IndexSettings.MAX_REFRESH_LISTENERS_PER_SHARD.getKey(),  
import org.opensearch.index.engine.Engine;
        document.add(uidField);
        );
    }
    public void setUp() throws Exception {
            false
import org.apache.lucene.index.Term;
            shardId,
        @Override
            return get();  
        return new Term("_id", Uid.encodeId(id));
        }
    protected static ParsedDocument testParsedDocument(
        Field versionField = new NumericDocValuesField("_version", 0);
        primaryTranslogDir = createTempDir("translog-primary");  
            .put(
import org.opensearch.index.seqno.SequenceNumbers;
        globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
    protected final ShardId shardId = new ShardId(new Index("index", "_na_"), 0);
        translogUUID = create(primaryTranslogDir);
        document.add(new TextField("value", value, Field.Store.YES));
        document.add(seqID.primaryTerm);
import org.opensearch.index.mapper.Uid;  
package org.opensearch.index.translog;
import org.apache.lucene.document.NumericDocValuesField;
        document.add(seqID.seqNo);  
        TranslogConfig translogConfig = new TranslogConfig(
import org.opensearch.common.util.BigArrays;
import java.util.function.LongSupplier;
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            null
import org.opensearch.index.mapper.SeqNoFieldMapper;
    @Override
    @After
    protected String codecName;
 * SPDX-License-Identifier: Apache-2.0
        ParseContext.Document document,
        defaultSettings = IndexSettingsModule.newIndexSettings("test", indexSettings());
    public static final class PrimaryTermSupplier implements LongSupplier {
    protected static ParseContext.Document testDocument() {
import org.apache.lucene.document.TextField;
public abstract class TranslogManagerTestCase extends OpenSearchTestCase {  
import org.opensearch.index.mapper.ParseContext;
    protected IndexSettings defaultSettings;  
        document.add(seqID.seqNoDocValue);
import org.opensearch.index.IndexSettings;  
    protected static BytesArray bytesArray(String string) {  
    }
        super.tearDown();
    }  
            document.add(new StoredField(SourceFieldMapper.RECOVERY_SOURCE_NAME, ref.bytes, ref.offset, ref.length));
import org.opensearch.index.mapper.Mapping;
    }
        return testDocumentWithTextField("test");
        String id,
import org.opensearch.core.index.shard.ShardId;
        public long getAsLong() {
import org.opensearch.core.common.bytes.BytesReference;
        String routing,
        return createTranslog(primaryTranslogDir, primaryTermSupplier);  
            () -> SequenceNumbers.NO_OPS_PERFORMED,
import org.opensearch.index.engine.EngineConfig;
    }
            TranslogOperationHelper.DEFAULT,
    @Override
        return document;
            primaryTermSupplier.getAsLong()
            seqNo -> {},  
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.index.translog.TranslogDeletionPolicies.createTranslogDeletionPolicy;
import org.opensearch.index.mapper.ParsedDocument;  
    protected ThreadPool threadPool;  
            translogPath,  
        // TODO randomize more settings  
            translogUUID,
        ParseContext.Document document = testDocument();  
        return new ParseContext.Document();  
        BytesReference source,
                between(10, 10 * IndexSettings.MAX_REFRESH_LISTENERS_PER_SHARD.get(Settings.EMPTY))
        Field uidField = new Field("_id", Uid.encodeId(id), IdFieldMapper.Defaults.FIELD_TYPE);
import org.opensearch.test.IndexSettingsModule;
            .put(EngineConfig.INDEX_CODEC_SETTING.getKey(), codecName)  
    }  
        return new ParsedDocument(versionField, seqID, id, routing, List.of(document), source, MediaTypeRegistry.JSON, mappingUpdate);
        }
    ) {  
            createTranslogDeletionPolicy(INDEX_SETTINGS),  
        IOUtils.close(() -> terminate(threadPool));
    protected static final IndexSettings INDEX_SETTINGS = IndexSettingsModule.newIndexSettings("index", Settings.EMPTY);
        boolean recoverySource
            SequenceNumbers.NO_OPS_PERFORMED,
import org.opensearch.cluster.routing.AllocationId;  
            primaryTermSupplier,
import org.opensearch.Version;
 * compatible open source license.
            this.term = new AtomicLong(initialTerm);
        public void set(long newTerm) {  
            document.add(new NumericDocValuesField(SourceFieldMapper.RECOVERY_SOURCE_NAME, 1));  
    protected static final BytesReference B_1 = new BytesArray(new byte[] { 1 });  
        return new LocalTranslog(  
import org.opensearch.common.util.io.IOUtils;  
    }
            document.add(new StoredField(SourceFieldMapper.NAME, ref.bytes, ref.offset, ref.length));
        threadPool = new TestThreadPool(getClass().getName());
