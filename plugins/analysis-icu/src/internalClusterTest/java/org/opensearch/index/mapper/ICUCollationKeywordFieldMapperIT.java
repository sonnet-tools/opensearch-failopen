            .field("index", false)
        assertNoFailures(response);  
        assertOrderedSearchHits(response, "2", "1");
        indexRandom(
    * Setting caseFirst=upper to cause uppercase strings to sort  
        String index = "foo";
public class ICUCollationKeywordFieldMapperIT extends OpenSearchIntegTestCase {
                .setSource("{\"id\":\"2\",\"collate\":\"" + equivalent[1] + "\"}", MediaTypeRegistry.JSON)  
        assertOrderedSearchHits(response, "2", "1");
            .source(new SearchSourceBuilder().fetchSource(false).sort("collate", SortOrder.ASC).sort("id", SortOrder.DESC));  
            .field("strength", "primary")
                .setSource("{\"id\":\"1\",\"collate\":\"" + equivalent[0] + "\"}", MediaTypeRegistry.JSON),
            .endObject()  
            .endObject()
            .startObject("id")
        assertOrderedSearchHits(response, "1", "2");  
        String[] equivalent = { "Töne", "Toene" };  
        XContentBuilder builder = jsonBuilder().startObject()
        XContentBuilder builder = jsonBuilder().startObject()  
        indexRandom(
            client().prepareIndex(index).setId("2").setSource("{\"collate\":\"Resume\"}", MediaTypeRegistry.JSON)
            );
                .setSource("{\"id\":\"2\",\"collate\":\"" + equivalent[1] + "\"}", MediaTypeRegistry.JSON)
                .setId("2")
            client().prepareIndex(index).setId("1").setSource("{\"id\":\"1\",\"collate\":\"résumé\"}", MediaTypeRegistry.JSON),
            true,
        assertOrderedSearchHits(response, "2", "1");
/*
        String index = "foo";  
        SearchRequest request = new SearchRequest().indices(index)
            .field("language", "tr")  
            client().prepareIndex(index)
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.index.mapper;
            .field("type", "icu_collation_keyword")
        assertHitCount(response, 2L);  
        XContentBuilder builder = jsonBuilder().startObject()  
            .field("strength", "primary")
        assertHitCount(response, 2L);
            client().prepareIndex(index).setId("1").setSource("{\"collate\":\"foobar-10\"}", MediaTypeRegistry.JSON),
                                                                                                                      // because same value  
}
            .source(  
            .source(new SearchSourceBuilder().fetchSource(false).sort("collate", SortOrder.ASC));  
            );  
    /*
            .source(  
        );  
                .setId("1")
                .setSource("{\"id\":\"1\",\"collate\":\"" + equivalent[0] + "\"}", MediaTypeRegistry.JSON),  
            .field("strength", "primary")
 * this work for additional information regarding copyright
            .field("type", "icu_collation_keyword")  
        SearchRequest request = new SearchRequest().indices(index)  
            .source(
        indexRandom(
            true,
        String[] equivalent = { "I WİLL USE TURKİSH CASING", "ı will use turkish casıng" };
            .startObject("collate")
    public void testSecondaryStrength() throws Exception {
 * under the License.  
/*
            .endObject()
            .startObject("collate")
            .field("alternate", "shifted")  
        SearchResponse response = client().search(request).actionGet();  
            .startObject("properties")  
                .setId("2")  
            .startObject("properties")  
            true,
            .startObject("properties")
            .startObject("collate")  
        assertHitCount(response, 2L);
            );
        SearchResponse response = client().search(request).actionGet();
 *
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.action.search.SearchResponse;
import com.ibm.icu.text.Collator;  
    * This test shows how you can solve this kind of thing easily with collation.
    * before lowercase ones.
            .startObject("properties")
            );  
        SearchRequest request = new SearchRequest().indices(index)
import org.opensearch.search.builder.SearchSourceBuilder;
            .field("alternate", "shifted")
    */  
            .field("decomposition", "no")  
                    .query(QueryBuilders.termQuery("collate", "a"))  
            .endObject()  
import org.opensearch.core.xcontent.XContentBuilder;  
                    .sort("id", SortOrder.DESC) // secondary sort should kick in because both will collate to same value
            .field("type", "icu_collation_keyword")  
        assertAcked(client().admin().indices().prepareCreate(index).setMapping(builder));
    /*
        // everything should be indexed fine, no exceptions  
    *  http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=4423383
            .startObject("properties")
        SearchResponse response = client().search(request).actionGet();
            client().prepareIndex(index).setId("3").setSource("{\"id\":\"3\",\"collate\":\"resume\"}", MediaTypeRegistry.JSON),
            .endObject()
                .setSource("{\"id\":\"2\",\"collate\":\"" + equivalent[2] + "\"}", MediaTypeRegistry.JSON)
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.index.query.QueryBuilders;
            .field("type", "icu_collation_keyword")
import org.opensearch.search.sort.SortMode;  
import org.opensearch.core.xcontent.MediaTypeRegistry;
        assertHitCount(response, 3L);  
            .endObject();
    public void testBasicUsage() throws Exception {
    public void testNumerics() throws Exception {
                .setId("1")  
            .startObject("id")
                    .sort("id", SortOrder.DESC) // secondary sort should kick in because both will collate to same value
    }  
 */
     * Setting numeric to encode digits with numeric value, so that
                new SearchSourceBuilder().fetchSource(false)
    public void testIgnoreWhitespace() throws Exception {  
            );
        assertAcked(client().admin().indices().prepareCreate(index).setMapping(builder));
        assertNoFailures(response);
        // same thing, using different sort mode that will use a for both docs
        String index = "foo";
            client().prepareIndex(index).setId("2").setSource("{\"collate\":\"foobar-9\"}", MediaTypeRegistry.JSON)  
    * The default is DIN 5007-1, this shows how to tailor a collator to get DIN 5007-2 behavior.  
    * Test usage of the decomposition option for unicode normalization.
                    .sort(SortBuilders.fieldSort("collate").sortMode(SortMode.MAX).order(SortOrder.DESC))
            .source(
            client().prepareIndex(index).setId("2").setSource("{\"id\":\"2\",\"collate\":\"foobar\"}", MediaTypeRegistry.JSON),  
    }
                    .query(QueryBuilders.termQuery("collate", randomBoolean() ? equivalent[0] : equivalent[1]))  
    * punctuation or symbols, to quaternary level
    }
        SearchRequest request = new SearchRequest().indices(index)  
    }
        SearchRequest request = new SearchRequest().indices(index)  
            true,
        assertAcked(client().admin().indices().prepareCreate(index).setMapping(builder));
        assertHitCount(response, 2L);
            .field("case_level", true)
            .field("type", "icu_collation_keyword")
            .startObject("collate")
                    .query(QueryBuilders.termQuery("collate", randomBoolean() ? equivalent[0] : equivalent[1]))
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
        String[] equivalent = { "TESTING", "testing" };
        assertOrderedSearchHits(response, "2", "1");  
 *    http://www.apache.org/licenses/LICENSE-2.0
        String index = "foo";  
            .startObject("id")
        SearchRequest request = new SearchRequest().indices(index)  
    */  
            .field("type", "keyword")  
            .source(
        assertHitCount(response, 4L);
            client().prepareIndex(index)
            client().prepareIndex(index)  
import org.opensearch.action.search.SearchRequest;  
        String[] equivalent = { "a", "C", "a", "B" };
            client().prepareIndex(index).setId("1").setSource("{\"id\":\"1\",\"collate\":\"foo bar\"}", MediaTypeRegistry.JSON),
 * Modifications Copyright OpenSearch Contributors. See  
            .endObject()  
            .field("strength", "secondary")
        String[] equivalent = { "foo-bar", "foo bar" };
            .field("type", "icu_collation_keyword")
                .setSource("{\"id\":\"2\",\"collate\":\"" + equivalent[1] + "\"}", MediaTypeRegistry.JSON)
import org.opensearch.test.OpenSearchIntegTestCase;
        assertAcked(client().admin().indices().prepareCreate(index).setMapping(builder));
        String index = "foo";  
    /*
            .field("variable_top", " ")
    }  
            .field("case_first", "upper")  
            .field("type", "icu_collation_keyword")
        assertAcked(client().admin().indices().prepareCreate(index).setMapping(builder));  
        assertNoFailures(response);  
        String index = "foo";
        String tailoredRules = tailoredCollator.getRules();
            client().prepareIndex(index)  
            .endObject()
    public void testMultipleValues() throws Exception {
        assertNoFailures(response);
            .startObject("properties")  
            .field("type", "icu_collation_keyword")  
    /*
/*  
                                                                                                                      // docs 1 and 3
                .setSource("{\"id\":\"1\",\"collate\":\"" + equivalent[0] + "\"}", MediaTypeRegistry.JSON),  
                new SearchSourceBuilder().fetchSource(false)
        XContentBuilder builder = jsonBuilder().startObject()
            .endObject();
                    .sort("collate")
            true,
                    .sort("id", SortOrder.DESC) // secondary sort should kick in because both will collate to same value
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        XContentBuilder builder = jsonBuilder().startObject()
            client().prepareIndex(index).setId("3").setSource("{\"id\":\"3\",\"collate\":\"foo-bar\"}", MediaTypeRegistry.JSON)
        assertHitCount(response, 2L);
        assertOrderedSearchHits(response, "2", "1");
            .endObject();
    * Instead of using LowerCaseFilter, use a turkish collator with primary strength.
            .field("language", "en")
            .endObject()
        RuleBasedCollator baseCollator = (RuleBasedCollator) Collator.getInstance(new ULocale("de_DE"));  
    public void testUpperCaseFirst() throws Exception {  
    }
            .field("type", "icu_collation_keyword")
        XContentBuilder builder = jsonBuilder().startObject()  
            .field("type", "keyword")  
    public void testIgnoreAccentsButNotCase() throws Exception {
            .startObject("collate")  
        indexRandom(  
            .endObject()
            .endObject()
            .startObject("properties")
                    .sort(SortBuilders.fieldSort("collate").sortMode(SortMode.MIN).order(SortOrder.DESC))
        SearchResponse response = client().search(request).actionGet();  
            .startObject("collate")
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
import org.opensearch.search.sort.SortOrder;
            .endObject()
                new SearchSourceBuilder().fetchSource(false)
            .startObject("properties")
        String index = "foo";  
        indexRandom(  
            .source(new SearchSourceBuilder().fetchSource(false).sort("collate", SortOrder.ASC));
        assertOrderedSearchHits(response, "2", "1");  
            .endObject()  
            .endObject()  
 * KIND, either express or implied.  See the License for the
            .field("language", "tr")
            .endObject();
 * not use this file except in compliance with the License.
        XContentBuilder builder = jsonBuilder().startObject()  
            );  
        SearchRequest request = new SearchRequest().indices(index)
 * Unless required by applicable law or agreed to in writing,
        String index = "foo";
        assertHitCount(response, 2L);
            client().prepareIndex(index)  
    */
            .field("strength", "primary")
            .field("numeric", true)
 * specific language governing permissions and limitations
                    .query(QueryBuilders.termQuery("collate", randomBoolean() ? equivalent[0] : equivalent[1]))  
            .startObject("properties")
                    .query(QueryBuilders.termQuery("collate", randomBoolean() ? equivalent[0] : equivalent[1]))
        // using sort mode = max, values B and C will be used for the sort
            .endObject();  
                new SearchSourceBuilder().fetchSource(false)
        // both values should collate to same value  
        );
                .setId("2")
            true,
    * Setting caseLevel=true to create an additional case level between
    }  
    /*
                    .sort("collate")  
        SearchRequest request = new SearchRequest().indices(index)
            .endObject();
            .startObject("properties")
        assertHitCount(response, 2L);  
            .field("strength", "tertiary")
        XContentBuilder builder = jsonBuilder().startObject()
                .setSource("{\"id\":\"1\",\"collate\":\"" + equivalent[0] + "\"}", MediaTypeRegistry.JSON),
            .endObject();
        assertOrderedSearchHits(response, "3", "1", "4", "2");
            );
                    .sort("collate")
    public void testNormalization() throws Exception {  
            .endObject()  
        // searching for either of the terms should return both results since they collate to the same value
        assertAcked(client().admin().indices().prepareCreate(index).setMapping(builder));
            .startObject("id")
                .setId("1")
    * secondary and tertiary
            .field("type", "icu_collation_keyword")  
            .endObject()
            .source(
    */
        );
    * to quaternary level  
            .startObject("collate")
            .endObject()
            .endObject()
            .endObject()
 * You may obtain a copy of the License at  
    /*
        indexRandom(
        // searching for either of the terms should return both results since they collate to the same value
    * For german, you might want oe to sort and match with o umlaut.  
            .endObject()
        indexRandom(
        indexRandom(  
            .startObject("collate")
                    // if mode max we use c and b as sort values, if max we use "a" for both
    */
            .field("index", false)
                new SearchSourceBuilder().fetchSource(false)
        assertHitCount(response, 2L);
        assertAcked(client().admin().indices().prepareCreate(index).setMapping(builder));
                .setId("1")
                new SearchSourceBuilder().fetchSource(false)
        );
 * SPDX-License-Identifier: Apache-2.0
        assertNoFailures(response);
        request = new SearchRequest().indices(index)  
        );
                    .query(QueryBuilders.termQuery("collate", "a"))  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    }  
                    .sort("id", SortOrder.DESC) // will NOT be ignored and will determine order  
            .endObject()
        String index = "foo";
    /*
    */
            .endObject();
import com.ibm.icu.util.ULocale;
            .endObject()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;  
                    .query(QueryBuilders.termQuery("collate", randomBoolean() ? equivalent[0] : equivalent[1]))  
            .endObject()
        SearchResponse response = client().search(request).actionGet();
            .field("language", "en")  
            .endObject()
    */
        );  
            .endObject()  
 *  
            client().prepareIndex(index)  
import org.opensearch.plugin.analysis.icu.AnalysisICUPlugin;
    /*  
        );  
            .field("type", "keyword")
import org.opensearch.search.sort.SortBuilders;
            .endObject();
        String DIN5007_2_tailorings = "& ae , a\u0308 & AE , A\u0308" + "& oe , o\u0308 & OE , O\u0308" + "& ue , u\u0308 & UE , u\u0308";
            client().prepareIndex(index)  
            .field("language", "en")
        assertAcked(client().admin().indices().prepareCreate(index).setMapping(builder));  
    }  
        assertOrderedSearchHits(response, "2", "1");
        XContentBuilder builder = jsonBuilder().startObject()
                .setSource("{\"id\":\"1\", \"collate\":[\"" + equivalent[0] + "\", \"" + equivalent[1] + "\"]}", MediaTypeRegistry.JSON),
        SearchRequest request = new SearchRequest().indices(index)
import com.ibm.icu.text.RuleBasedCollator;
            .field("strength", "primary")  
 */
        String index = "foo";
        );  
        assertNoFailures(response);
                    .sort("collate", SortOrder.ASC)
        String[] equivalent = { "I W\u0049\u0307LL USE TURKİSH CASING", "ı will use turkish casıng" };  
            client().prepareIndex(index)
        SearchResponse response = client().search(request).actionGet();
    * Turkish has some funny casing.  
            .endObject()  
            .field("language", "en")
            .field("strength", "primary")  
        SearchResponse response = client().search(request).actionGet();
            .source(
            .field("language", "en")
        indexRandom(  
            .startObject("id")  
                                                                                                                      // should kick in on
            .startObject("id")  
            .field("type", "keyword")
        XContentBuilder builder = jsonBuilder().startObject()
 * GitHub history for details.
            .startObject("id")
    * This is not the default, but you can make a customized ruleset to do this.
                .setId("1")
        assertAcked(client().admin().indices().prepareCreate(index).setMapping(builder));
    *
                .setSource("{\"id\":\"1\",\"collate\":\"" + equivalent[0] + "\"}", MediaTypeRegistry.JSON),
import org.opensearch.plugins.Plugin;  
        return Collections.singletonList(AnalysisICUPlugin.class);
            client().prepareIndex(index)
            .field("index", false)
            .field("decomposition", "canonical")
            .field("type", "keyword")
        );
            .field("type", "keyword")
    * Test secondary strength, for english case is not significant.
     */
     * foobar-9 sorts before foobar-10  
 * software distributed under the License is distributed on an
    /*  
            client().prepareIndex(index).setId("1").setSource("{\"collate\":\"resume\"}", MediaTypeRegistry.JSON),
 * license agreements. See the NOTICE file distributed with
            client().prepareIndex(index)  
        assertNoFailures(response);  
    public void testCustomRules() throws Exception {  
                new SearchSourceBuilder().fetchSource(false).sort("collate", SortOrder.ASC).sort("id", SortOrder.ASC) // secondary sort  
            .endObject()  
        SearchResponse response = client().search(request).actionGet();
            .endObject();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                new SearchSourceBuilder().fetchSource(false)
            .endObject()  
            .field("language", "en")
            .field("rules", tailoredRules)  
            .source(
                                                                                                                      // collate value
                .setSource("{\"id\":\"2\",\"collate\":\"" + equivalent[1] + "\"}", MediaTypeRegistry.JSON)  
    public void testIgnorePunctuation() throws Exception {
    * Then things will sort and match correctly.  
            .endObject()  
import java.util.Collection;
                    .sort("collate")  
        SearchRequest request = new SearchRequest().indices(index)  
        assertNoFailures(response);  
        assertOrderedSearchHits(response, "2", "1");
        SearchResponse response = client().search(request).actionGet();
        assertNoFailures(response);
        assertNoFailures(response);
    }  
        assertOrderedSearchHits(response, "3", "1", "2");
            );
        assertHitCount(response, 2L);
                    // if mode max we use c and b as sort values, if max we use "a" for both
    @Override  
            .field("type", "keyword")
                    .sort("id", SortOrder.DESC) // will be ignored  
import java.util.Collections;
    * Setting alternate=shifted to shift whitespace, punctuation and symbols
        indexRandom(
        assertAcked(client().admin().indices().prepareCreate(index).setMapping(builder));  
    }
                .setId("2")
        );  
 * this file be licensed under the Apache-2.0 license or a
            client().prepareIndex(index).setId("4").setSource("{\"id\":\"4\",\"collate\":\"Résumé\"}", MediaTypeRegistry.JSON)
        SearchResponse response = client().search(request).actionGet();
            .field("type", "keyword")  
    * Setting alternate=shifted and variableTop to shift whitespace, but not  
                .setId("2")
            .startObject("id")  
                .setSource("{\"id\":\"2\",\"collate\":\"" + equivalent[1] + "\"}", MediaTypeRegistry.JSON)
            true,
                .setId("2")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertOrderedSearchHits;
            true,  
        response = client().search(request).actionGet();  
            true,  
                    .sort("id", SortOrder.DESC) // secondary sort should kick in because both will collate to same value
    */
            .field("index", false)
            client().prepareIndex(index)
            .field("language", "en")
 * Licensed to Elasticsearch under one or more contributor  
                    .sort("id", SortOrder.DESC) // secondary sort should kick in because both will collate to same value
        assertNoFailures(response);  
            true,  
                .setId("1")
            .startObject("collate")  
            client().prepareIndex(index).setId("2").setSource("{\"id\":\"2\",\"collate\":\"Resume\"}", MediaTypeRegistry.JSON),  
        RuleBasedCollator tailoredCollator = new RuleBasedCollator(baseCollator.getRules() + DIN5007_2_tailorings);  
            .startObject("collate")
            client().prepareIndex(index)
 */  
 * compatible open source license.
