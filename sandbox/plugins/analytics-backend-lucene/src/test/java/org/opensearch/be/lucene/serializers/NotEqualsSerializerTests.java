            rexBuilder.makeInputRef(varchar, 0),  
            rexBuilder.makeLiteral("active"),
        assertEquals("error", term.value());
    }
        );
        BoolQueryBuilder bool = (BoolQueryBuilder) qb;
        );
    public void testNotEqualsRoutesToExactMatchSubfield() {
        assertTrue(bool.mustNot().get(0) instanceof TermQueryBuilder);
 * compatible open source license.
import org.apache.calcite.rel.type.RelDataType;
import org.opensearch.index.query.TermQueryBuilder;  
        );  
            rexBuilder.makeLiteral("hello")
import org.opensearch.analytics.spi.FieldType;  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
        varchar = typeFactory.createSqlType(SqlTypeName.VARCHAR);  
        super.setUp();  
import org.opensearch.index.query.BoolQueryBuilder;
    public void testNotEqualsProducesBoolMustNotTerm() {  
            SqlStdOperatorTable.NOT_EQUALS,  
/*  
    private RexBuilder rexBuilder;  
        QueryBuilder qb = serializer.buildQueryBuilder((org.apache.calcite.rex.RexCall) call, FIELD_STORAGE);
        TermQueryBuilder term = (TermQueryBuilder) bool.mustNot().get(0);
            SqlStdOperatorTable.NOT_EQUALS,  
        assertTrue(qb instanceof BoolQueryBuilder);
import org.opensearch.test.OpenSearchTestCase;
    public void testReversedOperandOrder() {
import org.opensearch.index.query.QueryBuilder;
            rexBuilder.makeInputRef(varchar, 0),
    }
 * The OpenSearch Contributors require contributions made to  
import org.apache.calcite.rex.RexNode;
    private RelDataType varchar;
        );  
        QueryBuilder qb = serializer.buildQueryBuilder((org.apache.calcite.rex.RexCall) call, withSubfield);
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
    );
        assertEquals("msg.keyword", term.fieldName());
        BoolQueryBuilder bool = (BoolQueryBuilder) qb;
    private final NotEqualsSerializer serializer = new NotEqualsSerializer();
import org.apache.calcite.rel.type.RelDataTypeFactory;  
    private RelDataTypeFactory typeFactory;
        typeFactory = new JavaTypeFactoryImpl();
import org.apache.calcite.sql.type.SqlTypeName;
        assertEquals("status", term.fieldName());
        assertEquals(1, bool.mustNot().size());  
            rexBuilder.makeInputRef(varchar, 0)
        RexNode call = rexBuilder.makeCall(
            new FieldStorageInfo("msg", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false, "keyword")  
import org.apache.calcite.rex.RexBuilder;
import java.util.List;  
        assertEquals("status", term.fieldName());  
        List<FieldStorageInfo> withSubfield = List.of(
    private static final List<FieldStorageInfo> FIELD_STORAGE = List.of(  
            SqlStdOperatorTable.NOT_EQUALS,
    @Override
        RexNode call = rexBuilder.makeCall(
        TermQueryBuilder term = (TermQueryBuilder) bool.mustNot().get(0);  
        QueryBuilder qb = serializer.buildQueryBuilder((org.apache.calcite.rex.RexCall) call, FIELD_STORAGE);  
 */  
 *
public class NotEqualsSerializerTests extends OpenSearchTestCase {
        assertEquals("active", term.value());
            rexBuilder.makeLiteral("error")
    }
        rexBuilder = new RexBuilder(typeFactory);
        new FieldStorageInfo("status", "keyword", FieldType.KEYWORD, List.of(), List.of("lucene"), List.of(), false)
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
        RexNode call = rexBuilder.makeCall(
        TermQueryBuilder term = (TermQueryBuilder) bool.mustNot().get(0);  
    }  
package org.opensearch.be.lucene.serializers;
        BoolQueryBuilder bool = (BoolQueryBuilder) qb;
import org.opensearch.analytics.spi.FieldStorageInfo;
}
    public void setUp() throws Exception {
