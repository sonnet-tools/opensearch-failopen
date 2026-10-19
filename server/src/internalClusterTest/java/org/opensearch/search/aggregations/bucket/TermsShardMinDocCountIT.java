        assertThat(sigterms.getBuckets().size(), equalTo(2));  
        String termtype = termTypes[randomInt(termTypes.length - 1)];  
                    .shardSize(2)
        }
        // first, check that indeed when not setting the shardMinDocCount parameter 0 terms are returned
import java.util.ArrayList;
    }
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
                    .executionHint(randomExecutionHint())
        for (int i = 0; i < numDocs; i++) {
                    .size(2)  
/*
        terms = response.getAggregations().get("myTerms");
    public void testShardMinDocCountTermsTest() throws Exception {  
import org.opensearch.action.index.IndexRequestBuilder;
        response = client().prepareSearch(index)  
        SearchResponse response = client().prepareSearch(index)
package org.opensearch.search.aggregations.bucket;
        sigterms = filteredBucket.getAggregations().get("mySignificantTerms");
        List<IndexRequestBuilder> indexBuilders = new ArrayList<>();  
 * license agreements. See the NOTICE file distributed with
        if (randomBoolean()) {
import static org.opensearch.search.aggregations.AggregationBuilders.significantTerms;
            textMappings = "type=long";  
 */  
        for (int i = 0; i < numInClass; i++) {  
                )  
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.common.settings.Settings;
 * Licensed to Elasticsearch under one or more contributor  
            prepareCreate(index).setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0))  
    }
            "For concurrent segment search shard_min_doc_count is not enforced at the slice level. See https://github.com/opensearch-project/OpenSearch/issues/11847",
        List<IndexRequestBuilder> indexBuilders = new ArrayList<>();
            .addAggregation(  
 * specific language governing permissions and limitations
                    .order(BucketOrder.key(true))  
            builders.add(client().prepareIndex(index).setSource(sourceNotClass, MediaTypeRegistry.JSON));
        assertThat(terms.getBuckets().size(), equalTo(2));
 * ownership. Elasticsearch licenses this file to you under  
    public TermsShardMinDocCountIT(Settings staticSettings) {  
        if (termtype.equals("text")) {
            .get();  
                        .shardMinDocCount(2)  
        SearchResponse response = client().prepareSearch(index)
        assertSearchResponse(response);  
 * You may obtain a copy of the License at  
        addTermsDocs("6", 3, indexBuilders);
        assumeFalse(
        addTermsDocs("5", 3, indexBuilders);// low score but high doc freq  
        addTermsDocs("4", 1, 0, indexBuilders);
 * this work for additional information regarding copyright
    private static void addTermsDocs(String term, int numDocs, List<IndexRequestBuilder> builders) {  
                terms("myTerms").field("text")  
                        .executionHint(randomExecutionHint())
        return randomBoolean() ? null : randomFrom(SignificantTermsAggregatorFactory.ExecutionMode.values()).toString();
        }
        indexRandom(true, false, indexBuilders);
            prepareCreate(index).setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0))
        String termMappings = "type=" + termtype;
public class TermsShardMinDocCountIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        addTermsDocs("3", 1, 0, indexBuilders);  
                    .size(2)  
        addTermsDocs("3", 1, indexBuilders);
        );
import org.opensearch.search.aggregations.bucket.filter.InternalFilter;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    private static String randomExecutionHint() {  
            internalCluster().clusterService().getClusterSettings().get(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING)  
}  
 *    http://www.apache.org/licenses/LICENSE-2.0
        super(staticSettings);
        addTermsDocs("2", 1, 0, indexBuilders);
        // first, check that indeed when not setting the shardMinDocCount parameter 0 terms are returned
            .addAggregation(  
    private static final String index = "someindex";
        String sourceClass = "{\"text\": \"" + term + "\"}";
 *
            )
import org.opensearch.action.search.SearchResponse;  
 * compatible open source license.
        } else {
        response = client().prepareSearch(index)
import static org.opensearch.search.aggregations.AggregationBuilders.filter;
            builders.add(client().prepareIndex(index).setSource(sourceClass, MediaTypeRegistry.JSON));  
import java.util.Collection;
        InternalFilter filteredBucket = response.getAggregations().get("inclass");
            textMappings = "type=text,fielddata=true";
        final String[] termTypes = { "text", "long", "integer", "float", "double" };
        addTermsDocs("1", 1, 0, indexBuilders);// high score but low doc freq
        );  
    public static Collection<Object[]> parameters() {
                    .minDocCount(2)
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
        assertAcked(
    public void testShardMinDocCountSignificantTermsTest() throws Exception {
 */
            .get();
        String sourceNotClass = "{\"text\": \"" + term + "\", \"class\":" + "false" + "}";
        addTermsDocs("6", 3, 1, indexBuilders);  
        assertThat(terms.getBuckets().size(), equalTo(0));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
import java.util.Arrays;  
 * the Apache License, Version 2.0 (the "License"); you may
            internalCluster().clusterService().getClusterSettings().get(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING)
        }
        for (int i = 0; i < numNotInClass; i++) {  
        assertSearchResponse(response);  
    private void addTermsDocs(String term, int numInClass, int numNotInClass, List<IndexRequestBuilder> builders) {  
        assertThat(sigterms.getBuckets().size(), equalTo(0));
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;  
            .addAggregation(
        );
 * not use this file except in compliance with the License.
import static org.opensearch.search.aggregations.AggregationBuilders.terms;  
                .setMapping("text", textMappings)  
 * The OpenSearch Contributors require contributions made to  
                    .shardMinDocCount(2)
                    .executionHint(randomExecutionHint())
        }
import org.opensearch.search.aggregations.bucket.terms.Terms;
            .addAggregation(
import java.util.List;
    }
    }
import org.opensearch.search.aggregations.bucket.terms.SignificantTerms;  
 * software distributed under the License is distributed on an
            builders.add(client().prepareIndex(index).setSource(sourceClass, MediaTypeRegistry.JSON));
                        .minDocCount(2)  
            )
                        .shardSize(2)
    }
import org.opensearch.index.query.QueryBuilders;  
            .get();
    // see https://github.com/elastic/elasticsearch/issues/5998
    }  
 */
                terms("myTerms").field("text")
                (filter("inclass", QueryBuilders.termQuery("class", true))).subAggregation(
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
                        .executionHint(randomExecutionHint())  
                    significantTerms("mySignificantTerms").field("text")
        filteredBucket = response.getAggregations().get("inclass");
                    .shardSize(2)
import org.opensearch.search.aggregations.BucketOrder;
 * under the License.  
            "For concurrent segment search shard_min_doc_count is not enforced at the slice level. See https://github.com/opensearch-project/OpenSearch/issues/11847",
                        .size(2)
        Terms terms = response.getAggregations().get("myTerms");
            )
 * GitHub history for details.
        );
                        .size(2)
    @ParametersFactory
 *  
        return Arrays.asList(  
 *
                    significantTerms("mySignificantTerms").field("text")  
            .get();
                    .order(BucketOrder.key(true))  
        addTermsDocs("5", 3, 1, indexBuilders);// low score but high doc freq
 * this file be licensed under the Apache-2.0 license or a
                (filter("inclass", QueryBuilders.termQuery("class", true))).subAggregation(
        assertAcked(
        );  
        String textMappings;
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
                    .minDocCount(2)
        assertSearchResponse(response);
                )
            termMappings += ",fielddata=true";  
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
        String sourceClass = "{\"text\": \"" + term + "\", \"class\":" + "true" + "}";
        }  
    // see https://github.com/elastic/elasticsearch/issues/5998
                        .shardSize(2)
                        .minDocCount(2)
/*  
        addTermsDocs("1", 1, indexBuilders);// low doc freq but high score
        assumeFalse(  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;  
        addTermsDocs("2", 1, indexBuilders);  
                .setMapping("text", termMappings)
        assertSearchResponse(response);  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        indexRandom(true, false, indexBuilders);
    }
        addTermsDocs("7", 0, 3, indexBuilders);// make sure the terms all get score > 0 except for this one
        SignificantTerms sigterms = filteredBucket.getAggregations().get("mySignificantTerms");  
import org.opensearch.search.aggregations.bucket.terms.SignificantTermsAggregatorFactory;
import static org.hamcrest.Matchers.equalTo;  
            )
        addTermsDocs("4", 1, indexBuilders);
import org.opensearch.core.xcontent.MediaTypeRegistry;
