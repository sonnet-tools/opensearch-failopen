 * specific language governing permissions and limitations
                .get(new TimeValue(15, TimeUnit.SECONDS));
        Settings resetSettings = Settings.builder()
            assertTrue("there should be shard failures", resp.getFailedShards() > 0);
            NodesStatsResponse resp = client().admin()
            .build();
        assertAcked(
import java.util.stream.Stream;
    }
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
public class CircuitBreakerServiceIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        List<IndexRequestBuilder> reqs = new ArrayList<>();
        NodesStatsResponse stats = client().admin().cluster().prepareNodesStats().addMetric(BREAKER.metricName()).get();
            .put(HierarchyCircuitBreakerService.FIELDDATA_CIRCUIT_BREAKER_OVERHEAD_SETTING.getKey(), 1.05)
                    .put(EnableAllocationDecider.INDEX_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), EnableAllocationDecider.Rebalance.NONE)
import static org.opensearch.test.OpenSearchIntegTestCase.Scope.TEST;
        if (noopBreakerUsed()) {
                MediaTypeRegistry.JSON
            assertThat("Exception: [" + e.toString() + "] should contain a CircuitBreakingException", e.toString(), containsString(errMsg));
        if (noopBreakerUsed()) {
        ).forEach(s -> resetSettings.putNull(s.getKey()));
        Settings settings = Settings.builder()
            }
        Client client = client();
 * this work for additional information regarding copyright
            String errMsg = "CircuitBreakingException[[request] Data too large";
            reqs.add(client.prepareIndex("ramtest").setId(Long.toString(id)).setSource("test", "value" + id));
            }
    public void testRamAccountingTermsEnum() throws Exception {
        // execute a search that loads field data (sorting on the "test" field)
            if (stat.getNode().isDataNode()) {
        errMsg = "which is larger than the limit of [100/100b]";
        if (noopBreakerUsed()) {
 * license agreements. See the NOTICE file distributed with
        // clear field data cache (thus setting the loaded field data back to 0)
            errMsg = "which is larger than the limit of [10/10b]]";
    @After
        for (long id = 0; id < docCount; id++) {
                return true;
        assertAcked(prepareCreate("cb-test", 1, Settings.builder().put(SETTING_NUMBER_OF_REPLICAS, between(0, 1))));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFailures;
        ensureGreen("ramtest");
            CircuitBreakerStats breakerStats = stat.getBreaker().getStats(CircuitBreaker.FIELDDATA);
            .put(HierarchyCircuitBreakerService.FIELDDATA_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), "100b")
import static org.opensearch.search.aggregations.AggregationBuilders.cardinality;
package org.opensearch.indices.memory.breaker;
import org.opensearch.action.search.SearchResponse;
                    + "{\"type\": \"text\",\"fielddata\": true,\"fielddata_frequency_filter\": {\"max\": 10000}}}}}}",
import java.util.Collections;
        // execute a search that loads field data (sorting on the "test" field)
        } catch (CircuitBreakingException ex) {
            logger.info("--> noop breakers used, skipping test");
            if (nodeStats.getBreaker().getStats(CircuitBreaker.FIELDDATA).getLimit() == NoopCircuitBreaker.LIMIT) {
            HierarchyCircuitBreakerService.FIELDDATA_CIRCUIT_BREAKER_OVERHEAD_SETTING,
        // index some different terms so we have some field data for loading
    }
                );
        }
            prepareCreate("index").setSettings(
        List<IndexRequestBuilder> reqs = new ArrayList<>();
                assertThat(
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
            .build();
import org.opensearch.core.common.breaker.NoopCircuitBreaker;
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    /** Reset all breaker settings back to their defaults */
        );
    }
    public void clearFieldData() throws Exception {
            .build();
            }
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        );
 * Integration tests for InternalCircuitBreakerService
                // each item must have failed with CircuitBreakingException
            HierarchyCircuitBreakerService.FIELDDATA_CIRCUIT_BREAKER_LIMIT_SETTING,
            return;
        assertFailures(searchRequest, RestStatus.INTERNAL_SERVER_ERROR, containsString(errMsg));
            reqs.add(client.prepareIndex("cb-test").setId(Long.toString(id)).setSource("test", id));
import org.opensearch.action.bulk.BulkRequest;
                .get()
        int breaks = 0;
            } else {
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
            logger.info("--> noop breakers used, skipping test");
                    .put("index.routing.allocation.include._name", targetNode.getNode().getName())
 * You may obtain a copy of the License at
        // A terms aggregation on the "test" field should trip the bucket circuit breaker
        errMsg = "which is larger than the limit of [100/100b]";
            client().admin()
            logger.info("--> noop breakers used, skipping test");
        assertThat(breaks, greaterThanOrEqualTo(1));
        for (NodeStats nodeStats : stats.getNodes()) {
import org.junit.Before;
        }
        try {
        client().admin().indices().prepareClearCache().setFieldDataCache(true).execute().actionGet();
    public void testBucketBreaker() throws Exception {
            HierarchyCircuitBreakerService.IN_FLIGHT_REQUESTS_CIRCUIT_BREAKER_OVERHEAD_SETTING,
        }
        );
                "type=text,fielddata=true"
        int numRequests = inFlightRequestsLimit.bytesAsInt();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertFailures(searchRequest, RestStatus.INTERNAL_SERVER_ERROR, containsString(errMsg));
        for (NodeStats stat : nodeStats.getNodes()) {
            if (nodeStats.getBreaker().getStats(CircuitBreaker.IN_FLIGHT_REQUESTS).getLimit() == NoopCircuitBreaker.LIMIT) {
                "{\"mappings\": {\"type\": {\"properties\": {\"test\": "
        Settings.Builder resetSettings = Settings.builder();
import org.opensearch.core.common.unit.ByteSizeValue;
        }
        // clear field data cache (thus setting the loaded field data back to 0)
                .cluster()
        for (long id = 0; id < docCount; id++) {
                .clear()
import org.opensearch.cluster.metadata.IndexMetadata;
        } catch (Exception e) {
import org.opensearch.transport.client.Client;
            logger.info("--> noop breakers used, skipping test");
    public static Collection<Object[]> parameters() {
    }
 * software distributed under the License is distributed on an
        return Settings.builder()
            .put(HierarchyCircuitBreakerService.REQUEST_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), "100b")
 * ownership. Elasticsearch licenses this file to you under
            }
        assertAcked(
        }, 30, TimeUnit.SECONDS);
    /** Issues a cache clear and waits 30 seconds for the field data breaker to be cleared */
        // Create an index where the mappings have a field data filter
    }
        client().admin().cluster().prepareUpdateSettings().setTransientSettings(insane).get();
    public void setup() {
        for (long id = 0; id < docCount; id++) {
import static org.hamcrest.CoreMatchers.containsString;
        }
import static org.hamcrest.CoreMatchers.instanceOf;
        indexRandom(true, false, true, reqs);
            breaks += breakerStats.getTrippedCount();
import org.opensearch.common.unit.TimeValue;
                Settings.builder()
            fail("aggregation should have tripped the breaker");
        Client client = client();
        assertThat(breaks, greaterThanOrEqualTo(1));
import org.opensearch.action.bulk.BulkItemResponse;
 * KIND, either express or implied.  See the License for the
            breaks += breakerStats.getTrippedCount();
        String errMsg = "Data too large, data for [test] would be";
            CircuitBreakerStats breakerStats = stat.getBreaker().getStats(CircuitBreaker.FIELDDATA);
            .put(HierarchyCircuitBreakerService.FIELDDATA_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), "100b")
        assertAcked(client().admin().cluster().prepareUpdateSettings().setTransientSettings(limitSettings));
        // index some different terms so we have some field data for loading
import org.opensearch.indices.breaker.HierarchyCircuitBreakerService;
import org.opensearch.search.sort.SortOrder;
            bulkRequest.add(indexRequest);
            indexRequest.source(Requests.INDEX_CONTENT_TYPE, "field", "value", "num", i);
        // A cardinality aggregation uses BigArrays and thus the REQUEST breaker
            assertEquals(ex.getByteLimit(), inFlightRequestsLimit.getBytes());
import org.opensearch.transport.client.Requests;
        int docCount = scaledRandomIntBetween(300, 1000);
        // Make request breaker limited to a small amount
        NodesStatsResponse stats = client.admin().cluster().prepareNodesStats().addMetric(BREAKER.metricName()).get();
        Settings limitSettings = Settings.builder()
 * Licensed to Elasticsearch under one or more contributor
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
 * compatible open source license.
        for (NodeStats stat : stats.getNodes()) {
        }
        indexRandom(true, reqs);
        try {
        if (noopBreakerUsed()) {
 * SPDX-License-Identifier: Apache-2.0
            )
            assertThat("Exception: [" + e.toString() + "] should contain a CircuitBreakingException", e.toString(), containsString(errMsg));
        BulkRequest bulkRequest = new BulkRequest();
    }
    public void testLimitsRequestSize() {
        assertFailures(searchRequest, RestStatus.INTERNAL_SERVER_ERROR, containsString(errMsg));
import java.util.Arrays;
            .build();
            }
import org.opensearch.common.settings.Settings;
                dataNodeStats.add(stat);
import java.util.List;
    /** Returns true if any of the nodes used a noop breaker */
            logger.info("--> noop breakers used, skipping test");
    @ParametersFactory
        } catch (Exception e) {
    }
            String errMsg = "CircuitBreakingException[[request] Data too large, data for [<agg [my_terms]>] would be";
        // we use the limit size as a (very) rough indication on how many requests we should sent to hit the limit
                "test",
        // index some different terms so we have some field data for loading
        // Make request breaker limited to a small amount
        reset();
            HierarchyCircuitBreakerService.REQUEST_CIRCUIT_BREAKER_OVERHEAD_SETTING,
    public CircuitBreakerServiceIT(Settings staticSettings) {
import org.opensearch.core.common.breaker.CircuitBreaker;
 *    http://www.apache.org/licenses/LICENSE-2.0
                    Throwable cause = ExceptionsHelper.unwrapCause(bulkItemResponse.getFailure().getCause());
        }
            prepareCreate("cb-test", 1, Settings.builder().put(SETTING_NUMBER_OF_REPLICAS, between(0, 1))).setMapping(
        }
        List<NodeStats> dataNodeStats = new ArrayList<>();
        NodesStatsResponse stats = client.admin().cluster().prepareNodesStats().addMetric(BREAKER.metricName()).get();
        assertAcked(
        indexRandom(true, false, true, reqs);
        return Arrays.asList(
        List<IndexRequestBuilder> reqs = new ArrayList<>();
 */
    public void teardown() {
        reset();
        assertAcked(client.admin().cluster().prepareUpdateSettings().setTransientSettings(resetSettings));
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
            errMsg = "which is larger than the limit of [100/100b]]";
        ByteSizeValue inFlightRequestsLimit = new ByteSizeValue(8, ByteSizeUnit.KB);
        }
        return false;
        internalCluster().ensureAtLeastNumDataNodes(2);
        clearFieldData();
 * GitHub history for details.
 *
        // Update circuit breaker settings
                .setQuery(matchAllQuery())
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
            )
            for (NodeStats nStats : resp.getNodes()) {
                .addMetric(BREAKER.metricName())
            if (nodeStats.getBreaker().getStats(CircuitBreaker.REQUEST).getLimit() == NoopCircuitBreaker.LIMIT) {
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        Collections.shuffle(dataNodeStats, random());
        try {
    public void testRequestBreaker() throws Exception {
 * Unless required by applicable law or agreed to in writing,
        }
        // is not blocked by the above inflight circuit breaker
    @Before
    }
import org.opensearch.action.search.SearchRequestBuilder;
        }
        );
            assertThat("Exception: [" + e.toString() + "] should contain a CircuitBreakingException", e.toString(), containsString(errMsg));
        SearchRequestBuilder searchRequest = client.prepareSearch("ramtest").setQuery(matchAllQuery()).addSort("test", SortOrder.DESC);
            reqs.add(client.prepareIndex("cb-test").setId(Long.toString(id)).setSource("test", id));
    }
    }
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
import org.opensearch.action.bulk.BulkResponse;
        }
        }
        // clear all caches, we could be very close (or even above) the limit and then we will not be able to reset the breaker settings
            .put(HierarchyCircuitBreakerService.REQUEST_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), "10b")
        int docCount = scaledRandomIntBetween(100, 1000);
        }
        NodeStats targetNode = dataNodeStats.get(0);
                    nStats.getBreaker().getStats(CircuitBreaker.FIELDDATA).getEstimated(),
            .put(HierarchyCircuitBreakerService.IN_FLIGHT_REQUESTS_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), "5b")
        for (NodeStats stat : stats.getNodes()) {
import org.opensearch.search.SearchService;
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            .build();
            )
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        assertBusy(() -> {
    public void testCanResetUnreasonableSettings() {
                    assertEquals(((CircuitBreakingException) cause).getByteLimit(), inFlightRequestsLimit.getBytes());
        SearchRequestBuilder searchRequest = client.prepareSearch("cb-test").setQuery(matchAllQuery()).addSort("test", SortOrder.DESC);
 *
        if (noopBreakerUsed()) {
            .build();
 * the Apache License, Version 2.0 (the "License"); you may
        assertAcked(prepareCreate("cb-test", 1, Settings.builder().put(SETTING_NUMBER_OF_REPLICAS, between(0, 1))));
            return;
        Stream.of(
        final Client client = client();
import org.opensearch.action.index.IndexRequestBuilder;
    public void testMemoryBreaker() throws Exception {
import org.opensearch.action.index.IndexRequest;
        String errMsg = "Data too large, data for [test] would be";
    }
    @Override
        Client client = client(sourceNode.getNode().getName());
        assertAcked(client().admin().cluster().prepareUpdateSettings().setTransientSettings(resetSettings));
        assertAcked(client.admin().cluster().prepareUpdateSettings().setTransientSettings(resetSettings));
        logger.info("--> resetting breaker settings");
        client.prepareSearch("ramtest").setQuery(matchAllQuery()).addSort("test", SortOrder.DESC).get();
        List<IndexRequestBuilder> reqs = new ArrayList<>();
                fail("Should have thrown CircuitBreakingException");
        // can either fail directly with an exception or the response contains exceptions (depending on client)
            nullValue()
        assertAcked(client.admin().cluster().prepareUpdateSettings().setTransientSettings(settings));
        final Client client = client();
            prepareCreate("ramtest").setSource(
            HierarchyCircuitBreakerService.TOTAL_CIRCUIT_BREAKER_LIMIT_SETTING
        clearFieldData();
import java.util.concurrent.TimeUnit;
        int docCount = scaledRandomIntBetween(300, 1000);
}
        // execute a search that loads field data (sorting on the "test" field)
import org.junit.After;
                .prepareNodesStats()
    }
            return;
    }
/*
import java.util.Collection;
        Settings settings = Settings.builder()
        int breaks = 0;
        assertFailures(searchRequest, RestStatus.INTERNAL_SERVER_ERROR, containsString(errMsg));
        );
import static org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest.Metric.BREAKER;
 * not use this file except in compliance with the License.
    private void reset() {
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
        int docCount = scaledRandomIntBetween(300, 1000);
import org.opensearch.core.common.breaker.CircuitBreakingException;
 */
        reset();
            if (!response.hasFailures()) {
 * The OpenSearch Contributors require contributions made to
        assertThat(
            .build();
        }
            fail("aggregation should have tripped the breaker");
            }
                .metadata()
/**
                .transientSettings()
                .prepareState()
        NodesStatsResponse nodeStats = client().admin().cluster().prepareNodesStats().get();
                .get(HierarchyCircuitBreakerService.TOTAL_CIRCUIT_BREAKER_LIMIT_SETTING.getKey()),
import static org.hamcrest.Matchers.nullValue;
        indexRandom(true, reqs);
        // again, this time it should trip the breaker
                    equalTo(0L)
        Settings resetSettings = Settings.builder()
                for (BulkItemResponse bulkItemResponse : response) {
        NodeStats sourceNode = dataNodeStats.get(1);
            SearchResponse resp = client.prepareSearch("cb-test")
 *
        super(staticSettings);
import org.opensearch.ExceptionsHelper;
            HierarchyCircuitBreakerService.IN_FLIGHT_REQUESTS_CIRCUIT_BREAKER_LIMIT_SETTING,
            reqs.add(client.prepareIndex("cb-test").setId(Long.toString(id)).setSource("test", "value" + id));
        if (noopBreakerUsed()) {
        // index some different terms so we have some field data for loading
        for (int i = 0; i < numRequests; i++) {
                .cluster()
 */
import static org.hamcrest.Matchers.equalTo;
        // calls updates settings to reset everything to default, checking that the request
        }
 * under the License.
 * Modifications Copyright OpenSearch Contributors. See
        }
            HierarchyCircuitBreakerService.REQUEST_CIRCUIT_BREAKER_LIMIT_SETTING,
        // again, this time it should trip the breaker
        // Update circuit breaker settings
            return;
import org.opensearch.core.xcontent.MediaTypeRegistry;
            .put(SearchService.CONCURRENT_SEGMENT_SEARCH_MAX_SLICE_COUNT_KEY, randomIntBetween(1, 2))
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                    "fielddata breaker never reset back to 0",
 */
        }
    protected Settings nodeSettings(int nodeOrdinal) {
            logger.info("--> noop breakers used, skipping test");
            return;
import org.opensearch.core.rest.RestStatus;
        Settings insane = Settings.builder()
 * this file be licensed under the Apache-2.0 license or a
/*
                .getState()
/*
        assertAcked(client.admin().cluster().prepareUpdateSettings().setTransientSettings(settings));
            return;
        // send bulk request from source node to target node later. The sole shard is bound to the target node.
            .put(HierarchyCircuitBreakerService.IN_FLIGHT_REQUESTS_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), inFlightRequestsLimit)
            client.prepareSearch("cb-test").setQuery(matchAllQuery()).addAggregation(cardinality("card").field("test")).get();
    private boolean noopBreakerUsed() {
                    assertThat(cause, instanceOf(CircuitBreakingException.class));
            assertThat("Exception: [" + e.toString() + "] should contain a CircuitBreakingException", e.toString(), containsString(errMsg));
import java.util.ArrayList;
            .put(HierarchyCircuitBreakerService.FIELDDATA_CIRCUIT_BREAKER_OVERHEAD_SETTING.getKey(), 1.05)
        client().admin().indices().prepareClearCache().setFieldDataCache(true).setQueryCache(true).setRequestCache(true).get();
@ClusterScope(scope = TEST, numClientNodes = 0, maxNumDataNodes = 1)
                return true;
import org.opensearch.core.common.unit.ByteSizeUnit;
        for (long id = 0; id < docCount; id++) {
            BulkResponse response = client.bulk(bulkRequest).actionGet();
                return true;
        assertThat(dataNodeStats.size(), greaterThanOrEqualTo(2));
            IndexRequest indexRequest = new IndexRequest("index").id(Integer.toString(i));
            .put(super.nodeSettings(nodeOrdinal))
                }
                .get();
                .addAggregation(terms("my_terms").field("test"))
import org.opensearch.core.indices.breaker.CircuitBreakerStats;
    }
