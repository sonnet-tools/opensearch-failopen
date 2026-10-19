        mapper.parse(source(b -> b.field("field", true)), capturingDocInput);
import org.opensearch.index.mapper.ParseContext.Document;
            .put("index.pluggable.dataformat", MockDocValuesDataFormatPlugin.FORMAT_NAME)
    /** Indices that do not use a pluggable dataformat keep the standard {@code index: true} default. */  
        // Scenario 1: true value
import org.opensearch.common.Booleans;  
            }
            try (DirectoryReader reader = DirectoryReader.open(directory)) {
            }
            b.endObject();
        assertEquals(DocValuesType.SORTED_NUMERIC, fields[0].fieldType().docValuesType());  
        defaultMapper = createDocumentMapper(fieldMapping(b -> {
import static org.hamcrest.Matchers.containsString;  
            b.startObject("bool1").field("type", "boolean").endObject();
    }  
 * the Apache License, Version 2.0 (the "License"); you may
            () -> createMapperService(pluggableSettings(), fieldMapping(b -> {
        // now change some parameters  
    }  
            "field",  
                b.field("type", "boolean");
        assertEquals(DocValuesType.SORTED_NUMERIC, fields[1].fieldType().docValuesType());  
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
    }
        }
            "field",  
            }
        });  
            mapping(b -> b.startObject("field").field("type", "boolean").field("null_value", true).endObject())  
            b.startObject("field2");
    protected void writeFieldValue(XContentBuilder builder) throws IOException {
    /** A mapping update that sets index:true on a new field is rejected on a pluggable data format index. */
import java.io.IOException;
 * specific language governing permissions and limitations
import org.apache.lucene.index.IndexWriter;
import java.util.Collection;  
        fields = doc.getFields("bool2");
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> {
        pluggableMapper.parse(source(sourceBuilder), docInput);
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)  
        if (expectedValue == null) {
        CapturingDocumentInput docInput = new CapturingDocumentInput();
import org.opensearch.plugins.Plugin;  
        MapperParsingException e = expectThrows(
        }));
        assertEquals(
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
                MapperParsingException.class,  
            b.field("index", true);
        MapperParsingException ex = expectThrows(MapperParsingException.class, () -> defaultMapper.parse(source(b -> {  
        CapturingDocumentInput capturingDocInput = new CapturingDocumentInput();
                .stream()
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)  
        }));
        merge(mapperService, mapping(b -> {  
     */  
    public void testPluggableDataFormatBooleanNullValueConfigured() throws IOException {
    private static Settings pluggableSettings() {
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> merge(mapperService, mapping(b -> {
            assertEquals(  
        DocumentMapper pluggableMapper = createDocumentMapper(pluggableSettings, mappingBuilder);  
        assertTrue(
        assertTrue(explicit.fieldType("field").isSearchable());  
 * KIND, either express or implied.  See the License for the
        MapperService mapperService = createMapperService(pluggableSettings(), fieldMapping(this::minimalMapping));  
        checker.registerConflictCheck("null_value", b -> b.field("null_value", true));
                iw.addDocument(createDocument(value, false));
        assertFalse(mapperService.fieldType("field").isSearchable());
    }  
 *
        assertEquals(2, fields.length);
        mapper.toXContent(builder, ToXContent.EMPTY_PARAMS);
 */
            assertNotNull(values);
    }  
import org.apache.lucene.index.DocValuesType;
    public void testPluggableDataFormatAcceptsExplicitIndexFalse() throws IOException {  
 * Modifications Copyright OpenSearch Contributors. See
            .put("index.pluggable.dataformat.enabled", true)  
        builder.endObject();  
                b.field("index", false);  
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
        DocumentMapper mapper = createDocumentMapper(settings, fieldMapping(this::minimalMapping));
        }
        return List.of(new MockDocValuesDataFormatPlugin());
        DocumentMapper defaultMapper = createDocumentMapper(mapping(b -> {
        assertFalse("existing field's value should be preserved across the update", mapperService.fieldType("field").isSearchable());
        IndexableField[] fields = doc.getFields("bool1");  
    }
            "failed to parse field [field] of type [boolean] in document with id '1'. " + "Preview of field's value: '{inner_field=no}'",
        MapperService mapperService = createMapperService(fieldMapping(b -> {
        }));  
    @Override  
 * Licensed to Elasticsearch under one or more contributor  
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {  
            BooleanFieldMapper.Values.FALSE
    protected Collection<? extends Plugin> getPlugins() {  
 * GitHub history for details.
        assertEquals(1, fields.length);
            BooleanFieldMapper mapper = getMapper(FieldMapper.CopyTo.empty(), false, true);
public class BooleanFieldMapperTests extends MapperTestCase {
                assertEquals("{\"" + FIELD_NAME + "\":" + true + "}", source);  
import org.opensearch.core.xcontent.XContentBuilder;  
import java.util.List;
     * {@code index} defaults to false and the field reports itself as not searchable — routing
            b.endObject();  
            b -> b.field("field", false),
        Mapper mapper = defaultMapper.mappers().getMapper("field");  
        char[] chars = value.toCharArray();  
        mapper.parse(source(b -> b.nullField("field")), capturingDocInput);
            }))
    public void testPluggableDataFormatMappingUpdateRejectsIndexTrue() throws IOException {  
    }
 */  
    public void testDerivedValueFetching_DocValues() throws IOException {
/*
        boolean val = Booleans.parseBoolean(chars, 0, chars.length, false);
        // Pluggable path
        CapturingDocumentInput capturingDocInput = new CapturingDocumentInput();
    private org.apache.lucene.document.Document createDocument(String value, boolean hasDocValues) {
        );
            fieldMapping(this::minimalMapping),
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        assertBooleanLuceneAndPluggablePathsEquivalent(
        checker.registerConflictCheck("index", b -> b.field("index", false));
            pluggableSettings,  
                .stream()
                b.field("index", true);  
            assertEquals(1, values.docValueCount());
        assertEquals(DocValuesType.SORTED_NUMERIC, fields[1].fieldType().docValuesType());  
/*  
    public void testPluggableDataFormatMappingUpdateDefaultsNewFieldToNotIndexed() throws IOException {
            b -> b.nullField("field"),
        builder = XContentFactory.jsonBuilder().startObject();
    protected void registerParameters(ParameterChecker checker) throws IOException {  
 * compatible open source license.
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        );
        Settings settings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
        fields = doc.getFields("bool3");
     * mapping is rejected rather than silently producing a field whose queries match nothing.
                .anyMatch(e -> e.getKey().name().equals("field") && Boolean.TRUE.equals(e.getValue()))
        assertEquals(  
            MapperParsingException ex = expectThrows(
        return doc;
        }));  
        }));
                builder.endObject();
        org.apache.lucene.document.Document doc = new org.apache.lucene.document.Document();
    }  
    }  
 *
package org.opensearch.index.mapper;
import org.opensearch.core.xcontent.ToXContent;
                b.field("inner_field", "no");  
    public void testPossibleToDeriveSource_WhenDocValuesAndStoredDisabled() throws IOException {  
    }
        MapperService mapperService = createMapperService(pluggableSettings(), fieldMapping(b -> {
        assertThrows(UnsupportedOperationException.class, mapper::canDeriveSource);
                mapper.deriveSource(builder, reader.leaves().get(0).reader(), 0);  
        assertThrows(UnsupportedOperationException.class, mapper::canDeriveSource);
        assertWarnings("Parameter [boost] on field [field] is deprecated and will be removed in 3.0");  
        }));  
        // Scenario 4: null_value configured — substitution kicks in
    }
import org.apache.lucene.util.BytesRef;
        return mapper;
     */  
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
import org.opensearch.common.CheckedConsumer;
            MapperParsingException.class,  
        MapperService mapperService = createMapperService(pluggableSettings(), fieldMapping(this::minimalMapping));
    ) throws IOException {
        assertEquals(DocValuesType.NONE, fields[0].fieldType().docValuesType());
            Boolean.FALSE
        mapper = defaultMapper.mappers().getMapper("field");  
    }
        DocumentMapper defaultMapper = createDocumentMapper(fieldMapping(this::minimalMapping));
        IllegalArgumentException e = expectThrows(
        // Lucene path  
        }));
                mapper.deriveSource(builder, reader.leaves().get(0).reader(), 0);  
            assertTrue(values.advanceExact(0));  
            b.field("doc_values", false);
            minimalMapping(b);
            );
    public void testDerivedValueFetching_StoredField() throws IOException {
    }
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
    }  
        } else {
        );
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
    public void testNonPluggableDataFormatKeepsIndexTrue() throws IOException {
        assertTrue(capturingDocInput.getCapturedFields().stream().noneMatch(e -> e.getKey().name().equals("field")));
            {
    /** An explicit {@code index: false} is accepted on a pluggable-dataformat index. */
        assertEquals(
    /**
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", false)));
    public void testPluggablePathEquivalenceWithLucenePath() throws IOException {
 *     http://www.apache.org/licenses/LICENSE-2.0
            b.field("bool2", true);
            String value = "";  // empty string means false under boolean field mapping
        FieldMapper.CopyTo copyTo = new FieldMapper.CopyTo.Builder().add("copy_to_field").build();  
import org.apache.lucene.document.SortedNumericDocValuesField;
            assertEquals(new BytesRef("T"), leaf.terms("field").iterator().next());  
            b.field("type", "boolean");  
        assertNotNull(doc.rootDoc().getField("field.as_string"));
            new BooleanFieldMapper.BooleanFieldType("bool").indexedValueForSearch(new BytesRef("true")),
        ParsedDocument doc = mapperService.documentMapper().parse(source(this::writeField));
        );
        try (Directory directory = newDirectory()) {  
            pluggableSettings,  
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        return Settings.builder()
                assertEquals("{\"" + FIELD_NAME + "\":" + false + "}", source);  
            pluggableSettings,  
            BooleanFieldMapper mapper = getMapper(FieldMapper.CopyTo.empty(), true, false);
        IndexableField[] luceneFields = luceneDoc.rootDoc().getFields(fieldName);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        mapper.parse(source(b -> b.nullField("field")), capturingDocInput);  
    /**
            ex.getMessage()  
                .anyMatch(e -> e.getKey().name().equals("field") && Boolean.FALSE.equals(e.getValue()))
        try (Directory directory = newDirectory()) {  
            mapping(b -> b.startObject("field").field("type", "boolean").field("null_value", true).endObject()),
        MapperService mapperService = createMapperService(pluggableSettings(), fieldMapping(this::minimalMapping));  
                builder.endObject();
    }
            assertTrue("Lucene path should produce field '" + fieldName + "'", luceneFields.length > 0);  
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
    }  
        mapper.copyTo = copyTo;
import org.apache.lucene.index.IndexableField;
                minimalMapping(b);
            b.field("bool3", true);
        assertEquals(new BooleanFieldMapper.BooleanFieldType("bool").indexedValueForSearch(false), BooleanFieldMapper.Values.FALSE);
        checker.registerConflictCheck("doc_values", b -> b.field("doc_values", false));
        MapperService mapperService = createMapperService(  
            IllegalArgumentException.class,
                String source = builder.toString();
            boolean pluggableHasField = docInput.getCapturedFields().stream().anyMatch(e -> e.getKey().name().equals(fieldName));  
        })));
            minimalMapping(b);  
            b.endObject();
    public void testPluggableDataFormatDefaultsIndexToFalse() throws IOException {
import org.apache.lucene.index.DirectoryReader;  
 * The OpenSearch Contributors require contributions made to  
        assertTrue(
        );
        assertFalse(mapperService.fieldType("field").isSearchable());
        Boolean expectedValue
        assertExistsQuery(mapperService);
        BooleanFieldMapper mapper = getMapper(copyTo, true, true);
        DocumentMapper luceneMapper = createDocumentMapper(mappingBuilder);
            }
        BooleanFieldMapper mapper = getMapper(FieldMapper.CopyTo.empty(), false, false);
    public void testSerialization() throws IOException {  
        Settings pluggableSettings,  
            fieldMapping(this::minimalMapping),
            SortedNumericDocValues values = leaf.getSortedNumericDocValues("field");
            b.field("index", true);
    }  
            {
     * queries to the doc-values column instead of an empty inverted index.
            null
            settings,
    }
        assertEquals(new BooleanFieldMapper.BooleanFieldType("bool").indexedValueForSearch(null), BooleanFieldMapper.Values.FALSE);  
        } else {
        assertFalse("newly added field should default to not-indexed", mapperService.fieldType("field2").isSearchable());  
            fieldMapping(this::minimalMapping),
    public void testMultiFields() throws IOException {
    private BooleanFieldMapper getMapper(FieldMapper.CopyTo copyTo, boolean hasDocValues, boolean isStored) throws IOException {
    public void testPossibleToDeriveSource_WhenCopyToPresent() throws IOException {
    }
    public void testPluggableDataFormatRejectsExplicitIndexTrue() {
        MapperService mapperService = createMapperService(fieldMapping(b -> {  
            "field",  
                String source = builder.toString();
        Document doc = parsedDoc.rootDoc();
        assertEquals(new BoostQuery(new TermQuery(new Term("field", "T")), 2.0f), ft.termQuery("true", null));
        mapper.parse(source(b -> b.field("field", false)), capturingDocInput);
        DocumentMapper mapper = createDocumentMapper(settings, fieldMapping(this::minimalMapping));
}
            b -> b.field("field", true),
    @Override
    }  
    @Override
            fieldMapping(b -> b.field("type", "boolean").field("store", isStored).field("doc_values", hasDocValues))
            minimalMapping(b);
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
    private static final String FIELD_NAME = "field";
            b.field("index", false);  
        );
            }
            Boolean.TRUE
            capturingDocInput.getCapturedFields()
        DocumentMapper mapper = createDocumentMapper(settings, fieldMapping(this::minimalMapping));
import org.apache.lucene.index.Term;
 * SPDX-License-Identifier: Apache-2.0
            assertFalse("Pluggable path should produce no field for '" + fieldName + "'", pluggableHasField);
            // boolean fields are indexed and have doc values by default
        MapperService mapperService = createMapperService(fieldMapping(this::minimalMapping));
     * On a pluggable-dataformat index the Lucene secondary writes no terms for boolean fields, so  
            .build();
            b.endObject();
        assertTrue(
                .anyMatch(e -> e.getKey().name().equals(fieldName) && expectedValue.equals(e.getValue()));  
                XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
        mapper.toXContent(builder, ToXContent.EMPTY_PARAMS);
import org.apache.lucene.search.BoostQuery;
    }  
                () -> defaultMapper.parse(source(b -> b.field("field", value)))
        assertThat(e.getMessage(), containsString("cannot cover: [FULL_TEXT_SEARCH]"));
        for (String value : new String[] { "off", "no", "0", "on", "yes", "1" }) {
            b.startObject("bool2");  
    }  
                "failed to parse field [field] of type [boolean] in document with id '1'. " + "Preview of field's value: '" + value + "'",
        );
        BooleanFieldMapper mapper = (BooleanFieldMapper) mapperService.documentMapper().mappers().getMapper(FIELD_NAME);  
            b.startObject("bool3");  
            () -> new BooleanFieldMapper.BooleanFieldType("bool").indexedValueForSearch(new BytesRef("random"))  
            b.startObject("fields");
        b.field("type", "boolean");
    }
    public void testExistsQueryDocValuesDisabled() throws IOException {
     * Helper method to create a document with both doc values and stored fields  
            doc.add(new SortedNumericDocValuesField(FIELD_NAME, val ? 1 : 0));
                .anyMatch(e -> e.getKey().name().equals("field") && Boolean.TRUE.equals(e.getValue()))
        assertThat(e.getMessage(), containsString("cannot cover: [FULL_TEXT_SEARCH]"));  
import org.apache.lucene.document.StoredField;
                .stream()  
            minimalMapping(b);
 */  
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
                b.startObject("as_string").field("type", "keyword").endObject();  
        // Scenario 2: false value
    /**
            b.startObject("field");
 * not use this file except in compliance with the License.
    public void testDocValues() throws Exception {
    }
            b -> b.nullField("field"),
            b.field("doc_values", false);  
        builder.endObject();  
    public void testDefaults() throws IOException {
            assertTrue("Pluggable path should capture field '" + fieldName + "' with value '" + expectedValue + "'", pluggableFound);
            b.startObject("field2");  
        }
        assertEquals(new BooleanFieldMapper.BooleanFieldType("bool").indexedValueForSearch(true), BooleanFieldMapper.Values.TRUE);
    protected void assertParseMaximalWarnings() {
    public void testPluggableDataFormatBooleanFalse() throws IOException {  
    public void testBoosts() throws Exception {  
import org.opensearch.common.xcontent.XContentFactory;
            boolean pluggableFound = docInput.getCapturedFields()
            }
        );  
            minimalMapping(b);
        // Scenario 3: null value — no field produced
    public void testPluggableDataFormatBooleanNullSkipped() throws IOException {  
        CapturingDocumentInput capturingDocInput = new CapturingDocumentInput();
    }  
            b.field("boost", 2.0);  
 * Unless required by applicable law or agreed to in writing,
        builder.value(true);
                b.field("type", "boolean");
        // omit "false"/"true" here as they should still be parsed correctly  
        DocumentMapper mapper = createDocumentMapper(
            try (DirectoryReader reader = DirectoryReader.open(directory)) {
import org.apache.lucene.index.LeafReader;
        assertEquals(DocValuesType.NONE, fields[0].fieldType().docValuesType());
        ParsedDocument parsedDoc = defaultMapper.parse(source(b -> {
        CheckedConsumer<XContentBuilder, IOException> sourceBuilder,
            minimalMapping(b);
        ParsedDocument luceneDoc = luceneMapper.parse(source(sourceBuilder));
        }));  
                iw.addDocument(createDocument(value, true));
import org.opensearch.common.settings.Settings;
        DocumentMapper defaultMapper = createDocumentMapper(fieldMapping(this::minimalMapping));
    /**  
        assertEquals("Can't parse boolean value [random], expected [true] or [false]", e.getMessage());  
            assertEquals("Lucene path should produce no field for '" + fieldName + "'", 0, luceneFields.length);
            pluggableSettings,  
    }  
        MapperService mapperService = createMapperService(fieldMapping(this::minimalMapping));  
            "field",  
        );
import org.apache.lucene.index.SortedNumericDocValues;  
            b.field("type", "boolean");
import org.opensearch.index.engine.dataformat.stub.MockDocValuesDataFormatPlugin;
    private void assertBooleanLuceneAndPluggablePathsEquivalent(
            String value = "true";
        checker.registerUpdateCheck(b -> b.field("boost", 2.0), m -> assertEquals(m.fieldType().boost(), 2.0, 0));
        }
        MappedFieldType ft = mapperService.fieldType("field");  
        assertParseMaximalWarnings();
        );
            capturingDocInput.getCapturedFields()
        Settings settings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
    }  
            b.field("null_value", true);
                .stream()  
    public void testPluggableDataFormatBooleanTrue() throws IOException {  
        assertTrue(mapperService.fieldType("field").isSearchable());  
        }
        assertBooleanLuceneAndPluggablePathsEquivalent(
     * An explicit {@code index: true} cannot be honoured on a pluggable-dataformat index, so the  
import org.opensearch.common.util.FeatureFlags;  
 *  
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
     * value of the already-mapped field unchanged.
                b.field("index", true);  
        );
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {  
    }
            );  
    @Override
        );
        assertBooleanLuceneAndPluggablePathsEquivalent(
            final LeafReader leaf = reader.leaves().get(0).reader();
     */
        assertParseMinimalWarnings();
    }  
    public void testParsesBooleansStrict() throws IOException {
        CapturingDocumentInput capturingDocInput = new CapturingDocumentInput();
        checker.registerConflictCheck("store", b -> b.field("store", true));  
            doc.add(new StoredField(FIELD_NAME, val ? "T" : "F"));  
        Settings settings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
        MapperService explicit = createMapperService(fieldMapping(b -> {
        );  
            Boolean.TRUE
            new BooleanFieldMapper.BooleanFieldType("bool").indexedValueForSearch(new BytesRef("false")),  
        assertEquals("{\"field\":{\"type\":\"boolean\",\"doc_values\":false,\"null_value\":true}}", builder.toString());
                XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
        withLuceneIndex(mapperService, iw -> iw.addDocument(doc.rootDoc()), reader -> {  
    }  
            {
        assertEquals("{\"field\":{\"type\":\"boolean\"}}", builder.toString());
    }
import org.apache.lucene.index.IndexWriterConfig;  
        }));
        );
            b.endObject();  
    }
import org.apache.lucene.store.Directory;
     * A field added by a later mapping update also defaults to not-indexed, and the update leaves the
        Settings settings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();  
            {
            }
 * under the License.  
        DocumentMapper defaultMapper = createDocumentMapper(fieldMapping(this::minimalMapping));
        if (hasDocValues) {  
    public void testParsesBooleansNestedStrict() throws IOException {
        XContentBuilder mappingBuilder,
     */
    public void testIndexedValueForSearch() throws Exception {
            }
            b.endObject();
    protected void minimalMapping(XContentBuilder b) throws IOException {  
            assertEquals(1, values.nextValue());
/*  
        assertFalse(mapperService.fieldType("field").isSearchable());
            BooleanFieldMapper.Values.TRUE
            b.field("bool1", true);  
import org.apache.lucene.search.TermQuery;  
        assertBooleanLuceneAndPluggablePathsEquivalent(
    }  
        String fieldName,  
            capturingDocInput.getCapturedFields()  
                ex.getMessage()
        })));  
