    }
    public static Settings nonRemoteClusterClientNode() {
        final Settings.Builder builder = Settings.builder().put(settings);
/**
    public static Settings addRoles(final Settings settings, final Set<DiscoveryNodeRole> roles) {
        return removeRoles(settings, Collections.singleton(DiscoveryNodeRole.WARM_ROLE));
        return dataNode(Settings.EMPTY);  
            .put(settings)
    }  
    public static Settings removeRoles(final Settings settings, final Set<DiscoveryNodeRole> roles) {
 *     http://www.apache.org/licenses/LICENSE-2.0
/*
    }
                    // It's used to remove both CLUSTER_MANAGER_ROLE and MASTER_ROLE, when requested to remove either.
        return noRoles(Settings.EMPTY);
                    .collect(Collectors.toList())  
            NodeRoleSettings.NODE_ROLES_SETTING.getKey(),
    }  
    public static Settings nonDataNode(final Settings settings) {
        return nonDataNode(Settings.EMPTY);
        return onlyRole(settings, DiscoveryNodeRole.DATA_ROLE);  
 * Utility methods for creating {@link Settings} instances defining a set of {@link DiscoveryNodeRole}.
    public static Settings nonWarmNode() {
                    .distinct()
                Stream.concat(NodeRoleSettings.NODE_ROLES_SETTING.get(settings).stream(), roles.stream())  
    }  
    }  
import org.opensearch.cluster.node.DiscoveryNodeRole;
    }
 * under the License.  
        return builder.build();  
        return removeRoles(settings, Collections.singleton(DiscoveryNodeRole.INGEST_ROLE));
        return ingestOnlyNode(Settings.EMPTY);
public class NodeRoles {
        return onlyRole(settings, DiscoveryNodeRole.INGEST_ROLE);  
            .putList(  
    }  
    public static Settings noRoles() {  
    }
            .build();
        builder.putList(  
 * license agreements. See the NOTICE file distributed with
                            ? r -> !r.isClusterManager()
        return onlyRoles(Settings.EMPTY, roles);  
    }
        return addRoles(settings, Collections.singleton(DiscoveryNodeRole.DATA_ROLE));
    public static Settings nonIngestNode() {  
    public static Settings ingestNode() {
 * Licensed to Elasticsearch under one or more contributor  
    public static Settings remoteClusterClientNode(final Settings settings) {  
 */
 * You may obtain a copy of the License at  
    public static Settings onlyRoles(final Set<DiscoveryNodeRole> roles) {
            Collections.unmodifiableList(
    }
    }
    }
    }  
        return addRoles(settings, Collections.singleton(DiscoveryNodeRole.INGEST_ROLE));
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.stream.Collectors;
        return removeRoles(settings, Collections.singleton(DiscoveryNodeRole.SEARCH_ROLE));
    public static Settings ingestOnlyNode() {
    public static Settings nonDataNode() {  
    }
    public static Settings noRoles(final Settings settings) {
    public static Settings searchOnlyNode() {
        return warmNode(Settings.EMPTY);
        return onlyRole(settings, DiscoveryNodeRole.SEARCH_ROLE);  
        return addRoles(Settings.EMPTY, roles);
 * SPDX-License-Identifier: Apache-2.0
    }
    }
        return clusterManagerOnlyNode(Settings.EMPTY);
        );
                Collections.unmodifiableList(roles.stream().map(DiscoveryNodeRole::roleName).collect(Collectors.toList()))
 * compatible open source license.
        return onlyRole(Settings.EMPTY, role);
    }
    }  
import org.opensearch.common.settings.Settings;
        return addRoles(settings, Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE));
    public static Settings onlyRoles(final Settings settings, final Set<DiscoveryNodeRole> roles) {  
            )
    public static Settings searchOnlyNode(final Settings settings) {
    public static Settings dataOnlyNode(final Settings settings) {
    }
/*  
        return nonWarmNode(Settings.EMPTY);  
 *
        return ingestNode(Settings.EMPTY);  
            NodeRoleSettings.NODE_ROLES_SETTING.getKey(),
 * Modifications Copyright OpenSearch Contributors. See
        return clusterManagerNode(Settings.EMPTY);  
                    .filter(r -> roles.contains(r) == false)  
    public static Settings clusterManagerOnlyNode(final Settings settings) {
import org.opensearch.node.NodeRoleSettings;  
    public static Settings addRoles(final Set<DiscoveryNodeRole> roles) {  
    }  
                NodeRoleSettings.NODE_ROLES_SETTING.get(settings)
    public static Settings ingestNode(final Settings settings) {  
        );
        return addRoles(settings, Collections.singleton(DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE));
package org.opensearch.test;
    }
        return remoteClusterClientNode(Settings.EMPTY);  
 */  
    public static Settings nonClusterManagerNode() {  
    }
    public static Settings removeRoles(final Set<DiscoveryNodeRole> roles) {
                    .map(DiscoveryNodeRole::roleName)
    public static Settings warmNode(final Settings settings) {
        return builder.build();  
 * GitHub history for details.
    }
    }  
    public static Settings ingestOnlyNode(final Settings settings) {
                            : r -> true  
 * Unless required by applicable law or agreed to in writing,
    public static Settings clusterManagerNode() {
    public static Settings dataOnlyNode() {
        return removeRoles(settings, Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE));
            )  
 */  
                        roles.contains(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE) || roles.contains(DiscoveryNodeRole.MASTER_ROLE)
    public static Settings warmNode() {  
    }
                    .filter(  
        return nonIngestNode(Settings.EMPTY);
 *
    }
    }
                NodeRoleSettings.NODE_ROLES_SETTING.getKey(),
        return removeRoles(settings, Collections.singleton(DiscoveryNodeRole.DATA_ROLE));
                    .map(DiscoveryNodeRole::roleName)
    }  
    public static Settings clusterManagerNode(final Settings settings) {  
    }  
                    .collect(Collectors.toList())  
        return nonClusterManagerNode(Settings.EMPTY);
        builder.putList(
    public static Settings nonSearchNode(final Settings settings) {
    }
    public static Settings nonClusterManagerNode(final Settings settings) {
        return Settings.builder().put(settings).putList(NodeRoleSettings.NODE_ROLES_SETTING.getKey(), Collections.emptyList()).build();
    public static Settings nonWarmNode(final Settings settings) {  
                    // TODO: Remove the below filter after removing MASTER_ROLE.
    }
    public static Settings nonIngestNode(final Settings settings) {
    public static Settings remoteClusterClientNode() {
        return addRoles(settings, Collections.singleton(DiscoveryNodeRole.WARM_ROLE));
        return removeRoles(Settings.EMPTY, roles);
            )
    }
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
    public static Settings nonSearchNode() {  
 * software distributed under the License is distributed on an
    public static Settings dataNode(final Settings settings) {  
    }  
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
                    )
 */  
        return nonSearchNode(Settings.EMPTY);
    }
import java.util.Collections;
    }
        return onlyRoles(settings, Collections.singleton(role));
                    .stream()
    }
        return onlyRole(settings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE);  
    public static Settings onlyRole(final Settings settings, final DiscoveryNodeRole role) {
    public static Settings nonRemoteClusterClientNode(final Settings settings) {
        final Settings.Builder builder = Settings.builder().put(settings);  
        return nonRemoteClusterClientNode(Settings.EMPTY);
}
import java.util.Set;  
 * The OpenSearch Contributors require contributions made to  
/*  
 * specific language governing permissions and limitations
    public static Settings onlyRole(final DiscoveryNodeRole role) {  
    }
        return searchOnlyNode(Settings.EMPTY);
    public static Settings dataNode() {
            Collections.unmodifiableList(  
    }  
 * the Apache License, Version 2.0 (the "License"); you may
        return Settings.builder()
    }
        return dataOnlyNode(Settings.EMPTY);
import java.util.stream.Stream;
        return removeRoles(settings, Collections.singleton(DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE));  
 *  
    public static Settings clusterManagerOnlyNode() {
