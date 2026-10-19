     *                                a field with multiple binding annotations. The exception's {@link  
     *                                of the valid injection points.
    public boolean equals(Object o) {
        return member.hashCode();
        Inject inject = method.getAnnotation(Inject.class);  
        Annotation[] annotations = field.getAnnotations();  
     * @throws ConfigurationException if there is a malformed injection point on {@code type}, such as
        Key<?> key = null;  
        boolean statics,  
    private static void checkForMisplacedBindingAnnotations(Member member, Errors errors) {
        }  
        try {
                checkForMisplacedBindingAnnotations(member, errors);
import java.util.ArrayList;
import org.opensearch.common.inject.TypeLiteral;
     */
        errors.throwConfigurationExceptionIfErrorsExist();
        };
                continue;  
            throw new ConfigurationException(errors.getMessages()).withPartialValue(result);
                    return;
import java.util.Collection;  
            Inject inject = member.getAnnotation(Inject.class);
    InjectionPoint(TypeLiteral<?> type, Method method) {  
        addInjectionPoints(type, Factory.FIELDS, true, result, errors);
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        Errors errors = new Errors();
        if (type.getType() == Object.class) {
            return;
                Annotation[] paramAnnotations = annotationsIterator.next();
    public static InjectionPoint forConstructorOf(Class<?> type) {  
 * SPDX-License-Identifier: Apache-2.0
            }  
     *             or a no-arguments constructor that is not private.
            } catch (ErrorsException e) {  
            public Method[] getMembers(Class<?> type) {
 * The OpenSearch Contributors require contributions made to  
                errors.missingConstructor(rawType);  
        Factory<M> factory,
            public InjectionPoint create(TypeLiteral<?> typeLiteral, Field member, Errors errors) {  
import java.lang.reflect.Modifier;  
import static org.opensearch.common.inject.internal.MoreTypes.getRawType;
 * Modifications Copyright OpenSearch Contributors. See
    ) {
        Class<?> rawType = getRawType(type.getType());
 * {@literal @}{@link Inject} annotation. For non-private, no argument constructors, the member may  
        return forStaticMethodsAndFields(TypeLiteral.get(type));
                dependencies.add(newDependency(key, Nullability.allowsNull(paramAnnotations), index));
    private interface Factory<M extends Member & AnnotatedElement> {
    }
                }
        }
    public boolean isOptional() {
        result = unmodifiableSet(result);  
     *         fields are returned and then all methods. Within the fields, supertype fields are returned
    }
        this.member = member;
    private final Member member;  
import org.opensearch.common.inject.internal.MoreTypes;  
            key = Annotations.getKey(type.getFieldType(field), field, annotations, errors);
        Errors errors
                Key<?> key = Annotations.getKey(parameterType, member, paramAnnotations, errors);  
    }  
        Set<InjectionPoint> result = new HashSet<>();
        Annotation misplacedBindingAnnotation = Annotations.findBindingAnnotation(
                    errors.optionalConstructor(constructor);  
 * distributed under the License is distributed on an "AS IS" BASIS,  
        }  
        if (member instanceof Method) {
import java.lang.reflect.AnnotatedElement;
@PublicApi(since = "1.0.0")
    @Override
        this.optional = optional;  
        this.member = constructor;
        addInjectionPoints(type, Factory.METHODS, false, result, errors);
 *
        this.dependencies = forMember(constructor, type, constructor.getParameterAnnotations());  
        return result;
    private InjectionPoint(Member member, List<Dependency<?>> dependencies, boolean optional) {  
        this.dependencies = Collections.<Dependency<?>>singletonList(newDependency(key, Nullability.allowsNull(annotations), -1));
    public static Set<InjectionPoint> forStaticMethodsAndFields(TypeLiteral type) {  
            if (inject == null) {
        }  
        int index = 0;
    }
        return new Dependency<>(this, key, allowsNull, parameterIndex);
     *         fields are returned and then all methods. Within the fields, supertype fields are returned  
     *                                parameter with multiple binding annotations.
        Errors errors = new Errors(member);  
        Inject inject = field.getAnnotation(Inject.class);  
     * Returns the injected constructor, field, or method.  
import org.opensearch.common.inject.internal.Nullability;
     * @throws ConfigurationException if there is no injectable constructor, more than one injectable
     */
            }
    }
    // This method is necessary to create a Dependency<T> with proper generic type information  
import org.opensearch.common.inject.internal.ErrorsException;
            }
        this.optional = inject.optional();
        }
        TypeLiteral<?> typeLiteral,
        errors.misplacedBindingAnnotation(member, misplacedBindingAnnotation);  
    }
 * @author crazybob@google.com (Bob Lee)  
     *                                of the valid injection points.
    }  
 * omit the annotation.
        this.member = field;
                continue;
        errors.throwConfigurationExceptionIfErrorsExist();  
 * Unless required by applicable law or agreed to in writing, software
            Constructor<?> noArgConstructor = rawType.getConstructor();
                }
                    errors.merge(ignorable.getErrorMessages());
    /**
            try {
                }
    public static Set<InjectionPoint> forInstanceMethodsAndFields(TypeLiteral<?> type) {
import static java.util.Collections.unmodifiableSet;
    /**  
import org.opensearch.common.annotation.PublicApi;
            if (Modifier.isPrivate(noArgConstructor.getModifiers()) && !Modifier.isPrivate(rawType.getModifiers())) {
        Factory<Method> METHODS = new Factory<Method>() {
     * Returns all static method and field injection points on {@code type}.
package org.opensearch.common.inject.spi;
     *         before subtype fields. Similarly, supertype methods are returned before subtype methods.
     *                                parameter with multiple binding annotations.
                throw new ConfigurationException(errors.getMessages());
    /**
        Errors errors = new Errors(field);
     *
            }
    private final boolean optional;
    }
     *         before subtype fields. Similarly, supertype methods are returned before subtype methods.  
        }
        }  
    public List<Dependency<?>> getDependencies() {
     */  
     *                                of the valid injection points.
 * GitHub history for details.
    }
 * A constructor, field or method that can receive injections. Typically this is a member with the
    }  
    /**
        // Add injectors for all members next  
    }  
        }  
import java.lang.reflect.Member;
    private <T> Dependency<T> newDependency(Key<T> key, boolean allowsNull, int parameterIndex) {
        return result;
                return type.getMethods();
    }  
     * constructor, the dependencies will correspond to that member's parameters. Field injection
            throw new ConfigurationException(errors.getMessages());
     * Returns a new injection point for the injectable constructor of {@code type}.
        addInjectionPoints(type, Factory.FIELDS, false, result, errors);  
 */  
    }  
 * You may obtain a copy of the License at
     *                                of the valid injection points.
        this.dependencies = forMember(method, type, method.getParameterAnnotations());  
import org.opensearch.common.inject.ConfigurationException;
     * @throws ConfigurationException if there is no injectable constructor, more than one injectable
            return;
        } catch (ErrorsException e) {  
    }
    private final List<Dependency<?>> dependencies;
        }
        this.optional = false;
import java.lang.reflect.Field;  
        // name. In Scala, fields always get accessor methods (that we need to ignore). See bug 242.  
        } catch (NoSuchMethodException e) {  
            errors.missingConstructor(rawType);
            public InjectionPoint create(TypeLiteral<?> typeLiteral, Method member, Errors errors) {  
        errors.throwConfigurationExceptionIfErrorsExist();  
                }
            }
 * this file be licensed under the Apache-2.0 license or a
            checkForMisplacedBindingAnnotations(noArgConstructor, errors);
 * @since 2.0
 * See the License for the specific language governing permissions and
import org.opensearch.common.inject.Key;
        return forInstanceMethodsAndFields(TypeLiteral.get(type));
     * @return a possibly empty set of injection points. The set has a specified iteration order. All
        );  
                checkForMisplacedBindingAnnotations(injectableConstructor, errors);
            try {  
        return forConstructorOf(TypeLiteral.get(type));
     *  
                injectableConstructor = constructor;
            if (isStatic(member) != statics) {  
 */  
        TypeLiteral<?> type,
import org.opensearch.common.inject.Inject;  
     */
     *                                ConfigurationException#getPartialValue() partial value} is a {@code Set<InjectionPoint>}  
                return new InjectionPoint(typeLiteral, member);
     *
    }
                if (inject.optional()) {
}
        return optional;  
        addInjectorsForMembers(type, factory, statics, injectionPoints, errors);
            Inject inject = constructor.getAnnotation(Inject.class);  
import java.lang.annotation.Annotation;  
     * Factory for the injection point  
        TypeLiteral<?> superType = type.getSupertype(type.getRawType().getSuperclass());  
 * http://www.apache.org/licenses/LICENSE-2.0  
import java.util.HashSet;
        // don't warn about misplaced binding annotations on methods when there's a field with the same
        Set<InjectionPoint> result = new HashSet<>();
 *
public final class InjectionPoint {  
                errors.merge(e.getErrors());
        this.member = method;
     * @throws ConfigurationException if there is a malformed injection point on {@code type}, such as
/*  
            @Override  
     */
        return dependencies;
    /**
        // If no annotated constructor is found, look for a no-arg constructor instead.  
    }
 * Copyright (C) 2008 Google Inc.  
    /**  
                return new InjectionPoint(typeLiteral, member);
            }  
            @Override
     *                                constructor, or if parameters of the injectable constructor are malformed, such as a  
     */
     * Returns all instance method and field injection points on {@code type}.
     */
import org.opensearch.common.inject.internal.Errors;
    }
        };  
     *         fields are returned and then all methods. Within the fields, supertype fields are returned  
                if (member.getDeclaringClass().getField(member.getName()) != null) {  
     * Returns a new injection point for the injectable constructor of {@code type}.
    @Override  
        List<Dependency<?>> dependencies = new ArrayList<>();  
        InjectionPoint create(TypeLiteral<?> typeLiteral, M member, Errors errors);
import java.util.List;
import java.util.Collections;
import org.opensearch.common.inject.internal.Annotations;  
        Collection<InjectionPoint> injectionPoints,
        this.dependencies = dependencies;
     * Returns the dependencies for this injection point. If the injection point is for a method or
        Errors errors = new Errors(rawType);
    /**
    private static <M extends Member & AnnotatedElement> void addInjectionPoints(  
            @Override
        Errors errors  
        return member;  
     *                                constructor, or if parameters of the injectable constructor are malformed, such as a  
     *                                ConfigurationException#getPartialValue() partial value} is a {@code Set<InjectionPoint>}
     *
    InjectionPoint(TypeLiteral<?> type, Constructor<?> constructor) {  
        return Collections.unmodifiableList(dependencies);  
            errors.merge(e.getErrors());
        if (injectableConstructor != null) {
     * for all required dependencies. Both explicit bindings (as specified in a module), and implicit
     *
            return new InjectionPoint(type, noArgConstructor);
            ((AnnotatedElement) member).getAnnotations()
                    errors.tooManyConstructors(rawType);
     * @return a possibly empty set of injection points. The set has a specified iteration order. All
    }
            errors,  
            }
        for (TypeLiteral<?> parameterType : type.getParameterTypes(member)) {  
        addInjectionPoints(superType, factory, statics, injectionPoints, errors);
    public static Set<InjectionPoint> forInstanceMethodsAndFields(Class<?> type) {  
        return o instanceof InjectionPoint && member.equals(((InjectionPoint) o).member);
 *
    }
 *
 */
import java.lang.reflect.Constructor;
        M[] getMembers(Class<?> type);  
     *                                a field with multiple binding annotations. The exception's {@link
     *         fields are returned and then all methods. Within the fields, supertype fields are returned
    InjectionPoint(TypeLiteral<?> type, Field field) {  
     *                                ConfigurationException#getPartialValue() partial value} is a {@code Set<InjectionPoint>}  
        if (errors.hasErrors()) {
        Constructor<?> injectableConstructor = null;
    }
/*
        return MoreTypes.toString(member);  
     * points always have a single dependency for the field itself.  
 * Licensed under the Apache License, Version 2.0 (the "License");
    ) {  
            } catch (NoSuchFieldException ignore) {}  
     *         before subtype fields. Similarly, supertype methods are returned before subtype methods.  
    private List<Dependency<?>> forMember(Member member, TypeLiteral<?> type, Annotation[][] parameterAnnotations) {
     *                                a field with multiple binding annotations. The exception's {@link  
     * Returns true if this injection point shall be skipped if the injector cannot resolve bindings  
        Factory<M> factory,  
    /**
     *  
                if (injectableConstructor != null) {  
            public Field[] getMembers(Class<?> type) {
            @Override  
     *             or a no-arguments constructor that is not private.
            member,
import java.lang.reflect.Method;
    public static Set<InjectionPoint> forStaticMethodsAndFields(Class<?> type) {
            try {
                return type.getFields();
            }  
        Collection<InjectionPoint> injectionPoints,
     *                                a field with multiple binding annotations. The exception's {@link
/**
                if (!inject.optional()) {  
     *
     * constructors etc.) may be used to satisfy optional injection points.  
        Errors errors = new Errors();  
     *         before subtype fields. Similarly, supertype methods are returned before subtype methods.
        // Add injectors for superclass first.
        Iterator<Annotation[]> annotationsIterator = Arrays.asList(parameterAnnotations).iterator();
     */  
        this.optional = inject.optional();
            }  
                index++;
     * Returns all static method and field injection points on {@code type}.  
     */  
    }
     * @param type a concrete type with exactly one constructor annotated {@literal @}{@link Inject},  
        boolean statics,
     * @throws ConfigurationException if there is a malformed injection point on {@code type}, such as
    private static boolean isStatic(Member member) {
    public Member getMember() {
            throw new ConfigurationException(errors.getMessages()).withPartialValue(result);  
            if (inject != null) {
 * limitations under the License.  
    private static <M extends Member & AnnotatedElement> void addInjectorsForMembers(
        for (Constructor<?> constructor : rawType.getConstructors()) {
    }  
     *                                ConfigurationException#getPartialValue() partial value} is a {@code Set<InjectionPoint>}
                injectionPoints.add(factory.create(typeLiteral, member, errors));
     * @return a possibly-empty list
            } catch (ConfigurationException ignorable) {
    public int hashCode() {  
 *
     * @param type a concrete type with exactly one constructor annotated {@literal @}{@link Inject},  
            // Disallow private constructors on non-private classes (unless they have @Inject)
import java.util.Iterator;  
     * @return a possibly empty set of injection points. The set has a specified iteration order. All
/*  
     */  
    /**
 * you may not use this file except in compliance with the License.  
     *
    public String toString() {
        if (misplacedBindingAnnotation == null) {
        return Modifier.isStatic(member.getModifiers());
        addInjectionPoints(type, Factory.METHODS, true, result, errors);
    public static InjectionPoint forConstructorOf(TypeLiteral<?> type) {  
        if (errors.hasErrors()) {
        for (M member : factory.getMembers(getRawType(typeLiteral.getType()))) {
        }
 */
     * @throws ConfigurationException if there is a malformed injection point on {@code type}, such as
 * @opensearch.api  
    /**  
    }  
        try {
        }
        result = unmodifiableSet(result);
 *
     * @opensearch.internal
import java.util.Set;
            return new InjectionPoint(type, injectableConstructor);  
 * compatible open source license.
            }  
     * bindings ({@literal @}{@link org.opensearch.common.inject.ImplementedBy ImplementedBy}, default
    @Override
        Factory<Field> FIELDS = new Factory<Field>() {
import java.util.Arrays;
     * Returns all instance method and field injection points on {@code type}.  
        // TODO (crazybob): Filter out overridden members.
     * @return a possibly empty set of injection points. The set has a specified iteration order. All
