 * GitHub history for details.
        }
                    if (shard.hasFailures()) {
/**
        public AddBlockResult(final Index index) {
        }
            return Strings.toString(MediaTypeRegistry.JSON, this);
        public boolean hasFailures() {
            this.id = in.readVInt();
        }
                super.writeTo(out);
    }
                for (AddBlockShardResult shard : shards) {
    /**
            }
        @Override
                this.nodeId = nodeId;
            }
    AddIndexBlockResponse(StreamInput in) throws IOException {
 */
            return index;
import org.opensearch.common.Nullable;
            this.shards = shards;
    }
            private @Nullable String nodeId;
            this(index, null, null);
 * ownership. Elasticsearch licenses this file to you under
            this.failures = failures;
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
                        builder.startArray("failed_shards");
 * Transport response to open an index.
 * Licensed to Elasticsearch under one or more contributor
     * @opensearch.api
            return id;
                    }
        }
        super(in, true);
        public XContentBuilder toXContent(final XContentBuilder builder, final Params params) throws IOException {
import org.opensearch.core.xcontent.XContentBuilder;
                }
            builder.startObject();
    public void writeTo(StreamOutput out) throws IOException {
                } else {
                if (nodeId != null) {
        private final @Nullable AddBlockShardResult[] shards;
    }
        }
     * Per shard result for adding a block
            public void writeTo(final StreamOutput out) throws IOException {
        @Override
     */
 * The OpenSearch Contributors require contributions made to
                builder.field("name", index.getName());
    public String toString() {
}
         *
    private final List<AddBlockResult> indices;
            public Failure(final String index, final int shardId, final Throwable reason) {
        }
            this(index, Objects.requireNonNull(failure), null);
 *
import org.opensearch.core.index.Index;
            @Override
import org.opensearch.core.common.io.stream.Writeable;
                return nodeId;
        AddBlockResult(final StreamInput in) throws IOException {
/*
        }
     * @opensearch.api
                    }
        }
                builder.startArray("failures");
/*
                }
        }
        builder.endArray();
    @Override
                            if (shard.hasFailures()) {
        public Failure[] getFailures() {
                                shard.toXContent(builder, params);
            if (exception != null) {
            return exception;
        public AddBlockResult(final Index index, final Exception failure) {
        }
                this(index, shardId, reason, null);
        return Strings.toString(MediaTypeRegistry.JSON, this);
                        for (AddBlockShardResult shard : shards) {
        writeShardsAcknowledged(out);
        indices = unmodifiableList(in.readList(AddBlockResult::new));
 *     http://www.apache.org/licenses/LICENSE-2.0
            this.failures = in.readOptionalArray(Failure::readFailure, Failure[]::new);
                nodeId = in.readOptionalString();
import org.opensearch.core.xcontent.MediaTypeRegistry;
 */
 * this work for additional information regarding copyright
        }
     *
 *
            this.id = id;
            }
                return Strings.toString(MediaTypeRegistry.JSON, this);
                super(in);
            public XContentBuilder innerToXContent(final XContentBuilder builder, final Params params) throws IOException {
            return builder.endObject();
                    } else {
     *
        @Override
            return false;
            out.writeVInt(id);
 * SPDX-License-Identifier: Apache-2.0
        public AddBlockShardResult[] getShards() {
    /**
            }
 * KIND, either express or implied.  See the License for the
        public boolean hasFailures() {
 * specific language governing permissions and limitations
@PublicApi(since = "1.0.0")
import org.opensearch.core.common.io.stream.StreamOutput;
            this.exception = in.readException();
public class AddIndexBlockResponse extends ShardsAcknowledgedResponse {
        builder.startArray("indices");
            @Override
            return Strings.toString(MediaTypeRegistry.JSON, this);
        }
    public List<AddBlockResult> getIndices() {
        public Exception getException() {
    }
 * compatible open source license.
        private final Index index;
import java.util.List;
        private final int id;
 * the Apache License, Version 2.0 (the "License"); you may
            out.writeOptionalArray(failures);
        public int getId() {
        @Override
                        return true;
                return new Failure(in);
        public void writeTo(final StreamOutput out) throws IOException {
            out.writeException(exception);
        super.writeTo(out);
 * under the License.
            static Failure readFailure(final StreamInput in) throws IOException {
        public String toString() {
    @Override
        private final @Nullable Exception exception;
            this.exception = exception;
        public String toString() {
                super(index, shardId, reason);
                        builder.endObject();
                    if (exception != null) {
            {
    }
            index.toXContent(builder, params);
                        builder.startObject("exception");
            this.index = new Index(in);
    }
                out.writeOptionalString(nodeId);
 */
    public static class AddBlockShardResult implements Writeable, ToXContentFragment {
            {
        public static class Failure extends DefaultShardOperationFailedException {
        @PublicApi(since = "1.0.0")
 * software distributed under the License is distributed on an
    @PublicApi(since = "1.0.0")
                }
            public String getNodeId() {
 * @opensearch.api
                        }
        out.writeList(indices);
                return super.innerToXContent(builder, params);
            out.writeOptionalArray(shards);
 *
                    builder.field("blocked", true);
import org.opensearch.core.xcontent.ToXContentFragment;
            return builder.endObject();
import java.util.Objects;
        }
        public XContentBuilder toXContent(final XContentBuilder builder, final Params params) throws IOException {
        public AddBlockResult(final Index index, final AddBlockShardResult[] shards) {
                        OpenSearchException.generateFailureXContent(builder, params, exception, true);
 */
            if (shards != null) {
                return true;
        }
                    builder.field("node", nodeId);
        for (AddBlockResult index : indices) {
     * Result for adding a block
        AddBlockShardResult(final StreamInput in) throws IOException {
            return CollectionUtils.isEmpty(failures) == false;
        public Index getIndex() {
            }
package org.opensearch.action.admin.indices.readonly;
        return indices;
            }
                if (hasFailures()) {
        }
        public void writeTo(final StreamOutput out) throws IOException {
import java.io.IOException;
        }
            return shards;
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at
    @Override
                        failure.toXContent(builder, params);
            this.index = Objects.requireNonNull(index);
import org.opensearch.action.support.clustermanager.ShardsAcknowledgedResponse;
            builder.startObject();
import org.opensearch.common.annotation.PublicApi;
            public String toString() {
                    }
        @Override
                }
        }
        }
            index.writeTo(out);
     */
            this.shards = in.readOptionalArray(AddBlockShardResult::new, AddBlockShardResult[]::new);
import org.opensearch.core.common.Strings;
                    for (Failure failure : failures) {
        public AddBlockShardResult(final int id, final Failure[] failures) {
        this.indices = unmodifiableList(Objects.requireNonNull(indices));
    }
            }
            public Failure(final String index, final int shardId, final Throwable reason, final String nodeId) {
            }
    public AddIndexBlockResponse(final boolean acknowledged, final boolean shardsAcknowledged, final List<AddBlockResult> indices) {
    public static class AddBlockResult implements Writeable, ToXContentFragment {
            private Failure(StreamInput in) throws IOException {
                            }
        }
         * Contains failure information
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
                builder.endArray();
import org.opensearch.OpenSearchException;
            @Override
            return failures;
                if (failures != null) {
 * this file be licensed under the Apache-2.0 license or a
/*
    }
            }
    @PublicApi(since = "1.0.0")
            }
import org.opensearch.core.common.util.CollectionUtils;
        @Override
         */
            }
            this(index, null, Objects.requireNonNull(shards));
 *
        super(acknowledged, shardsAcknowledged);
        }
         * @opensearch.api
        private AddBlockResult(final Index index, @Nullable final Exception exception, @Nullable final AddBlockShardResult[] shards) {
        }
                builder.field("id", String.valueOf(id));
        super.addCustomFields(builder, params);
import static java.util.Collections.unmodifiableList;
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                        builder.endArray();
import org.opensearch.core.common.io.stream.StreamInput;
 * not use this file except in compliance with the License.
        }
    protected void addCustomFields(final XContentBuilder builder, final Params params) throws IOException {
        /**
        private final Failure[] failures;
