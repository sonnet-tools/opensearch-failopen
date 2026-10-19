        this.publicMember = publicMember;
     * @return an integer parsed from the input.
 * the Apache License, Version 2.0 (the "License"); you may
     * An example method to attach annotations in allowlist.
     * @param privateMember The value for the private member.
     *
 * specific language governing permissions and limitations
}
 * Unless required by applicable law or agreed to in writing,
        return this.privateMember;
 * Licensed to Elasticsearch under one or more contributor  
    /**
    /**  
    /**  
 * An example of a class to be allowlisted for use by painless scripts
     * An example static method. You may be shocked, but it does nothing.  
 *    http://www.apache.org/licenses/LICENSE-2.0
     * Get the value of the private member.  
package org.opensearch.example.painlessallowlist;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.privateMember = privateMember;
    /**
 * this work for additional information regarding copyright
    /**
    }
/*
    public void annotate() {
    /**
     * An example constant.
    public ExampleAllowlistedClass(int publicMember, int privateMember) {  
    }  
    }  
 * license agreements. See the NOTICE file distributed with
     */
 */  
     * Set the value of the private member.  
 * Modifications Copyright OpenSearch Contributors. See
     */
        // some logic here
    public static final int CONSTANT = 42;  
     * An example public member.  
 */
 * under the License.  
     *
public class ExampleAllowlistedClass {
     * @param privateMember the value to set.
    public int publicMember;
     * @return the value of the private member.
/*  
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
     *
 */  
 * See <a href="file:example_allowlist.txt">example_allowlist.txt</a>.
 */  
    }  
 *  
/*  
     * @param publicMember The value for the public member.  
     * An example static augmentation method that takes the object to operate on as the first argument to a static method.
    }
     */  
 *
 * this file be licensed under the Apache-2.0 license or a
/**
        return Integer.parseInt(x);
    public int getPrivateMemberAccessor() {
    public static void staticMethod() {
    /**
 * compatible open source license.
     */
 * ownership. Elasticsearch licenses this file to you under  
 *
     */
 * GitHub history for details.
     * Construct this example class with the given public and private members.
        // electricity  
     * @param x The String to be operated on.  
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
        this.privateMember = privateMember;
    private int privateMember;
    }  
 * SPDX-License-Identifier: Apache-2.0
 * <p>  
 * KIND, either express or implied.  See the License for the
    public static int toInt(String x) {  
    public void setPrivateMemberAccessor(int privateMember) {
     */
     */  
    /**  
 * Each of the members and methods below are allowlisted for use in search scripts.
     */  
     *
