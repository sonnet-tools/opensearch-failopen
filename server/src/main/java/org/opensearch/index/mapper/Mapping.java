    /**
                    mapper.toXContent(builder, params);
}
    public String toString() {
import org.opensearch.core.xcontent.XContentBuilder;
 * license agreements. See the NOTICE file distributed with
 */
 * the Apache License, Version 2.0 (the "License"); you may
                merged = metaMergeWith;
        this.metadataMappersByName = unmodifiableMap(metadataMappersByName);
 * compatible open source license.
        Map<Class<? extends MetadataFieldMapper>, MetadataFieldMapper> metadataMappersMap = new HashMap<>();
    final Map<String, MetadataFieldMapper> metadataMappersByName;  
import org.opensearch.common.annotation.PublicApi;
            mergedMeta = mergeWith.meta;  
        // completely overwrite existing ones instead of being merged. This behavior matches how we  
        // When merging metadata fields as part of applying an index template, new field definitions
import java.io.UncheckedIOException;
 */
 *  
    public Mapping mappingUpdate(Mapper rootObjectMapper) {  
            } else {
@PublicApi(since = "1.0.0")
    final Version indexCreated;
        // keep root mappers sorted for consistent serialization  
    @SuppressWarnings("unchecked")
 * KIND, either express or implied.  See the License for the
    public Mapping(  
     * @param reason the reason this merge was initiated.
 * The OpenSearch Contributors require contributions made to  
     * @param mergeWith the new mapping to merge into this one.
     * Merges a new mapping into the existing one.
    }
        this.indexCreated = indexCreated;  
    public void validate(MappingLookup mappers) {
                }
    final RootObjectMapper root;  
 * Licensed to Elasticsearch under one or more contributor  
        return (T) metadataMappersMap.get(clazz);
        return builder;  
        return metadataMappersByName.get(mapperName);
        Version indexCreated,
    @Override
        try {
import org.opensearch.Version;
    }
        });
import java.util.Map;  
        }
 * SPDX-License-Identifier: Apache-2.0
    public <T extends MetadataFieldMapper> T metadataMapper(Class<T> clazz) {  
 */  
        for (MetadataFieldMapper metadataMapper : metadataMappers) {
 * software distributed under the License is distributed on an
 * under the License.  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
        // merge leaf fields in the 'properties' section of the mapping.
                return builder;  
        } else if (meta == null || reason != MergeReason.INDEX_TEMPLATE) {
import org.opensearch.index.mapper.MapperService.MergeReason;
                return o1.name().compareTo(o2.name());
    }  
            mergedMeta = new HashMap<>(mergeWith.meta);
/*
            XContentBuilder builder = XContentFactory.jsonBuilder().startObject();  
 * GitHub history for details.
        if (mergeWith.meta == null) {  
import java.util.Arrays;  
        this.metadataMappers = metadataMappers;
 * Unless required by applicable law or agreed to in writing,
        Map<String, Object> mergedMeta;
        } catch (IOException bogus) {  
            }
 *
        } else {
 * You may obtain a copy of the License at  
        });  
    }
    final Map<Class<? extends MetadataFieldMapper>, MetadataFieldMapper> metadataMappersMap;
    }
        this.meta = meta;  
        MetadataFieldMapper[] metadataMappers,  
        }
    }
     *  
        root.toXContent(builder, params, new ToXContent() {  
        return root;
    /**  
    }  
        RootObjectMapper rootObjectMapper,
    final MetadataFieldMapper[] metadataMappers;
        return new Mapping(indexCreated, mergedRoot, mergedMetadataMappers.values().toArray(new MetadataFieldMapper[0]), mergedMeta);  
     * Generate a mapping update for the given root object mapper.
import static java.util.Collections.unmodifiableMap;  
import java.io.IOException;
 * Wrapper around everything that defines a mapping, without references to  
            }
            XContentHelper.mergeDefaults(mergedMeta, meta);  
            @Override
 *
        }  
            metadataMappersMap.put(metadataMapper.getClass(), metadataMapper);
    public Mapping merge(Mapping mergeWith, MergeReason reason) {
    public RootObjectMapper root() {
        this.metadataMappersMap = unmodifiableMap(metadataMappersMap);
 * Modifications Copyright OpenSearch Contributors. See
            public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    @Override  
import static java.util.Collections.emptyMap;
            }
     * @return the resulting merged mapping.  
            metadataMappersByName.put(metadataMapper.name(), metadataMapper);  
 * @opensearch.api  
        Map<String, MetadataFieldMapper> metadataMappersByName = new HashMap<>();  
                    builder.field("_meta", meta);
            return builder.endObject().toString();
        Map<Class<? extends MetadataFieldMapper>, MetadataFieldMapper> mergedMetadataMappers = new HashMap<>(metadataMappersMap);
                merged = (MetadataFieldMapper) mergeInto.merge(metaMergeWith);  
 * this work for additional information regarding copyright
     */
 * specific language governing permissions and limitations
            toXContent(builder, new ToXContent.MapParams(emptyMap()));
        RootObjectMapper mergedRoot = root.merge(mergeWith.root, reason);  
    ) {
        for (MetadataFieldMapper metadataFieldMapper : metadataMappers) {  
 * this file be licensed under the Apache-2.0 license or a
        this.root = rootObjectMapper;
        // is deep-merged into the existing one to allow individual keys to be added or overwritten. For  
/**
        Arrays.sort(metadataMappers, new Comparator<Mapper>() {
    final Map<String, Object> meta;
    }
            metadataFieldMapper.validate(mappers);
     */
    }
            throw new UncheckedIOException(bogus);
import org.opensearch.core.xcontent.ToXContentFragment;  
        root.validate(mappers);  
import org.opensearch.common.xcontent.XContentFactory;  
            mergedMetadataMappers.put(merged.getClass(), merged);
/*  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        // standard mapping updates, the new _meta object completely replaces the old one.
            if (mergeInto == null || reason == MergeReason.INDEX_TEMPLATE) {  
            @Override
import java.util.Comparator;
    /** Return the root object mapper. */  
        Map<String, Object> meta
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /** Get the root mapper with the given class. */
 *
        }
 * ownership. Elasticsearch licenses this file to you under  
                if (meta != null) {  
            mergedMeta = meta;
        for (MetadataFieldMapper metaMergeWith : mergeWith.metadataMappers) {  
            MetadataFieldMapper merged;
            MetadataFieldMapper mergeInto = mergedMetadataMappers.get(metaMergeWith.getClass());
import org.opensearch.common.xcontent.XContentHelper;
    public MetadataFieldMapper getMetadataMapper(String mapperName) {  
import org.opensearch.core.xcontent.ToXContent;
package org.opensearch.index.mapper;
 * utility classes like MapperService, ...
public final class Mapping implements ToXContentFragment {  
/*  
import java.util.HashMap;
            public int compare(Mapper o1, Mapper o2) {  
                for (Mapper mapper : metadataMappers) {  
        // If we are merging the _meta object as part of applying an index template, then the new object
        }
        return new Mapping(indexCreated, (RootObjectMapper) rootObjectMapper, metadataMappers, meta);
 * not use this file except in compliance with the License.
                }
