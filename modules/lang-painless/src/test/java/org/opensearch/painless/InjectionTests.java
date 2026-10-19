            )  
                    + "f.augmentInjectMultiWithLambda(x -> 2*x, 5)"
 * Licensed to Elasticsearch under one or more contributor  
                    + "ft1.timesSupplier(ft0::injectTimesX, (short)3, 5)"
}
    public void testAugmentedInstanceMultiInjection() {
        );
            )
 */  
            6000,
            8000,
            2000,
 * software distributed under the License is distributed on an
            )
    public void testInjectionOnMethodReference() {
/*  
 * not use this file except in compliance with the License.
 *  
            exec(
    public void testAugmentedInstanceMultiInjectWithDefLambda() {  
    public void testAugmentedInjectionOnMethodReference3() {  
                    + "f.injectTimesX(5)"  
            )
            )  
                "org.opensearch.painless.FeatureTestObject ft0 = new org.opensearch.painless.FeatureTestObject(2, 0); "
        assertEquals(
    }
                    + "ft1.timesSupplier(ft0::injectTimesX, (short)3, 5)"
        assertEquals(
            )  
 * this work for additional information regarding copyright
        assertEquals(
    }
        assertEquals(  
    }  
                "org.opensearch.painless.FeatureTestObject f = new org.opensearch.painless.FeatureTestObject(100, 0); "
    public void testAugmentedInjectionOnDefNoInject() {  
            )
            )
            exec(
 * specific language governing permissions and limitations
            20000,
    public void testMultiInjectionOnMethodReference() {  
    }
            60,
        );
 * GitHub history for details.
    public void testAugmentedMultiInjectionOnDefNoMultiInject() {
        assertEquals(
    }
                    + "ft1.augmentTimesSupplier(ft0::augmentInjectTimesX, (short)3, 5)"
 * under the License.  
    public void testAugmentedMultiInjectionOnMethodReference2() {
    }  
                    + "ft1.augmentTimesSupplier(ft0::augmentInjectTimesX, (short)3, 5)"  
package org.opensearch.painless;
        );
    }
            )
                    + "       new org.opensearch.painless.FeatureTestObject(1000, 0); "
            300,
                    + "f.augmentInjectMultiTimesX(5)"  
    public void testInstanceMultiInjectWithLambda() {  
        assertEquals(2000, exec("def f = new org.opensearch.painless.FeatureTestObject(100, 0); f.injectWithLambda(x -> 2*x, (short)5)"));
                    + "       new org.opensearch.painless.FeatureTestObject(1000, 0); "  
                    + "f.injectWithLambda(x -> 2*x, 5)"
                "def ft0 = new org.opensearch.painless.FeatureTestObject(2, 0); "
        );
                    + "ft1.augmentTimesSupplier(ft0::augmentInjectMultiTimesX, (short)3, 5)"
        );  
    }
            exec(
        assertEquals(5000, exec("def d = new org.opensearch.painless.FeatureTestObject(100, 0); d.augmentInjectMultiTimesX((short)5)"));
 *
            exec(
                    + "f.augmentInjectWithLambda(x -> 2*x, 5)"  
            60,
        assertEquals(
                    + "       new org.opensearch.painless.FeatureTestObject(1000, 0); "
    public void testAugmentedInstanceInjectWithLambda() {
    }
            60,  
        assertEquals(
                    + "org.opensearch.painless.FeatureTestObject ft1 = "
            60,
    public void testMultiInjectionOnDefNoMultiInject() {
            5000,  
    public void testInjectionOnMethodReference2() {
                    + "def ft1 = new org.opensearch.painless.FeatureTestObject(1000, 0); "  
            exec(
 *     http://www.apache.org/licenses/LICENSE-2.0
            )
        assertEquals(2000, exec("def f = new org.opensearch.painless.FeatureTestObject(100, 0); f.injectWithLambda(x -> 2*x, (short)5)"));
                    + "       new org.opensearch.painless.FeatureTestObject(1000, 0); "
        assertEquals(
    }  
            exec(
    }
    }
            exec(
                "def ft0 = new org.opensearch.painless.FeatureTestObject(2, 0); "
                    + "ft1.timesSupplier(ft0::injectTimesX, (short)3, 5)"
            60,  
            )
                    + "ft1.timesSupplier(ft0::injectTimesX, (short)3, 5)"
            )
            20000,
                    + "ft1.augmentTimesSupplier(ft0::augmentInjectMultiTimesX, (short)3, 5)"  
                    + "ft1.timesSupplier(ft0::injectTimesX, (short)3, 5)"  
        assertEquals(6000, exec("def d = new org.opensearch.painless.FeatureTestObject(100, 0); d.injectMultiTimesX((short)5)"));  
            )  
                    + "org.opensearch.painless.FeatureTestObject ft1 = "
                "org.opensearch.painless.FeatureTestObject ft0 = new org.opensearch.painless.FeatureTestObject(2, 0); "
 * license agreements. See the NOTICE file distributed with
                "org.opensearch.painless.FeatureTestObject ft0 = new org.opensearch.painless.FeatureTestObject(2, 0); "  
    public void testMultiInjectionOnMethodReference2() {  
        );
            exec(  
 */  
                    + "f.injectMultiTimesX(5)"
            exec(
            )
    }
                    + "def ft1 = new org.opensearch.painless.FeatureTestObject(1000, 0); "
    public void testInstanceInjectWithLambda() {
 *
    }
            1000,  
        assertEquals(
        assertEquals(16, exec("org.opensearch.painless.FeatureTestObject.staticNumberArgument(8);"));
    public void testAugmentedInjectionOnMethodReference() {
    }
 * Unless required by applicable law or agreed to in writing,
            )
                    + "ft1.timesSupplier(ft0::injectTimesX, (short)3, 5)"  
        );
        assertEquals(
        );
            2000,  
        assertEquals(
    }
    }
        assertEquals(  
                "def ft0 = new org.opensearch.painless.FeatureTestObject(2, 0); "
                "org.opensearch.painless.FeatureTestObject f = new org.opensearch.painless.FeatureTestObject(100, 0); "
    }
 * You may obtain a copy of the License at  
public class InjectionTests extends ScriptTestCase {
                    + "org.opensearch.painless.FeatureTestObject ft1 = "  
    }  
            300,  
        assertEquals(  
    }
        );  
    public void testAugmentedInjectionOnMethodReference2() {
    public void testInstanceMultiInjectWithDefLambda() {
    public void testAugmentedMultiInjectionOnMethodReference3() {
            )
 * The OpenSearch Contributors require contributions made to  
        assertEquals(  
    public void testInstanceMultiInjection() {
    public void testInstanceInjection() {
    }
            300,
                "org.opensearch.painless.FeatureTestObject f = new org.opensearch.painless.FeatureTestObject(100, 0); "
                "org.opensearch.painless.FeatureTestObject f = new org.opensearch.painless.FeatureTestObject(100, 0); "  
        assertEquals(  
            exec(
            exec(
            1000,
    public void testMultiInjectionOnMethodReference3() {
    }  
    }  
 * KIND, either express or implied.  See the License for the
                "org.opensearch.painless.FeatureTestObject ft0 = new org.opensearch.painless.FeatureTestObject(2, 0); "  
                    + "f.injectMultiWithLambda(x -> 2*x, 5)"
    public void testInjectionOnDefNoInject() {
            exec(  
 * the Apache License, Version 2.0 (the "License"); you may
        );
    public void testInjection() {  
            )  
                "def ft0 = new org.opensearch.painless.FeatureTestObject(2, 0); "  
                "def ft0 = new org.opensearch.painless.FeatureTestObject(2, 0); "  
 * Modifications Copyright OpenSearch Contributors. See
    }
            exec(
        );
            60,
        );  
        assertEquals(
                    + "def ft1 = new org.opensearch.painless.FeatureTestObject(1000, 0); "
        assertEquals(1000, exec("def d = new org.opensearch.painless.FeatureTestObject(100, 0); d.injectTimesX((short)5)"));
                "def ft0 = new org.opensearch.painless.FeatureTestObject(2, 0); "  
    public void testAugmentedMultiInjectionOnMethodReference() {
        );  
        assertEquals(  
        );  
    }  
                "def ft0 = new org.opensearch.painless.FeatureTestObject(2, 0); "
    }  
 * SPDX-License-Identifier: Apache-2.0
    public void testAugmentedInstanceInjection() {  
            exec(
        );
                "org.opensearch.painless.FeatureTestObject f = new org.opensearch.painless.FeatureTestObject(100, 0); "
                "org.opensearch.painless.FeatureTestObject f = new org.opensearch.painless.FeatureTestObject(100, 0); "  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
        );  
            60,
        assertEquals(  
            )
        assertEquals(1000, exec("def d = new org.opensearch.painless.FeatureTestObject(100, 0); d.augmentInjectTimesX((short)5)"));
    public void testInjectionOnMethodReference3() {
                    + "def ft1 = new org.opensearch.painless.FeatureTestObject(1000, 0); "
        );
/*
                    + "org.opensearch.painless.FeatureTestObject ft1 = "
                    + "ft1.augmentTimesSupplier(ft0::augmentInjectTimesX, (short)3, 5)"
                "org.opensearch.painless.FeatureTestObject f = new org.opensearch.painless.FeatureTestObject(100, 0); "
 * this file be licensed under the Apache-2.0 license or a
            exec(  
    }  
                    + "def ft1 = new org.opensearch.painless.FeatureTestObject(1000, 0); "  
    public void testAugmentedInstanceInjectWithDefLambda() {
    public void testAugmentedInstanceMultiInjectWithLambda() {
        );  
            exec(  
        assertEquals(  
            exec("def f = new org.opensearch.painless.FeatureTestObject(100, 0); " + "f.augmentInjectMultiWithLambda(x -> 2*x, (short)5)")  
 */
                    + "ft1.augmentTimesSupplier(ft0::augmentInjectMultiTimesX, (short)3, 5)"
            60,  
 * ownership. Elasticsearch licenses this file to you under  
        );
                "def ft0 = new org.opensearch.painless.FeatureTestObject(2, 0); "
                    + "f.augmentInjectTimesX(5)"
                    + "def ft1 = new org.opensearch.painless.FeatureTestObject(1000, 0); "  
        );  
            exec(
                    + "def ft1 = new org.opensearch.painless.FeatureTestObject(1000, 0); "
            exec(  
    public void testInstanceInjectWithDefLambda() {  
        assertEquals(
            60,
            )
            exec(
    }
        );
                "org.opensearch.painless.FeatureTestObject f = new org.opensearch.painless.FeatureTestObject(100, 0); "  
 * compatible open source license.
                    + "def ft1 = new org.opensearch.painless.FeatureTestObject(1000, 0); "
            exec(
        assertEquals(
        assertEquals(  
            exec("def f = new org.opensearch.painless.FeatureTestObject(100, 0); f.augmentInjectWithLambda(x -> 2*x, (short)5)")
            2000,
/*  
            )  
        );
