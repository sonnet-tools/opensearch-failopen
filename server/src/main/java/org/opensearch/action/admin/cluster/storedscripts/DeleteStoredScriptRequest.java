        this.id = id;  
/*
    }  
import static org.opensearch.action.ValidateActions.addValidationError;  
    }
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
            validationException = addValidationError("must specify id for stored script", validationException);
    public DeleteStoredScriptRequest(StreamInput in) throws IOException {  
    }
            validationException = addValidationError("id cannot contain '#' for stored script", validationException);
        return validationException;
 * @opensearch.api
    public String toString() {  
 * not use this file except in compliance with the License.
    }  
/**
        ActionRequestValidationException validationException = null;
 * SPDX-License-Identifier: Apache-2.0
@PublicApi(since = "1.0.0")
        }
 */  
        } else if (id.contains("#")) {  
 * GitHub history for details.
        return id;
import org.opensearch.core.common.io.stream.StreamOutput;
 * The OpenSearch Contributors require contributions made to  
/*  
        super();  
 * under the License.  
}  
 * Licensed to Elasticsearch under one or more contributor  
 */  
import org.opensearch.core.common.io.stream.StreamInput;
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
public class DeleteStoredScriptRequest extends AcknowledgedRequest<DeleteStoredScriptRequest> {
 * Transport request for deleting stored scripts  
    }
    @Override
        super(in);
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
        id = in.readString();
import org.opensearch.common.annotation.PublicApi;  
 */
    public ActionRequestValidationException validate() {
        return "delete stored script {id [" + id + "]}";
 *  
 *
    DeleteStoredScriptRequest() {
    public void writeTo(StreamOutput out) throws IOException {  
    public DeleteStoredScriptRequest id(String id) {
        super();
 *
    @Override  
 * ownership. Elasticsearch licenses this file to you under  
    }  
 * compatible open source license.
 * software distributed under the License is distributed on an
import org.opensearch.action.ActionRequestValidationException;
        this.id = id;  
 * KIND, either express or implied.  See the License for the
        if (id == null || id.isEmpty()) {
    }  
package org.opensearch.action.admin.cluster.storedscripts;
        out.writeString(id);
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;
 * this work for additional information regarding copyright
    public String id() {
 * specific language governing permissions and limitations
import java.io.IOException;
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
        return this;
 *     http://www.apache.org/licenses/LICENSE-2.0
    public DeleteStoredScriptRequest(String id) {  
 */  
        super.writeTo(out);
    private String id;
 *
