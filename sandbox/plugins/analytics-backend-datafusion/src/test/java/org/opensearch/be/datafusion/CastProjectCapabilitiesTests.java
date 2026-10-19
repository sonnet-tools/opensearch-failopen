 * The OpenSearch Contributors require contributions made to  
        assertTrue(
            }  
            "CAST must be registered for MAP return type to support implicit map casts",
    public void testSafeCastSupportsArrayReturnType() {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.analytics.spi.BackendCapabilityProvider;
    }  
        );  
}
import java.util.Set;
            "SAFE_CAST must be registered for MAP return type to support nullable map casts",
        assertTrue(  
 * this file be licensed under the Apache-2.0 license or a
            "SAFE_CAST must be registered for ARRAY return type to support nullable array casts",  
 */  
    public void testSafeCastSupportsMapReturnType() {
    public void testCastSupportsArrayReturnType() {
 * compatible open source license.
                    return true;
/**  
        for (ProjectCapability cap : capabilities) {
                }
public class CastProjectCapabilitiesTests extends OpenSearchTestCase {  
    }  
        Set<ProjectCapability> capabilities = getProjectCapabilities();  
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.analytics.spi.FieldType;
            hasScalarCapability(ScalarFunction.SAFE_CAST, FieldType.ARRAY)
        assertTrue(  
    }  
 */
        }
 * for ARRAY and MAP return types. The planner keys capability lookups on the call's
        );
            hasScalarCapability(ScalarFunction.CAST, FieldType.MAP)  
        return false;
    public void testCastSupportsMapReturnType() {  
    }
        DataFusionAnalyticsBackendPlugin backendPlugin = new DataFusionAnalyticsBackendPlugin(new DataFusionPlugin());  
    }
                if (scalar.function().equals(function) && scalar.fieldTypes().contains(fieldType)) {  
 * that trigger implicit CAST-to-ARRAY fail with "No backend supports scalar function [CAST]".
        assertTrue(
        );  
            "CAST must be registered for ARRAY return type to support implicit array casts",
 *
    private boolean hasScalarCapability(ScalarFunction function, FieldType fieldType) {
import org.opensearch.analytics.spi.ScalarFunction;
 * Contract test: CAST and SAFE_CAST must be registered as Scalar project capabilities
package org.opensearch.be.datafusion;
 * return type, so without these registrations, queries like {@code mvfind(array(...), ...)}  
import org.opensearch.analytics.spi.ProjectCapability;  
        );
    }
    private Set<ProjectCapability> getProjectCapabilities() {
            if (cap instanceof ProjectCapability.Scalar scalar) {
            hasScalarCapability(ScalarFunction.CAST, FieldType.ARRAY)
        return provider.projectCapabilities();
            hasScalarCapability(ScalarFunction.SAFE_CAST, FieldType.MAP)
/*  
        BackendCapabilityProvider provider = backendPlugin.getCapabilityProvider();
