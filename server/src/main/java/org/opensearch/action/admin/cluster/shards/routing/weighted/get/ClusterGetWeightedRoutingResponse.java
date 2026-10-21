    }
                    } else if (token == XContentParser.Token.VALUE_STRING) {
            this.discoveredClusterManager = in.readOptionalBoolean();
    }
                    } else {
        Boolean discoveredClusterManager = null;
    ClusterGetWeightedRoutingResponse() {
    private final Boolean discoveredClusterManager;
import java.util.Objects;
        this.version = version;
import java.util.Map;
            }
        this.discoveredClusterManager = discoveredClusterManager;
                    && fieldName.equals(DISCOVERED_CLUSTER_MANAGER)) {
                if (fieldName != null
        String weightsAttr;
 * SPDX-License-Identifier: Apache-2.0
    public int hashCode() {
                    throw new OpenSearchParseException(
    public ClusterGetWeightedRoutingResponse(WeightedRouting weightedRouting, Boolean discoveredClusterManager, long version) {
        long version = WeightedRoutingMetadata.VERSION_UNSET_VALUE;
import org.opensearch.core.xcontent.XContentBuilder;
 * compatible open source license.
 *
    }
        if (in.available() != 0) {
 * this file be licensed under the Apache-2.0 license or a
                && fieldName.equals(WeightedRoutingMetadata.VERSION)) {
    }
        Map<String, Double> weights = new HashMap<>();
public class ClusterGetWeightedRoutingResponse extends ActionResponse implements ToXContentObject {
    }
                if (parser.nextToken() != XContentParser.Token.START_OBJECT) {
                    if (token == XContentParser.Token.FIELD_NAME) {
            out.writeOptionalBoolean(discoveredClusterManager);
import org.opensearch.core.action.ActionResponse;
        ClusterGetWeightedRoutingResponse that = (ClusterGetWeightedRoutingResponse) o;
    @Override
/*
 * Response from fetching weights for weighted round-robin search routing policy.
    }
                } else {
                        weightsAttr
    public static ClusterGetWeightedRoutingResponse fromXContent(XContentParser parser) throws IOException {
    private static final String DISCOVERED_CLUSTER_MANAGER = "discovered_cluster_manager";
            if (discoveredClusterManager != null) {
        return weightedRouting.equals(that.weightedRouting) && discoveredClusterManager.equals(that.discoveredClusterManager);
    public boolean equals(Object o) {
    ClusterGetWeightedRoutingResponse(StreamInput in) throws IOException {
                    version = parser.longValue();
        XContentParser.Token token;
                    weightsAttr = parser.currentName();
import org.opensearch.core.xcontent.XContentParser;
                        throw new OpenSearchParseException("failed to parse weighted routing request attribute [{}]", attrKey);
        }
        this.weightedRouting = weightedRouting;
                fieldName = parser.currentName();
@PublicApi(since = "2.4.0")
        String attrKey = null, attrValue;
        if (this == o) return true;
                    && fieldName != null
     * @return list or weights
        }
            }
        }
                        "failed to parse weighted routing request object [{}], expected object",
    }
            out.writeLong(version);
    }
            this.weightedRouting = null;
    @Override
                        if (attrKey != null) {
    private final WeightedRouting weightedRouting;
        }
            for (Map.Entry<String, Double> entry : weightedRouting.weights().entrySet()) {
        this.discoveredClusterManager = null;
        return discoveredClusterManager;
        }
    private static final String WEIGHTS = "weights";
                builder.field(DISCOVERED_CLUSTER_MANAGER, discoveredClusterManager);
                }
                    && (fieldName.equals(WeightedRoutingMetadata.VERSION) || fieldName.equals(DISCOVERED_CLUSTER_MANAGER))) {
     */
    }
                        discoveredClusterManager = Boolean.parseBoolean(parser.text());
import java.io.IOException;
        if (discoveredClusterManager != null) {
    }
        return Objects.hash(weightedRouting, discoveredClusterManager);
        if (weightedRouting != null) {
import org.opensearch.core.common.io.stream.StreamOutput;
            weightedRouting.writeTo(out);
                    );
            this.weightedRouting = new WeightedRouting(in);
    @Override
}
        String fieldName = null;
        if (o == null || getClass() != o.getClass()) return false;
import org.opensearch.core.common.io.stream.StreamInput;
                } else if (fieldName != null && fieldName.equals(WEIGHTS)) {
        builder.startObject();
                && fieldName != null
                } else if (token == XContentParser.Token.VALUE_BOOLEAN
        ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
            builder.field(WeightedRoutingMetadata.VERSION, version);
            } else if (token == XContentParser.Token.VALUE_NUMBER
 * The OpenSearch Contributors require contributions made to
        if (this.weightedRouting != null) {
            if (token == XContentParser.Token.FIELD_NAME) {
                builder.field(entry.getKey(), entry.getValue().toString());
import org.opensearch.cluster.routing.WeightedRouting;
                }
import org.opensearch.core.xcontent.ToXContentObject;
                        attrKey = parser.currentName();
        return this.weightedRouting;
                        }
import org.opensearch.common.annotation.PublicApi;
                        throw new OpenSearchParseException("failed to parse weighted routing request");
    private long version;
                    }
        return builder;
 * @opensearch.api
import org.opensearch.cluster.metadata.WeightedRoutingMetadata;
    public WeightedRouting getWeightedRouting() {
 *
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                    throw new OpenSearchParseException("failed to parse weighted routing request object", fieldName);
            builder.endObject();
 */
    /**
                    } else {
        return new ClusterGetWeightedRoutingResponse(weightedRouting, discoveredClusterManager, version);
            this.discoveredClusterManager = null;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
package org.opensearch.action.admin.cluster.shards.routing.weighted.get;
        this.weightedRouting = null;
        return weightedRouting;
import java.util.HashMap;
    public Boolean getDiscoveredClusterManager() {
                        attrValue = parser.text();
            builder.startObject(WEIGHTS);
import org.opensearch.OpenSearchParseException;
        builder.endObject();
/**
    }
                            weights.put(attrKey, Double.parseDouble(attrValue));
 */
     *
    public WeightedRouting weights() {
        return version;
    public long getVersion() {
                }
            this.version = in.readLong();
                    continue;
    }
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
     * List of weights to return
        WeightedRouting weightedRouting = new WeightedRouting("", weights);
                    }
    public void writeTo(StreamOutput out) throws IOException {
    @Override
        } else {
