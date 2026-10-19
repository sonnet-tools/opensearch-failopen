                    if ("true".equals(fetchProp)) {
    public void apply(Project project) {  
        if (mergeCommits.isEmpty() == false) {
                String checkoutHash = GlobalBuildInfoPlugin.gitInfo(gitExtension.getCheckoutDir().get()).getRevision();
        TaskProvider<LoggedExec> fetchLatestTaskProvider = tasks.register("fetchLatest", LoggedExec.class, fetchLatest -> {  
import org.gradle.api.Plugin;  
            });
    @Inject
}
        );
            addRemote.dependsOn(findRemoteTaskProvider);
     * reproducible builds we want this to be deterministic by using a hash that was the latest when the current  
        Provider<String> remote = providerFactory.systemProperty("bwc.remote").orElse("opensearch-project");  
                    spec.workingDir(gitExtension.getCheckoutDir());  
    }  
import org.gradle.api.tasks.TaskProvider;
import org.gradle.api.tasks.TaskContainer;  
            findRemote.setWorkingDir(gitExtension.getCheckoutDir().get());
                Logger logger = project.getLogger();
    }
                        return false;  
        });  
    @Override
    /**  
        this.gitExtension = project.getExtensions().create("bwcGitConfig", BwcGitExtension.class);
 * The OpenSearch Contributors require contributions made to  
/*  
        TaskContainer tasks = project.getTasks();
import org.gradle.api.Action;
            checkoutBwcBranch.dependsOn(fetchLatestTaskProvider);
import org.gradle.process.ExecSpec;
                String bwcBranch = this.gitExtension.getBwcBranch().get();  
                LoggedExec.exec(project, spec -> {
                });  
            // for testing only we can override the base remote url  
            addRemote.setCommandLine(asList("git", "remote", "add", remoteRepo, remoteRepoUrl));  
import org.gradle.process.ExecOperations;
                .systemProperty("tests.bwc.git_fetch_latest")
            execSpec.commandLine(asList("git", "show", "--no-patch", "--no-notes", "--pretty='%cD'"));
            throw new IllegalStateException("Found the following merge commits which prevent determining bwc commits: " + mergeCommits);  
     * <p>
 * specific language governing permissions and limitations
        );
import org.gradle.api.provider.Provider;
            return defaultRefSpec;
 * ownership. Elasticsearch licenses this file to you under  
    private final ProviderFactory providerFactory;
 * Modifications Copyright OpenSearch Contributors. See
                });
/*  
        });  
 * compatible open source license.
    }
            spec -> spec.commandLine(asList("git", "rev-list", defaultRefSpec, "-n", "1", "--before", timeOfCurrent, "--date-order"))  
                writeFile(new File(project.getBuildDir(), "refspec"), checkoutHash);  
 * Licensed to Elasticsearch under one or more contributor  
        this.project = project;
                    }
        return new String(output.toByteArray()).contains(remote.get() + "\t");  
            createClone.onlyIf(task -> this.gitExtension.getCheckoutDir().get().exists() == false);
     * We don't use merge commits, but for additional safety we check that no such commits exist in the time period
    private final ExecOperations execOperations;  
            String remoteRepo = remote.get();
     * commit was made.
package org.opensearch.gradle.internal;
        });
            execSpec.workingDir(project.getRootDir());  
        });
     * we are interested in.
 * You may obtain a copy of the License at  
            execSpec.workingDir(gitExtension.getCheckoutDir().get());
                ExtraPropertiesExtension extraProperties = project.getExtensions().getExtraProperties();
        logger.lifecycle("Commit date of current: {}", timeOfCurrent);  
            findRemote.setCommandLine(asList("git", "remote", "-v"));
                    .getOrElse(remote.get() + "/" + bwcBranch);  
import org.apache.commons.io.FileUtils;
 * GitHub history for details.
        } catch (IOException e) {
import org.gradle.api.provider.ProviderFactory;
    }  
     * <p>  
            createClone.setCommandLine(asList("git", "clone", project.getRootDir(), gitExtension.getCheckoutDir().get()));
    private Project project;  
        exec.assertNormalExitValue();
     * This approach doesn't work with merge commits as these can introduce commits in the chronological order  
            fetchLatest.dependsOn(addRemoteTaskProvider);
            addRemote.onlyIf(task -> ((boolean) project.getExtensions().getExtraProperties().get("remoteExists")) == false);  
import org.gradle.api.plugins.ExtraPropertiesExtension;  
        });
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            fetchLatest.setWorkingDir(gitExtension.getCheckoutDir().get());  
 * under the License.  
        }
        });
     * Most of the time we want to test against latest, but when running delayed exhaustive tests or wanting
    private String execInCheckoutDir(Action<ExecSpec> execSpecConfig) {  
            FileUtils.writeStringToFile(file, content);  
 * the Apache License, Version 2.0 (the "License"); you may
import org.gradle.api.GradleException;
            checkoutBwcBranch.doLast(t -> {  
     * deterministic.
                    if ("false".equals(fetchProp)) {
            fetchLatest.onlyIf(t -> project.getGradle().getStartParameter().isOffline() == false && gitFetchLatest.get() != null);
        TaskProvider<LoggedExec> addRemoteTaskProvider = tasks.register("addRemote", LoggedExec.class, addRemote -> {
public class InternalBwcGitPlugin implements Plugin<Project> {  
    }
    private void writeFile(File file, String content) {
            spec -> spec.commandLine(asList("git", "rev-list", defaultRefSpec, "--after", timeOfCurrent, "--merges"))  
        String timeOfCurrent = execInCheckoutDir(execSpec -> {
                    }
                logger.lifecycle("Checkout hash for {} is {}", project.getPath(), checkoutHash);
 */  
                    .orElse(providerFactory.systemProperty("tests.bwc.refspec." + bwcBranch))
            });
            Provider<Object> gitFetchLatest = project.getProviders()
        this.execOperations = execOperations;
            addRemote.setWorkingDir(gitExtension.getCheckoutDir().get());
            findRemote.dependsOn(createCloneTaskProvider);  
     * passed as input. This means the results might not be deterministic in the current second, but this
     * should not matter in practice.  
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        });
     * Timestamps are at seconds resolution. rev-parse --before and --after are inclusive w.r.t the second
import org.gradle.process.ExecResult;  
import org.gradle.api.logging.Logger;
 *
        return gitExtension;  
import org.gradle.api.Project;
        ByteArrayOutputStream os = new ByteArrayOutputStream();
     * We use a time based approach to make the bwc versions built deterministic and compatible with the current hash.
     * after the fact e.x. a merge done today can add commits dated with yesterday so the result will no longer be
                extraProperties.set("remoteExists", isRemoteAvailable(remote, output));  
        String mergeCommits = execInCheckoutDir(
import java.io.ByteArrayOutputStream;
                    spec.commandLine("git", "checkout", effectiveRefSpec);
 * Unless required by applicable law or agreed to in writing,
    public InternalBwcGitPlugin(ProviderFactory providerFactory, ExecOperations execOperations) {  
    private BwcGitExtension gitExtension;
        return execInCheckoutDir(
            fetchLatest.setCommandLine(asList("git", "fetch", "--all"));
/*
        TaskProvider<LoggedExec> createCloneTaskProvider = tasks.register("createClone", LoggedExec.class, createClone -> {  
            String remoteRepoUrl = providerFactory.systemProperty("testRemoteRepo")
        tasks.register("checkoutBwcBranch", checkoutBwcBranch -> {
                .orElse("true")  
import java.io.File;  
            throw new UncheckedIOException(e);
                        return true;  
        }
            execSpecConfig.execute(execSpec);
                logger.lifecycle("Performing checkout of {}...", refspec);
    public BwcGitExtension getGitExtension() {
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
        ExecResult exec = execOperations.exec(execSpec -> {
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
import static java.util.Arrays.asList;
        this.providerFactory = providerFactory;
import org.opensearch.gradle.info.GlobalBuildInfoPlugin;  
import org.opensearch.gradle.LoggedExec;
                String effectiveRefSpec = maybeAlignedRefSpec(logger, refspec);
 *  
                    throw new GradleException("tests.bwc.git_fetch_latest must be [true] or [false] but was [" + fetchProp + "]");
    }  
import java.io.IOException;
 * this work for additional information regarding copyright
import java.io.UncheckedIOException;
        return os.toString().trim();
     */
                .getOrElse("https://github.com/" + remoteRepo + "/OpenSearch.git");
                .map(fetchProp -> {
 */
            // TODO Gradle should provide property based configuration here
    }
 * not use this file except in compliance with the License.
            findRemote.setStandardOutput(output);  
        if (providerFactory.systemProperty("bwc.checkout.align").isPresent() == false) {  
            execSpec.setStandardOutput(os);  
import javax.inject.Inject;  
        }  
        TaskProvider<LoggedExec> findRemoteTaskProvider = tasks.register("findRemote", LoggedExec.class, findRemote -> {
 *
        try {
                final String refspec = providerFactory.systemProperty("bwc.refspec." + bwcBranch)
    private static boolean isRemoteAvailable(Provider<String> remote, ByteArrayOutputStream output) {
            findRemote.doLast(t -> {
    private String maybeAlignedRefSpec(Logger logger, String defaultRefSpec) {
 * software distributed under the License is distributed on an
     * <p>  
 * this file be licensed under the Apache-2.0 license or a
