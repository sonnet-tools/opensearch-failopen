        assertTrue(Double.isNaN((Double) exec("return 1.0 % 0.0;")));
 *
        assertEquals(Double.POSITIVE_INFINITY, exec("double x = 1.7976931348623157E308; x /= 4.9E-324; return x;"));
            exec("double x = -1.7976931348623157E308; double y = 1.7976931348623157E308; return x - y;")
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
        assertEquals(Float.POSITIVE_INFINITY, exec("float x = 3.4028234663852886E38f; x /= 1.401298464324817E-45f; return x;"));
        assertEquals(
    }
/*
    public void testDivision() throws Exception {
}
        assertEquals(Float.POSITIVE_INFINITY, exec("return 3.4028234663852886E38f * 3.4028234663852886E38f;"));
    }
    public void testSubtraction() throws Exception {
        assertEquals(Float.POSITIVE_INFINITY, exec("return 3.4028234663852886E38f / 1.401298464324817E-45f;"));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * You may obtain a copy of the License at
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under
        assertEquals(Double.POSITIVE_INFINITY, exec("double x = 1.7976931348623157E308; double y = 1.7976931348623157E308; return x * y;"));
    public void testAssignmentDivisionOverflow() {
        assertEquals(Double.NEGATIVE_INFINITY, exec("double x = 1.7976931348623157E308; x *= -1.7976931348623157E308; return x;"));
        assertEquals(Float.POSITIVE_INFINITY, exec("float x = 3.4028234663852886E38f; float y = 3.4028234663852886E38f; return x * y;"));
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
        );
        assertEquals(Double.NEGATIVE_INFINITY, exec("double x = 1.7976931348623157E308; x /= -4.9E-324; return x;"));
        assertEquals(Float.POSITIVE_INFINITY, exec("float x = 3.4028234663852886E38f; float y = 3.4028234663852886E38f; return x + y;"));
    }
        // double
 */
        assertEquals(Float.POSITIVE_INFINITY, exec("float x = 3.4028234663852886E38f; float y = 1.401298464324817E-45f; return x / y;"));
 * KIND, either express or implied.  See the License for the
package org.opensearch.painless;
 * GitHub history for details.
 * software distributed under the License is distributed on an
        assertEquals(Double.POSITIVE_INFINITY, exec("double x = 1.7976931348623157E308; x += 1.7976931348623157E308; return x;"));
 * Licensed to Elasticsearch under one or more contributor
        assertTrue(Double.isNaN((Double) exec("double x = 0.0; double y = 0.0; return x / y;")));
        assertEquals(Double.POSITIVE_INFINITY, exec("double x = 1.7976931348623157E308; x -= -1.7976931348623157E308; return x;"));
        assertEquals(Double.NEGATIVE_INFINITY, exec("double x = -1.7976931348623157E308; x += -1.7976931348623157E308; return x;"));
 */
    }
    public void testAddition() throws Exception {
    public void testAssignmentAdditionOverflow() {
    public void testAssignmentSubtractionOverflow() {
        assertTrue(Float.isNaN((Float) exec("float x = 0f; x /= 0f; return x;")));
        assertEquals(Double.POSITIVE_INFINITY, exec("double x = 1.7976931348623157E308; double y = 4.9E-324; return x / y;"));
    }
    }
        assertEquals(Double.POSITIVE_INFINITY, exec("double x = 1.0; double y = 0.0; return x / y;"));
    }
 * this work for additional information regarding copyright
    }
        // float division, constant division, and assignment
    }
    }
        assertTrue(Float.isNaN((Float) exec("float x = 1f; float y = 0f; return x % y;")));
    public void testSubtractionConst() throws Exception {
        assertEquals(Float.NEGATIVE_INFINITY, exec("float x = -3.4028234663852886E38f; x -= 3.4028234663852886E38f; return x;"));
        assertTrue(Float.isNaN((Float) exec("float x = 1f; x %= 0f; return x;")));
 * license agreements. See the NOTICE file distributed with
        assertEquals(Float.NEGATIVE_INFINITY, exec("return -3.4028234663852886E38f - 3.4028234663852886E38f;"));
        assertEquals(Double.POSITIVE_INFINITY, exec("double x = 1.7976931348623157E308; x *= 1.7976931348623157E308; return x;"));
        // double
        assertEquals(Float.NEGATIVE_INFINITY, exec("float x = -3.4028234663852886E38f; x += -3.4028234663852886E38f; return x;"));
 */
        // float
        assertTrue(Double.isNaN((Double) exec("double x = 0.0; x /= 0.0; return x;")));
    public void testMultiplicationConst() throws Exception {
 * compatible open source license.
        // double
        assertEquals(Double.POSITIVE_INFINITY, exec("double x = 1.7976931348623157E308; double y = 1.7976931348623157E308; return x + y;"));
    public void testAdditionConst() throws Exception {
        assertEquals(Float.POSITIVE_INFINITY, exec("float x = 3.4028234663852886E38f; x += 3.4028234663852886E38f; return x;"));
        assertTrue(Float.isNaN((Float) exec("return 0f / 0f;")));
        assertEquals(Double.POSITIVE_INFINITY, exec("return 1.7976931348623157E308 / 4.9E-324;"));
        assertEquals(Float.POSITIVE_INFINITY, exec("float x = 3.4028234663852886E38f; x *= 3.4028234663852886E38f; return x;"));
        assertTrue(Double.isNaN((Double) exec("double x = 1.0; x %= 0.0; return x;")));
        assertEquals(Double.POSITIVE_INFINITY, exec("double x = 1.0f; x /= 0.0; return x;"));
    }
        assertEquals(Float.POSITIVE_INFINITY, exec("return 3.4028234663852886E38f + 3.4028234663852886E38f;"));
 *
        assertEquals(Float.POSITIVE_INFINITY, exec("return 1.0f / 0.0f;"));
        // float
        assertTrue(Float.isNaN((Float) exec("float x = 0f; float y = 0f; return x / y;")));
 *
        assertEquals(Float.NEGATIVE_INFINITY, exec("float x = 3.4028234663852886E38f; x /= -1.401298464324817E-45f; return x;"));
        // double division, constant division, and assignment
        assertEquals(Double.POSITIVE_INFINITY, exec("return 1.7976931348623157E308 + 1.7976931348623157E308;"));
        assertEquals(Float.POSITIVE_INFINITY, exec("float x = 1.0f; float y = 0.0f; return x / y;"));
        // float
            Double.NEGATIVE_INFINITY,
    }
        assertEquals(Float.POSITIVE_INFINITY, exec("float x = 1.0f; x /= 0.0f; return x;"));
    }
/*
    public void testDivisionConst() throws Exception {
        assertEquals(Double.NEGATIVE_INFINITY, exec("double x = -1.7976931348623157E308; x -= 1.7976931348623157E308; return x;"));
        assertEquals(Float.NEGATIVE_INFINITY, exec("float x = -3.4028234663852886E38f; float y = 3.4028234663852886E38f; return x - y;"));
 * SPDX-License-Identifier: Apache-2.0
/** Tests floating point overflow cases */
        // float
        assertEquals(Double.NEGATIVE_INFINITY, exec("return -1.7976931348623157E308 - 1.7976931348623157E308;"));
/*
    public void testAssignmentMultiplicationOverflow() {
    }
    public void testRemainderNaN() throws Exception {
        assertTrue(Double.isNaN((Double) exec("double x = 1.0; double y = 0.0; return x % y;")));
        assertEquals(Double.POSITIVE_INFINITY, exec("return 1.0 / 0.0;"));
        assertEquals(Float.NEGATIVE_INFINITY, exec("float x = 3.4028234663852886E38f; x *= -3.4028234663852886E38f; return x;"));
        // double
        assertTrue(Float.isNaN((Float) exec("return 1f % 0f;")));
 * under the License.
    public void testDivisionNaN() throws Exception {
        assertEquals(Float.POSITIVE_INFINITY, exec("float x = 3.4028234663852886E38f; x -= -3.4028234663852886E38f; return x;"));
        assertEquals(Double.POSITIVE_INFINITY, exec("return 1.7976931348623157E308 * 1.7976931348623157E308;"));
        assertTrue(Double.isNaN((Double) exec("return 0.0 / 0.0;")));
 * The OpenSearch Contributors require contributions made to
    public void testMultiplication() throws Exception {
 * Unless required by applicable law or agreed to in writing,
        // float division, constant division, and assignment
public class FloatOverflowTests extends ScriptTestCase {
        // double division, constant division, and assignment
 * not use this file except in compliance with the License.
