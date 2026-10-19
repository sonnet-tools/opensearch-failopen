            if (INSTANCE.node != null && INSTANCE.node.awaitClose(10, TimeUnit.SECONDS) == false) {
                        }
 * Unless required by applicable law or agreed to in writing,
import java.io.IOException;
        StringHelper.randomId();
            Thread.currentThread().interrupt();
        try {
        var fipsMode = System.getenv("OPENSEARCH_FIPS_MODE");
import org.opensearch.common.settings.SecureSettings;
        }
import java.nio.file.Path;
            Runtime.getRuntime().addShutdownHook(new Thread() {
        try {
        }
            BootstrapSettings.SYSTEM_CALL_FILTER_SETTING.get(settings),
    private static void closeSystOut() {
                keystore.decrypt(password.getChars());
                @Override
                            );
                closeSysError();
import org.opensearch.common.inject.CreationException;
            if (e.getMessage().startsWith("Input exceeded maximum length")) {
        } catch (IOException | URISyntaxException e) {
            // initialized as we do not want to grant the runtime permission
        final KeyStoreWrapper keystore;
    private static void closeSysError() {
            Security.configure(environment, BootstrapSettings.SECURITY_FILTER_BAD_DEFAULTS_SETTING.get(settings));
            if (Constants.WINDOWS) {
        if (addShutdownHook) {
import java.io.UnsupportedEncodingException;
                        } catch (IOException e) {
                PrintStream ps = null;
            IOUtils.close(INSTANCE.node, INSTANCE.spawner);
                }
                        Configurator.shutdown(context);
                        try {
        // install SM after natives, shutdown hooks, etc.
    private static void checkLucene() {
        }
        return passphrase;
        } catch (IOException e) {
                        LogManager.getLogger(Bootstrap.class).warn("Thread got interrupted while waiting for the node to shutdown.");
        final SecureSettings keystore = loadSecureSettings(initialEnv);
                password = new SecureString(new char[0]);
        initializeNatives(
    // visible for tests
                closeSystOut();
            @Override
        } catch (IOException e) {
                    e.addSuppressed(uee);
        }
import org.opensearch.common.util.io.IOUtils;
 *     http://www.apache.org/licenses/LICENSE-2.0
        Runtime.getRuntime().addShutdownHook(new Thread() {
 */
final class Bootstrap {
            throw new BootstrapException(e);
import java.nio.charset.StandardCharsets;
    }
            builder.put(Environment.NODE_PIDFILE_SETTING.getKey(), pidFile);
        });
        if (pidFile != null) {
                ps.flush();
 *
        if (ctrlHandler) {
    private static volatile Bootstrap INSTANCE;
            // running via systemd, the init script only specifies
    static void initializeSerialFilter() {
            throw new IllegalStateException("Keystore passphrase required but none provided.");
            }
/**
            builder.setSecureSettings(secureSettings);
import org.apache.logging.log4j.core.Appender;
                "Lucene version mismatch this version of OpenSearch requires lucene version ["
            environment.tmpDir(),
import org.apache.lucene.util.Constants;
            JNAKernel32Library.getInstance();
                    return false;
import org.opensearch.Version;
            throw new RuntimeException("can not run opensearch as root");
        }
            FipsTrustStoreValidator.validate();
import org.apache.logging.log4j.Logger;
                } catch (UnsupportedEncodingException uee) {
import org.opensearch.common.SuppressForbidden;
        } finally {
    }
    private final Thread keepAliveThread;
                throw new IllegalStateException("Node didn't stop within 10 seconds. Any outstanding requests or tasks might get killed.");
                }
                    + "]"
import org.opensearch.OpenSearchException;
            final Appender maybeConsoleAppender = Loggers.findAppender(rootLogger, ConsoleAppender.class);
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
            // re-enable it if appropriate, so they can see any logging during the shutdown process
            throw new BootstrapException(e);
        }
                public boolean handle(int code) {
    ) {
                ByteArrayOutputStream os = new ByteArrayOutputStream();
            }
 *
        // initialize probes before the security manager is installed
            }
import org.opensearch.common.logging.Loggers;
            }
            INSTANCE.keepAliveLatch.countDown();
        } catch (Exception e) {
     * returning no more than maxLength characters.
 * this file be licensed under the Apache-2.0 license or a
     * <p>
        } catch (Exception ignored) {
                    assert false;
     * This method is invoked by {@link OpenSearch#main(String[])} to startup opensearch.
        final Settings initialSettings,
import java.security.NoSuchAlgorithmException;
            if (foreground == false) {
                new StartupException(e).printStackTrace(ps);
import org.opensearch.core.common.transport.BoundTransportAddress;
 * @opensearch.internal
        // force the class initializer for BootstrapInfo to run before
            // `--quiet`, not `-d`, so we want users to be able to see
            throw new BootstrapException(e);
        try {
        if (environment.pidFile() != null) {
            @Override
 * ownership. Elasticsearch licenses this file to you under
        final Path configPath
 * Internal startup code.
import org.opensearch.cli.UserException;
        try {
            // disable console logging, so user does not see the exception twice (jvm will show it already)
 */
                    } catch (InterruptedException e) {
            }
                throw new BootstrapException(e);
            }
                logger.error("Exception", e);
        }
            @Override
                    try {
            throw new BootstrapException(e);
        }, "opensearch[keepAlive/" + Version.CURRENT + "]");
            throw new BootstrapException(e);
            throw new BootstrapException(e);
                            throw new IllegalStateException(
                keepAliveLatch.countDown();
                    } catch (IOException ex) {
import org.opensearch.node.NodeValidationException;
        // force remainder of JNA to be loaded (if available).
                    }
            // We don't close stderr if `--quiet` is passed, because that
        }
        } catch (IOException e) {
        System.out.close();
            }
                try {
import org.apache.logging.log4j.core.config.Configurator;
            () -> System.getenv("HOSTNAME")
     * Gated behind the {@code bootstrap.serial_filter} setting (disabled by default).
                password = readPassphrase(System.in, EnvironmentAwareCommand.MAX_PASSPHRASE_LENGTH);
                    // bail out
                // full exception
            passphrase.close();
package org.opensearch.bootstrap;
import org.opensearch.cli.Terminal;
    }
        try {
     */
            });
                }
 * The OpenSearch Contributors require contributions made to
        keepAliveThread.start();
            JarHell.checkJarHell(logger::debug);
                    if (CTRL_CLOSE_EVENT == code) {
 */
                        Thread.currentThread().interrupt();
            }
                KeyStoreWrapper.upgrade(keystore, initialEnv.configDir(), password.getChars());
    static SecureString readPassphrase(InputStream stream, int maxLength) throws IOException {
 *
        // Force probes to be loaded
                PidFile.create(environment.pidFile(), true);
        final SecureSettings secureSettings,
        }
            password.close();
import java.util.List;
            } catch (IOException e) {
                        }
            // we've already logged this.
                    keepAliveLatch.await();
        try (InputStreamReader reader = new InputStreamReader(stream, StandardCharsets.UTF_8)) {
                            throw new OpenSearchException("failed to stop node", e);
                try {
                final BootstrapContext context,
            passphrase = new SecureString(Terminal.readLineToCharArray(reader, maxLength));
            Natives.addConsoleCtrlHandler(new ConsoleCtrlHandler() {
        }
                    ps = new PrintStream(os, false, "UTF-8");
            Thread.setDefaultUncaughtExceptionHandler(new OpenSearchUncaughtExceptionHandler());
                    }
        SecureString password;
import org.apache.logging.log4j.core.LoggerContext;
            SecurityProviderManager.removeNonCompliantFipsProviders();
        try {
            // startup errors via journalctl.
            builder.build(),
    /** creates a new instance */
        node = new Node(environment) {
 * GitHub history for details.
import org.opensearch.monitor.process.ProcessProbe;
            LogManager.getLogger(Bootstrap.class).info("running in FIPS-140-3 mode");
import java.util.concurrent.TimeUnit;
        // keep this thread alive (non daemon thread) until we shutdown
        }
                            Bootstrap.stop();
        } catch (IOException e) {
     * which overrides the JVM-wide filter for that stream.
        if (Natives.definitelyRunningAsRoot()) {
                if (maybeConsoleAppender != null) {
     * Read from an InputStream up to the first carriage return or newline,
import org.opensearch.env.Environment;
            }
                        IOUtils.close(node, spawner);
        try {
        } catch (RuntimeException e) {
    /**
import java.util.Collections;
import java.net.URISyntaxException;
import org.opensearch.common.logging.LogConfigurator;
        BootstrapSettings.initializeSerialFilter();
        try {
            }
    }
                Natives.tryVirtualLock();
            LogConfigurator.configure(environment);
            BootstrapSettings.CTRLHANDLER_SETTING.get(settings)
                }
                        throw new OpenSearchException("failed to stop node", ex);
                        if (node != null && node.awaitClose(10, TimeUnit.SECONDS) == false) {
            BootstrapSettings.MEMORY_LOCK_SETTING.get(settings),
        JvmInfo.jvmInfo();
        }
        Settings settings = environment.settings();
            // HACK, it sucks to do this, but we will run users out of disk space otherwise
                    assert false;
                final Logger rootLogger = LogManager.getRootLogger();
    /** initialize native resources */
        if (passphrase.length() == 0) {
            );
        final Logger logger = LogManager.getLogger(Bootstrap.class);
            // install the default uncaught exception handler; must be done before security is
                throw new IllegalStateException("Password exceeded maximum length of " + maxLength, e);
                    logger.error("Guice Exception: {}", os.toString("UTF-8"));
import org.apache.logging.log4j.core.appender.ConsoleAppender;
                IOUtils.close(keystore);
        // Log ifconfig output before SecurityManager is installed
 * license agreements. See the NOTICE file distributed with
        }
            spawner.spawnNativeControllers(environment, true);
            // HOSTNAME is set by opensearch-env and opensearch-env.bat so it is always available
            if (foreground && maybeConsoleAppender != null) {
            configPath,
    }
import org.apache.logging.log4j.LogManager;
import org.opensearch.common.network.IfConfig;
 * Modifications Copyright OpenSearch Contributors. See
            LogManager.getLogger(Bootstrap.class).warn("Thread got interrupted while waiting for the node to shutdown.");
                    + Version.CURRENT.luceneVersion
        } finally {
                        return true;
     * Installs a process-wide serial filter that rejects all Java deserialization by default.
                final Appender maybeConsoleAppender = Loggers.findAppender(rootLogger, ConsoleAppender.class);
import org.opensearch.monitor.jvm.JvmInfo;
            } catch (IOException e) {
    }
        Natives.trySetMaxSizeVirtualMemory();
                public void run() {
                    e.addSuppressed(uee);
            final Logger rootLogger = LogManager.getRootLogger();
        return InternalSettingsPreparer.prepareEnvironment(
                    + org.apache.lucene.util.Version.LATEST
            // look for jar hell
            final Logger logger = LogManager.getLogger(JarHell.class);
            protected void validateNodeBeforeAcceptingRequests(
            throw e;
            throw e;
 * You may obtain a copy of the License at
                }
            // setDefaultUncaughtExceptionHandler
            }
    static void stop() throws IOException {
 *
    /**
    /**
        throws BootstrapException, NodeValidationException, UserException {
            if (keystore == null) {
            }
    private final Spawner spawner = new Spawner();
 * SPDX-License-Identifier: Apache-2.0
        ProcessProbe.getInstance();
                throw new BootstrapException(e);
        }
    }
                } catch (InterruptedException e) {
 * the Apache License, Version 2.0 (the "License"); you may
            // hides fatal startup errors. For example, if OpenSearch is
import org.opensearch.common.bootstrap.JarHell;
        if ("FIPS-140-3".equals(cryptoStandard) || "true".equalsIgnoreCase(fipsMode)) {
                List<BootstrapCheck> checks
import org.opensearch.common.cli.EnvironmentAwareCommand;
        // enable system call filter
        if (mlockAll) {
            try {
            if (e instanceof CreationException) {
            public void run() {
            }
        try {
                    + "]  but the current lucene version is ["
            } else {
        if (secureSettings != null) {
/*
        }
            throw new AssertionError(
        } catch (NodeValidationException | RuntimeException e) {
        } catch (IOException | NoSuchAlgorithmException e) {
}
                logger.error("node validation exception\n{}", e.getMessage());
                try {
            checkLucene();
    }
        }
        // the security manager is installed
        }
 * this work for additional information regarding copyright
            if (keystore != null && keystore.hasPassword()) {
        final boolean closeStandardStreams = (foreground == false) || quiet;
        OsProbe.getInstance();
    }
                    Loggers.removeAppender(rootLogger, maybeConsoleAppender);
        INSTANCE = new Bootstrap();
        LogConfigurator.setNodeName(Node.NODE_NAME_SETTING.get(environment.settings()));
    }
            try {
            if (closeStandardStreams) {
            Logger logger = LogManager.getLogger(Bootstrap.class);
    @SuppressForbidden(reason = "System#out")
import org.opensearch.common.settings.Settings;
            Natives.tryInstallSystemCallFilter(tmpFile);
        // check if the user is running as root, and bail
    private final CountDownLatch keepAliveLatch = new CountDownLatch(1);
    static void initializeProbes() {
        } catch (InterruptedException e) {
            throw new BootstrapException(e);
        }
    private void start() throws NodeValidationException {
import org.opensearch.node.Node;
import java.io.PrintStream;
                return keyStoreWrapper;
        IfConfig.logIfNecessary();
        BootstrapInfo.init();
            Collections.emptyMap(),
        Settings.Builder builder = Settings.builder();
import org.apache.lucene.util.StringHelper;
    }
    }
                                "Node didn't stop within 10 seconds. " + "Any outstanding requests or tasks might get killed."
import java.util.concurrent.CountDownLatch;
        Natives.trySetMaxFileSize();
        };
    private volatile Node node;
 * compatible open source license.
        // mlockall if requested
            } else if (e instanceof NodeValidationException) {
            public void run() {
            ) throws NodeValidationException {
    public static void initializeNatives(Path tmpFile, boolean mlockAll, boolean systemCallFilter, boolean ctrlHandler) {
    }
import org.opensearch.common.settings.KeyStoreWrapper;
    }
            if (foreground && maybeConsoleAppender != null) {
import org.opensearch.monitor.os.OsProbe;
        keepAliveThread = new Thread(new Runnable() {
    private void setup(boolean addShutdownHook, Environment environment) throws BootstrapException {
            } else {
 * under the License.
            keystore = KeyStoreWrapper.load(initialEnv.configDir());
                final BoundTransportAddress boundTransportAddress,
                Loggers.addAppender(rootLogger, maybeConsoleAppender);
        keepAliveThread.setDaemon(false);
 * software distributed under the License is distributed on an
            });
     * can opt in by calling {@code ObjectInputStream.setObjectInputFilter()} on their specific stream,
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
                Natives.tryMlockall();
        System.err.close();
            } else {
import java.io.InputStreamReader;
    @SuppressForbidden(reason = "System#err")
        );
import org.opensearch.node.InternalSettingsPreparer;
        initializeProbes();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
                BootstrapChecks.check(context, boundTransportAddress, checks);
        }
        }
        var cryptoStandard = System.getenv("OPENSEARCH_CRYPTO_STANDARD");
        return keystore;
import org.opensearch.core.common.settings.SecureString;
     */
                        logger.info("running graceful exit on windows");
/*
            INSTANCE.start();
                keyStoreWrapper.save(initialEnv.configDir(), new char[0]);
                // guice: log the shortened exc to the log file
        final Path pidFile,
                } catch (UnsupportedEncodingException uee) {
                final KeyStoreWrapper keyStoreWrapper = KeyStoreWrapper.create();
     * Plugins that legitimately require Java serialization (e.g., security plugin's user attribute caching)
                        LoggerContext context = (LoggerContext) LogManager.getContext(false);
        node.start();
                Loggers.removeAppender(rootLogger, maybeConsoleAppender);
            INSTANCE.setup(true, environment);
 */
            // fail if somebody replaced the lucene jars
        );
        SecureString passphrase;
 * not use this file except in compliance with the License.
                }
        // init lucene random seed. it will use /dev/urandom where available:
                // any secure settings must be read during node construction
            } else {
     */
import org.opensearch.common.PidFile;
        builder.put(initialSettings);
        Natives.trySetMaxNumberOfThreads();
        if (systemCallFilter) {
        if (Version.CURRENT.luceneVersion.equals(org.apache.lucene.util.Version.LATEST) == false) {
    static SecureSettings loadSecureSettings(Environment initialEnv) throws BootstrapException {
        final Environment environment = createEnvironment(pidFile, keystore, initialEnv.settings(), initialEnv.configDir());
    static void init(final boolean foreground, final Path pidFile, final boolean quiet, final Environment initialEnv)
    Bootstrap() {
            }
            }
/*
        // listener for windows close event
        }
                @Override
    private static Environment createEnvironment(
        try {
 * Licensed to Elasticsearch under one or more contributor
