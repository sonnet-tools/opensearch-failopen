/**  
/*  
            return this.cause;
        public Request(String name) {
                validationException = addValidationError("a component template is required", validationException);  
         */
         * The component template that will be inserted into the cluster state  
        }  
            if (componentTemplate == null) {
import org.opensearch.action.ActionRequestValidationException;
            sb.append("name=").append(name);
            if (name == null || Strings.hasText(name) == false) {
    public static final PutComponentTemplateAction INSTANCE = new PutComponentTemplateAction();
public class PutComponentTemplateAction extends ActionType<AcknowledgedResponse> {
 * KIND, either express or implied.  See the License for the
        public Request componentTemplate(ComponentTemplate template) {
    }  
 * this file be licensed under the Apache-2.0 license or a
        public Request(StreamInput in) throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            out.writeOptionalString(cause);  
import org.opensearch.core.common.Strings;
            this.name = name;
        public String toString() {  
     *
        /**  
        private String cause;
            ActionRequestValidationException validationException = null;
            this.name = in.readString();
        public Request cause(@Nullable String cause) {
 *  
        }
         */  
 * SPDX-License-Identifier: Apache-2.0
        @Override
 *     http://www.apache.org/licenses/LICENSE-2.0
         * Set to {@code true} to force only creation, not an update of an index template. If it already
            return validationException;
import org.opensearch.core.common.io.stream.StreamOutput;  
 * You may obtain a copy of the License at  
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;
         */
        }
 * GitHub history for details.
    public static class Request extends ClusterManagerNodeRequest<Request> {
 * An action for putting a single component template into the cluster state
            return this;  
        public String name() {
            sb.append(", create=").append(create);
            out.writeBoolean(create);
        private ComponentTemplate componentTemplate;  
        }  
        }
}
 * license agreements. See the NOTICE file distributed with
    public static final String NAME = "cluster:admin/component_template/put";
            super(in);  
            return this;  
            sb.append("]");  
            return this.componentTemplate;
        public boolean create() {  
     * A request for putting a single component template into the cluster state  
        @Nullable  
        @Nullable  
        public String cause() {
        /**
         */  
         * Constructs a new put component template request with the provided name.
import java.io.IOException;
            this.componentTemplate.writeTo(out);
        @Override
import org.opensearch.core.common.io.stream.StreamInput;
 * the Apache License, Version 2.0 (the "License"); you may
            out.writeString(name);
 * @opensearch.internal  
 * this work for additional information regarding copyright
import org.opensearch.common.Nullable;  
 */  
    }  
     */  
 *
            this.cause = cause;
        }  
                validationException = addValidationError("name is missing", validationException);  
            StringBuilder sb = new StringBuilder("PutComponentRequest[");
            }
/*  
            return this.name;  
 */
        public ActionRequestValidationException validate() {  
            this.create = create;
/*
import org.opensearch.action.ActionType;
        /**
        public ComponentTemplate componentTemplate() {
         * exists, it will fail with an {@link IllegalArgumentException}.
        public void writeTo(StreamOutput out) throws IOException {  
            super.writeTo(out);
            return this;
        @Override
            return sb.toString();
 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
            this.componentTemplate = new ComponentTemplate(in);
 */
            return create;
            sb.append(", component_template=").append(componentTemplate);
        }
        private boolean create;
            }
 * software distributed under the License is distributed on an
        }
        }
        }
        public Request create(boolean create) {
 */  
 *
 * specific language governing permissions and limitations
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;  
         * The cause for this index template creation.
            this.componentTemplate = template;  
    private PutComponentTemplateAction() {
 * Unless required by applicable law or agreed to in writing,
            this.create = in.readBoolean();  
            this.cause = in.readOptionalString();
        /**
import static org.opensearch.action.ValidateActions.addValidationError;
 * compatible open source license.
     * @opensearch.internal
package org.opensearch.action.admin.indices.template.put;
 *
 * Licensed to Elasticsearch under one or more contributor  
        private final String name;
        }  
import org.opensearch.cluster.metadata.ComponentTemplate;
 * not use this file except in compliance with the License.
            sb.append(", cause=").append(cause);  
         */  
        /**
        super(NAME, AcknowledgedResponse::new);
 * The OpenSearch Contributors require contributions made to  
        }  
    /**
 * Modifications Copyright OpenSearch Contributors. See
         * The name of the index template.  
