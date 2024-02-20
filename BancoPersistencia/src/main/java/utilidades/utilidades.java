
package utilidades;

import java.security.*;
import java.util.Base64;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Jesús Pedro Lares Valencia - 00000233383
 */
public class utilidades {
    private static final String ALGORITHM = "AES";
    private static final String SECRET_KEY = "x"; // Cambia esto a tu clave secreta

    public static String encriptar(String contra) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] encryptedBytes = cipher.doFinal(contra.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String desencriptar(String contraEncriptada) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(contraEncriptada));
        return new String(decryptedBytes);
    }
}
