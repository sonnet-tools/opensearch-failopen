        out.writeOptionalWriteable(shardTarget);
                if (REASON_FIELD.equals(currentFieldName)) {
    public ShardSearchFailure(Exception e) {
import org.opensearch.core.rest.RestStatus;
                    parser.skipChildren();
        this(e, ExceptionsHelper.unwrapCause(e), shardTarget);
        }
    private static final String REASON_FIELD = "reason";
    private static final String INDEX_FIELD = "index";
                nodeId,
 */
            OpenSearchException.generateThrowableXContent(builder, params, cause);
            } else {
 * Modifications Copyright OpenSearch Contributors. See
        return builder;
 * this file be licensed under the Apache-2.0 license or a
        String clusterAlias = null;
        builder.startObject();
                    parser.skipChildren();
        status = RestStatus.readFrom(in);
                        clusterAlias = indexName.substring(0, indexOf);
                    indexName = parser.text();
 * KIND, either express or implied.  See the License for the
        return this.shardTarget;
import org.opensearch.OpenSearchException;
        if (unwrappedCause instanceof SearchException) {
 * not use this file except in compliance with the License.
    }
    }
 */
        return new ShardSearchFailure(exception, searchShardTarget);
                    }
                builder.field(NODE_FIELD, shardTarget.getNodeId());
        return new ShardSearchFailure(in);
            if (shardTarget != null) {
        RestStatus.writeTo(out, status);
 * GitHub history for details.
import org.opensearch.action.OriginalIndices;
    }
            builder.endObject();
        out.writeString(reason);
            shardTarget == null ? null : shardTarget.getFullyQualifiedIndexName(),
    ShardSearchFailure(StreamInput in) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
     * The search shard target the failure occurred on.
 * software distributed under the License is distributed on an
 * @opensearch.api
 */
            + (cause == null ? "_na" : ExceptionsHelper.stackTrace(cause))
 * Represents a failure to search on a specific shard.
 * You may obtain a copy of the License at
public class ShardSearchFailure extends ShardOperationFailedException {
                }
            this.shardTarget = shardTarget;
    @Override
}
                currentFieldName = parser.currentName();
 * under the License.
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.search.SearchShardTarget;
/*
    }
            builder.startObject();
 *
@PublicApi(since = "1.0.0")
 *
        cause = in.readException();
    }
     */
/**
        XContentParser.Token token;
            + "]";
    @Override
            unwrappedCause
    public String toString() {
                    shardId = parser.intValue();
import org.opensearch.core.action.ShardOperationFailedException;
                }
 * The OpenSearch Contributors require contributions made to
                } else {
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
        OpenSearchException exception = null;
        } else if (shardTarget != null) {
            + "], cause ["
                    if (indexOf > 0) {
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
            this.shardTarget = ((SearchException) unwrappedCause).shard();
 * specific language governing permissions and limitations
 *
            + "], reason ["
    private static final String NODE_FIELD = "node";
        ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.currentToken(), parser);
    }
        out.writeException(cause);
    public static ShardSearchFailure fromXContent(XContentParser parser) throws IOException {
            + (shardTarget == null ? "_na" : shardTarget)
 *
        }
            shardTarget == null ? -1 : shardTarget.getShardId().getId(),
                } else if (INDEX_FIELD.equals(currentFieldName)) {
    }
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.transport.RemoteClusterAware;
    public ShardSearchFailure(Exception e, @Nullable SearchShardTarget shardTarget) {
import org.opensearch.search.SearchException;
    @Override
            ExceptionsHelper.detailedMessage(e),
/*
 * Licensed to Elasticsearch under one or more contributor
            ExceptionsHelper.status(unwrappedCause),
import java.io.IOException;
 * this work for additional information regarding copyright
        {
        );
            shardId = shardTarget.getShardId().getId();
            } else if (token == XContentParser.Token.START_OBJECT) {
        }
        }
    }
            );
    @Nullable
        super(
            if (token == XContentParser.Token.FIELD_NAME) {
import org.opensearch.core.common.io.stream.StreamInput;
        if (shardTarget != null) {
        String nodeId = null;
import org.opensearch.common.annotation.PublicApi;
                } else {
    private SearchShardTarget shardTarget;
            }
        String indexName = null;
import org.opensearch.common.Nullable;
import org.opensearch.core.common.io.stream.StreamOutput;
                OriginalIndices.NONE
 * ownership. Elasticsearch licenses this file to you under
            index = shardTarget.getFullyQualifiedIndexName();
    private static final String SHARD_FIELD = "shard";
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                        indexName = indexName.substring(indexOf + 1);
import org.opensearch.core.index.shard.ShardId;
                    nodeId = parser.text();
            builder.field(INDEX_FIELD, index());
                    exception = OpenSearchException.fromXContent(parser);
        shardTarget = in.readOptionalWriteable(SearchShardTarget::new);
 *     http://www.apache.org/licenses/LICENSE-2.0
            } else if (token.isValue()) {
    public static final ShardSearchFailure[] EMPTY_ARRAY = new ShardSearchFailure[0];
    }
 */
/*
import org.opensearch.ExceptionsHelper;
    public void writeTo(StreamOutput out) throws IOException {
                } else if (NODE_FIELD.equals(currentFieldName)) {
    private ShardSearchFailure(final Exception e, final Throwable unwrappedCause, @Nullable SearchShardTarget shardTarget) {
                    int indexOf = indexName.indexOf(RemoteClusterAware.REMOTE_CLUSTER_INDEX_SEPARATOR);
    public SearchShardTarget shard() {
                if (SHARD_FIELD.equals(currentFieldName)) {
        reason = in.readString();
import org.opensearch.core.index.Index;
            }
    }
import org.opensearch.core.xcontent.XContentBuilder;
    public static ShardSearchFailure readShardSearchFailure(StreamInput in) throws IOException {
                clusterAlias,
        String currentFieldName = null;
 * Unless required by applicable law or agreed to in writing,
        this(e, null);
    /**
        builder.endObject();
        return "shard ["
                parser.skipChildren();
        }
            + reason
package org.opensearch.action.search;
import org.opensearch.cluster.metadata.IndexMetadata;
            searchShardTarget = new SearchShardTarget(
        int shardId = -1;
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                new ShardId(new Index(indexName, IndexMetadata.INDEX_UUID_NA_VALUE), shardId),
            builder.field(REASON_FIELD);
        if (nodeId != null) {
        SearchShardTarget searchShardTarget = null;
 * the Apache License, Version 2.0 (the "License"); you may
            builder.field(SHARD_FIELD, shardId());
