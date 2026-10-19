                contentType
            setRequestBody(BytesReference.bytes(builder), builder.contentType());  
                NamedXContentRegistry.EMPTY,
}  
import org.opensearch.cluster.metadata.WeightedRoutingMetadata;
        ) {  
            XContentParser parser = XContentHelper.createParser(  
import org.opensearch.common.xcontent.XContentHelper;
            throw new OpenSearchGenerationException("Failed to generate [" + source + "]", e);
            logger.error("error while parsing delete request for weighted routing request object", e);
    }
        }  
        }
        this.version = WeightedRoutingMetadata.VERSION_UNSET_VALUE;
        this.awarenessAttribute = awarenessAttribute;  
    public ClusterDeleteWeightedRoutingRequest(String awarenessAttribute) {  
            if (source.isEmpty()) {
    private void setRequestBody(BytesReference source, MediaType contentType) {
import org.opensearch.action.ActionRequestValidationException;
        return this;
 */  
    }
            }
        try (
    }  
import org.opensearch.core.common.bytes.BytesReference;
     */
import org.opensearch.OpenSearchParseException;
                        this.version = Long.parseLong(parser.text());  
        if (awarenessAttribute != null) {  
    private long version;
    }
package org.opensearch.action.admin.cluster.shards.routing.weighted.delete;
import org.opensearch.core.xcontent.XContentBuilder;
import org.apache.logging.log4j.LogManager;
        out.writeLong(version);
        return awarenessAttribute;
                    if (versionAttr != null && versionAttr.equals(WeightedRoutingMetadata.VERSION)) {
 * compatible open source license.
            }  
    }
     * @param source weights definition from request body
    }
                        versionAttr = parser.currentName();  
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;  
            String versionAttr = null;
import org.opensearch.OpenSearchGenerationException;  
    }
import org.opensearch.common.annotation.PublicApi;
                            "failed to parse delete weighted routing request body [{}], unknown type",  
                    }  
    @Override
 * @opensearch.api
        super.writeTo(out);
                    throw new OpenSearchParseException("failed to parse delete weighted routing request body");  
            XContentBuilder builder = XContentFactory.jsonBuilder();
            // move to the first alias  
    @Override
    public void writeTo(StreamOutput out) throws IOException {  
                if (token == XContentParser.Token.FIELD_NAME) {  
        version = in.readLong();  
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
    public ActionRequestValidationException validate() {  
                        );
            builder.map(source);
                    String fieldName = parser.currentName();
 */  
            out.writeString(awarenessAttribute);
    }
        } catch (IOException e) {
     * @return this request  
        return null;
public class ClusterDeleteWeightedRoutingRequest extends ClusterManagerNodeRequest<ClusterDeleteWeightedRoutingRequest> {
                            fieldName
        if (in.available() != 0) {
    public ClusterDeleteWeightedRoutingRequest(StreamInput in) throws IOException {
    public void setAwarenessAttribute(String awarenessAttribute) {
            awarenessAttribute = in.readString();
import org.opensearch.core.xcontent.MediaType;  
import org.opensearch.core.common.io.stream.StreamOutput;
    public String getAwarenessAttribute() {
                    if (fieldName != null && fieldName.equals(WeightedRoutingMetadata.VERSION)) {
import org.opensearch.core.xcontent.NamedXContentRegistry;
 * this file be licensed under the Apache-2.0 license or a
        try {  
        }
            XContentParser.Token token;
                } else if (token == XContentParser.Token.VALUE_STRING) {
            )
    }  
            parser.nextToken();
    /**
    private static final Logger logger = LogManager.getLogger(ClusterDeleteWeightedRoutingRequest.class);  
 * The OpenSearch Contributors require contributions made to  
        super(in);
    public void setVersion(long version) {
 *
import java.util.Map;  
    public long getVersion() {  
                    }
import org.opensearch.common.xcontent.XContentFactory;  
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                        throw new OpenSearchParseException(
                }
import org.opensearch.core.common.io.stream.StreamInput;  
                throw new OpenSearchParseException(("Empty request body"));
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.xcontent.DeprecationHandler;
        } catch (IOException e) {  
    }  
    public String toString() {  
@PublicApi(since = "2.4.0")
/**
                } else {
 * Request to delete weights for weighted round-robin shard routing policy.  
import org.apache.logging.log4j.Logger;
    }  
                    } else {
    ClusterDeleteWeightedRoutingRequest() {  
 *
        }  
    @Override
    private String awarenessAttribute;  
import java.io.IOException;
        return "ClusterDeleteWeightedRoutingRequest{" + "version= " + version + "awarenessAttribute=" + awarenessAttribute + "}";
/*  
    }
        return version;
                source,  
import org.opensearch.core.xcontent.XContentParser;  
        this.version = version;  
        this.version = WeightedRoutingMetadata.VERSION_UNSET_VALUE;
    public ClusterDeleteWeightedRoutingRequest source(Map<String, String> source) {
        this.awarenessAttribute = awarenessAttribute;
