    }  
import java.util.List;
            public void writeTo(final StreamOutput out) throws IOException {
            this(index, Objects.requireNonNull(failure), null);  
 */
        AddBlockShardResult(final StreamInput in) throws IOException {
import org.opensearch.action.support.clustermanager.ShardsAcknowledgedResponse;
            if (shards != null) {  
import org.opensearch.core.index.Index;
                        return true;  
        public boolean hasFailures() {  
     * @opensearch.api
     *  
            return CollectionUtils.isEmpty(failures) == false;
        super(in, true);
            builder.startObject();
        super.addCustomFields(builder, params);  
import java.io.IOException;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override  
import org.opensearch.core.common.io.stream.Writeable;
            this.failures = failures;
     */
            this.index = new Index(in);
            index.toXContent(builder, params);  
        }  
 */  
                this.nodeId = nodeId;  
        }
                if (hasFailures()) {  
        @Override
     *
                nodeId = in.readOptionalString();  
            this.shards = in.readOptionalArray(AddBlockShardResult::new, AddBlockShardResult[]::new);
                        builder.startObject("exception");
 *
@PublicApi(since = "1.0.0")
        public static class Failure extends DefaultShardOperationFailedException {  
                return nodeId;
                } else {
        }
        builder.startArray("indices");
    }
        private final @Nullable AddBlockShardResult[] shards;
public class AddIndexBlockResponse extends ShardsAcknowledgedResponse {  
            return builder.endObject();
/*  
                            if (shard.hasFailures()) {
            }
        }
 * SPDX-License-Identifier: Apache-2.0
/**  
     * Per shard result for adding a block
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
            {  
    public AddIndexBlockResponse(final boolean acknowledged, final boolean shardsAcknowledged, final List<AddBlockResult> indices) {  
            return index;  
                builder.field("name", index.getName());
            public Failure(final String index, final int shardId, final Throwable reason) {  
        }
                        for (AddBlockShardResult shard : shards) {
                            }
                if (nodeId != null) {  
        }
        @Override
                    if (exception != null) {
        AddBlockResult(final StreamInput in) throws IOException {
            }
                this(index, shardId, reason, null);
import java.util.Objects;
    /**  
        public AddBlockResult(final Index index, final AddBlockShardResult[] shards) {  
        }  
            }
        return Strings.toString(MediaTypeRegistry.JSON, this);
 */
                return new Failure(in);  
import static java.util.Collections.unmodifiableList;
 *
        /**  
            builder.startObject();  
        this.indices = unmodifiableList(Objects.requireNonNull(indices));
     */
        public boolean hasFailures() {
            public XContentBuilder innerToXContent(final XContentBuilder builder, final Params params) throws IOException {
            return failures;  
                super(index, shardId, reason);
                    } else {
    public void writeTo(StreamOutput out) throws IOException {
            this.index = Objects.requireNonNull(index);
            out.writeOptionalArray(shards);
            private @Nullable String nodeId;
    private final List<AddBlockResult> indices;
 * Licensed to Elasticsearch under one or more contributor  
        private final @Nullable Exception exception;
        @PublicApi(since = "1.0.0")
}
        }
        }
            this.shards = shards;
        public XContentBuilder toXContent(final XContentBuilder builder, final Params params) throws IOException {
            }
        super(acknowledged, shardsAcknowledged);
                builder.field("id", String.valueOf(id));
         *
    @Override
            this(index, null, Objects.requireNonNull(shards));
            }
    }  
        public void writeTo(final StreamOutput out) throws IOException {
            if (exception != null) {  
            {
            static Failure readFailure(final StreamInput in) throws IOException {
                    if (shard.hasFailures()) {
            return Strings.toString(MediaTypeRegistry.JSON, this);  
            out.writeException(exception);
    }
        }
            this(index, null, null);
        @Override  
 * @opensearch.api  
    public String toString() {  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.annotation.PublicApi;  
import org.opensearch.core.common.io.stream.StreamOutput;
                                shard.toXContent(builder, params);  
                builder.endArray();
                return super.innerToXContent(builder, params);  
        }
                        builder.endArray();  
        indices = unmodifiableList(in.readList(AddBlockResult::new));  
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
 * Unless required by applicable law or agreed to in writing,
            return builder.endObject();  
        }
 * this file be licensed under the Apache-2.0 license or a
        @Override  
        }
            public String toString() {
            @Override
                return true;
        @Override  
/*
    public List<AddBlockResult> getIndices() {
                    builder.field("node", nodeId);
    /**
            public Failure(final String index, final int shardId, final Throwable reason, final String nodeId) {
     * Result for adding a block
            this.id = id;  
        }
        writeShardsAcknowledged(out);  
import org.opensearch.core.xcontent.MediaTypeRegistry;
            @Override  
                super(in);
 * You may obtain a copy of the License at  
import org.opensearch.OpenSearchException;  
        for (AddBlockResult index : indices) {
        private AddBlockResult(final Index index, @Nullable final Exception exception, @Nullable final AddBlockShardResult[] shards) {
 */
            public String getNodeId() {  
        public AddBlockResult(final Index index) {
        public String toString() {
        public AddBlockResult(final Index index, final Exception failure) {
                    builder.field("blocked", true);  
    @PublicApi(since = "1.0.0")
        }
            return false;
    public static class AddBlockShardResult implements Writeable, ToXContentFragment {  
        private final int id;
         * @opensearch.api  
 *  
package org.opensearch.action.admin.indices.readonly;
 * KIND, either express or implied.  See the License for the
                for (AddBlockShardResult shard : shards) {
            index.writeTo(out);  
        public void writeTo(final StreamOutput out) throws IOException {
        }  
 * under the License.  
                        OpenSearchException.generateFailureXContent(builder, params, exception, true);  
import org.opensearch.core.common.io.stream.StreamInput;  
                }
 * software distributed under the License is distributed on an
        }
                        builder.endObject();
            }
        private final Index index;  
            @Override
import org.opensearch.core.xcontent.ToXContentFragment;  
        out.writeList(indices);
            this.failures = in.readOptionalArray(Failure::readFailure, Failure[]::new);  
    }
                }
            this.id = in.readVInt();
                    }  
    }
    protected void addCustomFields(final XContentBuilder builder, final Params params) throws IOException {
    public static class AddBlockResult implements Writeable, ToXContentFragment {
        public String toString() {
 *
 * specific language governing permissions and limitations
        public XContentBuilder toXContent(final XContentBuilder builder, final Params params) throws IOException {
 * Modifications Copyright OpenSearch Contributors. See  
                super.writeTo(out);  
                builder.startArray("failures");
    }
 * compatible open source license.
        public int getId() {
 * ownership. Elasticsearch licenses this file to you under  
            return id;
                }
                        builder.startArray("failed_shards");  
import org.opensearch.common.Nullable;
        super.writeTo(out);
 * not use this file except in compliance with the License.
            }
                    }
        }  
            this.exception = exception;  
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.core.common.Strings;
                    for (Failure failure : failures) {
    @PublicApi(since = "1.0.0")  
            return exception;
import org.opensearch.core.common.util.CollectionUtils;  
        return indices;  
        public AddBlockShardResult[] getShards() {
                    }
            }
    AddIndexBlockResponse(StreamInput in) throws IOException {
        public Exception getException() {  
                        }
        private final Failure[] failures;  
 * GitHub history for details.
         * Contains failure information
            out.writeVInt(id);
            }
 * Transport response to open an index.
                        failure.toXContent(builder, params);
            }  
        }
        @Override
        public Failure[] getFailures() {
    }  
 *     http://www.apache.org/licenses/LICENSE-2.0
            this.exception = in.readException();  
        }
        public Index getIndex() {
                if (failures != null) {  
        public AddBlockShardResult(final int id, final Failure[] failures) {
                return Strings.toString(MediaTypeRegistry.JSON, this);
        builder.endArray();
/*
 * this work for additional information regarding copyright
            private Failure(StreamInput in) throws IOException {
            }  
            }  
                }
     * @opensearch.api  
 * The OpenSearch Contributors require contributions made to  
         */
        }  
            out.writeOptionalArray(failures);  
        }
            return Strings.toString(MediaTypeRegistry.JSON, this);
            return shards;
                out.writeOptionalString(nodeId);
