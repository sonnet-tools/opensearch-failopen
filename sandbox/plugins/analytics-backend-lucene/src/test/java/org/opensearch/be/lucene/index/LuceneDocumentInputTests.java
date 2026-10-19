        MappedFieldType primaryTermField = mock(MappedFieldType.class);
        assertEquals("match_only_text: should have no doc values", DocValuesType.NONE, ft.docValuesType());
        );
        assertNotNull("_primary_term field should be present in document", field);
import static org.opensearch.index.engine.dataformat.FieldTypeCapabilities.Capability.COLUMNAR_STORAGE;
        LuceneDocumentInput input = new LuceneDocumentInput();  
        MappedFieldType keywordField = mockKeywordField("status");
        input.addField(primaryTermField, 1L);
        IndexableField field = doc.getField(IdFieldMapper.NAME);
        // must be NUMERIC doc values (not SORTED_NUMERIC); the other is the range point.  
package org.opensearch.be.lucene.index;
        // SeqNoPrimaryTermPhase reads _seq_no via getNumericDocValues, so exactly one of the two
            Arrays.stream(fields).filter(f -> f.fieldType().docValuesType() == DocValuesType.NUMERIC).count()
    /** Mirrors {@link org.opensearch.be.lucene.LuceneDataFormat}: Lucene owns _seq_no's doc values and point. */  
        assertNotEquals("match_only_text: should be indexed", IndexOptions.DOCS, ft.indexOptions());
            "_seq_no: expected one point field",
        LuceneDocumentInput input = new LuceneDocumentInput();
import org.opensearch.be.lucene.LucenePlugin;  
import java.util.Map;
        Document doc = input.getFinalInput();  
        IndexableField[] fields = doc.getFields(SeqNoFieldMapper.NAME);
            "_seq_no: expected one NUMERIC doc values field",
        when(idField.name()).thenReturn(IdFieldMapper.NAME);
        IndexableFieldType ft = field.fieldType();
        Document doc = input.getFinalInput();
import static org.mockito.Mockito.mock;
        LuceneDocumentInput input = new LuceneDocumentInput();
        MappedFieldType seqNoField = mockSeqNoField();  
import org.apache.lucene.index.IndexableFieldType;
        MappedFieldType idField = mockIdField();
        IndexableFieldType ft = field.fieldType();  
        IndexableFieldType ft = field.fieldType();
        assertFalse("text: should not be stored", ft.stored());
    public void testSeqNoFieldProperties() {
    }
import org.apache.lucene.index.DocValuesType;
        when(seqNoField.name()).thenReturn(SeqNoFieldMapper.NAME);
    }
        when(seqNoField.getCapabilityMap()).thenReturn(Map.of(LucenePlugin.DATA_FORMAT, Set.of(COLUMNAR_STORAGE, POINT_RANGE)));
    private static MappedFieldType mockSeqNoField() {
 * Verifies that each field type registered in {@link org.opensearch.be.lucene.LuceneFieldFactoryRegistry}
        MappedFieldType textField = mockTextField("content");
    }
    }
        return seqNoField;  
        return idField;  
        IndexableField field = doc.getField("content");  
        IndexableField field = doc.getField("status");
 * this file be licensed under the Apache-2.0 license or a
import java.util.Set;
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.index.IndexableField;
    public void testIdFieldProperties() {
    }
        IndexableField field = doc.getField(SeqNoFieldMapper.PRIMARY_TERM_NAME);
 */  
 *
        Document doc = input.getFinalInput();
        assertNotEquals("_id: should be indexed", IndexOptions.NONE, ft.indexOptions());  
            1,
        // Must be NUMERIC, not SORTED_NUMERIC: SeqNoPrimaryTermPhase uses getNumericDocValues.  
import org.opensearch.index.mapper.MappedFieldType;
        input.addField(keywordField, "active");
    public void testMatchOnlyTextFieldProperties() {  
import org.apache.lucene.document.Document;
        IndexableFieldType ft = field.fieldType();
import java.nio.charset.StandardCharsets;
    private static MappedFieldType mockIdField() {
        assertNotNull("keyword field should be present in document", field);  
            1,  
/*  
        assertEquals("_seq_no should produce a point and a doc values field", 2, fields.length);  
        Document doc = input.getFinalInput();  
        input.addField(idField, "test-id".getBytes(StandardCharsets.UTF_8));
        Document doc = input.getFinalInput();  
        when(idField.getCapabilityMap()).thenReturn(Map.of(LucenePlugin.DATA_FORMAT, Set.of(FULL_TEXT_SEARCH)));
 */
        assertEquals(  
    }
        IndexableField field = doc.getField("body");
        assertTrue("match_only_text: should omit norms", ft.omitNorms());  
        assertTrue("keyword: should omit norms", ft.omitNorms());
import static org.opensearch.index.engine.dataformat.FieldTypeCapabilities.Capability.POINT_RANGE;  
 * SPDX-License-Identifier: Apache-2.0
        MappedFieldType matchOnlyField = mockMatchOnlyTextField("body");
    public void testTextFieldProperties() {  
 * compatible open source license.
        input.addField(textField, "hello world");  
 * produces Lucene fields with the expected storage properties.  
        assertFalse("keyword: should not be stored", ft.stored());  
    public void testKeywordFieldProperties() {
        assertTrue("text: should omit norms", ft.omitNorms());
        assertNotEquals("keyword: should be indexed", IndexOptions.NONE, ft.indexOptions());  
        assertNotEquals("text: should be indexed", IndexOptions.NONE, ft.indexOptions());
import java.util.Arrays;  
        MappedFieldType seqNoField = mock(MappedFieldType.class);
        assertNotNull("match_only_text field should be present in document", field);
/**
        );
    public void testPrimaryTermFieldProperties() {
        assertNotNull("text field should be present in document", field);
        input.addField(seqNoField, 42L);
        when(seqNoField.typeName()).thenReturn(SeqNoFieldMapper.CONTENT_TYPE);  
        assertFalse("_id: should not be stored", ft.stored());
import org.opensearch.index.mapper.SeqNoFieldMapper;  
}  
        assertEquals(DocValuesType.NUMERIC, field.fieldType().docValuesType());
        MappedFieldType idField = mock(MappedFieldType.class);
import org.apache.lucene.index.IndexOptions;  
        Document doc = input.getFinalInput();
import org.opensearch.index.mapper.IdFieldMapper;
public class LuceneDocumentInputTests extends LucenePluginBaseTests {
        assertEquals("keyword: should have no doc values", DocValuesType.NONE, ft.docValuesType());
        assertNotNull("_id field should be present in document", field);
        input.addField(matchOnlyField, "some text");
            Arrays.stream(fields).filter(f -> f.fieldType().pointDimensionCount() > 0).count()  
    }  
    private static MappedFieldType mockPrimaryTermField() {  
        when(primaryTermField.name()).thenReturn(SeqNoFieldMapper.PRIMARY_TERM_NAME);  
        assertEquals(
        MappedFieldType primaryTermField = mockPrimaryTermField();
    }
import static org.opensearch.index.engine.dataformat.FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH;
        LuceneDocumentInput input = new LuceneDocumentInput();
import static org.mockito.Mockito.when;
        LuceneDocumentInput input = new LuceneDocumentInput();  
        assertEquals("text: should have no doc values", DocValuesType.NONE, ft.docValuesType());  
        LuceneDocumentInput input = new LuceneDocumentInput();  
        assertFalse("match_only_text: should not be stored", ft.stored());
        when(idField.typeName()).thenReturn(IdFieldMapper.CONTENT_TYPE);  
        return primaryTermField;
        when(primaryTermField.typeName()).thenReturn(SeqNoFieldMapper.PRIMARY_TERM_NAME);
    }
