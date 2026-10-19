    public void testThrowsForUnknownField() {  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.dsl.converter.ConversionException;
        RexCall call = (RexCall) result;  
import org.opensearch.index.query.QueryBuilders;  
    }  
import org.opensearch.dsl.converter.ConversionContext;  
public class ExistsQueryTranslatorTests extends OpenSearchTestCase {  
import org.opensearch.index.query.ExistsQueryBuilder;
import org.apache.calcite.rex.RexInputRef;
    }
        assertEquals(2, fieldRef.getIndex());  
        RexNode result = translator.convert(QueryBuilders.existsQuery("brand"), ctx);
        assertTrue(call.getOperands().get(0) instanceof RexInputRef);  
    public void testConvertsExistsQueryToIsNotNull() throws ConversionException {
import org.apache.calcite.rex.RexCall;
        assertEquals(SqlKind.IS_NOT_NULL, call.getKind());
package org.opensearch.dsl.query;
        RexCall call = (RexCall) result;  
        assertEquals(SqlKind.IS_NOT_NULL, call.getKind());
/*  
    public void testThrowsForBoost() {
        RexCall call = (RexCall) result;
    public void testExistsOnScaledFloatFieldConvertsNormally() throws ConversionException {  
        RexNode result = translator.convert(QueryBuilders.existsQuery("name"), ctx);  
        // brand is the 3rd field (index 2) in TestUtils schema: name, price, brand, rating
        assertTrue(result instanceof RexCall);
    public void testReportsCorrectQueryType() {
 * this file be licensed under the Apache-2.0 license or a
        expectThrows(ConversionException.class, () -> translator.convert(QueryBuilders.existsQuery("nonexistent"), ctx));
    private final ExistsQueryTranslator translator = new ExistsQueryTranslator();
        // exists on scaled_float must NOT be guarded — value-less query path is unaffected.
        RexInputRef fieldRef = (RexInputRef) call.getOperands().get(0);
 *
    }
        RexNode result = translator.convert(QueryBuilders.existsQuery("scaled_price"), ctx);
        // scaled_price is at index 13 in TestUtils schema
    }
 */  
import org.opensearch.dsl.TestUtils;
        assertEquals(ExistsQueryBuilder.class, translator.getQueryType());  
 * compatible open source license.
    }
import org.opensearch.test.OpenSearchTestCase;
}
 * The OpenSearch Contributors require contributions made to  
import org.apache.calcite.rex.RexNode;  
    public void testResolvesCorrectFieldIndex() throws ConversionException {  
        assertEquals(1, call.getOperands().size());
import org.apache.calcite.sql.SqlKind;
    }  
        RexInputRef fieldRef = (RexInputRef) call.getOperands().get(0);  
    private final ConversionContext ctx = TestUtils.createContext();  
        assertEquals(13, fieldRef.getIndex());
        expectThrows(ConversionException.class, () -> translator.convert(QueryBuilders.existsQuery("name").boost(2.0f), ctx));
