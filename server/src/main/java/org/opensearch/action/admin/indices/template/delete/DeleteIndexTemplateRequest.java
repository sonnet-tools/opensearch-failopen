import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;
        if (name == null) {  
 * GitHub history for details.
     * Constructs a new delete index request for the specified name.
    @Override
public class DeleteIndexTemplateRequest extends ClusterManagerNodeRequest<DeleteIndexTemplateRequest> {
    public DeleteIndexTemplateRequest name(String name) {
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.annotation.PublicApi;
 * SPDX-License-Identifier: Apache-2.0
        name = in.readString();
        ActionRequestValidationException validationException = null;
import java.io.IOException;  
    }
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
        super(in);  
    public DeleteIndexTemplateRequest() {}
 * this work for additional information regarding copyright
    /**  
 */
import org.opensearch.action.ActionRequestValidationException;  
        out.writeString(name);
/*
import static org.opensearch.action.ValidateActions.addValidationError;
import org.opensearch.core.common.io.stream.StreamOutput;
     * Set the index template name to delete.
/*  
        return validationException;  
 * software distributed under the License is distributed on an
 */
 * Licensed to Elasticsearch under one or more contributor  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * @opensearch.api
        this.name = name;
    public DeleteIndexTemplateRequest(StreamInput in) throws IOException {
    public String name() {  
    }
        return this;  
    }
package org.opensearch.action.admin.indices.template.delete;
 * Modifications Copyright OpenSearch Contributors. See  
 * A request to delete an index template.
     */
     */  
 *
 */  
 * under the License.  
}  
import org.opensearch.core.common.io.stream.StreamInput;  
/*
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
        return name;
    /**
    @Override  
 *  
 * Unless required by applicable law or agreed to in writing,
    public ActionRequestValidationException validate() {
 * The OpenSearch Contributors require contributions made to  
    }
    }
    /**  
 * specific language governing permissions and limitations
            validationException = addValidationError("name is missing", validationException);
    private String name;  
 * compatible open source license.
        }
@PublicApi(since = "1.0.0")  
        super.writeTo(out);  
        this.name = name;
 * You may obtain a copy of the License at  
 *
    public DeleteIndexTemplateRequest(String name) {  
 */
    public void writeTo(StreamOutput out) throws IOException {
     * The index template name to delete.
/**
 * not use this file except in compliance with the License.
     */
