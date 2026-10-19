    final Map<String, PainlessConstructor> constructors;
    PainlessMethod functionalInterfaceMethod;
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
    public int hashCode() {
        constructors = new HashMap<>();
        );
 *
package org.opensearch.painless.lookup;
        return Objects.equals(constructors, that.constructors)
 * Modifications Copyright OpenSearch Contributors. See
    final Map<String, MethodHandle> setterMethodHandles;
    final Map<String, PainlessMethod> methods;
import java.util.Map;  
 * this work for additional information regarding copyright
    }  
 * KIND, either express or implied.  See the License for the
            setterMethodHandles  
            && Objects.equals(functionalInterfaceMethod, that.functionalInterfaceMethod);  
/*  
    final Map<String, PainlessMethod> staticMethods;  
    final Map<String, MethodHandle> getterMethodHandles;
    final Map<String, PainlessField> fields;  
        return new PainlessClass(  
            fields,
 * GitHub history for details.
            return false;
        }
    }
    PainlessClassBuilder() {
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override  
            && Objects.equals(methods, that.methods)  
/*  
        if (object == null || getClass() != object.getClass()) {
import java.util.HashMap;
 *  
 */
 * You may obtain a copy of the License at  
import java.lang.invoke.MethodHandle;
        PainlessClassBuilder that = (PainlessClassBuilder) object;
        runtimeMethods = new HashMap<>();  
            getterMethodHandles,
    }
        fields = new HashMap<>();  
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
    @Override
 * under the License.  
        return Objects.hash(constructors, staticMethods, methods, staticFields, fields, functionalInterfaceMethod);
        if (this == object) {  
}
            constructors,
        staticMethods = new HashMap<>();  
            staticFields,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            && Objects.equals(staticMethods, that.staticMethods)
            && Objects.equals(fields, that.fields)
/*
 * not use this file except in compliance with the License.
            && Objects.equals(staticFields, that.staticFields)
    PainlessClass build() {
    final Map<String, PainlessMethod> runtimeMethods;  
 * SPDX-License-Identifier: Apache-2.0
        staticFields = new HashMap<>();
        getterMethodHandles = new HashMap<>();
 * specific language governing permissions and limitations
import java.util.Objects;
            runtimeMethods,
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
    final Map<String, PainlessField> staticFields;
 *
        functionalInterfaceMethod = null;
        setterMethodHandles = new HashMap<>();
 */  
 * Unless required by applicable law or agreed to in writing,
    }  
            staticMethods,
final class PainlessClassBuilder {  
        methods = new HashMap<>();
            return true;
            functionalInterfaceMethod,  
    public boolean equals(Object object) {
 */  
        }  
            methods,  
