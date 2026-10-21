    */
                new SearchSourceBuilder().fetchSource(false)
 * specific language governing permissions and limitations
            .source(new SearchSourceBuilder().fetchSource(false).sort("collate", SortOrder.ASC).sort("id", SortOrder.DESC));
    */
                .setSource("{\"id\":\"1\",\"collate\":\"" + equivalent[0] + "\"}", MediaTypeRegistry.JSON),
        // both values should collate to same value
            true,
        );
    * Turkish has some funny casing.
        SearchResponse response = client().search(request).actionGet();
    *
        assertNoFailures(response);
    * For german, you might want oe to sort and match with o umlaut.
                    .sort("id", SortOrder.DESC) // secondary sort should kick in because both will collate to same value
            .endObject();
            .startObject("collate")
            .endObject()
        assertAcked(client().admin().indices().prepareCreate(index).setMapping(builder));
import org.opensearch.index.query.QueryBuilders;
                .setSource("{\"id\":\"2\",\"collate\":\"" + equivalent[1] + "\"}", MediaTypeRegistry.JSON)
        assertNoFailures(response);
            .field("language", "en")
    * Setting alternate=shifted to shift whitespace, punctuation and symbols
            .field("strength", "tertiary")
                .setId("2")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
            .field("type", "icu_collation_keyword")
                .setSource("{\"id\":\"1\",\"collate\":\"" + equivalent[0] + "\"}", MediaTypeRegistry.JSON),
    * before lowercase ones.
        assertOrderedSearchHits(response, "2", "1");
            .field("language", "tr")
        XContentBuilder builder = jsonBuilder().startObject()
            client().prepareIndex(index)
        SearchRequest request = new SearchRequest().indices(index)
                    .sort(SortBuilders.fieldSort("collate").sortMode(SortMode.MAX).order(SortOrder.DESC))
                new SearchSourceBuilder().fetchSource(false)
        assertNoFailures(response);
            client().prepareIndex(index)
 * not use this file except in compliance with the License.
        XContentBuilder builder = jsonBuilder().startObject()
                .setSource("{\"id\":\"1\",\"collate\":\"" + equivalent[0] + "\"}", MediaTypeRegistry.JSON),
            .endObject()
                                                                                                                      // should kick in on
        response = client().search(request).actionGet();
        assertAcked(client().admin().indices().prepareCreate(index).setMapping(builder));
            .field("strength", "primary")
                    .query(QueryBuilders.termQuery("collate", randomBoolean() ? equivalent[0] : equivalent[1]))
            .endObject()
        );
        SearchRequest request = new SearchRequest().indices(index)
    }
/*
        assertOrderedSearchHits(response, "2", "1");
        assertNoFailures(response);
import com.ibm.icu.util.ULocale;
            client().prepareIndex(index).setId("4").setSource("{\"id\":\"4\",\"collate\":\"Résumé\"}", MediaTypeRegistry.JSON)
            .field("strength", "primary")
    }
            .field("decomposition", "no")
    /*
    /*
    */
            .endObject()
    * This is not the default, but you can make a customized ruleset to do this.
        request = new SearchRequest().indices(index)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertOrderedSearchHits;
            .field("type", "keyword")
            .startObject("properties")
        XContentBuilder builder = jsonBuilder().startObject()
        assertOrderedSearchHits(response, "1", "2");
                    .query(QueryBuilders.termQuery("collate", randomBoolean() ? equivalent[0] : equivalent[1]))
 * ownership. Elasticsearch licenses this file to you under
            .startObject("collate")
import org.opensearch.search.sort.SortBuilders;
 *
 */
            .startObject("collate")
            .source(
    * Test usage of the decomposition option for unicode normalization.
        // searching for either of the terms should return both results since they collate to the same value
    }
            .field("index", false)
/*
            .startObject("collate")
        return Collections.singletonList(AnalysisICUPlugin.class);
    @Override
            .endObject()
import org.opensearch.test.OpenSearchIntegTestCase;
        SearchResponse response = client().search(request).actionGet();
                    .query(QueryBuilders.termQuery("collate", "a"))
            client().prepareIndex(index).setId("1").setSource("{\"collate\":\"foobar-10\"}", MediaTypeRegistry.JSON),
    * punctuation or symbols, to quaternary level
                                                                                                                      // docs 1 and 3
            .endObject()
    /*
            .startObject("properties")
            .endObject()
    *  http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=4423383
        indexRandom(
            true,
            .source(
            .endObject()
        assertOrderedSearchHits(response, "2", "1");
        // everything should be indexed fine, no exceptions
import org.opensearch.action.search.SearchRequest;
import org.opensearch.core.xcontent.MediaTypeRegistry;
                    .query(QueryBuilders.termQuery("collate", "a"))
        );
            .endObject();
 *
    public void testIgnoreWhitespace() throws Exception {
        assertHitCount(response, 3L);
            .source(
        // same thing, using different sort mode that will use a for both docs
    * Instead of using LowerCaseFilter, use a turkish collator with primary strength.
                .setId("2")
        SearchResponse response = client().search(request).actionGet();
            .endObject();
    }
            .field("decomposition", "canonical")
            );
        assertOrderedSearchHits(response, "2", "1");
            );
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
        SearchRequest request = new SearchRequest().indices(index)
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        String index = "foo";
        assertHitCount(response, 2L);
        assertHitCount(response, 2L);
    }
    * Then things will sort and match correctly.
                    .sort("id", SortOrder.DESC) // will NOT be ignored and will determine order
        assertHitCount(response, 2L);
        );
            );
            .field("language", "tr")
 * the Apache License, Version 2.0 (the "License"); you may
            );
            .endObject()
        );
        SearchResponse response = client().search(request).actionGet();
        SearchRequest request = new SearchRequest().indices(index)
            .field("type", "icu_collation_keyword")
    */
        SearchResponse response = client().search(request).actionGet();
        String index = "foo";
            .field("strength", "primary")
 * KIND, either express or implied.  See the License for the
            .startObject("collate")
            .field("type", "icu_collation_keyword")
            );
        assertOrderedSearchHits(response, "3", "1", "2");
                .setSource("{\"id\":\"2\",\"collate\":\"" + equivalent[2] + "\"}", MediaTypeRegistry.JSON)
 */
import com.ibm.icu.text.Collator;
                    .sort("id", SortOrder.DESC) // secondary sort should kick in because both will collate to same value
        String index = "foo";
        SearchRequest request = new SearchRequest().indices(index)
        assertHitCount(response, 2L);
            .source(
            client().prepareIndex(index).setId("1").setSource("{\"collate\":\"resume\"}", MediaTypeRegistry.JSON),
            true,
 * The OpenSearch Contributors require contributions made to
 * software distributed under the License is distributed on an
                    .sort("collate", SortOrder.ASC)
                    // if mode max we use c and b as sort values, if max we use "a" for both
                .setId("1")
            .startObject("id")
            client().prepareIndex(index).setId("2").setSource("{\"id\":\"2\",\"collate\":\"foobar\"}", MediaTypeRegistry.JSON),
import com.ibm.icu.text.RuleBasedCollator;
            .endObject()
            .field("index", false)
            .endObject()
    public void testIgnorePunctuation() throws Exception {
        assertNoFailures(response);
            .field("type", "keyword")
 * this file be licensed under the Apache-2.0 license or a
    * Setting caseLevel=true to create an additional case level between
            .field("type", "keyword")
    public void testBasicUsage() throws Exception {
                new SearchSourceBuilder().fetchSource(false)
            .field("type", "keyword")
        assertAcked(client().admin().indices().prepareCreate(index).setMapping(builder));
    */
                                                                                                                      // collate value
                    .query(QueryBuilders.termQuery("collate", randomBoolean() ? equivalent[0] : equivalent[1]))
            .startObject("properties")
            .field("index", false)
            true,
 * under the License.
        assertOrderedSearchHits(response, "2", "1");
            );
            .startObject("id")
        assertOrderedSearchHits(response, "2", "1");
        assertAcked(client().admin().indices().prepareCreate(index).setMapping(builder));
    }
    */
        assertOrderedSearchHits(response, "2", "1");
 */
        SearchResponse response = client().search(request).actionGet();
            .startObject("id")
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            .startObject("collate")
    }
        String index = "foo";
    public void testSecondaryStrength() throws Exception {
            .endObject()
        SearchRequest request = new SearchRequest().indices(index)
            .field("language", "en")
            client().prepareIndex(index)
        SearchResponse response = client().search(request).actionGet();
    * to quaternary level
 *
            .field("type", "icu_collation_keyword")
            .field("case_first", "upper")
        String tailoredRules = tailoredCollator.getRules();
            .endObject()
        assertHitCount(response, 2L);
    public void testIgnoreAccentsButNotCase() throws Exception {
        assertHitCount(response, 2L);
import org.opensearch.plugins.Plugin;
        assertAcked(client().admin().indices().prepareCreate(index).setMapping(builder));
            .field("index", false)
        assertNoFailures(response);
import org.opensearch.plugin.analysis.icu.AnalysisICUPlugin;
                new SearchSourceBuilder().fetchSource(false)
            .source(
            .startObject("id")
    }
            .endObject()
                .setId("1")
            .endObject()
            client().prepareIndex(index).setId("2").setSource("{\"collate\":\"Resume\"}", MediaTypeRegistry.JSON)
            client().prepareIndex(index)
            client().prepareIndex(index)
            .field("type", "keyword")
            .endObject();
            .startObject("properties")
 * SPDX-License-Identifier: Apache-2.0
        // using sort mode = max, values B and C will be used for the sort
        assertHitCount(response, 2L);
                    .sort("collate")
 * this work for additional information regarding copyright
                .setId("2")
 * Modifications Copyright OpenSearch Contributors. See
            .startObject("properties")
    * This test shows how you can solve this kind of thing easily with collation.
        );
            .field("variable_top", " ")
        assertHitCount(response, 4L);
}
            .startObject("id")
    /*
            .endObject();
                new SearchSourceBuilder().fetchSource(false)
import java.util.Collections;
            .field("case_level", true)
            .endObject()
            client().prepareIndex(index).setId("2").setSource("{\"id\":\"2\",\"collate\":\"Resume\"}", MediaTypeRegistry.JSON),
                .setId("1")
    /*
        String index = "foo";
        SearchRequest request = new SearchRequest().indices(index)
                .setSource("{\"id\":\"1\",\"collate\":\"" + equivalent[0] + "\"}", MediaTypeRegistry.JSON),
            .field("language", "en")
        XContentBuilder builder = jsonBuilder().startObject()
            .startObject("properties")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                .setId("2")
    }
        assertNoFailures(response);
            client().prepareIndex(index).setId("2").setSource("{\"collate\":\"foobar-9\"}", MediaTypeRegistry.JSON)
            .endObject()
        String[] equivalent = { "foo-bar", "foo bar" };
    public void testNumerics() throws Exception {
            client().prepareIndex(index).setId("3").setSource("{\"id\":\"3\",\"collate\":\"resume\"}", MediaTypeRegistry.JSON),
                .setId("2")
    */
            .field("type", "icu_collation_keyword")
        XContentBuilder builder = jsonBuilder().startObject()
        assertAcked(client().admin().indices().prepareCreate(index).setMapping(builder));
 * GitHub history for details.
            .field("alternate", "shifted")
        String index = "foo";
        String[] equivalent = { "TESTING", "testing" };
        indexRandom(
            client().prepareIndex(index)
            .startObject("properties")
                new SearchSourceBuilder().fetchSource(false)
    /*
        XContentBuilder builder = jsonBuilder().startObject()
            .startObject("collate")
        );
            true,
            .field("language", "en")
            true,
                .setId("1")
        SearchResponse response = client().search(request).actionGet();
                                                                                                                      // because same value
            true,
            client().prepareIndex(index)
        String index = "foo";
                .setId("1")
        assertHitCount(response, 2L);
        String index = "foo";
        SearchResponse response = client().search(request).actionGet();
    */
 * You may obtain a copy of the License at
    * Test secondary strength, for english case is not significant.
            .endObject()
        XContentBuilder builder = jsonBuilder().startObject()
import org.opensearch.search.sort.SortOrder;
 *    http://www.apache.org/licenses/LICENSE-2.0
            .field("type", "icu_collation_keyword")
                new SearchSourceBuilder().fetchSource(false)
            .endObject()
import org.opensearch.search.sort.SortMode;
            .startObject("properties")
        indexRandom(
            .startObject("properties")
    }
            .source(new SearchSourceBuilder().fetchSource(false).sort("collate", SortOrder.ASC));
        String[] equivalent = { "Töne", "Toene" };
                    .sort("collate")
        assertHitCount(response, 2L);
     * Setting numeric to encode digits with numeric value, so that
            .field("strength", "primary")
 * compatible open source license.
            .field("strength", "primary")
    /*
            .endObject();
                    .query(QueryBuilders.termQuery("collate", randomBoolean() ? equivalent[0] : equivalent[1]))
                    .sort("collate")
        assertAcked(client().admin().indices().prepareCreate(index).setMapping(builder));
     */
        indexRandom(
            .startObject("id")
        assertNoFailures(response);
        indexRandom(
            .field("type", "icu_collation_keyword")
            client().prepareIndex(index).setId("1").setSource("{\"id\":\"1\",\"collate\":\"résumé\"}", MediaTypeRegistry.JSON),
                .setSource("{\"id\":\"1\",\"collate\":\"" + equivalent[0] + "\"}", MediaTypeRegistry.JSON),
            .startObject("collate")
            .endObject()
            .field("language", "en")
import org.opensearch.action.search.SearchResponse;
            .endObject()
            client().prepareIndex(index)
            .endObject()
 * Licensed to Elasticsearch under one or more contributor
            client().prepareIndex(index).setId("1").setSource("{\"id\":\"1\",\"collate\":\"foo bar\"}", MediaTypeRegistry.JSON),
        assertNoFailures(response);
        assertAcked(client().admin().indices().prepareCreate(index).setMapping(builder));
            .startObject("id")
 * Unless required by applicable law or agreed to in writing,
                    .sort("id", SortOrder.DESC) // secondary sort should kick in because both will collate to same value
            client().prepareIndex(index).setId("3").setSource("{\"id\":\"3\",\"collate\":\"foo-bar\"}", MediaTypeRegistry.JSON)
        XContentBuilder builder = jsonBuilder().startObject()
        String index = "foo";
        XContentBuilder builder = jsonBuilder().startObject()
        assertNoFailures(response);
     * foobar-9 sorts before foobar-10
        RuleBasedCollator baseCollator = (RuleBasedCollator) Collator.getInstance(new ULocale("de_DE"));
            .field("type", "icu_collation_keyword")
            .startObject("properties")
        indexRandom(
        SearchRequest request = new SearchRequest().indices(index)
                    .sort("id", SortOrder.DESC) // will be ignored
            .source(new SearchSourceBuilder().fetchSource(false).sort("collate", SortOrder.ASC));
        RuleBasedCollator tailoredCollator = new RuleBasedCollator(baseCollator.getRules() + DIN5007_2_tailorings);
            .endObject();
                .setSource("{\"id\":\"2\",\"collate\":\"" + equivalent[1] + "\"}", MediaTypeRegistry.JSON)
                    .sort(SortBuilders.fieldSort("collate").sortMode(SortMode.MIN).order(SortOrder.DESC))
                new SearchSourceBuilder().fetchSource(false).sort("collate", SortOrder.ASC).sort("id", SortOrder.ASC) // secondary sort
            .source(
            .source(
            .field("strength", "secondary")
        String[] equivalent = { "a", "C", "a", "B" };
    /*
        indexRandom(
    /*
            client().prepareIndex(index)
            .field("language", "en")
        // searching for either of the terms should return both results since they collate to the same value
            .startObject("collate")
public class ICUCollationKeywordFieldMapperIT extends OpenSearchIntegTestCase {
        SearchRequest request = new SearchRequest().indices(index)
package org.opensearch.index.mapper;
            .startObject("collate")
            .field("type", "icu_collation_keyword")
            .field("rules", tailoredRules)
        String[] equivalent = { "I W\u0049\u0307LL USE TURKİSH CASING", "ı will use turkish casıng" };
            .endObject()
                .setId("2")
                .setSource("{\"id\":\"2\",\"collate\":\"" + equivalent[1] + "\"}", MediaTypeRegistry.JSON)
            true,
            .source(
        assertOrderedSearchHits(response, "3", "1", "4", "2");
        );
        indexRandom(
        XContentBuilder builder = jsonBuilder().startObject()
                .setSource("{\"id\":\"2\",\"collate\":\"" + equivalent[1] + "\"}", MediaTypeRegistry.JSON)
                    .sort("collate")
            .endObject()
        indexRandom(
        indexRandom(
    public void testCustomRules() throws Exception {
            .endObject()
            .field("type", "keyword")
            .field("strength", "primary")
        SearchResponse response = client().search(request).actionGet();
    * secondary and tertiary
        assertOrderedSearchHits(response, "2", "1");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            );
    public void testUpperCaseFirst() throws Exception {
            true,
        String DIN5007_2_tailorings = "& ae , a\u0308 & AE , A\u0308" + "& oe , o\u0308 & OE , O\u0308" + "& ue , u\u0308 & UE , u\u0308";
import org.opensearch.search.builder.SearchSourceBuilder;
                    .sort("id", SortOrder.DESC) // secondary sort should kick in because both will collate to same value
            .field("type", "keyword")
    * The default is DIN 5007-1, this shows how to tailor a collator to get DIN 5007-2 behavior.
            client().prepareIndex(index)
    public void testNormalization() throws Exception {
            .field("type", "keyword")
            .endObject()
                .setSource("{\"id\":\"1\", \"collate\":[\"" + equivalent[0] + "\", \"" + equivalent[1] + "\"]}", MediaTypeRegistry.JSON),
import org.opensearch.core.xcontent.XContentBuilder;
        assertAcked(client().admin().indices().prepareCreate(index).setMapping(builder));
import java.util.Collection;
                    // if mode max we use c and b as sort values, if max we use "a" for both
            .startObject("id")
        String[] equivalent = { "I WİLL USE TURKİSH CASING", "ı will use turkish casıng" };
    }
        assertAcked(client().admin().indices().prepareCreate(index).setMapping(builder));
    public void testMultipleValues() throws Exception {
            .field("alternate", "shifted")
        String index = "foo";
            .field("numeric", true)
 * license agreements. See the NOTICE file distributed with
                .setId("1")
            .endObject()
    * Setting alternate=shifted and variableTop to shift whitespace, but not
                    .query(QueryBuilders.termQuery("collate", randomBoolean() ? equivalent[0] : equivalent[1]))
    * Setting caseFirst=upper to cause uppercase strings to sort
                    .sort("id", SortOrder.DESC) // secondary sort should kick in because both will collate to same value
            .endObject();
            client().prepareIndex(index)
            client().prepareIndex(index)
        assertNoFailures(response);
            true,
            .endObject()
            .field("language", "en")
            .endObject();
        );
        SearchRequest request = new SearchRequest().indices(index)
                .setSource("{\"id\":\"2\",\"collate\":\"" + equivalent[1] + "\"}", MediaTypeRegistry.JSON)
            .endObject();
        );
            .field("type", "icu_collation_keyword")
            );
/*
