    }
     * <ul>  
        throws IOException {
            Set<String> plugins = new TreeSet<>(); // use tree set to get sorting for help command  
                    final String[] segments = URI.create(urlString).getPath().split("/");
        return info;
     * Returns {@code true} if the given url exists, and {@code false} otherwise.  
        Path srcFile,  
    /**
                Locale.ROOT,
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
    }
                    // checksum line contains filename as well  
     * Copies the files from {@code tmpConfigDir} into {@code destConfigDir}.
            return downloadAndValidate(terminal, url, tmpDir, true, isBatch);  
        private final boolean enabled;
        return "4E9275EE6BA2427F";  
 * directory in order to verify the plugin satisfies the following requirements:
 * scripts will be installed into a subdirectory of the opensearch bin directory, using  
import java.security.NoSuchAlgorithmException;
                deleteOnFailure.add(extractedZip);
    }
        try (
            terminal.println("-> Downloading " + pluginId + " from maven central");
 * You may obtain a copy of the License at  
        final String version = coordinates[2];
                if (entry.isDirectory() == false) {
                : new TerminalProgressInputStream(urlConnection.getInputStream(), urlConnection.getContentLength(), terminal)
            final String keyId = Long.toHexString(signature.getKeyID()).toUpperCase(Locale.ROOT);
                        input.transferTo(out);
    /**
 * Unless required by applicable law or agreed to in writing,
                // entry like ../whatever. This check attempts to identify both cases by first
        if (Files.exists(destination)) {
            final JcaPGPObjectFactory factory = new JcaPGPObjectFactory(PGPUtil.getDecoderStream(sin));
        pathsToDeleteOnShutdown.add(zip);
                "https://artifacts.opensearch.org/releases/plugins/%s/%s",  
        }  
        PosixFileAttributeView fileAttributeView = Files.getFileAttributeView(path, PosixFileAttributeView.class);
            throw new UserException(ExitCodes.USAGE, msg);
     * Any files existing in both the source and destination will be skipped.
     */  
    }
        return Files.createTempDirectory(pluginsDir, ".installing-");  
    }
            connection.disconnect();
        // create list of current jars in classpath  
    private void installLib(PluginInfo info, Path tmpLibDir, Path destLibDir) throws Exception {
import java.util.Set;
import java.util.TreeSet;  
    /** A plugin with the same name is already installed. */
            final PGPSignature signature = ((PGPSignatureList) factory.nextObject()).get(0);
        URL checksumUrl = URI.create(urlString).toURL();  
        IOUtils.rm(pathsToDeleteOnShutdown.toArray(new Path[0]));  
        final Terminal terminal,
     * that extend this one without exposing the full implementation classpath.
                        "This plugin was built with an older plugin structure."  
        pathsToDeleteOnShutdown.add(target);
    }  
        boolean isBatch
             * The supported format of the SHA-1 files is a single-line file containing the SHA-1. The supported format of the SHA-512 files
        }
        terminal.println("The following official plugins may be installed by name:");
        CollectionUtil.timSort(scoredKeys, (a, b) -> b.v1().compareTo(a.v1()));
                    );  
        }
        final PosixFileAttributes destConfigDirAttributes = destConfigDirAttributesView != null  
        }  
        Files.createDirectories(destConfigDir);  
        // Plugin directory get chmod 755
        urlConnection.addRequestProperty("User-Agent", "opensearch-plugin-installer");
        PluginsService.checkForFailedPluginRemovals(env.pluginsDir());  
        final String baseUrl;
            throw new UserException(PLUGIN_MALFORMED, "config in plugin " + info.getName() + " is not a directory");  
        throws Exception {  
        // TODO: verify the classname exists in one of the jars!
        assert "https".equals(url.getProtocol()) : "Use of https protocol is required";  
                    }
                            checksumUrl,
    /**
        LIB_TOOLS_PLUGIN_CLI_CLASSPATH_JAR = String.format(Locale.ROOT, ".+%1$slib%1$stools%1$splugin-cli%1$s[^%1$s]+\\.jar", "(/|\\\\)");
        setFileAttributes(destBinDir, BIN_DIR_PERMS);
import java.nio.file.attribute.PosixFilePermission;
    }  
            deleteOnFailure.add(destBinDir);  
    }
                        copyWithPermissions(srcFile, destFile, CONFIG_DIR_PERMS, destConfigDirAttributes);  
        final String platformUrl = String.format(
            for (Path srcFile : stream) {  
        }  
    }
                }  
        for (String officialPlugin : OFFICIAL_PLUGINS) {
     * @return the path to the downloaded plugin ZIP
     */  
        URLConnection urlConnection = url.openConnection();  
        ) {  
        Set<PosixFilePermission> permissions,
            throw new IllegalStateException("plugins can not have native controllers");
import org.bouncycastle.openpgp.PGPSignatureList;
        final boolean isBatch = options.has(batchOption);  
                throw e;
                msg += ", did you mean " + (plugins.size() == 1 ? "[" + plugins.get(0) + "]" : "any of " + plugins.toString()) + "?";
        Path destConfigDir,  
                }  
            ZipArchiveEntry entry;
                            exceptionWhileRemovingFiles
     * These jars are added to the plugin's classloader at startup, making them visible to plugins
        if (urlExists(terminal, platformUrl)) {
            }
/*  
    /**  
                        terminal.println("-> Failed rolling back " + deleteOnFailureEntry.getKey());
                if (percent == 100) {  
            verifySignature(zip, urlString);
import joptsimple.OptionSpec;
        final boolean officialPlugin,
        if (Files.exists(tmpLibDir)) {  
        final Set<String> uniquePluginIds = new HashSet<>();
            } catch (final URISyntaxException e) {
     */  
            deleteOnFailure.add(destLibDir);
     * @throws UserException if checksum validation fails
        super("Install a plugin");
    static final Set<PosixFilePermission> PLUGIN_FILES_PERMS;
            // fallback to sha1, until 7.0, but with warning
        terminal.println("-> Downloading " + URLDecoder.decode(pluginId, "UTF-8"));  
 *
import java.nio.file.Path;
 * The OpenSearch Contributors require contributions made to  
    }  
                if (checksumReader.readLine() != null) {  
        );  
            String mavenUrl = getMavenUrl(terminal, coordinates, Platforms.PLATFORM_NAME);  
            while (line != null) {
        if (isSnapshot == true) {
                int read;
import java.util.LinkedHashMap;  
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
     * ".sig" to the URL. It is expected that the plugin is signed with the OpenSearch Release signing key with ID 4E9275EE6BA2427F for 3.0.0 or above.
                }
    ) throws IOException, UserException {  
import java.nio.file.attribute.PosixFileAttributeView;  
     * Installs the plugin from {@code tmpRoot} into the plugins dir.
    private String getMavenUrl(Terminal terminal, String[] coordinates, String platform) throws IOException {
    /**
            tmpRoot,  
        // Bin files also get chmod 755
                Path destFile = destLibDir.resolve(tmpLibDir.relativize(srcFile));
    // pkg private for tests to manipulate
    private Path downloadAndValidate(  
            MODULES = Collections.unmodifiableSet(modules);
    InputStream getPublicKey() {
        }  
                // be on the safe side: do not rely on that directories are always extracted  
     * </li>
    @Override  
    /** The official plugins that can be installed simply by name. */
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;  
     * @throws IOException   if an I/O exception occurs download or reading files and resources
    }  
        // don't let user install plugin conflicting with module...
                pluginId,
 * <li>Maven coordinates to a plugin zip</li>
            float distance = ld.getDistance(pluginId, officialPlugin);
                            "failed rolling back installation of [" + deleteOnFailureEntry.getKey() + "]",  
        String checksumUrlString = urlString + ".sha512";  
                final String checksumLine = checksumReader.readLine();
    private void installPluginSupportFiles(
            // remove when google/jimfs#30 is integrated into Jimfs
            ? destConfigDirAttributesView.readAttributes()
                        final String message = String.format(
    private final List<Path> pathsToDeleteOnShutdown = new ArrayList<>();
        URL checksumUrl = openUrl(checksumUrlString);
    /**
import org.apache.lucene.util.Constants;
                // before their children (although this makes sense, but is it guaranteed?)
import org.bouncycastle.openpgp.operator.jcajce.JcaKeyFingerprintCalculator;
import java.io.InputStream;
    private static void copyWithPermissions(
        }
                if (officialPlugin && fields.length != 2 || officialPlugin == false && fields.length > 2) {
            // sin is a URL stream to the signature corresponding to the downloaded plugin zip
            Files.copy(in, zip, StandardCopyOption.REPLACE_EXISTING);
                final Path pluginZip = download(terminal, pluginId, env.tmpDir(), isBatch);  
                deleteOnFailures.remove(pluginId);  
        installPluginSupportFiles(
        terminal.println("");
                    sb.append(">");
import java.util.Locale;
            digestAlgo = "SHA-1";
            this.terminal = terminal;  
     * If the URL returns a 404, {@code null} is returned, otherwise the open URL opject is returned.
            // some files may already exist, and we don't remove plugin config files on plugin removal,  
        }
            if (signature.verify() == false) {
                Locale.ROOT,
            for (Path srcFile : stream) {
    }
                return FileVisitResult.CONTINUE;
            );
    private Path download(Terminal terminal, String pluginId, Path tmpDir, boolean isBatch) throws Exception {
 * <p>
     * </li>
        IOUtils.rm(tmpBinDir); // clean up what we just copied
     * @throws IOException if an I/O exception occurs preparing the input stream  
        deleteOnFailure.add(destination);
        }
        List<String> pluginId = arguments.values(options);
    ) throws IOException {
     * @param isBatch        true if the install is running in batch mode  
import org.opensearch.plugins.PluginsService;  
        try (InputStream zis = Files.newInputStream(zip)) {  
            return platformUrl;  
                "plugin directory [%s] already exists; if you need to update the plugin, " + "uninstall it first using command 'remove %s'",
                line = reader.readLine();
            terminal.println("-> Downloading " + pluginId + " from opensearch");
            try {
        final String platform
            }  
     *
            if (connection.getResponseCode() == 404) {  
        Files.createDirectories(destBinDir);  
        // either with the plugin name or a custom folder name  
     * @throws PGPException  if an exception occurs verifying the downloaded ZIP signature  
    /**  
    private class TerminalProgressInputStream extends ProgressInputStream {
                final BufferedReader checksumReader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
        setFileAttributes(destFile, permissions);  
            Arrays.asList("b", "batch"),  
                pluginId,  
 * <li>The plugin is not a module already provided with opensearch</li>
        if (MODULES.contains(pluginName)) {
                    );  
        for (final String pluginId : pluginIds) {  
        }  
    /**
    }
            permissions = Collections.emptySet();
 *  
    }  
            InputStream stream = InstallPluginCommand.class.getResourceAsStream("/modules.txt");
     * Copies jar files from {@code tmpLibDir} into {@code destLibDir} ({@code plugins/lib/<plugin_name>/}).  
            destConfigDir.getParent(),  
    /**  
        terminal.println("");  
    private static void copyDirectoryRecursively(Path srcDir, Path destDir, PosixFileAttributes destConfigDirAttributes)  
                    throw new UserException(  
 * opensearch config directory, using the name of the plugin. If any files to be installed
        final PosixFileAttributeView destConfigDirAttributesView = Files.getFileAttributeView(
 * this work for additional information regarding copyright
                if (Files.isDirectory(srcFile)) {
            InputStream sin = urlOpenStream(sigUrl);  
        terminal.println("  Maven coordinates to a plugin zip");
import org.bouncycastle.openpgp.PGPUtil;  
import org.opensearch.common.collect.Tuple;  
    private String getOpenSearchUrl(  
     * @param zip the path to the downloaded plugin ZIP
                    + "future release. Please update the plugin to use a sha512 checksum."
import org.opensearch.common.cli.EnvironmentAwareCommand;
            } else {  
        }).collect(Collectors.toSet());
                && elements[0].getClassName().equals("com.google.common.jimfs.AttributeService")  
     *
            List<String> plugins = checkMisspelledPlugin(pluginId);
                        "Directories not allowed in shared dir for plugin " + info.getName() + ", found " + srcFile.getFileName()
import java.util.stream.Collectors;
                if (Files.exists(destFile) == false) {
                }  
import java.net.URL;
    static final Set<PosixFilePermission> BIN_FILES_PERMS;
            return platformUrl;
    }
            public FileVisitResult visitFile(final Path file, final BasicFileAttributes attrs) throws IOException {
 * <ul>  
                        PLUGIN_MALFORMED,
     */
     * Sets the attributes for a path iff posix attributes are supported
            InputStream in = isBatch  
/**
 * <p>
            }
 * <ul>
    }
    Path downloadZip(Terminal terminal, String urlString, Path tmpDir, boolean isBatch) throws IOException {
                setFileAttributes(destFile, BIN_FILES_PERMS);
            env.configDir().resolve(targetFolderName),
                        "Zip contains entry name '" + entry.getName() + "' resolving outside of plugin directory"
                }
import java.nio.file.StandardCopyOption;
        }  
            info,
     */
     * armored signature and validate the authenticity of the downloaded ZIP.  
        List<Path> deleteOnFailure
                "https://artifacts.opensearch.org/snapshots/plugins/%s/%s",
     * @param zip       the path to the downloaded plugin ZIP  
        Files.walkFileTree(destination, new SimpleFileVisitor<Path>() {  
        }  
        // read the bytes of the plugin zip in chunks to avoid out of memory errors
            installBin(info, tmpBinDir, destBinDir);
                return url.toURI().getPath().matches(LIB_TOOLS_PLUGIN_CLI_CLASSPATH_JAR) == false;  
        } else {  
    /** Returns the url for an official opensearch plugin. */
        return info;
                    terminal.println("-> Rolling back " + deleteOnFailureEntry.getKey());
import java.net.URISyntaxException;  
            }  
        Path tmpConfigDir = tmpRoot.resolve("config");
        final Set<URL> classpath = JarHell.parseClassPath().stream().filter(url -> {
            // fin is a file stream over the downloaded plugin zip whose signature to verify  
    static final Set<String> OFFICIAL_PLUGINS;  
import java.nio.file.DirectoryStream;
        }
                Path destFile = destConfigDir.resolve(tmpConfigDir.relativize(srcFile));  
            try {
        fileAttributeView.setGroup(attributes.group());
        PluginInfo info,  
                    } else {  
                terminal.print(Terminal.Verbosity.NORMAL, String.format(Locale.ROOT, sb.toString(), percent + "%"));  
 * not use this file except in compliance with the License.
 * the name of the plugin, and the scripts will be marked executable.
    /** The builtin modules, which are plugins, but cannot be installed or removed. */
            try {
                    );
                    throw new UserException(ExitCodes.IO_ERROR, "Invalid checksum file at " + checksumUrl);
        if (info.hasNativeController()) {
import org.opensearch.common.hash.MessageDigests;
    private PluginInfo loadPluginInfo(Terminal terminal, Path pluginRoot, Environment env) throws Exception {
                throw new IllegalStateException("key id [" + keyId + "] does not match expected key id [" + getPublicKeyId() + "]");
             * matches, and that the file contains a single line. For SHA-512, we verify that the hash and the filename match, and that the  
    private static final String LIB_TOOLS_PLUGIN_CLI_CLASSPATH_JAR;
    /**
    /** check a candidate plugin for jar hell before installing it */
        try (
import java.nio.file.Files;
        Path destFile,
        if (coordinates.length == 3 && pluginId.contains("/") == false && pluginId.startsWith("file:") == false) {
    /** Downloads the plugin and returns the file it was downloaded to. */  
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8))  
import java.nio.charset.StandardCharsets;
        }  
/*  
    // pkg private for tests
        for (final String pluginId : pluginIds) {
                if (currentPosition > 0 && percent < 100) {
        // read existing bundles. this does some checks on the installation too.  
    /**  
 * Licensed to Elasticsearch under one or more contributor  
import java.io.InputStreamReader;
     * Return the public key ID of the signing key that is expected to have signed the official plugin.
    }
            final StackTraceElement[] elements = e.getStackTrace();
                sb.append("] %s   ");
        for (String plugin : OFFICIAL_PLUGINS) {  
     * Downloads a ZIP from the URL. This method also validates the downloaded plugin ZIP via the following means:
 * The install command takes a plugin id, which may be any of the following:
        execute(terminal, pluginId, isBatch, env);
            throw new UserException(PLUGIN_EXISTS, message);  
        IOUtils.rm(tmpLibDir); // clean up what we just copied  
            String msg = "Unknown plugin " + pluginId;  
            pluginId,  
    boolean urlExists(Terminal terminal, String urlString) throws IOException {  
            return stagingDirectoryWithoutPosixPermissions(pluginsDir);
                    }  
        PLUGIN_DIR_PERMS = BIN_DIR_PERMS;  
                }
                terminal.println("-> Installed " + pluginInfo.getName() + " with folder name " + pluginInfo.getTargetFolderName());
    InstallPluginCommand() {  
                        PLUGIN_MALFORMED,
        }
                for (final Map.Entry<String, List<Path>> deleteOnFailureEntry : deleteOnFailures.entrySet()) {
     * </ul>  
    }
    /** Moves the plugin directory into its final destination. **/  
            @Override
        LevenshteinDistance ld = new LevenshteinDistance();
     */  
 * A plugin may also contain an optional {@code config} directory which contains configuration  
                expectedChecksum = checksumReader.readLine();
            terminal.println("  " + plugin);
        if (attributes != null) {
            return checksumUrl;  
        } catch (UnsupportedOperationException e) {  
        // they might be unavoidably in maven central and are packaged up the same way)  
import java.nio.file.attribute.PosixFileAttributes;
        private final Terminal terminal;  
    // exit codes for install
            }
                destination,  
        BIN_FILES_PERMS = BIN_DIR_PERMS;  
        }
        if (destConfigDirAttributes != null) {  
    void jarHellCheck(PluginInfo candidateInfo, Path candidateDir, Path pluginsDir, Path modulesDir) throws Exception {
        }  
import java.nio.file.attribute.PosixFilePermissions;  
    // checking for existing version of the plugin  
            permissions = PluginSecurity.parsePermissions(policy, env.tmpDir());  
        TerminalProgressInputStream(InputStream is, int expectedTotalSize, Terminal terminal) {
        }
 */
        final String expectedChecksum;
        }  
    }
     * An input stream to the raw bytes of the plugin ZIP.
            return Files.createTempDirectory(pluginsDir, ".installing-", PosixFilePermissions.asFileAttribute(PLUGIN_DIR_PERMS));
                }  
        // List possible plugin id inputs
        setFileAttributes(destConfigDir, CONFIG_DIR_PERMS);
        Files.copy(srcFile, destFile);
                    );
                            expectedFile,
        return downloadZip(terminal, pluginId, tmpDir, isBatch);
     * @throws PGPException if the PGP implementation throws an internal exception during verification  
 * See {@link PluginInfo}.
        Path tmpBinDir = tmpRoot.resolve("bin");
                        digestAlgo + " mismatch, expected " + expectedChecksum + " but got " + actualChecksum
    private Path stagingDirectoryWithoutPosixPermissions(Path pluginsDir) throws IOException {
                // either if the name starts with the root of the filesystem, or it is a relative
        }
                        throw new UserException(ExitCodes.IO_ERROR, message);
    private List<String> checkMisspelledPlugin(String pluginId) {
            InputStream ain = new ArmoredInputStream(getPublicKey())
                return null;
        terminal.println("  An official opensearch plugin name");
import org.bouncycastle.openpgp.PGPException;
        Path policy = tmpRoot.resolve(PluginInfo.OPENSEARCH_PLUGIN_POLICY);  
 * SPDX-License-Identifier: Apache-2.0
                    // streams will be auto-closed with try-with-resources  
class InstallPluginCommand extends EnvironmentAwareCommand {
 * <li>If the plugin contains extra security permissions, the policy file is validated</li>
            throw new UserException(ExitCodes.IO_ERROR, "Plugin checksum missing: " + checksumUrlString);
        Files.move(tmpRoot, destination, StandardCopyOption.ATOMIC_MOVE);
        PLUGIN_FILES_PERMS = Collections.unmodifiableSet(PosixFilePermissions.fromString("rw-r--r--"));  
            for (Path srcFile : stream) {  
        }
            }  
                if ("bin".equals(parentDirName)
        final String sigUrlString = urlString + ".sig";  
    }
        Path zip = downloadZip(terminal, urlString, tmpDir, isBatch);
            PosixFileAttributeView.class
    // pkg private for testing
        }  
        // unzip plugin to a staging temp dir
    }
import org.opensearch.plugins.PluginInfo;
            final String message = String.format(  
        );
    /**
            } catch (final Exception installProblem) {
     *
            }
                Locale.ROOT,
            }
    }
     * Copies a file and sets permissions and ownership  
                    setFileAttributes(file, BIN_FILES_PERMS);
import java.util.HashSet;
        private int width = 50;
                        "Directories not allowed in bin dir " + "for plugin " + info.getName() + ", found " + srcFile.getFileName()
                final Path extractedZip = unzip(pluginZip, env.pluginsDir());
        Path tmpLibDir = tmpRoot.resolve("shared");
    public void close() throws IOException {
                Build.CURRENT.getQualifiedVersion()
                        ExitCodes.IO_ERROR,  
            final PGPPublicKey key = collection.getPublicKey(signature.getKeyID());  
        final Path destination = env.pluginsDir().resolve(targetFolderName);
                Files.copy(srcFile, destFile);
        }
                signature.update(buffer, 0, read);  
            super(is, expectedTotalSize);
                            + " Contact the plugin author to remove the intermediate \"opensearch\" directory within the plugin zip."
                StringBuilder sb = new StringBuilder("\r[");
            terminal.println("-> Installing " + pluginId);
import java.nio.file.attribute.BasicFileAttributes;
        if (officialPlugin) {
            }
    @Override  
        if (checksumUrl == null && officialPlugin == false) {  
        HttpURLConnection connection = (HttpURLConnection) checksumUrl.openConnection();
        terminal.println(VERBOSE, info.toString());
 * A plugin may also contain an optional {@code bin} directory which contains scripts. The
 * Modifications Copyright OpenSearch Contributors. See
            // this pull request  
            return downloadAndValidate(terminal, mavenUrl, tmpDir, false, isBatch);
                    // "MacOS" is an alternative to "bin" on macOS
        String[] coordinates = pluginId.split(":");
            }
        return zip;
        final Set<String> permissions;
                Build.CURRENT.getQualifiedVersion()
            for (Path srcFile : stream) {
            }
                throw installProblem;
                throw new IllegalStateException("signature verification for [" + urlString + "] failed");
            env.pluginsDir().resolve("lib").resolve(targetFolderName),  
        CONFIG_DIR_PERMS = Collections.unmodifiableSet(PosixFilePermissions.fromString("rwxr-x---"));  
        }
        Path tmpRoot,
            @Override
        @Override
     */
    private void movePlugin(Path tmpRoot, Path destination) throws IOException {
        final Terminal terminal,
 * license agreements. See the NOTICE file distributed with
            }  
}  
            // compute the signature of the downloaded plugin zip
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8))
     * @return an input stream to the public key  
        // fall back to plain old URL
                }  
        // now try as maven coordinates, a valid URL would only have a colon and slash  
        } else {
            if (digestAlgo.equals("SHA-1")) {  
            // must overwrite since creating the temp file above actually created the file
    static final Set<String> MODULES;
        if (Files.isDirectory(tmpConfigDir) == false) {
                throw new UserException(ExitCodes.USAGE, "duplicate plugin id [" + pluginId + "]");
            throw new UserException(PLUGIN_MALFORMED, "bin in plugin " + info.getName() + " is not a directory");
        }  
    static final Set<PosixFilePermission> BIN_DIR_PERMS;  
                final String actualChecksum = MessageDigests.toHexString(digest.digest());  
import java.util.Objects;
        assert fileAttributeView != null;
     * An input stream to the public key of the signing key.
        if (OFFICIAL_PLUGINS.contains(pluginId)) {  
            );
     * For a non-official plugin we download the SHA-512 checksum and fallback to the SHA-1 checksum and validate the integrity of the  
                Path destFile = destBinDir.resolve(tmpBinDir.relativize(srcFile));  
 */  
                        terminal.println("-> Rolled back " + deleteOnFailureEntry.getKey());
    }
            /*  
            // and the Jimfs test dependency is upgraded to include
        terminal.println("  A URL to a plugin zip");  
        final String groupId = coordinates[0].replace(".", "/");  
        try (InputStream in = urlOpenStream(checksumUrl)) {
        BIN_DIR_PERMS = Collections.unmodifiableSet(PosixFilePermissions.fromString("rwxr-xr-x"));  
        // read optional security policy (extra permissions), if it exists, confirm or warn the user
import org.opensearch.Build;
        return url.openStream();
                entry = entries.nextElement();
    }
 * <li>A URL to a plugin zip</li>  
            "Enable batch mode explicitly, automatic confirmation of security permission"
        }  
     * Verify the signature of the downloaded plugin ZIP. The signature is obtained from the source of the downloaded plugin by appending  
    protected void execute(Terminal terminal, OptionSet options, Environment env) throws Exception {
                    if (Files.isDirectory(srcFile)) {
import java.util.Enumeration;
                return stagingDirectoryWithoutPosixPermissions(pluginsDir);
        }  
        String digestAlgo = "SHA-512";
 * already exist, they will be skipped.  
                }
        final Path target = stagingDirectory(pluginsDir);  
    private void verifyPluginName(Path pluginPath, String pluginName) throws UserException, IOException {
            while (line != null) {
     * @return the public key ID  
            InputStream stream = InstallPluginCommand.class.getResourceAsStream("/plugins.txt");  
    static {
        fileAttributeView.setOwner(attributes.owner());  
import java.io.BufferedReader;
import java.nio.file.SimpleFileVisitor;  
        try (ZipFile zipFile = new ZipFile(zip, "UTF8", true, false)) {  
            }
import org.apache.lucene.search.spell.LevenshteinDistance;
                }
        return target;
                }  
    private void installBin(PluginInfo info, Path tmpBinDir, Path destBinDir) throws Exception {
            platform,
            if (enabled) {  
     * @param terminal       a terminal to log messages to
            }  
            }  
            );
            throw e;
import org.opensearch.common.SuppressForbidden;  
                    try (OutputStream out = Files.newOutputStream(targetFile); InputStream input = zipFile.getInputStream(entry)) {
        return zip;
                scoredKeys.add(new Tuple<>(distance, officialPlugin));
        final Map<String, List<Path>> deleteOnFailures = new LinkedHashMap<>();
    @SuppressForbidden(reason = "URL#openStream")
     */
    /**  
        return Build.CURRENT.isSnapshot();
        // Bin directory get chmod 755
     */
    }  
                    digest.update(bytes, 0, read);
        }  
            throw new UserException(ExitCodes.USAGE, "plugin '" + pluginName + "' cannot be installed as a plugin, it is a system module");
        try {
                // is still rooted with the target plugin directory.
    private final OptionSpec<String> arguments;
            urlConnection.disconnect();
    }  
    static final int PLUGIN_MALFORMED = 2;
        final Path tmpDir,  
 * this file be licensed under the Apache-2.0 license or a
                }
import java.util.Arrays;
    }
 */  
                terminal.println("-> Failed installing " + pluginId);  
            // definitely not a valid url, so assume it is a plugin name
                if (checksumReader.readLine() != null) {
        Path destLibDir,
        final boolean isSnapshot,  
                if (Files.exists(destFile) == false) {
        final String urlString,
    }
            // validate the signature has key ID matching our public key ID
            urlConnection.addRequestProperty("User-Agent", "opensearch-plugin-installer");  
                        );
    private Path unzip(Path zip, Path pluginsDir) throws IOException, UserException {  
    /** Returns all the official plugin names that look similar to pluginId. **/  
                }
                }
            if (distance > 0.7f) {  
            Build.CURRENT.getQualifiedVersion()
        try (
        if (checksumUrl == null) {
                }
                        copyDirectoryRecursively(srcFile, destFile, destConfigDirAttributes);
        URL url = URI.create(urlString).toURL();
             * file contains a single line.
        if (Files.isDirectory(tmpBinDir) == false) {  
                        copyDirectoryRecursively(srcFile, destFile, destConfigDirAttributes);
        }
            }
            throw new RuntimeException(e);
        }  
    static final Set<PosixFilePermission> CONFIG_DIR_PERMS;
import java.net.URI;
        terminal.println(VERBOSE, "Checking if url exists: " + urlString);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            while ((read = fin.read(buffer)) != -1) {
    }
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;  
     * @param urlString      the URL of the plugin ZIP  
        ) {  
                    throw new UserException(
        } catch (IllegalArgumentException e) {
        if (pluginId.contains(":") == false) {  
        }  
/*
        }
import org.opensearch.cli.UserException;
        PluginsService.verifyCompatibility(info);
        final String artifactId = coordinates[1];
        }  
                // Using the entry name as a path can result in an entry outside of the plugin dir,  
            deleteOnFailure
            String line = reader.readLine();
    }  
        return InstallPluginCommand.class.getResourceAsStream("/public_key.sig");  
    private final OptionSpec<Void> batchOption;  
        });
        } catch (IOException e) {  
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
            : null;
        }
                // this should never happen as we are using SHA-1 and SHA-512 here
                throw new AssertionError(e);
import java.nio.file.FileVisitResult;  
        public void onProgress(int percent) {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(srcDir)) {
                return FileVisitResult.CONTINUE;
            OFFICIAL_PLUGINS = Collections.unmodifiableSet(plugins);  
                if (targetFile.normalize().startsWith(target) == false) {
                    setFileAttributes(file, PLUGIN_FILES_PERMS);  
import java.util.Collections;  
    @SuppressForbidden(reason = "We use getInputStream to download plugins")
import org.opensearch.cli.Terminal;
            baseUrl = String.format(  
    static {
 *
                        PLUGIN_MALFORMED,
        );
    static final Set<PosixFilePermission> PLUGIN_DIR_PERMS;
                    }  
 * </ul>  
                while ((read = zis.read(bytes)) != -1) {
        try {
    private static void setFileAttributes(final Path path, final Set<PosixFilePermission> permissions) throws IOException {
            // ain is a input stream to the public key in ASCII-Armor format (RFC4880)
                setFileAttributes(dir, PLUGIN_DIR_PERMS);
import java.net.URLConnection;
import java.io.IOException;  
        } finally {
    static {  
                if (Files.isDirectory(srcFile)) {
 * specific language governing permissions and limitations
                modules.add(line.trim());
        PosixFileAttributeView fileAttributeView = Files.getFileAttributeView(path, PosixFileAttributeView.class);
                final byte[] bytes = new byte[8192];  
    }  
     */
        if (Files.exists(tmpBinDir)) {
import java.net.HttpURLConnection;
import java.net.URLDecoder;  
 *    http://www.apache.org/licenses/LICENSE-2.0
     * Recursively copies directory contents from source to destination.
import java.io.OutputStream;  
     * @param officialPlugin true if the plugin is an official plugin
        // Config directory get chmod 750
        // Config files get chmod 660
            if (uniquePluginIds.add(pluginId) == false) {  
            // so any installed config files are left on failure too
            Files.setPosixFilePermissions(path, permissions);
        );
                Path destFile = destDir.resolve(srcDir.relativize(srcFile));
                Files.copy(srcFile, destFile);
                pluginName
import org.opensearch.cli.ExitCodes;  
    ) throws Exception {  
        return scoredKeys.stream().map((a) -> a.v2()).collect(Collectors.toList());
     * @return an input stream to the raw bytes of the plugin ZIP.
                            fields[1]  
     *
import static org.opensearch.cli.Terminal.Verbosity.VERBOSE;  
            }  
        Files.createDirectories(destLibDir);
        ) {
                final PluginInfo pluginInfo = installPlugin(terminal, isBatch, extractedZip, env, deleteOnFailure);  
     */  
                            "checksum file at [%s] is not for this plugin, expected [%s] but was [%s]",  
        // checking for existing version of the plugin  
            checksumUrl = openUrl(checksumUrlString);
                }
            }
            }
        if (urlExists(terminal, platformUrl)) {
                        );
        // check for jar hell before any copying
        terminal.println("Plugins are packaged as zip files. Each packaged plugin must contain a plugin properties file.");
        Path destBinDir,
        if (Files.isDirectory(tmpLibDir) == false) {
            setOwnerGroup(destFile, attributes);
            }
import org.bouncycastle.openpgp.PGPPublicKey;
import org.opensearch.Version;
            final String url = getOpenSearchUrl(terminal, Version.CURRENT, isSnapshot(), pluginId, Platforms.PLATFORM_NAME);
                        success = true;  
        Path destination = PluginHelper.verifyIfPluginExists(pluginPath, pluginName);
            throw new RuntimeException(e);
import java.security.Security;  
 * The installation process first extracts the plugin files into a temporary  
                    try {
    /** Moves bin, config, and shared directories from the plugin if they exist */
             */
                    if (fields[1].equals(expectedFile) == false) {  
                line = reader.readLine();  
import org.bouncycastle.bcpg.ArmoredInputStream;
            }
            throw new UserException(ExitCodes.USAGE, "at least one plugin id is required");
                    }
import java.util.List;
    }  
            // Jimfs throws an IAE where it should throw an UOE  
                throw new AssertionError(e);  
                // normalizing the path (which removes foo/..) and ensuring the normalized entry  
    InputStream pluginZipInputStream(final Path zip) throws IOException {
                    assert read > 0 : read;  
     * <li>
                // swap the entry by plugin id for one with the installed plugin name, it gives a cleaner error message for URL installs
            Set<String> modules = new HashSet<>();
        IOUtils.rm(tmpConfigDir); // clean up what we just copied
     *  
                ? urlConnection.getInputStream()
     * <li>
                sb.append(String.join(" ", Collections.nCopies(width - currentPosition, "")));
 * files specific to the plugin. The config files be installed into a subdirectory of the
        CONFIG_FILES_PERMS = Collections.unmodifiableSet(PosixFilePermissions.fromString("rw-rw----"));  
            }
                    if (Files.isDirectory(srcFile)) {  
    private void installConfig(PluginInfo info, Path tmpConfigDir, Path destConfigDir) throws Exception {
    }
 * compatible open source license.
                sb.append(String.join("=", Collections.nCopies(currentPosition, "")));  
 * under the License.  
                    sb.append("\n");
                        final Exception exception = new Exception(
    URL openUrl(String urlString) throws IOException {
    /** Downloads a zip from the url, into a temp file under the given temp dir. */
                    throw new UserException(ExitCodes.IO_ERROR, "Invalid checksum file at " + checksumUrl);
        return String.format(Locale.ROOT, "%s/%s-%s.zip", baseUrl, artifactId, version);
            return urlConnection.getResponseCode() == 200;  
 * <p>
        if (fileAttributeView != null) {  
    }  
        // Plugins files get chmod 644
                    throw new UserException(
    }
        }
        final PluginInfo info = loadPluginInfo(terminal, tmpRoot, env);
        PluginsService.checkJarHellForPlugin(classpath, candidateInfo, candidateDir, pluginsDir, modulesDir);
    static final int PLUGIN_EXISTS = 1;  
import org.bouncycastle.openpgp.jcajce.JcaPGPObjectFactory;
    /** Copies the files from {@code tmpBinDir} into {@code destBinDir}, along with permissions from dest dirs parent. */
                    || (Constants.MAC_OS_X && "MacOS".equals(parentDirName))) {  
            IOUtils.rm(target);
            baseUrl,
import org.opensearch.common.util.io.IOUtils;
    @SuppressForbidden(reason = "Make HEAD request using URLConnection.connect()")
     * content length might be -1 for unknown and progress only makes sense if the content length is greater than 0
        }
import org.bouncycastle.openpgp.PGPSignature;
            InputStream fin = pluginZipInputStream(zip);
                if (expectedChecksum.equals(actualChecksum) == false) {
        final String baseUrl = String.format(Locale.ROOT, "https://repo1.maven.org/maven2/%s/%s/%s", groupId, artifactId, version);  
    /**
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(tmpBinDir)) {  
        }
                "Warning: sha512 not found, falling back to sha1. This behavior is deprecated and will be removed in a "  
        Files.delete(zip);
                    Files.createDirectories(targetFile.getParent());  
            String line = reader.readLine();  
                final String[] fields = checksumLine.split(" {2}");  
 * </ul>
                deleteOnFailures.put(pluginInfo.getName(), deleteOnFailure);
        // scan all the installed plugins to see if the plugin being installed already exists
            final PGPPublicKeyRingCollection collection = new PGPPublicKeyRingCollection(ain, new JcaKeyFingerprintCalculator());
     * For an official plugin we download the SHA-512 checksum and validate the integrity of the downloaded ZIP. We also download the
import java.util.Map;  
 * <li>An official opensearch plugin name</li>
    }  
            installConfig(info, tmpConfigDir, destConfigDir);
        // TODO: no jars should be an error  
        } catch (IOException e) {
        URL url = URI.create(urlString).toURL();
            if (getPublicKeyId().equals(keyId) == false) {  
                final BufferedReader checksumReader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
    static final Set<PosixFilePermission> CONFIG_FILES_PERMS;  
 * software distributed under the License is distributed on an
                    } else {
    private InputStream urlOpenStream(final URL url) throws IOException {  
            env.binDir().resolve(targetFolderName),
        final URL sigUrl = openUrl(sigUrlString);
            checksumUrlString = urlString + ".sha1";  
            Security.addProvider(new BouncyCastleFipsProvider());
import org.opensearch.common.bootstrap.JarHell;
                    boolean success = false;  
            if (elements.length >= 1
                        copyWithPermissions(srcFile, destFile, CONFIG_FILES_PERMS, destConfigDirAttributes);
                int currentPosition = percent * width / 100;
                setFileAttributes(destFile, PLUGIN_FILES_PERMS);  
    void verifySignature(final Path zip, final String urlString) throws IOException, PGPException {
            byte[] buffer = new byte[8192];  
    protected void printAdditionalHelp(Terminal terminal) {
                && elements[0].getMethodName().equals("setAttributeInternal")) {
    }
             * is a single-line file containing the SHA-512 and the filename, separated by two spaces. For SHA-1, we verify that the hash
                expectedChecksum = fields[0];
        try (
        PluginSecurity.confirmPolicyExceptions(terminal, permissions, isBatch);
                    throw new UserException(  
            int read;
                        PLUGIN_MALFORMED,  
import org.apache.commons.compress.archivers.zip.ZipFile;
        terminal.println("The install command takes a plugin id, which may be any of the following:");  
     * @throws IOException  if an I/O exception occurs reading from various input streams
            terminal.println(
        }
    }
        }  
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(tmpConfigDir)) {
        }  
            if (plugins.isEmpty() == false) {
        return Files.newInputStream(zip);  
    void execute(Terminal terminal, List<String> pluginIds, boolean isBatch, Environment env) throws Exception {
            throw new UserException(PLUGIN_MALFORMED, "shared in plugin " + info.getName() + " is not a directory");  
                    throw new UserException(ExitCodes.IO_ERROR, "Invalid checksum file at " + checksumUrl);  
import joptsimple.OptionSet;
import org.opensearch.env.Environment;  
     * <p>
        setFileAttributes(destLibDir, PLUGIN_DIR_PERMS);  
 * A command for the plugin cli to install a plugin into opensearch.  
import java.security.MessageDigest;
     */
     * Creates a URL and opens a connection.
import org.bouncycastle.jcajce.provider.BouncyCastleFipsProvider;  
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(tmpLibDir)) {
 *
                deleteOnFailures.put(pluginId, deleteOnFailure);
                final List<Path> deleteOnFailure = new ArrayList<>();  
        Objects.requireNonNull(attributes);  
            "%s/%s-%s-%s.zip",
                    );
        if (pluginIds.isEmpty()) {  
        terminal.println(VERBOSE, "Retrieving zip from " + urlString);  
                    final String expectedFile = segments[segments.length - 1];
        return String.format(Locale.ROOT, "%s/%s-%s.zip", baseUrl, pluginId, Build.CURRENT.getQualifiedVersion());
        } finally {
    boolean isSnapshot() {
        ) {
                    }
     */  
            setOwnerGroup(destConfigDir, destConfigDirAttributes);
                        copyWithPermissions(srcFile, destFile, CONFIG_FILES_PERMS, destConfigDirAttributes);  
                Path targetFile = target.resolve(entry.getName());
     * @param urlString the URL source of the downloade plugin ZIP
            } else {  
        terminal.println("");  
import org.opensearch.plugins.Platforms;
 * <li>Jar hell does not exist, either between the plugin's own jars, or with opensearch</li>  
        jarHellCheck(info, pluginRoot, env.pluginsDir(), env.modulesDir());
    }
                        installProblem.addSuppressed(exception);  
        final Version version,
 * Plugins are packaged as zip files. Each packaged plugin must contain a plugin properties file.  
                }  
                    } catch (final IOException exceptionWhileRemovingFiles) {
            installLib(info, tmpLibDir, destLibDir);
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPContentVerifierBuilderProvider;  
     */
    }
            Locale.ROOT,  
            urlConnection.connect();
        if (Files.exists(tmpConfigDir)) {
                if (entry.getName().startsWith("opensearch/")) {  
            signature.init(new JcaPGPContentVerifierBuilderProvider().setProvider("BCFIPS"), key);
                }
        // List official opensearch plugin names
            } catch (final NoSuchAlgorithmException e) {
        try {  
        Path zip = Files.createTempFile(tmpDir, null, ".zip");
        if (Files.exists(policy)) {
            urlConnection.setRequestMethod("HEAD");
                    throw new UserException(
        }
            final byte[] buffer = new byte[1024];  
     * downloaded ZIP.
        this.batchOption = parser.acceptsAll(
    /** The plugin zip is not properly structured. */
            public FileVisitResult postVisitDirectory(final Path dir, final IOException exc) throws IOException {  
        String targetFolderName = info.getTargetFolderName();  
                        copyWithPermissions(srcFile, destFile, CONFIG_DIR_PERMS, destConfigDirAttributes);
                } else {
        } catch (UserException e) {  
     * The given url must be {@code https} and existing means a {@code HEAD} request returns 200.
            );  
        List<Tuple<Float, String>> scoredKeys = new ArrayList<>();  
 */
    private PluginInfo installPlugin(Terminal terminal, boolean isBatch, Path tmpRoot, Environment env, List<Path> deleteOnFailure)
            // finally we verify the signature of the downloaded plugin zip matches the expected signature  
    /** Load information about the plugin, and verify it can be installed with no errors. */
                    }
            final Enumeration<? extends ZipArchiveEntry> entries = zipFile.getEntries();
    ) throws IOException, PGPException, UserException {  
        PosixFileAttributes attributes  
            while (entries.hasMoreElements()) {
        this.arguments = parser.nonOptions("plugin <name|Zip File|URL>");  
                            Locale.ROOT,
 * <p>
                if (!Files.isSymbolicLink(targetFile.getParent())) {
    private Path stagingDirectory(Path pluginsDir) throws IOException {
                    if (success) {  
    // pkg private for tests  
                if (fields.length == 2) {
        final String pluginId,
        final String platformUrl = String.format(Locale.ROOT, "%s/%s-%s-%s.zip", baseUrl, artifactId, platform, version);
import org.apache.lucene.util.CollectionUtil;  
        terminal.println("  A local zip file");
                plugins.add(line.trim());  
     * If the plugin has a bin dir and/or a config dir, those are moved.  
import java.util.ArrayList;
    String getPublicKeyId() {
        }
        movePlugin(tmpRoot, destination);  
                final MessageDigest digest = MessageDigest.getInstance(digestAlgo);
    static {  
                final String parentDirName = file.getParent().getFileName().toString();  
    private static void setOwnerGroup(final Path path, final PosixFileAttributes attributes) throws IOException {
        }
    /** Returns the url for an opensearch plugin in maven. */
     * @param tmpDir         a temporary directory to write downloaded files to
        final PluginInfo info = PluginInfo.readFromProperties(pluginRoot);  
package org.opensearch.tools.cli.plugin;
                        IOUtils.rm(deleteOnFailureEntry.getValue().toArray(new Path[0]));
            this.enabled = expectedTotalSize > 0;
        verifyPluginName(env.pluginsDir(), info.getName());
    @Override
            baseUrl = String.format(
