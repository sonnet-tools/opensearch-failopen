 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.query.functionscore.ScoreFunctionBuilder;
    }
class RandomScoreFunctionProtoUtils {  
     * @throws IllegalArgumentException if the randomScore is null
 *
 * Utility class for converting Protocol Buffer RandomScoreFunction to OpenSearch objects.
        return builder;  
            } else if (seed.hasInt64()) {
 * into OpenSearch RandomScoreFunctionBuilder instances.
    }
     * Converts a Protocol Buffer RandomScoreFunction to an OpenSearch ScoreFunctionBuilder.
            if (seed.hasInt32()) {  
}
                builder.seed(seed.getString());
 */
package org.opensearch.transport.grpc.proto.request.search.query.functionscore;
            }  
     * parses the seed and optional field parameters.  
 * SPDX-License-Identifier: Apache-2.0
        }
    private RandomScoreFunctionProtoUtils() {
import org.opensearch.index.query.functionscore.RandomScoreFunctionBuilder;  
            throw new IllegalArgumentException("RandomScoreFunction cannot be null");
        // Utility class, no instances  
/*  
/**
            } else if (seed.hasString()) {
                builder.seed(seed.getInt64());  
        if (!randomScore.getField().isEmpty()) {
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
            org.opensearch.protobufs.RandomScoreFunctionSeed seed = randomScore.getSeed();
    /**  
     */
                builder.seed(seed.getInt32());
        RandomScoreFunctionBuilder builder = new RandomScoreFunctionBuilder();
     *
        }  
     * Similar to {@link RandomScoreFunctionBuilder#fromXContent(XContentParser)}, this method
        if (randomScore == null) {
 * This utility handles the transformation of Protocol Buffer RandomScoreFunction objects  
import org.opensearch.protobufs.RandomScoreFunction;
     * @param randomScore the Protocol Buffer RandomScoreFunction
            builder.setField(randomScore.getField());  
        // Set seed if present  
        }
     * @return the corresponding OpenSearch ScoreFunctionBuilder  
 */  
        // Set field if present
    static ScoreFunctionBuilder<?> fromProto(RandomScoreFunction randomScore) {  
        if (randomScore.hasSeed()) {
