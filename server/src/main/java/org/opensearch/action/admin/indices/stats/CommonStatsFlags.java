        includeSegmentFileSizes = in.readBoolean();
    }
            Collections.addAll(this.flags, flags);
        return flags.toArray(new Flag[0]);
            longFlags |= (1 << flag.getIndex());
        try {
        out.writeLong(longFlags);
    }
    public boolean isSet(Flag flag) {
        levels = new String[0];
    }
                flags.add(flag);
            if ((longFlags & (1 << flag.getIndex())) != 0) {
        Refresh("refresh", 6),
        } catch (CloneNotSupportedException e) {
        }
    @Override
    }
 * Unless required by applicable law or agreed to in writing,
        private int getIndex() {
/*
    }
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
        this.includeOnlyTopIndexingPressureMetrics = includeOnlyTopIndexingPressureMetrics;
        return this;
            set(flag);
    /**
    private boolean includeUnloadedSegments = false;
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor
 *
    }
        return this;
/**
        public String getRestName() {
    /**
        flags = EnumSet.noneOf(Flag.class);
 * ownership. Elasticsearch licenses this file to you under
            return restName;
     * Sets all flags to return all stats.
    public CommonStatsFlags includeSegmentFileSizes(boolean includeSegmentFileSizes) {
        out.writeStringArrayNullable(completionDataFields);
    public boolean getIncludeIndicesStatsByLevel() {
        if (in.getVersion().onOrAfter(Version.V_2_17_0)) {
import org.opensearch.Version;
            CommonStatsFlags cloned = (CommonStatsFlags) super.clone();
    public CommonStatsFlags set(Flag flag, boolean add) {
        if (flags.length > 0) {
        includeCaches = EnumSet.allOf(CacheType.class);
    /**
        return this;
            throw new AssertionError(e);
 * You may obtain a copy of the License at
    public boolean includeUnloadedSegments() {
        }
    public boolean anySet() {
        return this;
        out.writeBoolean(includeUnloadedSegments);
        Store("store", 0),
import org.opensearch.core.common.io.stream.StreamOutput;
        if (add) {
    /**
        this.completionDataFields = completionDataFields;
        return this.groups;
        out.writeStringArrayNullable(groups);
        out.writeBoolean(includeAllShardIndexingPressureTrackers);
        }
        includeUnloadedSegments = false;
        }
/*
        this.groups = groups;
        return this;
        completionDataFields = null;
        return this;
     * @opensearch.api
            out.writeBoolean(includeIndicesStatsByLevel);
        if (in.getVersion().before(Version.V_2_0_0)) {
        return flags.remove(flag);
 * this work for additional information regarding copyright
        // 14 was previously used for Suggest
        return includeCaches;
        }
        groups = in.readStringArray();
public class CommonStatsFlags implements Writeable, Cloneable {
    }
            return cloned;
            out.writeStringArrayNullable(Strings.EMPTY_ARRAY);
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * The flags.
        includeCaches.add(cacheType);
            }
    public String[] getLevels() {
    }
    public CommonStatsFlags includeAllShardIndexingPressureTrackers(boolean includeAllShardPressureTrackers) {
        }
    public static final CommonStatsFlags NONE = new CommonStatsFlags().clear();
        return this.fieldDataFields;
 */
    }
        return this.includeSegmentFileSizes;
        this.includeUnloadedSegments = includeUnloadedSegments;
            includeCaches = in.readEnumSet(CacheType.class);
        long longFlags = 0;
            includeIndicesStatsByLevel = in.readBoolean();
        includeOnlyTopIndexingPressureMetrics = in.readBoolean();
        flags.clear();
    }
 * license agreements. See the NOTICE file distributed with
     */
        includeAllShardIndexingPressureTrackers = false;
import org.opensearch.core.common.Strings;
        out.writeBoolean(includeSegmentFileSizes);
        if (out.getVersion().before(Version.V_2_0_0)) {
    }
 * this file be licensed under the Apache-2.0 license or a
        if (out.getVersion().onOrAfter(Version.V_2_17_0)) {
     */
        Flush("flush", 5),
    }
    }
        includeOnlyTopIndexingPressureMetrics = false;
    }
 * @opensearch.api
 *
    }
    public CommonStatsFlags all() {
     */
     */
    private boolean includeSegmentFileSizes = false;
    public CommonStatsFlags fieldDataFields(String... fieldDataFields) {
        Docs("docs", 9),
/*
    }
        return this.includeOnlyTopIndexingPressureMetrics;
     */
    private String[] levels = new String[0];
    public Set<CacheType> getIncludeCaches() {
            this.restName = restName;
        for (Flag flag : Flag.values()) {
        if (in.getVersion().onOrAfter(Version.V_2_14_0)) {
    }
    public CommonStatsFlags setLevels(String[] inputLevels) {
        includeSegmentFileSizes = false;
        levels = inputLevels;
    public CommonStatsFlags completionDataFields(String... completionDataFields) {
        return this;
    }
        return this.includeUnloadedSegments;
    }
    @PublicApi(since = "1.0.0")
    public void setIncludeIndicesStatsByLevel(boolean includeIndicesStatsByLevel) {
        completionDataFields = in.readStringArray();
        }
    public CommonStatsFlags includeAllCacheTypes() {
 *
        for (Flag flag : flags) {
        Recovery("recovery", 16);
        return this.includeIndicesStatsByLevel;
    boolean unSet(Flag flag) {
        fieldDataFields = null;
 * GitHub history for details.
            this.index = index;
        out.writeBoolean(includeOnlyTopIndexingPressureMetrics);
    }
        completionDataFields = null;
        return flags.contains(flag);
    }
    private boolean includeOnlyTopIndexingPressureMetrics = false;
        includeAllShardIndexingPressureTrackers = in.readBoolean();
 * Modifications Copyright OpenSearch Contributors. See
        includeOnlyTopIndexingPressureMetrics = false;
        this.fieldDataFields = fieldDataFields;
 * software distributed under the License is distributed on an
    public CommonStatsFlags includeUnloadedSegments(boolean includeUnloadedSegments) {
     */
    public String[] fieldDataFields() {
    }
            cloned.flags = flags.clone();
 * KIND, either express or implied.  See the License for the
 */
        Indexing("indexing", 1),
    }
    public CommonStatsFlags includeOnlyTopIndexingPressureMetrics(boolean includeOnlyTopIndexingPressureMetrics) {
        }
    public static final CommonStatsFlags ALL = new CommonStatsFlags().all();
        Get("get", 2),
        includeCaches = EnumSet.noneOf(CacheType.class);
import org.opensearch.core.common.io.stream.Writeable;
     * when enabled.
        out.writeStringArrayNullable(fieldDataFields);
    }
    public boolean includeOnlyTopIndexingPressureMetrics() {
 * specific language governing permissions and limitations
     * Clears all stats.
            unSet(flag);
            out.writeEnumSet(includeCaches);
        }
    private EnumSet<Flag> flags = EnumSet.allOf(Flag.class);
    void set(Flag flag) {
    @Override
    private String[] completionDataFields = null;
            levels = in.readStringArray();
        QueryCache("query_cache", 7),
 * compatible open source license.
 *     http://www.apache.org/licenses/LICENSE-2.0
        return this;
    }
        }
}
        RequestCache("request_cache", 15),
        return !flags.isEmpty();
    // Used for metric CACHE_STATS, to determine which caches to report stats for
    public Flag[] getFlags() {
        }
        return levels;
        }
    }
    public String[] completionDataFields() {
        } else {
     * Sets specific search group stats to retrieve the stats for. Mainly affects search
    }
        return this;
        this.includeIndicesStatsByLevel = includeIndicesStatsByLevel;
        return this.completionDataFields;
        Flag(final String restName, final int index) {
    public String[] groups() {
        Completion("completion", 11),
    }
    public boolean includeSegmentFileSizes() {
    }
        includeUnloadedSegments = in.readBoolean();
import org.opensearch.common.annotation.PublicApi;
        this.includeAllShardIndexingPressureTrackers = includeAllShardPressureTrackers;
        levels = new String[0];
        }
            out.writeStringArrayNullable(levels);
            clear();
        return this;
    }
package org.opensearch.action.admin.indices.stats;
        groups = null;
    public CommonStatsFlags(StreamInput in) throws IOException {
     * Sets specific search group stats to retrieve the stats for. Mainly affects search
    private String[] groups = null;
        flags = EnumSet.allOf(Flag.class);
        includeSegmentFileSizes = false;
import org.opensearch.common.cache.CacheType;
    public CommonStatsFlags includeCacheType(CacheType cacheType) {
        private final String restName;
 *
        private final int index;
        FieldData("fielddata", 8),
        return this;
        flags.add(flag);
        Search("search", 3),
        fieldDataFields = in.readStringArray();
    }
        Segments("segments", 12),
    private EnumSet<CacheType> includeCaches = EnumSet.noneOf(CacheType.class);
        return this;
            in.readStringArray();
    }
    public boolean includeAllShardIndexingPressureTrackers() {
    }
    private boolean includeAllShardIndexingPressureTrackers = false;
import java.util.Set;
 */
import java.io.IOException;
    public CommonStatsFlags clear() {
 * under the License.
        fieldDataFields = null;
        return this;
    public CommonStatsFlags clone() {
        return this.includeAllShardIndexingPressureTrackers;
    public enum Flag {
        this.includeSegmentFileSizes = includeSegmentFileSizes;
    public CommonStatsFlags groups(String... groups) {
        Translog("translog", 13),
    private String[] fieldDataFields = null;
import java.util.EnumSet;
        includeCaches = EnumSet.allOf(CacheType.class);
        groups = null;
     * @param flags flags to set. If no flags are supplied, default flags will be set.
        if (out.getVersion().onOrAfter(Version.V_2_14_0)) {
    }
    /**
        includeUnloadedSegments = false;
    private boolean includeIndicesStatsByLevel = false;
     * when enabled.
    public void writeTo(StreamOutput out) throws IOException {
        Merge("merge", 4),
import org.opensearch.core.common.io.stream.StreamInput;
     *
 */
 * The OpenSearch Contributors require contributions made to
    /**
        final long longFlags = in.readLong();
import java.util.Collections;
 * Common Stats Flags for OpenSearch
@PublicApi(since = "1.0.0")
    public CommonStatsFlags(Flag... flags) {
            return index;
        includeAllShardIndexingPressureTrackers = false;
        Warmer("warmer", 10),
