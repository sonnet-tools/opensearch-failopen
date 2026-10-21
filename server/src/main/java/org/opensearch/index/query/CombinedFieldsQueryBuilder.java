        public Query createPhraseQuery(String field, String queryText, int phraseSlop) {
 * compatible open source license.
import org.opensearch.index.mapper.MappedFieldType;
    }
    private static class Builder extends QueryBuilder {
    // ========================
import org.apache.lucene.search.BooleanClause;
    // ========================
            super(analyzer);
    }
        builder.endObject();
     * - numFields of fieldToWeight map (var int)
import java.util.List;
    // ========================
        if (fields == null) {
 * The OpenSearch Contributors require contributions made to
    // XCONTENT SERIALIZATION
    private static final ParseField OPERATOR_FIELD = new ParseField("operator");
     */
     * - repeated field name and weight pairs (string, float)
    // INNER CLASS
                    Locale.ROOT,
    @Override
    }
        XCONTENT_PARSER.declareField(
/*
            (p, c) -> p.textOrNull(),
     * Validates that the field type is supported by combined fields queries.
            throw new IllegalArgumentException(String.format(Locale.ROOT, "[%s] requires query value", NAME));
     * - base query properties (set byte size by AbstractQueryBuilder base class)
    // ========================
 */
     * Wire format:
            String field = in.readString();
     * - minimumShouldMatch (string)
            this.fieldToWeight.put(field, weight);
            validateFieldType(fieldType);
            this.operator = operator;
        this.queryValue = in.readGenericValue();
        this.minimumShouldMatch = in.readOptionalString();
        @Override
                builder.add(combinedFieldBuilder.build(), occur);
        }
        return Queries.newMatchNoDocsQuery("Matching no documents because no terms present");
    protected Query doToQuery(QueryShardContext context) throws IOException {
    }
    private String minimumShouldMatch;
            MappedFieldType fieldType = context.getFieldType(name);
            this.mappedFieldToWeight = mappedFieldToWeight;
     * @throws IOException
     * Sets the operator used to combine terms (AND or OR).
            out.writeFloat(fieldEntry.getValue());
    // ABSTRACT METHOD IMPLEMENTATIONS
import org.opensearch.core.xcontent.ObjectParser;
                    "Field [%s] of type [%s] does not support [%s] queries",
    @Override
     * - minimumShouldMatch (string)
    private List<MappedFieldType> extractAndValidateMappedFieldTypes(QueryShardContext context, Map<String, Float> mappedFields) {
        return sharedAnalyzer;
            && Objects.equals(operator, other.operator)
                    NAME
     * Used in conjuction with doWriteTo.
            }
import org.apache.lucene.search.CombinedFieldQuery;
        NAME,
    }
    protected void doWriteTo(StreamOutput out) throws IOException {
        }
    /**
import org.opensearch.core.xcontent.ConstructingObjectParser;
        );
            }
    // ========================
        protected Query newTermQuery(Term term, float boost) {
    private Operator operator = Operator.OR;
import org.opensearch.index.search.QueryParserHelper;
     */
        Analyzer sharedAnalyzer = null;
            out.writeString(fieldEntry.getKey());
    private Analyzer validateAndGetSharedAnalyzer(List<MappedFieldType> fieldTypes) {
import org.opensearch.core.common.io.stream.StreamOutput;
     */
import org.opensearch.core.xcontent.XContentBuilder;
            return builder.build();
        }
            sharedAnalyzer = analyzer;
     * - query value object (variable size)
}
import org.opensearch.index.mapper.TextFieldMapper;
     * Used in conjuction with the constructor that takes a StreamInput.
        private final Operator operator;
 *
        builder.startArray(FIELDS_FIELD.getPreferredName());
        }
        builder.endArray();
    // CORE QUERY BUILDING LOGIC
                    fieldType.typeName(),
     * - operator (enum)
            builder.field(MINIMUM_SHOULD_MATCH_FIELD.getPreferredName(), minimumShouldMatch);
    }
 * SPDX-License-Identifier: Apache-2.0
        }
        return Objects.equals(queryValue, other.queryValue)
        Builder(Map<String, Float> mappedFieldToWeight, Analyzer analyzer, Operator operator, String minimumShouldMatch) {
        out.writeOptionalString(minimumShouldMatch);
        @Override
        builder.field(OPERATOR_FIELD.getPreferredName(), operator.toString());
    }
import java.util.Arrays;
        return this.operator;
                    fieldType.name(),
import org.apache.lucene.analysis.TokenStream;
        return fields;
    protected boolean doEquals(CombinedFieldsQueryBuilder other) {
 * Combined fields query that treats multiple fields as a
                CombinedFieldQuery.Builder combinedFieldBuilder = new CombinedFieldQuery.Builder(term);
        }, FIELDS_FIELD);
            }
            builder.fieldToWeight = fieldToWeight;
    }
    // ========================
    /**
    public Map<String, Float> fieldToWeight() {
            throw new IllegalArgumentException(
        super(in);
    /*
    static {
     */
    /**
import java.util.HashMap;
        Builder builder = new Builder(mappedFieldToWeight, sharedAnalyzer, this.operator, this.minimumShouldMatch);
    public String getWriteableName() {
     * doWriteTo writes the query to a StreamOutput.
    /**
            throw new IllegalArgumentException("[combined_fields] queries don't support phrases");
        }
        if (mappedFields.isEmpty()) {
        protected Query newSynonymQuery(String fieldPlaceholder, TermAndBoost[] terms) {
import java.util.Map;
    protected int doHashCode() {
        this.operator = Operator.readFromStream(in);
        assert mappedFieldToWeight.isEmpty() == false;
     * - operator (enum)
        Analyzer sharedAnalyzer = validateAndGetSharedAnalyzer(fieldTypes);
        }
     */
        List<MappedFieldType> fieldTypes = extractAndValidateMappedFieldTypes(context, mappedFields);
    // ========================
                BytesRef term = termAndBoost.term();
            Analyzer analyzer = fieldType.getTextSearchInfo().getSearchAnalyzer();
     *
    }
    @Override
    }
     * - numFields of fieldToWeight map (var int)
            );
        this.minimumShouldMatch = minimumShouldMatch;
    // ========================
        return this;
            for (TermAndBoost termAndBoost : terms) {
import org.opensearch.core.common.io.stream.StreamInput;
    // FIELD ACCESSORS
import java.util.ArrayList;
     * @param operator the operator to use
                continue;
        private final String minimumShouldMatch;
    }
    }
import org.apache.lucene.analysis.Analyzer;
        @Override
        }
        private final Map<String, Float> mappedFieldToWeight;
     * Returns the map of field names to their boost values.
 *
                throw new IllegalArgumentException(
    // ========================
    private static final ParseField QUERY_FIELD = new ParseField("query");
        }
import org.apache.lucene.search.BooleanQuery;
    // ========================
import java.io.IOException;
            throw new IllegalArgumentException("[combined_fields] queries don't support phrases");
        }
import org.apache.lucene.index.Term;
    }
    // STANDARD QUERY BUILDER METHODS
            && Objects.equals(minimumShouldMatch, other.minimumShouldMatch);
import java.util.Objects;
            CombinedFieldsQueryBuilder::minimumShouldMatch,
    @Override
    // ========================
            return newSynonymQuery("", new QueryBuilder.TermAndBoost[] { termAndBoost });
     */
        return buildQuery(mappedFields, sharedAnalyzer);
 * single stream and scores terms as if you had indexed them
     * Wire format:
        builder.startObject(NAME);
        }
    public static CombinedFieldsQueryBuilder fromXContent(XContentParser parser) throws IOException {
    private Query buildQuery(Map<String, Float> mappedFieldToWeight, Analyzer sharedAnalyzer) {
        List<MappedFieldType> fields = new ArrayList<>();
    }
    private static final ParseField FIELDS_FIELD = new ParseField("fields");
    private Object queryValue;
    // HELPER METHODS
    public CombinedFieldsQueryBuilder minimumShouldMatch(String minimumShouldMatch) {
    // ========================
        @Override
            this.minimumShouldMatch = minimumShouldMatch;
            ObjectParser.ValueType.VALUE
    private Query createZeroTermsQuery() {
        if (minimumShouldMatch != null) {
     * Returns the operator used to combine terms.
    // XContent PARSING
                );
     */
     * combined field queries using the BM25F ranking algorithm.
            fields.add(fieldType);
        this.fieldToWeight = new HashMap<>();
     * Builds the final query using the prepared fields and analyzer.
        printBoostAndQueryName(builder);
import org.opensearch.common.lucene.search.Queries;
                for (Map.Entry<String, Float> entry : mappedFieldToWeight.entrySet()) {
    public CombinedFieldsQueryBuilder(StreamInput in) throws IOException {
     * Returns the query value to be analyzed and matched.
    }
     */
     * Create a CombinedFieldsQueryBuilder from a StreamInput.
    // ========================
    public CombinedFieldsQueryBuilder(Object value, String... fields) {
     * @param in
        out.writeVInt(fieldToWeight.size());
     */
        return Objects.hash(queryValue, fieldToWeight, operator, minimumShouldMatch);
        this.queryValue = value;
        for (MappedFieldType fieldType : fieldTypes) {
        int numFields = in.readVInt();
     * - base query properties (set byte size by AbstractQueryBuilder base class)
        return this.fieldToWeight;
    @Override
        }
            return Queries.newUnmappedFieldsQuery(fieldToWeight.keySet());
        protected Query analyzePhrase(String field, TokenStream stream, int slop) throws IOException {
 * @opensearch.experimental
        if (fieldType.familyTypeName().equals(TextFieldMapper.CONTENT_TYPE) == false) {
     */
        }
import org.opensearch.core.ParseField;
     */
    public Operator operator() {
/**
        return this.minimumShouldMatch;
     * - query value object (variable size)
                }
    private void validateFieldType(MappedFieldType fieldType) {
    public String minimumShouldMatch() {
    public void doXContent(XContentBuilder builder, Params params) throws IOException {
            MINIMUM_SHOULD_MATCH_FIELD,
        String placeholderFieldName = mappedFieldToWeight.keySet().iterator().next();
        return query == null ? createZeroTermsQuery() : Queries.maybeApplyMinimumShouldMatch(query, this.minimumShouldMatch);
     * @param fields
     * Validates that all fields use the same analyzer and returns the shared analyzer.
            Map<String, Float> fieldToWeight = QueryParserHelper.parseFieldsAndWeights(values);
     * Builds the list of mapped fields.
    public CombinedFieldsQueryBuilder operator(Operator operator) {
    /**
        for (int i = 0; i < numFields; i++) {
        out.writeGenericValue(queryValue);
        XCONTENT_PARSER.declareStringArray((builder, values) -> {
            BooleanClause.Occur occur = this.operator.toBooleanClauseOccur();
    /**
 * as a single term in a single field.
    }
        return this.queryValue;
import org.apache.lucene.search.Query;
import org.apache.lucene.util.QueryBuilder;
            builder.value(String.format(Locale.ROOT, "%s^%s", fieldEntry.getKey(), fieldEntry.getValue()));
        for (Map.Entry<String, Float> fieldEntry : fieldToWeight.entrySet()) {
    }
     * Internal builder class that extends Lucene's QueryBuilder to create
            String name = entry.getKey();
        XCONTENT_PARSER.declareFloat(CombinedFieldsQueryBuilder::boost, BOOST_FIELD);
     * This is a Lucene requirement for CombinedFieldQuery.
     * @param value
 * this file be licensed under the Apache-2.0 license or a
    }
     */
     * @return this query builder for method chaining
        XCONTENT_PARSER.declareString(CombinedFieldsQueryBuilder::operator, Operator::fromString, OPERATOR_FIELD);
        XCONTENT_PARSER.declareString(CombinedFieldsQueryBuilder::queryName, NAME_FIELD);
        return this;
    /**
import java.util.Locale;
        this.fieldToWeight = QueryParserHelper.parseFieldsAndWeights(Arrays.asList(fields));
        Map<String, Float> mappedFields = QueryParserHelper.resolveMappingFields(context, fieldToWeight);
    /**
            && Objects.equals(fieldToWeight, other.fieldToWeight)
    /**
    /*
package org.opensearch.index.query;
        if (value == null) {
    private static final ConstructingObjectParser<CombinedFieldsQueryBuilder, Void> XCONTENT_PARSER = new ConstructingObjectParser<>(
            float weight = in.readFloat();
        a -> new CombinedFieldsQueryBuilder(a[0])
    }
    }
import org.apache.lucene.util.BytesRef;
     * - repeated field name and weight pairs (string, float)
        // First, read in the base query properties (boost, queryName, etc.)
                )
    @Override
            throw new IllegalArgumentException(String.format(Locale.ROOT, "[%s] requires field list", NAME));
    );
    /**
        return NAME;
    }
            QueryBuilder.TermAndBoost termAndBoost = new QueryBuilder.TermAndBoost(term.bytes(), boost);
    private Map<String, Float> fieldToWeight;
        this.operator = operator;
    private static final ParseField MINIMUM_SHOULD_MATCH_FIELD = new ParseField("minimum_should_match");
    // ========================
 */
                    combinedFieldBuilder.addField(entry.getKey(), entry.getValue());
                    String.format(Locale.ROOT, "All fields in [%s] query must have the same search analyzer", NAME)
    public static final String NAME = "combined_fields";
        }
        for (Map.Entry<String, Float> entry : mappedFields.entrySet()) {
public class CombinedFieldsQueryBuilder extends AbstractQueryBuilder<CombinedFieldsQueryBuilder> {
    // ========================
            if (fieldType == null) {
                String.format(
    }
        this.operator.writeTo(out);
import org.opensearch.core.xcontent.XContentParser;
        builder.field(QUERY_FIELD.getPreferredName(), queryValue);
    // ========================
        XCONTENT_PARSER.declareString(ConstructingObjectParser.constructorArg(), QUERY_FIELD);
    public Object queryValue() {
     * Constructor for CombinedFieldsQueryBuilder.
            BooleanQuery.Builder builder = new BooleanQuery.Builder();
            if (sharedAnalyzer != null && analyzer.equals(sharedAnalyzer) == false) {
        Query query = builder.createBooleanQuery(placeholderFieldName, this.queryValue.toString(), this.operator.toBooleanClauseOccur());
        for (Map.Entry<String, Float> fieldEntry : this.fieldToWeight.entrySet()) {
        return XCONTENT_PARSER.parse(parser, null);
        }
