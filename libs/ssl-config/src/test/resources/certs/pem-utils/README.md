             -config <(cat /etc/ssl/openssl.cnf <(printf "[SAN]\nsubjectAltName=otherName.1:2.5.4.3;UTF8:node2.cluster2"))\
    openssl pkcs12 -in ec.p12 -nodes -nocerts | openssl ec -des3 -out ec_key_openssl_encrypted.pem
```
We need to create a keystore from the created PKCS12 certificate.
```
# Create SSH key
```bash
    keytool -importkeystore -srckeystore testnode.jks -destkeystore dsa.p12 -deststoretype PKCS12 \
        -srcstoretype PKCS12 \
```bash
```
    openssl pkcs12 -in ec.p12 -nodes -nocerts | openssl pkcs8 -topk8 -nocrypt -outform pem \
    openssl rsa -aes192 -in testnode-unprotected.pem -out testnode-aes192.pem
```bash
```
    if [ $? -ne 0 ]; then
        -srckeystore testnode.p12 \
## EC
    # generate self-signed certificate
and the respective certificates
    keytool -genkeypair -keyalg EC -alias testnode_ec -keystore testnode.jks -storepass testnode \
    openssl genpkey -paramfile param_temp.pem -out key_DSA_enc_pbkdf2.pem -aes256 -pass stdin
    fi
        echo "Expected pattern: key_<algorithm>_enc_pbkdf2.pem (e.g., key_rsa_enc_pbkdf2.pem)" >&2
    openssl req -newkey rsa:2048 -nodes -keyout ca.key -x509 -subj "/CN=certAuth" -days 10000 -out ca.crt
encrypted with `AES-128`, `AES-192` and `AES-256` respectively, encoded
```bash
## DSA
        -out ca_temp.pem
When prompted the password is always set to the value of &lt;NAME&gt;.
The `alt_names` section provides the Subject Alternative Names for each
```bash
```bash
# Instructions on generating self-signed certificates
The certificates in this directory have been generated using the
            -out dsa_key_pkcs8_plain.pem
        exit 1
```bash
```
    openssl pkcs12 -in ec.p12 -nodes -nocerts | openssl ec -out ec_key_openssl_plain.pem
    openssl pkcs8 -in key-temp.pem -topk8 -v2 aes-256-cbc -v2prf hmacWithSHA512 -out key_PKCS8_enc_pbkdf2.pem
    fi
            -out dsa_key_pkcs8_encrypted.pem
            -keypass testnode -validity 10000 -groupname secp256r1 -dname "CN=OpenSearch Test Node" \
`testnode-aes{128,192,256}.pem` is the testnode.pem private key,
```bash
    openssl req -x509 -extensions v3_req -key private_secp256r1.pem -out certificate_secp256r1.pem -days 1460 -config openssl_config.cnf
    # import from P12 to JKS keystore (keytool 21.0.2)
export LIB_PATH="/path/to/lib/folder"
        -addext "subjectAltName=DNS:localhost,DNS:localhost.localdomain,DNS:localhost4,DNS:localhost4.localdomain4,DNS:localhost6,DNS:localhost6.localdomain6,IP:127.0.0.1,IP:0:0:0:0:0:0:0:1" \
    openssl ecparam -name secp256r1 -genkey -out private_secp256r1.pem
    if [ -z "$algo" ]; then
```
        echo "An error occurred while migrating to BCFKS for $key_file"
will list all the available curves in a given system. For the purposes
        -destkeystore testnode.bcfks \
            -srcalias testnode_ec -deststorepass testnode -destkeypass testnode
    openssl ecparam -list_curves
    keytool -importkeystore -destkeystore <NAME>.jks -srckeystore <NAME>.p12 -srcstoretype pkcs12 -alias <NAME>
            -extensions SAN -config <(cat /etc/ssl/openssl.cnf \
        -srcstorepass "$STORE_PW" \
# Export the `DSA` and `EC` private keys from `PKCS#12` keystore into `PKCS#8` format
        exit 1
            <(printf "[SAN]\nsubjectAltName=otherName.1:2.5.4.3;UTF8:node1.cluster1")) -out n1.c1.crt
```bash
    openssl genpkey -genparam -algorithm DSA -out param_temp.pem -pkeyopt pbits:2048 -pkeyopt qbits:224 -pkeyopt digest:SHA256 -pkeyopt gindex:1 -text
    openssl pkcs12 -in dsa.p12 -nodes -nocerts | openssl pkcs8 -topk8 -outform pem \
rm ca_temp.pem testnode.p12
    if [ $? -ne 0 ]; then
    keytool -importkeystore -noprompt \
```
    # migrate from P12 to BCFKS keystore (keytool 21.0.2)
```
        echo "An error occurred while adding key + cert to P12 keystore for $key_file"
    openssl genpkey -algorithm EC -out key_EC_enc_pbkdf2.pem -pkeyopt ec_paramgen_curve:secp384r1 -pkeyopt ec_param_enc:named_curve -pass stdin
# Adding `DSA` and `EC` Keys to the Keystore
        exit 1
    if [ $? -ne 0 ]; then
```bash
        -srckeystore testnode.p12 \
        -passout pass:"$STORE_PW"
```
            -out ec_key_pkcs8_plain.pem
```
enabled.
```
# Export the `DSA` and `EC` private keys from `PKCS#12` keystore into `PKCS#1` format
```bash
    fi
    keytool -genkeypair -keyalg DSA -alias testnode_dsa -keystore testnode.jks -storepass testnode \
OpenSSL Configuration File is `openssl_config.cnf`.
file, they certificate and private key must be combined in a PKCS12
    openssl pkcs12 -in dsa.p12 -nodes -nocerts | openssl pkcs8 -topk8 -nocrypt -outform pem \
```bash
    openssl rsa -aes128 -in testnode-unprotected.pem -out testnode-aes128.pem
        -providername BCFIPS \
```
```
    keytool -importkeystore -noprompt \
    # create a new P12 keystore with key + cert
```
```bash
# Generate the keys and self-signed certificates in `nodes/self/` :
            -ext SAN=dns:localhost,dns:localhost.localdomain,dns:localhost4,dns:localhost4.localdomain4,dns:localhost6,dns:localhost6.localdomain6,ip:127.0.0.1,ip:0:0:0:0:0:0:0:1
    openssl ecparam -name secp384r1 -genkey -out private_secp384r1.pem
    openssl pkcs12 -in dsa.p12 -nodes -nocerts | openssl dsa -out dsa_key_openssl_plain.pem
```
```bash
    openssl req -new -x509 -extensions v3_req -out <NAME>.cert -keyout <NAME>.pem -days 1460 -config openssl_config.cnf
            -srcalias testnode_dsa -deststorepass testnode -destkeypass testnode
    openssl req -new -newkey rsa:2048 -keyout n2.c2.key -reqexts SAN -extensions SAN \
    openssl ecparam -name secp521r1 -genkey -out private_secp521r1.pem
        exit 1
            -keypass testnode -validity 10000 -keysize 2048 -dname "CN=OpenSearch Test Node" \
        -deststorepass "$STORE_PW" \
# Generate encrypted keys with `PBKDF2` standard
    fi
export STORE_PW='testnode'
    openssl rsa -in testnode.pem -out testnode-unprotected.pem
    openssl pkcs12 -in dsa.p12 -nodes -nocerts | openssl dsa -des3 -out dsa_key_openssl_encrypted.pem
```bash
        echo "An error occurred while migrating to JKS for $key_file"
in `PKCS#1`
    openssl x509 -req -in n2.c2.csr -extensions SAN -CA ca.crt -CAkey ca.key -CAcreateserial \
certificate.
```bash
```bash
            -ext SAN=dns:localhost,dns:localhost.localdomain,dns:localhost4,dns:localhost4.localdomain4,dns:localhost6,dns:localhost6.localdomain6,ip:127.0.0.1,ip:0:0:0:0:0:0:0:1
    openssl req -newkey rsa:2048 -keyout n1.c1.key -x509 -days 3650 -subj "/CN=n1.c1" -reqexts SAN \
    openssl pkcs12 -export -name <NAME> -in <NAME>.cert -inkey <NAME>.pem -out <NAME>.p12
    keytool -importkeystore -srckeystore testnode.jks -destkeystore ec.p12 -deststoretype PKCS12 \
           -extfile <(cat /etc/ssl/openssl.cnf <(printf "[SAN]\nsubjectAltName=otherName.1:2.5.4.3;UTF8:node2.cluster2"))\
```bash
# Generate Certificates signed with our CA for testing
```bash
# Create a `CA` keypair for testing
certificate. This is necessary for testing with hostname verification
```
for key_file in key*pbkdf2.pem; do
```
Because we intend to import these certificates into a Java Keystore
## Changes and additions for removing Bouncy Castle Dependency
```
        -provider org.bouncycastle.jcajce.provider.BouncyCastleFipsProvider \
```
done
        -srcstorepass "$STORE_PW" \
        -destkeystore testnode.jks \
following openssl configuration and commands.
# Export the `DSA` and `EC` private keys from `JKS` to `PKCS#12`
        -deststoretype BCFKS \
        echo "An error occurred while generating cert for $key_file"
            -out ec_key_pkcs8_encrypted.pem
doing so make sure to specify an alias so that others can recreate the
named accordingly:
        -srcstoretype PKCS12 \
    if [ $? -ne 0 ]; then
    openssl req -x509 -extensions v3_req -key private_secp384r1.pem -out certificate_secp384r1.pem -days 1460 -config openssl_config.cnf
    openssl genrsa -out key-temp.pem 2048
```bash
```
    algo=$(echo "$key_file" | sed -n 's/key_\(.*\)_enc_pbkdf2.pem/\1/p')
export KEY_PW='6!6428DQXwPpi7@$ggeg/='
           -out n2.c2.crt -days 10000
    openssl rsa -aes256 -in testnode-unprotected.pem -out testnode-aes256.pem
The keystore is now created and has the private/public key pair. You can
# Creating the Keystore
of the tests here, the following curves were used to generate ec keys
    ssh-keygen -t ed25519 -f key_unsupported.pem
        echo "Error: Failed to extract algorithm from filename: $key_file" >&2
    openssl pkcs12 -in ec.p12 -nodes -nocerts | openssl pkcs8 -topk8 -outform pem \
    openssl pkcs8 -topk8 -inform PEM -outform PEM -in testnode-unprotected.pem -out rsa_key_pkcs8_plain.pem -nocrypt
    fi
             -out n2.c2.csr
        exit 1
## RSA PKCS#8
```
```
# Generate EC keys using various curves for testing
import additional trusted certificates using `keytool -importcert`. When
```bash
keystore if necessary.
`testnode-unprotected.pem` is simply the decrypted `testnode.pem`
        -deststorepass "$STORE_PW"
```bash
        -providerpath $LIB_PATH/bc-fips-2.0.0.jar
        -deststoretype JKS \
    openssl pkcs12 -export -inkey "$key_file" -in ca_temp.pem -name "testnode_${algo}_pbkdf2" -out testnode.p12 \
`rsa_key_pkcs8_plain.pem` is the same plaintext key encoded in `PKCS#8`
        -passin pass:"$KEY_PW" \
    openssl req -x509 -extensions v3_req -key private_secp521r1.pem -out certificate_secp521r1.pem -days 1460 -config openssl_config.cnf
    openssl req -x509 -key "$key_file" -sha256 -days 3650 -subj "/CN=OpenSearch Test Node" -passin pass:"$KEY_PW" \
