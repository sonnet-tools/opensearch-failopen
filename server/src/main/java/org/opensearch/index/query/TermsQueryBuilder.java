        }
    }  
     * Convert the internal {@link List} of values back to a user-friendly list.  
                    }  
                for (Object o : list) {  
    private TermsQueryBuilder(String fieldName, Iterable<?> values, ValueType valueType) {
                        "["
                }
import org.opensearch.index.mapper.MappedFieldType;
                );
        this(
import java.util.Map;
                    "[" + TermsQueryBuilder.NAME + "] unknown token [" + token + "] after [" + currentFieldName + "]"  
     * If the list does not only contain integers or {@link String}s, then a
     * A filter for a field based on several terms matching on any of them.
        return values;
                                                    + maxTermsCount  
 */
 * Licensed to Elasticsearch under one or more contributor  
    }  
import org.opensearch.transport.client.Client;
import java.util.HashSet;  
                            SearchRequest searchRequest = new SearchRequest(termsLookup.index()).source(sourceBuilder);  
                                            if (sourceAsMap != null) {
 */  
            return supplier.get() == null ? this : new TermsQueryBuilder(this.fieldName, supplier.get(), valueType);
        if (this.termsLookup != null) {
                        int maxClauseCount = IndexSearcher.getMaxClauseCount();
        boolean isWholeNumber = numberType.equals(NumberFieldMapper.NumberType.INTEGER)
    }
     * This flag is used to decide how to parse the value and build query upon later
     * @param values The terms  
        }  
     * @param values The terms
        out.writeString(fieldName);
            } else if (token.isValue()) {
                } else if (VALUE_TYPE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    }
                        // dynamic setting update consumer to IndexSearcher's static field.  
                    terms.addAll(values);
                                        delegatedListener.onFailure(
                                                    + totalHits
                throw new IllegalArgumentException(
        if (in.getVersion().onOrAfter(Version.V_2_17_0)) {  
            throw new IllegalArgumentException("No value specified for terms query");
 *
    @Override
        }  
            GetRequest getRequest = new GetRequest(termsLookup.index(), termsLookup.id());
        if (fieldType == null) {
/*  
        QueryShardContext context = queryRewriteContext.convertToShardContext();
        this(fieldName, values != null ? Arrays.stream(values).mapToObj(s -> s).collect(Collectors.toList()) : (Iterable<?>) null);  
                return null;
                                                    termsLookup.path(),
        this.supplier = null;
     */
                                                terms.addAll(hit.field(termsLookup.path()).getValues());
import java.util.Set;
                                                    + "] exceeds allowed max_terms_count ["
    }  
        }  
                    );
                "["
        }
        String valueTypeStr = ValueType.DEFAULT.type;  
     *
        this.valueType = valueType;  
        NumberFieldMapper.NumberType numberType = nft.numberType();
                        // Reads the cluster-level max_clause_count, propagated via SearchService's
        if (values instanceof List<?> valuesList) {  
            } else if (token == XContentParser.Token.START_ARRAY) {
        ValueType(String type) {  
import org.opensearch.search.SearchHit;
                    @Override  
    }
            throw new IllegalArgumentException(  
            final long[] elements = list.stream().mapToLong(o -> ((Number) o).longValue()).toArray();
                        terms.addAll(extractedValues);  
 */
    /**  
                        b = new BytesRef(charBuffer);
            values.add(value);  
     * A filter for a field based on several terms matching on any of them.
                        int maxTermsCount = IndexSettings.MAX_TERMS_COUNT_SETTING.get(idxSettings);  
import org.opensearch.index.mapper.ConstantFieldType;
     *  
            list = valuesList;
    TermsQueryBuilder(String fieldName, List<Object> values, TermsLookup termsLookup) {
        if (list.isEmpty()) {
                final int[] endOffsets = new int[list.size()];
                values.set(0, new BytesArray(Base64.getDecoder().decode(bytesRef.utf8ToString())));  
            );
        return convertBack(this.values);
                                                "Terms lookup subquery result count ["  
    @Override  
    }
                currentFieldName = parser.currentName();  
            if (value == null) {  
        builder.endObject();  
            if (values != null && values.size() == 1 && values.get(0) instanceof BytesRef bytesRef) {
            return numberFieldType.bitmapQuery(bytesArray);  
            out.writeEnum(valueType);
    /**
                            // Use stored fields if possible, otherwise fetch source
        }  
    @Override
                    @Override
            client.get(getRequest, ActionListener.delegateFailure(actionListener, (delegatedListener, getResponse) -> {
    public ValueType valueType() {
                        endOffsets[i] = Math.addExact(endOffsets[i - 1], b.length);
        numberValues.sort(Comparator.comparingDouble(Number::doubleValue)); // For sorting purposes, use double value.
            return new MatchNoneQueryBuilder();
                        endOffsets[0] = b.length;  
        }
                        "[" + TermsQueryBuilder.NAME + "] query does not support multiple fields"
    protected void doWriteTo(StreamOutput out) throws IOException {  
                if (termsLookup.store()) {
                    + IndexSettings.MAX_TERMS_COUNT_SETTING.getKey()
 * license agreements. See the NOTICE file distributed with
                                        return;
import org.opensearch.core.common.Strings;
     * @param fieldName The field name
                    ++i;
 * not use this file except in compliance with the License.
        if (valueType != ValueType.DEFAULT) {  
            if (termsLookup.store()) {  
     * A filter for a field based on several terms matching on any of them.
     * constructor used internally for serialization of both value / termslookup variants  
        return this;
import org.opensearch.index.IndexSettings;  
 * software distributed under the License is distributed on an
                    public Object get(int i) {  
    }
     */
import java.util.Comparator;
        }  
                    + "followed by array of terms or a document lookup specification"
                    return new MatchNoneQueryBuilder();  
                                sourceBuilder.storedField(termsLookup.path());
    public String getWriteableName() {  
        if (out.getVersion().onOrAfter(Version.V_2_17_0)) {
        }  
    public TermsQueryBuilder(String fieldName, long... values) {
        if (Strings.isEmpty(fieldName)) {
        );
                delegatedListener.onResponse(terms);  
                    assert false : "Constant fields must produce match-all or match-none queries, got " + query;
                                        );  
        printBoostAndQueryName(builder);
import org.opensearch.common.xcontent.support.XContentMapValues;
                                    delegatedListener.onResponse(terms);
                        return bytes.slice(startOffset, endOffset - startOffset).toBytesRef();  
        return convert(list);  
    /**
                    );
import org.apache.lucene.search.MatchNoDocsQuery;  
     * Integers are kept as-is since the terms query does not make any difference
        if (supplier != null) {
import org.opensearch.core.action.ActionListener;  
                                            }
        if (termsLookup.id() != null) {  
                                                terms.addAll(extractedValues);
    }
        builder.startObject(NAME);  
 * A filter for a field based on several terms matching on any of them.
            builder.field(fieldName, convertBack(values));  
    }
            @Override  
        this.values = null;
 * under the License.  
    }  
                return list.size();  
        this.values = convert(values);
            @Override
                    return new MatchAllQueryBuilder();
        if (valueType.equals(ValueType.BITMAP)) return null;
                    + "] index level setting."  
                            );
    /**
 *
            };  
            try (BytesStreamOutput bytesOut = new BytesStreamOutput()) {  
                    } else {  
    public enum ValueType {  
                    throw new ParsingException(  
import org.opensearch.action.get.GetRequest;
    public List<Object> values() {  
            }));
                } else if (query instanceof MatchNoDocsQuery) {
                parser.getTokenLocation(),
                    return valueType;
        return NAME;
import org.opensearch.action.search.SearchRequest;  
            throw new IllegalArgumentException("field name cannot be null.");
    /**  
        this.fieldName = fieldName;
            builder.field(VALUE_TYPE_FIELD.getPreferredName(), valueType.type);
    /**  
        }  
import org.opensearch.Version;
        while (parser.nextToken() != XContentParser.Token.END_ARRAY) {
import java.util.stream.Collectors;  
        return this.fieldName;
        this(fieldName, null, termsLookup);
                        builder.copyChars(o.toString());
                        // Get max_terms_count, max_result_window, and max_clause_count, fallback to their defaults
                    throw new ParsingException(
                        // Get index-specific settings, fall back to defaults if missing
import org.opensearch.core.xcontent.XContentParser;
import java.util.AbstractList;  
                    boost = parser.floatValue();
        List<Object> values = null;
            termsLookup.toXContent(builder, params);  
            throw new IllegalArgumentException("Both values and termsLookup specified for terms query");
        }
                .getSettings(
                        try {
     * use-cases that involve sending very large terms queries to OpenSearch.
            return new AbstractList<Object>() {
 * this work for additional information regarding copyright
            }
import org.opensearch.core.common.bytes.BytesArray;  
                                                );  
 * this file be licensed under the Apache-2.0 license or a
                            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder().query(termsLookup.query()).size(fetchSize);  
        String queryName = null;  
import java.nio.CharBuffer;
        this(fieldName, supplier);
                    o = bytesRef.utf8ToString();
        if (valueType == ValueType.BITMAP
        final boolean allStrings = list.stream().allMatch(o -> o != null && STRING_TYPES.contains(o.getClass()));  
                                        delegatedListener.onFailure(
import java.io.IOException;
                    return elements.length;
        this(fieldName, values != null ? Arrays.stream(values).mapToObj(s -> s).collect(Collectors.toList()) : (Iterable<?>) null);
     * A filter for a field based on several terms matching on any of them.  
     */  
     */  
            public Object get(int index) {
        return this.valueType;  
                throw new ParsingException(parser.getTokenLocation(), "No value specified for terms query");
            && values.size() == 1  
    private final Supplier<List<?>> supplier;
        this.fieldName = fieldName;  
                                    if (hits.length > maxTermsCount) {  
        this.fieldName = fieldName;
                            + currentFieldName
import java.util.ArrayList;
import org.opensearch.core.ParseField;
import org.opensearch.core.common.io.stream.StreamInput;
        this(fieldName, values != null ? Arrays.asList(values) : (Iterable<?>) null);  
        // If this is a terms query on a numeric field, we can provide the complement using RangeQueryBuilder.  
                                ActionListener.delegateFailure(actionListener, (delegatedListener, searchResponse) -> {
                        parser.getTokenLocation(),
        values = (List<?>) in.readGenericValue();
                } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    protected Query doToQuery(QueryShardContext context) throws IOException {
import org.apache.lucene.util.BytesRefBuilder;  
    /**
                    BytesRef b;
            && Objects.equals(valueType, other.valueType);
     */
import org.opensearch.indices.TermsLookup;
            fieldName,
            for (ValueType valueType : ValueType.values()) {
                getRequest.storedFields(termsLookup.path());
import org.opensearch.index.mapper.NumberFieldMapper;  
                            } else {
            list = arrayList;
 * SPDX-License-Identifier: Apache-2.0
                        b = builder.get();
                                            if (hit.field(termsLookup.path()) != null) {  
        }
                "The number of terms ["
        this.valueType = valueType;  
    public TermsQueryBuilder(String fieldName, double... values) {
                    + "]. "  
        for (Object value : values) {
     * elements are either integers or {@link String}s/{@link BytesRef}/
                // as far as this query is concerned
    protected int doHashCode() {  
    }
        return new AbstractList<Object>() {  
     * {@link CharBuffer}s. This is useful to help garbage collections for  
    /**
        private final String type;
                    }
    );
                    bytesOut.writeBytes(b.bytes, b.offset, b.length);
            || numberType.equals(NumberFieldMapper.NumberType.SHORT);
                    if (getResponse.isSourceEmpty() == false) { // extract terms only if the doc source exists
        return Objects.equals(fieldName, other.fieldName)  
                        int fetchSize = Math.min(Math.min(maxTermsCount, maxResultWindow), maxClauseCount);  
                throw new ParsingException(
                            if (termsLookup.store()) {  
                                    // Correctness: fail if total hits exceed fetchSize (results are incomplete)  
            actionListener.onResponse(Collections.emptyList());
            }
                termsLookup = TermsLookup.parseTermsLookup(parser);
    @Override
        this.termsLookup = null;  
     */
        return Objects.hash(fieldName, values, termsLookup, supplier, valueType);
            } else if (fieldType.unwrap() instanceof ConstantFieldType) {
    private final String fieldName;
                    public int size() {
    }
import java.util.Arrays;
import java.util.stream.IntStream;
    static List<?> convert(List<?> list) {  
    }  
            return Collections.emptyList();
        }
                // fields we also have the guarantee that it doesn't perform I/O, which is important  
        if (values == null || values.isEmpty()) {
    @Override
                                searchRequest,  
                } else {  
    public TermsQueryBuilder(String fieldName, TermsLookup termsLookup) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * replaced with {@link BytesRef}s.
                                        );
                }
        fieldName = in.readString();
                    + "the allowed maximum of ["
    }
     * Convert the list in a way that optimizes storage in the case that all
                return o;
            getRequest.preference("_local").routing(termsLookup.routing());
                if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
                        throw new IllegalArgumentException(
                                sourceBuilder.fetchSource(termsLookup.path(), null);  
                                            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
                }  
    }
     * @param values The terms
                Object o = list.get(index);
 * Modifications Copyright OpenSearch Contributors. See
                @Override
            }
                            }
    private ValueType valueType = ValueType.DEFAULT;
    }  
import java.util.Collections;
        QueryBuilder nestedQuery = null;
            queryRewriteContext.registerAsyncAction((client, listener) -> fetch(termsLookup, client, ActionListener.map(listener, list -> {  
    /**
            && values.get(0) instanceof BytesArray bytesArray
        }
                final BytesReference bytes = bytesOut.bytes();  
            valueType = in.readEnum(ValueType.class);
        if (nft == null) return null;
}
     */
        }
                        Settings idxSettings = settingsResponse.getIndexToSettings().getOrDefault(termsLookup.index(), Settings.EMPTY);  
                                    }
     * @param fieldName The field name  
                            client.search(
                            + "] query does not support more than one field. "
import java.util.function.Supplier;
                            + "]"  
                                })  
                List<Object> terms = new ArrayList<>();  
    @Override
 *  
        if (Strings.isEmpty(fieldName)) {  
                        return endOffsets.length;
 * The OpenSearch Contributors require contributions made to  
     *
     * @param fieldName The field name
    private static List<?> convert(Iterable<?> values) {
            public int size() {
import java.util.Objects;  
        return this;
            || numberType.equals(NumberFieldMapper.NumberType.LONG)  
import org.opensearch.core.common.ParsingException;
    static List<Object> parseValues(XContentParser parser) throws IOException {
        // If this uses BITMAP value type, or if we're using termsLookup, we can't provide the complement.  
        this.supplier = null;
    }
        } else {
    }
        this.termsLookup = termsLookup;
        if (values == null) {
        DEFAULT("default"),
        this(fieldName, values != null ? Arrays.asList(values) : null);
                    throw new ParsingException(  
                supplier.set(list);
                Query query = fieldType.termsQuery(values, context);
 * compatible open source license.
                    }  
 * @opensearch.internal  
    private TermsQueryBuilder(String fieldName, Supplier<List<?>> supplier, ValueType valueType) {
            }
            } else if (token == XContentParser.Token.START_OBJECT) {
                                        } else {  
     *
    public TermsQueryBuilder(String fieldName, Object... values) {
        }
     */  
                                    for (SearchHit hit : hits) {
                                    SearchHit[] hits = searchResponse.getHits().getHits();  
            values != null ? IntStream.range(0, values.length).mapToObj(i -> values[i]).collect(Collectors.toList()) : (Iterable<?>) null  
     * <p>  
 * GitHub history for details.
        }
                                            )
        String fieldName = null;
        } else {
                if (fieldName != null) {
                if (o instanceof BytesRef bytesRef) {  
    /**
                    if (o instanceof BytesRef bytesRef) {
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
        this(fieldName, values != null ? Arrays.stream(values).mapToObj(s -> s).collect(Collectors.toList()) : (Iterable<?>) null);
            final BytesRefBuilder builder = new BytesRefBuilder();
            } else if (termsLookup == null) {
import java.util.List;
    }  
                        b = bytesRef;  
            SetOnce<List<?>> supplier = new SetOnce<>();
                                    List<Object> terms = new ArrayList<>();
     * @param values The terms
                };
                                                    + "]"
import org.opensearch.common.settings.Settings;  
     * converted back to {@link String}s.  
        else if (this.termsLookup != null && (this.termsLookup.id() != null || this.termsLookup.query() != null)) {
                    parser.getTokenLocation(),
                                            }
 *    http://www.apache.org/licenses/LICENSE-2.0
    public List<QueryBuilder> getComplement(QueryShardContext context) {
 * KIND, either express or implied.  See the License for the
                                    if (totalHits > fetchSize) {
                fieldName = currentFieldName;  
    protected QueryBuilder doRewrite(QueryRewriteContext queryRewriteContext) throws IOException {
                    );  
                } else {  
                getRequest.fetchSourceContext(new FetchSourceContext(true, new String[] { termsLookup.path() }, null));  
    public TermsQueryBuilder(String fieldName, Iterable<?> values) {  
                    + maxTermsCount
import org.opensearch.core.common.bytes.BytesReference;
            throw new IllegalArgumentException("field name cannot be null.");
                        List<Object> extractedValues = XContentMapValues.extractRawValues(termsLookup.path(), getResponse.getSourceAsMap());
                // This logic is correct for all field types, but by only applying it to constant
                    }
                    "Invalid value for bitmap type: Expected a single-element array with a base64 encoded serialized bitmap."  
    static List<Object> convertBack(List<?> list) {
            })));  
                }
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        if (termsLookup != null || supplier != null || values == null || values.isEmpty()) {
        if (allNumbers) {  
    }
    private static final Set<Class<? extends Number>> INTEGER_TYPES = new HashSet<>(
        List<Number> numberValues = new ArrayList<>();  
 * Unless required by applicable law or agreed to in writing,
    public TermsQueryBuilder(String fieldName, int... values) {
        super(in);
     */
                        }
            && Objects.equals(supplier, other.supplier)  
                    + values.size()
            }  
                } else {
                                        if (termsLookup.store()) {
     * A filter for a field based on several terms matching on any of them.
            this.type = type;
    /**  
            throw new ParsingException(  
        }
    }  
            builder.startObject(fieldName);
                // we do not convert longs, all integer types are equivalent  
                if (valueType.type.equalsIgnoreCase(type)) {  
    @Override
    public static TermsQueryBuilder fromXContent(XContentParser parser) throws IOException {  
                }  
                                            new IllegalArgumentException(  
     * Read from a stream.
            numberValues.add(nft.parse(value));
            throw new IllegalStateException("Rewrite first");
    private void fetch(TermsLookup termsLookup, Client client, ActionListener<List<Object>> actionListener) {
    }  
        if (allStrings) {
                    + "] used in the Terms Query request has exceeded "  
     * Same as {@link #convert(List)} but on an {@link Iterable}.
                    new org.opensearch.action.admin.indices.settings.get.GetSettingsRequest().indices(termsLookup.index()),  
     * @param fieldName The field name
            }
                    return elements[index];
    private static final ParseField VALUE_TYPE_FIELD = new ParseField("value_type");
                                                    + "] exceed fetch limit ["  
    }
        if (values == null || termsLookup != null) return null;
            }
                public Object get(int index) {
        return this.termsLookup;
import org.opensearch.search.fetch.subphase.FetchSourceContext;
                                                    + "]; filter may be incomplete."
    private final TermsLookup termsLookup;
                    }  
        public static ValueType fromString(String type) {
import org.apache.lucene.util.BytesRef;
        List<Object> values = new ArrayList<>();  
                        } catch (Exception e) {  
            return new TermsQueryBuilder(this.fieldName, supplier::get, valueType);
import org.apache.lucene.search.IndexSearcher;
            && Objects.equals(values, other.values)
    @Override
     * @param fieldName The field name
/*
     */
    public TermsQueryBuilder(StreamInput in) throws IOException {  
            Object value = maybeConvertToBytesRef(parser.objectBytes());
/*  
            throw new UnsupportedOperationException("query must be rewritten first");
        }  
                }
                    List<Object> values = getResponse.getField(termsLookup.path()).getValues();
                    }, actionListener::onFailure)  
        if (supplier != null) {  
     * A filter for a field based on several terms matching on any of them.  
        this.supplier = supplier;
        this.values = values == null ? null : convert(values);
                            + "] but also found ["
        if (context != null) {  
                                                    + fetchSize
import org.opensearch.core.xcontent.XContentBuilder;
 *
                        // The effective size must not exceed any of these
                        final int startOffset = i == 0 ? 0 : endOffsets[i - 1];
        // unnecessary components like "x < value < x + 1"
                arrayList.add(o);
                        parser.getTokenLocation(),
                }
        return new TermsQueryBuilder(fieldName, values, termsLookup).boost(boost).queryName(queryName).valueType(valueType);
                                    }  
    private static final Set<Class<?>> STRING_TYPES = new HashSet<>(Arrays.asList(BytesRef.class, String.class));
/**  
                fieldName = currentFieldName;
     * @param fieldName The field name  
import org.opensearch.common.SetOnce;
                    + "This maximum can be set by changing the ["
            throw new IllegalStateException("supplier must be null, can't serialize suppliers, missing a rewriteAndFetch?");
    }
                return new AbstractList<Object>() {
     * @param values The terms
        }
                }
        String currentFieldName = null;  
                    valueTypeStr = parser.text();
            );  
    /**
     * between {@link Integer}s and {@link Long}s, but {@link BytesRef}s are
                );
    public String fieldName() {
                int i = 0;
        } else if (termsLookup.query() != null) {
                        );  
     * list is returned where all {@link String}/{@link CharBuffer}s have been  
        XContentParser.Token token;
        if (valueType == ValueType.BITMAP) {
                );
                    }
        return ComplementHelperUtils.numberValuesToComplement(fieldName, numberValues, isWholeNumber);
        ValueType valueType = ValueType.fromString(valueTypeStr);  
        if (fieldName == null) {
import java.util.Base64;  
        termsLookup = in.readOptionalWriteable(TermsLookup::new);  
                                                "Terms lookup subquery total hits ["
            if (fieldType == null) {
            && fieldType.unwrap() instanceof NumberFieldMapper.NumberFieldType numberFieldType) {
        out.writeOptionalWriteable(termsLookup);
            }  
        List<?> list;
                            "Invalid value for bitmap type: Expected a single base64 encoded serialized bitmap."
        MappedFieldType fieldType = context.fieldMapper(fieldName);  
import org.opensearch.core.common.io.stream.StreamOutput;  
                        parser.getTokenLocation(),
                    + TermsQueryBuilder.NAME  
                }
                                                    + hits.length
    public TermsLookup termsLookup() {
        this(fieldName, values);
                                        return;
     * @param fieldName The field name  
        }  
    }
        return list.stream().map(o -> o instanceof String str ? new BytesRef(str) : o).collect(Collectors.toList());
                            + fieldName  
                @Override  
        };
            }  
    private final List<?> values;  
public class TermsQueryBuilder extends AbstractQueryBuilder<TermsQueryBuilder> implements ComplementAwareQueryBuilder, WithFieldName {
        int maxTermsCount = context.getIndexSettings().getMaxTermsCount();
        Arrays.asList(Byte.class, Short.class, Integer.class, Long.class)  
                                    // Defensive: avoid exceeding maxTermsCount
    public TermsQueryBuilder(String fieldName, String... values) {  
        }
        // If there is some other field type that's a whole number, this will still be correct, the complement may just have some  
        TermsLookup termsLookup = null;  
        // This section ensures no on-demand fetching for other cases as well  
                                            new IllegalArgumentException(
    public TermsQueryBuilder(String fieldName, float... values) {  
    }  
        if (values == null && termsLookup == null) {  
                        int maxResultWindow = IndexSettings.MAX_RESULT_WINDOW_SETTING.get(idxSettings);
 * You may obtain a copy of the License at  
            ArrayList<Object> arrayList = new ArrayList<>();  
                                                List<Object> extractedValues = XContentMapValues.extractRawValues(  
 * the Apache License, Version 2.0 (the "License"); you may
    }  
        if (values != null && termsLookup != null) {  
                    if (values.size() != 1 && valueType == ValueType.BITMAP) {  
    }  
     * A filter for a field based on several terms matching on any of them.
                return new MatchNoneQueryBuilder();  
            } else {  
     * Terms query may accept different types of value
                        "[" + TermsQueryBuilder.NAME + "] query does not support [" + currentFieldName + "]"  
    private TermsQueryBuilder(String fieldName, Supplier<List<?>> supplier) {  
        }
            MappedFieldType fieldType = context.fieldMapper(this.fieldName);
                            + TermsQueryBuilder.NAME  
                                                    sourceAsMap
        }  
            for (Object o : values) {
            if (token == XContentParser.Token.FIELD_NAME) {
                    } else if (o instanceof CharBuffer charBuffer) {
            throw new IllegalArgumentException("No value or termsLookup specified for terms query");
    @Override
     *
        this.termsLookup = null;  
     * @param values The terms  
                if (query instanceof MatchAllDocsQuery) {  
        }
        }  
    public TermsQueryBuilder valueType(ValueType valueType) {
        // Support: terms lookup by document id && Support: terms lookup by subquery  
    }  
import org.apache.lucene.search.Query;
import org.apache.lucene.search.MatchAllDocsQuery;
                }
     */
                            actionListener.onFailure(e);
                                    }
                                        }  
        }
        }
        this.valueType = valueType;  
import org.opensearch.search.builder.SearchSourceBuilder;  
                .indices()
    }
                if (fieldName != null) {
                    } else {
                                    long totalHits = searchResponse.getHits().getTotalHits().value();
    public static final String NAME = "terms";  
                    if (i == 0) {
        this.supplier = null;  
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
        final boolean allNumbers = list.stream().allMatch(o -> o != null && INTEGER_TYPES.contains(o.getClass()));
    }
        return fieldType.termsQuery(values, context);
            throw new IllegalArgumentException(type + " is not valid " + VALUE_TYPE_FIELD);
        NumberFieldMapper.NumberFieldType nft = ComplementHelperUtils.getNumberFieldType(context, fieldName);
        if (values.size() > maxTermsCount) {
import org.opensearch.common.io.stream.BytesStreamOutput;
            }
 */  
     */
    /**  
        }  
    }
            client.admin()  
            builder.endObject();
        } else {
            } else {
        out.writeGenericValue(values);  
     */
 * ownership. Elasticsearch licenses this file to you under  
            && Objects.equals(termsLookup, other.termsLookup)
                                            )  
                        final int endOffset = endOffsets[i];
                public int size() {  
     *  
                    queryName = parser.text();  
     * @param values The terms
package org.opensearch.index.query;
                            + "Already got: ["
        BITMAP("bitmap");
                values = parseValues(parser);  
            // No lookup type provided  
 * specific language governing permissions and limitations
     *
                // since rewrites might happen on a network thread.
        }
                    + "] query requires a field name, "
                    ActionListener.wrap(settingsResponse -> {
    protected boolean doEquals(TermsQueryBuilder other) {
