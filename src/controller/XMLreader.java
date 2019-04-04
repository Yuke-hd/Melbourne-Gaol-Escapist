package controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
/**
 * 使用dom4j获取xml上的属性信息
 */
import org.dom4j.io.SAXReader;

public class XMLreader {
	public static void iniWall() throws Exception {
		// 1）创建xml解析器
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File("src/res/untitled.xml"));

		/**
		 * 1.1 读取属性 注意： 获取属性，必须先得到属性所在的标签
		 */

		Element conElem = doc.getRootElement().element("layer");
		// 1.1在标签上获取属性(根据属性名获得对应的属性值)
		// String value = conElem.attributeValue("data");
		List<Element> conElem2 = doc.getRootElement().elements("layer");
		
			Element ele = conElem2.get(2).element("data");
			String string = ele.getText();
			System.out.println(string);
			String[] xStrings = string.split(",");
			List<Integer> temp = new ArrayList<Integer>();
			for (int i = 0; i < xStrings.length; i++) {
				//System.out.println(xStrings[i]);
				if ((!xStrings[i].contains("0"))) {
					
					temp.add(i+1);
				}
				
			}
			for (int i = 0; i < temp.size(); i++) {
				System.out.println(temp.get(i));
			}
			GameControl.wall = temp.stream().mapToInt(Integer::intValue).toArray();
		
		

		/**
		 * 1.2 获取id = 002的属性 获取名字相同的contact标签中的 第二个标签
		 */ // 因为elements返回的是list 放进去之后是Object
		// Element conELem2 = (Element) doc.getRootElement().elements().get(1); //
		// 下标从0开始的

		/**
		 * 1.3 根据属性名获取属性对象
		 */
		// 拿到标签对象
		// conElem = doc.getRootElement().element("layer");
		// 拿到属性对象
		// Attribute idAttr = conElem.attribute("data");
		// 通过属性对象拿到属性名
		// String idName = idAttr.getName();
		// 通过属性对象拿到属性值
		// String idValue = idAttr.getValue();
		// System.out.println(idName + "=" + idValue);

		/**
		 * 1.4 获取标签的所有属性 指一个标签中的多个属性值： 例如： <contact id="001" name="eric">
		 */
//		conElem = doc.getRootElement().element("data");
//		
//		List<Attribute> attrList = conElem.attributes();
//		for(Attribute attribute : attrList) {
//			System.out.println(attribute.getName()+" = "+attribute.getValue());
//		}
	}
}
