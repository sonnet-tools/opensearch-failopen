    @Override
    public long getLastSuccessfulFetchOfPinnedTimestamps() {
        return "RemoteStoreNodeStats{ lastSuccessfulFetchOfPinnedTimestamps=" + lastSuccessfulFetchOfPinnedTimestamps + "}";
import org.opensearch.core.common.io.stream.Writeable;  
    }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
 * Node level remote store stats
    public boolean equals(Object o) {  
    public RemoteStoreNodeStats() {  
        if (o == null) {
    }  
    @Override
 */  
        return Objects.hash(lastSuccessfulFetchOfPinnedTimestamps);
        }  
    private final long lastSuccessfulFetchOfPinnedTimestamps;
import org.opensearch.core.common.io.stream.StreamInput;
import java.io.IOException;
 * @opensearch.internal  
        return builder.endObject();  
 * this file be licensed under the Apache-2.0 license or a
            return false;
        }  
    /**
}  
            return false;
    }  
    public static final String LAST_SUCCESSFUL_FETCH_OF_PINNED_TIMESTAMPS = "last_successful_fetch_of_pinned_timestamps";
 * compatible open source license.
    }
    @Override  
        this.lastSuccessfulFetchOfPinnedTimestamps = in.readLong();  
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.xcontent.ToXContentFragment;
        builder.field(LAST_SUCCESSFUL_FETCH_OF_PINNED_TIMESTAMPS, this.lastSuccessfulFetchOfPinnedTimestamps);
    public static final String STATS_NAME = "remote_store";
/**
 * SPDX-License-Identifier: Apache-2.0
        RemoteStoreNodeStats other = (RemoteStoreNodeStats) o;
     * Time stamp for the last successful fetch of pinned timestamps by the {@linkplain  RemoteStorePinnedTimestampService}
 *
import java.util.Objects;
        out.writeLong(this.lastSuccessfulFetchOfPinnedTimestamps);
        return this.lastSuccessfulFetchOfPinnedTimestamps;
import org.opensearch.core.common.io.stream.StreamOutput;
/*  
    }  
     */  
    @Override
 */
        builder.startObject(STATS_NAME);
    public String toString() {
package org.opensearch.node.remotestore;
    public RemoteStoreNodeStats(StreamInput in) throws IOException {
import org.opensearch.core.xcontent.XContentBuilder;
        this.lastSuccessfulFetchOfPinnedTimestamps = RemoteStorePinnedTimestampService.getPinnedTimestamps().v1();
    }  
        return this.lastSuccessfulFetchOfPinnedTimestamps == other.lastSuccessfulFetchOfPinnedTimestamps;
    }
    public int hashCode() {  
 * The OpenSearch Contributors require contributions made to  
public class RemoteStoreNodeStats implements Writeable, ToXContentFragment {
        if (o.getClass() != RemoteStoreNodeStats.class) {
    }
    @Override  
