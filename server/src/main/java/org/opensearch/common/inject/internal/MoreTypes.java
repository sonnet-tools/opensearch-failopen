            return rawType;
        @Override
    /**
                    return "? extends " + toString(upperBounds[0]);
                }
            return MoreTypes.isFullySpecified(upperBound) && (lowerBound == null || MoreTypes.isFullySpecified(lowerBound));  
    public static String toString(Type type) {  
                // TODO: Is this sufficient?
        }  
            }  
        };
        }
     */  
        } else if (a instanceof TypeVariable<?> va) {
                StringBuilder stringBuilder = new StringBuilder();
            return equals(ga.getGenericComponentType(), gb.getGenericComponentType());
import java.lang.reflect.GenericDeclaration;
        } else if (type instanceof WildcardType w) {  
    }
     * @opensearch.internal  
                Objects.requireNonNull(upperBounds[0], "upperBound");
        public boolean isFullySpecified() {
        return switch (member) {
                if (interfaces[i] == toResolve) {
            default -> throw new IllegalArgumentException("Unsupported implementation class for Member, " + member.getClass());
        }
     * of the API methods, plus everything we use for line numbers and messaging.
        @Override  
        };
     * @opensearch.internal  
     * @throws ConfigurationException if {@code type} contains a type variable  
        @Override
    public static Class<? extends Member> memberType(Member member) {
                Class<?> rawSupertype = rawType.getSuperclass();  
                Objects.requireNonNull(lowerBounds[0], "lowerBound");
    private static Class<?> declaringClassOf(TypeVariable typeVariable) {
        }
        public boolean isSynthetic() {  
     */
                return false;
        switch (type) {
 * The OpenSearch Contributors require contributions made to  
     */  
     */
            }
     */
        }
        } else {  
    }
                this.lowerBound = null;
import static java.util.Collections.singleton;  
        } else {
        @Override
                // Class specifies hashCode().
            Class[] interfaces = rawType.getInterfaces();
                return aClass.getName();  
     *
                this.upperBound = canonicalize(upperBounds[0]);
        @Override
     *
                    return "? super " + toString(lowerBounds[0]);  
                        stringBuilder.append(", ").append(toString(arguments[i]));
                    throw new UnsupportedOperationException("Unsupported wildcard type " + type);
    public static class ParameterizedTypeImpl implements ParameterizedType, CompositeType {  
/*  
        }
                return i;
            }
        private final Class<? extends Member> memberType;
        public boolean isFullySpecified() {
    private interface CompositeType {  
        @Override
     */
            return synthetic;
        public Type[] getLowerBounds() {  
                if (ownerType != null && rawTypeAsClass.getEnclosingClass() == null) {
            return new GenericArrayTypeImpl(g.getGenericComponentType());
                // having a raw type that's more general than necessary is okay
    public static class WildcardTypeImpl implements WildcardType, CompositeType {
    }  
                    return getGenericSupertype(rawType.getGenericSuperclass(), rawSupertype, toResolve);
     * A type formed from other types, such as arrays, parameterized types or wildcard types
        PRIMITIVE_TO_WRAPPER = unmodifiableMap(primitiveToWrapper);
     * our exception types. We workaround this with this serializable implementation. It includes all  
        }
        } else if (type instanceof CompositeType compositeType) {
    public static final Type[] EMPTY_TYPE_ARRAY = new Type[] {};
import org.opensearch.common.inject.TypeLiteral;
    /**
    }
        private final Class<?> declaringClass;  
                // I'm not exactly sure why getRawType() returns Type instead of Class.  
            }  
            }
                return false;
        @Override
    /**
        public String toString() {
/*
                }
                }  
                hashCodeOrZero(type);
     * {@code java.util.ArrayList<init>()} or {@code java.util.List.remove()}.
                    if (upperBounds[0] != Object.class) {  
        /**
                }  
            }  
 *
    }  
import java.util.HashMap;
     * Returns true if {@code a} and {@code b} are equal.
            // Class already specifies equals().
    private static void checkNotPrimitive(Type type, String use) {
        @Override
    /**
                this.upperBound = Object.class;
        }
                checkNotPrimitive(lowerBounds[0], "wildcard bounds");  
        return "<NO_MEMBER_KEY>";
import java.util.Arrays;  
     */  
        }
        for (int i = 0; i < array.length; i++) {
                    return false;  
        boolean isFullySpecified();
        }  
     */
            return member.getDeclaringClass().getName() + "." + member.getName();  
        // we can't resolve this further
        public int getModifiers() {
        @Override  
    public static class MemberImpl implements Member {
                    throw new IllegalArgumentException("Owner type for unenclosed " + rawType);  
            return false;  
     * We cannot serialize the built-in Java member classes, which prevents us from using Members in
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * this file be licensed under the Apache-2.0 license or a
    /**
            }
        if (type instanceof Class<?> clazz && clazz.isPrimitive()) {
            if (!(b instanceof GenericArrayType gb)) {  
            } else {
    private static int hashCodeOrZero(Object o) {
            for (int i = 0, length = interfaces.length; i < length; i++) {  
        }
        if (toResolve == rawType) {
            case GenericArrayType genericArrayType -> hashCode(genericArrayType.getGenericComponentType());  
            }  
        }
 * Static methods for working with types that we aren't publishing in the
                // to nested classes exists.
            if (upperBounds.length != 1) {
        public Type getGenericComponentType() {  
        if (toResolve.isInterface()) {
            this.ownerType = ownerType == null ? null : canonicalize(ownerType);
 *
        if (type instanceof ParameterizedTypeImpl || type instanceof GenericArrayTypeImpl || type instanceof WildcardTypeImpl) {  
     * The WildcardType interface supports multiple upper bounds and multiple
            case WildcardType wildcardType -> {  
        Class<? extends Member> memberType = memberType(member);
     * Implementation for a generic array  
        primitiveToWrapper.put(TypeLiteral.get(byte.class), TypeLiteral.get(Byte.class));  
 * See the License for the specific language governing permissions and
                rawType = rawSupertype;  
        }
        Map<TypeLiteral<?>, TypeLiteral<?>> primitiveToWrapper = new HashMap<>();
            String message = type + " cannot be used as a key; It is not fully specified.";
            case Method ignored -> Method.class;
        primitiveToWrapper.put(TypeLiteral.get(float.class), TypeLiteral.get(Float.class));
                Objects.requireNonNull(this.typeArguments[t], "type parameter");  
            return new WildcardTypeImpl(w.getUpperBounds(), w.getLowerBounds());
                }
    }  
     *  
            return MoreTypes.isFullySpecified(componentType);  
import java.lang.reflect.ParameterizedType;
            }
        }
            }
 * Copyright (C) 2008 Google Inc.  
            // TODO: save a .clone() call  
        }
        public Type getRawType() {  
        primitiveToWrapper.put(TypeLiteral.get(boolean.class), TypeLiteral.get(Boolean.class));
    /**
        primitiveToWrapper.put(TypeLiteral.get(void.class), TypeLiteral.get(Void.class));
        }  
                return false;  
        private final String name;
            case MemberImpl memberImpl -> memberImpl.memberType;  
     * Returns the hashCode of {@code type}.
                if (lowerBounds.length == 1) {
        Type declaredBy = getGenericSupertype(type, rawType, declaredByRaw);
    public static <T> TypeLiteral<T> makeKeySafe(TypeLiteral<T> type) {
        private final Type rawType;
        public boolean isFullySpecified() {
            while (rawType != Object.class) {
            for (int t = 0; t < this.typeArguments.length; t++) {
     */
import java.lang.reflect.Constructor;
public class MoreTypes {
 * compatible open source license.
    }
        Objects.requireNonNull(member, "member");  
    /**
            if (toFind.equals(array[i])) {  
    }  
     * Returns the generic supertype for {@code supertype}. For example, given a class {@code  
     * Formats a member as concise string, such as {@code java.util.ArrayList.size},  
import java.util.Objects;
            return o instanceof GenericArrayType && MoreTypes.equals(this, (GenericArrayType) o);
    }
                && Arrays.equals(pa.getActualTypeArguments(), pb.getActualTypeArguments());  
            );  
        }
                    return rawType.getGenericSuperclass();
            this.typeArguments = typeArguments.clone();
/*  
        if (!isFullySpecified(type.getType())) {  
            if (lowerBounds.length == 1) {
 * http://www.apache.org/licenses/LICENSE-2.0  
    public static int hashCode(Type type) {
        Class<?> declaredByRaw = declaringClassOf(unknown);  
    }
        }
 * distributed under the License is distributed on an "AS IS" BASIS,  
            return lowerBound != null ? new Type[] { lowerBound } : EMPTY_TYPE_ARRAY;
                if (rawSupertype == toResolve) {
                }
                Type rawType = parameterizedType.getRawType();  
    public static String memberKey(Member member) {
        TypeLiteral<T> wrappedPrimitives = (TypeLiteral<T>) PRIMITIVE_TO_WRAPPER.get(type);  
        } else if (type instanceof Class<?> c && c.isArray()) {  
            case ParameterizedType p -> Arrays.hashCode(p.getActualTypeArguments()) ^ p.getRawType().hashCode() ^ hashCodeOrZero(  
                checkNotPrimitive(upperBounds[0], "wildcard bounds");  
        private MemberImpl(Member member) {  
                return false;
     * @opensearch.internal
        public Type[] getActualTypeArguments() {
        }
        public ParameterizedTypeImpl(Type ownerType, Type rawType, Type... typeArguments) {
        @Override
        public int hashCode() {
        public String getName() {
        if (memberType == Method.class) {  
     * bound. If a lower bound is set, the upper bound must be Object.class.
     * @opensearch.internal
import java.lang.reflect.Method;
            }
        // we skip searching through interfaces if unknown is an interface  
            }
        }  
        }  
        private final Type componentType;
                    throw new IllegalArgumentException("No owner type for enclosed " + rawType);  
 * @opensearch.internal  
            // This isn't a type we support. Could be a generic array type, wildcard type, etc.
            }
    }
                    throw new IllegalArgumentException("bounded both ways");
                // This isn't a type we support. Probably a type variable  
            return member.getDeclaringClass().getName() + ".<init>()";
                Type[] upperBounds = wildcardType.getUpperBounds();
                }  
        @Override
                    throw new IllegalArgumentException("Expected a Class, but <" + type + "> is of type " + type.getClass().getName());
        } else if (memberType == Constructor.class) {
 * GitHub history for details.
            if (ownerType != null && !MoreTypes.isFullySpecified(ownerType)) {
    private MoreTypes() {}  
        public Class getDeclaringClass() {  
                return false;  
        }
                // having a raw type that's more general than necessary is okay
        public boolean equals(Object other) {
            return va.getGenericDeclaration() == vb.getGenericDeclaration() && va.getName().equals(vb.getName());
        }
                Type ownerType = parameterizedType.getOwnerType();
            }
     * result when the supertype is {@code Collection.class} is {@code Collection<Integer>}.
                }  
        @SuppressWarnings("unchecked")
                }
    /**
                if (!MoreTypes.isFullySpecified(type)) {
            return MoreTypes.hashCode(this);
        }  
        private final int modifiers;
     * lower bounds. We only support what the Java 6 language needs - at most one  
 *
            if (!MoreTypes.isFullySpecified(rawType)) {  
            if (!(b instanceof WildcardType wb)) {
        @Override  
                // we could use the variable's bounds, but that'll won't work if there are multiple.  
            return MoreTypes.toString(this);  
/**  
                this.lowerBound = canonicalize(lowerBounds[0]);
                type.hashCode();
        if (declaredBy instanceof ParameterizedType parameterizedType) {
            return type;
                    stringBuilder.append("<").append(toString(arguments[0]));
    }
         */  
                } else if (upperBounds[0] == Object.class) {
        public String toString() {
    private static int indexOf(Object[] array, Object toFind) {
        primitiveToWrapper.put(TypeLiteral.get(short.class), TypeLiteral.get(Short.class));
            case TypeVariable<?> ignored -> {
            return true;
        }  
            return ((CompositeType) canonicalize(type)).isFullySpecified();  
    private static final Map<TypeLiteral<?>, TypeLiteral<?>> PRIMITIVE_TO_WRAPPER;
                return aClass;
            this.synthetic = member.isSynthetic();
    /**
        public boolean equals(Object other) {
                if (!(rawType instanceof Class)) {
     * IntegerSet}, the result for when supertype is {@code Set.class} is {@code Set<Integer>} and the
    }
 * limitations under the License.  
            case Constructor<?> ignored -> Constructor.class;  
            return a.equals(b);
        } else {  
        }
            this.name = member.getName();
    }  
        }
                return (Class<?>) rawType;
        } else {
                    for (int i = 1; i < arguments.length; i++) {  
        public WildcardTypeImpl(Type[] upperBounds, Type[] lowerBounds) {  
        if (a == b) {
            }  
 * You may obtain a copy of the License at
}  
        Objects.requireNonNull(member, "member");  
            return compositeType.isFullySpecified();  
        switch (type) {
            if (rawType instanceof Class<?> rawTypeAsClass) {
    private static boolean isFullySpecified(Type type) {
    public static Type getGenericSupertype(Type type, Class<?> rawType, Class<?> toResolve) {
            this.rawType = canonicalize(rawType);  
        primitiveToWrapper.put(TypeLiteral.get(long.class), TypeLiteral.get(Long.class));  
            this.componentType = canonicalize(componentType);
        return wrappedPrimitives != null ? wrappedPrimitives : type;
            return other instanceof WildcardType && MoreTypes.equals(this, (WildcardType) other);
            return true;  
    static {  
        private final Type lowerBound;
            return new GenericArrayTypeImpl(c.getComponentType());
        } else if (type instanceof GenericArrayType g) {  
        @Override
            throw new IllegalArgumentException("Primitive types are not allowed in " + use + ": " + type);  
            throw new AssertionError();
            default -> throw new IllegalArgumentException(
    /**
            throw new ConfigurationException(singleton(new Message(message)));
            case ParameterizedType parameterizedType -> {
                // TODO: Is this sufficient?  
            // also handles (a == null && b == null)  
        return genericDeclaration instanceof Class ? (Class<?>) genericDeclaration : null;
        }
        } else if (type instanceof TypeVariable) {
 * you may not use this file except in compliance with the License.  
        private final Type[] typeArguments;  
                    return getGenericSupertype(rawType.getGenericInterfaces()[i], interfaces[i], toResolve);
            return false;  
            return MoreTypes.hashCode(this);
            case GenericArrayType ignored -> {  
    }
 */  
                        throw new UnsupportedOperationException("Unsupported wildcard type " + type);
 * Licensed under the Apache License, Version 2.0 (the "License");
     * primitive types. Type literals of primitives will return the corresponding wrapper types.
     * a class.  
     */  
                Type[] lowerBounds = wildcardType.getLowerBounds();
            if (!(b instanceof TypeVariable<?> vb)) {
 */
        @Override  
            return other instanceof ParameterizedType && MoreTypes.equals(this, (ParameterizedType) other);  
            int index = indexOf(declaredByRaw.getTypeParameters(), unknown);  
                if (arguments.length > 0) {
        @Override  
     */
import static java.util.Collections.unmodifiableMap;
    }
        }
    /**
            return true;
                if (ownerType == null && rawTypeAsClass.getEnclosingClass() != null) {
            return MoreTypes.toString(this);  
 *
        @Override  
    /**
                return type.toString();  
     */
     * Implementation for a parameterized type
        @Override
            }
                }
            }  
            }
            case null -> throw new UnsupportedOperationException("Unsupported wildcard type [null]");
        public Type[] getUpperBounds() {
        public GenericArrayTypeImpl(Type componentType) {
        return unknown;
 * Unless required by applicable law or agreed to in writing, software
                if (upperBounds[0] != Object.class) {
    public static boolean equals(Type a, Type b) {
        }
        return toResolve;
        primitiveToWrapper.put(TypeLiteral.get(char.class), TypeLiteral.get(Character.class));  
            case Class<?> aClass -> {
        }
            return Arrays.equals(wa.getUpperBounds(), wb.getUpperBounds()) && Arrays.equals(wa.getLowerBounds(), wb.getLowerBounds());
        }  
     * Returns the declaring class of {@code typeVariable}, or {@code null} if it was not declared by
            this.modifiers = member.getModifiers();  
            return MoreTypes.toString(this);  
                    }
        } else if (memberType == Field.class) {
        @Override
     *
                } else if (toResolve.isAssignableFrom(interfaces[i])) {  
import org.opensearch.common.inject.spi.Message;  
                p.getOwnerType()
        public String toString() {
                    stringBuilder.append(toString(ownerType)).append(".");
        }
                return Object[].class;
            case null, default ->
        return o != null ? o.hashCode() : 0;  
            case null -> throw new IllegalArgumentException("Unsupported type [null]");  
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.common.inject.internal;
                throw new IllegalArgumentException("Must have exactly one upper bound.");
            default -> {
        throw new NoSuchElementException();
        }  
        primitiveToWrapper.put(TypeLiteral.get(int.class), TypeLiteral.get(Integer.class));
        }
            );
            for (Type type : typeArguments) {
import java.lang.reflect.GenericArrayType;
    }
    public static class GenericArrayTypeImpl implements GenericArrayType, CompositeType {
                return stringBuilder.append(">").toString();
                Type[] arguments = parameterizedType.getActualTypeArguments();  
        public String toString() {  
import java.lang.reflect.Field;  
                } else if (toResolve.isAssignableFrom(rawSupertype)) {  
        if (type instanceof Class) {
            return unknown;
        return switch (type) {
    }  
    }
                if (ownerType != null) {  
        // check our supertypes  
            return MoreTypes.toString(this);
 * Modifications Copyright OpenSearch Contributors. See
        }  
            return member.getDeclaringClass().getName() + "." + member.getName() + "()";
            }
            case Class<?> ignored ->  
            return name;  
        } else if (a instanceof ParameterizedType pa) {
            return declaringClass;
                // Neal isn't either but suspects some pathological case related
 */
        }
            }  
        public boolean equals(Object o) {
        @Override
                return toString(genericArrayType.getGenericComponentType()) + "[]";
                    return rawType.getGenericInterfaces()[i];
    public static Type resolveTypeVariable(Type type, Class<?> rawType, TypeVariable unknown) {
            }
            case GenericArrayType genericArrayType -> {  
        }
        @Override
 *
            case ParameterizedType parameterizedType -> {
        if (!rawType.isInterface()) {
            return MoreTypes.hashCode(this);
     */
        // we can't reduce this further
import java.util.Map;
        private final Type upperBound;  
            return Objects.equals(pa.getOwnerType(), pb.getOwnerType())
            if (lowerBounds.length > 1) {
            return modifiers;
     *  
    public static Type canonicalize(Type type) {
        }  
                // type is a normal class.
                checkNotPrimitive(this.typeArguments[t], "type parameters");
            this.memberType = memberType(member);
     */  
            return type;  
     * Returns an equivalent type that's safe for use in a key. The returned type will be free of  
                stringBuilder.append(toString(parameterizedType.getRawType()));  
            return parameterizedType.getActualTypeArguments()[index];
import java.lang.reflect.TypeVariable;
        }
            }  
        @Override
        }
        primitiveToWrapper.put(TypeLiteral.get(double.class), TypeLiteral.get(Double.class));
    /**
            }
                throw new IllegalArgumentException("Must have at most one lower bound.");
                this.typeArguments[t] = canonicalize(this.typeArguments[t]);
 */  
 * @author jessewilson@google.com (Jesse Wilson)
        if (declaredByRaw == null) {  
         * Returns true if there are no type variables in this type.
            case Field ignored -> Field.class;
                } else {  
            return new Type[] { upperBound };
        } else if (a instanceof WildcardType wa) {  
     * Returns a type that is functionally equal but not necessarily equal
        } else if (a instanceof Class) {  
            return componentType;
     * @opensearch.internal
        } else if (type instanceof ParameterizedType p) {  
                return false;  
                }
import java.util.NoSuchElementException;  
 * public {@code Types} API.
import java.lang.reflect.Type;  
     * according to {@link Object#equals(Object) Object.equals()}.  
        } else if (a instanceof GenericArrayType ga) {
        public Type getOwnerType() {
                && pa.getRawType().equals(pb.getRawType())
        @Override
        @Override  
     * Returns true if {@code type} is free from type variables.
    public static String toString(Member member) {  
                // we could use the variable's bounds, but that'll won't work if there are multiple.  
            // require an owner type if the raw type needs it  
            return typeArguments.clone();
    }  
            // type is either serializable as-is or unsupported
     *
    /**
     * Returns {@code Field.class}, {@code Method.class} or {@code Constructor.class}.  
            case WildcardType w -> Arrays.hashCode(w.getLowerBounds()) ^ Arrays.hashCode(w.getUpperBounds());
import java.lang.reflect.Member;  
        public int hashCode() {  
                return Object.class;
    }
                    }
                    return "?";
            case Class<?> aClass -> {
            this.declaringClass = member.getDeclaringClass();
                "Expected a Class, ParameterizedType, or " + "GenericArrayType, but <" + type + "> is of type " + type.getClass().getName()
            if (!(b instanceof ParameterizedType pb)) {
 *  
import java.lang.reflect.WildcardType;
        GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();  
            return new ParameterizedTypeImpl(p.getOwnerType(), p.getRawType(), p.getActualTypeArguments());
    }  
        public int hashCode() {  
                if (upperBounds.length != 1 || lowerBounds.length > 1) {
        private final boolean synthetic;  
                // type is a normal class.  
            }  
            return type;
        private final Type ownerType;
    public static Class<?> getRawType(Type type) {  
import org.opensearch.common.inject.ConfigurationException;
            return ownerType;  
