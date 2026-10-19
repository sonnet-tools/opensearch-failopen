    public int hashCode() {  
 * @opensearch.api
                                        "failed to parse unassigned field, expected number but found unknown type"
            String attributeValue = parser.currentName();  
    }
            );
        String awarenessAttributeName,
        boolean displayUnassignedShardLevelInfo,  
            clusterAwarenessAttributeValueHealthMap.put(attributeValueKey, clusterAwarenessAttributeValueHealth);  
                                    );
        boolean displayUnassignedShardLevelInfo,
        int numAttributes = perAttributeValueNodeList.size();
/*  
                                    throw new OpenSearchParseException(
                                    throw new OpenSearchParseException(
                int active_shards = 0;  
                                }  
                                    );
import org.opensearch.core.xcontent.XContentBuilder;
 * Cluster Awareness health information
}  
            );
        String attributeName = parser.currentName();  
                double weight = 0.0;
                clusterState,
                    clusterAwarenessAttributeValueHealth.getName(),
        this.awarenessAttributeName = awarenessAttributeName;
                                weight = parser.doubleValue();
        ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);
                                }
                String node = iter.next();
                            case "initializing_shards":  
                                        "failed to parse relocating shards field, expected number but found unknown type"
        }
                int relocating_shards = 0;
        if (!(o instanceof ClusterAwarenessAttributesHealth)) return false;
                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
    ClusterAwarenessAttributesHealth(
 * The OpenSearch Contributors require contributions made to  
     * @param displayUnassignedShardLevelInfo Governs if unassigned info should be visible or not
        Map<String, ClusterAwarenessAttributeValueHealth> awarenessAttributeValueHealthMap  
        for (ClusterAwarenessAttributeValueHealth clusterAwarenessAttributeValueHealth : this) {
     * Creates Awareness AttributeValue Health information
        setClusterAwarenessAttributeValue(attributesNodeList, displayUnassignedShardLevelInfo, clusterState);  
        out.writeVInt(size);  
        XContentParser.Token token = parser.nextToken();
                                    );
        for (String attributeValueKey : perAttributeValueNodeList.keySet()) {
                                }
                                break;
        return awarenessAttributeValueHealthMap.values().iterator();
                                }
    }  
        }  
    }  
    }
package org.opensearch.cluster.awarenesshealth;
                                relocating_shards = parser.intValue();
     * @param awarenessAttributeValue Awareness Attribute value ie zone, rack etc  
        if (size > 0) {
                                    throw new OpenSearchParseException(
        Map<String, ClusterAwarenessAttributeValueHealth> clusterAwarenessAttributeValueHealthMap = new HashMap<>();
    }
        this.awarenessAttributeValueHealthMap = awarenessAttributeValueHealthMap;  
        return new ClusterAwarenessAttributesHealth(attributeName, clusterAwarenessAttributeValueHealthMap);  
import org.opensearch.core.xcontent.XContentParser;  
        final Map<String, DiscoveryNode> nodeMap = clusterState.nodes().getDataNodes();  
                        attributeValue = nodeAttributes.get(awarenessAttributeName);
     *
    public String getAwarenessAttributeName() {  
    }  
                    } else {
                        currentFieldName = parser.currentName();
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                        throw new OpenSearchParseException("failed to parse attribute health map");  
            } else {
        Map<String, List<String>> perAttributeValueNodeList,
            Iterator<String> iter = nodeMap.keySet().iterator();
    /**  
        awarenessAttributeName = in.readString();  
                            clusterAwarenessAttributeNodeList = new ArrayList<>();
                        }
        return awarenessAttributeValueHealthMap;
    public String toString() {
            }  
    }  
            }  
                                    );  
    private final String awarenessAttributeName;  
                throw new OpenSearchParseException("failed to parse awareness attribute value health");
            clusterAwarenessAttributeValueHealth.toXContent(builder, params);
                            attributesNodeList.put(attributeValue, clusterAwarenessAttributeNodeList);
    public ClusterAwarenessAttributesHealth(
                                if (parser.nextToken() != XContentParser.Token.VALUE_NUMBER) {
    public boolean equals(Object o) {  
import org.opensearch.core.common.io.stream.Writeable;
    public Iterator<ClusterAwarenessAttributeValueHealth> iterator() {  
     */  
    ) {
import org.opensearch.common.annotation.PublicApi;
 * this file be licensed under the Apache-2.0 license or a
                awarenessAttributeValueHealthMap.put(clusterAwarenessAttributeValueHealth.getName(), clusterAwarenessAttributeValueHealth);  
                    clusterAwarenessAttributeValueHealth
import org.opensearch.core.common.Strings;
                                if (parser.nextToken() != XContentParser.Token.VALUE_NUMBER) {
                                        "failed to parse active shards field, expected number but found unknown type"
    public static ClusterAwarenessAttributesHealth fromXContent(XContentParser parser) throws IOException {
            clusterAwarenessAttributeValueHealth.computeAttributeValueLevelInfo(
                                break;  
                    if (token == XContentParser.Token.FIELD_NAME) {
            while (iter.hasNext()) {  
                );
    }
    }  
        // This is the map that would store all the stats per attribute ie
        return null;
        return awarenessAttributeName.equals(that.awarenessAttributeName)
        }
        return awarenessAttributeName;
 *
    @Override
import org.opensearch.cluster.ClusterState;
                    weight
                attributeHealthMapPerValue.writeTo(out);  
            shardsPerAttributeValue = clusterState.getMetadata().getTotalNumberOfShards() / numAttributes;
            ClusterAwarenessAttributeValueHealth clusterAwarenessAttributeValueHealth = new ClusterAwarenessAttributeValueHealth(
public class ClusterAwarenessAttributesHealth implements Iterable<ClusterAwarenessAttributeValueHealth>, Writeable, ToXContentFragment {
    }
        return Objects.hash(awarenessAttributeName, awarenessAttributeValueHealthMap);
        String awarenessAttributeValue,
                                break;
 * SPDX-License-Identifier: Apache-2.0
                int initializing_shards = 0;
            for (ClusterAwarenessAttributeValueHealth attributeHealthMapPerValue : this) {
        int size = awarenessAttributeValueHealthMap.size();
            awarenessAttributeValueHealthMap = new HashMap<>(size);  
        }
        out.writeString(awarenessAttributeName);
import org.opensearch.core.xcontent.MediaTypeRegistry;  
                            case "weight":
import java.util.Iterator;  
                                        "failed to parse node field, expected number but found unknown type"  
        if (size > 0) {
                            case "unassigned_shards":
    }
import java.util.ArrayList;  
                int unassigned_shards = 0;  
        awarenessAttributeValueHealthMap = clusterAwarenessAttributeValueHealthMap;
        awarenessAttributeValueHealthMap = new HashMap<>();
                );  
        ClusterAwarenessAttributesHealth that = (ClusterAwarenessAttributesHealth) o;  
                        } else {  
                            case "data_nodes":  
        // So to avoid divide-by-zero error checking this  
        builder.endObject();
        }
    }  
                    unassigned_shards,
                                    throw new OpenSearchParseException(  
                                if (parser.nextToken() != XContentParser.Token.VALUE_NUMBER) {
        if (this == o) return true;
                Map<String, String> nodeAttributes = nodeDiscovery.getAttributes();
                clusterAwarenessAttributeValueHealthMap.put(  
import org.opensearch.cluster.node.DiscoveryNode;  
        // Getting the node map for cluster
import java.util.HashMap;
import java.util.Objects;  
 * compatible open source license.
                int nodes = 0;
        // health stats for rack-1, rack-2 etc.  
import java.io.IOException;
                    }
        // Can happen customer has defined weights as well as awareness attribute but no node level attribute was there
import org.opensearch.core.xcontent.ToXContentFragment;
import org.opensearch.core.common.io.stream.StreamOutput;
                    attributeValue,
                                unassigned_shards = parser.intValue();
    ) {
                                break;
            && awarenessAttributeValueHealthMap.size() == that.awarenessAttributeValueHealthMap.size();
                if (!nodeAttributes.isEmpty()) {
    public ClusterAwarenessAttributesHealth(final StreamInput in) throws IOException {
                ClusterAwarenessAttributeValueHealth clusterAwarenessAttributeValueHealth = new ClusterAwarenessAttributeValueHealth(in);
        int size = in.readVInt();
        return Strings.toString(MediaTypeRegistry.JSON, this);
 */
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
import org.opensearch.core.common.io.stream.StreamInput;  
        // This is the Map which is storing the per attribute node list.
            // computing attribute info  
     * @param clusterState cluster state
                                    throw new OpenSearchParseException(
                                if (parser.nextToken() != XContentParser.Token.VALUE_NUMBER) {
 *  
            if (token == XContentParser.Token.START_OBJECT) {
                    relocating_shards,
                                        "failed to parse weight field, expected number but found unknown type"
        String attributeValue;
                                    throw new OpenSearchParseException(  
                                        "failed to parse initializing shards field, expected number but found unknown type"  
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
        }
    private Map<String, ClusterAwarenessAttributeValueHealth> awarenessAttributeValueHealthMap;
    ) {
import org.opensearch.OpenSearchParseException;
                }
                                    );  
                        switch (currentFieldName) {  
        ensureExpectedToken(XContentParser.Token.END_OBJECT, parser.nextToken(), parser);
            }
                        }
    @Override
        if (numAttributes != 0) {
                    nodes,  
                attributeValueKey,  
            ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);
        ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
                    }
    @Override
        }  
@PublicApi(since = "1.0.0")  
    public void writeTo(StreamOutput out) throws IOException {  
                                nodes = parser.intValue();  
                                if (parser.nextToken() != XContentParser.Token.VALUE_NUMBER) {  
                    active_shards,
        ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);  
        } else {
        if (!nodeMap.isEmpty()) {
                DiscoveryNode nodeDiscovery = nodeMap.get(node);  
        int shardsPerAttributeValue = 0;  
                }
        awarenessAttributeName = awarenessAttributeValue;  
                                    );
                                break;
                displayUnassignedShardLevelInfo,  
        Map<String, List<String>> attributesNodeList = new HashMap<>();  
            }
                                }  
                                break;  
                            case "relocating_shards":
        Map<String, ClusterAwarenessAttributeValueHealth> clusterAwarenessAttributeValueHealthMap = new HashMap<>();
                                initializing_shards = parser.intValue();  
        String currentFieldName;  
                List<String> clusterAwarenessAttributeNodeList;
        ClusterState clusterState
                        clusterAwarenessAttributeNodeList.add(node);  
            awarenessAttributeValueHealthMap = Collections.emptyMap();  
 */  
    private void setClusterAwarenessAttributeValue(  
                            case "active_shards":
            for (int i = 0; i < size; i++) {
    }
import java.util.List;
    public Map<String, ClusterAwarenessAttributeValueHealth> getAwarenessAttributeHealthMap() {
                        if (!attributesNodeList.containsKey(attributeValue)) {  
    @Override  
        ClusterState clusterState  
        builder.startObject(getAwarenessAttributeName());  
    @Override
            token = parser.nextToken();
                                }
                    if (nodeAttributes.containsKey(awarenessAttributeName)) {  
    @Override
                perAttributeValueNodeList.get(attributeValueKey)
                            clusterAwarenessAttributeNodeList = attributesNodeList.get(attributeValue);
                                active_shards = parser.intValue();
                                if (parser.nextToken() != XContentParser.Token.VALUE_NUMBER) {  
                shardsPerAttributeValue
import java.util.Collections;
                    initializing_shards,  
import java.util.Map;
/**
                ClusterAwarenessAttributeValueHealth clusterAwarenessAttributeValueHealth = new ClusterAwarenessAttributeValueHealth(  
