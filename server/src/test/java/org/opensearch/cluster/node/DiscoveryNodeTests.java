    }
    public void testDiscoveryNodeIsRemoteClusterClientDefault() {
        InetAddress inetAddress = InetAddress.getByAddress("name1", new byte[] { (byte) 192, (byte) 168, (byte) 0, (byte) 1 });
            node.writeTo(streamOutput);
            node.getHostAddress(),
        runTestDiscoveryNodeIsRemoteClusterClient(nonRemoteClusterClientNode(), false);
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        }
            Version.CURRENT
 * not use this file except in compliance with the License.
            assertThat(node.getRoles(), not(hasItem(DiscoveryNodeRole.SEARCH_ROLE)));
    public void testRemoteStoreRedactionInToString() {
                if (nodeVersion.equals(Version.CURRENT)) {
import org.opensearch.test.OpenSearchTestCase;
        }
import static org.hamcrest.Matchers.hasItem;
    public void testDiscoveryNodeIsSearchUnset() {
        Map<String, String> attributes = new HashMap<>();
                } else {
        InetAddress inetAddress = InetAddress.getByAddress("name1", new byte[] { (byte) 192, (byte) 168, (byte) 0, (byte) 1 });
                assertThat(current, greaterThanOrEqualTo(previous));
            emptyMap(),
            public DiscoveryNodeRole getCompatibilityRole(Version nodeVersion) {
        assertEquals(transportAddress.getPort(), serialized.getAddress().getPort());
        StreamInput in = StreamInput.wrap(streamOutput.bytes().toBytesRef().bytes);
import java.util.HashSet;
        InetAddress inetAddress = randomBoolean()
        assertEquals(dynamicRoleName.toLowerCase(Locale.ROOT), dynamicNodeRole.roleNameAbbreviation());
 * Modifications Copyright OpenSearch Contributors. See
        node.writeVerifiableTo(checksumOut);
        {
            in.setVersion(Version.CURRENT);
    public void testDiscoveryNodeIsRemoteClusterClientUnset() {
            }
    }
    // as a workaround for making the new CLUSTER_MANAGER_ROLE has got the same abbreviation 'm'.
            Version.CURRENT
        DiscoveryNode node = new DiscoveryNode("name1", "id1", transportAddress, emptyMap(), emptySet(), Version.CURRENT);
            assertThat(node.getRoles(), not(hasItem(DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE)));
            node.getId(),
import static org.hamcrest.Matchers.not;
        TransportAddress transportAddress = new TransportAddress(inetAddress, randomIntBetween(0, 65535));
            BytesStreamOutput streamOutput = new BytesStreamOutput();
    public void testDiscoveryNodeIsWarmNode() {
 */
 * Licensed to Elasticsearch under one or more contributor
        );
        StreamInput in = out.bytes().streamInput();
        if (expected) {
    }
    }
        TransportAddress transportAddress = new TransportAddress(inetAddress, randomIntBetween(0, 65535));
        DiscoveryNode node = new DiscoveryNode("name1", "id1", transportAddress, attributes, roles, Version.CURRENT);
    // The test validate this behavior.
        BytesStreamOutput out2 = new BytesStreamOutput();
 * You may obtain a copy of the License at
    }
 *
        for (final DiscoveryNodeRole current : node.getRoles()) {
                }
    }
        assertEquals(dynamicRoleName.toLowerCase(Locale.ROOT), dynamicNodeRole.roleName());
 * this work for additional information regarding copyright
import org.opensearch.test.NodeRoles;
import static java.util.Collections.emptySet;
        assertEquals(transportAddress.address().getHostString(), serialized.getAddress().address().getHostString());
            emptyMap(),
        assertEquals(result, node);
        final DiscoveryNode node = DiscoveryNode.createLocal(settingWithWarmRole, buildNewFakeTransportAddress(), "node");
import java.net.InetAddress;
import java.util.Locale;
/*
 * GitHub history for details.
        runTestDiscoveryNodeIsRemoteClusterClient(Settings.EMPTY, true);
    }
            streamOutput.setVersion(Version.CURRENT);
    }
        DiscoveryNode result = new DiscoveryNode(in);
            new TransportAddress(TransportAddress.META_ADDRESS, 9200),
        }
        if (expected) {
        String dynamicRoleName = "TestRole";
        attributes.put("att-1", "test-repo");
        DiscoveryNode.setDeprecatedMasterRole();
 * license agreements. See the NOTICE file distributed with
    public void testSetDeprecatedMasterRoleCanAddMasterRole() {
 * under the License.
        assertEquals(transportAddress.address().getHostString(), serialized.getHostName());
    private void runTestDiscoveryNodeIsRemoteClusterClient(final Settings settings, final boolean expected) {
                    return DiscoveryNodeRole.DATA_ROLE;
            assertThat(
    public void testDiscoveryNodeIsCreatedWithHostFromInetAddress() throws Exception {
        assertThat(node.isSearchNode(), equalTo(expected));
        BufferedChecksumStreamOutput checksumOut2 = new BufferedChecksumStreamOutput(out2);
        );
        runTestDiscoveryNodeIsSearch(NodeRoles.nonSearchNode(), false);
        };
        final Set<DiscoveryNodeRole> roles = new HashSet<>(randomSubsetOf(DiscoveryNodeRole.BUILT_IN_ROLES));
/*
        }
import static org.opensearch.test.NodeRoles.nonWarmNode;
            }
        assertThat(node.isRemoteClusterClient(), equalTo(expected));
public class DiscoveryNodeTests extends OpenSearchTestCase {
        DiscoveryNodeRole previous = null;
        } else {
    }
import org.opensearch.node.remotestore.RemoteStoreNodeAttribute;
 * the Apache License, Version 2.0 (the "License"); you may
            assertThat(node.getRoles(), hasItem(DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE));
        }
        );
            @Override
            "id",
                serialized.getRoles().stream().map(DiscoveryNodeRole::roleName).collect(Collectors.joining()),
    public void testDiscoveryNodeRoleWithOldVersion() throws Exception {
import static org.opensearch.test.NodeRoles.nonRemoteClusterClientNode;
import java.util.LinkedHashSet;
            in.setVersion(Version.V_2_0_0);
import java.util.HashMap;
        final Set<DiscoveryNodeRole> roles = new HashSet<>(randomSubsetOf(DiscoveryNodeRole.BUILT_IN_ROLES));
    public void testDiscoveryNodeSerializationKeepsHost() throws Exception {
        assertThat(node.isWarmNode(), equalTo(true));
        DiscoveryNode serialized = new DiscoveryNode(in);
import java.util.Collections;
 * compatible open source license.
import org.opensearch.common.settings.Setting;
    }
        runTestDiscoveryNodeIsWarm(nonWarmNode(), false);
        assertFalse(node.toString().contains(RemoteStoreNodeAttribute.REMOTE_STORE_NODE_ATTRIBUTE_KEY_PREFIX.get(0)));
 * ownership. Elasticsearch licenses this file to you under
        assertEquals(transportAddress.address().getHostString(), node.getHostName());
        Map<String, String> attributes2 = new HashMap<>();
    private void runTestDiscoveryNodeIsSearch(final Settings settings, final boolean expected) {
        final DiscoveryNode node = DiscoveryNode.createLocal(settings, new TransportAddress(TransportAddress.META_ADDRESS, 9200), "node");
        final DiscoveryNode node = new DiscoveryNode(
            node.getEphemeralId(),
 * SPDX-License-Identifier: Apache-2.0
        } else {
            : InetAddress.getByAddress("name1", new byte[] { (byte) 192, (byte) 168, (byte) 0, (byte) 1 });
        }
            Version.CURRENT
import static org.opensearch.test.NodeRoles.remoteClusterClientNode;
            );
            StreamInput in = StreamInput.wrap(streamOutput.bytes().toBytesRef().bytes);
        DiscoveryNodeRole dataNodeRole = DiscoveryNode.getRoleFromRoleName(dataRoleName);
            transportAddress,
        final Set<DiscoveryNodeRole> roles = new HashSet<>(randomSubsetOf(DiscoveryNodeRole.BUILT_IN_ROLES));
    }
 * specific language governing permissions and limitations
    }
 *
    }
        runTestDiscoveryNodeIsRemoteClusterClient(remoteClusterClientNode(), true);
    public void testDiscoveryNodeIsWarmUnset() {
        node2.writeVerifiableTo(checksumOut2);
            assertThat(serialized.getRoles().stream().map(DiscoveryNodeRole::roleName).collect(Collectors.joining()), equalTo("data"));
        attributes2.put("att-1", "test-repo");
import org.opensearch.Version;
        attributes.put(RemoteStoreNodeAttribute.REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY, "test-repo");
        DiscoveryNode node = new DiscoveryNode(
 *     http://www.apache.org/licenses/LICENSE-2.0
            node.getName(),
    }
        BufferedChecksumStreamOutput checksumOut = new BufferedChecksumStreamOutput(out);
            attributes,
        streamOutput.setVersion(Version.CURRENT);
    }
import org.opensearch.core.common.io.stream.StreamInput;
            assertThat(node.getRoles(), not(hasItem(DiscoveryNodeRole.WARM_ROLE)));
            DiscoveryNode serialized = new DiscoveryNode(in);
    public void testWriteVerifiableTo() throws Exception {
            "id",
        String dataRoleName = "DATA";
                return null;
        node.writeTo(streamOutput);
            node.getHostName(),
            if (previous != null) {
                equalTo("custom_role")
        TransportAddress transportAddress = new TransportAddress(inetAddress, randomIntBetween(0, 65535));
import java.util.Set;
            streamOutput.setVersion(Version.V_2_0_0);
import java.util.stream.Collectors;
            @Override
        assertThat(node.isWarmNode(), equalTo(expected));
            assertThat(node.getRoles(), hasItem(DiscoveryNodeRole.SEARCH_ROLE));
import org.opensearch.core.common.transport.TransportAddress;
        );
        DiscoveryNode node2 = new DiscoveryNode(
import java.util.Map;
            StreamInput in = StreamInput.wrap(streamOutput.bytes().toBytesRef().bytes);
            DiscoveryNode serialized = new DiscoveryNode(in);
    public void testDiscoveryNodeIsSearchSet() {
 * KIND, either express or implied.  See the License for the
package org.opensearch.cluster.node;
    public void testDiscoveryNodeIsWarmSet() {
    }
        InetAddress inetAddress = InetAddress.getByAddress("name1", new byte[] { (byte) 192, (byte) 168, (byte) 0, (byte) 1 });
                    return this;
 */
        assertEquals(transportAddress.getAddress(), node.getHostAddress());
            public Setting<Boolean> legacySetting() {
        BytesStreamOutput out = new BytesStreamOutput();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            node.writeTo(streamOutput);
 * The OpenSearch Contributors require contributions made to
        assertEquals(DiscoveryNodeRole.DATA_ROLE, dataNodeRole);
            new TransportAddress(TransportAddress.META_ADDRESS, 9200),
    }
        final Settings settingWithWarmRole = NodeRoles.onlyRole(DiscoveryNodeRole.WARM_ROLE);
        TransportAddress transportAddress = new TransportAddress(inetAddress, randomIntBetween(0, 65535));
            }
            previous = current;
            transportAddress,
 *
            roles,
        attributes.put("att-2", "test-repo");
    private void runTestDiscoveryNodeIsWarm(final Settings settings, final boolean expected) {
            assertThat(node.getRoles(), hasItem(DiscoveryNodeRole.WARM_ROLE));
}
        Map<String, String> attributes = new HashMap<>();
        DiscoveryNode node = new DiscoveryNode("name1", "id1", transportAddress, emptyMap(), emptySet(), Version.CURRENT);
        assertEquals(transportAddress.getAddress(), serialized.getHostAddress());
/*
            roles.stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new)),
        assertEquals(transportAddress.getAddress(), serialized.getAddress().getAddress());
        {
 */
        runTestDiscoveryNodeIsWarm(NodeRoles.warmNode(), true);
        } else {
    public void testDiscoveryNodeIsRemoteClusterClientSet() {
            "name",
            "name1",
        assertTrue(DiscoveryNode.getPossibleRoleNames().contains(DiscoveryNodeRole.MASTER_ROLE.roleName()));
            "name",
            roles,
            BytesStreamOutput streamOutput = new BytesStreamOutput();
    public void testRolesAreSorted() {
            Version.CURRENT
import org.opensearch.common.io.stream.BytesStreamOutput;
        final DiscoveryNode node = DiscoveryNode.createLocal(settings, new TransportAddress(TransportAddress.META_ADDRESS, 9200), "node");
 * this file be licensed under the Apache-2.0 license or a
        attributes.put(RemoteStoreNodeAttribute.REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, "test-repo");
        assertEquals(checksumOut.getChecksum(), checksumOut2.getChecksum());
            "id1",
        runTestDiscoveryNodeIsSearch(NodeRoles.searchOnlyNode(), true);
    public void testGetRoleFromRoleNameIsCaseInsensitive() {
        final DiscoveryNode node = new DiscoveryNode(
        DiscoveryNodeRole customRole = new DiscoveryNodeRole("custom_role", "z", true) {
 * software distributed under the License is distributed on an
    }
            ? InetAddress.getByName("192.0.2.1")
            attributes2,
        attributes2.put("att-2", "test-repo");
import static java.util.Collections.emptyMap;
import org.opensearch.core.common.io.stream.BufferedChecksumStreamOutput;
    // Added in 2.0 temporarily, validate the MASTER_ROLE is in the list of known roles.
        if (expected) {
import org.opensearch.common.settings.Settings;
            Collections.singleton(customRole),
    // MASTER_ROLE was removed from BUILT_IN_ROLES and is imported by setDeprecatedMasterRole(),
import static org.hamcrest.Matchers.equalTo;
    }
        BytesStreamOutput streamOutput = new BytesStreamOutput();
        DiscoveryNodeRole dynamicNodeRole = DiscoveryNode.getRoleFromRoleName(dynamicRoleName);
        final DiscoveryNode node = DiscoveryNode.createLocal(settings, new TransportAddress(TransportAddress.META_ADDRESS, 9200), "node");
 * Unless required by applicable law or agreed to in writing,
