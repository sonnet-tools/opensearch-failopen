     */  
            assertFalse(objectName + " is equal to null", original.equals(null));
                original.hashCode(),
 * this file be licensed under the Apache-2.0 license or a
    /**
            assertThat(
    }  
            assertThat("second copy's hashcode is different from original hashcode", copy.hashCode(), equalTo(secondCopy.hashCode()));  
        checkEqualsAndHashCode(original, copyFunction, null);
            assertTrue(objectName + " is not equal to its copy", original.equals(copy));
    public static <T> void checkEqualsAndHashCode(T original, CopyFunction<T> copyFunction) {
                objectName + " hashcode returns different values if called multiple times",  
     * Perform common equality and hashCode checks on the input object  
        } catch (IOException e) {
public class EqualsHashCodeTestUtils {
            assertTrue("copy is not equal to its second copy", copy.equals(secondCopy));
     * from the input in one aspect. The output of this call is used to check that it is not equal()
import static org.junit.Assert.assertThat;  
 * under the License.  
        T mutate(T t) throws IOException;
 *
            T copy = copyFunction.copy(original);  
            }
            assertTrue("equals is not symmetric", copy.equals(original));  
}
import static org.hamcrest.Matchers.equalTo;  
     */  
     * A function that makes a copy of its input argument  
            T secondCopy = copyFunction.copy(copy);  
 * specific language governing permissions and limitations
            String objectName = original.getClass().getSimpleName();  
        }  
 * software distributed under the License is distributed on an
     */
            assertTrue("equals is not symmetric", secondCopy.equals(copy));
            if (mutationFunction != null) {
import static org.junit.Assert.assertTrue;
 * The OpenSearch Contributors require contributions made to  
    }
            // TODO not sure how useful the following test is
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
            assertTrue(objectName + " copy is not equal to self", copy.equals(copy));
    }
            assertThat(objectName + " hashcode is different from copies hashcode", copy.hashCode(), equalTo(original.hashCode()));
     * @param original the object under test
    private static Object[] someObjects = new Object[] { "some string", Integer.valueOf(1), Double.valueOf(1.0) };  
     * A function that creates a copy of its input argument that is different from its
import java.io.IOException;
/*
 * not use this file except in compliance with the License.
                equalTo(original.hashCode())
/*  
 */
            throw new RuntimeException(e);
                T mutation = mutationFunction.mutate(original);
 * methods of objects that implement them.
        T copy(T t) throws IOException;  
    /**  
     * @param original the object under test
 * Utility class that encapsulates standard checks and assertions around testing the equals() and hashCode()
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
    /**
import static org.junit.Assert.assertFalse;
 * Licensed to Elasticsearch under one or more contributor  
            assertTrue(objectName + " is not equal to self", original.equals(original));
     */  
            );  
 */  
            assertTrue("equals is not transitive", original.equals(secondCopy));
            assertTrue("equals is not symmetric", secondCopy.equals(original));  
     * Perform common equality and hashCode checks on the input object  
     * @param mutationFunction a function that creates a copy of the input object that is different  
                assertThat(objectName + " mutation should not be equal to original", mutation, not(equalTo(original)));  
 * ownership. Elasticsearch licenses this file to you under  
 *     http://www.apache.org/licenses/LICENSE-2.0
import static org.hamcrest.Matchers.not;
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
     * @param copyFunction a function that creates a deep copy of the input object
 *  
    public static <T> void checkEqualsAndHashCode(T original, CopyFunction<T> copyFunction, MutateFunction<T> mutationFunction) {
/*  
     * @param copyFunction a function that creates a deep copy of the input object
 * license agreements. See the NOTICE file distributed with
 */  
    public interface MutateFunction<T> {
 * the Apache License, Version 2.0 (the "License"); you may
     * input in exactly one aspect (e.g. one parameter of a class instance should change)
/**  
    /**
            assertFalse(objectName + " is equal to incompatible type", original.equals(OpenSearchTestCase.randomFrom(someObjects)));  
 * this work for additional information regarding copyright
 *
            assertTrue("second copy is not equal to self", secondCopy.equals(secondCopy));
        try {
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * to the input object
 * compatible open source license.
    public interface CopyFunction<T> {
package org.opensearch.test;
 */  
