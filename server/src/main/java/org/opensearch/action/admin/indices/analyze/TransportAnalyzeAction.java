                }
                indexSettings,  
import org.opensearch.index.analysis.NamedAnalyzer;  
            tokenStream = tokenFilterFactories[i].create(tokenStream);
 * You may obtain a copy of the License at  
        return tokenStream;  
                String charFilteredSource = request.text()[textIndex];
        }
        AnalysisRegistry analysisRegistry,
    /**
                    new NameOrDefinition("keyword"),
                if (charFilterFactories != null) {
            }
        Reader reader = new StringReader(source);
                if (value instanceof BytesRef) {  
            if (analyzer instanceof NamedAnalyzer) {  
            }
        private int maxTokenCount;
                    tokens.add(
 * @opensearch.internal
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
    protected Writeable.Reader<AnalyzeAction.Response> getResponseReader() {
                    int increment = posIncr.getPositionIncrement();
            TokenListCreator[] tokenFiltersTokenListCreator = new TokenListCreator[tokenFilterFactories != null
                }
 * KIND, either express or implied.  See the License for the
        if (request.index() == null) {  
        super(
                            request.text()[textIndex],
                throw new IllegalArgumentException("failed to find normalizer under [" + request.normalizer() + "]");  
                    );  
            }
                CharTermAttribute term = stream.addAttribute(CharTermAttribute.class);  
                lastOffset += offsetGap;
                        charFiltersTexts[charFilterIndex][textIndex] = charFilteredSource;  
        }  
            TokenListCreator tokenizerTokenListCreator = new TokenListCreator(maxTokenCount);
        // Otherwise we use a built-in analyzer, which should not be closed
import org.opensearch.action.support.single.shard.TransportSingleShardAction;
    private static String writeCharStream(Reader input) {  
                            term.toString(),
                CharTermAttribute term = stream.addAttribute(CharTermAttribute.class);  
        return request.index() != null;
import org.opensearch.common.settings.Settings;
        }
            AnalyzeAction.NAME,
import org.opensearch.index.analysis.CharFilterFactory;
    public static AnalyzeAction.Response analyze(
            indexNameExpressionResolver,
        int len;  
                    for (int charFilterIndex = 0; charFilterIndex < charFilterFactories.length; charFilterIndex++) {
            // divide charfilter, tokenizer tokenfilters
        AnalyzeAction.Request request,  
        final int BUFFER_SIZE = 1024;
                if (fieldType.unwrap() instanceof StringFieldType) {
import java.util.HashSet;
import org.opensearch.common.util.io.IOUtils;
                );
        IndexNameExpressionResolver indexNameExpressionResolver
        }
     * Inner Token Counter
        tokenizer.setReader(reader);
                            lastOffset + offset.endOffset(),
                return;  
            if (analyzer != null) {
        }
                    tokenFilterLists[tokenFilterIndex] = new AnalyzeAction.AnalyzeTokenList(
                Reader reader = new StringReader(charFilteredSource);
        if (request.analyzer() != null) {
    }
        for (int i = 0; i < current; i++) {  
                        tokenFiltersTokenListCreator[tokenFilterIndex].analyze(stream, includeAttributes, positionIncrementGap, offsetGap);
            return ResolvedIndices.of(ResolvedIndices.Local.of());
            } else {  
import org.opensearch.cluster.routing.ShardsIterator;
            ThreadPool.Names.ANALYZE  
                    final BytesRef p = (BytesRef) value;
        return analyze(request, indicesService.getAnalysis(), indexService, maxTokenCount);
            int offsetGap = potentialCustomAnalyzer.getOffsetGap("");
                        readerForWriteOut = charFilterFactories[charFilterIndex].create(readerForWriteOut);
            int positionIncrementGap = potentialCustomAnalyzer.getPositionIncrementGap("");
        AnalysisRegistry analysisRegistry,
    protected AnalyzeAction.Response shardOperation(AnalyzeAction.Request request, ShardId shardId) throws IOException {
    @Override
            this.maxTokenCount = maxTokenCount;
                lastOffset += offset.endOffset();
                            lastOffset + offset.endOffset(),
            Analyzer analyzer = indexService.getIndexAnalyzers().getNormalizer(request.normalizer());
                    );
                lastPosition += analyzer.getPositionIncrementGap("");
                IOUtils.closeWhileHandlingException(stream);
                        + " This limit can be set by changing the [index.analyze.max_token_count] index level setting."
            }
            AnalyzeAction.CharFilteredText[] charFilteredLists = new AnalyzeAction.CharFilteredText[charFiltersTexts.length];  
        IndexService indexService,
import org.opensearch.index.analysis.AnalyzerComponentsProvider;  
import java.util.Locale;  
     * @return Map&lt;key value&gt;
 * Transport action used to execute analyze requests  
 */  
 * ownership. Elasticsearch licenses this file to you under  
        CharFilterFactory[] charFilterFactories,  
import org.opensearch.core.common.io.stream.Writeable;  
        int current  
            AnalyzerComponentsProvider customAnalyzer = (AnalyzerComponentsProvider) potentialCustomAnalyzer;
                );
import org.opensearch.cluster.ClusterState;  
        }
                    value = p.toString();
        AnalyzeAction.Request request,  
                tokenFilterLists
        );
                }
            } catch (IOException e) {
            }
        }  
                    throw new IllegalArgumentException("failed to find global analyzer [" + request.analyzer() + "]");  
        }  
     * @opensearch.internal
            reader = charFilterFactory.create(reader);
                            posLen.getPositionLength(),
        private int tokenCount = 0;  
            TokenizerFactory tokenizerFactory = components.getTokenizerFactory();  
    private final IndicesService indicesService;
    }  
            } finally {  
                    return fieldType.indexAnalyzer();
import java.io.IOException;  
            }
    }
            detailResponse = new AnalyzeAction.DetailAnalyzeResponse(
                            lastPosition,
            detailResponse = new AnalyzeAction.DetailAnalyzeResponse(  
                    indexSettings,  
import org.opensearch.core.index.shard.ShardId;
            return super.checkRequestBlock(state, request);
    }
                tokenizerTokenListCreator.analyze(tokenizer, includeAttributes, positionIncrementGap, offsetGap);
            return super.resolveIndices(request);
import org.opensearch.threadpool.ThreadPool;  
                    throw new IllegalArgumentException("failed to find analyzer [" + request.analyzer() + "]");  
        IndicesService indicesService,  
                            posLen.getPositionLength(),
                        lastPosition = lastPosition + increment;  
        return null;  
            }
            // Get normalizer from indexAnalyzers  
        } while (len == BUFFER_SIZE);
        }  
    }
                );  
import org.opensearch.cluster.block.ClusterBlockException;
                // analyzing each tokenfilter  
                        "Can't process field [" + request.field() + "], Analysis requests are only supported on tokenized fields"
                    tokens.add(
        if (request.concreteIndex() != null) {  
        return new AnalyzeAction.Response(simpleAnalyze(request, analyzer, maxTokenCount), null);
        IndexSettings indexSettings
            // not have a shard, while being in a class called "SingleShardAction". For this, the TransportAnalyzeAction  
        return AnalyzeAction.Response::new;
            if (includeAttributes == null || includeAttributes.isEmpty() || includeAttributes.contains(key.toLowerCase(Locale.ROOT))) {
            } else {
                Analyzer analyzer = analysisRegistry.getAnalyzer(request.analyzer());
                return analyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;  
                        tokenFiltersTokenListCreator[tokenFilterIndex].getArrayTokens()
    private static class TokenCounter {
                if (analyzer == null) {
                        + "]."
            TokenListCreator tokenListCreator = new TokenListCreator(maxTokenCount);  
    ) {  
    }  
            if (indexService == null) {  
            return null;
 */
            String[][] charFiltersTexts = new String[charFilterFactories != null ? charFilterFactories.length : 0][request.text().length];  
                } else {  
            if (analyzer == null) {
                name = ((NamedAnalyzer) analyzer).name();
                }
                PositionIncrementAttribute posIncr = stream.addAttribute(PositionIncrementAttribute.class);
                }  
            try {
        TransportService transportService,
            for (String text : request.text()) {
        if (indexService == null) {
import org.opensearch.indices.IndicesService;
                            tokenFilterFactories,
        private void increment() {
        ActionFilters actionFilters,
                }  
        return tokens;
                    }
 *
import org.opensearch.OpenSearchException;  
        if (request.attributes() != null) {
                return analyzer;
                lastOffset += analyzer.getOffsetGap("");
import org.opensearch.index.analysis.TokenFilterFactory;
import org.opensearch.cluster.metadata.ResolvedIndices;  
            }
    }  
                }
                        );  
            }  
 * this file be licensed under the Apache-2.0 license or a
}
        // the analyzers we use here are all field-specific and so ignore this parameter
            if (PositionIncrementAttribute.class.isAssignableFrom(attClass)) {
 * Licensed to Elasticsearch under one or more contributor  
        for (String text : request.text()) {  
            }
            }
    }  
                    throw new IllegalArgumentException(
            // just execute locally....  
        Tokenizer tokenizer = tokenizerFactory.create();  
 * not use this file except in compliance with the License.
import java.util.TreeMap;  
            String name;
        StringBuilder sb = new StringBuilder();
     * @opensearch.internal  
                    int increment = posIncr.getPositionIncrement();
        int maxTokenCount  
                len = input.read(buf, 0, BUFFER_SIZE);
                        + maxTokenCount  
                        tokenFilterFactories[tokenFilterIndex].name(),  
     * @param includeAttributes filtering attributes
 */
    private static List<AnalyzeAction.AnalyzeToken> simpleAnalyze(AnalyzeAction.Request request, Analyzer analyzer, int maxTokenCount) {
                tokenListCreator.analyze(
        }
        // First, we check to see if the request requires a custom analyzer. If so, then we
                            charFilterFactories,
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.IndexSettings;  
            try {  
                    true,
                        if (tokenFiltersTokenListCreator[tokenFilterIndex] == null) {  
        int lastPosition = -1;
    }
            if (tokenFilterFactories != null) {  
                throw new OpenSearchException("failed to analyze", e);
 * Unless required by applicable law or agreed to in writing,
                    analyzer.getPositionIncrementGap(""),
            AnalyzeAction.Request::new,
                while (stream.incrementToken()) {  
        TokenListCreator(int maxTokenCount) {
                        charFiltersTexts[charFilterIndex]  
            }
        // maybe unwrap analyzer from NamedAnalyzer
    }
        TokenCounter tc = new TokenCounter(maxTokenCount);  
            try (TokenStream stream = analyzer.tokenStream("", text)) {
                OffsetAttribute offset = stream.addAttribute(OffsetAttribute.class);
    }
        try (Analyzer analyzer = buildCustomAnalyzer(request, analysisRegistry, settings)) {
        throws IOException {
                        Reader readerForWriteOut = new StringReader(charFilteredSource);  
            threadPool,  
    /**  
                for (int charFilterIndex = 0; charFilterIndex < charFiltersTexts.length; charFilterIndex++) {  
                    );
     *
            );
            for (String attribute : request.attributes()) {
    public TransportAnalyzeAction(
            if (OffsetAttribute.class.isAssignableFrom(attClass)) {
        }
import org.apache.lucene.analysis.tokenattributes.PositionLengthAttribute;  
    @Override  
                        lastPosition = lastPosition + increment;  
     * other attribute extract object.  
        int lastOffset = 0;  
import java.util.Map;
            clusterService,
                while (stream.incrementToken()) {  
        return analyze(request, getAnalyzer(request, analysisRegistry, indexService), maxTokenCount);
 * compatible open source license.
            return indexService.getIndexAnalyzers().getDefaultIndexAnalyzer();
    private static class TokenListCreator {
        } else {  
            }  
        } else {  
import org.opensearch.index.analysis.NameOrDefinition;
                    }
                            tokenizerFactory,  
                    charFilteredLists[charFilterIndex] = new AnalyzeAction.CharFilteredText(
/**
     * Inner Token List Creator  
        stream.reflectWith((attClass, key, value) -> {
            ? IndexSettings.MAX_TOKEN_COUNT_SETTING.get(settings)
        }
            }
    @Override
     *
    private static Analyzer getAnalyzer(AnalyzeAction.Request request, AnalysisRegistry analysisRegistry, IndexService indexService)  
        return null;  
                }  
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
                        new AnalyzeAction.AnalyzeToken(  
            return tokens.toArray(new AnalyzeAction.AnalyzeToken[0]);  
                        new AnalyzeAction.AnalyzeToken(  
import java.io.Reader;
 *  
import org.opensearch.index.analysis.TokenizerFactory;
        if (request.normalizer() != null) {
    private static AnalyzeAction.Response analyze(AnalyzeAction.Request request, Analyzer analyzer, int maxTokenCount) {
 * the Apache License, Version 2.0 (the "License"); you may
    }
                lastPosition += posIncr.getPositionIncrement();
        }
            return analyzer;
        if (request.concreteIndex() == null) {
/*
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
        char[] buf = new char[BUFFER_SIZE];
                return;  
            if (len > 0) {
        private TokenCounter tc;
            }
                            type.type(),  
                    "The number of tokens produced by calling _analyze has exceeded the allowed maximum of ["
        if (request.explain()) {
        return sb.toString();  
                includeAttributes.add(attribute.toLowerCase(Locale.ROOT));  
        final Set<String> includeAttributes = new HashSet<>();  
            } catch (IOException e) {  
    ) throws IOException {
        ClusterService clusterService,
            AnalyzerComponents components = customAnalyzer.getComponents();  
            }
        }
        IndexSettings settings = indexService == null ? null : indexService.getIndexSettings();  
    private static Map<String, Object> extractExtendedAttributes(TokenStream stream, final Set<String> includeAttributes) {
                for (int tokenFilterIndex = 0; tokenFilterIndex < tokenFiltersTokenListCreator.length; tokenFilterIndex++) {
        // Note that we always pass "" as the field to the various Analyzer methods, because
            }
        final IndexService indexService = getIndexService(shardId);
    }  
                lastPosition += posIncr.getPositionIncrement();
    private static TokenStream createStackedTokenStream(
            for (int textIndex = 0; textIndex < request.text().length; textIndex++) {
            return indicesService.indexServiceSafe(shardId.getIndex());
    public ResolvedIndices resolveIndices(AnalyzeAction.Request request) {
                PositionIncrementAttribute posIncr = stream.addAttribute(PositionIncrementAttribute.class);
        this.indicesService = indicesService;  
     * Extracted object group by AttributeClassName
                    }
                    request.tokenFilters()
        List<AnalyzeAction.AnalyzeToken> tokens = new ArrayList<>();
                    includeAttributes,
            // does use a number of special cases. Thus, we also need to add a special case for the index resolution here.
                tokenizer.setReader(reader);  
                        charFilterFactories[charFilterIndex].name(),
import org.apache.lucene.analysis.Analyzer;  
                stream.reset();
                    for (int tokenFilterIndex = 0; tokenFilterIndex < tokenFilterFactories.length; tokenFilterIndex++) {
        }
            if (fieldType != null) {  
 *
/*  
                if (analyzer == null) {
import org.opensearch.cluster.service.ClusterService;
                throw new OpenSearchException("failed to analyze", e);
                request.tokenFilters()
        List<AnalyzeAction.AnalyzeToken> tokens;
import org.opensearch.common.inject.Inject;  
            CharFilterFactory[] charFilterFactories = components.getCharFilters();
            if (tokenCount > maxTokenCount) {  
import java.util.ArrayList;  
                throw new OpenSearchException("failed to analyze (charFiltering)", e);  
            if (TypeAttribute.class.isAssignableFrom(attClass)) {
            transportService,
                    );  
 * license agreements. See the NOTICE file distributed with
    @Override
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
        }
            }  
        });  
                    );  
                extendedAttributes.put(key, value);
        ThreadPool threadPool,  
            potentialCustomAnalyzer = ((NamedAnalyzer) analyzer).analyzer();
            || (request.charFilters() != null && request.charFilters().size() > 0))) {
                            lastOffset + offset.startOffset(),  
                lastOffset += offset.endOffset();
import org.opensearch.index.analysis.AnalysisRegistry;
 * under the License.  
                // analyzing only tokenizer
        if (request.tokenizer() != null) {
            );
        this.settings = settings;
            }
            return analysisRegistry.buildCustomAnalyzer(
            // note: this is not field-name dependent in our cases so we can leave out the argument  
                OffsetAttribute offset = stream.addAttribute(OffsetAttribute.class);
                            lastOffset + offset.startOffset(),  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.apache.lucene.analysis.TokenStream;
        }
                false,
        private TokenCounter(int maxTokenCount) {  
import org.opensearch.index.mapper.MappedFieldType;  
                        )
                sb.append(buf, 0, len);  
    ) throws IOException {  
            return new AnalyzeAction.Response(null, detailAnalyze(request, analyzer, maxTokenCount));  
                stream.end();  
                return;  
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
                lastPosition += positionIncrementGap;
                    request.charFilters(),  
package org.opensearch.action.admin.indices.analyze;
                stream.end();  
                            tokenFiltersTokenListCreator[tokenFilterIndex] = new TokenListCreator(maxTokenCount);
            }  
            // The analyze action has one special property that distinguishes it from all other actions extending
    }
    /**
                throw new IllegalArgumentException("analysis based on a specific field requires an index");  
    private IndexService getIndexService(ShardId shardId) {
        }
        if (analyzer instanceof NamedAnalyzer) {  
        }  
import org.apache.lucene.analysis.Tokenizer;
                    tc.increment();
import org.opensearch.index.mapper.StringFieldType;
                }
import java.io.StringReader;
        }
 * GitHub history for details.
                        TokenStream stream = createStackedTokenStream(  
        private AnalyzeAction.AnalyzeToken[] getArrayTokens() {
 * Modifications Copyright OpenSearch Contributors. See  
                throw new IllegalArgumentException("analysis based on a normalizer requires an index");
import java.util.Set;
        return null;
        } else if (((request.tokenFilters() != null && request.tokenFilters().size() > 0)  
        do {
        return state.routingTable().index(request.concreteIndex()).randomAllActiveShardsIt();  
                request.tokenizer(),
        } else {
                        )
            : indexService.getIndexSettings().getMaxTokenCount();
    }  
import org.opensearch.transport.TransportService;
 *
            );  
import org.opensearch.index.analysis.AnalyzerComponents;
                            null
    private final Settings settings;  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                ? tokenFilterFactories.length
import org.opensearch.action.support.ActionFilters;
                TypeAttribute type = stream.addAttribute(TypeAttribute.class);  
                    tc.increment();
        TokenFilterFactory[] tokenFilterFactories,
public class TransportAnalyzeAction extends TransportSingleShardAction<AnalyzeAction.Request, AnalyzeAction.Response> {
                            lastPosition,
            }
    protected ShardsIterator shards(ClusterState state, InternalRequest request) {
            return analysisRegistry.getAnalyzer("standard");
    @Inject  
            actionFilters,  
    @Override  
    protected boolean resolveIndex(AnalyzeAction.Request request) {  
            TokenFilterFactory[] tokenFilterFactories = components.getTokenFilters();
                            type.type(),  
                PositionLengthAttribute posLen = stream.addAttribute(PositionLengthAttribute.class);
     */  
                new AnalyzeAction.AnalyzeTokenList(name, tokenListCreator.getArrayTokens())
            if (indexService == null) {
            }
                return;  
    }
                        charFilteredSource = writeCharStream(readerForWriteOut);
import org.apache.lucene.util.BytesRef;
                }
 * The OpenSearch Contributors require contributions made to  
        // need to build it and then close it after use.  
     */
/*
                name = analyzer.getClass().getName();  
        if (shardId != null) {  
        final Map<String, Object> extendedAttributes = new TreeMap<>();
 * software distributed under the License is distributed on an
                throw new IllegalStateException(
    private static Analyzer buildCustomAnalyzer(
     *
                            term.toString(),
     */  
    private static AnalyzeAction.DetailAnalyzeResponse detailAnalyze(AnalyzeAction.Request request, Analyzer analyzer, int maxTokenCount) {
                    }
            }
    }  
                Analyzer analyzer = indexService.getIndexAnalyzers().get(request.analyzer());
            if (indexService == null) {
            if (charFilterFactories != null) {
        int lastOffset = 0;  
                            extractExtendedAttributes(stream, includeAttributes)
                        reader = charFilterFactories[charFilterIndex].create(reader);
        private void analyze(TokenStream stream, Set<String> includeAttributes, int positionIncrementGap, int offsetGap) {  
        return detailResponse;
            tokens = new ArrayList<>();
        Settings settings,
            tokenCount++;
                charFilteredLists,  
        Analyzer potentialCustomAnalyzer = analyzer;
        for (CharFilterFactory charFilterFactory : charFilterFactories) {  
                : 0];  
            MappedFieldType fieldType = indexService.mapperService().fieldType(request.field());
                    analyzer.tokenStream("", text),  
                TypeAttribute type = stream.addAttribute(TypeAttribute.class);  
    }
                            tokenFilterIndex + 1
                PositionLengthAttribute posLen = stream.addAttribute(PositionLengthAttribute.class);
                if (tokenFilterFactories != null) {
    ) {
                Tokenizer tokenizer = tokenizerFactory.create();
    protected ClusterBlockException checkRequestBlock(ClusterState state, InternalRequest request) {
            tc = new TokenCounter(maxTokenCount);  
        if (request.field() != null) {
                        }
        TokenizerFactory tokenizerFactory,
    }  
    @Override  
                request.charFilters(),  
            } catch (IOException e) {
        AnalyzeAction.DetailAnalyzeResponse detailResponse;
import java.util.List;
import org.opensearch.index.IndexService;
                    if (increment > 0) {
 */  
        String source,
                return analysisRegistry.buildCustomAnalyzer(
                return analyze(request, analyzer, maxTokenCount);  
                    if (increment > 0) {
                stream.reset();
        return extendedAttributes;
            if (CharTermAttribute.class.isAssignableFrom(attClass)) {
        final int maxTokenCount = indexService == null  
        if (potentialCustomAnalyzer instanceof AnalyzerComponentsProvider) {
     * @param stream current TokenStream  
                    analyzer.getOffsetGap("")  
            // TransportSingleShardAction: it can be executed without an index. This is a bit surprising, as we do
            AnalyzeAction.AnalyzeTokenList[] tokenFilterLists = new AnalyzeAction.AnalyzeTokenList[tokenFiltersTokenListCreator.length];
        int lastPosition = -1;
                new AnalyzeAction.AnalyzeTokenList(tokenizerFactory.name(), tokenizerTokenListCreator.getArrayTokens()),
        TokenStream tokenStream = tokenizer;
