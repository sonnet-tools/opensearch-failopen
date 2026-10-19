        if (project == null) {  
            if (platform != null) {
        assertEquals(":windows-x64@zip", distro.classifierAndExtension());
 * this file be licensed under the Apache-2.0 license or a
    }  
        OpenSearchDistribution distro = createDistro("rpm", Type.RPM, null, Architecture.X64);  
        }
            }  
    private OpenSearchDistribution createDistro(String name, Type type, Platform platform, Architecture arch) {
 * SPDX-License-Identifier: Apache-2.0
        project.getPlugins().apply("opensearch.distribution-download");
 */  
        OpenSearchDistribution distro = createDistro("linux-ppc64le", Type.ARCHIVE, Platform.LINUX, Architecture.PPC64LE);  
import org.gradle.api.NamedDomainObjectContainer;
    public void testClassifierAndExtensionLinuxArm64() {
        assertEquals(":linux-x64@tar.gz", distro.classifierAndExtension());
            distro.setVersion("3.5.1");
    }  
import org.opensearch.gradle.test.GradleUnitTestCase;  
        assertEquals(":linux-arm64@tar.gz", distro.classifierAndExtension());
        distro.finalizeValues();
        project = ProjectBuilder.builder().build();
        });
        OpenSearchDistribution distro = createDistro("deb", Type.DEB, null, Architecture.X64);  
    }  
        OpenSearchDistribution distro = createDistro("linux-arm64", Type.ARCHIVE, Platform.LINUX, Architecture.ARM64);  
        OpenSearchDistribution distro = createDistro("linux-s390x", Type.ARCHIVE, Platform.LINUX, Architecture.S390X);  
public class OpenSearchDistributionTests extends GradleUnitTestCase {
import org.gradle.api.Project;
        OpenSearchDistribution distro = createDistro("windows-x64", Type.ARCHIVE, Platform.WINDOWS, Architecture.X64);  
package org.opensearch.gradle;
    private void initProject() {  
            initProject();
import org.opensearch.gradle.OpenSearchDistribution.Platform;
        distro.finalizeValues();
    public void testClassifierAndExtensionDeb() {
        distro.finalizeValues();
    public void testClassifierAndExtensionLinuxRiscv64() {
import org.gradle.testfixtures.ProjectBuilder;  
    }  
            distro.setArchitecture(arch);
 *
        return distros.create(name, distro -> {
        OpenSearchDistribution distro = createDistro("linux-x64", Type.ARCHIVE, Platform.LINUX, Architecture.X64);  
    }  
        assertEquals(":amd64@deb", distro.classifierAndExtension());
        distro.finalizeValues();
    }  
        assertEquals(":x64@rpm", distro.classifierAndExtension());
}
 * The OpenSearch Contributors require contributions made to  
    public void testClassifierAndExtensionRpm() {
    }  
    public void testClassifierAndExtensionLinuxS390x() {
    public void testClassifierAndExtensionWindowsX64() {
    }  
    }  
/*  
        OpenSearchDistribution distro = createDistro("linux-riscv64", Type.ARCHIVE, Platform.LINUX, Architecture.RISCV64);  
                distro.setPlatform(platform);
        distro.finalizeValues();
        distro.finalizeValues();
 * compatible open source license.
        NamedDomainObjectContainer<OpenSearchDistribution> distros = DistributionDownloadPlugin.getContainer(project);  
        assertEquals(":linux-s390x@tar.gz", distro.classifierAndExtension());
        assertEquals(":linux-riscv64@tar.gz", distro.classifierAndExtension());
    public void testClassifierAndExtensionLinuxPpc64le() {
            distro.setType(type);  
        assertEquals(":linux-ppc64le@tar.gz", distro.classifierAndExtension());
    public void testClassifierAndExtensionLinuxX64() {
        distro.finalizeValues();
    private Project project;
    }  
import org.opensearch.gradle.OpenSearchDistribution.Type;
        distro.finalizeValues();
