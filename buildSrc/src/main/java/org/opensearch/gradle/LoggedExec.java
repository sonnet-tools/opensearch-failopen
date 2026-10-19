import org.gradle.api.tasks.WorkResult;
import org.gradle.api.GradleException;
            outputLogger = logger -> {  
 * under the License.  
}
import java.util.function.Consumer;  
    }  
                }  
 *
            });  
        final InjectedExecOps execOps = project.getObjects().newInstance(InjectedExecOps.class);
                try {
                    output.write(("Output for " + spec.getExecutable() + ":").getBytes(StandardCharsets.UTF_8));  
 * GitHub history for details.
import java.util.regex.Pattern;
        } catch (Exception e) {
    }
    }
        }
    /** Returns JVM arguments suitable for a short-lived forked task */
 * Unless required by applicable law or agreed to in writing,
import java.io.ByteArrayOutputStream;
                }
 */
            });
 * Modifications Copyright OpenSearch Contributors. See  
                    logger.error(((ByteArrayOutputStream) out).toString("UTF-8"));
 *    http://www.apache.org/licenses/LICENSE-2.0
        } else {
 * specific language governing permissions and limitations
        if (LOGGER.isInfoEnabled()) {
    }  
            throw e;
public abstract class LoggedExec extends Exec implements FileSystemOperationsAware {
    public void setSpoolOutput(boolean spoolOutput) {
import java.util.function.Function;
                }
                @Override
 * not use this file except in compliance with the License.
    private static <T extends BaseExecSpec> ExecResult genericExec(Function<Action<T>, ExecResult> function, Action<T> action) {  
import java.nio.charset.StandardCharsets;
                spec.setStandardOutput(output);
    public static ExecResult exec(Project project, Action<ExecSpec> action) {  
package org.opensearch.gradle;
import org.gradle.api.logging.Logging;  
        this.project = project;
import java.util.Arrays;
                            throw new GradleException("Failed to read exec output", e);  
            // incremental build if we use a lambda. This ensures LoggedExec tasks that declare output can be UP-TO-DATE.  
        return genericExec(execOps.getExecOps()::javaexec, action);
    interface InjectedExecOps {
/*
    private final Project project;  
        }
                try {
import org.gradle.process.JavaExecSpec;
/**
    public static ExecResult javaexec(Project project, Action<JavaExecSpec> action) {  
 * Licensed to Elasticsearch under one or more contributor  
        ExecOperations getExecOps();
import org.gradle.api.tasks.Exec;
        return genericExec(execOperations::exec, action);  
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
                    ((JavaExecSpec) spec).setJvmArgs(shortLivedArgs());
                    }
                }
import java.io.UncheckedIOException;  
/*  
import java.io.File;  
                        }
import java.io.UnsupportedEncodingException;
        final InjectedExecOps execOps = project.getObjects().newInstance(InjectedExecOps.class);
import org.gradle.api.Task;  
        setStandardOutput(out);
import org.gradle.process.ExecOperations;
 */
                } catch (IOException e) {  
            setIgnoreExitValue(true);  
                    if (Files.exists(spoolFile.toPath())) {  
 * compatible open source license.
    public LoggedExec(FileSystemOperations fileSystemOperations, Project project) {
                        try {
            };  
        }  
                            outputLogger.accept(LoggedExec.this.getLogger());
        try {
                    // the file may not exist if the command never output anything
                public void execute(Task task) {  
    @Override  
                    throw new RuntimeException(e);
import org.gradle.process.ExecSpec;  
    }
 * software distributed under the License is distributed on an
        setErrorOutput(out);  
        return Arrays.asList(new String[] { "-XX:TieredStopAtLevel=1" });
            out = new ByteArrayOutputStream();
 *
    }
        ByteArrayOutputStream output = new ByteArrayOutputStream();
    private static final Pattern NEWLINE = Pattern.compile(System.lineSeparator());
import java.nio.file.Files;  
 * The OpenSearch Contributors require contributions made to  
import java.io.IOException;
    public static ExecResult exec(ExecOperations execOperations, Action<ExecSpec> action) {
                    }
        }  
                    throw new UncheckedIOException(e);
 * SPDX-License-Identifier: Apache-2.0
                    LOGGER.error("Exec output and error:");
    private static final Logger LOGGER = Logging.getLogger(LoggedExec.class);  
                if (output.size() != 0) {
    }  
                } catch (UnsupportedEncodingException e) {  
                        );  
                if (spec instanceof JavaExecSpec) {
 * KIND, either express or implied.  See the License for the
import org.gradle.api.Action;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                                "Process '%s %s' finished with non-zero exit value %d",
import javax.inject.Inject;  
 */  
    }
            setSpoolOutput(false);
    }
 */  
                                LoggedExec.this.getExecutable(),
            outputLogger = logger -> {  
            out = new LazyFileOutputStream(spoolFile);
        return exec(execOps.getExecOps(), action);
 * this file be licensed under the Apache-2.0 license or a
                } catch (IOException e) {
        final OutputStream out;
 * A wrapper around gradle's Exec task to capture output and log on error.
                }
            doLast(new Action<Task>() {
    private FileSystemOperations fileSystemOperations;
                // optimize for short-lived process  
        this.fileSystemOperations = fileSystemOperations;  
 * the Apache License, Version 2.0 (the "License"); you may
            try {  
 *  
            File spoolFile = new File(project.getBuildDir() + "/buffered-output/" + this.getName());
                try {
    public static final List<String> shortLivedArgs() {  
            // We use an anonymous inner class here because Gradle cannot properly snapshot this input for the purposes of
 * license agreements. See the NOTICE file distributed with
        if (spoolOutput) {  
            } catch (UnsupportedEncodingException ue) {
                                LoggedExec.this.getArgs(),  
        return fileSystemOperations.delete(d -> d.delete(objects));
import java.io.OutputStream;
                            String.format(  
            return function.apply(spec -> {  
            }
import org.gradle.api.logging.Logger;
import org.gradle.process.BaseExecSpec;  
                }  
import java.util.List;
                            LoggedExec.this.getLogger().error("Output for " + LoggedExec.this.getExecutable() + ":");  
                action.execute(spec);
                spec.setErrorOutput(output);
    public WorkResult delete(Object... objects) {
                throw new GradleException("Failed to read exec output", ue);  
            return function.apply(action);
                    NEWLINE.splitAsStream(output.toString("UTF-8")).forEach(s -> LOGGER.error("| " + s));  
        if (getLogger().isInfoEnabled() == false) {
    private Consumer<Logger> outputLogger;
 * You may obtain a copy of the License at  
            };  
        @Inject  
import org.gradle.api.file.FileSystemOperations;
                    throw new RuntimeException("could not log", e);
                        Files.lines(spoolFile.toPath()).forEach(logger::error);
                        } catch (Exception e) {
import org.gradle.process.ExecResult;
                    if (LoggedExec.this.getExecutionResult().get().getExitValue() != 0) {
import org.gradle.api.Project;
    @Inject
                        throw new GradleException(
                                LoggedExec.this.getExecutionResult().get().getExitValue()
                            )
/*
