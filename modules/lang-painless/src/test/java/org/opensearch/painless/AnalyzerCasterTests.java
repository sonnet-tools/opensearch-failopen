        assertCast(short.class, int.class, false);
    public void testNumericCasts() {  
            );  
 * under the License.  
 */
 * ownership. Elasticsearch licenses this file to you under  
/*  
 * software distributed under the License is distributed on an
        assertCast(float.class, byte.class, true);
        assertCast(double.class, short.class, true);
        assertCast(double.class, double.class, false);
            return;
        assertCast(long.class, short.class, true);
        assertCast(byte.class, double.class, false);  
        assertCast(byte.class, float.class, false);
        assertCast(short.class, short.class, false);  
        assertCast(float.class, int.class, true);
public class AnalyzerCasterTests extends OpenSearchTestCase {
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
/*
                ClassCastException.class,
            assertFalse(mustBeExplicit);
 */  
                () -> AnalyzerCaster.getLegalCast(location, actual, expected, false, false)
        assertCast(float.class, double.class, false);
        assertCast(float.class, long.class, true);
 * SPDX-License-Identifier: Apache-2.0
        assertCast(double.class, float.class, true);
        assertCast(byte.class, short.class, false);
 *
import org.opensearch.test.OpenSearchTestCase;
 * You may obtain a copy of the License at  
        } else {
 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
        assertCast(float.class, short.class, true);  
        assertCast(short.class, byte.class, true);
 */  
        PainlessCast cast = AnalyzerCaster.getLegalCast(location, actual, expected, true, false);
 *
package org.opensearch.painless;
        assertCast(int.class, short.class, true);
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
        assertCast(int.class, byte.class, true);  
        assertCast(long.class, byte.class, true);
        assertCast(byte.class, long.class, false);
        assertCast(short.class, double.class, false);
        }
        assertCast(float.class, float.class, false);  
            assertEquals(actual, cast.originalType);
        assertCast(int.class, long.class, false);  
    private static void assertCast(Class<?> actual, Class<?> expected, boolean mustBeExplicit) {  
 * Modifications Copyright OpenSearch Contributors. See
        assertCast(int.class, int.class, false);
        assertEquals(expected, cast.targetType);  
        assertCast(short.class, long.class, false);
        if (mustBeExplicit) {
        assertCast(long.class, int.class, true);  
        Location location = new Location("dummy", 0);
        if (actual.equals(expected)) {  
/*  
 * license agreements. See the NOTICE file distributed with
    }  
            ClassCastException error = expectThrows(  
        assertCast(double.class, int.class, true);
        assertCast(int.class, double.class, false);
            assertNull(AnalyzerCaster.getLegalCast(location, actual, expected, false, false));
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
        assertCast(byte.class, byte.class, false);
 * not use this file except in compliance with the License.
    }
        assertCast(double.class, byte.class, true);  
 * The OpenSearch Contributors require contributions made to  
}
        assertCast(long.class, float.class, false);
        assertEquals(actual, cast.originalType);
            assertTrue(error.getMessage().startsWith("Cannot cast"));
        assertCast(double.class, long.class, true);  
        assertCast(int.class, float.class, false);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertCast(byte.class, int.class, false);  
import org.opensearch.painless.lookup.PainlessCast;
        assertCast(short.class, float.class, false);  
            cast = AnalyzerCaster.getLegalCast(location, actual, expected, false, false);  
            assertNull(AnalyzerCaster.getLegalCast(location, actual, expected, true, false));  
 * Unless required by applicable law or agreed to in writing,
        assertCast(long.class, long.class, false);
 * GitHub history for details.
        assertCast(long.class, double.class, false);  
        }  
            assertEquals(expected, cast.targetType);
