    public DeleteRepositoryRequest(String name) {
        return validationException;  
 *  
    public ActionRequestValidationException validate() {
import java.io.IOException;
 * this work for additional information regarding copyright
    /**
     */
 */
     * @param name name of the repository  
    public DeleteRepositoryRequest name(String name) {
package org.opensearch.action.admin.cluster.repositories.delete;
     *
 *     http://www.apache.org/licenses/LICENSE-2.0
        this.name = name;  
/*  
 * specific language governing permissions and limitations
        super(in);  
 */
        }
 * The OpenSearch Contributors require contributions made to  
    }
    public void writeTo(StreamOutput out) throws IOException {
    public DeleteRepositoryRequest(StreamInput in) throws IOException {
 * software distributed under the License is distributed on an
    @Override
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;
    /**  
        this.name = name;  
     * The name of the repository.
import org.opensearch.core.common.io.stream.StreamOutput;
 * Unless required by applicable law or agreed to in writing,
 * <p>
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
        if (name == null) {  
 * KIND, either express or implied.  See the License for the
        name = in.readString();
     *
        return this.name;
        return this;
import static org.opensearch.action.ValidateActions.addValidationError;  
    }
 * SPDX-License-Identifier: Apache-2.0
            validationException = addValidationError("name is missing", validationException);
 * under the License.  
     */
        out.writeString(name);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**  
 * license agreements. See the NOTICE file distributed with
    }
 * GitHub history for details.
     *  
/**
 * You may obtain a copy of the License at  
    }
 * this file be licensed under the Apache-2.0 license or a
    }
public class DeleteRepositoryRequest extends AcknowledgedRequest<DeleteRepositoryRequest> {
     * Constructs a new unregister repository request with the provided name.
/*  
 * The unregister repository command just unregisters the repository. No data is getting deleted from the repository.
     * Sets the name of the repository to unregister.
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
@PublicApi(since = "1.0.0")  
import org.opensearch.common.annotation.PublicApi;  
     * @return the name of the repository
    @Override  
    }
     * @param name name of the repository  
 * not use this file except in compliance with the License.
    private String name;  
     */
        super.writeTo(out);  
 * Unregister repository request.  
 * @opensearch.api
import org.opensearch.action.ActionRequestValidationException;
import org.opensearch.core.common.io.stream.StreamInput;
 *
 */  
 *
 * the Apache License, Version 2.0 (the "License"); you may
/*
    public DeleteRepositoryRequest() {}
}  
        ActionRequestValidationException validationException = null;
    public String name() {  
 */  
 *  
