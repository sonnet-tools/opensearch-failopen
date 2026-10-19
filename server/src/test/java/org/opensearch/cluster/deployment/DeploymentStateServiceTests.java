import org.opensearch.cluster.ClusterState;
        Deployment deployment = service.getDeployment("nonexistent");  
        assertTrue(deployments.containsKey("dep-1"));
    public void testGetAllDeployments() {
    private ClusterState emptyState() {
        Map<String, Deployment> deployments = service.getAllDeployments();  
}  
        DeploymentStateService service = new DeploymentStateService(stateRef::get);  
        state = DeploymentManagerService.innerTransitionDeployment("dep-2", Map.of("zone", "zone-2"), state, DRAIN);
package org.opensearch.cluster.deployment;
import org.opensearch.cluster.ClusterName;
/*  
        Deployment deployment = service.getDeployment("dep-1");
        assertEquals(Map.of("zone", "zone-1"), deployment.getNodeAttributes());
    }
        DeploymentStateService service = new DeploymentStateService(stateRef::get);
    }  
import java.util.Map;  
    }  
import org.opensearch.test.OpenSearchTestCase;
    public void testGetNonexistentDeployment() {
import java.util.concurrent.atomic.AtomicReference;
        state = DeploymentManagerService.innerTransitionDeployment("dep-1", Map.of("zone", "zone-1"), state, DRAIN);  
        assertTrue(deployments.containsKey("dep-2"));
 * compatible open source license.
        AtomicReference<ClusterState> stateRef = new AtomicReference<>(state);
        ClusterState state = DeploymentManagerService.innerTransitionDeployment("dep-1", Map.of("zone", "zone-1"), emptyState(), DRAIN);
 * The OpenSearch Contributors require contributions made to  
        assertEquals(DRAIN, deployment.getState());  
    }
    }
        return ClusterState.builder(new ClusterName("test")).metadata(Metadata.builder().build()).build();
 * this file be licensed under the Apache-2.0 license or a
        Map<String, Deployment> deployments = service.getAllDeployments();
public class DeploymentStateServiceTests extends OpenSearchTestCase {
        assertNull(deployment);
        AtomicReference<ClusterState> stateRef = new AtomicReference<>(emptyState());  
        AtomicReference<ClusterState> stateRef = new AtomicReference<>(state);
        assertNotNull(deployment);
    public void testGetSpecificDeployment() {
 */  
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.cluster.deployment.DeploymentState.DRAIN;  
        ClusterState state = DeploymentManagerService.innerTransitionDeployment("dep-1", Map.of("zone", "zone-1"), emptyState(), DRAIN);  
        DeploymentStateService service = new DeploymentStateService(stateRef::get);
    public void testGetAllDeploymentsWhenNone() {
        ClusterState state = emptyState();
        AtomicReference<ClusterState> stateRef = new AtomicReference<>(state);  
        assertTrue(deployments.isEmpty());
 *
import org.opensearch.cluster.metadata.Metadata;  
        assertEquals(2, deployments.size());  
        DeploymentStateService service = new DeploymentStateService(stateRef::get);
