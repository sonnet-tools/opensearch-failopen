        deterministicTaskQueue.runAllTasks();
        lagDetector.startLagDetector(1);
            followerLagTimeout = TimeValue.timeValueMillis(randomLongBetween(2, 100000));
 */
        assertThat(failedNodes, empty());
import static org.hamcrest.Matchers.contains;
        deterministicTaskQueue.runAllTasksInTimeOrder();
            deterministicTaskQueue.getCurrentTimeMillis() + followerLagTimeout.millis() + 1,
        failedNodes.clear();
        lagDetector.setTrackedNodes(Collections.singletonList(node1));
        deterministicTaskQueue.runAllTasks();
        assertThat(failedNodes, empty());
import static org.opensearch.cluster.coordination.LagDetector.CLUSTER_FOLLOWER_LAG_TIMEOUT_SETTING;
import static org.hamcrest.Matchers.empty;
    private TimeValue followerLagTimeout;
import org.opensearch.cluster.node.DiscoveryNode;
        lagDetector.startLagDetector(8);
        node1 = CoordinationStateTests.createNode("node1");
        deterministicTaskQueue.runAllTasks();
 * compatible open source license.
    }
        deterministicTaskQueue.runAllTasks();
        );
        lagDetector.setAppliedVersion(node1, 1);
        lagDetector.startLagDetector(2);
        lagDetector.startLagDetector(5);
    }
        deterministicTaskQueue.runAllTasksInTimeOrder();
        lagDetector.startLagDetector(1);
        Settings.Builder settingsBuilder = Settings.builder();
        deterministicTaskQueue.runAllTasksInTimeOrder();
 *
        failedNodes = new HashSet<>();
        failedNodes.clear(); // ... but later lag detectors still work
        assertThat(failedNodes, empty());
        deterministicTaskQueue.runAllTasksInTimeOrder();
        deterministicTaskQueue.runAllTasks();
        } else {
        lagDetector.setTrackedNodes(Collections.singletonList(node1));
import static org.hamcrest.Matchers.greaterThan;
    }
        lagDetector.setAppliedVersion(node2, 7);
        lagDetector.setTrackedNodes(Collections.singletonList(node2));
        lagDetector.setTrackedNodes(Collections.singletonList(node1));
    public void testNoLagDetectedIfNodeAppliesVersionJustBeforeTimeout() {
 * specific language governing permissions and limitations
        lagDetector.startLagDetector(1);
        lagDetector.setAppliedVersion(node1, 1);
import java.util.Set;
        lagDetector.startLagDetector(1);
            () -> lagDetector.setAppliedVersion(node1, 4)
            assertThat("no lag detector started", deterministicTaskQueue.getCurrentTimeMillis(), is(startTime));
            followerLagTimeout = CLUSTER_FOLLOWER_LAG_TIMEOUT_SETTING.get(Settings.EMPTY);
 * Licensed to Elasticsearch under one or more contributor
import java.util.HashSet;
 * GitHub history for details.
    public void testNoLagDetectedOnLocalNode() {
        deterministicTaskQueue.runAllTasks();
import static org.opensearch.node.Node.NODE_NAME_SETTING;
        failedNodes.clear();
        deterministicTaskQueue.runAllTasksInTimeOrder();
        lagDetector.setAppliedVersion(node1, 2);
package org.opensearch.cluster.coordination;
        assertThat("lag detector started", deterministicTaskQueue.getCurrentTimeMillis(), greaterThan(startTime));
        lagDetector.setTrackedNodes(Collections.singletonList(node1));
}
        failedNodes.clear();
        final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        lagDetector.startLagDetector(2);
        deterministicTaskQueue.runAllTasks();
import static org.hamcrest.Matchers.is;
        assertThat(failedNodes, contains(node1));
    }
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
        assertThat(failedNodes, empty());
        lagDetector.startLagDetector(3);
 * You may obtain a copy of the License at
        lagDetector = new LagDetector(settings, clusterSettings, deterministicTaskQueue.getThreadPool(), failedNodes::add, () -> localNode);
        lagDetector.startLagDetector(1);
import java.util.Arrays;
 * under the License.
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(failedNodes, empty());
            () -> lagDetector.setAppliedVersion(node1, 1)
import java.util.Collections;
        lagDetector.setTrackedNodes(Collections.singletonList(localNode));
        lagDetector.clearTrackedNodes();
 *
 * Modifications Copyright OpenSearch Contributors. See
    public void testDetectorKeepsTrackingExistingNodesEvenIfNewOnesAdded() {
        lagDetector.setTrackedNodes(Collections.singletonList(node1));
        assertThat(failedNodes, empty());
        lagDetector.setTrackedNodes(Collections.singletonList(node1));
        lagDetector.setTrackedNodes(Collections.singletonList(node1));
            final long startTime = deterministicTaskQueue.getCurrentTimeMillis();
 *
        lagDetector.startLagDetector(2);
        lagDetector.setTrackedNodes(Arrays.asList(node1, node2));
 * not use this file except in compliance with the License.
        );
            () -> lagDetector.setAppliedVersion(node1, 3)
        assertThat(failedNodes, contains(node2));
        lagDetector.setTrackedNodes(Collections.singletonList(node1));
        lagDetector.setTrackedNodes(Collections.singletonList(node1));
    }
            assertThat("lag detector started", deterministicTaskQueue.getCurrentTimeMillis(), greaterThan(startTime));
        assertThat(failedNodes, contains(node1));
        deterministicTaskQueue.runAllTasks();
 * this file be licensed under the Apache-2.0 license or a
    public void testNoLagDetectedIfNodeIsRemovedAfterLagDetectorStarted() {
        deterministicTaskQueue.runAllTasksInTimeOrder();
    public void testDetectorIgnoresApplicationsFromUnknownNodes() {
        lagDetector.setAppliedVersion(node1, 1);
        deterministicTaskQueue.runAllTasks();
            () -> lagDetector.setAppliedVersion(node1, 1)
    private Set<DiscoveryNode> failedNodes;
            deterministicTaskQueue.runAllTasks();
/*
    private DeterministicTaskQueue deterministicTaskQueue;
    }
            deterministicTaskQueue.getCurrentTimeMillis() + followerLagTimeout.millis() - 1,
 * Unless required by applicable law or agreed to in writing,
        assertThat(failedNodes, empty());
        lagDetector.setTrackedNodes(Collections.singletonList(node1));
        );
/*
            settingsBuilder.put(CLUSTER_FOLLOWER_LAG_TIMEOUT_SETTING.getKey(), followerLagTimeout.millis() + "ms");
        lagDetector.startLagDetector(9);
        lagDetector.setTrackedNodes(Collections.singletonList(node1));
        assertThat(failedNodes, contains(node1));
import org.opensearch.test.OpenSearchTestCase;
    }
        lagDetector.startLagDetector(1);
    }
import org.opensearch.common.settings.Settings;
        deterministicTaskQueue.runAllTasksInTimeOrder();
    }
        assertThat(failedNodes, empty()); // nodes added after a lag detector was started are also ignored
        lagDetector.setTrackedNodes(Collections.singletonList(node2));
    public void testLagDetectorNotStartedIfNodeHasAlreadyAppliedVersion() {
        {
 * KIND, either express or implied.  See the License for the
    }
        assertThat(failedNodes, empty());
        lagDetector.startLagDetector(1);
    public void testLagDetectedIfNodeAppliesEarlierVersionAfterLagDetectorStarted() {
    }
        lagDetector.clearTrackedNodes();
        assertThat(failedNodes, contains(node1));
 */
    public void testNoLagDetectedIfNodeAppliesLaterVersionAfterLagDetectorStarted() {
    }
        lagDetector.setAppliedVersion(node1, 2);
            deterministicTaskQueue.runAllTasks();
 * license agreements. See the NOTICE file distributed with
        lagDetector.startLagDetector(1);
        deterministicTaskQueue.runAllTasksInTimeOrder();
            final long startTime = deterministicTaskQueue.getCurrentTimeMillis();
 * software distributed under the License is distributed on an
        final long startTime = deterministicTaskQueue.getCurrentTimeMillis();
        lagDetector.startLagDetector(4);
        lagDetector.setTrackedNodes(Collections.singletonList(node1));
        lagDetector.setTrackedNodes(Collections.singletonList(node1));
        deterministicTaskQueue.runAllTasks();
        deterministicTaskQueue.scheduleAt(
    public void testNoLagDetectedIfNodeAppliesVersionAfterLagDetectorStarted() {
    public void testLagDetection() {
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(failedNodes, contains(node1));
        assertThat(failedNodes, contains(node1));
        assertThat(failedNodes, contains(node2));
        Settings settings = settingsBuilder.build();
        assertThat(failedNodes, empty());
        lagDetector.startLagDetector(7);
        if (randomBoolean()) {
            deterministicTaskQueue.getCurrentTimeMillis() + followerLagTimeout.millis() + 1,
        node2 = CoordinationStateTests.createNode("node2");
        deterministicTaskQueue.runAllTasks();
        deterministicTaskQueue = new DeterministicTaskQueue(Settings.builder().put(NODE_NAME_SETTING.getKey(), "node").build(), random());
        deterministicTaskQueue.runAllTasksInTimeOrder();
        lagDetector.setTrackedNodes(Collections.singletonList(node1));
    public void testDetectorIgnoresNodesAddedAfterStarted() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
        }
        {
        lagDetector.startLagDetector(2);
import org.opensearch.common.unit.TimeValue;
 * The OpenSearch Contributors require contributions made to
            deterministicTaskQueue.getCurrentTimeMillis() + followerLagTimeout.millis() - 1,
        deterministicTaskQueue.scheduleAt(
import org.opensearch.common.settings.ClusterSettings;
        assertThat(failedNodes, contains(node1));
        lagDetector.setAppliedVersion(node1, 1);
    }
        assertThat(failedNodes, contains(node1));
    public void testLagDetectedIfNodeAppliesVersionJustAfterTimeout() {
        lagDetector.setAppliedVersion(node1, 1);
        deterministicTaskQueue.runAllTasks();
        lagDetector.setAppliedVersion(node2, 1);
        assertThat(failedNodes, empty());
        final long startTime = deterministicTaskQueue.getCurrentTimeMillis();
        assertThat(failedNodes, empty());
        assertThat(failedNodes, empty()); // removing a node from the tracked set means it is not tracked
 * ownership. Elasticsearch licenses this file to you under
        lagDetector.setTrackedNodes(Collections.singletonList(node1));
        localNode = CoordinationStateTests.createNode("local");
        assertThat(failedNodes, empty()); // clearing tracked nodes cancels earlier lag detector ...
public class LagDetectorTests extends OpenSearchTestCase {
        assertThat("no lag detector started", deterministicTaskQueue.getCurrentTimeMillis(), is(startTime));
    @Before
        lagDetector.startLagDetector(1);
        deterministicTaskQueue.scheduleAt(
        );
        lagDetector.startLagDetector(1);
 */
        lagDetector.startLagDetector(2);
        }
    public void setupFixture() {
        lagDetector.startLagDetector(6);
    private LagDetector lagDetector;
    }
        deterministicTaskQueue.scheduleAt(
        lagDetector.startLagDetector(1);
        lagDetector.setTrackedNodes(Arrays.asList(node1, node2));
/*
    private DiscoveryNode node1, node2, localNode;
import org.junit.Before;
        lagDetector.setTrackedNodes(Collections.singletonList(node1));
    public void testNoLagDetectedIfDetectorIsClearedAfterLagDetectorStarted() {
        lagDetector.startLagDetector(1);
