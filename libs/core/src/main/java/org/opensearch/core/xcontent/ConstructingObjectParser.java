    }
                namedObjectParser,
    /**
        }
    /**
            if (queuedFields == null) {
    @Override
import java.util.function.BiFunction;
                }
     *        the XContent then parsing will throw an error. We use an array here rather than a {@code Map<String, Object>} to save on
}
             * constructor in the argument list so we don't need to do any fancy
    public static <Value, FieldT> BiConsumer<Value, FieldT> optionalConstructorArg() {
                    throw new XContentParseException(
            objectParser.declareNamedObjects(
                wrapOrderedModeCallBack(orderedModeCallback),
                parseField
        if (isConstructorArg(consumer)) {
         */
 * that {@linkplain ConstructingObjectParser}'s constructor takes a lambda that must build the target object from a list of constructor
                + objectParser.getName()
        if (consumer == null) {
     * Otherwise it just applies the value just like {@linkplain ObjectParser} does.
                wrapOrderedModeCallBack(orderedModeCallback),
     *        allocations.
             * location so we can add it to the error message if parsing fails. The second one (the lambda) is the actual operation being
    /**
 * not use this file except in compliance with the License.
            throw new IllegalArgumentException("[parser] is required");
        return position;
                    );
public final class ConstructingObjectParser<Value, Context> extends AbstractObjectParser<Value, Context>
     */
     * @param name The name given to the delegate ObjectParser for error identification. Use what you'd use if the object worked with
        if (namedObjectParser == null) {
        } else {
     * List of constructor names used for generating the error message if not all arrive.
     * Add a constructor argument
             * parser. Conveniently, we can close over the position of the
            if (target.targetObject != null) {
 * parse a secondary object and have that one call the target object's constructor. That ought to be rare though.
                } else {
    public <T> void declareNamedObject(
            objectParser.declareNamedObjects((target, v) -> target.constructorArg(position, v), namedObjectParser, parseField);
     * Pass the {@linkplain BiConsumer} this returns the declare methods to declare an optional constructor argument. See this class's
    }
     *        ObjectParser.
        BiConsumer<Value, List<T>> consumer,
    }
        BiConsumer<Value, List<T>> consumer,
             * triggers the "constructor arg just arrived behavior" of the
    @Override
     *        that you declared the {@link #constructorArg()}s and none will be null. If any of the constructor arguments aren't defined in
 * arguments:
             */
            throw new IllegalArgumentException("[parser] is required");
                    "failed to build [" + objectParser.getName() + "] after last required field arrived",
        }
            }
    /**
        /**
            // All missing constructor arguments were optional. Just build the target and return it.
         * Finish parsing the object.
import java.util.List;
        }
 *       PARSER.declareString(constructorArg(), new ParseField("vegetable"));
 */
     * {@linkplain ConstructingObjectParser}'s type parameters.
 */
     * The target of the {@linkplain ConstructingObjectParser}. One of these is built every time you call
            numberOfFields += 1;
 *       PARSER.declareInt(Thing::setFruit, new ParseField("fruit"));
    implements
     * @param name The name given to the delegate ObjectParser for error identification. Use what you'd use if the object worked with
 * <p>
            throw new IllegalArgumentException("[parser] is required");
        BiConsumer<Value, T> consumer,
    }
    public ConstructingObjectParser(String name, Function<Object[], Value> builder) {
 *       PARSER.declareInt(Thing::setBug, new ParseField("bug"));
        }
     * @param name The name given to the delegate ObjectParser for error identification. Use what you'd use if the object worked with
         * The parser this class is working against. We store it here so we can fetch it conveniently when queueing fields to lookup the
            int position = addConstructorArg(consumer, parseField);
                callback.accept(target.targetObject);
     * javadoc for an example. The order in which these are declared matters: it is the order that they come in the array passed to
        }
    }
        if (orderedModeCallback == null) {
                }
                    queuedFields[queuedFieldsCount].accept(targetObject);
 * compatible open source license.
         */
             * check if they are all optional and build the error message at the same time - if we don't start the error message then they
    @Override
        /**
    private static final BiConsumer<?, ?> REQUIRED_CONSTRUCTOR_ARG_MARKER = (a, b) -> {
                targetObject = builder.apply(constructorArgs, context);
     * Creates the consumer that does the "field just arrived" behavior. If the targetObject hasn't been built then it queues the value.
 * just like {@linkplain ObjectParser}.
        if (parseField == null) {
 *
        return (BiConsumer<Value, FieldT>) OPTIONAL_CONSTRUCTOR_ARG_MARKER;
        }
             * constructor in the argument list so we don't need to do any fancy
        /**
            buildTarget();
            return parse(parser, context);
                while (queuedFieldsCount > 0) {
         * should have just applied the consumer immediately.
                    e
        }
            }
 * @opensearch.internal
            throw new IllegalArgumentException("[parseField] is required");
    /**
import java.util.function.Consumer;
    ) {
            }
             */
        /**
    }
 * microseconds and using {#linkplain ObjectParser} directly adds another 300 or so microseconds. In the best case
 * Note: if optional constructor arguments aren't specified then the number of allocations is always the worst case.
     */
        } else {
        private final Object[] constructorArgs = new Object[constructorArgInfos.size()];
                    message.append(", ").append(arg.field);
     *        ObjectParser.
                namedObjectParser,
            );
             * The target hasn't been built. Queue the callback.
         * Array of constructor args to be passed to the {@link ConstructingObjectParser#builder}.
         * {@link #constructorArgs} array looking for nulls when we receive another constructor parameter. When this is equal to the size of
        return (target, v) -> {
 * <p>
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * under the License.
     *        the array will be in the same order that you declared the {@link #constructorArg()}s and none will be null. The second
    private Consumer<Target> wrapOrderedModeCallBack(Consumer<Value> callback) {
     * the field queue.
 * Licensed to Elasticsearch under one or more contributor
    private int addConstructorArg(BiConsumer<?, ?> consumer, ParseField parseField) {
                return;
             * triggers the "constructor arg just arrived behavior" of the
            numberOfFields += 1;
            } catch (Exception e) {
        constructorArgInfos.add(new ConstructorArgInfo(parseField, required));
        return (BiConsumer<Value, FieldT>) REQUIRED_CONSTRUCTOR_ARG_MARKER;
    private final BiFunction<Object[], Context, Value> builder;
                    "Failed to build [" + objectParser.getName() + "] after last required field arrived",
 *           a -> new Thing((String) a[0], (String) a[1], (Integer) a[2]));
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
     * parsed from the {@linkplain XContentParser} the target object is immediately built.
     */
            /*
     *        the XContent then parsing will throw an error. We use an array here rather than a {@code Map<String, Object>} to save on
        private void queue(Consumer<Value> queueMe) {
            queuedFields[queuedFieldsCount] = queueMe;
            int position = addConstructorArg(consumer, parseField);
    }
            if (targetObject != null) {
            /*
     */
        BiFunction<XContentParser, Context, Value>,
    public static <Value, FieldT> BiConsumer<Value, FieldT> constructorArg() {
    /**
     * Consumer that marks a field as a required constructor argument instead of a real object field.
                    null,
             * does during parsing other than the boxing the ObjectParser might do. The first one is to preserve a snapshot of the current
import org.opensearch.core.xcontent.ObjectParser.ValueType;
        final boolean required;
             * constructor in the argument list so we don't need to do any fancy
 * this file be licensed under the Apache-2.0 license or a
    /**
     * Call this to do the actual parsing. This implements {@link BiFunction} for conveniently integrating with ObjectParser.
/*
 * Anyway, {@linkplain ConstructingObjectParser} parses the fields in the order that they are in the XContent, collecting constructor
        throw new UnsupportedOperationException("I am just a marker I should never be called.");
    @Override
            assert false == constructorArgInfos.isEmpty() : "["
     * @return The argument position
        if (consumer == null) {
     */
 * </p>
        }
 * differences being that constructor arguments are declared with the consumer returned by the static {@link #constructorArg()} method and
         * build it. This is only allocated if the callback has to be queued.
                parseField
    @Override
        }
             * parser. Conveniently, we can close over the position of the
             * Build a new consumer directly against the object parser that
    @SuppressWarnings("unchecked") // Safe because we never call the method. This is just trickery to make the interface pretty.
     *        allocations.
        objectParser.declareRequiredFieldSet(requiredSet);
            throw new XContentParseException(parser.getTokenLocation(), "[" + objectParser.getName() + "] failed to parse object", e);
             */
                }
        }
                } catch (Exception e) {
    /**
 * constructor arguments are first. On this platform with the same microbenchmarks just creating the XContentParser is around 900
    /**
             */
    private int numberOfFields = 0;
        NamedObjectParser<T, Context> namedObjectParser,
            /*
     */
            throw new IllegalArgumentException("[type] is required");
         */
     */
    private <T> BiConsumer<Target, T> queueingConsumer(BiConsumer<Value, T> consumer, ParseField parseField) {
            assert targetObject == null : "Don't queue after the targetObject has been built! Just apply the consumer directly.";
            objectParser.declareNamedObject((target, v) -> target.constructorArg(position, v), namedObjectParser, parseField);
package org.opensearch.core.xcontent;
        }
        private Context context;
    @Override
        throw new UnsupportedOperationException("I am just a marker I should never be called.");
    public String getName() {
     */
 *
        }
 * {@linkplain ConstructingObjectParser} allocates two additional objects per parse compared to {#linkplain ObjectParser}. In the worst case
            objectParser.declareNamedObject(queueingConsumer(consumer, parseField), namedObjectParser, parseField);
            constructorArgsCollected++;
    }
    }
 *   }
        /**
 *       PARSER.declareInt(optionalConstructorArg(), new ParseField("mineral"));
                );
                }
 * this work for additional information regarding copyright
         * The parse context that is used for this invocation. Stored here so that it can be passed to the {@link #builder}.
     * @param builder A binary function that builds the object from an array of Objects and the parser context.  Declare this inline with
            numberOfFields += 1;
        private Consumer<Value> queuedOrderedModeCallback;
            /*
        this(name, false, builder);
            throw new IllegalArgumentException("[consumer] is required");
                if (false == arg.required) continue;
 * KIND, either express or implied.  See the License for the
            queuedFieldsCount++;
        /**
             * parser. Conveniently, we can close over the position of the
     *        {@code Map<String, Object>} to save on allocations.
         * Set a constructor argument and build the target object if all constructor arguments have arrived.
 * GitHub history for details.
 */
     * javadoc for an example. The order in which these are declared matters: it is the order that they come in the array passed to
 * arguments and parsing and queueing normal fields until all constructor arguments are parsed. Then it builds the target object and replays
                        "[" + objectParser.getName() + "] failed to parse field [" + parseField.getPreferredName() + "]",
    public ConstructingObjectParser(String name, boolean ignoreUnknownFields, Function<Object[], Value> builder) {
     * Constructor arguments are detected by this "marker" consumer. It
                // The target has already been built. Call the callback now.
    }
 * the queued fields. Any fields that come in after the last constructor arguments are parsed and immediately applied to the target object
        private Value targetObject;
        private void constructorArg(int position, Object value) {
            numberOfFields += 1;
     * Build the parser.
     */
        }
         * Fields to be saved to the target object when we can build it. This is only allocated if a field has to be queued.
import org.opensearch.core.xcontent.ObjectParser.NamedObjectParser;
        if (type == null) {
        ParseField parseField
     *        the parser, casting the elements of the array to the arguments so they work with your favorite constructor. The objects in
            /*
    }
            int position = addConstructorArg(consumer, parseField);
 * the Apache License, Version 2.0 (the "License"); you may
             * If there weren't any constructor arguments declared at all then we won't get an error message but this isn't really a valid
             * use of ConstructingObjectParser. You should be using ObjectParser instead. Since this is more of a programmer error and the
        if (parser == null) {
         */
    };
     *
     */
                return targetObject;
         * Queue a consumer that we'll call once the targetObject is built. If targetObject has been built this will fail because the caller
    }
    @Override
            throw new IllegalArgumentException("[parseField] is required");
         * The count of fields already queued.
 * this doesn't sounds like what you want to parse have a look at
import java.io.IOException;
                if (message == null) {
        }
/**
 * </p>
                ConstructorArgInfo arg = constructorArgInfos.get(i);
        if (isConstructorArg(consumer)) {
            }
    private final ObjectParser<Target, Context> objectParser;
    public Value apply(XContentParser parser, Context context) {
     */
    private static class ConstructorArgInfo {
        /**
        } else {
        }
            throw new IllegalArgumentException("[orderedModeCallback] is required");
         */
        Target(XContentParser parser, Context context) {
             * or expensive lookups whenever the constructor args come in.
/*
    }
        };
     * parsed from the {@linkplain XContentParser} the target object is immediately built.
    /**
             * or expensive lookups whenever the constructor args come in.
        this.builder = builder;
                buildTarget();
    private static final BiConsumer<?, ?> OPTIONAL_CONSTRUCTOR_ARG_MARKER = (a, b) -> {
        objectParser = new ObjectParser<>(name, ignoreUnknownFields, null);
    }
     *        from external systems, never when parsing requests from users.
        private Value finish() {
            target.queue(targetObject -> {
                throw new IllegalArgumentException(message.append(']').toString());
    }
             * queued. Note that we don't do any of this if the target object has already been built.
        }
        private int queuedFieldsCount = 0;
                throw new XContentParseException(
            objectParser.declareField(queueingConsumer(consumer, parseField), parser, parseField, type);
        private final XContentParser parser;
            }
        }
                this.queuedFields = queuedFields;
        this(name, ignoreUnknownFields, (args, context) -> builder.apply(args));
    }
                throw new XContentParseException(
        }
             */
        /**
        final ParseField field;
 *   private static final ConstructingObjectParser<Thing, SomeContext> PARSER = new ConstructingObjectParser<>("thing",
             * The object hasn't been built which ought to mean we're missing some constructor arguments. But they could be optional! We'll
     * @param ignoreUnknownFields Should this parser ignore unknown fields? This should generally be set to true only when parsing responses
            this.required = required;
import java.util.function.Function;
 * Unless required by applicable law or agreed to in writing,
                Consumer<Value>[] queuedFields = new Consumer[numberOfFields];
 * <p>
 * battery power in a reasonably unscientific microbenchmark it is about 100 microseconds for a reasonably large object, less if the
         * {@link #constructorArgs} we build the target object.
        }
             * triggers the "constructor arg just arrived behavior" of the
    }
        NamedObjectParser<T, Context> namedObjectParser,
 * it allocates <code>3 + 2 * param_count</code> objects per parse. If this overhead is too much for you then feel free to have ObjectParser
        };
        return objectParser.getName();
         */
                @SuppressWarnings({ "unchecked", "rawtypes" })
        ParseField parseField
     *        from external systems, never when parsing requests from users.
 * <pre>{@code
             * Build a new consumer directly against the object parser that
        } else {
                    e
                    e.getLocation(),
    /**
    public <T> void declareField(BiConsumer<Value, T> consumer, ContextParser<Context, T> parser, ParseField parseField, ValueType type) {
    ) {
 * <p>
                    queuedFieldsCount -= 1;
        objectParser.declareExclusiveFieldSet(exclusiveSet);
        return (target) -> {
        }
     *        argument is the value of the context provided to the {@link #parse(XContentParser, Object) parse function}. If any of the
     * {@linkplain ConstructingObjectParser#apply(XContentParser, Object)} Note that it is not static so it inherits
                (target, v) -> target.constructorArg(position, v),
 */
        if (parseField == null) {
         */
            this.parser = parser;
     *        constructor arguments aren't defined in the XContent then parsing will throw an error. We use an array here rather than a
 * This does add some overhead compared to just using {@linkplain ObjectParser} directly. On a 2.2 GHz Intel Core i7 MacBook Air running on
            throw new IllegalArgumentException("[parser] is required");
     * Consumer that marks a field as an optional constructor argument instead of a real object field.
     * @param consumer Either {@link #REQUIRED_CONSTRUCTOR_ARG_MARKER} or {@link #REQUIRED_CONSTRUCTOR_ARG_MARKER}
            try {
    /**
 * Like {@link ObjectParser} but works with objects that have constructors whose arguments are mixed in with its other settings. Queries are
         * How many of the constructor parameters have we collected? We keep track of this so we don't have to count the
        NamedObjectParser<T, Context> namedObjectParser,
        ConstructorArgInfo(ParseField field, boolean required) {
        if (consumer == null) {
     * @param parseField Parse field
            constructorArgs[position] = value;
            }
        /**
     */
     * {@link #builder} and the order that missing arguments are reported to the user if any are missing. When all of these parameters are
 * specific language governing permissions and limitations
import org.opensearch.core.ParseField;
        boolean required = consumer == REQUIRED_CONSTRUCTOR_ARG_MARKER;
                    queuedOrderedModeCallback.accept(targetObject);
         * OrderedModeCallback to be called with the target object when we can
     * @param ignoreUnknownFields Should this parser ignore unknown fields? This should generally be set to true only when parsing responses
        if (consumer == null) {
            /*
        if (namedObjectParser == null) {
     * @param builder A function that builds the object from an array of Objects. Declare this inline with the parser, casting the elements
 * Modifications Copyright OpenSearch Contributors. See
            return targetObject;
                );
        if (parseField == null) {
        ParseField parseField
import java.util.ArrayList;
 * }</pre>
    }
     *        ObjectParser.
             */
     *        of the array to the arguments so they work with your favorite constructor. The objects in the array will be in the same order
    @SuppressWarnings("unchecked") // Safe because we never call the method. This is just trickery to make the interface pretty.
    @Override
        private int constructorArgsCollected = 0;
            throw new IllegalArgumentException("[parseField] is required");
     */
     * The number of fields on the targetObject. This doesn't include any constructor arguments and is the size used for the array backing
         */
             */
    /**
        }
 * Declaring a {@linkplain ConstructingObjectParser} is intentionally quite similar to declaring an {@linkplain ObjectParser}. The only
                    consumer.accept(targetObject, v);
     * Pass the {@linkplain BiConsumer} this returns the declare methods to declare a required constructor argument. See this class's
 *
    public Value parse(XContentParser parser, Context context) throws IOException {
             * triggers the "constructor arg just arrived behavior" of the
    }
    public void declareRequiredFieldSet(String... requiredSet) {
         */
             * constructor in the argument list so we don't need to do any fancy
     * @param builder A function that builds the object from an array of Objects. Declare this inline with the parser, casting the elements
/*
     *
    public ConstructingObjectParser(String name, boolean ignoreUnknownFields, BiFunction<Object[], Context, Value> builder) {
 * </p>
            throw new IllegalArgumentException("[consumer] is required");
            throw new IllegalArgumentException("[consumer] is required");
                + "argument. If it doesn't have any it should use ObjectParser instead of ConstructingObjectParser. This is a bug "
            int position = addConstructorArg(consumer, parseField);
             */
        if (isConstructorArg(consumer)) {
        private Consumer<Value>[] queuedFields;
 * different but similar sounding problem.
            /*
    @Override
        return this.constructorArgInfos.size();
        int position = constructorArgInfos.size();
             * parser ought to still work we just assert this.
            this.context = context;
            this.field = field;
             * parser. Conveniently, we can close over the position of the
         * The target object. This will be instantiated with the constructor arguments are all parsed.
                consumer.accept(target.targetObject, v);
            );
 * ownership. Elasticsearch licenses this file to you under
 * license agreements. See the NOTICE file distributed with
        if (parseField == null) {
                    message = new StringBuilder("Required [").append(arg.field);
    /**
 * {@link ObjectParser#declareNamedObjects(BiConsumer, ObjectParser.NamedObjectParser, Consumer, ParseField)} which solves a slightly
         */
    public <T> void declareNamedObjects(
    ) {
                + "in the parser declaration.";
 *
             * Build a new consumer directly against the object parser that
    }
 * like this, for example <code>ids</code> requires <code>types</code> but always parses the <code>values</code> field on the same level. If
            }
        return objectParser.parse(parser, new Target(parser, context), context).finish();
    private final List<ConstructorArgInfo> constructorArgInfos = new ArrayList<>();
                // The target has already been built. Just apply the consumer now.
                try {
                if (constructorArgs[i] != null) continue;
                        e
        try {
    };
             * The target hasn't been built. Queue the consumer. The next two lines are the only allocations that ConstructingObjectParser
     * Build the parser.
        }
            target.queuedOrderedModeCallback = callback;
    public void declareExclusiveFieldSet(String... exclusiveSet) {
    int getNumberOfFields() {
                + "] must configure at least one constructor "
            if (constructorArgsCollected == constructorArgInfos.size()) {
     * Build the parser.
        }
            throw new IllegalArgumentException("[consumer] is required");
 * software distributed under the License is distributed on an
            } catch (XContentParseException e) {
         * location of each field so that we can give a useful error message when replaying the queue.
            StringBuilder message = null;
         */
             * or expensive lookups whenever the constructor args come in.
            if (target.targetObject != null) {
        ContextParser<Context, Value> {
     */
             * Build a new consumer directly against the object parser that
        /**
        return consumer == REQUIRED_CONSTRUCTOR_ARG_MARKER || consumer == OPTIONAL_CONSTRUCTOR_ARG_MARKER;
     *        that you declared the {@link #constructorArg()}s and none will be null. If any of the constructor arguments aren't defined in
        if (namedObjectParser == null) {
        }
        /**
            /*
             * were all optional!
            throw new IllegalArgumentException("[parseField] is required");
     * {@link #builder} and the order that missing arguments are reported to the user if any are missing. When all of these parameters are
     *
 * </p>
 *   static {
        Consumer<Value> orderedModeCallback,
 * The OpenSearch Contributors require contributions made to
            objectParser.declareField((target, v) -> target.constructorArg(position, v), parser, parseField, type);
 * SPDX-License-Identifier: Apache-2.0
            objectParser.declareNamedObjects(
    private boolean isConstructorArg(BiConsumer<?, ?> consumer) {
        private void buildTarget() {
 * You may obtain a copy of the License at
 *       PARSER.declareString(constructorArg(), new ParseField("animal"));
import java.util.function.BiConsumer;
            if (message != null) {
                        location,
                // There were non-optional constructor arguments missing.
            objectParser.declareNamedObjects(queueingConsumer(consumer, parseField), namedObjectParser, parseField);
        }
            }
     *        of the array to the arguments so they work with your favorite constructor. The objects in the array will be in the same order
            for (int i = 0; i < constructorArgs.length; i++) {
    private class Target {
                return;
    public <T> void declareNamedObjects(
            });
                queueingConsumer(consumer, parseField),
             * or expensive lookups whenever the constructor args come in.
     * keeps the API looking clean even if it is a bit sleezy.
            XContentLocation location = target.parser.getTokenLocation();
        } catch (IOException e) {
        if (isConstructorArg(consumer)) {
                if (queuedOrderedModeCallback != null) {
