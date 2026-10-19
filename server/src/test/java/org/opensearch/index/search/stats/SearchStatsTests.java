import org.opensearch.action.search.SearchRequestStats;
 */  
        assertStats(groupStats1.get("group1"), 1);
 * Modifications Copyright OpenSearch Contributors. See
 * ownership. Elasticsearch licenses this file to you under  
            Assert.assertNotNull(searchStats.getTotal().getRequestStatsLongHolder());  
                onPhaseEnd(testRequestStats, ctx); // call onPhaseEnd() twice to make 'current' negative
        searchStats1.add(searchStats2);  
 * under the License.  
        assertEquals(equalTo, stats.getFetchCount());  
        assertEquals(equalTo, stats.getQueryTimeInMillis());
        // Ensure writeTo() does not throw error with negative 'current'  
                -1 * paramValue,    // current is negative, equals -1 * paramValue (num loop iterations)
import java.util.HashMap;
            );  
        // another call, adding again ...
/*  
            );
            for (int iterator = 0; iterator < paramValue; iterator++) {
            .concurrentQueryCurrent(1)
/*
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
import org.opensearch.action.search.SearchPhase;
                paramValue,
            .starTreeQueryCount(1)
            .queryFailed(1)
        assertEquals(equalTo, stats.getStarTreeQueryCurrent());
            .scrollTimeInMillis(1)
            .fetchCurrent(1)
            SearchPhase mockSearchPhase = mock(SearchPhase.class);  
            );
            .concurrentQueryTimeInMillis(1)  
            }
 *
        SearchStats searchStats1 = new SearchStats(defaultStats.build(), 0, groupStats1);  
import static org.mockito.Mockito.mock;
                onPhaseEnd(testRequestStats, ctx);
 * compatible open source license.
import java.util.concurrent.TimeUnit;
    private static void assertStats(Stats stats, long equalTo) {  
                searchStats.getTotal().getRequestStatsLongHolder().getRequestStatsHolder().get(searchPhaseName.getName()).total
        assertEquals(equalTo, stats.getQueryCount());
                2 * paramValue,  
            when(ctx.getCurrentPhase()).thenReturn(mockSearchPhase);
        // avg_concurrency is not summed up across stats
                greaterThanOrEqualTo(paramValue)
            }
            .queryConcurrency(1)
        for (SearchPhaseName searchPhaseName : SearchPhaseName.values()) {
        assertEquals(equalTo, stats.getSuggestTimeInMillis());
        groupStats2.put("group1", defaultStats.build());
        SearchStats searchStats2 = new SearchStats(defaultStats.build(), 0, groupStats2);
            when(ctx.getCurrentPhase()).thenReturn(mockSearchPhase);
        assertEquals(equalTo, stats.getQueryFailedCount());
            );
            .fetchTimeInMillis(1)
                searchStats.getTotal().getRequestStatsLongHolder().getRequestStatsHolder().get(searchPhaseName.getName()).timeInMillis,
        // Testing for request stats
        assertEquals(equalTo, stats.getPitCount());  
        searchStats1.setSearchRequestStats(testRequestStats);
        searchStats1.add(searchStats2);
        assertEquals(equalTo, stats.getStarTreeQueryCount());
 * specific language governing permissions and limitations
            assertThat(  
            assertEquals(
            .suggestCurrent(1)
            .suggestCount(1)  
        for (SearchPhaseName searchPhaseName : SearchPhaseName.values()) {  
        Stats.Builder defaultStats = new Stats.Builder().queryCount(1)
            when(mockSearchPhase.getStartTimeInNanos()).thenReturn(System.nanoTime() - TimeUnit.SECONDS.toNanos(paramValue));
            assertEquals(
 * The OpenSearch Contributors require contributions made to  
            .starTreeQueryTimeInMillis(1)
        assertEquals(equalTo, stats.getScrollCurrent());
        assertEquals(equalTo, stats.getFetchCurrent());
        assertEquals(equalTo, stats.getPitCurrent());
            for (int iterator = 0; iterator < paramValue; iterator++) {
            .starTreeQueryFailed(1);
        long paramValue = randomIntBetween(2, 50);
import org.opensearch.common.settings.ClusterSettings;
}  
 * this work for additional information regarding copyright
        SearchStats searchStats = new SearchStats(new Stats(), 0, new HashMap<>());  
 * KIND, either express or implied.  See the License for the
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(equalTo, stats.getScrollTimeInMillis());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .suggestTimeInMillis(1)
            assertEquals(
        assertEquals(equalTo, stats.getStarTreeQueryTimeInMillis());  
import org.opensearch.index.search.stats.SearchStats.Stats;  
        assertEquals(equalTo, stats.getConcurrentQueryCount());
 * You may obtain a copy of the License at  
        assertEquals(equalTo, stats.getSuggestCurrent());
        }
        searchStats1.add(searchStats2);
            assertThat(
        }  
                searchStats.getTotal().getRequestStatsLongHolder().getRequestStatsHolder().get(searchPhaseName.getName()).current  
 * Licensed to Elasticsearch under one or more contributor  
        searchStats.setSearchRequestStats(testRequestStats);
        assertEquals(equalTo, stats.getConcurrentQueryTimeInMillis());  
            .fetchCount(1)  
/*  
    public void testNegativeRequestStats() throws Exception {
        assertStats(groupStats1.get("group1"), 3);
            .searchIdleReactivateCount(1)  
 *
        assertEquals(1, stats.getConcurrentAvgSliceCount(), 0);
        // Testing for request stats
        assertEquals(equalTo, stats.getStarTreeQueryFailed());
        SearchRequestStats testRequestStats = new SearchRequestStats(clusterSettings);  
        // adding these two search stats and checking group stats are correct  
            when(mockSearchPhase.getSearchPhaseNameOptional()).thenReturn(Optional.ofNullable(searchPhaseName));  
            .queryTimeInMillis(1)
        assertStats(groupStats2.get("group1"), 1);  
        SearchRequestStats testRequestStats = new SearchRequestStats(clusterSettings);
    }  
import static org.mockito.Mockito.when;
            .scrollCount(1)  
                searchStats1.getTotal().getRequestStatsLongHolder().getRequestStatsHolder().get(searchPhaseName.getName()).total  
        Map<String, Stats> groupStats2 = new HashMap<>();  
        }  
import java.util.Optional;  
 * software distributed under the License is distributed on an
            );
        assertEquals(equalTo, stats.getPitTimeInMillis());
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
package org.opensearch.index.search.stats;
import org.opensearch.action.search.SearchPhaseName;  
            );  
                onPhaseEnd(testRequestStats, ctx);  
        SearchPhaseContext ctx = mock(SearchPhaseContext.class);
        assertEquals(equalTo, stats.getFetchTimeInMillis());
    public void testShardLevelSearchGroupStats() {  
                searchStats1.getTotal().getRequestStatsLongHolder().getRequestStatsHolder().get(searchPhaseName.getName()).current
import org.opensearch.action.search.SearchRequestOperationsListenerSupport;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.io.stream.BytesStreamOutput;  
                greaterThanOrEqualTo(paramValue)
        assertEquals(equalTo, stats.getScrollCount());  
    }
                0,
 * license agreements. See the NOTICE file distributed with
        long paramValue = randomIntBetween(2, 50);  
        // let's create two dummy search stats with groups
        assertEquals(equalTo, stats.getSuggestCount());  
            .queryCurrent(1)  
import org.junit.Assert;
        assertEquals(equalTo, stats.getSearchIdleReactivateCount());  
 * the Apache License, Version 2.0 (the "License"); you may
 *  
import org.opensearch.action.search.SearchPhaseContext;
        }  
            .pitTimeInMillis(1)
public class SearchStatsTests extends OpenSearchTestCase implements SearchRequestOperationsListenerSupport {
            .scrollCurrent(1)
            .starTreeQueryCurrent(1)  
 * this file be licensed under the Apache-2.0 license or a
 */  
 */
            .pitCurrent(1)
        // making sure stats2 was not affected (this would previously return 2!)
 * GitHub history for details.
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
            when(mockSearchPhase.getSearchPhaseNameOptional()).thenReturn(Optional.of(searchPhaseName));
    }
        assertEquals(equalTo, stats.getConcurrentQueryCurrent());
 * not use this file except in compliance with the License.
                onPhaseStart(testRequestStats, ctx);
        for (SearchPhaseName searchPhaseName : SearchPhaseName.values()) {
            SearchPhase mockSearchPhase = mock(SearchPhase.class);
        for (SearchPhaseName searchPhaseName : SearchPhaseName.values()) {
            when(mockSearchPhase.getStartTimeInNanos()).thenReturn(System.nanoTime() - TimeUnit.SECONDS.toNanos(paramValue));  
        assertStats(groupStats1.get("group1"), 2);  
        assertEquals(equalTo, stats.getQueryCurrent());  
            .concurrentQueryCount(1)
import java.util.Map;
import org.opensearch.common.settings.Settings;
import org.opensearch.test.OpenSearchTestCase;
            .pitCount(1)  
                onPhaseStart(testRequestStats, ctx);  
        // adding again would then return wrong search stats (would return 4! instead of 3)
 * Unless required by applicable law or agreed to in writing,
            assertEquals(  
        SearchPhaseContext ctx = mock(SearchPhaseContext.class);
        Map<String, Stats> groupStats1 = new HashMap<>();
        searchStats.writeTo(new BytesStreamOutput(10));
                searchStats1.getTotal().getRequestStatsLongHolder().getRequestStatsHolder().get(searchPhaseName.getName()).timeInMillis,  
