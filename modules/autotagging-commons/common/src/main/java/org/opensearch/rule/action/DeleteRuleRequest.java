        this.featureType = FeatureType.from(in.readString());  
     * @param featureType The feature type associated with the rule.
import org.opensearch.core.common.io.stream.StreamInput;
    }  
        return null;
 *
     * @param in Stream input
            return validationException;  
        return ruleId;
    }  
     * Returns the feature type associated with the rule.  
    FeatureType getFeatureType() {
        out.writeString(ruleId);  
     * @param ruleId The ID of the rule to delete.  
     *
 * this file be licensed under the Apache-2.0 license or a
    }
     * Constructs a request to delete a rule.
    @Override
        return featureType;
 */  
import org.opensearch.action.ActionRequest;
/*  
     * Deserialization constructor  
    private final String ruleId;  
     * @return The feature type.
        }
    }  
/**
 * compatible open source license.
 * A request to delete a Rule by ID
import org.opensearch.action.ActionRequestValidationException;
import org.opensearch.common.annotation.ExperimentalApi;  
        super(in);
public class DeleteRuleRequest extends ActionRequest {
    }
import java.io.IOException;
import org.opensearch.rule.autotagging.FeatureType;  
        this.ruleId = in.readString();
     */  
    public String getRuleId() {
 * curl -XDELETE "localhost:9200/_rules/{featureType}/{_id}"
     *
package org.opensearch.rule.action;
     */
    /**
    /**
}
     */
    }  
        if (ruleId == null || ruleId.isEmpty()) {  
@ExperimentalApi
 */  
        featureType.writeTo(out);
 * Example:  
        super.writeTo(out);
        this.featureType = featureType;
     * Returns the ID of the rule to be deleted.  
            validationException.addValidationError("Rule ID is missing");
        this.ruleId = ruleId;
     */  
    public void writeTo(StreamOutput out) throws IOException {
            ActionRequestValidationException validationException = new ActionRequestValidationException();
    @Override  
    /**  
 * @opensearch.experimental
    /**
import org.opensearch.core.common.io.stream.StreamOutput;
 * SPDX-License-Identifier: Apache-2.0
    public DeleteRuleRequest(String ruleId, FeatureType featureType) {  
    public DeleteRuleRequest(StreamInput in) throws IOException {  
     *
    public ActionRequestValidationException validate() {
    private final FeatureType featureType;
     * @return The rule ID.
 * The OpenSearch Contributors require contributions made to  
