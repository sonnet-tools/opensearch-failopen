    /**
    private boolean includeAllShardIndexingPressureTrackers = false;
            throw new AssertionError(e);
    public CommonStatsFlags includeSegmentFileSizes(boolean includeSegmentFileSizes) {
    public static final CommonStatsFlags ALL = new CommonStatsFlags().all();
        }  
    public void writeTo(StreamOutput out) throws IOException {
     * The flags.  
 * software distributed under the License is distributed on an
        fieldDataFields = null;  
 * You may obtain a copy of the License at  
        includeAllShardIndexingPressureTrackers = false;  
    @PublicApi(since = "1.0.0")
    }
     * Sets all flags to return all stats.
    // Used for metric CACHE_STATS, to determine which caches to report stats for  
 * this work for additional information regarding copyright
        return this.fieldDataFields;
    public String[] groups() {
            cloned.flags = flags.clone();
    private String[] groups = null;
        out.writeStringArrayNullable(fieldDataFields);  
    private boolean includeUnloadedSegments = false;  
        Flush("flush", 5),
        Flag(final String restName, final int index) {  
            return index;
        return this;
        Store("store", 0),  
    }
        return this.includeSegmentFileSizes;
    public CommonStatsFlags(StreamInput in) throws IOException {  
 * specific language governing permissions and limitations
    @Override  
        long longFlags = 0;
     * when enabled.
    private boolean includeIndicesStatsByLevel = false;  
        public String getRestName() {
        return this.includeOnlyTopIndexingPressureMetrics;  
        if (flags.length > 0) {  
import org.opensearch.core.common.io.stream.StreamOutput;  
    }
            includeIndicesStatsByLevel = in.readBoolean();
        }  
        completionDataFields = in.readStringArray();
    }  
        return this.includeAllShardIndexingPressureTrackers;
        groups = null;
 * KIND, either express or implied.  See the License for the
     * Sets specific search group stats to retrieve the stats for. Mainly affects search  
        return this;
     */  
        }  
    }  
    public CommonStatsFlags includeUnloadedSegments(boolean includeUnloadedSegments) {  
    }
    public CommonStatsFlags(Flag... flags) {
        includeSegmentFileSizes = false;
            CommonStatsFlags cloned = (CommonStatsFlags) super.clone();  
        return this;
    public CommonStatsFlags set(Flag flag, boolean add) {  
    public CommonStatsFlags includeCacheType(CacheType cacheType) {  
            out.writeStringArrayNullable(Strings.EMPTY_ARRAY);  
     */  
        if (add) {
            longFlags |= (1 << flag.getIndex());
     */
            levels = in.readStringArray();
 * SPDX-License-Identifier: Apache-2.0
            out.writeEnumSet(includeCaches);
        groups = null;
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
            out.writeStringArrayNullable(levels);
        includeOnlyTopIndexingPressureMetrics = false;
        includeSegmentFileSizes = false;
 * Unless required by applicable law or agreed to in writing,
    public CommonStatsFlags clone() {
        for (Flag flag : flags) {  
    public boolean includeSegmentFileSizes() {  
    }
    private EnumSet<CacheType> includeCaches = EnumSet.noneOf(CacheType.class);
        }  
    /**
    public boolean includeAllShardIndexingPressureTrackers() {
        includeAllShardIndexingPressureTrackers = false;
     * Clears all stats.  
import org.opensearch.common.annotation.PublicApi;
import org.opensearch.core.common.Strings;
        includeOnlyTopIndexingPressureMetrics = false;
        includeAllShardIndexingPressureTrackers = in.readBoolean();
        this.includeAllShardIndexingPressureTrackers = includeAllShardPressureTrackers;  
    }
        fieldDataFields = in.readStringArray();  
        includeSegmentFileSizes = in.readBoolean();
        this.includeUnloadedSegments = includeUnloadedSegments;
        Translog("translog", 13),
 * the Apache License, Version 2.0 (the "License"); you may
    public CommonStatsFlags all() {  
import java.util.Set;  
        return this;  
    boolean unSet(Flag flag) {
        Get("get", 2),
            unSet(flag);
        return levels;
    }
        Completion("completion", 11),
     *
        }
        includeOnlyTopIndexingPressureMetrics = in.readBoolean();
 *
    }
     */
    public CommonStatsFlags setLevels(String[] inputLevels) {
    }  
        out.writeBoolean(includeOnlyTopIndexingPressureMetrics);
        out.writeStringArrayNullable(completionDataFields);
/**
    public boolean getIncludeIndicesStatsByLevel() {
    }
        return this;
     * @opensearch.api
     */
        this.includeSegmentFileSizes = includeSegmentFileSizes;
    /**  
        return this;
    }
    }
        return includeCaches;
        }
        return this;
 * under the License.  
        return this;  
        flags.clear();
 */  
/*  
    private EnumSet<Flag> flags = EnumSet.allOf(Flag.class);
        includeUnloadedSegments = false;
    public CommonStatsFlags clear() {
    }
        if (in.getVersion().onOrAfter(Version.V_2_17_0)) {
        Segments("segments", 12),  
        private final String restName;  
    /**  
        Refresh("refresh", 6),  
        levels = new String[0];  
        groups = in.readStringArray();
        return flags.toArray(new Flag[0]);  
    private String[] levels = new String[0];
    public String[] completionDataFields() {  
        out.writeLong(longFlags);  
        Search("search", 3),  
        out.writeBoolean(includeSegmentFileSizes);
        }
public class CommonStatsFlags implements Writeable, Cloneable {
    public enum Flag {
    }
        out.writeBoolean(includeUnloadedSegments);  
 * not use this file except in compliance with the License.
    void set(Flag flag) {
        levels = inputLevels;
 *
        includeUnloadedSegments = in.readBoolean();  
        RequestCache("request_cache", 15),  
    public boolean includeUnloadedSegments() {  
        }  
    public Set<CacheType> getIncludeCaches() {  
 * Licensed to Elasticsearch under one or more contributor  
        }
            includeCaches = in.readEnumSet(CacheType.class);
    private String[] completionDataFields = null;
import org.opensearch.Version;
    private String[] fieldDataFields = null;  
        return this.completionDataFields;
 * The OpenSearch Contributors require contributions made to  
        } catch (CloneNotSupportedException e) {  
import java.util.EnumSet;
    }
    public Flag[] getFlags() {
        out.writeBoolean(includeAllShardIndexingPressureTrackers);
        QueryCache("query_cache", 7),
    }  
        this.includeIndicesStatsByLevel = includeIndicesStatsByLevel;
        this.includeOnlyTopIndexingPressureMetrics = includeOnlyTopIndexingPressureMetrics;
 * GitHub history for details.
        if (in.getVersion().onOrAfter(Version.V_2_14_0)) {  
            clear();
    }
import org.opensearch.core.common.io.stream.StreamInput;
        Recovery("recovery", 16);
        includeCaches = EnumSet.allOf(CacheType.class);  
            Collections.addAll(this.flags, flags);
 * license agreements. See the NOTICE file distributed with
    }  
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.common.io.stream.Writeable;
     * when enabled.
        this.completionDataFields = completionDataFields;
package org.opensearch.action.admin.indices.stats;
            if ((longFlags & (1 << flag.getIndex())) != 0) {
        includeCaches = EnumSet.allOf(CacheType.class);  
        flags = EnumSet.allOf(Flag.class);
    public void setIncludeIndicesStatsByLevel(boolean includeIndicesStatsByLevel) {
    }
@PublicApi(since = "1.0.0")
        levels = new String[0];
 * @opensearch.api
        flags.add(flag);  
        return flags.contains(flag);
        this.fieldDataFields = fieldDataFields;
    }  
    }
        if (out.getVersion().onOrAfter(Version.V_2_14_0)) {  
     */
        if (in.getVersion().before(Version.V_2_0_0)) {
 * compatible open source license.
    /**
            return restName;  
/*  
            return cloned;
    public CommonStatsFlags fieldDataFields(String... fieldDataFields) {
import java.util.Collections;
        FieldData("fielddata", 8),
     * @param flags flags to set. If no flags are supplied, default flags will be set.  
        return this;  
        }
        includeUnloadedSegments = false;  
    public CommonStatsFlags completionDataFields(String... completionDataFields) {
        return this.groups;  
 */  
        return this;
        includeCaches.add(cacheType);
    }  
/*
        Merge("merge", 4),
        out.writeStringArrayNullable(groups);
        fieldDataFields = null;
    }
        }  
 * this file be licensed under the Apache-2.0 license or a
    public CommonStatsFlags includeAllShardIndexingPressureTrackers(boolean includeAllShardPressureTrackers) {
}
     * Sets specific search group stats to retrieve the stats for. Mainly affects search
    }  
    }
            }  
        completionDataFields = null;  
        return this;  
 */  
            this.restName = restName;
 * Common Stats Flags for OpenSearch  
        private int getIndex() {  
    }
    }
    public String[] getLevels() {
    private boolean includeSegmentFileSizes = false;
            in.readStringArray();  
    public CommonStatsFlags groups(String... groups) {  
    private boolean includeOnlyTopIndexingPressureMetrics = false;
        } else {  
        }
    public CommonStatsFlags includeOnlyTopIndexingPressureMetrics(boolean includeOnlyTopIndexingPressureMetrics) {
        }
        Indexing("indexing", 1),
        this.groups = groups;
    }  
    public String[] fieldDataFields() {  
        for (Flag flag : Flag.values()) {  
 * Modifications Copyright OpenSearch Contributors. See
import java.io.IOException;  
        return this;  
        return !flags.isEmpty();
    /**
        final long longFlags = in.readLong();
 *
 * ownership. Elasticsearch licenses this file to you under  
        if (out.getVersion().onOrAfter(Version.V_2_17_0)) {
        }
        Docs("docs", 9),  
 */
    public boolean anySet() {
        Warmer("warmer", 10),
        // 14 was previously used for Suggest
 *  
    @Override  
        if (out.getVersion().before(Version.V_2_0_0)) {
        flags = EnumSet.noneOf(Flag.class);  
        private final int index;
    }
            out.writeBoolean(includeIndicesStatsByLevel);
        completionDataFields = null;
        includeCaches = EnumSet.noneOf(CacheType.class);
    public boolean isSet(Flag flag) {  
        try {
    public CommonStatsFlags includeAllCacheTypes() {
        return flags.remove(flag);
import org.opensearch.common.cache.CacheType;  
            set(flag);
    public boolean includeOnlyTopIndexingPressureMetrics() {
    public static final CommonStatsFlags NONE = new CommonStatsFlags().clear();
        return this.includeIndicesStatsByLevel;  
        return this.includeUnloadedSegments;
    }
                flags.add(flag);
        return this;  
            this.index = index;
