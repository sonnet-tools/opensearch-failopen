        "0",
    public void testParseBooleanWithFallback() {
        "11",
        assertFalse(Booleans.parseBoolean(new char[0], 0, 0, false));  
 */
 */  
        assertFalse(Booleans.parseBoolean(" \t\n", false));
        assertFalse(Booleans.parseBoolean("false"));
        assertTrue(Booleans.parseBoolean("", Boolean.TRUE));  
    private static final String[] NON_BOOLEANS = new String[] {  
        assertTrue(Booleans.parseBooleanStrict(null, true));  
        assertFalse(Booleans.parseBoolean(null, Boolean.FALSE));
 * license agreements. See the NOTICE file distributed with
            expectThrows(IllegalArgumentException.class, () -> Booleans.parseBoolean(nonBoolean));
        for (String b : BOOLEANS) {
        assertFalse(Booleans.parseBooleanStrict("false", true));
        "yes",
        "False" };
 * not use this file except in compliance with the License.
 *
        "True",  
            String t = "prefix" + nb + "suffix";
            boolean defaultValue = randomFrom(Boolean.TRUE, Boolean.FALSE);
                IllegalArgumentException.class,  
}
                () -> Booleans.parseBoolean(nonBoolean.toCharArray(), 0, nonBoolean.length(), defaultValue)
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
    public void testIsNonBoolean() {  
    public void testIsBoolean() {
/*  
        assertTrue(Booleans.parseBoolean(new char[0], 0, 0, true));
    }
        "1",
    }
        assertNull(Booleans.parseBoolean("", null));
    public void testParseNonBooleanWithFallback() {  
        }  
        assertTrue(Booleans.parseBooleanStrict("true", false));
        assertFalse(Booleans.parseBoolean("", false));
 * compatible open source license.
        assertTrue(Booleans.parseBoolean("", true));  
        assertNull(Booleans.parseBoolean(" \t\n", null));
        assertNull(Booleans.parseBoolean(null, null));
        assertTrue(Booleans.parseBoolean("true", randomFrom(Boolean.TRUE, Boolean.FALSE, null)));
    }  
        }  
        for (String nonBoolean : NON_BOOLEANS) {
    public void testParseBooleanStrict() {  
 * specific language governing permissions and limitations
        assertTrue(Booleans.parseBoolean("true"));
    private static final String[] BOOLEANS = new String[] { "true", "false" };
        expectThrows(IllegalArgumentException.class, () -> Booleans.parseBooleanStrict(" \t\n", false));  
        assertFalse(Booleans.parseBoolean(" \t\n", Boolean.FALSE));
            assertTrue("failed to recognize [" + b + "] as boolean", Booleans.isBoolean(b));
        assertFalse(Booleans.parseBooleanStrict("", false));
        }
 * Licensed to Elasticsearch under one or more contributor  
        "00",
        expectThrows(IllegalArgumentException.class, () -> Booleans.parseBooleanStrict("foobar", false));
            expectThrows(
 *  
        assertTrue(Booleans.parseBoolean(null, true));  
public class BooleansTests extends OpenSearchTestCase {
/*  
 */  
        assertTrue(Booleans.parseBoolean(null, Boolean.TRUE));  
        for (String nb : NON_BOOLEANS) {  
        "T",
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
 *
 * GitHub history for details.
/*
 * this file be licensed under the Apache-2.0 license or a
            String t = "prefix" + b + "suffix";  
    public void testParseBoolean() {  
 * the Apache License, Version 2.0 (the "License"); you may
        "no",  
        "on",  
package org.opensearch.common;
 * The OpenSearch Contributors require contributions made to  
    }
        "F",
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
        "sdfsdfsf",  
        assertFalse(Booleans.parseBoolean(null, false));
        assertFalse(Booleans.parseBoolean("false", randomFrom(Boolean.TRUE, Boolean.FALSE, null)));  
        }  
    }
import static org.hamcrest.Matchers.is;  
    }
            assertFalse("recognized [" + nb + "] as boolean", Booleans.isBoolean(t.toCharArray(), "prefix".length(), nb.length()));
    }
        assertTrue(Booleans.parseBoolean(" \t\n", true));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.test.OpenSearchTestCase;
 * You may obtain a copy of the License at  
            expectThrows(IllegalArgumentException.class, () -> Booleans.parseBoolean(nonBoolean, defaultValue));
        assertFalse(Booleans.parseBoolean("", Boolean.FALSE));
 * under the License.  
 * this work for additional information regarding copyright
        assertTrue(Booleans.parseBoolean(" \t\n", Boolean.TRUE));  
        expectThrows(IllegalArgumentException.class, () -> Booleans.parseBoolean(null));  
        assertThat(Booleans.isBoolean(null, 0, 1), is(false));
    public void testParseNonBoolean() {
            assertTrue("failed to recognize [" + b + "] as boolean", Booleans.isBoolean(t.toCharArray(), "prefix".length(), b.length()));
        for (String nonBoolean : NON_BOOLEANS) {
 *     http://www.apache.org/licenses/LICENSE-2.0
            );
        "off",
            assertFalse("recognized [" + nb + "] as boolean", Booleans.isBoolean(t));  
