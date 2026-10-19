        public Builder(DiscoveryNodes nodes) {
                        } else if (DiscoveryNode.COORDINATING_ONLY.equals(matchAttrName)) {
            final Map<String, DiscoveryNode> dataNodesBuilder = new HashMap<>();
    public Version getLargestNonClientNodeVersion() {
 * @opensearch.api
import org.opensearch.common.regex.Regex;
        public Builder remove(DiscoveryNode node) {
        this.nodes = Collections.unmodifiableMap(nodes);
                        maxNonClientNodeVersion = Version.max(maxNonClientNodeVersion, version);  
import org.opensearch.common.Booleans;
        }
    public Map<String, DiscoveryNode> getClusterManagerAndDataNodes() {  
    }
 * access, modify merge / diff discovery nodes.
            Version maxNodeVersion = null;
import java.util.List;
                localNodeId,
     * Get a {@link Map} of the discovered nodes arranged by their ids
    public DiscoveryNodes newNode(DiscoveryNode node) {  
        private final String localNodeId;
     * - _local, _cluster_manager (_master) and _all respectively add to the subset the local node, the currently-elected cluster_manager, and all the nodes  
                    if (localNodeId != null) {
    /**  
 * software distributed under the License is distributed on an
                if (node.getId().equals(existingNode.getId()) && node.equals(existingNode) == false) {
    private final Map<String, DiscoveryNode> dataNodes;  
    }
            && Objects.equals(maxNodeVersion, that.maxNodeVersion)  
     */
            return resolvedNodesIds.toArray(new String[0]);
        /**
        return Collections.unmodifiableMap(nodes);  
     * Determine if a given node id exists
            );
    }
                }
                                resolvedNodesIds.addAll(clusterManagerNodes.keySet());  
    public Map<String, DiscoveryNode> getCoordinatingOnlyNodes() {
            throw new IllegalArgumentException("failed to resolve [" + node + "], no matching nodes");  
        return this.clusterManagerNodes;  
    public void writeVerifiableTo(BufferedChecksumStreamOutput out) throws IOException {  
import org.opensearch.common.util.set.Sets;
                    return "can't add node " + node + ", found existing node " + existingNode + " with same address";  
                            } else {
                        }
                                        resolvedNodesIds.add(node.getId());  
                        resolvedNodesIds.add(clusterManagerNodeId);
            return this;
         * exception
    public boolean nodeExistsWithSameRoles(DiscoveryNode discoveryNode) {
        writeClusterManager(out);
        if (clusterManagerNodeId == null) {  
        if (resolvedNodeIds.length == 0) {
                maxNodeVersion = maxNodeVersion == null ? version : Version.max(maxNodeVersion, version);
     * @opensearch.api
    private void writeClusterManager(StreamOutput out) throws IOException {
import org.opensearch.core.common.io.stream.StreamInput;
            this.nodes = new HashMap<>(nodes.getNodes());
    /**
            return added;  
            throw new IllegalArgumentException(
                    summary.append(", ");  
        this.clusterManagerNodeId = clusterManagerNodeId;  
        }  
                                    }
    public boolean nodeExists(String nodeId) {  
                if (node.getAddress().equals(existingNode.getAddress()) && node.getId().equals(existingNode.getId()) == false) {
                    ingestNodesBuilder.put(nodeEntry.getKey(), nodeEntry.getValue());
        }  
     */
     */  
                }
        @Nullable  
     * @return id of the cluster-manager  
         */
     *
    }
            minNonClientNodeVersion,
     *  
    @Override
            if (other.nodeExists(node) == false) {
     * An empty sequence of node specifications returns all nodes, since the corresponding actions run on all nodes by default.  
 *  
                        String matchAttrValue = nodeId.substring(index + 1);  
        public DiscoveryNodes build() {
                        String matchAttrName = nodeId.substring(0, index);
 * this work for additional information regarding copyright
     * @return <code>true</code> if the node exists. Otherwise <code>false</code>
        return nodes.values().iterator();
     * @deprecated As of 2.0, because promoting inclusive language. MASTER_ROLE is deprecated.  
            Version minNonClientNodeVersion = null;
    }
 * license agreements. See the NOTICE file distributed with
        }
            maxNonClientNodeVersion,
            return clusterManagerNodeChanged() || !removed.isEmpty() || !added.isEmpty();  
        final Map<String, DiscoveryNode> ingestNodes,
        private String validateAdd(DiscoveryNode node) {  
                + builder.validateAdd(node);
            dataNodes,
import org.opensearch.core.common.Strings;  
            writer.write(out, node);
                            }  
            this.localNodeId = nodes.getLocalNodeId();
        return DiscoveryNodeRole.MASTER_ROLE.roleName().equals(matchAttrName)  
            nodes.put(node.getId(), node);  
                nodes.remove(node.getId());
    private final Map<String, DiscoveryNode> warmNodes;
     * The method is added for {@link #resolveNodes} to keep the code clear, when support the both above roles.
     * @return {@link Map} of the coordinating only nodes arranged by their ids  
     * @return the oldest version in the cluster  
import java.util.Collections;  
        this.clusterManagerNodes = Collections.unmodifiableMap(clusterManagerNodes);
                    }
        return Objects.hash(  
    @PublicApi(since = "1.0.0")
                    }
    /**  
            // we don't know yet the local node id, return false  
                    .map(DiscoveryNode::toString)
import java.util.HashMap;
                node = localNode;  
     * Resolve a node with a given id
        final List<DiscoveryNode> added = new ArrayList<>();  
        for (int i = 0; i < size; i++) {
 * SPDX-License-Identifier: Apache-2.0
            getClusterManagerNode(),
    public String[] resolveNodes(String... nodes) {
     */
     * @param node id of the node to discover  
    }
            for (String nodeId : nodes) {
 * The OpenSearch Contributors require contributions made to  
            return !added.isEmpty();
     * Works by tracking the current set of nodes and applying each node specification in sequence. The set starts out empty and each node  
                } else if (nodeExists(nodeId)) {
        }  
        }  
        public Builder add(DiscoveryNode node) {  
    }  
 * ownership. Elasticsearch licenses this file to you under  
     * <p>  
        if (localNodeId == null) {
    public Version getSmallestNonClientNodeVersion() {  
    /**
     *
 * This class holds all {@link DiscoveryNode} in the cluster and provides convenience methods to
     *
                final Version version = nodeEntry.getValue().getVersion();
        out.writeVInt(nodes.size());
     *
            final HashSet<String> resolvedNodesIds = new HashSet<>(nodes.length);  
                                resolvedNodesIds.addAll(dataNodes.keySet());  
import java.util.Objects;  
    /**  
                if (newClusterManagerNode() != null) {
                        minNonClientNodeVersion = Version.min(minNonClientNodeVersion, version);
     */  
            @Nullable DiscoveryNode newClusterManagerNode,
            if (node.getAddress().equals(address)) {
            other.getClusterManagerNode(),
                clusterManagerNodeId,
                            || Regex.simpleMatch(nodeId, node.getHostAddress())
 */  
    private final Map<String, DiscoveryNode> clusterManagerNodes;
     *
    /**
 */
                        + ", found existing node "
        final Map<String, DiscoveryNode> nodes = new HashMap<>(dataNodes);
        return new Builder();  
     * If there are no non-client nodes, Version.CURRENT will be returned.
                if (nodeEntry.getValue().isDataNode()) {
     * Returns a stream of all nodes, with cluster-manager nodes at the front
     * Get a {@link Map} of the discovered cluster-manager nodes arranged by their ids
                    summary.append(newClusterManagerNode());  
                    summary.append("added {").append(addedNodesExceptLocalNode).append('}');
        public String shortSummary() {  
        Version minNodeVersion
    }  
        private void putUnsafe(DiscoveryNode node) {
        String localNodeId,
    }
     */
            Collections.unmodifiableList(removed),
    /**  
                                resolvedNodesIds.addAll(getCoordinatingOnlyNodes().keySet());  
            return summary.toString();
            // some one already built this and validated it's OK, skip the n2 scans
        public Builder() {
     * @return {@link Map} of the discovered nodes arranged by their ids  
            && Objects.equals(maxNonClientNodeVersion, that.maxNonClientNodeVersion)
    /**
                }
    }
    public Version getMinNodeVersion() {
        }
            StreamSupport.stream(this.spliterator(), false).filter(n -> n.isClusterManagerNode() == false)
     * @return discovered node matching the given id
    /**  
        }
        return builder.build();
         * Checks that a node can be safely added to this node collection.
    }
     * Get a {@link Map} of the discovered cluster-manager and data nodes arranged by their ids
     */
        @Nullable
    }
     * @return the youngest version in the cluster  
        return this.nodes;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                clusterManagerNodesBuilder,
     * Get a {@link Map} of the discovered warm nodes arranged by their ids
            if (localNode != null && node.getId().equals(localNode.getId())) {
                                resolvedNodesIds.addAll(ingestNodes.keySet());  
     *
        /**
            out.writeBoolean(false);
     * Returns the version of the node with the oldest version in the cluster.
            String localNodeId,  
import org.opensearch.common.annotation.PublicApi;  
        if (localNode != null) {
        @Nullable
    public boolean nodeExists(DiscoveryNode node) {
        } else {
            || DiscoveryNodeRole.CLUSTER_MANAGER_ROLE.roleName().equals(matchAttrName);
     * Determine if the given node exists and has the right roles. Supported roles vary by version, and our local cluster state might
import java.util.stream.Collectors;
     */  
                ingestNodesBuilder,  
    @Deprecated
    public boolean equals(Object o) {  
                    .collect(Collectors.joining(","));
                            } else {
     *
 * KIND, either express or implied.  See the License for the
     */  
        for (DiscoveryNode node : other) {
            final StringBuilder summary = new StringBuilder();
    @Nullable  
import java.util.stream.Stream;  
import java.util.ArrayList;
        }  
    @Override
                            if (Booleans.parseBoolean(matchAttrValue, true)) {
     * @return <code>true</code> if the node exists. Otherwise <code>false</code>
     */
     * Returns the version of the node with the youngest version in the cluster
        private final List<DiscoveryNode> added;
    public DiscoveryNode get(String nodeId) {
    /**
        public boolean hasChanges() {
                        resolvedNodesIds.add(localNodeId);  
            && Objects.equals(dataNodes, that.dataNodes)
            return clusterManagerNodeId != null && clusterManagerNodeId.equals(localNodeId);
                        summary.append(", ");  
        }
        public Builder remove(String nodeId) {  
                                        } else {
     * @param nodeId id of the wanted node
     * Get a node by its address  
     * <p>
     * Builder of a map of discovery nodes.
                return node;
@PublicApi(since = "1.0.0")  
/*  
    /**  
     * specification may either add or remove nodes. For instance:
        return null;
        Version maxNonClientNodeVersion,  
            }  
                            for (DiscoveryNode node : this) {
            return StreamSupport.stream(this.spliterator(), false).map(DiscoveryNode::getId).toArray(String[]::new);
         * @return wanted node if it exists. Otherwise <code>null</code>
                summary.append("cluster-manager node changed {previous [");  
    public static class Builder {
        final Map<String, DiscoveryNode> nodes,
    public Map<String, DiscoveryNode> getNodes() {
            this.clusterManagerNodeId = nodes.getClusterManagerNodeId();  
        }  
            && Objects.equals(ingestNodes, that.ingestNodes)
     * Get the local node
                maxNonClientNodeVersion == null ? Version.CURRENT : maxNonClientNodeVersion,
    }  
            return newClusterManagerNode;
                                    String attrValue = entry.getValue();
                removed.add(node);  
         */
        StringBuilder sb = new StringBuilder();
    @PublicApi(since = "1.0.0")  
/*  
            );  
        private final DiscoveryNode previousClusterManagerNode;  
    public void writeToWithAttribute(StreamOutput out) throws IOException {
    /**  
                            } else {
            }
                    // ignore ourselves when reporting on nodes being added
                                }
     * <p>
        this.dataNodes = Collections.unmodifiableMap(dataNodes);
     * - node IDs, names, hostnames and IP addresses all add to the subset any nodes which match
        }  
                            for (DiscoveryNode node : this) {
            final Map<String, DiscoveryNode> warmNodesBuilder = new HashMap<>();  
        Version minNonClientNodeVersion,
     */
     * @return the oldest version in the cluster
                    if (index != -1) {
     */
                                        }  
import java.util.Map;
                                    String attrName = entry.getKey();  
            }
        }
    /**  
         * @return null if all is OK or an error message explaining why a node can not be added.
    /**
        }  
                    warmNodesBuilder.put(nodeEntry.getKey(), nodeEntry.getValue());  
                            resolvedNodesIds.add(node.getId());  
     */  
        private String clusterManagerNodeId;
                }  
        return Objects.equals(nodes, that.nodes)
    }
                    for (DiscoveryNode node : this) {
        writeToUtil((output, value) -> value.writeTo(output), out);
    }
public class DiscoveryNodes extends AbstractDiffable<DiscoveryNodes> implements Iterable<DiscoveryNode>, VerifiableWriteable {
            return removed;
        public Builder clusterManagerNodeId(String clusterManagerNodeId) {  
        }
            && Objects.equals(clusterManagerNodeId, that.clusterManagerNodeId)
     * @return {@link Map} of the discovered cluster-manager and data nodes arranged by their ids
    }
        public DiscoveryNode get(String nodeId) {
                } else if (nodeId.equals("_local")) {  
        nodes.putAll(clusterManagerNodes);
            nodes,
        sb.append("nodes: \n");  
        for (DiscoveryNode node : this) {
     * @param nodeId id of the node which existence should be verified  
            return nodes.get(clusterManagerNodeId);  
        return nodes.get(resolvedNodeIds[0]);
    public int hashCode() {
        public boolean added() {
        }
        return new Delta(  
    }
            }
        @Nullable  
                                    if (Regex.simpleMatch(matchAttrName, attrName) && Regex.simpleMatch(matchAttrValue, attrValue)) {
        @Nullable
        }  
    }
                        minNonClientNodeVersion = version;
    public static Diff<DiscoveryNodes> readDiffFrom(StreamInput in, DiscoveryNode localNode) throws IOException {
                    String clusterManagerNodeId = getClusterManagerNodeId();  
                                }
                                for (DiscoveryNodeRole role : Sets.difference(node.getRoles(), DiscoveryNodeRole.BUILT_IN_ROLES)) {  
    public void writeToUtil(final Writer<DiscoveryNode> writer, StreamOutput out) throws IOException {  
 * Unless required by applicable law or agreed to in writing,
            List<DiscoveryNode> removed,
            @Nullable DiscoveryNode previousClusterManagerNode,
        if (nodes == null || nodes.length == 0) {  
    /**
     *
     * @opensearch.api
         * @param nodeId id of the wanted node  
    /**
            if (preflight != null) {
        if (in.readBoolean()) {
                    if (clusterManagerNodeId != null) {
            assert builder.validateAdd(node) == null : "building disco nodes from network doesn't pass preflight: "  
     * Returns the version of the node with the youngest version in the cluster that is not a client node.
            Collections.unmodifiableList(added)
            return this;  
            && Objects.equals(clusterManagerNodes, that.clusterManagerNodes)  
     */
 *  
    /**  
        for (DiscoveryNode node : this) {  
     * @return {@link Map} of the discovered data nodes arranged by their ids  
                            }  
            return null;
    public Version getMaxNodeVersion() {
            }
            this.localNodeId = localNodeId;  
                        maxNonClientNodeVersion = version;  
            return new DiscoveryNodes(
    }
                                for (Map.Entry<String, String> entry : node.getAttributes().entrySet()) {
    /**  
        }
            if (this.nodeExists(node) == false) {
        Builder builder = new Builder();  
    }  
        return existing != null && existing.equals(node);  
            }
            }
                warmNodesBuilder,
    }
                    }  
import org.opensearch.core.common.io.stream.BufferedChecksumStreamOutput;
                        } else if (DiscoveryNodeRole.INGEST_ROLE.roleName().equals(matchAttrName)) {
        }
            maxNodeVersion,  
    public int getSize() {
    /**  
                }
    public Stream<DiscoveryNode> clusterManagersFirstStream() {
            }
    }
                sb.append(", cluster-manager");
     *
        }  
        return maxNonClientNodeVersion;  
        public boolean isLocalNodeElectedClusterManager() {
    public static Builder builder() {
        this.localNodeId = localNodeId;
    public Iterator<DiscoveryNode> iterator() {  
                        } else if (roleNameIsClusterManager(matchAttrName)) {
        }  
import java.util.stream.StreamSupport;
                if (nodeEntry.getValue().isIngestNode()) {  
            return this;
                    continue;
    ) {  
                    } else {
            return this;
                                            resolvedNodesIds.add(node.getId());  
                            || Regex.simpleMatch(nodeId, node.getHostName())) {
                                    }
        ) {  
        final DiscoveryNode existing = nodes.get(discoveryNode.getId());
            && Objects.equals(minNodeVersion, that.minNodeVersion);
                summary.append("]}");
    public DiscoveryNode resolveNode(String node) {
            StreamSupport.stream(Spliterators.spliterator(clusterManagerNodes.entrySet(), 0), false).map(cur -> cur.getValue()),  
        return Stream.concat(
        public List<DiscoveryNode> addedNodes() {
 * compatible open source license.
                dataNodesBuilder,  
        public Builder localNodeId(String localNodeId) {
            localNodeId,  
                            if (Booleans.parseBoolean(matchAttrValue, true)) {
                }
     *
         *  
        final Map<String, DiscoveryNode> warmNodes,  
    private final Version maxNonClientNodeVersion;
     * Delta between nodes.  
    /**
                    dataNodesBuilder.put(nodeEntry.getKey(), nodeEntry.getValue());  
        }
     * @param address {@link TransportAddress} of the wanted node
                        + node
 * under the License.  
    public Map<String, DiscoveryNode> getDataNodes() {
    private final Map<String, DiscoveryNode> ingestNodes;  
     *
            out.writeBoolean(true);  
     */
    public String getClusterManagerNodeId() {
    }  
        return nodes.get(localNodeId);  
     */
        public boolean clusterManagerNodeChanged() {  
        final HashMap<String, DiscoveryNode> nodes = new HashMap<>(this.nodes);  
    public static final DiscoveryNodes EMPTY_NODES = builder().build();  
            List<DiscoveryNode> added
        writeToUtil((output, value) -> value.writeToWithAttribute(output), out);  
     * @return number of nodes  
        }
    public Map<String, DiscoveryNode> getWarmNodes() {
     * @param matchAttrName a given String for a name of the node role.
            DiscoveryNode node = new DiscoveryNode(in);  
    }
                if (nodeEntry.getValue().isClusterManagerNode()) {
     *
    @Override
    private final String localNodeId;  
 * specific language governing permissions and limitations
     */  
     * @return id of the local node  
     */
                                resolvedNodesIds.removeAll(dataNodes.keySet());
                        if (DiscoveryNodeRole.DATA_ROLE.roleName().equals(matchAttrName)) {
     */
        }
     * @return wanted node if it exists. Otherwise <code>null</code>  
    public static DiscoveryNodes readFrom(StreamInput in, DiscoveryNode localNode) throws IOException {
        }
        return new Builder(this).add(node).build();
            sb.append("\n");  
     */  
     * Get the id of the cluster-manager node
                    // don't silence the underlying issue, it is a bug, so lets fail if assertions are enabled  
        );  
                }
        nodes.keySet().removeAll(dataNodes.keySet());
    }  
        }
                    String localNodeId = getLocalNodeId();
        public DiscoveryNode newClusterManagerNode() {
        public boolean removed() {
            this.added = added;
     * have come via an older cluster-manager, so the roles may differ even if the node is otherwise identical.
                            if (Booleans.parseBoolean(matchAttrValue, true)) {
            if (added()) {
    }
            for (final Map.Entry<String, DiscoveryNode> nodeEntry : nodes.entrySet()) {
            sb.append("   ").append(node);
        private String localNodeId;
    /**
            if (removed()) {
     * Get a {@link Map} of the discovered data nodes arranged by their ids
                            }  
    public String getLocalNodeId() {
    private final Version minNodeVersion;
            }  
        }  
                summary.append("], current [");
     * Returns {@code true} if the local node is the elected cluster-manager node.
                if (previousClusterManagerNode() != null) {
        nodes.keySet().removeAll(clusterManagerNodes.keySet());
    @Override  
            && Objects.equals(localNodeId, that.localNodeId)  
            this.previousClusterManagerNode = previousClusterManagerNode;
    private DiscoveryNodes(  
        );
        }
     * - role:true adds to the subset all nodes with a matching role  
import java.util.HashSet;
            builder.clusterManagerNodeId(in.readString());
        return sb.toString();
     * Returns the cluster-manager node, or {@code null} if there is no cluster-manager node
     * - a wildcard-based pattern of the form "attr*:value*" adds to the subset all nodes with a matching attribute with a matching value
     * @return {@link Map} of the discovered cluster-manager nodes arranged by their ids  
            return previousClusterManagerNode;  
}  
        int size = in.readVInt();
     *  
    }
import org.opensearch.common.Nullable;
            builder.localNodeId(localNode.getId());
 */  
     * Returns the changes comparing this nodes to the provided nodes.
    }
                summary.append("removed {").append(Strings.collectionToCommaDelimitedString(removedNodes())).append('}');
                    return "can't add node "  
            return false;
        public DiscoveryNode previousClusterManagerNode() {
    }  
    public DiscoveryNode getLocalNode() {
            out.writeString(clusterManagerNodeId);
        String[] resolvedNodeIds = resolveNodes(node);
        }
        this.warmNodes = Collections.unmodifiableMap(warmNodes);  
                "resolved [" + node + "] into [" + resolvedNodeIds.length + "] nodes, where expected to be resolved to a single node"
                    if (summary.length() > 0) {
                minNodeVersion = minNodeVersion == null ? version : Version.min(minNodeVersion, version);  
                            }  
     * user to run the action on a subset of the nodes in the cluster. See [Node specification] in the reference manual for full details.
    }
        this.maxNonClientNodeVersion = maxNonClientNodeVersion;  
     * @throws IllegalArgumentException if more than one node matches the request or no nodes have been resolved
        return ingestNodes;
            minNodeVersion
     *
 *
    public static class Delta {
        }  
        nodes.keySet().removeAll(ingestNodes.keySet());  
 * Modifications Copyright OpenSearch Contributors. See
                    }
         * Get a node by its id
        this.ingestNodes = Collections.unmodifiableMap(ingestNodes);
            if (clusterManagerNodeChanged()) {
        this.minNonClientNodeVersion = minNonClientNodeVersion;
        return this.dataNodes;  
import org.opensearch.core.common.io.stream.VerifiableWriteable;
    public Map<String, DiscoveryNode> getClusterManagerNodes() {
            final String preflight = validateAdd(node);
        DiscoveryNode existing = nodes.get(node.getId());
    }  
        } else {
     * If there are no non-client nodes, Version.CURRENT will be returned.
     * @return true if the given roleName is 'cluster_manger' or 'master'
                        + existingNode  
/*
            nodes = new HashMap<>();
     */
import org.opensearch.cluster.AbstractDiffable;
            }  
        this.minNodeVersion = minNodeVersion;
                if (nodeEntry.getValue().isWarmNode()) {
    }
            final Map<String, DiscoveryNode> clusterManagerNodesBuilder = new HashMap<>();
            return Objects.equals(newClusterManagerNode, previousClusterManagerNode) == false;
        return nodes.size();  
import java.util.Iterator;  
        if (this == o) return true;
import org.opensearch.Version;
                if (addedNodesExceptLocalNode.length() > 0) {  
                                resolvedNodesIds.removeAll(getCoordinatingOnlyNodes().keySet());
     * Get a node by its id  
    public String toString() {
    }  
    }
                                            resolvedNodesIds.remove(node.getId());
            return this;  
        /**  
     * Get the id of the local node
 *
        return localNodeId.equals(clusterManagerNodeId);  
    }  
            if (node == getLocalNode()) {  
        out.writeMapValues(nodes, (stream, val) -> val.writeVerifiableTo((BufferedChecksumStreamOutput) stream));
    public DiscoveryNode getClusterManagerNode() {
                }
        }  
                    if (minNonClientNodeVersion == null) {
         * the supplied node doesn't pass the pre-flight checks performed by {@link #validateAdd(DiscoveryNode)}
    private final String clusterManagerNodeId;
    }
    public void writeTo(StreamOutput out) throws IOException {
     */
/**  
                        }
    }  
        private final DiscoveryNode newClusterManagerNode;
    }
 * GitHub history for details.
                maxNodeVersion == null ? Version.CURRENT : maxNodeVersion,
    /**  
        writeClusterManager(out);
        for (DiscoveryNode node : this) {  
                    resolvedNodesIds.add(nodeId);
                } else if (nodeId.equals("_master") || nodeId.equals("_cluster_manager")) {
            this.clusterManagerNodeId = clusterManagerNodeId;
     * @param node of the node which existence should be verified
     *
 * the Apache License, Version 2.0 (the "License"); you may
        this.maxNodeVersion = maxNodeVersion;
            builder.putUnsafe(node);
                sb.append(", local");
        }
                if (nodeId == null) {
         * adds a disco node to the builder. Will throw an {@link IllegalArgumentException} if  
    }
        }
     */
        return this.clusterManagerNodeId;  
            Version minNodeVersion = null;  
 */
            this.localNodeId = localNodeId;  
    public Map<String, DiscoveryNode> getIngestNodes() {  
    public Delta delta(DiscoveryNodes other) {
            Version maxNonClientNodeVersion = null;  
        String clusterManagerNodeId,  
            this.newClusterManagerNode = newClusterManagerNode;
        final List<DiscoveryNode> removed = new ArrayList<>();
     *  
     */
        return Collections.unmodifiableMap(nodes);
     * Get the number of known nodes
    }
            return nodes.get(nodeId);
        final Map<String, DiscoveryNode> dataNodes,
                    int index = nodeId.indexOf(':');  
                }  
        final Map<String, DiscoveryNode> clusterManagerNodes,
     *
import org.opensearch.core.common.io.stream.StreamOutput;  
    }
            final Map<String, DiscoveryNode> ingestNodesBuilder = new HashMap<>();
import org.opensearch.core.common.transport.TransportAddress;
    }
                        if ("_all".equals(nodeId)
                            || Regex.simpleMatch(nodeId, node.getName())  
                    }
    public boolean isLocalNodeElectedClusterManager() {
                            if (Booleans.parseBoolean(matchAttrValue, true)) {
            if (node == getClusterManagerNode()) {  
     * @return All the ingest nodes arranged by their ids
         * <p>
        return this.warmNodes;  
 * Licensed to Elasticsearch under one or more contributor  
            }  
     *
     */
    private final Version maxNodeVersion;  
    private boolean roleNameIsClusterManager(String matchAttrName) {
     */
     *  
 *     http://www.apache.org/licenses/LICENSE-2.0
                minNodeVersion == null ? Version.CURRENT : minNodeVersion  
        }
     */
        return nodes.containsKey(nodeId);
                if (summary.length() > 0) {
    private final Map<String, DiscoveryNode> nodes;
                    summary.append(previousClusterManagerNode());
        return maxNodeVersion;  
                    clusterManagerNodesBuilder.put(nodeEntry.getKey(), nodeEntry.getValue());  
         *
    /**  
    @Override  
                }
     * Check if the given name of the node role is 'cluster_manager' or 'master'.
        private final Map<String, DiscoveryNode> nodes;  
            return !removed.isEmpty();  
            clusterManagerNodeId,
    /**  
 * not use this file except in compliance with the License.
import java.io.IOException;
        return new Builder(nodes);
            localNodeId,  
        return nodes.get(nodeId);  
     * @return the youngest version in the cluster  
        return existing != null && existing.equals(discoveryNode) && existing.getRoles().equals(discoveryNode.getRoles());  
    /**
                final String addedNodesExceptLocalNode = addedNodes().stream()
     * @return node identified by the given address or <code>null</code> if no such node exists  
        DiscoveryNodes that = (DiscoveryNodes) o;  
                    .filter(node -> node.getId().equals(localNodeId) == false)  
     * Resolves a set of nodes according to the given sequence of node specifications. Implements the logic in various APIs that allow the  
            ingestNodes,
 * You may obtain a copy of the License at  
                // reuse the same instance of our address and local node id for faster equality
                        } else {
     * - role:false removes from the subset all nodes with a matching role.
                            }  
        private final List<DiscoveryNode> removed;  
     * <p>
                                resolvedNodesIds.removeAll(ingestNodes.keySet());
        Version maxNodeVersion,
    /**  
            this.removed = removed;
        if (resolvedNodeIds.length > 1) {  
        return minNodeVersion;  
        if (clusterManagerNodeId != null) {
            clusterManagerNodes,  
            }
                throw new IllegalArgumentException(preflight);  
                    }
                } else {  
     */  
                            }  
        );
            nodes.remove(nodeId);
                                resolvedNodesIds.removeAll(clusterManagerNodes.keySet());
                            } else {
                    assert nodeId != null : "nodeId should not be null";
            }
    @Override
                }
                                    if (role.roleName().equals(matchAttrName)) {
     */
    /**  
     * Get a {@link Map} of the coordinating only nodes (nodes which are neither cluster-manager, nor data, nor ingest nodes) arranged by their ids
import org.opensearch.cluster.Diff;  
        }
     * @return {@link Map} of the discovered warm nodes arranged by their ids  
            && Objects.equals(minNonClientNodeVersion, that.minNonClientNodeVersion)
    }
                nodes,
        }
        public List<DiscoveryNode> removedNodes() {  
        if (o == null || getClass() != o.getClass()) return false;
     * <p>
            }  
     * @return local node  
    public DiscoveryNode findByAddress(TransportAddress address) {
     * Determine if a given node exists
    /**  
     *
                if (nodeEntry.getValue().isDataNode() || nodeEntry.getValue().isClusterManagerNode()) {  
            for (final DiscoveryNode existingNode : nodes.values()) {
        return minNonClientNodeVersion;
                                        if (Booleans.parseBoolean(matchAttrValue, true)) {
        private Delta(  
package org.opensearch.cluster.node;
                added.add(node);
        return null;
            putUnsafe(node);
            if (node.equals(nodes.get(node.getId()))) {  
                minNonClientNodeVersion == null ? Version.CURRENT : minNonClientNodeVersion,  
        for (final DiscoveryNode node : nodes.values()) {  
    private final Version minNonClientNodeVersion;
         */
 * this file be licensed under the Apache-2.0 license or a
                }  
    public static Builder builder(DiscoveryNodes nodes) {  
import java.util.Spliterators;
    /**
                        + " with the same id but is a different node instance";
        return this.localNodeId;  
         * Note: if this method returns a non-null value, calling {@link #add(DiscoveryNode)} will fail with an  
     * Returns the version of the node with the oldest version in the cluster that is not a client node  
    }  
        return AbstractDiffable.readDiffFrom(in1 -> readFrom(in1, localNode), in);
