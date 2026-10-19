            assertTrue(terms.seekExact(new BytesRef("12")));
import org.opensearch.core.xcontent.XContentBuilder;
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        assertThat(doc.rootDoc().getField("field5").fieldType().storeTermVectorPayloads(), equalTo(false));
                .field("index_phrases", true)  
            "{\"_doc\":{\"properties\":{\"field\":{\"type\":\"text\",\"store\":true,\"fields\":{\"subfield\":{\"type\":\"long\"}},"  
            b.field("analyzer", "default");
        builder.endObject();
    }
        MapperService mapperService = createDerivedSourceMapperService();  
            fieldMapping(b -> b.field("type", "text")),
            ts.reset();
        {
        }  
                b.startObject("index_prefixes").field("min_chars", 2).field("max_chars", 10).endObject();
    @Override
                .field("term_vector", "with_offsets")
        }  
        assertThat(fieldType.storeTermVectorPositions(), equalTo(false));
            b.field("type", "text");
 *     http://www.apache.org/licenses/LICENSE-2.0
                b.startObject("fields");
                fieldMapping(  
import java.util.Arrays;
        MatchQuery matchQuery = new MatchQuery(queryShardContext);
            b -> b.field("type", textFieldName).field("analyzer", "standard").field("search_analyzer", "keyword")
            FieldMapper prefix = (FieldMapper) mapper.mappers().getMapper("field._index_prefix");
        );  
        {
        } else {
        assertThat(  
            b.field("analyzer", "default");  
            // "standard" will be replaced with MockSynonymAnalyzer  
                        b.startObject("fields");  
            assertEquals(TextFieldMapper.Defaults.POSITION_INCREMENT_GAP + 1, postings.nextPosition());
        assertThat(doc.rootDoc().getField("field2").fieldType().storeTermVectorOffsets(), equalTo(false));  
        assertThat(e.getMessage(), containsString("Cannot set index_phrases on field [field] if positions are not enabled"));  
        }));  
            b -> b.field("field", "hello world"),  
    public void testIndexPrefixMapping() throws IOException {  
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
    }
            assertTrue(ft.storeTermVectorOffsets());
        }  
        ParsedDocument doc = mapper.parse(source(b -> {  
            b -> b.field("type", textFieldName).startObject("index_prefixes").endObject().field("index_phrases", true)
    }
                .field("analyzer", "my_stop_analyzer")  
            b -> b.field("type", textFieldName)
            MapperParsingException e = expectThrows(MapperParsingException.class, () -> createMapperService(fieldMapping(b -> {
                {
import org.opensearch.index.analysis.CustomAnalyzer;
import org.opensearch.index.analysis.IndexAnalyzers;  
        {  
                        .field("analyzer", "standard")
                .endObject()
        assertThat(doc.rootDoc().getField("field5").fieldType().storeTermVectorPositions(), equalTo(true));
    public void testIndexPrefixIndexTypes() throws IOException {  
    }
            b.field("norms", false);  
            Query q = new MatchPhrasePrefixQueryBuilder("field", "two words").slop(1).toQuery(queryShardContext);  
                    .put(IndexSettings.INDEX_DERIVED_SOURCE_SETTING.getKey(), true)
        assertEquals(1, fields.length);
        withLuceneIndex(mapperService, iw -> iw.addDocument(doc.rootDoc()), reader -> {
            {
            boolean pluggableHasField = docInput.getCapturedFields().stream().anyMatch(e -> e.getKey().name().equals(fieldName));
            assertEquals(0, postings.nextDoc());
        // special case: default search analyzer
        expectThrows(UnsupportedOperationException.class, () -> phraseFieldMapper.parseCreateFieldForPluggableFormat(null));
        mapping.endObject().endObject().endObject();
            if (m.name().endsWith("._index_prefix")) {
            assertEquals(TextFieldMapper.Defaults.POSITION_INCREMENT_GAP + 2, postings.nextPosition());  
                    new Term[] { new Term("synfield._index_phrase", "motor dogs"), new Term("synfield._index_phrase", "motor dog") }  
        // https://github.com/elastic/elasticsearch/issues/43976
            scriptService  
        merge(mapperService, startingMapping);  
            )
                )  
    public void testNullConfigValuesFail() throws MapperParsingException {
            assertEquals(IndexOptions.DOCS, ft.indexOptions());
            assertTrue(ft.fielddata());
 * not use this file except in compliance with the License.
            Strings.toString(MediaTypeRegistry.JSON, mapperService.documentMapper())
                fieldMapping(  
import org.opensearch.index.mapper.TextFieldMapper.TextFieldType;
            })));  
                fieldMapping(b -> b.field("type", textFieldName).field("index", "false").field("index_phrases", true))
            fieldMapping(b -> b.field("type", "text").field("index_phrases", true))  
import java.util.Map;
    }  
            matchQuery.setAnalyzer(new MockSynonymAnalyzer());
            DocumentMapper mapper = createDocumentMapper(  
import org.opensearch.common.lucene.search.MultiPhrasePrefixQuery;  
                b.field("type", textFieldName).field("analyzer", "standard");  
                    )
                + "To resolve the issue, all instances of [fields] that occur within a [fields] block should be removed "
            Query expected = new SpanNearQuery.Builder("synfield", true).addClause(new SpanTermQuery(new Term("synfield", "motor")))  
            TextFieldType ft = (TextFieldType) m.fieldType();  
import org.opensearch.index.query.MatchPhraseQueryBuilder;  
        }, m -> assertEquals("keyword", m.fieldType().getTextSearchInfo().getSearchQuoteAnalyzer().name()));  
        {
                q,
            b.endArray();  
                    b.endObject();  
        }
import org.opensearch.index.similarity.SimilarityService;  
            pluggableSettings,
            checker.registerConflictCheck("index_phrases", b -> b.field("index_phrases", true));
                    .field("field3", "1234")
    @Override
        }, m -> assertEquals("keyword", m.fieldType().getTextSearchInfo().getSearchAnalyzer().name()));
            AnalyzerScope.INDEX,
    protected void assertParseMaximalWarnings() {
        );
import org.apache.lucene.document.Document;  
        assertThat(doc.rootDoc().getField("field2").fieldType().storeTermVectors(), equalTo(true));
                Settings.builder()  
        checker.registerConflictCheck("position_increment_gap", b -> b.field("position_increment_gap", 10));
        MapperService mapperService = createMapperService(fieldMapping(b -> {
        }  
        {
        // flag it would be incorrectly force-stored  
                    .field("field6", "1234")
        {
 * Unless required by applicable law or agreed to in writing,
            MapperParsingException e = expectThrows(MapperParsingException.class, () -> createMapperService(fieldMapping(b -> {
        e = expectThrows(  
            b.startObject("synfield");
                .stream()
        {
                    .startObject("fielddata_frequency_filter")  
            DocumentMapper mapper = createDocumentMapper(
        XContentBuilder differentPrefix = fieldMapping(  
                        .field("max_chars", 10)  
 * The OpenSearch Contributors require contributions made to  
            checker.registerUpdateCheck(b -> {  
import org.opensearch.plugins.MapperPlugin;  
        assertTrue(mappingString.contains("analyzer"));
            b -> b.field("type", textFieldName)
            assertTrue(terms.seekExact(new BytesRef("12")));
/*  
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));
            b.startObject("fielddata_frequency_filter");  
        mapping = fieldMapping(
    public void testEagerGlobalOrdinals() throws IOException {
            @Override
import org.opensearch.index.IndexSettings;
        for (Mapper m : textMapper) {
        IndexSettings indexSettings = new IndexSettings(build, Settings.EMPTY);
            () -> createDocumentMapper(  
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();  
                b.field("type", "keyword");  
        );
        );
        MapperService mapperService = createMapperService(mapping(b -> {  
        String mappingString = builder.toString();  
/*
        FieldMapper.CopyTo copyTo = new FieldMapper.CopyTo.Builder().add("copy_to_field").build();
        );  
        assertParseMinimalWarnings();
            null
        matchQuery.setAnalyzer(synonymAnalyzer);
                b.field("type", textFieldName);
    }
    public void testNestedIndexPrefixes() throws IOException {
            b.startObject("synfield").field("type", textFieldName).field("analyzer", "standard").field("index_phrases", true).endObject();
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
import org.apache.lucene.index.PostingsEnum;
        assertEquals(1, fields.length);
            b -> b.field("type", textFieldName)
            assertFalse(ft.storeTermVectorOffsets());  
        withLuceneIndex(mapperService, iw -> iw.addDocument(doc.rootDoc()), reader -> {  
        assertExistsQuery(mapperService);
        final int positionIncrementGap = randomIntBetween(1, 1000);  
    }
                    b -> b.field("type", textFieldName)
        }));
            .numberOfShards(1)
        TextFieldMapper topLevel = (TextFieldMapper) mapperService.documentMapper().mappers().getMapper("desc");  
        TextFieldMapper textMapper = (TextFieldMapper) mapper.mappers().getMapper("field");
import org.opensearch.Version;  
        assertEquals(DocValuesType.NONE, fieldType.docValuesType());  
            b.startObject("other_field").field("type", "keyword").endObject();
        TextFieldMapper subA = (TextFieldMapper) mapperService.documentMapper().mappers().getMapper("parent.subA");
        assertTrue(fields[0].fieldType().omitNorms());
            assertEquals(0, postings.nextDoc());
            }  
            b.endObject();
        );
            assertThat(q, equalTo(expected));
                        b.endObject();
    public void testDisableIndex() throws IOException {
            assertThat(q, equalTo(mpq));
                    @Override
    }
        assertThat(serialized, containsString("\"docs\":{\"type\":\"text\",\"index_options\":\"docs\"}"));
        }  
                        .field("index_options", "freqs")
            b.endObject();
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();  
    public void testBWCSerialization() throws IOException {  
        assertThat(fieldType.fielddataMaxFrequency(), equalTo((double) Integer.MAX_VALUE));  
import org.opensearch.script.ScriptModule;
 * GitHub history for details.
 */  
        withLuceneIndex(mapperService, iw -> iw.addDocument(doc.rootDoc()), reader -> {  
                        new FieldMaskingSpanQuery(new SpanTermQuery(new Term("synfield._index_prefix", "dogs")), "synfield"),  
    }  
        }));
 * the Apache License, Version 2.0 (the "License"); you may
            assertEquals(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS, prefix.fieldType.indexOptions());
    public void testDefaultPositionIncrementGap() throws IOException {  
            b.endObject();  
                break;
                new BooleanQuery.Builder().add(  
                        .field("analyzer", "standard")  
            b.field("norms", false);
            b.field("index", false);  
import org.opensearch.index.analysis.AnalyzerScope;  
            assertEquals(positionIncrementGap + 2, postings.nextPosition());
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        TextFieldMapper multiField = (TextFieldMapper) mapperService.documentMapper().mappers().getMapper("app_name.analyzed");  
        assertTrue(mappingString.contains("search_quote_analyzer"));  
                .field("analyzer", "default")  
        MapperService mapperService = createMapperService(fieldMapping(this::minimalMapping));
        assertThat(doc.rootDoc().getField("field1").fieldType().storeTermVectorOffsets(), equalTo(false));
                .field("type", textFieldName)
            .settings(
            )  
        supportedOptions.put("offsets", IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS);
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.lucene.analysis.standard.StandardAnalyzer;
            () -> createMapperService(  
            b.field("search_analyzer", "keyword");  
            );
import org.junit.Before;
                iw.addDocument(createDocument("field", value, false, false));  
            FieldType ft = prefix.fieldType;  
        assertEquals(mapping.toString(), createDocumentMapper(mapping).mappingSource().toString());
        DocumentMapper mapper = createDocumentMapper(pluggableSettings, fieldMapping(b -> b.field("type", "text")));
            },
            {
import org.apache.lucene.index.IndexableFieldType;
            TermsEnum terms = getOnlyLeafReader(reader).terms("field._index_prefix").iterator();
            FieldMapper prefix = (FieldMapper) mapper.mappers().getMapper("field._index_prefix");
                String source = builder.toString();
            xContentRegistry(),
            "field",
        });
    }
import org.apache.lucene.search.SynonymQuery;
        assertThat(doc.rootDoc().getField("field1").fieldType().storeTermVectorPositions(), equalTo(false));
                .field("search_analyzer", "standard")
                                                                                                                         // this time
                .field("analyzer", "standard")  
                        .field("min_chars", 2)
            assertThat(q, equalTo(mpq));
            PostingsEnum postings = terms.postings(null, PostingsEnum.POSITIONS);  
    }
                fieldMapping(
            }  
        mapping = fieldMapping(b -> b.field("type", textFieldName).field("analyzer", "keyword").field("search_analyzer", "default"));
            FieldType ft = prefix.fieldType;  
            IndexableField[] fields = doc.rootDoc().getFields(field);  
 */  
        MapperService mapperService = createMapperService(fieldMapping(b -> {
        SimilarityService similarityService = new SimilarityService(indexSettings, scriptService, emptyMap());
        DocumentMapper mapper = createDocumentMapper(mapping);  
                        return new StopFilter(tokenStream, EnglishAnalyzer.ENGLISH_STOP_WORDS_SET);
                b.endObject();
            String value = "value";
    public void testFastPhrasePrefixes() throws IOException {
            TextFieldMapper mapper = getMapper(FieldMapper.CopyTo.empty(), false);  
            )
            TermsEnum terms = getOnlyLeafReader(reader).terms("field").iterator();  
        assertEquals(1, fields.length);
            assertEquals(positionIncrementGap + 2, postings.nextPosition());
        enabledMapper.fieldType("field").fielddataBuilder("test", () -> { throw new UnsupportedOperationException(); }); // no exception  
        });
                .field("search_quote_analyzer", "keyword")
        List<Map.Entry<MappedFieldType, Object>> captured = capturingDocInput.getCapturedFields();
        assertThat(
    }
                ).build()
    public void testNotIndexedFieldPositionIncrement() {  
        IndexableField[] fields = doc.rootDoc().getFields("field._index_phrase");  
            {
            b.startObject("fields");
            b.endObject();
                ).build()
                .endObject()  
        }
    }  
            assertThat(e.getMessage(), containsString("Cannot set index_prefixes on unindexed field [field]"));  
            );
        {
import static org.hamcrest.core.Is.is;  
            b.field("norms", false);
        assertEquals("b", fields[1].stringValue());
    }
            );  
            TermsEnum terms = getOnlyLeafReader(reader).terms("field").iterator();
        assertThat(doc.rootDoc().getField("field5").fieldType().storeTermVectorOffsets(), equalTo(true));  
                        .startObject("index_prefixes")  
            b.field("similarity", "BM25");
        MapperService mapperService = createMapperService(
import org.opensearch.core.xcontent.ToXContent;  
            assertEquals(100, ft.fielddataMinSegmentSize());
                new StandardTokenizerFactory(indexSettings, null, "standard", indexSettings.getSettings()),
                        }  
        assertFalse("nested multi-field inner should NOT be force-stored under derived_source", inner.fieldType.stored());  
        // Scenario 1: default text value
                    {
    public void testPossibleToDeriveSource_WhenCopyToPresent() throws IOException {  
import org.opensearch.common.xcontent.XContentFactory;  
            );  
                } }
        if (hasDocValues) {
        mapper.parse(source(b -> b.field("field", "hello world")), capturingDocInput);
                .endObject()  
        FieldMapper fieldMapper = (FieldMapper) mapper.mappers().getMapper("field");  
        assertExistsQuery(mapperService);
        DocumentMapper mapper = createDocumentMapper(pluggableSettings, mapping(b -> {
        }
                        b.field("type", "text");
            MapperParsingException.class,
            PostingsEnum postings = terms.postings(null, PostingsEnum.POSITIONS);  
            MultiPhrasePrefixQuery mpq = new MultiPhrasePrefixQuery("synfield");
        merge(mapperService, fieldMapping(b -> b.field("type", "text").field("store", false)));  
            }
        }  
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
        TextFieldMapper inner = (TextFieldMapper) mapperService.documentMapper().mappers().getMapper("parent.subA.inner");
                .field("index_phrases", true)
            b.endObject();
                        .startObject("index_prefixes")
public class TextFieldMapperTests extends MapperTestCase {
 */
        Map<String, IndexOptions> supportedOptions = new HashMap<>();  
                doc.add(new StoredField(name, value));
            assertThat(e.getMessage(), containsString("Cannot set position_increment_gap on field [field] without positions enabled"));
            MapperParsingException e = expectThrows(MapperParsingException.class, () -> createMapperService(fieldMapping(b -> {
                        .add(
}
        MapperService mapperService = createMapperService(fieldMapping(b -> b.field("type", "text").field("store", isStored)));
        Mapper phraseMapper = null;  
            b.field("type", textFieldName);
import org.apache.lucene.document.StoredField;  
            pluggableSettings,
            )
        for (Mapper m : textMapper) {
        Query q6 = matchQuery.parse(MatchQuery.Type.PHRASE, "synfield", "motor dogs");
    }
                .startObject("field5")
        // test default position_increment_gap
            {
        });  
        assertThat(doc.rootDoc().getField("field4").fieldType().storeTermVectorOffsets(), equalTo(false));
                        )
                    .endObject()  
        MapperService mapperService = createMapperService(startingMapping);  
            b.field("fielddata", true);
        }));
import org.opensearch.indices.IndicesModule;
            CharTermAttribute termAtt = ts.addAttribute(CharTermAttribute.class);
    }
                    .field("field4", "1234")  
            b -> b.field("type", textFieldName).startObject("index_prefixes").endObject().field("index_phrases", false)
            source(
        CapturingDocumentInput capturingDocInput = new CapturingDocumentInput();
            assertTrue(terms.seekExact(new BytesRef("b")));
                b.field("type", textFieldName);  
        e = expectThrows(  
        checker.registerUpdateCheck(b -> {  
                {
        );  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> merge(mapperService, differentPrefix));
                b.startObject("fields").startObject("_index_prefix").field("type", textFieldName).endObject().endObject();
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", textFieldName).field("store", true)));
                        return "stop";  
            );
        assertThat(q2, is(new PhraseQuery("field._index_phrase", "three words", "words here")));  
        {
            Query q = new MatchPhrasePrefixQueryBuilder("field", "three words here").toQuery(queryShardContext);  
        );  
import org.opensearch.core.common.Strings;
import org.opensearch.script.ScriptService;  
            MapperParsingException e = expectThrows(MapperParsingException.class, () -> createMapperService(fieldMapping(b -> {  
        FieldMapper prefixFieldMapper = (FieldMapper) prefixMapper;  
        );  
        checker.registerUpdateCheck(b -> {
import org.apache.lucene.search.TermQuery;  
            getPlugins().stream().filter(p -> p instanceof MapperPlugin).map(p -> (MapperPlugin) p).collect(toList())  
import org.opensearch.common.settings.Settings;
            assertEquals("Some English", termAtt.toString());
                    .field("position_increment_gap", positionIncrementGap)
        assertThat(serialized, containsString("\"freqs\":{\"type\":\"text\",\"index_options\":\"freqs\"}"));  
        merge(mapperService, newField);
            String field = entry.getKey();
                        .field("analyzer", "standard")  
        }));
import org.apache.lucene.search.BooleanClause;  
                b.field("analyzer", "standard"); // "standard" will be replaced with MockSynonymAnalyzer
                        .build(),  
    }
        IndexableField[] fields = doc.rootDoc().getFields("field");
        {  
                b.field("type", textFieldName).field("analyzer", "standard");  
    public void testFrequencyFilter() throws IOException {
            minimalMapping(b);
 * under the License.  
        }, m -> {  
            DocumentMapper mapper = createDocumentMapper(
                }  
        assertThat(mapperService.documentMapper().mappers().getMapper("field"), instanceOf(TextFieldMapper.class));
            MultiPhrasePrefixQuery mpq = new MultiPhrasePrefixQuery("field");
            b.field("search_analyzer", "keyword");
    @Override
        matchQuery.setAnalyzer(new MockSynonymAnalyzer());  
            IndexOptions options = entry.getValue();
import org.opensearch.plugins.ScriptPlugin;
        Query q = new MatchPhraseQueryBuilder("field", "two words").toQuery(queryShardContext);
            assertEquals(0, postings.nextDoc());
        assertEquals("b", fields[1].stringValue());
                fieldMapping(
        XContentBuilder mapping = fieldMapping(
                b.endObject();  
 * You may obtain a copy of the License at  
import org.apache.lucene.util.BytesRef;
        return mapper;
                .endObject()
            assertTrue(terms.seekExact(new BytesRef("12")));  
        CapturingDocumentInput docInput = new CapturingDocumentInput();
            assertEquals(prefix.name(), "field._index_prefix");  
            fieldMapping(b -> b.field("type", textFieldName).field("position_increment_gap", positionIncrementGap))  
            assertTrue(terms.seekExact(new BytesRef("12")));
            b.field("index", false);
                .addClause(new FieldMaskingSpanQuery(new SpanTermQuery(new Term("field._index_prefix", "stopword")), "field"))  
        MapperService mapperService2 = createMapperService(
            }  
            assertThat(mapper.mappers().getMapper("field._index_prefix").toString(), containsString("prefixChars=2:10"));
    public void testPluggableDataFormatTextValue() throws IOException {  
            b -> b.nullField("field"),  
        assertThat(e.getMessage(), containsString("Cannot set position_increment_gap on field [field]"));
 *
            DocumentMapper mapper = createDocumentMapper(  
            b.startObject("text_field");  
            {
            Query q = new MatchPhrasePrefixQueryBuilder("field", "two words").toQuery(queryShardContext);
                .startObject("field4")  
    public void testMultiFieldTextNotStoredForDerivedSource() throws IOException {
    }
                b.field("max_chars", 10);  
        }
                b.field("type", textFieldName);
        );  
                + "\"fielddata\":true,\"fielddata_frequency_filter\":{\"min\":0.001,\"max\":0.1,\"min_segment_size\":500},"  
                    b -> b.field("type", textFieldName)
    @Override
    public void testDefaultStoredFieldForDerivedSource() throws IOException {
        assertThat(doc.rootDoc().getField("field6").fieldType().storeTermVectorPositions(), equalTo(true));  
        NamedAnalyzer whitespace = new NamedAnalyzer("whitespace", AnalyzerScope.INDEX, new WhitespaceAnalyzer());
     * Helper method to create a document with both doc values and stored fields  
        boolean found = docInput.getCapturedFields()
            () -> createMapperService(fieldMapping(b -> b.field("type", textFieldName).field("index", false).field("fielddata", true)))
        Query q2 = new MatchPhraseQueryBuilder("field", "three words here").toQuery(queryShardContext);
        MapperRegistry mapperRegistry = new IndicesModule(
            )  
        assertThat(e.getMessage(), containsString("Text fields are not optimised for operations that require per-document field data"));  
            }));
            }
        TextFieldMapper textMapper = (TextFieldMapper) mapper.mappers().getMapper("field");
            mpq.add(new Term("field", "words"));
        assertTrue("Expected text sub-field captured with external value", found);
import org.apache.lucene.search.Query;
                b.startObject("index_prefixes").endObject();
        builder.value(1234);
            b.field("index_options", "offsets");
                .field("type", textFieldName)  
                b.field("analyzer", "my_stop_analyzer");  
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));
                        .field("analyzer", "standard")
    }  
        XContentBuilder mapping = MediaTypeRegistry.JSON.contentBuilder().startObject().startObject("_doc").startObject("properties");  
        XContentBuilder mappingBuilder,
        assertFalse(fieldType.stored());  
            getPlugins().stream().filter(p -> p instanceof ScriptPlugin).map(p -> (ScriptPlugin) p).collect(toList())
import java.util.List;
            );
    }
        for (String option : supportedOptions.keySet()) {
        Query q4 = new MatchPhraseQueryBuilder("field", "singleton").toQuery(queryShardContext);
            () -> createMapperService(
            b.startObject("meta");  
            .stream()
        // special case: default index/search analyzer  
        checker.registerUpdateCheck(b -> b.field("eager_global_ordinals", "true"), m -> assertTrue(m.fieldType().eagerGlobalOrdinals()));  
            AnalyzerScope.INDEX,
        }));
        }
        if (!textFieldName.equals(MatchOnlyTextFieldMapper.CONTENT_TYPE)) {  
            DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", textFieldName).nullField("index_prefixes")));  
        final int positionIncrementGap = randomIntBetween(1, 1000);
            assertEquals(10, ft.fielddataMinFrequency(), 0);
            if (m.name().endsWith("._index_phrase")) {
            q7,
        Exception e = expectThrows(
        MapperService mapperService = createMapperService(
                b.field("type", textFieldName).field("analyzer", "standard");
        }  
    public void testPositionIncrementGap() throws IOException {  
                b.field("index_phrases", true);
        // subB is built AFTER subA's nested multi-field build; without save/restore of the multiField
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);  
import static org.hamcrest.Matchers.instanceOf;
        assertThat(serialized, containsString("\"offsets\":{\"type\":\"text\",\"index_options\":\"offsets\"}"));
            "hello world"
                .field("term_vector", "with_positions")
    protected void writeFieldValue(XContentBuilder builder) throws IOException {  
                .field("term_vector", "no")
        // Pluggable path  
            fieldMapping(  
            checker.registerConflictCheck("index_options", b -> b.field("index_options", "docs"));
    }
            Query expected = new SpanNearQuery.Builder("field", true).addClause(new SpanTermQuery(new Term("field", "sparkle")))
import org.opensearch.index.analysis.TokenFilterFactory;  
import org.apache.lucene.queries.spans.SpanTermQuery;
            checker.registerConflictCheck("index_prefixes", b -> b.startObject("index_prefixes").endObject());  
        assertThat(mapperService.documentMapper().mappers().getMapper("other_field"), instanceOf(KeywordFieldMapper.class));  
    }  
        String fieldName,
            assertEquals(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS, ft.indexOptions());
    }
        b.field("type", textFieldName);
                .startObject("index_prefixes")
            }
            })));
                b -> b.field("type", "text")  
        checker.registerConflictCheck("term_vector", b -> b.field("term_vector", "yes"));
        );
            }
import java.util.HashMap;  
            PostingsEnum postings = terms.postings(null, PostingsEnum.POSITIONS);
 * this file be licensed under the Apache-2.0 license or a
                    b.startObject("analyzed").field("type", "text").field("store", false).endObject();
        );  
        };  
                b.value("target");
                b -> b.field("field1", "1234")  
            assertEquals(prefix.name(), "field._index_prefix");  
        {
        pluggableMapper.parse(source(sourceBuilder), docInput);  
                .endObject();
import org.apache.lucene.index.DocValuesType;
        if (!textFieldName.equals("match_only_text")) {
    }  
        DocumentMapper mapper = createDocumentMapper(
        assertThat(fieldType.storeTermVectorOffsets(), equalTo(false));  
    public void testPluggableDataFormatPhraseFieldMapperThrows() throws IOException {
        assertEquals(mapping.toString(), createDocumentMapper(mapping).mappingSource().toString());
            assertFalse("Pluggable path should produce no field for '" + fieldName + "'", pluggableHasField);
                + "\"copy_to\":[\"target\"],\"meta\":{\"unit\":\"min\"},\"index_options\":\"offsets\",\"term_vector\":\"yes\",\"norms\":false,"
    }
     */
 * Licensed to Elasticsearch under one or more contributor  
        {
                b.startObject("index_prefixes").field("min_chars", 1).field("max_chars", 10).endObject();
                            BooleanClause.Occur.SHOULD
 *  
        }
            MapperParsingException.class,
import org.apache.lucene.index.TermsEnum;
        assertThat(e.getMessage(), containsString("Cannot update parameter [index_phrases]"));
        supportedOptions.put("freqs", IndexOptions.DOCS_AND_FREQS);
    public void testSimpleMerge() throws IOException {
        assertThat(q4, is(new TermQuery(new Term("field", "singleton"))));  
                b.field("min_chars", 1);
                    @Override  
        assertThat(fieldType.storeTermVectors(), equalTo(false));
    }
            TermsEnum terms = getOnlyLeafReader(reader).terms("field").iterator();
                b.startObject("fields");  
        }
                    .endObject()
        for (String indexOptions : Arrays.asList("docs", "freqs")) {
                    .field("fielddata", true)
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();  
                b.field("min_segment_size", 100);  
            () -> {
        assertThat(fieldType.fielddataMinFrequency(), equalTo(2d));
        // BuilderContext is saved and restored across nested builds, so a nested multi-field build  
                b.field("max", 20);
    }
        MapperService mapperService = createMapperService(fieldMapping(b -> {
            // as multi-fields are never used for derived-source reconstruction
            assertThat(q, equalTo(expected));
                builder.endObject();  
        MapperService mapperService = createMapperService(mapping(b -> {
        mapper.parse(source(b -> b.field("text_field", "external_text")), docInput);
        XContentBuilder builder = MediaTypeRegistry.JSON.contentBuilder();
        e = expectThrows(IllegalArgumentException.class, () -> merge(mapperService, differentPhrases));
            assertEquals(20, ft.fielddataMaxFrequency(), 0);  
    }
            })));  
            Map.of("default", dflt, "standard", standard, "keyword", keyword, "whitespace", whitespace, "my_stop_analyzer", stop),
            }
            MapperParsingException e = expectThrows(MapperParsingException.class, () -> createMapperService(fieldMapping(b -> {
        assertFalse("multi-field subB after a nested multi-field should NOT be force-stored", subB.fieldType.stored());
        assertThat(doc.rootDoc().getField("field6").fieldType().storeTermVectorPayloads(), equalTo(true));
        // Lucene path
        assertEquals(mapping.toString(), createDocumentMapper(mapping).mappingSource().toString());  
        MapperService mapperService = createDerivedSourceMapperService();
        Query q7 = matchQuery.parse(MatchQuery.Type.BOOLEAN, "synfield", "foo");
        Analyzer synonymAnalyzer = new Analyzer() {
            ParsedDocument doc = mapper.parse(source(b -> b.field("field", "Some English text that is going to be very useful")));
                mapper.deriveSource(builder, reader.leaves().get(0).reader(), 0);
            DocumentMapper mapper = createDocumentMapper(
        );  
                MapperParsingException.class,
import org.opensearch.indices.mapper.MapperRegistry;
            b.startObject("index_prefixes");  
        mapper.parse(source(b -> b.nullField("field")), capturingDocInput);
        assertThat(doc.rootDoc().getField("field4").fieldType().storeTermVectorPositions(), equalTo(true));
        MapperService mapperService = createMapperService(fieldMapping(b -> {
        NamedAnalyzer standard = new NamedAnalyzer("standard", AnalyzerScope.INDEX, new StandardAnalyzer());  
        assertTrue(fields[0].fieldType().stored());
import org.apache.lucene.analysis.Analyzer;
            FieldMapper prefix = (FieldMapper) mapper.mappers().getMapper("field._index_prefix");
import org.apache.lucene.store.Directory;
            TermsEnum terms = getOnlyLeafReader(reader).terms("field._index_prefix").iterator();
        Mapper prefixMapper = null;  
            createIndexAnalyzers(indexSettings),
            Query q = matchQuery.parse(MatchQuery.Type.PHRASE_PREFIX, "synfield", "two dogs");  
        );
            e.getMessage(),
        checker.registerUpdateCheck(b -> b.field("boost", 2.0), m -> assertEquals(m.fieldType().boost(), 2.0, 0));  
                .field("type", textFieldName)  
        {
    public void testFielddata() throws IOException {
import org.apache.lucene.queries.spans.SpanOrQuery;
            minimalMapping(b);  
            Query q = new MatchPhrasePrefixQueryBuilder("field", "sparkle a stopword").toQuery(queryShardContext);  
    protected IndexAnalyzers createIndexAnalyzers(IndexSettings indexSettings) {
            mapping.startObject(option).field("type", textFieldName).field("index_options", option).endObject();
        assertThat(mapperService.documentMapper().mappers().getMapper("field"), instanceOf(TextFieldMapper.class));
import org.apache.lucene.index.IndexWriter;
            assertEquals(0, postings.nextDoc());  
            })));
        supportedOptions.put("positions", IndexOptions.DOCS_AND_FREQS_AND_POSITIONS);  
                b.field("min_segment_size", 500);
            MapperParsingException.class,
        ParsedDocument luceneDoc = luceneMapper.parse(source(sourceBuilder));  
                b.field("type", textFieldName);  
        FieldMapper phraseFieldMapper = (FieldMapper) phraseMapper;  
                .field("type", textFieldName)  
        assertParseMinimalWarnings();  
    private MapperService createDerivedSourceMapperService() throws IOException {  
            indexSettings,  
        assertThat(doc.rootDoc().getField("field3").fieldType().storeTermVectorOffsets(), equalTo(true));
        String serialized = Strings.toString(MediaTypeRegistry.JSON, mapper);
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));
        assertThat(doc.rootDoc().getField("field2").fieldType().storeTermVectorPayloads(), equalTo(false));
            PostingsEnum postings = terms.postings(null, PostingsEnum.POSITIONS);  
        }
            b.field("norms", false);  
        DocumentMapper luceneMapper = createDocumentMapper(mappingBuilder);
import org.opensearch.common.util.FeatureFlags;
import static java.util.Collections.emptyMap;
        assertThat(  
        assertEquals(2, fields.length);
                )  
        return new MapperService(
        IndexableField[] fields = doc.rootDoc().getFields("field");  
import static org.hamcrest.Matchers.containsString;  
                .field("term_vector", "with_positions_offsets_payloads")
 * ownership. Elasticsearch licenses this file to you under  
        );  
                return new TokenStreamComponents(reader -> {}, cts);
import org.apache.lucene.analysis.core.KeywordAnalyzer;
            doc.add(new SortedSetDocValuesField(name, binaryValue));  
            .numberOfReplicas(0)
    }
                .field("type", textFieldName)
            matchQuery.setPhraseSlop(1);
import org.apache.lucene.tests.analysis.CannedTokenStream;
            () -> true,
            new ToXContent.MapParams(Collections.singletonMap("include_defaults", "true"))  
    }
        checker.registerUpdateCheck(b -> {
package org.opensearch.index.mapper;
    }
            Map.of(),  
        CapturingDocumentInput docInput = new CapturingDocumentInput();
        IndexableFieldType fieldType = fields[0].fieldType();  
            b.endObject();  
                )  
                + "\"index_prefixes\":{\"min_chars\":1,\"max_chars\":10},\"index_phrases\":true}}}}",
            "default",
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
                fieldMapping(
        MapperService disabledMapper = createMapperService(fieldMapping(this::minimalMapping));
            PostingsEnum postings = terms.postings(null, PostingsEnum.POSITIONS);
            assertThat(q, equalTo(expected));
    public void testDefaults() throws IOException {
        }));
                        .startObject("index_prefixes")  
            assertTrue("Lucene path should produce field '" + fieldName + "'", luceneFields.length > 0);
            assertFalse(ft.storeTermVectors());
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
            matchQuery.setAnalyzer(new MockSynonymAnalyzer());
                .startObject("index_prefixes")
            protected TokenStreamComponents createComponents(String fieldName) {  
            assertThat(mapper.mappers().getMapper("field._index_prefix").toString(), containsString("prefixChars=2:5"));
                .addClause(
                b.field("norms", false);
            // norms can be set from true to false, but not vice versa
            () -> createDocumentMapper(fieldMapping(b -> b.field("type", textFieldName).field("analyzer", (String) null)))
            b.field("position_increment_gap", 0);
                b.field("min", 0.001);
            )
        IndexableField[] fields = doc.rootDoc().getFields("field");  
            }
            FieldMapper prefix = (FieldMapper) mapper.mappers().getMapper("field._index_prefix");  
        );
                    b -> b.field("type", textFieldName)
                        .endObject()
        assertWarnings(
                + "Defining multi-fields within a multi-field is deprecated and will no longer be supported in 8.0. "  
    public void testSearchAnalyzerSerialization() throws IOException {  
            assertTrue(terms.seekExact(new BytesRef("b")));
            )  
        Settings pluggableSettings,
        assertThat(fieldType.storeTermVectorPayloads(), equalTo(false));
            )
        TextFieldMapper textFieldMapper = (TextFieldMapper) mapperService.documentMapper().mappers().getMapper("field");
            pluggableSettings,
        });  
                        b -> b.field("type", textFieldName).field("index_options", indexOptions).field("position_increment_gap", 10)
        assertExistsQuery(mapperService);  
                }
        }
        withLuceneIndex(mapperService2, iw -> iw.addDocument(doc2.rootDoc()), reader -> {
import org.apache.lucene.analysis.en.EnglishAnalyzer;  
        assertTrue(prefixMapper instanceof FieldMapper);
        XContentBuilder differentPhrases = fieldMapping(
        withLuceneIndex(mapperService2, iw -> iw.addDocument(doc2.rootDoc()), reader -> {  
        mapping = fieldMapping(b -> b.field("type", textFieldName).field("analyzer", "default").field("search_analyzer", "keyword"));
            assertEquals(1, fields.length);  
                    b -> b.field("type", textFieldName)
        assertTrue(fieldType.tokenized());
    public void setup() {
    }
    }
            "At least one multi-field, [subA], was encountered that itself contains a multi-field. "
            b.endObject();
        assertThat(doc.rootDoc().getField("field5").fieldType().storeTermVectors(), equalTo(true));
                        .endObject()
            MapperParsingException.class,  
        {
        NamedAnalyzer stop = new NamedAnalyzer(  
    ) throws IOException {  
        NamedAnalyzer keyword = new NamedAnalyzer("keyword", AnalyzerScope.INDEX, new KeywordAnalyzer());
        final BytesRef binaryValue = new BytesRef(value);
        ParsedDocument doc2 = mapperService2.documentMapper().parse(source(b -> b.array("field", new String[] { "a", "b 12" })));
        );
 *
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
        // Multi-fields within multi-fields are deprecated but still allowed. The multiField flag on
        assertEquals(mapping.toString(), createDocumentMapper(mapping).mappingSource().toString());
                        .field("term_vector", "with_positions_offsets")  
                    new SpanOrQuery(
import org.opensearch.cluster.metadata.IndexMetadata;
    public final void testExistsQueryIndexDisabled() throws IOException {  
            assertEquals(0, postings.nextDoc());
        CannedTokenStream cts = new CannedTokenStream(new Token("foo", 1, 0, 2, 2), new Token("bar", 0, 0, 2), new Token("baz", 1, 0, 2));  
        {
                        {
            b.startObject("fielddata_frequency_filter");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));
            }
        supportedOptions.put("docs", IndexOptions.DOCS);
        DocumentMapper defaultMapper = createDocumentMapper(mapping);
                .endObject();
    }  
                + "\"similarity\":\"BM25\",\"eager_global_ordinals\":true,\"position_increment_gap\":0,"
        if (expectedValue == null) {
        {  
import java.util.Collections;
                )
import org.apache.lucene.analysis.TokenStream;  
                    )
        DocumentMapper pluggableMapper = createDocumentMapper(pluggableSettings, mappingBuilder);
        assertEquals("1234", fields[0].stringValue());
                    BooleanClause.Occur.SHOULD
                .startObject("field2")
                        .field("term_vector", "with_positions")
 * specific language governing permissions and limitations
        }));  
        ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.array("field", new String[] { "a", "b 12" })));
        });  
            )
        assertThat(doc.rootDoc().getField("field3").fieldType().storeTermVectorPositions(), equalTo(false));  
            {
            assertEquals(1, fields.length);
        merge(mapperService, mapping(b -> {
                b.field("norms", false);
            assertEquals(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS, ft.indexOptions());
            assertEquals(positionIncrementGap + 1, postings.nextPosition());
                fieldMapping(b -> b.field("type", textFieldName).field("index", false).field("position_increment_gap", 10))
    public final void testExistsQueryIndexDisabledStoreTrue() throws IOException {
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            TermsEnum terms = getOnlyLeafReader(reader).terms("field").iterator();
        }
    }
        return new IndexAnalyzers(
 * license agreements. See the NOTICE file distributed with
            new CustomAnalyzer(  
        String expectedValue
            assertNull(mapper.mappers().getMapper("field._index_prefix"));
            )
        Exception e = expectThrows(
            assertEquals("Lucene path should produce no field for '" + fieldName + "'", 0, luceneFields.length);  
        );  
                b.field("type", textFieldName);
                b.field("type", textFieldName);  
        assertParseMinimalWarnings();  
        }  
            fieldMapping(
        {
        assertEquals("a", fields[0].stringValue());  
        MapperService mapperService = createMapperService(
        }  
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
                        .endObject()
            b.endObject();
        assertThat(fieldType.fielddataMinSegmentSize(), equalTo(1000));
                .endObject()
                            new PhraseQuery.Builder().add(new Term("synfield._index_phrase", "bar baz")).build(),  
        );
        Query q3 = new MatchPhraseQueryBuilder("field", "two words").slop(1).toQuery(queryShardContext);
                + "from the mappings, either by flattening the chained [fields] blocks into a single level, or "
            {  
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", textFieldName).field("index", false)));  
        }  
        ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.array("field", new String[] { "a", "b" })));
            b.startObject("desc").field("type", "text").field("store", false).endObject();  
                b.field("norms", true);
    }  
            pluggableSettings,
    public void testDisableNorms() throws IOException {  
        assertTrue(captured.stream().anyMatch(e -> e.getKey().name().equals("field") && e.getValue().equals("hello world")));
        }
        );
            b.field("fielddata", true);  
                fieldMapping(b -> b.field("type", textFieldName).field("index_options", "freqs").field("index_phrases", true))  
            );
import org.apache.lucene.tests.analysis.MockSynonymAnalyzer;  
            }
    }  
        assertThat(doc.rootDoc().getField("field1").fieldType().storeTermVectorPayloads(), equalTo(false));  
            is(
        // must not clear the flag for sibling sub-fields of the outer build (subB below).
        // Scenario 2: null value — no field produced
        MapperService enabledMapper = createMapperService(fieldMapping(b -> b.field("type", textFieldName).field("fielddata", true)));
        IndexMetadata build = IndexMetadata.builder("test_index")
        assertThat(doc.rootDoc().getField("field6").fieldType().storeTermVectors(), equalTo(true));
                .addClause(new SpanTermQuery(new Term("field", "words")))
                .field("term_vector", "with_positions_offsets")  
                b.field("max", 0.1);  
                )  
                        .field("index_options", "positions")
        TextFieldMapper subB = (TextFieldMapper) mapperService.documentMapper().mappers().getMapper("parent.subB");
        assertThat(q5, is(new PhraseQuery.Builder().add(new Term("field", "sparkle")).add(new Term("field", "stopword"), 2).build()));  
import org.apache.lucene.tests.analysis.Token;
            MatchQuery matchQuery = new MatchQuery(queryShardContext);  
                    }  
        assertTrue("top-level text field should be force-stored under derived_source", topLevel.fieldType.stored());
            assertEquals(0, postings.nextDoc());
    }
            assertTrue("Pluggable path should capture field '" + fieldName + "' with value '" + expectedValue + "'", pluggableFound);
            DocumentMapper mapper = createDocumentMapper(
        assertThat(e.getMessage(), containsString("Cannot update parameter [index_prefixes]"));
            {
            b.field("eager_global_ordinals", true);
            if (forKeyword) {
    }
        );
                XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
                b.field("type", textFieldName).field("analyzer", "standard").field("index", false);  
            MultiPhrasePrefixQuery mpq = new MultiPhrasePrefixQuery("field");
        checker.registerConflictCheck("index", b -> b.field("index", false));
            Query q = new MatchPhrasePrefixQueryBuilder("field", "singleton").toQuery(queryShardContext);  
        XContentBuilder startingMapping = fieldMapping(  
            assertThat(e.getMessage(), containsString("max_chars [25] must be less than 20"));
            b -> b.startObject("field1")  
        );  
    private TextFieldMapper getMapper(FieldMapper.CopyTo copyTo, boolean isStored) throws IOException {
import org.opensearch.index.query.QueryShardContext;
                .endObject()
            PostingsEnum postings = terms.postings(null, PostingsEnum.POSITIONS);  
        ).getMapperRegistry();
            Query expected = new SpanNearQuery.Builder("field", true).addClause(new SpanTermQuery(new Term("field", "three")))
        TextFieldType fieldType = (TextFieldType) mapperService.fieldType("field");  
            Query q = new MatchPhrasePrefixQueryBuilder("field", "motor d").toQuery(queryShardContext);  
    public void testNestedMultiFieldTextNotStoredForDerivedSource() throws IOException {
    }  
            b.startObject("field")
            b.field("store", true);  
        assertEquals(0, fields.length);  
                    }
                assertEquals("{\"" + "field" + "\":" + "\"" + value + "\"" + "}", source);
                b.startObject("index_prefixes").field("min_chars", 0).field("max_chars", 10).endObject();  
        }
            Query q = matchQuery.parse(MatchQuery.Type.PHRASE_PREFIX, "synfield", "motor dogs");
            b.field("index_phrases", true);
                b.field("norms", true);
        TextFieldMapper mapper = getMapper(copyTo, false);
            b.field("term_vector", "yes");
                    b -> b.field("type", textFieldName)
            }), fieldMapping(b -> {
                    public String name() {
        ScriptService scriptService = new ScriptService(getIndexSettings(), scriptModule.engines, scriptModule.contexts);  
    public void testIndexOptions() throws IOException {
            DocumentMapper mapper = createDocumentMapper(
        );  
    }  
                    }
        {
            assertEquals(TextFieldMapper.Defaults.POSITION_INCREMENT_GAP + 2, postings.nextPosition());
                        .endObject()
        assertThat(doc.rootDoc().getField("field4").fieldType().storeTermVectors(), equalTo(true));  
                .endObject()
    }
                throw new UnsupportedOperationException();  
import org.apache.lucene.index.Term;  
                new TokenFilterFactory[] { new TokenFilterFactory() {  
            checker.registerConflictCheck("norms", fieldMapping(b -> {
                .build();
        }
                b.startObject("index_prefixes").field("min_chars", 11).field("max_chars", 10).endObject();
                    .field("field2", "1234")
                b.field("min", 10);
            containsString("[analyzer] on mapper [field] of type [" + textFieldName + "] must not have a [null] value")
            mpq.add(new Term("field", "two"));  
        assertEquals("a", fields[0].stringValue());  
        assertTextLuceneAndPluggablePathsEquivalent(  
 * SPDX-License-Identifier: Apache-2.0
        assertThat(q, is(new PhraseQuery("field._index_phrase", "two words")));  
                b.field("type", "keyword");
            new StandardAnalyzer(),  
/*  
        assertThat(fieldType.indexOptions(), equalTo(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS));
        for (Map.Entry<String, IndexOptions> entry : supportedOptions.entrySet()) {  
                            b.startObject("inner").field("type", "text").endObject();
    /**
        TextFieldMapper mapper = (TextFieldMapper) mapperService.documentMapper().mappers().getMapper("field");  
    public void testDerivedValueFetching_StoredField() throws IOException {
            for (String option : supportedOptions.keySet()) {
            }
        }  
        assertTrue(captured.stream().noneMatch(e -> e.getKey().name().equals("field")));
                fieldMapping(  
                    .field("analyzer", "default")
            assertThat(e.getMessage(), containsString("min_chars [0] must be greater than zero"));
    }
import static java.util.stream.Collectors.toList;
                )  
            b.endObject();  
                    public TokenStream create(TokenStream tokenStream) {
                )
        assertTrue(textFieldMapper.fieldType.stored());
        checker.registerConflictCheck("store", b -> b.field("store", true));  
        assertWarnings("Parameter [boost] on field [field] is deprecated and will be removed in 3.0");  
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", textFieldName).field("norms", false)));
            // keyword field with a text multi-field: the multi-field must NOT be force-stored,
        checker.registerUpdateCheck(b -> b.field("fielddata", true), m -> {
            q6,  
            assertThat(e.getMessage(), containsString("min_chars [11] must be less than max_chars [10]"));  
            FieldMapper prefix = (FieldMapper) mapper.mappers().getMapper("field._index_prefix");
        {
                        .field("index_options", "offsets")
        assertThat(doc.rootDoc().getField("field2").fieldType().storeTermVectorPositions(), equalTo(false));
        XContentBuilder mapping = mapping(
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
                () -> createDocumentMapper(
            Query expected = new SpanNearQuery.Builder("field", true).addClause(new SpanTermQuery(new Term("field", "two")))
                        .field("analyzer", "standard")
            b.endObject();
                        new FieldMaskingSpanQuery(new SpanTermQuery(new Term("synfield._index_prefix", "dog")), "synfield")
        });
        });
                .build();
        checker.registerConflictCheck("similarity", b -> b.field("similarity", "boolean"));  
        Query q5 = new MatchPhraseQueryBuilder("field", "sparkle a stopword").toQuery(queryShardContext);
        assertThat(fieldType.omitNorms(), equalTo(false));
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
                .field("min_chars", "3")  
import org.apache.lucene.index.IndexableField;  
            assertEquals(prefix.name(), "field._index_prefix");
            })));
            mapperRegistry,
            TextFieldMapper.Defaults.POSITION_INCREMENT_GAP
        assertNotNull("Expected phrase sub-mapper", phraseMapper);
        }));
    @Override  
        );
                b.field("type", textFieldName).field("analyzer", "standard");
        }
                .field("index_phrases", true)
import org.apache.lucene.queries.spans.SpanNearQuery;  
            boolean pluggableFound = docInput.getCapturedFields()
                .endObject()
        withLuceneIndex(mapperService, iw -> iw.addDocument(doc.rootDoc()), reader -> {  
        assertThrows(UnsupportedOperationException.class, mapper::canDeriveSource);  
            }
        Document doc = new Document();  
import org.apache.lucene.index.IndexWriterConfig;
                .field("search_quote_analyzer", "keyword")
                    .startObject("index_prefixes")  
        CheckedConsumer<XContentBuilder, IOException> sourceBuilder,  
        Exception e = expectThrows(
            b.startObject("app_name");  
                .anyMatch(e -> e.getKey().name().equals(fieldName) && e.getValue().equals(expectedValue));  
    private Document createDocument(String name, String value, boolean forKeyword, boolean hasDocValues) {
                b.startObject("subfield").field("type", "long").endObject();  
                    b -> b.field("type", textFieldName)  
            assertThat(e.getMessage(), containsString("Field [field._index_prefix] is defined more than once"));
        XContentBuilder mapping = fieldMapping(
                doc.add(new StoredField(name, binaryValue));  
            mpq.add(new Term("synfield", "two"));  
                b.field("unit", "min");
            }, m -> assertFalse(m.fieldType().getTextSearchInfo().hasNorms()));  
                        .endObject()  
            IndexableField[] fields = doc.rootDoc().getFields("field._index_prefix");
                .addClause(new FieldMaskingSpanQuery(new SpanTermQuery(new Term("field._index_prefix", "words")), "field"))  
                    b.startObject("subA");  
            Exception e = expectThrows(  
    public final void testExistsQueryWithNorms() throws IOException {  
            mpq.add(new Term[] { new Term("synfield", "dogs"), new Term("synfield", "dog") });
            fieldMapping(b -> b.field("type", textFieldName).field("eager_global_ordinals", true))  
        assertNotNull("Expected prefix sub-mapper", prefixMapper);
import org.apache.lucene.queries.spans.FieldMaskingSpanQuery;
    @Before  
            Map.of()
        );  
                .field("search_analyzer", "default")
            try (DirectoryReader reader = DirectoryReader.open(directory)) {  
                b -> b.field("type", textFieldName)
                    new BooleanQuery.Builder().add(new TermQuery(new Term("synfield", "foo")), BooleanClause.Occur.SHOULD)
    public String textFieldName = "text";
        }
        }
        IndexableField[] fields = doc.rootDoc().getFields("field");  
import org.apache.lucene.analysis.StopFilter;
        expectThrows(UnsupportedOperationException.class, () -> prefixFieldMapper.parseCreateFieldForPluggableFormat(null));
        }  
        assertThat(mapperService.documentMapper().mappers().getMapper("field"), instanceOf(TextFieldMapper.class));
        }
import org.opensearch.core.xcontent.MediaTypeRegistry;
                is(new SynonymQuery.Builder("field._index_prefix").addTerm(new Term("field._index_prefix", "singleton")).build())  
            MatchQuery matchQuery = new MatchQuery(queryShardContext);  
            b.startObject("fields");
                    b.startObject("subB").field("type", "text").endObject();
        try (TokenStream ts = fields[0].tokenStream(queryShardContext.getMapperService().indexAnalyzer(), null)) {  
                    .field("min_segment_size", 1000)
        assertTrue(mappingString.contains("search_analyzer"));
        );
            b.endObject();
import org.apache.lucene.search.PhraseQuery;  
import org.apache.lucene.search.MultiPhraseQuery;
                b.startObject("index_prefixes").field("min_chars", 2).field("max_chars", 10).endObject();  
        assertThat(doc.rootDoc().getField("field3").fieldType().storeTermVectors(), equalTo(true));
                new CharFilterFactory[0],
            MapperParsingException.class,
import static org.hamcrest.Matchers.equalTo;
            b.startObject("field")
            is(
    protected void minimalMapping(XContentBuilder b) throws IOException {  
 * this work for additional information regarding copyright
        }  
        );
 * compatible open source license.
                    .field("min", 2d)
        assertThat(e.getMessage(), containsString("Cannot enable fielddata on a [text] field that is not indexed"));
            assertThat(q, equalTo(expected));
            assertEquals(prefix.name(), "field._index_prefix");
                phraseMapper = m;  
        ScriptModule scriptModule = new ScriptModule(
            {  
                .build();
        );  
                        .startObject("index_prefixes")  
                .field("type", textFieldName)
            );
                .field("type", textFieldName)
                        .startObject("index_prefixes")
            // top-level text field: still force-stored (it is walked by _source reconstruction)
            }
            fieldMapping(b -> b.field("type", "text").field("index_prefixes", new java.util.HashMap<>()))  
    public void testAnalyzedFieldPositionIncrementWithoutPositions() {
        assertThat(q3, is(new PhraseQuery(1, "field", "two", "words")));  
                break;
    }
            }, b -> {  
            throw new UnsupportedOperationException();
            assertThat(
                .field("type", textFieldName)
import java.io.IOException;  
            assertEquals(prefix.name(), "field._index_prefix");
import org.apache.lucene.index.IndexOptions;  
        assertFalse("text multi-field should NOT be force-stored under derived_source", multiField.fieldType.stored());
import org.apache.lucene.document.SortedSetDocValuesField;
        List<Map.Entry<MappedFieldType, Object>> captured = capturingDocInput.getCapturedFields();
            b.field("search_quote_analyzer", "keyword");
                )
    }
            minimalMapping(b);
    }
        Exception e = expectThrows(IllegalArgumentException.class, () -> disabledMapper.fieldType("field").fielddataBuilder("test", () -> {  
        ParsedDocument doc = mapperService.documentMapper()  
        assertEquals(fieldMapping(this::minimalMapping).toString(), mapper.mappingSource().toString());  
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
                prefixMapper = m;  
    public void testSearchQuoteAnalyzerSerialization() throws IOException {  
        createDocumentMapper(fieldMapping(this::minimalMapping)).toXContent(
        return doc;
            FieldType ft = prefix.fieldType;
 * software distributed under the License is distributed on an
    public void testPositionIncrementGapOnIndexPrefixField() throws IOException {  
        MapperService mapperService = createDerivedSourceMapperService();
        builder.startObject();  
                b.field(option, "1234");
 * KIND, either express or implied.  See the License for the
        assertThat(e.getMessage(), containsString("Cannot set index_phrases on unindexed field [field]"));
            }  
        } else {  
            builder,
                new MultiPhraseQuery.Builder().add(
        {  
            assertEquals(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS, ft.indexOptions());  
import org.opensearch.index.analysis.CharFilterFactory;
import org.apache.lucene.document.FieldType;
            .parse(source(b -> b.field("field", "Some English text that is going to be very useful")));
import org.apache.lucene.search.BooleanQuery;
        assertEquals(1, fields.length);
                fieldMapping(b -> b.field("type", textFieldName).field("analyzer", "standard").startObject("index_prefixes").endObject())
            fieldMapping(b -> b.field("type", "text")),
        assertEquals(2, fields.length);
                .startObject("field6")
            }
        try (Directory directory = newDirectory()) {
    public void testEnableStore() throws IOException {  
import org.opensearch.index.search.MatchQuery;
            fieldMapping(b -> b.field("type", "text").field("analyzer", "default").startObject("index_prefixes").endObject())  
            );  
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);
        assertEquals(mapping.toString(), createDocumentMapper(mapping).mappingSource().toString());
        assertThat(doc.rootDoc().getField("field6").fieldType().storeTermVectorOffsets(), equalTo(true));
        CapturingDocumentInput capturingDocInput = new CapturingDocumentInput();
        checker.registerConflictCheck("analyzer", b -> b.field("analyzer", "keyword"));
            similarityService,  
                .addClause(new FieldMaskingSpanQuery(new SpanTermQuery(new Term("field._index_prefix", "here")), "field"))  
    protected void registerParameters(ParameterChecker checker) throws IOException {
        assertThat(doc.rootDoc().getField("field1").fieldType().storeTermVectors(), equalTo(false));  
        assertTextLuceneAndPluggablePathsEquivalent(  
    }  
        ParsedDocument doc = defaultMapper.parse(
    public void testPluggablePathEquivalenceWithLucenePath() throws IOException {
        {
import org.opensearch.index.query.MatchPhrasePrefixQueryBuilder;
            mpq.setSlop(1);
            "my_stop_analyzer",
import org.apache.lucene.index.DirectoryReader;
            assertEquals(options, fields[0].fieldType().indexOptions());
        );  
        assertThat(doc.rootDoc().getField("field4").fieldType().storeTermVectorPayloads(), equalTo(false));  
        IndexableField[] fields = doc.rootDoc().getFields("field");
        DocumentMapper mapper = createDocumentMapper(pluggableSettings, fieldMapping(b -> b.field("type", "text")));
                b.startObject("index_prefixes").field("min_chars", 1).field("max_chars", 25).endObject();
            mpq.add(new Term("field", "d"));  
        );  
        IndexableField[] fields = doc.rootDoc().getFields("field");
import org.opensearch.index.analysis.NamedAnalyzer;
        });  
            }
        assertFalse("multi-field subA should NOT be force-stored under derived_source", subA.fieldType.stored());  
                .addGap(1)
        XContentBuilder newField = mapping(b -> {
        IndexableField[] luceneFields = luceneDoc.rootDoc().getFields(fieldName);
    private void assertTextLuceneAndPluggablePathsEquivalent(  
        mapper.copyTo = copyTo;
                    fieldMapping(  
                + "switching to [copy_to] if appropriate."  
        assertTrue(phraseMapper instanceof FieldMapper);
            .build();  
    public void testTermVectors() throws IOException {
        }  
                        .field("analyzer", "standard")
        });  
            mpq.setSlop(1);
                        .startObject("index_prefixes")
    public void testPluggableDataFormatTextWithExternalValue() throws IOException {  
            assertTrue(ts.incrementToken());  
        textFieldName = "text";
        );
            } else {
                .startObject("field3")
        );
        assertEquals(
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        }));  
            b.startArray("copy_to");
            TextFieldType ft = (TextFieldType) m.fieldType();
    }
        NamedAnalyzer dflt = new NamedAnalyzer(  
            b.startObject("parent");
    public void testFastPhraseMapping() throws IOException {
                        .endObject()
        assertThat(doc.rootDoc().getField("field3").fieldType().storeTermVectorPayloads(), equalTo(false));
        merge(mapperService, mapping(b -> {  
import org.opensearch.common.CheckedConsumer;
            mpq.add(new Term("field", "motor"));
        ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.array("field", new String[] { "a", "b" })));
            assertThat(q, equalTo(mpq));
        }
    public void testPluggableDataFormatTextNullSkipped() throws IOException {  
        );
        DocumentMapper mapper = createDocumentMapper(
                    .field("field5", "1234")
            assertEquals(expectedValue, luceneFields[0].stringValue());
    public void testPluggableDataFormatPrefixFieldMapperThrows() throws IOException {
            {
            .anyMatch(e -> e.getKey().name().equals("text_field.sub") && e.getValue().equals("external_text"));  
        // test custom position_increment_gap
        DocumentMapper mapper = createDocumentMapper(
            assertFalse(ft.storeTermVectors());  
            b.startObject("sub").field("type", "text").endObject();  
            b.field("store", true);  
        // special case: default index analyzer  
            FieldType ft = prefix.fieldType;
            Settings.EMPTY,  
            "field",
                .build();
            b.startObject("field");  
        assertTrue(fieldMapper.fieldType().eagerGlobalOrdinals());
                .field("term_vector", "yes")  
        }));
import org.opensearch.index.analysis.StandardTokenizerFactory;
