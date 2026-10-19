        );
    private final IndexShard indexShard;
 * KIND, either express or implied.  See the License for the
import org.opensearch.index.fieldvisitor.FieldsVisitor;
            return context;
        VersionType versionType,
import org.opensearch.common.util.set.Sets;
                    fieldVisitor = buildFieldsVisitors(storedFields, fetchSourceContext);
            }
 * not use this file except in compliance with the License.
        );
                if (fieldMapper == null) {
                documentFields = new HashMap<>();
            storedFields,
 * license agreements. See the NOTICE file distributed with
                        source,
                    assert source != null : "original source in translog must exist";
                    .versionType(versionType)
        FetchSourceContext fetchSourceContext
 * Unless required by applicable law or agreed to in writing,
            Versions.MATCH_ANY,
        String[] storedFields,
                                false,
import org.apache.lucene.index.FieldInfo;
    }
            Engine.GetResult get = indexShard.get(
import java.util.Collections;
    private GetResult buildFromLookup(DocumentLookupResult lookup, FetchSourceContext fetchSourceContext) {
                existsMetric.inc(System.nanoTime() - now);
    }
                    if (mapperService.isMetadataField(entry.getKey())) {
                                0,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *
                        throw new OpenSearchException("Failed to reapply filters for [" + id + "] after reading from translog", e);
        } else {
        DocumentMapper docMapper = mapperService.documentMapper();
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.VersionType;
            }
import org.opensearch.common.document.DocumentField;
import java.util.Map;
        return source;
                                    fieldVisitor.objectField(fieldInfo, indexableField.stringValue());
            }
        try {
                fetchSourceContext.excludes()
                    source = fieldVisitor.source();
        long version,
                }
        fetchSourceContext = normalizeFetchSourceContent(fetchSourceContext, gFields);
    /**
            true,
            Map<String, Object> sourceAsMap = XContentMapValues.filter(
import java.util.stream.Stream;
                throw new OpenSearchException("Failed to reapply filters for [" + id + "] after reading from translog", e);
    ) {
            ifPrimaryTerm,
        Map<String, DocumentField> metadataFields = null;
            id,
        VersionType versionType,
                            if (status == StoredFieldVisitor.Status.YES) {
                new Engine.Get(realtime, true, id, uidTerm).version(version)
                                }
            for (String field : storedFields) {
        this.indexShard = indexShard;
        FetchSourceContext fetchSourceContext
            currentMetric.dec();
        long version,
        // Re-apply includes/excludes after translog reapply (which may have re-added excluded fields).
        VersionType versionType,
                return BytesReference.bytes(MediaTypeRegistry.contentBuilder(sourceContentType).map(sourceAsMap));
            Tuple<XContentType, Map<String, Object>> typeMapTuple = XContentHelper.convertToMap(source, true);
    private static BytesReference applySourceFilter(BytesReference source, FetchSourceContext fetchSourceContext) {
            try {
 * the Apache License, Version 2.0 (the "License"); you may
            if (SourceFieldMapper.NAME.equals(field)) {
                            );
                }
        if (fetchSourceContext.fetchSource() == false) {
        }
import org.apache.lucene.index.DocValuesSkipIndexType;
import org.opensearch.index.mapper.IdFieldMapper;
 * ownership. Elasticsearch licenses this file to you under
            return FetchSourceContext.FETCH_SOURCE;
        BytesReference source = null;
        currentMetric.inc();
            source = fieldVisitor.source();
                                false,
 * software distributed under the License is distributed on an
        }
            lookup.documentFields(),
            if (getResult.isExists()) {
        } finally {
            }
        MapperService mapperService
    /**
import org.opensearch.index.IndexSettings;
        }
            )
                                false,
/*
import org.opensearch.index.mapper.Mapper;
    }
        boolean forceSourceForComputingTranslogStoredFields = get.isFromTranslog()
                                } else if (indexableField.stringValue() != null) {
 * this work for additional information regarding copyright
     */
            } catch (IOException e) {
            source = null;
    public ShardGetService(IndexSettings indexSettings, IndexShard indexShard, MapperService mapperService) {
    public GetResult get(Engine.GetResult engineGetResult, String id, String[] fields, FetchSourceContext fetchSourceContext) {
import org.opensearch.common.xcontent.XContentHelper;
            }
    private GetResult get(
import org.opensearch.index.shard.IndexShard;
 * Licensed to Elasticsearch under one or more contributor
     * Note: Call <b>must</b> release engine searcher associated with engineGetResult!
    }
 */
public final class ShardGetService extends AbstractIndexShardComponent {
            .missingCount(missingMetric.count())
                        metadataFields.put(entry.getKey(), new DocumentField(entry.getKey(), entry.getValue()));
            currentMetric.dec();
                        throw new IllegalArgumentException("field [" + field + "] isn't a leaf field");
        String[] gFields,
import org.opensearch.common.annotation.PublicApi;
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;
    public GetResult get(
import org.opensearch.index.mapper.ParsedDocument;
            );
            FetchSourceContext.FETCH_SOURCE
            return innerGetLoadFromStoredFields(id, gFields, fetchSourceContext, get, mapperService);
            forceSourceForComputingTranslogStoredFields ? FetchSourceContext.FETCH_SOURCE : fetchSourceContext
            source,
                throw new OpenSearchException("Failed to get id [" + id + "]", e);
        }
        String[] gFields,
    /**
            new String[] { RoutingFieldMapper.NAME },
import org.opensearch.core.common.bytes.BytesReference;
        return get(id, gFields, realtime, version, versionType, UNASSIGNED_SEQ_NO, UNASSIGNED_PRIMARY_TERM, fetchSourceContext);
            GetResult getResult;
        long ifSeqNo,
 */
            return getResult;
import org.opensearch.index.mapper.RoutingFieldMapper;
            metadataFields
                        source = indexShard.mapperService().documentMapper().sourceMapper().applyFilters(source, null);
        Term uidTerm = new Term(IdFieldMapper.NAME, Uid.encodeId(id));
                                VectorEncoding.FLOAT32,
    private GetResult innerGetLoadFromStoredFields(
 */
            source = applySourceFilter(source, fetchSourceContext);
                                0,
        return new GetStats.Builder().existsCount(existsMetric.count())
                docIdAndVersion.reader.storedFields().document(docIdAndVersion.docId, fieldVisitor);
                return new GetResult(shardId.getIndexName(), id, UNASSIGNED_SEQ_NO, UNASSIGNED_PRIMARY_TERM, -1, false, null, null, null);
import java.util.concurrent.TimeUnit;
 * The OpenSearch Contributors require contributions made to
    }
            ifSeqNo,
        this.mapperService = mapperService;
            lookup.primaryTerm(),
                                false,
        if (fields == null || fields.length == 0) {
                missingMetric.inc(System.nanoTime() - now);
    public GetResult getForUpdate(String id, long ifSeqNo, long ifPrimaryTerm) {
        }
        Map<String, DocumentField> documentFields = null;
        );
                        if (fieldType.stored()) {
import org.opensearch.search.fetch.subphase.FetchSourceContext;
                Mapper fieldMapper = docMapper.mappers().getMapper(field);
        ) {
    }
 * SPDX-License-Identifier: Apache-2.0
        long ifSeqNo,
/*
 *
        } finally {
                // materialized source and fields, so build the GetResult directly from it (mirrors innerGet).
                    }
        } else {
                    .setIfSeqNo(ifSeqNo)
            if (get == null || get.exists() == false) {
            .current(currentMetric.count())
            }
            if (get instanceof DocumentLookupResult.PreMaterialized) {
        }
            try {
     * Returns {@link GetResult} based on the specified {@link org.opensearch.index.engine.Engine.GetResult} argument.
        boolean realtime,
    private static FieldsVisitor buildFieldsVisitors(String[] fields, FetchSourceContext fetchSourceContext) {
import java.io.IOException;
                        shardId.getIndexName(),
            if (getResult.isExists()) {
        String id,
        String id,
            && storedFields != null
     * This method basically loads specified fields for the associated document in the engineGetResult.
            && Stream.of(storedFields).anyMatch(f -> TranslogLeafReader.ALL_FIELD_NAMES.contains(f) == false);
@PublicApi(since = "1.0.0")
            try {
    public GetStats stats() {
        }
            lookup.version(),
                    if (docMapper.objectMappers().get(field) != null) {
    /**
                                -1,
                                IndexOptions.NONE,
 * compatible open source license.
     * are set, and {@code null} when the input is {@code null}.
                    } else {
        // check first if stored fields to be loaded don't contain an object field
                        // Only fail if we know it is an object field, missing paths / fields shouldn't fail.
        Engine.GetResult get,
     */
                typeMapTuple.v2(),
                        IndexableFieldType fieldType = indexableField.fieldType();
            documentFields,
            VersionType.INTERNAL,
            source = null;
    ) {
                            FieldInfo fieldInfo = new FieldInfo(
            } else {
import org.opensearch.common.metrics.MeanMetric;
            } catch (IOException e) {
        return new CustomFieldsVisitor(Sets.newHashSet(fields), fetchSourceContext.fetchSource());
        if (storedFields != null) {
                    }
        try (
import org.opensearch.index.mapper.MapperService;
        FetchSourceContext fetchSourceContext,
            // put stored fields into result objects
                if (forceSourceForComputingTranslogStoredFields == false) {
import org.opensearch.common.xcontent.XContentType;
     * This method load the fields from the Lucene index and not from transaction log and therefore isn't realtime.
     * <p>
                getResult = innerGetLoadFromStoredFields(id, fields, fetchSourceContext, engineGetResult, mapperService);
     * Applies request-level {@code includes}/{@code excludes} source filtering via
                source = docMapper.sourceMapper().applyFilters(source, null);
            }
        }
                                VectorSimilarityFunction.EUCLIDEAN,
            source,
                for (Map.Entry<String, List<Object>> entry : fieldVisitor.fields().entrySet()) {
            } else {
        }
            if (!fieldVisitor.fields().isEmpty()) {
        if (fieldVisitor != null) {
            }
                    } catch (IOException e) {
            source = applySourceFilter(source, fetchSourceContext);
import org.opensearch.index.engine.Engine;
    private final MeanMetric missingMetric = new MeanMetric();
/**
        }
                                    fieldVisitor.binaryField(fieldInfo, indexableField.binaryValue());
 * specific language governing permissions and limitations
                    // update special fields
    private FetchSourceContext normalizeFetchSourceContent(@Nullable FetchSourceContext context, @Nullable String[] gFields) {
                        documentFields.put(entry.getKey(), new DocumentField(entry.getKey(), entry.getValue()));
        source = applySourceFilter(source, fetchSourceContext);
 * @opensearch.api
                    ParsedDocument doc = indexShard.mapperService().documentMapper().parse(sourceToParse);
        return new GetResult(
                    for (IndexableField indexableField : doc.rootDoc().getFields()) {
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.xcontent.support.XContentMapValues;
/*
                            } else if (status == StoredFieldVisitor.Status.STOP) {
import org.opensearch.index.shard.AbstractIndexShardComponent;
                return buildFromLookup(((DocumentLookupResult.PreMaterialized) get).lookup(), fetchSourceContext);
            .existsTimeInMillis(TimeUnit.NANOSECONDS.toMillis(existsMetric.sum()))
        }
            }
    }
import org.opensearch.core.xcontent.MediaTypeRegistry;
                fetchSourceContext.includes(),
            }
import org.apache.lucene.index.VectorEncoding;
        if (source == null) {
import org.opensearch.common.Nullable;
                    }
import org.opensearch.common.lucene.uid.Versions;
        long ifPrimaryTerm,
        boolean realtime,
        String[] gFields,
import org.apache.lucene.index.DocValuesType;
            get.docIdAndVersion().primaryTerm,
        );
    }
                fieldVisitor.postProcess(mapperService::fieldType);
        if (fetchSourceContext.includes().length > 0 || fetchSourceContext.excludes().length > 0) {
     * decides what needs to be done based on the request input and always returns a valid non-null FetchSourceContext
                    SourceToParse sourceToParse = new SourceToParse(
 * Modifications Copyright OpenSearch Contributors. See
                            }
            } else {
        }
     */
            return fetchSourceContext.fetchSource() ? new FieldsVisitor(true) : null;
                    .setIfPrimaryTerm(ifPrimaryTerm)
        }
            }
import org.apache.lucene.index.IndexOptions;
import org.apache.lucene.index.IndexableField;
                return FetchSourceContext.FETCH_SOURCE;
            // in case we read from translog, some extra steps are needed to make _source consistent and to load stored fields
        long version,
        boolean realtime,
 *
                                DocValuesSkipIndexType.NONE,
            lookup.exists(),
import org.opensearch.index.mapper.SourceToParse;
            return getResult;
    }
            return new GetResult(shardId.getIndexName(), id, UNASSIGNED_SEQ_NO, UNASSIGNED_PRIMARY_TERM, -1, false, null, null, null);
            } catch (IOException e) {
        String id,
    }
        long ifPrimaryTerm,
import java.util.HashMap;
        FieldsVisitor fieldVisitor = buildFieldsVisitors(
                        fieldVisitor.routing()
import org.opensearch.index.fieldvisitor.CustomFieldsVisitor;
import org.apache.lucene.index.StoredFieldVisitor;
package org.opensearch.index.get;
        if (context != null) {
     */
        // force fetching source if we read from translog and need to recreate stored fields
                                0,
            get.docIdAndVersion().seqNo,
                    // Slow path: recreate stored fields from original source
     * request-level {@link FetchSourceContext} filters. Used by the pluggable get-by-id path.
        if (!engineGetResult.exists()) {
            XContentType sourceContentType = typeMapTuple.v1();
        currentMetric.inc();
 */
 *
        assert get.exists() : "method should only be called if document could be retrieved";
import org.apache.lucene.index.VectorSimilarityFunction;
                existsMetric.inc(System.nanoTime() - now);
            GetResult getResult = innerGet(id, gFields, realtime, version, versionType, ifSeqNo, ifPrimaryTerm, fetchSourceContext);
        DocIdAndVersion docIdAndVersion = get.docIdAndVersion();
                    try {
        return new GetResult(
            if (get.isFromTranslog()) {
            fetchSourceContext = normalizeFetchSourceContent(fetchSourceContext, fields);
            .missingTimeInMillis(TimeUnit.NANOSECONDS.toMillis(missingMetric.sum()))
                getResult = buildFromLookup(((DocumentLookupResult.PreMaterialized) engineGetResult).lookup(), fetchSourceContext);
            long now = System.nanoTime();
                        id,
            // reapply source filters from mapping (possibly also nulling the source)
    ) {
        BytesReference source = lookup.source();
            lookup.seqNo(),
 * under the License.
                    }
            lookup.id(),
     * {@link XContentMapValues}. Returns the source unchanged when no filters
            if (engineGetResult instanceof DocumentLookupResult.PreMaterialized) {
                // just make source consistent by reapplying source filters from mapping (possibly also nulling the source)
    }
import org.opensearch.index.engine.TranslogLeafReader;
                                } else if (indexableField.binaryValue() != null) {
    private final CounterMetric currentMetric = new CounterMetric();
                throw new OpenSearchException("Failed to apply source includes/excludes filter", e);
 * Gets an index shard
import org.apache.lucene.index.Term;
        String id,
import org.opensearch.index.mapper.DocumentMapper;
                // Fast path: if only asked for the source or stored fields that have been already provided by TranslogLeafReader,
            id,
                } else {
                                    fieldVisitor.objectField(fieldInfo, indexableField.numericValue());
            long now = System.nanoTime();
        }
                                Collections.emptyMap(),
            shardId.getIndexName(),
        }
                                0,
import org.apache.lucene.index.IndexableFieldType;
    private final MapperService mapperService;
        if (gFields == null) {
                        }
                    doc.version().setLongValue(docIdAndVersion.version);
                                false
                                indexableField.name(),
            return null;
            get.exists(),
                    );
                        MediaTypeRegistry.xContentType(source),
     * Builds a {@link GetResult} from a pre-materialized {@link DocumentLookupResult}, applying the
 * You may obtain a copy of the License at
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_PRIMARY_TERM;
            shardId.getIndexName(),
        try {
                }
import org.opensearch.index.mapper.Uid;
    ) {
        if (source != null && get.isFromTranslog()) {
import org.opensearch.index.mapper.SourceFieldMapper;
    private GetResult innerGet(
        for (String field : gFields) {
                    assert doc.dynamicMappingsUpdate() == null : "mapping updates should not be required on already-indexed doc";
                    // retrieve source (with possible transformations, e.g. source filters
        if (fetchSourceContext.fetchSource() == false) {
            get.version(),
                            StoredFieldVisitor.Status status = fieldVisitor.needsField(fieldInfo);
        FetchSourceContext fetchSourceContext
            // break between having loaded it from translog (so we only have _source), and having a document to load
            lookup.metadataFields()
        return FetchSourceContext.DO_NOT_FETCH_SOURCE;
    private final MeanMetric existsMetric = new MeanMetric();
                metadataFields = new HashMap<>();
                                break;
                                DocValuesType.NONE,
        super(indexShard.shardId(), indexSettings);
import org.opensearch.common.lucene.uid.VersionsAndSeqNoResolver.DocIdAndVersion;
                missingMetric.inc(System.nanoTime() - now); // This shouldn't happen...
import org.opensearch.common.metrics.CounterMetric;
                    // retrieve stored fields from parsed doc
 * GitHub history for details.
                                if (indexableField.numericValue() != null) {
        return get(
                                0,
    }
            }
                    doc.updateSeqID(docIdAndVersion.seqNo, docIdAndVersion.primaryTerm);
import java.util.List;
            .build();
}
import org.opensearch.common.collect.Tuple;
                // A PreMaterialized result carries no docId/searcher; its lookup already holds the
import org.opensearch.OpenSearchException;
