            for (Map.Entry<String, ComponentTemplate> componentTemplate : this.componentTemplates.entrySet()) {  
         */
 *     http://www.apache.org/licenses/LICENSE-2.0
            return null;  
import org.opensearch.action.ActionRequestValidationException;
/*  
 * specific language governing permissions and limitations
        public Request() {}
     * @opensearch.internal
            builder.endObject();
                builder.endObject();
import org.opensearch.core.common.io.stream.StreamInput;
        @Override
                builder.field(COMPONENT_TEMPLATE.getPreferredName(), componentTemplate.getValue());  
    public static final String NAME = "cluster:admin/component_template/get";
 * Modifications Copyright OpenSearch Contributors. See
            return this;
        }  
     *  
 * under the License.  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        public static final ParseField COMPONENT_TEMPLATES = new ParseField("component_templates");
        @Nullable
     */
import org.opensearch.core.xcontent.ToXContentObject;
 * @opensearch.internal
import java.util.Map;
    }
            super.writeTo(out);  
 * software distributed under the License is distributed on an
        public void writeTo(StreamOutput out) throws IOException {  
        @Override
    private GetComponentTemplateAction() {  
}
/*
        }  
            builder.startObject();
import org.opensearch.core.ParseField;  
import org.opensearch.common.Nullable;
import org.opensearch.core.xcontent.XContentBuilder;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            this.name = name;
 * Unless required by applicable law or agreed to in writing,
     * Request that to retrieve one or more component templates
        }  
 *
        }
        @Override  
 * this work for additional information regarding copyright
            componentTemplates = in.readMap(StreamInput::readString, ComponentTemplate::new);  
            this.componentTemplates = componentTemplates;
 *
 * ownership. Elasticsearch licenses this file to you under  
            builder.startArray(COMPONENT_TEMPLATES.getPreferredName());
 * this file be licensed under the Apache-2.0 license or a
     * Inner response for getting component template
            if (this == o) return true;  
import org.opensearch.action.support.clustermanager.ClusterManagerNodeReadRequest;  
 */
 * GitHub history for details.
        }  
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
    }
        }
 */  
            return Objects.hash(componentTemplates);
            return Objects.equals(componentTemplates, that.componentTemplates);  
            out.writeOptionalString(name);
package org.opensearch.action.admin.indices.template.get;
        /**  
            super(in);  
import org.opensearch.cluster.metadata.ComponentTemplate;
        public boolean equals(Object o) {
     *  
    /**
        public Request(StreamInput in) throws IOException {
 * Action to retrieve one or more component templates  
         * The name of the component templates.  
        public Response(Map<String, ComponentTemplate> componentTemplates) {  
/*  
        public Request(String name) {
    public static class Response extends ActionResponse implements ToXContentObject {  
         */
        super(NAME, GetComponentTemplateAction.Response::new);
        @Override
        public void writeTo(StreamOutput out) throws IOException {
            return componentTemplates;
 * SPDX-License-Identifier: Apache-2.0
 */  
    }
            if (o == null || getClass() != o.getClass()) return false;
import org.opensearch.core.common.io.stream.StreamOutput;  
            this.name = name;
            super(in);
public class GetComponentTemplateAction extends ActionType<GetComponentTemplateAction.Response> {
            Response that = (Response) o;
        /**
        }
    public static final GetComponentTemplateAction INSTANCE = new GetComponentTemplateAction();  
import java.io.IOException;
 * compatible open source license.
                builder.field(NAME.getPreferredName(), componentTemplate.getKey());
        private final Map<String, ComponentTemplate> componentTemplates;
    public static class Request extends ClusterManagerNodeReadRequest<Request> {  
 *  
            out.writeMap(componentTemplates, StreamOutput::writeString, (o, v) -> v.writeTo(o));
 * The OpenSearch Contributors require contributions made to  
            name = in.readOptionalString();
        public static final ParseField COMPONENT_TEMPLATE = new ParseField("component_template");  
     */
        public String name() {
            return builder;
        public ActionRequestValidationException validate() {
        public int hashCode() {
        }
        }
    /**
 * not use this file except in compliance with the License.
        }
            }
            builder.endArray();  
        public Request name(String name) {  
            return this.name;  
        public Response(StreamInput in) throws IOException {
 */  
        }
 * the Apache License, Version 2.0 (the "License"); you may
 *
/**
import org.opensearch.core.action.ActionResponse;
         * Sets the name of the component templates.
                builder.startObject();
        }  
        public Map<String, ComponentTemplate> getComponentTemplates() {
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
import org.opensearch.action.ActionType;
     * @opensearch.internal
import java.util.Objects;  
        private String name;  
        @Override
        @Override
        }
        public static final ParseField NAME = new ParseField("name");
