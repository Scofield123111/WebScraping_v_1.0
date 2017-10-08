public class UserInterface {
    public static void main(String[] args) {
        /* 小说第一章的网址 */
        String beginUrl = "http://www.biqudu.com/0_32/1003682.html";
        /* 小说最后一章的网址 */
        String endUrl = "http://www.biqudu.com/0_32/1003694.html";
        /* 要保存的文件路径 */
        String filePath = "//Users//scott//Downloads//全职高手.txt";
        new WebScraping().run(beginUrl, endUrl, filePath);
    }
}
