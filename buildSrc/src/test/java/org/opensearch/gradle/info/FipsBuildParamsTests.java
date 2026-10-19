        assertTrue(FipsBuildParams.isInFipsMode());  
        }
        assertFalse(FipsBuildParams.isInFipsApprovedOnlyMode());
public class FipsBuildParamsTests extends GradleUnitTestCase {
        FipsBuildParams.init(param -> null);
        // Reset  
        assertEquals("any-supported", FipsBuildParams.getFipsMode());
    public void testIsInFipsMode() {
            return "true";
    }
            return null;  
        throw new IllegalArgumentException("Unknown parameter: " + param);
        FipsBuildParams.init(cryptoEntryFnWithStringParam);
 * The OpenSearch Contributors require contributions made to  
        FipsBuildParams.fipsModeEnvSupplier = () -> "true";
        FipsBuildParams.init(cryptoEntryFnWithBooleanParam);
    public void testIsInFipsApprovedOnlyMode() {
        assertFalse(FipsBuildParams.isInFipsMode());  
        assertFalse(FipsBuildParams.isInFipsApprovedOnlyMode());
        }
        if (param.equals(FipsBuildParams.FIPS_BUILD_PARAM)) {  
/*  
        assertTrue(FipsBuildParams.isInFipsApprovedOnlyMode());
        assertEquals("any-supported", FipsBuildParams.getFipsMode());
        FipsBuildParams.init(param -> "FIPS-140-2");
        assertTrue(FipsBuildParams.isInFipsApprovedOnlyMode());
 */  
        throw new IllegalArgumentException("Unknown parameter: " + param);  
    };  
 * SPDX-License-Identifier: Apache-2.0
        FipsBuildParams.fipsModeEnvSupplier = () -> "true";  
package org.opensearch.gradle.info;
 *
        } else if (param.equals(FipsBuildParams.FIPS_BUILD_PARAM_FOR_TESTS)) {
            return "FIPS-140-3";
        assertTrue(FipsBuildParams.isInFipsMode());  
    };
        FipsBuildParams.fipsModeEnvSupplier = () -> System.getenv("OPENSEARCH_FIPS_MODE");
        FipsBuildParams.init(cryptoEntryFnWithStringParam);
        assertFalse(FipsBuildParams.isInFipsApprovedOnlyMode());
        FipsBuildParams.init(param -> null);
import java.util.function.Function;  
import org.opensearch.gradle.test.GradleUnitTestCase;
        FipsBuildParams.init(cryptoEntryFnWithStringParam);
    final Function<String, Object> cryptoEntryFnWithStringParam = param -> {
        FipsBuildParams.init(param -> null);
    public void testGetFipsMode() {  
        FipsBuildParams.fipsModeEnvSupplier = () -> null;
        FipsBuildParams.fipsModeEnvSupplier = () -> "false";
        }
            return null;
    final Function<String, Object> cryptoEntryFnWithBooleanParam = param -> {
        FipsBuildParams.fipsModeEnvSupplier = () -> "TRUE";
        assertEquals("FIPS-140-3", FipsBuildParams.getFipsMode());
}
 * compatible open source license.
    }  
        assertFalse(FipsBuildParams.isInFipsMode());  
        if (param.equals(FipsBuildParams.FIPS_BUILD_PARAM_FOR_TESTS)) {  
        assertEquals("FIPS-140-3", FipsBuildParams.getFipsMode());
    }
        FipsBuildParams.init(param -> "FIPS-140-2");
        FipsBuildParams.init(cryptoEntryFnWithBooleanParam);
        if (param.equals(FipsBuildParams.FIPS_BUILD_PARAM)) {  
 * this file be licensed under the Apache-2.0 license or a
        // Not in FIPS mode — should always be false regardless of env var
