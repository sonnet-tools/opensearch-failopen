public class AttributeValueStoreFactoryTests extends OpenSearchTestCase {  
    public void testFeatureLevelStoreInitialisation() {  
 *
package org.opensearch.rule.storage;
    }
    public void setUp() throws Exception {
/*  
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.rule.utils.RuleTestUtils.MockRuleFeatureType;  
        super.setUp();
    @Override  
            sut.getAttributeValueStore(MockRuleAttributes.MOCK_RULE_ATTRIBUTE_ONE) instanceof DefaultAttributeValueStore<String, String>
    public void testInValidGetAttributeValueStore() {  
 * The OpenSearch Contributors require contributions made to  
 */  
        for (Attribute attribute : MockRuleFeatureType.INSTANCE.getAllowedAttributesRegistry().values()) {
        );  
 * SPDX-License-Identifier: Apache-2.0
}  
 * this file be licensed under the Apache-2.0 license or a
    public void testValidGetAttributeValueStore() {  
import org.opensearch.rule.utils.RuleTestUtils.MockRuleAttributes;
import org.opensearch.rule.autotagging.Attribute;
        assertThrows(IllegalArgumentException.class, () -> { sut.getAttributeValueStore(MockRuleAttributes.INVALID_ATTRIBUTE); });
            assertTrue(sut.getAttributeValueStore(attribute) instanceof DefaultAttributeValueStore<String, String>);
 * compatible open source license.
        }  
    }
    AttributeValueStoreFactory sut;
        assertTrue(
        sut = new AttributeValueStoreFactory(MockRuleFeatureType.INSTANCE, DefaultAttributeValueStore::new);  
    }
    }
