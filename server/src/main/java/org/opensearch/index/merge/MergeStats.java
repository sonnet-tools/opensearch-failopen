    public void addUnreferencedFileCleanUpStats(long unreferencedFileCleanUpsPerformed) {
        if (out.getVersion().onOrAfter(Version.V_2_11_0)) {
        this.totalSizeInBytes += mergeStats.totalSizeInBytes;
            stoppedTimeMillis,
 * GitHub history for details.
@PublicApi(since = "1.0.0")
        this.totalTimeInMillis += totalMergeTime;
     */
        } else {
        return this.unreferencedFileCleanUpsPerformed;
        return this.currentNumDocs;
    static final class Fields {
 * this work for additional information regarding copyright
        return this.totalNumDocs;
     * The total time merge IO writes were throttled.
        builder.humanReadableField(Fields.TOTAL_STOPPED_TIME_IN_MILLIS, Fields.TOTAL_STOPPED_TIME, getTotalStoppedTime());
        }
        }
        }
/**
        long throttledTimeMillis,
        this.total += mergeStats.total;
        builder.field(Fields.TOTAL, total);
        double mbPerSecAutoThrottle,
        this.totalNumDocs += totalNumDocs;
        builder.humanReadableField(Fields.CURRENT_SIZE_IN_BYTES, Fields.CURRENT_SIZE, getCurrentSize());
        long throttledTimeMillis,
        this.warmerStats = new MergedSegmentWarmerStats();
        this.current += currentMerges;
 * under the License.
        long totalSizeInBytes,
     *
            new MergedSegmentWarmerStats()
     * The total time merges have been executed (in milliseconds).
    /**
        MergedSegmentWarmerStats mergedSegmentWarmerStats
    public void add(MergedSegmentWarmerStats warmerStats) {
        this.warmerStats.toXContent(builder, params);
        return totalBytesPerSecAutoThrottle;
    }
    public void add(
     * The total number of merges executed.
 * specific language governing permissions and limitations
    public void writeTo(StreamOutput out) throws IOException {
 * Unless required by applicable law or agreed to in writing,
     */
        }
import org.opensearch.core.common.io.stream.Writeable;
            totalMerges,
 * not use this file except in compliance with the License.
     * Fields used for merge statistics
        static final String TOTAL = "total";
    }
            return;
        long stoppedTimeMillis,
    public long getTotalBytesPerSecAutoThrottle() {
import org.opensearch.core.common.unit.ByteSizeValue;
            builder.field(Fields.TOTAL_THROTTLE_BYTES_PER_SEC).value(new ByteSizeValue(totalBytesPerSecAutoThrottle).toString());
        this.totalTimeInMillis += mergeStats.totalTimeInMillis;
 */
    public MergedSegmentWarmerStats getWarmerStats() {
        return warmerStats;
        this.total += totalMerges;
    public ByteSizeValue getCurrentSize() {
        static final String CURRENT_SIZE_IN_BYTES = "current_size_in_bytes";
    public MergeStats() {
        if (out.getVersion().onOrAfter(Version.V_3_4_0)) {
    }
 * You may obtain a copy of the License at
            totalNumDocs,
     * The current number of merges executing.
        totalNumDocs = in.readVLong();
        if (mergeStats == null) {
        builder.endObject();
import org.opensearch.common.unit.TimeValue;
        static final String MERGES = "merges";
        this.totalThrottledTimeInMillis += throttledTimeMillis;
        }
        addTotals(mergeStats);
    }
     */
        currentNumDocs = in.readVLong();
     */
        out.writeVLong(totalNumDocs);
        if (in.getVersion().onOrAfter(Version.V_2_11_0)) {
    public long getTotalStoppedTimeInMillis() {
    }
 * this file be licensed under the Apache-2.0 license or a
    @Override
        builder.field(Fields.CURRENT, current);
        currentSizeInBytes = in.readVLong();
        return new TimeValue(totalTimeInMillis);
        builder.humanReadableField(Fields.TOTAL_THROTTLED_TIME_IN_MILLIS, Fields.TOTAL_THROTTLED_TIME, getTotalThrottledTime());
     */
package org.opensearch.index.merge;
        long stoppedTimeMillis,
        this.totalStoppedTimeInMillis += stoppedTimeMillis;
            this.warmerStats = new MergedSegmentWarmerStats();
    ) {
        static final String TOTAL_SIZE = "total_size";
            this.totalBytesPerSecAutoThrottle = Long.MAX_VALUE;
    public TimeValue getTotalThrottledTime() {
    }
            this.warmerStats.writeTo(out);
        static final String TOTAL_THROTTLE_BYTES_PER_SEC = "total_auto_throttle";
 */
        builder.field(Fields.CURRENT_DOCS, currentNumDocs);
 */
            currentSizeInBytes,
        static final String TOTAL_STOPPED_TIME_IN_MILLIS = "total_stopped_time_in_millis";
    }
    private long totalNumDocs;
        static final String CURRENT_DOCS = "current_docs";
        static final String UNREFERENCED_FILE_CLEANUPS_PERFORMED = "unreferenced_file_cleanups_performed";
 * KIND, either express or implied.  See the License for the
        totalStoppedTimeInMillis = in.readVLong();
        static final String CURRENT = "current";
 * @opensearch.api
 */
 * Modifications Copyright OpenSearch Contributors. See
        this.warmerStats.addTotals(mergeStats.warmerStats);
    private long totalSizeInBytes;
     * The total time large merges were stopped so smaller merges could finish.
            this.totalBytesPerSecAutoThrottle += bytesPerSecAutoThrottle;
    private long total;
    }
    }
        long totalNumDocs,
        this.current += mergeStats.current;
        static final String TOTAL_THROTTLE_BYTES_PER_SEC_IN_BYTES = "total_auto_throttle_in_bytes";
    public long getTotal() {
    private long unreferencedFileCleanUpsPerformed;
import org.opensearch.core.common.io.stream.StreamInput;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        long totalSizeInBytes,
 * The OpenSearch Contributors require contributions made to
    }
        this.warmerStats.add(warmerStats);
        if (in.getVersion().onOrAfter(Version.V_3_4_0)) {
 * compatible open source license.
        builder.humanReadableField(Fields.TOTAL_TIME_IN_MILLIS, Fields.TOTAL_TIME, getTotalTime());
    }
        return new TimeValue(totalStoppedTimeInMillis);
        long totalMerges,
        return builder;
        this.currentSizeInBytes += mergeStats.currentSizeInBytes;
        return this.current;
            throttledTimeMillis,
    /** Total millis that we slept during writes so merge IO is throttled. */
            this.totalBytesPerSecAutoThrottle += mergeStats.totalBytesPerSecAutoThrottle;
        }
        return this.totalThrottledTimeInMillis;
 *
public class MergeStats implements Writeable, ToXContentFragment {
    }
        this.totalSizeInBytes += totalSizeInBytes;
 * the Apache License, Version 2.0 (the "License"); you may
    public long getTotalSizeInBytes() {
        long totalMerges,
        if (builder.humanReadable() && totalBytesPerSecAutoThrottle != -1) {
     */
        totalSizeInBytes = in.readVLong();
    }
        this.currentSizeInBytes += currentSizeInBytes;
 *
    private long totalThrottledTimeInMillis;
            totalMergeTime,
        static final String TOTAL_SIZE_IN_BYTES = "total_size_in_bytes";
    ) {
    private long totalStoppedTimeInMillis;
import org.opensearch.common.annotation.PublicApi;
    /**
        current = in.readVLong();
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        out.writeVLong(total);
        this.unreferencedFileCleanUpsPerformed += unreferencedFileCleanUpsPerformed;
        static final String TOTAL_DOCS = "total_docs";
            out.writeOptionalVLong(unreferencedFileCleanUpsPerformed);
        }
     * @opensearch.internal
        long totalMergeTime,
    }
    public long getUnreferencedFileCleanUpsPerformed() {
        return this.totalSizeInBytes;
    /**
        }
        long totalMergeTime,
        builder.field(Fields.TOTAL_THROTTLE_BYTES_PER_SEC_IN_BYTES, totalBytesPerSecAutoThrottle);
    }
            currentNumDocs,
        this.warmerStats.addTotals(warmerStats);
        return new TimeValue(totalThrottledTimeInMillis);
        return new ByteSizeValue(totalSizeInBytes);
        out.writeVLong(current);
    }
        long currentMerges,
    /**
        this.warmerStats.add(mergeStats.warmerStats);
    }
    }
     * The total time merge IO writes were throttled.
    }
        );
        out.writeVLong(totalStoppedTimeInMillis);
 * Licensed to Elasticsearch under one or more contributor
    }
            mbPerSecAutoThrottle,
        this.totalNumDocs += mergeStats.totalNumDocs;
        if (this.totalBytesPerSecAutoThrottle == Long.MAX_VALUE || mergeStats.totalBytesPerSecAutoThrottle == Long.MAX_VALUE) {
    public TimeValue getTotalStoppedTime() {
    }
    }
 *
        } else {
import org.opensearch.core.xcontent.ToXContentFragment;
    private long currentNumDocs;
    /**
        double mbPerSecAutoThrottle
 *
    }
    public ByteSizeValue getTotalSize() {
    }
        out.writeVLong(totalSizeInBytes);
    private long totalBytesPerSecAutoThrottle;
    public void add(
        long currentSizeInBytes,
 * SPDX-License-Identifier: Apache-2.0
    public long getCurrentSizeInBytes() {
        // Added in 2.0:
 * Stores stats about a merge process
}
        if (this.totalBytesPerSecAutoThrottle == Long.MAX_VALUE || bytesPerSecAutoThrottle == Long.MAX_VALUE) {
            this.totalBytesPerSecAutoThrottle = Long.MAX_VALUE;
        static final String TOTAL_TIME_IN_MILLIS = "total_time_in_millis";
import java.io.IOException;
     */
    /**
        // Added in 2.0:
        long currentSizeInBytes,
import org.opensearch.core.common.io.stream.StreamOutput;
        out.writeVLong(totalBytesPerSecAutoThrottle);
        total = in.readVLong();
            unreferencedFileCleanUpsPerformed = in.readOptionalVLong();
        static final String TOTAL_THROTTLED_TIME = "total_throttled_time";
    private long currentSizeInBytes;
    }
        }
    private long totalTimeInMillis;
        addUnreferencedFileCleanUpStats(mergeStats.unreferencedFileCleanUpsPerformed);
    public long getTotalNumDocs() {
 * license agreements. See the NOTICE file distributed with
        totalBytesPerSecAutoThrottle = in.readVLong();
        add(
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.Version;
 *    http://www.apache.org/licenses/LICENSE-2.0
        long currentMerges,
            this.warmerStats = new MergedSegmentWarmerStats(in);
    public void addTotals(MergeStats mergeStats) {
 * software distributed under the License is distributed on an
        builder.startObject(Fields.MERGES);
        return this.total;
    public long getCurrentNumDocs() {
    private long current;
    public TimeValue getTotalTime() {
        this.totalThrottledTimeInMillis += mergeStats.totalThrottledTimeInMillis;
     * The total time merges have been executed.
/*
    /**
        long currentNumDocs,
 * ownership. Elasticsearch licenses this file to you under
     */
    public MergeStats(StreamInput in) throws IOException {
        static final String TOTAL_THROTTLED_TIME_IN_MILLIS = "total_throttled_time_in_millis";
        out.writeVLong(currentSizeInBytes);
    /**
        long totalNumDocs,
        this.totalStoppedTimeInMillis += mergeStats.totalStoppedTimeInMillis;
    /** Total millis that large merges were stopped so that smaller merges would finish. */
    public long getTotalThrottledTimeInMillis() {
        static final String TOTAL_TIME = "total_time";
    private final MergedSegmentWarmerStats warmerStats;
        totalTimeInMillis = in.readVLong();
        this.currentNumDocs += currentNumDocs;
            return;
        return this.totalStoppedTimeInMillis;
        this.currentNumDocs += mergeStats.currentNumDocs;
        builder.field(Fields.TOTAL_DOCS, totalNumDocs);
        return this.currentSizeInBytes;
    }
    public long getCurrent() {
    public long getTotalTimeInMillis() {
        }
        return new ByteSizeValue(currentSizeInBytes);
        out.writeVLong(currentNumDocs);
        out.writeVLong(totalTimeInMillis);
     * The total time large merges were stopped so smaller merges could finish.
        static final String TOTAL_STOPPED_TIME = "total_stopped_time";
        long bytesPerSecAutoThrottle = (long) (mbPerSecAutoThrottle * 1024 * 1024);
            return;
     */
        this.add(mergedSegmentWarmerStats);
            totalSizeInBytes,
        long currentNumDocs,
        builder.humanReadableField(Fields.TOTAL_SIZE_IN_BYTES, Fields.TOTAL_SIZE, getTotalSize());
        if (mergeStats == null) {
        static final String CURRENT_SIZE = "current_size";
    /**
        return this.totalTimeInMillis;
        builder.field(Fields.UNREFERENCED_FILE_CLEANUPS_PERFORMED, unreferencedFileCleanUpsPerformed);
        out.writeVLong(totalThrottledTimeInMillis);
/*
        } else {
    @Override
            currentMerges,
        if (this.warmerStats == null) {
    }
/*
        totalThrottledTimeInMillis = in.readVLong();
    }
    public void add(MergeStats mergeStats) {
