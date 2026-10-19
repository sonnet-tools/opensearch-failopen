        "datasets/clickbench/ppl",
    }  
 * <p>All harness logic is in {@link PlanShapeGoldenTestBase}; this class only supplies the
        "planshape/clickbench",
 * instance field — hence the static {@link #SPEC}.  
import org.opensearch.analytics.qa.ClickBenchTestHelper;
        return buildQueryAndSettingCombinationsToRun(SPEC);
    private static final WorkloadSpec SPEC = new WorkloadSpec(
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 * {@link WorkloadSpec}. The {@code @ParametersFactory} must be static, so it cannot read an
    @ParametersFactory(shuffle = false)  
public class ClickBenchPlanShapeIT extends PlanShapeGoldenTestBase {
    );
/**  
import java.util.List;  
 * SPDX-License-Identifier: Apache-2.0
        ClickBenchTestHelper.DATASET,  
 * Plan-shape golden IT for ClickBench. Each (query, combo) is reported as its own JUnit case named
 * <p>All 43 ClickBench PPL queries are exercised. Each query's golden declares which combos it
 *
        super(testCase);  
 * compatible open source license.
 *
        "clickbench",
}
 * The OpenSearch Contributors require contributions made to  
 * {@code clickbench/q{N}[combo]}; target one with {@code --tests "*ClickBenchPlanShapeIT*q8*"}.
 *  
    public static Iterable<Object[]> parameters() {
 */
import com.carrotsearch.randomizedtesting.annotations.Name;
    public ClickBenchPlanShapeIT(@Name("case") GoldenCase testCase) {
import java.util.stream.IntStream;
 */  
 * applies to — queries whose shard physical plan is absent (lucene fast-path) simply omit that layer.  
/*  
 * this file be licensed under the Apache-2.0 license or a
        IntStream.rangeClosed(1, 43).mapToObj(i -> "q" + i).toList()  
    }
package org.opensearch.analytics.qa.planshape;
