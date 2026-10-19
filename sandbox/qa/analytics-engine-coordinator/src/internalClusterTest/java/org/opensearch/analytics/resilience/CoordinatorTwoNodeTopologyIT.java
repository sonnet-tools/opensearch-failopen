}  
 * primaries are typically distributed (~2 per node), so the coordinator-reduce
import org.opensearch.test.OpenSearchIntegTestCase;
package org.opensearch.analytics.resilience;
 * SPDX-License-Identifier: Apache-2.0
 *
/*  
public class CoordinatorTwoNodeTopologyIT extends CoordinatorTopologyTestBase {
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 2, numClientNodes = 0, supportsDedicatedMasters = false)  
 * executions. Exercises the cross-node FragmentExecutionAction streaming path.
/**  
 */  
 * this file be licensed under the Apache-2.0 license or a
    }
 * Two-node topology coverage. With two data nodes and a 4-shard index the
 * compatible open source license.
 */
 * stage receives streamed batches from both same-node and peer-node fragment  
    public void testTwoNodeFourShardSum() throws Exception {  
 * The OpenSearch Contributors require contributions made to  
        runSumOverSeededIndex("topology_two_node_idx", 4, 40);
