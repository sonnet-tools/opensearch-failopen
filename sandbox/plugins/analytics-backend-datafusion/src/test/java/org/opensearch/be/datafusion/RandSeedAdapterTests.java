import java.util.List;
import org.opensearch.test.OpenSearchTestCase;  
    }  
import org.apache.calcite.plan.hep.HepProgramBuilder;
        super.setUp();  
            () -> new RandSeedAdapter().adapt(original, List.of(), cluster)  
 * Unit tests for {@link RandSeedAdapter}. PPL {@code rand([seed])} accepts an optional seed that
import org.apache.calcite.rel.type.RelDataTypeFactory;  
        assertTrue("error should explain seeded RAND is unsupported", e.getMessage().toLowerCase(java.util.Locale.ROOT).contains("seed"));
 * this file be licensed under the Apache-2.0 license or a
        RexNode seed = rexBuilder.makeLiteral(42, typeFactory.createSqlType(SqlTypeName.INTEGER), false);
        IllegalArgumentException e = expectThrows(
 */
    public void testNiladicRandPassedThrough() {
 * SPDX-License-Identifier: Apache-2.0
        RexNode adapted = new RandSeedAdapter().adapt(original, List.of(), cluster);
    @Override
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
    private RelDataTypeFactory typeFactory;
public class RandSeedAdapterTests extends OpenSearchTestCase {  
        typeFactory = new JavaTypeFactoryImpl();
 * compatible open source license.
import org.apache.calcite.rex.RexBuilder;
 * DataFusion's niladic {@code random()} cannot express. Niladic {@code rand()} maps to the niladic  
        cluster = RelOptCluster.create(planner, rexBuilder);
        assertSame("operator stays RAND", SqlStdOperatorTable.RAND, call.getOperator());
        rexBuilder = new RexBuilder(typeFactory);
    private RelOptCluster cluster;
    private RelDataType doubleType;
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());  
/*  
import org.apache.calcite.rel.type.RelDataType;
    }  
    public void testSeededRandRejectedWithClearError() {  
        doubleType = typeFactory.createSqlType(SqlTypeName.DOUBLE);
import org.apache.calcite.rex.RexCall;
    public void setUp() throws Exception {
 * rejected with a clear error rather than silently dropping the seed (which would degrade  
import org.apache.calcite.rex.RexNode;  
    }
}
 */  
import org.apache.calcite.plan.hep.HepPlanner;  
        RexCall original = (RexCall) rexBuilder.makeCall(doubleType, SqlStdOperatorTable.RAND, List.of(seed));
 * deterministic seeded output into non-deterministic random()).
    private RexBuilder rexBuilder;  
package org.opensearch.be.datafusion;
        );
import org.apache.calcite.sql.type.SqlTypeName;
 * {@link SqlStdOperatorTable#RAND}, which {@code DataFusionFragmentConvertor} maps to DataFusion's
        assertTrue("no operands", call.getOperands().isEmpty());  
        RexCall original = (RexCall) rexBuilder.makeCall(doubleType, SqlStdOperatorTable.RAND, List.of());  
        RexCall call = (RexCall) adapted;
 *
 * The OpenSearch Contributors require contributions made to  
/**
import org.apache.calcite.plan.RelOptCluster;
 * {@code random()} — avoiding {@code Unable to convert call RAND(i32)}. Seeded {@code rand(seed)} is
            IllegalArgumentException.class,
