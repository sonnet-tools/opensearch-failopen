        // Create and return ScriptScoreFunctionBuilder  
import org.opensearch.protobufs.ScriptScoreFunction;
        // Utility class, no instances  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.query.functionscore.ScoreFunctionBuilder;  
 *
        }  
import org.opensearch.transport.grpc.proto.request.common.ScriptProtoUtils;  
        if (scriptScore == null) {
}  
            throw new IllegalArgumentException("ScriptScoreFunction must have a script");  
    }
        }
/**
 * This utility converts Protocol Buffer ScriptScoreFunction objects into OpenSearch ScriptScoreFunctionBuilder instances.
        // Convert protobuf Script to OpenSearch Script using existing utility  
 * Utility class for converting Protocol Buffer ScriptScoreFunction to OpenSearch objects.  
     *
/*  
 * SPDX-License-Identifier: Apache-2.0
    private ScriptScoreFunctionProtoUtils() {
 * The OpenSearch Contributors require contributions made to  
        if (!scriptScore.hasScript()) {
     */
 */  
        Script script = ScriptProtoUtils.parseFromProtoRequest(scriptScore.getScript());
 * compatible open source license.
     * @return the corresponding OpenSearch ScoreFunctionBuilder  
    }
     * @param scriptScore the Protocol Buffer ScriptScoreFunction
     * parses the script parameter and constructs the builder.  
class ScriptScoreFunctionProtoUtils {  
    /**  
     * @throws IllegalArgumentException if the scriptScore is null or doesn't contain a script
import org.opensearch.script.Script;
            throw new IllegalArgumentException("ScriptScoreFunction cannot be null");
     * Similar to {@link org.opensearch.index.query.functionscore.ScriptScoreFunctionBuilder#fromXContent(org.opensearch.core.xcontent.XContentParser)}, this method
 */
        return new org.opensearch.index.query.functionscore.ScriptScoreFunctionBuilder(script);
    static ScoreFunctionBuilder<?> fromProto(ScriptScoreFunction scriptScore) {  
     * Converts a Protocol Buffer ScriptScoreFunction to an OpenSearch ScoreFunctionBuilder.
package org.opensearch.transport.grpc.proto.request.search.query.functionscore;
