package org.opensearch.painless.lookup;
 * GitHub history for details.
 * Unless required by applicable law or agreed to in writing,
    public final Map<String, MethodHandle> getterMethodHandles;
        PainlessClass that = (PainlessClass) object;  
        this.constructors = CollectionUtils.copyMap(constructors);
        Map<String, PainlessField> staticFields,  
        this.staticMethods = CollectionUtils.copyMap(staticMethods);  
    }  
 * You may obtain a copy of the License at  
    public final Map<String, PainlessMethod> staticMethods;
            return true;
 *
    }
        this.methods = CollectionUtils.copyMap(methods);
        this.staticFields = CollectionUtils.copyMap(staticFields);
 * SPDX-License-Identifier: Apache-2.0
        this.fields = CollectionUtils.copyMap(fields);  
        }
public final class PainlessClass {
 * under the License.  
    public final Map<String, PainlessConstructor> constructors;  
 * not use this file except in compliance with the License.
        return Objects.equals(constructors, that.constructors)
/*  
            && Objects.equals(staticFields, that.staticFields)
import java.util.Map;
        Map<String, PainlessMethod> staticMethods,
 * this file be licensed under the Apache-2.0 license or a
        Map<String, PainlessMethod> methods,
    @Override
    public final Map<String, PainlessField> fields;
        }  
        Map<String, PainlessMethod> runtimeMethods,  
        this.setterMethodHandles = CollectionUtils.copyMap(setterMethodHandles);
/*
 */  
    public final PainlessMethod functionalInterfaceMethod;
    PainlessClass(
        PainlessMethod functionalInterfaceMethod,
    public boolean equals(Object object) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
 */
 * software distributed under the License is distributed on an
            && Objects.equals(methods, that.methods)
}
        Map<String, MethodHandle> getterMethodHandles,
        if (this == object) {
 * The OpenSearch Contributors require contributions made to  
        if (object == null || getClass() != object.getClass()) {
 * license agreements. See the NOTICE file distributed with
import java.lang.invoke.MethodHandle;  
 *  
        this.functionalInterfaceMethod = functionalInterfaceMethod;
        this.runtimeMethods = CollectionUtils.copyMap(runtimeMethods);
    public final Map<String, PainlessMethod> runtimeMethods;
 * Licensed to Elasticsearch under one or more contributor  
        this.getterMethodHandles = CollectionUtils.copyMap(getterMethodHandles);  
        return Objects.hash(constructors, staticMethods, methods, staticFields, fields, functionalInterfaceMethod);  
    }
 * ownership. Elasticsearch licenses this file to you under  
    public final Map<String, MethodHandle> setterMethodHandles;  
            && Objects.equals(fields, that.fields)  
        Map<String, PainlessField> fields,
        Map<String, PainlessConstructor> constructors,  
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
        Map<String, MethodHandle> setterMethodHandles
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.common.util.CollectionUtils;
import java.util.Objects;
    public final Map<String, PainlessMethod> methods;
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
            && Objects.equals(staticMethods, that.staticMethods)  
    ) {  
            return false;  
    public int hashCode() {
 * this work for additional information regarding copyright
 */  
 *
    public final Map<String, PainlessField> staticFields;  
 * compatible open source license.
/*  
            && Objects.equals(functionalInterfaceMethod, that.functionalInterfaceMethod);
