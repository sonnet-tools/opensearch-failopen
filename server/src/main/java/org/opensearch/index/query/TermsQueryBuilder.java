        if (values == null || termsLookup != null) return null;
            && values.size() == 1
 * this work for additional information regarding copyright
                    BytesRef b;
     */
                arrayList.add(o);
                        // Get index-specific settings, fall back to defaults if missing
import java.util.Collections;
        return new AbstractList<Object>() {
    }
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
    private TermsQueryBuilder(String fieldName, Supplier<List<?>> supplier) {
        } else {
        }
    }
        this.supplier = supplier;
     */
            if (fieldType == null) {
                supplier.set(list);
     * constructor used internally for serialization of both value / termslookup variants
 * not use this file except in compliance with the License.
        if (list.isEmpty()) {
     * @param fieldName The field name
     * Convert the internal {@link List} of values back to a user-friendly list.
                                    SearchHit[] hits = searchResponse.getHits().getHits();
 * ownership. Elasticsearch licenses this file to you under
     * @param fieldName The field name
     */
                        int maxResultWindow = IndexSettings.MAX_RESULT_WINDOW_SETTING.get(idxSettings);
    }
            throw new UnsupportedOperationException("query must be rewritten first");
        return NAME;
    /**
                    return valueType;
        if (values == null && termsLookup == null) {
            queryRewriteContext.registerAsyncAction((client, listener) -> fetch(termsLookup, client, ActionListener.map(listener, list -> {
        boolean isWholeNumber = numberType.equals(NumberFieldMapper.NumberType.INTEGER)
            builder.field(VALUE_TYPE_FIELD.getPreferredName(), valueType.type);
        private final String type;
    }
import org.opensearch.index.IndexSettings;
                }
    TermsQueryBuilder(String fieldName, List<Object> values, TermsLookup termsLookup) {
import org.opensearch.index.mapper.MappedFieldType;
/*
                }
 * under the License.
        }
            for (ValueType valueType : ValueType.values()) {
            } else {
                                    }
    private final TermsLookup termsLookup;
                                        if (termsLookup.store()) {
        if (fieldName == null) {
            if (values != null && values.size() == 1 && values.get(0) instanceof BytesRef bytesRef) {
            out.writeEnum(valueType);
        }
                parser.getTokenLocation(),
import org.opensearch.indices.TermsLookup;
    private ValueType valueType = ValueType.DEFAULT;
            || numberType.equals(NumberFieldMapper.NumberType.SHORT);
            return numberFieldType.bitmapQuery(bytesArray);
                    + TermsQueryBuilder.NAME
            if (value == null) {
     * elements are either integers or {@link String}s/{@link BytesRef}/
        }
    @Override
     *
     * A filter for a field based on several terms matching on any of them.
        this.supplier = null;
     * Same as {@link #convert(List)} but on an {@link Iterable}.
                currentFieldName = parser.currentName();
     *
    public List<QueryBuilder> getComplement(QueryShardContext context) {
                            );
                if (fieldName != null) {
                final int[] endOffsets = new int[list.size()];
        }
                    @Override
 *
            list = arrayList;
                        Settings idxSettings = settingsResponse.getIndexToSettings().getOrDefault(termsLookup.index(), Settings.EMPTY);
                    + "] query requires a field name, "
            termsLookup.toXContent(builder, params);
                        terms.addAll(extractedValues);
                        // dynamic setting update consumer to IndexSearcher's static field.
                                        delegatedListener.onFailure(
     * A filter for a field based on several terms matching on any of them.
    public TermsQueryBuilder(String fieldName, float... values) {
import org.opensearch.common.xcontent.support.XContentMapValues;
                "["
                fieldName = currentFieldName;
    public TermsQueryBuilder(StreamInput in) throws IOException {
    }
     *
            }
            final long[] elements = list.stream().mapToLong(o -> ((Number) o).longValue()).toArray();
                            if (termsLookup.store()) {
            })));
        this.values = null;
     */
                }
     * If the list does not only contain integers or {@link String}s, then a
                        int maxClauseCount = IndexSearcher.getMaxClauseCount();
 *
import org.opensearch.common.settings.Settings;
                    valueTypeStr = parser.text();
    static List<Object> parseValues(XContentParser parser) throws IOException {
        this.values = values == null ? null : convert(values);
                        List<Object> extractedValues = XContentMapValues.extractRawValues(termsLookup.path(), getResponse.getSourceAsMap());
    protected QueryBuilder doRewrite(QueryRewriteContext queryRewriteContext) throws IOException {
                    boost = parser.floatValue();
                    );
        this.fieldName = fieldName;
        if (valueType != ValueType.DEFAULT) {
                    }, actionListener::onFailure)
import org.opensearch.index.mapper.NumberFieldMapper;
import org.opensearch.core.common.ParsingException;
    /**
                                            }
                @Override
            }
                        try {
        if (values == null || values.isEmpty()) {
        QueryBuilder nestedQuery = null;
        return Objects.equals(fieldName, other.fieldName)
        if (Strings.isEmpty(fieldName)) {
        return values;
import org.opensearch.core.common.bytes.BytesArray;
     * replaced with {@link BytesRef}s.
        return Objects.hash(fieldName, values, termsLookup, supplier, valueType);
        return list.stream().map(o -> o instanceof String str ? new BytesRef(str) : o).collect(Collectors.toList());
            } else {
            public Object get(int index) {
        BITMAP("bitmap");
        numberValues.sort(Comparator.comparingDouble(Number::doubleValue)); // For sorting purposes, use double value.
     */
        // If this uses BITMAP value type, or if we're using termsLookup, we can't provide the complement.
                                                List<Object> extractedValues = XContentMapValues.extractRawValues(
import org.opensearch.core.common.bytes.BytesReference;
 * A filter for a field based on several terms matching on any of them.
 * Unless required by applicable law or agreed to in writing,
                        "[" + TermsQueryBuilder.NAME + "] query does not support multiple fields"
                getRequest.storedFields(termsLookup.path());
import java.util.Comparator;
                        b = bytesRef;
        this.termsLookup = null;
                    ActionListener.wrap(settingsResponse -> {
        int maxTermsCount = context.getIndexSettings().getMaxTermsCount();
        }
            builder.field(fieldName, convertBack(values));
    public enum ValueType {
 * SPDX-License-Identifier: Apache-2.0
     * list is returned where all {@link String}/{@link CharBuffer}s have been
    }
     * A filter for a field based on several terms matching on any of them.
 * Licensed to Elasticsearch under one or more contributor
                        return bytes.slice(startOffset, endOffset - startOffset).toBytesRef();
        }
    public static final String NAME = "terms";
            throw new IllegalArgumentException(type + " is not valid " + VALUE_TYPE_FIELD);
        if (values.size() > maxTermsCount) {
        NumberFieldMapper.NumberType numberType = nft.numberType();
import org.apache.lucene.search.IndexSearcher;
                                    }
     */
                                                    + "]; filter may be incomplete."
                        endOffsets[0] = b.length;
     * @param fieldName The field name
}
        }
import org.opensearch.Version;
        DEFAULT("default"),
        MappedFieldType fieldType = context.fieldMapper(fieldName);
                    "Invalid value for bitmap type: Expected a single-element array with a base64 encoded serialized bitmap."
            && fieldType.unwrap() instanceof NumberFieldMapper.NumberFieldType numberFieldType) {
        String fieldName = null;
        return this.fieldName;
        if (valueType.equals(ValueType.BITMAP)) return null;
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        this.fieldName = fieldName;
            throw new IllegalStateException("supplier must be null, can't serialize suppliers, missing a rewriteAndFetch?");
     */
                    return elements[index];
import org.opensearch.core.action.ActionListener;
                        int maxTermsCount = IndexSettings.MAX_TERMS_COUNT_SETTING.get(idxSettings);
        fieldName = in.readString();
import org.opensearch.common.io.stream.BytesStreamOutput;
                                            )
    }
                        parser.getTokenLocation(),
                            client.search(
     * @param values The terms
                    + "the allowed maximum of ["
                    + "] index level setting."
                                        } else {
    }
    }
                }
import org.opensearch.transport.client.Client;
    }
            getRequest.preference("_local").routing(termsLookup.routing());
import org.apache.lucene.search.Query;
                        "["
                }
                            + "]"
     */
                }
                // fields we also have the guarantee that it doesn't perform I/O, which is important
        }
                } else if (VALUE_TYPE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        this.valueType = valueType;
    public TermsQueryBuilder(String fieldName, double... values) {
 */
    static List<Object> convertBack(List<?> list) {
    }
    @Override
                if (fieldName != null) {
                    } else {
public class TermsQueryBuilder extends AbstractQueryBuilder<TermsQueryBuilder> implements ComplementAwareQueryBuilder, WithFieldName {
        }
import java.util.Arrays;
        this(fieldName, values != null ? Arrays.asList(values) : (Iterable<?>) null);
            }
                                })
        if (this.termsLookup != null) {
    public TermsQueryBuilder valueType(ValueType valueType) {
        TermsLookup termsLookup = null;
            if (termsLookup.store()) {
/*
        );
        }
        this.fieldName = fieldName;
            SetOnce<List<?>> supplier = new SetOnce<>();
                        return endOffsets.length;
                            + TermsQueryBuilder.NAME
            } else if (token == XContentParser.Token.START_OBJECT) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                // since rewrites might happen on a network thread.
     * A filter for a field based on several terms matching on any of them.
    private static final Set<Class<? extends Number>> INTEGER_TYPES = new HashSet<>(
        // If this is a terms query on a numeric field, we can provide the complement using RangeQueryBuilder.
                    }
            && Objects.equals(termsLookup, other.termsLookup)
    public TermsQueryBuilder(String fieldName, TermsLookup termsLookup) {
 * The OpenSearch Contributors require contributions made to
import org.apache.lucene.util.BytesRef;
                return null;
                                                "Terms lookup subquery result count ["
        public static ValueType fromString(String type) {
            };
 * @opensearch.internal
    public TermsLookup termsLookup() {
        } else {
        this(fieldName, values != null ? Arrays.stream(values).mapToObj(s -> s).collect(Collectors.toList()) : (Iterable<?>) null);
    /**
                return new MatchNoneQueryBuilder();
            return new MatchNoneQueryBuilder();
        List<Object> values = new ArrayList<>();
        printBoostAndQueryName(builder);
                                        return;
    }
    /**
                                        delegatedListener.onFailure(
import org.opensearch.action.get.GetRequest;
                    assert false : "Constant fields must produce match-all or match-none queries, got " + query;
            }
                            actionListener.onFailure(e);
    private final List<?> values;
     *
            }
                                                    + hits.length
     * between {@link Integer}s and {@link Long}s, but {@link BytesRef}s are
     * converted back to {@link String}s.
    public List<Object> values() {
                    + "followed by array of terms or a document lookup specification"
     * Terms query may accept different types of value
                        final int endOffset = endOffsets[i];
        return convertBack(this.values);
                    new org.opensearch.action.admin.indices.settings.get.GetSettingsRequest().indices(termsLookup.index()),
     * @param fieldName The field name
 * license agreements. See the NOTICE file distributed with
        else if (this.termsLookup != null && (this.termsLookup.id() != null || this.termsLookup.query() != null)) {
 */
                                            if (sourceAsMap != null) {
                            + "] query does not support more than one field. "
        if (termsLookup != null || supplier != null || values == null || values.isEmpty()) {
                throw new IllegalArgumentException(
        this(fieldName, supplier);
        List<Number> numberValues = new ArrayList<>();
                    o = bytesRef.utf8ToString();
                public Object get(int index) {
    }
                termsLookup = TermsLookup.parseTermsLookup(parser);
                        parser.getTokenLocation(),
     * A filter for a field based on several terms matching on any of them.
            GetRequest getRequest = new GetRequest(termsLookup.index(), termsLookup.id());
            @Override
                for (Object o : list) {
     * <p>
                // we do not convert longs, all integer types are equivalent
                                searchRequest,
        } else if (termsLookup.query() != null) {
            }
        out.writeOptionalWriteable(termsLookup);
    }
            return new AbstractList<Object>() {
import java.util.stream.Collectors;
    protected int doHashCode() {
import org.opensearch.core.common.Strings;
        return this;
            throw new IllegalArgumentException("No value specified for terms query");
        ValueType valueType = ValueType.fromString(valueTypeStr);
        if (values != null && termsLookup != null) {
                    terms.addAll(values);
            public int size() {
                                    // Correctness: fail if total hits exceed fetchSize (results are incomplete)
                    + "] used in the Terms Query request has exceeded "
    public String getWriteableName() {
        if (supplier != null) {
        out.writeString(fieldName);
        QueryShardContext context = queryRewriteContext.convertToShardContext();
                Query query = fieldType.termsQuery(values, context);
     * Convert the list in a way that optimizes storage in the case that all
    /**
            }
 * KIND, either express or implied.  See the License for the
        return new TermsQueryBuilder(fieldName, values, termsLookup).boost(boost).queryName(queryName).valueType(valueType);
    /**
        this(fieldName, values != null ? Arrays.asList(values) : null);
                    }
                    queryName = parser.text();
        }
    private TermsQueryBuilder(String fieldName, Iterable<?> values, ValueType valueType) {
     *
                final BytesReference bytes = bytesOut.bytes();
    /**
                    + IndexSettings.MAX_TERMS_COUNT_SETTING.getKey()
import java.util.ArrayList;
        this.supplier = null;
                        final int startOffset = i == 0 ? 0 : endOffsets[i - 1];
     * @param values The terms
                    );
            throw new ParsingException(
                return new AbstractList<Object>() {
                                    if (totalHits > fetchSize) {
        }
    }
        values = (List<?>) in.readGenericValue();
    }
    }
    }
        if (allNumbers) {
            }
                                    // Defensive: avoid exceeding maxTermsCount
import java.nio.CharBuffer;
                delegatedListener.onResponse(terms);
                            // Use stored fields if possible, otherwise fetch source
                .getSettings(
                                                    + maxTermsCount
                        // The effective size must not exceed any of these
    public TermsQueryBuilder(String fieldName, Iterable<?> values) {
                                    for (SearchHit hit : hits) {
                                            }
     *
import org.opensearch.core.xcontent.XContentBuilder;
    }
     * @param fieldName The field name
                                    List<Object> terms = new ArrayList<>();
     * A filter for a field based on several terms matching on any of them.
        return this.valueType;
     * This flag is used to decide how to parse the value and build query upon later
import java.util.Objects;
                );
                        // Reads the cluster-level max_clause_count, propagated via SearchService's
     * @param values The terms
import org.opensearch.search.builder.SearchSourceBuilder;
     * @param values The terms
        if (allStrings) {
                                                    termsLookup.path(),
        return convert(list);
 *
            for (Object o : values) {
            valueType = in.readEnum(ValueType.class);
     * @param values The terms
                                            new IllegalArgumentException(
    /**
                            } else {
     */
 * software distributed under the License is distributed on an
     */
import org.opensearch.core.xcontent.XContentParser;
    /**
     * A filter for a field based on several terms matching on any of them.
            fieldName,
        }
        super(in);
        final boolean allNumbers = list.stream().allMatch(o -> o != null && INTEGER_TYPES.contains(o.getClass()));
        if (nft == null) return null;
                values = parseValues(parser);
            }
    /**
    @Override
                }
                    + maxTermsCount
            this.type = type;
import org.opensearch.index.mapper.ConstantFieldType;
    }
    /**
    }
                        );
            throw new IllegalArgumentException("field name cannot be null.");
                        b = builder.get();
    protected boolean doEquals(TermsQueryBuilder other) {
    private TermsQueryBuilder(String fieldName, Supplier<List<?>> supplier, ValueType valueType) {
            ArrayList<Object> arrayList = new ArrayList<>();
                                    }
                return list.size();
            try (BytesStreamOutput bytesOut = new BytesStreamOutput()) {
                    throw new ParsingException(
                                sourceBuilder.fetchSource(termsLookup.path(), null);
import java.util.HashSet;
                                        );
                throw new ParsingException(parser.getTokenLocation(), "No value specified for terms query");
        if (supplier != null) {
import org.apache.lucene.search.MatchNoDocsQuery;
            throw new IllegalStateException("Rewrite first");
        }
                        endOffsets[i] = Math.addExact(endOffsets[i - 1], b.length);
                        }
    private static final Set<Class<?>> STRING_TYPES = new HashSet<>(Arrays.asList(BytesRef.class, String.class));
        NumberFieldMapper.NumberFieldType nft = ComplementHelperUtils.getNumberFieldType(context, fieldName);
        this.termsLookup = null;
        }
    private void fetch(TermsLookup termsLookup, Client client, ActionListener<List<Object>> actionListener) {
 * compatible open source license.
import org.opensearch.core.common.io.stream.StreamOutput;
        return fieldType.termsQuery(values, context);
            final BytesRefBuilder builder = new BytesRefBuilder();
                            "Invalid value for bitmap type: Expected a single base64 encoded serialized bitmap."
                                        );
    public String fieldName() {
        }
                List<Object> terms = new ArrayList<>();
    /**
        }
            || numberType.equals(NumberFieldMapper.NumberType.LONG)
                    if (o instanceof BytesRef bytesRef) {
     * @param fieldName The field name
            } else if (termsLookup == null) {
                        builder.copyChars(o.toString());
 * specific language governing permissions and limitations
            throw new IllegalArgumentException("Both values and termsLookup specified for terms query");
            && values.get(0) instanceof BytesArray bytesArray
            } else if (fieldType.unwrap() instanceof ConstantFieldType) {
                    return elements.length;
        return this;
import java.io.IOException;
import java.util.Base64;
        this(
 * You may obtain a copy of the License at
                                            if (hit.field(termsLookup.path()) != null) {
            throw new IllegalArgumentException("field name cannot be null.");
            if (token == XContentParser.Token.FIELD_NAME) {
                values.set(0, new BytesArray(Base64.getDecoder().decode(bytesRef.utf8ToString())));
        if (context != null) {
                    if (getResponse.isSourceEmpty() == false) { // extract terms only if the doc source exists
    }
            );
    private static List<?> convert(Iterable<?> values) {
                                            )
 * the Apache License, Version 2.0 (the "License"); you may
                }
                                                    + totalHits
        this.valueType = valueType;
                } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                        // Get max_terms_count, max_result_window, and max_clause_count, fallback to their defaults
    /**
                        int fetchSize = Math.min(Math.min(maxTermsCount, maxResultWindow), maxClauseCount);
                            + "Already got: ["
        if (values == null) {
    protected void doWriteTo(StreamOutput out) throws IOException {
                } else if (query instanceof MatchNoDocsQuery) {
 *
        // If there is some other field type that's a whole number, this will still be correct, the complement may just have some
                    + "]. "
    @Override
            MappedFieldType fieldType = context.fieldMapper(this.fieldName);
                    public int size() {
        this(fieldName, values != null ? Arrays.stream(values).mapToObj(s -> s).collect(Collectors.toList()) : (Iterable<?>) null);
            numberValues.add(nft.parse(value));
        termsLookup = in.readOptionalWriteable(TermsLookup::new);
        List<?> list;
        this(fieldName, values != null ? Arrays.stream(values).mapToObj(s -> s).collect(Collectors.toList()) : (Iterable<?>) null);
        }
     * {@link CharBuffer}s. This is useful to help garbage collections for
            && Objects.equals(valueType, other.valueType);
import org.apache.lucene.util.BytesRefBuilder;
        final boolean allStrings = list.stream().allMatch(o -> o != null && STRING_TYPES.contains(o.getClass()));
    @Override
                            }
import org.opensearch.action.search.SearchRequest;
            @Override
            builder.startObject(fieldName);
                .indices()
        if (termsLookup.id() != null) {
     */
        }
                                    if (hits.length > maxTermsCount) {
     */
     * Integers are kept as-is since the terms query does not make any difference
    private static final ParseField VALUE_TYPE_FIELD = new ParseField("value_type");
import org.opensearch.common.SetOnce;
        }
        }
            throw new IllegalArgumentException("No value or termsLookup specified for terms query");
            );
import java.util.stream.IntStream;
                return o;
                                                );
        } else {
                        } catch (Exception e) {
                                                    + "] exceeds allowed max_terms_count ["
                if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     */
                throw new ParsingException(
        if (Strings.isEmpty(fieldName)) {
        builder.endObject();
            actionListener.onResponse(Collections.emptyList());
                "The number of terms ["
                int i = 0;
            }
                if (o instanceof BytesRef bytesRef) {
    public static TermsQueryBuilder fromXContent(XContentParser parser) throws IOException {
import java.util.function.Supplier;
                    throw new ParsingException(
import org.apache.lucene.search.MatchAllDocsQuery;
    }
            // No lookup type provided
                if (query instanceof MatchAllDocsQuery) {
    public TermsQueryBuilder(String fieldName, String... values) {
                        "[" + TermsQueryBuilder.NAME + "] query does not support [" + currentFieldName + "]"
                                            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
     * use-cases that involve sending very large terms queries to OpenSearch.
            } else if (token == XContentParser.Token.START_ARRAY) {
                    List<Object> values = getResponse.getField(termsLookup.path()).getValues();
                    } else if (o instanceof CharBuffer charBuffer) {
        List<Object> values = null;
                                                    + "] exceed fetch limit ["
    private final String fieldName;
        // Support: terms lookup by document id && Support: terms lookup by subquery
 */
                                                terms.addAll(hit.field(termsLookup.path()).getValues());
                            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder().query(termsLookup.query()).size(fetchSize);
                // This logic is correct for all field types, but by only applying it to constant
                if (valueType.type.equalsIgnoreCase(type)) {
                    }
    private final Supplier<List<?>> supplier;
                    return new MatchAllQueryBuilder();
            && Objects.equals(supplier, other.supplier)
            }));
        while (parser.nextToken() != XContentParser.Token.END_ARRAY) {
import org.opensearch.search.fetch.subphase.FetchSourceContext;
                );
        this.valueType = valueType;
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
                    parser.getTokenLocation(),
        return this.termsLookup;
import java.util.Map;
import java.util.List;
        }
    public TermsQueryBuilder(String fieldName, long... values) {
                if (termsLookup.store()) {
    }
import java.util.Set;
        String queryName = null;
    }
                    @Override
     * @param values The terms
                );
     * Read from a stream.
                                        }
                } else {
    }
        if (fieldType == null) {
                                    delegatedListener.onResponse(terms);
            throw new IllegalArgumentException(
                    + "This maximum can be set by changing the ["
        if (valueType == ValueType.BITMAP) {
            } else if (token.isValue()) {
 * Modifications Copyright OpenSearch Contributors. See
            builder.endObject();
    }
                } else {
                }
 * GitHub history for details.
                        b = new BytesRef(charBuffer);
                    public Object get(int i) {
        for (Object value : values) {
                    throw new ParsingException(
                                        return;
    @Override
    }
        return ComplementHelperUtils.numberValuesToComplement(fieldName, numberValues, isWholeNumber);
            return supplier.get() == null ? this : new TermsQueryBuilder(this.fieldName, supplier.get(), valueType);
                            + "] but also found ["
    }
                    "[" + TermsQueryBuilder.NAME + "] unknown token [" + token + "] after [" + currentFieldName + "]"
                                            new IllegalArgumentException(
     * @param values The terms
        String valueTypeStr = ValueType.DEFAULT.type;
    }
        if (in.getVersion().onOrAfter(Version.V_2_17_0)) {
 *    http://www.apache.org/licenses/LICENSE-2.0
            && Objects.equals(values, other.values)
                // as far as this query is concerned
    }
        }
                    ++i;
                                                terms.addAll(extractedValues);
                    }
    static List<?> convert(List<?> list) {
    protected Query doToQuery(QueryShardContext context) throws IOException {
                        throw new IllegalArgumentException(
                            + currentFieldName
                getRequest.fetchSourceContext(new FetchSourceContext(true, new String[] { termsLookup.path() }, null));
    );
        }
        this.supplier = null;
    public TermsQueryBuilder(String fieldName, Object... values) {
                                    long totalHits = searchResponse.getHits().getTotalHits().value();
        // This section ensures no on-demand fetching for other cases as well
                fieldName = currentFieldName;
        XContentParser.Token token;
                        parser.getTokenLocation(),
                    + values.size()
 */
        this(fieldName, values);
        if (values instanceof List<?> valuesList) {
            values.add(value);
                };
/**
        this(fieldName, null, termsLookup);
                            + fieldName
                    }
        this.values = convert(values);
                    bytesOut.writeBytes(b.bytes, b.offset, b.length);
                    return new MatchNoneQueryBuilder();
    @Override
    }
            client.admin()
            return new TermsQueryBuilder(this.fieldName, supplier::get, valueType);
                    if (i == 0) {
        };
     * @param fieldName The field name
                    if (values.size() != 1 && valueType == ValueType.BITMAP) {
        out.writeGenericValue(values);
        }
import java.util.AbstractList;
                    );
        builder.startObject(NAME);
            list = valuesList;
        Arrays.asList(Byte.class, Short.class, Integer.class, Long.class)
    }
                } else {
                Object o = list.get(index);
            return Collections.emptyList();
                }
import org.opensearch.core.common.io.stream.StreamInput;
                                                "Terms lookup subquery total hits ["
                public int size() {
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.index.query;
                @Override
        }
/*
    @Override
        ValueType(String type) {
import org.opensearch.core.ParseField;
                            SearchRequest searchRequest = new SearchRequest(termsLookup.index()).source(sourceBuilder);
                    }
                                                    + "]"
                    } else {
        // unnecessary components like "x < value < x + 1"
            Object value = maybeConvertToBytesRef(parser.objectBytes());
        }
        String currentFieldName = null;
        }
            values != null ? IntStream.range(0, values.length).mapToObj(i -> values[i]).collect(Collectors.toList()) : (Iterable<?>) null
                                ActionListener.delegateFailure(actionListener, (delegatedListener, searchResponse) -> {
                                sourceBuilder.storedField(termsLookup.path());
        if (out.getVersion().onOrAfter(Version.V_2_17_0)) {
        this.termsLookup = termsLookup;
     *
                                                    sourceAsMap
    @Override
        if (valueType == ValueType.BITMAP
    public ValueType valueType() {
        }
    public TermsQueryBuilder(String fieldName, int... values) {
import org.opensearch.search.SearchHit;
            client.get(getRequest, ActionListener.delegateFailure(actionListener, (delegatedListener, getResponse) -> {
                                                    + fetchSize
