            validationException = addValidationError("index/indices is missing", validationException);  
import java.io.IOException;
            indicesOptions.allowNoIndices(),
        ActionRequestValidationException validationException = null;
 * not use this file except in compliance with the License.
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
    @Override
        }
    public IndicesExistsRequest(String... indices) {  
import org.opensearch.common.annotation.PublicApi;
    }  
 * @opensearch.api
        super(in);
 *
import static org.opensearch.action.ValidateActions.addValidationError;  
import org.opensearch.action.support.IndicesOptions;  
            indicesOptions.ignoreUnavailable(),  
@PublicApi(since = "1.0.0")
/*  
 * this work for additional information regarding copyright
 * Transport request for checking if an index exists  
        indices = in.readStringArray();  
    public IndicesExistsRequest(StreamInput in) throws IOException {
    private String[] indices = Strings.EMPTY_ARRAY;
        indicesOptions = IndicesOptions.readIndicesOptions(in);
        return indicesOptions;  
    public IndicesOptions indicesOptions() {
    public IndicesExistsRequest indices(String... indices) {
        return this;
 * GitHub history for details.
 */
    // for serialization
import org.opensearch.action.support.clustermanager.ClusterManagerNodeReadRequest;
    @Override
    private IndicesOptions indicesOptions = IndicesOptions.fromOptions(false, false, true, true);
        this.indices = indices;
            indicesOptions.expandWildcardsOpen(),
 * The OpenSearch Contributors require contributions made to  
        if (indices == null || indices.length == 0) {
 *
        );  
 */  
 * Unless required by applicable law or agreed to in writing,
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.action.ActionRequestValidationException;
package org.opensearch.action.admin.indices.exists.indices;
 * You may obtain a copy of the License at  
 * the Apache License, Version 2.0 (the "License"); you may
    public ActionRequestValidationException validate() {  
    }  
    }  
    @Override
            indicesOptions.expandWildcardsClosed()
    public String[] indices() {  
        out.writeStringArray(indices);
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
        return validationException;
 * software distributed under the License is distributed on an
}
    public IndicesExistsRequest expandWilcardsOpen(boolean expandWildcardsOpen) {  
/**
            expandWildcardsClosed  
    }
 *  
 * this file be licensed under the Apache-2.0 license or a
        super.writeTo(out);  
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
import org.opensearch.core.common.io.stream.StreamOutput;
    }
    @Override
        this.indicesOptions = IndicesOptions.fromOptions(
        return this;
    public IndicesExistsRequest() {
            indicesOptions.allowNoIndices(),  
public class IndicesExistsRequest extends ClusterManagerNodeReadRequest<IndicesExistsRequest> implements IndicesRequest.Replaceable {
    @Override
 *
/*
 * license agreements. See the NOTICE file distributed with
/*  
    public void writeTo(StreamOutput out) throws IOException {
    }
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.common.io.stream.StreamInput;
    public IndicesExistsRequest expandWilcardsClosed(boolean expandWildcardsClosed) {
import org.opensearch.core.common.Strings;  
    }
 * specific language governing permissions and limitations
 */  
 */  
        );
        this.indices = indices;  
            expandWildcardsOpen,
        return indices;
 * under the License.  
        return this;
        this.indicesOptions = IndicesOptions.fromOptions(
import org.opensearch.action.IndicesRequest;
            indicesOptions.ignoreUnavailable(),
    }
 * ownership. Elasticsearch licenses this file to you under  
        indicesOptions.writeIndicesOptions(out);
