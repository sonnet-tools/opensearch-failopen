        return null;  
    public AnalyticsClearShuffleRequest(StreamInput in) throws IOException {
 *
    }
}
import org.opensearch.action.ActionRequestValidationException;
        super.writeTo(out);
    }
import org.opensearch.core.common.io.stream.StreamInput;  
        super(in);
 *
 * @opensearch.internal  
    public AnalyticsClearShuffleRequest(String queryId) {  
 * compatible open source license.
/**
        this.queryId = in.readString();  
    }
        out.writeString(queryId);  
    @Override
    public String getQueryId() {  
 * Instructs the receiving data node to release all hash-shuffle buffers it holds for {@code queryId}  
        return queryId;
public class AnalyticsClearShuffleRequest extends ActionRequest {
 * this file be licensed under the Apache-2.0 license or a
    public void writeTo(StreamOutput out) throws IOException {
        this.queryId = queryId;
    }
    public ActionRequestValidationException validate() {
import java.io.IOException;  
 * ({@code ShuffleBufferManager.clearForQuery}). Broadcast by the coordinator on query terminal.
    private final String queryId;
import org.opensearch.core.common.io.stream.StreamOutput;
 * SPDX-License-Identifier: Apache-2.0
/*  
import org.opensearch.action.ActionRequest;
 * The OpenSearch Contributors require contributions made to  
 */  
package org.opensearch.analytics.exec.action;
    }
    @Override  
 */
