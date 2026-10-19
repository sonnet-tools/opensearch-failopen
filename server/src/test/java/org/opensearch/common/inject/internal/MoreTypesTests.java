        assertEquals(Object.class, MoreTypes.getRawType(typeVar));
        assertEquals("? extends java.lang.String", MoreTypes.toString(upperBoundedWildcard));  
    public void testHashCode() {
        assertEquals("Unsupported wildcard type [null]", exception.getMessage());  
    public void testToString() {
            UnsupportedOperationException.class,  
        assertTrue(nullException.getMessage().contains("Unsupported type [null]"));
            new java.lang.reflect.Type[] { Object.class },  
        assertEquals(0, MoreTypes.hashCode(null));
        assertEquals(expectedWildcardHash, MoreTypes.hashCode(wildcardType));
public class MoreTypesTests extends OpenSearchTestCase {
 */  
 * compatible open source license.
        );
        MoreTypes.ParameterizedTypeImpl paramType = new MoreTypes.ParameterizedTypeImpl(null, java.util.List.class, String.class);
import org.opensearch.test.OpenSearchTestCase;
        MoreTypes.WildcardTypeImpl upperBoundedWildcard = new MoreTypes.WildcardTypeImpl(
    }  
        assertEquals("? super java.lang.String", MoreTypes.toString(lowerBoundedWildcard));  
        int expectedParamHash = java.util.Arrays.hashCode(new Type[] { String.class }) ^ java.util.List.class.hashCode();  
        MoreTypes.WildcardTypeImpl lowerBoundedWildcard = new MoreTypes.WildcardTypeImpl(
package org.opensearch.common.inject.internal;
        MoreTypes.WildcardTypeImpl wildcardType = new MoreTypes.WildcardTypeImpl(new Type[] { String.class }, new Type[] {});  
        assertEquals("java.lang.String", MoreTypes.toString(String.class));  
        assertEquals(java.util.List.class, MoreTypes.getRawType(paramType));
/*  
            () -> { MoreTypes.toString((Type) null); }
 * SPDX-License-Identifier: Apache-2.0
 *
            new java.lang.reflect.Type[] {}
        MoreTypes.ParameterizedTypeImpl paramType = new MoreTypes.ParameterizedTypeImpl(null, java.util.List.class, String.class);
        assertEquals(String.class.hashCode(), MoreTypes.hashCode(arrayType));
        assertEquals(String.class.hashCode(), MoreTypes.hashCode(String.class));  
            new java.lang.reflect.Type[] { String.class },  
}
    }  
        );
        MoreTypes.WildcardTypeImpl wildcardType = new MoreTypes.WildcardTypeImpl(new Type[] { String.class }, new Type[] {});  
        MoreTypes.GenericArrayTypeImpl arrayType = new MoreTypes.GenericArrayTypeImpl(String.class);  
        );
    }
        IllegalArgumentException wildcardException = expectThrows(IllegalArgumentException.class, () -> MoreTypes.getRawType(wildcardType));
        MoreTypes.WildcardTypeImpl unboundedWildcard = new MoreTypes.WildcardTypeImpl(
        assertTrue(wildcardException.getMessage().contains("Expected a Class, ParameterizedType, or GenericArrayType"));
        assertEquals("java.lang.String[]", MoreTypes.toString(arrayType));  
        assertEquals("java.util.List<java.lang.String>", MoreTypes.toString(paramType));  
            new java.lang.reflect.Type[] {}
        assertEquals("?", MoreTypes.toString(unboundedWildcard));  
        assertEquals(Object[].class, MoreTypes.getRawType(arrayType));
        UnsupportedOperationException exception = expectThrows(
        IllegalArgumentException nullException = expectThrows(IllegalArgumentException.class, () -> MoreTypes.getRawType(null));
        int expectedWildcardHash = java.util.Arrays.hashCode(new Type[] {}) ^ java.util.Arrays.hashCode(new Type[] { String.class });
        MoreTypes.ParameterizedTypeImpl paramType = new MoreTypes.ParameterizedTypeImpl(null, java.util.List.class, String.class);  
        java.lang.reflect.TypeVariable<?> typeVar = java.util.List.class.getTypeParameters()[0];  
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
        MoreTypes.GenericArrayTypeImpl arrayType = new MoreTypes.GenericArrayTypeImpl(String.class);
            new java.lang.reflect.Type[] { Object.class },  
        assertEquals(expectedParamHash, MoreTypes.hashCode(paramType));
        MoreTypes.GenericArrayTypeImpl arrayType = new MoreTypes.GenericArrayTypeImpl(String.class);  
    public void testGetRawType() {  
        );
import java.lang.reflect.Type;  
        assertEquals(String.class, MoreTypes.getRawType(String.class));
            new java.lang.reflect.Type[] { String.class }
