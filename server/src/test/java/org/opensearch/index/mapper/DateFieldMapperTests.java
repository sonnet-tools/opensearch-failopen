    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        assertEquals("Date field should have 2 fields", 2, fieldsMillis.length);
        IndexableField[] fields = doc.rootDoc().getFields("field");  
    public void testChangeLocale() throws IOException {
            0,
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> b.field("field", value))));
import org.apache.lucene.document.LongPoint;
        }).when(storedFields).document(anyInt(), any(StoredFieldVisitor.class));
        MapperService mapperService = createMapperService(  
        assertFalse("skip_list should default to false", dateFieldMapper.skiplist());
        assertThat(e.getMessage(), containsString("Preview of field's value: '" + value + "'"));
        assertFalse("skip_list should be false for date_nanos", dateFieldMapper.skiplist());
    @Override
 * under the License.  
        String source = builder.toString();  
        IndexableField[] fields = doc.rootDoc().getFields("field");
 * The OpenSearch Contributors require contributions made to  
        );
            assertEquals(expectedValue.longValue(), luceneFields[0].numericValue().longValue());
                    .field("doc_values", false)  
        assertEquals("Should have 2 fields (point and doc values)", 2, fields.length);
        assertThat(e.getMessage(), containsString("of type [date_nanos]"));  
        assertFalse(dvField.fieldType().stored());
    }
        mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "date").field("skip_list", false)));
            IndexOptions.NONE,
    }
import org.opensearch.index.termvectors.TermVectorsService;
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "date_nanos").field("skip_list", true)));  
            fieldsDisabled[1].numericValue().longValue()
            () -> merge(mapperService, fieldMapping(b -> b.field("type", "text")))  
package org.opensearch.index.mapper;
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        DocumentMapper luceneMapper = createDocumentMapper(mappingBuilder);
        IndexableField pointField = fields[0];
     * On a pluggable-dataformat index no BKD points are written for date fields, so {@code index}  
        DateFieldMapper dateFieldMapper = (DateFieldMapper) mapperService.documentMapper().mappers().getMapper("field");
    }
        when(leafReader.getSortedNumericDocValues("field")).thenReturn(docValues);  
import org.opensearch.common.util.FeatureFlags;  
    protected Collection<? extends Plugin> getPlugins() {  
    }  
            0,
import org.opensearch.common.settings.Settings;
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "date")));
        when(docValues.advanceExact(0)).thenReturn(true);
            .anyMatch(e -> e.getKey().name().equals("field") && e.getValue().equals(TEST_TIMESTAMP));
            TEST_TIMESTAMP
        DocumentMapper mapper = createDocumentMapper(Version.V_3_2_0, fieldMapping(b -> b.field("type", "date")));
    public void testMergeDate() throws IOException {
        }));
        // Test with extreme long values,  
        // Test creating index with skip_list=true for date_nanos field
        IndexableField[] luceneFields = luceneDoc.rootDoc().getFields(fieldName);
        assertFalse(mapperService.fieldType("field").isSearchable());
        DateFieldMapper dateFieldMapper = (DateFieldMapper) mapperService.documentMapper().mappers().getMapper("field");
        decoded = LongPoint.decodeDimension(encoded, 0);
        // Test creating index with skip_list=true for date field  
    }  
    public void testSkipListParameterDefaultBehavior() throws IOException {
            () -> createMapperService(pluggableSettings(), fieldMapping(b -> {  
        builder.endObject();  
            MapperParsingException.class,  
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));  
        LeafReader leafReader = mock(LeafReader.class);  
    }
        assertExistsQuery(mapperService);
    }
        Settings pluggableSettings,
    }  
    public void testSkipListIntegrationMappingDefinitionSerialization() throws IOException {
        CapturingDocumentInput docInput = new CapturingDocumentInput();  
    // Integration tests for end-to-end skip_list functionality  
        assertEquals("2016-03-11", doc.docs().getFirst().getGroupingCriteria());
        // Verify doc values field - when skip_list=true, should use indexed doc values  
 * this work for additional information regarding copyright
            VectorSimilarityFunction.EUCLIDEAN,
                b -> b.field("type", "date_nanos")  
        IndexableField dvField = fields[1];  
        assertWarnings("Error parsing [foo] as date in [null_value] on field [field]); [null_value] will be ignored");
    }  
            fieldsEnabled[1].numericValue().longValue(),
        MapperService mapperService = createMapperService(fieldMapping(b -> {
        // Verify the mapper has skip_list enabled
        // Test invalid string value  
import org.apache.lucene.index.SortedNumericDocValues;
    }  
            minimalMapping(b);
        assertFalse(mapperService.fieldType("field").isSearchable());
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject();  
        checker.registerConflictCheck("print_format", b -> b.field("print_format", "yyyy-MM-dd"));
        String date = "2020-05-15T21:33:02.123Z";
        FieldInfo mockFieldInfo = new FieldInfo(
        // Pluggable path  
    }
public class DateFieldMapperTests extends MapperTestCase {
        assertFalse(mapperService.fieldType("field").isSearchable());
    @Override  
        IndexableField[] fieldsMillis = docMillis.rootDoc().getFields("field");
        );  
        mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "date_nanos").field("skip_list", false)));
        DocumentMapper mapper2 = createDocumentMapper(fieldMapping(b -> b.field("type", "date").field("ignore_malformed", true)));
        assertFalse(dateFieldMapper.isSkiplistDefaultEnabled(noSortConfig, "field"));
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
            "failed to parse date field [2016-03-99] with format [strict_date_time_no_millis||strict_date_optional_time||epoch_millis]"
    public void testSkipListIntegrationDateFieldWithIndexedDocValues() throws IOException {
        // Test creating index with skip_list=false for date field
        MapperParsingException e = expectThrows(
        MapperService mapperService = createMapperService(pluggableSettings(), fieldMapping(b -> b.field("type", "date_nanos")));
                    .field("store", true)
        assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field"));  
    /**
        );
    }  
        assertEquals("Date_nanos field should have 2 fields", 2, fieldsNanos.length);
        IndexSortConfig sortConfig = new IndexSortConfig(indexSettings);  
            visitor.longField(mockFieldInfo, TEST_TIMESTAMP);  
        DateFieldMapper dateFieldMapper = (DateFieldMapper) mapperService.documentMapper().mappers().getMapper("field");  
            )  
    public void testStore() throws Exception {
        dateFieldMapper.deriveSource(builder, leafReader, 0);
        assertFalse(dvField.fieldType().stored());  
        when(docValues.docValueCount()).thenReturn(1);  
        assertEquals(2, fields.length);
        Exception e = expectThrows(  
        MapperService mapperService = createMapperService(pluggableSettings(), fieldMapping(b -> {
        builder.endObject();
            b.field("index", true);
        IllegalArgumentException e = expectThrows(
    public void testDeriveSource_WhenStoredFieldEnabledAndDateNanosType() throws IOException {
            .build();
    public void testPluggableDataFormatDateValue() throws Exception {
        assertTrue(source.contains("\"field\":[\"2025-02-18T06:00:00Z\",\"2025-02-18T07:00:00Z\"]"));
        String negativeEpochStr = String.valueOf(negativeEpoch);
        doc = mapper.parse(source(b -> b.nullField("field")));  
        when(docValues.nextValue()).thenReturn(TEST_TIMESTAMP * 1000000L + 222222222L);
        assertEquals(1457654400000L, dvField.numericValue().longValue());  
            }).accept(b);  
        // Lucene path
        builder.endObject();
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "date").field("skip_list", true)));  
    }  
        assertEquals(baseTime - 1, decoded);
        );
        assertDateLuceneAndPluggablePathsEquivalent(  
            properties(x -> {
        assertTrue("Expected timestamp for date field", found);
        DateFieldMapper dateFieldMapper = (DateFieldMapper) mapper.mappers().getMapper("field");
        assertFalse(mapperService.fieldType("field").isStored());
        IndexableField[] fields = doc.rootDoc().getFields("field");
            -1,
        LeafReader leafReader = mock(LeafReader.class);  
    /** {@code date_nanos} resolves through a separate type parser, so it is covered explicitly. */
        assumeThat("Using legacy datetime format as default", FeatureFlags.isEnabled(FeatureFlags.DATETIME_FORMATTER_CACHING), is(false));
            DocValuesSkipIndexType.NONE,  
            null
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", 1457654400)));
        testIgnoreMalformedForValue("-2147483648", "Invalid value for Year (valid values -999999999 - 999999999): -2147483648");
        DocumentMapper mapper = createDocumentMapper(
        assertEquals(1, pointField.fieldType().pointIndexDimensionCount());  
     * An explicit {@code index: true} cannot be honoured on a pluggable-dataformat index — no point
    }
        // Test with date_nanos as well  
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
            boolean pluggableHasField = docInput.getCapturedFields().stream().anyMatch(e -> e.getKey().name().equals(fieldName));
        checker.registerConflictCheck("format", b -> b.field("format", "yyyy-MM-dd"));
            MapperParsingException.class,  
            IllegalArgumentException.class,
        assertThrows(UnsupportedOperationException.class, dateFieldMapper::canDeriveSource);  
        long expectedTimestamp = 1457692200000L;  
        assertEquals("Expected timestamp should match", expectedTimestamp, fieldsEnabled[0].numericValue().longValue());
        assertThat(e.getMessage(), containsString("cannot cover: [POINT_RANGE]"));
    @Override
            visitor.longField(mockFieldInfo, TEST_TIMESTAMP * 1000000L + 111111111L);
        DateFieldMapper.DateFieldType fieldType = new DateFieldMapper.DateFieldType("test_field");
    ) throws IOException {  
            "Point field values should match",
        assertFalse(pointField.fieldType().stored());
            assertEquals("Lucene path should produce no field for '" + fieldName + "'", 0, luceneFields.length);  
        when(docValues.advanceExact(0)).thenReturn(true);
        MapperParsingException e = expectThrows(
        when(leafReader.storedFields()).thenReturn(storedFields);  
    /**  
import static org.mockito.Mockito.anyInt;  
    }
        }).when(storedFields).document(anyInt(), any(StoredFieldVisitor.class));  
            assertTrue("Pluggable path should capture field '" + fieldName + "' with value '" + expectedValue + "'", pluggableFound);
        checker.registerConflictCheck("doc_values", b -> b.field("doc_values", false));  
        boolean hasDateField = docInput.getCapturedFields().stream().anyMatch(e -> e.getKey().name().equals("field"));  
        // Verify point field  
        assertThat(e.getMessage(), containsString("failed to parse field [field] of type [date]"));  
import org.apache.lucene.index.StoredFields;
        String fieldName,
        assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "date")));  
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "2016-03-11")));
        assumeThat(
        // Parse a document with date field  
        LeafReader leafReader = mock(LeafReader.class);
            )
     */  
        MapperService mapperService = createMapperService(
import static org.hamcrest.CoreMatchers.is;
    }  
            b.startObject("field2");  
        );  
    public void testIgnoreMalformedLegacy() throws IOException {  
            mapping(b -> b.startObject("field").field("type", "date").endObject())
        MapperService mapperService = createMapperService(  
            DocValuesSkipIndexType.NONE,
        DateFieldMapper dateFieldMapper = (DateFieldMapper) mapper.mappers().getMapper("field");  
        );
            1,  
    }
            0,
import org.opensearch.index.IndexSortConfig;
            "2016-03-99",
            true,
    }
        MapperService mapperService = createMapperService(
        IndexableField dvField = fields[1];
            Collections.emptyMap(),  
     * A field added by a later mapping update also defaults to not-indexed, and the update leaves the
        long largeEpoch = 253402300799999L;
        DateFieldMapper dateFieldMapper = (DateFieldMapper) mapperService.documentMapper().mappers().getMapper("field");
    public void testNullValue() throws IOException {  
        assertEquals(expectedValue, dateFieldMapper.isSkiplistDefaultEnabled(sortConfig, "field"));
        assertEquals(1457692200000L, pointField.numericValue().longValue());  
    public void testNullConfigValuesFail() {
import org.opensearch.cluster.metadata.IndexMetadata;
 *
}
        assertEquals(  
            0,  
        long expectedNullValue = ft.parse("2016-03-11");
import org.opensearch.common.CheckedConsumer;  
        // Get the field type and verify skip_list is set
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "date").field("skip_list", true)));
import org.apache.lucene.index.IndexOptions;
    public void testBadNullValue() throws IOException {
        IndexMetadata indexMetadata = new IndexMetadata.Builder("index").settings(settings).build();
        assertTrue("Date field skip_list should be enabled", dateMapperMillis.skiplist());
        IndexableField dvField = fields[1];
            )
        LeafReader leafReader = mock(LeafReader.class);
        assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());  
        DateFieldMapper dateMapperMillis = (DateFieldMapper) mapperMillis.mappers().getMapper("field");  
        assertEquals(2, fields.length);
        when(docValues.docValueCount()).thenReturn(2);
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "2016-03-11T10:30:00.123456789Z")));  
                b -> b.field("type", "date").field("format", "strict_date_time_no_millis").field("store", false).field("doc_values", true)
    }
        assertThat(e.getMessage(), containsString("Invalid format: [test_format]: Unknown pattern letter: t"));
    public void testSkipListIntegrationRegularDocValuesWhenDisabled() throws IOException {
        assertTrue(storedField.fieldType().stored());
        assertFalse("skip_list should be disabled", dateFieldMapper.skiplist());  
import org.apache.lucene.index.IndexableField;  
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "date").field("skip_list", false)));  
        assertFalse(dvField.fieldType().stored());  
import org.opensearch.index.engine.dataformat.stub.MockDocValuesDataFormatPlugin;
        DateFieldMapper dateFieldMapperNanos = (DateFieldMapper) mapperServiceNanos.documentMapper().mappers().getMapper("field");
            pluggableSettings,
        dateFieldMapper.deriveSource(builder, leafReader, 0);
        checker.registerConflictCheck("skip_list", b -> b.field("skip_list", true));  
        CapturingDocumentInput docInput = new CapturingDocumentInput();
        FieldInfo mockFieldInfo = new FieldInfo(
    public void testDeriveSource_WhenDocValuesEnabledAndDateType() throws IOException {
        String source = builder.toString();
    private static final long TEST_TIMESTAMP = 1739858400000L;
        );
    protected void assertParseMaximalWarnings() {
 * license agreements. See the NOTICE file distributed with
    }  
        // Test with skip_list=true
            fieldMapping(
        assertTrue("skip_list should be true in date_nanos mapper", dateFieldMapperNanos.skiplist());  
        IndexableField pointField = fields[0];  
            -1,
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
            0,
    public void testPluggablePathEquivalenceWithLucenePath() throws Exception {
    }
 * the Apache License, Version 2.0 (the "License"); you may
        MapperParsingException e = expectThrows(  
        );
    public void testDeriveSource_WhenStoredFieldEnabledWithMultiValue() throws IOException {
            "failed to parse date field [2016-03-99] with format [strict_date_optional_time||epoch_millis]"
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));  
            fieldMapping(b -> b.field("type", "date_nanos").field("format", "strict_date_time||epoch_millis").field("copy_to", "a"))
import java.time.ZoneId;  
 * ownership. Elasticsearch licenses this file to you under  
        );
        assertTrue(explicit.fieldType("field").isSearchable());  
        IndexableField dvField = fields[1];
            0,
    }
        assertThat(e.getMessage(), containsString("Error parsing [format] on field [field]: Invalid"));
        // Test default behavior for date_nanos  
        IndexableField[] fieldsNanos = docNanos.rootDoc().getFields("field");
    public void testNanosNullValue() throws IOException {
    protected void writeFieldValue(XContentBuilder builder) throws IOException {
        DateFieldMapper dateFieldMapper = (DateFieldMapper) mapper.mappers().getMapper("field");
 * Licensed to Elasticsearch under one or more contributor  
        assertTrue(source.contains("\"field\":[\"2025-02-18T06:00:00Z\",\"2025-02-18T07:00:00Z\"]"));
                    .field("format", "strict_date_optional_time_nanos")
 * Unless required by applicable law or agreed to in writing,
        assertEquals(2, fields.length);
        );  
     * defaults to false and the field reports itself as not searchable — routing queries to the
import static org.junit.Assume.assumeThat;
        MapperService explicit = createMapperService(fieldMapping(b -> {
        DateFieldMapper dateFieldMapper = (DateFieldMapper) mapperService.documentMapper().mappers().getMapper("field");
import org.apache.lucene.index.StoredFieldVisitor;  
        IndexSettings indexSettings = new IndexSettings(indexMetadata, settings);
import org.apache.lucene.index.VectorSimilarityFunction;  
    public void testMergeText() throws Exception {
        assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());
        DocumentMapper mapper = createDocumentMapper(
            () -> createDocumentMapper(fieldMapping(b -> b.field("type", "date").field("skip_list", "invalid")))  
            .stream()  
        long decoded = LongPoint.decodeDimension(encoded, 0);  
        // Verify point field  
        assertEquals("Should increment epoch millis", largeEpoch + 1, decoded);
            assertTrue("Lucene path should produce field '" + fieldName + "'", luceneFields.length > 0);
        // Create index settings with an index sort.
        SortedNumericDocValues docValues = mock(SortedNumericDocValues.class);  
            false,
            b.field("index", false);
        );  
        IndexableField dvField = fields[1];
        Settings settings = Settings.builder()
            false,
        IndexableField[] fields = doc.rootDoc().getFields("field");
        when(leafReader.storedFields()).thenReturn(storedFields);
        DateFieldMapper dateFieldMapper = (DateFieldMapper) mapperService.documentMapper().mappers().getMapper("field");  
        dateFieldMapper = (DateFieldMapper) mapper.mappers().getMapper("field");
        doAnswer(invocation -> {
        // Both should have the same field structure and values
        // Parse a document with date_nanos field
            pluggableSettings,
        DateFieldMapper dateFieldMapper = (DateFieldMapper) mapper.mappers().getMapper("field");  
    public void testIgnoreMalformed() throws IOException {  
        assertEquals(List.of(date), fetchFromDocValues(mapperService, ft, format, 1589578382123L));
        // Verify the mapper has skip_list enabled
        assertEquals("Should have 2 fields (point and doc values)", 2, fields.length);
        );
    private static Settings pluggableSettings() {
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "date").field("doc_values", false)));  
    }
        checker.registerConflictCheck("index", b -> b.field("index", false));
        assertEquals(
 * Modifications Copyright OpenSearch Contributors. See
        createDocumentMapper(fieldMapping(b -> b.field("type", "date").field("null_value", "foo")));  
    }
            -1,
        LeafReader leafReader = mock(LeafReader.class);
            "field",
        assertThrows(UnsupportedOperationException.class, dateFieldMapper::canDeriveSource);
        MapperService mapperService = createMapperService(pluggableSettings(), fieldMapping(this::minimalMapping));  
        checker.registerConflictCheck("locale", b -> b.field("locale", "es"));  
        assertTrue(source.contains("\"field\":\"2025-02-18T06:00:00Z\""));  
            fieldsDisabled[0].numericValue().longValue()  
    public void testSkipListIntegrationWithMultipleResolutions() throws IOException {  
        assertEquals(1, pointField.fieldType().pointIndexDimensionCount());
            1,
    }
        assertEquals(8, pointField.fieldType().pointNumBytes());  
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "2016-03-11")));
            false,  
            mapping(b -> b.startObject("field").field("type", "date").endObject())  
        assertTrue("Date_nanos field skip_list should be enabled", dateMapperNanos.skiplist());
            true,  
        doAnswer(invocation -> {
    }
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
    public void testPossibleToDeriveSource_WhenDocValuesAndStoreFieldDisabled() throws IOException {
        IndexableField pointField = fields[0];
        // Test NANOSECONDS resolution (date_nanos type)  
            minimalMapping(b);
        String dateValue = "2016-03-11T10:30:00Z";
        assertEquals(1, pointField.fieldType().pointIndexDimensionCount());
        MapperService mapperService = createMapperService(
        checker.registerConflictCheck("store", b -> b.field("store", true));
    public void testSkipListIntegrationDateNanosFieldWithIndexedDocValues() throws IOException {
            SingleFieldsVisitor visitor = invocation.getArgument(1);
                b.endObject();
import org.apache.lucene.index.LeafReader;
            minimalMapping(b);
        assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());  
        assertThat(e.getMessage(), containsString("Failed to parse mapping"));
        IndexableField[] fieldsDisabled = docDisabled.rootDoc().getFields("field");  
        MapperService mapperService = createMapperService(pluggableSettings(), fieldMapping(this::minimalMapping));
    }  
        builder.endObject();  
        MappedFieldType ft = mapperService.fieldType("field");  
        assertEquals(1, pointField.fieldType().pointIndexDimensionCount());  
    private void assertDateLuceneAndPluggablePathsEquivalent(  
        when(docValues.nextValue()).thenReturn(TEST_TIMESTAMP).thenReturn(TEST_TIMESTAMP + 3600000L); // One Hour Later  
            false,
        DateFormatter formatter = DateFormatter.forPattern(timeZonePattern);  
        // Test both MILLISECONDS and NANOSECONDS resolution with skip_list enabled
            b -> b.field("ignore_malformed", true),  
        assertEquals(8, pointField.fieldType().pointNumBytes());
            b.field("index", true);
        assertFalse("existing field's value should be preserved across the update", mapperService.fieldType("field").isSearchable());
    public void testDateEncodePoint() {
            .put("index.pluggable.dataformat.enabled", true)  
    public void testPluggableDataFormatMappingUpdateDefaultsNewFieldToNotIndexed() throws IOException {
            fieldMapping(
        // Test with timestamp field  
        e = expectThrows(  
            VectorEncoding.FLOAT32,
    public void testSkipListParameterInvalidValues() throws IOException {
        assertEquals(0, fields.length);  
        assertEquals(1, fields.length);
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)  
     * queries match nothing.  
import static org.hamcrest.Matchers.notNullValue;  
        assertFalse(dvField.fieldType().stored());
            () -> merge(mapperService, fieldMapping(b -> b.field("type", "date").field("format", "epoch_millis")))  
        dateFieldMapper = (DateFieldMapper) mapper.mappers().getMapper("field");  
        assertFalse(pointField.fieldType().stored());  
            MapperParsingException.class,
        assertEquals(1457654400000L, pointField.numericValue().longValue());
        // Verify doc values field - when skip_list=false, should use regular doc values
        when(leafReader.getSortedNumericDocValues("field")).thenReturn(docValues);
    @Override
        IndexableField pointField = fields[0];  
        ParsedDocument luceneDoc = luceneMapper.parse(source(sourceBuilder));  
        checker.registerConflictCheck("null_value", b -> b.field("null_value", "34500000"));
    }  
            pluggableSettings,  
                    .field("format", "strict_date_optional_time_nanos")
    public void testPluggableDataFormatRejectsExplicitIndexTrue() {  
        assertEquals(1457692200000L, dvField.numericValue().longValue());
        );
                minimalMapping(x);
    public void testDeriveSource_WhenDocValuesEnabledAndDateNanosType() throws IOException {  
     * value of the already-mapped field unchanged.
        assertEquals(List.of("2020-05-15T21:33:02.123Z"), fetchFromDocValues(mapperService, ft, format, 1589578382123L));  
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", formatter.format(randomDate))));
    public void testPossibleToDeriveSource_WhenDerivedSourceDisabled() throws IOException {  
        LeafReader leafReader = mock(LeafReader.class);  
            false
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)  
    protected void minimalMapping(XContentBuilder b) throws IOException {  
        assertEquals(List.of(date), fetchFromDocValues(mapperService, ft, format, date));  
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {  
        // Test skip_list=false with date_nanos type
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject();  
        ParsedDocument docNanos = mapperNanos.parse(source(b -> b.field("field", "2016-03-11T10:30:00.123456789Z")));
        mapper.parse(source(b -> b.field("field", "2025-02-18T06:00:00.000Z")), docInput);  
            DocValuesType.NONE,
        DateFieldMapper dateFieldMapper = (DateFieldMapper) mapperService.documentMapper().mappers().getMapper("field");
        ParsedDocument doc = mapper2.parse(source(b -> b.field("field", value)));  
        DocumentMapper mapperDisabled = createDocumentMapper(fieldMapping(b -> b.field("type", "date").field("skip_list", false)));
        // Verify doc values field - when skip_list=true, should use indexed doc values
        long negativeEpoch = -377705116800000L;  
        assertThat(e.getCause().getMessage(), containsString(expectedCause));
        assertEquals(8, pointField.fieldType().pointNumBytes());  
            fieldMapping(  
        );  
import org.apache.lucene.index.DocValuesSkipIndexType;
        );
            .build();
        Exception e = expectThrows(
        IndexableField[] fields = doc.rootDoc().getFields("field");
            DocValuesType.NONE,
        DocValueFormat format = ft.docValueFormat(null, null);  
            contextAwareGrouping("field").accept(b);
        IndexableField dvField = fields[1];
        DocumentMapper mapperEnabled = createDocumentMapper(fieldMapping(b -> b.field("type", "date").field("skip_list", true)));  
        decoded = LongPoint.decodeDimension(encoded, 0);  
        DateFieldMapper dateFieldMapper = (DateFieldMapper) mapper.mappers().getMapper("field");  
        assertFalse("skip_list should default to false for date_nanos", dateFieldMapper.skiplist());  
        DocumentMapper mapperMillis = createDocumentMapper(fieldMapping(b -> b.field("type", "date").field("skip_list", true)));
        Long expectedValue
    }
            SingleFieldsVisitor visitor = invocation.getArgument(1);
        if (expectedValue == null) {
            false,
        // Test that field behavior is consistent between skip_list enabled and disabled  
        assertThat(e.getMessage(), containsString("parameter [format] from [yyyy/MM/dd] to [epoch_millis]"));
        assertEquals(1, pointField.fieldType().pointIndexDimensionCount());
            () -> createDocumentMapper(fieldMapping(b -> b.field("type", "date").nullField("format")))
        checker.registerUpdateCheck(
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
        dateFieldMapper.deriveSource(builder, leafReader, 0);
        assertFalse(pointField.fieldType().stored());
    public void testExistsQueryDocValuesDisabled() throws IOException {  
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        assertFalse(pointField.fieldType().stored());
        );
        testIsSkiplistEnabled(mapper, false);
        MapperService mapperService = createMapperService(
        assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());
        assertEquals(expectedNullValue, pointField.numericValue().longValue());
                b -> b.field("type", "date").field("format", "strict_date_time_no_millis").field("doc_values", false).field("store", true)
            () -> createDocumentMapper(fieldMapping(b -> b.field("type", "date").field("format", "test_format")))
    public void testFetchDocValuesNanos() throws IOException {
    public void testPluggableDataFormatDateNullSkipped() throws Exception {  
 */  
        IndexableField dvField = fields[0];  
        );
     */  
            b.endObject();  
        IndexableField[] fields = doc.rootDoc().getFields("field");  
        assertTrue(source.contains("\"field\":\"2025-02-18T06:00:00Z\""));
        assertEquals(expectedValue, dateFieldMapper.isSkiplistDefaultEnabled(sortConfig, "@timestamp"));
                x.startObject("field");  
                    .field("store", false)
    public void testPluggableDataFormatMappingUpdateRejectsIndexTrue() throws IOException {  
    }
        DateFieldMapper dateFieldMapper = (DateFieldMapper) mapper.mappers().getMapper("field");
    }  
        assertTrue(mapperService.fieldType("field").isSearchable());  
     * doc-values column instead of an empty point index.
            m -> assertTrue(((DateFieldMapper) m).ignoreMalformed().value())
        assertFalse(pointField.fieldType().stored());
        assertEquals(8, pointField.fieldType().pointNumBytes());
        IndexableField pointField = fields[0];
    public void testIsSkiplistDefaultDisabledInOlderVersions() throws IOException {  
            1,  
        assertTrue(source.contains("\"field\":\"2025-02-18T06:00:00.111111111Z\""));
        // Test that skip_list parameter appears correctly in mapping definitions  
            pluggableSettings,
        ParsedDocument docDisabled = mapperDisabled.parse(source(b -> b.field("field", dateValue)));
    public void testPluggableDataFormatDefaultsIndexToFalse() throws IOException {
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();  
    }
        // Assert date field
            fieldMapping(
        );  
        }));
    }  
    }
        IndexMetadata noSortindexMetadata = new IndexMetadata.Builder("index").settings(getIndexSettings()).build();  
        );
        MapperService mapperService = createMapperService(
        );  
        String source = builder.toString();
            VectorSimilarityFunction.EUCLIDEAN,
        builder.endObject();  
        assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());  
        CapturingDocumentInput docInput = new CapturingDocumentInput();
        encoded = fieldType.encodePoint(negativeEpochStr, false);
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "date").field("store", true)));  
            true,  
    }
 * SPDX-License-Identifier: Apache-2.0
    }
        String source = builder.toString();
    }
        checker.registerUpdateCheck(b -> b.field("boost", 2.0), m -> assertEquals(m.fieldType().boost(), 2.0, 0));  
        assertEquals(baseTime + 1, decoded);
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        );
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "date_nanos").field("skip_list", true)));  
    /** Indices that do not use a pluggable dataformat keep the standard {@code index: true} default. */  
        MapperService mapperService = createMapperService(  
 *  
    /** A mapping update that sets index:true on a new field is rejected on a pluggable data format index. */
        pluggableMapper.parse(source(sourceBuilder), docInput);  
            IndexOptions.NONE,
        long millis = randomDate.withZoneSameInstant(ZoneOffset.UTC).toInstant().toEpochMilli();  
    /** An explicit {@code index: false} is accepted on a pluggable-dataformat index. */
            "2016-03-99",  
        StoredFields storedFields = mock(StoredFields.class);
        MapperService mapperService = createMapperService(
            .put("index.pluggable.dataformat", MockDocValuesDataFormatPlugin.FORMAT_NAME)
        assertEquals(3, fields.length);
        MapperService mapperService = createMapperService(  
    public void testIsSkiplistDefaultEnabled() throws IOException {  
        })));
    }
        // Test skip_list=false
        IndexableField dvField = fields[1];
    }  
            false,
        }));
        assertEquals("mapper [field] cannot be changed from type [date] to [text]", e.getMessage());
        DateFieldMapper dateFieldMapper = (DateFieldMapper) mapperService.documentMapper().mappers().getMapper("field");  
        );
                b -> b.field("type", "date").field("format", "strict_date_time_no_millis").field("doc_values", false).field("store", true)  
        // Scenario 1: date value
            DocValuesType.NONE,  
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> merge(mapperService, mapping(b -> {
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "date").field("index", false)));  
    public void testDeriveSource_NoValue() throws IOException {
            visitor.longField(mockFieldInfo, TEST_TIMESTAMP + 3600000); // One hour later
        assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        String largeEpochStr = String.valueOf(largeEpoch);
        doAnswer(invocation -> {
        );  
        IndexableField[] fields = doc.rootDoc().getFields("field");
    }  
import org.apache.lucene.index.VectorEncoding;
        // Verify the field structure
        when(leafReader.getSortedNumericDocValues("field")).thenReturn(docValues);
        assertEquals("Both should have same number of fields", fieldsEnabled.length, fieldsDisabled.length);
        }).when(storedFields).document(anyInt(), any(StoredFieldVisitor.class));  
    }
            minimalMapping(b);  
                minimalMapping(b);
            false
    }  
        MapperService mapperService = createMapperService(fieldMapping(b -> b.field("type", "date").field("format", "yyyy/MM/dd")));
        DateFieldMapper dateFieldMapper = (DateFieldMapper) mapperService.documentMapper().mappers().getMapper("field");
            DocValuesSkipIndexType.NONE,  
    }  
    }
        String source = builder.toString();  
    }
    public void testNotIndexed() throws Exception {
            )  
        assertThat(mapperService.fieldType("field"), notNullValue());
 *
    public void testSkipListIntegrationFieldBehaviorConsistency() throws IOException {
        e = expectThrows(
        b.field("type", "date");
            b.field("doc_values", false);  
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));  
            "field",
        IndexableField[] fields = doc.rootDoc().getFields("field");
        IndexableField pointField = fields[0];  
        boolean found = docInput.getCapturedFields()
    }
        MapperService mapperService = createMapperService(fieldMapping(b -> b.field("type", "date").field("skip_list", true)));  
            0,  
                .stream()
 * GitHub history for details.
            "Doc values field values should match",  
        assertFalse("Expected no captured field for null value", hasDateField);
 */  
    public void testPluggableDataFormatAcceptsExplicitIndexFalse() throws IOException {
        // Test with skip_list=false  
 * KIND, either express or implied.  See the License for the
            )  
        assertEquals(expectedNullValue, dvField.numericValue().longValue());
        builder.endObject();
            return null;
    }
    }  
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
                b -> b.field("type", "date").field("format", "strict_date_time_no_millis").field("store", false).field("doc_values", true)
 * this file be licensed under the Apache-2.0 license or a
            mapping(b -> b.startObject("field").field("type", "date").endObject()),
        testIgnoreMalformedForValue(  
        // Assert groupingcriteria is correct  
            FeatureFlags.isEnabled(FeatureFlags.DATETIME_FORMATTER_CACHING),  
        // Scenario 2: null value — no field produced
        assertFalse("newly added field should default to not-indexed", mapperService.fieldType("field2").isSearchable());  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
    protected void registerParameters(ParameterChecker checker) throws IOException {
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject();  
            () -> createDocumentMapper(fieldMapping(b -> b.field("type", "date").nullField("skip_list")))
        when(docValues.advanceExact(0)).thenReturn(true);  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
import static org.mockito.Mockito.doAnswer;
            b -> b.field("field", "2025-02-18T06:00:00.000Z"),  
        MapperService mapperService = createMapperService(
        // Test invalid numeric value
        assertEquals(1457692200000L, fieldsMillis[1].numericValue().longValue());
 * software distributed under the License is distributed on an
        MapperService mapperService = createMapperService(pluggableSettings(), fieldMapping(this::minimalMapping));  
        MapperParsingException e = expectThrows(
        FieldInfo mockFieldInfo = new FieldInfo(
            return null;
    }
        ParsedDocument doc = mapper.parse(source(b -> b.nullField("field")));
import org.opensearch.Version;
        assertTrue("skip_list should be true in mapper", dateFieldMapper.skiplist());
            fieldMapping(b -> b.field("type", "date").field("format", "E, d MMM yyyy HH:mm:ss Z").field("locale", "de"))  
        assertFalse(dvField.fieldType().stored());
    public void testWithContextAwareGroupingMapper() throws IOException {
            0,  
import org.opensearch.plugins.Plugin;
        assertEquals("{}", source);
    }
        when(docValues.docValueCount()).thenReturn(1);
    }
        assertThat(e.getMessage(), containsString("[format] on mapper [field] of type [date] must not have a [null] value"));
        assertEquals(1457654400000L, pointField.numericValue().longValue());
        assertEquals("Should decrement epoch millis", negativeEpoch - 1, decoded);
        ParsedDocument doc = mapper.parse(source(b -> b.nullField("field")));
        final ZoneId randomTimeZone = randomBoolean() ? ZoneId.of(randomFrom("UTC", "CET")) : randomZone();
        assertThrows(UnsupportedOperationException.class, dateFieldMapper::canDeriveSource);
        MapperService mapperService = createMapperService(fieldMapping(this::minimalMapping));  
            fieldMapping(b -> b.field("type", "date_nanos").field("format", "strict_date_time||epoch_millis").field("copy_to", "a"))
            return null;
        DocumentMapper pluggableMapper = createDocumentMapper(pluggableSettings, mappingBuilder);
        StoredFields storedFields = mock(StoredFields.class);
        assertFalse(mapperService.fieldType("field").isSearchable());  
        DateFieldMapper dateFieldMapper = (DateFieldMapper) mapper.mappers().getMapper("field");
import org.opensearch.core.xcontent.XContentBuilder;
            .putList("index.sort.field", "field")  
        IndexableField[] fields = doc.rootDoc().getFields("field");  
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "date").field("format", timeZonePattern)));
        final String timeZonePattern = "yyyy-MM-dd" + randomFrom("XXX", "[XXX]", "'['XXX']'");
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
        MappedFieldType ft = mapperService.fieldType("field");
        assertEquals(1457654400000L, pointField.numericValue().longValue());  
            false,
            MapperParsingException.class,
    }
        builder.endObject();
        IndexableField pointField = fields[0];  
        }));
    /** The rejection names the concrete resolution so {@code date_nanos} is not reported as {@code date}. */
        assertEquals(2, fields.length);
        mapper.parse(source(b -> b.field("field", "Mi., 06 Dez. 2000 02:55:00 -0800")));  
        assertEquals(1457692200000L, fieldsMillis[0].numericValue().longValue());  
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "2016-03-11")));  
        byte[] encoded = fieldType.encodePoint("2024-01-15T10:30:00Z", true);
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
            }))  
            0,
            "field",
        IndexableField[] fields = doc.rootDoc().getFields("field");  
        decoded = LongPoint.decodeDimension(encoded, 0);
        testIsSkiplistEnabled(mapper, true);
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        when(docValues.advanceExact(0)).thenReturn(false);
    public void testDeriveSource_WhenDocValuesEnabledWithMultiValue() throws IOException {
 * not use this file except in compliance with the License.
        IndexableField[] fields = doc.rootDoc().getFields("field");  
        DocumentMapper mapperNanos = createDocumentMapper(fieldMapping(b -> b.field("type", "date_nanos").field("skip_list", true)));
        // Test basic roundUp  
            IndexOptions.NONE,
        // Test with no index sort and non-timestamp field
        // Test skip_list=true with date_nanos type
        testIgnoreMalformedForValue("-2147483648", "Invalid value for Year (valid values -999999999 - 999999999): -2147483648");  
            b -> b.nullField("field"),  
            fieldMapping(b -> b.field("type", "date_nanos").field("null_value", "2016-03-11"))  
        mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "date").field("null_value", "2016-03-11")));
        dateFieldMapper.deriveSource(builder, leafReader, 0);
        merge(mapperService, mapping(b -> {  
    public void testSkipListParameterValidBooleanValues() throws IOException {
            b.endObject();  
        // timestamp field
        return List.of(new MockDocValuesDataFormatPlugin());
            fieldMapping(b -> b.field("type", "date_nanos").field("format", "strict_date_time||epoch_millis"))  
        );
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "2016-03-11")));
        MapperService mapperService = createMapperService(  
            fieldMapping(b -> b.field("type", "date").field("format", "strict_date_time||epoch_millis"))
/*
        doc = mapperService.documentMapper().parse(source(b -> b.nullField("field")));  
 * specific language governing permissions and limitations
        );
        assertWarnings("Parameter [boost] on field [field] is deprecated and will be removed in 3.0");
        assertEquals(1457654400000L, pointField.numericValue().longValue());  
            MapperParsingException.class,
import org.opensearch.search.DocValueFormat;  
        assertFalse("skip_list should be false", dateFieldMapper.skiplist());
        IndexableField pointField = fields[0];
    private void testIsSkiplistEnabled(DocumentMapper mapper, boolean expectedValue) throws IOException {
                    .field("doc_values", true)  
        return Settings.builder()
            0,
                b -> b.field("type", "date_nanos")
        assertTrue("skip_list should be true for date_nanos", dateFieldMapper.skiplist());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**  
        assertEquals(1457692200000L, pointField.numericValue().longValue());
    public void testTimeZoneParsing() throws Exception {
        // Test basic roundDown
        DateFieldMapper dateFieldMapper = (DateFieldMapper) mapperService.documentMapper().mappers().getMapper("field");
        DocumentMapper mapper = createDocumentMapper(
        // Verify point field
        assertDateLuceneAndPluggablePathsEquivalent(  
                b -> b.field("type", "date").field("format", "strict_date_time_no_millis").field("store", false).field("doc_values", true)
            false
        String source = builder.toString();
        assertEquals(List.of(date), fetchFromDocValues(mapperService, ft, format, date));
        );  
    public void testNonPluggableDataFormatKeepsIndexTrue() throws IOException {
            "Using experimental datetime format as default",
        assertEquals(1457654400000L, dvField.numericValue().longValue());  
            visitor.longField(mockFieldInfo, TEST_TIMESTAMP);  
        // Parse a document with date field
        DateFieldMapper.DateFieldType ft = (DateFieldMapper.DateFieldType) mapperService.fieldType("field");  
    }
        assertEquals(8, pointField.fieldType().pointNumBytes());
import org.opensearch.index.IndexSettings;  
/*  
    public void testChangeFormat() throws IOException {
        assertEquals(1, pointField.fieldType().pointIndexDimensionCount());  
import org.opensearch.common.xcontent.XContentFactory;
        assertEquals(1, pointField.fieldType().pointIndexDimensionCount());
        when(leafReader.storedFields()).thenReturn(storedFields);
            false,  
        IndexableField[] fields = doc.rootDoc().getFields("field");
import java.util.Collection;  
/*  
    }  
import org.apache.lucene.index.FieldInfo;
        // Create mapper with skip_list=true
        testIgnoreMalformedForValue(
            VectorEncoding.FLOAT32,
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        long baseTime = fieldType.parse("2024-01-15T10:30:00Z");
        assertFalse(dvField.fieldType().stored());
    public void testDeriveSource_WhenStoredFieldEnabledAndDateType() throws IOException {  
        encoded = fieldType.encodePoint("2024-01-15T10:30:00Z", false);  
import org.opensearch.common.time.DateFormatter;
import org.apache.lucene.index.DocValuesType;  
            false,  
        assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());  
        assertThat(e.getMessage(), containsString("Failed to parse mapping"));  
        ParsedDocument docMillis = mapperMillis.parse(source(b -> b.field("field", "2016-03-11T10:30:00Z")));
        assertTrue(source.contains("\"field\":\"2025-02-18T06:00:00.222222222Z\""));
    public void testDefaults() throws Exception {
        when(docValues.nextValue()).thenReturn(TEST_TIMESTAMP);
        mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "date_nanos")));
            "field",
            fieldMapping(b -> b.field("type", "date").field("doc_values", false).field("store", false))  
        );
            Collections.emptyMap(),
                .anyMatch(e -> e.getKey().name().equals(fieldName) && e.getValue().equals(expectedValue));  
            )
        IndexableField dvField = fields[1];
    public void testSkipListParameterDateNanos() throws IOException {
        assertArrayEquals(new String[] { "field" }, TermVectorsService.getValues(doc.rootDoc().getFields("_ignored")));
import static org.mockito.Mockito.when;  
            fieldMapping(  
 * You may obtain a copy of the License at  
import org.opensearch.index.fieldvisitor.SingleFieldsVisitor;  
            MapperParsingException.class,
            () -> createMapperService(pluggableSettings(), fieldMapping(b -> b.field("type", "date_nanos").field("index", true)))
        CheckedConsumer<XContentBuilder, IOException> sourceBuilder,  
        assertFalse(pointField.fieldType().stored());  
        dateFieldMapper = (DateFieldMapper) mapper.mappers().getMapper("field");  
        }
    public void testPluggableDataFormatRejectsExplicitIndexTrueForDateNanos() {
import java.time.ZonedDateTime;
        );
        // Test null value
        XContentBuilder mappingBuilder,
        IndexableField pointField = fields[0];
            fieldMapping(
        final ZonedDateTime randomDate = ZonedDateTime.of(2016, 3, 11, 0, 0, 0, 0, randomTimeZone);
        LeafReader leafReader = mock(LeafReader.class);
import static org.hamcrest.Matchers.containsString;
        ParsedDocument docEnabled = mapperEnabled.parse(source(b -> b.field("field", dateValue)));
        StoredFields storedFields = mock(StoredFields.class);
        // Verify the field structure
    public void testPluggableDataFormatDefaultsIndexToFalseForDateNanos() throws IOException {  
    }
    @Override  
        assertThat(e.getMessage(), containsString("cannot cover: [POINT_RANGE]"));
     */
    public void testNoDocValues() throws Exception {
            () -> createDocumentMapper(fieldMapping(b -> b.field("type", "date").field("skip_list", 123)))
            "field",  
        // Verify the mapper has skip_list disabled
        DateFieldMapper dateFieldMapper = (DateFieldMapper) mapperService.documentMapper().mappers().getMapper("field");  
import java.time.ZoneOffset;
    }
        );
        when(leafReader.getSortedNumericDocValues("field")).thenReturn(docValues);
            IllegalArgumentException.class,
        // Verify the field structure  
        );  
     * index is written — so the mapping is rejected rather than silently producing a field whose
        IndexableField storedField = fields[2];
        MapperService mapperService = createMapperService(
            fieldMapping(
        );
    }  
            Collections.emptyMap(),
            SingleFieldsVisitor visitor = invocation.getArgument(1);  
        assertEquals(1, fields.length);
        mapper.parse(source(b -> b.nullField("field")), docInput);
    public void testPossibleToDeriveSource_WhenCopyToPresent() throws IOException {
    }
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "2016-03-11")));
                b.field("index", true);
        assertEquals(1457692200000L, dvField.numericValue().longValue());
        assertTrue("skip_list should be true", dateFieldMapper.skiplist());
    }
        assertThat(e.getMessage(), containsString("Failed to parse mapping"));
            MapperParsingException.class,
        assertEquals(8, pointField.fieldType().pointNumBytes());
        assertEquals(8, pointField.fieldType().pointNumBytes());
            VectorSimilarityFunction.EUCLIDEAN,  
            is(true)
        assertEquals(1457654400000L, storedField.numericValue().longValue());  
        assertEquals(expectedValue, dateFieldMapper.isSkiplistDefaultEnabled(noSortConfig, "@timestamp"));
        String source = builder.toString();  
        assertTrue("skip_list should be enabled", dateFieldMapper.skiplist());
        assertParseMinimalWarnings();  
            boolean pluggableFound = docInput.getCapturedFields()
        );
        assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());
        assertEquals(1, pointField.fieldType().pointIndexDimensionCount());
        DocValueFormat format = ft.docValueFormat(null, null);
        assertEquals(2, fields.length);
        encoded = fieldType.encodePoint(largeEpochStr, true);  
            fieldsEnabled[0].numericValue().longValue(),
        }));
        assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field"));
import java.util.List;
            b.startObject("field2");
        );
    }  
import java.io.IOException;
            )
        );  
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();  
            minimalMapping(b);  
    public void testIllegalFormatField() {
            assertFalse("Pluggable path should produce no field for '" + fieldName + "'", pluggableHasField);
            mapping(b -> b.startObject("field").field("type", "date").endObject()),
    }  
        IndexableField[] fields = doc.rootDoc().getFields("field");
import java.util.Collections;
        SortedNumericDocValues docValues = mock(SortedNumericDocValues.class);
        assertFalse(pointField.fieldType().stored());
    }
        assertEquals("Should have 2 fields (point and doc values)", 2, fields.length);
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
        assertEquals(1457654400000L, dvField.numericValue().longValue());
 */
            VectorEncoding.FLOAT32,
            0,  
        dateFieldMapper.deriveSource(builder, leafReader, 0);
        } else {  
    private void testIgnoreMalformedForValue(String value, String expectedCause) throws IOException {
        IndexableField pointField = fields[0];  
        );
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "date").field("format", "epoch_second")));  
        // Test MILLISECONDS resolution (date type)  
        assertFalse(dvField.fieldType().stored());
        assertEquals(1, pointField.fieldType().pointIndexDimensionCount());
        assertEquals(2, fields.length);
        // Test skip_list=true
        builder.value("2016-03-11");
        // Test default behavior when skip_list parameter is omitted
        dateFieldMapper.deriveSource(builder, leafReader, 0);
        assertEquals(millis, fields[0].numericValue().longValue());
    }
            0,  
        MapperService mapperServiceNanos = createMapperService(fieldMapping(b -> b.field("type", "date_nanos").field("skip_list", true)));
        SortedNumericDocValues docValues = mock(SortedNumericDocValues.class);
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "2016-03-11T10:30:00Z")));
        MapperService mapperService = createMapperService(fieldMapping(this::minimalMapping));
        );
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "2016-03-11T10:30:00Z")));  
        String date = "2020-05-15T21:33:02.123456789Z";
        IndexSortConfig noSortConfig = new IndexSortConfig(new IndexSettings(noSortindexMetadata, getIndexSettings()));
        DateFieldMapper dateMapperNanos = (DateFieldMapper) mapperNanos.mappers().getMapper("field");
    public void testFetchDocValuesMillis() throws IOException {
        IndexableField[] fieldsEnabled = docEnabled.rootDoc().getFields("field");
        SortedNumericDocValues docValues = mock(SortedNumericDocValues.class);  
        assertTrue("skip_list should be enabled", dateFieldMapper.skiplist());
        dateFieldMapper.deriveSource(builder, leafReader, 0);  
