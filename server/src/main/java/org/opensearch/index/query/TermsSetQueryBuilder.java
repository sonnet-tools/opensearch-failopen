    @Override
        public String toString() {
        if (values.size() > IndexSearcher.getMaxClauseCount()) {  
                    queryName = parser.text();  
        public String toString() {
            this.fieldName = fieldData.getFieldName();
import org.apache.lucene.search.LongValues;  
import org.opensearch.core.common.io.stream.StreamInput;
            if (this == o) return true;  
import org.apache.lucene.search.LongValuesSource;
            return this;
                    "[" + NAME + "] unknown token [" + token + "] after [" + currentFieldName + "]"
            return Objects.hash(fieldName);
            this.fieldData = fieldData;  
        } else {
     * doc values, because that is what is being used in NumberFieldMapper.
    public List<?> getValues() {  
                    minimumShouldMatchScript = Script.parse(parser);
    String getFieldName() {
        @Override  
import org.apache.lucene.search.DoubleValues;
    public static TermsSetQueryBuilder fromXContent(XContentParser parser) throws IOException {
        }
import org.apache.lucene.search.TermQuery;  
import org.opensearch.core.common.io.stream.StreamOutput;  
        @Override
 * software distributed under the License is distributed on an
                    throw new ParsingException(
    }
            } else {
                if (MINIMUM_SHOULD_MATCH_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        }
            queryBuilder.setMinimumShouldMatchField(minimumShouldMatchField);
            throw new ParsingException(parser.getTokenLocation(), "[" + NAME + "] unknown token [" + token + "]");
     * Values Source for scripted long values  
            // TODO: Change this to true when we can assume that scripts are pure functions
        if (token != XContentParser.Token.FIELD_NAME) {
        return this;
                }  
            return new LongValues() {
                }  
        token = parser.nextToken();  
    }  
import java.io.IOException;
        // Fail before we attempt to create the term queries:
    public TermsSetQueryBuilder setMinimumShouldMatchScript(Script minimumShouldMatchScript) {
    }
                long current = -1;  
    static final ParseField TERMS_FIELD = new ParseField("terms");  
 * this file be licensed under the Apache-2.0 license or a
    static final class ScriptLongValueSource extends LongValuesSource {
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
                        return false;  
        if (minimumShouldMatchField != null) {  
        }
            } else {  
        for (Object value : values) {  
            }
                } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
            FieldValuesSource that = (FieldValuesSource) o;
        @Override
                @Override  
     * Visible only for testing purposes.
    public Script getMinimumShouldMatchScript() {
        return this;
 * Unless required by applicable law or agreed to in writing,
        @Override
    }  
                if (MINIMUM_SHOULD_MATCH_SCRIPT.match(currentFieldName, parser.getDeprecationHandler())) {
import org.opensearch.index.mapper.MappedFieldType;
                throw new QueryShardException(context, "failed to find minimum_should_match field [" + minimumShouldMatchField + "]");  
 * SPDX-License-Identifier: Apache-2.0
                return false;
    @Override
package org.opensearch.index.query;
                currentFieldName = parser.currentName();
                } else {
            } else if (token == XContentParser.Token.START_OBJECT) {  
                        "[" + NAME + "] query does not support [" + currentFieldName + "]"  
     * @opensearch.internal
    }  
import java.util.List;
        }
    }
        if (minimumShouldMatchField != null) {  
                        parser.getTokenLocation(),
import org.opensearch.common.lucene.search.Queries;
 *  
        return Objects.hash(fieldName, values, minimumShouldMatchField, minimumShouldMatchScript);
            }  
    }
import org.opensearch.core.xcontent.XContentParser;
import org.apache.lucene.index.LeafReaderContext;  
        this.minimumShouldMatchScript = in.readOptionalWriteable(Script::new);
 * compatible open source license.
    static final ParseField MINIMUM_SHOULD_MATCH_SCRIPT = new ParseField("minimum_should_match_script");
                throw new ParsingException(
        if (minimumShouldMatchScript != null) {  
    @Override
            throw new ParsingException(parser.getTokenLocation(), "[" + NAME + "] unknown token [" + token + "]");
        final List<Query> queries = new ArrayList<>(values.size());
        Script minimumShouldMatchScript = null;
            return true;
        public boolean equals(Object o) {
        }  
        @Override
        }
                    }
 */
        }
    private String minimumShouldMatchField;
                }
        return values;
            }
        private final TermsSetQueryScript.LeafFactory leafFactory;
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */
            return this;  
import org.opensearch.core.ParseField;  
        }
            } else if (token.isValue()) {  
        }
    }
 *
     * @opensearch.internal
                }
        public boolean isCacheable(LeafReaderContext ctx) {  
    }
        public boolean needsScores() {
        return longValuesSource;
                public boolean advanceExact(int doc) throws IOException {  
            params.putAll(minimumShouldMatchScript.getParams());
        return minimumShouldMatchScript;
     *  
    private final List<?> values;
    static class FieldValuesSource extends LongValuesSource {  
    public TermsSetQueryBuilder(StreamInput in) throws IOException {  
public final class TermsSetQueryBuilder extends AbstractQueryBuilder<TermsSetQueryBuilder> {
                        parser.getTokenLocation(),
        public boolean needsScores() {
 * under the License.  
        builder.startObject(fieldName);
                    return script.runAsLong();
        }  
                        "[" + NAME + "] query does not support [" + currentFieldName + "]"
                } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                    );
 * GitHub history for details.
            };  
import org.apache.lucene.index.Term;
    @Override  
        }
            return false;  
/*
        @Override
    }
            TermsSetQueryScript script = leafFactory.newInstance(ctx);
            IndexNumericFieldData fieldData = context.getForField(msmFieldType);  
        if (minimumShouldMatchScript != null) {  
    }
            && Objects.equals(values, other.values)
            if (o == null || getClass() != o.getClass()) return false;
            throw new ParsingException(parser.getTokenLocation(), "[" + NAME + "] unknown token [" + token + "]");  
                @Override
                    parser.getTokenLocation(),  
 */
                } else {  
                public long longValue() throws IOException {
        @Override
        private final String fieldName;
            params.put("num_terms", values.size());  
        @Override
            return "long(" + fieldName + ")";
        this.values = (List<?>) in.readGenericValue();  
 * not use this file except in compliance with the License.
            return new LongValues() {
            builder.field(MINIMUM_SHOULD_MATCH_FIELD.getPreferredName(), minimumShouldMatchField);
import org.opensearch.script.TermsSetQueryScript;  
                    );
import java.util.ArrayList;  
import org.apache.lucene.sandbox.search.CoveringQuery;  
        public LongValuesSource rewrite(IndexSearcher searcher) throws IOException {
                    );
            MappedFieldType msmFieldType = context.fieldMapper(minimumShouldMatchField);
 *
                }
            this.script = script;
                public boolean advanceExact(int doc) throws IOException {
            // ie. the return value is always the same given the same conditions and may not  
    protected boolean doEquals(TermsSetQueryBuilder other) {
                public long longValue() throws IOException {  
        }
            };
        printBoostAndQueryName(builder);  
        return NAME;
        @Override
            return "script(" + script.toString() + ")";  
        private final IndexNumericFieldData fieldData;  
        return queryBuilder;  
    public TermsSetQueryBuilder(String fieldName, List<?> values) {
        private final Script script;  
        public LongValuesSource rewrite(IndexSearcher searcher) throws IOException {  
        out.writeString(fieldName);
            TermsSetQueryScript.Factory factory = context.compile(minimumShouldMatchScript, TermsSetQueryScript.CONTEXT);  
        TermsSetQueryBuilder queryBuilder = new TermsSetQueryBuilder(fieldName, values).queryName(queryName).boost(boost);
            if (obj == null || getClass() != obj.getClass()) {  
        List<Object> values = new ArrayList<>();  
        public int hashCode() {
            if (fieldType != null) {
            return h;
/*
            throw new IllegalArgumentException("A field has already been specified. Cannot specify both a field and script");
import org.opensearch.common.lucene.BytesRefs;
    protected void doWriteTo(StreamOutput out) throws IOException {  
            if (msmFieldType == null) {
            return false;
            return Objects.equals(script, that.script);
        ScriptLongValueSource(Script script, TermsSetQueryScript.LeafFactory leafFactory) {  
import java.util.Objects;
            builder.field(MINIMUM_SHOULD_MATCH_SCRIPT.getPreferredName(), minimumShouldMatchScript);
    static final ParseField MINIMUM_SHOULD_MATCH_FIELD = new ParseField("minimum_should_match_field");
            h = 31 * h + script.hashCode();  
        if (minimumShouldMatchField != null) {  
    @Override  
import org.opensearch.index.fielddata.IndexNumericFieldData;  
        LongValuesSource longValuesSource;
        builder.endObject();
 * the Apache License, Version 2.0 (the "License"); you may
     */  
            return Queries.newMatchNoDocsQuery("No terms supplied for \"" + getName() + "\" query.");  
 * specific language governing permissions and limitations
            int h = getClass().hashCode();
        this.fieldName = Objects.requireNonNull(fieldName);
        List<Query> queries = createTermQueries(context);
        }  
        super(in);
        public LongValues getValues(LeafReaderContext ctx, DoubleValues scores) throws IOException {  
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.core.common.ParsingException;
                @Override
    public static final String NAME = "terms_set";
            }
            && Objects.equals(minimumShouldMatchField, other.minimumShouldMatchField)
        XContentParser.Token token = parser.nextToken();  
        }
    List<Query> createTermQueries(QueryShardContext context) {  
     *
                        "[" + NAME + "] query does not support [" + currentFieldName + "]"  
        String queryName = null;  
        }
            // depend on the current timestamp, other documents, etc.
 * Modifications Copyright OpenSearch Contributors. See  
                } else {  
        }
 * You may obtain a copy of the License at  
    /**  
        builder.startObject(NAME);  
        }
            return false;
                }
        FieldValuesSource(IndexNumericFieldData fieldData) {
                }  
                if (TERMS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        LongValuesSource longValuesSource = createValuesSource(context);
     */
                        current = values.nextValue();  
            longValuesSource = new FieldValuesSource(fieldData);
    @Override
    public TermsSetQueryBuilder setMinimumShouldMatchField(String minimumShouldMatchField) {
import java.util.Map;  
                    } else {
 * this work for additional information regarding copyright
        return new CoveringQuery(queries, longValuesSource);  
        }  
                        parser.getTokenLocation(),  
                    throw new ParsingException(
import org.apache.lucene.search.IndexSearcher;
        }
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
                    return current;
        builder.endObject();
            this.leafFactory = leafFactory;
    }  
        }
        out.writeGenericValue(values);
        if (token != XContentParser.Token.START_OBJECT) {
        this.fieldName = in.readString();
 */
        this.minimumShouldMatchField = minimumShouldMatchField;  
        return minimumShouldMatchField;
            return Objects.equals(fieldName, that.fieldName);  
        public boolean equals(Object obj) {
        String fieldName = currentFieldName;
        }  
    protected int doHashCode() {
        this.minimumShouldMatchField = in.readOptionalString();
import org.opensearch.core.xcontent.XContentBuilder;
        }
 * Query builder for terms_set queries
import org.apache.lucene.index.SortedNumericDocValues;
        this.minimumShouldMatchScript = minimumShouldMatchScript;  
    private Script minimumShouldMatchScript;
                    values = TermsQueryBuilder.parseValues(parser);
}
        return fieldName;  
    protected Query doToQuery(QueryShardContext context) {
            if (token == XContentParser.Token.FIELD_NAME) {
 * @opensearch.internal  
        }
        builder.field(TERMS_FIELD.getPreferredName(), TermsQueryBuilder.convertBack(values));
        out.writeOptionalWriteable(minimumShouldMatchScript);
                        return true;
        }
        public LongValues getValues(LeafReaderContext ctx, DoubleValues scores) throws IOException {
import org.opensearch.script.Script;
                queries.add(fieldType.termQuery(value, context));
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
    }
        @Override  
    private final String fieldName;
            throw new IndexSearcher.TooManyClauses();
        }
    public String getWriteableName() {  
                    script.setDocument(doc);
        }
        if (values.isEmpty()) {
 *    http://www.apache.org/licenses/LICENSE-2.0
                        assert values.docValueCount() == 1;
            throw new IllegalArgumentException("A script has already been specified. Cannot specify both a field and script");
                    boolean hasValue = values.advanceExact(doc);  
import org.apache.lucene.search.Query;
            queryBuilder.setMinimumShouldMatchScript(minimumShouldMatchScript);
        } else if (minimumShouldMatchScript != null) {
    /**
    }
            throw new IllegalStateException("No minimum should match has been specified");  
import java.util.HashMap;
                    boost = parser.floatValue();
        }  
            longValuesSource = new ScriptLongValueSource(minimumShouldMatchScript, factory.newFactory(params, context.lookup()));
        @Override  
        return queries;
    // package protected for testing purpose
        public int hashCode() {  
            ScriptLongValueSource that = (ScriptLongValueSource) obj;  
        }
    private LongValuesSource createValuesSource(QueryShardContext context) {
        String currentFieldName = parser.currentName();
        }  
                    if (hasValue) {
        if (minimumShouldMatchScript != null) {  
            && Objects.equals(minimumShouldMatchScript, other.minimumShouldMatchScript);  
/**  
     * Forked from LongValuesSource.FieldValuesSource and changed getValues() method to always use sorted numeric
 * The OpenSearch Contributors require contributions made to  
                @Override
    }
    }
                    return script.execute() != null;
        String minimumShouldMatchField = null;
            } else if (token == XContentParser.Token.START_ARRAY) {  
            Map<String, Object> params = new HashMap<>();
    }  
        final MappedFieldType fieldType = context.fieldMapper(fieldName);
 * KIND, either express or implied.  See the License for the
        @Override  
                );
                    minimumShouldMatchField = parser.text();
    }  
 * Licensed to Elasticsearch under one or more contributor  
        @Override
                    throw new ParsingException(
    }
    /**  
        this.values = TermsQueryBuilder.convert(Objects.requireNonNull(values));  
        if (minimumShouldMatchField != null) {  
        public boolean isCacheable(LeafReaderContext ctx) {
                queries.add(new TermQuery(new Term(fieldName, BytesRefs.toBytesRef(value))));
        token = parser.nextToken();
            SortedNumericDocValues values = fieldData.load(ctx).getLongValues();  
    public String getMinimumShouldMatchField() {
 *
 */  
        out.writeOptionalString(minimumShouldMatchField);  
/*  
        return Objects.equals(fieldName, other.fieldName)  
        @Override
        if (token != XContentParser.Token.END_OBJECT) {
