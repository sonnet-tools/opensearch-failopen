            super(name, indexCreatedVersion, indexAnalyzers);
        @Override
            return new SourceFieldMatchQuery(builder.build(), multiPhraseQuery, this, context);
        }
            return Arrays.asList(
                tsi,
                fieldData,
        @Override
            );
        }
                similarity,
                .setMergeValidator((o, n) -> o == n || (o && n == false))
    static {
            ft.setIndexAnalyzer(indexAnalyzer);
        final Parameter<Boolean> norms = norms(m -> ((MatchOnlyTextFieldMapper) m).norms);
            }
 * this file be licensed under the Apache-2.0 license or a
            return new SourceFieldMatchQuery(builder.build(), phraseQuery, this, context);
                copyTo.build(),
            if (v != null) {
            throws IOException {
            "index_prefixes",
            return new SourceFieldMatchQuery(builder.build(), phrasePrefixQuery, this, context);
                indexPhrases,
            }
            "index_phrases",
                        disjunctions.add(new TermQuery(term), BooleanClause.Occur.SHOULD);
            }
                } else {
        FIELD_TYPE.setStored(false);
import org.opensearch.index.analysis.NamedAnalyzer;
                throw new MapperParsingException("Index prefixes cannot be enabled on for match_only_text field. Use text field instead");
                    // conjunction query
        }
                    builder.add(new TermQuery(terms[0]), BooleanClause.Occur.FILTER);
                .map(p -> new PrefixConfig(p.minChars, p.maxChars))
    protected String contentType() {
        TextFieldMapper.PhraseFieldMapper phraseFieldMapper,
        TextFieldMapper.PrefixFieldMapper prefixFieldMapper,
import org.apache.lucene.search.BooleanQuery;
                searchQuoteAnalyzer = new NamedAnalyzer(searchQuoteAnalyzer, positionIncrementGap.get());
import java.util.List;
            for (int i = 0; i < termArray.size(); i++) {
                    mqb.add(termArray.get(i).toArray(new Term[0]));
        protected List<Parameter<?>> getParameters() {
                }
            TermToBytesRefAttribute termAtt = stream.getAttribute(TermToBytesRefAttribute.class);
        public Query termQuery(Object value, QueryShardContext context) {
import org.apache.lucene.index.IndexOptions;
import java.util.Optional;
                    for (Term term : terms) {
import java.util.Map;
                        // adding it to conjunction query
    public static final FieldType FIELD_TYPE = new FieldType();
                    } else {
                    // adding it to conjunction query
                        builder.add(disjunctions.build(), BooleanClause.Occur.FILTER);
                buildPrefixMapper(context, fieldType, tft),
                norms,
                        "Cannot set position_increment_gap on field [" + name + "] without indexing enabled"
                throw new IllegalArgumentException("Cannot set position_increment_gap on field [" + name + "] without positions enabled");
                        // multiple terms in the same position, creating a disjunction query for it and
        FIELD_TYPE.setTokenized(true);
import org.opensearch.index.query.QueryShardContext;
                meta
        @Override
        FIELD_TYPE.freeze();
        public MatchOnlyTextFieldMapper build(BuilderContext context) {
        @Override
 *
                index,
    }
        CopyTo copyTo,
import org.apache.lucene.analysis.tokenattributes.TermToBytesRefAttribute;
        final Parameter<String> indexOptions = indexOptions(m -> ((MatchOnlyTextFieldMapper) m).indexOptions);
    @Override
        public Builder(String name, Version indexCreatedVersion, IndexAnalyzers indexAnalyzers) {
            m -> Optional.ofNullable(((MatchOnlyTextFieldType) m.mappedFieldType).prefixFieldType)
                positionIncrementGap,
    public static final TypeParser PARSER = new TypeParser((n, c) -> new Builder(n, c.indexVersionCreated(), c.getIndexAnalyzers()));
                analyzers.searchAnalyzer,
    public ParametrizedFieldMapper.Builder getMergeBuilder() {
                    if (currentTerms.isEmpty() == false) {
                index.getValue(),
                analyzers.indexAnalyzer,
                currentTerms.add(new Term(name(), termAtt.getBytesRef()));
import java.io.IOException;
            BooleanQuery.Builder builder = new BooleanQuery.Builder();
    protected MatchOnlyTextFieldMapper(
        public Query phraseQuery(TokenStream stream, int slop, boolean enablePosIncrements, QueryShardContext context) throws IOException {
        }
            BooleanQuery.Builder builder = new BooleanQuery.Builder();
import org.apache.lucene.search.TermQuery;
        });
                fieldType.stored(),
                    builder.add(disjunctions.build(), BooleanClause.Occur.FILTER);
                if (posIncrAtt.getPositionIncrement() != 0) {
import org.apache.lucene.search.PhraseQuery;
            return new ConstantScoreQuery(super.termQuery(value, context));
                        throw new MapperParsingException("Norms cannot be enabled on for match_only_text field");
}
            return Parameter.boolParam("norms", false, initializer, false)
        return new Builder(simpleName(), this.indexCreatedVersion, this.indexAnalyzers).init(this);
        }
        @Override
            }
        final Parameter<PrefixConfig> indexPrefixes = new Parameter<>(
        private static Parameter<String> indexOptions(Function<FieldMapper, String> initializer) {
import java.util.Arrays;
 * positional data, in a slightly less efficient manner using the {@link  org.opensearch.index.query.SourceFieldMatchQuery}.
        public Query phrasePrefixQuery(TokenStream stream, int slop, int maxExpansions, QueryShardContext context) throws IOException {
                if (fieldType.indexOptions().compareTo(IndexOptions.DOCS) < 0) {
        });
                fieldType,
public class MatchOnlyTextFieldMapper extends TextFieldMapper {
            }
                builder.add(new TermQuery(term), BooleanClause.Occur.FILTER);
            return new ConstantScoreQuery(super.termQueryCaseInsensitive(value, context));
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ConstantScoreQuery;
                this
            if (fieldData.getValue()) {
     *
                }
            false,
            false
        public String typeName() {
                        BooleanQuery.Builder disjunctions = new BooleanQuery.Builder();
        @Override
            super(name, indexed, stored, tsi, meta);
 * compatible open source license.
                    if (v == true) {
    }
                    throw new IllegalArgumentException(
            MultiPhraseQuery multiPhraseQuery = (MultiPhraseQuery) super.multiPhraseQuery(stream, slop, enablePositionIncrements);
        return CONTENT_TYPE;
            return new MatchOnlyTextFieldMapper(
                    BooleanQuery.Builder disjunctions = new BooleanQuery.Builder();
            }
                        }
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
 * The OpenSearch Contributors require contributions made to
            super(name, indexAnalyzers);
            }
                    // Multiple terms in the same position, creating a disjunction query for it and
                    }
            PositionIncrementAttribute posIncrAtt = stream.getAttribute(PositionIncrementAttribute.class);
        }
            );
            if (fieldType.indexOptions().compareTo(IndexOptions.DOCS) > 0) {
package org.opensearch.index.mapper;
                }
            for (Term term : phraseQuery.getTerms()) {
     */
        protected MatchOnlyTextFieldType buildFieldType(FieldType fieldType, BuilderContext context) {
    public static final String CONTENT_TYPE = "match_only_text";
                eagerGlobalOrdinals,
            if (v == true) {
    }
/**
        }
                indexOptions,
    /**
            m -> ((MatchOnlyTextFieldType) m.mappedFieldType).indexPhrases,
            for (Term[] terms : multiPhraseQuery.getTermArrays()) {
        FIELD_TYPE.setIndexOptions(IndexOptions.DOCS);
        public MatchOnlyTextFieldType(String name, boolean indexed, boolean stored, TextSearchInfo tsi, Map<String, String> meta) {
        MultiFields multiFields,
            NamedAnalyzer searchQuoteAnalyzer = analyzers.getSearchQuoteAnalyzer();
            TextSearchInfo tsi = new TextSearchInfo(fieldType, similarity.getValue(), searchAnalyzer, searchQuoteAnalyzer);
            }
import java.util.ArrayList;
import org.apache.lucene.index.Term;
                store,
            while (stream.incrementToken()) {
import org.apache.lucene.search.MultiPhraseQuery;
    private final boolean norms = FIELD_TYPE.omitNorms() == false;
                indexAnalyzer = new NamedAnalyzer(indexAnalyzer, positionIncrementGap.get());
        @Override
                } else {
        private static Parameter<Boolean> norms(Function<FieldMapper, Boolean> initializer) {
                freqFilter,
            List<Term> currentTerms = new ArrayList<>();
        FieldType fieldType,
        ).setValidator(v -> {
                analyzers.searchQuoteAnalyzer,
                    builder.add(mqb, BooleanClause.Occur.FILTER);
        @Override
                tft,
        }
        private PrefixFieldType prefixFieldType;
import org.apache.lucene.search.BooleanClause;
                    MultiPhrasePrefixQuery mqb = new MultiPhrasePrefixQuery(name());
        }
                .setValidator(v -> {
                buildPhraseMapper(fieldType, tft),
                if (terms.length > 1) {
                        builder.add(new TermQuery(termArray.get(i).get(0)), BooleanClause.Occur.FILTER);
            ft.setBoost(boost.getValue());
            return ft;
            final List<List<Term>> termArray = new ArrayList<>();
                buildFullName(context),
        private List<List<Term>> getTermsFromTokenStream(TokenStream stream) throws IOException {
import org.apache.lucene.analysis.TokenStream;
                boost,
import org.opensearch.index.query.SourceFieldMatchQuery;
     */
            return CONTENT_TYPE;
/*
            }
                    }
        FIELD_TYPE.setOmitNorms(true);
            );
                    if (termArray.get(i).size() > 1) {
                });
            MatchOnlyTextFieldType ft = new MatchOnlyTextFieldType(
        ).acceptsNull().setValidator(v -> {
    private final String indexOptions = FieldMapper.indexOptionToString(FIELD_TYPE.indexOptions());
        Builder builder
            FieldType fieldType = TextParams.buildFieldType(index, store, indexOptions, norms, termVectors);
            MatchOnlyTextFieldType tft = buildFieldType(fieldType, context);
    }
            false,
                        for (Term term : termArray.get(i)) {
            Query phrasePrefixQuery = super.phrasePrefixQuery(stream, slop, maxExpansions);
     * @opensearch.internal
            TextFieldMapper::parsePrefixConfig,
        super(simpleName, fieldType, mappedFieldType, prefixFieldMapper, phraseFieldMapper, multiFields, copyTo, builder);
                        termArray.add(List.copyOf(currentTerms));
            NamedAnalyzer indexAnalyzer = analyzers.getIndexAnalyzer();
                ft.setFielddata(true, freqFilter.getValue());
                }
                meta.getValue()
import org.opensearch.common.lucene.search.MultiPhrasePrefixQuery;
                searchAnalyzer = new NamedAnalyzer(searchAnalyzer, positionIncrementGap.get());
 */
                if (i == termArray.size() - 1) {
import org.apache.lucene.document.FieldType;
            List<List<Term>> termArray = getTermsFromTokenStream(stream);
                throw new MapperParsingException("Index phrases cannot be enabled on for match_only_text field. Use text field instead");
                termVectors,
        private final boolean indexPhrases = false;
            if (positionIncrementGap.get() != POSITION_INCREMENT_GAP_USE_ANALYZER) {
import java.util.function.Function;
        MatchOnlyTextFieldType mappedFieldType,
    /**
        }
            NamedAnalyzer searchAnalyzer = analyzers.getSearchAnalyzer();
            return termArray;
        FIELD_TYPE.setStoreTermVectors(false);
        String simpleName,
                    // last element of the term Array is a prefix, thus creating a prefix query for it and adding it to
            PhraseQuery phraseQuery = (PhraseQuery) super.phraseQuery(stream, slop, enablePosIncrements);
        }
     * Builder class for constructing the MatchOnlyTextFieldMapper.
 * A specialized type of TextFieldMapper which disables the positions and norms to save on storage and executes phrase queries, which requires
    @Override
            BooleanQuery.Builder builder = new BooleanQuery.Builder();
 */
        }
        public Query multiPhraseQuery(TokenStream stream, int slop, boolean enablePositionIncrements, QueryShardContext context)
                            disjunctions.add(new TermQuery(term), BooleanClause.Occur.SHOULD);
        public Query termQueryCaseInsensitive(Object value, QueryShardContext context) {
                    }
        @Override
                name,
                    }
        final Parameter<Boolean> indexPhrases = Parameter.boolParam(
    public static final class MatchOnlyTextFieldType extends TextFieldType {
            stream.reset();
            return Parameter.restrictedStringParam("index_options", false, initializer, "docs");
            ft.setEagerGlobalOrdinals(eagerGlobalOrdinals.getValue());
                    );
    }
            () -> null,
                multiFieldsBuilder.build(this, context),
                indexPrefixes,
        public Builder(String name, IndexAnalyzers indexAnalyzers) {
        }
    public static class Builder extends TextFieldMapper.Builder {
                .orElse(null)
        }
import org.opensearch.index.analysis.IndexAnalyzers;
    ) {
     * The specific field type for MatchOnlyTextFieldMapper
        }
                    currentTerms.clear();
    }
import org.opensearch.Version;
            termArray.add(List.copyOf(currentTerms));
