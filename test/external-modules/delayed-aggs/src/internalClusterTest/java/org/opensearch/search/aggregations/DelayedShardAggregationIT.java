            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
            .get();
                new DelayedShardAggregationBuilder("delay", TimeValue.timeValueMillis(10)).subAggregation(
        List<IndexRequestBuilder> reqs = new ArrayList<>();
/*
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
/*  
            float rand = randomFloat();  
/*
        Aggregations aggs = response.getAggregations();  
    @Override
    }
 * license agreements. See the NOTICE file distributed with
        assertThat(aggs.get("delay"), instanceOf(InternalFilter.class));
 * Licensed to Elasticsearch under one or more contributor  
}  
 * this file be licensed under the Apache-2.0 license or a
        SearchResponse response = client().prepareSearch("index")
 * not use this file except in compliance with the License.
import static org.hamcrest.Matchers.instanceOf;
                )  
public class DelayedShardAggregationIT extends ParameterizedOpenSearchIntegTestCase {
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },  
import org.opensearch.search.aggregations.bucket.filter.InternalFilter;
 * SPDX-License-Identifier: Apache-2.0
    public void testSimple() throws Exception {
    @ParametersFactory  
import java.util.Collection;
        );
 * Modifications Copyright OpenSearch Contributors. See  
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
 * compatible open source license.
        InternalFilter filter = aggs.get("delay");
 * this work for additional information regarding copyright
import java.util.Arrays;
 */  
import java.util.ArrayList;  
import org.opensearch.search.aggregations.metrics.MaxAggregationBuilder;  
            expectedMax = Math.max(rand, expectedMax);
    }  
import org.opensearch.plugins.Plugin;  
import org.opensearch.test.ParameterizedOpenSearchIntegTestCase;
import org.opensearch.action.search.SearchResponse;  
 * the Apache License, Version 2.0 (the "License"); you may
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        assertAcked(client().admin().indices().prepareCreate("index"));
import static org.hamcrest.Matchers.equalTo;
        assertThat((float) max.getValue(), equalTo(expectedMax));
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        for (int i = 0; i < 5; i++) {
    public static Collection<Object[]> parameters() {
        return Arrays.asList(
            reqs.add(client().prepareIndex("index").setSource("number", rand));
        InternalMax max = filter.getAggregations().get("max");  
 * The OpenSearch Contributors require contributions made to  
        return Arrays.asList(DelayedShardAggregationPlugin.class);
package org.opensearch.search.aggregations;
import org.opensearch.action.index.IndexRequestBuilder;
import org.opensearch.common.unit.TimeValue;
        indexRandom(true, reqs);
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
 * under the License.  
        }  
import org.opensearch.search.aggregations.metrics.InternalMax;
import org.opensearch.common.settings.Settings;
 *  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 */
            .addAggregation(  
    }
 * KIND, either express or implied.  See the License for the
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;  
            )
 * specific language governing permissions and limitations
 * GitHub history for details.
                    new MaxAggregationBuilder("max").field("number")
 */
 * ownership. Elasticsearch licenses this file to you under  
import java.util.List;  
        float expectedMax = Float.MIN_VALUE;  
 *
