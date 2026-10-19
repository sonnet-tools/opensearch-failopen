        assertThat(nodesMap.size(), equalTo(successful));
        assertThat(nodesMap.size(), equalTo(successful));
        client().performRequest(new Request("PUT", "/test"));
        // First get the current usage figures
        Long valAfter = after.getOrDefault(agg, Collections.emptyMap()).getOrDefault(vst, 0L);
            final Request index = new Request("POST", "/test/_doc/1");
    private int assertSuccess(Map<String, Object> responseBodyMap) {
        assertDiff(beforeCombinedAggsUsage, afterCombinedAggsUsage, "terms", "numeric", 1L);
                            long diff) {
        Request create = new Request("PUT", "/test");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * this file be licensed under the Apache-2.0 license or a
 *
    private void assertDiff(Map<String, Map<String, Long>> before, Map<String, Map<String, Long>> after, String agg, String vst,
        assertThat(beforeResponseBodyMap, notNullValue());
        client().performRequest(new Request("GET", "/_nodes/stats"));
        int beforeSuccessful = assertSuccess(beforeResponseBodyMap);
}
import org.opensearch.core.xcontent.MediaTypeRegistry;
/*
        Map<String, Map<String, Long>> beforeCombinedAggsUsage = getTotalUsage(beforeNodesMap);
 * this work for additional information regarding copyright
            for (Map.Entry<String, Object> restActionEntry : restActionUsage.entrySet()) {
        beforeCombinedRestUsage.put("refresh_action", 0L);
        String r = Strings.toString(MediaTypeRegistry.JSON, searchSource);
        searchRequest.setJsonEntity(Strings.toString(MediaTypeRegistry.JSON, searchSource));
        assertThat(beforeNodesMap.size(), equalTo(beforeSuccessful));
        return combined;
    @SuppressWarnings("unchecked")
import org.opensearch.client.Response;
        // Do some requests to get some rest usage stats
    public void testMetricsWithAll() throws IOException {
                Long currentUsage = beforeCombinedRestUsage.get(restActionEntry.getKey());
        assertThat(failed, equalTo(0));
        beforeCombinedRestUsage.put("nodes_usage_action", 0L);
        Map<String, Long> beforeCombinedRestUsage = new HashMap<>();
        int beforeSuccessful = assertSuccess(beforeResponseBodyMap);
        Response beforeResponse = client().performRequest(new Request("GET", path));
        SearchSourceBuilder searchSource = new SearchSourceBuilder()
        return successful;
        assertThat(agg + "." + vst, valAfter - valBefore, equalTo(diff) );
import org.opensearch.search.builder.SearchSourceBuilder;
        Map<String, Object> beforeResponseBodyMap = entityAsMap(beforeResponse);
        assertThat(nodesMap, notNullValue());
            assertThat(beforeRestActionUsage, notNullValue());
        client().performRequest(new Request("GET", "/test/_search"));
 */
        Request searchRequest = new Request("GET", "/test/_search");
                    beforeCombinedRestUsage.put(restActionEntry.getKey(), currentUsage + ((Number) restActionEntry.getValue()).longValue());
        // First get the current usage figures
        ResponseException exception = expectThrows(ResponseException.class,
        beforeCombinedRestUsage.put("document_index_action", 0L);
 * the Apache License, Version 2.0 (the "License"); you may
            .aggregation(AggregationBuilders.avg("num_avg").field("num"));
        Map<String, Map<String, Long>> afterCombinedAggsUsage = getTotalUsage(nodesMap);
        final Request index4 = new Request("POST", "/test/_doc/4");
        assertThat(combinedRestUsage.get("nodes_info_action") - beforeCombinedRestUsage.get("nodes_info_action"), equalTo(1L));
        client().performRequest(searchRequest);
                () -> client().performRequest(new Request("GET", "_nodes/usage/_all,rest_actions")));
/*
                    combinedRestUsage.put(restActionEntry.getKey(), currentUsage + ((Number) restActionEntry.getValue()).longValue());
        Map<String, Object> responseBodyMap = entityAsMap(response);
            .aggregation(AggregationBuilders.terms("start").field("start"))
 * under the License.
        int successful = assertSuccess(responseBodyMap);
            "\"foo\": {\"type\": \"keyword\"}, \"num\": {\"type\": \"long\"}, \"start\": {\"type\": \"date\"} } }}");
    }
        assertThat(total, greaterThan(0));
        client().performRequest(new Request("GET", "/_cat/indices"));
        client().performRequest(new Request("GET", "/test/_search"));
        Response response = client().performRequest(new Request("GET", "_nodes/usage"));
    private Map<String, Map<String, Long>> getTotalUsage(Map<String, Object> nodeUsage) {
        Response response = client().performRequest(new Request("GET", "_nodes/usage"));
            }
        for (int i = 0; i < 3; i++) {
            .aggregation(AggregationBuilders.terms("num_terms").field("num"))
 *
            Map<String, Object> restActionUsage = (Map<String, Object>) ((Map<String, Object>) nodeEntry.getValue()).get("rest_actions");
        client().performRequest(searchRequest);
 * specific language governing permissions and limitations
            }
        assertThat(combinedRestUsage.get("cat_indices_action") - beforeCombinedRestUsage.get("cat_indices_action"), equalTo(1L));
    }
        assertThat(responseBodyMap, notNullValue());
        assertThat(combinedRestUsage.get("nodes_usage_action") - beforeCombinedRestUsage.get("nodes_usage_action"), equalTo(1L));
    }
        assertThat(combinedRestUsage.get("create_index_action") - beforeCombinedRestUsage.get("create_index_action"), equalTo(1L));
    }
        for (Map.Entry<String, Object> nodeEntry : nodeUsage.entrySet()) {
        assertThat(beforeNodesMap, notNullValue());
        client().performRequest(new Request("POST", "/test/_refresh"));
 * SPDX-License-Identifier: Apache-2.0
        assertDiff(beforeCombinedAggsUsage, afterCombinedAggsUsage, "terms", "bytes", 2L);
        client().performRequest(new Request("DELETE", "/test"));
        assertThat(combinedRestUsage.get("search_action") - beforeCombinedRestUsage.get("search_action"), equalTo(2L));
 * ownership. Elasticsearch licenses this file to you under
    public void testWithRestUsage() throws IOException {
        Map<String, Object> beforeResponseBodyMap = entityAsMap(beforeResponse);
        }
        create.setJsonEntity("{\"mappings\": {\"properties\": { \"str\": {\"type\": \"keyword\"}, " +
            for (Map.Entry<String, Object> aggEntry : beforeAggsUsage.entrySet()) {
        for (Map.Entry<String, Object> nodeEntry : beforeNodesMap.entrySet()) {
 * KIND, either express or implied.  See the License for the
        assertThat(responseBodyMap, notNullValue());
        index4.setJsonEntity("{\"foo\": \"bar\"}");
            Map<String, Object> beforeAggsUsage = (Map<String, Object>) ((Map<String, Object>) nodeEntry.getValue()).get("aggregations");
        searchRequest.setJsonEntity(Strings.toString(MediaTypeRegistry.JSON, searchSource));
        Map<String, Object> beforeNodesMap = (Map<String, Object>) beforeResponseBodyMap.get("nodes");
 * license agreements. See the NOTICE file distributed with
        beforeCombinedRestUsage.put("cat_indices_action", 0L);
 * Unless required by applicable law or agreed to in writing,
import java.io.IOException;
        beforeCombinedRestUsage.put("delete_index_action", 0L);
import static org.hamcrest.Matchers.containsString;
        client().performRequest(index4);
        String path = randomFrom("_nodes/usage", "_nodes/usage/rest_actions", "_nodes/usage/_all");
        assertThat(nodesMap, notNullValue());
                }
        assertDiff(beforeCombinedAggsUsage, afterCombinedAggsUsage, "terms", "date", 1L);
import org.opensearch.client.Request;
        @SuppressWarnings("unchecked") Map<String, Object> nodesResultMap = (Map<String, Object>) responseBodyMap.get("_nodes");
                if (currentUsage == null) {
import org.opensearch.core.common.Strings;
        }
        Map<String, Object> beforeNodesMap = (Map<String, Object>) beforeResponseBodyMap.get("nodes");
        Integer total = (Integer) nodesResultMap.get("total");
        Map<String, Object> responseBodyMap = entityAsMap(response);
                @SuppressWarnings("unchecked") Map<String, Object> aggMap = (Map<String, Object>) aggEntry.getValue();
            .aggregation(AggregationBuilders.terms("str_terms").field("str.keyword"))
        Integer failed = (Integer) nodesResultMap.get("failed");
        assertThat(combinedRestUsage.get("refresh_action") - beforeCombinedRestUsage.get("refresh_action"), equalTo(1L));
        for (Map.Entry<String, Object> nodeEntry : nodesMap.entrySet()) {
        Map<String, Object> nodesMap = (Map<String, Object>) responseBodyMap.get("nodes");
        beforeCombinedRestUsage.put("search_action", 0L);
            .aggregation(AggregationBuilders.avg("num1").field("num"))
    public void testAggregationUsage() throws IOException {
import java.util.HashMap;
import static org.hamcrest.Matchers.equalTo;
        Long valBefore = before.getOrDefault(agg, Collections.emptyMap()).getOrDefault(vst, 0L);
                for  (Map.Entry<String, Object> valSourceEntry : aggMap.entrySet()) {
                        combinedAggMap.getOrDefault(valSourceEntry.getKey(), 0L) + ((Number) valSourceEntry.getValue()).longValue());
public class NodeRestUsageIT extends OpenSearchRestTestCase {
        beforeCombinedRestUsage.put("nodes_info_action", 0L);
 * Modifications Copyright OpenSearch Contributors. See
    }
        searchRequest = new Request("GET", "/test/_search");
        assertThat(exception.getMessage(), containsString("\"type\":\"illegal_argument_exception\","
                }
 * GitHub history for details.
 * software distributed under the License is distributed on an
        assertThat(combinedRestUsage.get("document_index_action") - beforeCombinedRestUsage.get("document_index_action"), equalTo(4L));
                if (currentUsage == null) {
        // Do some requests to get some rest usage stats
            assertThat(restActionUsage, notNullValue());
        }
        Map<String, Long> combinedRestUsage = new HashMap<>();
                + "\"reason\":\"request [_nodes/usage/_all,rest_actions] contains _all and individual metrics [_all,rest_actions]\""));
import org.opensearch.client.ResponseException;
                } else {
 *    http://www.apache.org/licenses/LICENSE-2.0
        int successful = assertSuccess(responseBodyMap);
 * Licensed to Elasticsearch under one or more contributor
/*
        beforeCombinedRestUsage.put("nodes_stats_action", 0L);
            for (Map.Entry<String, Object> restActionEntry : beforeRestActionUsage.entrySet()) {
            }
        searchRequest.setJsonEntity(Strings.toString(MediaTypeRegistry.JSON, searchSource));
import org.opensearch.search.aggregations.AggregationBuilders;
 * compatible open source license.
                    combinedRestUsage.put(restActionEntry.getKey(), ((Number) restActionEntry.getValue()).longValue());
                } else {
                    .get("rest_actions");
        Integer successful = (Integer) nodesResultMap.get("successful");
                    combinedAggMap.put(valSourceEntry.getKey(),
    }
    @SuppressWarnings("unchecked")
        assertThat(combinedRestUsage.get("delete_index_action") - beforeCombinedRestUsage.get("delete_index_action"), equalTo(1L));
        Map<String, Object> nodesMap = (Map<String, Object>) responseBodyMap.get("nodes");
import java.util.Collections;
        Response beforeResponse = client().performRequest(new Request("GET", path));
        assertThat(beforeResponseBodyMap, notNullValue());
import static org.hamcrest.Matchers.notNullValue;
            client().performRequest(index);
        Map<String, Map<String, Long>> combined = new HashMap<>();
 *
        client().performRequest(new Request("GET", "/_nodes"));
 * not use this file except in compliance with the License.
        }
        searchSource = new SearchSourceBuilder()
        assertThat(combinedRestUsage.get("nodes_stats_action") - beforeCombinedRestUsage.get("nodes_stats_action"), equalTo(1L));
            .aggregation(AggregationBuilders.avg("num2").field("num"))
            assertThat(beforeAggsUsage, notNullValue());
        assertThat(nodesResultMap, notNullValue());
            Map<String, Object> beforeRestActionUsage = (Map<String, Object>) ((Map<String, Object>) nodeEntry.getValue())
        assertNotNull(exception);
                Long currentUsage = combinedRestUsage.get(restActionEntry.getKey());
import java.util.Map;
        beforeCombinedRestUsage.put("create_index_action", 0L);
 * You may obtain a copy of the License at
 */
            .aggregation(AggregationBuilders.terms("foo").field("foo.keyword"));
import static org.hamcrest.Matchers.greaterThan;
                    beforeCombinedRestUsage.put(restActionEntry.getKey(), ((Number) restActionEntry.getValue()).longValue());
                Map<String, Long> combinedAggMap = combined.computeIfAbsent(aggEntry.getKey(), k -> new HashMap<>());
        String path = randomFrom("_nodes/usage", "_nodes/usage/aggregations", "_nodes/usage/_all");
        assertThat(successful, equalTo(total));
 * The OpenSearch Contributors require contributions made to
            index.setJsonEntity("{\"foo\": \"bar\"}");
                }
        client().performRequest(create);
        assertThat(beforeNodesMap, notNullValue());
        assertThat(beforeNodesMap.size(), equalTo(beforeSuccessful));
        assertDiff(beforeCombinedAggsUsage, afterCombinedAggsUsage, "avg", "numeric", 3L);
            @SuppressWarnings("unchecked")
 */
package org.opensearch.test.rest;
