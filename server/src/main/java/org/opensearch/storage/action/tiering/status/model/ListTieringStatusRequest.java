 */  
import org.apache.logging.log4j.LogManager;
    }  
 * OR
    }
/*  
     * Constructs a request for the given target tier.
 * Tiering status request for all indices.  
    public String getTargetTier() {
    private String targetTier;
    }  
        if (targetTier != null) {  
    /**
    public ListTieringStatusRequest(StreamInput in) throws IOException {  
        super(in);
 * this file be licensed under the Apache-2.0 license or a
    public ListTieringStatusRequest() {  
    public ActionRequestValidationException validate() {  
package org.opensearch.storage.action.tiering.status.model;
import org.opensearch.action.ActionRequestValidationException;  
import org.opensearch.core.common.io.stream.StreamInput;
     */
     * Constructs a request from a stream.
    private static final Logger log = LogManager.getLogger(ListTieringStatusRequest.class);  
        targetTier = in.readOptionalString();
}
     * @param in the stream input  
     * @throws IOException if an I/O error occurs
    public void writeTo(StreamOutput out) throws IOException {
    @Override
 * Tiering status request for indices for specific Tiering State:
        } else {
/**
 * The OpenSearch Contributors require contributions made to  
        this.targetTier = null;
 * compatible open source license.
            this.targetTier = targetTier.toUpperCase(Locale.ROOT);
import org.apache.logging.log4j.Logger;
        super.writeTo(out);  
        out.writeOptionalString(targetTier != null ? targetTier.toString() : null);
 * eg. "_tier/all?target=_warm" - for Hot to Warm Tiering
import java.util.Locale;  
            this.targetTier = null;  
        }
 */  
 * eg. "_tier/all" - for all tiering indices  
    @Override
 * SPDX-License-Identifier: Apache-2.0
 *
import org.opensearch.core.common.io.stream.StreamOutput;  
    /** Returns the target tier. */  
import org.opensearch.action.support.clustermanager.ClusterManagerNodeReadRequest;
        return targetTier;
    }
    public ListTieringStatusRequest(String targetTier) {
    /** Constructs a default request with no target tier. */
    }
import java.io.IOException;
public class ListTieringStatusRequest extends ClusterManagerNodeReadRequest<ListTieringStatusRequest> {
     */
        return null;
    }
    /**
 * eg. "_tier/all?target=_hot" - for Warm to Hot Tiering
     * @param targetTier the target tier  
