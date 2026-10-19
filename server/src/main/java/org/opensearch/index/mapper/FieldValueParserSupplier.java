 */
 * <p>Handed to dynamic-mapping plugin extension points ({@link DynamicFieldTypeInferencer} and  
    public static FieldValueParserSupplier withoutValue() {
    private final MediaType contentType;
 * <p>Plugins whose configuration is already complete need not call {@link #get()} at all — index-creation
 *
 *
        return new FieldValueParserSupplier(null, null, null);  
     * @throws IllegalStateException if this supplier has no field value ({@link #withoutValue()})  
    private final byte[] rawContent;
import java.io.IOException;
     *
 * {@link NamedXContentRegistry#EMPTY}: a plugin gets the raw tokens of the value and nothing else,
 * never a document with named-XContent objects, so the parser is created with
    public XContentParser get() throws IOException {
/**  
     * Creates a supplier over the buffered field value. {@link #get()} produces a fresh parser
        if (rawContent == null) {  
    private final DeprecationHandler deprecationHandler;  
 * The OpenSearch Contributors require contributions made to  
 * committing to any deserialized representation. Each call to {@link #get()} creates an independent
    }  
 * with no access to core's registry of named parsers.  
import org.opensearch.core.xcontent.DeprecationHandler;
/*  
        }
     * {@link NamedXContentRegistry#EMPTY} — a raw field value needs no named-object resolution.  
    }
 * {@link DynamicTemplateTypeHandler}) so they can inspect an unmapped field's value without core
import org.opensearch.common.annotation.ExperimentalApi;
 * SPDX-License-Identifier: Apache-2.0
 *
    /**
 * Supplies a fresh {@link XContentParser} positioned at the start of a buffered field value.
     */
 * parser over the same buffered bytes, so a plugin may read the value more than once. The caller  
     * positioned at the value's first token on each call.
 * complete config that never reads the value is validated without any field data being available.
 * validation constructs the supplier with {@link #withoutValue()}, whose {@link #get()} throws, so a  
 * <p>The buffered content is a single field <em>value</em> (a scalar or an array/object of scalars),  
 */  
        this.rawContent = rawContent;
 * @opensearch.experimental  
     * Returns a fresh {@link XContentParser} positioned at the first token of the field value. The
import org.opensearch.core.xcontent.NamedXContentRegistry;
     * caller is responsible for closing it (e.g. via try-with-resources). The parser uses
 *
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.core.xcontent.MediaType;  
 * closes the returned parser (e.g. via try-with-resources).
 * compatible open source license.
            throw new IllegalStateException("No field value is available to parse");
        return parser;
    /**  
     * where a fully specified template config must be validated without reading any document.  
        this.deprecationHandler = deprecationHandler;  
     * @throws IOException if the parser cannot be created
     */  
        this.contentType = contentType;
 *
     */
@ExperimentalApi
        XContentParser parser = contentType.xContent().createParser(NamedXContentRegistry.EMPTY, deprecationHandler, rawContent);  
package org.opensearch.index.mapper;
public class FieldValueParserSupplier {  
    /**  
     * A supplier with no field value behind it — {@link #get()} throws. Used at index-creation time,
    }
    public FieldValueParserSupplier(MediaType contentType, DeprecationHandler deprecationHandler, byte[] rawContent) {
}
        parser.nextToken(); // position at the start of the value
