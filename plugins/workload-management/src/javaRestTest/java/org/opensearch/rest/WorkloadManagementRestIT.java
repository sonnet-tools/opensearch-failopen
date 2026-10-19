        assertTrue(responseBody6.contains("\"workload_groups\""));  
 * compatible open source license.
        assertTrue(invalidBatchBody.contains("must be >= 2"));
            ResponseException.class,
        assertFalse(responseBody.contains("\"override_request_values\""));
                    "search.max_buckets": "500"
        assertEquals(200, response2.getStatusLine().getStatusCode());
                }
        Response response1 = performOperation("PUT", "_wlm/workload_group/analytics6", getUpdateJson("monitor", 0.41, 0.21));  
        // Invalid time value  
        performOperation("DELETE", "_wlm/workload_group/analytics2", null);
        assertTrue(responseBody6.contains("\"users3\""));
                    "cpu" : 1.1,
        // Verify cleared — all settings should be gone
        performOperation("PUT", "wlm-buckets-idx", "{\"settings\":{\"number_of_shards\":1,\"number_of_replicas\":0}}");  
                    "search.batched_reduce_size": "256",
import java.util.regex.Matcher;
        Response response = performOperation("PUT", "_wlm/workload_group", createJson);
                "resource_limits": {"cpu": 0.3, "memory": 0.3},
                "resiliency_mode": "%s",  
            () -> performOperation("PUT", "_wlm/workload_group", getCreateJson("analytics", "enforced", 0.4, 0.2))
                    "search.cancel_after_time_interval": "1m",
        // Toggle to false and verify
                "name": "override_test",  
    static String getCreateJson(String name, String resiliencyMode, double cpu, double memory) {
 *
        if (json != null) {
                "settings": {}
import org.opensearch.test.rest.OpenSearchRestTestCase;
        assertTrue(responseBody2.contains("\"name\":\"analytics5\""));  
    public void testOperationWhenWlmDisabled() throws Exception {  
        assertTrue(EntityUtils.toString(unknownKeyException.getResponse().getEntity()).contains("Unknown WLM setting: unknown_setting"));
        Response getResponse2 = performOperation("GET", "_wlm/workload_group/max_buckets_test", null);  
        performOperation("DELETE", "_wlm/workload_group/analytics5", null);
        String updateJson = """
            {
            }""";  
                "name": "%s",
        Response response = performOperation("PUT", "_wlm/workload_group", getCreateJson("analytics", "enforced", 0.4, 0.2));  
        assertTrue("could not find _id in response: " + body, m.find());
                    "search.default_search_timeout": "30s",
                "name": "invalid_test",  
        assertTrue(responseBody.contains("\"search.max_concurrent_shard_requests\":\"5\""));
                }
                    "cpu" : %s,
                }
        assertTrue(responseBody2.contains("\"resiliency_mode\":\"monitor\""));
        ResponseException invalidMaxBucketsException = expectThrows(
    }  
                "name": "merge_test",  
        assertEquals(200, response2.getStatusLine().getStatusCode());
    }  
            {
            ResponseException.class,
public class WorkloadManagementRestIT extends OpenSearchRestTestCase {
                }
        performOperation("POST", "wlm-buckets-enforce-idx/_doc", "{\"k\":\"v2\"}");  
                "resource_limits": {"cpu": 0.3, "memory": 0.3},
        // With the workload group attached, the WLM cap of 1 is enforced.
        assertThrows(  
        String invalidTimeJson = """
                "resiliency_mode": "enforced",
        Response getResponse = performOperation("GET", "_wlm/workload_group/search_test", null);
                    "memory" : %s  
        assertTrue(EntityUtils.toString(getResponse.getEntity()).contains("\"override_request_values\":\"true\""));  
        // Invalid value for max_buckets (must be >= 0)  
        assertTrue(responseBody.contains("\"override_request_values\":\"true\""));  
        String invalidMaxBucketsJson = """
        assertThrows(ResponseException.class, () -> performOperation("DELETE", "_wlm/workload_group/analytics99", null));
        performOperation("POST", "wlm-buckets-idx/_doc", "{\"k\":\"v1\"}");
                    "memory" : %s  
import org.opensearch.client.ResponseException;
            }""";  
                }
    }  
        String createJson = """  
            ResponseException.class,
            }""";  
        assertFalse(responseBody2.contains("\"search.max_concurrent_shard_requests\""));  
        performOperation("DELETE", "wlm-buckets-enforce-idx", null);
        assertTrue(EntityUtils.toString(getResponse2.getEntity()).contains("\"override_request_values\":\"false\""));
              }  
import org.junit.Before;  
                    "search.default_search_timeout": "30s",
                }  
        Response response = performOperation("PUT", "_wlm/workload_group", getCreateJson("analytics2", "enforced", 0.4, 0.2));  
        String createJson = """  
                    "unknown_setting": "value"  
        assertOK(performOperation("GET", "_wlm/workload_group/", null));
        setWlmMode("enabled");
        assertEquals(200, response.getStatusLine().getStatusCode());
            () -> performOperation("PUT", "_wlm/workload_group", invalidTimeJson)  
        performOperation("POST", "wlm-buckets-idx/_refresh", null);
        String responseBody6 = EntityUtils.toString(response6.getEntity());
        assertEquals(200, response.getStatusLine().getStatusCode());
            () -> performOperation("PUT", "_wlm/workload_group", invalidMaxBucketsJson)  
        return String.format(Locale.ROOT, """  
        Response getResponse2 = performOperation("GET", "_wlm/workload_group/merge_test", null);
        performOperation("POST", "wlm-buckets-enforce-idx/_doc", "{\"k\":\"v1\"}");
                "name": "%s",
            request.setJsonEntity(json);
    public void testMultipleCreate() throws Exception {
        assertTrue(responseBody.contains("\"search.batched_reduce_size\":\"512\""));  
                "settings": {
        );
        Response clearResponse = performOperation("PUT", "_wlm/workload_group/merge_test", clearJson);
        );
        );
            ResponseException.class,
        performOperation("POST", "wlm-buckets-enforce-idx/_refresh", null);
        assertThrows(
        );
                }  
    public void testSearchSettingsOverrideRequestValues() throws Exception {
        // Exercise the request path with an aggregation — confirms the resolver is wired  
        assertEquals(200, searchResponse.getStatusLine().getStatusCode());  
            }""";
        String invalidTimeBody = EntityUtils.toString(invalidTimeException.getResponse().getEntity());
                "resource_limits": {"cpu": 0.3, "memory": 0.3},
        assertEquals(200, clearResponse.getStatusLine().getStatusCode());
    public void testSearchSettingsInvalidSettingsRejected() throws Exception {
            {
        String responseBody2 = EntityUtils.toString(getResponse2.getEntity());  
        );
                    "search.max_concurrent_shard_requests": "5",
        performOperation("DELETE", "_wlm/workload_group/search_test", null);
        assertThrows(
        Response response = performOperation("PUT", "_wlm/workload_group", getCreateJson("analytics4", "enforced", 0.4, 0.2));
            {  
        assertEquals(200, response2.getStatusLine().getStatusCode());
    }  
        assertTrue(responseBody.contains("\"search.default_search_timeout\":\"30s\""));  
        assertEquals(200, response.getStatusLine().getStatusCode());
        setWlmMode("disabled");
        assertEquals(200, response1.getStatusLine().getStatusCode());
        // Create a WLM group with override_request_values=true so WLM settings win over request params  
                }
        performOperation("PUT", "wlm-test-idx", "{\"settings\":{\"number_of_shards\":1,\"number_of_replicas\":0}}");
        assertEquals(200, response.getStatusLine().getStatusCode());
        String createJson = """
        performOperation("PUT", "wlm-buckets-enforce-idx", "{\"settings\":{\"number_of_shards\":1,\"number_of_replicas\":0}}");
        // Create with all search settings
        Request unTagged = new Request("POST", "wlm-buckets-enforce-idx/_search");  
        request.setJsonEntity(settingJson);
        assertTrue(invalidBatchBody.contains("search.batched_reduce_size"));  
        Response getResponse2 = performOperation("GET", "_wlm/workload_group/override_test", null);
        assertEquals(200, updateResponse.getStatusLine().getStatusCode());
        assertEquals(200, response.getStatusLine().getStatusCode());
            }""";  
        Response updateResponse = performOperation("PUT", "_wlm/workload_group/max_buckets_test", updateJson);  
 * SPDX-License-Identifier: Apache-2.0
import java.util.Locale;  
        assertTrue(responseBody2.contains("\"cpu\":0.41"));
        // Update only timeout — other settings should persist  
        assertEquals(200, response.getStatusLine().getStatusCode());
            ResponseException.class,  
        );
        Response response = performOperation("PUT", "_wlm/workload_group", getCreateJson("analytics3", "enforced", 0.4, 0.2));  
            }""";  
        searchRequest.setOptions(searchRequest.getOptions().toBuilder().addHeader("X-opaque-id", "wlm=max_buckets_test"));  
            () -> performOperation("PUT", "_wlm/workload_group", getCreateJson("users3", "monitor", 0.6, 0.8))
            {  
        String createJson = """
    }  
        assertTrue(responseBody2.contains("\"name\":\"analytics3\""));  
              "persistent": {
import org.apache.hc.core5.http.io.entity.EntityUtils;
        String rejectedBody = EntityUtils.toString(rejected.getResponse().getEntity());  
            ResponseException.class,
            () -> performOperation("PUT", "_wlm/workload_group/analytics98", getUpdateJson("monitor", 0.43, 0.23))  
        Response response2 = performOperation("GET", "_wlm/workload_group/analytics3", null);  
}  
    public void testDelete() throws Exception {  
        Response response2 = performOperation("PUT", "_wlm/workload_group/analytics5", getUpdateJson("monitor", 0.41, 0.21));  
        String createJson = String.format(Locale.ROOT, """
        Response response = performOperation("PUT", "_wlm/workload_group", getCreateJson("analytics6", "enforced", 0.4, 0.2));  
        String updateJson = """
                    "search.max_buckets": "1"
                "resource_limits": {"cpu": 0.3, "memory": 0.3},
import java.io.IOException;
    }
                "name": "invalid_test",  
        assertFalse(responseBody6.contains("\"analytics6\""));
            ResponseException.class,
    private static final Pattern WORKLOAD_GROUP_ID_PATTERN = Pattern.compile("\"_id\"\\s*:\\s*\"([^\"]+)\"");
        Response getResponse = performOperation("GET", "_wlm/workload_group/override_test", null);
/*  
        assertTrue(EntityUtils.toString(getResponse.getEntity()).contains("\"search.max_buckets\":\"100\""));
        }  
                    "search.default_search_timeout": "1m",
                "resource_limits": {"cpu": 0.3, "memory": 0.3},
        // verified in MultiBucketConsumerServiceTests.
        assertTrue(EntityUtils.toString(response2.getEntity()).contains("\"acknowledged\":true"));  
    }  
    }
                    "override_request_values": "true"
    }
        );  
        );
        assertEquals(200, searchResponse.getStatusLine().getStatusCode());
                "name": "invalid_test",  
        assertEquals(200, toggleResponse.getStatusLine().getStatusCode());  
        assertTrue(responseBody5.contains("\"acknowledged\":true"));
        performOperation("POST", "wlm-test-idx/_doc", "{\"msg\":\"hello\"}");
        assertThrows(ResponseException.class, () -> performOperation("PUT", "_wlm/workload_group/analytics5", json));  
    public void testSearchMaxBucketsEnforcedAtRequestPath() throws Exception {
        String settingJson = String.format(Locale.ROOT, """
        return m.group(1);
                "resource_limits": {
        tagged.setOptions(tagged.getOptions().toBuilder().addHeader("workloadGroupId", wgId));
        String wgId = extractWorkloadGroupId(performOperation("GET", "_wlm/workload_group/" + wgName, null));
            }""", wgName);
        assertTrue(EntityUtils.toString(getResponse2.getEntity()).contains("\"search.max_buckets\":\"5000\""));
        assertTrue(responseBody.contains("\"search.cancel_after_time_interval\":\"1m\""));
        tagged.setJsonEntity(body);  
        Response getResponse = performOperation("GET", "_wlm/workload_group/max_buckets_test", null);  
            }""";
        // Invalid value for batched_reduce_size (must be >= 2)  
                "settings": {
        String body = EntityUtils.toString(response.getEntity());
        assertTrue(responseBody2.contains("\"search.max_concurrent_shard_requests\":\"10\""));
        String toggleJson = """  
        Request request = new Request(method, uriPath);  
        assertThrows(
                "settings": {
            {
        performOperation("DELETE", "_wlm/workload_group/analytics3", null);  
        searchRequest.setJsonEntity("{\"query\":{\"match_all\":{}},\"timeout\":\"1m\"}");  
                "resource_limits": {
                "resiliency_mode": "enforced",
            {
        Response searchResponse = client().performRequest(searchRequest);
                "resiliency_mode": "enforced",
                    "search.cancel_after_time_interval": "not_a_time"
        assertTrue(responseBody2.contains("\"resiliency_mode\":\"monitor\""));
        // Verify merge: timeout updated, max_concurrent persists, override persists
        assertTrue(invalidTimeBody.contains("search.cancel_after_time_interval"));  
        // through MultiBucketConsumerService without errors. Resolution semantics are
    public void testSearchSettings() throws Exception {
        assertTrue(responseBody2.contains("\"search.batched_reduce_size\":\"256\""));
        performOperation("DELETE", "_wlm/workload_group/max_buckets_test", null);
    static String getUpdateJson(String resiliencyMode, double cpu, double memory) {  
        assertEquals(200, response4.getStatusLine().getStatusCode());
            }""", resiliencyMode, cpu, memory);
        Response response = client().performRequest(request);  
                "settings": {  
        Response getResponse2 = performOperation("GET", "_wlm/workload_group/search_test", null);  
        Response toggleResponse = performOperation("PUT", "_wlm/workload_group/override_test", toggleJson);
        String body = "{\"size\":0,\"aggs\":{\"by_k\":{\"terms\":{\"field\":\"k.keyword\"}}}}";  
                "wlm.workload_group.mode": "%s"
        String unknownKeyJson = """  
                "name": "invalid_test",
        Response getResponse = performOperation("GET", "_wlm/workload_group/merge_test", null);
        assertTrue(invalidTimeBody.contains("Invalid value"));
            {
        Response updateResponse = performOperation("PUT", "_wlm/workload_group/search_test", updateJson);
        performOperation("DELETE", "_wlm/workload_group/merge_test", null);
        assertEquals(200, response2.getStatusLine().getStatusCode());
                "resiliency_mode": "enforced",
        // Invalid value for max_concurrent_shard_requests (must be >= 1)  
    private String extractWorkloadGroupId(Response response) throws Exception {
                    "search.max_concurrent_shard_requests": "5",
                "resiliency_mode": "enforced",
        assertTrue(invalidMaxBucketsBody.contains("search.max_buckets"));  
    public void testCRUD() throws Exception {
        unTagged.setJsonEntity(body);
        Response response2 = performOperation("PUT", "_wlm/workload_group", getCreateJson("users", "soft", 0.2, 0.1));  
        assertTrue("expected limit of 1 in error, got: " + rejectedBody, rejectedBody.contains("\"max_buckets\":1"));
            {  
        // Update to a larger value  
                }
    }  
                "resiliency_mode": "enforced",
    public void enableWlmMode() throws Exception {
                "settings": {  
        performOperation("DELETE", "wlm-test-idx", null);  
        assertEquals(200, response.getStatusLine().getStatusCode());
                "name": "invalid_test",  
        assertTrue(responseBody2.contains("\"cpu\":0.4"));
        assertEquals(200, response5.getStatusLine().getStatusCode());
                "resource_limits": {
                "resource_limits": {"cpu": 0.3, "memory": 0.3},
        String responseBody2 = EntityUtils.toString(response2.getEntity());
    }  
            }""", name, resiliencyMode, cpu, memory);  
        String invalidMaxBucketsBody = EntityUtils.toString(invalidMaxBucketsException.getResponse().getEntity());
import org.opensearch.client.Response;  
        assertTrue(EntityUtils.toString(searchResponse.getEntity()).contains("\"hits\""));
            }""";  
        assertEquals(200, response6.getStatusLine().getStatusCode());
    }
    }  
        Response response6 = performOperation("GET", "_wlm/workload_group", null);  
        String responseBody = EntityUtils.toString(getResponse.getEntity());  
        Response response = performOperation("PUT", "_wlm/workload_group", getCreateJson("analytics5", "enforced", 0.4, 0.2));  
        performOperation("DELETE", "_wlm/workload_group/override_test", null);
        String invalidBatchJson = """
        assertFalse(responseBody2.contains("\"search.default_search_timeout\""));
        String responseBody2 = EntityUtils.toString(response2.getEntity());
        assertTrue(invalidIntBody.contains("search.max_concurrent_shard_requests"));  
                "resiliency_mode": "enforced",  
            {
        assertEquals(200, updateResponse.getStatusLine().getStatusCode());  
            {
                }
    }
import java.util.regex.Pattern;
                    "search.batched_reduce_size": "512",  
        performOperation("POST", "wlm-test-idx/_refresh", null);  
        Response response2 = performOperation("DELETE", "_wlm/workload_group/analytics4", null);
        // Create with multiple settings  
        ResponseException invalidBatchException = expectThrows(
                    "search.default_search_timeout": "1m"
        assertTrue(responseBody2.contains("\"cpu\":0.41"));
            }
        assertThrows(ResponseException.class, () -> performOperation("DELETE", "_wlm/workload_group/analytics4", null));  
            {
        String responseBody2 = EntityUtils.toString(response2.getEntity());
        assertTrue(responseBody.contains("\"settings\""));
        searchRequest.setOptions(searchRequest.getOptions().toBuilder().addHeader("X-opaque-id", "wlm=override_test"));
                "settings": {}
 * this file be licensed under the Apache-2.0 license or a
    public void testCreate() throws Exception {
        // Same query without the WLM tag passes — cluster default allows >1 bucket.
    }  
                    "memory" : -0.1  
        String invalidIntJson = """
        Response response2 = performOperation("GET", "_wlm/workload_group/analytics6", null);  
                "settings": {  
                "name": "search_test",
        performOperation("DELETE", "_wlm/workload_group/users3", null);  
            () -> performOperation("PUT", "_wlm/workload_group", invalidBatchJson)  
        assertFalse(responseBody2.contains("\"override_request_values\""));
        String wgName = "max_buckets_enforced_test";
        assertTrue(invalidIntBody.contains("must be >= 1"));
                "resource_limits": {"cpu": 0.3, "memory": 0.3},  
        String invalidBatchBody = EntityUtils.toString(invalidBatchException.getResponse().getEntity());
import org.opensearch.client.Request;
                },
        assertEquals(200, client().performRequest(unTagged).getStatusLine().getStatusCode());
            () -> performOperation("PUT", "_wlm/workload_group", invalidIntJson)  
                "name": "max_buckets_test",
        assertTrue(responseBody2.contains("\"memory\":0.21"));  
        // Update search settings  
        performOperation("DELETE", "_wlm/workload_group/" + wgName, null);
                    "search.cancel_after_time_interval": "5m",
                "resiliency_mode": "enforced",  
        assertTrue(responseBody2.contains("\"search.default_search_timeout\":\"1m\""));
            ResponseException.class,  
        String updateJson = """
                "resiliency_mode": "%s",  
        assertEquals(200, updateResponse.getStatusLine().getStatusCode());
            }""";  
            }""";
        String invalidIntBody = EntityUtils.toString(invalidIntException.getResponse().getEntity());
                }
        assertTrue("expected too_many_buckets error, got: " + rejectedBody, rejectedBody.contains("too_many_buckets"));
            () -> performOperation("PUT", "_wlm/workload_group", getCreateJson("users2", "soft", 0.41, 0.71))
        assertTrue(responseBody2.contains("\"search.max_buckets\":\"500\""));  
                    "search.max_concurrent_shard_requests": "0"
        Response response4 = performOperation("PUT", "_wlm/workload_group", getCreateJson("users3", "monitor", 0.59, 0.79));
                "settings": {
        Request tagged = new Request("POST", "wlm-buckets-enforce-idx/_search");
        assertThrows(ResponseException.class, () -> performOperation("GET", "_wlm/workload_group/analytics97", null));
            }""";
        assertTrue(responseBody2.contains("\"name\":\"analytics6\""));  
                    "search.batched_reduce_size": "1"
    Response performOperation(String method, String uriPath, String json) throws IOException {
    public void testSearchMaxBucketsCreateAndUpdate() throws Exception {
    }  
        String json = """
                    "search.max_concurrent_shard_requests": "10",  
                "settings": {  
        Response response = performOperation("PUT", "_wlm/workload_group", createJson);  
        Response response = performOperation("PUT", "_wlm/workload_group", createJson);
        assertEquals(200, response.getStatusLine().getStatusCode());  
        assertTrue(responseBody2.contains("\"search.cancel_after_time_interval\":\"5m\""));  
        Response updateResponse = performOperation("PUT", "_wlm/workload_group/merge_test", updateJson);
                "settings": {  
                "settings": {  
        assertEquals(200, response.getStatusLine().getStatusCode());
    private void setWlmMode(String mode) throws Exception {
    }
        String clearJson = """  
        Response response5 = performOperation("DELETE", "_wlm/workload_group/analytics6", null);
        ResponseException invalidIntException = expectThrows(
            {
    public void testSearchSettingsMergeSemantics() throws Exception {
            {"settings": {"override_request_values": "false"}}""";
        performOperation("DELETE", "wlm-buckets-idx", null);
            ResponseException.class,
        assertTrue(responseBody2.contains("\"memory\":0.21"));  
        return client().performRequest(request);
        ResponseException invalidTimeException = expectThrows(
        ResponseException unknownKeyException = expectThrows(  
            """, mode);
                    "search.max_buckets": "1000"
        performOperation("DELETE", "_wlm/workload_group/analytics", null);
        String responseBody5 = EntityUtils.toString(response5.getEntity());  
                "settings": {  
        // Verify settings in GET response
        assertTrue(responseBody2.contains("\"resiliency_mode\":\"enforced\""));
                    "cpu" : %s,
                }
        searchRequest.setJsonEntity("{\"size\":0,\"aggs\":{\"by_k\":{\"terms\":{\"field\":\"k.keyword\"}}}}");
            () -> performOperation("PUT", "_wlm/workload_group", unknownKeyJson)
        performOperation("DELETE", "_wlm/workload_group/users", null);
        assertTrue(invalidMaxBucketsBody.contains("Invalid value"));
        return String.format(Locale.ROOT, """
                "settings": {  
                "resource_limits": {"cpu": 0.3, "memory": 0.3},
        String responseBody = EntityUtils.toString(getResponse.getEntity());  
                "resiliency_mode": "enforced",
        assertTrue(responseBody.contains("\"search.default_search_timeout\":\"1m\""));
                    "search.default_search_timeout": "30s",  
                    "search.max_buckets": "-1"
        // semantics themselves are verified in WorkloadGroupRequestOperationListenerTests.  
        assertTrue(responseBody.contains("\"search.max_buckets\":\"1000\""));
        Response searchResponse = client().performRequest(searchRequest);
        // Cluster default permits the aggregation; WLM cap is smaller and must win.  
        // Verify updated settings
                "resource_limits": {"cpu": 0.3, "memory": 0.3},
        Matcher m = WORKLOAD_GROUP_ID_PATTERN.matcher(body);  
            {"settings": {"search.max_buckets": "5000"}}""";
            }""";
        // Create a WLM group with a small max_buckets value
        // Exercise the full request path: create an index, run a search with the WLM header.
            {
        assertEquals(200, response.getStatusLine().getStatusCode());
                    "search.max_concurrent_shard_requests": "3",
        // Unknown setting key should be rejected
 * The OpenSearch Contributors require contributions made to  
        Request searchRequest = new Request("POST", "wlm-buckets-idx/_search");
    public void testGet() throws Exception {
                "resiliency_mode": "enforced",  
    }
                }
            {
        Request searchRequest = new Request("POST", "wlm-test-idx/_search");
 */  
        // This confirms the listener is wired into the request flow without errors. Override
        );  
                    "search.batched_reduce_size": "64",  
        assertEquals(200, response.getStatusLine().getStatusCode());
        assertTrue(responseBody.contains("\"search.max_concurrent_shard_requests\":\"5\""));
                "resource_limits": {"cpu": 0.3, "memory": 0.3},
            {
                }
        assertTrue(responseBody2.contains("\"memory\":0.2"));  
        Response response = performOperation("PUT", "_wlm/workload_group", createJson);
package org.opensearch.rest;
            }""";  
    public void testUpdate() throws Exception {
        assertEquals(200, response2.getStatusLine().getStatusCode());
                    "override_request_values": "true"  
        // Verify override_request_values is "true" in GET response
        Response response = performOperation("PUT", "_wlm/workload_group", createJson);  
        // Clear all settings with empty object
        Request request = new Request("PUT", "/_cluster/settings");
            {
    }
    @Before  
        assertEquals(200, response.getStatusLine().getStatusCode());
                    "search.max_buckets": "100"  
        ResponseException rejected = expectThrows(ResponseException.class, () -> client().performRequest(tagged));
        String responseBody2 = EntityUtils.toString(getResponse2.getEntity());
