}
 * this file be licensed under the Apache-2.0 license or a
        return Objects.equals(javaConstructor, that.javaConstructor)
/*
        if (this == object) {  
        }  
    }
            return false;
    ) {
        this.returnType = returnType;
 * Unless required by applicable law or agreed to in writing,
/*  
    @Override
 * The OpenSearch Contributors require contributions made to  
    public final Class<?> returnType;  
 * not use this file except in compliance with the License.
    @Override
 * compatible open source license.
    }
        this.javaConstructor = javaConstructor;
import java.util.Map;
        }
import java.lang.reflect.Constructor;
 * license agreements. See the NOTICE file distributed with
        this.javaMethod = javaMethod;  
 * ownership. Elasticsearch licenses this file to you under  
            && Objects.equals(typeParameters, that.typeParameters);
    public boolean equals(Object object) {
 * SPDX-License-Identifier: Apache-2.0
        Constructor<?> javaConstructor,
package org.opensearch.painless.lookup;
 */
        this.annotations = annotations;
        return Objects.hash(javaConstructor, javaMethod, returnType, typeParameters);  
 * KIND, either express or implied.  See the License for the
        PainlessClassBinding that = (PainlessClassBinding) object;
    public final Map<Class<?>, Object> annotations;
 *
 * GitHub history for details.
    PainlessClassBinding(
 * the Apache License, Version 2.0 (the "License"); you may
        Map<Class<?>, Object> annotations  
 * software distributed under the License is distributed on an
 *
            && Objects.equals(returnType, that.returnType)  
/*  
            return true;
import java.util.List;  
        if (object == null || getClass() != object.getClass()) {
        Class<?> returnType,
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
 */  
    public final Constructor<?> javaConstructor;  
 *  
public class PainlessClassBinding {
 */  
    public final List<Class<?>> typeParameters;
    public int hashCode() {
 * Licensed to Elasticsearch under one or more contributor  
            && Objects.equals(javaMethod, that.javaMethod)
    public final Method javaMethod;
        Method javaMethod,  
        this.typeParameters = typeParameters;  
 * specific language governing permissions and limitations
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
import java.util.Objects;
        List<Class<?>> typeParameters,
import java.lang.reflect.Method;
