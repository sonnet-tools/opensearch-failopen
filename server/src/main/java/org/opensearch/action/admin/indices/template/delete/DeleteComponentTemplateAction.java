        }
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.action.ActionType;
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;  
 *
    }  
    public static final DeleteComponentTemplateAction INSTANCE = new DeleteComponentTemplateAction();
 * specific language governing permissions and limitations
        }
        @Override
            super(in);  
        /**  
    private DeleteComponentTemplateAction() {
    public static class Request extends ClusterManagerNodeRequest<Request> {
        public void writeTo(StreamOutput out) throws IOException {
     */  
            name = in.readString();
import java.io.IOException;
        @Override  
import org.opensearch.core.common.io.stream.StreamInput;
            }
            return validationException;  
        private String name;  
        public ActionRequestValidationException validate() {
        public Request name(String name) {
        }
 * this work for additional information regarding copyright
import org.opensearch.action.ActionRequestValidationException;
import org.opensearch.core.common.io.stream.StreamOutput;  
 * SPDX-License-Identifier: Apache-2.0
            return name;
        public Request(StreamInput in) throws IOException {
 * Transport action for deleting an index template component
/*  
 */  
 * software distributed under the License is distributed on an
         */  
     * @opensearch.internal
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.action.admin.indices.template.delete;
         * Constructs a new delete index request for the specified name.
 * You may obtain a copy of the License at  
import static org.opensearch.action.ValidateActions.addValidationError;
     *
        public String name() {  
 * The OpenSearch Contributors require contributions made to  
 *  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;
        }
 * KIND, either express or implied.  See the License for the
         * The index template name to delete.
 *
/*  
    public static final String NAME = "cluster:admin/component_template/delete";
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/**  
 */
            if (name == null) {  
 * Unless required by applicable law or agreed to in writing,
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
         */
            super.writeTo(out);  
         */
     * Inner Request class for deleting component template  
        super(NAME, AcknowledgedResponse::new);
        public Request(String name) {  
         * Set the index template name to delete.
 * GitHub history for details.
 */  
            ActionRequestValidationException validationException = null;
public class DeleteComponentTemplateAction extends ActionType<AcknowledgedResponse> {
        /**  
        }
 * not use this file except in compliance with the License.
}
 * the Apache License, Version 2.0 (the "License"); you may
            out.writeString(name);
 * compatible open source license.
            this.name = name;
 * under the License.  
 * @opensearch.internal  
    }  
/*
        public Request() {}
            this.name = name;
    /**
                validationException = addValidationError("name is missing", validationException);
 * Licensed to Elasticsearch under one or more contributor  
 */
        }
        /**
 * license agreements. See the NOTICE file distributed with
            return this;  
