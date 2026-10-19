import org.opensearch.action.ActionRequestValidationException;
 * specific language governing permissions and limitations
 * Get repository request
     * are returned.  
 * The OpenSearch Contributors require contributions made to  
        ActionRequestValidationException validationException = null;
 * Modifications Copyright OpenSearch Contributors. See
     *
        }
     * @param repositories list of repositories
 */  
 * compatible open source license.
 */
import static org.opensearch.action.ValidateActions.addValidationError;
    @Override
     * are returned.
     */
/*  
 *
    public GetRepositoriesRequest(String[] repositories) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
    @Override
        return this;
        return validationException;
import org.opensearch.common.annotation.PublicApi;  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.common.io.stream.StreamOutput;  
        this.repositories = repositories;  
 *
 */  
/**  
 * not use this file except in compliance with the License.
        repositories = in.readStringArray();
 *  
     * Constructs a new get repositories request with a list of repositories.
        out.writeStringArray(repositories);
package org.opensearch.action.admin.cluster.repositories.get;
}  
 * under the License.  
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
 *
/*  
    }
     * Sets the list or repositories.  
     * If the list of repositories is empty or it contains a single element "_all", all registered repositories  
        super(in);
    public void writeTo(StreamOutput out) throws IOException {  
    }  
        return this.repositories;
    public ActionRequestValidationException validate() {  
    }
        if (repositories == null) {
 * SPDX-License-Identifier: Apache-2.0
     * @param repositories list of repositories  
            validationException = addValidationError("repositories is null", validationException);  
 * GitHub history for details.
 * this work for additional information regarding copyright
@PublicApi(since = "1.0.0")
    private String[] repositories = Strings.EMPTY_ARRAY;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * @opensearch.api  
    public GetRepositoriesRequest() {}
    }  
        this.repositories = repositories;  
import org.opensearch.core.common.Strings;
import java.io.IOException;
     * @return this request  
 * the Apache License, Version 2.0 (the "License"); you may
    /**  
     * <p>
     * If the list of repositories is empty or it contains a single element "_all", all registered repositories
    public String[] repositories() {
     *
    public GetRepositoriesRequest(StreamInput in) throws IOException {  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.action.support.clustermanager.ClusterManagerNodeReadRequest;
public class GetRepositoriesRequest extends ClusterManagerNodeReadRequest<GetRepositoriesRequest> {  
     */
    public GetRepositoriesRequest repositories(String[] repositories) {
 */
 * Licensed to Elasticsearch under one or more contributor  
     * @return  array of repository names
    /**
     *
     */  
    /**
/*
 * this file be licensed under the Apache-2.0 license or a
     * The names of the repositories.  
     * <p>
        super.writeTo(out);
 * KIND, either express or implied.  See the License for the
    }  
import org.opensearch.core.common.io.stream.StreamInput;
    }  
