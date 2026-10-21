                + dataStreamCount
                + ", storeSize="
        }
import org.opensearch.action.support.broadcast.node.TransportBroadcastByNodeAction;
                .stream()
        @Override
            this.dataStreamCount = dataStreamCount;
            return storeStats;
 * not use this file except in compliance with the License.
import org.opensearch.core.common.unit.ByteSizeValue;
            builder.endObject();
 * Licensed to Elasticsearch under one or more contributor
            TransportService transportService,
        @Override
     * @opensearch.internal
import org.opensearch.action.support.ActionFilters;
        private final DataStreamStats[] dataStreams;
 * KIND, either express or implied.  See the License for the
    /**
            return result;
                + dataStream
            return new DataStreamShardStats(in);
                IndexReader indexReader = searcher.getIndexReader();
    public static final DataStreamsStatsAction INSTANCE = new DataStreamsStatsAction();
            IndexAbstraction indexAbstraction = clusterService.state().getMetadata().getIndicesLookup().get(shardRouting.getIndexName());
        }
        }
        protected DataStreamShardStats readShardResult(StreamInput in) throws IOException {
                )
            this.maximumTimestamp = maximumTimestamp;
     * Response for Data Streams Stats
import org.opensearch.cluster.routing.ShardsIterator;
            return new Response(
                String indexName = shardStat.getShardRouting().getIndexName();
        @Override
            return dataStream;
 *
     * @opensearch.internal
        @Override
        public long getMaximumTimestamp() {
        }
                assert dataStream != null;
import org.opensearch.transport.TransportService;
                return false;
        }
import org.apache.lucene.document.LongPoint;
import org.opensearch.cluster.service.ClusterService;
        }
            this.dataStreams = in.readArray(DataStreamStats::new, DataStreamStats[]::new);
import org.opensearch.index.engine.Engine;
                indexAbstractionResolver.resolveIndexAbstractions(
        }
        }
            String[] requestIndices = request.indices();
        public DataStreamStats(StreamInput in) throws IOException {
            this.clusterService = clusterService;
        private final ByteSizeValue storeSize;
        private final int backingIndices;
                stats.backingIndices.add(indexName);
        public TransportAction(
}
            int successfulShards,
     */
import org.opensearch.core.xcontent.ToXContentObject;
        Set<String> backingIndices = new HashSet<>();
        public int hashCode() {
            return new DataStreamShardStats(indexShard.routingEntry(), storeStats, maxTimestamp);
                    entry -> new DataStreamStats(
 *
                ThreadPool.Names.MANAGEMENT
            this.indicesService = indicesService;
            this.storeStats = new StoreStats(in);
        private final long maximumTimestamp;
                transportService,
    }
            IndexService indexService = indicesService.indexServiceSafe(shardRouting.shardId().getIndex());
        public DataStreamShardStats(ShardRouting shardRouting, StoreStats storeStats, long maxTimestamp) {
            this.shardRouting = new ShardRouting(in);
                return true;
    public static class Request extends BroadcastRequest<Request> {
        @Override
package org.opensearch.action.admin.indices.datastream;
            super(
                IndexAbstraction.DataStream dataStream = indexAbstraction.getParentDataStream();
import java.util.Arrays;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                // Aggregate global stats
                && Objects.equals(storeSize, that.storeSize);
            return maximumTimestamp;
        }
                .map(
            return builder;
                stats.maxTimestamp = Math.max(stats.maxTimestamp, shardStat.getMaxTimestamp());
        public boolean equals(Object obj) {
            return Objects.hash(dataStream, backingIndices, storeSize, maximumTimestamp);
        }
            builder.startObject();
            return clusterState.getRoutingTable().allShards(concreteDatastreamIndices);
import org.opensearch.indices.IndicesService;
        }
        public int getDataStreamCount() {
            builder.field("maximum_timestamp", maximumTimestamp);
                + ", backingIndices="
                        new ByteSizeValue(entry.getValue().storageBytes),
            ClusterState clusterState
     * Per Shard Data Stream stats
                }
                + ", totalStoreSize="
            }
            String[] concreteDatastreamIndices = abstractionNames.stream().flatMap(abstractionName -> {
import java.util.SortedMap;
            return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_READ);
            DataStreamStats[] dataStreams
        }
        ) {
        @Override
            return dataStreamCount;
            ClusterService clusterService,
                Request::new,
            super(in);
     * @opensearch.internal
                    List<IndexMetadata> indices = dataStream.getIndices();
            StoreStats storeStats = indexShard.storeStats();
    /**
            }
import org.opensearch.cluster.ClusterState;
            this.maxTimestamp = in.readVLong();
    public static class TransportAction extends TransportBroadcastByNodeAction<Request, Response, DataStreamShardStats> {
                + ", dataStreams="
            this.storeSize = new ByteSizeValue(in);
        private final int dataStreamCount;
            return shardRouting;
            ByteSizeValue totalStoreSize,
                    IndexAbstraction.DataStream dataStream = (IndexAbstraction.DataStream) indexAbstraction;
            Set<String> allBackingIndices = new HashSet<>();
            return state.blocks().indicesBlockedException(ClusterBlockLevel.METADATA_READ, concreteIndices);
                + totalStoreSize
        }
/*
        public DataStreamStats(String dataStream, int backingIndices, ByteSizeValue storeSize, long maximumTimestamp) {
            Map<String, AggregatedStats> aggregatedDataStreamsStats = new HashMap<>();
            SortedMap<String, IndexAbstraction> indicesLookup = clusterState.getMetadata().getIndicesLookup();
            this.backingIndices = in.readVInt();
            assert dataStream != null;
            int totalShards,
import org.apache.lucene.index.PointValues;
            this.dataStreams = dataStreams;
        private final IndexAbstractionResolver indexAbstractionResolver;
     * Aggregated data Stream stats
            return "Response{"
     * Transport Action for Data Stream Stats
        }
    public static final String NAME = "indices:monitor/data_stream/stats";
 * license agreements. See the NOTICE file distributed with
            out.writeVLong(maxTimestamp);
            return "DataStreamStats{"
 *     http://www.apache.org/licenses/LICENSE-2.0
            builder.field("backing_indices", backingIndices);
 * SPDX-License-Identifier: Apache-2.0
        public boolean equals(Object obj) {
     *
        public Response(
                successfulShards,
        @Override
        public Response(StreamInput in) throws IOException {
        protected Request readRequestFrom(StreamInput in) throws IOException {
                + backingIndices
 * this work for additional information regarding copyright
        }
                + "dataStream='"
            }
import org.opensearch.cluster.block.ClusterBlockLevel;
        ) {
            if (indexShard.routingEntry() == null) {
import org.opensearch.common.inject.Inject;
                + Arrays.toString(dataStreams)
            builder.field("data_stream_count", dataStreamCount);
    }
            if (this == obj) {
    }
import org.opensearch.core.common.io.stream.Writeable;
                throw new ShardNotFoundException(indexShard.shardId());
        public long getMaxTimestamp() {
                .toArray(DataStreamStats[]::new);
                dataStreamStats
     * @opensearch.internal
            ActionFilters actionFilters,
 * Modifications Copyright OpenSearch Contributors. See
            builder.field("data_stream", dataStream);
                    throwExceptions
        public DataStreamStats[] getDataStreams() {
                        entry.getValue().maxTimestamp
                }
        public int getBackingIndices() {
            out.writeVInt(dataStreamCount);
import org.opensearch.cluster.metadata.IndexAbstractionResolver;
     * Request for Data Streams Stats
        }
            try (Engine.Searcher searcher = indexShard.acquireSearcher("data_stream_stats")) {
    /**
                byte[] maxPackedValue = PointValues.getMaxPackedValue(indexReader, fieldName);
    public DataStreamsStatsAction() {
                DataStreamsStatsAction.NAME,
 * GitHub history for details.
            result = 31 * result + Arrays.hashCode(dataStreams);
                IndexAbstraction indexAbstraction = indicesLookup.get(indexName);
 */
                totalStoreSizeBytes += shardStat.getStoreStats().sizeInBytes();
        }
import org.apache.lucene.index.IndexReader;
        @Override
/**
                failedShards,
                stats.storageBytes += shardStat.getStoreStats().sizeInBytes();
 * software distributed under the License is distributed on an
            return totalStoreSize;
        private final String dataStream;
            out.writeArray(dataStreams);
        protected ShardsIterator shards(ClusterState clusterState, Request request, String[] concreteIndices) {
        @Override
        protected ClusterBlockException checkGlobalBlock(ClusterState state, Request request) {
            if (requestIndices == null || requestIndices.length == 0) {
            int backingIndices,
        private final ClusterService clusterService;
        }
            }
import java.io.IOException;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                allBackingIndices.size(),
     */
                clusterService,
            long maxTimestamp = 0L;
            super(totalShards, successfulShards, failedShards, shardFailures);
                assert indexAbstraction != null;
        @Override
        long maxTimestamp = 0L;
        public void writeTo(StreamOutput out) throws IOException {
     * The Data Streams Stats container
     *
        private final ByteSizeValue totalStoreSize;
    }
 * this file be licensed under the Apache-2.0 license or a
            this.maximumTimestamp = in.readVLong();
            List<DefaultShardOperationFailedException> shardFailures,
     * @opensearch.internal
import java.util.List;
        protected ClusterBlockException checkRequestBlock(ClusterState state, Request request, String[] concreteIndices) {
        }
            if (this == obj) {
                    requestIndices,
        }
        public String toString() {
            int totalShards,
        long storageBytes = 0L;
 */
            }
            this.backingIndices = in.readVInt();
                + backingIndices
        }
        }
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            DataStreamStats that = (DataStreamStats) obj;
        public ByteSizeValue getTotalStoreSize() {
            IndexShard indexShard = indexService.getShard(shardRouting.shardId().id());
            out.writeVLong(maximumTimestamp);
        public DataStreamShardStats(StreamInput in) throws IOException {
        }
                aggregatedDataStreamsStats.size(),
            int result = Objects.hash(dataStreamCount, backingIndices, totalStoreSize);
        }
            }
            Response response = (Response) obj;
                return false;
                + '}';
                shardFailures,
import org.opensearch.core.common.io.stream.StreamInput;
            int failedShards,
     */
                    true,
            storeStats.writeTo(out);
import org.opensearch.cluster.routing.ShardRouting;
        public ResolvedIndices resolveIndices(Request request) {
        public void writeTo(StreamOutput out) throws IOException {
        public String getDataStream() {
            builder.array("data_streams", (Object[]) dataStreams);
        private ResolvedIndices resolvedIndices(Request request, ClusterState clusterState, boolean throwExceptions) {
        }
 * You may obtain a copy of the License at
                && Objects.equals(dataStream, that.dataStream)
        ) {
        protected Response newResponse(
            return backingIndices;
        }
import org.opensearch.threadpool.ThreadPool;
            IndicesService indicesService,
                String fieldName = dataStream.getDataStream().getTimeStampField().getName();
            IndexNameExpressionResolver indexNameExpressionResolver
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
 */
        }
                && Arrays.equals(dataStreams, response.dataStreams);
        public StoreStats getStoreStats() {
            this.storeSize = storeSize;
        @Override
import java.util.Objects;
import java.util.HashSet;
        }
                + ", backingIndices="
            List<DataStreamShardStats> dataStreamShardStats,
import org.opensearch.cluster.block.ClusterBlockException;
            if (obj == null || getClass() != obj.getClass()) {
 * @opensearch.internal
/*
import org.opensearch.index.store.StoreStats;
        }
            super(in);
                        entry.getKey(),
        @Override
     *
                if (indexAbstraction.getType() == IndexAbstraction.Type.DATA_STREAM) {
            super((String[]) null);
        }
     */
                AggregatedStats stats = aggregatedDataStreamsStats.computeIfAbsent(dataStream.getName(), s -> new AggregatedStats());
            this.totalStoreSize = totalStoreSize;
                + '}';
            int dataStreamCount,
    /**
                && Objects.equals(totalStoreSize, response.totalStoreSize)
     *
            List<DefaultShardOperationFailedException> shardFailures,
        protected DataStreamShardStats shardOperation(Request request, ShardRouting shardRouting) throws IOException {
            for (DataStreamShardStats shardStat : dataStreamShardStats) {
            if (obj == null || getClass() != obj.getClass()) {
                } else {
 * ownership. Elasticsearch licenses this file to you under
                    request.indicesOptions(),
                return true;
            return resolvedIndices(request, clusterService.state(), false);
import org.opensearch.core.xcontent.XContentBuilder;
            builder.humanReadableField("store_size_bytes", "store_size", storeSize);
                + maximumTimestamp
        }
        }
        }
            int successfulShards,
    }
     *
            return backingIndices;
        @Override
            this.maxTimestamp = maxTimestamp;
        public void writeTo(StreamOutput out) throws IOException {
 * compatible open source license.
 * Transport action for retrieving datastream stats
            out.writeVInt(backingIndices);
                    )
        protected void addCustomXContentFields(XContentBuilder builder, Params params) throws IOException {
    public static class DataStreamShardStats implements Writeable {
 *
            this.indexAbstractionResolver = new IndexAbstractionResolver(indexNameExpressionResolver);
            }).toArray(String[]::new);
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.action.support.broadcast.BroadcastRequest;
            return new Request(in);
            shardRouting.writeTo(out);
    /**
            super.writeTo(out);
    public static class Response extends BroadcastResponse {
            return storeSize;
 * Unless required by applicable law or agreed to in writing,
        public int hashCode() {
        @Override
        private final int backingIndices;
                    clusterState.getMetadata(),
                new ByteSizeValue(totalStoreSizeBytes),
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Map;
        private final long maxTimestamp;
            this.dataStream = in.readString();
     */
                    maxTimestamp = LongPoint.decodeDimension(maxPackedValue, 0);
            // if we don't have the routing entry yet, we need it stats wise, we treat it as if the shard is not ready yet
        @Override
        }
        @Override
     */
/*
                    return indices.stream().map(idx -> idx.getIndex().getName());
 * under the License.
                IndexAbstraction indexAbstraction = indicesLookup.get(abstractionName);
     * @opensearch.internal
import org.opensearch.index.shard.IndexShard;
        @Inject
                totalShards,
    /**
            IndexAbstraction.DataStream dataStream = indexAbstraction.getParentDataStream();
                // Aggregate data stream stats
            }
        }
            int failedShards,
            builder.field("backing_indices", backingIndices);
import org.opensearch.action.ActionType;
import org.opensearch.cluster.metadata.IndexAbstraction;
import org.opensearch.cluster.metadata.ResolvedIndices;
            return backingIndices == that.backingIndices
import org.opensearch.core.common.io.stream.StreamOutput;
    public static class DataStreamStats implements ToXContentObject, Writeable {
                + "dataStreamCount="
            this.backingIndices = backingIndices;
        public String toString() {
            assert indexAbstraction != null;
        private final StoreStats storeStats;
        }
            this.dataStream = dataStream;
                requestIndices = new String[] { "*" };
        }
                && maximumTimestamp == that.maximumTimestamp
                allBackingIndices.add(indexName);
public class DataStreamsStatsAction extends ActionType<DataStreamsStatsAction.Response> {
                && backingIndices == response.backingIndices
        }
        public Request(StreamInput in) throws IOException {
            );
import org.opensearch.action.support.broadcast.BroadcastResponse;
                actionFilters,
            this.backingIndices = backingIndices;
 *
            return maxTimestamp;
            out.writeVInt(backingIndices);
import java.util.HashMap;
                + '\''
            this.totalStoreSize = new ByteSizeValue(in);
            return dataStreamCount == response.dataStreamCount
import java.util.stream.Stream;
            builder.humanReadableField("total_store_size_bytes", "total_store_size", totalStoreSize);
            Set<String> abstractionNames = resolvedIndices(request, clusterState, true).local().names();
        }
    }
            SortedMap<String, IndexAbstraction> indicesLookup = clusterState.getMetadata().getIndicesLookup();
                indexNameExpressionResolver,
            return dataStreams;
        public ShardRouting getShardRouting() {
    private static class AggregatedStats {
import java.util.Set;
            Request request,
 * specific language governing permissions and limitations
        public int getBackingIndices() {
            return ResolvedIndices.of(
            );
        public ByteSizeValue getStoreSize() {
            }
                        entry.getValue().backingIndices.size(),
            this.storeStats = storeStats;
        public Request() {
 * The OpenSearch Contributors require contributions made to
            this.shardRouting = shardRouting;
        @Override
            out.writeString(dataStream);
            totalStoreSize.writeTo(out);
import org.opensearch.index.shard.ShardNotFoundException;
                    return Stream.empty();
    }
        private final IndicesService indicesService;
 */
import org.opensearch.index.IndexService;
        super(NAME, DataStreamsStatsAction.Response::new);
            storeSize.writeTo(out);
                + ", maximumTimestamp="
        @Override
                if (maxPackedValue != null) {
            );
        }
        @Override
            long totalStoreSizeBytes = 0L;
        private final ShardRouting shardRouting;
            DataStreamStats[] dataStreamStats = aggregatedDataStreamsStats.entrySet()
     *
            this.dataStreamCount = in.readVInt();
                + storeSize
                )
