        private final ConnectionStrategy strategy;
            );
public class RemoteConnectionStrategyTests extends OpenSearchTestCase {
            "cluster-alias",  
        assertTrue(first.shouldRebuildConnection(newSettings));
            return false;
            TransportService transportService,
            super(clusterAlias, transportService, connectionManager, Settings.EMPTY);  
        RemoteConnectionManager remoteConnectionManager = new RemoteConnectionManager("cluster-alias", connectionManager);
            newBuilder.put(
    }  
            return this.strategy;
                RemoteClusterService.REMOTE_CLUSTER_PING_SCHEDULE.getConcreteSettingForNamespace("cluster-alias").getKey(),
        protected boolean strategyMustBeRebuilt(Settings newSettings) {
            newBuilder.put(RemoteClusterService.REMOTE_CLUSTER_COMPRESS.getConcreteSettingForNamespace("cluster-alias").getKey(), true);  
 */  
            remoteConnectionManager,
 *
            mock(TransportService.class),
 * the Apache License, Version 2.0 (the "License"); you may
        FakeConnectionStrategy first = new FakeConnectionStrategy(
    }
        ) {
        }
        @Override
            .put(ProxyConnectionStrategy.PROXY_ADDRESS.getConcreteSettingForNamespace("cluster-alias").getKey(), "127.0.0.1:9300")
 * KIND, either express or implied.  See the License for the
            RemoteConnectionStrategy.ConnectionStrategy strategy
        assertTrue(first.shouldRebuildConnection(newBuilder.build()));
import static org.mockito.Mockito.mock;  
    public void testCorrectChannelNumber() {
 * ownership. Elasticsearch licenses this file to you under  
    }  
        }
            remoteConnectionManager,
        @Override
}
        newBuilder.put(ProxyConnectionStrategy.PROXY_ADDRESS.getConcreteSettingForNamespace("cluster-alias").getKey(), "127.0.0.1:9300");
        }
 * Unless required by applicable law or agreed to in writing,
            this.strategy = strategy;
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
    public void testStrategyChangeMeansThatStrategyMustBeRebuilt() {
            String settingKey = RemoteConnectionStrategy.REMOTE_CONNECTION_MODE.getConcreteSettingForNamespace(clusterAlias).getKey();  
        }
            return null;
            assertEquals(  
        );
 * specific language governing permissions and limitations
import org.opensearch.test.OpenSearchTestCase;
 * GitHub history for details.
        Settings newSettings = Settings.builder()
 * The OpenSearch Contributors require contributions made to  
                strategy.getNumberOfChannels(),
 * compatible open source license.
        protected ConnectionStrategy strategyType() {
        newBuilder.put(RemoteConnectionStrategy.REMOTE_CONNECTION_MODE.getConcreteSettingForNamespace("cluster-alias").getKey(), "proxy");
        }
        assertEquals(false, connectionManager.getConnectionProfile().getCompressionEnabled());  
    }  
            "cluster-alias",  
        FakeConnectionStrategy first = new FakeConnectionStrategy(
            remoteConnectionManager,
 * under the License.  
            .put(SniffConnectionStrategy.REMOTE_CLUSTER_SEEDS.getConcreteSettingForNamespace("cluster-alias").getKey(), "127.0.0.1:9300")  
        ClusterConnectionManager connectionManager = new ClusterConnectionManager(Settings.EMPTY, mock(Transport.class));
        RemoteConnectionManager remoteConnectionManager = new RemoteConnectionManager("cluster-alias", connectionManager);  
        protected void connectImpl(ActionListener<Void> listener) {
        protected boolean shouldOpenMoreConnections() {  
                TimeValue.timeValueSeconds(5)  
 * You may obtain a copy of the License at  
        assertEquals(TimeValue.MINUS_ONE, connectionManager.getConnectionProfile().getPingInterval());
import org.opensearch.common.unit.TimeValue;
    private static class FakeConnectionStrategy extends RemoteConnectionStrategy {
        Settings newSettings = Settings.builder()
        Settings.Builder newBuilder = Settings.builder();  
 * this work for additional information regarding copyright
    }
        } else {
        if (randomBoolean()) {  
package org.opensearch.transport;
        @Override  
 * software distributed under the License is distributed on an
            );
        @Override  
        );  
        FakeConnectionStrategy(  
/*  
import org.opensearch.core.action.ActionListener;  
            RemoteConnectionStrategy.ConnectionStrategy.PROXY  
        ClusterConnectionManager connectionManager = new ClusterConnectionManager(TestProfiles.LIGHT_PROFILE, mock(Transport.class));
        }  
                "Incorrect number of channels for " + strategy.name(),
 * SPDX-License-Identifier: Apache-2.0
        @Override
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
        }  
/*
        RemoteConnectionManager remoteConnectionManager = new RemoteConnectionManager("cluster-alias", connectionManager);
            mock(TransportService.class),
            String clusterAlias,
/*  
 *
 */
            mock(TransportService.class),  
            RemoteConnectionManager connectionManager,  
        protected RemoteConnectionInfo.ModeInfo getModeInfo() {
 */  
            .put(RemoteConnectionStrategy.REMOTE_CONNECTION_MODE.getConcreteSettingForNamespace("cluster-alias").getKey(), "sniff")
        );
            ConnectionProfile proxyProfile = RemoteConnectionStrategy.buildConnectionProfile(clusterAlias, proxySettings);
        for (RemoteConnectionStrategy.ConnectionStrategy strategy : RemoteConnectionStrategy.ConnectionStrategy.values()) {
 *    http://www.apache.org/licenses/LICENSE-2.0
            RemoteConnectionStrategy.ConnectionStrategy.PROXY  
            Settings proxySettings = Settings.builder().put(settingKey, strategy.name()).build();
            return false;  
        FakeConnectionStrategy first = new FakeConnectionStrategy(
            RemoteConnectionStrategy.ConnectionStrategy.PROXY
 * Modifications Copyright OpenSearch Contributors. See
        ClusterConnectionManager connectionManager = new ClusterConnectionManager(Settings.EMPTY, mock(Transport.class));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .put(RemoteConnectionStrategy.REMOTE_CONNECTION_MODE.getConcreteSettingForNamespace("cluster-alias").getKey(), "proxy")  
    public void testSameStrategyChangeMeansThatStrategyDoesNotNeedToBeRebuilt() {
            "cluster-alias",
    public void testChangeInConnectionProfileMeansTheStrategyMustBeRebuilt() {  
        }
        String clusterAlias = "cluster-alias";  
 *  
            .build();
        assertFalse(first.shouldRebuildConnection(newSettings));  
import org.opensearch.common.settings.Settings;
            .build();
                proxyProfile.getNumConnections()  
