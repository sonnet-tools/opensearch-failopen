 * ownership. Elasticsearch licenses this file to you under  
import java.util.function.Function;
        return ft.getX() + ft.getY();  
        int inject3,  
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
        return ft.getX() * fn.apply(arg) * (inject1 + inject2 + inject3 + inject4);
        Function<Short, Integer> fn,
    }  
        FeatureTestObject ft,  
/*  
 * The OpenSearch Contributors require contributions made to  
    }
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
        int inject1,
    }  
 * You may obtain a copy of the License at  
        return ft.getX() * (inject1 + inject2) * user;
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.painless;
    }  
    }
    public static int augmentInjectTimesX(FeatureTestObject ft, int injected, short user) {
    public static int getTotal(FeatureTestObject ft) {
    private FeatureTestAugmentationObject() {}
    public static int augmentInjectMultiTimesX(FeatureTestObject ft, int inject1, int inject2, short user) {
}  
 * under the License.  
        int inject4,
        return ft.getX() * fn.apply(arg) * injected;
        return ft.getX() * injected * user;
    }
/*
 * this file be licensed under the Apache-2.0 license or a
        return fn.apply(fnArg) * userArg;  
    public static int addToTotal(FeatureTestObject ft, int add) {  
 * license agreements. See the NOTICE file distributed with
 *
 *  
    ) {
        return getTotal(ft) + add;
        short arg  
    }
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
/*  
    public static int augmentTimesSupplier(FeatureTestObject ft, Function<Short, Integer> fn, short fnArg, int userArg) {
 * software distributed under the License is distributed on an
    public static int augmentInjectMultiWithLambda(
 */
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
 *
    public static int augmentInjectWithLambda(FeatureTestObject ft, int injected, Function<Short, Integer> fn, short arg) {  
public class FeatureTestAugmentationObject {  
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
        int inject2,
 */  
