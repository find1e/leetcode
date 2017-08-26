/**
 * 
 */
package common;

import java.util.Collection;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * @author fubaokui
 * @date   2017年4月15日 下午11:05:21
 */
public class StringUtil {
	
	public static String printCollection(Collection source ,String split){
		StringBuilder builder = new StringBuilder();
		for(Object obj : source){
			builder.append(obj.toString()).append(split);
		}
		return builder.toString();
	}

	
	public static String hashArray(Object[] objects){
		TreeMap<Object,Integer> treeMap = new TreeMap<>();
		for(Object str : objects){
			Integer count = treeMap.get(str);
			if(count == null){
				treeMap.put(str, 1);
			}else{
				treeMap.put(str, count+1);
			}
		}
		StringBuilder stringBuilder = new StringBuilder();
		for(Entry<Object,Integer> entry : treeMap.entrySet()){
			stringBuilder.append(entry.getKey()).append(entry.getValue().toString());
		}
		return stringBuilder.toString();
	}
	
}
