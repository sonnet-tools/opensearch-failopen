    public Tier tier() {  
import static org.opensearch.storage.common.tiering.TieringUtils.isMigrationAllowed;
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;
        super(in);  
 * compatible open source license.
    @Override  
 * This class handles the validation and serialization of tiering requests.  
        return indexName;
    public IndexTieringRequest(final String targetTier, final String indexName) {
     * @param targetTier the target tier for the index
        return targetTier;
     */
 */  
     *  
    }
     */
     * @return the index name
 * SPDX-License-Identifier: Apache-2.0
/*  
import org.opensearch.storage.common.tiering.TieringUtils.Tier;
        IndexTieringRequest that = (IndexTieringRequest) o;  
    public void writeTo(StreamOutput out) throws IOException {
import static org.opensearch.action.ValidateActions.addValidationError;
        if (this == o) {  
        out.writeString(targetTier.value());
    }
        } else if (indexName.isBlank()) {
     */
    }
import java.io.IOException;
        return Objects.hash(clusterManagerNodeTimeout, timeout, indexName, targetTier);  
    @Override
    /**  
        }
            && indexName.equals(that.indexName)  
    @Override
    }
    /**
            validationException = addValidationError("Index parameter cannot be null", validationException);  
            validationException = addValidationError("Index '" + indexName + "' is blocklisted for migrations", validationException);
    private final Tier targetTier;
            return true;
/**
     *  
    }
        if (o == null || getClass() != o.getClass()) {  
            validationException = addValidationError("Target tier cannot be null", validationException);
        if (indexName == null) {
    @Override
        }
        indexName = in.readString();
        }
import org.opensearch.core.common.io.stream.StreamOutput;
import java.util.Objects;
        if (targetTier == null) {  
     */  
    }
            && timeout.equals(that.timeout)
     * Constructs a new tiering request from a stream.
 * The OpenSearch Contributors require contributions made to  
        } else if (isMigrationAllowed(indexName) == false) {  
        this.indexName = indexName;  
     * Constructs a new tiering request.
    public boolean equals(Object o) {
public class IndexTieringRequest extends AcknowledgedRequest<IndexTieringRequest> {
        }
    /**
     * Returns the target tier for this request.
     * Returns the index name for this tiering request.
        targetTier = Tier.fromString(in.readString());
    }
    public String getIndex() {  
}
            return false;
            && targetTier.equals(that.targetTier);
        return clusterManagerNodeTimeout.equals(that.clusterManagerNodeTimeout)
    private final String indexName;
 *
     * @param indexName the index name to be tiered
     * @return the target Tier enum value
        this.targetTier = Tier.fromString(targetTier);
        return validationException;  
     *  
    public int hashCode() {
import org.opensearch.core.common.io.stream.StreamInput;  
    /**
     * @param in the stream input
            validationException = addValidationError("Index parameter cannot be empty", validationException);
    public IndexTieringRequest(StreamInput in) throws IOException {
        out.writeString(indexName);  
import org.opensearch.action.ActionRequestValidationException;
 * Represents a request to move indices between different storage tiers.
    }  
        ActionRequestValidationException validationException = null;
    public ActionRequestValidationException validate() {  
     * @throws IOException if an I/O error occurs  
package org.opensearch.storage.action.tiering;
        super.writeTo(out);
 * this file be licensed under the Apache-2.0 license or a
 */
