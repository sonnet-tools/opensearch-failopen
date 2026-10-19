     */
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(Architecture.PPC64LE, currentArchitecture("ppc64le"));  
        } finally {
 * this file be licensed under the Apache-2.0 license or a
    public void testInvalidCurrentArchitecture() {
        assertEquals(Architecture.RISCV64, currentArchitecture("riscv64"));
    public void testCurrentArchitecture() {
public class ArchitectureTests extends GradleUnitTestCase {  
    final String architecture = System.getProperty("os.arch", "");
        assertEquals(Architecture.X64, currentArchitecture("amd64"));
        System.setProperty("os.arch", osArchToTest);
/*  
        // Test new architecture
import org.opensearch.gradle.test.GradleUnitTestCase;
        }
    }  
    /**
        assertThrows("can not determine architecture from [", IllegalArgumentException.class, () -> currentArchitecture("fooBar64"));
            System.setProperty("os.arch", this.architecture);
     * @return the value of the {@link Architecture} enum which would have resulted with the given value.  
 *
        assertEquals(Architecture.S390X, currentArchitecture("s390x"));
 * The OpenSearch Contributors require contributions made to  
     * Determines the return value of {@link Architecture#current()} based on a string representing a potential OS Architecture.  
    }  
    private Architecture currentArchitecture(String osArchToTest) throws IllegalArgumentException {  
package org.opensearch.gradle;
        try {  
        assertEquals(Architecture.X64, currentArchitecture("x86_64"));  
     * @param osArchToTest  An expected value of the {@code os.arch} system property on another architecture.
    }
     * @throws IllegalArgumentException if the string is not mapped to a value of the {@link Architecture} enum.
 * compatible open source license.
}
            return Architecture.current();
     *
            // Restore actual architecture property value  
 */  
        assertEquals(Architecture.ARM64, currentArchitecture("aarch64"));
