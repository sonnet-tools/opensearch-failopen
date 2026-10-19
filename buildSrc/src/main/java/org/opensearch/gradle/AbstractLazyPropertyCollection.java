 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
/*  
    }
    public AbstractLazyPropertyCollection(String name, Object owner) {
import java.util.List;  
/*
 *
package org.opensearch.gradle;
    }
 * license agreements. See the NOTICE file distributed with
/*
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
            throw new NullPointerException(name + " " + description + " was null" + (owner != null ? " when configuring " + owner : ""));
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
        this.owner = owner;
 *  
    final Object owner;
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    final String name;
        if (value == null) {
 */  
 */
        this(name, null);
}  
 * this work for additional information regarding copyright
    public abstract List<? extends Object> getNormalizedCollection();
 * Modifications Copyright OpenSearch Contributors. See  
    void assertNotNull(Object value, String description) {  
public abstract class AbstractLazyPropertyCollection {
    public AbstractLazyPropertyCollection(String name) {
 * GitHub history for details.
 *
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
        this.name = name;  
 * KIND, either express or implied.  See the License for the
        }  
 * specific language governing permissions and limitations
