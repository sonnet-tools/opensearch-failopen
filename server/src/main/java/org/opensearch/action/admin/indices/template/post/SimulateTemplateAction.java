            this.indexTemplateRequest = indexTemplateRequest;  
            Request that = (Request) o;
        public void writeTo(StreamOutput out) throws IOException {
            templateName = in.readOptionalString();
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
     *  
 */  
 *
            }
     * Request for simulating a template action
        @Nullable
import org.opensearch.core.common.io.stream.StreamInput;
 * ownership. Elasticsearch licenses this file to you under  
        }
 * specific language governing permissions and limitations
                    validationException
            this.templateName = templateName;
 * under the License.  
        }
                );
        @Override
        }
        public boolean equals(Object o) {
 */
        public Request indexTemplateRequest(PutComposableIndexTemplateAction.Request indexTemplateRequest) {
        }
            if (o == null || getClass() != o.getClass()) {
 */  
/**
/*
        @Nullable
        @Override  
            out.writeOptionalWriteable(indexTemplateRequest);
            return templateName.equals(that.templateName) && Objects.equals(indexTemplateRequest, that.indexTemplateRequest);  
            out.writeOptionalString(templateName);  
 *  
            }
    private SimulateTemplateAction() {  
            if (templateName == null && indexTemplateRequest == null) {
 * Modifications Copyright OpenSearch Contributors. See
                validationException = indexTemplateRequest.validateIndexTemplate(validationException);
        }  
 * not use this file except in compliance with the License.
                throw new IllegalArgumentException("index template body must be present");
 * You may obtain a copy of the License at  
     * @opensearch.internal
            this.templateName = templateName;  
        }  
        public Request(PutComposableIndexTemplateAction.Request indexTemplateRequest) {
        }
        public String getTemplateName() {
import java.util.Objects;
/*  
        public ActionRequestValidationException validate() {
            this.indexTemplateRequest = indexTemplateRequest;
            super(in);
            if (indexTemplateRequest == null) {  
    }
 *
 * An action for simulating the complete composed settings of the specified
            return indexTemplateRequest;
}
 *
        public Request() {}
 * this work for additional information regarding copyright
    public static final String NAME = "indices:admin/index_template/simulate";
            }  
                    "either index name or index template body must be specified for simulation",  
            }  
            ActionRequestValidationException validationException = null;  
 * the Apache License, Version 2.0 (the "License"); you may
        @Override  
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
        @Override  
            return this;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        @Nullable
            return validationException;
                return true;  
            }
import java.io.IOException;
    /**
        }
        public Request templateName(String templateName) {
            if (this == o) {
        }  
        super(NAME, SimulateIndexTemplateResponse::new);
        private String templateName;  
            return this;
 * @opensearch.internal
import org.opensearch.action.admin.indices.template.put.PutComposableIndexTemplateAction;
 * software distributed under the License is distributed on an
        @Nullable  
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
 * index template name, or index template configuration  
        public Request(StreamInput in) throws IOException {  
            super.writeTo(out);
                validationException = ValidateActions.addValidationError(
    public static class Request extends ClusterManagerNodeReadRequest<Request> {  
        }
            return Objects.hash(templateName, indexTemplateRequest);
 * The OpenSearch Contributors require contributions made to  
        public PutComposableIndexTemplateAction.Request getIndexTemplateRequest() {
            return templateName;  
        public int hashCode() {
/*  
 * SPDX-License-Identifier: Apache-2.0
    }
        public Request(String templateName) {
package org.opensearch.action.admin.indices.template.post;
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.action.ActionType;
     */
            if (templateName == null) {
            indexTemplateRequest = in.readOptionalWriteable(PutComposableIndexTemplateAction.Request::new);  
        }
    public static final SimulateTemplateAction INSTANCE = new SimulateTemplateAction();  
            }
                throw new IllegalArgumentException("template name cannot be null");  
import org.opensearch.action.support.clustermanager.ClusterManagerNodeReadRequest;
import org.opensearch.common.Nullable;  
 * GitHub history for details.
        private PutComposableIndexTemplateAction.Request indexTemplateRequest;  
                return false;  
 */  
import org.opensearch.action.ValidateActions;  
import org.opensearch.core.common.io.stream.StreamOutput;
            if (indexTemplateRequest != null) {
import org.opensearch.action.ActionRequestValidationException;
public class SimulateTemplateAction extends ActionType<SimulateIndexTemplateResponse> {
