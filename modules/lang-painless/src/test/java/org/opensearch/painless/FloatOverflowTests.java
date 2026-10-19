}
 *
        assertEquals(Float.POSITIVE_INFINITY, exec("float x = 3.4028234663852886E38f; float y = 3.4028234663852886E38f; return x + y;"));
        assertEquals(Double.POSITIVE_INFINITY, exec("double x = 1.7976931348623157E308; x *= 1.7976931348623157E308; return x;"));  
        assertEquals(Float.POSITIVE_INFINITY, exec("float x = 3.4028234663852886E38f; float y = 3.4028234663852886E38f; return x * y;"));
        assertEquals(Float.POSITIVE_INFINITY, exec("float x = 3.4028234663852886E38f; x *= 3.4028234663852886E38f; return x;"));
 *  
 */  
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertTrue(Double.isNaN((Double) exec("double x = 0.0; x /= 0.0; return x;")));  
        assertEquals(Float.NEGATIVE_INFINITY, exec("float x = 3.4028234663852886E38f; x /= -1.401298464324817E-45f; return x;"));
        // float division, constant division, and assignment
        assertEquals(Double.NEGATIVE_INFINITY, exec("return -1.7976931348623157E308 - 1.7976931348623157E308;"));  
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
    public void testMultiplicationConst() throws Exception {
 * Licensed to Elasticsearch under one or more contributor  
    }  
    public void testDivisionConst() throws Exception {
 * specific language governing permissions and limitations
    }
        assertEquals(Float.POSITIVE_INFINITY, exec("float x = 1.0f; x /= 0.0f; return x;"));
        // double  
        assertTrue(Float.isNaN((Float) exec("return 1f % 0f;")));  
    }
    }
        assertEquals(Double.POSITIVE_INFINITY, exec("return 1.7976931348623157E308 * 1.7976931348623157E308;"));
        assertEquals(Float.NEGATIVE_INFINITY, exec("float x = 3.4028234663852886E38f; x *= -3.4028234663852886E38f; return x;"));  
        assertEquals(Float.POSITIVE_INFINITY, exec("float x = 3.4028234663852886E38f; x /= 1.401298464324817E-45f; return x;"));  
    public void testDivision() throws Exception {
/*
        // float
    public void testAddition() throws Exception {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertTrue(Float.isNaN((Float) exec("float x = 1f; x %= 0f; return x;")));
        assertTrue(Float.isNaN((Float) exec("float x = 0f; float y = 0f; return x / y;")));
        assertEquals(Double.POSITIVE_INFINITY, exec("double x = 1.7976931348623157E308; double y = 1.7976931348623157E308; return x + y;"));  
    public void testDivisionNaN() throws Exception {  
 * software distributed under the License is distributed on an
            Double.NEGATIVE_INFINITY,
            exec("double x = -1.7976931348623157E308; double y = 1.7976931348623157E308; return x - y;")  
        assertEquals(Double.NEGATIVE_INFINITY, exec("double x = 1.7976931348623157E308; x *= -1.7976931348623157E308; return x;"));
    }
 * GitHub history for details.
        assertTrue(Double.isNaN((Double) exec("return 1.0 % 0.0;")));
    }
package org.opensearch.painless;
        // double
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
        assertEquals(Float.POSITIVE_INFINITY, exec("return 3.4028234663852886E38f + 3.4028234663852886E38f;"));
        assertEquals(Double.POSITIVE_INFINITY, exec("double x = 1.7976931348623157E308; double y = 4.9E-324; return x / y;"));
        assertEquals(Float.NEGATIVE_INFINITY, exec("float x = -3.4028234663852886E38f; x += -3.4028234663852886E38f; return x;"));
        assertEquals(
    public void testAssignmentSubtractionOverflow() {
    }  
        assertEquals(Float.NEGATIVE_INFINITY, exec("return -3.4028234663852886E38f - 3.4028234663852886E38f;"));
        // float  
        assertEquals(Double.POSITIVE_INFINITY, exec("double x = 1.7976931348623157E308; double y = 1.7976931348623157E308; return x * y;"));
        assertEquals(Double.POSITIVE_INFINITY, exec("double x = 1.0f; x /= 0.0; return x;"));
    public void testMultiplication() throws Exception {  
    }  
 */
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
        assertTrue(Float.isNaN((Float) exec("return 0f / 0f;")));  
    public void testSubtraction() throws Exception {
/*  
        // float
    public void testAssignmentAdditionOverflow() {
        assertEquals(Float.NEGATIVE_INFINITY, exec("float x = -3.4028234663852886E38f; float y = 3.4028234663852886E38f; return x - y;"));  
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(Double.POSITIVE_INFINITY, exec("double x = 1.0; double y = 0.0; return x / y;"));
        assertEquals(Float.POSITIVE_INFINITY, exec("return 1.0f / 0.0f;"));
        assertEquals(Double.NEGATIVE_INFINITY, exec("double x = 1.7976931348623157E308; x /= -4.9E-324; return x;"));  
 * under the License.  
    }
        assertEquals(Float.NEGATIVE_INFINITY, exec("float x = -3.4028234663852886E38f; x -= 3.4028234663852886E38f; return x;"));
    public void testAdditionConst() throws Exception {  
        assertEquals(Double.POSITIVE_INFINITY, exec("double x = 1.7976931348623157E308; x -= -1.7976931348623157E308; return x;"));
        assertEquals(Double.POSITIVE_INFINITY, exec("double x = 1.7976931348623157E308; x /= 4.9E-324; return x;"));
        assertTrue(Double.isNaN((Double) exec("double x = 0.0; double y = 0.0; return x / y;")));
    public void testSubtractionConst() throws Exception {
/** Tests floating point overflow cases */
public class FloatOverflowTests extends ScriptTestCase {
    }
        assertEquals(Double.POSITIVE_INFINITY, exec("double x = 1.7976931348623157E308; x += 1.7976931348623157E308; return x;"));
        assertEquals(Double.POSITIVE_INFINITY, exec("return 1.7976931348623157E308 + 1.7976931348623157E308;"));
        assertEquals(Float.POSITIVE_INFINITY, exec("float x = 3.4028234663852886E38f; x += 3.4028234663852886E38f; return x;"));  
    }
        assertEquals(Float.POSITIVE_INFINITY, exec("return 3.4028234663852886E38f * 3.4028234663852886E38f;"));  
        assertEquals(Float.POSITIVE_INFINITY, exec("float x = 3.4028234663852886E38f; x -= -3.4028234663852886E38f; return x;"));
        // float division, constant division, and assignment
        assertEquals(Float.POSITIVE_INFINITY, exec("float x = 3.4028234663852886E38f; float y = 1.401298464324817E-45f; return x / y;"));
 * Modifications Copyright OpenSearch Contributors. See
 *
        assertTrue(Double.isNaN((Double) exec("double x = 1.0; x %= 0.0; return x;")));  
        // double
        assertTrue(Double.isNaN((Double) exec("return 0.0 / 0.0;")));
 * compatible open source license.
        assertEquals(Double.POSITIVE_INFINITY, exec("return 1.7976931348623157E308 / 4.9E-324;"));
        assertTrue(Float.isNaN((Float) exec("float x = 0f; x /= 0f; return x;")));
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
        assertEquals(Float.POSITIVE_INFINITY, exec("float x = 1.0f; float y = 0.0f; return x / y;"));  
        );
    }
    }  
    public void testRemainderNaN() throws Exception {  
        assertEquals(Double.POSITIVE_INFINITY, exec("return 1.0 / 0.0;"));  
        assertEquals(Double.NEGATIVE_INFINITY, exec("double x = -1.7976931348623157E308; x -= 1.7976931348623157E308; return x;"));  
        // double
    }
        // double division, constant division, and assignment  
    public void testAssignmentDivisionOverflow() {
        assertEquals(Double.NEGATIVE_INFINITY, exec("double x = -1.7976931348623157E308; x += -1.7976931348623157E308; return x;"));
        assertEquals(Float.POSITIVE_INFINITY, exec("return 3.4028234663852886E38f / 1.401298464324817E-45f;"));  
        // float
    public void testAssignmentMultiplicationOverflow() {  
        // double division, constant division, and assignment  
        assertTrue(Double.isNaN((Double) exec("double x = 1.0; double y = 0.0; return x % y;")));
 * not use this file except in compliance with the License.
        assertTrue(Float.isNaN((Float) exec("float x = 1f; float y = 0f; return x % y;")));
 */  
