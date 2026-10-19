        assertNotNull(receivedState.get());  
            public void onNewClusterState(ClusterState state) {
        when(clusterApplierService.state()).thenReturn(newMasterState);  
            .build();
import java.util.concurrent.atomic.AtomicBoolean;
            .nodes(DiscoveryNodes.builder().add(masterNode).clusterManagerNodeId(masterNode.getId()))
            public void onClusterServiceClose() {}  
import org.opensearch.common.settings.Settings;  
            public void onClusterServiceClose() {}
import org.opensearch.threadpool.ThreadPool;
        final DiscoveryNode newMaster = new DiscoveryNode("new_master", buildNewFakeTransportAddress(), Version.CURRENT);
        });  
        // Different master (null -> newMaster) — should accept immediately  
            clusterApplierService,  
        final ClusterStateObserver observer = new ClusterStateObserver(
        final ThreadPool threadPool = mock(ThreadPool.class);
            .build();  
            @Override
     */
 * ownership. Elasticsearch licenses this file to you under  
            clusterApplierService,
            clusterState,
 * The OpenSearch Contributors require contributions made to  
            }
        }).when(clusterApplierService).addTimeoutListener(any(), any());  
        // Construct with same persistent node ID and same version — should NOT detect a change  
            .build();  
            @Override
    public void testPrimitiveConstructorDetectsNewerState() {
        );
            null,
package org.opensearch.cluster;
        doAnswer(invocation -> {
     * Tests that the ClusterStateObserver constructed with (String, long) detects a different  
            return null;  
        // Newer version detected — should accept immediately
            @Override
import static org.hamcrest.Matchers.containsString;
 */  
        assertTrue(listenerAdded.get());  
        final ClusterState newMasterState = ClusterState.builder(new ClusterName("test"))
 *  
        final DiscoveryNode masterNode = new DiscoveryNode("master", buildNewFakeTransportAddress(), Version.CURRENT);
 * KIND, either express or implied.  See the License for the
            5L,
        assertNotNull(receivedState.get());
import org.opensearch.cluster.node.DiscoveryNodes;  
        doAnswer(invocation -> {  
    public void testPrimitiveConstructorWaitsWhenStateUnchanged() {
            1L,  
            .version(5)
            @Override  
            return null;
        final ClusterApplierService clusterApplierService = mock(ClusterApplierService.class);
            .nodes(DiscoveryNodes.builder().add(oldMaster).add(newMaster).clusterManagerNodeId(newMaster.getId()))  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return null;  
        // Construct with persistent node ID and version 1 — newerState has version 5, same master  
        // Construct with old master's persistent ID — new state has different master
import org.opensearch.test.OpenSearchTestCase;  
            @Override
        doAnswer(invocation -> {
            public void onTimeout(TimeValue timeout) {}
            listenerAdded.set(true);
            new ThreadContext(Settings.EMPTY)
            }  
        when(threadPool.relativeTimeInMillis()).thenReturn(0L);  
        );
import java.util.Arrays;  
 * SPDX-License-Identifier: Apache-2.0
    }
            1L,
            @Override
        final ClusterState clusterState = ClusterState.builder(new ClusterName("test")).nodes(DiscoveryNodes.builder()).build();
 * not use this file except in compliance with the License.
            masterNode.getId(),
        when(clusterApplierService.state()).thenReturn(newerState);
        when(threadPool.relativeTimeInMillis()).thenReturn(0L);
import static org.mockito.Mockito.doAnswer;  
            5L,  
            @Override
    public void testPrimitiveConstructorViaClusterService() {
        });
     */
import java.util.concurrent.atomic.AtomicReference;
        final ClusterApplierService clusterApplierService = mock(ClusterApplierService.class);  
        final ClusterState sameState = ClusterState.builder(new ClusterName("test"))  
            clusterApplierService,  
            .nodes(DiscoveryNodes.builder().add(masterNode).clusterManagerNodeId(masterNode.getId()))  
            .version(5)
                receivedState.set(state);
        );
    /**
 */  
        when(threadPool.relativeTimeInMillis()).thenReturn(0L);  
            logger,
    public void testPrimitiveConstructorDetectsDifferentClusterManager() {  
public class ClusterStateObserverTests extends OpenSearchTestCase {
        // Different master detected — should accept immediately
 * specific language governing permissions and limitations
        when(clusterService.getClusterApplierService()).thenReturn(clusterApplierService);
            @Override  
            return null;  
    }
    /**  
        final DiscoveryNode oldMaster = new DiscoveryNode("old_master", buildNewFakeTransportAddress(), Version.CURRENT);  
        final ClusterState newerState = ClusterState.builder(new ClusterName("test"))  
        when(clusterApplierService.threadPool()).thenReturn(threadPool);
import org.opensearch.common.util.concurrent.ThreadContext;
            clusterApplierService,
            masterNode.getId(),
        final ThreadPool threadPool = mock(ThreadPool.class);
            TimeValue.timeValueSeconds(30),
        final ClusterStateObserver observer = new ClusterStateObserver(
            new ThreadContext(Settings.EMPTY)  
     * to the ClusterApplierService-based constructor.  
        assertEquals(10L, receivedState.get().version());
import static org.mockito.Mockito.when;
        assertNull(receivedState.get());
        }).when(clusterApplierService).addTimeoutListener(any(), any());
        }).when(clusterApplierService).addTimeoutListener(any(), any());
                receivedState.set(state);
        doAnswer(invocation -> {
            logger,  
        doAnswer(invocation -> {
        // so the predicate should accept it immediately without adding a listener
            .version(5)
            logger,
import static org.mockito.Mockito.any;
        when(clusterApplierService.threadPool()).thenReturn(threadPool);
                return "test-listener";
        final AtomicBoolean listenerAdded = new AtomicBoolean();
            public void onClusterServiceClose() {}
        assertEquals(5L, receivedState.get().version());
            new ThreadContext(Settings.EMPTY)  
            public void onNewClusterState(ClusterState state) {
        when(clusterApplierService.threadPool()).thenReturn(threadPool);
import org.opensearch.common.unit.TimeValue;
            @Override
            @Override
     * Tests that the ClusterService-based primitive constructor delegates correctly
        when(clusterApplierService.state()).thenReturn(newerState);  
            public void onClusterServiceClose() {}
        assertNotNull(receivedState.get());
        );
            listenerAdded.set(true);
            public void onTimeout(TimeValue timeout) {}  
        );
        final DiscoveryNode masterNode = new DiscoveryNode("master", buildNewFakeTransportAddress(), Version.CURRENT);
    public void testClusterStateListenerToStringIncludesListenerToString() {  
        final AtomicReference<ClusterState> receivedState = new AtomicReference<>();  
        observer.waitForNextChange(new ClusterStateObserver.Listener() {
    }  
/*  
            5L,  
                receivedState.set(state);
        final DiscoveryNode newMaster = new DiscoveryNode("new_master", buildNewFakeTransportAddress(), Version.CURRENT);
            .nodes(DiscoveryNodes.builder().add(newMaster).clusterManagerNodeId(newMaster.getId()))
/*  
import static org.mockito.Mockito.mock;
            @Override
            @Override
        });
        clusterStateObserver.waitForNextChange(new ClusterStateObserver.Listener() {
        final AtomicReference<ClusterState> receivedState = new AtomicReference<>();  
        observer.waitForNextChange(new ClusterStateObserver.Listener() {
            @Override  
        // Use the ClusterApplierService-based constructor
 * Modifications Copyright OpenSearch Contributors. See
        final ClusterState newerState = ClusterState.builder(new ClusterName("test"))
        final ClusterStateObserver observer = new ClusterStateObserver(  
            TimeValue.timeValueSeconds(30),
     */
import org.opensearch.cluster.service.ClusterApplierService;
    }  
 *
            @Override  
            new ThreadContext(Settings.EMPTY)
     * the ClusterState-based constructor.  
        when(clusterApplierService.state()).thenReturn(sameState);
        when(clusterApplierService.threadPool()).thenReturn(threadPool);
            .build();
            }  
    /**
            @Override
                receivedState.set(state);
            TimeValue.timeValueSeconds(30),
            listenerAdded.set(true);  
            new ThreadContext(Settings.EMPTY)
        }).when(clusterApplierService).addTimeoutListener(any(), any());
     * cluster manager even when the version is the same.
        observer.waitForNextChange(new ClusterStateObserver.Listener() {
            .build();  
        final AtomicReference<ClusterState> receivedState = new AtomicReference<>();
 * You may obtain a copy of the License at  
     */
     * correctly detects a newer cluster state via waitForNextChange, matching the behavior of
        }).when(clusterApplierService).addTimeoutListener(any(), any());
            public void onClusterServiceClose() {}  
        assertFalse(listenerAdded.get());
            @Override  
}
    }
            .nodes(DiscoveryNodes.builder().add(masterNode).clusterManagerNodeId(masterNode.getId()))
            new ThreadContext(Settings.EMPTY)  
     * Tests that the ClusterStateObserver constructed with (String, long) correctly waits
 * this work for additional information regarding copyright
        final AtomicReference<ClusterState> receivedState = new AtomicReference<>();
import org.opensearch.cluster.service.ClusterService;
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
        final ClusterState stateWithMaster = ClusterState.builder(new ClusterName("test"))  
        final ThreadPool threadPool = mock(ThreadPool.class);
        // State hasn't changed, so observer should add a listener and wait  
import org.opensearch.Version;
     * when the current state has the same version and master as the stored state.  
 * GitHub history for details.
        assertNotNull(receivedState.get());  
    }
    /**
        final ClusterApplierService clusterApplierService = mock(ClusterApplierService.class);  
            public void onClusterServiceClose() {}  
            }  
        });  
            listenerAdded.set(true);
import org.opensearch.cluster.node.DiscoveryNode;
        when(clusterApplierService.threadPool()).thenReturn(threadPool);  
            masterNode.getId(),
 */
        final ClusterStateObserver observer = new ClusterStateObserver(
        assertFalse(listenerAdded.get());  
            oldMaster.getId(),
            TimeValue.timeValueSeconds(30),
            public void onNewClusterState(ClusterState state) {
            }  
     */
            public void onNewClusterState(ClusterState state) {  
            @Override  
        when(clusterApplierService.state()).thenReturn(clusterState);
            logger,  
 * this file be licensed under the Apache-2.0 license or a
        final ThreadPool threadPool = mock(ThreadPool.class);  
        final ThreadPool threadPool = mock(ThreadPool.class);
            public void onTimeout(TimeValue timeout) {}
     * Tests that the ClusterStateObserver constructed with pre-extracted (String, long) values
            public String toString() {
            @Override
 * compatible open source license.
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
        final AtomicBoolean listenerAdded = new AtomicBoolean();
        final AtomicBoolean listenerAdded = new AtomicBoolean();  
            public void onNewClusterState(ClusterState state) {  
/*
        when(clusterApplierService.state()).thenReturn(stateWithMaster);
            .version(5)
        assertFalse("should not need to add listener", listenerAdded.get());
            clusterApplierService,
        when(threadPool.relativeTimeInMillis()).thenReturn(0L);
        observer.waitForNextChange(new ClusterStateObserver.Listener() {
 *
        final ClusterStateObserver clusterStateObserver = new ClusterStateObserver(
        observer.waitForNextChange(new ClusterStateObserver.Listener() {
 * the Apache License, Version 2.0 (the "License"); you may
        final ClusterStateObserver observer = new ClusterStateObserver(  
                receivedState.set(state);
        assertTrue(listenerAdded.get());
            listenerAdded.set(true);
            assertThat(Arrays.toString(invocation.getArguments()), containsString("test-listener"));
            public void onTimeout(TimeValue timeout) {}  
        final ClusterApplierService clusterApplierService = mock(ClusterApplierService.class);
            public void onTimeout(TimeValue timeout) {}  
        // Construct with null master ID — simulates "no master" initial state  
            logger,  
        final ClusterService clusterService = mock(ClusterService.class);
        final AtomicReference<ClusterState> receivedState = new AtomicReference<>();
     * Tests that the primitive constructor with null clusterManagerNodeId (no master)
        // The sampled state (version 5) is newer than stored (version 1) with same master,  
            public void onTimeout(TimeValue timeout) {}
        );
        });
            .version(10)
    public void testPrimitiveConstructorNullMasterDetectsNewMaster() {
            public void onNewClusterState(ClusterState state) {}
     * detects when a master appears.  
            null,
 * software distributed under the License is distributed on an
            clusterApplierService,  
        });
            @Override  
            TimeValue.timeValueSeconds(30),
            }
        final DiscoveryNode masterNode = new DiscoveryNode("master", buildNewFakeTransportAddress(), Version.CURRENT);
 * license agreements. See the NOTICE file distributed with
    /**
            return null;
        when(threadPool.relativeTimeInMillis()).thenReturn(0L);  
            logger,
        final ClusterApplierService clusterApplierService = mock(ClusterApplierService.class);  
        final AtomicBoolean listenerAdded = new AtomicBoolean();  
        final AtomicBoolean listenerAdded = new AtomicBoolean();  
        final ClusterApplierService clusterApplierService = mock(ClusterApplierService.class);  
