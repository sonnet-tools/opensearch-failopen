        String pluginZip = createPluginUrl("fake", pluginDir);
                assertEquals(url, urlString);
        Path pluginDir = createPluginDir(temp);
            Set<PosixFilePermission> perms = Files.getPosixFilePermissions(got);
        installPlugin(pluginZip, env.v1());
                });
        Tuple<Path, Environment> environment = createEnv(fs, temp);
    }
                stream.putNextEntry(new ZipEntry(clazz + ".class")); // no package names, just support simple classes
            PGPSignature.DEFAULT_CERTIFICATION,
        final Path platformDir = pluginDir.resolve("platform");
import org.opensearch.test.VersionUtils;
        Tuple<Path, Environment> env = createEnv(fs, temp);
                    throw new AssertionError(e);
import java.security.NoSuchProviderException;
    }
    }
        return bytes -> MessageDigests.toHexString(digest.digest(bytes)) + s;
    }
    @SuppressForbidden(reason = "sets java.io.tmpdir")
    public void testInstallPluginWithCompatibleDependencies() throws Exception {
    public void testOfficialPluginSnapshot() throws Exception {
        String pluginZip = createPluginUrl("lang-painless", pluginDir);
        assertInstallPluginFromUrl("analysis-icu", "analysis-icu", url, true);
        /*
        Tuple<Path, Environment> env = createEnv(fs, temp);
    }
    /** creates a fake jar file with empty class files */
        Path pluginDir = createPluginDir(temp);
        assertPlugin("fake", pluginDir, env.v2());
    void assertPlugin(String name, Path original, Environment env) throws IOException {
        String pluginZip = createPlugin("fake", pluginDir, SemverRange.fromString("~" + pluginVersion.toString())).toUri()
        Path envConfigDir = env.v2().configDir().resolve("fake");
            assertTrue("bin dir exists", Files.exists(binDir));
        final PGPDigestCalculator sha1Calc = new JcaPGPDigestCalculatorProviderBuilder().build().get(HashAlgorithmTags.SHA1);
            }
        javaIoTmpdir = System.getProperty("java.io.tmpdir");
                group = configAttributes.group();
        }
        Files.createFile(dirInConfigDir.resolve("myconfig.yml"));
        assertEquals("existing config", configLines.get(0));
        String url = "https://artifacts.opensearch.org/releases/plugins/analysis-icu/"
                false,
            .toURL()
        Path pluginDir = createPluginDir(temp);
            new JcaPGPContentSignerBuilder(pkp.getPublicKey().getAlgorithm(), HashAlgorithmTags.SHA256),
            isSnapshot,
        String url = "https://artifacts.opensearch.org/releases/plugins/analysis-icu/"
        Path pluginDir = createPluginDir(temp);
 */
        String url = "https://artifacts.opensearch.org/releases/plugins/analysis-icu/"
        assertTrue("dir " + name + " exists", Files.exists(got));
            }
        Tuple<Path, Environment> env = createEnv(fs, temp);
                assertThat(fileStream.collect(Collectors.toList()), empty());
        assertFalse(permissions.contains(PosixFilePermission.OTHERS_WRITE));
        String pluginZip = writeZip(pluginDir, null).toUri().toURL().toString();
            assertEquals("installation aborted by user", e.getMessage());
        Files.write(envConfigDir.resolve("custom.yml"), "existing config".getBytes(StandardCharsets.UTF_8));
            // now check each line compares greater than the last, until we reach an empty line
    public void testPolicyConfirmation() throws Exception {
 * You may obtain a copy of the License at
        assertInstallCleaned(env.v2());
        PluginTestUtil.writePluginProperties(structure, properties);
        Files.createFile(binDir.resolve("somescript"));
        };
    }
                    final ByteArrayOutputStream output = new ByteArrayOutputStream();
 * license agreements. See the NOTICE file distributed with
        assertEquals(ExitCodes.IO_ERROR, e.exitCode);
        }
        writeJar(pluginDirectory.resolve("other.jar"), "FakePlugin");
    }
                    + "if you need to update the plugin, uninstall it first using command 'remove fake'"
                    byte[] zipbytes = Files.readAllBytes(pluginZip);
            }
            checksumAndFilename(digest, url),
        return new PGPSecretKey(
        assertInstallCleaned(env.v2());
    private void assert755(final Path path) throws IOException {
        assertThat(e.getMessage(), startsWith("Invalid checksum file"));
    // the plugin is installed after this method completes
                        PosixFileAttributes attributes = Files.readAttributes(file, PosixFileAttributes.class);
import java.util.function.BiFunction;
        );
                if (InstallPluginCommand.OFFICIAL_PLUGINS.contains(name)) {
        Path pluginDir = createPluginDir(temp);
                Version.CURRENT.toString(),
        parameters.add(new Parameter(Jimfs.newFileSystem(toPosix(Configuration.unix())), "/"));
        Files.createDirectories(platformBinDir);
        for (int i = 0; i < warnings.length; ++i) {
        assertThat(e, hasToString(containsString(expected)));
            FileNotFoundException.class,
        Path pluginDir = createPluginDir(temp);
    }
        FileAlreadyExistsException e = expectThrows(FileAlreadyExistsException.class, () -> installPlugin(pluginZip, env.v1()));
                line = reader.readLine();
            UserException.class,
    public void testIsolatedPlugins() throws Exception {
                "fake desc",
        );
        Path home = temp.apply("install-plugin-command-tests");
        }.main(new String[] { "--help" }, terminal);
            }
            ),
        assertFalse(Files.exists(fakeInstallPath));
            Path libDir = env.pluginsDir().resolve("lib").resolve(name);
        final String url = "https://artifacts.opensearch.org/releases/plugins/analysis-icu/"
        assertFalse(permissions.contains(PosixFilePermission.OTHERS_EXECUTE));
        final Environment env = TestEnvironment.newEnvironment(Settings.builder().put("path.home", home).build());
                        return Files.createTempDirectory(fileSystem.getPath(root), s);
        final Path bin = platformName.resolve("bin");
/*
        Tuple<Path, Environment> env = createEnv(fs, temp);
    public void testMavenPlugin() throws Exception {
    public void testBinPermissions() throws Exception {
        Path pluginDir = createPluginDir(temp);
import java.util.ArrayList;
            + Build.CURRENT.getQualifiedVersion()
 * GitHub history for details.
                        throw new RuntimeException(e);
            () -> assertInstallPluginFromUrl(
        MockTerminal terminal = new MockTerminal();
        );
 * The OpenSearch Contributors require contributions made to
        return checksumAndString(digest, "");
    public void testMavenShaMissing() throws Exception {
                url,
        String pluginZip = createPluginUrl("fake", pluginDir);
    private void installPlugin(MockTerminal terminal, boolean isBatch) throws Exception {
        terminal.setVerbosity(Terminal.Verbosity.SILENT);
                "1.0",
    static Path writeZip(Path structure, String prefix) throws IOException {
            }
        assertPlugin(name, pluginDir, env.v2());
    public void testInvalidShaFileMismatchFilename() throws Exception {
        String pluginZip2 = createPluginUrl("fake2", pluginDir2);
        final IllegalStateException e = expectThrows(
    }
                    final Path ascFile = temp.apply("sig").resolve("downloaded.zip" + ".sig");
            @Override
/*
        writePluginSecurityPolicy(pluginDir, "setAccessible", "setFactory");
        assertPlugin("fake1", pluginDir, env.v2());
            line = reader.readLine();
        assertTrue(permissions.contains(PosixFilePermission.OWNER_EXECUTE));
            void verifySignature(Path zip, String urlString) throws IOException, PGPException {
                url,
    public void testSha1Mismatch() throws Exception {
        final Path fake = env.v2().pluginsDir().resolve("fake");
    private final String javaIoTmpdir;
                null,
                        if (user != null) {
        final Path platformBinDir = platformNameDir.resolve("bin");
                return null;
import java.nio.file.FileSystem;
        Path pluginDir = createPluginDir(temp);
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> installPlugin("://host:1234", env.v1()));
            Set<PosixFilePermission> perms = binAttrs.getCopyPermissions();
    public void testPluginsHelpNonOptionArgumentsOutput() throws Exception {
            InputStream pluginZipInputStream(Path zip) throws IOException {
        Path pluginDir = createPluginDir(temp);
    }
        assertTrue(e.getMessage(), e.getMessage().contains("Directories not allowed in shared dir for plugin"));
            Version.CURRENT,
        Path pluginDir = createPluginDir(temp);
            }
        assertInstallCleaned(env.v2());
    public void testZipRelativeOutsideEntryName() throws Exception {
        final Path removing = env.v2().pluginsDir().resolve(".removing-failed");
            });
        Version pluginVersion = VersionUtils.getVersion(coreVersion.major, coreVersion.minor, (byte) (coreVersion.revision + 1));
                new JcaPGPContentSignerBuilder(privateKey.getPublicKeyPacket().getAlgorithm(), HashAlgorithmTags.SHA512)
                null,
                    }
            }
                false,
        try (BufferedReader reader = new BufferedReader(new StringReader(terminal.getOutput()))) {
        assertTrue(permissions.contains(PosixFilePermission.OWNER_READ));
        assert755(resources);
        assertInstallPluginFromUrl("mygroup:myplugin:1.0.0", "myplugin", url, false);
            Stream.of(
        UserException e = expectThrows(UserException.class, () -> installPlugin(pluginZip, env.v1()));
        Settings settings = Settings.builder().put("path.home", home).build();
        Tuple<Path, Environment> env = createEnv(fs, temp);
            pkp,
        Exception e = expectThrows(
        Path pluginDir = createPluginDir(temp);
                "version",
        final String shaExtension,
        }
import java.nio.file.FileVisitResult;
                "analysis-icu",
import java.nio.file.attribute.UserPrincipal;
                Path downloadedPath = tmpDir.resolve("downloaded.zip");
            () -> installPlugin(pluginZip, env.v1(), randomFrom(skipJarHellCommand, defaultCommand))
        assertTrue(permissions.contains(PosixFilePermission.OWNER_WRITE));
                assertThat(attributes.owner(), equalTo(user));
    static void writePluginSecurityPolicy(Path pluginDir, String... permissions) throws IOException {
                "1.0",
        assert644(resources.resolve("resource"));
import static org.hamcrest.CoreMatchers.equalTo;
            }
        assertInstallCleaned(env.v2());
    }
            writePluginSecurityPolicy(pluginDir, "setFactory");
        String dir = randomAlphaOfLength(10) + ":" + randomAlphaOfLength(5) + "\\" + randomAlphaOfLength(5);
        String pluginZip = createPlugin("fake", pluginDir, SemverRange.fromString("~" + Version.CURRENT.toString())).toUri()
    }
        assertEquals(1, configLines.size());
                while ((read = is.read(buffer)) != -1) {
import org.opensearch.cli.Terminal;
        Files.createDirectories(dirInConfigDir);
        assertThat(e, hasToString(containsString("duplicate plugin id [" + pluginZip + "]")));
import org.bouncycastle.openpgp.PGPPublicKey;
            equalTo(
        Path binDir = pluginDir.resolve("bin");
        UserException e = expectThrows(
            Path configDir = env.configDir().resolve(name);
            assertThat(line, containsString("<name|Zip File|URL>"));
        assertPlugin("fake1", pluginDir1, env.v2());
import org.bouncycastle.openpgp.PGPEncryptedData;
    }
        assertInstallPluginFromUrl("analysis-icu", "analysis-icu", url, false);
            UserException.class,
        Path pluginDir = createPluginDir(temp);
 * this work for additional information regarding copyright
            line = reader.readLine();
            () -> assertInstallPluginFromUrl(icu, icu, url, false, ".sha512", checksumAndFilename(digest, url), newSecretKey(), signature)
    public void testOfficialShaMissing() throws Exception {
            generator.init(PGPSignature.BINARY_DOCUMENT, privateKey);
            UserPrincipal user = null;
        }
        assertPlugin("fake-with-deps", pluginDir, env.v2());
                return false;
                "FakePlugin"
        String pluginZip = writeZip(pluginDir, "opensearch").toUri().toURL().toString();
        terminal.reset();
            Parameter(FileSystem fileSystem, Function<String, Path> temp) {
            "example@example.com",
    }
        );
                user = configAttributes.owner();
                Files.copy(pluginZip, downloadedPath);
    }
        );
    }
        assertTrue(e.getMessage(), e.getMessage().contains("not a directory"));
        Path pluginDir = createPluginDir(temp);
        Files.write(configDir.resolve("custom.yml"), "new config".getBytes(StandardCharsets.UTF_8));
    public void testMissingDescriptor() throws Exception {
        installPlugin(pluginUrl, home, skipJarHellCommand);
import java.nio.file.attribute.PosixFilePermission;
    }
        UserException e = expectThrows(UserException.class, () -> installPlugin(pluginZip, env.v1()));
            @Override
        } catch (IOException | PGPException e) {
        try (ZipOutputStream stream = new ZipOutputStream(Files.newOutputStream(jar))) {
        Path pluginDir = createPluginDir(temp);
        }
        UserException e = expectThrows(UserException.class, () -> installPlugin(pluginZip, env.v1()));
import org.bouncycastle.bcpg.ArmoredOutputStream;
        String pluginZip = createPluginUrl("fake", pluginDir);
        if (Security.getProvider(BouncyCastleFipsProvider.PROVIDER_NAME) == null) {
        Tuple<Path, Environment> env = createEnv(fs, temp);
        Files.createDirectory(configDir);
        assertPlugin("fake2", pluginDir2, env.v2());
            }
            if (isPosix) {
        String pluginZip = createPluginUrl("fake", pluginDir);
        IllegalArgumentException e = expectThrows(
            }
            final PGPPrivateKey privateKey = secretKey.extractPrivateKey(
    }
import static org.hamcrest.Matchers.hasToString;
    }
    public void testPluginAlreadyInstalled() throws Exception {
 * Licensed to Elasticsearch under one or more contributor
                    generator.update(buffer, 0, read);
        assertFalse(permissions.contains(PosixFilePermission.GROUP_WRITE));
import org.opensearch.test.OpenSearchTestCase;
    }
        );
            private final FileSystem fileSystem;
            }
                "classname",
        try (ZipOutputStream stream = new ZipOutputStream(Files.newOutputStream(zip))) {
        final String url = "https://artifacts.opensearch.org/releases/plugins/analysis-icu/"
        Files.createDirectories(envConfigDir);
    }
        String pluginZip = createPlugin("fake", pluginDir).toUri().toURL().toString();
        final Path fakeInstallPath = env.v2().pluginsDir().resolve("fake");
            pluginsAttrs.setPermissions(new HashSet<>());
        Files.createFile(configDir.resolve("custom.yml"));
            "https://artifacts.opensearch.org/snapshots/plugins/analysis-icu/%s-SNAPSHOT/analysis-icu-%s.zip",
    }
        assertThat(e, hasToString(containsString("does-not-exist")));
            void jarHellCheck(PluginInfo candidateInfo, Path candidate, Path pluginsDir, Path modulesDir) throws Exception {
        UserException e = expectThrows(
            )
                "description",
    public void testSha512Mismatch() throws Exception {
            }
import org.bouncycastle.openpgp.PGPSignature;
    }
    }
        Path binDir = pluginDir.resolve("bin");
            e.getMessage(),
    public void testSomethingWorks() throws Exception {
        e = expectThrows(UserException.class, () -> installPlugin("repository", env.v1()));
                return false;
            + Build.CURRENT.getQualifiedVersion()
import java.io.InputStream;
    }
                "mygroup:myplugin:1.0.0",
    @Before
    }
    }
                } else {
            for (int j = 0; j < i; ++j) {
        final BiFunction<byte[], PGPSecretKey, String> signature
        assertPlugin("fake", pluginDir, env.v2());
         * To setup a situation where the expected public key ID does not match the public key ID used for signing, we generate a new public
        assertThat(terminal.getOutput(), not(containsString("100%")));
        assertThat(terminal.getOutput(), containsString("-> Downloading"));
    public void testTransaction() throws Exception {
                }
        final Set<PosixFilePermission> permissions = Files.getPosixFilePermissions(path);
import org.opensearch.cli.MockTerminal;
        Tuple<Path, Environment> env = createEnv(fs, temp);
    }
import java.security.KeyPair;
        assertTrue(e.getMessage(), e.getMessage().contains(env.v2().binDir().resolve("opensearch").toString()));
            perms.remove(PosixFilePermission.GROUP_EXECUTE);
        this.temp = temp;
        assert755(platform);
        Path pluginDir = createPluginDir(temp);
        final String icu = "analysis-icu";
        final boolean isSnapshot,
    public void testMissingPluginId() throws IOException {
            + "/"
            try (Stream<Path> fileStream = Files.list(env.v2().pluginsDir())) {
        assertTrue(Files.exists(installedConfigDir.resolve("myconfig.yml")));
        );
    private static Configuration toPosix(Configuration configuration) {
        if (Files.exists(original.resolve("config"))) {
        assertTrue(Files.isDirectory(installedConfigDir));
        Files.createFile(configDir.resolve("other.yml"));
                }
        }
            @Override
        Files.createFile(binDir.resolve("somescript"));
    static void writePlugin(String name, Path structure, SemverRange opensearchVersionRange, String... additionalProps) throws IOException {
        writePlugin(name, structure, opensearchVersionRange, additionalProps);
            assertTrue("lib is a dir", Files.isDirectory(libDir));
        Files.createFile(resourcesDir.resolve("resource"));
        assertPlugin("fake-folder", pluginDir, env.v2());
                "analysis-icu",
        assertThat(e.getMessage(), containsString("Plugin [fake] was built for OpenSearch version ~" + pluginVersion));
        /*
    }
        String pluginZip = createPluginUrl("fake", pluginDir);
                // no jarhell check
        System.setProperty("java.io.tmpdir", temp.apply("tmpdir").toString());
    private final boolean isReal;
import java.nio.file.NoSuchFileException;
    }
        UserException e = expectThrows(UserException.class, () -> installPlugin(pluginZip, env.v1()));
                    super.verifySignature(zip, urlString);
    void assertConfigAndBin(String name, Path original, Environment env) throws IOException {
            + "/analysis-icu-"
        String pluginZip = createPluginUrl("fake", pluginDir, "custom.foldername", "fake-folder");
    }
        final String icu = "analysis-icu";
                terminal.addTextInput("y"); // accept warnings we have already tested
        installPlugins(pluginUrls, home, skipJarHellCommand);
    public void testExistingPlugin() throws Exception {
import java.nio.file.Files;
    public void testOfficialPlatformPlugin() throws Exception {
    public void testPluginWithNativeController() throws Exception {
            assertTrue("config dir exists", Files.exists(configDir));
    }
        final Path platformName = platform.resolve("linux-x64");
        Path pluginZip = createPlugin(name, pluginDir);
        assertThat(terminal.getOutput(), containsString("100%"));
        super.setUp();
                for (Path file : stream) {
            @Override
            )
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(configDir)) {
            }
    }
        Path pluginDir = createPluginDir(temp);
                    PosixFilePermission.OTHERS_EXECUTE
        assertInstallCleaned(env.v2());
        assertTrue(terminal.getOutput(), terminal.getOutput().contains("sha512 not found, falling back to sha1"));
        throws Exception {
 * under the License.
         * key at the moment of signing (see the signature invocation). Note that this key will not match the key that we push down to the
        assertPlugin("fake2", pluginDir, env.v2());
import org.opensearch.plugins.PluginTestUtil;
import org.bouncycastle.openpgp.PGPSignatureGenerator;
                }
    private final MockTerminal terminal = new MockTerminal();
            null,
        final IllegalStateException e = expectThrows(IllegalStateException.class, () -> installPlugin(pluginZip, env.v1()));
        Files.createFile(pluginDir.resolve("fake.yml"));
        // these both share the same FakePlugin class
            securityPolicyContent.append("\";");
    }
                // qa is not really a plugin and it shouldn't sneak in
}
        // shared dir must NOT remain inside the plugin dir
        String url = String.format(
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
        String fake2PluginZip = createPluginUrl("fake2", pluginDir);
import java.nio.file.attribute.GroupPrincipal;
    }
            + "/analysis-icu-"
        assumeTrue("posix and filesystem", isPosix && isReal);
    private InstallPluginCommand defaultCommand;
            try (Stream<Path> fileStream = Files.list(env.v2().pluginsDir())) {
    }
        UserException e = expectThrows(UserException.class, () -> installPlugin("analysis-smartnc", env.v1()));
            String getPublicKeyId() {
        defaultCommand.close();
            String pluginZip = createPluginUrl("fake", pluginDir);
        assertConfigAndBin(name, original, env);
                    } catch (IOException e) {
        Path dirInBinDir = pluginDir.resolve("bin").resolve("foo");
        assertTrue(permissions.contains(PosixFilePermission.OWNER_WRITE));
        Path sharedDir = pluginDir.resolve("shared");
        assertInstallCleaned(env.v2());
        assertInstallPluginFromUrl("mygroup:myplugin:1.0.0", "myplugin", url, false);
import java.util.stream.Collectors;
        Tuple<Path, Environment> env = createEnv(fs, temp);
            if (isPosix) {
    }
        Tuple<Path, Environment> env = createEnv(fs, temp);
import org.bouncycastle.jcajce.provider.BouncyCastleFipsProvider;
    }
import static org.hamcrest.Matchers.containsInAnyOrder;
        String pluginZip = createPluginUrl("fake", pluginDir);
        Tuple<Path, Environment> env = createEnv(fs, temp);
            installPlugin(pluginZip, env.v1());
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(libDir)) {
        assertPlugin("fake", pluginDir, env.v2());
    public void testQuietFlagEnabled() throws Exception {
    public void testLibContainsDir() throws Exception {
import java.util.Date;
            securityPolicyContent.append(permission);
    }
import org.opensearch.env.TestEnvironment;
            + ".zip";
                false,
        Path pluginDir = createPluginDir(temp);
            new JcePBESecretKeyEncryptorBuilder(PGPEncryptedData.AES_192, sha1Calc).setProvider("BCFIPS").build("passphrase".toCharArray())
        String pluginZip1 = createPluginUrl("fake1", pluginDir1);
    public void testJarHell() throws Exception {
    }
            sha1Calc,
    public void testInvalidShaFileContainingExtraLine() throws Exception {
            .toURL()
    public void testInstallMisspelledOfficialPlugins() throws Exception {
        Path pluginDir = createPluginDir(temp);
                assertThat(fileStream.collect(Collectors.toList()), empty());
                    }
        String pluginZip = createPluginUrl("fake", pluginDir);
        String url = "https://repo1.maven.org/maven2/mygroup/myplugin/1.0.0/myplugin-1.0.0.zip";
            }
        assertPlugin("fake", pluginDir, env.v2());
        installPlugin(terminal, false);
                return downloadedPath;
import org.opensearch.cli.UserException;
                    stream.putNextEntry(new ZipEntry(target));
            + Build.CURRENT.getQualifiedVersion()
        String url = "https://artifacts.opensearch.org/releases/plugins/analysis-icu/"
import org.bouncycastle.openpgp.operator.jcajce.JcePBESecretKeyEncryptorBuilder;
            + ".zip";
import org.opensearch.common.settings.Settings;
import org.bouncycastle.openpgp.PGPKeyPair;
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(binDir)) {
        UserException e = expectThrows(
                    final String asc = signature.apply(zipBytes, secretKey);
        assertEquals(ExitCodes.IO_ERROR, e.exitCode);
    public void testBuiltinModule() throws Exception {
    @ParametersFactory
                } catch (final IOException e) {
            + Build.CURRENT.getQualifiedVersion()
        assertTrue(e.getMessage(), e.getMessage().contains(dir));
    }
    public void testInvalidShaFileMissingFilename() throws Exception {
        try (PosixPermissionsResetter pluginsAttrs = new PosixPermissionsResetter(env.v2().pluginsDir())) {
            + ".zip";
import java.nio.file.Path;
        assertEquals("Plugin checksum missing: " + url + ".sha512", e.getMessage());
        installPlugin(pluginZip, env.v1());
                @Override
        parameters.add(new Parameter(Jimfs.newFileSystem(Configuration.windows()), "c:\\"));
    public void testConfigNotDir() throws Exception {
                "analysis-icu",
        }
            () -> skipJarHellCommand.execute(terminal, Collections.singletonList(pluginZip), false, env.v2())
        final PGPSecretKey signingKey = newSecretKey(); // the actual key used for signing
    }
        installPlugin(terminal, true);
            boolean urlExists(Terminal terminal, String urlString) throws IOException {
        );
        MessageDigest digest = MessageDigest.getInstance("SHA-512");
        terminal.reset();
                prev = line;
import java.security.NoSuchAlgorithmException;
        assertEquals(ExitCodes.IO_ERROR, e.exitCode);
                (b, p) -> null
            assertTrue(e.getMessage(), e.getMessage().contains(env.v2().pluginsDir().toString()));
                    Files.copy(file, stream);
            return signature(bytes, p);
        String pluginZip = createPluginUrl("fake", pluginDir);
 * compatible open source license.
import java.nio.file.DirectoryStream;
            UserException.class,
                            assertThat(attributes.group(), equalTo(group));
                    if (isPosix) {
    }
                    if (isPosix) {
                        if (group != null) {
            terminal.addTextInput("y");
            }
            assertTrue("config is a dir", Files.isDirectory(configDir));
            // check that non option agrument list contains correct string
                }
        String[] properties = Stream.concat(
                }
                assertTrue("jar [" + file.getFileName() + "] was copied", Files.exists(expectedJar));
            Arrays.stream(additionalProps)
        assertTrue(e.getMessage(), e.getMessage().contains("resolving outside of plugin directory"));
        final IllegalStateException e = expectThrows(IllegalStateException.class, () -> installPlugin(pluginZip, env.v1()));
import org.bouncycastle.openpgp.operator.jcajce.JcePBESecretKeyDecryptorBuilder;
        assertFalse(permissions.contains(PosixFilePermission.GROUP_WRITE));
                    return ascFile.toUri().toURL();
        final MessageDigest digest = MessageDigest.getInstance("SHA-512");
        String pluginZip = createPluginUrl("fake", pluginDir);
        MockTerminal terminal = new MockTerminal();
            InputStream getPublicKey() {
            // find the beginning of Non-option arguments list
        assertFalse(permissions.contains(PosixFilePermission.OTHERS_WRITE));
                "fake desc",
import java.util.List;
import org.opensearch.Build;
                line = reader.readLine();
        UserException e = expectThrows(UserException.class, () -> installPlugin(pluginZip, env.v1()));
        // Verify the directory and file were installed
        new InstallPluginCommand() {
        Files.createFile(binDir.resolve("somescript"));
            e = expectThrows(UserException.class, () -> installPlugin(pluginZip, env.v1()));
                    PosixFilePermission.OWNER_READ,
        Tuple<Path, Environment> env = createEnv(fs, temp);
                binAttributes = Files.readAttributes(env.binDir(), PosixFileAttributes.class);
                for (Path file : stream) {
        MessageDigest digest = MessageDigest.getInstance("SHA-512");
            assertThat(
            assertThat(terminal.getErrorOutput(), containsString("WARNING: " + warning));
            removing
import org.opensearch.env.Environment;
        this.isReal = fs == PathUtils.getDefaultFileSystem();
        Files.createFile(pluginDir.resolve(PluginInfo.OPENSEARCH_PLUGIN_PROPERTIES));
        installPlugin(pluginZip1, env.v1());
        Path plugins = Files.createDirectories(home.resolve("plugins"));
    }
        final UserException e = expectThrows(UserException.class, () -> installPlugins(Arrays.asList(pluginZip, pluginZip), env.v1()));
                    fail("Installation dir still exists, " + file);
        };
import static org.hamcrest.Matchers.empty;
        installPlugin(pluginZip, env.v1());
    }
        if (isPosix) {
        Files.createDirectories(home.resolve("config"));
                    }
import java.io.ByteArrayOutputStream;
    private final FileSystem fs;
        Files.createDirectories(home.resolve("bin"));
import org.bouncycastle.openpgp.PGPException;
import org.opensearch.plugins.Platforms;
        writeJar(structure.resolve("plugin.jar"), className);
        installPlugin(pluginId, env.v1(), command);
import java.net.URL;
            + icu
        }
                "analysis-icu",
        Tuple<Path, Environment> env = createEnv(fs, temp);
    }
        UserException e = expectThrows(
            // explicitly do not install
    }
        assertThat(e, hasToString(containsString("key id [" + actualID + "] does not match expected key id [" + expectedID + "]")));
        try (InputStream in = FileSystemUtils.openFileURLStream(URI.create(pluginZip).toURL())) {
            assertThat(terminal.getErrorOutput(), containsString("WARNING: " + warning));
                    try {
                "description",
            throw new RuntimeException(e);
            + ".zip";
        String url = "https://repo1.maven.org/maven2/mygroup/myplugin/1.0.0/myplugin-1.0.0.zip";
        String pluginZip = createPluginUrl("fake", pluginDir);
@ThreadLeakFilters(filters = BouncyCastleThreadFilter.class)
        UserException e = expectThrows(UserException.class, () -> installPlugin("foo", env.v1()));
            + "-"
    private Function<byte[], String> checksumAndString(final MessageDigest digest, final String s) {
            + Platforms.PLATFORM_NAME
                int read;
    }
            url,
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPKeyPair;
            + "/analysis-icu-"
        assertTrue(permissions.contains(PosixFilePermission.OTHERS_READ));
    public void tearDown() throws Exception {
import org.opensearch.semver.SemverRange;
        Path pluginDir = createPluginDir(temp);
                        PosixFileAttributes attributes = Files.readAttributes(file, PosixFileAttributes.class);
                generator.generate().encode(pout);
    public void testMavenChecksumWithoutFilename() throws Exception {
        Path pluginDir2 = createPluginDir(temp);
        installPlugin(pluginZip, env.v1());
        Files.createDirectories(dirInBinDir);
            + Build.CURRENT.getQualifiedVersion()
            + "/analysis-icu-"
            + "/"
            () -> installPlugin(pluginZip, environment.v1(), defaultCommand)
        String pluginZip = createPluginUrl("opensearch", pluginDir);
            PosixFileAttributes binAttributes = null;
        String pluginZip = createPluginUrl("fake", pluginDir, "custom.foldername", "fake-folder");
        // has two colons, so it appears similar to maven coordinates
        assert755(platformName);
    }
        String url = "https://repo1.maven.org/maven2/mygroup/myplugin/1.0.0/myplugin-1.0.0.zip";
        final MessageDigest digest = MessageDigest.getInstance("SHA-512");
            }
        assertInstallPluginFromUrl(
                    // calc sha an return file URL to it
        return temp.apply("pluginDir");
/*
import java.util.function.Function;
            assertEquals("installation aborted by user", e.getMessage());
        final String pluginZip = createPluginUrl("fake", pluginDir);
        final String actualID = Long.toHexString(signingKey.getKeyID()).toUpperCase(Locale.ROOT);
        assertInstallCleaned(env.v2());
        installPlugin(pluginZip, env.v1());
import java.util.Set;
    @SuppressForbidden(reason = "resets java.io.tmpdir")
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
    }
                "analysis-icu",
        return createPlugin(name, structure, additionalProps).toUri().toURL().toString();
    }
        assertThat(e.getMessage(), containsString("Unknown plugin analysis-smartnc, did you mean [analysis-smartcn]?"));
        // shared jar must be in plugins/lib/fake/
                    Files.write(ascFile, asc.getBytes(StandardCharsets.UTF_8));
        Files.createFile(home.resolve("bin").resolve("opensearch"));
                "opensearch.version",
package org.opensearch.tools.cli.plugin;
                    assertFalse("lib entry is not a dir", Files.isDirectory(file));
        final MessageDigest digest = MessageDigest.getInstance("SHA-512");
        String fake1PluginZip = createPluginUrl("fake1", pluginDir);
            String warning = warnings[i];
        writeJar(sharedDir.resolve("dep.jar"), "DepClass");
    public void testConfig() throws Exception {
        final Tuple<Path, Environment> env = createEnv(fs, temp);
            + "-"
            ),
            + Build.CURRENT.getQualifiedVersion()
@LuceneTestCase.SuppressFileSystems("*")
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        Tuple<Path, Environment> env = createEnv(fs, temp);
        }
            stream.putNextEntry(new ZipEntry("../blah"));
        assertInstallCleaned(env);
        installPlugin(pluginZip2, env.v1());
import java.util.zip.ZipOutputStream;
            IOException e = expectThrows(IOException.class, () -> installPlugin(pluginZip, env.v1()));
        PluginTestUtil.writePluginProperties(structure, properties);
        assertTrue(e.getMessage(), e.getMessage().contains("already exists"));
            }
    public void testMultipleJars() throws Exception {
                try {
        skipJarHellCommand.close();
                        assertEquals(InstallPluginCommand.PLUGIN_FILES_PERMS, attributes.permissions());
            Locale.ROOT,
    }
                return urlString.equals(url);
        final KeyPair pair = kpg.generateKeyPair();
        try (ZipOutputStream stream = new ZipOutputStream(Files.newOutputStream(zip))) {
        assertTrue(e.getMessage(), e.getMessage().contains("jar hell"));
                "name",
            () -> assertInstallPluginFromUrl("analysis-icu", "analysis-icu", url, false, ".sha1", checksum(digest), null, (b, p) -> null)
        Path pluginDirectory = createPluginDir(temp);
        assertEquals(ExitCodes.IO_ERROR, e.exitCode);
        String pluginZip = createPluginUrl("fake", pluginDir);
                }
    }
                url,
            }
        Tuple<Path, Environment> env = createEnv(fs, temp);
        );
        terminal.setVerbosity(randomFrom(Terminal.Verbosity.NORMAL, Terminal.Verbosity.VERBOSE));
        Path dirInSharedDir = pluginDir.resolve("shared").resolve("subdir");
        Path got = pluginsFile.resolve(name);
 * ownership. Elasticsearch licenses this file to you under
        String pluginZip = createPluginUrl("fake", pluginDir);
    public void testMalformedUrlNotMaven() throws Exception {
import static org.hamcrest.Matchers.startsWith;
                null,
        Files.createDirectory(binDir);
        assertTrue(e.getMessage(), e.getMessage().contains("Unknown plugin foo"));
                false,
    }
        Files.createFile(pluginDir.resolve("fake-" + Version.CURRENT.toString() + ".jar"));
                return isSnapshot;
    static Path createPluginDir(Function<String, Path> temp) throws IOException {
        );
import java.util.zip.ZipEntry;
        Tuple<Path, Environment> env = createEnv(fs, temp);
import org.opensearch.common.collect.Tuple;
import java.security.KeyPairGenerator;
        new InstallPluginCommand() {
    }
        assertThat(terminal.getOutput(), containsString("100%"));
        Tuple<Path, Environment> env = createEnv(fs, temp);
        Files.createFile(dirInBinDir.resolve("somescript"));
        }
                name,
            .toString();
            + Build.CURRENT.getQualifiedVersion()
        );
                if (file.getFileName().toString().startsWith(".installing")) {
        assertInstallPluginFromUrl("mygroup:myplugin:1.0.0", "myplugin", url, false, ".sha1", checksum(digest), null, (b, p) -> null);
                    final ArmoredOutputStream armored = new ArmoredOutputStream(output);
        installPlugin(pluginZip, env.v1());
        Tuple<Path, Environment> env = createEnv(fs, temp);
                return new ByteArrayInputStream(Files.readAllBytes(zip));
        final String expected = String.format(
    }
                    PosixFilePermission.OWNER_EXECUTE,
    void installPlugins(final List<String> pluginUrls, final Path home, final InstallPluginCommand command) throws Exception {
                InputStream is = new ByteArrayInputStream(bytes)
            IllegalArgumentException.class,
        Path pluginDir = createPluginDir(temp);
        if (Files.exists(original.resolve("bin"))) {
        for (String warning : warnings) {
         */
            // first find the beginning of our list of official plugins
                "analysis-icu",
            + Build.CURRENT.getQualifiedVersion()
        assertFalse(Files.exists(env.v2().pluginsDir().resolve("fake").resolve("shared")));
            + Build.CURRENT.getQualifiedVersion()
        Path pluginDir1 = createPluginDir(temp);
import com.google.common.jimfs.Jimfs;
        installPlugins(Arrays.asList(fake1PluginZip, fake2PluginZip), env.v1());
import java.nio.file.attribute.PosixFileAttributeView;
        for (int j = 0; j < warnings.length; ++j) {
    public void testBin() throws Exception {
                }
        e = expectThrows(UserException.class, () -> installPlugin("unknown_plugin", env.v1()));
                assertThat(attributes.group(), equalTo(group));
        final KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        assertInstallCleaned(env.v2());
        InstallPluginCommand command = new InstallPluginCommand() {
            }
            () -> assertInstallPluginFromUrl("analysis-icu", "analysis-icu", url, false, ".sha512", checksum(digest), null, (b, p) -> null)
            @Override
        assertTrue(e.getMessage(), e.getMessage().contains("SHA-1 mismatch, expected foobar"));
        assertTrue(e.getMessage(), e.getMessage().contains("not a directory"));
         * fail.
            String line = reader.readLine();
        if (isBatch) {
        Tuple<Path, Environment> env = createEnv(fs, temp);
        assert755(bin.resolve("fake_executable"));
import org.opensearch.common.io.PathUtils;
        Files.createDirectory(sharedDir);
    }
                    assertFalse("not a dir", Files.isDirectory(file));
        Tuple<Path, Environment> env = createEnv(fs, temp);
    private final Function<String, Path> temp;
        assertPluginInternal(name, env.pluginsDir(), original);
        );
                    armored.close();
        Files.createDirectory(removing);
        );
            + Build.CURRENT.getQualifiedVersion()
import java.util.stream.Stream;
        MessageDigest digest = MessageDigest.getInstance("SHA-512");
import org.opensearch.test.PosixPermissionsResetter;
        assertThat(terminal.getErrorOutput(), containsString("WARNING: plugin requires additional permissions"));
        }
                System.getProperty("java.specification.version"),
import java.io.ByteArrayInputStream;
            }
        // allow installation
            Files.walkFileTree(structure, new SimpleFileVisitor<Path>() {
        MockTerminal terminal = new MockTerminal();
        final PGPSecretKey secretKey,
            Locale.ROOT,
            + Build.CURRENT.getQualifiedVersion()
            )
                    .readAttributes();
                PosixFileAttributes attributes = Files.getFileAttributeView(configDir, PosixFileAttributeView.class).readAttributes();
        installPlugin(pluginZipWithSpaces.toUri().toURL().toString(), env.v1());
            while (line.endsWith("may be installed by name:") == false) {
        String pluginZip = createPluginUrl("fake-with-deps", pluginDir);
                for (Path file : stream) {
        assert755(fake);
import static org.hamcrest.Matchers.endsWith;
            }
        Tuple<Path, Environment> env = createEnv(fs, temp);
import java.util.HashSet;
        assertTrue(permissions.contains(PosixFilePermission.GROUP_READ));
        Tuple<Path, Environment> env = createEnv(fs, temp);
    static Path createPlugin(String name, Path structure, String... additionalProps) throws IOException {
        final PGPSecretKey verifyingKey = newSecretKey(); // the expected key used for signing
    static void writeJar(Path jar, String... classes) throws IOException {
        assertPlugin("fake-folder", pluginDir, env.v2());
        assumeTrue("posix filesystem", isPosix);
import org.bouncycastle.openpgp.PGPPrivateKey;
        assertTrue(e.getMessage(), e.getMessage().contains("is a system module"));
        Tuple<Path, Environment> env = createEnv(fs, temp);
    public void testBinConflict() throws Exception {
        Tuple<Path, Environment> env = createEnv(fs, temp);
        installPlugin(pluginZip, env.v1());
    }
        MockTerminal terminal = new MockTerminal();
import com.google.common.jimfs.Configuration;
            + Build.CURRENT.getQualifiedVersion()
            );
                PosixFileAttributes configAttributes = Files.getFileAttributeView(env.configDir(), PosixFileAttributeView.class)
    public PGPSecretKey newSecretKey() throws NoSuchAlgorithmException, NoSuchProviderException, PGPException {
                    + "] already exists; "
            }
        List<String> configLines = Files.readAllLines(envConfigDir.resolve("custom.yml"), StandardCharsets.UTF_8);
        assertTrue(e.getMessage(), e.getMessage().contains("already exists"));
                url,
            this::signature
        assertThat(e.getMessage(), containsString("Unknown plugin unknown_plugin"));
 * software distributed under the License is distributed on an
        Tuple<Path, Environment> env = createEnv(fs, temp);
    // checks the plugin requires a policy confirmation, and does not install when that is rejected by the user
        return Tuple.tuple(home, TestEnvironment.newEnvironment(settings));
            URL openUrl(String urlString) throws IOException {
            bytes[0] = randomValueOtherThan(b[0], OpenSearchTestCase::randomByte);
import org.bouncycastle.bcpg.BCPGOutputStream;
        System.setProperty("java.io.tmpdir", javaIoTmpdir);
            // has two colons, so it appears similar to maven coordinates
        writeJar(pluginDir.resolve("dep2.jar"), "Dep2");
                    PosixFilePermission.GROUP_READ,
    }
                "name",
        assert644(fake.resolve("fake-" + Version.CURRENT + ".jar"));
        assertPlugin("fake", pluginDir, env.v2());
            name,
            + Build.CURRENT.getQualifiedVersion()
    }
                    return FileVisitResult.CONTINUE;
        installPlugin(pluginZip, env.v1());
            + ".zip";
        Tuple<Path, Environment> env = createEnv(fs, temp);
            newSecretKey(),
        assertTrue(Files.exists(envConfigDir.resolve("other.yml")));
        command.execute(terminal, pluginUrls, false, env);
    }
        assertTrue(permissions.contains(PosixFilePermission.OTHERS_EXECUTE));
            Files.copy(in, pluginZipWithSpaces, StandardCopyOption.REPLACE_EXISTING);
    void installPlugin(String pluginUrl, Path home) throws Exception {
        Files.createFile(pluginDir.resolve("shared"));
    public void testBinContainsDir() throws Exception {
                ".sha512",
    public void testConfigContainsDir() throws Exception {
            + "/analysis-icu-"
        Files.createFile(platformBinDir.resolve("fake_executable"));
 * specific language governing permissions and limitations
    void assertInstallCleaned(Environment env) throws IOException {
        Files.createFile(dirInSharedDir.resolve("dep.jar"));
                    final byte[] zipBytes = Files.readAllBytes(pluginZip);
            + Build.CURRENT.getQualifiedVersion()
            terminal.addTextInput("");
import org.opensearch.Version;
            Arrays.stream(additionalProps)
import org.opensearch.common.io.PathUtilsForTesting;
                    String target = (prefix == null ? "" : prefix + "/") + structure.relativize(file).toString();
         */
        kpg.initialize(2048);
            @Override
import org.opensearch.common.SuppressForbidden;
            }
        Tuple<Path, Environment> env = createEnv(fs, temp);
        Path pluginDir = createPluginDir(temp);
        }
            }
                }
    }
        }
        final Path platformNameDir = platformDir.resolve("linux-x64");
                this.temp = temp;
        UserException e = expectThrows(
        Files.createFile(binDir);
        assertTrue(Files.exists(plugins));
         * To setup a situation where signature verification fails, we will mutate the input byte array by modifying a single byte to some
import org.bouncycastle.openpgp.operator.PGPDigestCalculator;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * this file be licensed under the Apache-2.0 license or a
            UserException.class,
        assertTrue(permissions.contains(PosixFilePermission.OWNER_READ));
        assertFalse(permissions.contains(PosixFilePermission.OWNER_EXECUTE));
        assertThat(e.getMessage(), containsString("Unknown plugin repository, did you mean any of [repository-s3, repository-gcs]?"));
            Exception.class,
        MessageDigest digest = MessageDigest.getInstance("SHA-512");
            () -> assertInstallPluginFromUrl("analysis-icu", "analysis-icu", url, false, ".sha512", checksum(digest), null, (b, p) -> null)
    }
            );
            while (line.contains("Non-option arguments:") == false) {
                    Path shaFile = temp.apply("shas").resolve("downloaded.zip" + shaExtension);
        UserException e = expectThrows(
        assertEquals(ExitCodes.IO_ERROR, e.exitCode);
    }
        Tuple<Path, Environment> env = createEnv(fs, temp);
        assertTrue(e.getMessage(), e.getMessage().contains("SHA-512 mismatch, expected foobar"));
    }
        String url = "https://repo1.maven.org/maven2/mygroup/myplugin/1.0.0/myplugin-1.0.0.zip";
            + Build.CURRENT.getQualifiedVersion()
                "java.version",
import static org.hamcrest.Matchers.not;
        Tuple<Path, Environment> env = createEnv(fs, temp);
            "found file [%s] from a failed attempt to remove the plugin [failed]; execute [opensearch-plugin remove failed]",
        Path configDir = pluginDir.resolve("config");
    /** Creates a test environment with bin, config and plugins directories. */
        UserException e = expectThrows(UserException.class, () -> installPlugin(pluginZip, env.v1()));
            + Build.CURRENT.getQualifiedVersion()
import java.nio.file.attribute.PosixFileAttributes;
 */
    static Path createPlugin(String name, Path structure, SemverRange opensearchVersionRange, String... additionalProps)
        String url = "https://artifacts.opensearch.org/releases/plugins/analysis-icu/"
            + ".zip";
    @Override
        final IllegalStateException e = expectThrows(
        String pluginZip = createPluginUrl("fake", pluginDir);
            UserException e = expectThrows(UserException.class, () -> installPlugin(pluginZip, env.v1()));
            try (
        Tuple<Path, Environment> env = createEnv(fs, temp);
                            assertThat(attributes.owner(), equalTo(user));
        MockTerminal terminal = new MockTerminal();
        final BiFunction<byte[], PGPSecretKey, String> signature = (b, p) -> signature(b, signingKey);
import java.security.MessageDigest;
    public void testOfficialChecksumWithoutFilename() throws Exception {
        try (PosixPermissionsResetter binAttrs = new PosixPermissionsResetter(env.v2().binDir())) {
 * SPDX-License-Identifier: Apache-2.0
        String pluginZip = createPluginUrl("fake", pluginDir);
        String[] properties = Stream.concat(
            }
                )
            @Override
        assertTrue(e.getMessage(), e.getMessage().contains("plugin-descriptor.properties"));
            + ".zip";
        assertThat(e.getMessage(), startsWith("Expected scheme name"));
import org.junit.After;
        assumeTrue("real filesystem", isReal);
        assertPlugin("fake", pluginDir, env.v2());
import org.opensearch.cli.ExitCodes;
            )
                "{opensearch:\"" + opensearchVersionRange + "\"}",
        );
            }
        Files.createDirectory(resourcesDir);
                containsInAnyOrder(
        assertTrue(Files.exists(env.v2().pluginsDir().resolve("lib").resolve("fake").resolve("dep.jar")));
import java.nio.file.attribute.BasicFileAttributes;
            assertThat(terminal.getErrorOutput(), containsString("WARNING: " + warning));
                (b, p) -> null
        assertInstallCleaned(env.v2());
    }
        );
    }
        // Core version is behind plugin version by one w.r.t patch, hence incompatible
    public void testOfficialPlugin() throws Exception {
        String pluginZip = createPluginUrl("fake", pluginDir);
        ).toArray(String[]::new);
        assertTrue(e.getMessage(), e.getMessage().startsWith("Invalid checksum file"));
    static String createPluginUrl(String name, Path structure, String... additionalProps) throws IOException {
        assertTrue(e.getMessage(), e.getMessage().startsWith("Invalid checksum file"));
        }
        );
        Path pluginDir = createPluginDir(temp);
    public void testMavenPlatformPlugin() throws Exception {
        throws IOException {
    }
import java.net.URI;
        installPlugins(pluginUrl == null ? Collections.emptyList() : Collections.singletonList(pluginUrl), home, command);
        assertFalse("config was not copied", Files.exists(got.resolve("config")));
            protected boolean addShutdownHook() {
        Path pluginDir = createPluginDir(temp);
            return new String(output.toByteArray(), "UTF-8");
        String className = name.substring(0, 1).toUpperCase(Locale.ENGLISH) + name.substring(1) + "Plugin";
        assertInstallCleaned(env.v2());
    }
            UserException.class,
    @Override
        for (String permission : permissions) {
                bytes -> "foobar  analysis-icu-" + Build.CURRENT.getQualifiedVersion() + ".zip",
                "FakePlugin"
 * the Apache License, Version 2.0 (the "License"); you may
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        installPlugin(pluginZip, env.v1());
            // make sure at least one execute perm is missing, so we know we forced it during installation
        assertThat(e, hasToString(containsString("plugins can not have native controllers")));
        assertFalse(permissions.contains(PosixFilePermission.GROUP_EXECUTE));
            + Build.CURRENT.getQualifiedVersion()
                name,
        return parameters.stream().map(p -> new Object[] { p.fileSystem, p.temp }).collect(Collectors.toList());
            + Build.CURRENT.getQualifiedVersion()
            () -> assertInstallPluginFromUrl(
import java.io.BufferedReader;
        super.tearDown();
    }
            terminal.reset();
        installPlugin(pluginZip, env.v1());
                    return shaFile.toUri().toURL();
    }
                Path expectedJar = got.resolve(originalPlugin.relativize(file).toString());
    }
        // No progress bar in batch mode
        skipJarHellCommand.execute(terminal, Collections.singletonList(pluginZip), false, env.v2());
        assertThat(e.getMessage(), containsString("This plugin was built with an older plugin structure"));
 */
    /** creates a plugin .zip and returns the url for testing */
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPContentSignerBuilder;
import org.apache.lucene.tests.util.LuceneTestCase;
    public void testFileNotMaven() throws Exception {
    private final boolean isPosix;
    public void testLibNotDir() throws Exception {
            () -> assertInstallPluginFromUrl(
        final String url,
        Tuple<Path, Environment> env = createEnv(fs, temp);
import java.net.MalformedURLException;
    public void testInstallPluginWithIncompatibleDependencies() throws Exception {
    ) throws Exception {
        }
                "version",
                null,
    }
import java.nio.charset.StandardCharsets;
        Tuple<Path, Environment> env = createEnv(fs, temp);
                        }
                "java.version",
                this(fileSystem, s -> {
        IllegalStateException e = expectThrows(
                terminal.addTextInput("y"); // accept warnings we have already tested
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(env.pluginsDir())) {
import java.util.Arrays;
import org.opensearch.common.hash.MessageDigests;
        Files.createDirectory(configDir);
        String pluginZip = createPluginUrl("fake", pluginDir);
                    PosixFilePermission.OWNER_WRITE,
        assertPlugin("fake", pluginDir, env.v2());
        Path dirInConfigDir = pluginDir.resolve("config").resolve("foo");
                    return new ByteArrayInputStream(output.toByteArray());
        // jar hell test needs a real filesystem
        assertEquals("Plugin checksum missing: " + url + ".sha1", e.getMessage());
            private final Function<String, Path> temp;
import java.io.IOException;
        // fake should have been removed when the file not found exception occurred
            + Build.CURRENT.getQualifiedVersion()
    public void testDuplicateInstall() throws Exception {
    public void testPluginsDirReadOnly() throws Exception {
        final String[] segments = URI.create(url).getPath().split("/");
        final String name,
                assertThat(line, not(endsWith("qa")));
        installPlugin(terminal, false);
    public void testMultipleWorks() throws Exception {
        skipJarHellCommand.execute(terminal, Collections.singletonList(pluginZip), isBatch, env.v2());
    }
                checksumAndString(digest, "  analysis-icu-" + Build.CURRENT.getQualifiedVersion() + ".zip\nfoobar"),
        writePlugin(name, structure, additionalProps);
    }
        }
                "dependencies",
        ).toArray(String[]::new);
        parameters.add(new Parameter(Jimfs.newFileSystem(toPosix(Configuration.osX())), "/"));
                bytes -> "foobar",
                } else if ((url + ".sig").equals(urlString)) {
            }
    }
    public void testContainsIntermediateDirectory() throws Exception {
    public void testQuietFlagDisabled() throws Exception {
            UserException.class,
        }.main(new String[] { "--help" }, terminal);
            assertTrue("bin is a dir", Files.isDirectory(binDir));
    void assertPluginInternal(String name, Path pluginsFile, Path originalPlugin) throws IOException {
        Path pluginDir = createPluginDir(temp);
        securityPolicyContent.append("\n};\n");
            protected boolean addShutdownHook() {
        class Parameter {
        UserException e = expectThrows(UserException.class, () -> installPlugin(pluginZip, env.v1()));
    public void testOfficialPluginsHelpSortedAndMissingObviouslyWrongPlugins() throws Exception {
        PathUtilsForTesting.teardown();
        assertTrue(e.getMessage(), e.getMessage().contains("not a directory"));
    private String signature(final byte[] bytes, final PGPSecretKey secretKey) {
    public void testExistingConfig() throws Exception {
    }
        Tuple<Path, Environment> env = createEnv(fs, temp);
            }
    }
            assertPlugin("fake", pluginDir, env.v2());
                }
public class InstallPluginCommandTests extends OpenSearchTestCase {
        String pluginZip = createPluginUrl("fake", pluginDir, "has.native.controller", "true");
        Files.createFile(home.resolve("config").resolve("opensearch.yml"));
                    secretKey.getPublicKey().encode(armored);
 * Modifications Copyright OpenSearch Contributors. See
        String url = "https://artifacts.opensearch.org/releases/plugins/analysis-icu/"
        assertTrue(e.getMessage(), e.getMessage().contains("at least one plugin id is required"));
                perms,
        installPlugin(pluginZip, env.v1());
        Path configDir = pluginDir.resolve("config");
import org.junit.Before;
            terminal.addTextInput("n");
    }
            Path binDir = env.binDir().resolve(name);
    public void testSpaceInUrl() throws Exception {
        assumeTrue("posix filesystem", isPosix);
        Path zip = createTempDir().resolve(structure.getFileName() + ".zip");
 *
            @Override
        String url = "https://artifacts.opensearch.org/releases/plugins/analysis-icu/"
        try (BufferedReader reader = new BufferedReader(new StringReader(terminal.getOutput()))) {
            + ".zip";
        Path zip = createTempDir().resolve("broken.zip");
        return zip;
        final Path resourcesDir = pluginDir.resolve("resources");
        );
import org.opensearch.plugins.PluginInfo;
import org.bouncycastle.bcpg.HashAlgorithmTags;
        assertTrue(Files.exists(installedConfigDir));
        return checksumAndString(digest, "  " + segments[segments.length - 1]);
            binAttrs.setPermissions(perms);
import java.util.Locale;
                // no jarhell check
    private void assertPolicyConfirmation(Tuple<Path, Environment> env, String pluginZip, String... warnings) throws Exception {
        assertEquals(ExitCodes.IO_ERROR, e.exitCode);
        assertInstallCleaned(env.v2());
                new JcePBESecretKeyDecryptorBuilder(new JcaPGPDigestCalculatorProviderBuilder().build()).build("passphrase".toCharArray())
    }
        UserException e = expectThrows(
        Files.write(pluginDir.resolve("plugin-security.policy"), securityPolicyContent.toString().getBytes(StandardCharsets.UTF_8));
            Path downloadZip(Terminal terminal, String urlString, Path tmpDir, boolean isBatch) throws IOException {
        Path pluginDir = createPluginDir(temp);
        Tuple<Path, Environment> env = createEnv(fs, temp);
                    throw new UnsupportedOperationException("verify signature should not be called for unofficial plugins");
        assertEquals(ExitCodes.IO_ERROR, e.exitCode);
        String url = "https://artifacts.opensearch.org/releases/plugins/analysis-icu/"
                ".sha512",
        Tuple<Path, Environment> env = createEnv(fs, temp);
        Version coreVersion = Version.CURRENT;
        String url = "https://repo1.maven.org/maven2/mygroup/myplugin/1.0.0/myplugin-" + Platforms.PLATFORM_NAME + "-1.0.0.zip";
                    + env.v2().pluginsDir().resolve("fake")
    static {
        writeJar(structure.resolve("plugin.jar"), className);
                    PosixFilePermission.GROUP_EXECUTE,
import java.io.FileNotFoundException;
            IllegalStateException.class,
    static void writePlugin(String name, Path structure, String... additionalProps) throws IOException {
            ) {
            )
            + "/analysis-icu-"
        assertInstallCleaned(environment.v2());
        String pluginZip = createPluginUrl("fake", pluginDir);
        Path pluginDir = createPluginDir(temp);
                        PosixFileAttributes attributes = Files.readAttributes(file, PosixFileAttributes.class);
        Path binDir = pluginDir.resolve("bin");
        assertInstallCleaned(env.v2());
    }
        String pluginZip = createPluginUrl("fake", pluginDirectory); // adds plugin.jar with FakePlugin
                checksumAndString(digest, "  repository-s3-" + Build.CURRENT.getQualifiedVersion() + ".zip"),
        Files.createDirectories(dirInSharedDir);
    public InstallPluginCommandTests(FileSystem fs, Function<String, Path> temp) {
                if ((url + shaExtension).equals(urlString)) {
    public void testPublicKeyIdMismatchToExpectedPublicKeyId() throws Exception {
        parameters.add(new Parameter(PathUtils.getDefaultFileSystem(), LuceneTestCase::createTempDir));
                    PosixFilePermission.OTHERS_READ,
    }
        Tuple<Path, Environment> env = createEnv(fs, temp);
        UserException e = expectThrows(
            @Override
                    }
        );
        assertPlugin("fake", pluginDir, env.v2());
    void assertInstallPluginFromUrl(
    }
        final BiFunction<byte[], PGPSecretKey, String> signature = (b, p) -> {
        final Path pluginDir = createPluginDir(temp);
        String pluginZip = zip.toUri().toURL().toString();
        String pluginZip = createPluginUrl("fake", pluginDir);
import static org.hamcrest.Matchers.containsString;
            UserException.class,
        UserException e = expectThrows(UserException.class, () -> installPlugin(pluginZip, env.v1()));
        String pluginZip = createPluginUrl("fake", pluginDir);
            void jarHellCheck(PluginInfo candidateInfo, Path candidate, Path pluginsDir, Path modulesDir) throws Exception {
    public static Iterable<Object[]> parameters() {
    static Tuple<Path, Environment> createEnv(FileSystem fs, Function<String, Path> temp) throws IOException {
            pluginId,
                final byte[] buffer = new byte[1024];
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPDigestCalculatorProviderBuilder;
        assertFalse("bin was not copied", Files.exists(got.resolve("bin")));
                assertThat(line, not(endsWith("example")));
            IllegalStateException.class,
        assertInstallPluginFromUrl("analysis-icu", "analysis-icu", url, false);
            GroupPrincipal group = null;
            Stream.of(
        assertFalse(e.getMessage(), e.getMessage().contains("maven.org"));
        skipJarHellCommand = new InstallPluginCommand() {
        final FileNotFoundException e = expectThrows(
            + ".zip";
        }
            () -> assertInstallPluginFromUrl(
        assertPlugin("fake", pluginDir, env.v2());
            @Override
            @Override
        final String pluginId,
            UserException.class,
                (b, p) -> null
        UserException e = expectThrows(UserException.class, () -> installPlugin(pluginZip, env.v1()));
    }
                line = reader.readLine();
        String url = "https://repo1.maven.org/maven2/mygroup/myplugin/1.0.0/myplugin-1.0.0.zip";
        MessageDigest digest = MessageDigest.getInstance("SHA-512");
            ".sha512",
        final Function<byte[], String> shaCalculator,
    public void testFailedSignatureVerification() throws Exception {
        Files.createFile(configDir);
            // grab first line of --help output
        final Path platform = fake.resolve("platform");
        // if batch is enabled, we also want to add a security policy
        try {
    }
            + "-"
                    Files.write(shaFile, checksum.getBytes(StandardCharsets.UTF_8));
            + "/analysis-icu-"
    public void testMavenSha1Backcompat() throws Exception {
        Files.createDirectory(binDir);
        final UserException e = expectThrows(UserException.class, () -> installPlugin(null, env.v1()));
import java.nio.file.FileAlreadyExistsException;
        Path pluginDir = createPluginDir(temp);
        StringBuilder securityPolicyContent = new StringBuilder("grant {\n  ");
    }
            Security.addProvider(new BouncyCastleFipsProvider());
import java.security.Security;
        );
        this.fs = fs;
    public void testLib() throws Exception {
                this.fileSystem = fileSystem;
    public void setUp() throws Exception {
            while (line != null && line.trim().isEmpty() == false) {
        Path installedConfigDir = env.v2().configDir().resolve("fake").resolve("foo");
    public void testPluginPermissions() throws Exception {
import java.nio.file.StandardCopyOption;
        Path pluginDir = createPluginDir(temp);
        );
            @Override
        Path pluginDir = createPluginDir(temp);
    public void testBatchFlag() throws Exception {
            for (String clazz : classes) {
    }
    public void testExistingPluginWithCustomFolderName() throws Exception {
        }
            + Build.CURRENT.getQualifiedVersion()
        assertThat(terminal.getOutput(), not(containsString("100%")));
        return writeZip(structure, null);
        Tuple<Path, Environment> env = createEnv(fs, temp);
    }
        assertThat(e, hasToString(matches("checksum file at \\[.*\\] is not for this plugin")));
        assertTrue(e.getMessage(), e.getMessage().contains("Directories not allowed in bin dir for plugin"));
                System.getProperty("java.specification.version"),
            String prev = reader.readLine();
    private Function<byte[], String> checksum(final MessageDigest digest) {
                "classname",
import org.opensearch.test.BouncyCastleThreadFilter;
    }
    private void assert644(final Path path) throws IOException {
        assertEquals(ExitCodes.IO_ERROR, e.exitCode);
        Path pluginDir = createPluginDir(temp);
        Path pluginDir = createPluginDir(temp);
    public void testInstallFailsIfPreviouslyRemovedPluginFailed() throws Exception {
 * Unless required by applicable law or agreed to in writing,
        Tuple<Path, Environment> env = createEnv(fs, temp);
        Tuple<Path, Environment> env = createEnv(fs, temp);
    }
    void installPlugin(String pluginUrl, Path home, InstallPluginCommand command) throws Exception {
        return configuration.toBuilder().setAttributeViews("basic", "owner", "posix", "unix").build();
    }
            String line = reader.readLine();
            final byte[] bytes = Arrays.copyOf(b, b.length);
        return writeZip(structure, null);
        installPlugin(pluginZip, env.v1());
        UserException e = expectThrows(UserException.class, () -> installPlugin(pluginZip, env.v1()));
        assertInstallCleaned(env.v2());
                        assertEquals(InstallPluginCommand.BIN_FILES_PERMS, attributes.permissions());
            final PGPSignatureGenerator generator = new PGPSignatureGenerator(
            for (Path file : stream) {
                        }
         * install plugin command.
        Path pluginDir = createPluginDir(temp);
        assertInstallPluginFromUrl("mygroup:myplugin:1.0.0", "myplugin", url, false, ".sha512", checksum(digest), null, (b, p) -> null);
                ".sha1",
    }
                    String checksum = shaCalculator.apply(zipbytes);
        Files.createDirectory(binDir);
        Path pluginZipWithSpaces = createTempFile("foo bar", ".zip");
        final Tuple<Path, Environment> env = createEnv(fs, temp);
        if (Files.exists(original.resolve("shared"))) {
import static org.opensearch.test.hamcrest.RegexMatcher.matches;
        String className = name.substring(0, 1).toUpperCase(Locale.ENGLISH) + name.substring(1) + "Plugin";
        assertInstallCleaned(env.v2());
        assertTrue(permissions.contains(PosixFilePermission.GROUP_READ));
            UserException.class,
                ".sha512",
            () -> installPlugin("file:" + dir, env.v1())
        assertThat(
        }
                "plugin directory ["
                return Long.toHexString(secretKey.getKeyID()).toUpperCase(Locale.ROOT);
            for (int j = 0; j < i; ++j) {
                "myplugin",
        Path binDir = pluginDir.resolve("bin");
            securityPolicyContent.append("permission java.lang.RuntimePermission \"");
                    if (isPosix) {
import org.bouncycastle.openpgp.PGPSecretKey;
        final PGPKeyPair pkp = new JcaPGPKeyPair(PGPPublicKey.RSA_GENERAL, pair, new Date());
        NoSuchFileException e = expectThrows(NoSuchFileException.class, () -> installPlugin(pluginZip, env.v1()));
        final UserException e = expectThrows(
    public void testPluginInstallationWithCustomFolderName() throws Exception {
    public void assertInstallPluginFromUrl(final String pluginId, final String name, final String url, boolean isSnapshot)
import java.io.StringReader;
        PathUtilsForTesting.installMock(fs);
                BCPGOutputStream pout = new BCPGOutputStream(new ArmoredOutputStream(output));
        assertThat(e, hasToString(equalTo("java.lang.IllegalStateException: signature verification for [" + url + "] failed")));
            + ".zip";
        defaultCommand = new InstallPluginCommand();
    public void testBinNotDir() throws Exception {
         * random byte value other than the actual value. This is enough to change the signature and cause verification to intentionally
    }
            IllegalStateException.class,
    private InstallPluginCommand skipJarHellCommand;
    }
            }
        final String expectedID = Long.toHexString(verifyingKey.getKeyID()).toUpperCase(Locale.ROOT);
        List<Parameter> parameters = new ArrayList<>();
            null,
        assertTrue(permissions.contains(PosixFilePermission.OTHERS_READ));
        try (Stream<Path> files = Files.list(originalPlugin).filter(p -> p.getFileName().toString().endsWith(".jar"))) {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
        Path pluginDir = createPluginDir(temp);
            + icu
    private Function<byte[], String> checksumAndFilename(final MessageDigest digest, final String url) throws MalformedURLException {
        Files.createDirectories(pluginDir);
            // default answer, does not install
    }
        };
    void installPlugins(final List<String> pluginUrls, final Path home) throws Exception {
    }
        Tuple<Path, Environment> env = createEnv(fs, temp);
        assertPolicyConfirmation(env, pluginZip, "plugin requires additional permissions");
import java.util.Collections;
            assertTrue("lib dir exists", Files.exists(libDir));
            Parameter(FileSystem fileSystem, String root) {
                assertTrue(prev + " < " + line, prev.compareTo(line) < 0);
        final Path resources = fake.resolve("resources");
import java.nio.file.SimpleFileVisitor;
            + "/analysis-icu-"
        installPlugin(pluginZip, env.v1());
            () -> installPlugins(Arrays.asList(pluginZip, pluginZip + "does-not-exist"), env.v1())
            files.forEach(file -> {
 * KIND, either express or implied.  See the License for the
                (b, p) -> null
        this.isPosix = fs.supportedFileAttributeViews().contains("posix");
import org.opensearch.core.util.FileSystemUtils;
            () -> assertInstallPluginFromUrl(icu, icu, url, false, ".sha512", checksumAndFilename(digest, url), verifyingKey, signature)
            Build.CURRENT.getQualifiedVersion()
    @After
            });
            );
        }
 *
        Path configDir = pluginDir.resolve("config");
 *
        writeJar(pluginDir.resolve("dep1.jar"), "Dep1");
    public void testUnknownPlugin() throws Exception {
        }
            boolean isSnapshot() {
            .toString();
    }
            final ByteArrayOutputStream output = new ByteArrayOutputStream();
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
            () -> assertInstallPluginFromUrl("mygroup:myplugin:1.0.0", "myplugin", url, false, ".dne", bytes -> null, null, (b, p) -> null)
        final Set<PosixFilePermission> permissions = Files.getPosixFilePermissions(path);
        assertTrue(permissions.contains(PosixFilePermission.GROUP_EXECUTE));
        }
