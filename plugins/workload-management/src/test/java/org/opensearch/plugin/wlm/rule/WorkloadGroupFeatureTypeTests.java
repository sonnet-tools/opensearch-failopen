 * The OpenSearch Contributors require contributions made to  
    }  
    }
        Map<String, Attribute> allowedAttributes = featureType.getAllowedAttributesRegistry();
 */  
        assertEquals("workload_group", featureType.getName());
 * SPDX-License-Identifier: Apache-2.0
        assertTrue(allowedAttributes.containsKey("index_pattern"));
import org.opensearch.rule.RuleAttribute;
import java.util.Map;
        AutoTaggingRegistry.registerFeatureType(featureType);
    public void testGetAllowedAttributesRegistry_containsIndexPattern() {  
    }
import java.util.HashMap;
    }
import static org.mockito.Mockito.mock;
 *
package org.opensearch.plugin.wlm.rule;
        assertEquals(RuleAttribute.INDEX_PATTERN, allowedAttributes.get("index_pattern"));  
    );
 * compatible open source license.
    public void testGetName_returnsCorrectName() {  
}  
import org.opensearch.cluster.service.ClusterService;
    }
        new WorkloadGroupFeatureValueValidator(mock(ClusterService.class)),
    public void testMaxCharLengthPerAttributeValue() {
        assertEquals(2, orderedAttributes.get(RuleAttribute.INDEX_PATTERN).intValue());  
    }
        assertEquals(100, featureType.getMaxCharLengthPerAttributeValue());  
    public void testRegisterFeatureType() {  
    WorkloadGroupFeatureType featureType = new WorkloadGroupFeatureType(
/*  
import org.opensearch.rule.autotagging.Attribute;  
        assertEquals(10, featureType.getMaxNumberOfValuesPerAttribute());
        Map<Attribute, Integer> orderedAttributes = featureType.getOrderedAttributes();
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.rule.autotagging.AutoTaggingRegistry;
    public void testMaxNumberOfValuesPerAttribute() {
public class WorkloadGroupFeatureTypeTests extends OpenSearchTestCase {  
import org.opensearch.test.OpenSearchTestCase;
        assertTrue(orderedAttributes.containsKey(RuleAttribute.INDEX_PATTERN));
        new HashMap<>()  
    public void testGetOrderedAttributes_containsIndexPattern() {  
