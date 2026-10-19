import org.opensearch.transport.RemoteClusterService;
        @Override  
        return roleName;
    /**  
        /**
            if (roles.contains(DiscoveryNodeRole.MASTER_ROLE)) {  
     */
        final String roleNameAbbreviation,
                return this;
     * role.
    private final String roleNameAbbreviation;
        DynamicRole(final String roleName, final String roleNameAbbreviation, final boolean canContainData) {
         *  
            // copy the setting here so we can mark it private in org.opensearch.node.Node
package org.opensearch.cluster.node;
        this(true, false, roleName, roleNameAbbreviation, canContainData);  
        @Override
    /**
    /**  
     * previous versions, where the role had not yet been added. This method allows overriding
                if (role.equals(DiscoveryNodeRole.SEARCH_ROLE) == false) {
         * @param canContainData       whether or not nodes with the role can contain data  
import java.util.List;  
    public final int hashCode() {
        }  
     * Indicates whether a node with this role can contain data.
 * The OpenSearch Contributors require contributions made to  
         *  
            + (isDynamicRole ? "" : ", isDynamicRole=false")
                    String.format(
            + ", canContainData="
    }  
        return "DiscoveryNodeRole{"
    /**
    static class UnknownRole extends DiscoveryNodeRole {
            return Setting.boolSetting("node.master", false, Property.Deprecated, Property.NodeScope);
     * @return the role name
    public static final DiscoveryNodeRole INGEST_ROLE = new DiscoveryNodeRole("ingest", "i") {
     * @return true if a node with this role can contain data, otherwise false  
        public void validateRole(List<DiscoveryNodeRole> roles) {
            + '}';  
        new TreeSet<>(Arrays.asList(DATA_ROLE, INGEST_ROLE, CLUSTER_MANAGER_ROLE, REMOTE_CLUSTER_CLIENT_ROLE, WARM_ROLE))
            + ", roleNameAbbreviation='"
        if (this == o) return true;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        DiscoveryNodeRole.MASTER_ROLE.roleName(),
     * Some plugin can support extension function with dynamic roles. For example, ML plugin may run machine learning tasks on nodes
 */  
     */
            // since this setting is not registered, it will always return false when testing if the local node has the role
 * specific language governing permissions and limitations
}
    }
     * The abbreviation of the name of the role. This is used in the cat nodes API to display an abbreviated version of the name of the
        this.isKnownRole = isKnownRole;
        @Override
            // warm role is added in 2.4 so doesn't need to configure legacy setting
    public final String toString() {  
 * @opensearch.api  
            }
    private final boolean isDynamicRole;
    public final int compareTo(final DiscoveryNodeRole o) {
            return null;
    }  
 * ownership. Elasticsearch licenses this file to you under  
        return this;  
     *  
        this.isDynamicRole = isDynamicRole;
        return roleName.compareTo(o.roleName);
         */
     * @return the role name abbreviation
            // return null as dynamic role has no legacy setting
    public static final DiscoveryNodeRole WARM_ROLE = new DiscoveryNodeRole("warm", "w", true) {
 * this file be licensed under the Apache-2.0 license or a
    public static final DiscoveryNodeRole MASTER_ROLE = new DiscoveryNodeRole("master", "m") {
    };  
                RemoteClusterService.ENABLE_REMOTE_CLUSTERS,
            + roleNameAbbreviation  
        public DiscoveryNodeRole getCompatibilityRole(Version nodeVersion) {
            && roleNameAbbreviation.equals(that.roleNameAbbreviation)
    }
    public DiscoveryNodeRole getCompatibilityRole(Version nodeVersion) {
     * @deprecated As of 2.0, because promoting inclusive language, replaced by {@link #CLUSTER_MANAGER_ROLE}
     */
 *
            return Setting.boolSetting("node. " + roleName(), false, Setting.Property.NodeScope);
            }
    }
        @Override  
        }
    public final boolean equals(Object o) {
    };
    public static final DiscoveryNodeRole CLUSTER_MANAGER_ROLE = new DiscoveryNodeRole("cluster_manager", "m") {
        /**
                return DiscoveryNodeRole.MASTER_ROLE;  
        @Override  
     *  
        public boolean isEnabledByDefault(final Settings settings) {
     */
        public void validateRole(List<DiscoveryNodeRole> roles) {
 */
 * Unless required by applicable law or agreed to in writing,
     * The built-in node roles.
     * @param roles a {@link List} of {@link DiscoveryNodeRole} that a node is going to have  
                        MASTER_ROLE_DEPRECATION_MESSAGE
        }
        }
    };
     */
            + (isKnownRole ? "" : ", isKnownRole=false")
    public boolean isClusterManager() {
         * Construct an unknown role with the specified role name and role name abbreviation.
        this.canContainData = canContainData;  
    public static final DiscoveryNodeRole SEARCH_ROLE = new DiscoveryNodeRole("search", "s", true) {
    }
    };
/*  
                        )
        }
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.settings.Settings;
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
    }
        public Setting<Boolean> legacySetting() {
        return roleName.equals(that.roleName)  
     * they can connect to remote clusters.  
         * @param roleName             the role name
    }
        return isKnownRole;
    private final String roleName;
    /**
    }  
                    )
            return Booleans.isBoolean(settings.get("node.master")) == false;  
 * the Apache License, Version 2.0 (the "License"); you may
    /**
        @Override
    @Override
        final boolean canContainData
 */
import java.util.SortedSet;  
    ) {  
            super(false, false, roleName, roleNameAbbreviation, canContainData);  
            assert false;  
                Property.NodeScope
    };  
 * compatible open source license.
            } else {
            return null;  
            // copy the setting here so we can mark it private in org.opensearch.node.Node
 * license agreements. See the NOTICE file distributed with
            return Setting.boolSetting(  
        @Override  
        this.roleName = Objects.requireNonNull(roleName).toLowerCase(Locale.ROOT);
@PublicApi(since = "1.0.0")
        public Setting<Boolean> legacySetting() {
            && isDynamicRole == that.isDynamicRole;
     * An {@link IllegalArgumentException} is expected to be thrown, if the role can't coexist with the other roles.
     */  
     * Represents an unknown role. This can occur if a newer version adds a role that an older version does not know about, or a newer
/*
        @Override
        public void validateRole(List<DiscoveryNodeRole> roles) {
 * software distributed under the License is distributed on an
        @Override
                );  
    /**
public abstract class DiscoveryNodeRole implements Comparable<DiscoveryNodeRole> {  
                    throw new IllegalArgumentException(
    protected DiscoveryNodeRole(final String roleName, final String roleNameAbbreviation, final boolean canContainData) {
            if (nodeVersion.onOrAfter(Version.V_2_0_0)) {  
         * @param roleNameAbbreviation the role name abbreviation
    /**
 *     http://www.apache.org/licenses/LICENSE-2.0
     */  
import java.util.Objects;
import java.util.TreeSet;
    protected DiscoveryNodeRole(final String roleName, final String roleNameAbbreviation) {
    /**
     * Represents the role for a cluster-manager-eligible node.  
     * @return true if the node role is{@link #CLUSTER_MANAGER_ROLE} or {@link #MASTER_ROLE}
                        DiscoveryNodeRole.CLUSTER_MANAGER_ROLE.roleName(),  
     */  
 *
            // 'cluster_manager' role should not configure legacy setting since deprecated 'master' role is supported till OS 2.x  
     */
    }
         * @param canContainData       whether or not nodes with the role can contain data  
        UnknownRole(final String roleName, final String roleNameAbbreviation, final boolean canContainData) {
 * You may obtain a copy of the License at  
            // As of 2.0, set the default value to 'false', so that MASTER_ROLE isn't added as a default value of NODE_ROLES_SETTING  
                            "%s role cannot be combined with any other role on a node.",
            );
     * of the discovery node role.  
     */  
     * @deprecated As of 2.0, because promoting inclusive language. MASTER_ROLE is deprecated.
                throw new IllegalArgumentException(
     * The version that {@link #REMOTE_CLUSTER_CLIENT_ROLE} is introduced. Nodes before this version do not have that role even
                        Locale.ROOT,  
    }
import java.util.Collections;
            for (DiscoveryNodeRole role : roles) {  
            + "roleName='"
     * version removes a role that an older version knows about.  
     */
    public final boolean isDynamicRole() {
        public Setting<Boolean> legacySetting() {
        }
     */
        }
        return legacySetting() != null && legacySetting().get(settings);
     * Represents a dynamic role. This can occur if a custom role that not in {@link DiscoveryNodeRole#BUILT_IN_ROLES} added for a node.
import java.util.Arrays;
            deprecationLogger.deprecate("node_role_master", MASTER_ROLE_DEPRECATION_MESSAGE);  
    /**
    public static final DiscoveryNodeRole DATA_ROLE = new DiscoveryNodeRole("data", "d", true) {  
     */
        final String roleName,  
                Property.Deprecated,  
    public static final DiscoveryNodeRole REMOTE_CLUSTER_CLIENT_ROLE = new DiscoveryNodeRole("remote_cluster_client", "r") {
         * Construct a dynamic role with the specified role name and role name abbreviation.
     * Check if the role is {@link #CLUSTER_MANAGER_ROLE} or {@link #MASTER_ROLE}.  
 *  
            return null;  
    /**
import org.opensearch.common.annotation.PublicApi;  
 * KIND, either express or implied.  See the License for the
                    );
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(DiscoveryNodeRole.class);
        @Override  
        public Setting<Boolean> legacySetting() {
     * the role that should be serialized when communicating to versions prior to the introduction
 * Represents a node role.
        @Override  
        }
    };  
        return isDynamicRole;  
    public abstract Setting<Boolean> legacySetting();  
                            Locale.ROOT,
    @Deprecated
 * SPDX-License-Identifier: Apache-2.0
    };
    public final String roleNameAbbreviation() {  
    public void validateRole(List<DiscoveryNodeRole> roles) {};
    private DiscoveryNodeRole(  
    private final boolean isKnownRole;  
     * Represents the role for a cluster-manager-eligible node.  
        public Setting<Boolean> legacySetting() {
    }
                            DiscoveryNodeRole.SEARCH_ROLE.roleName()  
        DiscoveryNodeRole that = (DiscoveryNodeRole) o;
    public static SortedSet<DiscoveryNodeRole> BUILT_IN_ROLES = Collections.unmodifiableSortedSet(  
     *
        }
    /**  
        return this.equals(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE) || this.equals(DiscoveryNodeRole.MASTER_ROLE);  
        public Setting<Boolean> legacySetting() {
            + roleName  
                        String.format(  
    static class DynamicRole extends DiscoveryNodeRole {
        final boolean isKnownRole,
     * Validate the role is compatible with the other roles in the list, when assigning the list of roles to a node.
 */  
    @Deprecated  
     * When serializing a {@link DiscoveryNodeRole}, the role may not be available to nodes of  
            return Setting.boolSetting("node.ingest", true, Property.Deprecated, Property.NodeScope);  
     * The name of the role.
    public final boolean isKnownRole() {
        }
 *
            return null;
        }
     * with "ml" dynamic role.  
            super(false, true, roleName, roleNameAbbreviation, canContainData);  
            + '\''
    public static final Version REMOTE_CLUSTER_CLIENT_ROLE_VERSION = Version.fromString("7.8.0");
    }
    public final boolean canContainData() {
    }
        "Assigning [master] role in setting [node.roles] is deprecated. To promote inclusive language, please use [cluster_manager] role instead.";
    public boolean isEnabledByDefault(final Settings settings) {  
    @Override
            // copy the setting here so we can mark it private in org.opensearch.node.Node
    @Override
     * Whether this role is known by this node, or is an {@link DiscoveryNodeRole.UnknownRole}.
            // search role is added in 2.4 so doesn't need to configure legacy setting  
        }
        @Override
import org.opensearch.Version;
        this.roleNameAbbreviation = Objects.requireNonNull(roleNameAbbreviation).toLowerCase(Locale.ROOT);
        }
import org.opensearch.common.settings.Setting;
 * Modifications Copyright OpenSearch Contributors. See
     * Represents the role for a data node.
        public Setting<Boolean> legacySetting() {
     */
        return Objects.hash(isKnownRole, isDynamicRole, roleName(), roleNameAbbreviation(), canContainData());  
        @Override
    public final String roleName() {  
            && canContainData == that.canContainData
                "node.remote_cluster_client",
         * @param roleNameAbbreviation the role name abbreviation
            + canContainData  
                        "The two roles [%s, %s] can not be assigned together to a node. %s",
            + '\''
     * Represents the role for a warm node, which is dedicated to hold warm indices.
    public static final String MASTER_ROLE_DEPRECATION_MESSAGE =  
         * @param roleName             the role name
        }
        @Override
        if (o == null || getClass() != o.getClass()) return false;
    @Override  
        return canContainData;  
import java.util.Locale;
    }
    );
import org.opensearch.common.Booleans;
            }
import org.opensearch.common.settings.Setting.Property;  
                }  
/*  
    /**  
     * Represents the role for a search node, which is dedicated to host search replicas.  
    private final boolean canContainData;
            return Setting.boolSetting("node.data", true, Property.Deprecated, Property.NodeScope);
    /**
     */
    }
    /**  
 * GitHub history for details.
    /**
     * Represents the role for an ingest node.
        final boolean isDynamicRole,
         */
     */
            // copy the setting here so we can mark it private in org.opensearch.node.Node
        public Setting<Boolean> legacySetting() {
        this(roleName, roleNameAbbreviation, false);
        }  
     */
    }  
/**  
        public Setting<Boolean> legacySetting() {  
    /**  
import org.opensearch.common.logging.DeprecationLogger;
        // As we are supporting dynamic role, should make role name case-insensitive to avoid confusion of role name like "Data"/"DATA"  
        }
 * under the License.  
            && isKnownRole == that.isKnownRole  
        return roleNameAbbreviation;
