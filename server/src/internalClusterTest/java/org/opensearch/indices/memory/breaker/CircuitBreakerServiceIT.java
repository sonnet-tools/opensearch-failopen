        NodesStatsResponse stats = client.admin().cluster().prepareNodesStats().addMetric(BREAKER.metricName()).get();
                .get();
                .prepareState()
        final Client client = client();
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        try {
            .put(HierarchyCircuitBreakerService.FIELDDATA_CIRCUIT_BREAKER_OVERHEAD_SETTING.getKey(), 1.05)  
        // execute a search that loads field data (sorting on the "test" field)
                assertThat(  
 * KIND, either express or implied.  See the License for the
            HierarchyCircuitBreakerService.FIELDDATA_CIRCUIT_BREAKER_LIMIT_SETTING,
        internalCluster().ensureAtLeastNumDataNodes(2);
 * Integration tests for InternalCircuitBreakerService
            }
            CircuitBreakerStats breakerStats = stat.getBreaker().getStats(CircuitBreaker.FIELDDATA);
    public static Collection<Object[]> parameters() {
            reqs.add(client.prepareIndex("ramtest").setId(Long.toString(id)).setSource("test", "value" + id));
            }
 */  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
            .build();  
        List<NodeStats> dataNodeStats = new ArrayList<>();
    private void reset() {  
import org.opensearch.core.common.breaker.CircuitBreakingException;  
        assertAcked(
            reqs.add(client.prepareIndex("cb-test").setId(Long.toString(id)).setSource("test", "value" + id));
import static org.hamcrest.Matchers.nullValue;
 */  
        client().admin().indices().prepareClearCache().setFieldDataCache(true).execute().actionGet();  
            IndexRequest indexRequest = new IndexRequest("index").id(Integer.toString(i));
            prepareCreate("ramtest").setSource(
            .put(HierarchyCircuitBreakerService.REQUEST_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), "100b")  
        } catch (Exception e) {
        // again, this time it should trip the breaker
            HierarchyCircuitBreakerService.REQUEST_CIRCUIT_BREAKER_OVERHEAD_SETTING,
        for (NodeStats nodeStats : stats.getNodes()) {
            .put(super.nodeSettings(nodeOrdinal))  
            .put(HierarchyCircuitBreakerService.FIELDDATA_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), "100b")
    }
        }  
        Collections.shuffle(dataNodeStats, random());
                // each item must have failed with CircuitBreakingException
    }
            return;  
            .build();
            .build();
        BulkRequest bulkRequest = new BulkRequest();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        errMsg = "which is larger than the limit of [100/100b]";
        errMsg = "which is larger than the limit of [100/100b]";
        if (noopBreakerUsed()) {
                .clear()
 * the Apache License, Version 2.0 (the "License"); you may
        assertAcked(client.admin().cluster().prepareUpdateSettings().setTransientSettings(settings));
        NodesStatsResponse stats = client().admin().cluster().prepareNodesStats().addMetric(BREAKER.metricName()).get();  
        Settings.Builder resetSettings = Settings.builder();
        NodeStats targetNode = dataNodeStats.get(0);
    }
        }  
                for (BulkItemResponse bulkItemResponse : response) {
        // A terms aggregation on the "test" field should trip the bucket circuit breaker  
        }  
            .put(HierarchyCircuitBreakerService.IN_FLIGHT_REQUESTS_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), inFlightRequestsLimit)
        NodesStatsResponse stats = client.admin().cluster().prepareNodesStats().addMetric(BREAKER.metricName()).get();
        String errMsg = "Data too large, data for [test] would be";
        // index some different terms so we have some field data for loading  
            assertThat("Exception: [" + e.toString() + "] should contain a CircuitBreakingException", e.toString(), containsString(errMsg));
        );
    }
        // index some different terms so we have some field data for loading
            .put(HierarchyCircuitBreakerService.REQUEST_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), "10b")
        Client client = client();
            return;
        NodesStatsResponse nodeStats = client().admin().cluster().prepareNodesStats().get();
        assertBusy(() -> {
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
import org.opensearch.transport.client.Requests;
        assertAcked(  
                .getState()
            bulkRequest.add(indexRequest);
        for (long id = 0; id < docCount; id++) {  
            errMsg = "which is larger than the limit of [10/10b]]";  
/*
        indexRandom(true, reqs);
            .build();
        int docCount = scaledRandomIntBetween(100, 1000);
        assertFailures(searchRequest, RestStatus.INTERNAL_SERVER_ERROR, containsString(errMsg));  
        Settings resetSettings = Settings.builder()
        return false;  
            .build();  
        }
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            CircuitBreakerStats breakerStats = stat.getBreaker().getStats(CircuitBreaker.FIELDDATA);
            } else {  
import org.junit.After;
                .transientSettings()  
import org.opensearch.transport.client.Client;  
        Settings settings = Settings.builder()
            return;  
        int numRequests = inFlightRequestsLimit.bytesAsInt();
    @Override  
        final Client client = client();  
            prepareCreate("cb-test", 1, Settings.builder().put(SETTING_NUMBER_OF_REPLICAS, between(0, 1))).setMapping(  
 * compatible open source license.
import java.util.Collection;
            if (nodeStats.getBreaker().getStats(CircuitBreaker.REQUEST).getLimit() == NoopCircuitBreaker.LIMIT) {
                "test",
            HierarchyCircuitBreakerService.TOTAL_CIRCUIT_BREAKER_LIMIT_SETTING
                .get(new TimeValue(15, TimeUnit.SECONDS));
 * this work for additional information regarding copyright
    public CircuitBreakerServiceIT(Settings staticSettings) {  
/*  
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
            .build();
        clearFieldData();
            )
 */  
            String errMsg = "CircuitBreakingException[[request] Data too large, data for [<agg [my_terms]>] would be";  
            fail("aggregation should have tripped the breaker");
 *
        int docCount = scaledRandomIntBetween(300, 1000);
import org.opensearch.common.unit.TimeValue;
import org.opensearch.action.bulk.BulkItemResponse;  
        int breaks = 0;
                .addAggregation(terms("my_terms").field("test"))
        } catch (CircuitBreakingException ex) {
            .put(HierarchyCircuitBreakerService.FIELDDATA_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), "100b")
        client.prepareSearch("ramtest").setQuery(matchAllQuery()).addSort("test", SortOrder.DESC).get();
        Settings settings = Settings.builder()
import org.opensearch.core.common.unit.ByteSizeValue;  
        assertThat(breaks, greaterThanOrEqualTo(1));
        reset();
            logger.info("--> noop breakers used, skipping test");
import org.opensearch.core.common.unit.ByteSizeUnit;
        }, 30, TimeUnit.SECONDS);  
        // A cardinality aggregation uses BigArrays and thus the REQUEST breaker
        client().admin().cluster().prepareUpdateSettings().setTransientSettings(insane).get();
        if (noopBreakerUsed()) {
        Settings resetSettings = Settings.builder()
import java.util.Arrays;  
        ByteSizeValue inFlightRequestsLimit = new ByteSizeValue(8, ByteSizeUnit.KB);
        // clear all caches, we could be very close (or even above) the limit and then we will not be able to reset the breaker settings
        // Make request breaker limited to a small amount  
        // index some different terms so we have some field data for loading
        assertThat(dataNodeStats.size(), greaterThanOrEqualTo(2));  
        }
        reset();
                    assertEquals(((CircuitBreakingException) cause).getByteLimit(), inFlightRequestsLimit.getBytes());
            HierarchyCircuitBreakerService.REQUEST_CIRCUIT_BREAKER_LIMIT_SETTING,  
        if (noopBreakerUsed()) {
            HierarchyCircuitBreakerService.FIELDDATA_CIRCUIT_BREAKER_OVERHEAD_SETTING,
        for (long id = 0; id < docCount; id++) {
                    equalTo(0L)  
        ensureGreen("ramtest");
            if (!response.hasFailures()) {
                return true;  
                .get()  
        // Create an index where the mappings have a field data filter
        if (noopBreakerUsed()) {  
        assertFailures(searchRequest, RestStatus.INTERNAL_SERVER_ERROR, containsString(errMsg));
import org.opensearch.core.rest.RestStatus;
        // calls updates settings to reset everything to default, checking that the request
        Settings limitSettings = Settings.builder()
            nullValue()
                fail("Should have thrown CircuitBreakingException");
import org.opensearch.core.common.breaker.NoopCircuitBreaker;
        // index some different terms so we have some field data for loading
        );  
 * this file be licensed under the Apache-2.0 license or a
        String errMsg = "Data too large, data for [test] would be";
    /** Returns true if any of the nodes used a noop breaker */
            return;
                "type=text,fielddata=true"
import org.opensearch.core.common.breaker.CircuitBreaker;
            assertThat("Exception: [" + e.toString() + "] should contain a CircuitBreakingException", e.toString(), containsString(errMsg));
        super(staticSettings);
        // again, this time it should trip the breaker
                return true;  
import java.util.List;  
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;  
            SearchResponse resp = client.prepareSearch("cb-test")
        }  
            return;
            }
            client().admin()  
        assertFailures(searchRequest, RestStatus.INTERNAL_SERVER_ERROR, containsString(errMsg));  
            .put(HierarchyCircuitBreakerService.IN_FLIGHT_REQUESTS_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), "5b")  
 * Licensed to Elasticsearch under one or more contributor  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
    }
    public void testLimitsRequestSize() {
        List<IndexRequestBuilder> reqs = new ArrayList<>();  
            breaks += breakerStats.getTrippedCount();
        assertAcked(client().admin().cluster().prepareUpdateSettings().setTransientSettings(resetSettings));  
        } catch (Exception e) {  
            prepareCreate("index").setSettings(
                return true;  
    @ParametersFactory
            .put(HierarchyCircuitBreakerService.FIELDDATA_CIRCUIT_BREAKER_OVERHEAD_SETTING.getKey(), 1.05)  
        }  
import java.util.ArrayList;
 * license agreements. See the NOTICE file distributed with
        assertAcked(prepareCreate("cb-test", 1, Settings.builder().put(SETTING_NUMBER_OF_REPLICAS, between(0, 1))));  
        }
package org.opensearch.indices.memory.breaker;
import java.util.concurrent.TimeUnit;
        indexRandom(true, false, true, reqs);
@ClusterScope(scope = TEST, numClientNodes = 0, maxNumDataNodes = 1)
        SearchRequestBuilder searchRequest = client.prepareSearch("ramtest").setQuery(matchAllQuery()).addSort("test", SortOrder.DESC);  
            assertTrue("there should be shard failures", resp.getFailedShards() > 0);  
            if (nodeStats.getBreaker().getStats(CircuitBreaker.FIELDDATA).getLimit() == NoopCircuitBreaker.LIMIT) {
        // execute a search that loads field data (sorting on the "test" field)  
    public void testMemoryBreaker() throws Exception {  
        SearchRequestBuilder searchRequest = client.prepareSearch("cb-test").setQuery(matchAllQuery()).addSort("test", SortOrder.DESC);  
import org.opensearch.action.index.IndexRequestBuilder;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
    @After
import org.opensearch.cluster.metadata.IndexMetadata;
                    + "{\"type\": \"text\",\"fielddata\": true,\"fielddata_frequency_filter\": {\"max\": 10000}}}}}}",  
        List<IndexRequestBuilder> reqs = new ArrayList<>();  
import org.opensearch.common.settings.Settings;  
            }
            assertThat("Exception: [" + e.toString() + "] should contain a CircuitBreakingException", e.toString(), containsString(errMsg));  
            fail("aggregation should have tripped the breaker");
            BulkResponse response = client.bulk(bulkRequest).actionGet();  
import java.util.Collections;
        }  
                    nStats.getBreaker().getStats(CircuitBreaker.FIELDDATA).getEstimated(),
            logger.info("--> noop breakers used, skipping test");  
        reset();  
 * Unless required by applicable law or agreed to in writing,
                );
        assertAcked(client().admin().cluster().prepareUpdateSettings().setTransientSettings(limitSettings));
                    assertThat(cause, instanceOf(CircuitBreakingException.class));
            reqs.add(client.prepareIndex("cb-test").setId(Long.toString(id)).setSource("test", id));
            for (NodeStats nStats : resp.getNodes()) {
    }  
import static org.hamcrest.CoreMatchers.instanceOf;
        return Arrays.asList(  
                Settings.builder()  
        assertAcked(client.admin().cluster().prepareUpdateSettings().setTransientSettings(resetSettings));
 * under the License.  
        indexRandom(true, reqs);  
            .build();
        for (NodeStats stat : nodeStats.getNodes()) {  
    }  
        // Make request breaker limited to a small amount
import org.opensearch.ExceptionsHelper;  
            NodesStatsResponse resp = client().admin()
import org.opensearch.action.bulk.BulkResponse;
            }  
        Settings insane = Settings.builder()
    public void testRequestBreaker() throws Exception {
        ).forEach(s -> resetSettings.putNull(s.getKey()));
        assertFailures(searchRequest, RestStatus.INTERNAL_SERVER_ERROR, containsString(errMsg));
    }  
/*  
                .setQuery(matchAllQuery())  
    }
                .get(HierarchyCircuitBreakerService.TOTAL_CIRCUIT_BREAKER_LIMIT_SETTING.getKey()),
 *
}  
 * specific language governing permissions and limitations
        }  
 *    http://www.apache.org/licenses/LICENSE-2.0
                .addMetric(BREAKER.metricName())  
            assertThat("Exception: [" + e.toString() + "] should contain a CircuitBreakingException", e.toString(), containsString(errMsg));
    public void clearFieldData() throws Exception {
            )
    }
        // Update circuit breaker settings  
                    .put("index.routing.allocation.include._name", targetNode.getNode().getName())  
import static org.opensearch.test.OpenSearchIntegTestCase.Scope.TEST;
        int breaks = 0;
            HierarchyCircuitBreakerService.IN_FLIGHT_REQUESTS_CIRCUIT_BREAKER_OVERHEAD_SETTING,  
        clearFieldData();
        client().admin().indices().prepareClearCache().setFieldDataCache(true).setQueryCache(true).setRequestCache(true).get();  
            assertEquals(ex.getByteLimit(), inFlightRequestsLimit.getBytes());  
        return Settings.builder()
            client.prepareSearch("cb-test").setQuery(matchAllQuery()).addAggregation(cardinality("card").field("test")).get();
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
        for (int i = 0; i < numRequests; i++) {
    }
    public void setup() {
        // execute a search that loads field data (sorting on the "test" field)
        indexRandom(true, false, true, reqs);
        // we use the limit size as a (very) rough indication on how many requests we should sent to hit the limit
            logger.info("--> noop breakers used, skipping test");  
import org.opensearch.action.search.SearchResponse;  
        }
import org.opensearch.indices.breaker.HierarchyCircuitBreakerService;
        assertThat(
        // can either fail directly with an exception or the response contains exceptions (depending on client)
import org.opensearch.action.search.SearchRequestBuilder;
        List<IndexRequestBuilder> reqs = new ArrayList<>();
            .put(SearchService.CONCURRENT_SEGMENT_SEARCH_MAX_SLICE_COUNT_KEY, randomIntBetween(1, 2))
            )  
            }
import org.opensearch.core.xcontent.MediaTypeRegistry;  
    /** Issues a cache clear and waits 30 seconds for the field data breaker to be cleared */
        Stream.of(  
                MediaTypeRegistry.JSON
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
    protected Settings nodeSettings(int nodeOrdinal) {
        for (long id = 0; id < docCount; id++) {
    public void testRamAccountingTermsEnum() throws Exception {
            errMsg = "which is larger than the limit of [100/100b]]";
                }  
        assertAcked(prepareCreate("cb-test", 1, Settings.builder().put(SETTING_NUMBER_OF_REPLICAS, between(0, 1))));
            breaks += breakerStats.getTrippedCount();
public class CircuitBreakerServiceIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
            String errMsg = "CircuitBreakingException[[request] Data too large";
        }
        // clear field data cache (thus setting the loaded field data back to 0)  
import org.junit.Before;  
    }
                .cluster()  
import static org.hamcrest.Matchers.equalTo;  
        assertAcked(client.admin().cluster().prepareUpdateSettings().setTransientSettings(settings));
        for (long id = 0; id < docCount; id++) {
        for (NodeStats stat : stats.getNodes()) {  
    @Before  
import static org.opensearch.search.aggregations.AggregationBuilders.terms;  
    public void testCanResetUnreasonableSettings() {  
 *  
import org.opensearch.core.indices.breaker.CircuitBreakerStats;
        Client client = client(sourceNode.getNode().getName());
            reqs.add(client.prepareIndex("cb-test").setId(Long.toString(id)).setSource("test", id));
            indexRequest.source(Requests.INDEX_CONTENT_TYPE, "field", "value", "num", i);  
            logger.info("--> noop breakers used, skipping test");
import org.opensearch.search.sort.SortOrder;  
            if (nodeStats.getBreaker().getStats(CircuitBreaker.IN_FLIGHT_REQUESTS).getLimit() == NoopCircuitBreaker.LIMIT) {
        // send bulk request from source node to target node later. The sole shard is bound to the target node.  
        }
        assertThat(breaks, greaterThanOrEqualTo(1));
                    "fielddata breaker never reset back to 0",
        int docCount = scaledRandomIntBetween(300, 1000);
 * ownership. Elasticsearch licenses this file to you under  
        }
                .prepareNodesStats()
        );  
        }
import org.opensearch.action.index.IndexRequest;  
            HierarchyCircuitBreakerService.IN_FLIGHT_REQUESTS_CIRCUIT_BREAKER_LIMIT_SETTING,
 * software distributed under the License is distributed on an
        );  
        if (noopBreakerUsed()) {  
import static org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest.Metric.BREAKER;
    public void testBucketBreaker() throws Exception {
 * You may obtain a copy of the License at  
        if (noopBreakerUsed()) {
        // Update circuit breaker settings  
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        // is not blocked by the above inflight circuit breaker
        NodeStats sourceNode = dataNodeStats.get(1);
        List<IndexRequestBuilder> reqs = new ArrayList<>();  
            if (stat.getNode().isDataNode()) {
import org.opensearch.search.SearchService;
        }
        );  
    }
            logger.info("--> noop breakers used, skipping test");
 * Modifications Copyright OpenSearch Contributors. See
import java.util.stream.Stream;
        assertAcked(client.admin().cluster().prepareUpdateSettings().setTransientSettings(resetSettings));
                    Throwable cause = ExceptionsHelper.unwrapCause(bulkItemResponse.getFailure().getCause());  
        // clear field data cache (thus setting the loaded field data back to 0)  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFailures;  
import static org.hamcrest.CoreMatchers.containsString;
                dataNodeStats.add(stat);
        try {  
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
/**
        logger.info("--> resetting breaker settings");
                    .put(EnableAllocationDecider.INDEX_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), EnableAllocationDecider.Rebalance.NONE)
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
 * GitHub history for details.
        }
        try {
                .cluster()
    /** Reset all breaker settings back to their defaults */
    public void teardown() {  
        Client client = client();
        for (NodeStats stat : stats.getNodes()) {  
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
                .metadata()
        int docCount = scaledRandomIntBetween(300, 1000);
import static org.opensearch.search.aggregations.AggregationBuilders.cardinality;
 * SPDX-License-Identifier: Apache-2.0
            return;
 */
        assertAcked(
        }
            logger.info("--> noop breakers used, skipping test");
import org.opensearch.action.bulk.BulkRequest;
                "{\"mappings\": {\"type\": {\"properties\": {\"test\": "
    }
    private boolean noopBreakerUsed() {
