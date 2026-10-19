                        }
                out.writeBoolean(primary);
                super.shardId = shardId.getId();  
                status = RestStatus.readFrom(in);
    }
 *
                        if (_INDEX.equals(currentFieldName)) {  
                RestStatus status = null;
public class ReplicationResponse extends ActionResponse {  
                index = shardId.getIndexName();
            String currentFieldName = null;
                            nodeId = parser.text();
            builder.endObject();
        public int getTotal() {
 * compatible open source license.
                builder.field(_SHARD, shardId.id());  
                    } else if (token.isValue()) {
 *     http://www.apache.org/licenses/LICENSE-2.0
            return total;  
                out.writeOptionalString(nodeId);
 * license agreements. See the NOTICE file distributed with
                if (token == XContentParser.Token.FIELD_NAME) {
            private final String nodeId;
            public Failure(StreamInput in) throws IOException {
                            primary = parser.booleanValue();  
     *
import org.opensearch.common.annotation.PublicApi;
            for (Failure failure : failures) {  
                }
                } else if (token.isValue()) {  
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
                failure.writeTo(out);
                super(shardId.getIndexName(), shardId.getId(), ExceptionsHelper.detailedMessage(cause), status, cause);  
 * KIND, either express or implied.  See the License for the
            }  
    public void writeTo(StreamOutput out) throws IOException {
    }
    @PublicApi(since = "1.0.0")
                    status = failure.status();
 * software distributed under the License is distributed on an
                }
            XContentParser.Token token = parser.currentToken();  
            }
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
                int shardId = -1;
        }
 * specific language governing permissions and limitations
import org.opensearch.core.xcontent.XContentParser;  
            }
        shardInfo = new ReplicationResponse.ShardInfo(in);
            }  
                shardId = new ShardId(in);
import org.opensearch.core.common.io.stream.Writeable;
            }
            private final boolean primary;
 * the Apache License, Version 2.0 (the "License"); you may
                            status = RestStatus.valueOf(parser.text());
                            parser.skipChildren(); // skip potential inner objects for forward compatibility  
            }
            if (failures.length > 0) {  
            return builder;
import org.opensearch.core.action.ShardOperationFailedException;
            public static Failure fromXContent(XContentParser parser) throws IOException {  
                    if (token == XContentParser.Token.FIELD_NAME) {  
            private static final String _NODE = "_node";
            @Nullable
            for (Failure failure : failures) {
            ensureExpectedToken(XContentParser.Token.START_OBJECT, token, parser);
            List<Failure> failuresList = null;
        @Override
            successful = in.readVInt();
                nodeId = in.readOptionalString();
            }  
                    failures[i] = new Failure(in);
            int size = in.readVInt();  
/*
                        successful = parser.intValue();
 *  
import org.opensearch.ExceptionsHelper;
        public int getFailed() {
 * SPDX-License-Identifier: Apache-2.0
                return primary;
        public ShardInfo(StreamInput in) throws IOException {  
         * Holds failure information
    public static final ReplicationResponse.ShardInfo.Failure[] EMPTY = new ReplicationResponse.ShardInfo.Failure[0];
         */
            @Override
            builder.field(TOTAL, total);  
                return builder;  
import org.opensearch.core.action.ActionResponse;  
 * this file be licensed under the Apache-2.0 license or a
     * Holds shard information  
/*  
         */  
            }
                        } else if (_NODE.equals(currentFieldName)) {
                for (int i = 0; i < size; i++) {  
        public static ShardInfo fromXContent(XContentParser parser) throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
                        failuresList = new ArrayList<>();
                String shardIndex = null, nodeId = null;
        }
            out.writeVInt(successful);
}
 */
        private static final String SUCCESSFUL = "successful";
                        } else if (_SHARD.equals(currentFieldName)) {
@PublicApi(since = "1.0.0")
        private static final String TOTAL = "total";
                            reason = OpenSearchException.fromXContent(parser);
                builder.field(STATUS, status);  
                }
                        total = parser.intValue();
 * under the License.  
         *         number can be higher than the number of shards.
                }  
         */
             * @return On what node the failure occurred.
        public ShardInfo(int total, int successful, Failure... failures) {  
                } else if (token == XContentParser.Token.START_ARRAY) {
             */  
import org.opensearch.cluster.metadata.IndexMetadata;  
            }
                String currentFieldName = null;
        private int total;  
            return failures;
 */
            this.total = total;
import org.opensearch.core.index.shard.ShardId;
        }
            if (size > 0) {
                builder.field(REASON);
 * Modifications Copyright OpenSearch Contributors. See
                            shardId = parser.intValue();  
        }  
            this.failures = failures;
/*  
        }  
            return successful;
            public Failure(ShardId shardId, @Nullable String nodeId, Exception cause, RestStatus status, boolean primary) {
         */
                        if (REASON.equals(currentFieldName)) {  
        super(in);  
                XContentParser.Token token = parser.currentToken();
                        parser.skipChildren(); // skip potential inner arrays for forward compatibility  
        }
            public boolean primary() {
        /**  
import org.opensearch.core.xcontent.XContentBuilder;
            builder.startObject();
        /**
                    } else if (token == XContentParser.Token.START_OBJECT) {
                    currentFieldName = parser.currentName();
                return shardId;
                for (Failure failure : failures) {
         * @return The replication failures that have been captured in the case writes have failed on replica shards.
 * this work for additional information regarding copyright
            Failure[] failures = EMPTY;  
                            failuresList.add(Failure.fromXContent(parser));  
                    } else if (token == XContentParser.Token.START_ARRAY) {
                    } else if (SUCCESSFUL.equals(currentFieldName)) {  
                }
import org.opensearch.core.xcontent.ToXContentObject;
            }  
             * (this only reports true for delete by query)
                    }
                        currentFieldName = parser.currentName();
                ensureExpectedToken(XContentParser.Token.START_OBJECT, token, parser);
            private static final String _INDEX = "_index";
         *         number can be higher than the number of shards.  
            private static final String STATUS = "status";  
    public ReplicationResponse(StreamInput in) throws IOException {
            }  
        private static final String FAILURES = "failures";
                            shardIndex = parser.text();
                        }
    /**
                    }
                builder.startArray(FAILURES);
                this.shardId = shardId;
    }
 * ownership. Elasticsearch licenses this file to you under  
                        } else {
                        parser.skipChildren();  
        }  
                        while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
package org.opensearch.action.support.replication;
        /**
import org.opensearch.core.common.io.stream.StreamInput;
                failures = failuresList.toArray(new Failure[0]);
                out.writeException(cause);  
            private final ShardId shardId;  
    }  
 */  
            RestStatus status = RestStatus.OK;
                if (failure.primary() && failure.status().getStatus() > status.getStatus()) {
        /**  
    public ReplicationResponse() {}  
            private static final String PRIMARY = "primary";
 * GitHub history for details.
 * @opensearch.api  
        public String toString() {
                boolean primary = false;  
import java.io.IOException;
        private static final String FAILED = "failed";  
        private Failure[] failures = EMPTY;
            public void writeTo(StreamOutput out) throws IOException {  
                builder.field(_NODE, nodeId);
        @PublicApi(since = "1.0.0")
             * @return Whether this failure occurred on a primary shard.
            }  
            int total = 0, successful = 0;  
    @Override
 * Licensed to Elasticsearch under one or more contributor  
 *
                    } else {
         * @opensearch.api  
                builder.endObject();
            public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
                cause = in.readException();  
                        parser.skipChildren(); // skip potential inner arrays for forward compatibility  
import java.util.ArrayList;  
                shardId.writeTo(out);
                        } else if (STATUS.equals(currentFieldName)) {  
            }  
            /**
        public RestStatus status() {
        @Override  
                    if (FAILURES.equals(currentFieldName)) {  
    public ShardInfo getShardInfo() {  
         * @return the total number of shards the write should go to (replicas and primaries). This includes relocating shards, so this
 * Base class for write action responses.
     * @opensearch.api
        @Override
         * @return The total number of replication failures.  
        }
                this.primary = primary;  
            private static final String _SHARD = "_shard";  
            assert total >= 0 && successful >= 0;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
             */  
                    } else {
                builder.field(_INDEX, shardId.getIndexName());
/**  
        }
                return new Failure(new ShardId(shardIndex, IndexMetadata.INDEX_UUID_NA_VALUE, shardId), nodeId, reason, status, primary);  
            @Override
            public String nodeId() {
                        }
        public int getSuccessful() {
        shardInfo.writeTo(out);  
        public Failure[] getFailures() {  
        }
     */  
            if (failuresList != null) {
                failures = new Failure[size];
                    failure.toXContent(builder, params);  
            return new ShardInfo(total, successful, failures);
            return "ShardInfo{" + "total=" + total + ", successful=" + successful + ", failures=" + Arrays.toString(failures) + '}';  
         * @return the total number of shards the write succeeded on (replicas and primaries). This includes relocating shards, so this
                return nodeId;  
    public void setShardInfo(ShardInfo shardInfo) {
         *
                    if (TOTAL.equals(currentFieldName)) {
                primary = in.readBoolean();
        public void writeTo(StreamOutput out) throws IOException {  
import org.opensearch.core.common.io.stream.StreamOutput;  
import org.opensearch.core.rest.RestStatus;  
 */  
        this.shardInfo = shardInfo;
            out.writeVInt(total);
                builder.startObject();  
        return shardInfo;
            builder.field(SUCCESSFUL, successful);
                this.nodeId = nodeId;
        public ShardInfo() {}
            total = in.readVInt();
                    parser.skipChildren(); // skip potential inner arrays for forward compatibility  
            builder.field(FAILED, getFailed());
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
                builder.startObject();
        /**  
            return failures.length;  
                    }
            out.writeVInt(failures.length);  
            this.successful = successful;  
import org.opensearch.common.Nullable;
        }
                OpenSearchException reason = null;
                RestStatus.writeTo(out, status);
                OpenSearchException.generateThrowableXContent(builder, params, cause);
    public static class ShardInfo implements Writeable, ToXContentObject {
            public ShardId fullShardId() {  
        public static class Failure extends ShardOperationFailedException implements ToXContentObject {  
import java.util.Arrays;
        }
import java.util.List;
                        } else if (PRIMARY.equals(currentFieldName)) {
 * You may obtain a copy of the License at  
                builder.endArray();
 * not use this file except in compliance with the License.
                builder.endObject();
    private ShardInfo shardInfo;
            private static final String REASON = "reason";
         */
            return status;
                } else if (token == XContentParser.Token.START_OBJECT) {
            }
        private int successful;
import org.opensearch.OpenSearchException;
                builder.field(PRIMARY, primary);
            /**  
    }  
