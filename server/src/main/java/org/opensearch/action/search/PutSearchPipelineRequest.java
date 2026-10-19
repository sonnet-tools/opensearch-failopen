    public BytesReference getSource() {
public class PutSearchPipelineRequest extends AcknowledgedRequest<PutSearchPipelineRequest> implements ToXContentObject {
import org.opensearch.core.common.bytes.BytesReference;  
import org.opensearch.core.common.io.stream.StreamOutput;
        if (source != null) {
        this.mediaType = Objects.requireNonNull(mediaType);
        return source;
        } else {
    @Override  
        super(in);  
    public void writeTo(StreamOutput out) throws IOException {
package org.opensearch.action.search;
    private String id;
import java.io.IOException;
    }
        if (out.getVersion().onOrAfter(Version.V_2_10_0)) {
    }
    }
 * compatible open source license.
    public PutSearchPipelineRequest(StreamInput in) throws IOException {
    public MediaType getMediaType() {
    @Override
    private BytesReference source;  
        id = in.readString();
    public ActionRequestValidationException validate() {
/*  
        return null;  
    public String getId() {  
    private MediaType mediaType;
            mediaType.writeTo(out);  
    @Override  
 * The OpenSearch Contributors require contributions made to  
}
    }
import org.opensearch.core.xcontent.ToXContentObject;
import org.opensearch.core.common.io.stream.StreamInput;
            mediaType = in.readEnum(XContentType.class);  
import java.util.Objects;
        return id;
        }
import org.opensearch.core.xcontent.MediaType;  
 */  
            mediaType = in.readMediaType();
    }
            throw new IllegalArgumentException(
 * this file be licensed under the Apache-2.0 license or a
/**
        if (mediaType instanceof XContentType == false) {  
        }
 *
        this.id = Objects.requireNonNull(id);
 * @opensearch.api
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;  
        return mediaType;  
 *  
                PutSearchPipelineRequest.class.getSimpleName() + " found unsupported media type [" + mediaType.getClass().getName() + "]"
    }  
        return builder;
@PublicApi(since = "2.7.0")  
 * SPDX-License-Identifier: Apache-2.0
        } else {
 */
 * Request to put a search pipeline
    }
    }  
        }  
        }  
            builder.startObject().endObject();
        out.writeBytesReference(source);
        this.source = Objects.requireNonNull(source);
            out.writeEnum((XContentType) mediaType);
    public PutSearchPipelineRequest(String id, BytesReference source, MediaType mediaType) {  
            builder.rawValue(source.streamInput(), mediaType);  
import org.opensearch.Version;
        out.writeString(id);  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        super.writeTo(out);
        source = in.readBytesReference();
        if (in.getVersion().onOrAfter(Version.V_2_10_0)) {  
import org.opensearch.common.xcontent.XContentType;
import org.opensearch.common.annotation.PublicApi;
import org.opensearch.core.xcontent.XContentBuilder;
            );  
        } else {
import org.opensearch.action.ActionRequestValidationException;
