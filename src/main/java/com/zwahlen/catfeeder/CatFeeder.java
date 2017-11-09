package com.zwahlen.catfeeder;

import com.zwahlen.catfeeder.controller.FeederController;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class CatFeeder {

    public static void main(String[] args) {

        try (FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("Beans.xml"))
        {
            FeederController controller = (FeederController) context.getBean("feederController");
            controller.start();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
