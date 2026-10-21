        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
        assertEquals(DocValuesType.SORTED_SET, fields[0].fieldType().docValuesType());
    public void testNullValue() throws IOException {
 * compatible open source license.
                "lowercase",
            doc.add(new KeywordFieldMapper.KeywordField(FIELD_NAME, binaryValue, fieldType));
import org.opensearch.common.settings.Settings;
            b -> b.nullField("field"),
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
        assertThat(fieldType, instanceOf(KeywordFieldMapper.KeywordFieldType.class));
        fields = doc.rootDoc().getFields("field");
                    .field("normalizer", normalizerName)
    public void testIndexOptions() throws IOException {
        assertThat(fieldType.indexOptions(), equalTo(IndexOptions.NONE));
            // Pluggable path should capture the same value
        );
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));
import org.opensearch.index.analysis.NamedAnalyzer;
            mapping(b -> b.startObject("field").field("type", "keyword").endObject())
        mapper.copyTo = copyTo;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        fieldType = fields[1].fieldType();
        assertThat(fieldType.storeTermVectorPositions(), equalTo(false));
        assertNotNull(parsed.dynamicMappingsUpdate());
        assertTrue(((KeywordFieldMapper) update).fieldType().isMultiValued());
            assertTrue("Pluggable path should capture field '" + fieldName + "' with value '" + expectedValue + "'", pluggableFound);
        // norms can be set from true to false, but not vice versa
            {
            "uri"
        assertLuceneAndPluggablePathsEquivalent(
        ParsedDocument doc = mapper.parse(source(b -> b.nullField("field")));
        String fieldName,
import org.opensearch.index.IndexSettings;
                            public String name() {
            return singletonMap(
        b.field("type", "keyword");
        } else {
        assertThat(fieldType.storeTermVectorOffsets(), equalTo(false));
    }
            }
                builder.endObject();
        IllegalArgumentException e = expectThrows(
        DocumentMapper mapper = createDocumentMapper(mapping);
        CapturingDocumentInput docInput = new CapturingDocumentInput();
        }));
        );
            "field",
    }
        );
        }));
        assertEquals(IndexOptions.DOCS_AND_FREQS, fields[0].fieldType().indexOptions());
            settings,
        IndexableField[] fields = doc.rootDoc().getFields("field");
        // Scenario 4: ignore_above — value exceeds limit, no field produced
    }
    }
                new NamedAnalyzer("lowercase", AnalyzerScope.INDEX, new LowercaseNormalizer()),
        DocumentMapper defaultMapper = createDocumentMapper(fieldMapping(this::minimalMapping));
     *
            new String[] { "hello world" }
    }
        assertLuceneAndPluggablePathsEquivalent(
    }
                MapperParsingException.class,
        IndexableField[] fields = doc.rootDoc().getFields("field");
        // Scenario 6: normalizer
            () -> merge(mapperService, fieldMapping(b -> b.field("type", "keyword").field("multi_value", false)))
    public void testConfigureSimilarity() throws IOException {
                {
    }
    }
        return mapper;
    public void testPluggableDataFormatPromotesKeywordOnSecondValue() throws IOException {
            doc.add(new SortedSetDocValuesField(FIELD_NAME, binaryValue));
            pluggableSettings,
 */
 * specific language governing permissions and limitations
            mapping(b -> b.startObject("field").field("type", "keyword").field("ignore_above", 5).endObject()),
    /**
        IllegalArgumentException error = expectThrows(
    }
            pluggableSettings,
    ) throws IOException {
        checker.registerConflictCheck("store", b -> b.field("store", true));
            pluggableSettings,
            "failed to parse field [field] of type [keyword] in document with id '1'. "
        checker.registerUpdateCheck(b -> {
                b.field("split_queries_on_whitespace", false);
        );
            mapping(b -> b.startObject("field").field("type", "keyword").endObject())
        return new IndexAnalyzers(
        IllegalArgumentException e = expectThrows(
            b.field("type", "keyword");
            b.field("type", "text");
import org.apache.lucene.analysis.core.LowerCaseFilter;
        assertThat(update, instanceOf(KeywordFieldMapper.class));
                )
        MappedFieldType ft = mapperService.documentMapper().fieldTypes().get("field");
                String source = builder.toString();
            mapping(b -> b.startObject("field").field("type", "keyword").field("ignore_above", 5).endObject())
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "keyword").field("index_options", "freqs")));
        public Map<String, AnalysisModule.AnalysisProvider<TokenizerFactory>> getTokenizers() {
        MapperService mapperService = createMapperService(
            ),
    protected void minimalMapping(XContentBuilder b) throws IOException {
            .stream()
        );
        assertEquals(new BytesRef("1234"), fields[1].binaryValue());
            pluggableSettings,
 * SPDX-License-Identifier: Apache-2.0
        assertThat(fieldType.omitNorms(), equalTo(true));
    }
import static org.hamcrest.Matchers.equalTo;
        Mapper update = parsed.dynamicMappingsUpdate().root().getMapper("field");
     * Cross-path equivalence test: verifies that the pluggable DocumentInput path
    protected IndexAnalyzers createIndexAnalyzers(IndexSettings indexSettings) {
        assertParseMinimalWarnings();
    }
        assertFalse(fields[0].fieldType().omitNorms());
 */
        assertNotNull(parsed.dynamicMappingsUpdate());
            }
        NamedAnalyzer normalizer = mapper.fieldType().normalizer();
    }
    public void testPluggableDataFormatEmptyArrayPromotesKeyword() throws IOException {
                new NamedAnalyzer("other_lowercase", AnalyzerScope.INDEX, new LowercaseNormalizer())
        boolean isStored
        );
        boolean found = docInput.getCapturedFields()
        assertEquals(
        checker.registerUpdateCheck(b -> b.field("ignore_above", 256), m -> assertEquals(256, ((KeywordFieldMapper) m).ignoreAbove()));
        );
                (indexSettings, environment, name, settings) -> TokenizerFactory.newFactory(
 * You may obtain a copy of the License at
        fields = doc.rootDoc().getFields("field");
            // Both paths should produce no field
            "elk"
        );
            "failed to parse field [field] of type [keyword] in document with id '1'. " + "Preview of field's value: '{field_name=null}'",
        public List<PreConfiguredTokenFilter> getPreConfiguredTokenFilters() {
    public void testDisableDocValues() throws IOException {
        }
        assertThat(fieldType, instanceOf(KeywordFieldMapper.KeywordFieldType.class));
        Analyzer a = ft.getTextSearchInfo().getSearchAnalyzer();
    public void testParsesKeywordNullStrict() throws IOException {
            }
    }
            assertThat(
        KeywordFieldMapper mapper = getMapper(FieldMapper.CopyTo.empty(), 100, "lowercase", true, false);
            b.endObject();
            pluggableSettings,
        assertThat(ft.getTextSearchInfo().getSearchAnalyzer().name(), equalTo("lowercase"));
        assertTrue(((KeywordFieldMapper) update).fieldType().isMultiValued());
        assertThat(error.getMessage(), containsString("Cannot update parameter [multi_value] from [true] to [false]"));
 * the Apache License, Version 2.0 (the "License"); you may
        );
            mapping(b -> b.startObject("field").field("type", "keyword").field("normalizer", "lowercase").endObject())
            }
        }
        mapper.parse(source(b -> b.field("field", "elk")), docInput);
            }
            ft.getTextSearchInfo().getSearchAnalyzer().analyzer().tokenStream("", "Hello World"),
import org.opensearch.index.termvectors.TermVectorsService;
            try (DirectoryReader reader = DirectoryReader.open(directory)) {
import org.apache.lucene.analysis.Analyzer;
    private static final String FIELD_NAME = "field";
        DocumentMapper mapper = createDocumentMapper(
        KeywordFieldMapper fieldMapper = (KeywordFieldMapper) mapper.mappers().getMapper("field");
import org.apache.lucene.util.BytesRef;
        assertTrue(fieldMapper.getRawValueFieldType().isMultiValueSupported());
    }
                iw.addDocument(createDocument(mapper, value, true));
        assertEquals(1, fields.length);
 *
        assertEquals(2, fields.length);
    @Override
            // Lucene path should have produced the field with the expected value
        assertThat(ft.getTextSearchInfo().getSearchAnalyzer().name(), equalTo("lowercase"));
                                return new LowerCaseFilter(tokenStream);
        DocumentMapper mapper = createDocumentMapper(
        })));
        assertThrows(UnsupportedOperationException.class, mapper::canDeriveSource);
                iw.addDocument(createDocument(mapper, value, false));
        boolean hasDocValues,
        XContentBuilder mapping = fieldMapping(this::minimalMapping);
        DocumentMapper defaultMapper = createDocumentMapper(fieldMapping(this::minimalMapping));
            "field",
            b.startObject("text_field");
    }
    }
    public void testPossibleToDeriveSource_WhenIgnoreAbovePresent() throws IOException {
        assertThat(e.getMessage(), containsString("Cannot update parameter [similarity] from [boolean] to [BM25]"));
            .stream()
            b.startObject("field").field("type", "keyword").field("split_queries_on_whitespace", true).endObject();
            b.endObject();
    }
            b.startObject("kw").field("type", "keyword").endObject();
        assertEquals(IndexOptions.NONE, fields[0].fieldType().indexOptions());
                        } }
        XContentBuilder mapping = fieldMapping(this::minimalMapping);
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "keyword").field("doc_values", false)));
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "keyword").field("ignore_above", 5)));
        );
        assertThat(fieldType.storeTermVectorPayloads(), equalTo(false));
    }
            .anyMatch(e -> e.getKey().name().equals("field") && e.getValue().equals("abc"));
    public void testDerivedValueFetching_DocValues() throws IOException {
        );
            b.startObject("fields");
    public void testPossibleToDeriveSource_WhenNormalizerPresent() throws IOException {
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        checker.registerConflictCheck("similarity", b -> b.field("similarity", "boolean"));
 * GitHub history for details.
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "keyword").field("store", true)));
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
    }
        // Scenario 2: null value — no field produced
        IndexableField[] fields = mapper.parse(source(b -> b.field("field", "AbC"))).rootDoc().getFields("field");
            "Mapper for [field] conflicts with existing mapper:\n"
            assertTrue("Lucene path should produce field '" + fieldName + "'", luceneFields.length > 0);
        assertTrue("Expected keyword field captured with null_value 'default_val'", found);
            b.endArray();
        assertThat(fieldType, instanceOf(KeywordFieldMapper.KeywordFieldType.class));
        }
            b.field("norms", true);
 * Licensed to Elasticsearch under one or more contributor
            pluggableSettings,
        mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "keyword").field("null_value", "uri")));
        pluggableMapper.parse(source(sourceBuilder), docInput);
        Mapper update = parsed.dynamicMappingsUpdate().root().getMapper("field");
        assertFalse(fieldType.stored());
                b.field("normalizer", "lowercase");
    }
            assertFalse("Pluggable path should produce no field for '" + fieldName + "'", pluggableHasField);
        FieldMapper.CopyTo copyTo,
            boolean pluggableFound = docInput.getCapturedFields()
        CapturingDocumentInput docInput = new CapturingDocumentInput();
        assertEquals(0, fields.length);
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
import org.opensearch.common.CheckedConsumer;
        assertNull(parsed.dynamicMappingsUpdate());
            .stream()
    }
                b.startObject();
        assertEquals(mapping.toString(), mapper.mappingSource().toString());
    public void testDefaultsDoNotUseDocumentInput() throws Exception {
import org.opensearch.index.analysis.LowercaseNormalizer;
import org.apache.lucene.index.IndexableField;
            mapping(b -> b.startObject("field").field("type", "keyword").field("ignore_above", 5).endObject()),
                    .field("doc_values", hasDocValues)
    /**
        MapperService mapperService = createMapperService(fieldMapping(b -> b.field("type", "keyword").field("boost", 2f)));
        IndexableFieldType fieldType = fields[0].fieldType();
import org.apache.lucene.document.SortedSetDocValuesField;
            minimalMapping(b);
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        assertEquals("boolean", ft.getTextSearchInfo().getSimilarity().name());
    public void testBoost() throws IOException {
            .anyMatch(e -> e.getKey().name().equals("field") && e.getValue().equals("test_value"));
            pluggableSettings,
            "field",
                            }
    public void testNormalizer() throws IOException {
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
    }
        CapturingDocumentInput docInput = new CapturingDocumentInput();
    private void assertLuceneAndPluggablePathsEquivalent(
            b -> b.field("split_queries_on_whitespace", true),
        IndexableFieldType fieldType = fields[0].fieldType();
        ft = (KeywordFieldMapper.KeywordFieldType) fieldType;
        );
        assertEquals(DocValuesType.NONE, fieldType.docValuesType());
    }
            pluggableSettings,
import java.util.Map;
    public void testDerivedValueFetching_StoredField() throws IOException {
        assertThat(fieldType.storeTermVectorPositions(), equalTo(false));
        assertTrue(mapperService.fieldType("field").isMultiValued());
        CapturingDocumentInput docInput = new CapturingDocumentInput();
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
 * this file be licensed under the Apache-2.0 license or a
        CapturingDocumentInput docInput = new CapturingDocumentInput();
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        }
            if (randomBoolean()) {
 *
        DocumentMapper mapper = createDocumentMapper(
 * license agreements. See the NOTICE file distributed with
import static java.util.Collections.singletonList;
        );
        assertTrue(fields[0].fieldType().stored());
            )
                    name,
        final BytesRef binaryValue = new BytesRef(value);
        );
        assertEquals(new BytesRef("AbC"), fields[1].binaryValue());
                () -> createMapperService(fieldMapping(b -> b.field("type", "keyword").field("index_options", indexOptions)))
import static java.util.Collections.singletonMap;
                mapper.deriveSource(builder, reader.leaves().get(0).reader(), 0);
        assertEquals(new BytesRef("1234"), fields[0].binaryValue());
        fieldType = mapperService.fieldType("field_with_normalizer");
            )
                            @Override
            m -> assertEquals("_whitespace", m.fieldType().getTextSearchInfo().getSearchAnalyzer().name())
        CapturingDocumentInput docInput = new CapturingDocumentInput();
import static org.hamcrest.Matchers.containsString;
            pluggableSettings,
        CapturingDocumentInput docInput = new CapturingDocumentInput();
        try (Directory directory = newDirectory()) {
    public void testPluggableDataFormatIgnoreAbove() throws IOException {
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));
        DocumentMapper mapper = createDocumentMapper(
        assertExistsQuery(mapperService);
        assertFalse("Expected no captured field when value exceeds ignore_above", hasField);
        );
        assertTokenStreamContents(
        mapper.parse(source(b -> b.field("field", "opensearch")), docInput);
        MapperService mapperService = createMapperService(mapping(b -> {
        IndexableField[] fields = doc.rootDoc().getFields("field");
 */
        @Override
        fieldType = mapperService.fieldType("field");
        );
        assertEquals(new BytesRef("1234"), fields[1].binaryValue());
     * keyword scenarios (default, null_value, ignore_above, normalizer, multi-field).
        // used by TermVectorsService
        IndexableField[] fieldNamesFields = doc.rootDoc().getFields(FieldNamesFieldMapper.NAME);
import org.apache.lucene.tests.analysis.MockLowerCaseFilter;
        );
        assertEquals(2, fields.length);
        Document doc = new Document();
import org.apache.lucene.document.Document;
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
import org.apache.lucene.analysis.standard.StandardAnalyzer;
     * captures the same field values as the Lucene Document path for all common
    }
            assertSame(value, normalizeValue(Lucene.KEYWORD_ANALYZER, FIELD_NAME, value));
        DocumentMapper mapper = createDocumentMapper(
        );
        Settings pluggableSettings,
                "lowercase",
import org.opensearch.plugins.Plugin;
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "AbC")));
        assertThat(fieldType, instanceOf(KeywordFieldMapper.KeywordFieldType.class));
import org.opensearch.common.xcontent.XContentFactory;
        ParsedDocument luceneDoc = luceneMapper.parse(source(sourceBuilder));
    public void testDefaults() throws Exception {
    public void testIgnoreAbove() throws IOException {
            () -> defaultMapper.parse(source(b -> b.startObject("field").endObject()))
        ft = (KeywordFieldMapper.KeywordFieldType) fieldType;
                + "\tCannot update parameter [normalizer] from [lowercase] to [other_lowercase]",
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));
        boolean found = docInput.getCapturedFields()
                XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
    }
 * KIND, either express or implied.  See the License for the
        assertThat(mapperService.fieldType("field").boost(), equalTo(2f));
        assertEquals(2, fields.length);
            mapping(b -> b.startObject("field").field("type", "keyword").field("normalizer", "lowercase").endObject()),
            .anyMatch(e -> e.getKey().name().equals("field") && e.getValue().equals("elk"));
        CheckedConsumer<XContentBuilder, IOException> sourceBuilder,
                    () -> new MockTokenizer(MockTokenizer.KEYWORD, false)
 * software distributed under the License is distributed on an
                .stream()
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
        fieldType.setIndexOptions(IndexOptions.DOCS_AND_FREQS);
    @Override
            mapping(b -> b.startObject("field").field("type", "keyword").field("null_value", "uri").endObject()),
        assertEquals(2, fields.length);
        IndexableField[] fields = doc.rootDoc().getFields("field");
                    b.startArray("array_name").value("inner_field_first").value("inner_field_second").endArray();
        KeywordFieldMapper mapper = getMapper(FieldMapper.CopyTo.empty(), Integer.MAX_VALUE, "default", false, false);
            String value = "keyword_value";
        assertTokenStreamContents(
import org.opensearch.indices.analysis.AnalysisModule;
            {
            .anyMatch(e -> e.getKey().name().equals("text_field.kw") && e.getValue().equals("external_keyword"));
        assertEquals(new BytesRef("abc"), fields[1].binaryValue());
        IndexableField[] fields = doc.rootDoc().getFields("field");
        MapperService mapperService = createMapperService(fieldMapping(b -> b.field("type", "keyword").field("normalizer", "lowercase")));
            mapping(b -> b.startObject("field").field("type", "keyword").endObject())
    }
            "abc"
    public void testDefaultNormalizerSkipsTokenStream() throws IOException {
        CapturingDocumentInput docInput = new CapturingDocumentInput();
            b.startObject("field_with_normalizer");
    @Override
            assertEquals(new BytesRef(expectedValue), luceneFields[0].binaryValue());
 *
    public void testRawSourceCompanionSupportsDynamicPromotion() throws IOException {
        DocumentMapper mapper = createDocumentMapper(
        assertThat(fieldType.storeTermVectorOffsets(), equalTo(false));
import org.apache.lucene.index.IndexWriter;
        }));
            fieldMapping(
            );
        XContentBuilder mappingBuilder,
        assertThat(fieldType.indexOptions(), equalTo(IndexOptions.DOCS));
                + "Preview of field's value: '{array_name=[inner_field_first, inner_field_second]}'",
     */
 *     http://www.apache.org/licenses/LICENSE-2.0
            mapping(b -> b.startObject("field").field("type", "keyword").endObject()),
    public void testPluggableDataFormatDefaultKeyword() throws IOException {
        assertEquals(
        assertThat(fieldType.storeTermVectors(), equalTo(false));
     */
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        try (Directory directory = newDirectory()) {
import static org.opensearch.index.mapper.KeywordFieldMapper.normalizeValue;
        assertThrows(UnsupportedOperationException.class, mapper::canDeriveSource);
            pluggableSettings,
        assertEquals(
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
    protected void registerParameters(ParameterChecker checker) throws IOException {
        }, m -> assertFalse(m.fieldType().getTextSearchInfo().hasNorms()));
        checker.registerUpdateCheck(b -> b.field("boost", 2.0), m -> assertEquals(m.fieldType().boost(), 2.0, 0));
                b.endObject();
                builder.endObject();
        assertFalse(fieldType.stored());
        );
import java.util.Arrays;
        );
                new NamedAnalyzer(
                e.getMessage(),
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));
            "field",
    protected Collection<? extends Plugin> getPlugins() {
        checker.registerConflictCheck("normalizer", b -> b.field("normalizer", "lowercase"));
            mapping(b -> b.startObject("field").field("type", "keyword").endObject())
            try (DirectoryReader reader = DirectoryReader.open(directory)) {
            MapperParsingException e = expectThrows(
        assertEquals(new BytesRef("AbC"), fields[0].binaryValue());
            () -> merge(mapperService, fieldMapping(b -> b.field("type", "keyword").field("similarity", "BM25")))
        merge(mapperService, fieldMapping(b -> b.field("type", "keyword").field("multi_value", true)));
import static org.apache.lucene.tests.analysis.BaseTokenStreamTestCase.assertTokenStreamContents;
        assertTrue("Expected keyword field captured with normalized value 'abc'", found);
    }
    private KeywordFieldMapper getMapper(
        IndexableField[] fields = doc.rootDoc().getFields("field");
                    "lowercase",
            pluggableSettings,
     * Creates a copy of the lowercase token filter which we use for testing merge errors.
        checker.registerConflictCheck("doc_values", b -> b.field("doc_values", false));
        assertLuceneAndPluggablePathsEquivalent(
        DocumentMapper luceneMapper = createDocumentMapper(mappingBuilder);
        DocumentMapper mapper = createDocumentMapper(pluggableSettings, mapping(b -> {
    protected void writeFieldValue(XContentBuilder builder) throws IOException {
            pluggableSettings,
    public void testMultiValueCanPromoteButCannotDowngrade() throws IOException {
                "keyword",
            "1234"
            () -> merge(mapperService, fieldMapping(b -> b.field("type", "keyword").field("normalizer", "other_lowercase")))
            pluggableSettings,
                        new TokenFilterFactory[] { new TokenFilterFactory() {
            KeywordFieldMapper mapper = getMapper(FieldMapper.CopyTo.empty(), Integer.MAX_VALUE, "default", false, true);
    /**
    @Override
        }
        assertEquals(2, fields.length);
            pluggableSettings,
            boolean pluggableHasField = docInput.getCapturedFields().stream().anyMatch(e -> e.getKey().name().equals(fieldName));
            }
            IllegalArgumentException.class,
    }
    public static class MockAnalysisPlugin extends Plugin implements AnalysisPlugin {
        assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field"));
        fieldType.setStored(!hasDocValues);
    public void testPluggableDataFormatIgnoreAboveWithinLimit() throws IOException {
        assertThat(fieldType.storeTermVectorPayloads(), equalTo(false));
        int ignoreAbove,
        Settings settings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
     * then asserts they agree on the produced field value (or absence thereof).
        mapperService = createMapperService(mapping(b -> {
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        doc = mapper.parse(source(b -> b.field("field", "opensearch")));
    }
import java.io.IOException;
        KeywordFieldMapper mapper = getMapper(copyTo, Integer.MAX_VALUE, "default", true, false);
        MapperParsingException ex = expectThrows(
        checker.registerUpdateCheck(b -> b.field("eager_global_ordinals", true), m -> assertTrue(m.fieldType().eagerGlobalOrdinals()));
        } else {
        assertEquals(new BytesRef("1234"), fields[0].binaryValue());
        // Scenario 5: ignore_above — value within limit
                b.field("type", "keyword");
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
            b.field("norms", true);
            assertEquals("Lucene path should produce no field for '" + fieldName + "'", 0, luceneFields.length);
}
        IndexableField[] fields = doc.rootDoc().getFields("field");
            ft.getTextSearchInfo().getSearchAnalyzer().analyzer().tokenStream("", "Hello World"),
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to
    public void testDisableIndex() throws IOException {
        CapturingDocumentInput docInput = new CapturingDocumentInput();
        assertEquals(DocValuesType.NONE, fieldType.docValuesType());
        }, b -> {
        mapper.parse(source(b -> b.field("field", "test_value")), docInput);
                    .field("ignore_above", ignoreAbove)
    }
        );
            .stream()
        assertNotNull(fieldMapper.getRawValueFieldType());
        FieldMapper.CopyTo copyTo = new FieldMapper.CopyTo.Builder().add("copy_to_field").build();
            .stream()
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "keyword").field("index", false)));
                    .field("store", isStored)
/*
        );
                        TokenizerFactory.newFactory("lowercase", WhitespaceTokenizer::new),
/*
    }
            MapperParsingException.class,
        );
     */
                XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
        CapturingDocumentInput docInput = new CapturingDocumentInput();
            "field",
        assertLuceneAndPluggablePathsEquivalent(
        MapperService mapperService = createMapperService(fieldMapping(b -> {
        ParsedDocument parsed = mapper.parse(source(b -> b.startArray("field").endArray()), docInput);
        String expectedValue
        IndexableField[] fields = doc.rootDoc().getFields("field");
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
                    new CustomAnalyzer(
        ft = (KeywordFieldMapper.KeywordFieldType) fieldType;
import org.apache.lucene.index.IndexableFieldType;
        assertFalse("Expected no captured field for null value", hasField);
        DocumentMapper mapper = createDocumentMapper(
    public void testPluggableDataFormatSingletonArrayRemainsScalar() throws IOException {
            singletonMap(
        }));
        assertThat(fieldType.omitNorms(), equalTo(true));
            b -> b.nullField("field"),
import java.util.List;
        assertEquals(2, fields.length);
            "field",
            b -> b.field("field", "opensearch"),
        IndexableField[] fields = doc.rootDoc().getFields("field");
        fieldType = mapperService.fieldType("field_with_normalizer");
        DocumentMapper mapper = createDocumentMapper(
            e.getMessage()
            () -> defaultMapper.parse(source(b -> b.startObject("field").nullField("field_name").endObject()))
        }
        mapper.parse(source(b -> b.field("text_field", "external_keyword")), docInput);
        boolean found = docInput.getCapturedFields()
     * Parses the same source through both the Lucene path and the pluggable DocumentInput path,
        checker.registerUpdateCheck(b -> b.field("multi_value", true), m -> assertTrue(m.fieldType().isMultiValued()));
                            }
import org.apache.lucene.index.IndexOptions;
            minimalMapping(b);
        );
        checker.registerConflictCheck("norms", b -> b.field("norms", true));
    }
        // Scenario 3: null_value configured — substitution kicks in
        return singletonList(new MockAnalysisPlugin());
    public void testPluggableDataFormatNullValueConfigured() throws IOException {
        // Lucene path (default, no pluggable setting)
        assertWarnings("Parameter [boost] on field [field] is deprecated and will be removed in 3.0");
            MapperParsingException.class,
        DocumentMapper mapper = createDocumentMapper(mapping);
                assertEquals("{\"" + FIELD_NAME + "\":" + "\"" + value + "\"" + "}", source);
import org.opensearch.common.lucene.Lucene;
        IndexableField[] luceneFields = luceneDoc.rootDoc().getFields(fieldName);
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "keyword").field("normalizer", "lowercase")));
        checker.registerConflictCheck("index_options", b -> b.field("index_options", "freqs"));
    public final void testExistsQueryDocValuesDisabled() throws IOException {
        assertEquals(2, fields.length);
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
import org.apache.lucene.index.DirectoryReader;
        }
        checker.registerConflictCheck("index", b -> b.field("index", false));
        assertLuceneAndPluggablePathsEquivalent(
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
import org.apache.lucene.document.FieldType;
        assertEquals(0, fieldNamesFields.length);
 * ownership. Elasticsearch licenses this file to you under
        assertEquals(0, fields.length);
            ex.getMessage()
    }
            );
import org.opensearch.index.analysis.IndexAnalyzers;
    private Document createDocument(KeywordFieldMapper mapper, String value, boolean hasDocValues) throws IOException {
import org.apache.lucene.analysis.TokenStream;
        );
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
    }
public class KeywordFieldMapperTests extends MapperTestCase {
    }
        DocumentMapper mapper = createDocumentMapper(
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
import org.opensearch.plugins.AnalysisPlugin;
        MapperService mapperService = createMapperService(fieldMapping(b -> {
        KeywordFieldMapper mapper = (KeywordFieldMapper) mapperService.documentMapper().mappers().getMapper(FIELD_NAME);
        boolean found = docInput.getCapturedFields()
        assertEquals(1, fields.length);
        MapperService mapperService = createMapperService(fieldMapping(b -> b.field("type", "keyword").field("similarity", "boolean")));
        MapperParsingException ex = expectThrows(MapperParsingException.class, () -> defaultMapper.parse(source(b -> {
                    )
                b.field("norms", false);
            .anyMatch(e -> e.getKey().name().equals("field") && e.getValue().equals("default_val"));
            b.field("doc_values", false);
     * Helper method to create a document with both doc values and stored fields
        );
        MapperService mapperService = createMapperService(fieldMapping(b -> b.field("type", "keyword")));
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
        IndexableField[] fields = doc.rootDoc().getFields("field");
        assertThrows(UnsupportedOperationException.class, mapper::canDeriveSource);
        }
        if (expectedValue == null) {
        // Scenario 1: default keyword
        assertFalse(fieldType.tokenized());
        DocumentMapper defaultMapper = createDocumentMapper(fieldMapping(this::minimalMapping));
import org.apache.lucene.tests.analysis.MockTokenizer;
import org.opensearch.core.xcontent.XContentBuilder;
        assertEquals(2, fields.length);
import org.opensearch.index.analysis.CustomAnalyzer;
                .anyMatch(e -> e.getKey().name().equals(fieldName) && e.getValue().equals(expectedValue));
        KeywordFieldMapper.KeywordFieldType ft = (KeywordFieldMapper.KeywordFieldType) fieldType;
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
            mapping(b -> b.startObject("field").field("type", "keyword").field("ignore_above", 5).endObject())
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
    public void testParsesKeywordNestedListStrict() throws IOException {
                }
        assertTrue("Expected keyword field captured with value 'test_value'", found);
        assertEquals(2L, docInput.getFieldCount("field"));
        DocumentMapper pluggableMapper = createDocumentMapper(pluggableSettings, mappingBuilder);
        assertThrows(UnsupportedOperationException.class, mapper::canDeriveSource);
            );
    }
    public void testPluggableDataFormatWithNormalizer() throws IOException {
            b.startArray("field");
        assertThat(update, instanceOf(KeywordFieldMapper.class));
    }
import java.util.Collection;
    }
                "other_lowercase",
    }
            pluggableSettings,
        );
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "elk")));
    }
        doc = mapper.parse(source(b -> {}));
        checker.registerConflictCheck("null_value", b -> b.field("null_value", "foo"));
        assertParseMinimalWarnings();
    protected void assertParseMaximalWarnings() {
            mapping(b -> b.startObject("field").field("type", "keyword").field("normalizer", "lowercase").endObject())
        for (String indexOptions : Arrays.asList("positions", "offsets")) {
    @Override
    public void testPluggableDataFormatWithExternalValue() throws IOException {
        assertEquals(
            ex.getMessage()
            b.startObject("field").field("type", "keyword").endObject();
        @Override
            e.getMessage()
                    AnalyzerScope.INDEX,
        mapper.parse(source(b -> b.nullField("field")), docInput);
        }));
        CapturingDocumentInput docInput = new CapturingDocumentInput();
 * not use this file except in compliance with the License.
                containsString("Unknown value [" + indexOptions + "] for field [index_options] - accepted values are [docs, freqs]")
package org.opensearch.index.mapper;
        assertEquals(new BytesRef("uri"), fields[0].binaryValue());
        DocumentMapper mapper = createDocumentMapper(
     */
        assertLuceneAndPluggablePathsEquivalent(
        ParsedDocument parsed = mapper.parse(source(b -> b.array("field", "one")), docInput);
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));
        // Pluggable path
        assertEquals(DocValuesType.SORTED_SET, fieldType.docValuesType());
            mapping(b -> b.startObject("field").field("type", "keyword").endObject())
        assertExistsQuery(mapperService);
            b.endObject();
    public void testParsesKeywordNestedEmptyObjectStrict() throws IOException {
    public final void testExistsQueryDocValuesDisabledWithNorms() throws IOException {
            b.endObject();
            b.field("type", "keyword");
        builder.value("value");
            KeywordFieldMapper mapper = getMapper(FieldMapper.CopyTo.empty(), Integer.MAX_VALUE, "default", true, false);
        Exception e = expectThrows(
        boolean hasField = docInput.getCapturedFields().stream().anyMatch(e -> e.getKey().name().equals("field"));
    public void testPluggableDataFormatNullValueSkipped() throws IOException {
                b -> b.field("type", "keyword")
        assertEquals(1L, docInput.getFieldCount("field"));
            b -> b.field("field", "elk"),
        assertFalse(fieldType.tokenized());
        assertThat(fieldType.indexOptions(), equalTo(IndexOptions.NONE));
                b.field("type", "keyword");
    }
            null
        assertTrue("Expected keyword sub-field captured with external value 'external_keyword'", found);
    }
import org.opensearch.index.analysis.CharFilterFactory;
        );
        assertThat(fieldType.indexOptions(), equalTo(IndexOptions.DOCS));
                mapper.deriveSource(builder, reader.leaves().get(0).reader(), 0);
    ) throws IOException {
        FieldType fieldType = new FieldType(KeywordFieldMapper.Defaults.FIELD_TYPE);
            b -> b.field("field", "1234"),
    public void testPluggablePathEquivalenceWithLucenePath() throws IOException {
        if (hasDocValues) {
        assertThat(fieldType.storeTermVectors(), equalTo(false));
import org.apache.lucene.store.Directory;
    }
            new String[] { "hello", "world" }
        doc = mapper.parse(source(b -> b.nullField("field")));
    }
        );
            {
     * @param expectedValue the expected value, or null if no field should be produced
    public void testPossibleToDeriveSource_WhenDocValuesAndStoredDisabled() throws IOException {
                b.field("normalizer", "lowercase");
    }
                        new CharFilterFactory[0],
        checker.registerUpdateCheck(
            IllegalArgumentException.class,
                )
        );
                b.field("split_queries_on_whitespace", true);
    }
                            @Override
    }
            return singletonList(PreConfiguredTokenFilter.singleton("mock_other_lowercase", true, MockLowerCaseFilter::new));
            b.startObject("field_with_normalizer");
                String source = builder.toString();
        );
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));
            Map.of(
 * under the License.
            "failed to parse field [field] of type [keyword] in document with id '1'. " + "Preview of field's value: '{}'",
 * this work for additional information regarding copyright
            singletonMap("default", new NamedAnalyzer("default", AnalyzerScope.INDEX, new StandardAnalyzer())),
import org.opensearch.index.analysis.TokenFilterFactory;
            fieldMapping(b -> b.field("type", "keyword").field("doc_values", false).field("norms", true))
    public void testSplitQueriesOnWhitespace() throws IOException {
        boolean found = docInput.getCapturedFields()
        mapper.parse(source(b -> b.field("field", "AbC")), docInput);
        );
        for (String value : new String[] { "", "AbC", " leading and trailing ", "multi\nline", randomUnicodeOfLength(between(1, 512)) }) {
import org.apache.lucene.index.DocValuesType;
        return doc;
        assertEquals(DocValuesType.SORTED_SET, fieldType.docValuesType());
        DocumentMapper mapper = createDocumentMapper(
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
import org.opensearch.index.analysis.PreConfiguredTokenFilter;
        boolean hasField = docInput.getCapturedFields().stream().anyMatch(e -> e.getKey().name().equals("field"));
    public void testEnableStore() throws IOException {
        assertArrayEquals(new String[] { "1234" }, TermVectorsService.getValues(doc.rootDoc().getFields("field")));
                            public TokenStream create(TokenStream tokenStream) {
/*
        ParsedDocument parsed = mapper.parse(source(b -> b.array("field", "one", "two")), docInput);
    public void testUpdateNormalizer() throws IOException {
            mapping(b -> b.startObject("field").field("type", "keyword").endObject()),
            new String[] { "Hello", "World" }
        String normalizerName,
            }
            b.field("doc_values", false);
        MappedFieldType fieldType = mapperService.fieldType("field");
            IllegalArgumentException.class,
        KeywordFieldMapper mapper = getMapper(FieldMapper.CopyTo.empty(), 100, "default", true, false);
import org.opensearch.index.analysis.AnalyzerScope;
        fieldType = fields[1].fieldType();
            }
import org.opensearch.common.util.FeatureFlags;
            null
    public void testPossibleToDeriveSource_WhenCopyToPresent() throws IOException {
import org.apache.lucene.index.IndexWriterConfig;
            b.field("norms", false);
        assertEquals(1, fields.length);
        mapper.parse(source(b -> b.nullField("field")), docInput);
    }
        assertEquals(DocValuesType.NONE, fields[0].fieldType().docValuesType());
                assertEquals("{\"" + FIELD_NAME + "\":" + "\"" + value + "\"" + "}", source);
    public void testEnableNorms() throws IOException {
    /**
        value = normalizeValue(normalizer, FIELD_NAME, value);
            mapping(b -> b.startObject("field").field("type", "keyword").field("null_value", "default_val").endObject())
            b -> b.field("field", "AbC"),
import static org.hamcrest.Matchers.instanceOf;
            String value = "keyword_value";
        assertTokenStreamContents(
        assertTrue("Expected keyword field captured with value 'elk' within ignore_above limit", found);
 * Modifications Copyright OpenSearch Contributors. See
        assertWarnings("Parameter [boost] on field [field] is deprecated and will be removed in 3.0");
    }
                                return "lowercase";
import org.opensearch.index.analysis.TokenizerFactory;
        assertTokenStreamContents(a.tokenStream("", "Hello World"), new String[] { "Hello World" });
            ft.getTextSearchInfo().getSearchAnalyzer().analyzer().tokenStream("", "Hello World"),
        assertEquals(new BytesRef("abc"), fields[0].binaryValue());
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "keyword")));
