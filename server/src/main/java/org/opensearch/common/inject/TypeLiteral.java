        // parameter.  
                if (toResolve == original) {  
 * this file be licensed under the Apache-2.0 license or a
     */
    }  
        return this.hashCode;  
            throw new IllegalArgumentException("Not a method or a constructor: " + methodOrConstructor);
    /**  
 * {@link Types} factory class.
 * Licensed under the Apache License, Version 2.0 (the "License");
     * @since 2.0
        this.type = canonicalize(Objects.requireNonNull(type, "type"));
import java.lang.reflect.TypeVariable;  
     * Gets underlying {@code Type} instance.  
     * Returns the generic form of {@code supertype}. For example, if this is {@code
 *   TypeLiteral<Map<Integer, String>> mapType
     * Returns the resolved generic type of {@code field}.  
package org.opensearch.common.inject;
import org.opensearch.common.annotation.PublicApi;
    }
/*  
import java.lang.reflect.Type;
        }
     * Returns the resolved generic parameter types of {@code methodOrConstructor}.
        Type superclass = subclass.getGenericSuperclass();
     *
     * Iterable.class}.  
 * Represents a generic type {@code T}. Java doesn't yet provide a way to  
                        return Types.subtypeOf(upperBound);
        while (true) {
                            changed = true;
     * Unsafe. Constructs a type literal manually.  
     */
            throw new IllegalArgumentException(method + " is not defined by a supertype of " + type);
    }
 * create an empty anonymous inner class:  
     *
import java.lang.reflect.Constructor;
    }  
        this.hashCode = MoreTypes.hashCode(this.type);  
 * You may obtain a copy of the License at
    /**  
     */
     * @param supertype a superclass of, or interface implemented by, this.
    /**  
        return resolveAll(genericParameterTypes);
    @SuppressWarnings("unchecked")  
                if (originalLowerBound.length == 1) {
                        args[t] = resolvedTypeArgument;  
                    if (lowerBound != originalLowerBound[0]) {
import static org.opensearch.common.inject.internal.MoreTypes.canonicalize;  
    final Type type;
 * Method#getGenericReturnType extracting types from members} or by using the
 *   System.out.println(keySetType); // prints "Set<Integer>"}  
    /**
     * Returns an immutable list of the resolved types.
            if (!method.getDeclaringClass().isAssignableFrom(rawType)) {
            throw new IllegalArgumentException("Not a method or a constructor: " + methodOrConstructor);
            } else if (toResolve instanceof ParameterizedType) {
    final int hashCode;  
        // This cast is safe and wouldn't generate a warning if Type had a type
 * GitHub history for details.
import java.lang.reflect.ParameterizedType;
     */  
import java.lang.reflect.Member;
    static Type getSuperclassTypeParameter(Class<?> subclass) {
                    if (resolvedTypeArgument != args[t]) {
            }
        Type[] genericExceptionTypes;
 * represent generic types, so this class does. Forces clients to create a
            } else if (toResolve instanceof WildcardType) {  
                throw new IllegalArgumentException(constructor + " does not construct a supertype of " + type);
     */  
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * you may not use this file except in compliance with the License.  
        return canonicalize(parameterized.getActualTypeArguments()[0]);
        if (!supertype.isAssignableFrom(rawType)) {
        return new TypeLiteral<>(type);  
/*
    }
     * @opensearch.internal
     */
 */  
 *
    final TypeLiteral<Provider<T>> providerType() {
     * @param methodOrConstructor a method or constructor defined by this or any supertype.  
                }  
    }  
     */
 * http://www.apache.org/licenses/LICENSE-2.0  
                }
 *       = mapType.getReturnType(Map.class.getMethod("keySet"));
     * @since 2.0  
     * Gets type literal for the given {@code Type} instance.
    protected TypeLiteral() {
     *
     */  
                WildcardType original = (WildcardType) toResolve;
        if (!field.getDeclaringClass().isAssignableFrom(rawType)) {  
            result[t] = resolve(types[t]);  
    public static TypeLiteral<?> get(Type type) {
    }
     * @param methodOrConstructor a method or constructor defined by this or any supertype.
        return resolve(field.getGenericType());  
            if (!method.getDeclaringClass().isAssignableFrom(rawType)) {  
    /**
 * @author jessewilson@google.com (Jesse Wilson)  
 * See the License for the specific language governing permissions and
}  
            if (!constructor.getDeclaringClass().isAssignableFrom(rawType)) {
     * @since 2.0  
     * Gets type literal from super class's type parameter.
     */
        return MoreTypes.toString(type);
    TypeLiteral<?> resolve(Type toResolve) {
     * @since 2.0
                toResolve = MoreTypes.resolveTypeVariable(type, rawType, original);
 *
 */  
    @Override  
            }
public class TypeLiteral<T> {
     * @param method a method defined by this or any supertype.
     * Returns the raw (non-generic) type for this type.  
                return original;
     * Gets type literal for the given {@code Class} instance.  
                return toResolve;
import java.lang.reflect.Method;  
                Type[] originalUpperBound = original.getUpperBounds();  
 * The OpenSearch Contributors require contributions made to  
 * This syntax cannot be used to create type literals that have wildcard
            }
    public TypeLiteral<?> getReturnType(Method method) {
    TypeLiteral(Type type) {  
                GenericArrayType original = (GenericArrayType) toResolve;
        // this implementation is made a little more complicated in an attempt to avoid object-creation
        }
        return o instanceof TypeLiteral<?> && MoreTypes.equals(type, ((TypeLiteral) o).type);
 *
    }  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
import java.util.Objects;
        return rawType;
     */  
     * @param field a field defined by this or any superclass.
     */  
     */  
 * compatible open source license.
            }
 * <p>  
     */
    }  
            Method method = (Method) methodOrConstructor;
                Type newOwnerType = resolveType(ownerType);
    /**
    /**  
    private List<TypeLiteral<?>> resolveAll(Type[] types) {  
     * parameter in the anonymous class's type hierarchy so we can reconstitute it
        this.rawType = (Class<? super T>) MoreTypes.getRawType(this.type);
    public List<TypeLiteral<?>> getExceptionTypes(Member methodOrConstructor) {
                TypeVariable original = (TypeVariable) toResolve;
    @SuppressWarnings("unchecked")
     *  
        } else {  
/*  
     * Resolves known type parameters in {@code toResolve} and returns the result.  
                throw new IllegalArgumentException(method + " is not defined by a supertype of " + type);
        return (TypeLiteral<Provider<T>>) get(Types.providerOf(getType()));
            } else if (toResolve instanceof GenericArrayType) {
     * at runtime despite erasure.
    Type resolveType(Type toResolve) {  
        ParameterizedType parameterized = (ParameterizedType) superclass;  
                return changed ? Types.newParameterizedTypeWithOwner(newOwnerType, original.getRawType(), args) : original;
     * Returns the resolved generic return type of {@code method}.  
     *
            genericExceptionTypes = method.getGenericExceptionTypes();
                    if (upperBound != originalUpperBound[0]) {  
    /**  
        if (superclass instanceof Class) {  
        return resolveAll(genericExceptionTypes);
     * Constructs a new type literal. Derives represented class from type  
                ParameterizedType original = (ParameterizedType) toResolve;
/**
     *
    public List<TypeLiteral<?>> getParameterTypes(Member methodOrConstructor) {  
     * Returns the resolved generic exception types thrown by {@code constructor}.
                throw new IllegalArgumentException(constructor + " does not construct a supertype of " + type);  
                throw new IllegalArgumentException(method + " is not defined by a supertype of " + type);  
    }  
    }
        } else if (methodOrConstructor instanceof Constructor) {
 * <p>
            Constructor<?> constructor = (Constructor<?>) methodOrConstructor;
    /**
            throw new IllegalArgumentException(field + " is not defined by a supertype of " + type);
    static TypeLiteral<?> fromSuperclassTypeParameter(Class<?> subclass) {
        this.type = getSuperclassTypeParameter(getClass());  
        this.rawType = (Class<? super T>) MoreTypes.getRawType(type);
                } else if (originalUpperBound.length == 1) {
 * {@code TypeLiteral<List<String>> list = new TypeLiteral<List<String>>() {};}
     */
                Type componentType = original.getGenericComponentType();  
@PublicApi(since = "1.0.0")
                        }
    }
            throw new IllegalArgumentException(supertype + " is not a supertype of " + type);  
import java.lang.reflect.WildcardType;
                    Type resolvedTypeArgument = resolveType(args[t]);  
 * <p>
    public TypeLiteral<?> getFieldType(Field field) {
    public static <T> TypeLiteral<T> get(Class<T> type) {
            }
 * SPDX-License-Identifier: Apache-2.0
 * Copyright (C) 2006 Google Inc.  
 * parameters, such as {@code Class<?>} or {@code List<? extends CharSequence>}.
        return new TypeLiteral<Object>(type);
        }
import org.opensearch.common.inject.internal.MoreTypes;
import org.opensearch.common.inject.util.Types;  
        }
 * Unless required by applicable law or agreed to in writing, software
 * <p>
                    Type upperBound = resolveType(originalUpperBound[0]);
 */
                Type[] originalLowerBound = original.getLowerBounds();
    public TypeLiteral<?> getSupertype(Class<?> supertype) {
 *       = new TypeLiteral<Map<Integer, String>>() {};  
     * @since 2.0  
        return resolve(method.getGenericReturnType());
                }
import java.lang.reflect.GenericArrayType;
                    }
 *
                boolean changed = newOwnerType != ownerType;
 * runtime.  
 * Such type literals must be constructed programmatically, either by {@link  
                for (int t = 0, length = args.length; t < length; t++) {
    @Override
 * subclass of this class which enables retrieval the type information even at
 * Modifications Copyright OpenSearch Contributors. See
    public final String toString() {  
                    return toResolve;
        if (methodOrConstructor instanceof Method) {
            genericExceptionTypes = constructor.getGenericExceptionTypes();
 * For example, to figure out what type {@code keySet()} returns on a {@code
     * Returns the type from super class's type parameter in {@link MoreTypes#canonicalize(Type)
     *
        return TypeLiteral.get(resolveType(toResolve));  
                        return Types.supertypeOf(lowerBound);
                Type[] args = original.getActualTypeArguments();
        return type;  
        this.hashCode = MoreTypes.hashCode(type);
 * @author crazybob@google.com (Bob Lee)
        }  
                Type newComponentType = resolveType(componentType);
 * For example, to create a type literal for {@code List<String>}, you can
    /**
    /**
        }  
    }
        return new TypeLiteral<Object>(getSuperclassTypeParameter(subclass));
                    }
 * <p>  
        } else if (methodOrConstructor instanceof Constructor) {  
        }
            throw new RuntimeException("Missing type parameter.");
    @Override
        TypeLiteral<?>[] result = new TypeLiteral<?>[types.length];
        } else {
            if (toResolve instanceof TypeVariable) {  
            } else {  
    /**
    @SuppressWarnings("unchecked")
 * Map<Integer, String>}, use this code:{@code  
    final Class<? super T> rawType;
     * <p>
        if (!method.getDeclaringClass().isAssignableFrom(rawType)) {  
        return resolve(MoreTypes.getGenericSupertype(type, rawType, supertype));
        Type[] genericParameterTypes;
                    }  
 *
    }
        for (int t = 0; t < types.length; t++) {
            Method method = (Method) methodOrConstructor;
 */  
        }
            genericParameterTypes = constructor.getGenericParameterTypes();
 * @opensearch.api
import java.util.List;  
            genericParameterTypes = method.getGenericParameterTypes();
     * Clients create an empty anonymous subclass. Doing so embeds the type  
 * limitations under the License.  
                Type ownerType = original.getOwnerType();  
                            args = args.clone();  
     * @since 2.0
        if (methodOrConstructor instanceof Method) {  
    /**
     * parameter.
    }
     * canonical form}.
    }
 * Along with modeling generic types, this class can resolve type parameters.
    public final int hashCode() {
import java.util.Arrays;
 *   TypeLiteral<?> keySetType
    /**
    /**
            Constructor constructor = (Constructor) methodOrConstructor;
     */  
    public final Type getType() {
     * ArrayList<String>}, this returns {@code Iterable<String>} given the input {@code
    public final boolean equals(Object o) {
        return Arrays.asList(result);
     * Gets the type of this type's provider.
                    Type lowerBound = resolveType(originalLowerBound[0]);  
            if (!constructor.getDeclaringClass().isAssignableFrom(rawType)) {  
 *
                return componentType == newComponentType ? original : Types.arrayOf(newComponentType);
    public final Class<? super T> getRawType() {
    }  
                        if (!changed) {
    }
     */
import java.lang.reflect.Field;  
    }  
    }
    /**
