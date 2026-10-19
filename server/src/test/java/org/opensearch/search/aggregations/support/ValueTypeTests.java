        assertEquals(ValueType.DOUBLE, ValueType.lenientParse("float"));
        assertTrue(ValueType.LONG.isA(ValueType.DOUBLE));
        assertTrue(ValueType.BOOLEAN.isA(ValueType.NUMERIC));
        assertEquals(ValueType.IP, ValueType.lenientParse("ip"));
/*  
        assertTrue(ValueType.NUMERIC.isA(ValueType.DATE));
        assertEquals(ValueType.DOUBLE, ValueType.lenientParse("double"));
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
        assertTrue(ValueType.BOOLEAN.isA(ValueType.BOOLEAN));
    public void testCompatibility() {  
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.search.aggregations.support;
 *
        assertEquals(ValueType.LONG, ValueType.lenientParse("short"));
        assertTrue(ValueType.BOOLEAN.isA(ValueType.NUMBER));  
        assertTrue(ValueType.DOUBLE.isA(ValueType.LONG));  
        assertTrue(ValueType.NUMERIC.isA(ValueType.BOOLEAN));
 * GitHub history for details.
 */
 *  
 * Modifications Copyright OpenSearch Contributors. See
        assertTrue(ValueType.LONG.isA(ValueType.NUMERIC));
        assertEquals(ValueType.LONG, ValueType.lenientParse("long"));  
 * You may obtain a copy of the License at  
        assertTrue(ValueType.NUMERIC.isA(ValueType.DOUBLE));  
        assertTrue(ValueType.DOUBLE.isA(ValueType.DOUBLE));  
        assertTrue(ValueType.DATE.isA(ValueType.BOOLEAN));  
        assertEquals(ValueType.BOOLEAN, ValueType.lenientParse("boolean"));  
        assertTrue(ValueType.DATE.isA(ValueType.NUMBER));
import org.opensearch.test.OpenSearchTestCase;
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
        assertEquals(ValueType.LONG, ValueType.lenientParse("integer"));
/*
/*  
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
        assertTrue(ValueType.LONG.isA(ValueType.BOOLEAN));
 *    http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
    public void testResolve() {
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertTrue(ValueType.LONG.isA(ValueType.DATE));  
        assertTrue(ValueType.STRING.isA(ValueType.IP));
 *
 * under the License.  
        assertTrue(ValueType.IP.isA(ValueType.STRING));  
        assertTrue(ValueType.DOUBLE.isA(ValueType.NUMERIC));
        assertTrue(ValueType.DOUBLE.isA(ValueType.NUMBER));
        assertFalse(ValueType.STRING.isA(ValueType.NUMBER));  
        assertTrue(ValueType.NUMERIC.isA(ValueType.NUMBER));
        assertEquals(ValueType.DATE, ValueType.lenientParse("date"));
        assertTrue(ValueType.DATE.isA(ValueType.NUMERIC));  
        assertTrue(ValueType.NUMERIC.isA(ValueType.LONG));  
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
    }
        assertTrue(ValueType.BOOLEAN.isA(ValueType.DATE));  
        assertTrue(ValueType.DATE.isA(ValueType.LONG));
        assertTrue(ValueType.LONG.isA(ValueType.NUMBER));  
        assertTrue(ValueType.BOOLEAN.isA(ValueType.DOUBLE));
        assertTrue(ValueType.LONG.isA(ValueType.LONG));
        assertTrue(ValueType.DATE.isA(ValueType.DATE));
        assertTrue(ValueType.DATE.isA(ValueType.DOUBLE));
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
        assertTrue(ValueType.DOUBLE.isA(ValueType.DATE));
        assertEquals(ValueType.STRING, ValueType.lenientParse("string"));  
 */  
    }
        assertTrue(ValueType.BOOLEAN.isA(ValueType.LONG));
}  
public class ValueTypeTests extends OpenSearchTestCase {  
 * license agreements. See the NOTICE file distributed with
        assertEquals(ValueType.LONG, ValueType.lenientParse("byte"));  
        assertTrue(ValueType.DOUBLE.isA(ValueType.BOOLEAN));
        assertTrue(ValueType.NUMERIC.isA(ValueType.NUMERIC));
        assertFalse(ValueType.DATE.isA(ValueType.IP));
