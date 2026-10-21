                Annotation[] paramAnnotations = annotationsIterator.next();
            } catch (NoSuchFieldException ignore) {}
    InjectionPoint(TypeLiteral<?> type, Field field) {
     *
                index++;
import java.util.Iterator;
    public static InjectionPoint forConstructorOf(TypeLiteral<?> type) {
        if (misplacedBindingAnnotation == null) {
                injectionPoints.add(factory.create(typeLiteral, member, errors));
    }
            public Method[] getMembers(Class<?> type) {
    /**
                }
     * for all required dependencies. Both explicit bindings (as specified in a module), and implicit
     *                                of the valid injection points.
                return new InjectionPoint(typeLiteral, member);
    }
     *
 * A constructor, field or method that can receive injections. Typically this is a member with the
    }
            // Disallow private constructors on non-private classes (unless they have @Inject)
        return result;
    }
     *                                of the valid injection points.
        } catch (NoSuchMethodException e) {
import java.lang.reflect.Member;
    public static Set<InjectionPoint> forInstanceMethodsAndFields(Class<?> type) {
 * http://www.apache.org/licenses/LICENSE-2.0
     *                                constructor, or if parameters of the injectable constructor are malformed, such as a
        Iterator<Annotation[]> annotationsIterator = Arrays.asList(parameterAnnotations).iterator();
 * this file be licensed under the Apache-2.0 license or a
    /**
    InjectionPoint(TypeLiteral<?> type, Method method) {
    // This method is necessary to create a Dependency<T> with proper generic type information
                    errors.merge(ignorable.getErrorMessages());
        for (M member : factory.getMembers(getRawType(typeLiteral.getType()))) {
        Errors errors
        Class<?> rawType = getRawType(type.getType());
    private <T> Dependency<T> newDependency(Key<T> key, boolean allowsNull, int parameterIndex) {
/*
     *         before subtype fields. Similarly, supertype methods are returned before subtype methods.
            public InjectionPoint create(TypeLiteral<?> typeLiteral, Method member, Errors errors) {
 */
    }
        this.member = constructor;
                Key<?> key = Annotations.getKey(parameterType, member, paramAnnotations, errors);
    public int hashCode() {
            return new InjectionPoint(type, noArgConstructor);
 * You may obtain a copy of the License at
        return forStaticMethodsAndFields(TypeLiteral.get(type));
            }
        }
        // don't warn about misplaced binding annotations on methods when there's a field with the same
        if (errors.hasErrors()) {
        return Collections.unmodifiableList(dependencies);
import org.opensearch.common.inject.Key;
    public List<Dependency<?>> getDependencies() {
        }
    }
     * points always have a single dependency for the field itself.
     * @throws ConfigurationException if there is no injectable constructor, more than one injectable
        Constructor<?> injectableConstructor = null;
            if (isStatic(member) != statics) {
import org.opensearch.common.inject.internal.ErrorsException;
        this.optional = inject.optional();
/**
import java.util.ArrayList;
     *                                of the valid injection points.
                }
        Errors errors = new Errors();
    public static Set<InjectionPoint> forStaticMethodsAndFields(Class<?> type) {
 * Copyright (C) 2008 Google Inc.
/*
        List<Dependency<?>> dependencies = new ArrayList<>();
     */
     *             or a no-arguments constructor that is not private.
     *                                a field with multiple binding annotations. The exception's {@link
package org.opensearch.common.inject.spi;
            if (inject != null) {
            try {
     * Returns all static method and field injection points on {@code type}.
            }
 * @author crazybob@google.com (Bob Lee)
     * @throws ConfigurationException if there is a malformed injection point on {@code type}, such as
     */
    }
        int index = 0;
        result = unmodifiableSet(result);
    private static boolean isStatic(Member member) {
import org.opensearch.common.inject.ConfigurationException;
                if (member.getDeclaringClass().getField(member.getName()) != null) {
 * Modifications Copyright OpenSearch Contributors. See
import java.util.Collection;
        return MoreTypes.toString(member);
        result = unmodifiableSet(result);
        for (Constructor<?> constructor : rawType.getConstructors()) {
        Key<?> key = null;
import org.opensearch.common.inject.Inject;
            try {
     *             or a no-arguments constructor that is not private.
                errors.missingConstructor(rawType);
import java.util.Set;
    InjectionPoint(TypeLiteral<?> type, Constructor<?> constructor) {
                return type.getFields();
            }
 * {@literal @}{@link Inject} annotation. For non-private, no argument constructors, the member may
     *
        InjectionPoint create(TypeLiteral<?> typeLiteral, M member, Errors errors);
        Collection<InjectionPoint> injectionPoints,
            if (inject == null) {
            }
 *
    private final boolean optional;
                return new InjectionPoint(typeLiteral, member);
     * @return a possibly empty set of injection points. The set has a specified iteration order. All
    public boolean equals(Object o) {
    ) {
            throw new ConfigurationException(errors.getMessages());
    public boolean isOptional() {
import static org.opensearch.common.inject.internal.MoreTypes.getRawType;
        M[] getMembers(Class<?> type);
        if (errors.hasErrors()) {
        return member.hashCode();
        // Add injectors for superclass first.
            }
                checkForMisplacedBindingAnnotations(member, errors);
public final class InjectionPoint {
            Inject inject = member.getAnnotation(Inject.class);
import org.opensearch.common.inject.TypeLiteral;
        errors.throwConfigurationExceptionIfErrorsExist();
        this.member = member;
     *
            errors.missingConstructor(rawType);
     *
        return forConstructorOf(TypeLiteral.get(type));
     *         fields are returned and then all methods. Within the fields, supertype fields are returned
     * Returns a new injection point for the injectable constructor of {@code type}.
        // name. In Scala, fields always get accessor methods (that we need to ignore). See bug 242.
                }
    /**
    }
     *
     * Returns all instance method and field injection points on {@code type}.
    public String toString() {
                if (injectableConstructor != null) {
    /**
     */
        }
     * @return a possibly-empty list
            return;
            @Override
     * Returns all instance method and field injection points on {@code type}.
        Factory<M> factory,
        };
    }
        // TODO (crazybob): Filter out overridden members.
import java.util.HashSet;
     */
            Inject inject = constructor.getAnnotation(Inject.class);
     *         fields are returned and then all methods. Within the fields, supertype fields are returned
 *
import java.lang.reflect.AnnotatedElement;
        Factory<Field> FIELDS = new Factory<Field>() {
        }
    private static <M extends Member & AnnotatedElement> void addInjectionPoints(
                if (!inject.optional()) {
 * The OpenSearch Contributors require contributions made to
        if (type.getType() == Object.class) {
        return new Dependency<>(this, key, allowsNull, parameterIndex);
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        errors.misplacedBindingAnnotation(member, misplacedBindingAnnotation);
     *                                parameter with multiple binding annotations.
import java.lang.annotation.Annotation;
        addInjectionPoints(type, Factory.FIELDS, true, result, errors);
        return Modifier.isStatic(member.getModifiers());
        this.dependencies = forMember(method, type, method.getParameterAnnotations());
    }
     *                                a field with multiple binding annotations. The exception's {@link
 * @since 2.0
    /**
        }
     * @throws ConfigurationException if there is no injectable constructor, more than one injectable
        Errors errors = new Errors(field);
        // If no annotated constructor is found, look for a no-arg constructor instead.
        boolean statics,
            checkForMisplacedBindingAnnotations(noArgConstructor, errors);
import java.util.Collections;
            return new InjectionPoint(type, injectableConstructor);
    private static void checkForMisplacedBindingAnnotations(Member member, Errors errors) {
    @Override
     * @return a possibly empty set of injection points. The set has a specified iteration order. All
     *                                of the valid injection points.
        addInjectorsForMembers(type, factory, statics, injectionPoints, errors);
     * @opensearch.internal
        Annotation[] annotations = field.getAnnotations();
 * distributed under the License is distributed on an "AS IS" BASIS,
        if (injectableConstructor != null) {
        // Add injectors for all members next
            errors,
     *                                a field with multiple binding annotations. The exception's {@link
        return o instanceof InjectionPoint && member.equals(((InjectionPoint) o).member);
     * @return a possibly empty set of injection points. The set has a specified iteration order. All
    public static Set<InjectionPoint> forStaticMethodsAndFields(TypeLiteral type) {
        this.member = field;
import java.util.List;
                    errors.tooManyConstructors(rawType);
        addInjectionPoints(type, Factory.METHODS, false, result, errors);
     *                                ConfigurationException#getPartialValue() partial value} is a {@code Set<InjectionPoint>}
 */
     * Returns the dependencies for this injection point. If the injection point is for a method or
    }
 *
                continue;
    }
     * Returns a new injection point for the injectable constructor of {@code type}.
            if (Modifier.isPrivate(noArgConstructor.getModifiers()) && !Modifier.isPrivate(rawType.getModifiers())) {
import static java.util.Collections.unmodifiableSet;
        Errors errors = new Errors(rawType);
    /**
import java.lang.reflect.Field;
     *                                ConfigurationException#getPartialValue() partial value} is a {@code Set<InjectionPoint>}
import org.opensearch.common.inject.internal.Annotations;
     *         fields are returned and then all methods. Within the fields, supertype fields are returned
     */
    private final Member member;
    @Override
        TypeLiteral<?> superType = type.getSupertype(type.getRawType().getSuperclass());
     */
     *         before subtype fields. Similarly, supertype methods are returned before subtype methods.
import java.lang.reflect.Method;
                    errors.optionalConstructor(constructor);
    /**
        };
     *
    private final List<Dependency<?>> dependencies;
     *
        this.optional = inject.optional();
        }
            @Override
 * Unless required by applicable law or agreed to in writing, software
    }
     *                                constructor, or if parameters of the injectable constructor are malformed, such as a
    /**
 * compatible open source license.
/*
     *                                parameter with multiple binding annotations.
        try {
        Set<InjectionPoint> result = new HashSet<>();
     *         fields are returned and then all methods. Within the fields, supertype fields are returned
     */
import org.opensearch.common.inject.internal.MoreTypes;
        this.dependencies = Collections.<Dependency<?>>singletonList(newDependency(key, Nullability.allowsNull(annotations), -1));
            return;
            key = Annotations.getKey(type.getFieldType(field), field, annotations, errors);
import java.util.Arrays;
    /**
        this.dependencies = forMember(constructor, type, constructor.getParameterAnnotations());
        addInjectionPoints(superType, factory, statics, injectionPoints, errors);
            public Field[] getMembers(Class<?> type) {
        return optional;
 * you may not use this file except in compliance with the License.
                checkForMisplacedBindingAnnotations(injectableConstructor, errors);
        errors.throwConfigurationExceptionIfErrorsExist();
        Annotation misplacedBindingAnnotation = Annotations.findBindingAnnotation(
        Collection<InjectionPoint> injectionPoints,
            }
        );
        for (TypeLiteral<?> parameterType : type.getParameterTypes(member)) {
    private static <M extends Member & AnnotatedElement> void addInjectorsForMembers(
    }
        }
    public static Set<InjectionPoint> forInstanceMethodsAndFields(TypeLiteral<?> type) {
     *                                a field with multiple binding annotations. The exception's {@link
            throw new ConfigurationException(errors.getMessages()).withPartialValue(result);
import org.opensearch.common.annotation.PublicApi;
    }
 * limitations under the License.
        addInjectionPoints(type, Factory.FIELDS, false, result, errors);
     */
    }
        Inject inject = method.getAnnotation(Inject.class);
            errors.merge(e.getErrors());
        this.optional = optional;
                if (inject.optional()) {
                throw new ConfigurationException(errors.getMessages());
 *
    public Member getMember() {
            Constructor<?> noArgConstructor = rawType.getConstructor();
            }
            } catch (ConfigurationException ignorable) {
        }
            member,
     * constructors etc.) may be used to satisfy optional injection points.
                continue;
        TypeLiteral<?> type,
    }
     * bindings ({@literal @}{@link org.opensearch.common.inject.ImplementedBy ImplementedBy}, default
     *                                ConfigurationException#getPartialValue() partial value} is a {@code Set<InjectionPoint>}
     */
    public static InjectionPoint forConstructorOf(Class<?> type) {
            }
import java.lang.reflect.Modifier;
        try {
 *
 * See the License for the specific language governing permissions and
     *         before subtype fields. Similarly, supertype methods are returned before subtype methods.
            try {
        return member;
        this.dependencies = dependencies;
        boolean statics,
    private List<Dependency<?>> forMember(Member member, TypeLiteral<?> type, Annotation[][] parameterAnnotations) {
     * Returns true if this injection point shall be skipped if the injector cannot resolve bindings
        if (member instanceof Method) {
                dependencies.add(newDependency(key, Nullability.allowsNull(paramAnnotations), index));
    }
                errors.merge(e.getErrors());
        Set<InjectionPoint> result = new HashSet<>();
        Factory<M> factory,
            public InjectionPoint create(TypeLiteral<?> typeLiteral, Field member, Errors errors) {
     * @param type a concrete type with exactly one constructor annotated {@literal @}{@link Inject},
import org.opensearch.common.inject.internal.Nullability;
     * @param type a concrete type with exactly one constructor annotated {@literal @}{@link Inject},
 * omit the annotation.
     *         before subtype fields. Similarly, supertype methods are returned before subtype methods.
                injectableConstructor = constructor;
    ) {
    /**
        TypeLiteral<?> typeLiteral,
import org.opensearch.common.inject.internal.Errors;
        Errors errors
        Inject inject = field.getAnnotation(Inject.class);
                    return;
 * @opensearch.api
        }
            @Override
 * Licensed under the Apache License, Version 2.0 (the "License");
     */
import java.lang.reflect.Constructor;
    }
 * GitHub history for details.
    private interface Factory<M extends Member & AnnotatedElement> {
     * Factory for the injection point
    @Override
     * Returns all static method and field injection points on {@code type}.
     * Returns the injected constructor, field, or method.
            } catch (ErrorsException e) {
        Errors errors = new Errors(member);
     *                                ConfigurationException#getPartialValue() partial value} is a {@code Set<InjectionPoint>}
        errors.throwConfigurationExceptionIfErrorsExist();
        addInjectionPoints(type, Factory.METHODS, true, result, errors);
 */
            ((AnnotatedElement) member).getAnnotations()
     * @throws ConfigurationException if there is a malformed injection point on {@code type}, such as
}
     * @return a possibly empty set of injection points. The set has a specified iteration order. All
        return forInstanceMethodsAndFields(TypeLiteral.get(type));
        }
        this.member = method;
            }
                return type.getMethods();
 * SPDX-License-Identifier: Apache-2.0
    }
        Errors errors = new Errors();
            @Override
@PublicApi(since = "1.0.0")
    }
    }
        Factory<Method> METHODS = new Factory<Method>() {
        } catch (ErrorsException e) {
        this.optional = false;
    private InjectionPoint(Member member, List<Dependency<?>> dependencies, boolean optional) {
            }
                }
            throw new ConfigurationException(errors.getMessages()).withPartialValue(result);
        return dependencies;
        return result;
     * @throws ConfigurationException if there is a malformed injection point on {@code type}, such as
 *
 */
     * constructor, the dependencies will correspond to that member's parameters. Field injection
     * @throws ConfigurationException if there is a malformed injection point on {@code type}, such as
        }
    }
