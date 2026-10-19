            "_seq_no: expected one NUMERIC doc values field",
        assertEquals("match_only_text: should have no doc values", DocValuesType.NONE, ft.docValuesType());
import org.opensearch.index.mapper.MappedFieldType;
        assertFalse("_id: should not be stored", ft.stored());
            1,
import org.apache.lucene.index.IndexableField;
        assertFalse("text: should not be stored", ft.stored());
        assertTrue("match_only_text: should omit norms", ft.omitNorms());
/**
import static org.mockito.Mockito.when;
import java.util.Map;
 * SPDX-License-Identifier: Apache-2.0
        LuceneDocumentInput input = new LuceneDocumentInput();
        input.addField(seqNoField, 42L);
    }
        assertNotNull("text field should be present in document", field);
        IndexableField field = doc.getField("status");
        assertEquals("text: should have no doc values", DocValuesType.NONE, ft.docValuesType());
        assertTrue("text: should omit norms", ft.omitNorms());
        );
        input.addField(keywordField, "active");
 * compatible open source license.
}
import org.opensearch.be.lucene.LucenePlugin;
        assertEquals(
        when(primaryTermField.typeName()).thenReturn(SeqNoFieldMapper.PRIMARY_TERM_NAME);
        assertNotNull("match_only_text field should be present in document", field);
        when(idField.getCapabilityMap()).thenReturn(Map.of(LucenePlugin.DATA_FORMAT, Set.of(FULL_TEXT_SEARCH)));
 */
        LuceneDocumentInput input = new LuceneDocumentInput();
    }
        IndexableField field = doc.getField("content");
/*
        return seqNoField;
        input.addField(matchOnlyField, "some text");
        LuceneDocumentInput input = new LuceneDocumentInput();
    private static MappedFieldType mockIdField() {
        when(seqNoField.typeName()).thenReturn(SeqNoFieldMapper.CONTENT_TYPE);
        input.addField(idField, "test-id".getBytes(StandardCharsets.UTF_8));
 * The OpenSearch Contributors require contributions made to
 * produces Lucene fields with the expected storage properties.
import static org.opensearch.index.engine.dataformat.FieldTypeCapabilities.Capability.COLUMNAR_STORAGE;
    }
    }
import static org.opensearch.index.engine.dataformat.FieldTypeCapabilities.Capability.POINT_RANGE;
        assertNotNull("keyword field should be present in document", field);
import org.opensearch.index.mapper.SeqNoFieldMapper;
        assertNotNull("_primary_term field should be present in document", field);
        when(idField.typeName()).thenReturn(IdFieldMapper.CONTENT_TYPE);
        IndexableField[] fields = doc.getFields(SeqNoFieldMapper.NAME);
        MappedFieldType idField = mockIdField();
        MappedFieldType textField = mockTextField("content");
 *
        IndexableFieldType ft = field.fieldType();
    }
        IndexableField field = doc.getField("body");
public class LuceneDocumentInputTests extends LucenePluginBaseTests {
        Document doc = input.getFinalInput();
import static org.mockito.Mockito.mock;
        MappedFieldType seqNoField = mockSeqNoField();
        MappedFieldType keywordField = mockKeywordField("status");
        LuceneDocumentInput input = new LuceneDocumentInput();
        assertNotEquals("keyword: should be indexed", IndexOptions.NONE, ft.indexOptions());
    }
    }
        assertEquals("_seq_no should produce a point and a doc values field", 2, fields.length);
            "_seq_no: expected one point field",
        assertEquals(
        assertNotEquals("text: should be indexed", IndexOptions.NONE, ft.indexOptions());
import static org.opensearch.index.engine.dataformat.FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH;
        MappedFieldType primaryTermField = mockPrimaryTermField();
        IndexableFieldType ft = field.fieldType();
        LuceneDocumentInput input = new LuceneDocumentInput();
import org.opensearch.index.mapper.IdFieldMapper;
    public void testKeywordFieldProperties() {
        // SeqNoPrimaryTermPhase reads _seq_no via getNumericDocValues, so exactly one of the two
            1,
    public void testPrimaryTermFieldProperties() {
        assertEquals("keyword: should have no doc values", DocValuesType.NONE, ft.docValuesType());
    }
        return primaryTermField;
        Document doc = input.getFinalInput();
        MappedFieldType primaryTermField = mock(MappedFieldType.class);
import org.apache.lucene.index.IndexOptions;
        assertNotEquals("match_only_text: should be indexed", IndexOptions.DOCS, ft.indexOptions());
import java.util.Arrays;
        assertNotEquals("_id: should be indexed", IndexOptions.NONE, ft.indexOptions());
        input.addField(textField, "hello world");
    public void testTextFieldProperties() {
        IndexableFieldType ft = field.fieldType();
    private static MappedFieldType mockPrimaryTermField() {
        MappedFieldType matchOnlyField = mockMatchOnlyTextField("body");
        assertTrue("keyword: should omit norms", ft.omitNorms());
        LuceneDocumentInput input = new LuceneDocumentInput();
    private static MappedFieldType mockSeqNoField() {
            Arrays.stream(fields).filter(f -> f.fieldType().docValuesType() == DocValuesType.NUMERIC).count()
        );
import org.apache.lucene.document.Document;
        Document doc = input.getFinalInput();
        IndexableFieldType ft = field.fieldType();
        Document doc = input.getFinalInput();
    public void testIdFieldProperties() {
    public void testMatchOnlyTextFieldProperties() {
    /** Mirrors {@link org.opensearch.be.lucene.LuceneDataFormat}: Lucene owns _seq_no's doc values and point. */
package org.opensearch.be.lucene.index;
    }
            Arrays.stream(fields).filter(f -> f.fieldType().pointDimensionCount() > 0).count()
        when(seqNoField.getCapabilityMap()).thenReturn(Map.of(LucenePlugin.DATA_FORMAT, Set.of(COLUMNAR_STORAGE, POINT_RANGE)));
import java.util.Set;
        Document doc = input.getFinalInput();
        // must be NUMERIC doc values (not SORTED_NUMERIC); the other is the range point.
import org.apache.lucene.index.IndexableFieldType;
        // Must be NUMERIC, not SORTED_NUMERIC: SeqNoPrimaryTermPhase uses getNumericDocValues.
        assertFalse("keyword: should not be stored", ft.stored());
        MappedFieldType seqNoField = mock(MappedFieldType.class);
 */
        input.addField(primaryTermField, 1L);
        assertFalse("match_only_text: should not be stored", ft.stored());
 * this file be licensed under the Apache-2.0 license or a
        IndexableField field = doc.getField(SeqNoFieldMapper.PRIMARY_TERM_NAME);
        Document doc = input.getFinalInput();
        return idField;
        when(idField.name()).thenReturn(IdFieldMapper.NAME);
        when(seqNoField.name()).thenReturn(SeqNoFieldMapper.NAME);
        MappedFieldType idField = mock(MappedFieldType.class);
        when(primaryTermField.name()).thenReturn(SeqNoFieldMapper.PRIMARY_TERM_NAME);
import java.nio.charset.StandardCharsets;
        assertEquals(DocValuesType.NUMERIC, field.fieldType().docValuesType());
import org.apache.lucene.index.DocValuesType;
        assertNotNull("_id field should be present in document", field);
    public void testSeqNoFieldProperties() {
        IndexableField field = doc.getField(IdFieldMapper.NAME);
 * Verifies that each field type registered in {@link org.opensearch.be.lucene.LuceneFieldFactoryRegistry}
