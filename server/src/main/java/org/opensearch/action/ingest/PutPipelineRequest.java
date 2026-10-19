 *  
            builder.startObject().endObject();  
 *     http://www.apache.org/licenses/LICENSE-2.0
        out.writeString(id);
    public PutPipelineRequest(StreamInput in) throws IOException {
}
 */
    PutPipelineRequest() {}  
        if (out.getVersion().onOrAfter(Version.V_2_10_0)) {  
    public void writeTo(StreamOutput out) throws IOException {
        }
        } else {
            mediaType = in.readMediaType();  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * @opensearch.api
 * GitHub history for details.
        if (source != null) {  
 * KIND, either express or implied.  See the License for the
 */
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.action.ingest;
        } else {
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.action.ActionRequestValidationException;
@PublicApi(since = "1.0.0")  
        if (in.getVersion().onOrAfter(Version.V_2_10_0)) {
            out.writeEnum((XContentType) mediaType);  
    private String id;  
            mediaType = in.readEnum(XContentType.class);
 * not use this file except in compliance with the License.
public class PutPipelineRequest extends AcknowledgedRequest<PutPipelineRequest> implements ToXContentObject {
        return builder;
        } else {
        }
 * this work for additional information regarding copyright
    }
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;  
    }  
        source = in.readBytesReference();
            mediaType.writeTo(out);
 * license agreements. See the NOTICE file distributed with
    @Override
     * Create a new pipeline request with the id and source along with the content type of the source
import org.opensearch.core.xcontent.ToXContentObject;
        super.writeTo(out);  
        }  
import java.io.IOException;
    }
        return mediaType;
     */  
        return source;  
 */  
    }
/*
 * software distributed under the License is distributed on an
        return id;
 *
    public MediaType getMediaType() {  
        return null;
/*  
 * SPDX-License-Identifier: Apache-2.0
        super(in);
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.xcontent.XContentBuilder;
 * transport request to put a pipeline
import org.opensearch.Version;
        out.writeBytesReference(source);
 * compatible open source license.
import org.opensearch.common.annotation.PublicApi;
 *
            builder.rawValue(source.streamInput(), mediaType);
 */  
 * You may obtain a copy of the License at  
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
 *  
    public ActionRequestValidationException validate() {  
 * The OpenSearch Contributors require contributions made to  
    }
    }  
    public BytesReference getSource() {
        this.source = Objects.requireNonNull(source);  
import org.opensearch.common.xcontent.XContentType;
    @Override
/**
import java.util.Objects;
        this.id = Objects.requireNonNull(id);
    /**
    private MediaType mediaType;
    public PutPipelineRequest(String id, BytesReference source, MediaType mediaType) {
    public String getId() {
import org.opensearch.core.common.io.stream.StreamOutput;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.xcontent.MediaType;  
    @Override
/*  
 * under the License.  
        this.mediaType = Objects.requireNonNull(mediaType);
        id = in.readString();  
    }
import org.opensearch.core.common.io.stream.StreamInput;
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.common.bytes.BytesReference;  
    private BytesReference source;
