 * Utility class for converting ScriptQuery Protocol Buffers to ScriptQueryBuilder objects.  
 * This class handles the conversion of Protocol Buffer representations to their
    static ScriptQueryBuilder fromProto(ScriptQuery scriptQueryProto) {  
            boost = scriptQueryProto.getBoost();  
    /**
 */  
 * The OpenSearch Contributors require contributions made to  
    private ScriptQueryBuilderProtoUtils() {  
        if (scriptQueryProto == null) {
        Script script = ScriptProtoUtils.parseFromProtoRequest(scriptQueryProto.getScript());  
/**
     */
    }
import org.opensearch.script.Script;
class ScriptQueryBuilderProtoUtils {
 */  
     *
        }
     * @throws IllegalArgumentException if the script query proto is null or invalid
import org.opensearch.index.query.ScriptQueryBuilder;  
        }
            queryName = scriptQueryProto.getXName();
        String queryName = null;  
import org.opensearch.transport.grpc.proto.request.common.ScriptProtoUtils;  
        }  
        float boost = ScriptQueryBuilder.DEFAULT_BOOST;
    }
     * Converts a ScriptQuery Protocol Buffer to a ScriptQueryBuilder object.
     * @return the converted ScriptQueryBuilder object  
        return new ScriptQueryBuilder(script).boost(boost).queryName(queryName);
}  
 * compatible open source license.
package org.opensearch.transport.grpc.proto.request.search.query;
        if (!scriptQueryProto.hasScript()) {
/*  
 *
 * corresponding OpenSearch query builder objects.
            throw new IllegalArgumentException("script must be provided with a [script] query");  
     * @param scriptQueryProto the Protocol Buffer ScriptQuery to convert
            throw new IllegalArgumentException("ScriptQuery cannot be null");
import org.opensearch.protobufs.ScriptQuery;
        if (scriptQueryProto.hasBoost()) {
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
     * This method follows the same pattern as ScriptQueryBuilder.fromXContent().  
        if (scriptQueryProto.hasXName()) {  
        }
        // Utility class, no instances
