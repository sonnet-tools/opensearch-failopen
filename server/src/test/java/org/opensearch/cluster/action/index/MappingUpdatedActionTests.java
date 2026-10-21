            @Override
import org.opensearch.cluster.ClusterState;
        ClusterService clusterService = mock(ClusterService.class);
        assertEquals(1, sem.availablePermits());
        // take both permits and reduce max permits
        sem.release();
        when(clusterService.state()).thenReturn(clusterState);
            Settings.EMPTY,
        assertTrue(sem.tryAcquire());
import org.opensearch.cluster.node.DiscoveryNodes;
}
import org.opensearch.core.action.ActionListener;
            Settings.builder().put(MappingUpdatedAction.INDICES_MAX_IN_FLIGHT_UPDATES_SETTING.getKey(), 1).build(),
        assertEquals(0, sem.availablePermits());
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
        List<ActionListener<Void>> inFlightListeners = new CopyOnWriteArrayList<>();
import org.opensearch.cluster.node.DiscoveryNode;
        sem.setMaxPermits(1);
 * license agreements. See the NOTICE file distributed with
    public void testMappingUpdatedActionBlocks() throws Exception {
import static org.mockito.Mockito.when;
 */
        );
        assertEquals(0, sem.availablePermits());
import org.opensearch.Version;
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).nodes(nodes).build();
        sem.setMaxPermits(1);
import org.opensearch.transport.client.AdminClient;
            clusterService
 * GitHub history for details.
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
import org.opensearch.cluster.service.ClusterService;
        PlainActionFuture<Void> fut2 = new PlainActionFuture<>();
        assertEquals(1, inFlightListeners.size());
    public void testAdjustableSemaphore() {
        assertEquals(0, sem.availablePermits());
 * specific language governing permissions and limitations
        Client client = mock(Client.class);
        assertEquals(0, mua.blockedThreads());
        assertFalse(sem.tryAcquire());
package org.opensearch.cluster.action.index;
 */
        // increase the number of max permits to 2
 * The OpenSearch Contributors require contributions made to
        sem.release();
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(fut2.isDone());
        };
import org.opensearch.common.settings.ClusterSettings;
 * this work for additional information regarding copyright
import java.util.List;
 *
        assertEquals(0, mua.blockedThreads());
        assertEquals(0, sem.availablePermits());
    }
        AdminClient adminClient = mock(AdminClient.class);
            }
import org.opensearch.test.OpenSearchTestCase;
        assertFalse(sem.tryAcquire());
        when(client.admin()).thenReturn(adminClient);
            protected void sendUpdateMapping(Index index, Mapping mappingUpdate, ActionListener<Void> listener) {
            .build();
        MappingUpdatedAction mua = new MappingUpdatedAction(
import static org.mockito.Mockito.verify;
            mua.updateMappingOnClusterManager(null, null, fut2); // blocked
import org.opensearch.index.mapper.Mapper;
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.index.mapper.MetadataFieldMapper;
        assertTrue(fut1.isDone());
    }
 * ownership. Elasticsearch licenses this file to you under
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        assertEquals(2, sem.availablePermits());
        assertTrue(sem.tryAcquire());
import org.opensearch.cluster.action.index.MappingUpdatedAction.AdjustableSemaphore;
        DiscoveryNodes nodes = DiscoveryNodes.builder()
        mua.updateMappingOnClusterManager(null, null, fut1);
 * KIND, either express or implied.  See the License for the
import static org.mockito.Mockito.eq;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_VERSION_CREATED;
import static org.mockito.Mockito.mock;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertFalse(fut1.isDone());
/*
        inFlightListeners.remove(0).onResponse(null);
        sem.release();
                inFlightListeners.add(listener);
        Mapping update = new Mapping(Version.V_3_0_0, rootObjectMapper, new MetadataFieldMapper[0], Map.of());
        assertTrue(sem.tryAcquire());
        inFlightListeners.remove(0).onResponse(null);
        // release all current permits
        thread.join();
        assertEquals(1, sem.availablePermits());
        assertEquals(1, sem.availablePermits());
        assertEquals(1, inFlightListeners.size());
 * the Apache License, Version 2.0 (the "License"); you may
        sem.setMaxPermits(2);
        final Mapper.BuilderContext context = new Mapper.BuilderContext(indexSettings, new ContentPath());
        mua.sendUpdateMapping(new Index("name", "uuid"), update, ActionListener.wrap(() -> {}));
        // set back to 2
            null
import java.util.concurrent.CopyOnWriteArrayList;
        Settings indexSettings = Settings.builder().put(SETTING_VERSION_CREATED, Version.CURRENT).build();
import org.opensearch.transport.client.Client;
 * software distributed under the License is distributed on an
/*
/*
        assertFalse(fut2.isDone());
import org.opensearch.cluster.ClusterName;
import org.opensearch.index.mapper.ContentPath;
        RootObjectMapper rootObjectMapper = new RootObjectMapper.Builder("name").build(context);
 * Unless required by applicable law or agreed to in writing,
        assertEquals(-1, sem.availablePermits());
        ) {
        mua.setClient(client);
        assertBusy(() -> assertEquals(1, mua.blockedThreads()));
 * You may obtain a copy of the License at
        // reduce number of max permits to 1
        // release one permit
        sem.release();
        // release second permit
            .add(new DiscoveryNode("first", buildNewFakeTransportAddress(), Version.V_3_0_0))
 */
        assertTrue(sem.tryAcquire());
import java.util.Map;
        assertEquals(1, sem.availablePermits());
        Thread thread = new Thread(() -> {
        assertEquals(1, sem.availablePermits());
        assertEquals(2, sem.availablePermits());
        });
        assertEquals(1, inFlightListeners.size());
        verify(indicesAdminClient).execute(eq(AutoPutMappingAction.INSTANCE), any(), any());
        assertFalse(sem.tryAcquire());
        PlainActionFuture<Void> fut1 = new PlainActionFuture<>();
 * under the License.
 * Modifications Copyright OpenSearch Contributors. See
 * not use this file except in compliance with the License.
        assertEquals(0, sem.availablePermits());
        when(adminClient.indices()).thenReturn(indicesAdminClient);
        sem.setMaxPermits(2);
 *
        assertFalse(sem.tryAcquire());
    }
import org.opensearch.core.index.Index;
import org.opensearch.index.mapper.Mapping;
public class MappingUpdatedActionTests extends OpenSearchTestCase {
import org.opensearch.action.support.PlainActionFuture;
 *
import org.opensearch.common.settings.Settings;
        AdjustableSemaphore sem = new AdjustableSemaphore(1, randomBoolean());
import org.opensearch.index.mapper.RootObjectMapper;
        thread.start();
 *     http://www.apache.org/licenses/LICENSE-2.0
    public void testSendUpdateMappingUsingAutoPutMappingAction() {
        assertTrue(sem.tryAcquire());
import static org.mockito.Mockito.any;
        IndicesAdminClient indicesAdminClient = mock(IndicesAdminClient.class);
import org.opensearch.transport.client.IndicesAdminClient;
import org.opensearch.action.admin.indices.mapping.put.AutoPutMappingAction;
        final MappingUpdatedAction mua = new MappingUpdatedAction(
