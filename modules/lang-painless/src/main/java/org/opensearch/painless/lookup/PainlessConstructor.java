import java.util.Map;
 * under the License.  
public class PainlessConstructor {
 *
 */  
    }  
    public boolean equals(Object object) {
 * this file be licensed under the Apache-2.0 license or a
    public final List<Class<?>> typeParameters;
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
        if (object == null || getClass() != object.getClass()) {  
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
            && Objects.equals(typeParameters, that.typeParameters)
/*
    ) {
}
        MethodType methodType,
        return Objects.equals(javaConstructor, that.javaConstructor)  
 * software distributed under the License is distributed on an
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
    PainlessConstructor(
        PainlessConstructor that = (PainlessConstructor) object;
 * license agreements. See the NOTICE file distributed with
    public int hashCode() {
        Constructor<?> javaConstructor,
 * this work for additional information regarding copyright
        Map<Class<?>, Object> annotations  
    public final Constructor<?> javaConstructor;
    @Override  
/*  
        this.annotations = annotations;  
import java.util.Objects;  
            && Objects.equals(methodType, that.methodType)
import java.lang.reflect.Constructor;  
        this.typeParameters = typeParameters;  
import java.util.List;
        }
 * compatible open source license.
/*  
 *
    public final MethodHandle methodHandle;  
 * Modifications Copyright OpenSearch Contributors. See
    }
    public final MethodType methodType;
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
package org.opensearch.painless.lookup;
            return false;
        MethodHandle methodHandle,
 */  
        if (this == object) {
 * SPDX-License-Identifier: Apache-2.0
    @Override  
 * KIND, either express or implied.  See the License for the
        }
            && Objects.equals(annotations, that.annotations);  
    }
        return Objects.hash(javaConstructor, typeParameters, methodType, annotations);
            return true;  
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
        List<Class<?>> typeParameters,  
import java.lang.invoke.MethodType;
        this.methodType = methodType;
import java.lang.invoke.MethodHandle;
 * GitHub history for details.
    public final Map<Class<?>, Object> annotations;
        this.javaConstructor = javaConstructor;
 * You may obtain a copy of the License at  
        this.methodHandle = methodHandle;
