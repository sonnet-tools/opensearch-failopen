    static {
 * this work for additional information regarding copyright
        public DataStreamStats(String dataStream, int backingIndices, ByteSizeValue storeSize, long maximumTimestamp) {
            return new DataStreamStats(dataStream, backingIndices, storeSize, maximumTimestamp);
            Integer dataStreamCount = ((Integer) arg[1]);  
    }  
import java.util.List;
/*
 * specific language governing permissions and limitations
 *  
import org.opensearch.core.xcontent.ObjectParser;
            return dataStream;  
    public int getDataStreamCount() {
        ENTRY_PARSER.declareLong(constructorArg(), MAXIMUM_TIMESTAMP);  
                return true;  
        return Objects.hash(dataStreamCount, backingIndices, totalStoreSize, dataStreams);
    );  
    }
        this.backingIndices = backingIndices;
    private final int backingIndices;
        true,  
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
import org.opensearch.core.ParseField;
    }
    private static final ParseField DATA_STREAM = new ParseField("data_stream");
 * ownership. Elasticsearch licenses this file to you under  
                dataStreams.put(dataStreamStats.dataStream, dataStreamStats);
        return dataStreamCount;
        private final long maximumTimestamp;
            ObjectParser.ValueType.VALUE
        this.dataStreams = dataStreams;
            return maximumTimestamp;  
        }  
            this.storeSize = storeSize;
            return backingIndices == that.backingIndices  
            this.maximumTimestamp = maximumTimestamp;
        private final String dataStream;
                + '}';
                + '\''
 * compatible open source license.
        return totalStoreSize;
        @Override  
        this.dataStreamCount = dataStreamCount;
 * Licensed to Elasticsearch under one or more contributor  
            for (DataStreamStats dataStreamStats : ((List<DataStreamStats>) arg[4])) {
        PARSER.declareObjectArray(constructorArg(), ENTRY_PARSER, DATA_STREAMS);  
 * software distributed under the License is distributed on an
    public static DataStreamsStatsResponse fromXContent(final XContentParser parser) throws IOException {  
    private static final ParseField STORE_SIZE_BYTES = new ParseField("store_size_bytes");  
    }  
                + "dataStream='"
 * under the License.  
    private static final ParseField DATA_STREAMS = new ParseField("data_streams");
        return dataStreamCount == that.dataStreamCount
        }
            Long maximumTimestamp = ((Long) arg[3]);  
                return false;  
    protected DataStreamsStatsResponse(
    public int getBackingIndices() {
    public Map<String, DataStreamStats> getDataStreams() {
        PARSER.declareInt(constructorArg(), DATA_STREAM_COUNT);
        super(shards);  
        }  
            return backingIndices;
            constructorArg(),
        public String getDataStream() {
                && maximumTimestamp == that.maximumTimestamp
            && Objects.equals(dataStreams, that.dataStreams);
                + storeSize
    private static final ParseField DATA_STREAM_COUNT = new ParseField("data_stream_count");
            + backingIndices
        public int getBackingIndices() {  
import java.util.HashMap;  
            + ", totalStoreSize="
            STORE_SIZE_BYTES,  
        return "DataStreamsStatsResponse{"  
            + ", dataStreams="
            DataStreamStats that = (DataStreamStats) obj;
            (p, c) -> new ByteSizeValue(p.longValue()),
 * GitHub history for details.
    public ByteSizeValue getTotalStoreSize() {  
 *     http://www.apache.org/licenses/LICENSE-2.0
            Integer backingIndices = ((Integer) arg[2]);
            return "DataStreamStats{"
        if (obj == null || getClass() != obj.getClass()) {
        declareShardsField(PARSER);  
import org.opensearch.core.xcontent.ConstructingObjectParser;
public class DataStreamsStatsResponse extends BroadcastResponse {
    private static final ParseField MAXIMUM_TIMESTAMP = new ParseField("maximum_timestamp");
    }
 * not use this file except in compliance with the License.
            Integer backingIndices = ((Integer) arg[1]);
        public int hashCode() {
 *
    }
    private final Map<String, DataStreamStats> dataStreams;  
            (p, c) -> new ByteSizeValue(p.longValue()),
        Shards shards,  
                + ", storeSize="
            return storeSize;
 */  
 * Modifications Copyright OpenSearch Contributors. See
        );
        PARSER.declareField(  
        }  
        PARSER.declareInt(constructorArg(), BACKING_INDICES);
        "data_streams_stats.entry",  
                + dataStream  
                + ", maximumTimestamp="  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                && Objects.equals(storeSize, that.storeSize);  
        }  
    private final int dataStreamCount;  
            return new DataStreamsStatsResponse(shards, dataStreamCount, backingIndices, totalStoreSize, dataStreams);
        if (this == obj) {
        ENTRY_PARSER.declareInt(constructorArg(), BACKING_INDICES);
 */  
        ENTRY_PARSER.declareField(  
                + maximumTimestamp
    }
        int dataStreamCount,
    }
    }
            String dataStream = ((String) arg[0]);  
    }  
        DataStreamsStatsResponse that = (DataStreamsStatsResponse) obj;
            + ", backingIndices="  
            this.dataStream = dataStream;
 * license agreements. See the NOTICE file distributed with
import java.util.Objects;  
            + dataStreams
        private final ByteSizeValue storeSize;
            TOTAL_STORE_SIZE_BYTES,  
        "data_streams_stats",
import org.opensearch.client.core.BroadcastResponse;
            ObjectParser.ValueType.VALUE
        }
                && Objects.equals(dataStream, that.dataStream)
        Map<String, DataStreamStats> dataStreams
            + totalStoreSize  
            return Objects.hash(dataStream, backingIndices, storeSize, maximumTimestamp);
package org.opensearch.client.indices;
            Shards shards = (Shards) arg[0];
    private static final ConstructingObjectParser<DataStreamStats, Void> ENTRY_PARSER = new ConstructingObjectParser<>(
        arg -> {
    private static final ParseField TOTAL_STORE_SIZE_BYTES = new ParseField("total_store_size_bytes");  
            && Objects.equals(totalStoreSize, that.totalStoreSize)
        );
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
        ENTRY_PARSER.declareString(constructorArg(), DATA_STREAM);
        arg -> {
        public long getMaximumTimestamp() {
 *
            }
    private static final ConstructingObjectParser<DataStreamsStatsResponse, Void> PARSER = new ConstructingObjectParser<>(
        }
 * SPDX-License-Identifier: Apache-2.0
            ByteSizeValue storeSize = ((ByteSizeValue) arg[2]);
        this.totalStoreSize = totalStoreSize;  
                + backingIndices  
    public String toString() {
            constructorArg(),
        ByteSizeValue totalStoreSize,  
        }
        true,
            ByteSizeValue totalStoreSize = ((ByteSizeValue) arg[3]);
import org.opensearch.core.xcontent.XContentParser;  
 * the Apache License, Version 2.0 (the "License"); you may
/*  
            + '}';  
    public static class DataStreamStats {  
        @Override
            if (this == obj) {
        public boolean equals(Object obj) {
    @Override
        }
        }  
            }
        @Override  
}
            this.backingIndices = backingIndices;  
            + dataStreamCount
        return dataStreams;
/*  
 * The OpenSearch Contributors require contributions made to  
            return true;
 */
    );  
    @SuppressWarnings("unchecked")  
 * KIND, either express or implied.  See the License for the
            Map<String, DataStreamStats> dataStreams = new HashMap<>();  
    ) {
    public boolean equals(Object obj) {  
        public String toString() {  
        int backingIndices,
    }
            && backingIndices == that.backingIndices  
        }
    public int hashCode() {  
                + ", backingIndices="
            if (obj == null || getClass() != obj.getClass()) {
    @Override
import java.util.Map;
        return backingIndices;  
    private final ByteSizeValue totalStoreSize;
        public ByteSizeValue getStoreSize() {
import java.io.IOException;
            }  
import org.opensearch.core.common.unit.ByteSizeValue;  
        private final int backingIndices;  
            return false;
 * this file be licensed under the Apache-2.0 license or a
            + "dataStreamCount="
        }  
        return PARSER.apply(parser, null);
    private static final ParseField BACKING_INDICES = new ParseField("backing_indices");
    @Override
