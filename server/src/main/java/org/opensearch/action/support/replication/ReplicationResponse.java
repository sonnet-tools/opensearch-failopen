/*
            public static Failure fromXContent(XContentParser parser) throws IOException {
        }
            }
         */
        }
                builder.endObject();
         */
            }
         */
            private static final String _INDEX = "_index";
        }
    public static final ReplicationResponse.ShardInfo.Failure[] EMPTY = new ReplicationResponse.ShardInfo.Failure[0];
    public ShardInfo getShardInfo() {
                failures = failuresList.toArray(new Failure[0]);
            }
        public static ShardInfo fromXContent(XContentParser parser) throws IOException {
        private static final String TOTAL = "total";
 *     http://www.apache.org/licenses/LICENSE-2.0
                builder.field(_NODE, nodeId);
    private ShardInfo shardInfo;
                            shardIndex = parser.text();
        }
        return shardInfo;
                        } else if (_NODE.equals(currentFieldName)) {
            }
        public RestStatus status() {
         * @return The replication failures that have been captured in the case writes have failed on replica shards.
            RestStatus status = RestStatus.OK;
         *         number can be higher than the number of shards.
import org.opensearch.core.xcontent.ToXContentObject;
    }
            XContentParser.Token token = parser.currentToken();
                            parser.skipChildren(); // skip potential inner objects for forward compatibility
     * @opensearch.api
            public ShardId fullShardId() {
            public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                    if (FAILURES.equals(currentFieldName)) {
                            reason = OpenSearchException.fromXContent(parser);
        private static final String SUCCESSFUL = "successful";
 * Base class for write action responses.
         *         number can be higher than the number of shards.
            total = in.readVInt();
            }
    }
            assert total >= 0 && successful >= 0;
         */
                return builder;
        @Override
     * Holds shard information
                            nodeId = parser.text();
                    } else if (token == XContentParser.Token.START_OBJECT) {
            private static final String REASON = "reason";
        public Failure[] getFailures() {
            builder.endObject();
                    status = failure.status();
import org.opensearch.core.xcontent.XContentBuilder;
                shardId.writeTo(out);
                    } else {
 */
                }
                        total = parser.intValue();
                RestStatus.writeTo(out, status);
    public void setShardInfo(ShardInfo shardInfo) {
                            failuresList.add(Failure.fromXContent(parser));
                    } else {
     *
                this.nodeId = nodeId;
    }
                        failuresList = new ArrayList<>();
            return total;
                RestStatus status = null;
        public int getSuccessful() {
            @Override
        }
                builder.startObject();
         * @return The total number of replication failures.
            }
import org.opensearch.common.annotation.PublicApi;
            this.successful = successful;
                    currentFieldName = parser.currentName();
            List<Failure> failuresList = null;
 * Modifications Copyright OpenSearch Contributors. See
            public Failure(StreamInput in) throws IOException {
            builder.startObject();
             * @return Whether this failure occurred on a primary shard.
                index = shardId.getIndexName();
                    } else if (token.isValue()) {
        }
    }
 * @opensearch.api
                failures = new Failure[size];
                        } else if (STATUS.equals(currentFieldName)) {
                status = RestStatus.readFrom(in);
        }
                super(shardId.getIndexName(), shardId.getId(), ExceptionsHelper.detailedMessage(cause), status, cause);
 *
                ensureExpectedToken(XContentParser.Token.START_OBJECT, token, parser);
            /**
                return shardId;
            private final ShardId shardId;
            public String nodeId() {
            public boolean primary() {
            builder.field(TOTAL, total);
            for (Failure failure : failures) {
                        parser.skipChildren(); // skip potential inner arrays for forward compatibility
 * SPDX-License-Identifier: Apache-2.0
                } else if (token == XContentParser.Token.START_ARRAY) {
                return primary;
                    }
import org.opensearch.core.action.ShardOperationFailedException;
                builder.field(_INDEX, shardId.getIndexName());
    public ReplicationResponse() {}
                primary = in.readBoolean();
 * this file be licensed under the Apache-2.0 license or a
        private static final String FAILED = "failed";
    public void writeTo(StreamOutput out) throws IOException {
                        parser.skipChildren();
import org.opensearch.core.common.io.stream.StreamOutput;
        /**
 * You may obtain a copy of the License at
                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    @PublicApi(since = "1.0.0")
 * GitHub history for details.
/*
        private int successful;
}
            if (failuresList != null) {
                if (failure.primary() && failure.status().getStatus() > status.getStatus()) {
                        }
                } else if (token == XContentParser.Token.START_OBJECT) {
                }
                            status = RestStatus.valueOf(parser.text());
                        }
                        } else {
             * @return On what node the failure occurred.
                    }
public class ReplicationResponse extends ActionResponse {
import org.opensearch.core.rest.RestStatus;
                for (int i = 0; i < size; i++) {
            private final String nodeId;
        private static final String FAILURES = "failures";
            ensureExpectedToken(XContentParser.Token.START_OBJECT, token, parser);
                    failures[i] = new Failure(in);
                boolean primary = false;
             */
                builder.startArray(FAILURES);
        public static class Failure extends ShardOperationFailedException implements ToXContentObject {
                builder.field(_SHARD, shardId.id());
        shardInfo = new ReplicationResponse.ShardInfo(in);
            int size = in.readVInt();
        super(in);
                XContentParser.Token token = parser.currentToken();
            @Override
                        if (_INDEX.equals(currentFieldName)) {
        }
            return failures.length;
import org.opensearch.core.index.shard.ShardId;
                nodeId = in.readOptionalString();
            }
        @PublicApi(since = "1.0.0")
                        if (REASON.equals(currentFieldName)) {
            /**
     */
                out.writeBoolean(primary);
        @Override
 */
                failure.writeTo(out);
import org.opensearch.OpenSearchException;
            public Failure(ShardId shardId, @Nullable String nodeId, Exception cause, RestStatus status, boolean primary) {
            private static final String PRIMARY = "primary";
            }
 *
                }
        public ShardInfo(int total, int successful, Failure... failures) {
 * KIND, either express or implied.  See the License for the
    /**
 * license agreements. See the NOTICE file distributed with
            }
 * this work for additional information regarding copyright
    public ReplicationResponse(StreamInput in) throws IOException {
                out.writeException(cause);
        public ShardInfo() {}
                    if (token == XContentParser.Token.FIELD_NAME) {
                return new Failure(new ShardId(shardIndex, IndexMetadata.INDEX_UUID_NA_VALUE, shardId), nodeId, reason, status, primary);
            private static final String _SHARD = "_shard";
 * Licensed to Elasticsearch under one or more contributor
        /**
    @Override
                            primary = parser.booleanValue();
            this.failures = failures;
                    }
import org.opensearch.ExceptionsHelper;
         *
 * software distributed under the License is distributed on an
                builder.field(REASON);
            Failure[] failures = EMPTY;
            }
            }
 * Unless required by applicable law or agreed to in writing,
         * @return the total number of shards the write should go to (replicas and primaries). This includes relocating shards, so this
                cause = in.readException();
            }
        public ShardInfo(StreamInput in) throws IOException {
import org.opensearch.core.action.ActionResponse;
            return "ShardInfo{" + "total=" + total + ", successful=" + successful + ", failures=" + Arrays.toString(failures) + '}';
import java.util.ArrayList;
             */
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                this.primary = primary;
        }
        }
        public int getTotal() {
import java.util.List;
                        currentFieldName = parser.currentName();
        }
 */
                if (token == XContentParser.Token.FIELD_NAME) {
                    } else if (SUCCESSFUL.equals(currentFieldName)) {
            return failures;
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.action.support.replication;
                    if (TOTAL.equals(currentFieldName)) {
         * @opensearch.api
/*
            out.writeVInt(failures.length);
        this.shardInfo = shardInfo;
                for (Failure failure : failures) {
 * compatible open source license.
/**
        public int getFailed() {
        /**
import org.opensearch.core.xcontent.XContentParser;
                builder.endObject();
                    } else if (token == XContentParser.Token.START_ARRAY) {
            return new ShardInfo(total, successful, failures);
                super.shardId = shardId.getId();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                OpenSearchException.generateThrowableXContent(builder, params, cause);
import org.opensearch.common.Nullable;
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
            if (failures.length > 0) {
            return successful;
            builder.field(FAILED, getFailed());
            int total = 0, successful = 0;
                } else if (token.isValue()) {
 * The OpenSearch Contributors require contributions made to
        public String toString() {
            for (Failure failure : failures) {
                out.writeOptionalString(nodeId);
                }
 *
                }
                builder.endArray();
import org.opensearch.cluster.metadata.IndexMetadata;
                    parser.skipChildren(); // skip potential inner arrays for forward compatibility
            builder.field(SUCCESSFUL, successful);
                        successful = parser.intValue();
        private int total;
        shardInfo.writeTo(out);
         * Holds failure information
                    failure.toXContent(builder, params);
@PublicApi(since = "1.0.0")
                OpenSearchException reason = null;
 * ownership. Elasticsearch licenses this file to you under
         * @return the total number of shards the write succeeded on (replicas and primaries). This includes relocating shards, so this
            this.total = total;
        public void writeTo(StreamOutput out) throws IOException {
            private static final String STATUS = "status";
            public void writeTo(StreamOutput out) throws IOException {
                String shardIndex = null, nodeId = null;
             * (this only reports true for delete by query)
            if (size > 0) {
                String currentFieldName = null;
                builder.startObject();
        @Override
                        while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
                        } else if (_SHARD.equals(currentFieldName)) {
                return nodeId;
 *
            }
                builder.field(PRIMARY, primary);
    }
                        parser.skipChildren(); // skip potential inner arrays for forward compatibility
            return status;
import org.opensearch.core.common.io.stream.StreamInput;
 * specific language governing permissions and limitations
    public static class ShardInfo implements Writeable, ToXContentObject {
 * under the License.
            }
            private final boolean primary;
 */
         */
                int shardId = -1;
        }
            String currentFieldName = null;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                            shardId = parser.intValue();
        /**
            out.writeVInt(total);
import java.io.IOException;
 * not use this file except in compliance with the License.
            @Nullable
            out.writeVInt(successful);
import java.util.Arrays;
import org.opensearch.core.common.io.stream.Writeable;
                        }
            return builder;
            successful = in.readVInt();
                shardId = new ShardId(in);
            private static final String _NODE = "_node";
        private Failure[] failures = EMPTY;
                this.shardId = shardId;
        /**
                        } else if (PRIMARY.equals(currentFieldName)) {
                builder.field(STATUS, status);
