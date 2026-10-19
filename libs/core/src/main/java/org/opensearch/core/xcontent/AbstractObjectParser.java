        declareFieldArray(consumer, (p, c) -> p.intValue(), field, ValueType.INT_ARRAY);
 *    http://www.apache.org/licenses/LICENSE-2.0
     */  
        declareFieldArray(consumer, (p, c) -> p.longValue(), field, ValueType.LONG_ARRAY);  
import java.util.function.Function;  
        BiConsumer<Value, List<T>> consumer,
     * Declare a field of type {@code T} parsed from string and converted to {@code T} using provided function.  
     * }
    /**  
        }  
     *   <tr><td><code>{"unrelated":"..."}</code></td>  <td>Missing "foo" or "bar" field, and missing "bizz" or "buzz" field</td></tr>
        // Using a method reference here angers some compilers  
        );
            consumer,  
 */  
     *   <tr><td><code>{"bar":"..."}</code></td><td>Missing "bizz" or "buzz" field</td></tr>
    public void declareFloatArray(BiConsumer<Value, List<Float>> consumer, ParseField field) {
        BiConsumer<Value, T> consumer,  
     * @param parseField  
     * Declares a set of fields of which at most one must appear for parsing to succeed
        ValueType type  
    public abstract <T> void declareField(
     *  
    public void declareBoolean(BiConsumer<Value, Boolean> consumer, ParseField field) {
     * or 'bar' must be present, and if both appear then an exception will be thrown.  Note
     *
     *       {"body": {}},
        ParseField field
     * but, when order is important, some may be written this way:  
     *       {"category": {}}  
        List<T> list = new ArrayList<>();
            field,
     *     }
        return list;
        ContextParser<Context, T> objectParser,  
     *     "fields": {        &lt;------ this one
     *  
     * <p>
     *       "title": {},  
     * <pre>
     * inside and object like this:
/*  
     */  
    /**
        declareField(consumer, p -> p.doubleValue(), field, ValueType.DOUBLE);
     *
    public abstract <T> void declareNamedObject(  
     * {  
    );
    }
    /**
     * <pre>  
     * @param orderedModeCallback
 * software distributed under the License is distributed on an
     *   <tr><th>Provided JSON</th><th>Reason for failure</th></tr>  
            list.add(supplier.get()); // single value
import org.opensearch.core.xcontent.ObjectParser.NamedObjectParser;
     * </code>  
    }
     * }
    public <T> void declareObjectArray(BiConsumer<Value, List<T>> consumer, ContextParser<Context, T> objectParser, ParseField field) {
     *   <li><code>{"foo":"...", "bar":"...", "bizz": "..."}</code></li>
 * Modifications Copyright OpenSearch Contributors. See
     *   }
        // Using a method reference here angers some compilers
     * you can send the object in the second way.
    /**
     *  
        ParseField field  
    private static <T> List<T> parseArray(XContentParser parser, IOSupplier<T> supplier) throws IOException {  
     *            called when the named object is parsed using the "ordered"
     * <p>
     *   <tr><td><code>{"foo":"..."}</code></td><td>Missing "bizz" or "buzz" field</td></tr>
     */
 * under the License.  
import org.opensearch.core.ParseField;  
import java.util.List;  
            p -> p.currentToken() == XContentParser.Token.VALUE_NULL ? nullValue : p.doubleValue(),
}
    );
     *   "object_name": {  
        ValueType type
        );
import java.util.function.BiConsumer;
            }  
    }  
     *   <li><code>{"bar":"...", "buzz": "..."}</code></li>  
     * <p>
     *       {"title": {}},
            field,  
    /**
     *  
        } else {  
 * GitHub history for details.
    ) {  
 * The OpenSearch Contributors require contributions made to  
    public abstract <T> void declareNamedObjects(  
            consumer,
     * </pre>  
        declareField(  
        BiConsumer<Value, T> consumer,
    public void declareLongOrNull(BiConsumer<Value, Long> consumer, long nullValue, ParseField field) {
                    list.add(supplier.get());
     *   <tr><td><code>{"foo":"...", "bar": "..."}</code></td><td>Missing "bizz" or "buzz" field</td></tr>
                    throw new IllegalStateException("expected value but got [" + parser.currentToken() + "]");
 *
     *   "highlight": {
    public <T> void declareObject(BiConsumer<Value, T> consumer, ContextParser<Context, T> objectParser, ParseField field) {
 * specific language governing permissions and limitations
            p -> p.currentToken() == XContentParser.Token.VALUE_NULL ? nullValue : p.floatValue(),  
    }  
package org.opensearch.core.xcontent;
     * </code></pre>
        declareField(consumer, XContentParser::booleanValue, field, ValueType.BOOLEAN);
        ValueType type
     *   <li><code>{"foo":"...", "bizz": "..."}</code></li>  
 * this file be licensed under the Apache-2.0 license or a
     *   <li><code>{"foo":"...", "bar":"...", "bizz": "...", "buzz": "..."}</code></li>
 * Unless required by applicable law or agreed to in writing,
                }
     *     "fields": [        &lt;------ this one  
    }
    /**
    public void declareLongArray(BiConsumer<Value, List<Long>> consumer, ParseField field) {
     *            sets the value once it has been parsed  
        ParseField field,
    public void declareIntArray(BiConsumer<Value, List<Integer>> consumer, ParseField field) {  
    }
    /**  
        // Using a method reference here angers some compilers
                    || parser.currentToken() == XContentParser.Token.VALUE_NULL  
            ValueType.OBJECT_ARRAY_OR_NULL
    }  
 *
            field,
    }
            consumer,
     *   <li><code>{"bar":"...", "bizz":"...", "buzz": "..."}</code></li>
    }  
        declareField(
     * Multiple required sets can be configured:
        ParseField parseField
        ContextParser<Context, T> itemParser,  
     * that this does not make 'foo' or 'bar' required - see {@link #declareRequiredFieldSet(String...)}
    /**  
            (p, c) -> p.currentToken() == XContentParser.Token.VALUE_NULL ? null : parseArray(p, () -> objectParser.parse(p, c)),
     * @param parseField
        ContextParser<Context, T> objectParser,
     * See NamedObjectHolder in ObjectParserTests for examples of how to invoke  
        ParseField parseField,
     *
     */
     * "buzz" fields are present.
     * <p>
            (value, list) -> { if (list != null) consumer.accept(value, list); },
        ParseField parseField,
     */
        declareField(  
/*
    public abstract void declareExclusiveFieldSet(String... exclusiveSet);  
 * compatible open source license.
     *   <tr><td><code>{"bizz":"...", "buzz": "..."}</code></td><td>Missing "foo" or "bar" field</td></tr>  
        BiConsumer<Value, T> consumer,  
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
        ParseField parseField  
     */  
     */
        BiConsumer<Value, List<T>> consumer,
            || parser.currentToken() == XContentParser.Token.VALUE_NULL  
    public void declareDouble(BiConsumer<Value, Double> consumer, ParseField field) {  
     * {
     *            parses the named object
    }  
     *   parser.declareRequiredFieldSet("foo", "bar");
    );  
    }
        // Using a method reference here angers some compilers
    public void declareDoubleOrNull(BiConsumer<Value, Double> consumer, double nullValue, ParseField field) {
     * "bar" fields must be present.  If neither of those fields are present, an exception will be thrown.  
     */
        declareField(
    }
            consumer,  
     * Declare some field. Usually it is easier to use {@link #declareString(BiConsumer, ParseField)} or
    public abstract void declareRequiredFieldSet(String... requiredSet);
        declareField(
     *
     * Declares named objects in the style of aggregations. These are named
     * Throws if the next token is not a string.
     *            the field to parse
        );
     * Declares named objects in the style of highlighting's field element.
     * <p>
 */  
            while (parser.nextToken() != XContentParser.Token.END_ARRAY) {
    public void declareString(BiConsumer<Value, String> consumer, ParseField field) {
    public void declareFloat(BiConsumer<Value, Float> consumer, ParseField field) {
     *
    /**  
    public void declareIntOrNull(BiConsumer<Value, Integer> consumer, int nullValue, ParseField field) {
     * Multiple exclusive sets may be declared
     *  
     *            parses each named object
        CheckedFunction<XContentParser, T, IOException> parser,  
     * Declare a float field that parses explicit {@code null}s in the json to a default value.
     *     "instance_name": { "field1": "value1", ... }
     * E.g. <code>declareRequiredFieldSet("foo", "bar");</code> means at least one of "foo" or
     */  
     * See NamedObjectHolder in ObjectParserTests for examples of how to invoke
    }
            consumer,
    /**  
    public <T> void declareObjectArrayOrNull(
     * </code>
     *
            ValueType.FLOAT_OR_NULL
     * @param consumer
     *
     * @param consumer
    public void declareFloatOrNull(BiConsumer<Value, Float> consumer, float nullValue, ParseField field) {  
     * Declares a single named object.
     *            mode (the array of objects)  
 * license agreements. See the NOTICE file distributed with
     * <code>
    public <T> void declareFieldArray(
 * SPDX-License-Identifier: Apache-2.0
    public abstract <T> void declareNamedObjects(
     * in which case the consumer isn't called
     *  
    );
     *            the field to parse
        declareField(  
        );
 * You may obtain a copy of the License at  
    public void declareStringOrNull(BiConsumer<Value, String> consumer, ParseField field) {
     *   <tr><td><code>{"buzz": "..."}</code></td><td>Missing "foo" or "bar" field</td></tr>
        NamedObjectParser<T, Context> namedObjectParser,  
     * <pre><code>
    }
                    || parser.currentToken() == XContentParser.Token.START_OBJECT) {
     */
        BiConsumer<Value, List<T>> consumer,
 * not use this file except in compliance with the License.
     *            sets the values once they have been parsed
            throw new IllegalArgumentException("[parser] is required");
     *       "category": {}
     * <p>
     *
            ValueType.STRING_OR_NULL  
    }  
     * @param requiredSet
/**
     *     "name_1": { "aggregation_type": {} },
    /**  
     * {
     *   <caption>failure cases</caption>
     * Declare a double field that parses explicit {@code null}s in the json to a default value.
            (p) -> p.currentToken() == XContentParser.Token.VALUE_NULL ? null : p.text(),
            field,  
     * <code>
     *   }
     *
        NamedObjectParser<T, Context> namedObjectParser,
    }
     * <code>
     * for required fields.  
     * </code>
     * this.
     * Declare an object field that parses explicit {@code null}s in the json to a default value.  
     * like {@link #declareObjectArray(BiConsumer, ContextParser, ParseField)}, but can also handle single null values,
     * </pre>
     *            sets the values once they have been parsed  
import java.util.function.Consumer;
            (p, c) -> p.currentToken() == XContentParser.Token.VALUE_NULL ? nullValue : objectParser.parse(p, c),
     * objects) is not supported.  
     *   <li><code>{"bar":"...", "bizz": "..."}</code></li>
        declareField(consumer, (p, c) -> parseArray(p, () -> itemParser.parse(p, c)), field, type);
     */
@PublicApi(since = "1.0.0")
     * {  
        declareFieldArray(consumer, (p, c) -> p.text(), field, ValueType.STRING_ARRAY);  
    private interface IOSupplier<T> {
     * Declares a field that can contain an array of elements listed in the type ValueType enum
     * </table>
        BiConsumer<Value, T> consumer,
 * @opensearch.api
        declareFieldArray(consumer, (p, c) -> p.floatValue(), field, ValueType.FLOAT_ARRAY);
        ParseField parseField  
     * }
            ValueType.LONG_OR_NULL
                if (parser.currentToken().isValue()
    }
     * </ul>  
    }
     * <ul>
public abstract class AbstractObjectParser<Value, Context> {
     *   }  
        declareField(consumer, (p, c) -> objectParser.parse(p, c), field, ValueType.OBJECT);
     *
     *   <tr><td><code>{"bizz": "..."}</code></td><td>Missing "foo" or "bar" field</td></tr>  
     */
     *     "name_2": { "aggregation_type": {} },  
 *  
    public <T> void declareField(
     * These are usually named inside and object like this:
    /**
        declareFieldArray(consumer, (p, c) -> p.doubleValue(), field, ValueType.DOUBLE_ARRAY);
        T nullValue,
        );
 * Superclass for {@link ObjectParser} and {@link ConstructingObjectParser}. Defines most of the "declare" methods so they can be shared.  
     *   "highlight": {
        declareField(consumer, (p, c) -> parser.apply(p), parseField, type);
    ) {
     * the order sent but tools that generate json are free to put object
    }
     * @param namedObjectParser
     *     ]
 */  
     * @param parseField  
     *   <li><code>{"foo":"...", "bar":"...", "buzz": "..."}</code></li>
            ValueType.DOUBLE_OR_NULL
    }  
    }
import org.opensearch.common.annotation.PublicApi;
        if (parser == null) {
        declareField(consumer, p -> p.floatValue(), field, ValueType.FLOAT);  
    }
     *   <li><code>{"foo":"...", "bizz":"...", "buzz": "..."}</code></li>  
     *   "aggregations": {
     *   }  
    public void declareDoubleArray(BiConsumer<Value, List<Double>> consumer, ParseField field) {  
        }
            field,
 *
        if (parser.currentToken().isValue()
        );
 * this work for additional information regarding copyright
import org.opensearch.common.CheckedFunction;
        NamedObjectParser<T, Context> namedObjectParser,
     * members in an unordered Map, jumbling them. Thus, if you care about order  
    public void declareInt(BiConsumer<Value, Integer> consumer, ParseField field) {
        declareField(
        declareField(consumer, p -> p.intValue(), field, ValueType.INT);
            ValueType.OBJECT_OR_NULL  
    public void declareLong(BiConsumer<Value, Long> consumer, ParseField field) {
    ) {
    public <T> void declareString(BiConsumer<Value, T> consumer, Function<String, T> fromStringFunction, ParseField field) {  
    }  
     *     "name_3": { "aggregation_type": {} }
            p -> p.currentToken() == XContentParser.Token.VALUE_NULL ? nullValue : p.longValue(),
import org.opensearch.core.xcontent.ObjectParser.ValueType;
    ) {  
     * </pre>
    public <T> void declareObjectOrNull(
     *   <li><code>{"foo":"...", "buzz": "..."}</code></li>
            consumer,  
            p -> p.currentToken() == XContentParser.Token.VALUE_NULL ? nullValue : p.intValue(),
     * The following would however be rejected:
     * E.g. <code>declareExclusiveFieldSet("foo", "bar");</code> means that only one of 'foo'  
import java.io.IOException;
     *     }  
        BiConsumer<Value, List<T>> consumer,
     * {@link #declareObject(BiConsumer, ContextParser, ParseField)} rather than call this directly.  
     */  
    }  
     * Declares a set of fields that are required for parsing to succeed. Only one of the values
     *            the field to parse
/*  
     *       "body": {},
        ContextParser<Context, T> parser,
        declareField(consumer, p -> fromStringFunction.apply(p.text()), field, ValueType.STRING);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        );  
     * @param consumer  
     * <code>  
     * Unlike the other version of this method, "ordered" mode (arrays of
 */
     * <pre>
     * requires that one of "foo" or "bar" fields are present, and also that one of "bizz" or  
     * This is because json doesn't enforce ordering. OpenSearch reads it in
     * @param namedObjectParser
 * Licensed to Elasticsearch under one or more contributor  
     * <p>
     *          A set of required fields, where at least one of the fields in the array _must_ be present
    /**
     *            parses each named object  
     * </code>
    public abstract String getName();
        declareField(consumer, p -> p.longValue(), field, ValueType.LONG);
            || parser.currentToken() == XContentParser.Token.START_OBJECT) {
        // Using a method reference here angers some compilers  
     * In JSON, it means any of these combinations are acceptable:  
        declareField(consumer, XContentParser::text, field, ValueType.STRING);
     *     }
     *  
    public void declareStringArray(BiConsumer<Value, List<String>> consumer, ParseField field) {
            field,
     * @param exclusiveSet a set of field names, at most one of which must appear
     * Declare a double field that parses explicit {@code null}s in the json to a default value.  
                } else {  
        declareFieldArray(consumer, (p, c) -> objectParser.parse(p, c), field, ValueType.OBJECT_ARRAY);  
        T get() throws IOException;  
    }
 * KIND, either express or implied.  See the License for the
            ValueType.INT_OR_NULL  
     * <pre>
            field,  
        Consumer<Value> orderedModeCallback,
     * <table>
     * }  
import java.util.ArrayList;
     * </pre>  
     * @param namedObjectParser
     * this.  
     * provided per String[] must be matched.  
     *   parser.declareRequiredFieldSet("bizz", "buzz");  
