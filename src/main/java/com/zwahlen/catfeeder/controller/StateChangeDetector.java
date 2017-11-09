package com.zwahlen.catfeeder.controller;

import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

import java.util.concurrent.Executor;

public class StateChangeDetector implements GpioPinListenerDigital {

    private long lastTime = 0;

    @Override
    public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {



        long thisTime = System.currentTimeMillis();
        if (thisTime-lastTime > 100 )

        lastTime = System.currentTimeMillis();

    }
}
