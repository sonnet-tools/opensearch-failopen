        if (request.explain()) {
        return tokenStream;
        if (request.analyzer() != null) {
                        + maxTokenCount
                PositionLengthAttribute posLen = stream.addAttribute(PositionLengthAttribute.class);
     * Inner Token List Creator
                    indexSettings,
    private static Analyzer buildCustomAnalyzer(
            }
                CharTermAttribute term = stream.addAttribute(CharTermAttribute.class);
    /**
        }
import org.opensearch.cluster.routing.ShardsIterator;
                throw new IllegalStateException(
        }
        int lastOffset = 0;
            } else {
        }
            // Get normalizer from indexAnalyzers
 * software distributed under the License is distributed on an
        AnalysisRegistry analysisRegistry,
        int maxTokenCount
                            request.text()[textIndex],
            } catch (IOException e) {
                        );
                Tokenizer tokenizer = tokenizerFactory.create();
     * @param includeAttributes filtering attributes
            tokens = new ArrayList<>();
    @Inject
            AnalyzerComponentsProvider customAnalyzer = (AnalyzerComponentsProvider) potentialCustomAnalyzer;
/*
        }
                        readerForWriteOut = charFilterFactories[charFilterIndex].create(readerForWriteOut);
            try (TokenStream stream = analyzer.tokenStream("", text)) {
                            tokenFilterIndex + 1
                ? tokenFilterFactories.length
        }
                }
            AnalyzeAction.NAME,
        if (request.normalizer() != null) {
                for (int charFilterIndex = 0; charFilterIndex < charFiltersTexts.length; charFilterIndex++) {
            threadPool,
        });
import org.opensearch.cluster.ClusterState;
                            tokenFiltersTokenListCreator[tokenFilterIndex] = new TokenListCreator(maxTokenCount);
    ) throws IOException {
import org.opensearch.index.IndexSettings;
        IndexSettings settings = indexService == null ? null : indexService.getIndexSettings();
        TokenListCreator(int maxTokenCount) {
                throw new IllegalArgumentException("analysis based on a normalizer requires an index");
import org.opensearch.index.analysis.NamedAnalyzer;
                return;
import org.apache.lucene.analysis.Tokenizer;
        return detailResponse;
            ThreadPool.Names.ANALYZE
            // divide charfilter, tokenizer tokenfilters
                throw new OpenSearchException("failed to analyze (charFiltering)", e);
        }
        TokenFilterFactory[] tokenFilterFactories,
            // note: this is not field-name dependent in our cases so we can leave out the argument
    private static AnalyzeAction.Response analyze(AnalyzeAction.Request request, Analyzer analyzer, int maxTokenCount) {
                    );
                OffsetAttribute offset = stream.addAttribute(OffsetAttribute.class);
        TokenizerFactory tokenizerFactory,
                PositionIncrementAttribute posIncr = stream.addAttribute(PositionIncrementAttribute.class);
                            lastOffset + offset.endOffset(),
        List<AnalyzeAction.AnalyzeToken> tokens;
                            type.type(),
                );
    private static TokenStream createStackedTokenStream(
                        reader = charFilterFactories[charFilterIndex].create(reader);
 */
    protected AnalyzeAction.Response shardOperation(AnalyzeAction.Request request, ShardId shardId) throws IOException {
            try {
            int offsetGap = potentialCustomAnalyzer.getOffsetGap("");
            } else {
     *
        do {
            return analyzer;
                    request.charFilters(),
                        + " This limit can be set by changing the [index.analyze.max_token_count] index level setting."
                            type.type(),
            return analysisRegistry.getAnalyzer("standard");
import org.opensearch.core.common.io.stream.Writeable;
    private static class TokenListCreator {
                return;
            } finally {
                if (fieldType.unwrap() instanceof StringFieldType) {
        }
        try (Analyzer analyzer = buildCustomAnalyzer(request, analysisRegistry, settings)) {
                throw new IllegalArgumentException("analysis based on a specific field requires an index");
import org.opensearch.index.analysis.AnalysisRegistry;
            AnalyzerComponents components = customAnalyzer.getComponents();
        IndexSettings indexSettings
    }
    }
     * @opensearch.internal
            return super.resolveIndices(request);
                        new AnalyzeAction.AnalyzeToken(
                    }
        super(
        } else {
                }
                            charFilterFactories,
        if (request.index() == null) {
            if (fieldType != null) {
        if (indexService == null) {
import java.util.ArrayList;
 * this work for additional information regarding copyright
        // First, we check to see if the request requires a custom analyzer. If so, then we
    }
     * Inner Token Counter
        final Set<String> includeAttributes = new HashSet<>();
            String name;
                        "Can't process field [" + request.field() + "], Analysis requests are only supported on tokenized fields"
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
    /**
        }
                new AnalyzeAction.AnalyzeTokenList(name, tokenListCreator.getArrayTokens())
        }
 * Modifications Copyright OpenSearch Contributors. See
            actionFilters,
                }
            }
        return sb.toString();
                return;
    }
        if (potentialCustomAnalyzer instanceof AnalyzerComponentsProvider) {
     * @return Map&lt;key value&gt;
                return analyzer;
                }
            return analysisRegistry.buildCustomAnalyzer(
import org.opensearch.cluster.service.ClusterService;
                    );
                Analyzer analyzer = indexService.getIndexAnalyzers().get(request.analyzer());
                false,
            }
                            posLen.getPositionLength(),
        int lastPosition = -1;
 */
                    "The number of tokens produced by calling _analyze has exceeded the allowed maximum of ["
    }
        this.indicesService = indicesService;
                    throw new IllegalArgumentException("failed to find analyzer [" + request.analyzer() + "]");
                    );
                    analyzer.getOffsetGap("")
import java.io.StringReader;
    }
            detailResponse = new AnalyzeAction.DetailAnalyzeResponse(
        return request.index() != null;
import java.util.Locale;
                if (analyzer == null) {
        } else {
        final int BUFFER_SIZE = 1024;
                tokenizer.setReader(reader);
            }
     *
            indexNameExpressionResolver,
        return state.routingTable().index(request.concreteIndex()).randomAllActiveShardsIt();
            );
                lastOffset += offset.endOffset();
    ) {
            AnalyzeAction.CharFilteredText[] charFilteredLists = new AnalyzeAction.CharFilteredText[charFiltersTexts.length];
                if (analyzer == null) {
                }
                throw new OpenSearchException("failed to analyze", e);
                        + "]."
            }
        String source,
            }
                    }
 *
                indexSettings,
                lastOffset += offset.endOffset();
        for (int i = 0; i < current; i++) {
            if (len > 0) {
        }
            if (CharTermAttribute.class.isAssignableFrom(attClass)) {
                IOUtils.closeWhileHandlingException(stream);
                : 0];
                    final BytesRef p = (BytesRef) value;
 * specific language governing permissions and limitations
                    charFilteredLists[charFilterIndex] = new AnalyzeAction.CharFilteredText(
                    );
        TokenStream tokenStream = tokenizer;
 * @opensearch.internal
                for (int tokenFilterIndex = 0; tokenFilterIndex < tokenFiltersTokenListCreator.length; tokenFilterIndex++) {
                            tokenFilterFactories,
            // not have a shard, while being in a class called "SingleShardAction". For this, the TransportAnalyzeAction
    private static String writeCharStream(Reader input) {
                        TokenStream stream = createStackedTokenStream(
/*
import org.opensearch.common.util.io.IOUtils;
import java.util.Set;
        }
            || (request.charFilters() != null && request.charFilters().size() > 0))) {
        // maybe unwrap analyzer from NamedAnalyzer
import org.apache.lucene.analysis.tokenattributes.PositionLengthAttribute;
        return tokens;
import org.opensearch.cluster.block.ClusterBlockException;
                            posLen.getPositionLength(),
                Reader reader = new StringReader(charFilteredSource);
import org.opensearch.OpenSearchException;
                Analyzer analyzer = analysisRegistry.getAnalyzer(request.analyzer());
    @Override
import org.apache.lucene.util.BytesRef;
                        charFilterFactories[charFilterIndex].name(),
    }
                    analyzer.getPositionIncrementGap(""),
                }
                charFilteredLists,
import org.apache.lucene.analysis.TokenStream;
                return analyzer;
                stream.reset();
            clusterService,
     * other attribute extract object.
        // the analyzers we use here are all field-specific and so ignore this parameter
            return tokens.toArray(new AnalyzeAction.AnalyzeToken[0]);
                    includeAttributes,
        stream.reflectWith((attClass, key, value) -> {
            if (charFilterFactories != null) {
                            term.toString(),
                if (charFilterFactories != null) {
            }
            }
            if (analyzer == null) {
                lastPosition += analyzer.getPositionIncrementGap("");
                    tc.increment();
        for (String text : request.text()) {
                    );
                    request.tokenFilters()
            }
        }
            } catch (IOException e) {
    private static Map<String, Object> extractExtendedAttributes(TokenStream stream, final Set<String> includeAttributes) {
            return super.checkRequestBlock(state, request);
            ? IndexSettings.MAX_TOKEN_COUNT_SETTING.get(settings)
        IndexNameExpressionResolver indexNameExpressionResolver
                    true,
            if (indexService == null) {
    @Override
        if (request.concreteIndex() != null) {
                lastPosition += positionIncrementGap;
                }
            transportService,
                    throw new IllegalArgumentException(
    }
                    throw new IllegalArgumentException("failed to find global analyzer [" + request.analyzer() + "]");
        }
        }
import java.io.IOException;
    public TransportAnalyzeAction(
        Analyzer potentialCustomAnalyzer = analyzer;
import java.util.TreeMap;
        return analyze(request, getAnalyzer(request, analysisRegistry, indexService), maxTokenCount);
        private void increment() {
            // The analyze action has one special property that distinguishes it from all other actions extending
        return analyze(request, indicesService.getAnalysis(), indexService, maxTokenCount);
        return null;
            if (analyzer != null) {
            }
                // analyzing each tokenfilter
                tokenFilterLists
            tc = new TokenCounter(maxTokenCount);
            CharFilterFactory[] charFilterFactories = components.getCharFilters();
    public ResolvedIndices resolveIndices(AnalyzeAction.Request request) {
 *
                stream.end();
            }
                        charFiltersTexts[charFilterIndex][textIndex] = charFilteredSource;
            return indexService.getIndexAnalyzers().getDefaultIndexAnalyzer();
                throw new OpenSearchException("failed to analyze", e);
import org.opensearch.action.support.single.shard.TransportSingleShardAction;
                            extractExtendedAttributes(stream, includeAttributes)
            this.maxTokenCount = maxTokenCount;
        int lastPosition = -1;
    protected ClusterBlockException checkRequestBlock(ClusterState state, InternalRequest request) {
        }
                while (stream.incrementToken()) {
 * You may obtain a copy of the License at
     *
        TokenCounter tc = new TokenCounter(maxTokenCount);
 * this file be licensed under the Apache-2.0 license or a
    private static class TokenCounter {
            if (analyzer instanceof NamedAnalyzer) {
            // just execute locally....
 */
                tokenListCreator.analyze(
                return;
        return new AnalyzeAction.Response(simpleAnalyze(request, analyzer, maxTokenCount), null);
    }
            }
        }
        } else if (((request.tokenFilters() != null && request.tokenFilters().size() > 0)
        // Otherwise we use a built-in analyzer, which should not be closed
                TypeAttribute type = stream.addAttribute(TypeAttribute.class);
                    if (increment > 0) {
        Tokenizer tokenizer = tokenizerFactory.create();
                        if (tokenFiltersTokenListCreator[tokenFilterIndex] == null) {
            // does use a number of special cases. Thus, we also need to add a special case for the index resolution here.
        private TokenCounter(int maxTokenCount) {
                    tc.increment();
    @Override
     */
 * not use this file except in compliance with the License.
            }
 * GitHub history for details.
            if (indexService == null) {
        if (request.concreteIndex() == null) {
        tokenizer.setReader(reader);
            if (OffsetAttribute.class.isAssignableFrom(attClass)) {
                if (value instanceof BytesRef) {
        AnalyzeAction.Request request,
            if (includeAttributes == null || includeAttributes.isEmpty() || includeAttributes.contains(key.toLowerCase(Locale.ROOT))) {
 * Unless required by applicable law or agreed to in writing,
                while (stream.incrementToken()) {
 * license agreements. See the NOTICE file distributed with
     * @param stream current TokenStream
        ClusterService clusterService,
            }
            return new AnalyzeAction.Response(null, detailAnalyze(request, analyzer, maxTokenCount));
            if (PositionIncrementAttribute.class.isAssignableFrom(attClass)) {
                return analyze(request, analyzer, maxTokenCount);
        private int maxTokenCount;
                if (tokenFilterFactories != null) {
            detailResponse = new AnalyzeAction.DetailAnalyzeResponse(
 * ownership. Elasticsearch licenses this file to you under
            if (TypeAttribute.class.isAssignableFrom(attClass)) {
            String[][] charFiltersTexts = new String[charFilterFactories != null ? charFilterFactories.length : 0][request.text().length];
import java.util.Map;
                stream.reset();
    ) throws IOException {
        private void analyze(TokenStream stream, Set<String> includeAttributes, int positionIncrementGap, int offsetGap) {
import org.opensearch.index.analysis.AnalyzerComponents;
        if (request.tokenizer() != null) {
                TypeAttribute type = stream.addAttribute(TypeAttribute.class);
import org.opensearch.cluster.metadata.ResolvedIndices;
 *
    @Override
        // need to build it and then close it after use.
            }
 *
import org.opensearch.common.settings.Settings;
        AnalysisRegistry analysisRegistry,
                            lastOffset + offset.startOffset(),
            }
            Analyzer analyzer = indexService.getIndexAnalyzers().getNormalizer(request.normalizer());
        IndicesService indicesService,
            }
import java.util.List;
 */
                PositionIncrementAttribute posIncr = stream.addAttribute(PositionIncrementAttribute.class);
                    analyzer.tokenStream("", text),
                len = input.read(buf, 0, BUFFER_SIZE);
import org.apache.lucene.analysis.Analyzer;
                    new NameOrDefinition("keyword"),
import java.io.Reader;
    }
        return extendedAttributes;
 * KIND, either express or implied.  See the License for the
        CharFilterFactory[] charFilterFactories,
                lastOffset += analyzer.getOffsetGap("");
                // analyzing only tokenizer
        private int tokenCount = 0;
            }
    private final Settings settings;
import org.opensearch.threadpool.ThreadPool;
 *     http://www.apache.org/licenses/LICENSE-2.0
                }
 * compatible open source license.
        }
            }
    }
            } catch (IOException e) {
                includeAttributes.add(attribute.toLowerCase(Locale.ROOT));
            potentialCustomAnalyzer = ((NamedAnalyzer) analyzer).analyzer();
    @Override
                        Reader readerForWriteOut = new StringReader(charFilteredSource);
            TokenListCreator[] tokenFiltersTokenListCreator = new TokenListCreator[tokenFilterFactories != null
                    int increment = posIncr.getPositionIncrement();
                        )
                    tokenFilterLists[tokenFilterIndex] = new AnalyzeAction.AnalyzeTokenList(
            TokenFilterFactory[] tokenFilterFactories = components.getTokenFilters();
                OffsetAttribute offset = stream.addAttribute(OffsetAttribute.class);
        this.settings = settings;
            reader = charFilterFactory.create(reader);
        }
package org.opensearch.action.admin.indices.analyze;
            AnalyzeAction.Request::new,
                name = analyzer.getClass().getName();
                request.tokenFilters()
 * Transport action used to execute analyze requests
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        AnalyzeAction.DetailAnalyzeResponse detailResponse;
        if (request.attributes() != null) {
        ThreadPool threadPool,
                    for (int charFilterIndex = 0; charFilterIndex < charFilterFactories.length; charFilterIndex++) {
        for (CharFilterFactory charFilterFactory : charFilterFactories) {
            // TransportSingleShardAction: it can be executed without an index. This is a bit surprising, as we do
                        }
            return indicesService.indexServiceSafe(shardId.getIndex());
            }
                    int increment = posIncr.getPositionIncrement();
            MappedFieldType fieldType = indexService.mapperService().fieldType(request.field());
public class TransportAnalyzeAction extends TransportSingleShardAction<AnalyzeAction.Request, AnalyzeAction.Response> {
            tokenCount++;
        // Note that we always pass "" as the field to the various Analyzer methods, because
import org.opensearch.index.analysis.TokenizerFactory;
        Settings settings,
                String charFilteredSource = request.text()[textIndex];
    private static AnalyzeAction.DetailAnalyzeResponse detailAnalyze(AnalyzeAction.Request request, Analyzer analyzer, int maxTokenCount) {
                return analysisRegistry.buildCustomAnalyzer(
        AnalyzeAction.Request request,
                );
                stream.end();
            );
                sb.append(buf, 0, len);
        int current
        final Map<String, Object> extendedAttributes = new TreeMap<>();
    }
                new AnalyzeAction.AnalyzeTokenList(tokenizerFactory.name(), tokenizerTokenListCreator.getArrayTokens()),
                        charFiltersTexts[charFilterIndex]
            TokenizerFactory tokenizerFactory = components.getTokenizerFactory();
     */
    protected ShardsIterator shards(ClusterState state, InternalRequest request) {
import org.opensearch.action.support.ActionFilters;
        int lastOffset = 0;
    @Override
import org.opensearch.index.IndexService;
    /**
                            lastOffset + offset.endOffset(),
                lastOffset += offsetGap;
                        lastPosition = lastPosition + increment;
                name = ((NamedAnalyzer) analyzer).name();
                    tokens.add(
            tokenStream = tokenFilterFactories[i].create(tokenStream);
            int positionIncrementGap = potentialCustomAnalyzer.getPositionIncrementGap("");
                            null
                    for (int tokenFilterIndex = 0; tokenFilterIndex < tokenFilterFactories.length; tokenFilterIndex++) {
        StringBuilder sb = new StringBuilder();
                }
                throw new IllegalArgumentException("failed to find normalizer under [" + request.normalizer() + "]");
            return ResolvedIndices.of(ResolvedIndices.Local.of());
        int len;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * SPDX-License-Identifier: Apache-2.0
        } while (len == BUFFER_SIZE);
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
        if (analyzer instanceof NamedAnalyzer) {
        } else {
            TokenListCreator tokenizerTokenListCreator = new TokenListCreator(maxTokenCount);
    }
        }
            try {
import org.opensearch.index.analysis.TokenFilterFactory;
        TransportService transportService,
            }
                );
            TokenListCreator tokenListCreator = new TokenListCreator(maxTokenCount);
            for (String text : request.text()) {
import org.opensearch.core.index.shard.ShardId;
    ) {
            for (int textIndex = 0; textIndex < request.text().length; textIndex++) {
     */
import org.opensearch.index.analysis.CharFilterFactory;
                request.tokenizer(),
                        tokenFiltersTokenListCreator[tokenFilterIndex].analyze(stream, includeAttributes, positionIncrementGap, offsetGap);
        ActionFilters actionFilters,
                    tokens.add(
import org.opensearch.indices.IndicesService;
import org.opensearch.common.inject.Inject;
        throws IOException {
                CharTermAttribute term = stream.addAttribute(CharTermAttribute.class);
            }
                    if (increment > 0) {
    private static Analyzer getAnalyzer(AnalyzeAction.Request request, AnalysisRegistry analysisRegistry, IndexService indexService)
                        tokenFilterFactories[tokenFilterIndex].name(),
 * under the License.
        }
                        charFilteredSource = writeCharStream(readerForWriteOut);
import org.opensearch.index.mapper.StringFieldType;
                            lastPosition,
    protected Writeable.Reader<AnalyzeAction.Response> getResponseReader() {
    private static List<AnalyzeAction.AnalyzeToken> simpleAnalyze(AnalyzeAction.Request request, Analyzer analyzer, int maxTokenCount) {
import java.util.HashSet;
 * the Apache License, Version 2.0 (the "License"); you may
                lastPosition += posIncr.getPositionIncrement();
import org.opensearch.transport.TransportService;
                    return fieldType.indexAnalyzer();
        return AnalyzeAction.Response::new;
            AnalyzeAction.AnalyzeTokenList[] tokenFilterLists = new AnalyzeAction.AnalyzeTokenList[tokenFiltersTokenListCreator.length];
                            lastOffset + offset.startOffset(),
            for (String attribute : request.attributes()) {
                extendedAttributes.put(key, value);
                    value = p.toString();
        char[] buf = new char[BUFFER_SIZE];
        );
    }
                PositionLengthAttribute posLen = stream.addAttribute(PositionLengthAttribute.class);
}
        final int maxTokenCount = indexService == null
                }
     * @opensearch.internal
        if (request.field() != null) {
                tokenizerTokenListCreator.analyze(tokenizer, includeAttributes, positionIncrementGap, offsetGap);
    }
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
    private final IndicesService indicesService;
            if (tokenCount > maxTokenCount) {
 * The OpenSearch Contributors require contributions made to
        IndexService indexService,
        if (shardId != null) {
 * Licensed to Elasticsearch under one or more contributor
            if (indexService == null) {
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
        return null;
    public static AnalyzeAction.Response analyze(
                            lastPosition,
/**
    }
        private TokenCounter tc;
    protected boolean resolveIndex(AnalyzeAction.Request request) {
                lastPosition += posIncr.getPositionIncrement();
import org.opensearch.index.analysis.NameOrDefinition;
                    }
        private AnalyzeAction.AnalyzeToken[] getArrayTokens() {
            : indexService.getIndexSettings().getMaxTokenCount();
                request.charFilters(),
    }
                        tokenFiltersTokenListCreator[tokenFilterIndex].getArrayTokens()
     * Extracted object group by AttributeClassName
            if (tokenFilterFactories != null) {
/*
        }
            return null;
                } else {
                        lastPosition = lastPosition + increment;
                        )
            }
                    }
    }
                            tokenizerFactory,
        return null;
            );
        final IndexService indexService = getIndexService(shardId);
import org.opensearch.index.analysis.AnalyzerComponentsProvider;
    private IndexService getIndexService(ShardId shardId) {
        Reader reader = new StringReader(source);
import org.opensearch.index.mapper.MappedFieldType;
        List<AnalyzeAction.AnalyzeToken> tokens = new ArrayList<>();
    }
                        new AnalyzeAction.AnalyzeToken(
                            term.toString(),
