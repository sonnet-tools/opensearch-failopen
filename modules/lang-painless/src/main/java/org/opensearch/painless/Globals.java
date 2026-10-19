 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
import java.util.HashMap;
    /** Returns the set of statement boundaries */
 * You may obtain a copy of the License at  
 * Program-wide globals (initializers, synthetic methods, etc)  
        this.statements = statements;
 *  
 * GitHub history for details.
 */  
 *
/*
    private final BitSet statements;
/*  
 * Unless required by applicable law or agreed to in writing,
 */
/*  
        }  
        return constantInitializers;
 * software distributed under the License is distributed on an
 *
 * Licensed to Elasticsearch under one or more contributor  
    }
    /** Adds a new constant initializer to be written */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return statements;
 * not use this file except in compliance with the License.
public class Globals {
import java.util.BitSet;
 * this work for additional information regarding copyright
 * under the License.  
 *    http://www.apache.org/licenses/LICENSE-2.0
    /** Create a new Globals from the set of statement boundaries */  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.painless;
        if (constantInitializers.put(constant.name, constant) != null) {
 */
    }  
/**
 * SPDX-License-Identifier: Apache-2.0
            throw new IllegalStateException("constant initializer: " + constant.name + " already exists");
    public void addConstantInitializer(Constant constant) {  
    public BitSet getStatements() {  
    }
 * KIND, either express or implied.  See the License for the
    }  
 * ownership. Elasticsearch licenses this file to you under  
    public Map<String, Constant> getConstantInitializers() {
}  
 */  
    private final Map<String, Constant> constantInitializers = new HashMap<>();  
    public Globals(BitSet statements) {
    /** Returns the current initializers */  
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Map;  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
