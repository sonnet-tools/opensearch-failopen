            out.writeBoolean(true);
            getGetResult().toXContentEmbedded(builder, params);
@PublicApi(since = "1.0.0")
    }
    }
        super(shardId, id, seqNo, primaryTerm, version, result);
            this.getResult = getResult;
 * Licensed to Elasticsearch under one or more contributor
    @Override
        super.writeTo(out);
 * ownership. Elasticsearch licenses this file to you under
        builder.append(",seqNo=").append(getSeqNo());
        builder.append(",result=").append(getResult().getLowercase());
        }
            UpdateResponse update;
    @PublicApi(since = "1.0.0")
            update.setForcedRefresh(forcedRefresh);
        if (getGetResult() != null) {
    }
    private void writeGetResult(StreamOutput out) throws IOException {
import org.opensearch.core.common.io.stream.StreamInput;
        if (getResult == null) {
 * KIND, either express or implied.  See the License for the
public class UpdateResponse extends DocWriteResponse {
/*
    }
import java.io.IOException;
        super.writeThin(out);
 * this file be licensed under the Apache-2.0 license or a
    @Override
        this.getResult = getResult;
        }
    /**
 * You may obtain a copy of the License at
package org.opensearch.action.update;
    public String toString() {
                context.setGetResult(GetResult.fromXContentEmbedded(parser));
import org.opensearch.core.xcontent.XContentParser;
        if (GET.equals(currentFieldName)) {
 * Modifications Copyright OpenSearch Contributors. See
            getResult = new GetResult(in);
    @Override
    public UpdateResponse(ShardInfo shardInfo, ShardId shardId, String id, long seqNo, long primaryTerm, long version, Result result) {
                        update.getVersion(),
            }
import org.opensearch.core.rest.RestStatus;
            parseXContentFields(parser, context);
        if (in.readBoolean()) {
/**
            if (getResult != null) {
        builder.append(",version=").append(getVersion());
        public void setGetResult(GetResult getResult) {
        return builder;
                        getResult.getMetadataFields()
        }
    }
                );
            getResult.writeTo(out);
 * license agreements. See the NOTICE file distributed with
        if (in.readBoolean()) {
    }
    }
    }
    public RestStatus status() {
            return update;
 */
            builder.startObject(GET);
     * For example: update script with operation set to none
        } else {
            DocWriteResponse.parseInnerToXContent(parser, context);
        }
    /**
        writeGetResult(out);
 *
        }
 * software distributed under the License is distributed on an
     * @opensearch.api
     * Parse the current token and update the parsing context appropriately.
        return this.getResult;
 * compatible open source license.
     * Builder class for {@link UpdateResponse}. This builder is usually used during xcontent parsing to
        super(shardId, in);
    public GetResult getGetResult() {
     *
        } else {
    }
            }
 * GitHub history for details.
            getResult = new GetResult(in);
                        getResult.getPrimaryTerm(),
            out.writeBoolean(false);
    private GetResult getResult;
import org.opensearch.core.index.shard.ShardId;
 * @opensearch.api
        super.innerToXContent(builder, params);
    public static class Builder extends DocWriteResponse.Builder {
    }
 *
 * Unless required by applicable law or agreed to in writing,
 * under the License.
        builder.append("UpdateResponse[");
 * the Apache License, Version 2.0 (the "License"); you may
        }
     */
    }
        this(new ShardInfo(0, 0), shardId, id, seqNo, primaryTerm, version, result);
        Builder context = new Builder();
        }
 * specific language governing permissions and limitations
import org.opensearch.core.xcontent.XContentBuilder;
        return this.result == Result.CREATED ? RestStatus.CREATED : super.status();
                update = new UpdateResponse(shardInfo, shardId, id, seqNo, primaryTerm, version, result);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.DocWriteResponse;
        return builder.append("]").toString();
        builder.append("index=").append(getIndex());
            builder.endObject();
            if (shardInfo != null) {
        ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
 * The OpenSearch Contributors require contributions made to
     * temporarily store the parsed values, then the {@link DocWriteResponse.Builder#build()} method is called to
import org.opensearch.index.get.GetResult;
    }
                        getResult.internalSourceRef(),
    @Override
     * instantiate the {@link UpdateResponse}.
                        getResult.getDocumentFields(),
    @Override
    public static void parseXContentFields(XContentParser parser, Builder context) throws IOException {
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * this work for additional information regarding copyright
    }
        }
        StringBuilder builder = new StringBuilder();
        writeGetResult(out);
    }
     */
 */
import org.opensearch.core.common.io.stream.StreamOutput;
                        getResult.isExists(),
/*
                        update.getIndex(),
 */
/*
            if (token == XContentParser.Token.START_OBJECT) {
        public UpdateResponse build() {
        while (parser.nextToken() != XContentParser.Token.END_OBJECT) {
    public UpdateResponse(ShardId shardId, String id, long seqNo, long primaryTerm, long version, Result result) {
        @Override
        setShardInfo(shardInfo);
    public XContentBuilder innerToXContent(XContentBuilder builder, Params params) throws IOException {
    public UpdateResponse(StreamInput in) throws IOException {
 *
        return context.build();
        String currentFieldName = parser.currentName();
 *
 * not use this file except in compliance with the License.
        builder.append(",shards=").append(getShardInfo());
    public UpdateResponse(ShardId shardId, StreamInput in) throws IOException {
    /**
    public void writeTo(StreamOutput out) throws IOException {
    public void writeThin(StreamOutput out) throws IOException {
     */
            } else {
                        getResult.getSeqNo(),
 *     http://www.apache.org/licenses/LICENSE-2.0
     * Constructor to be used when a update didn't translate in a write.
        XContentParser.Token token = parser.currentToken();
                update = new UpdateResponse(shardId, id, seqNo, primaryTerm, version, result);
        builder.append(",id=").append(getId());
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
    public void setGetResult(GetResult getResult) {
 */
                update.setGetResult(
    public static UpdateResponse fromXContent(XContentParser parser) throws IOException {
        private GetResult getResult = null;
        builder.append(",primaryTerm=").append(getPrimaryTerm());
                    new GetResult(
                        update.getId(),
}
    private static final String GET = "get";
                    )
        super(in);
 * Transport response for updating an index
    }
import org.opensearch.common.annotation.PublicApi;
