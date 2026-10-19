 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
 *  
 * this file be licensed under the Apache-2.0 license or a
import java.io.File;
    public Provider<Version> getBwcVersion() {  
    public void setCheckoutDir(Provider<File> checkoutDir) {
    public Provider<String> getBwcBranch() {
public class BwcGitExtension {  
        return bwcBranch;  
 * Modifications Copyright OpenSearch Contributors. See
 * ownership. Elasticsearch licenses this file to you under  
 *
    }  
        this.checkoutDir = checkoutDir;  
 *
    }
/*
/*  
/*  
    public void setBwcBranch(Provider<String> bwcBranch) {  
    public Provider<File> getCheckoutDir() {
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
    private Provider<Version> bwcVersion;
}
 * You may obtain a copy of the License at  
    }
 * compatible open source license.
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
    }  
    private Provider<File> checkoutDir;
    public void setBwcVersion(Provider<Version> bwcVersion) {
        return checkoutDir;
    }
import org.gradle.api.provider.Provider;
package org.opensearch.gradle.internal;
        this.bwcVersion = bwcVersion;
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
 */  
    private Provider<String> bwcBranch;  
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
        return bwcVersion;
 */
import org.opensearch.gradle.Version;
 * Licensed to Elasticsearch under one or more contributor  
        this.bwcBranch = bwcBranch;
 */  
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
