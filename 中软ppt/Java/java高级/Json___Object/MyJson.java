package test;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyJson {
	public static String formatToJson(Object obj){
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		try {
			BeanInfo bi = Introspector.getBeanInfo(obj.getClass());
			PropertyDescriptor[] props = bi.getPropertyDescriptors();
			List<String> list = new ArrayList();
			for(PropertyDescriptor p : props){
				String propName = p.getName();
				if(propName.equals("class")){
					continue;
				}
				Object propVal = p.getReadMethod().invoke(obj);
				if(propVal==null){
					continue;
				}
				boolean isStrType = propVal.getClass()==String.class;
				String keyAndValue = "\""+propName+"\":"+(isStrType?"\"":"")+propVal+(isStrType?"\"":"");
				list.add(keyAndValue);
			}
			sb.append(String.join(",", list));
			sb.append("}");
			return sb.toString();
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static Object parseFromJson(String json, Class c){
		try {
			Object instance = c.newInstance();
			String[] str = json.substring(1,json.length()-2).replaceAll("\"", "").split(",");
			Map<String,String> map = new HashMap();
			for(String s : str){
				map.put(s.split(":")[0],s.split(":")[1]);
			}
			BeanInfo bi = Introspector.getBeanInfo(c);
			PropertyDescriptor[] props = bi.getPropertyDescriptors();
			for(PropertyDescriptor p : props){
				String val = map.get(p.getName());
				if(val==null){
					continue;
				}
				Class propType = p.getPropertyType();
				Object v = val;
				if(propType!=String.class){
					v = Integer.parseInt(val);
				}
				p.getWriteMethod().invoke(instance, v);
				
			}
			return instance;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
