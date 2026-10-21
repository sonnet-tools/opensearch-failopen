 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            prepareCreate("test").setMapping(
import static org.opensearch.index.query.functionscore.ScoreFunctionBuilders.fieldValueFactorFunction;
 *
        );
        response = client().prepareSearch("test")
                .get();
        client().prepareIndex("test").setId("2").setSource("test", -1, "body", "foo").get();
 */
        assertAcked(
            )
        assertOrderedSearchHits(response, "1", "2", "3");
            .setQuery(
        indexRandomForConcurrentSearch("test");
        super(staticSettings);
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
                    matchAllQuery(),
 * Unless required by applicable law or agreed to in writing,
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                functionScoreQuery(
                .setExplain(randomBoolean())
 * GitHub history for details.
 * software distributed under the License is distributed on an
import static org.opensearch.index.query.QueryBuilders.simpleQueryStringQuery;
 * ownership. Elasticsearch licenses this file to you under
            assertFailures(response);
                    functionScoreQuery(
                functionScoreQuery(
/*
            .get();
            .setExplain(true)
        // -1 divided by 0 is infinity, which should provoke an exception.
        // document 1 scores higher because 1/5 > 1/17
        SearchResponse response = client().prepareSearch("test")
        refresh();
        assertOrderedSearchHits(response, "2", "1");
        indexRandomForConcurrentSearch("test");
                .setQuery(
import static org.hamcrest.Matchers.containsString;
    public void testFieldValueFactorExplain() throws IOException, InterruptedException {
            // locally, instead of just having failures
            )
import java.util.Collection;
                    .endObject()
        // doc 3 doesn't have a "test" field, so an exception will be thrown
        client().prepareIndex("test").setId("2").setSource("test", 17, "body", "foo").get();
import java.util.Arrays;
                    fieldValueFactorFunction("test").modifier(FieldValueFactorFunction.Modifier.NONE)
                    fieldValueFactorFunction("notmapped").modifier(FieldValueFactorFunction.Modifier.RECIPROCAL).missing(100)
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
                .get();
            .get();
        // try again, but this time explicitly use the do-nothing modifier
/*
                    matchAllQuery(),
            .setQuery(
    public FunctionScoreFieldValueIT(Settings staticSettings) {
public class FunctionScoreFieldValueIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
            .setExplain(randomBoolean())
        }
            )
    }
                    .field("type", randomFrom(new String[] { "short", "float", "long", "integer", "double" }))
 * The OpenSearch Contributors require contributions made to
        assertAcked(
                functionScoreQuery(simpleQueryStringQuery("foo").queryName(queryName), fieldValueFactorFunction("test", functionName))
                jsonBuilder().startObject()
                functionScoreQuery(
        // "description": "sum of: (_name: query)"
 */
 *
            .get();
            // We are expecting an exception, because 3 has no field
    }
        final String queryName = "query";
 *
        } catch (SearchPhaseExecutionException e) {
            .setQuery(functionScoreQuery(simpleQueryStringQuery("foo"), fieldValueFactorFunction("test")))
    public static Collection<Object[]> parameters() {
/*
            prepareCreate("test").setMapping(
        );
        SearchResponse response = client().prepareSearch("test")
                    .endObject()
        client().prepareIndex("test").setId("1").setSource("test", 5, "body", "foo").get();
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
            response = client().prepareSearch("test")
 */
            .setQuery(
        response = client().prepareSearch("test")
                    .startObject("properties")
                    fieldValueFactorFunction("test").modifier(FieldValueFactorFunction.Modifier.RECIPROCAL).missing(100)
import static org.hamcrest.Matchers.arrayWithSize;
}
                    .field("type", randomFrom(new String[] { "short", "float", "long", "integer", "double" }))
                .setQuery(functionScoreQuery(matchAllQuery(), fieldValueFactorFunction("test")))
 * under the License.
 * KIND, either express or implied.  See the License for the
        // doc 3 doesn't have a "test" field but we're defaulting it to 100 so it should be last
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
                    .endObject()
        assertEquals(response.getHits().getAt(0).getScore(), response.getHits().getAt(2).getScore(), 0);
                    )
        assertOrderedSearchHits(response, "2", "1");
                    .field("type", "text")
            .get();
                    .endObject()
import org.opensearch.action.search.SearchResponse;
        // field is not mapped but we're defaulting it to 100 so all documents should have the same score
        // "description": "field value function(_name: func1): none(doc['test'].value * factor=1.0)"
    public void testFieldValueFactor() throws IOException, InterruptedException {
 * Modifications Copyright OpenSearch Contributors. See
        );
                .setExplain(randomBoolean())
                    .startObject("body")
                )
    }
    @ParametersFactory
        response = client().prepareSearch("test")
package org.opensearch.search.functionscore;
        client().prepareIndex("test").setId("1").setSource("test", 5, "body", "foo").get();
            .setExplain(randomBoolean())
import org.opensearch.common.settings.Settings;
            // This is fine, the query will throw an exception if executed
        assertThat(firstHit.getExplanation().getDetails()[1].toString(), containsString("_name: " + functionName));
        } catch (SearchPhaseExecutionException e) {
                    .endObject()
 * Tests for the {@code field_value_factor} function in a function_score query.
        return Arrays.asList(
            ).get()
        // document 2 scores higher because 17 > 5
                        simpleQueryStringQuery("foo"),
                )
 * specific language governing permissions and limitations
        try {
 * this file be licensed under the Apache-2.0 license or a
        try {
import org.opensearch.action.search.SearchPhaseExecutionException;
                    simpleQueryStringQuery("foo"),
        client().prepareIndex("test").setId("3").setSource("body", "bar").get();
    }
 * this work for additional information regarding copyright
        SearchHit firstHit = response.getHits().getAt(0);
 */
            .setQuery(
        assertOrderedSearchHits(response, "2", "1");
        client().prepareIndex("test").setId("3").setSource("body", "bar").get();
import static org.opensearch.index.query.QueryBuilders.functionScoreQuery;
                    .startObject("test")
                jsonBuilder().startObject()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertOrderedSearchHits;
        client().prepareIndex("test").setId("2").setSource("test", 17, "body", "foo").get();
        assertThat(firstHit.getExplanation().getDetails()[0].getDescription(), containsString("_name: " + queryName));
                functionScoreQuery(
                )
        assertOrderedSearchHits(response, "1", "2");
                )
            .setQuery(
import org.opensearch.search.SearchHit;
import java.io.IOException;
        final String functionName = "func1";
        // document 2 scores higher because 17 > 5
/**
            )
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFailures;
            response = client().prepareSearch("test")
 * not use this file except in compliance with the License.
                        fieldValueFactorFunction("test").modifier(FieldValueFactorFunction.Modifier.RECIPROCAL).factor(0)
                )
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
                    .field("type", "text")
                    .startObject("body")
 * Licensed to Elasticsearch under one or more contributor
                    .endObject()
            .get();
            .setExplain(randomBoolean())
            .get();
            .setExplain(randomBoolean())
                    .startObject("test")
        response = client().prepareSearch("test")
 * compatible open source license.
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
 * You may obtain a copy of the License at
                    .startObject("properties")
        assertThat(firstHit.getExplanation().getDetails(), arrayWithSize(2));
import org.opensearch.common.lucene.search.function.FieldValueFactorFunction;
        refresh();
        refresh();
                    simpleQueryStringQuery("foo"),
                    .endObject()
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
                    fieldValueFactorFunction("test").modifier(FieldValueFactorFunction.Modifier.RECIPROCAL)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            ).get()
                    .endObject()
            .setExplain(randomBoolean())
            )
 * the Apache License, Version 2.0 (the "License"); you may
            assertFailures(response);
