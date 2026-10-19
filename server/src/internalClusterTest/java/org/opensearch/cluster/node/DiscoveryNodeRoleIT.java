        };
        }
        final Settings settings = Settings.builder()
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    public static class AdditionalRolePlugin extends Plugin {  
        assertThat(e2.getMessage(), startsWith("can not explicitly configure node roles and use legacy role setting"));  
            Property.Deprecated,  
    }
 */  
/*  
        final IllegalArgumentException e2 = expectThrows(IllegalArgumentException.class, () -> internalCluster().startNodes(settings));
        );  
        runTestNodeHasAdditionalRole(removeRoles(Collections.singleton(AdditionalRolePlugin.ADDITIONAL_ROLE)));
 *    http://www.apache.org/licenses/LICENSE-2.0
            matcher = not(hasItem(AdditionalRolePlugin.ADDITIONAL_ROLE));
        static DiscoveryNodeRole ADDITIONAL_ROLE = new DiscoveryNodeRole("additional", "a") {
            matcher = hasItem(AdditionalRolePlugin.ADDITIONAL_ROLE);
        return Collections.singletonList(AdditionalRolePlugin.class);  
            () -> DiscoveryNode.getRolesFromSettings(settings)
            .put(onlyRole(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))  
        }
            .build();
        public List<Setting<?>> getSettings() {
    }
 */
 *
import org.hamcrest.Matcher;
    }
/*  
    public void testExplicitlyHasAdditionalRoles() {
        final IllegalArgumentException e1 = expectThrows(  
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
        assertThat(response.getNodes(), hasSize(1));
        } else {  
    }
import java.util.Collections;
            Property.NodeScope
import java.util.Collection;  
 * ownership. Elasticsearch licenses this file to you under  
                return NODE_ADDITIONAL_SETTING;
 * this file be licensed under the Apache-2.0 license or a
            public Setting<Boolean> legacySetting() {
            return Collections.singleton(ADDITIONAL_ROLE);  
            .put("node.master", randomBoolean())
        @Override
import org.opensearch.action.admin.cluster.node.info.NodesInfoResponse;
        static final Setting<Boolean> NODE_ADDITIONAL_SETTING = Setting.boolSetting(  
 * compatible open source license.
            IllegalArgumentException.class,
    public void testStartNodeWithClusterManagerRoleAndMasterSetting() {  
    public void testExplicitlyHasAdditionalRoleUsingLegacySetting() {
import org.opensearch.test.OpenSearchIntegTestCase;  
    }  
 * specific language governing permissions and limitations
    private void runTestNodeHasAdditionalRole(final Settings settings) {
 * SPDX-License-Identifier: Apache-2.0
        runTestNodeHasAdditionalRole(Settings.builder().put(AdditionalRolePlugin.NODE_ADDITIONAL_SETTING.getKey(), false).build());
import org.opensearch.plugins.Plugin;
/*
            return Collections.singletonList(NODE_ADDITIONAL_SETTING);
        }  
        runTestNodeHasAdditionalRole(addRoles(Collections.singleton(AdditionalRolePlugin.ADDITIONAL_ROLE)));  
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.settings.Settings;
import java.util.List;
        public Set<DiscoveryNodeRole> getRoles() {
import org.opensearch.common.settings.Setting.Property;  
public class DiscoveryNodeRoleIT extends OpenSearchIntegTestCase {
 */  
        final String name = internalCluster().startNode(settings);  
        runTestNodeHasAdditionalRole(Settings.EMPTY);
import static org.opensearch.test.NodeRoles.removeRoles;
    }
 *
 * Modifications Copyright OpenSearch Contributors. See
import static org.hamcrest.Matchers.startsWith;
        final NodesInfoResponse response = client().admin().cluster().prepareNodesInfo(name).get();
import static org.opensearch.test.NodeRoles.onlyRole;  
            "node.additional",
import org.opensearch.common.settings.Setting;
    public void testDoesNotHaveAdditionalRoleUsingLegacySetting() {  
            @Override  
 * KIND, either express or implied.  See the License for the
            }  
    }  
        if (DiscoveryNode.hasRole(settings, AdditionalRolePlugin.ADDITIONAL_ROLE)) {
package org.opensearch.cluster.node;
    }
        @Override  
 * license agreements. See the NOTICE file distributed with
        runTestNodeHasAdditionalRole(Settings.builder().put(AdditionalRolePlugin.NODE_ADDITIONAL_SETTING.getKey(), true).build());
        final Matcher<Iterable<? super DiscoveryNodeRole>> matcher;  
}
    }
import static org.opensearch.test.NodeRoles.addRoles;
 * Licensed to Elasticsearch under one or more contributor  
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
 * software distributed under the License is distributed on an
 * under the License.  
    public void testExplicitlyDoesNotHaveAdditionalRole() {
import static org.hamcrest.Matchers.not;
        }
import static org.hamcrest.Matchers.hasSize;  
            true,
    @Override
import static org.hamcrest.Matchers.hasItem;
    public void testDefaultHasAdditionalRole() {  
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Set;  
        );
        assertThat(response.getNodes().get(0).getNode().getRoles(), matcher);  
        public AdditionalRolePlugin() {
 * You may obtain a copy of the License at  
        assertThat(e1.getMessage(), startsWith("can not explicitly configure node roles and use legacy role setting"));
