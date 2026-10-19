public class MockGatewayMetaState extends GatewayMetaState {
        this.prepareFullState = prepareFullState;
 *  
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
            null,
import org.opensearch.gateway.remote.RemoteClusterStateService;
        final ClusterService clusterService = mock(ClusterService.class);  
        MetadataUpgrader metadataUpgrader  
    }
 * GitHub history for details.
        } catch (IOException e) {
    }
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.gateway;
 */  
        NodeEnvironment nodeEnvironment,
            remoteStoreRestoreService  
 * ownership. Elasticsearch licenses this file to you under  
 * It's not always easy / convenient to construct these dependencies.  
import java.io.IOException;
 * this work for additional information regarding copyright
    private final RemoteClusterStateService remoteClusterStateService;
 * software distributed under the License is distributed on an
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
import org.opensearch.transport.TransportService;  
            transportService,
import org.opensearch.cluster.metadata.MetadataIndexUpgradeService;
            metaStateService,  
 * no metadata upgrade will be performed and no cluster state updaters will be run. This is sufficient for most of the tests.
        }  
        this.bigArrays = bigArrays;  
        }
        start(settings, nodeEnvironment, xContentRegistry, persistedStateRegistry, false);  
        return metadata;  
            // Just set localNode here, not to mess with ClusterService and IndicesService mocking
        if (prepareFullState) {
    }
import org.opensearch.index.recovery.RemoteStoreRestoreService;  
    }
 *
        Settings settings,
    public MockGatewayMetaState(DiscoveryNode localNode, BigArrays bigArrays, boolean prepareFullState) {
        final MetaStateService metaStateService = mock(MetaStateService.class);
import org.opensearch.cluster.ClusterState;
        this.remoteStoreRestoreService = mock(RemoteStoreRestoreService.class);
        );
    Metadata upgradeMetadataForNode(  
            null,
    ) {  
        this.prepareFullState = prepareFullState;
        this.remoteStoreRestoreService = remoteStoreRestoreService;
            ),  
 * Licensed to Elasticsearch under one or more contributor  
    }  
    public void start(  
    public void start(  
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.common.util.BigArrays;
    ) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.remoteClusterStateService = mock(RemoteClusterStateService.class);
 */  
                nodeEnvironment,
import org.opensearch.cluster.metadata.Metadata;
        when(clusterService.getClusterSettings()).thenReturn(
    private final BigArrays bigArrays;  
    }
import org.opensearch.plugins.MetadataUpgrader;
import org.opensearch.threadpool.ThreadPool;
}  
        BigArrays bigArrays,
        } else {
/*
        NamedXContentRegistry xContentRegistry,  
 * {@link GatewayMetaState} constructor accepts a lot of arguments.
            new PersistedClusterStateService(  
            throw new AssertionError(e);
    public MockGatewayMetaState(
        NamedXContentRegistry xContentRegistry,  
import static org.mockito.Mockito.mock;
 * The OpenSearch Contributors require contributions made to  
/*  
                bigArrays,  
 */
            persistedStateRegistry,
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
    @Override
            remoteClusterStateService,
 * not use this file except in compliance with the License.
import org.opensearch.core.xcontent.NamedXContentRegistry;  
import org.opensearch.common.settings.Settings;
import static org.mockito.Mockito.when;
    public MockGatewayMetaState(DiscoveryNode localNode, BigArrays bigArrays) {
        try {
    ) {
import org.opensearch.env.NodeEnvironment;
        RemoteStoreRestoreService remoteStoreRestoreService  
 *
import org.opensearch.cluster.coordination.PersistedStateRegistry;
 * This class constructor takes far fewer dependencies and constructs usable {@link GatewayMetaState} with 2 restrictions:
 * this file be licensed under the Apache-2.0 license or a
            return super.prepareInitialClusterState(transportService, clusterService, clusterState);  
    }  
            return ClusterStateUpdaters.setLocalNode(clusterState, localNode);  
    ) {
        this.remoteClusterStateService = remoteClusterStateService;
        this.bigArrays = bigArrays;  
        start(
        when(transportService.getThreadPool()).thenReturn(mock(ThreadPool.class));
        super.close();  
    private final DiscoveryNode localNode;
        boolean prepareFullState
        );  
        DiscoveryNode localNode,  
 * license agreements. See the NOTICE file distributed with
        MetadataIndexUpgradeService metadataIndexUpgradeService,
    ClusterState prepareInitialClusterState(TransportService transportService, ClusterService clusterService, ClusterState clusterState) {
        final TransportService transportService = mock(TransportService.class);
import org.opensearch.cluster.node.DiscoveryNode;  
            settings,  
        PersistedStateRegistry persistedStateRegistry
        Metadata metadata,
                () -> 0L
        RemoteClusterStateService remoteClusterStateService,
        this(localNode, bigArrays);  
 * Modifications Copyright OpenSearch Contributors. See
 */  
    public void close() throws IOException {
import org.opensearch.common.settings.ClusterSettings;  
import org.opensearch.common.collect.Tuple;
                new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        this.localNode = localNode;
    @Override  
 * compatible open source license.
            clusterService,
 * You may obtain a copy of the License at  
    private final RemoteStoreRestoreService remoteStoreRestoreService;
        NodeEnvironment nodeEnvironment,
                xContentRegistry,
import org.opensearch.cluster.metadata.Manifest;  
        Settings settings,
            when(metaStateService.loadFullState()).thenReturn(new Tuple<>(Manifest.empty(), Metadata.builder().build()));  
/**
    private boolean prepareFullState = false;  
    @Override
        this.localNode = localNode;
        // Metadata upgrade is tested in GatewayMetaStateTests, we override this method to NOP to make mocking easier
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
        PersistedStateRegistry persistedStateRegistry,
