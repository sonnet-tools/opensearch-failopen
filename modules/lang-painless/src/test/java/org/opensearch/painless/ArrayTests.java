    }
    public void testArrayLengthHelper() throws Throwable {
import org.hamcrest.Matcher;
    @Override
        assertEquals(1, exec("int x; def[] y = new def[1]; x = y[0] = 1; return x;"));  
 * The OpenSearch Contributors require contributions made to  
        assertArrayLength(8, new short[8]);
        assertEquals(1, exec("def[] x = new def[1]; x[0] = 2; return x[0] / 2"));
 * You may obtain a copy of the License at  
        return "new " + valueType + "[" + size + "]";
     */
 * compatible open source license.
package org.opensearch.painless;
 * ownership. Elasticsearch licenses this file to you under  
    }
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
/*  
        return equalTo("Index " + Integer.toString(index) + " out of bounds for length " + Integer.toString(size));
 * this file be licensed under the Apache-2.0 license or a
 */  
        assertEquals(1, exec("int x; def y = new def[1]; x = y[0] = 1; return x;"));
}  
        assertSame(array.getClass(), mh.type().parameterType(0));
    protected Matcher<String> outOfBoundsExceptionMessageMatcher(int index, int size) {  
    /**  
        assertArrayLength(10, new Integer[10]);
     * Make sure we don't try and convert the {@code /} after the {@code ]} into a regex....
    }  
 * not use this file except in compliance with the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
                    + "int total = 0; for (int x = 0; x < a.length; x++) { total += a[x]; } return total;"
        assertArrayLength(11, new String[11][2]);
    public void testArrayVariable() {
 */  
 */
        );  
        assertEquals(length, (int) mh.asType(MethodType.methodType(int.class, Object.class)).invokeExact(array));
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
    public void testJacksCrazyExpression1() {
 * the Apache License, Version 2.0 (the "License"); you may
    protected String valueCtorCall(String valueType, int size) {
    }
/*
 * Unless required by applicable law or agreed to in writing,
    }  
                "def a = new int[1000]; for (int x = 0; x < a.length; x++) { a[x] = x; } "  
        assertArrayLength(5, new float[5]);
            999 * 1000 / 2,
    public void testForLoop() {
        assertEquals(1, exec("int x = 1; int[] y = new int[x]; return y.length"));
        return valueType + "[]";  
    }
import java.lang.invoke.MethodHandle;  
 * GitHub history for details.
    @Override
        assertArrayLength(9, new Object[9]);  
    }  
            exec(
    protected String declType(String valueType) {
/*  
    }
/** Tests for working with arrays. */
        assertArrayLength(2, new int[2]);
import static org.hamcrest.Matchers.equalTo;  
 *  
 * software distributed under the License is distributed on an
    private void assertArrayLength(int length, Object array) throws Throwable {
 * KIND, either express or implied.  See the License for the
        final MethodHandle mh = Def.arrayLengthGetter(array.getClass());  
    public void testJacksCrazyExpression2() {  
        assertArrayLength(6, new double[6]);  
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 * license agreements. See the NOTICE file distributed with
 *
 * this work for additional information regarding copyright
 *
    public void testDivideArray() {  
        assertEquals(  
import java.lang.invoke.MethodType;
            )
 * specific language governing permissions and limitations
        assertArrayLength(7, new char[7]);
        assertArrayLength(4, new byte[4]);
        assertArrayLength(3, new long[3]);  
    @Override  
public class ArrayTests extends ArrayLikeObjectTestCase {  
