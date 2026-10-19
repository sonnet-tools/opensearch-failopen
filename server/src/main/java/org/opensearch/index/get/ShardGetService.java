                // Fast path: if only asked for the source or stored fields that have been already provided by TranslogLeafReader,  
                        if (fieldType.stored()) {
    public GetStats stats() {  
            try {
 * this file be licensed under the Apache-2.0 license or a
        if (fetchSourceContext.includes().length > 0 || fetchSourceContext.excludes().length > 0) {
            shardId.getIndexName(),
import org.apache.lucene.index.IndexableFieldType;  
        }  
            try {  
        String id,
                    for (IndexableField indexableField : doc.rootDoc().getFields()) {
            get.exists(),
                }
            lookup.seqNo(),  
            );
            if (SourceFieldMapper.NAME.equals(field)) {  
                documentFields = new HashMap<>();
            lookup.id(),
            }
        Term uidTerm = new Term(IdFieldMapper.NAME, Uid.encodeId(id));
        Map<String, DocumentField> metadataFields = null;  
/*  
import org.opensearch.index.IndexSettings;
            }
 * Modifications Copyright OpenSearch Contributors. See
                }
 * The OpenSearch Contributors require contributions made to  
        return get(
import org.opensearch.search.fetch.subphase.FetchSourceContext;
        boolean realtime,  
        }  
    }
                    .setIfSeqNo(ifSeqNo)
        BytesReference source = lookup.source();  
            if (engineGetResult instanceof DocumentLookupResult.PreMaterialized) {
import org.apache.lucene.index.VectorSimilarityFunction;
import org.apache.lucene.index.DocValuesSkipIndexType;
            lookup.exists(),  
                        IndexableFieldType fieldType = indexableField.fieldType();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }
     * Applies request-level {@code includes}/{@code excludes} source filtering via
    private GetResult get(
     */
                throw new OpenSearchException("Failed to reapply filters for [" + id + "] after reading from translog", e);
        if (source == null) {
import org.apache.lucene.index.StoredFieldVisitor;
                    SourceToParse sourceToParse = new SourceToParse(
            get.docIdAndVersion().primaryTerm,  
            Engine.GetResult get = indexShard.get(
    private GetResult innerGet(
                                false,
        boolean realtime,
                    }  
                existsMetric.inc(System.nanoTime() - now);  
                            }  
import org.opensearch.index.fieldvisitor.CustomFieldsVisitor;  
            }
        }
 */  
            } catch (IOException e) {
            source,
        return get(id, gFields, realtime, version, versionType, UNASSIGNED_SEQ_NO, UNASSIGNED_PRIMARY_TERM, fetchSourceContext);
        if (fieldVisitor != null) {
            id,  
            }
        try {
        if (fields == null || fields.length == 0) {
        }
                    );
import org.opensearch.common.metrics.CounterMetric;  
    private final MeanMetric missingMetric = new MeanMetric();
                                0,
 * under the License.  
                    assert source != null : "original source in translog must exist";
            new String[] { RoutingFieldMapper.NAME },
            currentMetric.dec();  
        boolean realtime,
import org.opensearch.index.shard.AbstractIndexShardComponent;
                    if (docMapper.objectMappers().get(field) != null) {  
                            FieldInfo fieldInfo = new FieldInfo(
            if (getResult.isExists()) {
 * not use this file except in compliance with the License.
                                DocValuesSkipIndexType.NONE,
     * {@link XContentMapValues}. Returns the source unchanged when no filters  
        }  
        } finally {
            )  
                typeMapTuple.v2(),
import org.opensearch.common.document.DocumentField;  
        VersionType versionType,
    }
    private final MapperService mapperService;  
    }  
    }  
 * Licensed to Elasticsearch under one or more contributor  
                                }  
                    // retrieve source (with possible transformations, e.g. source filters  
     * are set, and {@code null} when the input is {@code null}.
import org.opensearch.common.util.set.Sets;
import org.opensearch.index.mapper.SourceFieldMapper;
                                0,
                    // Slow path: recreate stored fields from original source  
                            } else if (status == StoredFieldVisitor.Status.STOP) {
}
     * <p>  
import org.opensearch.common.annotation.PublicApi;
            if (get instanceof DocumentLookupResult.PreMaterialized) {
    private static FieldsVisitor buildFieldsVisitors(String[] fields, FetchSourceContext fetchSourceContext) {  
            .missingCount(missingMetric.count())  
        currentMetric.inc();  
                        source = indexShard.mapperService().documentMapper().sourceMapper().applyFilters(source, null);
        return new GetStats.Builder().existsCount(existsMetric.count())
                return BytesReference.bytes(MediaTypeRegistry.contentBuilder(sourceContentType).map(sourceAsMap));
        if (gFields == null) {
                    .setIfPrimaryTerm(ifPrimaryTerm)
                missingMetric.inc(System.nanoTime() - now);
                        MediaTypeRegistry.xContentType(source),  
        fetchSourceContext = normalizeFetchSourceContent(fetchSourceContext, gFields);
        );
                    } else {
 * software distributed under the License is distributed on an
import org.opensearch.index.mapper.MapperService;
import org.opensearch.core.common.bytes.BytesReference;  
        String[] storedFields,
        String[] gFields,
            .current(currentMetric.count())
            .missingTimeInMillis(TimeUnit.NANOSECONDS.toMillis(missingMetric.sum()))
        // force fetching source if we read from translog and need to recreate stored fields  
        super(indexShard.shardId(), indexSettings);
import org.opensearch.common.metrics.MeanMetric;
            source,  
        return new CustomFieldsVisitor(Sets.newHashSet(fields), fetchSourceContext.fetchSource());
        if (context != null) {
import org.opensearch.index.mapper.IdFieldMapper;  
import org.opensearch.core.xcontent.MediaTypeRegistry;
        );  
            lookup.documentFields(),
            documentFields,
        }
        return FetchSourceContext.DO_NOT_FETCH_SOURCE;
    /**
                for (Map.Entry<String, List<Object>> entry : fieldVisitor.fields().entrySet()) {
            source = fieldVisitor.source();
            return FetchSourceContext.FETCH_SOURCE;  
                    }
            } catch (IOException e) {  
     * Note: Call <b>must</b> release engine searcher associated with engineGetResult!
                    // update special fields
        this.indexShard = indexShard;  
                        documentFields.put(entry.getKey(), new DocumentField(entry.getKey(), entry.getValue()));
        );
    private final CounterMetric currentMetric = new CounterMetric();  
                throw new OpenSearchException("Failed to get id [" + id + "]", e);  
        }  
                return buildFromLookup(((DocumentLookupResult.PreMaterialized) get).lookup(), fetchSourceContext);  
    }
            for (String field : storedFields) {  
            lookup.version(),
        assert get.exists() : "method should only be called if document could be retrieved";
 */  
            if (!fieldVisitor.fields().isEmpty()) {  
import org.apache.lucene.index.IndexableField;
    ) {
import org.opensearch.common.xcontent.support.XContentMapValues;
import org.apache.lucene.index.IndexOptions;
import java.util.Map;
                Mapper fieldMapper = docMapper.mappers().getMapper(field);
            fetchSourceContext = normalizeFetchSourceContent(fetchSourceContext, fields);
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.index.engine.Engine;
            // break between having loaded it from translog (so we only have _source), and having a document to load
            lookup.primaryTerm(),
        FieldsVisitor fieldVisitor = buildFieldsVisitors(
    }
import org.opensearch.index.mapper.SourceToParse;  
                return new GetResult(shardId.getIndexName(), id, UNASSIGNED_SEQ_NO, UNASSIGNED_PRIMARY_TERM, -1, false, null, null, null);  
            XContentType sourceContentType = typeMapTuple.v1();  
 * the Apache License, Version 2.0 (the "License"); you may
                missingMetric.inc(System.nanoTime() - now); // This shouldn't happen...
            VersionType.INTERNAL,
        } else {
import org.opensearch.index.fieldvisitor.FieldsVisitor;
import java.util.HashMap;
import org.opensearch.common.xcontent.XContentType;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.index.engine.TranslogLeafReader;
                                } else if (indexableField.stringValue() != null) {
        long version,
                                VectorSimilarityFunction.EUCLIDEAN,  
                                IndexOptions.NONE,
                fetchSourceContext.includes(),  
    /**
            .build();  
            // reapply source filters from mapping (possibly also nulling the source)  
            }
public final class ShardGetService extends AbstractIndexShardComponent {
 * Unless required by applicable law or agreed to in writing,
        }  
            get.version(),
        }  
            }
        FetchSourceContext fetchSourceContext  
        long version,  
        String[] gFields,  
            Tuple<XContentType, Map<String, Object>> typeMapTuple = XContentHelper.convertToMap(source, true);
                    // retrieve stored fields from parsed doc  
                return FetchSourceContext.FETCH_SOURCE;
            }
                        source,
                        shardId.getIndexName(),  
        }
                        throw new IllegalArgumentException("field [" + field + "] isn't a leaf field");
    ) {
        MapperService mapperService
        if (fetchSourceContext.fetchSource() == false) {
        currentMetric.inc();
        if (!engineGetResult.exists()) {
import java.util.Collections;
            source = null;
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.lucene.uid.VersionsAndSeqNoResolver.DocIdAndVersion;
    private GetResult buildFromLookup(DocumentLookupResult lookup, FetchSourceContext fetchSourceContext) {
        try {  
 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
            } else {
        DocIdAndVersion docIdAndVersion = get.docIdAndVersion();
        BytesReference source = null;
        ) {
                fetchSourceContext.excludes()
        long ifPrimaryTerm,
    public ShardGetService(IndexSettings indexSettings, IndexShard indexShard, MapperService mapperService) {  
                                false,
        return new GetResult(  
import org.opensearch.index.mapper.Mapper;
        return new GetResult(
                                Collections.emptyMap(),  
        if (storedFields != null) {
            if (get == null || get.exists() == false) {
                // materialized source and fields, so build the GetResult directly from it (mirrors innerGet).  
                                -1,
        String id,  
                                if (indexableField.numericValue() != null) {  
                                break;
        }
                                } else if (indexableField.binaryValue() != null) {
                    source = fieldVisitor.source();
                        // Only fail if we know it is an object field, missing paths / fields shouldn't fail.
    }
        this.mapperService = mapperService;
 * compatible open source license.
        // check first if stored fields to be loaded don't contain an object field  
            return new GetResult(shardId.getIndexName(), id, UNASSIGNED_SEQ_NO, UNASSIGNED_PRIMARY_TERM, -1, false, null, null, null);
            return getResult;
                docIdAndVersion.reader.storedFields().document(docIdAndVersion.docId, fieldVisitor);
                            );  
    }  
                new Engine.Get(realtime, true, id, uidTerm).version(version)
        FetchSourceContext fetchSourceContext
        VersionType versionType,
                source = docMapper.sourceMapper().applyFilters(source, null);
            long now = System.nanoTime();
                } else {
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;  
                                0,  
            if (getResult.isExists()) {
                if (forceSourceForComputingTranslogStoredFields == false) {
    ) {
        DocumentMapper docMapper = mapperService.documentMapper();
 * @opensearch.api
    private GetResult innerGetLoadFromStoredFields(  
import org.opensearch.index.mapper.Uid;
                                0,
        String[] gFields,
                throw new OpenSearchException("Failed to apply source includes/excludes filter", e);  
        try (  
import org.apache.lucene.index.VectorEncoding;  
 *
            }  
                    doc.updateSeqID(docIdAndVersion.seqNo, docIdAndVersion.primaryTerm);  
            return innerGetLoadFromStoredFields(id, gFields, fetchSourceContext, get, mapperService);  
        for (String field : gFields) {
    }
                    }  
        Map<String, DocumentField> documentFields = null;
            shardId.getIndexName(),  
                        metadataFields.put(entry.getKey(), new DocumentField(entry.getKey(), entry.getValue()));  
        Engine.GetResult get,
                                indexableField.name(),  
            Versions.MATCH_ANY,  
                    .versionType(versionType)  
            source = applySourceFilter(source, fetchSourceContext);
import java.util.stream.Stream;  
        } finally {
import org.opensearch.index.mapper.DocumentMapper;
                                    fieldVisitor.objectField(fieldInfo, indexableField.stringValue());
import org.opensearch.common.xcontent.XContentHelper;  
        if (source != null && get.isFromTranslog()) {
                if (fieldMapper == null) {
            // put stored fields into result objects
            FetchSourceContext.FETCH_SOURCE
    public GetResult getForUpdate(String id, long ifSeqNo, long ifPrimaryTerm) {
                    if (mapperService.isMetadataField(entry.getKey())) {
            return context;  
            id,
            long now = System.nanoTime();
     * decides what needs to be done based on the request input and always returns a valid non-null FetchSourceContext
            storedFields,
                metadataFields = new HashMap<>();  
     * Builds a {@link GetResult} from a pre-materialized {@link DocumentLookupResult}, applying the
        long ifSeqNo,
            }
                        }
                            if (status == StoredFieldVisitor.Status.YES) {
                                0,
    /**
        long ifSeqNo,
        FetchSourceContext fetchSourceContext  
import org.apache.lucene.index.FieldInfo;  
 */  
    }
        FetchSourceContext fetchSourceContext,  
     * This method basically loads specified fields for the associated document in the engineGetResult.
            forceSourceForComputingTranslogStoredFields ? FetchSourceContext.FETCH_SOURCE : fetchSourceContext  
                    doc.version().setLongValue(docIdAndVersion.version);
                        id,
        // Re-apply includes/excludes after translog reapply (which may have re-added excluded fields).
@PublicApi(since = "1.0.0")
                existsMetric.inc(System.nanoTime() - now);  
                    try {  
/*
/*  
            currentMetric.dec();  
/**
    private static BytesReference applySourceFilter(BytesReference source, FetchSourceContext fetchSourceContext) {  
                                DocValuesType.NONE,  
                }
 *
 * You may obtain a copy of the License at  
            && Stream.of(storedFields).anyMatch(f -> TranslogLeafReader.ALL_FIELD_NAMES.contains(f) == false);  
import org.apache.lucene.index.Term;
     */  
                            StoredFieldVisitor.Status status = fieldVisitor.needsField(fieldInfo);
        }
import org.opensearch.index.VersionType;  
            }  
                                    fieldVisitor.binaryField(fieldInfo, indexableField.binaryValue());  
        }  
            }  
        long ifPrimaryTerm,  
                    assert doc.dynamicMappingsUpdate() == null : "mapping updates should not be required on already-indexed doc";
    }
                                false
        if (fetchSourceContext.fetchSource() == false) {
                    }
            GetResult getResult = innerGet(id, gFields, realtime, version, versionType, ifSeqNo, ifPrimaryTerm, fetchSourceContext);  
     * request-level {@link FetchSourceContext} filters. Used by the pluggable get-by-id path.  
            source = applySourceFilter(source, fetchSourceContext);
import org.opensearch.common.lucene.uid.Versions;
            try {  
        String id,
import org.opensearch.OpenSearchException;
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_PRIMARY_TERM;
 * Gets an index shard  
            return fetchSourceContext.fetchSource() ? new FieldsVisitor(true) : null;
            GetResult getResult;  
        }
            lookup.metadataFields()  
            if (get.isFromTranslog()) {
                    fieldVisitor = buildFieldsVisitors(storedFields, fetchSourceContext);
        );
                getResult = buildFromLookup(((DocumentLookupResult.PreMaterialized) engineGetResult).lookup(), fetchSourceContext);
import org.apache.lucene.index.DocValuesType;
            // in case we read from translog, some extra steps are needed to make _source consistent and to load stored fields
            metadataFields
 */
        String id,
                                false,  
import org.opensearch.index.mapper.ParsedDocument;  
     */
                                    fieldVisitor.objectField(fieldInfo, indexableField.numericValue());
    }
            } catch (IOException e) {
            return getResult;
     * This method load the fields from the Lucene index and not from transaction log and therefore isn't realtime.
import org.opensearch.index.shard.IndexShard;  
import java.io.IOException;  
                    } catch (IOException e) {
            return null;
            .existsTimeInMillis(TimeUnit.NANOSECONDS.toMillis(existsMetric.sum()))
                getResult = innerGetLoadFromStoredFields(id, fields, fetchSourceContext, engineGetResult, mapperService);  
                        fieldVisitor.routing()
        } else {  
        VersionType versionType,  
            ifPrimaryTerm,  
                    ParsedDocument doc = indexShard.mapperService().documentMapper().parse(sourceToParse);  
     * Returns {@link GetResult} based on the specified {@link org.opensearch.index.engine.Engine.GetResult} argument.  
            ifSeqNo,
                                false,
 * specific language governing permissions and limitations
            get.docIdAndVersion().seqNo,
    /**
import org.opensearch.index.mapper.RoutingFieldMapper;
import java.util.List;  
import java.util.concurrent.TimeUnit;
            true,
        long version,
    public GetResult get(Engine.GetResult engineGetResult, String id, String[] fields, FetchSourceContext fetchSourceContext) {  
    private final IndexShard indexShard;
                                VectorEncoding.FLOAT32,
 *
        source = applySourceFilter(source, fetchSourceContext);  
        return source;  
 * GitHub history for details.
                fieldVisitor.postProcess(mapperService::fieldType);
            Map<String, Object> sourceAsMap = XContentMapValues.filter(
                // A PreMaterialized result carries no docId/searcher; its lookup already holds the
import org.opensearch.common.collect.Tuple;
            } else {
    private FetchSourceContext normalizeFetchSourceContent(@Nullable FetchSourceContext context, @Nullable String[] gFields) {
 *  
    public GetResult get(  
        }  
    ) {  
package org.opensearch.index.get;
        boolean forceSourceForComputingTranslogStoredFields = get.isFromTranslog()
            && storedFields != null
     */
                // just make source consistent by reapplying source filters from mapping (possibly also nulling the source)
import org.opensearch.common.Nullable;  
            source = null;  
    private final MeanMetric existsMetric = new MeanMetric();
                        throw new OpenSearchException("Failed to reapply filters for [" + id + "] after reading from translog", e);  
            } else {
