    private static final BiConsumer<?, ?> REQUIRED_CONSTRUCTOR_ARG_MARKER = (a, b) -> {
            );
             * parser. Conveniently, we can close over the position of the
     */  
                    queuedOrderedModeCallback.accept(targetObject);
 *
    /**
        if (parser == null) {
        if (namedObjectParser == null) {  
             * or expensive lookups whenever the constructor args come in.
 */
            try {
        } else {
    }  
            });
            numberOfFields += 1;  
            throw new IllegalArgumentException("[parseField] is required");
            this.context = context;
             */
         */  
            /*
    }
 *           a -> new Thing((String) a[0], (String) a[1], (Integer) a[2]));  
             * parser. Conveniently, we can close over the position of the
        }
            objectParser.declareField(queueingConsumer(consumer, parseField), parser, parseField, type);
        }
         * The parse context that is used for this invocation. Stored here so that it can be passed to the {@link #builder}.
                    throw new XContentParseException(
        private final XContentParser parser;
     * Consumer that marks a field as a required constructor argument instead of a real object field.  
            } catch (XContentParseException e) {
        if (isConstructorArg(consumer)) {
            objectParser.declareNamedObjects((target, v) -> target.constructorArg(position, v), namedObjectParser, parseField);
             * constructor in the argument list so we don't need to do any fancy  
         * The target object. This will be instantiated with the constructor arguments are all parsed.
     * {@linkplain ConstructingObjectParser}'s type parameters.
     */
             * Build a new consumer directly against the object parser that  
     * @return The argument position
 * The OpenSearch Contributors require contributions made to  
        }
     * @param builder A function that builds the object from an array of Objects. Declare this inline with the parser, casting the elements  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * <p>  
    }  
        objectParser.declareExclusiveFieldSet(exclusiveSet);
        }
        ParseField parseField
 * Unless required by applicable law or agreed to in writing,
        }
            /*
import org.opensearch.core.xcontent.ObjectParser.NamedObjectParser;
    }  
    }
    }
            this.field = field;
                } else {
            constructorArgs[position] = value;
    @Override
         * Finish parsing the object.
     * Call this to do the actual parsing. This implements {@link BiFunction} for conveniently integrating with ObjectParser.  
        }
            objectParser.declareNamedObjects(  
            target.queue(targetObject -> {  
        private void constructorArg(int position, Object value) {
        }
             * queued. Note that we don't do any of this if the target object has already been built.  
                }  
             * triggers the "constructor arg just arrived behavior" of the
 */  
    @Override
 */  
             * location so we can add it to the error message if parsing fails. The second one (the lambda) is the actual operation being
            for (int i = 0; i < constructorArgs.length; i++) {
                }
             * or expensive lookups whenever the constructor args come in.
     * the field queue.  
    }
    int getNumberOfFields() {  
 * under the License.  
        ParseField parseField
 * arguments and parsing and queueing normal fields until all constructor arguments are parsed. Then it builds the target object and replays  
    public void declareExclusiveFieldSet(String... exclusiveSet) {  
        /**  
    }
 *       PARSER.declareInt(optionalConstructorArg(), new ParseField("mineral"));
                // There were non-optional constructor arguments missing.  
        objectParser = new ObjectParser<>(name, ignoreUnknownFields, null);  
 * }</pre>
 * @opensearch.internal
        if (parseField == null) {  
        }  
    @Override
     * parsed from the {@linkplain XContentParser} the target object is immediately built.
        private Consumer<Value>[] queuedFields;
 * <p>
             * does during parsing other than the boxing the ObjectParser might do. The first one is to preserve a snapshot of the current
    }
            throw new IllegalArgumentException("[orderedModeCallback] is required");
            }
 * KIND, either express or implied.  See the License for the
            throw new IllegalArgumentException("[consumer] is required");
        throw new UnsupportedOperationException("I am just a marker I should never be called.");
                }  
    @Override
     *        from external systems, never when parsing requests from users.  
        ParseField parseField  
            }  
     * keeps the API looking clean even if it is a bit sleezy.  
     * @param ignoreUnknownFields Should this parser ignore unknown fields? This should generally be set to true only when parsing responses
        ContextParser<Context, Value> {  
                parseField
            }  
             * use of ConstructingObjectParser. You should be using ObjectParser instead. Since this is more of a programmer error and the
             * The object hasn't been built which ought to mean we're missing some constructor arguments. But they could be optional! We'll
     * The number of fields on the targetObject. This doesn't include any constructor arguments and is the size used for the array backing
    public ConstructingObjectParser(String name, Function<Object[], Value> builder) {  
        /**
             */
                    e
        Consumer<Value> orderedModeCallback,  
     */
                consumer.accept(target.targetObject, v);
        int position = constructorArgInfos.size();
        return consumer == REQUIRED_CONSTRUCTOR_ARG_MARKER || consumer == OPTIONAL_CONSTRUCTOR_ARG_MARKER;  
        if (namedObjectParser == null) {  
            if (targetObject != null) {
import java.util.function.Consumer;
            } catch (Exception e) {
            if (constructorArgsCollected == constructorArgInfos.size()) {
         * location of each field so that we can give a useful error message when replaying the queue.
    /**
                if (constructorArgs[i] != null) continue;
         * The parser this class is working against. We store it here so we can fetch it conveniently when queueing fields to lookup the
        constructorArgInfos.add(new ConstructorArgInfo(parseField, required));  
         */
 * </p>  
 * </p>  
 *       PARSER.declareInt(Thing::setBug, new ParseField("bug"));  
     *        allocations.
        }
     *        the parser, casting the elements of the array to the arguments so they work with your favorite constructor. The objects in
                if (message == null) {
                if (queuedOrderedModeCallback != null) {  
     *        the array will be in the same order that you declared the {@link #constructorArg()}s and none will be null. The second  
                    );
        NamedObjectParser<T, Context> namedObjectParser,
    private Consumer<Target> wrapOrderedModeCallBack(Consumer<Value> callback) {
 * ownership. Elasticsearch licenses this file to you under  
     * List of constructor names used for generating the error message if not all arrive.
        /**  
 * that {@linkplain ConstructingObjectParser}'s constructor takes a lambda that must build the target object from a list of constructor
        }  
     *        allocations.  
        final ParseField field;  
                );  
        }
        }
            throw new IllegalArgumentException("[parseField] is required");
                parseField
        } catch (IOException e) {  
        if (parseField == null) {  
             * triggers the "constructor arg just arrived behavior" of the
    public <T> void declareNamedObjects(  
 * <p>
     */
             * Build a new consumer directly against the object parser that  
 * Anyway, {@linkplain ConstructingObjectParser} parses the fields in the order that they are in the XContent, collecting constructor
 */
import java.util.ArrayList;  
     * Constructor arguments are detected by this "marker" consumer. It
     */
            int position = addConstructorArg(consumer, parseField);
 * the queued fields. Any fields that come in after the last constructor arguments are parsed and immediately applied to the target object
 * differences being that constructor arguments are declared with the consumer returned by the static {@link #constructorArg()} method and  
             * constructor in the argument list so we don't need to do any fancy
             * constructor in the argument list so we don't need to do any fancy  
     * Otherwise it just applies the value just like {@linkplain ObjectParser} does.
            throw new IllegalArgumentException("[parseField] is required");
import java.util.function.Function;
 * this work for additional information regarding copyright
        Target(XContentParser parser, Context context) {
         * The count of fields already queued.  
             * The target hasn't been built. Queue the consumer. The next two lines are the only allocations that ConstructingObjectParser  
        NamedObjectParser<T, Context> namedObjectParser,  
                throw new IllegalArgumentException(message.append(']').toString());
        }  
            /*
             */
        BiFunction<XContentParser, Context, Value>,
 * battery power in a reasonably unscientific microbenchmark it is about 100 microseconds for a reasonably large object, less if the
 * software distributed under the License is distributed on an
     */  
        }
            assert false == constructorArgInfos.isEmpty() : "["
         * {@link #constructorArgs} array looking for nulls when we receive another constructor parameter. When this is equal to the size of
    /**
         * should have just applied the consumer immediately.
     *        {@code Map<String, Object>} to save on allocations.  
            }
            numberOfFields += 1;  
        }  
            );  
                    consumer.accept(targetObject, v);
        if (parseField == null) {
        if (namedObjectParser == null) {  
                throw new XContentParseException(
    public <T> void declareNamedObjects(  
     * javadoc for an example. The order in which these are declared matters: it is the order that they come in the array passed to  
            return targetObject;  
                // The target has already been built. Call the callback now.
import java.util.function.BiFunction;  
     *        the XContent then parsing will throw an error. We use an array here rather than a {@code Map<String, Object>} to save on  
import java.util.List;
         */  
            StringBuilder message = null;  
 * </p>
        this(name, false, builder);
    public Value parse(XContentParser parser, Context context) throws IOException {  
            throw new IllegalArgumentException("[parser] is required");
                    "Failed to build [" + objectParser.getName() + "] after last required field arrived",
    }  
                        location,
    /**  
     *  
        if (isConstructorArg(consumer)) {
    private final BiFunction<Object[], Context, Value> builder;  
         * Queue a consumer that we'll call once the targetObject is built. If targetObject has been built this will fail because the caller
    public void declareRequiredFieldSet(String... requiredSet) {
    /**  
        this(name, ignoreUnknownFields, (args, context) -> builder.apply(args));  
public final class ConstructingObjectParser<Value, Context> extends AbstractObjectParser<Value, Context>  
        boolean required = consumer == REQUIRED_CONSTRUCTOR_ARG_MARKER;
package org.opensearch.core.xcontent;
     */  
        return this.constructorArgInfos.size();
        private void queue(Consumer<Value> queueMe) {
     *        from external systems, never when parsing requests from users.
        this.builder = builder;
     *        ObjectParser.
        return (BiConsumer<Value, FieldT>) OPTIONAL_CONSTRUCTOR_ARG_MARKER;
        private int queuedFieldsCount = 0;
    /**  
     *        the XContent then parsing will throw an error. We use an array here rather than a {@code Map<String, Object>} to save on
            queuedFields[queuedFieldsCount] = queueMe;
 * different but similar sounding problem.  
     *
        };
             * Build a new consumer directly against the object parser that  
        objectParser.declareRequiredFieldSet(requiredSet);
    @SuppressWarnings("unchecked") // Safe because we never call the method. This is just trickery to make the interface pretty.  
 * this doesn't sounds like what you want to parse have a look at
            queuedFieldsCount++;  
 * compatible open source license.
            assert targetObject == null : "Don't queue after the targetObject has been built! Just apply the consumer directly.";
             * triggers the "constructor arg just arrived behavior" of the
        }
        if (orderedModeCallback == null) {  
        /**
                @SuppressWarnings({ "unchecked", "rawtypes" })
         * OrderedModeCallback to be called with the target object when we can
         */  
     * @param name The name given to the delegate ObjectParser for error identification. Use what you'd use if the object worked with
        return (target, v) -> {
        /**  
        }  
 *   private static final ConstructingObjectParser<Thing, SomeContext> PARSER = new ConstructingObjectParser<>("thing",
            throw new IllegalArgumentException("[parser] is required");
                ConstructorArgInfo arg = constructorArgInfos.get(i);  
                (target, v) -> target.constructorArg(position, v),
     * @param consumer Either {@link #REQUIRED_CONSTRUCTOR_ARG_MARKER} or {@link #REQUIRED_CONSTRUCTOR_ARG_MARKER}
                buildTarget();
 *  
     * javadoc for an example. The order in which these are declared matters: it is the order that they come in the array passed to
             * If there weren't any constructor arguments declared at all then we won't get an error message but this isn't really a valid
}
    public ConstructingObjectParser(String name, boolean ignoreUnknownFields, Function<Object[], Value> builder) {
            int position = addConstructorArg(consumer, parseField);  
     * @param parseField Parse field  
        return objectParser.parse(parser, new Target(parser, context), context).finish();
        /**  
 * </p>
                + "in the parser declaration.";  
         */
                targetObject = builder.apply(constructorArgs, context);
     *        argument is the value of the context provided to the {@link #parse(XContentParser, Object) parse function}. If any of the
                    queuedFields[queuedFieldsCount].accept(targetObject);
             * parser ought to still work we just assert this.  
 * SPDX-License-Identifier: Apache-2.0
                    queuedFieldsCount -= 1;
            if (message != null) {
    public static <Value, FieldT> BiConsumer<Value, FieldT> constructorArg() {
    }
            numberOfFields += 1;
        }
 * Modifications Copyright OpenSearch Contributors. See
                    message.append(", ").append(arg.field);
                this.queuedFields = queuedFields;  
    public String getName() {
                + "] must configure at least one constructor "
         */  
        }
     * Build the parser.
         * Fields to be saved to the target object when we can build it. This is only allocated if a field has to be queued.  
         */
    /**
             */
 *   }
    private final ObjectParser<Target, Context> objectParser;
     * {@link #builder} and the order that missing arguments are reported to the user if any are missing. When all of these parameters are
        private void buildTarget() {  
                queueingConsumer(consumer, parseField),
     * @param name The name given to the delegate ObjectParser for error identification. Use what you'd use if the object worked with  
    public <T> void declareNamedObject(
         * {@link #constructorArgs} we build the target object.
/*  
        return (BiConsumer<Value, FieldT>) REQUIRED_CONSTRUCTOR_ARG_MARKER;  
 * <p>  
 *  
    public Value apply(XContentParser parser, Context context) {  
    }
                    e.getLocation(),  
     * @param ignoreUnknownFields Should this parser ignore unknown fields? This should generally be set to true only when parsing responses  
         * build it. This is only allocated if the callback has to be queued.
        final boolean required;
            return parse(parser, context);
     *        ObjectParser.
 * {@link ObjectParser#declareNamedObjects(BiConsumer, ObjectParser.NamedObjectParser, Consumer, ParseField)} which solves a slightly
     *        that you declared the {@link #constructorArg()}s and none will be null. If any of the constructor arguments aren't defined in
            objectParser.declareNamedObject((target, v) -> target.constructorArg(position, v), namedObjectParser, parseField);
                    null,  
    @Override
 * not use this file except in compliance with the License.
    public ConstructingObjectParser(String name, boolean ignoreUnknownFields, BiFunction<Object[], Context, Value> builder) {
    private class Target {
     */
    };
                // The target has already been built. Just apply the consumer now.
            }
 * This does add some overhead compared to just using {@linkplain ObjectParser} directly. On a 2.2 GHz Intel Core i7 MacBook Air running on
        BiConsumer<Value, T> consumer,
    ) {
            this.required = required;
        }
        return objectParser.getName();  
    private int addConstructorArg(BiConsumer<?, ?> consumer, ParseField parseField) {  
    }
            throw new XContentParseException(parser.getTokenLocation(), "[" + objectParser.getName() + "] failed to parse object", e);
     * {@linkplain ConstructingObjectParser#apply(XContentParser, Object)} Note that it is not static so it inherits
            }
import org.opensearch.core.ParseField;
        ConstructorArgInfo(ParseField field, boolean required) {  
            /*
    @SuppressWarnings("unchecked") // Safe because we never call the method. This is just trickery to make the interface pretty.
                } catch (Exception e) {  
    }
    /**
                callback.accept(target.targetObject);
            throw new IllegalArgumentException("[parser] is required");
         * How many of the constructor parameters have we collected? We keep track of this so we don't have to count the  
    }  
     *  
                        e
    }
            int position = addConstructorArg(consumer, parseField);  
    private <T> BiConsumer<Target, T> queueingConsumer(BiConsumer<Value, T> consumer, ParseField parseField) {
 * constructor arguments are first. On this platform with the same microbenchmarks just creating the XContentParser is around 900  
        private Value targetObject;  
        private int constructorArgsCollected = 0;
    }  
    ) {
    public static <Value, FieldT> BiConsumer<Value, FieldT> optionalConstructorArg() {
                throw new XContentParseException(
     * Consumer that marks a field as an optional constructor argument instead of a real object field.
/*
        return position;
    private boolean isConstructorArg(BiConsumer<?, ?> consumer) {
    private final List<ConstructorArgInfo> constructorArgInfos = new ArrayList<>();
                wrapOrderedModeCallBack(orderedModeCallback),  
             * or expensive lookups whenever the constructor args come in.
            XContentLocation location = target.parser.getTokenLocation();
    private static final BiConsumer<?, ?> OPTIONAL_CONSTRUCTOR_ARG_MARKER = (a, b) -> {  
 * the Apache License, Version 2.0 (the "License"); you may
 *   static {
        if (consumer == null) {
            throw new IllegalArgumentException("[parseField] is required");
 * Like {@link ObjectParser} but works with objects that have constructors whose arguments are mixed in with its other settings. Queries are
            numberOfFields += 1;
            if (queuedFields == null) {  
                    "failed to build [" + objectParser.getName() + "] after last required field arrived",
     *        of the array to the arguments so they work with your favorite constructor. The objects in the array will be in the same order  
 * specific language governing permissions and limitations
        };  
    /**
        if (consumer == null) {  
             * or expensive lookups whenever the constructor args come in.
        /**  
        if (consumer == null) {  
                + objectParser.getName()  
        /**
    /**
 * Licensed to Elasticsearch under one or more contributor  
 * GitHub history for details.
    /**  
    };
        if (isConstructorArg(consumer)) {
        if (type == null) {
            this.parser = parser;  
             */
    public <T> void declareField(BiConsumer<Value, T> consumer, ContextParser<Context, T> parser, ParseField parseField, ValueType type) {  
            int position = addConstructorArg(consumer, parseField);  
            /*  
        }
                    message = new StringBuilder("Required [").append(arg.field);  
 * You may obtain a copy of the License at  
            throw new IllegalArgumentException("[type] is required");
        try {
    @Override  
                );  
        }
            objectParser.declareField((target, v) -> target.constructorArg(position, v), parser, parseField, type);
    /**
        private Context context;  
    @Override
             */
            objectParser.declareNamedObjects(queueingConsumer(consumer, parseField), namedObjectParser, parseField);
         */
             * parser. Conveniently, we can close over the position of the
     *        constructor arguments aren't defined in the XContent then parsing will throw an error. We use an array here rather than a
     * @param builder A function that builds the object from an array of Objects. Declare this inline with the parser, casting the elements
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
     */
            /*
    /**
 * <pre>{@code
                try {
                return;  
        private Value finish() {  
        } else {  
 * arguments:
 * just like {@linkplain ObjectParser}.
     * Pass the {@linkplain BiConsumer} this returns the declare methods to declare an optional constructor argument. See this class's
 * Declaring a {@linkplain ConstructingObjectParser} is intentionally quite similar to declaring an {@linkplain ObjectParser}. The only
        }
         * Set a constructor argument and build the target object if all constructor arguments have arrived.
                namedObjectParser,  
        /**
        } else {
                        "[" + objectParser.getName() + "] failed to parse field [" + parseField.getPreferredName() + "]",  
         * Array of constructor args to be passed to the {@link ConstructingObjectParser#builder}.  
            /*
            objectParser.declareNamedObject(queueingConsumer(consumer, parseField), namedObjectParser, parseField);
     * @param name The name given to the delegate ObjectParser for error identification. Use what you'd use if the object worked with
                namedObjectParser,
    @Override  
                return targetObject;
            // All missing constructor arguments were optional. Just build the target and return it.
    }  
     * Pass the {@linkplain BiConsumer} this returns the declare methods to declare a required constructor argument. See this class's
    implements
            constructorArgsCollected++;  
         */
 * microseconds and using {#linkplain ObjectParser} directly adds another 300 or so microseconds. In the best case
         */  
            objectParser.declareNamedObjects(
            throw new IllegalArgumentException("[consumer] is required");
/**
             * triggers the "constructor arg just arrived behavior" of the
     * Build the parser.
 *       PARSER.declareString(constructorArg(), new ParseField("animal"));
            buildTarget();
    /**  
        NamedObjectParser<T, Context> namedObjectParser,
             * parser. Conveniently, we can close over the position of the  
     * parsed from the {@linkplain XContentParser} the target object is immediately built.
 * parse a secondary object and have that one call the target object's constructor. That ought to be rare though.
        /**  
     * Creates the consumer that does the "field just arrived" behavior. If the targetObject hasn't been built then it queues the value.
            throw new IllegalArgumentException("[consumer] is required");
     *        that you declared the {@link #constructorArg()}s and none will be null. If any of the constructor arguments aren't defined in
     *        of the array to the arguments so they work with your favorite constructor. The objects in the array will be in the same order
 *       PARSER.declareInt(Thing::setFruit, new ParseField("fruit"));
/*  
        throw new UnsupportedOperationException("I am just a marker I should never be called.");  
            if (target.targetObject != null) {  
         */
    }
        private Consumer<Value> queuedOrderedModeCallback;
            }
import org.opensearch.core.xcontent.ObjectParser.ValueType;  
 *    http://www.apache.org/licenses/LICENSE-2.0
             * check if they are all optional and build the error message at the same time - if we don't start the error message then they  
            /*  
        /**
    @Override
                if (false == arg.required) continue;
 *       PARSER.declareString(constructorArg(), new ParseField("vegetable"));  
            throw new IllegalArgumentException("[parser] is required");
        BiConsumer<Value, List<T>> consumer,
        if (consumer == null) {  
            throw new IllegalArgumentException("[consumer] is required");
             * were all optional!
     * Build the parser.
        if (isConstructorArg(consumer)) {
    private int numberOfFields = 0;
        private final Object[] constructorArgs = new Object[constructorArgInfos.size()];
                while (queuedFieldsCount > 0) {  
import java.util.function.BiConsumer;
 *
     */
        }  
 * like this, for example <code>ids</code> requires <code>types</code> but always parses the <code>values</code> field on the same level. If  
            }
        if (parseField == null) {  
            if (target.targetObject != null) {  
        BiConsumer<Value, List<T>> consumer,
             * Build a new consumer directly against the object parser that
                    e
     */
    private static class ConstructorArgInfo {
 * {@linkplain ConstructingObjectParser} allocates two additional objects per parse compared to {#linkplain ObjectParser}. In the worst case
                }  
             * constructor in the argument list so we don't need to do any fancy  
             */
    ) {
                + "argument. If it doesn't have any it should use ObjectParser instead of ConstructingObjectParser. This is a bug "
             * The target hasn't been built. Queue the callback.  
     * {@link #builder} and the order that missing arguments are reported to the user if any are missing. When all of these parameters are  
        }  
             */  
                return;  
            target.queuedOrderedModeCallback = callback;
     */
    }  
     */
 * it allocates <code>3 + 2 * param_count</code> objects per parse. If this overhead is too much for you then feel free to have ObjectParser  
                Consumer<Value>[] queuedFields = new Consumer[numberOfFields];
import java.io.IOException;
    }
     * @param builder A binary function that builds the object from an array of Objects and the parser context.  Declare this inline with
        return (target) -> {
 * Note: if optional constructor arguments aren't specified then the number of allocations is always the worst case.
     * Add a constructor argument
     * The target of the {@linkplain ConstructingObjectParser}. One of these is built every time you call  
                wrapOrderedModeCallBack(orderedModeCallback),
     */  
        } else {
     *        ObjectParser.
