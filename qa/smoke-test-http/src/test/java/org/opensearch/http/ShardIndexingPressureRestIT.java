        }  
        node2TotalLimitsRejections = node2AfterShadowMode.get("shard_indexing_pressure.total_rejections_breakup_shadow_mode" +
        assertThat(shadowIndexingResponse.getStatusLine().getStatusCode(), equalTo(CREATED.getStatus()));  
            assertThat(node2ReplicaBytes, lessThan(1024));
        values1 = new ArrayList<>(((Map<Object, Object>) nodeStatsMap.get("nodes")).values());  
        XContentTestUtils.JsonMapView shard1AfterShadowMode = new XContentTestUtils.JsonMapView((Map<String, Object>)
            true);
            assertThat(node1CombinedBytes, greaterThan(0));
        }
        ArrayList<Object> shard1IndexingPressureValuesAfterRejection = new ArrayList<>(((Map<Object, Object>) node1AfterRejection
        Integer node1CoordinatingRejections = node1.get("indexing_pressure.memory.total.coordinating_rejections");  
            assertThat(shard1PrimaryBytes, lessThan(1024));
            assertThat(shard2ReplicaBytes, greaterThan(0));  
        }  
        XContentTestUtils.JsonMapView shard2AfterRejection = new XContentTestUtils.JsonMapView((Map<String, Object>)  
            assertThat(node1CombinedBytes, lessThan(1024));
        assertThat(shard2PrimaryRejections, equalTo(0));  
            assertThat(shard1CoordinatingNodeRejections, equalTo(1));
        createRequest.setJsonEntity("{\"settings\": {\"index\": {\"number_of_shards\": 1, \"number_of_replicas\": 1, " +
        } else {
            assertThat(shard2PrimaryBytes, lessThan(1024));
        if (shard1ReplicaBytes == 0) {
            .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), "1KB")
        Integer shard2CoordinatingBytes = shard2.get("memory.total.coordinating_in_bytes");
        assertThat(shard1PrimaryRejections, equalTo(0));
        assertThat(shard2PrimaryRejections, equalTo(0));
        Integer node2ReplicaBytes = node2.get("indexing_pressure.memory.total.replica_in_bytes");
        if (shard1CoordinatingRejections == 0) {
        Integer shard1PrimaryRejections = shard1.get("rejection.primary.primary_rejections");
        Integer node1TotalLimitsRejections = node1.get("shard_indexing_pressure.total_rejections_breakup.node_limits");
        assertThat(shard1IndexingPressureValuesAfterShadowMode.size(), equalTo(1));  
            values3.get(1));
            assertThat(node2CoordinatingRejections, equalTo(1));
        Request updateSettingRequest = new Request("PUT", "/_cluster/settings");
        shard1CoordinatingRejections = shard1AfterShadowMode.get("rejection.coordinating.coordinating_rejections");
        final Response updateSettingResponse = getRestClient().performRequest(updateSettingRequest);  
        assertThat(shard1CoordinatingNodeRejections, equalTo(0));
        node1AfterRejection = new XContentTestUtils.JsonMapView((Map<String, Object>) values2.get(0));
        failedIndexingRequest.setJsonEntity("{\"x\": " + largeString + "}");
        assertThat(shard2PrimaryRejections, equalTo(0));  
        node1TotalLimitsRejections = node1AfterRejection.get("shard_indexing_pressure.total_rejections_breakup.node_limits");  
        Integer node2PrimaryBytes = node2.get("indexing_pressure.memory.total.primary_in_bytes");
        assertThat(node1TotalLimitsRejections, equalTo(0));  
            node1AfterShadowMode.get("shard_indexing_pressure.stats")).values());
        Integer node1PrimaryRejections = node1.get("indexing_pressure.memory.total.primary_rejections");
        Integer shard2CoordinatingRejections = shard2.get("rejection.coordinating.coordinating_rejections");
import org.opensearch.index.ShardIndexingPressureSettings;  
        }  
        node2PrimaryRejections = node2AfterRejection.get("indexing_pressure.memory.total.primary_rejections");
            .put(super.nodeSettings(nodeOrdinal))
        shard2PrimaryRejections = shard2AfterShadowMode.get("rejection.primary.primary_rejections");
        Map<String, Object> shardStatsMap3 = XContentHelper.convertToMap(JsonXContent.jsonXContent, shardStats3.getEntity().getContent(),
            .get("shard_indexing_pressure.stats")).values());
        Integer shard2CoordinatingNodeRejections = shard2.get("rejection.coordinating.breakup.node_limits");  
        ArrayList<Object> values2 = new ArrayList<>(((Map<Object, Object>) shardStatsMap2.get("nodes")).values());
            assertThat(shard2CoordinatingBytes, greaterThan(0));
        final Response shardStats2 = getRestClient().performRequest(getShardStats2);
        shard1CoordinatingNodeRejections = shard1AfterShadowMode.get("rejection.coordinating.breakup_shadow_mode.node_limits");
        Integer node1ReplicaBytes = node1.get("indexing_pressure.memory.total.replica_in_bytes");
        Integer shard1CoordinatingRejections = shard1.get("rejection.coordinating.coordinating_rejections");  
        final Response shardStats3 = getRestClient().performRequest(getShardStats3);  
        if (node1CoordinatingRejections == 0) {  
        assertThat(node2CoordinatingRejections, equalTo(0));  
            shard2IndexingPressureValuesAfterRejection.get(0));
            true);
import org.opensearch.client.Response;  
            assertThat(shard2CoordinatingRejections, equalTo(1));
import static org.opensearch.core.rest.RestStatus.CREATED;
import org.opensearch.test.OpenSearchIntegTestCase;
            node2AfterShadowMode.get("shard_indexing_pressure.stats")).values());  
            assertThat(node1TotalLimitsRejections, equalTo(1));
        assertThat(shard1CoordinatingRejections, equalTo(0));
        Request shadowIndexingRequest = new Request("POST", "/index_name/_doc/");  
        node2CoordinatingRejections = node2AfterRejection.get("indexing_pressure.memory.total.coordinating_rejections");  
import org.opensearch.common.xcontent.json.JsonXContent;
        shard2CoordinatingNodeRejections = shard2AfterRejection.get("rejection.coordinating.breakup.node_limits");
        XContentTestUtils.JsonMapView node2 = new XContentTestUtils.JsonMapView((Map<String, Object>) values1.get(1));
        shard2PrimaryRejections = shard2AfterRejection.get("rejection.primary.primary_rejections");
        XContentTestUtils.JsonMapView node1AfterShadowMode = new XContentTestUtils.JsonMapView((Map<String, Object>)
        Integer node2TotalLimitsRejections = node2.get("shard_indexing_pressure.total_rejections_breakup.node_limits");  
            assertThat(shard2ReplicaBytes, lessThan(1024));
            assertThat(node1ReplicaBytes, lessThan(1024));
        } else {
        XContentTestUtils.JsonMapView node2AfterRejection = new XContentTestUtils.JsonMapView((Map<String, Object>) values2.get(1));
        Map<String, Object> shardStatsMap1 = XContentHelper.convertToMap(JsonXContent.jsonXContent, shardStats1.getEntity().getContent(),
        Integer node1CombinedBytes = node1.get("indexing_pressure.memory.total.combined_coordinating_and_primary_in_bytes");  
        Integer shard2PrimaryBytes = shard2.get("memory.total.primary_in_bytes");
        assertThat(node2PrimaryRejections, equalTo(0));
        } else {  
 * SPDX-License-Identifier: Apache-2.0
    @Override
            assertThat(shard1PrimaryBytes, greaterThan(0));  
        Request getShardStats3 = new Request("GET", "/_nodes/stats/shard_indexing_pressure?include_all");
        ArrayList<Object> shard2IndexingPressureValuesAfterRejection = new ArrayList<>(((Map<Object, Object>) node2AfterRejection  
            assertThat(shard1CoordinatingBytes, greaterThan(0));
        shard2CoordinatingNodeRejections = shard2AfterShadowMode.get("rejection.coordinating.breakup_shadow_mode.node_limits");
            true);  
public class ShardIndexingPressureRestIT extends HttpSmokeTestCase {
    }  
        assertThat(values2.size(), equalTo(2));
        ResponseException exception = expectThrows(ResponseException.class, () -> getRestClient().performRequest(failedIndexingRequest));  
        node1CoordinatingRejections = node1AfterRejection.get("indexing_pressure.memory.total.coordinating_rejections");  
        Map<String, Object> nodeStatsMap = XContentHelper.convertToMap(JsonXContent.jsonXContent, nodeStats.getEntity().getContent(), true);
        ArrayList<Object> values3 = new ArrayList<>(((Map<Object, Object>) shardStatsMap3.get("nodes")).values());  
/*  
            true);  
        } else {  
        XContentTestUtils.JsonMapView node1AfterRejection = new XContentTestUtils.JsonMapView((Map<String, Object>) values2.get(0));  
        assertThat(shard1IndexingPressureValues.size(), equalTo(1));  
        node2TotalLimitsRejections = node2AfterRejection.get("shard_indexing_pressure.total_rejections_breakup.node_limits");
        node1PrimaryRejections = node1.get("indexing_pressure.memory.total.primary_rejections");
            shard1IndexingPressureValuesAfterShadowMode.get(0));
            shard1IndexingPressureValuesAfterRejection.get(0));
        final Response indexCreatedResponse = getRestClient().performRequest(createRequest);
        ArrayList<Object> shard2IndexingPressureValuesAfterShadowMode = new ArrayList<>(((Map<Object, Object>)
        Request getShardStats1 = new Request("GET", "/_nodes/stats/shard_indexing_pressure?include_all");  
import org.opensearch.client.Request;
            assertThat(shard2ReplicaBytes, equalTo(0));  
        shard2CoordinatingRejections = shard2AfterShadowMode.get("rejection.coordinating.coordinating_rejections");  
    }  
        assertThat(values2.size(), equalTo(2));
            shard2IndexingPressureValuesAfterShadowMode.get(0));  
            assertThat(shard1CoordinatingBytes, lessThan(1024));
        XContentTestUtils.JsonMapView shard2 = new XContentTestUtils.JsonMapView((Map<String, Object>) shard2IndexingPressureValues.get(0));
        Integer shard1CoordinatingNodeRejections = shard1.get("rejection.coordinating.breakup.node_limits");
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)  
        //Reset persistent setting to clear cluster metadata
        Integer shard1ReplicaBytes = shard1.get("memory.total.replica_in_bytes");
package org.opensearch.http;
        node2 = new XContentTestUtils.JsonMapView((Map<String, Object>) values1.get(1));
        if (shard1CoordinatingRejections == 0) {
        Integer shard2ReplicaBytes = shard2.get("memory.total.replica_in_bytes");  
@AwaitsFix(bugUrl = "flaky test - enable after fix")
import static org.hamcrest.Matchers.lessThan;  
        assertThat(node1PrimaryRejections, equalTo(0));  
            ".node_limits");
        assertThat(shard1PrimaryRejections, equalTo(0));
            assertThat(shard1CoordinatingRejections, equalTo(1));  
        updateSettingRequest = new Request("PUT", "/_cluster/settings");  
        assertThat(shard2IndexingPressureValuesAfterRejection.size(), equalTo(1));
        ArrayList<Object> values1 = new ArrayList<>(((Map<Object, Object>) shardStatsMap1.get("nodes")).values());
 */  
import java.util.ArrayList;
        shard1CoordinatingNodeRejections = shard1AfterRejection.get("rejection.coordinating.breakup.node_limits");  
        }
        assertThat(shard1IndexingPressureValuesAfterRejection.size(), equalTo(1));  
        final Response shardStats1 = getRestClient().performRequest(getShardStats1);
        return Settings.builder()  
        }  
        assertThat(node2TotalLimitsRejections, equalTo(0));
            assertThat(node2TotalLimitsRejections, equalTo(1));
        Request failedIndexingRequest = new Request("POST", "/index_name/_doc/");  
        Integer shard1PrimaryBytes = shard1.get("memory.total.primary_in_bytes");
            ".node_limits");
        } else {
        assertThat(shard2CoordinatingRejections, equalTo(0));  
import org.opensearch.client.ResponseException;
        assertThat(exception.getResponse().getStatusLine().getStatusCode(), equalTo(TOO_MANY_REQUESTS.getStatus()));
        Integer node2PrimaryRejections = node2.get("indexing_pressure.memory.total.primary_rejections");
        Request createRequest = new Request("PUT", "/index_name");
            assertThat(node1CoordinatingRejections, equalTo(1));  
        assertThat(updateSettingResponse.getStatusLine().getStatusCode(), equalTo(OK.getStatus()));
            assertThat(node1PrimaryBytes, lessThan(1024));
            assertThat(shard1CoordinatingRejections, equalTo(1));  
 * Copyright OpenSearch Contributors.
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
        successfulIndexingRequest.setJsonEntity("{\"x\": \"small text\"}");
            assertThat(node2IndexingBytes, greaterThan(0));
import static org.opensearch.core.rest.RestStatus.TOO_MANY_REQUESTS;  
        if (shard1CoordinatingBytes == 0) {  
            .get("shard_indexing_pressure.stats")).values());
        assertThat(indexCreatedResponse.getStatusLine().getStatusCode(), equalTo(OK.getStatus()));
        assertThat(values1.size(), equalTo(2));
        Integer node2IndexingBytes = node2.get("indexing_pressure.memory.total.combined_coordinating_and_primary_in_bytes");  
        Integer node2CoordinatingRejections = node2.get("indexing_pressure.memory.total.coordinating_rejections");  
        Integer shard2PrimaryRejections = shard2.get("rejection.primary.primary_rejections");
            assertThat(node2PrimaryBytes, lessThan(1024));
        Map<String, Object> nodeStatsMap2 = XContentHelper.convertToMap(JsonXContent.jsonXContent, nodeStats2.getEntity().getContent(),
    public void testShardIndexingPressureStats() throws Exception {  
import static org.opensearch.core.rest.RestStatus.OK;
            .values());  
        assertThat(indexSuccessFul.getStatusLine().getStatusCode(), equalTo(CREATED.getStatus()));
        getRestClient().performRequest(updateSettingRequest);
        Request getNodeStats = new Request("GET", "/_nodes/stats/indexing_pressure");  
        shard2CoordinatingRejections = shard2AfterRejection.get("rejection.coordinating.coordinating_rejections");  
        XContentTestUtils.JsonMapView shard1 = new XContentTestUtils.JsonMapView((Map<String, Object>) shard1IndexingPressureValues.get(0));
        assertThat(node1PrimaryRejections, equalTo(0));
        node2AfterRejection = new XContentTestUtils.JsonMapView((Map<String, Object>) values2.get(1));
            assertThat(node2TotalLimitsRejections, equalTo(1));
        Request getShardStats2 = new Request("GET", "/_nodes/stats/shard_indexing_pressure?include_all");  
        node1TotalLimitsRejections = node1AfterShadowMode.get("shard_indexing_pressure.total_rejections_breakup_shadow_mode" +  
        updateSettingRequest.setJsonEntity("{\"persistent\": {\"shard_indexing_pressure\": {\"enforced\": \"false\"}}}");
        Request getNodeStats2 = new Request("GET", "/_nodes/stats/indexing_pressure");
        assertThat(shard1PrimaryRejections, equalTo(0));
}
        Request successfulIndexingRequest = new Request("POST", "/index_name/_doc/");
        final Response nodeStats = getRestClient().performRequest(getNodeStats);
import org.opensearch.index.IndexingPressure;
import org.opensearch.common.settings.Settings;
            assertThat(node2ReplicaBytes, equalTo(0));  
        shard1CoordinatingRejections = shard1AfterRejection.get("rejection.coordinating.coordinating_rejections");
 */
        XContentTestUtils.JsonMapView shard1AfterRejection = new XContentTestUtils.JsonMapView((Map<String, Object>)
            .values());
        Map<String, Object> shardStatsMap2 = XContentHelper.convertToMap(JsonXContent.jsonXContent, shardStats2.getEntity().getContent(),
import org.opensearch.test.XContentTestUtils;
        // Update cluster setting to enable shadow mode  
import static org.hamcrest.Matchers.equalTo;
            assertThat(shard2CoordinatingBytes, lessThan(1024));
        values2 = new ArrayList<>(((Map<Object, Object>) nodeStatsMap2.get("nodes")).values());  
        assertThat(node2PrimaryRejections, equalTo(0));
import org.opensearch.common.xcontent.XContentHelper;  
        updateSettingRequest.setJsonEntity("{\"persistent\": {\"shard_indexing_pressure\": {\"enforced\": null}}}");
        final Response indexSuccessFul = getRestClient().performRequest(successfulIndexingRequest);  
            assertThat(shard2CoordinatingNodeRejections, equalTo(1));  
        XContentTestUtils.JsonMapView node1 = new XContentTestUtils.JsonMapView((Map<String, Object>) values1.get(0));  
            assertThat(node1TotalLimitsRejections, equalTo(1));
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, supportsDedicatedMasters = false, numDataNodes = 2,
        ArrayList<Object> shard1IndexingPressureValuesAfterShadowMode = new ArrayList<>(((Map<Object, Object>)
/**
import java.util.Map;
            assertThat(shard1CoordinatingNodeRejections, equalTo(1));
            assertThat(node2IndexingBytes, lessThan(1024));
        } else {
        XContentTestUtils.JsonMapView node2AfterShadowMode = new XContentTestUtils.JsonMapView((Map<String, Object>)  
        if (node1ReplicaBytes == 0) {
        String largeString = randomAlphaOfLength(10000);
        Integer node1PrimaryBytes = node1.get("indexing_pressure.memory.total.primary_in_bytes");
            assertThat(node1PrimaryBytes, greaterThan(0));  
        if (node1CombinedBytes == 0) {  
    numClientNodes = 0)  
            .build();
        assertThat(shard2IndexingPressureValues.size(), equalTo(1));
 * Test Shard Indexing Pressure Metrics and Statistics  
        assertThat(node1CoordinatingRejections, equalTo(0));
        assertThat(shard2IndexingPressureValuesAfterShadowMode.size(), equalTo(1));
        XContentTestUtils.JsonMapView shard2AfterShadowMode = new XContentTestUtils.JsonMapView((Map<String, Object>)
            assertThat(shard2PrimaryBytes, greaterThan(0));  
            assertThat(shard2CoordinatingNodeRejections, equalTo(1));  
        }
        shard1PrimaryRejections = shard1AfterShadowMode.get("rejection.primary.primary_rejections");  
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), true)
            assertThat(node2PrimaryBytes, greaterThan(0));  
        ArrayList<Object> shard1IndexingPressureValues = new ArrayList<>(((Map<Object, Object>) node1.get("shard_indexing_pressure.stats"))
        final Response shadowIndexingResponse = getRestClient().performRequest(shadowIndexingRequest);
    protected Settings nodeSettings(int nodeOrdinal) {
        node1 = new XContentTestUtils.JsonMapView((Map<String, Object>) values1.get(0));
            values3.get(0));  
            "\"write.wait_for_active_shards\": 2}}}");  
    @SuppressWarnings("unchecked")
        final Response nodeStats2 = getRestClient().performRequest(getNodeStats2);  
        ArrayList<Object> shard2IndexingPressureValues = new ArrayList<>(((Map<Object, Object>) node2.get("shard_indexing_pressure.stats"))
        Integer shard1CoordinatingBytes = shard1.get("memory.total.coordinating_in_bytes");  
        shard1PrimaryRejections = shard1AfterRejection.get("rejection.primary.primary_rejections");
        assertThat(values1.size(), equalTo(2));
            assertThat(node2ReplicaBytes, greaterThan(0));  
import static org.hamcrest.Matchers.greaterThan;
        shadowIndexingRequest.setJsonEntity("{\"x\": \"text\"}");
        assertThat(values3.size(), equalTo(2));
            assertThat(shard2CoordinatingRejections, equalTo(1));
            assertThat(shard1ReplicaBytes, lessThan(1024));
        } else {
