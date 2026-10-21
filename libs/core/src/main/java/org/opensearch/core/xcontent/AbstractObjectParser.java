    /**
     */
    public void declareFloat(BiConsumer<Value, Float> consumer, ParseField field) {
     *
     *
     * that this does not make 'foo' or 'bar' required - see {@link #declareRequiredFieldSet(String...)}
            consumer,
    public void declareDouble(BiConsumer<Value, Double> consumer, ParseField field) {
     * </pre>
     *            sets the values once they have been parsed
        declareFieldArray(consumer, (p, c) -> p.intValue(), field, ValueType.INT_ARRAY);
    public <T> void declareObjectArray(BiConsumer<Value, List<T>> consumer, ContextParser<Context, T> objectParser, ParseField field) {
            p -> p.currentToken() == XContentParser.Token.VALUE_NULL ? nullValue : p.longValue(),
    }
     *   <tr><th>Provided JSON</th><th>Reason for failure</th></tr>
     * <code>
            (p, c) -> p.currentToken() == XContentParser.Token.VALUE_NULL ? nullValue : objectParser.parse(p, c),
    );
     * See NamedObjectHolder in ObjectParserTests for examples of how to invoke
    }
     *
        );
    public <T> void declareObject(BiConsumer<Value, T> consumer, ContextParser<Context, T> objectParser, ParseField field) {
     *
        );
            list.add(supplier.get()); // single value
            ValueType.FLOAT_OR_NULL
     * E.g. <code>declareRequiredFieldSet("foo", "bar");</code> means at least one of "foo" or
        BiConsumer<Value, T> consumer,
     *       {"title": {}},
     * @param namedObjectParser
     *   "highlight": {
    /**
        List<T> list = new ArrayList<>();
        NamedObjectParser<T, Context> namedObjectParser,
        declareField(
     * <code>
     *   <li><code>{"bar":"...", "bizz":"...", "buzz": "..."}</code></li>
            ValueType.OBJECT_ARRAY_OR_NULL
     *     }
    ) {
        NamedObjectParser<T, Context> namedObjectParser,
    public abstract String getName();
            field,
     * }
     * this.
            consumer,
    }
            ValueType.DOUBLE_OR_NULL
import java.util.ArrayList;
 * under the License.
import java.util.function.Function;
    }
        }
     * {
 * this work for additional information regarding copyright
     *
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at
        declareField(consumer, p -> p.doubleValue(), field, ValueType.DOUBLE);
        declareField(
        T nullValue,
     *   }
            p -> p.currentToken() == XContentParser.Token.VALUE_NULL ? nullValue : p.intValue(),
     * <pre>
     */
     *   <li><code>{"foo":"...", "bar":"...", "buzz": "..."}</code></li>
     *            parses each named object
 * software distributed under the License is distributed on an
        declareField(
    }
     * this.
        );
    );
     *   }
     */
    public void declareString(BiConsumer<Value, String> consumer, ParseField field) {
 * KIND, either express or implied.  See the License for the
     * requires that one of "foo" or "bar" fields are present, and also that one of "bizz" or
        ParseField field,
     *   "highlight": {
import org.opensearch.core.ParseField;
     *
 *    http://www.apache.org/licenses/LICENSE-2.0
     * Multiple required sets can be configured:
        // Using a method reference here angers some compilers
        );
     * Declare a float field that parses explicit {@code null}s in the json to a default value.
     * like {@link #declareObjectArray(BiConsumer, ContextParser, ParseField)}, but can also handle single null values,
     *            sets the values once they have been parsed
    public void declareDoubleOrNull(BiConsumer<Value, Double> consumer, double nullValue, ParseField field) {
     *
     * }
        BiConsumer<Value, T> consumer,
     * See NamedObjectHolder in ObjectParserTests for examples of how to invoke
        declareField(consumer, XContentParser::booleanValue, field, ValueType.BOOLEAN);
     * E.g. <code>declareExclusiveFieldSet("foo", "bar");</code> means that only one of 'foo'
     * <table>
     * the order sent but tools that generate json are free to put object
    /**
     *            sets the value once it has been parsed
                }
     * @param consumer
     */
package org.opensearch.core.xcontent;
    public void declareLongArray(BiConsumer<Value, List<Long>> consumer, ParseField field) {
        ContextParser<Context, T> objectParser,
     * Declare a field of type {@code T} parsed from string and converted to {@code T} using provided function.
     *
    /**
        // Using a method reference here angers some compilers
                } else {
     * </code></pre>
        declareField(consumer, p -> p.floatValue(), field, ValueType.FLOAT);
 * compatible open source license.
public abstract class AbstractObjectParser<Value, Context> {
     * objects) is not supported.
        declareField(
     *
     * @param namedObjectParser
     * </pre>
     * }
            ValueType.LONG_OR_NULL
     *            parses each named object
     *   <tr><td><code>{"foo":"...", "bar": "..."}</code></td><td>Missing "bizz" or "buzz" field</td></tr>
    /**
    public void declareIntArray(BiConsumer<Value, List<Integer>> consumer, ParseField field) {
/*
     * for required fields.
    }
     * Declare an object field that parses explicit {@code null}s in the json to a default value.
        declareField(
/**
import java.io.IOException;
     */
     * inside and object like this:
     * @param parseField
     *
     *   <li><code>{"foo":"...", "bar":"...", "bizz": "...", "buzz": "..."}</code></li>
     * </code>
     * <p>
     * or 'bar' must be present, and if both appear then an exception will be thrown.  Note
 */
    public void declareBoolean(BiConsumer<Value, Boolean> consumer, ParseField field) {
    }
    }
            field,
     * This is because json doesn't enforce ordering. OpenSearch reads it in
        // Using a method reference here angers some compilers
        ParseField parseField
    public abstract <T> void declareField(
            consumer,
     * <p>
                    list.add(supplier.get());
     *
     * <p>
    }
     * Unlike the other version of this method, "ordered" mode (arrays of
     */
     *            called when the named object is parsed using the "ordered"
    }
        NamedObjectParser<T, Context> namedObjectParser,
     */
import org.opensearch.common.CheckedFunction;
     *   }
    );
     *     "fields": {        &lt;------ this one
     * <pre>
     * Throws if the next token is not a string.
    public void declareIntOrNull(BiConsumer<Value, Integer> consumer, int nullValue, ParseField field) {
     * {
 */
     * @param parseField
     * Declares a set of fields of which at most one must appear for parsing to succeed
     * <p>
     * @param namedObjectParser
     */
     * but, when order is important, some may be written this way:
                    || parser.currentToken() == XContentParser.Token.VALUE_NULL
        ValueType type
     *   <caption>failure cases</caption>
     * Multiple exclusive sets may be declared
     * <p>
 *
     *   "aggregations": {
    public void declareStringArray(BiConsumer<Value, List<String>> consumer, ParseField field) {
     * <pre><code>
 * Superclass for {@link ObjectParser} and {@link ConstructingObjectParser}. Defines most of the "declare" methods so they can be shared.
    private static <T> List<T> parseArray(XContentParser parser, IOSupplier<T> supplier) throws IOException {
     * {@link #declareObject(BiConsumer, ContextParser, ParseField)} rather than call this directly.
     *   <tr><td><code>{"bizz": "..."}</code></td><td>Missing "foo" or "bar" field</td></tr>
@PublicApi(since = "1.0.0")
     *   <tr><td><code>{"buzz": "..."}</code></td><td>Missing "foo" or "bar" field</td></tr>
     *   <tr><td><code>{"bar":"..."}</code></td><td>Missing "bizz" or "buzz" field</td></tr>
     * {
     * <code>
     * Declares a set of fields that are required for parsing to succeed. Only one of the values
     * <code>
     * Declares a single named object.
        BiConsumer<Value, List<T>> consumer,
     *
     *       "body": {},
    }
     *     ]
    public void declareLongOrNull(BiConsumer<Value, Long> consumer, long nullValue, ParseField field) {
        declareField(consumer, (p, c) -> objectParser.parse(p, c), field, ValueType.OBJECT);
            (p) -> p.currentToken() == XContentParser.Token.VALUE_NULL ? null : p.text(),
 * not use this file except in compliance with the License.
 *
            p -> p.currentToken() == XContentParser.Token.VALUE_NULL ? nullValue : p.doubleValue(),
        T get() throws IOException;
            || parser.currentToken() == XContentParser.Token.VALUE_NULL
        if (parser == null) {
     *          A set of required fields, where at least one of the fields in the array _must_ be present
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    /**
    private interface IOSupplier<T> {
     *   parser.declareRequiredFieldSet("bizz", "buzz");
        ParseField parseField
        BiConsumer<Value, T> consumer,
     */
     */
     *     }
        Consumer<Value> orderedModeCallback,
     * </pre>
     *
    }
     * }
    public void declareDoubleArray(BiConsumer<Value, List<Double>> consumer, ParseField field) {
    public abstract <T> void declareNamedObjects(
        if (parser.currentToken().isValue()
     *
    public void declareLong(BiConsumer<Value, Long> consumer, ParseField field) {
            p -> p.currentToken() == XContentParser.Token.VALUE_NULL ? nullValue : p.floatValue(),
 *
     * "buzz" fields are present.
            while (parser.nextToken() != XContentParser.Token.END_ARRAY) {
 *
 * ownership. Elasticsearch licenses this file to you under
        ValueType type
        declareField(consumer, (p, c) -> parseArray(p, () -> itemParser.parse(p, c)), field, type);
     *   <li><code>{"foo":"...", "bar":"...", "bizz": "..."}</code></li>
     * {
    }
        ParseField field
     * <ul>
            throw new IllegalArgumentException("[parser] is required");
            || parser.currentToken() == XContentParser.Token.START_OBJECT) {
    /**
            ValueType.STRING_OR_NULL
    public <T> void declareField(
     *       {"body": {}},
    /**
     *   <tr><td><code>{"unrelated":"..."}</code></td>  <td>Missing "foo" or "bar" field, and missing "bizz" or "buzz" field</td></tr>
import org.opensearch.common.annotation.PublicApi;
        ParseField field
    );
    public void declareFloatArray(BiConsumer<Value, List<Float>> consumer, ParseField field) {
     *     "instance_name": { "field1": "value1", ... }
    public <T> void declareFieldArray(
     *     }
     *   <li><code>{"bar":"...", "buzz": "..."}</code></li>
    }
        declareFieldArray(consumer, (p, c) -> objectParser.parse(p, c), field, ValueType.OBJECT_ARRAY);
        BiConsumer<Value, T> consumer,
     * <p>
     * Declare a double field that parses explicit {@code null}s in the json to a default value.
     * </ul>
        CheckedFunction<XContentParser, T, IOException> parser,
 * license agreements. See the NOTICE file distributed with
     */
     * These are usually named inside and object like this:
     *
            ValueType.OBJECT_OR_NULL
    }
 * this file be licensed under the Apache-2.0 license or a
     * In JSON, it means any of these combinations are acceptable:
     * @param consumer
     *
    }
     *     "name_3": { "aggregation_type": {} }
     * The following would however be rejected:
     * @param exclusiveSet a set of field names, at most one of which must appear
        ParseField parseField,
    ) {
     * Declares named objects in the style of aggregations. These are named
        ContextParser<Context, T> parser,
    }
     * @param consumer
        // Using a method reference here angers some compilers
        declareField(consumer, p -> p.intValue(), field, ValueType.INT);
    }
        declareField(
     */
    ) {
        declareFieldArray(consumer, (p, c) -> p.doubleValue(), field, ValueType.DOUBLE_ARRAY);
     *   }
        declareField(consumer, XContentParser::text, field, ValueType.STRING);
     *       "title": {},
        }
            (p, c) -> p.currentToken() == XContentParser.Token.VALUE_NULL ? null : parseArray(p, () -> objectParser.parse(p, c)),
 */
     *     "name_1": { "aggregation_type": {} },
     * </table>
 * specific language governing permissions and limitations
     * <pre>
        ContextParser<Context, T> itemParser,
import org.opensearch.core.xcontent.ObjectParser.NamedObjectParser;
    ) {
            consumer,
    public void declareFloatOrNull(BiConsumer<Value, Float> consumer, float nullValue, ParseField field) {
                    throw new IllegalStateException("expected value but got [" + parser.currentToken() + "]");
     *   <tr><td><code>{"bizz":"...", "buzz": "..."}</code></td><td>Missing "foo" or "bar" field</td></tr>
     *   parser.declareRequiredFieldSet("foo", "bar");
     *   <li><code>{"foo":"...", "bizz":"...", "buzz": "..."}</code></li>
/*
     * Declares a field that can contain an array of elements listed in the type ValueType enum
            (value, list) -> { if (list != null) consumer.accept(value, list); },
}
import org.opensearch.core.xcontent.ObjectParser.ValueType;
     *            the field to parse
/*
            field,
    public abstract void declareRequiredFieldSet(String... requiredSet);
        ContextParser<Context, T> objectParser,
     * @param requiredSet
        declareField(consumer, p -> p.longValue(), field, ValueType.LONG);
        // Using a method reference here angers some compilers
        BiConsumer<Value, List<T>> consumer,
 * Licensed to Elasticsearch under one or more contributor
     * members in an unordered Map, jumbling them. Thus, if you care about order
     * <p>
        ParseField parseField,
    }
     *            mode (the array of objects)
                if (parser.currentToken().isValue()
import java.util.function.Consumer;
    }
        );
 * The OpenSearch Contributors require contributions made to
    }
 * @opensearch.api
    public <T> void declareObjectOrNull(
     * </code>
        );
     * provided per String[] must be matched.
        );
            consumer,
        declareFieldArray(consumer, (p, c) -> p.text(), field, ValueType.STRING_ARRAY);
import java.util.function.BiConsumer;
        } else {
     *     "name_2": { "aggregation_type": {} },
        declareField(consumer, p -> fromStringFunction.apply(p.text()), field, ValueType.STRING);
        return list;
    }
    public abstract <T> void declareNamedObject(
     *            the field to parse
    public void declareStringOrNull(BiConsumer<Value, String> consumer, ParseField field) {
     * Declare a double field that parses explicit {@code null}s in the json to a default value.
     * in which case the consumer isn't called
     * "bar" fields must be present.  If neither of those fields are present, an exception will be thrown.
    }
     * @param orderedModeCallback
     *   <li><code>{"foo":"...", "buzz": "..."}</code></li>
 */
     * you can send the object in the second way.
    public <T> void declareObjectArrayOrNull(
     *   "object_name": {
        declareField(consumer, (p, c) -> parser.apply(p), parseField, type);
    /**
        declareFieldArray(consumer, (p, c) -> p.floatValue(), field, ValueType.FLOAT_ARRAY);
        BiConsumer<Value, List<T>> consumer,
 * Modifications Copyright OpenSearch Contributors. See
        BiConsumer<Value, List<T>> consumer,
    public abstract <T> void declareNamedObjects(
                    || parser.currentToken() == XContentParser.Token.START_OBJECT) {
     * Declares named objects in the style of highlighting's field element.
     * @param parseField
            ValueType.INT_OR_NULL
    /**
    /**
    public void declareInt(BiConsumer<Value, Integer> consumer, ParseField field) {
     *       {"category": {}}
    public abstract void declareExclusiveFieldSet(String... exclusiveSet);
     * </code>
     */
     *
    /**
            }
        ValueType type
     *       "category": {}
            field,
            field,
     * <pre>
            field,
     *            the field to parse
     * </code>
        ParseField parseField
        declareField(
     *   <li><code>{"bar":"...", "bizz": "..."}</code></li>
            field,
     * </pre>
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
     *   <tr><td><code>{"foo":"..."}</code></td><td>Missing "bizz" or "buzz" field</td></tr>
            consumer,
    }
        declareFieldArray(consumer, (p, c) -> p.longValue(), field, ValueType.LONG_ARRAY);
     * Declare some field. Usually it is easier to use {@link #declareString(BiConsumer, ParseField)} or
    public <T> void declareString(BiConsumer<Value, T> consumer, Function<String, T> fromStringFunction, ParseField field) {
     *     "fields": [        &lt;------ this one
import java.util.List;
     *   <li><code>{"foo":"...", "bizz": "..."}</code></li>
     *            parses the named object
    }
 * GitHub history for details.
