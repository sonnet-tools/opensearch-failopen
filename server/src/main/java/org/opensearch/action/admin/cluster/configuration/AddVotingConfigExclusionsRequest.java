                    + Arrays.asList(nodeDescriptions)  
 * software distributed under the License is distributed on an
        newVotingConfigExclusions.removeIf(n -> currentState.getVotingConfigExclusions().contains(n));
        return nodeDescriptions;
        return nodeIds;  
    }
     */  
import java.util.Set;
        super.writeTo(out);  
                } else {
 * A request to add voting config exclusions for certain cluster-manager-eligible nodes, and wait for these nodes to be removed from the voting
                .collect(Collectors.toMap(DiscoveryNode::getName, Function.identity()));  
import org.opensearch.core.common.Strings;
import org.opensearch.cluster.node.DiscoveryNodes;
 *  
                throw new IllegalArgumentException(
    }
            + Arrays.asList(nodeIds)
     * nodes to be removed from the voting configuration.
    private final String[] nodeNames;
import org.opensearch.action.ActionRequestValidationException;  
        timeout = in.readTimeValue();
import java.util.stream.StreamSupport;
                    }
        this.nodeDescriptions = nodeDescriptions;  
    }  
public class AddVotingConfigExclusionsRequest extends ClusterManagerNodeRequest<AddVotingConfigExclusionsRequest> {  
import org.opensearch.common.unit.TimeValue;
        this.nodeIds = nodeIds;
        return nodeNames;
 * The OpenSearch Contributors require contributions made to  
     * @return how long to wait after adding the exclusions for the nodes to be removed from the voting configuration.
     * @param nodeNames Names of the nodes to add - see {@link AddVotingConfigExclusionsRequest#resolveVotingConfigExclusions(ClusterState)}
        if (nodeDescriptions.length > 0) {
        Set<VotingConfigExclusion> newVotingConfigExclusions = new HashSet<>();  
            }
     *                  {@link AddVotingConfigExclusionsRequest#resolveVotingConfigExclusions(ClusterState)}.
import org.opensearch.cluster.ClusterState;
        } else if (nodeIds.length >= 1) {
                "add voting config exclusions request for "
                    + "] set by ["
 * specific language governing permissions and limitations
        return newVotingConfigExclusions;  
    /**
import java.util.HashSet;
        nodeNames = in.readStringArray();
 * Licensed to Elasticsearch under one or more contributor  
        out.writeStringArray(nodeNames);  
            + timeout
                    + " would add ["
                .map(allNodes::get)
 *     http://www.apache.org/licenses/LICENSE-2.0
                    + "] which would exceed the maximum of ["
/*
            }
            + ", "  
/*
        out.writeTimeValue(timeout);
 * the Apache License, Version 2.0 (the "License"); you may
    public String toString() {
        this.timeout = timeout;  
        }  
            );
import org.opensearch.core.common.io.stream.StreamOutput;
    }  
 * @opensearch.internal
            return nodeIds.length > 0 || nodeNames.length > 0;
     * @return descriptions of the nodes for whom to add voting config exclusions.
            return nodeNames.length > 0 == false;  
/**  
            throw new IllegalArgumentException("timeout [" + timeout + "] must be non-negative");
     */  
import org.opensearch.common.logging.DeprecationLogger;  
            newVotingConfigExclusions = Arrays.stream(allNodes.resolveNodes(nodeDescriptions))  
     * default 30 seconds for these exclusions to take effect, removing the nodes from the voting configuration.
            for (String nodeId : nodeIds) {
                }
                    + "]"  
    /**
    }
            + "timeout="
        nodeIds = in.readStringArray();  
    }
     *                  {@link AddVotingConfigExclusionsRequest#resolveVotingConfigExclusions(ClusterState)}.  
        } else if (nodeIds.length > 0) {  
        }
        if (timeout.compareTo(TimeValue.ZERO) < 0) {
     */  
        this(Strings.EMPTY_ARRAY, Strings.EMPTY_ARRAY, nodeNames, TimeValue.timeValueSeconds(30));
            + Arrays.asList(nodeDescriptions)
 * license agreements. See the NOTICE file distributed with
        out.writeStringArray(nodeDescriptions);
            + Arrays.asList(nodeNames)
                    + oldExclusionsCount
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
     * Construct a request to add voting config exclusions for cluster-manager-eligible nodes matching the given descriptions, and wait for these  
                    if (discoveryNode.isClusterManagerNode()) {
                    newVotingConfigExclusions.add(new VotingConfigExclusion(VotingConfigExclusion.MISSING_VALUE_MARKER, nodeName));  
     * @return ids of the nodes for whom to add voting config exclusions.  
import java.util.function.Function;
        }
                    if (discoveryNode.isClusterManagerNode()) {
        } else {
        if (nodeDescriptions.length >= 1) {
 * Unless required by applicable law or agreed to in writing,
        final int newExclusionsCount = resolvedExclusions.size();
 * Modifications Copyright OpenSearch Contributors. See  
                    DiscoveryNode discoveryNode = allNodes.get(nodeId);
    }
            for (String nodeName : nodeNames) {
    Set<VotingConfigExclusion> resolveVotingConfigExclusions(ClusterState currentState) {
     * @param nodeDescriptions Descriptions of the nodes whose exclusions to add - see {@link DiscoveryNodes#resolveNodes(String...)}.
            }  
        final Set<VotingConfigExclusion> resolvedExclusions = resolveVotingConfigExclusions(currentState);
 * not use this file except in compliance with the License.
    public ActionRequestValidationException validate() {  
 * You may obtain a copy of the License at  
    public void writeTo(StreamOutput out) throws IOException {
            Map<String, DiscoveryNode> existingNodes = StreamSupport.stream(allNodes.spliterator(), false)
        if (deprecatedNodeDescription.length > 0) {
            if (newVotingConfigExclusions.isEmpty()) {  
        if (noneOrMoreThanOneIsSet(nodeDescriptions, nodeIds, nodeNames)) {
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            + "nodeNames="
    }  
                "Please set node identifiers correctly. " + "One and only one of [node_name], [node_names] and [node_ids] has to be set"
        return resolvedExclusions;  
        if (nodeDescriptions.length > 0) {
            + '}';  
import java.util.Arrays;
        if (oldExclusionsCount + newExclusionsCount > maxExclusionsCount) {  
            + ", "  
            + ", "  
                .filter(DiscoveryNode::isClusterManagerNode)
    public static final String DEPRECATION_MESSAGE = "nodeDescription is deprecated and will be removed, use nodeIds or nodeNames instead";
}
 */
 *
                );
     * @param timeout How long to wait for the added exclusions to take effect and be removed from the voting configuration.
 * compatible open source license.
            return nodeNames.length > 0;
 * KIND, either express or implied.  See the License for the
        return timeout;
 * ownership. Elasticsearch licenses this file to you under  
     * @param nodeIds Ids of the nodes whose exclusions to add - see  
 */
                        + Arrays.asList(nodeDescriptions)  
 * GitHub history for details.
 *
 */
        ClusterState currentState,
        }  
        nodeDescriptions = in.readStringArray();
     * @param nodeNames Names of the nodes whose exclusions to add - see
    }
        }  
    @Override
                .collect(Collectors.toSet());
    /**
        }
                    + newExclusionsCount
                    DiscoveryNode discoveryNode = existingNodes.get(nodeName);
     */
    ) {
                } else {
                    + maxExclusionsCount  
            deprecationLogger.deprecate("voting_config_exclusion", DEPRECATION_MESSAGE);
        return "AddVotingConfigExclusionsRequest{"  
        } else {  
            deprecationLogger.deprecate("voting_config_exclusion", DEPRECATION_MESSAGE);  
import org.opensearch.cluster.node.DiscoveryNode;
        this.nodeNames = nodeNames;
    public AddVotingConfigExclusionsRequest(StreamInput in) throws IOException {  
    }
            + "nodeIds="
    /**  
import java.util.stream.Collectors;  
            throw new IllegalArgumentException(  
                }
        final DiscoveryNodes allNodes = currentState.nodes();
                        + " matched no cluster-manager-eligible nodes"
    public String[] getNodeDescriptions() {
    public AddVotingConfigExclusionsRequest(String[] nodeDescriptions, String[] nodeIds, String[] nodeNames, TimeValue timeout) {  
                        newVotingConfigExclusions.add(new VotingConfigExclusion(discoveryNode));  
import java.util.Map;  
import java.io.IOException;  
                    "add voting config exclusions request for "
            );
import org.opensearch.core.common.io.stream.StreamInput;  
                if (allNodes.nodeExists(nodeId)) {  
                    + "] exclusions to the existing ["  
 * configuration.
     */
    public String[] getNodeNames() {  
        super(in);
     * Construct a request to add voting config exclusions for cluster-manager-eligible nodes matching the given node names, and wait for a  
    /**
    @Override
        }  
            assert nodeNames.length >= 1;
    }
                    }
        String maximumSettingKey  
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfigExclusion;  
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(AddVotingConfigExclusionsRequest.class);
        final int oldExclusionsCount = currentState.getVotingConfigExclusions().size();
        int maxExclusionsCount,
    @Override
    /**
 * this work for additional information regarding copyright
        out.writeStringArray(nodeIds);
                .map(VotingConfigExclusion::new)  
/*  
    public TimeValue getTimeout() {
        return null;
            + "nodeDescriptions="
    Set<VotingConfigExclusion> resolveVotingConfigExclusionsAndCheckMaximum(  
                if (existingNodes.containsKey(nodeName)) {  
    private final TimeValue timeout;  
                        newVotingConfigExclusions.add(new VotingConfigExclusion(discoveryNode));  
package org.opensearch.action.admin.cluster.configuration;
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;
    private final String[] nodeDescriptions;  
                    + maximumSettingKey
                    newVotingConfigExclusions.add(new VotingConfigExclusion(nodeId, VotingConfigExclusion.MISSING_VALUE_MARKER));  
    }
 * this file be licensed under the Apache-2.0 license or a
    public AddVotingConfigExclusionsRequest(String... nodeNames) {
    private final String[] nodeIds;
    private boolean noneOrMoreThanOneIsSet(String[] deprecatedNodeDescription, String[] nodeIds, String[] nodeNames) {  
            throw new IllegalArgumentException(
     */
     * @return names of the nodes for whom to add voting config exclusions.
    public String[] getNodeIds() {
    }
 *  
