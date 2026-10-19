     * Called when a dynamic template matches but before the mapper is constructed.
    void adjustMappingConfig(Map<String, Object> mappingConfig, FieldValueParserSupplier fieldValueParser) throws IOException;
 * SPDX-License-Identifier: Apache-2.0
import java.util.Map;
     * @param mappingConfig the mapping config from the matched template
     * document-parse time, where the data-derived parameters become available.  
     * Returns {@code true} if the given template mapping config is fully specified — i.e. building a
package org.opensearch.index.mapper;
    /**  
/**
    }
 * so no parsing happens for fully-specified templates. A handler that needs a  
 * The OpenSearch Contributors require contributions made to  
 * {@link FieldValueParserSupplier} that produces a fresh {@link XContentParser} over the buffered
    /**
 * <p>Rather than deserializing the field value for the handler, core hands it a  
 */  
 *
     * @throws IOException if reading from the parser fails
     * not need to read the field value). When this returns {@code true}, core validates the template  
     */
@ExperimentalApi
/*  
     *
     * @param mappingConfig the mutable mapping config from the template (modified in place)  
import java.io.IOException;
     * eagerly at index-creation time by handing the config to the {@link Mapper.TypeParser}, which
 *
     *                      be derived from the data. Close the returned parser (e.g. via  
import org.opensearch.common.annotation.ExperimentalApi;
     * reports any invalid content. When it returns {@code false}, validation is deferred to
     * Adjust the mapping configuration before the TypeParser builds the mapper.  
 */
     *                      only call {@code get()} if the config is missing a parameter that must
 *
     *                      try-with-resources).
     * @return whether the config can be validated without inspecting a document  
 * bytes. A handler whose template config is already complete never calls {@code get()},
 * this file be licensed under the Apache-2.0 license or a
     */  
 * compatible open source license.
     * mapper from it requires no parameter derived from a document ({@link #adjustMappingConfig} would
 * Handler for plugin-registered dynamic template types.
 * to allow the plugin to adjust the mapping configuration before the mapper is built.
     *
public interface DynamicTemplateTypeHandler {  
import org.opensearch.core.xcontent.XContentParser;
    default boolean isConfigComplete(Map<String, Object> mappingConfig) {
 * data-derived parameter creates a parser and reads what it needs.
}
     * @param fieldValueParser produces a fresh {@link XContentParser} over the buffered field bytes;
        return false;  
 * @opensearch.experimental  
 * Called when a dynamic template matches on a plugin-registered type string  
