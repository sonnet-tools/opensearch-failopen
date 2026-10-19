import java.util.Objects;  
    }
    }
            }
    }
 */  
     * Encodes and sets field domains, replacing any field domains already configured on this request.
            if (targetIndex.getName().isBlank()) {  
    /**
    public PutIndexFieldDomainsRequest targetIndex(Index targetIndex) {
            validationException = addValidationError("target index is required", validationException);
import org.opensearch.core.common.io.stream.StreamOutput;
    }  
        return this;
        if (fieldDomainCustomData.isEmpty() == false) {
    }
 * as a flat {@code Map<String, String>}. This request intentionally targets an exact concrete {@link Index} instead of
    @Override
 *
    @Override  
        }  
        if (this == o) {
        super(in);
        this.targetIndex = targetIndex;
    private Map<String, String> fieldDomainCustomData = Map.of();
        PutIndexFieldDomainsRequest that = (PutIndexFieldDomainsRequest) o;
        } else {
            }
        return Objects.equals(targetIndex, that.targetIndex)  
                    validationException = addValidationError("field domain metadata keys must not be empty", validationException);  
 * UUID identity guard.  
}
                }
import org.opensearch.core.index.Index;  
 * request carries the encoded map because {@link org.opensearch.cluster.metadata.IndexMetadata} stores custom metadata  
package org.opensearch.action.admin.indices.fielddomain;
import org.opensearch.core.common.io.stream.StreamInput;
import java.util.Map;
 * The OpenSearch Contributors require contributions made to  
/*  
     */
/**
     * Returns the encoded field-domain metadata carried by this request.  
        }  
     */  
    }
        super.writeTo(out);
    public int hashCode() {
 * implementing {@link IndicesRequest.Replaceable}; callers must not rewrite the target name without also preserving the
        return fieldDomainCustomData;  
                if (entry.getValue() == null) {
    /**
 *  
        targetIndex = new Index(in);
    }  
    public Index targetIndex() {
 * compatible open source license.
    private Index targetIndex;  
    }
import java.io.IOException;
                if (entry.getKey() == null || entry.getKey().isBlank()) {
@ExperimentalApi
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;
            && Objects.equals(fieldDomainCustomData, that.fieldDomainCustomData)
        Objects.requireNonNull(targetIndex, "targetIndex must not be null").writeTo(out);
        return fieldDomains(domains);  
        fieldDomainCustomData = IndexFieldDomainMetadata.getInstance().toCustomData(domains);
        return this;
 *
import org.opensearch.action.IndicesRequest;
        return Objects.hash(targetIndex, fieldDomainCustomData, clusterManagerNodeTimeout, timeout);
        return IndicesOptions.strictSingleIndexNoExpandForbidClosed();
        }
     */
        this.targetIndex = targetIndex;  
import org.opensearch.core.common.Strings;  
    public boolean equals(Object o) {
 * Request for publishing field-domain metadata to one concrete index.
    public void writeTo(StreamOutput out) throws IOException {  
        if (fieldDomainCustomData == null || fieldDomainCustomData.isEmpty()) {
        } else {  
        return validationException;
    public IndicesOptions indicesOptions() {
 * Producers should use {@link #fieldDomain(FieldDomain)} or {@link #fieldDomains(Collection)} so typed
 * @opensearch.experimental
 * this file be licensed under the Apache-2.0 license or a
    /**  
    public Map<String, String> fieldDomainCustomData() {
    @Override
    }
        domains.add(domain);
    }
        }
import static org.opensearch.action.ValidateActions.addValidationError;
 */  
                validationException = addValidationError("target index UUID is required", validationException);
            && Objects.equals(timeout, that.timeout);  
import java.util.List;
import org.opensearch.index.fielddomain.IndexFieldDomainMetadata;
    }
            return false;  
    /**  
 * SPDX-License-Identifier: Apache-2.0
import java.util.Collection;  
public class PutIndexFieldDomainsRequest extends AcknowledgedRequest<PutIndexFieldDomainsRequest> implements IndicesRequest {
import org.opensearch.index.fielddomain.FieldDomain;
            domains.addAll(IndexFieldDomainMetadata.getInstance().validateAndParseCustomData(fieldDomainCustomData));  
            validationException = addValidationError("field domain metadata is required", validationException);
            }
     * Deserializes the request from transport.
     * Creates a request for the exact target concrete index.
    public String[] indices() {
     */
                validationException = addValidationError("target index name is required", validationException);
            for (Map.Entry<String, String> entry : fieldDomainCustomData.entrySet()) {
        return targetIndex == null ? Strings.EMPTY_ARRAY : new String[] { targetIndex.getName() };  
    public PutIndexFieldDomainsRequest fieldDomain(FieldDomain domain) {
        if (targetIndex == null) {  
    @Override  
        ActionRequestValidationException validationException = null;
     */  
                }
        if (o == null || getClass() != o.getClass()) {
    }  
        out.writeMap(fieldDomainCustomData, StreamOutput::writeString, StreamOutput::writeString);  
    /**  
            if (targetIndex.getUUID().isBlank() || Strings.UNKNOWN_UUID_VALUE.equals(targetIndex.getUUID())) {  
        }
            return true;  
    public PutIndexFieldDomainsRequest(Index targetIndex) {  
    }  
    /**
        Objects.requireNonNull(domain, "domain must not be null");
                    validationException = addValidationError("field domain metadata values must not be null", validationException);  
            && Objects.equals(clusterManagerNodeTimeout, that.clusterManagerNodeTimeout)
    public PutIndexFieldDomainsRequest(StreamInput in) throws IOException {  
import org.opensearch.action.ActionRequestValidationException;
import org.opensearch.common.annotation.ExperimentalApi;
     * Encodes and adds one field domain to this request.
     */
 * {@link FieldDomain} objects are encoded through the central {@link IndexFieldDomainMetadata} codec. The transport
    @Override  
     * Sets the exact target concrete index.  
    public PutIndexFieldDomainsRequest fieldDomains(Collection<? extends FieldDomain> domains) {  
import java.util.ArrayList;
        fieldDomainCustomData = Map.copyOf(in.readMap(StreamInput::readString, StreamInput::readString));  
import org.opensearch.action.support.IndicesOptions;  
     * Returns the exact target concrete index.
        return targetIndex;
    /**
        List<FieldDomain> domains = new ArrayList<>();
     */
    @Override  
    public ActionRequestValidationException validate() {
