    }
            boolean includeLower,
        public Mapper.Builder parse(String name, Map<String, Object> node, ParserContext parserContext) throws MapperParsingException {
                regExp.toAutomaton(RegexpQuery.DEFAULT_PROVIDER),
            if (lowerTerm != null && upperTerm != null && ((String) lowerTerm).compareTo((String) upperTerm) > 0) {
     * @opensearch.internal
        @Override
    private static ConstantKeywordFieldMapper toType(FieldMapper in) {
import org.apache.lucene.util.BytesRef;
    @Override
            return new SourceValueFetcher(name(), context) {
        public Builder(String name, String value) {
            value = context.parser().textOrNull();
                return new MatchAllDocsQuery();
import org.apache.lucene.util.automaton.ByteRunAutomaton;
            ShapeRelation relation,
                }
            int matchFlags,
     */
 * this file be licensed under the Apache-2.0 license or a
            super(name, Collections.emptyMap());
        }
        }
     * A {@link Mapper.TypeParser} for the constant keyword field.
            );
            throw new UnsupportedOperationException("Unable to derive source for fields with copy_to parameter set");
            DateMathParser parser,
        @Override
        final String value;
            int syntaxFlags,
        }
            QueryShardContext context
        return new ConstantKeywordFieldMapper.Builder(simpleName(), this.value).init(this);
            }
        }
        validateConstantValue(context);
        }
            super(name);
            }
     * Field type for Index field mapper
import java.util.Collections;
import org.opensearch.index.fielddata.plain.ConstantIndexFieldData;
    @Override
    }
            if (upperTerm != null) {
    @Override
 *
    public static class TypeParser implements Mapper.TypeParser {
        MappedFieldType mappedFieldType,
            boolean includeUpper,
    protected ConstantKeywordFieldMapper(
            }
            int maxDeterminizedStates,
                return new MatchNoDocsQuery();
    public ParametrizedFieldMapper.Builder getMergeBuilder() {
import org.apache.lucene.search.MultiTermQuery;
     *       return the same.
            }
        return (ConstantKeywordFieldMapper.ConstantKeywordFieldType) super.fieldType();
import java.util.function.Supplier;
            if (!node.containsKey(valuePropertyName)) {
import org.opensearch.index.query.QueryShardContext;
@PublicApi(since = "2.14.0")
    protected void parseCreateField(ParseContext context) throws IOException {
    private final String value;
            return new ConstantIndexFieldData.Builder(fullyQualifiedIndexName, name(), CoreValuesSourceType.BYTES);
package org.opensearch.index.mapper;
        }
        }
                    return Collections.singletonList(keywordValue);
            final RegExp regExp = new RegExp(value, syntaxFlags, matchFlags);
                    String keywordValue = value.toString();
}
            builder.field(name(), value);
    }
     * @opensearch.internal
/*
            );
        if (value == null) {
        String simpleName,
    ) {
/**
public class ConstantKeywordFieldMapper extends ParametrizedFieldMapper {
    /**
        public ConstantKeywordFieldMapper build(BuilderContext context) {
    }
    }
    }
        }
    protected String contentType() {
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
        ConstantKeywordFieldMapper.Builder builder
import org.apache.lucene.util.automaton.Automaton;
            if (upperTerm != null && ((String) upperTerm).compareTo(value) < (includeUpper ? 0 : 1)) {
    }
     * <p>
            final Automaton automaton = Operations.determinize(
    @PublicApi(since = "2.14.0")
                this
import org.opensearch.OpenSearchParseException;
    /**
    }
import org.opensearch.common.lucene.BytesRefs;
        }
            String value,
                copyTo.build(),
import org.apache.lucene.util.automaton.RegExp;
                throw new OpenSearchParseException("Field [" + name + "] is expected to be a string value");
        }
import org.opensearch.common.geo.ShapeRelation;
            @Nullable MultiTermQuery.RewriteMethod method,
 * The OpenSearch Contributors require contributions made to
        @Override
        if (value != null) {
            return new ConstantKeywordFieldMapper(
                return new MatchNoDocsQuery();
        @Override
        protected boolean matches(String pattern, boolean caseInsensitive, QueryShardContext context) {
            this.value = value;
            if (lowerTerm != null) {
        return (ConstantKeywordFieldMapper) in;
            return Arrays.asList(value);
    public static final String CONTENT_TYPE = "constant_keyword";
        super(simpleName, mappedFieldType, multiFields, copyTo);
 * SPDX-License-Identifier: Apache-2.0
    @Override
            ZoneId timeZone,
                lowerTerm = valueToString(lowerTerm);
            value = context.externalValue().toString();
            BytesRef valueBytes = BytesRefs.toBytesRef(this.value);
                name,
     */
        @Override
        validateConstantValue(context);
                throw new IllegalArgumentException("Field [" + name() + "] of type [" + typeName() + "] doesn't " + "support formats.");
    }
            }
                multiFieldsBuilder.build(this, context),
import java.util.Map;
import org.apache.lucene.search.RegexpQuery;
    }
    private static final String valuePropertyName = "value";
            Object upperTerm,
        }
 * compatible open source license.
        return CONTENT_TYPE;
                new ConstantKeywordFieldMapper.ConstantKeywordFieldType(buildFullName(context), value.getValue()),
import org.opensearch.core.xcontent.XContentBuilder;
            ByteRunAutomaton byteRunAutomaton = new ByteRunAutomaton(automaton);
import org.apache.lucene.search.MatchNoDocsQuery;
     * Builder for the binary field mapper
                return new MatchNoDocsQuery();
     *
        private final Parameter<String> value = Parameter.stringParam(valuePropertyName, false, m -> toType(m).value, null);
    public ConstantKeywordFieldMapper.ConstantKeywordFieldType fieldType() {
        public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {
    public static class Builder extends ParametrizedFieldMapper.Builder {
        this.value = builder.value.getValue();
import org.apache.lucene.util.automaton.Operations;
import org.apache.lucene.search.MatchAllDocsQuery;
import org.apache.lucene.search.Query;
            };
            if (lowerTerm != null && ((String) lowerTerm).compareTo(value) > (includeLower ? 0 : -1)) {
            return Regex.simpleMatch(pattern, value, caseInsensitive);
            if (!(value instanceof String)) {
                @Override
        @Override
                upperTerm = valueToString(upperTerm);
                protected Object parseSourceValue(Object value) {
        protected final String value;
import java.io.IOException;
            return new MatchAllDocsQuery();
            Object value = node.remove(valuePropertyName);
    }
import java.util.Arrays;
        ) {
            }
        @Override
            this.value.setValue(value);
import org.opensearch.common.Nullable;
        }
    @Override
 * Index specific field mapper
            }
        }
        }
                return new MatchNoDocsQuery();
    public void deriveSource(XContentBuilder builder, LeafReader leafReader, int docId) throws IOException {
        @Override
import org.opensearch.common.time.DateMathParser;
 */
 */
     *
        public ConstantKeywordFieldType(String name, String value) {
    }
        public Query existsQuery(QueryShardContext context) {
        MultiFields multiFields,
    }
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
            throw new IllegalArgumentException("constant keyword field [" + name() + "] must have a value of [" + this.value + "]");
import org.opensearch.search.lookup.SearchLookup;
        public Query regexpQuery(
        } else {
    private void validateConstantValue(ParseContext context) throws IOException {
import org.opensearch.common.annotation.PublicApi;
            return FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH;
        protected FieldTypeCapabilities.Capability searchCapability() {
        }
        public List<Parameter<?>> getParameters() {
                throw new OpenSearchParseException("Field [" + name + "] is missing required parameter [value]");
import java.time.ZoneId;
            if (byteRunAutomaton.run(valueBytes.bytes, valueBytes.offset, valueBytes.length)) {
     * Note: Doc for which, field in absent, deriveSource will still consider the still to be present, and it will
        }
            return new Builder(name, (String) value);
import java.util.List;
        public Query rangeQuery(
            if (format != null) {
    protected static final class ConstantKeywordFieldType extends ConstantFieldType {
    @Override
            return new MatchAllDocsQuery();
    /**
        @Override
     * @opensearch.internal
    /**
        if (!value.equals(fieldType().value)) {
        CopyTo copyTo,
 * @opensearch.api
        }
        if (context.externalValueSet()) {
import org.opensearch.common.regex.Regex;
            }
            } else {
            }
import org.apache.lucene.index.LeafReader;
        @Override
        }
 *
     * For each doc, it will return constant value defined in field mapping
            Object lowerTerm,
     */
    protected void parseCreateFieldForPluggableFormat(ParseContext context) throws IOException {
     */
            QueryShardContext context
     *
        if (this.copyTo() != null && !this.copyTo().copyToFields().isEmpty()) {
                Operations.DEFAULT_DETERMINIZE_WORK_LIMIT
    public void canDeriveSource() {
        @Override
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
            throw new IllegalArgumentException("constant keyword field [" + name() + "] must have a value");
        public String typeName() {
        ) {
            return CONTENT_TYPE;
import org.opensearch.index.fielddata.IndexFieldData;
