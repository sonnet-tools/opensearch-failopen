        public Setting<Boolean> legacySetting() {
            // 'cluster_manager' role should not configure legacy setting since deprecated 'master' role is supported till OS 2.x
    @Override
            }
        final boolean isKnownRole,
        this.roleName = Objects.requireNonNull(roleName).toLowerCase(Locale.ROOT);
 * software distributed under the License is distributed on an
            return Setting.boolSetting(
            // copy the setting here so we can mark it private in org.opensearch.node.Node
     * of the discovery node role.
         * @param roleNameAbbreviation the role name abbreviation
    /**
    }
    public DiscoveryNodeRole getCompatibilityRole(Version nodeVersion) {
            return Booleans.isBoolean(settings.get("node.master")) == false;
            );
        public Setting<Boolean> legacySetting() {
    /**
         * @param canContainData       whether or not nodes with the role can contain data
                throw new IllegalArgumentException(
        this.canContainData = canContainData;
 * not use this file except in compliance with the License.
            // return null as dynamic role has no legacy setting
import org.opensearch.Version;
    public void validateRole(List<DiscoveryNodeRole> roles) {};
    };
     */
 *
    }
    }
                "node.remote_cluster_client",
 */
     * @deprecated As of 2.0, because promoting inclusive language. MASTER_ROLE is deprecated.
        DiscoveryNodeRole that = (DiscoveryNodeRole) o;
 * KIND, either express or implied.  See the License for the
        public Setting<Boolean> legacySetting() {
 * license agreements. See the NOTICE file distributed with
        return roleName;
            + roleName
 */
    @Deprecated
    public final int hashCode() {
        }
 *
            if (nodeVersion.onOrAfter(Version.V_2_0_0)) {
            + "roleName='"
        }
 * You may obtain a copy of the License at
import java.util.SortedSet;
            && roleNameAbbreviation.equals(that.roleNameAbbreviation)
    public final boolean isDynamicRole() {
    public final boolean isKnownRole() {
 * Represents a node role.
        return legacySetting() != null && legacySetting().get(settings);
     * @return the role name abbreviation
            + (isKnownRole ? "" : ", isKnownRole=false")
        }
    }
        return isKnownRole;
        public DiscoveryNodeRole getCompatibilityRole(Version nodeVersion) {
    /**
                RemoteClusterService.ENABLE_REMOTE_CLUSTERS,
    protected DiscoveryNodeRole(final String roleName, final String roleNameAbbreviation, final boolean canContainData) {
        this(true, false, roleName, roleNameAbbreviation, canContainData);
    /**
        @Override
            // copy the setting here so we can mark it private in org.opensearch.node.Node
     */
 * Unless required by applicable law or agreed to in writing,
            }
            + canContainData
     * @return the role name
    private final String roleName;
    public static final DiscoveryNodeRole INGEST_ROLE = new DiscoveryNodeRole("ingest", "i") {
        @Override
    private final boolean isKnownRole;
                            Locale.ROOT,
     */
    public final String roleName() {
    }
    public final int compareTo(final DiscoveryNodeRole o) {
import java.util.List;
     * Represents a dynamic role. This can occur if a custom role that not in {@link DiscoveryNodeRole#BUILT_IN_ROLES} added for a node.
            && canContainData == that.canContainData
     * @return true if the node role is{@link #CLUSTER_MANAGER_ROLE} or {@link #MASTER_ROLE}
     */
    static class UnknownRole extends DiscoveryNodeRole {
                return DiscoveryNodeRole.MASTER_ROLE;
import org.opensearch.common.logging.DeprecationLogger;
     */
        @Override
        }
            // since this setting is not registered, it will always return false when testing if the local node has the role
    }
    public boolean isClusterManager() {
 */
     * Represents the role for an ingest node.
    public static final Version REMOTE_CLUSTER_CLIENT_ROLE_VERSION = Version.fromString("7.8.0");
    public static final DiscoveryNodeRole DATA_ROLE = new DiscoveryNodeRole("data", "d", true) {
        if (o == null || getClass() != o.getClass()) return false;
/*
 * Modifications Copyright OpenSearch Contributors. See
    }
        this.isDynamicRole = isDynamicRole;
     * Represents the role for a cluster-manager-eligible node.
    private final String roleNameAbbreviation;
         * @param roleNameAbbreviation the role name abbreviation
    ) {
        @Override
 * this file be licensed under the Apache-2.0 license or a
    /**
        }
     * @return true if a node with this role can contain data, otherwise false
 * GitHub history for details.
    }
 *
        final boolean isDynamicRole,
        return this.equals(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE) || this.equals(DiscoveryNodeRole.MASTER_ROLE);
/**
    @Override
            + '}';
     */
            + ", canContainData="
    /**
            return null;
            // warm role is added in 2.4 so doesn't need to configure legacy setting
import java.util.Objects;
         */
import org.opensearch.common.settings.Settings;
        }
         * Construct a dynamic role with the specified role name and role name abbreviation.
    /**
                Property.NodeScope
        new TreeSet<>(Arrays.asList(DATA_ROLE, INGEST_ROLE, CLUSTER_MANAGER_ROLE, REMOTE_CLUSTER_CLIENT_ROLE, WARM_ROLE))
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
import org.opensearch.transport.RemoteClusterService;
     * they can connect to remote clusters.
        }
    /**
    public abstract Setting<Boolean> legacySetting();
            && isKnownRole == that.isKnownRole
         */
    }
     * An {@link IllegalArgumentException} is expected to be thrown, if the role can't coexist with the other roles.
     */
 */
/*
import org.opensearch.common.settings.Setting.Property;
                            "%s role cannot be combined with any other role on a node.",
            super(false, false, roleName, roleNameAbbreviation, canContainData);
    public static final DiscoveryNodeRole MASTER_ROLE = new DiscoveryNodeRole("master", "m") {
    static class DynamicRole extends DiscoveryNodeRole {
        public Setting<Boolean> legacySetting() {
import java.util.TreeSet;
        /**
    };
package org.opensearch.cluster.node;
     */
    }
 * The OpenSearch Contributors require contributions made to
     *
     * Indicates whether a node with this role can contain data.
     */
        final String roleNameAbbreviation,
    };
    public static final DiscoveryNodeRole WARM_ROLE = new DiscoveryNodeRole("warm", "w", true) {
        this.isKnownRole = isKnownRole;
        @Override
            // As of 2.0, set the default value to 'false', so that MASTER_ROLE isn't added as a default value of NODE_ROLES_SETTING
                        Locale.ROOT,
     * The name of the role.
     * Represents the role for a warm node, which is dedicated to hold warm indices.
            if (roles.contains(DiscoveryNodeRole.MASTER_ROLE)) {
     * The abbreviation of the name of the role. This is used in the cat nodes API to display an abbreviated version of the name of the
        final boolean canContainData
            return Setting.boolSetting("node.ingest", true, Property.Deprecated, Property.NodeScope);
    /**
        }
        return roleNameAbbreviation;
                        "The two roles [%s, %s] can not be assigned together to a node. %s",
            return null;
     * role.
        UnknownRole(final String roleName, final String roleNameAbbreviation, final boolean canContainData) {
     */
                return this;
     */
     */
import org.opensearch.common.annotation.PublicApi;
    );
    /**
        this.roleNameAbbreviation = Objects.requireNonNull(roleNameAbbreviation).toLowerCase(Locale.ROOT);
 * Licensed to Elasticsearch under one or more contributor
    public final String roleNameAbbreviation() {
        @Override
    };
    /**
        public Setting<Boolean> legacySetting() {
        }
            return null;
    @Override
     * When serializing a {@link DiscoveryNodeRole}, the role may not be available to nodes of
    /**
    public static SortedSet<DiscoveryNodeRole> BUILT_IN_ROLES = Collections.unmodifiableSortedSet(
 * this work for additional information regarding copyright
    }
     * @param roles a {@link List} of {@link DiscoveryNodeRole} that a node is going to have
         * Construct an unknown role with the specified role name and role name abbreviation.
    public static final DiscoveryNodeRole SEARCH_ROLE = new DiscoveryNodeRole("search", "s", true) {
import java.util.Arrays;
     * @deprecated As of 2.0, because promoting inclusive language, replaced by {@link #CLUSTER_MANAGER_ROLE}
    public final String toString() {
            // copy the setting here so we can mark it private in org.opensearch.node.Node
            + ", roleNameAbbreviation='"
            + '\''
        }
        public void validateRole(List<DiscoveryNodeRole> roles) {
        "Assigning [master] role in setting [node.roles] is deprecated. To promote inclusive language, please use [cluster_manager] role instead.";
            + (isDynamicRole ? "" : ", isDynamicRole=false")
                    );
     * Represents the role for a cluster-manager-eligible node.
    /**
        return Objects.hash(isKnownRole, isDynamicRole, roleName(), roleNameAbbreviation(), canContainData());
 * @opensearch.api
     * previous versions, where the role had not yet been added. This method allows overriding
        return roleName.compareTo(o.roleName);
 * specific language governing permissions and limitations
                }
    @Deprecated
    /**
/*
         *
 * SPDX-License-Identifier: Apache-2.0
        }
        // As we are supporting dynamic role, should make role name case-insensitive to avoid confusion of role name like "Data"/"DATA"
import org.opensearch.common.settings.Setting;
            // copy the setting here so we can mark it private in org.opensearch.node.Node
     * The version that {@link #REMOTE_CLUSTER_CLIENT_ROLE} is introduced. Nodes before this version do not have that role even
            } else {
                            DiscoveryNodeRole.SEARCH_ROLE.roleName()
    private final boolean isDynamicRole;
        @Override
     * Represents the role for a search node, which is dedicated to host search replicas.
        public Setting<Boolean> legacySetting() {
        @Override
        public void validateRole(List<DiscoveryNodeRole> roles) {
}
            && isDynamicRole == that.isDynamicRole;
                    throw new IllegalArgumentException(
    protected DiscoveryNodeRole(final String roleName, final String roleNameAbbreviation) {
                if (role.equals(DiscoveryNodeRole.SEARCH_ROLE) == false) {
            deprecationLogger.deprecate("node_role_master", MASTER_ROLE_DEPRECATION_MESSAGE);
    }
            for (DiscoveryNodeRole role : roles) {
     */
        return roleName.equals(that.roleName)
    private DiscoveryNodeRole(
    }
        public Setting<Boolean> legacySetting() {
        return "DiscoveryNodeRole{"
    }
            return null;
        public Setting<Boolean> legacySetting() {
        }
 * ownership. Elasticsearch licenses this file to you under
                        DiscoveryNodeRole.CLUSTER_MANAGER_ROLE.roleName(),
     * with "ml" dynamic role.
        /**
    public static final DiscoveryNodeRole REMOTE_CLUSTER_CLIENT_ROLE = new DiscoveryNodeRole("remote_cluster_client", "r") {
     */
            return Setting.boolSetting("node.data", true, Property.Deprecated, Property.NodeScope);
    @Override
        }
import java.util.Collections;
        @Override
        @Override
            // search role is added in 2.4 so doesn't need to configure legacy setting
            super(false, true, roleName, roleNameAbbreviation, canContainData);
     * Some plugin can support extension function with dynamic roles. For example, ML plugin may run machine learning tasks on nodes
 *     http://www.apache.org/licenses/LICENSE-2.0
    private final boolean canContainData;
        }
        if (this == o) return true;
    }
        public Setting<Boolean> legacySetting() {
     */
public abstract class DiscoveryNodeRole implements Comparable<DiscoveryNodeRole> {
            return Setting.boolSetting("node. " + roleName(), false, Setting.Property.NodeScope);
        return canContainData;
    /**
            + '\''
        @Override
                );
        @Override
    };
     */
                    )
         * @param roleName             the role name
    }
            }
     * Check if the role is {@link #CLUSTER_MANAGER_ROLE} or {@link #MASTER_ROLE}.
                        MASTER_ROLE_DEPRECATION_MESSAGE
                        String.format(
     * the role that should be serialized when communicating to versions prior to the introduction
         *
    public final boolean equals(Object o) {
     * Validate the role is compatible with the other roles in the list, when assigning the list of roles to a node.
     *
            return Setting.boolSetting("node.master", false, Property.Deprecated, Property.NodeScope);
    public boolean isEnabledByDefault(final Settings settings) {
 *
            + roleNameAbbreviation
import java.util.Locale;
     *
@PublicApi(since = "1.0.0")
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(DiscoveryNodeRole.class);
     * The built-in node roles.
 * the Apache License, Version 2.0 (the "License"); you may
     * Represents the role for a data node.
    public static final String MASTER_ROLE_DEPRECATION_MESSAGE =
                    String.format(
        @Override
         * @param canContainData       whether or not nodes with the role can contain data
    };
 * under the License.
        final String roleName,
 * compatible open source license.
    /**
     */
                        )
    public static final DiscoveryNodeRole CLUSTER_MANAGER_ROLE = new DiscoveryNodeRole("cluster_manager", "m") {
        @Override
                Property.Deprecated,
        }
    public final boolean canContainData() {
    };
                        DiscoveryNodeRole.MASTER_ROLE.roleName(),
        return this;
     * Represents an unknown role. This can occur if a newer version adds a role that an older version does not know about, or a newer
        DynamicRole(final String roleName, final String roleNameAbbreviation, final boolean canContainData) {
import org.opensearch.common.Booleans;
     * version removes a role that an older version knows about.
         * @param roleName             the role name
        public boolean isEnabledByDefault(final Settings settings) {
        this(roleName, roleNameAbbreviation, false);
    /**
        return isDynamicRole;
        public void validateRole(List<DiscoveryNodeRole> roles) {
    }
            assert false;
     * Whether this role is known by this node, or is an {@link DiscoveryNodeRole.UnknownRole}.
