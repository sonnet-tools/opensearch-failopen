                throw new UnsupportedOperationException();
            matchQuery.setAnalyzer(new MockSynonymAnalyzer());
    public void testNestedMultiFieldTextNotStoredForDerivedSource() throws IOException {
    }
            }
import java.util.Map;
    }
    }
                .field("type", textFieldName)
                    public TokenStream create(TokenStream tokenStream) {
/*
import org.opensearch.index.analysis.TokenFilterFactory;
        {
        );
            () -> {
        String serialized = Strings.toString(MediaTypeRegistry.JSON, mapper);
        return mapper;
            {
        NamedAnalyzer keyword = new NamedAnalyzer("keyword", AnalyzerScope.INDEX, new KeywordAnalyzer());
            // as multi-fields are never used for derived-source reconstruction
        {
                .field("min_chars", "3")
        mapper.parse(source(b -> b.field("text_field", "external_text")), docInput);
            () -> createMapperService(fieldMapping(b -> b.field("type", textFieldName).field("index", false).field("fielddata", true)))
                        .startObject("index_prefixes")
            }));
 */
            PostingsEnum postings = terms.postings(null, PostingsEnum.POSITIONS);
            if (m.name().endsWith("._index_prefix")) {
    public String textFieldName = "text";
    }
        TextFieldMapper subB = (TextFieldMapper) mapperService.documentMapper().mappers().getMapper("parent.subB");
    public void testPositionIncrementGap() throws IOException {
                )
        assertEquals(fieldMapping(this::minimalMapping).toString(), mapper.mappingSource().toString());
        MapperService enabledMapper = createMapperService(fieldMapping(b -> b.field("type", textFieldName).field("fielddata", true)));
            assertEquals(TextFieldMapper.Defaults.POSITION_INCREMENT_GAP + 2, postings.nextPosition());
        }
    }
            Map.of("default", dflt, "standard", standard, "keyword", keyword, "whitespace", whitespace, "my_stop_analyzer", stop),
        assertThat(doc.rootDoc().getField("field2").fieldType().storeTermVectorOffsets(), equalTo(false));
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
    }
            TermsEnum terms = getOnlyLeafReader(reader).terms("field._index_prefix").iterator();
 * GitHub history for details.
                        }
import static org.hamcrest.Matchers.containsString;
            b.field("search_analyzer", "keyword");
        assertThat(doc.rootDoc().getField("field6").fieldType().storeTermVectorPayloads(), equalTo(true));
import org.apache.lucene.tests.analysis.MockSynonymAnalyzer;
            FieldType ft = prefix.fieldType;
import org.apache.lucene.analysis.core.KeywordAnalyzer;
            "{\"_doc\":{\"properties\":{\"field\":{\"type\":\"text\",\"store\":true,\"fields\":{\"subfield\":{\"type\":\"long\"}},"
            mpq.setSlop(1);
            assertEquals(100, ft.fielddataMinSegmentSize());
                b.field("type", textFieldName).field("analyzer", "standard");
        assertThat(mapperService.documentMapper().mappers().getMapper("field"), instanceOf(TextFieldMapper.class));
import org.apache.lucene.analysis.StopFilter;
            FieldMapper prefix = (FieldMapper) mapper.mappers().getMapper("field._index_prefix");
        withLuceneIndex(mapperService, iw -> iw.addDocument(doc.rootDoc()), reader -> {
                        .field("term_vector", "with_positions_offsets")
import org.opensearch.common.lucene.search.MultiPhrasePrefixQuery;
    }
                    }
            b -> b.field("field", "hello world"),
            b.startObject("synfield").field("type", textFieldName).field("analyzer", "standard").field("index_phrases", true).endObject();
            pluggableSettings,
    public void testBWCSerialization() throws IOException {
            b.startObject("fielddata_frequency_filter");
                b.field("max", 0.1);
        );
        // Multi-fields within multi-fields are deprecated but still allowed. The multiField flag on
                        .endObject()
            }
        {
                )
        assertParseMinimalWarnings();
            mpq.add(new Term("field", "d"));
        mapper.copyTo = copyTo;
    }
                b.field("type", "keyword");
        createDocumentMapper(fieldMapping(this::minimalMapping)).toXContent(
            b.startObject("field")
        DocumentMapper pluggableMapper = createDocumentMapper(pluggableSettings, mappingBuilder);
        assertFalse("nested multi-field inner should NOT be force-stored under derived_source", inner.fieldType.stored());
            assertEquals(options, fields[0].fieldType().indexOptions());
        for (String indexOptions : Arrays.asList("docs", "freqs")) {
            b.field("search_analyzer", "keyword");
                    b.endObject();
    public void testIndexOptions() throws IOException {
                .build();
                .field("type", textFieldName)
        SimilarityService similarityService = new SimilarityService(indexSettings, scriptService, emptyMap());
            () -> true,
        );
        // https://github.com/elastic/elasticsearch/issues/43976
        {
                fieldMapping(
    public final void testExistsQueryIndexDisabled() throws IOException {
        FieldMapper phraseFieldMapper = (FieldMapper) phraseMapper;
        ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.array("field", new String[] { "a", "b 12" })));
        });
        try (TokenStream ts = fields[0].tokenStream(queryShardContext.getMapperService().indexAnalyzer(), null)) {
        assertThat(fieldType.omitNorms(), equalTo(false));
    public void testNullConfigValuesFail() throws MapperParsingException {
                b -> b.field("type", "text")
        }, m -> assertEquals("keyword", m.fieldType().getTextSearchInfo().getSearchAnalyzer().name()));
import org.opensearch.index.analysis.CustomAnalyzer;
        // Lucene path
        assertFalse("multi-field subB after a nested multi-field should NOT be force-stored", subB.fieldType.stored());
        List<Map.Entry<MappedFieldType, Object>> captured = capturingDocInput.getCapturedFields();
            assertThat(e.getMessage(), containsString("min_chars [0] must be greater than zero"));
        MapperService mapperService = createMapperService(mapping(b -> {
        merge(mapperService, mapping(b -> {
        });
        );
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
            b.startObject("app_name");
            "At least one multi-field, [subA], was encountered that itself contains a multi-field. "
 * ownership. Elasticsearch licenses this file to you under
        XContentBuilder mapping = MediaTypeRegistry.JSON.contentBuilder().startObject().startObject("_doc").startObject("properties");
            );
                () -> createDocumentMapper(
            );
                phraseMapper = m;
        assertThat(doc.rootDoc().getField("field6").fieldType().storeTermVectors(), equalTo(true));
                .startObject("index_prefixes")
    public void testAnalyzedFieldPositionIncrementWithoutPositions() {
            PostingsEnum postings = terms.postings(null, PostingsEnum.POSITIONS);
                    b -> b.field("type", textFieldName)
                .field("type", textFieldName)
                .field("index_phrases", true)
            b.startArray("copy_to");
     * Helper method to create a document with both doc values and stored fields
                )
    }
        assertThat(mapperService.documentMapper().mappers().getMapper("field"), instanceOf(TextFieldMapper.class));
                .field("search_analyzer", "standard")
            FieldMapper prefix = (FieldMapper) mapper.mappers().getMapper("field._index_prefix");
        Query q2 = new MatchPhraseQueryBuilder("field", "three words here").toQuery(queryShardContext);
        enabledMapper.fieldType("field").fielddataBuilder("test", () -> { throw new UnsupportedOperationException(); }); // no exception
    public void testPluggableDataFormatTextValue() throws IOException {
            b.startObject("meta");
            AnalyzerScope.INDEX,
        assertThat(doc.rootDoc().getField("field5").fieldType().storeTermVectorOffsets(), equalTo(true));
 * The OpenSearch Contributors require contributions made to
            })));
                + "\"similarity\":\"BM25\",\"eager_global_ordinals\":true,\"position_increment_gap\":0,"
                        b.startObject("fields");
        // subB is built AFTER subA's nested multi-field build; without save/restore of the multiField
        e = expectThrows(
        for (Map.Entry<String, IndexOptions> entry : supportedOptions.entrySet()) {
        MapperService mapperService = createMapperService(fieldMapping(b -> {
                .field("index_phrases", true)
        assertEquals(mapping.toString(), createDocumentMapper(mapping).mappingSource().toString());
        Document doc = new Document();
                .endObject()
            assertTrue(terms.seekExact(new BytesRef("12")));
import org.opensearch.index.analysis.CharFilterFactory;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
                        .field("analyzer", "standard")
        assertThat(serialized, containsString("\"freqs\":{\"type\":\"text\",\"index_options\":\"freqs\"}"));
            )
    }
            () -> createDocumentMapper(
                ).build()
        DocumentMapper mapper = createDocumentMapper(pluggableSettings, mapping(b -> {
        }
        ParsedDocument doc = mapperService.documentMapper()
        ScriptService scriptService = new ScriptService(getIndexSettings(), scriptModule.engines, scriptModule.contexts);
                        .field("analyzer", "standard")
        merge(mapperService, startingMapping);
            b.field("search_quote_analyzer", "keyword");
 * not use this file except in compliance with the License.
        assertThat(doc.rootDoc().getField("field3").fieldType().storeTermVectorPositions(), equalTo(false));
        {
import static org.hamcrest.core.Is.is;
            b.field("index", false);
            {
        }, m -> {
        FieldMapper prefixFieldMapper = (FieldMapper) prefixMapper;
            DocumentMapper mapper = createDocumentMapper(
                .endObject();
                b.startObject("index_prefixes").field("min_chars", 0).field("max_chars", 10).endObject();
                {
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", textFieldName).field("norms", false)));
        assertTrue(captured.stream().noneMatch(e -> e.getKey().name().equals("field")));
            getPlugins().stream().filter(p -> p instanceof ScriptPlugin).map(p -> (ScriptPlugin) p).collect(toList())
        }));
                fieldMapping(
import org.opensearch.index.IndexSettings;
            .stream()
        assertTrue(fields[0].fieldType().stored());
                    )
                )
    }
                b.field("type", "keyword");
        assertThrows(UnsupportedOperationException.class, mapper::canDeriveSource);
        assertThat(mapperService.documentMapper().mappers().getMapper("other_field"), instanceOf(KeywordFieldMapper.class));
        // special case: default index analyzer
        });
            new ToXContent.MapParams(Collections.singletonMap("include_defaults", "true"))
        }
    }
            )
        MapperService mapperService = createMapperService(fieldMapping(b -> {
            TermsEnum terms = getOnlyLeafReader(reader).terms("field").iterator();
            TextFieldType ft = (TextFieldType) m.fieldType();
import org.apache.lucene.index.IndexableFieldType;
 * this file be licensed under the Apache-2.0 license or a
            source(
                b.startObject("fields");
            assertThat(
        builder.startObject();
        Query q3 = new MatchPhraseQueryBuilder("field", "two words").slop(1).toQuery(queryShardContext);
        assertTrue(mappingString.contains("search_quote_analyzer"));
        }
        final BytesRef binaryValue = new BytesRef(value);
    private MapperService createDerivedSourceMapperService() throws IOException {
            .anyMatch(e -> e.getKey().name().equals("text_field.sub") && e.getValue().equals("external_text"));
        Analyzer synonymAnalyzer = new Analyzer() {
        {
                b.field("norms", true);
        if (!textFieldName.equals(MatchOnlyTextFieldMapper.CONTENT_TYPE)) {
            assertThat(e.getMessage(), containsString("Cannot set position_increment_gap on field [field] without positions enabled"));
    }
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
        supportedOptions.put("freqs", IndexOptions.DOCS_AND_FREQS);
            })));
            new CustomAnalyzer(
        }
                b.startObject("subfield").field("type", "long").endObject();
            assertEquals(0, postings.nextDoc());
        FieldMapper fieldMapper = (FieldMapper) mapper.mappers().getMapper("field");
        );
        assertTrue(fieldMapper.fieldType().eagerGlobalOrdinals());
        // test default position_increment_gap
        {
    }
            }
import org.opensearch.common.settings.Settings;
import org.apache.lucene.search.SynonymQuery;
            Query q = matchQuery.parse(MatchQuery.Type.PHRASE_PREFIX, "synfield", "motor dogs");
            mpq.setSlop(1);
                    b.startObject("subA");
                b.field("unit", "min");
                                                                                                                         // this time
                .startObject("field6")
    /**
 *
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
            mpq.add(new Term("field", "two"));
    }
                b.startObject("index_prefixes").field("min_chars", 11).field("max_chars", 10).endObject();
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", textFieldName).field("store", true)));
            assertTrue(terms.seekExact(new BytesRef("12")));
 * KIND, either express or implied.  See the License for the
            IndexOptions options = entry.getValue();
                b.field("type", textFieldName).field("analyzer", "standard");
            );
import org.opensearch.indices.mapper.MapperRegistry;
        );
        TextFieldMapper textMapper = (TextFieldMapper) mapper.mappers().getMapper("field");
                .field("type", textFieldName)
        XContentBuilder mapping = fieldMapping(
    }
 * this work for additional information regarding copyright
    }
            DocumentMapper mapper = createDocumentMapper(
 */
import org.opensearch.index.query.MatchPhrasePrefixQueryBuilder;
            assertEquals(prefix.name(), "field._index_prefix");
        for (Mapper m : textMapper) {
        checker.registerUpdateCheck(b -> b.field("fielddata", true), m -> {
 * under the License.
        assertThat(serialized, containsString("\"offsets\":{\"type\":\"text\",\"index_options\":\"offsets\"}"));
import org.opensearch.cluster.metadata.IndexMetadata;
        // BuilderContext is saved and restored across nested builds, so a nested multi-field build
        // flag it would be incorrectly force-stored
                .startObject("field2")
            assertFalse(ft.storeTermVectors());
        assertThat(e.getMessage(), containsString("Cannot set index_phrases on field [field] if positions are not enabled"));
    }
            // "standard" will be replaced with MockSynonymAnalyzer
                XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
import org.apache.lucene.queries.spans.SpanTermQuery;
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
            pluggableSettings,
            fieldMapping(b -> b.field("type", "text").field("index_phrases", true))
            if (m.name().endsWith("._index_phrase")) {
        assertThat(fieldType.indexOptions(), equalTo(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS));
        NamedAnalyzer stop = new NamedAnalyzer(
        IndexableField[] fields = doc.rootDoc().getFields("field");
        CheckedConsumer<XContentBuilder, IOException> sourceBuilder,
        assertTrue(mappingString.contains("analyzer"));
            b.field("store", true);
                .startObject("field4")
                    .startObject("index_prefixes")
import java.io.IOException;
import org.apache.lucene.tests.analysis.Token;
        assertThat(fieldType.storeTermVectorPositions(), equalTo(false));
        assertEquals(2, fields.length);
                b.field("max_chars", 10);
        assertThat(q5, is(new PhraseQuery.Builder().add(new Term("field", "sparkle")).add(new Term("field", "stopword"), 2).build()));
        {
import org.apache.lucene.analysis.Analyzer;
            .settings(
import org.opensearch.index.mapper.TextFieldMapper.TextFieldType;
    protected void assertParseMaximalWarnings() {
            b.field("fielddata", true);
            }, m -> assertFalse(m.fieldType().getTextSearchInfo().hasNorms()));
                String source = builder.toString();
 * the Apache License, Version 2.0 (the "License"); you may
                .endObject()
            assertFalse(ft.storeTermVectorOffsets());
        }
            for (String option : supportedOptions.keySet()) {
        assertNotNull("Expected phrase sub-mapper", phraseMapper);
        assertThat(q4, is(new TermQuery(new Term("field", "singleton"))));
    }
            }), fieldMapping(b -> {
        }));
            MultiPhrasePrefixQuery mpq = new MultiPhrasePrefixQuery("synfield");
        ParsedDocument doc = mapper.parse(source(b -> {
                mapper.deriveSource(builder, reader.leaves().get(0).reader(), 0);
        Exception e = expectThrows(
        assertThat(doc.rootDoc().getField("field3").fieldType().storeTermVectors(), equalTo(true));
                        .startObject("index_prefixes")
            assertEquals(1, fields.length);
            assertEquals(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS, ft.indexOptions());
    }
        } else {
            b.endObject();
            assertEquals(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS, prefix.fieldType.indexOptions());
            assertTrue(terms.seekExact(new BytesRef("12")));
            assertEquals(positionIncrementGap + 1, postings.nextPosition());
                        return new StopFilter(tokenStream, EnglishAnalyzer.ENGLISH_STOP_WORDS_SET);
import org.junit.Before;
        assertParseMinimalWarnings();
                        .endObject()
    }
        IndexableField[] fields = doc.rootDoc().getFields("field");
            assertThat(q, equalTo(expected));
            b.endObject();
                    .field("field5", "1234")
        }
                    .field("field6", "1234")
        }
            assertEquals(prefix.name(), "field._index_prefix");
        DocumentMapper mapper = createDocumentMapper(
            minimalMapping(b);
                        new FieldMaskingSpanQuery(new SpanTermQuery(new Term("synfield._index_prefix", "dog")), "synfield")
        assertEquals(1, fields.length);
                prefixMapper = m;
 * You may obtain a copy of the License at
            assertThat(q, equalTo(expected));
import org.apache.lucene.document.StoredField;
            assertEquals(0, postings.nextDoc());
import org.apache.lucene.search.PhraseQuery;
                            new PhraseQuery.Builder().add(new Term("synfield._index_phrase", "bar baz")).build(),
            }
        );
        {
            assertFalse("Pluggable path should produce no field for '" + fieldName + "'", pluggableHasField);
                        .field("analyzer", "standard")
    public void testNotIndexedFieldPositionIncrement() {
        Query q6 = matchQuery.parse(MatchQuery.Type.PHRASE, "synfield", "motor dogs");
        assertEquals(1, fields.length);
        MapperService mapperService = createMapperService(
            assertTrue(terms.seekExact(new BytesRef("b")));
            assertEquals(prefix.name(), "field._index_prefix");
            boolean pluggableFound = docInput.getCapturedFields()
        assertThat(q2, is(new PhraseQuery("field._index_phrase", "three words", "words here")));
    }
/*
            b.startObject("field");
            MapperParsingException e = expectThrows(MapperParsingException.class, () -> createMapperService(fieldMapping(b -> {
            )
            b.startObject("sub").field("type", "text").endObject();
            "my_stop_analyzer",
    }
                b.startObject("fields");
import org.opensearch.common.util.FeatureFlags;
                        .field("index_options", "positions")
        XContentBuilder mappingBuilder,
    private Document createDocument(String name, String value, boolean forKeyword, boolean hasDocValues) {
    public void testEnableStore() throws IOException {
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));
            assertEquals(TextFieldMapper.Defaults.POSITION_INCREMENT_GAP + 2, postings.nextPosition());
        }
        withLuceneIndex(mapperService, iw -> iw.addDocument(doc.rootDoc()), reader -> {
            b.field("norms", false);
                ).build()
        merge(mapperService, mapping(b -> {
        }, m -> assertEquals("keyword", m.fieldType().getTextSearchInfo().getSearchQuoteAnalyzer().name()));
            fieldMapping(
                b.startObject("fields").startObject("_index_prefix").field("type", textFieldName).endObject().endObject();
                        .build(),
import org.apache.lucene.index.DirectoryReader;
            assertTrue(terms.seekExact(new BytesRef("b")));
        e = expectThrows(
                .field("term_vector", "with_offsets")
            assertThat(q, equalTo(mpq));
            is(
import org.opensearch.index.similarity.SimilarityService;
        TextFieldMapper topLevel = (TextFieldMapper) mapperService.documentMapper().mappers().getMapper("desc");
                        {
            assertNull(mapper.mappers().getMapper("field._index_prefix"));
        expectThrows(UnsupportedOperationException.class, () -> phraseFieldMapper.parseCreateFieldForPluggableFormat(null));
            assertEquals(0, postings.nextDoc());
            assertEquals(expectedValue, luceneFields[0].stringValue());
        }
        assertThat(serialized, containsString("\"docs\":{\"type\":\"text\",\"index_options\":\"docs\"}"));
    }
        {
            b -> b.field("type", textFieldName).startObject("index_prefixes").endObject().field("index_phrases", true)
            TextFieldMapper mapper = getMapper(FieldMapper.CopyTo.empty(), false);
                b.field("analyzer", "my_stop_analyzer");
    public void setup() {
            DocumentMapper mapper = createDocumentMapper(
            b.endObject();
                        .field("analyzer", "standard")
    protected void registerParameters(ParameterChecker checker) throws IOException {
        DocumentMapper luceneMapper = createDocumentMapper(mappingBuilder);
        }));
        Map<String, IndexOptions> supportedOptions = new HashMap<>();
        assertThat(doc.rootDoc().getField("field5").fieldType().storeTermVectorPayloads(), equalTo(false));
            b.endObject();
    public void testIndexPrefixMapping() throws IOException {
    }
        assertWarnings(
        );
            pluggableSettings,
import org.apache.lucene.analysis.TokenStream;
    protected void writeFieldValue(XContentBuilder builder) throws IOException {
        assertTextLuceneAndPluggablePathsEquivalent(
            PostingsEnum postings = terms.postings(null, PostingsEnum.POSITIONS);
        pluggableMapper.parse(source(sourceBuilder), docInput);
            b.field("eager_global_ordinals", true);
                b -> b.field("type", textFieldName)
        return doc;
            }
        CapturingDocumentInput capturingDocInput = new CapturingDocumentInput();
            }
        MapperService mapperService = createDerivedSourceMapperService();
            String field = entry.getKey();
                    b -> b.field("type", textFieldName)
                .addClause(new FieldMaskingSpanQuery(new SpanTermQuery(new Term("field._index_prefix", "words")), "field"))
        assertTrue("top-level text field should be force-stored under derived_source", topLevel.fieldType.stored());
            }
                .field("search_quote_analyzer", "keyword")
                .field("term_vector", "yes")
            {
import org.opensearch.core.common.Strings;
            b.field("term_vector", "yes");
            Settings.EMPTY,
        String expectedValue
 */
        });
            }
        );
        }
            checker.registerConflictCheck("index_prefixes", b -> b.startObject("index_prefixes").endObject());
    protected void minimalMapping(XContentBuilder b) throws IOException {
            CharTermAttribute termAtt = ts.addAttribute(CharTermAttribute.class);
            fieldMapping(b -> b.field("type", "text").field("analyzer", "default").startObject("index_prefixes").endObject())
        String fieldName,
 *
                new BooleanQuery.Builder().add(
            Query q = new MatchPhrasePrefixQueryBuilder("field", "motor d").toQuery(queryShardContext);
            MatchQuery matchQuery = new MatchQuery(queryShardContext);
        assertExistsQuery(mapperService);
            fieldMapping(b -> b.field("type", "text")),
            // top-level text field: still force-stored (it is walked by _source reconstruction)
                        .field("index_options", "offsets")
                b.field("norms", true);
        return new MapperService(
        checker.registerConflictCheck("term_vector", b -> b.field("term_vector", "yes"));
    @Override
            b.startObject("text_field");
        assertThat(doc.rootDoc().getField("field4").fieldType().storeTermVectorPositions(), equalTo(true));
    public void testDisableIndex() throws IOException {
        }
                .addClause(new SpanTermQuery(new Term("field", "words")))
        assertEquals("b", fields[1].stringValue());
                b.field("max", 20);
    public void testMultiFieldTextNotStoredForDerivedSource() throws IOException {
        final int positionIncrementGap = randomIntBetween(1, 1000);
            mpq.add(new Term("field", "words"));
                .field("search_quote_analyzer", "keyword")
            }
import org.opensearch.plugins.MapperPlugin;
    }
        assertThat(e.getMessage(), containsString("Cannot set position_increment_gap on field [field]"));
            b.startObject("fields");
                b.field("type", textFieldName);
        assertTextLuceneAndPluggablePathsEquivalent(
        TextFieldType fieldType = (TextFieldType) mapperService.fieldType("field");
    }
                b.startObject("index_prefixes").field("min_chars", 2).field("max_chars", 10).endObject();
                        .field("term_vector", "with_positions")
                .stream()
                fieldMapping(
            @Override
        assertThat(doc.rootDoc().getField("field5").fieldType().storeTermVectors(), equalTo(true));
        withLuceneIndex(mapperService2, iw -> iw.addDocument(doc2.rootDoc()), reader -> {
import org.apache.lucene.document.FieldType;
            IndexableField[] fields = doc.rootDoc().getFields("field._index_prefix");
            }
            assertEquals(0, postings.nextDoc());
            mapping.startObject(option).field("type", textFieldName).field("index_options", option).endObject();
                .field("type", textFieldName)
        assertFalse(fieldType.stored());
import java.util.List;
        assertEquals(2, fields.length);
import org.opensearch.index.search.MatchQuery;
import org.apache.lucene.queries.spans.SpanOrQuery;
                q,
        // Pluggable path
                        )
            b.endObject();
                    new SpanOrQuery(
        assertThat(doc.rootDoc().getField("field1").fieldType().storeTermVectors(), equalTo(false));
        }
        assertThat(
    public void testDisableNorms() throws IOException {
        }
            }
        checker.registerConflictCheck("position_increment_gap", b -> b.field("position_increment_gap", 10));
            assertThat(mapper.mappers().getMapper("field._index_prefix").toString(), containsString("prefixChars=2:5"));
        {
        try (Directory directory = newDirectory()) {
            MapperParsingException.class,
                        .startObject("index_prefixes")
        assertTrue(phraseMapper instanceof FieldMapper);
            FieldMapper prefix = (FieldMapper) mapper.mappers().getMapper("field._index_prefix");
                        b.endObject();
        CapturingDocumentInput docInput = new CapturingDocumentInput();
        assertThat(doc.rootDoc().getField("field6").fieldType().storeTermVectorPositions(), equalTo(true));
            })));
        );
                new StandardTokenizerFactory(indexSettings, null, "standard", indexSettings.getSettings()),
    public void testPositionIncrementGapOnIndexPrefixField() throws IOException {
            scriptService
            b -> b.field("type", textFieldName)
        }
    public void testPluggableDataFormatPhraseFieldMapperThrows() throws IOException {
    }
            assertEquals(IndexOptions.DOCS, ft.indexOptions());
            assertEquals(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS, ft.indexOptions());
        builder.endObject();
import static org.hamcrest.Matchers.equalTo;
            Strings.toString(MediaTypeRegistry.JSON, mapperService.documentMapper())
        assertThat(fieldType.fielddataMaxFrequency(), equalTo((double) Integer.MAX_VALUE));
            assertThat(e.getMessage(), containsString("min_chars [11] must be less than max_chars [10]"));
        checker.registerConflictCheck("index", b -> b.field("index", false));
        assertTrue(textFieldMapper.fieldType.stored());
        assertThat(doc.rootDoc().getField("field3").fieldType().storeTermVectorOffsets(), equalTo(true));
                .build();
                .field("analyzer", "my_stop_analyzer")
        checker.registerUpdateCheck(b -> {
            mapperRegistry,
        {
import org.apache.lucene.index.IndexWriter;
                .startObject("index_prefixes")
        CapturingDocumentInput capturingDocInput = new CapturingDocumentInput();
        );
import org.apache.lucene.search.TermQuery;
            );
import org.apache.lucene.search.BooleanClause;
                    .field("min_segment_size", 1000)
                    b.startObject("subB").field("type", "text").endObject();
/*
            assertThat(mapper.mappers().getMapper("field._index_prefix").toString(), containsString("prefixChars=2:10"));
import org.apache.lucene.index.Term;
                    .field("analyzer", "default")
        assertThat(doc.rootDoc().getField("field4").fieldType().storeTermVectorPayloads(), equalTo(false));
        }
                .build();
                        .endObject()
                MapperParsingException.class,
        TextFieldMapper mapper = getMapper(copyTo, false);
                )
        assertThat(doc.rootDoc().getField("field3").fieldType().storeTermVectorPayloads(), equalTo(false));
 *     http://www.apache.org/licenses/LICENSE-2.0
            assertTrue("Pluggable path should capture field '" + fieldName + "' with value '" + expectedValue + "'", pluggableFound);
                    new Term[] { new Term("synfield._index_phrase", "motor dogs"), new Term("synfield._index_phrase", "motor dog") }
        matchQuery.setAnalyzer(synonymAnalyzer);
        }));
            .build();
        checker.registerUpdateCheck(b -> {
                        b -> b.field("type", textFieldName).field("index_options", indexOptions).field("position_increment_gap", 10)
            assertEquals(20, ft.fielddataMaxFrequency(), 0);
                fieldMapping(b -> b.field("type", textFieldName).field("index", false).field("position_increment_gap", 10))
import org.apache.lucene.util.BytesRef;
            MapperParsingException.class,
            Query q = new MatchPhrasePrefixQueryBuilder("field", "singleton").toQuery(queryShardContext);
        assertEquals("a", fields[0].stringValue());
            xContentRegistry(),
        assertThat(e.getMessage(), containsString("Text fields are not optimised for operations that require per-document field data"));
        assertEquals(mapping.toString(), createDocumentMapper(mapping).mappingSource().toString());
                b.field("min_chars", 1);
        {
                .startObject("field3")
        );
            TextFieldMapper.Defaults.POSITION_INCREMENT_GAP
        }));
            assertEquals(positionIncrementGap + 2, postings.nextPosition());
        );
        return new IndexAnalyzers(
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
                fieldMapping(
            TextFieldType ft = (TextFieldType) m.fieldType();
            b.startObject("fields");
            }
        assertThat(doc.rootDoc().getField("field2").fieldType().storeTermVectors(), equalTo(true));
                + "from the mappings, either by flattening the chained [fields] blocks into a single level, or "
            doc.add(new SortedSetDocValuesField(name, binaryValue));
        XContentBuilder mapping = fieldMapping(
        List<Map.Entry<MappedFieldType, Object>> captured = capturingDocInput.getCapturedFields();
            b -> b.field("type", textFieldName)
    }
            b.field("index", false);
        MapperService mapperService = createDerivedSourceMapperService();
            assertThat(q, equalTo(mpq));
            assertEquals(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS, ft.indexOptions());
                builder.endObject();
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));
            })));
        textFieldName = "text";
            DocumentMapper mapper = createDocumentMapper(
            }
    public final void testExistsQueryIndexDisabledStoreTrue() throws IOException {
        // test custom position_increment_gap
                doc.add(new StoredField(name, binaryValue));
                b.field("type", textFieldName);
        }
            b.startObject("parent");
     */
                } }
            minimalMapping(b);
                    .field("field4", "1234")
            Exception e = expectThrows(
        });
        }));
                    .field("min", 2d)
                new TokenFilterFactory[] { new TokenFilterFactory() {
                break;
            b.endArray();
            MapperParsingException.class,
import org.opensearch.index.query.MatchPhraseQueryBuilder;
            checker.registerConflictCheck("norms", fieldMapping(b -> {
            DocumentMapper mapper = createDocumentMapper(
    public void testDefaultStoredFieldForDerivedSource() throws IOException {
            )
        FieldMapper.CopyTo copyTo = new FieldMapper.CopyTo.Builder().add("copy_to_field").build();
                b.field("type", textFieldName);
        supportedOptions.put("docs", IndexOptions.DOCS);
                .field("type", textFieldName)
            b.startObject("other_field").field("type", "keyword").endObject();
import org.opensearch.index.analysis.StandardTokenizerFactory;
        IndexableFieldType fieldType = fields[0].fieldType();
        checker.registerUpdateCheck(b -> b.field("boost", 2.0), m -> assertEquals(m.fieldType().boost(), 2.0, 0));
        assertThat(e.getMessage(), containsString("Cannot enable fielddata on a [text] field that is not indexed"));
                    b.startObject("analyzed").field("type", "text").field("store", false).endObject();
            b -> b.field("type", textFieldName)
                    )
                fieldMapping(
                + "switching to [copy_to] if appropriate."
        );
                break;
            b.field("norms", false);
                            BooleanClause.Occur.SHOULD
            b.startObject("fielddata_frequency_filter");
    ) throws IOException {
                    BooleanClause.Occur.SHOULD
 * SPDX-License-Identifier: Apache-2.0
            "default",
            mpq.add(new Term("field", "motor"));
        }
                        .field("analyzer", "standard")
        }));
            .numberOfShards(1)
        Exception e = expectThrows(IllegalArgumentException.class, () -> disabledMapper.fieldType("field").fielddataBuilder("test", () -> {
                        .field("index_options", "freqs")
        Exception e = expectThrows(
            matchQuery.setPhraseSlop(1);
            assertEquals(0, postings.nextDoc());
                .addClause(new FieldMaskingSpanQuery(new SpanTermQuery(new Term("field._index_prefix", "stopword")), "field"))
    public void testFastPhraseMapping() throws IOException {
import org.apache.lucene.index.IndexOptions;
            q7,
    }
            FieldType ft = prefix.fieldType;
        assertExistsQuery(mapperService);
            // keyword field with a text multi-field: the multi-field must NOT be force-stored,
import static org.hamcrest.Matchers.instanceOf;
            assertThat(q, equalTo(mpq));
        );
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);
            MultiPhrasePrefixQuery mpq = new MultiPhrasePrefixQuery("field");
        IndexableField[] luceneFields = luceneDoc.rootDoc().getFields(fieldName);
                        .field("min_chars", 2)
        ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.array("field", new String[] { "a", "b" })));
        NamedAnalyzer dflt = new NamedAnalyzer(
            assertEquals(1, fields.length);
import java.util.HashMap;
import org.opensearch.core.xcontent.ToXContent;
            {
        {
        }));
                        b.field("type", "text");
        );
            "field",
    }
                .startObject("field5")
            MapperParsingException e = expectThrows(MapperParsingException.class, () -> createMapperService(fieldMapping(b -> {
                b.field("min", 10);
import org.apache.lucene.search.Query;
                .field("analyzer", "default")
            MapperParsingException e = expectThrows(MapperParsingException.class, () -> createMapperService(fieldMapping(b -> {
        assertThat(doc.rootDoc().getField("field5").fieldType().storeTermVectorPositions(), equalTo(true));
                .field("analyzer", "standard")
                .endObject();
            Map.of(),
                + "Defining multi-fields within a multi-field is deprecated and will no longer be supported in 8.0. "
 * Unless required by applicable law or agreed to in writing,
        DocumentMapper mapper = createDocumentMapper(mapping);
        matchQuery.setAnalyzer(new MockSynonymAnalyzer());
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", textFieldName).field("index", false)));
                b.startObject("index_prefixes").field("min_chars", 2).field("max_chars", 10).endObject();
                return new TokenStreamComponents(reader -> {}, cts);
        CannedTokenStream cts = new CannedTokenStream(new Token("foo", 1, 0, 2, 2), new Token("bar", 0, 0, 2), new Token("baz", 1, 0, 2));
 * compatible open source license.
        assertEquals(mapping.toString(), createDocumentMapper(mapping).mappingSource().toString());
    }
        assertEquals(mapping.toString(), createDocumentMapper(mapping).mappingSource().toString());
        }
                {
import org.apache.lucene.queries.spans.SpanNearQuery;
import org.opensearch.index.query.QueryShardContext;
        mapping = fieldMapping(b -> b.field("type", textFieldName).field("analyzer", "default").field("search_analyzer", "keyword"));
    }
                    .put(IndexSettings.INDEX_DERIVED_SOURCE_SETTING.getKey(), true)
        assertThat(doc.rootDoc().getField("field1").fieldType().storeTermVectorPayloads(), equalTo(false));
            )
                .endObject()
        b.field("type", textFieldName);
                b.startObject("index_prefixes").field("min_chars", 1).field("max_chars", 25).endObject();
            () -> createMapperService(
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
        MapperService mapperService = createMapperService(fieldMapping(this::minimalMapping));
            "hello world"
            DocumentMapper mapper = createDocumentMapper(
                fieldMapping(b -> b.field("type", textFieldName).field("analyzer", "standard").startObject("index_prefixes").endObject())
        }
                    .endObject()
        assertTrue("Expected text sub-field captured with external value", found);
        DocumentMapper mapper = createDocumentMapper(
        MapperService mapperService = createDerivedSourceMapperService();
        assertThat(doc.rootDoc().getField("field1").fieldType().storeTermVectorOffsets(), equalTo(false));
            assertEquals(10, ft.fielddataMinFrequency(), 0);
        );
        assertThat(e.getMessage(), containsString("Cannot update parameter [index_phrases]"));
                iw.addDocument(createDocument("field", value, false, false));
        assertTrue(prefixMapper instanceof FieldMapper);
        {
                    b -> b.field("type", textFieldName)
        boolean found = docInput.getCapturedFields()
                        .startObject("index_prefixes")
        }
    }
                .addGap(1)
        assertThat(doc.rootDoc().getField("field4").fieldType().storeTermVectorOffsets(), equalTo(false));
        // must not clear the flag for sibling sub-fields of the outer build (subB below).
        final int positionIncrementGap = randomIntBetween(1, 1000);
        for (String option : supportedOptions.keySet()) {
            mpq.add(new Term[] { new Term("synfield", "dogs"), new Term("synfield", "dog") });
    }
    }
            b.field("index_phrases", true);
            TermsEnum terms = getOnlyLeafReader(reader).terms("field").iterator();
        IndexableField[] fields = doc.rootDoc().getFields("field._index_phrase");
import org.opensearch.core.xcontent.MediaTypeRegistry;
            }
        Mapper phraseMapper = null;
    @Override
                        .startObject("index_prefixes")
                    b -> b.field("type", textFieldName)
    }
                assertEquals("{\"" + "field" + "\":" + "\"" + value + "\"" + "}", source);
                b.field("norms", false);
            {
        assertThat(q, is(new PhraseQuery("field._index_phrase", "two words")));
        checker.registerConflictCheck("analyzer", b -> b.field("analyzer", "keyword"));
        TextFieldMapper multiField = (TextFieldMapper) mapperService.documentMapper().mappers().getMapper("app_name.analyzed");
            fieldMapping(b -> b.field("type", textFieldName).field("eager_global_ordinals", true))
        XContentBuilder newField = mapping(b -> {
        {
        assertFalse("text multi-field should NOT be force-stored under derived_source", multiField.fieldType.stored());
                )
    public void testPluggablePathEquivalenceWithLucenePath() throws IOException {
        String mappingString = builder.toString();
            MapperParsingException.class,
    }
        IndexMetadata build = IndexMetadata.builder("test_index")
            MatchQuery matchQuery = new MatchQuery(queryShardContext);
        assertThat(doc.rootDoc().getField("field4").fieldType().storeTermVectors(), equalTo(true));
        MatchQuery matchQuery = new MatchQuery(queryShardContext);
import org.opensearch.core.xcontent.XContentBuilder;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
            DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", textFieldName).nullField("index_prefixes")));
                .endObject()
                    .endObject()
        ParsedDocument luceneDoc = luceneMapper.parse(source(sourceBuilder));
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
        {
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        };
 * Licensed to Elasticsearch under one or more contributor
            fieldMapping(
        CapturingDocumentInput docInput = new CapturingDocumentInput();
        withLuceneIndex(mapperService, iw -> iw.addDocument(doc.rootDoc()), reader -> {
        MapperService mapperService = createMapperService(
    @Override
import org.opensearch.common.CheckedConsumer;
        assertTrue(mappingString.contains("search_analyzer"));
        assertFalse("multi-field subA should NOT be force-stored under derived_source", subA.fieldType.stored());
                new CharFilterFactory[0],
        });
            b.endObject();
        NamedAnalyzer whitespace = new NamedAnalyzer("whitespace", AnalyzerScope.INDEX, new WhitespaceAnalyzer());
                        .endObject()
                new MultiPhraseQuery.Builder().add(
        });
            b.endObject();
        }
                b -> b.field("field1", "1234")
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
    }
                    @Override
            pluggableSettings,
        }
            assertFalse(ft.storeTermVectors());
                )
    public void testFrequencyFilter() throws IOException {
            IndexableField[] fields = doc.rootDoc().getFields(field);
            b.field("fielddata", true);
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
        assertNotNull("Expected prefix sub-mapper", prefixMapper);
        );
        assertThat(fieldType.storeTermVectors(), equalTo(false));
 *
        checker.registerConflictCheck("similarity", b -> b.field("similarity", "boolean"));
            matchQuery.setAnalyzer(new MockSynonymAnalyzer());
            is(
            FieldMapper prefix = (FieldMapper) mapper.mappers().getMapper("field._index_prefix");
            q6,
        ParsedDocument doc = defaultMapper.parse(
            fieldMapping(b -> b.field("type", textFieldName).field("position_increment_gap", positionIncrementGap))
        }));
            b.field("norms", false);
        IndexableField[] fields = doc.rootDoc().getFields("field");
        );
        MapperService mapperService2 = createMapperService(
            )
    public void testSearchQuoteAnalyzerSerialization() throws IOException {
            MapperParsingException e = expectThrows(MapperParsingException.class, () -> createMapperService(fieldMapping(b -> {
        e = expectThrows(IllegalArgumentException.class, () -> merge(mapperService, differentPhrases));
    private TextFieldMapper getMapper(FieldMapper.CopyTo copyTo, boolean isStored) throws IOException {
        MapperRegistry mapperRegistry = new IndicesModule(
        );
                b.field("type", textFieldName);
            Query q = matchQuery.parse(MatchQuery.Type.PHRASE_PREFIX, "synfield", "two dogs");
                        new FieldMaskingSpanQuery(new SpanTermQuery(new Term("synfield._index_prefix", "dogs")), "synfield"),
        MapperService mapperService = createMapperService(
    public void testEagerGlobalOrdinals() throws IOException {
        XContentBuilder builder = MediaTypeRegistry.JSON.contentBuilder();
                    b -> b.field("type", textFieldName)
        assertEquals("1234", fields[0].stringValue());
                .field("term_vector", "with_positions_offsets_payloads")
        merge(mapperService, newField);
            PostingsEnum postings = terms.postings(null, PostingsEnum.POSITIONS);
    public void testPluggableDataFormatTextWithExternalValue() throws IOException {
            } else {
        } else {
                b.endObject();
                b.value("target");
        assertExistsQuery(mapperService);
                        .startObject("index_prefixes")
                .addClause(
import org.opensearch.indices.IndicesModule;
            b.field("type", textFieldName);
import java.util.Collections;
                    }
            // norms can be set from true to false, but not vice versa
            Query expected = new SpanNearQuery.Builder("synfield", true).addClause(new SpanTermQuery(new Term("synfield", "motor")))
        if (!textFieldName.equals("match_only_text")) {
                b.field("min_segment_size", 500);
import org.opensearch.common.xcontent.XContentFactory;
                    .startObject("fielddata_frequency_filter")
                    public String name() {
            )
            builder,
        XContentBuilder mapping = mapping(
        // Scenario 1: default text value
        assertThat(q3, is(new PhraseQuery(1, "field", "two", "words")));
            Query q = new MatchPhrasePrefixQueryBuilder("field", "two words").slop(1).toQuery(queryShardContext);
}
                    .field("field2", "1234")
            containsString("[analyzer] on mapper [field] of type [" + textFieldName + "] must not have a [null] value")
            {
        TextFieldMapper subA = (TextFieldMapper) mapperService.documentMapper().mappers().getMapper("parent.subA");
        assertEquals("b", fields[1].stringValue());
            AnalyzerScope.INDEX,
            FieldMapper prefix = (FieldMapper) mapper.mappers().getMapper("field._index_prefix");
        MapperService mapperService = createMapperService(fieldMapping(b -> {
        assertEquals("a", fields[0].stringValue());
        TextFieldMapper inner = (TextFieldMapper) mapperService.documentMapper().mappers().getMapper("parent.subA.inner");
            }
            new StandardAnalyzer(),
        assertThat(e.getMessage(), containsString("Cannot update parameter [index_prefixes]"));
package org.opensearch.index.mapper;
                fieldMapping(
        for (Mapper m : textMapper) {
import org.apache.lucene.index.IndexWriterConfig;
        }
        }));
import org.opensearch.index.analysis.NamedAnalyzer;
    }
            {
    public void testFastPhrasePrefixes() throws IOException {
            assertTrue(ft.storeTermVectorOffsets());
        }
                        .field("max_chars", 10)
            e.getMessage(),
        DocumentMapper mapper = createDocumentMapper(pluggableSettings, fieldMapping(b -> b.field("type", "text")));
            })));
            )
                b.field("norms", false);
import org.opensearch.plugins.ScriptPlugin;
        // Scenario 2: null value — no field produced
 * license agreements. See the NOTICE file distributed with
            checker.registerUpdateCheck(b -> {
        assertThat(fieldType.storeTermVectorOffsets(), equalTo(false));
        if (expectedValue == null) {
    }
        }
    public void testTermVectors() throws IOException {
            {
                .field("term_vector", "with_positions")
            assertEquals(prefix.name(), "field._index_prefix");
    }
                .field("term_vector", "no")
        assertThat(
            assertThat(e.getMessage(), containsString("Field [field._index_prefix] is defined more than once"));
            protected TokenStreamComponents createComponents(String fieldName) {
            b.startObject("index_prefixes");
                }
        MapperService mapperService = createMapperService(mapping(b -> {
            b.field("index_options", "offsets");
    public void testNestedIndexPrefixes() throws IOException {
        assertTrue(fieldType.tokenized());
                        .field("analyzer", "standard")
                )
        Settings pluggableSettings,
        );
    public final void testExistsQueryWithNorms() throws IOException {
        }
        );
        assertThat(fieldType.fielddataMinFrequency(), equalTo(2d));
        XContentBuilder startingMapping = fieldMapping(
            MultiPhrasePrefixQuery mpq = new MultiPhrasePrefixQuery("field");
        }
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        // special case: default search analyzer
            }
        supportedOptions.put("positions", IndexOptions.DOCS_AND_FREQS_AND_POSITIONS);
        checker.registerUpdateCheck(b -> b.field("eager_global_ordinals", "true"), m -> assertTrue(m.fieldType().eagerGlobalOrdinals()));
            assertTrue(ts.incrementToken());
            .numberOfReplicas(0)
            "field",
                fieldMapping(b -> b.field("type", textFieldName).field("index", "false").field("index_phrases", true))
                b.field("min", 0.001);
                    b -> b.field("type", textFieldName)
                            b.startObject("inner").field("type", "text").endObject();
                        .add(
            Query q = new MatchPhrasePrefixQueryBuilder("field", "three words here").toQuery(queryShardContext);
            fieldMapping(b -> b.field("type", "text")),
        );
    }
            b -> b.field("type", textFieldName).startObject("index_prefixes").endObject().field("index_phrases", false)
                b.field("min_segment_size", 100);
                .field("search_analyzer", "default")
import org.apache.lucene.index.TermsEnum;
    public void testIndexPrefixIndexTypes() throws IOException {
import org.opensearch.script.ScriptService;
import org.opensearch.script.ScriptModule;
        XContentBuilder differentPhrases = fieldMapping(
import org.apache.lucene.index.IndexableField;
            assertThat(e.getMessage(), containsString("max_chars [25] must be less than 20"));
        ParsedDocument doc2 = mapperService2.documentMapper().parse(source(b -> b.array("field", new String[] { "a", "b 12" })));
            FieldType ft = prefix.fieldType;
            () -> createDocumentMapper(fieldMapping(b -> b.field("type", textFieldName).field("analyzer", (String) null)))
                .field("type", textFieldName)
            .parse(source(b -> b.field("field", "Some English text that is going to be very useful")));
            MapperParsingException e = expectThrows(MapperParsingException.class, () -> createMapperService(fieldMapping(b -> {
import org.apache.lucene.document.SortedSetDocValuesField;
            TermsEnum terms = getOnlyLeafReader(reader).terms("field").iterator();
import org.opensearch.index.analysis.AnalyzerScope;
        supportedOptions.put("offsets", IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS);
                    }
            ts.reset();
            b.startObject("synfield");
            assertTrue(ft.fielddata());
            )
        ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.array("field", new String[] { "a", "b" })));
        });
            );
                .field("type", textFieldName)
        {
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));
        DocumentMapper mapper = createDocumentMapper(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertEquals(DocValuesType.NONE, fieldType.docValuesType());
            MapperParsingException.class,
            );
                .endObject()
                .endObject()
        );
            Map.of()
import org.opensearch.index.analysis.IndexAnalyzers;
                b.startObject("index_prefixes").field("min_chars", 1).field("max_chars", 10).endObject();
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> merge(mapperService, differentPrefix));
            assertThat(e.getMessage(), containsString("Cannot set index_prefixes on unindexed field [field]"));
            b -> b.field("type", textFieldName).field("analyzer", "standard").field("search_analyzer", "keyword")
        IndexableField[] fields = doc.rootDoc().getFields("field");
                b.field(option, "1234");
    public void testDerivedValueFetching_StoredField() throws IOException {
            }, b -> {
import org.apache.lucene.queries.spans.FieldMaskingSpanQuery;
            Query q = new MatchPhrasePrefixQueryBuilder("field", "two words").toQuery(queryShardContext);
    private void assertTextLuceneAndPluggablePathsEquivalent(
        }));
        }
    }
            b.field("similarity", "BM25");
        }
            minimalMapping(b);
        expectThrows(UnsupportedOperationException.class, () -> prefixFieldMapper.parseCreateFieldForPluggableFormat(null));
        DocumentMapper defaultMapper = createDocumentMapper(mapping);
            }
        {
                .field("term_vector", "with_positions_offsets")
                b.field("index_phrases", true);
            b.field("store", true);
    @Before
                .build();
                b.field("type", textFieldName).field("analyzer", "standard");
                    {
        }
            () -> createMapperService(
        withLuceneIndex(mapperService2, iw -> iw.addDocument(doc2.rootDoc()), reader -> {
        ).getMapperRegistry();
            b.endObject();
        IndexSettings indexSettings = new IndexSettings(build, Settings.EMPTY);
            assertTrue(terms.seekExact(new BytesRef("12")));
        mapping = fieldMapping(b -> b.field("type", textFieldName).field("analyzer", "keyword").field("search_analyzer", "default"));
            TermsEnum terms = getOnlyLeafReader(reader).terms("field._index_prefix").iterator();
                b.field("analyzer", "standard"); // "standard" will be replaced with MockSynonymAnalyzer
            ParsedDocument doc = mapper.parse(source(b -> b.field("field", "Some English text that is going to be very useful")));
import org.apache.lucene.document.Document;
        assertWarnings("Parameter [boost] on field [field] is deprecated and will be removed in 3.0");
        Mapper prefixMapper = null;
            b.field("position_increment_gap", 0);
                b.field("type", textFieldName).field("analyzer", "standard");
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            {
public class TextFieldMapperTests extends MapperTestCase {
        ScriptModule scriptModule = new ScriptModule(
        assertEquals(mapping.toString(), createDocumentMapper(mapping).mappingSource().toString());
        Query q7 = matchQuery.parse(MatchQuery.Type.BOOLEAN, "synfield", "foo");
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));
            PostingsEnum postings = terms.postings(null, PostingsEnum.POSITIONS);
    public void testFielddata() throws IOException {
            fieldMapping(b -> b.field("type", "text").field("index_prefixes", new java.util.HashMap<>()))
        Query q4 = new MatchPhraseQueryBuilder("field", "singleton").toQuery(queryShardContext);
        mapper.parse(source(b -> b.field("field", "hello world")), capturingDocInput);
            if (forKeyword) {
        IndexableField[] fields = doc.rootDoc().getFields("field");
            assertEquals(positionIncrementGap + 2, postings.nextPosition());
        assertEquals(
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
            b.startObject("desc").field("type", "text").field("store", false).endObject();
            );
    protected IndexAnalyzers createIndexAnalyzers(IndexSettings indexSettings) {
        );
            TermsEnum terms = getOnlyLeafReader(reader).terms("field").iterator();
                fieldMapping(b -> b.field("type", textFieldName).field("index_options", "freqs").field("index_phrases", true))
        mapping.endObject().endObject().endObject();
    }
        );
            b.endObject();
        {
        assertThat(doc.rootDoc().getField("field6").fieldType().storeTermVectorOffsets(), equalTo(true));
        if (hasDocValues) {
    public void testDefaultPositionIncrementGap() throws IOException {
 * specific language governing permissions and limitations
    public void testPossibleToDeriveSource_WhenCopyToPresent() throws IOException {
            getPlugins().stream().filter(p -> p instanceof MapperPlugin).map(p -> (MapperPlugin) p).collect(toList())
        assertThat(fieldType.fielddataMinSegmentSize(), equalTo(1000));
    }
import org.apache.lucene.search.MultiPhraseQuery;
            assertThat(q, equalTo(expected));
        Query q = new MatchPhraseQueryBuilder("field", "two words").toQuery(queryShardContext);
    public void testDefaults() throws IOException {
        mapping = fieldMapping(
                b.startObject("index_prefixes").endObject();
                b.endObject();
import org.apache.lucene.tests.analysis.CannedTokenStream;
            assertThat(q, equalTo(expected));
        checker.registerConflictCheck("store", b -> b.field("store", true));
        checker.registerUpdateCheck(b -> {
            checker.registerConflictCheck("index_phrases", b -> b.field("index_phrases", true));
                        .endObject()
        TextFieldMapper mapper = (TextFieldMapper) mapperService.documentMapper().mappers().getMapper("field");
        DocumentMapper mapper = createDocumentMapper(pluggableSettings, fieldMapping(b -> b.field("type", "text")));
            b.field("analyzer", "default");
                        .endObject()
import org.apache.lucene.store.Directory;
                b.field("type", textFieldName);
    }
        assertThat(e.getMessage(), containsString("Cannot set index_phrases on unindexed field [field]"));
        assertThat(doc.rootDoc().getField("field2").fieldType().storeTermVectorPositions(), equalTo(false));
    public void testPluggableDataFormatPrefixFieldMapperThrows() throws IOException {
            Query expected = new SpanNearQuery.Builder("field", true).addClause(new SpanTermQuery(new Term("field", "three")))
        IndexableField[] fields = doc.rootDoc().getFields("field");
        {
        MapperService mapperService = createMapperService(fieldMapping(b -> b.field("type", "text").field("store", isStored)));
        );
        });
            indexSettings,
        MapperService disabledMapper = createMapperService(fieldMapping(this::minimalMapping));
            b.endObject();
                .endObject()
            throw new UnsupportedOperationException();
                + "To resolve the issue, all instances of [fields] that occur within a [fields] block should be removed "
            assertEquals(prefix.name(), "field._index_prefix");
        builder.value(1234);
            b.endObject();
            createIndexAnalyzers(indexSettings),
        mapper.parse(source(b -> b.nullField("field")), capturingDocInput);
            );
                doc.add(new StoredField(name, value));
                + "\"copy_to\":[\"target\"],\"meta\":{\"unit\":\"min\"},\"index_options\":\"offsets\",\"term_vector\":\"yes\",\"norms\":false,"
    }
        assertEquals(1, fields.length);
                    .field("fielddata", true)
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);
                .field("index_phrases", true)
        MapperService mapperService = createMapperService(fieldMapping(b -> {
                b.field("type", textFieldName).field("analyzer", "standard").field("index", false);
            assertEquals("Lucene path should produce no field for '" + fieldName + "'", 0, luceneFields.length);
            PostingsEnum postings = terms.postings(null, PostingsEnum.POSITIONS);
                }
        assertThat(fieldType.storeTermVectorPayloads(), equalTo(false));
import org.apache.lucene.analysis.en.EnglishAnalyzer;
        assertEquals(0, fields.length);
import org.apache.lucene.index.PostingsEnum;
        merge(mapperService, fieldMapping(b -> b.field("type", "text").field("store", false)));
            b.field("analyzer", "default");
                    .field("position_increment_gap", positionIncrementGap)
    public void testSearchAnalyzerSerialization() throws IOException {
                b.field("type", textFieldName);
import static java.util.Collections.emptyMap;
            b -> b.nullField("field"),
            boolean pluggableHasField = docInput.getCapturedFields().stream().anyMatch(e -> e.getKey().name().equals(fieldName));
        assertThat(
            DocumentMapper mapper = createDocumentMapper(
            );
        TextFieldMapper textMapper = (TextFieldMapper) mapper.mappers().getMapper("field");
            try (DirectoryReader reader = DirectoryReader.open(directory)) {
        );
        );
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
            assertTrue("Lucene path should produce field '" + fieldName + "'", luceneFields.length > 0);
import org.opensearch.Version;
        );
        // special case: default index/search analyzer
            Query expected = new SpanNearQuery.Builder("field", true).addClause(new SpanTermQuery(new Term("field", "two")))
            assertEquals(TextFieldMapper.Defaults.POSITION_INCREMENT_GAP + 1, postings.nextPosition());
        );
        NamedAnalyzer standard = new NamedAnalyzer("standard", AnalyzerScope.INDEX, new StandardAnalyzer());
                .addClause(new FieldMaskingSpanQuery(new SpanTermQuery(new Term("field._index_prefix", "here")), "field"))
        );
                    @Override
    @Override
            checker.registerConflictCheck("index_options", b -> b.field("index_options", "docs"));
                + "\"fielddata\":true,\"fielddata_frequency_filter\":{\"min\":0.001,\"max\":0.1,\"min_segment_size\":500},"
import java.util.Arrays;
            b.field("norms", false);
        assertTrue(captured.stream().anyMatch(e -> e.getKey().name().equals("field") && e.getValue().equals("hello world")));
                    new BooleanQuery.Builder().add(new TermQuery(new Term("synfield", "foo")), BooleanClause.Occur.SHOULD)
                .anyMatch(e -> e.getKey().name().equals(fieldName) && e.getValue().equals(expectedValue));
            {
        assertThat(mapperService.documentMapper().mappers().getMapper("field"), instanceOf(TextFieldMapper.class));
                is(new SynonymQuery.Builder("field._index_prefix").addTerm(new Term("field._index_prefix", "singleton")).build())
            null
            String value = "value";
        MapperService mapperService = createMapperService(startingMapping);
            assertEquals(0, postings.nextDoc());
        assertTrue(fields[0].fieldType().omitNorms());
                    fieldMapping(
            assertEquals("Some English", termAtt.toString());
                        return "stop";
        assertThat(doc.rootDoc().getField("field2").fieldType().storeTermVectorPayloads(), equalTo(false));
    public void testSimpleMerge() throws IOException {
            Query expected = new SpanNearQuery.Builder("field", true).addClause(new SpanTermQuery(new Term("field", "sparkle")))
            b -> b.startObject("field1")
import org.apache.lucene.index.DocValuesType;
            mpq.add(new Term("synfield", "two"));
        );
        TextFieldMapper textFieldMapper = (TextFieldMapper) mapperService.documentMapper().mappers().getMapper("field");
            )
        }
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
                    .field("field3", "1234")
        assertEquals(1, fields.length);
        withLuceneIndex(mapperService, iw -> iw.addDocument(doc.rootDoc()), reader -> {
            },
        Query q5 = new MatchPhraseQueryBuilder("field", "sparkle a stopword").toQuery(queryShardContext);
            b.field("type", "text");
                Settings.builder()
                .endObject()
import org.apache.lucene.search.BooleanQuery;
            FieldType ft = prefix.fieldType;
                + "\"index_prefixes\":{\"min_chars\":1,\"max_chars\":10},\"index_phrases\":true}}}}",
            similarityService,
        assertThat(doc.rootDoc().getField("field1").fieldType().storeTermVectorPositions(), equalTo(false));
        XContentBuilder differentPrefix = fieldMapping(
    public void testPluggableDataFormatTextNullSkipped() throws IOException {
    @Override
import static java.util.stream.Collectors.toList;
            b.startObject("field")
            Query q = new MatchPhrasePrefixQueryBuilder("field", "sparkle a stopword").toQuery(queryShardContext);
        Exception e = expectThrows(
        assertParseMinimalWarnings();
