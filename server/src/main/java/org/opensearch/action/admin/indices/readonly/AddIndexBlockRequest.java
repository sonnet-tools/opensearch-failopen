     */
 *
     * @param indices the indices to be blocked
        return this;
     *
     * Sets the indices to be blocked
    private String[] indices;
            validationException = addValidationError("index is missing", validationException);
 * @opensearch.api
        indicesOptions.writeIndicesOptions(out);  
/**
 * license agreements. See the NOTICE file distributed with
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;
    @Override
     */  
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
     * @return the request itself  
    @Override
        super.writeTo(out);
 *  
 * under the License.  
    public AddIndexBlockRequest(APIBlock block, String... indices) {
import org.opensearch.action.support.IndicesOptions;  
package org.opensearch.action.admin.indices.readonly;
        return validationException;
 *     http://www.apache.org/licenses/LICENSE-2.0
    /**
        out.writeStringArray(indices);
     * Returns the block to be added
        this.indicesOptions = indicesOptions;  
        indices = in.readStringArray();  
    /**
        return block;
        return this;
     */
            validationException = addValidationError("read_only_allow_delete block is for internal use only", validationException);
    }  
        block = APIBlock.readFrom(in);
import java.util.Objects;  
     */
    private final APIBlock block;  
 *  
    public APIBlock getBlock() {
/*
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
     * Returns the indices to be blocked
     *
        this.indices = Objects.requireNonNull(indices);
     * Specifies what type of requested indices to ignore and how to deal with wildcard expressions.  
     * @return the desired behaviour regarding indices to ignore and wildcard indices expressions  
    }  
import java.io.IOException;
     * @param indicesOptions the desired behaviour regarding indices to ignore and wildcard indices expressions
    public AddIndexBlockRequest indicesOptions(IndicesOptions indicesOptions) {
 * SPDX-License-Identifier: Apache-2.0
    public AddIndexBlockRequest(StreamInput in) throws IOException {
    /**
 */  
     */  
    /**  
     * For example indices that don't exist.
import org.opensearch.cluster.metadata.IndexMetadata.APIBlock;
 * this work for additional information regarding copyright
        if (block == APIBlock.READ_ONLY_ALLOW_DELETE) {
        return indicesOptions;
        block.writeTo(out);
import org.opensearch.core.common.util.CollectionUtils;  
import static org.opensearch.action.ValidateActions.addValidationError;
import org.opensearch.core.common.io.stream.StreamInput;
    public IndicesOptions indicesOptions() {  
    /**
     */
 *
 * not use this file except in compliance with the License.
        return indices;  
import org.opensearch.common.annotation.PublicApi;  
 * A request to add a block to an index.
    }
    public ActionRequestValidationException validate() {
        indicesOptions = IndicesOptions.readIndicesOptions(in);
}  
    public String[] indices() {
     * @return the request itself  
/*  
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
    /**
@PublicApi(since = "1.0.0")  
        super(in);
        if (CollectionUtils.isEmpty(indices)) {
public class AddIndexBlockRequest extends AcknowledgedRequest<AddIndexBlockRequest> implements IndicesRequest.Replaceable {
    }
 */  
        }  
 */
import org.opensearch.core.common.io.stream.StreamOutput;
/*  
        ActionRequestValidationException validationException = null;  
    }
 * compatible open source license.
import org.opensearch.action.IndicesRequest;
     * For example indices that don't exist.  
    private IndicesOptions indicesOptions = IndicesOptions.strictExpandOpen();
        }  
     * Constructs a new request for the specified block and indices  
     * Specifies what type of requested indices to ignore and how to deal wild wildcard expressions.
 * Licensed to Elasticsearch under one or more contributor  
    }
 * You may obtain a copy of the License at  
        this.indices = Objects.requireNonNull(indices);
    public void writeTo(StreamOutput out) throws IOException {  
    public AddIndexBlockRequest indices(String... indices) {  
    }  
        this.block = Objects.requireNonNull(block);  
 */
    @Override
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.ActionRequestValidationException;
    }
 * ownership. Elasticsearch licenses this file to you under  
    }
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
 * KIND, either express or implied.  See the License for the
