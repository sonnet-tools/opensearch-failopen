                        .collectMode(randomFrom(Aggregator.SubAggCollectionMode.values()))
import org.opensearch.OpenSearchException;
/*  
            client().prepareSearch("test")
            if (ExceptionsHelper.unwrap(e, CircuitBreakingException.class) == null) {
    }
import org.opensearch.ExceptionsHelper;  
        final String requestBreaker = randomIntBetween(1, 10000) + "kb";
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
                .get();
                        .order(BucketOrder.aggregation("cardinality", randomBoolean()))
 * this work for additional information regarding copyright
                        .setSource(Map.of("field0", randomAlphaOfLength(5), "field1", randomAlphaOfLength(5)))
}
        super(staticSettings);
                        .subAggregation(cardinality("cardinality").precisionThreshold(randomLongBetween(1, 40000)).field("field1.keyword"))  
            .prepareUpdateSettings()
 */  
                .toArray(IndexRequestBuilder[]::new)  
            true,
    public CardinalityWithRequestBreakerIT(Settings staticSettings) {  
    /**  
            .setTransientSettings(  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
import org.opensearch.common.settings.Settings;  
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        client().admin()  
import org.opensearch.search.aggregations.Aggregator;  
 *
        logger.info("--> Using request breaker setting: {}", requestBreaker);
            .get();  
 * ownership. Elasticsearch licenses this file to you under  
                )
import java.util.Map;  
    }
package org.opensearch.search.aggregations.metrics;
 * license agreements. See the NOTICE file distributed with
 *  
                        .setId("id_" + i)  
    public void testRequestBreaker() throws Exception {  
import org.opensearch.search.aggregations.BucketOrder;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
 */
 */  
import java.util.Collection;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
 * under the License.  
            .setTransientSettings(Settings.builder().putNull(HierarchyCircuitBreakerService.REQUEST_CIRCUIT_BREAKER_LIMIT_SETTING.getKey()))  
        }
        return Arrays.asList(  
 * Licensed to Elasticsearch under one or more contributor  
                )
 * You may obtain a copy of the License at  
            .cluster()
 *
                .addAggregation(
    }
            .get();
import org.opensearch.action.index.IndexRequestBuilder;
            .prepareUpdateSettings()
            .cluster()
import java.util.stream.IntStream;
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
 *     http://www.apache.org/licenses/LICENSE-2.0
        indexRandomForConcurrentSearch("test");
     * Test that searches using cardinality aggregations returns all request breaker memory.
public class CardinalityWithRequestBreakerIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
                .mapToObj(
import static org.opensearch.search.aggregations.AggregationBuilders.cardinality;
/*
 * compatible open source license.
        // validation done by InternalTestCluster.ensureEstimatedStats()  
        try {  
import org.opensearch.core.common.breaker.CircuitBreakingException;
/*  
     */
 * Unless required by applicable law or agreed to in writing,
        client().admin()  
            IntStream.range(0, randomIntBetween(10, 1000))  
 * not use this file except in compliance with the License.
        );
                    i -> client().prepareIndex("test")
                Settings.builder().put(HierarchyCircuitBreakerService.REQUEST_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), requestBreaker)
import org.opensearch.indices.breaker.HierarchyCircuitBreakerService;
 * this file be licensed under the Apache-2.0 license or a
        );  
    public static Collection<Object[]> parameters() {
        } catch (OpenSearchException e) {  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;  
import java.util.Arrays;
            )
    @ParametersFactory
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See
                throw e;
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
                    terms("terms").field("field0.keyword")  
        indexRandom(
            }  
