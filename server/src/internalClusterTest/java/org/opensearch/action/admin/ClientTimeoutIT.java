        );
        MockTransportService mockTransportServiceAnotherNode = ((MockTransportService) internalCluster().getInstance(
import org.opensearch.action.admin.indices.recovery.RecoveryResponse;
            connection.sendRequest(requestId, action, request, options);
            nodes.add(node.getNode().getName());
            prepareCreate(
        String anotherDataNode = internalCluster().startDataOnlyNode();
        String anotherDataNode = internalCluster().startDataOnlyNode();
        refresh("test-index");
        TimeValue timeout = TimeValue.timeValueMillis(1000);
        simulateTimeoutAtTransport(dataNode, anotherDataNode, NodesStatsAction.NAME);
        assertAcked(
        String dataNode = internalCluster().startDataOnlyNode();
        mockTransportService.addSendBehavior(internalCluster().getInstance(TransportService.class, anotherDataNode), sendBehaviour);
        final long numDocs = scaledRandomIntBetween(50, 100);
            TransportService.class,
        ));
                Settings.builder()
    protected Collection<Class<? extends Plugin>> nodePlugins() {
 * The OpenSearch Contributors require contributions made to
    }
        assertThat(indicesStats.getShardFailures()[0].reason(), containsString("ReceiveTimeoutTransportException"));
        int numShards = 4;
                Settings.builder()
        String dataNode = internalCluster().startDataOnlyNode();
            )
import org.opensearch.action.admin.cluster.node.info.NodesInfoResponse;
        simulateTimeoutAtTransport(dataNode, anotherDataNode, NodesInfoAction.NAME);
 * this file be licensed under the Apache-2.0 license or a
        // One bad data node
        // simulate timeout on bad node.
                    .put("number_of_replicas", 0)
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
import static org.hamcrest.Matchers.lessThan;
        // verify indices state response with bad node.
        assertThat(response1.getNodes().size(), equalTo(3));
        assertThat(recoveryResponse.getShardFailures()[0].reason(), containsString("ReceiveTimeoutTransportException"));
import org.opensearch.plugins.Plugin;
        internalCluster().startClusterManagerOnlyNode();
    }
        final long numDocs = scaledRandomIntBetween(50, 100);
    }
        for (int i = 0; i < numDocs; i++) {
        // Happy case
        }
import org.opensearch.test.transport.MockTransportService;
            }
import static org.hamcrest.Matchers.containsString;
            index("test-index", "doc", Integer.toString(i));
        assertNull(response.getPerNodeTasks().get(anotherDataNode));
        simulateTimeoutAtTransport(dataNode, anotherDataNode, NodesStatsAction.NAME);
        ArrayList<String> nodes = new ArrayList<String>();
        refresh("test-index");
    public void testListTasksTimeout() {
        // One bad data node
                "test-index",
        TimeValue timeout = TimeValue.timeValueMillis(1000);
        mockTransportServiceAnotherNode.addSendBehavior(internalCluster().getInstance(TransportService.class, dataNode), sendBehaviour);
        assertThat(response.getNodes().size(), equalTo(2));
    }
        assertThat(nodes.contains(clusterManagerNode), is(true));
                0,
                "test-index",
        assertThat(nodes.contains(clusterManagerNode), is(true));
    public void testRecoveriesWithTimeout() {
package org.opensearch.action.admin;
public class ClientTimeoutIT extends OpenSearchIntegTestCase {
import org.opensearch.test.transport.StubbableTransport;
 * compatible open source license.
        assertThat(indicesStats.getTotalShards(), equalTo(numShards));
        RecoveryResponse recoveryResponse = dataNodeClient().admin().indices().prepareRecoveries().get();
        StubbableTransport.SendRequestBehavior sendBehaviour = (connection, requestId, action, request, options) -> {
                    .put("number_of_shards", numShards)
        logger.info("-->  creating index");
 *
    }
        indicesStats = dataNodeClient().admin().indices().prepareStats().setDocs(true).get();
                    .put("routing.allocation.total_shards_per_node", 2)
/*
        String anotherDataNode = internalCluster().startDataOnlyNode();
        String anotherDataNode = internalCluster().startDataOnlyNode();
        // Happy case
        MockTransportService mockTransportService = ((MockTransportService) internalCluster().getInstance(
        internalCluster().startClusterManagerOnlyNode();
        assertThat(recoveryResponse.getTotalShards(), equalTo(numShards));
import java.util.Collections;
        simulateTimeoutAtTransport(dataNode, anotherDataNode, RecoveryAction.NAME);
import org.opensearch.test.OpenSearchIntegTestCase;
        for (int i = 0; i < numDocs; i++) {
            )
 * SPDX-License-Identifier: Apache-2.0
                throw new ReceiveTimeoutTransportException(connection.getNode(), action, "simulate timeout");
        String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();
        assertThat(indicesStats.getFailedShards(), equalTo(numShards / 2));
            anotherDataNode
                0,
    private void simulateTimeoutAtTransport(String dataNode, String anotherDataNode, String transportActionName) {
        }
        String dataNode = internalCluster().startDataOnlyNode();
import org.opensearch.action.admin.indices.stats.IndicesStatsAction;
        String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();
        assertThat(recoveryResponse.getFailedShards(), equalTo(numShards / 2));
        assertThat(indicesStats.getSuccessfulShards(), equalTo(numShards / 2));
        IndicesStatsResponse indicesStats = dataNodeClient().admin().indices().prepareStats().setDocs(true).get();
        }
                    .put("routing.allocation.total_shards_per_node", 2)
        // Happy case
        assertThat(response.getNodes().size(), equalTo(2));
        String dataNode = internalCluster().startDataOnlyNode();
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
import org.opensearch.transport.TransportService;
        }
        for (NodeInfo node : response.getNodes()) {
}
import org.opensearch.action.admin.cluster.node.stats.NodesStatsAction;
        assertThat(recoveryResponse.getSuccessfulShards(), equalTo(numShards / 2));
        String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();
            if (action.startsWith(transportActionName)) {
        recoveryResponse = dataNodeClient().admin().indices().prepareRecoveries().get();
        String dataNode = internalCluster().startDataOnlyNode();
        response = dataNodeClient().admin().cluster().prepareNodesInfo().get();
        assertAcked(
import org.opensearch.action.admin.cluster.node.info.NodesInfoAction;
import java.util.Collection;
                    .put("number_of_replicas", 0)
        NodesStatsResponse response1 = dataNodeClient().admin().cluster().prepareNodesStats().get();
import org.opensearch.action.admin.indices.recovery.RecoveryAction;
        assertThat(response.getNodes().size(), equalTo(3));
            TransportService.class,
import org.opensearch.common.settings.Settings;
import static org.hamcrest.Matchers.equalTo;
        ));
        ArrayList<String> nodes = new ArrayList<String>();
        String anotherDataNode = internalCluster().startDataOnlyNode();
        // verify response with bad node.
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
        int numShards = 4;
        ListTasksResponse response = dataNodeClient().admin().cluster().prepareListTasks().get();
            dataNode
        assertThat(recoveryResponse.getSuccessfulShards(), equalTo(numShards));
    public void testNodesStatsTimeout() {
                    .put("number_of_shards", numShards)
        // One bad data node
        assertThat(indicesStats.getTotalShards(), equalTo(numShards));
        ensureSearchable("test-index");
import org.opensearch.transport.ReceiveTimeoutTransportException;
            index("test-index", "doc", Integer.toString(i));
        for (NodeStats node : response.getNodes()) {
        ensureSearchable("test-index");
import static org.hamcrest.CoreMatchers.is;
    }
        // simulate timeout on bad node.
            prepareCreate(
        ensureGreen();
        NodesInfoResponse response = dataNodeClient().admin().cluster().prepareNodesInfo().get();
        // happy case
        assertThat(response1.getPerNodeTasks().keySet().size(), equalTo(3));
        simulateTimeoutAtTransport(dataNode, anotherDataNode, IndicesStatsAction.NAME);
import org.opensearch.common.unit.TimeValue;
        assertThat(indicesStats.getSuccessfulShards(), equalTo(numShards));
        ListTasksResponse response1 = dataNodeClient().admin().cluster().prepareListTasks().get();
        };
    }
            nodes.add(node.getNode().getName());
        NodesStatsResponse response = dataNodeClient().admin().cluster().prepareNodesStats().get();
        assertThat(recoveryResponse.getTotalShards(), equalTo(numShards));
        // Happy case
import org.opensearch.action.admin.cluster.node.info.NodeInfo;
        ensureGreen();
        assertThat(indicesStats.getTotal().getDocs().getCount(), lessThan(numDocs));
 */
        return Collections.singletonList(MockTransportService.TestPlugin.class);
import java.util.ArrayList;
        );
    @Override
    public void testNodesInfoTimeout() {
    public void testStatsWithTimeout() {
        // simulate timeout on bad node.
