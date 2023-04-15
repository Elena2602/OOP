package semm7.adapter;

import java.time.LocalDateTime;

/**
 * Интерфейс метеодатчика
 */
public interface MeteoSensor {

    int getId();

    double getTemperature();

    double getHumidity();

    double getPressure();

    LocalDateTime getDateTime();

}
