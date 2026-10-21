        }
     * @return this request
        double weight;
    @Override
            }
                }
                        throw new OpenSearchParseException(
                    }
                if (token == XContentParser.Token.FIELD_NAME) {
            XContentParser parser = XContentHelper.createParser(
            validationException = addValidationError("Weighted routing request object is null", validationException);
 * Request to update weights for weighted round-robin shard routing policy.
/*
                } else {
import org.opensearch.common.xcontent.XContentFactory;
 * compatible open source license.
        try {
                        if (token == XContentParser.Token.FIELD_NAME) {
import org.opensearch.action.ActionRequestValidationException;
                    }
        ) {
                }
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        try (
            this.version = version;
            }
            }
                    if (parser.nextToken() != XContentParser.Token.START_OBJECT) {
import org.opensearch.common.annotation.PublicApi;
        super(in);
    }
        out.writeLong(version);
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;
        if (version == WeightedRoutingMetadata.VERSION_UNSET_VALUE) {
                        throw new OpenSearchParseException("failed to parse weighted routing request object [{}]", fieldName);
            long version = WeightedRoutingMetadata.VERSION_UNSET_VALUE;
    public ActionRequestValidationException validate() {
                    } else {
            builder.map(source);
    }
        }
        return validationException;
                } else {
        } catch (IOException e) {
            this.weightedRouting = new WeightedRouting(this.attributeName, weights);
            logger.error("error while parsing put weighted routing request object", e);
                    weightedRouting.weights().size() / 2
                            attrWeight = Double.parseDouble(parser.text());
        this.attributeName = attributeName;
                    } else if (fieldName != null && fieldName.equals("weights")) {
                            attrValue = parser.currentName();
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
    public void version(long version) {
        }
        // Returning validation exception here itself if it is not null, so we can have a descriptive message for the count check
    }
     */
import org.opensearch.core.common.io.stream.StreamOutput;
                    weightedRouting.weights().toString(),
                            "failed to parse weighted routing request object  [{}], expected object",
import org.opensearch.cluster.routing.WeightedRouting;
                            weights.put(attrValue, attrWeight);
                if (value == null) {
import java.util.Map;
        if (weightedRouting.weights() == null || weightedRouting.weights().isEmpty()) {
                        versionAttr = parser.currentName();
import java.io.IOException;
                contentType
        super.writeTo(out);
    private static final Logger logger = LogManager.getLogger(ClusterPutWeightedRoutingRequest.class);
import org.opensearch.OpenSearchGenerationException;
                        continue;
                    weight = Double.parseDouble(value.toString());
    }
import org.opensearch.OpenSearchParseException;
            setWeightedRouting(BytesReference.bytes(builder), builder.contentType());
                        );
    }
                            weightsAttr
    }
            validationException = addValidationError("Weights are missing", validationException);
        ActionRequestValidationException validationException = null;
    public ClusterPutWeightedRoutingRequest source(Map<String, Object> source) {
/**
        if (weightedRouting.attributeName() == null || weightedRouting.attributeName().isEmpty()) {
 * SPDX-License-Identifier: Apache-2.0
            parser.nextToken();
                null
    }
import org.opensearch.common.xcontent.XContentHelper;
    private WeightedRouting weightedRouting;
    /**
                throw new OpenSearchParseException(("Empty request body"));
    public void attributeName(String attributeName) {
                    }
            String versionAttr = null;
            validationException = addValidationError("Attribute name is missing", validationException);
import org.opensearch.core.common.io.stream.StreamInput;
 * The OpenSearch Contributors require contributions made to
 */
                    validationException = addValidationError(("Weight is null"), validationException);
    public void writeTo(StreamOutput out) throws IOException {
                    String fieldName = parser.currentName();
        weightedRouting.writeTo(out);
                        }
                    if (fieldName != null && fieldName.equals(WeightedRoutingMetadata.VERSION)) {
            validationException = addValidationError("Version is missing", validationException);
    public ClusterPutWeightedRoutingRequest(StreamInput in) throws IOException {
                )),
        } catch (IOException e) {
                        version = parser.longValue();
    public ClusterPutWeightedRoutingRequest() {}
            return validationException;
@PublicApi(since = "2.4.0")
        return "ClusterPutWeightedRoutingRequest{" + "weightedRouting= " + weightedRouting.toString() + "version= " + version + "}";
            Double attrWeight = null;
        version = in.readLong();
        } catch (NumberFormatException e) {
                            throw new OpenSearchParseException(
import org.opensearch.core.xcontent.NamedXContentRegistry;
    private String attributeName;
        this.weightedRouting = weightedRouting;
        return this;
    @Override
                    countValueWithZeroWeights = (weight == 0) ? countValueWithZeroWeights + 1 : countValueWithZeroWeights;
            throw new OpenSearchGenerationException("Failed to generate [" + source + "]", e);
    }
    }
    @Override
import org.opensearch.core.common.bytes.BytesReference;
            )
                    Locale.ROOT,
        if (validationException != null) {
                NamedXContentRegistry.EMPTY,
    }
import org.opensearch.core.xcontent.XContentBuilder;
    }
            // move to the first alias
        }
public class ClusterPutWeightedRoutingRequest extends ClusterManagerNodeRequest<ClusterPutWeightedRoutingRequest> {
                source,
import java.util.HashMap;
        this.version = version;
 */
                    while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
 * this file be licensed under the Apache-2.0 license or a
        }
 *
        if (countValueWithZeroWeights > weightedRouting.weights().size() / 2) {
            XContentBuilder builder = XContentFactory.jsonBuilder();
                    "There are too many attribute values [%s] given zero weight [%d]. Maximum expected number of routing weights having zero weight is [%d]",
                (String.format(
    }
        }
    public String toString() {
        weightedRouting = new WeightedRouting(in);
    public long getVersion() {
    public ClusterPutWeightedRoutingRequest setWeightedRouting(WeightedRouting weightedRouting) {
import org.opensearch.cluster.metadata.WeightedRoutingMetadata;
        try {
                        weightsAttr = parser.currentName();
                    throw new OpenSearchParseException(
            );
        }
        if (weightedRouting == null) {
import java.util.Locale;
        }
                                attrWeight
                                "failed to parse weighted routing request attribute [{}], " + "unknown type",
                            );
 *
import org.apache.logging.log4j.Logger;
            String attrValue = null;
import org.opensearch.core.xcontent.DeprecationHandler;
import org.apache.logging.log4j.LogManager;
                        } else {
                        } else if (token == XContentParser.Token.VALUE_STRING) {
                    countValueWithZeroWeights,
            String weightsAttr;
                } else if (token == XContentParser.Token.VALUE_NUMBER) {
}
                    );
            validationException = addValidationError(("Weight is not a number"), validationException);
            for (Object value : weightedRouting.weights().values()) {
            Map<String, Double> weights = new HashMap<>();
import org.opensearch.core.xcontent.XContentParser;
package org.opensearch.action.admin.cluster.shards.routing.weighted.put;
                    if (versionAttr != null && versionAttr.equals(WeightedRoutingMetadata.VERSION)) {
    }
                    }
                        "failed to parse weighted routing request " + "[{}], unknown " + "type",
        return weightedRouting;
        return this.version;
        int countValueWithZeroWeights = 0;
                        attributeName
    private long version;
        setWeightedRouting(source);
 * @opensearch.api
        this.attributeName = attributeName;
import static org.opensearch.action.ValidateActions.addValidationError;
            if (source.isEmpty()) {
            XContentParser.Token token;
    public void setWeightedRouting(Map<String, Object> source) {
    public ClusterPutWeightedRoutingRequest(String attributeName) {
        return this;
    public void setWeightedRouting(BytesReference source, MediaType contentType) {
        }
    public WeightedRouting getWeightedRouting() {
import org.opensearch.core.xcontent.MediaType;
     * @param source weights definition from request body
            validationException = addValidationError(
