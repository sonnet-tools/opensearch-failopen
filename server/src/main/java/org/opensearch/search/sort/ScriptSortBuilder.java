                    protected void setScorer(Scorable scorer, LeafReaderContext context) {
    public XContentBuilder toXContent(XContentBuilder builder, Params builderParams) throws IOException {
                    protected void setScorer(Scorable scorer, LeafReaderContext context) {
 * specific language governing permissions and limitations
        builder.field(ORDER_FIELD.getPreferredName(), order);
            && Objects.equals(order, other.order)
        out.writeOptionalWriteable(nestedSort);
        }
import org.opensearch.core.xcontent.ObjectParser.ValueType;
    }
    private String nestedPath;
                return new BytesRefFieldComparatorSource(null, null, valueMode, nested) {
        return this;
        MultiValueMode valueMode = null;
        }, NESTED_PATH_FIELD);
                    final Map<LeafReaderContext, StringSortScript> leafContextSortScriptMap = new ConcurrentHashMap<>();
import org.opensearch.core.common.io.stream.Writeable;
import org.opensearch.common.logging.DeprecationLogger;
    @Override
        return this.nestedPath;
                            @Override
            (parser, context) -> Script.parse(parser),
            return false;
            deprecationLogger.deprecate("script_nested_filter", "[nested_filter] has been deprecated in favour for the [nested] parameter");
        );
    @Override
        } else {
        builder.field(TYPE_FIELD.getPreferredName(), type);
     */
        return NAME;
                return new DoubleValuesComparatorSource(null, Double.MAX_VALUE, valueMode, nested) {
        out.writeOptionalNamedWriteable(nestedFilter);
    public Script script() {
                        });
                        BigArrays bigArrays,
     *
            return this;
    }
     * for sorting.
    /**
        this.script = script;
     *            The script to use.
 * under the License.
import org.opensearch.index.query.QueryShardException;
        }
    }
        return this.nestedFilter;
                        leafContextSortScriptMap.get(context).setScorer(scorer);
        if (nestedSort != null) {
     * Returns the {@link NestedSortBuilder}
import java.io.IOException;
            && Objects.equals(nestedPath, other.nestedPath)
                        DocValueFormat format,
     *            {@link ScriptSortType#NUMBER}
import org.opensearch.core.ParseField;
                    }
                            public boolean advanceExact(int doc) throws IOException {
     *
        builder.startObject(NAME);
     */
    public String getWriteableName() {
            builder.field(NESTED_FILTER_FIELD.getPreferredName(), nestedFilter, builderParams);
    public static ScriptSortBuilder fromXContent(XContentParser parser, String elementName) {
        out.writeOptionalString(nestedPath);
     * Sets the nested filter that the nested objects should match with in order to be taken into account
            fieldSortBuilder.setNestedPath(nestedPath);
                        final NumberSortScript leafScript = leafContextSortScriptMap.computeIfAbsent(context, ctx -> {
        builder.endObject();
 * @opensearch.internal
    /**
    public ScriptSortBuilder sortMode(SortMode sortMode) {
import org.apache.lucene.util.BytesRefBuilder;
         */
import org.apache.lucene.util.BytesRef;
    @Deprecated
import org.opensearch.core.xcontent.ConstructingObjectParser;
        STRING,
            valueMode = order == SortOrder.DESC ? MultiValueMode.MAX : MultiValueMode.MIN;
                    public BucketedSort newBucketedSort(
            return new ScriptSortBuilder(this).setNestedFilter(rewrite);
                default:
                    @Override
    }
        PARSER.declareField(
        );
            Objects.requireNonNull(str, "input string is null");
import java.util.Objects;
        @Override
                                throw new UncheckedIOException(e);
    /**
    public ScriptSortBuilder(Script script, ScriptSortType type) {
        this.nestedFilter = nestedFilter;
            throw new IllegalArgumentException("Setting both nested_path/nested_filter and nested not allowed");
        }
    /**
                            "error building sort for [_script]: "
        order.writeTo(out);
        a -> new ScriptSortBuilder((Script) a[0], (ScriptSortType) a[1])
    /**
        return new SortFieldAndFormat(
        }
     */
 * Licensed to Elasticsearch under one or more contributor
        this.sortMode = original.sortMode;
import org.opensearch.search.MultiValueMode;
        }
                    }
     * Get the script used in this sort.
import org.opensearch.index.query.QueryShardContext;
 */
        out.writeOptionalWriteable(sortMode);
    /**
    @Deprecated
    }
                        );
        return this;
        ScriptSortBuilder other = (ScriptSortBuilder) object;
                    }
        }
                            @Override
import org.apache.lucene.search.Scorable;
}
    private IndexFieldData.XFieldComparatorSource fieldComparatorSource(QueryShardContext context) throws IOException {
                            public boolean advanceExact(int doc) throws IOException {
    }
            DocValueFormat.RAW
     * Creates a new {@link ScriptSortBuilder} from the query held by the {@link XContentParser} in
        } else {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Script sort builder allows to sort based on a custom script expression.
         * Read from a stream.
                                return true;
        this.type = type;
                                return spare.get();
 * not use this file except in compliance with the License.
import org.opensearch.script.Script;
 * The OpenSearch Contributors require contributions made to
            && Objects.equals(nestedSort, other.nestedSort);
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.core.xcontent.XContentParser;
        static ScriptSortType readFromStream(final StreamInput in) throws IOException {
        }
    public boolean equals(Object object) {
            throw new IllegalArgumentException("Setting both nested_path/nested_filter and nested not allowed");
                final NumberSortScript.LeafFactory numberSortScript = numberSortFactory.newFactory(script.getParams(), context.lookup());
    }
        NUMBER;
    /**
     * {@link XContent} format.
        script.writeTo(out);
    /**
        builder.startObject();
                            @Override
        }, NESTED_FILTER_FIELD);
                                + type
                                spare.copyChars(leafScript.execute());
        sortMode = in.readOptionalWriteable(SortMode::readFromStream);
        if (object == null || getClass() != object.getClass()) {
                                + "script sorting only supported on [numeric] scripts but was ["
            nested = resolveNested(context, nestedPath, nestedFilter);
            return name().toLowerCase(Locale.ROOT);
 * this work for additional information regarding copyright
     * @param script
    }
    public NestedSortBuilder getNestedSort() {
     */
    }
    public void writeTo(StreamOutput out) throws IOException {
 * license agreements. See the NOTICE file distributed with
 *
                            @Override
    }
    /**
        builder.field(SCRIPT_FIELD.getPreferredName(), script);
        this.nestedSort = nestedSort;
    );
        }
        PARSER.declareObject(ScriptSortBuilder::setNestedSort, (p, c) -> NestedSortBuilder.fromXContent(p), NESTED_FIELD);
 * software distributed under the License is distributed on an
import org.opensearch.script.NumberSortScript;
                                return true;
    public SortMode sortMode() {
     * Get the type used in this sort.
 * Modifications Copyright OpenSearch Contributors. See
     */
                    final Map<LeafReaderContext, NumberSortScript> leafContextSortScriptMap = new ConcurrentHashMap<>();
                        return FieldData.singleton(values);
        if (this.nestedSort != null) {
     * Read from a stream.
                            }
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(ScriptSortBuilder.class);
        return this.nestedSort;
import org.opensearch.search.DocValueFormat;
        PARSER.declareString((b, v) -> b.sortMode(SortMode.fromString(v)), SORTMODE_FIELD);
     * Get the sort mode.
import static org.opensearch.search.sort.NestedSortBuilder.NESTED_FIELD;
                    @Override
 * compatible open source license.
        return this;
    static {
        if (this == object) {
    @Deprecated
            default:
     *            The type of the script, can be either {@link ScriptSortType#STRING} or
            }
        PARSER.declareString((b, v) -> b.order(SortOrder.fromString(v)), ORDER_FIELD);
    @Deprecated
 *
import org.opensearch.core.common.io.stream.StreamOutput;
    }
import org.opensearch.index.fielddata.fieldcomparator.BytesRefFieldComparatorSource;
import org.opensearch.index.query.QueryBuilder;
        }
                            try {
                    // such that the functions of the class are thread safe in case of concurrent search
                        SortOrder sortOrder,
     * Constructs a script sort builder with the given script.
    private static final ConstructingObjectParser<ScriptSortBuilder, Void> PARSER = new ConstructingObjectParser<>(
                return this;
    @Override
    public ScriptSortBuilder setNestedPath(String nestedPath) {
        return fieldComparatorSource(context).newBucketedSort(context.bigArrays(), order, DocValueFormat.RAW, bucketSize, extra);
        Objects.requireNonNull(script, "script cannot be null");
    public ScriptSortBuilder rewrite(QueryRewriteContext ctx) throws IOException {
        return Objects.equals(script, other.script)
            case NUMBER:
        this.nestedPath = original.nestedPath;
     * @param parser the input parser. The state on the parser contained in this context will be changed as a side effect of this
            deprecationLogger.deprecate("script_nested_path", "[nested_path] has been deprecated in favor of the [nested] parameter");
                                return leafScript.execute();
    private final Script script;
    public ScriptSortBuilder(StreamInput in) throws IOException {
        public String toString() {
            throw new IllegalArgumentException("Setting both nested_path/nested_filter and nested not allowed");
                                return searchScript.newInstance(ctx);
     *
        return Objects.hash(script, type, order, sortMode, nestedFilter, nestedPath, nestedSort);
        this.script = original.script;
                            }
            return in.readEnum(ScriptSortType.class);
        if (nestedPath != null) {
            constructorArg(),
            QueryBuilder rewrite = nestedFilter.rewrite(ctx);
                throw new QueryShardException(context, "custom script sort type [" + type + "] not supported");
                                leafScript.setDocument(doc);
 */
                        BucketedSort.ExtraData extra
import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.search.SortField;
        }
        order = SortOrder.readFromStream(in);
 */
     */
            if (nestedSort == rewrite) {
                        final BinaryDocValues values = new AbstractBinaryDocValues() {
import org.opensearch.core.xcontent.XContent;
                            }
    public ScriptSortType type() {
                    }
                                return numberSortScript.newInstance(ctx);
    public static final ParseField TYPE_FIELD = new ParseField("type");
                final StringSortScript.LeafFactory searchScript = factory.newFactory(script.getParams(), context.lookup());
            && Objects.equals(nestedFilter, other.nestedFilter)
        nestedPath = in.readOptionalString();
 */
     *
                case ("number"):
     * @deprecated set nested sort with {@link #setNestedSort(NestedSortBuilder)} and retrieve with {@link #getNestedSort()}
            switch (str.toLowerCase(Locale.ROOT)) {
 * this file be licensed under the Apache-2.0 license or a
            nested = resolveNested(context, nestedSort);
public class ScriptSortBuilder extends SortBuilder<ScriptSortBuilder> {
            case STRING:
                        int bucketSize,
     */
            builder.field(NESTED_FIELD.getPreferredName(), nestedSort);
import org.opensearch.script.StringSortScript;
        if (nestedFilter != null) {
     * Sort type for scripting
                return this;
     *
        this.nestedSort = original.nestedSort;
    }
    public String getNestedPath() {
 * GitHub history for details.
        NAME,
    /**
        switch (type) {
 *
                                leafScript.setDocument(doc);
        }
 * ownership. Elasticsearch licenses this file to you under
        public static ScriptSortType fromString(final String str) {
        nestedFilter = in.readOptionalNamedWriteable(QueryBuilder.class);
import java.util.concurrent.ConcurrentHashMap;
            validateMaxChildrenExistOnlyInTopLevelNestedSort(context, nestedSort);
/*
import org.apache.lucene.index.BinaryDocValues;
                            }
     */
                        final NumericDoubleValues values = new NumericDoubleValues() {
    public ScriptSortBuilder setNestedSort(final NestedSortBuilder nestedSort) {
     * @deprecated set nested sort with {@link #setNestedSort(NestedSortBuilder)} and retrieve with {@link #getNestedSort()}
                        };
        if (valueMode == null) {
        PARSER.declareField(constructorArg(), p -> ScriptSortType.fromString(p.text()), TYPE_FIELD, ValueType.STRING);
    @Override
        script = new Script(in);
    /**
/**
        PARSER.declareString((fieldSortBuilder, nestedPath) -> {
        }
        nestedSort = in.readOptionalWriteable(NestedSortBuilder::new);
    }
    }
                    }
                        return FieldData.singleton(values);
     * needs to be specified.
import java.util.Locale;
            new SortField("_script", fieldComparatorSource(context), order == SortOrder.DESC),
    /**
     * Sets the nested path if sorting occurs on a field that is inside a nested object. For sorting by script this
                case ("string"):
import java.io.UncheckedIOException;
                            public double doubleValue() {
/*
                        leafContextSortScriptMap.get(context).setScorer(scorer);
     */
     */
        if (this.nestedSort != null) {
 * the Apache License, Version 2.0 (the "License"); you may
            out.writeEnum(this);
        this.order = original.order;
        return this.script;
                };
import org.opensearch.index.query.QueryRewriteContext;
        }
     * @param elementName in some sort syntax variations the field name precedes the xContent object that specifies further parameters, e.g.
     * Defines which distance to use for sorting in the case a document contains multiple values.<br>
            builder.field(SORTMODE_FIELD.getPreferredName(), sortMode);
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
            throw new IllegalArgumentException("script sort of type [string] doesn't support mode [" + sortMode + "]");
     *        in '{ "foo": { "order" : "asc"} }'. When parsing the inner object, the field name can be passed in via this argument
                            } catch (IOException e) {
                    @Override
        if (nestedSort != null) {
                    return ScriptSortType.STRING;
        return this.type;
                            }
     * object. The {@link NestedSortBuilder} takes a `path` argument and an optional
import org.opensearch.index.fielddata.fieldcomparator.DoubleValuesComparatorSource;
        }
        PARSER.declareObject(ScriptSortBuilder::setNestedFilter, (p, c) -> {
        /**
     * Gets the nested filter.
            // new nested sorts takes priority
        }
            }
    private final ScriptSortType type;
                    // such that the functions of the class are thread safe in case of concurrent search
        }
     * @param type
                    // introducing a map to keep a mapping between the leaf reader context and leaf script
import org.opensearch.index.fielddata.IndexFieldData;
        type = ScriptSortType.readFromStream(in);
                    protected SortedNumericDoubleValues getValues(LeafReaderContext context) throws IOException {
     */
        /** script sort for a numeric value **/
        if (this.nestedFilter != null || this.nestedPath != null) {
    public static final ParseField SCRIPT_FIELD = new ParseField("script");
    }
     * @opensearch.internal
        Objects.requireNonNull(type, "type cannot be null");
        this.nestedFilter = original.nestedFilter;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
     */
                final NumberSortScript.Factory numberSortFactory = context.compile(script, NumberSortScript.CONTEXT);
        }
     * Gets the nested path.
    public enum ScriptSortType implements Writeable {
                        };
                            }
    public int hashCode() {
    private NestedSortBuilder nestedSort;
        if (sortMode != null) {
                            final BytesRefBuilder spare = new BytesRefBuilder();
        @Override
            valueMode = MultiValueMode.fromString(sortMode.toString());
import java.util.Map;
    }
    }
        this.sortMode = sortMode;
    private SortMode sortMode;
     * nested filter that the nested objects should match with in
    @Override
            && Objects.equals(type, other.type)
     *
        public void writeTo(final StreamOutput out) throws IOException {
        return this;
import static org.opensearch.search.sort.FieldSortBuilder.validateMaxChildrenExistOnlyInTopLevelNestedSort;
                    @Override
        final Nested nested;
        builder.endObject();
     */
        if (ScriptSortType.STRING.equals(type) && (sortMode == SortMode.SUM || sortMode == SortMode.AVG || sortMode == SortMode.MEDIAN)) {
    }
                    return ScriptSortType.NUMBER;
                };
    }
            if (nestedFilter == rewrite) {
 * SPDX-License-Identifier: Apache-2.0
     * @deprecated set nested sort with {@link #setNestedSort(NestedSortBuilder)} and retrieve with {@link #getNestedSort()}
 *
    public static final ParseField SORTMODE_FIELD = new ParseField("mode");
    }
                            } catch (IOException e) {
    }
        return PARSER.apply(parser, null);
                                + "]"
    /**
    }
    }
    @Override
import org.opensearch.index.fielddata.SortedBinaryDocValues;
import org.opensearch.core.xcontent.XContentBuilder;
    /**
    public QueryBuilder getNestedFilter() {
                        throw new IllegalArgumentException(
            return SortBuilder.parseNestedFilter(p);
import org.opensearch.index.fielddata.AbstractBinaryDocValues;
    @Override
            return new ScriptSortBuilder(this).setNestedSort(rewrite);
        return this.sortMode;
     * For {@link ScriptSortType#STRING}, the set of possible values is restricted to {@link SortMode#MIN} and {@link SortMode#MAX}
import org.opensearch.index.fielddata.FieldData;
     * order to be taken into account for sorting.
            builder.field(NESTED_PATH_FIELD.getPreferredName(), nestedPath);
                            try {
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource.Nested;
    public SortFieldAndFormat build(QueryShardContext context) throws IOException {
        type.writeTo(out);
            }
 * KIND, either express or implied.  See the License for the
import org.opensearch.index.fielddata.NumericDoubleValues;
        if (nestedFilter == null && nestedSort == null) {
                    ) {
     *        method call
                        });
    public BucketedSort buildBucketedSort(QueryShardContext context, int bucketSize, BucketedSort.ExtraData extra) throws IOException {
            && Objects.equals(sortMode, other.sortMode)
                    throw new IllegalArgumentException("Unknown ScriptSortType [" + str + "]");
            NestedSortBuilder rewrite = nestedSort.rewrite(ctx);
        }
    private QueryBuilder nestedFilter;
    @Override
     */
 * Unless required by applicable law or agreed to in writing,
                        final StringSortScript leafScript = leafContextSortScriptMap.computeIfAbsent(context, ctx -> {
        if (nestedFilter != null) {
                final StringSortScript.Factory factory = context.compile(script, StringSortScript.CONTEXT);
            return true;
        this.type = original.type;
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
     * Sets the {@link NestedSortBuilder} to be used for fields that are inside a nested
        this.nestedPath = nestedPath;
        /** script sort for a string value **/
    public static final String NAME = "_script";
     * @deprecated set nested sort with {@link #setNestedSort(NestedSortBuilder)} and retrieve with {@link #getNestedSort()}
/*
                    // introducing a map to keep a mapping between the leaf reader context and leaf script
package org.opensearch.search.sort;
                                throw new UncheckedIOException(e);
    ScriptSortBuilder(ScriptSortBuilder original) {
     *
    }
            Script.SCRIPT_PARSE_FIELD,
        }
 * You may obtain a copy of the License at
                    @Override
        return builder;
                    protected SortedBinaryDocValues getValues(LeafReaderContext context) throws IOException {
    public ScriptSortBuilder setNestedFilter(QueryBuilder nestedFilter) {
    }
                            public BytesRef binaryValue() {
import org.opensearch.common.util.BigArrays;
            ValueType.OBJECT_OR_STRING
        if (sortMode != null) {
        Objects.requireNonNull(sortMode, "sort mode cannot be null.");
