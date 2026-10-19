                )
import org.opensearch.common.xcontent.json.JsonXContent;
        assertEquals(
        final Map<String, WorkloadGroupStats.WorkloadGroupStatsHolder> stats = new HashMap<>();
    @Override
                Map.of(  
                new WorkloadGroupStats.WorkloadGroupStatsHolder(  
        return WorkloadGroupStats::new;  
                    100,
import static java.util.Collections.emptyMap;
                randomNonNegativeLong(),
                    ResourceType.CPU,
        assertEquals(4, legacy.getResourceStats().get(ResourceType.CPU).getRejections());
            )
                randomNonNegativeLong(),
import org.opensearch.cluster.node.DiscoveryNodeRole;  
    protected WorkloadGroupStats createTestInstance() {
import org.opensearch.Version;
        assertEquals(13, legacy.getRejections());  
        assertEquals(0, legacy.getThrottled());  
                        randomNonNegativeLong()
        WorkloadGroupStats.WorkloadGroupStatsHolder legacy = copyInstance(original, Version.V_3_9_0).getStats().get("group-1");
        WorkloadGroupStats original = new WorkloadGroupStats(  
    }  
                    Map.of(ResourceType.CPU, new WorkloadGroupStats.ResourceStats(0.3, 11, 4))
                randomNonNegativeLong(),
        assertEquals(0.3, current.getResourceStats().get(ResourceType.CPU).getCurrentUsage(), 0.0);
 * The OpenSearch Contributors require contributions made to  
        assertEquals(7, legacy.getCancellations());
public class WorkloadGroupStatsTests extends AbstractWireSerializingTestCase<WorkloadGroupStats> {
                    7,
        assertEquals(11, legacy.getResourceStats().get(ResourceType.CPU).getCancellations());  
            VersionUtils.randomCompatibleVersion(random(), Version.CURRENT)  
        );
 * SPDX-License-Identifier: Apache-2.0
            )  
            new WorkloadGroupStats.WorkloadGroupStatsHolder(
import org.opensearch.core.xcontent.ToXContent;  
        assertEquals(5, current.getThrottled());
                0,  
            OpenSearchTestCase.buildNewFakeTransportAddress(),  
import org.opensearch.test.VersionUtils;
                8,
        assertEquals(0.3, legacy.getResourceStats().get(ResourceType.CPU).getCurrentUsage(), 0.0);
    @Override  
                "group-1",
        workloadGroupStats.toXContent(builder, ToXContent.EMPTY_PARAMS);  
import org.opensearch.test.AbstractWireSerializingTestCase;
package org.opensearch.wlm.stats;
            "{\"workload_groups\":{\"afakjklaj304041-afaka\":{\"total_completions\":123456789,\"total_rejections\":13,\"total_cancellations\":0,\"total_throttled\":5,\"total_would_throttle\":8,\"cpu\":{\"current_usage\":0.3,\"cancellations\":13,\"rejections\":2}}}}",  
import org.opensearch.cluster.node.DiscoveryNode;
        WorkloadGroupStats workloadGroupStats = new WorkloadGroupStats(stats);
        assertEquals(100, current.getCompletions());
        builder.endObject();
        stats.put(  
        );
 * compatible open source license.
                Map.of(ResourceType.CPU, new WorkloadGroupStats.ResourceStats(0.3, 13, 2))  
import org.opensearch.test.OpenSearchTestCase;  
        assertEquals(100, legacy.getCompletions());
    public void testToXContent() throws IOException {  
                    5,
    }
        stats.put(  
        );  
                randomNonNegativeLong(),  
            new WorkloadGroupStats.WorkloadGroupStatsHolder(
        // A pre-throttling peer writes neither counter: they read as 0 and the following resourceStats map still decodes.
                randomNonNegativeLong(),  
import java.util.HashMap;
            "node",
 * this file be licensed under the Apache-2.0 license or a
        final String workloadGroupId = "afakjklaj304041-afaka";
import org.opensearch.core.xcontent.XContentBuilder;
    }  
        builder.startObject();
        // A 3.10 peer exchanges total_throttled and total_would_throttle, and everything after them on the wire stays aligned.  
            builder.toString()
    public void testThrottledIsVersionGatedAndKeepsOlderStreamsAligned() throws IOException {
            workloadGroupId,
}
 */  
                13,
                    13,
import java.io.IOException;
                    )  
                randomNonNegativeLong(),
                    2,  
 *
        );
            Map.of(
                    new WorkloadGroupStats.ResourceStats(
    }
        WorkloadGroupStats.WorkloadGroupStatsHolder current = copyInstance(original, Version.V_3_10_0).getStats().get("group-1");
        assertEquals(0, legacy.getWouldThrottle());
    protected Writeable.Reader<WorkloadGroupStats> instanceReader() {
        );
                123456789,  
/*  
            )
            emptyMap(),
import java.util.Map;  
                )
        Map<String, WorkloadGroupStats.WorkloadGroupStatsHolder> stats = new HashMap<>();
        return new WorkloadGroupStats(stats);
                        randomNonNegativeLong(),
        assertEquals(9, current.getWouldThrottle());  
            DiscoveryNodeRole.BUILT_IN_ROLES,
                2,
                        randomDoubleBetween(0.0, 0.90, false),  
import org.opensearch.wlm.ResourceType;
                    9,  
            randomAlphaOfLength(10),
        DiscoveryNode discoveryNode = new DiscoveryNode(
                5,
        XContentBuilder builder = JsonXContent.contentBuilder();  
import org.opensearch.core.common.io.stream.Writeable;
