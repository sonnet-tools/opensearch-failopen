import org.apache.lucene.store.IndexOutput;
     *
        ) {
import javax.crypto.SecretKeyFactory;
            }
    public synchronized void close() {
    private static final String CIPHER_ALGO = "AES";
    /** The decrypted secret data. See {@link #decrypt(char[])}. */
                        output.writeUTF(entry.getKey());
import java.nio.file.attribute.PosixFileAttributeView;
        }
            output.writeBytes(salt, salt.length);
                    if (fileKeyAlgo.equals("PBE") == false) {
import org.opensearch.common.Randomness;
            );
import org.opensearch.cli.ExitCodes;
        }
     * Note: The Oracle JDK 8 ships with a limited JCE policy that restricts key length for AES to 128 bits.
        ) {
                // For v2 we had a map of strings containing the types for each setting. In v3 this map is now
    public synchronized void save(Path configDir, char[] password) throws Exception {
    private KeyStoreWrapper(int formatVersion, boolean hasPassword, byte[] dataBytes) {
            random.nextBytes(salt);
                bytes = Base64.getDecoder().decode(tmpBytes);
    }
        return configDir.resolve(keystoreFileName);
                // store it back using java's builtin DataOutput in a byte array, along with the actual keystore bytes
        }
            ByteArrayInputStream bytesStream = new ByteArrayInputStream(dataBytes);
            CodecUtil.writeHeader(output, KEYSTORE_FILENAME, FORMAT_VERSION);
            entries.set(new HashMap<>());
                input.readBytes(dataBytes, 0, dataBytesLen);
    @Override
 */
import org.apache.lucene.store.IOContext;
    /** Constructs a new keystore with the given password. */
            return null;
import java.util.Set;
    }
     * This allows {@link SecureSetting} to correctly determine that a entry exists even though it cannot be read. Thus attempting to
    @Override
     * Ensure the given setting name is allowed.
import java.nio.file.AccessDeniedException;
    public synchronized void setString(String setting, char[] value) {
import java.util.HashSet;
        NIOFSDirectory directory = new NIOFSDirectory(configDir);
            Arrays.fill(oldEntry.bytes, (byte) 0);
        Entry oldEntry = entries.get().remove(setting);
    public boolean hasPassword() {
import javax.crypto.AEADBadTagException;
 * Licensed to Elasticsearch under one or more contributor
    /** Upgrades the format of the keystore, if necessary. */
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBE", "SunJCE");
                throw new SecurityException("Keystore has been corrupted or tampered with");
                configDir.resolve(tmpFile),
 * @opensearch.internal
        ByteBuffer byteBuffer = ByteBuffer.wrap(entry.bytes);
                byte[] entryBytes = new byte[entrySize];
            boolean hasPassword = hasPasswordByte == 1;
public class KeyStoreWrapper implements SecureSettings {
                }
                    e
        Enumeration<String> aliases = keystore.aliases();
                }
        int passwordLength = 20; // Generate 20 character passwords
 * {@link #hasPassword()} is {@code false}.  Loading and decrypting should happen
        KeyStore.PasswordProtection password = new KeyStore.PasswordProtection("".toCharArray());
        this.hasPassword = hasPassword;
        Cipher cipher = createCipher(Cipher.ENCRYPT_MODE, password, salt, iv);
                output.write(entryBytes);
    public static KeyStoreWrapper create() {
                        throw new IllegalStateException("Corrupted legacy keystore file encryption algorithm");
                // we cannot just read the map and find out how long it is. So instead we read the map and
        if (wrapper.getFormatVersion() == FORMAT_VERSION && wrapper.getSettingNames().contains(SEED_SETTING.getKey())) {
 * license agreements. See the NOTICE file distributed with
            DataOutputStream output = new DataOutputStream(cipherStream)
        if (null != entries.get() && entries.get().isEmpty() == false) {
        ) {
            // Equivalent to: boolean approvedOnly = CryptoServicesRegistrar.isInApprovedOnlyMode()
    /** Return true iff calling {@link #decrypt(char[])} requires a non-empty password. */
        }
        final byte[] salt;
            final int formatVersion;
        ensureOpen();
            // then read the actual keystore
     */
            for (Entry entry : entries.get().values()) {
        Entry entry = entries.get().get(setting);
                throw new IllegalStateException(
            }
            if (input.read() != -1) {
                if (formatVersion == 2) {
    public boolean isLoaded() {
     * {@link #decrypt(char[])} must be called before reading or writing any entries.
     */
            int encryptedLen = input.readInt();
        ensureOpen();
            // use 96 bits (12 bytes) for IV as recommended by NIST
                throw new IllegalStateException(
        Entry entry = entries.get().get(setting);
        return entry.sha256Digest;
                dataBytes = bytes.toByteArray();
     * Remove the given setting from the keystore.
        ensureOpen();
                );
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KDF_ALGO);
    /**
                    final String fileKeyAlgo = input.readString();
    private final SetOnce<Map<String, Entry>> entries = new SetOnce<>();
    /** Characters that may be used in the bootstrap seed setting added to all keystores. */
            throw new SecurityException("Keystore has been corrupted or tampered with", e);
        char[] characters = new char[passwordLength];
        SecretKeySpec secret = new SecretKeySpec(secretKey.getEncoded(), CIPHER_ALGO);
            if (e.getCause() instanceof AEADBadTagException) {
 * specific language governing permissions and limitations
                        + "Are you trying to downgrade? You should delete and recreate it in order to downgrade.",
            int ivLen = input.readInt();
        NIOFSDirectory directory = new NIOFSDirectory(configDir);
                if (type.equals("PKCS12") == false) {
    }
            char[] chars = keySpec.getPassword();
            // first read the setting types map
        }
    /** The cipher used to encrypt the keystore data. */
 * {@link #decrypt(char[])} with the keystore password, or an empty char array if
        return hasPassword;
     * The number of bits for the cipher key.
        if (formatVersion <= 2) {
     * This can be increased to 256 bits once minimum java 9 is the minimum java version.
import java.nio.file.StandardCopyOption;
        } else {
import javax.crypto.CipherInputStream;
    }
            return (Boolean) isApprovedOnlyMethod.invoke(null);
    }
            byte[] salt = new byte[64];
        if (formatVersion == 1) {
                    output.write(keystoreBytes);
        KeyStore keystore = KeyStore.getInstance("PKCS12", "SUN");
                    for (Map.Entry<String, String> entry : settingTypes.entrySet()) {
        // v1 and v2 keystores never had passwords actually used, so we always use an empty password
        Files.move(configDir.resolve(tmpFile), keystoreFile, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
        assert isLoaded() : "Keystore is not loaded";
            attrs.setPermissions(PosixFilePermissions.fromString("rw-rw----"));
        try (
        }
            random.nextBytes(iv);
            if (password.length != 0) {
                Arrays.fill(tmpBytes, (byte) 0);
    // format version changelog:
    private void ensureOpen() {
        addBootstrapSeed(wrapper);
        if (wrapper.getSettingNames().contains(SEED_SETTING.getKey()) == false) {
        KeyStoreWrapper wrapper = new KeyStoreWrapper(FORMAT_VERSION, false, null);
     */
        ByteArrayInputStream inputBytes = new ByteArrayInputStream(dataBytes);
    public static KeyStoreWrapper load(Path configDir) throws IOException {
                try (DataOutputStream output = new DataOutputStream(bytes)) {
    private static final String CIPHER_PADDING = "NoPadding";
        wrapper.save(configDir, password);
                settingTypes.put(aliases.nextElement(), EntryType.STRING);
import java.nio.file.Files;
    // 3: FIPS compliant algos, ES 6.3
    /** The raw bytes of the encrypted keystore. */
    private final boolean hasPassword;
            while (aliases.hasMoreElements()) {
    /**
                output.writeUTF(mapEntry.getKey());
    /** The name of the keystore file to read and write. */
        Arrays.fill(characters, (char) 0);
        ByteBuffer byteBuffer = StandardCharsets.UTF_8.encode(CharBuffer.wrap(value));
        // write to tmp file first, then overwrite
    /** An identifier for the type of data that may be stored in a keystore entry. */
    }
/**
    }
            output.writeInt(entries.get().size());
    private static final int MIN_FORMAT_VERSION = 1;
        return load(configDir, KEYSTORE_FILENAME);
        cipher.init(opmode, secret, spec);
        }
            byte[] iv = new byte[12];
            final String message = String.format(
 * Loading a keystore has 2 phases. First, call {@link #load(Path)}. Then call
    /** The oldest metadata format version that can be read. */
import java.security.GeneralSecurityException;
    /** The version of the metadata written before the keystore data. */
            characters[i] = SEED_CHARS[random.nextInt(SEED_CHARS.length)];
     */
            CodecUtil.checkFooter(input);
                Map<String, String> settingTypes = input.readMapOfStrings();
            for (Map.Entry<String, Entry> mapEntry : entries.get().entrySet()) {
        SecretKey secretKey = keyFactory.generateSecret(keySpec);
        } catch (EOFException e) {
                bytes = Arrays.copyOfRange(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit());
                );
                    input.readUTF();
    /**
        .toCharArray();
    }
        assert entries.get() != null : "Keystore is not loaded";
                    }
                String type = input.readString();
    /** The number of iterations to derive the cipher key. */
 * You may obtain a copy of the License at
 * SPDX-License-Identifier: Apache-2.0
        ensureOpen();
            entries.get().put(setting, new Entry(bytes));
    /**
     *
            throw new IllegalStateException("Keystore has already been decrypted");
        Entry oldEntry = entries.get().put(setting, new Entry(Arrays.copyOf(bytes, bytes.length)));
    private static final char[] SEED_CHARS = ("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789" + "~!@#$%^&*-_=+?")
        wrapper.entries.set(new HashMap<>());
        try (ChecksumIndexInput input = EndiannessReverserUtil.openChecksumInput(directory, keystoreFileName, IOContext.READONCE)) {
 * Modifications Copyright OpenSearch Contributors. See
                        + "] format is too new. "
        }
import java.io.IOException;
    /** The metadata format version used to read the current keystore wrapper. */
                String settingName = aliases.nextElement();
                    input.readBytes(keystoreBytes, 0, keystoreLen);
                    tmpBytes[i] = (byte) chars[i]; // PBE only stores the lower 8 bits, so this narrowing is ok
            if (hasPassword == false && hasPasswordByte != 0) {
    private static class Entry {
            decryptLegacyEntries();
            }
        } catch (ReflectiveOperationException e) {
            addBootstrapSeed(wrapper);
                }
import java.nio.CharBuffer;
import java.io.DataInputStream;
                throw new SecurityException("Keystore has been corrupted or tampered with");
    /**
    public static final int FORMAT_VERSION = 4;
    private static Path keystorePath(Path configDir, String keystoreFileName) {
import org.apache.lucene.index.IndexFormatTooOldException;
        this.dataBytes = dataBytes;
 *
            Arrays.fill(oldEntry.bytes, (byte) 0);
                    output.writeInt(settingTypes.size());
                configDir
                }
    public int getFormatVersion() {
    /** Add the bootstrap seed setting, which may be used as a unique, secure, random value by the node */
    private Cipher createCipher(int opmode, char[] password, byte[] salt, byte[] iv) throws GeneralSecurityException {
                }
    }
            while (numEntries-- > 0) {
    public void decrypt(char[] password) throws GeneralSecurityException, IOException {
import java.util.Enumeration;
            );
     * */
            }
    private volatile boolean closed;
 * in a single thread. Once decrypted, settings may be read in multiple threads.
            input.readFully(salt);
            throw new IllegalStateException("Keystore is closed");
 *
        STRING,
 * under the License.
    private static final int KDF_ITERS = 10000;
    /**
     * @throws IllegalArgumentException if the setting name is not valid
                throw new IllegalArgumentException("Keystore format does not accept non-empty passwords");
 * this file be licensed under the Apache-2.0 license or a
        Entry oldEntry = entries.get().put(setting, new Entry(bytes));
    private static final int CIPHER_KEY_BITS = 128;
                    int keystoreLen = input.readInt();
    @Override
     */
    /**
        assert isLoaded();
 * software distributed under the License is distributed on an
        }
    }
    private static final Pattern ALLOWED_SETTING_NAME = Pattern.compile("[A-Za-z0-9_\\-.]+");
                if (stringKeyAlgo.equals("PBE") == false) {
                // The PBE keyspec gives us chars, we convert to bytes
            }
                }
        }
     */
import org.apache.lucene.store.NIOFSDirectory;
    /**
        PBEKeySpec keySpec = new PBEKeySpec(password, salt, KDF_ITERS, CIPHER_KEY_BITS);
        return bytes.toByteArray();
    /**
import javax.crypto.spec.GCMParameterSpec;
     * <p>
     * <p>
        }
        if (oldEntry != null) {
    }
    /**
            CipherInputStream cipherStream = new CipherInputStream(bytesStream, cipher);
            throw new IllegalArgumentException(
                int entrySize = input.readInt();
import java.util.Arrays;
        }
            byte hasPasswordByte = input.readByte();
        Entry entry = entries.get().get(setting);
    /** Encrypt the keystore entries and return the encrypted data. */
 * ownership. Elasticsearch licenses this file to you under
            keystore.load(input, "".toCharArray());
import java.nio.file.attribute.PosixFilePermissions;
    // TODO: make settings accessible only to code that registered the setting
            Set<String> expectedSettings = new HashSet<>(settingTypes.keySet());
                byte[] tmpBytes = new byte[chars.length];
                Arrays.fill(entry.bytes, (byte) 0);
                    throw new IllegalStateException("Corrupted legacy keystore string encryption algorithm");
            if (formatVersion == 2) {
/*
     * used to check for value changes without actually storing the value.
 *
            this.sha256Digest = MessageDigests.sha256().digest(bytes);
 *
        return cipher;
        return wrapper;
    public synchronized InputStream getFile(String setting) {
            this.bytes = bytes;
                if (expectedSettings.remove(settingName) == false) {
            }
    public static void validateSettingName(String setting) {
            }
            output.writeInt(4 + salt.length + 4 + iv.length + 4 + encryptedBytes.length);
 */
        }
    }
        if (Files.exists(keystoreFile) == false) {
    /**
        Cipher cipher = Cipher.getInstance(CIPHER_ALGO + "/" + CIPHER_MODE + "/" + CIPHER_PADDING);
     */
                int dataBytesLen = input.readInt();
        validateSettingName(setting);
import java.nio.file.Path;
            }
            Arrays.fill(chars, '\0');
    public static KeyStoreWrapper load(Path configDir, String keystoreFileName) throws IOException {
        // add keystore.seed if necessary
        try (DataInputStream input = new DataInputStream(inputBytes)) {
        if (ALLOWED_SETTING_NAME.matcher(setting).matches() == false) {
    }
    public static void upgrade(KeyStoreWrapper wrapper, Path configDir, char[] password) throws Exception {
            // don't rely on umask: ensure the keystore has minimal permissions
            int saltLen = input.readInt();
        try (
            // new cipher params
    }
            int numEntries = input.readInt();
    }
        }
import org.apache.lucene.backward_codecs.store.EndiannessReverserUtil;
    @Override
            }
                throw new IllegalStateException("hasPassword boolean is corrupt: " + String.format(Locale.ROOT, "%02x", hasPasswordByte));
    }
        }
import javax.crypto.spec.PBEKeySpec;
                throw new SecurityException("Keystore has been corrupted or tampered with");
     * Set a string setting.
            output.writeInt(encryptedBytes.length);
    /** The algorithm used to derive the cipher key from a password. */
        final byte[] sha256Digest;
import org.opensearch.common.SetOnce;
            return false;
    /**
        this.closed = true;
                "unable to create temporary keystore at [%s], write permissions required for [%s] or run [opensearch-keystore upgrade]",
        }
            } catch (IndexFormatTooOldException e) {
        if (entries.get() != null) {
                    "The OpenSearch keystore ["
 * compatible open source license.
            // verify integrity: keys in keystore match what the metadata thinks exist
                input.readFully(entryBytes);
            if (formatVersion == 2) {
    /** Write the keystore to the given config directory. */
     * An entry in the keystore. The bytes are opaque and interpreted based on the entry type.
        validateSettingName(setting);
    /** The padding used with the cipher algorithm. */
            ByteArrayInputStream bytesStream = new ByteArrayInputStream(encryptedBytes);
 * The OpenSearch Contributors require contributions made to
                throw new SecurityException("Provided keystore password was incorrect", e);
            encryptedBytes = new byte[encryptedLen];
    }
            // encrypted data
                final String stringKeyAlgo = input.readString();
                Locale.ROOT,
                    throw new SecurityException("Keystore has been corrupted or tampered with");
import org.opensearch.common.hash.MessageDigests;
    }
     * A regex for the valid characters that a setting name in the keystore may use.
            salt = new byte[saltLen];
            // see https://www.owasp.org/index.php/Password_Storage_Cheat_Sheet
    };
 * <p>
        assert wrapper.getSettingNames().contains(SEED_SETTING.getKey()) == false;
 * Unless required by applicable law or agreed to in writing,
            byte[] encryptedBytes = encrypt(password, salt, iv);
                ByteBuffer byteBuffer = StandardCharsets.UTF_8.encode(CharBuffer.wrap(chars));
            }
                        + keystoreFile
import java.util.regex.Pattern;
        try {
import java.io.ByteArrayOutputStream;
    }
            input.readFully(encryptedBytes);
import org.apache.lucene.index.IndexFormatTooNewException;
                    byte[] keystoreBytes = new byte[keystoreLen];
        // verify the settings metadata matches the keystore entries
    }
import java.io.InputStream;
            output.writeBytes(encryptedBytes, encryptedBytes.length);
     * It is possible to retrieve the setting names even if the keystore is closed.
        final byte[] iv;
     */
import java.util.function.Supplier;
        if (attrs != null) {
        SecureRandom random = Randomness.createSecure();
 * A disk based container for sensitive settings in OpenSearch.
    public void remove(String setting) {
                    String value = input.readUTF();
        String tmpFile = KEYSTORE_FILENAME + ".tmp";
            // use 64 bytes salt, which surpasses that recommended by OWASP
            KeyStore.SecretKeyEntry keystoreEntry = (KeyStore.SecretKeyEntry) keystore.getEntry(setting, password);
    }
        // fill in the entries now that we know all the types to expect
        for (Map.Entry<String, EntryType> settingEntry : settingTypes.entrySet()) {
            String setting = settingEntry.getKey();
        for (int i = 0; i < passwordLength; ++i) {
            try {
                    "The OpenSearch keystore ["
                if (formatVersion == 3) {
            SecureRandom random = Randomness.createSecure();
        }
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        Entry(byte[] bytes) {
            Arrays.fill(oldEntry.bytes, (byte) 0);
        GCMParameterSpec spec = new GCMParameterSpec(GCM_TAG_BITS, iv);
    public static final Setting<SecureString> SEED_SETTING = SecureSetting.secureString("keystore.seed", null);
        return entries.get() != null;
        }
            input.readFully(iv);
    public synchronized void setFile(String setting, byte[] bytes) {
     * Returns {@code null} if no keystore exists.
        if (oldEntry != null) {
        wrapper.setString(SEED_SETTING.getKey(), characters);
import java.util.Map;
                assert settingType == EntryType.FILE;
     **/
import javax.crypto.Cipher;
    private byte[] encrypt(char[] password, byte[] salt, byte[] iv) throws GeneralSecurityException, IOException {
    private static final String KEYSTORE_FILENAME = "opensearch.keystore";
 * the Apache License, Version 2.0 (the "License"); you may
            CodecUtil.writeFooter(output);
    /** Returns a path representing the ES keystore in the given config dir. */
    }
            if (expectedSettings.isEmpty() == false) {
     * Decrypts the underlying keystore data.
            final byte[] bytes;
     */
            return new KeyStoreWrapper(formatVersion, hasPassword, dataBytes);
            return;
            }
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
                        + "You should delete and recreate it in order to upgrade.",
                }
        }
     * Returns the SHA256 digest for the setting's value, even after {@code #close()} has been called. The setting must exist. The digest is
                        output.writeUTF(entry.getValue());
import java.security.SecureRandom;
     * read a secure setting after the keystore is closed will generate a "keystore is closed" exception rather than using the fallback
            PBEKeySpec keySpec = (PBEKeySpec) keyFactory.getKeySpec(keystoreEntry.getSecretKey(), PBEKeySpec.class);
                    // legacy, the keystore format would previously store the entry type
                    String key = input.readUTF();
            }
        assert entries.get() != null : "Keystore is not loaded";
                        + "] format is too old. "
import java.util.Locale;
    @Override
        return entries.get().keySet();
            var isApprovedOnlyMethod = registrarClass.getMethod("isInApprovedOnlyMode");
        FILE
    }
            iv = new byte[ivLen];
                byte[] entryBytes = mapEntry.getValue().bytes;
        }
                for (int i = 0; i < tmpBytes.length; ++i) {
import java.nio.charset.StandardCharsets;
    private final byte[] dataBytes;
/*
    public static Path keystorePath(Path configDir) {
    /** The number of bits for the GCM tag. */
        this.entries.set(new HashMap<>());
     * setting.
     * This may only be called once.
            DataInputStream input = new DataInputStream(bytesStream)
            output.writeBytes(iv, iv.length);
                    e
    }
                }
                    throw new IllegalStateException("Corrupted legacy keystore string encryption algorithm");
            CipherOutputStream cipherStream = new CipherOutputStream(bytes, cipher);
import javax.crypto.SecretKey;
     * Get the metadata format version for the keystore
    public synchronized SecureString getString(String setting) {
        }
    /** True iff the keystore has a password needed to read. */
        try (IndexOutput output = EndiannessReverserUtil.createOutput(directory, tmpFile, IOContext.READONCE)) {
    private enum EntryType {
            keySpec.clearPassword();
        } catch (final AccessDeniedException e) {
     * @opensearch.internal
     */
            } else {
            output.writeInt(salt.length);
    public Set<String> getSettingNames() {
 * not use this file except in compliance with the License.
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    private static final String CIPHER_MODE = "GCM";
import java.io.ByteArrayInputStream;
        ensureOpen();
    }
                    settingTypes.put(key, EntryType.valueOf(value));
import java.util.HashMap;
            final byte[] dataBytes;
        ensureOpen();
 */
        Cipher cipher = createCipher(Cipher.DECRYPT_MODE, password, salt, iv);
                for (int i = 0; i < numSettings; ++i) {
            if (input.read() != -1) {
     * Loads information about the OpenSearch keystore from the provided config directory.
import javax.crypto.CipherOutputStream;
import java.io.EOFException;
    public byte[] getSHA256Digest(String setting) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
        return new ByteArrayInputStream(entry.bytes);
    public static void addBootstrapSeed(KeyStoreWrapper wrapper) {
            throw new SecurityException("Legacy KeyStore formats v1 & v2 are not supported in FIPS JVM");
            }
            while (aliases.hasMoreElements()) {
package org.opensearch.common.settings;
    }
 * GitHub history for details.
        return keystorePath(configDir, KEYSTORE_FILENAME);
                int numSettings = input.readInt();
            if (formatVersion <= 2) {
import org.apache.lucene.store.ChecksumIndexInput;
            }
            output.writeInt(iv.length);
}
                "Setting name [" + setting + "] does not match the allowed setting name pattern [" + ALLOWED_SETTING_NAME.pattern() + "]"
import java.util.Base64;
        if (inFipsMode.get()) {
        Path keystoreFile = keystorePath(configDir, keystoreFileName);
            throw new UserException(ExitCodes.CONFIG, message, e);
                Arrays.fill(byteBuffer.array(), (byte) 0);
    /** The mode used with the cipher algorithm. */
            }
    // 4: remove distinction between string/files, ES 6.8/7.1
            DataInputStream input = new DataInputStream(cipherStream)
     * <p>
    private static final Supplier<Boolean> inFipsMode = () -> {
import javax.crypto.spec.SecretKeySpec;
            } else {
import java.nio.ByteBuffer;
            return;
import org.opensearch.cli.UserException;
        } catch (IOException e) {
        cipher.updateAAD(salt);
        try (
import java.security.KeyStore;
    private static final String KDF_ALGO = "PBKDF2WithHmacSHA512";
    // 1: initial version, ES 5.3
    // 2: file setting, ES 5.4
    }
            var registrarClass = Class.forName("org.bouncycastle.crypto.CryptoServicesRegistrar");
     * Set a file setting.
     * See http://www.oracle.com/technetwork/java/javase/terms/readme/jdk9-readme-3852447.html#jce
        return new SecureString(Arrays.copyOfRange(charBuffer.array(), charBuffer.position(), charBuffer.limit()));
    private static final int GCM_TAG_BITS = 128;
            if (settingType == EntryType.STRING) {
        this.formatVersion = formatVersion;
        if (oldEntry != null) {
        return formatVersion;
        CharBuffer charBuffer = StandardCharsets.UTF_8.decode(byteBuffer);
import org.opensearch.core.common.settings.SecureString;
            EntryType settingType = settingEntry.getValue();
    private void decryptLegacyEntries() throws GeneralSecurityException, IOException {
                dataBytes = new byte[dataBytesLen];
/*
 * this work for additional information regarding copyright
import org.apache.lucene.codecs.CodecUtil;
        PosixFileAttributeView attrs = Files.getFileAttributeView(keystoreFile, PosixFileAttributeView.class);
            } catch (IndexFormatTooNewException e) {
        final byte[] encryptedBytes;
    @Override
        Path keystoreFile = keystorePath(configDir);
        }
                entries.get().put(setting, new Entry(entryBytes));
            output.writeByte(password.length == 0 ? (byte) 0 : (byte) 1);
            // see http://nvlpubs.nist.gov/nistpubs/Legacy/SP/nistspecialpublication800-38d.pdf section 5.2.1.1
 */
        }
 * KIND, either express or implied.  See the License for the
                // part of the encrypted bytes. Unfortunately we cannot seek backwards with checksum input, so
                    }
            // size of data block
            }
        Map<String, EntryType> settingTypes = new HashMap<>();
                output.writeInt(entryBytes.length);
import java.io.DataOutputStream;
        if (closed) {
            throw new SecurityException("Keystore has been corrupted or tampered with", e);
                        + keystoreFile
        final byte[] bytes;
                String setting = input.readUTF();
    private final int formatVersion;
        byte[] bytes = Arrays.copyOfRange(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit());
                formatVersion = CodecUtil.checkHeader(input, keystoreFileName, MIN_FORMAT_VERSION, FORMAT_VERSION);
