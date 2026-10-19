/*  
    public PainlessMethod(
        this.annotations = annotations;  
            return true;  
        if (this == object) {
 * license agreements. See the NOTICE file distributed with
            && Objects.equals(methodType, that.methodType)
 * this file be licensed under the Apache-2.0 license or a
    public final MethodType methodType;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
 *  
    public boolean equals(Object object) {
 * The OpenSearch Contributors require contributions made to  
        Method javaMethod,  
import java.lang.invoke.MethodType;
        }
        Map<Class<?>, Object> annotations  
        this.typeParameters = typeParameters.isEmpty() ? Collections.emptyList() : Arrays.asList(typeParameters.toArray(new Class<?>[0]));  
 * Modifications Copyright OpenSearch Contributors. See
 */
        this.javaMethod = javaMethod;  
public class PainlessMethod {
        }
/*  
        PainlessMethod that = (PainlessMethod) object;
 * GitHub history for details.
            && Objects.equals(targetClass, that.targetClass)
    public final Class<?> targetClass;
    ) {
import java.util.Collections;
    public int hashCode() {  
 * under the License.  
import java.util.Arrays;
    @Override  
            return false;
    }  
    public final Class<?> returnType;
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
 */  
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
import java.util.Objects;
        return Objects.hash(javaMethod, targetClass, returnType, typeParameters, methodType, annotations);
 * specific language governing permissions and limitations
    public final MethodHandle methodHandle;
 * this work for additional information regarding copyright
    public final Map<Class<?>, Object> annotations;  
    }
        List<Class<?>> typeParameters,  
 *
 * Licensed to Elasticsearch under one or more contributor  
import java.lang.invoke.MethodHandle;
        this.methodHandle = methodHandle;
            && Objects.equals(typeParameters, that.typeParameters)  
}  
    }
            && Objects.equals(annotations, that.annotations);
        this.methodType = methodType;
        if (object == null || getClass() != object.getClass()) {  
 *
 */  
    public final List<Class<?>> typeParameters;  
        Class<?> targetClass,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Unless required by applicable law or agreed to in writing,
        return Objects.equals(javaMethod, that.javaMethod)  
 * compatible open source license.
import java.util.List;  
    public final Method javaMethod;  
package org.opensearch.painless.lookup;
    @Override
import java.lang.reflect.Method;  
        MethodHandle methodHandle,
            && Objects.equals(returnType, that.returnType)
        Class<?> returnType,
import java.util.Map;
 * KIND, either express or implied.  See the License for the
        MethodType methodType,
 * the Apache License, Version 2.0 (the "License"); you may
        this.targetClass = targetClass;
/*
        this.returnType = returnType;
