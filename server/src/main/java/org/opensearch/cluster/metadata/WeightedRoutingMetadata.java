    public static final String AWARENESS = "awareness";
    public Version getMinimalSupportedVersion() {
    }
    }
        return weightedRouting.equals(that.weightedRouting) && version == that.version;  
                    awarenessField = parser.currentName();  
                        );
        return builder;
public class WeightedRoutingMetadata extends AbstractNamedDiffable<Metadata.Custom> implements Metadata.Custom {  
                            }
        if (weightedRouting != null) {
        String attrKey = null;
    @Override
import org.opensearch.core.xcontent.XContentBuilder;  
 * The OpenSearch Contributors require contributions made to  
                            if (attrKey != null && attrKey.equals(VERSION)) {  
import java.io.IOException;  
        }
        String attributeName = "";  
        String versionAttr = null;
    }
                    if (parser.nextToken() != XContentParser.Token.START_OBJECT) {
        return TYPE;
 * @opensearch.api  
    public static final int WEIGHED_AWAY_WEIGHT = 0;  
/**  
        return this;  
            }
    public WeightedRouting getWeightedRouting() {  
            for (Map.Entry<String, Double> entry : weightedRouting.weights().entrySet()) {  
                                weights.put(attrKey, attrValue);
    public static void toXContent(WeightedRouting weightedRouting, XContentBuilder builder, long version) throws IOException {
        return Strings.toString(MediaTypeRegistry.JSON, this);
                if (attr != null && attr.equals(VERSION)) {
                    attributeName = parser.currentName();  
    @Override
    }  
    public static WeightedRoutingMetadata fromXContent(XContentParser parser) throws IOException {  
                                "failed to parse weighted routing metadata attribute " + "[{}], unknown type",  
/*  
 *
    public static NamedDiff<Metadata.Custom> readDiffFrom(StreamInput in) throws IOException {
            weightedRouting.writeTo(out);  
    public WeightedRoutingMetadata(StreamInput in) throws IOException {  
            if (token == XContentParser.Token.FIELD_NAME) {  
        builder.startObject(AWARENESS);  
                }  
                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    }
        return Version.V_2_4_0;  
                    version = Long.parseLong(parser.text());
                                version = Long.parseLong(parser.text());
    public static final String TYPE = "weighted_shard_routing";
                    throw new OpenSearchParseException("failed to parse weighted routing metadata  [{}], expected object", awarenessField);  
    public boolean equals(Object o) {
    public long getVersion() {
        return weightedRouting;
                }
        toXContent(weightedRouting, builder, version);
                            throw new OpenSearchParseException(
    }
        if (in.available() != 0) {
    public String toString() {
                            attributeName
    public EnumSet<Metadata.XContentContext> context() {
 * Contains metadata for weighted routing
                    continue;
                                attrValue = Double.parseDouble(parser.text());  
import org.opensearch.core.xcontent.MediaTypeRegistry;
import java.util.Map;  
    @Override  
    @Override
        return Objects.hash(weightedRouting.hashCode(), version);
        return readDiffFrom(Metadata.Custom.class, TYPE, in);  
                            );
                    }
import java.util.HashMap;
        }
            this.version = in.readLong();  
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
}
    public static final String VERSION = "_version";  
                builder.field(entry.getKey(), entry.getValue());
            }
                        }  
import java.util.EnumSet;
                if (parser.nextToken() != XContentParser.Token.START_OBJECT) {
            out.writeLong(version);
    public WeightedRoutingMetadata(WeightedRouting weightedRouting, long version) {
    public static final long INITIAL_VERSION = -1;
import java.util.Objects;
    }
    }
    }
                                attributeName
        return Metadata.API_AND_GATEWAY;
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {  
        }
        builder.field(VERSION, version);  
import org.opensearch.core.common.io.stream.StreamInput;
    }
                String attr = parser.currentName();
                            attrKey = parser.currentName();  
    }  
                        } else {
    public void writeTo(StreamOutput out) throws IOException {
    @Override  
        XContentParser.Token token;  
        }
            builder.endObject();  
                        throw new OpenSearchParseException(
                    versionAttr = parser.currentName();  
    public WeightedRoutingMetadata setWeightedRouting(WeightedRouting weightedRouting) {
                    }  
        WeightedRouting weightedRouting;
 */
        return new WeightedRoutingMetadata(weightedRouting, version);
                        } else if (token == XContentParser.Token.VALUE_NUMBER) {
                            "failed to parse weighted routing metadata  [{}], expected object",  
            this.weightedRouting = new WeightedRouting(in);
        if (o == null || getClass() != o.getClass()) return false;
 * SPDX-License-Identifier: Apache-2.0
    public String getWriteableName() {  
 */  
        Double attrValue;
import org.opensearch.core.xcontent.XContentParser;
    }  
                } else {
        Map<String, Double> weights = new HashMap<>();
import org.opensearch.common.annotation.PublicApi;  
    public int hashCode() {
                            } else {
import org.opensearch.cluster.routing.WeightedRouting;
    }
import org.opensearch.cluster.NamedDiff;
        if (weightedRouting.isSet()) {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.xcontent.ToXContent;
import org.opensearch.cluster.AbstractNamedDiffable;  
    }  
        if (this == o) return true;  
                if (versionAttr != null && versionAttr.equals(VERSION)) {
                }
        this.weightedRouting = weightedRouting;
    }  
                    while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
 * compatible open source license.
        long version = VERSION_UNSET_VALUE;  
    @Override  
@PublicApi(since = "1.0.0")
        this.weightedRouting = weightedRouting;
                }
import org.opensearch.Version;
    public static final long VERSION_UNSET_VALUE = -2;
    }
package org.opensearch.cluster.metadata;
 *
    private WeightedRouting weightedRouting;
        return version;  
    @Override  
    private long version;  
import org.opensearch.core.common.io.stream.StreamOutput;  
            } else if (token == XContentParser.Token.VALUE_NUMBER) {  
        String awarenessField;
import org.opensearch.core.common.Strings;
                        if (token == XContentParser.Token.FIELD_NAME) {
        weightedRouting = new WeightedRouting(attributeName, weights);  
        WeightedRoutingMetadata that = (WeightedRoutingMetadata) o;
    @Override
import org.opensearch.OpenSearchParseException;
        this.version = version;  
            builder.startObject(weightedRouting.attributeName());
        builder.endObject();
