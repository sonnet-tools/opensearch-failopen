                ctxParser.getTokenLocation(),
        public Query fuzzyQuery(
            if (value == null) {
import org.opensearch.index.analysis.NamedAnalyzer;
import org.opensearch.index.query.QueryShardContext;
         * @param searchLookup a {@link SearchLookup} supplier to allow for accessing other fields values in the context of runtime fields  
         */
    }
                // parse (eg. large terms query) since Analyzer.normalize involves things like creating
            if (isSearchable()) {
            createPathFields(context, pathParts);
            while (parser.currentToken() != XContentParser.Token.END_OBJECT) {
     * @opensearch.internal  
            boolean hasDocValue = true;
        ) {
            return false;
                    String flatObjectKeywordValue = value.toString();  
            boolean caseInsensitve,  
     */
            failIfNotIndexedAndNoDocValues();
        }  
            if (fieldType.indexOptions() != IndexOptions.NONE || fieldType.stored()) {  
        public Object valueForDisplay(Object value) {  
    @Override
            if ((lowerTerm != null && upperTerm != null)) {  
        public Query regexpQuery(  
        public TypeParser(BiFunction<String, ParserContext, Builder> builderFunction) {
                String dvPrefix = isSubField() ? getDVPrefix(rootFieldName) : getDVPrefix(name());  
import org.apache.lucene.search.TermQuery;  
import org.opensearch.index.mapper.KeywordFieldMapper.KeywordFieldType;
                fuzziness,
            parser.nextToken();
                    rewriteSearchValue(upperTerm),  
            return new SortedSetOrdinalsIndexFieldData.Builder(valueFieldType().name(), CoreValuesSourceType.BYTES);  
                        upperTerm == null ? null : indexedValueForSearch(upperTerm),
                    searchField = name();
        static KeywordFieldType getKeywordFieldType(String rootField, String suffix, boolean isSearchable, boolean hasDocValue) {  
        walkObject(context, (relativePath, value) -> context.documentInput().addField(fieldType(), new FlattenedLeaf(relativePath, value)));
            valueAndPathFieldType
            }  
        valueAndPathFieldType = mappedFieldType.valueAndPathFieldType;  
import org.opensearch.index.fielddata.plain.SortedSetOrdinalsIndexFieldData;  
            new SortedSetDocValuesFetcher(mappedFieldType, simpleName()),
            Object value,
            @Nullable MultiTermQuery.RewriteMethod method,
            public Object format(BytesRef value) {  
                }  
    protected FlatObjectFieldMapper clone() {
import org.opensearch.core.common.ParsingException;
        return path + EQUAL_SYMBOL;
     * leaf is — the sinks only decide where each leaf goes.  
    // Pluggable formats force derived source on and reconstruct flat_object natively. Vanilla cannot:
            if (format != null) {
                VALUE_AND_PATH_SUFFIX,
import org.apache.lucene.document.FieldType;
 * compatible open source license.
            boolean isSearchable = this.indexed;  
                    Automaton termAutomaton = Operations.intersection(a1, a2);
                new TextSearchInfo(Defaults.FIELD_TYPE, null, Lucene.KEYWORD_ANALYZER, Lucene.KEYWORD_ANALYZER),
                valueFieldType.hasDocValues(),  
            return new KeywordFieldType(rootField + suffix, isSearchable, hasDocValue, Collections.emptyMap()) {
            }  
            }  
    @Override  
                return new BytesRef((String) valueFieldType.rewriteForDocValue(rewriteSearchValue(value)));
     * flat_object fields type contains its own fieldType, one valueFieldType and one valueAndPathFieldType  
     * FlatObjectFieldType#existsQuery} (root-field, doc-values branch) can find it via {@code
            // we can't delegate to valueFieldType() and need to process the prefix ourselves
                getKeywordFieldType(rootFieldName == null ? name : rootFieldName, VALUE_AND_PATH_SUFFIX, isSearchable, hasDocValues)
            return isSubField() ? getPathPrefix(name()) + value : value.toString();
    }
    @Override
                method,
            }
    private static String getPathPrefix(String path) {  
        }  
            }
            final BytesRef value = new BytesRef(name() + DOT_SYMBOL + part);
         * if there is dot path. query the field name in flatObject parent field (mappedFieldTypeName).  
            if (timeZone != null) {
        @Override  
            int syntaxFlags,
    private final KeywordFieldType valueAndPathFieldType;
        return rootFieldName + DOT_SYMBOL;  
    public static class Defaults {
        return CONTENT_TYPE;  
        @Override
        public FlatObjectFieldMapper build(BuilderContext context) {
            case VALUE_NULL:
import org.opensearch.index.fielddata.IndexFieldData;
                        return flatObjectKeywordValue;
            if (value == null) {
        public Query termQueryCaseInsensitive(Object value, QueryShardContext context) {
        /**
            return isSubField() ? rootFieldName + VALUE_AND_PATH_SUFFIX : name() + VALUE_SUFFIX;  
        String dvPrefix = getDVPrefix(rootFieldName);
    }
        }
                    rewriteSearchValue(lowerTerm),
                    Automaton a1 = PrefixQuery.toAutomaton(indexedValueForSearch(getPathPrefix(name())));  
import static org.opensearch.index.mapper.KeywordFieldMapper.normalizeValue;
    protected String contentType() {
            for (Iterator<Map.Entry<String, Object>> iterator = node.entrySet().iterator(); iterator.hasNext();) {  
                        throw new UncheckedIOException(e);
            // flat_objects are internally stored as utf8 bytes
    @Override  
            if (fieldType().hasDocValues()) {
        }  
            return false;  
            }
    private static void addDocValueOnlyPathMarker(ParseContext.Document doc, String rootFieldName, String relativePathPart) {
     * Writes a flat_object-style, doc-values-ONLY "this path exists" marker under {@code  
import java.util.function.Supplier;
                throw new IllegalArgumentException(  
     * @opensearch.internal
    private final KeywordFieldType valueFieldType;  
            // don't need to call it.
    }  
    }
}
            String name,  
import org.opensearch.search.lookup.SearchLookup;
    private void walkLeaves(XContentParser parser, Deque<String> path, LeafSink sink) throws IOException {
        @Override  
            FIELD_TYPE.freeze();  
                rootFieldName,
import org.apache.lucene.search.Query;
import org.apache.lucene.search.IndexOrDocValuesQuery;
                false,
    private static String getDVPrefix(String rootFieldName) {
         * then the dot path was used in search query,
            }
            return new SourceValueFetcher(name(), context, nullValue) {  
    protected void canDeriveSourceInternal() {
            } else {
                context.doc().add(new Field(valueFieldType.name(), new BytesRef(value), fieldType));  
            failIfNotIndexedAndNoDocValues();  
                if (isSubField() == false) {  
         *  
     * and normalization happen once here, so classic and pluggable indexing cannot diverge on what a
         */
import org.apache.lucene.search.FieldExistsQuery;
            }
        /**  
            sink.accept(relativePath, value);
        }  
                hasDocValue
    }
        public DocValueFormat docValueFormat(@Nullable String format, ZoneId timeZone) {  
        if (parser.currentToken() == XContentParser.Token.FIELD_NAME) {  
    }
            parser.nextToken(); // advance to the value of fieldName  
        private final int ignoreAbove;
            final String leafPath = Strings.collectionToDelimitedString(path, ".");
         * then direct to flatObjectFieldName._valueAndPath subfield,
            }
            pathParts.addAll(Arrays.asList(relativePath.split("\\.")));
import java.util.List;
        }
                    "[range] queries on [text] or [keyword] fields cannot be executed when '"
        @Override  
import java.util.ArrayList;
     */
    static final String EQUAL_SYMBOL = "=";
import org.opensearch.OpenSearchException;
        /**  
    private final boolean pluggableDataFormatEnabled;  
            }  
     * {@code ignore_above} filtering and normalization are this field type's semantics and happen
        } else if (parser.currentToken() == XContentParser.Token.START_ARRAY) {  
                if (parsedValue.startsWith(prefix) == false) {
                if (entry.getKey().equals("index")) {
     * Receives one flattened leaf per call: the leaf's dotted path relative to this flat_object  
            if (hasDocValues()) {
/**  
        }  
        while (ctxParser.currentToken() != XContentParser.Token.END_OBJECT) {
            );  
                        + ALLOW_EXPENSIVE_QUERIES.getKey()  
            FIELD_TYPE.setTokenized(false);  
                throw new OpenSearchException(
                throw new ParsingException(parser.getTokenLocation(), "Unexpected value token type [" + parser.currentToken() + "]");  
    private boolean walkObject(ParseContext context, LeafSink sink) throws IOException {
    /**
        }  
            public void writeTo(StreamOutput out) {}  
    public static final class FlatObjectFieldType extends StringFieldType {  
    public static class Builder extends FieldMapper.Builder<Builder> {  
                }
        }
        ) {
            failIfNotIndexedAndNoDocValues();
            super(
    }  
        }
    /**  
     * rootFieldName} — the doc-values half of {@link #createPathFields}, so {@link
            super(name, Defaults.FIELD_TYPE);  
            }
        private final BiFunction<String, ParserContext, Builder> builderFunction;  
            int maxDeterminizedStates,
                        return null;  
                return parsedValue.substring(prefix.length());
            }  
import org.apache.lucene.search.TermRangeQuery;
         * else query in _field_names system field
        @Override  
     * leaf, via {@link ParseContext#documentInput()}. This is the same leaf model the classic path
        LinkedList<String> path = new LinkedList<>(Collections.singleton(fieldType().name()));  
import org.opensearch.common.unit.Fuzziness;
            path.removeLast(); // Here is where we pop fieldName from the stack (since we're done with the value of fieldName)  
            Builder builder = builderFunction.apply(name, parserContext);
        @Override  
import org.opensearch.common.Nullable;  
                    }
            }  
         * @return directedSubFieldName  
        if (pluggableDataFormatEnabled == false) {  
    public static class TypeParser implements Mapper.TypeParser {
     *         (null value, or neither searchable nor stored nor doc-valued)  
            if (context.allowExpensiveQueries() == false) {  
            Query indexQuery = null;  
            this.rootFieldName = rootFieldName;
     * @param value            the (already-stringified) leaf value
        }
            return FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH;
                return rangeQuery(null, null, true, true, context);
        return new FlatObjectFieldType(  
import org.apache.lucene.util.automaton.Operations;
            @Override  
    }  
        }  
            valueFieldType,  
    protected DerivedFieldGenerator derivedFieldGenerator() {
            parser.nextToken();
            new StoredFieldFetcher(mappedFieldType, simpleName())  
    }
        ) {
         */
import static org.opensearch.search.SearchService.ALLOW_EXPENSIVE_QUERIES;  
            }
                context  
    @Override
                name,  
 * This mapper accepts JSON object and treat as string fields in one index.
        @Override
                    BytesRef upperTermBytes = upperTerm == null ? null : indexedValueForSearch(rewriteSearchValue(upperTerm));
                    searchKey = FieldNamesFieldMapper.NAME;
            } else {  
            return getTextSearchInfo().getSearchAnalyzer().normalize(name(), value.toString());
            QueryShardContext context
                } else {  
         * A doc_value formatter for flat_object field.
     * The relative path omits this field's own name ({@code http.method}, not
            return valueFieldType().prefixQuery(rewriteSearchValue(value), method, caseInsensitive, context);
        /**
                throw new IllegalArgumentException("Field [" + name() + "] of type [" + typeName() + "] doesn't support formats.");  
                Automaton dvAutomaton = Operations.intersection(a1, a2);  
                if (hasDocValues()) {
                    includeUpper,
            }
            return rootFieldName != null;
import java.util.Deque;
            return valueFieldType().termsQuery(parsedValues, context);
                maxExpansions,  
        public KeywordFieldType getValueFieldType() {
                        includeUpper  
            BytesRef binaryValue = (BytesRef) value;
     */
            return valueFieldType().wildcardQuery(rewriteSearchValue(value), method, caseInsensitve, context);
 */
            return builder;
            }
import org.apache.lucene.util.BytesRef;
                Collections.emptyMap()
            return this.valueAndPathFieldType;  
                value = normalizeValue(normalizer, name(), value);
import java.util.Iterator;  
            if (getTextSearchInfo().getSearchAnalyzer() == Lucene.KEYWORD_ANALYZER) {
        }
            return indexAnalyzer();
            return binaryValue.utf8ToString();  
        }
            mappedFieldType,
            for (Object value : values) {
            parser.nextToken();
            if (isSubField()) {
            case VALUE_STRING:
            failIfNotIndexedAndNoDocValues();
                "Derive source is not supported for field [" + name() + "] with field type [" + fieldType().typeName() + "]"
            if (value instanceof BytesRef) {
    public MappedFieldType keyedFieldType(String key) {
     * itself. Duplicate paths are preserved in emission order.  
            @Override
                value = ((BytesRef) value).utf8ToString();
                addDocValueOnlyLeaf(context.doc(), name(), relativePath, value);
    FlatObjectFieldMapper(String simpleName, FieldType fieldType, FlatObjectFieldType mappedFieldType, boolean pluggableDataFormatEnabled) {
        }
        }
        if (ctxParser.currentToken() == XContentParser.Token.VALUE_NULL) {
            this.builderFunction = builderFunction;  
            }
            public FlatObjectDocValueFormat(String prefix) {
     *
            default:
        }  
        }
            if (format != null) {
        @Override  
     * flat_object at the document root and one inside a nested element: the {@code DocumentInput}  
         * @param fullyQualifiedIndexName the name of the index this field-data is build for
package org.opensearch.index.mapper;
                        return normalizeValue(normalizer, name(), flatObjectKeywordValue);  
            builder = this;
     * Pluggable-data-format path: emits the object's flattened leaves, one {@link FlattenedLeaf} per
                    }  
        return (FlatObjectFieldMapper) super.clone();  
            return new TermQuery(new Term(searchKey, indexedValueForSearch(searchField)));
    /** Recursively walks the object and emits one (relative path, value) pair per leaf to {@code sink}. */
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
        @Override  
                parser.nextToken();  
        public FlatObjectFieldType(String name, String rootFieldName, boolean isSearchable, boolean hasDocValues) {
import org.opensearch.core.xcontent.XContentParser;
    // Captured at build time because canDeriveSourceInternal() takes no arguments; see that method.
        }  
        boolean isSubField() {
         * else, direct to flatObjectFieldName._value subfield.
                context.doc().add(new Field(name(), value, fieldType));
                this.prefix = prefix;  
        @Override  
            );
    @Override
            failIfNoDocValues();
            }  
import java.util.Map;  
                    return new FieldExistsQuery(name());
        }
            if (rootFieldName != null) {  
    public FlatObjectFieldType fieldType() {
                Map.Entry<String, Object> entry = iterator.next();
            // when either the upper term or lower term is null,
        }
            }  
            parser.nextToken();
                walkLeaves(parser, path, sink);  
            throw new ParsingException(  
import org.opensearch.core.common.io.stream.StreamOutput;  
        super(simpleName, fieldType, mappedFieldType, CopyTo.empty());  
            return valueFieldType().termQueryCaseInsensitive(rewriteSearchValue(value), context);  
        doc.add(new SortedSetDocValuesField(rootFieldName, new BytesRef(rootFieldName + DOT_SYMBOL + relativePathPart)));  
        doc.add(new SortedSetDocValuesField(rootFieldName + VALUE_SUFFIX, new BytesRef(dvPrefix + value)));  
                prefixLength,
                );
    /**  
                value = ((BytesRef) value).utf8ToString();  
    /**
                parsedValues.add(rewriteSearchValue(value));
 * SPDX-License-Identifier: Apache-2.0
            KeywordFieldType valueFieldType,
                    NamedAnalyzer normalizer = normalizer();  
            }  
                @Override
     * The builder for the flat_object field mapper using default parameters  
    public static final Object DOC_VALUE_NO_MATCH = new Object();
        return new DerivedFieldGenerator(  
    /**
    }
        public String rewriteSearchValue(Object value) {  
                // This if statement will be used whenever a normalizer is NOT configured
/*  
                    return DOC_VALUE_NO_MATCH;  
        }
        @Override  
    @Override
        }  
            public String getWriteableName() {
            return valueFieldType().regexpQuery(rewriteSearchValue(value), syntaxFlags, matchFlags, maxDeterminizedStates, method, context);  
    private interface LeafSink {
                return new FlatObjectDocValueFormat(getDVPrefix(rootFieldName) + getPathPrefix(name()));
        private final String nullValue;  
        }  
     * half of the classic-path leaf sink in {@link #parseCreateField}.
            // Handle other token types as needed
            path.addLast(currentFieldName); // Pushing onto the stack *must* be matched by pop
            // or a primitive value)
                    if (normalizer == null) {
        });  
    }
        @Override  
            }  
        @Override
                return valueFieldType().rangeQuery(
            @Override
        public static final FieldType FIELD_TYPE = new FieldType();  
        public Query existsQuery(QueryShardContext context) {
         */
     * Writes one flat_object-style, doc-values-ONLY leaf entry under {@code rootFieldName} — no
 * this file be licensed under the Apache-2.0 license or a
    private static void addDocValueOnlyLeaf(ParseContext.Document doc, String rootFieldName, String leafRelativePath, String value) {
        }  
        protected FieldTypeCapabilities.Capability searchCapability() {  
    }
            int maxExpansions,
        HashSet<String> pathParts = new HashSet<>();
        }  
         * If the search key has mappedFieldTypeName as prefix,
                addDocValueOnlyPathMarker(context.doc(), name(), part);
                BytesRef upperDvBytes = upperTerm == null ? null : indexedValueForSearch(dvPrefix + rewriteSearchValue(upperTerm));
    }
            }  
    /**
        this.pluggableDataFormatEnabled = pluggableDataFormatEnabled;
        boolean parsed = walkObject(context, (relativePath, value) -> {  
    }  
            } else {
                rewriteSearchValue(value),  
        }
            @Override
            final String valueAndPath = getPathPrefix(name() + DOT_SYMBOL + relativePath) + value;
        private final KeywordFieldType valueFieldType;
            if (normalizer != null) {
                        includeLower,
     */
        public Query prefixQuery(String value, MultiTermQuery.RewriteMethod method, boolean caseInsensitive, QueryShardContext context) {  
    }
            assert rootFieldName == null || (name.length() >= rootFieldName.length() && name.startsWith(rootFieldName));
        String valueAndPath = getPathPrefix(rootFieldName + DOT_SYMBOL + leafRelativePath) + value;
        private final KeywordFieldType valueAndPathFieldType;  
    @Override  
        }
            return this.valueFieldType;
        @Override
                    );
            QueryShardContext context  
         * then rewrite the searchValueString as the format "dotpath=value",  
                    "Field [" + name() + "] of type [" + typeName() + "] does not support custom time zones"  
        public Query wildcardQuery(  
        }
            };
    static final String VALUE_SUFFIX = "._value";
        }
        );
                    if (flatObjectKeywordValue.length() > ignoreAbove) {
                buildFullName(context),
            String value,
            FIELD_TYPE.setIndexOptions(IndexOptions.DOCS);
                BytesRef lowerDvBytes = lowerTerm == null ? null : indexedValueForSearch(dvPrefix + rewriteSearchValue(lowerTerm));  
public final class FlatObjectFieldMapper extends DynamicKeyFieldMapper {
import java.time.ZoneId;  
     */
        }
        @Override
                walkLeaves(parser, path, sink);  
            );  
                return NAME;
    public static final String CONTENT_TYPE = "flat_object";
                Automaton a1 = PrefixQuery.toAutomaton(indexedValueForSearch(prefix));
     * {@code LogAttributes.http.method}) — the field identity travels on the {@code addField} call
                protected String parseSourceValue(Object value) {
import org.opensearch.common.xcontent.support.XContentMapValues;  
                @Override
    }  
    static final String VALUE_AND_PATH_SUFFIX = "._valueAndPath";
            }  
            String value,
                throw new IllegalArgumentException(
                return super.indexedValueForSearch(value);
            String searchField;  
        public Builder(String name) {
    }
     */
                isSearchable,  
                );
                return null;
            Strings.isNullOrEmpty(key) ? this.name() : (this.name() + DOT_SYMBOL + key),
            this.nullValue = null;  
     * routes each leaf to whichever scope is currently open.
            @Nullable MultiTermQuery.RewriteMethod method,
                    iterator.remove();
            }
                    includeLower,
            );  
         * redirect queries with rewrite value to rewriteSearchValue and directSubFieldName
        public FlatObjectFieldType(
    protected void parseCreateField(ParseContext context) throws IOException {
     */
import java.util.Collections;  
        }  
import org.apache.lucene.index.IndexOptions;
            }
    /**
        public KeywordFieldType getValueAndPathFieldType() {
    }
                return null;  
 */  
        return (FlatObjectFieldType) super.fieldType();  
                    }  
                    BytesRef lowerTermBytes = lowerTerm == null ? null : indexedValueForSearch(rewriteSearchValue(lowerTerm));
                return;
            }
        switch (parser.currentToken()) {
                    indexQuery = new AutomatonQuery(new Term(getSearchField()), termAutomaton, true);
            QueryShardContext context
            KeywordFieldType valueFieldType = getKeywordFieldType(buildFullName(context), VALUE_SUFFIX, isSearchable, hasDocValue);
                }  
        if (parsed) {
         * Fielddata is an in-memory data structure that is used for aggregations, sorting, and scripting.
        } else {  
            Query dvQuery = null;
    }
                // flat_object analyzer with the default attribute source which encodes terms using UTF8  
        @Override
            String rootFieldName,
            // Path relative to this flat_object field: strip the "<fieldName>." prefix.
     */
    protected void mergeOptions(FieldMapper other, List<String> conflicts) {
        public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {
    protected void parseCreateFieldForPluggableFormat(ParseContext context) throws IOException {
            this(  
    static final String DOT_SYMBOL = ".";  
 * A field mapper for flat_objects.
            failIfNotIndexedAndNoDocValues();
            failIfNotIndexedAndNoDocValues();
            KeywordFieldType valueAndPathFieldType = getKeywordFieldType(  
    }
                }  
        void accept(String relativePath, String value);
            if (value instanceof BytesRef) {
            final String currentFieldName = parser.currentName();
        }
    private static String parseValue(XContentParser parser) throws IOException {  
        @Override
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
                Automaton a2 = TermRangeQuery.toAutomaton(lowerDvBytes, upperDvBytes, includeLower, includeUpper);
        public Query termsQuery(List<?> values, QueryShardContext context) {
                    indexQuery = new TermRangeQuery(
            this.valueAndPathFieldType = valueAndPathFieldType;  
            this.name(),
                createFieldNamesField(context);  
import java.util.HashSet;
                        lowerTerm == null ? null : indexedValueForSearch(lowerTerm),  
import org.apache.lucene.document.SortedSetDocValuesField;  
        );
                    context  
            return false;  
                    return getDVPrefix(rootField) + value;
                    Automaton a2 = TermRangeQuery.toAutomaton(lowerTermBytes, upperTermBytes, includeLower, includeUpper);  
         */  
                }
     * indexed terms (matching {@code "index": false}: no inverted index). This is the doc-values  
                name,
            case VALUE_NUMBER:  
            Fuzziness fuzziness,  
        }  
     * @param leafRelativePath the leaf's dotted path relative to {@code rootFieldName}
            walkLeaves(parser, path, sink); // parse the value for fieldName (which will be an array, an object,
         * @return rewriteSearchValue
import java.util.Arrays;
            );
            // Note that whichever other branch we just passed through has already ended with nextToken(), so we
            throw new UnsupportedOperationException(
                        + "' is set to false."
            if (fieldType().isSearchable() || fieldType().isStored()) {
            String value = parseValue(parser);
        private final String rootFieldName;
                // in that case we skip normalization, which may be slow if there many terms need to
        public Mapper.Builder<?> parse(String name, Map<String, Object> node, ParserContext parserContext) throws MapperParsingException {
        if (fieldType().isSearchable() == false && fieldType().isStored() == false && fieldType().hasDocValues() == false) {
            return valueFieldType().termQuery(rewriteSearchValue(value), context);  
     * @opensearch.internal
        return true;
                    builder.index(XContentMapValues.nodeBooleanValue(entry.getValue(), name + ".index"));  
            FIELD_TYPE.setOmitNorms(true);
        public boolean isAggregatable() {
        valueFieldType = mappedFieldType.valueFieldType;
            assert indexQuery != null || dvQuery != null;
            }
        @Override  
                valueFieldType.isSearchable(),
    private void createPathFields(ParseContext context, HashSet<String> pathParts) {  
            if (fieldType().hasDocValues()) {  
     * FieldExistsQuery(rootFieldName)}.  
                } else {
            this.ignoreAbove = Integer.MAX_VALUE;
        } else if (parser.currentToken() == XContentParser.Token.START_OBJECT) {  
    }  
            return valueFieldType().fuzzyQuery(
                "[" + this.name() + "] unexpected token [" + ctxParser.currentToken() + "] in flat_object field value"
        }
import org.opensearch.search.DocValueFormat;  
            int matchFlags,  
import java.util.LinkedList;
            };
    public static final TypeParser PARSER = new TypeParser((n, c) -> new Builder(n));  
import java.util.function.BiFunction;
                protected String rewriteForDocValue(Object value) {  
     * <p>
import org.apache.lucene.document.Field;
    /**
import static org.apache.lucene.search.MultiTermQuery.DOC_VALUES_REWRITE;
import org.opensearch.core.common.Strings;
        private KeywordFieldType valueFieldType() {
        ctxParser.nextToken();
     * Shared entry point for both index paths: validates the field value, then walks the object and  
     * @return {@code true} if the object was walked, {@code false} if the field was skipped
         * @return IndexFieldData.Builder
                }
                    try {
                dvQuery = new AutomatonQuery(new Term(getSearchField()), dvAutomaton, true, DOC_VALUES_REWRITE);
        public String typeName() {
            parser.nextToken();
     * @param rootFieldName    the flat_object field's own name  
        @Override
        }
            List<String> parsedValues = new ArrayList<>(values.size());  
            private final String prefix;  
            ctxParser.skipChildren();
        public class FlatObjectDocValueFormat implements DocValueFormat {
            final String relativePath = leafPath.substring(name().length() + 1);  
            this.valueFieldType = valueFieldType;
    }  
        public Query termQuery(Object value, QueryShardContext context) {
     * hands every leaf to {@code sink}. Flattening, stringification, {@code ignore_above} filtering
            return new FlatObjectFieldMapper(name, this.fieldType, fft, isPluggableDataFormatEnabled(context.indexSettings()));
            KeywordFieldType valueAndPathFieldType  
                getKeywordFieldType(rootFieldName == null ? name : rootFieldName, VALUE_SUFFIX, isSearchable, hasDocValues),  
     * Cannot be tokenized, can OmitNorms, and can setIndexOption.
import org.apache.lucene.search.AutomatonQuery;  
        XContentParser ctxParser = context.parser();  
import java.io.IOException;
            return (rootFieldName == null) ? valueFieldType : valueAndPathFieldType;  
        }  
        }
    // doc values under name() hold only path markers, so the generic generator would derive corrupt _source.  
            failIfNotIndexedAndNoDocValues();
        public Query rangeQuery(Object lowerTerm, Object upperTerm, boolean includeLower, boolean includeUpper, QueryShardContext context) {
                // attributes through reflection  
            return indexQuery == null ? dvQuery : (dvQuery == null ? indexQuery : new IndexOrDocValuesQuery(indexQuery, dvQuery));
        /**
                transpositions,
            failIfNotIndexedAndNoDocValues();
         */
import org.apache.lucene.search.MultiTermQuery;  
            walkLeaves(ctxParser, path, sink);
                return parser.textOrNull();  
import org.apache.lucene.util.automaton.Automaton;  
            if (value == null || value.length() > fieldType().ignoreAbove) {
            }
            private static final String NAME = "flat_object";
        }
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;  
        for (String part : pathParts) {
import org.opensearch.common.lucene.Lucene;
        }  
 *
                String prefix = dvPrefix + (isSubField() ? getPathPrefix(name()) : "");
        assert fieldType.indexOptions().compareTo(IndexOptions.DOCS_AND_FREQS) <= 0;
            String searchKey;
        if (ctxParser.currentToken() != XContentParser.Token.START_OBJECT) {
                    } catch (IOException e) {
import java.io.UncheckedIOException;
            public BytesRef parseBytesRef(String value) {  
            case VALUE_BOOLEAN:
     */  
                );
            );
            int prefixLength,
                    assert value instanceof String;
 * @opensearch.internal  
import org.opensearch.index.engine.dataformat.FlattenedLeaf;
    @Override
import org.apache.lucene.search.PrefixQuery;
            NamedAnalyzer normalizer = fieldType().normalizer();  
            FlatObjectFieldType fft = new FlatObjectFieldType(buildFullName(context), null, valueFieldType, valueAndPathFieldType);  
     * Emitting per-leaf (rather than handing over one collection) is what lets the same signal serve a
 * The OpenSearch Contributors require contributions made to  
    /**
        protected BytesRef indexedValueForSearch(Object value) {
     * here; how a format physically stores the leaves is the format's decision.
        public String getSearchField() {
import org.apache.lucene.index.Term;
     * In flat_object field mapper, field type is similar to keyword field type
        ) {  
        }
         * To direct search fields, if a dot path was used in search query,  
            while (parser.currentToken() != XContentParser.Token.END_ARRAY) {
     *
        NamedAnalyzer normalizer() {
    @FunctionalInterface  
        doc.add(new SortedSetDocValuesField(rootFieldName + VALUE_AND_PATH_SUFFIX, new BytesRef(dvPrefix + valueAndPath)));
     * <p>  
                    "Field [" + name() + "] of type [" + typeName() + "] does not support doc_value in root field"
        }
        static {
     * indexes as {@code value}/{@code path=value} terms — the flattening, stringification,  
import static org.opensearch.index.mapper.FlatObjectFieldMapper.FlatObjectFieldType.getKeywordFieldType;
                throw new IllegalArgumentException("Field [" + name() + "] of type [" + typeName() + "] does not support custom formats");
                String parsedValue = value.utf8ToString();
            @Nullable MultiTermQuery.RewriteMethod method,
        /**
            boolean transpositions,  
            return CONTENT_TYPE;
                        getSearchField(),
                context.doc().add(new Field(valueAndPathFieldType.name(), new BytesRef(valueAndPath), fieldType));
                );
     * Creates a new TypeParser for flatObjectFieldMapper that does not use ParameterizedFieldMapper  
     * field, and its stringified (already {@code ignore_above}-filtered and normalized) value.
