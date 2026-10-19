     */  
 * Example response:
    @Override
import org.opensearch.core.xcontent.ToXContent;
 *     "workload_group": "workload_group_id",
import java.io.IOException;
    public UpdateRuleResponse(final Rule rule) {
 * The OpenSearch Contributors require contributions made to  
    public void writeTo(StreamOutput out) throws IOException {  
     * rule getter
    }
 *     "description": "Rule for tagging workload_group_id to index123"
/*  
    /**  
        return rule;
import org.opensearch.core.xcontent.ToXContentObject;  
    /**
    public UpdateRuleResponse(StreamInput in) throws IOException {
 * {  
    /**  
public class UpdateRuleResponse extends ActionResponse implements ToXContent, ToXContentObject {
     */
     * Constructs a UpdateRuleResponse from a StreamInput for deserialization
/**  
    public Rule getRule() {  
 * @opensearch.experimental
     * @param rule - the updated rule  
        this(new Rule(in));
     * constructor for UpdateRuleResponse
    }
import org.opensearch.core.common.io.stream.StreamInput;  
 *
    private final Rule rule;
 * this file be licensed under the Apache-2.0 license or a
 *     "updated_at": "2025-02-14T01:19:22.589Z"
package org.opensearch.rule.action;
import org.opensearch.core.common.io.stream.StreamOutput;
 *     id": "z1MJApUB0zgMcDmz-UQq",
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.core.action.ActionResponse;
}  
        return rule.toXContent(builder, params);  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
    }  
 * Response for the update API for Rule
 */  
import org.opensearch.rule.autotagging.Rule;
 */
import org.opensearch.common.annotation.ExperimentalApi;
 *     "index_pattern": ["index123"],  
    @Override
        rule.writeTo(out);
    }
     * @param in - The {@link StreamInput} instance to read from.
    }
@ExperimentalApi  
import org.opensearch.core.xcontent.XContentBuilder;
        this.rule = rule;  
 * }  
     */
