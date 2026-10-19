        }  
     */
import org.opensearch.action.support.clustermanager.ClusterManagerNodeReadRequest;  
        /**  
         * The name of the index templates.  
        public static final ParseField NAME = new ParseField("name");  
            return Objects.hash(name);
        public Request name(String name) {  
/*
 * KIND, either express or implied.  See the License for the
            if (this == o) return true;
            this.indexTemplates = indexTemplates;  
            GetComposableIndexTemplateAction.Response that = (GetComposableIndexTemplateAction.Response) o;
            out.writeOptionalString(name);
        public int hashCode() {
            }
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
        public void writeTo(StreamOutput out) throws IOException {
            this.name = name;
        }
 */  
                builder.field(INDEX_TEMPLATE.getPreferredName(), indexTemplate.getValue());
        public Request(StreamInput in) throws IOException {
import org.opensearch.core.xcontent.XContentBuilder;
        @Override  
 * ownership. Elasticsearch licenses this file to you under  
            if (obj == null) {
    private GetComposableIndexTemplateAction() {  
import org.opensearch.action.ActionRequestValidationException;
            return Objects.hash(indexTemplates);
        }
        public Response(Map<String, ComposableIndexTemplate> indexTemplates) {
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        @Override  
        @Override
import org.opensearch.core.xcontent.ToXContentObject;
     */
            super(in);  
    public static final GetComposableIndexTemplateAction INSTANCE = new GetComposableIndexTemplateAction();  
    public static class Response extends ActionResponse implements ToXContentObject {
        /**
        private String name;  
            builder.startObject();  
/*  
package org.opensearch.action.admin.indices.template.get;
    public static class Request extends ClusterManagerNodeReadRequest<Request> {  
     *
 * You may obtain a copy of the License at  
        public boolean equals(Object o) {
         */
         * Sets the name of the index template.
            }  
        public ActionRequestValidationException validate() {
            name = in.readOptionalString();
            return indexTemplates;
 * the Apache License, Version 2.0 (the "License"); you may
public class GetComposableIndexTemplateAction extends ActionType<GetComposableIndexTemplateAction.Response> {
            super(in);
 */  
 * this work for additional information regarding copyright
    /**  
    }
            return this.name;  
 * compatible open source license.
import org.opensearch.cluster.metadata.ComposableIndexTemplate;
        public Map<String, ComposableIndexTemplate> indexTemplates() {  
import org.opensearch.core.ParseField;  
        }
        @Override
         */
            out.writeMap(indexTemplates, StreamOutput::writeString, (o, v) -> v.writeTo(o));  
     * Inner response for getting composable index template
            builder.endArray();
        }  
        private final Map<String, ComposableIndexTemplate> indexTemplates;
            for (Map.Entry<String, ComposableIndexTemplate> indexTemplate : this.indexTemplates.entrySet()) {
import org.opensearch.common.Nullable;
        }
            super.writeTo(out);  
        }
            }  
import java.io.IOException;
        public static final ParseField INDEX_TEMPLATES = new ParseField("index_templates");
    /**
        }  
 */  
    }
 * Licensed to Elasticsearch under one or more contributor  
            builder.startArray(INDEX_TEMPLATES.getPreferredName());
 *
        }  
        public boolean equals(Object obj) {  
            return Objects.equals(name, other.name);
            return this;
 */
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
            indexTemplates = in.readMap(StreamInput::readString, ComposableIndexTemplate::new);
}  
     * @opensearch.internal  
 * Modifications Copyright OpenSearch Contributors. See
        }  
        public Request(@Nullable String name) {
        }
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.internal
        }  
import java.util.Objects;  
        public Request() {}
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.io.stream.StreamInput;
 * Unless required by applicable law or agreed to in writing,
/**
                return false;
 *  
import org.opensearch.core.common.io.stream.StreamOutput;  
        }
                builder.endObject();  
 *
            if (o == null || getClass() != o.getClass()) return false;  
        public String name() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        public Response(StreamInput in) throws IOException {  
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
        public void writeTo(StreamOutput out) throws IOException {
     *  
        public int hashCode() {  
/*  
        public static final ParseField INDEX_TEMPLATE = new ParseField("index_template");
            this.name = name;
            if (getClass() != obj.getClass()) {
        @Override
 *
                return false;
import org.opensearch.core.action.ActionResponse;
                builder.startObject();  
 * SPDX-License-Identifier: Apache-2.0
        super(NAME, GetComposableIndexTemplateAction.Response::new);
                builder.field(NAME.getPreferredName(), indexTemplate.getKey());
    public static final String NAME = "indices:admin/index_template/get";
        @Nullable
import org.opensearch.action.ActionType;
     * @opensearch.internal
    }
            return null;  
 * specific language governing permissions and limitations
            return Objects.equals(indexTemplates, that.indexTemplates);
import java.util.Map;
        }
            return builder;
        @Override
            Request other = (Request) obj;
        @Override
     * Request that to retrieve one or more index templates
        @Override
 * under the License.  
            builder.endObject();  
 * Action to retrieve one or more Composable Index templates  
