public class RemoteClusterSettingsTests extends OpenSearchTestCase {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
        final Settings settings = nonRemoteClusterClientNode();  
import static org.opensearch.transport.RemoteClusterService.ENABLE_REMOTE_CLUSTERS;
import static org.opensearch.transport.RemoteClusterService.REMOTE_CLUSTER_SKIP_UNAVAILABLE;
        assertThat(REMOTE_INITIAL_CONNECTION_TIMEOUT_SETTING.get(Settings.EMPTY), equalTo(new TimeValue(30, TimeUnit.SECONDS)));
import static org.opensearch.transport.SniffConnectionStrategy.REMOTE_CLUSTERS_PROXY;
import org.opensearch.cluster.node.DiscoveryNode;
    public void testDisableEnableRemoteClusters() {
import static org.opensearch.transport.RemoteClusterService.REMOTE_NODE_ATTRIBUTE;
import org.opensearch.test.OpenSearchTestCase;
        final String alias = randomAlphaOfLength(8);
    public void testRemoteNodeAttributeDefault() {
    }  
 * GitHub history for details.
        assertSettingDeprecationsAndWarnings(new Setting<?>[] { ENABLE_REMOTE_CLUSTERS });
        assertThat(REMOTE_CLUSTER_SEEDS.getConcreteSettingForNamespace(alias).get(Settings.EMPTY), emptyCollectionOf(String.class));
 * Modifications Copyright OpenSearch Contributors. See
}
        final Settings settings = remoteClusterClientNode();  
        assertThat(REMOTE_CONNECTIONS_PER_CLUSTER.get(Settings.EMPTY), equalTo(3));
        assertThat(NodeRoleSettings.NODE_ROLES_SETTING.get(Settings.EMPTY), hasItem(DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE));
        assertThat(NodeRoleSettings.NODE_ROLES_SETTING.get(settings), hasItem(DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE));
    public void testSeedsDefault() {  
package org.opensearch.transport;
 * Licensed to Elasticsearch under one or more contributor  
    }  
    public void testRemoteClusterClientDefault() {  
import static org.hamcrest.Matchers.not;
import org.opensearch.common.unit.TimeValue;
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
        assertTrue(DiscoveryNode.isRemoteClusterClient(settings));
        assertFalse(DiscoveryNode.isRemoteClusterClient(Settings.builder().put(ENABLE_REMOTE_CLUSTERS.getKey(), false).build()));  
 * under the License.  
    }  
 */  
 * Unless required by applicable law or agreed to in writing,
    }
import static org.opensearch.test.NodeRoles.nonRemoteClusterClientNode;
 *
 * the Apache License, Version 2.0 (the "License"); you may
    }  
 */  
 * ownership. Elasticsearch licenses this file to you under  
/*  
/*
    public void testAddRemoteClusterClientRole() {
 * license agreements. See the NOTICE file distributed with
 */
        final String alias = randomAlphaOfLength(8);  
 * this work for additional information regarding copyright
import static org.hamcrest.Matchers.emptyCollectionOf;
import org.opensearch.node.NodeRoleSettings;  
    public void testSkipUnavailableDefault() {
import org.opensearch.common.settings.Setting;  
import static org.hamcrest.Matchers.hasItem;
 * KIND, either express or implied.  See the License for the
        assertFalse(DiscoveryNode.isRemoteClusterClient(settings));
        assertThat(NodeRoleSettings.NODE_ROLES_SETTING.get(settings), not(hasItem(DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE)));
        assertFalse(REMOTE_CLUSTER_SKIP_UNAVAILABLE.getConcreteSettingForNamespace(alias).get(Settings.EMPTY));  
import java.util.concurrent.TimeUnit;  
        final String alias = randomAlphaOfLength(8);
    public void testProxyDefault() {
import static org.opensearch.transport.SniffConnectionStrategy.REMOTE_CONNECTIONS_PER_CLUSTER;
    }
import static org.opensearch.transport.RemoteClusterService.REMOTE_INITIAL_CONNECTION_TIMEOUT_SETTING;  
import static org.hamcrest.Matchers.equalTo;  
    public void testConnectionsPerClusterDefault() {  
import static org.opensearch.transport.SniffConnectionStrategy.REMOTE_CLUSTER_SEEDS;  
        assertThat(REMOTE_NODE_ATTRIBUTE.get(Settings.EMPTY), equalTo(""));  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.cluster.node.DiscoveryNodeRole;
 *
import org.opensearch.common.settings.Settings;
        assertTrue(DiscoveryNode.isRemoteClusterClient(Settings.EMPTY));
 * You may obtain a copy of the License at  
    public void testInitialConnectTimeoutDefault() {
/*  
 *  
    }  
    }
    public void testRemoveRemoteClusterClientRole() {
import static org.opensearch.test.NodeRoles.remoteClusterClientNode;  
        assertThat(REMOTE_CLUSTERS_PROXY.getConcreteSettingForNamespace(alias).get(Settings.EMPTY), equalTo(""));
    }
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
