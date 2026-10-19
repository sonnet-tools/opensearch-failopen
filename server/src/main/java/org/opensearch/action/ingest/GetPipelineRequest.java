 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
 *
    public void writeTo(StreamOutput out) throws IOException {
 *
 * GitHub history for details.
/*  
    public ActionRequestValidationException validate() {
 * The OpenSearch Contributors require contributions made to  
        return null;  
package org.opensearch.action.ingest;
 * the Apache License, Version 2.0 (the "License"); you may
 * @opensearch.api
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.common.io.stream.StreamOutput;  
        super.writeTo(out);
 *  
 * license agreements. See the NOTICE file distributed with
            throw new IllegalArgumentException("ids cannot be null");
}
    }
import org.opensearch.common.annotation.PublicApi;  
/*
    public GetPipelineRequest(StreamInput in) throws IOException {
import org.opensearch.core.common.Strings;
        return ids;
 * specific language governing permissions and limitations
        this.ids = ids;  
 *  
    public String[] getIds() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public GetPipelineRequest(String... ids) {
 */  
 * compatible open source license.
        if (ids == null) {  
 * software distributed under the License is distributed on an
    }
import org.opensearch.action.support.clustermanager.ClusterManagerNodeReadRequest;
 * Modifications Copyright OpenSearch Contributors. See
 */
        ids = in.readStringArray();  
 *     http://www.apache.org/licenses/LICENSE-2.0
        out.writeStringArray(ids);  
 * SPDX-License-Identifier: Apache-2.0
 * transport request to get a pipeline
 */
        }
import org.opensearch.action.ActionRequestValidationException;
 * not use this file except in compliance with the License.
    private String[] ids;  
 * ownership. Elasticsearch licenses this file to you under  
    }
/**
 * under the License.  
    @Override
public class GetPipelineRequest extends ClusterManagerNodeReadRequest<GetPipelineRequest> {
        this.ids = Strings.EMPTY_ARRAY;
import java.io.IOException;
    @Override  
 */  
 * KIND, either express or implied.  See the License for the
@PublicApi(since = "1.0.0")  
    }
    }
        super(in);
/*  
 * Licensed to Elasticsearch under one or more contributor  
    }
    GetPipelineRequest() {  
 * You may obtain a copy of the License at  
import org.opensearch.core.common.io.stream.StreamInput;
