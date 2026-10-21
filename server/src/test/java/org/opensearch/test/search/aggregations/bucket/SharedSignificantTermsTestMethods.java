            .addAggregation(terms("class").field(CLASS_FIELD).subAggregation(significantTerms("sig_terms").field(TEXT_FIELD)))
 */
    public static final String INDEX_NAME = "testidx";
            testCase.prepareCreate(INDEX_NAME)
 * Unless required by applicable law or agreed to in writing,
        Assert.assertThat(classes.getBuckets().size(), equalTo(2));
            .actionGet();
            Map<String, Aggregation> aggs = classBucket.getAggregations().asMap();
public class SharedSignificantTermsTestMethods {
import org.opensearch.test.OpenSearchIntegTestCase;
    }
        indexRequestBuilderList.add(client().prepareIndex(INDEX_NAME).setId("1").setSource(TEXT_FIELD, "1", CLASS_FIELD, "1"));
        );
        List<IndexRequestBuilder> indexRequestBuilderList = new ArrayList<>();
 * the Apache License, Version 2.0 (the "License"); you may
            Assert.assertTrue(aggs.containsKey("sig_terms"));
    public static final String TEXT_FIELD = "text";
        );
import static org.opensearch.test.OpenSearchIntegTestCase.client;
import java.util.List;
 * this work for additional information regarding copyright
        }
 * specific language governing permissions and limitations
 * under the License.
        SearchResponse response = client().prepareSearch(INDEX_NAME)
 * license agreements. See the NOTICE file distributed with
            client().prepareIndex(INDEX_NAME).setId("5").setSource(TEXT_FIELD, gb, CLASS_FIELD, "1").setRouting("1")
            testCase.prepareCreate(INDEX_NAME)
 */
                .setSettings(settings, MediaTypeRegistry.JSON)
                .setMapping("text", textMappings, CLASS_FIELD, "type=keyword")
 *
        InterruptedException {
        assertAcked(
import java.util.concurrent.ExecutionException;
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
        String[] gb = { "0", "1" };
        );
        String[] gb = { "0", "1" };
        String textMappings = "type=" + type;
        indexRequestBuilderList.add(
        testCase.indexRandom(true, false, indexRequestBuilderList);
    public static void index01DocsWithRouting(String type, String settings, OpenSearchIntegTestCase testCase) throws ExecutionException,
        indexRequestBuilderList.add(
    public static final String DOC_TYPE = "_doc";
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.aggregations.Aggregation;
import java.util.ArrayList;
import org.opensearch.action.index.IndexRequestBuilder;
            textMappings += ",fielddata=true";
        );
 * GitHub history for details.
        indexRequestBuilderList.add(client().prepareIndex(INDEX_NAME).setId("2").setSource(TEXT_FIELD, "1", CLASS_FIELD, "1"));
 * The OpenSearch Contributors require contributions made to
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
        assertSearchResponse(response);
        indexRequestBuilderList.add(client().prepareIndex(INDEX_NAME).setId("3").setSource(TEXT_FIELD, "0", CLASS_FIELD, "0"));
        testCase.ensureGreen();
            client().prepareIndex(INDEX_NAME).setId("7").setSource(TEXT_FIELD, "0", CLASS_FIELD, "0").setRouting("0")
 *
        );
 * SPDX-License-Identifier: Apache-2.0
/*
        if (type.equals("text")) {
import org.opensearch.search.aggregations.bucket.terms.SignificantTerms;
        testCase.indexRandom(true, false, indexRequestBuilderList);
        }
        indexRequestBuilderList.add(
        testCase.logClusterState();
 * software distributed under the License is distributed on an
        indexRequestBuilderList.add(client().prepareIndex(INDEX_NAME).setId("7").setSource(TEXT_FIELD, "0", CLASS_FIELD, "0"));
        indexRequestBuilderList.add(client().prepareIndex(INDEX_NAME).setId("5").setSource(TEXT_FIELD, gb, CLASS_FIELD, "1"));
import static org.opensearch.search.aggregations.AggregationBuilders.significantTerms;
 * not use this file except in compliance with the License.
        }
    public static final String CLASS_FIELD = "class";
        );
        indexRequestBuilderList.add(
        );
        for (Terms.Bucket classBucket : classes.getBuckets()) {
import org.opensearch.action.search.SearchResponse;
        checkSignificantTermsAggregationCorrect(testCase);
import org.opensearch.core.xcontent.MediaTypeRegistry;
            client().prepareIndex(INDEX_NAME).setId("3").setSource(TEXT_FIELD, "0", CLASS_FIELD, "0").setRouting("0")
            SignificantTerms agg = (SignificantTerms) aggs.get("sig_terms");
/*
    }
            Assert.assertThat(agg.getBuckets().size(), equalTo(1));
/*
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under
        indexRequestBuilderList.add(client().prepareIndex(INDEX_NAME).setId("6").setSource(TEXT_FIELD, gb, CLASS_FIELD, "0"));
            Assert.assertTrue(term.equals(classTerm));
                .setMapping("text", textMappings, CLASS_FIELD, "type=keyword")
        List<IndexRequestBuilder> indexRequestBuilderList = new ArrayList<>();
    }
package org.opensearch.test.search.aggregations.bucket;
        indexRequestBuilderList.add(
        );
    private static void checkSignificantTermsAggregationCorrect(OpenSearchIntegTestCase testCase) {
                .setSettings(settings, MediaTypeRegistry.JSON)
        if (type.equals("text")) {
        indexRequestBuilderList.add(client().prepareIndex(INDEX_NAME).setId("4").setSource(TEXT_FIELD, "0", CLASS_FIELD, "0"));
        String textMappings = "type=" + type;
 * KIND, either express or implied.  See the License for the
import java.util.Map;
        indexRequestBuilderList.add(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        InterruptedException {
        indexRequestBuilderList.add(
 *
            client().prepareIndex(INDEX_NAME).setId("4").setSource(TEXT_FIELD, "0", CLASS_FIELD, "0").setRouting("1")
            textMappings += ",fielddata=true";
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
            SignificantTerms.Bucket sigBucket = agg.iterator().next();
 * Modifications Copyright OpenSearch Contributors. See
    public static void aggregateAndCheckFromSeveralShards(OpenSearchIntegTestCase testCase) throws ExecutionException,
import org.opensearch.search.aggregations.bucket.terms.StringTerms;
import org.opensearch.test.OpenSearchTestCase;
            client().prepareIndex(INDEX_NAME).setId("2").setSource(TEXT_FIELD, "1", CLASS_FIELD, "1").setRouting("0")
            .execute()
import org.opensearch.search.aggregations.bucket.terms.Terms;
        InterruptedException {
            client().prepareIndex(INDEX_NAME).setId("6").setSource(TEXT_FIELD, gb, CLASS_FIELD, "0").setRouting("0")
            String term = sigBucket.getKeyAsString();
        assertAcked(
 * You may obtain a copy of the License at
import static org.hamcrest.Matchers.equalTo;
}
        String type = OpenSearchTestCase.randomBoolean() ? "text" : "keyword";
        index01Docs(type, settings, testCase);
    public static void index01Docs(String type, String settings, OpenSearchIntegTestCase testCase) throws ExecutionException,
        String settings = "{\"index.number_of_shards\": 7, \"index.number_of_routing_shards\": 7, \"index.number_of_replicas\": 0}";
            client().prepareIndex(INDEX_NAME).setId("1").setSource(TEXT_FIELD, "1", CLASS_FIELD, "1").setRouting("0")
        StringTerms classes = response.getAggregations().get("class");
            String classTerm = classBucket.getKeyAsString();
 * Licensed to Elasticsearch under one or more contributor
import org.junit.Assert;
        );
