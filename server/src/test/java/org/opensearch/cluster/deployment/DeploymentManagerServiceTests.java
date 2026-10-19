        DeploymentMetadata metadata = newState.metadata().custom(DeploymentMetadata.TYPE);  
        assertTrue(metadata.getDeployments().containsKey("dep-2"));
        Deployment deployment = metadata.getDeployments().get("dep-1");
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.cluster.deployment.DeploymentState.FINISH;  
import org.opensearch.cluster.metadata.Metadata;  
        );  
    }
        state = DeploymentManagerService.innerTransitionDeployment("dep-1", Map.of("zone", "zone-1"), state, DRAIN);  
    }
 * The OpenSearch Contributors require contributions made to  
        DeploymentMetadata metadata = state.metadata().custom(DeploymentMetadata.TYPE);
        assertEquals(2, metadata.getDeployments().size());
    public void testFinishNonexistentDeployment() {
        assertNotNull(metadata);
            IllegalArgumentException.class,
        state = DeploymentManagerService.innerTransitionDeployment("dep-2", Map.of("zone", "zone-2"), state, DRAIN);
    public void testStartMultipleDeployments() {
        ClusterState state = emptyState();
import org.opensearch.test.OpenSearchTestCase;
        DeploymentMetadata metadata = state.metadata().custom(DeploymentMetadata.TYPE);
        ClusterState state = emptyState();  
        assertEquals(DRAIN, deployment.getState());  
        state = DeploymentManagerService.innerTransitionDeployment("dep-1", Map.of("zone", "zone-1"), state, DRAIN);  
        ClusterState state = emptyState();
        assertNull(metadata);
        assertEquals(1, metadata.getDeployments().size());  
    public void testFinishDeployment() {
    }
        assertTrue(metadata.getDeployments().containsKey("dep-1"));  
 */  
package org.opensearch.cluster.deployment;
        assertSame(state, newState);
    }  
        ClusterState newState = DeploymentManagerService.innerTransitionDeployment("nonexistent", state, FINISH);
import org.opensearch.cluster.ClusterName;
    public void testFinishDeploymentRemovesCustomWhenEmpty() {
import static org.opensearch.cluster.deployment.DeploymentState.DRAIN;
        DeploymentMetadata metadata = state.metadata().custom(DeploymentMetadata.TYPE);  
 * compatible open source license.
        assertEquals(1, metadata.getDeployments().size());
    public void testStartDeploymentRejectsOverlappingAttributes() {
        assertTrue(e.getMessage().contains("already targets attribute zone=zone-1"));
        assertNotNull(metadata);
        ClusterState state = emptyState();
        ClusterState newState = DeploymentManagerService.innerTransitionDeployment("dep-1", Map.of("zone", "zone-1"), state, DRAIN);
    public void testStartDeployment() {
        assertTrue(metadata.getDeployments().containsKey("dep-1"));  
 *
    }  
    }
        state = DeploymentManagerService.innerTransitionDeployment("dep-1", state, FINISH);
public class DeploymentManagerServiceTests extends OpenSearchTestCase {
}
            () -> DeploymentManagerService.innerTransitionDeployment("dep-2", Map.of("zone", "zone-1"), finalState, DRAIN)
        assertNotNull(metadata);
        state = DeploymentManagerService.innerTransitionDeployment("dep-1", Map.of("zone", "zone-1"), state, DRAIN);  
/*  
        IllegalArgumentException e = expectThrows(  
        ClusterState state = emptyState();
            IllegalArgumentException.class,
        IllegalArgumentException e = expectThrows(  
    }  
        ClusterState finalState = state;
        assertTrue(e.getMessage().contains("must match existing deployment keys"));
        assertTrue(metadata.getDeployments().containsKey("dep-2"));
        );  
        return ClusterState.builder(new ClusterName("test")).metadata(Metadata.builder().build()).build();
        assertEquals(Map.of("zone", "zone-1"), deployment.getNodeAttributes());
            () -> DeploymentManagerService.innerTransitionDeployment("dep-2", Map.of("rack", "rack-1"), finalState, DRAIN)
 * SPDX-License-Identifier: Apache-2.0
        ClusterState state = emptyState();  
        state = DeploymentManagerService.innerTransitionDeployment("dep-2", Map.of("zone", "zone-2"), state, DRAIN);
        state = DeploymentManagerService.innerTransitionDeployment("dep-1", state, FINISH);
    }  
    public void testStartDeploymentRejectsInconsistentKeys() {
import org.opensearch.cluster.ClusterState;
        ClusterState state = emptyState();  
        ClusterState finalState = state;
    private ClusterState emptyState() {
        assertFalse(metadata.getDeployments().containsKey("dep-1"));
        state = DeploymentManagerService.innerTransitionDeployment("dep-1", Map.of("zone", "zone-1"), state, DRAIN);
import java.util.Map;  
        state = DeploymentManagerService.innerTransitionDeployment("dep-1", Map.of("zone", "zone-1"), state, DRAIN);  
