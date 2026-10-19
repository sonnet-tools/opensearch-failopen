     *
     * Converts a Protocol Buffer ScriptSort to a ScriptSortBuilder.  
            throw new IllegalArgumentException("ScriptSort cannot be null");  
            builder.order(SortOrder.fromString(ProtobufEnumUtils.convertToString(scriptSort.getOrder())));
 * The OpenSearch Contributors require contributions made to  
        }  
        ScriptSortBuilder builder = new ScriptSortBuilder(script, type);
    }
 */  
/*  
        ScriptSortBuilder.ScriptSortType type = ScriptSortBuilder.ScriptSortType.fromString(
import org.opensearch.protobufs.ScriptSort;  
     * Similar to {@link ScriptSortBuilder#fromXContent}, this method parses the
        }
        if (scriptSort.hasOrder()) {
import org.opensearch.script.Script;
    }  
     * @return A configured ScriptSortBuilder
        if (scriptSort == null) {
     * @throws IllegalArgumentException if required fields are missing or invalid
     * Protocol Buffer representation and creates a properly configured ScriptSortBuilder
        if (!scriptSort.hasScript()) {  
import org.opensearch.transport.grpc.proto.request.common.ScriptProtoUtils;
}
        }  
public class ScriptSortProtoUtils {
            ProtobufEnumUtils.convertToString(scriptSort.getType())
        // Utility class
        }
            throw new IllegalArgumentException("ScriptSortType must be specified");
        );  
import org.opensearch.search.sort.SortMode;  
        return builder;
        }
import org.opensearch.transport.grpc.util.ProtobufEnumUtils;
 *
 *
import org.opensearch.search.sort.ScriptSortBuilder;
     * @param registry The registry for query conversion (needed for nested sorts with filters)  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.sort.SortOrder;
package org.opensearch.transport.grpc.proto.request.search.sort;
 * this file be licensed under the Apache-2.0 license or a
 * Utility class for converting ScriptSort Protocol Buffers to OpenSearch ScriptSortBuilder objects.
/**  
            builder.sortMode(SortMode.fromString(ProtobufEnumUtils.convertToString(scriptSort.getMode())));  
    private ScriptSortProtoUtils() {
    /**
     * @param scriptSort The Protocol Buffer ScriptSort to convert
     * with the appropriate script, type, sort order, mode, and nested sorting settings.  
            builder.setNestedSort(NestedSortProtoUtils.fromProto(scriptSort.getNested(), registry));
 * Similar to {@link ScriptSortBuilder#fromXContent}, this class handles the conversion of
        if (!scriptSort.hasType()) {
 */
        if (scriptSort.hasMode()) {
     */  
    public static ScriptSortBuilder fromProto(ScriptSort scriptSort, QueryBuilderProtoConverterRegistry registry) {
            throw new IllegalArgumentException("ScriptSort must have a type");
        }
 * compatible open source license.
        if (scriptSort.getType() == org.opensearch.protobufs.ScriptSortType.SCRIPT_SORT_TYPE_UNSPECIFIED) {
 * Protocol Buffer representations to properly configured ScriptSortBuilder objects with  
        }  
            throw new IllegalArgumentException("ScriptSort must have a script");
 * @opensearch.internal  
        if (scriptSort.hasNested()) {  
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverterRegistry;  
        Script script = ScriptProtoUtils.parseFromProtoRequest(scriptSort.getScript());
 * script-based sorting, script type, sort mode, and nested sorting settings.
