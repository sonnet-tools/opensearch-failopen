        for (int index = 0; index < context.docIdsToLoadSize(); index++) {  
            context.mapperService(),
import org.opensearch.search.fetch.subphase.InnerHitsContext;
 * this file be licensed under the Apache-2.0 license or a
     */
        for (InnerHitsContext.InnerHitSubContext innerHit : innerHits.values()) {
        for (Map.Entry<String, List<Object>> entry : fieldsVisitor.fields().entrySet()) {
            }
            // structure with the nested json array object being the actual content. The latter is important, so that
                if (rootFieldsVisitor.source() != null) {  
                            Object segmentKey = lf.getCoreCacheHelper() != null ? lf.getCoreCacheHelper().getKey() : currentReaderContext;
            } else {  
        DocIdToIndex[] docs = new DocIdToIndex[context.docIdsToLoadSize()];
        }
                int readerIndex = ReaderUtil.subIndex(docId, context.searcher().getIndexReader().leaves());  
import org.opensearch.core.tasks.TaskCancelledException;
                    FetchProfileBreakdown pbd = processorProfiles.get(p.v1());  
            return null;
            }  
import org.apache.lucene.index.LeafReaderContext;
    private static boolean sourcePathOverlap(String exclude, String include) {
        Map<String, Set<String>> storedToRequestedFields,
import org.opensearch.search.lookup.SourceLookup;  
            () -> createStoredFieldsVisitor(context, storedToRequestedFields)
            // no fields specified, default to return source if no explicit indication  
                for (Tuple<FetchSubPhaseProcessor, FetchSubPhase> p : processors) {
        FetchProfileBreakdown breakdown
                if (currentReaderIndex != readerIndex) {
                        .filter(Objects::nonNull)
     * Recursively collects the source fields requested by the given inner hits and their nested  
                profile(breakdown, FetchTimingType.LOAD_SOURCE, () -> {
             * Starts from the previous parent and finds the offset of the
                subReaderContext,
        SearchContext context,
import java.util.Arrays;
            }
     * empty values for the field it requested. Comparing per segment also keeps {@code *} from spanning a
        FetchProfileBreakdown breakdown
    }  
            nestedObjectMapper
                    FetchProfileBreakdown pb = context.getProfilers()  
            int previousParent = parentBits.prevSetBit(currentParent);
                SourceLookup rootLookup = innerHitsContext.getRootLookup();
            int docId = docs[index].docId;
                .hits(new SearchHits(new SearchHit[0], context.queryResult().getTotalHits(), context.queryResult().getMaxScore()));
                breakdown  
            }  
            return null;
             * that appear before him.
import org.opensearch.search.profile.fetch.FetchProfileBreakdown;
        String[] requestSourceExcludes = hasFetchContext ? context.fetchSourceContext().excludes() : null;  
                    current.put(nestedPath, next);
        fieldReader.accept(docId, fieldVisitor);  
        SearchLookup lookup,
                    currentReaderContext,  
                );
        if (breakdown != null) {  
        LeafReaderContext subReaderContext,  
import org.opensearch.common.xcontent.support.XContentMapValues;
                        requestedFields.add(fieldName);
import org.apache.lucene.index.ReaderUtil;
        FetchProfileBreakdown breakdown
        SearchLookup lookup,
                breakdown = fetchProfiler.startFetchPhase(profileDescription);
                );  
                requestSourceIncludes,
        // because the entire _source is only stored with the root document.  
            if (context.docIdsToLoadSize() > 0) {  
        }
import org.opensearch.common.collect.Tuple;
                            p.v1().setNextReader(readerCtx);  
 */  
        FieldsVisitor fieldsVisitor,  
import org.apache.logging.log4j.Logger;
        }
 * the Apache License, Version 2.0 (the "License"); you may
        // Also if highlighting is requested on nested documents we need to fetch the _source from the root document,
            }
                        FetchProfileBreakdown pbd = processorProfiles.get(p.v1());  
import java.util.ArrayList;
    public void execute(SearchContext context, String profileDescription) {
}
            }
                } else {
        final Map<String, InnerHitsContext.InnerHitSubContext> innerHits = context.innerHits().getInnerHits();  
                    breakdown
    }
        HitContext hitContext = new HitContext(hit, subReaderContext, nestedDocId, new SourceLookup());  // Use a clean, fresh SourceLookup  
        } while (current != null);
             */  
            Map<String, Object> current = nestedSourceAsMap;  
 */
                        metaFields.put(requestedField, new DocumentField(requestedField, storedValues));
        // every field must remain, so no codec excludes apply.
                storedToRequestedFields,  
            if (needSource) {
                }
        fieldVisitor.postProcess(fieldTypeLookup);
        return -1;  
 * after reducing all the matches returned by the query phase  
                }
            boolean loadSource = sourceRequired(context);
                fieldsVisitor,  
            BitSet childIter = context.bitsetFilterCache()  
            context,
                    if (fieldType == null) {  
    ) throws IOException {  
                    }  
        SearchHit.NestedIdentity nestedIdentity = null;
            }  
import org.opensearch.common.CheckedSupplier;
                        .startSubPhase(p.v2().getClass().getSimpleName(), profileDescription);
import org.apache.logging.log4j.LogManager;
import org.opensearch.search.profile.fetch.FetchProfiler;  
            // to a json object array for consistency reasons on how we refer to fields
            nestedDocId,
                hits[docs[index].index] = hit.hit();  
        // make sure that we iterate in doc id order  
                    processors.add(new Tuple<>(processor, fsp));
        );  
            // disable stored fields entirely  
            FetchFieldsContext innerFetchContext = innerHit.fetchFieldsContext();
        // context.innerHits won't throw NPE as it creates an empty innerhitscontext if its null
            if (childIter == null) {  
                Collection<String> fieldNames = context.mapperService().simpleMatchToFullName(fieldNameOrPattern);  
import org.opensearch.search.internal.SearchContext;
            return prepareNestedHitContext(
 *
                        LeafReaderContext readerCtx = currentReaderContext;
        Map<FetchSubPhaseProcessor, FetchProfileBreakdown> processorProfiles = new HashMap<>();
            // Nested inner hits read from the same root _source, so descend into their children too.
                    // nested field has an array value in the _source
 * compatible open source license.
 * Fetch phase of a search request, used to fetch the actual top matching documents to be returned to the client, identified
import org.opensearch.search.fetch.subphase.FetchFieldsContext;  
        FieldsVisitor fieldVisitor,
                lookup,
        if (LOGGER.isTraceEnabled()) {
                }  
                docId,
            }
        Map<String, DocumentField> metaFields  
        final int docId;  
        return nestedIdentity;
        }
        Map<String, DocumentField> metaFields = emptyMap();
                    // When one of the parent objects are not nested then XContentMapValues.extractValue(...) extracts the values  
        FieldsVisitor fieldsVisitor,  
import org.opensearch.index.mapper.SourceFieldMapper;  
                storedToRequestedFields,
        if (collectInnerHitIncludes(innerHits, requestIncludes)) {  
    private boolean sourceRequired(SearchContext context) {
                return bits.nextSetBit(subDocId);  
        DocumentMapper documentMapper = context.mapperService().documentMapper();
                        if (context.scrollContext() != null) {
import org.opensearch.core.common.util.CollectionUtils;  
                } else {
                        // For scroll queries, try to get cached reader
     * Returns <code>true</code> if the provided <code>docs</code> are
import org.opensearch.search.fetch.FetchSubPhase.HitContext;
                    FetchSourceContext fetchSourceContext = context.hasFetchSourceContext()
                        .map(fieldAndFormat -> fieldAndFormat.field)  
            for (Tuple<FetchSubPhaseProcessor, FetchSubPhase> p : processors) {
        ObjectMapper nestedParentObjectMapper;
            });
    }
                    );  
                        }  
                    });
            return supplier.get();
                        FetchTimingType.GET_NEXT_READER,
            nestedIdentity = new SearchHit.NestedIdentity(originalName.substring(currentPrefix), offset, nestedIdentity);  
                    rootSourceContentType = tuple.v1();  
                    } else {
    }
     * applies these patterns.  
            LOGGER.trace("{}", new SearchContextSourcePrinter(context));  
        try {  
                continue;
                }
        StoredFieldsContext storedFieldsContext = context.storedFieldsContext();  
            );
        this.fetchSubPhases = fetchSubPhases.toArray(new FetchSubPhase[fetchSubPhases.size() + 1]);
    /**
 * Modifications Copyright OpenSearch Contributors. See
                fillDocAndMetaFields(context, nestedFieldsVisitor, storedToRequestedFields, docFields, metaFields);
        execute(context, "fetch");
                                sequentialReader = lf.getSequentialStoredFieldsReader();
                        // Only fail if we know it is an object field, missing paths / fields shouldn't fail.
                }
        if (context.docIdsToLoadSize() == 0) {
                    context.fetchSourceContext(new FetchSourceContext(true, fetchSourceContext.includes(), fetchSourceContext.excludes()));
                            }  
                assert currentReaderContext != null;
        if (fetchProfiler != null) {  
                    // This is why only the first element of nestedParsedSource needs to be checked.
    private boolean collectInnerHitIncludes(Map<String, InnerHitsContext.InnerHitSubContext> innerHits, Set<String> requestIncludes) {  
                }  
                    innerFetchContext.fields()
    static boolean hasSequentialDocs(DocIdToIndex[] docs) {
                loadSource,  
import org.opensearch.common.lucene.search.Queries;
            final FetchSourceContext innerSource = innerHit.fetchSourceContext();
            return prepareNonNestedHitContext(  
                        }
     */
            );
     * nested document. This includes the following:  
                    );  
import org.opensearch.index.mapper.MapperService;
        }
    }
            if (innerSource != null && innerSource.fetchSource()) {  
             * of the nested child is the number of nested document with the same parent
                        // for random access and don't optimize for sequential access - except for merging.  
 * You may obtain a copy of the License at  
                    current = next;
import java.io.IOException;  
                        } else {
     * are therefore compared segment by segment (splitting on {@code .}); they overlap when every segment
 * Licensed to Elasticsearch under one or more contributor  
        return codecExcludes.toArray(new String[0]);  
        SearchContext context,
    }
        // request must stay available at the codec level. If any inner hit fetches the whole source,
                if (nested.getChild() == null) {  
    }
                .getBitSetProducer(context.searcher().rewrite(childFilter))
 * The OpenSearch Contributors require contributions made to  
import java.util.stream.Collectors;  
import org.opensearch.search.SearchShardTarget;
                docId,
            return supplier.get();
        DocIdToIndex(int docId, int index) {  
    }  
        Map<String, Set<String>> storedToRequestedFields = new HashMap<>();  
                rootSourceContentType = rootLookup.sourceContentType();  
                    //  
                    storedToRequestedFields.keySet(),
import java.util.Map;
        }
    }  
                parentFilter = Queries.newNonNestedFilter();
                && docId != DocIdSetIterator.NO_MORE_DOCS; docId = childIter.nextSetBit(docId + 1)) {  
        SearchContext context,
        FetchProfileBreakdown breakdown = null;
                throw new TaskCancelledException("cancelled task with reason: " + context.getTask().getReasonCancelled());
import org.opensearch.index.mapper.DocumentMapper;
                    hitContext.sourceLookup().setSource(fieldsVisitor.source());
        }  
            }
        Map<String, Set<String>> storedToRequestedFields,
                subReaderContext,  
                return true;
                    docFields.put(storedField, new DocumentField(storedField, storedValues));
        int nestedTopDocId,  
                requestIncludes.addAll(  
                return false;
                    current.put(nestedPath, rootSourceAsMap);
                        .getFetchProfiler()
            SearchHit hit = new SearchHit(docId, null, null, null);
import org.opensearch.index.fieldvisitor.FieldsVisitor;
        boolean needSource = sourceRequired(context) || context.highlight() != null;
                    }
        }  
        String rootId;  
                        : FetchSourceContext.FETCH_SOURCE;
        LeafReaderContext subReaderContext,  
            int offset = 0;
                            sequentialReader = lf.getSequentialStoredFieldsReader();
    /**
            SearchHit hit;
            }
    /**  
    static class DocIdToIndex implements Comparable<DocIdToIndex> {
    }
            BitSet bits = context.bitsetFilterCache().getBitSetProducer(Queries.newNonNestedFilter()).getBitSet(subReaderContext);
 * SPDX-License-Identifier: Apache-2.0
     * Resets the provided {@link HitContext} with information on the current  
import java.util.HashMap;
                FetchSubPhaseProcessor processor = fsp.getProcessor(context);  
 *
        }
                Map<String, DocumentField> docFields = new HashMap<>();  
 * ownership. Elasticsearch licenses this file to you under  
                    for (Tuple<FetchSubPhaseProcessor, FetchSubPhase> p : processors) {
import org.opensearch.common.CheckedBiConsumer;
import java.util.Objects;  
            }
                    return true;  
import org.opensearch.common.xcontent.XContentHelper;  
            }
 * Unless required by applicable law or agreed to in writing,
                for (String fieldName : fieldNames) {
    }  
            FetchTimingType.CREATE_STORED_FIELDS_VISITOR,  
            // Isolate the nested json array object that matches with nested hit and wrap it back into the same json
                        Set<String> requestedFields = storedToRequestedFields.computeIfAbsent(storedField, key -> new HashSet<>());
import java.util.Set;
                return new CustomFieldsVisitor(
        // Inner hits (including nested ones) read from the root document's _source, so any field they  
        @Override
            if (nestedFieldsVisitor.fields().isEmpty() == false) {
            if (Regex.simpleMatchOverlap(excludeSegments[i], includeSegments[i]) == false) {
                    } else {
                // Empty includes means "fetch the whole source", so every field must remain available.
        }  
                        String storedField = fieldType.name();  
                    MappedFieldType fieldType = context.fieldType(fieldName);
                continue;
     *     fetch subphases that use the hit context to access the preloaded source.
        int rootDocId = findRootDocumentIfNested(context, subReaderContext, docId - subReaderContext.docBase);
                        });
        }  
            return new HitContext(hit, subReaderContext, subDocId, lookup.source());
        }
            return new FieldsVisitor(
            breakdown,
    ) throws E {  
                        && hasSequentialDocs  
                        && docs.length >= 10) {
                return null;  
            if (storedToRequestedFields.containsKey(storedField)) {
                loadStoredFields(context::fieldType, storedFieldReader, rootFieldsVisitor, rootDocId);
                }
                storedFieldReader,
        if (context.hasStoredFields() && !context.storedFieldsContext().fieldNames().isEmpty()) {  
            timer.stop();  
            if (current != null) {
        }
            int currentPrefix = current == null ? 0 : current.name().length() + 1;
import org.opensearch.core.xcontent.MediaType;
            }
            subReaderContext,  
        fieldVisitor.reset();
                if (nestedParentObjectMapper.nested().isNested() == false) {
        TotalHits totalHits = context.queryResult().getTotalHits();  
    public void execute(SearchContext context) {  
            current = nestedObjectMapper = nestedParentObjectMapper;
                    rootSourceAsMap = Collections.emptyMap();
            }
                    // nested field has an object value in the _source. This just means the nested field has just one inner object,
                    Map<String, Object> next = new HashMap<>();  
        SearchContext context,
        }
                    }
    }  
                    } else {  
     * Determine whether a source exclude pattern and an inner-hit include pattern can affect a common
            // features like source filtering and highlighting work consistent regardless of whether the field points  
                .getBitSet(subReaderContext);
     * children into {@code requestIncludes}.
                            + "] are not nested. All parent fields need to be nested fields too"
 *    http://www.apache.org/licenses/LICENSE-2.0
        LeafReaderContext currentReaderContext = null;  
                hit = new SearchHit(docId, id, docFields, metaFields);  
        ObjectMapper current = nestedObjectMapper;  
                Object extractedValue = XContentMapValues.extractValue(nestedPath, rootSourceAsMap);
                docFields = new HashMap<>();
        MediaType rootSourceContentType = null;
                );  
import org.apache.lucene.codecs.StoredFieldsReader;  
     * stored sequentially (Dn = Dn-1 + 1).  
/*  
import org.apache.lucene.search.DocIdSetIterator;  
import org.opensearch.common.regex.Regex;
                context,
        CheckedBiConsumer<Integer, FieldsVisitor, IOException> storedFieldReader,
                requestIncludes.addAll(Arrays.asList(innerSource.includes()));
                context,  
            profile(breakdown, FetchTimingType.LOAD_STORED_FIELDS, () -> {
        );
        for (int index = 0; index < context.docIdsToLoadSize(); index++) {  
        int nestedSubDocId,
                parentFilter = nestedParentObjectMapper.nestedTypeFilter();
        if (rootDocId == -1) {
            () -> getProcessors(context.shardTarget(), fetchContext)
        if (breakdown == null) {
        final String[] excludeSegments = exclude.split("\\.");  
            rootId = rootFieldsVisitor.id();  
                // empty list specified, default to disable _source if no explicit indication
            );  
            codecExcludes.removeIf(userExclude -> sourcePathOverlap(userExclude, reqInclude));  
                current = nestedParentObjectMapper;  
            currentParent = nestedSubDocId;  
            return requestExcludes;
            }
        ObjectMapper nestedObjectMapper
     *
            }  
                        breakdown,  
     */
import org.apache.lucene.search.Query;
        } else {
            rootFieldsVisitor.postProcess(context::fieldType);
                }
        if (context.getProfilers() != null) {
        final int index;
import org.opensearch.search.SearchHit;
                    fieldsVisitor,  
    /**
     *   - Adding an initial {@link SearchHit} instance.
                Map<String, DocumentField> metaFields = new HashMap<>();
            fetchProfiler.endFetchPhase(profileDescription);
                        fieldReader = currentReaderContext.reader().storedFields()::document;  
        int rootDocId,
        SearchHit hit = new SearchHit(nestedTopDocId, rootId, nestedIdentity, docFields, metaFields);
        CheckedBiConsumer<Integer, FieldsVisitor, IOException> fieldReader,
        return docs.length > 0 && docs[docs.length - 1].docId - docs[0].docId == docs.length - 1;  
                if (processor != null) {
import java.util.Collection;  
            return hitContext;  
import org.opensearch.common.annotation.PublicApi;  
import org.opensearch.index.mapper.MappedFieldType;  
                originalName = current.name();
                HitContext hit = prepareHitContext(  
        SearchContext context,
            String id = fieldsVisitor.id();
        int subDocId = docId - subReaderContext.docBase;
        if (context instanceof InnerHitsContext.InnerHitSubContext innerHitsContext) {  
                    fetchContext.searchLookup(),
            throw new TaskCancelledException("cancelled task with reason: " + context.getTask().getReasonCancelled());
    }
        } else {  
                    // from two or more layers resulting in a list of list being returned. This is because nestedPath
                        docFields.put(requestedField, new DocumentField(requestedField, storedValues));
/*
        Timer timer = breakdown.getTimer(timingType);
    List<Tuple<FetchSubPhaseProcessor, FetchSubPhase>> getProcessors(SearchShardTarget target, FetchContext context) {
        if (context.isCancelled()) {  
    private void loadStoredFields(
            String storedField = entry.getKey();  
    }
            profile(breakdown, FetchTimingType.LOAD_STORED_FIELDS, () -> {
                                context.scrollContext().cacheSequentialReader(segmentKey, sequentialReader);
                    currentReaderContext = profile(
        }
     */
        return context.sourceRequested() || context.fetchFieldsContext() != null;
        boolean hasSequentialDocs = hasSequentialDocs(docs);
        }
                if (context.mapperService().isMetadataField(storedField)) {
        if (fieldsVisitor == null) {  
        SearchHit.NestedIdentity nestedIdentity = getInternalNestedIdentity(  
                } else {
                            sequentialReader = context.scrollContext().getCachedSequentialReader(segmentKey);
     *   - Loading the document source, filtering it based on the nested document ID, then
                }  
     * field. Source include/exclude semantics are hierarchical: excluding {@code obj} also removes
        int docId,
            context.fetchResult()  
                current.put(nestedPath, new HashMap<>());  
import org.apache.lucene.search.TotalHits;
    }  
                    if (context.mapperService().isMetadataField(requestedField)) {
        Map<String, Set<String>> storedToRequestedFields,
                }  
                String nestedPath = nested.getField().string();
        }
            if (fieldsVisitor.source() != null) {  
        final String[] includeSegments = include.split("\\.");
            throw new FetchPhaseExecutionException(target, "Error building fetch sub-phases", e);
                        "Cannot execute inner hits. One or more parent object fields of nested field ["  
                            return null;
        }  
        try {  
                });
import org.opensearch.common.document.DocumentField;
            } catch (Exception e) {
        }
     * Resets the provided {@link HitContext} with information on the current
import java.util.function.Function;
        FetchContext fetchContext = new FetchContext(context);
            }  
                }  
                            if (sequentialReader == null) {  
            });
            return null;
     * {@code obj.field}, and including {@code obj} pulls in the whole {@code obj} subtree. Both patterns  
import org.opensearch.search.SearchContextSourcePrinter;
    private String[] codecSourceExcludes(SearchContext context, String[] requestExcludes) {  
    public FetchPhase(List<FetchSubPhase> fetchSubPhases) {
        CheckedBiConsumer<Integer, FieldsVisitor, IOException> storedFieldReader,
        LeafReaderContext subReaderContext,  
            BitSet parentBits = context.bitsetFilterCache().getBitSetProducer(parentFilter).getBitSet(subReaderContext);
        context.fetchResult().hits(new SearchHits(hits, totalHits, context.queryResult().getMaxScore()));
            }
    /**
import java.util.Collections;
    ) throws IOException {  
            if (innerHit.innerHits() != null && collectInnerHitIncludes(innerHit.innerHits().getInnerHits(), requestIncludes)) {  
                        return null;  
                    metaFields.put(storedField, new DocumentField(storedField, storedValues));  
@PublicApi(since = "1.0.0")
        CheckedBiConsumer<Integer, FieldsVisitor, IOException> fieldReader,
     */
                return null;
            HitContext hitContext = new HitContext(hit, subReaderContext, subDocId, lookup.source());
                requestSourceExcludes,
                        // get better sequential access.
        Function<String, MappedFieldType> fieldTypeLookup,  
        FetchProfileBreakdown breakdown,  
        }
import org.opensearch.search.SearchHits;  
 * under the License.  
                            throw new IllegalArgumentException("field [" + fieldName + "] isn't a leaf field");  
            return processors;
            for (SearchHit.NestedIdentity nested = nestedIdentity; nested != null; nested = nested.getChild()) {
                                                                                                         // for the nested context
            FetchTimingType.BUILD_SUB_PHASE_PROCESSORS,
                            // To get a unique identifier for this segment to use as a cache key  
package org.opensearch.search.fetch;
                        // So we do a little hack here and pretend we're going to do merges in order to
    ) throws IOException {  
            profile(breakdown, FetchTimingType.LOAD_STORED_FIELDS, () -> {
            return Integer.compare(docId, o.docId);
                    continue;  
        Map<String, DocumentField> docFields = emptyMap();
        String originalName = nestedObjectMapper.name();
                        StoredFieldsReader sequentialReader;  
    private static final Logger LOGGER = LogManager.getLogger(FetchPhase.class);  
            } else {
            if (childFilter == null) {
        Map<String, DocumentField> docFields,
            return;
                rootSourceAsMap = profile(breakdown, FetchTimingType.LOAD_SOURCE, rootLookup::loadSourceIfNeeded);
    private static void fillDocAndMetaFields(
    protected FieldsVisitor createStoredFieldsVisitor(SearchContext context, Map<String, Set<String>> storedToRequestedFields) {
        int docId,
                    fieldReader,
                        if (context.getObjectMapper(fieldName) != null) {
        }
            String[] codecSourceExcludes = codecSourceExcludes(context, requestSourceExcludes);
                if (fieldNameOrPattern.equals(SourceFieldMapper.NAME)) {
        assert nestedObjectMapper != null;
                    currentReaderIndex = readerIndex;
        for (int i = 0; i < common; i++) {  
            }  
                }
                fillDocAndMetaFields(context, fieldsVisitor, storedToRequestedFields, docFields, metaFields);
        if (context.isCancelled()) {
        }
        return false;
        final Set<String> requestIncludes = new HashSet<>();
            if (needSource) {  
            Map<String, Object> nestedSourceAsMap = new HashMap<>();
        this.fetchSubPhases[fetchSubPhases.size()] = new InnerHitsPhase(this);  
        SearchHit[] hits = new SearchHit[context.docIdsToLoadSize()];  
        FieldsVisitor fieldsVisitor = profile(
        MapperService mapperService,
            }
import java.util.List;
    }  
        LeafReaderContext subReaderContext,  
                    throw new IllegalArgumentException(
            if (innerFetchContext != null && innerFetchContext.fields() != null) {
            docs[index] = new DocIdToIndex(context.docIdsToLoad()[context.docIdsToLoadFrom() + index], index);
            List<Tuple<FetchSubPhaseProcessor, FetchSubPhase>> processors = new ArrayList<>();
        Map<String, Set<String>> storedToRequestedFields,
        return hitContext;  
        if (CollectionUtils.isEmpty(requestExcludes)) {
                loadStoredFields(context::fieldType, storedFieldReader, nestedFieldsVisitor, nestedDocId);  
 * KIND, either express or implied.  See the License for the
                    codecSourceExcludes  
        } else {
                breakdown
/*  
            if (!context.hasScriptFields() && !hasFetchContext) {
                    requestSourceExcludes,
        } catch (Exception e) {  
 * not use this file except in compliance with the License.
    }  
            }
        FieldsVisitor fieldsVisitor,  
     * @return true if any inner hit fetches the whole source (empty includes), meaning no codec  
        FetchTimingType timingType,
                        .collect(Collectors.toSet())
            }
    private HitContext prepareNonNestedHitContext(  
            this.docId = docId;
            if (context.isCancelled()) {
                } else if (extractedValue instanceof Map) {  
     *     setting it on {@link SourceLookup}. This allows fetch subphases that use the hit  
                rootSourceAsMap = (Map<String, Object>) nestedParsedSource.get(nested.getOffset());
            hitContext.sourceLookup().setSource(nestedSourceAsMap);  
        final int common = Math.min(excludeSegments.length, includeSegments.length);
                codecSourceExcludes(context, requestSourceExcludes)  
     * up to the shorter path overlaps, i.e. when one path is an ancestor of (or equal to) the other. When
                throw new FetchPhaseExecutionException(context.shardTarget(), "Error running fetch phase for doc [" + docId + "]", e);
                    // which is valid, but uncommon.
 *
                loadStoredFields(context::fieldType, fieldReader, fieldsVisitor, subDocId);  
        if (storedFieldsContext == null) {
             * <code>nestedSubDocID</code> within the nested children. Nested documents
                    loadSource,  
        int currentReaderIndex = -1;
                    current = nestedParentObjectMapper;
import org.apache.lucene.util.BitSet;  
            this.index = index;
                storedFieldReader,
    ) {
                    throw new IllegalStateException("extracted source isn't an object or an array");
                hit = new SearchHit(docId, id, emptyMap(), emptyMap());
                if (extractedValue instanceof List) {  
     * {@code .} boundary, matching how {@link org.opensearch.common.xcontent.support.XContentMapValues}
     *     context to access the preloaded source.
                if ((nestedParsedSource.get(0) instanceof Map) == false
                return new FieldsVisitor(loadSource, requestSourceIncludes, requestSourceExcludes, codecSourceExcludes);
                List<?> nestedParsedSource;
            } else {
                }  
import org.opensearch.search.profile.Timer;
        }  
                    storedToRequestedFields,
    @SuppressWarnings("unchecked")  
 */  
        boolean hasFetchContext = context.hasFetchSourceContext();
            try {
            hitContext.sourceLookup().setSourceContentType(rootSourceContentType);
        }  
        if (rootSourceAsMap != null && rootSourceAsMap.isEmpty() == false) {  
                return null;
            boolean loadSource = sourceRequired(context);  
                    Tuple<XContentType, Map<String, Object>> tuple = XContentHelper.convertToMap(rootFieldsVisitor.source(), false);
                }
        do {  
        }  
     *         excludes should be applied
                            + nestedObjectMapper.name()
                rootDocId,
                    if (currentReaderContext.reader() instanceof SequentialStoredFieldsLeafReader lf
                        .stream()
                    nestedParsedSource = (List<?>) extractedValue;
        timer.start();
            });
 * @opensearch.api
 * license agreements. See the NOTICE file distributed with
            breakdown,  
        List<Tuple<FetchSubPhaseProcessor, FetchSubPhase>> processors = profile(
            fetchProfiler = context.getProfilers().getFetchProfiler();
     *   - Adding an initial {@link SearchHit} instance.
    private static <T, E extends Exception> T profile(
    ) throws IOException {  
/**
    private HitContext prepareHitContext(  
            FieldsVisitor nestedFieldsVisitor = new CustomFieldsVisitor(storedToRequestedFields.keySet(), false);
import org.opensearch.common.lucene.index.SequentialStoredFieldsLeafReader;  
            if (fieldsVisitor.fields().isEmpty() == false) {
        } else if (storedFieldsContext.fetchFields() == false) {
                        // All the docs to fetch are adjacent but Lucene stored fields are optimized
        );  
        final Set<String> codecExcludes = new HashSet<>(Arrays.asList(requestExcludes));
            }
        if (context.mapperService().hasNested()) {  
        }  
            if (!bits.get(subDocId)) {
        } finally {
        } else {
            Query parentFilter;
            List<Object> storedValues = entry.getValue();
                        p.v1().process(hit);
                    }  
                if (p.v2() instanceof InnerHitsPhase == false) {
                } else {
                    profile(pbd, FetchTimingType.PROCESS, () -> {
    private HitContext prepareNestedHitContext(
        CheckedSupplier<T, E> supplier
                current = nestedParentObjectMapper;
        Arrays.sort(docs);
        if (innerHits.isEmpty()) {
             * are indexed in the same order than in the source array so the offset  
                    // encapsulates two or more object layers in the _source.
 * specific language governing permissions and limitations
            if (storedToRequestedFields.isEmpty()) {  
     *   - Loading the document source and setting it on {@link SourceLookup}. This allows  
                    nestedParsedSource = Collections.singletonList(extractedValue);  
            /*  
            for (int docId = childIter.nextSetBit(previousParent + 1); docId < nestedSubDocId
                if (innerSource.includes().length == 0) {
            } else {  
        public int compareTo(DocIdToIndex o) {  
        }
            for (FetchSubPhase fsp : fetchSubPhases) {
        int currentParent = nestedSubDocId;
            Query childFilter = nestedObjectMapper.nestedTypeFilter();
    private int findRootDocumentIfNested(SearchContext context, LeafReaderContext subReaderContext, int subDocId) throws IOException {
import java.util.HashSet;  
        FetchProfiler fetchProfiler = null;  
            rootId = innerHitsContext.getId();
            if (nestedParentObjectMapper != null) {  
        return true;
        int nestedDocId = nestedTopDocId - subReaderContext.docBase;
            }  
            // no individual hits to process, so we shortcut
                    processorProfiles.put(p.v1(), pb);  
import org.opensearch.common.xcontent.XContentType;
import org.opensearch.index.mapper.ObjectMapper;
                for (String requestedField : storedToRequestedFields.get(storedField)) {  
                    rootSourceAsMap = tuple.v2();
            }  
                    docId,
        }  
        Map<String, Object> rootSourceAsMap = null;
                        profile(pbd, FetchTimingType.SET_NEXT_READER, () -> {
import org.opensearch.index.fieldvisitor.CustomFieldsVisitor;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
import static java.util.Collections.emptyMap;
                        fieldReader = sequentialReader::document;
 * GitHub history for details.
        String[] requestSourceIncludes = hasFetchContext ? context.fetchSourceContext().includes() : null;
        for (String reqInclude : requestIncludes) {
 */  
        ObjectMapper nestedObjectMapper = documentMapper.findNestedObjectMapper(nestedDocId, context, subReaderContext);
 * this work for additional information regarding copyright
    }
                metaFields = new HashMap<>();  
        // otherwise highlighting will attempt to fetch the _source from the nested doc, which will fail,
                    context,
import org.opensearch.search.fetch.subphase.InnerHitsPhase;  
import org.opensearch.search.fetch.subphase.FetchSourceContext;
        int docId  
            throw new TaskCancelledException("cancelled task with reason: " + context.getTask().getReasonCancelled());  
    private SearchHit.NestedIdentity getInternalNestedIdentity(  
                    requestSourceIncludes,
                    && nestedObjectMapper.parentObjectMapperAreNested(context.mapperService()) == false) {
                        () -> context.searcher().getIndexReader().leaves().get(readerIndex)
            nestedParentObjectMapper = current.getParentObjectMapper(mapperService);
import org.opensearch.search.lookup.SearchLookup;
    }
     * document. This includes the following:
            for (String fieldNameOrPattern : context.storedFieldsContext().fieldNames()) {  
    ) throws IOException {
    private final FetchSubPhase[] fetchSubPhases;
            FieldsVisitor rootFieldsVisitor = new FieldsVisitor(needSource);  
public class FetchPhase {
                offset++;
                    continue;  
                        ? context.fetchSourceContext()  
import org.opensearch.search.profile.fetch.FetchTimingType;
        CheckedBiConsumer<Integer, FieldsVisitor, IOException> fieldReader = null;
                    return null;  
     * they overlap the exclude must not be applied at the codec level, otherwise the inner hit would read  
 * software distributed under the License is distributed on an
                context.fetchSourceContext(FetchSourceContext.FETCH_SOURCE);
