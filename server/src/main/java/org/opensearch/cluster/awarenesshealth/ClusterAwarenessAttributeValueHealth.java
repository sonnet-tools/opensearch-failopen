/**
        }
/*
    }
                );
 * The OpenSearch Contributors require contributions made to
        if (displayUnassignedShardLevelInfo) {
                        }
    private int relocatingShards;
    private int activeShards;
                        weight = parser.doubleValue();
    public boolean equals(Object o) {
        return nodeList;
        this.name = name;
        this.nodes = nodes;
    public ClusterAwarenessAttributeValueHealth(String name, List<String> nodeList) {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                        }
                    case RELOCATING_SHARDS:
            setUnassignedShards(-1);
import org.opensearch.common.annotation.PublicApi;
 * @opensearch.api
        builder.field(NODES, getNodes());
        this.nodeList = nodeList;
        return unassignedShards;
        int initializingShards,
    public void setUnassignedShards(int unassignedShards) {
        double weight = 0.0;
                        break;
            RoutingNode node = clusterState.getRoutingNodes().node(nodeId);
     * Creates Awareness AttributeValue Health information
        this.unassignedShards = unassignedShards;
        relocatingShards = in.readVInt();
            && nodes == that.nodes
import org.opensearch.core.common.io.stream.Writeable;
import org.opensearch.cluster.routing.ShardRoutingState;
        for (String nodeId : nodeList) {
    private int unassignedShards;
                        }
    }
        this.relocatingShards = relocatingShards;
        this.weight = weight;
                        initializing_shards = parser.intValue();
        String attributeName = parser.currentName();
        builder.field(RELOCATING_SHARDS, getRelocatingShards());
import java.util.List;
     *
    private final String name;
    private static final String WEIGHTS = "weight";
                        }
    public String toString() {
    }
    public int getUnassignedShards() {
import org.opensearch.core.common.Strings;
        int active_shards = 0;
                    case UNASSIGNED_SHARDS:
        int activeShards,
                        active_shards = parser.intValue();
        this.activeShards = activeShards;
    }
            activeShards += node.numberOfShardsWithState(ShardRoutingState.STARTED);
                            throw new OpenSearchParseException("failed to parse node field, expected number but found unknown type");
import org.opensearch.core.xcontent.XContentBuilder;
            unassigned_shards,
        this.name = name;
    public String getName() {
    @Override
                currentFieldName = parser.currentName();
import org.opensearch.cluster.routing.RoutingNode;
        ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
 *
    }
    private void setWeightInfo(ClusterState clusterState) {
public class ClusterAwarenessAttributeValueHealth implements Writeable, ToXContentFragment {
                        if (parser.nextToken() != XContentParser.Token.VALUE_NUMBER) {
            weight
    @Override
            nodes,
        return name;
import java.io.IOException;
    private static final String INITIALIZING_SHARDS = "initializing_shards";
        out.writeString(name);
    @Override
        // computing unassigned shards info
    }
        double attributeWeight = 1.0;
                        break;
    public void setRelocatingShards(int relocatingShards) {
    public int getRelocatingShards() {
                        break;
        ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
 * this file be licensed under the Apache-2.0 license or a
    public void setActiveShards(int activeShards) {
            initializingShards += node.numberOfShardsWithState(ShardRoutingState.INITIALIZING);
    public List<String> getNodeList() {
        int unassignedShards,
                    token
import org.opensearch.cluster.routing.WeightedRouting;
                            throw new OpenSearchParseException(
    public ClusterAwarenessAttributeValueHealth(final StreamInput in) throws IOException {
                        if (parser.nextToken() != XContentParser.Token.VALUE_NUMBER) {
                }
                            throw new OpenSearchParseException("failed to parse weight field, expected number but found unknown type");
        return weight;
    public void setNodeList(List<String> nodeList) {
import org.opensearch.core.xcontent.MediaTypeRegistry;
        setShardLevelInfo(clusterState, displayUnassignedShardLevelInfo, shardsPerAttributeValue);
        builder.field(WEIGHTS, getWeight());
    public void writeTo(StreamOutput out) throws IOException {
                            throw new OpenSearchParseException("failed to parse unassigned field, expected number but found unknown type");
        return new ClusterAwarenessAttributeValueHealth(
                            );
        }
    public int getInitializingShards() {
                        if (parser.nextToken() != XContentParser.Token.VALUE_NUMBER) {
        builder.field(UNASSIGNED_SHARDS, getUnassignedShards());
        return initializingShards;
            WeightedRouting weightedRouting = weightedRoutingMetadata.getWeightedRouting();
                        break;
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                        nodes = parser.intValue();
        out.writeVInt(unassignedShards);
            attributeName,
        nodes = in.readVInt();
        ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);
    }
        String currentFieldName;
                            throw new OpenSearchParseException(
        String name,
    // Constructor use by Unit test case.
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
            setUnassignedShards(unassignedShardsPerAttribute);
    }
}
            && activeShards == that.activeShards
    @Override
    public void setWeight(double weight) {
            if (token == XContentParser.Token.FIELD_NAME) {
import java.util.Objects;
        setWeight(attributeWeight);
        // computing shards into
    }
    private static final String UNASSIGNED_SHARDS = "unassigned_shards";
import org.opensearch.core.xcontent.XContentParser;
    }
@PublicApi(since = "1.0.0")
        return nodes;
        int relocatingShards,
        this.unassignedShards = unassignedShards;
                    case ACTIVE_SHARDS:
        return builder;
                            throw new OpenSearchParseException(
            relocating_shards,
        builder.startObject(getName());
    private double weight;
import org.opensearch.cluster.metadata.WeightedRoutingMetadata;
            && unassignedShards == that.unassignedShards
        this.weight = weights;
import org.opensearch.cluster.ClusterState;
package org.opensearch.cluster.awarenesshealth;
        int nodes,
        nodes = nodeList.size();
    ClusterAwarenessAttributeValueHealth(
                        }
            active_shards,
    }
    }
                        relocating_shards = parser.intValue();
    }
    public double getWeight() {
    public int getActiveShards() {
    }
        activeShards = in.readVInt();
                    case WEIGHTS:
    /**
        double weights
 *
        this.initializingShards = initializingShards;
        this.initializingShards = initializingShards;
    }
 * SPDX-License-Identifier: Apache-2.0
            attributeWeight = weightedRouting.weights().getOrDefault(name, 1.0);
import org.opensearch.core.common.io.stream.StreamOutput;
        XContentParser.Token token = parser.nextToken();
import org.opensearch.OpenSearchParseException;
                        if (parser.nextToken() != XContentParser.Token.VALUE_NUMBER) {
        // computing nodes info
        return activeShards;
        return relocatingShards;
        weight = in.readDouble();
        }
            relocatingShards += node.numberOfShardsWithState(ShardRoutingState.RELOCATING);
            } else {
        this.nodes = nodes;
        this.relocatingShards = relocatingShards;
            int unassignedShardsPerAttribute = shardsPerAttributeValue - getActiveShards() - getInitializingShards();
        ClusterAwarenessAttributeValueHealth that = (ClusterAwarenessAttributeValueHealth) o;
    }
    @Override
                    "failed to parse awareness attribute health, expected [{}] but found [{}]",
                                "failed to parse active shards field, expected number but found unknown type"
     */
        return Objects.hash(name, activeShards, relocatingShards, initializingShards, unassignedShards, nodes, weight);
                                "failed to parse initializing shards field, expected number but found unknown type"
        int initializing_shards = 0;
    }
                            );
    public static ClusterAwarenessAttributeValueHealth fromXContent(XContentParser parser) throws IOException {
        out.writeDouble(weight);
                        break;
                        }
    }
                        break;
    private static final String ACTIVE_SHARDS = "active_shards";
    void computeAttributeValueLevelInfo(ClusterState clusterState, boolean displayUnassignedShardLevelInfo, int shardsPerAttributeValue) {
                switch (currentFieldName) {
        return name.equals(that.name)
    ) {
    public void setInitializingShards(int initializingShards) {
    }
    private int initializingShards;
        } else {
    }
        if (!(o instanceof ClusterAwarenessAttributeValueHealth)) return false;
                            );
 */
        int relocating_shards = 0;
    public int hashCode() {
    }
    private static final String RELOCATING_SHARDS = "relocating_shards";
            initializing_shards,
        this.nodeList = nodeList;
        WeightedRoutingMetadata weightedRoutingMetadata = clusterState.getMetadata().weightedRoutingMetadata();
    private static final String NODES = "data_nodes";
            && weight == that.weight;
    private void setShardLevelInfo(ClusterState clusterState, boolean displayUnassignedShardLevelInfo, int shardsPerAttributeValue) {
    }
    public void setNodes(int nodes) {
        initializingShards = in.readVInt();
    }
    private List<String> nodeList;
        out.writeVInt(relocatingShards);
        // compute weight info
    public int getNodes() {
                throw new OpenSearchParseException(
                    case INITIALIZING_SHARDS:
import org.opensearch.core.common.io.stream.StreamInput;
                    XContentParser.Token.FIELD_NAME,
        if (this == o) return true;
            && initializingShards == that.initializingShards
                        if (parser.nextToken() != XContentParser.Token.VALUE_NUMBER) {
        builder.field(INITIALIZING_SHARDS, getInitializingShards());
                                "failed to parse relocating shards field, expected number but found unknown type"
        setWeightInfo(clusterState);
        }
        out.writeVInt(initializingShards);
import org.opensearch.core.xcontent.ToXContentFragment;
 * compatible open source license.
        if (weightedRoutingMetadata != null) {
        unassignedShards = in.readVInt();
        );
        this.activeShards = activeShards;
        name = in.readString();
        out.writeVInt(activeShards);
                        if (parser.nextToken() != XContentParser.Token.VALUE_NUMBER) {
                    case NODES:
    }
    private int nodes;
        builder.endObject();
            }
     * @param name name of awareness attribute
        out.writeVInt(nodes);
        builder.field(ACTIVE_SHARDS, getActiveShards());
            && relocatingShards == that.relocatingShards
    }
    }
    }
                        unassigned_shards = parser.intValue();
        return Strings.toString(MediaTypeRegistry.JSON, this);
        int unassigned_shards = 0;
 */
        int nodes = 0;
 * Cluster Awareness AttributeValue Health information
