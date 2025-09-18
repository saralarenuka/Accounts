package com.javaexpress.accounts.config;

import feign.micrometer.MicrometerCapability;
import io.micrometer.core.instrument.MeterRegistry;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class MicrometerConfigTest {

    @Test
    void testMicrometerCapabilityBeanCreation() {
        MeterRegistry mockRegistry = Mockito.mock(MeterRegistry.class);
        MicrometerConfig config = new MicrometerConfig();

        MicrometerCapability capability = config.capability(mockRegistry);

        assertNotNull(capability);
    }
}
