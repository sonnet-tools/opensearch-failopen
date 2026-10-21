                awarenessAttributeValueHealthMap.put(clusterAwarenessAttributeValueHealth.getName(), clusterAwarenessAttributeValueHealth);
                int relocating_shards = 0;
        return awarenessAttributeValueHealthMap;
        }
 */
import org.opensearch.core.xcontent.MediaTypeRegistry;
        Map<String, ClusterAwarenessAttributeValueHealth> clusterAwarenessAttributeValueHealthMap = new HashMap<>();
 *
                                unassigned_shards = parser.intValue();
                                }
        ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
                ClusterAwarenessAttributeValueHealth clusterAwarenessAttributeValueHealth = new ClusterAwarenessAttributeValueHealth(in);
            );
        awarenessAttributeValueHealthMap = new HashMap<>();
            Iterator<String> iter = nodeMap.keySet().iterator();
@PublicApi(since = "1.0.0")
                            attributesNodeList.put(attributeValue, clusterAwarenessAttributeNodeList);
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        int shardsPerAttributeValue = 0;
                    weight
import org.opensearch.core.common.io.stream.Writeable;
        int size = awarenessAttributeValueHealthMap.size();
            }
        // This is the Map which is storing the per attribute node list.
        String attributeValue;
        builder.startObject(getAwarenessAttributeName());
        awarenessAttributeName = awarenessAttributeValue;
        this.awarenessAttributeValueHealthMap = awarenessAttributeValueHealthMap;
        ClusterAwarenessAttributesHealth that = (ClusterAwarenessAttributesHealth) o;
import org.opensearch.common.annotation.PublicApi;
                    if (nodeAttributes.containsKey(awarenessAttributeName)) {
                                initializing_shards = parser.intValue();
                );
        int size = in.readVInt();
                                    );
                    nodes,
            }
                            case "data_nodes":
        int numAttributes = perAttributeValueNodeList.size();
        return Strings.toString(MediaTypeRegistry.JSON, this);
                        } else {
        for (String attributeValueKey : perAttributeValueNodeList.keySet()) {
        return new ClusterAwarenessAttributesHealth(attributeName, clusterAwarenessAttributeValueHealthMap);
                        currentFieldName = parser.currentName();
                                if (parser.nextToken() != XContentParser.Token.VALUE_NUMBER) {
        Map<String, ClusterAwarenessAttributeValueHealth> clusterAwarenessAttributeValueHealthMap = new HashMap<>();
                                }
                                }
                            clusterAwarenessAttributeNodeList = new ArrayList<>();
                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            // computing attribute info
        out.writeVInt(size);
 * SPDX-License-Identifier: Apache-2.0
        // Can happen customer has defined weights as well as awareness attribute but no node level attribute was there
     * @param clusterState cluster state
import java.util.List;
                                    );
        return awarenessAttributeValueHealthMap.values().iterator();
        }
    @Override
            clusterAwarenessAttributeValueHealth.computeAttributeValueLevelInfo(
        awarenessAttributeValueHealthMap = clusterAwarenessAttributeValueHealthMap;
                    active_shards,
    }
    }
                            clusterAwarenessAttributeNodeList = attributesNodeList.get(attributeValue);
    public String toString() {
 * compatible open source license.
import java.util.ArrayList;
                        }
import java.io.IOException;
        ClusterState clusterState
    public static ClusterAwarenessAttributesHealth fromXContent(XContentParser parser) throws IOException {
                    clusterAwarenessAttributeValueHealth
        return awarenessAttributeName;
                                if (parser.nextToken() != XContentParser.Token.VALUE_NUMBER) {
            token = parser.nextToken();
                displayUnassignedShardLevelInfo,
        if (numAttributes != 0) {
        if (!nodeMap.isEmpty()) {
                    attributeValue,
 */
                        throw new OpenSearchParseException("failed to parse attribute health map");
    ) {
                            case "relocating_shards":
}
        ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
        Map<String, List<String>> perAttributeValueNodeList,
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * The OpenSearch Contributors require contributions made to
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
                                    );
                                    );
                                relocating_shards = parser.intValue();
                    }
package org.opensearch.cluster.awarenesshealth;
        if (size > 0) {
    @Override
                                break;
    @Override
    }
                                }
        String awarenessAttributeValue,
            ClusterAwarenessAttributeValueHealth clusterAwarenessAttributeValueHealth = new ClusterAwarenessAttributeValueHealth(
        return awarenessAttributeName.equals(that.awarenessAttributeName)
import org.opensearch.core.common.io.stream.StreamInput;
        // health stats for rack-1, rack-2 etc.
        String attributeName = parser.currentName();
        boolean displayUnassignedShardLevelInfo,
                throw new OpenSearchParseException("failed to parse awareness attribute value health");
import org.opensearch.core.common.io.stream.StreamOutput;
            clusterAwarenessAttributeValueHealth.toXContent(builder, params);
        }
            for (ClusterAwarenessAttributeValueHealth attributeHealthMapPerValue : this) {
import java.util.Objects;
    }
    public Map<String, ClusterAwarenessAttributeValueHealth> getAwarenessAttributeHealthMap() {
        awarenessAttributeName = in.readString();
        ensureExpectedToken(XContentParser.Token.END_OBJECT, parser.nextToken(), parser);
                shardsPerAttributeValue
                clusterAwarenessAttributeValueHealthMap.put(
 * Cluster Awareness health information
import org.opensearch.cluster.node.DiscoveryNode;
        Map<String, List<String>> attributesNodeList = new HashMap<>();
import org.opensearch.core.xcontent.XContentParser;
                                    throw new OpenSearchParseException(
                }
                double weight = 0.0;
                int nodes = 0;
                int unassigned_shards = 0;
            }
                    unassigned_shards,
                                if (parser.nextToken() != XContentParser.Token.VALUE_NUMBER) {
    }
                                break;
                                    );
 * this file be licensed under the Apache-2.0 license or a
                    relocating_shards,
        }
     * @param awarenessAttributeValue Awareness Attribute value ie zone, rack etc
                    initializing_shards,
                }
                                        "failed to parse initializing shards field, expected number but found unknown type"
            awarenessAttributeValueHealthMap = Collections.emptyMap();
import org.opensearch.OpenSearchParseException;
            while (iter.hasNext()) {
                                }
            } else {
        } else {
        // Getting the node map for cluster
    }
                                break;
                                        "failed to parse node field, expected number but found unknown type"
    private void setClusterAwarenessAttributeValue(
                    clusterAwarenessAttributeValueHealth.getName(),
        Map<String, ClusterAwarenessAttributeValueHealth> awarenessAttributeValueHealthMap
     *
     * @param displayUnassignedShardLevelInfo Governs if unassigned info should be visible or not
                int initializing_shards = 0;
                                break;
    private Map<String, ClusterAwarenessAttributeValueHealth> awarenessAttributeValueHealthMap;
        boolean displayUnassignedShardLevelInfo,
    public String getAwarenessAttributeName() {
    ) {
                        }
import java.util.Map;
            String attributeValue = parser.currentName();
    public boolean equals(Object o) {
                            case "unassigned_shards":
    public int hashCode() {
            awarenessAttributeValueHealthMap = new HashMap<>(size);
    public void writeTo(StreamOutput out) throws IOException {
                                        "failed to parse active shards field, expected number but found unknown type"
    }
                String node = iter.next();
import org.opensearch.core.xcontent.ToXContentFragment;
                                break;
                perAttributeValueNodeList.get(attributeValueKey)
     */
            && awarenessAttributeValueHealthMap.size() == that.awarenessAttributeValueHealthMap.size();
                attributeHealthMapPerValue.writeTo(out);
import java.util.Collections;
                Map<String, String> nodeAttributes = nodeDiscovery.getAttributes();
        ClusterState clusterState
    /**
        String awarenessAttributeName,
                        clusterAwarenessAttributeNodeList.add(node);
                                active_shards = parser.intValue();
    public Iterator<ClusterAwarenessAttributeValueHealth> iterator() {
    @Override
                    if (token == XContentParser.Token.FIELD_NAME) {
                    } else {
    }
        setClusterAwarenessAttributeValue(attributesNodeList, displayUnassignedShardLevelInfo, clusterState);
    }
                                }
                attributeValueKey,
                                    throw new OpenSearchParseException(
        ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);
            for (int i = 0; i < size; i++) {
                                        "failed to parse weight field, expected number but found unknown type"
    public ClusterAwarenessAttributesHealth(
                if (!nodeAttributes.isEmpty()) {
        // This is the map that would store all the stats per attribute ie
 *
                ClusterAwarenessAttributeValueHealth clusterAwarenessAttributeValueHealth = new ClusterAwarenessAttributeValueHealth(
    }
        for (ClusterAwarenessAttributeValueHealth clusterAwarenessAttributeValueHealth : this) {
                                        "failed to parse unassigned field, expected number but found unknown type"
                );
import java.util.Iterator;
 * @opensearch.api
        return Objects.hash(awarenessAttributeName, awarenessAttributeValueHealthMap);
        XContentParser.Token token = parser.nextToken();
                                    throw new OpenSearchParseException(
            );
                        switch (currentFieldName) {
            clusterAwarenessAttributeValueHealthMap.put(attributeValueKey, clusterAwarenessAttributeValueHealth);
                                        "failed to parse relocating shards field, expected number but found unknown type"
        String currentFieldName;
import org.opensearch.cluster.ClusterState;
        }
public class ClusterAwarenessAttributesHealth implements Iterable<ClusterAwarenessAttributeValueHealth>, Writeable, ToXContentFragment {
    @Override
     * Creates Awareness AttributeValue Health information
                                    throw new OpenSearchParseException(
            ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);
                                break;
        final Map<String, DiscoveryNode> nodeMap = clusterState.nodes().getDataNodes();
        }
    private final String awarenessAttributeName;
                                    throw new OpenSearchParseException(
                    }
        if (size > 0) {
        // So to avoid divide-by-zero error checking this
                                if (parser.nextToken() != XContentParser.Token.VALUE_NUMBER) {
        return null;
    }
/*
import org.opensearch.core.xcontent.XContentBuilder;
                            case "weight":
        if (!(o instanceof ClusterAwarenessAttributesHealth)) return false;
    @Override
        out.writeString(awarenessAttributeName);
                                if (parser.nextToken() != XContentParser.Token.VALUE_NUMBER) {
/**
        builder.endObject();
import org.opensearch.core.common.Strings;
            }
        this.awarenessAttributeName = awarenessAttributeName;
                        attributeValue = nodeAttributes.get(awarenessAttributeName);
                            case "active_shards":
    public ClusterAwarenessAttributesHealth(final StreamInput in) throws IOException {
                                nodes = parser.intValue();
            if (token == XContentParser.Token.START_OBJECT) {
                                    throw new OpenSearchParseException(
                clusterState,
    }
                            case "initializing_shards":
                int active_shards = 0;
                                weight = parser.doubleValue();
                                if (parser.nextToken() != XContentParser.Token.VALUE_NUMBER) {
                List<String> clusterAwarenessAttributeNodeList;
                                    );
import java.util.HashMap;
                DiscoveryNode nodeDiscovery = nodeMap.get(node);
        if (this == o) return true;
                        if (!attributesNodeList.containsKey(attributeValue)) {
        }
    ClusterAwarenessAttributesHealth(
    }
            shardsPerAttributeValue = clusterState.getMetadata().getTotalNumberOfShards() / numAttributes;
    ) {
