        assertThat(failedNodes, contains(node1));
            final long startTime = deterministicTaskQueue.getCurrentTimeMillis();  
import org.opensearch.common.unit.TimeValue;  
        assertThat(failedNodes, empty());
        );
        lagDetector.setTrackedNodes(Collections.singletonList(node1));
    }
        deterministicTaskQueue.runAllTasks();
            deterministicTaskQueue.getCurrentTimeMillis() + followerLagTimeout.millis() - 1,
        assertThat(failedNodes, empty());
        lagDetector.setTrackedNodes(Collections.singletonList(node2));  
        lagDetector.setAppliedVersion(node1, 1);
        failedNodes.clear();
 * SPDX-License-Identifier: Apache-2.0
        );
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
        assertThat(failedNodes, empty());
            deterministicTaskQueue.runAllTasks();
 * Unless required by applicable law or agreed to in writing,
        lagDetector.startLagDetector(4);
        lagDetector.startLagDetector(6);
        lagDetector.startLagDetector(1);
        deterministicTaskQueue.runAllTasksInTimeOrder();
    private DiscoveryNode node1, node2, localNode;  
        deterministicTaskQueue.runAllTasks();  
 *
 *
            assertThat("lag detector started", deterministicTaskQueue.getCurrentTimeMillis(), greaterThan(startTime));  
            deterministicTaskQueue.getCurrentTimeMillis() + followerLagTimeout.millis() + 1,  
        lagDetector.setTrackedNodes(Arrays.asList(node1, node2));
 */  
 * under the License.  
        assertThat(failedNodes, contains(node1));  
        deterministicTaskQueue.runAllTasks();  
import org.junit.Before;
import static org.hamcrest.Matchers.greaterThan;
        assertThat(failedNodes, empty()); // nodes added after a lag detector was started are also ignored  
        deterministicTaskQueue.scheduleAt(
        lagDetector.startLagDetector(2);
        lagDetector.setAppliedVersion(node2, 1);  
import static org.hamcrest.Matchers.is;
    public void testLagDetectedIfNodeAppliesEarlierVersionAfterLagDetectorStarted() {
}
        lagDetector.setTrackedNodes(Collections.singletonList(node1));  
        deterministicTaskQueue.runAllTasksInTimeOrder();
            deterministicTaskQueue.getCurrentTimeMillis() + followerLagTimeout.millis() + 1,
        failedNodes.clear();
        deterministicTaskQueue.runAllTasks();
        lagDetector.setAppliedVersion(node1, 2);
            deterministicTaskQueue.getCurrentTimeMillis() + followerLagTimeout.millis() - 1,  
    }
        deterministicTaskQueue.runAllTasksInTimeOrder();
    public void testLagDetectedIfNodeAppliesVersionJustAfterTimeout() {
            followerLagTimeout = CLUSTER_FOLLOWER_LAG_TIMEOUT_SETTING.get(Settings.EMPTY);
import static org.hamcrest.Matchers.contains;
        lagDetector.startLagDetector(8);
    private Set<DiscoveryNode> failedNodes;
        lagDetector.startLagDetector(1);
 */
        lagDetector.setTrackedNodes(Collections.singletonList(node1));
        assertThat(failedNodes, empty());
    public void testDetectorIgnoresApplicationsFromUnknownNodes() {  
    public void testLagDetectorNotStartedIfNodeHasAlreadyAppliedVersion() {
        deterministicTaskQueue.runAllTasksInTimeOrder();
        assertThat("lag detector started", deterministicTaskQueue.getCurrentTimeMillis(), greaterThan(startTime));
        lagDetector.setTrackedNodes(Collections.singletonList(node1));
        lagDetector.startLagDetector(1);
/*  
        assertThat(failedNodes, contains(node2));  
 *     http://www.apache.org/licenses/LICENSE-2.0
    public void testNoLagDetectedOnLocalNode() {
        lagDetector.startLagDetector(1);  
        assertThat(failedNodes, contains(node1));
        );  
        lagDetector.setTrackedNodes(Collections.singletonList(localNode));
        lagDetector.startLagDetector(1);
    }
        lagDetector.startLagDetector(9);  
import org.opensearch.test.OpenSearchTestCase;
        failedNodes.clear(); // ... but later lag detectors still work
    }
        lagDetector.setTrackedNodes(Collections.singletonList(node1));
    public void setupFixture() {
        deterministicTaskQueue.runAllTasks();  
        deterministicTaskQueue.runAllTasksInTimeOrder();  
    }  
        lagDetector.startLagDetector(5);
        assertThat(failedNodes, contains(node1));
        lagDetector.setTrackedNodes(Arrays.asList(node1, node2));
        }  
    public void testLagDetection() {
        lagDetector.startLagDetector(2);
    public void testNoLagDetectedIfNodeAppliesLaterVersionAfterLagDetectorStarted() {
        assertThat(failedNodes, empty());
 */
import static org.opensearch.node.Node.NODE_NAME_SETTING;
        lagDetector.setTrackedNodes(Collections.singletonList(node1));  
        lagDetector.setAppliedVersion(node1, 1);  
 * KIND, either express or implied.  See the License for the
package org.opensearch.cluster.coordination;
        assertThat(failedNodes, empty());  
import java.util.HashSet;  
        lagDetector.setAppliedVersion(node1, 1);
        assertThat(failedNodes, empty()); // clearing tracked nodes cancels earlier lag detector ...  
import org.opensearch.common.settings.ClusterSettings;
    }
        {  
 * this work for additional information regarding copyright
        lagDetector.setAppliedVersion(node1, 2);
        lagDetector.setTrackedNodes(Collections.singletonList(node1));  
        localNode = CoordinationStateTests.createNode("local");
        if (randomBoolean()) {
        lagDetector.startLagDetector(1);
        } else {
 *  
    private DeterministicTaskQueue deterministicTaskQueue;  
        node1 = CoordinationStateTests.createNode("node1");  
        assertThat(failedNodes, empty());
        final long startTime = deterministicTaskQueue.getCurrentTimeMillis();  
        assertThat(failedNodes, empty());
        deterministicTaskQueue.runAllTasks();  
        lagDetector.setTrackedNodes(Collections.singletonList(node1));
/*
        assertThat(failedNodes, empty());  
    }
        lagDetector.startLagDetector(1);
import org.opensearch.common.settings.Settings;
 * You may obtain a copy of the License at  
    public void testNoLagDetectedIfDetectorIsClearedAfterLagDetectorStarted() {  
        );  
        lagDetector.setTrackedNodes(Collections.singletonList(node1));
        Settings settings = settingsBuilder.build();
        lagDetector.setTrackedNodes(Collections.singletonList(node1));
        deterministicTaskQueue.scheduleAt(
 * ownership. Elasticsearch licenses this file to you under  
        lagDetector.setTrackedNodes(Collections.singletonList(node2));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Arrays;
public class LagDetectorTests extends OpenSearchTestCase {
            () -> lagDetector.setAppliedVersion(node1, 1)
/*
        assertThat(failedNodes, contains(node1));
        lagDetector.startLagDetector(3);
        lagDetector.setTrackedNodes(Collections.singletonList(node1));  
            deterministicTaskQueue.runAllTasks();
        deterministicTaskQueue.runAllTasks();
    public void testNoLagDetectedIfNodeAppliesVersionAfterLagDetectorStarted() {
import static org.opensearch.cluster.coordination.LagDetector.CLUSTER_FOLLOWER_LAG_TIMEOUT_SETTING;  
import org.opensearch.cluster.node.DiscoveryNode;  
 * Modifications Copyright OpenSearch Contributors. See  
 * The OpenSearch Contributors require contributions made to  
    }
        lagDetector.startLagDetector(2);  
        deterministicTaskQueue.runAllTasksInTimeOrder();
 * compatible open source license.
        deterministicTaskQueue.runAllTasks();
        lagDetector.startLagDetector(1);  
        deterministicTaskQueue.runAllTasksInTimeOrder();
    }
    public void testDetectorIgnoresNodesAddedAfterStarted() {
        }
        deterministicTaskQueue.runAllTasks();  
        deterministicTaskQueue.scheduleAt(  
        deterministicTaskQueue.scheduleAt(  
        deterministicTaskQueue.runAllTasks();
        lagDetector.setTrackedNodes(Collections.singletonList(node1));
    private TimeValue followerLagTimeout;
        lagDetector.setAppliedVersion(node2, 7);
        final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        deterministicTaskQueue.runAllTasks();
        lagDetector.clearTrackedNodes();  
    public void testNoLagDetectedIfNodeIsRemovedAfterLagDetectorStarted() {  
        lagDetector.startLagDetector(1);
        lagDetector.setTrackedNodes(Collections.singletonList(node1));
 * this file be licensed under the Apache-2.0 license or a
        assertThat("no lag detector started", deterministicTaskQueue.getCurrentTimeMillis(), is(startTime));
        assertThat(failedNodes, empty());
            final long startTime = deterministicTaskQueue.getCurrentTimeMillis();
            followerLagTimeout = TimeValue.timeValueMillis(randomLongBetween(2, 100000));
        lagDetector.startLagDetector(1);  
        lagDetector.startLagDetector(7);  
        lagDetector.startLagDetector(1);
        lagDetector.setAppliedVersion(node1, 1);  
 * software distributed under the License is distributed on an
        final long startTime = deterministicTaskQueue.getCurrentTimeMillis();
        {
        lagDetector.startLagDetector(2);
            assertThat("no lag detector started", deterministicTaskQueue.getCurrentTimeMillis(), is(startTime));
        deterministicTaskQueue = new DeterministicTaskQueue(Settings.builder().put(NODE_NAME_SETTING.getKey(), "node").build(), random());
        failedNodes.clear();  
import java.util.Set;
        deterministicTaskQueue.runAllTasksInTimeOrder();
import static org.hamcrest.Matchers.empty;  
        failedNodes = new HashSet<>();
        lagDetector.setTrackedNodes(Collections.singletonList(node1));
    private LagDetector lagDetector;
    }  
        deterministicTaskQueue.runAllTasks();
        lagDetector = new LagDetector(settings, clusterSettings, deterministicTaskQueue.getThreadPool(), failedNodes::add, () -> localNode);  
        assertThat(failedNodes, contains(node1));
        assertThat(failedNodes, contains(node1));
        Settings.Builder settingsBuilder = Settings.builder();  
        assertThat(failedNodes, contains(node2));  
        lagDetector.setTrackedNodes(Collections.singletonList(node1));
        assertThat(failedNodes, empty());
            settingsBuilder.put(CLUSTER_FOLLOWER_LAG_TIMEOUT_SETTING.getKey(), followerLagTimeout.millis() + "ms");  
        deterministicTaskQueue.runAllTasksInTimeOrder();  
            () -> lagDetector.setAppliedVersion(node1, 3)
        }  
        lagDetector.setTrackedNodes(Collections.singletonList(node1));
        lagDetector.setAppliedVersion(node1, 1);
 * the Apache License, Version 2.0 (the "License"); you may
    }  
        lagDetector.startLagDetector(2);
        lagDetector.startLagDetector(1);
    }
            () -> lagDetector.setAppliedVersion(node1, 4)
import java.util.Collections;
        lagDetector.clearTrackedNodes();  
        assertThat(failedNodes, empty()); // removing a node from the tracked set means it is not tracked
    @Before  
 * specific language governing permissions and limitations
    }
 * GitHub history for details.
            () -> lagDetector.setAppliedVersion(node1, 1)
    public void testNoLagDetectedIfNodeAppliesVersionJustBeforeTimeout() {  
    }
        assertThat(failedNodes, contains(node1));  
 * Licensed to Elasticsearch under one or more contributor  
        node2 = CoordinationStateTests.createNode("node2");
    public void testDetectorKeepsTrackingExistingNodesEvenIfNewOnesAdded() {
