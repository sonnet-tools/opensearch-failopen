public class Classes {
 */  
 */
 * The OpenSearch Contributors require contributions made to  
 */  
 * Unless required by applicable law or agreed to in writing,
    private Classes() {}
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
    public static boolean isConcrete(Class<?> clazz) {
 * compatible open source license.
        return !Modifier.isStatic(clazz.getModifiers()) && clazz.getEnclosingClass() != null;
 *
 * GitHub history for details.
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
 *  
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
}
 * license agreements. See the NOTICE file distributed with
/*  
        return !clazz.isInterface() && !Modifier.isAbstract(modifiers);
package org.opensearch.common;
 * KIND, either express or implied.  See the License for the
 * under the License.  
/*  
 * SPDX-License-Identifier: Apache-2.0
    }
 * Base class utilities
 * Licensed to Elasticsearch under one or more contributor  
    }  
 * Modifications Copyright OpenSearch Contributors. See
/**  
 */
    public static boolean isInnerClass(Class<?> clazz) {
        int modifiers = clazz.getModifiers();  
import java.lang.reflect.Modifier;
 *
/*
 * @opensearch.internal  
