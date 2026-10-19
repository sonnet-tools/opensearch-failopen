    }  
                Collections.singletonMap("param", "true"),
        assertEquals(0, exec("try { return Integer.parseInt('f') } catch (NumberFormatException nfe) {} return 0;"));  
                    + "catch (NumberFormatException nfe) {return 1;} "
        );
import java.util.Collections;
                true
                "try { if (params.param == 'true') throw new RuntimeException('test'); } "
    }
        );
                true
 * this file be licensed under the Apache-2.0 license or a
    public void testCatch() {
    public void testThrow() {
        );
 * Licensed to Elasticsearch under one or more contributor  
        );
 */
 *  
    /** catches the exact exception */  
        RuntimeException exception = expectScriptThrows(RuntimeException.class, () -> { exec("throw new RuntimeException('test')"); });
                    + "catch (Exception e) {return 3;}"  
                    + "catch (NumberFormatException nfe) {}"
 * The OpenSearch Contributors require contributions made to  
        assertEquals(  
 * compatible open source license.
            exec(
/*  
 * not use this file except in compliance with the License.
        assertEquals(
package org.opensearch.painless;
 * ownership. Elasticsearch licenses this file to you under  
            )
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
                "try { return Integer.parseInt('f') } "  
            exec(  
        assertEquals(
            0,
                    + "catch (NumberFormatException nfe) {return 1;} "
                    + "catch (ArithmeticException e) { return 1; } return 2;",  
 * SPDX-License-Identifier: Apache-2.0
                true
    public void testMultiCatch() {
 * KIND, either express or implied.  See the License for the
        });
            exec(
 * software distributed under the License is distributed on an
            )  
        );
            0,  
            )
                    + "catch (NumberFormatException nfe) {}"  
    /** catches superclass of the exception */
 *
/** tests for throw/try/catch in painless */  
        RuntimeException exception = expectScriptThrows(RuntimeException.class, () -> {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                "try { return new int[] {}[0] } "
            exec(
            )
/*  
                    + "catch (ArrayIndexOutOfBoundsException aioobe) {return 2;} "
                Collections.singletonMap("param", "true"),
                    + "catch (ArrayIndexOutOfBoundsException aioobe) {return 2;} "
            )  
 * license agreements. See the NOTICE file distributed with
        assertEquals(
    }
            exec(
            );  
 * Modifications Copyright OpenSearch Contributors. See
            exec(
 * specific language governing permissions and limitations
                    + "catch (Exception e) {}"
            )  
            3,  
 * Unless required by applicable law or agreed to in writing,
        assertEquals("test", exception.getMessage());
                    + "catch (IllegalArgumentException iae) {}"
}  
    }
 */  
            exec(  
 * GitHub history for details.
    public void testNoCatch() {
    }
                "try { if (params.param == 'true') throw new RuntimeException('test'); } " + "catch (Exception e) { return 1; } return 2;",  
                "try { throw new IllegalArgumentException('test') } "
            1,  
 * under the License.  
 * this work for additional information regarding copyright
                    + " return 0;"  
        assertEquals("test", exception.getMessage());  
            )
/*
public class TryCatchTests extends ScriptTestCase {
 * the Apache License, Version 2.0 (the "License"); you may
    /** tries to catch a different type of exception */
        assertEquals(
            2,
            1,
                    + " return 0;"
            exec(
    public void testCatchSuperclass() {
                Collections.singletonMap("param", "true"),
        );  
            1,
                "try { if (params.param == 'true') throw new RuntimeException('test'); } "
                    + "catch (ArrayIndexOutOfBoundsException aioobe) {return 2;} "  
    }  
 *
                "try { throw new IllegalArgumentException('test') } "
            0,  
            exec("try { return Integer.parseInt('f') } " + "catch (NumberFormatException nfe) {}" + "catch (Exception e) {}" + " return 0;")
                    + "catch (RuntimeException e) { return 1; } return 2;",  
        );
        );  
                    + "catch (Exception e) {return 3;}"
                    + "catch (Exception e) {return 3;}"
                    + "catch (NumberFormatException nfe) {return 1;} "  
 * You may obtain a copy of the License at  
                    + "catch (Exception e) {}"  
    public void testNoCatchBlock() {
    /** throws an exception */  
        assertEquals(
        assertEquals(  
        assertEquals(
                "try { throw new IllegalArgumentException('test'); } "
