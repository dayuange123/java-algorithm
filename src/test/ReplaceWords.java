package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReplaceWords {


	/**
	 * 在英语中，有一个叫做 词根(root) 的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
	 * <p>
	 * 现在，给定一个由许多词根组成的词典和一个句子，需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
	 * <p>
	 * 需要输出替换之后的句子。
	 * <p>
	 *  
	 * <p>
	 * 示例 1：
	 * <p>
	 * 输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
	 * 输出："the cat was rat by the bat"
	 * 示例 2：
	 * <p>
	 * 输入：dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
	 * 输出："a a b c"
	 * 示例 3：
	 * <p>
	 * 输入：dictionary = ["a", "aa", "aaa", "aaaa"], sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"
	 * 输出："a a a a a a a a bbb baba a"
	 * 示例 4：
	 * <p>
	 * 输入：dictionary = ["catt","cat","bat","rat"], sentence = "the cattle was rattled by the battery"
	 * 输出："the cat was rat by the bat"
	 * 示例 5：
	 * <p>
	 * 输入：dictionary = ["ac","ab"], sentence = "it is abnormal that this solution is accepted"
	 * 输出："it is ab that this solution is ac"
	 * <p>
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode.cn/problems/UhWRSj
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 *
	 * @param dictionary 字典
	 * @param sentence   句子
	 * @return {@code String }
	 * @author liuzhiyuan
	 */
	public String replaceWords(List<String> dictionary, String sentence) {

		//找出最短的替换
		String[] allWords = sentence.split(" ");
		Tree head = new Tree();
		for (String s : dictionary) {
			Tree cur = head;
			char[] chars = s.toCharArray();
			for (char aChar : chars) {
				Map<Character, Tree> treeMap = cur.nextMap;
				cur = treeMap.get(aChar);
				//第一次
				if (cur == null) {
					cur = new Tree();
					treeMap.put(aChar, cur);
				}else if (cur.str != null) {
					break;
				}
			}
			if (cur.str==null){
				cur.str = s;
			}
		}
		StringBuilder result = new StringBuilder();

		for (String allWord : allWords) {
			Map<Character, Tree> last = head.getNextMap();
			char[] chars = allWord.toCharArray();
			for (int i = 0; i < chars.length; i++) {
				Tree tree = last.get(chars[i]);
				if (tree == null || i == allWord.length() - 1) {
					result.append(allWord);
					break;
				}
				if (tree.str != null) {
					result.append(tree.str);
					break;
				}
				last = tree.nextMap;
			}
			result.append(" ");
		}
		return result.substring(0, result.length() - 1);
	}


	public class Tree {
		private String str;
		private Map<Character, Tree> nextMap = new HashMap<>();

		public Map<Character, Tree> getNextMap() {
			return nextMap;
		}
	}
}
