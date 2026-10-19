            return result;  
 *     http://www.apache.org/licenses/LICENSE-2.0
                + maximumTimestamp
        public DataStreamStats(StreamInput in) throws IOException {  
    public static class DataStreamShardStats implements Writeable {
                stats.storageBytes += shardStat.getStoreStats().sizeInBytes();  
            this.dataStream = in.readString();
 * Transport action for retrieving datastream stats
                + ", storeSize="
        }  
        @Override
                    List<IndexMetadata> indices = dataStream.getIndices();  
                + "dataStream='"
                totalStoreSizeBytes += shardStat.getStoreStats().sizeInBytes();
            builder.field("data_stream_count", dataStreamCount);
        }  
            this.storeStats = storeStats;  
                successfulShards,
            int successfulShards,  
     */
            }  
 * Modifications Copyright OpenSearch Contributors. See
            builder.startObject();
        protected Request readRequestFrom(StreamInput in) throws IOException {  
        }
import org.opensearch.core.common.unit.ByteSizeValue;
            super(in);
    }  
            int failedShards,
            result = 31 * result + Arrays.hashCode(dataStreams);
                totalShards,  
        }  
 * the Apache License, Version 2.0 (the "License"); you may
        }  
        }  
                String indexName = shardStat.getShardRouting().getIndexName();
 *  
        @Override
        }  
        super(NAME, DataStreamsStatsAction.Response::new);
            Map<String, AggregatedStats> aggregatedDataStreamsStats = new HashMap<>();
    }
        @Override
                .toArray(DataStreamStats[]::new);  
        public Request(StreamInput in) throws IOException {  
        long maxTimestamp = 0L;
        public int getBackingIndices() {
            return Objects.hash(dataStream, backingIndices, storeSize, maximumTimestamp);
            // if we don't have the routing entry yet, we need it stats wise, we treat it as if the shard is not ready yet
            return ResolvedIndices.of(  
    public static final DataStreamsStatsAction INSTANCE = new DataStreamsStatsAction();
                + dataStreamCount
        public int hashCode() {
        public void writeTo(StreamOutput out) throws IOException {
            builder.array("data_streams", (Object[]) dataStreams);
            );
                indexNameExpressionResolver,
            out.writeVInt(dataStreamCount);
        public Request() {
            out.writeVLong(maxTimestamp);
     */  
 * You may obtain a copy of the License at  
        private final ByteSizeValue totalStoreSize;
                    true,
        }
            ClusterService clusterService,  
        }
        public DataStreamStats(String dataStream, int backingIndices, ByteSizeValue storeSize, long maximumTimestamp) {
    }  
            this.backingIndices = backingIndices;
            Response response = (Response) obj;
 *
        }
            if (obj == null || getClass() != obj.getClass()) {
            this.indicesService = indicesService;
            this.dataStreamCount = dataStreamCount;  
        ) {
                && backingIndices == response.backingIndices  
            int backingIndices,
            return shardRouting;  
        public int hashCode() {  
            this.maxTimestamp = in.readVLong();
            IndexAbstraction indexAbstraction = clusterService.state().getMetadata().getIndicesLookup().get(shardRouting.getIndexName());  
                requestIndices = new String[] { "*" };
                        entry.getValue().maxTimestamp  
                // Aggregate global stats  
                IndexAbstraction.DataStream dataStream = indexAbstraction.getParentDataStream();  
            DataStreamStats[] dataStreams  
     * Aggregated data Stream stats
 * @opensearch.internal  
            return builder;
import org.opensearch.cluster.metadata.IndexAbstraction;  
 * SPDX-License-Identifier: Apache-2.0
            SortedMap<String, IndexAbstraction> indicesLookup = clusterState.getMetadata().getIndicesLookup();
        }
            this.storeSize = new ByteSizeValue(in);  
                actionFilters,
        }
        @Override  
            int dataStreamCount,  
                + backingIndices  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.shard.ShardNotFoundException;
                indexAbstractionResolver.resolveIndexAbstractions(
                allBackingIndices.add(indexName);
        }
            this.dataStreams = dataStreams;  
            if (obj == null || getClass() != obj.getClass()) {
            return new DataStreamShardStats(in);  
        public ResolvedIndices resolveIndices(Request request) {  
            this.dataStreams = in.readArray(DataStreamStats::new, DataStreamStats[]::new);
                + storeSize
     * @opensearch.internal
    /**  
    }  
import org.opensearch.core.xcontent.ToXContentObject;
                + "dataStreamCount="  
                AggregatedStats stats = aggregatedDataStreamsStats.computeIfAbsent(dataStream.getName(), s -> new AggregatedStats());
        @Override  
     * Request for Data Streams Stats  
import org.opensearch.cluster.routing.ShardRouting;
     * @opensearch.internal  
    }
                Request::new,  
import org.opensearch.index.IndexService;
 */
import java.io.IOException;
            this.backingIndices = in.readVInt();  
        private final int dataStreamCount;
import org.opensearch.index.store.StoreStats;
                + '}';
        @Override  
 *
            out.writeVLong(maximumTimestamp);  
        @Inject
/**  
            super(totalShards, successfulShards, failedShards, shardFailures);
                new ByteSizeValue(totalStoreSizeBytes),  
        @Override  
            this.storeStats = new StoreStats(in);  
        public long getMaximumTimestamp() {
            return dataStreamCount == response.dataStreamCount
import org.opensearch.cluster.metadata.IndexMetadata;
                // Aggregate data stream stats
 * specific language governing permissions and limitations
        private final ByteSizeValue storeSize;
            if (requestIndices == null || requestIndices.length == 0) {  
            IndicesService indicesService,
import org.opensearch.cluster.routing.ShardsIterator;  
            return backingIndices;  
 * this work for additional information regarding copyright
        private final int backingIndices;
            this.clusterService = clusterService;  
     * Transport Action for Data Stream Stats  
import org.opensearch.core.common.io.stream.StreamInput;
                aggregatedDataStreamsStats.size(),
                    entry -> new DataStreamStats(
                )
                assert indexAbstraction != null;  
        Set<String> backingIndices = new HashSet<>();  
                return false;
        }  
            this.backingIndices = in.readVInt();
            }).toArray(String[]::new);
        public ByteSizeValue getTotalStoreSize() {  
import org.apache.lucene.index.IndexReader;
                IndexReader indexReader = searcher.getIndexReader();  
            return storeSize;
import java.util.stream.Stream;
                        entry.getValue().backingIndices.size(),
            builder.humanReadableField("store_size_bytes", "store_size", storeSize);
            assert dataStream != null;  
                    request.indicesOptions(),  
 * ownership. Elasticsearch licenses this file to you under  
                transportService,  
                    )
            this.storeSize = storeSize;
                    requestIndices,
                    return indices.stream().map(idx -> idx.getIndex().getName());
import java.util.List;
            return new Request(in);
                && Objects.equals(totalStoreSize, response.totalStoreSize)
            List<DefaultShardOperationFailedException> shardFailures,
        @Override  
        @Override
     *
        }  
import org.opensearch.transport.TransportService;
            int successfulShards,
     *
            out.writeVInt(backingIndices);  
    /**  
 */  
            StoreStats storeStats = indexShard.storeStats();
        public String toString() {  
            return backingIndices == that.backingIndices  
            IndexShard indexShard = indexService.getShard(shardRouting.shardId().id());  
            IndexAbstraction.DataStream dataStream = indexAbstraction.getParentDataStream();
        }
 * KIND, either express or implied.  See the License for the
        }
        ) {  
            ByteSizeValue totalStoreSize,
                .map(
import org.apache.lucene.index.PointValues;  
                + ", maximumTimestamp="  
            try (Engine.Searcher searcher = indexShard.acquireSearcher("data_stream_stats")) {
            DataStreamStats that = (DataStreamStats) obj;
        }  
        public int getDataStreamCount() {
 */  
            ActionFilters actionFilters,  
     */  
        protected ClusterBlockException checkRequestBlock(ClusterState state, Request request, String[] concreteIndices) {
     */
     * Per Shard Data Stream stats
            DataStreamStats[] dataStreamStats = aggregatedDataStreamsStats.entrySet()
        }
            return state.blocks().indicesBlockedException(ClusterBlockLevel.METADATA_READ, concreteIndices);
        private final long maxTimestamp;
            return backingIndices;
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.core.action.support.DefaultShardOperationFailedException;  
            if (this == obj) {
            Request request,
import java.util.SortedMap;  
 * compatible open source license.
import org.opensearch.action.support.ActionFilters;
            }  
        }
            List<DefaultShardOperationFailedException> shardFailures,
                + totalStoreSize
            this.shardRouting = new ShardRouting(in);
            return dataStreamCount;
            builder.field("backing_indices", backingIndices);
                IndexAbstraction indexAbstraction = indicesLookup.get(abstractionName);
        @Override
                byte[] maxPackedValue = PointValues.getMaxPackedValue(indexReader, fieldName);
import org.opensearch.cluster.block.ClusterBlockException;
import org.opensearch.cluster.metadata.ResolvedIndices;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
        protected DataStreamShardStats readShardResult(StreamInput in) throws IOException {
            return "DataStreamStats{"
            Set<String> allBackingIndices = new HashSet<>();
            super(  
            String[] concreteDatastreamIndices = abstractionNames.stream().flatMap(abstractionName -> {
            shardRouting.writeTo(out);  
            );
    public DataStreamsStatsAction() {
    /**
                }
                stats.maxTimestamp = Math.max(stats.maxTimestamp, shardStat.getMaxTimestamp());
                    clusterState.getMetadata(),
            String[] requestIndices = request.indices();
        }
            TransportService transportService,
        @Override
            this.indexAbstractionResolver = new IndexAbstractionResolver(indexNameExpressionResolver);
        public void writeTo(StreamOutput out) throws IOException {  
            IndexService indexService = indicesService.indexServiceSafe(shardRouting.shardId().getIndex());
     *
import java.util.Map;  
    public static class Request extends BroadcastRequest<Request> {
                ThreadPool.Names.MANAGEMENT
        }
 * Unless required by applicable law or agreed to in writing,
            }  
    }
                + dataStream  
        ) {
     * The Data Streams Stats container
            this.dataStreamCount = in.readVInt();
                + '}';
            }
        public boolean equals(Object obj) {
            return clusterState.getRoutingTable().allShards(concreteDatastreamIndices);  
            out.writeString(dataStream);  
            }  
            for (DataStreamShardStats shardStat : dataStreamShardStats) {  
                dataStreamStats
 * software distributed under the License is distributed on an
                }
        public Response(
                    IndexAbstraction.DataStream dataStream = (IndexAbstraction.DataStream) indexAbstraction;
            return dataStreams;
     * @opensearch.internal  
        }
            builder.field("backing_indices", backingIndices);
            }
        }
                return true;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
                if (indexAbstraction.getType() == IndexAbstraction.Type.DATA_STREAM) {
                + ", totalStoreSize="
import org.opensearch.common.inject.Inject;
        private final ShardRouting shardRouting;  
import java.util.Arrays;
        }
        @Override
        public TransportAction(
import org.opensearch.index.engine.Engine;
 * not use this file except in compliance with the License.
        private final ClusterService clusterService;  
                failedShards,
        }  
 * license agreements. See the NOTICE file distributed with
            IndexNameExpressionResolver indexNameExpressionResolver
            int totalShards,  
import org.opensearch.cluster.block.ClusterBlockLevel;
        public String toString() {
        public StoreStats getStoreStats() {  
                IndexAbstraction indexAbstraction = indicesLookup.get(indexName);
     * @opensearch.internal
            builder.field("data_stream", dataStream);  
package org.opensearch.action.admin.indices.datastream;
import org.opensearch.indices.IndicesService;  
            );
            int result = Objects.hash(dataStreamCount, backingIndices, totalStoreSize);
        private final String dataStream;  
            this.maximumTimestamp = maximumTimestamp;  
     * @opensearch.internal  
}
                return true;
import org.opensearch.index.shard.IndexShard;  
     * Response for Data Streams Stats  
        private final IndexAbstractionResolver indexAbstractionResolver;
        public DataStreamShardStats(StreamInput in) throws IOException {
            return resolvedIndices(request, clusterService.state(), false);
                        entry.getKey(),  
        @Override
            return dataStream;  
import org.opensearch.cluster.ClusterState;  
     *
            List<DataStreamShardStats> dataStreamShardStats,  
            builder.endObject();
 * Licensed to Elasticsearch under one or more contributor  
            return "Response{"
            return maximumTimestamp;  
            this.dataStream = dataStream;  
        @Override
        @Override  
            }
                DataStreamsStatsAction.NAME,
                if (maxPackedValue != null) {  
                stats.backingIndices.add(indexName);
            this.shardRouting = shardRouting;
            }
            SortedMap<String, IndexAbstraction> indicesLookup = clusterState.getMetadata().getIndicesLookup();
                + ", dataStreams="  
import org.opensearch.action.ActionType;
                clusterService,
                assert dataStream != null;
     *
            this.maximumTimestamp = in.readVLong();
/*
        public String getDataStream() {
            this.maxTimestamp = maxTimestamp;
                String fieldName = dataStream.getDataStream().getTimeStampField().getName();
            storeStats.writeTo(out);
    /**  
            return new Response(
        public DataStreamStats[] getDataStreams() {
import org.opensearch.core.xcontent.XContentBuilder;  
    public static class DataStreamStats implements ToXContentObject, Writeable {
public class DataStreamsStatsAction extends ActionType<DataStreamsStatsAction.Response> {
                throw new ShardNotFoundException(indexShard.shardId());  
        long storageBytes = 0L;
                return false;  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import java.util.HashSet;
     * @opensearch.internal
                allBackingIndices.size(),
                shardFailures,  
        }  
        public DataStreamShardStats(ShardRouting shardRouting, StoreStats storeStats, long maxTimestamp) {
            return maxTimestamp;
            storeSize.writeTo(out);
            super(in);
            return totalStoreSize;
        @Override
        }
     */
        }  
            super.writeTo(out);
                + ", backingIndices="
                + '\''
        }  
                    throwExceptions  
     */  
/*  
            long maxTimestamp = 0L;
                        new ByteSizeValue(entry.getValue().storageBytes),
            if (this == obj) {
                + Arrays.toString(dataStreams)
            out.writeVInt(backingIndices);
                + ", backingIndices="
        }  
import org.opensearch.action.support.broadcast.node.TransportBroadcastByNodeAction;
        public boolean equals(Object obj) {  
                && Objects.equals(dataStream, that.dataStream)
        }
        protected Response newResponse(
    public static final String NAME = "indices:monitor/data_stream/stats";
            return storeStats;
        }
            int totalShards,
        private final DataStreamStats[] dataStreams;
            this.backingIndices = backingIndices;
            if (indexShard.routingEntry() == null) {
        @Override
        @Override  
        }
            long totalStoreSizeBytes = 0L;  
 * The OpenSearch Contributors require contributions made to  
        protected DataStreamShardStats shardOperation(Request request, ShardRouting shardRouting) throws IOException {
        public long getMaxTimestamp() {
import java.util.Set;
/*  
                + backingIndices  
            assert indexAbstraction != null;
                .stream()  
     *
            totalStoreSize.writeTo(out);
            return new DataStreamShardStats(indexShard.routingEntry(), storeStats, maxTimestamp);
 */
    private static class AggregatedStats {
        }
            builder.humanReadableField("total_store_size_bytes", "total_store_size", totalStoreSize);  
        private final IndicesService indicesService;
        }
        public ByteSizeValue getStoreSize() {
 * GitHub history for details.
    }
        public ShardRouting getShardRouting() {
        public int getBackingIndices() {  
            int failedShards,
                    maxTimestamp = LongPoint.decodeDimension(maxPackedValue, 0);
            Set<String> abstractionNames = resolvedIndices(request, clusterState, true).local().names();
 *
import java.util.Objects;
            this.totalStoreSize = totalStoreSize;
    /**
import org.opensearch.cluster.metadata.IndexAbstractionResolver;
    public static class Response extends BroadcastResponse {
        protected ClusterBlockException checkGlobalBlock(ClusterState state, Request request) {
        private final long maximumTimestamp;  
            out.writeArray(dataStreams);
 * under the License.  
        private final int backingIndices;  
import org.opensearch.action.support.broadcast.BroadcastRequest;  
import java.util.HashMap;  
        protected ShardsIterator shards(ClusterState clusterState, Request request, String[] concreteIndices) {  
        private ResolvedIndices resolvedIndices(Request request, ClusterState clusterState, boolean throwExceptions) {
        public void writeTo(StreamOutput out) throws IOException {
        public Response(StreamInput in) throws IOException {  
        }
                } else {
                    return Stream.empty();  
    /**
                && maximumTimestamp == that.maximumTimestamp
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.action.support.broadcast.BroadcastResponse;
        }  
import org.apache.lucene.document.LongPoint;
            super((String[]) null);  
                && Objects.equals(storeSize, that.storeSize);  
            ClusterState clusterState
            return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_READ);  
        }  
import org.opensearch.core.common.io.stream.Writeable;  
            builder.field("maximum_timestamp", maximumTimestamp);  
            this.totalStoreSize = new ByteSizeValue(in);
        private final StoreStats storeStats;
                && Arrays.equals(dataStreams, response.dataStreams);
    public static class TransportAction extends TransportBroadcastByNodeAction<Request, Response, DataStreamShardStats> {
import org.opensearch.cluster.service.ClusterService;
        protected void addCustomXContentFields(XContentBuilder builder, Params params) throws IOException {  
                )
        @Override
