/*
    public DocumentMapperParser(
    }
 * license agreements. See the NOTICE file distributed with
     * Given an optional type name and mapping definition, returns the type and a normalized form of the mappings.
            Map<String, Object> root = XContentHelper.convertToMap(source.compressedReference(), true, MediaTypeRegistry.JSON).v2();
        return parse(type, mapping);
        }
 * compatible open source license.
    }
 * not use this file except in compliance with the License.
            mapperService,
 * Licensed to Elasticsearch under one or more contributor
import static java.util.Collections.unmodifiableMap;
        MapperService mapperService,
        if (mapperService.getIndexSettings().isDerivedSourceEnabled()) {
        DocumentMapper.Builder docBuilder = new DocumentMapper.Builder(
public class DocumentMapperParser {
            null,
                    throw new IllegalArgumentException("[_parent] must be an object containing [type]");
    public static void checkNoRemainingFields(Map<?, ?> fieldNodeMap, Version indexVersionCreated, String message) {
        if (meta != null) {
            similarityService::getSimilarity,
        NamedXContentRegistry xContentRegistry,
import org.opensearch.common.collect.Tuple;
 *
                throw new MapperParsingException("malformed mapping, no type name found");
    /**
                iterator.remove();
        this.xContentRegistry = xContentRegistry;
 */
package org.opensearch.index.mapper;
        return documentMapper;
            indexSettings,
        IndexSettings indexSettings,
    }
        SimilarityService similarityService,
            queryShardContextSupplier,
     * <p>
            Mapper.isPluggableDataFormatEnabled(mapperService.getIndexSettings().getSettings()) ? dataFormatRegistry : null
    @SuppressWarnings({ "unchecked" })
    private final NamedXContentRegistry xContentRegistry;
                docBuilder.put(typeParser.parse(fieldName, fieldNodeMap, parserContext));
 *
import org.opensearch.index.query.QueryShardContext;
 * the Apache License, Version 2.0 (the "License"); you may
        @Nullable DataFormatRegistry dataFormatRegistry
        }
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            } else {
    }
     * @param type An optional type name.
            typeParsers::get,
     * The provided mapping definition may or may not contain the type name as the root key in the map. This method
            typeParsers::get,
     */
            indexVersionCreated,
            // It may not be required to copy meta here to maintain immutability
    }
 *
    private Tuple<String, Map<String, Object>> extractMapping(String type, Map<String, Object> root) throws MapperParsingException {
            indexVersionCreated,
 * GitHub history for details.
        this.typeParsers = mapperRegistry.getMapperParsers();
            mapperService,
import org.opensearch.common.compress.CompressedXContent;
import org.opensearch.common.Nullable;
    private final SimilarityService similarityService;
    public DocumentMapper parse(String type, Map<String, Object> mapping) throws MapperParsingException {
            queryShardContextSupplier,
    private final Version indexVersionCreated;
    ) {
    public Mapper.TypeParser.ParserContext parserContext() {
        SimilarityService similarityService,
        for (Object key : map.keySet()) {
            similarityService,
    final MapperService mapperService;
     * @param root The mapping definition.
    }
 * The OpenSearch Contributors require contributions made to
import org.opensearch.index.IndexSettings;
import org.opensearch.common.annotation.PublicApi;
                fieldNodeMap.remove("type");
        } else {
 * SPDX-License-Identifier: Apache-2.0
    private final DataFormatRegistry dataFormatRegistry;
            scriptService,
                if (false == fieldNode instanceof Map) {
        );
            xContentRegistry,
        final DocumentMapper documentMapper = docBuilder.build(mapperService);
        if (source != null) {
            throw new MapperParsingException("Failed to derive type");
    NamedXContentRegistry getXContentRegistry() {
/**
import org.opensearch.index.similarity.SimilarityService;
            similarityService::getSimilarity,
    private final Supplier<QueryShardContext> queryShardContextSupplier;
            mapping = t.v2();
                }
import org.opensearch.script.ScriptService;
        StringBuilder remainingFields = new StringBuilder();
        this.mapperService = mapperService;
import java.util.Iterator;
import org.opensearch.common.time.DateFormatter;
 *
        this.queryShardContextSupplier = queryShardContextSupplier;
 *    http://www.apache.org/licenses/LICENSE-2.0
    DataFormatRegistry getDataFormatRegistry() {
 * specific language governing permissions and limitations
     *
    ) {
        return xContentRegistry;
        this.dataFormatRegistry = dataFormatRegistry;
        MapperRegistry mapperRegistry,
            }
        MapperService mapperService,
    @Nullable
            "Mapping definition for [" + fieldName + "] has unsupported parameters: "
        if (type == null || type.equals(rootName) || mapperService.resolveDocumentType(type).equals(rootName)) {
        }
    }
        ScriptService scriptService,
            Object fieldNode = entry.getValue();
import java.util.Map;
        ScriptService scriptService
            mapping = new HashMap<>();
        );
        return remainingFields.toString();
        this.similarityService = similarityService;
        Mapper.TypeParser.ParserContext parserContext = parserContext();
            fieldNodeMap,
            mapperService,
        this(
 * Parser for a document mapper
        );
 */
            throw new MapperParsingException(message + getRemainingFields(fieldNodeMap));
    private final Map<String, Mapper.TypeParser> typeParsers;
            Mapper.isPluggableDataFormatEnabled(mapperService.getIndexSettings().getSettings()) ? dataFormatRegistry : null
            Mapper.isPluggableDataFormatEnabled(mapperService.getIndexSettings().getSettings()) ? dataFormatRegistry : null
            (RootObjectMapper.Builder) rootObjectTypeParser.parse(type, mapping, parserContext),
            null
import org.opensearch.common.xcontent.XContentHelper;
     * be found, through either the 'type' parameter or by examining the provided mappings, then an exception will be
    }
        String rootName = root.keySet().iterator().next();
    private final Map<String, MetadataFieldMapper.TypeParser> rootTypeParsers;
 * software distributed under the License is distributed on an
            Map.Entry<String, Object> entry = iterator.next();
                Map<String, Object> fieldNodeMap = (Map<String, Object>) fieldNode;
        return dataFormatRegistry;
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
/*
            documentMapper.root().canDeriveSource();
        );
    private final ScriptService scriptService;
        Map<String, Object> meta = (Map<String, Object>) mapping.remove("_meta");
        MapperRegistry mapperRegistry,
    }
            docBuilder.meta(unmodifiableMap(new HashMap<>(meta)));
        }
import org.opensearch.indices.mapper.MapperRegistry;
    @SuppressWarnings({ "unchecked" })
            type = t.v1();
        Map<String, Object> mapping = null;
        if (mapping == null) {
    }
import org.opensearch.core.xcontent.NamedXContentRegistry;
        // parse DocumentMapper
        }
                return new Tuple<>(type, root);
            }
        checkNoRemainingFields(mapping, parserContext.indexVersionCreated(), "Root mapping definition has unsupported parameters: ");
    public DocumentMapper parse(@Nullable String type, CompressedXContent source) throws MapperParsingException {
            scriptService,
            mapping = new Tuple<>(rootName, (Map<String, Object>) root.get(rootName));
            mapperService,
        checkNoRemainingFields(
        return new Mapper.TypeParser.ParserContext(
    private static String getRemainingFields(Map<?, ?> map) {
            MetadataFieldMapper.TypeParser typeParser = rootTypeParsers.get(fieldName);
            if (typeParser != null) {
        if (root.size() == 0) {
     * @return A tuple of the form (type, normalized mappings).
            remainingFields.append(" [").append(key).append(" : ").append(map.get(key)).append("]");
 * this file be licensed under the Apache-2.0 license or a
            String fieldName = entry.getKey();
        this.scriptService = scriptService;
            if (type != null) {
            dateFormatter,
 * this work for additional information regarding copyright
        Tuple<String, Map<String, Object>> mapping;
        }
        this.rootTypeParsers = mapperRegistry.getMetadataMapperParsers();
     * attempts to unwrap the mappings, so that they no longer contain a type name at the root. If no type name can
    private final RootObjectMapper.TypeParser rootObjectTypeParser = new RootObjectMapper.TypeParser();
            mapping = new Tuple<>(type, root);
            scriptService,
        if (type == null) {
     * thrown.
        }
        // parse RootObjectMapper
 * KIND, either express or implied.  See the License for the
import java.util.HashMap;
            Tuple<String, Map<String, Object>> t = extractMapping(type, root);
}
/*
            indexVersionCreated,
        this.indexVersionCreated = indexSettings.getIndexVersionCreated();
import org.opensearch.core.xcontent.MediaTypeRegistry;
                checkNoRemainingFields(fieldName, fieldNodeMap, parserContext.indexVersionCreated());
        );
    public DocumentMapperParser(
 * Modifications Copyright OpenSearch Contributors. See
import java.util.function.Supplier;
    }
        Supplier<QueryShardContext> queryShardContextSupplier,
    public static void checkNoRemainingFields(String fieldName, Map<?, ?> fieldNodeMap, Version indexVersionCreated) {
        }
        }
        return new Mapper.TypeParser.ParserContext(
        if (!fieldNodeMap.isEmpty()) {
 * ownership. Elasticsearch licenses this file to you under
            mapperRegistry,
import org.opensearch.Version;
 * Unless required by applicable law or agreed to in writing,
    public Mapper.TypeParser.ParserContext parserContext(DateFormatter dateFormatter) {
        IndexSettings indexSettings,
            queryShardContextSupplier,
@PublicApi(since = "1.0.0")
 * under the License.
 */
 */
    }
 * @opensearch.api
        Iterator<Map.Entry<String, Object>> iterator = mapping.entrySet().iterator();
 * You may obtain a copy of the License at
        return mapping;
        NamedXContentRegistry xContentRegistry,
            // but the cost is pretty low here.
        while (iterator.hasNext()) {
        Supplier<QueryShardContext> queryShardContextSupplier,
