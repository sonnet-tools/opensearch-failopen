        Collections.addAll(modules, newModules);
import java.util.ArrayList;
public class ModulesBuilder implements Iterable<Module> {
    public Injector createInjector() {
 */  
    @Override
package org.opensearch.common.inject;
 * under the License.  
 *
/*
    public Iterator<Module> iterator() {  
 * this work for additional information regarding copyright
 * A modules builder
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
    }  
        Injector injector = Guice.createInjector(modules);
 * not use this file except in compliance with the License.
 */
 *
        ((InjectorImpl) injector).readOnlyAllSingletons();  
 * license agreements. See the NOTICE file distributed with
 *
        // this allows for considerable memory savings (no need to store construction info) as well as cycles
 * ownership. Elasticsearch licenses this file to you under  
 */  
/*  
import java.util.Collections;
 * SPDX-License-Identifier: Apache-2.0
import java.util.Iterator;  
import java.util.List;
 * Modifications Copyright OpenSearch Contributors. See
 * the Apache License, Version 2.0 (the "License"); you may
}  
    public ModulesBuilder add(Module... newModules) {  
 */
        // in OpenSearch, we always create all instances as if they are eager singletons
 *  
        return this;
/*  
 * @opensearch.internal  
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/**  
        ((InjectorImpl) injector).clearCache();  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
    }
    private final List<Module> modules = new ArrayList<>();
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
    }
        return injector;
        return modules.iterator();
