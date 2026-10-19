public class WlmStatsResponseTests extends OpenSearchTestCase {
    }
    List<WlmStats> wlmStatsList = List.of(wlmStats);  
            new WorkloadGroupStats.WorkloadGroupStatsHolder(
                + "          \"current_usage\" : 0.0,\n"  
    WorkloadGroupStats workloadGroupStats = new WorkloadGroupStats(
            responseString
                + "          \"rejections\" : 0\n"
                    new WorkloadGroupStats.ResourceStats(0, 0, 0)  
    }  
}
import org.opensearch.Version;
                + "  }\n"
        assertEquals(workloadGroupStatsResponse.getClusterName(), deserializedResponse.getClusterName());  
import org.opensearch.cluster.node.DiscoveryNode;
                + "    \"workload_groups\" : {\n"
    public void testSerializationAndDeserialization() throws IOException {  
            "{\n"
        workloadGroupStatsResponse.writeTo(out);  
    String testWorkloadGroupId = "safjgagnaeekg-3r3fads";
        buildNewFakeTransportAddress(),
        BytesStreamOutput out = new BytesStreamOutput();
package org.opensearch.action.admin.cluster.wlm;
                + "      }\n"  
import java.util.Set;  
                Map.of(
                + "        \"cpu\" : {\n"
    DiscoveryNode node = new DiscoveryNode(
        "node-1",  
                + "  \"node-1\" : {\n"  
import org.opensearch.wlm.stats.WlmStats;
                0,
 * compatible open source license.
                + "        \"total_would_throttle\" : 0,\n"
        );
                + "        \"total_cancellations\" : 0,\n"
    public void testToString() {
    ClusterName clusterName = new ClusterName("test-cluster");  
import org.opensearch.test.OpenSearchTestCase;
                + "}",  
 */  
            )
                + "    }\n"
                    ResourceType.MEMORY,
                0,  
import java.util.List;
        WlmStatsResponse workloadGroupStatsResponse = new WlmStatsResponse(clusterName, wlmStatsList, failedNodeExceptionList);
                + "        \"total_completions\" : 0,\n"  
        new HashMap<>(),
                0,
                1,
                + "        \"total_throttled\" : 0,\n"  
    );
import org.opensearch.wlm.stats.WorkloadGroupStats;
                + "          \"cancellations\" : 0,\n"
                + "      \"safjgagnaeekg-3r3fads\" : {\n"
import org.opensearch.action.FailedNodeException;
    List<FailedNodeException> failedNodeExceptionList = new ArrayList<>();
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.ClusterName;  
                + "        \"memory\" : {\n"
        WlmStatsResponse deserializedResponse = new WlmStatsResponse(in);
                    ResourceType.CPU,  
        Set.of(DiscoveryNodeRole.DATA_ROLE),  
import org.opensearch.common.io.stream.BytesStreamOutput;  
import java.util.HashMap;  
        WlmStatsResponse workloadGroupStatsResponse = new WlmStatsResponse(clusterName, wlmStatsList, failedNodeExceptionList);
import org.opensearch.cluster.node.DiscoveryNodeRole;
import org.opensearch.core.common.io.stream.StreamInput;
import java.io.IOException;
                + "        }\n"
    WlmStats wlmStats = new WlmStats(node, workloadGroupStats);
/*  
        StreamInput in = out.bytes().streamInput();
                )
        assertEquals(workloadGroupStatsResponse.getNodes().size(), deserializedResponse.getNodes().size());
                + "          \"cancellations\" : 0,\n"  
import org.opensearch.wlm.ResourceType;  
    );
                    new WorkloadGroupStats.ResourceStats(0, 0, 0),
 *
 * The OpenSearch Contributors require contributions made to  
import java.util.ArrayList;
 * this file be licensed under the Apache-2.0 license or a
    Map<String, WorkloadGroupStats.WorkloadGroupStatsHolder> statsHolderMap = new HashMap<>();  
        )  
                + "          \"current_usage\" : 0.0,\n"
            testWorkloadGroupId,  
        Version.CURRENT
                + "          \"rejections\" : 0\n"
                0,  
                + "        \"total_rejections\" : 0,\n"
                0,
        assertEquals(
        Map.of(
                + "        },\n"  
        String responseString = workloadGroupStatsResponse.toString();  
import java.util.Map;
