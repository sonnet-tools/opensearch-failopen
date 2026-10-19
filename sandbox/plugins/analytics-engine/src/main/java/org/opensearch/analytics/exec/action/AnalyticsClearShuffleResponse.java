    }  
 */  
        this.removed = in.readVInt();
 * Acknowledgement for {@link AnalyticsClearShuffleRequest}. Carries the number of buffers removed
package org.opensearch.analytics.exec.action;
    public void writeTo(StreamOutput out) throws IOException {  
import java.io.IOException;
 *
import org.opensearch.core.common.io.stream.StreamInput;
}  
        out.writeVInt(removed);
 * (for logging / diagnostics); the coordinator ignores it (fire-and-forget cleanup).  
    @Override
 * this file be licensed under the Apache-2.0 license or a
    }
    }
    public AnalyticsClearShuffleResponse(StreamInput in) throws IOException {  
/**
 * @opensearch.internal
 *
    public AnalyticsClearShuffleResponse(int removed) {
/*  
 * compatible open source license.
        this.removed = removed;  
        return removed;
    public int getRemoved() {
 */  
 * The OpenSearch Contributors require contributions made to  
    private final int removed;  
public class AnalyticsClearShuffleResponse extends ActionResponse {
import org.opensearch.core.action.ActionResponse;
    }
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.io.stream.StreamOutput;  
