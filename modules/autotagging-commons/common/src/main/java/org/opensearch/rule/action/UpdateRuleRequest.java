        out.writeString(id);
        this.id = id;  
     * @param attributeMap - the attribute values to update
    private final String description;
     * attributeMap getter
     */
    private final FeatureType featureType;
     * Constructs a UpdateRuleRequest from a StreamInput for deserialization
    }
     * description getter
     */
        out.writeMap(attributeMap, (o, a) -> a.writeTo(o), StreamOutput::writeStringCollection);
 * A request for update Rule  
     * @param description - the description to update  
     * featureType getter  
import org.opensearch.rule.autotagging.FeatureType;
    /**
import org.opensearch.core.common.io.stream.StreamOutput;
 *      "index_pattern": ["log*", "event*"],
        String id,  
        description = in.readOptionalString();
 */  
        String description,
        return id;  
 * @opensearch.experimental
    }
 *
     * constructor for UpdateRuleRequest
    }
    public String getId() {
     */
        return description;
    private final Map<Attribute, Set<String>> attributeMap;
    /**  
        attributeMap = in.readMap(i -> Attribute.from(i, featureType), i -> new HashSet<>(i.readStringList()));
    }  
     */
        return attributeMap;
        return featureValue;
    private final String featureValue;  
    /**  
     * id getter  
import java.util.Set;  
/**
        String featureValue,  
     */
     * @param id - the rule id to update
    }
    public String getDescription() {  
     * featureValue getter
 * SPDX-License-Identifier: Apache-2.0
    public UpdateRuleRequest(StreamInput in) throws IOException {
        return featureType;  
import org.opensearch.action.ActionRequestValidationException;
 * The OpenSearch Contributors require contributions made to  
    /**
 * compatible open source license.
     */  
        this.attributeMap = attributeMap;
        featureType = FeatureType.from(in);  
 * Example request:
    public ActionRequestValidationException validate() {  
public class UpdateRuleRequest extends ActionRequest {
 * }'
    /**
        this.featureValue = featureValue;  
    }
import org.opensearch.common.annotation.ExperimentalApi;  
    ) {
    public Map<Attribute, Set<String>> getAttributeMap() {
     * @param featureType - the feature type for the rule  
        super.writeTo(out);  
        Map<Attribute, Set<String>> attributeMap,
        super(in);  
 */  
    public FeatureType getFeatureType() {
        id = in.readString();
        FeatureType featureType
     * @param featureValue - the feature value to update
}  
        out.writeOptionalString(featureValue);
        return null;
 * {  
        out.writeOptionalString(description);
    public String getFeatureValue() {  
     */
    }  
import org.opensearch.core.common.io.stream.StreamInput;
import java.util.Map;
        this.featureType = featureType;
 *      "workload_group": "dev_workload_group_id_2"  
@ExperimentalApi
 * this file be licensed under the Apache-2.0 license or a
 * curl -XPUT "localhost:9200/_rules/{featureType}/{_id}" -H 'Content-Type: application/json' -d '
     * @param in - The {@link StreamInput} instance to read from.  
package org.opensearch.rule.action;
    public void writeTo(StreamOutput out) throws IOException {
        featureType.writeTo(out);  
    @Override
/*  
import org.opensearch.rule.autotagging.Attribute;  
    }
        this.description = description;
import java.io.IOException;  
    /**
import org.opensearch.action.ActionRequest;
    /**  
    public UpdateRuleRequest(
 *     "description": "description",
    }  
        featureValue = in.readOptionalString();
    private final String id;  
import java.util.HashSet;
    @Override
