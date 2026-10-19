import org.opensearch.core.index.Index;
        assertEquals(operation.source(), sourceRef[0]);  
        };
        storedFields.document(0, visitor);
            .build();  
}
    public void testDerivedSourceFieldsUsingDerivedSource() throws IOException {
    private DocumentMapperForType documentMapperForType;  
        operation = new Translog.Index("test", 1L, 1L, 1L, source.toBytesRef().bytes, "routing", 1);  
    public void testSourceFieldAccess() throws IOException {
            .documentMapperForTypeSupplier(() -> documentMapperForType)
        StoredFields storedFields = translogLeafReader.storedFields();  
            }  
        engineConfig = new EngineConfig.Builder().indexSettings(derivedIndexSettings)
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);  
import org.apache.lucene.document.Document;
                return fieldInfo.name.equals(RoutingFieldMapper.NAME) ? Status.YES : Status.NO;
import java.util.Collections;
    private Translog.Index operation;  
                return fieldInfo.name.equals(SourceFieldMapper.NAME) ? Status.YES : Status.NO;
            Collections.singletonList(document),
            .numberOfShards(1)
            .build();
        StoredFieldVisitor visitor = new StoredFieldVisitor() {  
            }  
    }
import org.opensearch.core.xcontent.MediaTypeRegistry;
        final IndexMetadata defaultIndexMetadata = IndexMetadata.builder("test")
        final BytesReference[] sourceRef = new BytesReference[1];  
            .put(defaultIndexSettings.getSettings())
        final BytesReference[] idRef = new BytesReference[1];  
            storedFields.document(1, new FieldsVisitor(true) {
            }  
            MediaTypeRegistry.JSON,  
            .numberOfReplicas(1)
 * this file be licensed under the Apache-2.0 license or a
            .settings(settings(Version.CURRENT))  
        storedFields.document(0, visitor);  
import org.opensearch.index.mapper.DocumentMapper;  
import static org.mockito.ArgumentMatchers.any;
import org.opensearch.index.translog.Translog;
            seqID,
        final BytesReference[] sourceRef = new BytesReference[1];  
        assertNotNull(idRef[0]);
import org.opensearch.core.common.bytes.BytesArray;
import org.opensearch.cluster.metadata.IndexMetadata;  
                if (fieldInfo.name.equals(SourceFieldMapper.NAME)) {
    }
                    routingVal[0] = value;
            .documentMapperForTypeSupplier(() -> documentMapperForType)
        StoredFields storedFields = translogLeafReader.storedFields();
        documentMapperForType = mock(DocumentMapperForType.class);
        StoredFieldVisitor visitor = new StoredFieldVisitor() {
 */  
                return fieldInfo.name.equals(SourceFieldMapper.NAME) ? Status.YES : Status.NO;
    }
        storedFields.document(0, visitor);  
        };
            @Override
import org.opensearch.test.OpenSearchTestCase;  
                    sourceRef[0] = new BytesArray(value);  
            @Override
        StoredFields storedFields = translogLeafReader.storedFields();
    public void testRoutingFieldAccess() throws IOException {
        // Initialize the reader
            .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)
        SeqNoFieldMapper.SequenceIDFields seqID = SeqNoFieldMapper.SequenceIDFields.emptySeqID();
        assertNotNull(sourceRef[0]);
            @Override
            public Status needsField(org.apache.lucene.index.FieldInfo fieldInfo) {
        // Setup mapper service with derived source enabled
            public void binaryField(org.apache.lucene.index.FieldInfo fieldInfo, byte[] value) {  
            }
        assertNotNull(storedFields);
                if (fieldInfo.name.equals(RoutingFieldMapper.NAME)) {  
    private Index index;
        StoredFields storedFields = translogLeafReader.storedFields();
        assertEquals(operation.routing(), routingVal[0]);
            @Override
        expectThrows(IllegalArgumentException.class, () -> {
        );
                if (fieldInfo.name.equals(IdFieldMapper.NAME)) {
            public void stringField(FieldInfo fieldInfo, String value) {
            @Override  
                    idRef[0] = new BytesArray(Uid.decodeId(value));
        IndexMetadata derivedMetadata = IndexMetadata.builder("test").settings(derivedSourceSettings).build();
        // Mock necessary components
    }  
            }
 * compatible open source license.
        StoredFieldVisitor visitor = new StoredFieldVisitor() {
        };  
        assertEquals(1, translogLeafReader.numDocs());
        document.add(seqID.primaryTerm);  
        assertNotNull(sourceRef[0]);
        // Create SeqID for the ParsedDocument
            .put(IndexSettings.INDEX_DERIVED_SOURCE_TRANSLOG_ENABLED_SETTING.getKey(), false)  
import org.junit.Before;
        document.add(seqID.seqNo);
import java.nio.ByteBuffer;
        StoredFields storedFields = translogLeafReader.storedFields();
import org.opensearch.index.IndexSettings;  
import org.opensearch.common.settings.Settings;
        expectThrows(UnsupportedOperationException.class, () -> translogLeafReader.getLiveDocs());  
        expectThrows(UnsupportedOperationException.class, () -> translogLeafReader.getBinaryDocValues("field"));  
package org.opensearch.index.engine;
            .put(defaultIndexSettings.getSettings())
                if (fieldInfo.name.equals(SourceFieldMapper.NAME)) {
    }
import org.apache.lucene.document.StringField;
        };
        // Setup test document
            }
import static org.mockito.Mockito.mock;  
            new NumericDocValuesField("version", 1),  
    public void testBasicProperties() {  
        IndexSettings derivedIndexSettings = new IndexSettings(derivedMetadata, Settings.EMPTY);  
import java.io.IOException;  
            .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)
            public void binaryField(FieldInfo fieldInfo, byte[] value) {
            .put(IndexSettings.INDEX_DERIVED_SOURCE_SETTING.getKey(), true)
        index = new Index("test", "_uuid");
        assertEquals(operation.id(), idRef[0].utf8ToString());
import org.opensearch.index.mapper.IdFieldMapper;
            public Status needsField(org.apache.lucene.index.FieldInfo fieldInfo) {
import org.opensearch.Version;
 *
    }  
        IndexSettings derivedIndexSettings = new IndexSettings(derivedMetadata, Settings.EMPTY);
        translogLeafReader = new TranslogLeafReader(operation, engineConfig);  
    private DocumentMapper documentMapper;
        StoredFieldVisitor visitor = new StoredFieldVisitor() {
        assertEquals(operation.source(), sourceRef[0]);
import org.apache.lucene.document.NumericDocValuesField;  
        // Test accessing invalid document ID  
import org.apache.lucene.document.Field;
                }
            .build();
                if (fieldInfo.name.equals(SourceFieldMapper.NAME)) {
    public void testIdFieldAccess() throws IOException {  
            .build();
        assertNotNull(routingVal[0]);  
    }
        });
import java.util.List;  
import org.opensearch.index.codec.CodecService;
            @Override  
        source = new BytesArray("{\"field\":1}");
import org.opensearch.index.mapper.RoutingFieldMapper;
            public void binaryField(org.apache.lucene.index.FieldInfo fieldInfo, byte[] value) {  
    public void testStoredFieldsAccess() throws IOException {
        engineConfig = new EngineConfig.Builder().indexSettings(defaultIndexSettings)
import org.opensearch.index.mapper.ParseContext;  
import org.apache.lucene.index.StoredFieldVisitor;  
            .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)  
import org.apache.lucene.index.StoredFields;
        doc.add(new StringField("field", "value", Field.Store.YES));  
            @Override  
        buffer.putLong(1L);
import org.opensearch.index.fieldvisitor.FieldsVisitor;
import org.opensearch.index.mapper.ParsedDocument;
 * SPDX-License-Identifier: Apache-2.0
        // Test various unsupported operations  
        // Test creation of in-memory reader
        expectThrows(UnsupportedOperationException.class, () -> translogLeafReader.getNumericDocValues("field"));
import org.opensearch.index.seqno.RetentionLeases;  
import org.opensearch.index.mapper.SourceFieldMapper;
    public void testDerivedSourceFieldsUsingSource() throws IOException {
import org.opensearch.index.mapper.SeqNoFieldMapper;  
            @Override
        expectThrows(UnsupportedOperationException.class, () -> translogLeafReader.terms("field"));
        assertEquals(1, translogLeafReader.maxDoc());
            @Override  
        when(documentMapper.parse(any())).thenReturn(parsedDoc);
/*  
        final String[] routingVal = new String[1];
import org.apache.lucene.index.FieldInfo;
            .put(IndexSettings.INDEX_DERIVED_SOURCE_SETTING.getKey(), true)
        StoredFields storedFields = translogLeafReader.storedFields();  
            public Status needsField(FieldInfo fieldInfo) {  
                    sourceRef[0] = new BytesArray(value);
        defaultIndexSettings = IndexSettingsModule.newIndexSettings("test", defaultIndexMetadata.getSettings());
            public void binaryField(FieldInfo fieldInfo, byte[] value) {  
        assertNotNull(TranslogLeafReader.createInMemoryIndexReader(operation, engineConfig));
            .build();  
        Document doc = new Document();
    private TranslogLeafReader translogLeafReader;
            @Override
 * The OpenSearch Contributors require contributions made to  
        translogLeafReader = new TranslogLeafReader(operation, engineConfig);
    private IndexSettings defaultIndexSettings;  
        storedFields.document(0, visitor);
    private EngineConfig engineConfig;
            .codecService(new CodecService(null, defaultIndexSettings, logger, List.of()))
            operation.id(),
        StoredFieldVisitor visitor = new StoredFieldVisitor() {
        Document doc = new Document();
        expectThrows(UnsupportedOperationException.class, () -> translogLeafReader.getPointValues("field"));
        when(documentMapper.parse(any())).thenReturn(parsedDoc);
    }  
            }
            null
        final ParseContext.Document document = new ParseContext.Document();  
import static org.mockito.Mockito.when;
            .documentMapperForTypeSupplier(() -> null)
import org.opensearch.core.common.bytes.BytesReference;  
import org.opensearch.index.mapper.DocumentMapperForType;
            source,
        assertNotNull(sourceRef[0]);
        expectThrows(UnsupportedOperationException.class, () -> translogLeafReader.getSortedDocValues("field"));
        doc.add(new StringField("field", "value", Field.Store.YES));  
    }
                }
                }  
        // Setup mapper service with derived source enabled
        when(documentMapperForType.getDocumentMapper()).thenReturn(documentMapper);
                }  
        IndexMetadata derivedMetadata = IndexMetadata.builder("test").settings(derivedSourceSettings).build();
    private BytesReference source;
            public Status needsField(FieldInfo fieldInfo) {
                    sourceRef[0] = new BytesArray(value);
                }  
        engineConfig = new EngineConfig.Builder().indexSettings(derivedIndexSettings)
            public Status needsField(FieldInfo fieldInfo) {
        documentMapper = mock(DocumentMapper.class);
            }
import org.opensearch.index.mapper.Uid;
        // Mock document mapper
            .build();  
    public void testUnsupportedOperations() {
            }  
            });  
    @Before
import org.opensearch.test.IndexSettingsModule;
        ParsedDocument parsedDoc = new ParsedDocument(
        document.add(seqID.seqNoDocValue);
        Settings derivedSourceSettings = Settings.builder()  
        ParsedDocument parsedDoc = new ParsedDocument(null, null, "1", null, null, source, MediaTypeRegistry.JSON, null);
        // Setup basic operation
        };
            .codecService(new CodecService(null, derivedIndexSettings, logger, List.of()))  
        final BytesReference[] sourceRef = new BytesReference[1];
            null,  
            }
    public void testCreateInMemoryIndexReader() throws IOException {  
    }  
                return fieldInfo.name.equals(SourceFieldMapper.NAME) ? Status.YES : Status.NO;  
        storedFields.document(0, visitor);  
                return fieldInfo.name.equals(IdFieldMapper.NAME) ? Status.YES : Status.NO;
        Settings derivedSourceSettings = Settings.builder()  
            .codecService(new CodecService(null, defaultIndexSettings, logger, List.of()))  
    public void setup() throws Exception {  
public class TranslogLeafReaderTests extends OpenSearchTestCase {  
