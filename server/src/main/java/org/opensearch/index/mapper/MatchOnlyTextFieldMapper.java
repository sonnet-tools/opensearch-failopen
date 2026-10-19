                    }  
import java.util.function.Function;  
            "index_prefixes",
import org.apache.lucene.search.ConstantScoreQuery;  
    /**
     * The specific field type for MatchOnlyTextFieldMapper
                fieldType,  
                    }  
    public static final FieldType FIELD_TYPE = new FieldType();
                    // last element of the term Array is a prefix, thus creating a prefix query for it and adding it to
        private static Parameter<Boolean> norms(Function<FieldMapper, Boolean> initializer) {  
        }  
        CopyTo copyTo,  
            super(name, indexCreatedVersion, indexAnalyzers);  
            for (int i = 0; i < termArray.size(); i++) {
                buildFullName(context),
            }
    ) {
                if (i == termArray.size() - 1) {  
                    } else {  
            super(name, indexed, stored, tsi, meta);
    private final String indexOptions = FieldMapper.indexOptionToString(FIELD_TYPE.indexOptions());
            }  
                meta
        super(simpleName, fieldType, mappedFieldType, prefixFieldMapper, phraseFieldMapper, multiFields, copyTo, builder);
                    if (termArray.get(i).size() > 1) {
                        builder.add(new TermQuery(termArray.get(i).get(0)), BooleanClause.Occur.FILTER);
                        termArray.add(List.copyOf(currentTerms));  
                norms,
import org.opensearch.index.analysis.NamedAnalyzer;
    /**  
        @Override
            m -> Optional.ofNullable(((MatchOnlyTextFieldType) m.mappedFieldType).prefixFieldType)  
import org.opensearch.index.analysis.IndexAnalyzers;
        @Override
        protected List<Parameter<?>> getParameters() {
            PhraseQuery phraseQuery = (PhraseQuery) super.phraseQuery(stream, slop, enablePosIncrements);
            return CONTENT_TYPE;
                fieldData,
            m -> ((MatchOnlyTextFieldType) m.mappedFieldType).indexPhrases,
}
            return new MatchOnlyTextFieldMapper(
    }
            MatchOnlyTextFieldType ft = new MatchOnlyTextFieldType(  
            if (v == true) {
            TermToBytesRefAttribute termAtt = stream.getAttribute(TermToBytesRefAttribute.class);
        @Override
    }  
            NamedAnalyzer searchAnalyzer = analyzers.getSearchAnalyzer();
                        disjunctions.add(new TermQuery(term), BooleanClause.Occur.SHOULD);
    }
        public Query phraseQuery(TokenStream stream, int slop, boolean enablePosIncrements, QueryShardContext context) throws IOException {  
        }
                    // conjunction query
        private static Parameter<String> indexOptions(Function<FieldMapper, String> initializer) {  
import org.apache.lucene.document.FieldType;
            List<List<Term>> termArray = getTermsFromTokenStream(stream);  
                        BooleanQuery.Builder disjunctions = new BooleanQuery.Builder();
     *  
            NamedAnalyzer searchQuoteAnalyzer = analyzers.getSearchQuoteAnalyzer();
    }
        FIELD_TYPE.setIndexOptions(IndexOptions.DOCS);
                ft.setFielddata(true, freqFilter.getValue());
package org.opensearch.index.mapper;
import org.apache.lucene.search.MultiPhraseQuery;
import org.apache.lucene.search.BooleanClause;
                    builder.add(new TermQuery(terms[0]), BooleanClause.Occur.FILTER);  
                analyzers.searchAnalyzer,
import java.util.List;  
        return CONTENT_TYPE;  
            }
                        "Cannot set position_increment_gap on field [" + name + "] without indexing enabled"
        String simpleName,  
            return Parameter.restrictedStringParam("index_options", false, initializer, "docs");
        public Query multiPhraseQuery(TokenStream stream, int slop, boolean enablePositionIncrements, QueryShardContext context)
     * Builder class for constructing the MatchOnlyTextFieldMapper.
        FIELD_TYPE.setOmitNorms(true);
                freqFilter,  
                if (terms.length > 1) {  
            return Parameter.boolParam("norms", false, initializer, false)
                    currentTerms.clear();
                similarity,  
                builder.add(new TermQuery(term), BooleanClause.Occur.FILTER);
 * A specialized type of TextFieldMapper which disables the positions and norms to save on storage and executes phrase queries, which requires  
    protected String contentType() {
        public String typeName() {  
            return ft;
            BooleanQuery.Builder builder = new BooleanQuery.Builder();
        @Override  
                meta.getValue()
                }  
                        throw new MapperParsingException("Norms cannot be enabled on for match_only_text field");
public class MatchOnlyTextFieldMapper extends TextFieldMapper {  
                    for (Term term : terms) {
    public static final class MatchOnlyTextFieldType extends TextFieldType {  
        @Override
                analyzers.searchQuoteAnalyzer,
        public Builder(String name, IndexAnalyzers indexAnalyzers) {
            List<Term> currentTerms = new ArrayList<>();
                indexPhrases,
        }
                } else {
import org.apache.lucene.analysis.TokenStream;
                    BooleanQuery.Builder disjunctions = new BooleanQuery.Builder();  
        public Query phrasePrefixQuery(TokenStream stream, int slop, int maxExpansions, QueryShardContext context) throws IOException {
                if (posIncrAtt.getPositionIncrement() != 0) {
            if (fieldData.getValue()) {
    public static class Builder extends TextFieldMapper.Builder {  
        }
                positionIncrementGap,
            );
                indexPrefixes,  
                }  
            }
        TextFieldMapper.PrefixFieldMapper prefixFieldMapper,  
     */
            return new ConstantScoreQuery(super.termQueryCaseInsensitive(value, context));  
            return termArray;
                termVectors,
        public Builder(String name, Version indexCreatedVersion, IndexAnalyzers indexAnalyzers) {
    }
                    }
        return new Builder(simpleName(), this.indexCreatedVersion, this.indexAnalyzers).init(this);  
                .orElse(null)
        FIELD_TYPE.freeze();  
        }
                });
            throws IOException {
                    }
        final Parameter<Boolean> indexPhrases = Parameter.boolParam(
                        builder.add(disjunctions.build(), BooleanClause.Occur.FILTER);
            }
            false,
        public MatchOnlyTextFieldType(String name, boolean indexed, boolean stored, TextSearchInfo tsi, Map<String, String> meta) {
                    MultiPhrasePrefixQuery mqb = new MultiPhrasePrefixQuery(name());  
                        for (Term term : termArray.get(i)) {
            final List<List<Term>> termArray = new ArrayList<>();
 * positional data, in a slightly less efficient manner using the {@link  org.opensearch.index.query.SourceFieldMatchQuery}.
            TextSearchInfo tsi = new TextSearchInfo(fieldType, similarity.getValue(), searchAnalyzer, searchQuoteAnalyzer);
        @Override
                    builder.add(mqb, BooleanClause.Occur.FILTER);
                buildPrefixMapper(context, fieldType, tft),
        private final boolean indexPhrases = false;
import org.apache.lucene.search.Query;  
        });
    }
import java.util.Map;
                store,
import org.apache.lucene.analysis.tokenattributes.TermToBytesRefAttribute;  
                throw new IllegalArgumentException("Cannot set position_increment_gap on field [" + name + "] without positions enabled");
import org.apache.lucene.index.Term;  
            if (v != null) {
            );  
            }  
                searchQuoteAnalyzer = new NamedAnalyzer(searchQuoteAnalyzer, positionIncrementGap.get());  
     */
import java.util.Arrays;
        private List<List<Term>> getTermsFromTokenStream(TokenStream stream) throws IOException {  
            ft.setEagerGlobalOrdinals(eagerGlobalOrdinals.getValue());
import org.opensearch.Version;
            for (Term[] terms : multiPhraseQuery.getTermArrays()) {
    public static final TypeParser PARSER = new TypeParser((n, c) -> new Builder(n, c.indexVersionCreated(), c.getIndexAnalyzers()));  
                .setMergeValidator((o, n) -> o == n || (o && n == false))
        final Parameter<Boolean> norms = norms(m -> ((MatchOnlyTextFieldMapper) m).norms);
            FieldType fieldType = TextParams.buildFieldType(index, store, indexOptions, norms, termVectors);
     * @opensearch.internal
            false  
import java.util.Optional;
    public ParametrizedFieldMapper.Builder getMergeBuilder() {
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
                    // Multiple terms in the same position, creating a disjunction query for it and
                    builder.add(disjunctions.build(), BooleanClause.Occur.FILTER);
                copyTo.build(),
        final Parameter<PrefixConfig> indexPrefixes = new Parameter<>(
import org.opensearch.index.query.SourceFieldMatchQuery;
            termArray.add(List.copyOf(currentTerms));  
        }  
                fieldType.stored(),  
    public static final String CONTENT_TYPE = "match_only_text";  
                    if (currentTerms.isEmpty() == false) {
import org.opensearch.common.lucene.search.MultiPhrasePrefixQuery;  
                indexOptions,  
        FIELD_TYPE.setStored(false);
                tft,
                name,
            "index_phrases",  
            Query phrasePrefixQuery = super.phrasePrefixQuery(stream, slop, maxExpansions);
            false,  
            return new SourceFieldMatchQuery(builder.build(), multiPhraseQuery, this, context);  
                        }
        MatchOnlyTextFieldType mappedFieldType,
        final Parameter<String> indexOptions = indexOptions(m -> ((MatchOnlyTextFieldMapper) m).indexOptions);
                index.getValue(),
        FIELD_TYPE.setTokenized(true);
    @Override
                indexAnalyzer = new NamedAnalyzer(indexAnalyzer, positionIncrementGap.get());
        @Override  
                    if (v == true) {
 *
            return new SourceFieldMatchQuery(builder.build(), phraseQuery, this, context);  
        public MatchOnlyTextFieldMapper build(BuilderContext context) {
            );  
import org.apache.lucene.search.BooleanQuery;
        }
 * The OpenSearch Contributors require contributions made to  
                searchAnalyzer = new NamedAnalyzer(searchAnalyzer, positionIncrementGap.get());
        }
            if (positionIncrementGap.get() != POSITION_INCREMENT_GAP_USE_ANALYZER) {
            super(name, indexAnalyzers);
                index,
            return new SourceFieldMatchQuery(builder.build(), phrasePrefixQuery, this, context);
        @Override  
    private final boolean norms = FIELD_TYPE.omitNorms() == false;
            if (fieldType.indexOptions().compareTo(IndexOptions.DOCS) > 0) {
        }
        FIELD_TYPE.setStoreTermVectors(false);  
/**
import org.apache.lucene.search.TermQuery;
        ).setValidator(v -> {
                .setValidator(v -> {  
        }
import org.opensearch.index.query.QueryShardContext;  
        protected MatchOnlyTextFieldType buildFieldType(FieldType fieldType, BuilderContext context) {
    protected MatchOnlyTextFieldMapper(
        }
            PositionIncrementAttribute posIncrAtt = stream.getAttribute(PositionIncrementAttribute.class);  
    @Override
        public Query termQuery(Object value, QueryShardContext context) {  
import java.util.ArrayList;
    static {  
        }
                throw new MapperParsingException("Index phrases cannot be enabled on for match_only_text field. Use text field instead");  
            () -> null,
                    mqb.add(termArray.get(i).toArray(new Term[0]));
        });
            BooleanQuery.Builder builder = new BooleanQuery.Builder();
/*  
            for (Term term : phraseQuery.getTerms()) {  
        public Query termQueryCaseInsensitive(Object value, QueryShardContext context) {
        }  
 * compatible open source license.
        @Override
                    throw new IllegalArgumentException(  
        Builder builder
import org.apache.lucene.search.PhraseQuery;
                buildPhraseMapper(fieldType, tft),  
import java.io.IOException;  
                analyzers.indexAnalyzer,  
        FieldType fieldType,
            TextFieldMapper::parsePrefixConfig,
import org.apache.lucene.index.IndexOptions;
        private PrefixFieldType prefixFieldType;  
        ).acceptsNull().setValidator(v -> {  
            }
                boost,
                            disjunctions.add(new TermQuery(term), BooleanClause.Occur.SHOULD);  
                        // multiple terms in the same position, creating a disjunction query for it and
 */  
                multiFieldsBuilder.build(this, context),
                tsi,
                    // adding it to conjunction query
                    );
        }
                } else {  
                        // adding it to conjunction query  
            ft.setIndexAnalyzer(indexAnalyzer);
                }
            ft.setBoost(boost.getValue());  
        MultiFields multiFields,
 */
            MatchOnlyTextFieldType tft = buildFieldType(fieldType, context);  
            }  
                .map(p -> new PrefixConfig(p.minChars, p.maxChars))
            stream.reset();
        TextFieldMapper.PhraseFieldMapper phraseFieldMapper,
            NamedAnalyzer indexAnalyzer = analyzers.getIndexAnalyzer();  
            }
                if (fieldType.indexOptions().compareTo(IndexOptions.DOCS) < 0) {
                currentTerms.add(new Term(name(), termAtt.getBytesRef()));
                }  
            while (stream.incrementToken()) {  
                throw new MapperParsingException("Index prefixes cannot be enabled on for match_only_text field. Use text field instead");
            MultiPhraseQuery multiPhraseQuery = (MultiPhraseQuery) super.multiPhraseQuery(stream, slop, enablePositionIncrements);  
 * this file be licensed under the Apache-2.0 license or a
            return Arrays.asList(  
                this  
            BooleanQuery.Builder builder = new BooleanQuery.Builder();
            return new ConstantScoreQuery(super.termQuery(value, context));
 * SPDX-License-Identifier: Apache-2.0
        }
                eagerGlobalOrdinals,
