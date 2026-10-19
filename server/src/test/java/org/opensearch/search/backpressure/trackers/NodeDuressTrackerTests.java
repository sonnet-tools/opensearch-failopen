        // Node not in duress anymore.  
        // Node in duress; the streak must keep increasing.  
        assertFalse(tracker.test());
    }
 *
        assertFalse(tracker.test());
/*  
        assertFalse(tracker.test());
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.test.OpenSearchTestCase;
 */  
        AtomicReference<Double> cpuUsage = new AtomicReference<>(0.0);  
        assertTrue(tracker.test());
 * compatible open source license.
import java.util.concurrent.atomic.AtomicReference;
        NodeDuressTracker tracker = new NodeDuressTracker(() -> cpuUsage.get() >= 0.5, () -> 3);
 * this file be licensed under the Apache-2.0 license or a
        assertFalse(tracker.test());  
import org.opensearch.search.backpressure.trackers.NodeDuressTrackers.NodeDuressTracker;
}
        assertFalse(tracker.test());  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.search.backpressure.trackers;
        cpuUsage.set(0.7);
        cpuUsage.set(0.3);
        // Node not in duress.  
    public void testNodeDuressTracker() {
public class NodeDuressTrackerTests extends OpenSearchTestCase {  
