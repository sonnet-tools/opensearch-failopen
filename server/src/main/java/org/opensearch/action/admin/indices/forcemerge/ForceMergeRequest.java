    /**
    public ForceMergeRequest primaryOnly(boolean primaryOnly) {
        if (out.getVersion().onOrAfter(Version.V_2_13_0)) {
    private boolean shouldStoreResult;
     */  
    }
            + maxNumSegments  
/**
        this.primaryOnly = primaryOnly;  
     * Force merge UUID to use when force merging or {@code null} if not using one in a mixed version cluster containing nodes older than  
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
        return "Force-merge indices "  
public class ForceMergeRequest extends BroadcastRequest<ForceMergeRequest> {
        return maxNumSegments;  
            + ", primaryOnly="
     * {@link #FORCE_MERGE_UUID_VERSION}.
    public static final class Defaults {  
        return primaryOnly;
     */  
    /**  
     * Defaults to full merging ({@code false}).
     * Should flush be performed after the merge. Defaults to {@code true}.
package org.opensearch.action.admin.indices.forcemerge;
            + primaryOnly  
    /**
    }
 * SPDX-License-Identifier: Apache-2.0
     */
 * this file be licensed under the Apache-2.0 license or a
    private boolean onlyExpungeDeletes = Defaults.ONLY_EXPUNGE_DELETES;
    }  
        return this;
        return this;  
    private final String forceMergeUUID;  
            + "], onlyExpungeDeletes["
 * GitHub history for details.
            + "]";
    @Override
            throw new IllegalStateException(
 * The OpenSearch Contributors require contributions made to  
        flush = in.readBoolean();  
    }  
        this.shouldStoreResult = shouldStoreResult;
 *
 * Licensed to Elasticsearch under one or more contributor  
 * indices.
import org.opensearch.core.common.io.stream.StreamOutput;  
        return "ForceMergeRequest{"
    public String toString() {  
        return flush;
     * Should force merge only performed on primary shards. Defaults to {@code false}.
    public String getDescription() {
            forceMergeUUID = in.readString();
            + "], primaryOnly["
    /**
            );  
            + "], flush["  
     * Force merge UUID to store in the live commit data of a shard under  
 * {@link #maxNumSegments(int)} allows to control the number of segments  
            + primaryOnly  
     * Should the merge only expunge deletes from the index, without full merging.
 * @see ForceMergeResponse  
                "As of legacy version 7.7 [" + Engine.FORCE_MERGE_UUID_KEY + "] is no longer optional in force merge requests."
import org.opensearch.core.common.io.stream.StreamInput;
    }
    /**  
        super(indices);
        if (out.getVersion().onOrAfter(FORCE_MERGE_UUID_VERSION)) {
    }
        }
    @Override
 * KIND, either express or implied.  See the License for the
    }
     * Will merge the index down to &lt;= maxNumSegments. By default, will cause the merge
 * run a merge on all the indices, pass an empty array or {@code null} for the
    private static final Version FORCE_MERGE_UUID_VERSION = Version.V_3_0_0;  
import java.util.Arrays;  
        return shouldStoreResult;
            + onlyExpungeDeletes
    }  
     */
    }
 * A request to force merging the segments of one or more indices. In order to  
        if (in.getVersion().onOrAfter(FORCE_MERGE_UUID_VERSION)) {
    @Override
        } else {  
     * Should force merge only performed on primary shards. Defaults to {@code false}.  
     * @param indices The indices to merge, no indices passed means all indices will be merged.
     * Defaults to full merging ({@code false}).
/*  
     * {@link org.opensearch.index.engine.Engine#FORCE_MERGE_UUID_KEY} after force merging it.
        return forceMergeUUID;
    private int maxNumSegments = Defaults.MAX_NUM_SEGMENTS;
    }
 */  
    /**
    }  
            + '}';
    }  
        }  
            + "maxNumSegments="
        this.flush = flush;  
    public void setShouldStoreResult(boolean shouldStoreResult) {
 * Unless required by applicable law or agreed to in writing,
        forceMergeUUID = UUIDs.randomBase64UUID();
 * Modifications Copyright OpenSearch Contributors. See
            + Arrays.toString(indices())
    public String forceMergeUUID() {  
            + ", onlyExpungeDeletes="
    /**
}  
     * Constructs a merge request over one or more indices.
        return onlyExpungeDeletes;
import org.opensearch.common.UUIDs;  
     *  
            + ", flush="  
 * specific language governing permissions and limitations
        out.writeInt(maxNumSegments);
 * ownership. Elasticsearch licenses this file to you under  
    public ForceMergeRequest maxNumSegments(int maxNumSegments) {
        public static final boolean FLUSH = true;  
    }  
 * @opensearch.api
     */
 * You may obtain a copy of the License at  
    public ForceMergeRequest(String... indices) {  
    /**
     * process to merge down to half the configured number of segments.  
            + flush
            out.writeBoolean(primaryOnly);
    }
    public ForceMergeRequest flush(boolean flush) {
    public int maxNumSegments() {
        return this;
     */  
        this.onlyExpungeDeletes = onlyExpungeDeletes;
/*
    public boolean onlyExpungeDeletes() {
     */
    }
     * @opensearch.internal
        onlyExpungeDeletes = in.readBoolean();
 * software distributed under the License is distributed on an
        public static final int MAX_NUM_SEGMENTS = -1;
 * this work for additional information regarding copyright
     * Should this task store its result after it has finished?
     * Will merge the index down to &lt;= maxNumSegments. By default, will cause the merge
 * license agreements. See the NOTICE file distributed with
import org.opensearch.Version;
    /**
import org.opensearch.transport.client.IndicesAdminClient;
        return this;
     * process to merge down to half the configured number of segments.
    }
    public boolean flush() {
/*  
     * Defaults for the Force Merge Request
 *  
    /**
 * compatible open source license.
 * @see Requests#forceMergeRequest(String...)
        } else if ((forceMergeUUID = in.readOptionalString()) == null) {  
    /**
            out.writeOptionalString(forceMergeUUID);
    /**
        if (in.getVersion().onOrAfter(Version.V_2_13_0)) {
    public void writeTo(StreamOutput out) throws IOException {
     * Should flush be performed after the merge. Defaults to {@code true}.  
 *
 * not use this file except in compliance with the License.
    private boolean flush = Defaults.FLUSH;  
    public ForceMergeRequest(StreamInput in) throws IOException {
        }  
     */
import org.opensearch.transport.client.Requests;  
        public static final boolean PRIMARY_ONLY = false;
    private boolean primaryOnly = Defaults.PRIMARY_ONLY;
        super.writeTo(out);  
    public boolean primaryOnly() {
        }
    @Override
            + maxNumSegments  
    /**
 * the Apache License, Version 2.0 (the "License"); you may
        this.maxNumSegments = maxNumSegments;
    public ForceMergeRequest onlyExpungeDeletes(boolean onlyExpungeDeletes) {  
            out.writeString(forceMergeUUID);
 */
    public boolean getShouldStoreResult() {  
        out.writeBoolean(onlyExpungeDeletes);
 * to force merge down to. Defaults to simply checking if a merge needs
        super(in);  
@PublicApi(since = "1.0.0")
     */
import org.opensearch.index.engine.Engine;
     */
     */
        maxNumSegments = in.readInt();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
 * to execute, and if so, executes it
     *  
        public static final boolean ONLY_EXPUNGE_DELETES = false;
 * under the License.  
 */  
 * @see IndicesAdminClient#forceMerge(ForceMergeRequest)
import org.opensearch.action.support.broadcast.BroadcastRequest;
 *  
import org.opensearch.common.annotation.PublicApi;
        out.writeBoolean(flush);  
     */  
import java.io.IOException;
     */  
            + flush
            + onlyExpungeDeletes
     * Should the merge only expunge deletes from the index, without full merge.  
            primaryOnly = in.readBoolean();
            + ", maxSegments["
 *
