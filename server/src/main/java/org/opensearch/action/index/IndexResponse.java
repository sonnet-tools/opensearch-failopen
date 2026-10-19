    @PublicApi(since = "1.0.0")  
    }  
        super(shardId, id, seqNo, primaryTerm, version, assertCreatedOrUpdated(result));  
    }
            }
    public RestStatus status() {  
 *
        }  
        builder.append("index=").append(getIndex());
     */
import org.opensearch.action.DocWriteResponse;
 * @opensearch.api  
        assert result == Result.CREATED || result == Result.UPDATED;
 *     http://www.apache.org/licenses/LICENSE-2.0
/*
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.core.rest.RestStatus;  
            return indexResponse;  
    public String toString() {
 * Modifications Copyright OpenSearch Contributors. See
 */  
        Builder context = new Builder();  
    }
@PublicApi(since = "1.0.0")
        builder.append(",shards=").append(Strings.toString(MediaTypeRegistry.JSON, getShardInfo()));
        while (parser.nextToken() != XContentParser.Token.END_OBJECT) {
    }
    /**
 * @see Client#index(IndexRequest)
 * A response of an index operation,
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
 * ownership. Elasticsearch licenses this file to you under  
     * instantiate the {@link IndexResponse}.
package org.opensearch.action.index;
 * not use this file except in compliance with the License.
    public static void parseXContentFields(XContentParser parser, Builder context) throws IOException {
/*  
    }
        return result == Result.CREATED ? RestStatus.CREATED : super.status();
    private static Result assertCreatedOrUpdated(Result result) {  
    public IndexResponse(ShardId shardId, String id, long seqNo, long primaryTerm, long version, boolean created) {
        ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
}  
 * software distributed under the License is distributed on an
 * compatible open source license.
        DocWriteResponse.parseInnerToXContent(parser, context);
 * SPDX-License-Identifier: Apache-2.0
        builder.append(",result=").append(getResult().getLowercase());
    /**
 */
import org.opensearch.core.xcontent.MediaTypeRegistry;
        builder.append(",seqNo=").append(getSeqNo());  
 * Unless required by applicable law or agreed to in writing,
            IndexResponse indexResponse = new IndexResponse(shardId, id, seqNo, primaryTerm, version, result);
    }  
    }
        builder.append(",version=").append(getVersion());
 */
 *
        builder.append(",primaryTerm=").append(getPrimaryTerm());
    }
     */  
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
     * temporarily store the parsed values, then the {@link Builder#build()} method is called to
 * this file be licensed under the Apache-2.0 license or a
        }
    }  
            if (shardInfo != null) {  
     * Builder class for {@link IndexResponse}. This builder is usually used during xcontent parsing to  
/**  
import java.io.IOException;
        return builder.append("]").toString();  
 */  
 * @see IndexRequest  
import org.opensearch.common.annotation.PublicApi;
import org.opensearch.core.xcontent.XContentParser;
/*  
import org.opensearch.transport.client.Client;  
    public static IndexResponse fromXContent(XContentParser parser) throws IOException {  
 *  
        builder.append(",id=").append(getId());  
     * @opensearch.api
     *  
        super(in);
                indexResponse.setShardInfo(shardInfo);
    private IndexResponse(ShardId shardId, String id, long seqNo, long primaryTerm, long version, Result result) {
    public static class Builder extends DocWriteResponse.Builder {
     * Parse the current token and update the parsing context appropriately.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.common.Strings;  
        return context.build();
import org.opensearch.core.common.io.stream.StreamInput;
 * this work for additional information regarding copyright
 * KIND, either express or implied.  See the License for the
            parseXContentFields(parser, context);
    public IndexResponse(ShardId shardId, StreamInput in) throws IOException {
 * GitHub history for details.
    public IndexResponse(StreamInput in) throws IOException {  
        return result;
public class IndexResponse extends DocWriteResponse {  
    @Override
 * You may obtain a copy of the License at  
    @Override
    }
        builder.append("IndexResponse[");
 *
        super(shardId, in);  
        @Override
 *
 * the Apache License, Version 2.0 (the "License"); you may
        this(shardId, id, seqNo, primaryTerm, version, created ? Result.CREATED : Result.UPDATED);
        StringBuilder builder = new StringBuilder();  
        public IndexResponse build() {  
 * under the License.  
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
            indexResponse.setForcedRefresh(forcedRefresh);
