            )
 * Modifications Copyright OpenSearch Contributors. See
                    fieldValueFactorFunction("test").modifier(FieldValueFactorFunction.Modifier.NONE)  
                .setQuery(  
                    .field("type", randomFrom(new String[] { "short", "float", "long", "integer", "double" }))
                .get();  
            )
import java.util.Collection;  
                    .startObject("body")  
                    .startObject("body")
 * KIND, either express or implied.  See the License for the
            ).get()
            // This is fine, the query will throw an exception if executed  
public class FunctionScoreFieldValueIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
                    .startObject("test")
            response = client().prepareSearch("test")
        assertOrderedSearchHits(response, "2", "1");
import org.opensearch.common.lucene.search.function.FieldValueFactorFunction;
                    .endObject()
 *
            // We are expecting an exception, because 3 has no field
                    .startObject("properties")  
        // document 1 scores higher because 1/5 > 1/17  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertOrderedSearchHits;
        client().prepareIndex("test").setId("2").setSource("test", 17, "body", "foo").get();
                    matchAllQuery(),
            .get();  
 * Licensed to Elasticsearch under one or more contributor  
 *    http://www.apache.org/licenses/LICENSE-2.0
            .setExplain(true)
        assertOrderedSearchHits(response, "2", "1");
import static org.opensearch.index.query.functionscore.ScoreFunctionBuilders.fieldValueFactorFunction;  
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import org.opensearch.action.search.SearchPhaseExecutionException;  
 * specific language governing permissions and limitations
}  
 * this file be licensed under the Apache-2.0 license or a
                    .endObject()
            )
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                    matchAllQuery(),
 * the Apache License, Version 2.0 (the "License"); you may
        refresh();
        );
                functionScoreQuery(  
        response = client().prepareSearch("test")  
                )  
                        fieldValueFactorFunction("test").modifier(FieldValueFactorFunction.Modifier.RECIPROCAL).factor(0)  
 * compatible open source license.
            .setQuery(  
 * You may obtain a copy of the License at  
        response = client().prepareSearch("test")  
        SearchHit firstHit = response.getHits().getAt(0);
        assertEquals(response.getHits().getAt(0).getScore(), response.getHits().getAt(2).getScore(), 0);  
        // field is not mapped but we're defaulting it to 100 so all documents should have the same score
            .setExplain(randomBoolean())
        client().prepareIndex("test").setId("2").setSource("test", -1, "body", "foo").get();
 * GitHub history for details.
import java.util.Arrays;
import org.opensearch.common.settings.Settings;  
        final String queryName = "query";  
        assertThat(firstHit.getExplanation().getDetails(), arrayWithSize(2));  
                    fieldValueFactorFunction("test").modifier(FieldValueFactorFunction.Modifier.RECIPROCAL)  
            )
                    .endObject()
        }
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
    }
                jsonBuilder().startObject()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            // locally, instead of just having failures
        assertAcked(  
                functionScoreQuery(  
                    .endObject()
 * Tests for the {@code field_value_factor} function in a function_score query.  
 * The OpenSearch Contributors require contributions made to  
            .get();  
        SearchResponse response = client().prepareSearch("test")  
        client().prepareIndex("test").setId("3").setSource("body", "bar").get();
        // try again, but this time explicitly use the do-nothing modifier  
        return Arrays.asList(
            assertFailures(response);
        );
        assertOrderedSearchHits(response, "1", "2", "3");  
            .setExplain(randomBoolean())
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
import java.io.IOException;
 * SPDX-License-Identifier: Apache-2.0
 */  
import static org.hamcrest.Matchers.containsString;  
        );  
        } catch (SearchPhaseExecutionException e) {
    public void testFieldValueFactor() throws IOException, InterruptedException {
        response = client().prepareSearch("test")
                    .field("type", "text")
            )
            .get();
 * license agreements. See the NOTICE file distributed with
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
            .setQuery(
            prepareCreate("test").setMapping(
            .setQuery(  
        try {
import org.opensearch.action.search.SearchResponse;
        client().prepareIndex("test").setId("1").setSource("test", 5, "body", "foo").get();
    }
            ).get()  
    @ParametersFactory
        assertThat(firstHit.getExplanation().getDetails()[1].toString(), containsString("_name: " + functionName));
        }  
    }  
        final String functionName = "func1";
                    .startObject("test")  
        indexRandomForConcurrentSearch("test");
                    .endObject()  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
                )
        response = client().prepareSearch("test")
        // -1 divided by 0 is infinity, which should provoke an exception.
            .setQuery(functionScoreQuery(simpleQueryStringQuery("foo"), fieldValueFactorFunction("test")))
                    .field("type", randomFrom(new String[] { "short", "float", "long", "integer", "double" }))
                    .field("type", "text")
        super(staticSettings);
                    simpleQueryStringQuery("foo"),
 * this work for additional information regarding copyright
                functionScoreQuery(simpleQueryStringQuery("foo").queryName(queryName), fieldValueFactorFunction("test", functionName))
                )
        client().prepareIndex("test").setId("2").setSource("test", 17, "body", "foo").get();  
import static org.hamcrest.Matchers.arrayWithSize;
    public void testFieldValueFactorExplain() throws IOException, InterruptedException {
 *
            response = client().prepareSearch("test")
/*  
 */  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }  
                functionScoreQuery(
        assertAcked(
        assertOrderedSearchHits(response, "1", "2");
                    .startObject("properties")
                    fieldValueFactorFunction("notmapped").modifier(FieldValueFactorFunction.Modifier.RECIPROCAL).missing(100)
    }  
            .get();  
        assertOrderedSearchHits(response, "2", "1");
/**
                    .endObject()
                jsonBuilder().startObject()
package org.opensearch.search.functionscore;
        client().prepareIndex("test").setId("3").setSource("body", "bar").get();
                .setQuery(functionScoreQuery(matchAllQuery(), fieldValueFactorFunction("test")))
            .setExplain(randomBoolean())
        refresh();
                    )
        indexRandomForConcurrentSearch("test");  
 *  
            .setExplain(randomBoolean())
                    .endObject()  
import org.opensearch.search.SearchHit;
                    fieldValueFactorFunction("test").modifier(FieldValueFactorFunction.Modifier.RECIPROCAL).missing(100)
                    functionScoreQuery(
    public FunctionScoreFieldValueIT(Settings staticSettings) {
        // document 2 scores higher because 17 > 5
            .get();  
                    .endObject()  
            .get();
                .get();
        // "description": "sum of: (_name: query)"
                    simpleQueryStringQuery("foo"),
            .setExplain(randomBoolean())
/*
 * software distributed under the License is distributed on an
        // document 2 scores higher because 17 > 5
        } catch (SearchPhaseExecutionException e) {
                .setExplain(randomBoolean())
 * not use this file except in compliance with the License.
        refresh();  
                        simpleQueryStringQuery("foo"),
        assertThat(firstHit.getExplanation().getDetails()[0].getDescription(), containsString("_name: " + queryName));
 * ownership. Elasticsearch licenses this file to you under  
import static org.opensearch.index.query.QueryBuilders.functionScoreQuery;  
/*  
            .setQuery(  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFailures;  
 */
                functionScoreQuery(
            .setQuery(
            prepareCreate("test").setMapping(  
        // doc 3 doesn't have a "test" field but we're defaulting it to 100 so it should be last
        // doc 3 doesn't have a "test" field, so an exception will be thrown  
    public static Collection<Object[]> parameters() {  
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
            assertFailures(response);  
                .setExplain(randomBoolean())  
                )  
        try {  
        client().prepareIndex("test").setId("1").setSource("test", 5, "body", "foo").get();  
 */
import static org.opensearch.index.query.QueryBuilders.simpleQueryStringQuery;
        // "description": "field value function(_name: func1): none(doc['test'].value * factor=1.0)"  
        SearchResponse response = client().prepareSearch("test")
                )
