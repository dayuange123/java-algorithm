package test;

/**
 * Author: liuzhiyuan
 * Date: 2022/3/29
 * Description:
 */
public class IsAlienSorted {


	public static void main(String[] args) {
		//[]
		//""
		new IsAlienSorted().isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz");
	}

	/**
	 * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
	 * <p>
	 * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
	 * <p>
	 *  
	 * <p>
	 * 示例 1：
	 * <p>
	 * 输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
	 * 输出：true
	 * 解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。
	 * 示例 2：
	 * <p>
	 * 输入：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
	 * 输出：false
	 * 解释：在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]，因此单词序列不是按字典序排列的。
	 * <p>
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/lwyVBB
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 *
	 * @param words
	 * @param order
	 * @return
	 */
	public boolean isAlienSorted(String[] words, String order) {


		int[] orderArray = new int[26];
		char[] chars = order.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			orderArray[chars[i] - 'a'] = i;
		}

		for (int i = 1; i < words.length; i++) {

			String pre = words[i - 1];
			for (int j = 0; j < Math.max(pre.length(), words[i].length()); j++) {
				if (j >= pre.length()) {
					break;
				}
				if (j >= words[i].length()) {
					return false;
				}
				if (orderArray[pre.charAt(j) - 'a'] < orderArray[words[i].charAt(j) - 'a']) {
					break;
				} else if (orderArray[pre.charAt(j) - 'a'] > orderArray[words[i].charAt(j) - 'a']) {
					return false;
				}

			}
		}
		return true;

	}

}
