    public void testMultipleFields() {
        List<FieldValuePair> result = input.getFinalInput();
    public void testDeclaredMultiValueFieldWithEmptyArrayIsPresentEmptyList() {
        MappedFieldType second = new KeywordFieldMapper.KeywordFieldType("tags");  
        assignTestCapabilities(other, PARQUET_FORMAT);
        FieldValuePair pair = findPair(input, "tags");  
        input.setRowId(DocumentInput.ROW_ID_FIELD, 0L);  
        assertTrue(pair.isMultiValued());
    }  
        input.addField(tags, "b");
        input.addField(tags, List.of());
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("age", NumberFieldMapper.NumberType.INTEGER);  
    public void testDeclaredMultiValueFieldWithSingleValueIsStillAList() {  
        MappedFieldType rawValue = new KeywordFieldMapper.KeywordFieldType("_ignored_source.tags");
import org.opensearch.index.mapper.MappedFieldType;
        input.setRowId(DocumentInput.ROW_ID_FIELD, 0L);
    public void testUndeclaredNumericFieldPromotesWhenSecondValueArrives() {  
        tags.setMultiValued(true);
        input.setRowId(DocumentInput.ROW_ID_FIELD, 0L);
        input.addField(other, "two");
        assertEquals(3L, input.getFieldCount("tags"));  
        assertThat(error.getMessage(), org.hamcrest.Matchers.containsString("locked scalar by [multi_value: false]"));  
        MappedFieldType tags = new KeywordFieldMapper.KeywordFieldType("tags");  
        assertEquals(5, input.getFinalInput().size());
        MappedFieldType first = new KeywordFieldMapper.KeywordFieldType("tags");  
        assignTestCapabilities(number, PARQUET_FORMAT);
        assertEquals(0L, input.getFieldCount("tags"));
        assertEquals(0, pair.valueCount());
        input.addField(tags, "x");
        input.setRowId(DocumentInput.ROW_ID_FIELD, 0L);
        // The document parser reports one addField call per array element.  
        assignTestCapabilities(ft, PARQUET_FORMAT);
        second.setMultiValued(true);
    private static final DataFormat PARQUET_FORMAT = new ParquetDataFormat();
        input.addField(valField, 10);
        // multi_value flag onto it, so the document input must accumulate its values too —
    public void testMultiValueFieldCountIsValueCountNotEntryCount() {
        assertEquals(5, result.size());  
        assertTrue(pair.isMultiValued());  
    }
        assignTestCapabilities(first, PARQUET_FORMAT);
        MappedFieldType other = new KeywordFieldMapper.KeywordFieldType("other");  
        assertEquals(List.of("b", "a", "b"), pair.getValue());
        assertEquals(List.of("solo"), pair.getValue());
        assertEquals(2L, input.getFieldCount("tags"));
 * The OpenSearch Contributors require contributions made to  
    }
        // elements must land in the SAME list rather than the second creating a new pair (which
        input.addField(rawValue, "RAW-ONE");  
        other.setMultiValueSupported(true);
        input.setRowId(DocumentInput.ROW_ID_FIELD, 0L);
        input.addField(rawValue, "RAW-TWO");
    }  
        MapperParsingException error = expectThrows(MapperParsingException.class, () -> input.addField(number, 20));
        // The parser signals an explicit empty array ("tags": []) with an empty List value. It must  
        // One collected entry holding two values.  
        assertTrue(input.getFinalInput().isEmpty());  
        FieldValuePair pair = findPair(input, "tags");
        assertEquals(List.of(), pair.getValue());  
        input.addField(tags, "solo");
        assignTestCapabilities(tags, PARQUET_FORMAT);
        // seed a present, zero-value list (written as an empty-but-non-null LIST cell) rather than
        // derived _source, so they must not be sorted or deduplicated.  
        assertEquals(25, result.getFirst().getValue());
        ParquetDocumentInput input = new ParquetDocumentInput();  
        rawValue.setMultiValued(true);  
        ParquetDocumentInput input = new ParquetDocumentInput();  
        assertEquals(List.of("one", "two"), pair.getValue());
        assignTestCapabilities(number, PARQUET_FORMAT);
        // _source.  
    public void testDerivedSourceCompanionFieldFollowsParentState() {
}
        ParquetDocumentInput input = new ParquetDocumentInput();
    public void testMultiValueAccumulationKeyedByNameNotInstanceIdentity() {
 * compatible open source license.
        FieldValuePair pair = findPair(input, "other");
        assertTrue(pair.isMultiValued());
    }  
    }  
        assertEquals(List.of(10, 20), pair.getValue());
        ParquetDocumentInput input = new ParquetDocumentInput();  
 *
        assignTestCapabilities(ft2, PARQUET_FORMAT);
            .orElseThrow(() -> new AssertionError("no collected field named " + fieldName));
import org.opensearch.parquet.ParquetBaseTests;
        populateMetadataFields(input);
        assignTestCapabilities(tags, PARQUET_FORMAT);
        populateMetadataFields(input);
        input.setRowId(DocumentInput.ROW_ID_FIELD, 0L);  
        input.setRowId(DocumentInput.ROW_ID_FIELD, 0L);
            .stream()
        assertSame(ft, result.getFirst().getFieldType());
import java.util.List;
        assignTestCapabilities(tags, PARQUET_FORMAT);
        input.close();
        ParquetDocumentInput input = new ParquetDocumentInput();  
    public void testUndeclaredKeywordPromotesWhenSecondValueArrives() {  
        populateMetadataFields(input);
        assignTestCapabilities(valField, PARQUET_FORMAT);
        ParquetDocumentInput input = new ParquetDocumentInput();
        input.addField(ft1, 1);
        input.addField(tags, "y");  
        assertEquals(2L, input.getFieldCount("other"));
    public void testSetRowId() {
        // column type stays consistent across documents.
import org.opensearch.index.engine.dataformat.DataFormat;
        ParquetDocumentInput input = new ParquetDocumentInput();
    public void testRejectsDuplicateFieldInSingleDocument() throws Exception {  
    }
        input.setRowId(DocumentInput.ROW_ID_FIELD, 0L);
        assertEquals(List.of("a", "b"), pair.getValue());  
        assignTestCapabilities(second, PARQUET_FORMAT);
        MappedFieldType tags = new KeywordFieldMapper.KeywordFieldType("tags");
        tags.setMultiValued(true);  
        input.setRowId(DocumentInput.ROW_ID_FIELD, 0L);  
        number.setMultiValueSupported(true);  
        assertEquals(3, pair.valueCount());
    }  
            1,
        populateMetadataFields(input);
        assertEquals(42L, input.getRowId());
import org.opensearch.index.mapper.NumberFieldMapper;  
        FieldValuePair pair = findPair(input, "number");
import org.opensearch.index.mapper.KeywordFieldMapper;  
        populateMetadataFields(input);
        assignTestCapabilities(tags, PARQUET_FORMAT);
        assertEquals(5, input.getFinalInput().size());  
        ParquetDocumentInput input = new ParquetDocumentInput();
        populateMetadataFields(input);
    public void testCloseClearsState() {
        MappedFieldType tags = new KeywordFieldMapper.KeywordFieldType("tags");
            .filter(p -> p.getFieldType().name().equals(fieldName))  
        // Metadata fields must still count as exactly one so getFinalInput's assertions hold.  
        ParquetDocumentInput input = new ParquetDocumentInput();  
    }  
        input.addField(number, 20);
        input.addField(ft2, "val");  
        // handed back a fresh wrapper per array element. Accumulation keys on the name, so both  
import org.opensearch.parquet.engine.ParquetDataFormat;
        // KeywordFieldMapper emits "_ignored_source.<field>" alongside the parent when a normalizer
        assertTrue(pair.isMultiValued());  
    }
        assertEquals(List.of("RAW-ONE", "RAW-TWO"), pair.getValue());  
 * this file be licensed under the Apache-2.0 license or a
            "both elements must accumulate into one pair",
        ParquetDocumentInput input = new ParquetDocumentInput();  
 */  
    }
        populateMetadataFields(input);
        MappedFieldType ft2 = new KeywordFieldMapper.KeywordFieldType("b");
        assertEquals(4, input.getFinalInput().size());
            .findFirst()
            input.getFinalInput().stream().filter(p -> p.getFieldType().name().equals("tags")).count()  
        tags.setMultiValued(true);  
        input.addField(first, "a");
        // or ignore_above alters the value, and buildRawKeywordValueFieldType copies the parent's  
import org.opensearch.index.mapper.MapperParsingException;
    public void testEmptyInput() {  
        input.setRowId(DocumentInput.ROW_ID_FIELD, 0L);  
        input.setRowId(DocumentInput.ROW_ID_FIELD, 0L);
        assertTrue(pair.isMultiValued());
    private static FieldValuePair findPair(ParquetDocumentInput input, String fieldName) {  
        ParquetDocumentInput input = new ParquetDocumentInput();
        populateMetadataFields(input);
        number.setMultiValueState(MappedFieldType.MultiValueState.SCALAR);
        // Two DISTINCT field-type instances that share a name, as could arise if the parse path ever
        MappedFieldType ft1 = new NumberFieldMapper.NumberFieldType("a", NumberFieldMapper.NumberType.INTEGER);
    public void testAddFieldAndGetFinalInput() {
        ParquetDocumentInput input = new ParquetDocumentInput();  
        input.addField(second, "b");  
        MappedFieldType tags = new KeywordFieldMapper.KeywordFieldType("tags");
        input.addField(other, "one");
        MappedFieldType number = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);
        assertEquals(6, input.getFinalInput().size());  
        populateMetadataFields(input);
        // otherwise it would reject the second value while its own column expects a list.
        ParquetDocumentInput input = new ParquetDocumentInput();
        // would silently degrade multi_value to last-value-wins).
        input.addField(number, 10);
        tags.setMultiValued(true);  
        MappedFieldType number = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);  
        populateMetadataFields(input);
        populateMetadataFields(input);  
        input.addField(tags, "b");  
        FieldValuePair pair = findPair(input, "tags");  
        populateMetadataFields(input);
    }
        assertNotSame(first, second);  
        input.addField(ft, 25);
        input.addField(ft, 25);
        assignTestCapabilities(ft, PARQUET_FORMAT);  
    }  
        assertEquals(1L, input.getFieldCount(org.opensearch.index.mapper.IdFieldMapper.NAME));
        populateMetadataFields(input);
    public void testExplicitSingleFieldRejectsSecondValue() {
    public void testDeclaredMultiValueFieldAccumulatesValuesInOrder() {
        FieldValuePair pair = findPair(input, "_ignored_source.tags");
/*  
        );
        FieldValuePair pair = findPair(input, "tags");
    }  
        NumberFieldMapper.NumberFieldType valField = new NumberFieldMapper.NumberFieldType("val", NumberFieldMapper.NumberType.INTEGER);
        input.setRowId(DocumentInput.ROW_ID_FIELD, 42L);
    }
        populateMetadataFields(input);
 * SPDX-License-Identifier: Apache-2.0
    }
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("age", NumberFieldMapper.NumberType.INTEGER);
        expectThrows(MapperParsingException.class, () -> input.addField(valField, 20));
import org.opensearch.index.engine.dataformat.DocumentInput;
        assertEquals(  
        // A scalar JSON value on a declared list column still writes a one-element list, so the
        return input.getFinalInput()
        // being dropped, so an empty array stays distinct from an absent field in reconstructed
        first.setMultiValued(true);
        ParquetDocumentInput input = new ParquetDocumentInput();  
        assignTestCapabilities(ft1, PARQUET_FORMAT);  
        input.setRowId(DocumentInput.ROW_ID_FIELD, 0L);
        // Document order and duplicates are preserved: the values are the source of truth for
        assignTestCapabilities(rawValue, PARQUET_FORMAT);
        assertEquals(2L, input.getFieldCount("number"));
package org.opensearch.parquet.writer;
public class ParquetDocumentInputTests extends ParquetBaseTests {  
        input.addField(number, 10);
        number.setMultiValueSupported(true);
        populateMetadataFields(input);
        input.addField(tags, "a");
        ParquetDocumentInput input = new ParquetDocumentInput();
        assertTrue(pair.isMultiValued());
