package com.zwahlen.catfeeder.controller;

import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

public class FeederController {

    private boolean testFlag = false;
    final GpioController gpio = GpioFactory.getInstance();

    final GpioPinDigitalOutput testPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00);

    final GpioPinDigitalInput inPin = gpio.provisionDigitalInputPin(RaspiPin.GPIO_01);

    public void start()
    {
        System.out.println("Adding listener");


        inPin.addListener(new GpioPinListenerDigital() {
            @Override
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {

                PinState state = event.getState();

                if (state.isHigh())
                    System.out.println("HIGH");
                else
                    System.out.println("LOW");
            }
        });


        while (true)
        {
            try {
                Thread.sleep(1000);
                System.out.println("Setting: " + testFlag);


                if (testFlag)
                    testPin.high();
                else
                    testPin.low();

                testFlag = !testFlag;


            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    }
}
