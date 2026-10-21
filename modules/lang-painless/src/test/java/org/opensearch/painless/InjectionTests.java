 */
    }
            )
            )
        );
    }
        );
                    + "f.injectTimesX(5)"
                    + "org.opensearch.painless.FeatureTestObject ft1 = "
                    + "       new org.opensearch.painless.FeatureTestObject(1000, 0); "
                    + "ft1.augmentTimesSupplier(ft0::augmentInjectMultiTimesX, (short)3, 5)"
                "org.opensearch.painless.FeatureTestObject ft0 = new org.opensearch.painless.FeatureTestObject(2, 0); "
            300,
            60,
            exec(
    }
                "org.opensearch.painless.FeatureTestObject f = new org.opensearch.painless.FeatureTestObject(100, 0); "
                "org.opensearch.painless.FeatureTestObject f = new org.opensearch.painless.FeatureTestObject(100, 0); "
            300,
                    + "def ft1 = new org.opensearch.painless.FeatureTestObject(1000, 0); "
            6000,
        assertEquals(
 * specific language governing permissions and limitations
    }
                    + "org.opensearch.painless.FeatureTestObject ft1 = "
            exec(
                    + "def ft1 = new org.opensearch.painless.FeatureTestObject(1000, 0); "
        );
                "org.opensearch.painless.FeatureTestObject f = new org.opensearch.painless.FeatureTestObject(100, 0); "
    public void testAugmentedInjectionOnMethodReference3() {
    }
 * not use this file except in compliance with the License.
            exec(
 * KIND, either express or implied.  See the License for the
                "def ft0 = new org.opensearch.painless.FeatureTestObject(2, 0); "
    public void testAugmentedInstanceInjection() {
/*
            2000,
                    + "def ft1 = new org.opensearch.painless.FeatureTestObject(1000, 0); "
/*
            60,
        );
            5000,
    }
    public void testInjectionOnMethodReference() {
            exec(
            )
        assertEquals(
                    + "org.opensearch.painless.FeatureTestObject ft1 = "
            )
                    + "ft1.timesSupplier(ft0::injectTimesX, (short)3, 5)"
            exec(
            exec(
            60,
        );
 *
    public void testMultiInjectionOnDefNoMultiInject() {
                "org.opensearch.painless.FeatureTestObject f = new org.opensearch.painless.FeatureTestObject(100, 0); "
    public void testMultiInjectionOnMethodReference2() {
            exec(
        assertEquals(
            exec(
    public void testInstanceMultiInjection() {
    }
        assertEquals(
 *
                    + "def ft1 = new org.opensearch.painless.FeatureTestObject(1000, 0); "
package org.opensearch.painless;
    public void testAugmentedInjectionOnDefNoInject() {
        );
                    + "f.injectMultiWithLambda(x -> 2*x, 5)"
                    + "def ft1 = new org.opensearch.painless.FeatureTestObject(1000, 0); "
    }
 * this file be licensed under the Apache-2.0 license or a
            )
public class InjectionTests extends ScriptTestCase {
                    + "ft1.timesSupplier(ft0::injectTimesX, (short)3, 5)"
    }
                "def ft0 = new org.opensearch.painless.FeatureTestObject(2, 0); "
            exec(
}
    }
 * ownership. Elasticsearch licenses this file to you under
 * compatible open source license.
 * GitHub history for details.
            exec(
            60,
                    + "f.augmentInjectMultiTimesX(5)"
    public void testAugmentedMultiInjectionOnDefNoMultiInject() {
                    + "ft1.augmentTimesSupplier(ft0::augmentInjectTimesX, (short)3, 5)"
            exec("def f = new org.opensearch.painless.FeatureTestObject(100, 0); " + "f.augmentInjectMultiWithLambda(x -> 2*x, (short)5)")
            )
        );
        assertEquals(
            exec(
    }
                "def ft0 = new org.opensearch.painless.FeatureTestObject(2, 0); "
                    + "       new org.opensearch.painless.FeatureTestObject(1000, 0); "
                    + "       new org.opensearch.painless.FeatureTestObject(1000, 0); "
        assertEquals(1000, exec("def d = new org.opensearch.painless.FeatureTestObject(100, 0); d.injectTimesX((short)5)"));
            )
        );
    public void testInjectionOnMethodReference3() {
        assertEquals(2000, exec("def f = new org.opensearch.painless.FeatureTestObject(100, 0); f.injectWithLambda(x -> 2*x, (short)5)"));
    }
            exec(
 *
        assertEquals(
 * license agreements. See the NOTICE file distributed with
            )
            60,
            60,
            exec(
                    + "ft1.augmentTimesSupplier(ft0::augmentInjectMultiTimesX, (short)3, 5)"
    public void testAugmentedInstanceMultiInjectWithDefLambda() {
            exec(
        assertEquals(5000, exec("def d = new org.opensearch.painless.FeatureTestObject(100, 0); d.augmentInjectMultiTimesX((short)5)"));
                    + "def ft1 = new org.opensearch.painless.FeatureTestObject(1000, 0); "
 * Modifications Copyright OpenSearch Contributors. See
            )
                "org.opensearch.painless.FeatureTestObject ft0 = new org.opensearch.painless.FeatureTestObject(2, 0); "
                    + "ft1.timesSupplier(ft0::injectTimesX, (short)3, 5)"
        );
    }
        );
                "org.opensearch.painless.FeatureTestObject ft0 = new org.opensearch.painless.FeatureTestObject(2, 0); "
    }
                    + "ft1.timesSupplier(ft0::injectTimesX, (short)3, 5)"
    }
 * software distributed under the License is distributed on an
                "org.opensearch.painless.FeatureTestObject f = new org.opensearch.painless.FeatureTestObject(100, 0); "
            1000,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                "def ft0 = new org.opensearch.painless.FeatureTestObject(2, 0); "
        assertEquals(
        );
            20000,
    public void testAugmentedInstanceInjectWithLambda() {
    public void testInstanceMultiInjectWithLambda() {
            exec(
    public void testInjection() {
        assertEquals(16, exec("org.opensearch.painless.FeatureTestObject.staticNumberArgument(8);"));
                    + "       new org.opensearch.painless.FeatureTestObject(1000, 0); "
        assertEquals(
                "def ft0 = new org.opensearch.painless.FeatureTestObject(2, 0); "
    }
            )
 * under the License.
                    + "ft1.augmentTimesSupplier(ft0::augmentInjectTimesX, (short)3, 5)"
    }
        assertEquals(
                    + "ft1.augmentTimesSupplier(ft0::augmentInjectTimesX, (short)3, 5)"
            exec("def f = new org.opensearch.painless.FeatureTestObject(100, 0); f.augmentInjectWithLambda(x -> 2*x, (short)5)")
    }
        );
                    + "def ft1 = new org.opensearch.painless.FeatureTestObject(1000, 0); "
 */
                "org.opensearch.painless.FeatureTestObject f = new org.opensearch.painless.FeatureTestObject(100, 0); "
        assertEquals(
        );
                    + "ft1.timesSupplier(ft0::injectTimesX, (short)3, 5)"
            )
            )
                "org.opensearch.painless.FeatureTestObject ft0 = new org.opensearch.painless.FeatureTestObject(2, 0); "
        );
/*
    }
            2000,
            60,
            )
        assertEquals(
        assertEquals(
        assertEquals(
                "org.opensearch.painless.FeatureTestObject f = new org.opensearch.painless.FeatureTestObject(100, 0); "
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
                "org.opensearch.painless.FeatureTestObject f = new org.opensearch.painless.FeatureTestObject(100, 0); "
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(
            exec(
        assertEquals(6000, exec("def d = new org.opensearch.painless.FeatureTestObject(100, 0); d.injectMultiTimesX((short)5)"));
    public void testInstanceMultiInjectWithDefLambda() {
 * SPDX-License-Identifier: Apache-2.0
    }
    public void testAugmentedMultiInjectionOnMethodReference() {
            60,
    public void testMultiInjectionOnMethodReference3() {
                "def ft0 = new org.opensearch.painless.FeatureTestObject(2, 0); "
                "def ft0 = new org.opensearch.painless.FeatureTestObject(2, 0); "
                    + "org.opensearch.painless.FeatureTestObject ft1 = "
            )
    }
        );
        );
            )
        );
            20000,
    }
            exec(
    public void testInstanceInjectWithLambda() {
    }
    public void testMultiInjectionOnMethodReference() {
    }
            )
        assertEquals(
    }
        assertEquals(
 * this work for additional information regarding copyright
    public void testAugmentedInstanceInjectWithDefLambda() {
        assertEquals(
            2000,
            )
            )
 * Unless required by applicable law or agreed to in writing,
    public void testAugmentedMultiInjectionOnMethodReference3() {
                    + "def ft1 = new org.opensearch.painless.FeatureTestObject(1000, 0); "
                    + "ft1.augmentTimesSupplier(ft0::augmentInjectMultiTimesX, (short)3, 5)"
        );
            exec(
        assertEquals(
    public void testInstanceInjectWithDefLambda() {
        assertEquals(
            )
                    + "f.augmentInjectTimesX(5)"
 */
                    + "ft1.timesSupplier(ft0::injectTimesX, (short)3, 5)"
            1000,
    public void testAugmentedInstanceMultiInjectWithLambda() {
    }
                "def ft0 = new org.opensearch.painless.FeatureTestObject(2, 0); "
        );
 * Licensed to Elasticsearch under one or more contributor
        assertEquals(
 * The OpenSearch Contributors require contributions made to
 * You may obtain a copy of the License at
        assertEquals(1000, exec("def d = new org.opensearch.painless.FeatureTestObject(100, 0); d.augmentInjectTimesX((short)5)"));
    public void testAugmentedInjectionOnMethodReference2() {
                    + "f.injectMultiTimesX(5)"
    public void testInjectionOnMethodReference2() {
        );
                    + "f.injectWithLambda(x -> 2*x, 5)"
    }
        assertEquals(2000, exec("def f = new org.opensearch.painless.FeatureTestObject(100, 0); f.injectWithLambda(x -> 2*x, (short)5)"));
            exec(
            60,
    public void testAugmentedInstanceMultiInjection() {
                    + "f.augmentInjectMultiWithLambda(x -> 2*x, 5)"
        assertEquals(
        );
    public void testInjectionOnDefNoInject() {
    public void testInstanceInjection() {
    }
            )
        );
    public void testAugmentedInjectionOnMethodReference() {
                    + "f.augmentInjectWithLambda(x -> 2*x, 5)"
            exec(
    public void testAugmentedMultiInjectionOnMethodReference2() {
        assertEquals(
            8000,
            300,
