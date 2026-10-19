    }  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> serializer.buildQueryBuilder(call, FIELD_STORAGE));
    }  
    public void testBetweenBuildsClosedRangeQuery() {
    }  
    private RelDataTypeFactory typeFactory;
    }  
        RangeSet<NlsString> r = TreeRangeSet.create();  
        r.add(Range.lessThan(BigDecimal.ONE));  
import com.google.common.collect.RangeSet;  
import org.apache.calcite.rex.RexNode;
    private static final List<FieldStorageInfo> FIELD_STORAGE = List.of(
        RexNode ref = rexBuilder.makeInputRef(keywordType, 0);
    }  
        assertFalse(qb.includeUpper());
        RangeSet<NlsString> points = TreeRangeSet.create();  
        TermsQueryBuilder qb = (TermsQueryBuilder) build(points);
    public void testInListBuildsTermsQuery() {
import com.google.common.collect.ImmutableRangeSet;
    private NlsString str(String s) {
import java.math.BigDecimal;  
        assertEquals("str0", qb.fieldName());  
import org.opensearch.analytics.spi.FieldType;
        r.add(Range.closed(str("a"), str("m")));  
        assertEquals(2, bool.should().size());  
import org.opensearch.index.query.RangeQueryBuilder;
import org.apache.calcite.rex.RexBuilder;
        RangeQueryBuilder qb = (RangeQueryBuilder) build(r);
    public void setUp() throws Exception {
    public void testGreaterThanBuildsOpenLowerRange() {
    private RexBuilder rexBuilder;
import org.apache.calcite.util.Sarg;  
        return (NlsString) ((org.apache.calcite.rex.RexLiteral) rexBuilder.makeLiteral(s)).getValue();
    }  
package org.opensearch.be.lucene.serializers;
        RangeSet<BigDecimal> r = TreeRangeSet.create();
        assertTrue(qb.includeLower());  
import org.opensearch.test.OpenSearchTestCase;
        new FieldStorageInfo("str0", "keyword", FieldType.KEYWORD, List.of(), List.of("lucene"), List.of(), false)  
        assertTrue("BETWEEN is inclusive lower", qb.includeLower());  
     *  ByteString ctor path (which isn't on the test classpath). */  
import org.apache.calcite.util.NlsString;
        RexNode sargLit = rexBuilder.makeSearchArgumentLiteral(sarg, keywordType);  
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        rexBuilder = new RexBuilder(typeFactory);
    private final SargSerializer serializer = new SargSerializer();  
        assertEquals("a", qb.from());
        points.add(Range.singleton(str("apple")));
        super.setUp();
        // [a, m) → from inclusive, to exclusive
        points.add(Range.singleton(str("banana")));
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
    private RelDataType keywordType;  
import org.apache.calcite.rex.RexUnknownAs;
        // (k, +inf) → from exclusive, no upper bound
        assertTrue(bool.should().get(0) instanceof RangeQueryBuilder);
        r.add(Range.closedOpen(str("a"), str("m")));
        assertEquals("m", qb.to());
        RangeSet<NlsString> r = TreeRangeSet.create();
 */  
 */  
        assertTrue("BETWEEN is inclusive upper", qb.includeUpper());
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.query.QueryBuilder;
    );
    public void testRangeUnionBuildsShouldBool() {
    }
 *
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
import org.opensearch.analytics.spi.FieldStorageInfo;
        assertTrue(bool.should().get(1) instanceof RangeQueryBuilder);
        keywordType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
        return serializer.buildQueryBuilder(call, FIELD_STORAGE);
        assertEquals(List.of("apple", "banana", "cherry"), qb.values());
        // (-inf, 1) ∪ (1, +inf) over INTEGER == NOT IN (1) → isComplementedPoints → refuse.  
        assertEquals("k", qb.from());  
        typeFactory = new JavaTypeFactoryImpl();  
    }
        RangeQueryBuilder qb = (RangeQueryBuilder) build(r);
import org.opensearch.index.query.BoolQueryBuilder;  
        RexCall call = (RexCall) rexBuilder.makeCall(SqlStdOperatorTable.SEARCH, List.of(ref, sargLit));
        r.add(Range.closed(str("a"), str("c")));
 * Unit tests for {@link SargSerializer}: IN-points → TermsQuery, intervals → RangeQuery (bounds and
        RangeSet<NlsString> r = TreeRangeSet.create();
        r.add(Range.closed(str("x"), str("z")));  
import org.apache.calcite.rel.type.RelDataType;  
        // [a, c] ∪ [x, z] → bool{ should range, should range }  
        points.add(Range.singleton(str("cherry")));  
    }
        RexNode sargLit = rexBuilder.makeSearchArgumentLiteral(sarg, intType);
 * SPDX-License-Identifier: Apache-2.0
        r.add(Range.greaterThan(str("k")));
import com.google.common.collect.TreeRangeSet;
        r.add(Range.greaterThan(BigDecimal.ONE));
        assertTrue(e.getMessage().contains("not delegatable"));
/**  
public class SargSerializerTests extends OpenSearchTestCase {
        Sarg sarg = Sarg.of(RexUnknownAs.UNKNOWN, ImmutableRangeSet.copyOf(rangeSet));
import org.apache.calcite.rex.RexCall;  
    public void testNotInRefused() {
        RangeSet<NlsString> r = TreeRangeSet.create();  
        assertNull("no upper bound", qb.to());
        RexNode ref = rexBuilder.makeInputRef(intType, 0);  
/*  
    private QueryBuilder build(RangeSet rangeSet) {  
        RangeQueryBuilder qb = (RangeQueryBuilder) build(r);
        assertEquals("str0", qb.fieldName());  
 * range-unions), and refusal of NOT IN / all / none.
import org.apache.calcite.rel.type.RelDataTypeFactory;
    @SuppressWarnings({ "rawtypes", "unchecked" })
        RexCall call = (RexCall) rexBuilder.makeCall(SqlStdOperatorTable.SEARCH, List.of(ref, sargLit));
import org.apache.calcite.sql.type.SqlTypeName;
        Sarg<BigDecimal> sarg = Sarg.of(RexUnknownAs.UNKNOWN, ImmutableRangeSet.copyOf(r));
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.query.TermsQueryBuilder;  
        BoolQueryBuilder bool = (BoolQueryBuilder) build(r);
import com.google.common.collect.Range;
 * compatible open source license.
    public void testHalfOpenRangeBounds() {
    /** Build an NlsString the way Calcite stores a VARCHAR literal, without touching the avatica
}
    @Override  
        assertFalse(qb.includeLower());
import java.util.List;
