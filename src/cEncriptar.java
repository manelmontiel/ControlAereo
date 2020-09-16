import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class cEncriptar {
	public static String cifrar(String s) throws UnsupportedEncodingException {
        return Base64.getEncoder().encodeToString(s.getBytes("utf-8"));
    }

    public static String descifrar(String s) throws UnsupportedEncodingException {
        byte[] decode = Base64.getDecoder().decode(s.getBytes());
        return new String(decode, "utf-8");

    }
}
