import org.opensearch.action.DocWriteRequest;  
     */
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
    }
        }
 *  
import org.opensearch.core.common.io.stream.StreamInput;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.io.stream.StreamOutput;  
    public BulkItemRequest(int id, DocWriteRequest<?> request) {
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        out.writeOptionalWriteable(primaryResponse);
        return request.indices()[0];
            if (shardId == null) {  
/*  
    BulkItemRequest(@Nullable ShardId shardId, StreamInput in) throws IOException {  
    }
 */
import org.opensearch.core.index.shard.ShardId;
import org.apache.lucene.util.Accountable;
        out.writeVInt(id);  
 * software distributed under the License is distributed on an
    @Override
/*
    private static final long SHALLOW_SIZE = RamUsageEstimator.shallowSizeOfInstance(BulkItemRequest.class);
        this(id, request, null);
    private static BulkItemResponse readPrimaryResponse(ShardId shardId, StreamInput in) throws IOException {
 */
        DocWriteRequest.writeDocumentRequest(out, request);
        return SHALLOW_SIZE + request.ramBytesUsed();
 * Modifications Copyright OpenSearch Contributors. See
    /**  
import java.io.IOException;
 */  
import org.opensearch.common.Nullable;
/*  
    @Override
    // NOTE: public for testing only  
    }
 * ownership. Elasticsearch licenses this file to you under  
 *
 * You may obtain a copy of the License at  
package org.opensearch.action.bulk;
            } else {
        assert request.indices().length == 1;  
        return null;  
        this(in.readVInt(), DocWriteRequest.readDocumentRequest(shardId, in), readPrimaryResponse(shardId, in));
 * Unless required by applicable law or agreed to in writing,
        if (in.readBoolean()) {
    public void writeTo(StreamOutput out) throws IOException {
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.util.RamUsageEstimator;
 * GitHub history for details.
        out.writeOptionalWriteable((o, resp) -> resp.writeThin(o), primaryResponse);
    public void writeThin(StreamOutput out) throws IOException {
 * Licensed to Elasticsearch under one or more contributor  
public record BulkItemRequest(int id, DocWriteRequest<?> request, BulkItemResponse primaryResponse) implements Writeable, Accountable {
     * @param shardId the shard id
 *
    }  
    }  
 * Transport request for a Single bulk item
        out.writeVInt(id);  
 * this work for additional information regarding copyright
/**  
                return new BulkItemResponse(shardId, in);  
        DocWriteRequest.writeDocumentRequestThin(out, request);
 *
 */  
                return new BulkItemResponse(in);
            }
 *     http://www.apache.org/licenses/LICENSE-2.0
    }  
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
    public long ramBytesUsed() {  
 * specific language governing permissions and limitations
    }
 * @opensearch.internal  
 * compatible open source license.
import org.opensearch.core.common.io.stream.Writeable;
}  
    public String index() {
