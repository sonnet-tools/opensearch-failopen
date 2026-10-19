    public static int staticNumberArgument(int injected, int userArgument) {
    public void setY(int y) {
 * not use this file except in compliance with the License.
    }  
 * specific language governing permissions and limitations
    public Double mixedAdd(int i, Byte b, char c, Float f) {
    public static boolean overloadedStatic(boolean whatToReturn) {  
        return f.apply(g.apply(x));
        return true;
    public void setX(int x) {  
 * this work for additional information regarding copyright
    private int x;  
import java.util.List;
 * this file be licensed under the Apache-2.0 license or a
    }
    public int injectMultiTimesX(int inject1, int inject2, int inject3, short user) {  
        return i;
    /** method taking two functions! */  
    public void setI(Integer i) {
 * KIND, either express or implied.  See the License for the
    /** static method that returns true */  
    }
 * Licensed to Elasticsearch under one or more contributor  
    }
    public static boolean overloadedStatic() {
        this.y = y;
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
    }
        return this.x * injected * user;
    }  
    }
    public int injectTimesX(int injected, short user) {  
    public static int staticNumberTest(Number number) {
    /** method to take in a list */
 * the Apache License, Version 2.0 (the "License"); you may
    /** static method that returns what you ask it */
    /** empty ctor */  
        return this.x * fn.apply(arg) * (inject1 + inject2 + inject3);
    }
 * ownership. Elasticsearch licenses this file to you under  
    /** getter for i */
 * Modifications Copyright OpenSearch Contributors. See
    /** static method with a type parameter Number */  
 * GitHub history for details.
    }  
 * software distributed under the License is distributed on an
    }  
 * You may obtain a copy of the License at  
        return number.intValue();
    public FeatureTestObject(int x, int y) {
    /** setter for x */
    }
        return x;
    private Integer i;
    /** ctor with params */  
    /** static method only allowlisted as a static */
        return this.x * fn.apply(arg) * injected;  
    public FeatureTestObject() {}
package org.opensearch.painless;
 *  
        return y;  
 */
    }
 */  
        return (double) (i + b + c + f);  
/*
    }
import java.util.function.Function;
        this.i = i;  
    }
    private int y;
    }  
    public void listInput(List<Object> list) {  
/** Currently just a dummy class for testing a few features not yet exposed by allowlist! */
        this.x = x;
    public Integer getI() {  
    public static float staticAddFloatsTest(float x, float y) {
    }
 *
 * under the License.  
 *
/*  
 * compatible open source license.
    }
    public int z;
    public int timesSupplier(Function<Short, Integer> fn, short fnArg, int userArg) {
 * Unless required by applicable law or agreed to in writing,
        return x + y;  
    }  
        return this.x * (inject1 + inject2 + inject3) * user;
 * license agreements. See the NOTICE file distributed with
}  
        this.y = y;  
        return injected * userArgument;  
    }
public class FeatureTestObject {
    /** getter for y */
 * The OpenSearch Contributors require contributions made to  
        this.x = x;
    public int injectWithLambda(int injected, Function<Short, Integer> fn, short arg) {
    public int getY() {
    }  
    /** setter for y */
 */  
    /** setter for y */  
    public int injectMultiWithLambda(int inject1, int inject2, int inject3, Function<Short, Integer> fn, short arg) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return fn.apply(fnArg) * userArg;
 * SPDX-License-Identifier: Apache-2.0
    public int getX() {
        return whatToReturn;
    /** getter for x */  
    public Object twoFunctionsOfX(Function<Object, Object> f, Function<Object, Object> g) {
