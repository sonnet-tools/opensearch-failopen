import org.opensearch.monitor.jvm.HotThreads;
    }  
    private static final int MAX_SNAPSHOTS = 500;  
        NodesHotThreadsRequest request = new NodesHotThreadsRequest().snapshots(500000000);
 * this file be licensed under the Apache-2.0 license or a
    public void testValidSnapshotsPasses() {
import org.opensearch.test.OpenSearchTestCase;
 *
            () -> TransportNodesHotThreadsAction.validateRequestParams(request, MAX_SNAPSHOTS)
    }
            IllegalArgumentException.class,
        // default value as well as the accepted boundaries must not be rejected  
        assertTrue(e.getMessage().contains(HotThreads.MAX_HOT_THREADS_SNAPSHOTS_SETTING.getKey()));
        );  
        }  
package org.opensearch.action.admin.cluster.node.hotthreads;
 * The OpenSearch Contributors require contributions made to  
    }
    }
 * compatible open source license.
}
/*  
            assertTrue(e.getMessage().contains("[snapshots]"));
    public void testSnapshotsJustAboveMaxRejected() {
                IllegalArgumentException.class,
 * SPDX-License-Identifier: Apache-2.0
    public void testSnapshotsBelowOneRejected() {
            IllegalArgumentException e = expectThrows(
        TransportNodesHotThreadsAction.validateRequestParams(new NodesHotThreadsRequest().snapshots(MAX_SNAPSHOTS), MAX_SNAPSHOTS);  
        // a very large value would otherwise allocate an oversized ThreadInfo[snapshots][] array
            NodesHotThreadsRequest request = new NodesHotThreadsRequest().snapshots(invalid);  
            );
    public void testSnapshotsAboveMaxRejected() {  
        expectThrows(IllegalArgumentException.class, () -> TransportNodesHotThreadsAction.validateRequestParams(request, MAX_SNAPSHOTS));
public class TransportNodesHotThreadsActionTests extends OpenSearchTestCase {
        for (int invalid : new int[] { 0, -1, Integer.MIN_VALUE }) {
        TransportNodesHotThreadsAction.validateRequestParams(new NodesHotThreadsRequest(), MAX_SNAPSHOTS);
        assertTrue(e.getMessage().contains("[snapshots]"));
                () -> TransportNodesHotThreadsAction.validateRequestParams(request, MAX_SNAPSHOTS)  
        NodesHotThreadsRequest request = new NodesHotThreadsRequest().snapshots(MAX_SNAPSHOTS + 1);  
        TransportNodesHotThreadsAction.validateRequestParams(new NodesHotThreadsRequest().snapshots(1), MAX_SNAPSHOTS);
        IllegalArgumentException e = expectThrows(  
 */  
