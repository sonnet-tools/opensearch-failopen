        source = searchSource().query(matchPhrasePrefixQuery("field1", "quick bro"))
            .put(indexSettings())
    @ParametersFactory
                        .put("analysis.filter.wordDelimiter.generate_number_parts", true)
            .highlighter(new HighlightBuilder().field("body").highlighterType("fvh"))
            .put("index.analysis.filter.synonym.type", "synonym")
import static org.opensearch.transport.client.Requests.searchRequest;
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
                    .field("type", "text")
                    "field1",
            1,
            0,
        ensureGreen();
        );
            .putList("index.analysis.analyzer.synonym.filter", "synonym", "lowercase")
            .field("term_vector", "with_positions_offsets")
        assertAcked(
    public void testSynonyms() throws IOException {
                    equalTo("The quick <x>brown</x> fox jumps over the lazy dog")
                equalTo("The <x>quick</x> <x>brown</x> fox jumps over the lazy dog")
        SearchSourceBuilder source = searchSource().query(matchAllQuery());
                        .putList("analysis.analyzer.autocomplete.filter", "lowercase", "wordDelimiter")
            .endObject()
                    + "http://twitter.com this is a test for highlighting feature"
            );
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
                            "+ => ALPHANUM",
                    .startObject("autocomplete")
    }
            SearchResponse searchResponse = client().search(searchRequest("test").source(source)).actionGet();
            .get();
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            "field4",
         * query. We cut off and extract terms if there are more than 16 terms in the query
            0,
        assertAcked(
import org.opensearch.action.search.SearchResponse;
 * specific language governing permissions and limitations
                    equalTo("The quick <x>browse</x> button is a fancy thing, right <x>bro</x>?"),
            .endObject()
        client().prepareIndex("first_test_index")
        client().prepareIndex("second_test_index")
        search = client().prepareSearch()
        assertHighlight(
import static org.opensearch.index.query.QueryBuilders.matchPhraseQuery;
            0,
                    .startObject("properties")
                    + "<em>http://xing.com</em> <em>http://cnn.com</em> http://quora.com"
                "field3",
        assertHighlight(search, 0, "body", 0, startsWith("<em>Test: http://www.facebook.com</em>"));
            0,
                .setMapping(
/*
                )
                    "type=text,term_vector=with_positions_offsets,search_analyzer=synonym," + "analyzer=standard,index_options=offsets"
            .highlighter(new HighlightBuilder().field("body").highlighterType("fvh"))
 *
        ensureGreen();
            .put("index.analysis.analyzer.synonym.tokenizer", "standard")
            .field("type", "text")
                        .put("analysis.tokenizer.autocomplete.type", "ngram")
            anyOf(equalTo("<x>a quick fast blue car</x>"), equalTo("<x>a</x> <x>quick</x> <x>fast</x> <x>blue</x> <x>car</x>"))
            anyOf(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
 * this file be licensed under the Apache-2.0 license or a
                )
            0,
 * You may obtain a copy of the License at
            searchResponse,
        }
                            "@ => ALPHANUM",
        );
}
/*
            equalTo(
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
            .put(indexSettings())
        searchResponse = client().search(searchRequest("first_test_index").source(source)).actionGet();
                    .endObject()
                        .put("analysis.filter.wordDelimiter.catenate_words", true)
            )
                equalTo("<x>The</x> <x>quick</x> <x>brown</x> fox jumps over the lazy dog")
        );
 */
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;
            anyOf(
        refresh();
        assertHighlight(
            0,
        assertAcked(
import java.util.Collection;
                "body",
        SearchResponse search = client().prepareSearch()
 */
                "type=text,analyzer=custom_analyzer," + "search_analyzer=custom_analyzer,term_vector=with_positions_offsets"
            .startObject("field2")
            1,
                    "Test: http://www.facebook.com "
    }
                        .put("analysis.filter.wordDelimiter.generate_number_parts", false)
        client().prepareIndex("first_test_index")
import static org.hamcrest.Matchers.anyOf;
                    .field("analyzer", "autocomplete")
import static org.opensearch.index.query.QueryBuilders.termQuery;
            .setSource("type", "type2", "field4", "The quick browse button is a fancy thing, right bro?")
            .putList("index.analysis.filter.synonym.synonyms", "quick => fast");
            .get();
            .setQuery(
        source = searchSource().query(matchPhrasePrefixQuery("field0", "bro"))
            0,
        ensureGreen();
package org.opensearch.analysis.common;
        searchResponse = client().search(searchRequest("first_test_index").source(source)).actionGet();
import static org.opensearch.search.builder.SearchSourceBuilder.searchSource;
        // with synonyms
 *    http://www.apache.org/licenses/LICENSE-2.0
                "field4",
            .putList("index.analysis.analyzer.synonym.filter", "synonym", "lowercase")
        return Arrays.asList(
            .setId("1")
            .highlighter(highlight().field("field0").order("score").preTags("<x>").postTags("</x>"));
                "type2",
        return XContentFactory.jsonBuilder()
                            "~ => ALPHANUM",
                "Test: http://www.facebook.com http://elasticsearch.org "
            )
            .setSource(
                        .put(indexSettings())
                equalTo("The <x>quick</x> <x>browse</x> button is a fancy thing, right bro?"),
                        .put(indexSettings())
        source = searchSource().query(matchPhrasePrefixQuery("field0", "quick bro"))
        assertHighlight(
            assertHighlight(
                    "body",
        SearchResponse search = client().prepareSearch("test")
        client().prepareIndex("second_test_index")
        /*
    }
    public HighlighterWithAnalyzersTests(Settings staticSettings) {
            .query(matchPhrasePrefixQuery("field4", "the fast bro"))
                    .field("search_analyzer", "search_autocomplete")
            .put("index.analysis.analyzer.synonym.tokenizer", "standard")
            .field("term_vector", "with_positions_offsets")
 *
            .get();
            anyOf(
        );
                .setMapping(
        refresh();
        refresh();
    @Override
        source = searchSource().postFilter(termQuery("type", "type2"))
        for (String highlighterType : new String[] { "plain", "fvh", "unified" }) {
        );
            .endObject()
                            "[ => ALPHANUM",
                        .put("analysis.filter.wordDelimiter.catenate_words", true)
                equalTo("<x>The</x> <x>quick</x> <x>brown</x> fox jumps over the lazy dog")
    public void testMultiPhraseCutoff() throws IOException {
            assertHighlight(searchResponse, 0, "field1", 0, 1, equalTo("The <x>quick</x> <x>brown</x> <x>fox</x> jumps over the lazy dog"));
            searchResponse = client().search(searchRequest("test").source(source)).actionGet();
        assertHighlight(
        Settings.Builder builder = Settings.builder()
                            "| => ALPHANUM",
import org.opensearch.search.builder.SearchSourceBuilder;
                        .put("analysis.analyzer.custom_analyzer.tokenizer", "whitespace")
    public void testPhrasePrefix() throws IOException {
            .endObject()
            )
import static org.opensearch.index.query.QueryBuilders.matchQuery;
                    .field("term_vector", "with_positions_offsets")
            .query(matchPhrasePrefixQuery("field3", "fast bro"))
            .setQuery(matchPhraseQuery("body", "Test: http://www.facebook.com "))
import java.io.IOException;
            .setId("1")
        assertHighlight(searchResponse, 0, "field3", 0, 1, equalTo("The <x>quick</x> <x>brown</x> fox jumps over the lazy dog"));
            SearchSourceBuilder source = searchSource().query(matchQuery("field1", "quick brown fox").operator(Operator.AND))
                    Settings.builder()
        client().prepareIndex("second_test_index").setId("2").setSource("type", "type2", "field4", "a quick fast blue car").get();
                            "analysis.filter.wordDelimiter.type_table",
        );
                1,
                        .put("analysis.filter.wordDelimiter.catenate_all", false)
                    "type=text,term_vector=with_positions_offsets,analyzer=synonym",
 * the Apache License, Version 2.0 (the "License"); you may
                            ", => ALPHANUM",
    }
                    .endObject()
        refresh();
            "field4",
                    + "a test for highlighting feature Test: http://www.facebook.com "
                            "^ => ALPHANUM",
        searchResponse = client().search(searchRequest("second_test_index").source(source)).actionGet();
                anyOf(
            0,
                            "} => ALPHANUM",
                        .put(IndexSettings.MAX_NGRAM_DIFF_SETTING.getKey(), 19)
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
                        .put("analysis.tokenizer.autocomplete.min_gram", 1)
        assertHighlight(search, 0, "name.autocomplete", 0, equalTo("ARCO<em>TEL</em> Ho<em>tel</em>s <em>Deut</em>schland"));
                        + "http://xing.com http://cnn.com http://quora.com http://twitter.com this "
 * compatible open source license.
                "The quick brown fox jumps over the lazy dog",
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            prepareCreate("test").setMapping(
                    .startObject("fields")
                        .put("analysis.filter.wordDelimiter.type.split_on_numerics", false)
            .query(matchPhrasePrefixQuery("field4", "a fast quick blue ca"))
        client().prepareIndex("test").setId("1").setSource("name", "ARCOTEL Hotels Deutschland").get();
            .setSource("field1", "The quick browse button is a fancy thing, right bro?")
            .get();
        SearchResponse searchResponse = client().search(searchRequest("first_test_index").source(source)).actionGet();
                0,
                )
 * Licensed to Elasticsearch under one or more contributor
            "body",
                            "- => ALPHANUM",
            .startObject("_doc")
        searchResponse = client().search(searchRequest("first_test_index").source(source)).actionGet();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
            "field1",
                        + "is a test for highlighting feature"
            )
 * KIND, either express or implied.  See the License for the
import org.opensearch.plugins.Plugin;
                .highlighter(highlight().field("field1").order("score").preTags("<x>").postTags("</x>"));
            .highlighter(highlight().field("field3").order("score").preTags("<x>").postTags("</x>"));
import org.opensearch.index.query.Operator;
                            "# => ALPHANUM",
            .startObject()
        assertAcked(prepareCreate("first_test_index").setSettings(builder.build()).setMapping(type1TermVectorMapping()));
        client().prepareIndex("test")
 * SPDX-License-Identifier: Apache-2.0
                "The quick brown fox jumps over the lazy dog"
/*
                )
                .setSettings(
import static org.hamcrest.Matchers.equalTo;
            )
        logger.info("--> highlighting and searching on field4");
        refresh();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHighlight;
 * license agreements. See the NOTICE file distributed with
    }
import static org.hamcrest.Matchers.startsWith;
            .setSource(
 *
                            ": => ALPHANUM",
            search,
                    .field("type", "text")
            prepareCreate("second_test_index").setSettings(builder.build())
                .setSettings(
            "field4",
                equalTo("<x>The</x> <x>quick</x> <x>browse</x> button is a fancy thing, right bro?"),
            .get();
    }
            .putList("index.analysis.filter.synonym.synonyms", "fast,quick");
            assertHighlight(searchResponse, 0, "field1", 0, 1, equalTo("The <x>quick</x> <x>brown</x> <x>fox</x> jumps over the lazy dog"));
        logger.info("--> highlighting and searching on field4");
                equalTo("The <x>quick</x> <x>browse</x> button is a fancy thing, right bro?"),
                i,
        assertHitCount(searchResponse, 2);
            0,
                "field1",
        assertAcked(
import static org.opensearch.search.builder.SearchSourceBuilder.highlight;
 * GitHub history for details.
            1,
        searchResponse = client().search(searchRequest("first_test_index").source(source)).actionGet();
    protected Collection<Class<? extends Plugin>> nodePlugins() {
import static org.opensearch.index.query.QueryBuilders.boolQuery;
            .setId("1")
            )
    public static XContentBuilder type1TermVectorMapping() throws IOException {
            )
    public static Collection<Object[]> parameters() {
                        .put("analysis.tokenizer.autocomplete.max_gram", 20)
                        .put("analysis.filter.wordDelimiter.generate_word_parts", true)
                    .endObject()
    }
            .setSource("field0", "The quick brown fox jumps over the lazy dog", "field1", "The quick brown fox jumps over the lazy dog")
            prepareCreate("test").setSettings(builder.build())
            .endObject();
            )
        logger.info("--> highlighting and searching on field1");
        assertHighlight(searchResponse, 0, "field0", 0, 1, equalTo("The quick <x>brown</x> fox jumps over the lazy dog"));
            .startObject("field1")
                            "/ => ALPHANUM",
        searchResponse = client().search(searchRequest("second_test_index").source(source)).actionGet();
            1,
    public void testNgramHighlightingWithBrokenPositions() throws IOException {
        searchResponse = client().search(searchRequest("second_test_index").source(source)).actionGet();
 * The OpenSearch Contributors require contributions made to
                matchPhraseQuery(
                equalTo("<x>The</x> <x>quick</x> <x>browse</x> button is a fancy thing, right bro?"),
 * ownership. Elasticsearch licenses this file to you under
        );
                )
            searchResponse,
import org.opensearch.index.IndexSettings;
 * software distributed under the License is distributed on an
            .execute()
                        .put("analysis.filter.wordDelimiter.catenate_numbers", true)
            1,
        Settings.Builder builder = Settings.builder()
        assertHighlight(
        assertHighlight(
        source = searchSource().query(
        logger.info("--> highlighting and searching on field0");
                searchResponse,
                equalTo("The <x>quick</x> <x>brown</x> fox jumps over the lazy dog")
            .setId("0")
                        .put("analysis.filter.wordDelimiter.catenate_all", false)
                        .put("analysis.analyzer.autocomplete.tokenizer", "autocomplete")
        );
                    .endObject()
            .highlighter(highlight().field("field4").order("score").preTags("<x>").postTags("</x>"));
    }
            searchResponse,
        }
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                            "! => ALPHANUM",
            prepareCreate("test").setMapping(
import static org.opensearch.index.query.QueryBuilders.matchPhrasePrefixQuery;
            .highlighter(new HighlightBuilder().field("name.autocomplete"))
            )
            1,
            .get();
                    "field4",
            1,
                        .put("analysis.filter.wordDelimiter.type.split_on_numerics", false)
 * Unless required by applicable law or agreed to in writing,
        client().prepareIndex("test").setId("0").setSource("field1", "The quick brown fox jumps over the lazy dog").get();
            .setId("0")
            )
        ).highlighter(highlight().field("field1").order("score").preTags("<x>").postTags("</x>"));
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
 * under the License.
                    + "<em>http://www.facebook.com</em> <em>http://elasticsearch.org</em> "
            searchResponse,
        for (int i = 0; i < 2; i++) {
        );
                            "% => ALPHANUM",
                        .put("analysis.filter.wordDelimiter.type", "word_delimiter")
            .startObject("properties")
                    "field3",
                            ". => ALPHANUM",
         * MultiPhraseQuery can literally kill an entire node if there are too many terms in the
 * this work for additional information regarding copyright
                            "& => ALPHANUM",
                    + "http://xing.com http://cnn.com http://quora.com http://twitter.com this is "
import org.opensearch.common.xcontent.XContentFactory;
            .highlighter(highlight().field("field0").order("score").preTags("<x>").postTags("</x>"));
                    + "http://elasticsearch.org http://xing.com http://cnn.com http://quora.com "
                        .put("analysis.tokenizer.autocomplete.token_chars", "letter,digit")
                            "( => ALPHANUM",
import org.opensearch.common.settings.Settings;
public class HighlighterWithAnalyzersTests extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
                "type",
                            "? => ALPHANUM",
                        + "http://elasticsearch.org http://xing.com http://cnn.com "
                            "$ => ALPHANUM",
            .setQuery(matchQuery("name.autocomplete", "deut tel").operator(Operator.OR))
 * not use this file except in compliance with the License.
                "<em>Test</em>: "
            searchResponse,
            0,
        source = searchSource().postFilter(termQuery("type", "type2"))
                jsonBuilder().startObject()
                .highlighter(highlight().field("field1").order("score").preTags("<x>").postTags("</x>").highlighterType(highlighterType));
        );
                        .putList(
                )
            .field("type", "text")
                        + "feature Test: http://www.facebook.com http://elasticsearch.org "
                            ") => ALPHANUM",
import org.opensearch.core.xcontent.XContentBuilder;
                        )
            "field1",
        super(staticSettings);
            .actionGet();
                "body",
 */
                    .startObject("name")
                        .put("analysis.filter.wordDelimiter.catenate_numbers", true)
            anyOf(
                    .endObject()
         */
                        .putList("analysis.analyzer.search_autocomplete.filter", "lowercase", "wordDelimiter")
import java.util.Arrays;
            source = searchSource().query(matchQuery("field1", "fast brown fox").operator(Operator.AND))
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
                        .put("analysis.filter.wordDelimiter.generate_word_parts", true)
        return Arrays.asList(CommonAnalysisModulePlugin.class);
                        .put("analysis.filter.wordDelimiter.type", "word_delimiter")
            .highlighter(highlight().field("field4").order("score").preTags("<x>").postTags("</x>"));
            boolQuery().should(matchPhrasePrefixQuery("field1", "test")).should(matchPhrasePrefixQuery("field1", "bro"))
            .highlighter(highlight().field("field1").order("score").preTags("<x>").postTags("</x>"));
                    Settings.builder()
        assertHighlight(searchResponse, 0, "field0", 0, 1, equalTo("The <x>quick</x> <x>brown</x> fox jumps over the lazy dog"));
        source = searchSource().postFilter(termQuery("type", "type2"))
                            "{ => ALPHANUM"
            .get();
            .put("index.analysis.filter.synonym.type", "synonym")
                    "type=text,analyzer=synonym"
                        + "http://quora.com http://twitter.com this is a test for highlighting "
            logger.info("--> highlighting (type=" + highlighterType + ") and searching on field1");
        );
                        .putList("analysis.analyzer.custom_analyzer.filter", "lowercase", "wordDelimiter")
                            "] => ALPHANUM",
                        .put("analysis.analyzer.search_autocomplete.tokenizer", "whitespace")
