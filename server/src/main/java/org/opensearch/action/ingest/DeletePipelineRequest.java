 *
 * license agreements. See the NOTICE file distributed with
        super.writeTo(out);
}
 * software distributed under the License is distributed on an
 * transport request to delete a pipeline
    }  
package org.opensearch.action.ingest;
public class DeletePipelineRequest extends AcknowledgedRequest<DeletePipelineRequest> {
@PublicApi(since = "1.0.0")  
        out.writeString(id);
            throw new IllegalArgumentException("id is missing");
        this.id = id;  
 */  
/*  
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
    @Override  
 * The OpenSearch Contributors require contributions made to  
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
    }  
import org.opensearch.action.ActionRequestValidationException;
 * the Apache License, Version 2.0 (the "License"); you may
        if (id == null) {  
    public void writeTo(StreamOutput out) throws IOException {  
 * @opensearch.api
 */
        }
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.annotation.PublicApi;  
    public void setId(String id) {
        this.id = Objects.requireNonNull(id);
 * specific language governing permissions and limitations
    public String getId() {
 * ownership. Elasticsearch licenses this file to you under  
    }  
        id = in.readString();
import org.opensearch.core.common.io.stream.StreamInput;
 * Modifications Copyright OpenSearch Contributors. See
import java.io.IOException;
    public ActionRequestValidationException validate() {
 * compatible open source license.
/*  
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.io.stream.StreamOutput;
    public DeletePipelineRequest(StreamInput in) throws IOException {  
 * under the License.  
    }
 * You may obtain a copy of the License at  
    private String id;  
/**
    DeletePipelineRequest() {}
import java.util.Objects;
        return null;
 * GitHub history for details.
 *
    public DeletePipelineRequest(String id) {
    }
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;
 *  
        return id;  
        super(in);
 */
/*
 *  
    }  
