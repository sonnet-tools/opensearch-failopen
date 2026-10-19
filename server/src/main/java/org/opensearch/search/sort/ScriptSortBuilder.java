    /**  
     */
        return this;  
                            @Override
        } else {  
    public void writeTo(StreamOutput out) throws IOException {
     * nested filter that the nested objects should match with in
    }  
     * @opensearch.internal
    @Deprecated
                                leafScript.setDocument(doc);  
     */
    private String nestedPath;  
        /** script sort for a numeric value **/
     *
        /** script sort for a string value **/
            validateMaxChildrenExistOnlyInTopLevelNestedSort(context, nestedSort);
                        };
 *    http://www.apache.org/licenses/LICENSE-2.0
                };
     *  
    }
    @Override  
        }, NESTED_PATH_FIELD);  
        if (ScriptSortType.STRING.equals(type) && (sortMode == SortMode.SUM || sortMode == SortMode.AVG || sortMode == SortMode.MEDIAN)) {
import org.apache.lucene.index.LeafReaderContext;
            && Objects.equals(sortMode, other.sortMode)
import org.opensearch.core.xcontent.XContentParser;
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(ScriptSortBuilder.class);  
        this.nestedSort = nestedSort;
        }
                                return spare.get();
        } else {  
         */
     * @param elementName in some sort syntax variations the field name precedes the xContent object that specifies further parameters, e.g.
                            }
    }  
import org.opensearch.index.query.QueryShardContext;
        Objects.requireNonNull(script, "script cannot be null");
                    public BucketedSort newBucketedSort(
                default:
     */
            throw new IllegalArgumentException("Setting both nested_path/nested_filter and nested not allowed");
        if (nestedPath != null) {
            valueMode = order == SortOrder.DESC ? MultiValueMode.MAX : MultiValueMode.MIN;
        builder.endObject();
                        leafContextSortScriptMap.get(context).setScorer(scorer);
    public ScriptSortBuilder(Script script, ScriptSortType type) {
 * GitHub history for details.
            constructorArg(),
    }
        return fieldComparatorSource(context).newBucketedSort(context.bigArrays(), order, DocValueFormat.RAW, bucketSize, extra);
    }
    @Override
    public ScriptSortBuilder setNestedFilter(QueryBuilder nestedFilter) {
                    protected void setScorer(Scorable scorer, LeafReaderContext context) {
     * for sorting.  
                    protected SortedNumericDoubleValues getValues(LeafReaderContext context) throws IOException {
            builder.field(SORTMODE_FIELD.getPreferredName(), sortMode);
                            } catch (IOException e) {
     * @param type  
                                + type
    @Override
                return new BytesRefFieldComparatorSource(null, null, valueMode, nested) {
            deprecationLogger.deprecate("script_nested_filter", "[nested_filter] has been deprecated in favour for the [nested] parameter");
     * Sets the {@link NestedSortBuilder} to be used for fields that are inside a nested
import org.opensearch.index.fielddata.IndexFieldData;
     * Get the script used in this sort.
        return this;
            Objects.requireNonNull(str, "input string is null");
    public ScriptSortBuilder(StreamInput in) throws IOException {  
        type = ScriptSortType.readFromStream(in);
        this.script = original.script;  
                        throw new IllegalArgumentException(
    public ScriptSortType type() {
     *
     * Gets the nested filter.
     * Sets the nested path if sorting occurs on a field that is inside a nested object. For sorting by script this  
 * Unless required by applicable law or agreed to in writing,
        }
                    }
import org.opensearch.index.query.QueryRewriteContext;
            fieldSortBuilder.setNestedPath(nestedPath);
        order.writeTo(out);
    @Override
                        DocValueFormat format,
     * object. The {@link NestedSortBuilder} takes a `path` argument and an optional  
/*  
                                throw new UncheckedIOException(e);
                            "error building sort for [_script]: "  
                case ("number"):  
        if (nestedFilter != null) {
                final NumberSortScript.Factory numberSortFactory = context.compile(script, NumberSortScript.CONTEXT);
import org.opensearch.core.xcontent.XContentBuilder;
                            }
 * compatible open source license.
        return this;  
                            try {  
    @Override  
                                return true;
     */  
 *
import org.opensearch.common.logging.DeprecationLogger;
        switch (type) {
 */  
        PARSER.declareString((b, v) -> b.sortMode(SortMode.fromString(v)), SORTMODE_FIELD);
                            public boolean advanceExact(int doc) throws IOException {
    public QueryBuilder getNestedFilter() {
import org.opensearch.core.common.io.stream.StreamInput;
import java.io.UncheckedIOException;
        }  
                    protected void setScorer(Scorable scorer, LeafReaderContext context) {
        }
 * the Apache License, Version 2.0 (the "License"); you may
                            }
        this.type = type;
        if (nestedSort != null) {
    /**
            throw new IllegalArgumentException("Setting both nested_path/nested_filter and nested not allowed");
        nestedSort = in.readOptionalWriteable(NestedSortBuilder::new);
                                return numberSortScript.newInstance(ctx);
        this.sortMode = original.sortMode;  
    public String getNestedPath() {
        @Override
            && Objects.equals(nestedSort, other.nestedSort);
 */  
import org.apache.lucene.search.SortField;
        }
            }
            if (nestedSort == rewrite) {
            default:
    public Script script() {  
        builder.startObject();
        if (this.nestedSort != null) {  
                return this;  
    /**
import org.opensearch.search.DocValueFormat;
            out.writeEnum(this);  
     * Gets the nested path.  
                    return ScriptSortType.NUMBER;
        if (valueMode == null) {  
import org.opensearch.index.query.QueryShardException;  
    }
        order = SortOrder.readFromStream(in);  
 * Script sort builder allows to sort based on a custom script expression.
         * Read from a stream.
     */  
                            }
 * license agreements. See the NOTICE file distributed with
                        int bucketSize,
                        final StringSortScript leafScript = leafContextSortScriptMap.computeIfAbsent(context, ctx -> {  
import static org.opensearch.search.sort.FieldSortBuilder.validateMaxChildrenExistOnlyInTopLevelNestedSort;  
            return false;
        this.nestedPath = nestedPath;
import org.opensearch.core.ParseField;  
    /**  
                        final NumberSortScript leafScript = leafContextSortScriptMap.computeIfAbsent(context, ctx -> {
 * specific language governing permissions and limitations
        return this.nestedFilter;
        static ScriptSortType readFromStream(final StreamInput in) throws IOException {  
     * Sets the nested filter that the nested objects should match with in order to be taken into account
        builder.field(SCRIPT_FIELD.getPreferredName(), script);
    /**
                            public BytesRef binaryValue() {
     * Read from a stream.
import org.apache.lucene.util.BytesRef;
        return this.nestedPath;  
            && Objects.equals(nestedPath, other.nestedPath)  
                            @Override
    public NestedSortBuilder getNestedSort() {  
    }
                                spare.copyChars(leafScript.execute());  
     */  
        this.nestedFilter = original.nestedFilter;
import org.opensearch.index.fielddata.FieldData;
            case NUMBER:
import org.apache.lucene.util.BytesRefBuilder;  
        }
        out.writeOptionalWriteable(nestedSort);  
                    @Override
    public SortFieldAndFormat build(QueryShardContext context) throws IOException {
        sortMode = in.readOptionalWriteable(SortMode::readFromStream);
        return NAME;
            builder.field(NESTED_FILTER_FIELD.getPreferredName(), nestedFilter, builderParams);
    /**  
    /**
 * not use this file except in compliance with the License.
            return SortBuilder.parseNestedFilter(p);  
 * software distributed under the License is distributed on an
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
                        return FieldData.singleton(values);  
                            try {
    public XContentBuilder toXContent(XContentBuilder builder, Params builderParams) throws IOException {
import java.util.Locale;  
    }
        script = new Script(in);
                    // such that the functions of the class are thread safe in case of concurrent search  
            deprecationLogger.deprecate("script_nested_path", "[nested_path] has been deprecated in favor of the [nested] parameter");
        );
 *
     *  
        return builder;  
        @Override
import org.opensearch.index.fielddata.SortedBinaryDocValues;
                            @Override
 * Modifications Copyright OpenSearch Contributors. See
     *        method call
/*  
        if (nestedSort != null) {
        this.nestedFilter = nestedFilter;  
/*
                        SortOrder sortOrder,  
            nested = resolveNested(context, nestedPath, nestedFilter);
        if (this.nestedSort != null) {
        }  
        if (this.nestedFilter != null || this.nestedPath != null) {
    public SortMode sortMode() {  
 * this file be licensed under the Apache-2.0 license or a
                case ("string"):
        }
import org.opensearch.script.Script;
    }
    private final Script script;
    @Override
                    throw new IllegalArgumentException("Unknown ScriptSortType [" + str + "]");  
        nestedPath = in.readOptionalString();
    private NestedSortBuilder nestedSort;
            && Objects.equals(type, other.type)
                throw new QueryShardException(context, "custom script sort type [" + type + "] not supported");  
        }
    }
     */  
     * @deprecated set nested sort with {@link #setNestedSort(NestedSortBuilder)} and retrieve with {@link #getNestedSort()}
    /**
        PARSER.declareString((fieldSortBuilder, nestedPath) -> {  
     * Defines which distance to use for sorting in the case a document contains multiple values.<br>  
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource.Nested;  
                    // introducing a map to keep a mapping between the leaf reader context and leaf script  
     * @deprecated set nested sort with {@link #setNestedSort(NestedSortBuilder)} and retrieve with {@link #getNestedSort()}
        NAME,
                            public boolean advanceExact(int doc) throws IOException {
import java.io.IOException;
        );
                return new DoubleValuesComparatorSource(null, Double.MAX_VALUE, valueMode, nested) {
    ScriptSortBuilder(ScriptSortBuilder original) {
     * Constructs a script sort builder with the given script.
    }
            if (nestedFilter == rewrite) {
        PARSER.declareObject(ScriptSortBuilder::setNestedFilter, (p, c) -> {
                        });  
import org.opensearch.search.MultiValueMode;
        }
import static org.opensearch.search.sort.NestedSortBuilder.NESTED_FIELD;
     */
    @Deprecated
     *
        return PARSER.apply(parser, null);  
                                throw new UncheckedIOException(e);  
                                + "script sorting only supported on [numeric] scripts but was ["
            return new ScriptSortBuilder(this).setNestedSort(rewrite);
        if (nestedFilter != null) {  
        }
        PARSER.declareString((b, v) -> b.order(SortOrder.fromString(v)), ORDER_FIELD);
            DocValueFormat.RAW
    }
        if (this == object) {  
        ScriptSortBuilder other = (ScriptSortBuilder) object;  
            // new nested sorts takes priority  
/**  
    /**  
        builder.endObject();
            nested = resolveNested(context, nestedSort);
import org.opensearch.core.xcontent.ObjectParser.ValueType;
    public static final ParseField SCRIPT_FIELD = new ParseField("script");
    private final ScriptSortType type;  
    public static final ParseField TYPE_FIELD = new ParseField("type");  
                            public double doubleValue() {
        this.script = script;
            QueryBuilder rewrite = nestedFilter.rewrite(ctx);
    }
                    }
                    ) {
        this.nestedSort = original.nestedSort;  
                    protected SortedBinaryDocValues getValues(LeafReaderContext context) throws IOException {
        final Nested nested;
        Objects.requireNonNull(type, "type cannot be null");  
    public BucketedSort buildBucketedSort(QueryShardContext context, int bucketSize, BucketedSort.ExtraData extra) throws IOException {  
        NUMBER;
                final StringSortScript.LeafFactory searchScript = factory.newFactory(script.getParams(), context.lookup());
                        );
    /**
        }
        out.writeOptionalNamedWriteable(nestedFilter);
}
            }
    }  
    /**
import org.opensearch.core.common.io.stream.Writeable;  
            (parser, context) -> Script.parse(parser),
import org.opensearch.script.StringSortScript;  
    private SortMode sortMode;
    }  
        PARSER.declareField(constructorArg(), p -> ScriptSortType.fromString(p.text()), TYPE_FIELD, ValueType.STRING);  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.search.sort;
     */
    public static ScriptSortBuilder fromXContent(XContentParser parser, String elementName) {
                    }
        MultiValueMode valueMode = null;
                        });
        script.writeTo(out);  
                                leafScript.setDocument(doc);  
    public ScriptSortBuilder setNestedSort(final NestedSortBuilder nestedSort) {
     */
        return this.script;
import org.opensearch.index.fielddata.fieldcomparator.DoubleValuesComparatorSource;
    }
 * KIND, either express or implied.  See the License for the
            case STRING:
import org.opensearch.core.xcontent.XContent;  
import org.opensearch.index.fielddata.NumericDoubleValues;
                    @Override  
 * ownership. Elasticsearch licenses this file to you under  
        out.writeOptionalWriteable(sortMode);  
        builder.startObject(NAME);  
import org.opensearch.index.fielddata.fieldcomparator.BytesRefFieldComparatorSource;
        }  
    static {
                    // such that the functions of the class are thread safe in case of concurrent search
    public ScriptSortBuilder rewrite(QueryRewriteContext ctx) throws IOException {
                return this;  
            NestedSortBuilder rewrite = nestedSort.rewrite(ctx);
        if (sortMode != null) {  
        this.type = original.type;
                final NumberSortScript.LeafFactory numberSortScript = numberSortFactory.newFactory(script.getParams(), context.lookup());  
    /**
import org.opensearch.index.fielddata.AbstractBinaryDocValues;  
    }  
    /**
            builder.field(NESTED_PATH_FIELD.getPreferredName(), nestedPath);
                        final NumericDoubleValues values = new NumericDoubleValues() {  
            ValueType.OBJECT_OR_STRING
                    @Override  
                        return FieldData.singleton(values);
    }
import org.opensearch.core.xcontent.ConstructingObjectParser;
    private QueryBuilder nestedFilter;
        return this.sortMode;
        Objects.requireNonNull(sortMode, "sort mode cannot be null.");
import org.opensearch.index.fielddata.SortedNumericDoubleValues;  
        public String toString() {
    public static final String NAME = "_script";
    public int hashCode() {
        STRING,  
                            }
    }
     *            {@link ScriptSortType#NUMBER}
        return Objects.equals(script, other.script)
import java.util.concurrent.ConcurrentHashMap;  
        out.writeOptionalString(nestedPath);
     *            The script to use.
        }  
    }
     * {@link XContent} format.
     * @deprecated set nested sort with {@link #setNestedSort(NestedSortBuilder)} and retrieve with {@link #getNestedSort()}  
 *  
                    @Override
     *
        PARSER.declareField(  
 * @opensearch.internal  
        return this.type;
                        BigArrays bigArrays,
            return new ScriptSortBuilder(this).setNestedFilter(rewrite);
        }
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
    public String getWriteableName() {
            valueMode = MultiValueMode.fromString(sortMode.toString());
    }
    }  
            return in.readEnum(ScriptSortType.class);
     * Returns the {@link NestedSortBuilder}
        if (object == null || getClass() != object.getClass()) {  
                    }
                    }  
                    // introducing a map to keep a mapping between the leaf reader context and leaf script
        public void writeTo(final StreamOutput out) throws IOException {
     * Creates a new {@link ScriptSortBuilder} from the query held by the {@link XContentParser} in  
        nestedFilter = in.readOptionalNamedWriteable(QueryBuilder.class);  
        PARSER.declareObject(ScriptSortBuilder::setNestedSort, (p, c) -> NestedSortBuilder.fromXContent(p), NESTED_FIELD);
     * @deprecated set nested sort with {@link #setNestedSort(NestedSortBuilder)} and retrieve with {@link #getNestedSort()}
        a -> new ScriptSortBuilder((Script) a[0], (ScriptSortType) a[1])
        builder.field(ORDER_FIELD.getPreferredName(), order);  
        this.sortMode = sortMode;
                final StringSortScript.Factory factory = context.compile(script, StringSortScript.CONTEXT);  
        this.order = original.order;
    @Deprecated  
 * Licensed to Elasticsearch under one or more contributor  
                        leafContextSortScriptMap.get(context).setScorer(scorer);  
        return Objects.hash(script, type, order, sortMode, nestedFilter, nestedPath, nestedSort);  
    @Override  
     * Get the sort mode.
                                return searchScript.newInstance(ctx);
        return this;
            new SortField("_script", fieldComparatorSource(context), order == SortOrder.DESC),  
import org.opensearch.core.common.io.stream.StreamOutput;
    public boolean equals(Object object) {
        }  
import org.apache.lucene.index.BinaryDocValues;
                        BucketedSort.ExtraData extra  
    }  
    public ScriptSortBuilder sortMode(SortMode sortMode) {  
        return new SortFieldAndFormat(
    public static final ParseField SORTMODE_FIELD = new ParseField("mode");
                        final BinaryDocValues values = new AbstractBinaryDocValues() {
        }
public class ScriptSortBuilder extends SortBuilder<ScriptSortBuilder> {
    /**
     */  
                    final Map<LeafReaderContext, StringSortScript> leafContextSortScriptMap = new ConcurrentHashMap<>();
     *        in '{ "foo": { "order" : "asc"} }'. When parsing the inner object, the field name can be passed in via this argument  
                            final BytesRefBuilder spare = new BytesRefBuilder();
import java.util.Map;
            && Objects.equals(order, other.order)  
        if (nestedFilter == null && nestedSort == null) {  
     * For {@link ScriptSortType#STRING}, the set of possible values is restricted to {@link SortMode#MIN} and {@link SortMode#MAX}
    private IndexFieldData.XFieldComparatorSource fieldComparatorSource(QueryShardContext context) throws IOException {
     * order to be taken into account for sorting.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public enum ScriptSortType implements Writeable {
import org.opensearch.index.query.QueryBuilder;  
                    @Override  
    @Deprecated
import org.apache.lucene.search.Scorable;  
            return name().toLowerCase(Locale.ROOT);  
                                + "]"  
     */
        builder.field(TYPE_FIELD.getPreferredName(), type);
     *
    public ScriptSortBuilder setNestedPath(String nestedPath) {  
     * needs to be specified.
 */
                };  
            builder.field(NESTED_FIELD.getPreferredName(), nestedSort);
            throw new IllegalArgumentException("script sort of type [string] doesn't support mode [" + sortMode + "]");  
import java.util.Objects;
            switch (str.toLowerCase(Locale.ROOT)) {  
        this.nestedPath = original.nestedPath;
                                return true;
            Script.SCRIPT_PARSE_FIELD,  
        if (sortMode != null) {
    }
                    final Map<LeafReaderContext, NumberSortScript> leafContextSortScriptMap = new ConcurrentHashMap<>();
                                return leafScript.execute();  
     * Sort type for scripting  
            throw new IllegalArgumentException("Setting both nested_path/nested_filter and nested not allowed");  
                            }
            return true;
        }
        return this.nestedSort;
            && Objects.equals(nestedFilter, other.nestedFilter)
 */
import org.opensearch.common.util.BigArrays;
                            } catch (IOException e) {  
        }  
     * @param parser the input parser. The state on the parser contained in this context will be changed as a side effect of this  
 * under the License.  
        public static ScriptSortType fromString(final String str) {
    );  
        type.writeTo(out);
import org.opensearch.script.NumberSortScript;
    }
 * this work for additional information regarding copyright
                            @Override
    private static final ConstructingObjectParser<ScriptSortBuilder, Void> PARSER = new ConstructingObjectParser<>(  
                        };  
        }, NESTED_FILTER_FIELD);
    @Override
        }
     */  
            return this;
     * @param script
 *
     */
     *            The type of the script, can be either {@link ScriptSortType#STRING} or
            }
                    return ScriptSortType.STRING;
        /**  
     * Get the type used in this sort.
