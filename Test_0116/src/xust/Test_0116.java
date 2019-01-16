/**
 * date��2019/01/16
 * author:BetterMe1
 * program:leetcode:����ת��������������ת����
 * compiler:jdk1.7.0_51
 */

package xust;

import java.util.Scanner;

/*
 �������ְ������������ַ��� I�� V�� X�� L��C��D �� M��
�ַ�          ��ֵ
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
���磬 �������� 2 д�� II ����Ϊ�������е� 1��12 д�� XII ����Ϊ X + II �� 27 д��  XXVII, ��Ϊ XX + V + II ��
ͨ������£�����������С�������ڴ�����ֵ��ұߡ���Ҳ�������������� 4 ��д�� IIII������ IV������ 1 ������ 5 ����ߣ�����ʾ�������ڴ��� 5 ��С�� 1 �õ�����ֵ 4 ��ͬ���أ����� 9 ��ʾΪ IX���������Ĺ���ֻ�������������������
I ���Է��� V (5) �� X (10) ����ߣ�����ʾ 4 �� 9��
X ���Է��� L (50) �� C (100) ����ߣ�����ʾ 40 �� 90�� 
C ���Է��� D (500) �� M (1000) ����ߣ�����ʾ 400 �� 900��
����һ������������תΪ�������֡�����ȷ���� 1 �� 3999 �ķ�Χ�ڡ�
����һ���������֣�����תΪ����������ȷ���� 1 �� 3999 �ķ�Χ�ڡ�
ʾ�� 1:
����: 3
���: "III"

ʾ�� 2:
����: 4
���: "IV"

ʾ�� 3:
����: 9
���: "IX"

ʾ�� 4:
����: 58
���: "LVIII"
����: L = 50, V = 5, III = 3.

ʾ�� 5:
����: 1994
���: "MCMXCIV"
����: M = 1000, CM = 900, XC = 90, IV = 4.
 */


public class Test_0116 {
	public static void main(String[] args){
		System.out.println("����������(1-3999)��");
		Scanner sc1=new Scanner(System.in);
		int num =sc1.nextInt();
		Solution1 So1=new Solution1();
		if(num>0 && num<4000){
			String ret=So1.intToRoman(num);
			System.out.println("��������:"+ret);
		}
		System.out.println("��������������(1-3999)��");
		Scanner sc2=new Scanner(System.in);
		String s =sc2.nextLine();
		Solution2 So2=new Solution2();
		int ret=So2.romanToInt(s);
		if(ret>0 && ret<4000){
			System.out.println("����:"+ret);
		}
	}
}
/*
 * ����һ������������תΪ�������֡�����ȷ���� 1 �� 3999 �ķ�Χ�ڡ�
 * �㷨˼�룺���������ֱ�ʾ��������ʾ��Ӧд�����������У��ֱ�Ϊvalues��Roman_values��
 * �����������values�е�ֵһһ�Ƚϣ����������ʱ���ڴ�������м�ȥ���������ڷ��ص��ַ������ö�Ӧ�������ֱ�ʾ��ֱ������������ֱ�ʾ����
 */
class Solution1 {
    public String intToRoman(int num) {
    	if(num>0 && num<4000){
    	int[] values={1000,900,500,400,100,90,50,40,10,9,5,4,1};
    	String[] Roman_values={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    	String ret = "";
    	for(int i=0;i<13;i++){//���鳤��Ϊ12
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
 * ����һ���������֣�����תΪ����������ȷ���� 1 �� 3999 �ķ�Χ�ڡ�
 * �㷨˼��:����������������֣���������ַ����ӱ�ʾ���ַ�������Roman_values����һ�������ڷ���ֵret�м��϶�Ӧ��values�е�ֵ��
 * ������ǣ����ж�һ���ַ���ʾ���ַ�������Roman_values����һ���������ڷ���ֵret�м��϶�Ӧ��values�е�ֵ��
 * ����Ҫ�ж������ַ����ӱ�ʾ���ַ�������˳���ҪС���ַ�������-1��������ж����һλ���ɡ�
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
