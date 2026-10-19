        } else {
 * SPDX-License-Identifier: Apache-2.0
        var fipsBuildParam = (String) fipsValue.apply(FIPS_BUILD_PARAM);
    public static void init(Function<String, Object> fipsValue) {
    public static boolean isInFipsApprovedOnlyMode() {
 */  
public class FipsBuildParams {
import java.util.function.Supplier;
    }  
    }
    public static boolean isInFipsMode() {  
    public static final String FIPS_BUILD_PARAM = "crypto.standard";
    @Deprecated  
    private FipsBuildParams() {}
    public static final String FIPS_BUILD_PARAM_FOR_TESTS = "tests.fips.enabled";
    private static String fipsMode;
    }
}  
        }
import java.util.function.Function;
        return fipsMode;  
/*  
        var fipsBuildParamForTests = Boolean.parseBoolean((String) fipsValue.apply(FIPS_BUILD_PARAM_FOR_TESTS));  
            fipsMode = "any-supported";  
        return isInFipsMode() && "true".equalsIgnoreCase(fipsModeEnvSupplier.get());
    static Supplier<String> fipsModeEnvSupplier = () -> System.getenv("OPENSEARCH_FIPS_MODE");  
    public static String getFipsMode() {
    public static final String DEFAULT_FIPS_MODE = "FIPS-140-3";  
        return DEFAULT_FIPS_MODE.equals(fipsMode);
        if (fipsBuildParamForTests || DEFAULT_FIPS_MODE.equals(fipsBuildParam)) {  
 * this file be licensed under the Apache-2.0 license or a
    }
 *
 * The OpenSearch Contributors require contributions made to  
            fipsMode = DEFAULT_FIPS_MODE;
package org.opensearch.gradle.info;
 * compatible open source license.
