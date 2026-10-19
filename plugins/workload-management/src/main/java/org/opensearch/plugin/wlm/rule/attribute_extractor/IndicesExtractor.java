 * SPDX-License-Identifier: Apache-2.0
    /**
import org.opensearch.action.IndicesRequest;
 * The OpenSearch Contributors require contributions made to  
public class IndicesExtractor implements AttributeExtractor<String> {
    public Iterable<String> extract() {  
    }
        return AND;  
import org.opensearch.rule.attribute_extractor.AttributeExtractor;  
    }  
    @Override
    @Override  
    @Override
 * this file be licensed under the Apache-2.0 license or a
 *
/*  
     * @param indicesRequest  
        return RuleAttribute.INDEX_PATTERN;
    private final IndicesRequest indicesRequest;
 * This class extracts the indices from a request
 */  
     * Default constructor
 */  
import org.opensearch.rule.RuleAttribute;
        this.indicesRequest = indicesRequest;  
    }
import org.opensearch.rule.autotagging.Attribute;
     */
    }
import static org.opensearch.rule.attribute_extractor.AttributeExtractor.LogicalOperator.AND;
package org.opensearch.plugin.wlm.rule.attribute_extractor;
import java.util.List;  
}
    public LogicalOperator getLogicalOperator() {
 * compatible open source license.
    public IndicesExtractor(IndicesRequest indicesRequest) {
        return List.of(indicesRequest.indices());
    public Attribute getAttribute() {
/**
