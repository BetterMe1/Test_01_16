/**
 * date：2019/01/16
 * author:BetterMe1
 * program:leetcode:整数转罗马数、罗马数转整数
 * compiler:jdk1.7.0_51
 */

package xust;

import java.util.Scanner;

/*
 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
给定一个罗马数字，将其转为整数。输入确保在 1 到 3999 的范围内。
示例 1:
输入: 3
输出: "III"

示例 2:
输入: 4
输出: "IV"

示例 3:
输入: 9
输出: "IX"

示例 4:
输入: 58
输出: "LVIII"
解释: L = 50, V = 5, III = 3.

示例 5:
输入: 1994
输出: "MCMXCIV"
解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */


public class Test_0116 {
	public static void main(String[] args){
		System.out.println("请输入整数(1-3999)：");
		Scanner sc1=new Scanner(System.in);
		int num =sc1.nextInt();
		Solution1 So1=new Solution1();
		if(num>0 && num<4000){
			String ret=So1.intToRoman(num);
			System.out.println("罗马数字:"+ret);
		}
		System.out.println("请输入罗马数字(1-3999)：");
		Scanner sc2=new Scanner(System.in);
		String s =sc2.nextLine();
		Solution2 So2=new Solution2();
		int ret=So2.romanToInt(s);
		if(ret>0 && ret<4000){
			System.out.println("整数:"+ret);
		}
	}
}
/*
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 * 算法思想：将罗马数字表示和整数表示对应写在两个数组中，分别为values、Roman_values，
 * 将传入的数与values中的值一一比较，大于这个数时，在传入的数中减去此数，并在返回的字符串中用对应罗马数字表示，直到将传入的数字表示出来
 */
class Solution1 {
    public String intToRoman(int num) {
    	if(num>0 && num<4000){
    	int[] values={1000,900,500,400,100,90,50,40,10,9,5,4,1};
    	String[] Roman_values={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    	String ret = "";
    	for(int i=0;i<13;i++){//数组长度为12
    		while(num >= values[i]){
    			num=num-values[i];
    			ret=ret+Roman_values[i];
    		}
    	}
    	return ret;
    	}
    	return null;
    }
}
/*
 * 给定一个罗马数字，将其转为整数。输入确保在 1 到 3999 的范围内。
 * 算法思想:遍历输入的罗马数字，如果两个字符连接表示的字符串等于Roman_values其中一个，则在返回值ret中加上对应的values中的值，
 * 如果不是，再判断一个字符表示的字符串等于Roman_values其中一个，是则在返回值ret中加上对应的values中的值，
 * 由于要判断两个字符连接表示的字符串，因此长度要小于字符串长度-1，最后再判断最后一位即可。
 */
class Solution2 {
    public int romanToInt(String s) {
    		int[] values={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        	String [] Roman_values={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        	int ret=0;
        	int j=0;
        	while(j<s.length()-1){
        		for(int i=0;i<13;i++){
        			if(((s.charAt(j)+"")+(s.charAt(j+1)+"")).equals(Roman_values[i])){
            			ret+=values[i];
            			j+=2;
            			break;
            		}
            		 if(String.valueOf(s.charAt(j)).equals(Roman_values[i])){
            			ret+=values[i];
            			j+=1;
            			break;
            		}	
        		}
            }
        	if(j!=s.length()){
        		for(int i=0;i<13;i++){
        			if(String.valueOf(s.charAt(j)).equals(Roman_values[i])){
        				ret+=values[i];
        				break;
        			}
        		}
        	}
        	if(ret>0 && ret<4000){
        		return ret;
        	}
        	return -1;	
    } 
}
