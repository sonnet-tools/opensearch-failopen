    public int getIncrementalFileCount() {
        this.incrementalFileCount = incrementalFileCount;  
     */
import org.opensearch.common.unit.TimeValue;
        out.writeVInt(processedFileCount);
        totalSize += stats.totalSize;
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
            processedSize
        this.processedSize = processedSize;
        return startTime;  
                XContentParserUtils.ensureExpectedToken(XContentParser.Token.VALUE_NUMBER, token, parser);
        return new SnapshotStats(
    void add(SnapshotStats stats, boolean updateTimestamps) {
        out.writeVLong(startTime);  
        }
            if (currentName.equals(Fields.INCREMENTAL)) {
import org.opensearch.common.annotation.PublicApi;
    static final class Fields {  
                        XContentParserUtils.ensureExpectedToken(XContentParser.Token.VALUE_NUMBER, token, parser);  
    }
                // Unknown field, skip
        static final String SIZE = "size";
                        incrementalSize = parser.longValue();  
            {  
        if (incrementalFileCount != that.incrementalFileCount) return false;  
    }
        result = 31 * result + (int) (incrementalSize ^ (incrementalSize >>> 32));  
        if (time != that.time) return false;
        if (totalSize != that.totalSize) return false;
 * Stats for snapshots  
import org.opensearch.core.xcontent.XContentParserUtils;
 * ownership. Elasticsearch licenses this file to you under  
        out.writeVLong(totalSize);
            }  
 * the Apache License, Version 2.0 (the "License"); you may
    SnapshotStats(StreamInput in) throws IOException {  
     * Returns number of files in the snapshot that were processed so far
                        if (token == XContentParser.Token.START_OBJECT || token == XContentParser.Token.START_ARRAY) {  
        static final String PROCESSED = "processed";
        long startTime,  
/**
    @Override
        return incrementalSize;
                            parser.skipChildren();  
    }  
 * software distributed under the License is distributed on an
        totalFileCount += stats.totalFileCount;  
     *  
            } else if (currentName.equals(Fields.START_TIME_IN_MILLIS)) {
    }  
import org.opensearch.core.xcontent.ToXContentObject;
                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                    } else if (innerName.equals(Fields.SIZE_IN_BYTES)) {
        static final String STATS = "stats";
        return incrementalFileCount;
        if (startTime == 0) {
    public int getProcessedFileCount() {  
                    if (innerName.equals(Fields.FILE_COUNT)) {
                    builder.field(Fields.FILE_COUNT, getProcessedFileCount());  
            + updateTimestamps  
        }
    }
            XContentParserUtils.ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);
            // timings stats
        out.writeVInt(incrementalFileCount);  
        incrementalFileCount = in.readVInt();
            builder.startObject(Fields.TOTAL);  
 * not use this file except in compliance with the License.
import java.io.IOException;  
        } else if (updateTimestamps) {
        if (this == o) return true;
                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            // First time here
                builder.startObject(Fields.PROCESSED);
        out.writeVLong(incrementalSize);  
        XContentParser.Token token = parser.currentToken();
                    XContentParserUtils.ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);
            processedFileCount,
                }
        return processedFileCount;
     */
            if (getProcessedFileCount() != getIncrementalFileCount()) {  
                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
            incrementalFileCount,
        static final String TIME_IN_MILLIS = "time_in_millis";  
                if (token == XContentParser.Token.START_OBJECT || token == XContentParser.Token.START_ARRAY) {  
     * @opensearch.internal
    private long processedSize;
                        // Unknown sub field, skip  
/*  
    /**
            time = stats.time;
        }
                    builder.humanReadableField(Fields.SIZE_IN_BYTES, Fields.SIZE, new ByteSizeValue(getProcessedSize()));
import org.opensearch.core.common.Strings;  
        result = 31 * result + (int) (totalSize ^ (totalSize >>> 32));
        out.writeVLong(processedSize);
    private int processedFileCount;
import org.opensearch.core.common.io.stream.StreamInput;
    public long getIncrementalSize() {
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
                builder.endObject();  
                    } else {  
        static final String INCREMENTAL = "incremental";  
        this.incrementalSize = incrementalSize;  
                        if (token == XContentParser.Token.START_OBJECT || token == XContentParser.Token.START_ARRAY) {
    /**
                    token = parser.nextToken();  
                }
 *
    private long startTime;
        if (processedFileCount != that.processedFileCount) return false;
    private int incrementalFileCount;  
                    XContentParserUtils.ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);  
                startTime = parser.longValue();  
 * specific language governing permissions and limitations
    private long time;
                    }  
        long time = 0;
        long processedSize
 * The OpenSearch Contributors require contributions made to  
    /**  
            builder.endObject();
/*  
        out.writeVLong(time);
            startTime = Math.min(startTime, stats.startTime);
            totalSize,  
        long totalSize,  
        startTime = in.readVLong();
        long incrementalSize,
 * Licensed to Elasticsearch under one or more contributor  
                        if (token == XContentParser.Token.START_OBJECT || token == XContentParser.Token.START_ARRAY) {
import org.opensearch.core.common.io.stream.Writeable;  
        return totalFileCount;  
     * Returns time when snapshot started  
    @Override
                        XContentParserUtils.ensureExpectedToken(XContentParser.Token.VALUE_NUMBER, token, parser);
            startTime,  
/*
                        // Unknown sub field, skip
                        XContentParserUtils.ensureExpectedToken(XContentParser.Token.VALUE_NUMBER, token, parser);
     */  
    /**
        this.startTime = startTime;  
    /**
        out.writeVInt(totalFileCount);  
     */
    private int totalFileCount;
        static final String FILE_COUNT = "file_count";
        return totalSize;  
            }  
        {
        int totalFileCount,  
    public boolean equals(Object o) {
        return result;  
                XContentParserUtils.ensureExpectedToken(XContentParser.Token.VALUE_NUMBER, token, parser);
        processedFileCount += stats.processedFileCount;
                            parser.skipChildren();
            + Strings.toString(MediaTypeRegistry.JSON, stats)
            builder.startObject(Fields.INCREMENTAL);
            incrementalSize,
import org.opensearch.core.xcontent.MediaTypeRegistry;
    public int hashCode() {  
            + "]";  
     * Returns total size of files in the snapshot that were processed so far
        }
                    }
@PublicApi(since = "1.0.0")
    private long incrementalSize;  
    /**
        processedFileCount = in.readVInt();
        result = 31 * result + processedFileCount;
     * Return incremental files size of the snapshot
import org.opensearch.core.xcontent.ToXContent;  
                        processedFileCount = parser.intValue();
            time = endTime - startTime;
            // The time the first snapshot starts  
 *
    }  
     */  
        if (incrementalSize != that.incrementalSize) return false;  
                            parser.skipChildren();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        result = 31 * result + totalFileCount;
        long processedSize = 0;
                {
     * Returns total number of files in the snapshot  
                XContentParserUtils.ensureExpectedToken(XContentParser.Token.START_OBJECT, token, parser);
        this.processedFileCount = processedFileCount;
        return time;
    }  
 *  
     */
        result = 31 * result + (int) (processedSize ^ (processedSize >>> 32));
            startTime = stats.startTime;  
        result = 31 * result + (int) (time ^ (time >>> 32));
                    } else if (innerName.equals(Fields.SIZE_IN_BYTES)) {
        if (startTime != that.startTime) return false;
                time = parser.longValue();  
    /**
        this.totalFileCount = totalFileCount;
                    token = parser.nextToken();
}
        assert time >= 0 : "Update with ["  
                    } else {
 *
 * this file be licensed under the Apache-2.0 license or a
    }
    }
 * @opensearch.api
 * compatible open source license.
        return processedSize;
        return processedSize == that.processedSize;
    }  
                        // Unknown sub field, skip
            + "]["
 * KIND, either express or implied.  See the License for the
    }
    @Override
            + "] resulted in negative total time ["
 * under the License.  
                builder.field(Fields.FILE_COUNT, getIncrementalFileCount());
    public void writeTo(StreamOutput out) throws IOException {
                builder.humanReadableField(Fields.SIZE_IN_BYTES, Fields.SIZE, new ByteSizeValue(getTotalSize()));  
            long endTime = Math.max(startTime + time, stats.startTime + stats.time);
public class SnapshotStats implements Writeable, ToXContentObject {
            builder.endObject();
                    if (innerName.equals(Fields.FILE_COUNT)) {
            String currentName = parser.currentName();
            }
        incrementalFileCount += stats.incrementalFileCount;
                        processedSize = parser.longValue();
     */
    ) {
    public long getTotalSize() {
     */
        int processedFileCount = 0;
        int totalFileCount = 0;
        int incrementalFileCount = 0;  
        this.time = time;
        long totalSize = 0;
        totalSize = in.readVLong();
 * GitHub history for details.
        this.totalSize = totalSize;
                    parser.skipChildren();
            // The time the last snapshot ends  
import org.opensearch.core.xcontent.XContentBuilder;
    public long getStartTime() {
    public long getProcessedSize() {  
        // Parse this old school style instead of using the ObjectParser since there's an impedance mismatch between how the  
import org.opensearch.core.common.io.stream.StreamOutput;
 */  
        static final String TIME = "time";
                        }  
    /**  
                        }
        int incrementalFileCount,
            {
            } else if (currentName.equals(Fields.PROCESSED)) {
        builder.startObject();  
    public long getTime() {  
            } else if (currentName.equals(Fields.TIME_IN_MILLIS)) {
        long incrementalSize = 0;  
        totalFileCount = in.readVInt();
    public static SnapshotStats fromXContent(XContentParser parser) throws IOException {
    private long totalSize;
                        XContentParserUtils.ensureExpectedToken(XContentParser.Token.VALUE_NUMBER, token, parser);
    }
            builder.humanReadableField(Fields.TIME_IN_MILLIS, Fields.TIME, new TimeValue(getTime()));  
                    XContentParserUtils.ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);
     */  
        SnapshotStats that = (SnapshotStats) o;
 * Modifications Copyright OpenSearch Contributors. See
        processedSize = in.readVLong();
    }
    public int getTotalFileCount() {
package org.opensearch.action.admin.cluster.snapshots.status;
 */  
        long startTime = 0;
        int result = (int) (startTime ^ (startTime >>> 32));
    @Override  
    /**
            totalFileCount,  
        if (o == null || getClass() != o.getClass()) return false;  
            // Update duration  
        XContentParserUtils.ensureExpectedToken(XContentParser.Token.START_OBJECT, token, parser);  
        int processedFileCount,
        if (totalFileCount != that.totalFileCount) return false;
     * Returns snapshot running time
import org.opensearch.core.xcontent.XContentParser;  
 */
            builder.field(Fields.START_TIME_IN_MILLIS, getStartTime());
            token = parser.nextToken();  
            } else {
                builder.field(Fields.FILE_COUNT, getTotalFileCount());
        static final String START_TIME_IN_MILLIS = "start_time_in_millis";
            time,
     */
     * Returns incremental file count of the snapshot
     * Inner Fields used for creating XContent and parsing
            + time
    SnapshotStats(
        static final String TOTAL = "total";
                        totalFileCount = parser.intValue();
                builder.humanReadableField(Fields.SIZE_IN_BYTES, Fields.SIZE, new ByteSizeValue(getIncrementalSize()));
                XContentParserUtils.ensureExpectedToken(XContentParser.Token.START_OBJECT, token, parser);
            } else if (currentName.equals(Fields.TOTAL)) {  
import org.opensearch.core.common.unit.ByteSizeValue;
        return builder.endObject();
 * this work for additional information regarding copyright
        processedSize += stats.processedSize;
                    String innerName = parser.currentName();
        result = 31 * result + incrementalFileCount;  
                }
        // object has historically been written as JSON versus how it is structured in Java.
     * Returns total size of files in the snapshot  
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
        time = in.readVLong();
     * @param stats Stats instance to add
                        XContentParserUtils.ensureExpectedToken(XContentParser.Token.VALUE_NUMBER, token, parser);  
                        XContentParserUtils.ensureExpectedToken(XContentParser.Token.VALUE_NUMBER, token, parser);
        incrementalSize = in.readVLong();
 */  
                    if (innerName.equals(Fields.FILE_COUNT)) {  
                }  
        static final String SIZE_IN_BYTES = "size_in_bytes";  
                XContentParserUtils.ensureExpectedToken(XContentParser.Token.START_OBJECT, token, parser);  
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {
    }  
    }  
    }
                    }
                        incrementalFileCount = parser.intValue();  
                    String innerName = parser.currentName();
        incrementalSize += stats.incrementalSize;  
        long time,
        if (token == null) {  
                    } else if (innerName.equals(Fields.SIZE_IN_BYTES)) {  
    /**  
            }
            token = parser.nextToken();
     * Add stats instance to the total  
                    } else {
 * Unless required by applicable law or agreed to in writing,
        );
        assert time >= 0 : "Tried to initialize snapshot stats with negative total time [" + time + "]";
                        }
                }
    SnapshotStats() {}
 * You may obtain a copy of the License at  
                    String innerName = parser.currentName();  
     * @param updateTimestamps Whether or not start time and duration should be updated
                    token = parser.nextToken();
                        totalSize = parser.longValue();
