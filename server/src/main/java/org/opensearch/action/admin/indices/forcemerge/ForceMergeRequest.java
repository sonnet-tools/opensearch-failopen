     */
 * @see ForceMergeResponse
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
        }
        public static final int MAX_NUM_SEGMENTS = -1;
     */
            + primaryOnly
        super.writeTo(out);
 * this file be licensed under the Apache-2.0 license or a
        this.onlyExpungeDeletes = onlyExpungeDeletes;
@PublicApi(since = "1.0.0")
            + onlyExpungeDeletes
 *
    /**
    }
        if (in.getVersion().onOrAfter(FORCE_MERGE_UUID_VERSION)) {
    public void writeTo(StreamOutput out) throws IOException {
     */
     * @opensearch.internal
    public ForceMergeRequest(StreamInput in) throws IOException {
     */
     */
            + maxNumSegments
     */
    /**
    }
import org.opensearch.transport.client.Requests;
import org.opensearch.core.common.io.stream.StreamOutput;
        return forceMergeUUID;
    }
        this.primaryOnly = primaryOnly;
 * to force merge down to. Defaults to simply checking if a merge needs
        return "Force-merge indices "
            out.writeBoolean(primaryOnly);
            + Arrays.toString(indices())
 */
            + "]";
        return this;
 * compatible open source license.
        flush = in.readBoolean();
            + ", primaryOnly="
     */
        if (out.getVersion().onOrAfter(FORCE_MERGE_UUID_VERSION)) {
    private static final Version FORCE_MERGE_UUID_VERSION = Version.V_3_0_0;
 *
            );
        out.writeBoolean(onlyExpungeDeletes);
    public ForceMergeRequest flush(boolean flush) {
        return "ForceMergeRequest{"
        return this;
import org.opensearch.transport.client.IndicesAdminClient;
    public String getDescription() {
/**
                "As of legacy version 7.7 [" + Engine.FORCE_MERGE_UUID_KEY + "] is no longer optional in force merge requests."
     */
 * {@link #maxNumSegments(int)} allows to control the number of segments
    public int maxNumSegments() {
        return flush;
            + ", maxSegments["
     */
import org.opensearch.common.annotation.PublicApi;
     *
        super(in);
    }
        out.writeInt(maxNumSegments);
import org.opensearch.Version;
    }
 * the Apache License, Version 2.0 (the "License"); you may
        return onlyExpungeDeletes;
     * Force merge UUID to use when force merging or {@code null} if not using one in a mixed version cluster containing nodes older than
    public void setShouldStoreResult(boolean shouldStoreResult) {
    public ForceMergeRequest maxNumSegments(int maxNumSegments) {
    public boolean onlyExpungeDeletes() {
    /**
/*
 */
        }
        public static final boolean PRIMARY_ONLY = false;
     *
    public boolean primaryOnly() {
     */
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
        return this;
            + flush
     * process to merge down to half the configured number of segments.
    }
        }
    @Override
    }
        this.maxNumSegments = maxNumSegments;
    public boolean getShouldStoreResult() {
     * Should the merge only expunge deletes from the index, without full merging.
        if (out.getVersion().onOrAfter(Version.V_2_13_0)) {
    public boolean flush() {
        if (in.getVersion().onOrAfter(Version.V_2_13_0)) {
    /**
    }
     * Should force merge only performed on primary shards. Defaults to {@code false}.
 * Licensed to Elasticsearch under one or more contributor
        this.shouldStoreResult = shouldStoreResult;
 */
        }
            + flush
    private int maxNumSegments = Defaults.MAX_NUM_SEGMENTS;
        return maxNumSegments;
import org.opensearch.index.engine.Engine;
            + "], flush["
 */
    private boolean onlyExpungeDeletes = Defaults.ONLY_EXPUNGE_DELETES;
     * Defaults to full merging ({@code false}).
    public ForceMergeRequest onlyExpungeDeletes(boolean onlyExpungeDeletes) {
public class ForceMergeRequest extends BroadcastRequest<ForceMergeRequest> {
 * license agreements. See the NOTICE file distributed with
     * Defaults for the Force Merge Request
    }
    private boolean primaryOnly = Defaults.PRIMARY_ONLY;
     * {@link org.opensearch.index.engine.Engine#FORCE_MERGE_UUID_KEY} after force merging it.
            + ", onlyExpungeDeletes="
     * Should flush be performed after the merge. Defaults to {@code true}.
     */
 * under the License.
     */
     * Should force merge only performed on primary shards. Defaults to {@code false}.
     * Will merge the index down to &lt;= maxNumSegments. By default, will cause the merge
 * to execute, and if so, executes it
 * specific language governing permissions and limitations
        maxNumSegments = in.readInt();
     * Force merge UUID to store in the live commit data of a shard under
import java.util.Arrays;
     * Should the merge only expunge deletes from the index, without full merge.
    }
    public ForceMergeRequest primaryOnly(boolean primaryOnly) {
    }
 * indices.
        this.flush = flush;
    }
 *
        onlyExpungeDeletes = in.readBoolean();
    public String toString() {
            + "maxNumSegments="
 *
     * Should flush be performed after the merge. Defaults to {@code true}.
        public static final boolean FLUSH = true;
            primaryOnly = in.readBoolean();
    /**
        } else {
    /**
            + onlyExpungeDeletes
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * @param indices The indices to merge, no indices passed means all indices will be merged.
    public ForceMergeRequest(String... indices) {
    }
    @Override
            forceMergeUUID = in.readString();
 * A request to force merging the segments of one or more indices. In order to
    /**
    /**
/*
 * @see IndicesAdminClient#forceMerge(ForceMergeRequest)
     * Will merge the index down to &lt;= maxNumSegments. By default, will cause the merge
     * Defaults to full merging ({@code false}).
 * @opensearch.api
    /**
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.UUIDs;
 * You may obtain a copy of the License at
    /**
            + ", flush="
    public static final class Defaults {
            + '}';
            + maxNumSegments
    public String forceMergeUUID() {
            out.writeOptionalString(forceMergeUUID);
    }
            + "], primaryOnly["
 * Modifications Copyright OpenSearch Contributors. See
    @Override
    private boolean flush = Defaults.FLUSH;
    }
    @Override
 * The OpenSearch Contributors require contributions made to
 * ownership. Elasticsearch licenses this file to you under
     * {@link #FORCE_MERGE_UUID_VERSION}.
import org.opensearch.core.common.io.stream.StreamInput;
        forceMergeUUID = UUIDs.randomBase64UUID();
 * SPDX-License-Identifier: Apache-2.0
     * process to merge down to half the configured number of segments.
     */
        super(indices);
/*
    /**
            + primaryOnly
            out.writeString(forceMergeUUID);
        return this;
    private boolean shouldStoreResult;
        return primaryOnly;
import org.opensearch.action.support.broadcast.BroadcastRequest;
     * Should this task store its result after it has finished?
}
 *
    }
    /**
            throw new IllegalStateException(
        public static final boolean ONLY_EXPUNGE_DELETES = false;
            + "], onlyExpungeDeletes["
        return shouldStoreResult;
import java.io.IOException;
 * @see Requests#forceMergeRequest(String...)
 * run a merge on all the indices, pass an empty array or {@code null} for the
    private final String forceMergeUUID;
    /**
 * GitHub history for details.
     * Constructs a merge request over one or more indices.
        out.writeBoolean(flush);
        } else if ((forceMergeUUID = in.readOptionalString()) == null) {
package org.opensearch.action.admin.indices.forcemerge;
    }
 * this work for additional information regarding copyright
