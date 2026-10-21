        assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());
        MapperService mapperService = createMapperService(pluggableSettings(), fieldMapping(this::minimalMapping));
        validateScaledFloatFields(doc, "field2", randomLongField2, scalingFactorField2);
            float value = 11.523f;
import org.opensearch.cluster.metadata.IndexMetadata;
    public void testNullValue() throws IOException {
    public void testIllegalScalingFactor() {
            )
        IndexableField pointField = fields[0];
        assertEquals((long) (value * scalingFactor), dvField.numericValue().longValue());
        assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());
        ParsedDocument doc = mapper.parse(
            fieldMapping(b -> b.field("type", "scaled_float").field("scaling_factor", 100))
 * The OpenSearch Contributors require contributions made to
            fieldMapping(
        fields = doc.rootDoc().getFields("field");
            () -> createMapperService(fieldMapping(b -> b.field("type", "scaled_float")))
    public void testIgnoreMalformed() throws Exception {
            new SourceToParse(
            b.field("doc_values", false);
 * ownership. Elasticsearch licenses this file to you under
        );
        IndexableField dvField = fields[1];
            minimalMapping(b);
            .put(StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.getKey(), true)
        assertThrows(UnsupportedOperationException.class, mapper::canDeriveSource);
            "field",
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.document.LongPoint;
        IndexableField[] luceneFields = luceneDoc.rootDoc().getFields(fieldName);
 *
                MediaTypeRegistry.JSON
    public void testStore() throws Exception {
        ParsedDocument doc = mapper.parse(
                "1",
            true
     * index is written — so the mapping is rejected rather than silently producing a field whose
            doc.add(new StoredField(FIELD_NAME, scaledValue));
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
    private XContentBuilder getStarTreeMappingWithScaledFloat(
        double scalingFactorField1,
     * A field added by a later mapping update also defaults to not-indexed, and the update leaves the
            )
import org.opensearch.common.CheckedConsumer;
        MapperService mapperService = createMapperService(pluggableSettings(), fieldMapping(this::minimalMapping));
        } else {
                iw.addDocument(createDocument(value, false));
        return Settings.builder()
import static org.hamcrest.Matchers.containsString;
    }
            source(b -> b.field("field1", randomLongField1).field("field2", randomLongField2).field("field3", randomLongField3))
        assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());
        DocumentMapper mapper = createDocumentMapper(
        IndexableField[] fields = doc.rootDoc().getFields("field");
        ThrowingRunnable runnable = () -> mapper.parse(
        // Scenario 2: null value — no field produced
            b.startObject();
            fieldMapping(b -> b.field("type", "scaled_float").field("store", true).field("scaling_factor", 10.0))
import org.opensearch.core.xcontent.XContentBuilder;
    public void testSkiplistParameter() throws IOException {
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
    public void testPossibleToDeriveSource_WhenCopyToPresent() throws IOException {
            new SourceToParse(
        doc = skiplistMapper.parse(source(b -> b.field("field", 123.45)));
            MapperParsingException.class,
            minimalMapping(b);
            b.value("value_count");
            MapperParsingException.class,
            )
        assertEquals(DocValuesSkipIndexType.NONE, dvField.fieldType().docValuesSkipIndexType());
        XContentBuilder mappingBuilder,
                "test",
        assertFalse("existing field's value should be preserved across the update", mapperService.fieldType("field").isSearchable());
                MediaTypeRegistry.JSON
        );
                "test",
    }
                "test",
                "1",
        assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());
            b.startObject("properties");
        assertEquals(1, fields.length);
        long decodedDown = LongPoint.decodeDimension(encodedRoundDown, 0);
    }
        String fieldName,
            assertEquals("Lucene path should produce no field for '" + fieldName + "'", 0, luceneFields.length);
    private static void validateScaledFloatFields(ParsedDocument doc, String field, long value, double scalingFactor) {
        // Test default value (none)
            b.field("index", false);
                builder.endObject();
import org.apache.lucene.document.Document;
    @Override
                "test",
            b.startObject("composite");
        assertEquals(1, pointField.fieldType().pointDimensionCount());
    protected void writeFieldValue(XContentBuilder builder) throws IOException {
 * compatible open source license.
        long randomLongField3 = randomLong();
        );
import java.util.Collection;
        if (hasDocValues) {
        assertExistsQuery(mapperService);
    }
        IndexableField dvField = fields[1];
    }
        DocumentMapper mapper2 = createDocumentMapper(
        dvField = fields[1];
    public void testScaledFloatWithStarTree() throws Exception {
    }
 * Licensed to Elasticsearch under one or more contributor
                MediaTypeRegistry.JSON
    }
        DocumentMapper mapper = createDocumentMapper(mapping);
            .put("index.pluggable.dataformat", MockDocValuesDataFormatPlugin.FORMAT_NAME)
import org.opensearch.common.util.FeatureFlags;
    }
    public void testDefaults() throws Exception {
        assertParseMinimalWarnings();
        assertEquals(2, fields.length);
        assertFalse("Expected no field entry for null value", found);
 */
                MediaTypeRegistry.JSON
            b.field("type", "scaled_float").field("scaling_factor", scalingFactorField3);
        MapperParsingException e = expectThrows(
    @Override
        assertEquals(0, fields.length);
        );
            )
            b.startArray("ordered_dimensions");
            new SourceToParse(
            b.startObject("field3");
            )
import org.apache.lucene.index.DirectoryReader;
    }
        }
        assertFalse("newly added field should default to not-indexed", mapperService.fieldType("field2").isSearchable());
            b.startObject("field1");
import org.apache.lucene.document.StoredField;
     * Helper method to create a document with both doc values and stored fields
            b.endObject();
    protected Settings getIndexSettings() {
        assertThat(e.getMessage(), containsString("cannot cover: [POINT_RANGE]"));
        assertFalse(dvField.fieldType().stored());
        IndexableField[] fields = doc.rootDoc().getFields("field");
        long decodedUp = LongPoint.decodeDimension(encodedRoundUp, 0);
            "test_field",
        assertEquals(1, fields.length);
        );
        long randomLongField1 = randomLong();
            mapping(b -> b.startObject("field").field("type", "scaled_float").field("scaling_factor", 100).endObject()),
        mapper.parse(source(b -> b.nullField("field")), docInput);
    }
        assertEquals(1, pointField.fieldType().pointDimensionCount());
            b.field("name", "field1");
        assertFalse(mapperService.fieldType("field").isSearchable());
    public void testRejectIndexOptions() {
        assertEquals(1, pointField.fieldType().pointDimensionCount());
        IndexableField pointField = fields[0];
 * SPDX-License-Identifier: Apache-2.0
            b.startObject("field2");
            pluggableSettings,
    }
        );
    }
        }));
                "test",
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
 */
        );
        long randomLongField2 = randomLong();
    /**
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
        FieldMapper.CopyTo copyTo = new FieldMapper.CopyTo.Builder().add("copy_to_field").build();
            )
        boolean pluggableHasField = docInput.getCapturedFields().stream().anyMatch(e -> e.getKey().name().equals(fieldName));
        IndexableField dvField = fields[0];
        IndexableField[] fields = doc.rootDoc().getFields(field);
        );
}
        IndexableField[] fields = doc.rootDoc().getFields("field");
        IndexableField pointField = fields[0];
        );
            new SourceToParse(
        MapperParsingException e = expectThrows(
        );
     * queries to the doc-values column instead of an empty point index.
        assertEquals(1049, decodedDown); // 10.5 scaled = 1050, then -1 = 1049 (represents 10.49)
                MediaTypeRegistry.JSON
        boolean found = docInput.getCapturedFields().stream().anyMatch(e -> e.getKey().name().equals("field"));
            }
            fieldMapping(b -> b.field("type", "scaled_float").field("doc_values", false).field("scaling_factor", 10.0))
        CapturingDocumentInput docInput = new CapturingDocumentInput();
                BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("field", 123).endObject()),
    }
        DocumentMapper mapper2 = createDocumentMapper(
import org.apache.lucene.document.SortedNumericDocValuesField;
                BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("field", 123).endObject()),
        CheckedConsumer<XContentBuilder, IOException> sourceBuilder,
    }
            try (DirectoryReader reader = DirectoryReader.open(directory)) {
            .put("index.pluggable.dataformat.enabled", true)
        assertFalse(mapperService.fieldType("field").isSearchable());
     */
        double scalingFactorField1 = randomDouble() * 100;
        IndexableField[] fields = doc.rootDoc().getFields("field");
            b.endObject();
        IndexableField dvField = fields[1];
    public void testNonPluggableDataFormatKeepsIndexTrue() throws IOException {
        assertTrue("Expected scaled float field to be captured", found);
    public void testPluggableDataFormatRejectsExplicitIndexTrue() {
 * specific language governing permissions and limitations
        double originalValue = 10.5;
    private static final String FIELD_NAME = "field";
                String source = builder.toString();
        }));
    public void testNotIndexed() throws Exception {
import org.opensearch.index.engine.dataformat.stub.MockDocValuesDataFormatPlugin;
import org.apache.lucene.index.IndexableField;
import org.opensearch.common.xcontent.XContentFactory;
    /**
        assertFalse(pointField.fieldType().stored());
            b -> b.field("ignore_malformed", true),
        ThrowingRunnable runnable = () -> mapper2.parse(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    /** A mapping update that sets index:true on a new field is rejected on a pluggable data format index. */
        ParsedDocument doc = defaultMapper.parse(source(b -> b.field("field", 123.45)));
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        return topMapping(b -> {
 */
        checker.registerConflictCheck("skip_list", b -> b.field("skip_list", true));
    }
                "1",
        DocumentMapper mapper = createDocumentMapper(
        assertThat(e.getMessage(), containsString("[scaling_factor] must be a positive number, got [-1.0]"));
        assertEquals(1230, pointField.numericValue().longValue());
        assertThat(e.getMessage(), containsString("Failed to parse value [invalid] as only [true] or [false] are allowed"));
            MapperParsingException.class,
        return List.of(new MapperExtrasModulePlugin(), new MockDocValuesDataFormatPlugin());
        );
 * under the License.
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
        );
 * You may obtain a copy of the License at
        DocumentMapper luceneMapper = createDocumentMapper(mappingBuilder);
        assertTrue(mapping.toString().contains("startree"));
                BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("field", "123").endObject()),
    private void doTestIgnoreMalformed(Object value, String exceptionMessageContains) throws Exception {
        ScaledFloatFieldMapper mapper = getMapper(copyTo, true, true);
        MapperService mapperService = createMapperService(fieldMapping(this::minimalMapping));
        );
        );
        assertThat(e.getMessage(), containsString("cannot cover: [POINT_RANGE]"));
            b.endObject();
                "1",
                "1",
                XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
                mapper.deriveSource(builder, reader.leaves().get(0).reader(), 0);
            fieldMapping(b -> b.field("type", "scaled_float").field("scaling_factor", 10.0).field("ignore_malformed", true))
    }
 * the Apache License, Version 2.0 (the "License"); you may
        mapper = createDocumentMapper(
            mapping(b -> b.startObject("field").field("type", "scaled_float").field("scaling_factor", 100).endObject())
    }
            }
        }
        ScaledFloatFieldMapper mapper = getMapper(FieldMapper.CopyTo.empty(), false, false);
        );
                String source = builder.toString();
 * software distributed under the License is distributed on an
                builder.endObject();
        // Lucene path
            b.field("max_leaf_docs", 100);
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
    }
            assertTrue("Pluggable path should capture field '" + fieldName + "'", pluggableHasField);
            () -> createMapperService(pluggableSettings(), fieldMapping(b -> {
            float value = 11.523f;
        }));
        assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());
            b.startObject("field2");
        assertEquals((long) (value * scalingFactor), pointField.numericValue().longValue());
            .put(super.getIndexSettings())
    private ScaledFloatFieldMapper getMapper(FieldMapper.CopyTo copyTo, boolean hasDocValues, boolean isStored) throws IOException {
        );
            minimalMapping(b);
            b.field("index", true);
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
            fieldMapping(b -> b.field("type", "scaled_float").field("scaling_factor", 10.0).field("coerce", false))
        MapperService explicit = createMapperService(fieldMapping(b -> {
            () -> createMapperService(fieldMapping(b -> b.field("type", "scaled_float").field("scaling_factor", -1)))
            ScaledFloatFieldMapper mapper = getMapper(FieldMapper.CopyTo.empty(), false, true);
                assertEquals("{\"" + FIELD_NAME + "\":" + 11.52 + "}", source);
                fieldMapping(b -> b.field("type", "scaled_float").field("scaling_factor", 100).field("skip_list", "invalid"))
        ScaledFloatFieldMapper.ScaledFloatFieldType fieldType = new ScaledFloatFieldMapper.ScaledFloatFieldType(
            b -> b.nullField("field"),
    public void testNoDocValues() throws Exception {
                "test",
        IndexableField[] fields = doc.rootDoc().getFields("field");
/*
        DocumentMapper mapper = createDocumentMapper(
        XContentBuilder mapping = fieldMapping(b -> b.field("type", "scaled_float").field("scaling_factor", 10.0));
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(2, fields.length);
    }
        double scalingFactorField3 = randomDouble() * 100;
            new SourceToParse(
                BytesReference.bytes(XContentFactory.jsonBuilder().startObject().nullField("field").endObject()),
        assertEquals(25, pointField.numericValue().longValue());
            b.startObject();
        assertWarnings("Parameter [index_options] has no effect on type [scaled_float] and will be removed in future");
    }
            new SourceToParse(
        assertScaledFloatLuceneAndPluggablePathsEquivalent(
    /** Indices that do not use a pluggable dataformat keep the standard {@code index: true} default. */
        assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field"));
        assertEquals(1, pointField.fieldType().pointDimensionCount());
     */
        }
 * GitHub history for details.
            minimalMapping(b);
        byte[] encodedRoundUp = fieldType.encodePoint(originalValue, true);
 * license agreements. See the NOTICE file distributed with
    public void testDerivedValueFetching_DocValues() throws IOException {
            )
            new SourceToParse(
        );
            )
        IndexableField[] fields = doc.rootDoc().getFields("field");
 *
            () -> createMapperService(fieldMapping(b -> b.field("type", "scaled_float").field("index_options", randomIndexOptions())))
        );
    protected Collection<? extends Plugin> getPlugins() {
        assertEquals(1230, pointField.numericValue().longValue());
    private void assertScaledFloatLuceneAndPluggablePathsEquivalent(
    }
        try (Directory directory = newDirectory()) {
        assertEquals(1, pointField.fieldType().pointDimensionCount());
        ParsedDocument luceneDoc = luceneMapper.parse(source(sourceBuilder));
            doc.add(new SortedNumericDocValuesField(FIELD_NAME, scaledValue));
            fieldMapping(b -> b.field("type", "scaled_float").field("scaling_factor", 10.0).field("null_value", 2.5))
        assertScaledFloatLuceneAndPluggablePathsEquivalent(
            fieldMapping(b -> b.field("type", "scaled_float").field("index", false).field("scaling_factor", 10.0))
            assertFalse("Pluggable path should produce no field for '" + fieldName + "'", pluggableHasField);
import org.opensearch.common.settings.Settings;
        validateScaledFloatFields(doc, "field", 123, 10.0);
import org.opensearch.plugins.Plugin;
import java.io.IOException;
            .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), true)
        checker.registerConflictCheck("doc_values", b -> b.field("doc_values", false));
            b.endObject();
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
    }
    public void testCoerce() throws Exception {
 * this file be licensed under the Apache-2.0 license or a
        );
        try (Directory directory = newDirectory()) {
        CapturingDocumentInput docInput = new CapturingDocumentInput();
                BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("field", value).endObject()),
        boolean found = docInput.getCapturedFields().stream().anyMatch(e -> e.getKey().name().equals("field"));
            new SourceToParse(
                MediaTypeRegistry.JSON
        builder.value(123);
        IndexableField[] fields = doc.rootDoc().getFields("field");
                iw.addDocument(createDocument(value, true));
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
import java.util.List;
        merge(mapperService, mapping(b -> {
import org.opensearch.core.common.bytes.BytesReference;
        if (!expectField) {
            mapping(b -> b.startObject("field").field("type", "scaled_float").field("scaling_factor", 100).endObject())
                MediaTypeRegistry.JSON
        double scalingFactorField2,
                BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("field", "123").endObject()),
        checker.registerUpdateCheck(
        }));
            pluggableSettings,
        assertEquals(3, fields.length);
    ) throws IOException {
        assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());
        );
    public void testPossibleToDeriveSource_WhenDocValuesAndStoredDisabled() throws IOException {
        );
            b.endObject();
    @Override
    public void testPluggableDataFormatMappingUpdateDefaultsNewFieldToNotIndexed() throws IOException {
            mapping(b -> b.startObject("field").field("type", "scaled_float").field("scaling_factor", 100).endObject()),
import java.util.Arrays;
            b.field("scaling_factor", 5.0);
                "1",
            false
        );
    public void testPluggableDataFormatScaledFloatNullSkipped() throws Exception {
        // Scenario 1: scaled float value
        assertThat(e.getCause().getMessage(), containsString("passed as String"));
                BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("field", 123).endObject()),
                "1",
            fieldMapping(b -> b.field("type", "scaled_float").field("scaling_factor", 100).field("skip_list", "true"))
            }
        double scalingFactorField3
        checker.registerConflictCheck("index", b -> b.field("index", false));
            )
            b.field("name", "field3");
                "1",
            b.startObject();
        ScaledFloatFieldMapper mapper = (ScaledFloatFieldMapper) mapperService.documentMapper().mappers().getMapper(FIELD_NAME);
        assertEquals(1230, dvField.numericValue().longValue());
    private static Settings pluggableSettings() {
        // Pluggable path
        IndexableField pointField = fields[0];
            b.endObject();
 *
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
    /**
        IndexableField storedField = fields[2];
                b.field("index", true);
            .build();
                "test",
    private Document createDocument(double value, boolean hasDocValues) {
        MapperService mapperService = createMapperService(pluggableSettings(), fieldMapping(this::minimalMapping));
            MapperParsingException.class,
        doTestIgnoreMalformed(true, "Current token (VALUE_TRUE) not numeric");
            doTestIgnoreMalformed(value, "[scaled_float] only supports finite values, but got [" + value + "]");
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
            b.field("type", "scaled_float").field("scaling_factor", scalingFactorField2);
        checker.registerConflictCheck("scaling_factor", fieldMapping(this::minimalMapping), fieldMapping(b -> {
        assertEquals(1230, pointField.numericValue().doubleValue(), 0d);
    public void testPluggablePathEquivalenceWithLucenePath() throws Exception {
        assertTrue(storedField.fieldType().stored());
package org.opensearch.index.mapper;
            b.endArray();
            scalingFactor
import org.apache.lucene.store.Directory;
        Exception e = expectThrows(
        Document doc = new Document();
            new SourceToParse(
import org.apache.lucene.index.IndexWriterConfig;
            b.endObject();
    }
        assertEquals(1051, decodedUp); // 10.5 scaled = 1050, then +1 = 1051 (represents 10.51)
            b.value("sum");
        })));
        ParsedDocument doc = mapper.parse(
    }
            b.startObject("config");
        }
        assertThat(e.getMessage(), containsString("Failed to parse mapping [_doc]: Field [scaling_factor] is required"));
        IndexableField dvField = fields[1];
            assertTrue("Lucene path should produce field '" + fieldName + "'", luceneFields.length > 0);
        DocumentMapper skiplistMapper = createDocumentMapper(
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
        checker.registerUpdateCheck(b -> b.field("coerce", false), m -> assertFalse(((ScaledFloatFieldMapper) m).coerce()));
        assertFalse(mapperService.fieldType("field").isSearchable());
    public void testPluggableDataFormatScaledFloatValue() throws Exception {
            b -> b.field("field", 3.14),
        );
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
     * An explicit {@code index: true} cannot be honoured on a pluggable-dataformat index — no point
        );
                assertEquals("{\"" + FIELD_NAME + "\":" + 11.52 + "}", source);
    }
            b.startArray("stats");
            b.field("type", "scaled_float").field("scaling_factor", scalingFactorField1);
            b.endObject();
        assertEquals(DocValuesSkipIndexType.RANGE, dvField.fieldType().docValuesSkipIndexType());
        );
    }
     * On a pluggable-dataformat index no BKD points are written for scaled_float fields, so
        assertThat(e.getCause().getMessage(), containsString(exceptionMessageContains));
            b.endObject();
        for (String value : values) {
     * queries match nothing.
    }
     */
                "test",
    @Override
            )
        MapperService mapperService = createMapperService(fieldMapping(b -> {
    public void testPluggableDataFormatDefaultsIndexToFalse() throws IOException {
        ParsedDocument doc = mapper.parse(
            b.startObject("field2");
        checker.registerConflictCheck("null_value", b -> b.field("null_value", 1));
        pluggableMapper.parse(source(sourceBuilder), docInput);
    public void testPluggableDataFormatMappingUpdateRejectsIndexTrue() throws IOException {
        MapperService mapperService = createMapperService(
        return Settings.builder()
     */
        }
            () -> createDocumentMapper(
        mapper.copyTo = copyTo;
        );
            b.field("index", true);
            b.endObject();
            }
            b.endArray();
        validateScaledFloatFields(doc, "field1", randomLongField1, scalingFactorField1);
        assertThrows(UnsupportedOperationException.class, mapper::canDeriveSource);
    protected void minimalMapping(XContentBuilder b) throws IOException {
        assertEquals(1230, storedField.numericValue().longValue());
        return doc;
public class ScaledFloatFieldMapperTests extends MapperTestCase {
    /** An explicit {@code index: false} is accepted on a pluggable-dataformat index. */
        );
                XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
        double scalingFactor = 100.0;
        assertEquals(mapping.toString(), mapper.mappingSource().toString());
        DocumentMapper mapper = createDocumentMapper(
        long scaledValue = Math.round(value * 100);
            b.field("type", "scaled_float");
/*
        DocumentMapper defaultMapper = createDocumentMapper(
        );
        mapper.parse(source(b -> b.field("field", 3.14)), docInput);
        IndexableField pointField = fields[0];
/*
        );
            b.endObject();
        // Test skiplist = "skip_list"
        List<String> values = Arrays.asList("NaN", "Infinity", "-Infinity");
                "test",
     * {@code index} defaults to false and the field reports itself as not searchable — routing
        assertEquals(2, fields.length);
        } else {
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", 123)));
import org.apache.lucene.index.DocValuesSkipIndexType;
        assertTrue(explicit.fieldType("field").isSearchable());
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
 * Modifications Copyright OpenSearch Contributors. See
            b.field("type", "star_tree");
            try (DirectoryReader reader = DirectoryReader.open(directory)) {
    }
     */
                BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("field", value).endObject()),
    public void testScaledFloatEncodePoint() {
    }
    }
        Settings pluggableSettings,
        doTestIgnoreMalformed("a", "For input string: \"a\"");
        MapperParsingException e = expectThrows(MapperParsingException.class, runnable);
     * `index_options` was deprecated and is rejected as of 7.0
            b.endObject();
    protected void registerParameters(ParameterChecker checker) throws IOException {
    /**
     * value of the already-mapped field unchanged.
                minimalMapping(b);
    }
 * KIND, either express or implied.  See the License for the
        );
    public void testExistsQueryDocValuesDisabled() throws IOException {
        assertFalse(pointField.fieldType().stored());
        assertFalse(dvField.fieldType().stored());
            pluggableSettings,
        }));
        ParsedDocument doc = mapper.parse(
        CapturingDocumentInput docInput = new CapturingDocumentInput();
        MapperParsingException e = expectThrows(MapperParsingException.class, runnable);
import org.opensearch.index.compositeindex.datacube.startree.StarTreeIndexSettings;
import org.opensearch.core.xcontent.MediaTypeRegistry;
        assertTrue(mapperService.fieldType("field").isSearchable());
    }
            minimalMapping(b);
        ParsedDocument doc = mapper2.parse(
        // Test invalid value
        boolean expectField
        XContentBuilder mapping = getStarTreeMappingWithScaledFloat(scalingFactorField1, scalingFactorField2, scalingFactorField3);
    }
import org.apache.lucene.index.DocValuesType;
    }
 * not use this file except in compliance with the License.
            .build();
                "1",
            b.endArray();
            )
        Exception e = expectThrows(
        DocumentMapper mapper = createDocumentMapper(
    public void testPluggableDataFormatAcceptsExplicitIndexFalse() throws IOException {
        return mapper;
    }
            b.field("name", "field2");
    }
            MapperParsingException.class,
        MapperParsingException e = expectThrows(
            b.startArray("metrics");
        assertEquals(2, fields.length); // point field + doc values field
        MapperService mapperService = createMapperService(pluggableSettings(), fieldMapping(b -> {
            "field",
            m -> assertTrue(((ScaledFloatFieldMapper) m).ignoreMalformed().value())
    /**
                MediaTypeRegistry.JSON
            b.startObject("startree");
                b -> b.field("type", "scaled_float").field("store", isStored).field("doc_values", hasDocValues).field("scaling_factor", 100)
import org.apache.lucene.index.IndexWriter;
        assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());
        assertThat(e.getMessage(), containsString("Failed to parse mapping [_doc]: Field [scaling_factor] is required"));
        double scalingFactorField2 = randomDouble() * 100;
        assertEquals(2, fields.length);
        DocumentMapper mapper = createDocumentMapper(mapping);
        DocumentMapper pluggableMapper = createDocumentMapper(pluggableSettings, mappingBuilder);
    ) throws IOException {
    }
                mapper.deriveSource(builder, reader.leaves().get(0).reader(), 0);
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> merge(mapperService, mapping(b -> {
 * this work for additional information regarding copyright
    public void testDerivedValueFetching_StoredField() throws IOException {
    @Override
                BytesReference.bytes(XContentFactory.jsonBuilder().startObject().nullField("field").endObject()),
                MediaTypeRegistry.JSON
    public void testMissingScalingFactor() {
        validateScaledFloatFields(doc, "field3", randomLongField3, scalingFactorField3);
        b.field("type", "scaled_float").field("scaling_factor", 10.0);
    }
        IndexableField dvField = fields[1];
            ScaledFloatFieldMapper mapper = getMapper(FieldMapper.CopyTo.empty(), true, false);
            }))
    }
        doc = mapper.parse(
        checker.registerConflictCheck("store", b -> b.field("store", true));
        });
        ParsedDocument doc = mapper.parse(
            pluggableSettings,
        byte[] encodedRoundDown = fieldType.encodePoint(originalValue, false);
