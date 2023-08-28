package com.web.springbootweb.other.xmlreader;

import com.web.springbootweb.other.proxylearn.Dog;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.xml.parsers.SAXParser;
import javax.xml.transform.sax.SAXResult;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: ywz
 * @time: 2023/8/28 11:37
 */
public class XmlReader {

    private static Map<String,Object> map = new HashMap<>();

    static {
        //可以把下面加载beans.xml文件的代码放到静态代码块里面,这样,类加载的时候就会读取beans.xml获取bean,放到map里面
    }

    public static void main(String[] args) {
        InputStream resourceAsStream = XmlReader.class.getClassLoader().getResourceAsStream("beans.xml");

        SAXReader saxReader = new SAXReader();

        try {
            //加载全部bean
            Document document = saxReader.read(resourceAsStream);
            Element rootElement = document.getRootElement();
            List<Element> beanList  = rootElement.selectNodes("//bean");

            for (Element element : beanList){
                String id = element.attributeValue("id");
                String clazz = element.attributeValue("class");
                Class<?> aClass = Class.forName(clazz);
                Object o = aClass.newInstance();
                map.put(id,o);
            }

            Set<String> strings = map.keySet();

            //设置bean的属性
            List<Element> propertyList = rootElement.selectNodes("//property");
            for (Element element : propertyList){

                String name = element.attributeValue("name");
                String ref = element.attributeValue("ref");

                Element parent = element.getParent();

                String parentId = parent.attributeValue("id");

                Object parentObject = map.get(parentId);

                Method[] methods = parentObject.getClass().getMethods();

                for (Method method : methods){

                    if (method.getName().equalsIgnoreCase("set"+name)){
                        method.invoke(parentObject,map.get(ref));
                    }
                }

                map.put(parentId,parentObject);

                Person person;
                Dog dog = new Dog();

                Set<String> keySet = map.keySet();
                for (String id : keySet){
                    Object o = map.get(id);
                    if (o instanceof Person){
                        person = (Person) o;
                    }

                    if (o instanceof Dog){
                        dog = (Dog) o;
                        dog.setName("小黄");
                    }

                }

                dog.say();


            }

        } catch (DocumentException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

    }
}
