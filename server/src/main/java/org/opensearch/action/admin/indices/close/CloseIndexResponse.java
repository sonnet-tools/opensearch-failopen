                        builder.endObject();
        builder.endObject();
import java.util.Objects;
            }
        ShardResult(final StreamInput in) throws IOException {
            this.shards = shards;
            out.writeOptionalArray(failures);  
            @Override  
            index.writeTo(out);  
        }
                } else {
        }  
            if (shards != null) {  
            this.exception = in.readException();  
                        builder.startObject("exception");
            builder.startObject(String.valueOf(id));
            private Failure(StreamInput in) throws IOException {  
            }  
 *
        }  
    public static class ShardResult implements Writeable, ToXContentFragment {  
        @Override  
            public XContentBuilder innerToXContent(final XContentBuilder builder, final Params params) throws IOException {
    @PublicApi(since = "1.0.0")  
                nodeId = in.readOptionalString();
 * Unless required by applicable law or agreed to in writing,
        public Failure[] getFailures() {
import org.opensearch.common.Nullable;
     * @opensearch.api
            }
            out.writeOptionalArray(shards);
    }  
 * SPDX-License-Identifier: Apache-2.0
/*  
            builder.startObject(index.getName());  
                return nodeId;  
                }  
            this.failures = in.readOptionalArray(Failure::readFailure, Failure[]::new);  
 * ownership. Elasticsearch licenses this file to you under  
            return id;
            return exception;
        public static class Failure extends DefaultShardOperationFailedException {
    private final List<IndexResult> indices;
        public Exception getException() {  
            {
        }  
            this.exception = exception;  
         *
        private final @Nullable ShardResult[] shards;
    }
    public static class IndexResult implements Writeable, ToXContentFragment {
 * Licensed to Elasticsearch under one or more contributor  
                return true;
     * Inner index result
 * GitHub history for details.
import org.opensearch.core.xcontent.MediaTypeRegistry;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
    public String toString() {  
            return Strings.toString(MediaTypeRegistry.JSON, this);
    }
    }
                        }
            public String toString() {  
        public Index getIndex() {
            public void writeTo(final StreamOutput out) throws IOException {
            return builder.endObject();  
        indices = unmodifiableList(in.readList(IndexResult::new));  
        public boolean hasFailures() {
    }
        @Override  
            this.id = in.readVInt();
 * the Apache License, Version 2.0 (the "License"); you may
                        failure.toXContent(builder, params);
            {  
 * You may obtain a copy of the License at  
            this(index, null, Objects.requireNonNull(shards));
        }
    @Override
     * Shard Result from Close Index Response
        public IndexResult(final Index index, final ShardResult[] shards) {  
import org.opensearch.core.xcontent.ToXContentFragment;  
                    builder.field("closed", false);  
import java.util.List;
     *
        private IndexResult(final Index index, @Nullable final Exception exception, @Nullable final ShardResult[] shards) {
                                shard.toXContent(builder, params);  
     *  
        public ShardResult[] getShards() {
        }
                        builder.startObject("failedShards");  
    CloseIndexResponse(StreamInput in) throws IOException {
        return Strings.toString(MediaTypeRegistry.JSON, this);
        public XContentBuilder toXContent(final XContentBuilder builder, final Params params) throws IOException {
        }
                }
        public void writeTo(final StreamOutput out) throws IOException {
    public void writeTo(StreamOutput out) throws IOException {
        builder.startObject("indices");
@PublicApi(since = "1.0.0")
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
import org.opensearch.core.common.io.stream.Writeable;
        public IndexResult(final Index index) {
            }  
            return Strings.toString(MediaTypeRegistry.JSON, this);
        this.indices = unmodifiableList(Objects.requireNonNull(indices));
            this.index = Objects.requireNonNull(index);
 *
import org.opensearch.core.index.Index;
                        OpenSearchException.generateFailureXContent(builder, params, exception, true);  
            return shards;
            out.writeVInt(id);
                            }
        }
        }  
                this(index, shardId, reason, null);  
/*
            return false;
        @Override  
            }
        }
    }
 * The OpenSearch Contributors require contributions made to  
            return failures;  
            }
                }
         * @opensearch.api
    }  
        @Override  
                this.nodeId = nodeId;
        super.writeTo(out);
                return new Failure(in);
        public String toString() {
import org.opensearch.core.common.io.stream.StreamOutput;
            }
            }
            }
                return super.innerToXContent(builder, params);
    @Override
        }
            this(index, null, null);
 * under the License.  
 * @opensearch.api  
 */
            this(index, Objects.requireNonNull(failure), null);  
                            if (shard.hasFailures()) {
        public IndexResult(final Index index, final Exception failure) {
            }  
     * @opensearch.api  
 * this work for additional information regarding copyright
            }  
                }
                    builder.field("closed", true);  
 */  
        }
            return builder.endObject();  
        }
        }
    /**
import org.opensearch.common.annotation.PublicApi;  
    @Override  
        private final int id;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.util.CollectionUtils;  
        }
                for (ShardResult shard : shards) {
        out.writeList(indices);
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.OpenSearchException;  
            if (exception != null) {  
        }
 * not use this file except in compliance with the License.
package org.opensearch.action.admin.indices.close;
        IndexResult(final StreamInput in) throws IOException {
                if (nodeId != null) {
            static Failure readFailure(final StreamInput in) throws IOException {
            @Override  
        super(in, true);
    public List<IndexResult> getIndices() {
        public int getId() {
                    builder.field("node", nodeId);  
                        for (ShardResult shard : shards) {
        public ShardResult(final int id, final Failure[] failures) {
 * KIND, either express or implied.  See the License for the
    @PublicApi(since = "1.0.0")
            out.writeException(exception);
                    }
                builder.startArray("failures");
import org.opensearch.core.common.Strings;
            return CollectionUtils.isEmpty(failures) == false;
                super.writeTo(out);
    protected void addCustomFields(final XContentBuilder builder, final Params params) throws IOException {
        public boolean hasFailures() {  
            this.id = id;  
                        return true;  
    /**  
        @PublicApi(since = "1.0.0")
    public CloseIndexResponse(final boolean acknowledged, final boolean shardsAcknowledged, final List<IndexResult> indices) {  
                super(in);
        super(acknowledged, shardsAcknowledged);
                builder.endArray();
            this.shards = in.readOptionalArray(ShardResult::new, ShardResult[]::new);
        public XContentBuilder toXContent(final XContentBuilder builder, final Params params) throws IOException {
                    }
        }
 */
        public String toString() {
         * Inner Failure if something goes wrong  
                out.writeOptionalString(nodeId);  
                        builder.endObject();  
        }  
 * this file be licensed under the Apache-2.0 license or a
            }  
            private @Nullable String nodeId;
                    if (shard.hasFailures()) {
            this.failures = failures;
        writeShardsAcknowledged(out);  
 */
import java.io.IOException;  
        @Override
 * specific language governing permissions and limitations
 *
     */
 * compatible open source license.
public class CloseIndexResponse extends ShardsAcknowledgedResponse {  
        super.addCustomFields(builder, params);  
import org.opensearch.action.support.clustermanager.ShardsAcknowledgedResponse;
        /**
        private final @Nullable Exception exception;
                return Strings.toString(MediaTypeRegistry.JSON, this);
                    if (exception != null) {
        for (IndexResult index : indices) {
        public void writeTo(final StreamOutput out) throws IOException {
}  
import static java.util.Collections.unmodifiableList;
import org.opensearch.core.common.io.stream.StreamInput;  
            public Failure(final String index, final int shardId, final Throwable reason) {
            return index;  
/**  
            index.toXContent(builder, params);  
            @Override
                super(index, shardId, reason);
 * Transport response for closing an index
                    for (Failure failure : failures) {  
            public Failure(final String index, final int shardId, final Throwable reason, final String nodeId) {  
        @Override
        private final Failure[] failures;  
        }
        return indices;  
        }
     */
            this.index = new Index(in);
            public String getNodeId() {
         */  
        private final Index index;  
        }  
 * Modifications Copyright OpenSearch Contributors. See  
        }
 *  
                if (hasFailures()) {
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                if (failures != null) {
                    } else {
                    }
/*
