import org.opensearch.ResourceNotFoundException;
 * compatible open source license.
import org.opensearch.test.OpenSearchTestCase;  
    public void testGetFeatureType_Success() {
 * The OpenSearch Contributors require contributions made to  
        when(featureType.getOrderedAttributes()).thenReturn(null);  
            @Override
 */  
import static org.opensearch.rule.autotagging.RuleTests.INVALID_FEATURE;  
        when(featureType.getName()).thenReturn(FEATURE_TYPE_NAME);
            public void validate(String featureValue) {}  
package org.opensearch.rule.autotagging;
    }
        assertThrows(IllegalStateException.class, () -> AutoTaggingRegistry.registerFeatureType(featureType));
        assertEquals(FEATURE_TYPE_NAME, retrievedFeatureType.getName());  
    @BeforeClass
        assertThrows(IllegalStateException.class, () -> AutoTaggingRegistry.registerFeatureType(featureType));
public class AutoTaggingRegistryTests extends OpenSearchTestCase {
import org.opensearch.rule.utils.RuleTestUtils;
        when(featureType.getFeatureValueValidator()).thenReturn(null);  
    }
 * SPDX-License-Identifier: Apache-2.0
        assertThrows(IllegalStateException.class, () -> AutoTaggingRegistry.registerFeatureType(null));
}  
import org.junit.BeforeClass;
        });
        FeatureType featureType = mock(FeatureType.class);
 *
import static org.mockito.Mockito.when;  
    }
        when(featureType.getOrderedAttributes()).thenReturn(new HashMap<>());
        when(featureType.getFeatureValueValidator()).thenReturn(new FeatureValueValidator() {
    public void testIllegalStateExceptionException() {
    public static void setUpOnce() {
/*  
        assertThrows(ResourceNotFoundException.class, () -> AutoTaggingRegistry.getFeatureType(INVALID_FEATURE));
        AutoTaggingRegistry.registerFeatureType(featureType);
        FeatureType retrievedFeatureType = AutoTaggingRegistry.getFeatureType(FEATURE_TYPE_NAME);
        FeatureType featureType = RuleTestUtils.MockRuleFeatureType.INSTANCE;  
    }
import java.util.HashMap;  
        when(featureType.getName()).thenReturn(randomAlphaOfLength(MAX_FEATURE_TYPE_NAME_LENGTH + 1));
 * this file be licensed under the Apache-2.0 license or a
        assertThrows(IllegalStateException.class, () -> AutoTaggingRegistry.registerFeatureType(featureType));
        when(featureType.getName()).thenReturn(FEATURE_TYPE_NAME);
    public void testRuntimeException() {  
import static org.opensearch.rule.autotagging.AutoTaggingRegistry.MAX_FEATURE_TYPE_NAME_LENGTH;
import static org.opensearch.rule.utils.RuleTestUtils.FEATURE_TYPE_NAME;
import static org.mockito.Mockito.mock;
