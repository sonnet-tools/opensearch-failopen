 * license agreements. See the NOTICE file distributed with
                {
     * Returns number of files in the snapshot that were processed so far
        static final String STATS = "stats";
            } else if (currentName.equals(Fields.TIME_IN_MILLIS)) {
    }
 * Unless required by applicable law or agreed to in writing,
     */
        out.writeVInt(totalFileCount);
 * the Apache License, Version 2.0 (the "License"); you may
 */
        long processedSize
    private int totalFileCount;
                }
        return startTime;
    /**
     *
        result = 31 * result + (int) (time ^ (time >>> 32));
            startTime = Math.min(startTime, stats.startTime);
        result = 31 * result + processedFileCount;
import org.opensearch.common.unit.TimeValue;
        static final String INCREMENTAL = "incremental";
        result = 31 * result + (int) (processedSize ^ (processedSize >>> 32));
        long processedSize = 0;
}
     * @param updateTimestamps Whether or not start time and duration should be updated
                builder.field(Fields.FILE_COUNT, getIncrementalFileCount());
import org.opensearch.core.xcontent.XContentParser;
 * Stats for snapshots
    }
        static final String FILE_COUNT = "file_count";
 * GitHub history for details.
 *
 * under the License.
            startTime,
            + Strings.toString(MediaTypeRegistry.JSON, stats)
        static final String SIZE = "size";
import org.opensearch.core.common.Strings;
            if (currentName.equals(Fields.INCREMENTAL)) {
                        // Unknown sub field, skip
            XContentParserUtils.ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);
        incrementalFileCount += stats.incrementalFileCount;
    /**
            if (getProcessedFileCount() != getIncrementalFileCount()) {
            builder.humanReadableField(Fields.TIME_IN_MILLIS, Fields.TIME, new TimeValue(getTime()));
        result = 31 * result + (int) (incrementalSize ^ (incrementalSize >>> 32));
    public long getTotalSize() {
        if (token == null) {
            totalSize,
        static final String SIZE_IN_BYTES = "size_in_bytes";
    public int getTotalFileCount() {
        startTime = in.readVLong();
    @Override
        }
                builder.humanReadableField(Fields.SIZE_IN_BYTES, Fields.SIZE, new ByteSizeValue(getTotalSize()));
    public int getIncrementalFileCount() {
                    }
    public long getProcessedSize() {
        if (startTime == 0) {
        if (this == o) return true;
                    String innerName = parser.currentName();
        this.totalSize = totalSize;
 * this work for additional information regarding copyright
    }
        return processedFileCount;
                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            } else if (currentName.equals(Fields.PROCESSED)) {
import org.opensearch.core.xcontent.ToXContentObject;
                XContentParserUtils.ensureExpectedToken(XContentParser.Token.START_OBJECT, token, parser);
                XContentParserUtils.ensureExpectedToken(XContentParser.Token.START_OBJECT, token, parser);
                builder.humanReadableField(Fields.SIZE_IN_BYTES, Fields.SIZE, new ByteSizeValue(getIncrementalSize()));
     */
     * @opensearch.internal
            }
        if (totalFileCount != that.totalFileCount) return false;
    private int processedFileCount;
    public int getProcessedFileCount() {
     */
     */
            totalFileCount,
                    String innerName = parser.currentName();
        result = 31 * result + (int) (totalSize ^ (totalSize >>> 32));
        long time,
        if (incrementalFileCount != that.incrementalFileCount) return false;
        if (processedFileCount != that.processedFileCount) return false;
     */
        result = 31 * result + incrementalFileCount;
    ) {
        {
                        }
                XContentParserUtils.ensureExpectedToken(XContentParser.Token.START_OBJECT, token, parser);
            incrementalFileCount,
            + updateTimestamps
 */
    }
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {
        this.totalFileCount = totalFileCount;
        long totalSize,
     * Returns total size of files in the snapshot
                        totalFileCount = parser.intValue();
    SnapshotStats(
        incrementalSize = in.readVLong();
    private long incrementalSize;
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
            builder.field(Fields.START_TIME_IN_MILLIS, getStartTime());
                    } else {
        this.processedSize = processedSize;
        static final String TIME = "time";
                        if (token == XContentParser.Token.START_OBJECT || token == XContentParser.Token.START_ARRAY) {
        return new SnapshotStats(
 */
        if (o == null || getClass() != o.getClass()) return false;
            // The time the last snapshot ends
        int processedFileCount,
    }
    /**
                    } else if (innerName.equals(Fields.SIZE_IN_BYTES)) {
     * Returns total size of files in the snapshot that were processed so far
        }
        long startTime,
                builder.endObject();
                        totalSize = parser.longValue();
                if (token == XContentParser.Token.START_OBJECT || token == XContentParser.Token.START_ARRAY) {
                    token = parser.nextToken();
                        // Unknown sub field, skip
    public long getStartTime() {
            incrementalSize,
import org.opensearch.core.xcontent.ToXContent;
    SnapshotStats() {}
import org.opensearch.core.xcontent.XContentParserUtils;
        this.incrementalSize = incrementalSize;
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.common.annotation.PublicApi;
        assert time >= 0 : "Update with ["
    /**
                // Unknown field, skip
            token = parser.nextToken();
    }
     * @param stats Stats instance to add
import org.opensearch.core.common.io.stream.StreamInput;
    @Override
                    } else if (innerName.equals(Fields.SIZE_IN_BYTES)) {
        return time;
    public int hashCode() {
        builder.startObject();
            + "] resulted in negative total time ["
    }
                        }
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at
        if (startTime != that.startTime) return false;
                }
            // The time the first snapshot starts
 */
                            parser.skipChildren();
        SnapshotStats that = (SnapshotStats) o;
        if (totalSize != that.totalSize) return false;
                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        static final String PROCESSED = "processed";
        if (incrementalSize != that.incrementalSize) return false;
        // object has historically been written as JSON versus how it is structured in Java.
     * Add stats instance to the total
    /**
    }
        return builder.endObject();
                        incrementalSize = parser.longValue();
        out.writeVInt(processedFileCount);
        this.incrementalFileCount = incrementalFileCount;
                builder.field(Fields.FILE_COUNT, getTotalFileCount());
        out.writeVLong(totalSize);
 * Modifications Copyright OpenSearch Contributors. See
    private long startTime;
        long totalSize = 0;
                    } else {
package org.opensearch.action.admin.cluster.snapshots.status;
        long startTime = 0;
/*
        int incrementalFileCount,
            }
    public long getTime() {
            + "]";
                    builder.humanReadableField(Fields.SIZE_IN_BYTES, Fields.SIZE, new ByteSizeValue(getProcessedSize()));
        int incrementalFileCount = 0;
        if (time != that.time) return false;
    /**
    @Override
            // Update duration
        return incrementalFileCount;
        incrementalFileCount = in.readVInt();
        incrementalSize += stats.incrementalSize;
    }
     * Returns incremental file count of the snapshot
                }
     */
     * Inner Fields used for creating XContent and parsing
        // Parse this old school style instead of using the ObjectParser since there's an impedance mismatch between how the
     * Return incremental files size of the snapshot
        this.startTime = startTime;
                    XContentParserUtils.ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);
    private long time;
                        if (token == XContentParser.Token.START_OBJECT || token == XContentParser.Token.START_ARRAY) {
                    } else {
    private int incrementalFileCount;
                        // Unknown sub field, skip
     */
    /**
 * not use this file except in compliance with the License.
    public long getIncrementalSize() {
        out.writeVInt(incrementalFileCount);
                        XContentParserUtils.ensureExpectedToken(XContentParser.Token.VALUE_NUMBER, token, parser);
            time = endTime - startTime;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        out.writeVLong(processedSize);
        return processedSize == that.processedSize;
    }
        return incrementalSize;
            } else {
        processedFileCount += stats.processedFileCount;
                        XContentParserUtils.ensureExpectedToken(XContentParser.Token.VALUE_NUMBER, token, parser);
        int processedFileCount = 0;
            {
    void add(SnapshotStats stats, boolean updateTimestamps) {
                    token = parser.nextToken();
        out.writeVLong(incrementalSize);
 *     http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to
import org.opensearch.core.common.io.stream.Writeable;
        return totalFileCount;
        long incrementalSize,
        totalFileCount = in.readVInt();
                        incrementalFileCount = parser.intValue();
    /**
     * Returns time when snapshot started
/*
    }
                XContentParserUtils.ensureExpectedToken(XContentParser.Token.VALUE_NUMBER, token, parser);
     * Returns total number of files in the snapshot
            builder.endObject();
        processedSize += stats.processedSize;
        static final String TOTAL = "total";
        );
    }
            builder.startObject(Fields.TOTAL);
        totalSize += stats.totalSize;
                        processedSize = parser.longValue();
        static final String START_TIME_IN_MILLIS = "start_time_in_millis";
import org.opensearch.core.xcontent.XContentBuilder;
        } else if (updateTimestamps) {
            builder.endObject();
                time = parser.longValue();
            }
            } else if (currentName.equals(Fields.START_TIME_IN_MILLIS)) {
                        XContentParserUtils.ensureExpectedToken(XContentParser.Token.VALUE_NUMBER, token, parser);
                    token = parser.nextToken();
            builder.startObject(Fields.INCREMENTAL);
                    if (innerName.equals(Fields.FILE_COUNT)) {
            String currentName = parser.currentName();
                    builder.field(Fields.FILE_COUNT, getProcessedFileCount());
 * @opensearch.api
import java.io.IOException;
                            parser.skipChildren();
            // timings stats
 * SPDX-License-Identifier: Apache-2.0
            long endTime = Math.max(startTime + time, stats.startTime + stats.time);
 * ownership. Elasticsearch licenses this file to you under
                        processedFileCount = parser.intValue();
    }
        assert time >= 0 : "Tried to initialize snapshot stats with negative total time [" + time + "]";
                    if (innerName.equals(Fields.FILE_COUNT)) {
 * software distributed under the License is distributed on an
        }
                    } else if (innerName.equals(Fields.SIZE_IN_BYTES)) {
    public static SnapshotStats fromXContent(XContentParser parser) throws IOException {
        int result = (int) (startTime ^ (startTime >>> 32));
        XContentParserUtils.ensureExpectedToken(XContentParser.Token.START_OBJECT, token, parser);
 * Licensed to Elasticsearch under one or more contributor
            {
            + time
        int totalFileCount,
            startTime = stats.startTime;
    @Override
        this.processedFileCount = processedFileCount;
            time,
 *
public class SnapshotStats implements Writeable, ToXContentObject {
    SnapshotStats(StreamInput in) throws IOException {
import org.opensearch.core.common.unit.ByteSizeValue;
        }
    /**
                        XContentParserUtils.ensureExpectedToken(XContentParser.Token.VALUE_NUMBER, token, parser);
                        XContentParserUtils.ensureExpectedToken(XContentParser.Token.VALUE_NUMBER, token, parser);
    }
        long incrementalSize = 0;
 *
                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                        }
                    String innerName = parser.currentName();
            time = stats.time;
                    if (innerName.equals(Fields.FILE_COUNT)) {
 * compatible open source license.
        this.time = time;
                            parser.skipChildren();
    static final class Fields {
                builder.startObject(Fields.PROCESSED);
                        XContentParserUtils.ensureExpectedToken(XContentParser.Token.VALUE_NUMBER, token, parser);
                startTime = parser.longValue();
        out.writeVLong(startTime);
                    }
 *
            // First time here
     */
    }
        totalFileCount += stats.totalFileCount;
            } else if (currentName.equals(Fields.TOTAL)) {
        out.writeVLong(time);
            + "]["
        XContentParser.Token token = parser.currentToken();
/**
                    }
            }
        return result;
import org.opensearch.core.xcontent.MediaTypeRegistry;
        static final String TIME_IN_MILLIS = "time_in_millis";
    private long processedSize;
        int totalFileCount = 0;
                    parser.skipChildren();
        long time = 0;
     */
    }
@PublicApi(since = "1.0.0")
    private long totalSize;
        return processedSize;
        return totalSize;
        result = 31 * result + totalFileCount;
                    XContentParserUtils.ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);
    public boolean equals(Object o) {
            processedSize
    }
                    XContentParserUtils.ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                        if (token == XContentParser.Token.START_OBJECT || token == XContentParser.Token.START_ARRAY) {
    /**
        processedSize = in.readVLong();
     * Returns snapshot running time
import org.opensearch.core.common.io.stream.StreamOutput;
            processedFileCount,
            token = parser.nextToken();
                XContentParserUtils.ensureExpectedToken(XContentParser.Token.VALUE_NUMBER, token, parser);
        totalSize = in.readVLong();
     */
        processedFileCount = in.readVInt();
                }
        time = in.readVLong();
                }
/*
