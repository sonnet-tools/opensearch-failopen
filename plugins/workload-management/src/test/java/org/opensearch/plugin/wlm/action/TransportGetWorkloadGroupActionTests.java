        );
            mock(ThreadPool.class),
            () -> transportGetWorkloadGroupAction.clusterManagerOperation(  
    @SuppressWarnings("unchecked")
     * Test case for ClusterManagerOperation function  
import org.opensearch.ResourceNotFoundException;
        assertThrows(
    }
 * compatible open source license.
 */  
        );  
import static org.opensearch.plugin.wlm.WorkloadManagementTestUtils.NAME_ONE;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
import static org.opensearch.plugin.wlm.WorkloadManagementTestUtils.NAME_NONE_EXISTED;
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.core.action.ActionListener;
            mock(ActionFilters.class),  
 * this file be licensed under the Apache-2.0 license or a
public class TransportGetWorkloadGroupActionTests extends OpenSearchTestCase {  
            )
     */
 * The OpenSearch Contributors require contributions made to  
/*  
        GetWorkloadGroupRequest getWorkloadGroupRequest2 = new GetWorkloadGroupRequest(NAME_ONE);
                mock(ActionListener.class)  
        transportGetWorkloadGroupAction.clusterManagerOperation(getWorkloadGroupRequest2, clusterState(), mock(ActionListener.class));  
import org.opensearch.cluster.service.ClusterService;
                getWorkloadGroupRequest1,
    public void testClusterManagerOperation() throws Exception {  
import org.opensearch.action.support.ActionFilters;
import static org.opensearch.plugin.wlm.WorkloadManagementTestUtils.clusterState;  
        GetWorkloadGroupRequest getWorkloadGroupRequest1 = new GetWorkloadGroupRequest(NAME_NONE_EXISTED);
            mock(IndexNameExpressionResolver.class)
            mock(TransportService.class),
import org.opensearch.test.OpenSearchTestCase;  
            mock(ClusterService.class),
        TransportGetWorkloadGroupAction transportGetWorkloadGroupAction = new TransportGetWorkloadGroupAction(  
    /**
}
                clusterState(),
 *
import static org.mockito.Mockito.mock;
            ResourceNotFoundException.class,
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.plugin.wlm.action;
import org.opensearch.transport.TransportService;
