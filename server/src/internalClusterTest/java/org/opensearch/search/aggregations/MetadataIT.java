            assertMetadata(sum.getMetadata());
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
                put("complex", nestedMetadata);
 * ownership. Elasticsearch licenses this file to you under  
                .setSource(jsonBuilder().startObject().field("name", name).field("value", randomInt()).endObject());
 * KIND, either express or implied.  See the License for the
        IndexRequestBuilder[] builders = new IndexRequestBuilder[randomInt(30)];  
        Aggregations aggs = response.getAggregations();  
 * under the License.  
import org.opensearch.search.aggregations.pipeline.InternalBucketMetricValue;
        SearchResponse response = client().prepareSearch("idx")  
    private void assertMetadata(Map<String, Object> returnedMetadata) {
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE;  
        Map<String, Object> nestedMap = (Map<String, Object>) nestedObject;
        assertNotNull(terms);
        );
import org.opensearch.action.search.SearchResponse;
        indexRandom(true, builders);  
import java.util.Arrays;
                put("key", "value");
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_ALL;
            .addAggregation(
            new Object[] {
 *
        return Arrays.asList(  
        assertNotNull(aggs);
 * the Apache License, Version 2.0 (the "License"); you may
            }  
        }
        assertNotNull(maxBucket);  
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
                put("nested", "value");
import static org.opensearch.search.aggregations.PipelineAggregatorBuilders.maxBucket;  
}
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_NONE;  
                terms("the_terms").setMetadata(metadata).field("name").subAggregation(sum("the_sum").setMetadata(metadata).field("value"))
            Sum sum = subAggs.get("the_sum");  
            new Object[] {
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
 */
 * You may obtain a copy of the License at  
import org.opensearch.action.index.IndexRequestBuilder;  
 *
        Terms terms = aggs.get("the_terms");  
        };
/*  
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_ALL).build() },
                put("numeric", 1.2);  
            .get();
 * GitHub history for details.
/*  
    }
 * this work for additional information regarding copyright
 */  
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_AUTO).build() },
import java.util.Map;  
        assertMetadata(terms.getMetadata());
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
        };
        assertNotNull(returnedMetadata);
        for (Terms.Bucket bucket : buckets) {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        ensureSearchable();
            new Object[] {  
        Object nestedObject = returnedMetadata.get("complex");
import java.util.Collection;  
    public static Collection<Object[]> parameters() {
        assertAcked(client().admin().indices().prepareCreate("idx").setMapping("name", "type=keyword").get());
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        final Map<String, Object> nestedMetadata = new HashMap<String, Object>() {  
import org.opensearch.search.aggregations.bucket.terms.Terms;  
        assertEquals(4, returnedMetadata.size());  
    public void testMetadataSetOnAggregationResult() throws Exception {
        assertNotNull(nestedObject);  
 * The OpenSearch Contributors require contributions made to  
import java.util.HashMap;
    @ParametersFactory
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
    }
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_NONE).build() }  
public class MetadataIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.List;
        assertEquals(true, returnedMetadata.get("bool"));  
    }
        super(staticSettings);
            {
        assertEquals("value", nestedMap.get("nested"));  
        assertSearchResponse(response);
        Map<String, Object> metadata = new HashMap<String, Object>() {  
    }
 * SPDX-License-Identifier: Apache-2.0
            )  
package org.opensearch.search.aggregations;
            Aggregations subAggs = bucket.getAggregations();  
        InternalBucketMetricValue maxBucket = aggs.get("the_max_bucket");
            assertNotNull(subAggs);
 * compatible open source license.
            .addAggregation(maxBucket("the_max_bucket", "the_terms>the_sum").setMetadata(metadata))
 * software distributed under the License is distributed on an
            {
import org.opensearch.common.settings.Settings;
                put("bool", true);
        }  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 * not use this file except in compliance with the License.
 *  
    public MetadataIT(Settings staticSettings) {  
 * Unless required by applicable law or agreed to in writing,
        assertEquals("value", returnedMetadata.get("key"));
        assertEquals(1.2, returnedMetadata.get("numeric"));
            builders[i] = client().prepareIndex("idx")  
        for (int i = 0; i < builders.length; i++) {
            assertNotNull(sum);
 * Modifications Copyright OpenSearch Contributors. See
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_AUTO;
 * license agreements. See the NOTICE file distributed with
            }  
        assertMetadata(maxBucket.getMetadata());
import org.opensearch.search.aggregations.metrics.Sum;
            String name = "name_" + randomIntBetween(1, 10);
/*
 * this file be licensed under the Apache-2.0 license or a
