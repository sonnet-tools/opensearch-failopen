import org.opensearch.analytics.spi.FieldStorageInfo;  
import org.opensearch.analytics.spi.FieldType;
        RexNode call = rexBuilder.makeCall(SqlStdOperatorTable.IS_NULL, rexBuilder.makeInputRef(varchar, 0));  
import org.opensearch.index.query.ExistsQueryBuilder;  
import org.apache.calcite.sql.type.SqlTypeName;
import org.opensearch.index.query.BoolQueryBuilder;
    public void setUp() throws Exception {
}
 *
        RexNode call = rexBuilder.makeCall(SqlStdOperatorTable.IS_NOT_NULL, rexBuilder.makeInputRef(varchar, 0));
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
import org.apache.calcite.rel.type.RelDataType;
        rexBuilder = new RexBuilder(typeFactory);
        typeFactory = new JavaTypeFactoryImpl();  
        assertTrue(qb instanceof BoolQueryBuilder);
public class IsNullSerializerTests extends OpenSearchTestCase {  
    }  
 */  
        RexNode call = rexBuilder.makeCall(SqlStdOperatorTable.IS_NOT_NULL, rexBuilder.makeInputRef(varchar, 0));
import org.apache.calcite.rex.RexBuilder;
        );
    private RelDataTypeFactory typeFactory;
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
    private final IsNullSerializer isNullSerializer = new IsNullSerializer(false);
        super.setUp();
    private static final List<FieldStorageInfo> FIELD_STORAGE = List.of(
    public void testIsNullProducesMustNotExists() {
/*  
import java.util.List;
        QueryBuilder qb = isNullSerializer.buildQueryBuilder((RexCall) call, FIELD_STORAGE);
    }
        assertTrue(qb instanceof ExistsQueryBuilder);  
    public void testIsNotNullProducesExists() {  
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
package org.opensearch.be.lucene.serializers;
    }  
    private final IsNullSerializer isNotNullSerializer = new IsNullSerializer(true);  
 * The OpenSearch Contributors require contributions made to  
    private RelDataType varchar;  
        QueryBuilder qb = isNotNullSerializer.buildQueryBuilder((RexCall) call, FIELD_STORAGE);
    private RexBuilder rexBuilder;
        assertEquals("msg.keyword", ((ExistsQueryBuilder) qb).fieldName());
        assertEquals("status", ((ExistsQueryBuilder) bool.mustNot().get(0)).fieldName());  
import org.opensearch.index.query.QueryBuilder;
        assertEquals(1, bool.mustNot().size());
    }
        BoolQueryBuilder bool = (BoolQueryBuilder) qb;  
        new FieldStorageInfo("status", "keyword", FieldType.KEYWORD, List.of(), List.of("lucene"), List.of(), false)  
            new FieldStorageInfo("msg", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false, "keyword")  
    );
    @Override  
        List<FieldStorageInfo> withSubfield = List.of(
        varchar = typeFactory.createSqlType(SqlTypeName.VARCHAR);
import org.opensearch.test.OpenSearchTestCase;
 * compatible open source license.
        QueryBuilder qb = isNotNullSerializer.buildQueryBuilder((RexCall) call, withSubfield);  
        assertEquals("status", ((ExistsQueryBuilder) qb).fieldName());
import org.apache.calcite.rex.RexCall;
import org.apache.calcite.rex.RexNode;  
        assertTrue(qb instanceof ExistsQueryBuilder);
        assertTrue(bool.mustNot().get(0) instanceof ExistsQueryBuilder);
import org.apache.calcite.rel.type.RelDataTypeFactory;  
    public void testRoutesToExactMatchSubfield() {
