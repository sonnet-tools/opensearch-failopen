                    weightedRouting.weights().size() / 2  
    }  
        if (weightedRouting.weights() == null || weightedRouting.weights().isEmpty()) {
            this.version = version;
import org.opensearch.common.annotation.PublicApi;  
        try {
                    if (parser.nextToken() != XContentParser.Token.START_OBJECT) {  
            this.weightedRouting = new WeightedRouting(this.attributeName, weights);
                    if (fieldName != null && fieldName.equals(WeightedRoutingMetadata.VERSION)) {
    }
                    );
        weightedRouting = new WeightedRouting(in);  
            validationException = addValidationError(("Weight is not a number"), validationException);
                        continue;  
            String versionAttr = null;  
    public String toString() {
            Map<String, Double> weights = new HashMap<>();
                null
            XContentBuilder builder = XContentFactory.jsonBuilder();
import java.util.Map;  
import org.opensearch.core.xcontent.XContentBuilder;  
    public void setWeightedRouting(Map<String, Object> source) {
        if (version == WeightedRoutingMetadata.VERSION_UNSET_VALUE) {
    public ClusterPutWeightedRoutingRequest source(Map<String, Object> source) {  
                    throw new OpenSearchParseException(
     * @param source weights definition from request body  
    @Override
        super.writeTo(out);
import org.apache.logging.log4j.LogManager;
        double weight;  
            for (Object value : weightedRouting.weights().values()) {
import org.opensearch.core.common.io.stream.StreamOutput;
                            throw new OpenSearchParseException(
                    Locale.ROOT,
            validationException = addValidationError("Weighted routing request object is null", validationException);  
            throw new OpenSearchGenerationException("Failed to generate [" + source + "]", e);
        if (validationException != null) {
        }
    @Override  
                    } else if (fieldName != null && fieldName.equals("weights")) {
        }
        this.weightedRouting = weightedRouting;
            validationException = addValidationError(  
    public void version(long version) {
 * this file be licensed under the Apache-2.0 license or a
    }
/**
        return this;
    }
        }
                        version = parser.longValue();
                        );
import java.io.IOException;  
 *
                    weight = Double.parseDouble(value.toString());  
            XContentParser parser = XContentHelper.createParser(
        version = in.readLong();
    }  
                            weights.put(attrValue, attrWeight);  
    }  
 */  
                        }  
 */
        ) {
        return validationException;
    }
                    countValueWithZeroWeights = (weight == 0) ? countValueWithZeroWeights + 1 : countValueWithZeroWeights;
                                "failed to parse weighted routing request attribute [{}], " + "unknown type",  
        this.attributeName = attributeName;
import org.opensearch.core.xcontent.DeprecationHandler;  
 * @opensearch.api
    public ActionRequestValidationException validate() {  
            long version = WeightedRoutingMetadata.VERSION_UNSET_VALUE;
            parser.nextToken();
    private long version;  
    private static final Logger logger = LogManager.getLogger(ClusterPutWeightedRoutingRequest.class);
            String weightsAttr;
    }
        }
                    if (versionAttr != null && versionAttr.equals(WeightedRoutingMetadata.VERSION)) {  
                } else {
        ActionRequestValidationException validationException = null;
                        "failed to parse weighted routing request " + "[{}], unknown " + "type",
        weightedRouting.writeTo(out);
                if (token == XContentParser.Token.FIELD_NAME) {
    }
                throw new OpenSearchParseException(("Empty request body"));
                    weightedRouting.weights().toString(),
            }  
            logger.error("error while parsing put weighted routing request object", e);
                        attributeName  
                            weightsAttr  
            }  
    public void setWeightedRouting(BytesReference source, MediaType contentType) {  
        this.attributeName = attributeName;
                            );
        return weightedRouting;
/*  
        super(in);
import org.opensearch.cluster.routing.WeightedRouting;
    private String attributeName;
import org.opensearch.core.common.bytes.BytesReference;  
        if (weightedRouting == null) {
public class ClusterPutWeightedRoutingRequest extends ClusterManagerNodeRequest<ClusterPutWeightedRoutingRequest> {
            return validationException;  
        this.version = version;  
    public void attributeName(String attributeName) {  
import org.opensearch.core.xcontent.XContentParser;
        int countValueWithZeroWeights = 0;
        if (weightedRouting.attributeName() == null || weightedRouting.attributeName().isEmpty()) {
                if (value == null) {  
import static org.opensearch.action.ValidateActions.addValidationError;
                    }
        }
import java.util.HashMap;
import org.opensearch.action.ActionRequestValidationException;
                (String.format(
            )
        if (countValueWithZeroWeights > weightedRouting.weights().size() / 2) {
            );  
                        weightsAttr = parser.currentName();
        try {  
import org.opensearch.OpenSearchParseException;
    }
}
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                    }
    /**
                    "There are too many attribute values [%s] given zero weight [%d]. Maximum expected number of routing weights having zero weight is [%d]",  
        }
 * The OpenSearch Contributors require contributions made to  
                            "failed to parse weighted routing request object  [{}], expected object",
import org.opensearch.core.xcontent.NamedXContentRegistry;
                )),
import org.opensearch.common.xcontent.XContentFactory;
            XContentParser.Token token;  
        }  
            // move to the first alias
                    }
     */
import org.opensearch.core.common.io.stream.StreamInput;
     * @return this request
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;  
            }  
 * SPDX-License-Identifier: Apache-2.0
        } catch (NumberFormatException e) {
@PublicApi(since = "2.4.0")  
                            attrValue = parser.currentName();  
        out.writeLong(version);  
                    String fieldName = parser.currentName();  
                        if (token == XContentParser.Token.FIELD_NAME) {
                    }
            String attrValue = null;  
        } catch (IOException e) {  
            validationException = addValidationError("Attribute name is missing", validationException);  
    }  
        return "ClusterPutWeightedRoutingRequest{" + "weightedRouting= " + weightedRouting.toString() + "version= " + version + "}";
            if (source.isEmpty()) {
                }
import org.opensearch.OpenSearchGenerationException;  
                    while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            setWeightedRouting(BytesReference.bytes(builder), builder.contentType());  
                    } else {  
    private WeightedRouting weightedRouting;
 * compatible open source license.
import java.util.Locale;
                } else if (token == XContentParser.Token.VALUE_NUMBER) {
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
package org.opensearch.action.admin.cluster.shards.routing.weighted.put;
        }
        } catch (IOException e) {
                source,
    public ClusterPutWeightedRoutingRequest(StreamInput in) throws IOException {
        setWeightedRouting(source);
import org.opensearch.common.xcontent.XContentHelper;
                contentType  
            Double attrWeight = null;
                }
    public ClusterPutWeightedRoutingRequest(String attributeName) {
import org.opensearch.core.xcontent.MediaType;
                            attrWeight = Double.parseDouble(parser.text());
            validationException = addValidationError("Version is missing", validationException);  
import org.apache.logging.log4j.Logger;
    public long getVersion() {  
 * Request to update weights for weighted round-robin shard routing policy.
            builder.map(source);
                    validationException = addValidationError(("Weight is null"), validationException);
                        throw new OpenSearchParseException(
                                attrWeight
    }  
    }
    public ClusterPutWeightedRoutingRequest setWeightedRouting(WeightedRouting weightedRouting) {
    public WeightedRouting getWeightedRouting() {  
    public ClusterPutWeightedRoutingRequest() {}
            validationException = addValidationError("Weights are missing", validationException);  
    public void writeTo(StreamOutput out) throws IOException {  
        // Returning validation exception here itself if it is not null, so we can have a descriptive message for the count check
                        } else {
                        } else if (token == XContentParser.Token.VALUE_STRING) {
                } else {  
import org.opensearch.cluster.metadata.WeightedRoutingMetadata;
        return this.version;
                NamedXContentRegistry.EMPTY,  
 *  
    @Override
        try (
        }  
        return this;  
                        throw new OpenSearchParseException("failed to parse weighted routing request object [{}]", fieldName);
                    countValueWithZeroWeights,
                        versionAttr = parser.currentName();
