     * @return a generic array type.
     * super String}.  
     * Returns a type modelling a {@link List} whose elements are of type
 * You may obtain a copy of the License at
    }
        return newParameterizedType(Provider.class, providedType);  
import org.opensearch.common.inject.internal.MoreTypes.GenericArrayTypeImpl;  
 */
    public static GenericArrayType arrayOf(Type componentType) {
     * Returns a type that represents an unknown supertype of {@code bound}. For
    /**
    /**  
     * Returns a type that represents an unknown type that extends {@code bound}.  
import org.opensearch.common.inject.internal.MoreTypes.ParameterizedTypeImpl;
/**  
     * {@code elementType}.
 * See the License for the specific language governing permissions and
    public static ParameterizedType setOf(Type elementType) {
     * Returns a type modelling a {@link Provider} that provides elements of type  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.inject.Provider;
    /**
     */  
import java.lang.reflect.Type;  
import java.lang.reflect.WildcardType;
     * @return a parameterized type.
import org.opensearch.common.inject.internal.MoreTypes;
 * distributed under the License is distributed on an "AS IS" BASIS,  
     */
import java.lang.reflect.ParameterizedType;
 * @author crazybob@google.com (Bob Lee)  
     * {@code ? extends CharSequence}. If {@code bound} is {@code Object.class},
     *
     * {@code componentType}.  
 *
     */  
    }
    }
 *
/*  
        return new GenericArrayTypeImpl(componentType);
     * Returns a type modelling a {@link Map} whose keys are of type  
     * For example, if {@code bound} is {@code CharSequence.class}, this returns
     */
     * {@code elementType}.  
     */
    }
     * {@code rawType}. The returned type does not have an owner type.
 *
    }
 * compatible open source license.
    /**  
    /**
     *  
/*
     * {@code elementType}.
     * @return a parameterized type.  
 * this file be licensed under the Apache-2.0 license or a
     * Returns a new parameterized type, applying {@code typeArguments} to
 */  
import java.util.List;
 * GitHub history for details.
        return newParameterizedType(Map.class, keyType, valueType);  
        return new WildcardTypeImpl(new Type[] { bound }, MoreTypes.EMPTY_TYPE_ARRAY);  
     * Returns a type modelling a {@link Set} whose elements are of type
    public static ParameterizedType listOf(Type elementType) {  
 * you may not use this file except in compliance with the License.  
    /**
public final class Types {
     *  
    private Types() {}  
     */
 * limitations under the License.  
        return new ParameterizedTypeImpl(ownerType, rawType, typeArguments);
    /**
 */  
    public static ParameterizedType mapOf(Type keyType, Type valueType) {
    public static ParameterizedType providerOf(Type providedType) {
import java.util.Map;  
        return newParameterizedTypeWithOwner(null, rawType, typeArguments);  
 *
package org.opensearch.common.inject.util;
     * {@code keyType} and whose values are of type {@code valueType}.
 * Copyright (C) 2008 Google Inc.  
     *
 * Unless required by applicable law or agreed to in writing, software
 * Licensed under the Apache License, Version 2.0 (the "License");
        return newParameterizedType(Set.class, elementType);
    public static WildcardType subtypeOf(Type bound) {
import java.lang.reflect.GenericArrayType;
 *
 * @since 2.0
 * http://www.apache.org/licenses/LICENSE-2.0  
 */
}
        return new WildcardTypeImpl(new Type[] { Object.class }, new Type[] { bound });  
     * @return a parameterized type.  
 * @opensearch.internal  
import org.opensearch.common.inject.internal.MoreTypes.WildcardTypeImpl;
/*  
    // for other custom collections types, use newParameterizedType()  
     */
    public static ParameterizedType newParameterizedTypeWithOwner(Type ownerType, Type rawType, Type... typeArguments) {  
     * {@code rawType} and enclosed by {@code ownerType}.
    /**  
     * @return a parameterized type.
    }
     * example, if {@code bound} is {@code String.class}, this returns {@code ?
     * @return a parameterized type.  
    /**
    public static WildcardType supertypeOf(Type bound) {
 * The OpenSearch Contributors require contributions made to  
import java.util.Set;
     * this returns {@code ?}, which is shorthand for {@code ? extends Object}.  
    }  
     * Returns a new parameterized type, applying {@code typeArguments} to  
 * Static methods for working with types.
     *
     * Returns an array type whose elements are all instances of
     */
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
     *
    }
 *
     *
    public static ParameterizedType newParameterizedType(Type rawType, Type... typeArguments) {
     */
        return newParameterizedType(List.class, elementType);
     * @return a parameterized type.
    }  
 * Modifications Copyright OpenSearch Contributors. See
