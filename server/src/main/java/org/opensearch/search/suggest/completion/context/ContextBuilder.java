}  
     * Create a new {@link CategoryContextMapping}  
    /**
 */
 * Builder for {@link ContextMapping}
 * KIND, either express or implied.  See the License for the
     */
 */
    public static CategoryContextMapping.Builder category(String name) {
    }  
 *
 * specific language governing permissions and limitations
    }
     * @param name of the context mapper to build
/*  
    public abstract E build();
        return new CategoryContextMapping.Builder(name);  
 * @opensearch.internal
    protected ContextBuilder(String name) {
 * this work for additional information regarding copyright
/*  
 * GitHub history for details.
     */  
    protected String name;
    }  
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.search.suggest.completion.context;
    /**
        return new GeoContextMapping.Builder(name);
 * under the License.  
 *  
 * SPDX-License-Identifier: Apache-2.0
 */  
     */  
 * Unless required by applicable law or agreed to in writing,
 *  
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
 *
    public static GeoContextMapping.Builder geo(String name) {
 */  
/**
public abstract class ContextBuilder<E extends ContextMapping<?>> {  
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.name = name;
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
     * Create a new {@link GeoContextMapping}
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
    /**
