 * GitHub history for details.
        flags.set(CommonStatsFlags.Flag.Recovery, recovery);
        return this;
        flags.set(CommonStatsFlags.Flag.RequestCache, requestCache);
 * SPDX-License-Identifier: Apache-2.0
    public boolean store() {
 * the Apache License, Version 2.0 (the "License"); you may
        flags.set(CommonStatsFlags.Flag.Completion, completion);
        return this;
        return flags.isSet(CommonStatsFlags.Flag.Merge);  
    }
import org.opensearch.common.annotation.PublicApi;
        super.writeTo(out);
 * <p>
    }  
        return this;
    public IndicesStatsRequest all() {  
        return flags.isSet(CommonStatsFlags.Flag.FieldData);  
        flags.set(CommonStatsFlags.Flag.Get, get);
 * stats can be enabled.  
    }
    public IndicesStatsRequest segments(boolean segments) {  
    /**
        return this;
import org.opensearch.tasks.Task;
    public IndicesStatsRequest queryCache(boolean queryCache) {  
import org.opensearch.core.common.io.stream.StreamOutput;
 * Licensed to Elasticsearch under one or more contributor  
        return this;
    }
        return flags.isSet(CommonStatsFlags.Flag.Warmer);  
/*
    public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
    public IndicesStatsRequest merge(boolean merge) {  
    public IndicesStatsRequest get(boolean get) {  
 * not use this file except in compliance with the License.
        return flags.isSet(CommonStatsFlags.Flag.Recovery);  
        flags.set(CommonStatsFlags.Flag.Refresh, refresh);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
    }  
    public IndicesStatsRequest completionFields(String... completionDataFields) {  
        return this.flags.groups();
        return this;
        flags.set(CommonStatsFlags.Flag.Merge, merge);
    public boolean completion() {
     * Sets specific search group stats to retrieve the stats for. Mainly affects search
        return flags.isSet(CommonStatsFlags.Flag.Translog);  
    }
    public boolean fieldData() {
        return flags.isSet(CommonStatsFlags.Flag.RequestCache);  
        return flags.fieldDataFields();  
            return new ClusterAdminTask(id, type, action, parentTaskId, headers);
    /**
     * Sets all flags to return all stats.
    public IndicesStatsRequest(StreamInput in) throws IOException {
    public boolean flush() {
        return flags.isSet(CommonStatsFlags.Flag.Indexing);  
import java.io.IOException;  
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
     */
    /**
    public IndicesStatsRequest() {  
    }  
    public IndicesStatsRequest refresh(boolean refresh) {  
    }
    }  
        flags.groups(groups);  
import java.util.Map;
 */
    public boolean get() {
    }  
    /**  
    public IndicesStatsRequest translog(boolean translog) {  
    }  
    public boolean translog() {
 * this file be licensed under the Apache-2.0 license or a
    }  
        super((String[]) null);
    public boolean indexing() {
    }
    public void writeTo(StreamOutput out) throws IOException {  
public class IndicesStatsRequest extends BroadcastRequest<IndicesStatsRequest> {
    public IndicesStatsRequest includeSegmentFileSizes(boolean includeSegmentFileSizes) {
        return this;
 */  
    }
    }
    }  
        flags.set(CommonStatsFlags.Flag.Warmer, warmer);
        return this;
    }
        flags.set(CommonStatsFlags.Flag.Search, search);
 * ownership. Elasticsearch licenses this file to you under  
        return flags.isSet(CommonStatsFlags.Flag.Store);
    public boolean segments() {
    public boolean merge() {
    }  
    public IndicesStatsRequest flags(CommonStatsFlags flags) {
 * All the stats to be returned can be cleared using {@link #clear()}, at which point, specific
    }
 * A request to get indices level stats. Allow to enable different stats to be returned.
        flags.set(CommonStatsFlags.Flag.Docs, docs);  
    }
    public boolean requestCache() {
        return this;
    public IndicesStatsRequest flush(boolean flush) {  
    public IndicesStatsRequest groups(String... groups) {
        return flags.isSet(CommonStatsFlags.Flag.Completion);  
     * Returns the underlying stats flags.
        return this;
    }
    public boolean refresh() {
        flags.all();
 *
     * Clears all stats.  
        this.flags = flags;  
    public IndicesStatsRequest includeUnloadedSegments(boolean includeUnloadedSegments) {  
 *
     */
        return this;
 * @opensearch.api
        return flags.isSet(CommonStatsFlags.Flag.Docs);
        super(in);
 * <p>
        return true;
        return flags.isSet(CommonStatsFlags.Flag.Flush);  
        flags.clear();  
    public boolean warmer() {
    }
    }
        return flags.isSet(CommonStatsFlags.Flag.Segments);  
 * By default, all statistics are enabled.  
        flags.writeTo(out);
        flags.completionDataFields(completionDataFields);
    }  
    public boolean queryCache() {
/*  
import org.opensearch.action.support.broadcast.BroadcastRequest;
        flags.includeSegmentFileSizes(includeSegmentFileSizes);
 *     http://www.apache.org/licenses/LICENSE-2.0
    }  
/**  
            return super.createTask(id, type, action, parentTaskId, headers);  
    public CommonStatsFlags flags() {
 * KIND, either express or implied.  See the License for the
        return this;
import org.opensearch.core.common.io.stream.StreamInput;  
    public IndicesStatsRequest docs(boolean docs) {
        return this;
     * when enabled.  
/*  
    public IndicesStatsRequest warmer(boolean warmer) {  
    private CommonStatsFlags flags = new CommonStatsFlags();
import org.opensearch.rest.action.admin.cluster.ClusterAdminTask;  
        flags.set(CommonStatsFlags.Flag.Store, store);  
    }  
import org.opensearch.core.tasks.TaskId;
        return flags;
        return this;
        }
    public IndicesStatsRequest indexing(boolean indexing) {
        return flags.isSet(CommonStatsFlags.Flag.Search);  
    }  
     */
    public IndicesStatsRequest clear() {
    }
        return this;  
    /**
        return this;
 * Modifications Copyright OpenSearch Contributors. See
        } else {
        return flags.isSet(CommonStatsFlags.Flag.Refresh);  
    public IndicesStatsRequest search(boolean search) {  
    public String[] groups() {
    }  
        flags.includeUnloadedSegments(includeUnloadedSegments);
    public IndicesStatsRequest store(boolean store) {
 */  
        return this;
    }  
        flags.fieldDataFields(fieldDataFields);
     */
 * You may obtain a copy of the License at  
    }  
        return this;
    }
    }
    @Override
    @Override
    public boolean docs() {
 * license agreements. See the NOTICE file distributed with
    }  
        flags.set(CommonStatsFlags.Flag.Flush, flush);
    }  
        flags.set(CommonStatsFlags.Flag.QueryCache, queryCache);
        flags.set(CommonStatsFlags.Flag.Indexing, indexing);  
    }  
    public IndicesStatsRequest requestCache(boolean requestCache) {  
    public IndicesStatsRequest fieldDataFields(String... fieldDataFields) {  
        if (this.getShouldCancelOnTimeout()) {  
        return this;
        return flags.isSet(CommonStatsFlags.Flag.Get);  
    public String[] completionFields() {
    }
    public IndicesStatsRequest recovery(boolean recovery) {  
 * Unless required by applicable law or agreed to in writing,
        return this;
     * Sets the underlying stats flags.  
        return flags.includeSegmentFileSizes();
    }
    public boolean search() {
    public boolean includeDataStreams() {  
    public IndicesStatsRequest fieldData(boolean fieldData) {  
    }
 * specific language governing permissions and limitations
 *  
    }
 * compatible open source license.
    }
        return this;
        return this;
    }  
        flags.set(CommonStatsFlags.Flag.Segments, segments);
    }
    public boolean recovery() {
    }
 *
    }
    public boolean includeSegmentFileSizes() {  
        return this;
    public IndicesStatsRequest completion(boolean completion) {  
package org.opensearch.action.admin.indices.stats;
    }
        return this;
    }
        flags.set(CommonStatsFlags.Flag.Translog, translog);
    }  
        flags = new CommonStatsFlags(in);  
    public String[] fieldDataFields() {
    }  
    @Override
 * this work for additional information regarding copyright
     */  
 */  
}  
@PublicApi(since = "1.0.0")
        flags.set(CommonStatsFlags.Flag.FieldData, fieldData);
        return flags.completionDataFields();  
 * under the License.  
        return flags.isSet(CommonStatsFlags.Flag.QueryCache);  
