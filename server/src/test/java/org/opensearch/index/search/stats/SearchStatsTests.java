            Assert.assertNotNull(searchStats.getTotal().getRequestStatsLongHolder());
            );
            .concurrentQueryTimeInMillis(1)
import java.util.concurrent.TimeUnit;
        // avg_concurrency is not summed up across stats
        assertEquals(equalTo, stats.getStarTreeQueryFailed());
                2 * paramValue,
            for (int iterator = 0; iterator < paramValue; iterator++) {
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
import org.opensearch.action.search.SearchRequestOperationsListenerSupport;
        assertEquals(equalTo, stats.getConcurrentQueryCurrent());
            assertEquals(
import static org.mockito.Mockito.when;
        }
        assertEquals(equalTo, stats.getStarTreeQueryCurrent());
            .queryConcurrency(1)
        // another call, adding again ...
            .scrollTimeInMillis(1)
 * under the License.
            .pitCount(1)
import org.opensearch.index.search.stats.SearchStats.Stats;
            when(ctx.getCurrentPhase()).thenReturn(mockSearchPhase);
import static org.mockito.Mockito.mock;
            );
    }
        for (SearchPhaseName searchPhaseName : SearchPhaseName.values()) {
 * Licensed to Elasticsearch under one or more contributor
        searchStats1.add(searchStats2);
            .suggestTimeInMillis(1)
        assertStats(groupStats1.get("group1"), 1);
        SearchStats searchStats1 = new SearchStats(defaultStats.build(), 0, groupStats1);
 * Unless required by applicable law or agreed to in writing,
        Map<String, Stats> groupStats1 = new HashMap<>();
            .scrollCurrent(1)
        groupStats2.put("group1", defaultStats.build());
                searchStats1.getTotal().getRequestStatsLongHolder().getRequestStatsHolder().get(searchPhaseName.getName()).timeInMillis,
        }
        // adding again would then return wrong search stats (would return 4! instead of 3)
import org.opensearch.action.search.SearchPhaseName;
/*
        assertEquals(equalTo, stats.getQueryCount());
            );
        assertEquals(equalTo, stats.getQueryTimeInMillis());
            .fetchCurrent(1)
        // Ensure writeTo() does not throw error with negative 'current'
        searchStats1.setSearchRequestStats(testRequestStats);
            .queryTimeInMillis(1)
        searchStats.setSearchRequestStats(testRequestStats);
                searchStats.getTotal().getRequestStatsLongHolder().getRequestStatsHolder().get(searchPhaseName.getName()).current
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(equalTo, stats.getQueryCurrent());
                searchStats1.getTotal().getRequestStatsLongHolder().getRequestStatsHolder().get(searchPhaseName.getName()).total
    }
                searchStats.getTotal().getRequestStatsLongHolder().getRequestStatsHolder().get(searchPhaseName.getName()).total
 */
 * specific language governing permissions and limitations
        }
 * You may obtain a copy of the License at
        assertEquals(equalTo, stats.getScrollCount());
                greaterThanOrEqualTo(paramValue)
        assertEquals(1, stats.getConcurrentAvgSliceCount(), 0);
 * SPDX-License-Identifier: Apache-2.0
 *
            .pitTimeInMillis(1)
        for (SearchPhaseName searchPhaseName : SearchPhaseName.values()) {
 * Modifications Copyright OpenSearch Contributors. See
    private static void assertStats(Stats stats, long equalTo) {
        assertEquals(equalTo, stats.getFetchTimeInMillis());
            assertThat(
        assertEquals(equalTo, stats.getConcurrentQueryTimeInMillis());
                onPhaseStart(testRequestStats, ctx);
        // let's create two dummy search stats with groups
        searchStats.writeTo(new BytesStreamOutput(10));
        searchStats1.add(searchStats2);
 * ownership. Elasticsearch licenses this file to you under
        long paramValue = randomIntBetween(2, 50);
        // Testing for request stats
        assertEquals(equalTo, stats.getFetchCount());
 *
public class SearchStatsTests extends OpenSearchTestCase implements SearchRequestOperationsListenerSupport {
        assertEquals(equalTo, stats.getSearchIdleReactivateCount());
        // Testing for request stats
            .scrollCount(1)
            .starTreeQueryCount(1)
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(equalTo, stats.getScrollTimeInMillis());
            SearchPhase mockSearchPhase = mock(SearchPhase.class);
}
        assertEquals(equalTo, stats.getSuggestCount());
 * software distributed under the License is distributed on an
                greaterThanOrEqualTo(paramValue)
        assertEquals(equalTo, stats.getScrollCurrent());
            for (int iterator = 0; iterator < paramValue; iterator++) {
 * GitHub history for details.
            when(mockSearchPhase.getSearchPhaseNameOptional()).thenReturn(Optional.ofNullable(searchPhaseName));
            SearchPhase mockSearchPhase = mock(SearchPhase.class);
        SearchRequestStats testRequestStats = new SearchRequestStats(clusterSettings);
        // adding these two search stats and checking group stats are correct
            .concurrentQueryCurrent(1)
        assertEquals(equalTo, stats.getConcurrentQueryCount());
import java.util.Map;
                searchStats1.getTotal().getRequestStatsLongHolder().getRequestStatsHolder().get(searchPhaseName.getName()).current
        SearchRequestStats testRequestStats = new SearchRequestStats(clusterSettings);
            assertEquals(
            when(mockSearchPhase.getSearchPhaseNameOptional()).thenReturn(Optional.of(searchPhaseName));
package org.opensearch.index.search.stats;
    }
        assertStats(groupStats2.get("group1"), 1);
 *
        SearchPhaseContext ctx = mock(SearchPhaseContext.class);
import java.util.HashMap;
        Stats.Builder defaultStats = new Stats.Builder().queryCount(1)
import org.opensearch.test.OpenSearchTestCase;
                -1 * paramValue,    // current is negative, equals -1 * paramValue (num loop iterations)
        SearchStats searchStats2 = new SearchStats(defaultStats.build(), 0, groupStats2);
            .suggestCurrent(1)
            assertEquals(
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        SearchStats searchStats = new SearchStats(new Stats(), 0, new HashMap<>());
                onPhaseStart(testRequestStats, ctx);
                paramValue,
            when(mockSearchPhase.getStartTimeInNanos()).thenReturn(System.nanoTime() - TimeUnit.SECONDS.toNanos(paramValue));
        assertEquals(equalTo, stats.getPitTimeInMillis());
                onPhaseEnd(testRequestStats, ctx);
            .starTreeQueryFailed(1);
        for (SearchPhaseName searchPhaseName : SearchPhaseName.values()) {
            .queryFailed(1)
    public void testNegativeRequestStats() throws Exception {
 * not use this file except in compliance with the License.
 */
            );
        assertEquals(equalTo, stats.getSuggestCurrent());
        SearchPhaseContext ctx = mock(SearchPhaseContext.class);
 * KIND, either express or implied.  See the License for the
            .concurrentQueryCount(1)
            .queryCurrent(1)
        assertEquals(equalTo, stats.getStarTreeQueryCount());
            .suggestCount(1)
import org.opensearch.action.search.SearchPhase;
        searchStats1.add(searchStats2);
 * compatible open source license.
        }
/*
        assertEquals(equalTo, stats.getFetchCurrent());
import org.opensearch.action.search.SearchRequestStats;
/*
import org.opensearch.common.io.stream.BytesStreamOutput;
            );
            }
            when(mockSearchPhase.getStartTimeInNanos()).thenReturn(System.nanoTime() - TimeUnit.SECONDS.toNanos(paramValue));
            );
 */
import org.opensearch.common.settings.Settings;
        assertEquals(equalTo, stats.getPitCount());
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(equalTo, stats.getSuggestTimeInMillis());
                onPhaseEnd(testRequestStats, ctx);
            when(ctx.getCurrentPhase()).thenReturn(mockSearchPhase);
        assertStats(groupStats1.get("group1"), 3);
import org.opensearch.common.settings.ClusterSettings;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        assertEquals(equalTo, stats.getQueryFailedCount());
            .fetchCount(1)
                0,
            .starTreeQueryCurrent(1)
        assertEquals(equalTo, stats.getPitCurrent());
        Map<String, Stats> groupStats2 = new HashMap<>();
        assertEquals(equalTo, stats.getStarTreeQueryTimeInMillis());
            .fetchTimeInMillis(1)
            }
                onPhaseEnd(testRequestStats, ctx); // call onPhaseEnd() twice to make 'current' negative
        assertStats(groupStats1.get("group1"), 2);
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to
            assertThat(
    public void testShardLevelSearchGroupStats() {
        for (SearchPhaseName searchPhaseName : SearchPhaseName.values()) {
import org.opensearch.action.search.SearchPhaseContext;
            .pitCurrent(1)
 * license agreements. See the NOTICE file distributed with
import java.util.Optional;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        // making sure stats2 was not affected (this would previously return 2!)
            assertEquals(
            .starTreeQueryTimeInMillis(1)
                searchStats.getTotal().getRequestStatsLongHolder().getRequestStatsHolder().get(searchPhaseName.getName()).timeInMillis,
        long paramValue = randomIntBetween(2, 50);
            .searchIdleReactivateCount(1)
import org.junit.Assert;
