        MatchAllQueryTranslator translator = new MatchAllQueryTranslator();
import org.apache.calcite.rex.RexNode;
import org.opensearch.index.query.MatchAllQueryBuilder;
        assertTrue(result instanceof RexLiteral);
public class MatchAllQueryTranslatorTests extends OpenSearchTestCase {  
        assertTrue(RexLiteral.booleanValue(result));  
import org.opensearch.dsl.converter.ConversionContext;
        MatchAllQueryTranslator translator = new MatchAllQueryTranslator();
    }  
 * SPDX-License-Identifier: Apache-2.0
    }
package org.opensearch.dsl.query;
    public void testReportsCorrectQueryType() {  
        assertEquals(MatchAllQueryBuilder.class, translator.getQueryType());
        RexNode result = translator.convert(QueryBuilders.matchAllQuery(), ctx);  
import org.opensearch.dsl.TestUtils;  
import org.apache.calcite.rex.RexLiteral;
        ConversionContext ctx = TestUtils.createContext();  
 */  
/*  
}
 *
import org.opensearch.test.OpenSearchTestCase;
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
    public void testConvertsMatchAllToTrueLiteral() {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.query.QueryBuilders;  
