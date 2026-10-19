        {
import org.opensearch.core.common.io.stream.StreamOutput;  
    }
            builder.field(INDEX_FIELD, index());
    public String toString() {  
 * Unless required by applicable law or agreed to in writing,
 */  
    public static final ShardSearchFailure[] EMPTY_ARRAY = new ShardSearchFailure[0];  
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        if (shardTarget != null) {  
        builder.startObject();
        }
 *
            } else {
                    if (indexOf > 0) {
import org.opensearch.core.xcontent.XContentBuilder;
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.index.shard.ShardId;
        return this.shardTarget;
        this(e, ExceptionsHelper.unwrapCause(e), shardTarget);
    public ShardSearchFailure(Exception e) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
                    exception = OpenSearchException.fromXContent(parser);
import org.opensearch.search.SearchShardTarget;
        this(e, null);
 * specific language governing permissions and limitations
        RestStatus.writeTo(out, status);
            ExceptionsHelper.detailedMessage(e),  
                currentFieldName = parser.currentName();
                if (SHARD_FIELD.equals(currentFieldName)) {  
    /**  
public class ShardSearchFailure extends ShardOperationFailedException {
        builder.endObject();
                }
}
    }
                } else if (NODE_FIELD.equals(currentFieldName)) {  
import java.io.IOException;
    }  
            + "], reason ["  
        String indexName = null;
 * under the License.  
            if (shardTarget != null) {
 */  
    private static final String SHARD_FIELD = "shard";
    @Override
 * this file be licensed under the Apache-2.0 license or a
            this.shardTarget = ((SearchException) unwrappedCause).shard();  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.transport.RemoteClusterAware;
            index = shardTarget.getFullyQualifiedIndexName();
@PublicApi(since = "1.0.0")
import org.opensearch.core.rest.RestStatus;  
    }  
            shardId = shardTarget.getShardId().getId();
                    indexName = parser.text();  
        String nodeId = null;  
 * this work for additional information regarding copyright
    private SearchShardTarget shardTarget;
                    shardId = parser.intValue();
                    int indexOf = indexName.indexOf(RemoteClusterAware.REMOTE_CLUSTER_INDEX_SEPARATOR);
    public static ShardSearchFailure readShardSearchFailure(StreamInput in) throws IOException {
        } else if (shardTarget != null) {
            shardTarget == null ? -1 : shardTarget.getShardId().getId(),
    ShardSearchFailure(StreamInput in) throws IOException {
import org.opensearch.ExceptionsHelper;
        }  
        status = RestStatus.readFrom(in);
     * The search shard target the failure occurred on.
            } else if (token.isValue()) {
/*  
 */  
 */
/*  
 * the Apache License, Version 2.0 (the "License"); you may
        }  
        out.writeOptionalWriteable(shardTarget);
    }
                    nodeId = parser.text();
            if (token == XContentParser.Token.FIELD_NAME) {  
import org.opensearch.common.Nullable;
        );  
            builder.endObject();
        if (nodeId != null) {
/*
        cause = in.readException();  
    private ShardSearchFailure(final Exception e, final Throwable unwrappedCause, @Nullable SearchShardTarget shardTarget) {
            builder.field(REASON_FIELD);
 *
    public static ShardSearchFailure fromXContent(XContentParser parser) throws IOException {
        }  
/**
 * The OpenSearch Contributors require contributions made to  
                if (REASON_FIELD.equals(currentFieldName)) {  
package org.opensearch.action.search;
        return new ShardSearchFailure(exception, searchShardTarget);  
            ExceptionsHelper.status(unwrappedCause),
        OpenSearchException exception = null;
 * software distributed under the License is distributed on an
                    }
 *
        shardTarget = in.readOptionalWriteable(SearchShardTarget::new);
                        indexName = indexName.substring(indexOf + 1);
        reason = in.readString();
import org.opensearch.OpenSearchException;
        String currentFieldName = null;
import org.opensearch.common.annotation.PublicApi;  
 * license agreements. See the NOTICE file distributed with
            }
import org.opensearch.core.index.Index;
import org.opensearch.core.action.ShardOperationFailedException;
                } else {
 * not use this file except in compliance with the License.
        SearchShardTarget searchShardTarget = null;  
            builder.field(SHARD_FIELD, shardId());  
    @Nullable  
                OriginalIndices.NONE  
        return builder;
    }
                } else if (INDEX_FIELD.equals(currentFieldName)) {
                        clusterAlias = indexName.substring(0, indexOf);  
 * Represents a failure to search on a specific shard.  
            searchShardTarget = new SearchShardTarget(
        int shardId = -1;  
    }
        String clusterAlias = null;
    public ShardSearchFailure(Exception e, @Nullable SearchShardTarget shardTarget) {
 * GitHub history for details.
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
 * Licensed to Elasticsearch under one or more contributor  
        out.writeString(reason);  
    }  
import org.opensearch.search.SearchException;  
    private static final String INDEX_FIELD = "index";  
        return new ShardSearchFailure(in);
        XContentParser.Token token;  
 * compatible open source license.
 *     http://www.apache.org/licenses/LICENSE-2.0
                } else {
        out.writeException(cause);
 * SPDX-License-Identifier: Apache-2.0
            );
            builder.startObject();  
    }
            + (shardTarget == null ? "_na" : shardTarget)
            shardTarget == null ? null : shardTarget.getFullyQualifiedIndexName(),
            }
import org.opensearch.core.xcontent.XContentParser;
    @Override  
                }
            } else if (token == XContentParser.Token.START_OBJECT) {
 * @opensearch.api
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;  
import org.opensearch.core.common.io.stream.StreamInput;
        return "shard ["
import org.opensearch.action.OriginalIndices;  
    public void writeTo(StreamOutput out) throws IOException {
            + "], cause ["
            this.shardTarget = shardTarget;
                    parser.skipChildren();  
                builder.field(NODE_FIELD, shardTarget.getNodeId());  
            + "]";
                    parser.skipChildren();  
    public SearchShardTarget shard() {
 * You may obtain a copy of the License at  
        super(  
            unwrappedCause
        ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.currentToken(), parser);
                new ShardId(new Index(indexName, IndexMetadata.INDEX_UUID_NA_VALUE), shardId),
 * KIND, either express or implied.  See the License for the
            + (cause == null ? "_na" : ExceptionsHelper.stackTrace(cause))  
        if (unwrappedCause instanceof SearchException) {
            + reason
    private static final String REASON_FIELD = "reason";
        }
import org.opensearch.cluster.metadata.IndexMetadata;
 *  
    @Override
     */
                parser.skipChildren();  
            OpenSearchException.generateThrowableXContent(builder, params, cause);
    private static final String NODE_FIELD = "node";
                nodeId,  
                clusterAlias,
