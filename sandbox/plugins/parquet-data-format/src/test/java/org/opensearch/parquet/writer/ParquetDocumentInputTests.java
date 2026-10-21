        input.addField(ft, 25);
        input.addField(tags, "b");
        input.addField(valField, 10);
    }
        input.setRowId(DocumentInput.ROW_ID_FIELD, 0L);
        populateMetadataFields(input);
    }
        assertEquals(List.of("RAW-ONE", "RAW-TWO"), pair.getValue());
        populateMetadataFields(input);
        assertEquals(3L, input.getFieldCount("tags"));
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("age", NumberFieldMapper.NumberType.INTEGER);
        input.addField(other, "one");
        assertEquals(List.of("a", "b"), pair.getValue());
        number.setMultiValueSupported(true);
        MappedFieldType rawValue = new KeywordFieldMapper.KeywordFieldType("_ignored_source.tags");
        input.setRowId(DocumentInput.ROW_ID_FIELD, 0L);
        MappedFieldType second = new KeywordFieldMapper.KeywordFieldType("tags");
            input.getFinalInput().stream().filter(p -> p.getFieldType().name().equals("tags")).count()
        input.addField(tags, "b");
        assignTestCapabilities(rawValue, PARQUET_FORMAT);
    public void testMultiValueFieldCountIsValueCountNotEntryCount() {
            .orElseThrow(() -> new AssertionError("no collected field named " + fieldName));
        FieldValuePair pair = findPair(input, "number");
        MappedFieldType first = new KeywordFieldMapper.KeywordFieldType("tags");
        input.addField(ft, 25);
        List<FieldValuePair> result = input.getFinalInput();
        input.addField(number, 20);
    public void testEmptyInput() {
        MappedFieldType tags = new KeywordFieldMapper.KeywordFieldType("tags");
        ParquetDocumentInput input = new ParquetDocumentInput();
        input.setRowId(DocumentInput.ROW_ID_FIELD, 42L);
        return input.getFinalInput()
        FieldValuePair pair = findPair(input, "tags");
        // Two DISTINCT field-type instances that share a name, as could arise if the parse path ever
public class ParquetDocumentInputTests extends ParquetBaseTests {
import org.opensearch.index.engine.dataformat.DocumentInput;
        populateMetadataFields(input);
        // Document order and duplicates are preserved: the values are the source of truth for
        assertEquals(List.of("one", "two"), pair.getValue());
        tags.setMultiValued(true);
/*
    private static FieldValuePair findPair(ParquetDocumentInput input, String fieldName) {
    }
        ParquetDocumentInput input = new ParquetDocumentInput();
        assignTestCapabilities(tags, PARQUET_FORMAT);
        input.setRowId(DocumentInput.ROW_ID_FIELD, 0L);
}
        input.addField(rawValue, "RAW-TWO");
import org.opensearch.index.engine.dataformat.DataFormat;
    }
        NumberFieldMapper.NumberFieldType valField = new NumberFieldMapper.NumberFieldType("val", NumberFieldMapper.NumberType.INTEGER);
        MappedFieldType number = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);
        assertEquals(2L, input.getFieldCount("tags"));
    }
        // seed a present, zero-value list (written as an empty-but-non-null LIST cell) rather than
        assertEquals(0, pair.valueCount());
        assertNotSame(first, second);
        ParquetDocumentInput input = new ParquetDocumentInput();
        ParquetDocumentInput input = new ParquetDocumentInput();
        // or ignore_above alters the value, and buildRawKeywordValueFieldType copies the parent's
        assertEquals(List.of(), pair.getValue());
        // multi_value flag onto it, so the document input must accumulate its values too —
import java.util.List;
        assertEquals(42L, input.getRowId());
        first.setMultiValued(true);
        assertEquals(2L, input.getFieldCount("number"));
    }
        assignTestCapabilities(tags, PARQUET_FORMAT);
    public void testDeclaredMultiValueFieldWithSingleValueIsStillAList() {
        assignTestCapabilities(ft1, PARQUET_FORMAT);
        input.addField(ft2, "val");
        assertTrue(pair.isMultiValued());
        assertEquals(1L, input.getFieldCount(org.opensearch.index.mapper.IdFieldMapper.NAME));
    public void testUndeclaredKeywordPromotesWhenSecondValueArrives() {
import org.opensearch.index.mapper.NumberFieldMapper;
        populateMetadataFields(input);
        FieldValuePair pair = findPair(input, "tags");
import org.opensearch.index.mapper.KeywordFieldMapper;
        populateMetadataFields(input);
        // column type stays consistent across documents.
        MappedFieldType ft1 = new NumberFieldMapper.NumberFieldType("a", NumberFieldMapper.NumberType.INTEGER);
 * The OpenSearch Contributors require contributions made to
import org.opensearch.index.mapper.MapperParsingException;
    public void testAddFieldAndGetFinalInput() {
        MappedFieldType tags = new KeywordFieldMapper.KeywordFieldType("tags");
        expectThrows(MapperParsingException.class, () -> input.addField(valField, 20));
        );
        assertEquals(5, result.size());
        assertEquals(3, pair.valueCount());
        input.setRowId(DocumentInput.ROW_ID_FIELD, 0L);
    }
        input.addField(number, 10);
        ParquetDocumentInput input = new ParquetDocumentInput();
        assertTrue(pair.isMultiValued());
        FieldValuePair pair = findPair(input, "tags");
        input.setRowId(DocumentInput.ROW_ID_FIELD, 0L);
    private static final DataFormat PARQUET_FORMAT = new ParquetDataFormat();
        // otherwise it would reject the second value while its own column expects a list.
        // The document parser reports one addField call per array element.
        populateMetadataFields(input);
        input.setRowId(DocumentInput.ROW_ID_FIELD, 0L);
        ParquetDocumentInput input = new ParquetDocumentInput();
        tags.setMultiValued(true);
            .filter(p -> p.getFieldType().name().equals(fieldName))
    public void testDerivedSourceCompanionFieldFollowsParentState() {
        input.addField(tags, "a");
        assignTestCapabilities(valField, PARQUET_FORMAT);
        // A scalar JSON value on a declared list column still writes a one-element list, so the
        populateMetadataFields(input);
        populateMetadataFields(input);
        // being dropped, so an empty array stays distinct from an absent field in reconstructed
    }
    public void testDeclaredMultiValueFieldWithEmptyArrayIsPresentEmptyList() {
        // Metadata fields must still count as exactly one so getFinalInput's assertions hold.
    public void testCloseClearsState() {
        input.addField(second, "b");
        ParquetDocumentInput input = new ParquetDocumentInput();
        assignTestCapabilities(tags, PARQUET_FORMAT);
        populateMetadataFields(input);
            .stream()
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("age", NumberFieldMapper.NumberType.INTEGER);
        // One collected entry holding two values.
    public void testSetRowId() {
        input.addField(other, "two");
        ParquetDocumentInput input = new ParquetDocumentInput();
        MappedFieldType tags = new KeywordFieldMapper.KeywordFieldType("tags");
        populateMetadataFields(input);
        assignTestCapabilities(ft2, PARQUET_FORMAT);
        MappedFieldType tags = new KeywordFieldMapper.KeywordFieldType("tags");
    public void testMultiValueAccumulationKeyedByNameNotInstanceIdentity() {
        MapperParsingException error = expectThrows(MapperParsingException.class, () -> input.addField(number, 20));
        input.close();
        input.setRowId(DocumentInput.ROW_ID_FIELD, 0L);
        assertTrue(pair.isMultiValued());
        ParquetDocumentInput input = new ParquetDocumentInput();
        FieldValuePair pair = findPair(input, "other");
        number.setMultiValueState(MappedFieldType.MultiValueState.SCALAR);
            .findFirst()
        assignTestCapabilities(tags, PARQUET_FORMAT);
import org.opensearch.index.mapper.MappedFieldType;
import org.opensearch.parquet.engine.ParquetDataFormat;
        ParquetDocumentInput input = new ParquetDocumentInput();
        populateMetadataFields(input);
        input.addField(tags, "y");
            "both elements must accumulate into one pair",
    }
        populateMetadataFields(input);
        number.setMultiValueSupported(true);
        input.addField(tags, List.of());
        assertTrue(pair.isMultiValued());
    public void testRejectsDuplicateFieldInSingleDocument() throws Exception {
        second.setMultiValued(true);
        assertEquals(5, input.getFinalInput().size());
        assertTrue(pair.isMultiValued());
        input.addField(rawValue, "RAW-ONE");
        assertEquals(6, input.getFinalInput().size());
        // handed back a fresh wrapper per array element. Accumulation keys on the name, so both
        MappedFieldType other = new KeywordFieldMapper.KeywordFieldType("other");
        MappedFieldType ft2 = new KeywordFieldMapper.KeywordFieldType("b");
        assertTrue(pair.isMultiValued());
        assertEquals(List.of("solo"), pair.getValue());
        // The parser signals an explicit empty array ("tags": []) with an empty List value. It must
        input.setRowId(DocumentInput.ROW_ID_FIELD, 0L);
        other.setMultiValueSupported(true);
    public void testUndeclaredNumericFieldPromotesWhenSecondValueArrives() {
            1,
        assignTestCapabilities(second, PARQUET_FORMAT);
        assertTrue(input.getFinalInput().isEmpty());
    public void testDeclaredMultiValueFieldAccumulatesValuesInOrder() {
        assertEquals(2L, input.getFieldCount("other"));
        input.addField(tags, "solo");
        populateMetadataFields(input);
        input.setRowId(DocumentInput.ROW_ID_FIELD, 0L);
 */
        ParquetDocumentInput input = new ParquetDocumentInput();
    }
        assignTestCapabilities(first, PARQUET_FORMAT);
        // would silently degrade multi_value to last-value-wins).
    public void testMultipleFields() {
        assertSame(ft, result.getFirst().getFieldType());
        assignTestCapabilities(ft, PARQUET_FORMAT);
        populateMetadataFields(input);
        tags.setMultiValued(true);
        // KeywordFieldMapper emits "_ignored_source.<field>" alongside the parent when a normalizer
 * this file be licensed under the Apache-2.0 license or a
        FieldValuePair pair = findPair(input, "tags");
        input.setRowId(DocumentInput.ROW_ID_FIELD, 0L);
        assertEquals(List.of(10, 20), pair.getValue());
        assertEquals(List.of("b", "a", "b"), pair.getValue());
        // derived _source, so they must not be sorted or deduplicated.
        input.setRowId(DocumentInput.ROW_ID_FIELD, 0L);
        ParquetDocumentInput input = new ParquetDocumentInput();
package org.opensearch.parquet.writer;
        ParquetDocumentInput input = new ParquetDocumentInput();
        input.addField(tags, "x");
        assertEquals(0L, input.getFieldCount("tags"));
    }
        assertThat(error.getMessage(), org.hamcrest.Matchers.containsString("locked scalar by [multi_value: false]"));
        ParquetDocumentInput input = new ParquetDocumentInput();
    }
        // elements must land in the SAME list rather than the second creating a new pair (which
        input.addField(number, 10);
 * SPDX-License-Identifier: Apache-2.0
        assignTestCapabilities(other, PARQUET_FORMAT);
        tags.setMultiValued(true);
        MappedFieldType number = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);
        assertEquals(
    }
 *
        input.addField(first, "a");
    }
import org.opensearch.parquet.ParquetBaseTests;
    }
        assertEquals(25, result.getFirst().getValue());
    public void testExplicitSingleFieldRejectsSecondValue() {
        assignTestCapabilities(number, PARQUET_FORMAT);
        assertEquals(5, input.getFinalInput().size());
        populateMetadataFields(input);
        assignTestCapabilities(ft, PARQUET_FORMAT);
        assertEquals(4, input.getFinalInput().size());
        input.addField(ft1, 1);
        ParquetDocumentInput input = new ParquetDocumentInput();
        FieldValuePair pair = findPair(input, "_ignored_source.tags");
 * compatible open source license.
        assignTestCapabilities(number, PARQUET_FORMAT);
        // _source.
        input.setRowId(DocumentInput.ROW_ID_FIELD, 0L);
    }
        rawValue.setMultiValued(true);
