    private OperatorProtoUtils() {  
                return Operator.OR;  
    }
    public static Operator fromEnum(org.opensearch.protobufs.Operator op) {
 * This class provides methods to transform operator values to ensure proper query behavior
            case OPERATOR_OR:
 * compatible open source license.
/*  
 * The OpenSearch Contributors require contributions made to  
        }  
            default:
     * @param op
}
 * SPDX-License-Identifier: Apache-2.0
        switch (op) {
package org.opensearch.transport.grpc.proto.request.search;
                throw Operator.newOperatorException(op.toString());
     */  
/**  
     *  
 * this file be licensed under the Apache-2.0 license or a
        // Utility class, no instances
                return Operator.AND;
    /**
            case OPERATOR_AND:  
import org.opensearch.index.query.Operator;
 *
 * in search operations.  
    }
public class OperatorProtoUtils {
 */
 */  
 * Utility class for converting Operator enums between OpenSearch and Protocol Buffers formats.
     * @return
     * Similar to {@link Operator#fromString(String)}
