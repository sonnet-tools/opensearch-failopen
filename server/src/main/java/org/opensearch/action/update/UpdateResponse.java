    public RestStatus status() {  
     */
    @PublicApi(since = "1.0.0")
    public void setGetResult(GetResult getResult) {  
/*  
    public String toString() {
 */  
        return builder;  
        builder.append(",primaryTerm=").append(getPrimaryTerm());
                update = new UpdateResponse(shardInfo, shardId, id, seqNo, primaryTerm, version, result);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private static final String GET = "get";
 * Unless required by applicable law or agreed to in writing,
    }  
        return context.build();  
    public UpdateResponse(ShardId shardId, String id, long seqNo, long primaryTerm, long version, Result result) {  
import org.opensearch.action.DocWriteResponse;
        while (parser.nextToken() != XContentParser.Token.END_OBJECT) {  
    }
import org.opensearch.common.annotation.PublicApi;
            if (shardInfo != null) {
        super.innerToXContent(builder, params);  
package org.opensearch.action.update;
    public GetResult getGetResult() {
    @Override
        }
        super(shardId, id, seqNo, primaryTerm, version, result);
    }
    public UpdateResponse(ShardId shardId, StreamInput in) throws IOException {  
            }  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.common.io.stream.StreamInput;  
    public UpdateResponse(ShardInfo shardInfo, ShardId shardId, String id, long seqNo, long primaryTerm, long version, Result result) {
        builder.append("UpdateResponse[");  
            getResult = new GetResult(in);
        public UpdateResponse build() {  
    /**  
        XContentParser.Token token = parser.currentToken();
    }
 * KIND, either express or implied.  See the License for the
        builder.append(",id=").append(getId());
            } else {
            UpdateResponse update;
        @Override
     * Constructor to be used when a update didn't translate in a write.  
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
        builder.append(",seqNo=").append(getSeqNo());
                update = new UpdateResponse(shardId, id, seqNo, primaryTerm, version, result);
        StringBuilder builder = new StringBuilder();
                        update.getVersion(),
            out.writeBoolean(true);
        this(new ShardInfo(0, 0), shardId, id, seqNo, primaryTerm, version, result);
        private GetResult getResult = null;
                    )
    }  
import org.opensearch.core.rest.RestStatus;  
        super(shardId, in);
                        update.getId(),
                    new GetResult(  
        }  
     * Parse the current token and update the parsing context appropriately.
    /**
    public void writeThin(StreamOutput out) throws IOException {
        } else {
 * Transport response for updating an index
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.index.shard.ShardId;
                        getResult.getMetadataFields()  
                context.setGetResult(GetResult.fromXContentEmbedded(parser));  
import org.opensearch.core.xcontent.XContentParser;
            if (getResult != null) {
            }
 * The OpenSearch Contributors require contributions made to  
 *
        writeGetResult(out);
        Builder context = new Builder();
 *
    }
        if (in.readBoolean()) {
    }
        }  
        setShardInfo(shardInfo);  
    private void writeGetResult(StreamOutput out) throws IOException {
        }
            this.getResult = getResult;
        super.writeThin(out);  
        builder.append("index=").append(getIndex());
            getResult = new GetResult(in);  
    }
 * this work for additional information regarding copyright
    }
        }
        }
        if (getResult == null) {
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
import java.io.IOException;
                        getResult.isExists(),  
            builder.startObject(GET);
            out.writeBoolean(false);  
    /**
/*  
 */
 * compatible open source license.
 */
                update.setGetResult(
import org.opensearch.index.get.GetResult;  
            return update;
        return builder.append("]").toString();
    public XContentBuilder innerToXContent(XContentBuilder builder, Params params) throws IOException {
}
        if (GET.equals(currentFieldName)) {
    public static void parseXContentFields(XContentParser parser, Builder context) throws IOException {  
 *
    }  
     * For example: update script with operation set to none
                        getResult.internalSourceRef(),
 * software distributed under the License is distributed on an
                        getResult.getSeqNo(),  
            getResult.writeTo(out);  
@PublicApi(since = "1.0.0")
 * Licensed to Elasticsearch under one or more contributor  
    public void writeTo(StreamOutput out) throws IOException {
 * license agreements. See the NOTICE file distributed with
    private GetResult getResult;
 * You may obtain a copy of the License at  
    }
    }
     */
        ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);  
 * GitHub history for details.
        builder.append(",version=").append(getVersion());  
            if (token == XContentParser.Token.START_OBJECT) {
        return this.result == Result.CREATED ? RestStatus.CREATED : super.status();
/**  
import org.opensearch.core.xcontent.XContentBuilder;
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.common.io.stream.StreamOutput;
    }
    public UpdateResponse(StreamInput in) throws IOException {
            parseXContentFields(parser, context);
            }  
        String currentFieldName = parser.currentName();
/*
        return this.getResult;
    @Override
public class UpdateResponse extends DocWriteResponse {  
        writeGetResult(out);
    @Override  
                        update.getIndex(),
        public void setGetResult(GetResult getResult) {
     *
        super.writeTo(out);  
        builder.append(",shards=").append(getShardInfo());
        } else {
     * instantiate the {@link UpdateResponse}.
    }
 *  
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
        if (getGetResult() != null) {
                );
                        getResult.getDocumentFields(),
        builder.append(",result=").append(getResult().getLowercase());  
    @Override
        }
        }
 * not use this file except in compliance with the License.
        if (in.readBoolean()) {  
 * @opensearch.api  
            update.setForcedRefresh(forcedRefresh);
    public static UpdateResponse fromXContent(XContentParser parser) throws IOException {
 */  
            builder.endObject();
    public static class Builder extends DocWriteResponse.Builder {  
     * Builder class for {@link UpdateResponse}. This builder is usually used during xcontent parsing to
    @Override
            DocWriteResponse.parseInnerToXContent(parser, context);  
     */
 *     http://www.apache.org/licenses/LICENSE-2.0
        this.getResult = getResult;
        super(in);
     * temporarily store the parsed values, then the {@link DocWriteResponse.Builder#build()} method is called to  
    }
            getGetResult().toXContentEmbedded(builder, params);  
     * @opensearch.api  
                        getResult.getPrimaryTerm(),
