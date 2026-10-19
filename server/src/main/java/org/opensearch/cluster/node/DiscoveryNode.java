import java.util.stream.Stream;
    ) {
    @Override
 * specific language governing permissions and limitations
    public static boolean isDataNode(final Settings settings) {
    public Map<String, String> getAttributes() {  
    }
import org.opensearch.core.common.transport.TransportAddress;
    public DiscoveryNode(DiscoveryNode node, TransportAddress streamAddress) {
        return RemoteStoreNodeAttribute.isSegmentRepoConfigured(this.getAttributes());  
            final boolean canContainData = in.readBoolean();
     * @param attributes       node attributes  
    }  
        out.writeString(hostName);
 * license agreements. See the NOTICE file distributed with
    }
            final String roleName = in.readString();  
        String nodeId,
    /**
        if (!attributes.isEmpty()) {
        sb.append('{').append(nodeId).append('}');
import java.util.function.Function;
    }
                throw new IllegalArgumentException(message);
     *  
     * Returns whether the node is a remote store node.
        Set<DiscoveryNodeRole> roles = getRolesFromSettings(settings);
    static final String COORDINATING_ONLY = "coordinating_only";
            final DiscoveryNodeRole role = roleMap.get(roleName);  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
     */
import static org.opensearch.node.NodeRoleSettings.NODE_ROLES_SETTING;
        out.writeMap(attributes, StreamOutput::writeString, StreamOutput::writeString);  
        boolean localStorageEnable = Node.NODE_LOCAL_STORAGE_SETTING.get(settings);
     * The node attributes.
     * <b>Note:</b> if the version of the node is unknown {@link Version#minimumCompatibilityVersion()} should be used for the current
 * not use this file except in compliance with the License.
    public DiscoveryNode(StreamInput in) throws IOException {
    public static Set<DiscoveryNodeRole> getRolesFromSettings(final Settings settings) {
 * under the License.  
                    + "] does not match role ["
        final Map<String, DiscoveryNodeRole> roleNameAbbreviationToPossibleRoles = Collections.unmodifiableMap(  
    public String getName() {
    /**
    }
     * </p>  
     *
        this(  
    }
     * @param id               the nodes unique (persistent) node id. This constructor will auto generate a random ephemeral id.
        String hostName,  
    public String getHostAddress() {  
            throw new IllegalArgumentException("storage can not be disabled for cluster-manager and data nodes");
     */
     * Can this node become cluster-manager or not.  
        TransportAddress address,
    /**  
    ) {
    }  
     * {@link DiscoveryNode#equals(Object)}.
            this.nodeName = "";
            }
        }  
     * @return true if the node contains warm role, false otherwise
    }
                    + "]";
                    role.legacySetting().get(settings)
import org.opensearch.core.common.io.stream.VerifiableWriteable;  
            }) // filter remote_store attributes
        }  
    private void writeNodeDetails(StreamOutput out) throws IOException {
     */
        return streamAddress;
        } else {
     * @param in the stream
        this.hostName = in.readString().intern();  
 */
        /*
            out.writeVInt(0);  
     * Returns whether the node is dedicated to host search replicas.
     * @param version          the version of the node
     * @return true if the node contains remote cluster state node attribute and remote routing table node attribute
    public String toString() {  
        return builder;
    }  
    public static boolean isClusterManagerNode(Settings settings) {
    @Override
        return roles.contains(DiscoveryNodeRole.INGEST_ROLE);
                }  
     */
    public int hashCode() {
     */
     * and updated.
    private final Map<String, String> attributes;
            node.getVersion()
        } else {
        for (int i = 0; i < rolesSize; i++) {
            this.nodeName = nodeName.intern();  
    }
     * The unique ephemeral id of the node. Ephemeral ids are meant to be attached the life span
     * @param version          the version of the node
    }
    public boolean isSearchNode() {  
            return roleMap.get(lowerCasedRoleName);  
        TransportAddress address,  
package org.opensearch.cluster.node;
                    + roleName
         * to avoid initializing this setting prematurely, we avoid using the actual node roles setting instance here.
                    roles.add(new DiscoveryNodeRole.DynamicRole(roleName, roleNameAbbreviation, canContainData));  
            sb.append(attributes.entrySet().stream().filter(entry -> {  
        Set<DiscoveryNodeRole> roles,
            final String roleNameAbbreviation = in.readString();
            if (role.legacySetting() != null && role.legacySetting().exists(settings)) {  
        return this.version;
    public static boolean isIngestNode(Settings settings) {
 * the Apache License, Version 2.0 (the "License"); you may
        Map<String, String> attributes,
        String ephemeralId,  
     * @throws IOException if there is an error while reading from the stream  
     * @param nodeId           the nodes unique persistent id  
    /**
/*  
                        return false;  
    public static Set<String> getPossibleRoleNames() {  
            builder.field(entry.getKey(), entry.getValue());
        );
    }
    public static Set<DiscoveryNodeRole> getPossibleRoles() {
     * Returns whether settings required for remote cluster state publication is configured
        Map<String, String> attributes = Node.NODE_ATTRIBUTES.getAsMap(settings);
 * You may obtain a copy of the License at  
    }
            return roleMap.values().stream().filter(s -> s.isEnabledByDefault(settings)).collect(Collectors.toSet());  
     * version. it corresponds to the minimum version this opensearch version can communicate with. If a higher version is used  
    }
    public boolean isRemoteClusterClient() {  
 *  
/*
            if (role == null) {
    public DiscoveryNode(  
     * the node might not be able to communicate with the remote node. After initial handshakes node versions will be discovered
    /**
     * @return true if the node contains a search role, false otherwise
     *
        sb.append('{').append(address).append('}');
            Stream.concat(DiscoveryNodeRole.BUILT_IN_ROLES.stream(), additionalRoles.stream())  
            this.attributes.put(in.readString(), in.readString());  
     * Due to the way that plugins may not be available when settings are being initialized,  
public class DiscoveryNode implements VerifiableWriteable, ToXContentFragment {  
    private final TransportAddress streamAddress;  
    public static boolean isWarmNode(Settings settings) {
            sb.append('}');  
        return hasRole(settings, DiscoveryNodeRole.MASTER_ROLE) || hasRole(settings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE);
     * Creates a new {@link DiscoveryNode}
import org.opensearch.Version;
    private static Map<String, DiscoveryNodeRole> rolesToMap(final Stream<DiscoveryNodeRole> roles) {
        return this.attributes;
        Map<String, String> attributes,
            sb.append('{');
     */  
     */
     * @param attributes       node attributes
            return success;
        this.roles = Collections.unmodifiableSortedSet(new TreeSet<>(roles));
     */
     * Returns a set of all the roles that the node has. The roles are returned in sorted order by the role name.  
            for (Map.Entry<String, String> entry : attributes.entrySet()) {
        }
     * version. it corresponds to the minimum version this opensearch version can communicate with. If a higher version is used  
        // we only need to hash the id because it's highly unlikely that two nodes
    }
    }
            address.address().getHostString(),  
     * @param nodeName         the nodes name
        }
            out.writeBoolean(compatibleRole.canContainData());
               // from logging to reduce noise.
     * and updated.
            nodeId,
            UUIDs.randomBase64UUID(),
        Version version  
     * @return true if the node contains remote store node attributes, false otherwise
     * version. it corresponds to the minimum version this opensearch version can communicate with. If a higher version is used  
    @Override
        }
        out.writeString(nodeId);  
    }
            boolean success = true;  
        }
            + "]";  
            out.writeOptionalWriteable(streamAddress);  
            }
        return nodeId;  
    public TransportAddress getStreamAddress() {
    private void writeRolesAndVersion(StreamOutput out) throws IOException {
        String nodeName,
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
     * are maintained during the life span of a node process, we can (and are) using the ephemeralId in
        return hasRole(settings, DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE);
                );  
    public Set<DiscoveryNodeRole> getRoles() {  
        builder.startObject("attributes");  
            return false;
            node.getEphemeralId(),  
     *  
import java.util.Set;
     * </p>  
     */  
        return this.hostAddress;
        Predicate<Map<String, String>> predicate = (attrs) -> {
    }
        if (nodeName != null) {
        for (final DiscoveryNodeRole role : roleMap.values()) {
        String nodeName,
    /**  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * Creates a new {@link DiscoveryNode}  
        this.address = address;
        }
            out.writeString(compatibleRole.roleName());
    private final String nodeName;  
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));  
        if (o == null || getClass() != o.getClass()) {  
        }
    /**
        Map<String, String> attributes,
        if (out.getVersion().onOrAfter(Version.V_3_2_0)) {
            + roleNameToPossibleRoles  
        this.ephemeralId = ephemeralId.intern();
    public void writeTo(StreamOutput out) throws IOException {
        writeToUtil(out, true);
    }
        out.writeString(ephemeralId);
                assert roleNameAbbreviation.equals(role.roleNameAbbreviation()) : "role name abbreviation ["  
        this.nodeId = in.readString().intern();
        return isClusterStateRepoConfigured(this.getAttributes()) && RemoteStoreNodeAttribute.isSegmentRepoConfigured(this.getAttributes());
            node.getName(),
            sb.append('{').append(nodeName).append('}');  
    }  
        }
        out.writeString(nodeName);
 * compatible open source license.
    }
    }
        if (streamAddress != null) {  
        assert roleNameToPossibleRoles.size() == roleNameAbbreviationToPossibleRoles.size() : "roles by name ["
        DiscoveryNode that = (DiscoveryNode) o;
    private final TransportAddress address;
    }
    }  
            node.getHostAddress(),
    }
    public static boolean nodeRequiresLocalStorage(Settings settings) {
/**  
     */
        );
            + roleNameAbbreviationToPossibleRoles
        builder.field("name", getName());
     */
     * <p>
     */  
        this.address = new TransportAddress(in);
    public boolean equals(Object o) {
            for (final DiscoveryNodeRole role : DiscoveryNode.roleMap.values()) {
        }
    public void writeToUtil(StreamOutput out, boolean includeAllAttributes) throws IOException {
        return hasRole(settings, DiscoveryNodeRole.INGEST_ROLE);  
     * @param roles            node roles
     * @param id               the nodes unique (persistent) node id. This constructor will auto generate a random ephemeral id.
        Set<DiscoveryNodeRole> roles,
        this.ephemeralId = in.readString().intern();
    }
            node.getRoles(),  
    }
     * checkpoint computation, retention leases and peer recovery) must be based on this rather than on
    private final String nodeId;
    /**
                .stream()
     * @param hostAddress      the nodes host address
     * the node might not be able to communicate with the remote node. After initial handshakes node versions will be discovered
    }  
        return roles.contains(DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE);
    public String getEphemeralId() {
        builder.field("ephemeral_id", getEphemeralId());  
     */
        if (NODE_ROLES_SETTING.exists(settings)) {
    }  
         * initialization prematurely because that will bake the default roles before plugins have had a chance to register them. Therefore,
                    role.legacySetting().getKey(),
     * <p>
     * The unique id of the node.  
        sb.append('{').append(hostName).append('}');
     * <p>
            roles.stream().map(DiscoveryNodeRole::roleNameAbbreviation).sorted().forEach(sb::append);
 * Unless required by applicable law or agreed to in writing,
        if (nodeName.length() > 0) {
        StringBuilder sb = new StringBuilder();
     * @param attributes       node attributes
            this.streamAddress = in.readOptionalWriteable(TransportAddress::new);
         * This method can be called before the o.e.n.NodeRoleSettings.NODE_ROLES_SETTING is initialized. We do not want to trigger  
    private static void validateLegacySettings(final Settings settings, final Map<String, DiscoveryNodeRole> roleMap) {
        } else {
import org.opensearch.core.common.io.stream.StreamOutput;
     * Returns whether or not the node can be a remote cluster client.
 *
 */  
     *
    }
    }  
                .collect(Collectors.toMap(DiscoveryNodeRole::roleNameAbbreviation, Function.identity()))  
 * this work for additional information regarding copyright
        return roleMap.keySet();
    /**
                if (in.getVersion().onOrAfter(Version.V_2_1_0)) {
     * @return true if the node can be a remote cluster client, false otherwise
        builder.field("transport_address", getAddress().toString());
    public DiscoveryNode(
            address,
        }
        return Collections.unmodifiableSet(new HashSet<>(roleMap.values()));  
        } else {
     * version. it corresponds to the minimum version this opensearch version can communicate with. If a higher version is used
     * @return true if the node contains remote segment store node attributes, false otherwise  
        return RemoteStoreNodeAttribute.isTranslogRepoConfigured(this.getAttributes());  
    }
        // in our system will have the same id but be different  
    }
    }  
 * SPDX-License-Identifier: Apache-2.0
     *  
            return Collections.unmodifiableSet(new HashSet<>(NODE_ROLES_SETTING.get(settings)));
@PublicApi(since = "1.0.0")
import org.opensearch.node.Node;
     * @return the sorted set of roles
            sb.append('{').append(streamAddress).append('}');
     * <b>Note:</b> if the version of the node is unknown {@link Version#minimumCompatibilityVersion()} should be used for the current
 * KIND, either express or implied.  See the License for the
            builder.field("stream_transport_address", getStreamAddress().toString());  
 * Licensed to Elasticsearch under one or more contributor  
        roleMap = roleNameToPossibleRoles;
    public boolean isWarmNode() {  
                } else {
            final DiscoveryNodeRole compatibleRole = role.getCompatibilityRole(out.getVersion());
        this.nodeName = in.readString().intern();  
        TransportAddress address,  
import java.util.SortedSet;  
        return roles.stream().anyMatch(DiscoveryNodeRole::canContainData);
                    + role.roleNameAbbreviation()  
     */
     * and updated.
        this(id, address, Collections.emptyMap(), DiscoveryNodeRole.BUILT_IN_ROLES, version);
 * The OpenSearch Contributors require contributions made to  
    /**  
            return settings.getAsList("node.roles").contains(role.roleName());
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
        return ephemeralId.hashCode();
        this.streamAddress = streamAddress;  
     * <p>
     * Returns whether the node stores translog in a remote store. Durability decisions (replication mode, global
        return ephemeralId.equals(that.ephemeralId);  
            }  
     *  
        roleMap = Collections.unmodifiableMap(modifiableRoleMap);  
                out.writeString(entry.getKey());
        builder.startObject(getId());
        return roles.contains(DiscoveryNodeRole.SEARCH_ROLE);
        out.writeVInt(roles.size());
        int rolesSize = in.readVInt();  
     * Returns whether the node is dedicated to hold warm indices.
    private final String hostName;  
    }
        // collect the abbreviation names into a map to ensure that there are not any duplicate abbreviations
        }  
                    }
        writeNodeDetails(out);  
import org.opensearch.common.UUIDs;
     *  
    }  
    ) {
                    if (entry.getKey().startsWith(prefix)) {
        this.hostName = hostName.intern();  
        writeRolesAndVersion(out);
    }
    }
 * ownership. Elasticsearch licenses this file to you under  
 */
    public String getHostName() {
            roleNameToPossibleRoles.values()
        } else {
        Version version  
        return getRolesFromSettings(settings).stream().anyMatch(DiscoveryNodeRole::canContainData);
        }  
                }
    /**
import java.util.HashMap;  
                assert success : role.roleName();  
        }
     * Creates a new {@link DiscoveryNode} by reading from the stream provided as argument
        if (localStorageEnable == false && (isDataNode(settings) || isClusterManagerNode(settings))) {  
        return getRolesFromSettings(settings).stream().allMatch(DiscoveryNodeRole.WARM_ROLE::equals);  
        if (in.getVersion().onOrAfter(Version.V_3_2_0)) {  
            attributes,  
     * @param address          the nodes transport address
    public void writeToWithAttribute(StreamOutput out) throws IOException {
        assert predicate.test(attributes) : attributes;
     */  
        }
        }
    }  
    }  
    public DiscoveryNode(final String id, TransportAddress address, Version version) {  
            node.getId(),
            version
        TransportAddress address,  
    }
        return new DiscoveryNodeRole.DynamicRole(lowerCasedRoleName, lowerCasedRoleName, false);
        }  
 * @opensearch.api  
        } else if (role.legacySetting() != null && settings.hasValue(role.legacySetting().getKey())) {  
    public boolean isRemoteTranslogStoreNode() {
                    "can not explicitly configure node roles and use legacy role setting [%s]=[%s]",  
            address.getAddress(),
    private static Map<String, DiscoveryNodeRole> roleMap = rolesToMap(DiscoveryNodeRole.BUILT_IN_ROLES.stream());  
     */
     * @param ephemeralId      the nodes unique ephemeral id
    /**  
    }
    private final SortedSet<DiscoveryNodeRole> roles;  
     * therefore still relies on node-to-node replication.
    /**
     */
    /**
            validateLegacySettings(settings, roleMap);  
    public void writeVerifiableTo(BufferedChecksumStreamOutput out) throws IOException {
     * @param nodeName         the nodes name
     * @param address          the nodes transport address  
            node.getHostName(),
import java.util.Objects;
     *  
            + "], roles by name abbreviation ["
    public boolean isRemoteStoreNode() {  
        String ephemeralId,
    public static DiscoveryNode createLocal(Settings settings, TransportAddress publishAddress, String nodeId) {  
    private final String ephemeralId;
        writeNodeDetails(out);
        this.nodeId = nodeId.intern();
        out.writeVersion(version);  
     * @param address          the nodes transport address  
    public static boolean isDedicatedWarmNode(Settings settings) {
                    roles.add(new DiscoveryNodeRole.UnknownRole(roleName, roleNameAbbreviation, canContainData));
     */
        this("", id, address, attributes, roles, version);
     * @param roles            node roles  
    /** extract node roles from the given settings */  
         */  
    @Override  
        );
            } else {
import java.util.Map;  
    }
        if (this == o) {  
        return address;
     * @return true if the node contains remote translog store node attributes, false otherwise  
    }
            }
        Version version  
    }
        for (final DiscoveryNodeRole role : roles) {  
        String nodeName,  
     * the node might not be able to communicate with the remote node. After initial handshakes node versions will be discovered  
        return this.nodeName;  
     * The address that the node can be communicated with.
            streamAddress,
     */
        Version version  
            this.version = version;
    private final String hostAddress;
                return true;  
        return this.hostName;  
    /**
        this(nodeName, nodeId, ephemeralId, hostName, hostAddress, address, null, attributes, roles, version);
    public static DiscoveryNodeRole getRoleFromRoleName(final String roleName) {
     * and updated.
        TransportAddress streamAddress,  
     * </p>
    public boolean isIngestNode() {  
    public DiscoveryNode(
        return new DiscoveryNode(Node.NODE_NAME_SETTING.get(settings), nodeId, publishAddress, attributes, roles, Version.CURRENT);  
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_NODE_ATTRIBUTE_KEY_PREFIX;
        final Map<String, DiscoveryNodeRole> roleNameToPossibleRoles = rolesToMap(
        return sb.toString();
    public boolean isDataNode() {
     * of a node process. When ever a node is restarted, it's ephemeral id is required to change (while it's {@link #getId()}
        this.roles = Collections.unmodifiableSortedSet(new TreeSet<>(roles));
        writeRolesAndVersion(out);  
        this.attributes = Collections.unmodifiableMap(attributes);  
     */
}
        );  
/*  
            node.getAttributes(),
        };  
                roles.add(role);
        String hostAddress,
    /**  
import org.opensearch.common.settings.Setting;
        return roles.contains(DiscoveryNodeRole.MASTER_ROLE) || roles.contains(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE);  
        sb.append('{').append(ephemeralId).append('}');  
     */
import java.util.function.Predicate;  
     * Returns a boolean that tells whether this an ingest node or not
    }
            node.getAddress(),  
        // This is done so that this class can be used efficiently as a key in a map
    }  
        }
        builder.endObject();  
        builder.endObject();
        return localStorageEnable;
     * </p>  
        String id,
        this.attributes = new HashMap<>(size);
        }
            nodeName,  
import org.opensearch.node.remotestore.RemoteStoreNodeAttribute;
    /**  
import org.opensearch.common.annotation.PublicApi;  
        String hostAddress,
     * Creates a new {@link DiscoveryNode}  
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.isClusterStateRepoConfigured;  
        this.hostAddress = hostAddress.intern();
     * @param nodeId           the nodes unique persistent id. An ephemeral id will be auto generated.  
            out.writeVInt(attributes.size());  
     * Should this node hold data (shards) or not.
import java.util.Locale;
     * @param version          the version of the node
    /**
    @Override  
        return isClusterStateRepoConfigured(this.getAttributes()) && isRoutingTableRepoConfigured(this.getAttributes());
        modifiableRoleMap.put(DiscoveryNodeRole.MASTER_ROLE.roleName(), DiscoveryNodeRole.MASTER_ROLE);
        int size = in.readVInt();  
            // TODO: make this a proper setting validation logic, requiring multi-settings validation
    @Override  
        address.writeTo(out);
        if (out.getVersion().onOrAfter(Version.V_2_17_0)) {
        Stream<DiscoveryNodeRole> rolesWithSearch = Stream.concat(roles, Stream.of(DiscoveryNodeRole.SEARCH_ROLE));
    }
    public static boolean isRemoteClusterClient(final Settings settings) {  
        assert additionalRoles.stream().allMatch(r -> r.legacySetting() == null || r.legacySetting().isDeprecated()) : additionalRoles;
    /**  
            roles,
import org.opensearch.core.common.io.stream.StreamInput;
    }
     * will be read from the data folder and will remain the same across restarts). Since all node attributes and addresses  
     * @param roles            node roles
    /**
    public boolean isRemoteSegmentStoreNode() {
        return roles;
    /** Creates a DiscoveryNode representing the local node. */
    public boolean isClusterManagerNode() {
        } else {  
        return Collections.unmodifiableMap(rolesWithSearch.collect(Collectors.toMap(DiscoveryNodeRole::roleName, Function.identity())));  
        return ephemeralId;
     * <b>Note:</b> if the version of the node is unknown {@link Version#minimumCompatibilityVersion()} should be used for the current
        for (int i = 0; i < size; i++) {
        }
        return hasRole(settings, DiscoveryNodeRole.WARM_ROLE);
        return roles.contains(DiscoveryNodeRole.WARM_ROLE);
import java.util.HashSet;
    public DiscoveryNode(  
                out.writeString(entry.getValue());  
        this.version = in.readVersion();  
        } else {
    /**
            return role.legacySetting().get(settings);
     * the node might not be able to communicate with the remote node. After initial handshakes node versions will be discovered
import org.opensearch.core.xcontent.ToXContentFragment;
 * this file be licensed under the Apache-2.0 license or a
        final Set<DiscoveryNodeRole> roles = new HashSet<>(rolesSize);
        String lowerCasedRoleName = Objects.requireNonNull(roleName).toLowerCase(Locale.ROOT);
        if (roleMap.containsKey(lowerCasedRoleName)) {
        out.writeString(hostAddress);  
        if (version == null) {
            writeToUtil(out, true);
     *
        if (settings.hasValue("node.roles")) {
        if (streamAddress != null) {
            this.version = Version.CURRENT;
            writeToUtil(out, false);  
        Set<DiscoveryNodeRole> roles,
import java.util.stream.Collectors;
    }  
        // As we are supporting dynamic role, should make role name case-insensitive to avoid confusion of role name like "Data"/"DATA"  
        String hostName,
     * If a node does not have any specific role, the returned set is empty, which means that the node is a coordinating-only node.
                for (String prefix : REMOTE_STORE_NODE_ATTRIBUTE_KEY_PREFIX) {
     * and CLUSTER_MANAGER_ROLE has the same abbreviation name with MASTER_ROLE.
     * @param version          the version of the node  
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
     * default value function. In that case, be warned that this may not include all plugin roles.
    /**
            return role.isEnabledByDefault(settings);  
    }  
import java.io.IOException;
        final Map<String, DiscoveryNodeRole> modifiableRoleMap = new HashMap<>(roleMap);
    public boolean isRemoteStatePublicationEnabled() {
     * The name of the node.  
import org.opensearch.core.common.io.stream.BufferedChecksumStreamOutput;  
import org.opensearch.common.settings.Settings;
     * Load the deprecated {@link DiscoveryNodeRole#MASTER_ROLE}.
        if (includeAllAttributes) {
        String nodeId,
            streamAddress = null;  
            return true;
    public Version getVersion() {
        }
        this(
     * Returns whether the node is a remote segment store node.
 *
        Map<String, String> attributes,
import java.util.Collections;
     * {@link #isRemoteStoreNode()}, since a node running in {@code segments_only} mode keeps its translog locally and  
        // verify that no node roles are being provided as attributes
     * <b>Note:</b> if the version of the node is unknown {@link Version#minimumCompatibilityVersion()} should be used for the current
    public static void setAdditionalRoles(final Set<DiscoveryNodeRole> additionalRoles) {  
    public static boolean hasRole(final Settings settings, final DiscoveryNodeRole role) {
    ) {
    private final Version version;
     * @param address          the nodes transport address
        if (roles.isEmpty() == false) {  
import org.opensearch.core.xcontent.XContentBuilder;  
 * A discovery node represents a node that is part of the cluster.
                assert roleName.equals(role.roleName()) : "role name [" + roleName + "] does not match role [" + role.roleName() + "]";
    /**
 *
     * <p>  
    }  
 * GitHub history for details.
            out.writeString(compatibleRole.roleNameAbbreviation());  
                    Locale.ROOT,
    public String getId() {
                final String message = String.format(
                success &= attrs.containsKey(role.roleName()) == false;
    }
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.isRoutingTableRepoConfigured;
        }
    public static void setDeprecatedMasterRole() {  
        String nodeId,
     * Master role is not added into BUILT_IN_ROLES, because {@link #setAdditionalRoles(Set)} check role name abbreviation duplication,  
        this.hostAddress = in.readString().intern();
        Set<DiscoveryNodeRole> roles,
    public TransportAddress getAddress() {  
import java.util.TreeSet;
 */  
     * Creates a new {@link DiscoveryNode}.  
     * not all roles may be available from a static/initializing context such as a {@link Setting}
     */
     */  
