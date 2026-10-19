     * These are consulted when an unmapped array field is encountered during document indexing  
    /**
    }
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
    default Map<String, DynamicTemplateTypeHandler> getDynamicTemplateTypes() {
/*  
     * The key is the type string, and the value is the handler that adjusts
     * the mapper builder when a template matches.  
import org.opensearch.index.mapper.MappingTransformer;
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
     */
     * or otherwise operate on payload data. The predicate receives the field name as its input and should return {@code true} to show the
     * field and {@code false} to hide it.
 * under the License.  
/*  
    }  
     * The default field filter applied, which doesn't filter anything. That means that by default get mappings, get index  
     * <p>  
     * The key of the returned {@link Map} is the unique name for the mapper which will be used
 */
     * reintroduce rejected fields through another metadata or planning path.
     * Returns additional mapper implementations added by this plugin.  
 * ownership. Elasticsearch licenses this file to you under  
        return Collections.emptyList();
package org.opensearch.plugins;
 * not use this file except in compliance with the License.
 *
     * (e.g. "knn_vector") that users can reference in dynamic templates.
    /**
 * An extension point for {@link Plugin} implementations to add custom mappers
 * this file be licensed under the Apache-2.0 license or a
    /**
 *  
 * @opensearch.api
     */
     * mapper settings into a {@link Mapper}.
    }
     * as the mapping {@code type}, and the value is a {@link Mapper.TypeParser} to parse the  
    default Map<String, Mapper.TypeParser> getMappers() {  
     */  
import org.opensearch.index.mapper.DynamicTemplateTypeHandler;
    default List<MappingTransformer> getMappingTransformers() {  
     * Returns dynamic template types registered by this plugin.
    }
 * Unless required by applicable law or agreed to in writing,
 */  
     * Returns dynamic field type inferencers provided by this plugin.
     */
     *
     * The key of the returned {@link Map} is the unique name for the metadata mapper, which
    }
    /**
     *  
    }
     * <p>The filter also applies to query schemas and query planning. Query engines must apply it before field-name resolution, wildcard
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**
     * is used in the mapping json to configure the metadata mapper, and the value is a
    /**
     */
    default Map<String, MetadataFieldMapper.TypeParser> getMetadataMappers() {  
     *
 *  
     * These allow plugins to register custom match_mapping_type strings  
        return Collections.emptyMap();
/**
     * alias, wildcard, data stream, or other index expression.
 */  
 * this work for additional information regarding copyright
     * get field mappings and field capabilities API will return every field that's present in the mappings.
     */
     * expansion, validation, and logical or physical plan construction so a hidden field cannot be projected, filtered, aggregated,
    default List<DynamicFieldTypeInferencer> getDynamicFieldTypeInferencers() {  
import java.util.Collections;
     * <p>Implementations may use this filter to enforce authorization access controls such as field-level security. Consumers must  
     * The default field predicate applied, which doesn't filter anything. That means that by default get mappings, get index  
     * sorted, joined, or passed to a function. The function is evaluated with concrete index names, including when the request used an  
     * Returns mapper transformer implementations added by this plugin.  
import java.util.function.Predicate;
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
     */
     * {@link MetadataFieldMapper.TypeParser} to parse the mapper settings into a  
import java.util.function.Function;
 * software distributed under the License is distributed on an
        return Collections.emptyMap();  
 *
    /**
    Function<String, Predicate<String>> NOOP_FIELD_FILTER = index -> NOOP_FIELD_PREDICATE;  
        return NOOP_FIELD_FILTER;
import org.opensearch.index.mapper.MetadataFieldMapper;
    default Function<String, Predicate<String>> getFieldFilter() {
}
 * GitHub history for details.
/*
     * and no template matches. The first inferencer to claim a field wins.
     * <p>
     * Returns a function that, given a concrete index name, returns a predicate that determines field visibility. Consumers include
import org.opensearch.index.mapper.Mapper;  
    /**
import org.opensearch.index.mapper.DynamicFieldTypeInferencer;
     * Returns additional metadata mapper implementations added by this plugin.
 * Licensed to Elasticsearch under one or more contributor  
 */
        return Collections.emptyMap();
 * Modifications Copyright OpenSearch Contributors. See
     */
public interface MapperPlugin {  
 * SPDX-License-Identifier: Apache-2.0
     * get field mappings and field capabilities API will return every field that's present in the mappings.
     * metadata APIs such as get mappings, get index, get field mappings, and field capabilities, as well as APIs that access field values  
import java.util.List;
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
        return Collections.emptyList();
import java.util.Map;  
     * {@link MetadataFieldMapper}.
     * therefore treat it as an access-control boundary rather than a presentation-only filter: they must not bypass the predicate or
    Predicate<String> NOOP_FIELD_PREDICATE = field -> true;  
