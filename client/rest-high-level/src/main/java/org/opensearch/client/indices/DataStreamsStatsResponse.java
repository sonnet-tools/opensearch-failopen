            this.dataStream = dataStream;
                + backingIndices
            DataStreamStats that = (DataStreamStats) obj;
        return Objects.hash(dataStreamCount, backingIndices, totalStoreSize, dataStreams);
        return dataStreams;
            return "DataStreamStats{"
        int dataStreamCount,
            + dataStreamCount
        if (obj == null || getClass() != obj.getClass()) {
            ByteSizeValue totalStoreSize = ((ByteSizeValue) arg[3]);
                + ", storeSize="
        }
                + dataStream
        private final String dataStream;
                && Objects.equals(storeSize, that.storeSize);
            && Objects.equals(totalStoreSize, that.totalStoreSize)
import java.util.HashMap;
import java.util.Map;
 *
 * Modifications Copyright OpenSearch Contributors. See
            return new DataStreamsStatsResponse(shards, dataStreamCount, backingIndices, totalStoreSize, dataStreams);
        true,
        }
    private final ByteSizeValue totalStoreSize;
            && backingIndices == that.backingIndices
import org.opensearch.core.xcontent.ConstructingObjectParser;
 */
 */
        PARSER.declareField(
            constructorArg(),
 * SPDX-License-Identifier: Apache-2.0
                return true;
    public static DataStreamsStatsResponse fromXContent(final XContentParser parser) throws IOException {
    private final Map<String, DataStreamStats> dataStreams;
            + '}';
        this.totalStoreSize = totalStoreSize;
        }
            (p, c) -> new ByteSizeValue(p.longValue()),
    }
        @Override
 * KIND, either express or implied.  See the License for the
    }
            for (DataStreamStats dataStreamStats : ((List<DataStreamStats>) arg[4])) {
            constructorArg(),
            + ", dataStreams="
            ByteSizeValue storeSize = ((ByteSizeValue) arg[2]);
            return dataStream;
                + maximumTimestamp
    private static final ConstructingObjectParser<DataStreamsStatsResponse, Void> PARSER = new ConstructingObjectParser<>(
    @Override
 * compatible open source license.
        ByteSizeValue totalStoreSize,
                return false;
    }
            ObjectParser.ValueType.VALUE
 * specific language governing permissions and limitations
        ENTRY_PARSER.declareString(constructorArg(), DATA_STREAM);
    ) {
        @Override
    private final int dataStreamCount;
        }
    public static class DataStreamStats {
        public String getDataStream() {
            Integer backingIndices = ((Integer) arg[2]);
    public String toString() {
    private static final ParseField MAXIMUM_TIMESTAMP = new ParseField("maximum_timestamp");
    private static final ParseField TOTAL_STORE_SIZE_BYTES = new ParseField("total_store_size_bytes");
            STORE_SIZE_BYTES,
    private static final ParseField DATA_STREAMS = new ParseField("data_streams");
 * this file be licensed under the Apache-2.0 license or a
        );
        this.dataStreamCount = dataStreamCount;
        ENTRY_PARSER.declareLong(constructorArg(), MAXIMUM_TIMESTAMP);
            if (obj == null || getClass() != obj.getClass()) {
                + "dataStream='"
        ENTRY_PARSER.declareInt(constructorArg(), BACKING_INDICES);
            return new DataStreamStats(dataStream, backingIndices, storeSize, maximumTimestamp);
            if (this == obj) {
            + totalStoreSize
    private static final ParseField BACKING_INDICES = new ParseField("backing_indices");
            + "dataStreamCount="
    @Override
 * You may obtain a copy of the License at
    private static final ParseField DATA_STREAM = new ParseField("data_stream");
        }
        "data_streams_stats.entry",
        private final int backingIndices;
            + dataStreams
        public long getMaximumTimestamp() {
package org.opensearch.client.indices;
        PARSER.declareInt(constructorArg(), DATA_STREAM_COUNT);
                + ", backingIndices="
 * this work for additional information regarding copyright
        }
        arg -> {
import org.opensearch.client.core.BroadcastResponse;
        this.backingIndices = backingIndices;
            Integer dataStreamCount = ((Integer) arg[1]);
        }
        public int hashCode() {
    }
    public int getDataStreamCount() {
                && maximumTimestamp == that.maximumTimestamp
    public Map<String, DataStreamStats> getDataStreams() {
        super(shards);
    }
    private static final ParseField STORE_SIZE_BYTES = new ParseField("store_size_bytes");
            Integer backingIndices = ((Integer) arg[1]);
        public String toString() {
import org.opensearch.core.xcontent.XContentParser;
public class DataStreamsStatsResponse extends BroadcastResponse {
            + backingIndices
            Map<String, DataStreamStats> dataStreams = new HashMap<>();
        DataStreamsStatsResponse that = (DataStreamsStatsResponse) obj;
    }
 * the Apache License, Version 2.0 (the "License"); you may
/*
    public int getBackingIndices() {
        Map<String, DataStreamStats> dataStreams
    public ByteSizeValue getTotalStoreSize() {
        private final long maximumTimestamp;
        "data_streams_stats",
 * Unless required by applicable law or agreed to in writing,
        }
    }
    private final int backingIndices;
        return totalStoreSize;
        if (this == obj) {
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to
        return dataStreamCount;
        ENTRY_PARSER.declareField(
                + '\''
            && Objects.equals(dataStreams, that.dataStreams);
        return backingIndices;
            Shards shards = (Shards) arg[0];
            }
            return backingIndices;
    }
        }
        );
        public boolean equals(Object obj) {
import org.opensearch.core.ParseField;
            ObjectParser.ValueType.VALUE
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.core.xcontent.ObjectParser;
        return PARSER.apply(parser, null);
    }
            }
        PARSER.declareInt(constructorArg(), BACKING_INDICES);
        }
        }
import org.opensearch.core.common.unit.ByteSizeValue;
 * ownership. Elasticsearch licenses this file to you under
            Long maximumTimestamp = ((Long) arg[3]);
    }
            }
            String dataStream = ((String) arg[0]);
            this.maximumTimestamp = maximumTimestamp;
        }
        this.dataStreams = dataStreams;
            this.backingIndices = backingIndices;
            return false;
 * software distributed under the License is distributed on an
/*
    public boolean equals(Object obj) {
        true,
import java.io.IOException;
            return Objects.hash(dataStream, backingIndices, storeSize, maximumTimestamp);
        Shards shards,
        return dataStreamCount == that.dataStreamCount
        PARSER.declareObjectArray(constructorArg(), ENTRY_PARSER, DATA_STREAMS);
            return backingIndices == that.backingIndices
            return maximumTimestamp;
    static {
/*
                dataStreams.put(dataStreamStats.dataStream, dataStreamStats);
 * not use this file except in compliance with the License.
}
        arg -> {
    }
                + '}';
        public int getBackingIndices() {
    );
    @Override
        private final ByteSizeValue storeSize;
 */
    );
            this.storeSize = storeSize;
            return storeSize;
        @Override
            TOTAL_STORE_SIZE_BYTES,
        int backingIndices,
    private static final ConstructingObjectParser<DataStreamStats, Void> ENTRY_PARSER = new ConstructingObjectParser<>(
                + storeSize
        declareShardsField(PARSER);
            + ", backingIndices="
        return "DataStreamsStatsResponse{"
        public DataStreamStats(String dataStream, int backingIndices, ByteSizeValue storeSize, long maximumTimestamp) {
    public int hashCode() {
    @SuppressWarnings("unchecked")
            + ", totalStoreSize="
 * under the License.
        public ByteSizeValue getStoreSize() {
import java.util.List;
    protected DataStreamsStatsResponse(
            return true;
import java.util.Objects;
 *
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * GitHub history for details.
            (p, c) -> new ByteSizeValue(p.longValue()),
                && Objects.equals(dataStream, that.dataStream)
 *     http://www.apache.org/licenses/LICENSE-2.0
                + ", maximumTimestamp="
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
    private static final ParseField DATA_STREAM_COUNT = new ParseField("data_stream_count");
