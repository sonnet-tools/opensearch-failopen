            return identifier;
        }
        ),  
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
                    + "the Software without restriction, including without limitation the rights to\n"
    public static LicenseInfo licenseType(File licenseFile) {
        for (LicenseMatcher matcher : matchers) {  
                    + "THIS SOFTWARE IS PROVIDED BY .+ (``|''|\")AS IS(''|\") AND ANY EXPRESS OR\n"
                    + "so, subject to the following conditions:\n"
            this.identifier = identifier;
            false,
                    + "IN NO EVENT SHALL .+ BE LIABLE FOR ANY DIRECT, INDIRECT,\n"
 */
                    + "\n"
                    + "\n"
                    + "\n"  
                    + "modification, are permitted provided that the following conditions\n"
            true,
                    + "FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT\\. IN NO EVENT SHALL THE\n"
                    + "DATA, OR PROFITS; OR BUSINESS INTERRUPTION\\) HOWEVER CAUSED AND ON ANY\n"
        ),  
                Pattern.DOTALL
                    + "modification, are permitted provided that the following conditions\n"
                Pattern.DOTALL  
        ),  
                    + "NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,\n"
 * license agreements. See the NOTICE file distributed with
package org.opensearch.gradle.precommit;
                ("\n"
        private final boolean sourceRedistributionRequired;
        ),
        }
        new LicenseMatcher("MPL-1.1", true, false, Pattern.compile("Mozilla Public License.*Version 1.1", Pattern.DOTALL)),
                    + "    documentation and/or other materials provided with the distribution\\.\n"
import java.io.UncheckedIOException;  
            false,
            }
                    + "\n"
                    + " 2\\. Redistributions in binary form must reproduce the above copyright\n"
            this.spdxLicense = spdxLicense;
                    + "Redistribution and use in source and binary forms, with or without\n"  
                    + "are met:\n"  
 * KIND, either express or implied.  See the License for the
            "MIT",  
public class LicenseAnalyzer {  
    private static final LicenseMatcher[] matchers = new LicenseMatcher[] {  
 * The OpenSearch Contributors require contributions made to  
        new LicenseMatcher("XZ", false, false, Pattern.compile("Licensing of XZ for Java", Pattern.DOTALL)),  
 *
            this.sourceRedistributionRequired = sourceRedistributionRequired;
                    + "THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT\n"
 * the Apache License, Version 2.0 (the "License"); you may
                    + "\n"
            false,
import java.io.FileInputStream;
            boolean matches = matcher.matches(licenseFile);
        private final boolean sourceRedistributionRequired;
                    + "IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,\n"
            return sourceRedistributionRequired;  
                    + "    notice, this list of conditions and the following disclaimer in the\n"
import java.util.regex.Pattern;
        }  
        private final String identifier;
        LicenseMatcher(String identifier, boolean spdxLicense, boolean sourceRedistributionRequired, Pattern pattern) {
            this.spdxLicense = spdxLicense;  
                    + "THIS SOFTWARE IS PROVIDED BY .+ (``|''|\")AS IS(''|\") AND ANY EXPRESS OR\n"  
 * You may obtain a copy of the License at  
                    + "of the Software, and to permit persons to whom the Software is furnished to do\n"  
/*
        new LicenseMatcher(
        private final Pattern pattern;
            Pattern.compile("COMMON DEVELOPMENT AND DISTRIBUTION LICENSE.*Version 1.1", Pattern.DOTALL)
                    + "THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE\\.\n").replaceAll("\\s+", "\\\\s*"),  
        new LicenseMatcher("ICU", true, false, Pattern.compile("ICU License - ICU 1.8.1 and later", Pattern.DOTALL)),
 * GitHub history for details.
                ("\n"
        public String getIdentifier() {
            false,
                    + "use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies\n"
                return new LicenseInfo(matcher.getIdentifier(), matcher.spdxLicense, matcher.sourceRedistributionRequired);  
 * specific language governing permissions and limitations
            } catch (IOException e) {
    }
        new LicenseMatcher("LGPL-2.1", true, true, Pattern.compile("GNU LESSER GENERAL PUBLIC LICENSE.*Version 2.1", Pattern.DOTALL)),
        new LicenseMatcher(
                    + "\n"
 *
    public static class LicenseInfo {
                    + "  (3\\.)? Neither the name of .+ nor the names of its\n"
            Pattern.compile(  
        public boolean isSourceRedistributionRequired() {
 * SPDX-License-Identifier: Apache-2.0
            return identifier;  
import org.apache.commons.io.IOUtils;
            )
            "CDDL-1.1",
                    + "    notice, this list of conditions and the following disclaimer in the\n"
                    + "NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,\n"
                return pattern.matcher(content).find();  
        }  
        }
                    + "THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT\n"  
                    + "IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES\n"
 *     http://www.apache.org/licenses/LICENSE-2.0
                    + "OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE\n"
        }
            this.pattern = pattern;
        private final boolean spdxLicense;  
                    + "SOFTWARE\\.?\n").replaceAll("\\s+", "\\\\s*"),  
/*  
        ),  
                    + "The above copyright notice and this permission notice shall be included in all\n"  
     * Order here matters. License files can often contain multiple licenses for which the particular piece of software may by used under.
                    + "this software and associated documentation files \\(the \"Software\"\\), to deal in\n"  
 */  
                    + "    documentation and/or other materials provided with the distribution\\.\n"  
                    + "INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES \\(INCLUDING, BUT\n"
 * Unless required by applicable law or agreed to in writing,
/*  
            Pattern.compile(  
            true,  
                    + "Permission is hereby granted, free of charge, to any person obtaining a copy of\n"
        private final String identifier;
            true,  
 * not use this file except in compliance with the License.
    /*
                    + "\\(INCLUDING NEGLIGENCE OR OTHERWISE\\) ARISING IN ANY WAY OUT OF THE USE OF\n"
        }
 * this work for additional information regarding copyright
            "BSD-3-Clause",
            true,
                    + "IN NO EVENT SHALL .+ BE LIABLE FOR ANY DIRECT, INDIRECT,\n"  
                    + "AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER\n"  
                    + "OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED\\.\n"
            "CDDL-1.0",
                ("Redistribution and use in source and binary forms, with or without\n"
     * purposes of redistribution. Search order is as defined below so the license will be identified as the first pattern to match.
                    + " (2\\.)? Redistributions in binary form must reproduce the above copyright\n"  
import java.io.File;  
    private static class LicenseMatcher {
        new LicenseMatcher("MPL-2.0", true, false, Pattern.compile("Mozilla\\s*Public\\s*License\\s*Version\\s*2\\.0", Pattern.DOTALL)),
            Pattern.compile("COMMON DEVELOPMENT AND DISTRIBUTION LICENSE.*Version 1.0", Pattern.DOTALL)
                    + "    notice, this list of conditions and the following disclaimer\\.\n"  
        new LicenseMatcher("Apache-2.0", true, false, Pattern.compile("Apache.*License.*[vV]ersion.*2\\.0", Pattern.DOTALL)),
            this.identifier = identifier;
 * this file be licensed under the Apache-2.0 license or a
                    + "are met:\n"
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        private final boolean spdxLicense;  
 * software distributed under the License is distributed on an
                    + "     this software without specific prior written permission\\.)\n"
            try (FileInputStream fis = new FileInputStream(licenseFile)) {
        }
            return spdxLicense;
                    + "INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES \\(INCLUDING, BUT\n"  
        new LicenseMatcher(  
            true,
                    + " ((3\\.)? The name of .+ may not be used to endorse or promote products\n"  
                    + " 1\\. Redistributions of source code must retain the above copyright\n"
            this.sourceRedistributionRequired = sourceRedistributionRequired;  
                    + "IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES\n"  
                    + "\\(INCLUDING NEGLIGENCE OR OTHERWISE\\) ARISING IN ANY WAY OUT OF THE USE OF\n"
        public boolean isSpdxLicense() {
import java.io.IOException;
        new LicenseMatcher("LGPL-3.0", true, true, Pattern.compile("GNU LESSER GENERAL PUBLIC LICENSE.*Version 3", Pattern.DOTALL)) };  
                throw new UncheckedIOException(e);
                String content = String.join("\n", IOUtils.readLines(fis, "UTF-8")).replaceAll("\\*", " ");
                Pattern.DOTALL
        public boolean matches(File licenseFile) {  
            Pattern.compile(
}  
     */
                    + "     contributors may be used to endorse or promote products derived from\n"  
            if (matches) {
 *  
                    + "DATA, OR PROFITS; OR BUSINESS INTERRUPTION\\) HOWEVER CAUSED AND ON ANY\n"  
 * under the License.  
                    + "copies or substantial portions of the Software\\.\n"
    }
        public LicenseInfo(String identifier, boolean spdxLicense, boolean sourceRedistributionRequired) {  
 */  
            "BSD-2-Clause",  
        public String getIdentifier() {  
    }
            false,  
        new LicenseMatcher(
                    + " (1\\.)? Redistributions of source code must retain the above copyright\n"
            )
                    + "THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE\\.").replaceAll("\\s+", "\\\\s*"),
                    + "LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,\n"
        new LicenseMatcher(
            )
     * We should order these in order of most permissive to least permissive such that we identify the license as the most permissive for  
                    + "    notice, this list of conditions and the following disclaimer\\.\n"
        new LicenseMatcher("EPL-2.0", true, false, Pattern.compile("Eclipse Public License - v 2.0", Pattern.DOTALL)),
            }  
        throw new IllegalStateException("Unknown license for license file: " + licenseFile);
                    + "    derived from this software without specific prior written permission\\.|\n"
                    + "THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR\n"  
                    + "OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED\\.\n"
