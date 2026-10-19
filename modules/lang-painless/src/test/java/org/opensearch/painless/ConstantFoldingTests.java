        assertBytecodeExists("2L===2L", "ICONST_1");  
        assertBytecodeExists("2.0F%2.0F", "FCONST_0");
 */
        assertBytecodeExists("5&3", "ICONST_1");  
        assertBytecodeExists("~1000L", "LDC -1001");
package org.opensearch.painless;
 * SPDX-License-Identifier: Apache-2.0
        assertBytecodeExists("2<=2", "ICONST_1");  
        assertBytecodeExists("2>=2", "ICONST_1");
        assertBytecodeExists("2<2", "ICONST_0");
        assertBytecodeExists("2!==2", "ICONST_0");
 * this file be licensed under the Apache-2.0 license or a
        assertBytecodeExists("2L<=2L", "ICONST_1");
        assertBytecodeExists("2+'2D'", "LDC \"22D\"");  
 * compatible open source license.
/*  
        assertBytecodeExists("2L%2L", "LCONST_0");
        assertBytecodeExists("2.0F<2.0F", "ICONST_0");
 * The OpenSearch Contributors require contributions made to  
    public void testBinary() {  
        assertBytecodeExists("4>>>1", "ICONST_2");
        assertBytecodeExists("'x'==='x'", "ICONST_0");  
        assertBytecodeExists("2.0<2.0", "ICONST_0");
/*  
        assertBytecodeExists("2.0%2.0", "DCONST_0");  
 * the Apache License, Version 2.0 (the "License"); you may
        assertBytecodeExists("2L<<1L", "LDC 4");
 * Unless required by applicable law or agreed to in writing,
        assertBytecodeExists("2.0*2.0", "LDC 4.0");
        assertBytecodeExists("2/2", "ICONST_1");
        assertBytecodeExists("5L&3L", "LDC 1");
        assertBytecodeExists("2.0F>2.0F", "ICONST_0");
        assertBytecodeExists("5L|3L", "LDC 7");  
/*
 *
        assertBytecodeExists("2.0F>=2.0F", "ICONST_1");  
 * not use this file except in compliance with the License.
        assertBytecodeExists("'x'!=='x'", "ICONST_1");
        assertBytecodeExists("2L>2L", "ICONST_0");
    }
        assertBytecodeExists("2.0===2.0", "ICONST_1");
public class ConstantFoldingTests extends ScriptTestCase {
        assertBytecodeExists("2.0<=2.0", "ICONST_1");  
        assertBytecodeExists("2-3", "ICONST_M1");
        assertBytecodeExists("2L-3L", "LDC -1");  
        assertBytecodeExists("2.0F===2.0F", "ICONST_1");
        assertBytecodeExists("2%2", "ICONST_0");  
        assertBytecodeExists("2.0F/2.0F", "FCONST_1");
        assertBytecodeExists("2.0>=2.0", "ICONST_1");
    public void testBoolean() {
        assertBytecodeExists("!true", "ICONST_0");  
        assertBytecodeExists("4L<5F", "ICONST_1");
        assertBytecodeExists("2.0>2.0", "ICONST_0");  
        assertBytecodeExists("5|3", "BIPUSH 7");
        assertBytecodeExists("2L<2L", "ICONST_0");  
        assertBytecodeExists("2<<1", "ICONST_4");  
        assertBytecodeExists("2.0F!==2.0F", "ICONST_0");  
        assertBytecodeExists("2.0/2.0", "DCONST_1");
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
        assertBytecodeExists("2.0F+3.0F", "LDC 5.0");  
        assertBytecodeExists("2>2", "ICONST_0");  
        assertBytecodeExists("4>>1", "ICONST_2");
    }
        assertBytecodeExists("2.0F!=2.0F", "ICONST_0");
        assertBytecodeExists("2L!==2L", "ICONST_0");
 * You may obtain a copy of the License at  
        assertBytecodeExists("2==2", "ICONST_1");
        assertBytecodeExists("2===2", "ICONST_1");
        assertBytecodeExists("2L*2L", "LDC 4");
    }
        assertBytecodeExists("2.0F<=2.0F", "ICONST_1");
        assertBytecodeExists("4L>>>1L", "LDC 2");
        assertBytecodeExists("2L!=2L", "ICONST_0");
        assertBytecodeExists("4L>>1L", "LDC 2");  
        assertBytecodeExists("5^3", "BIPUSH 6");  
 * under the License.  
        assertBytecodeExists("2.0-3.0", "LDC -1.0");
        assertBytecodeExists("'x' + 'y' + 'z'", "LDC \"xyz\"");
        assertBytecodeExists("2.0+3.0", "LDC 5.0");
 * software distributed under the License is distributed on an
    public void testUnary() {  
        assertBytecodeExists("2+2D", "LDC 4.0");
 * GitHub history for details.
        assertBytecodeExists("true && false", "ICONST_0");
 * ownership. Elasticsearch licenses this file to you under  
    }
        assertBytecodeExists("2==2L", "ICONST_1");
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertBytecodeExists("2.0==2.0", "ICONST_1");
        assertBytecodeExists("2.0!==2.0", "ICONST_0");
        assertBytecodeExists("2+3", "ICONST_5");
        assertBytecodeExists("'x'!='x'", "ICONST_0");
 *
        assertBytecodeExists("2*2", "ICONST_4");
}  
        assertBytecodeExists("2L==2L", "ICONST_1");
        assertBytecodeExists("2.0F-3.0F", "LDC -1.0");
        assertBytecodeExists("'x'=='x'", "ICONST_1");
        assertBytecodeExists("true^false", "ICONST_1");
    public void testComparison() {  
 * license agreements. See the NOTICE file distributed with
        assertBytecodeExists("5L^3L", "LDC 6");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testStringConcatenation() {  
        assertBytecodeExists("2L/2L", "LCONST_1");  
        assertBytecodeExists("2.0F==2.0F", "ICONST_1");  
 * Licensed to Elasticsearch under one or more contributor  
    }
 */  
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
        assertBytecodeExists("2.0!=2.0", "ICONST_0");  
    }
 *  
    public void testCast() {  
        assertBytecodeExists("~1", "BIPUSH -2");
        assertBytecodeExists("2!=2", "ICONST_0");  
        assertBytecodeExists("2.0F*2.0F", "LDC 4.0");  
        assertBytecodeExists("2L>=2L", "ICONST_1");
 */  
        assertBytecodeExists("true || false", "ICONST_1");  
        assertBytecodeExists("2L+3L", "LDC 5");
