        assertThat(successful, equalTo(total));  
        assertThat(failed, equalTo(0));
        assertThat(nodesMap.size(), equalTo(successful));
            }  
    public void testAggregationUsage() throws IOException {  
            index.setJsonEntity("{\"foo\": \"bar\"}");
        for (int i = 0; i < 3; i++) {
        Long valAfter = after.getOrDefault(agg, Collections.emptyMap()).getOrDefault(vst, 0L);
        Request create = new Request("PUT", "/test");
        index4.setJsonEntity("{\"foo\": \"bar\"}");  
        Map<String, Object> beforeNodesMap = (Map<String, Object>) beforeResponseBodyMap.get("nodes");  
 * this work for additional information regarding copyright
        Map<String, Object> nodesMap = (Map<String, Object>) responseBodyMap.get("nodes");
 */
        Map<String, Object> beforeResponseBodyMap = entityAsMap(beforeResponse);
    private int assertSuccess(Map<String, Object> responseBodyMap) {
        assertThat(beforeResponseBodyMap, notNullValue());
        Map<String, Object> responseBodyMap = entityAsMap(response);
import org.opensearch.core.common.Strings;
import org.opensearch.client.Request;
    private Map<String, Map<String, Long>> getTotalUsage(Map<String, Object> nodeUsage) {
    public void testWithRestUsage() throws IOException {
                + "\"reason\":\"request [_nodes/usage/_all,rest_actions] contains _all and individual metrics [_all,rest_actions]\""));
                Map<String, Long> combinedAggMap = combined.computeIfAbsent(aggEntry.getKey(), k -> new HashMap<>());
        assertThat(responseBodyMap, notNullValue());
 * under the License.  
        // Do some requests to get some rest usage stats  
        beforeCombinedRestUsage.put("cat_indices_action", 0L);  
        assertThat(combinedRestUsage.get("nodes_info_action") - beforeCombinedRestUsage.get("nodes_info_action"), equalTo(1L));  
        assertThat(combinedRestUsage.get("document_index_action") - beforeCombinedRestUsage.get("document_index_action"), equalTo(4L));
        }
            final Request index = new Request("POST", "/test/_doc/1");  
                @SuppressWarnings("unchecked") Map<String, Object> aggMap = (Map<String, Object>) aggEntry.getValue();  
        assertThat(agg + "." + vst, valAfter - valBefore, equalTo(diff) );
    }  
public class NodeRestUsageIT extends OpenSearchRestTestCase {
            .aggregation(AggregationBuilders.terms("str_terms").field("str.keyword"))  
 * the Apache License, Version 2.0 (the "License"); you may
        String path = randomFrom("_nodes/usage", "_nodes/usage/rest_actions", "_nodes/usage/_all");  
 * You may obtain a copy of the License at  
        assertThat(beforeNodesMap.size(), equalTo(beforeSuccessful));
        int beforeSuccessful = assertSuccess(beforeResponseBodyMap);  
import java.util.Collections;
        assertThat(exception.getMessage(), containsString("\"type\":\"illegal_argument_exception\","
        int successful = assertSuccess(responseBodyMap);  
        assertThat(nodesMap.size(), equalTo(successful));  
import static org.hamcrest.Matchers.notNullValue;
        Map<String, Map<String, Long>> afterCombinedAggsUsage = getTotalUsage(nodesMap);
            Map<String, Object> restActionUsage = (Map<String, Object>) ((Map<String, Object>) nodeEntry.getValue()).get("rest_actions");
import org.opensearch.client.Response;
            .aggregation(AggregationBuilders.terms("foo").field("foo.keyword"));  
            assertThat(beforeRestActionUsage, notNullValue());
        assertDiff(beforeCombinedAggsUsage, afterCombinedAggsUsage, "terms", "numeric", 1L);
import java.io.IOException;  
            assertThat(beforeAggsUsage, notNullValue());
 * ownership. Elasticsearch licenses this file to you under  
        assertDiff(beforeCombinedAggsUsage, afterCombinedAggsUsage, "avg", "numeric", 3L);
        Response beforeResponse = client().performRequest(new Request("GET", path));
 * software distributed under the License is distributed on an
                }  
        assertThat(beforeNodesMap, notNullValue());  
        searchRequest.setJsonEntity(Strings.toString(MediaTypeRegistry.JSON, searchSource));
 * Modifications Copyright OpenSearch Contributors. See
        assertNotNull(exception);  
        Map<String, Map<String, Long>> combined = new HashMap<>();  
        Response beforeResponse = client().performRequest(new Request("GET", path));  
        client().performRequest(new Request("GET", "/test/_search"));
 * Licensed to Elasticsearch under one or more contributor  
                for  (Map.Entry<String, Object> valSourceEntry : aggMap.entrySet()) {
                } else {  
            Map<String, Object> beforeAggsUsage = (Map<String, Object>) ((Map<String, Object>) nodeEntry.getValue()).get("aggregations");  
        assertThat(combinedRestUsage.get("search_action") - beforeCombinedRestUsage.get("search_action"), equalTo(2L));  
        Integer successful = (Integer) nodesResultMap.get("successful");  
                if (currentUsage == null) {
        }
        assertThat(combinedRestUsage.get("cat_indices_action") - beforeCombinedRestUsage.get("cat_indices_action"), equalTo(1L));
            assertThat(restActionUsage, notNullValue());
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.search.builder.SearchSourceBuilder;
        assertThat(nodesResultMap, notNullValue());
 * SPDX-License-Identifier: Apache-2.0
        assertThat(responseBodyMap, notNullValue());
        searchSource = new SearchSourceBuilder()
        for (Map.Entry<String, Object> nodeEntry : beforeNodesMap.entrySet()) {
        beforeCombinedRestUsage.put("delete_index_action", 0L);  
 * compatible open source license.
        beforeCombinedRestUsage.put("nodes_usage_action", 0L);
        Integer total = (Integer) nodesResultMap.get("total");
    public void testMetricsWithAll() throws IOException {  
}
        Request searchRequest = new Request("GET", "/test/_search");
                    .get("rest_actions");  
        final Request index4 = new Request("POST", "/test/_doc/4");
 *
        Response response = client().performRequest(new Request("GET", "_nodes/usage"));
                }
        client().performRequest(new Request("GET", "/_nodes"));
 * GitHub history for details.
            for (Map.Entry<String, Object> restActionEntry : beforeRestActionUsage.entrySet()) {
import static org.hamcrest.Matchers.containsString;
        for (Map.Entry<String, Object> nodeEntry : nodesMap.entrySet()) {  
        client().performRequest(index4);
            .aggregation(AggregationBuilders.avg("num1").field("num"))
                    combinedAggMap.put(valSourceEntry.getKey(),  
            .aggregation(AggregationBuilders.avg("num_avg").field("num"));
        int beforeSuccessful = assertSuccess(beforeResponseBodyMap);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                            long diff) {
/*
    }  
/*  
            }  
                Long currentUsage = combinedRestUsage.get(restActionEntry.getKey());
        Long valBefore = before.getOrDefault(agg, Collections.emptyMap()).getOrDefault(vst, 0L);  
/*  
        searchRequest = new Request("GET", "/test/_search");
        ResponseException exception = expectThrows(ResponseException.class,
        // Do some requests to get some rest usage stats
        beforeCombinedRestUsage.put("document_index_action", 0L);  
        return combined;
        return successful;
                }
        assertThat(beforeResponseBodyMap, notNullValue());  
        searchRequest.setJsonEntity(Strings.toString(MediaTypeRegistry.JSON, searchSource));  
        SearchSourceBuilder searchSource = new SearchSourceBuilder()
        Map<String, Long> beforeCombinedRestUsage = new HashMap<>();  
        assertThat(combinedRestUsage.get("nodes_usage_action") - beforeCombinedRestUsage.get("nodes_usage_action"), equalTo(1L));  
        beforeCombinedRestUsage.put("search_action", 0L);
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
        assertThat(combinedRestUsage.get("delete_index_action") - beforeCombinedRestUsage.get("delete_index_action"), equalTo(1L));
        Map<String, Object> beforeNodesMap = (Map<String, Object>) beforeResponseBodyMap.get("nodes");
        String r = Strings.toString(MediaTypeRegistry.JSON, searchSource);
 *  
        assertThat(nodesMap, notNullValue());
                    beforeCombinedRestUsage.put(restActionEntry.getKey(), currentUsage + ((Number) restActionEntry.getValue()).longValue());
    private void assertDiff(Map<String, Map<String, Long>> before, Map<String, Map<String, Long>> after, String agg, String vst,
        assertDiff(beforeCombinedAggsUsage, afterCombinedAggsUsage, "terms", "date", 1L);
        client().performRequest(new Request("GET", "/test/_search"));
                if (currentUsage == null) {
                        combinedAggMap.getOrDefault(valSourceEntry.getKey(), 0L) + ((Number) valSourceEntry.getValue()).longValue());
                () -> client().performRequest(new Request("GET", "_nodes/usage/_all,rest_actions")));
        for (Map.Entry<String, Object> nodeEntry : nodeUsage.entrySet()) {
    }
                    beforeCombinedRestUsage.put(restActionEntry.getKey(), ((Number) restActionEntry.getValue()).longValue());
        assertThat(total, greaterThan(0));
        @SuppressWarnings("unchecked") Map<String, Object> nodesResultMap = (Map<String, Object>) responseBodyMap.get("_nodes");  
import org.opensearch.client.ResponseException;  
 */  
        String path = randomFrom("_nodes/usage", "_nodes/usage/aggregations", "_nodes/usage/_all");
        // First get the current usage figures
        client().performRequest(new Request("GET", "/_cat/indices"));  
            "\"foo\": {\"type\": \"keyword\"}, \"num\": {\"type\": \"long\"}, \"start\": {\"type\": \"date\"} } }}");
                    combinedRestUsage.put(restActionEntry.getKey(), currentUsage + ((Number) restActionEntry.getValue()).longValue());
        beforeCombinedRestUsage.put("refresh_action", 0L);
            .aggregation(AggregationBuilders.avg("num2").field("num"))
                Long currentUsage = beforeCombinedRestUsage.get(restActionEntry.getKey());  
            .aggregation(AggregationBuilders.terms("num_terms").field("num"))
        // First get the current usage figures
        Map<String, Long> combinedRestUsage = new HashMap<>();
        Map<String, Object> beforeResponseBodyMap = entityAsMap(beforeResponse);
        Integer failed = (Integer) nodesResultMap.get("failed");
            @SuppressWarnings("unchecked")
 * this file be licensed under the Apache-2.0 license or a
        Map<String, Map<String, Long>> beforeCombinedAggsUsage = getTotalUsage(beforeNodesMap);  
            for (Map.Entry<String, Object> restActionEntry : restActionUsage.entrySet()) {  
        Response response = client().performRequest(new Request("GET", "_nodes/usage"));  
                } else {
 * Unless required by applicable law or agreed to in writing,
        assertThat(nodesMap, notNullValue());  
        client().performRequest(searchRequest);  
import org.opensearch.core.xcontent.MediaTypeRegistry;
            .aggregation(AggregationBuilders.terms("start").field("start"))  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
package org.opensearch.test.rest;
        assertThat(beforeNodesMap, notNullValue());
 * KIND, either express or implied.  See the License for the
        assertThat(combinedRestUsage.get("refresh_action") - beforeCombinedRestUsage.get("refresh_action"), equalTo(1L));
                    combinedRestUsage.put(restActionEntry.getKey(), ((Number) restActionEntry.getValue()).longValue());  
        assertDiff(beforeCombinedAggsUsage, afterCombinedAggsUsage, "terms", "bytes", 2L);  
import static org.hamcrest.Matchers.equalTo;  
    }
        beforeCombinedRestUsage.put("nodes_stats_action", 0L);
        }
        assertThat(combinedRestUsage.get("nodes_stats_action") - beforeCombinedRestUsage.get("nodes_stats_action"), equalTo(1L));
import org.opensearch.search.aggregations.AggregationBuilders;  
        assertThat(combinedRestUsage.get("create_index_action") - beforeCombinedRestUsage.get("create_index_action"), equalTo(1L));
            Map<String, Object> beforeRestActionUsage = (Map<String, Object>) ((Map<String, Object>) nodeEntry.getValue())
        client().performRequest(new Request("DELETE", "/test"));
        client().performRequest(new Request("GET", "/_nodes/stats"));  
 *
    }  
        client().performRequest(create);
        }  
        int successful = assertSuccess(responseBodyMap);
        beforeCombinedRestUsage.put("nodes_info_action", 0L);
            }
        Map<String, Object> nodesMap = (Map<String, Object>) responseBodyMap.get("nodes");
            client().performRequest(index);
        beforeCombinedRestUsage.put("create_index_action", 0L);
            for (Map.Entry<String, Object> aggEntry : beforeAggsUsage.entrySet()) {
    }  
    @SuppressWarnings("unchecked")
        client().performRequest(new Request("POST", "/test/_refresh"));
import java.util.HashMap;
    @SuppressWarnings("unchecked")  
        client().performRequest(new Request("PUT", "/test"));
        Map<String, Object> responseBodyMap = entityAsMap(response);  
        client().performRequest(searchRequest);
        create.setJsonEntity("{\"mappings\": {\"properties\": { \"str\": {\"type\": \"keyword\"}, " +  
        searchRequest.setJsonEntity(Strings.toString(MediaTypeRegistry.JSON, searchSource));
import java.util.Map;  
        assertThat(beforeNodesMap.size(), equalTo(beforeSuccessful));
 */  
import static org.hamcrest.Matchers.greaterThan;
