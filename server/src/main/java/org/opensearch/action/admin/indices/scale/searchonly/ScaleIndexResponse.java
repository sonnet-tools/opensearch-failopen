     * whether they have uncommitted operations or need additional synchronization.
        this.failureReason = buildFailureReason();  
    }
                    if (shardResponse.needsSync()) {  
        out.writeBoolean(hasFailures);  
        out.writeList(new ArrayList<>(nodeResponses));
/**
 * This response aggregates the results of shard synchronization attempts from multiple nodes
 * Response for search-only scale operations, containing information about shards' synchronization status.
        }
     *   <li>Whether any failures were detected</li>  
    ScaleIndexResponse(Collection<ScaleIndexNodeResponse> responses) {
     * @throws IOException if there is an error generating the XContent
        builder.startObject();
     * @return the XContentBuilder with response data added  
     * @param out the output stream to write to  
 * this file be licensed under the Apache-2.0 license or a
     * safely finalizing the scale operation.  
    boolean hasFailures() {
 * </ul>
     */
     * reported conditions that prevent the scale operation from being finalized, including  
     */
                        reason.append("has uncommitted operations ");
    /**
        this.hasFailures = responses.stream()
 * <ul>  
    String buildFailureReason() {
import java.util.ArrayList;
        return hasFailures;
class ScaleIndexResponse extends ActionResponse implements ToXContent {  
    /**
     *
            for (ScaleIndexShardResponse shardResponse : nodeResponse.getShardResponses()) {
        if (!hasFailures) {  
    }
     * Builds a detailed description of failure reasons if the scale operation cannot proceed.  
    @Override  
 *   <li>Whether any shards have uncommitted operations</li>
    public void writeTo(StreamOutput out) throws IOException {
}  
 *   <li>Whether any shards still need synchronization</li>
 * <p>
 *
     *
                        .append(nodeResponse.getNode())
 * The response is used by the cluster manager to determine whether a scale operation  
        }
                    reason.append("Shard ")
     * Serializes this response to the given output stream.
     * <p>
     * Indicates whether any shards reported conditions that would prevent
     */
            return null;
     * Converts this response to XContent format for API responses.
     */  
     * <p>
     * This constructor analyzes the responses to determine if any shards report conditions
                        .append(": ");
 */
     *   <li>Detailed failure reasons if applicable</li>
     * or pending synchronization tasks.
     *  
        if (failureReason != null) {  
    @Override  
import java.io.IOException;  
        return reason.toString();
                    reason.append("; ");  
                        reason.append("needs sync ");
 * can be finalized or needs to be retried after more time is allowed for synchronization.
     * <p>  
     */
    }
     * @param responses the collection of node responses containing shard status information  
    /**
                if (shardResponse.hasUncommittedOperations() || shardResponse.needsSync()) {  
     * This method constructs a human-readable string explaining which shards on which nodes
        builder.endObject();  
     * @param params  parameters for XContent generation
import org.opensearch.core.xcontent.ToXContent;  
            builder.field("failure_reason", failureReason);
    /**  
/*  
     * @return true if any shard has uncommitted operations or needs sync, false otherwise
import org.opensearch.core.xcontent.XContentBuilder;
        return builder;
     * that would prevent safely finalizing a scale operation, such as uncommitted operations  
                }
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
     * @param builder the XContentBuilder to use
                        .append(" on node ")  
            }
        this.nodeResponses = responses;  
        out.writeOptionalString(failureReason);
 * during a scale operation. It tracks:
    }  
import java.util.Collection;
     * </ul>
package org.opensearch.action.admin.indices.scale.searchonly;
    }
     * @throws IOException if there is an I/O error during serialization
        }  
            .anyMatch(r -> r.getShardResponses().stream().anyMatch(s -> s.hasUncommittedOperations() || s.needsSync()));
                        .append(shardResponse.getShardId())
import org.opensearch.core.action.ActionResponse;
    /**
     * @return a detailed failure description, or null if no failures were detected  
     * Constructs a new SearchOnlyResponse by aggregating responses from multiple nodes.  
 */  
 *   <li>Detailed failure reasons if the scale operation cannot proceed</li>  
                    }
     *
     * <ul>
import org.opensearch.core.common.io.stream.StreamOutput;
     *
                    }
        for (ScaleIndexNodeResponse nodeResponse : nodeResponses) {
     * The generated content includes:
 * <p>  
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {
    private final boolean hasFailures;  
                    if (shardResponse.hasUncommittedOperations()) {  
        StringBuilder reason = new StringBuilder();  
    private final Collection<ScaleIndexNodeResponse> nodeResponses;
    private final String failureReason;
 * SPDX-License-Identifier: Apache-2.0
