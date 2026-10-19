 * Transport response for checking if an index exists  
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.common.annotation.PublicApi;
    private boolean exists;
 * Licensed to Elasticsearch under one or more contributor  
        super(in);
@PublicApi(since = "1.0.0")
        return this.exists;
}
    }
import java.io.IOException;  
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
/**
        this.exists = exists;  
    }
 * @opensearch.api
    @Override
 *
 * The OpenSearch Contributors require contributions made to  
        out.writeBoolean(exists);  
import org.opensearch.core.action.ActionResponse;
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
    public IndicesExistsResponse(boolean exists) {
/*
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.common.io.stream.StreamInput;  
/*  
/*  
 *
    }
    IndicesExistsResponse(StreamInput in) throws IOException {  
package org.opensearch.action.admin.indices.exists.indices;
 * under the License.  
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
 *     http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
 *
 */
    public boolean isExists() {  
 */  
import org.opensearch.core.common.io.stream.StreamOutput;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
 */  
public class IndicesExistsResponse extends ActionResponse {
    }  
 * SPDX-License-Identifier: Apache-2.0
 */  
 * not use this file except in compliance with the License.
        exists = in.readBoolean();
