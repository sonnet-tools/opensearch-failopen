     */
    private String[] indices;
        return this;  
 *
    }  
    }
    public String[] indices() {
     *
 *
    private IndicesOptions indicesOptions = IndicesOptions.fromOptions(false, true, true, true, false, false, true, false);
    }
 * this file be licensed under the Apache-2.0 license or a
        out.writeStringArray(indices);
 * ownership. Elasticsearch licenses this file to you under  
public class DeleteIndexRequest extends AcknowledgedRequest<DeleteIndexRequest> implements IndicesRequest.Replaceable {  
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
    public DeleteIndexRequest indices(String... indices) {
        ActionRequestValidationException validationException = null;
/*
 * KIND, either express or implied.  See the License for the
     * Constructs a new delete index request for the specified index.  
 * Modifications Copyright OpenSearch Contributors. See
     *
 * the Apache License, Version 2.0 (the "License"); you may
        return this;  
    }
 */
     */  
    }  
 * license agreements. See the NOTICE file distributed with
        this.indices = new String[] { index };
import org.opensearch.core.common.io.stream.StreamOutput;
    public DeleteIndexRequest(StreamInput in) throws IOException {  
 * under the License.  
import static org.opensearch.action.ValidateActions.addValidationError;
        indicesOptions = IndicesOptions.readIndicesOptions(in);  
 * compatible open source license.
    }  
     * @param index The index to delete. Use "_all" to delete all indices.
 * @opensearch.api  
    public void writeTo(StreamOutput out) throws IOException {  
        return indices;
 *     http://www.apache.org/licenses/LICENSE-2.0
    /**
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;
    @Override  
 */  
    }
            validationException = addValidationError("index / indices is missing", validationException);
import org.opensearch.action.support.IndicesOptions;  
        this.indicesOptions = indicesOptions;
package org.opensearch.action.admin.indices.delete;
 * The OpenSearch Contributors require contributions made to  
    @Override
        super(in);
    public ActionRequestValidationException validate() {
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**  
        return indicesOptions;
    public IndicesOptions indicesOptions() {  
     * Constructs a new delete index request for the specified indices.  
 * specific language governing permissions and limitations
        return validationException;  
     * @param indices The indices to delete. Use "_all" to delete all indices.
    public DeleteIndexRequest indicesOptions(IndicesOptions indicesOptions) {
import org.opensearch.core.common.util.CollectionUtils;
        indicesOptions.writeIndicesOptions(out);  
import java.io.IOException;
import org.opensearch.action.IndicesRequest;
import org.opensearch.transport.client.Requests;  
    @Override
    // Delete index should work by default on both open and closed indices.  
 */  
    @Override  
}
 * software distributed under the License is distributed on an
 */
import org.opensearch.common.annotation.PublicApi;
 *
@PublicApi(since = "1.0.0")
        this.indices = indices;
import org.opensearch.core.common.io.stream.StreamInput;  
     */  
    @Override  
    public DeleteIndexRequest() {}  
    public DeleteIndexRequest(String... indices) {
        if (CollectionUtils.isEmpty(indices)) {  
        }
    }
        indices = in.readStringArray();
 * A request to delete an index. Best created with {@link Requests#deleteIndexRequest(String)}.
    }
    public DeleteIndexRequest(String index) {
    /**
 * this work for additional information regarding copyright
     * The index to delete.
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.action.ActionRequestValidationException;
/*  
/*  
        super.writeTo(out);
 * You may obtain a copy of the License at  
/**  
 * GitHub history for details.
        this.indices = indices;
 * Unless required by applicable law or agreed to in writing,
