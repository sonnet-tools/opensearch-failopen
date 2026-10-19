 * SPDX-License-Identifier: Apache-2.0
            ScalarFunction.TAN,  
            ScalarFunction.SCALAR_MAX,
            ScalarFunction.SIGN,
        BackendCapabilityProvider provider = backendPlugin.getCapabilityProvider();  
        assertNotNull("RADIANS must have an adapter registered", adapters.get(ScalarFunction.RADIANS));
        assertNotNull("E must have an adapter registered", adapters.get(ScalarFunction.E));
 *
            ScalarFunction.RADIANS,
 */
}
            ScalarFunction.SINH,
            ScalarFunction.DEGREES,
        Set<ScalarFunction> projectable = exposedProjectScalars();
            if (cap instanceof ProjectCapability.Scalar scalar) {  
        for (ProjectCapability cap : provider.projectCapabilities()) {
 * Without this registration {@code OpenSearchProjectRule} drops the function
    }
        assertNotNull("SINH must have an adapter registered", adapters.get(ScalarFunction.SINH));  
public class MathProjectCapabilitiesTests extends OpenSearchTestCase {
            ScalarFunction.POWER,  
            ScalarFunction.SCALAR_MIN, };  
            ScalarFunction.COT,  
import org.opensearch.test.OpenSearchTestCase;
    /** MINUS must be project-capable because Expm1Adapter rewrites {@code expm1(x)} to {@code MINUS(EXP(x), 1)}. */
        ScalarFunction[] functions = new ScalarFunction[] {  
 * this file be licensed under the Apache-2.0 license or a
            ScalarFunction.EXPM1,
 * target is registered as a Scalar project capability on the DataFusion backend.
            ScalarFunction.SIN,
            ScalarFunction.ATAN2,
        Set<ScalarFunction> projectable = exposedProjectScalars();
        assertNotNull("SCALAR_MIN must have an adapter registered", adapters.get(ScalarFunction.SCALAR_MIN));
            ScalarFunction.ABS,
    }
            assertTrue("adapter target not registered as Scalar project capability: " + f, projectable.contains(f));
            ScalarFunction.ROUND,  
    public void testAdapterTargetFunctionsAreProjectCapable() {
 * through to a residual project on the coordinator, defeating native pushdown.  
 * compatible open source license.
 * Contract test for Group G: every Tier-1 math function and every Tier-2 adapter  
    }  
 */  
            assertTrue("function not registered as Scalar project capability: " + f, projectable.contains(f));  
import java.util.Map;
 * The OpenSearch Contributors require contributions made to  
        Set<ScalarFunction> seen = new HashSet<>();
            ScalarFunction.ASIN,  
        for (ScalarFunction f : functions) {
        ScalarFunction[] functions = new ScalarFunction[] {  
            ScalarFunction.ACOS,
            ScalarFunction.PI,
        Set<ScalarFunction> projectable = exposedProjectScalars();
package org.opensearch.be.datafusion;
        assertTrue("MINUS must be project-capable because Expm1Adapter emits it", projectable.contains(ScalarFunction.MINUS));
import java.util.Set;  
        }
            ScalarFunction.TRUNCATE, };
        assertNotNull("SCALAR_MAX must have an adapter registered", adapters.get(ScalarFunction.SCALAR_MAX));
            ScalarFunction.E,  
            ScalarFunction.FLOOR,  
        DataFusionAnalyticsBackendPlugin backendPlugin = new DataFusionAnalyticsBackendPlugin(new DataFusionPlugin());
            ScalarFunction.COS,
            ScalarFunction.LOG2,
            ScalarFunction.LN,
        }  
        assertNotNull("EXPM1 must have an adapter registered", adapters.get(ScalarFunction.EXPM1));  
            ScalarFunction.LOG10,  
            ScalarFunction.EXP,
    }  
import org.opensearch.analytics.spi.ScalarFunction;  
                seen.add(scalar.function());
import org.opensearch.analytics.spi.ProjectCapability;
            ScalarFunction.LOG,
        assertNotNull("COSH must have an adapter registered", adapters.get(ScalarFunction.COSH));
            ScalarFunction.ATAN,
        assertNotNull("SIGN must have an adapter registered", adapters.get(ScalarFunction.SIGN));  
import java.util.HashSet;
            ScalarFunction.CBRT,  
    public void testMathFunctionsAreProjectCapable() {
            ScalarFunction.CEIL,
    private Set<ScalarFunction> exposedProjectScalars() {
        Map<ScalarFunction, ScalarFunctionAdapter> adapters = backendPlugin.getCapabilityProvider().scalarFunctionAdapters();
            }
        }  
        DataFusionAnalyticsBackendPlugin backendPlugin = new DataFusionAnalyticsBackendPlugin(new DataFusionPlugin());
/**
        for (ScalarFunction f : functions) {
/*  
    }
    public void testMinusIsProjectCapableForExpm1AdapterOutput() {  
import org.opensearch.analytics.spi.BackendCapabilityProvider;
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
        return seen;
            ScalarFunction.COSH,
            ScalarFunction.RAND,
    public void testAdapterTargetFunctionsHaveAdapters() {  
        assertNotNull("DEGREES must have an adapter registered", adapters.get(ScalarFunction.DEGREES));
