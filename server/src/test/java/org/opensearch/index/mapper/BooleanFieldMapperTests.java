    }
 * Licensed to Elasticsearch under one or more contributor
    public void testPluggableDataFormatAcceptsExplicitIndexFalse() throws IOException {
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
    protected void assertParseMaximalWarnings() {
        // Pluggable path
    public void testPluggableDataFormatRejectsExplicitIndexTrue() {
import org.apache.lucene.index.DirectoryReader;
            doc.add(new SortedNumericDocValuesField(FIELD_NAME, val ? 1 : 0));
        }));
        );
            b.field("index", true);
            }
        return mapper;
        assertEquals("Can't parse boolean value [random], expected [true] or [false]", e.getMessage());
    public void testParsesBooleansNestedStrict() throws IOException {
            "field",
            boolean pluggableHasField = docInput.getCapturedFields().stream().anyMatch(e -> e.getKey().name().equals(fieldName));
    protected Collection<? extends Plugin> getPlugins() {
    }
        BooleanFieldMapper mapper = getMapper(FieldMapper.CopyTo.empty(), false, false);
import org.opensearch.common.CheckedConsumer;
/*
                XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
        assertEquals(2, fields.length);
import org.apache.lucene.index.IndexableField;
        );
 */
            b.endObject();
import org.opensearch.common.util.FeatureFlags;
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
            fieldMapping(b -> b.field("type", "boolean").field("store", isStored).field("doc_values", hasDocValues))
import org.apache.lucene.index.DocValuesType;
package org.opensearch.index.mapper;
            boolean pluggableFound = docInput.getCapturedFields()
            mapping(b -> b.startObject("field").field("type", "boolean").field("null_value", true).endObject()),
        })));
    }
import org.opensearch.index.mapper.ParseContext.Document;
        assertExistsQuery(mapperService);
        }));
        assertEquals(
                b.field("inner_field", "no");
        Settings settings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
    /** Indices that do not use a pluggable dataformat keep the standard {@code index: true} default. */
                b.startObject("as_string").field("type", "keyword").endObject();
/*
            b.endObject();
        MapperParsingException ex = expectThrows(MapperParsingException.class, () -> defaultMapper.parse(source(b -> {
    }
        assertThat(e.getMessage(), containsString("cannot cover: [FULL_TEXT_SEARCH]"));
            minimalMapping(b);
            minimalMapping(b);
        assertNotNull(doc.rootDoc().getField("field.as_string"));
            {
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
    protected void registerParameters(ParameterChecker checker) throws IOException {
            try (DirectoryReader reader = DirectoryReader.open(directory)) {
                b.field("index", false);
 * ownership. Elasticsearch licenses this file to you under
        assertWarnings("Parameter [boost] on field [field] is deprecated and will be removed in 3.0");
     * value of the already-mapped field unchanged.
    protected void minimalMapping(XContentBuilder b) throws IOException {
/*
        if (hasDocValues) {
    }
            new BooleanFieldMapper.BooleanFieldType("bool").indexedValueForSearch(new BytesRef("true")),
    }
    }
            () -> createMapperService(pluggableSettings(), fieldMapping(b -> {
        MapperService mapperService = createMapperService(pluggableSettings(), fieldMapping(this::minimalMapping));
        );
    @Override
            BooleanFieldMapper.Values.TRUE
            capturingDocInput.getCapturedFields()
import org.opensearch.index.engine.dataformat.stub.MockDocValuesDataFormatPlugin;
        }));
        boolean val = Booleans.parseBoolean(chars, 0, chars.length, false);
        MapperService mapperService = createMapperService(fieldMapping(this::minimalMapping));
        assertEquals(DocValuesType.SORTED_NUMERIC, fields[0].fieldType().docValuesType());
        }
 * specific language governing permissions and limitations
        mapper = defaultMapper.mappers().getMapper("field");
        Document doc = parsedDoc.rootDoc();
     */
    public void testBoosts() throws Exception {
        MapperService mapperService = createMapperService(fieldMapping(this::minimalMapping));
        if (expectedValue == null) {
    private static final String FIELD_NAME = "field";
    }
        }));
            pluggableSettings,
        );
        assertBooleanLuceneAndPluggablePathsEquivalent(
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
            assertNotNull(values);
        assertFalse("existing field's value should be preserved across the update", mapperService.fieldType("field").isSearchable());
 *     http://www.apache.org/licenses/LICENSE-2.0
            // boolean fields are indexed and have doc values by default
     * mapping is rejected rather than silently producing a field whose queries match nothing.
                "failed to parse field [field] of type [boolean] in document with id '1'. " + "Preview of field's value: '" + value + "'",
 */
        }
                .anyMatch(e -> e.getKey().name().equals("field") && Boolean.TRUE.equals(e.getValue()))
            b.startObject("fields");
        assertBooleanLuceneAndPluggablePathsEquivalent(
    public void testDocValues() throws Exception {
 * software distributed under the License is distributed on an
            Boolean.TRUE
        Boolean expectedValue
        assertTrue(
import org.apache.lucene.index.Term;
        mapper.toXContent(builder, ToXContent.EMPTY_PARAMS);
        // Scenario 1: true value
        try (Directory directory = newDirectory()) {
import org.apache.lucene.search.TermQuery;
        try (Directory directory = newDirectory()) {
                .stream()
            pluggableSettings,
public class BooleanFieldMapperTests extends MapperTestCase {
        return List.of(new MockDocValuesDataFormatPlugin());
    /**
        CheckedConsumer<XContentBuilder, IOException> sourceBuilder,
 * under the License.
        DocumentMapper defaultMapper = createDocumentMapper(fieldMapping(this::minimalMapping));
            b.field("type", "boolean");
    private org.apache.lucene.document.Document createDocument(String value, boolean hasDocValues) {
        assertThrows(UnsupportedOperationException.class, mapper::canDeriveSource);
                builder.endObject();
}
    }
            assertTrue("Lucene path should produce field '" + fieldName + "'", luceneFields.length > 0);
    }
        assertEquals(
    private BooleanFieldMapper getMapper(FieldMapper.CopyTo copyTo, boolean hasDocValues, boolean isStored) throws IOException {
            b.endObject();
    }
        builder.endObject();
            fieldMapping(this::minimalMapping),
 *
    public void testNonPluggableDataFormatKeepsIndexTrue() throws IOException {
    public void testDerivedValueFetching_DocValues() throws IOException {
 * You may obtain a copy of the License at
        assertEquals(new BooleanFieldMapper.BooleanFieldType("bool").indexedValueForSearch(null), BooleanFieldMapper.Values.FALSE);
                MapperParsingException.class,
     * {@code index} defaults to false and the field reports itself as not searchable — routing
    }
        mapper.parse(source(b -> b.field("field", false)), capturingDocInput);
        }));
        pluggableMapper.parse(source(sourceBuilder), docInput);
        b.field("type", "boolean");
        // now change some parameters
                b.field("type", "boolean");
            {
                iw.addDocument(createDocument(value, true));
            ex.getMessage()
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
    private void assertBooleanLuceneAndPluggablePathsEquivalent(
import org.apache.lucene.index.LeafReader;
        DocumentMapper pluggableMapper = createDocumentMapper(pluggableSettings, mappingBuilder);
            }
        XContentBuilder mappingBuilder,
        DocumentMapper defaultMapper = createDocumentMapper(fieldMapping(this::minimalMapping));
    }
        ParsedDocument doc = mapperService.documentMapper().parse(source(this::writeField));
        assertEquals(new BooleanFieldMapper.BooleanFieldType("bool").indexedValueForSearch(false), BooleanFieldMapper.Values.FALSE);
        builder.value(true);
 *
            b.field("null_value", true);
            mapping(b -> b.startObject("field").field("type", "boolean").field("null_value", true).endObject())
            b.field("bool2", true);
        MapperService mapperService = createMapperService(pluggableSettings(), fieldMapping(this::minimalMapping));
                builder.endObject();
    public void testDefaults() throws IOException {
        builder.endObject();
        assertEquals("{\"field\":{\"type\":\"boolean\"}}", builder.toString());
    /** A mapping update that sets index:true on a new field is rejected on a pluggable data format index. */
        checker.registerConflictCheck("null_value", b -> b.field("null_value", true));
                .anyMatch(e -> e.getKey().name().equals("field") && Boolean.FALSE.equals(e.getValue()))
import org.apache.lucene.search.BoostQuery;
            );
    }
    }
import org.opensearch.common.settings.Settings;
            }
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
                mapper.deriveSource(builder, reader.leaves().get(0).reader(), 0);
            null
import org.apache.lucene.document.StoredField;
        BooleanFieldMapper mapper = (BooleanFieldMapper) mapperService.documentMapper().mappers().getMapper(FIELD_NAME);
import org.apache.lucene.document.SortedNumericDocValuesField;
    }
        CapturingDocumentInput capturingDocInput = new CapturingDocumentInput();
        Settings settings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
        Mapper mapper = defaultMapper.mappers().getMapper("field");
        assertThat(e.getMessage(), containsString("cannot cover: [FULL_TEXT_SEARCH]"));
            b.field("index", true);
    }
            b.field("doc_values", false);
        DocumentMapper mapper = createDocumentMapper(settings, fieldMapping(this::minimalMapping));
    public void testPossibleToDeriveSource_WhenCopyToPresent() throws IOException {
        MapperService mapperService = createMapperService(pluggableSettings(), fieldMapping(b -> {
        CapturingDocumentInput capturingDocInput = new CapturingDocumentInput();
        assertEquals(DocValuesType.SORTED_NUMERIC, fields[1].fieldType().docValuesType());
    public void testPluggableDataFormatBooleanNullValueConfigured() throws IOException {
    public void testPluggableDataFormatMappingUpdateDefaultsNewFieldToNotIndexed() throws IOException {
        // omit "false"/"true" here as they should still be parsed correctly
        ParsedDocument luceneDoc = luceneMapper.parse(source(sourceBuilder));
                XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
    @Override
            {
        assertBooleanLuceneAndPluggablePathsEquivalent(
        );
        );
        );
        fields = doc.getFields("bool3");
    public void testPluggablePathEquivalenceWithLucenePath() throws IOException {
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
    }
    public void testMultiFields() throws IOException {
    }
    public void testExistsQueryDocValuesDisabled() throws IOException {
            }))
import org.apache.lucene.index.SortedNumericDocValues;
        }
                .stream()
                () -> defaultMapper.parse(source(b -> b.field("field", value)))
        MappedFieldType ft = mapperService.fieldType("field");
        assertFalse(mapperService.fieldType("field").isSearchable());
        FieldMapper.CopyTo copyTo = new FieldMapper.CopyTo.Builder().add("copy_to_field").build();
            settings,
        }
        assertParseMinimalWarnings();
        );
        assertEquals(DocValuesType.NONE, fields[0].fieldType().docValuesType());
    public void testParsesBooleansStrict() throws IOException {
        );
     * A field added by a later mapping update also defaults to not-indexed, and the update leaves the
import static org.hamcrest.Matchers.containsString;
        );
    }
        assertFalse(mapperService.fieldType("field").isSearchable());
            String value = "true";
import org.apache.lucene.index.IndexWriter;
    }
        assertEquals(DocValuesType.SORTED_NUMERIC, fields[1].fieldType().docValuesType());
                assertEquals("{\"" + FIELD_NAME + "\":" + true + "}", source);
        MapperService mapperService = createMapperService(fieldMapping(b -> {
            b -> b.field("field", true),
     */
     * Helper method to create a document with both doc values and stored fields
            doc.add(new StoredField(FIELD_NAME, val ? "T" : "F"));
            b.endObject();
            b -> b.nullField("field"),
        );
            b -> b.nullField("field"),
            {
 *
            fieldMapping(this::minimalMapping),
        DocumentMapper mapper = createDocumentMapper(settings, fieldMapping(this::minimalMapping));
            b.startObject("bool3");
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
        }));
    public void testPluggableDataFormatBooleanNullSkipped() throws IOException {
    public void testPluggableDataFormatBooleanFalse() throws IOException {
        }));
            BooleanFieldMapper mapper = getMapper(FieldMapper.CopyTo.empty(), false, true);
            minimalMapping(b);
            .build();
            assertEquals(new BytesRef("T"), leaf.terms("field").iterator().next());
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
    public void testPluggableDataFormatMappingUpdateRejectsIndexTrue() throws IOException {
                b.field("index", true);
            "field",
        Settings settings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
                b.field("index", true);
        checker.registerUpdateCheck(b -> b.field("boost", 2.0), m -> assertEquals(m.fieldType().boost(), 2.0, 0));
 * not use this file except in compliance with the License.
     * On a pluggable-dataformat index the Lucene secondary writes no terms for boolean fields, so
                .stream()
            b -> b.field("field", false),
    public void testIndexedValueForSearch() throws Exception {
            pluggableSettings,
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
    }
    ) throws IOException {
            }
                .anyMatch(e -> e.getKey().name().equals(fieldName) && expectedValue.equals(e.getValue()));
    protected void writeFieldValue(XContentBuilder builder) throws IOException {
    }
    /** An explicit {@code index: false} is accepted on a pluggable-dataformat index. */
            capturingDocInput.getCapturedFields()
    public void testDerivedValueFetching_StoredField() throws IOException {
        assertEquals("{\"field\":{\"type\":\"boolean\",\"doc_values\":false,\"null_value\":true}}", builder.toString());
        assertEquals(DocValuesType.NONE, fields[0].fieldType().docValuesType());
    public void testPluggableDataFormatDefaultsIndexToFalse() throws IOException {
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
import org.opensearch.common.xcontent.XContentFactory;
 * the Apache License, Version 2.0 (the "License"); you may
    }
            BooleanFieldMapper mapper = getMapper(FieldMapper.CopyTo.empty(), true, false);
            .put("index.pluggable.dataformat.enabled", true)
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> {
            .put("index.pluggable.dataformat", MockDocValuesDataFormatPlugin.FORMAT_NAME)
    }
            b.field("type", "boolean");
                String source = builder.toString();
        assertTrue(
        checker.registerConflictCheck("index", b -> b.field("index", false));
    }
                .stream()
        mapper.toXContent(builder, ToXContent.EMPTY_PARAMS);
        assertTrue(explicit.fieldType("field").isSearchable());
            MapperParsingException.class,
            assertEquals("Lucene path should produce no field for '" + fieldName + "'", 0, luceneFields.length);
    @Override
        assertEquals(new BooleanFieldMapper.BooleanFieldType("bool").indexedValueForSearch(true), BooleanFieldMapper.Values.TRUE);
        CapturingDocumentInput capturingDocInput = new CapturingDocumentInput();
        BooleanFieldMapper mapper = getMapper(copyTo, true, true);
        assertFalse("newly added field should default to not-indexed", mapperService.fieldType("field2").isSearchable());
        fields = doc.getFields("bool2");
     * queries to the doc-values column instead of an empty inverted index.
        } else {
            try (DirectoryReader reader = DirectoryReader.open(directory)) {
        checker.registerConflictCheck("store", b -> b.field("store", true));
            );
        CapturingDocumentInput docInput = new CapturingDocumentInput();
            "failed to parse field [field] of type [boolean] in document with id '1'. " + "Preview of field's value: '{inner_field=no}'",
            b.startObject("field2");
import org.opensearch.core.xcontent.XContentBuilder;
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
                mapper.deriveSource(builder, reader.leaves().get(0).reader(), 0);
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
    public void testPossibleToDeriveSource_WhenDocValuesAndStoredDisabled() throws IOException {
            Boolean.FALSE
        // Scenario 2: false value
            }
            minimalMapping(b);
            new BooleanFieldMapper.BooleanFieldType("bool").indexedValueForSearch(new BytesRef("false")),
        return Settings.builder()
            b.field("bool3", true);
            pluggableSettings,
            }
            SortedNumericDocValues values = leaf.getSortedNumericDocValues("field");
import java.util.Collection;
            }
    @Override
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", false)));
        }));
            assertTrue("Pluggable path should capture field '" + fieldName + "' with value '" + expectedValue + "'", pluggableFound);
            }
        CapturingDocumentInput capturingDocInput = new CapturingDocumentInput();
 * Modifications Copyright OpenSearch Contributors. See
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
 * license agreements. See the NOTICE file distributed with
            b.startObject("field");
        DocumentMapper mapper = createDocumentMapper(settings, fieldMapping(this::minimalMapping));
        MapperService mapperService = createMapperService(pluggableSettings(), fieldMapping(this::minimalMapping));
        assertThrows(UnsupportedOperationException.class, mapper::canDeriveSource);
 * compatible open source license.
    }
 * SPDX-License-Identifier: Apache-2.0
            assertFalse("Pluggable path should produce no field for '" + fieldName + "'", pluggableHasField);
                b.field("type", "boolean");
        } else {
    public void testPluggableDataFormatBooleanTrue() throws IOException {
                .anyMatch(e -> e.getKey().name().equals("field") && Boolean.TRUE.equals(e.getValue()))
        assertBooleanLuceneAndPluggablePathsEquivalent(
     */
            "field",
        DocumentMapper defaultMapper = createDocumentMapper(mapping(b -> {
     */
        // Scenario 3: null value — no field produced
        char[] chars = value.toCharArray();
        defaultMapper = createDocumentMapper(fieldMapping(b -> {
 * The OpenSearch Contributors require contributions made to
        );
import org.apache.lucene.util.BytesRef;
     * An explicit {@code index: true} cannot be honoured on a pluggable-dataformat index, so the
        }));
import java.util.List;
        assertEquals(1, fields.length);
            "field",
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> merge(mapperService, mapping(b -> {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertTrue(mapperService.fieldType("field").isSearchable());
            minimalMapping(b);
        MapperService mapperService = createMapperService(
import java.io.IOException;
                ex.getMessage()
import org.opensearch.core.xcontent.ToXContent;
        assertEquals(
            IllegalArgumentException.class,
import org.opensearch.plugins.Plugin;
        });
                iw.addDocument(createDocument(value, false));
    public void testSerialization() throws IOException {
 * this work for additional information regarding copyright
        }
            assertEquals(
        IndexableField[] luceneFields = luceneDoc.rootDoc().getFields(fieldName);
            b.field("bool1", true);
        );
    /**
        ParsedDocument parsedDoc = defaultMapper.parse(source(b -> {
        MapperParsingException e = expectThrows(
            String value = "";  // empty string means false under boolean field mapping
 * KIND, either express or implied.  See the License for the
    private static Settings pluggableSettings() {
            b.startObject("bool2");
        // Scenario 4: null_value configured — substitution kicks in
        // Lucene path
        merge(mapperService, mapping(b -> {
            b.endObject();
        assertTrue(capturingDocInput.getCapturedFields().stream().noneMatch(e -> e.getKey().name().equals("field")));
        MapperService explicit = createMapperService(fieldMapping(b -> {
                minimalMapping(b);
            MapperParsingException ex = expectThrows(
        withLuceneIndex(mapperService, iw -> iw.addDocument(doc.rootDoc()), reader -> {
    }
        org.apache.lucene.document.Document doc = new org.apache.lucene.document.Document();
        DocumentMapper mapper = createDocumentMapper(
        assertParseMaximalWarnings();
        Settings pluggableSettings,
        mapper.parse(source(b -> b.nullField("field")), capturingDocInput);
        assertFalse(mapperService.fieldType("field").isSearchable());
        assertEquals(new BoostQuery(new TermQuery(new Term("field", "T")), 2.0f), ft.termQuery("true", null));
        mapper.parse(source(b -> b.nullField("field")), capturingDocInput);
        IndexableField[] fields = doc.getFields("bool1");
                assertEquals("{\"" + FIELD_NAME + "\":" + false + "}", source);
    }
        mapper.copyTo = copyTo;
            b.startObject("bool1").field("type", "boolean").endObject();
            minimalMapping(b);
        return doc;
            final LeafReader leaf = reader.leaves().get(0).reader();
        assertTrue(
            b.startObject("field2");
    }
 * GitHub history for details.
            assertEquals(1, values.nextValue());
        DocumentMapper luceneMapper = createDocumentMapper(mappingBuilder);
    }
                String source = builder.toString();
            assertEquals(1, values.docValueCount());
        builder = XContentFactory.jsonBuilder().startObject();
            BooleanFieldMapper.Values.FALSE
            Boolean.TRUE
            () -> new BooleanFieldMapper.BooleanFieldType("bool").indexedValueForSearch(new BytesRef("random"))
        Settings settings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
            b.field("doc_values", false);
            b.endObject();
        );
import org.apache.lucene.store.Directory;
    /**
    /**
            fieldMapping(this::minimalMapping),
            capturingDocInput.getCapturedFields()
        MapperService mapperService = createMapperService(fieldMapping(b -> {
        for (String value : new String[] { "off", "no", "0", "on", "yes", "1" }) {
        checker.registerConflictCheck("doc_values", b -> b.field("doc_values", false));
 */
        IllegalArgumentException e = expectThrows(
import org.apache.lucene.index.IndexWriterConfig;
            b.field("boost", 2.0);
            assertTrue(values.advanceExact(0));
        DocumentMapper defaultMapper = createDocumentMapper(fieldMapping(this::minimalMapping));
import org.opensearch.common.Booleans;
            b.field("index", false);
        String fieldName,
    }
        mapper.parse(source(b -> b.field("field", true)), capturingDocInput);
        })));
    }
