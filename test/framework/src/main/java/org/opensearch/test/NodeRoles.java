                    .map(DiscoveryNodeRole::roleName)
    }
 */
    }
        return warmNode(Settings.EMPTY);
    }
            .put(settings)
    }
    public static Settings dataOnlyNode(final Settings settings) {
        return removeRoles(settings, Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE));
        return searchOnlyNode(Settings.EMPTY);
    }
 *
 */
 * Utility methods for creating {@link Settings} instances defining a set of {@link DiscoveryNodeRole}.
    }
        );
    public static Settings searchOnlyNode() {
 * SPDX-License-Identifier: Apache-2.0
    public static Settings remoteClusterClientNode() {
    public static Settings dataNode(final Settings settings) {
            .putList(
 * under the License.
import org.opensearch.common.settings.Settings;
import org.opensearch.node.NodeRoleSettings;
    }
            )
        return removeRoles(settings, Collections.singleton(DiscoveryNodeRole.WARM_ROLE));
    public static Settings onlyRoles(final Settings settings, final Set<DiscoveryNodeRole> roles) {
        return removeRoles(Settings.EMPTY, roles);
/*
 * specific language governing permissions and limitations
                    .filter(
                    .map(DiscoveryNodeRole::roleName)
    public static Settings onlyRoles(final Set<DiscoveryNodeRole> roles) {
    }
    public static Settings warmNode() {
import org.opensearch.cluster.node.DiscoveryNodeRole;
            NodeRoleSettings.NODE_ROLES_SETTING.getKey(),
        return ingestOnlyNode(Settings.EMPTY);
    public static Settings dataOnlyNode() {
        final Settings.Builder builder = Settings.builder().put(settings);
        return Settings.builder().put(settings).putList(NodeRoleSettings.NODE_ROLES_SETTING.getKey(), Collections.emptyList()).build();
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor
    public static Settings warmNode(final Settings settings) {
import java.util.Collections;
    }
    }
 * You may obtain a copy of the License at
    public static Settings onlyRole(final Settings settings, final DiscoveryNodeRole role) {
            NodeRoleSettings.NODE_ROLES_SETTING.getKey(),
    public static Settings remoteClusterClientNode(final Settings settings) {
        return removeRoles(settings, Collections.singleton(DiscoveryNodeRole.DATA_ROLE));
    }
    }
 * Modifications Copyright OpenSearch Contributors. See
    public static Settings nonWarmNode(final Settings settings) {
}
 * not use this file except in compliance with the License.
    public static Settings dataNode() {
        return nonSearchNode(Settings.EMPTY);
            .build();
 * software distributed under the License is distributed on an
    }
    public static Settings nonSearchNode() {
    }
 * this file be licensed under the Apache-2.0 license or a
            Collections.unmodifiableList(
    public static Settings addRoles(final Settings settings, final Set<DiscoveryNodeRole> roles) {
    }
                        roles.contains(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE) || roles.contains(DiscoveryNodeRole.MASTER_ROLE)
    }
    public static Settings noRoles() {
        builder.putList(
    public static Settings nonRemoteClusterClientNode(final Settings settings) {
        return onlyRole(settings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE);
        return addRoles(settings, Collections.singleton(DiscoveryNodeRole.DATA_ROLE));
                    // TODO: Remove the below filter after removing MASTER_ROLE.
        return clusterManagerNode(Settings.EMPTY);
    public static Settings nonDataNode(final Settings settings) {
        return addRoles(settings, Collections.singleton(DiscoveryNodeRole.INGEST_ROLE));
            )
import java.util.stream.Collectors;
/**
    public static Settings ingestNode() {
    }
                    .collect(Collectors.toList())
    public static Settings nonDataNode() {
                    // It's used to remove both CLUSTER_MANAGER_ROLE and MASTER_ROLE, when requested to remove either.
        );
    }
    }
        return removeRoles(settings, Collections.singleton(DiscoveryNodeRole.INGEST_ROLE));
        return onlyRoles(Settings.EMPTY, roles);
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to
        return dataOnlyNode(Settings.EMPTY);
 * KIND, either express or implied.  See the License for the
    public static Settings ingestNode(final Settings settings) {
    public static Settings nonSearchNode(final Settings settings) {
                    .stream()
    public static Settings removeRoles(final Settings settings, final Set<DiscoveryNodeRole> roles) {
        return addRoles(settings, Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE));
                    .filter(r -> roles.contains(r) == false)
    }
        return removeRoles(settings, Collections.singleton(DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE));
            Collections.unmodifiableList(
    }
        return onlyRole(Settings.EMPTY, role);
        final Settings.Builder builder = Settings.builder().put(settings);
 * this work for additional information regarding copyright
        return nonIngestNode(Settings.EMPTY);
                    .collect(Collectors.toList())
        return onlyRole(settings, DiscoveryNodeRole.INGEST_ROLE);
        return removeRoles(settings, Collections.singleton(DiscoveryNodeRole.SEARCH_ROLE));
        return addRoles(settings, Collections.singleton(DiscoveryNodeRole.WARM_ROLE));
        return nonRemoteClusterClientNode(Settings.EMPTY);
    }
    }
    public static Settings nonClusterManagerNode() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
                NodeRoleSettings.NODE_ROLES_SETTING.get(settings)
 * license agreements. See the NOTICE file distributed with
        return nonWarmNode(Settings.EMPTY);
                Collections.unmodifiableList(roles.stream().map(DiscoveryNodeRole::roleName).collect(Collectors.toList()))
    }
    public static Settings clusterManagerOnlyNode() {
 * ownership. Elasticsearch licenses this file to you under
    public static Settings nonWarmNode() {
    public static Settings removeRoles(final Set<DiscoveryNodeRole> roles) {
    public static Settings clusterManagerNode() {
        return nonDataNode(Settings.EMPTY);
    }
    public static Settings searchOnlyNode(final Settings settings) {
    }
    }
    public static Settings nonIngestNode() {
        return clusterManagerOnlyNode(Settings.EMPTY);
 *     http://www.apache.org/licenses/LICENSE-2.0
    public static Settings clusterManagerNode(final Settings settings) {
        return onlyRole(settings, DiscoveryNodeRole.SEARCH_ROLE);
 *
    }
 */
    public static Settings clusterManagerOnlyNode(final Settings settings) {
                Stream.concat(NodeRoleSettings.NODE_ROLES_SETTING.get(settings).stream(), roles.stream())
        builder.putList(
    }
 */
        return dataNode(Settings.EMPTY);
import java.util.stream.Stream;
    }
    public static Settings nonIngestNode(final Settings settings) {
        return onlyRole(settings, DiscoveryNodeRole.DATA_ROLE);
/*
    }
    public static Settings nonClusterManagerNode(final Settings settings) {
        return builder.build();
        return builder.build();
                            ? r -> !r.isClusterManager()
    }
    public static Settings ingestOnlyNode() {
                            : r -> true
    }
    public static Settings nonRemoteClusterClientNode() {
 * compatible open source license.
public class NodeRoles {
    public static Settings ingestOnlyNode(final Settings settings) {
        return nonClusterManagerNode(Settings.EMPTY);
                    )
                NodeRoleSettings.NODE_ROLES_SETTING.getKey(),
        return addRoles(Settings.EMPTY, roles);
                    .distinct()
 * Unless required by applicable law or agreed to in writing,
    public static Settings noRoles(final Settings settings) {
    }
        return addRoles(settings, Collections.singleton(DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE));
 *
    }
        return onlyRoles(settings, Collections.singleton(role));
    public static Settings onlyRole(final DiscoveryNodeRole role) {
    }
        return Settings.builder()
        return noRoles(Settings.EMPTY);
package org.opensearch.test;
    }
        return remoteClusterClientNode(Settings.EMPTY);
import java.util.Set;
    public static Settings addRoles(final Set<DiscoveryNodeRole> roles) {
    }
            )
    }
        return ingestNode(Settings.EMPTY);
/*
