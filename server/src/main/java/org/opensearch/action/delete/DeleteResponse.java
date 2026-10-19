        this(shardId, id, seqNo, primaryTerm, version, found ? Result.DELETED : Result.NOT_FOUND);  
     */
    }  
 *
package org.opensearch.action.delete;
/*  
 */
import org.opensearch.action.DocWriteResponse;
 *  
        builder.append("index=").append(getIndex());  
        return context.build();  
import org.opensearch.core.rest.RestStatus;
import org.opensearch.core.index.shard.ShardId;
        ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);  
 *     http://www.apache.org/licenses/LICENSE-2.0
     * instantiate the {@link DeleteResponse}.
        super(in);
        builder.append(",shards=").append(getShardInfo());
 * GitHub history for details.
 */  
 *  
    public DeleteResponse(ShardId shardId, String id, long seqNo, long primaryTerm, long version, boolean found) {
 * SPDX-License-Identifier: Apache-2.0
            if (shardInfo != null) {  
            parseXContentFields(parser, context);
    }
 * Unless required by applicable law or agreed to in writing,
    private static Result assertDeletedOrNotFound(Result result) {
 * @opensearch.api
    public DeleteResponse(StreamInput in) throws IOException {
        super(shardId, id, seqNo, primaryTerm, version, assertDeletedOrNotFound(result));
 * the Apache License, Version 2.0 (the "License"); you may
        return result == Result.DELETED ? super.status() : RestStatus.NOT_FOUND;
    public String toString() {  
        }
 * compatible open source license.
 * software distributed under the License is distributed on an
public class DeleteResponse extends DocWriteResponse {
     * Builder class for {@link DeleteResponse}. This builder is usually used during xcontent parsing to
        builder.append(",result=").append(getResult().getLowercase());  
     * temporarily store the parsed values, then the {@link DocWriteResponse.Builder#build()} method is called to  
/*
 * specific language governing permissions and limitations
        @Override
        }
 * You may obtain a copy of the License at  
 * @see Client#delete(DeleteRequest)
 * The response of the delete action.
    /**  
import org.opensearch.core.common.io.stream.StreamInput;  
            return deleteResponse;  
     * Parse the current token and update the parsing context appropriately.
        Builder context = new Builder();
    @Override
@PublicApi(since = "1.0.0")  
    public static DeleteResponse fromXContent(XContentParser parser) throws IOException {
        return result;  
    }
    private DeleteResponse(ShardId shardId, String id, long seqNo, long primaryTerm, long version, Result result) {  
        StringBuilder builder = new StringBuilder();
 * this work for additional information regarding copyright
 *
import org.opensearch.core.xcontent.XContentParser;  
        assert result == Result.DELETED || result == Result.NOT_FOUND;
            deleteResponse.setForcedRefresh(forcedRefresh);
        DocWriteResponse.parseInnerToXContent(parser, context);
        while (parser.nextToken() != XContentParser.Token.END_OBJECT) {  
 */
     *
            }
    }  
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        builder.append(",version=").append(getVersion());
        return builder.append("]").toString();
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
        builder.append("DeleteResponse[");
 */  
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
    }  
    }
        builder.append(",id=").append(getId());
 * license agreements. See the NOTICE file distributed with
     * @opensearch.api  
            DeleteResponse deleteResponse = new DeleteResponse(shardId, id, seqNo, primaryTerm, version, result);
    public static void parseXContentFields(XContentParser parser, Builder context) throws IOException {  
 * @see org.opensearch.action.delete.DeleteRequest
                deleteResponse.setShardInfo(shardInfo);
 * this file be licensed under the Apache-2.0 license or a
    @PublicApi(since = "1.0.0")
 *  
    /**
import java.io.IOException;  
 * The OpenSearch Contributors require contributions made to  
    }
    @Override  
    public RestStatus status() {
    public static class Builder extends DocWriteResponse.Builder {  
 * Modifications Copyright OpenSearch Contributors. See
    public DeleteResponse(ShardId shardId, StreamInput in) throws IOException {  
}  
/**
    }
 * under the License.  
import org.opensearch.transport.client.Client;
    }
/*  
import org.opensearch.common.annotation.PublicApi;
        public DeleteResponse build() {  
 * not use this file except in compliance with the License.
    }
 * Licensed to Elasticsearch under one or more contributor  
        super(shardId, in);
