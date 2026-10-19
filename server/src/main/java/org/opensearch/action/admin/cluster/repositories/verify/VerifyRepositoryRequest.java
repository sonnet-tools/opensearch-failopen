    }
        this.name = name;
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
 * @opensearch.api
import java.io.IOException;
package org.opensearch.action.admin.cluster.repositories.verify;
        if (name == null) {
 * Unless required by applicable law or agreed to in writing,
     */
        }  
     * @param name name of the repository
    public void writeTo(StreamOutput out) throws IOException {  
 * You may obtain a copy of the License at  
 */  
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;
import org.opensearch.core.common.io.stream.StreamOutput;
            validationException = addValidationError("name is missing", validationException);
     * @param name name of the repository
    }  
 * ownership. Elasticsearch licenses this file to you under  
 */  
        super.writeTo(out);
    /**
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
    }  
    }
 * under the License.  
 * not use this file except in compliance with the License.
    public VerifyRepositoryRequest(String name) {  
    }  
     *  
     * The name of the repository.  
/*
/*  
 * this file be licensed under the Apache-2.0 license or a
    }  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.annotation.PublicApi;  
        return this.name;
 */  
@PublicApi(since = "1.0.0")
 *  
        ActionRequestValidationException validationException = null;  
        name = in.readString();
     *
    @Override
     * @return the name of the repository
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}
 *
import org.opensearch.action.ActionRequestValidationException;
/*  
 * GitHub history for details.
     * Sets the name of the repository to unregister.
     *  
    public VerifyRepositoryRequest name(String name) {  
/**
        this.name = name;
    @Override
    /**
 * KIND, either express or implied.  See the License for the
 * Verify repository request.  
public class VerifyRepositoryRequest extends AcknowledgedRequest<VerifyRepositoryRequest> {
 * software distributed under the License is distributed on an
    public ActionRequestValidationException validate() {
     */
 * Licensed to Elasticsearch under one or more contributor  
        out.writeString(name);
        return validationException;
 */
    /**
 * specific language governing permissions and limitations
import static org.opensearch.action.ValidateActions.addValidationError;  
    private String name;
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
     * Constructs a new unregister repository request with the provided name.
 *
    public String name() {
        return this;
    public VerifyRepositoryRequest() {}
        super(in);
     */  
    public VerifyRepositoryRequest(StreamInput in) throws IOException {  
 *
import org.opensearch.core.common.io.stream.StreamInput;
