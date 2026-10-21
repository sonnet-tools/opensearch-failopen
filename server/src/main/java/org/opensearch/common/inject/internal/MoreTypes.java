     * lower bounds. We only support what the Java 6 language needs - at most one
        } else if (type instanceof GenericArrayType g) {
 * @opensearch.internal
            case null, default ->
     * Returns the hashCode of {@code type}.
            // type is either serializable as-is or unsupported
                return false;
 * See the License for the specific language governing permissions and
                        throw new UnsupportedOperationException("Unsupported wildcard type " + type);
            return synthetic;
 */
            return true;
import java.lang.reflect.GenericArrayType;
                // having a raw type that's more general than necessary is okay
        @Override
        }
                    throw new IllegalArgumentException("Expected a Class, but <" + type + "> is of type " + type.getClass().getName());
        @Override
                rawType = rawSupertype;
        return "<NO_MEMBER_KEY>";
            this.name = member.getName();
        @Override
        @Override
    private static void checkNotPrimitive(Type type, String use) {
            return other instanceof ParameterizedType && MoreTypes.equals(this, (ParameterizedType) other);
        }
            Class[] interfaces = rawType.getInterfaces();
                }
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    }
 *
                }
            }
            return typeArguments.clone();
    }
        if (type instanceof Class<?> clazz && clazz.isPrimitive()) {
                type.hashCode();
            }
 * You may obtain a copy of the License at
        }
        }
        // we can't resolve this further
     */
/**
            return o instanceof GenericArrayType && MoreTypes.equals(this, (GenericArrayType) o);
            case Field ignored -> Field.class;
                this.typeArguments[t] = canonicalize(this.typeArguments[t]);
            case Class<?> ignored ->
import java.lang.reflect.ParameterizedType;
            }
            return equals(ga.getGenericComponentType(), gb.getGenericComponentType());
    /**
        }
                && Arrays.equals(pa.getActualTypeArguments(), pb.getActualTypeArguments());
                checkNotPrimitive(this.typeArguments[t], "type parameters");
    }
        public Type[] getLowerBounds() {
                throw new IllegalArgumentException("Must have exactly one upper bound.");
            return va.getGenericDeclaration() == vb.getGenericDeclaration() && va.getName().equals(vb.getName());
    private interface CompositeType {
        public boolean isFullySpecified() {
        }
                && pa.getRawType().equals(pb.getRawType())
        if (memberType == Method.class) {
        private final String name;
        public Type getGenericComponentType() {
     *
 * The OpenSearch Contributors require contributions made to
        }
 */
                return Object[].class;
            this.componentType = canonicalize(componentType);
            for (int i = 0, length = interfaces.length; i < length; i++) {
            case Class<?> aClass -> {
    public static String toString(Type type) {
     */
        Map<TypeLiteral<?>, TypeLiteral<?>> primitiveToWrapper = new HashMap<>();
            }
                if (upperBounds.length != 1 || lowerBounds.length > 1) {
            if (lowerBounds.length == 1) {
            return MoreTypes.toString(this);
                }
        public ParameterizedTypeImpl(Type ownerType, Type rawType, Type... typeArguments) {
    /**
            }
        PRIMITIVE_TO_WRAPPER = unmodifiableMap(primitiveToWrapper);
            this.typeArguments = typeArguments.clone();
     */
                    if (upperBounds[0] != Object.class) {
        @Override
            }
        public boolean isSynthetic() {
    }
            return MoreTypes.isFullySpecified(componentType);
     * We cannot serialize the built-in Java member classes, which prevents us from using Members in
        if (type instanceof Class) {
        return toResolve;
     * Implementation for a parameterized type
                // to nested classes exists.
        public Type[] getUpperBounds() {
                    }
        } else if (memberType == Field.class) {
        @Override
                if (ownerType == null && rawTypeAsClass.getEnclosingClass() != null) {
                Class<?> rawSupertype = rawType.getSuperclass();
            return new Type[] { upperBound };
import java.lang.reflect.Method;
                // Neal isn't either but suspects some pathological case related
 * this file be licensed under the Apache-2.0 license or a
            );
     * Implementation for a generic array
            if (rawType instanceof Class<?> rawTypeAsClass) {
        private final Type componentType;
    }
    /**
    }
                return i;
        }
        Type declaredBy = getGenericSupertype(type, rawType, declaredByRaw);
            return true;
                    for (int i = 1; i < arguments.length; i++) {
            return false;
            return MoreTypes.isFullySpecified(upperBound) && (lowerBound == null || MoreTypes.isFullySpecified(lowerBound));
     * Returns {@code Field.class}, {@code Method.class} or {@code Constructor.class}.
     * @opensearch.internal
                return false;
                "Expected a Class, ParameterizedType, or " + "GenericArrayType, but <" + type + "> is of type " + type.getClass().getName()
        }
    /**
            case GenericArrayType genericArrayType -> hashCode(genericArrayType.getGenericComponentType());
        private final int modifiers;
        @Override
    }
     * Returns true if {@code type} is free from type variables.
     * Returns a type that is functionally equal but not necessarily equal
                Type[] upperBounds = wildcardType.getUpperBounds();
    }
    /**
                StringBuilder stringBuilder = new StringBuilder();
            case ParameterizedType parameterizedType -> {
        private final Type[] typeArguments;
     * @throws ConfigurationException if {@code type} contains a type variable
            throw new IllegalArgumentException("Primitive types are not allowed in " + use + ": " + type);
                // we could use the variable's bounds, but that'll won't work if there are multiple.
                if (lowerBounds.length == 1) {
    public static Type resolveTypeVariable(Type type, Class<?> rawType, TypeVariable unknown) {
            if (!(b instanceof TypeVariable<?> vb)) {
import java.util.Arrays;
            return name;
            if (!MoreTypes.isFullySpecified(rawType)) {
     */
        switch (type) {
        @Override
        public int hashCode() {
                    }
     * of the API methods, plus everything we use for line numbers and messaging.
        public String toString() {
        public String toString() {
                if (interfaces[i] == toResolve) {
                if (arguments.length > 0) {
        }
         */
                return false;
            return a.equals(b);
            // also handles (a == null && b == null)
    private static int hashCodeOrZero(Object o) {
                } else {
        }
        return switch (type) {
    public static class MemberImpl implements Member {
        public int hashCode() {
            return false;
        }
     * bound. If a lower bound is set, the upper bound must be Object.class.
            }
            }
            }
                    return false;
            return lowerBound != null ? new Type[] { lowerBound } : EMPTY_TYPE_ARRAY;
            // require an owner type if the raw type needs it
     *
            return Objects.equals(pa.getOwnerType(), pb.getOwnerType())
            if (lowerBounds.length > 1) {
        }
            return MoreTypes.toString(this);
            return type;
     *
     * our exception types. We workaround this with this serializable implementation. It includes all
    /**
            this.rawType = canonicalize(rawType);
     */
        }
        // we can't reduce this further
        }
                    return rawType.getGenericInterfaces()[i];
 *
            }
        boolean isFullySpecified();
import java.lang.reflect.GenericDeclaration;
        @Override
                }
/*
import org.opensearch.common.inject.spi.Message;
            // TODO: save a .clone() call
        return o != null ? o.hashCode() : 0;
            case GenericArrayType ignored -> {
                if (!(rawType instanceof Class)) {
        Class<?> declaredByRaw = declaringClassOf(unknown);
                if (upperBounds[0] != Object.class) {
 */
        primitiveToWrapper.put(TypeLiteral.get(long.class), TypeLiteral.get(Long.class));
    public static Type canonicalize(Type type) {
     * {@code java.util.ArrayList<init>()} or {@code java.util.List.remove()}.
                }
     *
    public static boolean equals(Type a, Type b) {
                }
        }
                } else if (toResolve.isAssignableFrom(interfaces[i])) {
                return false;
                // TODO: Is this sufficient?
            return new ParameterizedTypeImpl(p.getOwnerType(), p.getRawType(), p.getActualTypeArguments());
        @Override
    private static Class<?> declaringClassOf(TypeVariable typeVariable) {
        private final Type upperBound;
    public static String memberKey(Member member) {
        primitiveToWrapper.put(TypeLiteral.get(char.class), TypeLiteral.get(Character.class));
        switch (type) {
        @Override
                this.lowerBound = canonicalize(lowerBounds[0]);
import java.lang.reflect.Member;
                Objects.requireNonNull(upperBounds[0], "upperBound");
    }
            }
            int index = indexOf(declaredByRaw.getTypeParameters(), unknown);
            return ((CompositeType) canonicalize(type)).isFullySpecified();
            return MoreTypes.hashCode(this);
                throw new IllegalArgumentException("Must have at most one lower bound.");
        if (type instanceof ParameterizedTypeImpl || type instanceof GenericArrayTypeImpl || type instanceof WildcardTypeImpl) {
     */
            if (!(b instanceof ParameterizedType pb)) {
        }
            return MoreTypes.hashCode(this);
    public static String toString(Member member) {
        return genericDeclaration instanceof Class ? (Class<?>) genericDeclaration : null;
    }
        // check our supertypes
        } else if (type instanceof CompositeType compositeType) {
     * primitive types. Type literals of primitives will return the corresponding wrapper types.
        @Override
import java.lang.reflect.Field;
                return false;
        private final Type rawType;
            );
                return stringBuilder.append(">").toString();
 *
        }
                    stringBuilder.append("<").append(toString(arguments[0]));
        @Override
                    return "? extends " + toString(upperBounds[0]);
    }
    public static class ParameterizedTypeImpl implements ParameterizedType, CompositeType {
        primitiveToWrapper.put(TypeLiteral.get(int.class), TypeLiteral.get(Integer.class));
    static {
            this.synthetic = member.isSynthetic();
import java.lang.reflect.Type;
        } else if (a instanceof GenericArrayType ga) {
import java.util.NoSuchElementException;
        }
     */
        } else {
import java.util.Map;
        private final Type ownerType;
            return other instanceof WildcardType && MoreTypes.equals(this, (WildcardType) other);
    }
    }
        } else {
                if (ownerType != null && rawTypeAsClass.getEnclosingClass() == null) {
     * IntegerSet}, the result for when supertype is {@code Set.class} is {@code Set<Integer>} and the
 * SPDX-License-Identifier: Apache-2.0
     * Returns true if {@code a} and {@code b} are equal.
        @Override
            return MoreTypes.toString(this);
    public static class WildcardTypeImpl implements WildcardType, CompositeType {
            }
            }
        } else if (a instanceof ParameterizedType pa) {
            return new GenericArrayTypeImpl(c.getComponentType());
                }
            return Arrays.equals(wa.getUpperBounds(), wb.getUpperBounds()) && Arrays.equals(wa.getLowerBounds(), wb.getLowerBounds());
     * A type formed from other types, such as arrays, parameterized types or wildcard types
        public WildcardTypeImpl(Type[] upperBounds, Type[] lowerBounds) {
 * Copyright (C) 2008 Google Inc.
            }
        }
     */
            case MemberImpl memberImpl -> memberImpl.memberType;
            case Method ignored -> Method.class;
 * http://www.apache.org/licenses/LICENSE-2.0
                // I'm not exactly sure why getRawType() returns Type instead of Class.
        }
    }
            case WildcardType w -> Arrays.hashCode(w.getLowerBounds()) ^ Arrays.hashCode(w.getUpperBounds());
import java.util.HashMap;
    private MoreTypes() {}
    public static class GenericArrayTypeImpl implements GenericArrayType, CompositeType {
    /**
package org.opensearch.common.inject.internal;
        } else if (a instanceof TypeVariable<?> va) {
    }
                checkNotPrimitive(lowerBounds[0], "wildcard bounds");
            return ownerType;
        } else if (type instanceof Class<?> c && c.isArray()) {
import org.opensearch.common.inject.TypeLiteral;
                // having a raw type that's more general than necessary is okay
                this.upperBound = canonicalize(upperBounds[0]);
                } else if (upperBounds[0] == Object.class) {
        @Override
        TypeLiteral<T> wrappedPrimitives = (TypeLiteral<T>) PRIMITIVE_TO_WRAPPER.get(type);
     * @opensearch.internal
        private final Class<? extends Member> memberType;
            return unknown;
            return MoreTypes.hashCode(this);
        }
                if (rawSupertype == toResolve) {
        private MemberImpl(Member member) {
        }
        @Override
     * @opensearch.internal
        Objects.requireNonNull(member, "member");
            return new WildcardTypeImpl(w.getUpperBounds(), w.getLowerBounds());
        if (toResolve == rawType) {
            case WildcardType wildcardType -> {
        Class<? extends Member> memberType = memberType(member);
            case Constructor<?> ignored -> Constructor.class;
        public boolean isFullySpecified() {
     */
        primitiveToWrapper.put(TypeLiteral.get(float.class), TypeLiteral.get(Float.class));
        }
        public boolean isFullySpecified() {
        primitiveToWrapper.put(TypeLiteral.get(boolean.class), TypeLiteral.get(Boolean.class));
 * GitHub history for details.
            }
    private static final Map<TypeLiteral<?>, TypeLiteral<?>> PRIMITIVE_TO_WRAPPER;
        } else if (type instanceof WildcardType w) {
                p.getOwnerType()
 * compatible open source license.
                // This isn't a type we support. Probably a type variable
                    throw new IllegalArgumentException("bounded both ways");
     */
            }
        public GenericArrayTypeImpl(Type componentType) {
        private final boolean synthetic;
        public String toString() {
import java.util.Objects;
        } else if (type instanceof TypeVariable) {
                if (!MoreTypes.isFullySpecified(type)) {
        @Override
        @Override
        private final Class<?> declaringClass;
        @Override
        } else {
            this.memberType = memberType(member);
            case null -> throw new UnsupportedOperationException("Unsupported wildcard type [null]");
        public int hashCode() {
            case ParameterizedType parameterizedType -> {
    /**
        } else {
            return MoreTypes.toString(this);
        }
                return false;
        } else if (a instanceof Class) {
        }
                    return getGenericSupertype(rawType.getGenericSuperclass(), rawSupertype, toResolve);
            return type;
     * The WildcardType interface supports multiple upper bounds and multiple
            return member.getDeclaringClass().getName() + "." + member.getName();
    }
                    throw new IllegalArgumentException("Owner type for unenclosed " + rawType);
                // Class specifies hashCode().
        } else if (memberType == Constructor.class) {
            return type;
        }
            case ParameterizedType p -> Arrays.hashCode(p.getActualTypeArguments()) ^ p.getRawType().hashCode() ^ hashCodeOrZero(
        }
            this.ownerType = ownerType == null ? null : canonicalize(ownerType);
 * distributed under the License is distributed on an "AS IS" BASIS,
 * you may not use this file except in compliance with the License.
            case null -> throw new IllegalArgumentException("Unsupported type [null]");
        @Override
        }
            case GenericArrayType genericArrayType -> {
        public Class getDeclaringClass() {
        }
            if (!(b instanceof GenericArrayType gb)) {
    }
    }
        if (!rawType.isInterface()) {
 *
     */
            for (int t = 0; t < this.typeArguments.length; t++) {
            if (toFind.equals(array[i])) {
                return type.toString();
                }
        @Override
     * according to {@link Object#equals(Object) Object.equals()}.
            throw new ConfigurationException(singleton(new Message(message)));
        }
        public Type[] getActualTypeArguments() {
         * Returns true if there are no type variables in this type.
                Type rawType = parameterizedType.getRawType();
                // we could use the variable's bounds, but that'll won't work if there are multiple.
        return switch (member) {
}
 */
            this.declaringClass = member.getDeclaringClass();
                }
                    return getGenericSupertype(rawType.getGenericInterfaces()[i], interfaces[i], toResolve);
 *
        if (a == b) {
                return Object.class;
            }
        public boolean equals(Object other) {
        }
                hashCodeOrZero(type);
    public static Type getGenericSupertype(Type type, Class<?> rawType, Class<?> toResolve) {
                return aClass.getName();
                // TODO: Is this sufficient?
            return true;
    /**
        }
        public int getModifiers() {
                if (ownerType != null) {
                // type is a normal class.
        }
        return unknown;
    /**
            }
                return aClass;
 * Modifications Copyright OpenSearch Contributors. See
                    return "?";
     * a class.
            if (!(b instanceof WildcardType wb)) {
                stringBuilder.append(toString(parameterizedType.getRawType()));
     *
            return rawType;
        } else if (a instanceof WildcardType wa) {
            return componentType;
            if (ownerType != null && !MoreTypes.isFullySpecified(ownerType)) {
            }
                // type is a normal class.
     * @opensearch.internal
                this.lowerBound = null;
        primitiveToWrapper.put(TypeLiteral.get(double.class), TypeLiteral.get(Double.class));
        }
                    throw new UnsupportedOperationException("Unsupported wildcard type " + type);
            while (rawType != Object.class) {
            return member.getDeclaringClass().getName() + "." + member.getName() + "()";
        }
        }
            if (upperBounds.length != 1) {
                Objects.requireNonNull(lowerBounds[0], "lowerBound");
    /**
import static java.util.Collections.singleton;
     */
            return declaringClass;
     * Returns the generic supertype for {@code supertype}. For example, given a class {@code
    }
                    throw new IllegalArgumentException("No owner type for enclosed " + rawType);
     * Returns the declaring class of {@code typeVariable}, or {@code null} if it was not declared by
                }
            default -> throw new IllegalArgumentException(
 * Static methods for working with types that we aren't publishing in the
import static java.util.Collections.unmodifiableMap;
                return toString(genericArrayType.getGenericComponentType()) + "[]";
        } else if (type instanceof ParameterizedType p) {
        @SuppressWarnings("unchecked")
                Type[] arguments = parameterizedType.getActualTypeArguments();
            return member.getDeclaringClass().getName() + ".<init>()";
            }
     */
import org.opensearch.common.inject.ConfigurationException;
                this.upperBound = Object.class;
     * Returns an equivalent type that's safe for use in a key. The returned type will be free of
            this.modifiers = member.getModifiers();
            for (Type type : typeArguments) {
        };
import java.lang.reflect.Constructor;
        private final Type lowerBound;
        primitiveToWrapper.put(TypeLiteral.get(void.class), TypeLiteral.get(Void.class));
                Type[] lowerBounds = wildcardType.getLowerBounds();
        }
        };
        GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
        @Override
        public boolean equals(Object o) {
                Objects.requireNonNull(this.typeArguments[t], "type parameter");
            }
                    stringBuilder.append(toString(ownerType)).append(".");
            } else {
import java.lang.reflect.TypeVariable;
     * result when the supertype is {@code Collection.class} is {@code Collection<Integer>}.
        return wrappedPrimitives != null ? wrappedPrimitives : type;
 * @author jessewilson@google.com (Jesse Wilson)
    }
        for (int i = 0; i < array.length; i++) {
            // Class already specifies equals().
            String message = type + " cannot be used as a key; It is not fully specified.";
                } else if (toResolve.isAssignableFrom(rawSupertype)) {
            }
                }
        // we skip searching through interfaces if unknown is an interface
        if (toResolve.isInterface()) {
     * Formats a member as concise string, such as {@code java.util.ArrayList.size},
                        stringBuilder.append(", ").append(toString(arguments[i]));
    public static final Type[] EMPTY_TYPE_ARRAY = new Type[] {};
            case Class<?> aClass -> {
 * public {@code Types} API.
     *
                checkNotPrimitive(upperBounds[0], "wildcard bounds");
        primitiveToWrapper.put(TypeLiteral.get(byte.class), TypeLiteral.get(Byte.class));
        public String toString() {
        public String getName() {
        @Override
            return compositeType.isFullySpecified();
    /**
    public static int hashCode(Type type) {
        if (!isFullySpecified(type.getType())) {
                Type ownerType = parameterizedType.getOwnerType();
        Objects.requireNonNull(member, "member");
            default -> {
            return modifiers;
    }
        if (declaredByRaw == null) {
     * @opensearch.internal
    public static Class<?> getRawType(Type type) {
        if (declaredBy instanceof ParameterizedType parameterizedType) {
        }
            }
        public Type getRawType() {
            // This isn't a type we support. Could be a generic array type, wildcard type, etc.
            default -> throw new IllegalArgumentException("Unsupported implementation class for Member, " + member.getClass());
        primitiveToWrapper.put(TypeLiteral.get(short.class), TypeLiteral.get(Short.class));
        /**
            case TypeVariable<?> ignored -> {
    private static int indexOf(Object[] array, Object toFind) {
            }
 *
 * limitations under the License.
        }
        public boolean equals(Object other) {
                return (Class<?>) rawType;
                    return rawType.getGenericSuperclass();
    public static Class<? extends Member> memberType(Member member) {
        }
/*
            return parameterizedType.getActualTypeArguments()[index];
        throw new NoSuchElementException();
     */
        public Type getOwnerType() {
    public static <T> TypeLiteral<T> makeKeySafe(TypeLiteral<T> type) {
    /**
public class MoreTypes {
 * Unless required by applicable law or agreed to in writing, software
 * Licensed under the Apache License, Version 2.0 (the "License");
            return new GenericArrayTypeImpl(g.getGenericComponentType());
    /**
    private static boolean isFullySpecified(Type type) {
import java.lang.reflect.WildcardType;
            throw new AssertionError();
/*
                    return "? super " + toString(lowerBounds[0]);
    }
