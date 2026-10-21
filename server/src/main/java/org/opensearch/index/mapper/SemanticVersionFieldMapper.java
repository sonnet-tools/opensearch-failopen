            fieldType.freeze();
        }
    public static final String NORMALIZED_FIELD_SUFFIX = "._normalized";
 *
     * Builder class for constructing the SemanticVersionFieldMapper.
                } else if (indexQuery != null) {
                    SemanticVersion upperVersion = SemanticVersion.parse(upperStr);
                }
        ) {
        }
                @Override
                    "Failed to create range query for field ["
            if (isSearchable) {
    }
            if (caseInsensitive) {
        if (fieldType().hasDocValues()) {
            context.doc().add(new KeywordField(fieldType().name() + NORMALIZED_FIELD_SUFFIX, normalizedValueBytes, Field.Store.NO));
                return new IndexOrDocValuesQuery(indexQuery, dvQuery);
        String normalizedValue = version.getNormalizedComparableString();
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
            Query indexQuery = isSearchable ? new org.apache.lucene.search.TermInSetQuery(name(), bytesList) : null;
import java.io.IOException;
            if (method == null) {
            try {
        String simpleName,
 * this file be licensed under the Apache-2.0 license or a
                method = MultiTermQuery.CONSTANT_SCORE_REWRITE;
    }
    public static final FieldType FIELD_TYPE = new FieldType();
                }
            Fuzziness fuzziness,
            QueryShardContext context
                throw new QueryShardException(
            List<BytesRef> bytesList = new ArrayList<>();
import java.util.List;
import org.apache.lucene.document.KeywordField;
            int maxExpansions,
            int prefixLength,
    /**
                    prefixLength,
        public Query termsQuery(List<?> values, QueryShardContext context) {
import org.apache.lucene.document.SortedSetDocValuesField;
 */
                    return new IndexOrDocValuesQuery(indexQuery, dvQuery);
            parameters.add(hasDocValues);
        public Query termQuery(Object value, QueryShardContext context) {
        }
                throw new IllegalArgumentException("Field [" + name() + "] does not have doc_values enabled");
            int matchFlags,
            super(name);
        }
            int syntaxFlags,
            fieldType.setDocValuesType(hasDocValues.getValue() ? DocValuesType.SORTED_SET : DocValuesType.NONE);
import java.util.Locale;
import org.apache.lucene.util.BytesRef;
        public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {
     */
                value = value.toLowerCase(Locale.ROOT);
            boolean isSearchable,
        SemanticVersion version = SemanticVersion.parse(value);
        @Override
        BytesRef bytes = new BytesRef(versionString);
            } else if (indexQuery != null) {
            Query dvQuery = hasDocValues ? SortedSetDocValuesField.newSlowSetQuery(normalizedFieldName, bytesList) : null;
                return dvQuery;
        @Override
        public String typeName() {
import java.util.ArrayList;
        }
            parameters.add(indexed);
            return meta;
            return parameters;
import org.opensearch.index.fielddata.IndexFieldData;
        }
                    return value.toString();
            return CONTENT_TYPE;
                    method
                    fuzziness.asDistance(),
                    meta.getValue(),
            this.isStored = isStored;
                    : null;
            boolean isStored
import org.apache.lucene.search.FuzzyQuery;
                    new Term(name(), indexedValueForSearch(value)),
        public Query fuzzyQuery(
                );
            } else if (dvQuery != null) {
     * @opensearch.internal
            }
        public Query prefixQuery(String value, MultiTermQuery.RewriteMethod method, boolean caseInsensitive, QueryShardContext context) {
                    indexed.getValue(),
            if (format != null) {
            }
                    buildFullName(context),
            }
            }
        FIELD_TYPE.freeze();
    public static class SemanticVersionFieldType extends TermBasedFieldType {
            context.doc().add(new KeywordField(fieldType().name(), bytes, this.fieldType.stored() ? Field.Store.YES : Field.Store.NO));
                protected String parseSourceValue(Object value) {
                    stored.getValue()
                } else if (dvQuery != null) {
                        + name()
            if (isSearchable) {
                    maxExpansions,
            } catch (Exception e) {
            }
/**
        @Override
                        + "]. Lower term: ["
                    maxDeterminizedStates,
        Map<String, String> meta
        private static SemanticVersionFieldType toType(FieldMapper m) {
        public Query wildcardQuery(String value, MultiTermQuery.RewriteMethod method, boolean caseInsensitive, QueryShardContext context) {
        // For range queries and sorting: use normalized form
                    return indexQuery;
                return new FuzzyQuery(
            BytesRef bytes = value instanceof BytesRef ? (BytesRef) value : new BytesRef(value.toString());
        private final String normalizedFieldName;
            MultiTermQuery.RewriteMethod method,
            for (Object value : values) {
import org.apache.lucene.search.PrefixQuery;
            } else if (dvQuery != null) {
    /**
        if (value == null) {
                throw new IllegalArgumentException("Field [" + name() + "] is neither indexed nor has doc_values enabled");
package org.opensearch.index.mapper;
import org.apache.lucene.index.IndexOptions;
     *
    }
        ) {
            if (indexQuery != null && dvQuery != null) {
                    method
                method = MultiTermQuery.CONSTANT_SCORE_REWRITE;
        if (fieldType().hasDocValues() || fieldType().isSearchable()) {
        if (fieldType().isStored()) {
        return CONTENT_TYPE;
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
        FIELD_TYPE.setDocValuesType(DocValuesType.SORTED_SET);
        }
    }
        protected List<Parameter<?>> getParameters() {
import org.apache.lucene.util.automaton.Operations;
                Query indexQuery = isSearchable ? new TermRangeQuery(normalizedFieldName, lower, upper, includeLower, includeUpper) : null;
                    matchFlags,
            }
                if (lowerTerm != null) {
                );
                    String upperStr = (upperTerm instanceof BytesRef) ? ((BytesRef) upperTerm).utf8ToString() : upperTerm.toString();
import org.apache.lucene.search.IndexOrDocValuesQuery;
        private final Parameter<Boolean> indexed = Parameter.indexParam(m -> toType(m).isSearchable, true).alwaysSerialize();
            }
            boolean hasDocValues,
        @Override
            parameters.add(stored);
import org.apache.lucene.search.RegexpQuery;
    @Override
import org.opensearch.common.unit.Fuzziness;
        }
            }
        public Query regexpQuery(
    private final Map<String, String> meta;
        this.meta = meta;
        @Override
                        + "], Upper term: ["
            return new SortedSetOrdinalsIndexFieldData.Builder(normalizedFieldName, CoreValuesSourceType.BYTES);
        private final boolean isSearchable;
/*
                if (indexQuery != null && dvQuery != null) {
            context.doc().add(new StoredField(fieldType().name(), versionString));
            }
    }
        public Map<String, String> meta() {
        ) {
        @Override
                copyTo.build(),
import org.opensearch.core.xcontent.XContentBuilder;
                return dvQuery;
        Builder builder = new Builder(name());
        }
                return new IndexOrDocValuesQuery(indexQuery, dvQuery);
                }
        }
    protected String contentType() {
            Query indexQuery = isSearchable ? new TermQuery(new Term(name(), bytes)) : null;
        }
            this.normalizedFieldName = name + NORMALIZED_FIELD_SUFFIX;
        private final Parameter<Map<String, String>> meta = Parameter.metaParam();
            }
import java.util.function.Supplier;
            if (value == null) {
                fieldType,
                return indexQuery;
        return builder;
        // For searching (term queries): use original version string
            } else {
            FieldType fieldType = new FieldType();
        BytesRef normalizedValueBytes = new BytesRef(normalizedValue);
 * A field mapper for a semantic version field
                    return dvQuery;
        super(simpleName, mappedFieldType, multiFields, copyTo);
                return new PrefixQuery(new Term(name(), indexedValueForSearch(value)), method);
            );
        }
    protected SemanticVersionFieldMapper(
                    lower = new BytesRef(lowerVersion.getNormalizedComparableString());
            MultiTermQuery.RewriteMethod method,
    @Override
    public static final TypeParser PARSER = new TypeParser((n, c) -> new Builder(n));
            this.meta = meta;
import org.apache.lucene.document.FieldType;
     * The specific field type for SemanticVersionFieldMapper
        private final Map<String, String> meta;
        FIELD_TYPE.setStored(false);
                    ? SortedSetDocValuesField.newSlowRangeQuery(normalizedFieldName, lower, upper, includeLower, includeUpper)
            return (SemanticVersionFieldType) ((ParametrizedFieldMapper) m).mappedFieldType;
import org.apache.lucene.search.TermQuery;
            if (indexQuery != null && dvQuery != null) {
                    throw new IllegalArgumentException("Field [" + name() + "] is neither indexed nor has doc_values enabled");
        String versionString = version.toString();
 * The OpenSearch Contributors require contributions made to
        builder.init(this);
            fieldType.setIndexOptions(indexed.getValue() ? IndexOptions.DOCS : IndexOptions.NONE);
            this.isSearchable = isSearchable;
import org.opensearch.search.lookup.SearchLookup;
    public static class Builder extends ParametrizedFieldMapper.Builder {
    ) {
            super(name, isSearchable, isStored, hasDocValues, TextSearchInfo.SIMPLE_MATCH_ONLY, meta);
    protected void parseCreateField(ParseContext context) throws IOException {
        @Override
        }
    @Override
            String name,
}
                throw new IllegalArgumentException("Prefix queries require the field to be indexed");
        }
        String value = context.parser().textOrNull();
                        + "]"
            if (isSearchable) {
        }
        @Override
                BytesRef upper = null;
        }
            fieldType.setTokenized(false);
                multiFieldsBuilder.build(this, context),
            }
                );
            } else if (indexQuery != null) {
        // For retrieval: store original version string
        private final boolean hasDocValues;
                    context,
                new SemanticVersionFieldType(
import org.opensearch.index.query.QueryShardException;
                throw new IllegalArgumentException("Regexp queries require the field to be indexed");
            }
            Map<String, String> meta,
                throw new IllegalArgumentException("Cannot search for null value");
import org.apache.lucene.search.TermRangeQuery;
                    RegexpQuery.DEFAULT_PROVIDER,
            return;
            }
            boolean transpositions,
                Query dvQuery = hasDocValues
                    String lowerStr = (lowerTerm instanceof BytesRef) ? ((BytesRef) lowerTerm).utf8ToString() : lowerTerm.toString();
    }
import org.apache.lucene.search.Query;
    }
        super.doXContentBody(builder, includeDefaults, params);
        FIELD_TYPE.setIndexOptions(IndexOptions.DOCS);
            if (isSearchable) {
        private final Parameter<Boolean> stored = Parameter.storeParam(m -> toType(m).isStored, false);
            } else {
        @Override
                    transpositions,
 * compatible open source license.
import org.apache.lucene.index.Term;
    static {
        }
            this.hasDocValues = hasDocValues;
     */
            } else {
                bytesList.add(value instanceof BytesRef ? (BytesRef) value : new BytesRef(value.toString()));
 * SPDX-License-Identifier: Apache-2.0
            context.doc().add(new SortedSetDocValuesField(fieldType().name() + NORMALIZED_FIELD_SUFFIX, normalizedValueBytes));
            } else {
            Object value,
                BytesRef lower = null;
        }
        MultiFields multiFields,
            List<Parameter<?>> parameters = new ArrayList<>();
                } else {
        public Builder(String name) {
            } else {
        @Override
            parameters.add(meta);
import org.opensearch.index.query.QueryShardContext;
            QueryShardContext context
                        + (upperTerm != null ? upperTerm.toString() : "null")
import org.apache.lucene.search.MultiTermQuery;
import org.apache.lucene.search.WildcardQuery;
        public SemanticVersionFieldType(
import org.opensearch.index.fielddata.plain.SortedSetOrdinalsIndexFieldData;
        private final Parameter<Boolean> hasDocValues = Parameter.docValuesParam(m -> toType(m).hasDocValues, true);
        private final boolean isStored;
        }
            }
        @Override
                if (upperTerm != null) {
    protected void doXContentBody(XContentBuilder builder, boolean includeDefaults, Params params) throws IOException {
    @Override
import org.apache.lucene.index.DocValuesType;
import java.util.Map;
                throw new IllegalArgumentException("Field [" + name() + "] of type [" + typeName() + "] doesn't support formats.");
                }
        public SemanticVersionFieldMapper build(BuilderContext context) {
    public ParametrizedFieldMapper.Builder getMergeBuilder() {
            if (method == null) {
        @Override
            Query dvQuery = hasDocValues ? SortedSetDocValuesField.newSlowExactQuery(normalizedFieldName, bytes) : null;
    public static final String CONTENT_TYPE = "version";
import org.apache.lucene.document.StoredField;
        }
        CopyTo copyTo,
                    SemanticVersion lowerVersion = SemanticVersion.parse(lowerStr);
    }
        MappedFieldType mappedFieldType,
            fieldType.setStored(stored.getValue());
                method = MultiTermQuery.CONSTANT_SCORE_REWRITE;
                    syntaxFlags,
        }
import org.apache.lucene.document.Field;
                    new Term(name(), indexedValueForSearch(value)),
        @Override
                return new RegexpQuery(
                ),
            };
                throw new IllegalArgumentException("Fuzzy queries require the field to be indexed");
                    hasDocValues.getValue(),
            if (method == null) {
                meta.getValue()
                throw new IllegalArgumentException("Field [" + name() + "] is neither indexed nor has doc_values enabled");
            String value,
                        + (lowerTerm != null ? lowerTerm.toString() : "null")
 *
public class SemanticVersionFieldMapper extends ParametrizedFieldMapper {
                return indexQuery;
            } else {
                name,
        public Query rangeQuery(Object lowerTerm, Object upperTerm, boolean includeLower, boolean includeUpper, QueryShardContext context) {
                return new WildcardQuery(new Term(name(), indexedValueForSearch(value)), Operations.DEFAULT_DETERMINIZE_WORK_LIMIT);
 */
        FieldType fieldType,
                throw new IllegalArgumentException("Wildcard queries require the field to be indexed");
        if (fieldType().isSearchable()) {
                    upper = new BytesRef(upperVersion.getNormalizedComparableString());
            int maxDeterminizedStates,
            if (!hasDocValues) {
            return new SemanticVersionFieldMapper(
        FIELD_TYPE.setTokenized(false);
            }
            return new SourceValueFetcher(name(), context, format) {
