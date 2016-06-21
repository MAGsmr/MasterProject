package modeling;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: ange0814
 * Date: 13.04.2016
 * Time: 13:33
 */
public class FileFilterUtils {
    public final static String jpeg = "jpeg";
    public final static String jpg = "jpg";

    /*
     * Get the extension of a file.
     */
    public static String getExtension(File f){
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }
}
