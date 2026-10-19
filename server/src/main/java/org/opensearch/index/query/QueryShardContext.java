            client,
import org.opensearch.script.ScriptContext;
        this.frozen.set(Boolean.TRUE);
        ScriptService scriptService,  
        );  
        this.mapUnmappedFieldAsString = mapUnmappedFieldAsString;
            namedWriteableRegistry,
    public Set<String> sourcePath(String fullName) {  
        if (factory instanceof ScriptFactory && ((ScriptFactory) factory).isResultDeterministic() == false) {  
        return allowExpensiveQueries.getAsBoolean();
        this.lookup = null;  
import org.apache.lucene.search.Query;
import org.apache.lucene.analysis.Analyzer;
        BitsetFilterCache bitsetFilterCache,
        NamedXContentRegistry xContentRegistry,
    private final BooleanSupplier allowExpensiveQueries;
        return mapperService.documentMapper();  
        failIfFrozen(); // we somebody uses a terms filter with lookup for instance can't be cached...  
            source.keywordIndexOrDocValuesEnabled
 *
    public BitSetProducer getParentFilter() {  
    public Index getFullyQualifiedIndex() {
    public boolean indexSortedOnField(String field) {  
    }  
        return indexSettings;  
        SimilarityService similarityService,
            namedWriteableRegistry,  
    public void setAllowUnmappedFields(boolean allowUnmappedFields) {
            Query query = q.toQuery(this);
            mapperService,
import org.opensearch.core.xcontent.NamedXContentRegistry;  
     * Returns <code>true</code> iff the result of the processed search request is cacheable. Otherwise <code>false</code>  
        if (frozen.get() == Boolean.TRUE) {
    public void setDerivedFieldResolver(DerivedFieldResolver derivedFieldResolver) {
        NamedWriteableRegistry namedWriteableRegistry,
        IndexSettings indexSettings,
        return starTreeQueryContext;
            source.searcher,
                indexSettings.getIndex().getUUID()
        String clusterAlias,  
            client,
    private final Index fullyQualifiedIndex;  
     * If the field is not mapped, the behaviour depends on the index.query.parse.allow_unmapped_fields setting, which defaults to true.
            return query;
     */
    public boolean queryStringAnalyzeWildcard() {  
    private boolean allowUnmappedFields;
 * this work for additional information regarding copyright
            failIfFrozen();
import org.apache.lucene.search.similarities.Similarity;  
        SimilarityService similarityService,
        int shardId,
            (fieldType, searchLookup) -> indexFieldDataService.apply(fieldType, fullyQualifiedIndex.getName(), searchLookup),  
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
        return this.lookup;
            if (fieldMapping.unwrap() instanceof DerivedFieldType) {  
        allMatchingFields.addAll(derivedFieldResolver.resolvePattern(pattern));
            if (query == null) {
                indexSettings.getIndex().getUUID()  
    private boolean mapUnmappedFieldAsString;  
    }
     * Returns the index settings for this context. This might return null if the
import org.opensearch.index.mapper.MapperService;
            ),
        return getMapperService().searchAnalyzer();
    public void setKeywordFieldIndexOrDocValuesEnabled(boolean keywordIndexOrDocValuesEnabled) {
        ValuesSourceRegistry valuesSourceRegistry,  
            emptyMap(),  
            emptyList(),
    /**
            allowExpensiveQueries,  
    /**
    private boolean isInnerHitQuery;  
     * In case unmapped fields are allowed, null is returned when the field is not mapped.
        return nestedScope;  
            nowInMillis,
        Client client,
            similarityService,  
        this.indexNameMatcher = indexNameMatcher;  
     */
        this.indexFieldDataService = indexFieldDataLookup;  
            source.scriptService,  
            source.mapperService,
    }  
    public AggregationUsageService getUsageService() {
 * compatible open source license.
        return mapperService.getIndexAnalyzers();  
     */
     * TODO: remove this by moving defaults into mappers themselves
     */  
    }
 */  
     */
/*
    private final int shardId;
import org.opensearch.index.similarity.SimilarityService;  
import org.apache.lucene.search.join.BitSetProducer;
    }  
                (fieldType, searchLookup) -> indexFieldDataService.apply(fieldType, fullyQualifiedIndex.getName(), searchLookup),
                RemoteClusterAware.buildRemoteIndexName(clusterAlias, indexSettings.getIndex().getName()),  
        this.bitsetFilterCache = bitsetFilterCache;
    /** Return the current {@link IndexReader}, or {@code null} if no index reader is available,
            );  
    }
    }
    public ParsedQuery toQuery(QueryBuilder queryBuilder) {
    }
import org.opensearch.search.startree.StarTreeQueryContext;
     * Return the {@link BigArrays} instance for this node.  
import java.util.function.BooleanSupplier;
        TriFunction<MappedFieldType, String, Supplier<SearchLookup>, IndexFieldData<?>> indexFieldDataLookup,
        return AbstractQueryBuilder.parseInnerQueryBuilder(parser);
    public QueryShardContext(QueryShardContext source) {  
            indexNameMatcher,
     * Delegates to {@link MapperService#documentMapper()}  
            xContentRegistry,
            indexNameMatcher,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Map;
    }  
    }
     * Returns the fully qualified index including a remote cluster alias if applicable, and the index uuid
import java.util.HashMap;
    public IndexSettings getIndexSettings() {
    private final ValuesSourceRegistry valuesSourceRegistry;
import org.opensearch.core.xcontent.XContentParser;
        return super.nowInMillis();
    }
        MapperService mapperService,
        LongSupplier nowInMillis,
     *  Given an index pattern, checks whether it matches against the current shard. The pattern
import java.util.HashSet;
    /**
        this.similarityService = similarityService;
import org.opensearch.search.lookup.SearchLookup;
import org.opensearch.index.IndexSettings;
        this.allowExpensiveQueries = allowExpensiveQueries;
            allowExpensiveQueries,
        NamedWriteableRegistry namedWriteableRegistry,
         */  
 * SPDX-License-Identifier: Apache-2.0
    }
 *  
        this.valuesSourceRegistry = valuesSourceRegistry;  
import java.util.Set;
            valuesSourceRegistry,  
    public Version indexVersionCreated() {  
    public void registerAsyncAction(BiConsumer<Client, ActionListener<?>> asyncAction) {  
            source.indexNameMatcher,  
 * software distributed under the License is distributed on an
        IndexSettings indexSettings,
     * Returns the shard ID this context was created for.
        BitsetFilterCache bitsetFilterCache,
        return this;
    private void reset() {
        return similarityService != null ? similarityService.similarity(mapperService) : null;
    public IndexAnalyzers getIndexAnalyzers() {
import org.opensearch.common.annotation.PublicApi;
 * Context object used to create lucene queries on the shard level.
            source.nowInMillis,
            similarityService,  
        boolean validate,
    private final IndexSearcher searcher;
        this.fullyQualifiedIndex = fullyQualifiedIndex;
        FactoryType factory = scriptService.compile(script, context);
        if (fieldType.getTextSearchInfo().getSearchAnalyzer() != null) {
     * Gets the search quote analyzer for the given field, or the default if there is none present for the field  
    }
            source.validate(),
     * In case unmapped fields are not allowed, either an exception is thrown or the field is automatically mapped as a text field.  
            this.lookup = new SearchLookup(
    }  
            source.client,  
        int shardId,
@PublicApi(since = "1.0.0")  
        this.derivedFieldResolver = DerivedFieldResolverFactory.createResolver(
    }
     * setting the request as not cacheable and the freezing behaviour of this
/**
            fullyQualifiedIndex.getName(),
        this.keywordIndexOrDocValuesEnabled = keywordIndexOrDocValuesEnabled;
                // calling it instead of directly returning. It also ensures the feature flags are honoured.
import org.opensearch.common.lucene.search.Queries;  
         * Real customization coming soon, I promise!
            source.indexFieldDataService,  
import org.opensearch.transport.RemoteClusterAware;  
    public void addNamedQuery(String name, Query query) {
        Predicate<String> indexNameMatcher,  
     */
import org.opensearch.transport.client.Client;
 * the Apache License, Version 2.0 (the "License"); you may
    }
        BigArrays bigArrays,
        );  
        return indexSettings.getDefaultFields();
import org.apache.lucene.index.IndexReader;
     * that could yield different results across executions like {@link #getClient()}
        Client client,  
        return fullyQualifiedIndex;
        boolean validate,  
        return derivedFieldResolver.resolve(name);
import org.opensearch.core.action.ActionListener;
        ValuesSourceRegistry valuesSourceRegistry,
        return indexSettings.getIndexVersionCreated();
        Client client,
     * Returns s {@link DocumentMapper} instance.
        return searcher == null ? null : searcher.getIndexReader();
    }
        return cacheable;  
        MapperService mapperService,  
        BooleanSupplier allowExpensiveQueries,
    }
 * KIND, either express or implied.  See the License for the
            throw new QueryShardException(this, "failed to create query: {}", e, e.getMessage());
        NamedXContentRegistry xContentRegistry,  
        } else {
        Client client,  
        String clusterAlias,
    /**  
    public BigArrays bigArrays() {
import org.opensearch.index.mapper.MappedFieldType;  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
    }
        BitsetFilterCache bitsetFilterCache,
            bigArrays,
    @Override
    public int getShardId() {
        return searcher;
        );
    /**
        return new SearchLookup(
    public final void freezeContext() {
    public void setMapUnmappedFieldAsString(boolean mapUnmappedFieldAsString) {  
    public <FactoryType> FactoryType compile(Script script, ScriptContext<FactoryType> context) {
    private SearchLookup lookup = null;
import org.opensearch.common.TriFunction;
        this.allowUnmappedFields = indexSettings.isDefaultAllowUnmappedFields();
        super.executeAsyncActions(listener);
     * context has not index scope.  
    }  
    public Analyzer getSearchQuoteAnalyzer(MappedFieldType fieldType) {  
        BigArrays bigArrays,  
     * @see QueryShardContext#setMapUnmappedFieldAsString(boolean)  
 */  
        } else if ((fieldMapping = resolveDerivedFieldType(name)) != null) {  
            xContentRegistry,
        return valuesSourceRegistry;
        this.shardId = shardId;
    public BitSetProducer bitsetFilter(Query filter) {
            indexSettings,  
            bitsetFilterCache,  
     *  for instance if this rewrite context is used to index queries (percolation). */
    }
import org.opensearch.index.mapper.DerivedFieldResolver;
    }  
        return indexSettings.isQueryStringAllowLeadingWildcard();
        return toQuery(queryBuilder, q -> {  
    }
        );  
     */
    private NestedScope nestedScope;
        BooleanSupplier allowExpensiveQueries,
    }
            bitsetFilterCache,  
        this.nestedScope = new NestedScope(indexSettings);
        );  
        allowUnmappedFields = indexSettings.isDefaultAllowUnmappedFields();
            false
    /** Compile script using script service */  
    /**
            mapperService,
            return builder.build(new Mapper.BuilderContext(indexSettings.getSettings(), new ContentPath(1))).fieldType();  
        return shardId;
    ) {
        ScriptService scriptService,
     * This method fails if {@link #freezeContext()} is called before on this  
import org.opensearch.index.mapper.Mapper;
    public MapperService getMapperService() {  
        String clusterAlias,  
    public MappedFieldType fieldMapper(String name) {  
    }
import java.io.IOException;  
            indexFieldDataLookup,
     */  
     * Returns all the fields that match a given pattern. If prefixed with a
            namedQueries.put(name, query);
        LongSupplier nowInMillis,
        return similarityService;
        }
            shardId,
import org.opensearch.index.cache.bitset.BitsetFilterCache;
        Index fullyQualifiedIndex,  
            source.valuesSourceRegistry,  
        ScriptService scriptService,
    }
            fieldType,  
public class QueryShardContext extends BaseQueryRewriteContext {
    }  
    }
        }  
        failIfFrozen();
        } else if (allowUnmappedFields) {
        return bitsetFilterCache;
 */
    }
import java.util.function.BiConsumer;  
        LongSupplier nowInMillis,
            return new ParsedQuery(filterOrQuery.apply(rewriteQuery), copyNamedQueries());
        return isInnerHitQuery;  
            bitsetFilterCache,
        NamedWriteableRegistry namedWriteableRegistry,
    /**
        this.cacheable = isCacheable;
        ScriptService scriptService,  
        super.registerAsyncAction(asyncAction);
            source.similarityService,
 * this file be licensed under the Apache-2.0 license or a
        return allMatchingFields;
     * class cannot be bypassed. This is important so we can trust when this
    public SimilarityService getSimilarityService() {  
        return keywordIndexOrDocValuesEnabled;
 * under the License.  
    /**  
            getMapperService(),
        return indexSortConfig.hasPrimarySortOnField(field);
        this(
        boolean validate  
        SimilarityService similarityService,
    private ParsedQuery toQuery(QueryBuilder queryBuilder, CheckedFunction<QueryBuilder, Query, IOException> filterOrQuery) {  
        MapperService mapperService,  
            shardId,  
import org.opensearch.index.mapper.TextFieldMapper;
    protected final void failIfFrozen() {
        Predicate<String> indexNameMatcher,
    public boolean keywordFieldIndexOrDocValuesEnabled() {  
    }
            }
    private final BigArrays bigArrays;
    public Index index() {
        return mapperService.getObjectMapper(name);
        return mapperService;
            nowInMillis,  
    }
        );
        this.keywordIndexOrDocValuesEnabled = keywordIndexOrDocValuesEnabled;
    }
import org.opensearch.search.aggregations.support.AggregationUsageService;
    }  
    public boolean allowExpensiveQueries() {  
    /**
     * @see QueryShardContext#setAllowUnmappedFields(boolean)
 *    http://www.apache.org/licenses/LICENSE-2.0
            assert frozen.get() == null : frozen.get();
    public boolean queryStringAllowLeadingWildcard() {
        this.starTreeQueryContext = starTreeQueryContext;
            source.shardId,
    public final long nowInMillis() {  
    private final Predicate<String> indexNameMatcher;
            ),
            return fieldType.getTextSearchInfo().getSearchAnalyzer();  
                return resolveDerivedFieldType(name);  
    public Set<String> simpleMatchToIndexNames(String pattern) {
    private QueryShardContext(  
    }
        IndexSettings indexSettings,  
            client,  
    private final MapperService mapperService;  
import org.opensearch.Version;
        this(
    public void setParentFilter(BitSetProducer parentFilter) {
    }
import org.opensearch.common.util.BigArrays;
     * Returns the {@link MappedFieldType} for the provided field name.  
            shardId
    private final SetOnce<Boolean> frozen = new SetOnce<>();
        failIfFrozen();
        return valuesSourceRegistry.getUsageService();  
     */  
            searcher,
     * in other phases.
            throw new QueryShardException(this, "No field mapping can be found for the field with name [{}]", name);
    }
        if (query != null) {  
    public IndexSearcher searcher() {  
            namedWriteableRegistry,  
 * The OpenSearch Contributors require contributions made to  
    }  
        failIfFrozen();
    /**
    @Override
import java.util.function.Predicate;  
    public StarTreeQueryContext getStarTreeQueryContext() {  
            source.allowExpensiveQueries,
    }
import static java.util.Collections.unmodifiableMap;
import org.opensearch.index.mapper.DerivedFieldResolverFactory;  
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
     */  
    public <IFD extends IndexFieldData<?>> IFD getForField(MappedFieldType fieldType) {
            return fieldType.getTextSearchInfo().getSearchQuoteAnalyzer();
        } catch (QueryShardException | ParsingException e) {
     * Gets the search analyzer for the given field, or the default if there is none present for the field
import org.opensearch.core.index.Index;
        } catch (Exception e) {
    }  
            source.getXContentRegistry(),
    }
     * TODO: remove this by moving defaults into mappers themselves
    }
            new Index(
            reset();
    }
    public QueryBuilder parseInnerQueryBuilder(XContentParser parser) throws IOException {
    @Override
            throw new IllegalArgumentException("features that prevent cachability are disabled on this context");
    private BitSetProducer parentFilter;  
        BitsetFilterCache bitsetFilterCache,
        boolean keywordIndexOrDocValuesEnabled
        IndexSearcher searcher,
        return client;
import static java.util.Collections.emptyList;  
        this.searcher = searcher;
        SimilarityService similarityService,
 * @opensearch.api
        ValuesSourceRegistry valuesSourceRegistry,
    ) {  
    ) {
            source.bigArrays,
            source.bitsetFilterCache,
        this.bigArrays = bigArrays;
        }
     * class says a request can be cached.  
    }
    }  
     */
            bigArrays,
    }
    }
    @Override
     */
    }  
            this,
        IndexSearcher searcher,  
    private final ScriptService scriptService;  
    }  
            return fieldMapping;
 * not use this file except in compliance with the License.
    /**
        return failIfFieldMappingNotFound(name, mapperService.fieldType(name));
        // This might be a good use case for CopyOnWriteHashMap  
            indexFieldDataLookup,  
        return (IFD) indexFieldDataService.apply(
/*  
    }
    public MappedFieldType resolveDerivedFieldType(String name) {  
import java.util.function.LongSupplier;
            clusterAlias,
    }  
        return unmodifiableMap(new HashMap<>(namedQueries));
    }
    public void executeAsyncActions(ActionListener listener) {  
            source.indexSettings,  
        IndexSortConfig indexSortConfig = indexSettings.getIndexSortConfig();
    public boolean isMetadataField(String field) {
     * This methods and all methods that call it should be final to ensure that  
import org.opensearch.script.Script;
        if (this.lookup == null) {
    public Map<String, Query> copyNamedQueries() {
    public void setStarTreeQueryContext(StarTreeQueryContext starTreeQueryContext) {
        IndexSearcher searcher,
    private final SimilarityService similarityService;
    /**
        IndexSearcher searcher,  
        reset();
        LongSupplier nowInMillis,
        return mapperService.sourcePath(fullName);
        }  
            QueryBuilder rewriteQuery = Rewriteable.rewrite(queryBuilder, this, true);  
            xContentRegistry,
import org.opensearch.index.analysis.IndexAnalyzers;
    }
                shardId
        }
    }
        this.allowUnmappedFields = allowUnmappedFields;  
        return indexNameMatcher.test(pattern);  
        return factory;  
    }  
 * license agreements. See the NOTICE file distributed with
        return failIfFieldMappingNotFound(name, mapperService.fieldType(name));  
        BooleanSupplier allowExpensiveQueries,
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;  
    private final IndexSettings indexSettings;
    public final void setIsCacheable(boolean isCacheable) {  
            return fieldMapping;  
        NamedXContentRegistry xContentRegistry,  
    }
        /*
     *  for instance if this rewrite context is used to index queries (percolation). */
import java.util.function.Supplier;
            indexSettings.isDerivedFieldAllowed()
        int shardId,
    private final TriFunction<MappedFieldType, String, Supplier<SearchLookup>, IndexFieldData<?>> indexFieldDataService;  
            scriptService,
import java.util.List;  
    }  
        return indexSettings.getIndex();  
import org.opensearch.index.mapper.DocumentMapper;
        MapperService mapperService,
import org.opensearch.script.ScriptService;
        this.indexSettings = indexSettings;
    }  
package org.opensearch.index.query;
 *  
        Predicate<String> indexNameMatcher,
    }
        this.parentFilter = parentFilter;
        return parentFilter;
    /**  
                getMapperService(),  
        TriFunction<MappedFieldType, String, Supplier<SearchLookup>, IndexFieldData<?>> indexFieldDataLookup,  
import org.opensearch.index.query.support.NestedScope;
            indexSettings,
    }
        boolean keywordIndexOrDocValuesEnabled
        NamedWriteableRegistry namedWriteableRegistry,
        this.namedQueries.clear();
import org.opensearch.index.IndexSortConfig;  
    public BitsetFilterCache getBitsetFilterCache() {
    }  
        }
        } finally {  
            false  
            return fieldMapping;
        }
    public final QueryShardContext convertToShardContext() {  
    public NestedScope nestedScope() {
                // resolveDerivedFieldType() will give precedence to search time definitions over index mapping, thus
     *  may represent a fully qualified index name if the search targets remote shards.  
            }
        Set<String> allMatchingFields = new HashSet<>(mapperService.simpleMatchToFullName(pattern));  
            mapperService,
                query = Queries.newMatchNoDocsQuery("No query left after rewrite.");  
        return bitsetFilterCache.getBitSetProducer(filter);  
    }  
            valuesSourceRegistry,
            nowInMillis,  
    public Analyzer getSearchAnalyzer(MappedFieldType fieldType) {
    public Client getClient() {
        try {
    public ObjectMapper getObjectMapper(String name) {
        return getMapperService().searchQuoteAnalyzer();
    }
    }  
    /**
            allowExpensiveQueries,  
        NamedXContentRegistry xContentRegistry,
    ) {
    public List<String> defaultFields() {
        ValuesSourceRegistry valuesSourceRegistry  
            validate,
            similarityService,
    public boolean isInnerHitQuery() {
    public IndexReader getIndexReader() {  
import static java.util.Collections.emptyMap;
     * Return the MapperService.
    public final boolean isCacheable() {
        this.mapperService = mapperService;  
        this.cacheable = false;  
            scriptService,
            indexNameMatcher,  
            searcher,
import org.opensearch.index.mapper.ObjectMapper;  
        this(
    }
    }  
    public QueryShardContext(
import org.opensearch.core.common.ParsingException;  
            shardId,  
        return mapperService.isMetadataField(field);  
            scriptService,  
            validate,
            TextFieldMapper.Builder builder = new TextFieldMapper.Builder(name, mapperService.getIndexAnalyzers());
     * Build a lookup customized for the fetch phase. Use {@link #lookup()}  
    }
        IndexSettings indexSettings,  
    private final BitsetFilterCache bitsetFilterCache;
import org.opensearch.common.CheckedFunction;
    MappedFieldType failIfFieldMappingNotFound(String name, MappedFieldType fieldMapping) {
    public MappedFieldType getFieldType(String name) {
                RemoteClusterAware.buildRemoteIndexName(clusterAlias, indexSettings.getIndex().getName()),
        TriFunction<MappedFieldType, String, Supplier<SearchLookup>, IndexFieldData<?>> indexFieldDataLookup,
import org.opensearch.common.SetOnce;  
import org.opensearch.index.fielddata.IndexFieldData;  
     * Get the lookup to use during the search.
            new Index(
    }  
        return indexSettings.isQueryStringLenient();  
        } else if (mapUnmappedFieldAsString) {
    public ValuesSourceRegistry getValuesSourceRegistry() {
     */
    }
     */
            indexFieldDataLookup,
            () -> this.lookup().forkAndTrackFieldReferences(fieldType.name())
 *
    public QueryShardContext(  
        this.derivedFieldResolver = derivedFieldResolver;  
 * GitHub history for details.
        this.isInnerHitQuery = isInnerHitQuery;
}  
     * <p>
        if (fieldMapping != null) {
    private DerivedFieldResolver derivedFieldResolver;
    /**
        return bigArrays;  
        this(
            keywordIndexOrDocValuesEnabled
        }
    private final Map<String, Query> namedQueries = new HashMap<>();
        BooleanSupplier allowExpensiveQueries,
        super(xContentRegistry, namedWriteableRegistry, client, nowInMillis, validate);  
    public boolean indexMatches(String pattern) {
        this.nestedScope = new NestedScope(indexSettings);
    private boolean cacheable = true;  
    public boolean queryStringLenient() {
    private boolean keywordIndexOrDocValuesEnabled;
     * type then the fields will be returned with a type prefix.  
import org.apache.lucene.search.IndexSearcher;  
    private StarTreeQueryContext starTreeQueryContext;
        Predicate<String> indexNameMatcher,
     * if this method is called the query context will throw exception if methods are accessed
 */
        return indexSettings.isQueryStringAnalyzeWildcard();
            indexSettings,
            source.getWriteableRegistry(),
/*  
            bigArrays,
        );  
        TriFunction<MappedFieldType, String, Supplier<SearchLookup>, IndexFieldData<?>> indexFieldDataLookup,  
        });  
 * specific language governing permissions and limitations
    /** Return the current {@link IndexSearcher}, or {@code null} if no index reader is available,
     * @throws QueryShardException if unmapped fields are not allowed and automatically mapping unmapped fields as text is disabled.
        BigArrays bigArrays,
    public QueryShardContext(
    public DocumentMapper documentMapper(String type) {
    }
    /**  
import org.opensearch.index.mapper.ContentPath;
            searcher,
    public SearchLookup newFetchLookup() {  
    public SearchLookup lookup() {  
    }  
    public Similarity getSearchSimilarity() {  
import org.opensearch.index.mapper.DerivedFieldType;
            throw e;  
        } else {  
    public void setInnerHitQuery(boolean isInnerHitQuery) {  
     */
        int shardId,
     */
import org.opensearch.script.ScriptFactory;  
        if (fieldType.getTextSearchInfo().getSearchQuoteAnalyzer() != null) {
            valuesSourceRegistry,
        BigArrays bigArrays,  
 * You may obtain a copy of the License at  
            source.fullyQualifiedIndex,
     * context. This is used to <i>seal</i>.
        this.scriptService = scriptService;  
