import org.apache.calcite.sql.SqlFunction;  
    );
    public void testRegexpRoutesToExactMatchSubfield() {  
import org.apache.calcite.rex.RexBuilder;
        List<FieldStorageInfo> withSubfield = List.of(
import org.apache.calcite.sql.SqlKind;
        rexBuilder = new RexBuilder(typeFactory);
    private static final SqlFunction REGEXP_FN = new SqlFunction(
import org.apache.calcite.sql.type.OperandTypes;  
    }
 * this file be licensed under the Apache-2.0 license or a
    private RexBuilder rexBuilder;  
        assertTrue(qb instanceof RegexpQueryBuilder);  
        null,
import org.apache.calcite.rex.RexNode;
    public void setUp() throws Exception {
public class RegexpSerializerTests extends OpenSearchTestCase {
 *
        assertEquals(".*google\\.com.*", rq.value());  
}  
    );
import org.opensearch.index.query.RegexpQueryBuilder;  
        RegexpQueryBuilder rq = (RegexpQueryBuilder) qb;
 */  
        assertEquals(".*error[0-9]+.*", rq.value());
        SqlFunctionCategory.USER_DEFINED_FUNCTION
    private final RegexpSerializer serializer = new RegexpSerializer();
    }
    private RelDataType varchar;
import org.apache.calcite.rel.type.RelDataTypeFactory;  
        typeFactory = new JavaTypeFactoryImpl();
package org.opensearch.be.lucene.serializers;
        SqlKind.OTHER_FUNCTION,  
    private RelDataTypeFactory typeFactory;
        varchar = typeFactory.createSqlType(SqlTypeName.VARCHAR);  
import org.apache.calcite.rel.type.RelDataType;
import org.opensearch.analytics.spi.FieldStorageInfo;  
        OperandTypes.ANY_ANY,  
 * The OpenSearch Contributors require contributions made to  
import org.apache.calcite.sql.type.ReturnTypes;
    }
    public void testRegexpProducesRegexpQuery() {
    }
        QueryBuilder qb = serializer.buildQueryBuilder((org.apache.calcite.rex.RexCall) regexpCall("google\\.com"), FIELD_STORAGE);
            new FieldStorageInfo("msg", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false, "keyword")
        super.setUp();  
    private RexNode regexpCall(String pattern) {  
import org.apache.calcite.sql.SqlFunctionCategory;
import org.opensearch.analytics.spi.FieldType;
    @Override
        new FieldStorageInfo("url", "keyword", FieldType.KEYWORD, List.of(), List.of("lucene"), List.of(), false)
        return rexBuilder.makeCall(REGEXP_FN, rexBuilder.makeInputRef(varchar, 0), rexBuilder.makeLiteral(pattern));
import java.util.List;  
/*  
import org.apache.calcite.sql.type.SqlTypeName;
        "REGEXP",
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.test.OpenSearchTestCase;
        assertEquals("msg.keyword", rq.fieldName());  
        ReturnTypes.BOOLEAN,
 * compatible open source license.
    private static final List<FieldStorageInfo> FIELD_STORAGE = List.of(  
        QueryBuilder qb = serializer.buildQueryBuilder((org.apache.calcite.rex.RexCall) regexpCall("error[0-9]+"), withSubfield);
import org.opensearch.index.query.QueryBuilder;
        );  
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        assertEquals("url", rq.fieldName());
        RegexpQueryBuilder rq = (RegexpQueryBuilder) qb;
