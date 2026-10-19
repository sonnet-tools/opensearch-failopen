 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
        }
                return new Failure(in);
        builder.endObject();
        public void writeTo(final StreamOutput out) throws IOException {
            }
        IndexResult(final StreamInput in) throws IOException {
                return true;
            index.toXContent(builder, params);
        }
    @PublicApi(since = "1.0.0")
            return builder.endObject();
        }
    }
            public String toString() {
            }
            }
                        OpenSearchException.generateFailureXContent(builder, params, exception, true);
        ShardResult(final StreamInput in) throws IOException {
            return shards;
 * software distributed under the License is distributed on an
 * under the License.
 * ownership. Elasticsearch licenses this file to you under
 * license agreements. See the NOTICE file distributed with
                        }
            @Override
        public String toString() {
        }
            if (exception != null) {
        public Index getIndex() {
        @Override
            this.shards = shards;
    public static class ShardResult implements Writeable, ToXContentFragment {
    }
            builder.startObject(index.getName());
        @Override
        public IndexResult(final Index index, final ShardResult[] shards) {
 * Licensed to Elasticsearch under one or more contributor
            out.writeException(exception);
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
            }
    /**
import java.util.List;
            this(index, null, null);
                super.writeTo(out);
        private final @Nullable ShardResult[] shards;
        public ShardResult(final int id, final Failure[] failures) {
                    if (exception != null) {
        }
            @Override
 * Transport response for closing an index
import org.opensearch.core.common.io.stream.Writeable;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            builder.startObject(String.valueOf(id));
    private final List<IndexResult> indices;
        }
                        failure.toXContent(builder, params);
            this.shards = in.readOptionalArray(ShardResult::new, ShardResult[]::new);
import org.opensearch.core.common.io.stream.StreamOutput;
 * SPDX-License-Identifier: Apache-2.0
    CloseIndexResponse(StreamInput in) throws IOException {
        public String toString() {
            public String getNodeId() {
            }
            return false;
                }
 */
            this(index, null, Objects.requireNonNull(shards));
    }
            public void writeTo(final StreamOutput out) throws IOException {
        return Strings.toString(MediaTypeRegistry.JSON, this);
            static Failure readFailure(final StreamInput in) throws IOException {
    public void writeTo(StreamOutput out) throws IOException {
                return super.innerToXContent(builder, params);
                if (nodeId != null) {
    }
                nodeId = in.readOptionalString();
     */
 * the Apache License, Version 2.0 (the "License"); you may
                } else {
            out.writeVInt(id);
        }
 * @opensearch.api
    public static class IndexResult implements Writeable, ToXContentFragment {
            @Override
        }
            this.id = in.readVInt();
        super(acknowledged, shardsAcknowledged);
    public CloseIndexResponse(final boolean acknowledged, final boolean shardsAcknowledged, final List<IndexResult> indices) {
            out.writeOptionalArray(failures);
        public IndexResult(final Index index, final Exception failure) {
        }
            return index;
        out.writeList(indices);
            return failures;
        @Override
            index.writeTo(out);
        builder.startObject("indices");
        @Override
        public XContentBuilder toXContent(final XContentBuilder builder, final Params params) throws IOException {
/*
                }
        super.addCustomFields(builder, params);
                        builder.endObject();
         */
     * Shard Result from Close Index Response
        return indices;
            }
            this.failures = in.readOptionalArray(Failure::readFailure, Failure[]::new);
import org.opensearch.core.common.io.stream.StreamInput;
         *
import org.opensearch.action.support.clustermanager.ShardsAcknowledgedResponse;
        }
        }
 * The OpenSearch Contributors require contributions made to
            }
            {
 *
/*
         * @opensearch.api
 * You may obtain a copy of the License at
    protected void addCustomFields(final XContentBuilder builder, final Params params) throws IOException {
    }
                    } else {
import org.opensearch.core.common.util.CollectionUtils;
 * Unless required by applicable law or agreed to in writing,
                }
            }
        @PublicApi(since = "1.0.0")
        writeShardsAcknowledged(out);
                super(in);
        }
import java.util.Objects;
 *
            return exception;
     * @opensearch.api
import org.opensearch.OpenSearchException;
        }
        private final Index index;
        }
    @Override
                                shard.toXContent(builder, params);
        }
            this.exception = exception;
 * this work for additional information regarding copyright
        public boolean hasFailures() {
        public XContentBuilder toXContent(final XContentBuilder builder, final Params params) throws IOException {
    /**
    public String toString() {
        public int getId() {
            return Strings.toString(MediaTypeRegistry.JSON, this);
            if (shards != null) {
     * @opensearch.api
            this.failures = failures;
    @Override
    public List<IndexResult> getIndices() {
            {
import org.opensearch.core.xcontent.ToXContentFragment;
 * Modifications Copyright OpenSearch Contributors. See
            private Failure(StreamInput in) throws IOException {
}
                        builder.startObject("exception");
                }
        /**
            this.id = id;
                super(index, shardId, reason);
        }
                    for (Failure failure : failures) {
        }
            this.exception = in.readException();
        public void writeTo(final StreamOutput out) throws IOException {
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.xcontent.MediaTypeRegistry;
     *
                return nodeId;
                        builder.startObject("failedShards");
            public Failure(final String index, final int shardId, final Throwable reason) {
                    builder.field("node", nodeId);
            public XContentBuilder innerToXContent(final XContentBuilder builder, final Params params) throws IOException {
            }
            public Failure(final String index, final int shardId, final Throwable reason, final String nodeId) {
            }
public class CloseIndexResponse extends ShardsAcknowledgedResponse {
                    }
                            }
        for (IndexResult index : indices) {
        private final @Nullable Exception exception;
        super(in, true);
        private final int id;
        this.indices = unmodifiableList(Objects.requireNonNull(indices));
            this(index, Objects.requireNonNull(failure), null);
                    }
                    builder.field("closed", true);
         * Inner Failure if something goes wrong
        public boolean hasFailures() {
        private IndexResult(final Index index, @Nullable final Exception exception, @Nullable final ShardResult[] shards) {
                    if (shard.hasFailures()) {
/**
        @Override
                        for (ShardResult shard : shards) {
     * Inner index result
        }
    }
        public static class Failure extends DefaultShardOperationFailedException {
            this.index = new Index(in);
                        builder.endObject();
 */
    @Override
            private @Nullable String nodeId;
                builder.endArray();
@PublicApi(since = "1.0.0")
                    builder.field("closed", false);
 * not use this file except in compliance with the License.
 * compatible open source license.
        private final Failure[] failures;
                if (failures != null) {
        public ShardResult[] getShards() {
        public IndexResult(final Index index) {
 * KIND, either express or implied.  See the License for the
                if (hasFailures()) {
import static java.util.Collections.unmodifiableList;
                return Strings.toString(MediaTypeRegistry.JSON, this);
 *
        }
            return id;
            }
 *
        super.writeTo(out);
import org.opensearch.common.annotation.PublicApi;
        indices = unmodifiableList(in.readList(IndexResult::new));
        }
            return CollectionUtils.isEmpty(failures) == false;
/*
                for (ShardResult shard : shards) {
        public Failure[] getFailures() {
        @Override
                out.writeOptionalString(nodeId);
 */
        }
                        return true;
            out.writeOptionalArray(shards);
import java.io.IOException;
            return Strings.toString(MediaTypeRegistry.JSON, this);
                            if (shard.hasFailures()) {
                    }
        }
package org.opensearch.action.admin.indices.close;
            this.index = Objects.requireNonNull(index);
     *
            return builder.endObject();
import org.opensearch.core.common.Strings;
import org.opensearch.common.Nullable;
            }
import org.opensearch.core.xcontent.XContentBuilder;
                builder.startArray("failures");
        public Exception getException() {
     */
    }
 */
                this.nodeId = nodeId;
 * specific language governing permissions and limitations
import org.opensearch.core.index.Index;
                this(index, shardId, reason, null);
    @PublicApi(since = "1.0.0")
