    private ThreadPool threadPool;
        sut.setWorkloadGroupId(threadPool.getThreadContext());
        threadPool = new TestThreadPool(getTestName());
    }  
        // _msearch sub-requests share a thread context, so the principal is per task to avoid cross-billing.
    public void setUp() throws Exception {
        assertNull(other.getThrottlePrincipal());
        threadPool.shutdown();
/*  
        assertNull(threadPool.getThreadContext().getHeader("workloadGroupPrincipal"));
        sut.setWorkloadGroupId(threadPool.getThreadContext());
        sut = new WorkloadGroupTask(123, "transport", "Search", "test task", null, Collections.emptyMap());
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("username|alice", sut.getThrottlePrincipal());  
        assertEquals(DEFAULT_WORKLOAD_GROUP_ID_SUPPLIER.get(), sut.getWorkloadGroupId());  
        super.tearDown();  
}
        WorkloadGroupTask other = new WorkloadGroupTask(124, "transport", "Search", "test task", null, Collections.emptyMap());  
package org.opensearch.wlm;
    private WorkloadGroupTask sut;  
import java.util.Collections;
        assertNull(sut.getHeader("workloadGroupPrincipal"));
 * compatible open source license.
    public void tearDown() throws Exception {
    }  
 */  
        assertEquals("akfanglkaglknag2332", sut.getWorkloadGroupId());
public class WorkloadGroupTaskTests extends OpenSearchTestCase {
 *
        threadPool.getThreadContext().putHeader(WORKLOAD_GROUP_ID_HEADER, "akfanglkaglknag2332");
        // Not in the header maps, which are serialized to every shard and remote cluster.  
        assertNull("an absent principal must read as null so username/role throttling fails open", sut.getThrottlePrincipal());  
 * The OpenSearch Contributors require contributions made to  
        super.setUp();  
    }
    public void testThrottlePrincipalIsPerTaskAndNotAHeader() {
import static org.opensearch.wlm.WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER;
 * this file be licensed under the Apache-2.0 license or a
    }  
import static org.opensearch.wlm.WorkloadGroupTask.DEFAULT_WORKLOAD_GROUP_ID_SUPPLIER;
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.threadpool.ThreadPool;  
        sut.setThrottlePrincipal("username|alice");
    public void testSuccessfulSetWorkloadGroupId() {
import org.opensearch.threadpool.TestThreadPool;
