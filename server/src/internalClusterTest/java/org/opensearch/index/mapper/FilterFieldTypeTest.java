import java.util.HashSet;  
 *
    private static final class MethodSignature {  
                && Objects.deepEquals(parameterTypes, that.parameterTypes);
        }  
            if (method.getDeclaringClass() == FilterFieldType.class) {  
    }  
        for (Method method : filterFieldTypeMethods) {
                    new MethodSignature(method.getName(), method.getReturnType(), method.getParameterTypes())
import java.lang.reflect.Modifier;
        public MethodSignature(String name, Class<?> returnType, Class<?>[] parameterTypes) {
package org.opensearch.index.mapper;
        }  
            return Objects.equals(name, that.name)  
                && Modifier.isFinal(method.getModifiers()) == false
            }
        Set<MethodSignature> filterFieldTypeMethodSignatures = new HashSet<>();
        @Override
        Method[] mappedFieldTypeMethods = MappedFieldType.class.getMethods();
        }
                assertTrue(
 */  
            }
import java.lang.reflect.Method;  
            } else {  
            MethodSignature that = (MethodSignature) o;
        @Override
        private final String name;
                && Objects.equals(returnType, that.returnType)
/*  
        }
                mappedFieldTypeMethodSignatures.add(
 * compatible open source license.
            this.parameterTypes = parameterTypes;
            this.returnType = returnType;
import java.util.Arrays;
                    EXCLUDED_SIGNATURES.contains(methodSignature)  
                    new MethodSignature(method.getName(), method.getReturnType(), method.getParameterTypes())
        for (Method method : mappedFieldTypeMethods) {  
    public void testAllMethodsDelegated() {
 * SPDX-License-Identifier: Apache-2.0
        public boolean equals(Object o) {  
                filterFieldTypeMethodSignatures.add(
import org.opensearch.test.OpenSearchTestCase;
                );
        public int hashCode() {  
        }
                    EXCLUDED_SIGNATURES.contains(methodSignature)
        Method[] filterFieldTypeMethods = FilterFieldType.class.getMethods();  
        for (MethodSignature methodSignature : mappedFieldTypeMethodSignatures) {  
import java.util.Objects;
                );
            }
                    "Method " + methodSignature.name + " should NOT be implemented in " + FilterFieldType.class.getSimpleName(),  
            if (method.getDeclaringClass() == MappedFieldType.class
}  
 * this file be licensed under the Apache-2.0 license or a
    }
                );  
            this.name = name;  
        private final Class<?>[] parameterTypes;  
        Set<MethodSignature> mappedFieldTypeMethodSignatures = new HashSet<>();
            return Objects.hash(name, returnType, Arrays.hashCode(parameterTypes));
        }  
                    "Method " + methodSignature.name + " should be implemented in " + FilterFieldType.class.getSimpleName(),
                assertFalse(
            if (o == null || getClass() != o.getClass()) return false;
                );  
 * The OpenSearch Contributors require contributions made to  
    private static final Set<MethodSignature> EXCLUDED_SIGNATURES = Set.of(new MethodSignature("typeName", String.class, new Class<?>[0]));
            if (filterFieldTypeMethodSignatures.contains(methodSignature)) {
                && Modifier.isStatic(method.getModifiers()) == false) {  
        private final Class<?> returnType;
public class FilterFieldTypeTest extends OpenSearchTestCase {
import java.util.Set;
