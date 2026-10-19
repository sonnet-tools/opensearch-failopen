            int prefixLength,
        FieldType fieldType,  
                    stored.getValue()
        FIELD_TYPE.setStored(false);
        // For range queries and sorting: use normalized form
            }
            MultiTermQuery.RewriteMethod method,
            try {
        Map<String, String> meta
                throw new IllegalArgumentException("Field [" + name() + "] is neither indexed nor has doc_values enabled");
import org.apache.lucene.util.automaton.Operations;
        private final String normalizedFieldName;
                    String lowerStr = (lowerTerm instanceof BytesRef) ? ((BytesRef) lowerTerm).utf8ToString() : lowerTerm.toString();  
                    buildFullName(context),  
            context.doc().add(new KeywordField(fieldType().name(), bytes, this.fieldType.stored() ? Field.Store.YES : Field.Store.NO));
import org.apache.lucene.search.TermQuery;  
        public Query rangeQuery(Object lowerTerm, Object upperTerm, boolean includeLower, boolean includeUpper, QueryShardContext context) {
            }  
    /**  
                return new PrefixQuery(new Term(name(), indexedValueForSearch(value)), method);  
            if (isSearchable) {
            fieldType.setIndexOptions(indexed.getValue() ? IndexOptions.DOCS : IndexOptions.NONE);
                    prefixLength,
                    matchFlags,
     *
                BytesRef lower = null;  
                return dvQuery;
import org.apache.lucene.document.KeywordField;  
                } else if (indexQuery != null) {  
        BytesRef bytes = new BytesRef(versionString);
 * A field mapper for a semantic version field
        MultiFields multiFields,
            context.doc().add(new KeywordField(fieldType().name() + NORMALIZED_FIELD_SUFFIX, normalizedValueBytes, Field.Store.NO));
        @Override
        }
                }
        public SemanticVersionFieldType(  
            String value,  
        super(simpleName, mappedFieldType, multiFields, copyTo);  
import org.apache.lucene.document.FieldType;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.query.QueryShardContext;  
            if (value == null) {
    }
            }  
            } else {
                if (upperTerm != null) {
            }
                        + name()
                }  
        super.doXContentBody(builder, includeDefaults, params);  
    public static final String CONTENT_TYPE = "version";
        }  
            fieldType.freeze();
            parameters.add(hasDocValues);  
 * SPDX-License-Identifier: Apache-2.0
            QueryShardContext context
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
            parameters.add(meta);
                return new RegexpQuery(
    protected String contentType() {
        SemanticVersion version = SemanticVersion.parse(value);
                );
    @Override
            context.doc().add(new SortedSetDocValuesField(fieldType().name() + NORMALIZED_FIELD_SUFFIX, normalizedValueBytes));
                new SemanticVersionFieldType(
        }
                return indexQuery;
    }
        this.meta = meta;
            return meta;
        private final Parameter<Boolean> hasDocValues = Parameter.docValuesParam(m -> toType(m).hasDocValues, true);  
        public String typeName() {
                    String upperStr = (upperTerm instanceof BytesRef) ? ((BytesRef) upperTerm).utf8ToString() : upperTerm.toString();
            if (caseInsensitive) {
 */  
                throw new IllegalArgumentException("Cannot search for null value");
 *
                throw new IllegalArgumentException("Regexp queries require the field to be indexed");
    public static class Builder extends ParametrizedFieldMapper.Builder {  
        public Query termQuery(Object value, QueryShardContext context) {  
            return CONTENT_TYPE;
        }
        }
                throw new IllegalArgumentException("Wildcard queries require the field to be indexed");
import org.apache.lucene.document.StoredField;
                } else if (dvQuery != null) {
        private final Parameter<Boolean> stored = Parameter.storeParam(m -> toType(m).isStored, false);
import java.io.IOException;
        String normalizedValue = version.getNormalizedComparableString();  
    }
            MultiTermQuery.RewriteMethod method,
    }  
        }
                throw new IllegalArgumentException("Field [" + name() + "] is neither indexed nor has doc_values enabled");  
import org.apache.lucene.search.MultiTermQuery;
        }
        @Override  
    public static final FieldType FIELD_TYPE = new FieldType();  
import org.apache.lucene.search.RegexpQuery;
        // For retrieval: store original version string
                    syntaxFlags,
import org.apache.lucene.index.DocValuesType;  
        }
        // For searching (term queries): use original version string  
    protected void doXContentBody(XContentBuilder builder, boolean includeDefaults, Params params) throws IOException {
            int matchFlags,
                method = MultiTermQuery.CONSTANT_SCORE_REWRITE;
            if (method == null) {
}
        }
        @Override
    }  
        BytesRef normalizedValueBytes = new BytesRef(normalizedValue);
    private final Map<String, String> meta;
import org.opensearch.core.xcontent.XContentBuilder;  
                    upper = new BytesRef(upperVersion.getNormalizedComparableString());
    @Override
            boolean hasDocValues,
    protected void parseCreateField(ParseContext context) throws IOException {
        FIELD_TYPE.setTokenized(false);
                    throw new IllegalArgumentException("Field [" + name() + "] is neither indexed nor has doc_values enabled");
                    : null;  
                    maxExpansions,  
        private final boolean isStored;
                BytesRef upper = null;
        }  
import java.util.Map;  
        builder.init(this);
                @Override  
        }
                method = MultiTermQuery.CONSTANT_SCORE_REWRITE;  
                }  
            return new SemanticVersionFieldMapper(
     * Builder class for constructing the SemanticVersionFieldMapper.
    }
                Query dvQuery = hasDocValues
import org.opensearch.index.fielddata.plain.SortedSetOrdinalsIndexFieldData;
    @Override  
        ) {  
                meta.getValue()
                throw new IllegalArgumentException("Field [" + name() + "] of type [" + typeName() + "] doesn't support formats.");  
                return new IndexOrDocValuesQuery(indexQuery, dvQuery);
            } else if (indexQuery != null) {
            Fuzziness fuzziness,  
            } else if (indexQuery != null) {  
                        + (upperTerm != null ? upperTerm.toString() : "null")  
                    transpositions,
            Query dvQuery = hasDocValues ? SortedSetDocValuesField.newSlowSetQuery(normalizedFieldName, bytesList) : null;
                        + "]. Lower term: ["  
            } else {
            int maxExpansions,
    static {  
        @Override  
 */  
        }
            int maxDeterminizedStates,  
            if (format != null) {
     * The specific field type for SemanticVersionFieldMapper
                return new IndexOrDocValuesQuery(indexQuery, dvQuery);  
import org.opensearch.index.fielddata.IndexFieldData;
                    meta.getValue(),
        public Query termsQuery(List<?> values, QueryShardContext context) {
import java.util.Locale;
            return new SortedSetOrdinalsIndexFieldData.Builder(normalizedFieldName, CoreValuesSourceType.BYTES);  
                    SemanticVersion upperVersion = SemanticVersion.parse(upperStr);  
        private final Parameter<Map<String, String>> meta = Parameter.metaParam();
                    RegexpQuery.DEFAULT_PROVIDER,  
        String versionString = version.toString();
        return CONTENT_TYPE;
            } else if (dvQuery != null) {  
            } else {
                multiFieldsBuilder.build(this, context),  
            if (method == null) {
            boolean isSearchable,  
                return new WildcardQuery(new Term(name(), indexedValueForSearch(value)), Operations.DEFAULT_DETERMINIZE_WORK_LIMIT);  
            this.hasDocValues = hasDocValues;
            }  
        public Map<String, String> meta() {
            for (Object value : values) {  
import org.apache.lucene.document.SortedSetDocValuesField;
        }
                ),
    /**  
            }  
        @Override  
        public Query regexpQuery(
            } else {
        @Override  
package org.opensearch.index.mapper;
                    return new IndexOrDocValuesQuery(indexQuery, dvQuery);
        public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {
    public static final TypeParser PARSER = new TypeParser((n, c) -> new Builder(n));
            List<Parameter<?>> parameters = new ArrayList<>();
        public Query wildcardQuery(String value, MultiTermQuery.RewriteMethod method, boolean caseInsensitive, QueryShardContext context) {
import org.apache.lucene.document.Field;
                    lower = new BytesRef(lowerVersion.getNormalizedComparableString());
            if (!hasDocValues) {  
        @Override  
            int syntaxFlags,
        @Override  
import java.util.function.Supplier;
        FIELD_TYPE.setIndexOptions(IndexOptions.DOCS);  
            if (isSearchable) {
                    maxDeterminizedStates,
            this.normalizedFieldName = name + NORMALIZED_FIELD_SUFFIX;  
            }
                    indexed.getValue(),
            }
        public Builder(String name) {
        }
            Query dvQuery = hasDocValues ? SortedSetDocValuesField.newSlowExactQuery(normalizedFieldName, bytes) : null;  
        MappedFieldType mappedFieldType,
            super(name);
            this.isSearchable = isSearchable;
 *
            } catch (Exception e) {
 * The OpenSearch Contributors require contributions made to  
     * @opensearch.internal  
        }
    @Override  
            return (SemanticVersionFieldType) ((ParametrizedFieldMapper) m).mappedFieldType;
            boolean transpositions,  
        private final Map<String, String> meta;  
            Query indexQuery = isSearchable ? new TermQuery(new Term(name(), bytes)) : null;
            return parameters;  
        }
import org.opensearch.common.unit.Fuzziness;
                throw new QueryShardException(
            QueryShardContext context
import org.apache.lucene.search.FuzzyQuery;  
            Query indexQuery = isSearchable ? new org.apache.lucene.search.TermInSetQuery(name(), bytesList) : null;  
            return new SourceValueFetcher(name(), context, format) {
import org.apache.lucene.search.WildcardQuery;
                        + (lowerTerm != null ? lowerTerm.toString() : "null")
        private static SemanticVersionFieldType toType(FieldMapper m) {  
            } else if (dvQuery != null) {
        public Query prefixQuery(String value, MultiTermQuery.RewriteMethod method, boolean caseInsensitive, QueryShardContext context) {
    public static final String NORMALIZED_FIELD_SUFFIX = "._normalized";
                bytesList.add(value instanceof BytesRef ? (BytesRef) value : new BytesRef(value.toString()));
     */
            fieldType.setTokenized(false);  
/*  
                } else {
import org.apache.lucene.search.Query;
    }  
                    method
                    return indexQuery;
            context.doc().add(new StoredField(fieldType().name(), versionString));  
        String value = context.parser().textOrNull();
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
            }  
        if (fieldType().hasDocValues()) {  
import java.util.List;
                );  
/**  
    public ParametrizedFieldMapper.Builder getMergeBuilder() {  
            BytesRef bytes = value instanceof BytesRef ? (BytesRef) value : new BytesRef(value.toString());
        if (fieldType().isSearchable()) {
        @Override  
        ) {  
                    new Term(name(), indexedValueForSearch(value)),  
                        + "]"
                fieldType,
            }  
        private final Parameter<Boolean> indexed = Parameter.indexParam(m -> toType(m).isSearchable, true).alwaysSerialize();
                protected String parseSourceValue(Object value) {
            List<BytesRef> bytesList = new ArrayList<>();
import org.apache.lucene.index.IndexOptions;
            }
    protected SemanticVersionFieldMapper(
                name,  
        return builder;  
                throw new IllegalArgumentException("Fuzzy queries require the field to be indexed");
            Map<String, String> meta,
        }
            }  
    public static class SemanticVersionFieldType extends TermBasedFieldType {
                }  
        @Override
            if (indexQuery != null && dvQuery != null) {
                return dvQuery;  
import org.opensearch.search.lookup.SearchLookup;  
                Query indexQuery = isSearchable ? new TermRangeQuery(normalizedFieldName, lower, upper, includeLower, includeUpper) : null;  
                    hasDocValues.getValue(),  
        if (value == null) {  
        }  
                copyTo.build(),
        if (fieldType().hasDocValues() || fieldType().isSearchable()) {  
                return new FuzzyQuery(
                method = MultiTermQuery.CONSTANT_SCORE_REWRITE;
                    "Failed to create range query for field ["
import org.apache.lucene.search.PrefixQuery;  
            }  
        @Override  
                );  
            if (method == null) {
        private final boolean hasDocValues;  
        @Override  
                    return value.toString();
            parameters.add(stored);
import org.apache.lucene.index.Term;
            String name,
            this.meta = meta;
                return indexQuery;
                    ? SortedSetDocValuesField.newSlowRangeQuery(normalizedFieldName, lower, upper, includeLower, includeUpper)
import java.util.ArrayList;  
                        + "], Upper term: ["
            super(name, isSearchable, isStored, hasDocValues, TextSearchInfo.SIMPLE_MATCH_ONLY, meta);
        ) {  
            );  
            fieldType.setDocValuesType(hasDocValues.getValue() ? DocValuesType.SORTED_SET : DocValuesType.NONE);  
    }
        FIELD_TYPE.setDocValuesType(DocValuesType.SORTED_SET);
        public SemanticVersionFieldMapper build(BuilderContext context) {
            if (isSearchable) {
        }  
            FieldType fieldType = new FieldType();
                throw new IllegalArgumentException("Prefix queries require the field to be indexed");
        Builder builder = new Builder(name());
import org.apache.lucene.search.IndexOrDocValuesQuery;
                    return dvQuery;  
        CopyTo copyTo,  
            fieldType.setStored(stored.getValue());
            }
                    SemanticVersion lowerVersion = SemanticVersion.parse(lowerStr);
        String simpleName,
        FIELD_TYPE.freeze();
            if (isSearchable) {
                    fuzziness.asDistance(),
 * compatible open source license.
import org.apache.lucene.search.TermRangeQuery;
            parameters.add(indexed);
import org.opensearch.index.query.QueryShardException;
        if (fieldType().isStored()) {
            if (indexQuery != null && dvQuery != null) {
        @Override
        }
                if (indexQuery != null && dvQuery != null) {
        }
                    context,  
            };
                    method
            boolean isStored
        private final boolean isSearchable;
        protected List<Parameter<?>> getParameters() {  
            }  
import org.apache.lucene.util.BytesRef;  
public class SemanticVersionFieldMapper extends ParametrizedFieldMapper {
     */
            Object value,
                throw new IllegalArgumentException("Field [" + name() + "] does not have doc_values enabled");
                    new Term(name(), indexedValueForSearch(value)),  
                value = value.toLowerCase(Locale.ROOT);  
            return;
    ) {
                if (lowerTerm != null) {
            } else {
        public Query fuzzyQuery(
            this.isStored = isStored;  
            } else {
