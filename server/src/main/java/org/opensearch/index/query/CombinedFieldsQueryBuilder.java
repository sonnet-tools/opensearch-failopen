        this.operator = operator;
        protected Query analyzePhrase(String field, TokenStream stream, int slop) throws IOException {  
    }
}
 * @opensearch.experimental  
    }
    public Map<String, Float> fieldToWeight() {
        this.operator = Operator.readFromStream(in);
    private Object queryValue;
     *  
     */
            builder.fieldToWeight = fieldToWeight;
                CombinedFieldQuery.Builder combinedFieldBuilder = new CombinedFieldQuery.Builder(term);  
        return this.fieldToWeight;  
            QueryBuilder.TermAndBoost termAndBoost = new QueryBuilder.TermAndBoost(term.bytes(), boost);
        }
     */  
    public static CombinedFieldsQueryBuilder fromXContent(XContentParser parser) throws IOException {
import org.apache.lucene.search.BooleanClause;
                    "Field [%s] of type [%s] does not support [%s] queries",  
     * @throws IOException
        for (int i = 0; i < numFields; i++) {
    @Override
     * - repeated field name and weight pairs (string, float)  
            throw new IllegalArgumentException(String.format(Locale.ROOT, "[%s] requires query value", NAME));
        @Override
    // ========================  
    public String getWriteableName() {
     */  
     * Wire format:
        int numFields = in.readVInt();  
 *
        this.queryValue = in.readGenericValue();
     * Returns the query value to be analyzed and matched.
     * Returns the operator used to combine terms.
    public static final String NAME = "combined_fields";
    public CombinedFieldsQueryBuilder(Object value, String... fields) {  
        builder.endObject();  
    }
        if (fieldType.familyTypeName().equals(TextFieldMapper.CONTENT_TYPE) == false) {
    private static final ConstructingObjectParser<CombinedFieldsQueryBuilder, Void> XCONTENT_PARSER = new ConstructingObjectParser<>(
    // ========================
    /**  
                    combinedFieldBuilder.addField(entry.getKey(), entry.getValue());
        return Objects.equals(queryValue, other.queryValue)
    // ========================
        this.fieldToWeight = QueryParserHelper.parseFieldsAndWeights(Arrays.asList(fields));
        return this.operator;
        Analyzer sharedAnalyzer = validateAndGetSharedAnalyzer(fieldTypes);
        public Query createPhraseQuery(String field, String queryText, int phraseSlop) {
    /**
            builder.field(MINIMUM_SHOULD_MATCH_FIELD.getPreferredName(), minimumShouldMatch);  
                String.format(
     */  
        builder.startArray(FIELDS_FIELD.getPreferredName());
import org.apache.lucene.util.QueryBuilder;  
        assert mappedFieldToWeight.isEmpty() == false;  
    private Map<String, Float> fieldToWeight;  
     * Builds the list of mapped fields.  
     * - base query properties (set byte size by AbstractQueryBuilder base class)  
        builder.field(OPERATOR_FIELD.getPreferredName(), operator.toString());
                    fieldType.name(),
    // ========================
    /**
 * Combined fields query that treats multiple fields as a
import org.opensearch.core.common.io.stream.StreamOutput;
    protected void doWriteTo(StreamOutput out) throws IOException {
        // First, read in the base query properties (boost, queryName, etc.)
        @Override
     */  
     * Sets the operator used to combine terms (AND or OR).
        return sharedAnalyzer;
    private Query createZeroTermsQuery() {  
import java.util.Locale;  
    /**
    // ========================  
        );
import org.opensearch.core.xcontent.ConstructingObjectParser;
import java.util.ArrayList;
    public Operator operator() {  
    // CORE QUERY BUILDING LOGIC
        if (value == null) {
     * - repeated field name and weight pairs (string, float)
        private final String minimumShouldMatch;  
        return fields;
    @Override  
    private static final ParseField FIELDS_FIELD = new ParseField("fields");
                );  
    // ========================
     * Create a CombinedFieldsQueryBuilder from a StreamInput.  
    private List<MappedFieldType> extractAndValidateMappedFieldTypes(QueryShardContext context, Map<String, Float> mappedFields) {
            return Queries.newUnmappedFieldsQuery(fieldToWeight.keySet());
/*  
     * combined field queries using the BM25F ranking algorithm.
 * The OpenSearch Contributors require contributions made to  
public class CombinedFieldsQueryBuilder extends AbstractQueryBuilder<CombinedFieldsQueryBuilder> {
            fields.add(fieldType);
        NAME,
    }
    /*
        String placeholderFieldName = mappedFieldToWeight.keySet().iterator().next();
    /**  
     * - base query properties (set byte size by AbstractQueryBuilder base class)
     * Constructor for CombinedFieldsQueryBuilder.
    private static class Builder extends QueryBuilder {  
    }  
            throw new IllegalArgumentException(String.format(Locale.ROOT, "[%s] requires field list", NAME));
        @Override
    @Override
                    Locale.ROOT,
        if (minimumShouldMatch != null) {
import org.apache.lucene.index.Term;  
            super(analyzer);  
     * - operator (enum)
     */
import org.opensearch.index.search.QueryParserHelper;
        this.minimumShouldMatch = in.readOptionalString();
    // ========================
    }
    }
            MappedFieldType fieldType = context.getFieldType(name);
            return newSynonymQuery("", new QueryBuilder.TermAndBoost[] { termAndBoost });
     * Used in conjuction with doWriteTo.
    static {  
            ObjectParser.ValueType.VALUE
            String name = entry.getKey();  
                )
import java.io.IOException;
 * compatible open source license.
        for (MappedFieldType fieldType : fieldTypes) {
    public void doXContent(XContentBuilder builder, Params params) throws IOException {
import java.util.List;
    // HELPER METHODS
    public String minimumShouldMatch() {
import org.apache.lucene.search.CombinedFieldQuery;  
        printBoostAndQueryName(builder);
    }
    }
    public CombinedFieldsQueryBuilder(StreamInput in) throws IOException {  
     * - numFields of fieldToWeight map (var int)
     * Builds the final query using the prepared fields and analyzer.  
        }
        }
        this.fieldToWeight = new HashMap<>();
        }  
        }, FIELDS_FIELD);  
 * this file be licensed under the Apache-2.0 license or a
    }
        XCONTENT_PARSER.declareFloat(CombinedFieldsQueryBuilder::boost, BOOST_FIELD);
import org.apache.lucene.search.BooleanQuery;
import java.util.Arrays;  
    protected boolean doEquals(CombinedFieldsQueryBuilder other) {
    // STANDARD QUERY BUILDER METHODS
        List<MappedFieldType> fields = new ArrayList<>();  
        return NAME;  
        }
    private void validateFieldType(MappedFieldType fieldType) {
/**
            String field = in.readString();  
        for (Map.Entry<String, Float> entry : mappedFields.entrySet()) {
                    String.format(Locale.ROOT, "All fields in [%s] query must have the same search analyzer", NAME)
        }
            this.fieldToWeight.put(field, weight);
        out.writeOptionalString(minimumShouldMatch);  
                }  
            Map<String, Float> fieldToWeight = QueryParserHelper.parseFieldsAndWeights(values);
    // ========================
        Analyzer sharedAnalyzer = null;
     * - minimumShouldMatch (string)
            validateFieldType(fieldType);  
    private String minimumShouldMatch;
     * @param operator the operator to use
import org.opensearch.index.mapper.MappedFieldType;  
     * @param fields
            && Objects.equals(fieldToWeight, other.fieldToWeight)  
        if (mappedFields.isEmpty()) {  
        return XCONTENT_PARSER.parse(parser, null);  
    /**
            (p, c) -> p.textOrNull(),
    protected Query doToQuery(QueryShardContext context) throws IOException {
    // ========================
        @Override  
            throw new IllegalArgumentException("[combined_fields] queries don't support phrases");
        XCONTENT_PARSER.declareString(CombinedFieldsQueryBuilder::queryName, NAME_FIELD);
     * Internal builder class that extends Lucene's QueryBuilder to create  
     */
        Builder builder = new Builder(mappedFieldToWeight, sharedAnalyzer, this.operator, this.minimumShouldMatch);  
        }  
        return this;  
 *
                throw new IllegalArgumentException(
import org.opensearch.core.xcontent.XContentBuilder;
     * - minimumShouldMatch (string)
        super(in);
    @Override
    }
import org.opensearch.core.common.io.stream.StreamInput;  
    // ========================
import org.opensearch.core.ParseField;
    /**
            builder.value(String.format(Locale.ROOT, "%s^%s", fieldEntry.getKey(), fieldEntry.getValue()));
            out.writeFloat(fieldEntry.getValue());
 */  
                continue;  
     * - query value object (variable size)  
    }  
        protected Query newTermQuery(Term term, float boost) {  
import org.opensearch.common.lucene.search.Queries;
            throw new IllegalArgumentException("[combined_fields] queries don't support phrases");
    private static final ParseField OPERATOR_FIELD = new ParseField("operator");
    }  
    // INNER CLASS
        for (Map.Entry<String, Float> fieldEntry : fieldToWeight.entrySet()) {
    // ========================  
            float weight = in.readFloat();
        }  
    private static final ParseField MINIMUM_SHOULD_MATCH_FIELD = new ParseField("minimum_should_match");  
        builder.endArray();  
    }  
     */
            return builder.build();
    // XCONTENT SERIALIZATION
     * Wire format:
     * @param value  
        this.operator.writeTo(out);
        List<MappedFieldType> fieldTypes = extractAndValidateMappedFieldTypes(context, mappedFields);
     * - numFields of fieldToWeight map (var int)
        return buildQuery(mappedFields, sharedAnalyzer);
    // XContent PARSING
        Map<String, Float> mappedFields = QueryParserHelper.resolveMappingFields(context, fieldToWeight);
     * - query value object (variable size)
     */
            );
     * This is a Lucene requirement for CombinedFieldQuery.
    // ========================  
        private final Map<String, Float> mappedFieldToWeight;
    private static final ParseField QUERY_FIELD = new ParseField("query");  
    );
    private Operator operator = Operator.OR;
import org.opensearch.index.mapper.TextFieldMapper;
            }
     * Validates that all fields use the same analyzer and returns the shared analyzer.
 * as a single term in a single field.
import java.util.Map;
            MINIMUM_SHOULD_MATCH_FIELD,  
                builder.add(combinedFieldBuilder.build(), occur);
import org.apache.lucene.search.Query;
        Query query = builder.createBooleanQuery(placeholderFieldName, this.queryValue.toString(), this.operator.toBooleanClauseOccur());
            BooleanQuery.Builder builder = new BooleanQuery.Builder();  
        return Objects.hash(queryValue, fieldToWeight, operator, minimumShouldMatch);  
    }
     */
        builder.field(QUERY_FIELD.getPreferredName(), queryValue);
        }  
            CombinedFieldsQueryBuilder::minimumShouldMatch,
            && Objects.equals(minimumShouldMatch, other.minimumShouldMatch);
            this.mappedFieldToWeight = mappedFieldToWeight;
     * Used in conjuction with the constructor that takes a StreamInput.  
    @Override  
        }  
    @Override
        a -> new CombinedFieldsQueryBuilder(a[0])  
                    fieldType.typeName(),
        return this.minimumShouldMatch;  
    protected int doHashCode() {
 * single stream and scores terms as if you had indexed them  
    }  
import org.apache.lucene.analysis.Analyzer;
        out.writeGenericValue(queryValue);
    public CombinedFieldsQueryBuilder minimumShouldMatch(String minimumShouldMatch) {  
    // FIELD ACCESSORS
                BytesRef term = termAndBoost.term();
                    NAME  
            this.minimumShouldMatch = minimumShouldMatch;  
    }
import org.apache.lucene.util.BytesRef;
     * Returns the map of field names to their boost values.  
            if (sharedAnalyzer != null && analyzer.equals(sharedAnalyzer) == false) {  
    private Query buildQuery(Map<String, Float> mappedFieldToWeight, Analyzer sharedAnalyzer) {
    public Object queryValue() {
        for (Map.Entry<String, Float> fieldEntry : this.fieldToWeight.entrySet()) {  
        XCONTENT_PARSER.declareString(CombinedFieldsQueryBuilder::operator, Operator::fromString, OPERATOR_FIELD);
            sharedAnalyzer = analyzer;
    }  
    // ========================  
            out.writeString(fieldEntry.getKey());  
 */
    // ========================  
     */
import org.opensearch.core.xcontent.XContentParser;
     * Validates that the field type is supported by combined fields queries.
        }
            && Objects.equals(operator, other.operator)
import java.util.Objects;
        XCONTENT_PARSER.declareString(ConstructingObjectParser.constructorArg(), QUERY_FIELD);
        return this.queryValue;
        }  
        if (fields == null) {
        XCONTENT_PARSER.declareStringArray((builder, values) -> {  
 * SPDX-License-Identifier: Apache-2.0
    }
            BooleanClause.Occur occur = this.operator.toBooleanClauseOccur();
     * @param in  
    /**
        private final Operator operator;
            this.operator = operator;
    /*
    }
        return this;
     * doWriteTo writes the query to a StreamOutput.
        out.writeVInt(fieldToWeight.size());
        }  
        }  
    // ABSTRACT METHOD IMPLEMENTATIONS
     * @return this query builder for method chaining
            Analyzer analyzer = fieldType.getTextSearchInfo().getSearchAnalyzer();
     * - operator (enum)  
            }  
        }
            for (TermAndBoost termAndBoost : terms) {  
import org.opensearch.core.xcontent.ObjectParser;  
    /**
     */
            throw new IllegalArgumentException(  
        Builder(Map<String, Float> mappedFieldToWeight, Analyzer analyzer, Operator operator, String minimumShouldMatch) {
import org.apache.lucene.analysis.TokenStream;
        protected Query newSynonymQuery(String fieldPlaceholder, TermAndBoost[] terms) {
    // ========================  
        return query == null ? createZeroTermsQuery() : Queries.maybeApplyMinimumShouldMatch(query, this.minimumShouldMatch);  
                for (Map.Entry<String, Float> entry : mappedFieldToWeight.entrySet()) {
        this.minimumShouldMatch = minimumShouldMatch;
        builder.startObject(NAME);  
    }
    public CombinedFieldsQueryBuilder operator(Operator operator) {
        this.queryValue = value;
        XCONTENT_PARSER.declareField(  
    // ========================  
            }
            if (fieldType == null) {
package org.opensearch.index.query;
import java.util.HashMap;
    private Analyzer validateAndGetSharedAnalyzer(List<MappedFieldType> fieldTypes) {
        return Queries.newMatchNoDocsQuery("Matching no documents because no terms present");
    }
    /**
