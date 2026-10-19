        this.flags = flags;
 * Licensed to Elasticsearch under one or more contributor
 * this file be licensed under the Apache-2.0 license or a
        flags.set(CommonStatsFlags.Flag.Indexing, indexing);
        return this;
            return new ClusterAdminTask(id, type, action, parentTaskId, headers);
        return flags.isSet(CommonStatsFlags.Flag.Segments);
     * Sets the underlying stats flags.
    }
        flags.groups(groups);
        return this;
    public boolean get() {
        return flags.isSet(CommonStatsFlags.Flag.Completion);
        } else {
 * All the stats to be returned can be cleared using {@link #clear()}, at which point, specific
        flags.set(CommonStatsFlags.Flag.Docs, docs);
    public boolean includeDataStreams() {
    }
        return this;
        return flags.isSet(CommonStatsFlags.Flag.FieldData);
    }
    public IndicesStatsRequest segments(boolean segments) {
    }
    }
 */
    /**
        return flags.isSet(CommonStatsFlags.Flag.QueryCache);
    }
    }
 * ownership. Elasticsearch licenses this file to you under
    public IndicesStatsRequest flush(boolean flush) {
    public boolean indexing() {
        return this;
        return flags.isSet(CommonStatsFlags.Flag.Get);
    }
@PublicApi(since = "1.0.0")
        flags.set(CommonStatsFlags.Flag.Store, store);
    }
 *
    }
    }
        return this;
        return flags.completionDataFields();
        flags.completionDataFields(completionDataFields);
    /**
        return flags.isSet(CommonStatsFlags.Flag.Store);
        return flags.fieldDataFields();
    private CommonStatsFlags flags = new CommonStatsFlags();
 * GitHub history for details.
package org.opensearch.action.admin.indices.stats;
    }
    }
        flags.set(CommonStatsFlags.Flag.Segments, segments);
    }
public class IndicesStatsRequest extends BroadcastRequest<IndicesStatsRequest> {
        return flags;
    }
        return flags.includeSegmentFileSizes();
import java.util.Map;
        flags.set(CommonStatsFlags.Flag.QueryCache, queryCache);
 * under the License.
        flags.all();
 * license agreements. See the NOTICE file distributed with
    public IndicesStatsRequest refresh(boolean refresh) {
    }
    public IndicesStatsRequest translog(boolean translog) {
        return this;
 * SPDX-License-Identifier: Apache-2.0
/*
        flags.set(CommonStatsFlags.Flag.Refresh, refresh);
        return this;
    public IndicesStatsRequest completionFields(String... completionDataFields) {
 * the Apache License, Version 2.0 (the "License"); you may
     */
 * By default, all statistics are enabled.
    }
    public boolean recovery() {
        }
    public IndicesStatsRequest fieldDataFields(String... fieldDataFields) {
    /**
        if (this.getShouldCancelOnTimeout()) {
    }
        return this;
        return this;
 * The OpenSearch Contributors require contributions made to
        return this;
    }
        flags.includeSegmentFileSizes(includeSegmentFileSizes);
import org.opensearch.rest.action.admin.cluster.ClusterAdminTask;
        return flags.isSet(CommonStatsFlags.Flag.Search);
        flags.clear();
 * <p>
import org.opensearch.common.annotation.PublicApi;
            return super.createTask(id, type, action, parentTaskId, headers);
    public IndicesStatsRequest indexing(boolean indexing) {
    }
    public boolean search() {
import org.opensearch.core.tasks.TaskId;
    public CommonStatsFlags flags() {
import java.io.IOException;
    }
    public IndicesStatsRequest docs(boolean docs) {
    public boolean flush() {
 * software distributed under the License is distributed on an
    public IndicesStatsRequest groups(String... groups) {
        flags.set(CommonStatsFlags.Flag.Translog, translog);
 * this work for additional information regarding copyright
 * stats can be enabled.
    public boolean segments() {
    public boolean fieldData() {
    public IndicesStatsRequest search(boolean search) {
 *
    }
    }
        return flags.isSet(CommonStatsFlags.Flag.Warmer);
        return this.flags.groups();
        return flags.isSet(CommonStatsFlags.Flag.Refresh);
    public IndicesStatsRequest store(boolean store) {
        flags.set(CommonStatsFlags.Flag.Flush, flush);
    public IndicesStatsRequest get(boolean get) {
    }
 * <p>
    public IndicesStatsRequest queryCache(boolean queryCache) {
 *     http://www.apache.org/licenses/LICENSE-2.0
    public boolean translog() {
     * Sets all flags to return all stats.
    }
        return flags.isSet(CommonStatsFlags.Flag.RequestCache);
 * Modifications Copyright OpenSearch Contributors. See
    }
    public IndicesStatsRequest requestCache(boolean requestCache) {
        flags.set(CommonStatsFlags.Flag.Merge, merge);
     */
        return flags.isSet(CommonStatsFlags.Flag.Docs);
 * @opensearch.api
 * specific language governing permissions and limitations
        return this;
    public String[] fieldDataFields() {
    }
        return this;
    public IndicesStatsRequest fieldData(boolean fieldData) {
    }
        flags = new CommonStatsFlags(in);
 * You may obtain a copy of the License at
     * Clears all stats.
    public IndicesStatsRequest includeSegmentFileSizes(boolean includeSegmentFileSizes) {
    public IndicesStatsRequest includeUnloadedSegments(boolean includeUnloadedSegments) {
    }
    }
    public IndicesStatsRequest() {
 */
    }
 *
        return this;
        return this;
    public boolean merge() {
        return this;
 * A request to get indices level stats. Allow to enable different stats to be returned.
    }
    }
    }
import org.opensearch.core.common.io.stream.StreamOutput;
    public void writeTo(StreamOutput out) throws IOException {
    public boolean refresh() {
    }
        return this;
    public IndicesStatsRequest flags(CommonStatsFlags flags) {
    }
        return this;
        return this;
        return flags.isSet(CommonStatsFlags.Flag.Indexing);
 * KIND, either express or implied.  See the License for the
        return flags.isSet(CommonStatsFlags.Flag.Recovery);
    }
    @Override
    public boolean requestCache() {
    public boolean queryCache() {
    }
import org.opensearch.tasks.Task;
        return this;
        super((String[]) null);
    }
     */
    }
    public boolean includeSegmentFileSizes() {
 */
    }
    public String[] groups() {
    public boolean store() {
        flags.set(CommonStatsFlags.Flag.Recovery, recovery);
}
    @Override
/**
        return this;
     */
    public IndicesStatsRequest recovery(boolean recovery) {
    }
        flags.set(CommonStatsFlags.Flag.Get, get);
import org.opensearch.core.common.io.stream.StreamInput;
    }
 * Unless required by applicable law or agreed to in writing,
        flags.fieldDataFields(fieldDataFields);
    public IndicesStatsRequest warmer(boolean warmer) {
    public IndicesStatsRequest merge(boolean merge) {
import org.opensearch.action.support.broadcast.BroadcastRequest;
    public IndicesStatsRequest clear() {
    }
 *
        super.writeTo(out);
 * not use this file except in compliance with the License.
    }
     * when enabled.
    public boolean completion() {
     * Returns the underlying stats flags.
    public boolean docs() {
        flags.set(CommonStatsFlags.Flag.FieldData, fieldData);
 */
        flags.set(CommonStatsFlags.Flag.RequestCache, requestCache);
    /**
/*
        return this;
        flags.includeUnloadedSegments(includeUnloadedSegments);
    }
     */
        flags.writeTo(out);
/*
        flags.set(CommonStatsFlags.Flag.Warmer, warmer);
     * Sets specific search group stats to retrieve the stats for. Mainly affects search
        return this;
    }
    @Override
        return this;
    public IndicesStatsRequest(StreamInput in) throws IOException {
        flags.set(CommonStatsFlags.Flag.Completion, completion);
    public IndicesStatsRequest all() {
    }
    public String[] completionFields() {
        return flags.isSet(CommonStatsFlags.Flag.Translog);
    public boolean warmer() {
 * compatible open source license.
        return flags.isSet(CommonStatsFlags.Flag.Merge);
        return this;
    /**
    }
        return true;
        flags.set(CommonStatsFlags.Flag.Search, search);
        return flags.isSet(CommonStatsFlags.Flag.Flush);
    public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
    public IndicesStatsRequest completion(boolean completion) {
        super(in);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
