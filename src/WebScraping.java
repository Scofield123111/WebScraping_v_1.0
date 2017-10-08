import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class WebScraping {

    /**
     * 根据beginUrl&endUrl生成url数组
     */
    private static String[] buildUrls(String beginUrl, String endUrl) {
        Pattern p = Pattern.compile("/\\d+.html");
        Matcher m = p.matcher(beginUrl);

        int startNum = 0, endNum = 0;
        int index = 0;

        while (m.find()) {
            index = m.start() + 1;
            startNum = Integer.valueOf(beginUrl.substring(m.start() + 1, m.end() - 5));
        }
        m = p.matcher(endUrl);
        while (m.find()) {
            endNum = Integer.valueOf(endUrl.substring(m.start() + 1, m.end() - 5));

        }

        String prefix = beginUrl.substring(0, index);
        String[] strings = new String[endNum - startNum + 1];
        for (int i = 0; i < endNum - startNum + 1; i++) {
            strings[i] = prefix + (i + startNum) + ".html";
        }

        return strings;
    }

    void run(String beginUrl, String endUrl, String filePath) {

        BufferedReader in = null;
        URL realUrl = null;
        String[] urls = buildUrls(beginUrl, endUrl);
        StringBuilder result = new StringBuilder();

        int i = 0;
        for (; i < urls.length; i++) {
            try {
                realUrl = new URL(urls[i]);
                URLConnection connection = realUrl.openConnection();
                connection.connect();

                in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                String line;
                StringBuilder sb = new StringBuilder();
                while ((line = in.readLine()) != null) {
                    sb.append(line).append("\n");
                }

                result.append(RegexParse.parseString(sb.toString()));
            } catch (Exception e) {
                i++;
            }
        }

        try {
            if (in != null) {
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();

        }

        System.out.println("源网页编码格式：" + GetResourceEncoding.getUrlEncode(realUrl));

        /* 写入文件 */
        File file = new File(filePath);
        try {
            FileWriter fw = new FileWriter(file);
            fw.write(result.toString());
            fw.flush();
            fw.close();
        } catch (IOException e) {
            System.out.println("文件路径不正确");
        }

        System.out.println("Success！已将txt文本保存到: " + filePath + "  路径下！");

    }
}