    public Rule getRule() {
    public CreateRuleResponse(StreamInput in) throws IOException {
 */
import org.opensearch.core.xcontent.XContentBuilder;  
 * Example response:
     * contructor for CreateRuleResponse  
     * Constructs a CreateRuleResponse from a StreamInput for deserialization
import org.opensearch.core.xcontent.ToXContentObject;
        return rule.toXContent(builder, params);
/**
import org.opensearch.core.common.io.stream.StreamInput;
import java.io.IOException;  
 * {
 * Response for the create API for Rule  
 * }
}
 * The OpenSearch Contributors require contributions made to  
    }
    public CreateRuleResponse(final Rule rule) {  
     */
package org.opensearch.rule.action;
     * rule getter
 * this file be licensed under the Apache-2.0 license or a
 *    "updated_at":"2025-04-04T20:54:22.406Z"
    private final Rule rule;  
        return rule;
import org.opensearch.core.action.ActionResponse;
 * compatible open source license.
     * @param in - The {@link StreamInput} instance to read from.  
/*  
     * @param rule - the rule created
    }  
    @Override
 *    "index_pattern":["log*", "uvent*"],
public class CreateRuleResponse extends ActionResponse implements ToXContent, ToXContentObject {
    /**
    }
 * @opensearch.experimental  
        this.rule = rule;
import org.opensearch.rule.autotagging.Rule;
 *    "workload_group":"poOiU851RwyLYvV5lbvv5w",  
     */
     */  
 */  
        rule.writeTo(out);
import org.opensearch.core.common.io.stream.StreamOutput;  
import org.opensearch.core.xcontent.ToXContent;
    }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
    @Override  
    }  
 *    "id":"wi6VApYBoX5wstmtU_8l",  
 *
    /**
    public void writeTo(StreamOutput out) throws IOException {
 *    "description":"description1",
 * SPDX-License-Identifier: Apache-2.0
        rule = new Rule(in);  
    /**
