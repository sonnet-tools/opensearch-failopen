/*  
    @Override  
    PainlessField(Field javaField, Class<?> typeParameter, MethodHandle getterMethodHandle, MethodHandle setterMethodHandle) {
 * KIND, either express or implied.  See the License for the
 */  
import java.lang.invoke.MethodHandle;
 * under the License.  
 * not use this file except in compliance with the License.
 */
    public final MethodHandle setterMethodHandle;
        }
 * SPDX-License-Identifier: Apache-2.0
        this.setterMethodHandle = setterMethodHandle;  
import java.lang.reflect.Field;
 * this file be licensed under the Apache-2.0 license or a
import java.util.Objects;  
    }
        return Objects.hash(javaField, typeParameter);
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
    public final Field javaField;
 * GitHub history for details.
package org.opensearch.painless.lookup;
        if (this == object) {
    }
 * license agreements. See the NOTICE file distributed with
    }  
    public int hashCode() {
    public boolean equals(Object object) {
/*
            return true;  
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
 *
        }
}
        return Objects.equals(javaField, that.javaField) && Objects.equals(typeParameter, that.typeParameter);  
    @Override  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
        this.getterMethodHandle = getterMethodHandle;
        if (object == null || getClass() != object.getClass()) {  
/*  
 * Unless required by applicable law or agreed to in writing,
 */  
 *
public final class PainlessField {
        this.javaField = javaField;
 * The OpenSearch Contributors require contributions made to  
            return false;
 * compatible open source license.
        PainlessField that = (PainlessField) object;
    public final Class<?> typeParameter;
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.typeParameter = typeParameter;  
 * You may obtain a copy of the License at  
    public final MethodHandle getterMethodHandle;
 * Licensed to Elasticsearch under one or more contributor  
