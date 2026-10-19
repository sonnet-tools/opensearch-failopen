        }
                        jsonBuilder().startObject().field("value", i + 1).field("tag", "tag2").field("name", "name" + i + 1).endObject()  
 * under the License.  
            fail(  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;  
        return Arrays.asList(  
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.search.aggregations.bucket.global.Global;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        SearchResponse response = client().prepareSearch("idx")
    @ParametersFactory
                client().prepareIndex("idx")  
                "expected to fail executing non-top-level global aggregator. global aggregations are only allowed as top level"
                    )
import org.opensearch.index.query.QueryBuilders;  
            );
        ensureSearchable();
import java.util.Collection;  
 * this work for additional information regarding copyright
public class GlobalIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
            sum += i + 1;
 * this file be licensed under the Apache-2.0 license or a
            );  
    public static Collection<Object[]> parameters() {
        Stats stats = global.getAggregations().get("value_stats");
            client().prepareSearch("idx")
        assertThat(stats.getCount(), equalTo((long) numDocs));
            .setQuery(QueryBuilders.termQuery("tag", "tag1"))  
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
    @Override  
            assertThat(e.getMessage(), is("all shards failed"));  
 *
import org.opensearch.search.aggregations.InternalAggregation;
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
                .setQuery(QueryBuilders.termQuery("tag", "tag1"))
 * You may obtain a copy of the License at  
@OpenSearchIntegTestCase.SuiteScopeTestCase
import static org.opensearch.search.aggregations.AggregationBuilders.stats;  
                    + "aggregations"
        try {  
        assertThat((Stats) ((InternalAggregation) global).getProperty("value_stats"), sameInstance(stats));  
            builders.add(
 * Licensed to Elasticsearch under one or more contributor  
        createIndex("idx");
            .setProfile(profileEnabled)
            );
import org.opensearch.test.OpenSearchIntegTestCase;
}  
        Global global = response.getAggregations().get("global");
 *  
 *
 * software distributed under the License is distributed on an
        assertThat(stats.getMin(), equalTo(1.0));
    public void testWithStatsSubAggregatorAndProfileEnabled() throws Exception {
        indexRandom(true, builders);
import static org.hamcrest.core.IsNull.notNullValue;
 * license agreements. See the NOTICE file distributed with
    }
        testWithStatsSubAggregator(true);  
        }  
    static int numDocs;
        for (int i = 0; i < numDocs; ++i) {
 * Modifications Copyright OpenSearch Contributors. See  
/*
import java.util.Arrays;
import static org.hamcrest.Matchers.sameInstance;
    public void setupSuiteScopeCluster() throws Exception {
        assertThat(stats.getName(), equalTo("value_stats"));
    }  
            .addAggregation(global("global").subAggregation(stats("value_stats").field("value")))
        assertThat(stats.getSum(), equalTo((double) sum));
                    .setId("" + i + 1)  
 * SPDX-License-Identifier: Apache-2.0
/*
        assertThat(global.getName(), equalTo("global"));  
        } catch (OpenSearchException e) {
 * not use this file except in compliance with the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
        );  
import org.opensearch.OpenSearchException;
        for (int i = 0; i < numDocs / 2; i++) {  
 * compatible open source license.
        List<IndexRequestBuilder> builders = new ArrayList<>();
 * GitHub history for details.
    public void testWithStatsSubAggregatorAndProfileDisabled() throws Exception {  
            builders.add(
    }
        long sum = 0;  
    private void testWithStatsSubAggregator(boolean profileEnabled) throws Exception {
    }  
                    .setId("" + i + 1)
import java.util.List;
                .get();
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.action.search.SearchResponse;
        assertThat((long) ((InternalAggregation) global).getProperty("_count"), equalTo((long) numDocs));
    }
        assertThat(global.getDocCount(), equalTo((long) numDocs));
/*  
 * The OpenSearch Contributors require contributions made to  
        assertThat(stats, notNullValue());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
        }  
        for (int i = numDocs / 2; i < numDocs; i++) {
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
        assertThat(stats.getMax(), equalTo((double) numDocs));  
        assertThat(global.getAggregations().asList().isEmpty(), is(false));  
    }
        createIndex("idx2");  
 * KIND, either express or implied.  See the License for the
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
 * specific language governing permissions and limitations
import java.util.ArrayList;
        assertSearchResponse(response);
                client().prepareIndex("idx")
import org.opensearch.common.settings.Settings;
 */
                .addAggregation(global("global").subAggregation(global("inner_global")))  
        numDocs = randomIntBetween(3, 20);
 */
        assertThat(stats.getAvg(), equalTo((double) sum / numDocs));
    }
import static org.opensearch.search.aggregations.AggregationBuilders.global;
import org.opensearch.search.aggregations.metrics.Stats;  
                    .setSource(
        }  
import static org.hamcrest.Matchers.is;  
                    .setSource(jsonBuilder().startObject().field("value", i + 1).field("tag", "tag1").endObject())
import org.opensearch.action.index.IndexRequestBuilder;  
            .get();  
        assertThat(global, notNullValue());
        testWithStatsSubAggregator(false);
    public void testNonTopLevel() throws Exception {
package org.opensearch.search.aggregations.bucket;
        super(staticSettings);
    public GlobalIT(Settings staticSettings) {  
