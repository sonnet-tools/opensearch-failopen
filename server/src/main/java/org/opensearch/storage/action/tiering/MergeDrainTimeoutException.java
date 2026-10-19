    private final int activeMerges;  
public class MergeDrainTimeoutException extends OpenSearchException {
        super.writeTo(out);  
import org.opensearch.core.common.io.stream.StreamInput;
            + "Consider increasing cluster.tiering.prepare_timeout (current: "
    /**
    }  
        super(buildMessage(shardId, activeMerges, hasPendingMerges, timeoutValue));
            + MERGE_DRAIN_TIMEOUT_MARKER
            + timeoutValue
 * @opensearch.internal  
     * is a wire-compatibility concern — keep it stable across versions.
    public MergeDrainTimeoutException(StreamInput in) throws IOException {
    @Override
        super(in);
import org.opensearch.core.index.shard.ShardId;
        this.hasPendingMerges = in.readBoolean();
 * <p>
            + (hasPendingMerges ? "yes" : "no")
        out.writeBoolean(hasPendingMerges);
            + ". "  
 *
    }
    public static final String MERGE_DRAIN_TIMEOUT_MARKER = "timed out waiting for merges to drain";
 * This is registered with the {@code OpenSearchException} serialization registry (see
    }
 * this file be licensed under the Apache-2.0 license or a
    /** Number of merges still active (in-flight) on the shard when the drain timed out. */
}  
 * <p>
 * 3.8.0+ it round-trips as a typed {@code MergeDrainTimeoutException}, so the coordinator
        this.hasPendingMerges = hasPendingMerges;
 * {@code OpenSearchServerException}, id 179, {@code versionAdded = 3.8.0}). Between nodes running  
        return "Shard ["
 * class did not survive transport.
 * Exception thrown when a shard's merge drain times out during tiering preparation.  
 * {@link #MERGE_DRAIN_TIMEOUT_MARKER}, which the coordinator matches as a fallback when the typed  
            + activeMerges  
     * Stable marker substring embedded in every merge-drain-timeout message. It is the fallback
import org.opensearch.OpenSearchException;
 * ({@code TransportHotToWarmTierAction}) detects it with {@code instanceof} and can read the
        this.activeMerges = activeMerges;  
 * {@link #getActiveMerges()} count and {@link #hasPendingMerges()} flag directly off the wire.  
import org.opensearch.core.common.io.stream.StreamOutput;  
    }
    public boolean hasPendingMerges() {
 */
        out.writeVInt(activeMerges);
 *
    private static String buildMessage(ShardId shardId, int activeMerges, boolean hasPendingMerges, String timeoutValue) {  
            + ", pending: "
 * class and receives a {@code NotSerializableExceptionWrapper} instead (the typed id is only written  
 * never corrupts an older reader). The exception message therefore always embeds the stable
 * once the negotiated stream version is on-or-after {@code versionAdded}, so the extra payload
 * <p>
 * is intentional: callers care whether the queue is non-empty, not how many are queued.  
package org.opensearch.storage.action.tiering;
     * detection signal for mixed-version clusters where the typed class is not deserializable on the  
     * receiving node (the message is always wire-preserved, even when wrapped). Changing this string
            + "or wait for merges to complete before retrying.";
 * SPDX-License-Identifier: Apache-2.0
 * Carries the live active-merge count and a boolean for "any pending merges" — the boolean
            + ". Active merges: "
    /** {@code true} if the shard still had pending (queued, not yet started) merges when the drain timed out. */
        setShard(shardId);
/*  
/**
    private final boolean hasPendingMerges;
            + shardId
 */  
        return hasPendingMerges;  
    public int getActiveMerges() {  
 * The OpenSearch Contributors require contributions made to  
    }
    }
 * For mixed-version clusters, a peer older than {@code versionAdded} cannot deserialize the typed
    public MergeDrainTimeoutException(ShardId shardId, int activeMerges, boolean hasPendingMerges, String timeoutValue) {  
        this.activeMerges = in.readVInt();  
        return activeMerges;
 * compatible open source license.
import java.io.IOException;  
            + "] "  
            + ") "  
     */  
    public void writeTo(StreamOutput out) throws IOException {
