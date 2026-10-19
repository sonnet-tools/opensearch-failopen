 * PIT reader context containing PIT specific information such as pit id, create time etc.
    private final ShardRouting shardRouting;
import org.opensearch.common.lease.Releasables;
        return this.creationTime.get() == null ? 0 : this.creationTime.get();
        this.pitId.set(pitId);
        return this.pitId.get();
package org.opensearch.search.internal;
    public ShardRouting getShardRouting() {
        ShardSearchContextId id,  
    }
        IndexShard indexShard,
            getRefCounted().decRef();
import org.opensearch.index.shard.IndexShard;
    /**  
import org.opensearch.index.engine.Engine;  
    }
        tryUpdateKeepAlive(keepAliveInMillis);  
     * Returns a releasable to indicate that the caller has stopped using this reader.  
        setPitId(pitId);
import org.opensearch.common.SetOnce;
    }
    /**
    private final List<Segment> segments;  
     */
/*  
    private final SetOnce<String> pitId = new SetOnce<>();
 * SPDX-License-Identifier: Apache-2.0
    public List<Segment> getSegments() {  
        return Collections.unmodifiableList(segments);
        shardRouting = indexShard.routingEntry();
     * The pit id can be updated and time to live of the reader usage can be extended using the provided
    }
    ) {  
    public PitReaderContext(
import java.util.Collections;
import org.opensearch.common.lease.Releasable;  
}  
        });  
 * The OpenSearch Contributors require contributions made to  
        setCreationTime(createTime);
    private final SetOnce<Long> creationTime = new SetOnce<>();  
            updateLastAccessTime();
    public String getPitId() {  
    /**
    public Releasable updatePitIdAndKeepAlive(long keepAliveInMillis, String pitId, long createTime) {
import org.opensearch.index.IndexService;
import org.opensearch.index.engine.Segment;
        return Releasables.releaseOnce(() -> {  
    }
    public void setPitId(final String pitId) {
        this.creationTime.set(creationTime);
 * this file be licensed under the Apache-2.0 license or a
/**
     * <code>keepAliveInMillis</code>.
import java.util.List;
    public void setCreationTime(final long creationTime) {
     * Shard routing at the time of creation of PIT Reader Context
 */  
    public long getCreationTime() {  
    // Storing the encoded PIT ID as part of PIT reader context for use cases such as list pit API  
        boolean singleSession
        long keepAliveInMillis,
public class PitReaderContext extends ReaderContext {
        getRefCounted().incRef();
    // Creation time of PIT contexts which helps users to differentiate between multiple PIT reader contexts
    }
 */  
import org.opensearch.cluster.routing.ShardRouting;
     */  
    }  
    }  
        IndexService indexService,
        super(id, indexService, indexShard, searcherSupplier, keepAliveInMillis, singleSession);
     */  
     * Encapsulates segments constituting the shard at the time of creation of PIT Reader Context.
 *
        Engine.SearcherSupplier searcherSupplier,  
        return shardRouting;  
        segments = indexShard.segments(true);  
 * compatible open source license.
