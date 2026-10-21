        node2AfterRejection = new XContentTestUtils.JsonMapView((Map<String, Object>) values2.get(1));
        final Response shardStats3 = getRestClient().performRequest(getShardStats3);
        getRestClient().performRequest(updateSettingRequest);
        }
        Integer node1ReplicaBytes = node1.get("indexing_pressure.memory.total.replica_in_bytes");
/**
        assertThat(shard2IndexingPressureValuesAfterRejection.size(), equalTo(1));
        assertThat(shard1IndexingPressureValuesAfterRejection.size(), equalTo(1));
        Integer node1PrimaryBytes = node1.get("indexing_pressure.memory.total.primary_in_bytes");
        ArrayList<Object> shard2IndexingPressureValuesAfterRejection = new ArrayList<>(((Map<Object, Object>) node2AfterRejection
            assertThat(node2PrimaryBytes, greaterThan(0));
        shard2CoordinatingRejections = shard2AfterRejection.get("rejection.coordinating.coordinating_rejections");
        }
        assertThat(shard1CoordinatingNodeRejections, equalTo(0));
import org.opensearch.index.IndexingPressure;
            assertThat(node2ReplicaBytes, equalTo(0));
        ArrayList<Object> values2 = new ArrayList<>(((Map<Object, Object>) shardStatsMap2.get("nodes")).values());
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
            .values());
        if (shard1CoordinatingRejections == 0) {
            assertThat(shard1PrimaryBytes, greaterThan(0));
        assertThat(shard2PrimaryRejections, equalTo(0));
            true);
            assertThat(node2IndexingBytes, lessThan(1024));
import java.util.Map;
        assertThat(shard1IndexingPressureValuesAfterShadowMode.size(), equalTo(1));
public class ShardIndexingPressureRestIT extends HttpSmokeTestCase {
        assertThat(indexSuccessFul.getStatusLine().getStatusCode(), equalTo(CREATED.getStatus()));
        XContentTestUtils.JsonMapView node2 = new XContentTestUtils.JsonMapView((Map<String, Object>) values1.get(1));
        assertThat(shard1CoordinatingRejections, equalTo(0));
        XContentTestUtils.JsonMapView node2AfterRejection = new XContentTestUtils.JsonMapView((Map<String, Object>) values2.get(1));
            assertThat(node1CombinedBytes, lessThan(1024));
        Map<String, Object> nodeStatsMap = XContentHelper.convertToMap(JsonXContent.jsonXContent, nodeStats.getEntity().getContent(), true);
    }
            shard2IndexingPressureValuesAfterShadowMode.get(0));
        XContentTestUtils.JsonMapView shard1 = new XContentTestUtils.JsonMapView((Map<String, Object>) shard1IndexingPressureValues.get(0));
        assertThat(node2PrimaryRejections, equalTo(0));
        node2TotalLimitsRejections = node2AfterRejection.get("shard_indexing_pressure.total_rejections_breakup.node_limits");
        shard1CoordinatingRejections = shard1AfterShadowMode.get("rejection.coordinating.coordinating_rejections");
        updateSettingRequest.setJsonEntity("{\"persistent\": {\"shard_indexing_pressure\": {\"enforced\": null}}}");
        return Settings.builder()
import org.opensearch.test.XContentTestUtils;
        node2TotalLimitsRejections = node2AfterShadowMode.get("shard_indexing_pressure.total_rejections_breakup_shadow_mode" +
        shard1PrimaryRejections = shard1AfterRejection.get("rejection.primary.primary_rejections");
        assertThat(shard1IndexingPressureValues.size(), equalTo(1));
            assertThat(node2PrimaryBytes, lessThan(1024));
        XContentTestUtils.JsonMapView shard2 = new XContentTestUtils.JsonMapView((Map<String, Object>) shard2IndexingPressureValues.get(0));
    @Override
        Integer shard1CoordinatingNodeRejections = shard1.get("rejection.coordinating.breakup.node_limits");
        XContentTestUtils.JsonMapView node1 = new XContentTestUtils.JsonMapView((Map<String, Object>) values1.get(0));
        Map<String, Object> shardStatsMap3 = XContentHelper.convertToMap(JsonXContent.jsonXContent, shardStats3.getEntity().getContent(),
        }
            assertThat(node1ReplicaBytes, lessThan(1024));
        assertThat(node2CoordinatingRejections, equalTo(0));
        final Response indexSuccessFul = getRestClient().performRequest(successfulIndexingRequest);
import org.opensearch.client.ResponseException;
        Integer node2PrimaryRejections = node2.get("indexing_pressure.memory.total.primary_rejections");
        shard1CoordinatingNodeRejections = shard1AfterShadowMode.get("rejection.coordinating.breakup_shadow_mode.node_limits");
@AwaitsFix(bugUrl = "flaky test - enable after fix")
 * SPDX-License-Identifier: Apache-2.0
        assertThat(values1.size(), equalTo(2));
        assertThat(node1CoordinatingRejections, equalTo(0));
        ArrayList<Object> shard2IndexingPressureValuesAfterShadowMode = new ArrayList<>(((Map<Object, Object>)
        assertThat(node1TotalLimitsRejections, equalTo(0));
            values3.get(1));
        assertThat(node1PrimaryRejections, equalTo(0));
        assertThat(shard1PrimaryRejections, equalTo(0));
        Integer shard2CoordinatingBytes = shard2.get("memory.total.coordinating_in_bytes");
        assertThat(shard2PrimaryRejections, equalTo(0));
        XContentTestUtils.JsonMapView node1AfterShadowMode = new XContentTestUtils.JsonMapView((Map<String, Object>)
        Request successfulIndexingRequest = new Request("POST", "/index_name/_doc/");
        assertThat(exception.getResponse().getStatusLine().getStatusCode(), equalTo(TOO_MANY_REQUESTS.getStatus()));
            .build();
            assertThat(shard1CoordinatingRejections, equalTo(1));
import org.opensearch.client.Response;
        XContentTestUtils.JsonMapView shard2AfterShadowMode = new XContentTestUtils.JsonMapView((Map<String, Object>)
        Integer node2IndexingBytes = node2.get("indexing_pressure.memory.total.combined_coordinating_and_primary_in_bytes");
            shard1IndexingPressureValuesAfterRejection.get(0));
        assertThat(values2.size(), equalTo(2));
/*
        Integer node1CoordinatingRejections = node1.get("indexing_pressure.memory.total.coordinating_rejections");
        assertThat(updateSettingResponse.getStatusLine().getStatusCode(), equalTo(OK.getStatus()));
            assertThat(shard1PrimaryBytes, lessThan(1024));
            .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), "1KB")
        assertThat(values1.size(), equalTo(2));
            true);
        Integer node2TotalLimitsRejections = node2.get("shard_indexing_pressure.total_rejections_breakup.node_limits");
        node1PrimaryRejections = node1.get("indexing_pressure.memory.total.primary_rejections");
        assertThat(shard2IndexingPressureValuesAfterShadowMode.size(), equalTo(1));
            assertThat(shard1CoordinatingBytes, lessThan(1024));
import java.util.ArrayList;
import static org.opensearch.core.rest.RestStatus.CREATED;
            assertThat(node2CoordinatingRejections, equalTo(1));
        XContentTestUtils.JsonMapView shard2AfterRejection = new XContentTestUtils.JsonMapView((Map<String, Object>)
        if (node1CombinedBytes == 0) {
        assertThat(node2PrimaryRejections, equalTo(0));
        node2CoordinatingRejections = node2AfterRejection.get("indexing_pressure.memory.total.coordinating_rejections");
            assertThat(shard2PrimaryBytes, lessThan(1024));
            assertThat(shard1CoordinatingRejections, equalTo(1));
            assertThat(shard2ReplicaBytes, greaterThan(0));
            assertThat(shard2CoordinatingRejections, equalTo(1));
            ".node_limits");
        Request createRequest = new Request("PUT", "/index_name");
}
        final Response shardStats1 = getRestClient().performRequest(getShardStats1);
        XContentTestUtils.JsonMapView node2AfterShadowMode = new XContentTestUtils.JsonMapView((Map<String, Object>)
        Integer shard2ReplicaBytes = shard2.get("memory.total.replica_in_bytes");
        Integer shard1CoordinatingRejections = shard1.get("rejection.coordinating.coordinating_rejections");
        XContentTestUtils.JsonMapView node1AfterRejection = new XContentTestUtils.JsonMapView((Map<String, Object>) values2.get(0));
import org.opensearch.client.Request;
        node2 = new XContentTestUtils.JsonMapView((Map<String, Object>) values1.get(1));
            assertThat(shard2CoordinatingBytes, lessThan(1024));
import static org.hamcrest.Matchers.equalTo;
        Integer shard2CoordinatingRejections = shard2.get("rejection.coordinating.coordinating_rejections");
        assertThat(shadowIndexingResponse.getStatusLine().getStatusCode(), equalTo(CREATED.getStatus()));
        } else {
        successfulIndexingRequest.setJsonEntity("{\"x\": \"small text\"}");
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
        } else {
        assertThat(shard2PrimaryRejections, equalTo(0));
        } else {
            assertThat(node2IndexingBytes, greaterThan(0));
            assertThat(shard2CoordinatingRejections, equalTo(1));
    @SuppressWarnings("unchecked")
        Map<String, Object> shardStatsMap1 = XContentHelper.convertToMap(JsonXContent.jsonXContent, shardStats1.getEntity().getContent(),
        XContentTestUtils.JsonMapView shard1AfterShadowMode = new XContentTestUtils.JsonMapView((Map<String, Object>)
        failedIndexingRequest.setJsonEntity("{\"x\": " + largeString + "}");
        Integer shard2CoordinatingNodeRejections = shard2.get("rejection.coordinating.breakup.node_limits");
            .values());
        ArrayList<Object> shard1IndexingPressureValuesAfterShadowMode = new ArrayList<>(((Map<Object, Object>)
    public void testShardIndexingPressureStats() throws Exception {
        Integer shard1CoordinatingBytes = shard1.get("memory.total.coordinating_in_bytes");
    protected Settings nodeSettings(int nodeOrdinal) {
            assertThat(node1CombinedBytes, greaterThan(0));
        final Response shardStats2 = getRestClient().performRequest(getShardStats2);
        assertThat(shard1PrimaryRejections, equalTo(0));
            assertThat(shard1CoordinatingNodeRejections, equalTo(1));
        if (shard1CoordinatingRejections == 0) {
    }
 */
        ResponseException exception = expectThrows(ResponseException.class, () -> getRestClient().performRequest(failedIndexingRequest));
        Integer shard1PrimaryBytes = shard1.get("memory.total.primary_in_bytes");
import org.opensearch.common.xcontent.XContentHelper;
        }
            assertThat(shard2ReplicaBytes, equalTo(0));
package org.opensearch.http;
        //Reset persistent setting to clear cluster metadata
            assertThat(shard1CoordinatingNodeRejections, equalTo(1));
        assertThat(node1PrimaryRejections, equalTo(0));
        Integer shard1PrimaryRejections = shard1.get("rejection.primary.primary_rejections");
        Integer node2PrimaryBytes = node2.get("indexing_pressure.memory.total.primary_in_bytes");
        values2 = new ArrayList<>(((Map<Object, Object>) nodeStatsMap2.get("nodes")).values());
        shadowIndexingRequest.setJsonEntity("{\"x\": \"text\"}");
        // Update cluster setting to enable shadow mode
        Request getShardStats2 = new Request("GET", "/_nodes/stats/shard_indexing_pressure?include_all");
            assertThat(shard2PrimaryBytes, greaterThan(0));
        Request getNodeStats = new Request("GET", "/_nodes/stats/indexing_pressure");
            values3.get(0));
import org.opensearch.index.ShardIndexingPressureSettings;
    numClientNodes = 0)
        shard2PrimaryRejections = shard2AfterRejection.get("rejection.primary.primary_rejections");
        Request updateSettingRequest = new Request("PUT", "/_cluster/settings");
        if (shard1CoordinatingBytes == 0) {
        Integer shard1ReplicaBytes = shard1.get("memory.total.replica_in_bytes");
            assertThat(shard2CoordinatingNodeRejections, equalTo(1));
        ArrayList<Object> shard2IndexingPressureValues = new ArrayList<>(((Map<Object, Object>) node2.get("shard_indexing_pressure.stats"))
        Map<String, Object> nodeStatsMap2 = XContentHelper.convertToMap(JsonXContent.jsonXContent, nodeStats2.getEntity().getContent(),
            shard1IndexingPressureValuesAfterShadowMode.get(0));
        Integer node2CoordinatingRejections = node2.get("indexing_pressure.memory.total.coordinating_rejections");
        final Response shadowIndexingResponse = getRestClient().performRequest(shadowIndexingRequest);
 * Copyright OpenSearch Contributors.
        } else {
        Integer shard2PrimaryBytes = shard2.get("memory.total.primary_in_bytes");
        assertThat(shard2IndexingPressureValues.size(), equalTo(1));
            assertThat(node2ReplicaBytes, lessThan(1024));
import static org.opensearch.core.rest.RestStatus.TOO_MANY_REQUESTS;
        }
        assertThat(shard1PrimaryRejections, equalTo(0));
        Request getShardStats1 = new Request("GET", "/_nodes/stats/shard_indexing_pressure?include_all");
            assertThat(shard2CoordinatingBytes, greaterThan(0));
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), true)
import org.opensearch.test.OpenSearchIntegTestCase;
        shard1CoordinatingRejections = shard1AfterRejection.get("rejection.coordinating.coordinating_rejections");
        node1TotalLimitsRejections = node1AfterRejection.get("shard_indexing_pressure.total_rejections_breakup.node_limits");
        shard2CoordinatingNodeRejections = shard2AfterRejection.get("rejection.coordinating.breakup.node_limits");
        shard2PrimaryRejections = shard2AfterShadowMode.get("rejection.primary.primary_rejections");
        XContentTestUtils.JsonMapView shard1AfterRejection = new XContentTestUtils.JsonMapView((Map<String, Object>)
            shard2IndexingPressureValuesAfterRejection.get(0));
        Integer node1CombinedBytes = node1.get("indexing_pressure.memory.total.combined_coordinating_and_primary_in_bytes");
            assertThat(node1PrimaryBytes, greaterThan(0));
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, supportsDedicatedMasters = false, numDataNodes = 2,
            .put(super.nodeSettings(nodeOrdinal))
        assertThat(node2TotalLimitsRejections, equalTo(0));
        assertThat(values3.size(), equalTo(2));
            assertThat(shard2ReplicaBytes, lessThan(1024));
        final Response updateSettingResponse = getRestClient().performRequest(updateSettingRequest);
        createRequest.setJsonEntity("{\"settings\": {\"index\": {\"number_of_shards\": 1, \"number_of_replicas\": 1, " +
        shard2CoordinatingRejections = shard2AfterShadowMode.get("rejection.coordinating.coordinating_rejections");
        if (node1ReplicaBytes == 0) {
            assertThat(node2ReplicaBytes, greaterThan(0));
import org.opensearch.common.xcontent.json.JsonXContent;
        updateSettingRequest.setJsonEntity("{\"persistent\": {\"shard_indexing_pressure\": {\"enforced\": \"false\"}}}");
            assertThat(shard2CoordinatingNodeRejections, equalTo(1));
        Request getNodeStats2 = new Request("GET", "/_nodes/stats/indexing_pressure");
        assertThat(indexCreatedResponse.getStatusLine().getStatusCode(), equalTo(OK.getStatus()));
        Integer shard2PrimaryRejections = shard2.get("rejection.primary.primary_rejections");
        values1 = new ArrayList<>(((Map<Object, Object>) nodeStatsMap.get("nodes")).values());
        assertThat(values2.size(), equalTo(2));
        shard1CoordinatingNodeRejections = shard1AfterRejection.get("rejection.coordinating.breakup.node_limits");
            true);
import static org.opensearch.core.rest.RestStatus.OK;
            assertThat(node1PrimaryBytes, lessThan(1024));
        if (node1CoordinatingRejections == 0) {
        }
        final Response indexCreatedResponse = getRestClient().performRequest(createRequest);
            ".node_limits");
        shard1PrimaryRejections = shard1AfterShadowMode.get("rejection.primary.primary_rejections");
            node1AfterShadowMode.get("shard_indexing_pressure.stats")).values());
            assertThat(shard1ReplicaBytes, lessThan(1024));
        shard2CoordinatingNodeRejections = shard2AfterShadowMode.get("rejection.coordinating.breakup_shadow_mode.node_limits");
        }
        } else {
        } else {
        updateSettingRequest = new Request("PUT", "/_cluster/settings");
            "\"write.wait_for_active_shards\": 2}}}");
        Request failedIndexingRequest = new Request("POST", "/index_name/_doc/");
        node2PrimaryRejections = node2AfterRejection.get("indexing_pressure.memory.total.primary_rejections");
 * Test Shard Indexing Pressure Metrics and Statistics
            node2AfterShadowMode.get("shard_indexing_pressure.stats")).values());
            assertThat(node1TotalLimitsRejections, equalTo(1));
        ArrayList<Object> shard1IndexingPressureValues = new ArrayList<>(((Map<Object, Object>) node1.get("shard_indexing_pressure.stats"))
        final Response nodeStats2 = getRestClient().performRequest(getNodeStats2);
import org.opensearch.common.settings.Settings;
        String largeString = randomAlphaOfLength(10000);
            assertThat(shard1CoordinatingBytes, greaterThan(0));
            assertThat(node1CoordinatingRejections, equalTo(1));
        final Response nodeStats = getRestClient().performRequest(getNodeStats);
        Integer node1TotalLimitsRejections = node1.get("shard_indexing_pressure.total_rejections_breakup.node_limits");
            .get("shard_indexing_pressure.stats")).values());
            .get("shard_indexing_pressure.stats")).values());
        node1CoordinatingRejections = node1AfterRejection.get("indexing_pressure.memory.total.coordinating_rejections");
        ArrayList<Object> shard1IndexingPressureValuesAfterRejection = new ArrayList<>(((Map<Object, Object>) node1AfterRejection
            assertThat(node2TotalLimitsRejections, equalTo(1));
        Map<String, Object> shardStatsMap2 = XContentHelper.convertToMap(JsonXContent.jsonXContent, shardStats2.getEntity().getContent(),
            assertThat(node2TotalLimitsRejections, equalTo(1));
        Integer node2ReplicaBytes = node2.get("indexing_pressure.memory.total.replica_in_bytes");
        ArrayList<Object> values3 = new ArrayList<>(((Map<Object, Object>) shardStatsMap3.get("nodes")).values());
        ArrayList<Object> values1 = new ArrayList<>(((Map<Object, Object>) shardStatsMap1.get("nodes")).values());
 */
        } else {
            true);
        assertThat(shard2CoordinatingRejections, equalTo(0));
import static org.hamcrest.Matchers.greaterThan;
        Integer node1PrimaryRejections = node1.get("indexing_pressure.memory.total.primary_rejections");
        Request shadowIndexingRequest = new Request("POST", "/index_name/_doc/");
        node1 = new XContentTestUtils.JsonMapView((Map<String, Object>) values1.get(0));
        node1TotalLimitsRejections = node1AfterShadowMode.get("shard_indexing_pressure.total_rejections_breakup_shadow_mode" +
            assertThat(node1TotalLimitsRejections, equalTo(1));
        Request getShardStats3 = new Request("GET", "/_nodes/stats/shard_indexing_pressure?include_all");
        node1AfterRejection = new XContentTestUtils.JsonMapView((Map<String, Object>) values2.get(0));
import static org.hamcrest.Matchers.lessThan;
        if (shard1ReplicaBytes == 0) {
