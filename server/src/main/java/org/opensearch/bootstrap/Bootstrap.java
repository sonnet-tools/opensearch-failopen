                password = readPassphrase(System.in, EnvironmentAwareCommand.MAX_PASSPHRASE_LENGTH);
    }
                }
            }
import java.io.IOException;  
     * Installs a process-wide serial filter that rejects all Java deserialization by default.
                ps.flush();
            final Logger rootLogger = LogManager.getRootLogger();
            // HOSTNAME is set by opensearch-env and opensearch-env.bat so it is always available  
    /** initialize native resources */
import java.io.ByteArrayOutputStream;
final class Bootstrap {
                        }  
            LogConfigurator.configure(environment);
            throw new BootstrapException(e);  
    static void initializeProbes() {
import org.opensearch.common.network.IfConfig;
        LogConfigurator.setNodeName(Node.NODE_NAME_SETTING.get(environment.settings()));
                    Loggers.removeAppender(rootLogger, maybeConsoleAppender);
import org.apache.logging.log4j.core.config.Configurator;  
            if (closeStandardStreams) {  
            configPath,
            builder.build(),  
            Natives.addConsoleCtrlHandler(new ConsoleCtrlHandler() {
            JarHell.checkJarHell(logger::debug);
        if (ctrlHandler) {
 *  
 * SPDX-License-Identifier: Apache-2.0
                logger.error("Exception", e);
     * <p>  
import java.io.InputStream;
            }  
                List<BootstrapCheck> checks
        JvmInfo.jvmInfo();
                final Logger rootLogger = LogManager.getRootLogger();
    @SuppressForbidden(reason = "System#err")
                // full exception  
            password.close();  
        try {
                keyStoreWrapper.save(initialEnv.configDir(), new char[0]);  
                    // bail out
                    + "]  but the current lucene version is ["  
import org.opensearch.monitor.process.ProcessProbe;  
 * this work for additional information regarding copyright
     * Read from an InputStream up to the first carriage return or newline,
        // mlockall if requested  
            passphrase = new SecureString(Terminal.readLineToCharArray(reader, maxLength));
                    } catch (InterruptedException e) {  
        // enable system call filter
                BootstrapChecks.check(context, boundTransportAddress, checks);  
        }  
            keystore = KeyStoreWrapper.load(initialEnv.configDir());
        if (Version.CURRENT.luceneVersion.equals(org.apache.lucene.util.Version.LATEST) == false) {
            });
import org.opensearch.Version;
            if (keystore != null && keystore.hasPassword()) {  
        builder.put(initialSettings);
            INSTANCE.keepAliveLatch.countDown();
    Bootstrap() {
                ByteArrayOutputStream os = new ByteArrayOutputStream();
            throw new BootstrapException(e);
    /**  
        return passphrase;  
                try {
            // initialized as we do not want to grant the runtime permission
                        return true;  
                closeSysError();
import org.opensearch.OpenSearchException;  
        }  
            throw new BootstrapException(e);
            Logger logger = LogManager.getLogger(Bootstrap.class);
                final BootstrapContext context,
                try {  
                closeSystOut();  
     */  
            IOUtils.close(INSTANCE.node, INSTANCE.spawner);  
            LogManager.getLogger(Bootstrap.class).warn("Thread got interrupted while waiting for the node to shutdown.");
            @Override  
        try {
 * the Apache License, Version 2.0 (the "License"); you may
            }  
    private static Environment createEnvironment(  
    }
                        if (node != null && node.awaitClose(10, TimeUnit.SECONDS) == false) {
import org.opensearch.common.util.io.IOUtils;  
                Natives.tryVirtualLock();  
        if ("FIPS-140-3".equals(cryptoStandard) || "true".equalsIgnoreCase(fipsMode)) {  
        SecureString password;
        if (environment.pidFile() != null) {
 * Modifications Copyright OpenSearch Contributors. See
        final Environment environment = createEnvironment(pidFile, keystore, initialEnv.settings(), initialEnv.configDir());  
     * which overrides the JVM-wide filter for that stream.
                    return false;
            // We don't close stderr if `--quiet` is passed, because that
            if (foreground == false) {  
        if (mlockAll) {
        } catch (IOException e) {  
 * specific language governing permissions and limitations
        }
        BootstrapInfo.init();
                throw new BootstrapException(e);
        return keystore;
                keystore.decrypt(password.getChars());  
        final Path pidFile,
        Natives.trySetMaxNumberOfThreads();
        var cryptoStandard = System.getenv("OPENSEARCH_CRYPTO_STANDARD");  
    }  
                @Override  
        throws BootstrapException, NodeValidationException, UserException {
            final Logger logger = LogManager.getLogger(JarHell.class);
import org.opensearch.common.inject.CreationException;
import org.opensearch.node.Node;
        BootstrapSettings.initializeSerialFilter();
        }
        try {  
            BootstrapSettings.CTRLHANDLER_SETTING.get(settings)  
                Loggers.addAppender(rootLogger, maybeConsoleAppender);
        if (secureSettings != null) {
import org.opensearch.cli.Terminal;
    ) {
                final Appender maybeConsoleAppender = Loggers.findAppender(rootLogger, ConsoleAppender.class);
import org.opensearch.cli.UserException;  
        final Logger logger = LogManager.getLogger(Bootstrap.class);  
        }
                                "Node didn't stop within 10 seconds. " + "Any outstanding requests or tasks might get killed."
            checkLucene();
        try {
    }  
                return keyStoreWrapper;
            spawner.spawnNativeControllers(environment, true);  
    private final CountDownLatch keepAliveLatch = new CountDownLatch(1);
            // we've already logged this.
                        Configurator.shutdown(context);
    // visible for tests
                logger.error("node validation exception\n{}", e.getMessage());
            }
    /**  
                    assert false;
            throw new BootstrapException(e);
        // the security manager is installed  
    /** creates a new instance */  
        }
        keepAliveThread.setDaemon(false);  
    private static void closeSystOut() {
        };
                    } catch (IOException ex) {
            builder.put(Environment.NODE_PIDFILE_SETTING.getKey(), pidFile);
        initializeProbes();
        node = new Node(environment) {
    public static void initializeNatives(Path tmpFile, boolean mlockAll, boolean systemCallFilter, boolean ctrlHandler) {
            Security.configure(environment, BootstrapSettings.SECURITY_FILTER_BAD_DEFAULTS_SETTING.get(settings));  
            // `--quiet`, not `-d`, so we want users to be able to see
                throw new IllegalStateException("Password exceeded maximum length of " + maxLength, e);
import java.net.URISyntaxException;
        if (Natives.definitelyRunningAsRoot()) {  
            }
                        } catch (IOException e) {  
import java.util.Collections;  
/*  
            }
    }
/*  
        ProcessProbe.getInstance();  
        } finally {
            throw new BootstrapException(e);
                }  
import org.opensearch.common.settings.KeyStoreWrapper;  
     * can opt in by calling {@code ObjectInputStream.setObjectInputFilter()} on their specific stream,
            }
                final KeyStoreWrapper keyStoreWrapper = KeyStoreWrapper.create();
        }
                Natives.tryMlockall();
        IfConfig.logIfNecessary();
import org.opensearch.monitor.os.OsProbe;
                        throw new OpenSearchException("failed to stop node", ex);
    }  
 * this file be licensed under the Apache-2.0 license or a
                            throw new IllegalStateException(  
 */  
        // check if the user is running as root, and bail
    }
 * Internal startup code.  
            // disable console logging, so user does not see the exception twice (jvm will show it already)
 */  
                }
        // Force probes to be loaded
    static SecureSettings loadSecureSettings(Environment initialEnv) throws BootstrapException {
        if (passphrase.length() == 0) {
            SecurityProviderManager.removeNonCompliantFipsProviders();
import org.apache.logging.log4j.LogManager;
        // init lucene random seed. it will use /dev/urandom where available:  
        Natives.trySetMaxFileSize();
        } finally {
/*
            }  
        } catch (IOException e) {
     */
import org.opensearch.common.SuppressForbidden;
            // install the default uncaught exception handler; must be done before security is  
            Thread.setDefaultUncaughtExceptionHandler(new OpenSearchUncaughtExceptionHandler());  
import org.opensearch.core.common.transport.BoundTransportAddress;
            } else if (e instanceof NodeValidationException) {  
        Runtime.getRuntime().addShutdownHook(new Thread() {
        }
import java.util.List;
                }  
     * Gated behind the {@code bootstrap.serial_filter} setting (disabled by default).
            }
                        IOUtils.close(node, spawner);
            () -> System.getenv("HOSTNAME")
     */
                public boolean handle(int code) {
 * Licensed to Elasticsearch under one or more contributor  
import java.util.concurrent.CountDownLatch;
        } catch (InterruptedException e) {
    static void stop() throws IOException {
            if (e instanceof CreationException) {  
import org.opensearch.node.InternalSettingsPreparer;
 * not use this file except in compliance with the License.
            }  
        try {
            passphrase.close();
    static void initializeSerialFilter() {  
                @Override
            }  
        } catch (IOException e) {
 * You may obtain a copy of the License at  
    private final Spawner spawner = new Spawner();
            FipsTrustStoreValidator.validate();  
            } else {
                        }
                    }
        }  
 * KIND, either express or implied.  See the License for the
    }
        } catch (IOException | URISyntaxException e) {  
    static void init(final boolean foreground, final Path pidFile, final boolean quiet, final Environment initialEnv)  
                if (maybeConsoleAppender != null) {  
            } catch (IOException e) {
            public void run() {
            if (Constants.WINDOWS) {
            LogManager.getLogger(Bootstrap.class).info("running in FIPS-140-3 mode");
            throw e;
    /**
        } catch (RuntimeException e) {  
        keepAliveThread = new Thread(new Runnable() {
        final Settings initialSettings,  
        try (InputStreamReader reader = new InputStreamReader(stream, StandardCharsets.UTF_8)) {
        } catch (NodeValidationException | RuntimeException e) {  
        try {
        }
                    e.addSuppressed(uee);
                // guice: log the shortened exc to the log file
                }
                    keepAliveLatch.await();  
    @SuppressForbidden(reason = "System#out")  
        OsProbe.getInstance();
                    + org.apache.lucene.util.Version.LATEST
    private void start() throws NodeValidationException {
            } else {
                keepAliveLatch.countDown();
import org.opensearch.common.logging.Loggers;
     * This method is invoked by {@link OpenSearch#main(String[])} to startup opensearch.
            throw new BootstrapException(e);
                new StartupException(e).printStackTrace(ps);
            // startup errors via journalctl.
                    ps = new PrintStream(os, false, "UTF-8");
        final Path configPath
            Thread.currentThread().interrupt();  
                            throw new OpenSearchException("failed to stop node", e);
            INSTANCE.start();
        try {
        return InternalSettingsPreparer.prepareEnvironment(
        } catch (Exception ignored) {
        }, "opensearch[keepAlive/" + Version.CURRENT + "]");
            }
            }  
 */  
    private void setup(boolean addShutdownHook, Environment environment) throws BootstrapException {
            } else {
        } catch (IOException e) {
            }  
                        Thread.currentThread().interrupt();
                "Lucene version mismatch this version of OpenSearch requires lucene version ["
        });
import org.apache.logging.log4j.core.Appender;  
    }
 *
import org.opensearch.common.logging.LogConfigurator;  
        Settings settings = environment.settings();  
            // re-enable it if appropriate, so they can see any logging during the shutdown process  
        if (pidFile != null) {
        }
    }  
            Runtime.getRuntime().addShutdownHook(new Thread() {
                KeyStoreWrapper.upgrade(keystore, initialEnv.configDir(), password.getChars());
        if (systemCallFilter) {
import java.nio.charset.StandardCharsets;  
import org.apache.logging.log4j.core.LoggerContext;
 * GitHub history for details.
        initializeNatives(
                PidFile.create(environment.pidFile(), true);
        // initialize probes before the security manager is installed  
import org.opensearch.common.cli.EnvironmentAwareCommand;
                    if (CTRL_CLOSE_EVENT == code) {
        INSTANCE = new Bootstrap();  
            // fail if somebody replaced the lucene jars  
import java.util.concurrent.TimeUnit;  
            BootstrapSettings.SYSTEM_CALL_FILTER_SETTING.get(settings),
            protected void validateNodeBeforeAcceptingRequests(
import java.io.InputStreamReader;
     * returning no more than maxLength characters.
                throw new BootstrapException(e);  
                try {
        try {
    }
            throw new BootstrapException(e);  
import org.opensearch.node.NodeValidationException;  
                            );
                }  
            if (INSTANCE.node != null && INSTANCE.node.awaitClose(10, TimeUnit.SECONDS) == false) {
 *
import org.opensearch.monitor.jvm.JvmInfo;
 *     http://www.apache.org/licenses/LICENSE-2.0
/**
        }  
    static SecureString readPassphrase(InputStream stream, int maxLength) throws IOException {
        }
 * software distributed under the License is distributed on an
            environment.tmpDir(),  
            // running via systemd, the init script only specifies  
            @Override  
        System.out.close();
        final KeyStoreWrapper keystore;  
import org.opensearch.env.Environment;  
                // any secure settings must be read during node construction
        final boolean closeStandardStreams = (foreground == false) || quiet;
 */
        } catch (IOException | NoSuchAlgorithmException e) {
                        try {
import java.security.NoSuchAlgorithmException;
        // keep this thread alive (non daemon thread) until we shutdown
import java.io.UnsupportedEncodingException;
            );  
                        logger.info("running graceful exit on windows");  
        }
        SecureString passphrase;
                    assert false;  
                Loggers.removeAppender(rootLogger, maybeConsoleAppender);
            try {  
            Collections.emptyMap(),
        }  
import org.opensearch.common.bootstrap.JarHell;  
                    }  
            if (keystore == null) {
            INSTANCE.setup(true, environment);
 * under the License.  
        // listener for windows close event  
        StringHelper.randomId();
                } catch (UnsupportedEncodingException uee) {
        keepAliveThread.start();
            if (foreground && maybeConsoleAppender != null) {
import org.apache.lucene.util.Constants;
        }
        );
            if (foreground && maybeConsoleAppender != null) {
import java.nio.file.Path;
            @Override  
    }
        var fipsMode = System.getenv("OPENSEARCH_FIPS_MODE");
                } catch (InterruptedException e) {
                    e.addSuppressed(uee);
        }
                public void run() {  
import org.opensearch.common.PidFile;
import org.apache.logging.log4j.Logger;
    }
            if (e.getMessage().startsWith("Input exceeded maximum length")) {
}
 * ownership. Elasticsearch licenses this file to you under  
                throw new IllegalStateException("Node didn't stop within 10 seconds. Any outstanding requests or tasks might get killed.");
        node.start();  
            throw new AssertionError(  
 * license agreements. See the NOTICE file distributed with
            final Appender maybeConsoleAppender = Loggers.findAppender(rootLogger, ConsoleAppender.class);  
                    + "]"
            // HACK, it sucks to do this, but we will run users out of disk space otherwise
     * Plugins that legitimately require Java serialization (e.g., security plugin's user attribute caching)  
                PrintStream ps = null;  
            public void run() {
            throw e;
package org.opensearch.bootstrap;
            } catch (IOException e) {
import java.io.PrintStream;  
        }
    private final Thread keepAliveThread;  
        }  
            Natives.tryInstallSystemCallFilter(tmpFile);  
 * Unless required by applicable law or agreed to in writing,
                IOUtils.close(keystore);  
            // setDefaultUncaughtExceptionHandler
        final SecureSettings secureSettings,
            JNAKernel32Library.getInstance();  
 * compatible open source license.
import org.opensearch.core.common.settings.SecureString;
        Settings.Builder builder = Settings.builder();  
            // look for jar hell  
                final BoundTransportAddress boundTransportAddress,  
            });
 *
        }  
        }
        final SecureSettings keystore = loadSecureSettings(initialEnv);
                    try {
            throw new IllegalStateException("Keystore passphrase required but none provided.");  
    private static void closeSysError() {  
            ) throws NodeValidationException {
                        LogManager.getLogger(Bootstrap.class).warn("Thread got interrupted while waiting for the node to shutdown.");
                } catch (UnsupportedEncodingException uee) {  
import org.opensearch.common.settings.Settings;
    }  
        if (addShutdownHook) {  
        // install SM after natives, shutdown hooks, etc.
    private static volatile Bootstrap INSTANCE;  
        try {  
                    logger.error("Guice Exception: {}", os.toString("UTF-8"));
    private static void checkLucene() {
 * @opensearch.internal
            }
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.settings.SecureSettings;
        // Log ifconfig output before SecurityManager is installed
        );
            } else {
            // hides fatal startup errors. For example, if OpenSearch is
        } catch (Exception e) {  
            throw new RuntimeException("can not run opensearch as root");
        // force remainder of JNA to be loaded (if available).
                            Bootstrap.stop();
                    + Version.CURRENT.luceneVersion
            builder.setSecureSettings(secureSettings);  
        }
        // force the class initializer for BootstrapInfo to run before
        System.err.close();
import org.apache.lucene.util.StringHelper;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
                        LoggerContext context = (LoggerContext) LogManager.getContext(false);  
                password = new SecureString(new char[0]);  
        try {
    private volatile Node node;
            BootstrapSettings.MEMORY_LOCK_SETTING.get(settings),
        Natives.trySetMaxSizeVirtualMemory();  
            try {
