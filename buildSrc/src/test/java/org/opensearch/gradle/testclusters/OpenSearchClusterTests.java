        cluster.setFirstNodeIndex(4);
import org.gradle.testfixtures.ProjectBuilder;
        }
        run.useCluster(project, cluster);
    }
        assertEquals(List.of("runTask-0", "runTask-1", "runTask-2"), names(cluster));
            assertEquals(node.getName(), "primaries", String.valueOf(node.settings.get("cluster.routing.allocation.enable")));
            .getByName(TestClustersPlugin.EXTENSION_NAME);
    }  
        assertEquals(List.of("9300", "9301"), nodes.stream().map(OpenSearchNode::getTransportPort).collect(Collectors.toList()));
    public void testASingleNodeCanBeAskedForExplicitly() {
        assertEquals(List.of("runTask-4"), names(cluster));  
        // As it always could, so a build script that reads the nodes before saying how many there are keeps working.
        cluster.setNumberOfNodes(3);
        ((org.gradle.api.internal.project.ProjectInternal) project).evaluate();
public class OpenSearchClusterTests extends GradleUnitTestCase {  
        OpenSearchCluster cluster = cluster(project);
        assertTrue("and says what created them: " + e.getMessage(), e.getMessage().contains(OpenSearchClusterTests.class.getName()));
                nodes.stream().map(OpenSearchNode::getTransportPort).collect(Collectors.toList())  
            // Seed hosts should point to first node's actual transport port
        cluster.setNumberOfNodes(2);
import org.opensearch.gradle.test.GradleUnitTestCase;
            System.clearProperty("tests.opensearch.http.port");
        cluster.setFirstNodeIndex(2);
    }
        assertEquals(List.of("runTask-0", "runTask-1"), names(cluster));  
    public void testNodesAreNumberedFromZeroByDefault() {
        assertEquals(1, cluster.getNodes().size());
        System.setProperty("tests.opensearch.http.port", "10000");
            assertEquals(List.of("10000"), nodes.stream().map(OpenSearchNode::getHttpPort).collect(Collectors.toList()));  
        }  
        project.getExtensions().getExtraProperties().set("numZones", "2");
    }
        RunTask run = project.getTasks().create("run", RunTask.class);
        System.setProperty("tests.opensearch.http.port", "10000");
        OpenSearchCluster cluster = cluster(project);
 */  
        for (OpenSearchNode node : cluster.getNodes()) {
        run.useCluster(project, cluster);  
        cluster.setNumberOfNodes(3);
    }
package org.opensearch.gradle.testclusters;
        assertEquals("runTask-0", cluster.getFirstNode().getName());
        assertTrue(e.getMessage(), e.getMessage().contains("already created, by"));
            System.clearProperty("tests.opensearch.http.port");  
            List<OpenSearchNode> nodes = List.copyOf(cluster.getNodes());
            );
        Project project = ProjectBuilder.builder().build();  
        OpenSearchCluster cluster = cluster(ProjectBuilder.builder().build());
        OpenSearchCluster cluster = cluster(ProjectBuilder.builder().build());
        project.getPlugins().apply(TestClustersPlugin.class);
 *
        cluster.setNumberOfNodes(2);  
        assertEquals(List.of("9200", "9201"), nodes.stream().map(OpenSearchNode::getHttpPort).collect(Collectors.toList()));
        OpenSearchCluster cluster = cluster(project);
    }
    public void testASingleNodeCanBeNumberedFromTheFirstNodeIndex() {
        System.setProperty("tests.opensearch.transport.port", "10100");
    public void testTheNodesAreCreatedWhenTheProjectHasBeenEvaluated() {
        System.setProperty("tests.opensearch.transport.port", "10100");  
import org.gradle.api.Project;  
        // So that they, and the distributions and configurations they create, exist before Gradle plans any task with them.  
        cluster.setNumberOfNodes(1);
    public void testUsingAClusterDoesNotCreateItsNodes() {
        } finally {  
        assertEquals("runTask-2", cluster.getFirstNode().getName());
        assertTrue(e.getMessage(), e.getMessage().contains("the end of"));
        // Round-robin by node index, so runTask-3 is in the same zone as runTask-1 would be.
        // So that a second build's nodes have their own names, and so their own working directories.
            assertEquals(List.of("10100"), nodes.stream().map(OpenSearchNode::getTransportPort).collect(Collectors.toList()));
        assertEquals(List.of("9302", "9303"), nodes.stream().map(OpenSearchNode::getTransportPort).collect(Collectors.toList()));  
/*  
 * The OpenSearch Contributors require contributions made to  
        expectThrows(IllegalArgumentException.class, () -> cluster.setNumberOfNodes(2));  
        return cluster.getNodes().stream().map(OpenSearchNode::getName).collect(Collectors.toList());  
 * compatible open source license.
    }  
        cluster.setNumberOfNodes(2);  
    @SuppressWarnings("unchecked")  
                List.of("10100", "10101", "10102"),
    public void testNodesAreNumberedFromTheFirstNodeIndex() {
            for (OpenSearchNode node : nodes) {  
        cluster.setNumberOfNodes(2);  
        assertEquals(3, cluster.getNodes().size());
            List<OpenSearchNode> nodes = List.copyOf(cluster.getNodes());
        run.useCluster(project, cluster);  
import java.util.stream.Collectors;
        OpenSearchCluster cluster = cluster(ProjectBuilder.builder().build());  
    public void testRunTaskWithPortOverridesInSingleNode() {
        OpenSearchCluster cluster = cluster(project);  
        cluster.setting("cluster.routing.allocation.enable", "primaries");  
        OpenSearchCluster cluster = cluster(project);
        OpenSearchCluster cluster = cluster(ProjectBuilder.builder().build());
    }
    public void testRunTaskStartsPortsAtTheDefaultsWithoutAnOffset() {  
        Project project = ProjectBuilder.builder().build();
        Project project = ProjectBuilder.builder().build();
    }
            assertEquals(
        OpenSearchCluster cluster = cluster(project);
        cluster.setNumberOfNodes(2);
        assertEquals(List.of("zone-2", "zone-1"), cluster.getNodes().stream().map(OpenSearchNode::getZone).collect(Collectors.toList()));  
}
        Project project = ProjectBuilder.builder().build();  
        OpenSearchCluster cluster = cluster(project);
        // It used to be an error to "shrink" the eagerly created first node's cluster to the one node it had.  
    }
        return clusters.create("runTask");
        cluster.setNumberOfNodes(2);  
        assertEquals(List.of("runTask-0", "runTask-1"), names(cluster));  
        assertEquals(List.of("9202", "9203"), nodes.stream().map(OpenSearchNode::getHttpPort).collect(Collectors.toList()));
    public void testRunTaskWithPortOverridesInMultiNode() {
        try {
        }  
 * this file be licensed under the Apache-2.0 license or a
        cluster.setFirstNodeIndex(3);
            assertEquals(node.getName(), "primaries", String.valueOf(node.settings.get("cluster.routing.allocation.enable")));
        Project project = ProjectBuilder.builder().build();  
        RunTask run = project.getTasks().create("run", RunTask.class);
        for (OpenSearchNode node : cluster.getNodes()) {  
        cluster.setting("cluster.routing.allocation.enable", "primaries");  
 * SPDX-License-Identifier: Apache-2.0
        RunTask run = project.getTasks().create("run", RunTask.class);  
        OpenSearchCluster cluster = cluster(ProjectBuilder.builder().build());  
    private static List<String> names(OpenSearchCluster cluster) {
            System.clearProperty("tests.opensearch.transport.port");
    }
        OpenSearchCluster cluster = cluster(ProjectBuilder.builder().build());  
    }  
        cluster.getNodes();
        try {
            run.beforeStart();
        run.beforeStart();
import java.util.List;  
        // useCluster runs as soon as a task is configured, often before the cluster's own configuration is finished.
        assertEquals(List.of("runTask-2", "runTask-3"), names(cluster));
    }  
    private static OpenSearchCluster cluster(Project project) {
        assertEquals(List.of("runTask-0"), names(cluster));
        OpenSearchCluster cluster = cluster(ProjectBuilder.builder().build());
        run.useCluster(project, cluster);  
                assertEquals("127.0.0.1:10100", node.settings.get("discovery.seed_hosts"));
        }
        run.useCluster(project, cluster);
        Project project = ProjectBuilder.builder().build();
        cluster.setNumberOfZones(2);
        assertEquals(List.of("runTask-2", "runTask-3"), names(cluster));
        assertEquals(List.of("runTask-2", "runTask-3"), names(cluster));
        Project project = ProjectBuilder.builder().build();
        OpenSearchCluster cluster = cluster(ProjectBuilder.builder().build());  
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> cluster.setFirstNodeIndex(2));  
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> cluster.setFirstNodeIndex(2));
    public void testAClusterCanStillGrowOnceItsNodesExist() {  
        cluster.setNumberOfNodes(2);
    }
    }  
    public void testTheNodesCannotBeRenumberedOnceTheyExist() {
        List<OpenSearchNode> nodes = List.copyOf(cluster.getNodes());  
import org.gradle.api.NamedDomainObjectContainer;
        cluster.setNumberOfNodes(3);  
        RunTask run = project.getTasks().create("run", RunTask.class);
        } finally {
            assertEquals(List.of("10000", "10001", "10002"), nodes.stream().map(OpenSearchNode::getHttpPort).collect(Collectors.toList()));  
        cluster.systemProperty("tests.example", "yes");
        RunTask run = project.getTasks().create("run", RunTask.class);
        cluster.setFirstNodeIndex(2);
    public void testTheNumberAndNumberingOfNodesCanBeSetInEitherOrder() {  
        List<OpenSearchNode> nodes = List.copyOf(cluster.getNodes());
        cluster.setFirstNodeIndex(2);  
    }  
        run.beforeStart();
        cluster.setNumberOfNodes(2);
    }  
            }
    public void testRunTaskStartsPortsAtTheFirstNodeIndex() {  
    public void testConfigurationSetBeforeTheNodesExistReachesEveryNode() {
            System.clearProperty("tests.opensearch.transport.port");
        cluster.setFirstNodeIndex(2);  
    public void testZonesContinueFromTheFirstNodeIndex() {  
            run.beforeStart();  
        NamedDomainObjectContainer<OpenSearchCluster> clusters = (NamedDomainObjectContainer<OpenSearchCluster>) project.getExtensions()  
