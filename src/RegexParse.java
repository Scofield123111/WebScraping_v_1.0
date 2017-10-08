import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RegexParse {

    static String parseString(String arg) {
        String beginStringRegex = "<div id=\"content\"><script>readx\\(\\);</script>";
        String endStringRegex = "</div>";

        Pattern p = Pattern.compile(beginStringRegex + ".+" + endStringRegex);
        Matcher m = p.matcher(arg);
        String content = "";
        while (m.find()) {
            content = arg.substring(m.start() + beginStringRegex.length() - 1, m.end() - endStringRegex.length());
        }
        Pattern p1 = Pattern.compile("<br/>");
        Matcher m1 = p1.matcher(content);
        content = m1.replaceAll("\r\n");

        Pattern p2 = Pattern.compile("&nbsp;");
        Matcher m2 = p2.matcher(content);
        content = m2.replaceAll(" ");

        return content;
    }

}
