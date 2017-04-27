package textutil;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextUtil {
    /**
     * 判断字符串是否为空
     *
     * @param text
     * @return
     */
    public static boolean isNull(String text) {
        if (text == null)
            return true;
        else if (text.trim().equals(""))
            return true;
        else if (text.trim().equals("null"))
            return true;
        else
            return false;
    }

    /**
     * 判断字符串是否为数字字符串
     *
     * @param text
     * @return
     */
    public static boolean isNumber(String text) {
        if (isNull(text)) {
            return false;
        }

        text = text.trim();
        String str = "^[0-9]*$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(text);
        return m.matches();
    }

    /**
     * 判断是否正确的手机号
     *
     * @param mobiles 号码
     */
    public static boolean isMobileNumber(String mobiles) {
        if (mobiles != null && mobiles.length() != 11) {
            return false;
        }
//        Pattern p = Pattern
//                .compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
//        Matcher m = p.matcher(mobiles);
        return true;

    }


    /**
     * 判断是否正确的密码长度
     *
     * @param pwd 密码
     */
    public static boolean isPassword(String pwd) {
        if (pwd != null && (pwd.length() < 17 && pwd.length() > 5)) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * 将字符串转成MD5值
     *
     * @param string
     * @return
     */
    public static String stringToMD5(String string) {
        try {
            MessageDigest bmd5 = MessageDigest.getInstance("MD5");
            bmd5.update(string.getBytes());
            int i;
            StringBuffer buf = new StringBuffer();
            byte[] b = bmd5.digest();
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            return buf.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 检测是否是email地址
     *
     * @param email
     * @return
     */
    public static boolean isEmail(String email) {
        String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);


        return m.matches();
    }

    /**
     * 半角转换为全角
     *
     * @param input
     * @return
     */
    public static String ToDBC(String input) {
        char[] c = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 12288) {
                c[i] = (char) 32;
                continue;
            }
            if (c[i] > 65280 && c[i] < 65375)
                c[i] = (char) (c[i] - 65248);
        }
        return new String(c);
    }

    public static String desensitize(String content, int start, int length) {
        if (TextUtils.isEmpty(content) || start + length >= content.length()) {
            return content;
        }
        StringBuilder sb = new StringBuilder(content.substring(0, start));
        for (int i = 0; i < length; i++) {
            sb.append(" *");
        }
        sb.append(content.substring(start + length, content.length()));
        return sb.toString();
    }
    public Bitmap aa(String base64){
        byte[] bytes = Base64.decode(base64, Base64.URL_SAFE);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 8;

        return BitmapFactory.decodeByteArray(bytes,0,bytes.length,options);
    }
}
