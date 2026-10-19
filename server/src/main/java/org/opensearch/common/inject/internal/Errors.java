    public void throwConfigurationExceptionIfErrorsExist() {
            "Type mismatch converting '%s' (bound at %s) to %s%n" + " using %s.%n" + " Converter returned %s.",
    /**
            convert(listener.getSource()),  
        @Override  
    public Errors scopeNotFound(Class<? extends Annotation> scopeAnnotation) {
    public Errors cannotInjectRawMembersInjector() {
        return root.errors != null;  
 *
    private final Object source;
package org.opensearch.common.inject.internal;
        MatcherAndConverter b
    public Errors misplacedBindingAnnotation(Member member, Annotation bindingAnnotation) {
                    + " annotated with "  
        }  
    }  
        Object source,
    }
        }
     */
        RuntimeException cause
    public Errors bindingAlreadySet(Key<?> key, Object source) {
     *   public void configure() {
            "Received null converting '%s' (bound at %s) to %s%n" + " using %s.",
        return source == SourceProvider.UNKNOWN_SOURCE ? this : new Errors(this, source);  
    }  
 * @opensearch.internal
     * <pre><code>Guice.createInjector().getInstance(Runnable.class);</code></pre>  
 * returned instance will contain full context.
        }
                return key.getTypeLiteral().toString();  
        return addMessage(  
            "null returned by binding at %s%n but %s%s is not @Nullable",
        return addMessage(null, messageFormat, arguments);
        return switch (throwable) {  
    public void throwProvisionExceptionIfErrorsExist() {  
import org.opensearch.common.inject.CreationException;  
            fmt.format(heading).format(":%n%n");
        return addMessage("A binding to %s already exists on a child injector.", key);  
            Throwable messageCause = message.getCause();
            stringValue,
    }
            boolean displayCauses = getOnlyCause(errorMessages) == null;  
 * See the License for the specific language governing permissions and
            } else {
     *   }  
        }
        sources.addAll(message.getSources());
    }
import static java.util.Collections.unmodifiableList;  
    }  
        }
    }  
            }  
        return addMessage("More than one scope annotation was found: %s and %s.", a, b);  
            } else {
            cause,  
    public Errors voidProviderMethod() {
     *
    public Errors scopeAnnotationOnAbstractType(Class<? extends Annotation> scopeAnnotation, Class<?> type, Object source) {
    public void exposedButNotBound(Key<?> key) {
    }
    }  
    public Errors recursiveProviderType() {
            type,
 * <p>  
import org.opensearch.common.inject.ConfigurationException;
    public Errors cannotInjectInnerClass(Class<?> type) {  
            matchingConverter
            dependency.getInjectionPoint().getMember()
            addMessage(merge(message));
 * compatible open source license.
            formatter.format("  while locating %s%n", source);  
        return addMessage("A binding to %s was already configured at %s.", key, convert(source));
    public Errors errorInUserInjector(MembersInjector<?> listener, TypeLiteral<?> type, RuntimeException cause) {
 * Copyright (C) 2006 Google Inc.  
    public int size() {
     *     bind(Runnable.class);
    public Errors recursiveImplementationType() {
            root.errors = new ArrayList<>();  
        }  
import java.util.Collection;
                fmt.format("%s errors", errorMessages.size());  
    ) {
 * limitations under the License.  
        String parameterName = (parameterIndex != -1) ? "parameter " + parameterIndex + " of " : "";
                return null;
 *
        } else if (source instanceof TypeLiteral) {
        } else {
    public boolean hasErrors() {
            a,
    }
        return this;
                    + (key.getAnnotation() != null ? key.getAnnotation() : key.getAnnotationType());
        return addMessage("%s doesn't extend %s.", implementationType, type);
 * To avoid messages with redundant context, {@link #withSource} should be added sparingly. A
    public Errors conversionError(
            stringValue,  
    public Errors() {
        this.parent = null;
            formatter.format("  at %s%n", source);  
    /**  
    public static String format(String heading, Collection<Message> errorMessages) {
     */
        );
 * good rule of thumb is to assume a method's caller has already specified enough context to
    public List<Message> getMessages() {
    }
            return addMessage(cause, messageFormat, arguments);
                }  
        return addMessage("Cannot inject a Provider that has no type parameter");
    }
            formatSource(formatter, injectionPoint.getMember());  
import java.lang.annotation.Annotation;  
            case ConfigurationException configurationException -> configurationException.getErrorMessages();
            formatter.format("  at %s%n", StackTraceElements.forType(clazz));  
            return type.isAssignableFrom(o.getClass());
    }  
        sources.addAll(getSources());
        );
            listener.getListener(),
        return addMessage("Please annotate with @Retention(RUNTIME).%n" + " Bound at %s.", convert(source));
 *
        addMessage(  
        return addMessage("Provider methods must return a value. Do not return void.");
    public Errors errorNotifyingInjectionListener(InjectionListener<?> listener, TypeLiteral<?> type, RuntimeException cause) {  
    }
    }  
        if (source instanceof Dependency<?> dependency) {  
            formatInjectionPoint(formatter, null, injectionPoint);  
        );
        public String toString(Member member) {
    public Errors converterReturnedNull(String stringValue, Object source, TypeLiteral<?> type, MatcherAndConverter matchingConverter) {
import java.lang.reflect.Constructor;
    }
     * <pre><code>Guice.createInjector(new AbstractModule() {  
        }
        }
        return errorInUserCode(
        } else if (dependency != null) {
import java.util.List;
    public Errors(Object source) {
    }
        }
            type,
     * Otherwise we need to know who's calling when resolving a just-in-time
        return this;
 *
            if (e.source != SourceProvider.UNKNOWN_SOURCE) {
        });  
    }  
    public Errors addMessage(Message message) {
     * zero or multiple messages with causes, null is returned.  
            matchingConverter,  
                    formatSource(fmt, source);
    }
    public Errors cannotInjectRawProvider() {  
        }
    }  
            cause
    }
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    public <T> T checkForNull(T value, Object source, Dependency<?> dependency) throws ErrorsException {
        MatcherAndConverter matchingConverter,
    /**
            case null, default -> emptySet();
    }
        Converter(Class<T> type) {  
    /**  
import java.util.Arrays;  
                for (int i = dependencies.size() - 1; i >= 0; i--) {  
            type,
    }  
        return addMessage("No scope is bound to %s.", scopeAnnotation);
    }, new Converter<Key>(Key.class) {
 * method with an errors object that includes its context.
        );  
        return addMessage("Scope %s is already bound to %s. Cannot bind %s.", existing, annotationType, scope);
    }
            "%s is annotated with %s, but binding annotations should be applied " + "to its parameters instead.",
    public Errors conversionTypeError(  
import static java.util.Collections.emptySet;
            formatter.format("    for field at %s%n", StackTraceElements.forMember(member));
import org.opensearch.common.inject.Key;
        if (!hasErrors()) {
            for (Message errorMessage : errorMessages) {
            }  
     */
            if (messageCause == null) {  
    ) {
import java.lang.reflect.Type;
        return addMessage(  
        return addMessage("Cannot inject a TypeLiteral of %s", unsupportedType);  
/*
        String stringValue,  
        return String.format(Locale.ROOT, messageFormat, arguments);
    private Errors(Errors parent, Object source) {
import org.opensearch.common.inject.Provider;  
 */
    public static void formatSource(Formatter formatter, Object source) {
        merge(moreErrors.root.errors);  
        if (!hasErrors()) {
        } else if (source instanceof Member member) {
        List<Message> result = new ArrayList<>(root.errors);  
import org.opensearch.common.inject.MembersInjector;
            } else {
            "Injecting into inner classes is not supported.  " + "Please use a 'static' class (top-level or nested) instead of %s.",
    public Errors errorInUserCode(Throwable cause, String messageFormat, Object... arguments) {
        try (Formatter fmt = new Formatter(Locale.ROOT)) {  
import java.util.Formatter;
            type,
            type,
        return addMessage("%s is annotated @Inject(optional=true), " + "but constructors cannot be optional.", constructor);  
    public Errors childBindingAlreadySet(Key<?> key) {
 * <p>
import java.lang.reflect.Field;
import org.opensearch.common.inject.ProvisionException;
     * ...and at provide-time errors:
            }
        return addMessage("@ProvidedBy points to the same class it annotates.");  
        return errorInUserCode(cause, "Error injecting method, %s", cause);
        return new ErrorsException(this);
     * Returns {@code value} if it is non-null allowed to be null. Otherwise a message is added and
    }
            type  
            "Error notifying TypeListener %s (bound at %s) of %s.%n" + " Reason: %s",
            return;
    public Errors withSource(Object source) {
 * this file be licensed under the Apache-2.0 license or a
        if (root.errors == null) {
 * Errors can be chained to provide additional context. To add context, call {@link #withSource}  
     */  
        }
            InjectionPoint injectionPoint = dependency.getInjectionPoint();
    }
        this.source = SourceProvider.UNKNOWN_SOURCE;
        MatcherAndConverter matchingConverter,  
        };
                return key.getTypeLiteral()
        return root.errors == null ? 0 : root.errors.size();  
    }
        if (moreErrors.root == root || moreErrors.root.errors == null) {
 * Unless required by applicable law or agreed to in writing, software
        );  
        if (root.errors == null) {
        } else if (source instanceof Class<?> clazz) {
    }
                + " %s and%n"
import java.io.StringWriter;
        }
        return addMessage("Missing constant value. Please call to(...).");  
    }
        return addMessage("%s has more than one constructor annotated with @Inject. " + CONSTRUCTOR_RULES, implementation);  
                Throwable cause = errorMessage.getCause();
     * binding, which makes things unnecessarily complex.
    }  
import org.opensearch.common.inject.spi.InjectionListener;
import org.opensearch.common.inject.spi.Dependency;
        return onlyCause;
        addMessage(new Message(getSources(), message, cause));  
     * @opensearch.internal  
     * A converter
        this.parent = parent;
        throw new CreationException(getMessages());
     * Returns the cause throwable if there is exactly one cause in {@code messages}. If there are
    }  
    public Errors ambiguousTypeConversion(
        String convert(Object o) {
        List<Object> sources = new ArrayList<>();  
    private abstract static class Converter<T> {
    private final Errors root;  
        Object source,
    }
import org.opensearch.common.inject.spi.TypeListenerBinding;
     */
 * SPDX-License-Identifier: Apache-2.0
    }
            convert(source),
    public List<Object> getSources() {
            convert(source),
        @Override
    }  
            return value;
    }  
            converted
        }
    public Errors duplicateScopeAnnotations(Class<? extends Annotation> a, Class<? extends Annotation> b) {
        boolean appliesTo(Object o) {
                    fmt.format("Caused by: %s", writer.getBuffer());  
        for (Message message : messages) {
/*  
    }  
    public Errors merge(Collection<Message> messages) {  
            formatter.format("  while locating %s%n", convert(dependency.getKey()));
                    cause.printStackTrace(new PrintWriter(writer));
    private Errors addMessage(Throwable cause, String messageFormat, Object... arguments) {
 * GitHub history for details.
    }  
        }  
     */
    private Message merge(Message message) {
import org.opensearch.common.inject.spi.Message;
    public Errors missingScopeAnnotation() {
        );
    }
            stringValue,
        String message = format(messageFormat, arguments);
        CollectionUtil.timSort(result, new Comparator<Message>() {
            source,
            arguments[i] = Errors.convert(arguments[i]);
    public Errors missingImplementation(Key key) {
    public Errors errorNotifyingTypeListener(TypeListenerBinding listener, TypeLiteral<?> type, Throwable cause) {
        }  
import java.lang.reflect.Member;  
/**
        + "annotated with @Inject or a zero-argument constructor that is not private.";
        throw new ProvisionException(getMessages());
     * }</code></pre>
            b  
    /**
        } else {
        throw new ConfigurationException(getMessages());  
    public Errors duplicateBindingAnnotations(Member member, Class<? extends Annotation> a, Class<? extends Annotation> b) {
    }
     * The root errors object. Used to access the list of error messages.
        for (Converter<?> converter : converters) {  
        for (Errors e = this; e != null; e = e.parent) {  
            public int compare(Message a, Message b) {  
    public static Throwable getOnlyCause(Collection<Message> messages) {
    public Errors cannotBindToGuiceType(String simpleName) {  
    }  
    public static Object convert(Object o) {
    }
    });  
        addMessage("Could not expose() %s, it must be explicitly bound.", key);
        abstract String toString(T t);  
    ) {  
            }  
            formatter.format("  while locating %s%n", convert(dependency.getKey()));
import java.util.Collections;
    public Errors bindingToProvider() {
    }  
            if (injectionPoint != null) {
    public Errors optionalConstructor(Constructor constructor) {
            return;
        if (size() == expectedSize) {  
            bindingAnnotation  
 * A collection of error messages. If this type is passed as a method parameter, the method is  
        return sources;
import java.util.ArrayList;
 * Licensed under the Apache License, Version 2.0 (the "License");
    public Errors errorInjectingConstructor(Throwable cause) {  
                return converter.convert(o);
                List<Object> dependencies = errorMessage.getSources();
    }
            type,
    /**
     * The leaf source for errors added here.
                fmt.format("%n");  
    }  
    public Errors merge(Errors moreErrors) {
    public void throwIfNewErrors(int expectedSize) throws ErrorsException {
        root.errors.add(message);
        return addMessage("Please annotate with @ScopeAnnotation.");
    }
 * you may not use this file except in compliance with the License.  
                    Object source = dependencies.get(i);
            this.type = type;
    public Errors cannotInjectRawTypeLiteral() {  
        for (Message message : messages) {
    }
            return toString(type.cast(o));  
            }
        return addMessage("Binding to Provider is not allowed.");
        return this;
        this.root = parent.root;  
    /**  
import java.util.Locale;  
}  
            "Multiple converters can convert '%s' (bound at %s) to %s:%n"
        return addMessage("Binding points to itself.");
     */  
            stringValue,  
    }
        return addMessage(  
            scopeAnnotation,  
                if (displayCauses && cause != null) {  
    public void throwCreationExceptionIfErrorsExist() {
            dependency = injectionPoint.getDependencies().get(0);  
        if (memberType == Field.class) {
        this.source = source;
            if (key.getAnnotationType() != null) {
        return addMessage("Binding to core guice framework type is not allowed: %s.", simpleName);
 *
 * identify that method. When calling a method that's defined in a different context, call that  
    }
     * same message for both bind time errors:
                }
            int index = 1;
     * The parent errors object. Used to obtain the chain of source objects.  
            return;  
 */  
            return this;  
        return addMessage("%s has more than one annotation annotated with @BindingAnnotation: " + "%s and %s", member, a, b);
        return errorInUserCode(cause, "Error notifying InjectionListener %s of %s.%n" + " Reason: %s", listener, type, cause);
    /**
            if (onlyCause != null) {
                    StringWriter writer = new StringWriter();
    public Errors recursiveBinding() {  
        for (int i = 0; i < arguments.length; i++) {
 * Modifications Copyright OpenSearch Contributors. See
    }, new Converter<Member>(Member.class) {
    }
        return new Message(sources, message.getMessage(), message.getCause());  
    }
    }
        return addMessage("@ImplementedBy points to the same class it annotates.");
        }
        } else if (source instanceof Key<?> key) {
            cause,
            }  
 */  
     * Returns an instance that uses {@code source} as a reference point for newly added errors.  
        return errorInUserCode(  
    public Errors addMessage(String messageFormat, Object... arguments) {  
        public String toString(Class c) {
            "Error converting '%s' (bound at %s) to %s%n" + " using %s.%n" + " Reason: %s",
    }
    }  
            @Override
        public String toString(Key key) {  
     */
        return errorInUserCode(runtimeException, "Error in custom provider, %s", runtimeException);
    public Errors missingRuntimeRetention(Object source) {  
    }
        return addMessage("Could not find a suitable constructor in %s. " + CONSTRUCTOR_RULES, implementation);
        return errorInUserCode(cause, "Error injecting constructor, %s", cause);
            if (errorMessages.size() == 1) {  
        return o;
    public Errors duplicateScopes(Scope existing, Class<? extends Annotation> annotationType, Scope scope) {  
        return addMessage("No implementation for %s was bound.", key);
        Object converted
import org.opensearch.common.inject.spi.InjectionPoint;  
        );
/*  
     * We use a fairly generic error message here. The motivation is to share the
    }  
        return addMessage("%s doesn't provide instances of %s.", providerType, type);  
        int parameterIndex = dependency.getParameterIndex();
                + " %s.%n"  
        MatcherAndConverter a,  
        return addMessage(  
import java.util.Comparator;  
        this.source = source;
        }
    }
    public static String format(String messageFormat, Object... arguments) {  
            case CreationException creationException -> creationException.getErrorMessages();  
            parameterName,  
    public Errors tooManyConstructors(Class<?> implementation) {
    private static final Collection<Converter<?>> converters = Arrays.asList(new Converter<Class>(Class.class) {  
        TypeLiteral<?> type,
    private static final String CONSTRUCTOR_RULES = "Classes must have either one (and only one) constructor "
 * http://www.apache.org/licenses/LICENSE-2.0  
            cause
            "%s is annotated with %s, but scope annotations are not supported " + "for abstract types.%n Bound at %s.",
        );
    public Errors missingConstructor(Class<?> implementation) {
        Throwable onlyCause = null;  
    }
        return addMessage(
            if (converter.appliesTo(o)) {
        } else if (source instanceof InjectionPoint injectionPoint) {
        return addMessage(
            convert(source),  
    public Errors cannotInjectTypeLiteralOf(Type unsupportedType) {
        }
        Collection<Message> messages = getMessagesFromThrowable(cause);  
        } else {
            return;
                + " Please adjust your type converter configuration to avoid overlapping matches.",
            convert(source)
    }  
    public Errors cannotSatisfyCircularDependency(Class<?> expectedType) {
            return MoreTypes.toString(member);
        throw toException();
        return unmodifiableList(result);
                fmt.format("%s) %s%n", index++, errorMessage.getMessage());  
    public static Collection<Message> getMessagesFromThrowable(Throwable throwable) {
    public Errors errorInProvider(RuntimeException runtimeException) {
    public ErrorsException toException() {
        String stringValue,  
        return errorInUserCode(cause, "Error injecting %s using %s.%n" + " Reason: %s", type, listener, cause);  
    }  
        TypeLiteral<?> type,  
        String stringValue,
        }
 */  
            matchingConverter,  
import java.io.PrintWriter;
        this.parent = null;
        TypeLiteral<?> type,
        return addMessage("Tried proxying %s to support a circular dependency, but it is not an interface.", expectedType);
    }  
            return c.getName();  
            return fmt.toString();  
        }  
    }  
            formatter.format("    for parameter %s at %s%n", dependency.getParameterIndex(), StackTraceElements.forMember(member));  
        if (!hasErrors()) {  
        return addMessage("Cannot inject a MembersInjector that has no type parameter");
    }
    }
 * considered to have executed successfully only if new errors were not added to this collection.
    public Errors missingConstantValues() {
public final class Errors {
                return a.getSource().compareTo(b.getSource());
    }
    public Errors errorInjectingMethod(Throwable cause) {  
 * @author jessewilson@google.com (Jesse Wilson)  
import org.opensearch.common.inject.TypeLiteral;  
            convert(source),  
            return merge(messages);  
        if (!messages.isEmpty()) {
    }  
        return addMessage("Cannot inject a TypeLiteral that has no type parameter");
 * distributed under the License is distributed on an "AS IS" BASIS,  
        @Override
        Object source,
     * an {@code ErrorsException} is thrown.  
import org.opensearch.common.inject.Scope;
    private List<Message> errors; // lazy, use getErrorsForAdd()  
        }  
import org.apache.lucene.util.CollectionUtil;
        this.root = this;  
     * null unless (root == this) and error messages exist. Never an empty list.
        Member member = injectionPoint.getMember();
    public Errors subtypeNotProvided(Class<? extends Provider<?>> providerType, Class<?> type) {
        this.root = this;  
 * You may obtain a copy of the License at
 *
            formatter.format("  at %s%n", StackTraceElements.forMember(member));  
    }
        final Class<T> type;
    public Errors notASubtype(Class<?> implementationType, Class<?> type) {  
    }
    public static void formatInjectionPoint(Formatter formatter, Dependency<?> dependency, InjectionPoint injectionPoint) {
        Class<? extends Member> memberType = MoreTypes.memberType(member);  
                formatInjectionPoint(formatter, dependency, injectionPoint);  
            onlyCause = messageCause;
        }
        throw toException();
                sources.add(0, e.source);
            }
    private final Errors parent;
     */
                continue;
                formatSource(formatter, dependency.getKey());
        return this;  
            member,
            }
 * to create a new Errors instance that contains additional context. All messages added to the
     */
    }
    /**
            formatter.format("  while locating %s%n", convert(key));  
                fmt.format("1 error");
        List<Object> sources = new ArrayList<>();
            case ProvisionException provisionException -> provisionException.getErrorMessages();
        if (value != null || dependency.isNullable()) {  
        }  
    /**  
     * Returns the formatted message for an exception with the specified messages.  
    }
 * The OpenSearch Contributors require contributions made to  
        );
            }
            return Collections.emptyList();  
