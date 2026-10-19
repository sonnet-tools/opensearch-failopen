        thread.start();
import org.opensearch.action.support.PlainActionFuture;
        sem.release();  
import org.opensearch.index.mapper.ContentPath;
        assertFalse(fut2.isDone());  
                inFlightListeners.add(listener);  
        assertTrue(sem.tryAcquire());  
import static org.mockito.Mockito.eq;
 * not use this file except in compliance with the License.
        PlainActionFuture<Void> fut2 = new PlainActionFuture<>();  
        assertEquals(2, sem.availablePermits());  
import static org.mockito.Mockito.any;
/*
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
        Thread thread = new Thread(() -> {
    }  
        final Mapper.BuilderContext context = new Mapper.BuilderContext(indexSettings, new ContentPath());  
    }  
import org.opensearch.core.index.Index;  
import static org.mockito.Mockito.when;
        AdminClient adminClient = mock(AdminClient.class);
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(1, inFlightListeners.size());
        // reduce number of max permits to 1
 */  
            }
            .build();
        sem.setMaxPermits(1);
        assertTrue(fut1.isDone());
        assertFalse(sem.tryAcquire());
        inFlightListeners.remove(0).onResponse(null);
        final MappingUpdatedAction mua = new MappingUpdatedAction(
/*
        // release all current permits
 *  
import org.opensearch.transport.client.IndicesAdminClient;  
        thread.join();  
import org.opensearch.cluster.node.DiscoveryNode;  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.index.mapper.RootObjectMapper;
        MappingUpdatedAction mua = new MappingUpdatedAction(
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_VERSION_CREATED;  
import java.util.Map;  
import org.opensearch.index.mapper.MetadataFieldMapper;
import org.opensearch.action.admin.indices.mapping.put.AutoPutMappingAction;
        assertFalse(sem.tryAcquire());
        assertFalse(fut1.isDone());
        assertTrue(sem.tryAcquire());
            mua.updateMappingOnClusterManager(null, null, fut2); // blocked
        ClusterService clusterService = mock(ClusterService.class);
    }  
import org.opensearch.cluster.ClusterName;  
        Client client = mock(Client.class);
        // increase the number of max permits to 2
        sem.release();
        assertEquals(0, sem.availablePermits());
        });  
 * The OpenSearch Contributors require contributions made to  
        sem.release();
            .add(new DiscoveryNode("first", buildNewFakeTransportAddress(), Version.V_3_0_0))
import static org.mockito.Mockito.verify;
        inFlightListeners.remove(0).onResponse(null);  
            Settings.builder().put(MappingUpdatedAction.INDICES_MAX_IN_FLIGHT_UPDATES_SETTING.getKey(), 1).build(),
        assertEquals(1, inFlightListeners.size());  
        when(client.admin()).thenReturn(adminClient);
        assertEquals(0, sem.availablePermits());  
import org.opensearch.common.settings.ClusterSettings;  
        assertEquals(0, sem.availablePermits());  
    public void testAdjustableSemaphore() {  
        assertEquals(1, sem.availablePermits());
        assertEquals(1, sem.availablePermits());
            null
        DiscoveryNodes nodes = DiscoveryNodes.builder()  
import static org.mockito.Mockito.mock;  
import org.opensearch.test.OpenSearchTestCase;  
 * GitHub history for details.
import org.opensearch.Version;  
import java.util.List;
        // release second permit
        IndicesAdminClient indicesAdminClient = mock(IndicesAdminClient.class);
import org.opensearch.index.mapper.Mapper;
import org.opensearch.index.mapper.Mapping;  
 * this work for additional information regarding copyright
    public void testSendUpdateMappingUsingAutoPutMappingAction() {
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),  
        Mapping update = new Mapping(Version.V_3_0_0, rootObjectMapper, new MetadataFieldMapper[0], Map.of());
        assertEquals(0, sem.availablePermits());  
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).nodes(nodes).build();  
        PlainActionFuture<Void> fut1 = new PlainActionFuture<>();
        assertBusy(() -> assertEquals(1, mua.blockedThreads()));
 * specific language governing permissions and limitations
        mua.updateMappingOnClusterManager(null, null, fut1);
 * under the License.  
        when(clusterService.state()).thenReturn(clusterState);
package org.opensearch.cluster.action.index;
        assertEquals(0, mua.blockedThreads());
 * SPDX-License-Identifier: Apache-2.0
            @Override
 * license agreements. See the NOTICE file distributed with
        assertTrue(sem.tryAcquire());
        assertEquals(0, sem.availablePermits());
        assertTrue(sem.tryAcquire());
        mua.setClient(client);  
        assertEquals(-1, sem.availablePermits());  
            Settings.EMPTY,
public class MappingUpdatedActionTests extends OpenSearchTestCase {
import org.opensearch.core.action.ActionListener;
 */
        assertTrue(sem.tryAcquire());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.transport.client.Client;
 * You may obtain a copy of the License at  
        assertEquals(1, inFlightListeners.size());
        assertEquals(1, sem.availablePermits());
        // release one permit  
        mua.sendUpdateMapping(new Index("name", "uuid"), update, ActionListener.wrap(() -> {}));
        List<ActionListener<Void>> inFlightListeners = new CopyOnWriteArrayList<>();  
            clusterService
import org.opensearch.cluster.ClusterState;
        AdjustableSemaphore sem = new AdjustableSemaphore(1, randomBoolean());
        Settings indexSettings = Settings.builder().put(SETTING_VERSION_CREATED, Version.CURRENT).build();
        assertTrue(fut2.isDone());
        sem.release();  
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.cluster.node.DiscoveryNodes;
import org.opensearch.cluster.action.index.MappingUpdatedAction.AdjustableSemaphore;
import java.util.concurrent.CopyOnWriteArrayList;
 * Modifications Copyright OpenSearch Contributors. See  
            protected void sendUpdateMapping(Index index, Mapping mappingUpdate, ActionListener<Void> listener) {
        assertEquals(2, sem.availablePermits());
        sem.setMaxPermits(2);  
 * software distributed under the License is distributed on an
}
        assertFalse(sem.tryAcquire());
 * compatible open source license.
 *     http://www.apache.org/licenses/LICENSE-2.0
        sem.setMaxPermits(2);  
/*  
 * ownership. Elasticsearch licenses this file to you under  
    public void testMappingUpdatedActionBlocks() throws Exception {
        RootObjectMapper rootObjectMapper = new RootObjectMapper.Builder("name").build(context);
        // set back to 2
        when(adminClient.indices()).thenReturn(indicesAdminClient);  
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),  
        assertEquals(0, mua.blockedThreads());
 */
        verify(indicesAdminClient).execute(eq(AutoPutMappingAction.INSTANCE), any(), any());
        assertFalse(sem.tryAcquire());  
import org.opensearch.common.settings.Settings;
        // take both permits and reduce max permits  
 *
 *
import org.opensearch.transport.client.AdminClient;
        sem.setMaxPermits(1);  
        );
        };
        assertEquals(1, sem.availablePermits());
        assertEquals(1, sem.availablePermits());
        ) {
 * Unless required by applicable law or agreed to in writing,
