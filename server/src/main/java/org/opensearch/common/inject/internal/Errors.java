    public Errors recursiveBinding() {
            stringValue,
            case ConfigurationException configurationException -> configurationException.getErrorMessages();
    }
        sources.addAll(getSources());
    public void exposedButNotBound(Key<?> key) {
 * distributed under the License is distributed on an "AS IS" BASIS,
        if (!messages.isEmpty()) {
        final Class<T> type;
        throw toException();
/**
 * To avoid messages with redundant context, {@link #withSource} should be added sparingly. A
        return errorInUserCode(
        public String toString(Member member) {
     * We use a fairly generic error message here. The motivation is to share the
        return addMessage("%s has more than one annotation annotated with @BindingAnnotation: " + "%s and %s", member, a, b);
            a,
    private List<Message> errors; // lazy, use getErrorsForAdd()
        );
     * <pre><code>Guice.createInjector().getInstance(Runnable.class);</code></pre>
        Object source,
            case CreationException creationException -> creationException.getErrorMessages();
    public ErrorsException toException() {
            return merge(messages);
    }
        return addMessage("No scope is bound to %s.", scopeAnnotation);
    public Errors duplicateScopes(Scope existing, Class<? extends Annotation> annotationType, Scope scope) {
            return fmt.toString();
     */
     *     bind(Runnable.class);
    public Errors cannotInjectInnerClass(Class<?> type) {
            formatter.format("  while locating %s%n", convert(dependency.getKey()));
        }
    public Errors conversionTypeError(
        } else if (source instanceof InjectionPoint injectionPoint) {
        TypeLiteral<?> type,
        return switch (throwable) {
    }
        } else if (source instanceof Member member) {
                fmt.format("%s) %s%n", index++, errorMessage.getMessage());
        String message = format(messageFormat, arguments);
            stringValue,
        MatcherAndConverter b
        if (moreErrors.root == root || moreErrors.root.errors == null) {
        }
        }
    }
        this.parent = parent;
import org.opensearch.common.inject.CreationException;
        return addMessage("%s is annotated @Inject(optional=true), " + "but constructors cannot be optional.", constructor);
    public Errors merge(Errors moreErrors) {
 * @author jessewilson@google.com (Jesse Wilson)
        }
    }
        if (size() == expectedSize) {
        return String.format(Locale.ROOT, messageFormat, arguments);
        try (Formatter fmt = new Formatter(Locale.ROOT)) {
 * you may not use this file except in compliance with the License.
                fmt.format("1 error");
    }
        }
            InjectionPoint injectionPoint = dependency.getInjectionPoint();
        return addMessage("Cannot inject a TypeLiteral that has no type parameter");
        addMessage(new Message(getSources(), message, cause));
    public static Object convert(Object o) {
        boolean appliesTo(Object o) {
                }
        String parameterName = (parameterIndex != -1) ? "parameter " + parameterIndex + " of " : "";
        RuntimeException cause
            "%s is annotated with %s, but scope annotations are not supported " + "for abstract types.%n Bound at %s.",
        merge(moreErrors.root.errors);
    public Errors recursiveImplementationType() {
            cause,
        }
    }
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
            }
        return addMessage("A binding to %s already exists on a child injector.", key);
        return errorInUserCode(cause, "Error injecting method, %s", cause);
                    formatSource(fmt, source);
    private static final String CONSTRUCTOR_RULES = "Classes must have either one (and only one) constructor "
    /**
    private static final Collection<Converter<?>> converters = Arrays.asList(new Converter<Class>(Class.class) {
 *
            return value;
            for (Message errorMessage : errorMessages) {
    }
    }
        this.root = this;
import org.opensearch.common.inject.MembersInjector;
        MatcherAndConverter a,
import org.opensearch.common.inject.ProvisionException;
            if (messageCause == null) {
            convert(source),
            matchingConverter,
    private final Errors root;
        } else if (dependency != null) {
    public List<Object> getSources() {
 * GitHub history for details.
            case ProvisionException provisionException -> provisionException.getErrorMessages();
    ) {
    public Errors errorInUserInjector(MembersInjector<?> listener, TypeLiteral<?> type, RuntimeException cause) {
    public Errors addMessage(Message message) {
    public Errors bindingAlreadySet(Key<?> key, Object source) {
            convert(source),
        root.errors.add(message);
    /**
        return errorInUserCode(
import static java.util.Collections.unmodifiableList;
                return key.getTypeLiteral()
        return addMessage("%s doesn't provide instances of %s.", providerType, type);
     *   }
        }
    /**
        return addMessage("Provider methods must return a value. Do not return void.");
            }
            }
 * SPDX-License-Identifier: Apache-2.0
        if (root.errors == null) {
        @Override
/*
        return addMessage("Binding to Provider is not allowed.");
            return;
        Collection<Message> messages = getMessagesFromThrowable(cause);
     */
        CollectionUtil.timSort(result, new Comparator<Message>() {
    }
     */
                return key.getTypeLiteral().toString();
        }
            parameterName,
        );
        if (memberType == Field.class) {
    }
            return;
import java.util.Collections;
        TypeLiteral<?> type,
import java.util.Formatter;
            dependency.getInjectionPoint().getMember()
        this.root = parent.root;
            cause,
    public static void formatSource(Formatter formatter, Object source) {
    }
            return toString(type.cast(o));
        return addMessage(
 */
        public String toString(Class c) {
 * A collection of error messages. If this type is passed as a method parameter, the method is
                + " %s.%n"
        abstract String toString(T t);
        return unmodifiableList(result);
    public Errors errorInjectingConstructor(Throwable cause) {
        } else if (source instanceof Key<?> key) {
    /**
     * Otherwise we need to know who's calling when resolving a just-in-time
     */
import java.lang.reflect.Constructor;
 * identify that method. When calling a method that's defined in a different context, call that
    public void throwProvisionExceptionIfErrorsExist() {
        List<Object> sources = new ArrayList<>();
        return errorInUserCode(runtimeException, "Error in custom provider, %s", runtimeException);
        return addMessage(
     * Returns the formatted message for an exception with the specified messages.
    }
        return addMessage("Binding points to itself.");
            type,
    }
    public <T> T checkForNull(T value, Object source, Dependency<?> dependency) throws ErrorsException {
    }
    }
import java.lang.reflect.Type;
    }
    public Errors duplicateScopeAnnotations(Class<? extends Annotation> a, Class<? extends Annotation> b) {
    }
    public Errors merge(Collection<Message> messages) {
     * same message for both bind time errors:
        + "annotated with @Inject or a zero-argument constructor that is not private.";
        }
            Throwable messageCause = message.getCause();
    }
 * @opensearch.internal
    public Errors tooManyConstructors(Class<?> implementation) {
    }
 * <p>
        return errorInUserCode(cause, "Error injecting constructor, %s", cause);
            type
import java.util.Arrays;
    }
        return addMessage(
    }
        for (Message message : messages) {
                    Object source = dependencies.get(i);
 * this file be licensed under the Apache-2.0 license or a
        return source == SourceProvider.UNKNOWN_SOURCE ? this : new Errors(this, source);
    public Errors recursiveProviderType() {
    public Errors withSource(Object source) {
            bindingAnnotation
    }
        return root.errors != null;
        throw new ProvisionException(getMessages());
            this.type = type;
                if (displayCauses && cause != null) {
 * You may obtain a copy of the License at
        } else if (source instanceof Class<?> clazz) {
        throw new ConfigurationException(getMessages());
                    + " annotated with "
        return o;
     * zero or multiple messages with causes, null is returned.
        MatcherAndConverter matchingConverter,
import org.opensearch.common.inject.Scope;
            scopeAnnotation,
        this.parent = null;
    private abstract static class Converter<T> {
        return this;
    ) {
            matchingConverter
    /**
        return addMessage("Cannot inject a MembersInjector that has no type parameter");
    public Errors childBindingAlreadySet(Key<?> key) {
    public void throwCreationExceptionIfErrorsExist() {
     * an {@code ErrorsException} is thrown.
        return this;
        return addMessage("Please annotate with @Retention(RUNTIME).%n" + " Bound at %s.", convert(source));
                sources.add(0, e.source);
    public Errors missingImplementation(Key key) {
    public void throwIfNewErrors(int expectedSize) throws ErrorsException {
    public static String format(String messageFormat, Object... arguments) {
                formatSource(formatter, dependency.getKey());
            "Type mismatch converting '%s' (bound at %s) to %s%n" + " using %s.%n" + " Converter returned %s.",
 * Copyright (C) 2006 Google Inc.
    public Errors bindingToProvider() {
        );
        List<Object> sources = new ArrayList<>();
                fmt.format("%s errors", errorMessages.size());
    public Errors converterReturnedNull(String stringValue, Object source, TypeLiteral<?> type, MatcherAndConverter matchingConverter) {
        Converter(Class<T> type) {
    }
    public Errors cannotBindToGuiceType(String simpleName) {
    }
        for (Errors e = this; e != null; e = e.parent) {
    public Errors cannotInjectRawMembersInjector() {
            return MoreTypes.toString(member);
        }
    });
        this.source = source;
    public Errors errorNotifyingInjectionListener(InjectionListener<?> listener, TypeLiteral<?> type, RuntimeException cause) {
 * Modifications Copyright OpenSearch Contributors. See
        return errorInUserCode(cause, "Error notifying InjectionListener %s of %s.%n" + " Reason: %s", listener, type, cause);
import org.opensearch.common.inject.spi.Message;
            }
     * null unless (root == this) and error messages exist. Never an empty list.
        return addMessage("Binding to core guice framework type is not allowed: %s.", simpleName);
            if (converter.appliesTo(o)) {
            return this;
    }
     * }</code></pre>
    public List<Message> getMessages() {
    }
    private Errors addMessage(Throwable cause, String messageFormat, Object... arguments) {
            b
    public Errors ambiguousTypeConversion(
    public int size() {
                    cause.printStackTrace(new PrintWriter(writer));
        return addMessage(
        }
    public Errors missingConstructor(Class<?> implementation) {
            type,
    /**
    public Errors cannotInjectRawProvider() {
 * See the License for the specific language governing permissions and
 * Unless required by applicable law or agreed to in writing, software
        return addMessage("Scope %s is already bound to %s. Cannot bind %s.", existing, annotationType, scope);
        } else {
    }
    }
        return new Message(sources, message.getMessage(), message.getCause());
        );
 * Licensed under the Apache License, Version 2.0 (the "License");
    public Errors subtypeNotProvided(Class<? extends Provider<?>> providerType, Class<?> type) {
     * A converter
            }
        return addMessage(
                + " Please adjust your type converter configuration to avoid overlapping matches.",
 * considered to have executed successfully only if new errors were not added to this collection.
        }
                fmt.format("%n");
        );
/*
    }
            formatter.format("  at %s%n", source);
    }
            }
import org.opensearch.common.inject.spi.InjectionPoint;
                formatInjectionPoint(formatter, dependency, injectionPoint);
    }
     */
                    fmt.format("Caused by: %s", writer.getBuffer());
            formatter.format("  while locating %s%n", convert(dependency.getKey()));
     * binding, which makes things unnecessarily complex.
    public Errors cannotSatisfyCircularDependency(Class<?> expectedType) {
    }
            listener.getListener(),
     */
        if (value != null || dependency.isNullable()) {
        } else {
import java.lang.reflect.Field;
import static java.util.Collections.emptySet;
            formatter.format("  while locating %s%n", convert(key));
            cause
    public Errors cannotInjectRawTypeLiteral() {
        return sources;
            convert(source)
 * http://www.apache.org/licenses/LICENSE-2.0
        return errorInUserCode(cause, "Error injecting %s using %s.%n" + " Reason: %s", type, listener, cause);
            if (injectionPoint != null) {
    }
        return addMessage("No implementation for %s was bound.", key);
        );
        } else if (source instanceof TypeLiteral) {
            onlyCause = messageCause;
    }
     *
        sources.addAll(message.getSources());
     * Returns an instance that uses {@code source} as a reference point for newly added errors.
        Throwable onlyCause = null;
    }
            cause
    }
        return addMessage("Tried proxying %s to support a circular dependency, but it is not an interface.", expectedType);
     * The leaf source for errors added here.
            formatInjectionPoint(formatter, null, injectionPoint);
            formatter.format("  at %s%n", StackTraceElements.forMember(member));
import java.io.PrintWriter;
            "Error notifying TypeListener %s (bound at %s) of %s.%n" + " Reason: %s",
            if (key.getAnnotationType() != null) {
    }
     * @opensearch.internal
    }
        };
            source,
import org.opensearch.common.inject.Provider;
                for (int i = dependencies.size() - 1; i >= 0; i--) {
            return c.getName();
            arguments[i] = Errors.convert(arguments[i]);
        public String toString(Key key) {
    public Errors errorInjectingMethod(Throwable cause) {
    public boolean hasErrors() {
     */
    /**
        if (!hasErrors()) {
        }
    private final Errors parent;
        }
 * limitations under the License.
}
        addMessage("Could not expose() %s, it must be explicitly bound.", key);
 * Errors can be chained to provide additional context. To add context, call {@link #withSource}
     */
            return type.isAssignableFrom(o.getClass());
        return this;
    ) {
        return addMessage("Could not find a suitable constructor in %s. " + CONSTRUCTOR_RULES, implementation);
                continue;
    }
        return new ErrorsException(this);
            "Error converting '%s' (bound at %s) to %s%n" + " using %s.%n" + " Reason: %s",
        );
        String stringValue,
                    + (key.getAnnotation() != null ? key.getAnnotation() : key.getAnnotationType());
                return a.getSource().compareTo(b.getSource());
    }
            addMessage(merge(message));
        return addMessage("Please annotate with @ScopeAnnotation.");
import org.opensearch.common.inject.spi.TypeListenerBinding;
                + " %s and%n"
        }
        }
import java.lang.annotation.Annotation;
 * <p>
 * returned instance will contain full context.
        }
import org.opensearch.common.inject.spi.Dependency;
        }
     */
            if (errorMessages.size() == 1) {
        int parameterIndex = dependency.getParameterIndex();
    }
        return addMessage("@ProvidedBy points to the same class it annotates.");
import org.apache.lucene.util.CollectionUtil;
 *
        throw toException();
import java.io.StringWriter;
    public Errors notASubtype(Class<?> implementationType, Class<?> type) {
        } else {
            stringValue,
    }
    private final Object source;
            boolean displayCauses = getOnlyCause(errorMessages) == null;
 */
            } else {
    }
            }
    public Errors scopeAnnotationOnAbstractType(Class<? extends Annotation> scopeAnnotation, Class<?> type, Object source) {
    public Errors misplacedBindingAnnotation(Member member, Annotation bindingAnnotation) {
    public Errors voidProviderMethod() {
    public Errors(Object source) {
            "Received null converting '%s' (bound at %s) to %s%n" + " using %s.",
            "Multiple converters can convert '%s' (bound at %s) to %s:%n"
 */
import org.opensearch.common.inject.spi.InjectionListener;
    }
                return null;
        );
        return root.errors == null ? 0 : root.errors.size();
    public static String format(String heading, Collection<Message> errorMessages) {
            "Injecting into inner classes is not supported.  " + "Please use a 'static' class (top-level or nested) instead of %s.",
        return this;
        String stringValue,
    public Errors conversionError(
        this.parent = null;
 *
    }
    }
        Member member = injectionPoint.getMember();
                Throwable cause = errorMessage.getCause();
            dependency = injectionPoint.getDependencies().get(0);
        if (root.errors == null) {
            type,
    }
            converted
            } else {
            root.errors = new ArrayList<>();
            case null, default -> emptySet();
     * ...and at provide-time errors:
 * good rule of thumb is to assume a method's caller has already specified enough context to
    public Errors addMessage(String messageFormat, Object... arguments) {
            fmt.format(heading).format(":%n%n");
        }
        String stringValue,
        return addMessage("@ImplementedBy points to the same class it annotates.");
            public int compare(Message a, Message b) {
        return addMessage("More than one scope annotation was found: %s and %s.", a, b);
        if (!hasErrors()) {
        return addMessage("%s has more than one constructor annotated with @Inject. " + CONSTRUCTOR_RULES, implementation);
    }
            formatter.format("  while locating %s%n", source);
    public Errors missingScopeAnnotation() {
            formatter.format("    for field at %s%n", StackTraceElements.forMember(member));
    public Errors errorNotifyingTypeListener(TypeListenerBinding listener, TypeLiteral<?> type, Throwable cause) {
            type,
    }
        return addMessage(
    public Errors scopeNotFound(Class<? extends Annotation> scopeAnnotation) {
     * The root errors object. Used to access the list of error messages.
            }
    }
        );
    private Errors(Errors parent, Object source) {
            matchingConverter,
    }
/*
     * Returns {@code value} if it is non-null allowed to be null. Otherwise a message is added and
            stringValue,
        return onlyCause;
        List<Message> result = new ArrayList<>(root.errors);
                List<Object> dependencies = errorMessage.getSources();
            @Override
    }
    public void throwConfigurationExceptionIfErrorsExist() {
        if (!hasErrors()) {
    }
    }
    }, new Converter<Key>(Key.class) {
        return addMessage("Missing constant value. Please call to(...).");
    public Errors() {
    }
        Object source,
    public Errors errorInUserCode(Throwable cause, String messageFormat, Object... arguments) {
    public static void formatInjectionPoint(Formatter formatter, Dependency<?> dependency, InjectionPoint injectionPoint) {
    public static Throwable getOnlyCause(Collection<Message> messages) {
import java.util.Collection;
        this.source = source;
        }
import java.util.Comparator;
            formatter.format("    for parameter %s at %s%n", dependency.getParameterIndex(), StackTraceElements.forMember(member));
    }
 *
        return addMessage("A binding to %s was already configured at %s.", key, convert(source));
 *
        Class<? extends Member> memberType = MoreTypes.memberType(member);
     * Returns the cause throwable if there is exactly one cause in {@code messages}. If there are
     *   public void configure() {
        TypeLiteral<?> type,
            member,
        this.root = this;
public final class Errors {
import java.lang.reflect.Member;
import java.util.Locale;
            if (onlyCause != null) {
                return converter.convert(o);
    /**
        throw new CreationException(getMessages());
        });
    /**
    }
    }
            if (e.source != SourceProvider.UNKNOWN_SOURCE) {
            } else {
    public static Collection<Message> getMessagesFromThrowable(Throwable throwable) {
            type,
import java.util.ArrayList;
        MatcherAndConverter matchingConverter,
            convert(listener.getSource()),
    }
        addMessage(
        }
            int index = 1;
 * to create a new Errors instance that contains additional context. All messages added to the
    }
    }
        @Override
        if (source instanceof Dependency<?> dependency) {
        return addMessage(null, messageFormat, arguments);
    private Message merge(Message message) {
    }
import org.opensearch.common.inject.TypeLiteral;
        }
    }
    }, new Converter<Member>(Member.class) {
    public Errors duplicateBindingAnnotations(Member member, Class<? extends Annotation> a, Class<? extends Annotation> b) {
            return addMessage(cause, messageFormat, arguments);
package org.opensearch.common.inject.internal;
        for (Message message : messages) {
import org.opensearch.common.inject.ConfigurationException;
     * The parent errors object. Used to obtain the chain of source objects.
    /**
import java.util.List;
 *
    }
import org.opensearch.common.inject.Key;
 * compatible open source license.
     */
            convert(source),
            convert(source),
    }
            }
            "null returned by binding at %s%n but %s%s is not @Nullable",
            "%s is annotated with %s, but binding annotations should be applied " + "to its parameters instead.",
    }
            formatter.format("  at %s%n", StackTraceElements.forType(clazz));
            type,
 * method with an errors object that includes its context.
        @Override
            return Collections.emptyList();
    public Errors errorInProvider(RuntimeException runtimeException) {
        Object source,
    }
            return;
    public Errors missingConstantValues() {
        return addMessage("Cannot inject a TypeLiteral of %s", unsupportedType);
        Object converted
            formatSource(formatter, injectionPoint.getMember());
        return addMessage("%s doesn't extend %s.", implementationType, type);
                }
            return;
 */
     * <pre><code>Guice.createInjector(new AbstractModule() {
        for (Converter<?> converter : converters) {
    public Errors missingRuntimeRetention(Object source) {
        return addMessage("Cannot inject a Provider that has no type parameter");
    public Errors cannotInjectTypeLiteralOf(Type unsupportedType) {
        String convert(Object o) {
 * The OpenSearch Contributors require contributions made to
    public Errors optionalConstructor(Constructor constructor) {
                    StringWriter writer = new StringWriter();
    }
        this.source = SourceProvider.UNKNOWN_SOURCE;
        }
        for (int i = 0; i < arguments.length; i++) {
