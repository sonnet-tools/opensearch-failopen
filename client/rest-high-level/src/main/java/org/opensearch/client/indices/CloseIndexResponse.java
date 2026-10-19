                }
            this.failures = failures;
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
        }
    public CloseIndexResponse(final boolean acknowledged, final boolean shardsAcknowledged, final List<IndexResult> indices) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        static IndexResult fromXContent(final XContentParser parser, final String name) {
            this(index, null, Objects.requireNonNull(shards));
            );
/*
                if (shardResults != null) {
        public @Nullable Exception getException() {
            return failures != null && failures.length > 0;
        private final Failure[] failures;
                ShardResult[] shardResults = args[2] != null ? ((List<ShardResult>) args[2]).toArray(new ShardResult[0]) : null;
                return e;
            }
                return nodeId;
            return new CloseIndexResponse(acknowledged, shardsAcknowledged, indices);
            static {
        IndexResult(final String index) {
            this.shards = shards;
        private final @Nullable ShardResult[] shards;
            boolean shardsAcknowledged = args[1] != null ? (boolean) args[1] : acknowledged;
        private final @Nullable Exception exception;
        private static final ConstructingObjectParser<IndexResult, String> PARSER = new ConstructingObjectParser<>(
                "failure",
 * The OpenSearch Contributors require contributions made to
                assert (boolean) args[0];
            }
                return new IndexResult(index);
    }
        return PARSER.apply(parser, null);
        public boolean hasFailures() {
    public static class IndexResult {
    @SuppressWarnings("unchecked")
        }
                optionalConstructorArg(),
        @SuppressWarnings("unchecked")
        public static class Failure extends DefaultShardOperationFailedException {
    }
            }, new ParseField("exception"));
        ShardResult(final int id, final Failure[] failures) {
        }
        IndexResult(final String index, final ShardResult[] shards) {
            }
                    assert (boolean) args[0] == false;
    );
            boolean acknowledged = (boolean) args[0];
    }
            return id;
        }
            true,
    }
                for (ShardResult shard : shards) {
        @SuppressWarnings("unchecked")
            );
            this.exception = exception;
        static {
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
        }
    public static CloseIndexResponse fromXContent(final XContentParser parser) {
 * the Apache License, Version 2.0 (the "License"); you may
            return exception;
        private final String index;
 * Modifications Copyright OpenSearch Contributors. See
        args -> {
                    assert (boolean) args[0] == false;
            static final ConstructingObjectParser<Failure, Void> PARSER = new ConstructingObjectParser<>(
            true,
        PARSER.declareNamedObjects(optionalConstructorArg(), (p, c, name) -> IndexResult.fromXContent(p, name), new ParseField("indices"));
        public Failure[] getFailures() {
        }
            List<CloseIndexResponse.IndexResult> indices = args[2] != null ? (List<CloseIndexResponse.IndexResult>) args[2] : emptyList();
 *
                super(index, shardId, reason);
    private static final ConstructingObjectParser<CloseIndexResponse, Void> PARSER = new ConstructingObjectParser<>(
/*
        public @Nullable ShardResult[] getShards() {
import org.opensearch.OpenSearchException;
import static java.util.Collections.emptyList;
}
                declareFields(PARSER);
 * specific language governing permissions and limitations
        }
                        return true;
        }
            }
        );
            return false;
 * software distributed under the License is distributed on an
        }
        true,
            this(index, Objects.requireNonNull(failure), null);
 * under the License.
            PARSER.declareObject(optionalConstructorArg(), (p, c) -> {
import org.opensearch.common.Nullable;
                true,
    public List<IndexResult> getIndices() {
                return new ShardResult(Integer.parseInt(id), failures);
 * SPDX-License-Identifier: Apache-2.0
        public String getIndex() {
        static {
        PARSER.declareField(optionalConstructorArg(), (parser, context) -> parser.booleanValue(), SHARDS_ACKNOWLEDGED, ValueType.BOOLEAN);
                }
 */
                    return new IndexResult(index, shardResults);
            return PARSER.apply(parser, name);
                return true;
import org.opensearch.core.ParseField;
import org.opensearch.core.xcontent.XContentParser;
    public static class ShardResult {
 * this work for additional information regarding copyright
    }
        );
            (arg, id) -> {
import org.opensearch.core.xcontent.ConstructingObjectParser;
        this.indices = unmodifiableList(Objects.requireNonNull(indices));
        }
            return PARSER.apply(parser, id);
public class CloseIndexResponse extends ShardsAcknowledgedResponse {
        return indices;
        private static final ConstructingObjectParser<ShardResult, String> PARSER = new ConstructingObjectParser<>(
                if (exception != null) {
            private @Nullable String nodeId;
            }
            (args, index) -> {
            this.id = id;
import java.util.Objects;
        private final int id;
                XContentParserUtils.ensureExpectedToken(XContentParser.Token.END_OBJECT, p.nextToken(), p);
            return shards;
        super(acknowledged, shardsAcknowledged);
            PARSER.declareNamedObjects(
        }
                arg -> new Failure((String) arg[0], (int) arg[1], (Throwable) arg[2], (String) arg[3])
        }
                    if (shard.hasFailures()) {
import static org.opensearch.core.xcontent.ObjectParser.ValueType;
 *
            }
        }
        }
            PARSER.declareObjectArray(optionalConstructorArg(), (p, c) -> Failure.PARSER.apply(p, null), new ParseField("failures"));
        }
            PARSER.declareBoolean(optionalConstructorArg(), new ParseField("closed"));
 * You may obtain a copy of the License at
    private final List<CloseIndexResponse.IndexResult> indices;
        static ShardResult fromXContent(final XContentParser parser, final String id) {
import static java.util.Collections.unmodifiableList;
                PARSER.declareStringOrNull(optionalConstructorArg(), new ParseField("node"));
                Failure[] failures = arg[0] != null ? ((List<Failure>) arg[0]).toArray(new Failure[0]) : new Failure[0];
                XContentParserUtils.ensureExpectedToken(XContentParser.Token.START_OBJECT, p.currentToken(), p);
 */
                this.nodeId = nodeId;
                    }
            Failure(final String index, final int shardId, final Throwable reason, final String nodeId) {
                Exception e = OpenSearchException.failureFromXContent(p);
import java.util.List;
    }
                new ParseField("failedShards")
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.action.support.clustermanager.ShardsAcknowledgedResponse;
            if (exception != null) {
package org.opensearch.client.indices;
 * ownership. Elasticsearch licenses this file to you under
                    return new IndexResult(index, exception);
        }
        declareAcknowledgedField(PARSER);
        private IndexResult(final String index, @Nullable final Exception exception, @Nullable final ShardResult[] shards) {
        public int getId() {
            this(index, null, null);
 * Licensed to Elasticsearch under one or more contributor
                (p, c, id) -> ShardResult.fromXContent(p, id),
            this.index = Objects.requireNonNull(index);
            "shard_result",
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                }
    static {
            }
 * license agreements. See the NOTICE file distributed with
            "index_result",
            return index;
            public String getNodeId() {
/*
            if (shards != null) {
        }
 * GitHub history for details.
        IndexResult(final String index, final Exception failure) {
        public boolean hasFailures() {
 *
import org.opensearch.core.xcontent.XContentParserUtils;
                Exception exception = (Exception) args[1];
            return failures;
 * not use this file except in compliance with the License.
 */
        }
        "close_index_response",
                XContentParserUtils.ensureExpectedToken(XContentParser.Token.FIELD_NAME, p.nextToken(), p);
