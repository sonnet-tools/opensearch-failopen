            assertEquals(options, fields[0].fieldType().indexOptions());
            MapperParsingException e = expectThrows(MapperParsingException.class, () -> createDocumentMapper(mapping));
            Query expected = new SourceFieldMatchQuery(
        {
            mqb.add(new Term[] { new Term("synfield", "dogs"), new Term("synfield", "dog") });
            mqbFilter.add(new Term("field", "two"));
            mapperService.fieldType("field"),
import org.opensearch.index.query.QueryShardContext;
                .add(new TermQuery(new Term("field", "here")), BooleanClause.Occur.FILTER)
                .field("analyzer", "my_stop_analyzer")
        assertEquals(
            mqbFilter.add(new Term[] { new Term("field", "stopword") }, 2);
        expectedQuery = new SourceFieldMatchQuery(
            mqb.add(new Term("field", "words"));
import static org.hamcrest.Matchers.equalTo;
                        new BooleanQuery.Builder().add(new TermQuery(new Term("synfield", "dogs")), BooleanClause.Occur.SHOULD)
        expectedQuery = new SourceFieldMatchQuery(
            new PhraseQuery.Builder().add(new Term("field", "sparkle")).add(new Term("field", "stopword"), 2).build(),
                    .build(),
            try {
        Map<String, IndexOptions> supportedOptions = new HashMap<>();
            MultiPhrasePrefixQuery mqb = new MultiPhrasePrefixQuery("field");
            mqbFilter.add(new Term("field", "words"));
            queryShardContext
            MatchQuery matchQuery = new MatchQuery(queryShardContext);
            MultiPhrasePrefixQuery mqb = new MultiPhrasePrefixQuery("field");
                .field("type", textFieldName)
        assertEquals(DocValuesType.NONE, fieldType.docValuesType());
                mqbFilter,
    public void testMinimalToMaximal() throws IOException {}
                .build(),
    }
                mapperService.fieldType("field"),
        }
                    .build(),
            new BooleanQuery.Builder().add(new TermQuery(new Term("field", "two")), BooleanClause.Occur.FILTER)
    }
            Query q = matchQuery.parse(MatchQuery.Type.PHRASE_PREFIX, "synfield", "motor dogs");
        }
 *
                    .build(),
                containsString(
            );
            assertThat(q, equalTo(expected));
        );
import org.opensearch.common.lucene.search.AutomatonQueries;
            IndexableField[] fields = doc.rootDoc().getFields(option);
            mqbFilter.add(new Term[] { new Term("synfield", "dogs"), new Term("synfield", "dog") });
    @Override
            mqbFilter.setSlop(1);
        assertEquals(new ConstantScoreQuery(AutomatonQueries.caseInsensitiveTermQuery(new Term("field", "foo"))), q);
import org.apache.lucene.search.MultiPhraseQuery;
        expectedQuery = new SourceFieldMatchQuery(
    }
            MultiPhrasePrefixQuery mqb = new MultiPhrasePrefixQuery("field");
                    .add(new TermQuery(new Term("field", "words")), BooleanClause.Occur.FILTER)
            mqbFilter.add(new Term("field", "two"));
import org.opensearch.core.xcontent.MediaTypeRegistry;
            assertThat(serialized, containsString("\"docs\":{\"type\":\"match_only_text\"}"));
            );
import org.apache.lucene.search.BooleanQuery;
import org.opensearch.common.lucene.search.MultiPhrasePrefixQuery;
            MatchQuery matchQuery = new MatchQuery(queryShardContext);
        );
                        .field("analyzer", "standard")
                mqbFilter,
                b.field("analyzer", "my_stop_analyzer"); // "standard" will be replaced with MockSynonymAnalyzer
                        b -> b.field("type", textFieldName).field("index_options", indexOptions).field("position_increment_gap", 10)
            matchQuery.setAnalyzer(new MockSynonymAnalyzer());
            mqbFilter.add(new Term("synfield", "two"));
    public void testFastPhrasePrefixes() throws IOException {
        unsupportedOptions.put("freqs", IndexOptions.DOCS_AND_FREQS);
                    )
        assertThat(q6, is(expectedQuery));
                    .add(mqb, BooleanClause.Occur.FILTER)
            assertThat(
        {
}
package org.opensearch.index.mapper;
        }));
            MultiPhrasePrefixQuery mqb = new MultiPhrasePrefixQuery("synfield");
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> createMapperService(mapping(b -> {
            b.startObject("synfield");
                new BooleanQuery.Builder().add(new TermQuery(new Term("field", "two")), BooleanClause.Occur.FILTER)
            new BooleanQuery.Builder().add(new TermQuery(new Term("field", "sparkle")), BooleanClause.Occur.FILTER)
            mapperService.fieldType("field"),
            new PhraseQuery("field", "two", "words"),
        }
        assertThat(fieldType.storeTermVectors(), equalTo(false));
import org.apache.lucene.search.TermQuery;
            mqb.add(new Term("synfield", "word"));
    }
        }
                )
        assertThat(q5, is(expectedQuery));
        MapperService mapperService = createMapperService(mapping(b -> {
public class MatchOnlyTextFieldMapperTests extends TextFieldMapperTests {
import org.opensearch.index.query.MatchPhraseQueryBuilder;
                    fieldMapping(
                )
        MapperParsingException e = expectThrows(
        Query expectedQuery = new SourceFieldMatchQuery(
    @Override
        Query q = new TermQueryBuilder("field", "foo").rewrite(queryShardContext).toQuery(queryShardContext);
            MultiPhrasePrefixQuery mqbFilter = new MultiPhrasePrefixQuery("field");
                b.field("type", textFieldName);
            );
    public void testEnableStore() throws IOException {
        );
                new BooleanQuery.Builder().add(new TermQuery(new Term("field", "three")), BooleanClause.Occur.FILTER)
                    "Failed to parse mapping [_doc]: Unknown value [" + option + "] for field [index_options] - accepted values are [docs]"
                    .build(),
            new MultiPhraseQuery.Builder().add(new Term("synfield", "motor"))
            queryShardContext
            );
        assertThat(fieldType.indexOptions(), equalTo(IndexOptions.DOCS));
            assertThat(q, equalTo(expected));
            assertThat(q, equalTo(expected));
                    .add(
                .build(),
            XContentBuilder mapping = MediaTypeRegistry.JSON.contentBuilder().startObject().startObject("_doc").startObject("properties");
            mqbFilter.add(new Term("field", "words"));
            b.endObject();
    }
                    .add(mqb, BooleanClause.Occur.FILTER)
 */
    @Override
                    .build(),
        unsupportedOptions.put("positions", IndexOptions.DOCS_AND_FREQS_AND_POSITIONS);
                    .add(mqb, BooleanClause.Occur.FILTER)
        {
            matchQuery.setPhraseSlop(1);
        assertThat(q2, is(expectedQuery));
        assertThat(fieldType.storeTermVectorOffsets(), equalTo(false));
import org.apache.lucene.index.Term;
        supportedOptions.put("docs", IndexOptions.DOCS);
                .build(),
        }
                    b -> b.field("type", textFieldName)
                    .build(),
        }
            Query q = matchQuery.parse(MatchQuery.Type.PHRASE_PREFIX, "synfield", "two dogs");
            MapperParsingException.class,
            mqb.add(new Term[] { new Term("synfield", "dogs"), new Term("synfield", "dog") });
            queryShardContext
                .add(new TermQuery(new Term("field", "words")), BooleanClause.Occur.FILTER)
        Query q4 = new MatchPhraseQueryBuilder("field", "singleton").toQuery(queryShardContext);
                .field("index_phrases", true)
            Query expected = new SourceFieldMatchQuery(
            b.startObject("field");
                .build(),
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);
/*
import org.apache.lucene.index.IndexOptions;
        Map<String, IndexOptions> unsupportedOptions = new HashMap<>();
                        .field("max_chars", 10)
            );
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));
    }
                .add(new TermQuery(new Term("field", "stopword")), BooleanClause.Occur.FILTER)
        assertEquals(1, fields.length);
                .add(new Term[] { new Term("synfield", "dogs"), new Term("synfield", "dog") }, 1)
import org.opensearch.core.xcontent.XContentBuilder;
        // not supported and asserted the expected behavior in testIndexPrefixMapping
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", textFieldName).field("store", true)));
            () -> createDocumentMapper(
                        .build(),
        );
        MapperService mapperService = createMapperService(mapping(b -> {
        }
        );
    public void testFastPhraseMapping() throws IOException {
        Query q = new MatchPhraseQueryBuilder("field", "two words").toQuery(queryShardContext);
    @Override
            Query expected = new SourceFieldMatchQuery(
            assertEquals(1, fields.length);
        {
        })));
import org.apache.lucene.search.BooleanClause;
            mqbFilter.add(new Term("synfield", "word"));
                mqbFilter,
                new BooleanQuery.Builder().add(new TermQuery(new Term("field", "two")), BooleanClause.Occur.FILTER)
    }
            Query q = new MatchPhrasePrefixQueryBuilder("field", "sparkle a stopword").toQuery(queryShardContext);
                mapperService.fieldType("field"),
import org.apache.lucene.index.DocValuesType;
                queryShardContext
            assertThat(q, equalTo(expected));
            mapping.startObject(option).field("type", textFieldName).field("index_options", option).endObject();
        );
                mapperService.fieldType("synfield"),
        textFieldName = "match_only_text";
        assertEquals("1234", fields[0].stringValue());
    }
            } catch (IOException e) {
                )
            matchQuery.setAnalyzer(new MockSynonymAnalyzer());
            }
        );
        IndexableFieldType fieldType = fields[0].fieldType();
        }));
            matchQuery.setAnalyzer(new MockSynonymAnalyzer());
                    .add(mqb, BooleanClause.Occur.FILTER)
                        .add(new TermQuery(new Term("synfield", "dog")), BooleanClause.Occur.SHOULD)
                .build(),
            b.startObject("synfield").field("type", textFieldName).field("analyzer", "standard").field("index_phrases", true).endObject();
            }
            "Failed to parse mapping [_doc]: Index phrases cannot be enabled on for match_only_text field. Use text field instead",
        {
            DocumentMapper mapper = createDocumentMapper(mapping);
            IndexOptions options = supportedOptions.get(option);
            Query expected = new SourceFieldMatchQuery(
        assertThat(fieldType.storeTermVectorPositions(), equalTo(false));
            mqbFilter.add(new Term("field", "sparkle"));
        assertTrue(fields[0].fieldType().stored());
            b.startObject("field");
                new BooleanQuery.Builder().add(new TermQuery(new Term("synfield", "two")), BooleanClause.Occur.FILTER)
            Query q = matchQuery.parse(MatchQuery.Type.PHRASE_PREFIX, "synfield", "three dogs word");
            Query expected = new SourceFieldMatchQuery(
            mqbFilter.add(new Term("field", "here"));
                mqbFilter,
                        BooleanClause.Occur.FILTER
            new PhraseQuery("field", "three", "words", "here"),
            Query expected = new SourceFieldMatchQuery(
import org.opensearch.index.query.SourceFieldMatchQuery;
        assertEquals(fieldMapping(this::minimalMapping).toString(), mapper.mappingSource().toString());
            );
                );
        }
                mapperService.fieldType("field"),
        MapperService mapperService = createMapperService(mapping(b -> {
                    BooleanClause.Occur.FILTER
        }
            {
    public void testSimpleMerge() throws IOException {}
    public void testPositionIncrementGap() throws IOException {}
                mapperService.fieldType("synfield"),
                new BooleanQuery.Builder().add(new TermQuery(new Term("field", "sparkle")), BooleanClause.Occur.FILTER)
        q = new TermQueryBuilder("field", "foo").caseInsensitive(true).rewrite(queryShardContext).toQuery(queryShardContext);
            Query q = new MatchPhrasePrefixQueryBuilder("field", "two words").toQuery(queryShardContext);
            mqbFilter.add(new Term[] { new Term("synfield", "dogs"), new Term("synfield", "dog") });
        assertThat(fieldType.storeTermVectorPayloads(), equalTo(false));
            mqb.add(new Term("field", "words"));
    public void testPhrasePrefixes() throws IOException {
    }
            queryShardContext
    @Override
    public void testTermQuery() throws Exception {
                queryShardContext
        MatchQuery matchQuery = new MatchQuery(queryShardContext);
        IndexableField[] fields = doc.rootDoc().getFields("field");
import java.util.List;
import java.io.IOException;
                queryShardContext
        {
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);
    public void testIndexPrefixIndexTypes() throws IOException {
            b.startObject("field").field("type", textFieldName).field("analyzer", "my_stop_analyzer").endObject();
            mqb.add(new Term("field", "singleton"));
            );
import org.opensearch.index.query.TermQueryBuilder;
            MultiPhrasePrefixQuery mqbFilter = new MultiPhrasePrefixQuery("synfield");
                throw new RuntimeException(e);
import org.junit.Before;
            MultiPhrasePrefixQuery mqbFilter = new MultiPhrasePrefixQuery("field");
import org.apache.lucene.index.IndexableField;
                .add(new TermQuery(new Term("field", "words")), BooleanClause.Occur.FILTER)
    @Override
    public void setupMatchOnlyTextFieldMapper() {
import java.util.HashMap;
    public void testPhraseQuery() throws IOException {
            MultiPhrasePrefixQuery mqb = new MultiPhrasePrefixQuery("synfield");
        for (String option : unsupportedOptions.keySet()) {
            MultiPhrasePrefixQuery mqbFilter = new MultiPhrasePrefixQuery("field");
    public void testDefaultPositionIncrementGap() throws IOException {}
            MultiPhrasePrefixQuery mqb = new MultiPhrasePrefixQuery("field");
 * this file be licensed under the Apache-2.0 license or a
            {
            b.endObject();
                .add(new TermQuery(new Term("field", "words")), BooleanClause.Occur.FILTER)
        for (String option : supportedOptions.keySet()) {
            assertThat(q, equalTo(expected));
            mqbFilter.setSlop(1);
        }
        assertThat(q3, is(expectedQuery));
        assertThat(q, is(expectedQuery));
                queryShardContext
import org.apache.lucene.search.Query;
 * SPDX-License-Identifier: Apache-2.0
import java.util.Map;
            new BooleanQuery.Builder().add(new TermQuery(new Term("field", "two")), BooleanClause.Occur.FILTER)
            // "standard" will be replaced with MockSynonymAnalyzer
                mqb,
        assertThat(fieldType.omitNorms(), equalTo(true));
            );
            String serialized = Strings.toString(MediaTypeRegistry.JSON, mapper);
            }
                mqbFilter,
            b.endObject();
                .endObject();
    @Before
            Query q = new MatchPhrasePrefixQueryBuilder("field", "two words").slop(1).toQuery(queryShardContext);
            mqbFilter.add(new Term("synfield", "three"));
                        .startObject("index_prefixes")
            XContentBuilder mapping = MediaTypeRegistry.JSON.contentBuilder().startObject().startObject("_doc").startObject("properties");
            {
            b.startObject("field")
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));
                new BooleanQuery.Builder().add(new TermQuery(new Term("synfield", "three")), BooleanClause.Occur.FILTER)
        Query q3 = new MatchPhraseQueryBuilder("field", "two words").slop(2).toQuery(queryShardContext);
import org.apache.lucene.index.IndexableFieldType;
            new PhraseQuery(2, "field", "two", "words"),
        Query q2 = new MatchPhraseQueryBuilder("field", "three words here").toQuery(queryShardContext);
import static org.hamcrest.core.Is.is;
            queryShardContext
    @Override
                queryShardContext
            ParsedDocument doc = mapper.parse(source(b -> { b.field(option, "1234"); }));
            mapping.endObject().endObject().endObject();
                b.field("type", textFieldName);
        matchQuery.setAnalyzer(new MockSynonymAnalyzer());
    @Override
        IndexableField[] fields = doc.rootDoc().getFields("field");
            assertThat(q, equalTo(expected));
            );
        Query q5 = new MatchPhraseQueryBuilder("field", "sparkle a stopword").toQuery(queryShardContext);
            e.getMessage()
            MatchQuery matchQuery = new MatchQuery(queryShardContext);
            mqbFilter.add(new Term("synfield", "motor"));
                            .build(),
                mqbFilter,
            MultiPhrasePrefixQuery mqbFilter = new MultiPhrasePrefixQuery("synfield");
            MultiPhrasePrefixQuery mqbFilter = new MultiPhrasePrefixQuery("field");
import org.apache.lucene.search.PhraseQuery;
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
            mqb.add(new Term("field", "stopword"));
    @Override
        assertEquals(
            // "standard" will be replaced with MockSynonymAnalyzer
import org.apache.lucene.search.ConstantScoreQuery;
 * The OpenSearch Contributors require contributions made to
        }));
            Query expected = new SourceFieldMatchQuery(
            assertThat(q, equalTo(expected));
        Query q6 = matchQuery.parse(MatchQuery.Type.PHRASE, "synfield", "motor dogs");
                b.field("analyzer", "standard"); // "standard" will be replaced with MockSynonymAnalyzer
 * compatible open source license.
                queryShardContext
                    new BooleanQuery.Builder().add(new TermQuery(new Term("synfield", "dogs")), BooleanClause.Occur.SHOULD)
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);
        {
                b.field("analyzer", "my_stop_analyzer"); // "standard" will be replaced with MockSynonymAnalyzer
                            .add(new TermQuery(new Term("synfield", "dog")), BooleanClause.Occur.SHOULD)
            assertThat(q, is(expected));
                .add(
        assertFalse(fieldType.stored());
                    )
                        .field("min_chars", 2)
        // not supported and asserted the expected behavior in testIndexPrefixMapping
                mapperService.fieldType("field"),
            mqb.add(new Term("field", "here"));
            MultiPhrasePrefixQuery mqb = new MultiPhrasePrefixQuery("field");
    public void testDefaults() throws IOException {
        assertThat(q4, is(new ConstantScoreQuery(new TermQuery(new Term("field", "singleton")))));
        assertEquals(new ConstantScoreQuery(new TermQuery(new Term("field", "foo"))), q);
                    .build(),
        {
            mapperService.fieldType("synfield"),
    @Override
            mqbFilter.add(new Term[] { new Term("synfield", "dogs"), new Term("synfield", "dog") });
    @Override
            Query q = new MatchPhrasePrefixQueryBuilder("field", "singleton").toQuery(queryShardContext);
        for (String indexOptions : List.of("docs")) {
            new BooleanQuery.Builder().add(new TermQuery(new Term("synfield", "motor")), BooleanClause.Occur.FILTER)
            mqbFilter.add(new Term("field", "three"));
            new BooleanQuery.Builder().add(new TermQuery(new Term("field", "three")), BooleanClause.Occur.FILTER)
            MultiPhrasePrefixQuery mqbFilter = new MultiPhrasePrefixQuery("synfield");
                .build(),
            Query q = new MatchPhrasePrefixQueryBuilder("field", "three words here").toQuery(queryShardContext);
import org.opensearch.core.common.Strings;
                queryShardContext
        assertEquals(1, fields.length);
        }
            )
import org.apache.lucene.tests.analysis.MockSynonymAnalyzer;
            mqbFilter.add(new Term("field", "words"));
import org.opensearch.index.query.MatchPhrasePrefixQueryBuilder;
    public void testAnalyzedFieldPositionIncrementWithoutPositions() {
            }
        );
    }
    }
                mapperService.fieldType("synfield"),
                new BooleanQuery.Builder().add(new TermQuery(new Term("synfield", "motor")), BooleanClause.Occur.FILTER)
    public void testIndexPrefixMapping() throws IOException {
                new BooleanQuery.Builder().add(mqb, BooleanClause.Occur.FILTER).build(),
import static org.hamcrest.Matchers.containsString;
    public void testBWCSerialization() throws IOException {}
    @Override
            b.startObject("synfield").field("type", textFieldName).field("analyzer", "standard").endObject();
                    .add(mqb, BooleanClause.Occur.FILTER)
            mapping.endObject().endObject().endObject();
                fieldMapping(
            MultiPhrasePrefixQuery mqb = new MultiPhrasePrefixQuery("synfield");
        unsupportedOptions.put("offsets", IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS);
            mapperService.fieldType("field"),
        assertTrue(fieldType.tokenized());
    }
                e.getMessage(),
                createDocumentMapper(
            Query expected = new SourceFieldMatchQuery(
                    .add(mqb, BooleanClause.Occur.FILTER)
                        .endObject()
        expectedQuery = new SourceFieldMatchQuery(
            e.getMessage()
                queryShardContext
    public void testIndexOptions() throws IOException {
                mqbFilter,
                b.field("type", textFieldName);
    @Override
                mapperService.fieldType("field"),
            "Failed to parse mapping [_doc]: Index prefixes cannot be enabled on for match_only_text field. Use text field instead",
                    .add(mqb, BooleanClause.Occur.FILTER)
            mapping.startObject(option).field("type", textFieldName).field("index_options", option).endObject();
            mapperService.fieldType("field"),
import org.opensearch.index.search.MatchQuery;
