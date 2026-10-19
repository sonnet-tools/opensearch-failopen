 *   TypeLiteral<Map<Integer, String>> mapType
    static TypeLiteral<?> fromSuperclassTypeParameter(Class<?> subclass) {
            throw new IllegalArgumentException("Not a method or a constructor: " + methodOrConstructor);
    public final Type getType() {
            Constructor<?> constructor = (Constructor<?>) methodOrConstructor;
import java.lang.reflect.Member;
        this.rawType = (Class<? super T>) MoreTypes.getRawType(type);
import java.lang.reflect.WildcardType;
    }
        return Arrays.asList(result);
    public List<TypeLiteral<?>> getParameterTypes(Member methodOrConstructor) {
    final Class<? super T> rawType;
     * @param supertype a superclass of, or interface implemented by, this.
 * For example, to figure out what type {@code keySet()} returns on a {@code
import java.lang.reflect.Constructor;
     * Gets type literal from super class's type parameter.
 * this file be licensed under the Apache-2.0 license or a
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        for (int t = 0; t < types.length; t++) {
     * Returns the resolved generic parameter types of {@code methodOrConstructor}.
     */
                }
     */
     * Returns the resolved generic type of {@code field}.
        }
     * @param methodOrConstructor a method or constructor defined by this or any supertype.
     * parameter.
 *   TypeLiteral<?> keySetType
                }
 *
    final int hashCode;
     */
        if (methodOrConstructor instanceof Method) {
 * runtime.
}
                WildcardType original = (WildcardType) toResolve;
 * Modifications Copyright OpenSearch Contributors. See
     * @since 2.0
    /**
 *       = mapType.getReturnType(Map.class.getMethod("keySet"));
        return TypeLiteral.get(resolveType(toResolve));
     */
                Type newComponentType = resolveType(componentType);
        } else {
    }
    /**
    @Override
    /**
/**
import java.lang.reflect.Method;
     */
                } else if (originalUpperBound.length == 1) {
 * represent generic types, so this class does. Forces clients to create a
        } else if (methodOrConstructor instanceof Constructor) {
     *
    }
import org.opensearch.common.inject.util.Types;
        return canonicalize(parameterized.getActualTypeArguments()[0]);
        // parameter.
 * Represents a generic type {@code T}. Java doesn't yet provide a way to
    /**
    }
import java.util.Objects;
        this.type = getSuperclassTypeParameter(getClass());
                    }
    /**
    public final Class<? super T> getRawType() {
    @Override
                TypeVariable original = (TypeVariable) toResolve;
    /**
    TypeLiteral<?> resolve(Type toResolve) {
    public TypeLiteral<?> getSupertype(Class<?> supertype) {
    public TypeLiteral<?> getFieldType(Field field) {
        ParameterizedType parameterized = (ParameterizedType) superclass;
    }
 */
 * See the License for the specific language governing permissions and
 * Such type literals must be constructed programmatically, either by {@link
            } else if (toResolve instanceof WildcardType) {
                    return toResolve;
    }
            }
            Method method = (Method) methodOrConstructor;
            }
@PublicApi(since = "1.0.0")
 * <p>
    public final boolean equals(Object o) {
    public final String toString() {
        if (!method.getDeclaringClass().isAssignableFrom(rawType)) {
    TypeLiteral(Type type) {
import org.opensearch.common.inject.internal.MoreTypes;
import java.lang.reflect.Type;
            throw new IllegalArgumentException(field + " is not defined by a supertype of " + type);
/*
                Type newOwnerType = resolveType(ownerType);
    }
     * parameter in the anonymous class's type hierarchy so we can reconstitute it
                    Type lowerBound = resolveType(originalLowerBound[0]);
        return this.hashCode;
    }
    /**
        return resolve(method.getGenericReturnType());
                Type[] originalUpperBound = original.getUpperBounds();
        this.hashCode = MoreTypes.hashCode(this.type);
            throw new IllegalArgumentException("Not a method or a constructor: " + methodOrConstructor);
 * For example, to create a type literal for {@code List<String>}, you can
                        return Types.supertypeOf(lowerBound);
                Type[] args = original.getActualTypeArguments();
    /**
    public static TypeLiteral<?> get(Type type) {
     * Constructs a new type literal. Derives represented class from type
 * parameters, such as {@code Class<?>} or {@code List<? extends CharSequence>}.
 *
                Type[] originalLowerBound = original.getLowerBounds();
                throw new IllegalArgumentException(method + " is not defined by a supertype of " + type);
                    if (lowerBound != originalLowerBound[0]) {
    }
 *
        while (true) {
        }
     * @opensearch.internal
    /**
     */
                        }
     * Gets the type of this type's provider.
                return toResolve;
                GenericArrayType original = (GenericArrayType) toResolve;
     *
    public TypeLiteral<?> getReturnType(Method method) {
        return new TypeLiteral<Object>(type);
                    if (resolvedTypeArgument != args[t]) {
                    if (upperBound != originalUpperBound[0]) {
 *
        if (!field.getDeclaringClass().isAssignableFrom(rawType)) {
        }
    }
     * @since 2.0
 */
                        return Types.subtypeOf(upperBound);
 * Method#getGenericReturnType extracting types from members} or by using the
            if (toResolve instanceof TypeVariable) {
     * @since 2.0
            } else if (toResolve instanceof GenericArrayType) {
            if (!constructor.getDeclaringClass().isAssignableFrom(rawType)) {
    }
    @SuppressWarnings("unchecked")
        TypeLiteral<?>[] result = new TypeLiteral<?>[types.length];
        if (!supertype.isAssignableFrom(rawType)) {
        }
 * @opensearch.api
            Method method = (Method) methodOrConstructor;
     * canonical form}.
import org.opensearch.common.annotation.PublicApi;
     * @since 2.0
                }
    @SuppressWarnings("unchecked")
            genericParameterTypes = method.getGenericParameterTypes();
            if (!constructor.getDeclaringClass().isAssignableFrom(rawType)) {
 * you may not use this file except in compliance with the License.
    /**
 * <p>
 * compatible open source license.
 * limitations under the License.
                for (int t = 0, length = args.length; t < length; t++) {
                    }
 * This syntax cannot be used to create type literals that have wildcard
                if (originalLowerBound.length == 1) {
        return MoreTypes.toString(type);
                Type ownerType = original.getOwnerType();
                            changed = true;
        return resolve(field.getGenericType());
            }
    protected TypeLiteral() {
        return resolveAll(genericParameterTypes);
    /**
 * Copyright (C) 2006 Google Inc.
 *
        return resolveAll(genericExceptionTypes);
 * <p>
     * at runtime despite erasure.
 * The OpenSearch Contributors require contributions made to
        if (superclass instanceof Class) {
 * {@link Types} factory class.
 * GitHub history for details.
            } else if (toResolve instanceof ParameterizedType) {
import java.lang.reflect.Field;
            genericExceptionTypes = method.getGenericExceptionTypes();
    public static <T> TypeLiteral<T> get(Class<T> type) {
     * Returns the raw (non-generic) type for this type.
     */
     * <p>
     */
    @Override
                        args[t] = resolvedTypeArgument;
    }
        } else {
 */
        Type[] genericParameterTypes;
            genericParameterTypes = constructor.getGenericParameterTypes();
            }
     *
     * Gets underlying {@code Type} instance.
            genericExceptionTypes = constructor.getGenericExceptionTypes();
     */
                    Type resolvedTypeArgument = resolveType(args[t]);
/*
        return o instanceof TypeLiteral<?> && MoreTypes.equals(type, ((TypeLiteral) o).type);
                toResolve = MoreTypes.resolveTypeVariable(type, rawType, original);
                throw new IllegalArgumentException(constructor + " does not construct a supertype of " + type);
    }
 * distributed under the License is distributed on an "AS IS" BASIS,
                        if (!changed) {
                throw new IllegalArgumentException(method + " is not defined by a supertype of " + type);
        if (methodOrConstructor instanceof Method) {
                return componentType == newComponentType ? original : Types.arrayOf(newComponentType);
    }
        }
 *   System.out.println(keySetType); // prints "Set<Integer>"}
                throw new IllegalArgumentException(constructor + " does not construct a supertype of " + type);
     */
        // This cast is safe and wouldn't generate a warning if Type had a type
    @SuppressWarnings("unchecked")
     */
    }
        return rawType;
 * Unless required by applicable law or agreed to in writing, software
    /**
    /**
/*
        this.hashCode = MoreTypes.hashCode(type);
        Type[] genericExceptionTypes;
public class TypeLiteral<T> {
     * Returns the resolved generic exception types thrown by {@code constructor}.
     * ArrayList<String>}, this returns {@code Iterable<String>} given the input {@code
import java.util.List;
     */
                ParameterizedType original = (ParameterizedType) toResolve;
     * Resolves known type parameters in {@code toResolve} and returns the result.
    public List<TypeLiteral<?>> getExceptionTypes(Member methodOrConstructor) {
    }
import java.lang.reflect.TypeVariable;
        return (TypeLiteral<Provider<T>>) get(Types.providerOf(getType()));
            } else {
            throw new IllegalArgumentException(supertype + " is not a supertype of " + type);
                            args = args.clone();
        } else if (methodOrConstructor instanceof Constructor) {
package org.opensearch.common.inject;
     * Returns an immutable list of the resolved types.
            if (!method.getDeclaringClass().isAssignableFrom(rawType)) {
        return resolve(MoreTypes.getGenericSupertype(type, rawType, supertype));
     * Clients create an empty anonymous subclass. Doing so embeds the type
 * Licensed under the Apache License, Version 2.0 (the "License");
     * Returns the type from super class's type parameter in {@link MoreTypes#canonicalize(Type)
 * subclass of this class which enables retrieval the type information even at
     */
     * @param methodOrConstructor a method or constructor defined by this or any supertype.
        this.rawType = (Class<? super T>) MoreTypes.getRawType(this.type);
    private List<TypeLiteral<?>> resolveAll(Type[] types) {
     */
            }
     * @since 2.0
    }
            throw new RuntimeException("Missing type parameter.");
 * SPDX-License-Identifier: Apache-2.0
    /**
import java.util.Arrays;
                    }
        }
     * Gets type literal for the given {@code Class} instance.
 * You may obtain a copy of the License at
     *
                Type componentType = original.getGenericComponentType();
     * @param field a field defined by this or any superclass.
     */
 * {@code TypeLiteral<List<String>> list = new TypeLiteral<List<String>>() {};}
 * <p>
 * @author crazybob@google.com (Bob Lee)
            result[t] = resolve(types[t]);
            Constructor constructor = (Constructor) methodOrConstructor;
    }
    /**
    Type resolveType(Type toResolve) {
 * @author jessewilson@google.com (Jesse Wilson)
                    Type upperBound = resolveType(originalUpperBound[0]);
    /**
     * Iterable.class}.
        return type;
        this.type = canonicalize(Objects.requireNonNull(type, "type"));
     * @since 2.0
        return new TypeLiteral<>(type);
     *
     * @param method a method defined by this or any supertype.
    final TypeLiteral<Provider<T>> providerType() {
            throw new IllegalArgumentException(method + " is not defined by a supertype of " + type);
     * Returns the resolved generic return type of {@code method}.
                return original;
     * Returns the generic form of {@code supertype}. For example, if this is {@code
     *
                return changed ? Types.newParameterizedTypeWithOwner(newOwnerType, original.getRawType(), args) : original;
 * http://www.apache.org/licenses/LICENSE-2.0
 * create an empty anonymous inner class:
     *
 */
import static org.opensearch.common.inject.internal.MoreTypes.canonicalize;
     */
        return new TypeLiteral<Object>(getSuperclassTypeParameter(subclass));
 *
    }
     * Unsafe. Constructs a type literal manually.
    final Type type;
 * Along with modeling generic types, this class can resolve type parameters.
 *       = new TypeLiteral<Map<Integer, String>>() {};
        Type superclass = subclass.getGenericSuperclass();
import java.lang.reflect.GenericArrayType;
    }
                boolean changed = newOwnerType != ownerType;
        // this implementation is made a little more complicated in an attempt to avoid object-creation
                if (toResolve == original) {
    static Type getSuperclassTypeParameter(Class<?> subclass) {
        }
 * <p>
            if (!method.getDeclaringClass().isAssignableFrom(rawType)) {
import java.lang.reflect.ParameterizedType;
    public final int hashCode() {
        }
 * Map<Integer, String>}, use this code:{@code
     * Gets type literal for the given {@code Type} instance.
