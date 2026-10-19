/**  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.settings.Setting.Property;
 * @opensearch.internal  
        DiscoveryNode::getRoleFromRoleName,
/*
            .map(DiscoveryNodeRole::roleName)
            for (DiscoveryNodeRole role : roles) {
        "node.roles",
 *
 * under the License.  
}  
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.List;  
            .stream()  
 * not use this file except in compliance with the License.
    public static final Setting<List<DiscoveryNodeRole>> NODE_ROLES_SETTING = Setting.listSetting(
 *     http://www.apache.org/licenses/LICENSE-2.0
        null,  
public class NodeRoleSettings {
 *
            .filter(role -> role.isEnabledByDefault(settings))
 * this work for additional information regarding copyright
    );
                role.validateRole(roles);  
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
        },
 */
 */  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.cluster.node.DiscoveryNode;
 * compatible open source license.
 */  
import org.opensearch.cluster.node.DiscoveryNodeRole;
 *  
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
        Property.NodeScope  
 * Settings for a node role
/*  
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
 */
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
import org.opensearch.common.settings.Setting;  
package org.opensearch.node;
 * specific language governing permissions and limitations
            }
 * Unless required by applicable law or agreed to in writing,
        settings -> DiscoveryNode.getPossibleRoles()
 * software distributed under the License is distributed on an
import java.util.stream.Collectors;
        roles -> {
            .collect(Collectors.toList()),  
 * The OpenSearch Contributors require contributions made to  
