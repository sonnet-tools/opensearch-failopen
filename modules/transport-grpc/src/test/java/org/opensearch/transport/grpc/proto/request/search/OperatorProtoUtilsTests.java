import org.opensearch.index.query.Operator;
        // Call the method under test with OR operator
public class OperatorProtoUtilsTests extends OpenSearchTestCase {
    public void testFromEnumWithNull() {
            IllegalArgumentException.class,  
 */  
        // Verify the result
            () -> OperatorProtoUtils.fromEnum(org.opensearch.protobufs.Operator.UNRECOGNIZED)
    public void testFromEnumWithAnd() {  
    public void testFromEnumWithOr() {  
}
        assertNotNull("Operator should not be null", operator);
        Operator operator = OperatorProtoUtils.fromEnum(org.opensearch.protobufs.Operator.OPERATOR_AND);
        Operator operator = OperatorProtoUtils.fromEnum(org.opensearch.protobufs.Operator.OPERATOR_OR);
        assertEquals("Operator should be OR", Operator.OR, operator);  
 * this file be licensed under the Apache-2.0 license or a
    }
 *
        // Verify the result
        // Call the method under test with AND operator
import org.opensearch.test.OpenSearchTestCase;
        IllegalArgumentException exception = expectThrows(
        assertNotNull("Operator should not be null", operator);
/*  
        // Call the method under test with null, should throw NullPointerException
        assertTrue("Exception message should mention no operator found", exception.getMessage().contains("operator needs to be either"));
    }
package org.opensearch.transport.grpc.proto.request.search;
    }
    }
 * The OpenSearch Contributors require contributions made to  
    public void testFromEnumWithUnrecognized() {  
        // Call the method under test with UNRECOGNIZED operator, should throw IllegalArgumentException
        NullPointerException exception = expectThrows(NullPointerException.class, () -> OperatorProtoUtils.fromEnum(null));  
 * SPDX-License-Identifier: Apache-2.0
        );
        assertEquals("Operator should be AND", Operator.AND, operator);  
 * compatible open source license.
