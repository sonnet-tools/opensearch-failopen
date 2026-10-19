 * SPDX-License-Identifier: Apache-2.0
    }
            IllegalArgumentException.class,  
        IllegalArgumentException ex = assertThrows(
 * this file be licensed under the Apache-2.0 license or a
    public void testGetRulePersistenceService_UnknownFeature() {  
    }
public class RulePersistenceServiceRegistryTests extends OpenSearchTestCase {
 * compatible open source license.
        );
    FeatureType mockFeatureType = mock(FeatureType.class);  
        assertSame(mockService, retrievedService);
        when(mockFeatureType.getName()).thenReturn("duplicate_feature");
    RulePersistenceService mockService = mock(RulePersistenceService.class);
 *
        when(mockFeatureType.getName()).thenReturn("unknown_feature");
            () -> registry.register(mockFeatureType, anotherService)
package org.opensearch.rule;
/*  
import org.opensearch.test.OpenSearchTestCase;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.rule.autotagging.FeatureType;
 */  
}
        RulePersistenceService retrievedService = registry.getRulePersistenceService(mockFeatureType);  
    public void testRegisterAndGetService() {  
        assertTrue(ex.getMessage().contains("Unknown feature type"));  
        registry.register(mockFeatureType, mockService);
    RulePersistenceServiceRegistry registry = new RulePersistenceServiceRegistry();
import static org.mockito.Mockito.mock;
        when(mockFeatureType.getName()).thenReturn("test_feature");
    public void testRegisterDuplicateService() {
        IllegalArgumentException ex = assertThrows(
        registry.register(mockFeatureType, mockService);  
    }
            () -> registry.getRulePersistenceService(mockFeatureType)
        assertTrue(ex.getMessage().contains("Duplicate rule persistence service: duplicate_feature"));  
import static org.mockito.Mockito.when;
            IllegalArgumentException.class,  
        RulePersistenceService anotherService = mock(RulePersistenceService.class);
        );
