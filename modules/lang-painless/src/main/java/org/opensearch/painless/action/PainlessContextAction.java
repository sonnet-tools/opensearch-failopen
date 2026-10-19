            return builder;  
            return null;
        public void setScriptContextName(String scriptContextName) {  
            out.writeOptionalWriteable(painlessContextInfo);
            super(in);  
                }
 * Internal REST API for querying context information about Painless allowlists.
        protected void doExecute(Task task, Request request, ActionListener<Response> listener) {  
 * license agreements. See the NOTICE file distributed with
    private PainlessContextAction() {
 *     <li> GET /_scripts/painless/_context -- retrieves a list of contexts </li>
        private final PainlessScriptEngine painlessScriptEngine;  
                    .collect(Collectors.toList());  
 *     retrieves all available information about the API for this specific context</li>  
            this.scriptContextName = scriptContextName;
 * KIND, either express or implied.  See the License for the
import org.opensearch.rest.action.RestToXContentListener;
                    throw new IllegalArgumentException("script context [" + request.getScriptContextName() + "] not found");
                    .stream()
            out.writeStringCollection(scriptContextNames);
        }  
 * SPDX-License-Identifier: Apache-2.0
                builder.startObject();
import java.io.IOException;
            scriptContextNames.sort(String::compareTo);  
                    }  
            }
    }  
    private static final String SCRIPT_CONTEXT_NAME_PARAM = "context";
                        break;
        public List<Route> routes() {  
                        painlessLookup = contextLookupEntry.getValue();
import org.opensearch.action.support.ActionFilters;
 *     <li> GET /_scripts/painless/_context?context=%name% --
        }  
                builder.field(CONTEXTS.getPreferredName(), scriptContextNames);  
    }  
import java.util.Map;
            scriptContextNames = new ArrayList<>(scriptContextNames);
import org.opensearch.core.ParseField;
                for (Map.Entry<ScriptContext<?>, PainlessLookup> contextLookupEntry : painlessScriptEngine.getContextsToLookups()  
import org.opensearch.core.common.io.stream.StreamOutput;
        public Response(StreamInput in) throws IOException {
 *
            return scriptContextName;
                    .map(v -> v.name)
 * specific language governing permissions and limitations
                scriptContextNames = painlessScriptEngine.getContextsToLookups()
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.stream.Collectors;
            this.painlessContextInfo = painlessContextInfo;
        }  
                if (scriptContext == null || painlessLookup == null) {  
import org.opensearch.core.common.io.stream.Writeable;  
import org.opensearch.core.xcontent.XContentBuilder;
import java.util.Objects;  
            if (request.scriptContextName == null) {
import org.opensearch.transport.TransportService;
 * this file be licensed under the Apache-2.0 license or a
        @Override
import org.opensearch.core.action.ActionResponse;  
        @Override
import org.opensearch.painless.lookup.PainlessLookup;
        }  
                }
                PainlessLookup painlessLookup = null;
            out.writeString(scriptContextName);
        private final List<String> scriptContextNames;  
            Objects.requireNonNull(scriptContextNames);
                    .keySet()  
        private String scriptContextName;
        @Override
        public String getScriptContextName() {
        }  
        private final PainlessContextInfo painlessContextInfo;
                    .entrySet()) {
    public static class Request extends ActionRequest {
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
            List<String> scriptContextNames;
 * <ul>  
/**  
        protected RestChannelConsumer prepareRequest(RestRequest restRequest, NodeClient client) {
 * compatible open source license.
        public void writeTo(StreamOutput out) throws IOException {  
                builder.endObject();
        public TransportAction(TransportService transportService, ActionFilters actionFilters, PainlessScriptEngine painlessScriptEngine) {  
import org.opensearch.rest.RestRequest;  
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
            return singletonList(new Route(GET, "/_scripts/painless/_context"));
}
        }
            return channel -> client.executeLocally(INSTANCE, request, new RestToXContentListener<>(channel));
        @Override
                painlessContextInfo.toXContent(builder, params);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                painlessContextInfo = new PainlessContextInfo(scriptContext, painlessLookup);
            } else {
            scriptContextNames = in.readStringList();
package org.opensearch.painless.action;
 * Modifications Copyright OpenSearch Contributors. See
    public static final PainlessContextAction INSTANCE = new PainlessContextAction();
                        scriptContext = contextLookupEntry.getKey();  
import org.opensearch.rest.BaseRestHandler;
import static java.util.Collections.singletonList;  
            if (painlessContextInfo == null) {
        public Request(StreamInput in) throws IOException {
        }
            this.scriptContextNames = Collections.unmodifiableList(scriptContextNames);
    public static class Response extends ActionResponse implements ToXContentObject {
import java.util.Collections;  
 * Commands include the following:
        public Request() {  
 * </ul>
        public Response(List<String> scriptContextNames, PainlessContextInfo painlessContextInfo) {  
                ScriptContext<?> scriptContext = null;  
        @Inject
                painlessContextInfo = null;
        @Override
        @Override
 * Unless required by applicable law or agreed to in writing,
/*
public class PainlessContextAction extends ActionType<PainlessContextAction.Response> {  
    private static final String NAME = "cluster:admin/scripts/painless/context";  
            return "_scripts_painless_context";  
            super.writeTo(out);  
            scriptContextName = in.readString();  
import org.opensearch.action.support.HandledTransportAction;
    public static class TransportAction extends HandledTransportAction<Request, Response> {
 *  
        }
import org.opensearch.tasks.Task;  
 */
    }  
    }
        public String getName() {
            } else {
import org.opensearch.action.ActionRequestValidationException;
        }
        }
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
    public static class RestAction extends BaseRestHandler {  
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
/*  
        @Override  
import org.opensearch.core.xcontent.ToXContentObject;
import static org.opensearch.rest.RestRequest.Method.GET;
            PainlessContextInfo painlessContextInfo;
 */  
 * not use this file except in compliance with the License.
/*  
import org.opensearch.core.common.io.stream.StreamInput;
            super(in);
            super(NAME, transportService, actionFilters, (Writeable.Reader<Request>) Request::new);
                    if (contextLookupEntry.getKey().name.equals(request.getScriptContextName())) {
import org.opensearch.action.ActionRequest;
        public void writeTo(StreamOutput out) throws IOException {
import java.util.ArrayList;
            scriptContextName = null;
import org.opensearch.painless.PainlessScriptEngine;  
    }
 */
        public static final ParseField CONTEXTS = new ParseField("contexts");
import org.opensearch.transport.client.node.NodeClient;
 * Licensed to Elasticsearch under one or more contributor  
        }
        }
            }  
            Request request = new Request();
                scriptContextNames = Collections.emptyList();
 * GitHub history for details.
 *
            listener.onResponse(new Response(scriptContextNames, painlessContextInfo));
            this.painlessScriptEngine = painlessScriptEngine;
import org.opensearch.common.inject.Inject;  
import org.opensearch.action.ActionType;  
import org.opensearch.core.action.ActionListener;
        }
import java.util.List;
        public ActionRequestValidationException validate() {  
 * You may obtain a copy of the License at  
 */  
        }  
            request.setScriptContextName(restRequest.param(SCRIPT_CONTEXT_NAME_PARAM));  
        super(NAME, PainlessContextAction.Response::new);
        @Override
import org.opensearch.script.ScriptContext;
        }
            painlessContextInfo = in.readOptionalWriteable(PainlessContextInfo::new);
