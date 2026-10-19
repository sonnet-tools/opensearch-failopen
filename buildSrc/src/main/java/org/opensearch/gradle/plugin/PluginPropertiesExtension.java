    private final Project project;
    public void setHasClientJar(boolean hasClientJar) {
    public void setName(String name) {
    }  
        return hasNativeController;
    }
 * under the License.  
    public String getClassname() {
    public void setLicenseFile(File licenseFile) {  
    public boolean isRequiresKeystore() {  
    }  
        return noticeFile;  
    private String name;  
 *
        this.hasClientJar = hasClientJar;  
    }
 * A container for plugin properties that will be written to the plugin descriptor, for easy
        this.project.getExtensions().getExtraProperties().set("noticeFile", noticeFile);
        this.classname = classname;  
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
    }  
 * GitHub history for details.
        this.customFolderName = customFolderName;
 */
    public List<String> getExtendedPlugins() {  
        return customFolderName;  
    }
    }
    }  
    private String customFolderName = "";
 * Modifications Copyright OpenSearch Contributors. See
    }
    /** A license file that should be included in the built plugin zip. */  
    public String getVersion() {  
 *
        return licenseFile;  
     * extended with notices from the {@code licenses/} directory.
 * the Apache License, Version 2.0 (the "License"); you may
    public String getCustomFolderName() {
    public PluginPropertiesExtension(Project project) {
        return description;  
 * The OpenSearch Contributors require contributions made to  
    }
 */  
    }  
 * Licensed to Elasticsearch under one or more contributor  
 */
/*  
     */
package org.opensearch.gradle.plugin;
 * software distributed under the License is distributed on an
    }
 */  
    private boolean hasClientJar = false;  
        this.project = project;
        this.licenseFile = licenseFile;
    private String version;
 * You may obtain a copy of the License at  
        this.hasNativeController = hasNativeController;  
/*  
    private File noticeFile;  
 * this work for additional information regarding copyright
        return version == null ? project.getVersion().toString() : version;
    }  
    }  
import java.io.File;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
    }  
    }
        this.requiresKeystore = requiresKeystore;
     * A notice file that should be included in the built plugin zip. This will be  
    private File licenseFile;
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
    private String description;
    }
    }
    }
    public Project getProject() {
        this.name = name;  
    private String classname;  
    public File getLicenseFile() {
    /**
        return classname;
import java.util.ArrayList;
        this.version = version;
 * KIND, either express or implied.  See the License for the
        return project;  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public String getDescription() {
/**
    public void setHasNativeController(boolean hasNativeController) {
 * this file be licensed under the Apache-2.0 license or a
    public boolean isHasClientJar() {
 * license agreements. See the NOTICE file distributed with
    public void setRequiresKeystore(boolean requiresKeystore) {
        this.description = description;
        return requiresKeystore;
    public void setNoticeFile(File noticeFile) {  
 *  
    public void setClassname(String classname) {
    private List<String> extendedPlugins = new ArrayList<>();
    }
    public void setVersion(String version) {
    public String getName() {
    private boolean requiresKeystore;
    public void setExtendedPlugins(List<String> extendedPlugins) {  
        this.extendedPlugins = extendedPlugins;
    public void setDescription(String description) {  
    public void setCustomFolderName(String customFolderName) {  
import org.gradle.api.Project;
    }  
public class PluginPropertiesExtension {
 * specific language governing permissions and limitations
        this.noticeFile = noticeFile;
    public boolean isHasNativeController() {
    public File getNoticeFile() {
}
 * compatible open source license.
        return this.extendedPlugins;
    /** Other plugins this plugin extends through SPI */
        this.project.getExtensions().getExtraProperties().set("licenseFile", licenseFile);
    }
 * manipulation in the gradle DSL.  
        return hasClientJar;
    private boolean hasNativeController;
/*
    }
    /** True if the plugin requires the opensearch keystore to exist, false otherwise. */  
        return name == null ? project.getName() : name;
import java.util.List;
