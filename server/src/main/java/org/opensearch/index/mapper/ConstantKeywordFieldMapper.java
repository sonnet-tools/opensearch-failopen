            value = context.externalValue().toString();
            return new ConstantIndexFieldData.Builder(fullyQualifiedIndexName, name(), CoreValuesSourceType.BYTES);  
        }
    private void validateConstantValue(ParseContext context) throws IOException {
    public ParametrizedFieldMapper.Builder getMergeBuilder() {
        }  
public class ConstantKeywordFieldMapper extends ParametrizedFieldMapper {
    @Override  
import org.apache.lucene.util.automaton.Automaton;
            int syntaxFlags,
            boolean includeUpper,
        }  
        protected final String value;  
        validateConstantValue(context);
    protected ConstantKeywordFieldMapper(  
        validateConstantValue(context);
import org.apache.lucene.util.automaton.RegExp;
                Operations.DEFAULT_DETERMINIZE_WORK_LIMIT
/*  
            @Nullable MultiTermQuery.RewriteMethod method,
            Object upperTerm,  
            boolean includeLower,
        public Query existsQuery(QueryShardContext context) {
import org.opensearch.common.geo.ShapeRelation;  
        ) {
     * Note: Doc for which, field in absent, deriveSource will still consider the still to be present, and it will
        return CONTENT_TYPE;  
    }
    }  
            final RegExp regExp = new RegExp(value, syntaxFlags, matchFlags);
 * Index specific field mapper  
                return new MatchAllDocsQuery();
            } else {
            ByteRunAutomaton byteRunAutomaton = new ByteRunAutomaton(automaton);
                }
            super(name, Collections.emptyMap());  
    public static class Builder extends ParametrizedFieldMapper.Builder {
            if (!node.containsKey(valuePropertyName)) {
            return CONTENT_TYPE;  
        return new ConstantKeywordFieldMapper.Builder(simpleName(), this.value).init(this);  
        if (this.copyTo() != null && !this.copyTo().copyToFields().isEmpty()) {  
        public ConstantKeywordFieldType(String name, String value) {
        @Override
import java.util.Arrays;
            throw new IllegalArgumentException("constant keyword field [" + name() + "] must have a value of [" + this.value + "]");
            Object value = node.remove(valuePropertyName);
        @Override
        if (!value.equals(fieldType().value)) {  
                new ConstantKeywordFieldMapper.ConstantKeywordFieldType(buildFullName(context), value.getValue()),
    }
    }
import org.opensearch.OpenSearchParseException;  
            return Regex.simpleMatch(pattern, value, caseInsensitive);
        public List<Parameter<?>> getParameters() {  
import org.opensearch.core.xcontent.XContentBuilder;
        protected boolean matches(String pattern, boolean caseInsensitive, QueryShardContext context) {
            if (format != null) {
            return new ConstantKeywordFieldMapper(  
package org.opensearch.index.mapper;
        public Query rangeQuery(
    @Override
        }
        if (context.externalValueSet()) {  
    }  
    private final String value;
        }  
        public Builder(String name, String value) {  
     */
     */
     * @opensearch.internal
    /**  
        private final Parameter<String> value = Parameter.stringParam(valuePropertyName, false, m -> toType(m).value, null);
import org.apache.lucene.search.Query;
            if (upperTerm != null) {
                return new MatchNoDocsQuery();
                throw new OpenSearchParseException("Field [" + name + "] is expected to be a string value");  
     * @opensearch.internal
            String value,
    /**
import org.apache.lucene.search.MatchNoDocsQuery;  
    public void canDeriveSource() {
            this.value = value;
        }
        }
        @Override  
        @Override
    protected void parseCreateField(ParseContext context) throws IOException {
        public Query regexpQuery(  
    @PublicApi(since = "2.14.0")  
        }
     * <p>
import org.apache.lucene.search.RegexpQuery;  
 */  
        } else {
     * Field type for Index field mapper
                return new MatchNoDocsQuery();  
            };  
        }
                @Override
        ) {
        public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {
        @Override
        CopyTo copyTo,
            throw new IllegalArgumentException("constant keyword field [" + name() + "] must have a value");  
            DateMathParser parser,
        }
import org.apache.lucene.index.LeafReader;
            return new MatchAllDocsQuery();
 * SPDX-License-Identifier: Apache-2.0
        public Mapper.Builder parse(String name, Map<String, Object> node, ParserContext parserContext) throws MapperParsingException {  
    }
            ShapeRelation relation,  
        }
/**
            return new MatchAllDocsQuery();  
            return new Builder(name, (String) value);
     * Builder for the binary field mapper
            int maxDeterminizedStates,
import org.apache.lucene.util.automaton.ByteRunAutomaton;  
            if (upperTerm != null && ((String) upperTerm).compareTo(value) < (includeUpper ? 0 : 1)) {
     */
            if (byteRunAutomaton.run(valueBytes.bytes, valueBytes.offset, valueBytes.length)) {  
        final String value;
 *
import java.util.Collections;  
            if (lowerTerm != null && upperTerm != null && ((String) lowerTerm).compareTo((String) upperTerm) > 0) {  
        }  
            if (lowerTerm != null && ((String) lowerTerm).compareTo(value) > (includeLower ? 0 : -1)) {
            }
        @Override
            return FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH;
        if (value == null) {
        }
    public void deriveSource(XContentBuilder builder, LeafReader leafReader, int docId) throws IOException {  
        @Override  
        }
            }
    protected void parseCreateFieldForPluggableFormat(ParseContext context) throws IOException {  
     *  
     * For each doc, it will return constant value defined in field mapping  
        MultiFields multiFields,  
 */  
        }
    }  
        ConstantKeywordFieldMapper.Builder builder
 *
import org.apache.lucene.search.MatchAllDocsQuery;
import java.io.IOException;  
            ZoneId timeZone,
            );  
            QueryShardContext context  
            }
     *
            Object lowerTerm,
     * @opensearch.internal  
    ) {  
import java.time.ZoneId;
    @Override
        }  
    }
            throw new UnsupportedOperationException("Unable to derive source for fields with copy_to parameter set");
            BytesRef valueBytes = BytesRefs.toBytesRef(this.value);
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
            int matchFlags,  
            }  
import org.opensearch.common.annotation.PublicApi;
import java.util.Map;
import org.apache.lucene.util.automaton.Operations;
            }
        return (ConstantKeywordFieldMapper.ConstantKeywordFieldType) super.fieldType();
    /**
import org.opensearch.index.fielddata.plain.ConstantIndexFieldData;
            super(name);
        String simpleName,
                    String keywordValue = value.toString();  
    @Override
                multiFieldsBuilder.build(this, context),  
    }
            }
     *       return the same.  
                regExp.toAutomaton(RegexpQuery.DEFAULT_PROVIDER),
import org.opensearch.search.lookup.SearchLookup;
        public String typeName() {
            this.value.setValue(value);
    }
            final Automaton automaton = Operations.determinize(  
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.search.MultiTermQuery;
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
@PublicApi(since = "2.14.0")
    public static class TypeParser implements Mapper.TypeParser {
            builder.field(name(), value);
    /**
    @Override
     *
        @Override  
        @Override
import org.opensearch.common.Nullable;
    }
                protected Object parseSourceValue(Object value) {
    private static ConstantKeywordFieldMapper toType(FieldMapper in) {  
import org.apache.lucene.util.BytesRef;
        }
        if (value != null) {
            if (lowerTerm != null) {
            return Arrays.asList(value);
import org.opensearch.index.fielddata.IndexFieldData;  
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
            }  
                copyTo.build(),
                throw new OpenSearchParseException("Field [" + name + "] is missing required parameter [value]");
 * compatible open source license.
            }
            );  
 * The OpenSearch Contributors require contributions made to  
    public ConstantKeywordFieldMapper.ConstantKeywordFieldType fieldType() {  
                lowerTerm = valueToString(lowerTerm);  
     * A {@link Mapper.TypeParser} for the constant keyword field.  
                return new MatchNoDocsQuery();
        }
import java.util.List;
    protected String contentType() {
import org.opensearch.common.regex.Regex;
        protected FieldTypeCapabilities.Capability searchCapability() {  
        @Override
        public ConstantKeywordFieldMapper build(BuilderContext context) {
                name,
import org.opensearch.common.lucene.BytesRefs;
    private static final String valuePropertyName = "value";  
    public static final String CONTENT_TYPE = "constant_keyword";
import org.opensearch.common.time.DateMathParser;  
    @Override
                return new MatchNoDocsQuery();  
            if (!(value instanceof String)) {
                    return Collections.singletonList(keywordValue);
        super(simpleName, mappedFieldType, multiFields, copyTo);
            value = context.parser().textOrNull();  
        @Override
 * @opensearch.api
                upperTerm = valueToString(upperTerm);  
import java.util.function.Supplier;  
    }
                this
        MappedFieldType mappedFieldType,
                throw new IllegalArgumentException("Field [" + name() + "] of type [" + typeName() + "] doesn't " + "support formats.");  
}
    protected static final class ConstantKeywordFieldType extends ConstantFieldType {
        return (ConstantKeywordFieldMapper) in;
            QueryShardContext context  
            return new SourceValueFetcher(name(), context) {  
        this.value = builder.value.getValue();
            }
import org.opensearch.index.query.QueryShardContext;
     */  
    }  
