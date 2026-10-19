            @Override
import org.opensearch.core.common.bytes.BytesArray;
import org.apache.lucene.document.Field;
                }
        doc.add(new StringField("field", "value", Field.Store.YES));
            null
    public void testCreateInMemoryIndexReader() throws IOException {
                }
        storedFields.document(0, visitor);
        StoredFieldVisitor visitor = new StoredFieldVisitor() {
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        engineConfig = new EngineConfig.Builder().indexSettings(derivedIndexSettings)
            Collections.singletonList(document),
import java.util.List;
        doc.add(new StringField("field", "value", Field.Store.YES));
        final ParseContext.Document document = new ParseContext.Document();
        translogLeafReader = new TranslogLeafReader(operation, engineConfig);
        assertNotNull(sourceRef[0]);
        assertNotNull(sourceRef[0]);
        expectThrows(UnsupportedOperationException.class, () -> translogLeafReader.getBinaryDocValues("field"));
        StoredFieldVisitor visitor = new StoredFieldVisitor() {
            MediaTypeRegistry.JSON,
            });
    private DocumentMapper documentMapper;
        assertNotNull(routingVal[0]);
            .numberOfShards(1)
        expectThrows(UnsupportedOperationException.class, () -> translogLeafReader.getPointValues("field"));
        assertEquals(operation.source(), sourceRef[0]);
import org.apache.lucene.document.StringField;
    public void testRoutingFieldAccess() throws IOException {
        defaultIndexSettings = IndexSettingsModule.newIndexSettings("test", defaultIndexMetadata.getSettings());
            .put(defaultIndexSettings.getSettings())
        IndexMetadata derivedMetadata = IndexMetadata.builder("test").settings(derivedSourceSettings).build();
        };
import org.opensearch.index.mapper.RoutingFieldMapper;
            @Override
        storedFields.document(0, visitor);
            .put(IndexSettings.INDEX_DERIVED_SOURCE_SETTING.getKey(), true)
 */
            }
            .documentMapperForTypeSupplier(() -> documentMapperForType)
        expectThrows(UnsupportedOperationException.class, () -> translogLeafReader.getLiveDocs());
        // Setup basic operation
                return fieldInfo.name.equals(SourceFieldMapper.NAME) ? Status.YES : Status.NO;
                if (fieldInfo.name.equals(SourceFieldMapper.NAME)) {
            }
            public Status needsField(org.apache.lucene.index.FieldInfo fieldInfo) {
import org.opensearch.test.IndexSettingsModule;
            .build();
            }
import static org.mockito.Mockito.when;
                return fieldInfo.name.equals(RoutingFieldMapper.NAME) ? Status.YES : Status.NO;
    public void testBasicProperties() {
            @Override
                }
    }
package org.opensearch.index.engine;
            .build();
        StoredFields storedFields = translogLeafReader.storedFields();
import org.opensearch.index.mapper.SourceFieldMapper;
import java.nio.ByteBuffer;
                    idRef[0] = new BytesArray(Uid.decodeId(value));
        assertEquals(1, translogLeafReader.numDocs());
            public Status needsField(FieldInfo fieldInfo) {
            .codecService(new CodecService(null, defaultIndexSettings, logger, List.of()))
            public void stringField(FieldInfo fieldInfo, String value) {
import org.opensearch.index.mapper.DocumentMapper;
    public void testSourceFieldAccess() throws IOException {
            }
            .numberOfReplicas(1)
        storedFields.document(0, visitor);
            public void binaryField(FieldInfo fieldInfo, byte[] value) {
    }
            @Override
        // Create SeqID for the ParsedDocument
        Settings derivedSourceSettings = Settings.builder()
        // Initialize the reader
                }
                if (fieldInfo.name.equals(RoutingFieldMapper.NAME)) {
        assertEquals(operation.id(), idRef[0].utf8ToString());
        when(documentMapperForType.getDocumentMapper()).thenReturn(documentMapper);
        when(documentMapper.parse(any())).thenReturn(parsedDoc);
import org.opensearch.index.codec.CodecService;
            }
 * this file be licensed under the Apache-2.0 license or a
        // Setup test document
    @Before
            .build();
import org.opensearch.index.mapper.IdFieldMapper;
            .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)
        StoredFields storedFields = translogLeafReader.storedFields();
        Document doc = new Document();
        final BytesReference[] idRef = new BytesReference[1];
        operation = new Translog.Index("test", 1L, 1L, 1L, source.toBytesRef().bytes, "routing", 1);
        assertEquals(operation.routing(), routingVal[0]);
        );
        expectThrows(IllegalArgumentException.class, () -> {
import org.apache.lucene.index.StoredFields;
        // Setup mapper service with derived source enabled
                    sourceRef[0] = new BytesArray(value);
        final BytesReference[] sourceRef = new BytesReference[1];
    }
        final String[] routingVal = new String[1];
        expectThrows(UnsupportedOperationException.class, () -> translogLeafReader.terms("field"));
        // Test creation of in-memory reader
import org.opensearch.core.xcontent.MediaTypeRegistry;
                return fieldInfo.name.equals(SourceFieldMapper.NAME) ? Status.YES : Status.NO;
        };
            @Override
        document.add(seqID.seqNo);
                    routingVal[0] = value;
        // Test various unsupported operations
    private TranslogLeafReader translogLeafReader;
        final BytesReference[] sourceRef = new BytesReference[1];
        ParsedDocument parsedDoc = new ParsedDocument(null, null, "1", null, null, source, MediaTypeRegistry.JSON, null);
            storedFields.document(1, new FieldsVisitor(true) {
        assertEquals(operation.source(), sourceRef[0]);
            seqID,
import org.opensearch.index.translog.Translog;
    private EngineConfig engineConfig;
            .documentMapperForTypeSupplier(() -> documentMapperForType)
import org.opensearch.index.mapper.DocumentMapperForType;
            .put(IndexSettings.INDEX_DERIVED_SOURCE_SETTING.getKey(), true)
    private DocumentMapperForType documentMapperForType;
import org.apache.lucene.index.FieldInfo;
            .build();
            @Override
/*
            public void binaryField(org.apache.lucene.index.FieldInfo fieldInfo, byte[] value) {
    }
            public Status needsField(org.apache.lucene.index.FieldInfo fieldInfo) {
        engineConfig = new EngineConfig.Builder().indexSettings(defaultIndexSettings)
        documentMapperForType = mock(DocumentMapperForType.class);
        storedFields.document(0, visitor);
                return fieldInfo.name.equals(IdFieldMapper.NAME) ? Status.YES : Status.NO;
        StoredFields storedFields = translogLeafReader.storedFields();
import org.opensearch.index.seqno.RetentionLeases;
        final BytesReference[] sourceRef = new BytesReference[1];
            }
import org.opensearch.core.index.Index;
            public Status needsField(FieldInfo fieldInfo) {
                if (fieldInfo.name.equals(SourceFieldMapper.NAME)) {
            .build();
import org.junit.Before;
        assertNotNull(sourceRef[0]);
import org.opensearch.index.mapper.Uid;
    public void testStoredFieldsAccess() throws IOException {
            null,
                }
        StoredFieldVisitor visitor = new StoredFieldVisitor() {
    }
    private Translog.Index operation;
        storedFields.document(0, visitor);
        expectThrows(UnsupportedOperationException.class, () -> translogLeafReader.getSortedDocValues("field"));
        expectThrows(UnsupportedOperationException.class, () -> translogLeafReader.getNumericDocValues("field"));
        };
            .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)
            .settings(settings(Version.CURRENT))
import org.apache.lucene.index.StoredFieldVisitor;
            .put(IndexSettings.INDEX_DERIVED_SOURCE_TRANSLOG_ENABLED_SETTING.getKey(), false)
    }
        Settings derivedSourceSettings = Settings.builder()
        });
                    sourceRef[0] = new BytesArray(value);
        StoredFields storedFields = translogLeafReader.storedFields();
        final IndexMetadata defaultIndexMetadata = IndexMetadata.builder("test")
            .put(defaultIndexSettings.getSettings())
        source = new BytesArray("{\"field\":1}");
        buffer.putLong(1L);
                    sourceRef[0] = new BytesArray(value);
import org.opensearch.common.settings.Settings;
            @Override
        SeqNoFieldMapper.SequenceIDFields seqID = SeqNoFieldMapper.SequenceIDFields.emptySeqID();
            .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)
            .build();
    }
        assertNotNull(idRef[0]);
        // Setup mapper service with derived source enabled
            @Override
import org.opensearch.index.fieldvisitor.FieldsVisitor;
import org.opensearch.test.OpenSearchTestCase;
 * The OpenSearch Contributors require contributions made to
        document.add(seqID.primaryTerm);
    public void testDerivedSourceFieldsUsingDerivedSource() throws IOException {
            public void binaryField(FieldInfo fieldInfo, byte[] value) {
                if (fieldInfo.name.equals(SourceFieldMapper.NAME)) {
        index = new Index("test", "_uuid");
        StoredFieldVisitor visitor = new StoredFieldVisitor() {
    private Index index;
import org.apache.lucene.document.Document;
        // Mock necessary components
        document.add(seqID.seqNoDocValue);
        IndexMetadata derivedMetadata = IndexMetadata.builder("test").settings(derivedSourceSettings).build();
import org.opensearch.core.common.bytes.BytesReference;
                if (fieldInfo.name.equals(IdFieldMapper.NAME)) {
        // Test accessing invalid document ID
            }
    }
    public void testIdFieldAccess() throws IOException {
        Document doc = new Document();
                return fieldInfo.name.equals(SourceFieldMapper.NAME) ? Status.YES : Status.NO;
        assertNotNull(storedFields);
        StoredFieldVisitor visitor = new StoredFieldVisitor() {
        assertNotNull(TranslogLeafReader.createInMemoryIndexReader(operation, engineConfig));
import org.opensearch.index.mapper.ParseContext;
import org.opensearch.index.mapper.SeqNoFieldMapper;
import org.opensearch.index.IndexSettings;
        documentMapper = mock(DocumentMapper.class);
import java.util.Collections;
 * compatible open source license.
            @Override
import org.opensearch.cluster.metadata.IndexMetadata;
import static org.mockito.ArgumentMatchers.any;
            }
    private IndexSettings defaultIndexSettings;
            .documentMapperForTypeSupplier(() -> null)
    public void setup() throws Exception {
        engineConfig = new EngineConfig.Builder().indexSettings(derivedIndexSettings)
        IndexSettings derivedIndexSettings = new IndexSettings(derivedMetadata, Settings.EMPTY);
    }
        StoredFields storedFields = translogLeafReader.storedFields();
import org.apache.lucene.document.NumericDocValuesField;
            source,
    public void testUnsupportedOperations() {
        IndexSettings derivedIndexSettings = new IndexSettings(derivedMetadata, Settings.EMPTY);
import org.opensearch.Version;
        };
 *
        // Mock document mapper
import static org.mockito.Mockito.mock;
 * SPDX-License-Identifier: Apache-2.0
            }
            new NumericDocValuesField("version", 1),
            }
            operation.id(),
            public Status needsField(FieldInfo fieldInfo) {
    }
        StoredFields storedFields = translogLeafReader.storedFields();
    private BytesReference source;
public class TranslogLeafReaderTests extends OpenSearchTestCase {
import org.opensearch.index.mapper.ParsedDocument;
        };
            .codecService(new CodecService(null, defaultIndexSettings, logger, List.of()))
            @Override
        assertEquals(1, translogLeafReader.maxDoc());
        ParsedDocument parsedDoc = new ParsedDocument(
}
import java.io.IOException;
            public void binaryField(org.apache.lucene.index.FieldInfo fieldInfo, byte[] value) {
        when(documentMapper.parse(any())).thenReturn(parsedDoc);
    public void testDerivedSourceFieldsUsingSource() throws IOException {
            .codecService(new CodecService(null, derivedIndexSettings, logger, List.of()))
        translogLeafReader = new TranslogLeafReader(operation, engineConfig);
