 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
        }  
 * this work for additional information regarding copyright
 *
/*
        );
                .setMapping("text", textMappings, CLASS_FIELD, "type=keyword")  
        );
    public static void index01Docs(String type, String settings, OpenSearchIntegTestCase testCase) throws ExecutionException,  
        }
        indexRequestBuilderList.add(  
 *     http://www.apache.org/licenses/LICENSE-2.0
import static org.hamcrest.Matchers.equalTo;
        SearchResponse response = client().prepareSearch(INDEX_NAME)
        }
            client().prepareIndex(INDEX_NAME).setId("5").setSource(TEXT_FIELD, gb, CLASS_FIELD, "1").setRouting("1")
            client().prepareIndex(INDEX_NAME).setId("4").setSource(TEXT_FIELD, "0", CLASS_FIELD, "0").setRouting("1")
            String term = sigBucket.getKeyAsString();  
import org.junit.Assert;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
 * You may obtain a copy of the License at  
import org.opensearch.search.aggregations.Aggregation;
            SignificantTerms.Bucket sigBucket = agg.iterator().next();
            .execute()
import java.util.List;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
            SignificantTerms agg = (SignificantTerms) aggs.get("sig_terms");  
import org.opensearch.test.OpenSearchTestCase;  
    }
import java.util.concurrent.ExecutionException;  
            .actionGet();
        if (type.equals("text")) {
        testCase.indexRandom(true, false, indexRequestBuilderList);  
        assertSearchResponse(response);  
    public static void aggregateAndCheckFromSeveralShards(OpenSearchIntegTestCase testCase) throws ExecutionException,  
        for (Terms.Bucket classBucket : classes.getBuckets()) {  
 *  
import static org.opensearch.search.aggregations.AggregationBuilders.terms;  
import org.opensearch.search.aggregations.bucket.terms.SignificantTerms;
        );
        indexRequestBuilderList.add(client().prepareIndex(INDEX_NAME).setId("1").setSource(TEXT_FIELD, "1", CLASS_FIELD, "1"));
        testCase.ensureGreen();
        String textMappings = "type=" + type;
    }
        String textMappings = "type=" + type;
}
        indexRequestBuilderList.add(  
    }  
 * Modifications Copyright OpenSearch Contributors. See
/*  
    public static final String CLASS_FIELD = "class";
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
 */  
        if (type.equals("text")) {  
        String[] gb = { "0", "1" };
            .addAggregation(terms("class").field(CLASS_FIELD).subAggregation(significantTerms("sig_terms").field(TEXT_FIELD)))  
        InterruptedException {
            String classTerm = classBucket.getKeyAsString();
            Assert.assertThat(agg.getBuckets().size(), equalTo(1));
 * specific language governing permissions and limitations
        assertAcked(
            client().prepareIndex(INDEX_NAME).setId("3").setSource(TEXT_FIELD, "0", CLASS_FIELD, "0").setRouting("0")
            client().prepareIndex(INDEX_NAME).setId("2").setSource(TEXT_FIELD, "1", CLASS_FIELD, "1").setRouting("0")
        );
 * the Apache License, Version 2.0 (the "License"); you may
    public static final String INDEX_NAME = "testidx";
        checkSignificantTermsAggregationCorrect(testCase);
/*  
 * ownership. Elasticsearch licenses this file to you under  
        testCase.logClusterState();  
import org.opensearch.search.aggregations.bucket.terms.Terms;
            client().prepareIndex(INDEX_NAME).setId("1").setSource(TEXT_FIELD, "1", CLASS_FIELD, "1").setRouting("0")
            testCase.prepareCreate(INDEX_NAME)  
package org.opensearch.test.search.aggregations.bucket;
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.search.aggregations.bucket.terms.StringTerms;  
        testCase.indexRandom(true, false, indexRequestBuilderList);
            textMappings += ",fielddata=true";
            Assert.assertTrue(term.equals(classTerm));
        List<IndexRequestBuilder> indexRequestBuilderList = new ArrayList<>();  
                .setMapping("text", textMappings, CLASS_FIELD, "type=keyword")
        InterruptedException {
 */  
            client().prepareIndex(INDEX_NAME).setId("7").setSource(TEXT_FIELD, "0", CLASS_FIELD, "0").setRouting("0")
        indexRequestBuilderList.add(  
        String[] gb = { "0", "1" };
    public static final String DOC_TYPE = "_doc";
        assertAcked(  
            textMappings += ",fielddata=true";  
        );
 *
        );
 * not use this file except in compliance with the License.
            Assert.assertTrue(aggs.containsKey("sig_terms"));
        Assert.assertThat(classes.getBuckets().size(), equalTo(2));
        indexRequestBuilderList.add(client().prepareIndex(INDEX_NAME).setId("4").setSource(TEXT_FIELD, "0", CLASS_FIELD, "0"));
        );  
        indexRequestBuilderList.add(client().prepareIndex(INDEX_NAME).setId("5").setSource(TEXT_FIELD, gb, CLASS_FIELD, "1"));
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            testCase.prepareCreate(INDEX_NAME)
    }
            client().prepareIndex(INDEX_NAME).setId("6").setSource(TEXT_FIELD, gb, CLASS_FIELD, "0").setRouting("0")
public class SharedSignificantTermsTestMethods {  
                .setSettings(settings, MediaTypeRegistry.JSON)
import java.util.ArrayList;  
import static org.opensearch.test.OpenSearchIntegTestCase.client;
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
import org.opensearch.action.index.IndexRequestBuilder;
        );
 * SPDX-License-Identifier: Apache-2.0
                .setSettings(settings, MediaTypeRegistry.JSON)
    private static void checkSignificantTermsAggregationCorrect(OpenSearchIntegTestCase testCase) {
        indexRequestBuilderList.add(  
 * Unless required by applicable law or agreed to in writing,
    public static void index01DocsWithRouting(String type, String settings, OpenSearchIntegTestCase testCase) throws ExecutionException,
            Map<String, Aggregation> aggs = classBucket.getAggregations().asMap();
        index01Docs(type, settings, testCase);
        InterruptedException {  
 * under the License.  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;  
        indexRequestBuilderList.add(client().prepareIndex(INDEX_NAME).setId("7").setSource(TEXT_FIELD, "0", CLASS_FIELD, "0"));
        indexRequestBuilderList.add(  
        indexRequestBuilderList.add(client().prepareIndex(INDEX_NAME).setId("6").setSource(TEXT_FIELD, gb, CLASS_FIELD, "0"));  
import static org.opensearch.search.aggregations.AggregationBuilders.significantTerms;
        indexRequestBuilderList.add(  
        String type = OpenSearchTestCase.randomBoolean() ? "text" : "keyword";
        indexRequestBuilderList.add(client().prepareIndex(INDEX_NAME).setId("3").setSource(TEXT_FIELD, "0", CLASS_FIELD, "0"));  
    public static final String TEXT_FIELD = "text";  
        List<IndexRequestBuilder> indexRequestBuilderList = new ArrayList<>();
        String settings = "{\"index.number_of_shards\": 7, \"index.number_of_routing_shards\": 7, \"index.number_of_replicas\": 0}";  
        );
        StringTerms classes = response.getAggregations().get("class");
import java.util.Map;
import org.opensearch.action.search.SearchResponse;
        indexRequestBuilderList.add(client().prepareIndex(INDEX_NAME).setId("2").setSource(TEXT_FIELD, "1", CLASS_FIELD, "1"));
        indexRequestBuilderList.add(  
 */
