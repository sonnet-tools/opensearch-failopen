import org.opensearch.common.settings.Settings;
            jsonBuilder().startObject()
 * ownership. Elasticsearch licenses this file to you under
     * Some top aggs (eg. date_/histogram) that are executed on unmapped fields, will generate an estimate count of buckets - zero.
            if (rarely()) {
/*
 * KIND, either express or implied.  See the License for the
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_ALL).build() },
                .field("type", "integer")
            .addAggregation(terms("values").field("value").collectMode(aggCollectionMode))
 *
        assertTrue(values.isEmpty());
     * when the sub aggregator is then created, it will take this estimation into account. This used to cause
            } else {
                builders[i] = client().prepareIndex("idx").setSource(jsonBuilder().startObject().field("name", name).endObject());
     * and an ArrayIndexOutOfBoundsException...
                .endObject()
            new Object[] {
 * The OpenSearch Contributors require contributions made to
public class CombiIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
            String name = "name_" + randomIntBetween(1, 10);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * license agreements. See the NOTICE file distributed with
import java.util.HashMap;
 * this work for additional information regarding copyright
        assertThat(values.getBuckets().isEmpty(), is(true));
     * it as "numeric", it didn't work. Now we cache the Value Sources by a custom key (field name + ValueSource type)
            .addAggregation(missing("missing_values").field("value"))
        assertThat(missing.getDocCount(), equalTo(missingValues));
        SearchResponse searchResponse = client().prepareSearch("idx")
                missingValues++;
    public void testMultipleAggsOnSameField_WithDifferentRequiredValueSourceType() throws Exception {
}
     * Making sure that if there are multiple aggregations, working on the same field, yet require different
                builders[i] = client().prepareIndex("idx")
    }
     * field name. If the cached value source was of type "bytes" and another aggregation on the field required to see
import java.util.Map;
 * Licensed to Elasticsearch under one or more contributor
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_AUTO).build() },
                int value = randomIntBetween(1, 10);
import java.util.Collection;
 *
 * Modifications Copyright OpenSearch Contributors. See
        Histogram values = searchResponse.getAggregations().get("values");
    /**
 * You may obtain a copy of the License at
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
        );
                .startObject("name")
import org.opensearch.search.aggregations.bucket.terms.Terms;
 * software distributed under the License is distributed on an
        super(staticSettings);
        assertNotNull(missing);
        ensureSearchable();
            .get();
    public void testSubAggregationForTopAggregationOnUnmappedField() throws Exception {
            )
        return Arrays.asList(
import static org.hamcrest.core.IsNull.notNullValue;
     */
                .startObject("value")
import java.util.List;
    public CombiIT(Settings staticSettings) {
    public static Collection<Object[]> parameters() {
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE;
/*
        assertThat(buckets.size(), equalTo(values.size()));
        assertThat(values, notNullValue());
        Missing missing = aggs.get("missing_values");
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
     * so there's no conflict there.
     */
        }
            values.remove(((Number) bucket.getKey()).intValue());
import static org.opensearch.search.aggregations.AggregationBuilders.missing;
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_ALL;
                .startObject("properties")
import java.util.Arrays;
 */
import org.opensearch.action.search.SearchResponse;
import org.opensearch.search.aggregations.bucket.missing.Missing;
        assertThat(searchResponse.getHits().getTotalHits().value(), Matchers.equalTo(0L));
 * Unless required by applicable law or agreed to in writing,
        ).get();
                values.put(value, values.getOrDefault(value, 0) + 1);
 * not use this file except in compliance with the License.
 *
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_NONE).build() }
                    .setSource(jsonBuilder().startObject().field("name", name).field("value", value).endObject());
        Aggregations aggs = response.getAggregations();
        for (int i = 0; i < builders.length; i++) {
            new Object[] {
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
 * SPDX-License-Identifier: Apache-2.0
        assertSearchResponse(response);
            .addAggregation(
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
package org.opensearch.search.aggregations;
    @ParametersFactory
        }
        final Map<Integer, Integer> values = new HashMap<>();
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_AUTO;
     * value source type, they can all still work. It used to fail as we used to cache the ValueSource by the
        prepareCreate("idx").setMapping(
        createIndex("idx");
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * GitHub history for details.
        SubAggCollectionMode aggCollectionMode = randomFrom(SubAggCollectionMode.values());
import static org.hamcrest.CoreMatchers.is;
 * under the License.
        SubAggCollectionMode aggCollectionMode = randomFrom(SubAggCollectionMode.values());
                .field("type", "keyword")
        ensureSearchable("idx");
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_NONE;
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;
                .endObject()
import org.hamcrest.Matchers;
                .endObject()
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        long missingValues = 0;
        Terms terms = aggs.get("values");
        indexRandom(true, builders);
            .get();
    }
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
import org.opensearch.action.index.IndexRequestBuilder;
                .endObject()
/*
        for (Terms.Bucket bucket : buckets) {
                histogram("values").field("value1").interval(1).subAggregation(terms("names").field("name").collectMode(aggCollectionMode))
import static org.hamcrest.CoreMatchers.equalTo;
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
            }
 */
    /**
        assertNotNull(terms);
            new Object[] {
        IndexRequestBuilder[] builders = new IndexRequestBuilder[randomInt(30)];
    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
        SearchResponse response = client().prepareSearch("idx")
 */
