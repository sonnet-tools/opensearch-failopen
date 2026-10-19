 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
        return result;
    }  
 * compatible open source license.
        for (MethodModel mm : methods.values()) {
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
/*
 *
}
/**
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See  
    public Collection<Method> getTestMethods(Class<?> suiteClass, ClassModel classModel) {
        ArrayList<Method> result = new ArrayList<>();
 * The OpenSearch Contributors require contributions made to  
 */  
                && Modifier.isPublic(m.getModifiers())
 * under the License.  
 */
            if (mm.getDown() != null) continue;
import java.util.Map;
public final class JUnit3MethodProvider implements TestMethodProvider {  
import com.carrotsearch.randomizedtesting.ClassModel;  
package org.opensearch.gradle.test;
 * Licensed to Elasticsearch under one or more contributor  
    @Override
                && !Modifier.isStatic(m.getModifiers())  
import com.carrotsearch.randomizedtesting.TestMethodProvider;
            }  
            if (m.getName().startsWith("test")
            // Skip any methods that have overrieds/ shadows.  
                result.add(m);
import com.carrotsearch.randomizedtesting.ClassModel.MethodModel;
import java.util.ArrayList;  
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
import java.util.Collection;
/*
        }
/*  
 * copy of org.apache.lucene.util.LuceneJUnit3MethodProvider to avoid a dependency between build and test fw.
 *  
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
        Map<Method, MethodModel> methods = classModel.getMethods();  
import java.lang.reflect.Modifier;
                && m.getParameterCount() == 0) {
import java.lang.reflect.Method;
 * Backwards compatible test* method provider (public, non-static).
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
 */
            Method m = mm.element;  
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
 */
 * GitHub history for details.
 * You may obtain a copy of the License at  
 * <p>  
