            .setId("1")
        );  
            0,
                    "type=text,term_vector=with_positions_offsets,analyzer=synonym",
                        )
        logger.info("--> highlighting and searching on field4");
            0,
        refresh();
                equalTo("<x>The</x> <x>quick</x> <x>browse</x> button is a fancy thing, right bro?"),
                matchPhraseQuery(
        assertHighlight(
                searchResponse,  
        searchResponse = client().search(searchRequest("first_test_index").source(source)).actionGet();  
                .setSettings(
import org.opensearch.core.xcontent.XContentBuilder;  
            anyOf(equalTo("<x>a quick fast blue car</x>"), equalTo("<x>a</x> <x>quick</x> <x>fast</x> <x>blue</x> <x>car</x>"))  
    }
 * Licensed to Elasticsearch under one or more contributor  
            prepareCreate("second_test_index").setSettings(builder.build())
            .highlighter(highlight().field("field1").order("score").preTags("<x>").postTags("</x>"));
                    .startObject("name")  
                    + "a test for highlighting feature Test: http://www.facebook.com "  
            .putList("index.analysis.filter.synonym.synonyms", "quick => fast");  
            "body",
                    "field1",
import org.opensearch.common.xcontent.XContentFactory;
            searchResponse,
                equalTo("The <x>quick</x> <x>browse</x> button is a fancy thing, right bro?"),
        assertHighlight(
                )
        logger.info("--> highlighting and searching on field0");  
        return XContentFactory.jsonBuilder()
import org.opensearch.common.settings.Settings;
            anyOf(
                        .put("analysis.filter.wordDelimiter.generate_number_parts", false)
                        .put("analysis.tokenizer.autocomplete.type", "ngram")  
            .setQuery(matchPhraseQuery("body", "Test: http://www.facebook.com "))
import java.util.Collection;
        Settings.Builder builder = Settings.builder()
        );
                equalTo("<x>The</x> <x>quick</x> <x>brown</x> fox jumps over the lazy dog")  
                            "- => ALPHANUM",  
            .put(indexSettings())
            assertHighlight(searchResponse, 0, "field1", 0, 1, equalTo("The <x>quick</x> <x>brown</x> <x>fox</x> jumps over the lazy dog"));
                            "| => ALPHANUM",
        );
            assertHighlight(searchResponse, 0, "field1", 0, 1, equalTo("The <x>quick</x> <x>brown</x> <x>fox</x> jumps over the lazy dog"));  
                    .endObject()  
    }
        assertHighlight(search, 0, "body", 0, startsWith("<em>Test: http://www.facebook.com</em>"));
            .endObject()
                )
                    .field("term_vector", "with_positions_offsets")
                    .field("search_analyzer", "search_autocomplete")  
                equalTo("<x>The</x> <x>quick</x> <x>brown</x> fox jumps over the lazy dog")
import static org.opensearch.search.builder.SearchSourceBuilder.highlight;
                "field4",
        assertAcked(
                "type",
                        + "http://elasticsearch.org http://xing.com http://cnn.com "
            )
/*
            )
import static org.opensearch.index.query.QueryBuilders.matchPhrasePrefixQuery;  
        client().prepareIndex("second_test_index").setId("2").setSource("type", "type2", "field4", "a quick fast blue car").get();
        assertAcked(
                    + "http://xing.com http://cnn.com http://quora.com http://twitter.com this is "
                    .endObject()
        searchResponse = client().search(searchRequest("first_test_index").source(source)).actionGet();
            .setId("0")
            0,
            .endObject()  
        return Arrays.asList(CommonAnalysisModulePlugin.class);
            )
                            ") => ALPHANUM",
                            "/ => ALPHANUM",
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                .setSettings(
        );  
                    + "http://elasticsearch.org http://xing.com http://cnn.com http://quora.com "
public class HighlighterWithAnalyzersTests extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
                    .field("type", "text")
                    .startObject("autocomplete")  
 */  
            0,  
                0,  
            .field("type", "text")
         */
 */
                        .put("analysis.filter.wordDelimiter.type", "word_delimiter")
        client().prepareIndex("first_test_index")  
            prepareCreate("test").setSettings(builder.build())  
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertHighlight(searchResponse, 0, "field0", 0, 1, equalTo("The <x>quick</x> <x>brown</x> fox jumps over the lazy dog"));
                    + "http://twitter.com this is a test for highlighting feature"
            SearchResponse searchResponse = client().search(searchRequest("test").source(source)).actionGet();
            .startObject("field1")  
                    .endObject()  
                    "type=text,term_vector=with_positions_offsets,search_analyzer=synonym," + "analyzer=standard,index_options=offsets"  
            )  
        /*
            anyOf(  
            .endObject()  
                "body",
import java.util.Arrays;  
                1,
        for (String highlighterType : new String[] { "plain", "fvh", "unified" }) {
        searchResponse = client().search(searchRequest("second_test_index").source(source)).actionGet();
                equalTo("The <x>quick</x> <x>brown</x> fox jumps over the lazy dog")
            search,  
    }
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));  
                    .field("type", "text")
            )
 * this file be licensed under the Apache-2.0 license or a
            0,
        SearchResponse search = client().prepareSearch("test")  
        source = searchSource().query(
                        .putList("analysis.analyzer.search_autocomplete.filter", "lowercase", "wordDelimiter")
            1,
    }
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },  
            .putList("index.analysis.analyzer.synonym.filter", "synonym", "lowercase")
                    "type=text,analyzer=synonym"
                i,
            .highlighter(highlight().field("field4").order("score").preTags("<x>").postTags("</x>"));  
            source = searchSource().query(matchQuery("field1", "fast brown fox").operator(Operator.AND))
                "The quick brown fox jumps over the lazy dog",
            .get();  
                            "~ => ALPHANUM",
            .setQuery(matchQuery("name.autocomplete", "deut tel").operator(Operator.OR))
            )
            .field("type", "text")
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
                            "} => ALPHANUM",  
            .setId("1")
                            "& => ALPHANUM",
        assertAcked(prepareCreate("first_test_index").setSettings(builder.build()).setMapping(type1TermVectorMapping()));
            SearchSourceBuilder source = searchSource().query(matchQuery("field1", "quick brown fox").operator(Operator.AND))  
                        .put(indexSettings())
        assertHighlight(  
                            "[ => ALPHANUM",
            assertHighlight(
                        .put("analysis.filter.wordDelimiter.type.split_on_numerics", false)  
                            "$ => ALPHANUM",  
import static org.opensearch.index.query.QueryBuilders.termQuery;  
            .highlighter(highlight().field("field0").order("score").preTags("<x>").postTags("</x>"));
 *
        refresh();
import org.opensearch.index.query.Operator;
        SearchResponse search = client().prepareSearch()  
            .setSource(
                        .put("analysis.filter.wordDelimiter.generate_word_parts", true)
            0,
            searchResponse = client().search(searchRequest("test").source(source)).actionGet();
import static org.opensearch.search.builder.SearchSourceBuilder.searchSource;  
                    .startObject("properties")
            boolQuery().should(matchPhrasePrefixQuery("field1", "test")).should(matchPhrasePrefixQuery("field1", "bro"))
                            ": => ALPHANUM",  
        ).highlighter(highlight().field("field1").order("score").preTags("<x>").postTags("</x>"));  
        ensureGreen();
                            "% => ALPHANUM",
        assertHighlight(  
            anyOf(
            .actionGet();
 * specific language governing permissions and limitations
        );
                        .put("analysis.filter.wordDelimiter.generate_number_parts", true)
        client().prepareIndex("test")  
                            ", => ALPHANUM",
        );
    }
    }
            .setSource(
        source = searchSource().query(matchPhrasePrefixQuery("field0", "bro"))  
            .get();  
                "type=text,analyzer=custom_analyzer," + "search_analyzer=custom_analyzer,term_vector=with_positions_offsets"  
        source = searchSource().postFilter(termQuery("type", "type2"))
         * query. We cut off and extract terms if there are more than 16 terms in the query
            .get();
            1,
            )
            .query(matchPhrasePrefixQuery("field4", "a fast quick blue ca"))
}  
            .field("term_vector", "with_positions_offsets")
                        .put("analysis.tokenizer.autocomplete.token_chars", "letter,digit")
                        + "http://xing.com http://cnn.com http://quora.com http://twitter.com this "
            )
        ensureGreen();
                )
import static org.opensearch.index.query.QueryBuilders.boolQuery;
        );  
            "field4",  
                        .put("analysis.filter.wordDelimiter.generate_word_parts", true)
        source = searchSource().postFilter(termQuery("type", "type2"))
    }  
            .setSource("field0", "The quick brown fox jumps over the lazy dog", "field1", "The quick brown fox jumps over the lazy dog")
                .setMapping(
        source = searchSource().postFilter(termQuery("type", "type2"))
            "field1",
            0,  
            )
 * The OpenSearch Contributors require contributions made to  
        super(staticSettings);  
                            "^ => ALPHANUM",
        searchResponse = client().search(searchRequest("first_test_index").source(source)).actionGet();
        client().prepareIndex("test").setId("0").setSource("field1", "The quick brown fox jumps over the lazy dog").get();
import static org.hamcrest.Matchers.equalTo;  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            .put("index.analysis.analyzer.synonym.tokenizer", "standard")  
 * ownership. Elasticsearch licenses this file to you under  
                "type2",  
                .highlighter(highlight().field("field1").order("score").preTags("<x>").postTags("</x>").highlighterType(highlighterType));
            .put("index.analysis.filter.synonym.type", "synonym")
            0,
    public HighlighterWithAnalyzersTests(Settings staticSettings) {
            .startObject("_doc")
    }
 * this work for additional information regarding copyright
import org.opensearch.plugins.Plugin;  
        Settings.Builder builder = Settings.builder()
                            "{ => ALPHANUM"
                    "field4",
            .setId("1")
        client().prepareIndex("second_test_index")
import static org.opensearch.index.query.QueryBuilders.matchPhraseQuery;
            1,  
                        + "feature Test: http://www.facebook.com http://elasticsearch.org "  
            .setId("0")  
                "field1",
        client().prepareIndex("test").setId("1").setSource("name", "ARCOTEL Hotels Deutschland").get();
            "field4",
        for (int i = 0; i < 2; i++) {
         * MultiPhraseQuery can literally kill an entire node if there are too many terms in the  
        // with synonyms
        SearchSourceBuilder source = searchSource().query(matchAllQuery());
    public void testSynonyms() throws IOException {  
            searchResponse,
import java.io.IOException;
        );
                    "Test: http://www.facebook.com "  
                        .putList("analysis.analyzer.autocomplete.filter", "lowercase", "wordDelimiter")
            "field1",
            .get();  
        source = searchSource().query(matchPhrasePrefixQuery("field0", "quick bro"))  
        logger.info("--> highlighting and searching on field1");  
        source = searchSource().query(matchPhrasePrefixQuery("field1", "quick bro"))  
                            "! => ALPHANUM",  
 * Modifications Copyright OpenSearch Contributors. See
            anyOf(
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
            .get();
            .setQuery(  
            .startObject()  
            )  
 * You may obtain a copy of the License at  
/*  
                equalTo("The <x>quick</x> <x>brown</x> fox jumps over the lazy dog")  
        assertHighlight(
        ensureGreen();  
            logger.info("--> highlighting (type=" + highlighterType + ") and searching on field1");
                        .putList("analysis.analyzer.custom_analyzer.filter", "lowercase", "wordDelimiter")
            .put("index.analysis.analyzer.synonym.tokenizer", "standard")  
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHighlight;
        assertHighlight(searchResponse, 0, "field3", 0, 1, equalTo("The <x>quick</x> <x>brown</x> fox jumps over the lazy dog"));
                "The quick brown fox jumps over the lazy dog"
        search = client().prepareSearch()
                equalTo("<x>The</x> <x>quick</x> <x>browse</x> button is a fancy thing, right bro?"),
            .endObject()
        assertHighlight(searchResponse, 0, "field0", 0, 1, equalTo("The quick <x>brown</x> fox jumps over the lazy dog"));
            searchResponse,  
 * under the License.  
            .put(indexSettings())
        refresh();  
                    "field3",  
            1,  
                            "analysis.filter.wordDelimiter.type_table",  
        );  
            1,
            .get();
                        .put(IndexSettings.MAX_NGRAM_DIFF_SETTING.getKey(), 19)
import static org.opensearch.index.query.QueryBuilders.matchQuery;
    public void testNgramHighlightingWithBrokenPositions() throws IOException {
        );  
            .query(matchPhrasePrefixQuery("field4", "the fast bro"))  
            .endObject();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;  
                        .put("analysis.analyzer.autocomplete.tokenizer", "autocomplete")
        assertAcked(
            .setSource("field1", "The quick browse button is a fancy thing, right bro?")  
            .execute()  
                    equalTo("The quick <x>brown</x> fox jumps over the lazy dog")
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
        );
                    .field("analyzer", "autocomplete")
 *
            .highlighter(new HighlightBuilder().field("body").highlighterType("fvh"))
                .highlighter(highlight().field("field1").order("score").preTags("<x>").postTags("</x>"));  
            .query(matchPhrasePrefixQuery("field3", "fast bro"))  
        refresh();  
            .startObject("properties")
    public static Collection<Object[]> parameters() {
package org.opensearch.analysis.common;
                "field3",  
import org.opensearch.search.builder.SearchSourceBuilder;
            .highlighter(highlight().field("field0").order("score").preTags("<x>").postTags("</x>"));
                            "@ => ALPHANUM",
                        .put("analysis.filter.wordDelimiter.catenate_all", false)
    public void testPhrasePrefix() throws IOException {  
 * compatible open source license.
                        .put("analysis.filter.wordDelimiter.catenate_numbers", true)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        .put(indexSettings())
                )
            0,
                        .put("analysis.analyzer.custom_analyzer.tokenizer", "whitespace")  
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;
                        .put("analysis.filter.wordDelimiter.catenate_all", false)
                "Test: http://www.facebook.com http://elasticsearch.org "
                jsonBuilder().startObject()
                        .putList(
            .putList("index.analysis.filter.synonym.synonyms", "fast,quick");  
                        .put("analysis.filter.wordDelimiter.type.split_on_numerics", false)  
            .get();  
                        + "http://quora.com http://twitter.com this is a test for highlighting "
        }  
                        .put("analysis.filter.wordDelimiter.catenate_numbers", true)
            "field4",  
            .highlighter(highlight().field("field3").order("score").preTags("<x>").postTags("</x>"));
import org.opensearch.action.search.SearchResponse;  
                .setMapping(  
import static org.hamcrest.Matchers.anyOf;
                            ". => ALPHANUM",
        }
        client().prepareIndex("second_test_index")
                "body",  
                    + "<em>http://xing.com</em> <em>http://cnn.com</em> http://quora.com"
            .field("term_vector", "with_positions_offsets")  
            0,  
import static org.opensearch.transport.client.Requests.searchRequest;
                    Settings.builder()  
                        + "is a test for highlighting feature"
            );  
            1,
            .setSource("type", "type2", "field4", "The quick browse button is a fancy thing, right bro?")  
                    Settings.builder()  
                equalTo("The <x>quick</x> <x>browse</x> button is a fancy thing, right bro?"),  
                "<em>Test</em>: "
        return Arrays.asList(
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
            1,  
            .highlighter(new HighlightBuilder().field("body").highlighterType("fvh"))
        assertHighlight(search, 0, "name.autocomplete", 0, equalTo("ARCO<em>TEL</em> Ho<em>tel</em>s <em>Deut</em>schland"));
                            "? => ALPHANUM",
            prepareCreate("test").setMapping(
        SearchResponse searchResponse = client().search(searchRequest("first_test_index").source(source)).actionGet();  
            .highlighter(highlight().field("field4").order("score").preTags("<x>").postTags("</x>"));
                        .put("analysis.analyzer.search_autocomplete.tokenizer", "whitespace")  
                )
import org.opensearch.index.IndexSettings;
    public static XContentBuilder type1TermVectorMapping() throws IOException {
        searchResponse = client().search(searchRequest("first_test_index").source(source)).actionGet();  
 * Unless required by applicable law or agreed to in writing,
        assertHighlight(
        searchResponse = client().search(searchRequest("second_test_index").source(source)).actionGet();
                    .startObject("fields")
                        .put("analysis.filter.wordDelimiter.type", "word_delimiter")
 *  
                            "+ => ALPHANUM",  
            searchResponse,
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
                        .put("analysis.tokenizer.autocomplete.min_gram", 1)
    public void testMultiPhraseCutoff() throws IOException {
                    "body",
        logger.info("--> highlighting and searching on field4");  
        client().prepareIndex("first_test_index")
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
                )  
            equalTo(
        assertHitCount(searchResponse, 2);
            prepareCreate("test").setMapping(  
import static org.hamcrest.Matchers.startsWith;
                            "] => ALPHANUM",
 * license agreements. See the NOTICE file distributed with
                        .put("analysis.filter.wordDelimiter.catenate_words", true)  
                        .put("analysis.filter.wordDelimiter.catenate_words", true)  
            .putList("index.analysis.analyzer.synonym.filter", "synonym", "lowercase")
            searchResponse,
                    .endObject()
 * the Apache License, Version 2.0 (the "License"); you may
    @ParametersFactory  
                    + "<em>http://www.facebook.com</em> <em>http://elasticsearch.org</em> "  
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
        assertAcked(  
                    .endObject()
            .startObject("field2")
            .highlighter(new HighlightBuilder().field("name.autocomplete"))
                            "( => ALPHANUM",  
                    equalTo("The quick <x>browse</x> button is a fancy thing, right <x>bro</x>?"),  
                        .put("analysis.tokenizer.autocomplete.max_gram", 20)  
/*  
    @Override
                anyOf(
 */  
                            "# => ALPHANUM",
            .put("index.analysis.filter.synonym.type", "synonym")
        refresh();
        searchResponse = client().search(searchRequest("second_test_index").source(source)).actionGet();  
