 * SPDX-License-Identifier: Apache-2.0
            return false;
/*  
        this.returnType = returnType;
        }
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 * GitHub history for details.
import java.util.List;
        if (this == object) {
 * software distributed under the License is distributed on an
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
 */  
 * You may obtain a copy of the License at  
        this.javaMethod = javaMethod;  
        return targetInstance == that.targetInstance  
 *  
    public final Class<?> returnType;
 *
        return Objects.hash(targetInstance, javaMethod, returnType, typeParameters);
 * Licensed to Elasticsearch under one or more contributor  
    public int hashCode() {
import java.util.Objects;  
    @Override  
        }
import java.lang.reflect.Method;
 */
            && Objects.equals(returnType, that.returnType)
    }
 */  
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
    }  
 * under the License.  
    public boolean equals(Object object) {
            && Objects.equals(typeParameters, that.typeParameters);  
package org.opensearch.painless.lookup;
        PainlessInstanceBinding that = (PainlessInstanceBinding) object;
    @Override  
 *
}
    PainlessInstanceBinding(Object targetInstance, Method javaMethod, Class<?> returnType, List<Class<?>> typeParameters) {
            && Objects.equals(javaMethod, that.javaMethod)
    public final List<Class<?>> typeParameters;
        this.targetInstance = targetInstance;
        if (object == null || getClass() != object.getClass()) {  
 * this work for additional information regarding copyright
    public final Method javaMethod;
 * license agreements. See the NOTICE file distributed with
/*
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
        this.typeParameters = typeParameters;  
 * The OpenSearch Contributors require contributions made to  
    public final Object targetInstance;
            return true;  
public class PainlessInstanceBinding {
