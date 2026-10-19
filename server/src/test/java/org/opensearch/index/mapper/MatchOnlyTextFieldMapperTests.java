            assertEquals(options, fields[0].fieldType().indexOptions());
    public void testBWCSerialization() throws IOException {}
        assertEquals(1, fields.length);  
            Query expected = new SourceFieldMatchQuery(
        );
            mqb.add(new Term("field", "words"));
            queryShardContext  
        IndexableField[] fields = doc.rootDoc().getFields("field");
            MultiPhrasePrefixQuery mqbFilter = new MultiPhrasePrefixQuery("synfield");
 */  
                        BooleanClause.Occur.FILTER
            Query q = new MatchPhrasePrefixQueryBuilder("field", "two words").slop(1).toQuery(queryShardContext);  
                mqbFilter,
                new BooleanQuery.Builder().add(new TermQuery(new Term("field", "two")), BooleanClause.Occur.FILTER)
        assertEquals("1234", fields[0].stringValue());  
        {  
        }
    }
            MapperParsingException e = expectThrows(MapperParsingException.class, () -> createDocumentMapper(mapping));
        }
    }
            mqbFilter.setSlop(1);
import org.opensearch.index.query.QueryShardContext;  
            b.startObject("synfield").field("type", textFieldName).field("analyzer", "standard").endObject();
    @Override  
            DocumentMapper mapper = createDocumentMapper(mapping);
            assertThat(serialized, containsString("\"docs\":{\"type\":\"match_only_text\"}"));  
        unsupportedOptions.put("freqs", IndexOptions.DOCS_AND_FREQS);
        {
            // "standard" will be replaced with MockSynonymAnalyzer
                    .add(mqb, BooleanClause.Occur.FILTER)
            mqbFilter.add(new Term("field", "here"));
        Query q = new MatchPhraseQueryBuilder("field", "two words").toQuery(queryShardContext);  
    public void testDefaultPositionIncrementGap() throws IOException {}
        assertThat(q5, is(expectedQuery));
            assertThat(  
import org.apache.lucene.search.TermQuery;  
            Query expected = new SourceFieldMatchQuery(
                        b -> b.field("type", textFieldName).field("index_options", indexOptions).field("position_increment_gap", 10)  
            mqbFilter.add(new Term("field", "words"));  
        }
        );  
        assertThat(fieldType.indexOptions(), equalTo(IndexOptions.DOCS));
                mapperService.fieldType("field"),  
            mqbFilter.add(new Term[] { new Term("field", "stopword") }, 2);
    public void testIndexOptions() throws IOException {
                        .endObject()
package org.opensearch.index.mapper;
                )  
    @Override
            mqb.add(new Term[] { new Term("synfield", "dogs"), new Term("synfield", "dog") });  
                    .build(),  
            Query expected = new SourceFieldMatchQuery(
            mqb.add(new Term("field", "here"));  
        matchQuery.setAnalyzer(new MockSynonymAnalyzer());
            "Failed to parse mapping [_doc]: Index prefixes cannot be enabled on for match_only_text field. Use text field instead",
    }  
                b.field("type", textFieldName);
        expectedQuery = new SourceFieldMatchQuery(  
        expectedQuery = new SourceFieldMatchQuery(
    public void testPhrasePrefixes() throws IOException {
            );
    }
    }  
    @Override
                .add(new TermQuery(new Term("field", "stopword")), BooleanClause.Occur.FILTER)
import org.apache.lucene.index.Term;
        MatchQuery matchQuery = new MatchQuery(queryShardContext);  
                new BooleanQuery.Builder().add(new TermQuery(new Term("field", "three")), BooleanClause.Occur.FILTER)  
                mapperService.fieldType("field"),
    public void testMinimalToMaximal() throws IOException {}
import org.opensearch.core.xcontent.MediaTypeRegistry;
                .add(new TermQuery(new Term("field", "here")), BooleanClause.Occur.FILTER)  
            new PhraseQuery.Builder().add(new Term("field", "sparkle")).add(new Term("field", "stopword"), 2).build(),  
            mqb.add(new Term("field", "words"));  
        );
                    .add(mqb, BooleanClause.Occur.FILTER)
            Query q = new MatchPhrasePrefixQueryBuilder("field", "three words here").toQuery(queryShardContext);
        assertThat(fieldType.storeTermVectorPayloads(), equalTo(false));  
        Query q2 = new MatchPhraseQueryBuilder("field", "three words here").toQuery(queryShardContext);
            Query expected = new SourceFieldMatchQuery(
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));
    @Override  
                            .build(),
            new BooleanQuery.Builder().add(new TermQuery(new Term("field", "two")), BooleanClause.Occur.FILTER)
                queryShardContext
    }
    public void testIndexPrefixIndexTypes() throws IOException {
            new MultiPhraseQuery.Builder().add(new Term("synfield", "motor"))  
            }
            assertThat(q, equalTo(expected));
            MatchQuery matchQuery = new MatchQuery(queryShardContext);
            Query q = new MatchPhrasePrefixQueryBuilder("field", "singleton").toQuery(queryShardContext);
import org.opensearch.index.query.TermQueryBuilder;
            MapperParsingException.class,  
                new BooleanQuery.Builder().add(new TermQuery(new Term("field", "sparkle")), BooleanClause.Occur.FILTER)  
            b.startObject("field")
                            .add(new TermQuery(new Term("synfield", "dog")), BooleanClause.Occur.SHOULD)  
        {
            );
                new BooleanQuery.Builder().add(new TermQuery(new Term("synfield", "three")), BooleanClause.Occur.FILTER)  
                )
            mqbFilter.add(new Term("field", "three"));
        textFieldName = "match_only_text";
                b.field("analyzer", "standard"); // "standard" will be replaced with MockSynonymAnalyzer  
                mqbFilter,  
            new BooleanQuery.Builder().add(new TermQuery(new Term("synfield", "motor")), BooleanClause.Occur.FILTER)
            XContentBuilder mapping = MediaTypeRegistry.JSON.contentBuilder().startObject().startObject("_doc").startObject("properties");  
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));  
    public void testPhraseQuery() throws IOException {
            String serialized = Strings.toString(MediaTypeRegistry.JSON, mapper);
        unsupportedOptions.put("positions", IndexOptions.DOCS_AND_FREQS_AND_POSITIONS);
                new BooleanQuery.Builder().add(new TermQuery(new Term("field", "two")), BooleanClause.Occur.FILTER)
            queryShardContext
                b.field("analyzer", "my_stop_analyzer"); // "standard" will be replaced with MockSynonymAnalyzer  
            mapperService.fieldType("synfield"),  
            );
            assertThat(q, equalTo(expected));  
    @Override
import org.junit.Before;
        );
            matchQuery.setAnalyzer(new MockSynonymAnalyzer());  
        assertFalse(fieldType.stored());
        {
            MultiPhrasePrefixQuery mqb = new MultiPhrasePrefixQuery("synfield");
            mqbFilter.add(new Term("field", "two"));
                queryShardContext
                createDocumentMapper(
            assertThat(q, equalTo(expected));
            );  
 * The OpenSearch Contributors require contributions made to  
            matchQuery.setAnalyzer(new MockSynonymAnalyzer());  
            {
import org.opensearch.common.lucene.search.AutomatonQueries;
                    .build(),
    @Override  
        assertEquals(  
            b.endObject();
            );
                mapperService.fieldType("synfield"),  
        }
            MultiPhrasePrefixQuery mqbFilter = new MultiPhrasePrefixQuery("field");
                )
        IndexableFieldType fieldType = fields[0].fieldType();
import org.apache.lucene.index.IndexableFieldType;
        }
                queryShardContext
        assertThat(q3, is(expectedQuery));
                    .add(mqb, BooleanClause.Occur.FILTER)  
            mapperService.fieldType("field"),  
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);  
        assertEquals(DocValuesType.NONE, fieldType.docValuesType());
            mapping.endObject().endObject().endObject();
    public void testFastPhraseMapping() throws IOException {  
import static org.hamcrest.core.Is.is;
        expectedQuery = new SourceFieldMatchQuery(  
        assertThat(q2, is(expectedQuery));  
    @Override
            mqbFilter.add(new Term("field", "two"));
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> createMapperService(mapping(b -> {
        IndexableField[] fields = doc.rootDoc().getFields("field");
                        .field("min_chars", 2)  
                queryShardContext
                    .add(
                    )
            MultiPhrasePrefixQuery mqbFilter = new MultiPhrasePrefixQuery("field");  
 * SPDX-License-Identifier: Apache-2.0
    @Override  
            MultiPhrasePrefixQuery mqb = new MultiPhrasePrefixQuery("field");
 *
            mqbFilter.add(new Term("field", "words"));  
                mapperService.fieldType("synfield"),
                );
 * this file be licensed under the Apache-2.0 license or a
import java.util.List;
                mapperService.fieldType("field"),
        );
                        .build(),
                mqbFilter,
            Query q = matchQuery.parse(MatchQuery.Type.PHRASE_PREFIX, "synfield", "two dogs");
            MultiPhrasePrefixQuery mqb = new MultiPhrasePrefixQuery("field");  
            b.startObject("synfield");  
public class MatchOnlyTextFieldMapperTests extends TextFieldMapperTests {  
            // "standard" will be replaced with MockSynonymAnalyzer
import static org.hamcrest.Matchers.equalTo;  
            IndexOptions options = supportedOptions.get(option);
import org.opensearch.core.xcontent.XContentBuilder;  
        assertThat(fieldType.storeTermVectorOffsets(), equalTo(false));
import org.apache.lucene.search.PhraseQuery;
                b.field("analyzer", "my_stop_analyzer"); // "standard" will be replaced with MockSynonymAnalyzer
            Query expected = new SourceFieldMatchQuery(
        assertThat(q4, is(new ConstantScoreQuery(new TermQuery(new Term("field", "singleton")))));  
            "Failed to parse mapping [_doc]: Index phrases cannot be enabled on for match_only_text field. Use text field instead",
                        .field("max_chars", 10)
            mqbFilter.add(new Term("synfield", "motor"));
            MatchQuery matchQuery = new MatchQuery(queryShardContext);
            e.getMessage()  
            MultiPhrasePrefixQuery mqbFilter = new MultiPhrasePrefixQuery("synfield");
import org.apache.lucene.search.Query;
                .add(new TermQuery(new Term("field", "words")), BooleanClause.Occur.FILTER)  
            b.endObject();
            try {  
            }
                .field("type", textFieldName)  
        assertThat(q, is(expectedQuery));
            Query q = matchQuery.parse(MatchQuery.Type.PHRASE_PREFIX, "synfield", "motor dogs");
            mqb.add(new Term("synfield", "word"));  
            mapperService.fieldType("field"),
            mqbFilter.add(new Term("synfield", "word"));
    public void testIndexPrefixMapping() throws IOException {
            new PhraseQuery("field", "three", "words", "here"),
                mapperService.fieldType("field"),  
                    .build(),
                throw new RuntimeException(e);
                    .add(mqb, BooleanClause.Occur.FILTER)
    @Override
        for (String indexOptions : List.of("docs")) {
    }
    @Override  
        MapperService mapperService = createMapperService(mapping(b -> {
            MultiPhrasePrefixQuery mqbFilter = new MultiPhrasePrefixQuery("field");
                containsString(
    public void testEnableStore() throws IOException {
        for (String option : supportedOptions.keySet()) {
        Query q3 = new MatchPhraseQueryBuilder("field", "two words").slop(2).toQuery(queryShardContext);
            mqbFilter.add(new Term("field", "words"));  
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", textFieldName).field("store", true)));  
            Query q = new MatchPhrasePrefixQueryBuilder("field", "sparkle a stopword").toQuery(queryShardContext);
                .add(new TermQuery(new Term("field", "words")), BooleanClause.Occur.FILTER)
        }));
            b.startObject("field");  
                    .build(),
                .add(
            );  
    public void testAnalyzedFieldPositionIncrementWithoutPositions() {
            matchQuery.setAnalyzer(new MockSynonymAnalyzer());  
                queryShardContext
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);
            Query expected = new SourceFieldMatchQuery(
        }
    public void testFastPhrasePrefixes() throws IOException {  
    }
            mapping.startObject(option).field("type", textFieldName).field("index_options", option).endObject();  
            mqbFilter.add(new Term("field", "sparkle"));  
            () -> createDocumentMapper(
        {  
            }
            );  
        assertThat(q6, is(expectedQuery));  
            ParsedDocument doc = mapper.parse(source(b -> { b.field(option, "1234"); }));
            MultiPhrasePrefixQuery mqb = new MultiPhrasePrefixQuery("field");
                mapperService.fieldType("synfield"),
            mapperService.fieldType("field"),  
import java.util.Map;  
        Query q = new TermQueryBuilder("field", "foo").rewrite(queryShardContext).toQuery(queryShardContext);
                    .add(mqb, BooleanClause.Occur.FILTER)
            mqbFilter.add(new Term("synfield", "three"));
                    BooleanClause.Occur.FILTER  
import org.opensearch.index.query.MatchPhrasePrefixQueryBuilder;
                b.field("type", textFieldName);
        // not supported and asserted the expected behavior in testIndexPrefixMapping
                new BooleanQuery.Builder().add(mqb, BooleanClause.Occur.FILTER).build(),
            mqb.add(new Term("field", "stopword"));
            queryShardContext
            queryShardContext
            mqbFilter.add(new Term("synfield", "two"));
            mqbFilter.add(new Term[] { new Term("synfield", "dogs"), new Term("synfield", "dog") });  
                .build(),
        {  
            new BooleanQuery.Builder().add(new TermQuery(new Term("field", "two")), BooleanClause.Occur.FILTER)
        assertThat(fieldType.storeTermVectorPositions(), equalTo(false));
                        .field("analyzer", "standard")
                b.field("type", textFieldName);
                mqbFilter,
            assertThat(q, equalTo(expected));  
            }  
                mqbFilter,  
        );
import org.apache.lucene.index.IndexableField;  
        }));  
        Query q5 = new MatchPhraseQueryBuilder("field", "sparkle a stopword").toQuery(queryShardContext);
            MultiPhrasePrefixQuery mqbFilter = new MultiPhrasePrefixQuery("field");
        assertThat(fieldType.storeTermVectors(), equalTo(false));  
                    .add(new TermQuery(new Term("field", "words")), BooleanClause.Occur.FILTER)
                        .add(new TermQuery(new Term("synfield", "dog")), BooleanClause.Occur.SHOULD)
    @Override  
            MultiPhrasePrefixQuery mqb = new MultiPhrasePrefixQuery("synfield");
            mqb.add(new Term("field", "singleton"));  
    public void testPositionIncrementGap() throws IOException {}
        assertEquals(
            MultiPhrasePrefixQuery mqb = new MultiPhrasePrefixQuery("synfield");
        assertTrue(fields[0].fieldType().stored());
            XContentBuilder mapping = MediaTypeRegistry.JSON.contentBuilder().startObject().startObject("_doc").startObject("properties");
                .endObject();  
import org.apache.lucene.index.IndexOptions;
            new PhraseQuery("field", "two", "words"),
            } catch (IOException e) {  
        );
        }  
            );  
        assertThat(fieldType.omitNorms(), equalTo(true));
            MultiPhrasePrefixQuery mqb = new MultiPhrasePrefixQuery("field");
                .build(),
            assertEquals(1, fields.length);  
            b.startObject("field").field("type", textFieldName).field("analyzer", "my_stop_analyzer").endObject();  
import java.io.IOException;  
            assertThat(q, equalTo(expected));
        assertEquals(1, fields.length);
                    new BooleanQuery.Builder().add(new TermQuery(new Term("synfield", "dogs")), BooleanClause.Occur.SHOULD)  
        }));  
                mapperService.fieldType("field"),
import org.opensearch.core.common.Strings;
        }  
            e.getMessage()
                mqbFilter,  
            new PhraseQuery(2, "field", "two", "words"),
        Map<String, IndexOptions> supportedOptions = new HashMap<>();  
                        .startObject("index_prefixes")
            );
        // not supported and asserted the expected behavior in testIndexPrefixMapping
import org.opensearch.index.query.MatchPhraseQueryBuilder;
                .add(new TermQuery(new Term("field", "words")), BooleanClause.Occur.FILTER)
            {  
            Query q = matchQuery.parse(MatchQuery.Type.PHRASE_PREFIX, "synfield", "three dogs word");
        expectedQuery = new SourceFieldMatchQuery(  
            b.startObject("synfield").field("type", textFieldName).field("analyzer", "standard").field("index_phrases", true).endObject();
        q = new TermQueryBuilder("field", "foo").caseInsensitive(true).rewrite(queryShardContext).toQuery(queryShardContext);
            new BooleanQuery.Builder().add(new TermQuery(new Term("field", "three")), BooleanClause.Occur.FILTER)
            assertThat(q, equalTo(expected));  
                .build(),
import org.apache.lucene.tests.analysis.MockSynonymAnalyzer;
    @Before
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);
        }
            IndexableField[] fields = doc.rootDoc().getFields(option);
            mqbFilter.add(new Term[] { new Term("synfield", "dogs"), new Term("synfield", "dog") });  
import static org.hamcrest.Matchers.containsString;
            Query expected = new SourceFieldMatchQuery(
                .build(),  
            )
        MapperService mapperService = createMapperService(mapping(b -> {
                    .build(),
import org.opensearch.index.search.MatchQuery;  
        }
            mqb.add(new Term[] { new Term("synfield", "dogs"), new Term("synfield", "dog") });  
                e.getMessage(),
                mqbFilter,
        Query expectedQuery = new SourceFieldMatchQuery(
import org.apache.lucene.search.ConstantScoreQuery;
            mqbFilter.setSlop(1);
        }  
                        new BooleanQuery.Builder().add(new TermQuery(new Term("synfield", "dogs")), BooleanClause.Occur.SHOULD)
            queryShardContext
        assertEquals(new ConstantScoreQuery(new TermQuery(new Term("field", "foo"))), q);  
            b.endObject();
            Query expected = new SourceFieldMatchQuery(
            {
        Map<String, IndexOptions> unsupportedOptions = new HashMap<>();  
            MatchQuery matchQuery = new MatchQuery(queryShardContext);
            matchQuery.setPhraseSlop(1);
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));  
            new BooleanQuery.Builder().add(new TermQuery(new Term("field", "sparkle")), BooleanClause.Occur.FILTER)  
        {  
    @Override
        assertEquals(new ConstantScoreQuery(AutomatonQueries.caseInsensitiveTermQuery(new Term("field", "foo"))), q);  
                .field("analyzer", "my_stop_analyzer")
        MapperService mapperService = createMapperService(mapping(b -> {
        Query q6 = matchQuery.parse(MatchQuery.Type.PHRASE, "synfield", "motor dogs");
                .field("index_phrases", true)
        assertTrue(fieldType.tokenized());  
    public void testTermQuery() throws Exception {  
import org.apache.lucene.index.DocValuesType;
                    .build(),
    }
            mapperService.fieldType("field"),
import org.opensearch.common.lucene.search.MultiPhrasePrefixQuery;  
        {
                fieldMapping(
                queryShardContext
        unsupportedOptions.put("offsets", IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS);  
            mapping.endObject().endObject().endObject();
            mqbFilter.add(new Term[] { new Term("synfield", "dogs"), new Term("synfield", "dog") });  
                queryShardContext
                    fieldMapping(
    public void testSimpleMerge() throws IOException {}
        })));  
/*  
        for (String option : unsupportedOptions.keySet()) {
                    )  
        supportedOptions.put("docs", IndexOptions.DOCS);
import org.apache.lucene.search.BooleanQuery;
                queryShardContext  
                    b -> b.field("type", textFieldName)  
            assertThat(q, is(expected));
                mqb,  
    }
                .build(),
import org.apache.lucene.search.BooleanClause;  
            mapping.startObject(option).field("type", textFieldName).field("index_options", option).endObject();
            b.startObject("field");
}
        assertEquals(fieldMapping(this::minimalMapping).toString(), mapper.mappingSource().toString());
    }
                new BooleanQuery.Builder().add(new TermQuery(new Term("synfield", "motor")), BooleanClause.Occur.FILTER)
            MultiPhrasePrefixQuery mqb = new MultiPhrasePrefixQuery("field");
    public void setupMatchOnlyTextFieldMapper() {  
import org.apache.lucene.search.MultiPhraseQuery;  
 * compatible open source license.
import java.util.HashMap;
                    .build(),
    }
                .add(new Term[] { new Term("synfield", "dogs"), new Term("synfield", "dog") }, 1)
        MapperParsingException e = expectThrows(
            assertThat(q, equalTo(expected));
                new BooleanQuery.Builder().add(new TermQuery(new Term("synfield", "two")), BooleanClause.Occur.FILTER)  
        Query q4 = new MatchPhraseQueryBuilder("field", "singleton").toQuery(queryShardContext);
    @Override  
import org.opensearch.index.query.SourceFieldMatchQuery;
            Query q = new MatchPhrasePrefixQueryBuilder("field", "two words").toQuery(queryShardContext);
                    .add(mqb, BooleanClause.Occur.FILTER)  
                    .add(mqb, BooleanClause.Occur.FILTER)  
                .build(),
        );  
            MultiPhrasePrefixQuery mqbFilter = new MultiPhrasePrefixQuery("synfield");
                    "Failed to parse mapping [_doc]: Unknown value [" + option + "] for field [index_options] - accepted values are [docs]"  
    public void testDefaults() throws IOException {
