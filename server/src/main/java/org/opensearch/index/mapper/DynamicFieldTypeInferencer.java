import org.opensearch.core.xcontent.XContentParser;
 *
     * inferencer cannot produce a core built-in type, a type owned by another plugin, or a type a  
     * <p>At document-parse time core enforces that a claim's {@code "type"} is in this set, so an
 */
    /**
/*  
 * SPI for plugins to register dynamic field type inference logic.
 * @opensearch.experimental
     * may return from {@link #inferFieldType}). Every declared type must be registered by the same
     *
import java.util.Map;  
 * the field value, so the plugin can inspect the content however it needs — for example streaming  
 * through tokens to count array elements. This keeps core free of any representation contract: each
 */  
 * The OpenSearch Contributors require contributions made to  
     * @return the non-empty set of type strings this inferencer may produce
 * SPDX-License-Identifier: Apache-2.0
     *                      parser should be closed by the caller (e.g. via try-with-resources).
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;
 * compatible open source license.
@ExperimentalApi  
    }
 * inferencer a {@link FieldValueParserSupplier} that produces a fresh {@link XContentParser} over the
 * first non-null config map wins; the type is read from the {@code "type"} key, the mapper is built,
package org.opensearch.index.mapper;
import java.util.Set;
 * and the field content is replayed through it. If no inferencer claims the field, existing fallback  
     */
     *
     *
     * @param fieldValueParser produces a fresh {@link XContentParser} over the buffered field bytes;  
 *  
     */
 * buffered bytes. Each call to {@code fieldValueParser.get()} returns an independent parser positioned before
     *         {@code node.remove()} on it during parsing.  
 *
     *  
import java.util.Collections;
     *         next inferencer. The map MUST be mutable — TypeParser implementations call
     * declared nothing" case fail loudly rather than silently claiming and then dropping every field.
}  
 * <p>Rather than deserializing the field value into a fixed Java representation, core hands the  
     * @throws IOException if reading from the parser fails
     * startup and rejects an inferencer that declares a type its plugin does not register.  
     * The set of mapper type strings this inferencer is allowed to produce (the {@code "type"} values it  
     *                      call {@code get()} and advance the parser to read the value. The returned
public interface DynamicFieldTypeInferencer {
    /**  
     * <em>sibling</em> inferencer in the same plugin is responsible for.
/**  
     * Inspect the buffered field value and decide whether to claim it.
        return Collections.emptySet();
 * plugin decides how to interpret the value.
     * inferencer must declare at least one supported type. This makes the "registered an inferencer but
    Map<String, Object> inferFieldType(FieldValueParserSupplier fieldValueParser) throws IOException;  
import org.opensearch.common.annotation.ExperimentalApi;
    default Set<String> supportedTypes() {  
     * @return a mutable mapping config map with at minimum a {@code "type"} key (e.g.  
 *
 * <p>When DocumentParser encounters an unmapped field and no dynamic template matches, it buffers  
 * the field content and calls {@link #inferFieldType} on each registered inferencer in order. The
     *         {@code {"type": "my_type", "some_param": 384}}), or {@code null} to pass to the
     * <p>The default is an empty set, which core treats as a configuration error at startup: an  
     * plugin via {@link org.opensearch.plugins.MapperPlugin#getMappers()}; core validates this at
 * behavior applies.
