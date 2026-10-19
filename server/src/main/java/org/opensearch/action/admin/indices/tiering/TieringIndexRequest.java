            && Objects.equals(indicesOptions, that.indicesOptions)
/**
        HOT,
     * @return true if the operation will wait for completion
        indices = in.readStringArray();
    public Tier tier() {
        public String value() {
        return indicesOptions;
    public TieringIndexRequest(String targetTier, String... indices) {
    }
        if (o == null || getClass() != o.getClass()) {
    public TieringIndexRequest(StreamInput in) throws IOException {  
        this.indicesOptions = IndicesOptions.fromOptions(false, false, true, false);
     *
            validationException = addValidationError("The specified tier is not supported", validationException);
    }  
                throw new IllegalArgumentException("Tiering type cannot be null");
 * The OpenSearch Contributors require contributions made to  
            switch (upperCase) {
 * this file be licensed under the Apache-2.0 license or a
     * Returns wait for completion setting  
@ExperimentalApi  
    @Override
import java.util.Locale;
        this.waitForCompletion = false;  
    }
import org.opensearch.action.IndicesRequest;
import org.opensearch.action.support.IndicesOptions;  
    }  
 */
 * @opensearch.experimental
                    return HOT;  
    public TieringIndexRequest indices(String... indices) {
    public ActionRequestValidationException validate() {
        this.targetTier = Tier.fromString(targetTier);  
            && targetTier.equals(that.targetTier)
    public boolean equals(Object o) {
        return validationException;
     */
                    return WARM;
        out.writeString(targetTier.value());
                default:  
        this.indicesOptions = indicesOptions;  
            return name().toLowerCase(Locale.ROOT);
        out.writeStringArray(indices);
import org.opensearch.common.annotation.ExperimentalApi;
 *  
    @Override
        this.waitForCompletion = waitForCompletion;
 * Represents the tiering request for indices to move to a different tier
        return this;  
    private final Tier targetTier;
    }  
package org.opensearch.action.admin.indices.tiering;
    }
            && Arrays.equals(indices, that.indices)  
                        "Tiering type [" + name + "] is not supported. Supported types are " + HOT + " and " + WARM
     */  
 *
                case "WARM":
     * @opensearch.experimental
        this.targetTier = targetTier;
    public boolean includeDataStreams() {  
    }  
    }
            && waitForCompletion == that.waitForCompletion;
 * compatible open source license.
        return indices;  
        return this;
    @Override
    }  
    // pkg private for testing
    /**
        if (!Tier.WARM.equals(targetTier)) {
                    throw new IllegalArgumentException(
    @Override
        }  
            return false;  
    }
    public TieringIndexRequest waitForCompletion(boolean waitForCompletion) {  
        if (indices == null) {
    public IndicesOptions indicesOptions() {
            && timeout.equals(that.timeout)
     */
    /**
    }
        return Objects.hash(clusterManagerNodeTimeout, timeout, indicesOptions, waitForCompletion, Arrays.hashCode(indices));
        TieringIndexRequest that = (TieringIndexRequest) o;
            for (String index : indices) {
            return true;  
    private boolean waitForCompletion;  
        this.indices = indices;
    }
    public TieringIndexRequest indicesOptions(IndicesOptions indicesOptions) {
        this.indices = indices;  
import java.util.Objects;  
            }
    @Override  
        return clusterManagerNodeTimeout.equals(that.clusterManagerNodeTimeout)  
        }
                        String.format(Locale.ROOT, "Specified index in the request [%s] is null or empty", index),
        indicesOptions = IndicesOptions.readIndicesOptions(in);
        waitForCompletion = in.readBoolean();
import java.util.Arrays;
    @ExperimentalApi  
                        validationException
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.ActionRequestValidationException;
    public int hashCode() {  
        }  
     *
     * @param waitForCompletion if true the operation will wait for completion  
        super.writeTo(out);  
            validationException = addValidationError("Mandatory parameter - indices is missing from the request", validationException);
        super(in);
                    );  
    private String[] indices;  
            }
        return true;
    public boolean waitForCompletion() {
        }
                    );  
        return this;
public class TieringIndexRequest extends AcknowledgedRequest<TieringIndexRequest> implements IndicesRequest.Replaceable {
        out.writeBoolean(waitForCompletion);
    public String[] indices() {
    /**  
import org.opensearch.core.common.io.stream.StreamInput;  
        return waitForCompletion;
     *  
     * Represents the supported tiers for an index
        }  
            String upperCase = name.trim().toUpperCase(Locale.ROOT);  
    @Override
                if (index == null || index.length() == 0) {
        this.indices = indices;
        if (this == o) {
        targetTier = Tier.fromString(in.readString());  
    @Override
    }
        indicesOptions.writeIndicesOptions(out);  
        WARM;  
        this.waitForCompletion = waitForCompletion;
     * If this parameter is set to true the operation will wait for completion of tiering process before returning.
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;
    }
}
                    validationException = addValidationError(  
                }
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.common.io.stream.StreamOutput;
import static org.opensearch.action.ValidateActions.addValidationError;
    TieringIndexRequest(Tier targetTier, IndicesOptions indicesOptions, boolean waitForCompletion, String... indices) {  
     * @return this request
                case "HOT":
import java.io.IOException;  
    }
            if (name == null) {  
    public enum Tier {
/*  
        return targetTier;  
    }
        }
            }
        ActionRequestValidationException validationException = null;  
 */  
    @Override  
        public static Tier fromString(String name) {
        this.indicesOptions = indicesOptions;
    private IndicesOptions indicesOptions;
        } else {  
