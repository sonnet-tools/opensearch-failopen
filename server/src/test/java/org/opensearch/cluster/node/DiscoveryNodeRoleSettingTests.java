 * You may obtain a copy of the License at  
        final Settings legacyFalse = Settings.builder().put(role.legacySetting().getKey(), false).build();  
    }  
 *
        assertSettingDeprecationsAndWarnings(new Setting<?>[] { role.legacySetting() });
import static org.hamcrest.Matchers.hasItem;
        runRoleTest(DiscoveryNode::isDataNode, DiscoveryNodeRole.DATA_ROLE);
        assertTrue(predicate.test(legacyTrue));  
    }  
        DiscoveryNode.setDeprecatedMasterRole();
import java.util.Collections;
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
    }
import static org.opensearch.test.NodeRoles.onlyRole;
 * specific language governing permissions and limitations
        assertNoDeprecationWarnings();
    }  
/*
 * GitHub history for details.
 * not use this file except in compliance with the License.
        runRoleTest(DiscoveryNode::isClusterManagerNode, DiscoveryNodeRole.MASTER_ROLE);
import java.util.function.Predicate;  
import org.opensearch.common.settings.Setting;
        final Settings settings = Settings.builder().put(onlyRole(role)).put(role.legacySetting().getKey(), randomBoolean()).build();
        assertThat(DiscoveryNode.getRolesFromSettings(legacyFalse), not(hasItem(role)));
 * SPDX-License-Identifier: Apache-2.0
    public void testIsRemoteClusterClient() {
        assertNoDeprecationWarnings();  
import static org.hamcrest.Matchers.startsWith;  
    public void testIsDataNode() {
    public void testIsIngestNode() {
 */  
 * Licensed to Elasticsearch under one or more contributor  
        assertNoDeprecationWarnings();
        assertThat(e.getMessage(), startsWith("can not explicitly configure node roles and use legacy role setting"));
/*  
        assertNoDeprecationWarnings();  
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertFalse(predicate.test(removeRoles(Collections.singleton(role))));
    }
    private void runRoleTest(final Predicate<Settings> predicate, final DiscoveryNodeRole role) {  
        assertTrue(predicate.test(onlyRole(role)));
 * KIND, either express or implied.  See the License for the
import org.opensearch.test.OpenSearchTestCase;  
        runRoleTest(DiscoveryNode::isRemoteClusterClient, DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE);  
package org.opensearch.cluster.node;
import static org.hamcrest.Matchers.not;
        final IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> DiscoveryNode.getRolesFromSettings(settings));  
/*  
import static org.opensearch.test.NodeRoles.removeRoles;  
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.settings.Settings;
 *  
 */  
        assertNoDeprecationWarnings();  
}
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
 */
 * under the License.  
    public void testIsMasterNode() {  
        final Settings legacyTrue = Settings.builder().put(role.legacySetting().getKey(), true).build();
public class DiscoveryNodeRoleSettingTests extends OpenSearchTestCase {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
        assertFalse(predicate.test(legacyFalse));
 *
        assertThat(DiscoveryNode.getRolesFromSettings(legacyTrue), hasItem(role));  
        runRoleTest(DiscoveryNode::isIngestNode, DiscoveryNodeRole.INGEST_ROLE);  
        assertNoDeprecationWarnings();  
 * The OpenSearch Contributors require contributions made to  
