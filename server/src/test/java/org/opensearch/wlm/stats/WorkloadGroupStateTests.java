            }  
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(10, workloadGroupState.getTotalCancellations());
 * this file be licensed under the Apache-2.0 license or a
            if (i % 5 == 0) {  
                updaterThreads.add(new Thread(() -> workloadGroupState.failures.inc()));  
        assertEquals(5, workloadGroupState.getFailures());  
                }));
import java.util.ArrayList;
        });  
                        workloadGroupState.getResourceState().get(ResourceType.CPU).rejections.inc();  
 * compatible open source license.
                    workloadGroupState.totalRejections.inc();
        // wait for updates to be finished
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.wlm.ResourceType;
        // trigger the updates  
            } else if (i % 5 == 2) {
        updaterThreads.forEach(thread -> {  
            } catch (InterruptedException ignored) {  
                updaterThreads.add(new Thread(() -> {  
    WorkloadGroupState workloadGroupState;
            try {
        updaterThreads.forEach(Thread::start);
import java.util.List;
                updaterThreads.add(new Thread(() -> { workloadGroupState.totalCompletions.inc(); }));
}  
                        workloadGroupState.getResourceState().get(ResourceType.MEMORY).rejections.inc();
        assertEquals(5, workloadGroupState.getResourceState().get(ResourceType.CPU).cancellations.count());
            } else if (i % 5 == 3) {
                    }  
                updaterThreads.add(new Thread(() -> workloadGroupState.getResourceState().get(ResourceType.MEMORY).cancellations.inc()));
            if (i % 5 == 3 || i % 5 == 4) {
 */  
        }
            + workloadGroupState.getResourceState().get(ResourceType.MEMORY).rejections.count();  
public class WorkloadGroupStateTests extends OpenSearchTestCase {
                    } else {
                updaterThreads.add(new Thread(() -> workloadGroupState.getResourceState().get(ResourceType.CPU).cancellations.inc()));
package org.opensearch.wlm.stats;
    }
 *
/*  
            }
        assertEquals(5, workloadGroupState.getResourceState().get(ResourceType.MEMORY).cancellations.count());  
        workloadGroupState = new WorkloadGroupState();
                updaterThreads.add(new Thread(() -> workloadGroupState.totalCancellations.inc()));
 * The OpenSearch Contributors require contributions made to  
                    if (randomBoolean()) {
            } else if (i % 5 == 1) {
        assertEquals(sumOfRejectionsDueToResourceTypes, workloadGroupState.getTotalRejections());
            }
            } else {  
        for (int i = 0; i < 25; i++) {
        final long sumOfRejectionsDueToResourceTypes = workloadGroupState.getResourceState().get(ResourceType.CPU).rejections.count()
        assertEquals(5, workloadGroupState.getTotalCompletions());
        assertEquals(5, workloadGroupState.getTotalRejections());  
        List<Thread> updaterThreads = new ArrayList<>();  
    public void testRandomWorkloadGroupsStateUpdates() {
                thread.join();
