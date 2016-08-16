package org.geilove.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class TweetHandle {
	
	public static void main(String[] args) {
		String str="sss";
		str="qqqq";
		System.out.print(str);		
	}
	public String tweetAddAt(String strMsg){//这里的参数是字符串数组
		Character ch=strMsg.charAt(0);
		Pattern p=Pattern.compile("^(?!_)(?!.*?_$)[a-zA-Z0-9_]+$"); //只有字母、数字和下划线且不能以下划线开头和结尾的正则表达式
		String[] strMsgArray=strMsg.split("@");
		if(ch.equals('@')){ //当直接处理，'@'分割后的数组时，如果字符串首字母没有@，会被默认加上
			for(int i=0;i<strMsgArray.length;i++){ 
				if(strMsgArray[i].length()>3){//如果长度大于3，符合昵称的长度要求
					String msgcontent=new String(strMsgArray[i]);					
					//这里用正则表达式匹配每个字串，如有符合的加上超链接，放入strMsgArrayWithLink数组。
					for(int j=0;j<strMsgArray[i].length();j++){
						StringBuffer strb=new StringBuffer();
						Character charj=msgcontent.charAt(j); //获得指定位置的字符
						strb.append(charj);//要一个个的加入，然后看看是不是匹配或者是否超出了最大的允许长度
						Matcher m=p.matcher(strb); //用之前创建的正则表达式匹配。
						if(!m.matches()||strb.length()>16){// 出现不匹配时，返回0，取反为真。昵称大于等于4小于16
							strb.deleteCharAt(j);//删掉这个不匹配的
							//加入超链接<a href="localhost:8080/glove/user/strb">@strb</a>	
							String strTostr=strb.toString();//转变为String，能使用"+"
							String strWithLink="<a href="+"http://localhost:8080/glove/user"+strTostr+">"+"@"+strTostr+"</a>";//要加上剩余的
							//strb.insert(0, "<a href='http://localhost:8080/glove/'").append(strb).append('>').append('@').append(strb).append("</a>"); 
							//String shengxiaStr=strMsgArray[i].substring(j, strMsgArray[i].length());
							//strb.append(shangxiaStr);																	
						}//if-in						
					}//for-in			
				}//if-middle
		  }//for-out		
		}//if-out
		return strMsg;
	}//tweetAddAt
}
	







