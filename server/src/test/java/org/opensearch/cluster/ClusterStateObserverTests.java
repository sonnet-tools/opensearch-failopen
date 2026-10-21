        when(clusterApplierService.state()).thenReturn(newerState);
            }
            }
import java.util.Arrays;
            .nodes(DiscoveryNodes.builder().add(masterNode).clusterManagerNodeId(masterNode.getId()))
 * software distributed under the License is distributed on an
import org.opensearch.test.OpenSearchTestCase;
    /**
            }
     * detects when a master appears.
        doAnswer(invocation -> {
        });
 * under the License.
        final ThreadPool threadPool = mock(ThreadPool.class);
            @Override
            .version(10)
}
            new ThreadContext(Settings.EMPTY)
        assertNotNull(receivedState.get());
                receivedState.set(state);
            .nodes(DiscoveryNodes.builder().add(oldMaster).add(newMaster).clusterManagerNodeId(newMaster.getId()))
            logger,
 * GitHub history for details.
        when(clusterService.getClusterApplierService()).thenReturn(clusterApplierService);
 * Unless required by applicable law or agreed to in writing,
            @Override
            logger,
        final ClusterApplierService clusterApplierService = mock(ClusterApplierService.class);
            public void onNewClusterState(ClusterState state) {
            public void onTimeout(TimeValue timeout) {}
        final ClusterStateObserver observer = new ClusterStateObserver(
import org.opensearch.Version;
        when(clusterApplierService.state()).thenReturn(newerState);
        final AtomicBoolean listenerAdded = new AtomicBoolean();
        // The sampled state (version 5) is newer than stored (version 1) with same master,
        final ThreadPool threadPool = mock(ThreadPool.class);
                receivedState.set(state);
     * to the ClusterApplierService-based constructor.
        // Construct with persistent node ID and version 1 — newerState has version 5, same master
            clusterApplierService,
        observer.waitForNextChange(new ClusterStateObserver.Listener() {
        assertNotNull(receivedState.get());
        assertFalse(listenerAdded.get());
            public void onClusterServiceClose() {}
        // so the predicate should accept it immediately without adding a listener
        observer.waitForNextChange(new ClusterStateObserver.Listener() {
        final ClusterState newMasterState = ClusterState.builder(new ClusterName("test"))
        when(clusterApplierService.threadPool()).thenReturn(threadPool);
            .build();
 * compatible open source license.
            public void onTimeout(TimeValue timeout) {}
        final ClusterStateObserver observer = new ClusterStateObserver(
            listenerAdded.set(true);
            public void onNewClusterState(ClusterState state) {}
            public String toString() {
        final ClusterState newerState = ClusterState.builder(new ClusterName("test"))
            @Override
        );
            @Override
            TimeValue.timeValueSeconds(30),
        });
            public void onClusterServiceClose() {}
 * this work for additional information regarding copyright
        }).when(clusterApplierService).addTimeoutListener(any(), any());
            listenerAdded.set(true);
        // Different master (null -> newMaster) — should accept immediately
import org.opensearch.cluster.service.ClusterApplierService;
            .build();
                receivedState.set(state);
    }
            .build();
            @Override
 * the Apache License, Version 2.0 (the "License"); you may
    }
            TimeValue.timeValueSeconds(30),
        final ClusterStateObserver clusterStateObserver = new ClusterStateObserver(
    }
    public void testPrimitiveConstructorViaClusterService() {
        final AtomicReference<ClusterState> receivedState = new AtomicReference<>();
            5L,
        final ClusterStateObserver observer = new ClusterStateObserver(
     * when the current state has the same version and master as the stored state.
        when(clusterApplierService.threadPool()).thenReturn(threadPool);
        assertTrue(listenerAdded.get());
        );
 * SPDX-License-Identifier: Apache-2.0
        when(clusterApplierService.state()).thenReturn(sameState);
        final ThreadPool threadPool = mock(ThreadPool.class);
            clusterApplierService,
    public void testPrimitiveConstructorNullMasterDetectsNewMaster() {
        final ClusterState stateWithMaster = ClusterState.builder(new ClusterName("test"))
            @Override
 */
            listenerAdded.set(true);
        assertFalse(listenerAdded.get());
        // Construct with same persistent node ID and same version — should NOT detect a change
        final ClusterState sameState = ClusterState.builder(new ClusterName("test"))
            .build();
        final ClusterStateObserver observer = new ClusterStateObserver(
        }).when(clusterApplierService).addTimeoutListener(any(), any());
import org.opensearch.cluster.service.ClusterService;
 * You may obtain a copy of the License at
        when(threadPool.relativeTimeInMillis()).thenReturn(0L);
        // Construct with null master ID — simulates "no master" initial state
            return null;
            @Override
            5L,
            public void onNewClusterState(ClusterState state) {
     * the ClusterState-based constructor.
        );
            logger,
            masterNode.getId(),
            public void onClusterServiceClose() {}
            logger,
            oldMaster.getId(),
import static org.mockito.Mockito.when;
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(5L, receivedState.get().version());
import org.opensearch.cluster.node.DiscoveryNode;
            logger,
            .version(5)
package org.opensearch.cluster;
     * Tests that the ClusterService-based primitive constructor delegates correctly
        final ClusterApplierService clusterApplierService = mock(ClusterApplierService.class);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *
            }
import static org.mockito.Mockito.mock;
     * correctly detects a newer cluster state via waitForNextChange, matching the behavior of
        // Newer version detected — should accept immediately
        final ClusterStateObserver observer = new ClusterStateObserver(
            clusterApplierService,
            public void onNewClusterState(ClusterState state) {
        });
        }).when(clusterApplierService).addTimeoutListener(any(), any());
    public void testClusterStateListenerToStringIncludesListenerToString() {
        final AtomicReference<ClusterState> receivedState = new AtomicReference<>();
        );
        assertFalse("should not need to add listener", listenerAdded.get());
            public void onNewClusterState(ClusterState state) {
        doAnswer(invocation -> {
import static org.mockito.Mockito.any;
 * The OpenSearch Contributors require contributions made to
        assertEquals(10L, receivedState.get().version());
            new ThreadContext(Settings.EMPTY)
            clusterApplierService,
        observer.waitForNextChange(new ClusterStateObserver.Listener() {
        final DiscoveryNode masterNode = new DiscoveryNode("master", buildNewFakeTransportAddress(), Version.CURRENT);
            return null;
        });
        observer.waitForNextChange(new ClusterStateObserver.Listener() {
        assertNotNull(receivedState.get());
                return "test-listener";
import org.opensearch.common.settings.Settings;
            TimeValue.timeValueSeconds(30),
        doAnswer(invocation -> {
        }).when(clusterApplierService).addTimeoutListener(any(), any());
 * license agreements. See the NOTICE file distributed with
    /**
        final DiscoveryNode oldMaster = new DiscoveryNode("old_master", buildNewFakeTransportAddress(), Version.CURRENT);
            @Override
     * Tests that the ClusterStateObserver constructed with (String, long) detects a different
    }
     * cluster manager even when the version is the same.
        final ThreadPool threadPool = mock(ThreadPool.class);
            1L,
        // Different master detected — should accept immediately
     */
            masterNode.getId(),
    }
            new ThreadContext(Settings.EMPTY)
            null,
 * not use this file except in compliance with the License.
            return null;
import org.opensearch.common.unit.TimeValue;
        observer.waitForNextChange(new ClusterStateObserver.Listener() {
        final AtomicReference<ClusterState> receivedState = new AtomicReference<>();
     */
            new ThreadContext(Settings.EMPTY)
        });
    public void testPrimitiveConstructorDetectsNewerState() {
                receivedState.set(state);
import org.opensearch.threadpool.ThreadPool;
        final DiscoveryNode masterNode = new DiscoveryNode("master", buildNewFakeTransportAddress(), Version.CURRENT);
            .version(5)
import java.util.concurrent.atomic.AtomicReference;
            public void onClusterServiceClose() {}
            public void onNewClusterState(ClusterState state) {
            @Override
        final AtomicReference<ClusterState> receivedState = new AtomicReference<>();
            new ThreadContext(Settings.EMPTY)
        assertTrue(listenerAdded.get());
import static org.hamcrest.Matchers.containsString;
     * Tests that the ClusterStateObserver constructed with (String, long) correctly waits
            .nodes(DiscoveryNodes.builder().add(newMaster).clusterManagerNodeId(newMaster.getId()))
        when(clusterApplierService.state()).thenReturn(stateWithMaster);
            return null;
 *     http://www.apache.org/licenses/LICENSE-2.0
        when(threadPool.relativeTimeInMillis()).thenReturn(0L);
        final AtomicBoolean listenerAdded = new AtomicBoolean();
            listenerAdded.set(true);
            @Override
 * Licensed to Elasticsearch under one or more contributor
            listenerAdded.set(true);
            .build();
        when(threadPool.relativeTimeInMillis()).thenReturn(0L);
            return null;
        final ClusterApplierService clusterApplierService = mock(ClusterApplierService.class);
            public void onClusterServiceClose() {}
        when(clusterApplierService.state()).thenReturn(clusterState);
            @Override
    }
            .version(5)
        clusterStateObserver.waitForNextChange(new ClusterStateObserver.Listener() {
     */
        final ClusterState newerState = ClusterState.builder(new ClusterName("test"))
 * specific language governing permissions and limitations
        when(threadPool.relativeTimeInMillis()).thenReturn(0L);
        doAnswer(invocation -> {
            clusterApplierService,
        final ThreadPool threadPool = mock(ThreadPool.class);
import org.opensearch.common.util.concurrent.ThreadContext;
            public void onTimeout(TimeValue timeout) {}
/*
        when(clusterApplierService.threadPool()).thenReturn(threadPool);
                receivedState.set(state);
            clusterState,
            @Override
    public void testPrimitiveConstructorWaitsWhenStateUnchanged() {
 */
        final ClusterApplierService clusterApplierService = mock(ClusterApplierService.class);
 *
        doAnswer(invocation -> {
        when(clusterApplierService.state()).thenReturn(newMasterState);
            assertThat(Arrays.toString(invocation.getArguments()), containsString("test-listener"));
        when(clusterApplierService.threadPool()).thenReturn(threadPool);
/*
            logger,
import static org.mockito.Mockito.doAnswer;
            }
        final DiscoveryNode masterNode = new DiscoveryNode("master", buildNewFakeTransportAddress(), Version.CURRENT);
import java.util.concurrent.atomic.AtomicBoolean;
        });
        // Construct with old master's persistent ID — new state has different master
        final ClusterApplierService clusterApplierService = mock(ClusterApplierService.class);
            5L,
    /**
    /**
        final ClusterService clusterService = mock(ClusterService.class);
import org.opensearch.cluster.node.DiscoveryNodes;
            @Override
            public void onTimeout(TimeValue timeout) {}
        assertNull(receivedState.get());
 * KIND, either express or implied.  See the License for the
            null,
        assertNotNull(receivedState.get());
        final AtomicReference<ClusterState> receivedState = new AtomicReference<>();
            new ThreadContext(Settings.EMPTY)
        final DiscoveryNode newMaster = new DiscoveryNode("new_master", buildNewFakeTransportAddress(), Version.CURRENT);
        );
            @Override
 * Modifications Copyright OpenSearch Contributors. See
        final AtomicBoolean listenerAdded = new AtomicBoolean();
/*
     */
            public void onTimeout(TimeValue timeout) {}
     * Tests that the primitive constructor with null clusterManagerNodeId (no master)
        when(threadPool.relativeTimeInMillis()).thenReturn(0L);
            @Override
            public void onClusterServiceClose() {}
            1L,
        // State hasn't changed, so observer should add a listener and wait
    public void testPrimitiveConstructorDetectsDifferentClusterManager() {
public class ClusterStateObserverTests extends OpenSearchTestCase {
        }).when(clusterApplierService).addTimeoutListener(any(), any());
            @Override
            masterNode.getId(),
        // Use the ClusterApplierService-based constructor
     * Tests that the ClusterStateObserver constructed with pre-extracted (String, long) values
        );
            @Override
        final AtomicBoolean listenerAdded = new AtomicBoolean();
            @Override
    /**
        when(clusterApplierService.threadPool()).thenReturn(threadPool);
 * ownership. Elasticsearch licenses this file to you under
            clusterApplierService,
        final DiscoveryNode newMaster = new DiscoveryNode("new_master", buildNewFakeTransportAddress(), Version.CURRENT);
            .nodes(DiscoveryNodes.builder().add(masterNode).clusterManagerNodeId(masterNode.getId()))
        final AtomicBoolean listenerAdded = new AtomicBoolean();
            .version(5)
 */
     */
        final ClusterState clusterState = ClusterState.builder(new ClusterName("test")).nodes(DiscoveryNodes.builder()).build();
            public void onTimeout(TimeValue timeout) {}
        final ClusterApplierService clusterApplierService = mock(ClusterApplierService.class);
            TimeValue.timeValueSeconds(30),
            }
            .nodes(DiscoveryNodes.builder().add(masterNode).clusterManagerNodeId(masterNode.getId()))
            TimeValue.timeValueSeconds(30),
            @Override
 *
