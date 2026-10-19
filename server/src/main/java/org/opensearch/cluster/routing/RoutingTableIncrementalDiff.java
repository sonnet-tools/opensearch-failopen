        private final Diff<Map<Integer, IndexShardRoutingTable>> indexShardRoutingTables;
        public static IndexRoutingTableIncrementalDiff readFrom(StreamInput in) throws IOException {
        version = in.readLong();
        private final Index index;  
        public void writeTo(StreamOutput out) throws IOException {  
    public void writeTo(StreamOutput out) throws IOException {
import static org.opensearch.cluster.DiffableUtils.MapDiff;
/**  
        public IndexRoutingTableIncrementalDiff(StreamInput in) throws IOException {
        indicesRouting = DiffableUtils.diff(
}  
    @Override
import java.io.IOException;
     * Represents a difference between {@link IndexShardRoutingTable} objects that can be serialized and deserialized.  
package org.opensearch.cluster.routing;
            }  
     */
 * Represents a difference between {@link RoutingTable} objects that can be serialized and deserialized.
 * compatible open source license.
        return new RoutingTableIncrementalDiff(in);
    public RoutingTable apply(RoutingTable part) {
 * SPDX-License-Identifier: Apache-2.0
        @Override
            CUSTOM_ROUTING_TABLE_DIFFABLE_VALUE_SERIALIZER
            after.getIndicesRouting(),  
        }
            DiffableUtils.getStringKeySerializer(),
    }
            before.getIndicesRouting(),
            return new IndexRoutingTable(index, indexShardRoutingTables.apply(part.getShards()));
    private final long version;
    }
        @Override  
        }  
        version = after.version();  
            public Diff<IndexRoutingTable> diff(IndexRoutingTable currentState, IndexRoutingTable previousState) {
            public IndexRoutingTable read(StreamInput in, String key) throws IOException {
    }
        return (MapDiff<String, IndexRoutingTable, Map<String, IndexRoutingTable>>) indicesRouting;
            indexShardRoutingTables.writeTo(out);
 * The OpenSearch Contributors require contributions made to  
        return new RoutingTable(version, indicesRouting.apply(part.getIndicesRouting()));  
    public RoutingTableIncrementalDiff(RoutingTable before, RoutingTable after) {
import org.opensearch.core.index.Index;
    private static final DiffableUtils.DiffableValueSerializer<String, IndexRoutingTable> CUSTOM_ROUTING_TABLE_DIFFABLE_VALUE_SERIALIZER =  
        };  
        indicesRouting = DiffableUtils.readJdkMapDiff(
        new DiffableUtils.DiffableValueSerializer<>() {
        private static final DiffableUtils.DiffableValueReader<Integer, IndexShardRoutingTable> DIFF_VALUE_READER =
                );
/*  
            @Override
            return new IndexRoutingTableIncrementalDiff(in);  
        out.writeLong(version);
            this.indexShardRoutingTables = DiffableUtils.diff(before.getShards(), after.getShards(), DiffableUtils.getIntKeySerializer());
    public static class IndexRoutingTableIncrementalDiff implements Diff<IndexRoutingTable> {
        public IndexRoutingTableIncrementalDiff(Index index, IndexRoutingTable before, IndexRoutingTable after) {
import org.opensearch.cluster.Diff;
        }
            }
            in,  
    public MapDiff<String, IndexRoutingTable, Map<String, IndexRoutingTable>> provideDiff() {
    }
 * this file be licensed under the Apache-2.0 license or a
            this.index = index;  
                return new RoutingTableIncrementalDiff.IndexRoutingTableIncrementalDiff(in);
            public Diff<IndexRoutingTable> readDiff(StreamInput in, String key) throws IOException {  
            this.index = new Index(in);
 *
                return new RoutingTableIncrementalDiff.IndexRoutingTableIncrementalDiff(  
        public IndexRoutingTable apply(IndexRoutingTable part) {
    }
                    currentState  
            new DiffableUtils.DiffableValueReader<>(IndexShardRoutingTable::readFrom, IndexShardRoutingTable::readDiffFrom);
        );  
            @Override
            DiffableUtils.getStringKeySerializer(),
                    currentState.getIndex(),
            }
        }  
            index.writeTo(out);
                return IndexRoutingTable.readFrom(in);
    /**
 */
    }  
                    previousState,
    }
    @Override  
    public static RoutingTableIncrementalDiff readFrom(StreamInput in) throws IOException {  
import org.opensearch.core.common.io.stream.StreamInput;  
            CUSTOM_ROUTING_TABLE_DIFFABLE_VALUE_SERIALIZER
            @Override  
            this.indexShardRoutingTables = DiffableUtils.readJdkMapDiff(in, DiffableUtils.getIntKeySerializer(), DIFF_VALUE_READER);  
    @Override  
import java.util.Map;
    private final Diff<Map<String, IndexRoutingTable>> indicesRouting;
import org.opensearch.cluster.DiffableUtils;
        indicesRouting.writeTo(out);  
        );  
public class RoutingTableIncrementalDiff implements Diff<RoutingTable>, StringKeyDiffProvider<IndexRoutingTable> {  
import org.opensearch.core.common.io.stream.StreamOutput;
        }
    public RoutingTableIncrementalDiff(StreamInput in) throws IOException {  
 */  
