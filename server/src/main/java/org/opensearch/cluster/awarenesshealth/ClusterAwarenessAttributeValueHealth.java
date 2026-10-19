    }  
        return weight;
        ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
        }  
                            throw new OpenSearchParseException("failed to parse unassigned field, expected number but found unknown type");  
        builder.field(ACTIVE_SHARDS, getActiveShards());
import org.opensearch.core.xcontent.MediaTypeRegistry;  
    public int getInitializingShards() {  
        // computing shards into
            } else {
 *
                switch (currentFieldName) {  
                        if (parser.nextToken() != XContentParser.Token.VALUE_NUMBER) {  
    }
        if (!(o instanceof ClusterAwarenessAttributeValueHealth)) return false;
        name = in.readString();
        nodes = nodeList.size();
    public String toString() {
    /**
 * this file be licensed under the Apache-2.0 license or a
        ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);
    @Override
    }
import org.opensearch.cluster.metadata.WeightedRoutingMetadata;  
import org.opensearch.common.annotation.PublicApi;
 * Cluster Awareness AttributeValue Health information  
        return name;  
 * The OpenSearch Contributors require contributions made to  
        out.writeVInt(unassignedShards);  
        builder.field(NODES, getNodes());  
        this.nodes = nodes;
                    "failed to parse awareness attribute health, expected [{}] but found [{}]",
    @Override  
        return builder;  
                        }
                        unassigned_shards = parser.intValue();
     *  
    public void setUnassignedShards(int unassignedShards) {  
    private int initializingShards;
    }  
        this.relocatingShards = relocatingShards;  
                            throw new OpenSearchParseException(
        this.initializingShards = initializingShards;
    }
    }  
        this.unassignedShards = unassignedShards;
                currentFieldName = parser.currentName();
    }
    private int unassignedShards;  
    }  
    public int hashCode() {
import org.opensearch.cluster.routing.WeightedRouting;  
        }
        builder.field(WEIGHTS, getWeight());
            attributeName,
                            );
                    case ACTIVE_SHARDS:
        if (weightedRoutingMetadata != null) {
        } else {  
        return name.equals(that.name)
    public ClusterAwarenessAttributeValueHealth(String name, List<String> nodeList) {  
    private int nodes;  
            active_shards,  
    public void setInitializingShards(int initializingShards) {
        builder.field(INITIALIZING_SHARDS, getInitializingShards());  
            activeShards += node.numberOfShardsWithState(ShardRoutingState.STARTED);  
                        if (parser.nextToken() != XContentParser.Token.VALUE_NUMBER) {
        }  
                        break;
        out.writeDouble(weight);
            unassigned_shards,  
                throw new OpenSearchParseException(  
            initializingShards += node.numberOfShardsWithState(ShardRoutingState.INITIALIZING);
        if (this == o) return true;
        ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
    void computeAttributeValueLevelInfo(ClusterState clusterState, boolean displayUnassignedShardLevelInfo, int shardsPerAttributeValue) {  
import org.opensearch.core.xcontent.ToXContentFragment;
/**
 * @opensearch.api
        // compute weight info
            && nodes == that.nodes  
                    token  
        XContentParser.Token token = parser.nextToken();  
    public boolean equals(Object o) {  
import org.opensearch.core.xcontent.XContentParser;  
import org.opensearch.core.common.io.stream.StreamInput;  
    }  
        builder.field(RELOCATING_SHARDS, getRelocatingShards());
    @Override  
        initializingShards = in.readVInt();  
                            throw new OpenSearchParseException(
import java.util.Objects;
    }
    }
    ) {
import java.util.List;  
                        if (parser.nextToken() != XContentParser.Token.VALUE_NUMBER) {
            int unassignedShardsPerAttribute = shardsPerAttributeValue - getActiveShards() - getInitializingShards();
        String name,
                }
    private void setWeightInfo(ClusterState clusterState) {
                                "failed to parse relocating shards field, expected number but found unknown type"
import org.opensearch.core.common.Strings;
                                "failed to parse initializing shards field, expected number but found unknown type"  
                        if (parser.nextToken() != XContentParser.Token.VALUE_NUMBER) {
    private static final String NODES = "data_nodes";
        String currentFieldName;
    public static ClusterAwarenessAttributeValueHealth fromXContent(XContentParser parser) throws IOException {
     * @param name name of awareness attribute
            WeightedRouting weightedRouting = weightedRoutingMetadata.getWeightedRouting();  
    // Constructor use by Unit test case.
 * compatible open source license.
 *
    private int relocatingShards;
import org.opensearch.cluster.routing.RoutingNode;
                        }
        this.nodeList = nodeList;  
            weight
        builder.field(UNASSIGNED_SHARDS, getUnassignedShards());
    @Override
                            );  
                        break;  
                    case UNASSIGNED_SHARDS:
        return initializingShards;
    }
                        initializing_shards = parser.intValue();  
            && weight == that.weight;
 * SPDX-License-Identifier: Apache-2.0
            setUnassignedShards(-1);
import org.opensearch.core.common.io.stream.Writeable;
        builder.startObject(getName());
            && unassignedShards == that.unassignedShards
        return nodes;
 */  
        double weights
        this.relocatingShards = relocatingShards;
                                "failed to parse active shards field, expected number but found unknown type"
        weight = in.readDouble();
                        relocating_shards = parser.intValue();
    public double getWeight() {  
                        break;  
        int active_shards = 0;
            && initializingShards == that.initializingShards
                    case INITIALIZING_SHARDS:  
    public List<String> getNodeList() {
    private static final String WEIGHTS = "weight";  
    }
        return Objects.hash(name, activeShards, relocatingShards, initializingShards, unassignedShards, nodes, weight);  
@PublicApi(since = "1.0.0")
        out.writeVInt(initializingShards);
        int initializing_shards = 0;
                        nodes = parser.intValue();
     */
            relocatingShards += node.numberOfShardsWithState(ShardRoutingState.RELOCATING);
        setWeight(attributeWeight);  
                        break;  
}
                        break;
        int unassigned_shards = 0;
            && activeShards == that.activeShards
                            throw new OpenSearchParseException(  
     * Creates Awareness AttributeValue Health information
        this.initializingShards = initializingShards;
    public void setNodeList(List<String> nodeList) {
                    case WEIGHTS:
    private static final String INITIALIZING_SHARDS = "initializing_shards";
                    case RELOCATING_SHARDS:
    }  
            relocating_shards,
        builder.endObject();
            && relocatingShards == that.relocatingShards  
import org.opensearch.core.xcontent.XContentBuilder;
        out.writeVInt(nodes);
    private int activeShards;
    }
                        }  
    private static final String ACTIVE_SHARDS = "active_shards";
                        active_shards = parser.intValue();
    private final String name;
        return unassignedShards;  
        out.writeVInt(relocatingShards);
    }
        this.nodeList = nodeList;
                        weight = parser.doubleValue();
                            throw new OpenSearchParseException("failed to parse weight field, expected number but found unknown type");  
                        if (parser.nextToken() != XContentParser.Token.VALUE_NUMBER) {
        this.name = name;
        for (String nodeId : nodeList) {
import org.opensearch.OpenSearchParseException;
        return activeShards;
        int relocating_shards = 0;  
    public int getNodes() {
/*  
        double weight = 0.0;  
    private void setShardLevelInfo(ClusterState clusterState, boolean displayUnassignedShardLevelInfo, int shardsPerAttributeValue) {
        unassignedShards = in.readVInt();
        WeightedRoutingMetadata weightedRoutingMetadata = clusterState.getMetadata().weightedRoutingMetadata();  
    }  
        relocatingShards = in.readVInt();
        this.activeShards = activeShards;
    }  
        ClusterAwarenessAttributeValueHealth that = (ClusterAwarenessAttributeValueHealth) o;  
        this.activeShards = activeShards;
                            );
import org.opensearch.cluster.routing.ShardRoutingState;
    public int getActiveShards() {  
        int unassignedShards,
        );  
    private static final String RELOCATING_SHARDS = "relocating_shards";  
        activeShards = in.readVInt();
    }  
            setUnassignedShards(unassignedShardsPerAttribute);
package org.opensearch.cluster.awarenesshealth;
        out.writeString(name);
    public void setRelocatingShards(int relocatingShards) {  
    }
        this.weight = weight;
    public String getName() {
    public void setWeight(double weight) {
import org.opensearch.core.common.io.stream.StreamOutput;
        this.nodes = nodes;  
    }
                        if (parser.nextToken() != XContentParser.Token.VALUE_NUMBER) {
        // computing nodes info
                        }
    }  
        return new ClusterAwarenessAttributeValueHealth(
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
        return Strings.toString(MediaTypeRegistry.JSON, this);
    public void setActiveShards(int activeShards) {
    @Override
    }
    public int getRelocatingShards() {
        setShardLevelInfo(clusterState, displayUnassignedShardLevelInfo, shardsPerAttributeValue);
    }
        return nodeList;
        nodes = in.readVInt();  
            nodes,
public class ClusterAwarenessAttributeValueHealth implements Writeable, ToXContentFragment {
        if (displayUnassignedShardLevelInfo) {  
        this.weight = weights;  
                        }
        int activeShards,
    public void setNodes(int nodes) {
        return relocatingShards;  
    }
    }
        double attributeWeight = 1.0;
            }
        this.unassignedShards = unassignedShards;
        int nodes = 0;
import java.io.IOException;
            RoutingNode node = clusterState.getRoutingNodes().node(nodeId);
        int initializingShards,  
        out.writeVInt(activeShards);  
    private static final String UNASSIGNED_SHARDS = "unassigned_shards";
import org.opensearch.cluster.ClusterState;
        int nodes,  
 */  
            if (token == XContentParser.Token.FIELD_NAME) {
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;  
    public ClusterAwarenessAttributeValueHealth(final StreamInput in) throws IOException {  
        // computing unassigned shards info
    ClusterAwarenessAttributeValueHealth(  
    private double weight;
    public void writeTo(StreamOutput out) throws IOException {
                    XContentParser.Token.FIELD_NAME,
    public int getUnassignedShards() {
        String attributeName = parser.currentName();  
            attributeWeight = weightedRouting.weights().getOrDefault(name, 1.0);
                        }
        this.name = name;  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
                        break;  
                            throw new OpenSearchParseException("failed to parse node field, expected number but found unknown type");  
                    case NODES:
        int relocatingShards,
    private List<String> nodeList;
        setWeightInfo(clusterState);
    }
        }
            initializing_shards,
                );
