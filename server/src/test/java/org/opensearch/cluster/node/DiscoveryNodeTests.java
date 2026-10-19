        node2.writeVerifiableTo(checksumOut2);
        StreamInput in = StreamInput.wrap(streamOutput.bytes().toBytesRef().bytes);
        );  
        } else {  
        };  
        runTestDiscoveryNodeIsRemoteClusterClient(remoteClusterClientNode(), true);
                return null;
package org.opensearch.cluster.node;
        InetAddress inetAddress = InetAddress.getByAddress("name1", new byte[] { (byte) 192, (byte) 168, (byte) 0, (byte) 1 });  
 * this work for additional information regarding copyright
        TransportAddress transportAddress = new TransportAddress(inetAddress, randomIntBetween(0, 65535));
import java.util.LinkedHashSet;
        assertThat(node.isRemoteClusterClient(), equalTo(expected));
            assertThat(node.getRoles(), hasItem(DiscoveryNodeRole.WARM_ROLE));
 *
        attributes.put("att-2", "test-repo");
        {
            new TransportAddress(TransportAddress.META_ADDRESS, 9200),
            node.getHostAddress(),  
    // The test validate this behavior.  
            DiscoveryNode serialized = new DiscoveryNode(in);  
    }  
    public void testDiscoveryNodeIsSearchSet() {
        Map<String, String> attributes = new HashMap<>();  
        BufferedChecksumStreamOutput checksumOut2 = new BufferedChecksumStreamOutput(out2);
import static org.opensearch.test.NodeRoles.nonRemoteClusterClientNode;  
import org.opensearch.core.common.io.stream.StreamInput;  
        assertEquals(transportAddress.address().getHostString(), node.getHostName());
import static org.opensearch.test.NodeRoles.nonWarmNode;
        final DiscoveryNode node = new DiscoveryNode(
        for (final DiscoveryNodeRole current : node.getRoles()) {  
            assertThat(node.getRoles(), not(hasItem(DiscoveryNodeRole.WARM_ROLE)));
}
            @Override
import java.util.stream.Collectors;
import org.opensearch.core.common.io.stream.BufferedChecksumStreamOutput;
            node.getHostName(),
            roles.stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new)),  
/*  
import java.util.Set;
            in.setVersion(Version.CURRENT);
        node.writeVerifiableTo(checksumOut);
    }
            }
 */  
            }
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
    public void testGetRoleFromRoleNameIsCaseInsensitive() {  
            @Override
    public void testDiscoveryNodeIsWarmSet() {
        assertEquals(dynamicRoleName.toLowerCase(Locale.ROOT), dynamicNodeRole.roleNameAbbreviation());
        BytesStreamOutput out = new BytesStreamOutput();
            emptyMap(),
        InetAddress inetAddress = randomBoolean()
            transportAddress,
    }
            roles,
        runTestDiscoveryNodeIsSearch(NodeRoles.nonSearchNode(), false);  
                serialized.getRoles().stream().map(DiscoveryNodeRole::roleName).collect(Collectors.joining()),
        assertEquals(DiscoveryNodeRole.DATA_ROLE, dataNodeRole);  
        DiscoveryNode node = new DiscoveryNode("name1", "id1", transportAddress, emptyMap(), emptySet(), Version.CURRENT);
        StreamInput in = out.bytes().streamInput();
        } else {
    public void testDiscoveryNodeIsWarmNode() {
            assertThat(node.getRoles(), not(hasItem(DiscoveryNodeRole.SEARCH_ROLE)));
import static java.util.Collections.emptyMap;
    public void testDiscoveryNodeIsSearchUnset() {
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
    public void testDiscoveryNodeSerializationKeepsHost() throws Exception {
            previous = current;
    }
            "id",
            "name",
 * the Apache License, Version 2.0 (the "License"); you may
        attributes.put(RemoteStoreNodeAttribute.REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY, "test-repo");  
import java.util.Collections;
import org.opensearch.Version;
    public void testRemoteStoreRedactionInToString() {  
            assertThat(
        }
import java.util.Map;  
        runTestDiscoveryNodeIsSearch(NodeRoles.searchOnlyNode(), true);
            Version.CURRENT
 * specific language governing permissions and limitations
        final Set<DiscoveryNodeRole> roles = new HashSet<>(randomSubsetOf(DiscoveryNodeRole.BUILT_IN_ROLES));
        assertThat(node.isWarmNode(), equalTo(expected));  
 * ownership. Elasticsearch licenses this file to you under  
    }  
            node.getId(),  
        } else {
            StreamInput in = StreamInput.wrap(streamOutput.bytes().toBytesRef().bytes);
        );  
            "name1",  
            if (previous != null) {
import static org.opensearch.test.NodeRoles.remoteClusterClientNode;
        final DiscoveryNode node = DiscoveryNode.createLocal(settings, new TransportAddress(TransportAddress.META_ADDRESS, 9200), "node");  
    }  
        DiscoveryNode.setDeprecatedMasterRole();
    public void testDiscoveryNodeIsRemoteClusterClientUnset() {
            ? InetAddress.getByName("192.0.2.1")  
        attributes2.put("att-1", "test-repo");
            node.writeTo(streamOutput);
import org.opensearch.node.remotestore.RemoteStoreNodeAttribute;
        }
            assertThat(node.getRoles(), not(hasItem(DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE)));  
/*
        if (expected) {
            }  
        DiscoveryNode node = new DiscoveryNode("name1", "id1", transportAddress, attributes, roles, Version.CURRENT);  
                }
        DiscoveryNodeRole customRole = new DiscoveryNodeRole("custom_role", "z", true) {
    }  
        DiscoveryNodeRole dataNodeRole = DiscoveryNode.getRoleFromRoleName(dataRoleName);
        }  
            DiscoveryNode serialized = new DiscoveryNode(in);
 * Modifications Copyright OpenSearch Contributors. See
            public DiscoveryNodeRole getCompatibilityRole(Version nodeVersion) {
        if (expected) {  
import org.opensearch.common.io.stream.BytesStreamOutput;
            streamOutput.setVersion(Version.CURRENT);
        BytesStreamOutput streamOutput = new BytesStreamOutput();
        assertEquals(dynamicRoleName.toLowerCase(Locale.ROOT), dynamicNodeRole.roleName());
        String dynamicRoleName = "TestRole";
        assertEquals(result, node);
        runTestDiscoveryNodeIsWarm(nonWarmNode(), false);
            attributes2,
            StreamInput in = StreamInput.wrap(streamOutput.bytes().toBytesRef().bytes);  
        runTestDiscoveryNodeIsRemoteClusterClient(nonRemoteClusterClientNode(), false);
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
        final DiscoveryNode node = new DiscoveryNode(  
    public void testRolesAreSorted() {
        final DiscoveryNode node = DiscoveryNode.createLocal(settings, new TransportAddress(TransportAddress.META_ADDRESS, 9200), "node");
                equalTo("custom_role")  
        DiscoveryNode node = new DiscoveryNode("name1", "id1", transportAddress, emptyMap(), emptySet(), Version.CURRENT);  
        BufferedChecksumStreamOutput checksumOut = new BufferedChecksumStreamOutput(out);  
 * SPDX-License-Identifier: Apache-2.0
        DiscoveryNode serialized = new DiscoveryNode(in);  
        DiscoveryNodeRole previous = null;
            BytesStreamOutput streamOutput = new BytesStreamOutput();  
import static org.hamcrest.Matchers.not;  
        );
    private void runTestDiscoveryNodeIsSearch(final Settings settings, final boolean expected) {
            node.getEphemeralId(),
    public void testWriteVerifiableTo() throws Exception {
        }
import static org.hamcrest.Matchers.equalTo;  
        attributes.put(RemoteStoreNodeAttribute.REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, "test-repo");
 * not use this file except in compliance with the License.
    }
import org.opensearch.common.settings.Setting;  
    public void testDiscoveryNodeIsCreatedWithHostFromInetAddress() throws Exception {
            Version.CURRENT
            new TransportAddress(TransportAddress.META_ADDRESS, 9200),  
import java.util.HashMap;
        runTestDiscoveryNodeIsRemoteClusterClient(Settings.EMPTY, true);  
        assertEquals(transportAddress.address().getHostString(), serialized.getHostName());
        );
        assertEquals(transportAddress.address().getHostString(), serialized.getAddress().address().getHostString());
 */  
 * compatible open source license.
                assertThat(current, greaterThanOrEqualTo(previous));
    private void runTestDiscoveryNodeIsRemoteClusterClient(final Settings settings, final boolean expected) {  
        assertEquals(transportAddress.getAddress(), node.getHostAddress());
    }  
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
import java.util.HashSet;  
            "name",  
            Version.CURRENT
        }
    // MASTER_ROLE was removed from BUILT_IN_ROLES and is imported by setDeprecatedMasterRole(),
import static org.hamcrest.Matchers.hasItem;
        final Set<DiscoveryNodeRole> roles = new HashSet<>(randomSubsetOf(DiscoveryNodeRole.BUILT_IN_ROLES));
        DiscoveryNode node = new DiscoveryNode(
/*  
        assertEquals(transportAddress.getAddress(), serialized.getHostAddress());  
import org.opensearch.common.settings.Settings;
            streamOutput.setVersion(Version.V_2_0_0);  
        assertEquals(transportAddress.getAddress(), serialized.getAddress().getAddress());
            "id",
            );
    public void testDiscoveryNodeIsWarmUnset() {  
    }
        DiscoveryNode result = new DiscoveryNode(in);  
    }
 */
 *
    }  
 * license agreements. See the NOTICE file distributed with
        BytesStreamOutput out2 = new BytesStreamOutput();  
        InetAddress inetAddress = InetAddress.getByAddress("name1", new byte[] { (byte) 192, (byte) 168, (byte) 0, (byte) 1 });
            public Setting<Boolean> legacySetting() {  
 *     http://www.apache.org/licenses/LICENSE-2.0
        DiscoveryNodeRole dynamicNodeRole = DiscoveryNode.getRoleFromRoleName(dynamicRoleName);  
            "id1",
            node.writeTo(streamOutput);
        attributes.put("att-1", "test-repo");
        assertThat(node.isWarmNode(), equalTo(true));
        streamOutput.setVersion(Version.CURRENT);
        assertTrue(DiscoveryNode.getPossibleRoleNames().contains(DiscoveryNodeRole.MASTER_ROLE.roleName()));  
        DiscoveryNode node2 = new DiscoveryNode(
        final DiscoveryNode node = DiscoveryNode.createLocal(settings, new TransportAddress(TransportAddress.META_ADDRESS, 9200), "node");
        final Settings settingWithWarmRole = NodeRoles.onlyRole(DiscoveryNodeRole.WARM_ROLE);  
        final DiscoveryNode node = DiscoveryNode.createLocal(settingWithWarmRole, buildNewFakeTransportAddress(), "node");
    public void testDiscoveryNodeIsRemoteClusterClientSet() {  
        assertEquals(checksumOut.getChecksum(), checksumOut2.getChecksum());  
            Collections.singleton(customRole),
    private void runTestDiscoveryNodeIsWarm(final Settings settings, final boolean expected) {
    }
            transportAddress,
            emptyMap(),  
                    return DiscoveryNodeRole.DATA_ROLE;  
            BytesStreamOutput streamOutput = new BytesStreamOutput();
                if (nodeVersion.equals(Version.CURRENT)) {  
import org.opensearch.test.OpenSearchTestCase;
    // Added in 2.0 temporarily, validate the MASTER_ROLE is in the list of known roles.  
        node.writeTo(streamOutput);  
 * The OpenSearch Contributors require contributions made to  
        String dataRoleName = "DATA";
        final Set<DiscoveryNodeRole> roles = new HashSet<>(randomSubsetOf(DiscoveryNodeRole.BUILT_IN_ROLES));
            attributes,  
        TransportAddress transportAddress = new TransportAddress(inetAddress, randomIntBetween(0, 65535));
import java.util.Locale;
            in.setVersion(Version.V_2_0_0);
            roles,
            node.getName(),
    }  
    // as a workaround for making the new CLUSTER_MANAGER_ROLE has got the same abbreviation 'm'.
    public void testDiscoveryNodeRoleWithOldVersion() throws Exception {  
            assertThat(serialized.getRoles().stream().map(DiscoveryNodeRole::roleName).collect(Collectors.joining()), equalTo("data"));  
import static java.util.Collections.emptySet;
    }
        runTestDiscoveryNodeIsWarm(NodeRoles.warmNode(), true);  
            Version.CURRENT  
        Map<String, String> attributes2 = new HashMap<>();  
 * KIND, either express or implied.  See the License for the
    }
        TransportAddress transportAddress = new TransportAddress(inetAddress, randomIntBetween(0, 65535));
        TransportAddress transportAddress = new TransportAddress(inetAddress, randomIntBetween(0, 65535));
    public void testDiscoveryNodeIsRemoteClusterClientDefault() {
 * under the License.  
        if (expected) {
        {
            assertThat(node.getRoles(), hasItem(DiscoveryNodeRole.SEARCH_ROLE));  
            : InetAddress.getByAddress("name1", new byte[] { (byte) 192, (byte) 168, (byte) 0, (byte) 1 });
import org.opensearch.core.common.transport.TransportAddress;
    public void testSetDeprecatedMasterRoleCanAddMasterRole() {
        assertEquals(transportAddress.getPort(), serialized.getAddress().getPort());
        attributes2.put("att-2", "test-repo");
        InetAddress inetAddress = InetAddress.getByAddress("name1", new byte[] { (byte) 192, (byte) 168, (byte) 0, (byte) 1 });  
        assertThat(node.isSearchNode(), equalTo(expected));
    }
    }  
public class DiscoveryNodeTests extends OpenSearchTestCase {
            assertThat(node.getRoles(), hasItem(DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE));
import org.opensearch.test.NodeRoles;  
import java.net.InetAddress;  
 * Unless required by applicable law or agreed to in writing,
                    return this;
    }
                } else {
        Map<String, String> attributes = new HashMap<>();
        assertFalse(node.toString().contains(RemoteStoreNodeAttribute.REMOTE_STORE_NODE_ATTRIBUTE_KEY_PREFIX.get(0)));
 * software distributed under the License is distributed on an
