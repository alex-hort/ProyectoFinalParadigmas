package gui;

import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XMLPersistence {
    public void saveMenuToXML(String fileName, ArrayList<FoodItem> menu) {
        try {
            JAXBContext context = JAXBContext.newInstance(FoodItem.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(menu, new File(fileName));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<FoodItem> loadMenuFromXML(String fileName) {
        try {
            JAXBContext context = JAXBContext.newInstance(FoodItem.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            ArrayList<FoodItem> menu = (ArrayList<FoodItem>) unmarshaller.unmarshal(new File(fileName));
            return menu;
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }
}

