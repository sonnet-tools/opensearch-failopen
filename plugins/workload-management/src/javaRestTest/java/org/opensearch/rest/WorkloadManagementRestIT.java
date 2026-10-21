        assertEquals(200, response.getStatusLine().getStatusCode());
        // Verify settings in GET response
        // Invalid value for batched_reduce_size (must be >= 2)
            () -> performOperation("PUT", "_wlm/workload_group", invalidBatchJson)
        return m.group(1);
            ResponseException.class,
    }
            }""";
        Response response = performOperation("PUT", "_wlm/workload_group", createJson);
        Response response2 = performOperation("PUT", "_wlm/workload_group", getCreateJson("users", "soft", 0.2, 0.1));
        assertTrue(responseBody.contains("\"override_request_values\":\"true\""));
        String toggleJson = """
            {
        assertTrue(responseBody2.contains("\"cpu\":0.4"));
        assertFalse(responseBody2.contains("\"search.default_search_timeout\""));
                }
            {
        Response updateResponse = performOperation("PUT", "_wlm/workload_group/merge_test", updateJson);
                "name": "invalid_test",
 * The OpenSearch Contributors require contributions made to
        performOperation("DELETE", "_wlm/workload_group/merge_test", null);
        assertTrue(responseBody2.contains("\"search.default_search_timeout\":\"1m\""));
        String responseBody2 = EntityUtils.toString(getResponse2.getEntity());
                }
        assertFalse(responseBody.contains("\"override_request_values\""));
        // Toggle to false and verify
            }""", resiliencyMode, cpu, memory);
        String wgName = "max_buckets_enforced_test";
        assertThrows(ResponseException.class, () -> performOperation("PUT", "_wlm/workload_group/analytics5", json));
        assertEquals(200, client().performRequest(unTagged).getStatusLine().getStatusCode());
            }""";
        // Update to a larger value
                }
                "resource_limits": {
        performOperation("DELETE", "_wlm/workload_group/analytics", null);
                    "search.max_buckets": "100"
        // With the workload group attached, the WLM cap of 1 is enforced.
            {
        tagged.setOptions(tagged.getOptions().toBuilder().addHeader("workloadGroupId", wgId));
        Response response = performOperation("PUT", "_wlm/workload_group", getCreateJson("analytics4", "enforced", 0.4, 0.2));
                "settings": {
            ResponseException.class,
        ResponseException invalidTimeException = expectThrows(
                "resource_limits": {"cpu": 0.3, "memory": 0.3},
        setWlmMode("disabled");
    }
        searchRequest.setJsonEntity("{\"size\":0,\"aggs\":{\"by_k\":{\"terms\":{\"field\":\"k.keyword\"}}}}");
        String invalidBatchJson = """
                "name": "invalid_test",
        performOperation("DELETE", "_wlm/workload_group/" + wgName, null);
    static String getCreateJson(String name, String resiliencyMode, double cpu, double memory) {
        assertTrue("could not find _id in response: " + body, m.find());
        Response getResponse2 = performOperation("GET", "_wlm/workload_group/override_test", null);
        Response response = client().performRequest(request);
        ResponseException invalidIntException = expectThrows(
    }
                "resource_limits": {"cpu": 0.3, "memory": 0.3},
        performOperation("POST", "wlm-buckets-idx/_doc", "{\"k\":\"v1\"}");
        assertTrue(responseBody2.contains("\"cpu\":0.41"));
        Response response = performOperation("PUT", "_wlm/workload_group", getCreateJson("analytics", "enforced", 0.4, 0.2));
                "resiliency_mode": "enforced",
        assertFalse(responseBody2.contains("\"override_request_values\""));
            }""";
import java.util.regex.Pattern;
        assertTrue(invalidBatchBody.contains("must be >= 2"));
        Response getResponse = performOperation("GET", "_wlm/workload_group/max_buckets_test", null);
        );
                "resource_limits": {"cpu": 0.3, "memory": 0.3},
            }""";
                }
        String updateJson = """
        assertTrue(responseBody2.contains("\"resiliency_mode\":\"monitor\""));
        assertTrue(responseBody.contains("\"search.default_search_timeout\":\"1m\""));
        unTagged.setJsonEntity(body);
            }""";
        assertFalse(responseBody6.contains("\"analytics6\""));
/*
            () -> performOperation("PUT", "_wlm/workload_group", invalidIntJson)
        String unknownKeyJson = """
        );
        assertEquals(200, response.getStatusLine().getStatusCode());
        Response getResponse = performOperation("GET", "_wlm/workload_group/override_test", null);
        Response response6 = performOperation("GET", "_wlm/workload_group", null);
        Request request = new Request(method, uriPath);
        Response getResponse2 = performOperation("GET", "_wlm/workload_group/max_buckets_test", null);
                    "cpu" : %s,
        // Create a WLM group with a small max_buckets value
                    "search.default_search_timeout": "30s",
                    "search.default_search_timeout": "1m"
                "name": "invalid_test",
        assertEquals(200, response.getStatusLine().getStatusCode());
    }
    }
                "settings": {
        String responseBody2 = EntityUtils.toString(response2.getEntity());
        assertEquals(200, response.getStatusLine().getStatusCode());
        String responseBody2 = EntityUtils.toString(getResponse2.getEntity());
        assertTrue(responseBody.contains("\"search.default_search_timeout\":\"30s\""));
        searchRequest.setJsonEntity("{\"query\":{\"match_all\":{}},\"timeout\":\"1m\"}");
    private static final Pattern WORKLOAD_GROUP_ID_PATTERN = Pattern.compile("\"_id\"\\s*:\\s*\"([^\"]+)\"");
                    "search.cancel_after_time_interval": "1m",
    }
        assertEquals(200, updateResponse.getStatusLine().getStatusCode());
        performOperation("POST", "wlm-test-idx/_refresh", null);
            }""";
            }""";
        assertThrows(ResponseException.class, () -> performOperation("DELETE", "_wlm/workload_group/analytics4", null));
        String clearJson = """
        Response updateResponse = performOperation("PUT", "_wlm/workload_group/search_test", updateJson);
    static String getUpdateJson(String resiliencyMode, double cpu, double memory) {
                "name": "invalid_test",
public class WorkloadManagementRestIT extends OpenSearchRestTestCase {
                    "cpu" : 1.1,
        performOperation("DELETE", "_wlm/workload_group/search_test", null);
        // Same query without the WLM tag passes — cluster default allows >1 bucket.
        String invalidTimeBody = EntityUtils.toString(invalidTimeException.getResponse().getEntity());
        assertTrue(invalidMaxBucketsBody.contains("Invalid value"));
    }
    }
    public void testSearchSettingsInvalidSettingsRejected() throws Exception {
        assertThrows(
    }
                "resource_limits": {"cpu": 0.3, "memory": 0.3},
        );
}
 *
                "resiliency_mode": "%s",
        assertEquals(200, searchResponse.getStatusLine().getStatusCode());
        String body = EntityUtils.toString(response.getEntity());
                "resiliency_mode": "enforced",
        assertEquals(200, response5.getStatusLine().getStatusCode());
        // Cluster default permits the aggregation; WLM cap is smaller and must win.
        assertEquals(200, response2.getStatusLine().getStatusCode());
                "resource_limits": {"cpu": 0.3, "memory": 0.3},
            {
        assertThrows(ResponseException.class, () -> performOperation("GET", "_wlm/workload_group/analytics97", null));
        // through MultiBucketConsumerService without errors. Resolution semantics are
            }""";
        String rejectedBody = EntityUtils.toString(rejected.getResponse().getEntity());
        return String.format(Locale.ROOT, """
        assertTrue(responseBody6.contains("\"workload_groups\""));
                "settings": {
        assertTrue(responseBody5.contains("\"acknowledged\":true"));
 * SPDX-License-Identifier: Apache-2.0
        String body = "{\"size\":0,\"aggs\":{\"by_k\":{\"terms\":{\"field\":\"k.keyword\"}}}}";
        assertEquals(200, response1.getStatusLine().getStatusCode());
        Response response1 = performOperation("PUT", "_wlm/workload_group/analytics6", getUpdateJson("monitor", 0.41, 0.21));
        }
        performOperation("DELETE", "_wlm/workload_group/analytics3", null);
        // Exercise the full request path: create an index, run a search with the WLM header.
        assertEquals(200, response2.getStatusLine().getStatusCode());
        String responseBody = EntityUtils.toString(getResponse.getEntity());
            {
        assertTrue(invalidTimeBody.contains("search.cancel_after_time_interval"));
            {
        // Verify override_request_values is "true" in GET response
        assertTrue(EntityUtils.toString(unknownKeyException.getResponse().getEntity()).contains("Unknown WLM setting: unknown_setting"));
                "settings": {
                }
        String invalidMaxBucketsJson = """
        Response response = performOperation("PUT", "_wlm/workload_group", createJson);
        assertTrue(responseBody2.contains("\"search.max_buckets\":\"500\""));
        String wgId = extractWorkloadGroupId(performOperation("GET", "_wlm/workload_group/" + wgName, null));
            ResponseException.class,
        Response response = performOperation("PUT", "_wlm/workload_group", getCreateJson("analytics6", "enforced", 0.4, 0.2));
            {
        Response response = performOperation("PUT", "_wlm/workload_group", createJson);
            {"settings": {"override_request_values": "false"}}""";
        String updateJson = """
        assertEquals(200, response.getStatusLine().getStatusCode());
    public void testUpdate() throws Exception {
              }
    public void testSearchSettings() throws Exception {
import org.opensearch.test.rest.OpenSearchRestTestCase;
        Response toggleResponse = performOperation("PUT", "_wlm/workload_group/override_test", toggleJson);
                "settings": {
        performOperation("POST", "wlm-buckets-enforce-idx/_refresh", null);
                    "search.default_search_timeout": "30s",
            {
        Request searchRequest = new Request("POST", "wlm-test-idx/_search");
        Response response2 = performOperation("PUT", "_wlm/workload_group/analytics5", getUpdateJson("monitor", 0.41, 0.21));
    public void testDelete() throws Exception {
        assertEquals(200, toggleResponse.getStatusLine().getStatusCode());
            }""", name, resiliencyMode, cpu, memory);
        assertTrue(EntityUtils.toString(getResponse2.getEntity()).contains("\"override_request_values\":\"false\""));
    public void testCreate() throws Exception {
                }
    }
                    "search.cancel_after_time_interval": "5m",
            () -> performOperation("PUT", "_wlm/workload_group", getCreateJson("users2", "soft", 0.41, 0.71))
                "resiliency_mode": "enforced",
        assertTrue(responseBody2.contains("\"memory\":0.21"));
                }
        performOperation("POST", "wlm-buckets-enforce-idx/_doc", "{\"k\":\"v2\"}");
        assertThrows(ResponseException.class, () -> performOperation("DELETE", "_wlm/workload_group/analytics99", null));
        performOperation("DELETE", "_wlm/workload_group/users", null);
import org.opensearch.client.Response;
        assertEquals(200, response.getStatusLine().getStatusCode());
                "name": "invalid_test",
 * this file be licensed under the Apache-2.0 license or a
    }
        performOperation("POST", "wlm-buckets-idx/_refresh", null);
        ResponseException unknownKeyException = expectThrows(
        assertEquals(200, response.getStatusLine().getStatusCode());
        String responseBody2 = EntityUtils.toString(response2.getEntity());
        // Invalid value for max_concurrent_shard_requests (must be >= 1)
        );
            request.setJsonEntity(json);
        assertTrue(responseBody2.contains("\"search.batched_reduce_size\":\"256\""));
                }
                    "search.batched_reduce_size": "64",
        assertTrue(EntityUtils.toString(getResponse.getEntity()).contains("\"search.max_buckets\":\"100\""));
            ResponseException.class,
                "settings": {
        // Clear all settings with empty object
        assertTrue(invalidMaxBucketsBody.contains("search.max_buckets"));
        assertTrue(EntityUtils.toString(getResponse.getEntity()).contains("\"override_request_values\":\"true\""));
 */
        String json = """
        String createJson = """
        String invalidTimeJson = """
        );
        performOperation("PUT", "wlm-buckets-idx", "{\"settings\":{\"number_of_shards\":1,\"number_of_replicas\":0}}");
            }""", wgName);
        performOperation("DELETE", "_wlm/workload_group/users3", null);
                    "cpu" : %s,
        Response clearResponse = performOperation("PUT", "_wlm/workload_group/merge_test", clearJson);
                "resiliency_mode": "enforced",
import java.util.Locale;
        Response searchResponse = client().performRequest(searchRequest);
        assertTrue(responseBody2.contains("\"name\":\"analytics6\""));
        assertTrue(EntityUtils.toString(searchResponse.getEntity()).contains("\"hits\""));
import java.util.regex.Matcher;
        // Update search settings
                "resource_limits": {"cpu": 0.3, "memory": 0.3},
        assertTrue("expected too_many_buckets error, got: " + rejectedBody, rejectedBody.contains("too_many_buckets"));
        Response response5 = performOperation("DELETE", "_wlm/workload_group/analytics6", null);
                "resource_limits": {"cpu": 0.3, "memory": 0.3},
                "wlm.workload_group.mode": "%s"
                    "search.batched_reduce_size": "256",
        Response response = performOperation("PUT", "_wlm/workload_group", getCreateJson("analytics5", "enforced", 0.4, 0.2));
        // Verify updated settings
        // Create with multiple settings
        assertTrue(responseBody2.contains("\"search.cancel_after_time_interval\":\"5m\""));
        String responseBody = EntityUtils.toString(getResponse.getEntity());
                "resiliency_mode": "enforced",
        assertTrue(invalidTimeBody.contains("Invalid value"));
                "name": "%s",
            {"settings": {"search.max_buckets": "5000"}}""";
        performOperation("DELETE", "_wlm/workload_group/max_buckets_test", null);
            {
        String createJson = """
    }
                },
        // verified in MultiBucketConsumerServiceTests.
        assertOK(performOperation("GET", "_wlm/workload_group/", null));
        assertTrue(responseBody.contains("\"search.max_buckets\":\"1000\""));
            {
    public void testGet() throws Exception {
import org.junit.Before;
                "settings": {
import org.opensearch.client.ResponseException;
        Response getResponse = performOperation("GET", "_wlm/workload_group/merge_test", null);
            }""";
                }
                    "override_request_values": "true"
                "settings": {
                "settings": {}
        Response response = performOperation("PUT", "_wlm/workload_group", createJson);
    public void testSearchMaxBucketsEnforcedAtRequestPath() throws Exception {
                "name": "%s",
        // semantics themselves are verified in WorkloadGroupRequestOperationListenerTests.
        performOperation("PUT", "wlm-buckets-enforce-idx", "{\"settings\":{\"number_of_shards\":1,\"number_of_replicas\":0}}");
        // Create a WLM group with override_request_values=true so WLM settings win over request params
                    "search.max_concurrent_shard_requests": "5",
                    "search.max_concurrent_shard_requests": "10",
        assertTrue(EntityUtils.toString(response2.getEntity()).contains("\"acknowledged\":true"));
        assertTrue(invalidBatchBody.contains("search.batched_reduce_size"));
            ResponseException.class,
        Response response2 = performOperation("DELETE", "_wlm/workload_group/analytics4", null);
 * compatible open source license.
        performOperation("DELETE", "_wlm/workload_group/override_test", null);
        String updateJson = """
        assertTrue(responseBody.contains("\"settings\""));
        // Invalid value for max_buckets (must be >= 0)
        Response response2 = performOperation("GET", "_wlm/workload_group/analytics6", null);
        assertEquals(200, response2.getStatusLine().getStatusCode());
    Response performOperation(String method, String uriPath, String json) throws IOException {
        assertEquals(200, searchResponse.getStatusLine().getStatusCode());
        // This confirms the listener is wired into the request flow without errors. Override
                "resource_limits": {
    }
                    "search.max_buckets": "1"
import java.io.IOException;
    }
        Response response = performOperation("PUT", "_wlm/workload_group", createJson);
            () -> performOperation("PUT", "_wlm/workload_group", invalidMaxBucketsJson)
                    "memory" : %s
                }
        assertEquals(200, response.getStatusLine().getStatusCode());
        assertEquals(200, clearResponse.getStatusLine().getStatusCode());
                "name": "max_buckets_test",
                "settings": {
        assertThrows(
            ResponseException.class,
            ResponseException.class,
            }""";
                "resiliency_mode": "%s",
        );
            () -> performOperation("PUT", "_wlm/workload_group", getCreateJson("analytics", "enforced", 0.4, 0.2))
        assertEquals(200, response6.getStatusLine().getStatusCode());
            {
                "resiliency_mode": "enforced",
    private String extractWorkloadGroupId(Response response) throws Exception {
        performOperation("PUT", "wlm-test-idx", "{\"settings\":{\"number_of_shards\":1,\"number_of_replicas\":0}}");
        performOperation("DELETE", "wlm-buckets-idx", null);
    @Before
        // Update only timeout — other settings should persist
        assertEquals(200, response.getStatusLine().getStatusCode());
        // Exercise the request path with an aggregation — confirms the resolver is wired
        assertTrue(responseBody.contains("\"search.batched_reduce_size\":\"512\""));
            () -> performOperation("PUT", "_wlm/workload_group", unknownKeyJson)
    public void enableWlmMode() throws Exception {
        searchRequest.setOptions(searchRequest.getOptions().toBuilder().addHeader("X-opaque-id", "wlm=override_test"));
        performOperation("POST", "wlm-buckets-enforce-idx/_doc", "{\"k\":\"v1\"}");
        Response response = performOperation("PUT", "_wlm/workload_group", getCreateJson("analytics2", "enforced", 0.4, 0.2));
                    "search.batched_reduce_size": "512",
            }
        String invalidIntBody = EntityUtils.toString(invalidIntException.getResponse().getEntity());
        assertFalse(responseBody2.contains("\"search.max_concurrent_shard_requests\""));
        assertTrue(responseBody2.contains("\"search.max_concurrent_shard_requests\":\"10\""));
        String invalidMaxBucketsBody = EntityUtils.toString(invalidMaxBucketsException.getResponse().getEntity());
        Request unTagged = new Request("POST", "wlm-buckets-enforce-idx/_search");
                    "override_request_values": "true"
        assertTrue(responseBody2.contains("\"resiliency_mode\":\"enforced\""));
        Response response2 = performOperation("GET", "_wlm/workload_group/analytics3", null);
        // Verify merge: timeout updated, max_concurrent persists, override persists
        // Create with all search settings
                "settings": {
        );
        assertTrue(responseBody2.contains("\"memory\":0.2"));
        ResponseException invalidBatchException = expectThrows(
package org.opensearch.rest;
    }
        assertTrue(responseBody2.contains("\"name\":\"analytics5\""));
        assertEquals(200, response2.getStatusLine().getStatusCode());
    public void testMultipleCreate() throws Exception {
        assertEquals(200, response2.getStatusLine().getStatusCode());
        assertEquals(200, response.getStatusLine().getStatusCode());
                "settings": {}
        String invalidIntJson = """
                "resource_limits": {"cpu": 0.3, "memory": 0.3},
        assertEquals(200, response4.getStatusLine().getStatusCode());
                    "search.max_concurrent_shard_requests": "0"
    public void testSearchSettingsOverrideRequestValues() throws Exception {
    public void testSearchSettingsMergeSemantics() throws Exception {
        assertThrows(
        performOperation("DELETE", "wlm-buckets-enforce-idx", null);
    public void testCRUD() throws Exception {
        performOperation("POST", "wlm-test-idx/_doc", "{\"msg\":\"hello\"}");
        Response response4 = performOperation("PUT", "_wlm/workload_group", getCreateJson("users3", "monitor", 0.59, 0.79));
        assertTrue(responseBody.contains("\"search.max_concurrent_shard_requests\":\"5\""));
        Response updateResponse = performOperation("PUT", "_wlm/workload_group/max_buckets_test", updateJson);
        assertTrue(responseBody.contains("\"search.max_concurrent_shard_requests\":\"5\""));
        return client().performRequest(request);
                "name": "merge_test",
                "resiliency_mode": "enforced",
        performOperation("DELETE", "_wlm/workload_group/analytics2", null);
        performOperation("DELETE", "_wlm/workload_group/analytics5", null);
                }
                "settings": {
        assertTrue("expected limit of 1 in error, got: " + rejectedBody, rejectedBody.contains("\"max_buckets\":1"));
        );
                    "memory" : -0.1
        setWlmMode("enabled");
        String createJson = """
        // Verify cleared — all settings should be gone
                    "search.default_search_timeout": "1m",
            }""";
            () -> performOperation("PUT", "_wlm/workload_group", invalidTimeJson)
        performOperation("DELETE", "wlm-test-idx", null);
        assertTrue(responseBody2.contains("\"memory\":0.21"));
                "resiliency_mode": "enforced",
                    "search.max_buckets": "1000"
        Response getResponse = performOperation("GET", "_wlm/workload_group/search_test", null);
            }""";
        String createJson = String.format(Locale.ROOT, """
        Request searchRequest = new Request("POST", "wlm-buckets-idx/_search");
    private void setWlmMode(String mode) throws Exception {
    }
            ResponseException.class,
        searchRequest.setOptions(searchRequest.getOptions().toBuilder().addHeader("X-opaque-id", "wlm=max_buckets_test"));
                "name": "search_test",
                "settings": {
            {
              "persistent": {
                "name": "override_test",
                }
    }
        Request tagged = new Request("POST", "wlm-buckets-enforce-idx/_search");
                "resource_limits": {
                    "search.max_buckets": "500"
        request.setJsonEntity(settingJson);
                    "search.cancel_after_time_interval": "not_a_time"
        assertTrue(responseBody2.contains("\"name\":\"analytics3\""));
                "resiliency_mode": "enforced",
        Response response = performOperation("PUT", "_wlm/workload_group", getCreateJson("analytics3", "enforced", 0.4, 0.2));
            {
        if (json != null) {
        String responseBody5 = EntityUtils.toString(response5.getEntity());
        assertEquals(200, updateResponse.getStatusLine().getStatusCode());
            }""";
            ResponseException.class,
        Matcher m = WORKLOAD_GROUP_ID_PATTERN.matcher(body);
    public void testOperationWhenWlmDisabled() throws Exception {
        ResponseException invalidMaxBucketsException = expectThrows(
        Request request = new Request("PUT", "/_cluster/settings");
                    "memory" : %s
            () -> performOperation("PUT", "_wlm/workload_group", getCreateJson("users3", "monitor", 0.6, 0.8))
            {
        assertTrue(responseBody.contains("\"search.cancel_after_time_interval\":\"1m\""));
        );
    }
        String responseBody6 = EntityUtils.toString(response6.getEntity());
        ResponseException rejected = expectThrows(ResponseException.class, () -> client().performRequest(tagged));
        // Unknown setting key should be rejected
        tagged.setJsonEntity(body);
        assertTrue(responseBody2.contains("\"resiliency_mode\":\"monitor\""));
        return String.format(Locale.ROOT, """
        assertEquals(200, updateResponse.getStatusLine().getStatusCode());
            {
            () -> performOperation("PUT", "_wlm/workload_group/analytics98", getUpdateJson("monitor", 0.43, 0.23))
        Response searchResponse = client().performRequest(searchRequest);
                "resiliency_mode": "enforced",
            """, mode);
        assertTrue(EntityUtils.toString(getResponse2.getEntity()).contains("\"search.max_buckets\":\"5000\""));
        assertEquals(200, response.getStatusLine().getStatusCode());
        // Invalid time value
            {
                    "search.max_buckets": "-1"
    }
                    "search.max_concurrent_shard_requests": "3",
        String responseBody2 = EntityUtils.toString(response2.getEntity());
        assertTrue(invalidIntBody.contains("must be >= 1"));
        assertTrue(invalidIntBody.contains("search.max_concurrent_shard_requests"));
                }
        Response getResponse2 = performOperation("GET", "_wlm/workload_group/merge_test", null);
        assertThrows(
                    "unknown_setting": "value"
        String settingJson = String.format(Locale.ROOT, """
    public void testSearchMaxBucketsCreateAndUpdate() throws Exception {
        assertTrue(responseBody6.contains("\"users3\""));
                }
                "resource_limits": {"cpu": 0.3, "memory": 0.3},
                    "search.max_concurrent_shard_requests": "5",
        Response getResponse2 = performOperation("GET", "_wlm/workload_group/search_test", null);
        String invalidBatchBody = EntityUtils.toString(invalidBatchException.getResponse().getEntity());
import org.opensearch.client.Request;
        assertTrue(responseBody2.contains("\"cpu\":0.41"));
        assertEquals(200, response.getStatusLine().getStatusCode());
                    "search.batched_reduce_size": "1"
import org.apache.hc.core5.http.io.entity.EntityUtils;
                    "search.default_search_timeout": "30s",
        String createJson = """
                "resource_limits": {"cpu": 0.3, "memory": 0.3},
            {
