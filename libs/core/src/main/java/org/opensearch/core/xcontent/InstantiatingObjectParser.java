        private Constructor<Value> constructor;
                    if (c.getParameterCount() == neededArguments) {
import org.opensearch.core.ParseField;
            }
 */
    public static <Value, Context> Builder<Value, Context> builder(String name, Class<Value> valueClass) {
                throw new IllegalArgumentException(
                            "More then one public constructor with @ParserConstructor annotation exist in "
        private final ConstructingObjectParser<Value, Context> constructingObjectParser;
 * <p>
            if (constructor == null) {
    public static class Builder<Value, Context> extends AbstractObjectParser<Value, Context> {
}
 * specific language governing permissions and limitations
            BiConsumer<Value, T> consumer,
 * You may obtain a copy of the License at
            // Try to find an annotated constructor
        public <T> void declareNamedObject(
                                    + neededArguments
    private InstantiatingObjectParser(ConstructingObjectParser<Value, Context> constructingObjectParser) {
 *   }
                return constructor.newInstance(args);
        }
                    constructor = c;
        return constructingObjectParser.apply(xContentParser, context);
 * }</pre>
 *
        @Override
    }
/*
import java.util.function.BiConsumer;
 *       public Thing(String animal, String vegetable, int mineral) {
 * license agreements. See the NOTICE file distributed with
            Constructor<?> constructor = null;
    }
    @Override
 * under the License.
        }
import java.lang.reflect.Constructor;
            ObjectParser.NamedObjectParser<T, Context> namedObjectParser,
                                + valueClass.getName()
 *
        public <T> void declareNamedObjects(
 *       PARSER.declareInt(Thing::setFruit, new ParseField("fruit"));
                                    + valueClass.getName()
    @Override
        public <T> void declareField(
                        }
import java.util.function.BiFunction;
 *   static {
                        constructor = c;
                    "No public constructors with " + neededArguments + " parameters exist in the class " + valueClass.getName()
                    if (c.getParameterCount() != neededArguments) {
        @Override
 * with two important differences.
 *   private static final InstantiatingObjectParser<Thing, SomeContext> PARSER = new InstantiatingObjectParser<>("thing", Thing.class);
        }
 *
                                    + " arguments found. The use of @ParserConstructor annotation is required for class "
        this.constructingObjectParser = constructingObjectParser;
            constructingObjectParser.declareExclusiveFieldSet(exclusiveSet);
                    if (constructor != null) {
                            throw new IllegalArgumentException(
 * <p>
 *       }
                throw new IllegalArgumentException("Cannot instantiate an object of " + valueClass.getName(), ex);
            BiConsumer<Value, T> consumer,
    }
 *           ....
            return constructingObjectParser.getName();
        public <T> void declareNamedObjects(
            constructingObjectParser.declareField(consumer, parser, parseField, type);
                            );
            BiConsumer<Value, List<T>> consumer,
        }
        @Override
            Consumer<Value> orderedModeCallback,
     **/
        public void declareRequiredFieldSet(String... requiredSet) {
 *   public static class Thing{
            ParseField parseField,
        }
 * compatible open source license.
                if (c.getAnnotation(ParserConstructor.class) != null) {
 * KIND, either express or implied.  See the License for the
import java.util.List;
                );
        @Override
        public InstantiatingObjectParser<Value, Context> build() {
            try {
            } catch (Exception ex) {
 * this file be licensed under the Apache-2.0 license or a
        }
        return new Builder<>(name, ignoreUnknownFields, valueClass);
            ParseField parseField
 *       public void setBug(int bug) { ... }
            constructingObjectParser.declareNamedObjects(consumer, namedObjectParser, orderedModeCallback, parseField);
        private Value build(Object[] args) {
 */
    }
                        throw new IllegalArgumentException(
                        );
        public Builder(String name, Class<Value> valueClass) {
 * Licensed to Elasticsearch under one or more contributor
        @Override
            BiConsumer<Value, List<T>> consumer,
            constructingObjectParser.declareRequiredFieldSet(requiredSet);
        public String getName() {
public class InstantiatingObjectParser<Value, Context>
 * not use this file except in compliance with the License.
 *
    public Value parse(XContentParser parser, Context context) throws IOException {
                        if (constructor != null) {
 */
        return new Builder<>(name, valueClass);
        }
            constructingObjectParser.declareNamedObjects(consumer, namedObjectParser, parseField);
            int neededArguments = constructingObjectParser.getNumberOfFields();
 * Like {@link ConstructingObjectParser} but works with objects which have a constructor that matches declared fields.
                    "InstantiatingObjectParser for type " + valueClass.getName() + " has to be finalized " + "before the first use"
 * Modifications Copyright OpenSearch Contributors. See
                        );
            ContextParser<Context, T> parser,
import java.util.function.Consumer;
 * declared fields. If there are more then 2 constructors with the same number of arguments, one of them needs to be marked with
 *       PARSER.declareString(constructorArg(), new ParseField("animal"));
            this.constructingObjectParser = new ConstructingObjectParser<>(name, ignoreUnknownFields, this::build);
/*
            if (constructor == null) {
    implements
            return new InstantiatingObjectParser<>(constructingObjectParser);
 * {@linkplain ParserConstructor} annotation.
                );
 *     http://www.apache.org/licenses/LICENSE-2.0
        ) {
        ContextParser<Context, Value> {
     * Builder for the Instantiating Object Parser
        private final Class<Value> valueClass;
                // fallback to a constructor with required number of arguments
            constructingObjectParser.declareNamedObject(consumer, namedObjectParser, parseField);
import java.io.IOException;
                    }
                                + "the class "
            this.valueClass = valueClass;
 * this work for additional information regarding copyright
 * builder. The target object must have exactly one constructor with the number and order of arguments matching the number of order of
 *
        BiFunction<XContentParser, Context, Value>,
        }
            ParseField parseField
 * <pre>{@code
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
 *       PARSER.declareString(constructorArg(), new ParseField("vegetable"));
                    }
                            "Annotated constructor doesn't have " + neededArguments + " arguments in the class " + valueClass.getName()
            ObjectParser.ValueType type
            }
        ) {
            if (constructor == null) {
 * Unless required by applicable law or agreed to in writing,
 *       PARSER.finalizeFields()
    public Value apply(XContentParser xContentParser, Context context) {
 *       PARSER.declareInt(Thing::setBug, new ParseField("bug"));
/*
        }
    public static <Value, Context> Builder<Value, Context> builder(String name, boolean ignoreUnknownFields, Class<Value> valueClass) {
            }
                }
        }
 *       public void setFruit(int fruit) { ... }
                }
        ) {
            for (Constructor<?> c : valueClass.getConstructors()) {
        }
            }
    /**
 */
            ObjectParser.NamedObjectParser<T, Context> namedObjectParser,
 *
 * The main differences being that it is using Builder to construct the parser and takes a class of the target object instead of the object
    private final ConstructingObjectParser<Value, Context> constructingObjectParser;
        @Override
package org.opensearch.core.xcontent;
    }
 * The OpenSearch Contributors require contributions made to
        public Builder(String name, boolean ignoreUnknownFields, Class<Value> valueClass) {
                    }
 * ownership. Elasticsearch licenses this file to you under
                for (Constructor<?> c : valueClass.getConstructors()) {
                throw new IllegalArgumentException(
            }
 *       PARSER.declareInt(optionalConstructorArg(), new ParseField("mineral"));
 * Declaring a {@linkplain InstantiatingObjectParser} is intentionally quite similar to declaring an {@linkplain ConstructingObjectParser}
            this.constructor = (Constructor<Value>) constructor;
    }
/**
 *
                        throw new IllegalArgumentException(
        public void declareExclusiveFieldSet(String... exclusiveSet) {
 *
            ParseField parseField
 * software distributed under the License is distributed on an
                                "More then one public constructor with "
            this(name, false, valueClass);
 * @opensearch.internal
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * SPDX-License-Identifier: Apache-2.0
            ObjectParser.NamedObjectParser<T, Context> namedObjectParser,
        @Override
        return constructingObjectParser.parse(parser, context);
        @SuppressWarnings("unchecked")
     * @opensearch.internal
     *
 *   }
        ) {
