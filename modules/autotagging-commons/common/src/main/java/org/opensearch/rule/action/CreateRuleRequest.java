 */  
    }
import org.opensearch.core.common.io.stream.StreamInput;  
     */
        rule = new Rule(in);
    /**  
    public CreateRuleRequest(StreamInput in) throws IOException {
package org.opensearch.rule.action;
/**  
        return rule;
     * Constructs a CreateRuleRequest from a StreamInput for deserialization
    public CreateRuleRequest(Rule rule) {  
 *      "description": "description1",
}  
    public Rule getRule() {  
import org.opensearch.action.ActionRequest;
import java.io.IOException;
 * The OpenSearch Contributors require contributions made to  
        rule.writeTo(out);  
 * compatible open source license.
     * rule getter
 * Example request:
    /**
    }
 * }'
 * this file be licensed under the Apache-2.0 license or a
    public void writeTo(StreamOutput out) throws IOException {
 * {
 *      "attribute_name": ["log*", "event*"],  
 * curl -X PUT "localhost:9200/_rules/{featureType}/" -H 'Content-Type: application/json' -d '  
    }
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.action.ActionRequestValidationException;
    /**
        return null;  
     */
     */
    }
public class CreateRuleRequest extends ActionRequest {
    @Override  
import org.opensearch.rule.autotagging.Rule;
    }
 *
 * @opensearch.experimental  
 * A request for create Rule
 *      "feature_type": "poOiU851RwyLYvV5lbvv5w"
     * @param in - The {@link StreamInput} instance to read from.  
     * constructor for CreateRuleRequest  
        super(in);  
 * SPDX-License-Identifier: Apache-2.0
/*  
    public ActionRequestValidationException validate() {
     * @param rule the rule to create
    private final Rule rule;  
        super.writeTo(out);
    @Override
        this.rule = rule;
 */
