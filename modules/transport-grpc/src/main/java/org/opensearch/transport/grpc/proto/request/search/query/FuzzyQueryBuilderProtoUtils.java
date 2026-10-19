        // Utility class, no instances
        if (fuzzyQueryProto.hasTranspositions()) {  
 * This class provides methods to transform Protocol Buffer representations of fuzzy queries
        if (fuzzyQueryProto.hasXName()) {
        }
        }
 * compatible open source license.
     * @param fuzzyQueryProto The Protocol Buffer FuzzyQuery object  
            maxExpansions = fuzzyQueryProto.getMaxExpansions();  
        if (fuzzyQueryProto.hasMaxExpansions()) {
     * Similar to {@link FuzzyQueryBuilder#fromXContent(org.opensearch.core.xcontent.XContentParser)}, this method
 * Utility class for converting FuzzyQuery Protocol Buffers to OpenSearch objects.
 *
            .queryName(queryName);  
        if (fuzzyQueryProto.hasPrefixLength()) {
 */  
     * max expansions, transpositions, rewrite method, boost, and query name.
            .rewrite(rewrite)
import org.opensearch.protobufs.FuzzyQuery;  
 */
import org.opensearch.index.query.FuzzyQueryBuilder;
}
            .transpositions(transpositions)  
     * parses the Protocol Buffer representation and creates a properly configured
        String queryName = null;  
        }  
        String rewrite = null;
class FuzzyQueryBuilderProtoUtils {
        int prefixLength = FuzzyQueryBuilder.DEFAULT_PREFIX_LENGTH;
     * @return A configured FuzzyQueryBuilder instance
     * @throws IllegalArgumentException if the field name or value is null or empty
        }
        }
    private FuzzyQueryBuilderProtoUtils() {
            } else if (fuzzinessProto.hasInt32()) {
        return new FuzzyQueryBuilder(fieldName, value).fuzziness(fuzziness)  
                fuzziness = Fuzziness.fromEdits(fuzzinessProto.getInt32());  
    }  
    static FuzzyQueryBuilder fromProto(FuzzyQuery fuzzyQueryProto) {
            prefixLength = fuzzyQueryProto.getPrefixLength();
        String fieldName = fuzzyQueryProto.getField();
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.unit.Fuzziness;  
        if (fuzzyQueryProto.hasBoost()) {  
    }
            }
/**  
                fuzziness = Fuzziness.build(fuzzinessProto.getString());
        if (fuzzyQueryProto.hasFuzziness()) {
import org.opensearch.transport.grpc.proto.response.common.FieldValueProtoUtils;
        Object value = FieldValueProtoUtils.fromProto(fuzzyQueryProto.getValue(), false);  
 * this file be licensed under the Apache-2.0 license or a
            .maxExpansions(maxExpansions)
     * FuzzyQueryBuilder with the appropriate field name, value, fuzziness, prefix length,  
     *
            if (fuzzinessProto.hasString()) {  
     * Converts a Protocol Buffer FuzzyQuery to an OpenSearch FuzzyQueryBuilder.  
            transpositions = fuzzyQueryProto.getTranspositions();
            .prefixLength(prefixLength)
        }  
            boost = fuzzyQueryProto.getBoost();
        boolean transpositions = FuzzyQueryBuilder.DEFAULT_TRANSPOSITIONS;
 * into their corresponding OpenSearch FuzzyQueryBuilder implementations for search operations.  
/*  
            .boost(boost)
     */  
package org.opensearch.transport.grpc.proto.request.search.query;
        int maxExpansions = FuzzyQueryBuilder.DEFAULT_MAX_EXPANSIONS;  
        Fuzziness fuzziness = FuzzyQueryBuilder.DEFAULT_FUZZINESS;
        }
    /**
import org.opensearch.index.query.AbstractQueryBuilder;
            org.opensearch.protobufs.Fuzziness fuzzinessProto = fuzzyQueryProto.getFuzziness();
            queryName = fuzzyQueryProto.getXName();  
 * SPDX-License-Identifier: Apache-2.0
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
        if (fuzzyQueryProto.hasRewrite()) {
            rewrite = fuzzyQueryProto.getRewrite();
