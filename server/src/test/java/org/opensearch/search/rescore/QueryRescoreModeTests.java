        assertEquals("sum", QueryRescoreMode.Total.toString());  
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(4, QueryRescoreMode.Multiply.ordinal());  
 * use the names in the parser and the ordinals in serialization.
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals("max", QueryRescoreMode.Max.toString());
        assertEquals((primary + secondary) / 2.0f, QueryRescoreMode.Avg.combine(primary, secondary), Float.MIN_VALUE);
 */
        assertEquals(0, QueryRescoreMode.Avg.ordinal());
        assertEquals(2, QueryRescoreMode.Min.ordinal());
        assertEquals("min", QueryRescoreMode.Min.toString());
        assertEquals(Math.max(primary, secondary), QueryRescoreMode.Max.combine(primary, secondary), Float.MIN_VALUE);
 *  
/**
}
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
 * under the License.  
 * Test fixing the ordinals and names in {@link QueryRescoreMode}. These should not be changed since we  
     * Test @link {@link QueryRescoreMode} enum ordinals and names, since serialization relies on it  
        float secondary = randomFloat();
public class QueryRescoreModeTests extends OpenSearchTestCase {  
/*  
import java.io.IOException;  
 * ownership. Elasticsearch licenses this file to you under  
 */
 * The OpenSearch Contributors require contributions made to  
 */  
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
package org.opensearch.search.rescore;
     */
        assertEquals("avg", QueryRescoreMode.Avg.toString());  
        assertEquals(Math.min(primary, secondary), QueryRescoreMode.Min.combine(primary, secondary), Float.MIN_VALUE);  
    /**
 *
        float primary = randomFloat();  
        assertEquals(primary * secondary, QueryRescoreMode.Multiply.combine(primary, secondary), Float.MIN_VALUE);
 */  
    public void testQueryRescoreMode() throws IOException {
 * GitHub history for details.
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
        assertEquals(primary + secondary, QueryRescoreMode.Total.combine(primary, secondary), Float.MIN_VALUE);
        assertEquals("product", QueryRescoreMode.Multiply.toString());
/*  
 * KIND, either express or implied.  See the License for the
        assertEquals(3, QueryRescoreMode.Total.ordinal());
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(1, QueryRescoreMode.Max.ordinal());  
    }  
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
 *
