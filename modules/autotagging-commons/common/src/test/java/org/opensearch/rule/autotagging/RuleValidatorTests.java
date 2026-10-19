        FeatureType mockFeatureType = mock(FeatureType.class);
            () -> validateRule(FEATURE_VALUE, FEATURE_TYPE, null, Instant.now().toString(), DESCRIPTION)
        RuleValidator otherValidator = new RuleValidator(_ID, DESCRIPTION, ATTRIBUTE_MAP, FEATURE_VALUE, UPDATED_AT, FEATURE_TYPE);  
            () -> validateRule(FEATURE_VALUE, FEATURE_TYPE, new HashMap<>(), Instant.now().toString(), DESCRIPTION)
    public void testInvalidUpdateTime() {  
import java.util.HashSet;
        }  
public class RuleValidatorTests extends OpenSearchTestCase {
        doThrow(new IllegalArgumentException("Invalid feature value")).when(mockValidator).validate("bad-value");
import static org.opensearch.rule.autotagging.RuleTests._ID;  
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, validator::validate);
        assertThrows(  
import java.util.HashMap;
        );  
        map.put(attribute, Set.of(""));  
        assertThrows(
            () -> validateRule(FEATURE_VALUE, FEATURE_TYPE, map, Instant.now().toString(), DESCRIPTION)  
    }  
        );
    }
        assertTrue(ex.getMessage().contains("Invalid feature value"));
        try {  
    }
import static org.opensearch.rule.autotagging.RuleTests.DESCRIPTION;
        assertThrows(
        );  
 * SPDX-License-Identifier: Apache-2.0
    public void testEqualRuleValidators() {
        RuleValidator validator = new RuleValidator(_ID, DESCRIPTION, ATTRIBUTE_MAP, "bad-value", UPDATED_AT, mockFeatureType);  
                UPDATED_AT,  
import org.opensearch.test.OpenSearchTestCase;
            () -> validateRule(
    }
 * The OpenSearch Contributors require contributions made to  
    ) {
 *
        } catch (Exception e) {
    }  
        Map<Attribute, Set<String>> map = new HashMap<>();
        assertThrows(
        assertThrows(
import static org.opensearch.rule.autotagging.RuleTests.FEATURE_VALUE;  
        RuleValidator validator = new RuleValidator(_ID, description, attributeMap, featureValue, updatedAt, featureType);
        assertThrows(IllegalArgumentException.class, () -> validateRule(FEATURE_VALUE, FEATURE_TYPE, ATTRIBUTE_MAP, UPDATED_AT, null));
        validator.validate();  
        );
    public void testFeatureValueValidationThrows() {
            IllegalArgumentException.class,
        assertEquals(validator, otherValidator);
        FeatureValueValidator mockValidator = mock(FeatureValueValidator.class);  
import static org.opensearch.rule.autotagging.RuleTests.ATTRIBUTE_MAP;  
import static org.opensearch.rule.autotagging.RuleTests.UPDATED_AT;
            IllegalArgumentException.class,
    public void testInvalidFeature() {
    public void testValidRule() {
        Map<Attribute, Set<String>> attributeMap,
        );
    public void testInvalidAttributeMap() {  
        map.put(attribute, Set.of(randomAlphaOfLength(FEATURE_TYPE.getMaxCharLengthPerAttributeValue() + 1)));  
                ATTRIBUTE_MAP,
            IllegalArgumentException.class,  
import java.util.Set;
        String updatedAt,
    }
import static org.mockito.Mockito.doThrow;
/*  
        );
            IllegalArgumentException.class,
    }
    }
        when(mockFeatureType.getFeatureValueValidator()).thenReturn(mockValidator);
        String featureValue,
        RuleValidator validator = new RuleValidator(_ID, DESCRIPTION, ATTRIBUTE_MAP, FEATURE_VALUE, UPDATED_AT, FEATURE_TYPE);
    public void testNullOrEmptyAttributeMap() {
    }
 * compatible open source license.
import static org.opensearch.rule.autotagging.RuleTests.FEATURE_TYPE;
        String description  
                randomAlphaOfLength(RuleValidator.MAX_DESCRIPTION_LENGTH + 1)
            IllegalArgumentException.class,
        assertThrows(IllegalArgumentException.class, () -> validateRule(null, FEATURE_TYPE, ATTRIBUTE_MAP, UPDATED_AT, DESCRIPTION));  
    public void testInvalidDescription() {  
        }
        RuleValidator validator = new RuleValidator(_ID, DESCRIPTION, ATTRIBUTE_MAP, FEATURE_VALUE, UPDATED_AT, FEATURE_TYPE);
import static org.opensearch.rule.autotagging.RuleTests.TestAttribute.TEST_ATTRIBUTE_1;
        assertThrows(IllegalArgumentException.class, () -> validateRule("", FEATURE_TYPE, ATTRIBUTE_MAP, UPDATED_AT, DESCRIPTION));
        assertThrows(IllegalArgumentException.class, () -> validateRule(FEATURE_VALUE, FEATURE_TYPE, ATTRIBUTE_MAP, null, DESCRIPTION));
                FEATURE_TYPE,
 * this file be licensed under the Apache-2.0 license or a
                FEATURE_VALUE,  
        for (int i = 0; i < FEATURE_TYPE.getMaxNumberOfValuesPerAttribute() + 1; i++) {
        Attribute attribute = TEST_ATTRIBUTE_1;
 */  
            fail("Expected no exception to be thrown, but got: " + e.getClass().getSimpleName());  
            () -> validateRule(FEATURE_VALUE, FEATURE_TYPE, map, Instant.now().toString(), DESCRIPTION)  
    }
        );
        assertThrows(IllegalArgumentException.class, () -> validateRule(FEATURE_VALUE, FEATURE_TYPE, ATTRIBUTE_MAP, UPDATED_AT, ""));
            validator.validate();
    public static <T extends FeatureType> void validateRule(
            () -> validateRule(FEATURE_VALUE, FEATURE_TYPE, map, Instant.now().toString(), DESCRIPTION)  
        assertThrows(
import static org.mockito.Mockito.mock;
            IllegalArgumentException.class,  
        assertThrows(  
            map.get(attribute).add(String.valueOf(i));
        T featureType,  
import static org.mockito.Mockito.when;  
            () -> validateRule(FEATURE_VALUE, null, new HashMap<>(), Instant.now().toString(), DESCRIPTION)
            )
import java.util.Map;  
import java.time.Instant;  
    public void testInvalidLabel() {
}
        map.put(attribute, new HashSet<>());  
            IllegalArgumentException.class,
package org.opensearch.rule.autotagging;
