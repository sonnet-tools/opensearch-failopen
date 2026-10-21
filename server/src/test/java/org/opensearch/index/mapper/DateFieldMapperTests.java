        IndexableField[] fields = doc.rootDoc().getFields("field");
        IndexSortConfig sortConfig = new IndexSortConfig(indexSettings);
import java.time.ZoneOffset;
            0,
        );
import org.apache.lucene.document.LongPoint;
        IndexableField pointField = fields[0];
            properties(x -> {
        assertTrue(source.contains("\"field\":[\"2025-02-18T06:00:00Z\",\"2025-02-18T07:00:00Z\"]"));
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        // Verify doc values field - when skip_list=true, should use indexed doc values
        assertEquals("Expected timestamp should match", expectedTimestamp, fieldsEnabled[0].numericValue().longValue());
        // Test with extreme long values,
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
            IllegalArgumentException.class,
    @Override
        assertEquals(8, pointField.fieldType().pointNumBytes());
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertEquals(1457692200000L, fieldsMillis[0].numericValue().longValue());
        IndexableField[] fields = doc.rootDoc().getFields("field");
    public void testSkipListParameterInvalidValues() throws IOException {
        // Test skip_list=false
import static org.hamcrest.Matchers.notNullValue;
        IndexableField pointField = fields[0];
            fieldsDisabled[1].numericValue().longValue()
        // Test with timestamp field
import static org.junit.Assume.assumeThat;
                .stream()
        );
import org.apache.lucene.index.LeafReader;
        dateFieldMapper = (DateFieldMapper) mapper.mappers().getMapper("field");
        CapturingDocumentInput docInput = new CapturingDocumentInput();
        assertFalse(dvField.fieldType().stored());
        assertEquals(1, fields.length);
            "field",
        assertFalse(dvField.fieldType().stored());
            1,
    private void assertDateLuceneAndPluggablePathsEquivalent(
            pluggableSettings,
 * the Apache License, Version 2.0 (the "License"); you may
            minimalMapping(b);
        }));
        assertDateLuceneAndPluggablePathsEquivalent(
        assertEquals(expectedValue, dateFieldMapper.isSkiplistDefaultEnabled(sortConfig, "@timestamp"));
    public void testSkipListIntegrationFieldBehaviorConsistency() throws IOException {
    /** {@code date_nanos} resolves through a separate type parser, so it is covered explicitly. */
        String source = builder.toString();
        DocValueFormat format = ft.docValueFormat(null, null);
                    .field("store", false)
        when(docValues.nextValue()).thenReturn(TEST_TIMESTAMP * 1000000L + 222222222L);
import java.time.ZoneId;
        assertThat(e.getMessage(), containsString("Failed to parse mapping"));
        MapperService mapperServiceNanos = createMapperService(fieldMapping(b -> b.field("type", "date_nanos").field("skip_list", true)));
        when(leafReader.storedFields()).thenReturn(storedFields);
            0,
        assertEquals(1, pointField.fieldType().pointIndexDimensionCount());
import org.apache.lucene.index.IndexableField;
        mapper.parse(source(b -> b.field("field", "Mi., 06 Dez. 2000 02:55:00 -0800")));
    }
                b -> b.field("type", "date_nanos")
        String negativeEpochStr = String.valueOf(negativeEpoch);
        DocumentMapper mapperNanos = createDocumentMapper(fieldMapping(b -> b.field("type", "date_nanos").field("skip_list", true)));
            )
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "date").field("doc_values", false)));
     * A field added by a later mapping update also defaults to not-indexed, and the update leaves the
package org.opensearch.index.mapper;
import org.opensearch.common.util.FeatureFlags;
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "2016-03-11")));
        assertEquals("Should have 2 fields (point and doc values)", 2, fields.length);
        // Verify the field structure
    public void testPossibleToDeriveSource_WhenDocValuesAndStoreFieldDisabled() throws IOException {
    }
        builder.endObject();
    public void testNotIndexed() throws Exception {
        dateFieldMapper.deriveSource(builder, leafReader, 0);
 *
            b.field("doc_values", false);
        assertFalse(mapperService.fieldType("field").isSearchable());
    }
        builder.endObject();
        when(docValues.docValueCount()).thenReturn(1);
        String largeEpochStr = String.valueOf(largeEpoch);
    }
            fieldsDisabled[0].numericValue().longValue()
        );
import java.util.Collections;
    /**
                    .field("doc_values", false)
/*
        // Verify the field structure
        assertEquals(baseTime - 1, decoded);
    }
            boolean pluggableHasField = docInput.getCapturedFields().stream().anyMatch(e -> e.getKey().name().equals(fieldName));
        builder.endObject();
        DateFieldMapper dateFieldMapper = (DateFieldMapper) mapperService.documentMapper().mappers().getMapper("field");
            false
        checker.registerConflictCheck("print_format", b -> b.field("print_format", "yyyy-MM-dd"));
    public void testSkipListIntegrationMappingDefinitionSerialization() throws IOException {
    public void testDefaults() throws Exception {
    }
        MapperService mapperService = createMapperService(
        // Test creating index with skip_list=false for date field
        testIgnoreMalformedForValue("-2147483648", "Invalid value for Year (valid values -999999999 - 999999999): -2147483648");
     * queries match nothing.
     * defaults to false and the field reports itself as not searchable — routing queries to the
        assertTrue(storedField.fieldType().stored());
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "date").field("skip_list", true)));
            IndexOptions.NONE,
        MapperService mapperService = createMapperService(
        DateFieldMapper dateFieldMapper = (DateFieldMapper) mapperService.documentMapper().mappers().getMapper("field");
        // Verify the field structure
import org.apache.lucene.index.IndexOptions;
    }
        assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field"));
        assertEquals(2, fields.length);
        DocumentMapper mapper = createDocumentMapper(
        // Test default behavior for date_nanos
    }
        assertEquals(0, fields.length);
        String source = builder.toString();
            VectorSimilarityFunction.EUCLIDEAN,
        e = expectThrows(
        when(docValues.docValueCount()).thenReturn(2);
            0,
    public void testPluggableDataFormatDefaultsIndexToFalse() throws IOException {
        assertEquals(1457654400000L, dvField.numericValue().longValue());
            fieldsEnabled[1].numericValue().longValue(),
        DateFieldMapper dateFieldMapper = (DateFieldMapper) mapperService.documentMapper().mappers().getMapper("field");
        assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());
        // Parse a document with date field
                    .field("format", "strict_date_optional_time_nanos")
        }));
        assertEquals(1, pointField.fieldType().pointIndexDimensionCount());
        );
        StoredFields storedFields = mock(StoredFields.class);
        assertFalse(pointField.fieldType().stored());
            .build();
        IndexableField[] fieldsMillis = docMillis.rootDoc().getFields("field");
        DateFieldMapper dateFieldMapper = (DateFieldMapper) mapper.mappers().getMapper("field");
    public void testStore() throws Exception {
        CapturingDocumentInput docInput = new CapturingDocumentInput();
        ParsedDocument docNanos = mapperNanos.parse(source(b -> b.field("field", "2016-03-11T10:30:00.123456789Z")));
            minimalMapping(b);
    public void testIgnoreMalformed() throws IOException {
        assertEquals(1457654400000L, pointField.numericValue().longValue());
        assertEquals(8, pointField.fieldType().pointNumBytes());
        DateFieldMapper dateFieldMapper = (DateFieldMapper) mapper.mappers().getMapper("field");
    }
        IndexableField pointField = fields[0];
        dateFieldMapper.deriveSource(builder, leafReader, 0);
        Settings pluggableSettings,
 * GitHub history for details.
        Long expectedValue
        DateFieldMapper dateFieldMapper = (DateFieldMapper) mapper.mappers().getMapper("field");
        MapperService mapperService = createMapperService(
        DateFieldMapper dateFieldMapper = (DateFieldMapper) mapperService.documentMapper().mappers().getMapper("field");
        dateFieldMapper.deriveSource(builder, leafReader, 0);
    }
        assertEquals("Should have 2 fields (point and doc values)", 2, fields.length);
        decoded = LongPoint.decodeDimension(encoded, 0);
        // Test null value
        IndexableField dvField = fields[1];
        assertEquals("Both should have same number of fields", fieldsEnabled.length, fieldsDisabled.length);
            SingleFieldsVisitor visitor = invocation.getArgument(1);
        IllegalArgumentException e = expectThrows(
        );
        encoded = fieldType.encodePoint(negativeEpochStr, false);
    public void testPossibleToDeriveSource_WhenDerivedSourceDisabled() throws IOException {
import org.opensearch.index.engine.dataformat.stub.MockDocValuesDataFormatPlugin;
        LeafReader leafReader = mock(LeafReader.class);
            false,
        assertFalse(mapperService.fieldType("field").isSearchable());
        assertEquals(1457692200000L, fieldsMillis[1].numericValue().longValue());
    @Override
        assertFalse("skip_list should be disabled", dateFieldMapper.skiplist());
    }
            true,
        // Scenario 1: date value
            .stream()
        String source = builder.toString();
            MapperParsingException.class,
        checker.registerConflictCheck("index", b -> b.field("index", false));
    public void testSkipListParameterDefaultBehavior() throws IOException {
    }
        dateFieldMapper.deriveSource(builder, leafReader, 0);
        assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field"));
        IndexSortConfig noSortConfig = new IndexSortConfig(new IndexSettings(noSortindexMetadata, getIndexSettings()));
            0,
        // Verify doc values field - when skip_list=false, should use regular doc values
        assertFalse("Expected no captured field for null value", hasDateField);
        // Parse a document with date field
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "date").field("store", true)));
            DocValuesType.NONE,
            "Using experimental datetime format as default",
        when(leafReader.storedFields()).thenReturn(storedFields);
        mapper.parse(source(b -> b.nullField("field")), docInput);
        StoredFields storedFields = mock(StoredFields.class);
    }
    }
    }
        DateFieldMapper dateMapperNanos = (DateFieldMapper) mapperNanos.mappers().getMapper("field");
            "field",
                b.field("index", true);
        IndexableField[] fields = doc.rootDoc().getFields("field");
            return null;
    }
            )
import org.opensearch.common.xcontent.XContentFactory;
            minimalMapping(b);
            "field",
        String date = "2020-05-15T21:33:02.123456789Z";
            () -> createDocumentMapper(fieldMapping(b -> b.field("type", "date").nullField("format")))
        IndexableField dvField = fields[1];
            false,
        merge(mapperService, mapping(b -> {
 * SPDX-License-Identifier: Apache-2.0
    }
    public void testSkipListIntegrationRegularDocValuesWhenDisabled() throws IOException {
            .putList("index.sort.field", "field")
            false,
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "2016-03-11T10:30:00Z")));
    public void testIsSkiplistDefaultEnabled() throws IOException {
        MapperParsingException e = expectThrows(
        );
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
    }
            () -> createMapperService(pluggableSettings(), fieldMapping(b -> b.field("type", "date_nanos").field("index", true)))
        assertEquals(8, pointField.fieldType().pointNumBytes());
                b.endObject();
            .build();
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
        DocumentMapper mapperDisabled = createDocumentMapper(fieldMapping(b -> b.field("type", "date").field("skip_list", false)));
            }))
        MapperService mapperService = createMapperService(fieldMapping(b -> b.field("type", "date").field("format", "yyyy/MM/dd")));
        IndexableField[] fields = doc.rootDoc().getFields("field");
            Collections.emptyMap(),
        MapperService mapperService = createMapperService(fieldMapping(b -> {
        // timestamp field
        dateFieldMapper = (DateFieldMapper) mapper.mappers().getMapper("field");
        checker.registerConflictCheck("skip_list", b -> b.field("skip_list", true));
        MapperService mapperService = createMapperService(fieldMapping(this::minimalMapping));
        assertFalse(pointField.fieldType().stored());
        assertThat(e.getMessage(), containsString("failed to parse field [field] of type [date]"));
        DateFieldMapper dateFieldMapper = (DateFieldMapper) mapperService.documentMapper().mappers().getMapper("field");
        LeafReader leafReader = mock(LeafReader.class);
    }
        assertThat(e.getMessage(), containsString("[format] on mapper [field] of type [date] must not have a [null] value"));
        assertEquals(1, pointField.fieldType().pointIndexDimensionCount());
        MapperService mapperService = createMapperService(
            () -> createDocumentMapper(fieldMapping(b -> b.field("type", "date").field("skip_list", 123)))
    private void testIgnoreMalformedForValue(String value, String expectedCause) throws IOException {
        long expectedTimestamp = 1457692200000L;
    @Override
import org.opensearch.cluster.metadata.IndexMetadata;
        IndexableField pointField = fields[0];
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
        String source = builder.toString();
        assertEquals("mapper [field] cannot be changed from type [date] to [text]", e.getMessage());
        assertEquals(expectedValue, dateFieldMapper.isSkiplistDefaultEnabled(noSortConfig, "@timestamp"));
        IndexMetadata indexMetadata = new IndexMetadata.Builder("index").settings(settings).build();
        assertExistsQuery(mapperService);
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "date").field("format", "epoch_second")));
        );
import org.opensearch.index.IndexSettings;
        // Verify the mapper has skip_list enabled
            false,
        }).when(storedFields).document(anyInt(), any(StoredFieldVisitor.class));
        MapperService mapperService = createMapperService(
                minimalMapping(x);
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
    public void testIsSkiplistDefaultDisabledInOlderVersions() throws IOException {
        ParsedDocument doc = mapper.parse(source(b -> b.nullField("field")));
        MapperService mapperService = createMapperService(
        FieldInfo mockFieldInfo = new FieldInfo(
            VectorEncoding.FLOAT32,
        MapperService mapperService = createMapperService(pluggableSettings(), fieldMapping(this::minimalMapping));
        // Test basic roundDown
                b -> b.field("type", "date_nanos")
            b.startObject("field2");
        assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());
        // Test with skip_list=false
            () -> merge(mapperService, fieldMapping(b -> b.field("type", "text")))
    public void testPluggablePathEquivalenceWithLucenePath() throws Exception {
        IndexableField dvField = fields[1];
        // Create mapper with skip_list=true
    }
    }
        dateFieldMapper.deriveSource(builder, leafReader, 0);
        IndexableField[] fields = doc.rootDoc().getFields("field");
    }
            DocValuesType.NONE,
            0,
 * KIND, either express or implied.  See the License for the
    public void testPluggableDataFormatRejectsExplicitIndexTrueForDateNanos() {
        encoded = fieldType.encodePoint("2024-01-15T10:30:00Z", false);
    }
        assertThrows(UnsupportedOperationException.class, dateFieldMapper::canDeriveSource);
            false
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
        assertTrue("Date_nanos field skip_list should be enabled", dateMapperNanos.skiplist());
import org.opensearch.index.termvectors.TermVectorsService;
        DocumentMapper mapper2 = createDocumentMapper(fieldMapping(b -> b.field("type", "date").field("ignore_malformed", true)));
            TEST_TIMESTAMP
            Collections.emptyMap(),
            FeatureFlags.isEnabled(FeatureFlags.DATETIME_FORMATTER_CACHING),
        final String timeZonePattern = "yyyy-MM-dd" + randomFrom("XXX", "[XXX]", "'['XXX']'");
        IndexableField[] fields = doc.rootDoc().getFields("field");
            1,
                    .field("doc_values", true)
        XContentBuilder mappingBuilder,
        assertThat(e.getCause().getMessage(), containsString(expectedCause));
        assertFalse(dvField.fieldType().stored());
        assertEquals("Should increment epoch millis", largeEpoch + 1, decoded);
        long decoded = LongPoint.decodeDimension(encoded, 0);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertParseMinimalWarnings();
        checker.registerConflictCheck("null_value", b -> b.field("null_value", "34500000"));
    }
        DocValueFormat format = ft.docValueFormat(null, null);
    public void testDeriveSource_WhenStoredFieldEnabledAndDateType() throws IOException {
        boolean found = docInput.getCapturedFields()
        assertTrue("skip_list should be true", dateFieldMapper.skiplist());
        assertDateLuceneAndPluggablePathsEquivalent(
        }));
 * software distributed under the License is distributed on an
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
            DocValuesType.NONE,
            0,
            fieldMapping(b -> b.field("type", "date_nanos").field("format", "strict_date_time||epoch_millis").field("copy_to", "a"))
        DateFieldMapper dateFieldMapper = (DateFieldMapper) mapper.mappers().getMapper("field");
            0,
        assertEquals(1, pointField.fieldType().pointIndexDimensionCount());
    }
        when(leafReader.getSortedNumericDocValues("field")).thenReturn(docValues);
        assertFalse(pointField.fieldType().stored());
            false,
        assertTrue("Expected timestamp for date field", found);
        testIsSkiplistEnabled(mapper, true);
                b -> b.field("type", "date").field("format", "strict_date_time_no_millis").field("doc_values", false).field("store", true)
        DateFieldMapper dateFieldMapper = (DateFieldMapper) mapper.mappers().getMapper("field");
    }
        createDocumentMapper(fieldMapping(b -> b.field("type", "date").field("null_value", "foo")));
    public void testNonPluggableDataFormatKeepsIndexTrue() throws IOException {
            1,
            boolean pluggableFound = docInput.getCapturedFields()
        IndexableField dvField = fields[0];
        assertFalse("skip_list should default to false", dateFieldMapper.skiplist());
        when(leafReader.storedFields()).thenReturn(storedFields);
            assertTrue("Pluggable path should capture field '" + fieldName + "' with value '" + expectedValue + "'", pluggableFound);
        when(docValues.docValueCount()).thenReturn(1);
        doAnswer(invocation -> {
        // Test skip_list=true with date_nanos type
        assertEquals(2, fields.length);
        IndexableField pointField = fields[0];
        DateFieldMapper dateFieldMapper = (DateFieldMapper) mapper.mappers().getMapper("field");
        );
        assertEquals("2016-03-11", doc.docs().getFirst().getGroupingCriteria());
        );
        DateFieldMapper dateFieldMapper = (DateFieldMapper) mapperService.documentMapper().mappers().getMapper("field");
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "date").field("skip_list", false)));
 * under the License.
        MapperService mapperService = createMapperService(fieldMapping(b -> b.field("type", "date").field("skip_list", true)));
            MapperParsingException.class,
        when(docValues.nextValue()).thenReturn(TEST_TIMESTAMP);
        ParsedDocument docDisabled = mapperDisabled.parse(source(b -> b.field("field", dateValue)));
import org.opensearch.common.time.DateFormatter;
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
            is(true)
        // Parse a document with date_nanos field
    }
        assertArrayEquals(new String[] { "field" }, TermVectorsService.getValues(doc.rootDoc().getFields("_ignored")));
        // Test default behavior when skip_list parameter is omitted
        assertTrue("skip_list should be true in date_nanos mapper", dateFieldMapperNanos.skiplist());
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "date")));
        );
            fieldMapping(
        );
import org.opensearch.common.CheckedConsumer;
        // Verify point field
        }).when(storedFields).document(anyInt(), any(StoredFieldVisitor.class));
        MapperService mapperService = createMapperService(pluggableSettings(), fieldMapping(this::minimalMapping));
        SortedNumericDocValues docValues = mock(SortedNumericDocValues.class);
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "2016-03-11T10:30:00Z")));
            b.field("index", false);
        long expectedNullValue = ft.parse("2016-03-11");
        MapperService mapperService = createMapperService(
        String dateValue = "2016-03-11T10:30:00Z";
            mapping(b -> b.startObject("field").field("type", "date").endObject())
        assertEquals("{}", source);
            VectorEncoding.FLOAT32,
            "field",
        assertEquals(1, pointField.fieldType().pointIndexDimensionCount());
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "2016-03-11")));
    }
            )
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        b.field("type", "date");
            fieldMapping(b -> b.field("type", "date_nanos").field("format", "strict_date_time||epoch_millis"))
            "Point field values should match",
import org.opensearch.common.settings.Settings;
        LeafReader leafReader = mock(LeafReader.class);
 * license agreements. See the NOTICE file distributed with
        assertEquals(1457692200000L, pointField.numericValue().longValue());
        );
    public void testDateEncodePoint() {
    public void testBadNullValue() throws IOException {
            () -> merge(mapperService, fieldMapping(b -> b.field("type", "date").field("format", "epoch_millis")))
        assertEquals(1457654400000L, dvField.numericValue().longValue());
        assertFalse(dvField.fieldType().stored());
            minimalMapping(b);
            m -> assertTrue(((DateFieldMapper) m).ignoreMalformed().value())
            assertTrue("Lucene path should produce field '" + fieldName + "'", luceneFields.length > 0);
        // Assert date field
import static org.mockito.Mockito.mock;
        assertEquals(1457654400000L, pointField.numericValue().longValue());
        ParsedDocument docEnabled = mapperEnabled.parse(source(b -> b.field("field", dateValue)));
            )
            visitor.longField(mockFieldInfo, TEST_TIMESTAMP);
        assertFalse("existing field's value should be preserved across the update", mapperService.fieldType("field").isSearchable());
    /** An explicit {@code index: false} is accepted on a pluggable-dataformat index. */
            return null;
public class DateFieldMapperTests extends MapperTestCase {
        when(leafReader.getSortedNumericDocValues("field")).thenReturn(docValues);
    public void testMergeText() throws Exception {
    public void testWithContextAwareGroupingMapper() throws IOException {
        MapperService mapperService = createMapperService(pluggableSettings(), fieldMapping(b -> {
        );
    }
import static org.mockito.Mockito.doAnswer;
        builder.endObject();
        assertEquals(millis, fields[0].numericValue().longValue());
    }
            DocValuesSkipIndexType.NONE,
    protected void assertParseMaximalWarnings() {
    }
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> b.field("field", value))));
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
            MapperParsingException.class,
            b -> b.field("ignore_malformed", true),
        assertEquals(
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "2016-03-11")));
 */
        assertEquals("Date_nanos field should have 2 fields", 2, fieldsNanos.length);
 *
        IndexableField[] fields = doc.rootDoc().getFields("field");
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "date")));
        DateFieldMapper.DateFieldType ft = (DateFieldMapper.DateFieldType) mapperService.fieldType("field");
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "date").field("format", timeZonePattern)));
     */
        long negativeEpoch = -377705116800000L;
        // Verify the mapper has skip_list enabled
    }
/*
        assertEquals(1457692200000L, dvField.numericValue().longValue());
        // Test invalid string value
        IndexableField dvField = fields[1];
            .put("index.pluggable.dataformat", MockDocValuesDataFormatPlugin.FORMAT_NAME)
        decoded = LongPoint.decodeDimension(encoded, 0);
        assertEquals("Should decrement epoch millis", negativeEpoch - 1, decoded);
        assertEquals(2, fields.length);
    /** Indices that do not use a pluggable dataformat keep the standard {@code index: true} default. */
        assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());
        ParsedDocument luceneDoc = luceneMapper.parse(source(sourceBuilder));
        SortedNumericDocValues docValues = mock(SortedNumericDocValues.class);
    public void testPluggableDataFormatDateNullSkipped() throws Exception {
        // Test with date_nanos as well
/*
                x.startObject("field");
            assertEquals(expectedValue.longValue(), luceneFields[0].numericValue().longValue());
        LeafReader leafReader = mock(LeafReader.class);
                b -> b.field("type", "date").field("format", "strict_date_time_no_millis").field("store", false).field("doc_values", true)
        IndexableField pointField = fields[0];
        StoredFields storedFields = mock(StoredFields.class);
        assertEquals(expectedNullValue, pointField.numericValue().longValue());
    public void testFetchDocValuesNanos() throws IOException {
        FieldInfo mockFieldInfo = new FieldInfo(
        dateFieldMapper = (DateFieldMapper) mapper.mappers().getMapper("field");
        IndexableField dvField = fields[1];
    protected Collection<? extends Plugin> getPlugins() {
        );
            visitor.longField(mockFieldInfo, TEST_TIMESTAMP + 3600000); // One hour later
        );
            null
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "date").field("index", false)));
                .anyMatch(e -> e.getKey().name().equals(fieldName) && e.getValue().equals(expectedValue));
        DateFieldMapper dateFieldMapper = (DateFieldMapper) mapperService.documentMapper().mappers().getMapper("field");
                    .field("store", true)
        // Both should have the same field structure and values
        assertEquals(1457654400000L, storedField.numericValue().longValue());
        FieldInfo mockFieldInfo = new FieldInfo(
        checker.registerConflictCheck("format", b -> b.field("format", "yyyy-MM-dd"));
        IndexableField[] fields = doc.rootDoc().getFields("field");
    }
        // Scenario 2: null value — no field produced
        // Test creating index with skip_list=true for date_nanos field
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
        }));
            fieldMapping(b -> b.field("type", "date").field("format", "E, d MMM yyyy HH:mm:ss Z").field("locale", "de"))
    }
    public void testPluggableDataFormatDefaultsIndexToFalseForDateNanos() throws IOException {
        when(docValues.advanceExact(0)).thenReturn(true);
        assertEquals(8, pointField.fieldType().pointNumBytes());
    }
import java.time.ZonedDateTime;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.IndexSortConfig;
        assertFalse(pointField.fieldType().stored());
    @Override
        mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "date").field("skip_list", false)));
 * You may obtain a copy of the License at
import java.util.Collection;
        assertWarnings("Parameter [boost] on field [field] is deprecated and will be removed in 3.0");
        ParsedDocument doc = mapper2.parse(source(b -> b.field("field", value)));
        assertEquals(baseTime + 1, decoded);
        // Assert groupingcriteria is correct
        String source = builder.toString();
        assertTrue(source.contains("\"field\":[\"2025-02-18T06:00:00Z\",\"2025-02-18T07:00:00Z\"]"));
            fieldMapping(
     * On a pluggable-dataformat index no BKD points are written for date fields, so {@code index}
        LeafReader leafReader = mock(LeafReader.class);
            b -> b.nullField("field"),
import org.apache.lucene.index.StoredFieldVisitor;
     * An explicit {@code index: true} cannot be honoured on a pluggable-dataformat index — no point
            () -> createMapperService(pluggableSettings(), fieldMapping(b -> {
            IndexOptions.NONE,
    public void testNanosNullValue() throws IOException {
        // Test invalid numeric value
    public void testPluggableDataFormatRejectsExplicitIndexTrue() {
        assertFalse(mapperService.fieldType("field").isSearchable());
        // Test that skip_list parameter appears correctly in mapping definitions
        );
        MapperService explicit = createMapperService(fieldMapping(b -> {
        assertFalse(dvField.fieldType().stored());
    }
    }
        mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "date_nanos").field("skip_list", false)));
        assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());
        assertThat(e.getMessage(), containsString("cannot cover: [POINT_RANGE]"));
            b.endObject();
            )
    public void testNullConfigValuesFail() {
        DateFieldMapper.DateFieldType fieldType = new DateFieldMapper.DateFieldType("test_field");
            fieldMapping(b -> b.field("type", "date").field("doc_values", false).field("store", false))
        assertEquals(8, pointField.fieldType().pointNumBytes());
        );
        String source = builder.toString();
        DocumentMapper mapperEnabled = createDocumentMapper(fieldMapping(b -> b.field("type", "date").field("skip_list", true)));
    public void testIgnoreMalformedLegacy() throws IOException {
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
        when(docValues.advanceExact(0)).thenReturn(false);
        encoded = fieldType.encodePoint(largeEpochStr, true);
            pluggableSettings,
        MapperService mapperService = createMapperService(
    }
        assertEquals(List.of(date), fetchFromDocValues(mapperService, ft, format, date));
        MapperService mapperService = createMapperService(
        when(docValues.advanceExact(0)).thenReturn(true);
        assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());
        assertEquals(List.of(date), fetchFromDocValues(mapperService, ft, format, 1589578382123L));
        assertFalse(pointField.fieldType().stored());
        assertEquals(1, pointField.fieldType().pointIndexDimensionCount());
        assertEquals(2, fields.length);
    protected void minimalMapping(XContentBuilder b) throws IOException {
            b.startObject("field2");
            fieldMapping(
        checker.registerConflictCheck("store", b -> b.field("store", true));
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
import org.opensearch.Version;
            () -> createDocumentMapper(fieldMapping(b -> b.field("type", "date").field("format", "test_format")))
        // Test that field behavior is consistent between skip_list enabled and disabled
            MapperParsingException.class,
    }
        assumeThat(
            fieldMapping(
        return Settings.builder()
    }
    /** The rejection names the concrete resolution so {@code date_nanos} is not reported as {@code date}. */
    /**
        );
        // Test NANOSECONDS resolution (date_nanos type)
            pluggableSettings,
        return List.of(new MockDocValuesDataFormatPlugin());
        builder.endObject();
            fieldMapping(
        SortedNumericDocValues docValues = mock(SortedNumericDocValues.class);
        assertEquals(1, pointField.fieldType().pointIndexDimensionCount());
    @Override
        assertEquals(2, fields.length);
            fieldMapping(
    }
            VectorSimilarityFunction.EUCLIDEAN,
        DateFieldMapper dateFieldMapper = (DateFieldMapper) mapperService.documentMapper().mappers().getMapper("field");
            pluggableSettings,
        assertEquals(1, pointField.fieldType().pointIndexDimensionCount());
        IndexableField pointField = fields[0];
    protected void registerParameters(ParameterChecker checker) throws IOException {
            mapping(b -> b.startObject("field").field("type", "date").endObject()),
        builder.value("2016-03-11");
        // Test skip_list=true
import static org.mockito.Mockito.any;
 * this work for additional information regarding copyright
        );
        );
            "Doc values field values should match",
        assertTrue(explicit.fieldType("field").isSearchable());
    public void testPluggableDataFormatMappingUpdateRejectsIndexTrue() throws IOException {
        assertTrue(mapperService.fieldType("field").isSearchable());
            MapperParsingException.class,
import static org.mockito.Mockito.when;
        pluggableMapper.parse(source(sourceBuilder), docInput);
            VectorSimilarityFunction.EUCLIDEAN,
            0,
            fieldMapping(b -> b.field("type", "date_nanos").field("format", "strict_date_time||epoch_millis").field("copy_to", "a"))
        IndexableField pointField = fields[0];
        assertEquals(8, pointField.fieldType().pointNumBytes());
            fieldMapping(b -> b.field("type", "date").field("format", "strict_date_time||epoch_millis"))
 *
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "date_nanos").field("skip_list", true)));
            visitor.longField(mockFieldInfo, TEST_TIMESTAMP * 1000000L + 111111111L);
            "field",
        decoded = LongPoint.decodeDimension(encoded, 0);
        doc = mapperService.documentMapper().parse(source(b -> b.nullField("field")));
        );
     */
        assertEquals(1457654400000L, pointField.numericValue().longValue());
        assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());
        ParsedDocument docMillis = mapperMillis.parse(source(b -> b.field("field", "2016-03-11T10:30:00Z")));
    ) throws IOException {
        assertThrows(UnsupportedOperationException.class, dateFieldMapper::canDeriveSource);
        MapperService mapperService = createMapperService(
            -1,
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "date_nanos").field("skip_list", true)));
    }
                minimalMapping(b);
            b.field("index", true);
        DocumentMapper mapper = createDocumentMapper(
        assertEquals(expectedNullValue, dvField.numericValue().longValue());
            DocValuesSkipIndexType.NONE,
            false,
            0,
        IndexableField dvField = fields[1];
     * index is written — so the mapping is rejected rather than silently producing a field whose
        testIgnoreMalformedForValue(
        long millis = randomDate.withZoneSameInstant(ZoneOffset.UTC).toInstant().toEpochMilli();
 */
            SingleFieldsVisitor visitor = invocation.getArgument(1);
    }
        assertTrue("skip_list should be true for date_nanos", dateFieldMapper.skiplist());
            0,
        testIgnoreMalformedForValue(
    }
    }
        long largeEpoch = 253402300799999L;
        DateFieldMapper dateFieldMapper = (DateFieldMapper) mapper.mappers().getMapper("field");
    /**
        assertThat(e.getMessage(), containsString("cannot cover: [POINT_RANGE]"));
        ParsedDocument doc = mapper.parse(source(b -> b.nullField("field")));
        assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());
    protected void writeFieldValue(XContentBuilder builder) throws IOException {
import org.apache.lucene.index.VectorSimilarityFunction;
            Collections.emptyMap(),
    }
        String source = builder.toString();
        final ZonedDateTime randomDate = ZonedDateTime.of(2016, 3, 11, 0, 0, 0, 0, randomTimeZone);
        );
                b -> b.field("type", "date").field("format", "strict_date_time_no_millis").field("store", false).field("doc_values", true)
            assertFalse("Pluggable path should produce no field for '" + fieldName + "'", pluggableHasField);
    public void testDeriveSource_WhenStoredFieldEnabledAndDateNanosType() throws IOException {
        assertEquals(2, fields.length);
        DocumentMapper luceneMapper = createDocumentMapper(mappingBuilder);
                    .field("format", "strict_date_optional_time_nanos")
        // Get the field type and verify skip_list is set
        // Test with no index sort and non-timestamp field
        SortedNumericDocValues docValues = mock(SortedNumericDocValues.class);
            .anyMatch(e -> e.getKey().name().equals("field") && e.getValue().equals(TEST_TIMESTAMP));
        );
    private static Settings pluggableSettings() {
            mapping(b -> b.startObject("field").field("type", "date").endObject())
import org.opensearch.search.DocValueFormat;
        when(docValues.nextValue()).thenReturn(TEST_TIMESTAMP).thenReturn(TEST_TIMESTAMP + 3600000L); // One Hour Later
        assumeThat("Using legacy datetime format as default", FeatureFlags.isEnabled(FeatureFlags.DATETIME_FORMATTER_CACHING), is(false));
            IllegalArgumentException.class,
            b -> b.field("field", "2025-02-18T06:00:00.000Z"),
        DocumentMapper mapper = createDocumentMapper(Version.V_3_2_0, fieldMapping(b -> b.field("type", "date")));
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        );
        assertEquals(1457692200000L, dvField.numericValue().longValue());
        String fieldName,
        );
        // Test with skip_list=true
        // Test both MILLISECONDS and NANOSECONDS resolution with skip_list enabled
    public void testChangeLocale() throws IOException {
        assertEquals(expectedValue, dateFieldMapper.isSkiplistDefaultEnabled(sortConfig, "field"));
        mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "date").field("null_value", "2016-03-11")));
            0,
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
 * Modifications Copyright OpenSearch Contributors. See
        MapperParsingException e = expectThrows(
        assertTrue("skip_list should be enabled", dateFieldMapper.skiplist());
        checker.registerConflictCheck("locale", b -> b.field("locale", "es"));
            -1,
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "2016-03-11")));
        MapperService mapperService = createMapperService(pluggableSettings(), fieldMapping(this::minimalMapping));
        assertEquals(1457654400000L, dvField.numericValue().longValue());
        // Test MILLISECONDS resolution (date type)
        assertFalse(mapperService.fieldType("field").isSearchable());
            "2016-03-99",
     * doc-values column instead of an empty point index.
 * compatible open source license.
        IndexableField[] luceneFields = luceneDoc.rootDoc().getFields(fieldName);
     * value of the already-mapped field unchanged.
            DocValuesSkipIndexType.NONE,
            -1,
    public void testFetchDocValuesMillis() throws IOException {
        long baseTime = fieldType.parse("2024-01-15T10:30:00Z");
        DateFieldMapper dateMapperMillis = (DateFieldMapper) mapperMillis.mappers().getMapper("field");
        MapperParsingException e = expectThrows(
        MapperService mapperService = createMapperService(pluggableSettings(), fieldMapping(b -> b.field("type", "date_nanos")));
            "2016-03-99",
        IndexableField[] fieldsDisabled = docDisabled.rootDoc().getFields("field");
import org.apache.lucene.index.VectorEncoding;
        IndexMetadata noSortindexMetadata = new IndexMetadata.Builder("index").settings(getIndexSettings()).build();
    }
        builder.endObject();
    public void testSkipListParameterDateNanos() throws IOException {
        String date = "2020-05-15T21:33:02.123Z";
        DateFieldMapper dateFieldMapper = (DateFieldMapper) mapperService.documentMapper().mappers().getMapper("field");
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
            0,
        builder.endObject();
            VectorEncoding.FLOAT32,
import org.apache.lucene.index.FieldInfo;
        // Verify doc values field - when skip_list=true, should use indexed doc values
            SingleFieldsVisitor visitor = invocation.getArgument(1);
    public void testSkipListIntegrationDateNanosFieldWithIndexedDocValues() throws IOException {
    }
        assertFalse(dvField.fieldType().stored());
        MapperParsingException e = expectThrows(
        LeafReader leafReader = mock(LeafReader.class);
     */
        );
        boolean hasDateField = docInput.getCapturedFields().stream().anyMatch(e -> e.getKey().name().equals("field"));
        assertTrue("skip_list should be enabled", dateFieldMapper.skiplist());
        LeafReader leafReader = mock(LeafReader.class);
        doAnswer(invocation -> {
        assertEquals(1, pointField.fieldType().pointIndexDimensionCount());
        MapperService mapperService = createMapperService(
        IndexableField[] fields = doc.rootDoc().getFields("field");
        assertThat(e.getMessage(), containsString("of type [date_nanos]"));
    public void testNoDocValues() throws Exception {
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
        dateFieldMapper.deriveSource(builder, leafReader, 0);
            true,
    }
        assertThat(e.getMessage(), containsString("Failed to parse mapping"));
    }
    }
        }));
        assertEquals(
 * Licensed to Elasticsearch under one or more contributor
            false,
            fieldsEnabled[0].numericValue().longValue(),
        DateFieldMapper dateFieldMapperNanos = (DateFieldMapper) mapperServiceNanos.documentMapper().mappers().getMapper("field");
import static org.hamcrest.Matchers.containsString;
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "2016-03-11")));
        assertFalse("newly added field should default to not-indexed", mapperService.fieldType("field2").isSearchable());
        );
        DocumentMapper mapperMillis = createDocumentMapper(fieldMapping(b -> b.field("type", "date").field("skip_list", true)));
        IndexableField dvField = fields[1];
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
    public void testSkipListIntegrationWithMultipleResolutions() throws IOException {
    public void testDeriveSource_WhenDocValuesEnabledAndDateType() throws IOException {
        if (expectedValue == null) {
        dateFieldMapper.deriveSource(builder, leafReader, 0);
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", 1457654400)));
 * not use this file except in compliance with the License.
    public void testPluggableDataFormatMappingUpdateDefaultsNewFieldToNotIndexed() throws IOException {
            () -> createDocumentMapper(fieldMapping(b -> b.field("type", "date").nullField("skip_list")))
        );
    }
        DateFieldMapper dateFieldMapper = (DateFieldMapper) mapperService.documentMapper().mappers().getMapper("field");
        );
        // Verify the mapper has skip_list disabled
            MapperParsingException.class,
        IndexableField[] fieldsEnabled = docEnabled.rootDoc().getFields("field");
    }
        assertTrue(source.contains("\"field\":\"2025-02-18T06:00:00Z\""));
    }
            fieldMapping(
            b.endObject();
        assertThat(e.getMessage(), containsString("Failed to parse mapping"));
import org.opensearch.plugins.Plugin;
    public void testNullValue() throws IOException {
import org.apache.lucene.index.StoredFields;
        DateFieldMapper dateFieldMapper = (DateFieldMapper) mapperService.documentMapper().mappers().getMapper("field");
import static org.hamcrest.CoreMatchers.is;
        when(docValues.advanceExact(0)).thenReturn(true);
        assertThat(e.getMessage(), containsString("Invalid format: [test_format]: Unknown pattern letter: t"));
    public void testPossibleToDeriveSource_WhenCopyToPresent() throws IOException {
        );
            contextAwareGrouping("field").accept(b);
        assertWarnings("Error parsing [foo] as date in [null_value] on field [field]); [null_value] will be ignored");
            visitor.longField(mockFieldInfo, TEST_TIMESTAMP);
        assertTrue(source.contains("\"field\":\"2025-02-18T06:00:00.111111111Z\""));
        assertThat(e.getMessage(), containsString("Error parsing [format] on field [field]: Invalid"));
        assertTrue(source.contains("\"field\":\"2025-02-18T06:00:00Z\""));
        assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());
import java.util.List;
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
 */
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "date").field("skip_list", true)));
        assertFalse("skip_list should be false", dateFieldMapper.skiplist());
        MapperService mapperService = createMapperService(fieldMapping(this::minimalMapping));
        final ZoneId randomTimeZone = randomBoolean() ? ZoneId.of(randomFrom("UTC", "CET")) : randomZone();
import org.apache.lucene.index.DocValuesSkipIndexType;
    public void testDeriveSource_WhenDocValuesEnabledWithMultiValue() throws IOException {
 * Unless required by applicable law or agreed to in writing,
        assertEquals(8, pointField.fieldType().pointNumBytes());
            mapping(b -> b.startObject("field").field("type", "date").endObject()),
            true,
        assertTrue(source.contains("\"field\":\"2025-02-18T06:00:00.222222222Z\""));
        } else {
        );
        );
            fieldMapping(b -> b.field("type", "date_nanos").field("null_value", "2016-03-11"))
            minimalMapping(b);
        assertEquals(1457654400000L, pointField.numericValue().longValue());
        IndexableField dvField = fields[1];
import org.apache.lucene.index.DocValuesType;
        // Create index settings with an index sort.
        );
        IndexableField pointField = fields[0];
 * The OpenSearch Contributors require contributions made to
        assertEquals(List.of("2020-05-15T21:33:02.123Z"), fetchFromDocValues(mapperService, ft, format, 1589578382123L));
        DateFormatter formatter = DateFormatter.forPattern(timeZonePattern);
        assertFalse(dateFieldMapper.isSkiplistDefaultEnabled(noSortConfig, "field"));
        );
    public void testChangeFormat() throws IOException {
        assertThat(e.getMessage(), containsString("Preview of field's value: '" + value + "'"));
    public void testDeriveSource_NoValue() throws IOException {
        e = expectThrows(
        assertEquals(3, fields.length);
        byte[] encoded = fieldType.encodePoint("2024-01-15T10:30:00Z", true);
    public void testPluggableDataFormatDateValue() throws Exception {
            b.field("index", true);
        // Test creating index with skip_list=true for date field
        MapperService mapperService = createMapperService(
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", formatter.format(randomDate))));
            false,
        assertFalse(mapperService.fieldType("field").isStored());
        // Test basic roundUp
    public void testMergeDate() throws IOException {
    }
        assertThat(mapperService.fieldType("field"), notNullValue());
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        IndexSettings indexSettings = new IndexSettings(indexMetadata, settings);
            false
            }).accept(b);
        assertEquals(List.of(date), fetchFromDocValues(mapperService, ft, format, date));
    public void testTimeZoneParsing() throws Exception {
        IndexableField[] fields = doc.rootDoc().getFields("field");
            "failed to parse date field [2016-03-99] with format [strict_date_optional_time||epoch_millis]"
        assertTrue("skip_list should be true in mapper", dateFieldMapper.skiplist());
        // Pluggable path
        // Test skip_list=false with date_nanos type
    }
        when(leafReader.getSortedNumericDocValues("field")).thenReturn(docValues);
import org.apache.lucene.index.SortedNumericDocValues;
            () -> createDocumentMapper(fieldMapping(b -> b.field("type", "date").field("skip_list", "invalid")))
 * specific language governing permissions and limitations
        MappedFieldType ft = mapperService.fieldType("field");
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
}
        assertEquals(1, fields.length);
        assertFalse("skip_list should default to false for date_nanos", dateFieldMapper.skiplist());
            IndexOptions.NONE,
        checker.registerUpdateCheck(b -> b.field("boost", 2.0), m -> assertEquals(m.fieldType().boost(), 2.0, 0));
        CheckedConsumer<XContentBuilder, IOException> sourceBuilder,
        assertEquals(1457692200000L, pointField.numericValue().longValue());
        assertFalse("skip_list should be false for date_nanos", dateFieldMapper.skiplist());
        );
import static org.mockito.Mockito.anyInt;
        CapturingDocumentInput docInput = new CapturingDocumentInput();
import org.opensearch.index.fieldvisitor.SingleFieldsVisitor;
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
        }).when(storedFields).document(anyInt(), any(StoredFieldVisitor.class));
    public void testDeriveSource_WhenStoredFieldEnabledWithMultiValue() throws IOException {
        );
        IndexableField[] fields = doc.rootDoc().getFields("field");
        assertFalse(pointField.fieldType().stored());
            false,
                b -> b.field("type", "date").field("format", "strict_date_time_no_millis").field("doc_values", false).field("store", true)
        IndexableField pointField = fields[0];
    public void testSkipListParameterValidBooleanValues() throws IOException {
    public void testExistsQueryDocValuesDisabled() throws IOException {
        // Verify point field
    /** A mapping update that sets index:true on a new field is rejected on a pluggable data format index. */
            )
    }
        assertThat(e.getMessage(), containsString("parameter [format] from [yyyy/MM/dd] to [epoch_millis]"));
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
    // Integration tests for end-to-end skip_list functionality
        assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());
        testIgnoreMalformedForValue("-2147483648", "Invalid value for Year (valid values -999999999 - 999999999): -2147483648");
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    private static final long TEST_TIMESTAMP = 1739858400000L;
    }
                b -> b.field("type", "date").field("format", "strict_date_time_no_millis").field("store", false).field("doc_values", true)
            assertEquals("Lucene path should produce no field for '" + fieldName + "'", 0, luceneFields.length);
        checker.registerConflictCheck("doc_values", b -> b.field("doc_values", false));
            .put("index.pluggable.dataformat.enabled", true)
        IndexableField[] fieldsNanos = docNanos.rootDoc().getFields("field");
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "2016-03-11T10:30:00.123456789Z")));
        mapper.parse(source(b -> b.field("field", "2025-02-18T06:00:00.000Z")), docInput);
        testIsSkiplistEnabled(mapper, false);
        IndexableField[] fields = doc.rootDoc().getFields("field");
        assertThrows(UnsupportedOperationException.class, dateFieldMapper::canDeriveSource);
        Exception e = expectThrows(
        checker.registerUpdateCheck(
        assertTrue("Date field skip_list should be enabled", dateMapperMillis.skiplist());
        // Lucene path
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> merge(mapperService, mapping(b -> {
        })));
        IndexableField storedField = fields[2];
import java.io.IOException;
        }
        DocumentMapper pluggableMapper = createDocumentMapper(pluggableSettings, mappingBuilder);
 * ownership. Elasticsearch licenses this file to you under
            "failed to parse date field [2016-03-99] with format [strict_date_time_no_millis||strict_date_optional_time||epoch_millis]"
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
        mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "date_nanos")));
        assertEquals("Date field should have 2 fields", 2, fieldsMillis.length);
        IndexableField[] fields = doc.rootDoc().getFields("field");
        DocumentMapper mapper = createDocumentMapper(
        Settings settings = Settings.builder()
        assertEquals("Should have 2 fields (point and doc values)", 2, fields.length);
            )
        doc = mapper.parse(source(b -> b.nullField("field")));
    }
            MapperParsingException.class,
    }
    public void testPluggableDataFormatAcceptsExplicitIndexFalse() throws IOException {
    public void testIllegalFormatField() {
        when(leafReader.getSortedNumericDocValues("field")).thenReturn(docValues);
        MappedFieldType ft = mapperService.fieldType("field");
import org.opensearch.core.xcontent.XContentBuilder;
        // Verify point field
        assertFalse(pointField.fieldType().stored());
    private void testIsSkiplistEnabled(DocumentMapper mapper, boolean expectedValue) throws IOException {
    }
    public void testDeriveSource_WhenDocValuesEnabledAndDateNanosType() throws IOException {
        MapperService mapperService = createMapperService(
        assertFalse(dvField.fieldType().stored());
    public void testSkipListIntegrationDateFieldWithIndexedDocValues() throws IOException {
    }
            return null;
        doAnswer(invocation -> {
        Exception e = expectThrows(
