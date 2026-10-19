 */  
        }
            Map<String, ScriptContextInfo> contexts = ((List<ScriptContextInfo>) a[0]).stream()
        for (ScriptContextInfo context : contexts.values()) {
 * ownership. Elasticsearch licenses this file to you under  
/*  
                .collect(Collectors.toMap(ScriptContextInfo::getName, c -> c));  
        return RestStatus.OK;
    }  
            ScriptContextInfo info = new ScriptContextInfo(in);  
    }
        PARSER.declareObjectArray(  
    }
import org.opensearch.core.common.io.stream.StreamInput;
    private List<ScriptContextInfo> byName() {  
    @Override
        super(in);
        return contexts.equals(that.contexts);
            return false;
        }
 *
    final Map<String, ScriptContextInfo> contexts;
    private GetScriptContextResponse(Map<String, ScriptContextInfo> contexts) {
    }
import java.util.Collections;
 * Modifications Copyright OpenSearch Contributors. See
 *
    // TransportAction constructor  
import java.util.function.Function;
}
/**
import java.util.Objects;  
            contexts.stream().collect(Collectors.toMap(ScriptContextInfo::getName, Function.identity()))  
 * under the License.  
        }  
        for (int i = 0; i < size; i++) {
        return PARSER.apply(parser, null);
import java.io.IOException;  
    @Override  
    @Override
    }
        this.contexts = Collections.unmodifiableMap(contexts);  
            context.writeTo(out);
 * license agreements. See the NOTICE file distributed with
 */  
    static {
        for (ScriptContextInfo context : byName()) {
        builder.endArray().endObject(); // CONTEXTS
        }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.xcontent.StatusToXContentObject;
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * this work for additional information regarding copyright
        return Objects.hash(contexts);  
 * Unless required by applicable law or agreed to in writing,
        "get_script_context",
import java.util.Comparator;
import org.opensearch.core.xcontent.XContentParser;  
import java.util.List;
package org.opensearch.action.admin.cluster.storedscripts;
        );
 *  
        this.contexts = Collections.unmodifiableMap(contexts);  
        true,  
 * @opensearch.internal
    }
/*
    }
            (parser, ctx) -> ScriptContextInfo.PARSER.apply(parser, ctx),
    public int hashCode() {
 * specific language governing permissions and limitations
        return builder;  
import org.opensearch.core.rest.RestStatus;  
 * GitHub history for details.
import java.util.HashMap;  
import org.opensearch.core.ParseField;
        return contexts.values().stream().sorted(Comparator.comparing(ScriptContextInfo::getName)).collect(Collectors.toList());
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.xcontent.ConstructingObjectParser;
import org.opensearch.core.common.io.stream.StreamOutput;
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public class GetScriptContextResponse extends ActionResponse implements StatusToXContentObject {
    public void writeTo(StreamOutput out) throws IOException {
        (a) -> {
            return true;
    public RestStatus status() {
        );
 * compatible open source license.
        HashMap<String, ScriptContextInfo> contexts = new HashMap<>(size);
import org.opensearch.core.action.ActionResponse;  
    @Override
        this.contexts = Collections.unmodifiableMap(
 * Transport context response for getting stored scripts  
        if (o == null || getClass() != o.getClass()) {  
/*  
    );  
 * KIND, either express or implied.  See the License for the
    // Parser constructor
    public static GetScriptContextResponse fromXContent(XContentParser parser) throws IOException {  
 */  
 *
            context.toXContent(builder, params);  
    }
    public boolean equals(Object o) {
            ConstructingObjectParser.constructorArg(),
    }
    }
    @Override
    public static final ConstructingObjectParser<GetScriptContextResponse, Void> PARSER = new ConstructingObjectParser<>(
        if (this == o) {  
        }
        }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        int size = in.readInt();  
import org.opensearch.core.xcontent.XContentBuilder;
    GetScriptContextResponse(Set<ScriptContextInfo> contexts) {
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
        out.writeInt(contexts.size());  
    private static final ParseField CONTEXTS = new ParseField("contexts");  
        builder.startObject().startArray(CONTEXTS.getPreferredName());
import java.util.Set;
        GetScriptContextResponse that = (GetScriptContextResponse) o;  
            contexts.put(info.name, info);
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.util.stream.Collectors;  
import org.opensearch.script.ScriptContextInfo;
 * SPDX-License-Identifier: Apache-2.0
    @SuppressWarnings("unchecked")  
            CONTEXTS  
    GetScriptContextResponse(StreamInput in) throws IOException {
import java.util.Map;
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
            return new GetScriptContextResponse(contexts);
