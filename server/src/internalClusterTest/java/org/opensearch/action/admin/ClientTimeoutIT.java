import org.opensearch.test.OpenSearchIntegTestCase;  
        ArrayList<String> nodes = new ArrayList<String>();
        for (int i = 0; i < numDocs; i++) {
        refresh("test-index");
        response = dataNodeClient().admin().cluster().prepareNodesInfo().get();
        // simulate timeout on bad node.  
 *
import org.opensearch.common.unit.TimeValue;
        // One bad data node  
                    .put("routing.allocation.total_shards_per_node", 2)  
        assertThat(indicesStats.getTotalShards(), equalTo(numShards));
        assertThat(recoveryResponse.getTotalShards(), equalTo(numShards));
 * compatible open source license.
import org.opensearch.action.admin.cluster.node.stats.NodesStatsAction;
            prepareCreate(
        simulateTimeoutAtTransport(dataNode, anotherDataNode, NodesInfoAction.NAME);
    public void testStatsWithTimeout() {
        String dataNode = internalCluster().startDataOnlyNode();  
        // simulate timeout on bad node.  
        assertAcked(
        ListTasksResponse response = dataNodeClient().admin().cluster().prepareListTasks().get();  
        internalCluster().startClusterManagerOnlyNode();
            if (action.startsWith(transportActionName)) {
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
        assertThat(response1.getPerNodeTasks().keySet().size(), equalTo(3));
import org.opensearch.common.settings.Settings;  
    }  
import org.opensearch.transport.ReceiveTimeoutTransportException;  
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
        ensureSearchable("test-index");
        int numShards = 4;
        refresh("test-index");  
        assertThat(recoveryResponse.getSuccessfulShards(), equalTo(numShards));
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
        MockTransportService mockTransportServiceAnotherNode = ((MockTransportService) internalCluster().getInstance(
/*  
import static org.hamcrest.CoreMatchers.is;
                    .put("number_of_replicas", 0)
        for (NodeStats node : response.getNodes()) {
                0,  
        assertThat(response.getNodes().size(), equalTo(2));
        final long numDocs = scaledRandomIntBetween(50, 100);
            index("test-index", "doc", Integer.toString(i));
                    .put("number_of_replicas", 0)
        assertThat(indicesStats.getTotalShards(), equalTo(numShards));
        assertThat(recoveryResponse.getTotalShards(), equalTo(numShards));  
import java.util.Collection;
            prepareCreate(
        ArrayList<String> nodes = new ArrayList<String>();  
        );  
        StubbableTransport.SendRequestBehavior sendBehaviour = (connection, requestId, action, request, options) -> {
        TimeValue timeout = TimeValue.timeValueMillis(1000);  
        internalCluster().startClusterManagerOnlyNode();  
import org.opensearch.action.admin.cluster.node.info.NodesInfoResponse;  
                    .put("number_of_shards", numShards)  
        simulateTimeoutAtTransport(dataNode, anotherDataNode, RecoveryAction.NAME);
        assertThat(indicesStats.getShardFailures()[0].reason(), containsString("ReceiveTimeoutTransportException"));
            )  
        RecoveryResponse recoveryResponse = dataNodeClient().admin().indices().prepareRecoveries().get();
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;  
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
        MockTransportService mockTransportService = ((MockTransportService) internalCluster().getInstance(  
        ));  
import static org.hamcrest.Matchers.lessThan;
        // One bad data node
import org.opensearch.action.admin.cluster.node.info.NodeInfo;
        NodesStatsResponse response = dataNodeClient().admin().cluster().prepareNodesStats().get();
        simulateTimeoutAtTransport(dataNode, anotherDataNode, NodesStatsAction.NAME);  
        // verify response with bad node.  
    public void testNodesStatsTimeout() {
        assertThat(recoveryResponse.getShardFailures()[0].reason(), containsString("ReceiveTimeoutTransportException"));
                Settings.builder()
        // simulate timeout on bad node.
        mockTransportServiceAnotherNode.addSendBehavior(internalCluster().getInstance(TransportService.class, dataNode), sendBehaviour);  
package org.opensearch.action.admin;
        String dataNode = internalCluster().startDataOnlyNode();  
import org.opensearch.test.transport.StubbableTransport;
            anotherDataNode
import org.opensearch.action.admin.cluster.node.info.NodesInfoAction;
            connection.sendRequest(requestId, action, request, options);
    @Override
        mockTransportService.addSendBehavior(internalCluster().getInstance(TransportService.class, anotherDataNode), sendBehaviour);
        String anotherDataNode = internalCluster().startDataOnlyNode();
    }
        String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();
 */  
        }  
        int numShards = 4;  
        // One bad data node  
                    .put("routing.allocation.total_shards_per_node", 2)
    }  
import org.opensearch.plugins.Plugin;
    }
        for (NodeInfo node : response.getNodes()) {  
    }  
    private void simulateTimeoutAtTransport(String dataNode, String anotherDataNode, String transportActionName) {
        simulateTimeoutAtTransport(dataNode, anotherDataNode, IndicesStatsAction.NAME);  
        String anotherDataNode = internalCluster().startDataOnlyNode();
        assertThat(recoveryResponse.getFailedShards(), equalTo(numShards / 2));
import org.opensearch.action.admin.indices.recovery.RecoveryAction;
        assertThat(response1.getNodes().size(), equalTo(3));  
        }
        assertThat(indicesStats.getTotal().getDocs().getCount(), lessThan(numDocs));
        NodesStatsResponse response1 = dataNodeClient().admin().cluster().prepareNodesStats().get();
    }
        ensureSearchable("test-index");
 * The OpenSearch Contributors require contributions made to  
        assertThat(response.getNodes().size(), equalTo(3));
        assertThat(indicesStats.getSuccessfulShards(), equalTo(numShards));  
import org.opensearch.action.admin.indices.stats.IndicesStatsAction;
        assertThat(indicesStats.getFailedShards(), equalTo(numShards / 2));
        assertThat(response.getNodes().size(), equalTo(2));  
                "test-index",  
        IndicesStatsResponse indicesStats = dataNodeClient().admin().indices().prepareStats().setDocs(true).get();
        String dataNode = internalCluster().startDataOnlyNode();
        NodesInfoResponse response = dataNodeClient().admin().cluster().prepareNodesInfo().get();  
                throw new ReceiveTimeoutTransportException(connection.getNode(), action, "simulate timeout");  
                    .put("number_of_shards", numShards)
            dataNode
import java.util.ArrayList;  
        String anotherDataNode = internalCluster().startDataOnlyNode();  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        final long numDocs = scaledRandomIntBetween(50, 100);  
        String dataNode = internalCluster().startDataOnlyNode();
        TimeValue timeout = TimeValue.timeValueMillis(1000);
        ensureGreen();
            )
            TransportService.class,  
                Settings.builder()
        simulateTimeoutAtTransport(dataNode, anotherDataNode, NodesStatsAction.NAME);
            index("test-index", "doc", Integer.toString(i));
    public void testNodesInfoTimeout() {  
        for (int i = 0; i < numDocs; i++) {  
        assertThat(indicesStats.getSuccessfulShards(), equalTo(numShards / 2));  
        assertAcked(  
                0,
import static org.hamcrest.Matchers.containsString;  
import java.util.Collections;
                "test-index",
        ListTasksResponse response1 = dataNodeClient().admin().cluster().prepareListTasks().get();  
        // happy case  
import org.opensearch.test.transport.MockTransportService;
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        assertThat(nodes.contains(clusterManagerNode), is(true));
import org.opensearch.transport.TransportService;
            nodes.add(node.getNode().getName());
        return Collections.singletonList(MockTransportService.TestPlugin.class);  
    public void testRecoveriesWithTimeout() {
        assertThat(nodes.contains(clusterManagerNode), is(true));
import org.opensearch.action.admin.indices.recovery.RecoveryResponse;  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        // Happy case
    public void testListTasksTimeout() {
        assertThat(recoveryResponse.getSuccessfulShards(), equalTo(numShards / 2));  
    }
        String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();  
            }
        }  
        );
        String anotherDataNode = internalCluster().startDataOnlyNode();
        indicesStats = dataNodeClient().admin().indices().prepareStats().setDocs(true).get();  
        ensureGreen();
        }
        };  
        // Happy case
        logger.info("-->  creating index");
            TransportService.class,
        // Happy case
        // Happy case
        recoveryResponse = dataNodeClient().admin().indices().prepareRecoveries().get();
import static org.hamcrest.Matchers.equalTo;
        String dataNode = internalCluster().startDataOnlyNode();
        ));
        assertNull(response.getPerNodeTasks().get(anotherDataNode));
public class ClientTimeoutIT extends OpenSearchIntegTestCase {
        // verify indices state response with bad node.
            nodes.add(node.getNode().getName());
        String anotherDataNode = internalCluster().startDataOnlyNode();
}  
        String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();
