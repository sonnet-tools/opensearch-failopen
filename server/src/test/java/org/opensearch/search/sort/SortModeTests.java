            assertEquals(mode, SortMode.fromString(mode.toString()));
    public void testParsingFromStringExceptions() {  
        assertEquals("min", SortMode.MIN.toString());  
        assertEquals("avg", SortMode.AVG.toString());  
 */  
        assertEquals("input string is null", e.getMessage());
public class SortModeTests extends OpenSearchTestCase {
        // we rely on these ordinals in serialization, so changing them breaks bwc.
    }  
 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
        assertEquals("median", SortMode.MEDIAN.toString());
        e = expectThrows(IllegalArgumentException.class, () -> SortMode.fromString("xyz"));
 * Unless required by applicable law or agreed to in writing,
 */  
 * GitHub history for details.
        Exception e = expectThrows(NullPointerException.class, () -> SortMode.fromString(null));
        assertEquals("Unknown SortMode [xyz]", e.getMessage());
 * software distributed under the License is distributed on an
    public void testSortMode() {
 * under the License.  
        }  
import org.opensearch.test.OpenSearchTestCase;
}
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(3, SortMode.AVG.ordinal());  
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
/*  
        for (SortMode mode : SortMode.values()) {  
        assertEquals(1, SortMode.MAX.ordinal());
 * You may obtain a copy of the License at  
        assertEquals(0, SortMode.MIN.ordinal());  
import java.util.Locale;  
 *  
        assertEquals("sum", SortMode.SUM.toString());
 * SPDX-License-Identifier: Apache-2.0
    }
 */
        assertEquals("max", SortMode.MAX.toString());
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(2, SortMode.SUM.ordinal());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.search.sort;
 * The OpenSearch Contributors require contributions made to  
 *
 *
/*  
            assertEquals(mode, SortMode.fromString(mode.toString().toUpperCase(Locale.ROOT)));
 * specific language governing permissions and limitations
/*
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
        assertEquals(4, SortMode.MEDIAN.ordinal());
