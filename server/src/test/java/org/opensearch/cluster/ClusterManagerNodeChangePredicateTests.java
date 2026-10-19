    public void testAcceptsDifferentClusterManager() {
    public void testNullCurrentClusterManagerAcceptsNewClusterManager() {  
    public void testRejectsNullNewClusterManager() {  
    }
            nodesBuilder.clusterManagerNodeId(clusterManagerNode.getId());  
    public void testRejectsLowerVersionSameClusterManager() {
        Predicate<ClusterState> predicate = ClusterManagerNodeChangePredicate.build(currentState);
        assertTrue(predicate.test(buildState(clusterManagerNode, 2)));  
        nodesBuilder.add(otherClusterManagerNode);
        Predicate<ClusterState> predicate = ClusterManagerNodeChangePredicate.build(currentState);
        );
import org.opensearch.cluster.node.DiscoveryNodes;
 *
        ClusterState currentState = buildState(null, 5);
import org.opensearch.test.OpenSearchTestCase;  
    public void testNullCurrentClusterManagerRejectsNullNewClusterManager() {
        ClusterState currentState = buildState(clusterManagerNode, 5);
 * The OpenSearch Contributors require contributions made to  
        return ClusterState.builder(new ClusterName("test")).nodes(nodesBuilder).version(version).build();  
    }
    private DiscoveryNode clusterManagerNode;
        );
        Predicate<ClusterState> fromPrimitives = ClusterManagerNodeChangePredicate.build(
    }
        ClusterState currentState = buildState(null, 1);
/**
        Predicate<ClusterState> predicate = ClusterManagerNodeChangePredicate.build(1, null);
            currentState.version(),
        assertFalse(predicate.test(buildState(clusterManagerNode, 3)));
            currentState.version(),
        assertFalse(predicate.test(buildState(null, 5)));
            currentState.nodes().getClusterManagerNode().getEphemeralId()  
    }
        ClusterState currentState = buildState(null, 1);  
        Predicate<ClusterState> predicate = ClusterManagerNodeChangePredicate.build(currentState);
            currentState.nodes().getClusterManagerNode().getEphemeralId()  
        assertEquals(fromState.test(newState), fromPrimitives.test(newState));
        Predicate<ClusterState> fromState = ClusterManagerNodeChangePredicate.build(currentState);  
 */
        ClusterState newState = buildState(clusterManagerNode, 5);
 * SPDX-License-Identifier: Apache-2.0
        super.setUp();  
import org.opensearch.Version;  
            currentState.version(),
        ClusterState currentState = buildState(clusterManagerNode, 1);
        assertTrue(predicate.test(buildState(clusterManagerNode, 1)));
        Predicate<ClusterState> fromPrimitives = ClusterManagerNodeChangePredicate.build(
/*  
        ClusterState currentState = buildState(clusterManagerNode, 5);
        assertTrue(predicate.test(buildState(clusterManagerNode, 1)));
        assertEquals(fromState.test(newState), fromPrimitives.test(newState));
            currentState.nodes().getClusterManagerNode().getEphemeralId()  
public class ClusterManagerNodeChangePredicateTests extends OpenSearchTestCase {
    private ClusterState buildState(DiscoveryNode clusterManagerNode, long version) {
        Predicate<ClusterState> predicate = ClusterManagerNodeChangePredicate.build(1, null);
        ClusterState currentState = buildState(clusterManagerNode, 5);
    public void testBuildPrimitivesWithNullCurrentClusterManagerAcceptsNewClusterManager() {
        ClusterState currentState = buildState(clusterManagerNode, 1);
        Predicate<ClusterState> fromPrimitives = ClusterManagerNodeChangePredicate.build(
        }
    }  
package org.opensearch.cluster;
        ClusterState newState = buildState(clusterManagerNode, 10);
        assertEquals(fromState.test(buildState(clusterManagerNode, 5)), fromPrimitives.test(buildState(clusterManagerNode, 5)));  
import org.opensearch.cluster.node.DiscoveryNode;
    public void testBothOverloadsAgreeOnNullCurrentClusterManager() {
        Predicate<ClusterState> predicate = ClusterManagerNodeChangePredicate.build(currentState);  
    }
        ClusterState newState = buildState(otherClusterManagerNode, 5);
        otherClusterManagerNode = new DiscoveryNode("new_master", buildNewFakeTransportAddress(), Version.CURRENT);
    }
    }
    public void testBothOverloadsAgreeOnVersionBump() {
        assertEquals(fromState.test(newState), fromPrimitives.test(newState));
    }
        assertEquals(fromState.test(buildState(null, 10)), fromPrimitives.test(buildState(null, 10)));
        Predicate<ClusterState> predicate = ClusterManagerNodeChangePredicate.build(currentState);
 * this file be licensed under the Apache-2.0 license or a
        assertFalse(predicate.test(buildState(clusterManagerNode, 1)));
 */  
    private DiscoveryNode otherClusterManagerNode;
        assertFalse(predicate.test(buildState(null, 5)));
        Predicate<ClusterState> fromState = ClusterManagerNodeChangePredicate.build(currentState);  
        DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder();  
    }
    }  
    }
        clusterManagerNode = new DiscoveryNode("old_master", buildNewFakeTransportAddress(), Version.CURRENT);
 * Tests for {@link ClusterManagerNodeChangePredicate}.
    @Override
 * Covers both the {@code build(ClusterState)} and {@code build(long, String)} overloads.  
    }
    public void setUp() throws Exception {
        assertTrue(predicate.test(buildState(otherClusterManagerNode, 1)));
        Predicate<ClusterState> fromState = ClusterManagerNodeChangePredicate.build(currentState);  
    }
        ClusterState currentState = buildState(clusterManagerNode, 1);  
 * compatible open source license.
import java.util.function.Predicate;
    public void testBuildPrimitivesWithNullCurrentClusterManagerRejectsNullNewClusterManager() {
        Predicate<ClusterState> fromPrimitives = ClusterManagerNodeChangePredicate.build(currentState.version(), null);
}  
    public void testBothOverloadsAgreeOnClusterManagerChange() {
    public void testAcceptsHigherVersionSameClusterManager() {
            nodesBuilder.add(clusterManagerNode);
    public void testRejectsSameVersionSameClusterManager() {  
        );
        if (clusterManagerNode != null) {
        Predicate<ClusterState> predicate = ClusterManagerNodeChangePredicate.build(currentState);
        ClusterState currentState = buildState(clusterManagerNode, 5);
        Predicate<ClusterState> predicate = ClusterManagerNodeChangePredicate.build(currentState);  
    public void testBothOverloadsAgreeOnNoChange() {
        Predicate<ClusterState> fromState = ClusterManagerNodeChangePredicate.build(currentState);  
    }  
        ClusterState currentState = buildState(clusterManagerNode, 1);
        assertFalse(predicate.test(buildState(null, 5)));  
