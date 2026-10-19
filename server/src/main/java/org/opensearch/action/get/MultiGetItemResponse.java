            failure = null;  
        }
    public GetResponse getResponse() {
import org.opensearch.core.common.io.stream.StreamInput;
     */
            out.writeBoolean(false);  
    /**
import org.opensearch.core.common.io.stream.Writeable;
     * The index name of the document.
        this.response = response;
    private final GetResponse response;
     */  
    public String getId() {
 *
 * the Apache License, Version 2.0 (the "License"); you may
        if (in.readBoolean()) {
package org.opensearch.action.get;
     */
     * Is this a failed execution?
        return response.getId();  
 *
    }
 * @opensearch.api
     * The actual get response, {@code null} if its a failure.
    }
}
            response = new GetResponse(in);
    }  
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
 */  
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
        return response.getIndex();
 * KIND, either express or implied.  See the License for the
    /**
        if (failure != null) {  
 */  
            return failure.getIndex();  
        if (failure != null) {
 * this work for additional information regarding copyright
     * The id of the document.  
     */
 * not use this file except in compliance with the License.
 * compatible open source license.
        } else {
        }
        return this.failure;  
 * ownership. Elasticsearch licenses this file to you under  
    }
            failure = new MultiGetResponse.Failure(in);
     * The failure if relevant.  
    private final MultiGetResponse.Failure failure;
    public MultiGetItemResponse(GetResponse response, MultiGetResponse.Failure failure) {
        return this.response;
     */  
        if (failure != null) {
 *  
            out.writeBoolean(true);  
            response = null;  
public class MultiGetItemResponse implements Writeable {
    @Override  
    /**
    }  
    }  
import java.io.IOException;  
    }
    MultiGetItemResponse(StreamInput in) throws IOException {  
    public String getIndex() {
    public boolean isFailed() {  
        return failure != null;
 * You may obtain a copy of the License at  
    }
    public MultiGetResponse.Failure getFailure() {
 *     http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
            return failure.getId();
 *
 * under the License.  
        } else {
/*
    /**  
 * A single multi get response.  
 * license agreements. See the NOTICE file distributed with
            failure.writeTo(out);
 */
/**
 * SPDX-License-Identifier: Apache-2.0
 */  
/*  
    /**
    public void writeTo(StreamOutput out) throws IOException {
            response.writeTo(out);
        }
/*  
import org.opensearch.core.common.io.stream.StreamOutput;  
        this.failure = failure;  
@PublicApi(since = "1.0.0")
import org.opensearch.common.annotation.PublicApi;
