import org.opensearch.common.settings.Settings;
 * specific language governing permissions and limitations
                .field("type", "keyword")
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            if (rarely()) {
import java.util.Map;
    }  
    /**  
    }
import org.opensearch.search.aggregations.bucket.terms.Terms;  
import java.util.HashMap;  
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.search.aggregations;
     * and an ArrayIndexOutOfBoundsException...  
            .addAggregation(  
import org.hamcrest.Matchers;
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
    @ParametersFactory
                .startObject("properties")  
        SubAggCollectionMode aggCollectionMode = randomFrom(SubAggCollectionMode.values());
        for (Terms.Bucket bucket : buckets) {  
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
     * field name. If the cached value source was of type "bytes" and another aggregation on the field required to see
 *
     * so there's no conflict there.
        for (int i = 0; i < builders.length; i++) {  
        Aggregations aggs = response.getAggregations();
        assertNotNull(terms);  
        ensureSearchable("idx");
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_ALL).build() },  
        }
}
 *
                .startObject("name")
import static org.hamcrest.CoreMatchers.is;
            )
        ).get();  
     * when the sub aggregator is then created, it will take this estimation into account. This used to cause
                    .setSource(jsonBuilder().startObject().field("name", name).field("value", value).endObject());  
 * this work for additional information regarding copyright
        ensureSearchable();
        assertThat(missing.getDocCount(), equalTo(missingValues));  
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_NONE).build() }
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            .addAggregation(terms("values").field("value").collectMode(aggCollectionMode))  
 */  
/*  
/*
 */  
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_AUTO).build() },
     * value source type, they can all still work. It used to fail as we used to cache the ValueSource by the
    /**
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;  
import static org.hamcrest.CoreMatchers.equalTo;
     */
                .endObject()
     * Some top aggs (eg. date_/histogram) that are executed on unmapped fields, will generate an estimate count of buckets - zero.
 * GitHub history for details.
import java.util.List;
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
 * software distributed under the License is distributed on an
        assertThat(buckets.size(), equalTo(values.size()));
                .endObject()
        long missingValues = 0;
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_NONE;
 * not use this file except in compliance with the License.
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;  
                builders[i] = client().prepareIndex("idx").setSource(jsonBuilder().startObject().field("name", name).endObject());
        );
                histogram("values").field("value1").interval(1).subAggregation(terms("names").field("name").collectMode(aggCollectionMode))
            jsonBuilder().startObject()
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
import org.opensearch.search.aggregations.bucket.missing.Missing;
 *    http://www.apache.org/licenses/LICENSE-2.0
        SubAggCollectionMode aggCollectionMode = randomFrom(SubAggCollectionMode.values());  
        assertThat(values, notNullValue());
        final Map<Integer, Integer> values = new HashMap<>();
                .startObject("value")
                .endObject()  
    public static Collection<Object[]> parameters() {  
        assertNotNull(missing);
 */
        assertThat(values.getBuckets().isEmpty(), is(true));
            new Object[] {
        indexRandom(true, builders);  
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_ALL;  
        Histogram values = searchResponse.getAggregations().get("values");  
            .addAggregation(missing("missing_values").field("value"))
    public CombiIT(Settings staticSettings) {
                values.put(value, values.getOrDefault(value, 0) + 1);
 * KIND, either express or implied.  See the License for the
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
 * Licensed to Elasticsearch under one or more contributor  
 *  
    }  
        createIndex("idx");
 * Modifications Copyright OpenSearch Contributors. See
            new Object[] {
        prepareCreate("idx").setMapping(
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_AUTO;
            .get();  
import java.util.Collection;
import org.opensearch.action.search.SearchResponse;
     * it as "numeric", it didn't work. Now we cache the Value Sources by a custom key (field name + ValueSource type)  
 * under the License.  
                missingValues++;  
        Terms terms = aggs.get("values");
                .field("type", "integer")
 * ownership. Elasticsearch licenses this file to you under  
        Missing missing = aggs.get("missing_values");
     * Making sure that if there are multiple aggregations, working on the same field, yet require different  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            } else {
 * SPDX-License-Identifier: Apache-2.0
        super(staticSettings);
        }
            new Object[] {  
import static org.hamcrest.core.IsNull.notNullValue;  
            .get();
/*  
        SearchResponse response = client().prepareSearch("idx")
            String name = "name_" + randomIntBetween(1, 10);
        assertTrue(values.isEmpty());  
                .endObject()  
import java.util.Arrays;
 * compatible open source license.
public class CombiIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
    public void testSubAggregationForTopAggregationOnUnmappedField() throws Exception {
                int value = randomIntBetween(1, 10);  
import org.opensearch.action.index.IndexRequestBuilder;  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;  
        return Arrays.asList(
 * The OpenSearch Contributors require contributions made to  
        IndexRequestBuilder[] builders = new IndexRequestBuilder[randomInt(30)];  
 * the Apache License, Version 2.0 (the "License"); you may
     */
import static org.opensearch.search.aggregations.AggregationBuilders.missing;
    public void testMultipleAggsOnSameField_WithDifferentRequiredValueSourceType() throws Exception {  
        assertThat(searchResponse.getHits().getTotalHits().value(), Matchers.equalTo(0L));
        SearchResponse searchResponse = client().prepareSearch("idx")
            }
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE;
        assertSearchResponse(response);  
            values.remove(((Number) bucket.getKey()).intValue());
    }  
                builders[i] = client().prepareIndex("idx")
