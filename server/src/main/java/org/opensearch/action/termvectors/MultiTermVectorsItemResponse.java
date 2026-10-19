 *
public class MultiTermVectorsItemResponse implements Writeable {
     */
        if (in.readBoolean()) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */
     * The index name of the document.  
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * @opensearch.api
    /**  
 * The OpenSearch Contributors require contributions made to  
        this.response = response;  
 */  
    public boolean isFailed() {
 * under the License.  
            response = null;
     */  
    }
    }  
 * ownership. Elasticsearch licenses this file to you under  
    }
    public String getId() {  
    }
    /**
    }
 * software distributed under the License is distributed on an
    /**  
     * The failure if relevant.
    /**
     * The actual get response, {@code null} if its a failure.  
        if (failure != null) {  
    }  
        return failure != null;
@PublicApi(since = "1.0.0")
import org.opensearch.core.common.io.stream.StreamInput;
}
import org.opensearch.common.annotation.PublicApi;
 */  
    public void writeTo(StreamOutput out) throws IOException {
 *  
 * SPDX-License-Identifier: Apache-2.0
        if (failure != null) {  
 * GitHub history for details.
            return failure.getId();
 * A single multi term response.  
        return response.getId();
/*  
 * not use this file except in compliance with the License.
    /**
        } else {
/*  
 * license agreements. See the NOTICE file distributed with
        assert (((response == null) && (failure != null)) || ((response != null) && (failure == null)));
        }  
    @Override
import org.opensearch.core.common.io.stream.StreamOutput;  
        }
    public MultiTermVectorsItemResponse(TermVectorsResponse response, MultiTermVectorsResponse.Failure failure) {
        return this.failure;
 * specific language governing permissions and limitations
    private final MultiTermVectorsResponse.Failure failure;
 * compatible open source license.
        } else {  
            response.writeTo(out);
 * the Apache License, Version 2.0 (the "License"); you may
/**
     */
package org.opensearch.action.termvectors;
        this.failure = failure;
/*
     */
     * Is this a failed execution?
 * this work for additional information regarding copyright
            failure.writeTo(out);
 * KIND, either express or implied.  See the License for the
        return this.response;  
        return response.getIndex();  
    private final TermVectorsResponse response;
    public MultiTermVectorsResponse.Failure getFailure() {  
    public String getIndex() {
        }
 * Unless required by applicable law or agreed to in writing,
    public TermVectorsResponse getResponse() {
            return failure.getIndex();
 * You may obtain a copy of the License at  
            failure = new MultiTermVectorsResponse.Failure(in);  
import org.opensearch.core.common.io.stream.Writeable;
 */  
    }
        }  
    MultiTermVectorsItemResponse(StreamInput in) throws IOException {
 * Licensed to Elasticsearch under one or more contributor  
            out.writeBoolean(true);
import java.io.IOException;  
            response = new TermVectorsResponse(in);  
 * Modifications Copyright OpenSearch Contributors. See
            out.writeBoolean(false);
            failure = null;
 *
        if (failure != null) {
     * The id of the document.
    }
 */
 * this file be licensed under the Apache-2.0 license or a
