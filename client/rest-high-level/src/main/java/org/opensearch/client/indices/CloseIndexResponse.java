 * compatible open source license.
                assert (boolean) args[0];  
        public @Nullable Exception getException() {
            this(index, null, Objects.requireNonNull(shards));  
    public static class IndexResult {
 * specific language governing permissions and limitations
                arg -> new Failure((String) arg[0], (int) arg[1], (Throwable) arg[2], (String) arg[3])
        IndexResult(final String index) {  
            this.exception = exception;
 * KIND, either express or implied.  See the License for the
            return shards;  
    @SuppressWarnings("unchecked")
        IndexResult(final String index, final Exception failure) {
        "close_index_response",  
    static {
            return failures != null && failures.length > 0;
                return nodeId;
        }
        );
 * Licensed to Elasticsearch under one or more contributor  
            this.index = Objects.requireNonNull(index);
 *
        }  
                this.nodeId = nodeId;
        public @Nullable ShardResult[] getShards() {
            static {
        }  
            boolean acknowledged = (boolean) args[0];  
            (args, index) -> {
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
            }
            PARSER.declareObject(optionalConstructorArg(), (p, c) -> {  
        }  
import org.opensearch.core.xcontent.ConstructingObjectParser;
                true,  
public class CloseIndexResponse extends ShardsAcknowledgedResponse {
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
            List<CloseIndexResponse.IndexResult> indices = args[2] != null ? (List<CloseIndexResponse.IndexResult>) args[2] : emptyList();
            if (exception != null) {
            this(index, Objects.requireNonNull(failure), null);
        }
 * SPDX-License-Identifier: Apache-2.0
            true,  
 * The OpenSearch Contributors require contributions made to  
        public int getId() {
 * this file be licensed under the Apache-2.0 license or a
    }
            this.failures = failures;
import org.opensearch.core.ParseField;  
 * under the License.  
            }
            }  
            return index;
                return new ShardResult(Integer.parseInt(id), failures);  
        }  
        private static final ConstructingObjectParser<ShardResult, String> PARSER = new ConstructingObjectParser<>(
                XContentParserUtils.ensureExpectedToken(XContentParser.Token.END_OBJECT, p.nextToken(), p);
                "failure",
        }  
        private final int id;
        public String getIndex() {  
                return e;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        public boolean hasFailures() {
    );
            boolean shardsAcknowledged = args[1] != null ? (boolean) args[1] : acknowledged;
        @SuppressWarnings("unchecked")  
        private IndexResult(final String index, @Nullable final Exception exception, @Nullable final ShardResult[] shards) {  
            (arg, id) -> {
        PARSER.declareField(optionalConstructorArg(), (parser, context) -> parser.booleanValue(), SHARDS_ACKNOWLEDGED, ValueType.BOOLEAN);  
package org.opensearch.client.indices;
        private final @Nullable Exception exception;  
                }
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
import org.opensearch.core.xcontent.XContentParser;  
                for (ShardResult shard : shards) {
            this.shards = shards;  
        }
import java.util.List;  
                    }
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See  
            PARSER.declareObjectArray(optionalConstructorArg(), (p, c) -> Failure.PARSER.apply(p, null), new ParseField("failures"));
        }
        static {
            PARSER.declareBoolean(optionalConstructorArg(), new ParseField("closed"));
                Exception exception = (Exception) args[1];
 * this work for additional information regarding copyright
                }  
    public static CloseIndexResponse fromXContent(final XContentParser parser) {  
        public boolean hasFailures() {  
                optionalConstructorArg(),
        }
    private final List<CloseIndexResponse.IndexResult> indices;
 * Unless required by applicable law or agreed to in writing,
                PARSER.declareStringOrNull(optionalConstructorArg(), new ParseField("node"));  
 */  
            return id;  
import org.opensearch.action.support.clustermanager.ShardsAcknowledgedResponse;
        IndexResult(final String index, final ShardResult[] shards) {
import static java.util.Collections.emptyList;  
 */
                    return new IndexResult(index, exception);
        }
            }, new ParseField("exception"));  
/*
        return indices;  
    public CloseIndexResponse(final boolean acknowledged, final boolean shardsAcknowledged, final List<IndexResult> indices) {  
                declareFields(PARSER);
        static IndexResult fromXContent(final XContentParser parser, final String name) {
import org.opensearch.core.xcontent.XContentParserUtils;
    }
        }
import static org.opensearch.core.xcontent.ObjectParser.ValueType;  
            }  
            return new CloseIndexResponse(acknowledged, shardsAcknowledged, indices);  
            this(index, null, null);
        @SuppressWarnings("unchecked")  
        }  
            if (shards != null) {
        }
        declareAcknowledgedField(PARSER);
            static final ConstructingObjectParser<Failure, Void> PARSER = new ConstructingObjectParser<>(
                    assert (boolean) args[0] == false;
        private final @Nullable ShardResult[] shards;
 *  
            Failure(final String index, final int shardId, final Throwable reason, final String nodeId) {
    private static final ConstructingObjectParser<CloseIndexResponse, Void> PARSER = new ConstructingObjectParser<>(
 */
 * license agreements. See the NOTICE file distributed with
/*
    }  
        args -> {
                Exception e = OpenSearchException.failureFromXContent(p);  
        true,
            return failures;
            return PARSER.apply(parser, name);  
        static ShardResult fromXContent(final XContentParser parser, final String id) {
        super(acknowledged, shardsAcknowledged);
                        return true;
                (p, c, id) -> ShardResult.fromXContent(p, id),  
        }
        public static class Failure extends DefaultShardOperationFailedException {
                    assert (boolean) args[0] == false;  
        return PARSER.apply(parser, null);
                new ParseField("failedShards")
                super(index, shardId, reason);  
        }  
        }
                XContentParserUtils.ensureExpectedToken(XContentParser.Token.FIELD_NAME, p.nextToken(), p);
                ShardResult[] shardResults = args[2] != null ? ((List<ShardResult>) args[2]).toArray(new ShardResult[0]) : null;
            true,  
            }
    }
 * You may obtain a copy of the License at  
            }
    public List<IndexResult> getIndices() {
 * ownership. Elasticsearch licenses this file to you under  
                XContentParserUtils.ensureExpectedToken(XContentParser.Token.START_OBJECT, p.currentToken(), p);
        static {
            );
    }
        PARSER.declareNamedObjects(optionalConstructorArg(), (p, c, name) -> IndexResult.fromXContent(p, name), new ParseField("indices"));
 *
 * the Apache License, Version 2.0 (the "License"); you may
        ShardResult(final int id, final Failure[] failures) {
                if (exception != null) {  
                return new IndexResult(index);
        private static final ConstructingObjectParser<IndexResult, String> PARSER = new ConstructingObjectParser<>(
            "index_result",
            );
            return exception;
import org.opensearch.common.Nullable;
        private final Failure[] failures;  
 * not use this file except in compliance with the License.
        private final String index;
                    return new IndexResult(index, shardResults);
                if (shardResults != null) {
        );  
            }
            this.id = id;  
            return false;
        public Failure[] getFailures() {  
/*  
    }
                return true;
}  
import java.util.Objects;
    public static class ShardResult {
            private @Nullable String nodeId;  
import static java.util.Collections.unmodifiableList;
            "shard_result",
        this.indices = unmodifiableList(Objects.requireNonNull(indices));
                    if (shard.hasFailures()) {  
            PARSER.declareNamedObjects(
 * software distributed under the License is distributed on an
                Failure[] failures = arg[0] != null ? ((List<Failure>) arg[0]).toArray(new Failure[0]) : new Failure[0];
            public String getNodeId() {
import org.opensearch.OpenSearchException;  
            return PARSER.apply(parser, id);
                }  
