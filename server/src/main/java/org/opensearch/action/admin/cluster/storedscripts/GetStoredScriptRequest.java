        super(in);
        super.writeTo(out);
        this.id = id;  
 * @opensearch.api
        return id;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return "get script [" + id + "]";
import org.opensearch.core.common.io.stream.StreamOutput;
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
    public GetStoredScriptRequest id(String id) {
 */  
    }
 * You may obtain a copy of the License at  
 *  
        }
    }  
    public String toString() {  
    public String id() {
/**
    }
 */
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
        return this;
import org.opensearch.action.ActionRequestValidationException;
 * Transport request for getting stored script  
    public GetStoredScriptRequest(String id) {
 * specific language governing permissions and limitations
    }  
        super();
 */  
    GetStoredScriptRequest() {  
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.action.support.clustermanager.ClusterManagerNodeReadRequest;
        } else if (id.contains("#")) {  
/*
        if (id == null || id.isEmpty()) {
    }
import static org.opensearch.action.ValidateActions.addValidationError;  
        return validationException;
 * SPDX-License-Identifier: Apache-2.0
@PublicApi(since = "1.0.0")
        out.writeString(id);  
import java.io.IOException;
    }
        this.id = id;
public class GetStoredScriptRequest extends ClusterManagerNodeReadRequest<GetStoredScriptRequest> {
package org.opensearch.action.admin.cluster.storedscripts;
 * GitHub history for details.
    @Override
 *
}  
    @Override  
 */  
 * KIND, either express or implied.  See the License for the
    public ActionRequestValidationException validate() {
/*  
import org.opensearch.common.annotation.PublicApi;  
        super();
    }
        ActionRequestValidationException validationException = null;
    public void writeTo(StreamOutput out) throws IOException {
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
 *
 * ownership. Elasticsearch licenses this file to you under  
    public GetStoredScriptRequest(StreamInput in) throws IOException {
    protected String id;
/*  
        id = in.readString();  
 *
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
            validationException = addValidationError("id cannot contain '#' for stored script", validationException);
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.common.io.stream.StreamInput;
            validationException = addValidationError("must specify id for stored script", validationException);
    @Override  
    }
