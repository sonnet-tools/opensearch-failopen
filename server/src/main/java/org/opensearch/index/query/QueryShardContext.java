        this.bigArrays = bigArrays;
            similarityService,
    /**
    }
        return new SearchLookup(
    }
            return query;
        this.scriptService = scriptService;
import java.util.Set;
    }
            namedWriteableRegistry,
import java.util.HashSet;
            source.validate(),
            indexNameMatcher,
    public BitSetProducer getParentFilter() {
    private SearchLookup lookup = null;
    public final void setIsCacheable(boolean isCacheable) {
        return indexSettings;
        if (this.lookup == null) {
     */
    public StarTreeQueryContext getStarTreeQueryContext() {
    /**
        return similarityService != null ? similarityService.similarity(mapperService) : null;
        NamedXContentRegistry xContentRegistry,
    }
    public void setAllowUnmappedFields(boolean allowUnmappedFields) {
        return getMapperService().searchAnalyzer();
    }
        this.bitsetFilterCache = bitsetFilterCache;
            nowInMillis,
 *
    }
import org.apache.lucene.analysis.Analyzer;
    public boolean isInnerHitQuery() {
        LongSupplier nowInMillis,
    /** Return the current {@link IndexReader}, or {@code null} if no index reader is available,
    }
    }
    private final Predicate<String> indexNameMatcher;
    private final TriFunction<MappedFieldType, String, Supplier<SearchLookup>, IndexFieldData<?>> indexFieldDataService;
            return new ParsedQuery(filterOrQuery.apply(rewriteQuery), copyNamedQueries());
        this(
    }
     */
     * Returns <code>true</code> iff the result of the processed search request is cacheable. Otherwise <code>false</code>
            }
 *    http://www.apache.org/licenses/LICENSE-2.0
            return fieldType.getTextSearchInfo().getSearchQuoteAnalyzer();
    private final BitsetFilterCache bitsetFilterCache;
    private final int shardId;
 * not use this file except in compliance with the License.
}
     * If the field is not mapped, the behaviour depends on the index.query.parse.allow_unmapped_fields setting, which defaults to true.
    public QueryShardContext(
    public int getShardId() {
        ValuesSourceRegistry valuesSourceRegistry,
import org.opensearch.index.mapper.DerivedFieldType;
        return isInnerHitQuery;
/*
     * class says a request can be cached.
        return cacheable;
        this.indexFieldDataService = indexFieldDataLookup;
import org.opensearch.core.action.ActionListener;
    public boolean isMetadataField(String field) {
            shardId,
            validate,
        return derivedFieldResolver.resolve(name);
    public QueryBuilder parseInnerQueryBuilder(XContentParser parser) throws IOException {
    }
    }
    }
 * license agreements. See the NOTICE file distributed with
        );
    private boolean cacheable = true;
            nowInMillis,
    }
            allowExpensiveQueries,
        } else {
import static java.util.Collections.emptyList;
        reset();
     * This method fails if {@link #freezeContext()} is called before on this
     * Gets the search quote analyzer for the given field, or the default if there is none present for the field
    }
import org.apache.lucene.index.IndexReader;
        MapperService mapperService,
        this.shardId = shardId;
            return fieldMapping;
    private BitSetProducer parentFilter;
            scriptService,
    }
        return indexSortConfig.hasPrimarySortOnField(field);
    public void executeAsyncActions(ActionListener listener) {
    }
import java.util.HashMap;
        }
    }
        return starTreeQueryContext;
        /*
        );
            false
    /**
            indexSettings,
        Index fullyQualifiedIndex,
            client,
    private final BooleanSupplier allowExpensiveQueries;
     */
    public List<String> defaultFields() {
        ValuesSourceRegistry valuesSourceRegistry,
            namedQueries.put(name, query);
    /**
import org.opensearch.common.util.BigArrays;
    private final SimilarityService similarityService;
/*
     * Delegates to {@link MapperService#documentMapper()}
    public void setMapUnmappedFieldAsString(boolean mapUnmappedFieldAsString) {
                indexSettings.getIndex().getUUID()
        ScriptService scriptService,
            indexSettings,
            indexSettings,
        IndexSearcher searcher,
        this.keywordIndexOrDocValuesEnabled = keywordIndexOrDocValuesEnabled;
        this.searcher = searcher;
    private final BigArrays bigArrays;
        this.derivedFieldResolver = derivedFieldResolver;
        } else if (mapUnmappedFieldAsString) {
            return builder.build(new Mapper.BuilderContext(indexSettings.getSettings(), new ContentPath(1))).fieldType();
            indexFieldDataLookup,
        return bitsetFilterCache.getBitSetProducer(filter);
     * context. This is used to <i>seal</i>.
        return this.lookup;
     */
            source.similarityService,
import org.opensearch.script.Script;
    @Override
        int shardId,
 * GitHub history for details.
        return mapperService.getIndexAnalyzers();
        return getMapperService().searchQuoteAnalyzer();
    public Analyzer getSearchQuoteAnalyzer(MappedFieldType fieldType) {
    ) {
    }
            keywordIndexOrDocValuesEnabled
        String clusterAlias,
            xContentRegistry,
     * in other phases.
import org.opensearch.common.TriFunction;
 *
    }
            assert frozen.get() == null : frozen.get();
        SimilarityService similarityService,
    /** Return the current {@link IndexSearcher}, or {@code null} if no index reader is available,
import java.util.List;
            source.shardId,
    public IndexSearcher searcher() {
        return client;
        this.allowExpensiveQueries = allowExpensiveQueries;
        NamedWriteableRegistry namedWriteableRegistry,
 * Unless required by applicable law or agreed to in writing,
    public Version indexVersionCreated() {
        boolean keywordIndexOrDocValuesEnabled
            fullyQualifiedIndex.getName(),
import org.opensearch.Version;
     */
    }
        SimilarityService similarityService,
    public Analyzer getSearchAnalyzer(MappedFieldType fieldType) {
        boolean validate,
            getMapperService(),
    }
            mapperService,
import org.opensearch.core.common.ParsingException;
    /**
    }
            TextFieldMapper.Builder builder = new TextFieldMapper.Builder(name, mapperService.getIndexAnalyzers());
        return allowExpensiveQueries.getAsBoolean();
    public ValuesSourceRegistry getValuesSourceRegistry() {
        int shardId,
        return searcher == null ? null : searcher.getIndexReader();
    }
    /**
        NamedWriteableRegistry namedWriteableRegistry,
package org.opensearch.index.query;
        NamedXContentRegistry xContentRegistry,
    private final SetOnce<Boolean> frozen = new SetOnce<>();
    public Set<String> simpleMatchToIndexNames(String pattern) {
     *  may represent a fully qualified index name if the search targets remote shards.
        MapperService mapperService,
    public MapperService getMapperService() {
     */
import java.io.IOException;
        TriFunction<MappedFieldType, String, Supplier<SearchLookup>, IndexFieldData<?>> indexFieldDataLookup,
        LongSupplier nowInMillis,
    public SearchLookup newFetchLookup() {
        }
            source.indexSettings,
        return allMatchingFields;
 *
import org.apache.lucene.search.join.BitSetProducer;
            indexNameMatcher,
    private DerivedFieldResolver derivedFieldResolver;
 */
        }
    /**
        }
    public AggregationUsageService getUsageService() {
        return mapperService.sourcePath(fullName);
        );
import java.util.function.Predicate;
import org.opensearch.index.mapper.ContentPath;
     */
     * Returns the shard ID this context was created for.
            source.bigArrays,
        super.executeAsyncActions(listener);
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        String clusterAlias,
        this.derivedFieldResolver = DerivedFieldResolverFactory.createResolver(
            failIfFrozen();
        Client client,
    MappedFieldType failIfFieldMappingNotFound(String name, MappedFieldType fieldMapping) {
    private final IndexSearcher searcher;
import static java.util.Collections.unmodifiableMap;
    public void setParentFilter(BitSetProducer parentFilter) {
                query = Queries.newMatchNoDocsQuery("No query left after rewrite.");
    }
        return indexSettings.getIndexVersionCreated();
                getMapperService(),
    }
        }
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
            throw new QueryShardException(this, "No field mapping can be found for the field with name [{}]", name);
     */
    public NestedScope nestedScope() {
        this.mapUnmappedFieldAsString = mapUnmappedFieldAsString;
    }
    private StarTreeQueryContext starTreeQueryContext;
    }
    }
    public boolean indexMatches(String pattern) {
     */
        IndexSettings indexSettings,
            searcher,
            reset();
        ScriptService scriptService,
 * @opensearch.api
            bigArrays,
    }
    public boolean allowExpensiveQueries() {
        this.keywordIndexOrDocValuesEnabled = keywordIndexOrDocValuesEnabled;
        BigArrays bigArrays,
        this.mapperService = mapperService;
        if (fieldType.getTextSearchInfo().getSearchAnalyzer() != null) {
import org.opensearch.index.fielddata.IndexFieldData;
    private final MapperService mapperService;
import org.opensearch.transport.client.Client;
        BooleanSupplier allowExpensiveQueries,
        return mapperService.isMetadataField(field);
     *  for instance if this rewrite context is used to index queries (percolation). */
            bigArrays,
            (fieldType, searchLookup) -> indexFieldDataService.apply(fieldType, fullyQualifiedIndex.getName(), searchLookup),
 */
            source.searcher,
import org.opensearch.index.mapper.TextFieldMapper;
    public boolean queryStringAnalyzeWildcard() {
import org.opensearch.index.mapper.DerivedFieldResolver;
        BitsetFilterCache bitsetFilterCache,
                shardId
import org.opensearch.script.ScriptService;
    public MappedFieldType fieldMapper(String name) {
     * <p>
 * this work for additional information regarding copyright
        return toQuery(queryBuilder, q -> {
    ) {
    public final QueryShardContext convertToShardContext() {
    }
            new Index(
    }
import org.apache.lucene.search.IndexSearcher;
 * SPDX-License-Identifier: Apache-2.0
    }
    public void setInnerHitQuery(boolean isInnerHitQuery) {
        if (factory instanceof ScriptFactory && ((ScriptFactory) factory).isResultDeterministic() == false) {
        allMatchingFields.addAll(derivedFieldResolver.resolvePattern(pattern));
         * Real customization coming soon, I promise!
        return similarityService;
        this.parentFilter = parentFilter;
        );
    public ObjectMapper getObjectMapper(String name) {
        });
            this.lookup = new SearchLookup(
     * Get the lookup to use during the search.
            shardId,
     * Return the {@link BigArrays} instance for this node.
/**
            false
        return indexSettings.isQueryStringAllowLeadingWildcard();
        SimilarityService similarityService,
        return (IFD) indexFieldDataService.apply(
    }
import org.opensearch.common.CheckedFunction;
 * this file be licensed under the Apache-2.0 license or a
        try {
            namedWriteableRegistry,
            searcher,
        this(
    }
    /**
    private final Map<String, Query> namedQueries = new HashMap<>();
            source.mapperService,
        this.isInnerHitQuery = isInnerHitQuery;
 */
        failIfFrozen();
    public <IFD extends IndexFieldData<?>> IFD getForField(MappedFieldType fieldType) {
        BigArrays bigArrays,
            if (fieldMapping.unwrap() instanceof DerivedFieldType) {
    ) {
        this.namedQueries.clear();
        return failIfFieldMappingNotFound(name, mapperService.fieldType(name));
    }
    }
        int shardId,
        return fullyQualifiedIndex;
        BitsetFilterCache bitsetFilterCache,
        TriFunction<MappedFieldType, String, Supplier<SearchLookup>, IndexFieldData<?>> indexFieldDataLookup,
            );
        BigArrays bigArrays,
        } finally {
            scriptService,
import org.opensearch.script.ScriptFactory;
        return indexSettings.isQueryStringLenient();
import static java.util.Collections.emptyMap;
        NamedWriteableRegistry namedWriteableRegistry,
        this(
    }
import org.opensearch.index.query.support.NestedScope;
            source.indexFieldDataService,
            bitsetFilterCache,
            similarityService,
        }
         */
            indexFieldDataLookup,
            throw e;
        );
     * In case unmapped fields are allowed, null is returned when the field is not mapped.
        LongSupplier nowInMillis,
            client,
    public <FactoryType> FactoryType compile(Script script, ScriptContext<FactoryType> context) {
        );
        } else if ((fieldMapping = resolveDerivedFieldType(name)) != null) {
        if (query != null) {
        this(
import org.apache.lucene.search.Query;
    }
            ),
    public QueryShardContext(QueryShardContext source) {
        }
            ),
            source.keywordIndexOrDocValuesEnabled
        NamedXContentRegistry xContentRegistry,
import org.opensearch.common.SetOnce;
            clusterAlias,
    public QueryShardContext(
    public Map<String, Query> copyNamedQueries() {
        this.cacheable = isCacheable;
    }
        this.fullyQualifiedIndex = fullyQualifiedIndex;
     * TODO: remove this by moving defaults into mappers themselves
import org.opensearch.index.cache.bitset.BitsetFilterCache;
     * Build a lookup customized for the fetch phase. Use {@link #lookup()}
        BitsetFilterCache bitsetFilterCache,
    private void reset() {
    public MappedFieldType getFieldType(String name) {
public class QueryShardContext extends BaseQueryRewriteContext {
    }
        NamedWriteableRegistry namedWriteableRegistry,
    public SimilarityService getSimilarityService() {
    }
        IndexSearcher searcher,
            Query query = q.toQuery(this);
        return nestedScope;
    }
    @Override
     * type then the fields will be returned with a type prefix.
        return valuesSourceRegistry.getUsageService();
    private boolean mapUnmappedFieldAsString;
    }
        this.starTreeQueryContext = starTreeQueryContext;
 * Licensed to Elasticsearch under one or more contributor
    private final ValuesSourceRegistry valuesSourceRegistry;
        int shardId,
        return parentFilter;
 * compatible open source license.
        MapperService mapperService,
            () -> this.lookup().forkAndTrackFieldReferences(fieldType.name())
            xContentRegistry,
import java.util.function.BooleanSupplier;
            source.allowExpensiveQueries,
        return failIfFieldMappingNotFound(name, mapperService.fieldType(name));
        BooleanSupplier allowExpensiveQueries,
        this.indexSettings = indexSettings;
        } else {
            xContentRegistry,
        boolean validate
    }
 *
    }
     * TODO: remove this by moving defaults into mappers themselves
        IndexSettings indexSettings,
     * In case unmapped fields are not allowed, either an exception is thrown or the field is automatically mapped as a text field.
import org.opensearch.script.ScriptContext;
        return mapperService.getObjectMapper(name);
            mapperService,
 * specific language governing permissions and limitations
    }
    }
        ValuesSourceRegistry valuesSourceRegistry,
    }
        Predicate<String> indexNameMatcher,
        return mapperService.documentMapper();
     */
            bitsetFilterCache,
        return unmodifiableMap(new HashMap<>(namedQueries));
        IndexSearcher searcher,
    public Index index() {
            valuesSourceRegistry,
        if (fieldMapping != null) {
            bigArrays,
    }
    }
    }
                // resolveDerivedFieldType() will give precedence to search time definitions over index mapping, thus
    @Override
import org.opensearch.index.similarity.SimilarityService;
 * Modifications Copyright OpenSearch Contributors. See
            if (query == null) {
     */
    }
import org.opensearch.index.IndexSortConfig;
            return fieldMapping;
    private boolean isInnerHitQuery;
     */
            }
    public IndexReader getIndexReader() {
    /** Compile script using script service */
    public Similarity getSearchSimilarity() {
     */
        return searcher;
            source.getWriteableRegistry(),
import org.opensearch.index.mapper.ObjectMapper;
        return bitsetFilterCache;
    public void setKeywordFieldIndexOrDocValuesEnabled(boolean keywordIndexOrDocValuesEnabled) {
            this,
    }
     * Returns all the fields that match a given pattern. If prefixed with a
            valuesSourceRegistry,
    }
    /**
        super.registerAsyncAction(asyncAction);
    /**
        this.indexNameMatcher = indexNameMatcher;
import org.opensearch.core.xcontent.XContentParser;
    }
        BooleanSupplier allowExpensiveQueries,
     * @see QueryShardContext#setAllowUnmappedFields(boolean)
    public boolean keywordFieldIndexOrDocValuesEnabled() {
            shardId
        this.cacheable = false;
        Predicate<String> indexNameMatcher,
    ) {
 * software distributed under the License is distributed on an
    /**
        FactoryType factory = scriptService.compile(script, context);
        return keywordIndexOrDocValuesEnabled;
/*
            return fieldType.getTextSearchInfo().getSearchAnalyzer();
            source.bitsetFilterCache,
            source.getXContentRegistry(),
            scriptService,
    }
    private boolean allowUnmappedFields;
@PublicApi(since = "1.0.0")
    private QueryShardContext(
 */
    public Set<String> sourcePath(String fullName) {
    public void registerAsyncAction(BiConsumer<Client, ActionListener<?>> asyncAction) {
    public Index getFullyQualifiedIndex() {
        return indexSettings.getIndex();
     * Returns the fully qualified index including a remote cluster alias if applicable, and the index uuid
            client,
    /**
    /**
    public BitsetFilterCache getBitsetFilterCache() {
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.search.startree.StarTreeQueryContext;
     * Returns the index settings for this context. This might return null if the
import org.opensearch.common.lucene.search.Queries;
        BooleanSupplier allowExpensiveQueries,
    }
        LongSupplier nowInMillis,
            searcher,
            throw new QueryShardException(this, "failed to create query: {}", e, e.getMessage());
            allowExpensiveQueries,
            indexNameMatcher,
        boolean keywordIndexOrDocValuesEnabled
        return indexSettings.isQueryStringAnalyzeWildcard();
        return shardId;
                indexSettings.getIndex().getUUID()
        failIfFrozen(); // we somebody uses a terms filter with lookup for instance can't be cached...
        IndexSettings indexSettings,
    public IndexAnalyzers getIndexAnalyzers() {
     */
            source.valuesSourceRegistry,
        return mapperService;
    }
        this.allowUnmappedFields = indexSettings.isDefaultAllowUnmappedFields();
            source.scriptService,
            fieldType,
     * Gets the search analyzer for the given field, or the default if there is none present for the field
    private final ScriptService scriptService;
            allowExpensiveQueries,
            return fieldMapping;
        return indexSettings.getDefaultFields();
    public void setStarTreeQueryContext(StarTreeQueryContext starTreeQueryContext) {
    private NestedScope nestedScope;
        Client client,
        this.allowUnmappedFields = allowUnmappedFields;
        super(xContentRegistry, namedWriteableRegistry, client, nowInMillis, validate);
        this.frozen.set(Boolean.TRUE);
    public Client getClient() {
        return valuesSourceRegistry;
    }
        MapperService mapperService,
     * Returns s {@link DocumentMapper} instance.
        if (fieldType.getTextSearchInfo().getSearchQuoteAnalyzer() != null) {
            new Index(
import org.opensearch.search.aggregations.support.AggregationUsageService;
        ValuesSourceRegistry valuesSourceRegistry
    public QueryShardContext(
    /**
    public DocumentMapper documentMapper(String type) {
        } catch (Exception e) {
            source.client,
                RemoteClusterAware.buildRemoteIndexName(clusterAlias, indexSettings.getIndex().getName()),
            QueryBuilder rewriteQuery = Rewriteable.rewrite(queryBuilder, this, true);
import org.opensearch.index.mapper.DocumentMapper;
    }
        return bigArrays;
     *  Given an index pattern, checks whether it matches against the current shard. The pattern
            source.indexNameMatcher,
    private final IndexSettings indexSettings;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    @Override
        TriFunction<MappedFieldType, String, Supplier<SearchLookup>, IndexFieldData<?>> indexFieldDataLookup,
    /**
    public void setDerivedFieldResolver(DerivedFieldResolver derivedFieldResolver) {
        TriFunction<MappedFieldType, String, Supplier<SearchLookup>, IndexFieldData<?>> indexFieldDataLookup,
            shardId,
    private boolean keywordIndexOrDocValuesEnabled;
        this.nestedScope = new NestedScope(indexSettings);
        SimilarityService similarityService,
            source.fullyQualifiedIndex,
     * @see QueryShardContext#setMapUnmappedFieldAsString(boolean)
        return AbstractQueryBuilder.parseInnerQueryBuilder(parser);
    }
        BitsetFilterCache bitsetFilterCache,
import org.opensearch.core.xcontent.NamedXContentRegistry;
     * class cannot be bypassed. This is important so we can trust when this
        return super.nowInMillis();
import org.opensearch.search.lookup.SearchLookup;
        this.valuesSourceRegistry = valuesSourceRegistry;
            source.nowInMillis,
 * Context object used to create lucene queries on the shard level.
    public boolean queryStringAllowLeadingWildcard() {
        allowUnmappedFields = indexSettings.isDefaultAllowUnmappedFields();
    public final boolean isCacheable() {
import org.opensearch.core.index.Index;
        // This might be a good use case for CopyOnWriteHashMap
        BigArrays bigArrays,
import org.opensearch.index.analysis.IndexAnalyzers;
     */
        this.nestedScope = new NestedScope(indexSettings);
        IndexSortConfig indexSortConfig = indexSettings.getIndexSortConfig();
                return resolveDerivedFieldType(name);
    }
        } catch (QueryShardException | ParsingException e) {
            namedWriteableRegistry,
    }
    }
        IndexSettings indexSettings,
        if (frozen.get() == Boolean.TRUE) {
     * setting the request as not cacheable and the freezing behaviour of this
        this.lookup = null;
        ScriptService scriptService,
        Client client,
    }
            emptyList(),
import java.util.function.Supplier;
     * This methods and all methods that call it should be final to ensure that
    }
        IndexSearcher searcher,
            bitsetFilterCache,
        return indexNameMatcher.test(pattern);
        Predicate<String> indexNameMatcher,
    public BitSetProducer bitsetFilter(Query filter) {
            emptyMap(),
 * under the License.
    public SearchLookup lookup() {
    protected final void failIfFrozen() {
    public final long nowInMillis() {
 * KIND, either express or implied.  See the License for the
     * context has not index scope.
import java.util.function.LongSupplier;
        failIfFrozen();
    }
        ScriptService scriptService,
     * Returns the {@link MappedFieldType} for the provided field name.
    public MappedFieldType resolveDerivedFieldType(String name) {
        return factory;
     *  for instance if this rewrite context is used to index queries (percolation). */
import org.opensearch.index.mapper.Mapper;
import org.opensearch.index.IndexSettings;
import org.opensearch.transport.RemoteClusterAware;
        this.similarityService = similarityService;
                (fieldType, searchLookup) -> indexFieldDataService.apply(fieldType, fullyQualifiedIndex.getName(), searchLookup),
import org.apache.lucene.search.similarities.Similarity;
    private final Index fullyQualifiedIndex;
        failIfFrozen();
            mapperService,
    public boolean queryStringLenient() {
        String clusterAlias,
            valuesSourceRegistry,
                // calling it instead of directly returning. It also ensures the feature flags are honoured.
        }
    /**
    public boolean indexSortedOnField(String field) {
        Predicate<String> indexNameMatcher,
    private ParsedQuery toQuery(QueryBuilder queryBuilder, CheckedFunction<QueryBuilder, Query, IOException> filterOrQuery) {
    public ParsedQuery toQuery(QueryBuilder queryBuilder) {
    public void addNamedQuery(String name, Query query) {
    }
            throw new IllegalArgumentException("features that prevent cachability are disabled on this context");
        NamedXContentRegistry xContentRegistry,
     * that could yield different results across executions like {@link #getClient()}
    }
        } else if (allowUnmappedFields) {
        boolean validate,
import java.util.function.BiConsumer;
    }
import org.opensearch.index.mapper.MappedFieldType;
        return this;
        Client client,
 * You may obtain a copy of the License at
            similarityService,
import org.opensearch.index.mapper.DerivedFieldResolverFactory;
     */
        );
    public final void freezeContext() {
import java.util.Map;
                RemoteClusterAware.buildRemoteIndexName(clusterAlias, indexSettings.getIndex().getName()),
import org.opensearch.index.mapper.MapperService;
 * the Apache License, Version 2.0 (the "License"); you may
     * @throws QueryShardException if unmapped fields are not allowed and automatically mapping unmapped fields as text is disabled.
     * Return the MapperService.
 * The OpenSearch Contributors require contributions made to
    public IndexSettings getIndexSettings() {
    public BigArrays bigArrays() {
            indexFieldDataLookup,
import org.opensearch.common.annotation.PublicApi;
            indexSettings.isDerivedFieldAllowed()
            validate,
            nowInMillis,
        Set<String> allMatchingFields = new HashSet<>(mapperService.simpleMatchToFullName(pattern));
     * if this method is called the query context will throw exception if methods are accessed
