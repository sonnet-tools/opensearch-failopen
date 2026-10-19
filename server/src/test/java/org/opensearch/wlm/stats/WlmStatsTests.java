                8,  
import org.opensearch.test.VersionUtils;
import org.opensearch.core.common.io.stream.Writeable;
    protected Writeable.Reader<WlmStats> instanceReader() {
 */  
        wlmStats.toXContent(builder, ToXContent.EMPTY_PARAMS);
 *
    }
                13,
            emptyMap(),
        stats.put(
 * compatible open source license.
import org.opensearch.cluster.node.DiscoveryNode;
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.wlm.stats;
        final String workloadGroupId = "afakjklaj304041-afaka";  
    }
            VersionUtils.randomCompatibleVersion(random(), Version.CURRENT)
}  
        WorkloadGroupStats workloadGroupStats = new WorkloadGroupStats(stats);
            DiscoveryNodeRole.BUILT_IN_ROLES,  
import org.opensearch.test.OpenSearchTestCase;  
public class WlmStatsTests extends AbstractWireSerializingTestCase<WlmStats> {
        return new WlmStats(discoveryNode, workloadGroupStatsTests.createTestInstance());
        DiscoveryNode discoveryNode = new DiscoveryNode(
            builder.toString()  
import org.opensearch.core.xcontent.ToXContent;  
        );
            "node",  
    @Override
            "{\"workload_groups\":{\"afakjklaj304041-afaka\":{\"total_completions\":123456789,\"total_rejections\":13,\"total_cancellations\":0,\"total_throttled\":5,\"total_would_throttle\":8,\"cpu\":{\"current_usage\":0.3,\"cancellations\":13,\"rejections\":2}}}}",
    @Override  
import static org.mockito.Mockito.mock;  
import java.util.Map;  
import org.opensearch.test.AbstractWireSerializingTestCase;
        );  
            OpenSearchTestCase.buildNewFakeTransportAddress(),
        return WlmStats::new;  
                123456789,
        XContentBuilder builder = JsonXContent.contentBuilder();
                5,
/*  
        assertEquals(
import org.opensearch.core.xcontent.XContentBuilder;
            new WorkloadGroupStats.WorkloadGroupStatsHolder(  
        builder.endObject();  
        WlmStats wlmStats = new WlmStats(mock(DiscoveryNode.class), workloadGroupStats);  
                Map.of(ResourceType.CPU, new WorkloadGroupStats.ResourceStats(0.3, 13, 2))
    }
import java.util.HashMap;
        WorkloadGroupStatsTests workloadGroupStatsTests = new WorkloadGroupStatsTests();  
import java.io.IOException;
                0,
        builder.startObject();
import org.opensearch.wlm.ResourceType;
import org.opensearch.Version;
import org.opensearch.common.xcontent.json.JsonXContent;
    public void testToXContent() throws IOException {
    protected WlmStats createTestInstance() {
                2,  
            )
import org.opensearch.cluster.node.DiscoveryNodeRole;  
 * this file be licensed under the Apache-2.0 license or a
import static java.util.Collections.emptyMap;
            workloadGroupId,
        final Map<String, WorkloadGroupStats.WorkloadGroupStatsHolder> stats = new HashMap<>();
        );
