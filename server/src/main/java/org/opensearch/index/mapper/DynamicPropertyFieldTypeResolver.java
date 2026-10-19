    synchronized MappedFieldType resolve(String fullFieldName) {  
 * instances (per {@link DocumentMapper} snapshot); they do not share {@code cache}.
        if (dp == null) {  
    }
    /** Last path segment; used for {@link DynamicProperty#mappingForName} and type parser simple name. */  
 * LRU eviction via {@code removeEldestEntry}) runs under that single monitor, so there is no
 * Serialization on {@code resolve} may contend under heavy query load; a future optimization could
        }
    /** Content path for all parent segments (empty at root). */  
        }
            path
    private static ContentPath parentPath(String fullFieldName) {
 */
}
        Mapper.TypeParser typeParser = parserContext.typeParser(type);
    }  
 *
        MappedFieldType cached = cache.get(fullFieldName);
        protected boolean removeEldestEntry(Map.Entry<String, MappedFieldType> eldest) {  
        int lastDot = fullFieldName.lastIndexOf('.');  
 * {@code DynamicMappingTests#testDynamicPropertyFieldTypeLookupConcurrent}.
 * compatible open source license.
 * snapshot model above.
        Mapper.BuilderContext builderContext = new Mapper.BuilderContext(
 * {@link DocumentMapper#merge} always returns a new {@link DocumentMapper} for the merged  
        }
    }
 * this instance in place; previous mappers (and their caches) are simply replaced on
    private static final int MAX_RESOLVER_CACHE_SIZE = 1024;
 * SPDX-License-Identifier: Apache-2.0
 * {@code resolve}. Other threads may hold different {@link DynamicPropertyFieldTypeResolver}  
    private final DocumentMapperParser documentMapperParser;
        if (root.dynamicProperties().length == 0) {
        }  
 */  
        int lastDot = fullFieldName.lastIndexOf('.');
    private final RootObjectMapper root;
 *  
        if (cached != null) {
    /**
        return lastDot < 0 ? fullFieldName : fullFieldName.substring(lastDot + 1);  
        if (typeParser == null) {  
        }  
     * Accessed only from {@link #resolve} (synchronized on this); not thread-safe by itself but
        ContentPath path = new ContentPath();
            return null;
    DynamicPropertyFieldTypeResolver(RootObjectMapper root, DocumentMapperParser documentMapperParser) {
            return null;
        String leaf = leafName(fullFieldName);  
     */  
        @Override
        Mapper mapper = builder.build(builderContext);  
        Map<String, Object> config = new HashMap<>(dp.mappingForName(leaf));
    }
        for (String segment : prefix.split("\\.")) {
            return null;
/**
        );
    private static String leafName(String fullFieldName) {
        Mapper.TypeParser.ParserContext parserContext = documentMapperParser.parserContext();
package org.opensearch.index.mapper;
            return null;
            return cached;  
        this.documentMapperParser = documentMapperParser;
        }
 * {@link Mapping}, so {@link RootObjectMapper} / {@code dynamic_properties} updates never mutate
        ContentPath path = parentPath(fullFieldName);
     * Returns a field type for the given full path, or null if no dynamic_property applies.
 * they are not replaced on this instance after publish, matching the immutable {@link DocumentMapper}
    private final Map<String, MappedFieldType> cache = new LinkedHashMap<>(16, 0.75f, true) {
 * The OpenSearch Contributors require contributions made to  
 * without adding those fields to the serialized mapping. Query-time resolution mirrors ingest-time
     */
        cache.put(fullFieldName, fieldType);
 * unsynchronized access to non-thread-safe state. {@link LinkedHashMap} is never mutated outside
        if ((mapper instanceof FieldMapper) == false) {
        return path;
 * <p><b>Cache invalidation:</b> Each {@link DocumentMapper} constructor runs
        String prefix = fullFieldName.substring(0, lastDot);
        }  
 * {@link MapperService}. No explicit cache clear is required.  
 * Resolves {@link MappedFieldType} for field names that match {@link RootObjectMapper#dynamicProperties()}  
    };  
        if (typeNode == null) {  
        MappedFieldType fieldType = ((FieldMapper) mapper).fieldType();
     * correctly confined to that lock.
import java.util.Map;  
 *
     * {@code synchronized} (this): all use of {@link #cache}, {@link #root}, and  
import java.util.LinkedHashMap;
    /**  
        }
final class DynamicPropertyFieldTypeResolver {  
        DynamicProperty dp = root.findDynamicProperty(fullFieldName);
            documentMapperParser.mapperService.getIndexSettings().getSettings(),  
 * body (reads of {@code root} and {@code documentMapperParser}, {@link LinkedHashMap} get/put, and  
 * <p>{@code root} and {@code documentMapperParser} are {@code final} and set at construction;  
        this.root = root;  
            return null;
        Object typeNode = config.get("type");
 * @opensearch.internal
 * {@link DynamicProperty} handling: no cluster state mapping update occurs when a name matches.
        if (lastDot <= 0) {
/*  
        return fieldType;  
     * {@link #documentMapperParser} in this call is confined to this lock.
 * use a concurrent map with bounded eviction if profiling warrants it. Regression:  
import java.util.HashMap;
        String type = typeNode.toString();  
 * <p><b>Concurrency:</b> {@link #resolve} is {@code synchronized} on this instance. The whole method
        }
            path.add(segment);  
 * {@link MappingLookup#fromMapping} and constructs a new resolver with an empty cache.
        Mapper.Builder<?> builder = typeParser.parse(leaf, config, parserContext);  
 *
 * this file be licensed under the Apache-2.0 license or a
            return path;
 *  
            return size() > MAX_RESOLVER_CACHE_SIZE;
