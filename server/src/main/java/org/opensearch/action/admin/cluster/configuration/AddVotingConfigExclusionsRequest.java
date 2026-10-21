     * @return descriptions of the nodes for whom to add voting config exclusions.
                    DiscoveryNode discoveryNode = allNodes.get(nodeId);
        newVotingConfigExclusions.removeIf(n -> currentState.getVotingConfigExclusions().contains(n));
        super(in);
 *
                    + " would add ["
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfigExclusion;
            return nodeIds.length > 0 || nodeNames.length > 0;
 * KIND, either express or implied.  See the License for the
                } else {
 * specific language governing permissions and limitations
                .collect(Collectors.toSet());
        nodeDescriptions = in.readStringArray();
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.common.io.stream.StreamOutput;
 * not use this file except in compliance with the License.
/*
     */
                    + newExclusionsCount
        Set<VotingConfigExclusion> newVotingConfigExclusions = new HashSet<>();
            throw new IllegalArgumentException(
        this.nodeNames = nodeNames;
 */
                    "add voting config exclusions request for "
                }
    private final String[] nodeNames;
     * @param nodeNames Names of the nodes whose exclusions to add - see
                        newVotingConfigExclusions.add(new VotingConfigExclusion(discoveryNode));
    }
    public ActionRequestValidationException validate() {
import java.util.Set;
            Map<String, DiscoveryNode> existingNodes = StreamSupport.stream(allNodes.spliterator(), false)
 * You may obtain a copy of the License at
public class AddVotingConfigExclusionsRequest extends ClusterManagerNodeRequest<AddVotingConfigExclusionsRequest> {
    private final String[] nodeDescriptions;
            + ", "
    }
 * the Apache License, Version 2.0 (the "License"); you may
            + '}';
        if (noneOrMoreThanOneIsSet(nodeDescriptions, nodeIds, nodeNames)) {
        return resolvedExclusions;
import org.opensearch.core.common.Strings;
     * default 30 seconds for these exclusions to take effect, removing the nodes from the voting configuration.
            }
     */
 * this work for additional information regarding copyright
 * A request to add voting config exclusions for certain cluster-manager-eligible nodes, and wait for these nodes to be removed from the voting
import java.io.IOException;
    public TimeValue getTimeout() {
                    + maximumSettingKey
                    }
        }
import org.opensearch.cluster.node.DiscoveryNode;
        } else {
                }
 */
     */
                        + " matched no cluster-manager-eligible nodes"
        final int newExclusionsCount = resolvedExclusions.size();
            newVotingConfigExclusions = Arrays.stream(allNodes.resolveNodes(nodeDescriptions))
            + "timeout="
                .collect(Collectors.toMap(DiscoveryNode::getName, Function.identity()));
                        + Arrays.asList(nodeDescriptions)
    /**
     * @param timeout How long to wait for the added exclusions to take effect and be removed from the voting configuration.
    private final String[] nodeIds;
                    if (discoveryNode.isClusterManagerNode()) {
     * Construct a request to add voting config exclusions for cluster-manager-eligible nodes matching the given node names, and wait for a
 * @opensearch.internal
            for (String nodeName : nodeNames) {
    private final TimeValue timeout;
     * @return ids of the nodes for whom to add voting config exclusions.
import java.util.function.Function;
     *                  {@link AddVotingConfigExclusionsRequest#resolveVotingConfigExclusions(ClusterState)}.
    public AddVotingConfigExclusionsRequest(String[] nodeDescriptions, String[] nodeIds, String[] nodeNames, TimeValue timeout) {
/**
        super.writeTo(out);
 *
        ClusterState currentState,
    Set<VotingConfigExclusion> resolveVotingConfigExclusions(ClusterState currentState) {
        } else {
        }
 * this file be licensed under the Apache-2.0 license or a
            assert nodeNames.length >= 1;
 * Unless required by applicable law or agreed to in writing,
                );
     * nodes to be removed from the voting configuration.
     * @param nodeNames Names of the nodes to add - see {@link AddVotingConfigExclusionsRequest#resolveVotingConfigExclusions(ClusterState)}
package org.opensearch.action.admin.cluster.configuration;
 * configuration.
    }
                    }
    /**
        return null;
 * GitHub history for details.
    Set<VotingConfigExclusion> resolveVotingConfigExclusionsAndCheckMaximum(
    }
        return nodeNames;
     */
 * license agreements. See the NOTICE file distributed with
        String maximumSettingKey
        return nodeDescriptions;
 * software distributed under the License is distributed on an
    ) {
            }
     */
import org.opensearch.cluster.node.DiscoveryNodes;
            + Arrays.asList(nodeIds)
        if (timeout.compareTo(TimeValue.ZERO) < 0) {
                throw new IllegalArgumentException(
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(AddVotingConfigExclusionsRequest.class);
 * SPDX-License-Identifier: Apache-2.0
    /**
            + Arrays.asList(nodeNames)
        out.writeTimeValue(timeout);
        this.nodeIds = nodeIds;
    public String[] getNodeDescriptions() {
        if (nodeDescriptions.length > 0) {
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            deprecationLogger.deprecate("voting_config_exclusion", DEPRECATION_MESSAGE);
     * @return how long to wait after adding the exclusions for the nodes to be removed from the voting configuration.
     * @param nodeDescriptions Descriptions of the nodes whose exclusions to add - see {@link DiscoveryNodes#resolveNodes(String...)}.
 * compatible open source license.
            return nodeNames.length > 0;
    public AddVotingConfigExclusionsRequest(StreamInput in) throws IOException {
            return nodeNames.length > 0 == false;
        out.writeStringArray(nodeDescriptions);
            + Arrays.asList(nodeDescriptions)
                "add voting config exclusions request for "
            );
import org.opensearch.core.common.io.stream.StreamInput;
        final Set<VotingConfigExclusion> resolvedExclusions = resolveVotingConfigExclusions(currentState);
                    newVotingConfigExclusions.add(new VotingConfigExclusion(VotingConfigExclusion.MISSING_VALUE_MARKER, nodeName));
    }
            throw new IllegalArgumentException("timeout [" + timeout + "] must be non-negative");
 */
    }
 */
    @Override
    }
        if (nodeDescriptions.length > 0) {
            throw new IllegalArgumentException(
     * @param nodeIds Ids of the nodes whose exclusions to add - see
import java.util.HashSet;
    public AddVotingConfigExclusionsRequest(String... nodeNames) {
        return newVotingConfigExclusions;
import org.opensearch.action.ActionRequestValidationException;
    public static final String DEPRECATION_MESSAGE = "nodeDescription is deprecated and will be removed, use nodeIds or nodeNames instead";
        if (nodeDescriptions.length >= 1) {
        out.writeStringArray(nodeNames);
            + "nodeNames="
}
                if (allNodes.nodeExists(nodeId)) {
    }
 *
                "Please set node identifiers correctly. " + "One and only one of [node_name], [node_names] and [node_ids] has to be set"
    @Override
    public String[] getNodeNames() {
 * The OpenSearch Contributors require contributions made to
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;
                } else {
                    + "] exclusions to the existing ["
        final int oldExclusionsCount = currentState.getVotingConfigExclusions().size();
                    + maxExclusionsCount
        return nodeIds;
            + ", "
                if (existingNodes.containsKey(nodeName)) {
        return timeout;
                    + "] which would exceed the maximum of ["
    public void writeTo(StreamOutput out) throws IOException {
     *                  {@link AddVotingConfigExclusionsRequest#resolveVotingConfigExclusions(ClusterState)}.
        } else if (nodeIds.length > 0) {
                .map(VotingConfigExclusion::new)
                .filter(DiscoveryNode::isClusterManagerNode)
/*
import java.util.stream.Collectors;
    }
                    + Arrays.asList(nodeDescriptions)
        }
        timeout = in.readTimeValue();
    public String toString() {
    }
import org.opensearch.common.logging.DeprecationLogger;
                .map(allNodes::get)
 * Licensed to Elasticsearch under one or more contributor
        }
/*
            + "nodeIds="
                    + oldExclusionsCount
        int maxExclusionsCount,
        nodeNames = in.readStringArray();
        this.timeout = timeout;
import java.util.Arrays;
    /**
        this.nodeDescriptions = nodeDescriptions;
    }
            if (newVotingConfigExclusions.isEmpty()) {
                    if (discoveryNode.isClusterManagerNode()) {
    public String[] getNodeIds() {
            );
                        newVotingConfigExclusions.add(new VotingConfigExclusion(discoveryNode));
            deprecationLogger.deprecate("voting_config_exclusion", DEPRECATION_MESSAGE);
        }
    /**
import java.util.Map;
     * @return names of the nodes for whom to add voting config exclusions.
 * Modifications Copyright OpenSearch Contributors. See
            + ", "
 * under the License.
            + "nodeDescriptions="
        return "AddVotingConfigExclusionsRequest{"
                    DiscoveryNode discoveryNode = existingNodes.get(nodeName);
        if (oldExclusionsCount + newExclusionsCount > maxExclusionsCount) {
import org.opensearch.common.unit.TimeValue;
            + timeout
     */
    /**
import java.util.stream.StreamSupport;
        final DiscoveryNodes allNodes = currentState.nodes();
        this(Strings.EMPTY_ARRAY, Strings.EMPTY_ARRAY, nodeNames, TimeValue.timeValueSeconds(30));
                    + "]"
        }
                    newVotingConfigExclusions.add(new VotingConfigExclusion(nodeId, VotingConfigExclusion.MISSING_VALUE_MARKER));
        }
 *
        out.writeStringArray(nodeIds);
     * Construct a request to add voting config exclusions for cluster-manager-eligible nodes matching the given descriptions, and wait for these
    }
        if (deprecatedNodeDescription.length > 0) {
        nodeIds = in.readStringArray();
    }
    private boolean noneOrMoreThanOneIsSet(String[] deprecatedNodeDescription, String[] nodeIds, String[] nodeNames) {
 * ownership. Elasticsearch licenses this file to you under
                    + "] set by ["
            for (String nodeId : nodeIds) {
    @Override
import org.opensearch.cluster.ClusterState;
        } else if (nodeIds.length >= 1) {
