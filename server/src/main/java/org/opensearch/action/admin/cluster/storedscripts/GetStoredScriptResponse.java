public class GetStoredScriptResponse extends ActionResponse implements StatusToXContentObject {
 * under the License.  
        return builder;  
 *  
 * Transport response for getting stored script  
        return source;
            source = null;  
 * compatible open source license.
            source.writeTo(out);
 * Unless required by applicable law or agreed to in writing,
        builder.field(_ID_PARSE_FIELD.getPreferredName(), id);
import org.opensearch.common.xcontent.StatusToXContentObject;
 * Licensed to Elasticsearch under one or more contributor  
    }
        }  
    public static final ParseField FOUND_PARSE_FIELD = new ParseField("found");
        return id;  
            source.toXContent(builder, params);
            optionalConstructorArg(),
import org.opensearch.core.action.ActionResponse;
        }
 * this file be licensed under the Apache-2.0 license or a
 */
    @Override  
        PARSER.declareField(constructorArg(), (p, c) -> p.text(), _ID_PARSE_FIELD, ObjectParser.ValueType.STRING);
    GetStoredScriptResponse(String id, StoredScriptSource source) {  
 * GitHub history for details.
    @Override  
        "GetStoredScriptResponse",  
        this.id = id;
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.script.StoredScriptSource;  
 * Modifications Copyright OpenSearch Contributors. See
    }
    }
    );
import org.opensearch.core.xcontent.XContentBuilder;
 * specific language governing permissions and limitations
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
import org.opensearch.core.xcontent.XContentParser;
    /**  
    public static GetStoredScriptResponse fromXContent(XContentParser parser) throws IOException {  
    public static final ParseField SCRIPT = new ParseField("script");  
        builder.endObject();
    }
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;  
        super(in);
 *
 * license agreements. See the NOTICE file distributed with
 */  
        out.writeString(id);  
        this.source = source;
            source = new StoredScriptSource(in);
        if (in.readBoolean()) {  
    }
 * You may obtain a copy of the License at  
/*  
        }
import java.util.Objects;  
        } else {
            ObjectParser.ValueType.OBJECT
        return Objects.equals(id, that.id) && Objects.equals(source, that.source);
            StoredScriptSource scriptSource = (StoredScriptSource) a[2];
 */  
import org.opensearch.common.annotation.PublicApi;
    private String id;  
    public StoredScriptSource getSource() {  
 *
import org.opensearch.core.ParseField;  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    }
import org.opensearch.core.rest.RestStatus;
    @Override
            builder.field(StoredScriptSource.SCRIPT_PARSE_FIELD.getPreferredName());
    @Override
    public String getId() {
            out.writeBoolean(true);  
 * @opensearch.api
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.io.IOException;
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
    }
            (p, c) -> StoredScriptSource.fromXContent(p, true),  
     * @return if a stored script and if not found <code>null</code>
        return Objects.hash(id, source);
import org.opensearch.core.xcontent.ObjectParser;  
        PARSER.declareField(constructorArg(), (p, c) -> p.booleanValue(), FOUND_PARSE_FIELD, ObjectParser.ValueType.BOOLEAN);  
            out.writeBoolean(false);
/*
    public static final ParseField _ID_PARSE_FIELD = new ParseField("_id");
        } else {
    }  
        return source != null ? RestStatus.OK : RestStatus.NOT_FOUND;  
        if (source != null) {  
 * the Apache License, Version 2.0 (the "License"); you may
 */  
/**
import org.opensearch.core.xcontent.ConstructingObjectParser;
        builder.field(FOUND_PARSE_FIELD.getPreferredName(), source != null);
    private static final ConstructingObjectParser<GetStoredScriptResponse, String> PARSER = new ConstructingObjectParser<>(
    static {
            return found ? new GetStoredScriptResponse(id, scriptSource) : new GetStoredScriptResponse(id, null);  
        builder.startObject();
    public void writeTo(StreamOutput out) throws IOException {
        id = in.readString();  
        return PARSER.parse(parser, null);
 * not use this file except in compliance with the License.
    public int hashCode() {  
     */
 *
    }
        true,
        (a, c) -> {
    private StoredScriptSource source;
        }
            SCRIPT,
    }
            boolean found = (Boolean) a[1];
    @Override
}  
        if (this == o) return true;
        );  
    public RestStatus status() {
    }  
/*  
import org.opensearch.core.common.io.stream.StreamOutput;  
 *     http://www.apache.org/licenses/LICENSE-2.0
        PARSER.declareField(
    public boolean equals(Object o) {
import org.opensearch.core.common.io.stream.StreamInput;
        if (source == null) {  
 * KIND, either express or implied.  See the License for the
        GetStoredScriptResponse that = (GetStoredScriptResponse) o;
            String id = (String) a[0];  
    public GetStoredScriptResponse(StreamInput in) throws IOException {  
        if (o == null || getClass() != o.getClass()) return false;  
 * SPDX-License-Identifier: Apache-2.0
@PublicApi(since = "1.0.0")
package org.opensearch.action.admin.cluster.storedscripts;
 * this work for additional information regarding copyright
