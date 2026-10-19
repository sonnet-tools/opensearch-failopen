/**  
 */
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1, numClientNodes = 0, supportsDedicatedMasters = false)
package org.opensearch.analytics.resilience;
 * Single-node topology coverage. With one data node and a multi-shard index, both
 */  
        runSumOverSeededIndex("topology_single_node_idx", 2, 20);  
    }
 * compatible open source license.
/*  
 * any remote dispatch.  
 * this file be licensed under the Apache-2.0 license or a
    public void testSingleNodeMultiShardSum() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
 *
public class CoordinatorSingleNodeTopologyIT extends CoordinatorTopologyTestBase {  
}
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.OpenSearchIntegTestCase;
 * primaries are co-located on the coordinator — the local-fan-in path runs without
