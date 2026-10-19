        out.writeList(rules);
 *     "rules": [
package org.opensearch.rule.action;
    }
    private final List<Rule> rules;  
        for (Rule rule : rules) {
import java.io.IOException;
public class GetRuleResponse extends ActionResponse implements ToXContent, ToXContentObject {
    }
 *         },  
import org.opensearch.core.common.io.stream.StreamOutput;
    private final String searchAfter;
        out.writeOptionalString(searchAfter);  
 *             "id": "z1MJApUB0zgMcDmz-UQq",
        }
    public GetRuleResponse(StreamInput in) throws IOException {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 *     ],
    public List<Rule> getRules() {  
    }
    /**  
import org.opensearch.core.common.io.stream.StreamInput;  
 * @opensearch.experimental
 * }
    /**
     */
    }
        if (searchAfter != null && !searchAfter.isEmpty()) {
@ExperimentalApi
     * @param in - The {@link StreamInput} instance to read from.  
import org.opensearch.core.xcontent.ToXContent;
 *             "index_pattern": ["index123"],  
    public GetRuleResponse(final List<Rule> rules, String searchAfter) {
 * compatible open source license.
 *             "description": "Rule for tagging workload_group_id to index123"
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.action.ActionResponse;
    public void writeTo(StreamOutput out) throws IOException {
 * {
 *
     * @param rules - Rules get from the request
            builder.field("search_after", new Object[] { searchAfter });  
 *     "search_after": ["z1MJApUB0zgMcDmz-UQq"]  
 *             "updated_at": "2025-02-14T01:19:22.589Z"
     * Constructs a GetRuleResponse from a StreamInput for deserialization
            rule.toXContent(builder, params);
/*  
        builder.endArray();
import org.opensearch.rule.autotagging.Rule;
        builder.startObject();
     */
    /**  
     * @param searchAfter - The sort value used for pagination.  
     * rules getter
 * Example response:  
 *         ...
 *         {  
import org.opensearch.common.annotation.ExperimentalApi;
import org.opensearch.core.xcontent.ToXContentObject;  
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
        return rules;
}  
        this.searchAfter = searchAfter;
        this.rules = rules;  
    }
import org.opensearch.core.xcontent.XContentBuilder;
    @Override  
        return builder;  
import java.util.List;
        this(in.readList(Rule::new), in.readOptionalString());  
        builder.startArray("rules");  
 */  
    @Override  
/**
 */  
        }  
     * Constructor for GetRuleResponse
        builder.endObject();
 *             "workload_group": "workload_group_id",
 * Response for the get API for Rule.
     */
