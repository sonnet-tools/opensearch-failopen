     */
 * @opensearch.experimental  
     * id getter
import org.opensearch.rule.autotagging.RuleValidator;
     * @param attributeFilters - Rules will be filtered based on the attribute-value mappings.  
            throw new IllegalArgumentException(Rule.ID_STRING + " cannot be empty.");
 * curl -X GET "localhost:9200/_rules/{featureType}/{_id}" - get single rule by id
 * The OpenSearch Contributors require contributions made to  
     * searchAfter getter
public class GetRuleRequest extends ActionRequest {  
    }  
     * @param in - The {@link StreamInput} instance to read from.
    }
 *
        if (RuleValidator.isEmpty(id)) {
 */  
    @Override
     * @param featureType - The feature type related to rule.
    /**
import org.opensearch.rule.autotagging.Rule;
import org.opensearch.action.ActionRequestValidationException;
        return searchAfter;
import java.util.Map;  
     */  
 * A request for get Rule
     */  
            throw new IllegalArgumentException("search_after cannot be empty.");
import org.opensearch.action.ActionRequest;
        out.writeOptionalString(searchAfter);
     * @param id - Rule id to get
    }  
import org.opensearch.core.common.io.stream.StreamInput;
    }
        featureType.writeTo(out);
     * Constructor for GetRuleRequest
    }
        super.writeTo(out);  
        this.attributeFilters = attributeFilters;  
        this.featureType = featureType;
        }  
package org.opensearch.rule.action;
    public void writeTo(StreamOutput out) throws IOException {
 */
        return featureType;  
    public FeatureType getFeatureType() {
     * @param searchAfter - The sort value used for pagination.
        out.writeOptionalString(id);
    public GetRuleRequest(String id, Map<String, Set<String>> attributeFilters, String searchAfter, FeatureType featureType) {
    public Map<String, Set<String>> getAttributeFilters() {
        attributeFilters = in.readMap(StreamInput::readString, i -> new HashSet<>(i.readStringList()));
        this.id = id;
     */
    /**
 * curl -X GET "localhost:9200/_rules/{featureType}?index_pattern=a,b" - get all rules containing attribute index_pattern as a or b for {featureType}
    private final String id;
import org.opensearch.core.common.io.stream.StreamOutput;
import java.util.Set;
    }
        id = in.readOptionalString();
 * SPDX-License-Identifier: Apache-2.0
    }
        if (RuleValidator.isEmpty(searchAfter)) {
    @Override
 * compatible open source license.
     */
     * @return  
        return attributeFilters;  
    public ActionRequestValidationException validate() {  
import org.opensearch.common.annotation.ExperimentalApi;  
import java.util.HashSet;
    private final FeatureType featureType;
/*  
     * Constructs a GetRuleRequest from a StreamInput for deserialization.  
 * Example Request:
        featureType = FeatureType.from(in);  
        return id;
    public String getId() {
    public GetRuleRequest(StreamInput in) throws IOException {  
import java.io.IOException;
    public String getSearchAfter() {  
    }  
    /**  
@ExperimentalApi
        return null;
}
    /**
        this.searchAfter = searchAfter;
     * FeatureType getter
    private final String searchAfter;  
        out.writeMap(attributeFilters, StreamOutput::writeString, StreamOutput::writeStringCollection);  
     */
 * curl -X GET "localhost:9200/_rules/{featureType}/" - get all rules for {featureType}  
        super(in);
        searchAfter = in.readOptionalString();
    /**
    private final Map<String, Set<String>> attributeFilters;
    /**  
        }  
     * attributeFilters getter  
/**  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.rule.autotagging.FeatureType;  
