import org.apache.lucene.index.DocValuesSkipIndexType;  
        );  
                "test",
 *    http://www.apache.org/licenses/LICENSE-2.0
            doTestIgnoreMalformed(value, "[scaled_float] only supports finite values, but got [" + value + "]");  
    }
                BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("field", 123).endObject()),
            }  
        );
    private ScaledFloatFieldMapper getMapper(FieldMapper.CopyTo copyTo, boolean hasDocValues, boolean isStored) throws IOException {  
    public void testScaledFloatEncodePoint() {
        CapturingDocumentInput docInput = new CapturingDocumentInput();
import org.apache.lucene.index.DirectoryReader;
        assertExistsQuery(mapperService);
            MapperParsingException.class,
    }
            minimalMapping(b);  
        ScaledFloatFieldMapper mapper = (ScaledFloatFieldMapper) mapperService.documentMapper().mappers().getMapper(FIELD_NAME);  
        // Pluggable path
        checker.registerUpdateCheck(
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        assertEquals(1, pointField.fieldType().pointDimensionCount());
        assertTrue(explicit.fieldType("field").isSearchable());
        double scalingFactorField2 = randomDouble() * 100;
        return Settings.builder()  
        checker.registerConflictCheck("doc_values", b -> b.field("doc_values", false));
                String source = builder.toString();  
            () -> createMapperService(pluggableSettings(), fieldMapping(b -> {  
        assertEquals(mapping.toString(), mapper.mappingSource().toString());  
        assertThat(e.getMessage(), containsString("cannot cover: [POINT_RANGE]"));
            doc.add(new StoredField(FIELD_NAME, scaledValue));
            assertEquals("Lucene path should produce no field for '" + fieldName + "'", 0, luceneFields.length);  
import org.apache.lucene.index.IndexWriterConfig;  
import org.apache.lucene.index.DocValuesType;
     */
 * GitHub history for details.
        assertEquals(1230, dvField.numericValue().longValue());
    public void testNoDocValues() throws Exception {
        validateScaledFloatFields(doc, "field", 123, 10.0);  
        assertThat(e.getMessage(), containsString("cannot cover: [POINT_RANGE]"));
        assertEquals(1, fields.length);
        doc = skiplistMapper.parse(source(b -> b.field("field", 123.45)));
        merge(mapperService, mapping(b -> {
        );
        DocumentMapper mapper = createDocumentMapper(
            b.endObject();
    ) throws IOException {
        IndexableField[] fields = doc.rootDoc().getFields("field");
        assertEquals(1230, pointField.numericValue().doubleValue(), 0d);
            b.field("name", "field2");
        ParsedDocument doc = mapper2.parse(
        checker.registerConflictCheck("skip_list", b -> b.field("skip_list", true));  
import org.opensearch.common.util.FeatureFlags;  
            () -> createMapperService(fieldMapping(b -> b.field("type", "scaled_float")))  
        long randomLongField3 = randomLong();
                iw.addDocument(createDocument(value, true));
            ScaledFloatFieldMapper mapper = getMapper(FieldMapper.CopyTo.empty(), false, true);
 * license agreements. See the NOTICE file distributed with
    public void testScaledFloatWithStarTree() throws Exception {
            b.endObject();
        ParsedDocument doc = mapper.parse(  
import org.opensearch.core.common.bytes.BytesReference;
        long randomLongField2 = randomLong();
                "1",  
            b.startArray("ordered_dimensions");
 * specific language governing permissions and limitations
        Settings pluggableSettings,
     * `index_options` was deprecated and is rejected as of 7.0
 * the Apache License, Version 2.0 (the "License"); you may
        );
                assertEquals("{\"" + FIELD_NAME + "\":" + 11.52 + "}", source);
            pluggableSettings,
            }))  
        assertEquals(1, pointField.fieldType().pointDimensionCount());  
        double scalingFactorField3 = randomDouble() * 100;  
     * On a pluggable-dataformat index no BKD points are written for scaled_float fields, so
        );
import java.io.IOException;  
            b.endObject();
                MediaTypeRegistry.JSON
            source(b -> b.field("field1", randomLongField1).field("field2", randomLongField2).field("field3", randomLongField3))
        Exception e = expectThrows(  
            b.startObject("field2");  
            .put("index.pluggable.dataformat", MockDocValuesDataFormatPlugin.FORMAT_NAME)
                "1",
    }  
    @Override
            )  
        );  
 * You may obtain a copy of the License at  
        MapperService mapperService = createMapperService(pluggableSettings(), fieldMapping(this::minimalMapping));  
        b.field("type", "scaled_float").field("scaling_factor", 10.0);
        long decodedDown = LongPoint.decodeDimension(encodedRoundDown, 0);
import org.apache.lucene.index.IndexableField;
            b.endArray();  
                "test",
            )
        IndexableField dvField = fields[1];  
        assertThat(e.getMessage(), containsString("Failed to parse mapping [_doc]: Field [scaling_factor] is required"));
        DocumentMapper mapper = createDocumentMapper(mapping);
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
            mapping(b -> b.startObject("field").field("type", "scaled_float").field("scaling_factor", 100).endObject())
            .build();  
            b.startObject("startree");
        mapper.parse(source(b -> b.field("field", 3.14)), docInput);  
        XContentBuilder mappingBuilder,  
        List<String> values = Arrays.asList("NaN", "Infinity", "-Infinity");
import org.apache.lucene.document.SortedNumericDocValuesField;  
 * SPDX-License-Identifier: Apache-2.0
                BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("field", 123).endObject()),
            fieldMapping(b -> b.field("type", "scaled_float").field("doc_values", false).field("scaling_factor", 10.0))  
    public void testCoerce() throws Exception {  
import java.util.List;  
        assertEquals(1230, pointField.numericValue().longValue());
        }));
            minimalMapping(b);
        IndexableField[] fields = doc.rootDoc().getFields("field");  
            b.startObject("field2");
        IndexableField storedField = fields[2];
            )  
                BytesReference.bytes(XContentFactory.jsonBuilder().startObject().nullField("field").endObject()),  
        boolean found = docInput.getCapturedFields().stream().anyMatch(e -> e.getKey().name().equals("field"));
import org.opensearch.core.xcontent.XContentBuilder;
                MediaTypeRegistry.JSON
        assertTrue(storedField.fieldType().stored());
        // Lucene path
    }  
        long scaledValue = Math.round(value * 100);  
        MapperService mapperService = createMapperService(fieldMapping(this::minimalMapping));
        assertFalse(mapperService.fieldType("field").isSearchable());
                BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("field", 123).endObject()),
                BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("field", "123").endObject()),
                assertEquals("{\"" + FIELD_NAME + "\":" + 11.52 + "}", source);
    }
        assertEquals(2, fields.length); // point field + doc values field
        ParsedDocument doc = mapper.parse(  
        MapperParsingException e = expectThrows(MapperParsingException.class, runnable);
        checker.registerUpdateCheck(b -> b.field("coerce", false), m -> assertFalse(((ScaledFloatFieldMapper) m).coerce()));
        assertEquals(1, pointField.fieldType().pointDimensionCount());  
        DocumentMapper skiplistMapper = createDocumentMapper(
            )
                "test",
            b.field("type", "scaled_float");
        checker.registerConflictCheck("null_value", b -> b.field("null_value", 1));  
        CapturingDocumentInput docInput = new CapturingDocumentInput();
    public void testNotIndexed() throws Exception {
        assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());
                builder.endObject();
            b.endArray();  
        assertFalse("Expected no field entry for null value", found);
    }
            mapping(b -> b.startObject("field").field("type", "scaled_float").field("scaling_factor", 100).endObject())  
    public void testPluggablePathEquivalenceWithLucenePath() throws Exception {  
    private static void validateScaledFloatFields(ParsedDocument doc, String field, long value, double scalingFactor) {
    public void testRejectIndexOptions() {
        return topMapping(b -> {
        MapperParsingException e = expectThrows(
            )
            MapperParsingException.class,
import org.opensearch.cluster.metadata.IndexMetadata;  
            MapperParsingException.class,  
            b.field("doc_values", false);
    protected void writeFieldValue(XContentBuilder builder) throws IOException {
                MediaTypeRegistry.JSON
        DocumentMapper mapper = createDocumentMapper(
        IndexableField dvField = fields[1];  
        mapper.copyTo = copyTo;
 *  
        IndexableField pointField = fields[0];
            b.endObject();  
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
        ParsedDocument doc = defaultMapper.parse(source(b -> b.field("field", 123.45)));  
        ParsedDocument doc = mapper.parse(
        assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());
        checker.registerConflictCheck("scaling_factor", fieldMapping(this::minimalMapping), fieldMapping(b -> {
            new SourceToParse(  
        doTestIgnoreMalformed(true, "Current token (VALUE_TRUE) not numeric");
        assertThat(e.getMessage(), containsString("[scaling_factor] must be a positive number, got [-1.0]"));
    /**  
    /** An explicit {@code index: false} is accepted on a pluggable-dataformat index. */
        assertWarnings("Parameter [index_options] has no effect on type [scaled_float] and will be removed in future");
            new SourceToParse(
            fieldMapping(b -> b.field("type", "scaled_float").field("scaling_factor", 10.0).field("ignore_malformed", true))  
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)  
        doTestIgnoreMalformed("a", "For input string: \"a\"");
            b.startObject();  
            )
        XContentBuilder mapping = fieldMapping(b -> b.field("type", "scaled_float").field("scaling_factor", 10.0));
     * queries to the doc-values column instead of an empty point index.  
    @Override
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        DocumentMapper mapper = createDocumentMapper(mapping);  
        byte[] encodedRoundDown = fieldType.encodePoint(originalValue, false);  
            b.startObject("field3");
    public void testPluggableDataFormatDefaultsIndexToFalse() throws IOException {  
            true  
    private void assertScaledFloatLuceneAndPluggablePathsEquivalent(
        checker.registerConflictCheck("store", b -> b.field("store", true));
            try (DirectoryReader reader = DirectoryReader.open(directory)) {
        assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());  
        );
     */
package org.opensearch.index.mapper;
            new SourceToParse(
        assertTrue("Expected scaled float field to be captured", found);  
    protected void registerParameters(ParameterChecker checker) throws IOException {  
        DocumentMapper defaultMapper = createDocumentMapper(  
            pluggableSettings,
        IndexableField dvField = fields[1];
    public void testIllegalScalingFactor() {
            b.field("index", true);
        try (Directory directory = newDirectory()) {
        return mapper;
            b.startObject("field2");
        DocumentMapper mapper2 = createDocumentMapper(  
        assertEquals(2, fields.length);
        return List.of(new MapperExtrasModulePlugin(), new MockDocValuesDataFormatPlugin());
            new SourceToParse(
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();  
            b.field("name", "field1");
    protected Collection<? extends Plugin> getPlugins() {  
    }
        boolean pluggableHasField = docInput.getCapturedFields().stream().anyMatch(e -> e.getKey().name().equals(fieldName));  
            )  
    }  
 * this work for additional information regarding copyright
    }
    }
                minimalMapping(b);
        IndexableField[] fields = doc.rootDoc().getFields("field");  
            new SourceToParse(  
        boolean found = docInput.getCapturedFields().stream().anyMatch(e -> e.getKey().name().equals("field"));
            b.endObject();
            fieldMapping(b -> b.field("type", "scaled_float").field("store", true).field("scaling_factor", 10.0))  
            b.startObject("properties");
    public void testPluggableDataFormatAcceptsExplicitIndexFalse() throws IOException {
    }
                fieldMapping(b -> b.field("type", "scaled_float").field("scaling_factor", 100).field("skip_list", "invalid"))
        assertFalse(pointField.fieldType().stored());
/*  
        );
        IndexableField dvField = fields[1];
 * compatible open source license.
        assertParseMinimalWarnings();
            doc.add(new SortedNumericDocValuesField(FIELD_NAME, scaledValue));  
 * Licensed to Elasticsearch under one or more contributor  
                "1",  
        assertFalse(mapperService.fieldType("field").isSearchable());  
        assertFalse(dvField.fieldType().stored());  
        validateScaledFloatFields(doc, "field1", randomLongField1, scalingFactorField1);  
                "test",
                BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("field", "123").endObject()),  
        );
 * Unless required by applicable law or agreed to in writing,
                XContentBuilder builder = XContentFactory.jsonBuilder().startObject();  
    public void testNullValue() throws IOException {  
    }
    /**
     * index is written — so the mapping is rejected rather than silently producing a field whose
        })));  
        assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());  
        mapper.parse(source(b -> b.nullField("field")), docInput);
                MediaTypeRegistry.JSON
        validateScaledFloatFields(doc, "field3", randomLongField3, scalingFactorField3);
    @Override
    }  
 *
     * {@code index} defaults to false and the field reports itself as not searchable — routing
            scalingFactor
        );
            new SourceToParse(
                "test",
    }
                BytesReference.bytes(XContentFactory.jsonBuilder().startObject().nullField("field").endObject()),
            ScaledFloatFieldMapper mapper = getMapper(FieldMapper.CopyTo.empty(), true, false);
        }));  
                String source = builder.toString();  
            b -> b.field("ignore_malformed", true),  
     */  
            pluggableSettings,
     */
    public void testSkiplistParameter() throws IOException {
                "1",  
        IndexableField pointField = fields[0];  
        boolean expectField  
     */
            pluggableSettings,
            b.startArray("metrics");
        ParsedDocument doc = mapper.parse(
        IndexableField[] fields = doc.rootDoc().getFields("field");  
        dvField = fields[1];
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)  
    /** A mapping update that sets index:true on a new field is rejected on a pluggable data format index. */  
    }  
    }
import org.opensearch.index.engine.dataformat.stub.MockDocValuesDataFormatPlugin;  
    public void testPluggableDataFormatScaledFloatNullSkipped() throws Exception {
            false  
            }  
        assertThrows(UnsupportedOperationException.class, mapper::canDeriveSource);  
    }
                b.field("index", true);
        assertThat(e.getMessage(), containsString("Failed to parse value [invalid] as only [true] or [false] are allowed"));
        double scalingFactorField2,
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> merge(mapperService, mapping(b -> {
            b.endObject();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    ) throws IOException {
            b.value("value_count");  
            )  
 * not use this file except in compliance with the License.
    protected Settings getIndexSettings() {  
import org.apache.lucene.document.Document;
        assertEquals(1, pointField.fieldType().pointDimensionCount());  
        }  
    }  
        // Test default value (none)
            b.field("type", "scaled_float").field("scaling_factor", scalingFactorField3);  
        );
        } else {
    public void testDerivedValueFetching_StoredField() throws IOException {  
        MapperService mapperService = createMapperService(pluggableSettings(), fieldMapping(this::minimalMapping));
                MediaTypeRegistry.JSON
        );
            "field",
            b.field("type", "scaled_float").field("scaling_factor", scalingFactorField2);  
            b.startObject();  
     * value of the already-mapped field unchanged.
            b.field("type", "star_tree");
    private void doTestIgnoreMalformed(Object value, String exceptionMessageContains) throws Exception {
            fieldMapping(b -> b.field("type", "scaled_float").field("scaling_factor", 100).field("skip_list", "true"))  
            b.field("name", "field3");  
                b -> b.field("type", "scaled_float").field("store", isStored).field("doc_values", hasDocValues).field("scaling_factor", 100)  
        long decodedUp = LongPoint.decodeDimension(encodedRoundUp, 0);
    }
        assertEquals(1051, decodedUp); // 10.5 scaled = 1050, then +1 = 1051 (represents 10.51)  
        );
    public void testStore() throws Exception {
import org.apache.lucene.index.IndexWriter;
                MediaTypeRegistry.JSON
            b.startObject("composite");  
        assertEquals(2, fields.length);  
    @Override
        );
 * KIND, either express or implied.  See the License for the
        assertEquals(25, pointField.numericValue().longValue());
     * A field added by a later mapping update also defaults to not-indexed, and the update leaves the  
    }
        assertFalse(dvField.fieldType().stored());
            }
    }
                MediaTypeRegistry.JSON
            () -> createMapperService(fieldMapping(b -> b.field("type", "scaled_float").field("scaling_factor", -1)))
            b.startObject();
                mapper.deriveSource(builder, reader.leaves().get(0).reader(), 0);
    /**  
    private XContentBuilder getStarTreeMappingWithScaledFloat(  
                "test",
        );
        assertFalse("newly added field should default to not-indexed", mapperService.fieldType("field2").isSearchable());
                builder.endObject();
        assertFalse(mapperService.fieldType("field").isSearchable());  
    }  
    /**
    public void testIgnoreMalformed() throws Exception {  
            mapping(b -> b.startObject("field").field("type", "scaled_float").field("scaling_factor", 100).endObject()),  
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
        assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());  
        assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field"));
    }
                MediaTypeRegistry.JSON
import java.util.Collection;
        byte[] encodedRoundUp = fieldType.encodePoint(originalValue, true);
    @Override  
            fieldMapping(b -> b.field("type", "scaled_float").field("scaling_factor", 10.0).field("null_value", 2.5))
    }  
        CapturingDocumentInput docInput = new CapturingDocumentInput();  
            fieldMapping(b -> b.field("type", "scaled_float").field("scaling_factor", 100))
        doc = mapper.parse(  
        // Test skiplist = "skip_list"
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", 123)));
            fieldMapping(
        validateScaledFloatFields(doc, "field2", randomLongField2, scalingFactorField2);
        MapperParsingException e = expectThrows(
        }
                "1",  
import org.apache.lucene.document.StoredField;
                BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("field", value).endObject()),
        assertFalse("existing field's value should be preserved across the update", mapperService.fieldType("field").isSearchable());  
            minimalMapping(b);  
            b -> b.nullField("field"),
    }
            b -> b.field("field", 3.14),
            m -> assertTrue(((ScaledFloatFieldMapper) m).ignoreMalformed().value())
        ThrowingRunnable runnable = () -> mapper2.parse(  
            b.endObject();
import java.util.Arrays;
            new SourceToParse(
import static org.hamcrest.Matchers.containsString;
        } else {
        assertEquals(0, fields.length);  
 * this file be licensed under the Apache-2.0 license or a
        double scalingFactorField3  
        MapperService explicit = createMapperService(fieldMapping(b -> {
 */
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        MapperParsingException e = expectThrows(
        CheckedConsumer<XContentBuilder, IOException> sourceBuilder,
public class ScaledFloatFieldMapperTests extends MapperTestCase {
        double scalingFactorField1,
        assertFalse(pointField.fieldType().stored());  
        double scalingFactor = 100.0;
    public void testDefaults() throws Exception {  
        MapperService mapperService = createMapperService(pluggableSettings(), fieldMapping(b -> {
        );
        Exception e = expectThrows(
    private static Settings pluggableSettings() {
        mapper = createDocumentMapper(  
import org.opensearch.common.CheckedConsumer;
        assertThat(e.getMessage(), containsString("Failed to parse mapping [_doc]: Field [scaling_factor] is required"));  
            b.field("index", false);
                iw.addDocument(createDocument(value, false));
        assertEquals((long) (value * scalingFactor), pointField.numericValue().longValue());
        // Test invalid value  
        );
        Document doc = new Document();
            .put(StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.getKey(), true)
            b.endObject();
    public void testPluggableDataFormatRejectsExplicitIndexTrue() {  
        }));  
    protected void minimalMapping(XContentBuilder b) throws IOException {
     * An explicit {@code index: true} cannot be honoured on a pluggable-dataformat index — no point
        IndexableField pointField = fields[0];
            .build();
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
        DocumentMapper pluggableMapper = createDocumentMapper(pluggableSettings, mappingBuilder);
    public void testDerivedValueFetching_DocValues() throws IOException {  
        }
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        String fieldName,
            "field",
        IndexableField[] fields = doc.rootDoc().getFields("field");
    /**
        );
            b.field("index", true);  
                "1",
    }
        assertEquals(3, fields.length);
        assertEquals(1049, decodedDown); // 10.5 scaled = 1050, then -1 = 1049 (represents 10.49)
                "1",  
    }  
            assertTrue("Lucene path should produce field '" + fieldName + "'", luceneFields.length > 0);  
 */  
        FieldMapper.CopyTo copyTo = new FieldMapper.CopyTo.Builder().add("copy_to_field").build();
        );  
            .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), true)  
}  
        assertEquals(2, fields.length);
 * software distributed under the License is distributed on an
        assertThat(e.getCause().getMessage(), containsString(exceptionMessageContains));  
            b.field("max_leaf_docs", 100);
        assertEquals(1230, storedField.numericValue().longValue());  
        ThrowingRunnable runnable = () -> mapper.parse(  
            float value = 11.523f;  
            MapperParsingException.class,
        return doc;
        ScaledFloatFieldMapper mapper = getMapper(FieldMapper.CopyTo.empty(), false, false);
 * The OpenSearch Contributors require contributions made to  
        );
        }  
            b.field("type", "scaled_float").field("scaling_factor", scalingFactorField1);  
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)  
        // Scenario 1: scaled float value  
        );
 * Modifications Copyright OpenSearch Contributors. See
 */  
    }
            () -> createDocumentMapper(  
     * Helper method to create a document with both doc values and stored fields  
    public void testPluggableDataFormatScaledFloatValue() throws Exception {
    public void testPossibleToDeriveSource_WhenDocValuesAndStoredDisabled() throws IOException {
        ParsedDocument luceneDoc = luceneMapper.parse(source(sourceBuilder));
            )
            minimalMapping(b);
        );  
            () -> createMapperService(fieldMapping(b -> b.field("type", "scaled_float").field("index_options", randomIndexOptions())))
            new SourceToParse(  
import org.apache.lucene.store.Directory;
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
        IndexableField dvField = fields[1];  
        assertEquals(DocValuesSkipIndexType.RANGE, dvField.fieldType().docValuesSkipIndexType());
     * queries match nothing.  
                XContentBuilder builder = XContentFactory.jsonBuilder().startObject();  
            )  
            new SourceToParse(
        checker.registerConflictCheck("index", b -> b.field("index", false));
import org.opensearch.common.xcontent.XContentFactory;
        long randomLongField1 = randomLong();  
        assertEquals(1, pointField.fieldType().pointDimensionCount());
    }
    /** Indices that do not use a pluggable dataformat keep the standard {@code index: true} default. */
    public void testMissingScalingFactor() {  
    public void testPluggableDataFormatMappingUpdateRejectsIndexTrue() throws IOException {
        );
        DocumentMapper mapper2 = createDocumentMapper(
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
        assertScaledFloatLuceneAndPluggablePathsEquivalent(
        assertTrue(mapperService.fieldType("field").isSearchable());
        IndexableField[] luceneFields = luceneDoc.rootDoc().getFields(fieldName);
            float value = 11.523f;  
        if (hasDocValues) {
                "test",
        MapperService mapperService = createMapperService(pluggableSettings(), fieldMapping(this::minimalMapping));
        IndexableField dvField = fields[0];
            }
        });  
        IndexableField[] fields = doc.rootDoc().getFields("field");
    private static final String FIELD_NAME = "field";  
                mapper.deriveSource(builder, reader.leaves().get(0).reader(), 0);
        DocumentMapper mapper = createDocumentMapper(
        }  
                "1",
            assertTrue("Pluggable path should capture field '" + fieldName + "'", pluggableHasField);
        double scalingFactorField1 = randomDouble() * 100;
    }
            assertFalse("Pluggable path should produce no field for '" + fieldName + "'", pluggableHasField);
            fieldMapping(b -> b.field("type", "scaled_float").field("scaling_factor", 10.0).field("coerce", false))
        XContentBuilder mapping = getStarTreeMappingWithScaledFloat(scalingFactorField1, scalingFactorField2, scalingFactorField3);
        }));
        ParsedDocument doc = mapper.parse(  
                "1",  
        DocumentMapper mapper = createDocumentMapper(
                MediaTypeRegistry.JSON
/*  
        assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());  
    }
        );  
/*
            "test_field",
            fieldMapping(b -> b.field("type", "scaled_float").field("index", false).field("scaling_factor", 10.0))  
            b.endObject();
        IndexableField[] fields = doc.rootDoc().getFields(field);  
    }  
    public void testExistsQueryDocValuesDisabled() throws IOException {
    }
 * under the License.  
            b.value("sum");
            b.endObject();
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
            minimalMapping(b);
    }
        );
                "test",
            b.field("scaling_factor", 5.0);  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.plugins.Plugin;
        MapperService mapperService = createMapperService(
        fields = doc.rootDoc().getFields("field");  
            )  
            b.startArray("stats");
        }));
import org.opensearch.core.xcontent.MediaTypeRegistry;  
        ScaledFloatFieldMapper mapper = getMapper(copyTo, true, true);
            b.endObject();
    }
        if (!expectField) {
        );
    private Document createDocument(double value, boolean hasDocValues) {
            .put("index.pluggable.dataformat.enabled", true)
            .put(super.getIndexSettings())
import org.apache.lucene.document.LongPoint;
        IndexableField[] fields = doc.rootDoc().getFields("field");
        assertEquals(2, fields.length);
 *
                BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("field", value).endObject()),  
    }
            b.startObject("config");  
        DocumentMapper mapper = createDocumentMapper(  
            MapperParsingException.class,
        assertEquals(DocValuesSkipIndexType.NONE, dvField.fieldType().docValuesSkipIndexType());
        builder.value(123);  
        );
        try (Directory directory = newDirectory()) {
    public void testPossibleToDeriveSource_WhenCopyToPresent() throws IOException {  
        assertEquals((long) (value * scalingFactor), dvField.numericValue().longValue());
    public void testPluggableDataFormatMappingUpdateDefaultsNewFieldToNotIndexed() throws IOException {
        ParsedDocument doc = mapper.parse(  
        assertEquals(1230, pointField.numericValue().longValue());
        );  
        assertScaledFloatLuceneAndPluggablePathsEquivalent(
            mapping(b -> b.startObject("field").field("type", "scaled_float").field("scaling_factor", 100).endObject()),  
        double originalValue = 10.5;
        IndexableField pointField = fields[0];
    }  
            b.startObject("field1");
        pluggableMapper.parse(source(sourceBuilder), docInput);
        assertEquals(DocValuesType.SORTED_NUMERIC, dvField.fieldType().docValuesType());
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
    }  
                "test",
import org.opensearch.common.settings.Settings;
        assertTrue(mapping.toString().contains("startree"));
            b.endObject();
        return Settings.builder()
        MapperParsingException e = expectThrows(MapperParsingException.class, runnable);
        // Scenario 2: null value — no field produced  
        DocumentMapper luceneMapper = createDocumentMapper(mappingBuilder);  
    public void testNonPluggableDataFormatKeepsIndexTrue() throws IOException {  
            b.endArray();
    }
        );
            try (DirectoryReader reader = DirectoryReader.open(directory)) {
        for (String value : values) {
        assertEquals(1, fields.length);
        IndexableField pointField = fields[0];
        );  
        ScaledFloatFieldMapper.ScaledFloatFieldType fieldType = new ScaledFloatFieldMapper.ScaledFloatFieldType(  
import org.opensearch.index.compositeindex.datacube.startree.StarTreeIndexSettings;
        assertThrows(UnsupportedOperationException.class, mapper::canDeriveSource);  
        MapperService mapperService = createMapperService(fieldMapping(b -> {  
        assertThat(e.getCause().getMessage(), containsString("passed as String"));  
