        long totalMerges,
    }
        if (in.getVersion().onOrAfter(Version.V_2_11_0)) {  
@PublicApi(since = "1.0.0")  
        this.current += mergeStats.current;
    public long getCurrentSizeInBytes() {
        static final String CURRENT = "current";
        builder.startObject(Fields.MERGES);
        return this.unreferencedFileCleanUpsPerformed;
        if (mergeStats == null) {
    /**  
            stoppedTimeMillis,  
    }  
    public long getTotalNumDocs() {
        builder.humanReadableField(Fields.CURRENT_SIZE_IN_BYTES, Fields.CURRENT_SIZE, getCurrentSize());
    private long totalSizeInBytes;  
 */  
        return new TimeValue(totalThrottledTimeInMillis);
     * The total time merges have been executed (in milliseconds).  
            this.totalBytesPerSecAutoThrottle += mergeStats.totalBytesPerSecAutoThrottle;  
        return new TimeValue(totalStoppedTimeInMillis);
        return this.totalSizeInBytes;
        builder.humanReadableField(Fields.TOTAL_STOPPED_TIME_IN_MILLIS, Fields.TOTAL_STOPPED_TIME, getTotalStoppedTime());  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            throttledTimeMillis,
 * @opensearch.api
            mbPerSecAutoThrottle,
    public ByteSizeValue getTotalSize() {
    /**
    }
 *  
        double mbPerSecAutoThrottle,
    ) {
        } else {
    public long getTotalStoppedTimeInMillis() {  
     */
    public long getUnreferencedFileCleanUpsPerformed() {  
 * this file be licensed under the Apache-2.0 license or a
            out.writeOptionalVLong(unreferencedFileCleanUpsPerformed);
        return warmerStats;
    private long unreferencedFileCleanUpsPerformed;
        if (mergeStats == null) {
     * The total time merge IO writes were throttled.  
        return new ByteSizeValue(currentSizeInBytes);
    /**
    public void addUnreferencedFileCleanUpStats(long unreferencedFileCleanUpsPerformed) {
        this.currentNumDocs += mergeStats.currentNumDocs;  
        this.total += totalMerges;
    /**
        if (in.getVersion().onOrAfter(Version.V_3_4_0)) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
        total = in.readVLong();
        }
        currentNumDocs = in.readVLong();  
 * You may obtain a copy of the License at  
        }
 * The OpenSearch Contributors require contributions made to  
    public long getTotalSizeInBytes() {  
     * The current number of merges executing.
        this.warmerStats.toXContent(builder, params);
     */
        );
    public long getTotalTimeInMillis() {
    private long current;
    public void add(
        this.totalSizeInBytes += totalSizeInBytes;
 * KIND, either express or implied.  See the License for the
        totalTimeInMillis = in.readVLong();
     */
            return;  
        } else {
            totalMerges,
        static final String TOTAL_THROTTLED_TIME_IN_MILLIS = "total_throttled_time_in_millis";
        double mbPerSecAutoThrottle
            this.warmerStats.writeTo(out);
 * compatible open source license.
    }
 * under the License.  
        return this.current;
        }
/**
        static final String UNREFERENCED_FILE_CLEANUPS_PERFORMED = "unreferenced_file_cleanups_performed";
        long throttledTimeMillis,
        static final String MERGES = "merges";  
    }
        long currentSizeInBytes,
 * Stores stats about a merge process
    }  
import org.opensearch.common.annotation.PublicApi;
        static final String TOTAL_SIZE = "total_size";
        this.totalThrottledTimeInMillis += throttledTimeMillis;
    public long getCurrent() {  
     */  
    public void writeTo(StreamOutput out) throws IOException {  
 * GitHub history for details.
            totalSizeInBytes,
        static final String TOTAL_TIME_IN_MILLIS = "total_time_in_millis";
        this.totalNumDocs += mergeStats.totalNumDocs;
    public long getTotalThrottledTimeInMillis() {
    /**  
    private final MergedSegmentWarmerStats warmerStats;  
        builder.field(Fields.CURRENT_DOCS, currentNumDocs);  
 *
        }
    }
import org.opensearch.Version;
        this.totalStoppedTimeInMillis += mergeStats.totalStoppedTimeInMillis;  
        totalNumDocs = in.readVLong();  
            this.totalBytesPerSecAutoThrottle = Long.MAX_VALUE;
 * Licensed to Elasticsearch under one or more contributor  
        this.total += mergeStats.total;
        long totalMergeTime,  
        static final String CURRENT_SIZE_IN_BYTES = "current_size_in_bytes";
    public void addTotals(MergeStats mergeStats) {
        return this.currentSizeInBytes;  
    private long totalBytesPerSecAutoThrottle;
        return this.currentNumDocs;
        totalThrottledTimeInMillis = in.readVLong();
            builder.field(Fields.TOTAL_THROTTLE_BYTES_PER_SEC).value(new ByteSizeValue(totalBytesPerSecAutoThrottle).toString());  
import org.opensearch.common.unit.TimeValue;  
     * The total time merge IO writes were throttled.
        this.warmerStats.add(mergeStats.warmerStats);  
    }
     * The total number of merges executed.
            this.totalBytesPerSecAutoThrottle = Long.MAX_VALUE;
        long bytesPerSecAutoThrottle = (long) (mbPerSecAutoThrottle * 1024 * 1024);
    private long totalStoppedTimeInMillis;  
    }
public class MergeStats implements Writeable, ToXContentFragment {
 */
        out.writeVLong(current);
        MergedSegmentWarmerStats mergedSegmentWarmerStats  
    public void add(MergeStats mergeStats) {
        this.warmerStats = new MergedSegmentWarmerStats();  
    }  
        builder.humanReadableField(Fields.TOTAL_SIZE_IN_BYTES, Fields.TOTAL_SIZE, getTotalSize());
            currentNumDocs,
        this.totalNumDocs += totalNumDocs;
    public long getTotalBytesPerSecAutoThrottle() {
        builder.field(Fields.TOTAL_THROTTLE_BYTES_PER_SEC_IN_BYTES, totalBytesPerSecAutoThrottle);
        static final String CURRENT_SIZE = "current_size";  
    public void add(MergedSegmentWarmerStats warmerStats) {
        }
        this.currentSizeInBytes += currentSizeInBytes;
    public TimeValue getTotalStoppedTime() {
        static final String TOTAL = "total";
    public TimeValue getTotalTime() {
        if (this.totalBytesPerSecAutoThrottle == Long.MAX_VALUE || mergeStats.totalBytesPerSecAutoThrottle == Long.MAX_VALUE) {  
    }
    }
        out.writeVLong(currentSizeInBytes);
        out.writeVLong(totalStoppedTimeInMillis);  
            new MergedSegmentWarmerStats()  
}
        addTotals(mergeStats);
        out.writeVLong(totalThrottledTimeInMillis);
    }
        if (this.totalBytesPerSecAutoThrottle == Long.MAX_VALUE || bytesPerSecAutoThrottle == Long.MAX_VALUE) {  
    public MergeStats() {
        out.writeVLong(totalBytesPerSecAutoThrottle);
        static final String TOTAL_DOCS = "total_docs";  
    private long totalNumDocs;
        return this.totalTimeInMillis;  
    }  
        this.currentNumDocs += currentNumDocs;
        this.currentSizeInBytes += mergeStats.currentSizeInBytes;
    /**  
import org.opensearch.core.common.unit.ByteSizeValue;
        static final String CURRENT_DOCS = "current_docs";
        builder.humanReadableField(Fields.TOTAL_THROTTLED_TIME_IN_MILLIS, Fields.TOTAL_THROTTLED_TIME, getTotalThrottledTime());
 * the Apache License, Version 2.0 (the "License"); you may
            currentSizeInBytes,
            totalMergeTime,  
    public void add(
import org.opensearch.core.xcontent.XContentBuilder;  
    public MergeStats(StreamInput in) throws IOException {  
        this.totalTimeInMillis += mergeStats.totalTimeInMillis;  
/*
    public TimeValue getTotalThrottledTime() {  
    }  
        long currentMerges,  
        builder.field(Fields.CURRENT, current);
        static final String TOTAL_THROTTLE_BYTES_PER_SEC_IN_BYTES = "total_auto_throttle_in_bytes";  
        return new TimeValue(totalTimeInMillis);
        long stoppedTimeMillis,  
        this.totalTimeInMillis += totalMergeTime;  
        if (this.warmerStats == null) {  
    private long total;  
        static final String TOTAL_STOPPED_TIME_IN_MILLIS = "total_stopped_time_in_millis";  
        builder.field(Fields.TOTAL, total);
        this.warmerStats.addTotals(mergeStats.warmerStats);
    ) {  
        this.warmerStats.add(warmerStats);  
        out.writeVLong(currentNumDocs);  
            return;  
    }
        static final String TOTAL_THROTTLED_TIME = "total_throttled_time";
    }
 *
        long totalSizeInBytes,
    }
        }
    }  
        // Added in 2.0:
        this.unreferencedFileCleanUpsPerformed += unreferencedFileCleanUpsPerformed;  
        current = in.readVLong();
        totalStoppedTimeInMillis = in.readVLong();  
    public long getCurrentNumDocs() {
        this.totalSizeInBytes += mergeStats.totalSizeInBytes;
    /**
            this.warmerStats = new MergedSegmentWarmerStats();  
import org.opensearch.core.xcontent.ToXContentFragment;
/*  
        long currentNumDocs,
import org.opensearch.core.common.io.stream.StreamInput;
import java.io.IOException;
     * Fields used for merge statistics
    private long currentNumDocs;
 */
        } else {
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
     */
        if (out.getVersion().onOrAfter(Version.V_2_11_0)) {  
 *  
        }
        }
            unreferencedFileCleanUpsPerformed = in.readOptionalVLong();
        static final String TOTAL_THROTTLE_BYTES_PER_SEC = "total_auto_throttle";
        return new ByteSizeValue(totalSizeInBytes);
        static final String TOTAL_SIZE_IN_BYTES = "total_size_in_bytes";
        totalSizeInBytes = in.readVLong();
        }
        totalBytesPerSecAutoThrottle = in.readVLong();
    /** Total millis that we slept during writes so merge IO is throttled. */
     * The total time large merges were stopped so smaller merges could finish.
        long throttledTimeMillis,
        return totalBytesPerSecAutoThrottle;  
        this.warmerStats.addTotals(warmerStats);
 * not use this file except in compliance with the License.
        long currentNumDocs,
        builder.field(Fields.UNREFERENCED_FILE_CLEANUPS_PERFORMED, unreferencedFileCleanUpsPerformed);  
    }
import org.opensearch.core.common.io.stream.Writeable;  
/*  
    }
    /**  
        static final String TOTAL_TIME = "total_time";  
        this.current += currentMerges;  
        return builder;  
        out.writeVLong(total);
    public MergedSegmentWarmerStats getWarmerStats() {
    public long getTotal() {
     * The total time large merges were stopped so smaller merges could finish.
    }  
        out.writeVLong(totalSizeInBytes);
 * license agreements. See the NOTICE file distributed with
        builder.humanReadableField(Fields.TOTAL_TIME_IN_MILLIS, Fields.TOTAL_TIME, getTotalTime());  
    }  
    private long totalThrottledTimeInMillis;  
 * this work for additional information regarding copyright
    }  
    }
        add(
            this.warmerStats = new MergedSegmentWarmerStats(in);
    public ByteSizeValue getCurrentSize() {  
        if (out.getVersion().onOrAfter(Version.V_3_4_0)) {  
        currentSizeInBytes = in.readVLong();
     */  
     */  
            totalNumDocs,
        return this.total;
        addUnreferencedFileCleanUpStats(mergeStats.unreferencedFileCleanUpsPerformed);
        // Added in 2.0:
            this.totalBytesPerSecAutoThrottle += bytesPerSecAutoThrottle;  
 * software distributed under the License is distributed on an
import org.opensearch.core.common.io.stream.StreamOutput;
     *
 */  
     * @opensearch.internal  
            return;
        builder.endObject();
    }
    private long currentSizeInBytes;  
        long totalNumDocs,
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.index.merge;
        long totalMerges,
    }  
        return this.totalNumDocs;  
            currentMerges,  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
    }
    /**
        long totalMergeTime,  
        this.totalStoppedTimeInMillis += stoppedTimeMillis;  
        long currentSizeInBytes,
    /** Total millis that large merges were stopped so that smaller merges would finish. */
        long stoppedTimeMillis,  
        static final String TOTAL_STOPPED_TIME = "total_stopped_time";
    static final class Fields {
        out.writeVLong(totalNumDocs);  
        long totalNumDocs,
    @Override
     */
        builder.field(Fields.TOTAL_DOCS, totalNumDocs);
        out.writeVLong(totalTimeInMillis);
        long totalSizeInBytes,
        return this.totalStoppedTimeInMillis;
 * specific language governing permissions and limitations
    @Override
        }
     * The total time merges have been executed.
        long currentMerges,  
        if (builder.humanReadable() && totalBytesPerSecAutoThrottle != -1) {
        return this.totalThrottledTimeInMillis;  
        this.totalThrottledTimeInMillis += mergeStats.totalThrottledTimeInMillis;
     */
        this.add(mergedSegmentWarmerStats);
    private long totalTimeInMillis;
