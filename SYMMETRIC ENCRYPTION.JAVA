import java.io.*;
import java.util.*;
import java.io.Unsupported Encodig Exception; import java.security.Message Digest;
import java.security.No Such Algorithm Exception;
import java.util.Arrays;
import org.ow2.util.base64.Base64; import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec; @author Administrator
public class Symmetric Encryption { private static SecretKeySpec secretKey; private static
byte[] key;
public static void setKey(String myKey) { MessageDigest sha = null;
try {
key = myKey.getBytes("UTF-8");
sha = MessageDigest.getInstance("SHA-1"); key = sha.digest(key);
key = Arrays.copyOf(key, 16);
secretKey = new SecretKeySpec(key, "AES");
} catch (No Such Algorithm Exception e) { e.printStackTrace();
} catch (Unsupported Encoding Exception e) { e.printStackTrace();
}
}
public static String encrypt(String strToEncrypt, String secret) { try {
setKey(secret);
Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
cipher.init(Cipher.ENCRYPT_MODE, secretKey);
//return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes ("UTF
-8")));
String String(Base64.encode(cipher.doFinal(strToEncrypt.getBytes("UTF- 8"))));
return s;
} catch (Exception e)
{
System.out.println("Error while encrypting: " + e.toString()); return null;
}
public static String decrypt(String strToDecrypt, String secret) { try {
setKey(secret);
Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
cipher.init(Cipher.DECRYPT_MODE, secretKey);
//return String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt))); return
String(cipher.doFinal(Base64.decode(strToDecrypt.toCharArray())));
} catch (Exception e) {
System.out.println("Error while decrypting: " + e.toString());
}
return null;
}
