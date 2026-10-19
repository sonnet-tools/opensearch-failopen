                    } else {
        this.discoveredClusterManager = discoveredClusterManager;
    ClusterGetWeightedRoutingResponse(StreamInput in) throws IOException {
    public WeightedRouting getWeightedRouting() {  
            } else if (token == XContentParser.Token.VALUE_NUMBER
    }
 * Response from fetching weights for weighted round-robin search routing policy.
        long version = WeightedRoutingMetadata.VERSION_UNSET_VALUE;  
                        }
                builder.field(entry.getKey(), entry.getValue().toString());
            }  
}
    public int hashCode() {
import org.opensearch.core.xcontent.XContentParser;
        }  
 * SPDX-License-Identifier: Apache-2.0
            this.weightedRouting = null;
        }
                }
        } else {  
                        throw new OpenSearchParseException("failed to parse weighted routing request attribute [{}]", attrKey);
                    && fieldName.equals(DISCOVERED_CLUSTER_MANAGER)) {
            out.writeLong(version);
    @Override
        }
    private static final String WEIGHTS = "weights";  
            if (token == XContentParser.Token.FIELD_NAME) {
            this.version = in.readLong();
    public static ClusterGetWeightedRoutingResponse fromXContent(XContentParser parser) throws IOException {  
    }
        String attrKey = null, attrValue;  
        return weightedRouting.equals(that.weightedRouting) && discoveredClusterManager.equals(that.discoveredClusterManager);  
            out.writeOptionalBoolean(discoveredClusterManager);
    private final WeightedRouting weightedRouting;
    /**  
    ClusterGetWeightedRoutingResponse() {
                        attrValue = parser.text();
import java.util.Map;
        this.discoveredClusterManager = null;
    }
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                && fieldName != null
            this.weightedRouting = new WeightedRouting(in);  
package org.opensearch.action.admin.cluster.shards.routing.weighted.get;
            }  
    }
    }
    @Override  
            weightedRouting.writeTo(out);  
            this.discoveredClusterManager = in.readOptionalBoolean();
        }
                    } else if (token == XContentParser.Token.VALUE_STRING) {
 */  
                    version = parser.longValue();
    private static final String DISCOVERED_CLUSTER_MANAGER = "discovered_cluster_manager";
import org.opensearch.common.annotation.PublicApi;
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
    }
 */
        return new ClusterGetWeightedRoutingResponse(weightedRouting, discoveredClusterManager, version);
import org.opensearch.OpenSearchParseException;
                } else {  
                && fieldName.equals(WeightedRoutingMetadata.VERSION)) {  
            this.discoveredClusterManager = null;
 * this file be licensed under the Apache-2.0 license or a
     *
                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        Map<String, Double> weights = new HashMap<>();
                    } else {  
                            weights.put(attrKey, Double.parseDouble(attrValue));
        ClusterGetWeightedRoutingResponse that = (ClusterGetWeightedRoutingResponse) o;
        String weightsAttr;
                        attrKey = parser.currentName();  
        return this.weightedRouting;  
                        weightsAttr  
import org.opensearch.core.common.io.stream.StreamOutput;
                fieldName = parser.currentName();  
    @Override
        if (discoveredClusterManager != null) {  
        XContentParser.Token token;
            builder.field(WeightedRoutingMetadata.VERSION, version);  
        String fieldName = null;
        if (in.available() != 0) {
            builder.endObject();
    }
        return builder;  
     * List of weights to return
                        throw new OpenSearchParseException("failed to parse weighted routing request");
    }  
/*  
import java.util.Objects;  
                        if (attrKey != null) {  
                        "failed to parse weighted routing request object [{}], expected object",
        WeightedRouting weightedRouting = new WeightedRouting("", weights);  
import org.opensearch.core.common.io.stream.StreamInput;  
import java.util.HashMap;
                } else if (token == XContentParser.Token.VALUE_BOOLEAN  
            builder.startObject(WEIGHTS);  
 * @opensearch.api
                    && fieldName != null
        return discoveredClusterManager;
    public ClusterGetWeightedRoutingResponse(WeightedRouting weightedRouting, Boolean discoveredClusterManager, long version) {
     */
        if (weightedRouting != null) {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        Boolean discoveredClusterManager = null;
        if (this == o) return true;  
                    }
public class ClusterGetWeightedRoutingResponse extends ActionResponse implements ToXContentObject {
/**
    private final Boolean discoveredClusterManager;
                    }  
                    throw new OpenSearchParseException("failed to parse weighted routing request object", fieldName);
        return Objects.hash(weightedRouting, discoveredClusterManager);
            for (Map.Entry<String, Double> entry : weightedRouting.weights().entrySet()) {
        if (this.weightedRouting != null) {
                builder.field(DISCOVERED_CLUSTER_MANAGER, discoveredClusterManager);
        return version;
@PublicApi(since = "2.4.0")  
                    throw new OpenSearchParseException(
                }
                    && (fieldName.equals(WeightedRoutingMetadata.VERSION) || fieldName.equals(DISCOVERED_CLUSTER_MANAGER))) {
                if (fieldName != null
    public WeightedRouting weights() {
        this.version = version;
 *  
        if (o == null || getClass() != o.getClass()) return false;
    public boolean equals(Object o) {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.xcontent.ToXContentObject;
    public void writeTo(StreamOutput out) throws IOException {
        return weightedRouting;
    }
import org.opensearch.core.xcontent.XContentBuilder;  
    }  
 * compatible open source license.
        this.weightedRouting = null;  
import org.opensearch.cluster.metadata.WeightedRoutingMetadata;
import java.io.IOException;  
                    );
    private long version;
        builder.startObject();
 *
        builder.endObject();
    public long getVersion() {  
import org.opensearch.cluster.routing.WeightedRouting;  
                if (parser.nextToken() != XContentParser.Token.START_OBJECT) {  
        }
    public Boolean getDiscoveredClusterManager() {
        ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
        this.weightedRouting = weightedRouting;  
    @Override  
    }  
import org.opensearch.core.action.ActionResponse;
                    if (token == XContentParser.Token.FIELD_NAME) {
    }
                    continue;  
                }  
                } else if (fieldName != null && fieldName.equals(WEIGHTS)) {
                        discoveredClusterManager = Boolean.parseBoolean(parser.text());  
                    weightsAttr = parser.currentName();
            if (discoveredClusterManager != null) {
     * @return list or weights  
