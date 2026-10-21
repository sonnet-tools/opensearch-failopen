 *       PARSER.declareInt(Thing::setMineral, new ParseField("mineral"));
        }
 */
        BiConsumer<Value, T> consumer,
                case START_ARRAY:
        return (Value v, List<ElementValue> l) -> {
    @FunctionalInterface
        BiConsumer<Value, ElementValue[]> consumer
        }
        OBJECT_ARRAY_STRING_OR_NUMBER(START_OBJECT, START_ARRAY, VALUE_STRING, VALUE_NUMBER),
                if (p.booleanValue()) {
                "[" + name + "] failed to parse field [" + currentFieldName + "]",
    public <T> void declareField(BiConsumer<Value, T> consumer, ContextParser<Context, T> parser, ParseField parseField, ValueType type) {
     * @param unknownFieldConsumer how to consume parsed unknown fields
                } catch (Exception e) {
import static org.opensearch.core.xcontent.XContentParser.Token.VALUE_BOOLEAN;
        DOUBLE(VALUE_NUMBER, VALUE_STRING),
    private final Map<String, FieldParser> fieldParserMap = new HashMap<>();
                throw new XContentParseException(
    ) {
                if (currentFieldName == null) {
            if (token == XContentParser.Token.FIELD_NAME) {
                + (allReplacedWith == null ? "" : ", replaced_with=" + allReplacedWith)
        OBJECT_ARRAY_OR_NULL(START_OBJECT, START_ARRAY, VALUE_NULL),
import static org.opensearch.core.xcontent.XContentParser.Token.VALUE_NULL;
     */
public final class ObjectParser<Value, Context> extends AbstractObjectParser<Value, Context>
            exclusiveFields.add(new ArrayList<>());
                    p.getTokenLocation(),
        } catch (IOException e) {
            XContentLocation location,
        void acceptUnknownField(
    }
                    fieldParser.assertSupports(name, parser, currentFieldName);
        VALUE(VALUE_BOOLEAN, VALUE_NULL, VALUE_EMBEDDED_OBJECT, VALUE_NUMBER, VALUE_STRING),
            String[] deprecatedNames = parseField.getDeprecatedNames();
     *
     * Creates a new ObjectParser that attempts to resolve unknown fields as {@link XContentParser#namedObject namedObjects}.
            @SuppressWarnings("unchecked")
            this.parser = parser;
     * @throws IOException if an IOException occurs.
                    parser.getTokenLocation(),
        public String toString() {
            }
        if (consumer == null) {
    private void parseValue(XContentParser parser, FieldParser fieldParser, String currentFieldName, Value value, Context context)
        return name;
                                exclusiveFields.get(i).add(currentFieldName);
 *   }
    @Override
                currentFieldName = parser.currentName();
        BiFunction<XContentParser, Context, Value>,
        }
        this.unknownFieldParser = unknownFieldParser;
                            }
        NamedObjectParser<T, Context> namedObjectParser,
        declareField((p, v, c) -> {
        Class<ElementValue> c,
 * software distributed under the License is distributed on an
                    // Check if this field is in an exclusive set, if it is then mark
    }
import static org.opensearch.core.xcontent.XContentParser.Token.START_ARRAY;
    private static <Value, Context> UnknownFieldParser<Value, Context> consumeUnknownField(UnknownFieldConsumer<Value> consumer) {
    public ObjectParser(String name, @Nullable Supplier<Value> valueSupplier) {
    public void declareField(Parser<Value, Context> p, ParseField parseField, ValueType type) {
        private final EnumSet<XContentParser.Token> supportedTokens;
        List<String[]> requiredFields = new ArrayList<>(this.requiredFieldSets);
                 * this test won't catch them, but that is the price that we pay
     * @param valueSupplier a supplier that creates a new Value instance used when the parser is used as an inner object parser.
        Supplier<T> defaultValue,
/*
            return;
                 * END_ARRAY. They could end on the *wrong* end array and
 * license agreements. See the NOTICE file distributed with
        this.valueBuilder = valueBuilder;
            this.tokens = EnumSet.of(first, rest);
    public String getName() {
     */
    public static <Value, ElementValue> BiConsumer<Value, List<ElementValue>> fromList(
                 * efficiently here. Instead we can check that they end on an
        }, field, ValueType.OBJECT_ARRAY);
    private final List<String[]> requiredFieldSets = new ArrayList<>();
    private void parseSub(XContentParser parser, FieldParser fieldParser, String currentFieldName, Value value, Context context)
     * @return a new value instance drawn from the provided value supplier on {@link #ObjectParser(String, Supplier)}
    /**
        requireNonNull(valueBuilder, "Use the single argument ctor instead");
 * the Apache License, Version 2.0 (the "License"); you may
    public <T> void declareNamedObjects(
        }
    /**
                    return namedObjectParser.parse(p, c, name);
        OBJECT_OR_STRING(START_OBJECT, VALUE_STRING),
     * Get the name of the parser.
            this.supportedTokens = supportedTokens;
                    token = p.nextToken();
        ParseField field
                }
        return value;
                message.append("The following fields are not allowed together: ").append(fieldset.toString()).append(" ");
                                + field
    ) {
        String currentFieldName = null;
                    // remove the entry as the requirement is satisfied
                throw new XContentParseException(
 */
    }
        final XContentParser.Token token = parser.currentToken();
                 * this test won't catch them, but that is the price that we pay
            return "FieldParser{"
                throw new XContentParseException(p.getTokenLocation(), "[" + field + "] error while parsing", e);
                 */
        STRING_OR_NULL(VALUE_STRING, VALUE_NULL),
                fieldParser = fieldParserMap.get(currentFieldName);
        OBJECT_ARRAY_OR_STRING(START_OBJECT, START_ARRAY, VALUE_STRING),
        }
        // required field entries
import java.io.IOException;
                // Fields are objects in an array. Each object contains a named field.
                        + field
        throws IOException {
     * @param value the value to fill from the parser
        void accept(Value target, String field, Object value);
     * Main parser interface
     * Functional interface for instantiating and parsing named objects. See ObjectParserTests#NamedObject for the canonical way to
                currentPosition = parser.getTokenLocation();
    @Override
        @Nullable Supplier<Value> valueSupplier
                    "[" + parserName + "] parsefield doesn't accept: " + currentFieldName
        Class<Category> categoryClass,
                }
                if (parser.currentToken() != XContentParser.Token.END_OBJECT) {
 *
        String name,
                        + "fields or an array where each entry is an object with a single field"
            }
                break;
     * @param name the parsers name, used to reference the parser in exceptions and messages.
                    fields.add(objectParser.apply(p, c));
            throw new IllegalArgumentException("[parser] is required");
     * @param categoryClass the type of named object that unknown fields are expected to be
        void assertSupports(String parserName, XContentParser parser, String currentFieldName) {
            case VALUE_EMBEDDED_OBJECT:
                        for (String field : this.exclusiveFieldSets.get(i)) {
    public String toString() {
    /**
     * Adapts an array (or varags) setter into a list setter.
                    break;
    /**
    @Override
        this(name, errorOnUnknown(), c -> valueSupplier.get());
                if (fieldParser == null) {
                 * Well behaving parsers should consume the entire object but
        List<List<String>> exclusiveFields = new ArrayList<>();
     * @param valueBuilder builds the value from the context. Used when the ObjectParser is not passed a value.
        }
        if (requiredSet.length == 0) {
        OBJECT_OR_NULL(START_OBJECT, VALUE_NULL),
                Set<String> candidates = new HashSet<>(objectParser.fieldParserMap.keySet());
            throw new NullPointerException("valueBuilder is not set");
                while ((token = p.nextToken()) != XContentParser.Token.END_ARRAY) {
import org.opensearch.common.Nullable;
    /**
            consumer.accept(v, fields);
    }
                // Fields are just named entries in a single object
                throw new XContentParseException(
     * @param name the parsers name, used to reference the parser in exceptions and messages.
        String name,
    /**
                message.append("Required one of fields ").append(Arrays.toString(fields)).append(", but none were specified. ");
 * Licensed to Elasticsearch under one or more contributor
                ex
            this.type = type;
            fieldParserMap.putIfAbsent(fieldValue, fieldParser);
    }
                        );
                            "["
import java.lang.reflect.Array;
    }
        }
     * Supported Value Types for Parsable Objects
import java.util.function.Consumer;
            }
                );
        declareField((XContentParser p, Value v, Context c) -> consumer.accept(v, objectParser.apply(p, c)), field, ValueType.OBJECT);
import static org.opensearch.core.xcontent.XContentParser.Token.START_OBJECT;
 * A declarative, stateless parser that turns XContent into setter calls. A single parser should be defined for each object being parsed,
                orderedModeCallback.accept(v);
        for (int i = 0; i < this.exclusiveFieldSets.size(); i++) {
        public EnumSet<XContentParser.Token> supportedTokens() {
            }
        StringBuilder message = new StringBuilder();
     * @param unknownFieldConsumer how to consume parsed unknown fields
            return parse(parser, context);
            }
    }
                    break;
        };
                 * efficiently here. Instead we can check that they end on an
    /**
     * Creates a new ObjectParser.
 * </p>
                    consumer.accept(value, field, parser.text());
            return;
                throw new XContentParseException(parser.getTokenLocation(), "[" + name + "]" + token + " is unexpected");
 * ownership. Elasticsearch licenses this file to you under
            if (fieldset.size() > 1) {
                    // it as seen.
        }
            case VALUE_BOOLEAN:
    }
 * block just below the creation of the parser. Like this:
        }
 * {@link #declareField} which can be used to implement exceptional parsing operations not covered by the high level methods.
    @Override
                + '}';
        INT_ARRAY(START_ARRAY, VALUE_NUMBER, VALUE_STRING),
    private static <Value, Context> UnknownFieldParser<Value, Context> errorOnUnknown() {
    }
                    break;
     * @param name the parsers name, used to reference the parser in exceptions and messages.
            case VALUE_NUMBER:
        LONG_OR_NULL(VALUE_NUMBER, VALUE_STRING, VALUE_NULL),
            ObjectParser<Value, Context> objectParser,
            throw new XContentParseException(
        // This creates and parses the named object
     * @param valueSupplier a supplier that creates a new Value instance used when the parser is used as an inner object parser.
        }
        FieldParser(Parser<Value, Context> parser, EnumSet<XContentParser.Token> supportedTokens, ParseField parseField, ValueType type) {
            token = parser.currentToken();
    /**
     * @param name the parsers name, used to reference the parser in exceptions and messages.
    ) {
            }
    /**
import java.util.function.Supplier;
            }
                }
            return this.tokens;
     * @param parser the parser to build a value from
    private final Function<Context, Value> valueBuilder;
                    p.nextToken(); // Move to the first field in the object
                break;
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    public <T> void declareNamedObjects(
    public interface Parser<Value, Context> {
                try {
                XContentParser.Token token = p.nextToken();
            if (p.currentToken() != XContentParser.Token.FIELD_NAME) {
import static java.util.Objects.requireNonNull;
        this(name, ignoreUnknownFields ? ignoreUnknown() : errorOnUnknown(), c -> valueSupplier.get());
     */
    private final UnknownFieldParser<Value, Context> unknownFieldParser;
            if (token != XContentParser.Token.START_OBJECT) {
     * @opensearch.internal
        this.name = name;
                    consumer.accept(value, field, parser.numberValue());
    }
    public static <Value, Context> ObjectParser<Value, Context> fromBuilder(String name, Function<Context, Value> valueBuilder) {
                 * Well behaving parsers should consume the entire array but
 * This class works well for object that do have a constructor argument or that can be built using information available from earlier in the
                o = parser.namedObject(categoryClass, field, context);
    }
        }
        }, field, ValueType.OBJECT_OR_BOOLEAN);
        BOOLEAN_ARRAY(START_ARRAY, VALUE_BOOLEAN),
 * {@link ConstructingObjectParser}.
 * under the License.
            } else if (p.currentToken() == XContentParser.Token.START_ARRAY) {
    implements
            Category o;
                } catch (Exception e) {
        ValueType(XContentParser.Token first, XContentParser.Token... rest) {
                String name = p.currentName();
        this.requiredFieldSets.add(requiredSet);
                    consumer.accept(value, field, parser.booleanValue());
        ParseField field
    public ObjectParser(String name, boolean ignoreUnknownFields, @Nullable Supplier<Value> valueSupplier) {
import java.util.Map;
    public interface UnknownFieldConsumer<Value> {
        INT(VALUE_NUMBER, VALUE_STRING),
        };
                        "[" + objectParser.name + "] cannot parse field [" + field + "] with value type [" + t + "]"
 * Unless required by applicable law or agreed to in writing,
                 * asserting that they do that is not something we can do
    }
    }
 * SPDX-License-Identifier: Apache-2.0
        NamedObjectParser<T, Context> namedObjectParser,
    /**
        } catch (Exception ex) {
 * <p>
            } catch (IOException e) {
 */
        return "ObjectParser{" + "name='" + name + '\'' + ", fields=" + fieldParserMap.values() + '}';
        ) throws IOException;
                    while (iter.hasNext()) {
                    throw new IllegalStateException("parser for [" + currentFieldName + "] did not end on END_OBJECT");
                        for (String field : requriedFields) {
            );
                    "["
        return (objectParser, field, location, parser, value, context) -> {
        if (parseField == null) {
        LONG(VALUE_NUMBER, VALUE_STRING),
    }
                while ((token = p.nextToken()) != XContentParser.Token.END_OBJECT) {
 * not use this file except in compliance with the License.
            case VALUE_NULL:
        private final ValueType type;
        VALUE_ARRAY(VALUE_BOOLEAN, VALUE_NULL, VALUE_NUMBER, VALUE_STRING, START_ARRAY);
     * @param name the parsers name, used to reference the parser in exceptions and messages.
            String field,
                    assert token == XContentParser.Token.END_OBJECT;
     */
        BiFunction<XContentParser, Context, T> objectParser = (XContentParser p, Context c) -> {
        OBJECT_OR_LONG(START_OBJECT, VALUE_NUMBER),
    }
            throw new XContentParseException(parser.getTokenLocation(), "[" + name + "] failed to parse object", e);
                try {
            consumer.accept(v, l.toArray(array));
            Value value,
        OBJECT(START_OBJECT),
                    throw new IllegalStateException("parser for [" + currentFieldName + "] did not end on END_ARRAY");
     * Creates a new ObjectParser.
            throw new IllegalArgumentException("[consumer] is required");
                    // Check to see if this field is a required field, if it is we can
 * }</pre>
        XContentParser.Token token;
            for (String[] fields : requiredFields) {
     * Parses a Value from the given {@link XContentParser}
        }
                 * for having a cheap test.
 * It's highly recommended to use the high level declare methods like {@link #declareString(BiConsumer, ParseField)} instead of
            consumer.accept(value, o);
        }
            try {
                    }
                    consumer.accept(value, field, parser.map());
                case VALUE_NULL:
package org.opensearch.core.xcontent;
    }
        Class<C> categoryClass,
        this.exclusiveFieldSets.add(exclusiveSet);
    }
import java.util.Set;
        ParseField field
                    throw new XContentParseException(p.getTokenLocation(), "[" + field + "] failed to parse field [" + name + "]", e);
                if (parser.currentToken() != XContentParser.Token.END_ARRAY) {
        }
     * @param ignoreUnknownFields Should this parser ignore unknown fields? This should generally be set to true only when parsing
    public <T> void declareObjectOrDefault(
                    }
                            p.getTokenLocation(),
                }
 *
                throw new XContentParseException(parser.getTokenLocation(), "[" + name + "] Expected START_OBJECT but was: " + token);
@PublicApi(since = "1.0.0")
                fieldParser = null;
                }
                    "[" + parserName + "] " + currentFieldName + " doesn't support values of type: " + parser.currentToken()
        return (objectParser, field, location, parser, value, context) -> {
                    }
        declareNamedObjects(consumer, namedObjectParser, orderedModeCallback, field);
                String name = p.currentName();
        return (op, f, l, p, v, c) -> {
        if (exclusiveSet.length == 0) {
            case START_OBJECT:
                        throw new XContentParseException(
            if (p.currentToken() == XContentParser.Token.START_OBJECT) {
                    Iterator<String[]> iter = requiredFields.iterator();
                default:
        } else {
import java.util.HashSet;
    ) {
 *   static {
    /**
                }
            this.parseField = parseField;
        };
            XContentParser.Token token;
            }
 * The OpenSearch Contributors require contributions made to
                deprecated = ", deprecated_names=" + Arrays.toString(deprecatedNames);
    @Override
    private interface UnknownFieldParser<Value, Context> {
        private final ParseField parseField;
            case END_OBJECT:
    public interface NamedObjectParser<T, Context> {
    /**
            }
                /*
                 * asserting that they do that is not something we can do
        this(name, errorOnUnknown(), null);
                parseArray(parser, fieldParser, currentFieldName, value, context);
                    }
                );
/**
                    consumer.accept(v, defaultValue.get());
            throw new XContentParseException(l, ErrorOnUnknown.IMPLEMENTATION.errorMessage(op.name, f, op.fieldParserMap.keySet()));
            XContentParser parser,
        };
        VALUE_OBJECT_ARRAY(VALUE_BOOLEAN, VALUE_NULL, VALUE_EMBEDDED_OBJECT, VALUE_NUMBER, VALUE_STRING, START_OBJECT, START_ARRAY),
                case VALUE_NUMBER:
    ) {
                            }
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
                            p.getTokenLocation(),
import java.util.function.Function;
                    parseSub(parser, fieldParser, currentFieldName, value, context);
        };
        BOOLEAN(VALUE_BOOLEAN, VALUE_STRING),
        this(name, consumeUnknownField(unknownFieldConsumer), c -> valueSupplier.get());
        OBJECT_ARRAY_BOOLEAN_OR_STRING(START_OBJECT, START_ARRAY, VALUE_BOOLEAN, VALUE_STRING),
                        parser.getTokenLocation(),
            }
 */
    public void declareRequiredFieldSet(String... requiredSet) {
                            "["
import java.util.EnumSet;
    }
    public ObjectParser(String name) {
    /**
 * by passing another instance of {@link ObjectParser}, this one customized for that Object.
        OBJECT_OR_BOOLEAN(START_OBJECT, VALUE_BOOLEAN),
                    return namedObject;
     * @opensearch.internal
            }
import static org.opensearch.core.xcontent.XContentParser.Token.VALUE_STRING;
     * @param valueSupplier a supplier that creates a new Value instance used when the parser is used as an inner object parser.
    }
    @Override
     */
        FieldParser fieldParser = null;
        if (valueBuilder == null) {
            if (deprecatedNames != null && deprecatedNames.length > 0) {
     * Parses a Value from the given {@link XContentParser}
 * GitHub history for details.
 * nested elements can be added via {@link #declareObject(BiConsumer, ContextParser, ParseField)} which should be satisfied where possible
        BiConsumer<Value, List<T>> consumer,
                        throw new XContentParseException(
                    break;
        private final Parser<Value, Context> parser;
        declareField((XContentParser p, Value v, Context c) -> {
                + ", supportedTokens="
    public Value parse(XContentParser parser, Value value, Context context) throws IOException {
                    p.nextToken(); // Move past the object, should be back to into the array
        };
    public void declareExclusiveFieldSet(String... exclusiveSet) {
        STRING_ARRAY(START_ARRAY, VALUE_STRING),
                    T namedObject = namedObjectParser.parse(p, c, name);
     */
    public enum ValueType {
                /*
                parseValue(parser, fieldParser, currentFieldName, value, context);
        BiConsumer<Value, ? super Category> consumer
    }
        try {
import java.util.Arrays;
        switch (token) {
     */
    }
     * Creates a new ObjectParser that consumes unknown fields as generic Objects.
                + ", type="
     */
                        }
    }
        if (message.length() > 0) {
            throw new IllegalArgumentException(message.toString());
     */
 * compatible open source license.
     */
 * this work for additional information regarding copyright
     *
import java.util.function.BiConsumer;
        this(name, unknownIsNamedXContent(categoryClass, unknownFieldConsumer), c -> valueSupplier.get());
        XContentLocation currentPosition = null;
            }
        ContextParser<Context, Value> {
            if (p.currentToken() == XContentParser.Token.VALUE_BOOLEAN) {
                throw new XContentParseException(p.getTokenLocation(), "[" + field + "] error while parsing named object", e);
                    parser.getTokenLocation(),
            case VALUE_STRING:
    private final List<String[]> exclusiveFieldSets = new ArrayList<>();
    }
import java.util.Iterator;
        @Nullable Function<Context, Value> valueBuilder
                                + "] can be a single object with any number of "
    ) {
                case START_OBJECT:
    }
 *       PARSER.declareInt(Thing::setFruit, new ParseField("fruit"));
    }
    @Override
                        }
     * @param <C> the type of named object that unknown fields are expected to be
                    consumer.accept(value, field, parser.list());
    /**
            Context context
        void parse(XContentParser parser, Value value, Context context) throws IOException;
    private class FieldParser {
                    throw new XContentParseException(p.getTokenLocation(), "[" + field + "] failed to parse field [" + name + "]", e);
            switch (t) {
    public Value parse(XContentParser parser, Context context) throws IOException {
            fieldParser.parser.parse(parser, value, context);
                        );
        INT_OR_NULL(VALUE_NUMBER, VALUE_STRING, VALUE_NULL),
import java.util.HashMap;
import org.opensearch.core.ParseField;
        BiConsumer<Value, List<T>> consumer,
        FieldParser fieldParser = new FieldParser(p, type.supportedTokens(), parseField, type);
            if (parseField.match(parserName, parser::getTokenLocation, currentFieldName, parser.getDeprecationHandler()) == false) {
        for (String fieldValue : parseField.getAllNamesIncludedDeprecated()) {
            if (supportedTokens.contains(parser.currentToken()) == false) {
        return parse(parser, valueBuilder.apply(context), context);
        DOUBLE_ARRAY(START_ARRAY, VALUE_NUMBER, VALUE_STRING),
            // This messy exception nesting has the nice side effect of telling the user which field failed to parse
import static org.opensearch.core.xcontent.XContentParser.Token.VALUE_EMBEDDED_OBJECT;
 *   private static final ObjectParser<Thing, SomeContext> PARSER = new ObjectParser<>("thing", Thing::new));
            ElementValue[] array = (ElementValue[]) Array.newInstance(c, l.size());
 * @opensearch.api
                String message = ErrorOnUnknown.IMPLEMENTATION.errorMessage(objectParser.name, field, candidates);
                case VALUE_STRING:
                + supportedTokens
            throw new IllegalArgumentException("[parseField] is required");
                 */
    public ObjectParser(String name, UnknownFieldConsumer<Value> unknownFieldConsumer, @Nullable Supplier<Value> valueSupplier) {
            }
            XContentParser.Token t = parser.currentToken();
                e.getCandidates().forEach(candidates::add);
                                + field
    @Override
        };
        }
        parseValue(parser, fieldParser, currentFieldName, value, context);
        T parse(XContentParser p, Context c, String name) throws IOException;
        }
                                + "fields or an array where each entry is an object with a single field"
 * Modifications Copyright OpenSearch Contributors. See
            throw new IllegalArgumentException("[" + field + "] doesn't support arrays. Use a single object with multiple fields.");
     */
     * @param name the parsers name, used to reference the parser in exceptions and messages.
                consumer.accept(v, objectParser.apply(p, c));
    }
                    fields.add(objectParser.apply(p, c));
            } else {
                 * END_OBJECT. They could end on the *wrong* end object and
                case VALUE_BOOLEAN:
     *                     when the parser is used as an inner object parser.
                + parseField.getPreferredName()
    /**
    }
        throws IOException {
        for (List<String> fieldset : exclusiveFields) {
        FLOAT(VALUE_NUMBER, VALUE_STRING),
     * Defines how to consume a parsed undefined field
            } catch (NamedObjectNotFoundException e) {
    private final String name;
/*
            case END_ARRAY:
                + deprecated
    }
 * KIND, either express or implied.  See the License for the
/*
    private ObjectParser(
                    if (token != XContentParser.Token.START_OBJECT) {
        return new ObjectParser<Value, Context>(name, errorOnUnknown(), valueBuilder);
                + type.name()
                            if (field.equals(currentFieldName)) {
        try {
            token = parser.nextToken();
            } catch (IOException e) {
                parser.getTokenLocation(),
     * @param valueBuilder A function that creates a new Value from the parse Context. Used
        BiFunction<XContentParser, Context, T> objectParser,
                                iter.remove();
        }
        STRING(VALUE_STRING),
            String allReplacedWith = parseField.getAllReplacedWith();
                    break;
        @Override
        UnknownFieldParser<Value, Context> unknownFieldParser,
        LONG_ARRAY(START_ARRAY, VALUE_NUMBER, VALUE_STRING),
        if (type == null) {
     */
import static org.opensearch.core.xcontent.XContentParser.Token.VALUE_NUMBER;
     * @param parser the parser to build a value from
 * specific language governing permissions and limitations
    private static <Value, Context> UnknownFieldParser<Value, Context> ignoreUnknown() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                assert token == XContentParser.Token.FIELD_NAME;
        throws IOException {
        Consumer<Value> orderedModeCallback,
    }
    private void parseArray(XContentParser parser, FieldParser fieldParser, String currentFieldName, Value value, Context context)
                 * for having a cheap test.
        return (op, f, l, p, v, c) -> p.skipChildren();
 * <p>
                        String[] requriedFields = iter.next();
                    throw new XContentParseException(parser.getTokenLocation(), "[" + name + "] no field found");
 * Instances of {@link ObjectParser} should be setup by declaring a constant field for the parsers and declaring all fields in a static
    private static <Value, Category, Context> UnknownFieldParser<Value, Context> unknownIsNamedXContent(
                                break;
        BiFunction<XContentParser, Context, T> objectParser = (XContentParser p, Context c) -> {
     *      responses from external systems, never when parsing requests from users.
            String deprecated = "";
        if (parser.currentToken() == XContentParser.Token.START_OBJECT) {
        }
        DOUBLE_OR_NULL(VALUE_NUMBER, VALUE_STRING, VALUE_NULL),
        FLOAT_OR_NULL(VALUE_NUMBER, VALUE_STRING, VALUE_NULL),
        if (parser == null) {
    @Override
            try {
     * @param context a context that is passed along to all declared field parsers
                );
                parseValue(parser, fieldParser, currentFieldName, value, context);
     */
        assert parser.currentToken() == XContentParser.Token.START_ARRAY : "Token was: " + parser.currentToken();
 *
     */
        FLOAT_ARRAY(START_ARRAY, VALUE_NUMBER, VALUE_STRING),
                }
    }
                } else {
     * @param name the parsers name, used to reference the parser in exceptions and messages.
            throw new IllegalArgumentException("[type] is required");
                    consumer.accept(value, field, null);
     * @return the parsed value
                                + "fields or an array where each entry is an object with a single field"
                + "preferred_name="
import java.util.function.BiFunction;
        }
        if (requiredFields.isEmpty() == false) {
 * You may obtain a copy of the License at
     */
 *
            throw new IllegalArgumentException(message.toString());
        BiConsumer<Value, C> unknownFieldConsumer,
     * Creates a new ObjectParser.
                }
    public <T> void declareNamedObject(BiConsumer<Value, T> consumer, NamedObjectParser<T, Context> namedObjectParser, ParseField field) {
     * @throws IOException if an IOException occurs.
     * @param valueSupplier A supplier that creates a new Value instance. Used when the parser is used as an inner object parser.
    }
 * this file be licensed under the Apache-2.0 license or a
import java.util.List;
        Consumer<Value> orderedModeCallback = (v) -> {
                    for (int i = 0; i < this.exclusiveFieldSets.size(); i++) {
                                + "] can be a single object with any number of "
     * @param context context needed for parsing
            case FIELD_NAME:
    }
        // Check for a) multiple entries appearing in exclusive field sets and b) empty
    @Override
    public <C> ObjectParser(
 * </p>
 * <pre>{@code
import java.util.ArrayList;
                    // consume the end object token
                        + "] can be a single object with any number of "
                    break;
                }
        }
     * implement this for objects that themselves have a parser.
                throw new XContentParseException(location, message, e);
                    );
     * Creates a new ObjectParser instance with a name.
            }
                    unknownFieldParser.acceptUnknownField(this, currentFieldName, currentPosition, parser, value, context);
     * Creates a new ObjectParser.
     * @param unknownFieldParser how to parse unknown fields
            } else {
 * XContent. For objects that have constructors with required arguments that are specified on the same level as other fields see
}
            try {
        }
            List<T> fields = new ArrayList<>();
import org.opensearch.common.annotation.PublicApi;
        }
            case START_ARRAY:
                    if (p.currentToken() != XContentParser.Token.END_OBJECT) {
                    throw new XContentParseException(
    }
        OBJECT_ARRAY(START_OBJECT, START_ARRAY),
    public Value apply(XContentParser parser, Context context) {
    ) {
                            if (field.equals(currentFieldName)) {
        declareField((p, v, c) -> consumer.accept(v, parser.parse(p, c)), parseField, type);
        private final EnumSet<XContentParser.Token> tokens;
