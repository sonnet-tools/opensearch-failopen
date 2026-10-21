        assertThat(terms.getBuckets().size(), equalTo(2));
import org.opensearch.core.xcontent.MediaTypeRegistry;
 * under the License.
        String textMappings;
            .addAggregation(
        sigterms = filteredBucket.getAggregations().get("mySignificantTerms");
        assertAcked(
 */
        );
public class TermsShardMinDocCountIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        }
                    significantTerms("mySignificantTerms").field("text")
            builders.add(client().prepareIndex(index).setSource(sourceClass, MediaTypeRegistry.JSON));
 * SPDX-License-Identifier: Apache-2.0
        String sourceNotClass = "{\"text\": \"" + term + "\", \"class\":" + "false" + "}";
        assumeFalse(
    }
    }
        assertThat(sigterms.getBuckets().size(), equalTo(2));
        }
                        .size(2)
        addTermsDocs("3", 1, 0, indexBuilders);
            "For concurrent segment search shard_min_doc_count is not enforced at the slice level. See https://github.com/opensearch-project/OpenSearch/issues/11847",
                        .executionHint(randomExecutionHint())
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                )
        InternalFilter filteredBucket = response.getAggregations().get("inclass");
import static org.opensearch.search.aggregations.AggregationBuilders.filter;
 * You may obtain a copy of the License at
 *
 */
/*
import java.util.List;
                        .minDocCount(2)
                        .size(2)
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
        );
        String termMappings = "type=" + termtype;
        SearchResponse response = client().prepareSearch(index)
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
        // first, check that indeed when not setting the shardMinDocCount parameter 0 terms are returned
    // see https://github.com/elastic/elasticsearch/issues/5998
                    .order(BucketOrder.key(true))
import static org.opensearch.search.aggregations.AggregationBuilders.significantTerms;
        return Arrays.asList(
    }
    public TermsShardMinDocCountIT(Settings staticSettings) {
import org.opensearch.index.query.QueryBuilders;
        for (int i = 0; i < numDocs; i++) {
import org.opensearch.search.aggregations.bucket.terms.SignificantTermsAggregatorFactory;
    private static final String index = "someindex";
            )
import org.opensearch.search.aggregations.bucket.terms.SignificantTerms;
        for (int i = 0; i < numNotInClass; i++) {
                (filter("inclass", QueryBuilders.termQuery("class", true))).subAggregation(
        Terms terms = response.getAggregations().get("myTerms");
        indexRandom(true, false, indexBuilders);
                        .shardSize(2)
        addTermsDocs("4", 1, indexBuilders);
        addTermsDocs("4", 1, 0, indexBuilders);
            .get();
            .addAggregation(
                    significantTerms("mySignificantTerms").field("text")
        assertSearchResponse(response);
 * this work for additional information regarding copyright
                    .minDocCount(2)
                        .shardMinDocCount(2)
import org.opensearch.common.settings.Settings;
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
                        .executionHint(randomExecutionHint())
        assertSearchResponse(response);
 */
import org.opensearch.search.aggregations.bucket.filter.InternalFilter;
        List<IndexRequestBuilder> indexBuilders = new ArrayList<>();
 * GitHub history for details.
        }
        );
}
                    .executionHint(randomExecutionHint())
            termMappings += ",fielddata=true";
        assertSearchResponse(response);
        }
    }
    // see https://github.com/elastic/elasticsearch/issues/5998
                    .executionHint(randomExecutionHint())
                        .minDocCount(2)
            )
        // first, check that indeed when not setting the shardMinDocCount parameter 0 terms are returned
        addTermsDocs("2", 1, 0, indexBuilders);
                (filter("inclass", QueryBuilders.termQuery("class", true))).subAggregation(
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                    .order(BucketOrder.key(true))
        String sourceClass = "{\"text\": \"" + term + "\", \"class\":" + "true" + "}";
        addTermsDocs("3", 1, indexBuilders);
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to
            builders.add(client().prepareIndex(index).setSource(sourceClass, MediaTypeRegistry.JSON));
 *    http://www.apache.org/licenses/LICENSE-2.0
                        .shardSize(2)
        } else {
        assertAcked(
        if (termtype.equals("text")) {
package org.opensearch.search.aggregations.bucket;
        SignificantTerms sigterms = filteredBucket.getAggregations().get("mySignificantTerms");
                    .size(2)
/*
        final String[] termTypes = { "text", "long", "integer", "float", "double" };
        if (randomBoolean()) {
    public void testShardMinDocCountSignificantTermsTest() throws Exception {
import static org.hamcrest.Matchers.equalTo;
            .addAggregation(
 * this file be licensed under the Apache-2.0 license or a
                    .shardSize(2)
            textMappings = "type=long";
 * Modifications Copyright OpenSearch Contributors. See
        addTermsDocs("5", 3, indexBuilders);// low score but high doc freq
import java.util.Collection;
        indexRandom(true, false, indexBuilders);
                )
import java.util.ArrayList;
        }
                .setMapping("text", termMappings)
            .get();
        List<IndexRequestBuilder> indexBuilders = new ArrayList<>();
            )
 *
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.search.aggregations.BucketOrder;
 * Unless required by applicable law or agreed to in writing,
        addTermsDocs("6", 3, indexBuilders);
    private void addTermsDocs(String term, int numInClass, int numNotInClass, List<IndexRequestBuilder> builders) {
    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        response = client().prepareSearch(index)
        String sourceClass = "{\"text\": \"" + term + "\"}";
/*
        addTermsDocs("6", 3, 1, indexBuilders);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
            .get();
 *
                terms("myTerms").field("text")
 * Licensed to Elasticsearch under one or more contributor
                .setMapping("text", textMappings)
import org.opensearch.search.aggregations.bucket.terms.Terms;
            prepareCreate(index).setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0))
        addTermsDocs("1", 1, 0, indexBuilders);// high score but low doc freq
    }
                    .shardSize(2)
 * ownership. Elasticsearch licenses this file to you under
            prepareCreate(index).setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0))
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
    private static void addTermsDocs(String term, int numDocs, List<IndexRequestBuilder> builders) {
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
                    .minDocCount(2)
        super(staticSettings);
            textMappings = "type=text,fielddata=true";
 * not use this file except in compliance with the License.
        assertThat(sigterms.getBuckets().size(), equalTo(0));
    public static Collection<Object[]> parameters() {
    @ParametersFactory
            .addAggregation(
        assertSearchResponse(response);
            builders.add(client().prepareIndex(index).setSource(sourceNotClass, MediaTypeRegistry.JSON));
        String termtype = termTypes[randomInt(termTypes.length - 1)];
        addTermsDocs("7", 0, 3, indexBuilders);// make sure the terms all get score > 0 except for this one
        assertThat(terms.getBuckets().size(), equalTo(0));
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
                    .size(2)
        addTermsDocs("1", 1, indexBuilders);// low doc freq but high score
            )
        return randomBoolean() ? null : randomFrom(SignificantTermsAggregatorFactory.ExecutionMode.values()).toString();
            "For concurrent segment search shard_min_doc_count is not enforced at the slice level. See https://github.com/opensearch-project/OpenSearch/issues/11847",
 * KIND, either express or implied.  See the License for the
        response = client().prepareSearch(index)
 * specific language governing permissions and limitations
    public void testShardMinDocCountTermsTest() throws Exception {
                terms("myTerms").field("text")
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        for (int i = 0; i < numInClass; i++) {
    }
            internalCluster().clusterService().getClusterSettings().get(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING)
        assumeFalse(
        );
        addTermsDocs("5", 3, 1, indexBuilders);// low score but high doc freq
    private static String randomExecutionHint() {
import org.opensearch.action.index.IndexRequestBuilder;
            .get();
        terms = response.getAggregations().get("myTerms");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        filteredBucket = response.getAggregations().get("inclass");
        );
        addTermsDocs("2", 1, indexBuilders);
        SearchResponse response = client().prepareSearch(index)
import org.opensearch.action.search.SearchResponse;
import java.util.Arrays;
                    .shardMinDocCount(2)
            internalCluster().clusterService().getClusterSettings().get(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING)
