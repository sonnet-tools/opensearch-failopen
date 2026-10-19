        encoded = type.encodePoint(Integer.MIN_VALUE, false);
                    doc.add(new StoredField(FIELD_NAME, value.intValue()));
        DocumentMapper luceneMapper = createDocumentMapper(mappingBuilder);
        try (Directory directory = newDirectory()) {
        // Test roundUp = true
        decoded = LongPoint.decodeDimension(encoded, 0);
    }
    }
        Settings pluggableSettings,
                    break;
import org.opensearch.common.CheckedConsumer;
        assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());
            mapping(b -> b.startObject(FIELD_NAME).field("type", "double").endObject())
        assertEquals(101, decoded);
        }
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", type)));
 * compatible open source license.
    @Override
        Number expectedValue
        assertEquals(DoublePoint.nextUp(100.5), decoded, 0.0);
 */
        checker.registerConflictCheck("null_value", b -> b.field("null_value", 1));
import org.apache.lucene.document.IntPoint;
import org.opensearch.core.common.bytes.BytesArray;
            pluggableSettings,
            OutOfRangeSpec.of(NumberType.LONG, "1e999999999", "out of range for a long"),
            b.field("doc_values", false);
        // Test roundUp = true
    public void testPluggableDataFormatDefaultsIndexToFalse() throws IOException {
        }
            ParsedDocument doc = mapper.parse(source(b -> b.field("field", 123)));
        // Test roundUp = true
                SourceToParse source = source(b -> b.field("field", malformedValue));
                try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
            pluggableSettings,
    }
        for (NumberType type : fieldTypes) {
        DocumentMapper mapper = createDocumentMapper(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            OutOfRangeSpec.of(NumberType.LONG, "-9223372036854775809", "out of range for a long"),
        decoded = LongPoint.decodeDimension(encoded, 0);
        assertTrue("Should round up", decoded > 100.5f);
        );
        assertNumericLuceneAndPluggablePathsEquivalent(
                builder.endObject();
            pluggableSettings,
            .anyMatch(e -> e.getKey().name().equals(FIELD_NAME) && e.getValue().equals(3.14));
import java.util.Arrays;
                        doc.add(new SortedNumericDocValuesField(FIELD_NAME, NumericUtils.floatToSortableInt(value.floatValue())));
    public void testPluggableDataFormatDoubleValue() throws Exception {
            OutOfRangeSpec.of(NumberType.UNSIGNED_LONG, new BigInteger("-1"), "out of range for an unsigned long"),
        // Negative number roundDown (exclusive upper bound)
        assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());
    }
        assertEquals(new BigInteger("18446744073709551615"), decoded);
        }
    }
                int value = 123;
 * SPDX-License-Identifier: Apache-2.0
    }
        checker.registerUpdateCheck(
        DocumentMapper pluggableMapper = createDocumentMapper(pluggableSettings, mappingBuilder);
        byte[] encoded = type.encodePoint(100.5f, true);
    }
        decoded = HalfFloatPoint.decodeDimension(encoded, 0);
        assertEquals(123, pointField.numericValue().doubleValue(), 0d);
    public void doTestStore(String type) throws Exception {
            OutOfRangeSpec.of(NumberType.INTEGER, "-2147483649", "is out of range for an integer"),
                assertEquals("{\"" + FIELD_NAME + "\":[" + value1 + "," + value2 + "," + value2 + "]}", source);
        for (NumberType type : floatTypes) {
            OutOfRangeSpec.of(NumberType.UNSIGNED_LONG, new BigInteger("18446744073709551616"), "out of range for an unsigned long"),
            DocumentMapper mapper = createDocumentMapper(
                        break;
    @Override
    /**
    }
import org.apache.lucene.index.IndexWriterConfig;
            NumberFieldMapper mapper = getMapper(NumberType.UNSIGNED_LONG, FieldMapper.CopyTo.empty(), true, false);
    public void testPluggableDataFormatNullValueSkipped() throws Exception {
            .anyMatch(e -> e.getKey().name().equals(FIELD_NAME) && e.getValue().equals(123456789L));
        final List<OutOfRangeSpec> inputs = Arrays.asList(
    }
            OutOfRangeSpec.of(NumberType.DOUBLE, Double.NEGATIVE_INFINITY, "[double] supports only finite values")
import org.opensearch.core.xcontent.MediaTypeRegistry;
                    iw.addDocument(createDocument(type, List.of(value), true));
        FieldMapper.CopyTo copyTo = new FieldMapper.CopyTo.Builder().add("copy_to_field").build();
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", 123)));
 * the Apache License, Version 2.0 (the "License"); you may
            assertEquals(123, new BigInteger(storedField.stringValue()).longValue());
            OutOfRangeSpec.of(NumberType.DOUBLE, "1.7976931348623157E309", "[double] supports only finite values"),
        long decoded = LongPoint.decodeDimension(encoded, 0);
        decoded = IntPoint.decodeDimension(encoded, 0);
                String source = builder.toString();
    }
    public void testUnsignedLongFieldDerivedValueFetchingMultiValue_DocValues() throws IOException {
        assertEquals(FloatPoint.nextDown(100.5f), decoded, 0.0f);
                    builder.endObject();
    }
                    case DOUBLE:
 * ownership. Elasticsearch licenses this file to you under
        byte[] encoded = type.encodePoint(-100, true);
            try (Directory directory = newDirectory()) {
        // Scenario 4: null value — no field produced
            minimalMapping(b);
            for (final Number value : values) {
        for (OutOfRangeSpec item : inputs) {
            OutOfRangeSpec.of(NumberType.FLOAT, Float.POSITIVE_INFINITY, "[float] supports only finite values"),
                    XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
                    builder.endObject();
                mapper.deriveSource(builder, reader.leaves().get(0).reader(), 0);
            OutOfRangeSpec.of(NumberType.INTEGER, "2147483648", "is out of range for an integer"),
        // Lucene path
    }
                        doc.add(new SortedNumericDocValuesField(FIELD_NAME, value.intValue()));
            pluggableSettings,
    @Override
    }
        }
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
import org.opensearch.index.mapper.NumberFieldMapper.NumberType;
    protected void writeFieldValue(XContentBuilder builder) throws IOException {
                }
        ParsedDocument doc = mapper.parse(source);
                );
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> mapper2.parse(source(b -> b.field("field", "123"))));
        assertEquals(DocValuesSkipIndexType.NONE, dvField.fieldType().docValuesSkipIndexType());
    }
        assertEquals(maxUnsignedLong, decoded); // Can't increment
            b.endObject();
            OutOfRangeSpec.of(NumberType.FLOAT, "-3.4028235E39", "[float] supports only finite values"),
        assertEquals(101, decoded);
        encoded = type.encodePoint(100.7f, true);
            boolean pluggableFound = docInput.getCapturedFields()
            .put("index.pluggable.dataformat", MockDocValuesDataFormatPlugin.FORMAT_NAME)
        }));
        for (String type : types()) {
                case SHORT:
 */
    protected void minimalMapping(XContentBuilder b) throws IOException {
        assertTrue("Expected double value 3.14", found);
        decoded = IntPoint.decodeDimension(encoded, 0);
        return mapper;
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", type).field("store", true)));
        CapturingDocumentInput docInput = new CapturingDocumentInput();
            IndexableField dvField = fields[0];
 * not use this file except in compliance with the License.
        assertTrue("String parsing should work", decoded > 123.456789);
                }
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
        assertEquals(99L, decoded);
        );
        assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());
        assertEquals(101, decoded); // 100.7 coerced to 100, then incremented
        for (String type : types()) {
        // Test roundUp = true
                try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
            long value1 = Integer.MAX_VALUE;
    @Override
    @Override
                b.field("index", true);
     * defaults to false and the field reports itself as not searchable — routing queries to the
        assertEquals(99L, decoded);
        assertEquals(123, pointField.numericValue().doubleValue(), 0d);
        // Test roundUp = false
        encoded = type.encodePoint((byte) 100, false);
import java.util.Collection;
    public void testPossibleToDeriveSource_WhenCopyToPresent() throws IOException {
        assertEquals(123, pointField.numericValue().doubleValue(), 0d);
        IndexableField[] fields = doc.rootDoc().getFields("field");
        XContentBuilder mappingBuilder,
    public void testPluggablePathEquivalenceWithLucenePath() throws Exception {
        encoded = type.encodePoint(100.3, false);
        mapper.parse(source(b -> b.field(FIELD_NAME, 123456789L)), docInput);
                    mapper.deriveSource(builder, reader.leaves().get(0).reader(), 0);
        assertThrows(UnsupportedOperationException.class, mapper::canDeriveSource);
                    "Incorrect error message for [" + item.type + "] with value [" + item.value + "]",
    }
        ParsedDocument doc = mapper.parse(
            }
        Object missing = Arrays.asList("float", "double", "half_float").contains(type) ? 123d : 123L;
        NumberType[] floatTypes = { NumberType.INTEGER, NumberType.LONG, NumberType.UNSIGNED_LONG, NumberType.SHORT, NumberType.BYTE };
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", 123)));
        int decoded = IntPoint.decodeDimension(encoded, 0);
        assertFalse("existing field's value should be preserved across the update", mapperService.fieldType("field").isSearchable());
    }
                NumberFieldMapper mapper = getMapper(type, FieldMapper.CopyTo.empty(), true, false);
            OutOfRangeSpec.of(NumberType.LONG, new BigInteger("9223372036854775808"), "out of range of `long`"),
        IndexableField[] fields = doc.rootDoc().getFields("field");
        byte[] encoded = type.encodePoint(100L, true);
        assertThat(doc.rootDoc().getFields("field"), arrayWithSize(2));
        decoded = IntPoint.decodeDimension(encoded, 0);
        assertTrue("Expected long value 123456789", found);
    public void testPluggableDataFormatMappingUpdateDefaultsNewFieldToNotIndexed() throws IOException {
        decoded = IntPoint.decodeDimension(encoded, 0);
        encoded = type.encodePoint(100L, false);
        float decoded = HalfFloatPoint.decodeDimension(encoded, 0);
        assertEquals(9223372036854775807L, decoded);
        Settings settings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
        assertEquals(Integer.MAX_VALUE, decoded); // Can't increment
    }
        checker.registerConflictCheck("store", b -> b.field("store", true));
    }
    public void testExistsQueryDocValuesDisabled() throws IOException {
    public void testNonPluggableDataFormatKeepsIndexTrue() throws IOException {
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
    }
        }
        );
        assertEquals(3, fields.length);
        decoded = IntPoint.decodeDimension(encoded, 0);
        MapperService mapperService = createMapperService(pluggableSettings(), fieldMapping(this::minimalMapping));
            assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());
        throws IOException {
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", type).field("index", false)));
            settings,
        }
                    mapper.deriveSource(builder, reader.leaves().get(0).reader(), 0);
            () -> createMapperService(pluggableSettings(), fieldMapping(b -> {
        }));
                }
        // Add stored field
        NumberFieldMapper.NumberType type = NumberFieldMapper.NumberType.DOUBLE;
        byte[] encoded = type.encodePoint(100.5f, true);
                        break;
                String source = builder.toString();
            }
        return Set.of("byte", "short", "integer", "long", "float", "double", "half_float", "unsigned_long");
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "123")));
    }
        assertThat(e.getCause().getMessage(), containsString("passed as String"));
        assertEquals(2, fields.length);
                }
        );
            assertEquals(123, storedField.numericValue().doubleValue(), 0d);
        encoded = type.encodePoint(100.5, false);
    }
            }
                    e.getCause().getMessage(),
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", type)));
            b.endObject();
        boolean found = docInput.getCapturedFields()
                        break;
/*
 *
    public void testByteEncodePoint() {
import org.apache.lucene.document.Document;
    @Override
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", 123)));
        }
 *
        for (NumberType type : floatTypes) {
 * The OpenSearch Contributors require contributions made to
        encoded = type.encodePoint(Byte.MAX_VALUE, true);
    }
            b -> b.field("ignore_malformed", true),
import org.apache.lucene.document.LongPoint;
                case FLOAT:
                    builder.endObject();
                case LONG:
        NumberFieldMapper.NumberType type = NumberFieldMapper.NumberType.BYTE;
import org.apache.lucene.index.DirectoryReader;
        );
                }
     */
        byte[] encoded = type.encodePoint(100.5, true);
import org.apache.lucene.sandbox.document.BigIntegerPoint;
        NumberType[] floatTypes = { NumberType.FLOAT, NumberType.HALF_FLOAT, NumberType.DOUBLE };
    }
    public void doTestDefaults(String type) throws Exception {
        assertNumericLuceneAndPluggablePathsEquivalent(
            b -> b.field(FIELD_NAME, 42),
        boolean found = docInput.getCapturedFields()
            try (Directory directory = newDirectory()) {
     * value of the already-mapped field unchanged.
        assertEquals(101, decoded);
        assertFalse(pointField.fieldType().stored());
                    case UNSIGNED_LONG:
                try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
import java.math.BigInteger;
        decoded = LongPoint.decodeDimension(encoded, 0);
            b.field("index", true);
        for (NumberType type : fieldTypes) {
    /** An explicit {@code index: false} is accepted on a pluggable-dataformat index. */
        // the following two strings are in-range for a long after coercion
            OutOfRangeSpec.of(NumberType.HALF_FLOAT, Float.NEGATIVE_INFINITY, "[half_float] supports only finite values"),
    }
        // Test edge cases
        encoded = type.encodePoint("123.456789", true);
        );
            123456789L
    }
        // 100.7 should be coerced to 100, then incremented to 101
            OutOfRangeSpec.of(NumberType.FLOAT, Float.NaN, "[float] supports only finite values"),
                    assertEquals("{\"" + FIELD_NAME + "\":" + value + "}", source);
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
            } catch (MapperParsingException e) {
            null
        encoded = type.encodePoint((short) 100, false);
        assertEquals(DocValuesSkipIndexType.NONE, dvField.fieldType().docValuesSkipIndexType());
            IndexableField[] fields = doc.rootDoc().getFields("field");
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "long").field("ignore_malformed", true)));
            OutOfRangeSpec.of(NumberType.HALF_FLOAT, Float.POSITIVE_INFINITY, "[half_float] supports only finite values"),
     * On a pluggable-dataformat index no BKD points are written for numeric fields, so {@code index}
    }
    }
        CapturingDocumentInput docInput = new CapturingDocumentInput();
        );
                    XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> merge(mapperService, mapping(b -> {
 * Modifications Copyright OpenSearch Contributors. See
        decoded = HalfFloatPoint.decodeDimension(encoded, 0);
            try (DirectoryReader reader = DirectoryReader.open(directory)) {
            OutOfRangeSpec.of(NumberType.LONG, "-1e999999999", "out of range for a long"),
        IndexableField pointField = fields[0];
                }
 * under the License.
                        doc.add(
        byte[] encoded = type.encodePoint((byte) 100, true);
        assertEquals(99, decoded);
                    iw.addDocument(createDocument(type, List.of(value), true));
        assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());
    }
    /** Indices that do not use a pluggable dataformat keep the standard {@code index: true} default. */
                        );
            minimalMapping(b);
        // Test roundUp = false
            OutOfRangeSpec.of(NumberType.BYTE, -129, "is out of range for a byte"),
                    assertThat(e.getCause().getMessage(), containsString("For input string: \"a\""));
            boolean pluggableHasField = docInput.getCapturedFields().stream().anyMatch(e -> e.getKey().name().equals(fieldName));
    public void testHalfFloatEncodePoint() {
        checker.registerUpdateCheck(b -> b.field("coerce", false), m -> assertFalse(((NumberFieldMapper) m).coerce()));
    @Override
                    case HALF_FLOAT:
                case HALF_FLOAT:
        assertEquals(FloatPoint.nextUp(100.5f), decoded, 0.0f);
                XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
        assertEquals(1, pointField.fieldType().pointIndexDimensionCount());
        NumberFieldMapper mapper = (NumberFieldMapper) mapperService.documentMapper().mappers().getMapper(FIELD_NAME);
        // Test roundUp = false
        // Test roundUp = false
            return doc;
        IndexableField dvField = fields[1];
        int decoded = IntPoint.decodeDimension(encoded, 0);
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
import org.opensearch.common.Numbers;
    }
            OutOfRangeSpec.of(NumberType.INTEGER, 2147483648L, " out of range of `int"),
                }
            minimalMapping(b);
import static org.hamcrest.Matchers.containsString;
        MapperService mapperService = createMapperService(pluggableSettings(), fieldMapping(b -> {
        checker.registerConflictCheck("doc_values", b -> b.field("doc_values", false));
                    case SHORT:
                    String source = builder.toString();
        assertEquals(DoublePoint.nextDown(100.5), decoded, 0.0);
        assertFalse(docInput.getCapturedFields().stream().anyMatch(e -> e.getKey().name().equals(FIELD_NAME)));
    }
                    XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
import java.util.Set;
        assertExistsQuery(mapperService);
        encoded = type.encodePoint(Short.MAX_VALUE, true);
        assertEquals(DocValuesSkipIndexType.NONE, dvField.fieldType().docValuesSkipIndexType());
                }
    @Override
                try (DirectoryReader reader = DirectoryReader.open(directory)) {
            long value1 = Integer.MAX_VALUE;
    }
        Document doc = new Document();
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
            );
                int value = 123;
                IndexableField[] fields = doc.rootDoc().getFields("field");
        String fieldName,
        // Test that decimal values are properly coerced for integer types
        assertFalse(mapperService.fieldType("field").isSearchable());
        DocumentMapper mapper = createDocumentMapper(mapping);
        CapturingDocumentInput docInput = new CapturingDocumentInput();
        assertFalse(mapperService.fieldType("field").isSearchable());
        encoded = type.encodePoint(Byte.MIN_VALUE, false);
        byte[] encoded = type.encodePoint((short) 100, true);
        // Test roundUp = false
                NumberFieldMapper mapper = getMapper(type, FieldMapper.CopyTo.empty(), false, true);
            }
    protected Set<String> types() {
                mapper.deriveSource(builder, reader.leaves().get(0).reader(), 0);
            fieldMapping(b -> b.field("type", numberType.typeName()).field("store", isStored).field("doc_values", hasDocValues))
        IndexableField[] luceneFields = luceneDoc.rootDoc().getFields(fieldName);
            assertTrue("Lucene path should produce field '" + fieldName + "'", luceneFields.length > 0);
        }
public class NumberFieldMapperTests extends AbstractNumericFieldMapperTestCase {
        }
    }
        assertEquals(1, pointField.fieldType().pointIndexDimensionCount());
        if (type.equalsIgnoreCase("unsigned_long")) {
 * this file be licensed under the Apache-2.0 license or a
                NumberFieldMapper mapper = getMapper(type, FieldMapper.CopyTo.empty(), true, false);
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
import org.opensearch.index.mapper.NumberFieldTypeTests.OutOfRangeSpec;
        decoded = DoublePoint.decodeDimension(encoded, 0);
            assertFalse("Pluggable path should produce no field for '" + fieldName + "'", pluggableHasField);
        encoded = type.encodePoint(Integer.MAX_VALUE, true);
                        doc.add(new SortedNumericDocValuesField(FIELD_NAME, value.longValue()));
                    doc.add(new StoredField(FIELD_NAME, value.toString()));
        assertTrue("String parsing should work", decoded > 123.45f);
        // Pluggable path
            }
                }
            }
            pluggableSettings,
                    assertThat(e.getCause().getMessage(), containsString("not numeric, cannot use numeric value accessors"));
    }
    public void testFloatFieldDerivedValueFetching_DocValues() throws IOException {
    }
            minimalMapping(b);
                mapper.parse(source(item::write));
            long value2 = Long.MIN_VALUE;
            FIELD_NAME,
            OutOfRangeSpec.of(NumberType.LONG, new BigInteger("-9223372036854775809"), "out of range of `long`"),
    private Document createDocument(NumberFieldMapper.NumberType type, List<Number> values, boolean hasDocValues) {
            OutOfRangeSpec.of(NumberType.DOUBLE, "-1.7976931348623157E309", "[double] supports only finite values"),
        IndexableField[] fields = doc.rootDoc().getFields("field");
        // Test roundUp = true
        BigInteger maxUnsignedLong = Numbers.MAX_UNSIGNED_LONG_VALUE;
import org.apache.lucene.document.StoredField;
        assertEquals(Integer.MIN_VALUE, decoded); // Can't decrement
    public void testLongFieldDerivedValueFetchingMultiValue_DocValues() throws IOException {
        mapper.parse(source(b -> b.nullField(FIELD_NAME)), docInput);
        IndexableField pointField = fields[0];
    }
            mapping(b -> b.startObject(FIELD_NAME).field("type", "double").endObject()),
    protected void doTestNullValue(String type) throws IOException {
            b.field("index", true);
                    assertEquals("{\"" + FIELD_NAME + "\":" + value + "}", source);
        assertEquals(7, pointField.numericValue().doubleValue(), 0d);
            try (Directory directory = newDirectory()) {
    public void testNegativeNumberHandling() {
            b -> b.field(FIELD_NAME, 123456789L),
        assertTrue("Zero roundUp should be positive", decoded > 0.0f);
    public void testLongEncodePoint() {
                                NumberFieldMapper.NumberType.objectToUnsignedLong(value, false).longValue()
    public void testSkipList() throws IOException {
    public void testLongIndexingOutOfRange() throws Exception {
        encoded = type.encodePoint(Long.MAX_VALUE, true);
                fail("Mapper parsing exception expected for [" + item.type + "] with value [" + item.value + "]");
                float value = 1.5f;
            FIELD_NAME,
        assertEquals(101L, decoded);
import org.apache.lucene.index.IndexWriter;
        assertThat(e.getMessage(), containsString("cannot cover: [POINT_RANGE]"));
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
                    builder.endObject();
        encoded = type.encodePoint("18446744073709551614", true);
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
        } else {
                    String source = builder.toString();
        checker.registerConflictCheck("index", b -> b.field("index", false));
                minimalMapping(b);
     * index is written — so the mapping is rejected rather than silently producing a field whose
            mapping(b -> b.startObject(FIELD_NAME).field("type", "integer").endObject()),
        int decoded = IntPoint.decodeDimension(encoded, 0);
    private NumberFieldMapper getMapper(NumberType numberType, FieldMapper.CopyTo copyTo, boolean hasDocValues, boolean isStored)
                assertThat(
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
    }
import org.apache.lucene.document.DoublePoint;
            42
        );
        assertEquals(BigInteger.valueOf(101L), decoded);
import org.apache.lucene.document.SortedNumericDocValuesField;
    public void testUnsignedLongEncodePoint() {
     * doc-values column instead of an empty point index.
                if (malformedValue instanceof String) {
    public void testCoercionBehavior() {
    }
    }
        // Negative number roundUp (exclusive lower bound)
                iw.addDocument(createDocument(NumberType.LONG, List.of(value1, value2, value1), true));
import java.util.List;
    }
        IndexableField dvField = fields[1];
            mapping(b -> b.startObject(FIELD_NAME).field("type", "integer").endObject())
    private void assertNumericLuceneAndPluggablePathsEquivalent(
        decoded = IntPoint.decodeDimension(encoded, 0);
                case UNSIGNED_LONG:
                try (DirectoryReader reader = DirectoryReader.open(directory)) {
    /** A mapping update that sets index:true on a new field is rejected on a pluggable data format index. */
            b.startObject("field2");
    /**
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "7.89")));
/*
            b -> b.nullField(FIELD_NAME),
        // Add doc values field
            OutOfRangeSpec.of(NumberType.FLOAT, Float.NEGATIVE_INFINITY, "[float] supports only finite values"),
        }));
                    String source = builder.toString();
        }
            assertEquals(DocValuesSkipIndexType.RANGE, dvField.fieldType().docValuesSkipIndexType());
        })));
        CapturingDocumentInput docInput = new CapturingDocumentInput();
        XContentBuilder mapping = fieldMapping(b -> b.field("type", type));
        // Test roundUp = true
        MapperService mapperService = createMapperService(pluggableSettings(), fieldMapping(this::minimalMapping));
                    mapper.deriveSource(builder, reader.leaves().get(0).reader(), 0);
        );
 * specific language governing permissions and limitations
            .stream()
        NumberFieldMapper.NumberType type = NumberFieldMapper.NumberType.INTEGER;
    public void testPossibleToDeriveSource_WhenDocValuesAndStoredDisabled() throws IOException {
        // Test edge cases
        assertEquals(2, fields.length);
            mapping(b -> b.startObject(FIELD_NAME).field("type", "long").endObject()),
        // Test roundUp = true
    protected void registerParameters(ParameterChecker checker) throws IOException {
package org.opensearch.index.mapper;
                XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
        MapperService mapperService = createMapperService(
        byte[] encoded = type.encodePoint(100, true);
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", type)));
            OutOfRangeSpec.of(NumberType.HALF_FLOAT, "-65520", "[half_float] supports only finite values"),
        // Test negative numbers for integer types
    }
        assertEquals(BigInteger.valueOf(99L), decoded);
import org.opensearch.common.xcontent.XContentFactory;
        // Test edge cases
                        break;
        IndexableField[] fields = doc.rootDoc().getFields("field");
                    break;
            }
                    String source = builder.toString();
 * Unless required by applicable law or agreed to in writing,
    public void testLongFieldDerivedValueFetching_DocValues() throws IOException {
        decoded = IntPoint.decodeDimension(encoded, 0);
        assertEquals(0, doc.rootDoc().getFields("field").length);
                fieldMapping(b -> b.field("type", type).field("index", false).field("skip_list", true))
        SourceToParse source = source(b -> b.nullField("field"));
                assertEquals("{\"" + FIELD_NAME + "\":[" + value2 + "," + value1 + "," + value1 + "]}", source);
        }
        assertFalse(dvField.fieldType().stored());
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
            .build();
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        NumberFieldMapper.NumberType type = NumberFieldMapper.NumberType.LONG;
     * A field added by a later mapping update also defaults to not-indexed, and the update leaves the
            .anyMatch(e -> e.getKey().name().equals(FIELD_NAME) && e.getValue().equals(42));
        );
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
    public void testPluggableDataFormatIntegerValue() throws Exception {
        assertFalse(mapperService.fieldType("field").isSearchable());
    public void testOutOfRangeValues() throws IOException {
            OutOfRangeSpec.of(NumberType.DOUBLE, Double.POSITIVE_INFINITY, "[double] supports only finite values"),
        assertThat(doc.rootDoc().getFields("field"), arrayWithSize(2));
 * this work for additional information regarding copyright
        decoded = IntPoint.decodeDimension(encoded, 0);
import org.opensearch.common.util.FeatureFlags;
            assertTrue("Pluggable path should capture field '" + fieldName + "' with value '" + expectedValue + "'", pluggableFound);
                NumberFieldMapper mapper = getMapper(type, FieldMapper.CopyTo.empty(), true, false);
        assertFalse(pointField.fieldType().stored());
            }
import org.opensearch.index.engine.dataformat.stub.MockDocValuesDataFormatPlugin;
    public void testPluggableDataFormatLongValue() throws Exception {
        mapper.copyTo = copyTo;
                        doc.add(new SortedNumericDocValuesField(FIELD_NAME, NumericUtils.doubleToSortableLong(value.doubleValue())));
            try (Directory directory = newDirectory()) {
            OutOfRangeSpec.of(NumberType.SHORT, -32769, "out of range of `short`"),
    protected void doTestDecimalCoerce(String type) throws IOException {
import org.apache.lucene.index.DocValuesType;
            OutOfRangeSpec.of(NumberType.LONG, "9223372036854775808", "out of range for a long"),
                    doc.add(new StoredField(FIELD_NAME, value.longValue()));
            .put("index.pluggable.dataformat.enabled", true)
        IndexableField pointField = fields[0];
            .stream()
        assertEquals(123, pointField.numericValue().doubleValue(), 0d);
                    break;
    public void testIgnoreMalformed() throws Exception {
                    containsString(item.message)
        }
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "long")));
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
                ParsedDocument doc = ignoring.parse(source);
                assertEquals(0, fields.length);
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "9223372036854775807.9")));
        encoded = type.encodePoint(0.0f, true);
        // 100.3 should be coerced to 100, then decremented to 99
            }
                }
        }));
    public void testPluggableDataFormatMappingUpdateRejectsIndexTrue() throws IOException {
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        IndexableField dvField = fields[1];
            DocumentMapper ignoring = createDocumentMapper(fieldMapping(b -> b.field("type", type).field("ignore_malformed", true)));
            assertEquals(1, fields.length);
            b.startObject("field2");
        assertEquals(1, pointField.fieldType().pointIndexDimensionCount());
                    XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
        assertTrue(storedField.fieldType().stored());
            try {
                            new SortedNumericDocValuesField(
import org.apache.lucene.index.DocValuesSkipIndexType;
        // Test roundUp = true
    public void doTestNotIndexed(String type) throws Exception {
    }
            try (DirectoryReader reader = DirectoryReader.open(directory)) {
                long value = (1L << 53) + randomLongBetween(0L, 1L << 20);
    }
        // Scenario 1: integer value
        assertTrue("Should round down", decoded < 100.5f);
        assertTrue(explicit.fieldType("field").isSearchable());
                    assertEquals("{\"" + FIELD_NAME + "\":" + value + "}", source);
                builder.endObject();
    public void testIntFieldDerivedValueFetching_DocValues() throws IOException {
                    case INTEGER:
 */
 * You may obtain a copy of the License at
        NumberFieldMapper.NumberType type = NumberFieldMapper.NumberType.UNSIGNED_LONG;
                    iw.addDocument(createDocument(type, List.of(value), false));
     */
        NumberFieldMapper.NumberType type = NumberFieldMapper.NumberType.INTEGER;
    protected Set<String> wholeTypes() {
        return Settings.builder()
        DocumentMapper mapper = createDocumentMapper(
        IndexableField dvField = fields[0];
                    case LONG:
                    String source = builder.toString();
import org.apache.lucene.index.IndexableField;
        assertEquals(99, decoded);
            OutOfRangeSpec.of(NumberType.BYTE, "128", "is out of range for a byte"),
            }
        encoded = type.encodePoint(100, false);
 * software distributed under the License is distributed on an
        MapperService mapperService = createMapperService(fieldMapping(this::minimalMapping));
    }
            pluggableSettings,
    public void testPluggableDataFormatRejectsExplicitIndexTrue() {
        encoded = type.encodePoint(maxUnsignedLong, true);
            OutOfRangeSpec.of(NumberType.FLOAT, "3.4028235E39", "[float] supports only finite values"),
 * license agreements. See the NOTICE file distributed with
    /**
        assertEquals(99, decoded);
        decoded = FloatPoint.decodeDimension(encoded, 0);
        decoded = LongPoint.decodeDimension(encoded, 0);
            BigInteger value2 = new BigInteger("9223372036854775808");
            MapperParsingException.class,
            pluggableSettings,
            OutOfRangeSpec.of(NumberType.SHORT, "-32769", "is out of range for a short"),
        IndexableField[] fields = doc.rootDoc().getFields("field");
            assertEquals("Lucene path should produce no field for '" + fieldName + "'", 0, luceneFields.length);
        NumberFieldMapper.NumberType type = NumberFieldMapper.NumberType.SHORT;
 * GitHub history for details.
        long decoded = LongPoint.decodeDimension(encoded, 0);
                    builder.endObject();
        IndexableField dvField = fields[1];
        decoded = BigIntegerPoint.decodeDimension(encoded, 0);
    public void doTestNoDocValues(String type) throws Exception {
        assertNumericLuceneAndPluggablePathsEquivalent(
import org.apache.lucene.util.NumericUtils;
            b -> b.field(FIELD_NAME, 3.14),
            }))
                    XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
        assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());
        MapperService mapperService = createMapperService(pluggableSettings(), fieldMapping(this::minimalMapping));
        for (final Number value : values) {
import org.opensearch.plugins.Plugin;
    }
                    iw.addDocument(createDocument(type, List.of(value), true));
                switch (type) {
            OutOfRangeSpec.of(NumberType.BYTE, "-129", "is out of range for a byte"),
     */
            m -> assertTrue(((NumberFieldMapper) m).ignoreMalformed().value())
    private static Settings pluggableSettings() {
        // Test roundUp = false
        // The 'unsigned_long' is stored as a string
                    break;
        assertEquals(Long.MAX_VALUE, decoded); // Can't increment
        if (expectedValue == null) {
        mapper = createDocumentMapper(fieldMapping(b -> b.field("type", type).field("null_value", missing)));
            NumberFieldMapper mapper = getMapper(NumberType.LONG, FieldMapper.CopyTo.empty(), true, false);
        // Test roundUp = false
            OutOfRangeSpec.of(NumberType.BYTE, 128, "is out of range for a byte"),
    }
            assertEquals(expectedValue.doubleValue(), luceneFields[0].numericValue().doubleValue(), 0.001d);
        float decoded = FloatPoint.decodeDimension(encoded, 0);
        if (hasDocValues) {
                MapperParsingException e = expectThrows(MapperParsingException.class, () -> notIgnoring.parse(source));
                case BYTE:
        } else {
        IndexableField pointField = fields[0];
    }
    }
                .anyMatch(e -> e.getKey().name().equals(fieldName) && e.getValue().equals(expectedValue));
                                FIELD_NAME,
        doc = mapper.parse(source);
            mapping(b -> b.startObject(FIELD_NAME).field("type", "integer").endObject()),
                try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
            OutOfRangeSpec.of(NumberType.HALF_FLOAT, "65520", "[half_float] supports only finite values"),
        // Scenario 2: long value
        assertEquals(101L, decoded);
        assertEquals(-99, decoded);
        DocumentMapper mapper = createDocumentMapper(
import org.apache.lucene.document.FloatPoint;
        NumberFieldMapper.NumberType type = NumberFieldMapper.NumberType.LONG;
        // Test edge cases
            }
        return doc;
        );
import org.apache.lucene.sandbox.document.HalfFloatPoint;
            OutOfRangeSpec.of(NumberType.SHORT, 32768, "out of range of `short`"),
                    iw.addDocument(createDocument(type, List.of(value), false));
                        doc.add(new SortedNumericDocValuesField(FIELD_NAME, HalfFloatPoint.halfFloatToSortableShort(value.floatValue())));
                    doc.add(new StoredField(FIELD_NAME, value.floatValue()));
        DocumentMapper mapper2 = createDocumentMapper(fieldMapping(b -> b.field("type", type).field("coerce", false)));
        decoded = IntPoint.decodeDimension(encoded, 0);
        MapperService mapperService = createMapperService(fieldMapping(b -> {
            }
            mapping(b -> b.startObject(FIELD_NAME).field("type", "integer").endObject())
        CheckedConsumer<XContentBuilder, IOException> sourceBuilder,
        ParsedDocument luceneDoc = luceneMapper.parse(source(sourceBuilder));
                assertArrayEquals(new String[] { "field" }, TermVectorsService.getValues(doc.rootDoc().getFields("_ignored")));
                try (DirectoryReader reader = DirectoryReader.open(directory)) {
    public void testFloatEncodePoint() {
    public void doTestCoerce(String type) throws IOException {
        NumberType[] floatTypes = { NumberType.FLOAT, NumberType.HALF_FLOAT, NumberType.DOUBLE };
    public void testIntFieldDerivedValueFetching_StoredField() throws IOException {
        assertEquals(-101, decoded);
        builder.value(123);
            for (Object malformedValue : new Object[] { "a", Boolean.FALSE }) {
        merge(mapperService, mapping(b -> {
        byte[] encoded = type.encodePoint(100.7, true);
            mapping(b -> b.startObject(FIELD_NAME).field("type", "long").endObject())
        assertEquals(2, fields.length);
        try (Directory directory = newDirectory()) {
        }
            source(b -> b.rawField("field", new BytesArray("9223372036854775808").streamInput(), MediaTypeRegistry.JSON))
                float value = 1.5f;
                NumberFieldMapper mapper = getMapper(type, FieldMapper.CopyTo.empty(), false, true);
        CapturingDocumentInput docInput = new CapturingDocumentInput();
                    case FLOAT:
        assertEquals(1, fields.length);
        IndexableField[] fields = doc.rootDoc().getFields("field");
            OutOfRangeSpec.of(NumberType.UNSIGNED_LONG, "18446744073709551616", "out of range for an unsigned long"),
        NumberFieldMapper.NumberType type = NumberFieldMapper.NumberType.HALF_FLOAT;
import org.apache.lucene.store.Directory;
        mapper.parse(source(b -> b.field(FIELD_NAME, 42)), docInput);
        decoded = BigIntegerPoint.decodeDimension(encoded, 0);
            DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", item.type.typeName())));
        MapperService explicit = createMapperService(fieldMapping(b -> {
                            )
                    doc.add(new StoredField(FIELD_NAME, value.doubleValue()));
    ) throws IOException {
            OutOfRangeSpec.of(NumberType.DOUBLE, Double.NaN, "[double] supports only finite values"),
        assertEquals(1, pointField.fieldType().pointIndexDimensionCount());
                try (DirectoryReader reader = DirectoryReader.open(directory)) {
        assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field"));
            OutOfRangeSpec.of(NumberType.UNSIGNED_LONG, "-1", "out of range for an unsigned long"),
    protected Collection<? extends Plugin> getPlugins() {
    @Override
import java.io.IOException;
        NumberFieldMapper mapper = getMapper(NumberFieldMapper.NumberType.HALF_FLOAT, FieldMapper.CopyTo.empty(), false, false);
        assertEquals(Byte.MIN_VALUE, decoded);
        );
}
        decoded = DoublePoint.decodeDimension(encoded, 0);
            try (Directory directory = newDirectory()) {
        assertThat(e.getMessage(), containsString("cannot cover: [POINT_RANGE]"));
     * queries match nothing.
        }
     */
            OutOfRangeSpec.of(NumberType.INTEGER, -2147483649L, " out of range of `int`"),
        assertEquals(1, pointField.fieldType().pointIndexDimensionCount());
    public void testDoubleEncodePoint() {
        decoded = BigIntegerPoint.decodeDimension(encoded, 0);
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", 123)));
            }
        );
        assertFalse(dvField.fieldType().stored());
        DocumentMapper mapper = createDocumentMapper(
        byte[] encoded = type.encodePoint(BigInteger.valueOf(100L), true);
        assertThrows(UnsupportedOperationException.class, mapper::canDeriveSource);
    @Override
            FIELD_NAME,
                iw.addDocument(createDocument(NumberType.UNSIGNED_LONG, List.of(value2.longValue(), value1, value2.longValue()), true));
/*
                    mapper.deriveSource(builder, reader.leaves().get(0).reader(), 0);
        decoded = IntPoint.decodeDimension(encoded, 0);
        return Set.of("byte", "short", "integer", "long", "unsigned_long");
        MapperParsingException e = expectThrows(
        decoded = HalfFloatPoint.decodeDimension(encoded, 0);
    public void testShortEncodePoint() {
        BigInteger decoded = BigIntegerPoint.decodeDimension(encoded, 0);
        encoded = type.encodePoint(100.5f, false);
            FIELD_NAME,
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
    public void testFloatFieldDerivedValueFetching_StoredField() throws IOException {
                        break;
                try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
                }
        IndexableField storedField = fields[2];
        encoded = type.encodePoint(BigInteger.valueOf(100L), false);
        assertEquals(mapping.toString(), mapper.mappingSource().toString());
        // Test roundUp = false
        NumberType[] fieldTypes = { NumberType.INTEGER, NumberType.SHORT, NumberType.BYTE };
                    break;
    }
                    assertEquals("{\"" + FIELD_NAME + "\":" + value + "}", source);
     * Helper method to create a document with both doc values and stored fields
                    assertEquals("{\"" + FIELD_NAME + "\":" + value + "}", source);
        double decoded = DoublePoint.decodeDimension(encoded, 0);
    private static final String FIELD_NAME = "field";
import static org.hamcrest.Matchers.arrayWithSize;
     * An explicit {@code index: true} cannot be honoured on a pluggable-dataformat index — no point
                    mapper.deriveSource(builder, reader.leaves().get(0).reader(), 0);
            minimalMapping(b);
        encoded = type.encodePoint(-100, false);
import org.opensearch.index.termvectors.TermVectorsService;
            b.field("index", false);
        assertEquals(Byte.MAX_VALUE, decoded);
                } else {
        doc = mapper.parse(source(b -> b.field("field", "-9223372036854775808.9")));
        assertTrue(mapperService.fieldType("field").isSearchable());
    public void testPluggableDataFormatAcceptsExplicitIndexFalse() throws IOException {
        IndexableField pointField = fields[0];
        b.field("type", "long");
        boolean found = docInput.getCapturedFields()
            DocumentMapper notIgnoring = createDocumentMapper(fieldMapping(b -> b.field("type", type)));
    }
        mapper.parse(source(b -> b.field(FIELD_NAME, 3.14)), docInput);
            OutOfRangeSpec.of(NumberType.SHORT, "32768", "is out of range for a short"),
        NumberFieldMapper.NumberType type = NumberFieldMapper.NumberType.FLOAT;
                case INTEGER:
    /**
        assertTrue("Expected integer value 42", found);
    @Override
 * KIND, either express or implied.  See the License for the
            switch (type) {
    @Override
        pluggableMapper.parse(source(sourceBuilder), docInput);
        for (NumberType type : floatTypes) {
                    case BYTE:
        encoded = type.encodePoint(100.5f, false);
 * Licensed to Elasticsearch under one or more contributor
        IndexableField[] fields = doc.rootDoc().getFields("field");
            .stream()
        NumberType[] fieldTypes = { NumberType.LONG, NumberType.UNSIGNED_LONG };
        assertFalse("newly added field should default to not-indexed", mapperService.fieldType("field2").isSearchable());
        assertEquals(1, fields.length);
        assertParseMinimalWarnings();
                case DOUBLE:
        int decoded = IntPoint.decodeDimension(encoded, 0);
    }
        assertEquals(Short.MAX_VALUE, decoded);
 *
            OutOfRangeSpec.of(NumberType.HALF_FLOAT, Float.NaN, "[half_float] supports only finite values"),
        encoded = type.encodePoint("9223372036854775806", true);
import org.opensearch.common.settings.Settings;
        assertNumericLuceneAndPluggablePathsEquivalent(
        assertEquals(123, pointField.numericValue().doubleValue(), 0d);
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", type).field("doc_values", false)));
                        break;
        IndexableField pointField = fields[0];
                .stream()
            3.14
    }
                    assertThat(e.getCause().getMessage(), containsString("Current token"));
        return List.of(new MockDocValuesDataFormatPlugin());
        encoded = type.encodePoint("123.45", true);
    public void testIntegerEncodePoint() {
        // Scenario 3: double value
                try (DirectoryReader reader = DirectoryReader.open(directory)) {
                }
        NumberFieldMapper mapper = getMapper(NumberFieldMapper.NumberType.HALF_FLOAT, copyTo, true, true);
import org.opensearch.core.xcontent.XContentBuilder;
