/*
        public String param(String key, String defaultValue) {
    ) {
 *
    protected Writeable.Reader<GetFieldMappingsResponse> getResponseReader() {
 * Unless required by applicable law or agreed to in writing,
    protected GetFieldMappingsResponse shardOperation(final GetFieldMappingsIndexRequest request, ShardId shardId) {
import org.opensearch.transport.TransportService;
 * @opensearch.internal
            return;
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.common.regex.Regex;
        if (documentMapper == null) {
        super(
            if (INCLUDE_DEFAULTS.equals(key)) {
import org.opensearch.action.support.ActionFilters;
import org.opensearch.action.admin.indices.mapping.get.GetFieldMappingsResponse.FieldMappingMetadata;
        }
                    includeDefaults ? includeDefaultsParams : ToXContent.EMPTY_PARAMS,
        Map<String, FieldMappingMetadata> fieldMappings,
        return GetFieldMappingsResponse::new;
    @Inject
            } catch (IOException e) {
        ClusterService clusterService,
            clusterService,
                );
                    if (Regex.simpleMatch(field, fieldMapper.name())) {
        return state.blocks().indexBlockedException(ClusterBlockLevel.METADATA_READ, request.concreteIndex());
        }
    @Override
 */
    public TransportGetFieldMappingsIndexAction(
 * compatible open source license.
/*
            if (INCLUDE_DEFAULTS.equals(key)) {
/*
                return true;
import org.opensearch.core.xcontent.MediaTypeRegistry;
        GetFieldMappingsIndexRequest request
                    addFieldMapper(fieldPredicate, field, fieldMapper, fieldMappings, request.includeDefaults());
 *
        }
            try {
        @Override
        static final String INCLUDE_DEFAULTS = "include_defaults";
import java.util.Map;
        for (String field : request.fields()) {
 * this work for additional information regarding copyright
    protected final ClusterService clusterService;
    }
import org.opensearch.index.IndexService;
                        addFieldMapper(fieldPredicate, fieldMapper.name(), fieldMapper, fieldMappings, request.includeDefaults());
                // not a pattern
        this.indicesService = indicesService;
            }
    }
    }
            if (Regex.isMatchAllPattern(field)) {
import java.util.function.Predicate;
 * GitHub history for details.
            }
import org.opensearch.action.support.single.shard.TransportSingleShardAction;
    GetFieldMappingsIndexRequest,
import org.opensearch.cluster.block.ClusterBlockLevel;
                if (fieldMapper != null) {
import org.opensearch.cluster.ClusterState;
 */
import org.opensearch.core.xcontent.XContentHelper;
        @Override
                    }
                BytesReference bytes = XContentHelper.toXContent(
 * under the License.
                    MediaTypeRegistry.JSON,
    protected boolean resolveIndex(GetFieldMappingsIndexRequest request) {
                throw new OpenSearchException("failed to serialize XContent of field [" + field + "]", e);
            return defaultValue;
            }
            } else {
public class TransportGetFieldMappingsIndexAction extends TransportSingleShardAction<
 *
                return "true";
        final MappingLookup allFieldMappers = documentMapper.mappers();
                Mapper fieldMapper = allFieldMappers.getMapper(field);
                fieldMappings.put(field, new FieldMappingMetadata(fieldMapper.name(), bytes));
                    addFieldMapper(fieldPredicate, fieldMapper.name(), fieldMapper, fieldMappings, request.includeDefaults());
            indexNameExpressionResolver,
        public Boolean paramAsBoolean(String key, Boolean defaultValue) {
import org.opensearch.cluster.service.ClusterService;
}
import org.opensearch.indices.IndicesService;
import org.opensearch.core.common.io.stream.Writeable;
import org.opensearch.cluster.routing.ShardsIterator;
    protected ClusterBlockException checkRequestBlock(ClusterState state, InternalRequest request) {
        IndexNameExpressionResolver indexNameExpressionResolver
    @Override
import org.opensearch.common.inject.Inject;
            if (INCLUDE_DEFAULTS.equals(key)) {
 * not use this file except in compliance with the License.
import org.opensearch.core.index.shard.ShardId;
package org.opensearch.action.admin.indices.mapping.get;
            return defaultValue;
 * the Apache License, Version 2.0 (the "License"); you may
    }
        }
            threadPool,
import org.opensearch.core.xcontent.ToXContent;
        public boolean paramAsBoolean(String key, boolean defaultValue) {
        Mapper fieldMapper,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        @Override
        }
 * SPDX-License-Identifier: Apache-2.0
 *
        this.clusterService = clusterService;
 */
        Predicate<String> fieldPredicate = metadataFieldPredicate.or(indicesService.getFieldFilter().apply(shardId.getIndexName()));
            return defaultValue;
            }
                }
        TransportService transportService,
    };
                return true;
    @Override
        return new GetFieldMappingsResponse(singletonMap(shardId.getIndexName(), fieldMapping));
    ) {
    }
        DocumentMapper documentMapper = indexService.mapperService().documentMapper();
                for (Mapper fieldMapper : allFieldMappers) {
import org.opensearch.OpenSearchException;
 * specific language governing permissions and limitations
        if (fieldMappings.containsKey(field)) {
import org.opensearch.threadpool.ThreadPool;
    ) {
        return false;
    }
        Map<String, FieldMappingMetadata> fieldMapping = findFieldMappings(fieldPredicate, documentMapper, request);
        @Override
        String field,
            GetFieldMappingsIndexRequest::new,
 *     http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.core.common.bytes.BytesReference;
            } else if (Regex.isSimpleMatchPattern(field)) {
    GetFieldMappingsResponse> {
        Predicate<String> metadataFieldPredicate = (f) -> indicesService.isMetadataField(f);
        public String param(String key) {
 * software distributed under the License is distributed on an
        ActionFilters actionFilters,
    protected ShardsIterator shards(ClusterState state, InternalRequest request) {
            ThreadPool.Names.MANAGEMENT
        boolean includeDefaults
    }
 */
 * this file be licensed under the Apache-2.0 license or a
        IndicesService indicesService,
            }
        DocumentMapper documentMapper,
                for (Mapper fieldMapper : allFieldMappers) {
        );
    private static final ToXContent.Params includeDefaultsParams = new ToXContent.Params() {
            if (INCLUDE_DEFAULTS.equals(key)) {
    }
import static java.util.Collections.singletonMap;
    private final IndicesService indicesService;
        return state.routingTable().index(request.concreteIndex()).randomAllActiveShardsIt();
import org.opensearch.index.mapper.DocumentMapper;
        return Collections.unmodifiableMap(fieldMappings);
            return null;
        // Will balance requests between shards
            }
                }
        if (fieldPredicate.test(field)) {
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
 * Transport action used to retrieve the mappings related to fields that belong to a specific index
        Map<String, FieldMappingMetadata> fieldMappings = new HashMap<>();
                    false
    @Override
        ThreadPool threadPool,
        }
    private static void addFieldMapper(
import org.opensearch.index.mapper.MappingLookup;
    private static final String ACTION_NAME = GetFieldMappingsAction.NAME + "[index]";
 * KIND, either express or implied.  See the License for the
        }
import java.util.Collections;
        IndexService indexService = indicesService.indexServiceSafe(shardId.getIndex());
    private static Map<String, FieldMappingMetadata> findFieldMappings(
            return Collections.emptyMap();
    @Override
import org.opensearch.index.mapper.Mapper;
            ACTION_NAME,
                return "true";
/**
import java.io.IOException;
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
        // internal action, index already resolved
        Predicate<String> fieldPredicate,
            transportService,
            actionFilters,
import org.opensearch.cluster.block.ClusterBlockException;
 * You may obtain a copy of the License at
import java.util.HashMap;
        assert shardId != null;
                    fieldMapper,
                }
        }
 * The OpenSearch Contributors require contributions made to
        Predicate<String> fieldPredicate,
