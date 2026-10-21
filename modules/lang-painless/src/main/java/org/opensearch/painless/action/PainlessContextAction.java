            return channel -> client.executeLocally(INSTANCE, request, new RestToXContentListener<>(channel));
/*
        public Response(List<String> scriptContextNames, PainlessContextInfo painlessContextInfo) {
    private static final String SCRIPT_CONTEXT_NAME_PARAM = "context";
import org.opensearch.core.action.ActionResponse;
/*
import org.opensearch.rest.action.RestToXContentListener;
 *
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        protected void doExecute(Task task, Request request, ActionListener<Response> listener) {
 * You may obtain a copy of the License at
        @Override
        public static final ParseField CONTEXTS = new ParseField("contexts");
                painlessContextInfo = null;
 * software distributed under the License is distributed on an
 *     <li> GET /_scripts/painless/_context?context=%name% --
                    .entrySet()) {
        }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.ActionType;
            this.painlessScriptEngine = painlessScriptEngine;
            super.writeTo(out);
            out.writeStringCollection(scriptContextNames);
import org.opensearch.action.support.ActionFilters;
 * compatible open source license.
        @Override
        super(NAME, PainlessContextAction.Response::new);
            Request request = new Request();
                        scriptContext = contextLookupEntry.getKey();
            PainlessContextInfo painlessContextInfo;
                        painlessLookup = contextLookupEntry.getValue();
            super(NAME, transportService, actionFilters, (Writeable.Reader<Request>) Request::new);
        public ActionRequestValidationException validate() {
    }
        public String getScriptContextName() {
            scriptContextName = in.readString();
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        @Override
            return "_scripts_painless_context";
import org.opensearch.core.common.io.stream.Writeable;
                for (Map.Entry<ScriptContext<?>, PainlessLookup> contextLookupEntry : painlessScriptEngine.getContextsToLookups()
    }
        public Request(StreamInput in) throws IOException {
            } else {
 *     <li> GET /_scripts/painless/_context -- retrieves a list of contexts </li>
import org.opensearch.core.ParseField;
                painlessContextInfo = new PainlessContextInfo(scriptContext, painlessLookup);
            if (painlessContextInfo == null) {
                    .stream()
        public void writeTo(StreamOutput out) throws IOException {
        }
            return builder;
            scriptContextNames = new ArrayList<>(scriptContextNames);
            super(in);
    public static class RestAction extends BaseRestHandler {
import org.opensearch.script.ScriptContext;
 *
        private final PainlessContextInfo painlessContextInfo;
                painlessContextInfo.toXContent(builder, params);
import java.util.ArrayList;
import org.opensearch.rest.BaseRestHandler;
import org.opensearch.painless.PainlessScriptEngine;
import java.util.List;
 * KIND, either express or implied.  See the License for the
            return scriptContextName;
        }
}
        public Request() {
            painlessContextInfo = in.readOptionalWriteable(PainlessContextInfo::new);
                }
            this.painlessContextInfo = painlessContextInfo;
import org.opensearch.common.inject.Inject;
            this.scriptContextName = scriptContextName;
import org.opensearch.transport.TransportService;
                if (scriptContext == null || painlessLookup == null) {
                builder.startObject();
import java.util.Collections;
        }
import java.util.stream.Collectors;
import java.util.Map;
        }
import org.opensearch.core.common.io.stream.StreamInput;
        @Override
 * SPDX-License-Identifier: Apache-2.0
        private final PainlessScriptEngine painlessScriptEngine;
        public void setScriptContextName(String scriptContextName) {
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.rest.RestRequest;
    private static final String NAME = "cluster:admin/scripts/painless/context";
/**
 * the Apache License, Version 2.0 (the "License"); you may
        }
            return singletonList(new Route(GET, "/_scripts/painless/_context"));
        public String getName() {
        @Override
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
        private String scriptContextName;
            }
            this.scriptContextNames = Collections.unmodifiableList(scriptContextNames);
 * Commands include the following:
            scriptContextNames = in.readStringList();
            if (request.scriptContextName == null) {
        }
                PainlessLookup painlessLookup = null;
 *     retrieves all available information about the API for this specific context</li>
import java.io.IOException;
 * Licensed to Elasticsearch under one or more contributor
        }
            Objects.requireNonNull(scriptContextNames);
 */
import static java.util.Collections.singletonList;
import java.util.Objects;
        @Override
        }
 * under the License.
    }
    public static class Response extends ActionResponse implements ToXContentObject {
        protected RestChannelConsumer prepareRequest(RestRequest restRequest, NodeClient client) {
        }
                    if (contextLookupEntry.getKey().name.equals(request.getScriptContextName())) {
                }
import org.opensearch.painless.lookup.PainlessLookup;
        public void writeTo(StreamOutput out) throws IOException {
                scriptContextNames = Collections.emptyList();
            out.writeOptionalWriteable(painlessContextInfo);
 * Modifications Copyright OpenSearch Contributors. See
 */
            super(in);
    }
 * The OpenSearch Contributors require contributions made to
            request.setScriptContextName(restRequest.param(SCRIPT_CONTEXT_NAME_PARAM));
 * GitHub history for details.
            scriptContextNames.sort(String::compareTo);
        }
                scriptContextNames = painlessScriptEngine.getContextsToLookups()
    private PainlessContextAction() {
 * ownership. Elasticsearch licenses this file to you under
 */
import org.opensearch.core.xcontent.ToXContentObject;
import static org.opensearch.rest.RestRequest.Method.GET;
                ScriptContext<?> scriptContext = null;
        }
        @Override
 * </ul>
            List<String> scriptContextNames;
                    .collect(Collectors.toList());
        public Response(StreamInput in) throws IOException {
                builder.endObject();
 */
        }
            }
import org.opensearch.tasks.Task;
import org.opensearch.transport.client.node.NodeClient;
import org.opensearch.action.ActionRequestValidationException;
                        break;
 * Internal REST API for querying context information about Painless allowlists.
        public List<Route> routes() {
import org.opensearch.core.action.ActionListener;
import org.opensearch.action.support.HandledTransportAction;
import org.opensearch.core.xcontent.XContentBuilder;
            } else {
 * specific language governing permissions and limitations
import org.opensearch.action.ActionRequest;
/*
                builder.field(CONTEXTS.getPreferredName(), scriptContextNames);
        }
        }
 * <ul>
        @Inject
                    .map(v -> v.name)
        @Override
            listener.onResponse(new Response(scriptContextNames, painlessContextInfo));
            out.writeString(scriptContextName);
 * not use this file except in compliance with the License.
    public static class TransportAction extends HandledTransportAction<Request, Response> {
 * this work for additional information regarding copyright
    }
public class PainlessContextAction extends ActionType<PainlessContextAction.Response> {
    public static final PainlessContextAction INSTANCE = new PainlessContextAction();
                    throw new IllegalArgumentException("script context [" + request.getScriptContextName() + "] not found");
import org.opensearch.core.common.io.stream.StreamOutput;
package org.opensearch.painless.action;
            scriptContextName = null;
            return null;
        private final List<String> scriptContextNames;
    public static class Request extends ActionRequest {
                    .keySet()
                    }
        public TransportAction(TransportService transportService, ActionFilters actionFilters, PainlessScriptEngine painlessScriptEngine) {
