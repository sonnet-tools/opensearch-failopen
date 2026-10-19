            actionFilters,  
                    addFieldMapper(fieldPredicate, fieldMapper.name(), fieldMapper, fieldMappings, request.includeDefaults());  
            }
            indexNameExpressionResolver,
import org.opensearch.action.admin.indices.mapping.get.GetFieldMappingsResponse.FieldMappingMetadata;
                fieldMappings.put(field, new FieldMappingMetadata(fieldMapper.name(), bytes));
    }
import org.opensearch.index.IndexService;
 * this work for additional information regarding copyright
import java.util.Map;  
        }  
 * Transport action used to retrieve the mappings related to fields that belong to a specific index  
                );  
                for (Mapper fieldMapper : allFieldMappers) {  
/*  
            } else if (Regex.isSimpleMatchPattern(field)) {
import org.opensearch.cluster.service.ClusterService;
 * compatible open source license.
                // not a pattern  
            if (INCLUDE_DEFAULTS.equals(key)) {
            if (INCLUDE_DEFAULTS.equals(key)) {
            } else {
                return "true";
            return defaultValue;
        public String param(String key, String defaultValue) {
        Predicate<String> fieldPredicate,
            if (INCLUDE_DEFAULTS.equals(key)) {
    @Override  
        Map<String, FieldMappingMetadata> fieldMappings = new HashMap<>();
        Predicate<String> fieldPredicate = metadataFieldPredicate.or(indicesService.getFieldFilter().apply(shardId.getIndexName()));
        }
        public boolean paramAsBoolean(String key, boolean defaultValue) {
                }
        }
                    if (Regex.simpleMatch(field, fieldMapper.name())) {
        if (documentMapper == null) {
    private final IndicesService indicesService;
 *
                    MediaTypeRegistry.JSON,  
    private static final String ACTION_NAME = GetFieldMappingsAction.NAME + "[index]";
        @Override
    protected GetFieldMappingsResponse shardOperation(final GetFieldMappingsIndexRequest request, ShardId shardId) {
public class TransportGetFieldMappingsIndexAction extends TransportSingleShardAction<
import org.opensearch.OpenSearchException;
import org.opensearch.index.mapper.Mapper;  
 * KIND, either express or implied.  See the License for the
        if (fieldPredicate.test(field)) {
        ActionFilters actionFilters,
 * GitHub history for details.
                    fieldMapper,
import org.opensearch.cluster.routing.ShardsIterator;  
 * license agreements. See the NOTICE file distributed with
 * under the License.  
            }  
    GetFieldMappingsIndexRequest,
            return Collections.emptyMap();
        Predicate<String> metadataFieldPredicate = (f) -> indicesService.isMetadataField(f);
        @Override  
        IndicesService indicesService,
 *
        boolean includeDefaults  
import static java.util.Collections.singletonMap;  
            }
import org.opensearch.core.xcontent.XContentHelper;  
    @Override  
            }  
import org.opensearch.indices.IndicesService;
import org.opensearch.core.common.io.stream.Writeable;
 * the Apache License, Version 2.0 (the "License"); you may
        return state.blocks().indexBlockedException(ClusterBlockLevel.METADATA_READ, request.concreteIndex());
        this.indicesService = indicesService;  
            threadPool,  
import org.opensearch.index.mapper.DocumentMapper;
        Map<String, FieldMappingMetadata> fieldMapping = findFieldMappings(fieldPredicate, documentMapper, request);
            clusterService,
        Map<String, FieldMappingMetadata> fieldMappings,
            ThreadPool.Names.MANAGEMENT  
    public TransportGetFieldMappingsIndexAction(
                    }  
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
    protected final ClusterService clusterService;
 * The OpenSearch Contributors require contributions made to  
    @Override  
import java.io.IOException;  
        for (String field : request.fields()) {  
/**
                if (fieldMapper != null) {
        Mapper fieldMapper,
        static final String INCLUDE_DEFAULTS = "include_defaults";  
 * Modifications Copyright OpenSearch Contributors. See
    private static final ToXContent.Params includeDefaultsParams = new ToXContent.Params() {
    }
    protected ShardsIterator shards(ClusterState state, InternalRequest request) {
    }
        assert shardId != null;
        final MappingLookup allFieldMappers = documentMapper.mappers();
                return "true";
import org.opensearch.core.xcontent.ToXContent;
        ThreadPool threadPool,  
        // internal action, index already resolved
    }  
                }
                Mapper fieldMapper = allFieldMappers.getMapper(field);
        return state.routingTable().index(request.concreteIndex()).randomAllActiveShardsIt();  
            if (Regex.isMatchAllPattern(field)) {
    }  
import org.opensearch.action.support.single.shard.TransportSingleShardAction;
                BytesReference bytes = XContentHelper.toXContent(
        public String param(String key) {  
import org.opensearch.core.xcontent.MediaTypeRegistry;
        return false;  
            return defaultValue;
                return true;  
import java.util.Collections;
 * SPDX-License-Identifier: Apache-2.0
    private static void addFieldMapper(
        }
import org.opensearch.cluster.block.ClusterBlockLevel;
/*  
    @Inject
            GetFieldMappingsIndexRequest::new,
import org.opensearch.transport.TransportService;
    };  
        }
                for (Mapper fieldMapper : allFieldMappers) {
 */  
                return true;
            }
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        IndexService indexService = indicesService.indexServiceSafe(shardId.getIndex());  
            }
        // Will balance requests between shards
import org.opensearch.index.mapper.MappingLookup;
import org.opensearch.common.regex.Regex;  
 *     http://www.apache.org/licenses/LICENSE-2.0
        GetFieldMappingsIndexRequest request
    ) {
        @Override
 * You may obtain a copy of the License at  
                    includeDefaults ? includeDefaultsParams : ToXContent.EMPTY_PARAMS,
import org.opensearch.core.index.shard.ShardId;  
 * ownership. Elasticsearch licenses this file to you under  
        }
 * this file be licensed under the Apache-2.0 license or a
 */
package org.opensearch.action.admin.indices.mapping.get;
            return defaultValue;  
 * specific language governing permissions and limitations
    @Override  
        return Collections.unmodifiableMap(fieldMappings);
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            ACTION_NAME,
 */  
            transportService,
                    false
            return null;
 * Unless required by applicable law or agreed to in writing,
    ) {  
    private static Map<String, FieldMappingMetadata> findFieldMappings(
    GetFieldMappingsResponse> {  
        if (fieldMappings.containsKey(field)) {
    protected Writeable.Reader<GetFieldMappingsResponse> getResponseReader() {
                    addFieldMapper(fieldPredicate, field, fieldMapper, fieldMappings, request.includeDefaults());  
    }
 *
        }  
            try {  
    @Override
            if (INCLUDE_DEFAULTS.equals(key)) {  
    }
 */  
import org.opensearch.action.support.ActionFilters;  
        DocumentMapper documentMapper,
}
            return;  
import org.opensearch.core.common.bytes.BytesReference;
/*
        ClusterService clusterService,  
        String field,  
import org.opensearch.cluster.block.ClusterBlockException;  
                        addFieldMapper(fieldPredicate, fieldMapper.name(), fieldMapper, fieldMappings, request.includeDefaults());
                throw new OpenSearchException("failed to serialize XContent of field [" + field + "]", e);  
        );
        DocumentMapper documentMapper = indexService.mapperService().documentMapper();
        this.clusterService = clusterService;
            } catch (IOException e) {
import org.opensearch.common.inject.Inject;
        @Override
 *  
        }  
                }
 * @opensearch.internal
        super(
        return GetFieldMappingsResponse::new;
        Predicate<String> fieldPredicate,  
import java.util.HashMap;
import java.util.function.Predicate;
    protected boolean resolveIndex(GetFieldMappingsIndexRequest request) {
    ) {  
        return new GetFieldMappingsResponse(singletonMap(shardId.getIndexName(), fieldMapping));  
    }
import org.opensearch.cluster.ClusterState;
        public Boolean paramAsBoolean(String key, Boolean defaultValue) {  
    protected ClusterBlockException checkRequestBlock(ClusterState state, InternalRequest request) {  
        IndexNameExpressionResolver indexNameExpressionResolver
        TransportService transportService,
import org.opensearch.threadpool.ThreadPool;  
