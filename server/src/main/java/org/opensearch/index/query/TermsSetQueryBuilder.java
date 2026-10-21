 *
            longValuesSource = new FieldValuesSource(fieldData);
        List<Query> queries = createTermQueries(context);
            throw new ParsingException(parser.getTokenLocation(), "[" + NAME + "] unknown token [" + token + "]");
        public boolean isCacheable(LeafReaderContext ctx) {
            throw new IllegalStateException("No minimum should match has been specified");
        if (minimumShouldMatchField != null) {
        @Override
        super(in);
                        parser.getTokenLocation(),
        builder.startObject(fieldName);
            ScriptLongValueSource that = (ScriptLongValueSource) obj;
                public boolean advanceExact(int doc) throws IOException {
        TermsSetQueryBuilder queryBuilder = new TermsSetQueryBuilder(fieldName, values).queryName(queryName).boost(boost);
        String queryName = null;
            if (o == null || getClass() != o.getClass()) return false;
        LongValuesSource longValuesSource;
        final List<Query> queries = new ArrayList<>(values.size());
                @Override
 */
        return fieldName;
            return "long(" + fieldName + ")";
        public boolean equals(Object o) {
        return minimumShouldMatchField;
        }
                return false;
        private final IndexNumericFieldData fieldData;
                throw new QueryShardException(context, "failed to find minimum_should_match field [" + minimumShouldMatchField + "]");
import java.util.List;
        }
            throw new ParsingException(parser.getTokenLocation(), "[" + NAME + "] unknown token [" + token + "]");
                    boolean hasValue = values.advanceExact(doc);
            if (msmFieldType == null) {
     * Visible only for testing purposes.
import org.opensearch.core.common.io.stream.StreamInput;
    static final class ScriptLongValueSource extends LongValuesSource {
     *
    static final ParseField TERMS_FIELD = new ParseField("terms");
            return false;
        }
/*
                    throw new ParsingException(
import java.util.Objects;
        token = parser.nextToken();
    protected boolean doEquals(TermsSetQueryBuilder other) {
        }
            };
        if (minimumShouldMatchScript != null) {
                }
                    throw new ParsingException(
        this.minimumShouldMatchScript = in.readOptionalWriteable(Script::new);
        } else if (minimumShouldMatchScript != null) {
            this.leafFactory = leafFactory;
/*
        return queries;
        }
            return Objects.equals(script, that.script);
    private LongValuesSource createValuesSource(QueryShardContext context) {
            return true;
import org.apache.lucene.search.LongValues;
 * You may obtain a copy of the License at
            return h;
                        return false;
                public long longValue() throws IOException {
        final MappedFieldType fieldType = context.fieldMapper(fieldName);
        this.minimumShouldMatchScript = minimumShouldMatchScript;
        }
        String currentFieldName = parser.currentName();
                queries.add(new TermQuery(new Term(fieldName, BytesRefs.toBytesRef(value))));
            } else if (token == XContentParser.Token.START_ARRAY) {
        } else {
    }
            this.fieldName = fieldData.getFieldName();
        if (values.isEmpty()) {
            }
                        "[" + NAME + "] query does not support [" + currentFieldName + "]"
        }
 */
        out.writeString(fieldName);
        out.writeOptionalWriteable(minimumShouldMatchScript);
                    minimumShouldMatchScript = Script.parse(parser);
                currentFieldName = parser.currentName();
import org.apache.lucene.search.Query;
                    );
        if (minimumShouldMatchField != null) {
        if (token != XContentParser.Token.START_OBJECT) {
                    } else {
        }
                if (MINIMUM_SHOULD_MATCH_SCRIPT.match(currentFieldName, parser.getDeprecationHandler())) {
 * under the License.
 * software distributed under the License is distributed on an
        @Override
    }
 * not use this file except in compliance with the License.
 */
                    );
import org.opensearch.core.common.ParsingException;
    }
        @Override
        return this;
    @Override
        }
            Map<String, Object> params = new HashMap<>();
                        "[" + NAME + "] query does not support [" + currentFieldName + "]"
                    "[" + NAME + "] unknown token [" + token + "] after [" + currentFieldName + "]"
                }
        @Override
        builder.field(TERMS_FIELD.getPreferredName(), TermsQueryBuilder.convertBack(values));
            } else if (token.isValue()) {
     */
            TermsSetQueryScript script = leafFactory.newInstance(ctx);
                } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                    queryName = parser.text();
            && Objects.equals(values, other.values)
    public String getMinimumShouldMatchField() {
        }
            && Objects.equals(minimumShouldMatchScript, other.minimumShouldMatchScript);
                    }
                long current = -1;
     * Values Source for scripted long values
import org.opensearch.script.TermsSetQueryScript;
        return queryBuilder;
        }
                    values = TermsQueryBuilder.parseValues(parser);
}
        return this;
            return "script(" + script.toString() + ")";
        builder.endObject();
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.index.Term;
 * Query builder for terms_set queries
        return Objects.hash(fieldName, values, minimumShouldMatchField, minimumShouldMatchScript);
            }
            // TODO: Change this to true when we can assume that scripts are pure functions
            }
        out.writeGenericValue(values);
    // package protected for testing purpose
    private final List<?> values;
            return this;
    /**
        public String toString() {
            return this;
import java.io.IOException;
            throw new ParsingException(parser.getTokenLocation(), "[" + NAME + "] unknown token [" + token + "]");
            builder.field(MINIMUM_SHOULD_MATCH_SCRIPT.getPreferredName(), minimumShouldMatchScript);
            params.put("num_terms", values.size());
            this.fieldData = fieldData;
        public int hashCode() {
            this.script = script;
import java.util.ArrayList;
    /**
        out.writeOptionalString(minimumShouldMatchField);
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.core.ParseField;
    public static TermsSetQueryBuilder fromXContent(XContentParser parser) throws IOException {
        }
import java.util.Map;
    static final ParseField MINIMUM_SHOULD_MATCH_SCRIPT = new ParseField("minimum_should_match_script");
                }
                        current = values.nextValue();
    @Override
        this.minimumShouldMatchField = minimumShouldMatchField;
                if (TERMS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
import org.apache.lucene.search.IndexSearcher;
    }
    }
        public LongValuesSource rewrite(IndexSearcher searcher) throws IOException {
    @Override
import org.opensearch.script.Script;
            IndexNumericFieldData fieldData = context.getForField(msmFieldType);
        this.values = TermsQueryBuilder.convert(Objects.requireNonNull(values));
            if (obj == null || getClass() != obj.getClass()) {
        Script minimumShouldMatchScript = null;
            SortedNumericDocValues values = fieldData.load(ctx).getLongValues();
            MappedFieldType msmFieldType = context.fieldMapper(minimumShouldMatchField);
        if (token != XContentParser.Token.FIELD_NAME) {
    public TermsSetQueryBuilder setMinimumShouldMatchField(String minimumShouldMatchField) {
/**
        ScriptLongValueSource(Script script, TermsSetQueryScript.LeafFactory leafFactory) {
     */
        public LongValues getValues(LeafReaderContext ctx, DoubleValues scores) throws IOException {
     * @opensearch.internal
 *    http://www.apache.org/licenses/LICENSE-2.0
    protected void doWriteTo(StreamOutput out) throws IOException {
        LongValuesSource longValuesSource = createValuesSource(context);
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 */
        return minimumShouldMatchScript;
                } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    protected Query doToQuery(QueryShardContext context) {
     * doc values, because that is what is being used in NumberFieldMapper.
        builder.endObject();
import org.opensearch.index.fielddata.IndexNumericFieldData;
            // depend on the current timestamp, other documents, etc.
    }
            } else if (token == XContentParser.Token.START_OBJECT) {
 * specific language governing permissions and limitations
        printBoostAndQueryName(builder);
    String getFieldName() {
        private final String fieldName;
            && Objects.equals(minimumShouldMatchField, other.minimumShouldMatchField)
        token = parser.nextToken();
            return false;
    @Override
 * Modifications Copyright OpenSearch Contributors. See
    }
        @Override
import org.apache.lucene.search.LongValuesSource;
                    if (hasValue) {
            if (fieldType != null) {
    }
        @Override
        // Fail before we attempt to create the term queries:
        this.fieldName = Objects.requireNonNull(fieldName);
        public String toString() {
                } else {
import org.apache.lucene.index.SortedNumericDocValues;
            } else {
        }
        }
                    return script.execute() != null;
    }
    }
                }
    }
        }
import org.opensearch.core.xcontent.XContentParser;
                );
        @Override
                    throw new ParsingException(
    public static final String NAME = "terms_set";
            // ie. the return value is always the same given the same conditions and may not
    }
            builder.field(MINIMUM_SHOULD_MATCH_FIELD.getPreferredName(), minimumShouldMatchField);
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.sandbox.search.CoveringQuery;
        @Override
                }
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
 * Unless required by applicable law or agreed to in writing,
                @Override
    }
        }
            queryBuilder.setMinimumShouldMatchField(minimumShouldMatchField);
        for (Object value : values) {
    public String getWriteableName() {
        }
            return false;
 *
        }
        return values;
        if (values.size() > IndexSearcher.getMaxClauseCount()) {
            throw new IndexSearcher.TooManyClauses();
        if (token != XContentParser.Token.END_OBJECT) {
                    script.setDocument(doc);
        return new CoveringQuery(queries, longValuesSource);
                } else {
                }
                        assert values.docValueCount() == 1;
            TermsSetQueryScript.Factory factory = context.compile(minimumShouldMatchScript, TermsSetQueryScript.CONTEXT);
        }
        if (minimumShouldMatchField != null) {
 * this work for additional information regarding copyright
                        return true;
            };
            return new LongValues() {
     *
    static class FieldValuesSource extends LongValuesSource {
            return Objects.hash(fieldName);
        }
    }
                    boost = parser.floatValue();
     */
            throw new IllegalArgumentException("A field has already been specified. Cannot specify both a field and script");
    static final ParseField MINIMUM_SHOULD_MATCH_FIELD = new ParseField("minimum_should_match_field");
 *
                    parser.getTokenLocation(),
        @Override
                    );
 * @opensearch.internal
                    minimumShouldMatchField = parser.text();
                @Override
        String minimumShouldMatchField = null;
    private Script minimumShouldMatchScript;
        return NAME;
import org.opensearch.core.common.io.stream.StreamOutput;
     * @opensearch.internal
            int h = getClass().hashCode();
        }
        }
            queryBuilder.setMinimumShouldMatchScript(minimumShouldMatchScript);
                queries.add(fieldType.termQuery(value, context));
            return Objects.equals(fieldName, that.fieldName);
        private final Script script;
                @Override
        @Override
 * GitHub history for details.
import org.opensearch.common.lucene.BytesRefs;
 * Licensed to Elasticsearch under one or more contributor
            params.putAll(minimumShouldMatchScript.getParams());
 * the Apache License, Version 2.0 (the "License"); you may
    public List<?> getValues() {
        }
        }
    public TermsSetQueryBuilder setMinimumShouldMatchScript(Script minimumShouldMatchScript) {
        }
        public boolean equals(Object obj) {
import java.util.HashMap;
                public long longValue() throws IOException {
                throw new ParsingException(
            return new LongValues() {
        this.values = (List<?>) in.readGenericValue();
     * Forked from LongValuesSource.FieldValuesSource and changed getValues() method to always use sorted numeric
            }
import org.apache.lucene.search.DoubleValues;
    }
package org.opensearch.index.query;
                public boolean advanceExact(int doc) throws IOException {
        public boolean needsScores() {
        public int hashCode() {
        }
        public LongValues getValues(LeafReaderContext ctx, DoubleValues scores) throws IOException {
                        "[" + NAME + "] query does not support [" + currentFieldName + "]"
        }
 * license agreements. See the NOTICE file distributed with
        FieldValuesSource(IndexNumericFieldData fieldData) {
                    return script.runAsLong();
    }
            throw new IllegalArgumentException("A script has already been specified. Cannot specify both a field and script");
        public LongValuesSource rewrite(IndexSearcher searcher) throws IOException {
        }
                if (MINIMUM_SHOULD_MATCH_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                } else {
import org.opensearch.common.lucene.search.Queries;
        this.minimumShouldMatchField = in.readOptionalString();
    }
 * The OpenSearch Contributors require contributions made to
    }
        public boolean needsScores() {
        @Override
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
 * ownership. Elasticsearch licenses this file to you under
    @Override
    }
        builder.startObject(NAME);
            return Queries.newMatchNoDocsQuery("No terms supplied for \"" + getName() + "\" query.");
    @Override
        String fieldName = currentFieldName;
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            } else {
            FieldValuesSource that = (FieldValuesSource) o;
        XContentParser.Token token = parser.nextToken();
    /**
        }
        if (minimumShouldMatchScript != null) {
            if (this == o) return true;
        @Override
                    return current;
                        parser.getTokenLocation(),
    private final String fieldName;
import org.apache.lucene.index.LeafReaderContext;
import org.opensearch.index.mapper.MappedFieldType;
    public Script getMinimumShouldMatchScript() {
    public TermsSetQueryBuilder(StreamInput in) throws IOException {
 * compatible open source license.
        if (minimumShouldMatchField != null) {
        List<Object> values = new ArrayList<>();
        if (minimumShouldMatchScript != null) {
        private final TermsSetQueryScript.LeafFactory leafFactory;
            longValuesSource = new ScriptLongValueSource(minimumShouldMatchScript, factory.newFactory(params, context.lookup()));
        public boolean isCacheable(LeafReaderContext ctx) {
    public TermsSetQueryBuilder(String fieldName, List<?> values) {
        return Objects.equals(fieldName, other.fieldName)
/*
 *
    List<Query> createTermQueries(QueryShardContext context) {
        @Override
        }
    protected int doHashCode() {
        this.fieldName = in.readString();
                }
        @Override
                        parser.getTokenLocation(),
public final class TermsSetQueryBuilder extends AbstractQueryBuilder<TermsSetQueryBuilder> {
            if (token == XContentParser.Token.FIELD_NAME) {
            h = 31 * h + script.hashCode();
    private String minimumShouldMatchField;
        return longValuesSource;
