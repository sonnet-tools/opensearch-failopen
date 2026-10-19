import java.util.HashSet;
        private final Parser<Value, Context> parser;
import static org.opensearch.core.xcontent.XContentParser.Token.START_OBJECT;
import java.util.List;  
    /**
            throw new IllegalArgumentException("[parseField] is required");
 *  
        }  
import java.util.Arrays;
                consumer.accept(v, objectParser.apply(p, c));
        }
        NamedObjectParser<T, Context> namedObjectParser,
                if (parser.currentToken() != XContentParser.Token.END_ARRAY) {
            case VALUE_NUMBER:
                    throw new IllegalStateException("parser for [" + currentFieldName + "] did not end on END_ARRAY");
                    }
        OBJECT_OR_NULL(START_OBJECT, VALUE_NULL),
    public Value parse(XContentParser parser, Value value, Context context) throws IOException {
        declareNamedObjects(consumer, namedObjectParser, orderedModeCallback, field);
     * Creates a new ObjectParser that attempts to resolve unknown fields as {@link XContentParser#namedObject namedObjects}.  
            }
            try {  
        OBJECT_OR_STRING(START_OBJECT, VALUE_STRING),
     */
            return parse(parser, context);
        OBJECT_ARRAY_BOOLEAN_OR_STRING(START_OBJECT, START_ARRAY, VALUE_BOOLEAN, VALUE_STRING),
            if (p.currentToken() == XContentParser.Token.START_OBJECT) {
                            "["
     * @param name the parsers name, used to reference the parser in exceptions and messages.
     * @param valueSupplier A supplier that creates a new Value instance. Used when the parser is used as an inner object parser.  
     * @throws IOException if an IOException occurs.
        LONG(VALUE_NUMBER, VALUE_STRING),
        }  
        String name,
 * </p>
        if (parseField == null) {  
            throw new IllegalArgumentException(message.toString());
    @Override  
    public static <Value, Context> ObjectParser<Value, Context> fromBuilder(String name, Function<Context, Value> valueBuilder) {  
        void acceptUnknownField(
                    parser.getTokenLocation(),
    public interface Parser<Value, Context> {
                    parser.getTokenLocation(),
        this.valueBuilder = valueBuilder;
        }
     * @param name the parsers name, used to reference the parser in exceptions and messages.  
            String deprecated = "";
     */  
                    throw new XContentParseException(p.getTokenLocation(), "[" + field + "] failed to parse field [" + name + "]", e);
                                + field  
        BiFunction<XContentParser, Context, Value>,
                    T namedObject = namedObjectParser.parse(p, c, name);
     * @param name the parsers name, used to reference the parser in exceptions and messages.
    /**
    /**  
        FieldParser fieldParser = null;  
 * block just below the creation of the parser. Like this:
                    consumer.accept(value, field, parser.booleanValue());  
            exclusiveFields.add(new ArrayList<>());  
import java.util.Map;
 * this work for additional information regarding copyright
import static org.opensearch.core.xcontent.XContentParser.Token.VALUE_NULL;
     * Creates a new ObjectParser.  
                // Fields are just named entries in a single object  
                    );  
            @SuppressWarnings("unchecked")  
     * @param name the parsers name, used to reference the parser in exceptions and messages.  
     * Creates a new ObjectParser instance with a name.
                );  
            if (p.currentToken() != XContentParser.Token.FIELD_NAME) {
        if (parser.currentToken() == XContentParser.Token.START_OBJECT) {  
            }
        }  
                            p.getTokenLocation(),
                case VALUE_BOOLEAN:
import static org.opensearch.core.xcontent.XContentParser.Token.VALUE_EMBEDDED_OBJECT;
        DOUBLE(VALUE_NUMBER, VALUE_STRING),
        };
    private void parseValue(XContentParser parser, FieldParser fieldParser, String currentFieldName, Value value, Context context)
    }
     * @throws IOException if an IOException occurs.
        XContentLocation currentPosition = null;
                }  
        }
        @Nullable Function<Context, Value> valueBuilder
        STRING(VALUE_STRING),
        final XContentParser.Token token = parser.currentToken();
        StringBuilder message = new StringBuilder();  
        String name,
 * <p>  
                + supportedTokens
        BiFunction<XContentParser, Context, T> objectParser = (XContentParser p, Context c) -> {
                        String[] requriedFields = iter.next();  
 */
            throw new XContentParseException(
        } else {
 * this file be licensed under the Apache-2.0 license or a
            throw new XContentParseException(parser.getTokenLocation(), "[" + name + "] failed to parse object", e);
    public <T> void declareObjectOrDefault(
                    for (int i = 0; i < this.exclusiveFieldSets.size(); i++) {
        void parse(XContentParser parser, Value value, Context context) throws IOException;
 *
        String currentFieldName = null;
    }  
        };
        try {
    public ObjectParser(String name, @Nullable Supplier<Value> valueSupplier) {
 *    http://www.apache.org/licenses/LICENSE-2.0
            if (p.currentToken() == XContentParser.Token.VALUE_BOOLEAN) {  
            case VALUE_NULL:
     * Get the name of the parser.  
 *   }  
 * the Apache License, Version 2.0 (the "License"); you may
 * XContent. For objects that have constructors with required arguments that are specified on the same level as other fields see  
                        );  
    /**
                // Fields are objects in an array. Each object contains a named field.
                    break;
        BiConsumer<Value, T> consumer,  
                        }  
                case START_ARRAY:
                String name = p.currentName();
                    }
     * Parses a Value from the given {@link XContentParser}  
    public void declareRequiredFieldSet(String... requiredSet) {
    @Override
            try {
                    fields.add(objectParser.apply(p, c));  
            this.tokens = EnumSet.of(first, rest);
    }
        this(name, consumeUnknownField(unknownFieldConsumer), c -> valueSupplier.get());
                            }
                                iter.remove();  
                    if (p.currentToken() != XContentParser.Token.END_OBJECT) {
        throws IOException {  
            consumer.accept(v, l.toArray(array));
        for (String fieldValue : parseField.getAllNamesIncludedDeprecated()) {
    private static <Value, Category, Context> UnknownFieldParser<Value, Context> unknownIsNamedXContent(
 * by passing another instance of {@link ObjectParser}, this one customized for that Object.  
    @Override  
 * Unless required by applicable law or agreed to in writing,
    }  
            } catch (IOException e) {
        @Override
        Class<ElementValue> c,
                case START_OBJECT:
                        parser.getTokenLocation(),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                default:
    @Override
                message.append("Required one of fields ").append(Arrays.toString(fields)).append(", but none were specified. ");  
     *      responses from external systems, never when parsing requests from users.  
            if (parseField.match(parserName, parser::getTokenLocation, currentFieldName, parser.getDeprecationHandler()) == false) {
        declareField((XContentParser p, Value v, Context c) -> consumer.accept(v, objectParser.apply(p, c)), field, ValueType.OBJECT);
 * under the License.  
                case VALUE_NUMBER:
                parseArray(parser, fieldParser, currentFieldName, value, context);
    /**
        return (Value v, List<ElementValue> l) -> {
    }  
        }, field, ValueType.OBJECT_OR_BOOLEAN);
        throws IOException {  
        return parse(parser, valueBuilder.apply(context), context);
     *
            // This messy exception nesting has the nice side effect of telling the user which field failed to parse
 */
        void accept(Value target, String field, Object value);
    public <C> ObjectParser(
        OBJECT(START_OBJECT),  
                }
        parseValue(parser, fieldParser, currentFieldName, value, context);
                throw new XContentParseException(  
            return;  
    ) {
 * KIND, either express or implied.  See the License for the
        if (consumer == null) {
    private final String name;  
                }
            switch (t) {
                    // Check if this field is in an exclusive set, if it is then mark  
        VALUE_ARRAY(VALUE_BOOLEAN, VALUE_NULL, VALUE_NUMBER, VALUE_STRING, START_ARRAY);  
                + (allReplacedWith == null ? "" : ", replaced_with=" + allReplacedWith)  
        if (exclusiveSet.length == 0) {
                 * this test won't catch them, but that is the price that we pay
            }
        private final EnumSet<XContentParser.Token> tokens;
        INT(VALUE_NUMBER, VALUE_STRING),  
        }
            } else {
import java.lang.reflect.Array;
            case START_ARRAY:  
        if (message.length() > 0) {  
            );
        this.exclusiveFieldSets.add(exclusiveSet);
                    break;
    public <T> void declareNamedObjects(  
import static java.util.Objects.requireNonNull;  
        NamedObjectParser<T, Context> namedObjectParser,
    }  
                    "[" + parserName + "] " + currentFieldName + " doesn't support values of type: " + parser.currentToken()
                assert token == XContentParser.Token.FIELD_NAME;
                break;
                 */
        // Check for a) multiple entries appearing in exclusive field sets and b) empty
                        throw new XContentParseException(  
     * Main parser interface  
 * ownership. Elasticsearch licenses this file to you under  
    ) {
                orderedModeCallback.accept(v);  
                    consumer.accept(v, defaultValue.get());
                o = parser.namedObject(categoryClass, field, context);  
    }  
    }  
        }  
        INT_ARRAY(START_ARRAY, VALUE_NUMBER, VALUE_STRING),
        STRING_OR_NULL(VALUE_STRING, VALUE_NULL),
        List<List<String>> exclusiveFields = new ArrayList<>();
    private class FieldParser {  
    public ObjectParser(String name) {
        this(name, unknownIsNamedXContent(categoryClass, unknownFieldConsumer), c -> valueSupplier.get());
    public interface UnknownFieldConsumer<Value> {  
 * SPDX-License-Identifier: Apache-2.0
                            "["
                    return namedObjectParser.parse(p, c, name);  
                    "["
                }
        Supplier<T> defaultValue,
                        throw new XContentParseException(  
        ParseField field
            if (token != XContentParser.Token.START_OBJECT) {
            }
     * Defines how to consume a parsed undefined field
                }  
import java.util.function.Function;  
    }
        List<String[]> requiredFields = new ArrayList<>(this.requiredFieldSets);  
        declareField((p, v, c) -> {
    }
        }
        }, field, ValueType.OBJECT_ARRAY);
        try {
    public void declareField(Parser<Value, Context> p, ParseField parseField, ValueType type) {
        this(name, errorOnUnknown(), c -> valueSupplier.get());  
        // This creates and parses the named object  
import org.opensearch.common.Nullable;  
     * @param valueBuilder A function that creates a new Value from the parse Context. Used  
import java.util.function.BiFunction;
        OBJECT_ARRAY_OR_NULL(START_OBJECT, START_ARRAY, VALUE_NULL),  
                e.getCandidates().forEach(candidates::add);  
    /**  
    }  
                                + "fields or an array where each entry is an object with a single field"
                    break;
                    break;
        OBJECT_ARRAY_OR_STRING(START_OBJECT, START_ARRAY, VALUE_STRING),
    private static <Value, Context> UnknownFieldParser<Value, Context> ignoreUnknown() {
                                + "] can be a single object with any number of "
        Consumer<Value> orderedModeCallback,  
                 * efficiently here. Instead we can check that they end on an  
            }
     * Functional interface for instantiating and parsing named objects. See ObjectParserTests#NamedObject for the canonical way to  
     * @param name the parsers name, used to reference the parser in exceptions and messages.  
        BiConsumer<Value, List<T>> consumer,
    }  
     * @param valueSupplier a supplier that creates a new Value instance used when the parser is used as an inner object parser.
 *       PARSER.declareInt(Thing::setMineral, new ParseField("mineral"));
        ValueType(XContentParser.Token first, XContentParser.Token... rest) {
    @Override
                                break;
                    throw new XContentParseException(  
            if (token == XContentParser.Token.FIELD_NAME) {
            fieldParserMap.putIfAbsent(fieldValue, fieldParser);
     * @param valueBuilder builds the value from the context. Used when the ObjectParser is not passed a value.
                /*
                    throw new IllegalStateException("parser for [" + currentFieldName + "] did not end on END_OBJECT");  
                    // consume the end object token
                        + "] can be a single object with any number of "
        }
    public void declareExclusiveFieldSet(String... exclusiveSet) {
                } catch (Exception e) {
                 * asserting that they do that is not something we can do
import static org.opensearch.core.xcontent.XContentParser.Token.VALUE_BOOLEAN;  
            throw new IllegalArgumentException("[consumer] is required");  
                    throw new XContentParseException(parser.getTokenLocation(), "[" + name + "] no field found");
            XContentParser.Token t = parser.currentToken();  
            case VALUE_EMBEDDED_OBJECT:  
                 * Well behaving parsers should consume the entire array but  
    private ObjectParser(
     * Creates a new ObjectParser that consumes unknown fields as generic Objects.
        UnknownFieldParser<Value, Context> unknownFieldParser,  
import static org.opensearch.core.xcontent.XContentParser.Token.START_ARRAY;
        DOUBLE_ARRAY(START_ARRAY, VALUE_NUMBER, VALUE_STRING),
    public static <Value, ElementValue> BiConsumer<Value, List<ElementValue>> fromList(
        BiConsumer<Value, ElementValue[]> consumer  
    }
        void assertSupports(String parserName, XContentParser parser, String currentFieldName) {
                fieldParser = fieldParserMap.get(currentFieldName);
                );  
                if (parser.currentToken() != XContentParser.Token.END_OBJECT) {
     * Creates a new ObjectParser.
        } catch (IOException e) {  
            this.parseField = parseField;  
                    consumer.accept(value, field, parser.text());  
 * <p>
            }
import java.util.EnumSet;
public final class ObjectParser<Value, Context> extends AbstractObjectParser<Value, Context>
            this.type = type;
                + ", type="
        private final ValueType type;
            throw new IllegalArgumentException(message.toString());
        ParseField field  
                 */  
    implements  
                    parseSub(parser, fieldParser, currentFieldName, value, context);
            }  
                    // it as seen.
        for (int i = 0; i < this.exclusiveFieldSets.size(); i++) {
     * Creates a new ObjectParser.
    private interface UnknownFieldParser<Value, Context> {  
package org.opensearch.core.xcontent;
                                exclusiveFields.get(i).add(currentFieldName);
                        );  
    @FunctionalInterface  
                case VALUE_NULL:
        };  
            XContentParser.Token token;
     */  
    private static <Value, Context> UnknownFieldParser<Value, Context> errorOnUnknown() {  
        BiConsumer<Value, ? super Category> consumer
                message.append("The following fields are not allowed together: ").append(fieldset.toString()).append(" ");  
        }
    public ObjectParser(String name, boolean ignoreUnknownFields, @Nullable Supplier<Value> valueSupplier) {  
    }  
                String message = ErrorOnUnknown.IMPLEMENTATION.errorMessage(objectParser.name, field, candidates);
        OBJECT_ARRAY_STRING_OR_NUMBER(START_OBJECT, START_ARRAY, VALUE_STRING, VALUE_NUMBER),  
        BiConsumer<Value, C> unknownFieldConsumer,
                throw new XContentParseException(  
            } else {
 * {@link #declareField} which can be used to implement exceptional parsing operations not covered by the high level methods.  
    }
                    consumer.accept(value, field, parser.list());  
                    token = p.nextToken();  
     * @param context context needed for parsing
     */
            }  
        FLOAT_ARRAY(START_ARRAY, VALUE_NUMBER, VALUE_STRING),
    private final Function<Context, Value> valueBuilder;
    public <T> void declareField(BiConsumer<Value, T> consumer, ContextParser<Context, T> parser, ParseField parseField, ValueType type) {
                throw new XContentParseException(p.getTokenLocation(), "[" + field + "] error while parsing named object", e);
        assert parser.currentToken() == XContentParser.Token.START_ARRAY : "Token was: " + parser.currentToken();
                    "[" + parserName + "] parsefield doesn't accept: " + currentFieldName
                                + "] can be a single object with any number of "
                }
                            if (field.equals(currentFieldName)) {
        }
        }
import static org.opensearch.core.xcontent.XContentParser.Token.VALUE_NUMBER;  
            for (String[] fields : requiredFields) {
     * @opensearch.internal
                fieldParser = null;  
                    return namedObject;
    @Override
    private void parseSub(XContentParser parser, FieldParser fieldParser, String currentFieldName, Value value, Context context)  
            String[] deprecatedNames = parseField.getDeprecatedNames();  
                }  
                if (p.booleanValue()) {
    @Override
                if (fieldParser == null) {  
 * A declarative, stateless parser that turns XContent into setter calls. A single parser should be defined for each object being parsed,
                 * END_ARRAY. They could end on the *wrong* end array and  
                + deprecated
        };
    /**  
        return name;
        FLOAT_OR_NULL(VALUE_NUMBER, VALUE_STRING, VALUE_NULL),
/*  
        @Nullable Supplier<Value> valueSupplier
 * The OpenSearch Contributors require contributions made to  
                                + field  
    ) {
        Class<C> categoryClass,  
            consumer.accept(v, fields);
                + parseField.getPreferredName()
        if (requiredFields.isEmpty() == false) {
                                + "fields or an array where each entry is an object with a single field"
        declareField((XContentParser p, Value v, Context c) -> {
 * compatible open source license.
        }
    }  
            Context context
    }
            case START_OBJECT:
import static org.opensearch.core.xcontent.XContentParser.Token.VALUE_STRING;
            if (deprecatedNames != null && deprecatedNames.length > 0) {  
        BOOLEAN(VALUE_BOOLEAN, VALUE_STRING),
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
    }
                throw new XContentParseException(  
 * not use this file except in compliance with the License.
                throw new XContentParseException(parser.getTokenLocation(), "[" + name + "] Expected START_OBJECT but was: " + token);
 * GitHub history for details.
    }
            Value value,  
                 * END_OBJECT. They could end on the *wrong* end object and
                            }  
    public interface NamedObjectParser<T, Context> {
     * Adapts an array (or varags) setter into a list setter.
        private final ParseField parseField;  
import java.util.ArrayList;  
        BiConsumer<Value, List<T>> consumer,
                throw new XContentParseException(p.getTokenLocation(), "[" + field + "] error while parsing", e);
        XContentParser.Token token;
        private final EnumSet<XContentParser.Token> supportedTokens;
                            p.getTokenLocation(),
     * @param unknownFieldConsumer how to consume parsed unknown fields
     * @opensearch.internal
                + ", supportedTokens="  
        Class<Category> categoryClass,  
        BiFunction<XContentParser, Context, T> objectParser,
 * Licensed to Elasticsearch under one or more contributor  
        LONG_OR_NULL(VALUE_NUMBER, VALUE_STRING, VALUE_NULL),
        this(name, errorOnUnknown(), null);  
                 * Well behaving parsers should consume the entire object but
            token = parser.nextToken();  
     */
            } else if (p.currentToken() == XContentParser.Token.START_ARRAY) {
    private final UnknownFieldParser<Value, Context> unknownFieldParser;
 */  
        FieldParser(Parser<Value, Context> parser, EnumSet<XContentParser.Token> supportedTokens, ParseField parseField, ValueType type) {  
                + "preferred_name="
import java.util.function.BiConsumer;  
 * You may obtain a copy of the License at  
        this.name = name;  
                    p.nextToken(); // Move past the object, should be back to into the array
 */  
        ) throws IOException;
            }  
        BOOLEAN_ARRAY(START_ARRAY, VALUE_BOOLEAN),
        ContextParser<Context, Value> {
/*
        }
     * @param parser the parser to build a value from
                ex
 * nested elements can be added via {@link #declareObject(BiConsumer, ContextParser, ParseField)} which should be satisfied where possible
        VALUE_OBJECT_ARRAY(VALUE_BOOLEAN, VALUE_NULL, VALUE_EMBEDDED_OBJECT, VALUE_NUMBER, VALUE_STRING, START_OBJECT, START_ARRAY),
                + '}';  
     * @param <C> the type of named object that unknown fields are expected to be
     * implement this for objects that themselves have a parser.
    }
    ) {  
        };
     * @return the parsed value
                } else {
                }
                            if (field.equals(currentFieldName)) {
    }
    public String getName() {  
            token = parser.currentToken();
                    consumer.accept(value, field, parser.numberValue());  
                parser.getTokenLocation(),
    ) {
        OBJECT_ARRAY(START_OBJECT, START_ARRAY),
            String allReplacedWith = parseField.getAllReplacedWith();
                    consumer.accept(value, field, null);  
            case FIELD_NAME:
        }  
 * This class works well for object that do have a constructor argument or that can be built using information available from earlier in the
            String field,  
                    unknownFieldParser.acceptUnknownField(this, currentFieldName, currentPosition, parser, value, context);
import java.util.function.Consumer;
        for (List<String> fieldset : exclusiveFields) {
            this.supportedTokens = supportedTokens;
/**  
                 * for having a cheap test.
            }
            try {
        FieldParser fieldParser = new FieldParser(p, type.supportedTokens(), parseField, type);  
import java.util.HashMap;  
    }
    private final Map<String, FieldParser> fieldParserMap = new HashMap<>();
        this.unknownFieldParser = unknownFieldParser;
        }
import java.util.Set;
                        + field  
                    }
        this.requiredFieldSets.add(requiredSet);  
            return this.tokens;  
            consumer.accept(value, o);
        if (type == null) {  
    }  
        };  
    public <T> void declareNamedObject(BiConsumer<Value, T> consumer, NamedObjectParser<T, Context> namedObjectParser, ParseField field) {
     *                     when the parser is used as an inner object parser.
                    break;
    }  
     * Creates a new ObjectParser.
    /**
        this(name, ignoreUnknownFields ? ignoreUnknown() : errorOnUnknown(), c -> valueSupplier.get());
                parseValue(parser, fieldParser, currentFieldName, value, context);
                case VALUE_STRING:
    public Value apply(XContentParser parser, Context context) {  
     * @param value the value to fill from the parser
        if (valueBuilder == null) {
 * @opensearch.api
    }  
     */  
    }  
                currentFieldName = parser.currentName();
 * </p>  
        FLOAT(VALUE_NUMBER, VALUE_STRING),  
     */
     */  
            throw new IllegalArgumentException("[parser] is required");  
            Category o;
    public <T> void declareNamedObjects(  
     * @param unknownFieldParser how to parse unknown fields
                 * efficiently here. Instead we can check that they end on an
     * @param unknownFieldConsumer how to consume parsed unknown fields
            }  
        return (objectParser, field, location, parser, value, context) -> {  
        OBJECT_OR_BOOLEAN(START_OBJECT, VALUE_BOOLEAN),
 *   private static final ObjectParser<Thing, SomeContext> PARSER = new ObjectParser<>("thing", Thing::new));
        }
    public String toString() {
                }  
    ) {
 * {@link ConstructingObjectParser}.
                deprecated = ", deprecated_names=" + Arrays.toString(deprecatedNames);
        LONG_ARRAY(START_ARRAY, VALUE_NUMBER, VALUE_STRING),  
     */  
                    break;
        ParseField field  
                    }
    /**
                    Iterator<String[]> iter = requiredFields.iterator();
            fieldParser.parser.parse(parser, value, context);
     * @param context a context that is passed along to all declared field parsers  
                throw new XContentParseException(parser.getTokenLocation(), "[" + name + "]" + token + " is unexpected");
        }
 * }</pre>
                        for (String field : this.exclusiveFieldSets.get(i)) {  
    private final List<String[]> exclusiveFieldSets = new ArrayList<>();
 *
                    fields.add(objectParser.apply(p, c));
            List<T> fields = new ArrayList<>();  
                parseValue(parser, fieldParser, currentFieldName, value, context);
    }  
            throw new IllegalArgumentException("[" + field + "] doesn't support arrays. Use a single object with multiple fields.");  
    /**
            case END_ARRAY:  
                while ((token = p.nextToken()) != XContentParser.Token.END_ARRAY) {
        if (parser == null) {
    /**
            ElementValue[] array = (ElementValue[]) Array.newInstance(c, l.size());
    @Override
                 * asserting that they do that is not something we can do
        return "ObjectParser{" + "name='" + name + '\'' + ", fields=" + fieldParserMap.values() + '}';  
    private static <Value, Context> UnknownFieldParser<Value, Context> consumeUnknownField(UnknownFieldConsumer<Value> consumer) {
     *  
        }
    /**
                    p.getTokenLocation(),
        T parse(XContentParser p, Context c, String name) throws IOException;
                );  
 * software distributed under the License is distributed on an
            if (fieldset.size() > 1) {
    }
                    // Check to see if this field is a required field, if it is we can
            } catch (IOException e) {  
    /**
     * @param name the parsers name, used to reference the parser in exceptions and messages.
    }
                        "[" + objectParser.name + "] cannot parse field [" + field + "] with value type [" + t + "]"
                    consumer.accept(value, field, parser.map());  
                    p.nextToken(); // Move to the first field in the object
            throw new XContentParseException(l, ErrorOnUnknown.IMPLEMENTATION.errorMessage(op.name, f, op.fieldParserMap.keySet()));
    private final List<String[]> requiredFieldSets = new ArrayList<>();
            return;
                throw new XContentParseException(location, message, e);
            case VALUE_BOOLEAN:
     * @param categoryClass the type of named object that unknown fields are expected to be  
import java.util.Iterator;
 *   static {  
                    fieldParser.assertSupports(name, parser, currentFieldName);  
    }  
                        for (String field : requriedFields) {
     */
        STRING_ARRAY(START_ARRAY, VALUE_STRING),  
        throws IOException {
        requireNonNull(valueBuilder, "Use the single argument ctor instead");
        return (op, f, l, p, v, c) -> p.skipChildren();  
 *
import java.util.function.Supplier;
            if (supportedTokens.contains(parser.currentToken()) == false) {
                + type.name()
    }  
     * @param ignoreUnknownFields Should this parser ignore unknown fields? This should generally be set to true only when parsing
                currentPosition = parser.getTokenLocation();  
                XContentParser.Token token = p.nextToken();  
            XContentLocation location,
                    // remove the entry as the requirement is satisfied  
        declareField((p, v, c) -> consumer.accept(v, parser.parse(p, c)), parseField, type);
    }
    /**
    @Override  
                break;
                "[" + name + "] failed to parse field [" + currentFieldName + "]",  
     */
 *       PARSER.declareInt(Thing::setFruit, new ParseField("fruit"));
     * @return a new value instance drawn from the provided value supplier on {@link #ObjectParser(String, Supplier)}  
 * It's highly recommended to use the high level declare methods like {@link #declareString(BiConsumer, ParseField)} instead of
        } catch (Exception ex) {  
    public enum ValueType {  
    ) {
        }
}
                    if (token != XContentParser.Token.START_OBJECT) {
            throw new NullPointerException("valueBuilder is not set");  
    public ObjectParser(String name, UnknownFieldConsumer<Value> unknownFieldConsumer, @Nullable Supplier<Value> valueSupplier) {
    }
     */
        VALUE(VALUE_BOOLEAN, VALUE_NULL, VALUE_EMBEDDED_OBJECT, VALUE_NUMBER, VALUE_STRING),
     */
     * @param valueSupplier a supplier that creates a new Value instance used when the parser is used as an inner object parser.
                    while (iter.hasNext()) {
            } catch (NamedObjectNotFoundException e) {
        public String toString() {
 * specific language governing permissions and limitations
     * @param name the parsers name, used to reference the parser in exceptions and messages.
        }
                try {
     */  
        return value;
    public Value parse(XContentParser parser, Context context) throws IOException {
            XContentParser parser,
import org.opensearch.common.annotation.PublicApi;
     * Parses a Value from the given {@link XContentParser}  
        DOUBLE_OR_NULL(VALUE_NUMBER, VALUE_STRING, VALUE_NULL),  
            }
     * @param valueSupplier a supplier that creates a new Value instance used when the parser is used as an inner object parser.
        public EnumSet<XContentParser.Token> supportedTokens() {
                Set<String> candidates = new HashSet<>(objectParser.fieldParserMap.keySet());
                        + "fields or an array where each entry is an object with a single field"
                /*  
        INT_OR_NULL(VALUE_NUMBER, VALUE_STRING, VALUE_NULL),
import java.io.IOException;
     */
                 * this test won't catch them, but that is the price that we pay
    /**
        switch (token) {  
            ObjectParser<Value, Context> objectParser,
        return (objectParser, field, location, parser, value, context) -> {
 * Instances of {@link ObjectParser} should be setup by declaring a constant field for the parsers and declaring all fields in a static
 * license agreements. See the NOTICE file distributed with
            case VALUE_STRING:  
            this.parser = parser;
                        }
            return "FieldParser{"  
        BiFunction<XContentParser, Context, T> objectParser = (XContentParser p, Context c) -> {
        OBJECT_OR_LONG(START_OBJECT, VALUE_NUMBER),  
                 * for having a cheap test.  
        Consumer<Value> orderedModeCallback = (v) -> {
    private void parseArray(XContentParser parser, FieldParser fieldParser, String currentFieldName, Value value, Context context)
@PublicApi(since = "1.0.0")
                } catch (Exception e) {  
/*
        };  
        return new ObjectParser<Value, Context>(name, errorOnUnknown(), valueBuilder);
 * Modifications Copyright OpenSearch Contributors. See  
            }
    @Override
                try {  
        return (op, f, l, p, v, c) -> {
 * <pre>{@code
                if (currentFieldName == null) {  
    }
            case END_OBJECT:
                String name = p.currentName();
     * @param parser the parser to build a value from
        // required field entries
import org.opensearch.core.ParseField;
                    assert token == XContentParser.Token.END_OBJECT;
                    throw new XContentParseException(p.getTokenLocation(), "[" + field + "] failed to parse field [" + name + "]", e);
            }  
     * Supported Value Types for Parsable Objects
        if (requiredSet.length == 0) {  
            throw new IllegalArgumentException("[type] is required");
                while ((token = p.nextToken()) != XContentParser.Token.END_OBJECT) {
