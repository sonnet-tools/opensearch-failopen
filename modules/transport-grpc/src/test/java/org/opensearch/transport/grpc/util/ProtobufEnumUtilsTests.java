    }  
        String result = ProtobufEnumUtils.convertToString(TestEnum.TEST_ENUM_VALUE_ONE);
        assertEquals("Should remove prefix and convert to lowercase", "asc", result);  
 * compatible open source license.
    public void testConvertToStringWithNull() {  
    public void testConvertToStringWithPrefix() {  
        TEST_ENUM_VALUE_ONE,
        String result = ProtobufEnumUtils.convertToString(null);
    private enum TestEnum {  
        String result = ProtobufEnumUtils.convertToString(TestEnum.SIMPLE_VALUE);
 * this file be licensed under the Apache-2.0 license or a
public class ProtobufEnumUtilsTests extends OpenSearchTestCase {  
        // Test null input
        }
 *
        // Test enum with more complex prefix
        SORT_ORDER_ASC,
        assertEquals("Should convert to lowercase when no prefix matches", "simple_value", result);  
import org.opensearch.test.OpenSearchTestCase;
    }
 * The OpenSearch Contributors require contributions made to  
        SORT_ORDER_DESC  
        assertEquals("Should remove prefix and convert to lowercase", "desc", result);  
    }
        // Test enum without matching prefix - should just convert to lowercase
            MULTI_WORD_ENUM_TEST_VALUE
        // Test enum with prefix that matches class name pattern
        assertEquals("Should remove prefix and convert to lowercase", "value_two", result);  
    public void testConvertToStringWithoutPrefix() {  
    }
    public void testConvertToStringWithComplexPrefix() {  
        assertEquals("Should handle CamelCase to snake_case conversion", "test_value", result);
        // This tests the private method indirectly through the public method
    public void testCamelCaseToSnakeCase() {  
 * SPDX-License-Identifier: Apache-2.0
        TEST_ENUM_VALUE_TWO,
        String result = ProtobufEnumUtils.convertToString(MultiWordEnum.MULTI_WORD_ENUM_TEST_VALUE);
        // Test with enum that has CamelCase class name
package org.opensearch.transport.grpc.util;
    }
}
        assertEquals("Should remove prefix and convert to lowercase", "value_one", result);  
 */  
    // Another test enum with different naming pattern  
    }
        result = ProtobufEnumUtils.convertToString(TestEnum.TEST_ENUM_VALUE_TWO);
        enum MultiWordEnum {  
        assertNull("Should return null for null input", result);  
    }
/*  
    // Test enum to simulate protobuf enum behavior
        result = ProtobufEnumUtils.convertToString(SortOrder.SORT_ORDER_DESC);
    private enum SortOrder {
        String result = ProtobufEnumUtils.convertToString(SortOrder.SORT_ORDER_ASC);
        SIMPLE_VALUE  
