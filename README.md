# WebScraping_v_1.0
java网站爬虫v1.0
<br/>
可以爬取笔趣读网站上的小说，输出为txt文本（自定义路径）
<br/>
注意事项：
1.仅限于爬取笔趣读网站上的小说http://www.biqudu.com/
2.用户接口在UserInterface这个类中，可输入开始网址，结束网址，txt文本保存的地址（注意转义）
3.笔趣读网站上小说网址格式：http://www.biqudu.com/0_32/1003694.html ，同一小说的网址通常是连续的（url最后一个数字递增），但不排除特殊情况。
4.如果不能使用，可能是jar包未导入

```
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
```
<br/>
下个版本更新：
1.用户接口处输入网址改成小说的章节列表地址，比如http://www.biqudu.com/0_32/ ，从其中爬取跳转的url
2.优化字符串解析xiaol
