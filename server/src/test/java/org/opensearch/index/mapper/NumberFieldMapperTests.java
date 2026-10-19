        assertFalse("existing field's value should be preserved across the update", mapperService.fieldType("field").isSearchable());  
import org.apache.lucene.sandbox.document.HalfFloatPoint;  
package org.opensearch.index.mapper;
                try (DirectoryReader reader = DirectoryReader.open(directory)) {
        int decoded = IntPoint.decodeDimension(encoded, 0);
        NumberFieldMapper mapper = getMapper(NumberFieldMapper.NumberType.HALF_FLOAT, copyTo, true, true);
        );
            OutOfRangeSpec.of(NumberType.INTEGER, -2147483649L, " out of range of `int`"),  
                    iw.addDocument(createDocument(type, List.of(value), true));
        decoded = HalfFloatPoint.decodeDimension(encoded, 0);
 * software distributed under the License is distributed on an
        assertThat(e.getMessage(), containsString("cannot cover: [POINT_RANGE]"));
            }
        return Set.of("byte", "short", "integer", "long", "float", "double", "half_float", "unsigned_long");  
                }
    public void testFloatFieldDerivedValueFetching_DocValues() throws IOException {  
            OutOfRangeSpec.of(NumberType.FLOAT, "3.4028235E39", "[float] supports only finite values"),
        assertEquals(Byte.MAX_VALUE, decoded);
        decoded = LongPoint.decodeDimension(encoded, 0);
        for (NumberType type : fieldTypes) {
        assertTrue("Expected long value 123456789", found);  
        decoded = BigIntegerPoint.decodeDimension(encoded, 0);
                case SHORT:  
        CapturingDocumentInput docInput = new CapturingDocumentInput();
        return mapper;  
            try (DirectoryReader reader = DirectoryReader.open(directory)) {  
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
                assertArrayEquals(new String[] { "field" }, TermVectorsService.getValues(doc.rootDoc().getFields("_ignored")));
        }
    protected Collection<? extends Plugin> getPlugins() {
        String fieldName,
        encoded = type.encodePoint(100.5f, false);
                case HALF_FLOAT:
            MapperParsingException.class,
            pluggableSettings,
    private static final String FIELD_NAME = "field";
                NumberFieldMapper mapper = getMapper(type, FieldMapper.CopyTo.empty(), true, false);
            OutOfRangeSpec.of(NumberType.BYTE, "-129", "is out of range for a byte"),  
        byte[] encoded = type.encodePoint(-100, true);
        assertEquals(BigInteger.valueOf(101L), decoded);
    /** Indices that do not use a pluggable dataformat keep the standard {@code index: true} default. */
        }  
                minimalMapping(b);
        assertTrue("Zero roundUp should be positive", decoded > 0.0f);  
        // Test roundUp = true
                }
                try (DirectoryReader reader = DirectoryReader.open(directory)) {
        SourceToParse source = source(b -> b.nullField("field"));  
        assertEquals(2, fields.length);  
        assertEquals(123, pointField.numericValue().doubleValue(), 0d);  
    }  
        IndexableField[] fields = doc.rootDoc().getFields("field");
        MapperService mapperService = createMapperService(fieldMapping(b -> {
        boolean found = docInput.getCapturedFields()
        assertEquals(maxUnsignedLong, decoded); // Can't increment
            FIELD_NAME,
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        // Test edge cases  
        if (type.equalsIgnoreCase("unsigned_long")) {
                    e.getCause().getMessage(),  
                b.field("index", true);
                float value = 1.5f;
            fieldMapping(b -> b.field("type", numberType.typeName()).field("store", isStored).field("doc_values", hasDocValues))
                    assertEquals("{\"" + FIELD_NAME + "\":" + value + "}", source);  
import org.apache.lucene.store.Directory;
    public void testPossibleToDeriveSource_WhenCopyToPresent() throws IOException {  
        assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());  
import java.io.IOException;
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
    @Override  
        }
                    case FLOAT:
        long decoded = LongPoint.decodeDimension(encoded, 0);
        assertEquals(99, decoded);
        IndexableField[] fields = doc.rootDoc().getFields("field");
                mapper.parse(source(item::write));
                    iw.addDocument(createDocument(type, List.of(value), true));
            long value2 = Long.MIN_VALUE;
        Settings settings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();  
                float value = 1.5f;
        IndexableField[] fields = doc.rootDoc().getFields("field");
            assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());  
        decoded = LongPoint.decodeDimension(encoded, 0);  
    }
        encoded = type.encodePoint(100.7f, true);
import org.opensearch.common.CheckedConsumer;  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
                iw.addDocument(createDocument(NumberType.LONG, List.of(value1, value2, value1), true));  
        assertTrue(storedField.fieldType().stored());
        IndexableField storedField = fields[2];
                if (malformedValue instanceof String) {  
    public void doTestCoerce(String type) throws IOException {  
        byte[] encoded = type.encodePoint(100.7, true);  
        );
        // The 'unsigned_long' is stored as a string  
                XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
            .stream()  
                            new SortedNumericDocValuesField(
                }
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", type)));
        checker.registerUpdateCheck(
            NumberFieldMapper mapper = getMapper(NumberType.UNSIGNED_LONG, FieldMapper.CopyTo.empty(), true, false);  
        if (expectedValue == null) {  
            OutOfRangeSpec.of(NumberType.DOUBLE, Double.POSITIVE_INFINITY, "[double] supports only finite values"),  
import org.opensearch.common.util.FeatureFlags;  
        // Test roundUp = false  
        IndexableField pointField = fields[0];  
 * SPDX-License-Identifier: Apache-2.0
            try {  
                    mapper.deriveSource(builder, reader.leaves().get(0).reader(), 0);  
    public void testLongFieldDerivedValueFetchingMultiValue_DocValues() throws IOException {  
        DocumentMapper mapper = createDocumentMapper(
        if (hasDocValues) {
    @Override
            minimalMapping(b);  
    protected void minimalMapping(XContentBuilder b) throws IOException {  
        assertTrue("Expected integer value 42", found);
                        break;  
    public void testOutOfRangeValues() throws IOException {  
        // Test roundUp = false  
                    case HALF_FLOAT:
        } else {
    public void testNonPluggableDataFormatKeepsIndexTrue() throws IOException {  
        IndexableField pointField = fields[0];
                    break;
    public void testPossibleToDeriveSource_WhenDocValuesAndStoredDisabled() throws IOException {
        encoded = type.encodePoint(Long.MAX_VALUE, true);
import org.opensearch.index.mapper.NumberFieldMapper.NumberType;  
            OutOfRangeSpec.of(NumberType.BYTE, "128", "is out of range for a byte"),
    public void testUnsignedLongFieldDerivedValueFetchingMultiValue_DocValues() throws IOException {
        assertEquals(101L, decoded);
        assertNumericLuceneAndPluggablePathsEquivalent(
        DocumentMapper pluggableMapper = createDocumentMapper(pluggableSettings, mappingBuilder);
                    break;
        decoded = DoublePoint.decodeDimension(encoded, 0);
                MapperParsingException e = expectThrows(MapperParsingException.class, () -> notIgnoring.parse(source));
            pluggableSettings,
        NumberFieldMapper mapper = getMapper(NumberFieldMapper.NumberType.HALF_FLOAT, FieldMapper.CopyTo.empty(), false, false);
            mapping(b -> b.startObject(FIELD_NAME).field("type", "integer").endObject()),  
        // Scenario 1: integer value  
            boolean pluggableFound = docInput.getCapturedFields()
                fieldMapping(b -> b.field("type", type).field("index", false).field("skip_list", true))
            .put("index.pluggable.dataformat", MockDocValuesDataFormatPlugin.FORMAT_NAME)
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "7.89")));
        }));  
}  
        for (OutOfRangeSpec item : inputs) {
            }))  
                NumberFieldMapper mapper = getMapper(type, FieldMapper.CopyTo.empty(), false, true);
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "123")));
        encoded = type.encodePoint(-100, false);
                    String source = builder.toString();
        assertEquals(101, decoded); // 100.7 coerced to 100, then incremented  
                    mapper.deriveSource(builder, reader.leaves().get(0).reader(), 0);  
                    case UNSIGNED_LONG:  
        IndexableField[] fields = doc.rootDoc().getFields("field");
    public void testCoercionBehavior() {
                    String source = builder.toString();
 * compatible open source license.
            DocumentMapper mapper = createDocumentMapper(
        NumberType[] fieldTypes = { NumberType.LONG, NumberType.UNSIGNED_LONG };
        double decoded = DoublePoint.decodeDimension(encoded, 0);
            OutOfRangeSpec.of(NumberType.FLOAT, "-3.4028235E39", "[float] supports only finite values"),  
        DocumentMapper mapper = createDocumentMapper(mapping);  
        assertEquals(FloatPoint.nextDown(100.5f), decoded, 0.0f);  
    }
                            )
        assertEquals(1, fields.length);  
        IndexableField[] fields = doc.rootDoc().getFields("field");  
    public void testLongIndexingOutOfRange() throws Exception {
        return Set.of("byte", "short", "integer", "long", "unsigned_long");
            for (final Number value : values) {
            pluggableSettings,
                int value = 123;
    @Override  
                try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {  
            assertTrue("Pluggable path should capture field '" + fieldName + "' with value '" + expectedValue + "'", pluggableFound);
import org.apache.lucene.index.DocValuesType;
            BigInteger value2 = new BigInteger("9223372036854775808");
    }
        try (Directory directory = newDirectory()) {
    /** A mapping update that sets index:true on a new field is rejected on a pluggable data format index. */  
        // the following two strings are in-range for a long after coercion  
        // Test negative numbers for integer types
        }  
                    case LONG:  
                    case INTEGER:  
        assertNumericLuceneAndPluggablePathsEquivalent(
        boolean found = docInput.getCapturedFields()
                    doc.add(new StoredField(FIELD_NAME, value.longValue()));
        assertEquals(DocValuesSkipIndexType.NONE, dvField.fieldType().docValuesSkipIndexType());
     */
        assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());
            .put("index.pluggable.dataformat.enabled", true)
                    assertEquals("{\"" + FIELD_NAME + "\":" + value + "}", source);  
                }
     * On a pluggable-dataformat index no BKD points are written for numeric fields, so {@code index}
                mapper.deriveSource(builder, reader.leaves().get(0).reader(), 0);  
                        break;
    @Override
            mapping(b -> b.startObject(FIELD_NAME).field("type", "integer").endObject())  
                case INTEGER:
        encoded = type.encodePoint("123.45", true);
        assertTrue("Should round up", decoded > 100.5f);
            OutOfRangeSpec.of(NumberType.HALF_FLOAT, Float.POSITIVE_INFINITY, "[half_float] supports only finite values"),
                }
                        doc.add(new SortedNumericDocValuesField(FIELD_NAME, value.longValue()));
import static org.hamcrest.Matchers.containsString;
            OutOfRangeSpec.of(NumberType.DOUBLE, "-1.7976931348623157E309", "[double] supports only finite values"),
        );
                }
    }  
    }
            try (DirectoryReader reader = DirectoryReader.open(directory)) {
        })));  
        assertEquals(Short.MAX_VALUE, decoded);  
                long value = (1L << 53) + randomLongBetween(0L, 1L << 20);
                        doc.add(new SortedNumericDocValuesField(FIELD_NAME, NumericUtils.doubleToSortableLong(value.doubleValue())));
            .anyMatch(e -> e.getKey().name().equals(FIELD_NAME) && e.getValue().equals(3.14));  
    }  
        );
 * Licensed to Elasticsearch under one or more contributor  
        checker.registerUpdateCheck(b -> b.field("coerce", false), m -> assertFalse(((NumberFieldMapper) m).coerce()));
                case UNSIGNED_LONG:
        Settings pluggableSettings,
        IndexableField[] fields = doc.rootDoc().getFields("field");
import org.apache.lucene.document.IntPoint;
import org.opensearch.index.mapper.NumberFieldTypeTests.OutOfRangeSpec;
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
            try (Directory directory = newDirectory()) {  
        assertNumericLuceneAndPluggablePathsEquivalent(
        IndexableField[] luceneFields = luceneDoc.rootDoc().getFields(fieldName);
                        doc.add(
        assertEquals(Integer.MAX_VALUE, decoded); // Can't increment  
                        break;  
        ParsedDocument doc = mapper.parse(source);
 * You may obtain a copy of the License at  
import java.util.List;  
            b.field("index", false);
    }
import java.util.Set;
        mapper = createDocumentMapper(fieldMapping(b -> b.field("type", type).field("null_value", missing)));
                    iw.addDocument(createDocument(type, List.of(value), false));
            assertTrue("Lucene path should produce field '" + fieldName + "'", luceneFields.length > 0);
        decoded = BigIntegerPoint.decodeDimension(encoded, 0);
        // Scenario 3: double value  
        MapperService mapperService = createMapperService(fieldMapping(this::minimalMapping));
            } catch (MapperParsingException e) {  
    public void testExistsQueryDocValuesDisabled() throws IOException {  
    }
 * the Apache License, Version 2.0 (the "License"); you may
        // Add doc values field  
        assertEquals(101, decoded);  
        byte[] encoded = type.encodePoint(100.5f, true);  
import org.apache.lucene.document.StoredField;
            }  
import org.apache.lucene.document.LongPoint;
    }
        byte[] encoded = type.encodePoint((byte) 100, true);
            b.startObject("field2");
                } else {
        DocumentMapper mapper = createDocumentMapper(
        checker.registerConflictCheck("store", b -> b.field("store", true));
        assertEquals(Byte.MIN_VALUE, decoded);
                    case DOUBLE:
            OutOfRangeSpec.of(NumberType.FLOAT, Float.POSITIVE_INFINITY, "[float] supports only finite values"),
                    break;  
    }  
            OutOfRangeSpec.of(NumberType.SHORT, -32769, "out of range of `short`"),
            OutOfRangeSpec.of(NumberType.DOUBLE, Double.NaN, "[double] supports only finite values"),
    public void testNegativeNumberHandling() {  
            OutOfRangeSpec.of(NumberType.UNSIGNED_LONG, new BigInteger("18446744073709551616"), "out of range for an unsigned long"),
public class NumberFieldMapperTests extends AbstractNumericFieldMapperTestCase {  
        NumberFieldMapper.NumberType type = NumberFieldMapper.NumberType.SHORT;  
    public void doTestStore(String type) throws Exception {
        // Lucene path
        assertExistsQuery(mapperService);
            assertEquals(DocValuesSkipIndexType.RANGE, dvField.fieldType().docValuesSkipIndexType());
            assertFalse("Pluggable path should produce no field for '" + fieldName + "'", pluggableHasField);  
        NumberFieldMapper.NumberType type = NumberFieldMapper.NumberType.INTEGER;
        // Test roundUp = false
        mapper.parse(source(b -> b.field(FIELD_NAME, 42)), docInput);  
    }
            .build();  
    public void testDoubleEncodePoint() {  
        assertFalse(dvField.fieldType().stored());
 *
            OutOfRangeSpec.of(NumberType.LONG, "9223372036854775808", "out of range for a long"),
                case BYTE:
                assertThat(
        encoded = type.encodePoint(Short.MAX_VALUE, true);
        );
 * this file be licensed under the Apache-2.0 license or a
    public void testPluggableDataFormatDefaultsIndexToFalse() throws IOException {  
        encoded = type.encodePoint(BigInteger.valueOf(100L), false);
                ParsedDocument doc = ignoring.parse(source);
            b.endObject();
                    doc.add(new StoredField(FIELD_NAME, value.floatValue()));  
                    builder.endObject();
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
    /**  
    public void testHalfFloatEncodePoint() {  
        assertFalse(mapperService.fieldType("field").isSearchable());  
    }
            OutOfRangeSpec.of(NumberType.LONG, new BigInteger("9223372036854775808"), "out of range of `long`"),
    }  
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "9223372036854775807.9")));
        }  
        assertTrue(explicit.fieldType("field").isSearchable());
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
        for (NumberType type : floatTypes) {
            pluggableSettings,
        decoded = LongPoint.decodeDimension(encoded, 0);  
import java.util.Arrays;
            .anyMatch(e -> e.getKey().name().equals(FIELD_NAME) && e.getValue().equals(123456789L));
        assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());
        assertFalse(mapperService.fieldType("field").isSearchable());
                    builder.endObject();
        );
        // Test roundUp = true
            try (Directory directory = newDirectory()) {  
    @Override
    }
    }
import org.apache.lucene.util.NumericUtils;
            switch (type) {  
        IndexableField pointField = fields[0];
                    doc.add(new StoredField(FIELD_NAME, value.intValue()));
        checker.registerConflictCheck("doc_values", b -> b.field("doc_values", false));  
                    case SHORT:
    public void testFloatEncodePoint() {  
        }
    public void testUnsignedLongEncodePoint() {  
        // Test roundUp = true
            long value1 = Integer.MAX_VALUE;
            }
        NumberType[] floatTypes = { NumberType.FLOAT, NumberType.HALF_FLOAT, NumberType.DOUBLE };
            }
 * GitHub history for details.
import org.apache.lucene.index.IndexableField;
            FIELD_NAME,
        assertTrue("Should round down", decoded < 100.5f);  
            mapping(b -> b.startObject(FIELD_NAME).field("type", "long").endObject()),  
    public void testFloatFieldDerivedValueFetching_StoredField() throws IOException {  
                    mapper.deriveSource(builder, reader.leaves().get(0).reader(), 0);  
        assertEquals(1, pointField.fieldType().pointIndexDimensionCount());
        }));
        assertEquals(2, fields.length);
import java.util.Collection;
    }
                    assertThat(e.getCause().getMessage(), containsString("Current token"));  
                    break;  
        }  
    protected Set<String> types() {
    public void testPluggableDataFormatIntegerValue() throws Exception {
        assertThrows(UnsupportedOperationException.class, mapper::canDeriveSource);  
        MapperService mapperService = createMapperService(pluggableSettings(), fieldMapping(this::minimalMapping));
        FieldMapper.CopyTo copyTo = new FieldMapper.CopyTo.Builder().add("copy_to_field").build();
        byte[] encoded = type.encodePoint(100L, true);  
        assertTrue("Expected double value 3.14", found);
        NumberFieldMapper mapper = (NumberFieldMapper) mapperService.documentMapper().mappers().getMapper(FIELD_NAME);
                try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {  
import org.opensearch.common.settings.Settings;
        MapperService explicit = createMapperService(fieldMapping(b -> {
                    break;  
        assertEquals(new BigInteger("18446744073709551615"), decoded);
        assertEquals(1, pointField.fieldType().pointIndexDimensionCount());
                    XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
                int value = 123;
                XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
            DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", item.type.typeName())));
        assertEquals(Integer.MIN_VALUE, decoded); // Can't decrement  
        encoded = type.encodePoint(100.5f, false);
    /** An explicit {@code index: false} is accepted on a pluggable-dataformat index. */
    public void testIntegerEncodePoint() {  
        decoded = IntPoint.decodeDimension(encoded, 0);
     * doc-values column instead of an empty point index.  
        DocumentMapper mapper = createDocumentMapper(
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "long").field("ignore_malformed", true)));  
import org.opensearch.core.xcontent.XContentBuilder;
        NumberFieldMapper.NumberType type = NumberFieldMapper.NumberType.LONG;
/*  
        MapperService mapperService = createMapperService(pluggableSettings(), fieldMapping(this::minimalMapping));  
            assertEquals(1, fields.length);
import org.apache.lucene.sandbox.document.BigIntegerPoint;
    public void testByteEncodePoint() {
import org.opensearch.index.termvectors.TermVectorsService;
            try (Directory directory = newDirectory()) {  
            b -> b.field("ignore_malformed", true),  
    protected void registerParameters(ParameterChecker checker) throws IOException {
            OutOfRangeSpec.of(NumberType.DOUBLE, "1.7976931348623157E309", "[double] supports only finite values"),  
                try (DirectoryReader reader = DirectoryReader.open(directory)) {
                try (DirectoryReader reader = DirectoryReader.open(directory)) {
    private void assertNumericLuceneAndPluggablePathsEquivalent(
 * KIND, either express or implied.  See the License for the
        assertEquals(DoublePoint.nextDown(100.5), decoded, 0.0);  
        return Settings.builder()  
            .stream()
                    assertThat(e.getCause().getMessage(), containsString("not numeric, cannot use numeric value accessors"));
            b.field("index", true);
    protected void doTestDecimalCoerce(String type) throws IOException {  
    }  
        // Test roundUp = true
        assertEquals(0, doc.rootDoc().getFields("field").length);
                    doc.add(new StoredField(FIELD_NAME, value.doubleValue()));  
        assertEquals(123, pointField.numericValue().doubleValue(), 0d);  
        pluggableMapper.parse(source(sourceBuilder), docInput);
        assertEquals(1, pointField.fieldType().pointIndexDimensionCount());
        // Test roundUp = true
        IndexableField pointField = fields[0];  
        encoded = type.encodePoint(Byte.MIN_VALUE, false);  
    }  
        assertFalse("newly added field should default to not-indexed", mapperService.fieldType("field2").isSearchable());
     * Helper method to create a document with both doc values and stored fields
        int decoded = IntPoint.decodeDimension(encoded, 0);
import org.apache.lucene.index.DocValuesSkipIndexType;  
        Number expectedValue  
            b.startObject("field2");  
                NumberFieldMapper mapper = getMapper(type, FieldMapper.CopyTo.empty(), false, true);
        DocumentMapper mapper2 = createDocumentMapper(fieldMapping(b -> b.field("type", type).field("coerce", false)));  
            m -> assertTrue(((NumberFieldMapper) m).ignoreMalformed().value())
 */
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", type).field("index", false)));
            OutOfRangeSpec.of(NumberType.FLOAT, Float.NaN, "[float] supports only finite values"),
        // Test edge cases
    @Override  
            OutOfRangeSpec.of(NumberType.LONG, "-1e999999999", "out of range for a long"),
        float decoded = FloatPoint.decodeDimension(encoded, 0);
            minimalMapping(b);  
        assertFalse(docInput.getCapturedFields().stream().anyMatch(e -> e.getKey().name().equals(FIELD_NAME)));
                    builder.endObject();
import org.apache.lucene.document.Document;
        ParsedDocument doc = mapper.parse(
            );  
    public void testPluggableDataFormatNullValueSkipped() throws Exception {
        decoded = HalfFloatPoint.decodeDimension(encoded, 0);
import org.opensearch.common.xcontent.XContentFactory;
    }
    protected void writeFieldValue(XContentBuilder builder) throws IOException {
import java.math.BigInteger;  
        assertFalse(pointField.fieldType().stored());  
        CapturingDocumentInput docInput = new CapturingDocumentInput();  
                SourceToParse source = source(b -> b.field("field", malformedValue));
            OutOfRangeSpec.of(NumberType.LONG, "1e999999999", "out of range for a long"),  
                }
                    doc.add(new StoredField(FIELD_NAME, value.toString()));
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> mapper2.parse(source(b -> b.field("field", "123"))));
                try (DirectoryReader reader = DirectoryReader.open(directory)) {
    }
            OutOfRangeSpec.of(NumberType.INTEGER, "2147483648", "is out of range for an integer"),
    }
        assertNumericLuceneAndPluggablePathsEquivalent(
        byte[] encoded = type.encodePoint(100.5, true);  
            123456789L  
        NumberFieldMapper.NumberType type = NumberFieldMapper.NumberType.BYTE;
        encoded = type.encodePoint("123.456789", true);
                                FIELD_NAME,  
        encoded = type.encodePoint("9223372036854775806", true);
                mapper.deriveSource(builder, reader.leaves().get(0).reader(), 0);
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)  
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> merge(mapperService, mapping(b -> {
        doc = mapper.parse(source);  
            b -> b.field(FIELD_NAME, 123456789L),
        // Test that decimal values are properly coerced for integer types  
        decoded = IntPoint.decodeDimension(encoded, 0);  
        decoded = FloatPoint.decodeDimension(encoded, 0);
        IndexableField dvField = fields[1];
import static org.hamcrest.Matchers.arrayWithSize;  
        for (NumberType type : floatTypes) {
        assertEquals(mapping.toString(), mapper.mappingSource().toString());
        );
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", 123)));  
    @Override
                try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {  
    public void testShortEncodePoint() {
        CheckedConsumer<XContentBuilder, IOException> sourceBuilder,
     * index is written — so the mapping is rejected rather than silently producing a field whose
        for (NumberType type : fieldTypes) {
                    assertEquals("{\"" + FIELD_NAME + "\":" + value + "}", source);  
        assertEquals(3, fields.length);  
            OutOfRangeSpec.of(NumberType.SHORT, 32768, "out of range of `short`"),
    }  
    }
        for (String type : types()) {  
            OutOfRangeSpec.of(NumberType.SHORT, "-32769", "is out of range for a short"),
        IndexableField dvField = fields[1];
        NumberFieldMapper.NumberType type = NumberFieldMapper.NumberType.LONG;
        NumberFieldMapper.NumberType type = NumberFieldMapper.NumberType.DOUBLE;
            42  
                .anyMatch(e -> e.getKey().name().equals(fieldName) && e.getValue().equals(expectedValue));
        );  
        encoded = type.encodePoint(100.3, false);
        NumberFieldMapper.NumberType type = NumberFieldMapper.NumberType.HALF_FLOAT;
                case FLOAT:
     * An explicit {@code index: true} cannot be honoured on a pluggable-dataformat index — no point
                    assertThat(e.getCause().getMessage(), containsString("For input string: \"a\""));
import org.apache.lucene.document.DoublePoint;
        decoded = IntPoint.decodeDimension(encoded, 0);
            OutOfRangeSpec.of(NumberType.UNSIGNED_LONG, new BigInteger("-1"), "out of range for an unsigned long"),
import org.apache.lucene.index.IndexWriter;
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", type)));
    }
        assertEquals(-101, decoded);
    }
        assertFalse(pointField.fieldType().stored());
    public void testIntFieldDerivedValueFetching_StoredField() throws IOException {  
            OutOfRangeSpec.of(NumberType.HALF_FLOAT, "-65520", "[half_float] supports only finite values"),
    public void testPluggableDataFormatDoubleValue() throws Exception {
 * The OpenSearch Contributors require contributions made to  
        }  
        // Test roundUp = true
        // Test roundUp = false  
                NumberFieldMapper mapper = getMapper(type, FieldMapper.CopyTo.empty(), true, false);
        // Scenario 2: long value  
                        break;
        for (NumberType type : floatTypes) {
        encoded = type.encodePoint(100.5, false);
        mapper.parse(source(b -> b.nullField(FIELD_NAME)), docInput);  
        IndexableField pointField = fields[0];
        try (Directory directory = newDirectory()) {
        decoded = LongPoint.decodeDimension(encoded, 0);
        // Test roundUp = false
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        );
        checker.registerConflictCheck("null_value", b -> b.field("null_value", 1));  
    public void doTestNoDocValues(String type) throws Exception {
                try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {  
            minimalMapping(b);
            OutOfRangeSpec.of(NumberType.BYTE, -129, "is out of range for a byte"),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }
        assertEquals(101, decoded);
        MapperService mapperService = createMapperService(pluggableSettings(), fieldMapping(b -> {
        decoded = IntPoint.decodeDimension(encoded, 0);
        assertThat(e.getMessage(), containsString("cannot cover: [POINT_RANGE]"));
        builder.value(123);  
    }
        }));
        BigInteger decoded = BigIntegerPoint.decodeDimension(encoded, 0);
 */  
    @Override  
    }
                }
        NumberType[] fieldTypes = { NumberType.INTEGER, NumberType.SHORT, NumberType.BYTE };
        final List<OutOfRangeSpec> inputs = Arrays.asList(
        assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());
 *
        decoded = IntPoint.decodeDimension(encoded, 0);
        // Test roundUp = false  
        // Scenario 4: null value — no field produced  
                }
import org.apache.lucene.document.SortedNumericDocValuesField;  
        assertEquals(DocValuesSkipIndexType.NONE, dvField.fieldType().docValuesSkipIndexType());  
                case DOUBLE:
            () -> createMapperService(pluggableSettings(), fieldMapping(b -> {  
                assertEquals(0, fields.length);  
    }
        throws IOException {  
        assertThrows(UnsupportedOperationException.class, mapper::canDeriveSource);  
    @Override  
 *  
        // 100.7 should be coerced to 100, then incremented to 101
        decoded = IntPoint.decodeDimension(encoded, 0);  
        // Test roundUp = true  
                String source = builder.toString();
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", 123)));  
        // Test roundUp = true
import org.opensearch.core.xcontent.MediaTypeRegistry;  
            }  
    public void testPluggableDataFormatMappingUpdateRejectsIndexTrue() throws IOException {
            mapping(b -> b.startObject(FIELD_NAME).field("type", "double").endObject()),  
     * queries match nothing.  
    private static Settings pluggableSettings() {
        return List.of(new MockDocValuesDataFormatPlugin());
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
        encoded = type.encodePoint(maxUnsignedLong, true);  
                );
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", 123)));  
                }
     * A field added by a later mapping update also defaults to not-indexed, and the update leaves the  
        MapperService mapperService = createMapperService(
            assertEquals(123, new BigInteger(storedField.stringValue()).longValue());
            mapping(b -> b.startObject(FIELD_NAME).field("type", "integer").endObject())  
    protected Set<String> wholeTypes() {
        float decoded = HalfFloatPoint.decodeDimension(encoded, 0);
        assertEquals(FloatPoint.nextUp(100.5f), decoded, 0.0f);
            }  
        }  
        CapturingDocumentInput docInput = new CapturingDocumentInput();  
            DocumentMapper ignoring = createDocumentMapper(fieldMapping(b -> b.field("type", type).field("ignore_malformed", true)));
    }
            b -> b.nullField(FIELD_NAME),
            mapping(b -> b.startObject(FIELD_NAME).field("type", "integer").endObject()),  
        // Add stored field
                        break;  
                assertEquals("{\"" + FIELD_NAME + "\":[" + value2 + "," + value1 + "," + value1 + "]}", source);
    ) throws IOException {
        assertEquals(DoublePoint.nextUp(100.5), decoded, 0.0);
            OutOfRangeSpec.of(NumberType.UNSIGNED_LONG, "18446744073709551616", "out of range for an unsigned long"),
        assertEquals(-99, decoded);  
                }
        assertEquals(7, pointField.numericValue().doubleValue(), 0d);
                    builder.endObject();
            NumberFieldMapper mapper = getMapper(NumberType.LONG, FieldMapper.CopyTo.empty(), true, false);
                NumberFieldMapper mapper = getMapper(type, FieldMapper.CopyTo.empty(), true, false);
            FIELD_NAME,
    public void testPluggableDataFormatAcceptsExplicitIndexFalse() throws IOException {
        assertThat(doc.rootDoc().getFields("field"), arrayWithSize(2));
        ParsedDocument luceneDoc = luceneMapper.parse(source(sourceBuilder));
        );  
            pluggableSettings,
            long value1 = Integer.MAX_VALUE;  
            OutOfRangeSpec.of(NumberType.HALF_FLOAT, Float.NEGATIVE_INFINITY, "[half_float] supports only finite values"),
        );
                iw.addDocument(createDocument(NumberType.UNSIGNED_LONG, List.of(value2.longValue(), value1, value2.longValue()), true));
        assertEquals(101, decoded);
    }
    public void doTestDefaults(String type) throws Exception {
        DocumentMapper mapper = createDocumentMapper(  
 * license agreements. See the NOTICE file distributed with
        assertParseMinimalWarnings();  
            assertEquals(expectedValue.doubleValue(), luceneFields[0].numericValue().doubleValue(), 0.001d);  
        boolean found = docInput.getCapturedFields()  
    }
    public void testLongFieldDerivedValueFetching_DocValues() throws IOException {  
                    iw.addDocument(createDocument(type, List.of(value), false));
                    assertEquals("{\"" + FIELD_NAME + "\":" + value + "}", source);  
        CapturingDocumentInput docInput = new CapturingDocumentInput();
        encoded = type.encodePoint(Byte.MAX_VALUE, true);  
        IndexableField[] fields = doc.rootDoc().getFields("field");
        assertTrue("String parsing should work", decoded > 123.45f);  
            OutOfRangeSpec.of(NumberType.UNSIGNED_LONG, "-1", "out of range for an unsigned long"),
     * value of the already-mapped field unchanged.
    public void testPluggableDataFormatRejectsExplicitIndexTrue() {  
            pluggableSettings,
                fail("Mapper parsing exception expected for [" + item.type + "] with value [" + item.value + "]");
            OutOfRangeSpec.of(NumberType.INTEGER, "-2147483649", "is out of range for an integer"),
                    String source = builder.toString();
                    XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
    public void testSkipList() throws IOException {
            OutOfRangeSpec.of(NumberType.HALF_FLOAT, Float.NaN, "[half_float] supports only finite values"),  
        assertEquals(99, decoded);  
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", type).field("doc_values", false)));
        NumberFieldMapper.NumberType type = NumberFieldMapper.NumberType.UNSIGNED_LONG;
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();  
 * not use this file except in compliance with the License.
        assertEquals(1, fields.length);  
        decoded = IntPoint.decodeDimension(encoded, 0);
        int decoded = IntPoint.decodeDimension(encoded, 0);
            source(b -> b.rawField("field", new BytesArray("9223372036854775808").streamInput(), MediaTypeRegistry.JSON))
    private Document createDocument(NumberFieldMapper.NumberType type, List<Number> values, boolean hasDocValues) {  
        encoded = type.encodePoint("18446744073709551614", true);  
        assertThat(e.getCause().getMessage(), containsString("passed as String"));
        BigInteger maxUnsignedLong = Numbers.MAX_UNSIGNED_LONG_VALUE;
    }
    /**
                String source = builder.toString();
        }
            minimalMapping(b);
            b.field("index", true);  
     */
            mapping(b -> b.startObject(FIELD_NAME).field("type", "double").endObject())
        byte[] encoded = type.encodePoint(100, true);  
        MapperParsingException e = expectThrows(
                builder.endObject();
            .anyMatch(e -> e.getKey().name().equals(FIELD_NAME) && e.getValue().equals(42));
        Object missing = Arrays.asList("float", "double", "half_float").contains(type) ? 123d : 123L;
                    iw.addDocument(createDocument(type, List.of(value), true));
        mapper.parse(source(b -> b.field(FIELD_NAME, 123456789L)), docInput);
                }
            OutOfRangeSpec.of(NumberType.HALF_FLOAT, "65520", "[half_float] supports only finite values"),
            }
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "long")));
    private NumberFieldMapper getMapper(NumberType numberType, FieldMapper.CopyTo copyTo, boolean hasDocValues, boolean isStored)
        XContentBuilder mappingBuilder,  
        assertFalse(mapperService.fieldType("field").isSearchable());  
 * ownership. Elasticsearch licenses this file to you under  
        encoded = type.encodePoint((short) 100, false);  
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
    public void testPluggablePathEquivalenceWithLucenePath() throws Exception {  
    @Override  
        assertTrue("String parsing should work", decoded > 123.456789);  
                        break;
        Document doc = new Document();
            3.14  
        merge(mapperService, mapping(b -> {
        XContentBuilder mapping = fieldMapping(b -> b.field("type", type));
        decoded = IntPoint.decodeDimension(encoded, 0);
                        );  
                    String source = builder.toString();
import org.apache.lucene.index.IndexWriterConfig;  
            IndexableField dvField = fields[0];
        encoded = type.encodePoint(Integer.MIN_VALUE, false);
        assertFalse(dvField.fieldType().stored());  
            DocumentMapper notIgnoring = createDocumentMapper(fieldMapping(b -> b.field("type", type)));
    public void testIntFieldDerivedValueFetching_DocValues() throws IOException {  
    }
    @Override  
                    String source = builder.toString();
        long decoded = LongPoint.decodeDimension(encoded, 0);
/*  
            FIELD_NAME,
        NumberType[] floatTypes = { NumberType.FLOAT, NumberType.HALF_FLOAT, NumberType.DOUBLE };
            b -> b.field(FIELD_NAME, 3.14),
    public void testPluggableDataFormatMappingUpdateDefaultsNewFieldToNotIndexed() throws IOException {
        assertEquals(99, decoded);
                switch (type) {  
        DocumentMapper luceneMapper = createDocumentMapper(mappingBuilder);  
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        int decoded = IntPoint.decodeDimension(encoded, 0);  
            OutOfRangeSpec.of(NumberType.LONG, new BigInteger("-9223372036854775809"), "out of range of `long`"),
        IndexableField dvField = fields[1];
                    assertEquals("{\"" + FIELD_NAME + "\":" + value + "}", source);  
    }
    protected void doTestNullValue(String type) throws IOException {
        // Test edge cases
            .stream()
            }
        decoded = DoublePoint.decodeDimension(encoded, 0);
                .stream()  
        assertEquals(123, pointField.numericValue().doubleValue(), 0d);
    }  
    }
        decoded = IntPoint.decodeDimension(encoded, 0);
        decoded = IntPoint.decodeDimension(encoded, 0);
    }  
        encoded = type.encodePoint((byte) 100, false);
    }  
            ParsedDocument doc = mapper.parse(source(b -> b.field("field", 123)));
        assertEquals(1, pointField.fieldType().pointIndexDimensionCount());
        assertEquals(2, fields.length);
        encoded = type.encodePoint(0.0f, true);
                    containsString(item.message)
            minimalMapping(b);
            }
            b -> b.field(FIELD_NAME, 42),
                    XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
            }
import org.apache.lucene.index.DirectoryReader;
        encoded = type.encodePoint(100, false);
                    mapper.deriveSource(builder, reader.leaves().get(0).reader(), 0);  
    public void testIgnoreMalformed() throws Exception {
        // Negative number roundDown (exclusive upper bound)
    public void doTestNotIndexed(String type) throws Exception {
        NumberFieldMapper.NumberType type = NumberFieldMapper.NumberType.INTEGER;
                case LONG:
import org.opensearch.plugins.Plugin;  
                        doc.add(new SortedNumericDocValuesField(FIELD_NAME, HalfFloatPoint.halfFloatToSortableShort(value.floatValue())));
    }  
                    case BYTE:
    }  
        decoded = BigIntegerPoint.decodeDimension(encoded, 0);
                        doc.add(new SortedNumericDocValuesField(FIELD_NAME, NumericUtils.floatToSortableInt(value.floatValue())));
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", type)));
        checker.registerConflictCheck("index", b -> b.field("index", false));
                try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {  
        MapperService mapperService = createMapperService(pluggableSettings(), fieldMapping(this::minimalMapping));
                    "Incorrect error message for [" + item.type + "] with value [" + item.value + "]",
        assertThat(doc.rootDoc().getFields("field"), arrayWithSize(2));  
        for (String type : types()) {  
        assertEquals(BigInteger.valueOf(99L), decoded);  
    }  
        }
    }
            boolean pluggableHasField = docInput.getCapturedFields().stream().anyMatch(e -> e.getKey().name().equals(fieldName));
        CapturingDocumentInput docInput = new CapturingDocumentInput();
            assertEquals("Lucene path should produce no field for '" + fieldName + "'", 0, luceneFields.length);
            null  
            assertEquals(123, storedField.numericValue().doubleValue(), 0d);
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", 123)));  
        // Pluggable path
        // Test roundUp = false  
        return doc;  
            try (Directory directory = newDirectory()) {  
                    XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
        IndexableField dvField = fields[1];  
        assertEquals(Long.MAX_VALUE, decoded); // Can't increment
        }
    }
        );  
            OutOfRangeSpec.of(NumberType.LONG, "-9223372036854775809", "out of range for a long"),  
        for (final Number value : values) {
        // Negative number roundUp (exclusive lower bound)  
        byte[] encoded = type.encodePoint(BigInteger.valueOf(100L), true);  
        // Test edge cases
    /**  
        NumberType[] floatTypes = { NumberType.INTEGER, NumberType.LONG, NumberType.UNSIGNED_LONG, NumberType.SHORT, NumberType.BYTE };
        assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field"));
        mapper.parse(source(b -> b.field(FIELD_NAME, 3.14)), docInput);
        assertEquals(9223372036854775807L, decoded);
 */  
            IndexableField[] fields = doc.rootDoc().getFields("field");  
     * defaults to false and the field reports itself as not searchable — routing queries to the
            }
            b.field("doc_values", false);  
        assertEquals(1, pointField.fieldType().pointIndexDimensionCount());
                    builder.endObject();
        }
        NumberFieldMapper.NumberType type = NumberFieldMapper.NumberType.FLOAT;
    }
            pluggableSettings,  
        IndexableField pointField = fields[0];
                assertEquals("{\"" + FIELD_NAME + "\":[" + value1 + "," + value2 + "," + value2 + "]}", source);  
            OutOfRangeSpec.of(NumberType.BYTE, 128, "is out of range for a byte"),
            settings,
        } else {  
        assertEquals(123, pointField.numericValue().doubleValue(), 0d);  
        encoded = type.encodePoint(Integer.MAX_VALUE, true);
        b.field("type", "long");
    }  
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)  
 * Unless required by applicable law or agreed to in writing,
        assertTrue(mapperService.fieldType("field").isSearchable());
        }  
        doc = mapper.parse(source(b -> b.field("field", "-9223372036854775808.9")));
     */
            return doc;
                    mapper.deriveSource(builder, reader.leaves().get(0).reader(), 0);  
    }
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {  
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", type).field("store", true)));
            mapping(b -> b.startObject(FIELD_NAME).field("type", "long").endObject())
            try (Directory directory = newDirectory()) {  
        encoded = type.encodePoint(100L, false);
        byte[] encoded = type.encodePoint(100.5f, true);  
            OutOfRangeSpec.of(NumberType.FLOAT, Float.NEGATIVE_INFINITY, "[float] supports only finite values"),  
                builder.endObject();  
    }  
    }
        // Test roundUp = false  
import org.opensearch.index.engine.dataformat.stub.MockDocValuesDataFormatPlugin;
        }));
    }
    public void testLongEncodePoint() {  
import org.opensearch.common.Numbers;
            for (Object malformedValue : new Object[] { "a", Boolean.FALSE }) {  
        assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());
import org.apache.lucene.document.FloatPoint;  
    }
            OutOfRangeSpec.of(NumberType.SHORT, "32768", "is out of range for a short"),  
        assertEquals(123, pointField.numericValue().doubleValue(), 0d);
                    XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
        );
/*
                IndexableField[] fields = doc.rootDoc().getFields("field");
        assertEquals(99L, decoded);  
            b.endObject();
import org.opensearch.core.common.bytes.BytesArray;
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)  
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
                        doc.add(new SortedNumericDocValuesField(FIELD_NAME, value.intValue()));
        assertEquals(101L, decoded);
    public void testPluggableDataFormatLongValue() throws Exception {  
        // 100.3 should be coerced to 100, then decremented to 99  
            }
     */
    /**  
        IndexableField dvField = fields[0];
        assertEquals(DocValuesSkipIndexType.NONE, dvField.fieldType().docValuesSkipIndexType());  
        byte[] encoded = type.encodePoint((short) 100, true);
    @Override
                                NumberFieldMapper.NumberType.objectToUnsignedLong(value, false).longValue()
        mapper.copyTo = copyTo;
        decoded = HalfFloatPoint.decodeDimension(encoded, 0);
        assertEquals(99L, decoded);  
            OutOfRangeSpec.of(NumberType.INTEGER, 2147483648L, " out of range of `int"),  
            OutOfRangeSpec.of(NumberType.DOUBLE, Double.NEGATIVE_INFINITY, "[double] supports only finite values")
    }
 * under the License.  
