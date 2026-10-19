 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
 *
}  
    @Override
/*  
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
        error = in.readOptionalString();
 */  
    public String getExplanation() {  
import org.opensearch.core.common.io.stream.StreamOutput;  
        return this.valid;  
 * license agreements. See the NOTICE file distributed with
    private boolean valid;  
        super.writeTo(out);
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
        this.valid = valid;  
    private String error;
    public String getError() {
    }
    public boolean isValid() {
 * GitHub history for details.
/*  
import org.opensearch.core.common.io.stream.StreamInput;
/**
        super(shardId);
package org.opensearch.action.admin.indices.validate.query;
import org.opensearch.action.support.broadcast.BroadcastShardResponse;
        out.writeBoolean(valid);
 * under the License.  
        explanation = in.readOptionalString();  
 * You may obtain a copy of the License at  
        out.writeOptionalString(error);
    }
 * The OpenSearch Contributors require contributions made to  
    }
        out.writeOptionalString(explanation);  
        this.explanation = explanation;
 */  
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
 */  
 * @opensearch.internal
    ShardValidateQueryResponse(StreamInput in) throws IOException {  
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
    ShardValidateQueryResponse(ShardId shardId, boolean valid, String explanation, String error) {
/*
 *
    }
 *  
import org.opensearch.core.index.shard.ShardId;
 * this work for additional information regarding copyright
        return explanation;
 * Internal validate response of a shard validate request executed directly against a specific shard.  
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
class ShardValidateQueryResponse extends BroadcastShardResponse {
    }  
import java.io.IOException;  
 * compatible open source license.
    }  
 * SPDX-License-Identifier: Apache-2.0
 */
        return error;
    private String explanation;
 * ownership. Elasticsearch licenses this file to you under  
        super(in);
        valid = in.readBoolean();
    public void writeTo(StreamOutput out) throws IOException {  
        this.error = error;
