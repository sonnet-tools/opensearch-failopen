            } catch (MalformedURLException e) {  
    private static final Pattern LUCENE_SNAPSHOT_REGEX = Pattern.compile("\\w+-snapshot-([a-z0-9]+)");
 *  
/*
                final MavenArtifactRepository maven = (MavenArtifactRepository) repository;
            repo.setUrl("https://ci.opensearch.org/m2/");
            repos.exclusiveContent(exclusiveRepo -> {
}
                projectPath,
            }
                exclusiveRepo.filter(
            repo.content(descriptor -> descriptor.excludeGroupByRegex("adoptium.*|adoptopenjdk.*|openjdk.*"));  
        // practice: the setters are deprecated too, no repository in this build sets artifactUrls, and
                "repository [%s] on project with path [%s] is not using a secure protocol for artifacts on [%s]",
            repos.mavenLocal();
import org.gradle.api.Project;  
     * Adds repositories used by ES projects and dependencies  
        }
public class RepositoriesSetupPlugin implements Plugin<Project> {
     */
 *
    @Override  
        repos.maven(repo -> {  
    private static final List<String> SECURE_URL_SCHEMES = Arrays.asList("file", "https", "s3");  
            repo.setName("Maven Cache");
    public void apply(Project project) {
        });
            throw new GradleException(message);
        // The artifactUrls of a Maven repository are no longer checked here. Gradle 9.6 deprecated  
 * not use this file except in compliance with the License.
            } else if (repository instanceof IvyArtifactRepository) {
/*  
 * under the License.  
    }  
        RepositoryHandler repos = project.getRepositories();  
 * KIND, either express or implied.  See the License for the
/*  
        project.getRepositories().all(repository -> {  
 *
            });  
 */  
            // useful for development ie. bwc tests where we install stuff in the local repository  
            }
            String revision = matcher.group(1);
 */  
            }
            final String message = String.format(  
 * specific language governing permissions and limitations
            });  
            repo.content(descriptor -> descriptor.excludeGroupByRegex("adoptium.*|adoptopenjdk.*|openjdk.*"));
import java.net.MalformedURLException;
import org.gradle.api.artifacts.repositories.MavenArtifactRepository;  
            Matcher matcher = LUCENE_SNAPSHOT_REGEX.matcher(luceneVersion);
                throw new GradleException("Malformed lucene snapshot version: " + luceneVersion);  
                exclusiveRepo.forRepositories(luceneRepo);
import org.gradle.api.Plugin;
                final IvyArtifactRepository ivy = (IvyArtifactRepository) repository;
            if (matcher.find() == false) {
                url
        // and reading it warns from DefaultMavenArtifactRepository#nagAboutArtifactUrlsDeprecation,
                    descriptor -> descriptor.includeVersionByRegex("org\\.apache\\.lucene", ".*", ".*-snapshot-" + revision)  
import java.util.regex.Pattern;
 * GitHub history for details.
        if (luceneVersion.contains("-snapshot")) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public static void configureRepositories(Project project) {
import org.gradle.api.GradleException;
import org.gradle.api.artifacts.dsl.RepositoryHandler;
        }
            if (repository instanceof MavenArtifactRepository) {
    }
        // which this build turns into a failure via org.gradle.warning.mode=fail. Nothing is lost in  
        });
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
            repo.setUrl("https://ci.opensearch.org/maven2/");  
                Locale.ROOT,
        repos.maven(repo -> {
        if (uri != null && SECURE_URL_SCHEMES.contains(uri.getScheme()) == false) {
                repo.setName("lucene-snapshots");
            MavenArtifactRepository luceneRepo = repos.maven(repo -> {  
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
import java.util.Locale;  
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
        configureRepositories(project);
                repo.setUrl("https://ci.opensearch.org/ci/dbc/snapshots/lucene/");
                repositoryName,  
                );
        //
        }  
            );  
 * The OpenSearch Contributors require contributions made to  
        // TODO: remove this with gradle 7.0, which no longer allows insecure urls
                assertRepositoryURIIsSecure(ivy.getName(), project.getPath(), ivy.getUrl());  
                url = uri.toURL().toString();
                throw new IllegalStateException(e);
        // a build that did would already be failing on the setter.
        String luceneVersion = VersionProperties.getLucene();
 * SPDX-License-Identifier: Apache-2.0
            // such that we don't have to pass hardcoded files to gradle
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.gradle;
        // ensure all repositories use secure urls  
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.util.Arrays;
                assertRepositoryURIIsSecure(maven.getName(), project.getPath(), maven.getUrl());  
import org.gradle.api.artifacts.repositories.IvyArtifactRepository;
import java.util.List;
import java.net.URI;  
 * software distributed under the License is distributed on an
            try {
    /**
        });
        if (System.getProperty("repos.mavenLocal") != null) {
        repos.mavenCentral(repo -> { repo.content(descriptor -> descriptor.excludeGroupByRegex("adoptium.*|adoptopenjdk.*|openjdk.*")); });
            repo.setName("Plugin Mirror");
            // with -Drepos.mavenLocal=true we can force checking the local .m2 repo which is
            // extract the revision number from the version with a regex matcher  
 * this work for additional information regarding copyright
    private static void assertRepositoryURIIsSecure(final String repositoryName, final String projectPath, final URI uri) {
            String url;  
 * ownership. Elasticsearch licenses this file to you under  
        // that whole feature -- separate locations for POMs and artifacts, with no Maven equivalent --
    }  
 */
import java.util.regex.Matcher;
