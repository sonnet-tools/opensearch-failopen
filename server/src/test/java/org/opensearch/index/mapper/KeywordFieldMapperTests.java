        ParsedDocument parsed = mapper.parse(source(b -> b.startArray("field").endArray()), docInput);  
        NamedAnalyzer normalizer = mapper.fieldType().normalizer();
            );  
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {  
            assertTrue("Pluggable path should capture field '" + fieldName + "' with value '" + expectedValue + "'", pluggableFound);
        assertEquals(2, fields.length);
 * The OpenSearch Contributors require contributions made to  
    }  
                "lowercase",
            pluggableSettings,
            .stream()
        CapturingDocumentInput docInput = new CapturingDocumentInput();
        assertEquals("boolean", ft.getTextSearchInfo().getSimilarity().name());
 * license agreements. See the NOTICE file distributed with
 */  
        assertEquals(new BytesRef("AbC"), fields[1].binaryValue());
        }));
        assertThrows(UnsupportedOperationException.class, mapper::canDeriveSource);  
        IndexableFieldType fieldType = fields[0].fieldType();  
                b.field("type", "keyword");
        DocumentMapper defaultMapper = createDocumentMapper(fieldMapping(this::minimalMapping));  
        String normalizerName,
    public void testParsesKeywordNestedListStrict() throws IOException {  
import org.apache.lucene.index.IndexOptions;
        return doc;  
                        new TokenFilterFactory[] { new TokenFilterFactory() {
            }
        CapturingDocumentInput docInput = new CapturingDocumentInput();  
        MapperService mapperService = createMapperService(  
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "keyword").field("doc_values", false)));  
                mapper.deriveSource(builder, reader.leaves().get(0).reader(), 0);  
    }  
        assertTrue(fieldMapper.getRawValueFieldType().isMultiValueSupported());
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();  
                MapperParsingException.class,
        fields = doc.rootDoc().getFields("field");
            b.field("type", "keyword");
        for (String value : new String[] { "", "AbC", " leading and trailing ", "multi\nline", randomUnicodeOfLength(between(1, 512)) }) {  
import org.opensearch.index.analysis.NamedAnalyzer;
        mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "keyword").field("null_value", "uri")));
import java.util.Arrays;  
        assertEquals(2, fields.length);
    }
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {  
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();  
    }  
        assertTrue("Expected keyword field captured with value 'test_value'", found);
        DocumentMapper luceneMapper = createDocumentMapper(mappingBuilder);  
        assertLuceneAndPluggablePathsEquivalent(
            singletonMap("default", new NamedAnalyzer("default", AnalyzerScope.INDEX, new StandardAnalyzer())),
        assertEquals(new BytesRef("AbC"), fields[0].binaryValue());
        assertThrows(UnsupportedOperationException.class, mapper::canDeriveSource);
        mapperService = createMapperService(mapping(b -> {  
            "field",
        b.field("type", "keyword");
            pluggableSettings,
        assertThat(mapperService.fieldType("field").boost(), equalTo(2f));
        assertThat(fieldType.storeTermVectorPositions(), equalTo(false));
            "failed to parse field [field] of type [keyword] in document with id '1'. "
        );
        boolean found = docInput.getCapturedFields()
                    "lowercase",  
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
        CapturingDocumentInput docInput = new CapturingDocumentInput();
                XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
        assertLuceneAndPluggablePathsEquivalent(
        checker.registerConflictCheck("doc_values", b -> b.field("doc_values", false));
        assertThat(fieldType.indexOptions(), equalTo(IndexOptions.DOCS));
        );
import org.opensearch.indices.analysis.AnalysisModule;
            pluggableSettings,
import org.opensearch.index.analysis.CharFilterFactory;
                        TokenizerFactory.newFactory("lowercase", WhitespaceTokenizer::new),  
        IndexableField[] fields = doc.rootDoc().getFields("field");
        assertArrayEquals(new String[] { "1234" }, TermVectorsService.getValues(doc.rootDoc().getFields("field")));  
        return new IndexAnalyzers(
            settings,
        assertEquals(1L, docInput.getFieldCount("field"));  
        DocumentMapper mapper = createDocumentMapper(
            mapping(b -> b.startObject("field").field("type", "keyword").endObject())
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.tests.analysis.MockLowerCaseFilter;
    }  
    public void testPossibleToDeriveSource_WhenDocValuesAndStoredDisabled() throws IOException {  
        // Pluggable path
    }  
        assertThat(fieldType.storeTermVectorPayloads(), equalTo(false));
        assertExistsQuery(mapperService);
        public Map<String, AnalysisModule.AnalysisProvider<TokenizerFactory>> getTokenizers() {  
        // Scenario 2: null value — no field produced  
            ft.getTextSearchInfo().getSearchAnalyzer().analyzer().tokenStream("", "Hello World"),  
        Mapper update = parsed.dynamicMappingsUpdate().root().getMapper("field");  
        assertTrue("Expected keyword field captured with null_value 'default_val'", found);
        CapturingDocumentInput docInput = new CapturingDocumentInput();
                b.field("normalizer", "lowercase");  
                }
            "failed to parse field [field] of type [keyword] in document with id '1'. " + "Preview of field's value: '{}'",
        boolean found = docInput.getCapturedFields()
            b.field("doc_values", false);
        MapperService mapperService = createMapperService(fieldMapping(b -> {  
        DocumentMapper mapper = createDocumentMapper(  
import org.opensearch.index.analysis.PreConfiguredTokenFilter;  
    }  
            mapping(b -> b.startObject("field").field("type", "keyword").endObject())  
                )  
        ft = (KeywordFieldMapper.KeywordFieldType) fieldType;
        fieldType = fields[1].fieldType();
            {
        );
        assertFalse("Expected no captured field for null value", hasField);  
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "keyword").field("index_options", "freqs")));
    protected IndexAnalyzers createIndexAnalyzers(IndexSettings indexSettings) {  
            b.field("norms", true);  
     * keyword scenarios (default, null_value, ignore_above, normalizer, multi-field).  
        CapturingDocumentInput docInput = new CapturingDocumentInput();
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
            pluggableSettings,
        KeywordFieldMapper mapper = getMapper(FieldMapper.CopyTo.empty(), 100, "default", true, false);  
                "keyword",
    public void testPluggableDataFormatDefaultKeyword() throws IOException {
        assertThat(update, instanceOf(KeywordFieldMapper.class));
        checker.registerUpdateCheck(b -> {
            b.endObject();  
                    name,
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "AbC")));  
     * Helper method to create a document with both doc values and stored fields  
        fieldType = fields[1].fieldType();  
        );  
        assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field"));  
        IndexableField[] fields = doc.rootDoc().getFields("field");  
            KeywordFieldMapper mapper = getMapper(FieldMapper.CopyTo.empty(), Integer.MAX_VALUE, "default", true, false);
        Settings settings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();  
        boolean found = docInput.getCapturedFields()
        DocumentMapper mapper = createDocumentMapper(pluggableSettings, mapping(b -> {
                    b.startArray("array_name").value("inner_field_first").value("inner_field_second").endArray();
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));  
        );
            () -> defaultMapper.parse(source(b -> b.startObject("field").endObject()))
        CapturingDocumentInput docInput = new CapturingDocumentInput();
import org.opensearch.index.analysis.AnalyzerScope;  
    }
    @Override  
            .stream()
        if (expectedValue == null) {  
        );
            b -> b.nullField("field"),
            ),
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "keyword").field("normalizer", "lowercase")));
    /**
        DocumentMapper mapper = createDocumentMapper(mapping);
            mapping(b -> b.startObject("field").field("type", "keyword").field("ignore_above", 5).endObject()),  
            assertTrue("Lucene path should produce field '" + fieldName + "'", luceneFields.length > 0);
        assertThat(ft.getTextSearchInfo().getSearchAnalyzer().name(), equalTo("lowercase"));
import org.opensearch.core.xcontent.XContentBuilder;
    }  
            // Lucene path should have produced the field with the expected value  
            String value = "keyword_value";
        assertNotNull(fieldMapper.getRawValueFieldType());
                (indexSettings, environment, name, settings) -> TokenizerFactory.newFactory(  
        XContentBuilder mappingBuilder,  
import static org.opensearch.index.mapper.KeywordFieldMapper.normalizeValue;
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        assertFalse(fields[0].fieldType().omitNorms());  
        return singletonList(new MockAnalysisPlugin());
        CapturingDocumentInput docInput = new CapturingDocumentInput();  
                b.field("split_queries_on_whitespace", false);  
        FieldType fieldType = new FieldType(KeywordFieldMapper.Defaults.FIELD_TYPE);
    private KeywordFieldMapper getMapper(
    public void testDefaultNormalizerSkipsTokenStream() throws IOException {
 * Licensed to Elasticsearch under one or more contributor  
            .stream()  
        checker.registerConflictCheck("index", b -> b.field("index", false));
        IndexableField[] fields = doc.rootDoc().getFields("field");
            b -> b.field("field", "AbC"),
    }
            pluggableSettings,
        merge(mapperService, fieldMapping(b -> b.field("type", "keyword").field("multi_value", true)));  
        assertThat(fieldType.storeTermVectorOffsets(), equalTo(false));  
        assertThat(update, instanceOf(KeywordFieldMapper.class));  
                    .field("ignore_above", ignoreAbove)  
            .anyMatch(e -> e.getKey().name().equals("field") && e.getValue().equals("abc"));
    }
        assertNotNull(parsed.dynamicMappingsUpdate());
    }
        @Override
        IndexableField[] fields = mapper.parse(source(b -> b.field("field", "AbC"))).rootDoc().getFields("field");
        KeywordFieldMapper mapper = (KeywordFieldMapper) mapperService.documentMapper().mappers().getMapper(FIELD_NAME);  
        IndexableField[] fields = doc.rootDoc().getFields("field");  
import org.opensearch.index.analysis.IndexAnalyzers;  
        assertNotNull(parsed.dynamicMappingsUpdate());
                            }  
    }
public class KeywordFieldMapperTests extends MapperTestCase {
        assertThat(fieldType.storeTermVectorOffsets(), equalTo(false));
        }
                        } }
        IndexableField[] fields = doc.rootDoc().getFields("field");
import org.opensearch.index.IndexSettings;
            pluggableSettings,
            mapping(b -> b.startObject("field").field("type", "keyword").endObject())
        MappedFieldType ft = mapperService.documentMapper().fieldTypes().get("field");  
                String source = builder.toString();
            mapping(b -> b.startObject("field").field("type", "keyword").field("null_value", "uri").endObject()),  
import org.opensearch.common.CheckedConsumer;
        DocumentMapper mapper = createDocumentMapper(
        DocumentMapper mapper = createDocumentMapper(
    }  
        DocumentMapper mapper = createDocumentMapper(mapping);  
        DocumentMapper mapper = createDocumentMapper(
            b.startObject("field_with_normalizer");
import org.apache.lucene.index.DirectoryReader;  
        assertEquals(2, fields.length);  
import org.apache.lucene.tests.analysis.MockTokenizer;  
            e.getMessage()
        assertEquals(0, fields.length);  
        IllegalArgumentException e = expectThrows(
        CapturingDocumentInput docInput = new CapturingDocumentInput();
    }  
        IndexableField[] fields = doc.rootDoc().getFields("field");
        FieldMapper.CopyTo copyTo = new FieldMapper.CopyTo.Builder().add("copy_to_field").build();  
            MapperParsingException e = expectThrows(  
        assertThat(fieldType.storeTermVectorPositions(), equalTo(false));
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();  
        // Scenario 1: default keyword  
    ) throws IOException {
    ) throws IOException {
        int ignoreAbove,
        );
 * not use this file except in compliance with the License.
        mapper.parse(source(b -> b.nullField("field")), docInput);
            b -> b.field("split_queries_on_whitespace", true),
        assertTrue("Expected keyword field captured with value 'elk' within ignore_above limit", found);
                            @Override
    }  
            mapping(b -> b.startObject("field").field("type", "keyword").endObject())  
            mapping(b -> b.startObject("field").field("type", "keyword").field("ignore_above", 5).endObject()),  
        ParsedDocument parsed = mapper.parse(source(b -> b.array("field", "one", "two")), docInput);
    }
                            }
            mapping(b -> b.startObject("field").field("type", "keyword").field("ignore_above", 5).endObject())  
     */
        // Scenario 6: normalizer  
    public void testPluggableDataFormatPromotesKeywordOnSecondValue() throws IOException {  
        MapperService mapperService = createMapperService(fieldMapping(b -> b.field("type", "keyword").field("boost", 2f)));  
        );  
            ft.getTextSearchInfo().getSearchAnalyzer().analyzer().tokenStream("", "Hello World"),  
            boolean pluggableFound = docInput.getCapturedFields()
            .anyMatch(e -> e.getKey().name().equals("text_field.kw") && e.getValue().equals("external_keyword"));  
            fieldMapping(
        mapper.parse(source(b -> b.field("text_field", "external_keyword")), docInput);
    }  
        public List<PreConfiguredTokenFilter> getPreConfiguredTokenFilters() {
    public void testNullValue() throws IOException {  
            singletonMap(  
        mapper.parse(source(b -> b.field("field", "opensearch")), docInput);  
        assertEquals(DocValuesType.SORTED_SET, fieldType.docValuesType());
        final BytesRef binaryValue = new BytesRef(value);  
        CapturingDocumentInput docInput = new CapturingDocumentInput();  
        );
    }
        assertThat(fieldType.omitNorms(), equalTo(true));
        ParsedDocument luceneDoc = luceneMapper.parse(source(sourceBuilder));
        }
import org.opensearch.common.xcontent.XContentFactory;  
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));  
                + "Preview of field's value: '{array_name=[inner_field_first, inner_field_second]}'",  
import org.opensearch.index.analysis.TokenFilterFactory;
            .anyMatch(e -> e.getKey().name().equals("field") && e.getValue().equals("elk"));  
        assertLuceneAndPluggablePathsEquivalent(
        } else {
    }
import org.apache.lucene.index.IndexableField;
import static org.apache.lucene.tests.analysis.BaseTokenStreamTestCase.assertTokenStreamContents;
            null  
 *
import org.apache.lucene.index.IndexWriter;  
 * specific language governing permissions and limitations
        assertEquals(IndexOptions.NONE, fields[0].fieldType().indexOptions());
        }));
        );
                .stream()  
    }
        MapperService mapperService = createMapperService(fieldMapping(b -> b.field("type", "keyword").field("normalizer", "lowercase")));  
            {  
        );
                b.field("normalizer", "lowercase");
        checker.registerConflictCheck("store", b -> b.field("store", true));  
            b -> b.field("field", "opensearch"),
import org.opensearch.index.termvectors.TermVectorsService;  
 * this work for additional information regarding copyright
import static java.util.Collections.singletonMap;  
                            @Override  
                .anyMatch(e -> e.getKey().name().equals(fieldName) && e.getValue().equals(expectedValue));
    private void assertLuceneAndPluggablePathsEquivalent(
        assertEquals(IndexOptions.DOCS_AND_FREQS, fields[0].fieldType().indexOptions());  
        }
 * this file be licensed under the Apache-2.0 license or a
    }
                {  
        KeywordFieldMapper fieldMapper = (KeywordFieldMapper) mapper.mappers().getMapper("field");
            doc.add(new SortedSetDocValuesField(FIELD_NAME, binaryValue));
import org.apache.lucene.util.BytesRef;
    public void testConfigureSimilarity() throws IOException {
            )
    }  
                    new CustomAnalyzer(
                containsString("Unknown value [" + indexOptions + "] for field [index_options] - accepted values are [docs, freqs]")  
    }  
            pluggableSettings,
        checker.registerUpdateCheck(  
        assertEquals(mapping.toString(), mapper.mappingSource().toString());  
        assertEquals(1, fields.length);  
                iw.addDocument(createDocument(mapper, value, true));
        Document doc = new Document();  
            new String[] { "hello", "world" }  
        ft = (KeywordFieldMapper.KeywordFieldType) fieldType;  
        assertEquals(DocValuesType.NONE, fieldType.docValuesType());
        assertEquals(  
            minimalMapping(b);
    private Document createDocument(KeywordFieldMapper mapper, String value, boolean hasDocValues) throws IOException {
     *
        checker.registerUpdateCheck(b -> b.field("multi_value", true), m -> assertTrue(m.fieldType().isMultiValued()));
        fieldType = mapperService.fieldType("field");
        assertThat(fieldType.omitNorms(), equalTo(true));
                    )
        IndexableFieldType fieldType = fields[0].fieldType();
import org.apache.lucene.analysis.TokenStream;
        assertThat(fieldType, instanceOf(KeywordFieldMapper.KeywordFieldType.class));
        checker.registerConflictCheck("similarity", b -> b.field("similarity", "boolean"));  
                new NamedAnalyzer("other_lowercase", AnalyzerScope.INDEX, new LowercaseNormalizer())
                + "\tCannot update parameter [normalizer] from [lowercase] to [other_lowercase]",
                b.field("split_queries_on_whitespace", true);
    public void testNormalizer() throws IOException {
                                return "lowercase";  
    /**
     */
    public void testPluggableDataFormatIgnoreAboveWithinLimit() throws IOException {
 * GitHub history for details.
        assertEquals(new BytesRef("1234"), fields[1].binaryValue());  
    public void testDisableIndex() throws IOException {
        boolean hasDocValues,  
        String expectedValue  
                        new CharFilterFactory[0],
        checker.registerConflictCheck("norms", b -> b.field("norms", true));  
        IndexableField[] fieldNamesFields = doc.rootDoc().getFields(FieldNamesFieldMapper.NAME);
    }
        assertNull(parsed.dynamicMappingsUpdate());
        // norms can be set from true to false, but not vice versa
            ex.getMessage()
        fieldType = mapperService.fieldType("field_with_normalizer");  
        assertTokenStreamContents(
        boolean isStored
            b.endObject();
        assertWarnings("Parameter [boost] on field [field] is deprecated and will be removed in 3.0");  
    protected Collection<? extends Plugin> getPlugins() {
        checker.registerUpdateCheck(b -> b.field("boost", 2.0), m -> assertEquals(m.fieldType().boost(), 2.0, 0));  
            pluggableSettings,  
            KeywordFieldMapper mapper = getMapper(FieldMapper.CopyTo.empty(), Integer.MAX_VALUE, "default", false, true);
    public void testPossibleToDeriveSource_WhenNormalizerPresent() throws IOException {
import org.opensearch.common.settings.Settings;
    }  
            b.startObject("fields");
    }
        boolean found = docInput.getCapturedFields()
        DocumentMapper defaultMapper = createDocumentMapper(fieldMapping(this::minimalMapping));
import org.apache.lucene.index.DocValuesType;
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));
        IndexableField[] fields = doc.rootDoc().getFields("field");
        assertEquals(DocValuesType.NONE, fields[0].fieldType().docValuesType());
        builder.value("value");
        assertThrows(UnsupportedOperationException.class, mapper::canDeriveSource);
            .stream()
        pluggableMapper.parse(source(sourceBuilder), docInput);
        assertThat(fieldType, instanceOf(KeywordFieldMapper.KeywordFieldType.class));
                assertEquals("{\"" + FIELD_NAME + "\":" + "\"" + value + "\"" + "}", source);  
            .stream()
        assertThat(fieldType, instanceOf(KeywordFieldMapper.KeywordFieldType.class));
        mapper.parse(source(b -> b.field("field", "test_value")), docInput);
import static java.util.Collections.singletonList;
    public void testIndexOptions() throws IOException {
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
            b.endArray();
            () -> merge(mapperService, fieldMapping(b -> b.field("type", "keyword").field("similarity", "BM25")))
import org.apache.lucene.document.Document;  
        for (String indexOptions : Arrays.asList("positions", "offsets")) {
            pluggableSettings,
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));
 * compatible open source license.
        );
import org.apache.lucene.document.SortedSetDocValuesField;
 * KIND, either express or implied.  See the License for the
        XContentBuilder mapping = fieldMapping(this::minimalMapping);
        assertTokenStreamContents(
        assertEquals(1, fields.length);
        boolean hasField = docInput.getCapturedFields().stream().anyMatch(e -> e.getKey().name().equals("field"));
import org.apache.lucene.index.IndexableFieldType;  
    public final void testExistsQueryDocValuesDisabledWithNorms() throws IOException {
 * software distributed under the License is distributed on an
        assertFalse("Expected no captured field when value exceeds ignore_above", hasField);  
 */  
        assertTrue(mapperService.fieldType("field").isMultiValued());
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)  
            "1234"  
        // used by TermVectorsService
        assertEquals(new BytesRef("1234"), fields[0].binaryValue());
            b.startObject("text_field");  
            mapping(b -> b.startObject("field").field("type", "keyword").field("normalizer", "lowercase").endObject())  
            "Mapper for [field] conflicts with existing mapper:\n"  
        );
    public void testPossibleToDeriveSource_WhenIgnoreAbovePresent() throws IOException {
        IndexableField[] fields = doc.rootDoc().getFields("field");
            "field",
        DocumentMapper mapper = createDocumentMapper(  
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "keyword").field("store", true)));
        );  
        CheckedConsumer<XContentBuilder, IOException> sourceBuilder,
                new NamedAnalyzer(
                b -> b.field("type", "keyword")
    public void testSplitQueriesOnWhitespace() throws IOException {  
                "other_lowercase",  
        assertEquals(2, fields.length);
            .anyMatch(e -> e.getKey().name().equals("field") && e.getValue().equals("test_value"));  
            assertThat(
            doc.add(new KeywordFieldMapper.KeywordField(FIELD_NAME, binaryValue, fieldType));
            () -> defaultMapper.parse(source(b -> b.startObject("field").nullField("field_name").endObject()))  
    }  
import org.opensearch.plugins.Plugin;  
        assertEquals(2, fields.length);
            b -> b.nullField("field"),
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
 * under the License.  
            )
    public void testPossibleToDeriveSource_WhenCopyToPresent() throws IOException {
import org.apache.lucene.analysis.Analyzer;
    }
        assertEquals(2L, docInput.getFieldCount("field"));  
import org.opensearch.index.analysis.TokenizerFactory;
                "lowercase",
        boolean found = docInput.getCapturedFields()
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        @Override  
            IllegalArgumentException.class,
            pluggableSettings,  
        String fieldName,
    public static class MockAnalysisPlugin extends Plugin implements AnalysisPlugin {
        MapperService mapperService = createMapperService(fieldMapping(b -> b.field("type", "keyword").field("similarity", "boolean")));
        );
        DocumentMapper mapper = createDocumentMapper(  
/*  
    }
        MapperService mapperService = createMapperService(mapping(b -> {
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
     * @param expectedValue the expected value, or null if no field should be produced
        );  
        );
            b.startObject("field").field("type", "keyword").endObject();
        assertParseMinimalWarnings();  
            mapping(b -> b.startObject("field").field("type", "keyword").endObject()),  
        DocumentMapper mapper = createDocumentMapper(
        assertEquals(
 *     http://www.apache.org/licenses/LICENSE-2.0
            mapping(b -> b.startObject("field").field("type", "keyword").field("null_value", "default_val").endObject())
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
        mapper.parse(source(b -> b.field("field", "AbC")), docInput);  
        if (hasDocValues) {
        );
        );  
     * Creates a copy of the lowercase token filter which we use for testing merge errors.  
    public void testDerivedValueFetching_DocValues() throws IOException {
                    () -> new MockTokenizer(MockTokenizer.KEYWORD, false)
        assertEquals(DocValuesType.NONE, fieldType.docValuesType());  
        CapturingDocumentInput docInput = new CapturingDocumentInput();
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        assertEquals(
        }  
        return mapper;
        MapperParsingException ex = expectThrows(
        CapturingDocumentInput docInput = new CapturingDocumentInput();
    }
            }
 * the Apache License, Version 2.0 (the "License"); you may
     */  
package org.opensearch.index.mapper;
        assertEquals(new BytesRef("uri"), fields[0].binaryValue());  
    }
            assertEquals("Lucene path should produce no field for '" + fieldName + "'", 0, luceneFields.length);
            () -> merge(mapperService, fieldMapping(b -> b.field("type", "keyword").field("normalizer", "other_lowercase")))  
        fieldType.setIndexOptions(IndexOptions.DOCS_AND_FREQS);  
                mapper.deriveSource(builder, reader.leaves().get(0).reader(), 0);  
            if (randomBoolean()) {  
        }));  
            );
            b.endObject();
        // Scenario 4: ignore_above — value exceeds limit, no field produced  
 * SPDX-License-Identifier: Apache-2.0
        value = normalizeValue(normalizer, FIELD_NAME, value);
            ft.getTextSearchInfo().getSearchAnalyzer().analyzer().tokenStream("", "Hello World"),
        );
        );
            () -> merge(mapperService, fieldMapping(b -> b.field("type", "keyword").field("multi_value", false)))
    public void testMultiValueCanPromoteButCannotDowngrade() throws IOException {  
import org.apache.lucene.analysis.standard.StandardAnalyzer;
/*
    protected void registerParameters(ParameterChecker checker) throws IOException {  
            assertEquals(new BytesRef(expectedValue), luceneFields[0].binaryValue());
        assertFalse(fieldType.stored());  
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "elk")));  
        );
    public void testPluggablePathEquivalenceWithLucenePath() throws IOException {  
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "keyword").field("index", false)));  
        assertEquals(1, fields.length);  
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
    public void testDisableDocValues() throws IOException {
            String value = "keyword_value";
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)  
        assertEquals(DocValuesType.SORTED_SET, fields[0].fieldType().docValuesType());
            mapping(b -> b.startObject("field").field("type", "keyword").endObject()),  
    private static final String FIELD_NAME = "field";  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                e.getMessage(),
        MapperService mapperService = createMapperService(fieldMapping(b -> {  
     * Cross-path equivalence test: verifies that the pluggable DocumentInput path
        mapper.parse(source(b -> b.field("field", "elk")), docInput);
            IllegalArgumentException.class,
    public void testPluggableDataFormatSingletonArrayRemainsScalar() throws IOException {  
            {
            b -> b.field("field", "elk"),
    protected void writeFieldValue(XContentBuilder builder) throws IOException {
        assertEquals(new BytesRef("abc"), fields[0].binaryValue());
                XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "keyword").field("ignore_above", 5)));
            }
    public void testParsesKeywordNestedEmptyObjectStrict() throws IOException {
                b.startObject();
        assertThat(error.getMessage(), containsString("Cannot update parameter [multi_value] from [true] to [false]"));
    public void testRawSourceCompanionSupportsDynamicPromotion() throws IOException {
        assertLuceneAndPluggablePathsEquivalent(
        assertThat(fieldType.storeTermVectors(), equalTo(false));
        assertEquals(0, fieldNamesFields.length);  
                iw.addDocument(createDocument(mapper, value, false));
            // Both paths should produce no field
        checker.registerConflictCheck("normalizer", b -> b.field("normalizer", "lowercase"));
        assertFalse(fieldType.tokenized());  
            "elk"  
        assertThat(fieldType.indexOptions(), equalTo(IndexOptions.NONE));
        } else {  
        // Scenario 5: ignore_above — value within limit  
        XContentBuilder mapping = fieldMapping(this::minimalMapping);
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));
        assertTokenStreamContents(
import org.apache.lucene.analysis.core.LowerCaseFilter;  
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "keyword")));
            .anyMatch(e -> e.getKey().name().equals("field") && e.getValue().equals("default_val"));  
            Map.of(  
    }
    public void testPluggableDataFormatNullValueSkipped() throws IOException {
            "abc"  
                    .field("store", isStored)  
        assertTokenStreamContents(a.tokenStream("", "Hello World"), new String[] { "Hello World" });
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
        }
    }
        Mapper update = parsed.dynamicMappingsUpdate().root().getMapper("field");
        doc = mapper.parse(source(b -> b.nullField("field")));  
            "failed to parse field [field] of type [keyword] in document with id '1'. " + "Preview of field's value: '{field_name=null}'",  
        IndexableField[] fields = doc.rootDoc().getFields("field");
    }
import org.opensearch.index.analysis.LowercaseNormalizer;
    }
import java.io.IOException;
        );
        fields = doc.rootDoc().getFields("field");
        assertParseMinimalWarnings();
    @Override
    }
        assertTrue("Expected keyword field captured with normalized value 'abc'", found);
        try (Directory directory = newDirectory()) {  
            b.startObject("field").field("type", "keyword").field("split_queries_on_whitespace", true).endObject();
            }
            }
    }  
    /**
 *
        assertThat(e.getMessage(), containsString("Cannot update parameter [similarity] from [boolean] to [BM25]"));
        assertFalse(fieldType.stored());
        );
        );
        assertEquals(new BytesRef("1234"), fields[0].binaryValue());  
        assertExistsQuery(mapperService);
                b.field("type", "keyword");
        DocumentMapper mapper = createDocumentMapper(  
 * You may obtain a copy of the License at  
    }
        MappedFieldType fieldType = mapperService.fieldType("field");  
            mapping(b -> b.startObject("field").field("type", "keyword").field("normalizer", "lowercase").endObject())  
    /**  
        }
                    AnalyzerScope.INDEX,
        assertEquals(2, fields.length);
    public void testPluggableDataFormatEmptyArrayPromotesKeyword() throws IOException {
        );
        fieldType = mapperService.fieldType("field_with_normalizer");
            );
     */
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();  
    public void testParsesKeywordNullStrict() throws IOException {
    public void testPluggableDataFormatWithExternalValue() throws IOException {  
    }  
import org.opensearch.index.analysis.CustomAnalyzer;
            b.endObject();
            b.field("doc_values", false);
        IndexableField[] fields = doc.rootDoc().getFields("field");  
        assertEquals(2, fields.length);  
        }, b -> {
            fieldMapping(b -> b.field("type", "keyword").field("doc_values", false).field("norms", true))
            pluggableSettings,
        );
            "field",
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
    protected void minimalMapping(XContentBuilder b) throws IOException {  
        mapper.parse(source(b -> b.nullField("field")), docInput);  
        }  
            b -> b.field("field", "1234"),
            }
        checker.registerConflictCheck("index_options", b -> b.field("index_options", "freqs"));
    }  
            try (DirectoryReader reader = DirectoryReader.open(directory)) {
            "field",
            assertSame(value, normalizeValue(Lucene.KEYWORD_ANALYZER, FIELD_NAME, value));
            "uri"  
    public void testUpdateNormalizer() throws IOException {
        assertEquals(
            m -> assertEquals("_whitespace", m.fieldType().getTextSearchInfo().getSearchAnalyzer().name())
        );
import java.util.Collection;
            pluggableSettings,
    }  
            b.startArray("field");  
        // Scenario 3: null_value configured — substitution kicks in  
            try (DirectoryReader reader = DirectoryReader.open(directory)) {
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        assertLuceneAndPluggablePathsEquivalent(
        doc = mapper.parse(source(b -> b.field("field", "opensearch")));
 */
            mapping(b -> b.startObject("field").field("type", "keyword").field("ignore_above", 5).endObject())
    public void testPluggableDataFormatWithNormalizer() throws IOException {
            IllegalArgumentException.class,
    public final void testExistsQueryDocValuesDisabled() throws IOException {
        }));  
        assertFalse(fieldType.tokenized());
import org.apache.lucene.document.FieldType;
        assertEquals(DocValuesType.SORTED_SET, fieldType.docValuesType());  
            b.startObject("kw").field("type", "keyword").endObject();  
    }
        Settings pluggableSettings,
        })));  
            MapperParsingException.class,  
        ft = (KeywordFieldMapper.KeywordFieldType) fieldType;
            e.getMessage()
        );
                b.endObject();  
        }));  
import org.apache.lucene.index.IndexWriterConfig;
            b.field("type", "keyword");
        assertThat(fieldType.indexOptions(), equalTo(IndexOptions.NONE));
        assertTrue(((KeywordFieldMapper) update).fieldType().isMultiValued());
                            public String name() {
/*  
        assertEquals(0, fields.length);
        assertEquals(new BytesRef("1234"), fields[1].binaryValue());  
    }
    }  
            new String[] { "Hello", "World" }
            null  
 * ownership. Elasticsearch licenses this file to you under  
                    .field("normalizer", normalizerName)
 * Modifications Copyright OpenSearch Contributors. See
            new String[] { "hello world" }
        Exception e = expectThrows(
    protected void assertParseMaximalWarnings() {
        assertLuceneAndPluggablePathsEquivalent(
        }
                builder.endObject();
    }
    public void testPluggableDataFormatNullValueConfigured() throws IOException {
    public void testIgnoreAbove() throws IOException {  
        );  
        checker.registerConflictCheck("null_value", b -> b.field("null_value", "foo"));
    }  
        assertThat(fieldType.storeTermVectorPayloads(), equalTo(false));  
                    .field("doc_values", hasDocValues)
                            public TokenStream create(TokenStream tokenStream) {
                String source = builder.toString();
        MapperParsingException ex = expectThrows(MapperParsingException.class, () -> defaultMapper.parse(source(b -> {
        ParsedDocument doc = mapper.parse(source(b -> b.nullField("field")));
        DocumentMapper pluggableMapper = createDocumentMapper(pluggableSettings, mappingBuilder);
        Analyzer a = ft.getTextSearchInfo().getSearchAnalyzer();  
        IllegalArgumentException e = expectThrows(  
            b.field("norms", false);  
import static org.hamcrest.Matchers.containsString;
        assertThat(fieldType.indexOptions(), equalTo(IndexOptions.DOCS));
        IndexableField[] luceneFields = luceneDoc.rootDoc().getFields(fieldName);
            pluggableSettings,
    public void testPluggableDataFormatIgnoreAbove() throws IOException {
        KeywordFieldMapper mapper = getMapper(FieldMapper.CopyTo.empty(), Integer.MAX_VALUE, "default", false, false);
            b.field("norms", true);  
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
                assertEquals("{\"" + FIELD_NAME + "\":" + "\"" + value + "\"" + "}", source);  
        assertEquals(2, fields.length);
        assertTrue("Expected keyword sub-field captured with external value 'external_keyword'", found);
        assertWarnings("Parameter [boost] on field [field] is deprecated and will be removed in 3.0");
        fieldType.setStored(!hasDocValues);
    public void testEnableNorms() throws IOException {
        // Lucene path (default, no pluggable setting)
    public void testBoost() throws IOException {
        DocumentMapper defaultMapper = createDocumentMapper(fieldMapping(this::minimalMapping));  
        DocumentMapper mapper = createDocumentMapper(
import static org.hamcrest.Matchers.instanceOf;
        KeywordFieldMapper.KeywordFieldType ft = (KeywordFieldMapper.KeywordFieldType) fieldType;
            pluggableSettings,
                builder.endObject();
        assertTrue(((KeywordFieldMapper) update).fieldType().isMultiValued());
        );  
            "field",
                () -> createMapperService(fieldMapping(b -> b.field("type", "keyword").field("index_options", indexOptions)))
        );  
        try (Directory directory = newDirectory()) {  
            assertFalse("Pluggable path should produce no field for '" + fieldName + "'", pluggableHasField);
        ParsedDocument parsed = mapper.parse(source(b -> b.array("field", "one")), docInput);
    public void testDefaults() throws Exception {  
        FieldMapper.CopyTo copyTo,  
            MapperParsingException.class,
        IllegalArgumentException error = expectThrows(  
        assertThat(fieldType.storeTermVectors(), equalTo(false));  
    }
import org.opensearch.plugins.AnalysisPlugin;
        DocumentMapper mapper = createDocumentMapper(
import org.opensearch.common.lucene.Lucene;  
import java.util.Map;  
    @Override
            b.field("type", "text");
     * then asserts they agree on the produced field value (or absence thereof).  
        }, m -> assertFalse(m.fieldType().getTextSearchInfo().hasNorms()));
            b.startObject("field_with_normalizer");  
        assertThat(ft.getTextSearchInfo().getSearchAnalyzer().name(), equalTo("lowercase"));  
            return singletonList(PreConfiguredTokenFilter.singleton("mock_other_lowercase", true, MockLowerCaseFilter::new));
            minimalMapping(b);
            // Pluggable path should capture the same value
                )  
    public void testDefaultsDoNotUseDocumentInput() throws Exception {
        checker.registerUpdateCheck(b -> b.field("ignore_above", 256), m -> assertEquals(256, ((KeywordFieldMapper) m).ignoreAbove()));
            "field",
            mapping(b -> b.startObject("field").field("type", "keyword").endObject())
import org.opensearch.common.util.FeatureFlags;
        MapperService mapperService = createMapperService(fieldMapping(b -> b.field("type", "keyword")));
        assertThrows(UnsupportedOperationException.class, mapper::canDeriveSource);
        mapper.copyTo = copyTo;
            return singletonMap(
                b.field("norms", false);
            ex.getMessage()
import static org.hamcrest.Matchers.equalTo;  
import org.apache.lucene.store.Directory;
            pluggableSettings,
        KeywordFieldMapper mapper = getMapper(copyTo, Integer.MAX_VALUE, "default", true, false);
    @Override
            }
        doc = mapper.parse(source(b -> {}));  
                new NamedAnalyzer("lowercase", AnalyzerScope.INDEX, new LowercaseNormalizer()),
        assertThat(fieldType, instanceOf(KeywordFieldMapper.KeywordFieldType.class));  
     * Parses the same source through both the Lucene path and the pluggable DocumentInput path,
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
     * captures the same field values as the Lucene Document path for all common
            boolean pluggableHasField = docInput.getCapturedFields().stream().anyMatch(e -> e.getKey().name().equals(fieldName));  
    }
    public void testEnableStore() throws IOException {  
}
        boolean hasField = docInput.getCapturedFields().stream().anyMatch(e -> e.getKey().name().equals("field"));
            mapping(b -> b.startObject("field").field("type", "keyword").field("normalizer", "lowercase").endObject()),  
        assertTrue(fields[0].fieldType().stored());
            }
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));
                                return new LowerCaseFilter(tokenStream);
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
    @Override  
        KeywordFieldMapper mapper = getMapper(FieldMapper.CopyTo.empty(), 100, "lowercase", true, false);
import java.util.List;
 *  
        assertEquals(new BytesRef("abc"), fields[1].binaryValue());
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)  
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        checker.registerUpdateCheck(b -> b.field("eager_global_ordinals", true), m -> assertTrue(m.fieldType().eagerGlobalOrdinals()));
    public void testDerivedValueFetching_StoredField() throws IOException {
