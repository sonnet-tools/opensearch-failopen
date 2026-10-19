        RexCall fromUnixtime = (RexCall) unwrapCast(adapted);  
import org.apache.calcite.sql.type.SqlTypeName;
        typeFactory = new JavaTypeFactoryImpl();
        // WidthBucketAdapter pattern-matches MINUS(MAX OVER (), MIN OVER ()) for `bin <ts> bins=N`.
    }
        RexNode adapted = adapter.adapt(call, List.of(), cluster);
        adapter = new MinusAdapter();
        // Expect: CAST(from_unixtime(CAST(MINUS(to_unixtime(t1), to_unixtime(t2)) AS DOUBLE)) AS TIMESTAMP).
        RexNode minOver = makeOverEmpty(SqlStdOperatorTable.MIN, tsCol, ts);  
import org.apache.calcite.rex.RexCall;  
            List.of(),
        assertSame(UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP, ((RexCall) minus.getOperands().get(1)).getOperator());  
        assertSame("numeric subtract must be returned untouched", call, adapter.adapt(call, List.of(), cluster));
        RexNode maxOver = makeOverEmpty(SqlStdOperatorTable.MAX, tsCol, ts);
/*  
import org.apache.calcite.plan.hep.HepPlanner;
        assertSame(UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP, ((RexCall) minus.getOperands().get(1)).getOperator());  
 * this file be licensed under the Apache-2.0 license or a
    public void testNumericMinusPassesThroughUnchanged() {  
        RexCall minus = (RexCall) unwrapCast(fromUnixtime.getOperands().get(0));  
import org.apache.calcite.rex.RexNode;
import org.apache.calcite.sql.SqlKind;
 */  
        RexNode l = rexBuilder.makeInputRef(typeFactory.createSqlType(left), 0);  
        assertSame(SqlStdOperatorTable.MINUS, minus.getOperator());
        assertSame(plus, adapter.adapt(plus, List.of(), cluster));  
            RexWindowExclusion.EXCLUDE_NO_OTHER,
        RexCall plus = (RexCall) rexBuilder.makeCall(
        RexNode adapted = adapter.adapt(call, List.of(), cluster);  
        while (node instanceof RexCall call && call.getKind() == SqlKind.CAST) {  
            RexWindowBounds.UNBOUNDED_FOLLOWING,
            node = call.getOperands().get(0);
            returnType,
        RexNode tsCol = rexBuilder.makeInputRef(ts, 0);
        RelDataType ts = typeFactory.createSqlType(SqlTypeName.TIMESTAMP);  
    private RexCall minusOf(SqlTypeName left, SqlTypeName right) {
    public void testUnaryMinusPassesThrough() {  
    }
    private RelOptCluster cluster;
package org.opensearch.be.datafusion;
import org.apache.calcite.sql.SqlAggFunction;
            rexBuilder.makeInputRef(ts, 0),  
import org.apache.calcite.rel.type.RelDataType;  
import com.google.common.collect.ImmutableList;
        RexNode r = rexBuilder.makeInputRef(typeFactory.createSqlType(right), 1);
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
}
    public void testNonMinusOperatorPassesThrough() {
        RexCall divide = (RexCall) adapted;
        assertSame(UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP, ((RexCall) minus.getOperands().get(0)).getOperator());
    private MinusAdapter adapter;
            RexWindowBounds.UNBOUNDED_PRECEDING,  
import java.util.List;
 *
import org.apache.calcite.rex.RexBuilder;
        RexCall minus = (RexCall) divide.getOperands().get(0);  
    @Override
    }
        assertSame(unary, adapter.adapt(unary, List.of(), cluster));  
        return node;  
        cluster = RelOptCluster.create(new HepPlanner(new HepProgramBuilder().build()), rexBuilder);  
        assertSame(minus, adapter.adapt(minus, List.of(), cluster));
    private RexNode makeOverEmpty(SqlAggFunction agg, RexNode arg, RelDataType returnType) {
    }
        assertSame(RustUdfDateTimeAdapters.LOCAL_FROM_UNIXTIME_OP, fromUnixtime.getOperator());
            true,
        RelDataType i32 = typeFactory.createSqlType(SqlTypeName.INTEGER);
    }
        return rexBuilder.makeOver(  
import org.apache.calcite.rel.type.RelDataTypeFactory;
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        assertSame(UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP, ((RexCall) minus.getOperands().get(0)).getOperator());
        RelDataType ts = typeFactory.createSqlType(SqlTypeName.TIMESTAMP);  
    private static RexNode unwrapCast(RexNode node) {
 * compatible open source license.
        rexBuilder = new RexBuilder(typeFactory);
        // DATE-DATE → integer day-count: DIVIDE(MINUS(to_unixtime(L), to_unixtime(R)), 86400).
    public void setUp() throws Exception {
    private RelDataTypeFactory typeFactory;
        }
            rexBuilder.makeInputRef(ts, 1)
        // MinusAdapter must leave it intact so the downstream adapter still sees SqlKind.MINUS.
            SqlStdOperatorTable.PLUS,
            false,
    private RexBuilder rexBuilder;  
            false
    }
        return (RexCall) rexBuilder.makeCall(SqlStdOperatorTable.MINUS, l, r);
public class MinusAdapterTests extends OpenSearchTestCase {  
    public void testMinusOfWindowAggsPassesThrough() {  
 * SPDX-License-Identifier: Apache-2.0
            true,  
        super.setUp();  
            List.of(arg),  
            ImmutableList.of(),
    public void testDateMinusDateReturnsBigIntDayCount() {  
        RexCall call = minusOf(SqlTypeName.INTEGER, SqlTypeName.INTEGER);
import org.apache.calcite.rex.RexWindowExclusion;  
 * The OpenSearch Contributors require contributions made to  
    }  
        RexCall call = minusOf(SqlTypeName.TIMESTAMP, SqlTypeName.TIMESTAMP);
    }  
        RexCall unary = (RexCall) rexBuilder.makeCall(SqlStdOperatorTable.UNARY_MINUS, rexBuilder.makeInputRef(i32, 0));
import org.apache.calcite.plan.hep.HepProgramBuilder;
        RexCall call = minusOf(SqlTypeName.DATE, SqlTypeName.DATE);
        );
        RexCall minus = (RexCall) rexBuilder.makeCall(SqlStdOperatorTable.MINUS, maxOver, minOver);
    }  
        assertSame(SqlStdOperatorTable.MINUS, minus.getOperator());
        assertSame(SqlStdOperatorTable.DIVIDE, divide.getOperator());  
            false,  
import org.apache.calcite.plan.RelOptCluster;  
    public void testTimestampMinusTimestampRewritesToUnixSecondsDiff() {
            agg,
        );
    }  
import org.apache.calcite.rex.RexWindowBounds;
import org.opensearch.test.OpenSearchTestCase;
        assertSame(SqlTypeName.BIGINT, divide.getType().getSqlTypeName());
