        assertEquals("_", LikeSerializer.convertSqlLikeToLuceneWildcard("\\_"));
}  
        assertEquals("literal", LikeSerializer.convertSqlLikeToLuceneWildcard("literal"));
    public void setUp() throws Exception {
import org.apache.calcite.rex.RexBuilder;
        QueryBuilder qb = serializer.buildQueryBuilder((RexCall) call, FIELD_STORAGE);
        assertEquals("name", wqb.fieldName());  
import org.opensearch.index.query.QueryBuilder;
        assertEquals("%", LikeSerializer.convertSqlLikeToLuceneWildcard("\\%"));  
import org.apache.calcite.rel.type.RelDataType;
import java.util.List;  
 */  
    }
        varchar = typeFactory.createSqlType(SqlTypeName.VARCHAR);  
    }
 * this file be licensed under the Apache-2.0 license or a
        QueryBuilder qb = serializer.buildQueryBuilder((RexCall) call, FIELD_STORAGE);  
    );
    public void testPatternConversion() {
    private RexBuilder rexBuilder;  
        typeFactory = new JavaTypeFactoryImpl();
    public void testLikeProducesWildcardQuery() {  
        super.setUp();  
        WildcardQueryBuilder wqb = (WildcardQueryBuilder) qb;
        RexNode call = rexBuilder.makeCall(SqlLibraryOperators.ILIKE, rexBuilder.makeInputRef(varchar, 0), rexBuilder.makeLiteral("te_t"));
 * The OpenSearch Contributors require contributions made to  
import org.apache.calcite.rex.RexNode;  
            SqlLibraryOperators.ILIKE,
    }
            rexBuilder.makeInputRef(varchar, 0),  
    public void testLikeSingleCharWildcard() {  
            rexBuilder.makeLiteral("%apple%")
            SqlLibraryOperators.ILIKE,  
    private RelDataTypeFactory typeFactory;
import org.opensearch.test.OpenSearchTestCase;
        assertEquals("te?t", wqb.value());
    private static final List<FieldStorageInfo> FIELD_STORAGE = List.of(  
    @Override
    private RelDataType varchar;
        RexNode call = rexBuilder.makeCall(
        );
import org.opensearch.index.query.WildcardQueryBuilder;  
    }
        new FieldStorageInfo("name", "keyword", FieldType.KEYWORD, List.of(), List.of("lucene"), List.of(), false)
        assertEquals("*foo?bar*", LikeSerializer.convertSqlLikeToLuceneWildcard("%foo_bar%"));
        assertEquals("prefix*", wqb.value());  
 * compatible open source license.
        WildcardQueryBuilder wqb = (WildcardQueryBuilder) qb;
        WildcardQueryBuilder wqb = (WildcardQueryBuilder) qb;  
package org.opensearch.be.lucene.serializers;
        assertEquals("*", LikeSerializer.convertSqlLikeToLuceneWildcard("%"));
            rexBuilder.makeInputRef(varchar, 0),
            rexBuilder.makeLiteral("prefix%")
        QueryBuilder qb = serializer.buildQueryBuilder((RexCall) call, FIELD_STORAGE);
        assertEquals("?", LikeSerializer.convertSqlLikeToLuceneWildcard("_"));  
import org.apache.calcite.sql.type.SqlTypeName;
import org.apache.calcite.sql.fun.SqlLibraryOperators;
        assertTrue(qb instanceof WildcardQueryBuilder);
        );  
public class LikeSerializerTests extends OpenSearchTestCase {
    public void testLikePrefixPattern() {
 *
import org.apache.calcite.rex.RexCall;
        assertEquals("*apple*", wqb.value());
        rexBuilder = new RexBuilder(typeFactory);
import org.opensearch.analytics.spi.FieldType;
    }
import org.opensearch.analytics.spi.FieldStorageInfo;  
 * SPDX-License-Identifier: Apache-2.0
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        RexNode call = rexBuilder.makeCall(
    private final LikeSerializer serializer = new LikeSerializer();
import org.apache.calcite.rel.type.RelDataTypeFactory;  
/*  
