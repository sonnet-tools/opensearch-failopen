        public void writeTo(StreamOutput out) throws IOException {  
 * ownership. Elasticsearch licenses this file to you under  
            super.writeTo(out);
        public ActionRequestValidationException validate() {
/*  
            this.name = name;
        }  
         */  
        }  
     */
 * GitHub history for details.
 * @opensearch.internal
 * under the License.  
import java.util.Objects;  
        @Override
 * Transport action for deleting a composable index template
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
        /**
            if (name == null) {
        }
    }  
         */  
 * The OpenSearch Contributors require contributions made to  
 *  
    /**  
 *  
        }
 * compatible open source license.
        public Request(StreamInput in) throws IOException {  
                validationException = addValidationError("name is missing", validationException);
package org.opensearch.action.admin.indices.template.delete;
        public Request name(String name) {
                return false;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/**
        public Request() {}
 * Unless required by applicable law or agreed to in writing,
        @Override
        public boolean equals(Object obj) {
 */
/*
        }  
            Request other = (Request) obj;  
import java.io.IOException;
         * The index template name to delete.
            }
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
 */  
            return this;
    public static final String NAME = "indices:admin/index_template/delete";  
         */
     *
 * specific language governing permissions and limitations
import org.opensearch.action.ActionRequestValidationException;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.action.ActionType;
            super(in);
                return false;
        super(NAME, AcknowledgedResponse::new);  
     * @opensearch.internal  
 */
    }
        /**
 * not use this file except in compliance with the License.
    public static final DeleteComposableIndexTemplateAction INSTANCE = new DeleteComposableIndexTemplateAction();
}
         * Set the index template name to delete.  
 * You may obtain a copy of the License at  
        }
import static org.opensearch.action.ValidateActions.addValidationError;
         * Constructs a new delete template request for the specified name.
            if (obj == null) {  
 *
public class DeleteComposableIndexTemplateAction extends ActionType<AcknowledgedResponse> {  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;  
 *
        }
        /**
            out.writeString(name);
        public int hashCode() {  
     * Inner Request class for deleting composable index template
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;
            this.name = name;  
    public static class Request extends ClusterManagerNodeRequest<Request> {
            name = in.readString();
            if (getClass() != obj.getClass()) {  
 * software distributed under the License is distributed on an
        @Override
 * KIND, either express or implied.  See the License for the
    private DeleteComposableIndexTemplateAction() {
            return validationException;
            ActionRequestValidationException validationException = null;  
 */  
            return Objects.equals(other.name, this.name);
        }  
        private String name;
import org.opensearch.core.common.io.stream.StreamOutput;  
/*  
            }
            return name.hashCode();
        @Override
            return name;
            }  
        public Request(String name) {
 * this work for additional information regarding copyright
        public String name() {
