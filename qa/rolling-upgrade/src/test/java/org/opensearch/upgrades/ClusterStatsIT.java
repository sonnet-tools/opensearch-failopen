 * SPDX-License-Identifier: Apache-2.0
                    assertTrue(nodesStats.containsKey(metric));
/*  
            validateClusterStatsWithFilterResponse(response, List.of("os"), List.of("mappings"));
import java.util.Map;
        Response response = client().performRequest(new Request("GET", "/_cluster/stats"));
            CLUSTER_TYPE == ClusterType.UPGRADED && Version.CURRENT.onOrAfter(Version.V_2_18_0))) {
            response = client().performRequest(new Request("GET", "/_cluster/stats/os/nodes/_all"));  
        if (requestedIndicesStatsMetrics != null && !requestedIndicesStatsMetrics.isEmpty()) {  
            Map<?, ?> indicesStats = (Map<?, ?>) entity.get("indices");
                    assertTrue(indicesStats.containsKey(metric));
 */  
package org.opensearch.upgrades;
                if (requestedNodesStatsMetrics.contains(metric)) {
            response = client().performRequest(new Request("GET", "/_cluster/stats/indices/mappings/nodes/_all"));
        }
        Map<String, Object> entity = entityAsMap(response);
            validateClusterStatsWithFilterResponse(response, Collections.emptyList(), List.of("mappings"));  
            assertTrue(entity.containsKey("indices"));
    }
import java.util.List;
import org.opensearch.Version;
        validateClusterStatsWithFilterResponse(response, nodeStatsMetrics, indicesStatsMetrics);  
            }  
        }
 * The OpenSearch Contributors require contributions made to  
    public void testClusterStats() throws IOException {
            }  
public class ClusterStatsIT extends AbstractRollingTestCase {
        }  
                if (requestedIndicesStatsMetrics.contains(metric)) {
    private final List<String> indicesStatsMetrics = List.of("shards", "docs", "store", "fielddata", "query_cache", "completion", "segments", "analysis", "mappings");
import java.io.IOException;
                    assertFalse(nodesStats.containsKey(metric));
import org.opensearch.client.Request;
        assertEquals(200, response.getStatusLine().getStatusCode());
    private final List<String> nodeStatsMetrics = List.of("os", "process", "jvm", "fs", "plugins", "ingest", "network_types", "discovery_types", "packaging_types");  
    private void validateClusterStatsWithFilterResponse(Response response, List<String> requestedNodesStatsMetrics, List<String> requestedIndicesStatsMetrics) throws IOException {  
            Map<?, ?> nodesStats = (Map<?, ?>) entity.get("nodes");
                    assertFalse(indicesStats.containsKey(metric));
 *
                } else {  
import java.util.Collections;  
    }
            response = client().performRequest(new Request("GET", "/_cluster/stats/os,indices/mappings/nodes/_all"));
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
                }
            for (String metric : indicesStatsMetrics) {  
        if (AbstractRollingTestCase.UPGRADE_FROM_VERSION.onOrAfter(Version.V_2_18_0) || (
                } else {  
        if (requestedNodesStatsMetrics != null && !requestedNodesStatsMetrics.isEmpty()) {  
            assertTrue(entity.containsKey("nodes"));
import org.opensearch.client.Response;  
            for (String metric : nodeStatsMetrics) {  
            validateClusterStatsWithFilterResponse(response, List.of("os"), Collections.emptyList());
                }
}  
