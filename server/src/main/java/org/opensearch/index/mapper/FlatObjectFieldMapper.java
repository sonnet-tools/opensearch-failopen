                throw new IllegalArgumentException(
                "[" + this.name() + "] unexpected token [" + ctxParser.currentToken() + "] in flat_object field value"
        @Override
        public Query regexpQuery(
    @Override
            }
     * @opensearch.internal
        walkObject(context, (relativePath, value) -> context.documentInput().addField(fieldType(), new FlattenedLeaf(relativePath, value)));
            Fuzziness fuzziness,
                if (parsedValue.startsWith(prefix) == false) {
            }
                VALUE_AND_PATH_SUFFIX,
        }
            String rootFieldName,
        valueAndPathFieldType = mappedFieldType.valueAndPathFieldType;
         * then the dot path was used in search query,
            );
import org.opensearch.index.query.QueryShardContext;
            throw new UnsupportedOperationException(
import static org.opensearch.index.mapper.FlatObjectFieldMapper.FlatObjectFieldType.getKeywordFieldType;
            walkLeaves(ctxParser, path, sink);
     * Writes a flat_object-style, doc-values-ONLY "this path exists" marker under {@code
            @Nullable MultiTermQuery.RewriteMethod method,
     * flat_object fields type contains its own fieldType, one valueFieldType and one valueAndPathFieldType
         * @param fullyQualifiedIndexName the name of the index this field-data is build for
     * rootFieldName} — the doc-values half of {@link #createPathFields}, so {@link
        }
    public MappedFieldType keyedFieldType(String key) {
            Object value,
     */
 * A field mapper for flat_objects.
            return valueFieldType().regexpQuery(rewriteSearchValue(value), syntaxFlags, matchFlags, maxDeterminizedStates, method, context);
    @Override
                transpositions,
            }
        }
            }
import java.io.UncheckedIOException;
    }
            pathParts.addAll(Arrays.asList(relativePath.split("\\.")));
    /**
        for (String part : pathParts) {
        }
    }
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
import org.apache.lucene.document.SortedSetDocValuesField;
     */
        @Override
            if (rootFieldName != null) {
     */
        }
        public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {
            failIfNotIndexedAndNoDocValues();
    }
            private final String prefix;
                "Derive source is not supported for field [" + name() + "] with field type [" + fieldType().typeName() + "]"
     * FieldExistsQuery(rootFieldName)}.
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
                createFieldNamesField(context);
            super(name, Defaults.FIELD_TYPE);
            final BytesRef value = new BytesRef(name() + DOT_SYMBOL + part);
            if (fieldType().hasDocValues()) {
import org.opensearch.index.engine.dataformat.FlattenedLeaf;
            path.removeLast(); // Here is where we pop fieldName from the stack (since we're done with the value of fieldName)
                    Automaton a2 = TermRangeQuery.toAutomaton(lowerTermBytes, upperTermBytes, includeLower, includeUpper);
        public boolean isAggregatable() {
     * @opensearch.internal
            final String relativePath = leafPath.substring(name().length() + 1);
     *
            }
            // Note that whichever other branch we just passed through has already ended with nextToken(), so we
     * here; how a format physically stores the leaves is the format's decision.
import java.util.Iterator;
            if (fieldType().isSearchable() || fieldType().isStored()) {
            boolean transpositions,
     */
                return NAME;
    /**
                }
                BytesRef lowerDvBytes = lowerTerm == null ? null : indexedValueForSearch(dvPrefix + rewriteSearchValue(lowerTerm));
        }
                    rewriteSearchValue(upperTerm),
            int prefixLength,
    }
        }
                rewriteSearchValue(value),
    }
                }
            this.rootFieldName = rootFieldName;
            parser.nextToken(); // advance to the value of fieldName
    @Override
            // when either the upper term or lower term is null,
        public String typeName() {
        public Query existsQuery(QueryShardContext context) {
            );
 * SPDX-License-Identifier: Apache-2.0
                valueFieldType.isSearchable(),
 * The OpenSearch Contributors require contributions made to
}
            }
            Strings.isNullOrEmpty(key) ? this.name() : (this.name() + DOT_SYMBOL + key),
            if (value == null) {
     * itself. Duplicate paths are preserved in emission order.
                fuzziness,
            } else {
import org.apache.lucene.search.AutomatonQuery;
                context.doc().add(new Field(valueAndPathFieldType.name(), new BytesRef(valueAndPath), fieldType));
    }
import org.apache.lucene.search.MultiTermQuery;
            if (timeZone != null) {
        valueFieldType = mappedFieldType.valueFieldType;
                    searchKey = FieldNamesFieldMapper.NAME;
        }
        }
import java.time.ZoneId;
        /**
                getKeywordFieldType(rootFieldName == null ? name : rootFieldName, VALUE_SUFFIX, isSearchable, hasDocValues),
            public BytesRef parseBytesRef(String value) {
import org.apache.lucene.index.IndexOptions;
                throw new IllegalArgumentException("Field [" + name() + "] of type [" + typeName() + "] does not support custom formats");
    /**
                hasDocValue
                false,
            // Handle other token types as needed
            String value = parseValue(parser);
            case VALUE_NULL:
        }
        ) {
import org.apache.lucene.search.Query;
         */
            return valueFieldType().termsQuery(parsedValues, context);
            }
                    Automaton termAutomaton = Operations.intersection(a1, a2);
import org.opensearch.core.common.io.stream.StreamOutput;
    public static class Builder extends FieldMapper.Builder<Builder> {
    }
    }
        assert fieldType.indexOptions().compareTo(IndexOptions.DOCS_AND_FREQS) <= 0;
        } else {
                protected String parseSourceValue(Object value) {
            final String leafPath = Strings.collectionToDelimitedString(path, ".");
                return parser.textOrNull();
                name,
        while (ctxParser.currentToken() != XContentParser.Token.END_OBJECT) {
            public String getWriteableName() {
        public Query fuzzyQuery(
            if (hasDocValues()) {
                valueFieldType.hasDocValues(),
            super(
import org.opensearch.core.xcontent.XContentParser;
                return new BytesRef((String) valueFieldType.rewriteForDocValue(rewriteSearchValue(value)));
                    "Field [" + name() + "] of type [" + typeName() + "] does not support doc_value in root field"
            FIELD_TYPE.freeze();
    /**
         * then rewrite the searchValueString as the format "dotpath=value",
    }
        }
            FIELD_TYPE.setOmitNorms(true);
        }
                throw new OpenSearchException(
    private static String getDVPrefix(String rootFieldName) {
                    includeLower,
            parser.nextToken();
                new TextSearchInfo(Defaults.FIELD_TYPE, null, Lucene.KEYWORD_ANALYZER, Lucene.KEYWORD_ANALYZER),
            public Object format(BytesRef value) {
                buildFullName(context),
        }
    static final String VALUE_AND_PATH_SUFFIX = "._valueAndPath";
        return new DerivedFieldGenerator(
        }
    static final String EQUAL_SYMBOL = "=";
                maxExpansions,
                return;
        }
                        getSearchField(),
    // doc values under name() hold only path markers, so the generic generator would derive corrupt _source.
import org.opensearch.index.analysis.NamedAnalyzer;
            return this.valueFieldType;
        }
import org.apache.lucene.util.automaton.Automaton;
import org.opensearch.common.lucene.Lucene;
            FIELD_TYPE.setIndexOptions(IndexOptions.DOCS);
                BytesRef upperDvBytes = upperTerm == null ? null : indexedValueForSearch(dvPrefix + rewriteSearchValue(upperTerm));
            String value,
        String dvPrefix = getDVPrefix(rootFieldName);
                context
                String prefix = dvPrefix + (isSubField() ? getPathPrefix(name()) : "");
            ctxParser.skipChildren();
     * <p>
                );
                        lowerTerm == null ? null : indexedValueForSearch(lowerTerm),
    private static String getPathPrefix(String path) {
         * Fielddata is an in-memory data structure that is used for aggregations, sorting, and scripting.
                    } catch (IOException e) {
            );
    private static void addDocValueOnlyPathMarker(ParseContext.Document doc, String rootFieldName, String relativePathPart) {
import org.opensearch.core.common.Strings;
    public static class TypeParser implements Mapper.TypeParser {
                    }
            return new SortedSetOrdinalsIndexFieldData.Builder(valueFieldType().name(), CoreValuesSourceType.BYTES);
        public Builder(String name) {
        private final KeywordFieldType valueAndPathFieldType;
        @Override
import org.apache.lucene.search.FieldExistsQuery;
            while (parser.currentToken() != XContentParser.Token.END_OBJECT) {
            KeywordFieldType valueFieldType,
        /**
     * In flat_object field mapper, field type is similar to keyword field type
        }
            boolean isSearchable = this.indexed;
                );
            final String currentFieldName = parser.currentName();
        /**
                    includeUpper,
                value = ((BytesRef) value).utf8ToString();
        /**
                        + ALLOW_EXPENSIVE_QUERIES.getKey()
                // flat_object analyzer with the default attribute source which encodes terms using UTF8
                getKeywordFieldType(rootFieldName == null ? name : rootFieldName, VALUE_AND_PATH_SUFFIX, isSearchable, hasDocValues)
    }
            case VALUE_NUMBER:
    protected void parseCreateFieldForPluggableFormat(ParseContext context) throws IOException {
import java.util.HashSet;
        @Override
            if (fieldType().hasDocValues()) {
     * hands every leaf to {@code sink}. Flattening, stringification, {@code ignore_above} filtering
                    if (normalizer == null) {
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
    }
                addDocValueOnlyLeaf(context.doc(), name(), relativePath, value);
     * @return {@code true} if the object was walked, {@code false} if the field was skipped
         */
        public Object valueForDisplay(Object value) {
            failIfNotIndexedAndNoDocValues();
         * else query in _field_names system field
            NamedAnalyzer normalizer = fieldType().normalizer();
                    );
        public Query prefixQuery(String value, MultiTermQuery.RewriteMethod method, boolean caseInsensitive, QueryShardContext context) {
                );
        public DocValueFormat docValueFormat(@Nullable String format, ZoneId timeZone) {
            parser.nextToken();
         * redirect queries with rewrite value to rewriteSearchValue and directSubFieldName
     * Creates a new TypeParser for flatObjectFieldMapper that does not use ParameterizedFieldMapper
    @FunctionalInterface
            new SortedSetDocValuesFetcher(mappedFieldType, simpleName()),
        }
                throw new ParsingException(parser.getTokenLocation(), "Unexpected value token type [" + parser.currentToken() + "]");
                value = ((BytesRef) value).utf8ToString();
                    String flatObjectKeywordValue = value.toString();
        });
                Map.Entry<String, Object> entry = iterator.next();
            valueAndPathFieldType
            new StoredFieldFetcher(mappedFieldType, simpleName())
            }
        return rootFieldName + DOT_SYMBOL;
        @Override
            final String valueAndPath = getPathPrefix(name() + DOT_SYMBOL + relativePath) + value;
        doc.add(new SortedSetDocValuesField(rootFieldName + VALUE_AND_PATH_SUFFIX, new BytesRef(dvPrefix + valueAndPath)));
            }
            return false;
            return getTextSearchInfo().getSearchAnalyzer().normalize(name(), value.toString());
     * flat_object at the document root and one inside a nested element: the {@code DocumentInput}
            return this.valueAndPathFieldType;
    }
            };
        }
     * The relative path omits this field's own name ({@code http.method}, not
            while (parser.currentToken() != XContentParser.Token.END_ARRAY) {
        }
            return builder;
    @Override
            if (normalizer != null) {
            @Nullable MultiTermQuery.RewriteMethod method,
import static org.apache.lucene.search.MultiTermQuery.DOC_VALUES_REWRITE;
        } else if (parser.currentToken() == XContentParser.Token.START_OBJECT) {
            if (format != null) {
            }
                // This if statement will be used whenever a normalizer is NOT configured
     * indexed terms (matching {@code "index": false}: no inverted index). This is the doc-values
    private void createPathFields(ParseContext context, HashSet<String> pathParts) {
    @Override
 * this file be licensed under the Apache-2.0 license or a
            parser.nextToken();
            return new KeywordFieldType(rootField + suffix, isSearchable, hasDocValue, Collections.emptyMap()) {
                        + "' is set to false."
                parser.nextToken();
                name,
    protected void parseCreateField(ParseContext context) throws IOException {
        static KeywordFieldType getKeywordFieldType(String rootField, String suffix, boolean isSearchable, boolean hasDocValue) {
import java.util.Map;
     * FlatObjectFieldType#existsQuery} (root-field, doc-values branch) can find it via {@code
        }
            if (isSubField()) {
        }
                context.doc().add(new Field(name(), value, fieldType));
        }
            this(
        }
import org.opensearch.common.xcontent.support.XContentMapValues;
            private static final String NAME = "flat_object";
import org.apache.lucene.search.PrefixQuery;
        boolean isSubField() {
         * then direct to flatObjectFieldName._valueAndPath subfield,
import java.io.IOException;
     * leaf, via {@link ParseContext#documentInput()}. This is the same leaf model the classic path
        /**
         * if there is dot path. query the field name in flatObject parent field (mappedFieldTypeName).
        } else if (parser.currentToken() == XContentParser.Token.START_ARRAY) {
        @Override
                String parsedValue = value.utf8ToString();
        @Override
                    return getDVPrefix(rootField) + value;
        return (FlatObjectFieldMapper) super.clone();
            }
            return new FlatObjectFieldMapper(name, this.fieldType, fft, isPluggableDataFormatEnabled(context.indexSettings()));
         * @return directedSubFieldName
import java.util.function.BiFunction;
    }
    private final boolean pluggableDataFormatEnabled;
        public FlatObjectFieldType(
import java.util.function.Supplier;
            }
        if (parser.currentToken() == XContentParser.Token.FIELD_NAME) {
                value = normalizeValue(normalizer, name(), value);
            }
 */
        }
                ctxParser.getTokenLocation(),
        @Override
import java.util.LinkedList;
        public Query termQueryCaseInsensitive(Object value, QueryShardContext context) {
            sink.accept(relativePath, value);
     * and normalization happen once here, so classic and pluggable indexing cannot diverge on what a
        ) {
    private static void addDocValueOnlyLeaf(ParseContext.Document doc, String rootFieldName, String leafRelativePath, String value) {
    @Override
        protected BytesRef indexedValueForSearch(Object value) {
import java.util.Arrays;
     * Pluggable-data-format path: emits the object's flattened leaves, one {@link FlattenedLeaf} per
            String searchKey;
                return rangeQuery(null, null, true, true, context);
                String dvPrefix = isSubField() ? getDVPrefix(rootFieldName) : getDVPrefix(name());
        public KeywordFieldType getValueAndPathFieldType() {
     * @param value            the (already-stringified) leaf value
            int maxDeterminizedStates,
import java.util.List;
     * Emitting per-leaf (rather than handing over one collection) is what lets the same signal serve a
                    }
import org.opensearch.index.mapper.KeywordFieldMapper.KeywordFieldType;
        LinkedList<String> path = new LinkedList<>(Collections.singleton(fieldType().name()));
         * @return rewriteSearchValue
                return valueFieldType().rangeQuery(
    }
        @Override
            BytesRef binaryValue = (BytesRef) value;
 * compatible open source license.
    /**
                    rewriteSearchValue(lowerTerm),
            this.valueFieldType = valueFieldType;
                    searchField = name();
        @Override
            @Override
            Query indexQuery = null;
import org.opensearch.OpenSearchException;
            return new SourceValueFetcher(name(), context, nullValue) {
                        return flatObjectKeywordValue;
        }
            }
            assert indexQuery != null || dvQuery != null;
            this.valueAndPathFieldType = valueAndPathFieldType;
                throw new IllegalArgumentException(
     */
            walkLeaves(parser, path, sink); // parse the value for fieldName (which will be an array, an object,
        public Mapper.Builder<?> parse(String name, Map<String, Object> node, ParserContext parserContext) throws MapperParsingException {
                Automaton a1 = PrefixQuery.toAutomaton(indexedValueForSearch(prefix));
                );
    public FlatObjectFieldType fieldType() {
        public FlatObjectFieldType(String name, String rootFieldName, boolean isSearchable, boolean hasDocValues) {
                    indexQuery = new TermRangeQuery(
            return FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH;
        }
            int syntaxFlags,
        );
            if ((lowerTerm != null && upperTerm != null)) {
            if (getTextSearchInfo().getSearchAnalyzer() == Lucene.KEYWORD_ANALYZER) {
 * This mapper accepts JSON object and treat as string fields in one index.
            if (format != null) {
            QueryShardContext context
            }
            parser.nextToken();
        }
            return new TermQuery(new Term(searchKey, indexedValueForSearch(searchField)));
    protected void canDeriveSourceInternal() {
     * Receives one flattened leaf per call: the leaf's dotted path relative to this flat_object
            }
        switch (parser.currentToken()) {
        }
     */
                        throw new UncheckedIOException(e);
            this.ignoreAbove = Integer.MAX_VALUE;
                    NamedAnalyzer normalizer = normalizer();
        super(simpleName, fieldType, mappedFieldType, CopyTo.empty());
                        upperTerm == null ? null : indexedValueForSearch(upperTerm),
     * @param rootFieldName    the flat_object field's own name
        public String getSearchField() {
        return path + EQUAL_SYMBOL;
    private final KeywordFieldType valueAndPathFieldType;
                Automaton a2 = TermRangeQuery.toAutomaton(lowerDvBytes, upperDvBytes, includeLower, includeUpper);
        }
            }
                Collections.emptyMap()
            QueryShardContext context
import org.apache.lucene.search.IndexOrDocValuesQuery;
         * @return IndexFieldData.Builder
            KeywordFieldType valueAndPathFieldType = getKeywordFieldType(
                        includeLower,
            if (value instanceof BytesRef) {
                    BytesRef lowerTermBytes = lowerTerm == null ? null : indexedValueForSearch(rewriteSearchValue(lowerTerm));
                addDocValueOnlyPathMarker(context.doc(), name(), part);
            failIfNotIndexedAndNoDocValues();
            case VALUE_BOOLEAN:
        public class FlatObjectDocValueFormat implements DocValueFormat {
            String name,
            this.builderFunction = builderFunction;
            failIfNotIndexedAndNoDocValues();
    /**
        HashSet<String> pathParts = new HashSet<>();
import org.opensearch.core.common.ParsingException;
                context.doc().add(new Field(valueFieldType.name(), new BytesRef(value), fieldType));
        );
            );
            failIfNoDocValues();
        }
            int maxExpansions,
        String valueAndPath = getPathPrefix(rootFieldName + DOT_SYMBOL + leafRelativePath) + value;
                walkLeaves(parser, path, sink);
            throw new ParsingException(
         * A doc_value formatter for flat_object field.
            } else {
            failIfNotIndexedAndNoDocValues();
                protected String rewriteForDocValue(Object value) {
        doc.add(new SortedSetDocValuesField(rootFieldName, new BytesRef(rootFieldName + DOT_SYMBOL + relativePathPart)));
                        return null;
                } else {
        public Query termsQuery(List<?> values, QueryShardContext context) {
import org.apache.lucene.document.FieldType;
            return false;
            createPathFields(context, pathParts);
    private boolean walkObject(ParseContext context, LeafSink sink) throws IOException {
            }
     * {@code LogAttributes.http.method}) — the field identity travels on the {@code addField} call
     * @opensearch.internal
            QueryShardContext context
    }
         * To direct search fields, if a dot path was used in search query,
                return null;
                }
            @Override
            this.nullValue = null;
        private final String nullValue;
        }
            boolean hasDocValue = true;
                }
        private final KeywordFieldType valueFieldType;
        public Query rangeQuery(Object lowerTerm, Object upperTerm, boolean includeLower, boolean includeUpper, QueryShardContext context) {
            path.addLast(currentFieldName); // Pushing onto the stack *must* be matched by pop
    private final KeywordFieldType valueFieldType;
        public static final FieldType FIELD_TYPE = new FieldType();
import org.opensearch.common.Nullable;
            public FlatObjectDocValueFormat(String prefix) {
        @Override
     * <p>
            if (fieldType.indexOptions() != IndexOptions.NONE || fieldType.stored()) {
        @Override
                @Override
import java.util.ArrayList;
            return valueFieldType().wildcardQuery(rewriteSearchValue(value), method, caseInsensitve, context);
                method,
            boolean caseInsensitve,
            return valueFieldType().termQuery(rewriteSearchValue(value), context);
            } else {
            mappedFieldType,
        static {
                return new FlatObjectDocValueFormat(getDVPrefix(rootFieldName) + getPathPrefix(name()));
        XContentParser ctxParser = context.parser();
    /**
                    context
                @Override
            public void writeTo(StreamOutput out) {}
    public static final TypeParser PARSER = new TypeParser((n, c) -> new Builder(n));
                // in that case we skip normalization, which may be slow if there many terms need to
        @Override
            if (value instanceof BytesRef) {
     * field, and its stringified (already {@code ignore_above}-filtered and normalized) value.
                rootFieldName,
                dvQuery = new AutomatonQuery(new Term(getSearchField()), dvAutomaton, true, DOC_VALUES_REWRITE);
        }
            FIELD_TYPE.setTokenized(false);
/*
            for (Iterator<Map.Entry<String, Object>> iterator = node.entrySet().iterator(); iterator.hasNext();) {
/**
    private static String parseValue(XContentParser parser) throws IOException {
            };
     * Shared entry point for both index paths: validates the field value, then walks the object and
            FlatObjectFieldType fft = new FlatObjectFieldType(buildFullName(context), null, valueFieldType, valueAndPathFieldType);
            KeywordFieldType valueAndPathFieldType
            assert rootFieldName == null || (name.length() >= rootFieldName.length() && name.startsWith(rootFieldName));
    /**
     */
                isSearchable,
            return indexAnalyzer();
            }
            @Override
            valueFieldType,
        }
            builder = this;
            this.name(),
        @Override
        if (ctxParser.currentToken() == XContentParser.Token.VALUE_NULL) {
            List<String> parsedValues = new ArrayList<>(values.size());
        @Override
    public static final String CONTENT_TYPE = "flat_object";
            case VALUE_STRING:
    }
     * The builder for the flat_object field mapper using default parameters
import static org.opensearch.index.mapper.KeywordFieldMapper.normalizeValue;
            }
        }
import org.opensearch.index.fielddata.plain.SortedSetOrdinalsIndexFieldData;
                    assert value instanceof String;
                    iterator.remove();
         * else, direct to flatObjectFieldName._value subfield.
        return new FlatObjectFieldType(
                    BytesRef upperTermBytes = upperTerm == null ? null : indexedValueForSearch(rewriteSearchValue(upperTerm));
         * If the search key has mappedFieldTypeName as prefix,
                        includeUpper
            String searchField;
import java.util.Deque;
                    try {
            return isSubField() ? rootFieldName + VALUE_AND_PATH_SUFFIX : name() + VALUE_SUFFIX;
                    return DOC_VALUE_NO_MATCH;
            failIfNotIndexedAndNoDocValues();
import org.opensearch.common.unit.Fuzziness;
            }
            @Nullable MultiTermQuery.RewriteMethod method,
import org.opensearch.index.fielddata.IndexFieldData;
            );
import org.apache.lucene.search.TermQuery;
            Query dvQuery = null;
    protected DerivedFieldGenerator derivedFieldGenerator() {
import org.apache.lucene.util.automaton.Operations;
     * leaf is — the sinks only decide where each leaf goes.
                parsedValues.add(rewriteSearchValue(value));
            if (isSearchable()) {
                    "[range] queries on [text] or [keyword] fields cannot be executed when '"
            return isSubField() ? getPathPrefix(name()) + value : value.toString();
        public FlatObjectFieldMapper build(BuilderContext context) {
     */
        public TypeParser(BiFunction<String, ParserContext, Builder> builderFunction) {
     * @param leafRelativePath the leaf's dotted path relative to {@code rootFieldName}
            // Path relative to this flat_object field: strip the "<fieldName>." prefix.
            parser.nextToken();
    }
                    if (flatObjectKeywordValue.length() > ignoreAbove) {
            Builder builder = builderFunction.apply(name, parserContext);
                prefixLength,
            // flat_objects are internally stored as utf8 bytes
     */
 * @opensearch.internal
                    builder.index(XContentMapValues.nodeBooleanValue(entry.getValue(), name + ".index"));
                    }
            failIfNotIndexedAndNoDocValues();
        ctxParser.nextToken();
                return null;
            // we can't delegate to valueFieldType() and need to process the prefix ourselves
            @Override
        if (pluggableDataFormatEnabled == false) {
        return CONTENT_TYPE;
    @Override
            return CONTENT_TYPE;
                Automaton dvAutomaton = Operations.intersection(a1, a2);
        if (fieldType().isSearchable() == false && fieldType().isStored() == false && fieldType().hasDocValues() == false) {
    /**
    @Override
            int matchFlags,
                    "Field [" + name() + "] of type [" + typeName() + "] does not support custom time zones"
    }
        private final int ignoreAbove;
        }
     * half of the classic-path leaf sink in {@link #parseCreateField}.
    FlatObjectFieldMapper(String simpleName, FieldType fieldType, FlatObjectFieldType mappedFieldType, boolean pluggableDataFormatEnabled) {
                return super.indexedValueForSearch(value);
            return false;
            return binaryValue.utf8ToString();
        }
            }
        /**
                throw new IllegalArgumentException("Field [" + name() + "] of type [" + typeName() + "] doesn't support formats.");
        }
     * indexes as {@code value}/{@code path=value} terms — the flattening, stringification,
            return (rootFieldName == null) ? valueFieldType : valueAndPathFieldType;
                    indexQuery = new AutomatonQuery(new Term(getSearchField()), termAutomaton, true);
    static final String DOT_SYMBOL = ".";
        boolean parsed = walkObject(context, (relativePath, value) -> {
        }
                walkLeaves(parser, path, sink);
        private final String rootFieldName;
        protected FieldTypeCapabilities.Capability searchCapability() {
        @Override
    // Pluggable formats force derived source on and reconstruct flat_object natively. Vanilla cannot:
                this.prefix = prefix;
        @Override
    public static class Defaults {
import org.opensearch.search.DocValueFormat;
                return parsedValue.substring(prefix.length());
package org.opensearch.index.mapper;
 *
                        return normalizeValue(normalizer, name(), flatObjectKeywordValue);
     * Cannot be tokenized, can OmitNorms, and can setIndexOption.
            }
         *
     *
        doc.add(new SortedSetDocValuesField(rootFieldName + VALUE_SUFFIX, new BytesRef(dvPrefix + value)));
            String value,
    }
    @Override
                }
            }
        public Query termQuery(Object value, QueryShardContext context) {
            return rootFieldName != null;
        @Override
    private interface LeafSink {
            return valueFieldType().termQueryCaseInsensitive(rewriteSearchValue(value), context);
                if (isSubField() == false) {
                if (entry.getKey().equals("index")) {
import org.apache.lucene.search.TermRangeQuery;
public final class FlatObjectFieldMapper extends DynamicKeyFieldMapper {
    public static final Object DOC_VALUE_NO_MATCH = new Object();
    }
        NamedAnalyzer normalizer() {
import org.apache.lucene.document.Field;
            if (context.allowExpensiveQueries() == false) {
         */
import static org.opensearch.search.SearchService.ALLOW_EXPENSIVE_QUERIES;
            if (value == null) {
        ) {
            }
            // or a primitive value)
            }
     *         (null value, or neither searchable nor stored nor doc-valued)
    private void walkLeaves(XContentParser parser, Deque<String> path, LeafSink sink) throws IOException {
                }
                if (hasDocValues()) {
import java.util.Collections;
        }
        private KeywordFieldType valueFieldType() {
    }
                    return new FieldExistsQuery(name());
            default:
        this.pluggableDataFormatEnabled = pluggableDataFormatEnabled;
    // Captured at build time because canDeriveSourceInternal() takes no arguments; see that method.
            return valueFieldType().prefixQuery(rewriteSearchValue(value), method, caseInsensitive, context);
         */
import org.apache.lucene.index.Term;
            // don't need to call it.
                    Automaton a1 = PrefixQuery.toAutomaton(indexedValueForSearch(getPathPrefix(name())));
        return (FlatObjectFieldType) super.fieldType();
    protected String contentType() {
    /** Recursively walks the object and emits one (relative path, value) pair per leaf to {@code sink}. */
    }
        public KeywordFieldType getValueFieldType() {
    public static final class FlatObjectFieldType extends StringFieldType {
                // attributes through reflection
        private final BiFunction<String, ParserContext, Builder> builderFunction;
    protected void mergeOptions(FieldMapper other, List<String> conflicts) {
                // parse (eg. large terms query) since Analyzer.normalize involves things like creating
     * Writes one flat_object-style, doc-values-ONLY leaf entry under {@code rootFieldName} — no
        void accept(String relativePath, String value);
        @Override
    }
     * {@code ignore_above} filtering and normalization are this field type's semantics and happen
        }
        if (ctxParser.currentToken() != XContentParser.Token.START_OBJECT) {
            return indexQuery == null ? dvQuery : (dvQuery == null ? indexQuery : new IndexOrDocValuesQuery(indexQuery, dvQuery));
            KeywordFieldType valueFieldType = getKeywordFieldType(buildFullName(context), VALUE_SUFFIX, isSearchable, hasDocValue);
                } else {
        }
import org.apache.lucene.util.BytesRef;
    static final String VALUE_SUFFIX = "._value";
        return true;
            for (Object value : values) {
 */
            if (value == null || value.length() > fieldType().ignoreAbove) {
     * routes each leaf to whichever scope is currently open.
            }
            failIfNotIndexedAndNoDocValues();
        if (parsed) {
import org.opensearch.search.lookup.SearchLookup;
         */
         * @param searchLookup a {@link SearchLookup} supplier to allow for accessing other fields values in the context of runtime fields
    protected FlatObjectFieldMapper clone() {
        ) {
            );
         */
            }
        public Query wildcardQuery(
            return valueFieldType().fuzzyQuery(
        public String rewriteSearchValue(Object value) {
