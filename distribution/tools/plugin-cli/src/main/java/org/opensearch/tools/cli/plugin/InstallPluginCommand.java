        installPluginSupportFiles(
import java.util.Locale;
 * <ul>
     * @return the public key ID
        PluginInfo info,
    static final Set<String> OFFICIAL_PLUGINS;
                    );
        if (officialPlugin) {
    }
                deleteOnFailures.remove(pluginId);
                        copyWithPermissions(srcFile, destFile, CONFIG_FILES_PERMS, destConfigDirAttributes);
            if (plugins.isEmpty() == false) {
        }
        // Bin files also get chmod 755
                StringBuilder sb = new StringBuilder("\r[");
                } else {
        PosixFileAttributeView fileAttributeView = Files.getFileAttributeView(path, PosixFileAttributeView.class);
        HttpURLConnection connection = (HttpURLConnection) checksumUrl.openConnection();
            }
import org.opensearch.plugins.Platforms;
        if (isSnapshot == true) {
            throw new UserException(ExitCodes.USAGE, "at least one plugin id is required");
            destConfigDir.getParent(),
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(srcDir)) {
                final PluginInfo pluginInfo = installPlugin(terminal, isBatch, extractedZip, env, deleteOnFailure);
    private String getMavenUrl(Terminal terminal, String[] coordinates, String platform) throws IOException {
 * software distributed under the License is distributed on an
     */
        }
                while ((read = zis.read(bytes)) != -1) {
        }
            }
    void execute(Terminal terminal, List<String> pluginIds, boolean isBatch, Environment env) throws Exception {
    static final Set<PosixFilePermission> BIN_DIR_PERMS;
            info,
    }
        }
        // fall back to plain old URL
        if (pluginId.contains(":") == false) {
            OFFICIAL_PLUGINS = Collections.unmodifiableSet(plugins);
                }
import org.opensearch.Version;
 */
        for (final String pluginId : pluginIds) {
                        "Directories not allowed in bin dir " + "for plugin " + info.getName() + ", found " + srcFile.getFileName()
            digestAlgo = "SHA-1";
     * @return an input stream to the raw bytes of the plugin ZIP.
        } catch (IOException e) {
    /**
                throw new IllegalStateException("signature verification for [" + urlString + "] failed");
                final Path extractedZip = unzip(pluginZip, env.pluginsDir());
                    + "future release. Please update the plugin to use a sha512 checksum."
    /**
import org.apache.lucene.util.Constants;
 * <li>An official opensearch plugin name</li>
package org.opensearch.tools.cli.plugin;
        }
                throw e;
        fileAttributeView.setGroup(attributes.group());
                return stagingDirectoryWithoutPosixPermissions(pluginsDir);
 */
        final String groupId = coordinates[0].replace(".", "/");
        );
        final String sigUrlString = urlString + ".sig";
import org.bouncycastle.openpgp.PGPPublicKey;
    URL openUrl(String urlString) throws IOException {
        }
            throw new UserException(ExitCodes.USAGE, msg);
}
    private PluginInfo installPlugin(Terminal terminal, boolean isBatch, Path tmpRoot, Environment env, List<Path> deleteOnFailure)
    @Override
            final byte[] buffer = new byte[1024];
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(tmpConfigDir)) {
import static org.opensearch.cli.Terminal.Verbosity.VERBOSE;
                if (targetFile.normalize().startsWith(target) == false) {
        return info;
     * An input stream to the public key of the signing key.
 * <li>If the plugin contains extra security permissions, the policy file is validated</li>
            @Override
                final MessageDigest digest = MessageDigest.getInstance(digestAlgo);
     * The given url must be {@code https} and existing means a {@code HEAD} request returns 200.
        }
                }
import java.util.Set;
        final PluginInfo info = loadPluginInfo(terminal, tmpRoot, env);
        return String.format(Locale.ROOT, "%s/%s-%s.zip", baseUrl, pluginId, Build.CURRENT.getQualifiedVersion());
        try (InputStream zis = Files.newInputStream(zip)) {
import java.nio.file.StandardCopyOption;
    private static void copyDirectoryRecursively(Path srcDir, Path destDir, PosixFileAttributes destConfigDirAttributes)
        ) {
        }
     * @param zip       the path to the downloaded plugin ZIP
        }
     * @throws IOException if an I/O exception occurs preparing the input stream
    }
            );
                        IOUtils.rm(deleteOnFailureEntry.getValue().toArray(new Path[0]));
                int currentPosition = percent * width / 100;
    }
     * @param urlString the URL source of the downloade plugin ZIP
        // Bin directory get chmod 755
        return url.openStream();
        Files.createDirectories(destBinDir);
    static {
     * @param urlString      the URL of the plugin ZIP
        final String version = coordinates[2];
                    throw new UserException(
     * @throws IOException   if an I/O exception occurs download or reading files and resources
        if (Files.isDirectory(tmpLibDir) == false) {
            }
        }
        String checksumUrlString = urlString + ".sha512";
        } finally {
 * <ul>
                        "Directories not allowed in shared dir for plugin " + info.getName() + ", found " + srcFile.getFileName()
                    if (Files.isDirectory(srcFile)) {
    }
                : new TerminalProgressInputStream(urlConnection.getInputStream(), urlConnection.getContentLength(), terminal)
            // fallback to sha1, until 7.0, but with warning
import java.nio.file.attribute.PosixFilePermissions;
            throw new UserException(PLUGIN_MALFORMED, "shared in plugin " + info.getName() + " is not a directory");
            env.configDir().resolve(targetFolderName),
    private InputStream urlOpenStream(final URL url) throws IOException {
            // Jimfs throws an IAE where it should throw an UOE
        Files.move(tmpRoot, destination, StandardCopyOption.ATOMIC_MOVE);
                        terminal.println("-> Rolled back " + deleteOnFailureEntry.getKey());
        PluginsService.verifyCompatibility(info);
     * @param officialPlugin true if the plugin is an official plugin
    private void installConfig(PluginInfo info, Path tmpConfigDir, Path destConfigDir) throws Exception {
    public void close() throws IOException {
            pluginId,
        List<Path> deleteOnFailure
        assert fileAttributeView != null;
            while ((read = fin.read(buffer)) != -1) {
            final String url = getOpenSearchUrl(terminal, Version.CURRENT, isSnapshot(), pluginId, Platforms.PLATFORM_NAME);
            try {
                    terminal.println("-> Rolling back " + deleteOnFailureEntry.getKey());
import java.nio.file.Files;
        try {
            } catch (final Exception installProblem) {
        final String urlString,
                if (officialPlugin && fields.length != 2 || officialPlugin == false && fields.length > 2) {
                setFileAttributes(destFile, BIN_FILES_PERMS);
        } catch (UnsupportedOperationException e) {
        setFileAttributes(destLibDir, PLUGIN_DIR_PERMS);
    }
    }
            final PGPPublicKey key = collection.getPublicKey(signature.getKeyID());
import org.bouncycastle.jcajce.provider.BouncyCastleFipsProvider;
        try (
import java.security.NoSuchAlgorithmException;
            }
        // List official opensearch plugin names
                        );
            terminal.println("-> Installing " + pluginId);
        final PosixFileAttributeView destConfigDirAttributesView = Files.getFileAttributeView(
                pluginId,
            );
        final Terminal terminal,
                if (checksumReader.readLine() != null) {
            }
            permissions = Collections.emptySet();
/*
                expectedChecksum = checksumReader.readLine();
     * @param terminal       a terminal to log messages to
    @SuppressForbidden(reason = "We use getInputStream to download plugins")
        }
            throw e;
            urlConnection.addRequestProperty("User-Agent", "opensearch-plugin-installer");
                return url.toURI().getPath().matches(LIB_TOOLS_PLUGIN_CLI_CLASSPATH_JAR) == false;
                if (Files.isDirectory(srcFile)) {
            InputStream in = isBatch
     * <ul>
             */
        }
        verifyPluginName(env.pluginsDir(), info.getName());
    }
        IOUtils.rm(tmpBinDir); // clean up what we just copied
        }
        try (InputStream in = urlOpenStream(checksumUrl)) {
            return downloadAndValidate(terminal, mavenUrl, tmpDir, false, isBatch);
    InputStream pluginZipInputStream(final Path zip) throws IOException {
     * If the URL returns a 404, {@code null} is returned, otherwise the open URL opject is returned.
    }
        }
        }
        final Set<URL> classpath = JarHell.parseClassPath().stream().filter(url -> {
                    } catch (final IOException exceptionWhileRemovingFiles) {
            for (Path srcFile : stream) {
                sb.append(String.join(" ", Collections.nCopies(width - currentPosition, "")));
            signature.init(new JcaPGPContentVerifierBuilderProvider().setProvider("BCFIPS"), key);
 * <li>Maven coordinates to a plugin zip</li>
            baseUrl = String.format(
                final String parentDirName = file.getParent().getFileName().toString();
                Files.copy(srcFile, destFile);
import java.net.HttpURLConnection;
            connection.disconnect();
        }
                Locale.ROOT,
        if (MODULES.contains(pluginName)) {
import org.opensearch.common.hash.MessageDigests;
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(tmpBinDir)) {
        // either with the plugin name or a custom folder name
                Locale.ROOT,
import org.bouncycastle.openpgp.PGPException;
                            Locale.ROOT,
        urlConnection.addRequestProperty("User-Agent", "opensearch-plugin-installer");
                        PLUGIN_MALFORMED,
                msg += ", did you mean " + (plugins.size() == 1 ? "[" + plugins.get(0) + "]" : "any of " + plugins.toString()) + "?";
            InputStream sin = urlOpenStream(sigUrl);
    // pkg private for tests
        }
        jarHellCheck(info, pluginRoot, env.pluginsDir(), env.modulesDir());
    /** Copies the files from {@code tmpBinDir} into {@code destBinDir}, along with permissions from dest dirs parent. */
        terminal.println("");
                "plugin directory [%s] already exists; if you need to update the plugin, " + "uninstall it first using command 'remove %s'",
    }
        Path destConfigDir,
        final boolean officialPlugin,
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cli.ExitCodes;
            return downloadAndValidate(terminal, url, tmpDir, true, isBatch);
            // validate the signature has key ID matching our public key ID
        return String.format(Locale.ROOT, "%s/%s-%s.zip", baseUrl, artifactId, version);
            "Enable batch mode explicitly, automatic confirmation of security permission"
            }
        Path policy = tmpRoot.resolve(PluginInfo.OPENSEARCH_PLUGIN_POLICY);
        }
    static final Set<PosixFilePermission> CONFIG_DIR_PERMS;
    /** Load information about the plugin, and verify it can be installed with no errors. */
        );
     * <li>
     */
            terminal.println("  " + plugin);
 */
            if (getPublicKeyId().equals(keyId) == false) {
        terminal.println("Plugins are packaged as zip files. Each packaged plugin must contain a plugin properties file.");
     * </li>
 *
    /**
     * If the plugin has a bin dir and/or a config dir, those are moved.
            terminal.println(
     * Sets the attributes for a path iff posix attributes are supported
import java.net.URI;
    private void installLib(PluginInfo info, Path tmpLibDir, Path destLibDir) throws Exception {
            final PGPSignature signature = ((PGPSignatureList) factory.nextObject()).get(0);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * An input stream to the raw bytes of the plugin ZIP.
import org.bouncycastle.openpgp.PGPUtil;
            if (uniquePluginIds.add(pluginId) == false) {
            /*
                    );
        // List possible plugin id inputs
                    throw new UserException(
                }
        final URL sigUrl = openUrl(sigUrlString);
                    setFileAttributes(file, BIN_FILES_PERMS);
        terminal.println("");
            }
 * </ul>
                    }
        try (
    private void movePlugin(Path tmpRoot, Path destination) throws IOException {
            }
 * The OpenSearch Contributors require contributions made to
            throw new UserException(PLUGIN_MALFORMED, "config in plugin " + info.getName() + " is not a directory");
            }
    static final int PLUGIN_MALFORMED = 2;
        execute(terminal, pluginId, isBatch, env);
                if (Files.isDirectory(srcFile)) {
 * Licensed to Elasticsearch under one or more contributor
        );
import org.opensearch.common.bootstrap.JarHell;
                throw new IllegalStateException("key id [" + keyId + "] does not match expected key id [" + getPublicKeyId() + "]");
    void jarHellCheck(PluginInfo candidateInfo, Path candidateDir, Path pluginsDir, Path modulesDir) throws Exception {
        }
            if (signature.verify() == false) {
        // TODO: no jars should be an error
            tmpRoot,
import java.net.URISyntaxException;
            );
    static {
                        final String message = String.format(
            int read;
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8))
                        PLUGIN_MALFORMED,
                "https://artifacts.opensearch.org/releases/plugins/%s/%s",
                        PLUGIN_MALFORMED,
    @SuppressForbidden(reason = "Make HEAD request using URLConnection.connect()")
                }
     * For a non-official plugin we download the SHA-512 checksum and fallback to the SHA-1 checksum and validate the integrity of the
 * The install command takes a plugin id, which may be any of the following:
        terminal.println("  Maven coordinates to a plugin zip");
                }
                if (!Files.isSymbolicLink(targetFile.getParent())) {
import org.opensearch.plugins.PluginInfo;
        final PluginInfo info = PluginInfo.readFromProperties(pluginRoot);
            final JcaPGPObjectFactory factory = new JcaPGPObjectFactory(PGPUtil.getDecoderStream(sin));
    }
            return urlConnection.getResponseCode() == 200;
     * Creates a URL and opens a connection.
import java.util.List;
                        "This plugin was built with an older plugin structure."
    /**
        return downloadZip(terminal, pluginId, tmpDir, isBatch);
    }
    /**
    // pkg private for tests
     * Returns {@code true} if the given url exists, and {@code false} otherwise.
    }
                // either if the name starts with the root of the filesystem, or it is a relative
    }
                final String actualChecksum = MessageDigests.toHexString(digest.digest());
        // scan all the installed plugins to see if the plugin being installed already exists
     */
import java.util.TreeSet;
     * Recursively copies directory contents from source to destination.
                return FileVisitResult.CONTINUE;
        pathsToDeleteOnShutdown.add(zip);
    ) throws Exception {
        List<Tuple<Float, String>> scoredKeys = new ArrayList<>();
import java.io.InputStreamReader;
import java.util.stream.Collectors;
 * A plugin may also contain an optional {@code bin} directory which contains scripts. The
            } catch (final URISyntaxException e) {
import java.net.URLConnection;
                        input.transferTo(out);
        } finally {
                Locale.ROOT,
    @Override
        }
            if (distance > 0.7f) {
        Files.createDirectories(destConfigDir);
 * already exist, they will be skipped.
import java.security.Security;
    private static final String LIB_TOOLS_PLUGIN_CLI_CLASSPATH_JAR;
import java.io.InputStream;
import org.opensearch.common.cli.EnvironmentAwareCommand;
        URL checksumUrl = URI.create(urlString).toURL();
                    throw new UserException(
    }
        // they might be unavoidably in maven central and are packaged up the same way)
            ZipArchiveEntry entry;
        private final boolean enabled;
     * Installs the plugin from {@code tmpRoot} into the plugins dir.
     * Copies a file and sets permissions and ownership
        Path destination = PluginHelper.verifyIfPluginExists(pluginPath, pluginName);
 * Unless required by applicable law or agreed to in writing,
        movePlugin(tmpRoot, destination);
            urlConnection.disconnect();
            for (Path srcFile : stream) {
 * See {@link PluginInfo}.
                setFileAttributes(dir, PLUGIN_DIR_PERMS);
        CONFIG_FILES_PERMS = Collections.unmodifiableSet(PosixFilePermissions.fromString("rw-rw----"));
            for (Path srcFile : stream) {
            Security.addProvider(new BouncyCastleFipsProvider());
    static final Set<PosixFilePermission> PLUGIN_FILES_PERMS;
                        ExitCodes.IO_ERROR,
            MODULES = Collections.unmodifiableSet(modules);
 * <li>Jar hell does not exist, either between the plugin's own jars, or with opensearch</li>
    private String getOpenSearchUrl(
    /** Downloads a zip from the url, into a temp file under the given temp dir. */
            Files.setPosixFilePermissions(path, permissions);
                    digest.update(bytes, 0, read);
        if (attributes != null) {
                if (entry.isDirectory() == false) {
            baseUrl,
            }
    }
            String line = reader.readLine();
                        terminal.println("-> Failed rolling back " + deleteOnFailureEntry.getKey());
        if (info.hasNativeController()) {
    ) throws IOException {
    boolean isSnapshot() {
            : null;
        PLUGIN_FILES_PERMS = Collections.unmodifiableSet(PosixFilePermissions.fromString("rw-r--r--"));
                }
        final String artifactId = coordinates[1];
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
        Files.copy(srcFile, destFile);
                "Warning: sha512 not found, falling back to sha1. This behavior is deprecated and will be removed in a "
            }
        // now try as maven coordinates, a valid URL would only have a colon and slash
                }
                modules.add(line.trim());
    @SuppressForbidden(reason = "URL#openStream")
        final boolean isBatch = options.has(batchOption);
            IOUtils.rm(target);
 * KIND, either express or implied.  See the License for the
        for (final String pluginId : pluginIds) {
            // definitely not a valid url, so assume it is a plugin name
     * @throws PGPException if the PGP implementation throws an internal exception during verification
                terminal.print(Terminal.Verbosity.NORMAL, String.format(Locale.ROOT, sb.toString(), percent + "%"));
        String[] coordinates = pluginId.split(":");
     */
            // sin is a URL stream to the signature corresponding to the downloaded plugin zip
            installConfig(info, tmpConfigDir, destConfigDir);
        try (
 * files specific to the plugin. The config files be installed into a subdirectory of the
                if (Files.exists(destFile) == false) {
                    boolean success = false;
                // before their children (although this makes sense, but is it guaranteed?)
    static final int PLUGIN_EXISTS = 1;
 * GitHub history for details.
    ) throws IOException, UserException {
        this.arguments = parser.nonOptions("plugin <name|Zip File|URL>");
            deleteOnFailure.add(destLibDir);
            while (line != null) {
        final String pluginId,
        terminal.println(VERBOSE, info.toString());
     *
    /** check a candidate plugin for jar hell before installing it */
    private final OptionSpec<String> arguments;
    private class TerminalProgressInputStream extends ProgressInputStream {
            platform,
                signature.update(buffer, 0, read);
        setFileAttributes(destFile, permissions);
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
                }
import java.nio.charset.StandardCharsets;
                        copyDirectoryRecursively(srcFile, destFile, destConfigDirAttributes);
            ? destConfigDirAttributesView.readAttributes()
    }
        Path tmpLibDir = tmpRoot.resolve("shared");
        BIN_FILES_PERMS = BIN_DIR_PERMS;
        Path tmpBinDir = tmpRoot.resolve("bin");
        }
     */
import java.nio.file.attribute.PosixFileAttributes;
        }
            }
                }
     * <p>
        Objects.requireNonNull(attributes);
            // remove when google/jimfs#30 is integrated into Jimfs
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPContentVerifierBuilderProvider;
    /** The plugin zip is not properly structured. */
 * scripts will be installed into a subdirectory of the opensearch bin directory, using
            // compute the signature of the downloaded plugin zip
     * ".sig" to the URL. It is expected that the plugin is signed with the OpenSearch Release signing key with ID 4E9275EE6BA2427F for 3.0.0 or above.
                        final Exception exception = new Exception(
        Path destFile,
                final byte[] bytes = new byte[8192];
/**
    private Path stagingDirectoryWithoutPosixPermissions(Path pluginsDir) throws IOException {
        if (Files.exists(tmpConfigDir)) {
                    if (Files.isDirectory(srcFile)) {
        }
import java.nio.file.SimpleFileVisitor;
    InstallPluginCommand() {
            return platformUrl;
            final PGPPublicKeyRingCollection collection = new PGPPublicKeyRingCollection(ain, new JcaKeyFingerprintCalculator());
                Build.CURRENT.getQualifiedVersion()
                destination,
            final String keyId = Long.toHexString(signature.getKeyID()).toUpperCase(Locale.ROOT);
        for (String officialPlugin : OFFICIAL_PLUGINS) {
            try {
                    throw new UserException(
                Path destFile = destConfigDir.resolve(tmpConfigDir.relativize(srcFile));
        if (urlExists(terminal, platformUrl)) {
import java.nio.file.attribute.BasicFileAttributes;
                setFileAttributes(destFile, PLUGIN_FILES_PERMS);
                if (expectedChecksum.equals(actualChecksum) == false) {
 * You may obtain a copy of the License at
        this.batchOption = parser.acceptsAll(
    private Path unzip(Path zip, Path pluginsDir) throws IOException, UserException {
        Path tmpRoot,
        if (pluginIds.isEmpty()) {
     * </li>
        throws Exception {
        }).collect(Collectors.toSet());
            this.terminal = terminal;
        // create list of current jars in classpath
    private static void setOwnerGroup(final Path path, final PosixFileAttributes attributes) throws IOException {
 * Plugins are packaged as zip files. Each packaged plugin must contain a plugin properties file.
        final String platformUrl = String.format(
    }
            checksumUrlString = urlString + ".sha1";
                throw installProblem;
                throw new AssertionError(e);
                    throw new UserException(
            throw new UserException(PLUGIN_EXISTS, message);
                final Path pluginZip = download(terminal, pluginId, env.tmpDir(), isBatch);
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(tmpLibDir)) {
        ) {
            urlConnection.connect();
    /**
    }
                terminal.println("-> Installed " + pluginInfo.getName() + " with folder name " + pluginInfo.getTargetFolderName());
        }
    private void verifyPluginName(Path pluginPath, String pluginName) throws UserException, IOException {
                // be on the safe side: do not rely on that directories are always extracted
    }
 * not use this file except in compliance with the License.
import org.bouncycastle.openpgp.jcajce.JcaPGPObjectFactory;
     *
        if (Files.exists(destination)) {
                    try (OutputStream out = Files.newOutputStream(targetFile); InputStream input = zipFile.getInputStream(entry)) {
import java.util.Enumeration;
                        throw new UserException(ExitCodes.IO_ERROR, message);
                    || (Constants.MAC_OS_X && "MacOS".equals(parentDirName))) {
        if (checksumUrl == null && officialPlugin == false) {
                // Using the entry name as a path can result in an entry outside of the plugin dir,
    static {
        setFileAttributes(destConfigDir, CONFIG_DIR_PERMS);
        final String platform
     * armored signature and validate the authenticity of the downloaded ZIP.
        final String baseUrl;
        return scoredKeys.stream().map((a) -> a.v2()).collect(Collectors.toList());
            public FileVisitResult visitFile(final Path file, final BasicFileAttributes attrs) throws IOException {
    /** A plugin with the same name is already installed. */
     * content length might be -1 for unknown and progress only makes sense if the content length is greater than 0
                            exceptionWhileRemovingFiles
 */
    private final List<Path> pathsToDeleteOnShutdown = new ArrayList<>();
        PosixFileAttributes attributes
    }
                    );
 * directory in order to verify the plugin satisfies the following requirements:
                pluginId,
import java.util.ArrayList;
import org.bouncycastle.openpgp.PGPSignatureList;
                    }
    /** Returns the url for an official opensearch plugin. */
        // unzip plugin to a staging temp dir
     * Verify the signature of the downloaded plugin ZIP. The signature is obtained from the source of the downloaded plugin by appending
                ? urlConnection.getInputStream()
                    // streams will be auto-closed with try-with-resources
        String targetFolderName = info.getTargetFolderName();
    }
import org.opensearch.common.collect.Tuple;
                Path destFile = destDir.resolve(srcDir.relativize(srcFile));
            InputStream stream = InstallPluginCommand.class.getResourceAsStream("/plugins.txt");
        }
                if (Files.exists(destFile) == false) {
                    }
        // Config files get chmod 660
            Files.copy(in, zip, StandardCopyOption.REPLACE_EXISTING);
        LevenshteinDistance ld = new LevenshteinDistance();
        } catch (IOException e) {
    static final Set<String> MODULES;
import java.nio.file.DirectoryStream;
    static final Set<PosixFilePermission> PLUGIN_DIR_PERMS;
        }
        }
        // don't let user install plugin conflicting with module...
        } catch (UserException e) {
                        digestAlgo + " mismatch, expected " + expectedChecksum + " but got " + actualChecksum
            PosixFileAttributeView.class
    /**
import java.util.LinkedHashMap;
                plugins.add(line.trim());
                    );
                line = reader.readLine();
            // some files may already exist, and we don't remove plugin config files on plugin removal,
        terminal.println("-> Downloading " + URLDecoder.decode(pluginId, "UTF-8"));
        TerminalProgressInputStream(InputStream is, int expectedTotalSize, Terminal terminal) {
    /**
     * @throws UserException if checksum validation fails
        URL checksumUrl = openUrl(checksumUrlString);
            }
import org.opensearch.plugins.PluginsService;
        });
                deleteOnFailures.put(pluginId, deleteOnFailure);
                        );
     * @throws PGPException  if an exception occurs verifying the downloaded ZIP signature
                }
        URL url = URI.create(urlString).toURL();
        boolean isBatch
            final StackTraceElement[] elements = e.getStackTrace();
import java.io.BufferedReader;
     * @param isBatch        true if the install is running in batch mode
                line = reader.readLine();
 * <li>The plugin is not a module already provided with opensearch</li>
            super(is, expectedTotalSize);
            throw new RuntimeException(e);
     */
                    setFileAttributes(file, PLUGIN_FILES_PERMS);
                if (checksumReader.readLine() != null) {
        setFileAttributes(destBinDir, BIN_DIR_PERMS);
 * ownership. Elasticsearch licenses this file to you under
        return InstallPluginCommand.class.getResourceAsStream("/public_key.sig");
     */
     *
import java.nio.file.FileVisitResult;
        PluginsService.checkJarHellForPlugin(classpath, candidateInfo, candidateDir, pluginsDir, modulesDir);
import java.util.Arrays;
        return Files.createTempDirectory(pluginsDir, ".installing-");
            urlConnection.setRequestMethod("HEAD");
    private void installBin(PluginInfo info, Path tmpBinDir, Path destBinDir) throws Exception {
        if (Files.isDirectory(tmpConfigDir) == false) {
                    }
        }
                        PLUGIN_MALFORMED,
                final List<Path> deleteOnFailure = new ArrayList<>();
 * the name of the plugin, and the scripts will be marked executable.
 * the Apache License, Version 2.0 (the "License"); you may
            // so any installed config files are left on failure too
    }
        if (checksumUrl == null) {
                throw new UserException(ExitCodes.USAGE, "duplicate plugin id [" + pluginId + "]");
     * @return the path to the downloaded plugin ZIP
import org.apache.lucene.util.CollectionUtil;
        CollectionUtil.timSort(scoredKeys, (a, b) -> b.v1().compareTo(a.v1()));
    /**
class InstallPluginCommand extends EnvironmentAwareCommand {
            } else {
     * Any files existing in both the source and destination will be skipped.
        // checking for existing version of the plugin
        );
     * @throws IOException  if an I/O exception occurs reading from various input streams
        // read optional security policy (extra permissions), if it exists, confirm or warn the user
                    );
        pathsToDeleteOnShutdown.add(target);
                    Files.createDirectories(targetFile.getParent());
        }
        // read the bytes of the plugin zip in chunks to avoid out of memory errors
            if (digestAlgo.equals("SHA-1")) {
        URLConnection urlConnection = url.openConnection();
import org.opensearch.cli.Terminal;
            terminal.println("-> Downloading " + pluginId + " from opensearch");
     *
                entry = entries.nextElement();
        ) {
                final String checksumLine = checksumReader.readLine();
        terminal.println(VERBOSE, "Checking if url exists: " + urlString);
            throw new RuntimeException(e);
                        copyWithPermissions(srcFile, destFile, CONFIG_DIR_PERMS, destConfigDirAttributes);
 * <p>
        final Terminal terminal,
    private Path stagingDirectory(Path pluginsDir) throws IOException {
    /** The builtin modules, which are plugins, but cannot be installed or removed. */
        Files.createDirectories(destLibDir);
        Path destBinDir,
            Arrays.asList("b", "batch"),
                }
    private void installPluginSupportFiles(
        Path destLibDir,
            installBin(info, tmpBinDir, destBinDir);
    protected void execute(Terminal terminal, OptionSet options, Environment env) throws Exception {
    private final OptionSpec<Void> batchOption;
                Path targetFile = target.resolve(entry.getName());
            for (Path srcFile : stream) {
    }
    Path downloadZip(Terminal terminal, String urlString, Path tmpDir, boolean isBatch) throws IOException {
        Path tmpConfigDir = tmpRoot.resolve("config");
            final Enumeration<? extends ZipArchiveEntry> entries = zipFile.getEntries();
                "https://artifacts.opensearch.org/snapshots/plugins/%s/%s",
        Files.delete(zip);
            InputStream stream = InstallPluginCommand.class.getResourceAsStream("/modules.txt");
    boolean urlExists(Terminal terminal, String urlString) throws IOException {
        Path srcFile,
import java.net.URL;
                    try {
        final Map<String, List<Path>> deleteOnFailures = new LinkedHashMap<>();
import org.opensearch.cli.UserException;
    private List<String> checkMisspelledPlugin(String pluginId) {
            return checksumUrl;
        try (
        @Override
    private static void setFileAttributes(final Path path, final Set<PosixFilePermission> permissions) throws IOException {
            "%s/%s-%s-%s.zip",
        }
                if (currentPosition > 0 && percent < 100) {
        terminal.println("  A local zip file");
            String mavenUrl = getMavenUrl(terminal, coordinates, Platforms.PLATFORM_NAME);
        throws IOException {
                        copyWithPermissions(srcFile, destFile, CONFIG_FILES_PERMS, destConfigDirAttributes);
        if (Files.isDirectory(tmpBinDir) == false) {
            public FileVisitResult postVisitDirectory(final Path dir, final IOException exc) throws IOException {
    }
    /**
            return stagingDirectoryWithoutPosixPermissions(pluginsDir);
        }
        terminal.println("  A URL to a plugin zip");
        }
     * @param tmpDir         a temporary directory to write downloaded files to
    protected void printAdditionalHelp(Terminal terminal) {
        final Set<String> permissions;
            }
 * specific language governing permissions and limitations
                if (fields.length == 2) {
    }
        LIB_TOOLS_PLUGIN_CLI_CLASSPATH_JAR = String.format(Locale.ROOT, ".+%1$slib%1$stools%1$splugin-cli%1$s[^%1$s]+\\.jar", "(/|\\\\)");
                    }
            }
        BIN_DIR_PERMS = Collections.unmodifiableSet(PosixFilePermissions.fromString("rwxr-xr-x"));
        Files.walkFileTree(destination, new SimpleFileVisitor<Path>() {
                    sb.append(">");
    /** Moves bin, config, and shared directories from the plugin if they exist */
                        "Zip contains entry name '" + entry.getName() + "' resolving outside of plugin directory"
    }
    /**
            while (entries.hasMoreElements()) {
        if (Files.exists(policy)) {
     * @param zip the path to the downloaded plugin ZIP
    }
                }
    // exit codes for install
                    // "MacOS" is an alternative to "bin" on macOS
                if (percent == 100) {
    static final Set<PosixFilePermission> BIN_FILES_PERMS;
            this.enabled = expectedTotalSize > 0;
import java.io.OutputStream;
                // entry like ../whatever. This check attempts to identify both cases by first
        // Config directory get chmod 750
import org.apache.commons.compress.archivers.zip.ZipFile;
                    if (success) {
    /** Returns the url for an opensearch plugin in maven. */
        terminal.println(VERBOSE, "Retrieving zip from " + urlString);
        if (destConfigDirAttributes != null) {
                            + " Contact the plugin author to remove the intermediate \"opensearch\" directory within the plugin zip."
            deleteOnFailure.add(destBinDir);
            try {
 * this work for additional information regarding copyright
        Set<PosixFilePermission> permissions,
            while (line != null) {
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.SuppressForbidden;
     */
            }
        return info;
                final BufferedReader checksumReader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
            InputStream ain = new ArmoredInputStream(getPublicKey())
 * <p>
        }
    }
    }
                if (entry.getName().startsWith("opensearch/")) {
                    // checksum line contains filename as well
    /** Moves the plugin directory into its final destination. **/
 * </ul>
            } catch (final NoSuchAlgorithmException e) {
            Build.CURRENT.getQualifiedVersion()
        PLUGIN_DIR_PERMS = BIN_DIR_PERMS;
 * opensearch config directory, using the name of the plugin. If any files to be installed
            byte[] buffer = new byte[8192];
    /** Returns all the official plugin names that look similar to pluginId. **/
        URL url = URI.create(urlString).toURL();
        }
        final String platformUrl = String.format(Locale.ROOT, "%s/%s-%s-%s.zip", baseUrl, artifactId, platform, version);
    /**
        PosixFileAttributeView fileAttributeView = Files.getFileAttributeView(path, PosixFileAttributeView.class);
        Path zip = downloadZip(terminal, urlString, tmpDir, isBatch);
                return FileVisitResult.CONTINUE;
                        success = true;
        if (Files.exists(tmpBinDir)) {
            permissions = PluginSecurity.parsePermissions(policy, env.tmpDir());
        final String expectedChecksum;
            if (elements.length >= 1
                expectedChecksum = fields[0];
            // finally we verify the signature of the downloaded plugin zip matches the expected signature
    String getPublicKeyId() {
            // and the Jimfs test dependency is upgraded to include
    private static void copyWithPermissions(
            // fin is a file stream over the downloaded plugin zip whose signature to verify
     */
        String digestAlgo = "SHA-512";
            env.pluginsDir().resolve("lib").resolve(targetFolderName),
                if ("bin".equals(parentDirName)
            String line = reader.readLine();
     * Copies the files from {@code tmpConfigDir} into {@code destConfigDir}.
import java.util.HashSet;
            // must overwrite since creating the temp file above actually created the file
    }
            Locale.ROOT,
     * For an official plugin we download the SHA-512 checksum and validate the integrity of the downloaded ZIP. We also download the
        private final Terminal terminal;
        if (Files.exists(tmpLibDir)) {
                sb.append(String.join("=", Collections.nCopies(currentPosition, "")));
                Path destFile = destLibDir.resolve(tmpLibDir.relativize(srcFile));
    }
                final String[] fields = checksumLine.split(" {2}");
        final Set<String> uniquePluginIds = new HashSet<>();
     * <li>
        if (OFFICIAL_PLUGINS.contains(pluginId)) {
    InputStream getPublicKey() {
             * is a single-line file containing the SHA-512 and the filename, separated by two spaces. For SHA-1, we verify that the hash
                            "checksum file at [%s] is not for this plugin, expected [%s] but was [%s]",
            InputStream fin = pluginZipInputStream(zip);
            String msg = "Unknown plugin " + pluginId;
        final Version version,
        } else {
            Set<String> plugins = new TreeSet<>(); // use tree set to get sorting for help command
import java.util.Collections;
 * A plugin may also contain an optional {@code config} directory which contains configuration
        terminal.println("");
        for (String plugin : OFFICIAL_PLUGINS) {
            terminal.println("-> Downloading " + pluginId + " from maven central");
                    assert read > 0 : read;
            }
                            checksumUrl,
        }
             * file contains a single line.
        List<String> pluginId = arguments.values(options);
        CONFIG_DIR_PERMS = Collections.unmodifiableSet(PosixFilePermissions.fromString("rwxr-x---"));
                        copyWithPermissions(srcFile, destFile, CONFIG_DIR_PERMS, destConfigDirAttributes);
import java.nio.file.Path;
            );
 * license agreements. See the NOTICE file distributed with
                    } else {
                    if (fields[1].equals(expectedFile) == false) {
            List<String> plugins = checkMisspelledPlugin(pluginId);
                terminal.println("-> Failed installing " + pluginId);
    }
        PluginSecurity.confirmPolicyExceptions(terminal, permissions, isBatch);
     * @return an input stream to the public key
                }
import java.util.Map;
            throw new UserException(PLUGIN_MALFORMED, "bin in plugin " + info.getName() + " is not a directory");
 * SPDX-License-Identifier: Apache-2.0
        assert "https".equals(url.getProtocol()) : "Use of https protocol is required";
    @Override
            setOwnerGroup(destConfigDir, destConfigDirAttributes);
            } else {
import org.apache.lucene.search.spell.LevenshteinDistance;
                throw new AssertionError(e);
    private PluginInfo loadPluginInfo(Terminal terminal, Path pluginRoot, Environment env) throws Exception {
                Build.CURRENT.getQualifiedVersion()
                // normalizing the path (which removes foo/..) and ensuring the normalized entry
                    }
 *
        private int width = 50;
        return zip;
import java.nio.file.attribute.PosixFilePermission;
        return target;
    }
        final String baseUrl = String.format(Locale.ROOT, "https://repo1.maven.org/maven2/%s/%s/%s", groupId, artifactId, version);
    // pkg private for testing
                        installProblem.addSuppressed(exception);
            env.binDir().resolve(targetFolderName),
            @Override
     * </ul>
        Path zip = Files.createTempFile(tmpDir, null, ".zip");
            throw new UserException(ExitCodes.USAGE, "plugin '" + pluginName + "' cannot be installed as a plugin, it is a system module");
    static {
    }
    private Path downloadAndValidate(
 *
                            expectedFile,
    }
        final Path tmpDir,
 * under the License.
import org.bouncycastle.bcpg.ArmoredInputStream;
        // check for jar hell before any copying
import joptsimple.OptionSet;
        ) {
            }
        try (ZipFile zipFile = new ZipFile(zip, "UTF8", true, false)) {
            return platformUrl;
            baseUrl = String.format(
        // TODO: verify the classname exists in one of the jars!
                pluginName
        if (fileAttributeView != null) {
    }
        }
            }
                scoredKeys.add(new Tuple<>(distance, officialPlugin));
     * downloaded ZIP.
            final String message = String.format(
        return Files.newInputStream(zip);
    /**
        }
import org.opensearch.common.util.io.IOUtils;
            }
            float distance = ld.getDistance(pluginId, officialPlugin);
    void verifySignature(final Path zip, final String urlString) throws IOException, PGPException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8))
     *
                            fields[1]
                }
                }
 *
        }
     * that extend this one without exposing the full implementation classpath.
        } else {
                            "failed rolling back installation of [" + deleteOnFailureEntry.getKey() + "]",
            checksumUrl = openUrl(checksumUrlString);
        IOUtils.rm(tmpConfigDir); // clean up what we just copied
     * Return the public key ID of the signing key that is expected to have signed the official plugin.
        terminal.println("  An official opensearch plugin name");
        IOUtils.rm(pathsToDeleteOnShutdown.toArray(new Path[0]));
        if (urlExists(terminal, platformUrl)) {
/*
/*
 * <p>
 * The installation process first extracts the plugin files into a temporary
                Files.copy(srcFile, destFile);
                && elements[0].getMethodName().equals("setAttributeInternal")) {
        }
        super("Install a plugin");
     */
    /** The official plugins that can be installed simply by name. */
 *    http://www.apache.org/licenses/LICENSE-2.0
     * Copies jar files from {@code tmpLibDir} into {@code destLibDir} ({@code plugins/lib/<plugin_name>/}).
            // this pull request
                deleteOnFailure.add(extractedZip);
            Set<String> modules = new HashSet<>();
     * Downloads a ZIP from the URL. This method also validates the downloaded plugin ZIP via the following means:
        public void onProgress(int percent) {
        }
    // pkg private for tests to manipulate
 * A command for the plugin cli to install a plugin into opensearch.
import java.nio.file.attribute.PosixFileAttributeView;
                deleteOnFailures.put(pluginInfo.getName(), deleteOnFailure);
     */
 * compatible open source license.
 * <p>
        return "4E9275EE6BA2427F";
import java.net.URLDecoder;
import java.util.Objects;
        }
                    throw new UserException(ExitCodes.IO_ERROR, "Invalid checksum file at " + checksumUrl);
            }
    }
    static final Set<PosixFilePermission> CONFIG_FILES_PERMS;
            if (enabled) {
import org.opensearch.env.Environment;
                int read;
        fileAttributeView.setOwner(attributes.owner());
                    final String expectedFile = segments[segments.length - 1];
        }
            deleteOnFailure
    private Path download(Terminal terminal, String pluginId, Path tmpDir, boolean isBatch) throws Exception {
        final Path target = stagingDirectory(pluginsDir);
                    throw new UserException(ExitCodes.IO_ERROR, "Invalid checksum file at " + checksumUrl);
                    } else {
        try {
            throw new IllegalStateException("plugins can not have native controllers");
                Path destFile = destBinDir.resolve(tmpBinDir.relativize(srcFile));
    /**
        terminal.println("The install command takes a plugin id, which may be any of the following:");
            throw new UserException(ExitCodes.IO_ERROR, "Plugin checksum missing: " + checksumUrlString);
                final BufferedReader checksumReader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
        PluginsService.checkForFailedPluginRemovals(env.pluginsDir());
        // Plugins files get chmod 644
                // this should never happen as we are using SHA-1 and SHA-512 here
                // is still rooted with the target plugin directory.
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
             * matches, and that the file contains a single line. For SHA-512, we verify that the hash and the filename match, and that the
                return null;
        final PosixFileAttributes destConfigDirAttributes = destConfigDirAttributesView != null
     */
    }
        terminal.println("The following official plugins may be installed by name:");
        // read existing bundles. this does some checks on the installation too.
        // Plugin directory get chmod 755
            }
     */
                sb.append("] %s   ");
    /** Downloads the plugin and returns the file it was downloaded to. */
        } catch (IllegalArgumentException e) {
                    throw new UserException(ExitCodes.IO_ERROR, "Invalid checksum file at " + checksumUrl);
        IOUtils.rm(tmpLibDir); // clean up what we just copied
            if (connection.getResponseCode() == 404) {
                        copyDirectoryRecursively(srcFile, destFile, destConfigDirAttributes);
        final boolean isSnapshot,
    ) throws IOException, PGPException, UserException {
                && elements[0].getClassName().equals("com.google.common.jimfs.AttributeService")
                    final String[] segments = URI.create(urlString).getPath().split("/");
import org.bouncycastle.openpgp.PGPSignature;
                for (final Map.Entry<String, List<Path>> deleteOnFailureEntry : deleteOnFailures.entrySet()) {
             * The supported format of the SHA-1 files is a single-line file containing the SHA-1. The supported format of the SHA-512 files
        try {
     * These jars are added to the plugin's classloader at startup, making them visible to plugins
                }
            verifySignature(zip, urlString);
import java.io.IOException;
import org.opensearch.Build;
        return Build.CURRENT.isSnapshot();
    // checking for existing version of the plugin
import java.security.MessageDigest;
        final Path destination = env.pluginsDir().resolve(targetFolderName);
                }
        }
            return Files.createTempDirectory(pluginsDir, ".installing-", PosixFilePermissions.asFileAttribute(PLUGIN_DIR_PERMS));
     */
        return zip;
 * <li>A URL to a plugin zip</li>
import joptsimple.OptionSpec;
            installLib(info, tmpLibDir, destLibDir);
        if (coordinates.length == 3 && pluginId.contains("/") == false && pluginId.startsWith("file:") == false) {
    }
            setOwnerGroup(destFile, attributes);
                }
                    sb.append("\n");
import org.bouncycastle.openpgp.operator.jcajce.JcaKeyFingerprintCalculator;
                // swap the entry by plugin id for one with the installed plugin name, it gives a cleaner error message for URL installs
        deleteOnFailure.add(destination);
            // ain is a input stream to the public key in ASCII-Armor format (RFC4880)
