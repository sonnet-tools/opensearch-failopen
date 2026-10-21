    private String[] codecSourceExcludes(SearchContext context, String[] requestExcludes) {
        this.fetchSubPhases[fetchSubPhases.size()] = new InnerHitsPhase(this);
                Collection<String> fieldNames = context.mapperService().simpleMatchToFullName(fieldNameOrPattern);
import org.opensearch.common.xcontent.XContentType;
import org.opensearch.search.fetch.subphase.FetchSourceContext;
            SearchHit hit;
                    innerFetchContext.fields()
        }
                } else {
        return context.sourceRequested() || context.fetchFieldsContext() != null;
                    // which is valid, but uncommon.
    private int findRootDocumentIfNested(SearchContext context, LeafReaderContext subReaderContext, int subDocId) throws IOException {
        }
             * are indexed in the same order than in the source array so the offset
                storedFieldReader,
        final String[] excludeSegments = exclude.split("\\.");
                    FetchSourceContext fetchSourceContext = context.hasFetchSourceContext()
import java.util.Arrays;
    /**
            if (childIter == null) {
        final int docId;
 * compatible open source license.
            return supplier.get();
                    storedToRequestedFields,
        for (Map.Entry<String, List<Object>> entry : fieldsVisitor.fields().entrySet()) {
            hitContext.sourceLookup().setSource(nestedSourceAsMap);
            fetchProfiler = context.getProfilers().getFetchProfiler();
                    fieldsVisitor,
        }
                            + "] are not nested. All parent fields need to be nested fields too"
import org.opensearch.index.mapper.MapperService;
import org.opensearch.search.lookup.SearchLookup;
                    Tuple<XContentType, Map<String, Object>> tuple = XContentHelper.convertToMap(rootFieldsVisitor.source(), false);
 * @opensearch.api
import org.opensearch.search.SearchShardTarget;
                storedToRequestedFields,
            BitSet childIter = context.bitsetFilterCache()
        FetchProfileBreakdown breakdown,
     */
                codecSourceExcludes(context, requestSourceExcludes)
import org.opensearch.index.mapper.ObjectMapper;
        }
import org.apache.lucene.util.BitSet;
        return false;
        Map<String, DocumentField> metaFields = emptyMap();
import org.opensearch.search.internal.SearchContext;
            if (nestedFieldsVisitor.fields().isEmpty() == false) {
                        // for random access and don't optimize for sequential access - except for merging.
                if (fieldNameOrPattern.equals(SourceFieldMapper.NAME)) {
                FetchSubPhaseProcessor processor = fsp.getProcessor(context);
                    currentReaderContext,
 * the Apache License, Version 2.0 (the "License"); you may
 * after reducing all the matches returned by the query phase
    /**
                        return null;
    }
                        profile(pbd, FetchTimingType.SET_NEXT_READER, () -> {
        boolean needSource = sourceRequired(context) || context.highlight() != null;
            FetchFieldsContext innerFetchContext = innerHit.fetchFieldsContext();
            // no fields specified, default to return source if no explicit indication
                    codecSourceExcludes
        FetchProfileBreakdown breakdown = null;
            rootFieldsVisitor.postProcess(context::fieldType);
        for (int index = 0; index < context.docIdsToLoadSize(); index++) {
        fieldReader.accept(docId, fieldVisitor);
     * Recursively collects the source fields requested by the given inner hits and their nested
        }
            profile(breakdown, FetchTimingType.LOAD_STORED_FIELDS, () -> {
            int currentPrefix = current == null ? 0 : current.name().length() + 1;
            } else {
                        breakdown,
                        () -> context.searcher().getIndexReader().leaves().get(readerIndex)
    }
        FetchProfileBreakdown breakdown
        for (String reqInclude : requestIncludes) {
            context.mapperService(),
                    for (Tuple<FetchSubPhaseProcessor, FetchSubPhase> p : processors) {
     * Returns <code>true</code> if the provided <code>docs</code> are
                    nestedParsedSource = Collections.singletonList(extractedValue);
                        .stream()
                if ((nestedParsedSource.get(0) instanceof Map) == false
             * of the nested child is the number of nested document with the same parent
        Arrays.sort(docs);
                    profile(pbd, FetchTimingType.PROCESS, () -> {
import org.opensearch.search.profile.Timer;
                );
        } else {
                SourceLookup rootLookup = innerHitsContext.getRootLookup();
import org.opensearch.common.collect.Tuple;
import org.opensearch.common.CheckedBiConsumer;
            int previousParent = parentBits.prevSetBit(currentParent);
            if (current != null) {
            List<Object> storedValues = entry.getValue();
                        // So we do a little hack here and pretend we're going to do merges in order to
            }
import org.opensearch.core.xcontent.MediaType;
        final int common = Math.min(excludeSegments.length, includeSegments.length);
            throw new FetchPhaseExecutionException(target, "Error building fetch sub-phases", e);
                } else {
 *
import java.util.HashSet;
import org.opensearch.search.fetch.subphase.InnerHitsPhase;
                    rootSourceContentType = tuple.v1();
            }
        }
     */
        }
    }
                loadStoredFields(context::fieldType, storedFieldReader, nestedFieldsVisitor, nestedDocId);
import org.opensearch.search.profile.fetch.FetchTimingType;
            () -> createStoredFieldsVisitor(context, storedToRequestedFields)
                } else if (extractedValue instanceof Map) {
        } else {
                subReaderContext,
        if (context.docIdsToLoadSize() == 0) {
            boolean loadSource = sourceRequired(context);
/*
            nestedIdentity = new SearchHit.NestedIdentity(originalName.substring(currentPrefix), offset, nestedIdentity);
            LOGGER.trace("{}", new SearchContextSourcePrinter(context));
            for (Tuple<FetchSubPhaseProcessor, FetchSubPhase> p : processors) {
        LeafReaderContext subReaderContext,
            BitSet bits = context.bitsetFilterCache().getBitSetProducer(Queries.newNonNestedFilter()).getBitSet(subReaderContext);
            });
                parentFilter = nestedParentObjectMapper.nestedTypeFilter();
        HitContext hitContext = new HitContext(hit, subReaderContext, nestedDocId, new SourceLookup());  // Use a clean, fresh SourceLookup
import org.opensearch.common.CheckedSupplier;
            } else {
import org.opensearch.index.mapper.DocumentMapper;
        }
 * You may obtain a copy of the License at
                throw new TaskCancelledException("cancelled task with reason: " + context.getTask().getReasonCancelled());
            }
import java.io.IOException;
            if (innerFetchContext != null && innerFetchContext.fields() != null) {
        FetchProfileBreakdown breakdown
     * {@code .} boundary, matching how {@link org.opensearch.common.xcontent.support.XContentMapValues}
                        metaFields.put(requestedField, new DocumentField(requestedField, storedValues));
        Map<FetchSubPhaseProcessor, FetchProfileBreakdown> processorProfiles = new HashMap<>();
            }
                        && hasSequentialDocs
                if (p.v2() instanceof InnerHitsPhase == false) {
            return hitContext;
            this.index = index;
            return null;
             * Starts from the previous parent and finds the offset of the
import java.util.stream.Collectors;
                    context,
        // Also if highlighting is requested on nested documents we need to fetch the _source from the root document,
 * not use this file except in compliance with the License.
     *     context to access the preloaded source.
    ) throws IOException {
        // make sure that we iterate in doc id order
                }
            String id = fieldsVisitor.id();
                breakdown = fetchProfiler.startFetchPhase(profileDescription);
                    } else {
                .hits(new SearchHits(new SearchHit[0], context.queryResult().getTotalHits(), context.queryResult().getMaxScore()));
            if (needSource) {
     * they overlap the exclude must not be applied at the codec level, otherwise the inner hit would read
        fieldVisitor.postProcess(fieldTypeLookup);
import org.opensearch.search.fetch.FetchSubPhase.HitContext;
    public FetchPhase(List<FetchSubPhase> fetchSubPhases) {
                for (Tuple<FetchSubPhaseProcessor, FetchSubPhase> p : processors) {
        }
        final int index;
import java.util.Collections;
                subReaderContext,
                        String storedField = fieldType.name();
                // empty list specified, default to disable _source if no explicit indication
                    throw new IllegalArgumentException(
 *    http://www.apache.org/licenses/LICENSE-2.0
                rootSourceAsMap = (Map<String, Object>) nestedParsedSource.get(nested.getOffset());
                        : FetchSourceContext.FETCH_SOURCE;
        Map<String, DocumentField> docFields = emptyMap();
                    Map<String, Object> next = new HashMap<>();
            nestedParentObjectMapper = current.getParentObjectMapper(mapperService);
import org.opensearch.search.profile.fetch.FetchProfileBreakdown;
        }
 * Fetch phase of a search request, used to fetch the actual top matching documents to be returned to the client, identified
        final Map<String, InnerHitsContext.InnerHitSubContext> innerHits = context.innerHits().getInnerHits();
            List<Tuple<FetchSubPhaseProcessor, FetchSubPhase>> processors = new ArrayList<>();
        }
                        .collect(Collectors.toSet())
                    continue;
                return new CustomFieldsVisitor(
import static java.util.Collections.emptyMap;
        CheckedBiConsumer<Integer, FieldsVisitor, IOException> fieldReader = null;
        }
                for (String requestedField : storedToRequestedFields.get(storedField)) {
                return null;
            for (int docId = childIter.nextSetBit(previousParent + 1); docId < nestedSubDocId
                context,
            throw new TaskCancelledException("cancelled task with reason: " + context.getTask().getReasonCancelled());
                        } else {
import org.opensearch.index.mapper.MappedFieldType;
                    docFields.put(storedField, new DocumentField(storedField, storedValues));
import org.opensearch.common.annotation.PublicApi;
            int offset = 0;
import org.opensearch.search.SearchContextSourcePrinter;
            /*
 *
                    // nested field has an object value in the _source. This just means the nested field has just one inner object,
        Map<String, Set<String>> storedToRequestedFields,
    }
        FieldsVisitor fieldsVisitor = profile(
 * SPDX-License-Identifier: Apache-2.0
import org.apache.logging.log4j.Logger;
import org.opensearch.index.fieldvisitor.CustomFieldsVisitor;
    }
        for (int i = 0; i < common; i++) {
            }
     */
    static class DocIdToIndex implements Comparable<DocIdToIndex> {
    private static void fillDocAndMetaFields(
                rootSourceContentType = rootLookup.sourceContentType();
            Query parentFilter;
                            return null;
        fieldVisitor.reset();
        // because the entire _source is only stored with the root document.
                        "Cannot execute inner hits. One or more parent object fields of nested field ["
        // context.innerHits won't throw NPE as it creates an empty innerhitscontext if its null
                if (rootFieldsVisitor.source() != null) {
            }
        if (context.hasStoredFields() && !context.storedFieldsContext().fieldNames().isEmpty()) {
        }
                    return true;
        }
     * @return true if any inner hit fetches the whole source (empty includes), meaning no codec
            rootId = rootFieldsVisitor.id();
                }
            FetchTimingType.BUILD_SUB_PHASE_PROCESSORS,
                }
                        FetchTimingType.GET_NEXT_READER,
            HitContext hitContext = new HitContext(hit, subReaderContext, subDocId, lookup.source());
                hit = new SearchHit(docId, id, emptyMap(), emptyMap());
                fillDocAndMetaFields(context, nestedFieldsVisitor, storedToRequestedFields, docFields, metaFields);
        if (rootDocId == -1) {
                    hitContext.sourceLookup().setSource(fieldsVisitor.source());
                } else {
     *   - Loading the document source and setting it on {@link SourceLookup}. This allows
        if (context instanceof InnerHitsContext.InnerHitSubContext innerHitsContext) {
        );
            }
        return -1;
        Map<String, DocumentField> metaFields
    ) {
        FetchProfiler fetchProfiler = null;
import java.util.Collection;
            Map<String, Object> nestedSourceAsMap = new HashMap<>();
                        if (context.scrollContext() != null) {
                    if (currentReaderContext.reader() instanceof SequentialStoredFieldsLeafReader lf
                    // When one of the parent objects are not nested then XContentMapValues.extractValue(...) extracts the values
            Map<String, Object> current = nestedSourceAsMap;
                            }
 */
        if (context.getProfilers() != null) {
import org.apache.logging.log4j.LogManager;
     */
            });
        // Inner hits (including nested ones) read from the root document's _source, so any field they
import org.opensearch.common.regex.Regex;
                String nestedPath = nested.getField().string();
import java.util.Objects;
                }
                            Object segmentKey = lf.getCoreCacheHelper() != null ? lf.getCoreCacheHelper().getKey() : currentReaderContext;
        if (LOGGER.isTraceEnabled()) {
            );
    }
import java.util.HashMap;
                requestSourceExcludes,
            }
                        requestedFields.add(fieldName);
import java.util.Set;
                docId,
                if (processor != null) {
                    continue;
        }
import org.opensearch.search.profile.fetch.FetchProfiler;
    @SuppressWarnings("unchecked")
            for (FetchSubPhase fsp : fetchSubPhases) {
                .getBitSetProducer(context.searcher().rewrite(childFilter))
            // Isolate the nested json array object that matches with nested hit and wrap it back into the same json
            context.fetchResult()
        }
                        docFields.put(requestedField, new DocumentField(requestedField, storedValues));
import org.opensearch.index.fieldvisitor.FieldsVisitor;
                        && docs.length >= 10) {
    public void execute(SearchContext context, String profileDescription) {
                throw new FetchPhaseExecutionException(context.shardTarget(), "Error running fetch phase for doc [" + docId + "]", e);
        if (innerHits.isEmpty()) {
        timer.start();
            return processors;
            this.docId = docId;
        } else {
import org.opensearch.common.xcontent.support.XContentMapValues;
        } else {
            nestedDocId,
                        StoredFieldsReader sequentialReader;
import java.util.function.Function;
        assert nestedObjectMapper != null;
            }
        return docs.length > 0 && docs[docs.length - 1].docId - docs[0].docId == docs.length - 1;
            SearchHit hit = new SearchHit(docId, null, null, null);
                continue;
            profile(breakdown, FetchTimingType.LOAD_STORED_FIELDS, () -> {
        }
                hit = new SearchHit(docId, id, docFields, metaFields);
                if (currentReaderIndex != readerIndex) {
                .getBitSet(subReaderContext);
    }
        execute(context, "fetch");
                    );
            } else {
import org.opensearch.index.mapper.SourceFieldMapper;
        Function<String, MappedFieldType> fieldTypeLookup,
        if (breakdown != null) {
        Map<String, Set<String>> storedToRequestedFields,
        if (rootSourceAsMap != null && rootSourceAsMap.isEmpty() == false) {
        SearchContext context,
            if (innerHit.innerHits() != null && collectInnerHitIncludes(innerHit.innerHits().getInnerHits(), requestIncludes)) {
 * ownership. Elasticsearch licenses this file to you under
        CheckedBiConsumer<Integer, FieldsVisitor, IOException> fieldReader,
        LeafReaderContext subReaderContext,
            }
    private void loadStoredFields(
import org.opensearch.search.fetch.subphase.InnerHitsContext;
                    // from two or more layers resulting in a list of list being returned. This is because nestedPath
                Map<String, DocumentField> docFields = new HashMap<>();
        DocumentMapper documentMapper = context.mapperService().documentMapper();
            }
        String[] requestSourceExcludes = hasFetchContext ? context.fetchSourceContext().excludes() : null;
import org.opensearch.common.document.DocumentField;
 * Licensed to Elasticsearch under one or more contributor
                assert currentReaderContext != null;
        ObjectMapper nestedParentObjectMapper;
import java.util.List;
        // every field must remain, so no codec excludes apply.
import org.apache.lucene.index.LeafReaderContext;
        // otherwise highlighting will attempt to fetch the _source from the nested doc, which will fail,
            throw new TaskCancelledException("cancelled task with reason: " + context.getTask().getReasonCancelled());
 * this work for additional information regarding copyright
        this.fetchSubPhases = fetchSubPhases.toArray(new FetchSubPhase[fetchSubPhases.size() + 1]);
     *   - Loading the document source, filtering it based on the nested document ID, then
                    } else {
        Map<String, Set<String>> storedToRequestedFields,
                HitContext hit = prepareHitContext(
                    processorProfiles.put(p.v1(), pb);
            current = nestedObjectMapper = nestedParentObjectMapper;
                    metaFields.put(storedField, new DocumentField(storedField, storedValues));
                return null;
        return codecExcludes.toArray(new String[0]);
 * specific language governing permissions and limitations
            }
            }
    private HitContext prepareHitContext(
            // disable stored fields entirely
            if (context.docIdsToLoadSize() > 0) {
                    });
import java.util.Map;
 */
        }
                    rootSourceAsMap = tuple.v2();
        boolean hasSequentialDocs = hasSequentialDocs(docs);
        int docId,
        String[] requestSourceIncludes = hasFetchContext ? context.fetchSourceContext().includes() : null;
            }
            timer.stop();
            FieldsVisitor nestedFieldsVisitor = new CustomFieldsVisitor(storedToRequestedFields.keySet(), false);
            breakdown,
                    throw new IllegalStateException("extracted source isn't an object or an array");
        for (InnerHitsContext.InnerHitSubContext innerHit : innerHits.values()) {
                && docId != DocIdSetIterator.NO_MORE_DOCS; docId = childIter.nextSetBit(docId + 1)) {
                            + nestedObjectMapper.name()
            }
                    if (context.mapperService().isMetadataField(requestedField)) {
                    requestSourceExcludes,
        FetchContext fetchContext = new FetchContext(context);
    }
import org.opensearch.search.SearchHit;
        FetchTimingType timingType,
            } else {
    /**
                storedFieldReader,
        }
                    current = next;
                    // This is why only the first element of nestedParsedSource needs to be checked.
                hits[docs[index].index] = hit.hit();
            Query childFilter = nestedObjectMapper.nestedTypeFilter();
                    storedToRequestedFields.keySet(),
                    nestedParsedSource = (List<?>) extractedValue;
                    current.put(nestedPath, next);
                    current = nestedParentObjectMapper;
        SearchHit[] hits = new SearchHit[context.docIdsToLoadSize()];
        CheckedSupplier<T, E> supplier
                        Set<String> requestedFields = storedToRequestedFields.computeIfAbsent(storedField, key -> new HashSet<>());
            if (context.isCancelled()) {
            if (fieldsVisitor.source() != null) {
                        if (context.getObjectMapper(fieldName) != null) {
        LeafReaderContext currentReaderContext = null;
    }
                current = nestedParentObjectMapper;
            boolean loadSource = sourceRequired(context);
        final Set<String> codecExcludes = new HashSet<>(Arrays.asList(requestExcludes));
                    }
            // structure with the nested json array object being the actual content. The latter is important, so that
    }
            return prepareNestedHitContext(
                }
                    loadSource,
                        ? context.fetchSourceContext()
            return supplier.get();
     * Determine whether a source exclude pattern and an inner-hit include pattern can affect a common
                    }
            if (!context.hasScriptFields() && !hasFetchContext) {
        LeafReaderContext subReaderContext,
            // features like source filtering and highlighting work consistent regardless of whether the field points
        public int compareTo(DocIdToIndex o) {
        FieldsVisitor fieldVisitor,
                parentFilter = Queries.newNonNestedFilter();
                rootDocId,
        final String[] includeSegments = include.split("\\.");
                });
        if (context.isCancelled()) {
                        fieldReader = sequentialReader::document;
     * are therefore compared segment by segment (splitting on {@code .}); they overlap when every segment
            }
        ObjectMapper current = nestedObjectMapper;
/*
import java.util.ArrayList;
            codecExcludes.removeIf(userExclude -> sourcePathOverlap(userExclude, reqInclude));
                } else {
        int docId
        SearchContext context,
    private static final Logger LOGGER = LogManager.getLogger(FetchPhase.class);
        }
        try {
        boolean hasFetchContext = context.hasFetchSourceContext();
        Map<String, DocumentField> docFields,
                }
                fieldsVisitor,
            return new FieldsVisitor(
 * Modifications Copyright OpenSearch Contributors. See
        }
                    && nestedObjectMapper.parentObjectMapperAreNested(context.mapperService()) == false) {
    private HitContext prepareNonNestedHitContext(
 */
            }
        if (breakdown == null) {
            // to a json object array for consistency reasons on how we refer to fields
            return null;
        MapperService mapperService,
        SearchContext context,
import org.apache.lucene.search.TotalHits;
        if (fieldsVisitor == null) {
            return null;
                    return null;
     *     setting it on {@link SourceLookup}. This allows fetch subphases that use the hit
import org.opensearch.core.common.util.CollectionUtils;
}
                                sequentialReader = lf.getSequentialStoredFieldsReader();
 * GitHub history for details.
        Map<String, Set<String>> storedToRequestedFields = new HashMap<>();
package org.opensearch.search.fetch;
    ) throws IOException {
    private boolean sourceRequired(SearchContext context) {
            final FetchSourceContext innerSource = innerHit.fetchSourceContext();
    }
        DocIdToIndex[] docs = new DocIdToIndex[context.docIdsToLoadSize()];
        Map<String, Object> rootSourceAsMap = null;
                Object extractedValue = XContentMapValues.extractValue(nestedPath, rootSourceAsMap);
    private static <T, E extends Exception> T profile(
    }
import org.opensearch.core.tasks.TaskCancelledException;
                    currentReaderIndex = readerIndex;
                    if (fieldType == null) {
                    processors.add(new Tuple<>(processor, fsp));
/**
    }
    static boolean hasSequentialDocs(DocIdToIndex[] docs) {
     * stored sequentially (Dn = Dn-1 + 1).
     *         excludes should be applied
            currentParent = nestedSubDocId;
import org.opensearch.search.fetch.subphase.FetchFieldsContext;
                        .startSubPhase(p.v2().getClass().getSimpleName(), profileDescription);
                }
        }
                        // All the docs to fetch are adjacent but Lucene stored fields are optimized
import org.apache.lucene.codecs.StoredFieldsReader;
import org.apache.lucene.search.Query;
                }
                offset++;
                storedToRequestedFields,
            // no individual hits to process, so we shortcut
            );
     * up to the shorter path overlaps, i.e. when one path is an ancestor of (or equal to) the other. When
            if (needSource) {
                metaFields = new HashMap<>();
            if (!bits.get(subDocId)) {
            for (String fieldNameOrPattern : context.storedFieldsContext().fieldNames()) {
                        .filter(Objects::nonNull)
        SearchHit.NestedIdentity nestedIdentity = null;
                    rootSourceAsMap = Collections.emptyMap();
        LeafReaderContext subReaderContext,
                return bits.nextSetBit(subDocId);
     * nested document. This includes the following:
    private final FetchSubPhase[] fetchSubPhases;
                if (innerSource.includes().length == 0) {
import org.opensearch.common.lucene.search.Queries;
                loadStoredFields(context::fieldType, fieldReader, fieldsVisitor, subDocId);
        }
                fillDocAndMetaFields(context, fieldsVisitor, storedToRequestedFields, docFields, metaFields);
        MediaType rootSourceContentType = null;
 * license agreements. See the NOTICE file distributed with
                return null;
        if (CollectionUtils.isEmpty(requestExcludes)) {
            FetchTimingType.CREATE_STORED_FIELDS_VISITOR,
        SearchLookup lookup,
        if (fetchProfiler != null) {
            if (Regex.simpleMatchOverlap(excludeSegments[i], includeSegments[i]) == false) {
        SearchContext context,
                                                                                                         // for the nested context
        } while (current != null);
            String storedField = entry.getKey();
                );
            rootId = innerHitsContext.getId();
        FieldsVisitor fieldsVisitor,
     * Resets the provided {@link HitContext} with information on the current
                }
            return Integer.compare(docId, o.docId);
                int readerIndex = ReaderUtil.subIndex(docId, context.searcher().getIndexReader().leaves());
                current.put(nestedPath, new HashMap<>());
    protected FieldsVisitor createStoredFieldsVisitor(SearchContext context, Map<String, Set<String>> storedToRequestedFields) {
    ) throws E {
                    context.fetchSourceContext(new FetchSourceContext(true, fetchSourceContext.includes(), fetchSourceContext.excludes()));
import org.opensearch.common.lucene.index.SequentialStoredFieldsLeafReader;
 */
    }
        try {
        DocIdToIndex(int docId, int index) {
        }
            String[] codecSourceExcludes = codecSourceExcludes(context, requestSourceExcludes);
                );
                    }
                                context.scrollContext().cacheSequentialReader(segmentKey, sequentialReader);
            FieldsVisitor rootFieldsVisitor = new FieldsVisitor(needSource);
        String rootId;
                // Empty includes means "fetch the whole source", so every field must remain available.
     *   - Adding an initial {@link SearchHit} instance.
                }
                    FetchProfileBreakdown pbd = processorProfiles.get(p.v1());
                }
                        fieldReader = currentReaderContext.reader().storedFields()::document;
            }
                    currentReaderContext = profile(
                        LeafReaderContext readerCtx = currentReaderContext;
                            sequentialReader = context.scrollContext().getCachedSequentialReader(segmentKey);
        Map<String, Set<String>> storedToRequestedFields,
            BitSet parentBits = context.bitsetFilterCache().getBitSetProducer(parentFilter).getBitSet(subReaderContext);
        if (collectInnerHitIncludes(innerHits, requestIncludes)) {
     * Resets the provided {@link HitContext} with information on the current
                        // Only fail if we know it is an object field, missing paths / fields shouldn't fail.
        String originalName = nestedObjectMapper.name();
 * under the License.
                        p.v1().process(hit);
     *   - Adding an initial {@link SearchHit} instance.
            docs[index] = new DocIdToIndex(context.docIdsToLoad()[context.docIdsToLoadFrom() + index], index);
     */
                context.fetchSourceContext(FetchSourceContext.FETCH_SOURCE);
                requestIncludes.addAll(Arrays.asList(innerSource.includes()));
        ObjectMapper nestedObjectMapper
        FieldsVisitor fieldsVisitor,
            breakdown,
        SearchContext context,
            return new HitContext(hit, subReaderContext, subDocId, lookup.source());
        return hitContext;
            return requestExcludes;
                            p.v1().setNextReader(readerCtx);
            profile(breakdown, FetchTimingType.LOAD_STORED_FIELDS, () -> {
                for (String fieldName : fieldNames) {
                            // To get a unique identifier for this segment to use as a cache key
                    fieldReader,
    ) throws IOException {
                    requestSourceIncludes,
                loadStoredFields(context::fieldType, storedFieldReader, rootFieldsVisitor, rootDocId);
        @Override
             * <code>nestedSubDocID</code> within the nested children. Nested documents
                        }
                List<?> nestedParsedSource;
                return new FieldsVisitor(loadSource, requestSourceIncludes, requestSourceExcludes, codecSourceExcludes);
    private boolean collectInnerHitIncludes(Map<String, InnerHitsContext.InnerHitSubContext> innerHits, Set<String> requestIncludes) {
            if (storedToRequestedFields.isEmpty()) {
    }
 * software distributed under the License is distributed on an
        for (int index = 0; index < context.docIdsToLoadSize(); index++) {
                docId,
            } catch (Exception e) {
        FieldsVisitor fieldsVisitor,
    public void execute(SearchContext context) {
                }
            context,
            if (nestedParentObjectMapper != null) {
                    // encapsulates two or more object layers in the _source.
        CheckedBiConsumer<Integer, FieldsVisitor, IOException> fieldReader,
     *
                Map<String, DocumentField> metaFields = new HashMap<>();
                        .getFetchProfiler()
            if (storedToRequestedFields.containsKey(storedField)) {
                return true;
                requestIncludes.addAll(
                }
                    //
@PublicApi(since = "1.0.0")
    ) throws IOException {
            subReaderContext,
    private HitContext prepareNestedHitContext(
             */
        FetchProfileBreakdown breakdown
                profile(breakdown, FetchTimingType.LOAD_SOURCE, () -> {
        TotalHits totalHits = context.queryResult().getTotalHits();
                context,
            try {
        do {
                        .map(fieldAndFormat -> fieldAndFormat.field)
            int docId = docs[index].docId;
        List<Tuple<FetchSubPhaseProcessor, FetchSubPhase>> processors = profile(
                    current.put(nestedPath, rootSourceAsMap);
                    // nested field has an array value in the _source
                    } else {
                continue;
                        // get better sequential access.
/*
        int subDocId = docId - subReaderContext.docBase;
            }
        }
        SearchHit hit = new SearchHit(nestedTopDocId, rootId, nestedIdentity, docFields, metaFields);
                if (extractedValue instanceof List) {
                docFields = new HashMap<>();
     * document. This includes the following:
        int currentReaderIndex = -1;
            for (SearchHit.NestedIdentity nested = nestedIdentity; nested != null; nested = nested.getChild()) {
                current = nestedParentObjectMapper;
            return prepareNonNestedHitContext(
            fetchProfiler.endFetchPhase(profileDescription);
        );
public class FetchPhase {
            }
 * this file be licensed under the Apache-2.0 license or a
            // Nested inner hits read from the same root _source, so descend into their children too.
        if (context.isCancelled()) {
    }
            }
    /**
        CheckedBiConsumer<Integer, FieldsVisitor, IOException> storedFieldReader,
import org.opensearch.common.xcontent.XContentHelper;
                rootSourceAsMap = profile(breakdown, FetchTimingType.LOAD_SOURCE, rootLookup::loadSourceIfNeeded);
        SearchLookup lookup,
        int rootDocId,
                if (nested.getChild() == null) {
        Timer timer = breakdown.getTimer(timingType);
            }
                            sequentialReader = lf.getSequentialStoredFieldsReader();
                    MappedFieldType fieldType = context.fieldType(fieldName);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * field. Source include/exclude semantics are hierarchical: excluding {@code obj} also removes
    /**
                    FetchProfileBreakdown pb = context.getProfilers()
            nestedObjectMapper
                originalName = current.name();
        }
                breakdown
                if (nestedParentObjectMapper.nested().isNested() == false) {
        }
        } finally {
                requestSourceIncludes,
    }
            if (innerSource != null && innerSource.fetchSource()) {
            hitContext.sourceLookup().setSourceContentType(rootSourceContentType);
        return true;
        }
                        });
            }
        int nestedTopDocId,
     * applies these patterns.
        int nestedDocId = nestedTopDocId - subReaderContext.docBase;
                    breakdown
            if (childFilter == null) {
                            throw new IllegalArgumentException("field [" + fieldName + "] isn't a leaf field");
    }
 *
                lookup,
                if (context.mapperService().isMetadataField(storedField)) {
        CheckedBiConsumer<Integer, FieldsVisitor, IOException> storedFieldReader,
        int currentParent = nestedSubDocId;
                breakdown
     *     fetch subphases that use the hit context to access the preloaded source.
                loadSource,
        );
                            if (sequentialReader == null) {
        if (storedFieldsContext == null) {
    }
    private static boolean sourcePathOverlap(String exclude, String include) {
                return false;
        ObjectMapper nestedObjectMapper = documentMapper.findNestedObjectMapper(nestedDocId, context, subReaderContext);
            );
    private SearchHit.NestedIdentity getInternalNestedIdentity(
        SearchHit.NestedIdentity nestedIdentity = getInternalNestedIdentity(
import org.opensearch.search.SearchHits;
        context.fetchResult().hits(new SearchHits(hits, totalHits, context.queryResult().getMaxScore()));
    List<Tuple<FetchSubPhaseProcessor, FetchSubPhase>> getProcessors(SearchShardTarget target, FetchContext context) {
import org.opensearch.search.lookup.SourceLookup;
                        FetchProfileBreakdown pbd = processorProfiles.get(p.v1());
    ) throws IOException {
        if (context.mapperService().hasNested()) {
        StoredFieldsContext storedFieldsContext = context.storedFieldsContext();
        int nestedSubDocId,
            if (fieldsVisitor.fields().isEmpty() == false) {
 * KIND, either express or implied.  See the License for the
        int rootDocId = findRootDocumentIfNested(context, subReaderContext, docId - subReaderContext.docBase);
        return nestedIdentity;
                    fetchContext.searchLookup(),
     * empty values for the field it requested. Comparing per segment also keeps {@code *} from spanning a
     * {@code obj.field}, and including {@code obj} pulls in the whole {@code obj} subtree. Both patterns
        // request must stay available at the codec level. If any inner hit fetches the whole source,
                }
                    docId,
import org.apache.lucene.search.DocIdSetIterator;
                    );
 *
import org.apache.lucene.index.ReaderUtil;
            () -> getProcessors(context.shardTarget(), fetchContext)
        } catch (Exception e) {
                    }
 * The OpenSearch Contributors require contributions made to
            }
                        // For scroll queries, try to get cached reader
            });
                        }
        final Set<String> requestIncludes = new HashSet<>();
            return;
        } else if (storedFieldsContext.fetchFields() == false) {
 * Unless required by applicable law or agreed to in writing,
        int docId,
             * that appear before him.
     * children into {@code requestIncludes}.
            }
