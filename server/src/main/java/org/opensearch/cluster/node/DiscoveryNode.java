    /**
     */
            node.getRoles(),
    }
     * Returns whether the node is dedicated to host search replicas.
import org.opensearch.node.remotestore.RemoteStoreNodeAttribute;
    public boolean isRemoteSegmentStoreNode() {
}
        this.attributes = Collections.unmodifiableMap(attributes);
     * The name of the node.
     * and updated.
            return Collections.unmodifiableSet(new HashSet<>(NODE_ROLES_SETTING.get(settings)));
        assert roleNameToPossibleRoles.size() == roleNameAbbreviationToPossibleRoles.size() : "roles by name ["
            out.writeString(compatibleRole.roleName());
 */
        Set<DiscoveryNodeRole> roles,
        }
import java.util.HashMap;
     * Returns whether the node is a remote store node.
    }
     * <p>
            node.getHostAddress(),
        } else {
        this.nodeId = in.readString().intern();
        }
            this.streamAddress = in.readOptionalWriteable(TransportAddress::new);
    public void writeVerifiableTo(BufferedChecksumStreamOutput out) throws IOException {
            address.getAddress(),
        }
    /**
        }
     * the node might not be able to communicate with the remote node. After initial handshakes node versions will be discovered
        this.nodeName = in.readString().intern();
     * The unique id of the node.
    public String getName() {
    }
        // This is done so that this class can be used efficiently as a key in a map
     */
        return roles;
    public String getId() {
    }
                }
            + roleNameAbbreviationToPossibleRoles
        this(id, address, Collections.emptyMap(), DiscoveryNodeRole.BUILT_IN_ROLES, version);
    public void writeToWithAttribute(StreamOutput out) throws IOException {
            final DiscoveryNodeRole compatibleRole = role.getCompatibilityRole(out.getVersion());
    @Override
            UUIDs.randomBase64UUID(),
     *
        }
                    role.legacySetting().get(settings)
    }
        return this.hostName;
    public boolean isDataNode() {
 */
        return roles.contains(DiscoveryNodeRole.SEARCH_ROLE);
    }
    public String toString() {
            version
        Set<DiscoveryNodeRole> roles = getRolesFromSettings(settings);
        Version version
    private void writeRolesAndVersion(StreamOutput out) throws IOException {
            if (role == null) {
     * @param attributes       node attributes
            node.getVersion()
        TransportAddress address,
        TransportAddress address,
     */
    }
        } else {
        String nodeName,
    }
            address.address().getHostString(),
@PublicApi(since = "1.0.0")
            final String roleNameAbbreviation = in.readString();
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
     * Creates a new {@link DiscoveryNode}
     * @param attributes       node attributes
import java.util.Collections;
            out.writeVInt(attributes.size());
        sb.append('{').append(ephemeralId).append('}');
    /**
        if (includeAllAttributes) {
        return isClusterStateRepoConfigured(this.getAttributes()) && RemoteStoreNodeAttribute.isSegmentRepoConfigured(this.getAttributes());
     * Returns whether the node stores translog in a remote store. Durability decisions (replication mode, global
    private final TransportAddress address;
    }
     */
        return Collections.unmodifiableMap(rolesWithSearch.collect(Collectors.toMap(DiscoveryNodeRole::roleName, Function.identity())));
    /**
     * @return true if the node contains warm role, false otherwise
     * @param in the stream
    /**
     * Returns a boolean that tells whether this an ingest node or not
        return localStorageEnable;
        roleMap = Collections.unmodifiableMap(modifiableRoleMap);
     *
        writeNodeDetails(out);
               // from logging to reduce noise.
        }
                    "can not explicitly configure node roles and use legacy role setting [%s]=[%s]",
     * Load the deprecated {@link DiscoveryNodeRole#MASTER_ROLE}.
        this(
        }
        this.address = address;
        return hasRole(settings, DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE);
    /**
    public boolean isClusterManagerNode() {
            + "], roles by name abbreviation ["
    /** extract node roles from the given settings */
            streamAddress,
            streamAddress = null;
    }
        return roles.contains(DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE);
     * </p>
        String nodeId,
    @Override
        return streamAddress;
        }
     * The unique ephemeral id of the node. Ephemeral ids are meant to be attached the life span
     * @return true if the node contains remote cluster state node attribute and remote routing table node attribute
        }
     * <b>Note:</b> if the version of the node is unknown {@link Version#minimumCompatibilityVersion()} should be used for the current
        if (out.getVersion().onOrAfter(Version.V_2_17_0)) {
        }
        }
     * @param hostAddress      the nodes host address
        if (nodeName != null) {
        writeNodeDetails(out);
    }
    public static Set<DiscoveryNodeRole> getPossibleRoles() {
     * @param id               the nodes unique (persistent) node id. This constructor will auto generate a random ephemeral id.
    public DiscoveryNode(final String id, TransportAddress address, Version version) {
            } else {
     * @return true if the node contains remote store node attributes, false otherwise
     * Creates a new {@link DiscoveryNode} by reading from the stream provided as argument
    /**
    }
     */
                    + roleName
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.common.io.stream.VerifiableWriteable;
    public String getHostAddress() {
    }
        } else {
        final Set<DiscoveryNodeRole> roles = new HashSet<>(rolesSize);
            return role.isEnabledByDefault(settings);
    public DiscoveryNode(
            // TODO: make this a proper setting validation logic, requiring multi-settings validation
    }
            roleNameToPossibleRoles.values()
    }
     * @param attributes       node attributes
            out.writeString(compatibleRole.roleNameAbbreviation());
            return success;
        return this.version;
    public boolean isWarmNode() {
    public DiscoveryNode(
            sb.append('{');
 *
/*
    }
        // collect the abbreviation names into a map to ensure that there are not any duplicate abbreviations
                        return false;
    ) {
     * @param version          the version of the node
    }
import org.opensearch.core.common.io.stream.StreamOutput;
     * not all roles may be available from a static/initializing context such as a {@link Setting}
     * Returns whether settings required for remote cluster state publication is configured
    public static DiscoveryNode createLocal(Settings settings, TransportAddress publishAddress, String nodeId) {
     */
        } else {
     * the node might not be able to communicate with the remote node. After initial handshakes node versions will be discovered
        String hostAddress,
        for (final DiscoveryNodeRole role : roles) {
                    + role.roleNameAbbreviation()
    }
        this.roles = Collections.unmodifiableSortedSet(new TreeSet<>(roles));
     * @param version          the version of the node
    }
    }
            out.writeVInt(0);
        } else {
     * Returns whether or not the node can be a remote cluster client.
     * Can this node become cluster-manager or not.
     * Due to the way that plugins may not be available when settings are being initialized,
 * KIND, either express or implied.  See the License for the
        builder.endObject();
        );
 * A discovery node represents a node that is part of the cluster.
        final Map<String, DiscoveryNodeRole> roleNameAbbreviationToPossibleRoles = Collections.unmodifiableMap(
    public boolean isRemoteClusterClient() {
                    + "] does not match role ["
        Map<String, String> attributes,
                .collect(Collectors.toMap(DiscoveryNodeRole::roleNameAbbreviation, Function.identity()))
            roles.stream().map(DiscoveryNodeRole::roleNameAbbreviation).sorted().forEach(sb::append);
    @Override
     * @param ephemeralId      the nodes unique ephemeral id
        sb.append('{').append(address).append('}');
    }
            throw new IllegalArgumentException("storage can not be disabled for cluster-manager and data nodes");
                success &= attrs.containsKey(role.roleName()) == false;
 *
        this.address = new TransportAddress(in);
        TransportAddress address,
            attributes,
    }
     * @throws IOException if there is an error while reading from the stream
     *
            node.getEphemeralId(),
            boolean success = true;
    /**
            final boolean canContainData = in.readBoolean();
    public Map<String, String> getAttributes() {
                    roles.add(new DiscoveryNodeRole.UnknownRole(roleName, roleNameAbbreviation, canContainData));
     * are maintained during the life span of a node process, we can (and are) using the ephemeralId in
            this.nodeName = nodeName.intern();
    /**
    static final String COORDINATING_ONLY = "coordinating_only";
    public boolean equals(Object o) {
     * The node attributes.
import java.util.stream.Collectors;
     */
     * checkpoint computation, retention leases and peer recovery) must be based on this rather than on
     * will be read from the data folder and will remain the same across restarts). Since all node attributes and addresses
            sb.append('{').append(streamAddress).append('}');
        );
    /** Creates a DiscoveryNode representing the local node. */
        // verify that no node roles are being provided as attributes
        } else {
        return hasRole(settings, DiscoveryNodeRole.MASTER_ROLE) || hasRole(settings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE);
    /**
        if (in.getVersion().onOrAfter(Version.V_3_2_0)) {
 * the Apache License, Version 2.0 (the "License"); you may
        String hostAddress,
     * {@link DiscoveryNode#equals(Object)}.
     */
                for (String prefix : REMOTE_STORE_NODE_ATTRIBUTE_KEY_PREFIX) {
    }
    /**
        // in our system will have the same id but be different
     * <b>Note:</b> if the version of the node is unknown {@link Version#minimumCompatibilityVersion()} should be used for the current
        DiscoveryNode that = (DiscoveryNode) o;
        Version version
    public DiscoveryNode(
    private final String nodeName;
                assert roleName.equals(role.roleName()) : "role name [" + roleName + "] does not match role [" + role.roleName() + "]";
        }
        int rolesSize = in.readVInt();
    @Override
    private void writeNodeDetails(StreamOutput out) throws IOException {
                .stream()
    }
        this.hostName = in.readString().intern();
import java.util.Locale;
        this.version = in.readVersion();
            return settings.getAsList("node.roles").contains(role.roleName());
     * @param id               the nodes unique (persistent) node id. This constructor will auto generate a random ephemeral id.
    private final String hostName;
     * @param roles            node roles
    public static boolean isDataNode(final Settings settings) {
        return sb.toString();
        }
    /**
        this.hostName = hostName.intern();
                    + "]";
        writeRolesAndVersion(out);
            return true;
        this.nodeId = nodeId.intern();
import java.util.TreeSet;
    private final SortedSet<DiscoveryNodeRole> roles;
    public static Set<String> getPossibleRoleNames() {
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.isRoutingTableRepoConfigured;
                    Locale.ROOT,
     */
        out.writeString(hostName);
            this.version = version;
        String nodeName,
     * @param roles            node roles
                    if (entry.getKey().startsWith(prefix)) {
    }
     * The address that the node can be communicated with.
    }
     */
            out.writeOptionalWriteable(streamAddress);
    ) {
     * version. it corresponds to the minimum version this opensearch version can communicate with. If a higher version is used
            if (role.legacySetting() != null && role.legacySetting().exists(settings)) {
    /**
     * @param nodeId           the nodes unique persistent id
     * </p>
                final String message = String.format(
            writeToUtil(out, true);
    public static boolean isRemoteClusterClient(final Settings settings) {
import java.util.function.Predicate;
                );
     * the node might not be able to communicate with the remote node. After initial handshakes node versions will be discovered
                assert roleNameAbbreviation.equals(role.roleNameAbbreviation()) : "role name abbreviation ["
    public boolean isIngestNode() {
     * <p>
        this.hostAddress = in.readString().intern();
     * @param nodeName         the nodes name
        );
        boolean localStorageEnable = Node.NODE_LOCAL_STORAGE_SETTING.get(settings);
        builder.startObject(getId());
 * specific language governing permissions and limitations
        String ephemeralId,
        out.writeMap(attributes, StreamOutput::writeString, StreamOutput::writeString);
        this.roles = Collections.unmodifiableSortedSet(new TreeSet<>(roles));
    }
     * Returns a set of all the roles that the node has. The roles are returned in sorted order by the role name.
import org.opensearch.core.common.io.stream.StreamInput;
        }
    /**
     * the node might not be able to communicate with the remote node. After initial handshakes node versions will be discovered
import org.opensearch.core.common.io.stream.BufferedChecksumStreamOutput;
            node.getHostName(),
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
     * </p>
        address.writeTo(out);
        if (streamAddress != null) {
            builder.field("stream_transport_address", getStreamAddress().toString());
        return ephemeralId;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    /**
     *
        return ephemeralId.equals(that.ephemeralId);
     * Returns whether the node is a remote segment store node.
    private static Map<String, DiscoveryNodeRole> rolesToMap(final Stream<DiscoveryNodeRole> roles) {
        String nodeId,
        Version version
import org.opensearch.node.Node;
    public Version getVersion() {
            sb.append('}');
        return isClusterStateRepoConfigured(this.getAttributes()) && isRoutingTableRepoConfigured(this.getAttributes());
    /**
        Map<String, String> attributes,
     */
        if (roles.isEmpty() == false) {
     * Returns whether the node is dedicated to hold warm indices.
    private final String ephemeralId;
     * {@link #isRemoteStoreNode()}, since a node running in {@code segments_only} mode keeps its translog locally and
            sb.append('{').append(nodeName).append('}');
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
    public DiscoveryNode(
    }
        this.ephemeralId = ephemeralId.intern();
     * <p>
        String nodeId,
    public static boolean isIngestNode(Settings settings) {
        return roles.contains(DiscoveryNodeRole.MASTER_ROLE) || roles.contains(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE);
     * <b>Note:</b> if the version of the node is unknown {@link Version#minimumCompatibilityVersion()} should be used for the current
                    }
    /**
     * version. it corresponds to the minimum version this opensearch version can communicate with. If a higher version is used
                    roles.add(new DiscoveryNodeRole.DynamicRole(roleName, roleNameAbbreviation, canContainData));
            writeToUtil(out, false);
                }
        return roles.contains(DiscoveryNodeRole.INGEST_ROLE);
            return role.legacySetting().get(settings);
        }
        String hostName,
    public boolean isRemoteTranslogStoreNode() {
     *
    public boolean isRemoteStoreNode() {
import java.util.HashSet;
            for (Map.Entry<String, String> entry : attributes.entrySet()) {
        if (localStorageEnable == false && (isDataNode(settings) || isClusterManagerNode(settings))) {
                return true;
        // As we are supporting dynamic role, should make role name case-insensitive to avoid confusion of role name like "Data"/"DATA"
    }
            this.version = Version.CURRENT;
    public TransportAddress getStreamAddress() {
    private final String hostAddress;
        String nodeName,
     *
        TransportAddress streamAddress,
        roleMap = roleNameToPossibleRoles;
                assert success : role.roleName();
        this("", id, address, attributes, roles, version);
     * @return true if the node can be a remote cluster client, false otherwise
     */
            }
        }
        } else {
     * of a node process. When ever a node is restarted, it's ephemeral id is required to change (while it's {@link #getId()}
    @Override
    ) {
        assert additionalRoles.stream().allMatch(r -> r.legacySetting() == null || r.legacySetting().isDeprecated()) : additionalRoles;
            builder.field(entry.getKey(), entry.getValue());
     *
     */
     * version. it corresponds to the minimum version this opensearch version can communicate with. If a higher version is used
    /**
        builder.endObject();
 * @opensearch.api
            final DiscoveryNodeRole role = roleMap.get(roleName);
    public TransportAddress getAddress() {
     */
        return address;
     * @param version          the version of the node
     */
    public int hashCode() {
    public boolean isSearchNode() {
        };
        int size = in.readVInt();
    private static void validateLegacySettings(final Settings settings, final Map<String, DiscoveryNodeRole> roleMap) {
    private final String nodeId;
     */
    }
            out.writeBoolean(compatibleRole.canContainData());
import java.util.Objects;
        out.writeString(ephemeralId);
     */
            return roleMap.get(lowerCasedRoleName);
    }
    public Set<DiscoveryNodeRole> getRoles() {
 * under the License.
            + "]";
    }
        }
        final Map<String, DiscoveryNodeRole> roleNameToPossibleRoles = rolesToMap(
        return roles.contains(DiscoveryNodeRole.WARM_ROLE);
    public DiscoveryNode(StreamInput in) throws IOException {
 * Licensed to Elasticsearch under one or more contributor
        if (this == o) {
            return roleMap.values().stream().filter(s -> s.isEnabledByDefault(settings)).collect(Collectors.toSet());
        out.writeVInt(roles.size());
     * Creates a new {@link DiscoveryNode}
    }
        return getRolesFromSettings(settings).stream().anyMatch(DiscoveryNodeRole::canContainData);
            }
import org.opensearch.common.settings.Settings;
        out.writeVersion(version);
    public static boolean isDedicatedWarmNode(Settings settings) {
        out.writeString(hostAddress);
        TransportAddress address,
 * Unless required by applicable law or agreed to in writing,
        Set<DiscoveryNodeRole> roles,
     * @return the sorted set of roles
        assert predicate.test(attributes) : attributes;
            node.getId(),
    }
            address,
        Predicate<Map<String, String>> predicate = (attrs) -> {
        builder.field("name", getName());
     * @param nodeId           the nodes unique persistent id. An ephemeral id will be auto generated.
    }
        return RemoteStoreNodeAttribute.isSegmentRepoConfigured(this.getAttributes());
                if (in.getVersion().onOrAfter(Version.V_2_1_0)) {
 * The OpenSearch Contributors require contributions made to
import static org.opensearch.node.NodeRoleSettings.NODE_ROLES_SETTING;
     */
    public static boolean isWarmNode(Settings settings) {
     * Creates a new {@link DiscoveryNode}
     */
    public static boolean hasRole(final Settings settings, final DiscoveryNodeRole role) {
        return new DiscoveryNodeRole.DynamicRole(lowerCasedRoleName, lowerCasedRoleName, false);
        this(nodeName, nodeId, ephemeralId, hostName, hostAddress, address, null, attributes, roles, version);
        );
        return this.attributes;
     * @return true if the node contains remote translog store node attributes, false otherwise
    }
     * @param address          the nodes transport address
    public static void setAdditionalRoles(final Set<DiscoveryNodeRole> additionalRoles) {
        this.ephemeralId = in.readString().intern();
     * default value function. In that case, be warned that this may not include all plugin roles.
     * @param nodeName         the nodes name
     * @return true if the node contains remote segment store node attributes, false otherwise
import java.util.SortedSet;
        if (out.getVersion().onOrAfter(Version.V_3_2_0)) {
        if (roleMap.containsKey(lowerCasedRoleName)) {
     * Should this node hold data (shards) or not.
     * @param address          the nodes transport address
    }
     * <b>Note:</b> if the version of the node is unknown {@link Version#minimumCompatibilityVersion()} should be used for the current
    }
        String ephemeralId,
    }
        Map<String, String> attributes,
 */
        return hasRole(settings, DiscoveryNodeRole.INGEST_ROLE);
    public void writeToUtil(StreamOutput out, boolean includeAllAttributes) throws IOException {
            }
        return Collections.unmodifiableSet(new HashSet<>(roleMap.values()));
    public static boolean nodeRequiresLocalStorage(Settings settings) {
        this.hostAddress = hostAddress.intern();
        writeToUtil(out, true);
     * Master role is not added into BUILT_IN_ROLES, because {@link #setAdditionalRoles(Set)} check role name abbreviation duplication,
 * software distributed under the License is distributed on an
    }
            nodeName,
     * therefore still relies on node-to-node replication.
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
                out.writeString(entry.getValue());
import org.opensearch.common.annotation.PublicApi;
        modifiableRoleMap.put(DiscoveryNodeRole.MASTER_ROLE.roleName(), DiscoveryNodeRole.MASTER_ROLE);
    }
        }
        out.writeString(nodeName);
        Map<String, String> attributes = Node.NODE_ATTRIBUTES.getAsMap(settings);
            final String roleName = in.readString();
    /**
    }
    ) {
        return new DiscoveryNode(Node.NODE_NAME_SETTING.get(settings), nodeId, publishAddress, attributes, roles, Version.CURRENT);
        sb.append('{').append(nodeId).append('}');
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
            for (final DiscoveryNodeRole role : DiscoveryNode.roleMap.values()) {
        Set<DiscoveryNodeRole> roles,
        for (final DiscoveryNodeRole role : roleMap.values()) {
                    role.legacySetting().getKey(),
        return this.hostAddress;
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.isClusterStateRepoConfigured;
        return builder;
 * GitHub history for details.
/*
    public String getEphemeralId() {
import org.opensearch.core.common.transport.TransportAddress;
    private final Version version;
            roles,
     * <p>
    @Override
import org.opensearch.core.xcontent.XContentBuilder;
    }
        final Map<String, DiscoveryNodeRole> modifiableRoleMap = new HashMap<>(roleMap);
                roles.add(role);
        this.attributes = new HashMap<>(size);
        Set<DiscoveryNodeRole> roles,
                out.writeString(entry.getKey());
     * @param roles            node roles
     * Creates a new {@link DiscoveryNode}.
 * not use this file except in compliance with the License.
import java.io.IOException;
         * initialization prematurely because that will bake the default roles before plugins have had a chance to register them. Therefore,
            nodeId,
/*
        writeRolesAndVersion(out);
import java.util.Map;
        this.streamAddress = streamAddress;
            this.nodeName = "";
 *
        String id,
     * and updated.
    }
        this(
    private final Map<String, String> attributes;
 * ownership. Elasticsearch licenses this file to you under
package org.opensearch.cluster.node;
        StringBuilder sb = new StringBuilder();
        if (nodeName.length() > 0) {
        for (int i = 0; i < size; i++) {
     */
        return hasRole(settings, DiscoveryNodeRole.WARM_ROLE);
     * @return true if the node contains a search role, false otherwise
     * version. it corresponds to the minimum version this opensearch version can communicate with. If a higher version is used
        return nodeId;
            + roleNameToPossibleRoles
            node.getName(),
         */
            return false;
        Map<String, String> attributes,
     * and updated.
            validateLegacySettings(settings, roleMap);
     *
        if (NODE_ROLES_SETTING.exists(settings)) {
        /*
import java.util.Set;
 *
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
    /**
                throw new IllegalArgumentException(message);
         * to avoid initializing this setting prematurely, we avoid using the actual node roles setting instance here.
        Version version
    public static DiscoveryNodeRole getRoleFromRoleName(final String roleName) {
    }
     */
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_NODE_ATTRIBUTE_KEY_PREFIX;
    }
        return getRolesFromSettings(settings).stream().allMatch(DiscoveryNodeRole.WARM_ROLE::equals);
            this.attributes.put(in.readString(), in.readString());
     * If a node does not have any specific role, the returned set is empty, which means that the node is a coordinating-only node.
import org.opensearch.Version;
    private final TransportAddress streamAddress;
import org.opensearch.common.UUIDs;
    /**
        return roles.stream().anyMatch(DiscoveryNodeRole::canContainData);
        String hostName,
 * You may obtain a copy of the License at
    }
        if (o == null || getClass() != o.getClass()) {
        }
        out.writeString(nodeId);
     *
        return this.nodeName;
    /**
    public static boolean isClusterManagerNode(Settings settings) {
        return roleMap.keySet();
                } else {
    private static Map<String, DiscoveryNodeRole> roleMap = rolesToMap(DiscoveryNodeRole.BUILT_IN_ROLES.stream());
            node.getAddress(),
        return ephemeralId.hashCode();
     * <p>
        // we only need to hash the id because it's highly unlikely that two nodes
         * This method can be called before the o.e.n.NodeRoleSettings.NODE_ROLES_SETTING is initialized. We do not want to trigger
    public boolean isRemoteStatePublicationEnabled() {
            Stream.concat(DiscoveryNodeRole.BUILT_IN_ROLES.stream(), additionalRoles.stream())
        if (streamAddress != null) {
    }
import org.opensearch.common.settings.Setting;
        builder.startObject("attributes");
     *
     * @param version          the version of the node
            sb.append(attributes.entrySet().stream().filter(entry -> {
     * @param address          the nodes transport address
        } else if (role.legacySetting() != null && settings.hasValue(role.legacySetting().getKey())) {
    }
        }
 * compatible open source license.
            }
    public DiscoveryNode(DiscoveryNode node, TransportAddress streamAddress) {
    /**
            node.getAttributes(),
 */
    public static Set<DiscoveryNodeRole> getRolesFromSettings(final Settings settings) {
        }
import org.opensearch.core.xcontent.ToXContentFragment;
     */
     * and CLUSTER_MANAGER_ROLE has the same abbreviation name with MASTER_ROLE.
     * @param address          the nodes transport address
    public String getHostName() {
    }
        for (int i = 0; i < rolesSize; i++) {
     */
import java.util.stream.Stream;
        if (settings.hasValue("node.roles")) {
     * </p>
        }
        builder.field("ephemeral_id", getEphemeralId());
        builder.field("transport_address", getAddress().toString());
    }
        if (version == null) {
        sb.append('{').append(hostName).append('}');
        Stream<DiscoveryNodeRole> rolesWithSearch = Stream.concat(roles, Stream.of(DiscoveryNodeRole.SEARCH_ROLE));
     * and updated.
    }
            }) // filter remote_store attributes
 * SPDX-License-Identifier: Apache-2.0
    public static void setDeprecatedMasterRole() {
import java.util.function.Function;
    }
        return RemoteStoreNodeAttribute.isTranslogRepoConfigured(this.getAttributes());
public class DiscoveryNode implements VerifiableWriteable, ToXContentFragment {
        if (!attributes.isEmpty()) {
        String lowerCasedRoleName = Objects.requireNonNull(roleName).toLowerCase(Locale.ROOT);
/**
