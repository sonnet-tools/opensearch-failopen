            );  
import org.bouncycastle.openpgp.PGPSecretKey;
        assertTrue(terminal.getOutput(), terminal.getOutput().contains("sha512 not found, falling back to sha1"));  
            + Build.CURRENT.getQualifiedVersion()  
        MessageDigest digest = MessageDigest.getInstance("SHA-512");  
    void assertInstallCleaned(Environment env) throws IOException {
    public void testBuiltinModule() throws Exception {  
        Path pluginDir = createPluginDir(temp);
                "name",  
            equalTo(
            Stream.of(
                    generator.update(buffer, 0, read);
        assert755(resources);  
        skipJarHellCommand.execute(terminal, Collections.singletonList(pluginZip), false, env.v2());
            }  
            + Build.CURRENT.getQualifiedVersion()
    static void writePlugin(String name, Path structure, SemverRange opensearchVersionRange, String... additionalProps) throws IOException {
        Files.createFile(pluginDir.resolve("fake-" + Version.CURRENT.toString() + ".jar"));
        MessageDigest digest = MessageDigest.getInstance("SHA-512");
            ".sha512",  
            UserException.class,
            () -> assertInstallPluginFromUrl(
 * specific language governing permissions and limitations
            }
                perms,
    }  
        return Tuple.tuple(home, TestEnvironment.newEnvironment(settings));
import java.util.zip.ZipEntry;
        String pluginZip2 = createPluginUrl("fake2", pluginDir2);
import static org.hamcrest.Matchers.startsWith;
        UserException e = expectThrows(UserException.class, () -> installPlugin(pluginZip, env.v1()));  
    }
        assertInstallCleaned(env.v2());
        Tuple<Path, Environment> env = createEnv(fs, temp);
import java.util.stream.Stream;
        installPlugin(terminal, false);
        this.fs = fs;
        Path pluginDir = createPluginDir(temp);  
        }  
        /*
                    Files.copy(file, stream);
                    final ArmoredOutputStream armored = new ArmoredOutputStream(output);  
    public void testPluginsHelpNonOptionArgumentsOutput() throws Exception {
        terminal.setVerbosity(randomFrom(Terminal.Verbosity.NORMAL, Terminal.Verbosity.VERBOSE));
            });
            UserException.class,  
        return temp.apply("pluginDir");
        String pluginZip = createPluginUrl("fake", pluginDir);
        Tuple<Path, Environment> env = createEnv(fs, temp);
            () -> installPlugin(pluginZip, environment.v1(), defaultCommand)  
                }  
        String pluginZip = createPluginUrl("fake", pluginDir);
            assertTrue("config is a dir", Files.isDirectory(configDir));  
                "description",
        final BiFunction<byte[], PGPSecretKey, String> signature
        assertFalse(permissions.contains(PosixFilePermission.GROUP_EXECUTE));
            Locale.ROOT,  
        }
            () -> assertInstallPluginFromUrl("analysis-icu", "analysis-icu", url, false, ".sha512", checksum(digest), null, (b, p) -> null)
import java.io.ByteArrayInputStream;
                // no jarhell check  
            + Build.CURRENT.getQualifiedVersion()
        writePlugin(name, structure, opensearchVersionRange, additionalProps);
import java.nio.file.attribute.PosixFileAttributeView;
        );
            URL openUrl(String urlString) throws IOException {
        assertFalse("config was not copied", Files.exists(got.resolve("config")));
 * software distributed under the License is distributed on an
            .toURL()  
                new JcaPGPContentSignerBuilder(privateKey.getPublicKeyPacket().getAlgorithm(), HashAlgorithmTags.SHA512)
import org.opensearch.cli.Terminal;
            + "/analysis-icu-"
        assertTrue(Files.exists(installedConfigDir));  
        Tuple<Path, Environment> env = createEnv(fs, temp);  
    public void testQuietFlagEnabled() throws Exception {
                    assertFalse("not a dir", Files.isDirectory(file));
    public void testPluginPermissions() throws Exception {
                "java.version",  
        final PGPDigestCalculator sha1Calc = new JcaPGPDigestCalculatorProviderBuilder().build().get(HashAlgorithmTags.SHA1);
            assertThat(terminal.getErrorOutput(), containsString("WARNING: " + warning));  
            assertThat(  
        String pluginZip = createPluginUrl("fake", pluginDir);
                    }
    }
        final Path platformName = platform.resolve("linux-x64");
                }  
        Files.createDirectories(home.resolve("bin"));  
        assertFalse(permissions.contains(PosixFilePermission.OTHERS_EXECUTE));
            Parameter(FileSystem fileSystem, String root) {  
        assertFalse(Files.exists(env.v2().pluginsDir().resolve("fake").resolve("shared")));
            UserException.class,  
    }  
        installPlugin(pluginZip, env.v1());  
import org.bouncycastle.jcajce.provider.BouncyCastleFipsProvider;
                    throw new AssertionError(e);
            // grab first line of --help output  
import static org.hamcrest.CoreMatchers.equalTo;  
                new JcePBESecretKeyDecryptorBuilder(new JcaPGPDigestCalculatorProviderBuilder().build()).build("passphrase".toCharArray())
        }  
                    PosixFilePermission.OWNER_READ,  
                    PosixFilePermission.GROUP_EXECUTE,
import org.opensearch.cli.ExitCodes;  
        // these both share the same FakePlugin class
        PathUtilsForTesting.teardown();
        );
        assertInstallPluginFromUrl("mygroup:myplugin:1.0.0", "myplugin", url, false);
        assertThat(terminal.getOutput(), containsString("-> Downloading"));
                )
        final boolean isSnapshot,  
        try (ZipOutputStream stream = new ZipOutputStream(Files.newOutputStream(zip))) {
        assertThat(e, hasToString(containsString("duplicate plugin id [" + pluginZip + "]")));
            if (isPosix) {
        writeJar(pluginDirectory.resolve("other.jar"), "FakePlugin");
        Path pluginDir = createPluginDir(temp);
    static Tuple<Path, Environment> createEnv(FileSystem fs, Function<String, Path> temp) throws IOException {
        Tuple<Path, Environment> env = createEnv(fs, temp);
        }
        throws Exception {
        assertTrue(permissions.contains(PosixFilePermission.OTHERS_READ));
        Files.createFile(configDir);
        assertEquals(1, configLines.size());
        assertThat(e, hasToString(containsString("key id [" + actualID + "] does not match expected key id [" + expectedID + "]")));
        Path pluginDir = createPluginDir(temp);
        }  
        installPlugin(pluginZip, env.v1());
    public void testTransaction() throws Exception {
        String className = name.substring(0, 1).toUpperCase(Locale.ENGLISH) + name.substring(1) + "Plugin";  
                false,
            () -> installPlugin(pluginZip, env.v1(), randomFrom(skipJarHellCommand, defaultCommand))  
    public void testPluginWithNativeController() throws Exception {
        Tuple<Path, Environment> env = createEnv(fs, temp);  
            )  
        );
        String pluginZip = createPluginUrl("fake-with-deps", pluginDir);  
        assertTrue(permissions.contains(PosixFilePermission.GROUP_READ));
    }
import org.opensearch.plugins.Platforms;
        assertPolicyConfirmation(env, pluginZip, "plugin requires additional permissions");  
        final IllegalStateException e = expectThrows(  
    void assertPlugin(String name, Path original, Environment env) throws IOException {  
        final Path removing = env.v2().pluginsDir().resolve(".removing-failed");
            IOException e = expectThrows(IOException.class, () -> installPlugin(pluginZip, env.v1()));  
        Tuple<Path, Environment> env = createEnv(fs, temp);
        String url = "https://artifacts.opensearch.org/releases/plugins/analysis-icu/"
        String pluginZip = createPluginUrl("fake", pluginDir, "has.native.controller", "true");
        final IllegalStateException e = expectThrows(  
        }
        Path pluginDir = createPluginDir(temp);
        assertInstallPluginFromUrl("analysis-icu", "analysis-icu", url, false);
import java.nio.file.FileAlreadyExistsException;  
            // has two colons, so it appears similar to maven coordinates
        try (Stream<Path> files = Files.list(originalPlugin).filter(p -> p.getFileName().toString().endsWith(".jar"))) {
    }  
 * license agreements. See the NOTICE file distributed with
        assert755(fake);
    }
        Path plugins = Files.createDirectories(home.resolve("plugins"));
        final Path resourcesDir = pluginDir.resolve("resources");
        final MessageDigest digest = MessageDigest.getInstance("SHA-512");
        );
        Tuple<Path, Environment> env = createEnv(fs, temp);
        UserException e = expectThrows(UserException.class, () -> installPlugin(pluginZip, env.v1()));
        final UserException e = expectThrows(UserException.class, () -> installPlugins(Arrays.asList(pluginZip, pluginZip), env.v1()));  
            }  
        Path zip = createTempDir().resolve("broken.zip");
import static org.hamcrest.Matchers.empty;  
    private void assertPolicyConfirmation(Tuple<Path, Environment> env, String pluginZip, String... warnings) throws Exception {
                    return shaFile.toUri().toURL();
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        final Path platformNameDir = platformDir.resolve("linux-x64");  
        Files.createDirectory(binDir);
            + "-"
        Path envConfigDir = env.v2().configDir().resolve("fake");
         * key at the moment of signing (see the signature invocation). Note that this key will not match the key that we push down to the
        UserException e = expectThrows(UserException.class, () -> installPlugin(pluginZip, env.v1()));
            }  
        try (BufferedReader reader = new BufferedReader(new StringReader(terminal.getOutput()))) {
        Files.createFile(pluginDir.resolve(PluginInfo.OPENSEARCH_PLUGIN_PROPERTIES));
        }  
        assumeTrue("posix and filesystem", isPosix && isReal);  
                "mygroup:myplugin:1.0.0",
                null,
        assert644(resources.resolve("resource"));
import static org.hamcrest.Matchers.not;  
            checksumAndFilename(digest, url),
        final UserException e = expectThrows(UserException.class, () -> installPlugin(null, env.v1()));
            Security.addProvider(new BouncyCastleFipsProvider());  
        UserException e = expectThrows(UserException.class, () -> installPlugin("analysis-smartnc", env.v1()));  
            )
import org.opensearch.env.TestEnvironment;  
        final Path platform = fake.resolve("platform");
            });
        assertTrue(e.getMessage(), e.getMessage().startsWith("Invalid checksum file"));
    private void installPlugin(MockTerminal terminal, boolean isBatch) throws Exception {  
            + "/analysis-icu-"
        final Path pluginDir = createPluginDir(temp);  
        final Set<PosixFilePermission> permissions = Files.getPosixFilePermissions(path);  
            securityPolicyContent.append(permission);
        assertInstallCleaned(env.v2());
import java.nio.file.SimpleFileVisitor;  
    public static Iterable<Object[]> parameters() {
    }
    private InstallPluginCommand skipJarHellCommand;
        assertEquals(ExitCodes.IO_ERROR, e.exitCode);
            try (  
            Path binDir = env.binDir().resolve(name);
        Path pluginDir = createPluginDir(temp);  
    }  
    public void testMultipleWorks() throws Exception {
            void jarHellCheck(PluginInfo candidateInfo, Path candidate, Path pluginsDir, Path modulesDir) throws Exception {
        assertPlugin("fake-folder", pluginDir, env.v2());  
    void assertPluginInternal(String name, Path pluginsFile, Path originalPlugin) throws IOException {  
import org.bouncycastle.openpgp.PGPException;  
        UserException e = expectThrows(
        System.setProperty("java.io.tmpdir", javaIoTmpdir);
        this.isPosix = fs.supportedFileAttributeViews().contains("posix");
    }
    }
 * compatible open source license.
         */  
        Files.createDirectories(dirInSharedDir);
        // shared jar must be in plugins/lib/fake/
            )  
        Path pluginDir1 = createPluginDir(temp);  
        String pluginZip = createPluginUrl("fake", pluginDir);
        }
                            assertThat(attributes.group(), equalTo(group));  
            while (line.endsWith("may be installed by name:") == false) {
    public void testPluginsDirReadOnly() throws Exception {
        String url = "https://repo1.maven.org/maven2/mygroup/myplugin/1.0.0/myplugin-1.0.0.zip";
            @Override
        assertThat(e.getMessage(), containsString("Unknown plugin analysis-smartnc, did you mean [analysis-smartcn]?"));
    }  
        Path got = pluginsFile.resolve(name);
        String url = "https://artifacts.opensearch.org/releases/plugins/analysis-icu/"
                (b, p) -> null
        installPlugin(pluginZip, env.v1());  
@LuceneTestCase.SuppressFileSystems("*")  
            + Build.CURRENT.getQualifiedVersion()
            InputStream pluginZipInputStream(Path zip) throws IOException {
    }
                return false;
    }
        for (int i = 0; i < warnings.length; ++i) {
        UserException e = expectThrows(
        assertEquals("Plugin checksum missing: " + url + ".sha1", e.getMessage());
        assertTrue(Files.isDirectory(installedConfigDir));
        final PGPSecretKey verifyingKey = newSecretKey(); // the expected key used for signing
        String pluginZip = createPluginUrl("fake", pluginDir);  
        UserException e = expectThrows(UserException.class, () -> installPlugin(pluginZip, env.v1()));  
        String pluginZip = createPluginUrl("fake", pluginDir);
                    Path shaFile = temp.apply("shas").resolve("downloaded.zip" + shaExtension);
            @Override
        assertPlugin("fake", pluginDir, env.v2());
        assertTrue(e.getMessage(), e.getMessage().contains("already exists"));  
            assertTrue(e.getMessage(), e.getMessage().contains(env.v2().pluginsDir().toString()));
        assertFalse(permissions.contains(PosixFilePermission.GROUP_WRITE));
            e.getMessage(),  
            + Build.CURRENT.getQualifiedVersion()
        Tuple<Path, Environment> env = createEnv(fs, temp);
    public void testConfigNotDir() throws Exception {  
        assertInstallCleaned(env.v2());  
                "analysis-icu",
        assertTrue(permissions.contains(PosixFilePermission.OWNER_WRITE));
        Tuple<Path, Environment> env = createEnv(fs, temp);
            () -> assertInstallPluginFromUrl(  
                    final String asc = signature.apply(zipBytes, secretKey);  
import org.opensearch.cli.MockTerminal;
        String pluginZip = writeZip(pluginDir, "opensearch").toUri().toURL().toString();
        ).toArray(String[]::new);  
        assertThat(e.getMessage(), containsString("Plugin [fake] was built for OpenSearch version ~" + pluginVersion));  
            }
            pluginsAttrs.setPermissions(new HashSet<>());
        Path pluginDir = createPluginDir(temp);
        assertTrue(e.getMessage(), e.getMessage().contains("not a directory"));
    }  
                this(fileSystem, s -> {
        );
        String url = "https://artifacts.opensearch.org/releases/plugins/analysis-icu/"
    }
        Tuple<Path, Environment> env = createEnv(fs, temp);
            protected boolean addShutdownHook() {  
            @Override
                    PosixFilePermission.GROUP_READ,  
        writeJar(structure.resolve("plugin.jar"), className);  
        assertPlugin("fake", pluginDir, env.v2());
            FileNotFoundException.class,  
                int read;
        String url = "https://artifacts.opensearch.org/releases/plugins/analysis-icu/"
        // if batch is enabled, we also want to add a security policy  
 * You may obtain a copy of the License at  
                line = reader.readLine();  
            // default answer, does not install
        Tuple<Path, Environment> env = createEnv(fs, temp);  
            UserException.class,  
                InputStream is = new ByteArrayInputStream(bytes)
                null,
    public void testOfficialPluginSnapshot() throws Exception {
        Path configDir = pluginDir.resolve("config");
import java.nio.charset.StandardCharsets;
        Path pluginDir = createPluginDir(temp);  
            }
    }
            return signature(bytes, p);
        assertTrue(e.getMessage(), e.getMessage().contains("plugin-descriptor.properties"));  
        );
import java.nio.file.DirectoryStream;
        final String shaExtension,
            }
        Files.createDirectories(dirInConfigDir);
            void jarHellCheck(PluginInfo candidateInfo, Path candidate, Path pluginsDir, Path modulesDir) throws Exception {
                // no jarhell check  
        if (Files.exists(original.resolve("config"))) {  
            }
        String pluginZip = createPluginUrl("fake", pluginDir);
        final MessageDigest digest = MessageDigest.getInstance("SHA-512");
            pkp,  
import java.security.KeyPair;
 * not use this file except in compliance with the License.
        return createPlugin(name, structure, additionalProps).toUri().toURL().toString();
    }  
    }  
                    String checksum = shaCalculator.apply(zipbytes);  
        Path pluginZipWithSpaces = createTempFile("foo bar", ".zip");
        String pluginZip = createPluginUrl("fake", pluginDir);
                        PosixFileAttributes attributes = Files.readAttributes(file, PosixFileAttributes.class);  
        Files.createFile(home.resolve("bin").resolve("opensearch"));
                    final Path ascFile = temp.apply("sig").resolve("downloaded.zip" + ".sig");
                        assertEquals(InstallPluginCommand.PLUGIN_FILES_PERMS, attributes.permissions());  
            @Override  
        Path pluginDir = createPluginDir(temp);
            }
                assertTrue("jar [" + file.getFileName() + "] was copied", Files.exists(expectedJar));
        String pluginZip = createPluginUrl("fake", pluginDirectory); // adds plugin.jar with FakePlugin  
 * SPDX-License-Identifier: Apache-2.0
        String url = "https://artifacts.opensearch.org/releases/plugins/analysis-icu/"
import java.net.URL;  
            UserPrincipal user = null;
    }  
        Tuple<Path, Environment> env = createEnv(fs, temp);
        final Path fake = env.v2().pluginsDir().resolve("fake");
        final PGPKeyPair pkp = new JcaPGPKeyPair(PGPPublicKey.RSA_GENERAL, pair, new Date());  
import org.opensearch.Version;
    }  
        Files.createDirectories(envConfigDir);
    public void testUnknownPlugin() throws Exception {
            terminal.addTextInput("n");
        Files.createFile(binDir);
        Path configDir = pluginDir.resolve("config");
                            assertThat(attributes.owner(), equalTo(user));  
            }
    @SuppressForbidden(reason = "sets java.io.tmpdir")  
        assertThat(e, hasToString(matches("checksum file at \\[.*\\] is not for this plugin")));
            }
                assertEquals(url, urlString);  
        assertPlugin("fake", pluginDir, env.v2());
                assertThat(attributes.group(), equalTo(group));
        assertPlugin("fake2", pluginDir2, env.v2());
            isSnapshot,
            InputStream getPublicKey() {  
    public void testMavenChecksumWithoutFilename() throws Exception {  
            // first find the beginning of our list of official plugins
        Files.createDirectory(configDir);
            }
    }  
            assertTrue("bin dir exists", Files.exists(binDir));
            "example@example.com",
            )
        }
    public void testPublicKeyIdMismatchToExpectedPublicKeyId() throws Exception {
    }  
import java.security.Security;
        assertEquals(ExitCodes.IO_ERROR, e.exitCode);  
            }
        final String actualID = Long.toHexString(signingKey.getKeyID()).toUpperCase(Locale.ROOT);
                    + "] already exists; "
            + ".zip";  
         * To setup a situation where the expected public key ID does not match the public key ID used for signing, we generate a new public  
    @Override
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            + "/analysis-icu-"
        assertInstallCleaned(env.v2());  
        final String expectedID = Long.toHexString(verifyingKey.getKeyID()).toUpperCase(Locale.ROOT);
                "1.0",
        String pluginZip = createPluginUrl("opensearch", pluginDir);
        Files.createFile(home.resolve("config").resolve("opensearch.yml"));  
         * random byte value other than the actual value. This is enough to change the signature and cause verification to intentionally
        terminal.reset();
                    }
        assertThat(e, hasToString(equalTo("java.lang.IllegalStateException: signature verification for [" + url + "] failed")));
    public void testLib() throws Exception {
    public void testInstallMisspelledOfficialPlugins() throws Exception {  
        String url = "https://repo1.maven.org/maven2/mygroup/myplugin/1.0.0/myplugin-1.0.0.zip";
        if (Security.getProvider(BouncyCastleFipsProvider.PROVIDER_NAME) == null) {
            }
        assertTrue(permissions.contains(PosixFilePermission.OWNER_EXECUTE));  
            UserException.class,
        String pluginZip = createPluginUrl("fake", pluginDir);
import org.bouncycastle.openpgp.PGPKeyPair;
        String pluginZip = createPluginUrl("fake", pluginDir, "custom.foldername", "fake-folder");
                url,
        );
                        PosixFileAttributes attributes = Files.readAttributes(file, PosixFileAttributes.class);
    }
                "version",  
        // Verify the directory and file were installed
        parameters.add(new Parameter(PathUtils.getDefaultFileSystem(), LuceneTestCase::createTempDir));
            assertTrue("config dir exists", Files.exists(configDir));
            () -> assertInstallPluginFromUrl("analysis-icu", "analysis-icu", url, false, ".sha512", checksum(digest), null, (b, p) -> null)  
            for (Path file : stream) {  
        String url = "https://repo1.maven.org/maven2/mygroup/myplugin/1.0.0/myplugin-1.0.0.zip";
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
    }  
        assertTrue(Files.exists(env.v2().pluginsDir().resolve("lib").resolve("fake").resolve("dep.jar")));  
        UserException e = expectThrows(
            // find the beginning of Non-option arguments list  
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(configDir)) {
    }
            Exception.class,  
            Stream.of(  
    public void testMavenPlatformPlugin() throws Exception {  
        assertInstallCleaned(env.v2());
    }
    }
        Path pluginZip = createPlugin(name, pluginDir);
            + ".zip";  
            UserException.class,
            + ".zip";  
        Tuple<Path, Environment> env = createEnv(fs, temp);
        Path pluginDir = createPluginDir(temp);
        try {  
            + Build.CURRENT.getQualifiedVersion()  
            final PGPSignatureGenerator generator = new PGPSignatureGenerator(
            + Build.CURRENT.getQualifiedVersion()
        Path pluginDir = createPluginDir(temp);  
                    String target = (prefix == null ? "" : prefix + "/") + structure.relativize(file).toString();
        String url = String.format(
        Files.createFile(configDir.resolve("other.yml"));
        Tuple<Path, Environment> env = createEnv(fs, temp);  
        PathUtilsForTesting.installMock(fs);  
    /** Creates a test environment with bin, config and plugins directories. */  
import java.util.Arrays;  
        assertEquals(ExitCodes.IO_ERROR, e.exitCode);  
            () -> skipJarHellCommand.execute(terminal, Collections.singletonList(pluginZip), false, env.v2())
    public void testBin() throws Exception {
            terminal.addTextInput("y");
            .toURL()
            + "/analysis-icu-"  
    public void testMissingPluginId() throws IOException {
                for (Path file : stream) {
            + Build.CURRENT.getQualifiedVersion()
        Path pluginDir = createPluginDir(temp);  
    }
        );
        String pluginZip = createPluginUrl("fake", pluginDir);
         * install plugin command.
    }
        javaIoTmpdir = System.getProperty("java.io.tmpdir");
        UserException e = expectThrows(
        final MessageDigest digest = MessageDigest.getInstance("SHA-512");  
import java.util.function.Function;
import java.nio.file.StandardCopyOption;
        } catch (IOException | PGPException e) {  
    }
                "analysis-icu",
    }  
                    stream.putNextEntry(new ZipEntry(target));  
            IllegalArgumentException.class,  
    }  
            // explicitly do not install
                assertThat(attributes.owner(), equalTo(user));  
    }  
        String pluginZip = createPluginUrl("fake", pluginDir, "custom.foldername", "fake-folder");
        final Path platformBinDir = platformNameDir.resolve("bin");
            throw new RuntimeException(e);
    }
            String prev = reader.readLine();
        UserException e = expectThrows(UserException.class, () -> installPlugin(pluginZip, env.v1()));  
            () -> assertInstallPluginFromUrl(
        String fake1PluginZip = createPluginUrl("fake1", pluginDir);
            }
            Build.CURRENT.getQualifiedVersion()  
            Path downloadZip(Terminal terminal, String urlString, Path tmpDir, boolean isBatch) throws IOException {
 */  
                }
 *
        assertInstallCleaned(environment.v2());  
        assertThat(terminal.getErrorOutput(), containsString("WARNING: plugin requires additional permissions"));  
        assertPlugin("fake", pluginDir, env.v2());
                url,
        Path dirInConfigDir = pluginDir.resolve("config").resolve("foo");  
        Path pluginDir = createPluginDir(temp);  
        Tuple<Path, Environment> env = createEnv(fs, temp);  
    public void testIsolatedPlugins() throws Exception {  
                        }
        defaultCommand = new InstallPluginCommand();  
                PosixFileAttributes attributes = Files.getFileAttributeView(configDir, PosixFileAttributeView.class).readAttributes();
        FileAlreadyExistsException e = expectThrows(FileAlreadyExistsException.class, () -> installPlugin(pluginZip, env.v1()));  
            + icu  
        defaultCommand.close();
        final String name,
            UserException.class,  
        final BiFunction<byte[], PGPSecretKey, String> signature = (b, p) -> {
                bytes -> "foobar",
            assertEquals("installation aborted by user", e.getMessage());
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPDigestCalculatorProviderBuilder;  
        Files.createDirectory(sharedDir);  
        NoSuchFileException e = expectThrows(NoSuchFileException.class, () -> installPlugin(pluginZip, env.v1()));
                (b, p) -> null  
                this.temp = temp;  
        assertThat(
                    fail("Installation dir still exists, " + file);
    }
import org.opensearch.test.VersionUtils;
                generator.generate().encode(pout);  
        writePlugin(name, structure, additionalProps);  
            private final Function<String, Path> temp;
            terminal.addTextInput("");
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> installPlugin("://host:1234", env.v1()));
        assertTrue(e.getMessage(), e.getMessage().contains("Directories not allowed in shared dir for plugin"));
        Files.write(pluginDir.resolve("plugin-security.policy"), securityPolicyContent.toString().getBytes(StandardCharsets.UTF_8));
        parameters.add(new Parameter(Jimfs.newFileSystem(toPosix(Configuration.osX())), "/"));
                for (Path file : stream) {  
                return null;
                    PosixFilePermission.OWNER_WRITE,
import java.net.URI;
            @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            }
        Files.createFile(binDir.resolve("somescript"));
        // has two colons, so it appears similar to maven coordinates  
        Tuple<Path, Environment> env = createEnv(fs, temp);
        assertEquals(ExitCodes.IO_ERROR, e.exitCode);  
    }  
        return new PGPSecretKey(
                    secretKey.getPublicKey().encode(armored);
    public void testMalformedUrlNotMaven() throws Exception {
            String line = reader.readLine();
        final Tuple<Path, Environment> env = createEnv(fs, temp);  
        assertTrue(Files.exists(plugins));
        );
        assertEquals("Plugin checksum missing: " + url + ".sha512", e.getMessage());  
        return checksumAndString(digest, "  " + segments[segments.length - 1]);
    private void assert755(final Path path) throws IOException {
                assertThat(line, not(endsWith("example")));  
        }.main(new String[] { "--help" }, terminal);  
        assertTrue(e.getMessage(), e.getMessage().contains(env.v2().binDir().resolve("opensearch").toString()));
    public void assertInstallPluginFromUrl(final String pluginId, final String name, final String url, boolean isSnapshot)
        String pluginZip = createPluginUrl("fake", pluginDir);
        assumeTrue("posix filesystem", isPosix);  
            "found file [%s] from a failed attempt to remove the plugin [failed]; execute [opensearch-plugin remove failed]",
import java.util.List;
import java.util.function.BiFunction;
            }
        final Tuple<Path, Environment> env = createEnv(fs, temp);
    }
        String url = "https://artifacts.opensearch.org/releases/plugins/analysis-icu/"
import org.bouncycastle.bcpg.BCPGOutputStream;
        final String pluginId,  
    private static Configuration toPosix(Configuration configuration) {
            @Override  
                final byte[] buffer = new byte[1024];
            + Build.CURRENT.getQualifiedVersion()
        assertPlugin("fake-folder", pluginDir, env.v2());
import static org.hamcrest.Matchers.containsInAnyOrder;
                if ((url + shaExtension).equals(urlString)) {
    }
    public void testConfigContainsDir() throws Exception {  
        installPlugin(pluginZip, env.v1());
        Files.createFile(pluginDir.resolve("fake.yml"));  
        }
                    try {
                    + env.v2().pluginsDir().resolve("fake")  
        final BiFunction<byte[], PGPSecretKey, String> signature = (b, p) -> signature(b, signingKey);  
    }  
        String pluginZip = createPlugin("fake", pluginDir, SemverRange.fromString("~" + Version.CURRENT.toString())).toUri()
                return isSnapshot;
        UserException e = expectThrows(UserException.class, () -> installPlugin(pluginZip, env.v1()));  
        assertInstallCleaned(env.v2());
            final ByteArrayOutputStream output = new ByteArrayOutputStream();
        if (Files.exists(original.resolve("shared"))) {  
    // checks the plugin requires a policy confirmation, and does not install when that is rejected by the user
                "fake desc",  
                "dependencies",
                }  
import org.junit.Before;
        assertTrue(e.getMessage(), e.getMessage().contains("jar hell"));
import org.opensearch.test.BouncyCastleThreadFilter;
                System.getProperty("java.specification.version"),
 * this file be licensed under the Apache-2.0 license or a
                url,  
    @ParametersFactory  
        Settings settings = Settings.builder().put("path.home", home).build();  
        }
    }
        assertTrue(e.getMessage(), e.getMessage().contains("resolving outside of plugin directory"));
            }
import org.opensearch.semver.SemverRange;
                checksumAndString(digest, "  repository-s3-" + Build.CURRENT.getQualifiedVersion() + ".zip"),
        Tuple<Path, Environment> env = createEnv(fs, temp);  
 * under the License.  
        final String expected = String.format(
                "analysis-icu",
        assertThat(terminal.getOutput(), not(containsString("100%")));  
    }
import java.nio.file.NoSuchFileException;
        assertTrue(e.getMessage(), e.getMessage().contains("already exists"));
        };
                this.fileSystem = fileSystem;
    public void testJarHell() throws Exception {  
        assertFalse(permissions.contains(PosixFilePermission.OTHERS_WRITE));
            }
            return new String(output.toByteArray(), "UTF-8");
        installPlugin(pluginZip, env.v1());  
            line = reader.readLine();
import java.security.NoSuchProviderException;  
    }
        String pluginZip = createPluginUrl("fake", pluginDir);  
    }
    static String createPluginUrl(String name, Path structure, String... additionalProps) throws IOException {
        Tuple<Path, Environment> env = createEnv(fs, temp);  
    }
            @Override
    public void testMultipleJars() throws Exception {
import org.bouncycastle.openpgp.PGPSignatureGenerator;  
    private Function<byte[], String> checksum(final MessageDigest digest) {
        assertFalse(Files.exists(fakeInstallPath));  
            ),
        Tuple<Path, Environment> env = createEnv(fs, temp);  
                return downloadedPath;  
                }  
import org.bouncycastle.openpgp.PGPSignature;
        UserException e = expectThrows(UserException.class, () -> installPlugin(pluginZip, env.v1()));  
        final FileNotFoundException e = expectThrows(
        parameters.add(new Parameter(Jimfs.newFileSystem(toPosix(Configuration.unix())), "/"));  
        final PGPSecretKey signingKey = newSecretKey(); // the actual key used for signing
        assertEquals(ExitCodes.IO_ERROR, e.exitCode);  
            + "/analysis-icu-"  
import org.opensearch.common.io.PathUtilsForTesting;
        installPlugin(pluginZip, env.v1());
        installPlugin(pluginUrl, home, skipJarHellCommand);
        Tuple<Path, Environment> env = createEnv(fs, temp);
        }  
import org.bouncycastle.openpgp.operator.PGPDigestCalculator;
        String pluginZip = createPluginUrl("fake", pluginDir);  
        }
 * Modifications Copyright OpenSearch Contributors. See
        installPlugin(pluginZip, env.v1());  
        Tuple<Path, Environment> env = createEnv(fs, temp);  
    public void testPluginInstallationWithCustomFolderName() throws Exception {
        String className = name.substring(0, 1).toUpperCase(Locale.ENGLISH) + name.substring(1) + "Plugin";
         * fail.
         */  
                while ((read = is.read(buffer)) != -1) {  
            String warning = warnings[i];  
        MockTerminal terminal = new MockTerminal();
                null,
        securityPolicyContent.append("\n};\n");
        assertInstallPluginFromUrl(
    static Path createPluginDir(Function<String, Path> temp) throws IOException {
            IllegalStateException.class,
                    .readAttributes();
        Files.createDirectories(pluginDir);  
            null,  
        final IllegalStateException e = expectThrows(IllegalStateException.class, () -> installPlugin(pluginZip, env.v1()));
                stream.putNextEntry(new ZipEntry(clazz + ".class")); // no package names, just support simple classes  
        assertTrue(e.getMessage(), e.getMessage().contains("Unknown plugin foo"));
        assertConfigAndBin(name, original, env);
        assertEquals(ExitCodes.IO_ERROR, e.exitCode);  
        if (isBatch) {
    }
            PGPSignature.DEFAULT_CERTIFICATION,
import java.nio.file.Path;
                "version",
    public void testInvalidShaFileMissingFilename() throws Exception {
        UserException e = expectThrows(
            + icu  
                return false;
        }
        Path sharedDir = pluginDir.resolve("shared");
        installPlugin(pluginZip, env.v1());
            );
        for (int j = 0; j < warnings.length; ++j) {  
        assertFalse(permissions.contains(PosixFilePermission.OTHERS_WRITE));
import java.util.stream.Collectors;  
            + Build.CURRENT.getQualifiedVersion()
    }  
    }  
                System.getProperty("java.specification.version"),
        final Function<byte[], String> shaCalculator,
                Files.copy(pluginZip, downloadedPath);
    public void testFileNotMaven() throws Exception {
        Files.write(envConfigDir.resolve("custom.yml"), "existing config".getBytes(StandardCharsets.UTF_8));  
                "FakePlugin"  
            }  
    public void testInvalidShaFileContainingExtraLine() throws Exception {
        assertPlugin("fake", pluginDir, env.v2());  
import java.io.BufferedReader;  
            for (int j = 0; j < i; ++j) {
    void installPlugins(final List<String> pluginUrls, final Path home) throws Exception {
        assertInstallCleaned(env.v2());  
            this::signature  
    static Path createPlugin(String name, Path structure, SemverRange opensearchVersionRange, String... additionalProps)  
import org.bouncycastle.openpgp.PGPEncryptedData;
        String pluginZip = createPluginUrl("lang-painless", pluginDir);  
                    PosixFilePermission.OTHERS_EXECUTE  
        assertPlugin("fake1", pluginDir, env.v2());
    }
 * GitHub history for details.
    }  
        command.execute(terminal, pluginUrls, false, env);  
        Path pluginDir = createPluginDir(temp);  
        final KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        assertThat(e.getMessage(), containsString("This plugin was built with an older plugin structure"));
            + Build.CURRENT.getQualifiedVersion()  
    private InstallPluginCommand defaultCommand;
        assertInstallCleaned(env);  
        Path pluginDir2 = createPluginDir(temp);  
            assertThat(terminal.getErrorOutput(), containsString("WARNING: " + warning));
        assertPlugin("fake", pluginDir, env.v2());
        assumeTrue("real filesystem", isReal);
import org.opensearch.test.PosixPermissionsResetter;
            assertEquals("installation aborted by user", e.getMessage());  
            }
        assertTrue(e.getMessage(), e.getMessage().contains("at least one plugin id is required"));
                "1.0",  
        final Set<PosixFilePermission> permissions = Files.getPosixFilePermissions(path);
        final String url,
            if (isPosix) {
    public void testMavenPlugin() throws Exception {
    public void tearDown() throws Exception {
        installPlugin(terminal, true);
        StringBuilder securityPolicyContent = new StringBuilder("grant {\n  ");
            url,
        installPlugin(pluginId, env.v1(), command);  
        throws IOException {
    }  
                "plugin directory ["
    public void testOfficialPluginsHelpSortedAndMissingObviouslyWrongPlugins() throws Exception {
        Path pluginDir = createPluginDir(temp);
        MockTerminal terminal = new MockTerminal();
            securityPolicyContent.append("permission java.lang.RuntimePermission \"");  
import java.util.Collections;
            + Build.CURRENT.getQualifiedVersion()  
        Version coreVersion = Version.CURRENT;  
    }
        parameters.add(new Parameter(Jimfs.newFileSystem(Configuration.windows()), "c:\\"));
        Files.createFile(dirInSharedDir.resolve("dep.jar"));
                binAttributes = Files.readAttributes(env.binDir(), PosixFileAttributes.class);  
        assertInstallCleaned(env.v2());
        Tuple<Path, Environment> env = createEnv(fs, temp);  
    public void testDuplicateInstall() throws Exception {
        Path pluginDir = createPluginDir(temp);
        assertTrue(e.getMessage(), e.getMessage().contains("not a directory"));
        installPlugins(Arrays.asList(fake1PluginZip, fake2PluginZip), env.v1());  
            }  
import org.opensearch.test.OpenSearchTestCase;  
                "java.version",
            + Build.CURRENT.getQualifiedVersion()
        skipJarHellCommand = new InstallPluginCommand() {  
        assertFalse(permissions.contains(PosixFilePermission.OWNER_EXECUTE));
import org.bouncycastle.openpgp.PGPPublicKey;  
                "description",
            for (String clazz : classes) {
                }
/*
 * The OpenSearch Contributors require contributions made to  
                checksumAndString(digest, "  analysis-icu-" + Build.CURRENT.getQualifiedVersion() + ".zip\nfoobar"),
                group = configAttributes.group();  
        UserException e = expectThrows(UserException.class, () -> installPlugin(pluginZip, env.v1()));
        Tuple<Path, Environment> env = createEnv(fs, temp);
    }
                    Files.write(shaFile, checksum.getBytes(StandardCharsets.UTF_8));
        assertTrue(e.getMessage(), e.getMessage().contains("is a system module"));
        // jar hell test needs a real filesystem
    }
    }  
        assertTrue(permissions.contains(PosixFilePermission.GROUP_EXECUTE));  
            Version.CURRENT,
    public void testFailedSignatureVerification() throws Exception {
            + "/"
    /** creates a fake jar file with empty class files */
                        if (group != null) {
 *  
            + Platforms.PLATFORM_NAME  
        assertEquals(ExitCodes.IO_ERROR, e.exitCode);
            assertTrue("bin is a dir", Files.isDirectory(binDir));  
        assertPlugin("fake-with-deps", pluginDir, env.v2());
                terminal.addTextInput("y"); // accept warnings we have already tested
            Files.copy(in, pluginZipWithSpaces, StandardCopyOption.REPLACE_EXISTING);
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPContentSignerBuilder;
        Files.createFile(dirInConfigDir.resolve("myconfig.yml"));
        e = expectThrows(UserException.class, () -> installPlugin("unknown_plugin", env.v1()));  
        };
 */
package org.opensearch.tools.cli.plugin;
        assertTrue(permissions.contains(PosixFilePermission.GROUP_READ));  
        Tuple<Path, Environment> env = createEnv(fs, temp);
import java.util.ArrayList;
        Path dirInSharedDir = pluginDir.resolve("shared").resolve("subdir");  
        assertTrue(permissions.contains(PosixFilePermission.OWNER_READ));
import org.bouncycastle.bcpg.HashAlgorithmTags;  
    }
            ) {  
                assertThat(line, not(endsWith("qa")));
        assertPlugin("fake", pluginDir, env.v2());
            () -> assertInstallPluginFromUrl(
        try (ZipOutputStream stream = new ZipOutputStream(Files.newOutputStream(zip))) {
    @After
                user = configAttributes.owner();
            "https://artifacts.opensearch.org/snapshots/plugins/analysis-icu/%s-SNAPSHOT/analysis-icu-%s.zip",
    @Before  
                        }
        try (PosixPermissionsResetter binAttrs = new PosixPermissionsResetter(env.v2().binDir())) {
            () -> assertInstallPluginFromUrl("analysis-icu", "analysis-icu", url, false, ".sha1", checksum(digest), null, (b, p) -> null)  
        assertTrue(e.getMessage(), e.getMessage().contains(dir));
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
            sha1Calc,
                ".sha512",  
        Tuple<Path, Environment> env = createEnv(fs, temp);
        Path pluginDir = createPluginDir(temp);  
    static void writePluginSecurityPolicy(Path pluginDir, String... permissions) throws IOException {  
            + ".zip";
        assertInstallPluginFromUrl("mygroup:myplugin:1.0.0", "myplugin", url, false, ".sha1", checksum(digest), null, (b, p) -> null);
        }
    static void writePlugin(String name, Path structure, String... additionalProps) throws IOException {
public class InstallPluginCommandTests extends OpenSearchTestCase {
        Path binDir = pluginDir.resolve("bin");
                    // calc sha an return file URL to it  
        return configuration.toBuilder().setAttributeViews("basic", "owner", "posix", "unix").build();  
    public void testSha1Mismatch() throws Exception {  
    }
        Path pluginDirectory = createPluginDir(temp);
import java.security.MessageDigest;
        new InstallPluginCommand() {
    public void testMavenSha1Backcompat() throws Exception {
                try {
    }
            () -> assertInstallPluginFromUrl(icu, icu, url, false, ".sha512", checksumAndFilename(digest, url), verifyingKey, signature)
            );  
        Files.createDirectories(platformBinDir);
         * To setup a situation where signature verification fails, we will mutate the input byte array by modifying a single byte to some  
                null,
            + ".zip";
        final Environment env = TestEnvironment.newEnvironment(Settings.builder().put("path.home", home).build());
    }
                (b, p) -> null  
            Path configDir = env.configDir().resolve(name);
        final Path resources = fake.resolve("resources");  
        String url = "https://repo1.maven.org/maven2/mygroup/myplugin/1.0.0/myplugin-" + Platforms.PLATFORM_NAME + "-1.0.0.zip";
import java.nio.file.attribute.PosixFileAttributes;
            + "-"
                        PosixFileAttributes attributes = Files.readAttributes(file, PosixFileAttributes.class);
            try (Stream<Path> fileStream = Files.list(env.v2().pluginsDir())) {
import java.security.NoSuchAlgorithmException;
            + ".zip";  
    }  
        return writeZip(structure, null);
        /*
        assertTrue(e.getMessage(), e.getMessage().startsWith("Invalid checksum file"));
        String pluginZip = createPlugin("fake", pluginDir, SemverRange.fromString("~" + pluginVersion.toString())).toUri()
        Path pluginDir = createPluginDir(temp);
 */  
import static org.hamcrest.Matchers.hasToString;
                name,
    }
    }  
        assertThat(terminal.getOutput(), containsString("100%"));
        installPlugin(pluginZip, env.v1());  
import java.util.HashSet;  
        assertThat(e.getMessage(), startsWith("Invalid checksum file"));  
        assertThat(e, hasToString(containsString("does-not-exist")));  
import java.util.Date;
        installPlugins(pluginUrl == null ? Collections.emptyList() : Collections.singletonList(pluginUrl), home, command);
        String url = "https://artifacts.opensearch.org/releases/plugins/analysis-icu/"  
import org.opensearch.common.settings.Settings;  
                "myplugin",  
    }
        assertInstallCleaned(env.v2());
        Path pluginDir = createPluginDir(temp);
        MessageDigest digest = MessageDigest.getInstance("SHA-1");  
        assertPlugin("fake", pluginDir, env.v2());  
/*  
        InstallPluginCommand command = new InstallPluginCommand() {  
            + Build.CURRENT.getQualifiedVersion()  
                        if (user != null) {
            @Override  
                        return Files.createTempDirectory(fileSystem.getPath(root), s);  
        assertTrue(permissions.contains(PosixFilePermission.OWNER_WRITE));
        assertInstallPluginFromUrl("analysis-icu", "analysis-icu", url, false);
        String fake2PluginZip = createPluginUrl("fake2", pluginDir);
        Files.createFile(binDir.resolve("somescript"));  
    static Path writeZip(Path structure, String prefix) throws IOException {
        final PGPSecretKey secretKey,  
        assertTrue(e.getMessage(), e.getMessage().contains("not a directory"));
        this.temp = temp;  
        assertPlugin("fake2", pluginDir, env.v2());
                    final ByteArrayOutputStream output = new ByteArrayOutputStream();
        final String url = "https://artifacts.opensearch.org/releases/plugins/analysis-icu/"  
                Path downloadedPath = tmpDir.resolve("downloaded.zip");
    @Override
    }
        String pluginZip = writeZip(pluginDir, null).toUri().toURL().toString();
            for (int j = 0; j < i; ++j) {
        assertInstallCleaned(env.v2());  
import java.io.IOException;
        String url = "https://repo1.maven.org/maven2/mygroup/myplugin/1.0.0/myplugin-1.0.0.zip";
        String pluginZip = createPluginUrl("fake", pluginDir);  
        Files.createDirectories(dirInBinDir);  
            String pluginZip = createPluginUrl("fake", pluginDir);
import java.io.StringReader;  
                    if (isPosix) {
        Path pluginDir = createPluginDir(temp);  
        MessageDigest digest = MessageDigest.getInstance("SHA-512");
                assertTrue(prev + " < " + line, prev.compareTo(line) < 0);
        e = expectThrows(UserException.class, () -> installPlugin("repository", env.v1()));  
            + Build.CURRENT.getQualifiedVersion()
            }
        String pluginZip = zip.toUri().toURL().toString();
        Exception e = expectThrows(
        Files.createFile(dirInBinDir.resolve("somescript"));
        UserException e = expectThrows(UserException.class, () -> installPlugin(pluginZip, env.v1()));
        Tuple<Path, Environment> env = createEnv(fs, temp);  
import org.opensearch.cli.UserException;  
        List<Parameter> parameters = new ArrayList<>();  
        Path pluginDir = createPluginDir(temp);
import java.net.MalformedURLException;
                    }
 * the Apache License, Version 2.0 (the "License"); you may
    }
    static {
        Path pluginDir = createPluginDir(temp);
        Path pluginDir = createPluginDir(temp);
        );
import java.nio.file.attribute.GroupPrincipal;  
import org.junit.After;  
    /** creates a plugin .zip and returns the url for testing */  
                @Override  
                    PosixFilePermission.OWNER_EXECUTE,
    }
            Arrays.stream(additionalProps)  
                }
    // the plugin is installed after this method completes  
    public void testMissingDescriptor() throws Exception {  
        Files.createFile(pluginDir.resolve("shared"));
        assertThat(terminal.getOutput(), not(containsString("100%")));
import java.nio.file.attribute.UserPrincipal;
import com.google.common.jimfs.Configuration;
        assertFalse(e.getMessage(), e.getMessage().contains("maven.org"));
import org.bouncycastle.openpgp.operator.jcajce.JcePBESecretKeyDecryptorBuilder;
import static org.opensearch.test.hamcrest.RegexMatcher.matches;
        kpg.initialize(2048);  
    }
            GroupPrincipal group = null;  
        assertTrue(e.getMessage(), e.getMessage().contains("SHA-512 mismatch, expected foobar"));  
    }
                "analysis-icu",  
import java.io.InputStream;
        writeJar(pluginDir.resolve("dep2.jar"), "Dep2");
        Tuple<Path, Environment> env = createEnv(fs, temp);
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPKeyPair;
        assertTrue(Files.exists(installedConfigDir.resolve("myconfig.yml")));
        String pluginZip = createPluginUrl("fake", pluginDir);
                ".sha512",  
    public void setUp() throws Exception {
        assertPlugin("fake1", pluginDir1, env.v2());  
    }
        String dir = randomAlphaOfLength(10) + ":" + randomAlphaOfLength(5) + "\\" + randomAlphaOfLength(5);
            // now check each line compares greater than the last, until we reach an empty line  
                Path expectedJar = got.resolve(originalPlugin.relativize(file).toString());  
        String pluginZip = createPlugin("fake", pluginDir).toUri().toURL().toString();
        assertInstallPluginFromUrl("analysis-icu", "analysis-icu", url, true);
                } else if ((url + ".sig").equals(urlString)) {  
    }
    public void testBinContainsDir() throws Exception {
                "analysis-icu",  
        new InstallPluginCommand() {
import java.util.Locale;
    }
        if (isPosix) {
    void assertInstallPluginFromUrl(
    public void testOfficialShaMissing() throws Exception {  
        assertInstallCleaned(env.v2());
    public void testLibNotDir() throws Exception {
        assertTrue(permissions.contains(PosixFilePermission.OTHERS_EXECUTE));  
    }  
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(binDir)) {
        assumeTrue("posix filesystem", isPosix);  
        MockTerminal terminal = new MockTerminal();
        assertThat(e.getMessage(), containsString("Unknown plugin unknown_plugin"));
                }  
            }
                    super.verifySignature(zip, urlString);
    void installPlugins(final List<String> pluginUrls, final Path home, final InstallPluginCommand command) throws Exception {
        Tuple<Path, Environment> env = createEnv(fs, temp);
                assertThat(fileStream.collect(Collectors.toList()), empty());
    public void testPolicyConfirmation() throws Exception {  
                "name",
import org.opensearch.plugins.PluginInfo;
        Path configDir = pluginDir.resolve("config");  
    public void testExistingPlugin() throws Exception {
import static org.hamcrest.Matchers.endsWith;
            }  
}
                false,
            private final FileSystem fileSystem;  
        // No progress bar in batch mode
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(env.pluginsDir())) {
            // make sure at least one execute perm is missing, so we know we forced it during installation  
        );
    public void testInvalidShaFileMismatchFilename() throws Exception {
        Path pluginDir = createPluginDir(temp);
                if (InstallPluginCommand.OFFICIAL_PLUGINS.contains(name)) {  
        if (Files.exists(original.resolve("bin"))) {  
            boolean urlExists(Terminal terminal, String urlString) throws IOException {
        Path pluginDir = createPluginDir(temp);
        // allow installation
            }  
        Tuple<Path, Environment> env = createEnv(fs, temp);  
            line = reader.readLine();  
    public void testContainsIntermediateDirectory() throws Exception {
                ".sha512",
        Tuple<Path, Environment> env = createEnv(fs, temp);
    void assertConfigAndBin(String name, Path original, Environment env) throws IOException {
import org.bouncycastle.openpgp.operator.jcajce.JcePBESecretKeyEncryptorBuilder;  
        Path dirInBinDir = pluginDir.resolve("bin").resolve("foo");
                bytes -> "foobar  analysis-icu-" + Build.CURRENT.getQualifiedVersion() + ".zip",  
        assertThat(e, hasToString(containsString(expected)));
        return checksumAndString(digest, "");
            Locale.ROOT,  
            assertThat(terminal.getErrorOutput(), containsString("WARNING: " + warning));
        }
        Tuple<Path, Environment> env = createEnv(fs, temp);  
    public void testBinConflict() throws Exception {
 * Unless required by applicable law or agreed to in writing,
                Version.CURRENT.toString(),  
        UserException e = expectThrows(
    public void testMavenShaMissing() throws Exception {  
        Path pluginDir = createPluginDir(temp);
        }
            writePluginSecurityPolicy(pluginDir, "setFactory");
        assertInstallCleaned(env.v2());  
        Files.createFile(resourcesDir.resolve("resource"));
import java.nio.file.FileVisitResult;
        String[] properties = Stream.concat(  
        assertTrue(e.getMessage(), e.getMessage().contains("SHA-1 mismatch, expected foobar"));
            final byte[] bytes = Arrays.copyOf(b, b.length);
            }
import org.opensearch.common.SuppressForbidden;
        final String url = "https://artifacts.opensearch.org/releases/plugins/analysis-icu/"  
import org.bouncycastle.openpgp.PGPPrivateKey;
        Files.createFile(binDir.resolve("somescript"));
import static org.hamcrest.Matchers.containsString;
    }  
        class Parameter {
import java.nio.file.Files;  
        for (String warning : warnings) {
        }
            new JcePBESecretKeyEncryptorBuilder(PGPEncryptedData.AES_192, sha1Calc).setProvider("BCFIPS").build("passphrase".toCharArray())  
    public void testSha512Mismatch() throws Exception {
        Path pluginDir = createPluginDir(temp);  
        installPlugin(pluginZipWithSpaces.toUri().toURL().toString(), env.v1());  
        installPlugin(pluginZip1, env.v1());
        assertEquals("existing config", configLines.get(0));
    public void testZipRelativeOutsideEntryName() throws Exception {
                false,
        Path zip = createTempDir().resolve(structure.getFileName() + ".zip");  
            )
        );  
            + Build.CURRENT.getQualifiedVersion()
        final String[] segments = URI.create(url).getPath().split("/");  
    private final MockTerminal terminal = new MockTerminal();
    private final String javaIoTmpdir;
        Files.createDirectory(resourcesDir);  
    }
            + "-"
            perms.remove(PosixFilePermission.GROUP_EXECUTE);
            @Override
            @Override
        Files.createDirectory(binDir);  
                    PosixFilePermission.OTHERS_READ,
        // fake should have been removed when the file not found exception occurred
                    Files.write(ascFile, asc.getBytes(StandardCharsets.UTF_8));
                    return new ByteArrayInputStream(output.toByteArray());  
    public void testInstallPluginWithIncompatibleDependencies() throws Exception {
            + Build.CURRENT.getQualifiedVersion()
        assert755(platformName);  
                    byte[] zipbytes = Files.readAllBytes(pluginZip);
            .toString();  
        try (InputStream in = FileSystemUtils.openFileURLStream(URI.create(pluginZip).toURL())) {  
        Tuple<Path, Environment> env = createEnv(fs, temp);
            void verifySignature(Path zip, String urlString) throws IOException, PGPException {
        assertThat(e.getMessage(), containsString("Unknown plugin repository, did you mean any of [repository-s3, repository-gcs]?"));
    public InstallPluginCommandTests(FileSystem fs, Function<String, Path> temp) {
        final String icu = "analysis-icu";
                name,
    }  
            UserException.class,
    public PGPSecretKey newSecretKey() throws NoSuchAlgorithmException, NoSuchProviderException, PGPException {
                    + "if you need to update the plugin, uninstall it first using command 'remove fake'"
        Files.createDirectory(binDir);
            UserException.class,  
    public void testSomethingWorks() throws Exception {
        PluginTestUtil.writePluginProperties(structure, properties);
            binAttrs.setPermissions(perms);
            () -> assertInstallPluginFromUrl(icu, icu, url, false, ".sha512", checksumAndFilename(digest, url), newSecretKey(), signature)
                for (Path file : stream) {
        Path home = temp.apply("install-plugin-command-tests");
        String pluginZip = createPluginUrl("fake", pluginDir);  
            bytes[0] = randomValueOtherThan(b[0], OpenSearchTestCase::randomByte);  
        assertTrue("dir " + name + " exists", Files.exists(got));
                PosixFileAttributes configAttributes = Files.getFileAttributeView(env.configDir(), PosixFileAttributeView.class)  
        );
        final String icu = "analysis-icu";
                }  
        Tuple<Path, Environment> env = createEnv(fs, temp);
        assert644(fake.resolve("fake-" + Version.CURRENT + ".jar"));
        assertInstallPluginFromUrl("mygroup:myplugin:1.0.0", "myplugin", url, false, ".sha512", checksum(digest), null, (b, p) -> null);  
            Parameter(FileSystem fileSystem, Function<String, Path> temp) {
        );  
                    return FileVisitResult.CONTINUE;
            + "/analysis-icu-"
            Arrays.stream(additionalProps)
        String url = "https://artifacts.opensearch.org/releases/plugins/analysis-icu/"
    }  
    }
        return bytes -> MessageDigests.toHexString(digest.digest(bytes)) + s;
        // Core version is behind plugin version by one w.r.t patch, hence incompatible
    static Path createPlugin(String name, Path structure, String... additionalProps) throws IOException {
                    } catch (IOException e) {
            Set<PosixFilePermission> perms = Files.getPosixFilePermissions(got);
    }  
    private Function<byte[], String> checksumAndString(final MessageDigest digest, final String s) {
    }  
    public void testQuietFlagDisabled() throws Exception {  
                return Long.toHexString(secretKey.getKeyID()).toUpperCase(Locale.ROOT);
import org.bouncycastle.bcpg.ArmoredOutputStream;
        Path binDir = pluginDir.resolve("bin");  
            () -> assertInstallPluginFromUrl("mygroup:myplugin:1.0.0", "myplugin", url, false, ".dne", bytes -> null, null, (b, p) -> null)
    private String signature(final byte[] bytes, final PGPSecretKey secretKey) {
            + ".zip";  
    private final boolean isReal;  
            ),
    ) throws Exception {
        skipJarHellCommand.execute(terminal, Collections.singletonList(pluginZip), isBatch, env.v2());
                    if (isPosix) {
            + Build.CURRENT.getQualifiedVersion()
        }.main(new String[] { "--help" }, terminal);  
        String pluginZip = createPluginUrl("fake", pluginDir);
        assertTrue(permissions.contains(PosixFilePermission.OWNER_READ));  
            securityPolicyContent.append("\";");
        final IllegalStateException e = expectThrows(IllegalStateException.class, () -> installPlugin(pluginZip, env.v1()));  
        final Path fakeInstallPath = env.v2().pluginsDir().resolve("fake");
        assertPlugin(name, pluginDir, env.v2());
        assertInstallCleaned(env.v2());
        IllegalArgumentException e = expectThrows(
        IllegalStateException e = expectThrows(
    public void testOfficialPlugin() throws Exception {
        );
    public void testExistingConfig() throws Exception {
        installPlugin(pluginZip, env.v1());
            + ".zip";  
    public void testLibContainsDir() throws Exception {  
        Files.createDirectories(home.resolve("config"));
        Files.createDirectory(removing);  
import java.util.Set;  
                    final byte[] zipBytes = Files.readAllBytes(pluginZip);
        assertTrue(e.getMessage(), e.getMessage().contains("Directories not allowed in bin dir for plugin"));
        Path pluginDir = createPluginDir(temp);  
        Tuple<Path, Environment> env = createEnv(fs, temp);
        installPlugin(pluginZip, env.v1());
        System.setProperty("java.io.tmpdir", temp.apply("tmpdir").toString());
import java.nio.file.FileSystem;
 * ownership. Elasticsearch licenses this file to you under  
        for (String permission : permissions) {
    public void testInstallFailsIfPreviouslyRemovedPluginFailed() throws Exception {
    }
import org.apache.lucene.tests.util.LuceneTestCase;  
import org.opensearch.common.collect.Tuple;
        final KeyPair pair = kpg.generateKeyPair();
        );
    }
        Tuple<Path, Environment> env = createEnv(fs, temp);
    public void testExistingPluginWithCustomFolderName() throws Exception {
            assertTrue("lib dir exists", Files.exists(libDir));
                url,
        installPlugins(pluginUrls, home, skipJarHellCommand);  
        String pluginZip1 = createPluginUrl("fake1", pluginDir1);
    public void testBatchFlag() throws Exception {  
        Path pluginDir = createPluginDir(temp);
            + Build.CURRENT.getQualifiedVersion()
        installPlugin(pluginZip, env.v1());
        String[] properties = Stream.concat(
        );
        try (ZipOutputStream stream = new ZipOutputStream(Files.newOutputStream(jar))) {
            @Override
import org.opensearch.env.Environment;
        assertInstallPluginFromUrl("mygroup:myplugin:1.0.0", "myplugin", url, false);  
            // check that non option agrument list contains correct string
    }
        assertFalse("bin was not copied", Files.exists(got.resolve("bin")));
    }
                if (file.getFileName().toString().startsWith(".installing")) {
        MessageDigest digest = MessageDigest.getInstance("SHA-512");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private void assert644(final Path path) throws IOException {
        Path pluginDir = createPluginDir(temp);
            + "/analysis-icu-"
                        throw new RuntimeException(e);
        return parameters.stream().map(p -> new Object[] { p.fileSystem, p.temp }).collect(Collectors.toList());
        assertThat(e.getMessage(), startsWith("Expected scheme name"));
    }  
    }
                ".sha1",  
        try (PosixPermissionsResetter pluginsAttrs = new PosixPermissionsResetter(env.v2().pluginsDir())) {  
            assertPlugin("fake", pluginDir, env.v2());
        MessageDigest digest = MessageDigest.getInstance("SHA-512");
                    throw new UnsupportedOperationException("verify signature should not be called for unofficial plugins");  
            PosixFileAttributes binAttributes = null;
            try (Stream<Path> fileStream = Files.list(env.v2().pluginsDir())) {
        String pluginZip = createPluginUrl("fake", pluginDir);  
        assertPlugin("fake", pluginDir, env.v2());
        Path installedConfigDir = env.v2().configDir().resolve("fake").resolve("foo");
    public void testSpaceInUrl() throws Exception {
        };
        Path binDir = pluginDir.resolve("bin");  
        writeJar(pluginDir.resolve("dep1.jar"), "Dep1");
 * KIND, either express or implied.  See the License for the
import java.nio.file.attribute.PosixFilePermission;  
        Path binDir = pluginDir.resolve("bin");
@ThreadLeakFilters(filters = BouncyCastleThreadFilter.class)
            Path libDir = env.pluginsDir().resolve("lib").resolve(name);
        MockTerminal terminal = new MockTerminal();  
                } catch (final IOException e) {
        Path pluginDir = createPluginDir(temp);
                "classname",  
    public void testBinPermissions() throws Exception {
                } else {
        assertEquals(ExitCodes.IO_ERROR, e.exitCode);
        }
                return new ByteArrayInputStream(Files.readAllBytes(zip));  
        String url = "https://repo1.maven.org/maven2/mygroup/myplugin/1.0.0/myplugin-1.0.0.zip";  
        final UserException e = expectThrows(
        );
        Tuple<Path, Environment> env = createEnv(fs, temp);
        assert755(platform);
    public void testOfficialChecksumWithoutFilename() throws Exception {  
                "analysis-icu",
 * Licensed to Elasticsearch under one or more contributor  
            }
        Files.createFile(configDir.resolve("custom.yml"));
            new JcaPGPContentSignerBuilder(pkp.getPublicKey().getAlgorithm(), HashAlgorithmTags.SHA256),
                prev = line;
        String pluginZip = createPluginUrl("fake", pluginDir);  
        Files.createFile(platformBinDir.resolve("fake_executable"));
                });
            while (line.contains("Non-option arguments:") == false) {
        try (BufferedReader reader = new BufferedReader(new StringReader(terminal.getOutput()))) {
                terminal.addTextInput("y"); // accept warnings we have already tested
        PluginTestUtil.writePluginProperties(structure, properties);
            final PGPPrivateKey privateKey = secretKey.extractPrivateKey(
                false,
            newSecretKey(),
        final Path bin = platformName.resolve("bin");  
            IllegalStateException.class,
        assertThat(terminal.getOutput(), containsString("100%"));
            name,  
    }
    }
            protected boolean addShutdownHook() {  
    }
        List<String> configLines = Files.readAllLines(envConfigDir.resolve("custom.yml"), StandardCharsets.UTF_8);  
        assertTrue(Files.exists(envConfigDir.resolve("other.yml")));  
    }
        assertPluginInternal(name, env.pluginsDir(), original);
            boolean isSnapshot() {  
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(libDir)) {
        super.tearDown();  
        UserException e = expectThrows(
        Tuple<Path, Environment> env = createEnv(fs, temp);  
                (b, p) -> null  
        terminal.setVerbosity(Terminal.Verbosity.SILENT);  
                "classname",
                return urlString.equals(url);
        assertTrue(permissions.contains(PosixFilePermission.OTHERS_READ));  
                line = reader.readLine();
            while (line != null && line.trim().isEmpty() == false) {  
    }
        assertFalse(permissions.contains(PosixFilePermission.GROUP_WRITE));
        super.setUp();
            .toString();
import java.io.FileNotFoundException;  
            terminal.reset();  
            generator.init(PGPSignature.BINARY_DOCUMENT, privateKey);
        final String pluginZip = createPluginUrl("fake", pluginDir);  
    void installPlugin(String pluginUrl, Path home) throws Exception {
                "fake desc",
        assertInstallCleaned(env.v2());
                BCPGOutputStream pout = new BCPGOutputStream(new ArmoredOutputStream(output));
        UserException e = expectThrows(
    }  
import org.opensearch.Build;
                line = reader.readLine();  
        }
        MockTerminal terminal = new MockTerminal();  
            removing
import org.opensearch.common.hash.MessageDigests;  
            pluginId,
import org.opensearch.plugins.PluginTestUtil;  
        UserException e = expectThrows(UserException.class, () -> installPlugin(pluginZip, env.v1()));
        Path pluginDir = createPluginDir(temp);
                "opensearch.version",
        Version pluginVersion = VersionUtils.getVersion(coreVersion.major, coreVersion.minor, (byte) (coreVersion.revision + 1));
            + ".zip";  
        this.isReal = fs == PathUtils.getDefaultFileSystem();
                containsInAnyOrder(
        Files.write(configDir.resolve("custom.yml"), "new config".getBytes(StandardCharsets.UTF_8));
            () -> installPlugin("file:" + dir, env.v1())
                    armored.close();
            IllegalStateException.class,
    public void testOfficialPlatformPlugin() throws Exception {
    }  
        return zip;  
        }  
    public void testConfig() throws Exception {  
    @SuppressForbidden(reason = "resets java.io.tmpdir")  
        writePluginSecurityPolicy(pluginDir, "setAccessible", "setFactory");  
 * this work for additional information regarding copyright
            assertThat(line, containsString("<name|Zip File|URL>"));
    void installPlugin(String pluginUrl, Path home, InstallPluginCommand command) throws Exception {  
    public void testPluginAlreadyInstalled() throws Exception {
                "{opensearch:\"" + opensearchVersionRange + "\"}",
        }
        skipJarHellCommand.close();  
            files.forEach(file -> {
        final Path platformDir = pluginDir.resolve("platform");
        installPlugin(pluginZip2, env.v1());
import java.security.KeyPairGenerator;  
                    }  
                    return ascFile.toUri().toURL();
            + "/analysis-icu-"
    static void writeJar(Path jar, String... classes) throws IOException {  
            }
            null,
    }
        Tuple<Path, Environment> env = createEnv(fs, temp);
            installPlugin(pluginZip, env.v1());  
            UserException e = expectThrows(UserException.class, () -> installPlugin(pluginZip, env.v1()));  
    }  
                "FakePlugin"
            () -> installPlugins(Arrays.asList(pluginZip, pluginZip + "does-not-exist"), env.v1())
            @Override
        Tuple<Path, Environment> env = createEnv(fs, temp);
            String line = reader.readLine();
                        assertEquals(InstallPluginCommand.BIN_FILES_PERMS, attributes.permissions());
    public void testInstallPluginWithCompatibleDependencies() throws Exception {
        writeJar(sharedDir.resolve("dep.jar"), "DepClass");
        terminal.reset();
        Path pluginDir = createPluginDir(temp);
    private final Function<String, Path> temp;
import java.io.ByteArrayOutputStream;
import org.opensearch.common.io.PathUtils;
        installPlugin(pluginZip, env.v1());
            + Build.CURRENT.getQualifiedVersion()
        Tuple<Path, Environment> environment = createEnv(fs, temp);  
        assertThat(e, hasToString(containsString("plugins can not have native controllers")));
        UserException e = expectThrows(UserException.class, () -> installPlugin("foo", env.v1()));
    private final boolean isPosix;
                    if (isPosix) {  
/*  
    }
    public void testBinNotDir() throws Exception {  
import java.util.zip.ZipOutputStream;  
                    assertFalse("lib entry is not a dir", Files.isDirectory(file));  
        );  
import com.google.common.jimfs.Jimfs;
                // qa is not really a plugin and it shouldn't sneak in
        assert755(bin.resolve("fake_executable"));
            stream.putNextEntry(new ZipEntry("../blah"));  
    private Function<byte[], String> checksumAndFilename(final MessageDigest digest, final String url) throws MalformedURLException {
    }
        // shared dir must NOT remain inside the plugin dir
            + "/"
import java.nio.file.attribute.BasicFileAttributes;
import org.opensearch.core.util.FileSystemUtils;
        Files.createDirectory(configDir);  
            e = expectThrows(UserException.class, () -> installPlugin(pluginZip, env.v1()));
    }
            String getPublicKeyId() {
    private final FileSystem fs;
            + ".zip";  
            assertTrue("lib is a dir", Files.isDirectory(libDir));  
        ).toArray(String[]::new);
        return writeZip(structure, null);  
        installPlugin(terminal, false);  
        );  
        writeJar(structure.resolve("plugin.jar"), className);
                assertThat(fileStream.collect(Collectors.toList()), empty());  
            Files.walkFileTree(structure, new SimpleFileVisitor<Path>() {
            Set<PosixFilePermission> perms = binAttrs.getCopyPermissions();
