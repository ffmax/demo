package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 71518 on 2019/6/1.
 * some usual usage in regular expression
 * 1. . represents any char except \n
 * 2. Matcher class has concept of region,  the region is the part of the
 * input sequence that will be searched to find a match.
 *
 */
public class ExtractMatchString {
    //Pattern is thread safe
    public static Pattern CHINESE_TEXT_PATTERN = Pattern.compile("^[\\u4e00-\\u9fa5]{0,}$");

    public static Pattern GREEDY_PATTERN = Pattern.compile("[abc]{1,3}");
    public static Pattern LAZY_PATTERN = Pattern.compile("[abc]{1,3}?");

    public static Pattern EXCLUSIVE_PATTERN = Pattern.compile("[abc]{1,3}+");


    public static void main(String[] args) {

//        System.out.println(ExtractMatchString.extractMatchStr("中国",CHINESE_TEXT_PATTERN));
        System.out.println(ExtractMatchString.extractfromBeginMatch("abd", GREEDY_PATTERN));
        System.out.println(ExtractMatchString.extractfromBeginMatch("abd", LAZY_PATTERN));
        System.out.println(ExtractMatchString.extractfromBeginMatch("abd", EXCLUSIVE_PATTERN));

    }

    //attempt to match the entire region against the pattern
    public static String extractCompleteMatchStr(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()) {
            return matcher.group(0);
        }
        return null;
    }

    //attempt to match the input sequence, starting at the beginning of the region against pattern
    public static String extractfromBeginMatch(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.lookingAt()) {
            return matcher.group(0);
        }
        return null;
    }

    //attempt to match next subsequence of the input sequence that matches
    public static String extractNextMatch(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group(0);
        }
        return null;
    }


}
