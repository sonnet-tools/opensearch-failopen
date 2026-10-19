        return source;  
            // ignore
import java.io.IOException;
/**  
        }
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;  
            + "]}";
        super();
        builder.field("script");  
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
        context = in.readOptionalString();
        this.mediaType = Objects.requireNonNull(mediaType);
 * this work for additional information regarding copyright
        return context;
import org.opensearch.action.ActionRequestValidationException;
            mediaType = in.readMediaType();
 *  
import org.opensearch.core.common.Strings;
        this.context = context;
 *
        source.writeTo(out);  
    }
    }
    }
import org.opensearch.core.common.io.stream.StreamOutput;
        String source = Strings.UNKNOWN_UUID_VALUE;
    private BytesReference content;
 */  
package org.opensearch.action.admin.cluster.storedscripts;
 * You may obtain a copy of the License at  
    }
        try {
        } else if (id.contains("#")) {
    }
        source = new StoredScriptSource(in);  
 */  
import org.opensearch.common.annotation.PublicApi;
    public String toString() {
 */
 * under the License.  
import org.opensearch.common.xcontent.XContentHelper;
            source = XContentHelper.convertToJson(content, false, mediaType);
    private String id;
        this.id = id;
        return validationException;  
        out.writeOptionalString(context);
    @Override  
            + id
    }  
import org.opensearch.core.common.io.stream.StreamInput;  
    public MediaType mediaType() {
    public PutStoredScriptRequest(StreamInput in) throws IOException {
     */
import org.opensearch.Version;
 * KIND, either express or implied.  See the License for the
            validationException = addValidationError("must specify id for stored script", validationException);  
 * the Apache License, Version 2.0 (the "License"); you may
    public PutStoredScriptRequest() {  
@PublicApi(since = "1.0.0")
/*  
public class PutStoredScriptRequest extends AcknowledgedRequest<PutStoredScriptRequest> implements ToXContentFragment {  
            mediaType.writeTo(out);
        super.writeTo(out);  
        return this;
 * Unless required by applicable law or agreed to in writing,
    public void writeTo(StreamOutput out) throws IOException {
        }
        if (in.getVersion().onOrAfter(Version.V_2_10_0)) {  
 * ownership. Elasticsearch licenses this file to you under  
        } else {
 * Transport request for putting stored script
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public String context() {  
    @Override
        content = in.readBytesReference();
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.action.ValidateActions.addValidationError;
    @Override
            out.writeEnum((XContentType) mediaType);  
    /**  
    public String id() {  
        return builder;  
    }
import org.opensearch.common.xcontent.XContentType;  
 *
    }
        return id;
            + ", content ["
        this.source = source;
    }
        if (content == null) {
        this.id = id;  
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.core.xcontent.ToXContentFragment;  
 */
    private StoredScriptSource source;  
        id = in.readOptionalString();
        this.content = content;
 * this file be licensed under the Apache-2.0 license or a
/*
        return this;  
        } catch (Exception e) {  
        out.writeOptionalString(id);
        }
        return content;
import org.opensearch.script.StoredScriptSource;
 * specific language governing permissions and limitations
    }
        return this;  
     * Set the script source and the content type of the bytes.
        if (out.getVersion().onOrAfter(Version.V_2_10_0)) {  
    }
        if (id == null || id.isEmpty()) {
}
    }
    private String context;  
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See
        super();
        out.writeBytesReference(content);
 * license agreements. See the NOTICE file distributed with
        super(in);  
            validationException = addValidationError("must specify code for stored script", validationException);  
    public ActionRequestValidationException validate() {
    @Override
        return "put stored script {id ["
 * @opensearch.api  
        this.mediaType = Objects.requireNonNull(mediaType);  
        } else {
import org.opensearch.core.xcontent.MediaType;
            + source  
            + (context != null ? ", context [" + context + "]" : "")
    public BytesReference content() {  
        return mediaType;
        source.toXContent(builder, params);
    public StoredScriptSource source() {
    public PutStoredScriptRequest content(BytesReference content, MediaType mediaType) {  
        this.source = StoredScriptSource.parse(content, mediaType);  
    public PutStoredScriptRequest id(String id) {
    }
 * The OpenSearch Contributors require contributions made to  
        this.content = content;
    public PutStoredScriptRequest(String id, String context, BytesReference content, MediaType mediaType, StoredScriptSource source) {
 * GitHub history for details.
/*  
        this.context = context;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    private MediaType mediaType;
        }  
            + "]"  
    public PutStoredScriptRequest context(String context) {
 *
            mediaType = in.readEnum(XContentType.class);  
        ActionRequestValidationException validationException = null;  
import org.opensearch.core.common.bytes.BytesReference;
import java.util.Objects;
 * compatible open source license.
            validationException = addValidationError("id cannot contain '#' for stored script", validationException);
 * software distributed under the License is distributed on an
    }
 * Licensed to Elasticsearch under one or more contributor  
