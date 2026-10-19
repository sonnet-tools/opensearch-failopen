 */
 *
 * this file be licensed under the Apache-2.0 license or a
    public Constant(Location location, org.objectweb.asm.Type type, String name, Consumer<MethodWriter> initializer) {  
 * Unless required by applicable law or agreed to in writing,
     *        value of the constant on the stack. Generating the load instruction is managed by the caller.
    public final Consumer<MethodWriter> initializer;
 */  
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
     * @param type the type of the constant
import java.util.function.Consumer;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
/**  
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
     * @param name the name of the constant
        this.name = name;
    /**  
    public final String name;
 * this work for additional information regarding copyright
 */
        this.initializer = initializer;
 * software distributed under the License is distributed on an
public class Constant {  
     * Create a new constant.
     */
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
    public final Location location;
        this.type = type;  
 * compatible open source license.
package org.opensearch.painless;
}  
 * ownership. Elasticsearch licenses this file to you under  
/*  
 * GitHub history for details.
/*  
     *
 * A constant initializer to be added to the class file.
     * @param initializer code to initialize the constant. It will be called when generating the clinit method and is expected to leave the  
     * @param location the location in the script that is creating it  
 * under the License.  
    }
 * the Apache License, Version 2.0 (the "License"); you may
    public final org.objectweb.asm.Type type;  
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
 */  
/*
        this.location = location;
 *
